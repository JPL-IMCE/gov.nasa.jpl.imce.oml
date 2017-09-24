/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal UUID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID#getUuid <em>Uuid</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralUUID()
 * @model
 * @generated
 */
public interface LiteralUUID extends LiteralValue {
	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(UUIDValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralUUID_Uuid()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.UUIDDataType" required="true"
	 * @generated
	 */
	UUIDValue getUuid();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	void setUuid(UUIDValue value);

} // LiteralUUID
