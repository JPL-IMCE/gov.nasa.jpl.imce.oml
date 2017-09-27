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

import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.common.impl.ElementImpl;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

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
 * An implementation of the model object '<em><b>Rule Body Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RuleBodySegmentImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RuleBodySegmentImpl#getNextSegment <em>Next Segment</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RuleBodySegmentImpl#getPreviousSegment <em>Previous Segment</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RuleBodySegmentImpl#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleBodySegmentImpl extends ElementImpl implements RuleBodySegment {
	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected SegmentPredicate predicate;

	/**
	 * The cached value of the '{@link #getNextSegment() <em>Next Segment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextSegment()
	 * @generated
	 * @ordered
	 */
	protected RuleBodySegment nextSegment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleBodySegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.RULE_BODY_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SegmentPredicate getPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredicate(SegmentPredicate newPredicate, NotificationChain msgs) {
		SegmentPredicate oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE, oldPredicate, newPredicate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(SegmentPredicate newPredicate) {
		if (newPredicate != predicate) {
			NotificationChain msgs = null;
			if (predicate != null)
				msgs = ((InternalEObject)predicate).eInverseRemove(this, TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT, SegmentPredicate.class, msgs);
			if (newPredicate != null)
				msgs = ((InternalEObject)newPredicate).eInverseAdd(this, TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT, SegmentPredicate.class, msgs);
			msgs = basicSetPredicate(newPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE, newPredicate, newPredicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBodySegment getNextSegment() {
		return nextSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNextSegment(RuleBodySegment newNextSegment, NotificationChain msgs) {
		RuleBodySegment oldNextSegment = nextSegment;
		nextSegment = newNextSegment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT, oldNextSegment, newNextSegment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextSegment(RuleBodySegment newNextSegment) {
		if (newNextSegment != nextSegment) {
			NotificationChain msgs = null;
			if (nextSegment != null)
				msgs = ((InternalEObject)nextSegment).eInverseRemove(this, TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT, RuleBodySegment.class, msgs);
			if (newNextSegment != null)
				msgs = ((InternalEObject)newNextSegment).eInverseAdd(this, TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT, RuleBodySegment.class, msgs);
			msgs = basicSetNextSegment(newNextSegment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT, newNextSegment, newNextSegment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBodySegment getPreviousSegment() {
		if (eContainerFeatureID() != TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT) return null;
		return (RuleBodySegment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBodySegment basicGetPreviousSegment() {
		if (eContainerFeatureID() != TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT) return null;
		return (RuleBodySegment)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreviousSegment(RuleBodySegment newPreviousSegment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPreviousSegment, TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousSegment(RuleBodySegment newPreviousSegment) {
		if (newPreviousSegment != eInternalContainer() || (eContainerFeatureID() != TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT && newPreviousSegment != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newPreviousSegment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPreviousSegment != null)
				msgs = ((InternalEObject)newPreviousSegment).eInverseAdd(this, TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT, RuleBodySegment.class, msgs);
			msgs = basicSetPreviousSegment(newPreviousSegment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT, newPreviousSegment, newPreviousSegment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChainRule getRule() {
		if (eContainerFeatureID() != TerminologiesPackage.RULE_BODY_SEGMENT__RULE) return null;
		return (ChainRule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChainRule basicGetRule() {
		if (eContainerFeatureID() != TerminologiesPackage.RULE_BODY_SEGMENT__RULE) return null;
		return (ChainRule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRule(ChainRule newRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRule, TerminologiesPackage.RULE_BODY_SEGMENT__RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(ChainRule newRule) {
		if (newRule != eInternalContainer() || (eContainerFeatureID() != TerminologiesPackage.RULE_BODY_SEGMENT__RULE && newRule != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRule != null)
				msgs = ((InternalEObject)newRule).eInverseAdd(this, TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT, ChainRule.class, msgs);
			msgs = basicSetRule(newRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RULE_BODY_SEGMENT__RULE, newRule, newRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int position() {
		int _xifexpression = (int) 0;
		RuleBodySegment _previousSegment = this.getPreviousSegment();
		boolean _tripleEquals = (null == _previousSegment);
		if (_tripleEquals) {
			_xifexpression = 1;
		}
		else {
			int _position = this.getPreviousSegment().position();
			_xifexpression = (1 + _position);
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChainRule chainRule() {
		ChainRule _elvis = null;
		ChainRule _rule = this.getRule();
		if (_rule != null) {
			_elvis = _rule;
		} else {
			RuleBodySegment _previousSegment = this.getPreviousSegment();
			ChainRule _chainRule = null;
			if (_previousSegment!=null) {
				_chainRule=_previousSegment.chainRule();
			}
			_elvis = _chainRule;
		}
		return _elvis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		ChainRule _chainRule = this.chainRule();
		String _uuid = null;
		if (_chainRule!=null) {
			_uuid=_chainRule.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("chainRule", _string);
		String _string_1 = Integer.valueOf(this.position()).toString();
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("position", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"RuleBodySegment", _mappedTo, _mappedTo_1);
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
		ChainRule _rule = this.getRule();
		Module _moduleContext = null;
		if (_rule!=null) {
			_moduleContext=_rule.moduleContext();
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
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE:
				if (predicate != null)
					msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE, null, msgs);
				return basicSetPredicate((SegmentPredicate)otherEnd, msgs);
			case TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT:
				if (nextSegment != null)
					msgs = ((InternalEObject)nextSegment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT, null, msgs);
				return basicSetNextSegment((RuleBodySegment)otherEnd, msgs);
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPreviousSegment((RuleBodySegment)otherEnd, msgs);
			case TerminologiesPackage.RULE_BODY_SEGMENT__RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRule((ChainRule)otherEnd, msgs);
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
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE:
				return basicSetPredicate(null, msgs);
			case TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT:
				return basicSetNextSegment(null, msgs);
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT:
				return basicSetPreviousSegment(null, msgs);
			case TerminologiesPackage.RULE_BODY_SEGMENT__RULE:
				return basicSetRule(null, msgs);
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
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT:
				return eInternalContainer().eInverseRemove(this, TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT, RuleBodySegment.class, msgs);
			case TerminologiesPackage.RULE_BODY_SEGMENT__RULE:
				return eInternalContainer().eInverseRemove(this, TerminologiesPackage.CHAIN_RULE__FIRST_SEGMENT, ChainRule.class, msgs);
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
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE:
				return getPredicate();
			case TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT:
				return getNextSegment();
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT:
				if (resolve) return getPreviousSegment();
				return basicGetPreviousSegment();
			case TerminologiesPackage.RULE_BODY_SEGMENT__RULE:
				if (resolve) return getRule();
				return basicGetRule();
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
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE:
				setPredicate((SegmentPredicate)newValue);
				return;
			case TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT:
				setNextSegment((RuleBodySegment)newValue);
				return;
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT:
				setPreviousSegment((RuleBodySegment)newValue);
				return;
			case TerminologiesPackage.RULE_BODY_SEGMENT__RULE:
				setRule((ChainRule)newValue);
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
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE:
				setPredicate((SegmentPredicate)null);
				return;
			case TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT:
				setNextSegment((RuleBodySegment)null);
				return;
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT:
				setPreviousSegment((RuleBodySegment)null);
				return;
			case TerminologiesPackage.RULE_BODY_SEGMENT__RULE:
				setRule((ChainRule)null);
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
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE:
				return predicate != null;
			case TerminologiesPackage.RULE_BODY_SEGMENT__NEXT_SEGMENT:
				return nextSegment != null;
			case TerminologiesPackage.RULE_BODY_SEGMENT__PREVIOUS_SEGMENT:
				return basicGetPreviousSegment() != null;
			case TerminologiesPackage.RULE_BODY_SEGMENT__RULE:
				return basicGetRule() != null;
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
			case TerminologiesPackage.RULE_BODY_SEGMENT___POSITION:
				return position();
			case TerminologiesPackage.RULE_BODY_SEGMENT___CHAIN_RULE:
				return chainRule();
			case TerminologiesPackage.RULE_BODY_SEGMENT___UUID:
				return uuid();
			case TerminologiesPackage.RULE_BODY_SEGMENT___MODULE_CONTEXT:
				return moduleContext();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RuleBodySegmentImpl
