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

import gov.nasa.jpl.imce.oml.model.common.LiteralPattern;

import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StringScalarRestrictionImpl#getLength <em>Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StringScalarRestrictionImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StringScalarRestrictionImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StringScalarRestrictionImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringScalarRestrictionImpl extends RestrictedDataRangeImpl implements StringScalarRestriction {
	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final String LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected String length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected String minLength = MIN_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected String maxLength = MAX_LENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected LiteralPattern pattern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringScalarRestrictionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.STRING_SCALAR_RESTRICTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(String newLength) {
		String oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.STRING_SCALAR_RESTRICTION__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinLength(String newMinLength) {
		String oldMinLength = minLength;
		minLength = newMinLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.STRING_SCALAR_RESTRICTION__MIN_LENGTH, oldMinLength, minLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxLength(String newMaxLength) {
		String oldMaxLength = maxLength;
		maxLength = newMaxLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.STRING_SCALAR_RESTRICTION__MAX_LENGTH, oldMaxLength, maxLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralPattern getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(LiteralPattern newPattern, NotificationChain msgs) {
		LiteralPattern oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN, oldPattern, newPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(LiteralPattern newPattern) {
		if (newPattern != pattern) {
			NotificationChain msgs = null;
			if (pattern != null)
				msgs = ((InternalEObject)pattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN, null, msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN, null, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN:
				return basicSetPattern(null, msgs);
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
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__LENGTH:
				return getLength();
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__MIN_LENGTH:
				return getMinLength();
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__MAX_LENGTH:
				return getMaxLength();
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN:
				return getPattern();
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
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__LENGTH:
				setLength((String)newValue);
				return;
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__MIN_LENGTH:
				setMinLength((String)newValue);
				return;
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__MAX_LENGTH:
				setMaxLength((String)newValue);
				return;
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN:
				setPattern((LiteralPattern)newValue);
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
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN:
				setPattern((LiteralPattern)null);
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
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION__PATTERN:
				return pattern != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (length: ");
		result.append(length);
		result.append(", minLength: ");
		result.append(minLength);
		result.append(", maxLength: ");
		result.append(maxLength);
		result.append(')');
		return result.toString();
	}

} //StringScalarRestrictionImpl
