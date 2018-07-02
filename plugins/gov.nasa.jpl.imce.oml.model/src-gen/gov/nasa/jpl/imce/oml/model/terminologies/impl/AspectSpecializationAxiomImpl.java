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

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.AspectKind;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect Specialization Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectSpecializationAxiomImpl#getSubEntity <em>Sub Entity</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectSpecializationAxiomImpl#getSuperAspect <em>Super Aspect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AspectSpecializationAxiomImpl extends SpecializationAxiomImpl implements AspectSpecializationAxiom {
	/**
	 * The cached value of the '{@link #getSubEntity() <em>Sub Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubEntity()
	 * @generated
	 * @ordered
	 */
	protected Entity subEntity;

	/**
	 * The cached value of the '{@link #getSuperAspect() <em>Super Aspect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperAspect()
	 * @generated
	 * @ordered
	 */
	protected AspectKind superAspect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AspectSpecializationAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ASPECT_SPECIALIZATION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getSubEntity() {
		if (subEntity != null && subEntity.eIsProxy()) {
			InternalEObject oldSubEntity = (InternalEObject)subEntity;
			subEntity = (Entity)eResolveProxy(oldSubEntity);
			if (subEntity != oldSubEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY, oldSubEntity, subEntity));
			}
		}
		return subEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetSubEntity() {
		return subEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubEntity(Entity newSubEntity) {
		Entity oldSubEntity = subEntity;
		subEntity = newSubEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY, oldSubEntity, subEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AspectKind getSuperAspect() {
		if (superAspect != null && superAspect.eIsProxy()) {
			InternalEObject oldSuperAspect = (InternalEObject)superAspect;
			superAspect = (AspectKind)eResolveProxy(oldSuperAspect);
			if (superAspect != oldSuperAspect) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT, oldSuperAspect, superAspect));
			}
		}
		return superAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AspectKind basicGetSuperAspect() {
		return superAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperAspect(AspectKind newSuperAspect) {
		AspectKind oldSuperAspect = superAspect;
		superAspect = newSuperAspect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT, oldSuperAspect, superAspect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity child() {
		return this.getSubEntity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity parent() {
		return this.getSuperAspect();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		String _uuid = this.getTbox().uuid();
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _uuid);
		AspectKind _superAspect = this.getSuperAspect();
		String _uuid_1 = null;
		if (_superAspect!=null) {
			_uuid_1=_superAspect.uuid();
		}
		String _string = null;
		if (_uuid_1!=null) {
			_string=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("superAspect", _string);
		Entity _subEntity = this.getSubEntity();
		String _uuid_2 = null;
		if (_subEntity!=null) {
			_uuid_2=_subEntity.uuid();
		}
		String _string_1 = null;
		if (_uuid_2!=null) {
			_string_1=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("subEntity", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"AspectSpecializationAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY:
				if (resolve) return getSubEntity();
				return basicGetSubEntity();
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT:
				if (resolve) return getSuperAspect();
				return basicGetSuperAspect();
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
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY:
				setSubEntity((Entity)newValue);
				return;
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT:
				setSuperAspect((AspectKind)newValue);
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
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY:
				setSubEntity((Entity)null);
				return;
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT:
				setSuperAspect((AspectKind)null);
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
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY:
				return subEntity != null;
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT:
				return superAspect != null;
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
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM___CHILD:
				return child();
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM___PARENT:
				return parent();
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AspectSpecializationAxiomImpl
