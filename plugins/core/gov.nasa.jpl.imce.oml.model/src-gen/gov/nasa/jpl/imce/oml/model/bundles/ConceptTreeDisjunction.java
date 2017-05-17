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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept Tree Disjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ConceptTreeDisjunction represents the root & non-leaf nodes of a concept taxonomy:
 * - Root node is a RootConceptTaxonomyAxiom.
 * - Non-leaf nodes are AnonymousConceptTaxonomyAxioms.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#getDisjunctions <em>Disjunctions</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getConceptTreeDisjunction()
 * @model abstract="true"
 * @generated
 */
public interface ConceptTreeDisjunction extends Element {
	/**
	 * Returns the value of the '<em><b>Disjunctions</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#getDisjointTaxonomyParent <em>Disjoint Taxonomy Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disjunctions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disjunctions</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getConceptTreeDisjunction_Disjunctions()
	 * @see gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#getDisjointTaxonomyParent
	 * @model opposite="disjointTaxonomyParent" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<DisjointUnionOfConceptsAxiom> getDisjunctions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	Bundle bundleContainer();

} // ConceptTreeDisjunction
