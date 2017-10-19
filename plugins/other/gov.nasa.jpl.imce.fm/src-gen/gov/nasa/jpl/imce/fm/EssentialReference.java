/**
 */
package gov.nasa.jpl.imce.fm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Essential Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.fm.EssentialReference#getSource <em>Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.EssentialReference#getTarget <em>Target</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.EssentialReference#getReferenceName <em>Reference Name</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.fm.FmPackage#getEssentialReference()
 * @model
 * @generated
 */
public interface EssentialReference extends BinaryDirectedRelationship {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(InformationCarryingMetaclass)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getEssentialReference_Source()
	 * @model required="true"
	 * @generated
	 */
	InformationCarryingMetaclass getSource();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.EssentialReference#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(InformationCarryingMetaclass value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Entity)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getEssentialReference_Target()
	 * @model required="true"
	 * @generated
	 */
	Entity getTarget();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.EssentialReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Entity value);

	/**
	 * Returns the value of the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Name</em>' attribute.
	 * @see #setReferenceName(gov.nasa.jpl.imce.fm.String)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getEssentialReference_ReferenceName()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.fm.DTString" required="true"
	 * @generated
	 */
	gov.nasa.jpl.imce.fm.String getReferenceName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.EssentialReference#getReferenceName <em>Reference Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Name</em>' attribute.
	 * @see #getReferenceName()
	 * @generated
	 */
	void setReferenceName(gov.nasa.jpl.imce.fm.String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getSource();'"
	 * @generated
	 */
	Metaclass domain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTarget();'"
	 * @generated
	 */
	Type range();

} // EssentialReference
