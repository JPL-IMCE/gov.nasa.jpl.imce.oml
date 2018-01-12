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

import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reified Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#getForwardProperty <em>Forward Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#getInverseProperty <em>Inverse Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReifiedRelationshipImpl extends EntityRelationshipImpl implements ReifiedRelationship {
	/**
	 * The cached value of the '{@link #getForwardProperty() <em>Forward Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardProperty()
	 * @generated
	 * @ordered
	 */
	protected ForwardProperty forwardProperty;

	/**
	 * The cached value of the '{@link #getInverseProperty() <em>Inverse Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverseProperty()
	 * @generated
	 * @ordered
	 */
	protected InverseProperty inverseProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.REIFIED_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardProperty getForwardProperty() {
		return forwardProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForwardProperty(ForwardProperty newForwardProperty, NotificationChain msgs) {
		ForwardProperty oldForwardProperty = forwardProperty;
		forwardProperty = newForwardProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY, oldForwardProperty, newForwardProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForwardProperty(ForwardProperty newForwardProperty) {
		if (newForwardProperty != forwardProperty) {
			NotificationChain msgs = null;
			if (forwardProperty != null)
				msgs = ((InternalEObject)forwardProperty).eInverseRemove(this, TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP, ForwardProperty.class, msgs);
			if (newForwardProperty != null)
				msgs = ((InternalEObject)newForwardProperty).eInverseAdd(this, TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP, ForwardProperty.class, msgs);
			msgs = basicSetForwardProperty(newForwardProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY, newForwardProperty, newForwardProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseProperty getInverseProperty() {
		return inverseProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInverseProperty(InverseProperty newInverseProperty, NotificationChain msgs) {
		InverseProperty oldInverseProperty = inverseProperty;
		inverseProperty = newInverseProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY, oldInverseProperty, newInverseProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverseProperty(InverseProperty newInverseProperty) {
		if (newInverseProperty != inverseProperty) {
			NotificationChain msgs = null;
			if (inverseProperty != null)
				msgs = ((InternalEObject)inverseProperty).eInverseRemove(this, TerminologiesPackage.INVERSE_PROPERTY__REIFIED_RELATIONSHIP, InverseProperty.class, msgs);
			if (newInverseProperty != null)
				msgs = ((InternalEObject)newInverseProperty).eInverseAdd(this, TerminologiesPackage.INVERSE_PROPERTY__REIFIED_RELATIONSHIP, InverseProperty.class, msgs);
			msgs = basicSetInverseProperty(newInverseProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY, newInverseProperty, newInverseProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				if (forwardProperty != null)
					msgs = ((InternalEObject)forwardProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY, null, msgs);
				return basicSetForwardProperty((ForwardProperty)otherEnd, msgs);
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				if (inverseProperty != null)
					msgs = ((InternalEObject)inverseProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY, null, msgs);
				return basicSetInverseProperty((InverseProperty)otherEnd, msgs);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				return basicSetForwardProperty(null, msgs);
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				return basicSetInverseProperty(null, msgs);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				return getForwardProperty();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				return getInverseProperty();
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				setForwardProperty((ForwardProperty)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				setInverseProperty((InverseProperty)newValue);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				setForwardProperty((ForwardProperty)null);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				setInverseProperty((InverseProperty)null);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				return forwardProperty != null;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				return inverseProperty != null;
		}
		return super.eIsSet(featureID);
	}

} //ReifiedRelationshipImpl
