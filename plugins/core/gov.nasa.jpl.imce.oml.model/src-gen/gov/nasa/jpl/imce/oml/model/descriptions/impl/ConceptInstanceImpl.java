/**
 */
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;

import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptInstanceImpl#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptInstanceImpl#getSingletonConceptClassifier <em>Singleton Concept Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptInstanceImpl extends ConceptualEntitySingletonInstanceImpl implements ConceptInstance {
	/**
	 * The cached value of the '{@link #getSingletonConceptClassifier() <em>Singleton Concept Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingletonConceptClassifier()
	 * @generated
	 * @ordered
	 */
	protected Concept singletonConceptClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.CONCEPT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox getDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox basicGetDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptionBox(DescriptionBox newDescriptionBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDescriptionBox, DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionBox(DescriptionBox newDescriptionBox) {
		if (newDescriptionBox != eInternalContainer() || (eContainerFeatureID() != DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX && newDescriptionBox != null)) {
			if (EcoreUtil.isAncestor(this, newDescriptionBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDescriptionBox != null)
				msgs = ((InternalEObject)newDescriptionBox).eInverseAdd(this, DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES, DescriptionBox.class, msgs);
			msgs = basicSetDescriptionBox(newDescriptionBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX, newDescriptionBox, newDescriptionBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept getSingletonConceptClassifier() {
		if (singletonConceptClassifier != null && singletonConceptClassifier.eIsProxy()) {
			InternalEObject oldSingletonConceptClassifier = (InternalEObject)singletonConceptClassifier;
			singletonConceptClassifier = (Concept)eResolveProxy(oldSingletonConceptClassifier);
			if (singletonConceptClassifier != oldSingletonConceptClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER, oldSingletonConceptClassifier, singletonConceptClassifier));
			}
		}
		return singletonConceptClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept basicGetSingletonConceptClassifier() {
		return singletonConceptClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingletonConceptClassifier(Concept newSingletonConceptClassifier) {
		Concept oldSingletonConceptClassifier = singletonConceptClassifier;
		singletonConceptClassifier = newSingletonConceptClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER, oldSingletonConceptClassifier, singletonConceptClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntity conceptualEntitySingletonClassifier() {
		return this.getSingletonConceptClassifier();
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
			case DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX:
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
			case DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX:
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
			case DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX:
				return eInternalContainer().eInverseRemove(this, DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES, DescriptionBox.class, msgs);
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
			case DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX:
				if (resolve) return getDescriptionBox();
				return basicGetDescriptionBox();
			case DescriptionsPackage.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER:
				if (resolve) return getSingletonConceptClassifier();
				return basicGetSingletonConceptClassifier();
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
			case DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)newValue);
				return;
			case DescriptionsPackage.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER:
				setSingletonConceptClassifier((Concept)newValue);
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
			case DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)null);
				return;
			case DescriptionsPackage.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER:
				setSingletonConceptClassifier((Concept)null);
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
			case DescriptionsPackage.CONCEPT_INSTANCE__DESCRIPTION_BOX:
				return basicGetDescriptionBox() != null;
			case DescriptionsPackage.CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER:
				return singletonConceptClassifier != null;
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
			case DescriptionsPackage.CONCEPT_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER:
				return conceptualEntitySingletonClassifier();
			case DescriptionsPackage.CONCEPT_INSTANCE___DESCRIPTION_BOX:
				return descriptionBox();
			case DescriptionsPackage.CONCEPT_INSTANCE___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConceptInstanceImpl
