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

import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipInversePropertyPredicate;
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
 * An implementation of the model object '<em><b>Reified Relationship Inverse Property Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipInversePropertyPredicateImpl#getInverseProperty <em>Inverse Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReifiedRelationshipInversePropertyPredicateImpl extends BinarySegmentReversePropertyPredicateImpl implements ReifiedRelationshipInversePropertyPredicate {
	/**
	 * The cached value of the '{@link #getInverseProperty() <em>Inverse Property</em>}' reference.
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
	protected ReifiedRelationshipInversePropertyPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseProperty getInverseProperty() {
		if (inverseProperty != null && ((EObject)inverseProperty).eIsProxy()) {
			InternalEObject oldInverseProperty = (InternalEObject)inverseProperty;
			inverseProperty = (InverseProperty)eResolveProxy(oldInverseProperty);
			if (inverseProperty != oldInverseProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__INVERSE_PROPERTY, oldInverseProperty, inverseProperty));
			}
		}
		return inverseProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseProperty basicGetInverseProperty() {
		return inverseProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverseProperty(InverseProperty newInverseProperty) {
		InverseProperty oldInverseProperty = inverseProperty;
		inverseProperty = newInverseProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__INVERSE_PROPERTY, oldInverseProperty, inverseProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term termPredicate() {
		InverseProperty _inverseProperty = this.getInverseProperty();
		ReifiedRelationship _reifiedRelationship = null;
		if (_inverseProperty!=null) {
			_reifiedRelationship=_inverseProperty.getReifiedRelationship();
		}
		return _reifiedRelationship;
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
		InverseProperty _inverseProperty = this.getInverseProperty();
		String _uuid_1 = null;
		if (_inverseProperty!=null) {
			_uuid_1=_inverseProperty.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inverseProperty", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"ReifiedRelationshipInversePropertyPredicate", _mappedTo, _mappedTo_1);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__INVERSE_PROPERTY:
				if (resolve) return getInverseProperty();
				return basicGetInverseProperty();
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__INVERSE_PROPERTY:
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__INVERSE_PROPERTY:
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__INVERSE_PROPERTY:
				return inverseProperty != null;
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE___TERM_PREDICATE:
				return termPredicate();
			case TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ReifiedRelationshipInversePropertyPredicateImpl
