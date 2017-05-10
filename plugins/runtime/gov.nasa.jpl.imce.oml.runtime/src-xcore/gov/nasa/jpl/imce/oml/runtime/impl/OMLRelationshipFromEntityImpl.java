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

import gov.nasa.jpl.imce.oml.runtime.OMLEntity;
import gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromEntity;
import gov.nasa.jpl.imce.oml.runtime.RuntimePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OML Relationship From Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromEntityImpl#getOmlSource <em>Oml Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OMLRelationshipFromEntityImpl extends OMLObjectImpl implements OMLRelationshipFromEntity {
	/**
	 * The cached value of the '{@link #getOmlSource() <em>Oml Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlSource()
	 * @generated
	 * @ordered
	 */
	protected OMLEntity omlSource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLRelationshipFromEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePackage.Literals.OML_RELATIONSHIP_FROM_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLEntity getOmlSource() {
		if (omlSource != null && ((EObject)omlSource).eIsProxy()) {
			InternalEObject oldOmlSource = (InternalEObject)omlSource;
			omlSource = (OMLEntity)eResolveProxy(oldOmlSource);
			if (omlSource != oldOmlSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePackage.OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE, oldOmlSource, omlSource));
			}
		}
		return omlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLEntity basicGetOmlSource() {
		return omlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmlSource(OMLEntity newOmlSource) {
		OMLEntity oldOmlSource = omlSource;
		omlSource = newOmlSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE, oldOmlSource, omlSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimePackage.OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE:
				if (resolve) return getOmlSource();
				return basicGetOmlSource();
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
			case RuntimePackage.OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE:
				setOmlSource((OMLEntity)newValue);
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
			case RuntimePackage.OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE:
				setOmlSource((OMLEntity)null);
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
			case RuntimePackage.OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE:
				return omlSource != null;
		}
		return super.eIsSet(featureID);
	}

} //OMLRelationshipFromEntityImpl
