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
import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalUnreifiedRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUnreifiedRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Universal Unreified Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityUniversalUnreifiedRestrictionAxiomImpl#getRestrictedUnreifiedRelationship <em>Restricted Unreified Relationship</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityUniversalUnreifiedRestrictionAxiomImpl extends EntityExistentialRestrictionAxiomImpl implements EntityUniversalUnreifiedRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getRestrictedUnreifiedRelationship() <em>Restricted Unreified Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedUnreifiedRelationship()
	 * @generated
	 * @ordered
	 */
	protected UnreifiedRelationship restrictedUnreifiedRelationship;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityUniversalUnreifiedRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship getRestrictedUnreifiedRelationship() {
		if (restrictedUnreifiedRelationship != null && ((EObject)restrictedUnreifiedRelationship).eIsProxy()) {
			InternalEObject oldRestrictedUnreifiedRelationship = (InternalEObject)restrictedUnreifiedRelationship;
			restrictedUnreifiedRelationship = (UnreifiedRelationship)eResolveProxy(oldRestrictedUnreifiedRelationship);
			if (restrictedUnreifiedRelationship != oldRestrictedUnreifiedRelationship) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP, oldRestrictedUnreifiedRelationship, restrictedUnreifiedRelationship));
			}
		}
		return restrictedUnreifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationship basicGetRestrictedUnreifiedRelationship() {
		return restrictedUnreifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedUnreifiedRelationship(UnreifiedRelationship newRestrictedUnreifiedRelationship) {
		UnreifiedRelationship oldRestrictedUnreifiedRelationship = restrictedUnreifiedRelationship;
		restrictedUnreifiedRelationship = newRestrictedUnreifiedRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP, oldRestrictedUnreifiedRelationship, restrictedUnreifiedRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		String _uuid = this.getTbox().uuid();
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _uuid);
		Entity _restrictedDomain = this.getRestrictedDomain();
		String _uuid_1 = null;
		if (_restrictedDomain!=null) {
			_uuid_1=_restrictedDomain.uuid();
		}
		String _string = null;
		if (_uuid_1!=null) {
			_string=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("restrictedDomain", _string);
		Entity _restrictedRange = this.getRestrictedRange();
		String _uuid_2 = null;
		if (_restrictedRange!=null) {
			_uuid_2=_restrictedRange.uuid();
		}
		String _string_1 = null;
		if (_uuid_2!=null) {
			_string_1=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("restrictedRange", _string_1);
		UnreifiedRelationship _restrictedUnreifiedRelationship = this.getRestrictedUnreifiedRelationship();
		String _uuid_3 = null;
		if (_restrictedUnreifiedRelationship!=null) {
			_uuid_3=_restrictedUnreifiedRelationship.uuid();
		}
		String _string_2 = null;
		if (_uuid_3!=null) {
			_string_2=_uuid_3.toString();
		}
		Pair<String, String> _mappedTo_3 = Pair.<String, String>of("restrictedUnreifiedRelationship", _string_2);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"EntityUniversalUnreifiedRestrictionAxiom", _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3);
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
	public EntityRelationship restrictedRelation() {
		return this.getRestrictedUnreifiedRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP:
				if (resolve) return getRestrictedUnreifiedRelationship();
				return basicGetRestrictedUnreifiedRelationship();
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
			case TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP:
				setRestrictedUnreifiedRelationship((UnreifiedRelationship)newValue);
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
			case TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP:
				setRestrictedUnreifiedRelationship((UnreifiedRelationship)null);
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
			case TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP:
				return restrictedUnreifiedRelationship != null;
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
		if (baseClass == EntityUnreifiedRestrictionAxiom.class) {
			switch (derivedFeatureID) {
				case TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP: return TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP;
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
		if (baseClass == EntityUnreifiedRestrictionAxiom.class) {
			switch (baseFeatureID) {
				case TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP: return TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM__RESTRICTED_UNREIFIED_RELATIONSHIP;
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
		if (baseClass == CrossReferencabilityKind.class) {
			switch (baseOperationID) {
				case CommonPackage.CROSS_REFERENCABILITY_KIND___UUID: return TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM___UUID;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == EntityRestrictionAxiom.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM___RESTRICTED_RELATION: return TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM___RESTRICTED_RELATION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == EntityUnreifiedRestrictionAxiom.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.ENTITY_UNREIFIED_RESTRICTION_AXIOM___RESTRICTED_RELATION: return TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM___RESTRICTED_RELATION;
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
			case TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM___UUID:
				return uuid();
			case TerminologiesPackage.ENTITY_UNIVERSAL_UNREIFIED_RESTRICTION_AXIOM___RESTRICTED_RELATION:
				return restrictedRelation();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityUniversalUnreifiedRestrictionAxiomImpl
