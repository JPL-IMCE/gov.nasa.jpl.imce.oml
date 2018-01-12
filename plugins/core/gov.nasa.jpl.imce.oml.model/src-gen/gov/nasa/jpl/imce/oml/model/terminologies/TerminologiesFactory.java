/**
 * 
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
 * @generated
 */
public interface TerminologiesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TerminologiesFactory eINSTANCE = gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Terminology Extension Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminology Extension Axiom</em>'.
	 * @generated
	 */
	TerminologyExtensionAxiom createTerminologyExtensionAxiom();

	/**
	 * Returns a new object of class '<em>Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aspect</em>'.
	 * @generated
	 */
	Aspect createAspect();

	/**
	 * Returns a new object of class '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept</em>'.
	 * @generated
	 */
	Concept createConcept();

	/**
	 * Returns a new object of class '<em>Forward Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forward Property</em>'.
	 * @generated
	 */
	ForwardProperty createForwardProperty();

	/**
	 * Returns a new object of class '<em>Inverse Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inverse Property</em>'.
	 * @generated
	 */
	InverseProperty createInverseProperty();

	/**
	 * Returns a new object of class '<em>Reified Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship</em>'.
	 * @generated
	 */
	ReifiedRelationship createReifiedRelationship();

	/**
	 * Returns a new object of class '<em>Unreified Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unreified Relationship</em>'.
	 * @generated
	 */
	UnreifiedRelationship createUnreifiedRelationship();

	/**
	 * Returns a new object of class '<em>Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar</em>'.
	 * @generated
	 */
	Scalar createScalar();

	/**
	 * Returns a new object of class '<em>Entity Structured Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Structured Data Property</em>'.
	 * @generated
	 */
	EntityStructuredDataProperty createEntityStructuredDataProperty();

	/**
	 * Returns a new object of class '<em>Entity Scalar Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Scalar Data Property</em>'.
	 * @generated
	 */
	EntityScalarDataProperty createEntityScalarDataProperty();

	/**
	 * Returns a new object of class '<em>Structured Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Data Property</em>'.
	 * @generated
	 */
	StructuredDataProperty createStructuredDataProperty();

	/**
	 * Returns a new object of class '<em>Scalar Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Data Property</em>'.
	 * @generated
	 */
	ScalarDataProperty createScalarDataProperty();

	/**
	 * Returns a new object of class '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure</em>'.
	 * @generated
	 */
	Structure createStructure();

	/**
	 * Returns a new object of class '<em>Chain Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Chain Rule</em>'.
	 * @generated
	 */
	ChainRule createChainRule();

	/**
	 * Returns a new object of class '<em>Rule Body Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Body Segment</em>'.
	 * @generated
	 */
	RuleBodySegment createRuleBodySegment();

	/**
	 * Returns a new object of class '<em>Aspect Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aspect Predicate</em>'.
	 * @generated
	 */
	AspectPredicate createAspectPredicate();

	/**
	 * Returns a new object of class '<em>Concept Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept Predicate</em>'.
	 * @generated
	 */
	ConceptPredicate createConceptPredicate();

	/**
	 * Returns a new object of class '<em>Reified Relationship Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Predicate</em>'.
	 * @generated
	 */
	ReifiedRelationshipPredicate createReifiedRelationshipPredicate();

	/**
	 * Returns a new object of class '<em>Reified Relationship Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Property Predicate</em>'.
	 * @generated
	 */
	ReifiedRelationshipPropertyPredicate createReifiedRelationshipPropertyPredicate();

	/**
	 * Returns a new object of class '<em>Reified Relationship Inverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Inverse Property Predicate</em>'.
	 * @generated
	 */
	ReifiedRelationshipInversePropertyPredicate createReifiedRelationshipInversePropertyPredicate();

	/**
	 * Returns a new object of class '<em>Reified Relationship Source Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Source Property Predicate</em>'.
	 * @generated
	 */
	ReifiedRelationshipSourcePropertyPredicate createReifiedRelationshipSourcePropertyPredicate();

	/**
	 * Returns a new object of class '<em>Reified Relationship Source Inverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Source Inverse Property Predicate</em>'.
	 * @generated
	 */
	ReifiedRelationshipSourceInversePropertyPredicate createReifiedRelationshipSourceInversePropertyPredicate();

	/**
	 * Returns a new object of class '<em>Reified Relationship Target Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Target Property Predicate</em>'.
	 * @generated
	 */
	ReifiedRelationshipTargetPropertyPredicate createReifiedRelationshipTargetPropertyPredicate();

	/**
	 * Returns a new object of class '<em>Reified Relationship Target Inverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Target Inverse Property Predicate</em>'.
	 * @generated
	 */
	ReifiedRelationshipTargetInversePropertyPredicate createReifiedRelationshipTargetInversePropertyPredicate();

	/**
	 * Returns a new object of class '<em>Unreified Relationship Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unreified Relationship Property Predicate</em>'.
	 * @generated
	 */
	UnreifiedRelationshipPropertyPredicate createUnreifiedRelationshipPropertyPredicate();

	/**
	 * Returns a new object of class '<em>Unreified Relationship Inverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unreified Relationship Inverse Property Predicate</em>'.
	 * @generated
	 */
	UnreifiedRelationshipInversePropertyPredicate createUnreifiedRelationshipInversePropertyPredicate();

	/**
	 * Returns a new object of class '<em>Entity Existential Forward Reified Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Existential Forward Reified Restriction Axiom</em>'.
	 * @generated
	 */
	EntityExistentialForwardReifiedRestrictionAxiom createEntityExistentialForwardReifiedRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Entity Existential Inverse Reified Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Existential Inverse Reified Restriction Axiom</em>'.
	 * @generated
	 */
	EntityExistentialInverseReifiedRestrictionAxiom createEntityExistentialInverseReifiedRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Entity Existential Unreified Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Existential Unreified Restriction Axiom</em>'.
	 * @generated
	 */
	EntityExistentialUnreifiedRestrictionAxiom createEntityExistentialUnreifiedRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Entity Universal Forward Reified Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Universal Forward Reified Restriction Axiom</em>'.
	 * @generated
	 */
	EntityUniversalForwardReifiedRestrictionAxiom createEntityUniversalForwardReifiedRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Entity Universal Inverse Reified Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Universal Inverse Reified Restriction Axiom</em>'.
	 * @generated
	 */
	EntityUniversalInverseReifiedRestrictionAxiom createEntityUniversalInverseReifiedRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Entity Universal Unreified Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Universal Unreified Restriction Axiom</em>'.
	 * @generated
	 */
	EntityUniversalUnreifiedRestrictionAxiom createEntityUniversalUnreifiedRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Aspect Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aspect Specialization Axiom</em>'.
	 * @generated
	 */
	AspectSpecializationAxiom createAspectSpecializationAxiom();

	/**
	 * Returns a new object of class '<em>Concept Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept Specialization Axiom</em>'.
	 * @generated
	 */
	ConceptSpecializationAxiom createConceptSpecializationAxiom();

	/**
	 * Returns a new object of class '<em>Reified Relationship Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Specialization Axiom</em>'.
	 * @generated
	 */
	ReifiedRelationshipSpecializationAxiom createReifiedRelationshipSpecializationAxiom();

	/**
	 * Returns a new object of class '<em>Sub Object Property Of Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Object Property Of Axiom</em>'.
	 * @generated
	 */
	SubObjectPropertyOfAxiom createSubObjectPropertyOfAxiom();

	/**
	 * Returns a new object of class '<em>Sub Data Property Of Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Data Property Of Axiom</em>'.
	 * @generated
	 */
	SubDataPropertyOfAxiom createSubDataPropertyOfAxiom();

	/**
	 * Returns a new object of class '<em>Entity Scalar Data Property Existential Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Scalar Data Property Existential Restriction Axiom</em>'.
	 * @generated
	 */
	EntityScalarDataPropertyExistentialRestrictionAxiom createEntityScalarDataPropertyExistentialRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Entity Scalar Data Property Universal Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Scalar Data Property Universal Restriction Axiom</em>'.
	 * @generated
	 */
	EntityScalarDataPropertyUniversalRestrictionAxiom createEntityScalarDataPropertyUniversalRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Entity Scalar Data Property Particular Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Scalar Data Property Particular Restriction Axiom</em>'.
	 * @generated
	 */
	EntityScalarDataPropertyParticularRestrictionAxiom createEntityScalarDataPropertyParticularRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Entity Structured Data Property Particular Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Structured Data Property Particular Restriction Axiom</em>'.
	 * @generated
	 */
	EntityStructuredDataPropertyParticularRestrictionAxiom createEntityStructuredDataPropertyParticularRestrictionAxiom();

	/**
	 * Returns a new object of class '<em>Restriction Structured Data Property Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Restriction Structured Data Property Tuple</em>'.
	 * @generated
	 */
	RestrictionStructuredDataPropertyTuple createRestrictionStructuredDataPropertyTuple();

	/**
	 * Returns a new object of class '<em>Restriction Scalar Data Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Restriction Scalar Data Property Value</em>'.
	 * @generated
	 */
	RestrictionScalarDataPropertyValue createRestrictionScalarDataPropertyValue();

	/**
	 * Returns a new object of class '<em>Binary Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Scalar Restriction</em>'.
	 * @generated
	 */
	BinaryScalarRestriction createBinaryScalarRestriction();

	/**
	 * Returns a new object of class '<em>IRI Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IRI Scalar Restriction</em>'.
	 * @generated
	 */
	IRIScalarRestriction createIRIScalarRestriction();

	/**
	 * Returns a new object of class '<em>Numeric Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Scalar Restriction</em>'.
	 * @generated
	 */
	NumericScalarRestriction createNumericScalarRestriction();

	/**
	 * Returns a new object of class '<em>Plain Literal Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plain Literal Scalar Restriction</em>'.
	 * @generated
	 */
	PlainLiteralScalarRestriction createPlainLiteralScalarRestriction();

	/**
	 * Returns a new object of class '<em>String Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Scalar Restriction</em>'.
	 * @generated
	 */
	StringScalarRestriction createStringScalarRestriction();

	/**
	 * Returns a new object of class '<em>Time Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Scalar Restriction</em>'.
	 * @generated
	 */
	TimeScalarRestriction createTimeScalarRestriction();

	/**
	 * Returns a new object of class '<em>Synonym Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Synonym Scalar Restriction</em>'.
	 * @generated
	 */
	SynonymScalarRestriction createSynonymScalarRestriction();

	/**
	 * Returns a new object of class '<em>Scalar One Of Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar One Of Restriction</em>'.
	 * @generated
	 */
	ScalarOneOfRestriction createScalarOneOfRestriction();

	/**
	 * Returns a new object of class '<em>Scalar One Of Literal Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar One Of Literal Axiom</em>'.
	 * @generated
	 */
	ScalarOneOfLiteralAxiom createScalarOneOfLiteralAxiom();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TerminologiesPackage getTerminologiesPackage();

} //TerminologiesFactory
