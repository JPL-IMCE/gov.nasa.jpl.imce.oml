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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Relationship To Scalar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DataRelationshipToScalar is an OML DataRelationship
 * whose range is an OML DataRange.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDataRelationshipToScalar()
 * @model abstract="true"
 * @generated
 */
public interface DataRelationshipToScalar extends DataRelationshipRange {
	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(DataRange)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDataRelationshipToScalar_Range()
	 * @model required="true"
	 * @generated
	 */
	DataRange getRange();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar#getRange <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(DataRange value);

} // DataRelationshipToScalar
