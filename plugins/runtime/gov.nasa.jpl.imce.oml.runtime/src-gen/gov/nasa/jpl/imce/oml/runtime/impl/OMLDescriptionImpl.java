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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OML Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLDescriptionImpl#getOmlIRI <em>Oml IRI</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLDescriptionImpl#getOmlContents <em>Oml Contents</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OMLDescriptionImpl extends OMLObjectImpl implements OMLDescription {
	/**
	 * The default value of the '{@link #getOmlIRI() <em>Oml IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlIRI()
	 * @generated
	 * @ordered
	 */
	protected static final String OML_IRI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOmlIRI() <em>Oml IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlIRI()
	 * @generated
	 * @ordered
	 */
	protected String omlIRI = OML_IRI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOmlContents() <em>Oml Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlContents()
	 * @generated
	 * @ordered
	 */
	protected EList<OMLEntity> omlContents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMLRuntimePackage.Literals.OML_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOmlIRI() {
		return omlIRI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmlIRI(String newOmlIRI) {
		String oldOmlIRI = omlIRI;
		omlIRI = newOmlIRI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMLRuntimePackage.OML_DESCRIPTION__OML_IRI, oldOmlIRI, omlIRI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OMLEntity> getOmlContents() {
		if (omlContents == null) {
			omlContents = new EObjectContainmentWithInverseEList<OMLEntity>(OMLEntity.class, this, OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS, OMLRuntimePackage.OML_ENTITY__OML_DESCRIPTION);
		}
		return omlContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOmlContents()).basicAdd(otherEnd, msgs);
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
			case OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS:
				return ((InternalEList<?>)getOmlContents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMLRuntimePackage.OML_DESCRIPTION__OML_IRI:
				return getOmlIRI();
			case OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS:
				return getOmlContents();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OMLRuntimePackage.OML_DESCRIPTION__OML_IRI:
				setOmlIRI((String)newValue);
				return;
			case OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS:
				getOmlContents().clear();
				getOmlContents().addAll((Collection<? extends OMLEntity>)newValue);
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
			case OMLRuntimePackage.OML_DESCRIPTION__OML_IRI:
				setOmlIRI(OML_IRI_EDEFAULT);
				return;
			case OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS:
				getOmlContents().clear();
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
			case OMLRuntimePackage.OML_DESCRIPTION__OML_IRI:
				return OML_IRI_EDEFAULT == null ? omlIRI != null : !OML_IRI_EDEFAULT.equals(omlIRI);
			case OMLRuntimePackage.OML_DESCRIPTION__OML_CONTENTS:
				return omlContents != null && !omlContents.isEmpty();
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
		result.append(" (omlIRI: ");
		result.append(omlIRI);
		result.append(')');
		return result.toString();
	}

} //OMLDescriptionImpl
