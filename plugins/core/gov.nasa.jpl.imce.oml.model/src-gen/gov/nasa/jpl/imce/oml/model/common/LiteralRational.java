/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import gov.nasa.jpl.imce.oml.model.datatypes.RationalValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Rational</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralRational#getRational <em>Rational</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralRational()
 * @model
 * @generated
 */
public interface LiteralRational extends LiteralNumber {
	/**
	 * Returns the value of the '<em><b>Rational</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rational</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rational</em>' attribute.
	 * @see #setRational(RationalValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralRational_Rational()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.RationalDataType" required="true"
	 * @generated
	 */
	RationalValue getRational();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralRational#getRational <em>Rational</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rational</em>' attribute.
	 * @see #getRational()
	 * @generated
	 */
	void setRational(RationalValue value);

} // LiteralRational
