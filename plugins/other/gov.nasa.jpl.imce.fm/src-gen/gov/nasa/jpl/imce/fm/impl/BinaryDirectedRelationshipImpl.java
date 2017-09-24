/**
 */
package gov.nasa.jpl.imce.fm.impl;

import gov.nasa.jpl.imce.fm.BinaryDirectedRelationship;
import gov.nasa.jpl.imce.fm.FmPackage;
import gov.nasa.jpl.imce.fm.Metaclass;
import gov.nasa.jpl.imce.fm.Type;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Directed Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class BinaryDirectedRelationshipImpl extends MinimalEObjectImpl.Container implements BinaryDirectedRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryDirectedRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmPackage.Literals.BINARY_DIRECTED_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metaclass domain() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type range() {
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
			case FmPackage.BINARY_DIRECTED_RELATIONSHIP___DOMAIN:
				return domain();
			case FmPackage.BINARY_DIRECTED_RELATIONSHIP___RANGE:
				return range();
		}
		return super.eInvoke(operationID, arguments);
	}

} //BinaryDirectedRelationshipImpl
