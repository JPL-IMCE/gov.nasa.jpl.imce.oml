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
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

import gov.nasa.jpl.imce.oml.model.common.impl.ElementCrossReferenceTupleImpl;

import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipEnumerationRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipOneOfRestriction;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Relationship One Of Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.InstanceRelationshipOneOfRestrictionImpl#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.InstanceRelationshipOneOfRestrictionImpl#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstanceRelationshipOneOfRestrictionImpl extends ElementCrossReferenceTupleImpl implements InstanceRelationshipOneOfRestriction {
	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected ConceptualEntitySingletonInstance range;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceRelationshipOneOfRestrictionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceRelationshipEnumerationRestriction getEnumeration() {
		if (eContainerFeatureID() != DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION) return null;
		return (InstanceRelationshipEnumerationRestriction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceRelationshipEnumerationRestriction basicGetEnumeration() {
		if (eContainerFeatureID() != DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION) return null;
		return (InstanceRelationshipEnumerationRestriction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnumeration(InstanceRelationshipEnumerationRestriction newEnumeration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEnumeration, DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumeration(InstanceRelationshipEnumerationRestriction newEnumeration) {
		if (newEnumeration != eInternalContainer() || (eContainerFeatureID() != DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION && newEnumeration != null)) {
			if (EcoreUtil.isAncestor(this, newEnumeration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEnumeration != null)
				msgs = ((InternalEObject)newEnumeration).eInverseAdd(this, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES, InstanceRelationshipEnumerationRestriction.class, msgs);
			msgs = basicSetEnumeration(newEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION, newEnumeration, newEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntitySingletonInstance getRange() {
		if (range != null && range.eIsProxy()) {
			InternalEObject oldRange = (InternalEObject)range;
			range = (ConceptualEntitySingletonInstance)eResolveProxy(oldRange);
			if (range != oldRange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__RANGE, oldRange, range));
			}
		}
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntitySingletonInstance basicGetRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(ConceptualEntitySingletonInstance newRange) {
		ConceptualEntitySingletonInstance oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__RANGE, oldRange, range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		InstanceRelationshipEnumerationRestriction _enumeration = this.getEnumeration();
		String _uuid = null;
		if (_enumeration!=null) {
			_uuid=_enumeration.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("enumeration", _string);
		ConceptualEntitySingletonInstance _range = this.getRange();
		String _uuid_1 = null;
		if (_range!=null) {
			_uuid_1=_range.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("range", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"InstanceRelationshipOneOfRestriction", _mappedTo, _mappedTo_1);
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
	public EList<LogicalElement> allNestedElements() {
		return ECollections.<LogicalElement>emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEnumeration((InstanceRelationshipEnumerationRestriction)otherEnd, msgs);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION:
				return basicSetEnumeration(null, msgs);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION:
				return eInternalContainer().eInverseRemove(this, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES, InstanceRelationshipEnumerationRestriction.class, msgs);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION:
				if (resolve) return getEnumeration();
				return basicGetEnumeration();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__RANGE:
				if (resolve) return getRange();
				return basicGetRange();
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION:
				setEnumeration((InstanceRelationshipEnumerationRestriction)newValue);
				return;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__RANGE:
				setRange((ConceptualEntitySingletonInstance)newValue);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION:
				setEnumeration((InstanceRelationshipEnumerationRestriction)null);
				return;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__RANGE:
				setRange((ConceptualEntitySingletonInstance)null);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION:
				return basicGetEnumeration() != null;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__RANGE:
				return range != null;
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION___UUID:
				return uuid();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //InstanceRelationshipOneOfRestrictionImpl
