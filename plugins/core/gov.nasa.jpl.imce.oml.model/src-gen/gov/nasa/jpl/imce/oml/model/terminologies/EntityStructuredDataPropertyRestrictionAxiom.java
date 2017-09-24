/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Structured Data Property Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityStructuredDataPropertyRestrictionAxiom maps to
 * some kind of OWL2 Object Property Restriction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityStructuredDataPropertyRestrictionAxiom()
 * @model abstract="true"
 * @generated
 */
public interface EntityStructuredDataPropertyRestrictionAxiom extends TermAxiom {
	/**
	 * Returns the value of the '<em><b>Restricted Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Entity</em>' reference.
	 * @see #setRestrictedEntity(Entity)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityStructuredDataPropertyRestrictionAxiom_RestrictedEntity()
	 * @model required="true"
	 * @generated
	 */
	Entity getRestrictedEntity();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Entity</em>' reference.
	 * @see #getRestrictedEntity()
	 * @generated
	 */
	void setRestrictedEntity(Entity value);

} // EntityStructuredDataPropertyRestrictionAxiom
