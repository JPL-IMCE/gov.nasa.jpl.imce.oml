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

import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;

import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedConcept;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictionKind;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cardinality Restricted Concept</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CardinalityRestrictedConceptImpl#getRestrictionKind <em>Restriction Kind</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CardinalityRestrictedConceptImpl#getRestrictedRelationship <em>Restricted Relationship</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CardinalityRestrictedConceptImpl#getRestrictedRange <em>Restricted Range</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CardinalityRestrictedConceptImpl#getRestrictedCardinality <em>Restricted Cardinality</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardinalityRestrictedConceptImpl extends ConceptKindImpl implements CardinalityRestrictedConcept {
	/**
	 * The default value of the '{@link #getRestrictionKind() <em>Restriction Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictionKind()
	 * @generated
	 * @ordered
	 */
	protected static final CardinalityRestrictionKind RESTRICTION_KIND_EDEFAULT = CardinalityRestrictionKind.MIN;

	/**
	 * The cached value of the '{@link #getRestrictionKind() <em>Restriction Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictionKind()
	 * @generated
	 * @ordered
	 */
	protected CardinalityRestrictionKind restrictionKind = RESTRICTION_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRestrictedRelationship() <em>Restricted Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedRelationship()
	 * @generated
	 * @ordered
	 */
	protected RestrictableRelationship restrictedRelationship;

	/**
	 * The cached value of the '{@link #getRestrictedRange() <em>Restricted Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedRange()
	 * @generated
	 * @ordered
	 */
	protected Entity restrictedRange;

	/**
	 * The default value of the '{@link #getRestrictedCardinality() <em>Restricted Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final PositiveIntegerValue RESTRICTED_CARDINALITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRestrictedCardinality() <em>Restricted Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedCardinality()
	 * @generated
	 * @ordered
	 */
	protected PositiveIntegerValue restrictedCardinality = RESTRICTED_CARDINALITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityRestrictedConceptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.CARDINALITY_RESTRICTED_CONCEPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityRestrictionKind getRestrictionKind() {
		return restrictionKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictionKind(CardinalityRestrictionKind newRestrictionKind) {
		CardinalityRestrictionKind oldRestrictionKind = restrictionKind;
		restrictionKind = newRestrictionKind == null ? RESTRICTION_KIND_EDEFAULT : newRestrictionKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTION_KIND, oldRestrictionKind, restrictionKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestrictableRelationship getRestrictedRelationship() {
		if (restrictedRelationship != null && restrictedRelationship.eIsProxy()) {
			InternalEObject oldRestrictedRelationship = (InternalEObject)restrictedRelationship;
			restrictedRelationship = (RestrictableRelationship)eResolveProxy(oldRestrictedRelationship);
			if (restrictedRelationship != oldRestrictedRelationship) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RELATIONSHIP, oldRestrictedRelationship, restrictedRelationship));
			}
		}
		return restrictedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestrictableRelationship basicGetRestrictedRelationship() {
		return restrictedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedRelationship(RestrictableRelationship newRestrictedRelationship) {
		RestrictableRelationship oldRestrictedRelationship = restrictedRelationship;
		restrictedRelationship = newRestrictedRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RELATIONSHIP, oldRestrictedRelationship, restrictedRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getRestrictedRange() {
		if (restrictedRange != null && restrictedRange.eIsProxy()) {
			InternalEObject oldRestrictedRange = (InternalEObject)restrictedRange;
			restrictedRange = (Entity)eResolveProxy(oldRestrictedRange);
			if (restrictedRange != oldRestrictedRange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RANGE, oldRestrictedRange, restrictedRange));
			}
		}
		return restrictedRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetRestrictedRange() {
		return restrictedRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedRange(Entity newRestrictedRange) {
		Entity oldRestrictedRange = restrictedRange;
		restrictedRange = newRestrictedRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RANGE, oldRestrictedRange, restrictedRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositiveIntegerValue getRestrictedCardinality() {
		return restrictedCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedCardinality(PositiveIntegerValue newRestrictedCardinality) {
		PositiveIntegerValue oldRestrictedCardinality = restrictedCardinality;
		restrictedCardinality = newRestrictedCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_CARDINALITY, oldRestrictedCardinality, restrictedCardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTION_KIND:
				return getRestrictionKind();
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RELATIONSHIP:
				if (resolve) return getRestrictedRelationship();
				return basicGetRestrictedRelationship();
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RANGE:
				if (resolve) return getRestrictedRange();
				return basicGetRestrictedRange();
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_CARDINALITY:
				return getRestrictedCardinality();
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
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTION_KIND:
				setRestrictionKind((CardinalityRestrictionKind)newValue);
				return;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RELATIONSHIP:
				setRestrictedRelationship((RestrictableRelationship)newValue);
				return;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RANGE:
				setRestrictedRange((Entity)newValue);
				return;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_CARDINALITY:
				setRestrictedCardinality((PositiveIntegerValue)newValue);
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
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTION_KIND:
				setRestrictionKind(RESTRICTION_KIND_EDEFAULT);
				return;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RELATIONSHIP:
				setRestrictedRelationship((RestrictableRelationship)null);
				return;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RANGE:
				setRestrictedRange((Entity)null);
				return;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_CARDINALITY:
				setRestrictedCardinality(RESTRICTED_CARDINALITY_EDEFAULT);
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
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTION_KIND:
				return restrictionKind != RESTRICTION_KIND_EDEFAULT;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RELATIONSHIP:
				return restrictedRelationship != null;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_RANGE:
				return restrictedRange != null;
			case TerminologiesPackage.CARDINALITY_RESTRICTED_CONCEPT__RESTRICTED_CARDINALITY:
				return RESTRICTED_CARDINALITY_EDEFAULT == null ? restrictedCardinality != null : !RESTRICTED_CARDINALITY_EDEFAULT.equals(restrictedCardinality);
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (restrictionKind: ");
		result.append(restrictionKind);
		result.append(", restrictedCardinality: ");
		result.append(restrictedCardinality);
		result.append(')');
		return result.toString();
	}

} //CardinalityRestrictedConceptImpl
