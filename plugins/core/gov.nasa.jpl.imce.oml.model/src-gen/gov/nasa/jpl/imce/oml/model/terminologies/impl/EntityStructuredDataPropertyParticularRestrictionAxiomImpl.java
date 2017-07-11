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

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Structured Data Property Particular Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyParticularRestrictionAxiomImpl#getStructuredDataProperty <em>Structured Data Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyParticularRestrictionAxiomImpl#getStructuredPropertyTuples <em>Structured Property Tuples</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyParticularRestrictionAxiomImpl#getScalarDataPropertyValues <em>Scalar Data Property Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityStructuredDataPropertyParticularRestrictionAxiomImpl extends EntityStructuredDataPropertyRestrictionAxiomImpl implements EntityStructuredDataPropertyParticularRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getStructuredDataProperty() <em>Structured Data Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuredDataProperty()
	 * @generated
	 * @ordered
	 */
	protected DataRelationshipToStructure structuredDataProperty;

	/**
	 * The cached value of the '{@link #getStructuredPropertyTuples() <em>Structured Property Tuples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuredPropertyTuples()
	 * @generated
	 * @ordered
	 */
	protected EList<RestrictionStructuredDataPropertyTuple> structuredPropertyTuples;

	/**
	 * The cached value of the '{@link #getScalarDataPropertyValues() <em>Scalar Data Property Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalarDataPropertyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<RestrictionScalarDataPropertyValue> scalarDataPropertyValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityStructuredDataPropertyParticularRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRelationshipToStructure getStructuredDataProperty() {
		if (structuredDataProperty != null && ((EObject)structuredDataProperty).eIsProxy()) {
			InternalEObject oldStructuredDataProperty = (InternalEObject)structuredDataProperty;
			structuredDataProperty = (DataRelationshipToStructure)eResolveProxy(oldStructuredDataProperty);
			if (structuredDataProperty != oldStructuredDataProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY, oldStructuredDataProperty, structuredDataProperty));
			}
		}
		return structuredDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRelationshipToStructure basicGetStructuredDataProperty() {
		return structuredDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructuredDataProperty(DataRelationshipToStructure newStructuredDataProperty) {
		DataRelationshipToStructure oldStructuredDataProperty = structuredDataProperty;
		structuredDataProperty = newStructuredDataProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY, oldStructuredDataProperty, structuredDataProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RestrictionStructuredDataPropertyTuple> getStructuredPropertyTuples() {
		if (structuredPropertyTuples == null) {
			structuredPropertyTuples = new EObjectContainmentWithInverseEList<RestrictionStructuredDataPropertyTuple>(RestrictionStructuredDataPropertyTuple.class, this, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		}
		return structuredPropertyTuples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RestrictionScalarDataPropertyValue> getScalarDataPropertyValues() {
		if (scalarDataPropertyValues == null) {
			scalarDataPropertyValues = new EObjectContainmentWithInverseEList<RestrictionScalarDataPropertyValue>(RestrictionScalarDataPropertyValue.class, this, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		}
		return scalarDataPropertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox terminologyBox() {
		return this.getTbox();
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
		Entity _restrictedEntity = this.getRestrictedEntity();
		String _uuid_1 = null;
		if (_restrictedEntity!=null) {
			_uuid_1=_restrictedEntity.uuid();
		}
		String _string = null;
		if (_uuid_1!=null) {
			_string=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("restrictedEntity", _string);
		DataRelationshipToStructure _structuredDataProperty = this.getStructuredDataProperty();
		String _uuid_2 = null;
		if (_structuredDataProperty!=null) {
			_uuid_2=_structuredDataProperty.uuid();
		}
		String _string_1 = null;
		if (_uuid_2!=null) {
			_string_1=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("structuredDataProperty", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"EntityStructuredDataPropertyParticularRestrictionAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStructuredPropertyTuples()).basicAdd(otherEnd, msgs);
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getScalarDataPropertyValues()).basicAdd(otherEnd, msgs);
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES:
				return ((InternalEList<?>)getStructuredPropertyTuples()).basicRemove(otherEnd, msgs);
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES:
				return ((InternalEList<?>)getScalarDataPropertyValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY:
				if (resolve) return getStructuredDataProperty();
				return basicGetStructuredDataProperty();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES:
				return getStructuredPropertyTuples();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES:
				return getScalarDataPropertyValues();
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY:
				setStructuredDataProperty((DataRelationshipToStructure)newValue);
				return;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES:
				getStructuredPropertyTuples().clear();
				getStructuredPropertyTuples().addAll((Collection<? extends RestrictionStructuredDataPropertyTuple>)newValue);
				return;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES:
				getScalarDataPropertyValues().clear();
				getScalarDataPropertyValues().addAll((Collection<? extends RestrictionScalarDataPropertyValue>)newValue);
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY:
				setStructuredDataProperty((DataRelationshipToStructure)null);
				return;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES:
				getStructuredPropertyTuples().clear();
				return;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES:
				getScalarDataPropertyValues().clear();
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY:
				return structuredDataProperty != null;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES:
				return structuredPropertyTuples != null && !structuredPropertyTuples.isEmpty();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES:
				return scalarDataPropertyValues != null && !scalarDataPropertyValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == RestrictionStructuredDataPropertyContext.class) {
			switch (derivedFeatureID) {
				case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY: return TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY;
				case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES: return TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES;
				case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES: return TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == RestrictionStructuredDataPropertyContext.class) {
			switch (baseFeatureID) {
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY;
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_PROPERTY_TUPLES;
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_VALUES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
				case CommonPackage.ELEMENT___UUID: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == RestrictionStructuredDataPropertyContext.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT___TERMINOLOGY_BOX: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___TERMINOLOGY_BOX;
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___TERMINOLOGY_BOX:
				return terminologyBox();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityStructuredDataPropertyParticularRestrictionAxiomImpl
