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
import gov.nasa.jpl.imce.oml.dsl.scoping.OMLScopeExtensions
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.CommonPackage
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.common.LogicalElement
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import java.util.Collections
import java.util.HashMap
import java.util.List
import org.apache.xml.resolver.Catalog
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource.Diagnostic
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope

/**
 * OMLLinkingService resolves Xtext cross-references in OML textual models.
 * The implementation of getLinkedObjects(context, ref, node) involves a significant work 
 * to find the intended reference in the scope of possible objects in the context for the given reference property.
 * 
 * The result of this expensive cross-reference linking service can be cached when the resource set will not change
 * (i.e., the contents are effectively read-only). 
 */
class OMLLinkingService extends DefaultLinkingService {

	static val String RESOURCE_SET_READONLY_OML_LINKING_CACHE = "RESOURCE_SET_READONLY_OML_LINKING_CACHE"
	
	static def void clearCache(ResourceSet rs) {
		OMLScopeExtensions.clearCache(rs)
		rs.loadOptions.remove(RESOURCE_SET_READONLY_OML_LINKING_CACHE)
	}
	
	static def void initializeCache(ResourceSet rs) {
		OMLScopeExtensions.initializeCache(rs)
		val cache = new HashMap<EObject, HashMap<EReference, List<EObject>>>()
		val prev = rs.loadOptions.put(RESOURCE_SET_READONLY_OML_LINKING_CACHE, cache)
		if (null !== prev)
			throw new IllegalArgumentException("OMLLinkingService.initializeReadOnlyOMLLinkiCache(): The cache should be initialized only once!")
	}
	
	static def HashMap<EObject, HashMap<EReference, List<EObject>>> lookupReadOnlyOMLLinkingCache(ResourceSet rs) {
		val cache = rs.loadOptions.get(RESOURCE_SET_READONLY_OML_LINKING_CACHE)
		switch cache {
			HashMap<EObject, HashMap<EReference, List<EObject>>>:
				cache
		}
	}
	
	static def HashMap<EObject, HashMap<EReference, List<EObject>>> lookupReadOnlyOMLLinkingCache(EObject context) {
		val rs = context?.eResource?.resourceSet
		if (null !== rs)
			lookupReadOnlyOMLLinkingCache(rs)
		else
			null
	}
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter

	override List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
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

			val resourceIRI = if(-1 == fragmentIndex) crossRefIRI else crossRefIRI.substring(1, fragmentIndex - 1)
			
			if (fragmentIndex > 0)
				throw new IllegalNodeException(node,
					"Cross-reference cannot specify a fragment OML Entity: " + crossRefIRI)

			val Catalog catalog = OMLExtensions.findCatalogIfExists(context.eResource)
			if (null === catalog) {
				
				val refType = ref.EType
				switch refType {
					case BundlesPackage.eINSTANCE.bundle: {
						val bundle = rs.resources.map[contents.filter(Extent).map[modules.filter(Bundle)].flatten].
							flatten.findFirst[b|b.iri() == resourceIRI]
						if (null !== bundle) return Collections.singletonList(bundle)
					}
					case TerminologiesPackage.eINSTANCE.terminologyBox: {
						val tbox = rs.resources.map [
							contents.filter(Extent).map[modules.filter(TerminologyBox)].flatten
						].flatten.findFirst[tbox|tbox.iri() == resourceIRI]
						if (null !== tbox) return Collections.singletonList(tbox)
					}
					case DescriptionsPackage.eINSTANCE.descriptionBox: {
						val dbox = rs.resources.map [
							contents.filter(Extent).map[modules.filter(DescriptionBox)].flatten
						].flatten.findFirst[dbox|dbox.iri() == resourceIRI]
						if (null !== dbox) return Collections.singletonList(dbox)
					}
					default:
						{}
				}
				
				throw new IllegalNodeException(node,
					"IRI Cross-reference resolution for " + crossRefString + " requires an " +
						OMLExtensions.OML_CATALOG_XML + " file; but no such catalog file was found!")
			} else {
				val resolvedIRI = catalog.resolveURI(resourceIRI + ".oml") ?: catalog.resolveURI(resourceIRI + ".omlzip")
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
							flatten.findFirst[b|b.iri() == resolvedIRI || b.iri() == resourceIRI]
						return if(null === bundle) Collections.emptyList() else Collections.singletonList(bundle)
					}
					case TerminologiesPackage.eINSTANCE.terminologyBox: {
						val tbox = rs.resources.map [
							contents.filter(Extent).map[modules.filter(TerminologyBox)].flatten
						].flatten.findFirst[tbox|tbox.iri() == resolvedIRI || tbox.iri() == resourceIRI]
						return if(null === tbox) Collections.emptyList() else Collections.singletonList(tbox)
					}
					case DescriptionsPackage.eINSTANCE.descriptionBox: {
						val dbox = rs.resources.map [
							contents.filter(Extent).map[modules.filter(DescriptionBox)].flatten
						].flatten.findFirst[dbox|dbox.iri() == resolvedIRI || dbox.iri() == resourceIRI]
						return if(null === dbox) Collections.emptyList() else Collections.singletonList(dbox)
					}
					default:
						return Collections.emptyList()
				}
			}
		}

		var HashMap<EReference, List<EObject>> refCache = null
		
		val contextCache = lookupReadOnlyOMLLinkingCache(context)
		if (null !== contextCache) {
			refCache = contextCache.computeIfAbsent(context, [new HashMap<EReference, List<EObject>>()])
			
			val result = refCache.get(ref)
			if (null !== result)
				return result
		}
		
		if (AnnotationPropertyValue.isInstance(context) && ref == CommonPackage.eINSTANCE.annotationPropertyValue_Property) {
			// Look for what the next node is...
			val aContext = AnnotationPropertyValue.cast(context)
			val nextNode = node.parent.nextSibling
			val nextSE = nextNode.leafNodes.head.semanticElement
			switch nextSE {
				LogicalElement: {
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

		val List<EObject> result = if (null === eObjectDescription) {
			val defaultResult = super.getLinkedObjects(context, ref, node)
			if (defaultResult !== null && !defaultResult.empty)
				defaultResult
			else
				Collections.emptyList()
		} else {
			val e = eObjectDescription.getEObjectOrProxy()
			Collections.singletonList(e)
		}
		 
		refCache?.put(ref, result)
		
		result
	}

}
