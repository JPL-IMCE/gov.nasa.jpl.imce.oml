/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Structured Data Property Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyRestrictionAxiomImpl#getRestrictedEntity <em>Restricted Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityStructuredDataPropertyRestrictionAxiomImpl extends TermAxiomImpl implements EntityStructuredDataPropertyRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getRestrictedEntity() <em>Restricted Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedEntity()
	 * @generated
	 * @ordered
	 */
	protected Entity restrictedEntity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityStructuredDataPropertyRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getRestrictedEntity() {
		if (restrictedEntity != null && restrictedEntity.eIsProxy()) {
			InternalEObject oldRestrictedEntity = (InternalEObject)restrictedEntity;
			restrictedEntity = (Entity)eResolveProxy(oldRestrictedEntity);
			if (restrictedEntity != oldRestrictedEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY, oldRestrictedEntity, restrictedEntity));
			}
		}
		return restrictedEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetRestrictedEntity() {
		return restrictedEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedEntity(Entity newRestrictedEntity) {
		Entity oldRestrictedEntity = restrictedEntity;
		restrictedEntity = newRestrictedEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY, oldRestrictedEntity, restrictedEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY:
				if (resolve) return getRestrictedEntity();
				return basicGetRestrictedEntity();
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY:
				setRestrictedEntity((Entity)newValue);
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY:
				setRestrictedEntity((Entity)null);
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY:
				return restrictedEntity != null;
		}
		return super.eIsSet(featureID);
	}

} //EntityStructuredDataPropertyRestrictionAxiomImpl
