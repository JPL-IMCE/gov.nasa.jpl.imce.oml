/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.common.Module;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminology Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML TerminologyBox is an OML Module for defining a domain-specific vocabulary
 * as a logical set of OML TerminologyBoxStatement(s), possibly by reuse of other
 * vocabularies via OML TerminologyBoxAxiom(s).
 * The semantics of an OML TerminologyBox domain-specific vocabulary is defined
 * by the mapping to [OWL2-DL] of the other vocabularies it reuses, if any, and
 * that of its OML TerminologyBoxAxiom(s) and OML TerminologyBoxStatement(s)
 * according to its OML TerminologyKind.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getKind <em>Kind</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getBoxAxioms <em>Box Axioms</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getBoxStatements <em>Box Statements</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTerminologyBox()
 * @model abstract="true"
 * @generated
 */
public interface TerminologyBox extends Module {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind
	 * @see #setKind(TerminologyKind)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTerminologyBox_Kind()
	 * @model unique="false" required="true"
	 * @generated
	 */
	TerminologyKind getKind();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TerminologyKind value);

	/**
	 * Returns the value of the '<em><b>Box Axioms</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom#getTbox <em>Tbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OML TerminologyBoxAxiom(s) asserted in this OML TerminologyBox
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Box Axioms</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTerminologyBox_BoxAxioms()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom#getTbox
	 * @model opposite="tbox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<TerminologyBoxAxiom> getBoxAxioms();

	/**
	 * Returns the value of the '<em><b>Box Statements</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement#getTbox <em>Tbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OML TerminologyBoxStatement(s) asserted in this OML TerminologyBox
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Box Statements</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTerminologyBox_BoxStatements()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement#getTbox
	 * @model opposite="tbox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<TerminologyBoxStatement> getBoxStatements();

} // TerminologyBox
