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
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.terminologies.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TerminologiesFactoryImpl extends EFactoryImpl implements TerminologiesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TerminologiesFactory init() {
		try {
			TerminologiesFactory theTerminologiesFactory = (TerminologiesFactory)EPackage.Registry.INSTANCE.getEFactory(TerminologiesPackage.eNS_URI);
			if (theTerminologiesFactory != null) {
				return theTerminologiesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TerminologiesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologiesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM: return (EObject)createTerminologyExtensionAxiom();
			case TerminologiesPackage.ASPECT: return (EObject)createAspect();
			case TerminologiesPackage.CONCEPT: return (EObject)createConcept();
			case TerminologiesPackage.FORWARD_PROPERTY: return (EObject)createForwardProperty();
			case TerminologiesPackage.INVERSE_PROPERTY: return (EObject)createInverseProperty();
			case TerminologiesPackage.REIFIED_RELATIONSHIP: return (EObject)createReifiedRelationship();
			case TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP: return (EObject)createSpecializedReifiedRelationship();
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP: return (EObject)createUnreifiedRelationship();
			case TerminologiesPackage.SCALAR: return (EObject)createScalar();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY: return (EObject)createEntityStructuredDataProperty();
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY: return (EObject)createEntityScalarDataProperty();
			case TerminologiesPackage.STRUCTURED_DATA_PROPERTY: return (EObject)createStructuredDataProperty();
			case TerminologiesPackage.SCALAR_DATA_PROPERTY: return (EObject)createScalarDataProperty();
			case TerminologiesPackage.STRUCTURE: return (EObject)createStructure();
			case TerminologiesPackage.CHAIN_RULE: return (EObject)createChainRule();
			case TerminologiesPackage.RULE_BODY_SEGMENT: return (EObject)createRuleBodySegment();
			case TerminologiesPackage.SEGMENT_PREDICATE: return (EObject)createSegmentPredicate();
			case TerminologiesPackage.ENTITY_EXISTENTIAL_RESTRICTION_AXIOM: return (EObject)createEntityExistentialRestrictionAxiom();
			case TerminologiesPackage.ENTITY_UNIVERSAL_RESTRICTION_AXIOM: return (EObject)createEntityUniversalRestrictionAxiom();
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM: return (EObject)createAspectSpecializationAxiom();
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM: return (EObject)createConceptSpecializationAxiom();
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM: return (EObject)createSubObjectPropertyOfAxiom();
			case TerminologiesPackage.SUB_DATA_PROPERTY_OF_AXIOM: return (EObject)createSubDataPropertyOfAxiom();
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM: return (EObject)createEntityScalarDataPropertyExistentialRestrictionAxiom();
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM: return (EObject)createEntityScalarDataPropertyUniversalRestrictionAxiom();
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM: return (EObject)createEntityScalarDataPropertyParticularRestrictionAxiom();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM: return (EObject)createEntityStructuredDataPropertyParticularRestrictionAxiom();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE: return (EObject)createRestrictionStructuredDataPropertyTuple();
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE: return (EObject)createRestrictionScalarDataPropertyValue();
			case TerminologiesPackage.BINARY_SCALAR_RESTRICTION: return (EObject)createBinaryScalarRestriction();
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION: return (EObject)createIRIScalarRestriction();
			case TerminologiesPackage.NUMERIC_SCALAR_RESTRICTION: return (EObject)createNumericScalarRestriction();
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION: return (EObject)createPlainLiteralScalarRestriction();
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION: return (EObject)createStringScalarRestriction();
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION: return (EObject)createTimeScalarRestriction();
			case TerminologiesPackage.SYNONYM_SCALAR_RESTRICTION: return (EObject)createSynonymScalarRestriction();
			case TerminologiesPackage.SCALAR_ONE_OF_RESTRICTION: return (EObject)createScalarOneOfRestriction();
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM: return (EObject)createScalarOneOfLiteralAxiom();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TerminologiesPackage.TERMINOLOGY_KIND:
				return createTerminologyKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TerminologiesPackage.TERMINOLOGY_KIND:
				return convertTerminologyKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyExtensionAxiom createTerminologyExtensionAxiom() {
		TerminologyExtensionAxiomImpl terminologyExtensionAxiom = new TerminologyExtensionAxiomImpl();
		return terminologyExtensionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aspect createAspect() {
		AspectImpl aspect = new AspectImpl();
		return aspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept createConcept() {
		ConceptImpl concept = new ConceptImpl();
		return concept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardProperty createForwardProperty() {
		ForwardPropertyImpl forwardProperty = new ForwardPropertyImpl();
		return forwardProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseProperty createInverseProperty() {
		InversePropertyImpl inverseProperty = new InversePropertyImpl();
		return inverseProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship createReifiedRelationship() {
		ReifiedRelationshipImpl reifiedRelationship = new ReifiedRelationshipImpl();
		return reifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializedReifiedRelationship createSpecializedReifiedRelationship() {
		SpecializedReifiedRelationshipImpl specializedReifiedRelationship = new SpecializedReifiedRelationshipImpl();
		return specializedReifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship createUnreifiedRelationship() {
		UnreifiedRelationshipImpl unreifiedRelationship = new UnreifiedRelationshipImpl();
		return unreifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scalar createScalar() {
		ScalarImpl scalar = new ScalarImpl();
		return scalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityStructuredDataProperty createEntityStructuredDataProperty() {
		EntityStructuredDataPropertyImpl entityStructuredDataProperty = new EntityStructuredDataPropertyImpl();
		return entityStructuredDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityScalarDataProperty createEntityScalarDataProperty() {
		EntityScalarDataPropertyImpl entityScalarDataProperty = new EntityScalarDataPropertyImpl();
		return entityScalarDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredDataProperty createStructuredDataProperty() {
		StructuredDataPropertyImpl structuredDataProperty = new StructuredDataPropertyImpl();
		return structuredDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarDataProperty createScalarDataProperty() {
		ScalarDataPropertyImpl scalarDataProperty = new ScalarDataPropertyImpl();
		return scalarDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure createStructure() {
		StructureImpl structure = new StructureImpl();
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChainRule createChainRule() {
		ChainRuleImpl chainRule = new ChainRuleImpl();
		return chainRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBodySegment createRuleBodySegment() {
		RuleBodySegmentImpl ruleBodySegment = new RuleBodySegmentImpl();
		return ruleBodySegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SegmentPredicate createSegmentPredicate() {
		SegmentPredicateImpl segmentPredicate = new SegmentPredicateImpl();
		return segmentPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityExistentialRestrictionAxiom createEntityExistentialRestrictionAxiom() {
		EntityExistentialRestrictionAxiomImpl entityExistentialRestrictionAxiom = new EntityExistentialRestrictionAxiomImpl();
		return entityExistentialRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityUniversalRestrictionAxiom createEntityUniversalRestrictionAxiom() {
		EntityUniversalRestrictionAxiomImpl entityUniversalRestrictionAxiom = new EntityUniversalRestrictionAxiomImpl();
		return entityUniversalRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AspectSpecializationAxiom createAspectSpecializationAxiom() {
		AspectSpecializationAxiomImpl aspectSpecializationAxiom = new AspectSpecializationAxiomImpl();
		return aspectSpecializationAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptSpecializationAxiom createConceptSpecializationAxiom() {
		ConceptSpecializationAxiomImpl conceptSpecializationAxiom = new ConceptSpecializationAxiomImpl();
		return conceptSpecializationAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubObjectPropertyOfAxiom createSubObjectPropertyOfAxiom() {
		SubObjectPropertyOfAxiomImpl subObjectPropertyOfAxiom = new SubObjectPropertyOfAxiomImpl();
		return subObjectPropertyOfAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubDataPropertyOfAxiom createSubDataPropertyOfAxiom() {
		SubDataPropertyOfAxiomImpl subDataPropertyOfAxiom = new SubDataPropertyOfAxiomImpl();
		return subDataPropertyOfAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityScalarDataPropertyExistentialRestrictionAxiom createEntityScalarDataPropertyExistentialRestrictionAxiom() {
		EntityScalarDataPropertyExistentialRestrictionAxiomImpl entityScalarDataPropertyExistentialRestrictionAxiom = new EntityScalarDataPropertyExistentialRestrictionAxiomImpl();
		return entityScalarDataPropertyExistentialRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityScalarDataPropertyUniversalRestrictionAxiom createEntityScalarDataPropertyUniversalRestrictionAxiom() {
		EntityScalarDataPropertyUniversalRestrictionAxiomImpl entityScalarDataPropertyUniversalRestrictionAxiom = new EntityScalarDataPropertyUniversalRestrictionAxiomImpl();
		return entityScalarDataPropertyUniversalRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityScalarDataPropertyParticularRestrictionAxiom createEntityScalarDataPropertyParticularRestrictionAxiom() {
		EntityScalarDataPropertyParticularRestrictionAxiomImpl entityScalarDataPropertyParticularRestrictionAxiom = new EntityScalarDataPropertyParticularRestrictionAxiomImpl();
		return entityScalarDataPropertyParticularRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityStructuredDataPropertyParticularRestrictionAxiom createEntityStructuredDataPropertyParticularRestrictionAxiom() {
		EntityStructuredDataPropertyParticularRestrictionAxiomImpl entityStructuredDataPropertyParticularRestrictionAxiom = new EntityStructuredDataPropertyParticularRestrictionAxiomImpl();
		return entityStructuredDataPropertyParticularRestrictionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestrictionStructuredDataPropertyTuple createRestrictionStructuredDataPropertyTuple() {
		RestrictionStructuredDataPropertyTupleImpl restrictionStructuredDataPropertyTuple = new RestrictionStructuredDataPropertyTupleImpl();
		return restrictionStructuredDataPropertyTuple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestrictionScalarDataPropertyValue createRestrictionScalarDataPropertyValue() {
		RestrictionScalarDataPropertyValueImpl restrictionScalarDataPropertyValue = new RestrictionScalarDataPropertyValueImpl();
		return restrictionScalarDataPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryScalarRestriction createBinaryScalarRestriction() {
		BinaryScalarRestrictionImpl binaryScalarRestriction = new BinaryScalarRestrictionImpl();
		return binaryScalarRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRIScalarRestriction createIRIScalarRestriction() {
		IRIScalarRestrictionImpl iriScalarRestriction = new IRIScalarRestrictionImpl();
		return iriScalarRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericScalarRestriction createNumericScalarRestriction() {
		NumericScalarRestrictionImpl numericScalarRestriction = new NumericScalarRestrictionImpl();
		return numericScalarRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlainLiteralScalarRestriction createPlainLiteralScalarRestriction() {
		PlainLiteralScalarRestrictionImpl plainLiteralScalarRestriction = new PlainLiteralScalarRestrictionImpl();
		return plainLiteralScalarRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringScalarRestriction createStringScalarRestriction() {
		StringScalarRestrictionImpl stringScalarRestriction = new StringScalarRestrictionImpl();
		return stringScalarRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeScalarRestriction createTimeScalarRestriction() {
		TimeScalarRestrictionImpl timeScalarRestriction = new TimeScalarRestrictionImpl();
		return timeScalarRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynonymScalarRestriction createSynonymScalarRestriction() {
		SynonymScalarRestrictionImpl synonymScalarRestriction = new SynonymScalarRestrictionImpl();
		return synonymScalarRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarOneOfRestriction createScalarOneOfRestriction() {
		ScalarOneOfRestrictionImpl scalarOneOfRestriction = new ScalarOneOfRestrictionImpl();
		return scalarOneOfRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarOneOfLiteralAxiom createScalarOneOfLiteralAxiom() {
		ScalarOneOfLiteralAxiomImpl scalarOneOfLiteralAxiom = new ScalarOneOfLiteralAxiomImpl();
		return scalarOneOfLiteralAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyKind createTerminologyKindFromString(EDataType eDataType, String initialValue) {
		TerminologyKind result = TerminologyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTerminologyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologiesPackage getTerminologiesPackage() {
		return (TerminologiesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TerminologiesPackage getPackage() {
		return TerminologiesPackage.eINSTANCE;
	}

} //TerminologiesFactoryImpl
