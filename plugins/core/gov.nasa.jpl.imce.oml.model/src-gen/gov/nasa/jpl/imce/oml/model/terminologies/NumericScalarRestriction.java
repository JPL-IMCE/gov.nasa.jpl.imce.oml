/**
 * 
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


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
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusive minimum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' attribute.
	 * @see #setMinInclusive(String)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction_MinInclusive()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LexicalNumber"
	 * @generated
	 */
	String getMinInclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinInclusive <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' attribute.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(String value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusive maximum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' attribute.
	 * @see #setMaxInclusive(String)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction_MaxInclusive()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LexicalNumber"
	 * @generated
	 */
	String getMaxInclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' attribute.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(String value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exclusive minimum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' attribute.
	 * @see #setMinExclusive(String)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction_MinExclusive()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LexicalNumber"
	 * @generated
	 */
	String getMinExclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinExclusive <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' attribute.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(String value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exclusive maximum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' attribute.
	 * @see #setMaxExclusive(String)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getNumericScalarRestriction_MaxExclusive()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LexicalNumber"
	 * @generated
	 */
	String getMaxExclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' attribute.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(String value);

} // NumericScalarRestriction
