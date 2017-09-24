/**
 */
package gov.nasa.jpl.imce.oml.model.bundles;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage
 * @generated
 */
public interface BundlesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BundlesFactory eINSTANCE = gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bundle</em>'.
	 * @generated
	 */
	Bundle createBundle();

	/**
	 * Returns a new object of class '<em>Specific Disjoint Concept Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific Disjoint Concept Axiom</em>'.
	 * @generated
	 */
	SpecificDisjointConceptAxiom createSpecificDisjointConceptAxiom();

	/**
	 * Returns a new object of class '<em>Anonymous Concept Union Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Anonymous Concept Union Axiom</em>'.
	 * @generated
	 */
	AnonymousConceptUnionAxiom createAnonymousConceptUnionAxiom();

	/**
	 * Returns a new object of class '<em>Root Concept Taxonomy Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Concept Taxonomy Axiom</em>'.
	 * @generated
	 */
	RootConceptTaxonomyAxiom createRootConceptTaxonomyAxiom();

	/**
	 * Returns a new object of class '<em>Bundled Terminology Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bundled Terminology Axiom</em>'.
	 * @generated
	 */
	BundledTerminologyAxiom createBundledTerminologyAxiom();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BundlesPackage getBundlesPackage();

} //BundlesFactory
