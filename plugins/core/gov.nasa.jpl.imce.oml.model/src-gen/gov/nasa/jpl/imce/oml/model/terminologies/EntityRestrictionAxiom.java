/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.common.Element;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityRestrictionAxiom maps to an [OWL2 Object Property Restiction]
 * for an OML EntityRelationship.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedRelation <em>Restricted Relation</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedRange <em>Restricted Range</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedDomain <em>Restricted Domain</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityRestrictionAxiom()
 * @model abstract="true"
 * @generated
 */
public interface EntityRestrictionAxiom extends TermAxiom {
	/**
	 * Returns the value of the '<em><b>Restricted Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Relation</em>' reference.
	 * @see #setRestrictedRelation(EntityRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityRestrictionAxiom_RestrictedRelation()
	 * @model required="true"
	 * @generated
	 */
	EntityRelationship getRestrictedRelation();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedRelation <em>Restricted Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Relation</em>' reference.
	 * @see #getRestrictedRelation()
	 * @generated
	 */
	void setRestrictedRelation(EntityRelationship value);

	/**
	 * Returns the value of the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Range</em>' reference.
	 * @see #setRestrictedRange(Entity)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityRestrictionAxiom_RestrictedRange()
	 * @model required="true"
	 * @generated
	 */
	Entity getRestrictedRange();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedRange <em>Restricted Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Range</em>' reference.
	 * @see #getRestrictedRange()
	 * @generated
	 */
	void setRestrictedRange(Entity value);

	/**
	 * Returns the value of the '<em><b>Restricted Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Domain</em>' reference.
	 * @see #setRestrictedDomain(Entity)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityRestrictionAxiom_RestrictedDomain()
	 * @model required="true"
	 * @generated
	 */
	Entity getRestrictedDomain();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedDomain <em>Restricted Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Domain</em>' reference.
	 * @see #getRestrictedDomain()
	 * @generated
	 */
	void setRestrictedDomain(Entity value);

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

} // EntityRestrictionAxiom
