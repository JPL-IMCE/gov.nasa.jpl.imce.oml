/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminology Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML TerminologyAxiom is asserted in an OML TerminologyBox of some kind.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTerminologyAxiom()
 * @model abstract="true"
 * @generated
 */
public interface TerminologyAxiom extends ModuleEdge {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source TerminologyBox
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	TerminologyBox source();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.source();'"
	 * @generated
	 */
	Module sourceModule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target TerminologyBox
	 * <!-- end-model-doc -->
	 * @model unique="false" required="true"
	 * @generated
	 */
	TerminologyBox target();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.target();'"
	 * @generated
	 */
	Module targetModule();

} // TerminologyAxiom
