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
 * A representation of the model object '<em><b>Data Relationship From Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DataRelationshipFromEntity is an OML DataRelationship
 * whose domain is an OML Entity.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity#getDomain <em>Domain</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity#isIsIdentityCriteria <em>Is Identity Criteria</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDataRelationshipFromEntity()
 * @model abstract="true"
 * @generated
 */
public interface DataRelationshipFromEntity extends DataRelationshipDomain {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(Entity)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDataRelationshipFromEntity_Domain()
	 * @model required="true"
	 * @generated
	 */
	Entity getDomain();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Entity value);

	/**
	 * Returns the value of the '<em><b>Is Identity Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the OntoClean IdentityCriteria semantics of an OML DataRelationshipFromEntity:
	 * - +IC, if true; which means that every OML ConceptualEntity defined in a ClosedWorldDesignations OML Terminology
	 *   has an exact cardinality restriction of 1 for the possible values of the relationship, which is an
	 *   encoding in [OWL2-DL] of
	 * - ~IC, if false
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Identity Criteria</em>' attribute.
	 * @see #setIsIdentityCriteria(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDataRelationshipFromEntity_IsIdentityCriteria()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsIdentityCriteria();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity#isIsIdentityCriteria <em>Is Identity Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Identity Criteria</em>' attribute.
	 * @see #isIsIdentityCriteria()
	 * @generated
	 */
	void setIsIdentityCriteria(boolean value);

} // DataRelationshipFromEntity
