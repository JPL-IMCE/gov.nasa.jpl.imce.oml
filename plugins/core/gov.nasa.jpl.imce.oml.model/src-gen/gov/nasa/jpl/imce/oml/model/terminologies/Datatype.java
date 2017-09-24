/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Datatype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML Datatype is a common abstraction for what should be, in principle,
 * [OWL2 DataRange] of arity 1 (atomic) or > 1 (tuple structure).
 * In practice, an OML DataType maps to the [OWL2-DL] subset; which means
 * that an atomic OML Datatype maps to an [OWL2 Datatype] whereas
 * a structured OML Datatype maps to an [OWL2 Class].
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDatatype()
 * @model abstract="true"
 * @generated
 */
public interface Datatype extends Term {
} // Datatype
