/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conceptual Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ConceptualEntity is an OML Entity that can be instantiated
 * as an OML ConceptualEntitySingletonInstance in any OML DescriptionBox.
 * It is partially instantiated if some essential OML EntityRelationship
 * or OML DataRelationshipFromEntity with `isIdentityCriteria=true` lacks
 * an OML TerminologyInstanceAssertion specifying its reference or value respectively.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getConceptualEntity()
 * @model abstract="true"
 * @generated
 */
public interface ConceptualEntity extends EObject {
} // ConceptualEntity
