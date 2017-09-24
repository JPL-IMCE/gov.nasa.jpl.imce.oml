/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Resource;

import gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl;

import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipRange;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Relationship Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DataRelationshipRangeImpl extends ModuleElementImpl implements DataRelationshipRange {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataRelationshipRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.DATA_RELATIONSHIP_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String iri() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String name() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String abbrevIRI() {
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Resource.class) {
			switch (baseOperationID) {
				case CommonPackage.RESOURCE___IRI: return TerminologiesPackage.DATA_RELATIONSHIP_RANGE___IRI;
				case CommonPackage.RESOURCE___NAME: return TerminologiesPackage.DATA_RELATIONSHIP_RANGE___NAME;
				case CommonPackage.RESOURCE___ABBREV_IRI: return TerminologiesPackage.DATA_RELATIONSHIP_RANGE___ABBREV_IRI;
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
			case TerminologiesPackage.DATA_RELATIONSHIP_RANGE___IRI:
				return iri();
			case TerminologiesPackage.DATA_RELATIONSHIP_RANGE___NAME:
				return name();
			case TerminologiesPackage.DATA_RELATIONSHIP_RANGE___ABBREV_IRI:
				return abbrevIRI();
		}
		return super.eInvoke(operationID, arguments);
	}

} //DataRelationshipRangeImpl
