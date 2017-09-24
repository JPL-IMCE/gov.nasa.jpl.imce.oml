/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reified Relationship Specialization Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipSpecializationAxiomImpl#getSubRelationship <em>Sub Relationship</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipSpecializationAxiomImpl#getSuperRelationship <em>Super Relationship</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReifiedRelationshipSpecializationAxiomImpl extends SpecializationAxiomImpl implements ReifiedRelationshipSpecializationAxiom {
	/**
	 * The cached value of the '{@link #getSubRelationship() <em>Sub Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubRelationship()
	 * @generated
	 * @ordered
	 */
	protected ReifiedRelationship subRelationship;

	/**
	 * The cached value of the '{@link #getSuperRelationship() <em>Super Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperRelationship()
	 * @generated
	 * @ordered
	 */
	protected ReifiedRelationship superRelationship;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipSpecializationAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getSubRelationship() {
		if (subRelationship != null && subRelationship.eIsProxy()) {
			InternalEObject oldSubRelationship = (InternalEObject)subRelationship;
			subRelationship = (ReifiedRelationship)eResolveProxy(oldSubRelationship);
			if (subRelationship != oldSubRelationship) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP, oldSubRelationship, subRelationship));
			}
		}
		return subRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetSubRelationship() {
		return subRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubRelationship(ReifiedRelationship newSubRelationship) {
		ReifiedRelationship oldSubRelationship = subRelationship;
		subRelationship = newSubRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP, oldSubRelationship, subRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship getSuperRelationship() {
		if (superRelationship != null && superRelationship.eIsProxy()) {
			InternalEObject oldSuperRelationship = (InternalEObject)superRelationship;
			superRelationship = (ReifiedRelationship)eResolveProxy(oldSuperRelationship);
			if (superRelationship != oldSuperRelationship) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP, oldSuperRelationship, superRelationship));
			}
		}
		return superRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationship basicGetSuperRelationship() {
		return superRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperRelationship(ReifiedRelationship newSuperRelationship) {
		ReifiedRelationship oldSuperRelationship = superRelationship;
		superRelationship = newSuperRelationship;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP, oldSuperRelationship, superRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity child() {
		return this.getSubRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity parent() {
		return this.getSuperRelationship();
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
		ReifiedRelationship _superRelationship = this.getSuperRelationship();
		String _uuid_1 = null;
		if (_superRelationship!=null) {
			_uuid_1=_superRelationship.uuid();
		}
		String _string = null;
		if (_uuid_1!=null) {
			_string=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("superRelationship", _string);
		ReifiedRelationship _subRelationship = this.getSubRelationship();
		String _uuid_2 = null;
		if (_subRelationship!=null) {
			_uuid_2=_subRelationship.uuid();
		}
		String _string_1 = null;
		if (_uuid_2!=null) {
			_string_1=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("subRelationship", _string_1);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"ReifiedRelationshipSpecializationAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP:
				if (resolve) return getSubRelationship();
				return basicGetSubRelationship();
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP:
				if (resolve) return getSuperRelationship();
				return basicGetSuperRelationship();
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP:
				setSubRelationship((ReifiedRelationship)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP:
				setSuperRelationship((ReifiedRelationship)newValue);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP:
				setSubRelationship((ReifiedRelationship)null);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP:
				setSuperRelationship((ReifiedRelationship)null);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP:
				return subRelationship != null;
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP:
				return superRelationship != null;
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___CHILD:
				return child();
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___PARENT:
				return parent();
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ReifiedRelationshipSpecializationAxiomImpl
