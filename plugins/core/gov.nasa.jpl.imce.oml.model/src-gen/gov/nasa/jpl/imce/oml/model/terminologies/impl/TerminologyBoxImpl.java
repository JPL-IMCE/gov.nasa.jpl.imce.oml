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

import gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind;

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
 * An implementation of the model object '<em><b>Terminology Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl#getBoxAxioms <em>Box Axioms</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl#getBoxStatements <em>Box Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TerminologyBoxImpl extends ModuleImpl implements TerminologyBox {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final TerminologyKind KIND_EDEFAULT = TerminologyKind.OPEN_WORLD_DEFINITIONS;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected TerminologyKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBoxAxioms() <em>Box Axioms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoxAxioms()
	 * @generated
	 * @ordered
	 */
	protected EList<TerminologyBoxAxiom> boxAxioms;

	/**
	 * The cached value of the '{@link #getBoxStatements() <em>Box Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoxStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<TerminologyBoxStatement> boxStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminologyBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.TERMINOLOGY_BOX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(TerminologyKind newKind) {
		TerminologyKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TERMINOLOGY_BOX__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TerminologyBoxAxiom> getBoxAxioms() {
		if (boxAxioms == null) {
			boxAxioms = new EObjectContainmentWithInverseEList<TerminologyBoxAxiom>(TerminologyBoxAxiom.class, this, TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS, TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX);
		}
		return boxAxioms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TerminologyBoxStatement> getBoxStatements() {
		if (boxStatements == null) {
			boxStatements = new EObjectContainmentWithInverseEList<TerminologyBoxStatement>(TerminologyBoxStatement.class, this, TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS, TerminologiesPackage.TERMINOLOGY_BOX_STATEMENT__TBOX);
		}
		return boxStatements;
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
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBoxAxioms()).basicAdd(otherEnd, msgs);
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBoxStatements()).basicAdd(otherEnd, msgs);
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
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS:
				return ((InternalEList<?>)getBoxAxioms()).basicRemove(otherEnd, msgs);
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS:
				return ((InternalEList<?>)getBoxStatements()).basicRemove(otherEnd, msgs);
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
			case TerminologiesPackage.TERMINOLOGY_BOX__KIND:
				return getKind();
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS:
				return getBoxAxioms();
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS:
				return getBoxStatements();
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
			case TerminologiesPackage.TERMINOLOGY_BOX__KIND:
				setKind((TerminologyKind)newValue);
				return;
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS:
				getBoxAxioms().clear();
				getBoxAxioms().addAll((Collection<? extends TerminologyBoxAxiom>)newValue);
				return;
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS:
				getBoxStatements().clear();
				getBoxStatements().addAll((Collection<? extends TerminologyBoxStatement>)newValue);
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
			case TerminologiesPackage.TERMINOLOGY_BOX__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS:
				getBoxAxioms().clear();
				return;
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS:
				getBoxStatements().clear();
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
			case TerminologiesPackage.TERMINOLOGY_BOX__KIND:
				return kind != KIND_EDEFAULT;
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS:
				return boxAxioms != null && !boxAxioms.isEmpty();
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS:
				return boxStatements != null && !boxStatements.isEmpty();
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //TerminologyBoxImpl
