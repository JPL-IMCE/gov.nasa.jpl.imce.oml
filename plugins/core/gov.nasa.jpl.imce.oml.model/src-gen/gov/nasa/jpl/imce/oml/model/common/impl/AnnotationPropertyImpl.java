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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl#getExtent <em>Extent</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl#getIri <em>Iri</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl#getAbbrevIRI <em>Abbrev IRI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationPropertyImpl extends CDOObjectImpl implements AnnotationProperty {
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
	 * The default value of the '{@link #getAbbrevIRI() <em>Abbrev IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbbrevIRI()
	 * @generated
	 * @ordered
	 */
	protected static final String ABBREV_IRI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAbbrevIRI() <em>Abbrev IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbbrevIRI()
	 * @generated
	 * @ordered
	 */
	protected String abbrevIRI = ABBREV_IRI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.ANNOTATION_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extent getExtent() {
		if (eContainerFeatureID() != CommonPackage.ANNOTATION_PROPERTY__EXTENT) return null;
		return (Extent)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extent basicGetExtent() {
		if (eContainerFeatureID() != CommonPackage.ANNOTATION_PROPERTY__EXTENT) return null;
		return (Extent)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtent(Extent newExtent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExtent, CommonPackage.ANNOTATION_PROPERTY__EXTENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtent(Extent newExtent) {
		if (newExtent != eInternalContainer() || (eContainerFeatureID() != CommonPackage.ANNOTATION_PROPERTY__EXTENT && newExtent != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newExtent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExtent != null)
				msgs = ((InternalEObject)newExtent).eInverseAdd(this, CommonPackage.EXTENT__ANNOTATION_PROPERTIES, Extent.class, msgs);
			msgs = basicSetExtent(newExtent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ANNOTATION_PROPERTY__EXTENT, newExtent, newExtent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUuid() {
		UUID _namespaceUUID = OMLExtensions.namespaceUUID(this.getIri());
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ANNOTATION_PROPERTY__IRI, oldIri, iri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbbrevIRI() {
		return abbrevIRI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbbrevIRI(String newAbbrevIRI) {
		String oldAbbrevIRI = abbrevIRI;
		abbrevIRI = newAbbrevIRI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.ANNOTATION_PROPERTY__ABBREV_IRI, oldAbbrevIRI, abbrevIRI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonPackage.ANNOTATION_PROPERTY__EXTENT:
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
			case CommonPackage.ANNOTATION_PROPERTY__EXTENT:
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
			case CommonPackage.ANNOTATION_PROPERTY__EXTENT:
				return eInternalContainer().eInverseRemove(this, CommonPackage.EXTENT__ANNOTATION_PROPERTIES, Extent.class, msgs);
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
			case CommonPackage.ANNOTATION_PROPERTY__EXTENT:
				if (resolve) return getExtent();
				return basicGetExtent();
			case CommonPackage.ANNOTATION_PROPERTY__UUID:
				return getUuid();
			case CommonPackage.ANNOTATION_PROPERTY__IRI:
				return getIri();
			case CommonPackage.ANNOTATION_PROPERTY__ABBREV_IRI:
				return getAbbrevIRI();
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
			case CommonPackage.ANNOTATION_PROPERTY__EXTENT:
				setExtent((Extent)newValue);
				return;
			case CommonPackage.ANNOTATION_PROPERTY__IRI:
				setIri((String)newValue);
				return;
			case CommonPackage.ANNOTATION_PROPERTY__ABBREV_IRI:
				setAbbrevIRI((String)newValue);
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
			case CommonPackage.ANNOTATION_PROPERTY__EXTENT:
				setExtent((Extent)null);
				return;
			case CommonPackage.ANNOTATION_PROPERTY__IRI:
				setIri(IRI_EDEFAULT);
				return;
			case CommonPackage.ANNOTATION_PROPERTY__ABBREV_IRI:
				setAbbrevIRI(ABBREV_IRI_EDEFAULT);
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
			case CommonPackage.ANNOTATION_PROPERTY__EXTENT:
				return basicGetExtent() != null;
			case CommonPackage.ANNOTATION_PROPERTY__UUID:
				return UUID_EDEFAULT == null ? getUuid() != null : !UUID_EDEFAULT.equals(getUuid());
			case CommonPackage.ANNOTATION_PROPERTY__IRI:
				return IRI_EDEFAULT == null ? iri != null : !IRI_EDEFAULT.equals(iri);
			case CommonPackage.ANNOTATION_PROPERTY__ABBREV_IRI:
				return ABBREV_IRI_EDEFAULT == null ? abbrevIRI != null : !ABBREV_IRI_EDEFAULT.equals(abbrevIRI);
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
		result.append(" (iri: ");
		result.append(iri);
		result.append(", abbrevIRI: ");
		result.append(abbrevIRI);
		result.append(')');
		return result.toString();
	}

} //AnnotationPropertyImpl
