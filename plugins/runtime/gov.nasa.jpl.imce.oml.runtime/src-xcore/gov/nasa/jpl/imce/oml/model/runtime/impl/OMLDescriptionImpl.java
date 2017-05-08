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
package gov.nasa.jpl.imce.oml.model.runtime.impl;

import gov.nasa.jpl.imce.oml.model.runtime.OMLDescription;
import gov.nasa.jpl.imce.oml.model.runtime.OMLObject;
import gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage;

import java.lang.reflect.InvocationTargetException;

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
 *   <li>{@link gov.nasa.jpl.imce.oml.model.runtime.impl.OMLDescriptionImpl#getOmlDesciptionIRI <em>Oml Desciption IRI</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.runtime.impl.OMLDescriptionImpl#getOmlDescriptionContents <em>Oml Description Contents</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OMLDescriptionImpl extends OMLObjectImpl implements OMLDescription {
	/**
	 * The default value of the '{@link #getOmlDesciptionIRI() <em>Oml Desciption IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlDesciptionIRI()
	 * @generated
	 * @ordered
	 */
	protected static final String OML_DESCIPTION_IRI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOmlDesciptionIRI() <em>Oml Desciption IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlDesciptionIRI()
	 * @generated
	 * @ordered
	 */
	protected String omlDesciptionIRI = OML_DESCIPTION_IRI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOmlDescriptionContents() <em>Oml Description Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlDescriptionContents()
	 * @generated
	 * @ordered
	 */
	protected EList<OMLObject> omlDescriptionContents;

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
		return RuntimePackage.Literals.OML_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOmlDesciptionIRI() {
		return omlDesciptionIRI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmlDesciptionIRI(String newOmlDesciptionIRI) {
		String oldOmlDesciptionIRI = omlDesciptionIRI;
		omlDesciptionIRI = newOmlDesciptionIRI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.OML_DESCRIPTION__OML_DESCIPTION_IRI, oldOmlDesciptionIRI, omlDesciptionIRI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OMLObject> getOmlDescriptionContents() {
		if (omlDescriptionContents == null) {
			omlDescriptionContents = new EObjectContainmentWithInverseEList<OMLObject>(OMLObject.class, this, RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS, RuntimePackage.OML_OBJECT__OML_ROOT);
		}
		return omlDescriptionContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLDescription getOMLRoot() {
		return this;
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
			case RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOmlDescriptionContents()).basicAdd(otherEnd, msgs);
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
			case RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS:
				return ((InternalEList<?>)getOmlDescriptionContents()).basicRemove(otherEnd, msgs);
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
			case RuntimePackage.OML_DESCRIPTION__OML_DESCIPTION_IRI:
				return getOmlDesciptionIRI();
			case RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS:
				return getOmlDescriptionContents();
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
			case RuntimePackage.OML_DESCRIPTION__OML_DESCIPTION_IRI:
				setOmlDesciptionIRI((String)newValue);
				return;
			case RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS:
				getOmlDescriptionContents().clear();
				getOmlDescriptionContents().addAll((Collection<? extends OMLObject>)newValue);
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
			case RuntimePackage.OML_DESCRIPTION__OML_DESCIPTION_IRI:
				setOmlDesciptionIRI(OML_DESCIPTION_IRI_EDEFAULT);
				return;
			case RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS:
				getOmlDescriptionContents().clear();
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
			case RuntimePackage.OML_DESCRIPTION__OML_DESCIPTION_IRI:
				return OML_DESCIPTION_IRI_EDEFAULT == null ? omlDesciptionIRI != null : !OML_DESCIPTION_IRI_EDEFAULT.equals(omlDesciptionIRI);
			case RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS:
				return omlDescriptionContents != null && !omlDescriptionContents.isEmpty();
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
			case RuntimePackage.OML_DESCRIPTION___GET_OML_ROOT:
				return getOMLRoot();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (omlDesciptionIRI: ");
		result.append(omlDesciptionIRI);
		result.append(')');
		return result.toString();
	}

} //OMLDescriptionImpl
