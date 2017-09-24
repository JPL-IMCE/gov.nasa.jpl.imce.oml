/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directed Binary Relationship Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DirectedBinaryRelationshipKind is an abstraction
 * for the category of OML Term(s)
 * that are relationships with arity 2
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDirectedBinaryRelationshipKind()
 * @model abstract="true"
 * @generated
 */
public interface DirectedBinaryRelationshipKind extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 * @generated
	 */
	Term relationDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 * @generated
	 */
	Term relationRange();

} // DirectedBinaryRelationshipKind
