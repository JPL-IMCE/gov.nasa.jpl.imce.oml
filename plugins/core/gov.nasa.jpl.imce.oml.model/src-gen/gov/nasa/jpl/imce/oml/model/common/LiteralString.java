/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import gov.nasa.jpl.imce.oml.model.datatypes.StringValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralString#getString <em>String</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralString()
 * @model
 * @generated
 */
public interface LiteralString extends LiteralValue {
	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(StringValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralString_String()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.StringDataType" required="true"
	 * @generated
	 */
	StringValue getString();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralString#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(StringValue value);

} // LiteralString
