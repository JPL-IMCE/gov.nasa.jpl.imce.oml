/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Scalar Data Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityScalarDataProperty is an OML DataRelationship
 * whose domain is an OML Entity and range is an OML DataRange.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityScalarDataProperty()
 * @model
 * @generated
 */
public interface EntityScalarDataProperty extends DataRelationship, DataRelationshipFromEntity, DataRelationshipToScalar {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getDomain();'"
	 * @generated
	 */
	Term source();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getRange();'"
	 * @generated
	 */
	Datatype target();

} // EntityScalarDataProperty
