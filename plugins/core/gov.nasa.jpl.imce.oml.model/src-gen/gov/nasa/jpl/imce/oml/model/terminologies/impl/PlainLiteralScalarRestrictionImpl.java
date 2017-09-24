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

import gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;

import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plain Literal Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl#getLength <em>Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl#getLangRange <em>Lang Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlainLiteralScalarRestrictionImpl extends RestrictedDataRangeImpl implements PlainLiteralScalarRestriction {
	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final PositiveIntegerValue LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected PositiveIntegerValue length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected static final PositiveIntegerValue MIN_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected PositiveIntegerValue minLength = MIN_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected static final PositiveIntegerValue MAX_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected PositiveIntegerValue maxLength = MAX_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final PatternValue PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected PatternValue pattern = PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLangRange() <em>Lang Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLangRange()
	 * @generated
	 * @ordered
	 */
	protected static final LanguageTagValue LANG_RANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLangRange() <em>Lang Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLangRange()
	 * @generated
	 * @ordered
	 */
	protected LanguageTagValue langRange = LANG_RANGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlainLiteralScalarRestrictionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.PLAIN_LITERAL_SCALAR_RESTRICTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositiveIntegerValue getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(PositiveIntegerValue newLength) {
		PositiveIntegerValue oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositiveIntegerValue getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinLength(PositiveIntegerValue newMinLength) {
		PositiveIntegerValue oldMinLength = minLength;
		minLength = newMinLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH, oldMinLength, minLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositiveIntegerValue getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxLength(PositiveIntegerValue newMaxLength) {
		PositiveIntegerValue oldMaxLength = maxLength;
		maxLength = newMaxLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH, oldMaxLength, maxLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternValue getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(PatternValue newPattern) {
		PatternValue oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageTagValue getLangRange() {
		return langRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLangRange(LanguageTagValue newLangRange) {
		LanguageTagValue oldLangRange = langRange;
		langRange = newLangRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE, oldLangRange, langRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH:
				return getLength();
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH:
				return getMinLength();
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH:
				return getMaxLength();
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN:
				return getPattern();
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE:
				return getLangRange();
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
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH:
				setLength((PositiveIntegerValue)newValue);
				return;
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH:
				setMinLength((PositiveIntegerValue)newValue);
				return;
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH:
				setMaxLength((PositiveIntegerValue)newValue);
				return;
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN:
				setPattern((PatternValue)newValue);
				return;
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE:
				setLangRange((LanguageTagValue)newValue);
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
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN:
				setPattern(PATTERN_EDEFAULT);
				return;
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE:
				setLangRange(LANG_RANGE_EDEFAULT);
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
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE:
				return LANG_RANGE_EDEFAULT == null ? langRange != null : !LANG_RANGE_EDEFAULT.equals(langRange);
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
		result.append(", pattern: ");
		result.append(pattern);
		result.append(", langRange: ");
		result.append(langRange);
		result.append(')');
		return result.toString();
	}

} //PlainLiteralScalarRestrictionImpl
