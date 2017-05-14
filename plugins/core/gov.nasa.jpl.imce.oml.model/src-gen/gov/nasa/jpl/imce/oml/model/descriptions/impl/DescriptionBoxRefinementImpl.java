/**
 * 
 * Copyright 2016 California Institute of Technology ("Caltech").
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
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description Box Refinement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRefinementImpl#getRefiningDescriptionBox <em>Refining Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRefinementImpl#getRefinedDescriptionBox <em>Refined Description Box</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DescriptionBoxRefinementImpl extends DescriptionBoxRelationshipImpl implements DescriptionBoxRefinement {
	/**
	 * The cached value of the '{@link #getRefinedDescriptionBox() <em>Refined Description Box</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinedDescriptionBox()
	 * @generated
	 * @ordered
	 */
	protected DescriptionBox refinedDescriptionBox;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionBoxRefinementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.DESCRIPTION_BOX_REFINEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox getRefiningDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX) return null;
		return (DescriptionBox)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox basicGetRefiningDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX) return null;
		return (DescriptionBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefiningDescriptionBox(DescriptionBox newRefiningDescriptionBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRefiningDescriptionBox, DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefiningDescriptionBox(DescriptionBox newRefiningDescriptionBox) {
		if (newRefiningDescriptionBox != eInternalContainer() || (eContainerFeatureID() != DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX && newRefiningDescriptionBox != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newRefiningDescriptionBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefiningDescriptionBox != null)
				msgs = ((InternalEObject)newRefiningDescriptionBox).eInverseAdd(this, DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS, DescriptionBox.class, msgs);
			msgs = basicSetRefiningDescriptionBox(newRefiningDescriptionBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX, newRefiningDescriptionBox, newRefiningDescriptionBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox getRefinedDescriptionBox() {
		if (refinedDescriptionBox != null && ((EObject)refinedDescriptionBox).eIsProxy()) {
			InternalEObject oldRefinedDescriptionBox = (InternalEObject)refinedDescriptionBox;
			refinedDescriptionBox = (DescriptionBox)eResolveProxy(oldRefinedDescriptionBox);
			if (refinedDescriptionBox != oldRefinedDescriptionBox) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX, oldRefinedDescriptionBox, refinedDescriptionBox));
			}
		}
		return refinedDescriptionBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox basicGetRefinedDescriptionBox() {
		return refinedDescriptionBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedDescriptionBox(DescriptionBox newRefinedDescriptionBox) {
		DescriptionBox oldRefinedDescriptionBox = refinedDescriptionBox;
		refinedDescriptionBox = newRefinedDescriptionBox;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX, oldRefinedDescriptionBox, refinedDescriptionBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox descriptionDomain() {
		return this.getRefiningDescriptionBox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module targetModule() {
		return this.getRefinedDescriptionBox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		DescriptionBox _refiningDescriptionBox = this.getRefiningDescriptionBox();
		String _uuid = null;
		if (_refiningDescriptionBox!=null) {
			_uuid=_refiningDescriptionBox.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("refiningDescriptionBox", _string);
		DescriptionBox _refinedDescriptionBox = this.getRefinedDescriptionBox();
		String _uuid_1 = null;
		if (_refinedDescriptionBox!=null) {
			_uuid_1=_refinedDescriptionBox.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("refinedDescriptionBox", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"DescriptionBoxRefinement", _mappedTo, _mappedTo_1);
		String _string_2 = null;
		if (_derivedUUID!=null) {
			_string_2=_derivedUUID.toString();
		}
		return _string_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRefiningDescriptionBox((DescriptionBox)otherEnd, msgs);
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
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX:
				return basicSetRefiningDescriptionBox(null, msgs);
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
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX:
				return eInternalContainer().eInverseRemove(this, DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS, DescriptionBox.class, msgs);
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
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX:
				if (resolve) return getRefiningDescriptionBox();
				return basicGetRefiningDescriptionBox();
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX:
				if (resolve) return getRefinedDescriptionBox();
				return basicGetRefinedDescriptionBox();
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
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX:
				setRefiningDescriptionBox((DescriptionBox)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX:
				setRefinedDescriptionBox((DescriptionBox)newValue);
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
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX:
				setRefiningDescriptionBox((DescriptionBox)null);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX:
				setRefinedDescriptionBox((DescriptionBox)null);
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
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX:
				return basicGetRefiningDescriptionBox() != null;
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX:
				return refinedDescriptionBox != null;
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
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT___DESCRIPTION_DOMAIN:
				return descriptionDomain();
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT___TARGET_MODULE:
				return targetModule();
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //DescriptionBoxRefinementImpl
