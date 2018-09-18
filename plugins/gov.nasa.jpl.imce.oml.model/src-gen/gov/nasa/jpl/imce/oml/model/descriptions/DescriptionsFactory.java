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
package gov.nasa.jpl.imce.oml.model.descriptions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage
 * @generated
 */
public interface DescriptionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DescriptionsFactory eINSTANCE = gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Description Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description Box</em>'.
	 * @generated
	 */
	DescriptionBox createDescriptionBox();

	/**
	 * Returns a new object of class '<em>Description Box Extends Closed World Definitions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description Box Extends Closed World Definitions</em>'.
	 * @generated
	 */
	DescriptionBoxExtendsClosedWorldDefinitions createDescriptionBoxExtendsClosedWorldDefinitions();

	/**
	 * Returns a new object of class '<em>Description Box Refinement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description Box Refinement</em>'.
	 * @generated
	 */
	DescriptionBoxRefinement createDescriptionBoxRefinement();

	/**
	 * Returns a new object of class '<em>Singleton Instance Scalar Data Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Singleton Instance Scalar Data Property Value</em>'.
	 * @generated
	 */
	SingletonInstanceScalarDataPropertyValue createSingletonInstanceScalarDataPropertyValue();

	/**
	 * Returns a new object of class '<em>Singleton Instance Structured Data Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Singleton Instance Structured Data Property Value</em>'.
	 * @generated
	 */
	SingletonInstanceStructuredDataPropertyValue createSingletonInstanceStructuredDataPropertyValue();

	/**
	 * Returns a new object of class '<em>Structured Data Property Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Data Property Tuple</em>'.
	 * @generated
	 */
	StructuredDataPropertyTuple createStructuredDataPropertyTuple();

	/**
	 * Returns a new object of class '<em>Scalar Data Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Data Property Value</em>'.
	 * @generated
	 */
	ScalarDataPropertyValue createScalarDataPropertyValue();

	/**
	 * Returns a new object of class '<em>Concept Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept Instance</em>'.
	 * @generated
	 */
	ConceptInstance createConceptInstance();

	/**
	 * Returns a new object of class '<em>Instance Relationship Enumeration Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Relationship Enumeration Restriction</em>'.
	 * @generated
	 */
	InstanceRelationshipEnumerationRestriction createInstanceRelationshipEnumerationRestriction();

	/**
	 * Returns a new object of class '<em>Instance Relationship One Of Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Relationship One Of Restriction</em>'.
	 * @generated
	 */
	InstanceRelationshipOneOfRestriction createInstanceRelationshipOneOfRestriction();

	/**
	 * Returns a new object of class '<em>Instance Relationship Value Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Relationship Value Restriction</em>'.
	 * @generated
	 */
	InstanceRelationshipValueRestriction createInstanceRelationshipValueRestriction();

	/**
	 * Returns a new object of class '<em>Instance Relationship Existential Range Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Relationship Existential Range Restriction</em>'.
	 * @generated
	 */
	InstanceRelationshipExistentialRangeRestriction createInstanceRelationshipExistentialRangeRestriction();

	/**
	 * Returns a new object of class '<em>Instance Relationship Universal Range Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Relationship Universal Range Restriction</em>'.
	 * @generated
	 */
	InstanceRelationshipUniversalRangeRestriction createInstanceRelationshipUniversalRangeRestriction();

	/**
	 * Returns a new object of class '<em>Reified Relationship Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Instance</em>'.
	 * @generated
	 */
	ReifiedRelationshipInstance createReifiedRelationshipInstance();

	/**
	 * Returns a new object of class '<em>Reified Relationship Instance Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Instance Domain</em>'.
	 * @generated
	 */
	ReifiedRelationshipInstanceDomain createReifiedRelationshipInstanceDomain();

	/**
	 * Returns a new object of class '<em>Reified Relationship Instance Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reified Relationship Instance Range</em>'.
	 * @generated
	 */
	ReifiedRelationshipInstanceRange createReifiedRelationshipInstanceRange();

	/**
	 * Returns a new object of class '<em>Unreified Relationship Instance Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unreified Relationship Instance Tuple</em>'.
	 * @generated
	 */
	UnreifiedRelationshipInstanceTuple createUnreifiedRelationshipInstanceTuple();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DescriptionsPackage getDescriptionsPackage();

} //DescriptionsFactory
