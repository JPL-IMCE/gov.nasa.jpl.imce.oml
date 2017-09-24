/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.common.Element;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Scalar Data Property Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityScalarDataPropertyRestrictionAxiom maps to
 * some kind of OWL2 Data Property Restriction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom#getScalarProperty <em>Scalar Property</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityScalarDataPropertyRestrictionAxiom()
 * @model abstract="true"
 * @generated
 */
public interface EntityScalarDataPropertyRestrictionAxiom extends TermAxiom {
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
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityScalarDataPropertyRestrictionAxiom_RestrictedEntity()
	 * @model required="true"
	 * @generated
	 */
	Entity getRestrictedEntity();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Entity</em>' reference.
	 * @see #getRestrictedEntity()
	 * @generated
	 */
	void setRestrictedEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Scalar Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalar Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalar Property</em>' reference.
	 * @see #setScalarProperty(EntityScalarDataProperty)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityScalarDataPropertyRestrictionAxiom_ScalarProperty()
	 * @model required="true"
	 * @generated
	 */
	EntityScalarDataProperty getScalarProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom#getScalarProperty <em>Scalar Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalar Property</em>' reference.
	 * @see #getScalarProperty()
	 * @generated
	 */
	void setScalarProperty(EntityScalarDataProperty value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='scala.collection.immutable.Set.empty[resolver.api.Element]'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt;emptyEList();'"
	 * @generated
	 */
	EList<Element> allNestedElements();

} // EntityScalarDataPropertyRestrictionAxiom
