/**
 */
package gov.nasa.jpl.imce.oml.model.bundles.impl;

import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction;
import gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom;

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.common.impl.ElementImpl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Disjoint Union Of Concepts Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.impl.DisjointUnionOfConceptsAxiomImpl#getDisjointTaxonomyParent <em>Disjoint Taxonomy Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DisjointUnionOfConceptsAxiomImpl extends ElementImpl implements DisjointUnionOfConceptsAxiom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisjointUnionOfConceptsAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BundlesPackage.Literals.DISJOINT_UNION_OF_CONCEPTS_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptTreeDisjunction getDisjointTaxonomyParent() {
		if (eContainerFeatureID() != BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT) return null;
		return (ConceptTreeDisjunction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptTreeDisjunction basicGetDisjointTaxonomyParent() {
		if (eContainerFeatureID() != BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT) return null;
		return (ConceptTreeDisjunction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDisjointTaxonomyParent(ConceptTreeDisjunction newDisjointTaxonomyParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDisjointTaxonomyParent, BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisjointTaxonomyParent(ConceptTreeDisjunction newDisjointTaxonomyParent) {
		if (newDisjointTaxonomyParent != eInternalContainer() || (eContainerFeatureID() != BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT && newDisjointTaxonomyParent != null)) {
			if (EcoreUtil.isAncestor(this, newDisjointTaxonomyParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDisjointTaxonomyParent != null)
				msgs = ((InternalEObject)newDisjointTaxonomyParent).eInverseAdd(this, BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS, ConceptTreeDisjunction.class, msgs);
			msgs = basicSetDisjointTaxonomyParent(newDisjointTaxonomyParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT, newDisjointTaxonomyParent, newDisjointTaxonomyParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptTreeDisjunction conceptTreeDisjunctionParent() {
		return this.getDisjointTaxonomyParent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module moduleContext() {
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
	public EList<Element> allNestedUnions() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDisjointTaxonomyParent((ConceptTreeDisjunction)otherEnd, msgs);
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
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT:
				return basicSetDisjointTaxonomyParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT:
				return eInternalContainer().eInverseRemove(this, BundlesPackage.CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS, ConceptTreeDisjunction.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT:
				if (resolve) return getDisjointTaxonomyParent();
				return basicGetDisjointTaxonomyParent();
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
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT:
				setDisjointTaxonomyParent((ConceptTreeDisjunction)newValue);
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
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT:
				setDisjointTaxonomyParent((ConceptTreeDisjunction)null);
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
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT:
				return basicGetDisjointTaxonomyParent() != null;
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
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM___CONCEPT_TREE_DISJUNCTION_PARENT:
				return conceptTreeDisjunctionParent();
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM___MODULE_CONTEXT:
				return moduleContext();
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM___ALL_NESTED_UNIONS:
				return allNestedUnions();
		}
		return super.eInvoke(operationID, arguments);
	}

} //DisjointUnionOfConceptsAxiomImpl
