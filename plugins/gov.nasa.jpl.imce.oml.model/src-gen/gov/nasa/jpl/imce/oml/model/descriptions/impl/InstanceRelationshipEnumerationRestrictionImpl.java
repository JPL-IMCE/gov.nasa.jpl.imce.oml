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

import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipEnumerationRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipOneOfRestriction;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Relationship Enumeration Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.InstanceRelationshipEnumerationRestrictionImpl#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.InstanceRelationshipEnumerationRestrictionImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.InstanceRelationshipEnumerationRestrictionImpl#getRestrictedRelationship <em>Restricted Relationship</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.InstanceRelationshipEnumerationRestrictionImpl#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstanceRelationshipEnumerationRestrictionImpl extends TerminologyInstanceAssertionImpl implements InstanceRelationshipEnumerationRestriction {
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
	 * The cached value of the '{@link #getRestrictedRelationship() <em>Restricted Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedRelationship()
	 * @generated
	 * @ordered
	 */
	protected RestrictableRelationship restrictedRelationship;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceRelationshipOneOfRestriction> references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceRelationshipEnumerationRestrictionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox getDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox basicGetDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptionBox(DescriptionBox newDescriptionBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDescriptionBox, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionBox(DescriptionBox newDescriptionBox) {
		if (newDescriptionBox != eInternalContainer() || (eContainerFeatureID() != DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX && newDescriptionBox != null)) {
			if (EcoreUtil.isAncestor(this, newDescriptionBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDescriptionBox != null)
				msgs = ((InternalEObject)newDescriptionBox).eInverseAdd(this, DescriptionsPackage.DESCRIPTION_BOX__INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTIONS, DescriptionBox.class, msgs);
			msgs = basicSetDescriptionBox(newDescriptionBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX, newDescriptionBox, newDescriptionBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntitySingletonInstance getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (ConceptualEntitySingletonInstance)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DOMAIN, oldDomain, domain));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DOMAIN, oldDomain, domain));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__RESTRICTED_RELATIONSHIP, oldRestrictedRelationship, restrictedRelationship));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__RESTRICTED_RELATIONSHIP, oldRestrictedRelationship, restrictedRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstanceRelationshipOneOfRestriction> getReferences() {
		if (references == null) {
			references = new EObjectContainmentWithInverseEList<InstanceRelationshipOneOfRestriction>(InstanceRelationshipOneOfRestriction.class, this, DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES, DescriptionsPackage.INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION);
		}
		return references;
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
		ConceptualEntitySingletonInstance _domain = this.getDomain();
		String _uuid_1 = null;
		if (_domain!=null) {
			_uuid_1=_domain.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("domain", _string_1);
		RestrictableRelationship _restrictedRelationship = this.getRestrictedRelationship();
		String _uuid_2 = null;
		if (_restrictedRelationship!=null) {
			_uuid_2=_restrictedRelationship.uuid();
		}
		String _string_2 = null;
		if (_uuid_2!=null) {
			_string_2=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("restrictedRelationship", _string_2);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"InstanceRelationshipEnumerationRestriction", _mappedTo, _mappedTo_1, _mappedTo_2);
		String _string_3 = null;
		if (_derivedUUID!=null) {
			_string_3=_derivedUUID.toString();
		}
		return _string_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public gov.nasa.jpl.imce.oml.model.common.Module moduleContext() {
		return this.descriptionBox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogicalElement> allNestedElements() {
		BasicEList<LogicalElement> _xblockexpression = null;
		{
			final BasicEList<LogicalElement> nes = new BasicEList<LogicalElement>();
			nes.addAll(this.getReferences());
			_xblockexpression = nes;
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDescriptionBox((DescriptionBox)otherEnd, msgs);
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferences()).basicAdd(otherEnd, msgs);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX:
				return basicSetDescriptionBox(null, msgs);
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX:
				return eInternalContainer().eInverseRemove(this, DescriptionsPackage.DESCRIPTION_BOX__INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTIONS, DescriptionBox.class, msgs);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX:
				if (resolve) return getDescriptionBox();
				return basicGetDescriptionBox();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__RESTRICTED_RELATIONSHIP:
				if (resolve) return getRestrictedRelationship();
				return basicGetRestrictedRelationship();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES:
				return getReferences();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)newValue);
				return;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DOMAIN:
				setDomain((ConceptualEntitySingletonInstance)newValue);
				return;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__RESTRICTED_RELATIONSHIP:
				setRestrictedRelationship((RestrictableRelationship)newValue);
				return;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends InstanceRelationshipOneOfRestriction>)newValue);
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)null);
				return;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DOMAIN:
				setDomain((ConceptualEntitySingletonInstance)null);
				return;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__RESTRICTED_RELATIONSHIP:
				setRestrictedRelationship((RestrictableRelationship)null);
				return;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES:
				getReferences().clear();
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX:
				return basicGetDescriptionBox() != null;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DOMAIN:
				return domain != null;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__RESTRICTED_RELATIONSHIP:
				return restrictedRelationship != null;
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES:
				return references != null && !references.isEmpty();
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
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION___DESCRIPTION_BOX:
				return descriptionBox();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION___UUID:
				return uuid();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION___MODULE_CONTEXT:
				return moduleContext();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //InstanceRelationshipEnumerationRestrictionImpl
