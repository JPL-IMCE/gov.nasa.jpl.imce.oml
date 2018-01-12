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

import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUnreifiedRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Unreified Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityUnreifiedRestrictionAxiomImpl#getRestrictedUnreifiedRelationship <em>Restricted Unreified Relationship</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityUnreifiedRestrictionAxiomImpl extends EntityRestrictionAxiomImpl implements EntityUnreifiedRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getRestrictedUnreifiedRelationship() <em>Restricted Unreified Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedUnreifiedRelationship()
	 * @generated
	 * @ordered
	 */
	protected UnreifiedRelationship restrictedUnreifiedRelationship;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityUnreifiedRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_UNREIFIED_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship getRestrictedUnreifiedRelationship() {
		if (restrictedUnreifiedRelationship != null && ((EObject)restrictedUnreifiedRelationship).eIsProxy()) {
			InternalEObject oldRestrictedUnreifiedRelationship = (InternalEObject)restrictedUnreifiedRelationship;
			restrictedUnreifiedRelationship = (UnreifiedRelationship)eResolveProxy(oldRestrictedUnreifiedRelationship);
			if (restrictedUnreifiedRelationship != oldRestrictedUnreifiedRelationship) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP, oldRestrictedUnreifiedRelationship, restrictedUnreifiedRelationship));
			}
		}
		return restrictedUnreifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship basicGetRestrictedUnreifiedRelationship() {
		return restrictedUnreifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedUnreifiedRelationship(UnreifiedRelationship newRestrictedUnreifiedRelationship) {
		UnreifiedRelationship oldRestrictedUnreifiedRelationship = restrictedUnreifiedRelationship;
		restrictedUnreifiedRelationship = newRestrictedUnreifiedRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP, oldRestrictedUnreifiedRelationship, restrictedUnreifiedRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRelationship restrictedRelation() {
		return this.getRestrictedUnreifiedRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP:
				if (resolve) return getRestrictedUnreifiedRelationship();
				return basicGetRestrictedUnreifiedRelationship();
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
			case TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP:
				setRestrictedUnreifiedRelationship((UnreifiedRelationship)newValue);
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
			case TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP:
				setRestrictedUnreifiedRelationship((UnreifiedRelationship)null);
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
			case TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP:
				return restrictedUnreifiedRelationship != null;
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
			case TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM___RESTRICTED_RELATION:
				return restrictedRelation();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityUnreifiedRestrictionAxiomImpl
