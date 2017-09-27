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

import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipInversePropertyPredicate;

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
 * An implementation of the model object '<em><b>Unreified Relationship Inverse Property Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.UnreifiedRelationshipInversePropertyPredicateImpl#getUnreifiedRelationship <em>Unreified Relationship</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnreifiedRelationshipInversePropertyPredicateImpl extends BinarySegmentReversePropertyPredicateImpl implements UnreifiedRelationshipInversePropertyPredicate {
	/**
	 * The cached value of the '{@link #getUnreifiedRelationship() <em>Unreified Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnreifiedRelationship()
	 * @generated
	 * @ordered
	 */
	protected UnreifiedRelationship unreifiedRelationship;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnreifiedRelationshipInversePropertyPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship getUnreifiedRelationship() {
		if (unreifiedRelationship != null && ((EObject)unreifiedRelationship).eIsProxy()) {
			InternalEObject oldUnreifiedRelationship = (InternalEObject)unreifiedRelationship;
			unreifiedRelationship = (UnreifiedRelationship)eResolveProxy(oldUnreifiedRelationship);
			if (unreifiedRelationship != oldUnreifiedRelationship) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP, oldUnreifiedRelationship, unreifiedRelationship));
			}
		}
		return unreifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship basicGetUnreifiedRelationship() {
		return unreifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnreifiedRelationship(UnreifiedRelationship newUnreifiedRelationship) {
		UnreifiedRelationship oldUnreifiedRelationship = unreifiedRelationship;
		unreifiedRelationship = newUnreifiedRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP, oldUnreifiedRelationship, unreifiedRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term termPredicate() {
		return this.getUnreifiedRelationship();
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
		UnreifiedRelationship _unreifiedRelationship = this.getUnreifiedRelationship();
		String _uuid_1 = null;
		if (_unreifiedRelationship!=null) {
			_uuid_1=_unreifiedRelationship.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("unreifiedRelationship", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"UnreifiedRelationshipInversePropertyPredicate", _mappedTo, _mappedTo_1);
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
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP:
				if (resolve) return getUnreifiedRelationship();
				return basicGetUnreifiedRelationship();
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
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP:
				setUnreifiedRelationship((UnreifiedRelationship)newValue);
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
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP:
				setUnreifiedRelationship((UnreifiedRelationship)null);
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
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP:
				return unreifiedRelationship != null;
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
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE___TERM_PREDICATE:
				return termPredicate();
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //UnreifiedRelationshipInversePropertyPredicateImpl
