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

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel copyrightText='\nCopyright 2017 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' childCreationExtenders='true' complianceLevel='8.0' featureDelegation='None' modelDirectory='/gov.nasa.jpl.imce.oml.model/src-gen/' editDirectory='/gov.nasa.jpl.imce.oml.model.edit/src-gen/' editPluginClass='gov.nasa.jpl.imce.oml.model.edit.provider.OMLEditPlugin' basePackage='gov.nasa.jpl.imce.oml.model'"
 * @generated
 */
public interface BundlesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bundles";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://imce.jpl.nasa.gov/oml/bundles";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "omlb";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BundlesPackage eINSTANCE = gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundleImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__UUID = TerminologiesPackage.TERMINOLOGY_BOX__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__ANNOTATIONS = TerminologiesPackage.TERMINOLOGY_BOX__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__EXTENT = TerminologiesPackage.TERMINOLOGY_BOX__EXTENT;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__IRI = TerminologiesPackage.TERMINOLOGY_BOX__IRI;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__KIND = TerminologiesPackage.TERMINOLOGY_BOX__KIND;

	/**
	 * The feature id for the '<em><b>Box Axioms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BOX_AXIOMS = TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS;

	/**
	 * The feature id for the '<em><b>Box Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BOX_STATEMENTS = TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS;

	/**
	 * The feature id for the '<em><b>Bundle Axioms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BUNDLE_AXIOMS = TerminologiesPackage.TERMINOLOGY_BOX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bundle Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BUNDLE_STATEMENTS = TerminologiesPackage.TERMINOLOGY_BOX_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = TerminologiesPackage.TERMINOLOGY_BOX_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___IRI = TerminologiesPackage.TERMINOLOGY_BOX___IRI;

	/**
	 * The operation id for the '<em>Ns Prefix</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___NS_PREFIX = TerminologiesPackage.TERMINOLOGY_BOX___NS_PREFIX;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___NAME = TerminologiesPackage.TERMINOLOGY_BOX___NAME;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___ABBREV_IRI = TerminologiesPackage.TERMINOLOGY_BOX___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___UUID = TerminologiesPackage.TERMINOLOGY_BOX___UUID;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___MODULE_CONTEXT = TerminologiesPackage.TERMINOLOGY_BOX___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>Module Edges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___MODULE_EDGES = TerminologiesPackage.TERMINOLOGY_BOX_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Module Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE___MODULE_ELEMENTS = TerminologiesPackage.TERMINOLOGY_BOX_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_OPERATION_COUNT = TerminologiesPackage.TERMINOLOGY_BOX_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.TerminologyBundleStatementImpl <em>Terminology Bundle Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.TerminologyBundleStatementImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getTerminologyBundleStatement()
	 * @generated
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT = 1;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT__UUID = CommonPackage.MODULE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT__ANNOTATIONS = CommonPackage.MODULE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT__BUNDLE = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminology Bundle Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT_FEATURE_COUNT = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT___UUID = CommonPackage.MODULE_ELEMENT___UUID;

	/**
	 * The operation id for the '<em>All Nested Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT___ALL_NESTED_ELEMENTS = CommonPackage.MODULE_ELEMENT___ALL_NESTED_ELEMENTS;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT___MODULE_CONTEXT = CommonPackage.MODULE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Terminology Bundle Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_STATEMENT_OPERATION_COUNT = CommonPackage.MODULE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.TerminologyBundleAxiomImpl <em>Terminology Bundle Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.TerminologyBundleAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getTerminologyBundleAxiom()
	 * @generated
	 */
	int TERMINOLOGY_BUNDLE_AXIOM = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM__UUID = TerminologiesPackage.TERMINOLOGY_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM__ANNOTATIONS = TerminologiesPackage.TERMINOLOGY_AXIOM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM__BUNDLE = TerminologiesPackage.TERMINOLOGY_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminology Bundle Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM_FEATURE_COUNT = TerminologiesPackage.TERMINOLOGY_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM___UUID = TerminologiesPackage.TERMINOLOGY_AXIOM___UUID;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM___MODULE_CONTEXT = TerminologiesPackage.TERMINOLOGY_AXIOM___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM___SOURCE = TerminologiesPackage.TERMINOLOGY_AXIOM___SOURCE;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM___SOURCE_MODULE = TerminologiesPackage.TERMINOLOGY_AXIOM___SOURCE_MODULE;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM___TARGET = TerminologiesPackage.TERMINOLOGY_AXIOM___TARGET;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM___TARGET_MODULE = TerminologiesPackage.TERMINOLOGY_AXIOM___TARGET_MODULE;

	/**
	 * The number of operations of the '<em>Terminology Bundle Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BUNDLE_AXIOM_OPERATION_COUNT = TerminologiesPackage.TERMINOLOGY_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.ConceptTreeDisjunctionImpl <em>Concept Tree Disjunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.ConceptTreeDisjunctionImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getConceptTreeDisjunction()
	 * @generated
	 */
	int CONCEPT_TREE_DISJUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION__UUID = CommonPackage.ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION__ANNOTATIONS = CommonPackage.ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Disjunctions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS = CommonPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concept Tree Disjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION_FEATURE_COUNT = CommonPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION___UUID = CommonPackage.ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION___MODULE_CONTEXT = CommonPackage.ELEMENT___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>Bundle Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION___BUNDLE_CONTAINER = CommonPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>All Nested Disjunctions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION___ALL_NESTED_DISJUNCTIONS = CommonPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Concept Tree Disjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_TREE_DISJUNCTION_OPERATION_COUNT = CommonPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.DisjointUnionOfConceptsAxiomImpl <em>Disjoint Union Of Concepts Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.DisjointUnionOfConceptsAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getDisjointUnionOfConceptsAxiom()
	 * @generated
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM = 4;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM__UUID = CommonPackage.ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM__ANNOTATIONS = CommonPackage.ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Disjoint Taxonomy Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT = CommonPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Disjoint Union Of Concepts Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM_FEATURE_COUNT = CommonPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM___UUID = CommonPackage.ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Concept Tree Disjunction Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM___CONCEPT_TREE_DISJUNCTION_PARENT = CommonPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM___MODULE_CONTEXT = CommonPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>All Nested Unions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM___ALL_NESTED_UNIONS = CommonPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Disjoint Union Of Concepts Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT = CommonPackage.ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.SpecificDisjointConceptAxiomImpl <em>Specific Disjoint Concept Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.SpecificDisjointConceptAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getSpecificDisjointConceptAxiom()
	 * @generated
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM = 5;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM__UUID = DISJOINT_UNION_OF_CONCEPTS_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM__ANNOTATIONS = DISJOINT_UNION_OF_CONCEPTS_AXIOM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Disjoint Taxonomy Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_TAXONOMY_PARENT = DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT;

	/**
	 * The feature id for the '<em><b>Disjoint Leaf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF = DISJOINT_UNION_OF_CONCEPTS_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Disjoint Concept Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM_FEATURE_COUNT = DISJOINT_UNION_OF_CONCEPTS_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Concept Tree Disjunction Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM___CONCEPT_TREE_DISJUNCTION_PARENT = DISJOINT_UNION_OF_CONCEPTS_AXIOM___CONCEPT_TREE_DISJUNCTION_PARENT;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM___MODULE_CONTEXT = DISJOINT_UNION_OF_CONCEPTS_AXIOM___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM___UUID = DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>All Nested Unions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM___ALL_NESTED_UNIONS = DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specific Disjoint Concept Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DISJOINT_CONCEPT_AXIOM_OPERATION_COUNT = DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.AnonymousConceptUnionAxiomImpl <em>Anonymous Concept Union Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.AnonymousConceptUnionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getAnonymousConceptUnionAxiom()
	 * @generated
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM = 6;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM__UUID = DISJOINT_UNION_OF_CONCEPTS_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM__ANNOTATIONS = DISJOINT_UNION_OF_CONCEPTS_AXIOM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Disjoint Taxonomy Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM__DISJOINT_TAXONOMY_PARENT = DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT;

	/**
	 * The feature id for the '<em><b>Disjunctions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM__DISJUNCTIONS = DISJOINT_UNION_OF_CONCEPTS_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM__NAME = DISJOINT_UNION_OF_CONCEPTS_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Anonymous Concept Union Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM_FEATURE_COUNT = DISJOINT_UNION_OF_CONCEPTS_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Concept Tree Disjunction Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM___CONCEPT_TREE_DISJUNCTION_PARENT = DISJOINT_UNION_OF_CONCEPTS_AXIOM___CONCEPT_TREE_DISJUNCTION_PARENT;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM___MODULE_CONTEXT = DISJOINT_UNION_OF_CONCEPTS_AXIOM___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM___UUID = DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Bundle Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM___BUNDLE_CONTAINER = DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>All Nested Disjunctions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM___ALL_NESTED_DISJUNCTIONS = DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>All Nested Unions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM___ALL_NESTED_UNIONS = DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Anonymous Concept Union Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_CONCEPT_UNION_AXIOM_OPERATION_COUNT = DISJOINT_UNION_OF_CONCEPTS_AXIOM_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.RootConceptTaxonomyAxiomImpl <em>Root Concept Taxonomy Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.RootConceptTaxonomyAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getRootConceptTaxonomyAxiom()
	 * @generated
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM = 7;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM__UUID = TERMINOLOGY_BUNDLE_STATEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM__ANNOTATIONS = TERMINOLOGY_BUNDLE_STATEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM__BUNDLE = TERMINOLOGY_BUNDLE_STATEMENT__BUNDLE;

	/**
	 * The feature id for the '<em><b>Disjunctions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM__DISJUNCTIONS = TERMINOLOGY_BUNDLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT = TERMINOLOGY_BUNDLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root Concept Taxonomy Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM_FEATURE_COUNT = TERMINOLOGY_BUNDLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM___MODULE_CONTEXT = TERMINOLOGY_BUNDLE_STATEMENT___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM___UUID = TERMINOLOGY_BUNDLE_STATEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Bundle Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM___BUNDLE_CONTAINER = TERMINOLOGY_BUNDLE_STATEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>All Nested Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM___ALL_NESTED_ELEMENTS = TERMINOLOGY_BUNDLE_STATEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>All Nested Disjunctions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM___ALL_NESTED_DISJUNCTIONS = TERMINOLOGY_BUNDLE_STATEMENT_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Root Concept Taxonomy Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONCEPT_TAXONOMY_AXIOM_OPERATION_COUNT = TERMINOLOGY_BUNDLE_STATEMENT_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.BundledTerminologyAxiomImpl <em>Bundled Terminology Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundledTerminologyAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getBundledTerminologyAxiom()
	 * @generated
	 */
	int BUNDLED_TERMINOLOGY_AXIOM = 8;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM__UUID = TERMINOLOGY_BUNDLE_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM__ANNOTATIONS = TERMINOLOGY_BUNDLE_AXIOM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM__BUNDLE = TERMINOLOGY_BUNDLE_AXIOM__BUNDLE;

	/**
	 * The feature id for the '<em><b>Bundled Terminology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY = TERMINOLOGY_BUNDLE_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bundled Terminology Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM_FEATURE_COUNT = TERMINOLOGY_BUNDLE_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM___MODULE_CONTEXT = TERMINOLOGY_BUNDLE_AXIOM___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM___SOURCE_MODULE = TERMINOLOGY_BUNDLE_AXIOM___SOURCE_MODULE;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM___TARGET_MODULE = TERMINOLOGY_BUNDLE_AXIOM___TARGET_MODULE;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM___SOURCE = TERMINOLOGY_BUNDLE_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM___TARGET = TERMINOLOGY_BUNDLE_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM___UUID = TERMINOLOGY_BUNDLE_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bundled Terminology Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLED_TERMINOLOGY_AXIOM_OPERATION_COUNT = TERMINOLOGY_BUNDLE_AXIOM_OPERATION_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.Bundle
	 * @generated
	 */
	EClass getBundle();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.bundles.Bundle#getBundleAxioms <em>Bundle Axioms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bundle Axioms</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.Bundle#getBundleAxioms()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_BundleAxioms();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.bundles.Bundle#getBundleStatements <em>Bundle Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bundle Statements</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.Bundle#getBundleStatements()
	 * @see #getBundle()
	 * @generated
	 */
	EReference getBundle_BundleStatements();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.Bundle#moduleEdges() <em>Module Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Edges</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.Bundle#moduleEdges()
	 * @generated
	 */
	EOperation getBundle__ModuleEdges();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.Bundle#moduleElements() <em>Module Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Elements</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.Bundle#moduleElements()
	 * @generated
	 */
	EOperation getBundle__ModuleElements();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement <em>Terminology Bundle Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Bundle Statement</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement
	 * @generated
	 */
	EClass getTerminologyBundleStatement();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bundle</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement#getBundle()
	 * @see #getTerminologyBundleStatement()
	 * @generated
	 */
	EReference getTerminologyBundleStatement_Bundle();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement#moduleContext() <em>Module Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Context</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement#moduleContext()
	 * @generated
	 */
	EOperation getTerminologyBundleStatement__ModuleContext();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom <em>Terminology Bundle Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Bundle Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom
	 * @generated
	 */
	EClass getTerminologyBundleAxiom();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bundle</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom#getBundle()
	 * @see #getTerminologyBundleAxiom()
	 * @generated
	 */
	EReference getTerminologyBundleAxiom_Bundle();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction <em>Concept Tree Disjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept Tree Disjunction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction
	 * @generated
	 */
	EClass getConceptTreeDisjunction();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#getDisjunctions <em>Disjunctions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Disjunctions</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#getDisjunctions()
	 * @see #getConceptTreeDisjunction()
	 * @generated
	 */
	EReference getConceptTreeDisjunction_Disjunctions();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#bundleContainer() <em>Bundle Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Bundle Container</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#bundleContainer()
	 * @generated
	 */
	EOperation getConceptTreeDisjunction__BundleContainer();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#allNestedDisjunctions() <em>All Nested Disjunctions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Nested Disjunctions</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction#allNestedDisjunctions()
	 * @generated
	 */
	EOperation getConceptTreeDisjunction__AllNestedDisjunctions();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom <em>Disjoint Union Of Concepts Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disjoint Union Of Concepts Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom
	 * @generated
	 */
	EClass getDisjointUnionOfConceptsAxiom();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#getDisjointTaxonomyParent <em>Disjoint Taxonomy Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Disjoint Taxonomy Parent</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#getDisjointTaxonomyParent()
	 * @see #getDisjointUnionOfConceptsAxiom()
	 * @generated
	 */
	EReference getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#conceptTreeDisjunctionParent() <em>Concept Tree Disjunction Parent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Concept Tree Disjunction Parent</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#conceptTreeDisjunctionParent()
	 * @generated
	 */
	EOperation getDisjointUnionOfConceptsAxiom__ConceptTreeDisjunctionParent();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#moduleContext() <em>Module Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Context</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#moduleContext()
	 * @generated
	 */
	EOperation getDisjointUnionOfConceptsAxiom__ModuleContext();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#allNestedUnions() <em>All Nested Unions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Nested Unions</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom#allNestedUnions()
	 * @generated
	 */
	EOperation getDisjointUnionOfConceptsAxiom__AllNestedUnions();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom <em>Specific Disjoint Concept Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Disjoint Concept Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom
	 * @generated
	 */
	EClass getSpecificDisjointConceptAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom#getDisjointLeaf <em>Disjoint Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Disjoint Leaf</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom#getDisjointLeaf()
	 * @see #getSpecificDisjointConceptAxiom()
	 * @generated
	 */
	EReference getSpecificDisjointConceptAxiom_DisjointLeaf();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom#uuid()
	 * @generated
	 */
	EOperation getSpecificDisjointConceptAxiom__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom#allNestedUnions() <em>All Nested Unions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Nested Unions</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom#allNestedUnions()
	 * @generated
	 */
	EOperation getSpecificDisjointConceptAxiom__AllNestedUnions();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom <em>Anonymous Concept Union Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Anonymous Concept Union Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom
	 * @generated
	 */
	EClass getAnonymousConceptUnionAxiom();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#getName()
	 * @see #getAnonymousConceptUnionAxiom()
	 * @generated
	 */
	EAttribute getAnonymousConceptUnionAxiom_Name();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#uuid()
	 * @generated
	 */
	EOperation getAnonymousConceptUnionAxiom__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#bundleContainer() <em>Bundle Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Bundle Container</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#bundleContainer()
	 * @generated
	 */
	EOperation getAnonymousConceptUnionAxiom__BundleContainer();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#allNestedDisjunctions() <em>All Nested Disjunctions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Nested Disjunctions</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#allNestedDisjunctions()
	 * @generated
	 */
	EOperation getAnonymousConceptUnionAxiom__AllNestedDisjunctions();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#allNestedUnions() <em>All Nested Unions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Nested Unions</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#allNestedUnions()
	 * @generated
	 */
	EOperation getAnonymousConceptUnionAxiom__AllNestedUnions();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom <em>Root Concept Taxonomy Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Concept Taxonomy Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom
	 * @generated
	 */
	EClass getRootConceptTaxonomyAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#getRoot()
	 * @see #getRootConceptTaxonomyAxiom()
	 * @generated
	 */
	EReference getRootConceptTaxonomyAxiom_Root();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#uuid()
	 * @generated
	 */
	EOperation getRootConceptTaxonomyAxiom__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#bundleContainer() <em>Bundle Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Bundle Container</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#bundleContainer()
	 * @generated
	 */
	EOperation getRootConceptTaxonomyAxiom__BundleContainer();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#allNestedElements() <em>All Nested Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Nested Elements</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#allNestedElements()
	 * @generated
	 */
	EOperation getRootConceptTaxonomyAxiom__AllNestedElements();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#allNestedDisjunctions() <em>All Nested Disjunctions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Nested Disjunctions</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#allNestedDisjunctions()
	 * @generated
	 */
	EOperation getRootConceptTaxonomyAxiom__AllNestedDisjunctions();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom <em>Bundled Terminology Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundled Terminology Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom
	 * @generated
	 */
	EClass getBundledTerminologyAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#getBundledTerminology <em>Bundled Terminology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bundled Terminology</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#getBundledTerminology()
	 * @see #getBundledTerminologyAxiom()
	 * @generated
	 */
	EReference getBundledTerminologyAxiom_BundledTerminology();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#source()
	 * @generated
	 */
	EOperation getBundledTerminologyAxiom__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#target()
	 * @generated
	 */
	EOperation getBundledTerminologyAxiom__Target();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#uuid()
	 * @generated
	 */
	EOperation getBundledTerminologyAxiom__Uuid();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BundlesFactory getBundlesFactory();

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
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundleImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getBundle()
		 * @generated
		 */
		EClass BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em><b>Bundle Axioms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__BUNDLE_AXIOMS = eINSTANCE.getBundle_BundleAxioms();

		/**
		 * The meta object literal for the '<em><b>Bundle Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLE__BUNDLE_STATEMENTS = eINSTANCE.getBundle_BundleStatements();

		/**
		 * The meta object literal for the '<em><b>Module Edges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUNDLE___MODULE_EDGES = eINSTANCE.getBundle__ModuleEdges();

		/**
		 * The meta object literal for the '<em><b>Module Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUNDLE___MODULE_ELEMENTS = eINSTANCE.getBundle__ModuleElements();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.TerminologyBundleStatementImpl <em>Terminology Bundle Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.TerminologyBundleStatementImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getTerminologyBundleStatement()
		 * @generated
		 */
		EClass TERMINOLOGY_BUNDLE_STATEMENT = eINSTANCE.getTerminologyBundleStatement();

		/**
		 * The meta object literal for the '<em><b>Bundle</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_BUNDLE_STATEMENT__BUNDLE = eINSTANCE.getTerminologyBundleStatement_Bundle();

		/**
		 * The meta object literal for the '<em><b>Module Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_BUNDLE_STATEMENT___MODULE_CONTEXT = eINSTANCE.getTerminologyBundleStatement__ModuleContext();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.TerminologyBundleAxiomImpl <em>Terminology Bundle Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.TerminologyBundleAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getTerminologyBundleAxiom()
		 * @generated
		 */
		EClass TERMINOLOGY_BUNDLE_AXIOM = eINSTANCE.getTerminologyBundleAxiom();

		/**
		 * The meta object literal for the '<em><b>Bundle</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_BUNDLE_AXIOM__BUNDLE = eINSTANCE.getTerminologyBundleAxiom_Bundle();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.ConceptTreeDisjunctionImpl <em>Concept Tree Disjunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.ConceptTreeDisjunctionImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getConceptTreeDisjunction()
		 * @generated
		 */
		EClass CONCEPT_TREE_DISJUNCTION = eINSTANCE.getConceptTreeDisjunction();

		/**
		 * The meta object literal for the '<em><b>Disjunctions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS = eINSTANCE.getConceptTreeDisjunction_Disjunctions();

		/**
		 * The meta object literal for the '<em><b>Bundle Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_TREE_DISJUNCTION___BUNDLE_CONTAINER = eINSTANCE.getConceptTreeDisjunction__BundleContainer();

		/**
		 * The meta object literal for the '<em><b>All Nested Disjunctions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_TREE_DISJUNCTION___ALL_NESTED_DISJUNCTIONS = eINSTANCE.getConceptTreeDisjunction__AllNestedDisjunctions();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.DisjointUnionOfConceptsAxiomImpl <em>Disjoint Union Of Concepts Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.DisjointUnionOfConceptsAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getDisjointUnionOfConceptsAxiom()
		 * @generated
		 */
		EClass DISJOINT_UNION_OF_CONCEPTS_AXIOM = eINSTANCE.getDisjointUnionOfConceptsAxiom();

		/**
		 * The meta object literal for the '<em><b>Disjoint Taxonomy Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT = eINSTANCE.getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent();

		/**
		 * The meta object literal for the '<em><b>Concept Tree Disjunction Parent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DISJOINT_UNION_OF_CONCEPTS_AXIOM___CONCEPT_TREE_DISJUNCTION_PARENT = eINSTANCE.getDisjointUnionOfConceptsAxiom__ConceptTreeDisjunctionParent();

		/**
		 * The meta object literal for the '<em><b>Module Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DISJOINT_UNION_OF_CONCEPTS_AXIOM___MODULE_CONTEXT = eINSTANCE.getDisjointUnionOfConceptsAxiom__ModuleContext();

		/**
		 * The meta object literal for the '<em><b>All Nested Unions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DISJOINT_UNION_OF_CONCEPTS_AXIOM___ALL_NESTED_UNIONS = eINSTANCE.getDisjointUnionOfConceptsAxiom__AllNestedUnions();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.SpecificDisjointConceptAxiomImpl <em>Specific Disjoint Concept Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.SpecificDisjointConceptAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getSpecificDisjointConceptAxiom()
		 * @generated
		 */
		EClass SPECIFIC_DISJOINT_CONCEPT_AXIOM = eINSTANCE.getSpecificDisjointConceptAxiom();

		/**
		 * The meta object literal for the '<em><b>Disjoint Leaf</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF = eINSTANCE.getSpecificDisjointConceptAxiom_DisjointLeaf();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SPECIFIC_DISJOINT_CONCEPT_AXIOM___UUID = eINSTANCE.getSpecificDisjointConceptAxiom__Uuid();

		/**
		 * The meta object literal for the '<em><b>All Nested Unions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SPECIFIC_DISJOINT_CONCEPT_AXIOM___ALL_NESTED_UNIONS = eINSTANCE.getSpecificDisjointConceptAxiom__AllNestedUnions();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.AnonymousConceptUnionAxiomImpl <em>Anonymous Concept Union Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.AnonymousConceptUnionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getAnonymousConceptUnionAxiom()
		 * @generated
		 */
		EClass ANONYMOUS_CONCEPT_UNION_AXIOM = eINSTANCE.getAnonymousConceptUnionAxiom();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANONYMOUS_CONCEPT_UNION_AXIOM__NAME = eINSTANCE.getAnonymousConceptUnionAxiom_Name();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANONYMOUS_CONCEPT_UNION_AXIOM___UUID = eINSTANCE.getAnonymousConceptUnionAxiom__Uuid();

		/**
		 * The meta object literal for the '<em><b>Bundle Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANONYMOUS_CONCEPT_UNION_AXIOM___BUNDLE_CONTAINER = eINSTANCE.getAnonymousConceptUnionAxiom__BundleContainer();

		/**
		 * The meta object literal for the '<em><b>All Nested Disjunctions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANONYMOUS_CONCEPT_UNION_AXIOM___ALL_NESTED_DISJUNCTIONS = eINSTANCE.getAnonymousConceptUnionAxiom__AllNestedDisjunctions();

		/**
		 * The meta object literal for the '<em><b>All Nested Unions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANONYMOUS_CONCEPT_UNION_AXIOM___ALL_NESTED_UNIONS = eINSTANCE.getAnonymousConceptUnionAxiom__AllNestedUnions();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.RootConceptTaxonomyAxiomImpl <em>Root Concept Taxonomy Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.RootConceptTaxonomyAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getRootConceptTaxonomyAxiom()
		 * @generated
		 */
		EClass ROOT_CONCEPT_TAXONOMY_AXIOM = eINSTANCE.getRootConceptTaxonomyAxiom();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT = eINSTANCE.getRootConceptTaxonomyAxiom_Root();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ROOT_CONCEPT_TAXONOMY_AXIOM___UUID = eINSTANCE.getRootConceptTaxonomyAxiom__Uuid();

		/**
		 * The meta object literal for the '<em><b>Bundle Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ROOT_CONCEPT_TAXONOMY_AXIOM___BUNDLE_CONTAINER = eINSTANCE.getRootConceptTaxonomyAxiom__BundleContainer();

		/**
		 * The meta object literal for the '<em><b>All Nested Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ROOT_CONCEPT_TAXONOMY_AXIOM___ALL_NESTED_ELEMENTS = eINSTANCE.getRootConceptTaxonomyAxiom__AllNestedElements();

		/**
		 * The meta object literal for the '<em><b>All Nested Disjunctions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ROOT_CONCEPT_TAXONOMY_AXIOM___ALL_NESTED_DISJUNCTIONS = eINSTANCE.getRootConceptTaxonomyAxiom__AllNestedDisjunctions();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.bundles.impl.BundledTerminologyAxiomImpl <em>Bundled Terminology Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundledTerminologyAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.bundles.impl.BundlesPackageImpl#getBundledTerminologyAxiom()
		 * @generated
		 */
		EClass BUNDLED_TERMINOLOGY_AXIOM = eINSTANCE.getBundledTerminologyAxiom();

		/**
		 * The meta object literal for the '<em><b>Bundled Terminology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY = eINSTANCE.getBundledTerminologyAxiom_BundledTerminology();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUNDLED_TERMINOLOGY_AXIOM___SOURCE = eINSTANCE.getBundledTerminologyAxiom__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUNDLED_TERMINOLOGY_AXIOM___TARGET = eINSTANCE.getBundledTerminologyAxiom__Target();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUNDLED_TERMINOLOGY_AXIOM___UUID = eINSTANCE.getBundledTerminologyAxiom__Uuid();

	}

} //BundlesPackage
