/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.common.LiteralNumber;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML NumericScalarRestriction is a data range that specifies how one numeric scalar range adds facet restrictions to another.
 * Applies when the restricted scalar represents [OWL2 Real Numbers, Decimal Numbers and Integers] or [OWL2 Floating-Point Numbers].
 * 
 * The restricted scalar must be directly or indirectly a restriction of:
 * - [owl:real]
 * - [owl:rational]
 * - [xsd:decimal]
 * - [xsd:integer]
 * - [xsd:nonNegativeInteger]
 * - [xsd:nonPositiveInteger]
 * - [xsd:positiveInteger]
 * - [xsd:negativeInteger]
 * - [xsd:long]
 * - [xsd:int]
 * - [xsd:short]
 * - [xsd:byte]
 * - [xsd:unsignedLong]
 * - [xsd:unsignedInt]
 * - [xsd:unsignedShort]
 * - [xsd:unsignedByte]
 * - [xsd:double]
 * - [xsd:float]
 * 
 * Facets:
 * - [xsd:minInclusive]
 * - [xsd:maxInclusive]
 * - [xsd:minExclusive]
 * - [xsd:maxExclusive]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction()
 * @model
 * @generated
 */
public interface NumericScalarRestriction extends RestrictedDataRange {
	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusive minimum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' containment reference.
	 * @see #setMinInclusive(LiteralNumber)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction_MinInclusive()
	 * @model containment="true"
	 * @generated
	 */
	LiteralNumber getMinInclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinInclusive <em>Min Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' containment reference.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(LiteralNumber value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusive maximum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' containment reference.
	 * @see #setMaxInclusive(LiteralNumber)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction_MaxInclusive()
	 * @model containment="true"
	 * @generated
	 */
	LiteralNumber getMaxInclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' containment reference.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(LiteralNumber value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exclusive minimum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' containment reference.
	 * @see #setMinExclusive(LiteralNumber)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction_MinExclusive()
	 * @model containment="true"
	 * @generated
	 */
	LiteralNumber getMinExclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinExclusive <em>Min Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' containment reference.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(LiteralNumber value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exclusive maximum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #setMaxExclusive(LiteralNumber)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction_MaxExclusive()
	 * @model containment="true"
	 * @generated
	 */
	LiteralNumber getMaxExclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(LiteralNumber value);

} // NumericScalarRestriction
