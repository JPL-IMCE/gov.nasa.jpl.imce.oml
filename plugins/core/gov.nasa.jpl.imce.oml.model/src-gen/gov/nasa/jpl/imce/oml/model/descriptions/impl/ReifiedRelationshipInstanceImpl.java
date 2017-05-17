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

import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;

import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reified Relationship Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceImpl#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceImpl#getSingletonReifiedRelationshipClassifier <em>Singleton Reified Relationship Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReifiedRelationshipInstanceImpl extends ConceptualEntitySingletonInstanceImpl implements ReifiedRelationshipInstance {
	/**
	 * The cached value of the '{@link #getSingletonReifiedRelationshipClassifier() <em>Singleton Reified Relationship Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingletonReifiedRelationshipClassifier()
	 * @generated
	 * @ordered
	 */
	protected ReifiedRelationship singletonReifiedRelationshipClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.REIFIED_RELATIONSHIP_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox getDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox basicGetDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptionBox(DescriptionBox newDescriptionBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDescriptionBox, DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionBox(DescriptionBox newDescriptionBox) {
		if (newDescriptionBox != eInternalContainer() || (eContainerFeatureID() != DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX && newDescriptionBox != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newDescriptionBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDescriptionBox != null)
				msgs = ((InternalEObject)newDescriptionBox).eInverseAdd(this, DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES, DescriptionBox.class, msgs);
			msgs = basicSetDescriptionBox(newDescriptionBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX, newDescriptionBox, newDescriptionBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getSingletonReifiedRelationshipClassifier() {
		if (singletonReifiedRelationshipClassifier != null && ((EObject)singletonReifiedRelationshipClassifier).eIsProxy()) {
			InternalEObject oldSingletonReifiedRelationshipClassifier = (InternalEObject)singletonReifiedRelationshipClassifier;
			singletonReifiedRelationshipClassifier = (ReifiedRelationship)eResolveProxy(oldSingletonReifiedRelationshipClassifier);
			if (singletonReifiedRelationshipClassifier != oldSingletonReifiedRelationshipClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER, oldSingletonReifiedRelationshipClassifier, singletonReifiedRelationshipClassifier));
			}
		}
		return singletonReifiedRelationshipClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetSingletonReifiedRelationshipClassifier() {
		return singletonReifiedRelationshipClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingletonReifiedRelationshipClassifier(ReifiedRelationship newSingletonReifiedRelationshipClassifier) {
		ReifiedRelationship oldSingletonReifiedRelationshipClassifier = singletonReifiedRelationshipClassifier;
		singletonReifiedRelationshipClassifier = newSingletonReifiedRelationshipClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER, oldSingletonReifiedRelationshipClassifier, singletonReifiedRelationshipClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntity conceptualEntitySingletonClassifier() {
		return this.getSingletonReifiedRelationshipClassifier();
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX:
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
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX:
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
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX:
				return eInternalContainer().eInverseRemove(this, DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES, DescriptionBox.class, msgs);
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
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX:
				if (resolve) return getDescriptionBox();
				return basicGetDescriptionBox();
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER:
				if (resolve) return getSingletonReifiedRelationshipClassifier();
				return basicGetSingletonReifiedRelationshipClassifier();
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
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)newValue);
				return;
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER:
				setSingletonReifiedRelationshipClassifier((ReifiedRelationship)newValue);
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
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)null);
				return;
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER:
				setSingletonReifiedRelationshipClassifier((ReifiedRelationship)null);
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
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX:
				return basicGetDescriptionBox() != null;
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER:
				return singletonReifiedRelationshipClassifier != null;
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
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER:
				return conceptualEntitySingletonClassifier();
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE___DESCRIPTION_BOX:
				return descriptionBox();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ReifiedRelationshipInstanceImpl
