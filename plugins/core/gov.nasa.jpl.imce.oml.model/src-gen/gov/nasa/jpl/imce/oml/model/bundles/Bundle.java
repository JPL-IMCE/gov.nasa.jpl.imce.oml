/**
 * 
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package gov.nasa.jpl.imce.oml.model.bundles;

import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML Bundle is an OML TerminologyBox that is
 * an acyclic logical aggregate of other OML TerminologyBox(es)
 * and that logically assert OML TerminologyBundleStatement(s).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.Bundle#getBundleAxioms <em>Bundle Axioms</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.Bundle#getBundleStatements <em>Bundle Statements</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getBundle()
 * @model
 * @generated
 */
public interface Bundle extends TerminologyBox {
	/**
	 * Returns the value of the '<em><b>Bundle Axioms</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The BundledTerminologyAxioms asserted in this Bundle
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bundle Axioms</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getBundle_BundleAxioms()
	 * @see gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom#getBundle
	 * @model opposite="bundle" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<TerminologyBundleAxiom> getBundleAxioms();

	/**
	 * Returns the value of the '<em><b>Bundle Statements</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TerminologyBundleStatements asserted in this Bundle
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bundle Statements</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getBundle_BundleStatements()
	 * @see gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement#getBundle
	 * @model opposite="bundle" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<TerminologyBundleStatement> getBundleStatements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%&gt;&gt; me = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%&gt;&gt;();\n\tme.addAll(this.getBoxAxioms());\n\tme.addAll(this.getBundleAxioms());\n\t_xblockexpression = me;\n}\nreturn _xblockexpression;'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.lookupBoxAxioms(this) ++ extent.lookupBundleAxioms(this)'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<ModuleEdge> moduleEdges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleElement%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleElement%&gt;&gt; mes = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleElement%&gt;&gt;();\n\tmes.addAll(this.getBoxStatements());\n\tmes.addAll(this.getBundleStatements());\n\t_xblockexpression = mes;\n}\nreturn _xblockexpression;'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.lookupBundleStatements(this) ++ extent.lookupBoxStatements(this)'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<ModuleElement> moduleElements();

} // Bundle
