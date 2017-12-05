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
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scalar One Of Literal Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfLiteralAxiomImpl#getAxiom <em>Axiom</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfLiteralAxiomImpl#getValue <em>Value</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfLiteralAxiomImpl#getValueType <em>Value Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScalarOneOfLiteralAxiomImpl extends TermAxiomImpl implements ScalarOneOfLiteralAxiom {
	/**
	 * The cached value of the '{@link #getAxiom() <em>Axiom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxiom()
	 * @generated
	 * @ordered
	 */
	protected ScalarOneOfRestriction axiom;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected LiteralValue value;

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
	protected ScalarOneOfLiteralAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.SCALAR_ONE_OF_LITERAL_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarOneOfRestriction getAxiom() {
		if (axiom != null && ((EObject)axiom).eIsProxy()) {
			InternalEObject oldAxiom = (InternalEObject)axiom;
			axiom = (ScalarOneOfRestriction)eResolveProxy(oldAxiom);
			if (axiom != oldAxiom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM, oldAxiom, axiom));
			}
		}
		return axiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarOneOfRestriction basicGetAxiom() {
		return axiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxiom(ScalarOneOfRestriction newAxiom) {
		ScalarOneOfRestriction oldAxiom = axiom;
		axiom = newAxiom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM, oldAxiom, axiom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralValue getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(LiteralValue newValue, NotificationChain msgs) {
		LiteralValue oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(LiteralValue newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE, newValue, newValue));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE_TYPE, oldValueType, valueType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE_TYPE, oldValueType, valueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		TerminologyBox _tbox = this.getTbox();
		String _uuid = null;
		if (_tbox!=null) {
			_uuid=_tbox.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _string);
		ScalarOneOfRestriction _axiom = this.getAxiom();
		String _uuid_1 = null;
		if (_axiom!=null) {
			_uuid_1=_axiom.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("axiom", _string_1);
		LiteralValue _value = this.getValue();
		String _value_1 = null;
		if (_value!=null) {
			_value_1=_value.value();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("value", _value_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"ScalarOneOfLiteralAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE:
				return basicSetValue(null, msgs);
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
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM:
				if (resolve) return getAxiom();
				return basicGetAxiom();
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE:
				return getValue();
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE_TYPE:
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
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM:
				setAxiom((ScalarOneOfRestriction)newValue);
				return;
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE:
				setValue((LiteralValue)newValue);
				return;
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE_TYPE:
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
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM:
				setAxiom((ScalarOneOfRestriction)null);
				return;
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE:
				setValue((LiteralValue)null);
				return;
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE_TYPE:
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
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM:
				return axiom != null;
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE:
				return value != null;
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM__VALUE_TYPE:
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
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM___UUID:
				return uuid();
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ScalarOneOfLiteralAxiomImpl
