/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unreified Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML UnreifiedRelationship is a kind of OML EntityRelationship
 * where an instance has no intrinsic identity but rather structural
 * equivalence semantics as a tuple of references. This means
 * that an OML UnreifiedRelationship cannot be involved as the domain
 * or range of any kind of OML DirectedBinaryRelationshipKind.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getUnreifiedRelationship()
 * @model
 * @generated
 */
public interface UnreifiedRelationship extends EntityRelationship {
} // UnreifiedRelationship
