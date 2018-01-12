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

import gov.nasa.jpl.imce.oml.model.terminologies.EntityInverseReifiedRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Inverse Reified Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityInverseReifiedRestrictionAxiomImpl#getInverseProperty <em>Inverse Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityInverseReifiedRestrictionAxiomImpl extends EntityReifiedRestrictionAxiomImpl implements EntityInverseReifiedRestrictionAxiom {
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
	protected EntityInverseReifiedRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_INVERSE_REIFIED_RESTRICTION_AXIOM;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_INVERSE_REIFIED_RESTRICTION_AXIOM__INVERSE_PROPERTY, oldInverseProperty, inverseProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_INVERSE_REIFIED_RESTRICTION_AXIOM__INVERSE_PROPERTY, oldInverseProperty, inverseProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRelationship restrictedRelation() {
		return this.getInverseProperty().getReifiedRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_INVERSE_REIFIED_RESTRICTION_AXIOM__INVERSE_PROPERTY:
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
			case TerminologiesPackage.ENTITY_INVERSE_REIFIED_RESTRICTION_AXIOM__INVERSE_PROPERTY:
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
			case TerminologiesPackage.ENTITY_INVERSE_REIFIED_RESTRICTION_AXIOM__INVERSE_PROPERTY:
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
			case TerminologiesPackage.ENTITY_INVERSE_REIFIED_RESTRICTION_AXIOM__INVERSE_PROPERTY:
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
			case TerminologiesPackage.ENTITY_INVERSE_REIFIED_RESTRICTION_AXIOM___RESTRICTED_RELATION:
				return restrictedRelation();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityInverseReifiedRestrictionAxiomImpl
