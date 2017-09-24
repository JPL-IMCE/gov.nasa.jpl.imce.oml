/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Directed Binary Relationship Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DirectedBinaryRelationshipKindImpl extends MinimalEObjectImpl.Container implements DirectedBinaryRelationshipKind {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectedBinaryRelationshipKindImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.DIRECTED_BINARY_RELATIONSHIP_KIND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term relationDomain() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term relationRange() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TerminologiesPackage.DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_DOMAIN:
				return relationDomain();
			case TerminologiesPackage.DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_RANGE:
				return relationRange();
		}
		return super.eInvoke(operationID, arguments);
	}

} //DirectedBinaryRelationshipKindImpl
