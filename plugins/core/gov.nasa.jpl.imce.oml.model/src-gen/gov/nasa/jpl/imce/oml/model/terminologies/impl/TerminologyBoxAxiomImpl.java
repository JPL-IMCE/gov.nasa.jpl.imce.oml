/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Terminology Box Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxAxiomImpl#getTbox <em>Tbox</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TerminologyBoxAxiomImpl extends TerminologyAxiomImpl implements TerminologyBoxAxiom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminologyBoxAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.TERMINOLOGY_BOX_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox getTbox() {
		if (eContainerFeatureID() != TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX) return null;
		return (TerminologyBox)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox basicGetTbox() {
		if (eContainerFeatureID() != TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX) return null;
		return (TerminologyBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTbox(TerminologyBox newTbox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTbox, TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTbox(TerminologyBox newTbox) {
		if (newTbox != eInternalContainer() || (eContainerFeatureID() != TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX && newTbox != null)) {
			if (EcoreUtil.isAncestor(this, newTbox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTbox != null)
				msgs = ((InternalEObject)newTbox).eInverseAdd(this, TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS, TerminologyBox.class, msgs);
			msgs = basicSetTbox(newTbox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX, newTbox, newTbox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTbox((TerminologyBox)otherEnd, msgs);
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
			case TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX:
				return basicSetTbox(null, msgs);
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
			case TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX:
				return eInternalContainer().eInverseRemove(this, TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS, TerminologyBox.class, msgs);
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
			case TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX:
				if (resolve) return getTbox();
				return basicGetTbox();
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
			case TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX:
				setTbox((TerminologyBox)newValue);
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
			case TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX:
				setTbox((TerminologyBox)null);
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
			case TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX:
				return basicGetTbox() != null;
		}
		return super.eIsSet(featureID);
	}

} //TerminologyBoxAxiomImpl
