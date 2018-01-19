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

import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forward Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ForwardPropertyImpl#getReifiedRelationship <em>Reified Relationship</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ForwardPropertyImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForwardPropertyImpl extends RestrictableRelationshipImpl implements ForwardProperty {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForwardPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.FORWARD_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getReifiedRelationship() {
		if (eContainerFeatureID() != TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP) return null;
		return (ReifiedRelationship)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetReifiedRelationship() {
		if (eContainerFeatureID() != TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP) return null;
		return (ReifiedRelationship)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReifiedRelationship(ReifiedRelationship newReifiedRelationship, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newReifiedRelationship, TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReifiedRelationship(ReifiedRelationship newReifiedRelationship) {
		if (newReifiedRelationship != eInternalContainer() || (eContainerFeatureID() != TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP && newReifiedRelationship != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newReifiedRelationship))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newReifiedRelationship != null)
				msgs = ((InternalEObject)newReifiedRelationship).eInverseAdd(this, TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY, ReifiedRelationship.class, msgs);
			msgs = basicSetReifiedRelationship(newReifiedRelationship, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP, newReifiedRelationship, newReifiedRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.FORWARD_PROPERTY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String iri() {
		ReifiedRelationship _reifiedRelationship = this.getReifiedRelationship();
		TerminologyBox _tbox = null;
		if (_reifiedRelationship!=null) {
			_tbox=_reifiedRelationship.getTbox();
		}
		String _iri = null;
		if (_tbox!=null) {
			_iri=_tbox.iri();
		}
		String _plus = (_iri + "#");
		String _name = this.name();
		return (_plus + _name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String abbrevIRI() {
		String _elvis = null;
		ReifiedRelationship _reifiedRelationship = this.getReifiedRelationship();
		TerminologyBox _tbox = null;
		if (_reifiedRelationship!=null) {
			_tbox=_reifiedRelationship.getTbox();
		}
		String _nsPrefix = null;
		if (_tbox!=null) {
			_nsPrefix=_tbox.nsPrefix();
		}
		if (_nsPrefix != null) {
			_elvis = _nsPrefix;
		} else {
			_elvis = "";
		}
		String _plus = (_elvis + ":");
		String _name = this.name();
		return (_plus + _name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String name() {
		return this.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		String _name = this.name();
		String _string = null;
		if (_name!=null) {
			_string=_name.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("name", _string);
		ReifiedRelationship _reifiedRelationship = this.getReifiedRelationship();
		String _uuid = null;
		if (_reifiedRelationship!=null) {
			_uuid=_reifiedRelationship.uuid();
		}
		String _string_1 = null;
		if (_uuid!=null) {
			_string_1=_uuid.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("reifiedRelationship", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"ForwardProperty", _mappedTo, _mappedTo_1);
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
	public EntityRelationship relation() {
		return this.getReifiedRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module moduleContext() {
		ReifiedRelationship _reifiedRelationship = this.getReifiedRelationship();
		Module _moduleContext = null;
		if (_reifiedRelationship!=null) {
			_moduleContext=_reifiedRelationship.moduleContext();
		}
		return _moduleContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetReifiedRelationship((ReifiedRelationship)otherEnd, msgs);
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
			case TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP:
				return basicSetReifiedRelationship(null, msgs);
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
			case TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP:
				return eInternalContainer().eInverseRemove(this, TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY, ReifiedRelationship.class, msgs);
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
			case TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP:
				if (resolve) return getReifiedRelationship();
				return basicGetReifiedRelationship();
			case TerminologiesPackage.FORWARD_PROPERTY__NAME:
				return getName();
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
			case TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP:
				setReifiedRelationship((ReifiedRelationship)newValue);
				return;
			case TerminologiesPackage.FORWARD_PROPERTY__NAME:
				setName((String)newValue);
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
			case TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP:
				setReifiedRelationship((ReifiedRelationship)null);
				return;
			case TerminologiesPackage.FORWARD_PROPERTY__NAME:
				setName(NAME_EDEFAULT);
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
			case TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP:
				return basicGetReifiedRelationship() != null;
			case TerminologiesPackage.FORWARD_PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
			case TerminologiesPackage.FORWARD_PROPERTY___IRI:
				return iri();
			case TerminologiesPackage.FORWARD_PROPERTY___ABBREV_IRI:
				return abbrevIRI();
			case TerminologiesPackage.FORWARD_PROPERTY___NAME:
				return name();
			case TerminologiesPackage.FORWARD_PROPERTY___UUID:
				return uuid();
			case TerminologiesPackage.FORWARD_PROPERTY___RELATION:
				return relation();
			case TerminologiesPackage.FORWARD_PROPERTY___MODULE_CONTEXT:
				return moduleContext();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ForwardPropertyImpl
