/**
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
