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

import gov.nasa.jpl.imce.oml.model.common.impl.ElementCrossReferenceTupleImpl;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.Predicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;

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
 * An implementation of the model object '<em><b>Segment Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SegmentPredicateImpl#getBodySegment <em>Body Segment</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SegmentPredicateImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SegmentPredicateImpl#getReifiedRelationshipSource <em>Reified Relationship Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SegmentPredicateImpl#getReifiedRelationshipInverseSource <em>Reified Relationship Inverse Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SegmentPredicateImpl#getReifiedRelationshipTarget <em>Reified Relationship Target</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SegmentPredicateImpl#getReifiedRelationshipInverseTarget <em>Reified Relationship Inverse Target</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SegmentPredicateImpl#getUnreifiedRelationshipInverse <em>Unreified Relationship Inverse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SegmentPredicateImpl extends ElementCrossReferenceTupleImpl implements SegmentPredicate {
	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected Predicate predicate;

	/**
	 * The cached value of the '{@link #getReifiedRelationshipSource() <em>Reified Relationship Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReifiedRelationshipSource()
	 * @generated
	 * @ordered
	 */
	protected ReifiedRelationship reifiedRelationshipSource;

	/**
	 * The cached value of the '{@link #getReifiedRelationshipInverseSource() <em>Reified Relationship Inverse Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReifiedRelationshipInverseSource()
	 * @generated
	 * @ordered
	 */
	protected ReifiedRelationship reifiedRelationshipInverseSource;

	/**
	 * The cached value of the '{@link #getReifiedRelationshipTarget() <em>Reified Relationship Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReifiedRelationshipTarget()
	 * @generated
	 * @ordered
	 */
	protected ReifiedRelationship reifiedRelationshipTarget;

	/**
	 * The cached value of the '{@link #getReifiedRelationshipInverseTarget() <em>Reified Relationship Inverse Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReifiedRelationshipInverseTarget()
	 * @generated
	 * @ordered
	 */
	protected ReifiedRelationship reifiedRelationshipInverseTarget;

	/**
	 * The cached value of the '{@link #getUnreifiedRelationshipInverse() <em>Unreified Relationship Inverse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnreifiedRelationshipInverse()
	 * @generated
	 * @ordered
	 */
	protected UnreifiedRelationship unreifiedRelationshipInverse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SegmentPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.SEGMENT_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBodySegment getBodySegment() {
		if (eContainerFeatureID() != TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT) return null;
		return (RuleBodySegment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleBodySegment basicGetBodySegment() {
		if (eContainerFeatureID() != TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT) return null;
		return (RuleBodySegment)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodySegment(RuleBodySegment newBodySegment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBodySegment, TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodySegment(RuleBodySegment newBodySegment) {
		if (newBodySegment != eInternalContainer() || (eContainerFeatureID() != TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT && newBodySegment != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newBodySegment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBodySegment != null)
				msgs = ((InternalEObject)newBodySegment).eInverseAdd(this, TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE, RuleBodySegment.class, msgs);
			msgs = basicSetBodySegment(newBodySegment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT, newBodySegment, newBodySegment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate getPredicate() {
		if (predicate != null && ((EObject)predicate).eIsProxy()) {
			InternalEObject oldPredicate = (InternalEObject)predicate;
			predicate = (Predicate)eResolveProxy(oldPredicate);
			if (predicate != oldPredicate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SEGMENT_PREDICATE__PREDICATE, oldPredicate, predicate));
			}
		}
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate basicGetPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(Predicate newPredicate) {
		Predicate oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SEGMENT_PREDICATE__PREDICATE, oldPredicate, predicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getReifiedRelationshipSource() {
		if (reifiedRelationshipSource != null && ((EObject)reifiedRelationshipSource).eIsProxy()) {
			InternalEObject oldReifiedRelationshipSource = (InternalEObject)reifiedRelationshipSource;
			reifiedRelationshipSource = (ReifiedRelationship)eResolveProxy(oldReifiedRelationshipSource);
			if (reifiedRelationshipSource != oldReifiedRelationshipSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_SOURCE, oldReifiedRelationshipSource, reifiedRelationshipSource));
			}
		}
		return reifiedRelationshipSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetReifiedRelationshipSource() {
		return reifiedRelationshipSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReifiedRelationshipSource(ReifiedRelationship newReifiedRelationshipSource) {
		ReifiedRelationship oldReifiedRelationshipSource = reifiedRelationshipSource;
		reifiedRelationshipSource = newReifiedRelationshipSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_SOURCE, oldReifiedRelationshipSource, reifiedRelationshipSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getReifiedRelationshipInverseSource() {
		if (reifiedRelationshipInverseSource != null && ((EObject)reifiedRelationshipInverseSource).eIsProxy()) {
			InternalEObject oldReifiedRelationshipInverseSource = (InternalEObject)reifiedRelationshipInverseSource;
			reifiedRelationshipInverseSource = (ReifiedRelationship)eResolveProxy(oldReifiedRelationshipInverseSource);
			if (reifiedRelationshipInverseSource != oldReifiedRelationshipInverseSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_SOURCE, oldReifiedRelationshipInverseSource, reifiedRelationshipInverseSource));
			}
		}
		return reifiedRelationshipInverseSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetReifiedRelationshipInverseSource() {
		return reifiedRelationshipInverseSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReifiedRelationshipInverseSource(ReifiedRelationship newReifiedRelationshipInverseSource) {
		ReifiedRelationship oldReifiedRelationshipInverseSource = reifiedRelationshipInverseSource;
		reifiedRelationshipInverseSource = newReifiedRelationshipInverseSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_SOURCE, oldReifiedRelationshipInverseSource, reifiedRelationshipInverseSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getReifiedRelationshipTarget() {
		if (reifiedRelationshipTarget != null && ((EObject)reifiedRelationshipTarget).eIsProxy()) {
			InternalEObject oldReifiedRelationshipTarget = (InternalEObject)reifiedRelationshipTarget;
			reifiedRelationshipTarget = (ReifiedRelationship)eResolveProxy(oldReifiedRelationshipTarget);
			if (reifiedRelationshipTarget != oldReifiedRelationshipTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_TARGET, oldReifiedRelationshipTarget, reifiedRelationshipTarget));
			}
		}
		return reifiedRelationshipTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetReifiedRelationshipTarget() {
		return reifiedRelationshipTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReifiedRelationshipTarget(ReifiedRelationship newReifiedRelationshipTarget) {
		ReifiedRelationship oldReifiedRelationshipTarget = reifiedRelationshipTarget;
		reifiedRelationshipTarget = newReifiedRelationshipTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_TARGET, oldReifiedRelationshipTarget, reifiedRelationshipTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getReifiedRelationshipInverseTarget() {
		if (reifiedRelationshipInverseTarget != null && ((EObject)reifiedRelationshipInverseTarget).eIsProxy()) {
			InternalEObject oldReifiedRelationshipInverseTarget = (InternalEObject)reifiedRelationshipInverseTarget;
			reifiedRelationshipInverseTarget = (ReifiedRelationship)eResolveProxy(oldReifiedRelationshipInverseTarget);
			if (reifiedRelationshipInverseTarget != oldReifiedRelationshipInverseTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_TARGET, oldReifiedRelationshipInverseTarget, reifiedRelationshipInverseTarget));
			}
		}
		return reifiedRelationshipInverseTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetReifiedRelationshipInverseTarget() {
		return reifiedRelationshipInverseTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReifiedRelationshipInverseTarget(ReifiedRelationship newReifiedRelationshipInverseTarget) {
		ReifiedRelationship oldReifiedRelationshipInverseTarget = reifiedRelationshipInverseTarget;
		reifiedRelationshipInverseTarget = newReifiedRelationshipInverseTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_TARGET, oldReifiedRelationshipInverseTarget, reifiedRelationshipInverseTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship getUnreifiedRelationshipInverse() {
		if (unreifiedRelationshipInverse != null && ((EObject)unreifiedRelationshipInverse).eIsProxy()) {
			InternalEObject oldUnreifiedRelationshipInverse = (InternalEObject)unreifiedRelationshipInverse;
			unreifiedRelationshipInverse = (UnreifiedRelationship)eResolveProxy(oldUnreifiedRelationshipInverse);
			if (unreifiedRelationshipInverse != oldUnreifiedRelationshipInverse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SEGMENT_PREDICATE__UNREIFIED_RELATIONSHIP_INVERSE, oldUnreifiedRelationshipInverse, unreifiedRelationshipInverse));
			}
		}
		return unreifiedRelationshipInverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship basicGetUnreifiedRelationshipInverse() {
		return unreifiedRelationshipInverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnreifiedRelationshipInverse(UnreifiedRelationship newUnreifiedRelationshipInverse) {
		UnreifiedRelationship oldUnreifiedRelationshipInverse = unreifiedRelationshipInverse;
		unreifiedRelationshipInverse = newUnreifiedRelationshipInverse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SEGMENT_PREDICATE__UNREIFIED_RELATIONSHIP_INVERSE, oldUnreifiedRelationshipInverse, unreifiedRelationshipInverse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term termPredicate() {
		Term _elvis = null;
		Term _elvis_1 = null;
		Term _elvis_2 = null;
		Term _elvis_3 = null;
		Predicate _predicate = this.getPredicate();
		Term _term = null;
		if (_predicate!=null) {
			_term=_predicate.term();
		}
		if (_term != null) {
			_elvis_3 = _term;
		} else {
			ReifiedRelationship _reifiedRelationshipSource = this.getReifiedRelationshipSource();
			_elvis_3 = _reifiedRelationshipSource;
		}
		if (_elvis_3 != null) {
			_elvis_2 = _elvis_3;
		} else {
			ReifiedRelationship _reifiedRelationshipInverseSource = this.getReifiedRelationshipInverseSource();
			_elvis_2 = _reifiedRelationshipInverseSource;
		}
		if (_elvis_2 != null) {
			_elvis_1 = _elvis_2;
		} else {
			ReifiedRelationship _reifiedRelationshipTarget = this.getReifiedRelationshipTarget();
			_elvis_1 = _reifiedRelationshipTarget;
		}
		if (_elvis_1 != null) {
			_elvis = _elvis_1;
		} else {
			ReifiedRelationship _reifiedRelationshipInverseTarget = this.getReifiedRelationshipInverseTarget();
			_elvis = _reifiedRelationshipInverseTarget;
		}
		return _elvis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module moduleContext() {
		return this.getBodySegment().moduleContext();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		Predicate _predicate = this.getPredicate();
		String _uuid = null;
		if (_predicate!=null) {
			_uuid=_predicate.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("predicate", _string);
		RuleBodySegment _bodySegment = this.getBodySegment();
		String _uuid_1 = null;
		if (_bodySegment!=null) {
			_uuid_1=_bodySegment.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("bodySegment", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"SegmentPredicate", _mappedTo, _mappedTo_1);
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBodySegment((RuleBodySegment)otherEnd, msgs);
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
			case TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT:
				return basicSetBodySegment(null, msgs);
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
			case TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT:
				return eInternalContainer().eInverseRemove(this, TerminologiesPackage.RULE_BODY_SEGMENT__PREDICATE, RuleBodySegment.class, msgs);
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
			case TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT:
				if (resolve) return getBodySegment();
				return basicGetBodySegment();
			case TerminologiesPackage.SEGMENT_PREDICATE__PREDICATE:
				if (resolve) return getPredicate();
				return basicGetPredicate();
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_SOURCE:
				if (resolve) return getReifiedRelationshipSource();
				return basicGetReifiedRelationshipSource();
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_SOURCE:
				if (resolve) return getReifiedRelationshipInverseSource();
				return basicGetReifiedRelationshipInverseSource();
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_TARGET:
				if (resolve) return getReifiedRelationshipTarget();
				return basicGetReifiedRelationshipTarget();
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_TARGET:
				if (resolve) return getReifiedRelationshipInverseTarget();
				return basicGetReifiedRelationshipInverseTarget();
			case TerminologiesPackage.SEGMENT_PREDICATE__UNREIFIED_RELATIONSHIP_INVERSE:
				if (resolve) return getUnreifiedRelationshipInverse();
				return basicGetUnreifiedRelationshipInverse();
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
			case TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT:
				setBodySegment((RuleBodySegment)newValue);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__PREDICATE:
				setPredicate((Predicate)newValue);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_SOURCE:
				setReifiedRelationshipSource((ReifiedRelationship)newValue);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_SOURCE:
				setReifiedRelationshipInverseSource((ReifiedRelationship)newValue);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_TARGET:
				setReifiedRelationshipTarget((ReifiedRelationship)newValue);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_TARGET:
				setReifiedRelationshipInverseTarget((ReifiedRelationship)newValue);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__UNREIFIED_RELATIONSHIP_INVERSE:
				setUnreifiedRelationshipInverse((UnreifiedRelationship)newValue);
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
			case TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT:
				setBodySegment((RuleBodySegment)null);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__PREDICATE:
				setPredicate((Predicate)null);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_SOURCE:
				setReifiedRelationshipSource((ReifiedRelationship)null);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_SOURCE:
				setReifiedRelationshipInverseSource((ReifiedRelationship)null);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_TARGET:
				setReifiedRelationshipTarget((ReifiedRelationship)null);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_TARGET:
				setReifiedRelationshipInverseTarget((ReifiedRelationship)null);
				return;
			case TerminologiesPackage.SEGMENT_PREDICATE__UNREIFIED_RELATIONSHIP_INVERSE:
				setUnreifiedRelationshipInverse((UnreifiedRelationship)null);
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
			case TerminologiesPackage.SEGMENT_PREDICATE__BODY_SEGMENT:
				return basicGetBodySegment() != null;
			case TerminologiesPackage.SEGMENT_PREDICATE__PREDICATE:
				return predicate != null;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_SOURCE:
				return reifiedRelationshipSource != null;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_SOURCE:
				return reifiedRelationshipInverseSource != null;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_TARGET:
				return reifiedRelationshipTarget != null;
			case TerminologiesPackage.SEGMENT_PREDICATE__REIFIED_RELATIONSHIP_INVERSE_TARGET:
				return reifiedRelationshipInverseTarget != null;
			case TerminologiesPackage.SEGMENT_PREDICATE__UNREIFIED_RELATIONSHIP_INVERSE:
				return unreifiedRelationshipInverse != null;
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
			case TerminologiesPackage.SEGMENT_PREDICATE___TERM_PREDICATE:
				return termPredicate();
			case TerminologiesPackage.SEGMENT_PREDICATE___MODULE_CONTEXT:
				return moduleContext();
			case TerminologiesPackage.SEGMENT_PREDICATE___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SegmentPredicateImpl
