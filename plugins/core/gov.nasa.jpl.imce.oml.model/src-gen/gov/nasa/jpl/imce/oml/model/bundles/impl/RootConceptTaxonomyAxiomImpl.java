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
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.Concept;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Concept Taxonomy Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.RootConceptTaxonomyAxiomImpl#getDisjunctions <em>Disjunctions</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.RootConceptTaxonomyAxiomImpl#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootConceptTaxonomyAxiomImpl extends TerminologyBundleStatementImpl implements RootConceptTaxonomyAxiom {
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
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected Concept root;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootConceptTaxonomyAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BundlesPackage.Literals.ROOT_CONCEPT_TAXONOMY_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DisjointUnionOfConceptsAxiom> getDisjunctions() {
		if (disjunctions == null) {
			disjunctions = new EObjectContainmentWithInverseEList<DisjointUnionOfConceptsAxiom>(DisjointUnionOfConceptsAxiom.class, this, BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS, BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT);
		}
		return disjunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept getRoot() {
		if (root != null && ((EObject)root).eIsProxy()) {
			InternalEObject oldRoot = (InternalEObject)root;
			root = (Concept)eResolveProxy(oldRoot);
			if (root != oldRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT, oldRoot, root));
			}
		}
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept basicGetRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(Concept newRoot) {
		Concept oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		Bundle _bundle = this.getBundle();
		String _uuid = null;
		if (_bundle!=null) {
			_uuid=_bundle.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("bundle", _string);
		Concept _root = this.getRoot();
		String _uuid_1 = null;
		if (_root!=null) {
			_uuid_1=_root.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("root", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"RootConceptTaxonomyAxiom", _mappedTo, _mappedTo_1);
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
	public Bundle bundleContainer() {
		return this.getBundle();
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
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS:
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
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS:
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
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS:
				return getDisjunctions();
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
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
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS:
				getDisjunctions().clear();
				getDisjunctions().addAll((Collection<? extends DisjointUnionOfConceptsAxiom>)newValue);
				return;
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT:
				setRoot((Concept)newValue);
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
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS:
				getDisjunctions().clear();
				return;
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT:
				setRoot((Concept)null);
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
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS:
				return disjunctions != null && !disjunctions.isEmpty();
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT:
				return root != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ConceptTreeDisjunction.class) {
			switch (derivedFeatureID) {
				case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS: return BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ConceptTreeDisjunction.class) {
			switch (baseFeatureID) {
				case BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS: return BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Element.class) {
			switch (baseOperationID) {
				case CommonPackage.ELEMENT___UUID: return BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM___UUID;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ConceptTreeDisjunction.class) {
			switch (baseOperationID) {
				case BundlesPackage.CONCEPT_TREE_DISJUNCTION___BUNDLE_CONTAINER: return BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM___BUNDLE_CONTAINER;
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
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM___UUID:
				return uuid();
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM___BUNDLE_CONTAINER:
				return bundleContainer();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RootConceptTaxonomyAxiomImpl
