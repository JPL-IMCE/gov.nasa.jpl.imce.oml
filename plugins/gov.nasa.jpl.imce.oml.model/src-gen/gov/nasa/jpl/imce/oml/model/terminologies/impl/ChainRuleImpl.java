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

import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chain Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ChainRuleImpl#getHead <em>Head</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ChainRuleImpl#getFirstSegment <em>First Segment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChainRuleImpl extends RuleImpl implements ChainRule {
	/**
	 * The cached value of the '{@link #getHead() <em>Head</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHead()
	 * @generated
	 * @ordered
	 */
	protected UnreifiedRelationship head;

	/**
	 * The cached value of the '{@link #getFirstSegment() <em>First Segment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstSegment()
	 * @generated
	 * @ordered
	 */
	protected RuleBodySegment firstSegment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChainRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.CHAIN_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship getHead() {
		if (head != null && head.eIsProxy()) {
			InternalEObject oldHead = (InternalEObject)head;
			head = (UnreifiedRelationship)eResolveProxy(oldHead);
			if (head != oldHead) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.CHAIN_RULE__HEAD, oldHead, head));
			}
		}
		return head;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship basicGetHead() {
		return head;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHead(UnreifiedRelationship newHead) {
		UnreifiedRelationship oldHead = head;
		head = newHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHAIN_RULE__HEAD, oldHead, head));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBodySegment getFirstSegment() {
		return firstSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstSegment(RuleBodySegment newFirstSegment, NotificationChain msgs) {
		RuleBodySegment oldFirstSegment = firstSegment;
		firstSegment = newFirstSegment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT, oldFirstSegment, newFirstSegment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstSegment(RuleBodySegment newFirstSegment) {
		if (newFirstSegment != firstSegment) {
			NotificationChain msgs = null;
			if (firstSegment != null)
				msgs = ((InternalEObject)firstSegment).eInverseRemove(this, TerminologiesPackage.RULE_BODY_SEGMENT__RULE, RuleBodySegment.class, msgs);
			if (newFirstSegment != null)
				msgs = ((InternalEObject)newFirstSegment).eInverseAdd(this, TerminologiesPackage.RULE_BODY_SEGMENT__RULE, RuleBodySegment.class, msgs);
			msgs = basicSetFirstSegment(newFirstSegment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT, newFirstSegment, newFirstSegment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT:
				if (firstSegment != null)
					msgs = ((InternalEObject)firstSegment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT, null, msgs);
				return basicSetFirstSegment((RuleBodySegment)otherEnd, msgs);
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
			case TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT:
				return basicSetFirstSegment(null, msgs);
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
			case TerminologiesPackage.CHAIN_RULE__HEAD:
				if (resolve) return getHead();
				return basicGetHead();
			case TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT:
				return getFirstSegment();
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
			case TerminologiesPackage.CHAIN_RULE__HEAD:
				setHead((UnreifiedRelationship)newValue);
				return;
			case TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT:
				setFirstSegment((RuleBodySegment)newValue);
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
			case TerminologiesPackage.CHAIN_RULE__HEAD:
				setHead((UnreifiedRelationship)null);
				return;
			case TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT:
				setFirstSegment((RuleBodySegment)null);
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
			case TerminologiesPackage.CHAIN_RULE__HEAD:
				return head != null;
			case TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT:
				return firstSegment != null;
		}
		return super.eIsSet(featureID);
	}

} //ChainRuleImpl
