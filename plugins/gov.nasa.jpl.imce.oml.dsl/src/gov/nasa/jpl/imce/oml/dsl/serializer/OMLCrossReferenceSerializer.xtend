package gov.nasa.jpl.imce.oml.dsl.serializer

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.model.common.Module
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.linking.impl.LinkingHelper
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer

class OMLCrossReferenceSerializer extends CrossReferenceSerializer {
	
	@Inject
	private LinkingHelper linkingHelper;
	
	/*
	 * Caution: check for null before calling: linkingHelper.getCrossRefNodeAsString(node, true)
	 * - node !== null when target comes from creating a model via the Xtext DSL parser
	 * - node === null when target comes from creating a model directly via the DSL metamodel factory API
	 */
	override String serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		val ruleName = linkingHelper.getRuleNameFrom(crossref)
		if ("ExternalReference" == ruleName) {
			switch target {
				Module:
					'<'+target.iri()+'>'
				default:
					throw new IllegalArgumentException(
					"OntologicalModelingLanguageCrossReferenceSerializer.serializeCrossRef(..., 'ExternalReference', target, ...): target must be a Module, not: "+
					(if (null === target) "<null>" else target.eClass.name))
			}
		} else {
			val result = super.serializeCrossRef(semanticObject, crossref, target, node, errors)
			result
		}
	}
	
}