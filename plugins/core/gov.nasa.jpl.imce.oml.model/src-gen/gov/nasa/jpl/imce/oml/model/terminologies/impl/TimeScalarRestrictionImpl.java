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

import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TimeScalarRestrictionImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TimeScalarRestrictionImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TimeScalarRestrictionImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TimeScalarRestrictionImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeScalarRestrictionImpl extends RestrictedDataRangeImpl implements TimeScalarRestriction {
	/**
	 * The cached value of the '{@link #getMinInclusive() <em>Min Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinInclusive()
	 * @generated
	 * @ordered
	 */
	protected LiteralDateTime minInclusive;

	/**
	 * The cached value of the '{@link #getMaxInclusive() <em>Max Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInclusive()
	 * @generated
	 * @ordered
	 */
	protected LiteralDateTime maxInclusive;

	/**
	 * The cached value of the '{@link #getMinExclusive() <em>Min Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinExclusive()
	 * @generated
	 * @ordered
	 */
	protected LiteralDateTime minExclusive;

	/**
	 * The cached value of the '{@link #getMaxExclusive() <em>Max Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExclusive()
	 * @generated
	 * @ordered
	 */
	protected LiteralDateTime maxExclusive;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeScalarRestrictionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.TIME_SCALAR_RESTRICTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralDateTime getMinInclusive() {
		return minInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinInclusive(LiteralDateTime newMinInclusive, NotificationChain msgs) {
		LiteralDateTime oldMinInclusive = minInclusive;
		minInclusive = newMinInclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE, oldMinInclusive, newMinInclusive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinInclusive(LiteralDateTime newMinInclusive) {
		if (newMinInclusive != minInclusive) {
			NotificationChain msgs = null;
			if (minInclusive != null)
				msgs = ((InternalEObject)minInclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE, null, msgs);
			if (newMinInclusive != null)
				msgs = ((InternalEObject)newMinInclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE, null, msgs);
			msgs = basicSetMinInclusive(newMinInclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE, newMinInclusive, newMinInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralDateTime getMaxInclusive() {
		return maxInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxInclusive(LiteralDateTime newMaxInclusive, NotificationChain msgs) {
		LiteralDateTime oldMaxInclusive = maxInclusive;
		maxInclusive = newMaxInclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE, oldMaxInclusive, newMaxInclusive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxInclusive(LiteralDateTime newMaxInclusive) {
		if (newMaxInclusive != maxInclusive) {
			NotificationChain msgs = null;
			if (maxInclusive != null)
				msgs = ((InternalEObject)maxInclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE, null, msgs);
			if (newMaxInclusive != null)
				msgs = ((InternalEObject)newMaxInclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE, null, msgs);
			msgs = basicSetMaxInclusive(newMaxInclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE, newMaxInclusive, newMaxInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralDateTime getMinExclusive() {
		return minExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinExclusive(LiteralDateTime newMinExclusive, NotificationChain msgs) {
		LiteralDateTime oldMinExclusive = minExclusive;
		minExclusive = newMinExclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE, oldMinExclusive, newMinExclusive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinExclusive(LiteralDateTime newMinExclusive) {
		if (newMinExclusive != minExclusive) {
			NotificationChain msgs = null;
			if (minExclusive != null)
				msgs = ((InternalEObject)minExclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE, null, msgs);
			if (newMinExclusive != null)
				msgs = ((InternalEObject)newMinExclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE, null, msgs);
			msgs = basicSetMinExclusive(newMinExclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE, newMinExclusive, newMinExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralDateTime getMaxExclusive() {
		return maxExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxExclusive(LiteralDateTime newMaxExclusive, NotificationChain msgs) {
		LiteralDateTime oldMaxExclusive = maxExclusive;
		maxExclusive = newMaxExclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE, oldMaxExclusive, newMaxExclusive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxExclusive(LiteralDateTime newMaxExclusive) {
		if (newMaxExclusive != maxExclusive) {
			NotificationChain msgs = null;
			if (maxExclusive != null)
				msgs = ((InternalEObject)maxExclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE, null, msgs);
			if (newMaxExclusive != null)
				msgs = ((InternalEObject)newMaxExclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE, null, msgs);
			msgs = basicSetMaxExclusive(newMaxExclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE, newMaxExclusive, newMaxExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE:
				return basicSetMinInclusive(null, msgs);
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE:
				return basicSetMaxInclusive(null, msgs);
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE:
				return basicSetMinExclusive(null, msgs);
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE:
				return basicSetMaxExclusive(null, msgs);
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
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE:
				return getMinInclusive();
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE:
				return getMaxInclusive();
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE:
				return getMinExclusive();
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE:
				return getMaxExclusive();
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
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE:
				setMinInclusive((LiteralDateTime)newValue);
				return;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE:
				setMaxInclusive((LiteralDateTime)newValue);
				return;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE:
				setMinExclusive((LiteralDateTime)newValue);
				return;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE:
				setMaxExclusive((LiteralDateTime)newValue);
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
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE:
				setMinInclusive((LiteralDateTime)null);
				return;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE:
				setMaxInclusive((LiteralDateTime)null);
				return;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE:
				setMinExclusive((LiteralDateTime)null);
				return;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE:
				setMaxExclusive((LiteralDateTime)null);
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
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE:
				return minInclusive != null;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE:
				return maxInclusive != null;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE:
				return minExclusive != null;
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE:
				return maxExclusive != null;
		}
		return super.eIsSet(featureID);
	}

} //TimeScalarRestrictionImpl
