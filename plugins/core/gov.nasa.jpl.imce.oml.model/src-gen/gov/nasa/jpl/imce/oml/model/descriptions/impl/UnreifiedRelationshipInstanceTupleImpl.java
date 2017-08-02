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

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unreified Relationship Instance Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.UnreifiedRelationshipInstanceTupleImpl#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.UnreifiedRelationshipInstanceTupleImpl#getUnreifiedRelationship <em>Unreified Relationship</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.UnreifiedRelationshipInstanceTupleImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.UnreifiedRelationshipInstanceTupleImpl#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnreifiedRelationshipInstanceTupleImpl extends TerminologyInstanceAssertionImpl implements UnreifiedRelationshipInstanceTuple {
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
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected ConceptualEntitySingletonInstance domain;

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
	protected UnreifiedRelationshipInstanceTupleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox getDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox basicGetDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptionBox(DescriptionBox newDescriptionBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDescriptionBox, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionBox(DescriptionBox newDescriptionBox) {
		if (newDescriptionBox != eInternalContainer() || (eContainerFeatureID() != DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX && newDescriptionBox != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newDescriptionBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDescriptionBox != null)
				msgs = ((InternalEObject)newDescriptionBox).eInverseAdd(this, DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES, DescriptionBox.class, msgs);
			msgs = basicSetDescriptionBox(newDescriptionBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX, newDescriptionBox, newDescriptionBox));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP, oldUnreifiedRelationship, unreifiedRelationship));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP, oldUnreifiedRelationship, unreifiedRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntitySingletonInstance getDomain() {
		if (domain != null && ((EObject)domain).eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (ConceptualEntitySingletonInstance)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntitySingletonInstance basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(ConceptualEntitySingletonInstance newDomain) {
		ConceptualEntitySingletonInstance oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntitySingletonInstance getRange() {
		if (range != null && ((EObject)range).eIsProxy()) {
			InternalEObject oldRange = (InternalEObject)range;
			range = (ConceptualEntitySingletonInstance)eResolveProxy(oldRange);
			if (range != oldRange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE, oldRange, range));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE, oldRange, range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox descriptionBox() {
		return this.getDescriptionBox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		DescriptionBox _descriptionBox = this.descriptionBox();
		String _uuid = null;
		if (_descriptionBox!=null) {
			_uuid=_descriptionBox.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("descriptionBox", _string);
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
		ConceptualEntitySingletonInstance _domain = this.getDomain();
		Object _uuid_2 = null;
		if (_domain!=null) {
			_uuid_2=_domain.uuid();
		}
		String _string_2 = null;
		if (_uuid_2!=null) {
			_string_2=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("domain", _string_2);
		ConceptualEntitySingletonInstance _range = this.getRange();
		Object _uuid_3 = null;
		if (_range!=null) {
			_uuid_3=_range.uuid();
		}
		String _string_3 = null;
		if (_uuid_3!=null) {
			_string_3=_uuid_3.toString();
		}
		Pair<String, String> _mappedTo_3 = Pair.<String, String>of("range", _string_3);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"UnreifiedRelationshipInstanceTuple", _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3);
		String _string_4 = null;
		if (_derivedUUID!=null) {
			_string_4=_derivedUUID.toString();
		}
		return _string_4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module moduleContext() {
		return this.descriptionBox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> allNestedElements() {
		return ECollections.<Element>emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDescriptionBox((DescriptionBox)otherEnd, msgs);
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
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX:
				return basicSetDescriptionBox(null, msgs);
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
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX:
				return eInternalContainer().eInverseRemove(this, DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES, DescriptionBox.class, msgs);
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
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX:
				if (resolve) return getDescriptionBox();
				return basicGetDescriptionBox();
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP:
				if (resolve) return getUnreifiedRelationship();
				return basicGetUnreifiedRelationship();
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE:
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
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)newValue);
				return;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP:
				setUnreifiedRelationship((UnreifiedRelationship)newValue);
				return;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN:
				setDomain((ConceptualEntitySingletonInstance)newValue);
				return;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE:
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
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)null);
				return;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP:
				setUnreifiedRelationship((UnreifiedRelationship)null);
				return;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN:
				setDomain((ConceptualEntitySingletonInstance)null);
				return;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE:
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
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX:
				return basicGetDescriptionBox() != null;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP:
				return unreifiedRelationship != null;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN:
				return domain != null;
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE:
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
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___DESCRIPTION_BOX:
				return descriptionBox();
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___UUID:
				return uuid();
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___MODULE_CONTEXT:
				return moduleContext();
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //UnreifiedRelationshipInstanceTupleImpl
