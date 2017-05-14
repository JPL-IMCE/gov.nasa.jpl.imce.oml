/**
 * 
 * Copyright 2016 California Institute of Technology ("Caltech").
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
package gov.nasa.jpl.imce.oml.model.graphs;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel copyrightText='\nCopyright 2016 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n' bundleManifest='false' childCreationExtenders='true' complianceLevel='8.0' featureDelegation='None' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' modelDirectory='gov.nasa.jpl.imce.oml.model/src-gen/' modelName='OMLG' basePackage='gov.nasa.jpl.imce.oml.model'"
 * @generated
 */
public interface GraphsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://imce.jpl.nasa.gov/oml/graphs";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "omlg";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphsPackage eINSTANCE = gov.nasa.jpl.imce.oml.model.graphs.impl.GraphsPackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyGraphImpl <em>Terminology Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyGraphImpl
	 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.GraphsPackageImpl#getTerminologyGraph()
	 * @generated
	 */
	int TERMINOLOGY_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH__UUID = TerminologiesPackage.TERMINOLOGY_BOX__UUID;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH__EXTENT = TerminologiesPackage.TERMINOLOGY_BOX__EXTENT;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH__IRI = TerminologiesPackage.TERMINOLOGY_BOX__IRI;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH__ANNOTATIONS = TerminologiesPackage.TERMINOLOGY_BOX__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH__KIND = TerminologiesPackage.TERMINOLOGY_BOX__KIND;

	/**
	 * The feature id for the '<em><b>Box Axioms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH__BOX_AXIOMS = TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS;

	/**
	 * The feature id for the '<em><b>Box Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH__BOX_STATEMENTS = TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS;

	/**
	 * The number of structural features of the '<em>Terminology Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH_FEATURE_COUNT = TerminologiesPackage.TERMINOLOGY_BOX_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH___IRI = TerminologiesPackage.TERMINOLOGY_BOX___IRI;

	/**
	 * The operation id for the '<em>Ns Prefix</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH___NS_PREFIX = TerminologiesPackage.TERMINOLOGY_BOX___NS_PREFIX;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH___NAME = TerminologiesPackage.TERMINOLOGY_BOX___NAME;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH___ABBREV_IRI = TerminologiesPackage.TERMINOLOGY_BOX___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH___UUID = TerminologiesPackage.TERMINOLOGY_BOX___UUID;

	/**
	 * The operation id for the '<em>Module Edges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH___MODULE_EDGES = TerminologiesPackage.TERMINOLOGY_BOX_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Terminology Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_GRAPH_OPERATION_COUNT = TerminologiesPackage.TERMINOLOGY_BOX_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.graphs.impl.ConceptDesignationTerminologyAxiomImpl <em>Concept Designation Terminology Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.ConceptDesignationTerminologyAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.GraphsPackageImpl#getConceptDesignationTerminologyAxiom()
	 * @generated
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM = 1;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__UUID = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__TBOX = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Designated Terminology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Designated Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Concept Designation Terminology Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_FEATURE_COUNT = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___SOURCE_MODULE = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM___SOURCE_MODULE;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___TARGET_MODULE = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM___TARGET_MODULE;

	/**
	 * The operation id for the '<em>Designation Terminology Graph</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___DESIGNATION_TERMINOLOGY_GRAPH = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___SOURCE = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___TARGET = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___UUID = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Concept Designation Terminology Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM_OPERATION_COUNT = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyNestingAxiomImpl <em>Terminology Nesting Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyNestingAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.GraphsPackageImpl#getTerminologyNestingAxiom()
	 * @generated
	 */
	int TERMINOLOGY_NESTING_AXIOM = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM__UUID = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM__TBOX = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Nesting Terminology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nesting Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Terminology Nesting Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM_FEATURE_COUNT = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM___SOURCE_MODULE = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM___SOURCE_MODULE;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM___TARGET_MODULE = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM___TARGET_MODULE;

	/**
	 * The operation id for the '<em>Nested Terminology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM___NESTED_TERMINOLOGY = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM___SOURCE = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM___TARGET = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM___UUID = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Terminology Nesting Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_NESTING_AXIOM_OPERATION_COUNT = TerminologiesPackage.TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph <em>Terminology Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Graph</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
	 * @generated
	 */
	EClass getTerminologyGraph();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph#moduleEdges() <em>Module Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Edges</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph#moduleEdges()
	 * @generated
	 */
	EOperation getTerminologyGraph__ModuleEdges();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom <em>Concept Designation Terminology Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept Designation Terminology Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom
	 * @generated
	 */
	EClass getConceptDesignationTerminologyAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#getDesignatedTerminology <em>Designated Terminology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Designated Terminology</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#getDesignatedTerminology()
	 * @see #getConceptDesignationTerminologyAxiom()
	 * @generated
	 */
	EReference getConceptDesignationTerminologyAxiom_DesignatedTerminology();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#getDesignatedConcept <em>Designated Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Designated Concept</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#getDesignatedConcept()
	 * @see #getConceptDesignationTerminologyAxiom()
	 * @generated
	 */
	EReference getConceptDesignationTerminologyAxiom_DesignatedConcept();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#designationTerminologyGraph() <em>Designation Terminology Graph</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Designation Terminology Graph</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#designationTerminologyGraph()
	 * @generated
	 */
	EOperation getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#source()
	 * @generated
	 */
	EOperation getConceptDesignationTerminologyAxiom__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#target()
	 * @generated
	 */
	EOperation getConceptDesignationTerminologyAxiom__Target();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom#uuid()
	 * @generated
	 */
	EOperation getConceptDesignationTerminologyAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom <em>Terminology Nesting Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Nesting Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom
	 * @generated
	 */
	EClass getTerminologyNestingAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#getNestingTerminology <em>Nesting Terminology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Nesting Terminology</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#getNestingTerminology()
	 * @see #getTerminologyNestingAxiom()
	 * @generated
	 */
	EReference getTerminologyNestingAxiom_NestingTerminology();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#getNestingContext <em>Nesting Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Nesting Context</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#getNestingContext()
	 * @see #getTerminologyNestingAxiom()
	 * @generated
	 */
	EReference getTerminologyNestingAxiom_NestingContext();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#nestedTerminology() <em>Nested Terminology</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Nested Terminology</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#nestedTerminology()
	 * @generated
	 */
	EOperation getTerminologyNestingAxiom__NestedTerminology();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#source()
	 * @generated
	 */
	EOperation getTerminologyNestingAxiom__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#target()
	 * @generated
	 */
	EOperation getTerminologyNestingAxiom__Target();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#uuid()
	 * @generated
	 */
	EOperation getTerminologyNestingAxiom__Uuid();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphsFactory getGraphsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyGraphImpl <em>Terminology Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyGraphImpl
		 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.GraphsPackageImpl#getTerminologyGraph()
		 * @generated
		 */
		EClass TERMINOLOGY_GRAPH = eINSTANCE.getTerminologyGraph();

		/**
		 * The meta object literal for the '<em><b>Module Edges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_GRAPH___MODULE_EDGES = eINSTANCE.getTerminologyGraph__ModuleEdges();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.graphs.impl.ConceptDesignationTerminologyAxiomImpl <em>Concept Designation Terminology Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.ConceptDesignationTerminologyAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.GraphsPackageImpl#getConceptDesignationTerminologyAxiom()
		 * @generated
		 */
		EClass CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM = eINSTANCE.getConceptDesignationTerminologyAxiom();

		/**
		 * The meta object literal for the '<em><b>Designated Terminology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY = eINSTANCE.getConceptDesignationTerminologyAxiom_DesignatedTerminology();

		/**
		 * The meta object literal for the '<em><b>Designated Concept</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT = eINSTANCE.getConceptDesignationTerminologyAxiom_DesignatedConcept();

		/**
		 * The meta object literal for the '<em><b>Designation Terminology Graph</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___DESIGNATION_TERMINOLOGY_GRAPH = eINSTANCE.getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___SOURCE = eINSTANCE.getConceptDesignationTerminologyAxiom__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___TARGET = eINSTANCE.getConceptDesignationTerminologyAxiom__Target();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___UUID = eINSTANCE.getConceptDesignationTerminologyAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyNestingAxiomImpl <em>Terminology Nesting Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyNestingAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.graphs.impl.GraphsPackageImpl#getTerminologyNestingAxiom()
		 * @generated
		 */
		EClass TERMINOLOGY_NESTING_AXIOM = eINSTANCE.getTerminologyNestingAxiom();

		/**
		 * The meta object literal for the '<em><b>Nesting Terminology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY = eINSTANCE.getTerminologyNestingAxiom_NestingTerminology();

		/**
		 * The meta object literal for the '<em><b>Nesting Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT = eINSTANCE.getTerminologyNestingAxiom_NestingContext();

		/**
		 * The meta object literal for the '<em><b>Nested Terminology</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_NESTING_AXIOM___NESTED_TERMINOLOGY = eINSTANCE.getTerminologyNestingAxiom__NestedTerminology();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_NESTING_AXIOM___SOURCE = eINSTANCE.getTerminologyNestingAxiom__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_NESTING_AXIOM___TARGET = eINSTANCE.getTerminologyNestingAxiom__Target();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_NESTING_AXIOM___UUID = eINSTANCE.getTerminologyNestingAxiom__Uuid();

	}

} //GraphsPackage
