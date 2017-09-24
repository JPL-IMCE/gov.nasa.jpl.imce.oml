/**
 */
package gov.nasa.jpl.imce.oml.model.common;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Boolean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralBoolean#isValue <em>Value</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralBoolean()
 * @model
 * @generated
 */
public interface LiteralBoolean extends LiteralValue {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralBoolean_Value()
	 * @model unique="false"
	 * @generated
	 */
	boolean isValue();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralBoolean#isValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #isValue()
	 * @generated
	 */
	void setValue(boolean value);

} // LiteralBoolean
