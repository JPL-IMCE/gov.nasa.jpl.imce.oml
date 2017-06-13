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
package gov.nasa.jpl.imce.oml.runtime;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OML Reified Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship#getOmlSource <em>Oml Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship#getOmlTarget <em>Oml Target</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLReifiedRelationship()
 * @model
 * @generated
 */
public interface OMLReifiedRelationship extends OMLEntity {
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
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLReifiedRelationship_OmlSource()
	 * @model required="true"
	 * @generated
	 */
	OMLEntity getOmlSource();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship#getOmlSource <em>Oml Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml Source</em>' reference.
	 * @see #getOmlSource()
	 * @generated
	 */
	void setOmlSource(OMLEntity value);

	/**
	 * Returns the value of the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oml Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oml Target</em>' reference.
	 * @see #setOmlTarget(OMLEntity)
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLReifiedRelationship_OmlTarget()
	 * @model required="true"
	 * @generated
	 */
	OMLEntity getOmlTarget();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship#getOmlTarget <em>Oml Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml Target</em>' reference.
	 * @see #getOmlTarget()
	 * @generated
	 */
	void setOmlTarget(OMLEntity value);

} // OMLReifiedRelationship
