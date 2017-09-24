/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialization Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class SpecializationAxiomImpl extends TermAxiomImpl implements SpecializationAxiom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecializationAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.SPECIALIZATION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity child() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity parent() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> allNestedElements() {
		return ECollections.<Element>emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TerminologiesPackage.SPECIALIZATION_AXIOM___CHILD:
				return child();
			case TerminologiesPackage.SPECIALIZATION_AXIOM___PARENT:
				return parent();
			case TerminologiesPackage.SPECIALIZATION_AXIOM___ALL_NESTED_ELEMENTS:
				return allNestedElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SpecializationAxiomImpl
