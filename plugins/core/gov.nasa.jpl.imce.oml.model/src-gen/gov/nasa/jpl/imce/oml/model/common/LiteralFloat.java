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

import gov.nasa.jpl.imce.oml.model.datatypes.FloatValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Float</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralFloat#getFloat <em>Float</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralFloat()
 * @model
 * @generated
 */
public interface LiteralFloat extends LiteralNumber {
	/**
	 * Returns the value of the '<em><b>Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Float</em>' attribute.
	 * @see #setFloat(FloatValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralFloat_Float()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.FloatDataType" required="true"
	 * @generated
	 */
	FloatValue getFloat();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralFloat#getFloat <em>Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Float</em>' attribute.
	 * @see #getFloat()
	 * @generated
	 */
	void setFloat(FloatValue value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getFloat().toString();'"
	 * @generated
	 */
	String value();

} // LiteralFloat
