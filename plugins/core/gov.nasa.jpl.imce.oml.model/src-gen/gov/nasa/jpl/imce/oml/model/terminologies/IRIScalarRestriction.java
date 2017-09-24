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

import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IRI Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML IRIScalarRestriction is a data range that specifies how one IRI scalar adds facet restrictions to another.
 * Applicable when the restricted scalar represents an [OWL2 IRI].
 * 
 * The restricted scalar must be directly or indirectly a restriction of:
 * - [xsd:anyURI]
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
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getLength <em>Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getIRIScalarRestriction()
 * @model
 * @generated
 */
public interface IRIScalarRestriction extends RestrictedDataRange {
	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The length of the IRI
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getIRIScalarRestriction_Length()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getLength <em>Length</em>}' attribute.
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
	 * The minimum length of the IRI
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getIRIScalarRestriction_MinLength()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getMinLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getMinLength <em>Min Length</em>}' attribute.
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
	 * The maximum length of the IRI
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getIRIScalarRestriction_MaxLength()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral"
	 * @generated
	 */
	PositiveIntegerValue getMaxLength();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getMaxLength <em>Max Length</em>}' attribute.
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
	 * The pattern of the IRI (https://www.w3.org/TR/xmlschema-2/#regexs)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(PatternValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getIRIScalarRestriction_Pattern()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LiteralPattern"
	 * @generated
	 */
	PatternValue getPattern();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(PatternValue value);

} // IRIScalarRestriction
