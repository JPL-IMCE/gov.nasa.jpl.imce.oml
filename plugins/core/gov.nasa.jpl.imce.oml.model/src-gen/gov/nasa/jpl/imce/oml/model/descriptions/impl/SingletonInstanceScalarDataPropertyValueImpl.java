/**
 */
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.LiteralValue;
import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl;

import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;

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
 * An implementation of the model object '<em><b>Singleton Instance Scalar Data Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceScalarDataPropertyValueImpl#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceScalarDataPropertyValueImpl#getSingletonInstance <em>Singleton Instance</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceScalarDataPropertyValueImpl#getScalarDataProperty <em>Scalar Data Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceScalarDataPropertyValueImpl#getScalarPropertyValue <em>Scalar Property Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingletonInstanceScalarDataPropertyValueImpl extends ModuleElementImpl implements SingletonInstanceScalarDataPropertyValue {
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
	 * The cached value of the '{@link #getScalarDataProperty() <em>Scalar Data Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalarDataProperty()
	 * @generated
	 * @ordered
	 */
	protected EntityScalarDataProperty scalarDataProperty;

	/**
	 * The cached value of the '{@link #getScalarPropertyValue() <em>Scalar Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalarPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected LiteralValue scalarPropertyValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingletonInstanceScalarDataPropertyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox getDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox basicGetDescriptionBox() {
		if (eContainerFeatureID() != DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX) return null;
		return (DescriptionBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptionBox(DescriptionBox newDescriptionBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDescriptionBox, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionBox(DescriptionBox newDescriptionBox) {
		if (newDescriptionBox != eInternalContainer() || (eContainerFeatureID() != DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX && newDescriptionBox != null)) {
			if (EcoreUtil.isAncestor(this, newDescriptionBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDescriptionBox != null)
				msgs = ((InternalEObject)newDescriptionBox).eInverseAdd(this, DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES, DescriptionBox.class, msgs);
			msgs = basicSetDescriptionBox(newDescriptionBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX, newDescriptionBox, newDescriptionBox));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE, oldSingletonInstance, singletonInstance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE, oldSingletonInstance, singletonInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityScalarDataProperty getScalarDataProperty() {
		if (scalarDataProperty != null && scalarDataProperty.eIsProxy()) {
			InternalEObject oldScalarDataProperty = (InternalEObject)scalarDataProperty;
			scalarDataProperty = (EntityScalarDataProperty)eResolveProxy(oldScalarDataProperty);
			if (scalarDataProperty != oldScalarDataProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY, oldScalarDataProperty, scalarDataProperty));
			}
		}
		return scalarDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityScalarDataProperty basicGetScalarDataProperty() {
		return scalarDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScalarDataProperty(EntityScalarDataProperty newScalarDataProperty) {
		EntityScalarDataProperty oldScalarDataProperty = scalarDataProperty;
		scalarDataProperty = newScalarDataProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY, oldScalarDataProperty, scalarDataProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralValue getScalarPropertyValue() {
		return scalarPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScalarPropertyValue(LiteralValue newScalarPropertyValue, NotificationChain msgs) {
		LiteralValue oldScalarPropertyValue = scalarPropertyValue;
		scalarPropertyValue = newScalarPropertyValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE, oldScalarPropertyValue, newScalarPropertyValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScalarPropertyValue(LiteralValue newScalarPropertyValue) {
		if (newScalarPropertyValue != scalarPropertyValue) {
			NotificationChain msgs = null;
			if (scalarPropertyValue != null)
				msgs = ((InternalEObject)scalarPropertyValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE, null, msgs);
			if (newScalarPropertyValue != null)
				msgs = ((InternalEObject)newScalarPropertyValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE, null, msgs);
			msgs = basicSetScalarPropertyValue(newScalarPropertyValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE, newScalarPropertyValue, newScalarPropertyValue));
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
		EntityScalarDataProperty _scalarDataProperty = this.getScalarDataProperty();
		String _uuid_2 = null;
		if (_scalarDataProperty!=null) {
			_uuid_2=_scalarDataProperty.uuid();
		}
		String _string_2 = null;
		if (_uuid_2!=null) {
			_string_2=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("scalarDataProperty", _string_2);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"ScalarDataPropertyValue", _mappedTo, _mappedTo_1, _mappedTo_2);
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
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
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
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				return basicSetDescriptionBox(null, msgs);
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				return basicSetScalarPropertyValue(null, msgs);
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
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				return eInternalContainer().eInverseRemove(this, DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES, DescriptionBox.class, msgs);
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
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				if (resolve) return getDescriptionBox();
				return basicGetDescriptionBox();
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE:
				if (resolve) return getSingletonInstance();
				return basicGetSingletonInstance();
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY:
				if (resolve) return getScalarDataProperty();
				return basicGetScalarDataProperty();
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				return getScalarPropertyValue();
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
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)newValue);
				return;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE:
				setSingletonInstance((ConceptualEntitySingletonInstance)newValue);
				return;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY:
				setScalarDataProperty((EntityScalarDataProperty)newValue);
				return;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				setScalarPropertyValue((LiteralValue)newValue);
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
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				setDescriptionBox((DescriptionBox)null);
				return;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE:
				setSingletonInstance((ConceptualEntitySingletonInstance)null);
				return;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY:
				setScalarDataProperty((EntityScalarDataProperty)null);
				return;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				setScalarPropertyValue((LiteralValue)null);
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
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX:
				return basicGetDescriptionBox() != null;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE:
				return singletonInstance != null;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY:
				return scalarDataProperty != null;
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
				return scalarPropertyValue != null;
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
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___UUID:
				return uuid();
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___DESCRIPTION_BOX:
				return descriptionBox();
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___MODULE_CONTEXT:
				return moduleContext();
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SingletonInstanceScalarDataPropertyValueImpl
