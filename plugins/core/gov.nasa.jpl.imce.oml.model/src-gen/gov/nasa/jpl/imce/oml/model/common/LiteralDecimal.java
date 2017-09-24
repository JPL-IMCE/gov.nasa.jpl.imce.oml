/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Decimal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralDecimal#getDecimal <em>Decimal</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralDecimal()
 * @model
 * @generated
 */
public interface LiteralDecimal extends LiteralNumber {
	/**
	 * Returns the value of the '<em><b>Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decimal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decimal</em>' attribute.
	 * @see #setDecimal(AbstractDecimalValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralDecimal_Decimal()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.AbstractDecimalDataType" required="true"
	 * @generated
	 */
	AbstractDecimalValue getDecimal();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDecimal#getDecimal <em>Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decimal</em>' attribute.
	 * @see #getDecimal()
	 * @generated
	 */
	void setDecimal(AbstractDecimalValue value);

} // LiteralDecimal
