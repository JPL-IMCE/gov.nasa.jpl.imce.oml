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
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;

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
 * An implementation of the model object '<em><b>Terminology Extension Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyExtensionAxiomImpl#getExtendedTerminology <em>Extended Terminology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TerminologyExtensionAxiomImpl extends TerminologyBoxAxiomImpl implements TerminologyExtensionAxiom {
	/**
	 * The cached value of the '{@link #getExtendedTerminology() <em>Extended Terminology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedTerminology()
	 * @generated
	 * @ordered
	 */
	protected TerminologyBox extendedTerminology;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminologyExtensionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.TERMINOLOGY_EXTENSION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox getExtendedTerminology() {
		if (extendedTerminology != null && ((EObject)extendedTerminology).eIsProxy()) {
			InternalEObject oldExtendedTerminology = (InternalEObject)extendedTerminology;
			extendedTerminology = (TerminologyBox)eResolveProxy(oldExtendedTerminology);
			if (extendedTerminology != oldExtendedTerminology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY, oldExtendedTerminology, extendedTerminology));
			}
		}
		return extendedTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox basicGetExtendedTerminology() {
		return extendedTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedTerminology(TerminologyBox newExtendedTerminology) {
		TerminologyBox oldExtendedTerminology = extendedTerminology;
		extendedTerminology = newExtendedTerminology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY, oldExtendedTerminology, extendedTerminology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox extendingTerminology() {
		return this.getTbox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox source() {
		return this.extendingTerminology();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox target() {
		return this.getExtendedTerminology();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		TerminologyBox _tbox = this.getTbox();
		String _uuid = null;
		if (_tbox!=null) {
			_uuid=_tbox.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _string);
		TerminologyBox _extendedTerminology = this.getExtendedTerminology();
		String _uuid_1 = null;
		if (_extendedTerminology!=null) {
			_uuid_1=_extendedTerminology.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("extendedTerminology", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"TerminologyExtensionAxiom", _mappedTo, _mappedTo_1);
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
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY:
				if (resolve) return getExtendedTerminology();
				return basicGetExtendedTerminology();
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
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY:
				setExtendedTerminology((TerminologyBox)newValue);
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
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY:
				setExtendedTerminology((TerminologyBox)null);
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
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY:
				return extendedTerminology != null;
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
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM___EXTENDING_TERMINOLOGY:
				return extendingTerminology();
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM___SOURCE:
				return source();
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM___TARGET:
				return target();
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TerminologyExtensionAxiomImpl
