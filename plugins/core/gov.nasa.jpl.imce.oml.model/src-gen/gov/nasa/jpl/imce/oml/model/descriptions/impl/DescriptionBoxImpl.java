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
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;

import gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl;

import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getDescriptionBoxRefinements <em>Description Box Refinements</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getClosedWorldDefinitions <em>Closed World Definitions</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getConceptInstances <em>Concept Instances</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getReifiedRelationshipInstances <em>Reified Relationship Instances</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getReifiedRelationshipInstanceDomains <em>Reified Relationship Instance Domains</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getReifiedRelationshipInstanceRanges <em>Reified Relationship Instance Ranges</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getUnreifiedRelationshipInstanceTuples <em>Unreified Relationship Instance Tuples</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getSingletonScalarDataPropertyValues <em>Singleton Scalar Data Property Values</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl#getSingletonStructuredDataPropertyValues <em>Singleton Structured Data Property Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DescriptionBoxImpl extends ModuleImpl implements DescriptionBox {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final DescriptionKind KIND_EDEFAULT = DescriptionKind.FINAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected DescriptionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescriptionBoxRefinements() <em>Description Box Refinements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionBoxRefinements()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptionBoxRefinement> descriptionBoxRefinements;

	/**
	 * The cached value of the '{@link #getClosedWorldDefinitions() <em>Closed World Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClosedWorldDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptionBoxExtendsClosedWorldDefinitions> closedWorldDefinitions;

	/**
	 * The cached value of the '{@link #getConceptInstances() <em>Concept Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptInstance> conceptInstances;

	/**
	 * The cached value of the '{@link #getReifiedRelationshipInstances() <em>Reified Relationship Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReifiedRelationshipInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ReifiedRelationshipInstance> reifiedRelationshipInstances;

	/**
	 * The cached value of the '{@link #getReifiedRelationshipInstanceDomains() <em>Reified Relationship Instance Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReifiedRelationshipInstanceDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<ReifiedRelationshipInstanceDomain> reifiedRelationshipInstanceDomains;

	/**
	 * The cached value of the '{@link #getReifiedRelationshipInstanceRanges() <em>Reified Relationship Instance Ranges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReifiedRelationshipInstanceRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<ReifiedRelationshipInstanceRange> reifiedRelationshipInstanceRanges;

	/**
	 * The cached value of the '{@link #getUnreifiedRelationshipInstanceTuples() <em>Unreified Relationship Instance Tuples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnreifiedRelationshipInstanceTuples()
	 * @generated
	 * @ordered
	 */
	protected EList<UnreifiedRelationshipInstanceTuple> unreifiedRelationshipInstanceTuples;

	/**
	 * The cached value of the '{@link #getSingletonScalarDataPropertyValues() <em>Singleton Scalar Data Property Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingletonScalarDataPropertyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<SingletonInstanceScalarDataPropertyValue> singletonScalarDataPropertyValues;

	/**
	 * The cached value of the '{@link #getSingletonStructuredDataPropertyValues() <em>Singleton Structured Data Property Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingletonStructuredDataPropertyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<SingletonInstanceStructuredDataPropertyValue> singletonStructuredDataPropertyValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.DESCRIPTION_BOX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(DescriptionKind newKind) {
		DescriptionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.DESCRIPTION_BOX__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DescriptionBoxRefinement> getDescriptionBoxRefinements() {
		if (descriptionBoxRefinements == null) {
			descriptionBoxRefinements = new EObjectContainmentWithInverseEList<DescriptionBoxRefinement>(DescriptionBoxRefinement.class, this, DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS, DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX);
		}
		return descriptionBoxRefinements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DescriptionBoxExtendsClosedWorldDefinitions> getClosedWorldDefinitions() {
		if (closedWorldDefinitions == null) {
			closedWorldDefinitions = new EObjectContainmentWithInverseEList<DescriptionBoxExtendsClosedWorldDefinitions>(DescriptionBoxExtendsClosedWorldDefinitions.class, this, DescriptionsPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS, DescriptionsPackage.DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__DESCRIPTION_BOX);
		}
		return closedWorldDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptInstance> getConceptInstances() {
		if (conceptInstances == null) {
			conceptInstances = new EObjectContainmentWithInverseEList<ConceptInstance>(ConceptInstance.class, this, DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES, DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX);
		}
		return conceptInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReifiedRelationshipInstance> getReifiedRelationshipInstances() {
		if (reifiedRelationshipInstances == null) {
			reifiedRelationshipInstances = new EObjectContainmentWithInverseEList<ReifiedRelationshipInstance>(ReifiedRelationshipInstance.class, this, DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES, DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX);
		}
		return reifiedRelationshipInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReifiedRelationshipInstanceDomain> getReifiedRelationshipInstanceDomains() {
		if (reifiedRelationshipInstanceDomains == null) {
			reifiedRelationshipInstanceDomains = new EObjectContainmentWithInverseEList<ReifiedRelationshipInstanceDomain>(ReifiedRelationshipInstanceDomain.class, this, DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS, DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DESCRIPTION_BOX);
		}
		return reifiedRelationshipInstanceDomains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReifiedRelationshipInstanceRange> getReifiedRelationshipInstanceRanges() {
		if (reifiedRelationshipInstanceRanges == null) {
			reifiedRelationshipInstanceRanges = new EObjectContainmentWithInverseEList<ReifiedRelationshipInstanceRange>(ReifiedRelationshipInstanceRange.class, this, DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES, DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE_RANGE__DESCRIPTION_BOX);
		}
		return reifiedRelationshipInstanceRanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnreifiedRelationshipInstanceTuple> getUnreifiedRelationshipInstanceTuples() {
		if (unreifiedRelationshipInstanceTuples == null) {
			unreifiedRelationshipInstanceTuples = new EObjectContainmentWithInverseEList<UnreifiedRelationshipInstanceTuple>(UnreifiedRelationshipInstanceTuple.class, this, DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX);
		}
		return unreifiedRelationshipInstanceTuples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SingletonInstanceScalarDataPropertyValue> getSingletonScalarDataPropertyValues() {
		if (singletonScalarDataPropertyValues == null) {
			singletonScalarDataPropertyValues = new EObjectContainmentWithInverseEList<SingletonInstanceScalarDataPropertyValue>(SingletonInstanceScalarDataPropertyValue.class, this, DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX);
		}
		return singletonScalarDataPropertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SingletonInstanceStructuredDataPropertyValue> getSingletonStructuredDataPropertyValues() {
		if (singletonStructuredDataPropertyValues == null) {
			singletonStructuredDataPropertyValues = new EObjectContainmentWithInverseEList<SingletonInstanceStructuredDataPropertyValue>(SingletonInstanceStructuredDataPropertyValue.class, this, DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES, DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX);
		}
		return singletonStructuredDataPropertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleEdge> moduleEdges() {
		BasicEList<ModuleEdge> _xblockexpression = null; {
			final BasicEList<ModuleEdge> me = new BasicEList<ModuleEdge>();
			me.addAll(this.getDescriptionBoxRefinements());
			me.addAll(this.getClosedWorldDefinitions());
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
			case DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDescriptionBoxRefinements()).basicAdd(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClosedWorldDefinitions()).basicAdd(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConceptInstances()).basicAdd(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReifiedRelationshipInstances()).basicAdd(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReifiedRelationshipInstanceDomains()).basicAdd(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReifiedRelationshipInstanceRanges()).basicAdd(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnreifiedRelationshipInstanceTuples()).basicAdd(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSingletonScalarDataPropertyValues()).basicAdd(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSingletonStructuredDataPropertyValues()).basicAdd(otherEnd, msgs);
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
			case DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS:
				return ((InternalEList<?>)getDescriptionBoxRefinements()).basicRemove(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS:
				return ((InternalEList<?>)getClosedWorldDefinitions()).basicRemove(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES:
				return ((InternalEList<?>)getConceptInstances()).basicRemove(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES:
				return ((InternalEList<?>)getReifiedRelationshipInstances()).basicRemove(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS:
				return ((InternalEList<?>)getReifiedRelationshipInstanceDomains()).basicRemove(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES:
				return ((InternalEList<?>)getReifiedRelationshipInstanceRanges()).basicRemove(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES:
				return ((InternalEList<?>)getUnreifiedRelationshipInstanceTuples()).basicRemove(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES:
				return ((InternalEList<?>)getSingletonScalarDataPropertyValues()).basicRemove(otherEnd, msgs);
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES:
				return ((InternalEList<?>)getSingletonStructuredDataPropertyValues()).basicRemove(otherEnd, msgs);
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
			case DescriptionsPackage.DESCRIPTION_BOX__KIND:
				return getKind();
			case DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS:
				return getDescriptionBoxRefinements();
			case DescriptionsPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS:
				return getClosedWorldDefinitions();
			case DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES:
				return getConceptInstances();
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES:
				return getReifiedRelationshipInstances();
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS:
				return getReifiedRelationshipInstanceDomains();
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES:
				return getReifiedRelationshipInstanceRanges();
			case DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES:
				return getUnreifiedRelationshipInstanceTuples();
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES:
				return getSingletonScalarDataPropertyValues();
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES:
				return getSingletonStructuredDataPropertyValues();
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
			case DescriptionsPackage.DESCRIPTION_BOX__KIND:
				setKind((DescriptionKind)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS:
				getDescriptionBoxRefinements().clear();
				getDescriptionBoxRefinements().addAll((Collection<? extends DescriptionBoxRefinement>)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS:
				getClosedWorldDefinitions().clear();
				getClosedWorldDefinitions().addAll((Collection<? extends DescriptionBoxExtendsClosedWorldDefinitions>)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES:
				getConceptInstances().clear();
				getConceptInstances().addAll((Collection<? extends ConceptInstance>)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES:
				getReifiedRelationshipInstances().clear();
				getReifiedRelationshipInstances().addAll((Collection<? extends ReifiedRelationshipInstance>)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS:
				getReifiedRelationshipInstanceDomains().clear();
				getReifiedRelationshipInstanceDomains().addAll((Collection<? extends ReifiedRelationshipInstanceDomain>)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES:
				getReifiedRelationshipInstanceRanges().clear();
				getReifiedRelationshipInstanceRanges().addAll((Collection<? extends ReifiedRelationshipInstanceRange>)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES:
				getUnreifiedRelationshipInstanceTuples().clear();
				getUnreifiedRelationshipInstanceTuples().addAll((Collection<? extends UnreifiedRelationshipInstanceTuple>)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES:
				getSingletonScalarDataPropertyValues().clear();
				getSingletonScalarDataPropertyValues().addAll((Collection<? extends SingletonInstanceScalarDataPropertyValue>)newValue);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES:
				getSingletonStructuredDataPropertyValues().clear();
				getSingletonStructuredDataPropertyValues().addAll((Collection<? extends SingletonInstanceStructuredDataPropertyValue>)newValue);
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
			case DescriptionsPackage.DESCRIPTION_BOX__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS:
				getDescriptionBoxRefinements().clear();
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS:
				getClosedWorldDefinitions().clear();
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES:
				getConceptInstances().clear();
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES:
				getReifiedRelationshipInstances().clear();
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS:
				getReifiedRelationshipInstanceDomains().clear();
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES:
				getReifiedRelationshipInstanceRanges().clear();
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES:
				getUnreifiedRelationshipInstanceTuples().clear();
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES:
				getSingletonScalarDataPropertyValues().clear();
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES:
				getSingletonStructuredDataPropertyValues().clear();
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
			case DescriptionsPackage.DESCRIPTION_BOX__KIND:
				return kind != KIND_EDEFAULT;
			case DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS:
				return descriptionBoxRefinements != null && !descriptionBoxRefinements.isEmpty();
			case DescriptionsPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS:
				return closedWorldDefinitions != null && !closedWorldDefinitions.isEmpty();
			case DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES:
				return conceptInstances != null && !conceptInstances.isEmpty();
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES:
				return reifiedRelationshipInstances != null && !reifiedRelationshipInstances.isEmpty();
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS:
				return reifiedRelationshipInstanceDomains != null && !reifiedRelationshipInstanceDomains.isEmpty();
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES:
				return reifiedRelationshipInstanceRanges != null && !reifiedRelationshipInstanceRanges.isEmpty();
			case DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES:
				return unreifiedRelationshipInstanceTuples != null && !unreifiedRelationshipInstanceTuples.isEmpty();
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES:
				return singletonScalarDataPropertyValues != null && !singletonScalarDataPropertyValues.isEmpty();
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES:
				return singletonStructuredDataPropertyValues != null && !singletonStructuredDataPropertyValues.isEmpty();
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
			case DescriptionsPackage.DESCRIPTION_BOX___MODULE_EDGES:
				return moduleEdges();
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //DescriptionBoxImpl
