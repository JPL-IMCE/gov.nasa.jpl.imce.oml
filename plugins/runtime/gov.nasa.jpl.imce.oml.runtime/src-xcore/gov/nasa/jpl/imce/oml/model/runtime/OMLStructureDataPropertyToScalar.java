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
 * A representation of the model object '<em><b>OML Structure Data Property To Scalar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @see gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.runtime.OMLStructureDataPropertyToScalar#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage#getOMLStructureDataPropertyToScalar()
 * @model
 * @generated
 */
public interface OMLStructureDataPropertyToScalar extends OMLRelationshipFromStructure {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage#getOMLStructureDataPropertyToScalar_Value()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.runtime.LexicalValue"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.runtime.OMLStructureDataPropertyToScalar#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // OMLStructureDataPropertyToScalar
