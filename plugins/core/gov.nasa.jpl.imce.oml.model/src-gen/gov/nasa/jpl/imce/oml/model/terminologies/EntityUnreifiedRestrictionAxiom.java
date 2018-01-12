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
 * A representation of the model object '<em><b>Entity Unreified Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityUnreifiedRestrictionAxiom is an OML EntityRestrictionAxiom
 * where the restricted relationship is an OML UnreifiedRelationship.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityUnreifiedRestrictionAxiom#getRestrictedUnreifiedRelationship <em>Restricted Unreified Relationship</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityUnreifiedRestrictionAxiom()
 * @model abstract="true"
 * @generated
 */
public interface EntityUnreifiedRestrictionAxiom extends EntityRestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Restricted Unreified Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Unreified Relationship</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Unreified Relationship</em>' reference.
	 * @see #setRestrictedUnreifiedRelationship(UnreifiedRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityUnreifiedRestrictionAxiom_RestrictedUnreifiedRelationship()
	 * @model required="true"
	 * @generated
	 */
	UnreifiedRelationship getRestrictedUnreifiedRelationship();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityUnreifiedRestrictionAxiom#getRestrictedUnreifiedRelationship <em>Restricted Unreified Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Unreified Relationship</em>' reference.
	 * @see #getRestrictedUnreifiedRelationship()
	 * @generated
	 */
	void setRestrictedUnreifiedRelationship(UnreifiedRelationship value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getRestrictedUnreifiedRelationship();'"
	 * @generated
	 */
	EntityRelationship restrictedRelation();

} // EntityUnreifiedRestrictionAxiom
