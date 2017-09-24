/**
 */
package gov.nasa.jpl.imce.fm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.fm.FmPackage
 * @generated
 */
public interface FmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FmFactory eINSTANCE = gov.nasa.jpl.imce.fm.impl.FmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean</em>'.
	 * @generated
	 */
	Boolean createBoolean();

	/**
	 * Returns a new object of class '<em>String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String</em>'.
	 * @generated
	 */
	String createString();

	/**
	 * Returns a new object of class '<em>Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer</em>'.
	 * @generated
	 */
	Integer createInteger();

	/**
	 * Returns a new object of class '<em>Natural Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Natural Integer</em>'.
	 * @generated
	 */
	NaturalInteger createNaturalInteger();

	/**
	 * Returns a new object of class '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value</em>'.
	 * @generated
	 */
	Value createValue();

	/**
	 * Returns a new object of class '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity</em>'.
	 * @generated
	 */
	Entity createEntity();

	/**
	 * Returns a new object of class '<em>Extent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extent</em>'.
	 * @generated
	 */
	Extent createExtent();

	/**
	 * Returns a new object of class '<em>Binary Composite Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Composite Association</em>'.
	 * @generated
	 */
	BinaryCompositeAssociation createBinaryCompositeAssociation();

	/**
	 * Returns a new object of class '<em>Essential Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Essential Reference</em>'.
	 * @generated
	 */
	EssentialReference createEssentialReference();

	/**
	 * Returns a new object of class '<em>Essential Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Essential Attribute</em>'.
	 * @generated
	 */
	EssentialAttribute createEssentialAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FmPackage getFmPackage();

} //FmFactory
