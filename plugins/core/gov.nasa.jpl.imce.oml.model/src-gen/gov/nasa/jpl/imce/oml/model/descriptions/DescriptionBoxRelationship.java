/**
 */
package gov.nasa.jpl.imce.oml.model.descriptions;

import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description Box Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DescriptionBoxRelationship is a directed binary relationship
 * from an OML DescriptionBox source to an OML Module target.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBoxRelationship()
 * @model abstract="true"
 * @generated
 */
public interface DescriptionBoxRelationship extends ModuleEdge {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	DescriptionBox descriptionDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.descriptionDomain();'"
	 * @generated
	 */
	Module sourceModule();

} // DescriptionBoxRelationship
