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

import gov.nasa.jpl.imce.oml.model.terminologies.EntityForwardReifiedRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty;
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
 * An implementation of the model object '<em><b>Entity Forward Reified Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityForwardReifiedRestrictionAxiomImpl#getForwardProperty <em>Forward Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityForwardReifiedRestrictionAxiomImpl extends EntityReifiedRestrictionAxiomImpl implements EntityForwardReifiedRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getForwardProperty() <em>Forward Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardProperty()
	 * @generated
	 * @ordered
	 */
	protected ForwardProperty forwardProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityForwardReifiedRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_FORWARD_REIFIED_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardProperty getForwardProperty() {
		if (forwardProperty != null && ((EObject)forwardProperty).eIsProxy()) {
			InternalEObject oldForwardProperty = (InternalEObject)forwardProperty;
			forwardProperty = (ForwardProperty)eResolveProxy(oldForwardProperty);
			if (forwardProperty != oldForwardProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_FORWARD_REIFIED_RESTRICTION_AXIOM__FORWARD_PROPERTY, oldForwardProperty, forwardProperty));
			}
		}
		return forwardProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardProperty basicGetForwardProperty() {
		return forwardProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForwardProperty(ForwardProperty newForwardProperty) {
		ForwardProperty oldForwardProperty = forwardProperty;
		forwardProperty = newForwardProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_FORWARD_REIFIED_RESTRICTION_AXIOM__FORWARD_PROPERTY, oldForwardProperty, forwardProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRelationship restrictedRelation() {
		return this.getForwardProperty().getReifiedRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_FORWARD_REIFIED_RESTRICTION_AXIOM__FORWARD_PROPERTY:
				if (resolve) return getForwardProperty();
				return basicGetForwardProperty();
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
			case TerminologiesPackage.ENTITY_FORWARD_REIFIED_RESTRICTION_AXIOM__FORWARD_PROPERTY:
				setForwardProperty((ForwardProperty)newValue);
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
			case TerminologiesPackage.ENTITY_FORWARD_REIFIED_RESTRICTION_AXIOM__FORWARD_PROPERTY:
				setForwardProperty((ForwardProperty)null);
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
			case TerminologiesPackage.ENTITY_FORWARD_REIFIED_RESTRICTION_AXIOM__FORWARD_PROPERTY:
				return forwardProperty != null;
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
			case TerminologiesPackage.ENTITY_FORWARD_REIFIED_RESTRICTION_AXIOM___RESTRICTED_RELATION:
				return restrictedRelation();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityForwardReifiedRestrictionAxiomImpl
