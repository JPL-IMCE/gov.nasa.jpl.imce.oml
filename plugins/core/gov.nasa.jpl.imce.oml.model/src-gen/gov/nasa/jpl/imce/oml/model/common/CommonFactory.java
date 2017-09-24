/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonFactory eINSTANCE = gov.nasa.jpl.imce.oml.model.common.impl.CommonFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Literal Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Boolean</em>'.
	 * @generated
	 */
	LiteralBoolean createLiteralBoolean();

	/**
	 * Returns a new object of class '<em>Literal Date Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Date Time</em>'.
	 * @generated
	 */
	LiteralDateTime createLiteralDateTime();

	/**
	 * Returns a new object of class '<em>Literal String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal String</em>'.
	 * @generated
	 */
	LiteralString createLiteralString();

	/**
	 * Returns a new object of class '<em>Literal UUID</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal UUID</em>'.
	 * @generated
	 */
	LiteralUUID createLiteralUUID();

	/**
	 * Returns a new object of class '<em>Literal URI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal URI</em>'.
	 * @generated
	 */
	LiteralURI createLiteralURI();

	/**
	 * Returns a new object of class '<em>Literal Real</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Real</em>'.
	 * @generated
	 */
	LiteralReal createLiteralReal();

	/**
	 * Returns a new object of class '<em>Literal Rational</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Rational</em>'.
	 * @generated
	 */
	LiteralRational createLiteralRational();

	/**
	 * Returns a new object of class '<em>Literal Float</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Float</em>'.
	 * @generated
	 */
	LiteralFloat createLiteralFloat();

	/**
	 * Returns a new object of class '<em>Literal Decimal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Decimal</em>'.
	 * @generated
	 */
	LiteralDecimal createLiteralDecimal();

	/**
	 * Returns a new object of class '<em>Annotation Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Property Value</em>'.
	 * @generated
	 */
	AnnotationPropertyValue createAnnotationPropertyValue();

	/**
	 * Returns a new object of class '<em>Annotation Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Property</em>'.
	 * @generated
	 */
	AnnotationProperty createAnnotationProperty();

	/**
	 * Returns a new object of class '<em>Extent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extent</em>'.
	 * @generated
	 */
	Extent createExtent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommonPackage getCommonPackage();

} //CommonFactory
