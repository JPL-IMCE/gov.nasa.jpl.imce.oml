/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Restriction Structured Data Property Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictionStructuredDataPropertyTupleImpl#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RestrictionStructuredDataPropertyTupleImpl extends RestrictionStructuredDataPropertyContextImpl implements RestrictionStructuredDataPropertyTuple {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RestrictionStructuredDataPropertyTupleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestrictionStructuredDataPropertyContext getStructuredDataPropertyContext() {
		if (eContainerFeatureID() != TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT) return null;
		return (RestrictionStructuredDataPropertyContext)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestrictionStructuredDataPropertyContext basicGetStructuredDataPropertyContext() {
		if (eContainerFeatureID() != TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT) return null;
		return (RestrictionStructuredDataPropertyContext)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext newStructuredDataPropertyContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStructuredDataPropertyContext, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext newStructuredDataPropertyContext) {
		if (newStructuredDataPropertyContext != eInternalContainer() || (eContainerFeatureID() != TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT && newStructuredDataPropertyContext != null)) {
			if (EcoreUtil.isAncestor(this, newStructuredDataPropertyContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newStructuredDataPropertyContext != null)
				msgs = ((InternalEObject)newStructuredDataPropertyContext).eInverseAdd(this, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS, RestrictionStructuredDataPropertyContext.class, msgs);
			msgs = basicSetStructuredDataPropertyContext(newStructuredDataPropertyContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT, newStructuredDataPropertyContext, newStructuredDataPropertyContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox terminologyBox() {
		RestrictionStructuredDataPropertyContext _structuredDataPropertyContext = this.getStructuredDataPropertyContext();
		TerminologyBox _terminologyBox = null;
		if (_structuredDataPropertyContext!=null) {
			_terminologyBox=_structuredDataPropertyContext.terminologyBox();
		}
		return _terminologyBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		RestrictionStructuredDataPropertyContext _structuredDataPropertyContext = this.getStructuredDataPropertyContext();
		String _uuid = null;
		if (_structuredDataPropertyContext!=null) {
			_uuid=_structuredDataPropertyContext.uuid();
		}
		String _string = null;
		if (_uuid!=null) {
			_string=_uuid.toString();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("structuredDataPropertyContext", _string);
		DataRelationshipToStructure _structuredDataProperty = this.getStructuredDataProperty();
		String _uuid_1 = null;
		if (_structuredDataProperty!=null) {
			_uuid_1=_structuredDataProperty.uuid();
		}
		String _string_1 = null;
		if (_uuid_1!=null) {
			_string_1=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("structuredDataProperty", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"RestrictionStructuredDataPropertyTuple", _mappedTo, _mappedTo_1);
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
	public Module moduleContext() {
		RestrictionStructuredDataPropertyContext _structuredDataPropertyContext = this.getStructuredDataPropertyContext();
		Module _moduleContext = null;
		if (_structuredDataPropertyContext!=null) {
			_moduleContext=_structuredDataPropertyContext.moduleContext();
		}
		return _moduleContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> allNestedElements() {
		return this.allNestedRestrictionElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetStructuredDataPropertyContext((RestrictionStructuredDataPropertyContext)otherEnd, msgs);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				return basicSetStructuredDataPropertyContext(null, msgs);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				return eInternalContainer().eInverseRemove(this, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS, RestrictionStructuredDataPropertyContext.class, msgs);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				if (resolve) return getStructuredDataPropertyContext();
				return basicGetStructuredDataPropertyContext();
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				setStructuredDataPropertyContext((RestrictionStructuredDataPropertyContext)newValue);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				setStructuredDataPropertyContext((RestrictionStructuredDataPropertyContext)null);
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT:
				return basicGetStructuredDataPropertyContext() != null;
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
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE___TERMINOLOGY_BOX:
				return terminologyBox();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE___UUID:
				return uuid();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE___MODULE_CONTEXT:
				return moduleContext();
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RestrictionStructuredDataPropertyTupleImpl
