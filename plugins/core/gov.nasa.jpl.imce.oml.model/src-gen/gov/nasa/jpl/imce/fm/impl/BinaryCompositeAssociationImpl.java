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
package gov.nasa.jpl.imce.fm.impl;

import gov.nasa.jpl.imce.fm.BinaryCompositeAssociation;
import gov.nasa.jpl.imce.fm.FmPackage;
import gov.nasa.jpl.imce.fm.InformationCarryingMetaclass;
import gov.nasa.jpl.imce.fm.InformationContainerMetaclass;
import gov.nasa.jpl.imce.fm.Metaclass;
import gov.nasa.jpl.imce.fm.Type;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Composite Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.fm.impl.BinaryCompositeAssociationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.impl.BinaryCompositeAssociationImpl#getSourceRoleName <em>Source Role Name</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.impl.BinaryCompositeAssociationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.fm.impl.BinaryCompositeAssociationImpl#getTargetRoleName <em>Target Role Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryCompositeAssociationImpl extends BinaryDirectedRelationshipImpl implements BinaryCompositeAssociation {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected InformationContainerMetaclass source;

	/**
	 * The default value of the '{@link #getSourceRoleName() <em>Source Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRoleName()
	 * @generated
	 * @ordered
	 */
	protected static final gov.nasa.jpl.imce.fm.String SOURCE_ROLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceRoleName() <em>Source Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRoleName()
	 * @generated
	 * @ordered
	 */
	protected gov.nasa.jpl.imce.fm.String sourceRoleName = SOURCE_ROLE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected InformationCarryingMetaclass target;

	/**
	 * The default value of the '{@link #getTargetRoleName() <em>Target Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRoleName()
	 * @generated
	 * @ordered
	 */
	protected static final gov.nasa.jpl.imce.fm.String TARGET_ROLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetRoleName() <em>Target Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRoleName()
	 * @generated
	 * @ordered
	 */
	protected gov.nasa.jpl.imce.fm.String targetRoleName = TARGET_ROLE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryCompositeAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmPackage.Literals.BINARY_COMPOSITE_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationContainerMetaclass getSource() {
		if (source != null && ((EObject)source).eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (InformationContainerMetaclass)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationContainerMetaclass basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(InformationContainerMetaclass newSource) {
		InformationContainerMetaclass oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public gov.nasa.jpl.imce.fm.String getSourceRoleName() {
		return sourceRoleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRoleName(gov.nasa.jpl.imce.fm.String newSourceRoleName) {
		gov.nasa.jpl.imce.fm.String oldSourceRoleName = sourceRoleName;
		sourceRoleName = newSourceRoleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE_ROLE_NAME, oldSourceRoleName, sourceRoleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationCarryingMetaclass getTarget() {
		if (target != null && ((EObject)target).eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (InformationCarryingMetaclass)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationCarryingMetaclass basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(InformationCarryingMetaclass newTarget) {
		InformationCarryingMetaclass oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public gov.nasa.jpl.imce.fm.String getTargetRoleName() {
		return targetRoleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRoleName(gov.nasa.jpl.imce.fm.String newTargetRoleName) {
		gov.nasa.jpl.imce.fm.String oldTargetRoleName = targetRoleName;
		targetRoleName = newTargetRoleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET_ROLE_NAME, oldTargetRoleName, targetRoleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metaclass domain() {
		return this.getSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type range() {
		return this.getTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE_ROLE_NAME:
				return getSourceRoleName();
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET_ROLE_NAME:
				return getTargetRoleName();
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
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE:
				setSource((InformationContainerMetaclass)newValue);
				return;
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE_ROLE_NAME:
				setSourceRoleName((gov.nasa.jpl.imce.fm.String)newValue);
				return;
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET:
				setTarget((InformationCarryingMetaclass)newValue);
				return;
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET_ROLE_NAME:
				setTargetRoleName((gov.nasa.jpl.imce.fm.String)newValue);
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
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE:
				setSource((InformationContainerMetaclass)null);
				return;
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE_ROLE_NAME:
				setSourceRoleName(SOURCE_ROLE_NAME_EDEFAULT);
				return;
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET:
				setTarget((InformationCarryingMetaclass)null);
				return;
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET_ROLE_NAME:
				setTargetRoleName(TARGET_ROLE_NAME_EDEFAULT);
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
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE:
				return source != null;
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__SOURCE_ROLE_NAME:
				return SOURCE_ROLE_NAME_EDEFAULT == null ? sourceRoleName != null : !SOURCE_ROLE_NAME_EDEFAULT.equals(sourceRoleName);
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET:
				return target != null;
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION__TARGET_ROLE_NAME:
				return TARGET_ROLE_NAME_EDEFAULT == null ? targetRoleName != null : !TARGET_ROLE_NAME_EDEFAULT.equals(targetRoleName);
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
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION___DOMAIN:
				return domain();
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION___RANGE:
				return range();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (sourceRoleName: ");
		result.append(sourceRoleName);
		result.append(", targetRoleName: ");
		result.append(targetRoleName);
		result.append(')');
		return result.toString();
	}

} //BinaryCompositeAssociationImpl
