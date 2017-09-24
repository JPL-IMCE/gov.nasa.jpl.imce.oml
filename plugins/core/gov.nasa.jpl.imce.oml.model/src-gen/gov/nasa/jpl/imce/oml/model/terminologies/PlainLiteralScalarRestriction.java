/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plain Literal Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML PlainLiteralScalarRestriction is a data range that specifies how one plain literal scalar adds facet restrictions to another.
 * Applicable when the restricted scalar represents [rdf:PlainLiteral].
 * 
 * The restricted scalar must be directly or indirectly a restriction of:
 * - [rdf:PlainLiteral]
 * 
 * Facets:
 * - [xsd:langRange]
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
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getLength <em>Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getPattern <em>Pattern</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getLangRange <em>Lang Range</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getPlainLiteralScalarRestriction()
 * @model
 * @generated
 */
public interface PlainLiteralScalarRestriction extends RestrictedDataRange {
	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The length of the plain literal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getPlainLiteralScalarRestriction_Length()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getLength <em>Length</em>}' attribute.
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
	 * The minimum length of the plain literal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getPlainLiteralScalarRestriction_MinLength()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getMinLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getMinLength <em>Min Length</em>}' attribute.
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
	 * The maximum length of the plain literal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getPlainLiteralScalarRestriction_MaxLength()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getMaxLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getMaxLength <em>Max Length</em>}' attribute.
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
	 * The pattern of the plain literal (https://www.w3.org/TR/xmlschema-2/#regexs)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(PatternValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getPlainLiteralScalarRestriction_Pattern()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LiteralPattern"
	 * @generated
	 */
	PatternValue getPattern();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(PatternValue value);

	/**
	 * Returns the value of the '<em><b>Lang Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The language of the plain literal (http://www.rfc-editor.org/rfc/bcp/bcp47.txt)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lang Range</em>' attribute.
	 * @see #setLangRange(LanguageTagValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getPlainLiteralScalarRestriction_LangRange()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LanguageTagDataType"
	 * @generated
	 */
	LanguageTagValue getLangRange();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getLangRange <em>Lang Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lang Range</em>' attribute.
	 * @see #getLangRange()
	 * @generated
	 */
	void setLangRange(LanguageTagValue value);

} // PlainLiteralScalarRestriction
