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

import gov.nasa.jpl.imce.oml.model.common.impl.ElementImpl;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Restriction Structured Data Property Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionStructuredDataPropertyContextImpl#getStructuredDataProperty <em>Structured Data Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionStructuredDataPropertyContextImpl#getStructuredPropertyTuples <em>Structured Property Tuples</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionStructuredDataPropertyContextImpl#getScalarDataPropertyValues <em>Scalar Data Property Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RestrictionStructuredDataPropertyContextImpl extends ElementImpl implements RestrictionStructuredDataPropertyContext {
	/**
	 * The cached value of the '{@link #getStructuredDataProperty() <em>Structured Data Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuredDataProperty()
	 * @generated
	 * @ordered
	 */
	protected DataRelationshipToStructure structuredDataProperty;

	/**
	 * The cached value of the '{@link #getStructuredPropertyTuples() <em>Structured Property Tuples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuredPropertyTuples()
	 * @generated
	 * @ordered
	 */
	protected EList<RestrictionStructuredDataPropertyTuple> structuredPropertyTuples;

	/**
	 * The cached value of the '{@link #getScalarDataPropertyValues() <em>Scalar Data Property Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalarDataPropertyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<RestrictionScalarDataPropertyValue> scalarDataPropertyValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RestrictionStructuredDataPropertyContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRelationshipToStructure getStructuredDataProperty() {
		if (structuredDataProperty != null && ((EObject)structuredDataProperty).eIsProxy()) {
			InternalEObject oldStructuredDataProperty = (InternalEObject)structuredDataProperty;
			structuredDataProperty = (DataRelationshipToStructure)eResolveProxy(oldStructuredDataProperty);
			if (structuredDataProperty != oldStructuredDataProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY, oldStructuredDataProperty, structuredDataProperty));
			}
		}
		return structuredDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRelationshipToStructure basicGetStructuredDataProperty() {
		return structuredDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructuredDataProperty(DataRelationshipToStructure newStructuredDataProperty) {
		DataRelationshipToStructure oldStructuredDataProperty = structuredDataProperty;
		structuredDataProperty = newStructuredDataProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY, oldStructuredDataProperty, structuredDataProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RestrictionStructuredDataPropertyTuple> getStructuredPropertyTuples() {
		if (structuredPropertyTuples == null) {
			structuredPropertyTuples = new EObjectContainmentWithInverseEList<RestrictionStructuredDataPropertyTuple>(RestrictionStructuredDataPropertyTuple.class, this, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		}
		return structuredPropertyTuples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RestrictionScalarDataPropertyValue> getScalarDataPropertyValues() {
		if (scalarDataPropertyValues == null) {
			scalarDataPropertyValues = new EObjectContainmentWithInverseEList<RestrictionScalarDataPropertyValue>(RestrictionScalarDataPropertyValue.class, this, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		}
		return scalarDataPropertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox terminologyBox() {
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStructuredPropertyTuples()).basicAdd(otherEnd, msgs);
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getScalarDataPropertyValues()).basicAdd(otherEnd, msgs);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES:
				return ((InternalEList<?>)getStructuredPropertyTuples()).basicRemove(otherEnd, msgs);
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES:
				return ((InternalEList<?>)getScalarDataPropertyValues()).basicRemove(otherEnd, msgs);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY:
				if (resolve) return getStructuredDataProperty();
				return basicGetStructuredDataProperty();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES:
				return getStructuredPropertyTuples();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES:
				return getScalarDataPropertyValues();
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY:
				setStructuredDataProperty((DataRelationshipToStructure)newValue);
				return;
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES:
				getStructuredPropertyTuples().clear();
				getStructuredPropertyTuples().addAll((Collection<? extends RestrictionStructuredDataPropertyTuple>)newValue);
				return;
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES:
				getScalarDataPropertyValues().clear();
				getScalarDataPropertyValues().addAll((Collection<? extends RestrictionScalarDataPropertyValue>)newValue);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY:
				setStructuredDataProperty((DataRelationshipToStructure)null);
				return;
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES:
				getStructuredPropertyTuples().clear();
				return;
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES:
				getScalarDataPropertyValues().clear();
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY:
				return structuredDataProperty != null;
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES:
				return structuredPropertyTuples != null && !structuredPropertyTuples.isEmpty();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES:
				return scalarDataPropertyValues != null && !scalarDataPropertyValues.isEmpty();
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT___TERMINOLOGY_BOX:
				return terminologyBox();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RestrictionStructuredDataPropertyContextImpl
