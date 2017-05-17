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
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement;

import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;

import gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.BundleImpl#getBundleAxioms <em>Bundle Axioms</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.BundleImpl#getBundleStatements <em>Bundle Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BundleImpl extends TerminologyBoxImpl implements Bundle {
	/**
	 * The cached value of the '{@link #getBundleAxioms() <em>Bundle Axioms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleAxioms()
	 * @generated
	 * @ordered
	 */
	protected EList<TerminologyBundleAxiom> bundleAxioms;

	/**
	 * The cached value of the '{@link #getBundleStatements() <em>Bundle Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<TerminologyBundleStatement> bundleStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BundlesPackage.Literals.BUNDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TerminologyBundleAxiom> getBundleAxioms() {
		if (bundleAxioms == null) {
			bundleAxioms = new EObjectContainmentWithInverseEList<TerminologyBundleAxiom>(TerminologyBundleAxiom.class, this, BundlesPackage.BUNDLE__BUNDLE_AXIOMS, BundlesPackage.TERMINOLOGY_BUNDLE_AXIOM__BUNDLE);
		}
		return bundleAxioms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TerminologyBundleStatement> getBundleStatements() {
		if (bundleStatements == null) {
			bundleStatements = new EObjectContainmentWithInverseEList<TerminologyBundleStatement>(TerminologyBundleStatement.class, this, BundlesPackage.BUNDLE__BUNDLE_STATEMENTS, BundlesPackage.TERMINOLOGY_BUNDLE_STATEMENT__BUNDLE);
		}
		return bundleStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleEdge> moduleEdges() {
		BasicEList<ModuleEdge> _xblockexpression = null;
		{
			final BasicEList<ModuleEdge> me = new BasicEList<ModuleEdge>();
			me.addAll(this.getBoxAxioms());
			me.addAll(this.getBundleAxioms());
			_xblockexpression = me;
		}
		return _xblockexpression;
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
			case BundlesPackage.BUNDLE__BUNDLE_AXIOMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBundleAxioms()).basicAdd(otherEnd, msgs);
			case BundlesPackage.BUNDLE__BUNDLE_STATEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBundleStatements()).basicAdd(otherEnd, msgs);
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
			case BundlesPackage.BUNDLE__BUNDLE_AXIOMS:
				return ((InternalEList<?>)getBundleAxioms()).basicRemove(otherEnd, msgs);
			case BundlesPackage.BUNDLE__BUNDLE_STATEMENTS:
				return ((InternalEList<?>)getBundleStatements()).basicRemove(otherEnd, msgs);
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
			case BundlesPackage.BUNDLE__BUNDLE_AXIOMS:
				return getBundleAxioms();
			case BundlesPackage.BUNDLE__BUNDLE_STATEMENTS:
				return getBundleStatements();
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
			case BundlesPackage.BUNDLE__BUNDLE_AXIOMS:
				getBundleAxioms().clear();
				getBundleAxioms().addAll((Collection<? extends TerminologyBundleAxiom>)newValue);
				return;
			case BundlesPackage.BUNDLE__BUNDLE_STATEMENTS:
				getBundleStatements().clear();
				getBundleStatements().addAll((Collection<? extends TerminologyBundleStatement>)newValue);
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
			case BundlesPackage.BUNDLE__BUNDLE_AXIOMS:
				getBundleAxioms().clear();
				return;
			case BundlesPackage.BUNDLE__BUNDLE_STATEMENTS:
				getBundleStatements().clear();
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
			case BundlesPackage.BUNDLE__BUNDLE_AXIOMS:
				return bundleAxioms != null && !bundleAxioms.isEmpty();
			case BundlesPackage.BUNDLE__BUNDLE_STATEMENTS:
				return bundleStatements != null && !bundleStatements.isEmpty();
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
			case BundlesPackage.BUNDLE___MODULE_EDGES:
				return moduleEdges();
		}
		return super.eInvoke(operationID, arguments);
	}

} //BundleImpl
