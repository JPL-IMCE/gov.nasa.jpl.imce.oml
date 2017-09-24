/**
 */
package gov.nasa.jpl.imce.oml.model.common;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ModuleEdge is a binary, directed relationship from one OML Module to another
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getModuleEdge()
 * @model abstract="true"
 * @generated
 */
public interface ModuleEdge extends Element {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	Module sourceModule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 * @generated
	 */
	Module targetModule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.sourceModule();'"
	 * @generated
	 */
	Module moduleContext();

} // ModuleEdge
