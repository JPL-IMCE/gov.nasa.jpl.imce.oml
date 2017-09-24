/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Relationship To Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DataRelationshipToStructure is an OML DataRelationship
 * whose range is an OML Structure.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDataRelationshipToStructure()
 * @model abstract="true"
 * @generated
 */
public interface DataRelationshipToStructure extends DataRelationshipRange {
	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(Structure)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getDataRelationshipToStructure_Range()
	 * @model required="true"
	 * @generated
	 */
	Structure getRange();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure#getRange <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(Structure value);

} // DataRelationshipToStructure
