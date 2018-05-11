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

import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Structured Data Property Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityStructuredDataPropertyRestrictionAxiom maps to
 * some kind of OWL2 Object Property Restriction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityStructuredDataPropertyRestrictionAxiom()
 * @model abstract="true"
 * @generated
 */
public interface EntityStructuredDataPropertyRestrictionAxiom extends TermAxiom, ElementCrossReferenceTuple {
	/**
	 * Returns the value of the '<em><b>Restricted Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Entity</em>' reference.
	 * @see #setRestrictedEntity(Entity)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityStructuredDataPropertyRestrictionAxiom_RestrictedEntity()
	 * @model required="true"
	 * @generated
	 */
	Entity getRestrictedEntity();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Entity</em>' reference.
	 * @see #getRestrictedEntity()
	 * @generated
	 */
	void setRestrictedEntity(Entity value);

} // EntityStructuredDataPropertyRestrictionAxiom
