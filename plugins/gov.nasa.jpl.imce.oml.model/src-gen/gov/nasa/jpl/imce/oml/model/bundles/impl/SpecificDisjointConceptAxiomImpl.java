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

import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction;
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom;

import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.ConceptKind;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Disjoint Concept Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.SpecificDisjointConceptAxiomImpl#getDisjointLeaf <em>Disjoint Leaf</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecificDisjointConceptAxiomImpl extends DisjointUnionOfConceptsAxiomImpl implements SpecificDisjointConceptAxiom {
	/**
	 * The cached value of the '{@link #getDisjointLeaf() <em>Disjoint Leaf</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisjointLeaf()
	 * @generated
	 * @ordered
	 */
	protected ConceptKind disjointLeaf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificDisjointConceptAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BundlesPackage.Literals.SPECIFIC_DISJOINT_CONCEPT_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptKind getDisjointLeaf() {
		if (disjointLeaf != null && disjointLeaf.eIsProxy()) {
			InternalEObject oldDisjointLeaf = (InternalEObject)disjointLeaf;
			disjointLeaf = (ConceptKind)eResolveProxy(oldDisjointLeaf);
			if (disjointLeaf != oldDisjointLeaf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF, oldDisjointLeaf, disjointLeaf));
			}
		}
		return disjointLeaf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptKind basicGetDisjointLeaf() {
		return disjointLeaf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisjointLeaf(ConceptKind newDisjointLeaf) {
		ConceptKind oldDisjointLeaf = disjointLeaf;
		disjointLeaf = newDisjointLeaf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF, oldDisjointLeaf, disjointLeaf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		ConceptTreeDisjunction _disjointTaxonomyParent = this.getDisjointTaxonomyParent();
		String _uuid = null;
		if (_disjointTaxonomyParent!=null) {
			_uuid=_disjointTaxonomyParent.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("disjointTaxonomyParent", _string);
		ConceptKind _disjointLeaf = this.getDisjointLeaf();
		String _uuid_1 = null;
		if (_disjointLeaf!=null) {
			_uuid_1=_disjointLeaf.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("disjointLeaf", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"SpecificDisjointConceptAxiom", _mappedTo, _mappedTo_1);
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
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF:
				if (resolve) return getDisjointLeaf();
				return basicGetDisjointLeaf();
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
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF:
				setDisjointLeaf((ConceptKind)newValue);
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
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF:
				setDisjointLeaf((ConceptKind)null);
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
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF:
				return disjointLeaf != null;
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
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM___UUID:
				return uuid();
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SpecificDisjointConceptAxiomImpl
