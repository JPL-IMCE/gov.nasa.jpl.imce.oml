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

import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction;
import gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.UUID;

import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous Concept Union Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.AnonymousConceptUnionAxiomImpl#getDisjunctions <em>Disjunctions</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.AnonymousConceptUnionAxiomImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnonymousConceptUnionAxiomImpl extends DisjointUnionOfConceptsAxiomImpl implements AnonymousConceptUnionAxiom {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnonymousConceptUnionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BundlesPackage.Literals.ANONYMOUS_CONCEPT_UNION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DisjointUnionOfConceptsAxiom> getDisjunctions() {
		if (disjunctions == null) {
			disjunctions = new EObjectContainmentWithInverseEList<DisjointUnionOfConceptsAxiom>(DisjointUnionOfConceptsAxiom.class, this, BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS, BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT);
		}
		return disjunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__NAME, oldName, name));
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
		String _name = this.getName();
		String _string_1 = null;
		if (_name!=null) {
			_string_1=_name.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("name", _string_1);
		UUID _namespaceUUID = OMLExtensions.namespaceUUID(_string, _mappedTo);
		String _string_2 = null;
		if (_namespaceUUID!=null) {
			_string_2=_namespaceUUID.toString();
		}
		return _string_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle bundleContainer() {
		ConceptTreeDisjunction _disjointTaxonomyParent = this.getDisjointTaxonomyParent();
		Bundle _bundleContainer = null;
		if (_disjointTaxonomyParent!=null) {
			_bundleContainer=_disjointTaxonomyParent.bundleContainer();
		}
		return _bundleContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogicalElement> allNestedElements() {
		BasicEList<LogicalElement> _xblockexpression = null;
		{
			final BasicEList<LogicalElement> nes = new BasicEList<LogicalElement>();
			nes.addAll(this.getDisjunctions());
			final Consumer<DisjointUnionOfConceptsAxiom> _function = new Consumer<DisjointUnionOfConceptsAxiom>() {
				public void accept(final DisjointUnionOfConceptsAxiom d) {
					nes.addAll(d.allNestedElements());
				}
			};
			this.getDisjunctions().forEach(_function);
			_xblockexpression = nes;
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
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS:
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
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS:
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
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS:
				return getDisjunctions();
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__NAME:
				return getName();
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
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS:
				getDisjunctions().clear();
				getDisjunctions().addAll((Collection<? extends DisjointUnionOfConceptsAxiom>)newValue);
				return;
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__NAME:
				setName((String)newValue);
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
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS:
				getDisjunctions().clear();
				return;
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__NAME:
				setName(NAME_EDEFAULT);
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
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS:
				return disjunctions != null && !disjunctions.isEmpty();
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
				case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS: return BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS;
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
				case BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS: return BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS;
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
		if (baseClass == CrossReferencabilityKind.class) {
			switch (baseOperationID) {
				case CommonPackage.CROSS_REFERENCABILITY_KIND___UUID: return BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM___UUID;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == DisjointUnionOfConceptsAxiom.class) {
			switch (baseOperationID) {
				case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM___ALL_NESTED_ELEMENTS: return BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM___ALL_NESTED_ELEMENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ConceptTreeDisjunction.class) {
			switch (baseOperationID) {
				case BundlesPackage.CONCEPT_TREE_DISJUNCTION___BUNDLE_CONTAINER: return BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM___BUNDLE_CONTAINER;
				case BundlesPackage.CONCEPT_TREE_DISJUNCTION___ALL_NESTED_ELEMENTS: return BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM___ALL_NESTED_ELEMENTS;
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
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM___UUID:
				return uuid();
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM___BUNDLE_CONTAINER:
				return bundleContainer();
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AnonymousConceptUnionAxiomImpl
