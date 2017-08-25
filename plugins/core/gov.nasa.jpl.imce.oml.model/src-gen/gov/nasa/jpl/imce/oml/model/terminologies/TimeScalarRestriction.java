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

import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML TimeScalarRestriction is a data range that specifies how one time scalar adds facet restrictions to another.
 * Applicable when the restricted scalar represents [OWL2 Time Instants].
 * 
 * The restricted scalar must be directly or indirectly a restriction of:
 * - [xsd:dateTime]
 * - [xsd:dateTimeStamp]
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
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTimeScalarRestriction()
 * @model
 * @generated
 */
public interface TimeScalarRestriction extends RestrictedDataRange {
	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusive minimum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' containment reference.
	 * @see #setMinInclusive(LiteralDateTime)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTimeScalarRestriction_MinInclusive()
	 * @model containment="true"
	 * @generated
	 */
	LiteralDateTime getMinInclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMinInclusive <em>Min Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' containment reference.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(LiteralDateTime value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusive maximum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' containment reference.
	 * @see #setMaxInclusive(LiteralDateTime)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTimeScalarRestriction_MaxInclusive()
	 * @model containment="true"
	 * @generated
	 */
	LiteralDateTime getMaxInclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' containment reference.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(LiteralDateTime value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exclusive minimum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' containment reference.
	 * @see #setMinExclusive(LiteralDateTime)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTimeScalarRestriction_MinExclusive()
	 * @model containment="true"
	 * @generated
	 */
	LiteralDateTime getMinExclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMinExclusive <em>Min Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' containment reference.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(LiteralDateTime value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exclusive maximum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #setMaxExclusive(LiteralDateTime)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTimeScalarRestriction_MaxExclusive()
	 * @model containment="true"
	 * @generated
	 */
	LiteralDateTime getMaxExclusive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(LiteralDateTime value);

} // TimeScalarRestriction
