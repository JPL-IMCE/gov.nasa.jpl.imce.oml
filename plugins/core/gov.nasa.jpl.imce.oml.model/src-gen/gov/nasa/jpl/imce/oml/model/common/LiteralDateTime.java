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

import gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Date Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#getDateTime <em>Date Time</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralDateTime()
 * @model
 * @generated
 */
public interface LiteralDateTime extends LiteralValue {
	/**
	 * Returns the value of the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Time</em>' attribute.
	 * @see #setDateTime(DateTimeValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralDateTime_DateTime()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.DateTimeDataType" required="true"
	 * @generated
	 */
	DateTimeValue getDateTime();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#getDateTime <em>Date Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Time</em>' attribute.
	 * @see #getDateTime()
	 * @generated
	 */
	void setDateTime(DateTimeValue value);

} // LiteralDateTime
