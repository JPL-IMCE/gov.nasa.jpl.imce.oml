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
package gov.nasa.jpl.imce.oml.model.descriptions;

import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DescriptionBox maps to an [OWL2-DL Ontology]
 * about [OWL2-DL NamedIndividuals] mapped from OML TerminologyInstanceAssertion(s).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getKind <em>Kind</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getDescriptionBoxRefinements <em>Description Box Refinements</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getClosedWorldDefinitions <em>Closed World Definitions</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getConceptInstances <em>Concept Instances</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstances <em>Reified Relationship Instances</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstanceDomains <em>Reified Relationship Instance Domains</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstanceRanges <em>Reified Relationship Instance Ranges</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getUnreifiedRelationshipInstanceTuples <em>Unreified Relationship Instance Tuples</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getSingletonScalarDataPropertyValues <em>Singleton Scalar Data Property Values</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getSingletonStructuredDataPropertyValues <em>Singleton Structured Data Property Values</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox()
 * @model
 * @generated
 */
public interface DescriptionBox extends Module {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind
	 * @see #setKind(DescriptionKind)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_Kind()
	 * @model unique="false" required="true"
	 * @generated
	 */
	DescriptionKind getKind();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DescriptionKind value);

	/**
	 * Returns the value of the '<em><b>Description Box Refinements</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefiningDescriptionBox <em>Refining Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Box Refinements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Box Refinements</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_DescriptionBoxRefinements()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefiningDescriptionBox
	 * @model opposite="refiningDescriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<DescriptionBoxRefinement> getDescriptionBoxRefinements();

	/**
	 * Returns the value of the '<em><b>Closed World Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closed World Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closed World Definitions</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_ClosedWorldDefinitions()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getDescriptionBox
	 * @model opposite="descriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<DescriptionBoxExtendsClosedWorldDefinitions> getClosedWorldDefinitions();

	/**
	 * Returns the value of the '<em><b>Concept Instances</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concept Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concept Instances</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_ConceptInstances()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getDescriptionBox
	 * @model opposite="descriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<ConceptInstance> getConceptInstances();

	/**
	 * Returns the value of the '<em><b>Reified Relationship Instances</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship Instances</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_ReifiedRelationshipInstances()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#getDescriptionBox
	 * @model opposite="descriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<ReifiedRelationshipInstance> getReifiedRelationshipInstances();

	/**
	 * Returns the value of the '<em><b>Reified Relationship Instance Domains</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship Instance Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship Instance Domains</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_ReifiedRelationshipInstanceDomains()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDescriptionBox
	 * @model opposite="descriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<ReifiedRelationshipInstanceDomain> getReifiedRelationshipInstanceDomains();

	/**
	 * Returns the value of the '<em><b>Reified Relationship Instance Ranges</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship Instance Ranges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship Instance Ranges</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_ReifiedRelationshipInstanceRanges()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#getDescriptionBox
	 * @model opposite="descriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<ReifiedRelationshipInstanceRange> getReifiedRelationshipInstanceRanges();

	/**
	 * Returns the value of the '<em><b>Unreified Relationship Instance Tuples</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unreified Relationship Instance Tuples</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unreified Relationship Instance Tuples</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_UnreifiedRelationshipInstanceTuples()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getDescriptionBox
	 * @model opposite="descriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<UnreifiedRelationshipInstanceTuple> getUnreifiedRelationshipInstanceTuples();

	/**
	 * Returns the value of the '<em><b>Singleton Scalar Data Property Values</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton Scalar Data Property Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton Scalar Data Property Values</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_SingletonScalarDataPropertyValues()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getDescriptionBox
	 * @model opposite="descriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<SingletonInstanceScalarDataPropertyValue> getSingletonScalarDataPropertyValues();

	/**
	 * Returns the value of the '<em><b>Singleton Structured Data Property Values</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton Structured Data Property Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton Structured Data Property Values</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBox_SingletonStructuredDataPropertyValues()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#getDescriptionBox
	 * @model opposite="descriptionBox" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<SingletonInstanceStructuredDataPropertyValue> getSingletonStructuredDataPropertyValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.BasicEList%><<%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%>> _xblockexpression = null;\n{\n\tfinal <%org.eclipse.emf.common.util.BasicEList%><<%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%>> me = new <%org.eclipse.emf.common.util.BasicEList%><<%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%>>();\n\tme.addAll(this.getDescriptionBoxRefinements());\n\tme.addAll(this.getClosedWorldDefinitions());\n\t_xblockexpression = me;\n}\nreturn _xblockexpression;'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='descriptionBoxRefinements ++ closedWorldDefinitions'"
	 * @generated
	 */
	EList<ModuleEdge> moduleEdges();

} // DescriptionBox
