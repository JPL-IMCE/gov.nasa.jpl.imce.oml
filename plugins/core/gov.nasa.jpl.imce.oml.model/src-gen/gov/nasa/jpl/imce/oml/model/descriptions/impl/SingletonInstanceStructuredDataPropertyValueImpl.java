/**
 */
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Singleton Instance Structured Data Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyValueImpl#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyValueImpl#getSingletonInstance <em>Singleton Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingletonInstanceStructuredDataPropertyValueImpl extends SingletonInstanceStructuredDataPropertyContextImpl implements SingletonInstanceStructuredDataPropertyValue {
	/**
	 * The cached value of the '{@link #getSingletonInstance() <em>Singleton Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingletonInstance()
	 * @generated
	 * @ordered
	 */
	protected ConceptualEntitySingletonInstance singletonInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingletonInstanceStructuredDataPropertyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox getDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox basicGetDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptionBox(DescriptionBox newDescriptionBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDescriptionBox, DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionBox(DescriptionBox newDescriptionBox) {
		if (newDescriptionBox != eInternalContainer() || (eContainerFeatureID() != DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX && newDescriptionBox != null)) {
			if (EcoreUtil.isAncestor(this, newDescriptionBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDescriptionBox != null)
				msgs = ((InternalEObject)newDescriptionBox).eInverseAdd(this, DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES, DescriptionBox.class, msgs);
			msgs = basicSetDescriptionBox(newDescriptionBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX, newDescriptionBox, newDescriptionBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntitySingletonInstance getSingletonInstance() {
		if (singletonInstance != null && singletonInstance.eIsProxy()) {
			InternalEObject oldSingletonInstance = (InternalEObject)singletonInstance;
			singletonInstance = (ConceptualEntitySingletonInstance)eResolveProxy(oldSingletonInstance);
			if (singletonInstance != oldSingletonInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE, oldSingletonInstance, singletonInstance));
			}
		}
		return singletonInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualEntitySingletonInstance basicGetSingletonInstance() {
		return singletonInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingletonInstance(ConceptualEntitySingletonInstance newSingletonInstance) {
		ConceptualEntitySingletonInstance oldSingletonInstance = singletonInstance;
		singletonInstance = newSingletonInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE, oldSingletonInstance, singletonInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		DescriptionBox _descriptionBox = this.getDescriptionBox();
		String _uuid = null;
		if (_descriptionBox!=null) {
			_uuid=_descriptionBox.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("descriptionBox", _string);
		ConceptualEntitySingletonInstance _singletonInstance = this.getSingletonInstance();
		String _uuid_1 = null;
		if (_singletonInstance!=null) {
			_uuid_1=_singletonInstance.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("singletonInstance", _string_1);
		DataRelationshipToStructure _structuredDataProperty = this.getStructuredDataProperty();
		String _uuid_2 = null;
		if (_structuredDataProperty!=null) {
			_uuid_2=_structuredDataProperty.uuid();
		}
		String _string_2 = null;
		if (_uuid_2!=null) {
			_string_2=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("structuredDataProperty", _string_2);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"SingletonInstanceStructuredDataPropertyValue", _mappedTo, _mappedTo_1, _mappedTo_2);
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
	public DescriptionBox descriptionBox() {
		return this.getDescriptionBox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> allNestedElements() {
		return this.allNestedRestrictionElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
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
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
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
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				return eInternalContainer().eInverseRemove(this, DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES, DescriptionBox.class, msgs);
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
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				if (resolve) return getDescriptionBox();
				return basicGetDescriptionBox();
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE:
				if (resolve) return getSingletonInstance();
				return basicGetSingletonInstance();
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
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)newValue);
				return;
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE:
				setSingletonInstance((ConceptualEntitySingletonInstance)newValue);
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
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)null);
				return;
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE:
				setSingletonInstance((ConceptualEntitySingletonInstance)null);
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
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				return basicGetDescriptionBox() != null;
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE:
				return singletonInstance != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Element.class) {
			switch (baseOperationID) {
				case CommonPackage.ELEMENT___UUID: return DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___UUID;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == SingletonInstanceStructuredDataPropertyContext.class) {
			switch (baseOperationID) {
				case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT___DESCRIPTION_BOX: return DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___DESCRIPTION_BOX;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ModuleElement.class) {
			switch (baseOperationID) {
				case CommonPackage.MODULE_ELEMENT___ALL_NESTED_ELEMENTS: return DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___ALL_NESTED_ELEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___UUID:
				return uuid();
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___DESCRIPTION_BOX:
				return descriptionBox();
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SingletonInstanceStructuredDataPropertyValueImpl
