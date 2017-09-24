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
 * A representation of the model object '<em><b>Entity Structured Data Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityStructuredDataProperty is an OML DataRelationship
 * whose domain is an OML Entity and range is an OML Structure.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityStructuredDataProperty()
 * @model
 * @generated
 */
public interface EntityStructuredDataProperty extends DataRelationship, DataRelationshipFromEntity, DataRelationshipToStructure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getDomain();'"
	 * @generated
	 */
	Term source();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getRange();'"
	 * @generated
	 */
	Datatype target();

} // EntityStructuredDataProperty
