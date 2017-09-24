/**
 */
package gov.nasa.jpl.imce.oml.model.bundles;

import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminology Bundle Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML TerminologyBundleStatement is a logical axiom about an OML TerminologyThing
 * in an OML Bundle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement#getBundle <em>Bundle</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getTerminologyBundleStatement()
 * @model abstract="true"
 * @generated
 */
public interface TerminologyBundleStatement extends ModuleElement {
	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.bundles.Bundle#getBundleStatements <em>Bundle Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle</em>' container reference.
	 * @see #setBundle(Bundle)
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getTerminologyBundleStatement_Bundle()
	 * @see gov.nasa.jpl.imce.oml.model.bundles.Bundle#getBundleStatements
	 * @model opposite="bundleStatements" required="true" transient="false"
	 * @generated
	 */
	Bundle getBundle();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement#getBundle <em>Bundle</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' container reference.
	 * @see #getBundle()
	 * @generated
	 */
	void setBundle(Bundle value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.bundleOfTerminologyBundleStatement.get(this)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getBundle();'"
	 * @generated
	 */
	Module moduleContext();

} // TerminologyBundleStatement
