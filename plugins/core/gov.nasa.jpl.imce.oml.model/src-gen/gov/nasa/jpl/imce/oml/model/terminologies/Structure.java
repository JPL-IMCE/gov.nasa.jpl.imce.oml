/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML Structure would correspond to an OWL2 Declaration of an [OWL2 DataRange] with arity > 1.
 * However, since OWL2 Datatypes in the [OWL2-DL] are restricted to have arity=1,
 * the OML mapping to [OWL2-DL] involves a pattern-based usage of an [OWL2 Class] to represent an OML Structure.
 * The arity corresponds to the cardinality of the set of ScalarDataProperty & StructuredDataProperty
 * relationships whose domain is this structure.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getStructure()
 * @model
 * @generated
 */
public interface Structure extends Datatype, UnaryTermKind {
} // Structure
