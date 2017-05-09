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
package gov.nasa.jpl.imce.oml.model.runtime.impl;

import gov.nasa.jpl.imce.oml.model.runtime.OMLEntity;
import gov.nasa.jpl.imce.oml.model.runtime.OMLEntityRelationship;
import gov.nasa.jpl.imce.oml.model.runtime.OMLRelationshipToEntity;
import gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OML Entity Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.runtime.impl.OMLEntityRelationshipImpl#getOmlTarget <em>Oml Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OMLEntityRelationshipImpl extends OMLRelationshipFromEntityImpl implements OMLEntityRelationship {
	/**
	 * The cached value of the '{@link #getOmlTarget() <em>Oml Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlTarget()
	 * @generated
	 * @ordered
	 */
	protected OMLEntity omlTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLEntityRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePackage.Literals.OML_ENTITY_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLEntity getOmlTarget() {
		if (omlTarget != null && ((EObject)omlTarget).eIsProxy()) {
			InternalEObject oldOmlTarget = (InternalEObject)omlTarget;
			omlTarget = (OMLEntity)eResolveProxy(oldOmlTarget);
			if (omlTarget != oldOmlTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePackage.OML_ENTITY_RELATIONSHIP__OML_TARGET, oldOmlTarget, omlTarget));
			}
		}
		return omlTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLEntity basicGetOmlTarget() {
		return omlTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmlTarget(OMLEntity newOmlTarget) {
		OMLEntity oldOmlTarget = omlTarget;
		omlTarget = newOmlTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.OML_ENTITY_RELATIONSHIP__OML_TARGET, oldOmlTarget, omlTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimePackage.OML_ENTITY_RELATIONSHIP__OML_TARGET:
				if (resolve) return getOmlTarget();
				return basicGetOmlTarget();
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
			case RuntimePackage.OML_ENTITY_RELATIONSHIP__OML_TARGET:
				setOmlTarget((OMLEntity)newValue);
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
			case RuntimePackage.OML_ENTITY_RELATIONSHIP__OML_TARGET:
				setOmlTarget((OMLEntity)null);
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
			case RuntimePackage.OML_ENTITY_RELATIONSHIP__OML_TARGET:
				return omlTarget != null;
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
		if (baseClass == OMLRelationshipToEntity.class) {
			switch (derivedFeatureID) {
				case RuntimePackage.OML_ENTITY_RELATIONSHIP__OML_TARGET: return RuntimePackage.OML_RELATIONSHIP_TO_ENTITY__OML_TARGET;
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
		if (baseClass == OMLRelationshipToEntity.class) {
			switch (baseFeatureID) {
				case RuntimePackage.OML_RELATIONSHIP_TO_ENTITY__OML_TARGET: return RuntimePackage.OML_ENTITY_RELATIONSHIP__OML_TARGET;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //OMLEntityRelationshipImpl
