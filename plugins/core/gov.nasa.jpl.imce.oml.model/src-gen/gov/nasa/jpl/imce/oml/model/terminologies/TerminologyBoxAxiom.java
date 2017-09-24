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
 * A representation of the model object '<em><b>Terminology Box Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML TerminologyBoxAxiom is an OML TerminologyAxiom that
 * asserts a logical statement about an OML TerminologyBox.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom#getTbox <em>Tbox</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTerminologyBoxAxiom()
 * @model abstract="true"
 * @generated
 */
public interface TerminologyBoxAxiom extends TerminologyAxiom {
	/**
	 * Returns the value of the '<em><b>Tbox</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getBoxAxioms <em>Box Axioms</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tbox</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tbox</em>' container reference.
	 * @see #setTbox(TerminologyBox)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTerminologyBoxAxiom_Tbox()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getBoxAxioms
	 * @model opposite="boxAxioms" required="true" transient="false"
	 * @generated
	 */
	TerminologyBox getTbox();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom#getTbox <em>Tbox</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tbox</em>' container reference.
	 * @see #getTbox()
	 * @generated
	 */
	void setTbox(TerminologyBox value);

} // TerminologyBoxAxiom
