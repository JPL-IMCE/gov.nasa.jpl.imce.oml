/**
 * 
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Relationship From Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromEntityImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromEntityImpl#isIsIdentityCriteria <em>Is Identity Criteria</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataRelationshipFromEntityImpl extends DataRelationshipDomainImpl implements DataRelationshipFromEntity {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Entity domain;

	/**
	 * The default value of the '{@link #isIsIdentityCriteria() <em>Is Identity Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIdentityCriteria()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IDENTITY_CRITERIA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsIdentityCriteria() <em>Is Identity Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIdentityCriteria()
	 * @generated
	 * @ordered
	 */
	protected boolean isIdentityCriteria = IS_IDENTITY_CRITERIA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataRelationshipFromEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.DATA_RELATIONSHIP_FROM_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (Entity)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Entity newDomain) {
		Entity oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIdentityCriteria() {
		return isIdentityCriteria;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIdentityCriteria(boolean newIsIdentityCriteria) {
		boolean oldIsIdentityCriteria = isIdentityCriteria;
		isIdentityCriteria = newIsIdentityCriteria;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA, oldIsIdentityCriteria, isIdentityCriteria));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA:
				return isIsIdentityCriteria();
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
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN:
				setDomain((Entity)newValue);
				return;
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA:
				setIsIdentityCriteria((Boolean)newValue);
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
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN:
				setDomain((Entity)null);
				return;
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA:
				setIsIdentityCriteria(IS_IDENTITY_CRITERIA_EDEFAULT);
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
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN:
				return domain != null;
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA:
				return isIdentityCriteria != IS_IDENTITY_CRITERIA_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isIdentityCriteria: ");
		result.append(isIdentityCriteria);
		result.append(')');
		return result.toString();
	}

} //DataRelationshipFromEntityImpl
