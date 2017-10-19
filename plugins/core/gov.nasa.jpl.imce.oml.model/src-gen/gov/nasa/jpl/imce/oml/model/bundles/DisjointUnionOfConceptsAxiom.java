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

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Module;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Disjoint Union Of Concepts Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DisjointUnionOfConceptsAxiom(s) specifies the logical union of non-leaf & leaf nodes in a concept taxonomy tree:
 * - Each non-leaf node is an OML AnonymousConceptUnionAxiom.
 * - Each leaf nodes is an OML SpecificDisjointConceptAxiom.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#getDisjointTaxonomyParent <em>Disjoint Taxonomy Parent</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getDisjointUnionOfConceptsAxiom()
 * @model abstract="true"
 * @generated
 */
public interface DisjointUnionOfConceptsAxiom extends Element {
	/**
	 * Returns the value of the '<em><b>Disjoint Taxonomy Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#getDisjunctions <em>Disjunctions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parent of this node in a disjoint concept taxonomy tree.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Disjoint Taxonomy Parent</em>' container reference.
	 * @see #setDisjointTaxonomyParent(ConceptTreeDisjunction)
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent()
	 * @see gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#getDisjunctions
	 * @model opposite="disjunctions" required="true" transient="false"
	 * @generated
	 */
	ConceptTreeDisjunction getDisjointTaxonomyParent();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#getDisjointTaxonomyParent <em>Disjoint Taxonomy Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disjoint Taxonomy Parent</em>' container reference.
	 * @see #getDisjointTaxonomyParent()
	 * @generated
	 */
	void setDisjointTaxonomyParent(ConceptTreeDisjunction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.conceptTreeDisjunctionOfDisjointUnionOfConceptsAxiom.get(this)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getDisjointTaxonomyParent();'"
	 * @generated
	 */
	ConceptTreeDisjunction conceptTreeDisjunctionParent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='conceptTreeDisjunctionParent().flatMap(_.bundleContainer())'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction%&gt; _disjointTaxonomyParent = this.getDisjointTaxonomyParent();\n&lt;%gov.nasa.jpl.imce.oml.model.bundles.Bundle%&gt; _bundleContainer = null;\nif (_disjointTaxonomyParent!=null)\n{\n\t_bundleContainer=_disjointTaxonomyParent.bundleContainer();\n}\nreturn _bundleContainer;'"
	 * @generated
	 */
	Module moduleContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<Element> allNestedUnions();

} // DisjointUnionOfConceptsAxiom
