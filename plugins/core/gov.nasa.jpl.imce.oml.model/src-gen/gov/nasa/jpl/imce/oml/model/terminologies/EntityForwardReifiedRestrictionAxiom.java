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
 * A representation of the model object '<em><b>Entity Forward Reified Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityForwardReifiedRestrictionAxiom is an OML EntityRestrictionAxiom
 * where the restricted relationship is the forward property of an OML ReifiedRelationship.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityForwardReifiedRestrictionAxiom#getForwardProperty <em>Forward Property</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityForwardReifiedRestrictionAxiom()
 * @model abstract="true"
 * @generated
 */
public interface EntityForwardReifiedRestrictionAxiom extends EntityReifiedRestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Forward Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward Property</em>' reference.
	 * @see #setForwardProperty(ForwardProperty)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityForwardReifiedRestrictionAxiom_ForwardProperty()
	 * @model required="true"
	 * @generated
	 */
	ForwardProperty getForwardProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityForwardReifiedRestrictionAxiom#getForwardProperty <em>Forward Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward Property</em>' reference.
	 * @see #getForwardProperty()
	 * @generated
	 */
	void setForwardProperty(ForwardProperty value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getForwardProperty().getReifiedRelationship();'"
	 * @generated
	 */
	EntityRelationship restrictedRelation();

} // EntityForwardReifiedRestrictionAxiom
