/**
 */
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.common.Module;

import gov.nasa.jpl.imce.oml.model.common.impl.ModuleEdgeImpl;

import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description Box Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DescriptionBoxRelationshipImpl extends ModuleEdgeImpl implements DescriptionBoxRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionBoxRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DescriptionsPackage.Literals.DESCRIPTION_BOX_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox descriptionDomain() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module sourceModule() {
		return this.descriptionDomain();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DescriptionsPackage.DESCRIPTION_BOX_RELATIONSHIP___DESCRIPTION_DOMAIN:
				return descriptionDomain();
			case DescriptionsPackage.DESCRIPTION_BOX_RELATIONSHIP___SOURCE_MODULE:
				return sourceModule();
		}
		return super.eInvoke(operationID, arguments);
	}

} //DescriptionBoxRelationshipImpl
