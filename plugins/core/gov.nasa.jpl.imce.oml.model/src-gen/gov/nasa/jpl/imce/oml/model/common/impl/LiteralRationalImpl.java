/**
 */
package gov.nasa.jpl.imce.oml.model.common.impl;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.LiteralRational;

import gov.nasa.jpl.imce.oml.model.datatypes.RationalValue;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Rational</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralRationalImpl#getRational <em>Rational</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LiteralRationalImpl extends LiteralNumberImpl implements LiteralRational {
	/**
	 * The default value of the '{@link #getRational() <em>Rational</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRational()
	 * @generated
	 * @ordered
	 */
	protected static final RationalValue RATIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRational() <em>Rational</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRational()
	 * @generated
	 * @ordered
	 */
	protected RationalValue rational = RATIONAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralRationalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.LITERAL_RATIONAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RationalValue getRational() {
		return rational;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRational(RationalValue newRational) {
		RationalValue oldRational = rational;
		rational = newRational;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.LITERAL_RATIONAL__RATIONAL, oldRational, rational));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.LITERAL_RATIONAL__RATIONAL:
				return getRational();
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
			case CommonPackage.LITERAL_RATIONAL__RATIONAL:
				setRational((RationalValue)newValue);
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
			case CommonPackage.LITERAL_RATIONAL__RATIONAL:
				setRational(RATIONAL_EDEFAULT);
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
			case CommonPackage.LITERAL_RATIONAL__RATIONAL:
				return RATIONAL_EDEFAULT == null ? rational != null : !RATIONAL_EDEFAULT.equals(rational);
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
		result.append(" (rational: ");
		result.append(rational);
		result.append(')');
		return result.toString();
	}

} //LiteralRationalImpl
