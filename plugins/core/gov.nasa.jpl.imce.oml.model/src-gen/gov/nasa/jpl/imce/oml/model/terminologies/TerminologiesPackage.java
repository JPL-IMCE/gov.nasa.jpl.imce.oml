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
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * <!-- begin-model-doc -->
 * *
 * Copyright 2017 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the \"License\")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <!-- end-model-doc -->
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel copyrightText='\nCopyright 2017 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' childCreationExtenders='true' complianceLevel='8.0' featureDelegation='None' modelDirectory='/gov.nasa.jpl.imce.oml.model/src-gen/' editDirectory='/gov.nasa.jpl.imce.oml.model.edit/src-gen/' basePackage='gov.nasa.jpl.imce.oml.model'"
 * @generated
 */
public interface TerminologiesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "terminologies";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://imce.jpl.nasa.gov/oml/terminologies";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "omlt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TerminologiesPackage eINSTANCE = gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl <em>Terminology Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyBox()
	 * @generated
	 */
	int TERMINOLOGY_BOX = 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX__UUID = CommonPackage.MODULE__UUID;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX__EXTENT = CommonPackage.MODULE__EXTENT;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX__IRI = CommonPackage.MODULE__IRI;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX__ANNOTATIONS = CommonPackage.MODULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX__KIND = CommonPackage.MODULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Box Axioms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX__BOX_AXIOMS = CommonPackage.MODULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Box Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX__BOX_STATEMENTS = CommonPackage.MODULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Terminology Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_FEATURE_COUNT = CommonPackage.MODULE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Module Edges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX___MODULE_EDGES = CommonPackage.MODULE___MODULE_EDGES;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX___IRI = CommonPackage.MODULE___IRI;

	/**
	 * The operation id for the '<em>Ns Prefix</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX___NS_PREFIX = CommonPackage.MODULE___NS_PREFIX;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX___NAME = CommonPackage.MODULE___NAME;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX___ABBREV_IRI = CommonPackage.MODULE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX___UUID = CommonPackage.MODULE___UUID;

	/**
	 * The number of operations of the '<em>Terminology Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_OPERATION_COUNT = CommonPackage.MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxStatementImpl <em>Terminology Box Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxStatementImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyBoxStatement()
	 * @generated
	 */
	int TERMINOLOGY_BOX_STATEMENT = 1;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_STATEMENT__UUID = CommonPackage.MODULE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_STATEMENT__TBOX = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminology Box Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_STATEMENT_FEATURE_COUNT = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_STATEMENT___UUID = CommonPackage.MODULE_ELEMENT___UUID;

	/**
	 * The number of operations of the '<em>Terminology Box Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_STATEMENT_OPERATION_COUNT = CommonPackage.MODULE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyAxiomImpl <em>Terminology Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyAxiom()
	 * @generated
	 */
	int TERMINOLOGY_AXIOM = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_AXIOM__UUID = CommonPackage.MODULE_EDGE__UUID;

	/**
	 * The number of structural features of the '<em>Terminology Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_AXIOM_FEATURE_COUNT = CommonPackage.MODULE_EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_AXIOM___UUID = CommonPackage.MODULE_EDGE___UUID;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_AXIOM___SOURCE = CommonPackage.MODULE_EDGE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_AXIOM___SOURCE_MODULE = CommonPackage.MODULE_EDGE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_AXIOM___TARGET = CommonPackage.MODULE_EDGE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_AXIOM___TARGET_MODULE = CommonPackage.MODULE_EDGE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Terminology Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_AXIOM_OPERATION_COUNT = CommonPackage.MODULE_EDGE_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxAxiomImpl <em>Terminology Box Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyBoxAxiom()
	 * @generated
	 */
	int TERMINOLOGY_BOX_AXIOM = 3;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM__UUID = TERMINOLOGY_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM__TBOX = TERMINOLOGY_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminology Box Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT = TERMINOLOGY_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM___UUID = TERMINOLOGY_AXIOM___UUID;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM___SOURCE = TERMINOLOGY_AXIOM___SOURCE;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM___SOURCE_MODULE = TERMINOLOGY_AXIOM___SOURCE_MODULE;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM___TARGET = TERMINOLOGY_AXIOM___TARGET;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM___TARGET_MODULE = TERMINOLOGY_AXIOM___TARGET_MODULE;

	/**
	 * The number of operations of the '<em>Terminology Box Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT = TERMINOLOGY_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyExtensionAxiomImpl <em>Terminology Extension Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyExtensionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyExtensionAxiom()
	 * @generated
	 */
	int TERMINOLOGY_EXTENSION_AXIOM = 4;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM__UUID = TERMINOLOGY_BOX_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM__TBOX = TERMINOLOGY_BOX_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Extended Terminology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY = TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminology Extension Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM_FEATURE_COUNT = TERMINOLOGY_BOX_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM___SOURCE_MODULE = TERMINOLOGY_BOX_AXIOM___SOURCE_MODULE;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM___TARGET_MODULE = TERMINOLOGY_BOX_AXIOM___TARGET_MODULE;

	/**
	 * The operation id for the '<em>Extending Terminology</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM___EXTENDING_TERMINOLOGY = TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM___SOURCE = TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM___TARGET = TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM___UUID = TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Terminology Extension Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_EXTENSION_AXIOM_OPERATION_COUNT = TERMINOLOGY_BOX_AXIOM_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TermImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 5;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__UUID = TERMINOLOGY_BOX_STATEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__TBOX = TERMINOLOGY_BOX_STATEMENT__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__NAME = TERMINOLOGY_BOX_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = TERMINOLOGY_BOX_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___IRI = TERMINOLOGY_BOX_STATEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___ABBREV_IRI = TERMINOLOGY_BOX_STATEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___NAME = TERMINOLOGY_BOX_STATEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM___UUID = TERMINOLOGY_BOX_STATEMENT_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_OPERATION_COUNT = TERMINOLOGY_BOX_STATEMENT_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.UnaryTermKindImpl <em>Unary Term Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.UnaryTermKindImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getUnaryTermKind()
	 * @generated
	 */
	int UNARY_TERM_KIND = 6;

	/**
	 * The number of structural features of the '<em>Unary Term Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM_KIND_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Unary Term Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM_KIND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DirectedBinaryRelationshipKindImpl <em>Directed Binary Relationship Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DirectedBinaryRelationshipKindImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDirectedBinaryRelationshipKind()
	 * @generated
	 */
	int DIRECTED_BINARY_RELATIONSHIP_KIND = 7;

	/**
	 * The number of structural features of the '<em>Directed Binary Relationship Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTED_BINARY_RELATIONSHIP_KIND_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_DOMAIN = 0;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_RANGE = 1;

	/**
	 * The number of operations of the '<em>Directed Binary Relationship Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTED_BINARY_RELATIONSHIP_KIND_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 8;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__UUID = TERM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__TBOX = TERM__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = TERM__NAME;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___IRI = TERM___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___ABBREV_IRI = TERM___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___NAME = TERM___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY___UUID = TERM___UUID;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptualEntityImpl <em>Conceptual Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptualEntityImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getConceptualEntity()
	 * @generated
	 */
	int CONCEPTUAL_ENTITY = 9;

	/**
	 * The number of structural features of the '<em>Conceptual Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Conceptual Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectImpl <em>Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getAspect()
	 * @generated
	 */
	int ASPECT = 10;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__UUID = ENTITY__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__TBOX = ENTITY__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__NAME = ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___IRI = ENTITY___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___ABBREV_IRI = ENTITY___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___NAME = ENTITY___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT___UUID = ENTITY___UUID;

	/**
	 * The number of operations of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptImpl <em>Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getConcept()
	 * @generated
	 */
	int CONCEPT = 11;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__UUID = ENTITY__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__TBOX = ENTITY__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__NAME = ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___IRI = ENTITY___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___ABBREV_IRI = ENTITY___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___NAME = ENTITY___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT___UUID = ENTITY___UUID;

	/**
	 * The number of operations of the '<em>Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRelationshipImpl <em>Entity Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityRelationship()
	 * @generated
	 */
	int ENTITY_RELATIONSHIP = 12;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__UUID = TERM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__TBOX = TERM__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__NAME = TERM__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__SOURCE = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__TARGET = TERM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_FUNCTIONAL = TERM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Inverse Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL = TERM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_ESSENTIAL = TERM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Inverse Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL = TERM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Is Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_SYMMETRIC = TERM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Is Asymmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_ASYMMETRIC = TERM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Is Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_REFLEXIVE = TERM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is Irreflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_IRREFLEXIVE = TERM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Is Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP__IS_TRANSITIVE = TERM_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Entity Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP_FEATURE_COUNT = TERM_FEATURE_COUNT + 11;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP___IRI = TERM___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP___ABBREV_IRI = TERM___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP___NAME = TERM___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP___UUID = TERM___UUID;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP___RELATION_DOMAIN = TERM_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP___RELATION_RANGE = TERM_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Entity Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RELATIONSHIP_OPERATION_COUNT = TERM_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl <em>Reified Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getReifiedRelationship()
	 * @generated
	 */
	int REIFIED_RELATIONSHIP = 13;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__UUID = ENTITY_RELATIONSHIP__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__TBOX = ENTITY_RELATIONSHIP__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__NAME = ENTITY_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__SOURCE = ENTITY_RELATIONSHIP__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__TARGET = ENTITY_RELATIONSHIP__TARGET;

	/**
	 * The feature id for the '<em><b>Is Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_FUNCTIONAL = ENTITY_RELATIONSHIP__IS_FUNCTIONAL;

	/**
	 * The feature id for the '<em><b>Is Inverse Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL = ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL;

	/**
	 * The feature id for the '<em><b>Is Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_ESSENTIAL = ENTITY_RELATIONSHIP__IS_ESSENTIAL;

	/**
	 * The feature id for the '<em><b>Is Inverse Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL = ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL;

	/**
	 * The feature id for the '<em><b>Is Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_SYMMETRIC = ENTITY_RELATIONSHIP__IS_SYMMETRIC;

	/**
	 * The feature id for the '<em><b>Is Asymmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_ASYMMETRIC = ENTITY_RELATIONSHIP__IS_ASYMMETRIC;

	/**
	 * The feature id for the '<em><b>Is Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_REFLEXIVE = ENTITY_RELATIONSHIP__IS_REFLEXIVE;

	/**
	 * The feature id for the '<em><b>Is Irreflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_IRREFLEXIVE = ENTITY_RELATIONSHIP__IS_IRREFLEXIVE;

	/**
	 * The feature id for the '<em><b>Is Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__IS_TRANSITIVE = ENTITY_RELATIONSHIP__IS_TRANSITIVE;

	/**
	 * The feature id for the '<em><b>Unreified Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__UNREIFIED_PROPERTY_NAME = ENTITY_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unreified Inverse Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP__UNREIFIED_INVERSE_PROPERTY_NAME = ENTITY_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_FEATURE_COUNT = ENTITY_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP___IRI = ENTITY_RELATIONSHIP___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP___ABBREV_IRI = ENTITY_RELATIONSHIP___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP___NAME = ENTITY_RELATIONSHIP___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP___UUID = ENTITY_RELATIONSHIP___UUID;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP___RELATION_DOMAIN = ENTITY_RELATIONSHIP___RELATION_DOMAIN;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP___RELATION_RANGE = ENTITY_RELATIONSHIP___RELATION_RANGE;

	/**
	 * The number of operations of the '<em>Reified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_OPERATION_COUNT = ENTITY_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.UnreifiedRelationshipImpl <em>Unreified Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.UnreifiedRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getUnreifiedRelationship()
	 * @generated
	 */
	int UNREIFIED_RELATIONSHIP = 14;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__UUID = ENTITY_RELATIONSHIP__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__TBOX = ENTITY_RELATIONSHIP__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__NAME = ENTITY_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__SOURCE = ENTITY_RELATIONSHIP__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__TARGET = ENTITY_RELATIONSHIP__TARGET;

	/**
	 * The feature id for the '<em><b>Is Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_FUNCTIONAL = ENTITY_RELATIONSHIP__IS_FUNCTIONAL;

	/**
	 * The feature id for the '<em><b>Is Inverse Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL = ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL;

	/**
	 * The feature id for the '<em><b>Is Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_ESSENTIAL = ENTITY_RELATIONSHIP__IS_ESSENTIAL;

	/**
	 * The feature id for the '<em><b>Is Inverse Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL = ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL;

	/**
	 * The feature id for the '<em><b>Is Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_SYMMETRIC = ENTITY_RELATIONSHIP__IS_SYMMETRIC;

	/**
	 * The feature id for the '<em><b>Is Asymmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_ASYMMETRIC = ENTITY_RELATIONSHIP__IS_ASYMMETRIC;

	/**
	 * The feature id for the '<em><b>Is Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_REFLEXIVE = ENTITY_RELATIONSHIP__IS_REFLEXIVE;

	/**
	 * The feature id for the '<em><b>Is Irreflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_IRREFLEXIVE = ENTITY_RELATIONSHIP__IS_IRREFLEXIVE;

	/**
	 * The feature id for the '<em><b>Is Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP__IS_TRANSITIVE = ENTITY_RELATIONSHIP__IS_TRANSITIVE;

	/**
	 * The number of structural features of the '<em>Unreified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_FEATURE_COUNT = ENTITY_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP___IRI = ENTITY_RELATIONSHIP___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP___ABBREV_IRI = ENTITY_RELATIONSHIP___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP___NAME = ENTITY_RELATIONSHIP___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP___UUID = ENTITY_RELATIONSHIP___UUID;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP___RELATION_DOMAIN = ENTITY_RELATIONSHIP___RELATION_DOMAIN;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP___RELATION_RANGE = ENTITY_RELATIONSHIP___RELATION_RANGE;

	/**
	 * The number of operations of the '<em>Unreified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_OPERATION_COUNT = ENTITY_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DatatypeImpl <em>Datatype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DatatypeImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDatatype()
	 * @generated
	 */
	int DATATYPE = 15;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE__UUID = TERM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE__TBOX = TERM__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE__NAME = TERM__NAME;

	/**
	 * The number of structural features of the '<em>Datatype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE___IRI = TERM___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE___ABBREV_IRI = TERM___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE___NAME = TERM___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE___UUID = TERM___UUID;

	/**
	 * The number of operations of the '<em>Datatype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATATYPE_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRangeImpl <em>Data Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRangeImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRange()
	 * @generated
	 */
	int DATA_RANGE = 16;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE__UUID = DATATYPE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE__TBOX = DATATYPE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE__NAME = DATATYPE__NAME;

	/**
	 * The number of structural features of the '<em>Data Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE_FEATURE_COUNT = DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE___IRI = DATATYPE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE___ABBREV_IRI = DATATYPE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE___NAME = DATATYPE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE___UUID = DATATYPE___UUID;

	/**
	 * The number of operations of the '<em>Data Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RANGE_OPERATION_COUNT = DATATYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarImpl <em>Scalar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getScalar()
	 * @generated
	 */
	int SCALAR = 17;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__UUID = DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__TBOX = DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR__NAME = DATA_RANGE__NAME;

	/**
	 * The number of structural features of the '<em>Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_FEATURE_COUNT = DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___IRI = DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___ABBREV_IRI = DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___NAME = DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR___UUID = DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_OPERATION_COUNT = DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipImpl <em>Data Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationship()
	 * @generated
	 */
	int DATA_RELATIONSHIP = 18;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP__UUID = TERM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP__TBOX = TERM__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP__NAME = TERM__NAME;

	/**
	 * The number of structural features of the '<em>Data Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP___IRI = TERM___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP___ABBREV_IRI = TERM___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP___NAME = TERM___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP___UUID = TERM___UUID;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP___SOURCE = TERM_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP___RELATION_DOMAIN = TERM_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP___TARGET = TERM_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP___RELATION_RANGE = TERM_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Data Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_OPERATION_COUNT = TERM_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipDomainImpl <em>Data Relationship Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipDomainImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipDomain()
	 * @generated
	 */
	int DATA_RELATIONSHIP_DOMAIN = 19;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_DOMAIN__UUID = CommonPackage.ELEMENT__UUID;

	/**
	 * The number of structural features of the '<em>Data Relationship Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_DOMAIN_FEATURE_COUNT = CommonPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_DOMAIN___UUID = CommonPackage.ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_DOMAIN___IRI = CommonPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_DOMAIN___NAME = CommonPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_DOMAIN___ABBREV_IRI = CommonPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Relationship Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_DOMAIN_OPERATION_COUNT = CommonPackage.ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromEntityImpl <em>Data Relationship From Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromEntityImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipFromEntity()
	 * @generated
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY = 20;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY__UUID = DATA_RELATIONSHIP_DOMAIN__UUID;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN = DATA_RELATIONSHIP_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Identity Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA = DATA_RELATIONSHIP_DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Relationship From Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY_FEATURE_COUNT = DATA_RELATIONSHIP_DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY___UUID = DATA_RELATIONSHIP_DOMAIN___UUID;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY___IRI = DATA_RELATIONSHIP_DOMAIN___IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY___NAME = DATA_RELATIONSHIP_DOMAIN___NAME;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY___ABBREV_IRI = DATA_RELATIONSHIP_DOMAIN___ABBREV_IRI;

	/**
	 * The number of operations of the '<em>Data Relationship From Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_ENTITY_OPERATION_COUNT = DATA_RELATIONSHIP_DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromStructureImpl <em>Data Relationship From Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromStructureImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipFromStructure()
	 * @generated
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE = 21;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE__UUID = DATA_RELATIONSHIP_DOMAIN__UUID;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN = DATA_RELATIONSHIP_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Relationship From Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE_FEATURE_COUNT = DATA_RELATIONSHIP_DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE___UUID = DATA_RELATIONSHIP_DOMAIN___UUID;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE___IRI = DATA_RELATIONSHIP_DOMAIN___IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE___NAME = DATA_RELATIONSHIP_DOMAIN___NAME;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE___ABBREV_IRI = DATA_RELATIONSHIP_DOMAIN___ABBREV_IRI;

	/**
	 * The number of operations of the '<em>Data Relationship From Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_FROM_STRUCTURE_OPERATION_COUNT = DATA_RELATIONSHIP_DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipRangeImpl <em>Data Relationship Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipRangeImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipRange()
	 * @generated
	 */
	int DATA_RELATIONSHIP_RANGE = 22;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_RANGE__UUID = CommonPackage.ELEMENT__UUID;

	/**
	 * The number of structural features of the '<em>Data Relationship Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_RANGE_FEATURE_COUNT = CommonPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_RANGE___UUID = CommonPackage.ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_RANGE___IRI = CommonPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_RANGE___NAME = CommonPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_RANGE___ABBREV_IRI = CommonPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Relationship Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_RANGE_OPERATION_COUNT = CommonPackage.ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipToScalarImpl <em>Data Relationship To Scalar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipToScalarImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipToScalar()
	 * @generated
	 */
	int DATA_RELATIONSHIP_TO_SCALAR = 23;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_SCALAR__UUID = DATA_RELATIONSHIP_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_SCALAR__RANGE = DATA_RELATIONSHIP_RANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Relationship To Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_SCALAR_FEATURE_COUNT = DATA_RELATIONSHIP_RANGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_SCALAR___UUID = DATA_RELATIONSHIP_RANGE___UUID;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_SCALAR___IRI = DATA_RELATIONSHIP_RANGE___IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_SCALAR___NAME = DATA_RELATIONSHIP_RANGE___NAME;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_SCALAR___ABBREV_IRI = DATA_RELATIONSHIP_RANGE___ABBREV_IRI;

	/**
	 * The number of operations of the '<em>Data Relationship To Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_SCALAR_OPERATION_COUNT = DATA_RELATIONSHIP_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipToStructureImpl <em>Data Relationship To Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipToStructureImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipToStructure()
	 * @generated
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE = 24;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE__UUID = DATA_RELATIONSHIP_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE__RANGE = DATA_RELATIONSHIP_RANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Relationship To Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE_FEATURE_COUNT = DATA_RELATIONSHIP_RANGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE___UUID = DATA_RELATIONSHIP_RANGE___UUID;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE___IRI = DATA_RELATIONSHIP_RANGE___IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE___NAME = DATA_RELATIONSHIP_RANGE___NAME;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE___ABBREV_IRI = DATA_RELATIONSHIP_RANGE___ABBREV_IRI;

	/**
	 * The number of operations of the '<em>Data Relationship To Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_RELATIONSHIP_TO_STRUCTURE_OPERATION_COUNT = DATA_RELATIONSHIP_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyImpl <em>Entity Structured Data Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityStructuredDataProperty()
	 * @generated
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY = 25;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY__UUID = DATA_RELATIONSHIP__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY__TBOX = DATA_RELATIONSHIP__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY__NAME = DATA_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY__DOMAIN = DATA_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Identity Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY__IS_IDENTITY_CRITERIA = DATA_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY__RANGE = DATA_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entity Structured Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY_FEATURE_COUNT = DATA_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY___IRI = DATA_RELATIONSHIP___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY___ABBREV_IRI = DATA_RELATIONSHIP___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY___NAME = DATA_RELATIONSHIP___NAME;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY___RELATION_DOMAIN = DATA_RELATIONSHIP___RELATION_DOMAIN;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY___RELATION_RANGE = DATA_RELATIONSHIP___RELATION_RANGE;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY___UUID = DATA_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY___SOURCE = DATA_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY___TARGET = DATA_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Entity Structured Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_STRUCTURED_DATA_PROPERTY_OPERATION_COUNT = DATA_RELATIONSHIP_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyImpl <em>Entity Scalar Data Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataProperty()
	 * @generated
	 */
	int ENTITY_SCALAR_DATA_PROPERTY = 26;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY__UUID = DATA_RELATIONSHIP__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY__TBOX = DATA_RELATIONSHIP__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY__NAME = DATA_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY__DOMAIN = DATA_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Identity Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY__IS_IDENTITY_CRITERIA = DATA_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY__RANGE = DATA_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entity Scalar Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_FEATURE_COUNT = DATA_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY___IRI = DATA_RELATIONSHIP___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY___ABBREV_IRI = DATA_RELATIONSHIP___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY___NAME = DATA_RELATIONSHIP___NAME;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY___RELATION_DOMAIN = DATA_RELATIONSHIP___RELATION_DOMAIN;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY___RELATION_RANGE = DATA_RELATIONSHIP___RELATION_RANGE;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY___UUID = DATA_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY___SOURCE = DATA_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY___TARGET = DATA_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Entity Scalar Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_OPERATION_COUNT = DATA_RELATIONSHIP_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StructuredDataPropertyImpl <em>Structured Data Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.StructuredDataPropertyImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getStructuredDataProperty()
	 * @generated
	 */
	int STRUCTURED_DATA_PROPERTY = 27;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY__UUID = DATA_RELATIONSHIP__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY__TBOX = DATA_RELATIONSHIP__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY__NAME = DATA_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY__DOMAIN = DATA_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY__RANGE = DATA_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Structured Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_FEATURE_COUNT = DATA_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY___IRI = DATA_RELATIONSHIP___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY___ABBREV_IRI = DATA_RELATIONSHIP___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY___NAME = DATA_RELATIONSHIP___NAME;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY___RELATION_DOMAIN = DATA_RELATIONSHIP___RELATION_DOMAIN;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY___RELATION_RANGE = DATA_RELATIONSHIP___RELATION_RANGE;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY___UUID = DATA_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY___SOURCE = DATA_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY___TARGET = DATA_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Structured Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_OPERATION_COUNT = DATA_RELATIONSHIP_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarDataPropertyImpl <em>Scalar Data Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarDataPropertyImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getScalarDataProperty()
	 * @generated
	 */
	int SCALAR_DATA_PROPERTY = 28;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY__UUID = DATA_RELATIONSHIP__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY__TBOX = DATA_RELATIONSHIP__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY__NAME = DATA_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY__DOMAIN = DATA_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY__RANGE = DATA_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scalar Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_FEATURE_COUNT = DATA_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY___IRI = DATA_RELATIONSHIP___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY___ABBREV_IRI = DATA_RELATIONSHIP___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY___NAME = DATA_RELATIONSHIP___NAME;

	/**
	 * The operation id for the '<em>Relation Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY___RELATION_DOMAIN = DATA_RELATIONSHIP___RELATION_DOMAIN;

	/**
	 * The operation id for the '<em>Relation Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY___RELATION_RANGE = DATA_RELATIONSHIP___RELATION_RANGE;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY___UUID = DATA_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY___SOURCE = DATA_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY___TARGET = DATA_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Scalar Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_OPERATION_COUNT = DATA_RELATIONSHIP_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.StructureImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 29;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__UUID = DATATYPE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__TBOX = DATATYPE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__NAME = DATATYPE__NAME;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___IRI = DATATYPE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___ABBREV_IRI = DATATYPE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___NAME = DATATYPE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___UUID = DATATYPE___UUID;

	/**
	 * The number of operations of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_OPERATION_COUNT = DATATYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TermAxiomImpl <em>Term Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TermAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTermAxiom()
	 * @generated
	 */
	int TERM_AXIOM = 30;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_AXIOM__UUID = TERMINOLOGY_BOX_STATEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_AXIOM__TBOX = TERMINOLOGY_BOX_STATEMENT__TBOX;

	/**
	 * The number of structural features of the '<em>Term Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_AXIOM_FEATURE_COUNT = TERMINOLOGY_BOX_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_AXIOM___UUID = TERMINOLOGY_BOX_STATEMENT___UUID;

	/**
	 * The number of operations of the '<em>Term Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_AXIOM_OPERATION_COUNT = TERMINOLOGY_BOX_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRestrictionAxiomImpl <em>Entity Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRestrictionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityRestrictionAxiom()
	 * @generated
	 */
	int ENTITY_RESTRICTION_AXIOM = 31;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RESTRICTION_AXIOM__UUID = TERM_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RESTRICTION_AXIOM__TBOX = TERM_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Restricted Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION = TERM_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE = TERM_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Restricted Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN = TERM_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entity Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RESTRICTION_AXIOM_FEATURE_COUNT = TERM_AXIOM_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RESTRICTION_AXIOM___UUID = TERM_AXIOM___UUID;

	/**
	 * The number of operations of the '<em>Entity Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_RESTRICTION_AXIOM_OPERATION_COUNT = TERM_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityExistentialRestrictionAxiomImpl <em>Entity Existential Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityExistentialRestrictionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityExistentialRestrictionAxiom()
	 * @generated
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM = 32;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM__UUID = ENTITY_RESTRICTION_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM__TBOX = ENTITY_RESTRICTION_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Restricted Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM__RESTRICTED_RELATION = ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM__RESTRICTED_RANGE = ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE;

	/**
	 * The feature id for the '<em><b>Restricted Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM__RESTRICTED_DOMAIN = ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN;

	/**
	 * The number of structural features of the '<em>Entity Existential Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_FEATURE_COUNT = ENTITY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM___UUID = ENTITY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity Existential Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EXISTENTIAL_RESTRICTION_AXIOM_OPERATION_COUNT = ENTITY_RESTRICTION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityUniversalRestrictionAxiomImpl <em>Entity Universal Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityUniversalRestrictionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityUniversalRestrictionAxiom()
	 * @generated
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM = 33;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM__UUID = ENTITY_RESTRICTION_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM__TBOX = ENTITY_RESTRICTION_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Restricted Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM__RESTRICTED_RELATION = ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM__RESTRICTED_RANGE = ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE;

	/**
	 * The feature id for the '<em><b>Restricted Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM__RESTRICTED_DOMAIN = ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN;

	/**
	 * The number of structural features of the '<em>Entity Universal Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM_FEATURE_COUNT = ENTITY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM___UUID = ENTITY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity Universal Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_UNIVERSAL_RESTRICTION_AXIOM_OPERATION_COUNT = ENTITY_RESTRICTION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SpecializationAxiomImpl <em>Specialization Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.SpecializationAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getSpecializationAxiom()
	 * @generated
	 */
	int SPECIALIZATION_AXIOM = 34;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM__UUID = TERM_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM__TBOX = TERM_AXIOM__TBOX;

	/**
	 * The number of structural features of the '<em>Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM_FEATURE_COUNT = TERM_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM___UUID = TERM_AXIOM___UUID;

	/**
	 * The operation id for the '<em>Child</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM___CHILD = TERM_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM___PARENT = TERM_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_AXIOM_OPERATION_COUNT = TERM_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectSpecializationAxiomImpl <em>Aspect Specialization Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectSpecializationAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getAspectSpecializationAxiom()
	 * @generated
	 */
	int ASPECT_SPECIALIZATION_AXIOM = 35;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM__UUID = SPECIALIZATION_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM__TBOX = SPECIALIZATION_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Sub Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY = SPECIALIZATION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Aspect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT = SPECIALIZATION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aspect Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM_FEATURE_COUNT = SPECIALIZATION_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Child</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM___CHILD = SPECIALIZATION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM___PARENT = SPECIALIZATION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM___UUID = SPECIALIZATION_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Aspect Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_SPECIALIZATION_AXIOM_OPERATION_COUNT = SPECIALIZATION_AXIOM_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptSpecializationAxiomImpl <em>Concept Specialization Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptSpecializationAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getConceptSpecializationAxiom()
	 * @generated
	 */
	int CONCEPT_SPECIALIZATION_AXIOM = 36;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM__UUID = SPECIALIZATION_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM__TBOX = SPECIALIZATION_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Sub Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT = SPECIALIZATION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT = SPECIALIZATION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Concept Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM_FEATURE_COUNT = SPECIALIZATION_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Child</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM___CHILD = SPECIALIZATION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM___PARENT = SPECIALIZATION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM___UUID = SPECIALIZATION_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Concept Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_SPECIALIZATION_AXIOM_OPERATION_COUNT = SPECIALIZATION_AXIOM_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipSpecializationAxiomImpl <em>Reified Relationship Specialization Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipSpecializationAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getReifiedRelationshipSpecializationAxiom()
	 * @generated
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM = 37;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__UUID = SPECIALIZATION_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__TBOX = SPECIALIZATION_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Sub Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP = SPECIALIZATION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP = SPECIALIZATION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reified Relationship Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_FEATURE_COUNT = SPECIALIZATION_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Child</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___CHILD = SPECIALIZATION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___PARENT = SPECIALIZATION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___UUID = SPECIALIZATION_AXIOM_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Reified Relationship Specialization Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM_OPERATION_COUNT = SPECIALIZATION_AXIOM_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyRestrictionAxiomImpl <em>Entity Scalar Data Property Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyRestrictionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataPropertyRestrictionAxiom()
	 * @generated
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM = 38;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__UUID = TERM_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__TBOX = TERM_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Restricted Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY = TERM_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scalar Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY = TERM_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entity Scalar Data Property Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT = TERM_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM___UUID = TERM_AXIOM___UUID;

	/**
	 * The number of operations of the '<em>Entity Scalar Data Property Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT = TERM_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyExistentialRestrictionAxiomImpl <em>Entity Scalar Data Property Existential Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyExistentialRestrictionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataPropertyExistentialRestrictionAxiom()
	 * @generated
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM = 39;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__UUID = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__TBOX = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Restricted Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__RESTRICTED_ENTITY = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY;

	/**
	 * The feature id for the '<em><b>Scalar Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_PROPERTY = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY;

	/**
	 * The feature id for the '<em><b>Scalar Restriction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Scalar Data Property Existential Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_FEATURE_COUNT = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM___UUID = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity Scalar Data Property Existential Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM_OPERATION_COUNT = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyUniversalRestrictionAxiomImpl <em>Entity Scalar Data Property Universal Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyUniversalRestrictionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataPropertyUniversalRestrictionAxiom()
	 * @generated
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM = 40;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__UUID = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__TBOX = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Restricted Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__RESTRICTED_ENTITY = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY;

	/**
	 * The feature id for the '<em><b>Scalar Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_PROPERTY = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY;

	/**
	 * The feature id for the '<em><b>Scalar Restriction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Scalar Data Property Universal Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_FEATURE_COUNT = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM___UUID = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity Scalar Data Property Universal Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM_OPERATION_COUNT = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyParticularRestrictionAxiomImpl <em>Entity Scalar Data Property Particular Restriction Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyParticularRestrictionAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataPropertyParticularRestrictionAxiom()
	 * @generated
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM = 41;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__UUID = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__TBOX = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Restricted Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__RESTRICTED_ENTITY = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY;

	/**
	 * The feature id for the '<em><b>Scalar Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__SCALAR_PROPERTY = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY;

	/**
	 * The feature id for the '<em><b>Literal Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__LITERAL_VALUE = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Scalar Data Property Particular Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_FEATURE_COUNT = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity Scalar Data Property Particular Restriction Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM_OPERATION_COUNT = ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictedDataRangeImpl <em>Restricted Data Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictedDataRangeImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getRestrictedDataRange()
	 * @generated
	 */
	int RESTRICTED_DATA_RANGE = 42;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE__UUID = DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE__TBOX = DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE__NAME = DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE__RESTRICTED_RANGE = DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Restricted Data Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE_FEATURE_COUNT = DATA_RANGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE___IRI = DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE___ABBREV_IRI = DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE___NAME = DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE___UUID = DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>Restricted Data Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTED_DATA_RANGE_OPERATION_COUNT = DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.BinaryScalarRestrictionImpl <em>Binary Scalar Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.BinaryScalarRestrictionImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getBinaryScalarRestriction()
	 * @generated
	 */
	int BINARY_SCALAR_RESTRICTION = 43;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION__UUID = RESTRICTED_DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION__TBOX = RESTRICTED_DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION__NAME = RESTRICTED_DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION__RESTRICTED_RANGE = RESTRICTED_DATA_RANGE__RESTRICTED_RANGE;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION__LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION__MIN_LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION__MAX_LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION_FEATURE_COUNT = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION___IRI = RESTRICTED_DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION___ABBREV_IRI = RESTRICTED_DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION___NAME = RESTRICTED_DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION___UUID = RESTRICTED_DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>Binary Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_SCALAR_RESTRICTION_OPERATION_COUNT = RESTRICTED_DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.IRIScalarRestrictionImpl <em>IRI Scalar Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.IRIScalarRestrictionImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getIRIScalarRestriction()
	 * @generated
	 */
	int IRI_SCALAR_RESTRICTION = 44;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION__UUID = RESTRICTED_DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION__TBOX = RESTRICTED_DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION__NAME = RESTRICTED_DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION__RESTRICTED_RANGE = RESTRICTED_DATA_RANGE__RESTRICTED_RANGE;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION__LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION__MIN_LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION__MAX_LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION__PATTERN = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>IRI Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION_FEATURE_COUNT = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION___IRI = RESTRICTED_DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION___ABBREV_IRI = RESTRICTED_DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION___NAME = RESTRICTED_DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION___UUID = RESTRICTED_DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>IRI Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRI_SCALAR_RESTRICTION_OPERATION_COUNT = RESTRICTED_DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.NumericScalarRestrictionImpl <em>Numeric Scalar Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.NumericScalarRestrictionImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getNumericScalarRestriction()
	 * @generated
	 */
	int NUMERIC_SCALAR_RESTRICTION = 45;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION__UUID = RESTRICTED_DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION__TBOX = RESTRICTED_DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION__NAME = RESTRICTED_DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION__RESTRICTED_RANGE = RESTRICTED_DATA_RANGE__RESTRICTED_RANGE;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Numeric Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION_FEATURE_COUNT = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION___IRI = RESTRICTED_DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION___ABBREV_IRI = RESTRICTED_DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION___NAME = RESTRICTED_DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION___UUID = RESTRICTED_DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>Numeric Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_SCALAR_RESTRICTION_OPERATION_COUNT = RESTRICTED_DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl <em>Plain Literal Scalar Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getPlainLiteralScalarRestriction()
	 * @generated
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION = 46;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__UUID = RESTRICTED_DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__TBOX = RESTRICTED_DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__NAME = RESTRICTED_DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__RESTRICTED_RANGE = RESTRICTED_DATA_RANGE__RESTRICTED_RANGE;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Lang Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Plain Literal Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION_FEATURE_COUNT = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION___IRI = RESTRICTED_DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION___ABBREV_IRI = RESTRICTED_DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION___NAME = RESTRICTED_DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION___UUID = RESTRICTED_DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>Plain Literal Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_LITERAL_SCALAR_RESTRICTION_OPERATION_COUNT = RESTRICTED_DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StringScalarRestrictionImpl <em>String Scalar Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.StringScalarRestrictionImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getStringScalarRestriction()
	 * @generated
	 */
	int STRING_SCALAR_RESTRICTION = 47;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION__UUID = RESTRICTED_DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION__TBOX = RESTRICTED_DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION__NAME = RESTRICTED_DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION__RESTRICTED_RANGE = RESTRICTED_DATA_RANGE__RESTRICTED_RANGE;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION__LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION__MIN_LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION__MAX_LENGTH = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION__PATTERN = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>String Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION_FEATURE_COUNT = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION___IRI = RESTRICTED_DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION___ABBREV_IRI = RESTRICTED_DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION___NAME = RESTRICTED_DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION___UUID = RESTRICTED_DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>String Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SCALAR_RESTRICTION_OPERATION_COUNT = RESTRICTED_DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TimeScalarRestrictionImpl <em>Time Scalar Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TimeScalarRestrictionImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTimeScalarRestriction()
	 * @generated
	 */
	int TIME_SCALAR_RESTRICTION = 48;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION__UUID = RESTRICTED_DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION__TBOX = RESTRICTED_DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION__NAME = RESTRICTED_DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION__RESTRICTED_RANGE = RESTRICTED_DATA_RANGE__RESTRICTED_RANGE;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Time Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION_FEATURE_COUNT = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION___IRI = RESTRICTED_DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION___ABBREV_IRI = RESTRICTED_DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION___NAME = RESTRICTED_DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION___UUID = RESTRICTED_DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>Time Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SCALAR_RESTRICTION_OPERATION_COUNT = RESTRICTED_DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SynonymScalarRestrictionImpl <em>Synonym Scalar Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.SynonymScalarRestrictionImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getSynonymScalarRestriction()
	 * @generated
	 */
	int SYNONYM_SCALAR_RESTRICTION = 49;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION__UUID = RESTRICTED_DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION__TBOX = RESTRICTED_DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION__NAME = RESTRICTED_DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION__RESTRICTED_RANGE = RESTRICTED_DATA_RANGE__RESTRICTED_RANGE;

	/**
	 * The number of structural features of the '<em>Synonym Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION_FEATURE_COUNT = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION___IRI = RESTRICTED_DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION___ABBREV_IRI = RESTRICTED_DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION___NAME = RESTRICTED_DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION___UUID = RESTRICTED_DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>Synonym Scalar Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNONYM_SCALAR_RESTRICTION_OPERATION_COUNT = RESTRICTED_DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfRestrictionImpl <em>Scalar One Of Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfRestrictionImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getScalarOneOfRestriction()
	 * @generated
	 */
	int SCALAR_ONE_OF_RESTRICTION = 50;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION__UUID = RESTRICTED_DATA_RANGE__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION__TBOX = RESTRICTED_DATA_RANGE__TBOX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION__NAME = RESTRICTED_DATA_RANGE__NAME;

	/**
	 * The feature id for the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION__RESTRICTED_RANGE = RESTRICTED_DATA_RANGE__RESTRICTED_RANGE;

	/**
	 * The number of structural features of the '<em>Scalar One Of Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION_FEATURE_COUNT = RESTRICTED_DATA_RANGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION___IRI = RESTRICTED_DATA_RANGE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION___ABBREV_IRI = RESTRICTED_DATA_RANGE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION___NAME = RESTRICTED_DATA_RANGE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION___UUID = RESTRICTED_DATA_RANGE___UUID;

	/**
	 * The number of operations of the '<em>Scalar One Of Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_RESTRICTION_OPERATION_COUNT = RESTRICTED_DATA_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfLiteralAxiomImpl <em>Scalar One Of Literal Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfLiteralAxiomImpl
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getScalarOneOfLiteralAxiom()
	 * @generated
	 */
	int SCALAR_ONE_OF_LITERAL_AXIOM = 51;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_LITERAL_AXIOM__UUID = TERM_AXIOM__UUID;

	/**
	 * The feature id for the '<em><b>Tbox</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_LITERAL_AXIOM__TBOX = TERM_AXIOM__TBOX;

	/**
	 * The feature id for the '<em><b>Axiom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM = TERM_AXIOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_LITERAL_AXIOM__VALUE = TERM_AXIOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scalar One Of Literal Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_LITERAL_AXIOM_FEATURE_COUNT = TERM_AXIOM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_LITERAL_AXIOM___UUID = TERM_AXIOM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Scalar One Of Literal Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_ONE_OF_LITERAL_AXIOM_OPERATION_COUNT = TERM_AXIOM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind <em>Terminology Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyKind()
	 * @generated
	 */
	int TERMINOLOGY_KIND = 52;


	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox <em>Terminology Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
	 * @generated
	 */
	EClass getTerminologyBox();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getKind()
	 * @see #getTerminologyBox()
	 * @generated
	 */
	EAttribute getTerminologyBox_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getBoxAxioms <em>Box Axioms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Box Axioms</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getBoxAxioms()
	 * @see #getTerminologyBox()
	 * @generated
	 */
	EReference getTerminologyBox_BoxAxioms();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getBoxStatements <em>Box Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Box Statements</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox#getBoxStatements()
	 * @see #getTerminologyBox()
	 * @generated
	 */
	EReference getTerminologyBox_BoxStatements();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement <em>Terminology Box Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Box Statement</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement
	 * @generated
	 */
	EClass getTerminologyBoxStatement();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement#getTbox <em>Tbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tbox</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement#getTbox()
	 * @see #getTerminologyBoxStatement()
	 * @generated
	 */
	EReference getTerminologyBoxStatement_Tbox();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom <em>Terminology Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom
	 * @generated
	 */
	EClass getTerminologyAxiom();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom#source()
	 * @generated
	 */
	EOperation getTerminologyAxiom__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom#sourceModule() <em>Source Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source Module</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom#sourceModule()
	 * @generated
	 */
	EOperation getTerminologyAxiom__SourceModule();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom#target()
	 * @generated
	 */
	EOperation getTerminologyAxiom__Target();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom#targetModule() <em>Target Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Module</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom#targetModule()
	 * @generated
	 */
	EOperation getTerminologyAxiom__TargetModule();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom <em>Terminology Box Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Box Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom
	 * @generated
	 */
	EClass getTerminologyBoxAxiom();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom#getTbox <em>Tbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tbox</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom#getTbox()
	 * @see #getTerminologyBoxAxiom()
	 * @generated
	 */
	EReference getTerminologyBoxAxiom_Tbox();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom <em>Terminology Extension Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Extension Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom
	 * @generated
	 */
	EClass getTerminologyExtensionAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#getExtendedTerminology <em>Extended Terminology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Terminology</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#getExtendedTerminology()
	 * @see #getTerminologyExtensionAxiom()
	 * @generated
	 */
	EReference getTerminologyExtensionAxiom_ExtendedTerminology();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#extendingTerminology() <em>Extending Terminology</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Extending Terminology</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#extendingTerminology()
	 * @generated
	 */
	EOperation getTerminologyExtensionAxiom__ExtendingTerminology();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#source()
	 * @generated
	 */
	EOperation getTerminologyExtensionAxiom__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#target()
	 * @generated
	 */
	EOperation getTerminologyExtensionAxiom__Target();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom#uuid()
	 * @generated
	 */
	EOperation getTerminologyExtensionAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.Term#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Term#getName()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_Name();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.Term#iri() <em>Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Iri</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Term#iri()
	 * @generated
	 */
	EOperation getTerm__Iri();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.Term#abbrevIRI() <em>Abbrev IRI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Abbrev IRI</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Term#abbrevIRI()
	 * @generated
	 */
	EOperation getTerm__AbbrevIRI();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.Term#name() <em>Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Name</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Term#name()
	 * @generated
	 */
	EOperation getTerm__Name();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.Term#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Term#uuid()
	 * @generated
	 */
	EOperation getTerm__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.UnaryTermKind <em>Unary Term Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Term Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.UnaryTermKind
	 * @generated
	 */
	EClass getUnaryTermKind();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind <em>Directed Binary Relationship Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directed Binary Relationship Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind
	 * @generated
	 */
	EClass getDirectedBinaryRelationshipKind();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind#relationDomain() <em>Relation Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Relation Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind#relationDomain()
	 * @generated
	 */
	EOperation getDirectedBinaryRelationshipKind__RelationDomain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind#relationRange() <em>Relation Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Relation Range</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind#relationRange()
	 * @generated
	 */
	EOperation getDirectedBinaryRelationshipKind__RelationRange();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity <em>Conceptual Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conceptual Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity
	 * @generated
	 */
	EClass getConceptualEntity();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Aspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Aspect
	 * @generated
	 */
	EClass getAspect();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Concept
	 * @generated
	 */
	EClass getConcept();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship <em>Entity Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
	 * @generated
	 */
	EClass getEntityRelationship();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#getSource()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EReference getEntityRelationship_Source();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#getTarget()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EReference getEntityRelationship_Target();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsFunctional <em>Is Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Functional</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsFunctional()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsFunctional();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsInverseFunctional <em>Is Inverse Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Inverse Functional</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsInverseFunctional()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsInverseFunctional();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsEssential <em>Is Essential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Essential</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsEssential()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsEssential();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsInverseEssential <em>Is Inverse Essential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Inverse Essential</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsInverseEssential()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsInverseEssential();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsSymmetric <em>Is Symmetric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Symmetric</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsSymmetric()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsSymmetric();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsAsymmetric <em>Is Asymmetric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Asymmetric</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsAsymmetric()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsAsymmetric();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsReflexive <em>Is Reflexive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Reflexive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsReflexive()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsReflexive();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsIrreflexive <em>Is Irreflexive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Irreflexive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsIrreflexive()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsIrreflexive();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsTransitive <em>Is Transitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transitive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#isIsTransitive()
	 * @see #getEntityRelationship()
	 * @generated
	 */
	EAttribute getEntityRelationship_IsTransitive();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#relationDomain() <em>Relation Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Relation Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#relationDomain()
	 * @generated
	 */
	EOperation getEntityRelationship__RelationDomain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#relationRange() <em>Relation Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Relation Range</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship#relationRange()
	 * @generated
	 */
	EOperation getEntityRelationship__RelationRange();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship <em>Reified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reified Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
	 * @generated
	 */
	EClass getReifiedRelationship();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getUnreifiedPropertyName <em>Unreified Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unreified Property Name</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getUnreifiedPropertyName()
	 * @see #getReifiedRelationship()
	 * @generated
	 */
	EAttribute getReifiedRelationship_UnreifiedPropertyName();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getUnreifiedInversePropertyName <em>Unreified Inverse Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unreified Inverse Property Name</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getUnreifiedInversePropertyName()
	 * @see #getReifiedRelationship()
	 * @generated
	 */
	EAttribute getReifiedRelationship_UnreifiedInversePropertyName();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship <em>Unreified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unreified Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
	 * @generated
	 */
	EClass getUnreifiedRelationship();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Datatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Datatype</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Datatype
	 * @generated
	 */
	EClass getDatatype();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRange <em>Data Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRange
	 * @generated
	 */
	EClass getDataRange();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Scalar <em>Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Scalar
	 * @generated
	 */
	EClass getScalar();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship <em>Data Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship
	 * @generated
	 */
	EClass getDataRelationship();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship#source()
	 * @generated
	 */
	EOperation getDataRelationship__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship#relationDomain() <em>Relation Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Relation Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship#relationDomain()
	 * @generated
	 */
	EOperation getDataRelationship__RelationDomain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship#target()
	 * @generated
	 */
	EOperation getDataRelationship__Target();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship#relationRange() <em>Relation Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Relation Range</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship#relationRange()
	 * @generated
	 */
	EOperation getDataRelationship__RelationRange();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipDomain <em>Data Relationship Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Relationship Domain</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipDomain
	 * @generated
	 */
	EClass getDataRelationshipDomain();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity <em>Data Relationship From Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Relationship From Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity
	 * @generated
	 */
	EClass getDataRelationshipFromEntity();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity#getDomain()
	 * @see #getDataRelationshipFromEntity()
	 * @generated
	 */
	EReference getDataRelationshipFromEntity_Domain();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity#isIsIdentityCriteria <em>Is Identity Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Identity Criteria</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity#isIsIdentityCriteria()
	 * @see #getDataRelationshipFromEntity()
	 * @generated
	 */
	EAttribute getDataRelationshipFromEntity_IsIdentityCriteria();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromStructure <em>Data Relationship From Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Relationship From Structure</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromStructure
	 * @generated
	 */
	EClass getDataRelationshipFromStructure();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromStructure#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromStructure#getDomain()
	 * @see #getDataRelationshipFromStructure()
	 * @generated
	 */
	EReference getDataRelationshipFromStructure_Domain();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipRange <em>Data Relationship Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Relationship Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipRange
	 * @generated
	 */
	EClass getDataRelationshipRange();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar <em>Data Relationship To Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Relationship To Scalar</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar
	 * @generated
	 */
	EClass getDataRelationshipToScalar();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar#getRange()
	 * @see #getDataRelationshipToScalar()
	 * @generated
	 */
	EReference getDataRelationshipToScalar_Range();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure <em>Data Relationship To Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Relationship To Structure</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure
	 * @generated
	 */
	EClass getDataRelationshipToStructure();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure#getRange()
	 * @see #getDataRelationshipToStructure()
	 * @generated
	 */
	EReference getDataRelationshipToStructure_Range();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty <em>Entity Structured Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Structured Data Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
	 * @generated
	 */
	EClass getEntityStructuredDataProperty();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty#uuid()
	 * @generated
	 */
	EOperation getEntityStructuredDataProperty__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty#source()
	 * @generated
	 */
	EOperation getEntityStructuredDataProperty__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty#target()
	 * @generated
	 */
	EOperation getEntityStructuredDataProperty__Target();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty <em>Entity Scalar Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Scalar Data Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
	 * @generated
	 */
	EClass getEntityScalarDataProperty();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty#uuid()
	 * @generated
	 */
	EOperation getEntityScalarDataProperty__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty#source()
	 * @generated
	 */
	EOperation getEntityScalarDataProperty__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty#target()
	 * @generated
	 */
	EOperation getEntityScalarDataProperty__Target();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty <em>Structured Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structured Data Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
	 * @generated
	 */
	EClass getStructuredDataProperty();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty#uuid()
	 * @generated
	 */
	EOperation getStructuredDataProperty__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty#source()
	 * @generated
	 */
	EOperation getStructuredDataProperty__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty#target()
	 * @generated
	 */
	EOperation getStructuredDataProperty__Target();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty <em>Scalar Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Data Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
	 * @generated
	 */
	EClass getScalarDataProperty();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty#uuid()
	 * @generated
	 */
	EOperation getScalarDataProperty__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty#source()
	 * @generated
	 */
	EOperation getScalarDataProperty__Source();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty#target()
	 * @generated
	 */
	EOperation getScalarDataProperty__Target();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TermAxiom <em>Term Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TermAxiom
	 * @generated
	 */
	EClass getTermAxiom();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom <em>Entity Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Restriction Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
	 * @generated
	 */
	EClass getEntityRestrictionAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedRelation <em>Restricted Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Restricted Relation</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedRelation()
	 * @see #getEntityRestrictionAxiom()
	 * @generated
	 */
	EReference getEntityRestrictionAxiom_RestrictedRelation();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedRange <em>Restricted Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Restricted Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedRange()
	 * @see #getEntityRestrictionAxiom()
	 * @generated
	 */
	EReference getEntityRestrictionAxiom_RestrictedRange();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedDomain <em>Restricted Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Restricted Domain</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom#getRestrictedDomain()
	 * @see #getEntityRestrictionAxiom()
	 * @generated
	 */
	EReference getEntityRestrictionAxiom_RestrictedDomain();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom <em>Entity Existential Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Existential Restriction Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
	 * @generated
	 */
	EClass getEntityExistentialRestrictionAxiom();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom#uuid()
	 * @generated
	 */
	EOperation getEntityExistentialRestrictionAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom <em>Entity Universal Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Universal Restriction Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
	 * @generated
	 */
	EClass getEntityUniversalRestrictionAxiom();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom#uuid()
	 * @generated
	 */
	EOperation getEntityUniversalRestrictionAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom <em>Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialization Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
	 * @generated
	 */
	EClass getSpecializationAxiom();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom#child() <em>Child</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Child</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom#child()
	 * @generated
	 */
	EOperation getSpecializationAxiom__Child();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom#parent() <em>Parent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parent</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom#parent()
	 * @generated
	 */
	EOperation getSpecializationAxiom__Parent();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom <em>Aspect Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect Specialization Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
	 * @generated
	 */
	EClass getAspectSpecializationAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#getSubEntity <em>Sub Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#getSubEntity()
	 * @see #getAspectSpecializationAxiom()
	 * @generated
	 */
	EReference getAspectSpecializationAxiom_SubEntity();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#getSuperAspect <em>Super Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Aspect</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#getSuperAspect()
	 * @see #getAspectSpecializationAxiom()
	 * @generated
	 */
	EReference getAspectSpecializationAxiom_SuperAspect();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#child() <em>Child</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Child</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#child()
	 * @generated
	 */
	EOperation getAspectSpecializationAxiom__Child();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#parent() <em>Parent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parent</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#parent()
	 * @generated
	 */
	EOperation getAspectSpecializationAxiom__Parent();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#uuid()
	 * @generated
	 */
	EOperation getAspectSpecializationAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom <em>Concept Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept Specialization Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
	 * @generated
	 */
	EClass getConceptSpecializationAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#getSubConcept <em>Sub Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub Concept</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#getSubConcept()
	 * @see #getConceptSpecializationAxiom()
	 * @generated
	 */
	EReference getConceptSpecializationAxiom_SubConcept();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#getSuperConcept <em>Super Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Concept</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#getSuperConcept()
	 * @see #getConceptSpecializationAxiom()
	 * @generated
	 */
	EReference getConceptSpecializationAxiom_SuperConcept();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#child() <em>Child</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Child</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#child()
	 * @generated
	 */
	EOperation getConceptSpecializationAxiom__Child();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#parent() <em>Parent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parent</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#parent()
	 * @generated
	 */
	EOperation getConceptSpecializationAxiom__Parent();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom#uuid()
	 * @generated
	 */
	EOperation getConceptSpecializationAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom <em>Reified Relationship Specialization Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reified Relationship Specialization Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom
	 * @generated
	 */
	EClass getReifiedRelationshipSpecializationAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#getSubRelationship <em>Sub Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#getSubRelationship()
	 * @see #getReifiedRelationshipSpecializationAxiom()
	 * @generated
	 */
	EReference getReifiedRelationshipSpecializationAxiom_SubRelationship();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#getSuperRelationship <em>Super Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#getSuperRelationship()
	 * @see #getReifiedRelationshipSpecializationAxiom()
	 * @generated
	 */
	EReference getReifiedRelationshipSpecializationAxiom_SuperRelationship();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#child() <em>Child</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Child</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#child()
	 * @generated
	 */
	EOperation getReifiedRelationshipSpecializationAxiom__Child();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#parent() <em>Parent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parent</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#parent()
	 * @generated
	 */
	EOperation getReifiedRelationshipSpecializationAxiom__Parent();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#uuid()
	 * @generated
	 */
	EOperation getReifiedRelationshipSpecializationAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom <em>Entity Scalar Data Property Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Scalar Data Property Restriction Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom
	 * @generated
	 */
	EClass getEntityScalarDataPropertyRestrictionAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Restricted Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom#getRestrictedEntity()
	 * @see #getEntityScalarDataPropertyRestrictionAxiom()
	 * @generated
	 */
	EReference getEntityScalarDataPropertyRestrictionAxiom_RestrictedEntity();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom#getScalarProperty <em>Scalar Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scalar Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom#getScalarProperty()
	 * @see #getEntityScalarDataPropertyRestrictionAxiom()
	 * @generated
	 */
	EReference getEntityScalarDataPropertyRestrictionAxiom_ScalarProperty();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom <em>Entity Scalar Data Property Existential Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Scalar Data Property Existential Restriction Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
	 * @generated
	 */
	EClass getEntityScalarDataPropertyExistentialRestrictionAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom#getScalarRestriction <em>Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom#getScalarRestriction()
	 * @see #getEntityScalarDataPropertyExistentialRestrictionAxiom()
	 * @generated
	 */
	EReference getEntityScalarDataPropertyExistentialRestrictionAxiom_ScalarRestriction();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom#uuid()
	 * @generated
	 */
	EOperation getEntityScalarDataPropertyExistentialRestrictionAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom <em>Entity Scalar Data Property Universal Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Scalar Data Property Universal Restriction Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
	 * @generated
	 */
	EClass getEntityScalarDataPropertyUniversalRestrictionAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom#getScalarRestriction <em>Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom#getScalarRestriction()
	 * @see #getEntityScalarDataPropertyUniversalRestrictionAxiom()
	 * @generated
	 */
	EReference getEntityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom#uuid()
	 * @generated
	 */
	EOperation getEntityScalarDataPropertyUniversalRestrictionAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom <em>Entity Scalar Data Property Particular Restriction Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Scalar Data Property Particular Restriction Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
	 * @generated
	 */
	EClass getEntityScalarDataPropertyParticularRestrictionAxiom();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom#getLiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom#getLiteralValue()
	 * @see #getEntityScalarDataPropertyParticularRestrictionAxiom()
	 * @generated
	 */
	EAttribute getEntityScalarDataPropertyParticularRestrictionAxiom_LiteralValue();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom#uuid()
	 * @generated
	 */
	EOperation getEntityScalarDataPropertyParticularRestrictionAxiom__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange <em>Restricted Data Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Restricted Data Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange
	 * @generated
	 */
	EClass getRestrictedDataRange();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange#getRestrictedRange <em>Restricted Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Restricted Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange#getRestrictedRange()
	 * @see #getRestrictedDataRange()
	 * @generated
	 */
	EReference getRestrictedDataRange_RestrictedRange();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction <em>Binary Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
	 * @generated
	 */
	EClass getBinaryScalarRestriction();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getLength()
	 * @see #getBinaryScalarRestriction()
	 * @generated
	 */
	EAttribute getBinaryScalarRestriction_Length();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getMinLength()
	 * @see #getBinaryScalarRestriction()
	 * @generated
	 */
	EAttribute getBinaryScalarRestriction_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction#getMaxLength()
	 * @see #getBinaryScalarRestriction()
	 * @generated
	 */
	EAttribute getBinaryScalarRestriction_MaxLength();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction <em>IRI Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRI Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
	 * @generated
	 */
	EClass getIRIScalarRestriction();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getLength()
	 * @see #getIRIScalarRestriction()
	 * @generated
	 */
	EAttribute getIRIScalarRestriction_Length();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getMinLength()
	 * @see #getIRIScalarRestriction()
	 * @generated
	 */
	EAttribute getIRIScalarRestriction_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getMaxLength()
	 * @see #getIRIScalarRestriction()
	 * @generated
	 */
	EAttribute getIRIScalarRestriction_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction#getPattern()
	 * @see #getIRIScalarRestriction()
	 * @generated
	 */
	EAttribute getIRIScalarRestriction_Pattern();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction <em>Numeric Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
	 * @generated
	 */
	EClass getNumericScalarRestriction();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Inclusive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinInclusive()
	 * @see #getNumericScalarRestriction()
	 * @generated
	 */
	EAttribute getNumericScalarRestriction_MinInclusive();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Inclusive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxInclusive()
	 * @see #getNumericScalarRestriction()
	 * @generated
	 */
	EAttribute getNumericScalarRestriction_MaxInclusive();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Exclusive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMinExclusive()
	 * @see #getNumericScalarRestriction()
	 * @generated
	 */
	EAttribute getNumericScalarRestriction_MinExclusive();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Exclusive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction#getMaxExclusive()
	 * @see #getNumericScalarRestriction()
	 * @generated
	 */
	EAttribute getNumericScalarRestriction_MaxExclusive();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction <em>Plain Literal Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plain Literal Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
	 * @generated
	 */
	EClass getPlainLiteralScalarRestriction();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getLength()
	 * @see #getPlainLiteralScalarRestriction()
	 * @generated
	 */
	EAttribute getPlainLiteralScalarRestriction_Length();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getMinLength()
	 * @see #getPlainLiteralScalarRestriction()
	 * @generated
	 */
	EAttribute getPlainLiteralScalarRestriction_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getMaxLength()
	 * @see #getPlainLiteralScalarRestriction()
	 * @generated
	 */
	EAttribute getPlainLiteralScalarRestriction_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getPattern()
	 * @see #getPlainLiteralScalarRestriction()
	 * @generated
	 */
	EAttribute getPlainLiteralScalarRestriction_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getLangRange <em>Lang Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction#getLangRange()
	 * @see #getPlainLiteralScalarRestriction()
	 * @generated
	 */
	EAttribute getPlainLiteralScalarRestriction_LangRange();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction <em>String Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
	 * @generated
	 */
	EClass getStringScalarRestriction();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getLength()
	 * @see #getStringScalarRestriction()
	 * @generated
	 */
	EAttribute getStringScalarRestriction_Length();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getMinLength()
	 * @see #getStringScalarRestriction()
	 * @generated
	 */
	EAttribute getStringScalarRestriction_MinLength();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Length</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getMaxLength()
	 * @see #getStringScalarRestriction()
	 * @generated
	 */
	EAttribute getStringScalarRestriction_MaxLength();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction#getPattern()
	 * @see #getStringScalarRestriction()
	 * @generated
	 */
	EAttribute getStringScalarRestriction_Pattern();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction <em>Time Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
	 * @generated
	 */
	EClass getTimeScalarRestriction();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Inclusive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMinInclusive()
	 * @see #getTimeScalarRestriction()
	 * @generated
	 */
	EAttribute getTimeScalarRestriction_MinInclusive();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Inclusive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMaxInclusive()
	 * @see #getTimeScalarRestriction()
	 * @generated
	 */
	EAttribute getTimeScalarRestriction_MaxInclusive();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Exclusive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMinExclusive()
	 * @see #getTimeScalarRestriction()
	 * @generated
	 */
	EAttribute getTimeScalarRestriction_MinExclusive();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Exclusive</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction#getMaxExclusive()
	 * @see #getTimeScalarRestriction()
	 * @generated
	 */
	EAttribute getTimeScalarRestriction_MaxExclusive();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction <em>Synonym Scalar Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Synonym Scalar Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
	 * @generated
	 */
	EClass getSynonymScalarRestriction();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction <em>Scalar One Of Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar One Of Restriction</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
	 * @generated
	 */
	EClass getScalarOneOfRestriction();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom <em>Scalar One Of Literal Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar One Of Literal Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
	 * @generated
	 */
	EClass getScalarOneOfLiteralAxiom();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#getAxiom <em>Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Axiom</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#getAxiom()
	 * @see #getScalarOneOfLiteralAxiom()
	 * @generated
	 */
	EReference getScalarOneOfLiteralAxiom_Axiom();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#getValue()
	 * @see #getScalarOneOfLiteralAxiom()
	 * @generated
	 */
	EAttribute getScalarOneOfLiteralAxiom_Value();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#uuid()
	 * @generated
	 */
	EOperation getScalarOneOfLiteralAxiom__Uuid();

	/**
	 * Returns the meta object for enum '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind <em>Terminology Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Terminology Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind
	 * @generated
	 */
	EEnum getTerminologyKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TerminologiesFactory getTerminologiesFactory();

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
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl <em>Terminology Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyBox()
		 * @generated
		 */
		EClass TERMINOLOGY_BOX = eINSTANCE.getTerminologyBox();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINOLOGY_BOX__KIND = eINSTANCE.getTerminologyBox_Kind();

		/**
		 * The meta object literal for the '<em><b>Box Axioms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_BOX__BOX_AXIOMS = eINSTANCE.getTerminologyBox_BoxAxioms();

		/**
		 * The meta object literal for the '<em><b>Box Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_BOX__BOX_STATEMENTS = eINSTANCE.getTerminologyBox_BoxStatements();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxStatementImpl <em>Terminology Box Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxStatementImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyBoxStatement()
		 * @generated
		 */
		EClass TERMINOLOGY_BOX_STATEMENT = eINSTANCE.getTerminologyBoxStatement();

		/**
		 * The meta object literal for the '<em><b>Tbox</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_BOX_STATEMENT__TBOX = eINSTANCE.getTerminologyBoxStatement_Tbox();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyAxiomImpl <em>Terminology Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyAxiom()
		 * @generated
		 */
		EClass TERMINOLOGY_AXIOM = eINSTANCE.getTerminologyAxiom();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_AXIOM___SOURCE = eINSTANCE.getTerminologyAxiom__Source();

		/**
		 * The meta object literal for the '<em><b>Source Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_AXIOM___SOURCE_MODULE = eINSTANCE.getTerminologyAxiom__SourceModule();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_AXIOM___TARGET = eINSTANCE.getTerminologyAxiom__Target();

		/**
		 * The meta object literal for the '<em><b>Target Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_AXIOM___TARGET_MODULE = eINSTANCE.getTerminologyAxiom__TargetModule();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxAxiomImpl <em>Terminology Box Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyBoxAxiom()
		 * @generated
		 */
		EClass TERMINOLOGY_BOX_AXIOM = eINSTANCE.getTerminologyBoxAxiom();

		/**
		 * The meta object literal for the '<em><b>Tbox</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_BOX_AXIOM__TBOX = eINSTANCE.getTerminologyBoxAxiom_Tbox();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyExtensionAxiomImpl <em>Terminology Extension Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyExtensionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyExtensionAxiom()
		 * @generated
		 */
		EClass TERMINOLOGY_EXTENSION_AXIOM = eINSTANCE.getTerminologyExtensionAxiom();

		/**
		 * The meta object literal for the '<em><b>Extended Terminology</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY = eINSTANCE.getTerminologyExtensionAxiom_ExtendedTerminology();

		/**
		 * The meta object literal for the '<em><b>Extending Terminology</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_EXTENSION_AXIOM___EXTENDING_TERMINOLOGY = eINSTANCE.getTerminologyExtensionAxiom__ExtendingTerminology();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_EXTENSION_AXIOM___SOURCE = eINSTANCE.getTerminologyExtensionAxiom__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_EXTENSION_AXIOM___TARGET = eINSTANCE.getTerminologyExtensionAxiom__Target();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERMINOLOGY_EXTENSION_AXIOM___UUID = eINSTANCE.getTerminologyExtensionAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TermImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__NAME = eINSTANCE.getTerm_Name();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERM___IRI = eINSTANCE.getTerm__Iri();

		/**
		 * The meta object literal for the '<em><b>Abbrev IRI</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERM___ABBREV_IRI = eINSTANCE.getTerm__AbbrevIRI();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERM___NAME = eINSTANCE.getTerm__Name();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TERM___UUID = eINSTANCE.getTerm__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.UnaryTermKindImpl <em>Unary Term Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.UnaryTermKindImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getUnaryTermKind()
		 * @generated
		 */
		EClass UNARY_TERM_KIND = eINSTANCE.getUnaryTermKind();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DirectedBinaryRelationshipKindImpl <em>Directed Binary Relationship Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DirectedBinaryRelationshipKindImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDirectedBinaryRelationshipKind()
		 * @generated
		 */
		EClass DIRECTED_BINARY_RELATIONSHIP_KIND = eINSTANCE.getDirectedBinaryRelationshipKind();

		/**
		 * The meta object literal for the '<em><b>Relation Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_DOMAIN = eINSTANCE.getDirectedBinaryRelationshipKind__RelationDomain();

		/**
		 * The meta object literal for the '<em><b>Relation Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_RANGE = eINSTANCE.getDirectedBinaryRelationshipKind__RelationRange();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptualEntityImpl <em>Conceptual Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptualEntityImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getConceptualEntity()
		 * @generated
		 */
		EClass CONCEPTUAL_ENTITY = eINSTANCE.getConceptualEntity();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectImpl <em>Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getAspect()
		 * @generated
		 */
		EClass ASPECT = eINSTANCE.getAspect();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptImpl <em>Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getConcept()
		 * @generated
		 */
		EClass CONCEPT = eINSTANCE.getConcept();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRelationshipImpl <em>Entity Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityRelationship()
		 * @generated
		 */
		EClass ENTITY_RELATIONSHIP = eINSTANCE.getEntityRelationship();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_RELATIONSHIP__SOURCE = eINSTANCE.getEntityRelationship_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_RELATIONSHIP__TARGET = eINSTANCE.getEntityRelationship_Target();

		/**
		 * The meta object literal for the '<em><b>Is Functional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_FUNCTIONAL = eINSTANCE.getEntityRelationship_IsFunctional();

		/**
		 * The meta object literal for the '<em><b>Is Inverse Functional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL = eINSTANCE.getEntityRelationship_IsInverseFunctional();

		/**
		 * The meta object literal for the '<em><b>Is Essential</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_ESSENTIAL = eINSTANCE.getEntityRelationship_IsEssential();

		/**
		 * The meta object literal for the '<em><b>Is Inverse Essential</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL = eINSTANCE.getEntityRelationship_IsInverseEssential();

		/**
		 * The meta object literal for the '<em><b>Is Symmetric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_SYMMETRIC = eINSTANCE.getEntityRelationship_IsSymmetric();

		/**
		 * The meta object literal for the '<em><b>Is Asymmetric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_ASYMMETRIC = eINSTANCE.getEntityRelationship_IsAsymmetric();

		/**
		 * The meta object literal for the '<em><b>Is Reflexive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_REFLEXIVE = eINSTANCE.getEntityRelationship_IsReflexive();

		/**
		 * The meta object literal for the '<em><b>Is Irreflexive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_IRREFLEXIVE = eINSTANCE.getEntityRelationship_IsIrreflexive();

		/**
		 * The meta object literal for the '<em><b>Is Transitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_RELATIONSHIP__IS_TRANSITIVE = eINSTANCE.getEntityRelationship_IsTransitive();

		/**
		 * The meta object literal for the '<em><b>Relation Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_RELATIONSHIP___RELATION_DOMAIN = eINSTANCE.getEntityRelationship__RelationDomain();

		/**
		 * The meta object literal for the '<em><b>Relation Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_RELATIONSHIP___RELATION_RANGE = eINSTANCE.getEntityRelationship__RelationRange();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl <em>Reified Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getReifiedRelationship()
		 * @generated
		 */
		EClass REIFIED_RELATIONSHIP = eINSTANCE.getReifiedRelationship();

		/**
		 * The meta object literal for the '<em><b>Unreified Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REIFIED_RELATIONSHIP__UNREIFIED_PROPERTY_NAME = eINSTANCE.getReifiedRelationship_UnreifiedPropertyName();

		/**
		 * The meta object literal for the '<em><b>Unreified Inverse Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REIFIED_RELATIONSHIP__UNREIFIED_INVERSE_PROPERTY_NAME = eINSTANCE.getReifiedRelationship_UnreifiedInversePropertyName();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.UnreifiedRelationshipImpl <em>Unreified Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.UnreifiedRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getUnreifiedRelationship()
		 * @generated
		 */
		EClass UNREIFIED_RELATIONSHIP = eINSTANCE.getUnreifiedRelationship();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DatatypeImpl <em>Datatype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DatatypeImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDatatype()
		 * @generated
		 */
		EClass DATATYPE = eINSTANCE.getDatatype();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRangeImpl <em>Data Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRangeImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRange()
		 * @generated
		 */
		EClass DATA_RANGE = eINSTANCE.getDataRange();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarImpl <em>Scalar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getScalar()
		 * @generated
		 */
		EClass SCALAR = eINSTANCE.getScalar();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipImpl <em>Data Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationship()
		 * @generated
		 */
		EClass DATA_RELATIONSHIP = eINSTANCE.getDataRelationship();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_RELATIONSHIP___SOURCE = eINSTANCE.getDataRelationship__Source();

		/**
		 * The meta object literal for the '<em><b>Relation Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_RELATIONSHIP___RELATION_DOMAIN = eINSTANCE.getDataRelationship__RelationDomain();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_RELATIONSHIP___TARGET = eINSTANCE.getDataRelationship__Target();

		/**
		 * The meta object literal for the '<em><b>Relation Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_RELATIONSHIP___RELATION_RANGE = eINSTANCE.getDataRelationship__RelationRange();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipDomainImpl <em>Data Relationship Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipDomainImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipDomain()
		 * @generated
		 */
		EClass DATA_RELATIONSHIP_DOMAIN = eINSTANCE.getDataRelationshipDomain();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromEntityImpl <em>Data Relationship From Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromEntityImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipFromEntity()
		 * @generated
		 */
		EClass DATA_RELATIONSHIP_FROM_ENTITY = eINSTANCE.getDataRelationshipFromEntity();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN = eINSTANCE.getDataRelationshipFromEntity_Domain();

		/**
		 * The meta object literal for the '<em><b>Is Identity Criteria</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA = eINSTANCE.getDataRelationshipFromEntity_IsIdentityCriteria();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromStructureImpl <em>Data Relationship From Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipFromStructureImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipFromStructure()
		 * @generated
		 */
		EClass DATA_RELATIONSHIP_FROM_STRUCTURE = eINSTANCE.getDataRelationshipFromStructure();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN = eINSTANCE.getDataRelationshipFromStructure_Domain();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipRangeImpl <em>Data Relationship Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipRangeImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipRange()
		 * @generated
		 */
		EClass DATA_RELATIONSHIP_RANGE = eINSTANCE.getDataRelationshipRange();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipToScalarImpl <em>Data Relationship To Scalar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipToScalarImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipToScalar()
		 * @generated
		 */
		EClass DATA_RELATIONSHIP_TO_SCALAR = eINSTANCE.getDataRelationshipToScalar();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_RELATIONSHIP_TO_SCALAR__RANGE = eINSTANCE.getDataRelationshipToScalar_Range();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipToStructureImpl <em>Data Relationship To Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.DataRelationshipToStructureImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getDataRelationshipToStructure()
		 * @generated
		 */
		EClass DATA_RELATIONSHIP_TO_STRUCTURE = eINSTANCE.getDataRelationshipToStructure();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_RELATIONSHIP_TO_STRUCTURE__RANGE = eINSTANCE.getDataRelationshipToStructure_Range();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyImpl <em>Entity Structured Data Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityStructuredDataPropertyImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityStructuredDataProperty()
		 * @generated
		 */
		EClass ENTITY_STRUCTURED_DATA_PROPERTY = eINSTANCE.getEntityStructuredDataProperty();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_STRUCTURED_DATA_PROPERTY___UUID = eINSTANCE.getEntityStructuredDataProperty__Uuid();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_STRUCTURED_DATA_PROPERTY___SOURCE = eINSTANCE.getEntityStructuredDataProperty__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_STRUCTURED_DATA_PROPERTY___TARGET = eINSTANCE.getEntityStructuredDataProperty__Target();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyImpl <em>Entity Scalar Data Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataProperty()
		 * @generated
		 */
		EClass ENTITY_SCALAR_DATA_PROPERTY = eINSTANCE.getEntityScalarDataProperty();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_SCALAR_DATA_PROPERTY___UUID = eINSTANCE.getEntityScalarDataProperty__Uuid();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_SCALAR_DATA_PROPERTY___SOURCE = eINSTANCE.getEntityScalarDataProperty__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_SCALAR_DATA_PROPERTY___TARGET = eINSTANCE.getEntityScalarDataProperty__Target();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StructuredDataPropertyImpl <em>Structured Data Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.StructuredDataPropertyImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getStructuredDataProperty()
		 * @generated
		 */
		EClass STRUCTURED_DATA_PROPERTY = eINSTANCE.getStructuredDataProperty();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURED_DATA_PROPERTY___UUID = eINSTANCE.getStructuredDataProperty__Uuid();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURED_DATA_PROPERTY___SOURCE = eINSTANCE.getStructuredDataProperty__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURED_DATA_PROPERTY___TARGET = eINSTANCE.getStructuredDataProperty__Target();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarDataPropertyImpl <em>Scalar Data Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarDataPropertyImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getScalarDataProperty()
		 * @generated
		 */
		EClass SCALAR_DATA_PROPERTY = eINSTANCE.getScalarDataProperty();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_DATA_PROPERTY___UUID = eINSTANCE.getScalarDataProperty__Uuid();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_DATA_PROPERTY___SOURCE = eINSTANCE.getScalarDataProperty__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_DATA_PROPERTY___TARGET = eINSTANCE.getScalarDataProperty__Target();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.StructureImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TermAxiomImpl <em>Term Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TermAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTermAxiom()
		 * @generated
		 */
		EClass TERM_AXIOM = eINSTANCE.getTermAxiom();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRestrictionAxiomImpl <em>Entity Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityRestrictionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityRestrictionAxiom()
		 * @generated
		 */
		EClass ENTITY_RESTRICTION_AXIOM = eINSTANCE.getEntityRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Restricted Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION = eINSTANCE.getEntityRestrictionAxiom_RestrictedRelation();

		/**
		 * The meta object literal for the '<em><b>Restricted Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE = eINSTANCE.getEntityRestrictionAxiom_RestrictedRange();

		/**
		 * The meta object literal for the '<em><b>Restricted Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN = eINSTANCE.getEntityRestrictionAxiom_RestrictedDomain();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityExistentialRestrictionAxiomImpl <em>Entity Existential Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityExistentialRestrictionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityExistentialRestrictionAxiom()
		 * @generated
		 */
		EClass ENTITY_EXISTENTIAL_RESTRICTION_AXIOM = eINSTANCE.getEntityExistentialRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_EXISTENTIAL_RESTRICTION_AXIOM___UUID = eINSTANCE.getEntityExistentialRestrictionAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityUniversalRestrictionAxiomImpl <em>Entity Universal Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityUniversalRestrictionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityUniversalRestrictionAxiom()
		 * @generated
		 */
		EClass ENTITY_UNIVERSAL_RESTRICTION_AXIOM = eINSTANCE.getEntityUniversalRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_UNIVERSAL_RESTRICTION_AXIOM___UUID = eINSTANCE.getEntityUniversalRestrictionAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SpecializationAxiomImpl <em>Specialization Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.SpecializationAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getSpecializationAxiom()
		 * @generated
		 */
		EClass SPECIALIZATION_AXIOM = eINSTANCE.getSpecializationAxiom();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SPECIALIZATION_AXIOM___CHILD = eINSTANCE.getSpecializationAxiom__Child();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SPECIALIZATION_AXIOM___PARENT = eINSTANCE.getSpecializationAxiom__Parent();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectSpecializationAxiomImpl <em>Aspect Specialization Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.AspectSpecializationAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getAspectSpecializationAxiom()
		 * @generated
		 */
		EClass ASPECT_SPECIALIZATION_AXIOM = eINSTANCE.getAspectSpecializationAxiom();

		/**
		 * The meta object literal for the '<em><b>Sub Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY = eINSTANCE.getAspectSpecializationAxiom_SubEntity();

		/**
		 * The meta object literal for the '<em><b>Super Aspect</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT = eINSTANCE.getAspectSpecializationAxiom_SuperAspect();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASPECT_SPECIALIZATION_AXIOM___CHILD = eINSTANCE.getAspectSpecializationAxiom__Child();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASPECT_SPECIALIZATION_AXIOM___PARENT = eINSTANCE.getAspectSpecializationAxiom__Parent();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASPECT_SPECIALIZATION_AXIOM___UUID = eINSTANCE.getAspectSpecializationAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptSpecializationAxiomImpl <em>Concept Specialization Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ConceptSpecializationAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getConceptSpecializationAxiom()
		 * @generated
		 */
		EClass CONCEPT_SPECIALIZATION_AXIOM = eINSTANCE.getConceptSpecializationAxiom();

		/**
		 * The meta object literal for the '<em><b>Sub Concept</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT = eINSTANCE.getConceptSpecializationAxiom_SubConcept();

		/**
		 * The meta object literal for the '<em><b>Super Concept</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT = eINSTANCE.getConceptSpecializationAxiom_SuperConcept();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_SPECIALIZATION_AXIOM___CHILD = eINSTANCE.getConceptSpecializationAxiom__Child();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_SPECIALIZATION_AXIOM___PARENT = eINSTANCE.getConceptSpecializationAxiom__Parent();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_SPECIALIZATION_AXIOM___UUID = eINSTANCE.getConceptSpecializationAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipSpecializationAxiomImpl <em>Reified Relationship Specialization Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipSpecializationAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getReifiedRelationshipSpecializationAxiom()
		 * @generated
		 */
		EClass REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM = eINSTANCE.getReifiedRelationshipSpecializationAxiom();

		/**
		 * The meta object literal for the '<em><b>Sub Relationship</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP = eINSTANCE.getReifiedRelationshipSpecializationAxiom_SubRelationship();

		/**
		 * The meta object literal for the '<em><b>Super Relationship</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP = eINSTANCE.getReifiedRelationshipSpecializationAxiom_SuperRelationship();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___CHILD = eINSTANCE.getReifiedRelationshipSpecializationAxiom__Child();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___PARENT = eINSTANCE.getReifiedRelationshipSpecializationAxiom__Parent();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___UUID = eINSTANCE.getReifiedRelationshipSpecializationAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyRestrictionAxiomImpl <em>Entity Scalar Data Property Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyRestrictionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataPropertyRestrictionAxiom()
		 * @generated
		 */
		EClass ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM = eINSTANCE.getEntityScalarDataPropertyRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Restricted Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY = eINSTANCE.getEntityScalarDataPropertyRestrictionAxiom_RestrictedEntity();

		/**
		 * The meta object literal for the '<em><b>Scalar Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY = eINSTANCE.getEntityScalarDataPropertyRestrictionAxiom_ScalarProperty();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyExistentialRestrictionAxiomImpl <em>Entity Scalar Data Property Existential Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyExistentialRestrictionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataPropertyExistentialRestrictionAxiom()
		 * @generated
		 */
		EClass ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM = eINSTANCE.getEntityScalarDataPropertyExistentialRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Scalar Restriction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION = eINSTANCE.getEntityScalarDataPropertyExistentialRestrictionAxiom_ScalarRestriction();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM___UUID = eINSTANCE.getEntityScalarDataPropertyExistentialRestrictionAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyUniversalRestrictionAxiomImpl <em>Entity Scalar Data Property Universal Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyUniversalRestrictionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataPropertyUniversalRestrictionAxiom()
		 * @generated
		 */
		EClass ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM = eINSTANCE.getEntityScalarDataPropertyUniversalRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Scalar Restriction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION = eINSTANCE.getEntityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM___UUID = eINSTANCE.getEntityScalarDataPropertyUniversalRestrictionAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyParticularRestrictionAxiomImpl <em>Entity Scalar Data Property Particular Restriction Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.EntityScalarDataPropertyParticularRestrictionAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getEntityScalarDataPropertyParticularRestrictionAxiom()
		 * @generated
		 */
		EClass ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM = eINSTANCE.getEntityScalarDataPropertyParticularRestrictionAxiom();

		/**
		 * The meta object literal for the '<em><b>Literal Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__LITERAL_VALUE = eINSTANCE.getEntityScalarDataPropertyParticularRestrictionAxiom_LiteralValue();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID = eINSTANCE.getEntityScalarDataPropertyParticularRestrictionAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictedDataRangeImpl <em>Restricted Data Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.RestrictedDataRangeImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getRestrictedDataRange()
		 * @generated
		 */
		EClass RESTRICTED_DATA_RANGE = eINSTANCE.getRestrictedDataRange();

		/**
		 * The meta object literal for the '<em><b>Restricted Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESTRICTED_DATA_RANGE__RESTRICTED_RANGE = eINSTANCE.getRestrictedDataRange_RestrictedRange();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.BinaryScalarRestrictionImpl <em>Binary Scalar Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.BinaryScalarRestrictionImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getBinaryScalarRestriction()
		 * @generated
		 */
		EClass BINARY_SCALAR_RESTRICTION = eINSTANCE.getBinaryScalarRestriction();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_SCALAR_RESTRICTION__LENGTH = eINSTANCE.getBinaryScalarRestriction_Length();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_SCALAR_RESTRICTION__MIN_LENGTH = eINSTANCE.getBinaryScalarRestriction_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_SCALAR_RESTRICTION__MAX_LENGTH = eINSTANCE.getBinaryScalarRestriction_MaxLength();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.IRIScalarRestrictionImpl <em>IRI Scalar Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.IRIScalarRestrictionImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getIRIScalarRestriction()
		 * @generated
		 */
		EClass IRI_SCALAR_RESTRICTION = eINSTANCE.getIRIScalarRestriction();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IRI_SCALAR_RESTRICTION__LENGTH = eINSTANCE.getIRIScalarRestriction_Length();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IRI_SCALAR_RESTRICTION__MIN_LENGTH = eINSTANCE.getIRIScalarRestriction_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IRI_SCALAR_RESTRICTION__MAX_LENGTH = eINSTANCE.getIRIScalarRestriction_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IRI_SCALAR_RESTRICTION__PATTERN = eINSTANCE.getIRIScalarRestriction_Pattern();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.NumericScalarRestrictionImpl <em>Numeric Scalar Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.NumericScalarRestrictionImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getNumericScalarRestriction()
		 * @generated
		 */
		EClass NUMERIC_SCALAR_RESTRICTION = eINSTANCE.getNumericScalarRestriction();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE = eINSTANCE.getNumericScalarRestriction_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE = eINSTANCE.getNumericScalarRestriction_MaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Min Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE = eINSTANCE.getNumericScalarRestriction_MinExclusive();

		/**
		 * The meta object literal for the '<em><b>Max Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE = eINSTANCE.getNumericScalarRestriction_MaxExclusive();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl <em>Plain Literal Scalar Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.PlainLiteralScalarRestrictionImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getPlainLiteralScalarRestriction()
		 * @generated
		 */
		EClass PLAIN_LITERAL_SCALAR_RESTRICTION = eINSTANCE.getPlainLiteralScalarRestriction();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH = eINSTANCE.getPlainLiteralScalarRestriction_Length();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH = eINSTANCE.getPlainLiteralScalarRestriction_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH = eINSTANCE.getPlainLiteralScalarRestriction_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN = eINSTANCE.getPlainLiteralScalarRestriction_Pattern();

		/**
		 * The meta object literal for the '<em><b>Lang Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE = eINSTANCE.getPlainLiteralScalarRestriction_LangRange();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.StringScalarRestrictionImpl <em>String Scalar Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.StringScalarRestrictionImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getStringScalarRestriction()
		 * @generated
		 */
		EClass STRING_SCALAR_RESTRICTION = eINSTANCE.getStringScalarRestriction();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_SCALAR_RESTRICTION__LENGTH = eINSTANCE.getStringScalarRestriction_Length();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_SCALAR_RESTRICTION__MIN_LENGTH = eINSTANCE.getStringScalarRestriction_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_SCALAR_RESTRICTION__MAX_LENGTH = eINSTANCE.getStringScalarRestriction_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_SCALAR_RESTRICTION__PATTERN = eINSTANCE.getStringScalarRestriction_Pattern();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.TimeScalarRestrictionImpl <em>Time Scalar Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TimeScalarRestrictionImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTimeScalarRestriction()
		 * @generated
		 */
		EClass TIME_SCALAR_RESTRICTION = eINSTANCE.getTimeScalarRestriction();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE = eINSTANCE.getTimeScalarRestriction_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE = eINSTANCE.getTimeScalarRestriction_MaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Min Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE = eINSTANCE.getTimeScalarRestriction_MinExclusive();

		/**
		 * The meta object literal for the '<em><b>Max Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE = eINSTANCE.getTimeScalarRestriction_MaxExclusive();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.SynonymScalarRestrictionImpl <em>Synonym Scalar Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.SynonymScalarRestrictionImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getSynonymScalarRestriction()
		 * @generated
		 */
		EClass SYNONYM_SCALAR_RESTRICTION = eINSTANCE.getSynonymScalarRestriction();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfRestrictionImpl <em>Scalar One Of Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfRestrictionImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getScalarOneOfRestriction()
		 * @generated
		 */
		EClass SCALAR_ONE_OF_RESTRICTION = eINSTANCE.getScalarOneOfRestriction();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfLiteralAxiomImpl <em>Scalar One Of Literal Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.ScalarOneOfLiteralAxiomImpl
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getScalarOneOfLiteralAxiom()
		 * @generated
		 */
		EClass SCALAR_ONE_OF_LITERAL_AXIOM = eINSTANCE.getScalarOneOfLiteralAxiom();

		/**
		 * The meta object literal for the '<em><b>Axiom</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM = eINSTANCE.getScalarOneOfLiteralAxiom_Axiom();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_ONE_OF_LITERAL_AXIOM__VALUE = eINSTANCE.getScalarOneOfLiteralAxiom_Value();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_ONE_OF_LITERAL_AXIOM___UUID = eINSTANCE.getScalarOneOfLiteralAxiom__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind <em>Terminology Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind
		 * @see gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologiesPackageImpl#getTerminologyKind()
		 * @generated
		 */
		EEnum TERMINOLOGY_KIND = eINSTANCE.getTerminologyKind();

	}

} //TerminologiesPackage
