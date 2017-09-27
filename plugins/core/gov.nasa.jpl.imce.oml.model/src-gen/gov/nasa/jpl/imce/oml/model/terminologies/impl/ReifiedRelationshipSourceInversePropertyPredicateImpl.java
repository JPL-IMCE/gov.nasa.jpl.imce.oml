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

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSourceInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reified Relationship Source Inverse Property Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipSourceInversePropertyPredicateImpl#getReifiedRelationship <em>Reified Relationship</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReifiedRelationshipSourceInversePropertyPredicateImpl extends BinarySegmentReversePropertyPredicateImpl implements ReifiedRelationshipSourceInversePropertyPredicate {
	/**
	 * The cached value of the '{@link #getReifiedRelationship() <em>Reified Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReifiedRelationship()
	 * @generated
	 * @ordered
	 */
	protected ReifiedRelationship reifiedRelationship;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipSourceInversePropertyPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getReifiedRelationship() {
		if (reifiedRelationship != null && ((EObject)reifiedRelationship).eIsProxy()) {
			InternalEObject oldReifiedRelationship = (InternalEObject)reifiedRelationship;
			reifiedRelationship = (ReifiedRelationship)eResolveProxy(oldReifiedRelationship);
			if (reifiedRelationship != oldReifiedRelationship) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP, oldReifiedRelationship, reifiedRelationship));
			}
		}
		return reifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetReifiedRelationship() {
		return reifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReifiedRelationship(ReifiedRelationship newReifiedRelationship) {
		ReifiedRelationship oldReifiedRelationship = reifiedRelationship;
		reifiedRelationship = newReifiedRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP, oldReifiedRelationship, reifiedRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term termPredicate() {
		return this.getReifiedRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		RuleBodySegment _bodySegment = this.getBodySegment();
		String _uuid = null;
		if (_bodySegment!=null) {
			_uuid=_bodySegment.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("bodySegment", _string);
		ReifiedRelationship _reifiedRelationship = this.getReifiedRelationship();
		String _uuid_1 = null;
		if (_reifiedRelationship!=null) {
			_uuid_1=_reifiedRelationship.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("reifiedRelationship", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"ReifiedRelationshipSourceInversePropertyPredicate", _mappedTo, _mappedTo_1);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP:
				if (resolve) return getReifiedRelationship();
				return basicGetReifiedRelationship();
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP:
				setReifiedRelationship((ReifiedRelationship)newValue);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP:
				setReifiedRelationship((ReifiedRelationship)null);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP:
				return reifiedRelationship != null;
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE___TERM_PREDICATE:
				return termPredicate();
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ReifiedRelationshipSourceInversePropertyPredicateImpl
