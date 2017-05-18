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
package gov.nasa.jpl.imce.oml.runtime.impl;

import gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToStructure;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage;
import gov.nasa.jpl.imce.oml.runtime.OMLStructure;
import gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToStructure;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OML Structure Data Property To Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToStructureImpl#getOmlTarget <em>Oml Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OMLStructureDataPropertyToStructureImpl extends OMLRelationshipFromStructureImpl implements OMLStructureDataPropertyToStructure {
	/**
	 * The cached value of the '{@link #getOmlTarget() <em>Oml Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOmlTarget()
	 * @generated
	 * @ordered
	 */
	protected OMLStructure omlTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLStructureDataPropertyToStructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMLRuntimePackage.Literals.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLStructure getOmlTarget() {
		if (omlTarget != null && ((EObject)omlTarget).eIsProxy()) {
			InternalEObject oldOmlTarget = (InternalEObject)omlTarget;
			omlTarget = (OMLStructure)eResolveProxy(oldOmlTarget);
			if (omlTarget != oldOmlTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OMLRuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET, oldOmlTarget, omlTarget));
			}
		}
		return omlTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLStructure basicGetOmlTarget() {
		return omlTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmlTarget(OMLStructure newOmlTarget) {
		OMLStructure oldOmlTarget = omlTarget;
		omlTarget = newOmlTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OMLRuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET, oldOmlTarget, omlTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OMLRuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET:
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
			case OMLRuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET:
				setOmlTarget((OMLStructure)newValue);
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
			case OMLRuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET:
				setOmlTarget((OMLStructure)null);
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
			case OMLRuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET:
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
		if (baseClass == OMLRelationshipToStructure.class) {
			switch (derivedFeatureID) {
				case OMLRuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET: return OMLRuntimePackage.OML_RELATIONSHIP_TO_STRUCTURE__OML_TARGET;
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
		if (baseClass == OMLRelationshipToStructure.class) {
			switch (baseFeatureID) {
				case OMLRuntimePackage.OML_RELATIONSHIP_TO_STRUCTURE__OML_TARGET: return OMLRuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //OMLStructureDataPropertyToStructureImpl
