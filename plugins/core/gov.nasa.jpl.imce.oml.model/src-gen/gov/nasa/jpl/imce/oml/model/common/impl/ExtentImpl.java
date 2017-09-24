/**
 */
package gov.nasa.jpl.imce.oml.model.common.impl;

import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.Module;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.ExtentImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.ExtentImpl#getAnnotationProperties <em>Annotation Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtentImpl extends MinimalEObjectImpl.Container implements Extent {
	/**
	 * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModules()
	 * @generated
	 * @ordered
	 */
	protected EList<Module> modules;

	/**
	 * The cached value of the '{@link #getAnnotationProperties() <em>Annotation Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationProperty> annotationProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.EXTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Module> getModules() {
		if (modules == null) {
			modules = new EObjectContainmentWithInverseEList<Module>(Module.class, this, CommonPackage.EXTENT__MODULES, CommonPackage.MODULE__EXTENT);
		}
		return modules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationProperty> getAnnotationProperties() {
		if (annotationProperties == null) {
			annotationProperties = new EObjectContainmentWithInverseEList<AnnotationProperty>(AnnotationProperty.class, this, CommonPackage.EXTENT__ANNOTATION_PROPERTIES, CommonPackage.ANNOTATION_PROPERTY__EXTENT);
		}
		return annotationProperties;
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
			case CommonPackage.EXTENT__MODULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModules()).basicAdd(otherEnd, msgs);
			case CommonPackage.EXTENT__ANNOTATION_PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotationProperties()).basicAdd(otherEnd, msgs);
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
			case CommonPackage.EXTENT__MODULES:
				return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
			case CommonPackage.EXTENT__ANNOTATION_PROPERTIES:
				return ((InternalEList<?>)getAnnotationProperties()).basicRemove(otherEnd, msgs);
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
			case CommonPackage.EXTENT__MODULES:
				return getModules();
			case CommonPackage.EXTENT__ANNOTATION_PROPERTIES:
				return getAnnotationProperties();
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
			case CommonPackage.EXTENT__MODULES:
				getModules().clear();
				getModules().addAll((Collection<? extends Module>)newValue);
				return;
			case CommonPackage.EXTENT__ANNOTATION_PROPERTIES:
				getAnnotationProperties().clear();
				getAnnotationProperties().addAll((Collection<? extends AnnotationProperty>)newValue);
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
			case CommonPackage.EXTENT__MODULES:
				getModules().clear();
				return;
			case CommonPackage.EXTENT__ANNOTATION_PROPERTIES:
				getAnnotationProperties().clear();
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
			case CommonPackage.EXTENT__MODULES:
				return modules != null && !modules.isEmpty();
			case CommonPackage.EXTENT__ANNOTATION_PROPERTIES:
				return annotationProperties != null && !annotationProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExtentImpl
