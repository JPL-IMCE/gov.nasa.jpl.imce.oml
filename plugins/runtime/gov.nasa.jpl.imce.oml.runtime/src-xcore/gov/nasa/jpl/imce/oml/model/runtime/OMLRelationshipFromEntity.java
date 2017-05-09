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
package gov.nasa.jpl.imce.oml.model.runtime;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OML Relationship From Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.runtime.OMLRelationshipFromEntity#getOmlSource <em>Oml Source</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage#getOMLRelationshipFromEntity()
 * @model abstract="true"
 * @generated
 */
public interface OMLRelationshipFromEntity extends OMLObject {
	/**
	 * Returns the value of the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oml Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oml Source</em>' reference.
	 * @see #setOmlSource(OMLEntity)
	 * @see gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage#getOMLRelationshipFromEntity_OmlSource()
	 * @model required="true"
	 * @generated
	 */
	OMLEntity getOmlSource();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.runtime.OMLRelationshipFromEntity#getOmlSource <em>Oml Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml Source</em>' reference.
	 * @see #getOmlSource()
	 * @generated
	 */
	void setOmlSource(OMLEntity value);

} // OMLRelationshipFromEntity
