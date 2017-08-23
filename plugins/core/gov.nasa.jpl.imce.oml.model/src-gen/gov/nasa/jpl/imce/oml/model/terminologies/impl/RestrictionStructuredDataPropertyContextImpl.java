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

import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
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
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionStructuredDataPropertyContextImpl#getStructuredDataPropertyRestrictions <em>Structured Data Property Restrictions</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionStructuredDataPropertyContextImpl#getScalarDataPropertyRestrictions <em>Scalar Data Property Restrictions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RestrictionStructuredDataPropertyContextImpl extends ModuleElementImpl implements RestrictionStructuredDataPropertyContext {
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
	 * The cached value of the '{@link #getStructuredDataPropertyRestrictions() <em>Structured Data Property Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuredDataPropertyRestrictions()
	 * @generated
	 * @ordered
	 */
	protected EList<RestrictionStructuredDataPropertyTuple> structuredDataPropertyRestrictions;

	/**
	 * The cached value of the '{@link #getScalarDataPropertyRestrictions() <em>Scalar Data Property Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalarDataPropertyRestrictions()
	 * @generated
	 * @ordered
	 */
	protected EList<RestrictionScalarDataPropertyValue> scalarDataPropertyRestrictions;

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
	public EList<RestrictionStructuredDataPropertyTuple> getStructuredDataPropertyRestrictions() {
		if (structuredDataPropertyRestrictions == null) {
			structuredDataPropertyRestrictions = new EObjectContainmentWithInverseEList<RestrictionStructuredDataPropertyTuple>(RestrictionStructuredDataPropertyTuple.class, this, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		}
		return structuredDataPropertyRestrictions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RestrictionScalarDataPropertyValue> getScalarDataPropertyRestrictions() {
		if (scalarDataPropertyRestrictions == null) {
			scalarDataPropertyRestrictions = new EObjectContainmentWithInverseEList<RestrictionScalarDataPropertyValue>(RestrictionScalarDataPropertyValue.class, this, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		}
		return scalarDataPropertyRestrictions;
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
	public EList<Element> allNestedRestrictionElements() {
		BasicEList<Element> _xblockexpression = null;
		{
			final BasicEList<Element> nres = new BasicEList<Element>();
			nres.addAll(this.getStructuredDataPropertyRestrictions());
			final Consumer<RestrictionStructuredDataPropertyTuple> _function = new Consumer<RestrictionStructuredDataPropertyTuple>() {
				public void accept(final RestrictionStructuredDataPropertyTuple it) {
					nres.addAll(it.allNestedRestrictionElements());
				}
			};
			this.getStructuredDataPropertyRestrictions().forEach(_function);
			nres.addAll(this.getScalarDataPropertyRestrictions());
			_xblockexpression = nres;
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStructuredDataPropertyRestrictions()).basicAdd(otherEnd, msgs);
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getScalarDataPropertyRestrictions()).basicAdd(otherEnd, msgs);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				return ((InternalEList<?>)getStructuredDataPropertyRestrictions()).basicRemove(otherEnd, msgs);
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				return ((InternalEList<?>)getScalarDataPropertyRestrictions()).basicRemove(otherEnd, msgs);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				return getStructuredDataPropertyRestrictions();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				return getScalarDataPropertyRestrictions();
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				getStructuredDataPropertyRestrictions().clear();
				getStructuredDataPropertyRestrictions().addAll((Collection<? extends RestrictionStructuredDataPropertyTuple>)newValue);
				return;
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				getScalarDataPropertyRestrictions().clear();
				getScalarDataPropertyRestrictions().addAll((Collection<? extends RestrictionScalarDataPropertyValue>)newValue);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				getStructuredDataPropertyRestrictions().clear();
				return;
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				getScalarDataPropertyRestrictions().clear();
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				return structuredDataPropertyRestrictions != null && !structuredDataPropertyRestrictions.isEmpty();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				return scalarDataPropertyRestrictions != null && !scalarDataPropertyRestrictions.isEmpty();
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT___ALL_NESTED_RESTRICTION_ELEMENTS:
				return allNestedRestrictionElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RestrictionStructuredDataPropertyContextImpl
