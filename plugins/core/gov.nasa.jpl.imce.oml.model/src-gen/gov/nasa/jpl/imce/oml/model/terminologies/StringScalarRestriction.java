/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML StringScalarRestriction is a data range that specifies how one string scalar adds facet restrictions to another.
 * Applicable when the restricted scalar represents [OWL2 Strings].
 * 
 * The restricted scalar must be directly or indirectly a restriction of:
 * - [xsd:string]
 * - [xsd:normalizedString]
 * - [xsd:token]
 * - [xsd:language]
 * - [xsd:Name]
 * - [xsd:NCName]
 * - [xsd:NMTOKEN]
 * 
 * Facets:
 * - [xsd:length]
 * - [xsd:minLength]
 * - [xsd:maxLength]
 * - [xsd:pattern]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getLength <em>Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getStringScalarRestriction()
 * @model
 * @generated
 */
public interface StringScalarRestriction extends RestrictedDataRange {
	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The length of the string
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getStringScalarRestriction_Length()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getLength <em>Length</em>}' attribute.
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
	 * The minimum length of the string
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getStringScalarRestriction_MinLength()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getMinLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getMinLength <em>Min Length</em>}' attribute.
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
	 * The maximum length of the string
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getStringScalarRestriction_MaxLength()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getMaxLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(PositiveIntegerValue value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pattern of the string (https://www.w3.org/TR/xmlschema-2/#regexs)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(PatternValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getStringScalarRestriction_Pattern()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LiteralPattern"
	 * @generated
	 */
	PatternValue getPattern();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(PatternValue value);

} // StringScalarRestriction
