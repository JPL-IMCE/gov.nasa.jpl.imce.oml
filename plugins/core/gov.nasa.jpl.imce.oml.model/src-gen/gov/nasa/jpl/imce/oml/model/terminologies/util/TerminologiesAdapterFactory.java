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
package gov.nasa.jpl.imce.oml.model.terminologies.util;

import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;
import gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;
import gov.nasa.jpl.imce.oml.model.common.NonCrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.Resource;
import gov.nasa.jpl.imce.oml.model.common.ValueCrossReferenceTuple;

import gov.nasa.jpl.imce.oml.model.terminologies.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
 * @generated
 */
public class TerminologiesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TerminologiesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologiesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TerminologiesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminologiesSwitch<Adapter> modelSwitch =
		new TerminologiesSwitch<Adapter>() {
			@Override
			public Adapter caseTerminologyBox(TerminologyBox object) {
				return createTerminologyBoxAdapter();
			}
			@Override
			public Adapter caseTerminologyBoxStatement(TerminologyBoxStatement object) {
				return createTerminologyBoxStatementAdapter();
			}
			@Override
			public Adapter caseTerminologyAxiom(TerminologyAxiom object) {
				return createTerminologyAxiomAdapter();
			}
			@Override
			public Adapter caseTerminologyBoxAxiom(TerminologyBoxAxiom object) {
				return createTerminologyBoxAxiomAdapter();
			}
			@Override
			public Adapter caseTerminologyExtensionAxiom(TerminologyExtensionAxiom object) {
				return createTerminologyExtensionAxiomAdapter();
			}
			@Override
			public Adapter caseTerm(Term object) {
				return createTermAdapter();
			}
			@Override
			public Adapter caseUnaryTermKind(UnaryTermKind object) {
				return createUnaryTermKindAdapter();
			}
			@Override
			public Adapter caseDirectedBinaryRelationshipKind(DirectedBinaryRelationshipKind object) {
				return createDirectedBinaryRelationshipKindAdapter();
			}
			@Override
			public Adapter casePredicate(Predicate object) {
				return createPredicateAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object) {
				return createEntityAdapter();
			}
			@Override
			public Adapter caseConceptualEntity(ConceptualEntity object) {
				return createConceptualEntityAdapter();
			}
			@Override
			public Adapter caseAspect(Aspect object) {
				return createAspectAdapter();
			}
			@Override
			public Adapter caseConcept(Concept object) {
				return createConceptAdapter();
			}
			@Override
			public Adapter caseEntityRelationship(EntityRelationship object) {
				return createEntityRelationshipAdapter();
			}
			@Override
			public Adapter caseCharacterizedEntityRelationship(CharacterizedEntityRelationship object) {
				return createCharacterizedEntityRelationshipAdapter();
			}
			@Override
			public Adapter caseRestrictableRelationship(RestrictableRelationship object) {
				return createRestrictableRelationshipAdapter();
			}
			@Override
			public Adapter caseForwardProperty(ForwardProperty object) {
				return createForwardPropertyAdapter();
			}
			@Override
			public Adapter caseInverseProperty(InverseProperty object) {
				return createInversePropertyAdapter();
			}
			@Override
			public Adapter caseConceptualRelationship(ConceptualRelationship object) {
				return createConceptualRelationshipAdapter();
			}
			@Override
			public Adapter caseReifiedRelationship(ReifiedRelationship object) {
				return createReifiedRelationshipAdapter();
			}
			@Override
			public Adapter caseSpecializedReifiedRelationship(SpecializedReifiedRelationship object) {
				return createSpecializedReifiedRelationshipAdapter();
			}
			@Override
			public Adapter caseUnreifiedRelationship(UnreifiedRelationship object) {
				return createUnreifiedRelationshipAdapter();
			}
			@Override
			public Adapter caseDatatype(Datatype object) {
				return createDatatypeAdapter();
			}
			@Override
			public Adapter caseDataRange(DataRange object) {
				return createDataRangeAdapter();
			}
			@Override
			public Adapter caseScalar(Scalar object) {
				return createScalarAdapter();
			}
			@Override
			public Adapter caseDataRelationship(DataRelationship object) {
				return createDataRelationshipAdapter();
			}
			@Override
			public Adapter caseDataRelationshipDomain(DataRelationshipDomain object) {
				return createDataRelationshipDomainAdapter();
			}
			@Override
			public Adapter caseDataRelationshipFromEntity(DataRelationshipFromEntity object) {
				return createDataRelationshipFromEntityAdapter();
			}
			@Override
			public Adapter caseDataRelationshipFromStructure(DataRelationshipFromStructure object) {
				return createDataRelationshipFromStructureAdapter();
			}
			@Override
			public Adapter caseDataRelationshipRange(DataRelationshipRange object) {
				return createDataRelationshipRangeAdapter();
			}
			@Override
			public Adapter caseDataRelationshipToScalar(DataRelationshipToScalar object) {
				return createDataRelationshipToScalarAdapter();
			}
			@Override
			public Adapter caseDataRelationshipToStructure(DataRelationshipToStructure object) {
				return createDataRelationshipToStructureAdapter();
			}
			@Override
			public Adapter caseEntityStructuredDataProperty(EntityStructuredDataProperty object) {
				return createEntityStructuredDataPropertyAdapter();
			}
			@Override
			public Adapter caseEntityScalarDataProperty(EntityScalarDataProperty object) {
				return createEntityScalarDataPropertyAdapter();
			}
			@Override
			public Adapter caseStructuredDataProperty(StructuredDataProperty object) {
				return createStructuredDataPropertyAdapter();
			}
			@Override
			public Adapter caseScalarDataProperty(ScalarDataProperty object) {
				return createScalarDataPropertyAdapter();
			}
			@Override
			public Adapter caseStructure(Structure object) {
				return createStructureAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseChainRule(ChainRule object) {
				return createChainRuleAdapter();
			}
			@Override
			public Adapter caseRuleBodySegment(RuleBodySegment object) {
				return createRuleBodySegmentAdapter();
			}
			@Override
			public Adapter caseSegmentPredicate(SegmentPredicate object) {
				return createSegmentPredicateAdapter();
			}
			@Override
			public Adapter caseTermAxiom(TermAxiom object) {
				return createTermAxiomAdapter();
			}
			@Override
			public Adapter caseEntityRestrictionAxiom(EntityRestrictionAxiom object) {
				return createEntityRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseEntityExistentialRestrictionAxiom(EntityExistentialRestrictionAxiom object) {
				return createEntityExistentialRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseEntityUniversalRestrictionAxiom(EntityUniversalRestrictionAxiom object) {
				return createEntityUniversalRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseSpecializationAxiom(SpecializationAxiom object) {
				return createSpecializationAxiomAdapter();
			}
			@Override
			public Adapter caseAspectSpecializationAxiom(AspectSpecializationAxiom object) {
				return createAspectSpecializationAxiomAdapter();
			}
			@Override
			public Adapter caseConceptSpecializationAxiom(ConceptSpecializationAxiom object) {
				return createConceptSpecializationAxiomAdapter();
			}
			@Override
			public Adapter caseSubObjectPropertyOfAxiom(SubObjectPropertyOfAxiom object) {
				return createSubObjectPropertyOfAxiomAdapter();
			}
			@Override
			public Adapter caseSubDataPropertyOfAxiom(SubDataPropertyOfAxiom object) {
				return createSubDataPropertyOfAxiomAdapter();
			}
			@Override
			public Adapter caseEntityScalarDataPropertyRestrictionAxiom(EntityScalarDataPropertyRestrictionAxiom object) {
				return createEntityScalarDataPropertyRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseEntityScalarDataPropertyExistentialRestrictionAxiom(EntityScalarDataPropertyExistentialRestrictionAxiom object) {
				return createEntityScalarDataPropertyExistentialRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseEntityScalarDataPropertyUniversalRestrictionAxiom(EntityScalarDataPropertyUniversalRestrictionAxiom object) {
				return createEntityScalarDataPropertyUniversalRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseEntityScalarDataPropertyParticularRestrictionAxiom(EntityScalarDataPropertyParticularRestrictionAxiom object) {
				return createEntityScalarDataPropertyParticularRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseEntityStructuredDataPropertyRestrictionAxiom(EntityStructuredDataPropertyRestrictionAxiom object) {
				return createEntityStructuredDataPropertyRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseEntityStructuredDataPropertyParticularRestrictionAxiom(EntityStructuredDataPropertyParticularRestrictionAxiom object) {
				return createEntityStructuredDataPropertyParticularRestrictionAxiomAdapter();
			}
			@Override
			public Adapter caseRestrictionStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext object) {
				return createRestrictionStructuredDataPropertyContextAdapter();
			}
			@Override
			public Adapter caseRestrictionStructuredDataPropertyTuple(RestrictionStructuredDataPropertyTuple object) {
				return createRestrictionStructuredDataPropertyTupleAdapter();
			}
			@Override
			public Adapter caseRestrictionScalarDataPropertyValue(RestrictionScalarDataPropertyValue object) {
				return createRestrictionScalarDataPropertyValueAdapter();
			}
			@Override
			public Adapter caseRestrictedDataRange(RestrictedDataRange object) {
				return createRestrictedDataRangeAdapter();
			}
			@Override
			public Adapter caseBinaryScalarRestriction(BinaryScalarRestriction object) {
				return createBinaryScalarRestrictionAdapter();
			}
			@Override
			public Adapter caseIRIScalarRestriction(IRIScalarRestriction object) {
				return createIRIScalarRestrictionAdapter();
			}
			@Override
			public Adapter caseNumericScalarRestriction(NumericScalarRestriction object) {
				return createNumericScalarRestrictionAdapter();
			}
			@Override
			public Adapter casePlainLiteralScalarRestriction(PlainLiteralScalarRestriction object) {
				return createPlainLiteralScalarRestrictionAdapter();
			}
			@Override
			public Adapter caseStringScalarRestriction(StringScalarRestriction object) {
				return createStringScalarRestrictionAdapter();
			}
			@Override
			public Adapter caseTimeScalarRestriction(TimeScalarRestriction object) {
				return createTimeScalarRestrictionAdapter();
			}
			@Override
			public Adapter caseSynonymScalarRestriction(SynonymScalarRestriction object) {
				return createSynonymScalarRestrictionAdapter();
			}
			@Override
			public Adapter caseScalarOneOfRestriction(ScalarOneOfRestriction object) {
				return createScalarOneOfRestrictionAdapter();
			}
			@Override
			public Adapter caseScalarOneOfLiteralAxiom(ScalarOneOfLiteralAxiom object) {
				return createScalarOneOfLiteralAxiomAdapter();
			}
			@Override
			public Adapter caseCrossReferencabilityKind(CrossReferencabilityKind object) {
				return createCrossReferencabilityKindAdapter();
			}
			@Override
			public Adapter caseIdentityKind(IdentityKind object) {
				return createIdentityKindAdapter();
			}
			@Override
			public Adapter caseLogicalElement(LogicalElement object) {
				return createLogicalElementAdapter();
			}
			@Override
			public Adapter caseCrossReferencableKind(CrossReferencableKind object) {
				return createCrossReferencableKindAdapter();
			}
			@Override
			public Adapter caseIntrinsicIdentityKind(IntrinsicIdentityKind object) {
				return createIntrinsicIdentityKindAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseModule(Module object) {
				return createModuleAdapter();
			}
			@Override
			public Adapter caseModuleElement(ModuleElement object) {
				return createModuleElementAdapter();
			}
			@Override
			public Adapter caseExtrinsicIdentityKind(ExtrinsicIdentityKind object) {
				return createExtrinsicIdentityKindAdapter();
			}
			@Override
			public Adapter caseElementCrossReferenceTuple(ElementCrossReferenceTuple object) {
				return createElementCrossReferenceTupleAdapter();
			}
			@Override
			public Adapter caseModuleEdge(ModuleEdge object) {
				return createModuleEdgeAdapter();
			}
			@Override
			public Adapter caseNonCrossReferencableKind(NonCrossReferencableKind object) {
				return createNonCrossReferencableKindAdapter();
			}
			@Override
			public Adapter caseValueCrossReferenceTuple(ValueCrossReferenceTuple object) {
				return createValueCrossReferenceTupleAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox <em>Terminology Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
	 * @generated
	 */
	public Adapter createTerminologyBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement <em>Terminology Box Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement
	 * @generated
	 */
	public Adapter createTerminologyBoxStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom <em>Terminology Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom
	 * @generated
	 */
	public Adapter createTerminologyAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom <em>Terminology Box Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom
	 * @generated
	 */
	public Adapter createTerminologyBoxAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom <em>Terminology Extension Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom
	 * @generated
	 */
	public Adapter createTerminologyExtensionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Term
	 * @generated
	 */
	public Adapter createTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.UnaryTermKind <em>Unary Term Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.UnaryTermKind
	 * @generated
	 */
	public Adapter createUnaryTermKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind <em>Directed Binary Relationship Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind
	 * @generated
	 */
	public Adapter createDirectedBinaryRelationshipKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Predicate
	 * @generated
	 */
	public Adapter createPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity <em>Conceptual Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity
	 * @generated
	 */
	public Adapter createConceptualEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Aspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Aspect
	 * @generated
	 */
	public Adapter createAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Concept
	 * @generated
	 */
	public Adapter createConceptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship <em>Entity Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
	 * @generated
	 */
	public Adapter createEntityRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship <em>Characterized Entity Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship
	 * @generated
	 */
	public Adapter createCharacterizedEntityRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship <em>Restrictable Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship
	 * @generated
	 */
	public Adapter createRestrictableRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty <em>Forward Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty
	 * @generated
	 */
	public Adapter createForwardPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty <em>Inverse Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty
	 * @generated
	 */
	public Adapter createInversePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship <em>Conceptual Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship
	 * @generated
	 */
	public Adapter createConceptualRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship <em>Reified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
	 * @generated
	 */
	public Adapter createReifiedRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.SpecializedReifiedRelationship <em>Specialized Reified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SpecializedReifiedRelationship
	 * @generated
	 */
	public Adapter createSpecializedReifiedRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship <em>Unreified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
	 * @generated
	 */
	public Adapter createUnreifiedRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Datatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Datatype
	 * @generated
	 */
	public Adapter createDatatypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRange <em>Data Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRange
	 * @generated
	 */
	public Adapter createDataRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Scalar <em>Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Scalar
	 * @generated
	 */
	public Adapter createScalarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship <em>Data Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship
	 * @generated
	 */
	public Adapter createDataRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipDomain <em>Data Relationship Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipDomain
	 * @generated
	 */
	public Adapter createDataRelationshipDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity <em>Data Relationship From Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity
	 * @generated
	 */
	public Adapter createDataRelationshipFromEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromStructure <em>Data Relationship From Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromStructure
	 * @generated
	 */
	public Adapter createDataRelationshipFromStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipRange <em>Data Relationship Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipRange
	 * @generated
	 */
	public Adapter createDataRelationshipRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar <em>Data Relationship To Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar
	 * @generated
	 */
	public Adapter createDataRelationshipToScalarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure <em>Data Relationship To Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure
	 * @generated
	 */
	public Adapter createDataRelationshipToStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty <em>Entity Structured Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
	 * @generated
	 */
	public Adapter createEntityStructuredDataPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty <em>Entity Scalar Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
	 * @generated
	 */
	public Adapter createEntityScalarDataPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty <em>Structured Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
	 * @generated
	 */
	public Adapter createStructuredDataPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty <em>Scalar Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
	 * @generated
	 */
	public Adapter createScalarDataPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Structure
	 * @generated
	 */
	public Adapter createStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ChainRule <em>Chain Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ChainRule
	 * @generated
	 */
	public Adapter createChainRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment <em>Rule Body Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment
	 * @generated
	 */
	public Adapter createRuleBodySegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate <em>Segment Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate
	 * @generated
	 */
	public Adapter createSegmentPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TermAxiom <em>Term Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TermAxiom
	 * @generated
	 */
	public Adapter createTermAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom <em>Entity Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom <em>Entity Existential Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityExistentialRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom <em>Entity Universal Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityUniversalRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom <em>Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
	 * @generated
	 */
	public Adapter createSpecializationAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom <em>Aspect Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
	 * @generated
	 */
	public Adapter createAspectSpecializationAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom <em>Concept Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
	 * @generated
	 */
	public Adapter createConceptSpecializationAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom <em>Sub Object Property Of Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom
	 * @generated
	 */
	public Adapter createSubObjectPropertyOfAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom <em>Sub Data Property Of Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom
	 * @generated
	 */
	public Adapter createSubDataPropertyOfAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom <em>Entity Scalar Data Property Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityScalarDataPropertyRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom <em>Entity Scalar Data Property Existential Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityScalarDataPropertyExistentialRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom <em>Entity Scalar Data Property Universal Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityScalarDataPropertyUniversalRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom <em>Entity Scalar Data Property Particular Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityScalarDataPropertyParticularRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyRestrictionAxiom <em>Entity Structured Data Property Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityStructuredDataPropertyRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom <em>Entity Structured Data Property Particular Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom
	 * @generated
	 */
	public Adapter createEntityStructuredDataPropertyParticularRestrictionAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext <em>Restriction Structured Data Property Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext
	 * @generated
	 */
	public Adapter createRestrictionStructuredDataPropertyContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple <em>Restriction Structured Data Property Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple
	 * @generated
	 */
	public Adapter createRestrictionStructuredDataPropertyTupleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue <em>Restriction Scalar Data Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue
	 * @generated
	 */
	public Adapter createRestrictionScalarDataPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange <em>Restricted Data Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange
	 * @generated
	 */
	public Adapter createRestrictedDataRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction <em>Binary Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
	 * @generated
	 */
	public Adapter createBinaryScalarRestrictionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction <em>IRI Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
	 * @generated
	 */
	public Adapter createIRIScalarRestrictionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction <em>Numeric Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
	 * @generated
	 */
	public Adapter createNumericScalarRestrictionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction <em>Plain Literal Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
	 * @generated
	 */
	public Adapter createPlainLiteralScalarRestrictionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction <em>String Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
	 * @generated
	 */
	public Adapter createStringScalarRestrictionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction <em>Time Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
	 * @generated
	 */
	public Adapter createTimeScalarRestrictionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction <em>Synonym Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
	 * @generated
	 */
	public Adapter createSynonymScalarRestrictionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction <em>Scalar One Of Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
	 * @generated
	 */
	public Adapter createScalarOneOfRestrictionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom <em>Scalar One Of Literal Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
	 * @generated
	 */
	public Adapter createScalarOneOfLiteralAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind <em>Cross Referencability Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind
	 * @generated
	 */
	public Adapter createCrossReferencabilityKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.IdentityKind <em>Identity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.IdentityKind
	 * @generated
	 */
	public Adapter createIdentityKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LogicalElement <em>Logical Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LogicalElement
	 * @generated
	 */
	public Adapter createLogicalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind <em>Cross Referencable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind
	 * @generated
	 */
	public Adapter createCrossReferencableKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind <em>Intrinsic Identity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind
	 * @generated
	 */
	public Adapter createIntrinsicIdentityKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module
	 * @generated
	 */
	public Adapter createModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ModuleElement <em>Module Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleElement
	 * @generated
	 */
	public Adapter createModuleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind <em>Extrinsic Identity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind
	 * @generated
	 */
	public Adapter createExtrinsicIdentityKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple <em>Element Cross Reference Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple
	 * @generated
	 */
	public Adapter createElementCrossReferenceTupleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ModuleEdge <em>Module Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleEdge
	 * @generated
	 */
	public Adapter createModuleEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.NonCrossReferencableKind <em>Non Cross Referencable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.NonCrossReferencableKind
	 * @generated
	 */
	public Adapter createNonCrossReferencableKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ValueCrossReferenceTuple <em>Value Cross Reference Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ValueCrossReferenceTuple
	 * @generated
	 */
	public Adapter createValueCrossReferenceTupleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TerminologiesAdapterFactory
