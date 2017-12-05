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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getRational().toString();'"
	 * @generated
	 */
	String value();

} // LiteralRational
