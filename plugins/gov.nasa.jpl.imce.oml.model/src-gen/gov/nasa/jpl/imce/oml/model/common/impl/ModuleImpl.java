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
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl#getAnnotationProperties <em>Annotation Properties</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl#getExtent <em>Extent</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl#getIri <em>Iri</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ModuleImpl extends ResourceImpl implements gov.nasa.jpl.imce.oml.model.common.Module {
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
	 * The default value of the '{@link #getIri() <em>Iri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIri()
	 * @generated
	 * @ordered
	 */
	protected static final String IRI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIri() <em>Iri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIri()
	 * @generated
	 * @ordered
	 */
	protected String iri = IRI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationProperty> getAnnotationProperties() {
		if (annotationProperties == null) {
			annotationProperties = new EObjectContainmentWithInverseEList<AnnotationProperty>(AnnotationProperty.class, this, CommonPackage.MODULE__ANNOTATION_PROPERTIES, CommonPackage.ANNOTATION_PROPERTY__MODULE);
		}
		return annotationProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extent getExtent() {
		if (eContainerFeatureID() != CommonPackage.MODULE__EXTENT) return null;
		return (Extent)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extent basicGetExtent() {
		if (eContainerFeatureID() != CommonPackage.MODULE__EXTENT) return null;
		return (Extent)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtent(Extent newExtent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExtent, CommonPackage.MODULE__EXTENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtent(Extent newExtent) {
		if (newExtent != eInternalContainer() || (eContainerFeatureID() != CommonPackage.MODULE__EXTENT && newExtent != null)) {
			if (EcoreUtil.isAncestor(this, newExtent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExtent != null)
				msgs = ((InternalEObject)newExtent).eInverseAdd(this, CommonPackage.EXTENT__MODULES, Extent.class, msgs);
			msgs = basicSetExtent(newExtent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.MODULE__EXTENT, newExtent, newExtent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIri() {
		return iri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIri(String newIri) {
		String oldIri = iri;
		iri = newIri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.MODULE__IRI, oldIri, iri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleEdge> moduleEdges() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String iri() {
		return this.getIri();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String nsPrefix() {
		String _iri = this.getIri();
		String _substring = null;
		if (_iri!=null) {
			int _lastIndexOf = this.getIri().lastIndexOf("/");
			int _plus = (1 + _lastIndexOf);
			_substring=_iri.substring(_plus);
		}
		return _substring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String name() {
		return this.nsPrefix();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String abbrevIRI() {
		return this.nsPrefix();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		String _elvis = null;
		String _iri = this.iri();
		if (_iri != null) {
			_elvis = _iri;
		} else {
			_elvis = "";
		}
		UUID _namespaceUUID = OMLExtensions.namespaceUUID(_elvis);
		String _string = null;
		if (_namespaceUUID!=null) {
			_string=_namespaceUUID.toString();
		}
		return _string;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public gov.nasa.jpl.imce.oml.model.common.Module moduleContext() {
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleElement> moduleElements() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case CommonPackage.MODULE__ANNOTATION_PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotationProperties()).basicAdd(otherEnd, msgs);
			case CommonPackage.MODULE__EXTENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExtent((Extent)otherEnd, msgs);
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
			case CommonPackage.MODULE__ANNOTATION_PROPERTIES:
				return ((InternalEList<?>)getAnnotationProperties()).basicRemove(otherEnd, msgs);
			case CommonPackage.MODULE__EXTENT:
				return basicSetExtent(null, msgs);
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
			case CommonPackage.MODULE__EXTENT:
				return eInternalContainer().eInverseRemove(this, CommonPackage.EXTENT__MODULES, Extent.class, msgs);
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
			case CommonPackage.MODULE__ANNOTATION_PROPERTIES:
				return getAnnotationProperties();
			case CommonPackage.MODULE__EXTENT:
				if (resolve) return getExtent();
				return basicGetExtent();
			case CommonPackage.MODULE__IRI:
				return getIri();
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
			case CommonPackage.MODULE__ANNOTATION_PROPERTIES:
				getAnnotationProperties().clear();
				getAnnotationProperties().addAll((Collection<? extends AnnotationProperty>)newValue);
				return;
			case CommonPackage.MODULE__EXTENT:
				setExtent((Extent)newValue);
				return;
			case CommonPackage.MODULE__IRI:
				setIri((String)newValue);
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
			case CommonPackage.MODULE__ANNOTATION_PROPERTIES:
				getAnnotationProperties().clear();
				return;
			case CommonPackage.MODULE__EXTENT:
				setExtent((Extent)null);
				return;
			case CommonPackage.MODULE__IRI:
				setIri(IRI_EDEFAULT);
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
			case CommonPackage.MODULE__ANNOTATION_PROPERTIES:
				return annotationProperties != null && !annotationProperties.isEmpty();
			case CommonPackage.MODULE__EXTENT:
				return basicGetExtent() != null;
			case CommonPackage.MODULE__IRI:
				return IRI_EDEFAULT == null ? iri != null : !IRI_EDEFAULT.equals(iri);
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
			case CommonPackage.MODULE___MODULE_EDGES:
				return moduleEdges();
			case CommonPackage.MODULE___IRI:
				return iri();
			case CommonPackage.MODULE___NS_PREFIX:
				return nsPrefix();
			case CommonPackage.MODULE___NAME:
				return name();
			case CommonPackage.MODULE___ABBREV_IRI:
				return abbrevIRI();
			case CommonPackage.MODULE___UUID:
				return uuid();
			case CommonPackage.MODULE___MODULE_CONTEXT:
				return moduleContext();
			case CommonPackage.MODULE___MODULE_ELEMENTS:
				return moduleElements();
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (iri: ");
		result.append(iri);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl
