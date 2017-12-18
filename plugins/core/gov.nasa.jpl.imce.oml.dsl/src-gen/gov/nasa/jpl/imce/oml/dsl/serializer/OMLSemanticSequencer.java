/*
 * Copyright 2017 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.dsl.serializer;

import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.services.OMLGrammarAccess;
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LiteralBoolean;
import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime;
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal;
import gov.nasa.jpl.imce.oml.model.common.LiteralFloat;
import gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString;
import gov.nasa.jpl.imce.oml.model.common.LiteralRational;
import gov.nasa.jpl.imce.oml.model.common.LiteralRawString;
import gov.nasa.jpl.imce.oml.model.common.LiteralReal;
import gov.nasa.jpl.imce.oml.model.common.LiteralURI;
import gov.nasa.jpl.imce.oml.model.common.LiteralUUID;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipPropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSourceInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSourcePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipTargetInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipTargetPropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipPropertyPredicate;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class OMLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OMLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BundlesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM:
				sequence_AnonymousConceptUnionAxiom(context, (AnonymousConceptUnionAxiom) semanticObject); 
				return; 
			case BundlesPackage.BUNDLE:
				sequence_Bundle(context, (Bundle) semanticObject); 
				return; 
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM:
				sequence_BundledTerminologyAxiom(context, (BundledTerminologyAxiom) semanticObject); 
				return; 
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM:
				sequence_RootConceptTaxonomyAxiom(context, (RootConceptTaxonomyAxiom) semanticObject); 
				return; 
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM:
				sequence_SpecificDisjointConceptAxiom(context, (SpecificDisjointConceptAxiom) semanticObject); 
				return; 
			}
		else if (epackage == CommonPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case CommonPackage.ANNOTATION_PROPERTY:
				sequence_AnnotationProperty(context, (AnnotationProperty) semanticObject); 
				return; 
			case CommonPackage.ANNOTATION_PROPERTY_VALUE:
				sequence_AnnotationPropertyValue(context, (AnnotationPropertyValue) semanticObject); 
				return; 
			case CommonPackage.EXTENT:
				sequence_Extent(context, (Extent) semanticObject); 
				return; 
			case CommonPackage.LITERAL_BOOLEAN:
				sequence_LiteralBoolean(context, (LiteralBoolean) semanticObject); 
				return; 
			case CommonPackage.LITERAL_DATE_TIME:
				sequence_LiteralDateTime(context, (LiteralDateTime) semanticObject); 
				return; 
			case CommonPackage.LITERAL_DECIMAL:
				sequence_LiteralDecimal(context, (LiteralDecimal) semanticObject); 
				return; 
			case CommonPackage.LITERAL_FLOAT:
				sequence_LiteralFloat(context, (LiteralFloat) semanticObject); 
				return; 
			case CommonPackage.LITERAL_QUOTED_STRING:
				sequence_LiteralQuotedString(context, (LiteralQuotedString) semanticObject); 
				return; 
			case CommonPackage.LITERAL_RATIONAL:
				sequence_LiteralRational(context, (LiteralRational) semanticObject); 
				return; 
			case CommonPackage.LITERAL_RAW_STRING:
				sequence_LiteralRawString(context, (LiteralRawString) semanticObject); 
				return; 
			case CommonPackage.LITERAL_REAL:
				sequence_LiteralReal(context, (LiteralReal) semanticObject); 
				return; 
			case CommonPackage.LITERAL_URI:
				sequence_LiteralURI(context, (LiteralURI) semanticObject); 
				return; 
			case CommonPackage.LITERAL_UUID:
				sequence_LiteralUUID(context, (LiteralUUID) semanticObject); 
				return; 
			}
		else if (epackage == DescriptionsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case DescriptionsPackage.CONCEPT_INSTANCE:
				sequence_ConceptInstance(context, (ConceptInstance) semanticObject); 
				return; 
			case DescriptionsPackage.DESCRIPTION_BOX:
				sequence_DescriptionBox(context, (DescriptionBox) semanticObject); 
				return; 
			case DescriptionsPackage.DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS:
				sequence_DescriptionBoxExtendsClosedWorldDefinitions(context, (DescriptionBoxExtendsClosedWorldDefinitions) semanticObject); 
				return; 
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT:
				sequence_DescriptionBoxRefinement(context, (DescriptionBoxRefinement) semanticObject); 
				return; 
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE:
				sequence_ReifiedRelationshipInstance(context, (ReifiedRelationshipInstance) semanticObject); 
				return; 
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN:
				sequence_ReifiedRelationshipInstanceDomain(context, (ReifiedRelationshipInstanceDomain) semanticObject); 
				return; 
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE_RANGE:
				sequence_ReifiedRelationshipInstanceRange(context, (ReifiedRelationshipInstanceRange) semanticObject); 
				return; 
			case DescriptionsPackage.SCALAR_DATA_PROPERTY_VALUE:
				sequence_ScalarDataPropertyValue(context, (ScalarDataPropertyValue) semanticObject); 
				return; 
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE:
				sequence_SingletonInstanceScalarDataPropertyValue(context, (SingletonInstanceScalarDataPropertyValue) semanticObject); 
				return; 
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE:
				sequence_SingletonInstanceStructuredDataPropertyValue(context, (SingletonInstanceStructuredDataPropertyValue) semanticObject); 
				return; 
			case DescriptionsPackage.STRUCTURED_DATA_PROPERTY_TUPLE:
				sequence_StructuredDataPropertyTuple(context, (StructuredDataPropertyTuple) semanticObject); 
				return; 
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE:
				sequence_UnreifiedRelationshipInstanceTuple(context, (UnreifiedRelationshipInstanceTuple) semanticObject); 
				return; 
			}
		else if (epackage == GraphsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM:
				sequence_ConceptDesignationTerminologyAxiom(context, (ConceptDesignationTerminologyAxiom) semanticObject); 
				return; 
			case GraphsPackage.TERMINOLOGY_GRAPH:
				sequence_TerminologyGraph(context, (TerminologyGraph) semanticObject); 
				return; 
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM:
				sequence_TerminologyNestingAxiom(context, (TerminologyNestingAxiom) semanticObject); 
				return; 
			}
		else if (epackage == TerminologiesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TerminologiesPackage.ASPECT:
				sequence_Aspect(context, (Aspect) semanticObject); 
				return; 
			case TerminologiesPackage.ASPECT_PREDICATE:
				sequence_SegmentPredicate(context, (AspectPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM:
				sequence_AspectSpecializationAxiom(context, (AspectSpecializationAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.BINARY_SCALAR_RESTRICTION:
				sequence_BinaryScalarRestriction(context, (BinaryScalarRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.CHAIN_RULE:
				sequence_ChainRule(context, (ChainRule) semanticObject); 
				return; 
			case TerminologiesPackage.CONCEPT:
				sequence_Concept(context, (Concept) semanticObject); 
				return; 
			case TerminologiesPackage.CONCEPT_PREDICATE:
				sequence_SegmentPredicate(context, (ConceptPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM:
				sequence_ConceptSpecializationAxiom(context, (ConceptSpecializationAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.ENTITY_EXISTENTIAL_RESTRICTION_AXIOM:
				sequence_EntityExistentialRestrictionAxiom(context, (EntityExistentialRestrictionAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY:
				sequence_EntityScalarDataProperty(context, (EntityScalarDataProperty) semanticObject); 
				return; 
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM:
				sequence_EntityScalarDataPropertyExistentialRestrictionAxiom(context, (EntityScalarDataPropertyExistentialRestrictionAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM:
				sequence_EntityScalarDataPropertyParticularRestrictionAxiom(context, (EntityScalarDataPropertyParticularRestrictionAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM:
				sequence_EntityScalarDataPropertyUniversalRestrictionAxiom(context, (EntityScalarDataPropertyUniversalRestrictionAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY:
				sequence_EntityStructuredDataProperty(context, (EntityStructuredDataProperty) semanticObject); 
				return; 
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM:
				sequence_EntityStructuredDataPropertyParticularRestrictionAxiom(context, (EntityStructuredDataPropertyParticularRestrictionAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.ENTITY_UNIVERSAL_RESTRICTION_AXIOM:
				sequence_EntityUniversalRestrictionAxiom(context, (EntityUniversalRestrictionAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION:
				sequence_IRIScalarRestriction(context, (IRIScalarRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.NUMERIC_SCALAR_RESTRICTION:
				sequence_NumericScalarRestriction(context, (NumericScalarRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION:
				sequence_PlainLiteralScalarRestriction(context, (PlainLiteralScalarRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP:
				sequence_ReifiedRelationship(context, (ReifiedRelationship) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE:
				sequence_SegmentPredicate(context, (ReifiedRelationshipInversePropertyPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP_PREDICATE:
				sequence_SegmentPredicate(context, (ReifiedRelationshipPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP_PROPERTY_PREDICATE:
				sequence_SegmentPredicate(context, (ReifiedRelationshipPropertyPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE:
				sequence_SegmentPredicate(context, (ReifiedRelationshipSourceInversePropertyPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE:
				sequence_SegmentPredicate(context, (ReifiedRelationshipSourcePropertyPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM:
				sequence_ReifiedRelationshipSpecializationAxiom(context, (ReifiedRelationshipSpecializationAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE:
				sequence_SegmentPredicate(context, (ReifiedRelationshipTargetInversePropertyPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE:
				sequence_SegmentPredicate(context, (ReifiedRelationshipTargetPropertyPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE:
				sequence_RestrictionScalarDataPropertyValue(context, (RestrictionScalarDataPropertyValue) semanticObject); 
				return; 
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE:
				sequence_RestrictionStructuredDataPropertyTuple(context, (RestrictionStructuredDataPropertyTuple) semanticObject); 
				return; 
			case TerminologiesPackage.RULE_BODY_SEGMENT:
				sequence_RuleBodySegment(context, (RuleBodySegment) semanticObject); 
				return; 
			case TerminologiesPackage.SCALAR:
				sequence_Scalar(context, (Scalar) semanticObject); 
				return; 
			case TerminologiesPackage.SCALAR_DATA_PROPERTY:
				sequence_ScalarDataProperty(context, (ScalarDataProperty) semanticObject); 
				return; 
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM:
				sequence_ScalarOneOfLiteralAxiom(context, (ScalarOneOfLiteralAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.SCALAR_ONE_OF_RESTRICTION:
				sequence_ScalarOneOfRestriction(context, (ScalarOneOfRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION:
				sequence_StringScalarRestriction(context, (StringScalarRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.STRUCTURE:
				sequence_Structure(context, (Structure) semanticObject); 
				return; 
			case TerminologiesPackage.STRUCTURED_DATA_PROPERTY:
				sequence_StructuredDataProperty(context, (StructuredDataProperty) semanticObject); 
				return; 
			case TerminologiesPackage.SUB_DATA_PROPERTY_OF_AXIOM:
				sequence_SubDataPropertyOfAxiom(context, (SubDataPropertyOfAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM:
				sequence_SubObjectPropertyOfAxiom(context, (SubObjectPropertyOfAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.SYNONYM_SCALAR_RESTRICTION:
				sequence_SynonymScalarRestriction(context, (SynonymScalarRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM:
				sequence_TerminologyExtensionAxiom(context, (TerminologyExtensionAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION:
				sequence_TimeScalarRestriction(context, (TimeScalarRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP:
				sequence_UnreifiedRelationship(context, (UnreifiedRelationship) semanticObject); 
				return; 
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE:
				sequence_SegmentPredicate(context, (UnreifiedRelationshipInversePropertyPredicate) semanticObject); 
				return; 
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE:
				sequence_SegmentPredicate(context, (UnreifiedRelationshipPropertyPredicate) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AnnotationPropertyValue returns AnnotationPropertyValue
	 *
	 * Constraint:
	 *     (property=[AnnotationProperty|ABBREV_IRI] value=LiteralString)
	 */
	protected void sequence_AnnotationPropertyValue(ISerializationContext context, AnnotationPropertyValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.ANNOTATION_PROPERTY_VALUE__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.ANNOTATION_PROPERTY_VALUE__PROPERTY));
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.ANNOTATION_PROPERTY_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.ANNOTATION_PROPERTY_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1(), semanticObject.eGet(CommonPackage.Literals.ANNOTATION_PROPERTY_VALUE__PROPERTY, false));
		feeder.accept(grammarAccess.getAnnotationPropertyValueAccess().getValueLiteralStringParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AnnotationProperty returns AnnotationProperty
	 *
	 * Constraint:
	 *     (abbrevIRI=ABBREV_IRI iri=IRI)
	 */
	protected void sequence_AnnotationProperty(ISerializationContext context, AnnotationProperty semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.ANNOTATION_PROPERTY__ABBREV_IRI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.ANNOTATION_PROPERTY__ABBREV_IRI));
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.ANNOTATION_PROPERTY__IRI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.ANNOTATION_PROPERTY__IRI));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIABBREV_IRITerminalRuleCall_1_0(), semanticObject.getAbbrevIRI());
		feeder.accept(grammarAccess.getAnnotationPropertyAccess().getIriIRITerminalRuleCall_3_0(), semanticObject.getIri());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConceptTreeDisjunction returns AnonymousConceptUnionAxiom
	 *     DisjointUnionOfConceptsAxiom returns AnonymousConceptUnionAxiom
	 *     AnonymousConceptUnionAxiom returns AnonymousConceptUnionAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID disjunctions+=DisjointUnionOfConceptsAxiom*)
	 */
	protected void sequence_AnonymousConceptUnionAxiom(ISerializationContext context, AnonymousConceptUnionAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns AspectSpecializationAxiom
	 *     TermAxiom returns AspectSpecializationAxiom
	 *     SpecializationAxiom returns AspectSpecializationAxiom
	 *     AspectSpecializationAxiom returns AspectSpecializationAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* subEntity=[Entity|Reference] superAspect=[Aspect|Reference])
	 */
	protected void sequence_AspectSpecializationAxiom(ISerializationContext context, AspectSpecializationAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns Aspect
	 *     Term returns Aspect
	 *     AtomicEntity returns Aspect
	 *     Aspect returns Aspect
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID)
	 */
	protected void sequence_Aspect(ISerializationContext context, Aspect semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns BinaryScalarRestriction
	 *     Term returns BinaryScalarRestriction
	 *     Datatype returns BinaryScalarRestriction
	 *     ScalarDataRange returns BinaryScalarRestriction
	 *     RestrictedDataRange returns BinaryScalarRestriction
	 *     BinaryScalarRestriction returns BinaryScalarRestriction
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         name=ID 
	 *         (length=PositiveIntegerLiteral | minLength=PositiveIntegerLiteral | maxLength=PositiveIntegerLiteral)* 
	 *         restrictedRange=[DataRange|Reference]
	 *     )
	 */
	protected void sequence_BinaryScalarRestriction(ISerializationContext context, BinaryScalarRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Module returns Bundle
	 *     TerminologyBox returns Bundle
	 *     Bundle returns Bundle
	 *
	 * Constraint:
	 *     (
	 *         annotationProperties+=AnnotationProperty* 
	 *         annotations+=AnnotationPropertyValue* 
	 *         kind=TerminologyKind 
	 *         iri=IRI 
	 *         (
	 *             boxAxioms+=TerminologyBoxAxiom | 
	 *             boxStatements+=TerminologyBoxStatement | 
	 *             bundleStatements+=TerminologyBundleStatement | 
	 *             bundleAxioms+=TerminologyBundleAxiom
	 *         )*
	 *     )
	 */
	protected void sequence_Bundle(ISerializationContext context, Bundle semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BundledTerminologyAxiom returns BundledTerminologyAxiom
	 *     TerminologyBundleAxiom returns BundledTerminologyAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* bundledTerminology=[TerminologyBox|ExternalReference])
	 */
	protected void sequence_BundledTerminologyAxiom(ISerializationContext context, BundledTerminologyAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ChainRule
	 *     Term returns ChainRule
	 *     Rule returns ChainRule
	 *     ChainRule returns ChainRule
	 *
	 * Constraint:
	 *     (name=ID head=[UnreifiedRelationship|Reference] firstSegment=RuleBodySegment)
	 */
	protected void sequence_ChainRule(ISerializationContext context, ChainRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.CHAIN_RULE__HEAD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.CHAIN_RULE__HEAD));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.CHAIN_RULE__FIRST_SEGMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.CHAIN_RULE__FIRST_SEGMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getChainRuleAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getChainRuleAccess().getHeadUnreifiedRelationshipReferenceParserRuleCall_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.CHAIN_RULE__HEAD, false));
		feeder.accept(grammarAccess.getChainRuleAccess().getFirstSegmentRuleBodySegmentParserRuleCall_5_0(), semanticObject.getFirstSegment());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxAxiom returns ConceptDesignationTerminologyAxiom
	 *     ConceptDesignationTerminologyAxiom returns ConceptDesignationTerminologyAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* designatedTerminology=[TerminologyBox|ExternalReference] designatedConcept=[Concept|Reference])
	 */
	protected void sequence_ConceptDesignationTerminologyAxiom(ISerializationContext context, ConceptDesignationTerminologyAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyInstanceAssertion returns ConceptInstance
	 *     ConceptualEntitySingletonInstance returns ConceptInstance
	 *     ConceptInstance returns ConceptInstance
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID singletonConceptClassifier=[Concept|Reference])
	 */
	protected void sequence_ConceptInstance(ISerializationContext context, ConceptInstance semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ConceptSpecializationAxiom
	 *     TermAxiom returns ConceptSpecializationAxiom
	 *     SpecializationAxiom returns ConceptSpecializationAxiom
	 *     ConceptSpecializationAxiom returns ConceptSpecializationAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* subConcept=[Concept|Reference] superConcept=[Concept|Reference])
	 */
	protected void sequence_ConceptSpecializationAxiom(ISerializationContext context, ConceptSpecializationAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns Concept
	 *     Term returns Concept
	 *     AtomicEntity returns Concept
	 *     Concept returns Concept
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID)
	 */
	protected void sequence_Concept(ISerializationContext context, Concept semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DescriptionBoxExtendsClosedWorldDefinitions returns DescriptionBoxExtendsClosedWorldDefinitions
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* closedWorldDefinitions=[TerminologyBox|ExternalReference])
	 */
	protected void sequence_DescriptionBoxExtendsClosedWorldDefinitions(ISerializationContext context, DescriptionBoxExtendsClosedWorldDefinitions semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DescriptionBoxRefinement returns DescriptionBoxRefinement
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* refinedDescriptionBox=[DescriptionBox|ExternalReference])
	 */
	protected void sequence_DescriptionBoxRefinement(ISerializationContext context, DescriptionBoxRefinement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Module returns DescriptionBox
	 *     DescriptionBox returns DescriptionBox
	 *
	 * Constraint:
	 *     (
	 *         annotationProperties+=AnnotationProperty* 
	 *         annotations+=AnnotationPropertyValue* 
	 *         kind=DescriptionKind 
	 *         iri=IRI 
	 *         (
	 *             closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions | 
	 *             descriptionBoxRefinements+=DescriptionBoxRefinement | 
	 *             conceptInstances+=ConceptInstance | 
	 *             reifiedRelationshipInstances+=ReifiedRelationshipInstance | 
	 *             reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain | 
	 *             reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange | 
	 *             unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple | 
	 *             singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue | 
	 *             singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue
	 *         )*
	 *     )
	 */
	protected void sequence_DescriptionBox(ISerializationContext context, DescriptionBox semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityExistentialRestrictionAxiom
	 *     TermAxiom returns EntityExistentialRestrictionAxiom
	 *     EntityRestrictionAxiom returns EntityExistentialRestrictionAxiom
	 *     EntityExistentialRestrictionAxiom returns EntityExistentialRestrictionAxiom
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         restrictedDomain=[Entity|Reference] 
	 *         restrictedRelation=[EntityRelationship|Reference] 
	 *         restrictedRange=[Entity|Reference]
	 *     )
	 */
	protected void sequence_EntityExistentialRestrictionAxiom(ISerializationContext context, EntityExistentialRestrictionAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityScalarDataPropertyExistentialRestrictionAxiom
	 *     TermAxiom returns EntityScalarDataPropertyExistentialRestrictionAxiom
	 *     EntityScalarDataPropertyRestrictionAxiom returns EntityScalarDataPropertyExistentialRestrictionAxiom
	 *     EntityScalarDataPropertyExistentialRestrictionAxiom returns EntityScalarDataPropertyExistentialRestrictionAxiom
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         restrictedEntity=[Entity|Reference] 
	 *         scalarProperty=[EntityScalarDataProperty|Reference] 
	 *         scalarRestriction=[DataRange|Reference]
	 *     )
	 */
	protected void sequence_EntityScalarDataPropertyExistentialRestrictionAxiom(ISerializationContext context, EntityScalarDataPropertyExistentialRestrictionAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityScalarDataPropertyParticularRestrictionAxiom
	 *     TermAxiom returns EntityScalarDataPropertyParticularRestrictionAxiom
	 *     EntityScalarDataPropertyRestrictionAxiom returns EntityScalarDataPropertyParticularRestrictionAxiom
	 *     EntityScalarDataPropertyParticularRestrictionAxiom returns EntityScalarDataPropertyParticularRestrictionAxiom
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         restrictedEntity=[Entity|Reference] 
	 *         scalarProperty=[EntityScalarDataProperty|Reference] 
	 *         literalValue=LiteralValue 
	 *         valueType=[DataRange|Reference]?
	 *     )
	 */
	protected void sequence_EntityScalarDataPropertyParticularRestrictionAxiom(ISerializationContext context, EntityScalarDataPropertyParticularRestrictionAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityScalarDataPropertyUniversalRestrictionAxiom
	 *     TermAxiom returns EntityScalarDataPropertyUniversalRestrictionAxiom
	 *     EntityScalarDataPropertyRestrictionAxiom returns EntityScalarDataPropertyUniversalRestrictionAxiom
	 *     EntityScalarDataPropertyUniversalRestrictionAxiom returns EntityScalarDataPropertyUniversalRestrictionAxiom
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         restrictedEntity=[Entity|Reference] 
	 *         scalarProperty=[EntityScalarDataProperty|Reference] 
	 *         scalarRestriction=[DataRange|Reference]
	 *     )
	 */
	protected void sequence_EntityScalarDataPropertyUniversalRestrictionAxiom(ISerializationContext context, EntityScalarDataPropertyUniversalRestrictionAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityScalarDataProperty
	 *     Term returns EntityScalarDataProperty
	 *     DataRelationship returns EntityScalarDataProperty
	 *     EntityScalarDataProperty returns EntityScalarDataProperty
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* isIdentityCriteria?='+'? name=ID domain=[Entity|Reference] range=[DataRange|Reference])
	 */
	protected void sequence_EntityScalarDataProperty(ISerializationContext context, EntityScalarDataProperty semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityStructuredDataPropertyParticularRestrictionAxiom
	 *     TermAxiom returns EntityStructuredDataPropertyParticularRestrictionAxiom
	 *     EntityStructuredDataPropertyRestrictionAxiom returns EntityStructuredDataPropertyParticularRestrictionAxiom
	 *     EntityStructuredDataPropertyParticularRestrictionAxiom returns EntityStructuredDataPropertyParticularRestrictionAxiom
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         restrictedEntity=[Entity|Reference] 
	 *         structuredDataProperty=[EntityStructuredDataProperty|Reference] 
	 *         (structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple | scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)*
	 *     )
	 */
	protected void sequence_EntityStructuredDataPropertyParticularRestrictionAxiom(ISerializationContext context, EntityStructuredDataPropertyParticularRestrictionAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityStructuredDataProperty
	 *     Term returns EntityStructuredDataProperty
	 *     DataRelationship returns EntityStructuredDataProperty
	 *     EntityStructuredDataProperty returns EntityStructuredDataProperty
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* isIdentityCriteria?='+'? name=ID domain=[Entity|Reference] range=[Structure|Reference])
	 */
	protected void sequence_EntityStructuredDataProperty(ISerializationContext context, EntityStructuredDataProperty semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityUniversalRestrictionAxiom
	 *     TermAxiom returns EntityUniversalRestrictionAxiom
	 *     EntityRestrictionAxiom returns EntityUniversalRestrictionAxiom
	 *     EntityUniversalRestrictionAxiom returns EntityUniversalRestrictionAxiom
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         restrictedDomain=[Entity|Reference] 
	 *         restrictedRelation=[EntityRelationship|Reference] 
	 *         restrictedRange=[Entity|Reference]
	 *     )
	 */
	protected void sequence_EntityUniversalRestrictionAxiom(ISerializationContext context, EntityUniversalRestrictionAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Extent returns Extent
	 *
	 * Constraint:
	 *     modules+=Module*
	 */
	protected void sequence_Extent(ISerializationContext context, Extent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns IRIScalarRestriction
	 *     Term returns IRIScalarRestriction
	 *     Datatype returns IRIScalarRestriction
	 *     ScalarDataRange returns IRIScalarRestriction
	 *     RestrictedDataRange returns IRIScalarRestriction
	 *     IRIScalarRestriction returns IRIScalarRestriction
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         name=ID 
	 *         (length=PositiveIntegerLiteral | minLength=PositiveIntegerLiteral | maxLength=PositiveIntegerLiteral | pattern=PATTERN)* 
	 *         restrictedRange=[DataRange|Reference]
	 *     )
	 */
	protected void sequence_IRIScalarRestriction(ISerializationContext context, IRIScalarRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralBoolean
	 *     LiteralBoolean returns LiteralBoolean
	 *
	 * Constraint:
	 *     (bool=TRUE | bool=FALSE)
	 */
	protected void sequence_LiteralBoolean(ISerializationContext context, LiteralBoolean semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralDateTime
	 *     LiteralDateTime returns LiteralDateTime
	 *
	 * Constraint:
	 *     dateTime=DATE_TIME
	 */
	protected void sequence_LiteralDateTime(ISerializationContext context, LiteralDateTime semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.LITERAL_DATE_TIME__DATE_TIME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.LITERAL_DATE_TIME__DATE_TIME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralDateTimeAccess().getDateTimeDATE_TIMETerminalRuleCall_1_0(), semanticObject.getDateTime());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralDecimal
	 *     LiteralNumber returns LiteralDecimal
	 *     LiteralDecimal returns LiteralDecimal
	 *
	 * Constraint:
	 *     (decimal=DIGITS | decimal=DECIMAL)
	 */
	protected void sequence_LiteralDecimal(ISerializationContext context, LiteralDecimal semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralFloat
	 *     LiteralNumber returns LiteralFloat
	 *     LiteralFloat returns LiteralFloat
	 *
	 * Constraint:
	 *     float=FLOAT
	 */
	protected void sequence_LiteralFloat(ISerializationContext context, LiteralFloat semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.LITERAL_FLOAT__FLOAT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.LITERAL_FLOAT__FLOAT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralFloatAccess().getFloatFLOATTerminalRuleCall_1_0(), semanticObject.getFloat());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralQuotedString
	 *     LiteralString returns LiteralQuotedString
	 *     LiteralQuotedString returns LiteralQuotedString
	 *
	 * Constraint:
	 *     string=QUOTED_STRING_VALUE
	 */
	protected void sequence_LiteralQuotedString(ISerializationContext context, LiteralQuotedString semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.LITERAL_QUOTED_STRING__STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.LITERAL_QUOTED_STRING__STRING));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralQuotedStringAccess().getStringQUOTED_STRING_VALUETerminalRuleCall_1_0(), semanticObject.getString());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralRational
	 *     LiteralNumber returns LiteralRational
	 *     LiteralRational returns LiteralRational
	 *
	 * Constraint:
	 *     rational=RationalDataType
	 */
	protected void sequence_LiteralRational(ISerializationContext context, LiteralRational semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.LITERAL_RATIONAL__RATIONAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.LITERAL_RATIONAL__RATIONAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralRationalAccess().getRationalRationalDataTypeParserRuleCall_1_0(), semanticObject.getRational());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralRawString
	 *     LiteralString returns LiteralRawString
	 *     LiteralRawString returns LiteralRawString
	 *
	 * Constraint:
	 *     string=RAW_STRING_VALUE
	 */
	protected void sequence_LiteralRawString(ISerializationContext context, LiteralRawString semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.LITERAL_RAW_STRING__STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.LITERAL_RAW_STRING__STRING));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralRawStringAccess().getStringRAW_STRING_VALUETerminalRuleCall_1_0(), semanticObject.getString());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralReal
	 *     LiteralNumber returns LiteralReal
	 *     LiteralReal returns LiteralReal
	 *
	 * Constraint:
	 *     real=REAL
	 */
	protected void sequence_LiteralReal(ISerializationContext context, LiteralReal semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.LITERAL_REAL__REAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.LITERAL_REAL__REAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralRealAccess().getRealREALTerminalRuleCall_1_0(), semanticObject.getReal());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralURI
	 *     LiteralURI returns LiteralURI
	 *
	 * Constraint:
	 *     uri=URIDataType
	 */
	protected void sequence_LiteralURI(ISerializationContext context, LiteralURI semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.LITERAL_URI__URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.LITERAL_URI__URI));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralURIAccess().getUriURIDataTypeParserRuleCall_1_0(), semanticObject.getUri());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LiteralValue returns LiteralUUID
	 *     LiteralUUID returns LiteralUUID
	 *
	 * Constraint:
	 *     uuid=UUIDDataType
	 */
	protected void sequence_LiteralUUID(ISerializationContext context, LiteralUUID semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.LITERAL_UUID__UUID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.LITERAL_UUID__UUID));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getLiteralUUIDAccess().getUuidUUIDDataTypeParserRuleCall_1_0(), semanticObject.getUuid());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns NumericScalarRestriction
	 *     Term returns NumericScalarRestriction
	 *     Datatype returns NumericScalarRestriction
	 *     ScalarDataRange returns NumericScalarRestriction
	 *     RestrictedDataRange returns NumericScalarRestriction
	 *     NumericScalarRestriction returns NumericScalarRestriction
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         name=ID 
	 *         (minInclusive=LiteralNumber | maxInclusive=LiteralNumber | minExclusive=LiteralNumber | maxExclusive=LiteralNumber)* 
	 *         restrictedRange=[DataRange|Reference]
	 *     )
	 */
	protected void sequence_NumericScalarRestriction(ISerializationContext context, NumericScalarRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns PlainLiteralScalarRestriction
	 *     Term returns PlainLiteralScalarRestriction
	 *     Datatype returns PlainLiteralScalarRestriction
	 *     ScalarDataRange returns PlainLiteralScalarRestriction
	 *     RestrictedDataRange returns PlainLiteralScalarRestriction
	 *     PlainLiteralScalarRestriction returns PlainLiteralScalarRestriction
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         name=ID 
	 *         (length=PositiveIntegerLiteral | minLength=PositiveIntegerLiteral | maxLength=PositiveIntegerLiteral | pattern=PATTERN | langRange=LANG_TAG)* 
	 *         restrictedRange=[DataRange|Reference]
	 *     )
	 */
	protected void sequence_PlainLiteralScalarRestriction(ISerializationContext context, PlainLiteralScalarRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyInstanceAssertion returns ReifiedRelationshipInstanceDomain
	 *     ReifiedRelationshipInstanceDomain returns ReifiedRelationshipInstanceDomain
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] 
	 *         domain=[ConceptualEntitySingletonInstance|Reference]
	 *     )
	 */
	protected void sequence_ReifiedRelationshipInstanceDomain(ISerializationContext context, ReifiedRelationshipInstanceDomain semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyInstanceAssertion returns ReifiedRelationshipInstanceRange
	 *     ReifiedRelationshipInstanceRange returns ReifiedRelationshipInstanceRange
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] 
	 *         range=[ConceptualEntitySingletonInstance|Reference]
	 *     )
	 */
	protected void sequence_ReifiedRelationshipInstanceRange(ISerializationContext context, ReifiedRelationshipInstanceRange semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyInstanceAssertion returns ReifiedRelationshipInstance
	 *     ConceptualEntitySingletonInstance returns ReifiedRelationshipInstance
	 *     ReifiedRelationshipInstance returns ReifiedRelationshipInstance
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference])
	 */
	protected void sequence_ReifiedRelationshipInstance(ISerializationContext context, ReifiedRelationshipInstance semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ReifiedRelationshipSpecializationAxiom
	 *     TermAxiom returns ReifiedRelationshipSpecializationAxiom
	 *     SpecializationAxiom returns ReifiedRelationshipSpecializationAxiom
	 *     ReifiedRelationshipSpecializationAxiom returns ReifiedRelationshipSpecializationAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* subRelationship=[ReifiedRelationship|Reference] superRelationship=[ReifiedRelationship|Reference])
	 */
	protected void sequence_ReifiedRelationshipSpecializationAxiom(ISerializationContext context, ReifiedRelationshipSpecializationAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ReifiedRelationship
	 *     Term returns ReifiedRelationship
	 *     EntityRelationship returns ReifiedRelationship
	 *     ReifiedRelationship returns ReifiedRelationship
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         name=ID 
	 *         (
	 *             isFunctional?='functional' | 
	 *             isInverseFunctional?='inverseFunctional' | 
	 *             isEssential?='essential' | 
	 *             isInverseEssential?='inverseEssential' | 
	 *             isSymmetric?='symmetric' | 
	 *             isAsymmetric?='asymmetric' | 
	 *             isReflexive?='reflexive' | 
	 *             isIrreflexive?='irreflexive' | 
	 *             isTransitive?='transitive'
	 *         )* 
	 *         unreifiedPropertyName=ID 
	 *         unreifiedInversePropertyName=ID? 
	 *         source=[Entity|Reference] 
	 *         target=[Entity|Reference]
	 *     )
	 */
	protected void sequence_ReifiedRelationship(ISerializationContext context, ReifiedRelationship semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RestrictionScalarDataPropertyValue returns RestrictionScalarDataPropertyValue
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         scalarDataProperty=[ScalarDataProperty|Reference] 
	 *         scalarPropertyValue=LiteralValue 
	 *         valueType=[DataRange|Reference]?
	 *     )
	 */
	protected void sequence_RestrictionScalarDataPropertyValue(ISerializationContext context, RestrictionScalarDataPropertyValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RestrictionStructuredDataPropertyTuple returns RestrictionStructuredDataPropertyTuple
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         structuredDataProperty=[StructuredDataProperty|Reference] 
	 *         (structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple | scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)*
	 *     )
	 */
	protected void sequence_RestrictionStructuredDataPropertyTuple(ISerializationContext context, RestrictionStructuredDataPropertyTuple semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBundleStatement returns RootConceptTaxonomyAxiom
	 *     ConceptTreeDisjunction returns RootConceptTaxonomyAxiom
	 *     RootConceptTaxonomyAxiom returns RootConceptTaxonomyAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* root=[Concept|Reference] disjunctions+=DisjointUnionOfConceptsAxiom*)
	 */
	protected void sequence_RootConceptTaxonomyAxiom(ISerializationContext context, RootConceptTaxonomyAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RuleBodySegment returns RuleBodySegment
	 *
	 * Constraint:
	 *     (predicate=SegmentPredicate nextSegment=RuleBodySegment?)
	 */
	protected void sequence_RuleBodySegment(ISerializationContext context, RuleBodySegment semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ScalarDataPropertyValue returns ScalarDataPropertyValue
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         scalarDataProperty=[DataRelationshipToScalar|Reference] 
	 *         scalarPropertyValue=LiteralValue 
	 *         valueType=[DataRange|Reference]?
	 *     )
	 */
	protected void sequence_ScalarDataPropertyValue(ISerializationContext context, ScalarDataPropertyValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ScalarDataProperty
	 *     Term returns ScalarDataProperty
	 *     DataRelationship returns ScalarDataProperty
	 *     ScalarDataProperty returns ScalarDataProperty
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID domain=[Structure|Reference] range=[DataRange|Reference])
	 */
	protected void sequence_ScalarDataProperty(ISerializationContext context, ScalarDataProperty semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ScalarOneOfLiteralAxiom
	 *     TermAxiom returns ScalarOneOfLiteralAxiom
	 *     ScalarOneOfLiteralAxiom returns ScalarOneOfLiteralAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* axiom=[ScalarOneOfRestriction|Reference] value=LiteralValue valueType=[DataRange|Reference]?)
	 */
	protected void sequence_ScalarOneOfLiteralAxiom(ISerializationContext context, ScalarOneOfLiteralAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ScalarOneOfRestriction
	 *     Term returns ScalarOneOfRestriction
	 *     Datatype returns ScalarOneOfRestriction
	 *     ScalarDataRange returns ScalarOneOfRestriction
	 *     RestrictedDataRange returns ScalarOneOfRestriction
	 *     ScalarOneOfRestriction returns ScalarOneOfRestriction
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID restrictedRange=[DataRange|Reference])
	 */
	protected void sequence_ScalarOneOfRestriction(ISerializationContext context, ScalarOneOfRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns Scalar
	 *     Term returns Scalar
	 *     Datatype returns Scalar
	 *     ScalarDataRange returns Scalar
	 *     Scalar returns Scalar
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID)
	 */
	protected void sequence_Scalar(ISerializationContext context, Scalar semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns AspectPredicate
	 *
	 * Constraint:
	 *     aspect=[Aspect|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, AspectPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ASPECT_PREDICATE__ASPECT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ASPECT_PREDICATE__ASPECT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getAspectAspectReferenceParserRuleCall_0_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ASPECT_PREDICATE__ASPECT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns ConceptPredicate
	 *
	 * Constraint:
	 *     concept=[Concept|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, ConceptPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.CONCEPT_PREDICATE__CONCEPT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.CONCEPT_PREDICATE__CONCEPT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getConceptConceptReferenceParserRuleCall_1_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.CONCEPT_PREDICATE__CONCEPT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns ReifiedRelationshipInversePropertyPredicate
	 *
	 * Constraint:
	 *     reifiedRelationship=[ReifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, ReifiedRelationshipInversePropertyPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipReferenceParserRuleCall_4_5_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns ReifiedRelationshipPredicate
	 *
	 * Constraint:
	 *     reifiedRelationship=[ReifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, ReifiedRelationshipPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_PREDICATE__REIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_PREDICATE__REIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipReferenceParserRuleCall_2_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_PREDICATE__REIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns ReifiedRelationshipPropertyPredicate
	 *
	 * Constraint:
	 *     reifiedRelationship=[ReifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, ReifiedRelationshipPropertyPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipReferenceParserRuleCall_3_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns ReifiedRelationshipSourceInversePropertyPredicate
	 *
	 * Constraint:
	 *     reifiedRelationship=[ReifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, ReifiedRelationshipSourceInversePropertyPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipReferenceParserRuleCall_6_5_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns ReifiedRelationshipSourcePropertyPredicate
	 *
	 * Constraint:
	 *     reifiedRelationship=[ReifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, ReifiedRelationshipSourcePropertyPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipReferenceParserRuleCall_5_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns ReifiedRelationshipTargetInversePropertyPredicate
	 *
	 * Constraint:
	 *     reifiedRelationship=[ReifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, ReifiedRelationshipTargetInversePropertyPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipReferenceParserRuleCall_8_5_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns ReifiedRelationshipTargetPropertyPredicate
	 *
	 * Constraint:
	 *     reifiedRelationship=[ReifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, ReifiedRelationshipTargetPropertyPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipReferenceParserRuleCall_7_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns UnreifiedRelationshipInversePropertyPredicate
	 *
	 * Constraint:
	 *     unreifiedRelationship=[UnreifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, UnreifiedRelationshipInversePropertyPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_10_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SegmentPredicate returns UnreifiedRelationshipPropertyPredicate
	 *
	 * Constraint:
	 *     unreifiedRelationship=[UnreifiedRelationship|Reference]
	 */
	protected void sequence_SegmentPredicate(ISerializationContext context, UnreifiedRelationshipPropertyPredicate semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_9_1_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SingletonInstanceScalarDataPropertyValue returns SingletonInstanceScalarDataPropertyValue
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         singletonInstance=[ConceptualEntitySingletonInstance|Reference] 
	 *         scalarDataProperty=[EntityScalarDataProperty|Reference] 
	 *         scalarPropertyValue=LiteralValue 
	 *         valueType=[DataRange|Reference]?
	 *     )
	 */
	protected void sequence_SingletonInstanceScalarDataPropertyValue(ISerializationContext context, SingletonInstanceScalarDataPropertyValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SingletonInstanceStructuredDataPropertyValue returns SingletonInstanceStructuredDataPropertyValue
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         singletonInstance=[ConceptualEntitySingletonInstance|Reference] 
	 *         structuredDataProperty=[DataRelationshipToStructure|Reference] 
	 *         (structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
	 *     )
	 */
	protected void sequence_SingletonInstanceStructuredDataPropertyValue(ISerializationContext context, SingletonInstanceStructuredDataPropertyValue semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DisjointUnionOfConceptsAxiom returns SpecificDisjointConceptAxiom
	 *     SpecificDisjointConceptAxiom returns SpecificDisjointConceptAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* disjointLeaf=[Concept|Reference])
	 */
	protected void sequence_SpecificDisjointConceptAxiom(ISerializationContext context, SpecificDisjointConceptAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns StringScalarRestriction
	 *     Term returns StringScalarRestriction
	 *     Datatype returns StringScalarRestriction
	 *     ScalarDataRange returns StringScalarRestriction
	 *     RestrictedDataRange returns StringScalarRestriction
	 *     StringScalarRestriction returns StringScalarRestriction
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         name=ID 
	 *         (length=PositiveIntegerLiteral | minLength=PositiveIntegerLiteral | maxLength=PositiveIntegerLiteral | pattern=PATTERN)* 
	 *         restrictedRange=[DataRange|Reference]
	 *     )
	 */
	protected void sequence_StringScalarRestriction(ISerializationContext context, StringScalarRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns Structure
	 *     Term returns Structure
	 *     Datatype returns Structure
	 *     Structure returns Structure
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID)
	 */
	protected void sequence_Structure(ISerializationContext context, Structure semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     StructuredDataPropertyTuple returns StructuredDataPropertyTuple
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         structuredDataProperty=[DataRelationshipToStructure|Reference] 
	 *         (structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
	 *     )
	 */
	protected void sequence_StructuredDataPropertyTuple(ISerializationContext context, StructuredDataPropertyTuple semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns StructuredDataProperty
	 *     Term returns StructuredDataProperty
	 *     DataRelationship returns StructuredDataProperty
	 *     StructuredDataProperty returns StructuredDataProperty
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID domain=[Structure|Reference] range=[Structure|Reference])
	 */
	protected void sequence_StructuredDataProperty(ISerializationContext context, StructuredDataProperty semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns SubDataPropertyOfAxiom
	 *     TermAxiom returns SubDataPropertyOfAxiom
	 *     SubDataPropertyOfAxiom returns SubDataPropertyOfAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* subProperty=[EntityScalarDataProperty|Reference] superProperty=[EntityScalarDataProperty|Reference])
	 */
	protected void sequence_SubDataPropertyOfAxiom(ISerializationContext context, SubDataPropertyOfAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns SubObjectPropertyOfAxiom
	 *     TermAxiom returns SubObjectPropertyOfAxiom
	 *     SubObjectPropertyOfAxiom returns SubObjectPropertyOfAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* subProperty=[UnreifiedRelationship|Reference] superProperty=[UnreifiedRelationship|Reference])
	 */
	protected void sequence_SubObjectPropertyOfAxiom(ISerializationContext context, SubObjectPropertyOfAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns SynonymScalarRestriction
	 *     Term returns SynonymScalarRestriction
	 *     Datatype returns SynonymScalarRestriction
	 *     ScalarDataRange returns SynonymScalarRestriction
	 *     RestrictedDataRange returns SynonymScalarRestriction
	 *     SynonymScalarRestriction returns SynonymScalarRestriction
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* name=ID restrictedRange=[DataRange|Reference])
	 */
	protected void sequence_SynonymScalarRestriction(ISerializationContext context, SynonymScalarRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxAxiom returns TerminologyExtensionAxiom
	 *     TerminologyExtensionAxiom returns TerminologyExtensionAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* extendedTerminology=[TerminologyBox|ExternalReference])
	 */
	protected void sequence_TerminologyExtensionAxiom(ISerializationContext context, TerminologyExtensionAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Module returns TerminologyGraph
	 *     TerminologyBox returns TerminologyGraph
	 *     TerminologyGraph returns TerminologyGraph
	 *
	 * Constraint:
	 *     (
	 *         annotationProperties+=AnnotationProperty* 
	 *         annotations+=AnnotationPropertyValue* 
	 *         kind=TerminologyKind 
	 *         iri=IRI 
	 *         (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
	 *     )
	 */
	protected void sequence_TerminologyGraph(ISerializationContext context, TerminologyGraph semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxAxiom returns TerminologyNestingAxiom
	 *     TerminologyNestingAxiom returns TerminologyNestingAxiom
	 *
	 * Constraint:
	 *     (annotations+=AnnotationPropertyValue* nestingTerminology=[TerminologyBox|ExternalReference] nestingContext=[Concept|Reference])
	 */
	protected void sequence_TerminologyNestingAxiom(ISerializationContext context, TerminologyNestingAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns TimeScalarRestriction
	 *     Term returns TimeScalarRestriction
	 *     Datatype returns TimeScalarRestriction
	 *     ScalarDataRange returns TimeScalarRestriction
	 *     RestrictedDataRange returns TimeScalarRestriction
	 *     TimeScalarRestriction returns TimeScalarRestriction
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         name=ID 
	 *         (minInclusive=LiteralDateTime | maxInclusive=LiteralDateTime | minExclusive=LiteralDateTime | maxExclusive=LiteralDateTime)* 
	 *         restrictedRange=[DataRange|Reference]
	 *     )
	 */
	protected void sequence_TimeScalarRestriction(ISerializationContext context, TimeScalarRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyInstanceAssertion returns UnreifiedRelationshipInstanceTuple
	 *     UnreifiedRelationshipInstanceTuple returns UnreifiedRelationshipInstanceTuple
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         unreifiedRelationship=[UnreifiedRelationship|Reference] 
	 *         domain=[ConceptualEntitySingletonInstance|Reference] 
	 *         range=[ConceptualEntitySingletonInstance|Reference]
	 *     )
	 */
	protected void sequence_UnreifiedRelationshipInstanceTuple(ISerializationContext context, UnreifiedRelationshipInstanceTuple semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns UnreifiedRelationship
	 *     Term returns UnreifiedRelationship
	 *     EntityRelationship returns UnreifiedRelationship
	 *     UnreifiedRelationship returns UnreifiedRelationship
	 *
	 * Constraint:
	 *     (
	 *         annotations+=AnnotationPropertyValue* 
	 *         name=ID 
	 *         (
	 *             isFunctional?='functional' | 
	 *             isInverseFunctional?='inverseFunctional' | 
	 *             isEssential?='essential' | 
	 *             isInverseEssential?='inverseEssential' | 
	 *             isSymmetric?='symmetric' | 
	 *             isAsymmetric?='asymmetric' | 
	 *             isReflexive?='reflexive' | 
	 *             isIrreflexive?='irreflexive' | 
	 *             isTransitive?='transitive'
	 *         )* 
	 *         source=[Entity|Reference] 
	 *         target=[Entity|Reference]
	 *     )
	 */
	protected void sequence_UnreifiedRelationship(ISerializationContext context, UnreifiedRelationship semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
}
