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
package gov.nasa.jpl.imce.oml.model.common.impl;

import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.datatypes.StringValue;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationPropertyValueImpl extends CDOObjectImpl implements AnnotationPropertyValue {
	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected AnnotationProperty property;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final StringValue VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected StringValue value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationPropertyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.ANNOTATION_PROPERTY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUuid() {
		Element _subject = this.getSubject();
		String _uuid = null;
		if (_subject!=null) {
			_uuid=_subject.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("subject", _string);
		AnnotationProperty _property = this.getProperty();
		String _uuid_1 = null;
		if (_property!=null) {
			_uuid_1=_property.getUuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("property", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"AnnotationPropertyValue", _mappedTo, _mappedTo_1);
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
	public Element getSubject() {
		if (eContainerFeatureID() != CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT) return null;
		return (Element)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetSubject() {
		if (eContainerFeatureID() != CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT) return null;
		return (Element)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubject(Element newSubject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSubject, CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(Element newSubject) {
		if (newSubject != eInternalContainer() || (eContainerFeatureID() != CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT && newSubject != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newSubject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSubject != null)
				msgs = ((InternalEObject)newSubject).eInverseAdd(this, CommonPackage.ELEMENT__ANNOTATIONS, Element.class, msgs);
			msgs = basicSetSubject(newSubject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT, newSubject, newSubject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationProperty getProperty() {
		if (property != null && ((EObject)property).eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (AnnotationProperty)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonPackage.ANNOTATION_PROPERTY_VALUE__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationProperty basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(AnnotationProperty newProperty) {
		AnnotationProperty oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ANNOTATION_PROPERTY_VALUE__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValue getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(StringValue newValue) {
		StringValue oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ANNOTATION_PROPERTY_VALUE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSubject((Element)otherEnd, msgs);
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
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT:
				return basicSetSubject(null, msgs);
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
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT:
				return eInternalContainer().eInverseRemove(this, CommonPackage.ELEMENT__ANNOTATIONS, Element.class, msgs);
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
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__UUID:
				return getUuid();
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT:
				if (resolve) return getSubject();
				return basicGetSubject();
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__VALUE:
				return getValue();
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
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT:
				setSubject((Element)newValue);
				return;
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__PROPERTY:
				setProperty((AnnotationProperty)newValue);
				return;
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__VALUE:
				setValue((StringValue)newValue);
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
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT:
				setSubject((Element)null);
				return;
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__PROPERTY:
				setProperty((AnnotationProperty)null);
				return;
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__UUID:
				return UUID_EDEFAULT == null ? getUuid() != null : !UUID_EDEFAULT.equals(getUuid());
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__SUBJECT:
				return basicGetSubject() != null;
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__PROPERTY:
				return property != null;
			case CommonPackage.ANNOTATION_PROPERTY_VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //AnnotationPropertyValueImpl
