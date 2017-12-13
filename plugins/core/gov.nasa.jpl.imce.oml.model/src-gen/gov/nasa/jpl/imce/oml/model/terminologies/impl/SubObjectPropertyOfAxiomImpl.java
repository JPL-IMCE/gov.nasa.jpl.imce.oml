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

import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Object Property Of Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SubObjectPropertyOfAxiomImpl#getSubProperty <em>Sub Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SubObjectPropertyOfAxiomImpl#getSuperProperty <em>Super Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubObjectPropertyOfAxiomImpl extends TermAxiomImpl implements SubObjectPropertyOfAxiom {
	/**
	 * The cached value of the '{@link #getSubProperty() <em>Sub Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProperty()
	 * @generated
	 * @ordered
	 */
	protected UnreifiedRelationship subProperty;

	/**
	 * The cached value of the '{@link #getSuperProperty() <em>Super Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperProperty()
	 * @generated
	 * @ordered
	 */
	protected UnreifiedRelationship superProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubObjectPropertyOfAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.SUB_OBJECT_PROPERTY_OF_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship getSubProperty() {
		if (subProperty != null && ((EObject)subProperty).eIsProxy()) {
			InternalEObject oldSubProperty = (InternalEObject)subProperty;
			subProperty = (UnreifiedRelationship)eResolveProxy(oldSubProperty);
			if (subProperty != oldSubProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUB_PROPERTY, oldSubProperty, subProperty));
			}
		}
		return subProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship basicGetSubProperty() {
		return subProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubProperty(UnreifiedRelationship newSubProperty) {
		UnreifiedRelationship oldSubProperty = subProperty;
		subProperty = newSubProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUB_PROPERTY, oldSubProperty, subProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship getSuperProperty() {
		if (superProperty != null && ((EObject)superProperty).eIsProxy()) {
			InternalEObject oldSuperProperty = (InternalEObject)superProperty;
			superProperty = (UnreifiedRelationship)eResolveProxy(oldSuperProperty);
			if (superProperty != oldSuperProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUPER_PROPERTY, oldSuperProperty, superProperty));
			}
		}
		return superProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship basicGetSuperProperty() {
		return superProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperProperty(UnreifiedRelationship newSuperProperty) {
		UnreifiedRelationship oldSuperProperty = superProperty;
		superProperty = newSuperProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUPER_PROPERTY, oldSuperProperty, superProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		TerminologyBox _tbox = this.getTbox();
		String _uuid = null;
		if (_tbox!=null) {
			_uuid=_tbox.uuid();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _uuid);
		UnreifiedRelationship _subProperty = this.getSubProperty();
		String _uuid_1 = null;
		if (_subProperty!=null) {
			_uuid_1=_subProperty.uuid();
		}
		String _string = null;
		if (_uuid_1!=null) {
			_string=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("subProperty", _string);
		UnreifiedRelationship _superProperty = this.getSuperProperty();
		String _uuid_2 = null;
		if (_superProperty!=null) {
			_uuid_2=_superProperty.uuid();
		}
		String _string_1 = null;
		if (_uuid_2!=null) {
			_string_1=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("superProperty", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"SubObjectPropertyOfAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUB_PROPERTY:
				if (resolve) return getSubProperty();
				return basicGetSubProperty();
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUPER_PROPERTY:
				if (resolve) return getSuperProperty();
				return basicGetSuperProperty();
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
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUB_PROPERTY:
				setSubProperty((UnreifiedRelationship)newValue);
				return;
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUPER_PROPERTY:
				setSuperProperty((UnreifiedRelationship)newValue);
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
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUB_PROPERTY:
				setSubProperty((UnreifiedRelationship)null);
				return;
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUPER_PROPERTY:
				setSuperProperty((UnreifiedRelationship)null);
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
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUB_PROPERTY:
				return subProperty != null;
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM__SUPER_PROPERTY:
				return superProperty != null;
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
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM___UUID:
				return uuid();
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SubObjectPropertyOfAxiomImpl
