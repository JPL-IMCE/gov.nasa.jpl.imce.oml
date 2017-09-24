/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import gov.nasa.jpl.imce.oml.model.datatypes.RealValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Real</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralReal#getReal <em>Real</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralReal()
 * @model
 * @generated
 */
public interface LiteralReal extends LiteralNumber {
	/**
	 * Returns the value of the '<em><b>Real</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Real</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Real</em>' attribute.
	 * @see #setReal(RealValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralReal_Real()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.RealDataType" required="true"
	 * @generated
	 */
	RealValue getReal();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralReal#getReal <em>Real</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Real</em>' attribute.
	 * @see #getReal()
	 * @generated
	 */
	void setReal(RealValue value);

} // LiteralReal
