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

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;
import gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializedReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TermAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialized Reified Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SpecializedReifiedRelationshipImpl#getGeneral <em>General</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecializedReifiedRelationshipImpl extends ConceptualRelationshipImpl implements SpecializedReifiedRelationship {
	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected ConceptualRelationship general;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecializedReifiedRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.SPECIALIZED_REIFIED_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualRelationship getGeneral() {
		if (general != null && ((EObject)general).eIsProxy()) {
			InternalEObject oldGeneral = (InternalEObject)general;
			general = (ConceptualRelationship)eResolveProxy(oldGeneral);
			if (general != oldGeneral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP__GENERAL, oldGeneral, general));
			}
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualRelationship basicGetGeneral() {
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneral(ConceptualRelationship newGeneral) {
		ConceptualRelationship oldGeneral = general;
		general = newGeneral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP__GENERAL, oldGeneral, general));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity child() {
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity parent() {
		return this.getGeneral();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogicalElement> allNestedElements() {
		return ECollections.<LogicalElement>emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP__GENERAL:
				if (resolve) return getGeneral();
				return basicGetGeneral();
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
			case TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP__GENERAL:
				setGeneral((ConceptualRelationship)newValue);
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
			case TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP__GENERAL:
				setGeneral((ConceptualRelationship)null);
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
			case TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP__GENERAL:
				return general != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ModuleElement.class) {
			switch (baseOperationID) {
				case CommonPackage.MODULE_ELEMENT___ALL_NESTED_ELEMENTS: return TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Term.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.TERM___ALL_NESTED_ELEMENTS: return TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == TermAxiom.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ExtrinsicIdentityKind.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ElementCrossReferenceTuple.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == SpecializationAxiom.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.SPECIALIZATION_AXIOM___CHILD: return TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP___CHILD;
				case TerminologiesPackage.SPECIALIZATION_AXIOM___PARENT: return TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP___PARENT;
				case TerminologiesPackage.SPECIALIZATION_AXIOM___ALL_NESTED_ELEMENTS: return TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP___CHILD:
				return child();
			case TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP___PARENT:
				return parent();
			case TerminologiesPackage.SPECIALIZED_REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SpecializedReifiedRelationshipImpl
