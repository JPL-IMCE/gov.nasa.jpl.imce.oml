/**
 */
package gov.nasa.jpl.imce.oml.oti.provenance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.oti.provenance.ProvenancePackage
 * @generated
 */
public interface ProvenanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProvenanceFactory eINSTANCE = gov.nasa.jpl.imce.oml.oti.provenance.impl.ProvenanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>OML2OTI Provenance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML2OTI Provenance</em>'.
	 * @generated
	 */
	OML2OTIProvenance createOML2OTIProvenance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProvenancePackage getProvenancePackage();

} //ProvenanceFactory
