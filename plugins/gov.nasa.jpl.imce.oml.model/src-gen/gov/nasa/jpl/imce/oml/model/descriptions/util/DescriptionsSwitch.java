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
package gov.nasa.jpl.imce.oml.model.descriptions.util;

import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;
import gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;
import gov.nasa.jpl.imce.oml.model.common.NonCrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.Resource;
import gov.nasa.jpl.imce.oml.model.common.ValueCrossReferenceTuple;

import gov.nasa.jpl.imce.oml.model.descriptions.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage
 * @generated
 */
public class DescriptionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DescriptionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionsSwitch() {
		if (modelPackage == null) {
			modelPackage = DescriptionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DescriptionsPackage.DESCRIPTION_BOX: {
				DescriptionBox descriptionBox = (DescriptionBox)theEObject;
				T result = caseDescriptionBox(descriptionBox);
				if (result == null) result = caseModule(descriptionBox);
				if (result == null) result = caseResource(descriptionBox);
				if (result == null) result = caseLogicalElement(descriptionBox);
				if (result == null) result = caseIntrinsicIdentityKind(descriptionBox);
				if (result == null) result = caseIdentityKind(descriptionBox);
				if (result == null) result = caseCrossReferencableKind(descriptionBox);
				if (result == null) result = caseCrossReferencabilityKind(descriptionBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.DESCRIPTION_BOX_RELATIONSHIP: {
				DescriptionBoxRelationship descriptionBoxRelationship = (DescriptionBoxRelationship)theEObject;
				T result = caseDescriptionBoxRelationship(descriptionBoxRelationship);
				if (result == null) result = caseModuleEdge(descriptionBoxRelationship);
				if (result == null) result = caseElementCrossReferenceTuple(descriptionBoxRelationship);
				if (result == null) result = caseExtrinsicIdentityKind(descriptionBoxRelationship);
				if (result == null) result = caseCrossReferencableKind(descriptionBoxRelationship);
				if (result == null) result = caseLogicalElement(descriptionBoxRelationship);
				if (result == null) result = caseIdentityKind(descriptionBoxRelationship);
				if (result == null) result = caseCrossReferencabilityKind(descriptionBoxRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS: {
				DescriptionBoxExtendsClosedWorldDefinitions descriptionBoxExtendsClosedWorldDefinitions = (DescriptionBoxExtendsClosedWorldDefinitions)theEObject;
				T result = caseDescriptionBoxExtendsClosedWorldDefinitions(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = caseDescriptionBoxRelationship(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = caseModuleEdge(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = caseElementCrossReferenceTuple(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = caseExtrinsicIdentityKind(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = caseCrossReferencableKind(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = caseLogicalElement(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = caseIdentityKind(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = caseCrossReferencabilityKind(descriptionBoxExtendsClosedWorldDefinitions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT: {
				DescriptionBoxRefinement descriptionBoxRefinement = (DescriptionBoxRefinement)theEObject;
				T result = caseDescriptionBoxRefinement(descriptionBoxRefinement);
				if (result == null) result = caseDescriptionBoxRelationship(descriptionBoxRefinement);
				if (result == null) result = caseModuleEdge(descriptionBoxRefinement);
				if (result == null) result = caseElementCrossReferenceTuple(descriptionBoxRefinement);
				if (result == null) result = caseExtrinsicIdentityKind(descriptionBoxRefinement);
				if (result == null) result = caseCrossReferencableKind(descriptionBoxRefinement);
				if (result == null) result = caseLogicalElement(descriptionBoxRefinement);
				if (result == null) result = caseIdentityKind(descriptionBoxRefinement);
				if (result == null) result = caseCrossReferencabilityKind(descriptionBoxRefinement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.TERMINOLOGY_INSTANCE_ASSERTION: {
				TerminologyInstanceAssertion terminologyInstanceAssertion = (TerminologyInstanceAssertion)theEObject;
				T result = caseTerminologyInstanceAssertion(terminologyInstanceAssertion);
				if (result == null) result = caseModuleElement(terminologyInstanceAssertion);
				if (result == null) result = caseLogicalElement(terminologyInstanceAssertion);
				if (result == null) result = caseIdentityKind(terminologyInstanceAssertion);
				if (result == null) result = caseCrossReferencabilityKind(terminologyInstanceAssertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE: {
				SingletonInstanceScalarDataPropertyValue singletonInstanceScalarDataPropertyValue = (SingletonInstanceScalarDataPropertyValue)theEObject;
				T result = caseSingletonInstanceScalarDataPropertyValue(singletonInstanceScalarDataPropertyValue);
				if (result == null) result = caseModuleElement(singletonInstanceScalarDataPropertyValue);
				if (result == null) result = caseValueCrossReferenceTuple(singletonInstanceScalarDataPropertyValue);
				if (result == null) result = caseLogicalElement(singletonInstanceScalarDataPropertyValue);
				if (result == null) result = caseExtrinsicIdentityKind(singletonInstanceScalarDataPropertyValue);
				if (result == null) result = caseNonCrossReferencableKind(singletonInstanceScalarDataPropertyValue);
				if (result == null) result = caseIdentityKind(singletonInstanceScalarDataPropertyValue);
				if (result == null) result = caseCrossReferencabilityKind(singletonInstanceScalarDataPropertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT: {
				SingletonInstanceStructuredDataPropertyContext singletonInstanceStructuredDataPropertyContext = (SingletonInstanceStructuredDataPropertyContext)theEObject;
				T result = caseSingletonInstanceStructuredDataPropertyContext(singletonInstanceStructuredDataPropertyContext);
				if (result == null) result = caseElementCrossReferenceTuple(singletonInstanceStructuredDataPropertyContext);
				if (result == null) result = caseExtrinsicIdentityKind(singletonInstanceStructuredDataPropertyContext);
				if (result == null) result = caseCrossReferencableKind(singletonInstanceStructuredDataPropertyContext);
				if (result == null) result = caseLogicalElement(singletonInstanceStructuredDataPropertyContext);
				if (result == null) result = caseIdentityKind(singletonInstanceStructuredDataPropertyContext);
				if (result == null) result = caseCrossReferencabilityKind(singletonInstanceStructuredDataPropertyContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE: {
				SingletonInstanceStructuredDataPropertyValue singletonInstanceStructuredDataPropertyValue = (SingletonInstanceStructuredDataPropertyValue)theEObject;
				T result = caseSingletonInstanceStructuredDataPropertyValue(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = caseSingletonInstanceStructuredDataPropertyContext(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = caseModuleElement(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = caseElementCrossReferenceTuple(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = caseExtrinsicIdentityKind(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = caseCrossReferencableKind(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = caseLogicalElement(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = caseIdentityKind(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = caseCrossReferencabilityKind(singletonInstanceStructuredDataPropertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.STRUCTURED_DATA_PROPERTY_TUPLE: {
				StructuredDataPropertyTuple structuredDataPropertyTuple = (StructuredDataPropertyTuple)theEObject;
				T result = caseStructuredDataPropertyTuple(structuredDataPropertyTuple);
				if (result == null) result = caseSingletonInstanceStructuredDataPropertyContext(structuredDataPropertyTuple);
				if (result == null) result = caseElementCrossReferenceTuple(structuredDataPropertyTuple);
				if (result == null) result = caseExtrinsicIdentityKind(structuredDataPropertyTuple);
				if (result == null) result = caseCrossReferencableKind(structuredDataPropertyTuple);
				if (result == null) result = caseLogicalElement(structuredDataPropertyTuple);
				if (result == null) result = caseIdentityKind(structuredDataPropertyTuple);
				if (result == null) result = caseCrossReferencabilityKind(structuredDataPropertyTuple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.SCALAR_DATA_PROPERTY_VALUE: {
				ScalarDataPropertyValue scalarDataPropertyValue = (ScalarDataPropertyValue)theEObject;
				T result = caseScalarDataPropertyValue(scalarDataPropertyValue);
				if (result == null) result = caseLogicalElement(scalarDataPropertyValue);
				if (result == null) result = caseValueCrossReferenceTuple(scalarDataPropertyValue);
				if (result == null) result = caseExtrinsicIdentityKind(scalarDataPropertyValue);
				if (result == null) result = caseNonCrossReferencableKind(scalarDataPropertyValue);
				if (result == null) result = caseIdentityKind(scalarDataPropertyValue);
				if (result == null) result = caseCrossReferencabilityKind(scalarDataPropertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.CONCEPTUAL_ENTITY_SINGLETON_INSTANCE: {
				ConceptualEntitySingletonInstance conceptualEntitySingletonInstance = (ConceptualEntitySingletonInstance)theEObject;
				T result = caseConceptualEntitySingletonInstance(conceptualEntitySingletonInstance);
				if (result == null) result = caseTerminologyInstanceAssertion(conceptualEntitySingletonInstance);
				if (result == null) result = caseResource(conceptualEntitySingletonInstance);
				if (result == null) result = caseModuleElement(conceptualEntitySingletonInstance);
				if (result == null) result = caseIntrinsicIdentityKind(conceptualEntitySingletonInstance);
				if (result == null) result = caseLogicalElement(conceptualEntitySingletonInstance);
				if (result == null) result = caseCrossReferencableKind(conceptualEntitySingletonInstance);
				if (result == null) result = caseIdentityKind(conceptualEntitySingletonInstance);
				if (result == null) result = caseCrossReferencabilityKind(conceptualEntitySingletonInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.CONCEPT_INSTANCE: {
				ConceptInstance conceptInstance = (ConceptInstance)theEObject;
				T result = caseConceptInstance(conceptInstance);
				if (result == null) result = caseConceptualEntitySingletonInstance(conceptInstance);
				if (result == null) result = caseTerminologyInstanceAssertion(conceptInstance);
				if (result == null) result = caseResource(conceptInstance);
				if (result == null) result = caseModuleElement(conceptInstance);
				if (result == null) result = caseIntrinsicIdentityKind(conceptInstance);
				if (result == null) result = caseLogicalElement(conceptInstance);
				if (result == null) result = caseCrossReferencableKind(conceptInstance);
				if (result == null) result = caseIdentityKind(conceptInstance);
				if (result == null) result = caseCrossReferencabilityKind(conceptInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE: {
				ReifiedRelationshipInstance reifiedRelationshipInstance = (ReifiedRelationshipInstance)theEObject;
				T result = caseReifiedRelationshipInstance(reifiedRelationshipInstance);
				if (result == null) result = caseConceptualEntitySingletonInstance(reifiedRelationshipInstance);
				if (result == null) result = caseTerminologyInstanceAssertion(reifiedRelationshipInstance);
				if (result == null) result = caseResource(reifiedRelationshipInstance);
				if (result == null) result = caseModuleElement(reifiedRelationshipInstance);
				if (result == null) result = caseIntrinsicIdentityKind(reifiedRelationshipInstance);
				if (result == null) result = caseLogicalElement(reifiedRelationshipInstance);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipInstance);
				if (result == null) result = caseIdentityKind(reifiedRelationshipInstance);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN: {
				ReifiedRelationshipInstanceDomain reifiedRelationshipInstanceDomain = (ReifiedRelationshipInstanceDomain)theEObject;
				T result = caseReifiedRelationshipInstanceDomain(reifiedRelationshipInstanceDomain);
				if (result == null) result = caseTerminologyInstanceAssertion(reifiedRelationshipInstanceDomain);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipInstanceDomain);
				if (result == null) result = caseModuleElement(reifiedRelationshipInstanceDomain);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipInstanceDomain);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipInstanceDomain);
				if (result == null) result = caseLogicalElement(reifiedRelationshipInstanceDomain);
				if (result == null) result = caseIdentityKind(reifiedRelationshipInstanceDomain);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipInstanceDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE_RANGE: {
				ReifiedRelationshipInstanceRange reifiedRelationshipInstanceRange = (ReifiedRelationshipInstanceRange)theEObject;
				T result = caseReifiedRelationshipInstanceRange(reifiedRelationshipInstanceRange);
				if (result == null) result = caseTerminologyInstanceAssertion(reifiedRelationshipInstanceRange);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipInstanceRange);
				if (result == null) result = caseModuleElement(reifiedRelationshipInstanceRange);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipInstanceRange);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipInstanceRange);
				if (result == null) result = caseLogicalElement(reifiedRelationshipInstanceRange);
				if (result == null) result = caseIdentityKind(reifiedRelationshipInstanceRange);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipInstanceRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE: {
				UnreifiedRelationshipInstanceTuple unreifiedRelationshipInstanceTuple = (UnreifiedRelationshipInstanceTuple)theEObject;
				T result = caseUnreifiedRelationshipInstanceTuple(unreifiedRelationshipInstanceTuple);
				if (result == null) result = caseTerminologyInstanceAssertion(unreifiedRelationshipInstanceTuple);
				if (result == null) result = caseElementCrossReferenceTuple(unreifiedRelationshipInstanceTuple);
				if (result == null) result = caseModuleElement(unreifiedRelationshipInstanceTuple);
				if (result == null) result = caseExtrinsicIdentityKind(unreifiedRelationshipInstanceTuple);
				if (result == null) result = caseCrossReferencableKind(unreifiedRelationshipInstanceTuple);
				if (result == null) result = caseLogicalElement(unreifiedRelationshipInstanceTuple);
				if (result == null) result = caseIdentityKind(unreifiedRelationshipInstanceTuple);
				if (result == null) result = caseCrossReferencabilityKind(unreifiedRelationshipInstanceTuple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBox(DescriptionBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Box Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Box Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBoxRelationship(DescriptionBoxRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Box Extends Closed World Definitions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Box Extends Closed World Definitions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBoxExtendsClosedWorldDefinitions(DescriptionBoxExtendsClosedWorldDefinitions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Box Refinement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Box Refinement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionBoxRefinement(DescriptionBoxRefinement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Instance Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Instance Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyInstanceAssertion(TerminologyInstanceAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Singleton Instance Scalar Data Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Singleton Instance Scalar Data Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingletonInstanceScalarDataPropertyValue(SingletonInstanceScalarDataPropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Singleton Instance Structured Data Property Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Singleton Instance Structured Data Property Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingletonInstanceStructuredDataPropertyContext(SingletonInstanceStructuredDataPropertyContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Singleton Instance Structured Data Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Singleton Instance Structured Data Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingletonInstanceStructuredDataPropertyValue(SingletonInstanceStructuredDataPropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Data Property Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Data Property Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredDataPropertyTuple(StructuredDataPropertyTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Data Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Data Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarDataPropertyValue(ScalarDataPropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conceptual Entity Singleton Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conceptual Entity Singleton Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptualEntitySingletonInstance(ConceptualEntitySingletonInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptInstance(ConceptInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipInstance(ReifiedRelationshipInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Instance Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Instance Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipInstanceDomain(ReifiedRelationshipInstanceDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Instance Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Instance Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipInstanceRange(ReifiedRelationshipInstanceRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unreified Relationship Instance Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unreified Relationship Instance Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnreifiedRelationshipInstanceTuple(UnreifiedRelationshipInstanceTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cross Referencability Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cross Referencability Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCrossReferencabilityKind(CrossReferencabilityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentityKind(IdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalElement(LogicalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cross Referencable Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cross Referencable Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCrossReferencableKind(CrossReferencableKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intrinsic Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intrinsic Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntrinsicIdentityKind(IntrinsicIdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(gov.nasa.jpl.imce.oml.model.common.Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extrinsic Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extrinsic Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtrinsicIdentityKind(ExtrinsicIdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Cross Reference Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Cross Reference Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCrossReferenceTuple(ElementCrossReferenceTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleEdge(ModuleEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleElement(ModuleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Cross Referencable Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Cross Referencable Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonCrossReferencableKind(NonCrossReferencableKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Cross Reference Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Cross Reference Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueCrossReferenceTuple(ValueCrossReferenceTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DescriptionsSwitch
