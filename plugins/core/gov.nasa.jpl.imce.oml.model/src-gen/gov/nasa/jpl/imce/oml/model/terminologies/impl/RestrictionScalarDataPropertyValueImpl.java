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

import gov.nasa.jpl.imce.oml.model.common.LiteralValue;
import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.common.impl.LogicalElementImpl;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Restriction Scalar Data Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionScalarDataPropertyValueImpl#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionScalarDataPropertyValueImpl#getScalarDataProperty <em>Scalar Data Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionScalarDataPropertyValueImpl#getScalarPropertyValue <em>Scalar Property Value</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionScalarDataPropertyValueImpl#getValueType <em>Value Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RestrictionScalarDataPropertyValueImpl extends LogicalElementImpl implements RestrictionScalarDataPropertyValue {
	/**
	 * The cached value of the '{@link #getScalarDataProperty() <em>Scalar Data Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalarDataProperty()
	 * @generated
	 * @ordered
	 */
	protected DataRelationshipToScalar scalarDataProperty;

	/**
	 * The cached value of the '{@link #getScalarPropertyValue() <em>Scalar Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalarPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected LiteralValue scalarPropertyValue;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected DataRange valueType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RestrictionScalarDataPropertyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestrictionStructuredDataPropertyContext getStructuredDataPropertyContext() {
		if (eContainerFeatureID() != TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT) return null;
		return (RestrictionStructuredDataPropertyContext)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestrictionStructuredDataPropertyContext basicGetStructuredDataPropertyContext() {
		if (eContainerFeatureID() != TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT) return null;
		return (RestrictionStructuredDataPropertyContext)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext newStructuredDataPropertyContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStructuredDataPropertyContext, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext newStructuredDataPropertyContext) {
		if (newStructuredDataPropertyContext != eInternalContainer() || (eContainerFeatureID() != TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT && newStructuredDataPropertyContext != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newStructuredDataPropertyContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newStructuredDataPropertyContext != null)
				msgs = ((InternalEObject)newStructuredDataPropertyContext).eInverseAdd(this, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS, RestrictionStructuredDataPropertyContext.class, msgs);
			msgs = basicSetStructuredDataPropertyContext(newStructuredDataPropertyContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT, newStructuredDataPropertyContext, newStructuredDataPropertyContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRelationshipToScalar getScalarDataProperty() {
		if (scalarDataProperty != null && ((EObject)scalarDataProperty).eIsProxy()) {
			InternalEObject oldScalarDataProperty = (InternalEObject)scalarDataProperty;
			scalarDataProperty = (DataRelationshipToScalar)eResolveProxy(oldScalarDataProperty);
			if (scalarDataProperty != oldScalarDataProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY, oldScalarDataProperty, scalarDataProperty));
			}
		}
		return scalarDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRelationshipToScalar basicGetScalarDataProperty() {
		return scalarDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScalarDataProperty(DataRelationshipToScalar newScalarDataProperty) {
		DataRelationshipToScalar oldScalarDataProperty = scalarDataProperty;
		scalarDataProperty = newScalarDataProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY, oldScalarDataProperty, scalarDataProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralValue getScalarPropertyValue() {
		return scalarPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScalarPropertyValue(LiteralValue newScalarPropertyValue, NotificationChain msgs) {
		LiteralValue oldScalarPropertyValue = scalarPropertyValue;
		scalarPropertyValue = newScalarPropertyValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE, oldScalarPropertyValue, newScalarPropertyValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScalarPropertyValue(LiteralValue newScalarPropertyValue) {
		if (newScalarPropertyValue != scalarPropertyValue) {
			NotificationChain msgs = null;
			if (scalarPropertyValue != null)
				msgs = ((InternalEObject)scalarPropertyValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE, null, msgs);
			if (newScalarPropertyValue != null)
				msgs = ((InternalEObject)newScalarPropertyValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE, null, msgs);
			msgs = basicSetScalarPropertyValue(newScalarPropertyValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE, newScalarPropertyValue, newScalarPropertyValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRange getValueType() {
		if (valueType != null && ((EObject)valueType).eIsProxy()) {
			InternalEObject oldValueType = (InternalEObject)valueType;
			valueType = (DataRange)eResolveProxy(oldValueType);
			if (valueType != oldValueType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE, oldValueType, valueType));
			}
		}
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRange basicGetValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(DataRange newValueType) {
		DataRange oldValueType = valueType;
		valueType = newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE, oldValueType, valueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox terminologyBox() {
		RestrictionStructuredDataPropertyContext _structuredDataPropertyContext = this.getStructuredDataPropertyContext();
		TerminologyBox _terminologyBox = null;
		if (_structuredDataPropertyContext!=null) {
			_terminologyBox=_structuredDataPropertyContext.terminologyBox();
		}
		return _terminologyBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		RestrictionStructuredDataPropertyContext _structuredDataPropertyContext = this.getStructuredDataPropertyContext();
		String _uuid = null;
		if (_structuredDataPropertyContext!=null) {
			_uuid=_structuredDataPropertyContext.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("structuredDataPropertyContext", _string);
		DataRelationshipToScalar _scalarDataProperty = this.getScalarDataProperty();
		String _uuid_1 = null;
		if (_scalarDataProperty!=null) {
			_uuid_1=_scalarDataProperty.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("scalarDataProperty", _string_1);
		LiteralValue _scalarPropertyValue = this.getScalarPropertyValue();
		String _value = null;
		if (_scalarPropertyValue!=null) {
			_value=_scalarPropertyValue.value();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("scalarPropertyValue", _value);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"RestrictionScalarDataPropertyValue", _mappedTo, _mappedTo_1, _mappedTo_2);
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
	public Module moduleContext() {
		RestrictionStructuredDataPropertyContext _structuredDataPropertyContext = this.getStructuredDataPropertyContext();
		Module _moduleContext = null;
		if (_structuredDataPropertyContext!=null) {
			_moduleContext=_structuredDataPropertyContext.moduleContext();
		}
		return _moduleContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetStructuredDataPropertyContext((RestrictionStructuredDataPropertyContext)otherEnd, msgs);
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
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				return basicSetStructuredDataPropertyContext(null, msgs);
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				return basicSetScalarPropertyValue(null, msgs);
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
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				return eInternalContainer().eInverseRemove(this, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS, RestrictionStructuredDataPropertyContext.class, msgs);
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
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				if (resolve) return getStructuredDataPropertyContext();
				return basicGetStructuredDataPropertyContext();
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY:
				if (resolve) return getScalarDataProperty();
				return basicGetScalarDataProperty();
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				return getScalarPropertyValue();
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE:
				if (resolve) return getValueType();
				return basicGetValueType();
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
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				setStructuredDataPropertyContext((RestrictionStructuredDataPropertyContext)newValue);
				return;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY:
				setScalarDataProperty((DataRelationshipToScalar)newValue);
				return;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				setScalarPropertyValue((LiteralValue)newValue);
				return;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE:
				setValueType((DataRange)newValue);
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
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				setStructuredDataPropertyContext((RestrictionStructuredDataPropertyContext)null);
				return;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY:
				setScalarDataProperty((DataRelationshipToScalar)null);
				return;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				setScalarPropertyValue((LiteralValue)null);
				return;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE:
				setValueType((DataRange)null);
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
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				return basicGetStructuredDataPropertyContext() != null;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY:
				return scalarDataProperty != null;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				return scalarPropertyValue != null;
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE:
				return valueType != null;
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
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE___TERMINOLOGY_BOX:
				return terminologyBox();
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE___UUID:
				return uuid();
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE___MODULE_CONTEXT:
				return moduleContext();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RestrictionScalarDataPropertyValueImpl
