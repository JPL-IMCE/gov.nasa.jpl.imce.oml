/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.UUID;

import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Structured Data Property Particular Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyParticularRestrictionAxiomImpl#getStructuredDataProperty <em>Structured Data Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyParticularRestrictionAxiomImpl#getStructuredDataPropertyRestrictions <em>Structured Data Property Restrictions</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyParticularRestrictionAxiomImpl#getScalarDataPropertyRestrictions <em>Scalar Data Property Restrictions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityStructuredDataPropertyParticularRestrictionAxiomImpl extends EntityStructuredDataPropertyRestrictionAxiomImpl implements EntityStructuredDataPropertyParticularRestrictionAxiom {
	/**
	 * The cached value of the '{@link #getStructuredDataProperty() <em>Structured Data Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuredDataProperty()
	 * @generated
	 * @ordered
	 */
	protected DataRelationshipToStructure structuredDataProperty;

	/**
	 * The cached value of the '{@link #getStructuredDataPropertyRestrictions() <em>Structured Data Property Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuredDataPropertyRestrictions()
	 * @generated
	 * @ordered
	 */
	protected EList<RestrictionStructuredDataPropertyTuple> structuredDataPropertyRestrictions;

	/**
	 * The cached value of the '{@link #getScalarDataPropertyRestrictions() <em>Scalar Data Property Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalarDataPropertyRestrictions()
	 * @generated
	 * @ordered
	 */
	protected EList<RestrictionScalarDataPropertyValue> scalarDataPropertyRestrictions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityStructuredDataPropertyParticularRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRelationshipToStructure getStructuredDataProperty() {
		if (structuredDataProperty != null && structuredDataProperty.eIsProxy()) {
			InternalEObject oldStructuredDataProperty = (InternalEObject)structuredDataProperty;
			structuredDataProperty = (DataRelationshipToStructure)eResolveProxy(oldStructuredDataProperty);
			if (structuredDataProperty != oldStructuredDataProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY, oldStructuredDataProperty, structuredDataProperty));
			}
		}
		return structuredDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRelationshipToStructure basicGetStructuredDataProperty() {
		return structuredDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructuredDataProperty(DataRelationshipToStructure newStructuredDataProperty) {
		DataRelationshipToStructure oldStructuredDataProperty = structuredDataProperty;
		structuredDataProperty = newStructuredDataProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY, oldStructuredDataProperty, structuredDataProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RestrictionStructuredDataPropertyTuple> getStructuredDataPropertyRestrictions() {
		if (structuredDataPropertyRestrictions == null) {
			structuredDataPropertyRestrictions = new EObjectContainmentWithInverseEList<RestrictionStructuredDataPropertyTuple>(RestrictionStructuredDataPropertyTuple.class, this, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS, TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		}
		return structuredDataPropertyRestrictions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RestrictionScalarDataPropertyValue> getScalarDataPropertyRestrictions() {
		if (scalarDataPropertyRestrictions == null) {
			scalarDataPropertyRestrictions = new EObjectContainmentWithInverseEList<RestrictionScalarDataPropertyValue>(RestrictionScalarDataPropertyValue.class, this, TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS, TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		}
		return scalarDataPropertyRestrictions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox terminologyBox() {
		return this.getTbox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		TerminologyBox _tbox = this.getTbox();
		String _uuid = null;
		if (_tbox!=null) {
			_uuid=_tbox.uuid();
		}
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _uuid);
		Entity _restrictedEntity = this.getRestrictedEntity();
		String _uuid_1 = null;
		if (_restrictedEntity!=null) {
			_uuid_1=_restrictedEntity.uuid();
		}
		String _string = null;
		if (_uuid_1!=null) {
			_string=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("restrictedEntity", _string);
		DataRelationshipToStructure _structuredDataProperty = this.getStructuredDataProperty();
		String _uuid_2 = null;
		if (_structuredDataProperty!=null) {
			_uuid_2=_structuredDataProperty.uuid();
		}
		String _string_1 = null;
		if (_uuid_2!=null) {
			_string_1=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("structuredDataProperty", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"EntityStructuredDataPropertyParticularRestrictionAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
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
	public EList<Element> allNestedElements() {
		return this.allNestedRestrictionElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> allNestedRestrictionElements() {
		BasicEList<Element> _xblockexpression = null;
		{
			final BasicEList<Element> nres = new BasicEList<Element>();
			nres.addAll(this.getStructuredDataPropertyRestrictions());
			final Consumer<RestrictionStructuredDataPropertyTuple> _function = new Consumer<RestrictionStructuredDataPropertyTuple>() {
				public void accept(final RestrictionStructuredDataPropertyTuple it) {
					nres.addAll(it.allNestedRestrictionElements());
				}
			};
			this.getStructuredDataPropertyRestrictions().forEach(_function);
			nres.addAll(this.getScalarDataPropertyRestrictions());
			_xblockexpression = nres;
		}
		return _xblockexpression;
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStructuredDataPropertyRestrictions()).basicAdd(otherEnd, msgs);
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getScalarDataPropertyRestrictions()).basicAdd(otherEnd, msgs);
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				return ((InternalEList<?>)getStructuredDataPropertyRestrictions()).basicRemove(otherEnd, msgs);
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				return ((InternalEList<?>)getScalarDataPropertyRestrictions()).basicRemove(otherEnd, msgs);
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY:
				if (resolve) return getStructuredDataProperty();
				return basicGetStructuredDataProperty();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				return getStructuredDataPropertyRestrictions();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				return getScalarDataPropertyRestrictions();
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY:
				setStructuredDataProperty((DataRelationshipToStructure)newValue);
				return;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				getStructuredDataPropertyRestrictions().clear();
				getStructuredDataPropertyRestrictions().addAll((Collection<? extends RestrictionStructuredDataPropertyTuple>)newValue);
				return;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				getScalarDataPropertyRestrictions().clear();
				getScalarDataPropertyRestrictions().addAll((Collection<? extends RestrictionScalarDataPropertyValue>)newValue);
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY:
				setStructuredDataProperty((DataRelationshipToStructure)null);
				return;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				getStructuredDataPropertyRestrictions().clear();
				return;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				getScalarDataPropertyRestrictions().clear();
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY:
				return structuredDataProperty != null;
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS:
				return structuredDataPropertyRestrictions != null && !structuredDataPropertyRestrictions.isEmpty();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS:
				return scalarDataPropertyRestrictions != null && !scalarDataPropertyRestrictions.isEmpty();
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
		if (baseClass == RestrictionStructuredDataPropertyContext.class) {
			switch (derivedFeatureID) {
				case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY: return TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY;
				case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS: return TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS;
				case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS: return TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS;
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
		if (baseClass == RestrictionStructuredDataPropertyContext.class) {
			switch (baseFeatureID) {
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY;
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__STRUCTURED_DATA_PROPERTY_RESTRICTIONS;
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_DATA_PROPERTY_RESTRICTIONS;
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
		if (baseClass == Element.class) {
			switch (baseOperationID) {
				case CommonPackage.ELEMENT___UUID: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ModuleElement.class) {
			switch (baseOperationID) {
				case CommonPackage.MODULE_ELEMENT___ALL_NESTED_ELEMENTS: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___ALL_NESTED_ELEMENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == RestrictionStructuredDataPropertyContext.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT___TERMINOLOGY_BOX: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___TERMINOLOGY_BOX;
				case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT___ALL_NESTED_RESTRICTION_ELEMENTS: return TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___ALL_NESTED_RESTRICTION_ELEMENTS;
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
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___TERMINOLOGY_BOX:
				return terminologyBox();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID:
				return uuid();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___ALL_NESTED_ELEMENTS:
				return allNestedElements();
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___ALL_NESTED_RESTRICTION_ELEMENTS:
				return allNestedRestrictionElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityStructuredDataPropertyParticularRestrictionAxiomImpl
