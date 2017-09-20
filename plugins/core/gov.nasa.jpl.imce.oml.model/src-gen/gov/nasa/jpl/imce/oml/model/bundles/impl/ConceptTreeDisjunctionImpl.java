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
import gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction;
import gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom;

import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.common.impl.ElementImpl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept Tree Disjunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.ConceptTreeDisjunctionImpl#getDisjunctions <em>Disjunctions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConceptTreeDisjunctionImpl extends ElementImpl implements ConceptTreeDisjunction {
	/**
	 * The cached value of the '{@link #getDisjunctions() <em>Disjunctions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisjunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<DisjointUnionOfConceptsAxiom> disjunctions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptTreeDisjunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BundlesPackage.Literals.CONCEPT_TREE_DISJUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DisjointUnionOfConceptsAxiom> getDisjunctions() {
		if (disjunctions == null) {
			disjunctions = new EObjectContainmentWithInverseEList<DisjointUnionOfConceptsAxiom>(DisjointUnionOfConceptsAxiom.class, this, BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS, BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT);
		}
		return disjunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle bundleContainer() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> allNestedDisjunctions() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDisjunctions()).basicAdd(otherEnd, msgs);
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
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS:
				return ((InternalEList<?>)getDisjunctions()).basicRemove(otherEnd, msgs);
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
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS:
				return getDisjunctions();
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
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS:
				getDisjunctions().clear();
				getDisjunctions().addAll((Collection<? extends DisjointUnionOfConceptsAxiom>)newValue);
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
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS:
				getDisjunctions().clear();
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
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS:
				return disjunctions != null && !disjunctions.isEmpty();
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
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION___BUNDLE_CONTAINER:
				return bundleContainer();
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION___ALL_NESTED_DISJUNCTIONS:
				return allNestedDisjunctions();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConceptTreeDisjunctionImpl
