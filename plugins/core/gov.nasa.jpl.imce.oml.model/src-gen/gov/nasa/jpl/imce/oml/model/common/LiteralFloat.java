/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import gov.nasa.jpl.imce.oml.model.datatypes.FloatValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Float</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralFloat#getFloat <em>Float</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralFloat()
 * @model
 * @generated
 */
public interface LiteralFloat extends LiteralNumber {
	/**
	 * Returns the value of the '<em><b>Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Float</em>' attribute.
	 * @see #setFloat(FloatValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralFloat_Float()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.FloatDataType" required="true"
	 * @generated
	 */
	FloatValue getFloat();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralFloat#getFloat <em>Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Float</em>' attribute.
	 * @see #getFloat()
	 * @generated
	 */
	void setFloat(FloatValue value);

} // LiteralFloat
