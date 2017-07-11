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
import gov.nasa.jpl.imce.oml.model.common.Annotation;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Extent;
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
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
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
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
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
			case CommonPackage.ANNOTATION:
				sequence_Annotation(context, (Annotation) semanticObject); 
				return; 
			case CommonPackage.ANNOTATION_PROPERTY:
				sequence_AnnotationProperty(context, (AnnotationProperty) semanticObject); 
				return; 
			case CommonPackage.EXTENT:
				sequence_Extent(context, (Extent) semanticObject); 
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
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM:
				sequence_AspectSpecializationAxiom(context, (AspectSpecializationAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.BINARY_SCALAR_RESTRICTION:
				sequence_BinaryScalarRestriction(context, (BinaryScalarRestriction) semanticObject); 
				return; 
			case TerminologiesPackage.CONCEPT:
				sequence_Concept(context, (Concept) semanticObject); 
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM:
				sequence_ReifiedRelationshipSpecializationAxiom(context, (ReifiedRelationshipSpecializationAxiom) semanticObject); 
				return; 
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE:
				sequence_RestrictionScalarDataPropertyValue(context, (RestrictionScalarDataPropertyValue) semanticObject); 
				return; 
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE:
				sequence_RestrictionStructuredDataPropertyTuple(context, (RestrictionStructuredDataPropertyTuple) semanticObject); 
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
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
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
	 *     Annotation returns Annotation
	 *
	 * Constraint:
	 *     (property=[AnnotationProperty|ABBREV_IRI] value=STRING)
	 */
	protected void sequence_Annotation(ISerializationContext context, Annotation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.ANNOTATION__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.ANNOTATION__PROPERTY));
			if (transientValues.isValueTransient((EObject) semanticObject, CommonPackage.Literals.ANNOTATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, CommonPackage.Literals.ANNOTATION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1(), semanticObject.eGet(CommonPackage.Literals.ANNOTATION__PROPERTY, false));
		feeder.accept(grammarAccess.getAnnotationAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConceptTreeDisjunction returns AnonymousConceptUnionAxiom
	 *     DisjointUnionOfConceptsAxiom returns AnonymousConceptUnionAxiom
	 *     AnonymousConceptUnionAxiom returns AnonymousConceptUnionAxiom
	 *
	 * Constraint:
	 *     (name=ID disjunctions+=DisjointUnionOfConceptsAxiom*)
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
	 *     (subEntity=[Entity|Reference] superAspect=[Aspect|Reference])
	 */
	protected void sequence_AspectSpecializationAxiom(ISerializationContext context, AspectSpecializationAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityReferenceParserRuleCall_0_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY, false));
		feeder.accept(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectReferenceParserRuleCall_2_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns Aspect
	 *     Term returns Aspect
	 *     AtomicEntity returns Aspect
	 *     Aspect returns Aspect
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Aspect(ISerializationContext context, Aspect semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
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
	 *     (name=ID (length=INT | minLength=INT | maxLength=INT)* restrictedRange=[DataRange|Reference])
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
	 *         annotations+=Annotation* 
	 *         kind=TerminologyKind 
	 *         iri=IRI 
	 *         (
	 *             annotations+=Annotation | 
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
	 *     bundledTerminology=[TerminologyBox|ExternalReference]
	 */
	protected void sequence_BundledTerminologyAxiom(ISerializationContext context, BundledTerminologyAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, BundlesPackage.Literals.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, BundlesPackage.Literals.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1(), semanticObject.eGet(BundlesPackage.Literals.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxAxiom returns ConceptDesignationTerminologyAxiom
	 *     ConceptDesignationTerminologyAxiom returns ConceptDesignationTerminologyAxiom
	 *
	 * Constraint:
	 *     (designatedTerminology=[TerminologyBox|ExternalReference] designatedConcept=[Concept|Reference])
	 */
	protected void sequence_ConceptDesignationTerminologyAxiom(ISerializationContext context, ConceptDesignationTerminologyAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, GraphsPackage.Literals.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, GraphsPackage.Literals.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY));
			if (transientValues.isValueTransient((EObject) semanticObject, GraphsPackage.Literals.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, GraphsPackage.Literals.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1(), semanticObject.eGet(GraphsPackage.Literals.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY, false));
		feeder.accept(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptReferenceParserRuleCall_5_0_1(), semanticObject.eGet(GraphsPackage.Literals.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyInstanceAssertion returns ConceptInstance
	 *     ConceptualEntitySingletonInstance returns ConceptInstance
	 *     ConceptInstance returns ConceptInstance
	 *
	 * Constraint:
	 *     (name=ID singletonConceptClassifier=[Concept|Reference])
	 */
	protected void sequence_ConceptInstance(ISerializationContext context, ConceptInstance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptReferenceParserRuleCall_4_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ConceptSpecializationAxiom
	 *     TermAxiom returns ConceptSpecializationAxiom
	 *     SpecializationAxiom returns ConceptSpecializationAxiom
	 *     ConceptSpecializationAxiom returns ConceptSpecializationAxiom
	 *
	 * Constraint:
	 *     (subConcept=[Concept|Reference] superConcept=[Concept|Reference])
	 */
	protected void sequence_ConceptSpecializationAxiom(ISerializationContext context, ConceptSpecializationAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptReferenceParserRuleCall_0_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT, false));
		feeder.accept(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptReferenceParserRuleCall_2_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns Concept
	 *     Term returns Concept
	 *     AtomicEntity returns Concept
	 *     Concept returns Concept
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Concept(ISerializationContext context, Concept semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DescriptionBoxExtendsClosedWorldDefinitions returns DescriptionBoxExtendsClosedWorldDefinitions
	 *
	 * Constraint:
	 *     closedWorldDefinitions=[TerminologyBox|ExternalReference]
	 */
	protected void sequence_DescriptionBoxExtendsClosedWorldDefinitions(ISerializationContext context, DescriptionBoxExtendsClosedWorldDefinitions semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__CLOSED_WORLD_DEFINITIONS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__CLOSED_WORLD_DEFINITIONS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_1_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__CLOSED_WORLD_DEFINITIONS, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DescriptionBoxRefinement returns DescriptionBoxRefinement
	 *
	 * Constraint:
	 *     refinedDescriptionBox=[DescriptionBox|ExternalReference]
	 */
	protected void sequence_DescriptionBoxRefinement(ISerializationContext context, DescriptionBoxRefinement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_1_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Module returns DescriptionBox
	 *     DescriptionBox returns DescriptionBox
	 *
	 * Constraint:
	 *     (
	 *         annotations+=Annotation* 
	 *         kind=DescriptionKind 
	 *         iri=IRI 
	 *         (
	 *             annotations+=Annotation | 
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
	 *     (restrictedDomain=[Entity|Reference] restrictedRelation=[ReifiedRelationship|Reference] restrictedRange=[Entity|Reference])
	 */
	protected void sequence_EntityExistentialRestrictionAxiom(ISerializationContext context, EntityExistentialRestrictionAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityReferenceParserRuleCall_1_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN, false));
		feeder.accept(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION, false));
		feeder.accept(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityReferenceParserRuleCall_5_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityScalarDataPropertyExistentialRestrictionAxiom
	 *     TermAxiom returns EntityScalarDataPropertyExistentialRestrictionAxiom
	 *     EntityScalarDataPropertyRestrictionAxiom returns EntityScalarDataPropertyExistentialRestrictionAxiom
	 *     EntityScalarDataPropertyExistentialRestrictionAxiom returns EntityScalarDataPropertyExistentialRestrictionAxiom
	 *
	 * Constraint:
	 *     (restrictedEntity=[Entity|Reference] scalarProperty=[EntityScalarDataProperty|Reference] scalarRestriction=[DataRange|Reference])
	 */
	protected void sequence_EntityScalarDataPropertyExistentialRestrictionAxiom(ISerializationContext context, EntityScalarDataPropertyExistentialRestrictionAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY, false));
		feeder.accept(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY, false));
		feeder.accept(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityScalarDataPropertyParticularRestrictionAxiom
	 *     TermAxiom returns EntityScalarDataPropertyParticularRestrictionAxiom
	 *     EntityScalarDataPropertyRestrictionAxiom returns EntityScalarDataPropertyParticularRestrictionAxiom
	 *     EntityScalarDataPropertyParticularRestrictionAxiom returns EntityScalarDataPropertyParticularRestrictionAxiom
	 *
	 * Constraint:
	 *     (restrictedEntity=[Entity|Reference] scalarProperty=[EntityScalarDataProperty|Reference] literalValue=Value)
	 */
	protected void sequence_EntityScalarDataPropertyParticularRestrictionAxiom(ISerializationContext context, EntityScalarDataPropertyParticularRestrictionAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__LITERAL_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__LITERAL_VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY, false));
		feeder.accept(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY, false));
		feeder.accept(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueValueParserRuleCall_5_0(), semanticObject.getLiteralValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityScalarDataPropertyUniversalRestrictionAxiom
	 *     TermAxiom returns EntityScalarDataPropertyUniversalRestrictionAxiom
	 *     EntityScalarDataPropertyRestrictionAxiom returns EntityScalarDataPropertyUniversalRestrictionAxiom
	 *     EntityScalarDataPropertyUniversalRestrictionAxiom returns EntityScalarDataPropertyUniversalRestrictionAxiom
	 *
	 * Constraint:
	 *     (restrictedEntity=[Entity|Reference] scalarProperty=[EntityScalarDataProperty|Reference] scalarRestriction=[DataRange|Reference])
	 */
	protected void sequence_EntityScalarDataPropertyUniversalRestrictionAxiom(ISerializationContext context, EntityScalarDataPropertyUniversalRestrictionAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY, false));
		feeder.accept(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY, false));
		feeder.accept(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns EntityScalarDataProperty
	 *     Term returns EntityScalarDataProperty
	 *     DataRelationship returns EntityScalarDataProperty
	 *     EntityScalarDataProperty returns EntityScalarDataProperty
	 *
	 * Constraint:
	 *     (isIdentityCriteria?='+'? name=ID domain=[Entity|Reference] range=[DataRange|Reference])
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
	 *         restrictedEntity=[Entity|Reference] 
	 *         structuredDataProperty=[EntityStructuredDataProperty|Reference] 
	 *         (structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple | scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)*
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
	 *     (isIdentityCriteria?='+'? name=ID domain=[Entity|Reference] range=[Structure|Reference])
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
	 *     (restrictedDomain=[Entity|Reference] restrictedRelation=[ReifiedRelationship|Reference] restrictedRange=[Entity|Reference])
	 */
	protected void sequence_EntityUniversalRestrictionAxiom(ISerializationContext context, EntityUniversalRestrictionAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityReferenceParserRuleCall_1_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN, false));
		feeder.accept(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION, false));
		feeder.accept(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityReferenceParserRuleCall_5_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Extent returns Extent
	 *
	 * Constraint:
	 *     (annotationProperties+=AnnotationProperty | modules+=Module)*
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
	 *     (name=ID (length=INT | minLength=INT | maxLength=INT | pattern=STRING)* restrictedRange=[DataRange|Reference])
	 */
	protected void sequence_IRIScalarRestriction(ISerializationContext context, IRIScalarRestriction semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
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
	 *     (name=ID (minInclusive=STRING | maxInclusive=STRING | minExclusive=STRING | maxExclusive=STRING)* restrictedRange=[DataRange|Reference])
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
	 *     (name=ID (length=INT | minLength=INT | maxLength=INT | pattern=STRING | langRange=STRING)* restrictedRange=[DataRange|Reference])
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
	 *     (reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] domain=[ConceptualEntitySingletonInstance|Reference])
	 */
	protected void sequence_ReifiedRelationshipInstanceDomain(ISerializationContext context, ReifiedRelationshipInstanceDomain semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__REIFIED_RELATIONSHIP_INSTANCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__REIFIED_RELATIONSHIP_INSTANCE));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DOMAIN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__REIFIED_RELATIONSHIP_INSTANCE, false));
		feeder.accept(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DOMAIN, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyInstanceAssertion returns ReifiedRelationshipInstanceRange
	 *     ReifiedRelationshipInstanceRange returns ReifiedRelationshipInstanceRange
	 *
	 * Constraint:
	 *     (reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] range=[ConceptualEntitySingletonInstance|Reference])
	 */
	protected void sequence_ReifiedRelationshipInstanceRange(ISerializationContext context, ReifiedRelationshipInstanceRange semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_RANGE__REIFIED_RELATIONSHIP_INSTANCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_RANGE__REIFIED_RELATIONSHIP_INSTANCE));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_RANGE__RANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_RANGE__RANGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_RANGE__REIFIED_RELATIONSHIP_INSTANCE, false));
		feeder.accept(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE_RANGE__RANGE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyInstanceAssertion returns ReifiedRelationshipInstance
	 *     ConceptualEntitySingletonInstance returns ReifiedRelationshipInstance
	 *     ReifiedRelationshipInstance returns ReifiedRelationshipInstance
	 *
	 * Constraint:
	 *     (name=ID singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference])
	 */
	protected void sequence_ReifiedRelationshipInstance(ISerializationContext context, ReifiedRelationshipInstance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_4_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ReifiedRelationshipSpecializationAxiom
	 *     TermAxiom returns ReifiedRelationshipSpecializationAxiom
	 *     SpecializationAxiom returns ReifiedRelationshipSpecializationAxiom
	 *     ReifiedRelationshipSpecializationAxiom returns ReifiedRelationshipSpecializationAxiom
	 *
	 * Constraint:
	 *     (subRelationship=[ReifiedRelationship|Reference] superRelationship=[ReifiedRelationship|Reference])
	 */
	protected void sequence_ReifiedRelationshipSpecializationAxiom(ISerializationContext context, ReifiedRelationshipSpecializationAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipReferenceParserRuleCall_0_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP, false));
		feeder.accept(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipReferenceParserRuleCall_2_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP, false));
		feeder.finish();
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
	 *     (scalarDataProperty=[ScalarDataProperty|Reference] scalarPropertyValue=Value)
	 */
	protected void sequence_RestrictionScalarDataPropertyValue(ISerializationContext context, RestrictionScalarDataPropertyValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_0_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY, false));
		feeder.accept(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0(), semanticObject.getScalarPropertyValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RestrictionStructuredDataPropertyTuple returns RestrictionStructuredDataPropertyTuple
	 *
	 * Constraint:
	 *     (
	 *         structuredDataProperty=[StructuredDataProperty|Reference] 
	 *         (structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple | scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)*
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
	 *     (root=[Concept|Reference] disjunctions+=DisjointUnionOfConceptsAxiom*)
	 */
	protected void sequence_RootConceptTaxonomyAxiom(ISerializationContext context, RootConceptTaxonomyAxiom semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ScalarDataPropertyValue returns ScalarDataPropertyValue
	 *
	 * Constraint:
	 *     (scalarDataProperty=[DataRelationshipToScalar|Reference] scalarPropertyValue=Value)
	 */
	protected void sequence_ScalarDataPropertyValue(ISerializationContext context, ScalarDataPropertyValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_0_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY, false));
		feeder.accept(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0(), semanticObject.getScalarPropertyValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ScalarDataProperty
	 *     Term returns ScalarDataProperty
	 *     DataRelationship returns ScalarDataProperty
	 *     ScalarDataProperty returns ScalarDataProperty
	 *
	 * Constraint:
	 *     (name=ID domain=[Structure|Reference] range=[DataRange|Reference])
	 */
	protected void sequence_ScalarDataProperty(ISerializationContext context, ScalarDataProperty semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.DATA_RELATIONSHIP_TO_SCALAR__RANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.DATA_RELATIONSHIP_TO_SCALAR__RANGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getScalarDataPropertyAccess().getDomainStructureReferenceParserRuleCall_4_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN, false));
		feeder.accept(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_6_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.DATA_RELATIONSHIP_TO_SCALAR__RANGE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxStatement returns ScalarOneOfLiteralAxiom
	 *     TermAxiom returns ScalarOneOfLiteralAxiom
	 *     ScalarOneOfLiteralAxiom returns ScalarOneOfLiteralAxiom
	 *
	 * Constraint:
	 *     (axiom=[ScalarOneOfRestriction|Reference] value=STRING)
	 */
	protected void sequence_ScalarOneOfLiteralAxiom(ISerializationContext context, ScalarOneOfLiteralAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionReferenceParserRuleCall_1_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM, false));
		feeder.accept(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
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
	 *     (name=ID restrictedRange=[DataRange|Reference])
	 */
	protected void sequence_ScalarOneOfRestriction(ISerializationContext context, ScalarOneOfRestriction semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE, false));
		feeder.finish();
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
	 *     name=ID
	 */
	protected void sequence_Scalar(ISerializationContext context, Scalar semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SingletonInstanceScalarDataPropertyValue returns SingletonInstanceScalarDataPropertyValue
	 *
	 * Constraint:
	 *     (
	 *         singletonInstance=[ConceptualEntitySingletonInstance|Reference] 
	 *         scalarDataProperty=[EntityScalarDataProperty|Reference] 
	 *         scalarPropertyValue=Value
	 *     )
	 */
	protected void sequence_SingletonInstanceScalarDataPropertyValue(ISerializationContext context, SingletonInstanceScalarDataPropertyValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE, false));
		feeder.accept(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_2_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY, false));
		feeder.accept(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_4_0(), semanticObject.getScalarPropertyValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SingletonInstanceStructuredDataPropertyValue returns SingletonInstanceStructuredDataPropertyValue
	 *
	 * Constraint:
	 *     (
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
	 *     disjointLeaf=[Concept|Reference]
	 */
	protected void sequence_SpecificDisjointConceptAxiom(ISerializationContext context, SpecificDisjointConceptAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, BundlesPackage.Literals.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, BundlesPackage.Literals.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptReferenceParserRuleCall_2_0_1(), semanticObject.eGet(BundlesPackage.Literals.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF, false));
		feeder.finish();
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
	 *     (name=ID (length=INT | minLength=INT | maxLength=INT | pattern=STRING)* restrictedRange=[DataRange|Reference])
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
	 *     name=ID
	 */
	protected void sequence_Structure(ISerializationContext context, Structure semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     StructuredDataPropertyTuple returns StructuredDataPropertyTuple
	 *
	 * Constraint:
	 *     (
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
	 *     (name=ID domain=[Structure|Reference] range=[Structure|Reference])
	 */
	protected void sequence_StructuredDataProperty(ISerializationContext context, StructuredDataProperty semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.DATA_RELATIONSHIP_TO_STRUCTURE__RANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.DATA_RELATIONSHIP_TO_STRUCTURE__RANGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureReferenceParserRuleCall_4_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN, false));
		feeder.accept(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_6_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.DATA_RELATIONSHIP_TO_STRUCTURE__RANGE, false));
		feeder.finish();
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
	 *     (name=ID restrictedRange=[DataRange|Reference])
	 */
	protected void sequence_SynonymScalarRestriction(ISerializationContext context, SynonymScalarRestriction semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERM__NAME));
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TerminologyBoxAxiom returns TerminologyExtensionAxiom
	 *     TerminologyExtensionAxiom returns TerminologyExtensionAxiom
	 *
	 * Constraint:
	 *     extendedTerminology=[TerminologyBox|ExternalReference]
	 */
	protected void sequence_TerminologyExtensionAxiom(ISerializationContext context, TerminologyExtensionAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, TerminologiesPackage.Literals.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, TerminologiesPackage.Literals.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1(), semanticObject.eGet(TerminologiesPackage.Literals.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Module returns TerminologyGraph
	 *     TerminologyBox returns TerminologyGraph
	 *     TerminologyGraph returns TerminologyGraph
	 *
	 * Constraint:
	 *     (
	 *         annotations+=Annotation* 
	 *         kind=TerminologyKind 
	 *         iri=IRI 
	 *         (annotations+=Annotation | boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
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
	 *     (nestingTerminology=[TerminologyBox|ExternalReference] nestingContext=[Concept|Reference])
	 */
	protected void sequence_TerminologyNestingAxiom(ISerializationContext context, TerminologyNestingAxiom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, GraphsPackage.Literals.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, GraphsPackage.Literals.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY));
			if (transientValues.isValueTransient((EObject) semanticObject, GraphsPackage.Literals.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, GraphsPackage.Literals.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1(), semanticObject.eGet(GraphsPackage.Literals.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY, false));
		feeder.accept(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptReferenceParserRuleCall_5_0_1(), semanticObject.eGet(GraphsPackage.Literals.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT, false));
		feeder.finish();
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
	 *     (name=ID (minInclusive=STRING | maxInclusive=STRING | minExclusive=STRING | maxExclusive=STRING)* restrictedRange=[DataRange|Reference])
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
	 *         unreifiedRelationship=[UnreifiedRelationship|Reference] 
	 *         domain=[ConceptualEntitySingletonInstance|Reference] 
	 *         range=[ConceptualEntitySingletonInstance|Reference]
	 *     )
	 */
	protected void sequence_UnreifiedRelationshipInstanceTuple(ISerializationContext context, UnreifiedRelationshipInstanceTuple semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN));
			if (transientValues.isValueTransient((EObject) semanticObject, DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_3_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP, false));
		feeder.accept(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN, false));
		feeder.accept(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_7_0_1(), semanticObject.eGet(DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE, false));
		feeder.finish();
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
