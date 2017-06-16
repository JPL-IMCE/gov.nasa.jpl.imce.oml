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
package gov.nasa.jpl.imce.oml.runtime.impl;

import gov.nasa.jpl.imce.oml.runtime.OMLDescription;
import gov.nasa.jpl.imce.oml.runtime.OMLEntity;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OML Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl#getOmlName <em>Oml Name</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl#getOmlDescription <em>Oml Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OMLEntityImpl extends OMLObjectImpl implements OMLEntity {
	/**
	 * The default value of the '{@link #getOmlName() <em>Oml Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlName()
	 * @generated
	 * @ordered
	 */
	protected static final String OML_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOmlName() <em>Oml Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlName()
	 * @generated
	 * @ordered
	 */
	protected String omlName = OML_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMLRuntimePackage.Literals.OML_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOmlName() {
		return omlName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmlName(String newOmlName) {
		String oldOmlName = omlName;
		omlName = newOmlName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMLRuntimePackage.OML_ENTITY__OML_NAME, oldOmlName, omlName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLDescription getOmlDescription() {
		if (eContainerFeatureID() != OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION) return null;
		return (OMLDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLDescription basicGetOmlDescription() {
		if (eContainerFeatureID() != OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION) return null;
		return (OMLDescription)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOmlDescription(OMLDescription newOmlDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOmlDescription, OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmlDescription(OMLDescription newOmlDescription) {
		if (newOmlDescription != eInternalContainer() || (eContainerFeatureID() != OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION && newOmlDescription != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newOmlDescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOmlDescription != null)
				msgs = ((InternalEObject)newOmlDescription).eInverseAdd(this, OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS, OMLDescription.class, msgs);
			msgs = basicSetOmlDescription(newOmlDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION, newOmlDescription, newOmlDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOmlDescription((OMLDescription)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION:
				return basicSetOmlDescription(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION:
				return eInternalContainer().eInverseRemove(this, OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS, OMLDescription.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMLRuntimePackage.OML_ENTITY__OML_NAME:
				return getOmlName();
			case OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION:
				if (resolve) return getOmlDescription();
				return basicGetOmlDescription();
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
			case OMLRuntimePackage.OML_ENTITY__OML_NAME:
				setOmlName((String)newValue);
				return;
			case OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION:
				setOmlDescription((OMLDescription)newValue);
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
			case OMLRuntimePackage.OML_ENTITY__OML_NAME:
				setOmlName(OML_NAME_EDEFAULT);
				return;
			case OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION:
				setOmlDescription((OMLDescription)null);
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
			case OMLRuntimePackage.OML_ENTITY__OML_NAME:
				return OML_NAME_EDEFAULT == null ? omlName != null : !OML_NAME_EDEFAULT.equals(omlName);
			case OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION:
				return basicGetOmlDescription() != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (omlName: ");
		result.append(omlName);
		result.append(')');
		return result.toString();
	}

} //OMLEntityImpl
