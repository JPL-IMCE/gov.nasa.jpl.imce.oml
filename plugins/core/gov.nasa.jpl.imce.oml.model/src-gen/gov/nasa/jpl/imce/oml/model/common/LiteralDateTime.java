/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Date Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#getDateTime <em>Date Time</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralDateTime()
 * @model
 * @generated
 */
public interface LiteralDateTime extends LiteralValue {
	/**
	 * Returns the value of the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Time</em>' attribute.
	 * @see #setDateTime(DateTimeValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralDateTime_DateTime()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.DateTimeDataType" required="true"
	 * @generated
	 */
	DateTimeValue getDateTime();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#getDateTime <em>Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Time</em>' attribute.
	 * @see #getDateTime()
	 * @generated
	 */
	void setDateTime(DateTimeValue value);

} // LiteralDateTime
