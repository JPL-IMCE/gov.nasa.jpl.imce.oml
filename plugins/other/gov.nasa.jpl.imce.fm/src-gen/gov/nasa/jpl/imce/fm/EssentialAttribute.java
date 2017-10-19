/**
 */
package gov.nasa.jpl.imce.fm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Essential Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getSource <em>Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getTarget <em>Target</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getAttributeName <em>Attribute Name</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.fm.FmPackage#getEssentialAttribute()
 * @model
 * @generated
 */
public interface EssentialAttribute extends BinaryDirectedRelationship {
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
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getEssentialAttribute_Source()
	 * @model required="true"
	 * @generated
	 */
	InformationCarryingMetaclass getSource();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getSource <em>Source</em>}' reference.
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
	 * @see #setTarget(PrimitiveType)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getEssentialAttribute_Target()
	 * @model required="true"
	 * @generated
	 */
	PrimitiveType getTarget();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(gov.nasa.jpl.imce.fm.String)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getEssentialAttribute_AttributeName()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.fm.DTString" required="true"
	 * @generated
	 */
	gov.nasa.jpl.imce.fm.String getAttributeName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(gov.nasa.jpl.imce.fm.String value);

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

} // EssentialAttribute
