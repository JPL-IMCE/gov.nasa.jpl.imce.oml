/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML BinaryScalarRestriction is a data range that specifies how one binary scalar adds facet restrictions to another.
 * Applicable when the restricted scalar represents [OWL2 Binary Data].
 * 
 * The restricted scalar must be directly or indirectly a restriction of:
 * - [xsd:base64Binary]
 * - [xsd:hexBinary]
 * 
 * Facets:
 * - [xsd:length]
 * - [xsd:minLength]
 * - [xsd:maxLength]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getLength <em>Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getMaxLength <em>Max Length</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getBinaryScalarRestriction()
 * @model
 * @generated
 */
public interface BinaryScalarRestriction extends RestrictedDataRange {
	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The length of the binary data
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getBinaryScalarRestriction_Length()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(PositiveIntegerValue value);

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum length of the binary data
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getBinaryScalarRestriction_MinLength()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getMinLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(PositiveIntegerValue value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum length of the binary data
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getBinaryScalarRestriction_MaxLength()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getMaxLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(PositiveIntegerValue value);

} // BinaryScalarRestriction
