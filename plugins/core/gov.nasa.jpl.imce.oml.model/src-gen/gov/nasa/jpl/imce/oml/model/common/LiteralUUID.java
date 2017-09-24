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

import gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal UUID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID#getUuid <em>Uuid</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralUUID()
 * @model
 * @generated
 */
public interface LiteralUUID extends LiteralValue {
	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(UUIDValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralUUID_Uuid()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.UUIDDataType" required="true"
	 * @generated
	 */
	UUIDValue getUuid();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	void setUuid(UUIDValue value);

} // LiteralUUID
