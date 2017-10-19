/**
 */
package gov.nasa.jpl.imce.fm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Composite Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getSource <em>Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getSourceRoleName <em>Source Role Name</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getTarget <em>Target</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getTargetRoleName <em>Target Role Name</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.fm.FmPackage#getBinaryCompositeAssociation()
 * @model
 * @generated
 */
public interface BinaryCompositeAssociation extends BinaryDirectedRelationship {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(InformationContainerMetaclass)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getBinaryCompositeAssociation_Source()
	 * @model required="true"
	 * @generated
	 */
	InformationContainerMetaclass getSource();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(InformationContainerMetaclass value);

	/**
	 * Returns the value of the '<em><b>Source Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Role Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Role Name</em>' attribute.
	 * @see #setSourceRoleName(gov.nasa.jpl.imce.fm.String)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getBinaryCompositeAssociation_SourceRoleName()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.fm.DTString" required="true"
	 * @generated
	 */
	gov.nasa.jpl.imce.fm.String getSourceRoleName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getSourceRoleName <em>Source Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Role Name</em>' attribute.
	 * @see #getSourceRoleName()
	 * @generated
	 */
	void setSourceRoleName(gov.nasa.jpl.imce.fm.String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(InformationCarryingMetaclass)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getBinaryCompositeAssociation_Target()
	 * @model required="true"
	 * @generated
	 */
	InformationCarryingMetaclass getTarget();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(InformationCarryingMetaclass value);

	/**
	 * Returns the value of the '<em><b>Target Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Role Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Role Name</em>' attribute.
	 * @see #setTargetRoleName(gov.nasa.jpl.imce.fm.String)
	 * @see gov.nasa.jpl.imce.fm.FmPackage#getBinaryCompositeAssociation_TargetRoleName()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.fm.DTString" required="true"
	 * @generated
	 */
	gov.nasa.jpl.imce.fm.String getTargetRoleName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getTargetRoleName <em>Target Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Role Name</em>' attribute.
	 * @see #getTargetRoleName()
	 * @generated
	 */
	void setTargetRoleName(gov.nasa.jpl.imce.fm.String value);

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

} // BinaryCompositeAssociation
