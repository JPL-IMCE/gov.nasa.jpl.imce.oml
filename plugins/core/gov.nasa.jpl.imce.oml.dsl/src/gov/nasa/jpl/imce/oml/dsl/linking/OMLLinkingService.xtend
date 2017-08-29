/*
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */
package gov.nasa.jpl.imce.oml.dsl.linking

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.CommonPackage
import gov.nasa.jpl.imce.oml.model.common.Element
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import java.util.Collections
import org.apache.xml.resolver.Catalog
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource.Diagnostic
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope

class OMLLinkingService extends DefaultLinkingService {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter

	override getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		val EClass requiredType = ref.getEReferenceType()
		if (null === requiredType)
			return Collections.<EObject>emptyList()

		val crossRefString = getCrossRefNodeAsString(node)

		if (null === crossRefString || crossRefString.equals(""))
			return Collections.emptyList()

		// Is this an IRI cross-reference?
		if (crossRefString.startsWith("<") && crossRefString.endsWith(">")) {

			// For an IRI cross-reference, find an OASIS XML catalog to resolve the IRI into a local OML file URL, which we need to load into the XtextResourceSet.
			val rs = context.eResource.resourceSet
			if (null === rs)
				return Collections.emptyList()

			val crossRefIRI = crossRefString.substring(1, crossRefString.length - 1)
			val fragmentIndex = crossRefIRI.indexOf('#')

			val refIRI = if(-1 == fragmentIndex) crossRefIRI else crossRefIRI.substring(1, fragmentIndex - 1)
			val resourceIRI = if (refIRI.endsWith('/')) refIRI.substring(0, refIRI.length-1) else refIRI
			
			if (fragmentIndex > 0)
				throw new IllegalNodeException(node,
					"Cross-reference cannot specify a fragment OML Entity: " + crossRefIRI)

			val Catalog catalog = OMLExtensions.findCatalogIfExists(context.eResource)
			if (null === catalog) {
				
				val refType = ref.EType
				switch refType {
					case BundlesPackage.eINSTANCE.bundle: {
						val bundle = rs.resources.map[contents.filter(Extent).map[modules.filter(Bundle)].flatten].
							flatten.findFirst[b|b.iri() == refIRI]
						if (null !== bundle) return Collections.singletonList(bundle)
					}
					case TerminologiesPackage.eINSTANCE.terminologyBox: {
						val tbox = rs.resources.map [
							contents.filter(Extent).map[modules.filter(TerminologyBox)].flatten
						].flatten.findFirst[tbox|tbox.iri() == refIRI]
						if (null !== tbox) return Collections.singletonList(tbox)
					}
					case DescriptionsPackage.eINSTANCE.descriptionBox: {
						val dbox = rs.resources.map [
							contents.filter(Extent).map[modules.filter(DescriptionBox)].flatten
						].flatten.findFirst[dbox|dbox.iri() == refIRI]
						if (null !== dbox) return Collections.singletonList(dbox)
					}
					default:
						{}
				}
				
				throw new IllegalNodeException(node,
					"IRI Cross-reference resolution for " + crossRefString + " requires an " +
						OMLExtensions.OML_CATALOG_XML + " file; but no such catalog file was found!")
			} else {
				val resolvedIRI = catalog.resolveURI(resourceIRI + ".oml")
				if (null === resolvedIRI || resolvedIRI == resourceIRI)
					return Collections.emptyList()

				val resolvedOML = rs.getResource(URI.createURI(resolvedIRI), true)
				val StringBuffer problems = new StringBuffer()
				resolvedOML.errors.forEach [ Diagnostic e |
					switch e {
						org.eclipse.xtext.diagnostics.Diagnostic:
							problems.append(
								"\n" + e.message + " at " + e.location + " line:" + e.line + ", column:" + e.column +
									", offset:" + e.offset + ", length:" + e.length)
						default:
							problems.append(
								"\n" + e.message + " at " + e.location + " line:" + e.line + ", column:" + e.column)
					}
				]
				resolvedOML.warnings.forEach [ Diagnostic e |
					switch e {
						org.eclipse.xtext.diagnostics.Diagnostic:
							problems.append(
								e.message + " at " + e.location + " line:" + e.line + ", column:" + e.column +
									", offset:" + e.offset + ", length:" + e.length)
						default:
							problems.append(
								e.message + " at " + e.location + " line:" + e.line + ", column:" + e.column)
					}
				]
				if (!resolvedOML.errors.empty || !resolvedOML.warnings.empty) {
					throw new IllegalNodeException(
						node,
						"IRI cross reference problems\nCross reference:\n" + 
						crossRefString + 
						"\nResolved IRI:\n" +
						resolvedIRI + 
						"\n" + problems.toString
					)
				}

				val refType = ref.EType
				switch refType {
					case BundlesPackage.eINSTANCE.bundle: {
						val bundle = rs.resources.map[contents.filter(Extent).map[modules.filter(Bundle)].flatten].
							flatten.findFirst[b|b.iri() == refIRI]
						return if(null === bundle) Collections.emptyList() else Collections.singletonList(bundle)
					}
					case TerminologiesPackage.eINSTANCE.terminologyBox: {
						val tbox = rs.resources.map [
							contents.filter(Extent).map[modules.filter(TerminologyBox)].flatten
						].flatten.findFirst[tbox|tbox.iri() == refIRI]
						return if(null === tbox) Collections.emptyList() else Collections.singletonList(tbox)
					}
					case DescriptionsPackage.eINSTANCE.descriptionBox: {
						val dbox = rs.resources.map [
							contents.filter(Extent).map[modules.filter(DescriptionBox)].flatten
						].flatten.findFirst[dbox|dbox.iri() == refIRI]
						return if(null === dbox) Collections.emptyList() else Collections.singletonList(dbox)
					}
					default:
						return Collections.emptyList()
				}
			}
		}

		if (AnnotationPropertyValue.isInstance(context) && ref == CommonPackage.eINSTANCE.annotationPropertyValue_Property) {
			// Look for what the next node is...
			val aContext = AnnotationPropertyValue.cast(context)
			val nextNode = node.parent.nextSibling
			val nextSE = nextNode.leafNodes.head.semanticElement
			switch nextSE {
				Element: {
					// In this case, the concrete syntax looks like this:
					// <Annotation> == context
					// <Element> == nextSE
					aContext.subject = nextSE
				}
				AnnotationPropertyValue: {
					// In this case, the concrete syntax looks like this:
					// <Annotation> == context
					// <Annotation> == nextSE
					// ...
					// <Element>
					// force resolving the next annotation; as a side effect, it will have its subset set.
					val nextLeafNodes = nextNode.leafNodes
					val n1 = nextLeafNodes.findFirst[n|CrossReference.isInstance(n.grammarElement)]
					getLinkedObjects(nextSE, ref, n1)
					aContext.subject = nextSE.subject
				}
			}
		}

		// val defaultResult = super.getLinkedObjects(context, ref, node)
		// return defaultResult
		val IScope scope = getScope(context, ref)
		val QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString)
		val IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedLinkName)

		if (null === eObjectDescription) {
			val defaultResult = super.getLinkedObjects(context, ref, node)
			if (defaultResult !== null && !defaultResult.empty)
				return defaultResult
			else
				return Collections.emptyList()
		}
		val e = eObjectDescription.getEObjectOrProxy()
		return Collections.singletonList(e)
	}

}
