/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;

import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IRI Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.IRIScalarRestrictionImpl#getLength <em>Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.IRIScalarRestrictionImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.IRIScalarRestrictionImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.IRIScalarRestrictionImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IRIScalarRestrictionImpl extends RestrictedDataRangeImpl implements IRIScalarRestriction {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IRIScalarRestrictionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.IRI_SCALAR_RESTRICTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.IRI_SCALAR_RESTRICTION__LENGTH, oldLength, length));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.IRI_SCALAR_RESTRICTION__MIN_LENGTH, oldMinLength, minLength));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.IRI_SCALAR_RESTRICTION__MAX_LENGTH, oldMaxLength, maxLength));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.IRI_SCALAR_RESTRICTION__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__LENGTH:
				return getLength();
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__MIN_LENGTH:
				return getMinLength();
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__MAX_LENGTH:
				return getMaxLength();
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__PATTERN:
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
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__LENGTH:
				setLength((PositiveIntegerValue)newValue);
				return;
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__MIN_LENGTH:
				setMinLength((PositiveIntegerValue)newValue);
				return;
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__MAX_LENGTH:
				setMaxLength((PositiveIntegerValue)newValue);
				return;
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__PATTERN:
				setPattern((PatternValue)newValue);
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
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__PATTERN:
				setPattern(PATTERN_EDEFAULT);
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
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
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
		result.append(')');
		return result.toString();
	}

} //IRIScalarRestrictionImpl
