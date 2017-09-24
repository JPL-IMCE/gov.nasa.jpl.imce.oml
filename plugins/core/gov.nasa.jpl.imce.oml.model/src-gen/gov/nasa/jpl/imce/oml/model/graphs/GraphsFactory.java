/**
 */
package gov.nasa.jpl.imce.oml.model.graphs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage
 * @generated
 */
public interface GraphsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphsFactory eINSTANCE = gov.nasa.jpl.imce.oml.model.graphs.impl.GraphsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Terminology Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminology Graph</em>'.
	 * @generated
	 */
	TerminologyGraph createTerminologyGraph();

	/**
	 * Returns a new object of class '<em>Concept Designation Terminology Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept Designation Terminology Axiom</em>'.
	 * @generated
	 */
	ConceptDesignationTerminologyAxiom createConceptDesignationTerminologyAxiom();

	/**
	 * Returns a new object of class '<em>Terminology Nesting Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminology Nesting Axiom</em>'.
	 * @generated
	 */
	TerminologyNestingAxiom createTerminologyNestingAxiom();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphsPackage getGraphsPackage();

} //GraphsFactory
