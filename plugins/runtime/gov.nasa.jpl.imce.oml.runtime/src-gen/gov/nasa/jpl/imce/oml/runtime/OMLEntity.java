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
 * A representation of the model object '<em><b>OML Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance
 * 
 * Note that there is no name attribute per se.
 * When mapping OMLRuntime-based M1 => OML DescriptionBox M1, the OMLEntity ID will be used as a name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlName <em>Oml Name</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlDescription <em>Oml Description</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLEntity()
 * @model abstract="true"
 * @generated
 */
public interface OMLEntity extends OMLObject {
	/**
	 * Returns the value of the '<em><b>Oml Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oml Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oml Name</em>' attribute.
	 * @see #setOmlName(String)
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLEntity_OmlName()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.runtime.LocalName"
	 * @generated
	 */
	String getOmlName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlName <em>Oml Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml Name</em>' attribute.
	 * @see #getOmlName()
	 * @generated
	 */
	void setOmlName(String value);

	/**
	 * Returns the value of the '<em><b>Oml Description</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlContents <em>Oml Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oml Description</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oml Description</em>' container reference.
	 * @see #setOmlDescription(OMLDescription)
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLEntity_OmlDescription()
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlContents
	 * @model opposite="omlContents" required="true" transient="false"
	 * @generated
	 */
	OMLDescription getOmlDescription();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlDescription <em>Oml Description</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml Description</em>' container reference.
	 * @see #getOmlDescription()
	 * @generated
	 */
	void setOmlDescription(OMLDescription value);

} // OMLEntity
