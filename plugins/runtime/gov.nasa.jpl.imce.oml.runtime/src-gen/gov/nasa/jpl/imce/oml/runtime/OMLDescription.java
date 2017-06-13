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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OML Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlIRI <em>Oml IRI</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlContents <em>Oml Contents</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLDescription()
 * @model
 * @generated
 */
public interface OMLDescription extends OMLObject {
	/**
	 * Returns the value of the '<em><b>Oml IRI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oml IRI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oml IRI</em>' attribute.
	 * @see #setOmlIRI(String)
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLDescription_OmlIRI()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.runtime.IRI"
	 * @generated
	 */
	String getOmlIRI();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlIRI <em>Oml IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml IRI</em>' attribute.
	 * @see #getOmlIRI()
	 * @generated
	 */
	void setOmlIRI(String value);

	/**
	 * Returns the value of the '<em><b>Oml Contents</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.runtime.OMLEntity}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlDescription <em>Oml Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oml Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oml Contents</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLDescription_OmlContents()
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlDescription
	 * @model opposite="omlDescription" containment="true"
	 * @generated
	 */
	EList<OMLEntity> getOmlContents();

} // OMLDescription
