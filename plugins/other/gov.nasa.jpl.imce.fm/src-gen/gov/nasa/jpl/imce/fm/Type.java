/**
 */
package gov.nasa.jpl.imce.fm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.fm.Type#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.fm.FmPackage#getType()
 * @model abstract="true"
 * @generated
 */
public interface Type extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(gov.nasa.jpl.imce.fm.String)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getType_Name()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.fm.DTString" required="true"
	 * @generated
	 */
	gov.nasa.jpl.imce.fm.String getName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.Type#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(gov.nasa.jpl.imce.fm.String value);

} // Type
