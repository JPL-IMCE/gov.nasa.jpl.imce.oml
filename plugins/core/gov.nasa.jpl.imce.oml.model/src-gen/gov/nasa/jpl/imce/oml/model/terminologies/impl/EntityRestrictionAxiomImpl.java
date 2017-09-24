/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRestrictionAxiomImpl#getRestrictedRelation <em>Restricted Relation</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRestrictionAxiomImpl#getRestrictedRange <em>Restricted Range</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRestrictionAxiomImpl#getRestrictedDomain <em>Restricted Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityRestrictionAxiomImpl extends TermAxiomImpl implements EntityRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getRestrictedRelation() <em>Restricted Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedRelation()
	 * @generated
	 * @ordered
	 */
	protected EntityRelationship restrictedRelation;

	/**
	 * The cached value of the '{@link #getRestrictedRange() <em>Restricted Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedRange()
	 * @generated
	 * @ordered
	 */
	protected Entity restrictedRange;

	/**
	 * The cached value of the '{@link #getRestrictedDomain() <em>Restricted Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedDomain()
	 * @generated
	 * @ordered
	 */
	protected Entity restrictedDomain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRelationship getRestrictedRelation() {
		if (restrictedRelation != null && restrictedRelation.eIsProxy()) {
			InternalEObject oldRestrictedRelation = (InternalEObject)restrictedRelation;
			restrictedRelation = (EntityRelationship)eResolveProxy(oldRestrictedRelation);
			if (restrictedRelation != oldRestrictedRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION, oldRestrictedRelation, restrictedRelation));
			}
		}
		return restrictedRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRelationship basicGetRestrictedRelation() {
		return restrictedRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedRelation(EntityRelationship newRestrictedRelation) {
		EntityRelationship oldRestrictedRelation = restrictedRelation;
		restrictedRelation = newRestrictedRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION, oldRestrictedRelation, restrictedRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getRestrictedRange() {
		if (restrictedRange != null && restrictedRange.eIsProxy()) {
			InternalEObject oldRestrictedRange = (InternalEObject)restrictedRange;
			restrictedRange = (Entity)eResolveProxy(oldRestrictedRange);
			if (restrictedRange != oldRestrictedRange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE, oldRestrictedRange, restrictedRange));
			}
		}
		return restrictedRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetRestrictedRange() {
		return restrictedRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedRange(Entity newRestrictedRange) {
		Entity oldRestrictedRange = restrictedRange;
		restrictedRange = newRestrictedRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE, oldRestrictedRange, restrictedRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getRestrictedDomain() {
		if (restrictedDomain != null && restrictedDomain.eIsProxy()) {
			InternalEObject oldRestrictedDomain = (InternalEObject)restrictedDomain;
			restrictedDomain = (Entity)eResolveProxy(oldRestrictedDomain);
			if (restrictedDomain != oldRestrictedDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN, oldRestrictedDomain, restrictedDomain));
			}
		}
		return restrictedDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetRestrictedDomain() {
		return restrictedDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedDomain(Entity newRestrictedDomain) {
		Entity oldRestrictedDomain = restrictedDomain;
		restrictedDomain = newRestrictedDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN, oldRestrictedDomain, restrictedDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> allNestedElements() {
		return ECollections.<Element>emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION:
				if (resolve) return getRestrictedRelation();
				return basicGetRestrictedRelation();
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE:
				if (resolve) return getRestrictedRange();
				return basicGetRestrictedRange();
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN:
				if (resolve) return getRestrictedDomain();
				return basicGetRestrictedDomain();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION:
				setRestrictedRelation((EntityRelationship)newValue);
				return;
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE:
				setRestrictedRange((Entity)newValue);
				return;
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN:
				setRestrictedDomain((Entity)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION:
				setRestrictedRelation((EntityRelationship)null);
				return;
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE:
				setRestrictedRange((Entity)null);
				return;
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN:
				setRestrictedDomain((Entity)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION:
				return restrictedRelation != null;
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE:
				return restrictedRange != null;
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN:
				return restrictedDomain != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityRestrictionAxiomImpl
