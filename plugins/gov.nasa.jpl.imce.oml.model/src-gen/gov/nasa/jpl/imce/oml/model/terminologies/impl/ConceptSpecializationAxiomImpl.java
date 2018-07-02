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

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.ConceptKind;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept Specialization Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptSpecializationAxiomImpl#getSubConcept <em>Sub Concept</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptSpecializationAxiomImpl#getSuperConcept <em>Super Concept</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptSpecializationAxiomImpl extends SpecializationAxiomImpl implements ConceptSpecializationAxiom {
	/**
	 * The cached value of the '{@link #getSubConcept() <em>Sub Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubConcept()
	 * @generated
	 * @ordered
	 */
	protected ConceptKind subConcept;

	/**
	 * The cached value of the '{@link #getSuperConcept() <em>Super Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperConcept()
	 * @generated
	 * @ordered
	 */
	protected ConceptKind superConcept;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptSpecializationAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.CONCEPT_SPECIALIZATION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptKind getSubConcept() {
		if (subConcept != null && subConcept.eIsProxy()) {
			InternalEObject oldSubConcept = (InternalEObject)subConcept;
			subConcept = (ConceptKind)eResolveProxy(oldSubConcept);
			if (subConcept != oldSubConcept) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT, oldSubConcept, subConcept));
			}
		}
		return subConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptKind basicGetSubConcept() {
		return subConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubConcept(ConceptKind newSubConcept) {
		ConceptKind oldSubConcept = subConcept;
		subConcept = newSubConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT, oldSubConcept, subConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptKind getSuperConcept() {
		if (superConcept != null && superConcept.eIsProxy()) {
			InternalEObject oldSuperConcept = (InternalEObject)superConcept;
			superConcept = (ConceptKind)eResolveProxy(oldSuperConcept);
			if (superConcept != oldSuperConcept) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT, oldSuperConcept, superConcept));
			}
		}
		return superConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptKind basicGetSuperConcept() {
		return superConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperConcept(ConceptKind newSuperConcept) {
		ConceptKind oldSuperConcept = superConcept;
		superConcept = newSuperConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT, oldSuperConcept, superConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity child() {
		return this.getSubConcept();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity parent() {
		return this.getSuperConcept();
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
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _uuid);
		ConceptKind _superConcept = this.getSuperConcept();
		String _uuid_1 = null;
		if (_superConcept!=null) {
			_uuid_1=_superConcept.uuid();
		}
		String _string = null;
		if (_uuid_1!=null) {
			_string=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("superConcept", _string);
		ConceptKind _subConcept = this.getSubConcept();
		String _uuid_2 = null;
		if (_subConcept!=null) {
			_uuid_2=_subConcept.uuid();
		}
		String _string_1 = null;
		if (_uuid_2!=null) {
			_string_1=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("subConcept", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"ConceptSpecializationAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
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
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT:
				if (resolve) return getSubConcept();
				return basicGetSubConcept();
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT:
				if (resolve) return getSuperConcept();
				return basicGetSuperConcept();
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
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT:
				setSubConcept((ConceptKind)newValue);
				return;
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT:
				setSuperConcept((ConceptKind)newValue);
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
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT:
				setSubConcept((ConceptKind)null);
				return;
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT:
				setSuperConcept((ConceptKind)null);
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
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT:
				return subConcept != null;
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT:
				return superConcept != null;
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
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM___CHILD:
				return child();
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM___PARENT:
				return parent();
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConceptSpecializationAxiomImpl
