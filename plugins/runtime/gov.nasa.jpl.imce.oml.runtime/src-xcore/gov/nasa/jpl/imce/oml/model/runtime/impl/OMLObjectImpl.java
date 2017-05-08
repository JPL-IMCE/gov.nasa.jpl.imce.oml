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

import com.google.common.collect.Iterables;

import gov.nasa.jpl.imce.oml.model.runtime.OMLDescription;
import gov.nasa.jpl.imce.oml.model.runtime.OMLObject;
import gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OML Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.runtime.impl.OMLObjectImpl#getOmlRoot <em>Oml Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OMLObjectImpl extends CDOObjectImpl implements OMLObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePackage.Literals.OML_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLDescription getOmlRoot() {
		if (eContainerFeatureID() != RuntimePackage.OML_OBJECT__OML_ROOT) return null;
		return (OMLDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLDescription basicGetOmlRoot() {
		if (eContainerFeatureID() != RuntimePackage.OML_OBJECT__OML_ROOT) return null;
		return (OMLDescription)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOmlRoot(OMLDescription newOmlRoot, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOmlRoot, RuntimePackage.OML_OBJECT__OML_ROOT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmlRoot(OMLDescription newOmlRoot) {
		if (newOmlRoot != eInternalContainer() || (eContainerFeatureID() != RuntimePackage.OML_OBJECT__OML_ROOT && newOmlRoot != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newOmlRoot))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOmlRoot != null)
				msgs = ((InternalEObject)newOmlRoot).eInverseAdd(this, RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS, OMLDescription.class, msgs);
			msgs = basicSetOmlRoot(newOmlRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.OML_OBJECT__OML_ROOT, newOmlRoot, newOmlRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends OMLObject> EList<T> omlInverseReferencers(final Class<T> aType) {
		EList<T> _xblockexpression = null; {
			final ResourceSet resourceSet = this.eResource().getResourceSet();
			final Iterable<ECrossReferenceAdapter> adapters = Iterables.<ECrossReferenceAdapter>filter(resourceSet.eAdapters(), ECrossReferenceAdapter.class);
			EList<T> _xifexpression = null;
			boolean _isEmpty = IterableExtensions.isEmpty(adapters);
			if (_isEmpty) {
				EList<T> _xblockexpression_1 = null;
				{
					final Collection<Setting> references = UsageCrossReferencer.find(this, resourceSet);
					_xblockexpression_1 = ECollections.<T>asEList(((T[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(Iterables.<T>filter(Iterables.<OMLObject>filter(references, OMLObject.class), aType), OMLObject.class)));
				}
				_xifexpression = _xblockexpression_1;
			}
			else {
				_xifexpression = ECollections.<T>asEList(((T[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(Iterables.<T>filter(Iterables.<OMLObject>filter(((ECrossReferenceAdapter[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(adapters, ECrossReferenceAdapter.class))[0].getInverseReferences(this), OMLObject.class), aType), OMLObject.class)));
			}
			_xblockexpression = _xifexpression;
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimePackage.OML_OBJECT__OML_ROOT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOmlRoot((OMLDescription)otherEnd, msgs);
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
			case RuntimePackage.OML_OBJECT__OML_ROOT:
				return basicSetOmlRoot(null, msgs);
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
			case RuntimePackage.OML_OBJECT__OML_ROOT:
				return eInternalContainer().eInverseRemove(this, RuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS, OMLDescription.class, msgs);
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
			case RuntimePackage.OML_OBJECT__OML_ROOT:
				if (resolve) return getOmlRoot();
				return basicGetOmlRoot();
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
			case RuntimePackage.OML_OBJECT__OML_ROOT:
				setOmlRoot((OMLDescription)newValue);
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
			case RuntimePackage.OML_OBJECT__OML_ROOT:
				setOmlRoot((OMLDescription)null);
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
			case RuntimePackage.OML_OBJECT__OML_ROOT:
				return basicGetOmlRoot() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RuntimePackage.OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS:
				return omlInverseReferencers((Class)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //OMLObjectImpl
