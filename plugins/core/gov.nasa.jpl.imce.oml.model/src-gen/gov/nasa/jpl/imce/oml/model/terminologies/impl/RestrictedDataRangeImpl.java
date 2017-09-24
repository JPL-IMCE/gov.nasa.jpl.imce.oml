/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Restricted Data Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictedDataRangeImpl#getRestrictedRange <em>Restricted Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RestrictedDataRangeImpl extends DataRangeImpl implements RestrictedDataRange {
	/**
	 * The cached value of the '{@link #getRestrictedRange() <em>Restricted Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedRange()
	 * @generated
	 * @ordered
	 */
	protected DataRange restrictedRange;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RestrictedDataRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.RESTRICTED_DATA_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRange getRestrictedRange() {
		if (restrictedRange != null && restrictedRange.eIsProxy()) {
			InternalEObject oldRestrictedRange = (InternalEObject)restrictedRange;
			restrictedRange = (DataRange)eResolveProxy(oldRestrictedRange);
			if (restrictedRange != oldRestrictedRange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE, oldRestrictedRange, restrictedRange));
			}
		}
		return restrictedRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRange basicGetRestrictedRange() {
		return restrictedRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedRange(DataRange newRestrictedRange) {
		DataRange oldRestrictedRange = restrictedRange;
		restrictedRange = newRestrictedRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE, oldRestrictedRange, restrictedRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE:
				if (resolve) return getRestrictedRange();
				return basicGetRestrictedRange();
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
			case TerminologiesPackage.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE:
				setRestrictedRange((DataRange)newValue);
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
			case TerminologiesPackage.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE:
				setRestrictedRange((DataRange)null);
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
			case TerminologiesPackage.RESTRICTED_DATA_RANGE__RESTRICTED_RANGE:
				return restrictedRange != null;
		}
		return super.eIsSet(featureID);
	}

} //RestrictedDataRangeImpl
