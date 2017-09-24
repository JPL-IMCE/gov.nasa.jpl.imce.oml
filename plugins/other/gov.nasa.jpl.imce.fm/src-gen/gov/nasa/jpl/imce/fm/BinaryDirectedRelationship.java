/**
 */
package gov.nasa.jpl.imce.fm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Directed Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.fm.FmPackage#getBinaryDirectedRelationship()
 * @model abstract="true"
 * @generated
 */
public interface BinaryDirectedRelationship extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 * @generated
	 */
	Metaclass domain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 * @generated
	 */
	Type range();

} // BinaryDirectedRelationship
