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
package gov.nasa.jpl.imce.oml.model.bundles.impl;

import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundled Terminology Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.BundledTerminologyAxiomImpl#getBundledTerminology <em>Bundled Terminology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BundledTerminologyAxiomImpl extends TerminologyBundleAxiomImpl implements BundledTerminologyAxiom {
	/**
	 * The cached value of the '{@link #getBundledTerminology() <em>Bundled Terminology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundledTerminology()
	 * @generated
	 * @ordered
	 */
	protected TerminologyBox bundledTerminology;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundledTerminologyAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BundlesPackage.Literals.BUNDLED_TERMINOLOGY_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox getBundledTerminology() {
		if (bundledTerminology != null && ((EObject)bundledTerminology).eIsProxy()) {
			InternalEObject oldBundledTerminology = (InternalEObject)bundledTerminology;
			bundledTerminology = (TerminologyBox)eResolveProxy(oldBundledTerminology);
			if (bundledTerminology != oldBundledTerminology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY, oldBundledTerminology, bundledTerminology));
			}
		}
		return bundledTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox basicGetBundledTerminology() {
		return bundledTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundledTerminology(TerminologyBox newBundledTerminology) {
		TerminologyBox oldBundledTerminology = bundledTerminology;
		bundledTerminology = newBundledTerminology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY, oldBundledTerminology, bundledTerminology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox source() {
		return this.getBundle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox target() {
		return this.getBundledTerminology();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		TerminologyBox _bundledTerminology = this.getBundledTerminology();
		String _uuid = null;
		if (_bundledTerminology!=null) {
			_uuid=_bundledTerminology.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("bundledTerminology", _string);
		Bundle _bundle = this.getBundle();
		String _uuid_1 = null;
		if (_bundle!=null) {
			_uuid_1=_bundle.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("bundle", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"BundledTerminologyAxiom", _mappedTo, _mappedTo_1);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY:
				if (resolve) return getBundledTerminology();
				return basicGetBundledTerminology();
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
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY:
				setBundledTerminology((TerminologyBox)newValue);
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
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY:
				setBundledTerminology((TerminologyBox)null);
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
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY:
				return bundledTerminology != null;
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
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM___SOURCE:
				return source();
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM___TARGET:
				return target();
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //BundledTerminologyAxiomImpl
