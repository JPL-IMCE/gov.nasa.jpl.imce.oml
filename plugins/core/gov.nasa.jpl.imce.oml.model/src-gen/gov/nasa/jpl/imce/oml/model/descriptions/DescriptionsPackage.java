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
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel copyrightText='\nCopyright 2017 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' childCreationExtenders='true' complianceLevel='8.0' featureDelegation='None' modelDirectory='/gov.nasa.jpl.imce.oml.model/src-gen/' editDirectory='/gov.nasa.jpl.imce.oml.model.edit/src-gen/' basePackage='gov.nasa.jpl.imce.oml.model'"
 * @generated
 */
public interface DescriptionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "descriptions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://imce.jpl.nasa.gov/oml/descriptions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "omld";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DescriptionsPackage eINSTANCE = gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl <em>Description Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionBox()
	 * @generated
	 */
	int DESCRIPTION_BOX = 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__UUID = CommonPackage.MODULE__UUID;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__EXTENT = CommonPackage.MODULE__EXTENT;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__IRI = CommonPackage.MODULE__IRI;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__ANNOTATIONS = CommonPackage.MODULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__KIND = CommonPackage.MODULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description Box Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS = CommonPackage.MODULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Closed World Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS = CommonPackage.MODULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Concept Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__CONCEPT_INSTANCES = CommonPackage.MODULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reified Relationship Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES = CommonPackage.MODULE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Reified Relationship Instance Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS = CommonPackage.MODULE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Reified Relationship Instance Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES = CommonPackage.MODULE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Unreified Relationship Instance Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES = CommonPackage.MODULE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Singleton Scalar Data Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES = CommonPackage.MODULE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Singleton Structured Data Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES = CommonPackage.MODULE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Description Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_FEATURE_COUNT = CommonPackage.MODULE_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___IRI = CommonPackage.MODULE___IRI;

	/**
	 * The operation id for the '<em>Ns Prefix</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___NS_PREFIX = CommonPackage.MODULE___NS_PREFIX;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___NAME = CommonPackage.MODULE___NAME;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___ABBREV_IRI = CommonPackage.MODULE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___UUID = CommonPackage.MODULE___UUID;

	/**
	 * The operation id for the '<em>Module Edges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX___MODULE_EDGES = CommonPackage.MODULE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Description Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_OPERATION_COUNT = CommonPackage.MODULE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRelationshipImpl <em>Description Box Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionBoxRelationship()
	 * @generated
	 */
	int DESCRIPTION_BOX_RELATIONSHIP = 1;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_RELATIONSHIP__UUID = CommonPackage.MODULE_EDGE__UUID;

	/**
	 * The number of structural features of the '<em>Description Box Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_RELATIONSHIP_FEATURE_COUNT = CommonPackage.MODULE_EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_RELATIONSHIP___UUID = CommonPackage.MODULE_EDGE___UUID;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_RELATIONSHIP___TARGET_MODULE = CommonPackage.MODULE_EDGE___TARGET_MODULE;

	/**
	 * The operation id for the '<em>Description Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_RELATIONSHIP___DESCRIPTION_DOMAIN = CommonPackage.MODULE_EDGE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_RELATIONSHIP___SOURCE_MODULE = CommonPackage.MODULE_EDGE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Description Box Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT = CommonPackage.MODULE_EDGE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxExtendsClosedWorldDefinitionsImpl <em>Description Box Extends Closed World Definitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxExtendsClosedWorldDefinitionsImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionBoxExtendsClosedWorldDefinitions()
	 * @generated
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__UUID = DESCRIPTION_BOX_RELATIONSHIP__UUID;

	/**
	 * The feature id for the '<em><b>Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__DESCRIPTION_BOX = DESCRIPTION_BOX_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Closed World Definitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__CLOSED_WORLD_DEFINITIONS = DESCRIPTION_BOX_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Description Box Extends Closed World Definitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS_FEATURE_COUNT = DESCRIPTION_BOX_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___SOURCE_MODULE = DESCRIPTION_BOX_RELATIONSHIP___SOURCE_MODULE;

	/**
	 * The operation id for the '<em>Description Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___DESCRIPTION_DOMAIN = DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___TARGET_MODULE = DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___UUID = DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Description Box Extends Closed World Definitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS_OPERATION_COUNT = DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRefinementImpl <em>Description Box Refinement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRefinementImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionBoxRefinement()
	 * @generated
	 */
	int DESCRIPTION_BOX_REFINEMENT = 3;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT__UUID = DESCRIPTION_BOX_RELATIONSHIP__UUID;

	/**
	 * The feature id for the '<em><b>Refining Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX = DESCRIPTION_BOX_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refined Description Box</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX = DESCRIPTION_BOX_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Description Box Refinement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT_FEATURE_COUNT = DESCRIPTION_BOX_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT___SOURCE_MODULE = DESCRIPTION_BOX_RELATIONSHIP___SOURCE_MODULE;

	/**
	 * The operation id for the '<em>Description Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT___DESCRIPTION_DOMAIN = DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT___TARGET_MODULE = DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT___UUID = DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Description Box Refinement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_BOX_REFINEMENT_OPERATION_COUNT = DESCRIPTION_BOX_RELATIONSHIP_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.TerminologyInstanceAssertionImpl <em>Terminology Instance Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.TerminologyInstanceAssertionImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getTerminologyInstanceAssertion()
	 * @generated
	 */
	int TERMINOLOGY_INSTANCE_ASSERTION = 4;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_INSTANCE_ASSERTION__UUID = CommonPackage.MODULE_ELEMENT__UUID;

	/**
	 * The number of structural features of the '<em>Terminology Instance Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_INSTANCE_ASSERTION___UUID = CommonPackage.MODULE_ELEMENT___UUID;

	/**
	 * The number of operations of the '<em>Terminology Instance Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT = CommonPackage.MODULE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceScalarDataPropertyValueImpl <em>Singleton Instance Scalar Data Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceScalarDataPropertyValueImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getSingletonInstanceScalarDataPropertyValue()
	 * @generated
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__UUID = CommonPackage.MODULE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Singleton Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scalar Data Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scalar Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Singleton Instance Scalar Data Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE_FEATURE_COUNT = CommonPackage.MODULE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___UUID = CommonPackage.MODULE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___DESCRIPTION_BOX = CommonPackage.MODULE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Singleton Instance Scalar Data Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE_OPERATION_COUNT = CommonPackage.MODULE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyContextImpl <em>Singleton Instance Structured Data Property Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyContextImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getSingletonInstanceStructuredDataPropertyContext()
	 * @generated
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT = 6;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__UUID = CommonPackage.ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Structured Data Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY = CommonPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structured Property Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES = CommonPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scalar Data Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES = CommonPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Singleton Instance Structured Data Property Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_FEATURE_COUNT = CommonPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT___UUID = CommonPackage.ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT___DESCRIPTION_BOX = CommonPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Singleton Instance Structured Data Property Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_OPERATION_COUNT = CommonPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyValueImpl <em>Singleton Instance Structured Data Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyValueImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getSingletonInstanceStructuredDataPropertyValue()
	 * @generated
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__UUID = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__UUID;

	/**
	 * The feature id for the '<em><b>Structured Data Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY;

	/**
	 * The feature id for the '<em><b>Structured Property Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__STRUCTURED_PROPERTY_TUPLES = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES;

	/**
	 * The feature id for the '<em><b>Scalar Data Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY_VALUES = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Singleton Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Singleton Instance Structured Data Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE_FEATURE_COUNT = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___UUID = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___DESCRIPTION_BOX = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Singleton Instance Structured Data Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE_OPERATION_COUNT = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.StructuredDataPropertyTupleImpl <em>Structured Data Property Tuple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.StructuredDataPropertyTupleImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getStructuredDataPropertyTuple()
	 * @generated
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE = 8;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE__UUID = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__UUID;

	/**
	 * The feature id for the '<em><b>Structured Data Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY;

	/**
	 * The feature id for the '<em><b>Structured Property Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_PROPERTY_TUPLES = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES;

	/**
	 * The feature id for the '<em><b>Scalar Data Property Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE__SCALAR_DATA_PROPERTY_VALUES = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES;

	/**
	 * The feature id for the '<em><b>Structured Data Property Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structured Data Property Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE_FEATURE_COUNT = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE___DESCRIPTION_BOX = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE___UUID = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Structured Data Property Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_PROPERTY_TUPLE_OPERATION_COUNT = SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ScalarDataPropertyValueImpl <em>Scalar Data Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ScalarDataPropertyValueImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getScalarDataPropertyValue()
	 * @generated
	 */
	int SCALAR_DATA_PROPERTY_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_VALUE__UUID = CommonPackage.ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Structured Data Property Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT = CommonPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scalar Data Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY = CommonPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scalar Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE = CommonPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Scalar Data Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_VALUE_FEATURE_COUNT = CommonPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_VALUE___DESCRIPTION_BOX = CommonPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_VALUE___UUID = CommonPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Scalar Data Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_DATA_PROPERTY_VALUE_OPERATION_COUNT = CommonPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptualEntitySingletonInstanceImpl <em>Conceptual Entity Singleton Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptualEntitySingletonInstanceImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getConceptualEntitySingletonInstance()
	 * @generated
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE = 10;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__UUID = TERMINOLOGY_INSTANCE_ASSERTION__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Conceptual Entity Singleton Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_FEATURE_COUNT = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___DESCRIPTION_BOX = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___IRI = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___ABBREV_IRI = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___NAME = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Conceptual Entity Singleton Classifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___UUID = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>Conceptual Entity Singleton Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_OPERATION_COUNT = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 9;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptInstanceImpl <em>Concept Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptInstanceImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getConceptInstance()
	 * @generated
	 */
	int CONCEPT_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__UUID = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__NAME = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__DESCRIPTION_BOX = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Singleton Concept Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Concept Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE_FEATURE_COUNT = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___IRI = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___ABBREV_IRI = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___NAME = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___UUID = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___UUID;

	/**
	 * The operation id for the '<em>Conceptual Entity Singleton Classifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE___DESCRIPTION_BOX = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Concept Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_INSTANCE_OPERATION_COUNT = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceImpl <em>Reified Relationship Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getReifiedRelationshipInstance()
	 * @generated
	 */
	int REIFIED_RELATIONSHIP_INSTANCE = 12;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE__UUID = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE__NAME = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Singleton Reified Relationship Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reified Relationship Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_FEATURE_COUNT = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE___IRI = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___IRI;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE___ABBREV_IRI = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___ABBREV_IRI;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE___NAME = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___NAME;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE___UUID = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___UUID;

	/**
	 * The operation id for the '<em>Conceptual Entity Singleton Classifier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE___DESCRIPTION_BOX = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reified Relationship Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_OPERATION_COUNT = CONCEPTUAL_ENTITY_SINGLETON_INSTANCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceDomainImpl <em>Reified Relationship Instance Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceDomainImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getReifiedRelationshipInstanceDomain()
	 * @generated
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN = 13;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__UUID = TERMINOLOGY_INSTANCE_ASSERTION__UUID;

	/**
	 * The feature id for the '<em><b>Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DESCRIPTION_BOX = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reified Relationship Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__REIFIED_RELATIONSHIP_INSTANCE = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DOMAIN = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reified Relationship Instance Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN_FEATURE_COUNT = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN___DESCRIPTION_BOX = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN___UUID = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reified Relationship Instance Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_DOMAIN_OPERATION_COUNT = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceRangeImpl <em>Reified Relationship Instance Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceRangeImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getReifiedRelationshipInstanceRange()
	 * @generated
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE = 14;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE__UUID = TERMINOLOGY_INSTANCE_ASSERTION__UUID;

	/**
	 * The feature id for the '<em><b>Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE__DESCRIPTION_BOX = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reified Relationship Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE__REIFIED_RELATIONSHIP_INSTANCE = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE__RANGE = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reified Relationship Instance Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE_FEATURE_COUNT = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE___DESCRIPTION_BOX = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE___UUID = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reified Relationship Instance Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REIFIED_RELATIONSHIP_INSTANCE_RANGE_OPERATION_COUNT = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.UnreifiedRelationshipInstanceTupleImpl <em>Unreified Relationship Instance Tuple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.UnreifiedRelationshipInstanceTupleImpl
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getUnreifiedRelationshipInstanceTuple()
	 * @generated
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE = 15;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UUID = TERMINOLOGY_INSTANCE_ASSERTION__UUID;

	/**
	 * The feature id for the '<em><b>Description Box</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unreified Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Unreified Relationship Instance Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE_FEATURE_COUNT = TERMINOLOGY_INSTANCE_ASSERTION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Description Box</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___DESCRIPTION_BOX = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___UUID = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unreified Relationship Instance Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE_OPERATION_COUNT = TERMINOLOGY_INSTANCE_ASSERTION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind <em>Description Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionKind()
	 * @generated
	 */
	int DESCRIPTION_KIND = 16;


	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
	 * @generated
	 */
	EClass getDescriptionBox();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getKind()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EAttribute getDescriptionBox_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getDescriptionBoxRefinements <em>Description Box Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Description Box Refinements</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getDescriptionBoxRefinements()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_DescriptionBoxRefinements();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getClosedWorldDefinitions <em>Closed World Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Closed World Definitions</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getClosedWorldDefinitions()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_ClosedWorldDefinitions();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getConceptInstances <em>Concept Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concept Instances</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getConceptInstances()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_ConceptInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstances <em>Reified Relationship Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reified Relationship Instances</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstances()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_ReifiedRelationshipInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstanceDomains <em>Reified Relationship Instance Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reified Relationship Instance Domains</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstanceDomains()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_ReifiedRelationshipInstanceDomains();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstanceRanges <em>Reified Relationship Instance Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reified Relationship Instance Ranges</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstanceRanges()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_ReifiedRelationshipInstanceRanges();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getUnreifiedRelationshipInstanceTuples <em>Unreified Relationship Instance Tuples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unreified Relationship Instance Tuples</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getUnreifiedRelationshipInstanceTuples()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_UnreifiedRelationshipInstanceTuples();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getSingletonScalarDataPropertyValues <em>Singleton Scalar Data Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Singleton Scalar Data Property Values</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getSingletonScalarDataPropertyValues()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_SingletonScalarDataPropertyValues();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getSingletonStructuredDataPropertyValues <em>Singleton Structured Data Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Singleton Structured Data Property Values</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getSingletonStructuredDataPropertyValues()
	 * @see #getDescriptionBox()
	 * @generated
	 */
	EReference getDescriptionBox_SingletonStructuredDataPropertyValues();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#moduleEdges() <em>Module Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Edges</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#moduleEdges()
	 * @generated
	 */
	EOperation getDescriptionBox__ModuleEdges();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship <em>Description Box Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Box Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship
	 * @generated
	 */
	EClass getDescriptionBoxRelationship();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship#descriptionDomain() <em>Description Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship#descriptionDomain()
	 * @generated
	 */
	EOperation getDescriptionBoxRelationship__DescriptionDomain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship#sourceModule() <em>Source Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source Module</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship#sourceModule()
	 * @generated
	 */
	EOperation getDescriptionBoxRelationship__SourceModule();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions <em>Description Box Extends Closed World Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Box Extends Closed World Definitions</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
	 * @generated
	 */
	EClass getDescriptionBoxExtendsClosedWorldDefinitions();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getDescriptionBox()
	 * @see #getDescriptionBoxExtendsClosedWorldDefinitions()
	 * @generated
	 */
	EReference getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getClosedWorldDefinitions <em>Closed World Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Closed World Definitions</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getClosedWorldDefinitions()
	 * @see #getDescriptionBoxExtendsClosedWorldDefinitions()
	 * @generated
	 */
	EReference getDescriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#descriptionDomain() <em>Description Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#descriptionDomain()
	 * @generated
	 */
	EOperation getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#targetModule() <em>Target Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Module</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#targetModule()
	 * @generated
	 */
	EOperation getDescriptionBoxExtendsClosedWorldDefinitions__TargetModule();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#uuid()
	 * @generated
	 */
	EOperation getDescriptionBoxExtendsClosedWorldDefinitions__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement <em>Description Box Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Box Refinement</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement
	 * @generated
	 */
	EClass getDescriptionBoxRefinement();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefiningDescriptionBox <em>Refining Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Refining Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefiningDescriptionBox()
	 * @see #getDescriptionBoxRefinement()
	 * @generated
	 */
	EReference getDescriptionBoxRefinement_RefiningDescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefinedDescriptionBox <em>Refined Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refined Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefinedDescriptionBox()
	 * @see #getDescriptionBoxRefinement()
	 * @generated
	 */
	EReference getDescriptionBoxRefinement_RefinedDescriptionBox();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#descriptionDomain() <em>Description Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#descriptionDomain()
	 * @generated
	 */
	EOperation getDescriptionBoxRefinement__DescriptionDomain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#targetModule() <em>Target Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Module</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#targetModule()
	 * @generated
	 */
	EOperation getDescriptionBoxRefinement__TargetModule();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#uuid()
	 * @generated
	 */
	EOperation getDescriptionBoxRefinement__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.TerminologyInstanceAssertion <em>Terminology Instance Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminology Instance Assertion</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.TerminologyInstanceAssertion
	 * @generated
	 */
	EClass getTerminologyInstanceAssertion();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue <em>Singleton Instance Scalar Data Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Singleton Instance Scalar Data Property Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
	 * @generated
	 */
	EClass getSingletonInstanceScalarDataPropertyValue();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getDescriptionBox()
	 * @see #getSingletonInstanceScalarDataPropertyValue()
	 * @generated
	 */
	EReference getSingletonInstanceScalarDataPropertyValue_DescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getSingletonInstance <em>Singleton Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Singleton Instance</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getSingletonInstance()
	 * @see #getSingletonInstanceScalarDataPropertyValue()
	 * @generated
	 */
	EReference getSingletonInstanceScalarDataPropertyValue_SingletonInstance();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getScalarDataProperty <em>Scalar Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scalar Data Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getScalarDataProperty()
	 * @see #getSingletonInstanceScalarDataPropertyValue()
	 * @generated
	 */
	EReference getSingletonInstanceScalarDataPropertyValue_ScalarDataProperty();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getScalarPropertyValue <em>Scalar Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scalar Property Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getScalarPropertyValue()
	 * @see #getSingletonInstanceScalarDataPropertyValue()
	 * @generated
	 */
	EAttribute getSingletonInstanceScalarDataPropertyValue_ScalarPropertyValue();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#uuid()
	 * @generated
	 */
	EOperation getSingletonInstanceScalarDataPropertyValue__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#descriptionBox()
	 * @generated
	 */
	EOperation getSingletonInstanceScalarDataPropertyValue__DescriptionBox();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext <em>Singleton Instance Structured Data Property Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Singleton Instance Structured Data Property Context</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext
	 * @generated
	 */
	EClass getSingletonInstanceStructuredDataPropertyContext();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext#getStructuredDataProperty <em>Structured Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Structured Data Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext#getStructuredDataProperty()
	 * @see #getSingletonInstanceStructuredDataPropertyContext()
	 * @generated
	 */
	EReference getSingletonInstanceStructuredDataPropertyContext_StructuredDataProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext#getStructuredPropertyTuples <em>Structured Property Tuples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structured Property Tuples</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext#getStructuredPropertyTuples()
	 * @see #getSingletonInstanceStructuredDataPropertyContext()
	 * @generated
	 */
	EReference getSingletonInstanceStructuredDataPropertyContext_StructuredPropertyTuples();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext#getScalarDataPropertyValues <em>Scalar Data Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scalar Data Property Values</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext#getScalarDataPropertyValues()
	 * @see #getSingletonInstanceStructuredDataPropertyContext()
	 * @generated
	 */
	EReference getSingletonInstanceStructuredDataPropertyContext_ScalarDataPropertyValues();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext#descriptionBox()
	 * @generated
	 */
	EOperation getSingletonInstanceStructuredDataPropertyContext__DescriptionBox();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue <em>Singleton Instance Structured Data Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Singleton Instance Structured Data Property Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
	 * @generated
	 */
	EClass getSingletonInstanceStructuredDataPropertyValue();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#getDescriptionBox()
	 * @see #getSingletonInstanceStructuredDataPropertyValue()
	 * @generated
	 */
	EReference getSingletonInstanceStructuredDataPropertyValue_DescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#getSingletonInstance <em>Singleton Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Singleton Instance</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#getSingletonInstance()
	 * @see #getSingletonInstanceStructuredDataPropertyValue()
	 * @generated
	 */
	EReference getSingletonInstanceStructuredDataPropertyValue_SingletonInstance();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#uuid()
	 * @generated
	 */
	EOperation getSingletonInstanceStructuredDataPropertyValue__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue#descriptionBox()
	 * @generated
	 */
	EOperation getSingletonInstanceStructuredDataPropertyValue__DescriptionBox();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple <em>Structured Data Property Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structured Data Property Tuple</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple
	 * @generated
	 */
	EClass getStructuredDataPropertyTuple();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Structured Data Property Context</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple#getStructuredDataPropertyContext()
	 * @see #getStructuredDataPropertyTuple()
	 * @generated
	 */
	EReference getStructuredDataPropertyTuple_StructuredDataPropertyContext();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple#descriptionBox()
	 * @generated
	 */
	EOperation getStructuredDataPropertyTuple__DescriptionBox();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple#uuid()
	 * @generated
	 */
	EOperation getStructuredDataPropertyTuple__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue <em>Scalar Data Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Data Property Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
	 * @generated
	 */
	EClass getScalarDataPropertyValue();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Structured Data Property Context</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#getStructuredDataPropertyContext()
	 * @see #getScalarDataPropertyValue()
	 * @generated
	 */
	EReference getScalarDataPropertyValue_StructuredDataPropertyContext();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#getScalarDataProperty <em>Scalar Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scalar Data Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#getScalarDataProperty()
	 * @see #getScalarDataPropertyValue()
	 * @generated
	 */
	EReference getScalarDataPropertyValue_ScalarDataProperty();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#getScalarPropertyValue <em>Scalar Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scalar Property Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#getScalarPropertyValue()
	 * @see #getScalarDataPropertyValue()
	 * @generated
	 */
	EAttribute getScalarDataPropertyValue_ScalarPropertyValue();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#descriptionBox()
	 * @generated
	 */
	EOperation getScalarDataPropertyValue__DescriptionBox();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue#uuid()
	 * @generated
	 */
	EOperation getScalarDataPropertyValue__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance <em>Conceptual Entity Singleton Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conceptual Entity Singleton Instance</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance
	 * @generated
	 */
	EClass getConceptualEntitySingletonInstance();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#getName()
	 * @see #getConceptualEntitySingletonInstance()
	 * @generated
	 */
	EAttribute getConceptualEntitySingletonInstance_Name();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#descriptionBox()
	 * @generated
	 */
	EOperation getConceptualEntitySingletonInstance__DescriptionBox();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#iri() <em>Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Iri</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#iri()
	 * @generated
	 */
	EOperation getConceptualEntitySingletonInstance__Iri();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#abbrevIRI() <em>Abbrev IRI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Abbrev IRI</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#abbrevIRI()
	 * @generated
	 */
	EOperation getConceptualEntitySingletonInstance__AbbrevIRI();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#name() <em>Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Name</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#name()
	 * @generated
	 */
	EOperation getConceptualEntitySingletonInstance__Name();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#conceptualEntitySingletonClassifier() <em>Conceptual Entity Singleton Classifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Conceptual Entity Singleton Classifier</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#conceptualEntitySingletonClassifier()
	 * @generated
	 */
	EOperation getConceptualEntitySingletonInstance__ConceptualEntitySingletonClassifier();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#uuid()
	 * @generated
	 */
	EOperation getConceptualEntitySingletonInstance__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance <em>Concept Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept Instance</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
	 * @generated
	 */
	EClass getConceptInstance();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getDescriptionBox()
	 * @see #getConceptInstance()
	 * @generated
	 */
	EReference getConceptInstance_DescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getSingletonConceptClassifier <em>Singleton Concept Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Singleton Concept Classifier</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getSingletonConceptClassifier()
	 * @see #getConceptInstance()
	 * @generated
	 */
	EReference getConceptInstance_SingletonConceptClassifier();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#conceptualEntitySingletonClassifier() <em>Conceptual Entity Singleton Classifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Conceptual Entity Singleton Classifier</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#conceptualEntitySingletonClassifier()
	 * @generated
	 */
	EOperation getConceptInstance__ConceptualEntitySingletonClassifier();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#descriptionBox()
	 * @generated
	 */
	EOperation getConceptInstance__DescriptionBox();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance <em>Reified Relationship Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reified Relationship Instance</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
	 * @generated
	 */
	EClass getReifiedRelationshipInstance();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#getDescriptionBox()
	 * @see #getReifiedRelationshipInstance()
	 * @generated
	 */
	EReference getReifiedRelationshipInstance_DescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#getSingletonReifiedRelationshipClassifier <em>Singleton Reified Relationship Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Singleton Reified Relationship Classifier</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#getSingletonReifiedRelationshipClassifier()
	 * @see #getReifiedRelationshipInstance()
	 * @generated
	 */
	EReference getReifiedRelationshipInstance_SingletonReifiedRelationshipClassifier();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#conceptualEntitySingletonClassifier() <em>Conceptual Entity Singleton Classifier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Conceptual Entity Singleton Classifier</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#conceptualEntitySingletonClassifier()
	 * @generated
	 */
	EOperation getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance#descriptionBox()
	 * @generated
	 */
	EOperation getReifiedRelationshipInstance__DescriptionBox();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain <em>Reified Relationship Instance Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reified Relationship Instance Domain</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
	 * @generated
	 */
	EClass getReifiedRelationshipInstanceDomain();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDescriptionBox()
	 * @see #getReifiedRelationshipInstanceDomain()
	 * @generated
	 */
	EReference getReifiedRelationshipInstanceDomain_DescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getReifiedRelationshipInstance <em>Reified Relationship Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reified Relationship Instance</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getReifiedRelationshipInstance()
	 * @see #getReifiedRelationshipInstanceDomain()
	 * @generated
	 */
	EReference getReifiedRelationshipInstanceDomain_ReifiedRelationshipInstance();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDomain()
	 * @see #getReifiedRelationshipInstanceDomain()
	 * @generated
	 */
	EReference getReifiedRelationshipInstanceDomain_Domain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#descriptionBox()
	 * @generated
	 */
	EOperation getReifiedRelationshipInstanceDomain__DescriptionBox();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#uuid()
	 * @generated
	 */
	EOperation getReifiedRelationshipInstanceDomain__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange <em>Reified Relationship Instance Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reified Relationship Instance Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
	 * @generated
	 */
	EClass getReifiedRelationshipInstanceRange();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#getDescriptionBox()
	 * @see #getReifiedRelationshipInstanceRange()
	 * @generated
	 */
	EReference getReifiedRelationshipInstanceRange_DescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#getReifiedRelationshipInstance <em>Reified Relationship Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reified Relationship Instance</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#getReifiedRelationshipInstance()
	 * @see #getReifiedRelationshipInstanceRange()
	 * @generated
	 */
	EReference getReifiedRelationshipInstanceRange_ReifiedRelationshipInstance();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#getRange()
	 * @see #getReifiedRelationshipInstanceRange()
	 * @generated
	 */
	EReference getReifiedRelationshipInstanceRange_Range();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#descriptionBox()
	 * @generated
	 */
	EOperation getReifiedRelationshipInstanceRange__DescriptionBox();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange#uuid()
	 * @generated
	 */
	EOperation getReifiedRelationshipInstanceRange__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple <em>Unreified Relationship Instance Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unreified Relationship Instance Tuple</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple
	 * @generated
	 */
	EClass getUnreifiedRelationshipInstanceTuple();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getDescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Description Box</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getDescriptionBox()
	 * @see #getUnreifiedRelationshipInstanceTuple()
	 * @generated
	 */
	EReference getUnreifiedRelationshipInstanceTuple_DescriptionBox();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getUnreifiedRelationship <em>Unreified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unreified Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getUnreifiedRelationship()
	 * @see #getUnreifiedRelationshipInstanceTuple()
	 * @generated
	 */
	EReference getUnreifiedRelationshipInstanceTuple_UnreifiedRelationship();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getDomain()
	 * @see #getUnreifiedRelationshipInstanceTuple()
	 * @generated
	 */
	EReference getUnreifiedRelationshipInstanceTuple_Domain();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#getRange()
	 * @see #getUnreifiedRelationshipInstanceTuple()
	 * @generated
	 */
	EReference getUnreifiedRelationshipInstanceTuple_Range();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#descriptionBox() <em>Description Box</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Description Box</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#descriptionBox()
	 * @generated
	 */
	EOperation getUnreifiedRelationshipInstanceTuple__DescriptionBox();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple#uuid()
	 * @generated
	 */
	EOperation getUnreifiedRelationshipInstanceTuple__Uuid();

	/**
	 * Returns the meta object for enum '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind <em>Description Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Description Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind
	 * @generated
	 */
	EEnum getDescriptionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DescriptionsFactory getDescriptionsFactory();

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
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl <em>Description Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionBox()
		 * @generated
		 */
		EClass DESCRIPTION_BOX = eINSTANCE.getDescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION_BOX__KIND = eINSTANCE.getDescriptionBox_Kind();

		/**
		 * The meta object literal for the '<em><b>Description Box Refinements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS = eINSTANCE.getDescriptionBox_DescriptionBoxRefinements();

		/**
		 * The meta object literal for the '<em><b>Closed World Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS = eINSTANCE.getDescriptionBox_ClosedWorldDefinitions();

		/**
		 * The meta object literal for the '<em><b>Concept Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__CONCEPT_INSTANCES = eINSTANCE.getDescriptionBox_ConceptInstances();

		/**
		 * The meta object literal for the '<em><b>Reified Relationship Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES = eINSTANCE.getDescriptionBox_ReifiedRelationshipInstances();

		/**
		 * The meta object literal for the '<em><b>Reified Relationship Instance Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS = eINSTANCE.getDescriptionBox_ReifiedRelationshipInstanceDomains();

		/**
		 * The meta object literal for the '<em><b>Reified Relationship Instance Ranges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES = eINSTANCE.getDescriptionBox_ReifiedRelationshipInstanceRanges();

		/**
		 * The meta object literal for the '<em><b>Unreified Relationship Instance Tuples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES = eINSTANCE.getDescriptionBox_UnreifiedRelationshipInstanceTuples();

		/**
		 * The meta object literal for the '<em><b>Singleton Scalar Data Property Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES = eINSTANCE.getDescriptionBox_SingletonScalarDataPropertyValues();

		/**
		 * The meta object literal for the '<em><b>Singleton Structured Data Property Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES = eINSTANCE.getDescriptionBox_SingletonStructuredDataPropertyValues();

		/**
		 * The meta object literal for the '<em><b>Module Edges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX___MODULE_EDGES = eINSTANCE.getDescriptionBox__ModuleEdges();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRelationshipImpl <em>Description Box Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionBoxRelationship()
		 * @generated
		 */
		EClass DESCRIPTION_BOX_RELATIONSHIP = eINSTANCE.getDescriptionBoxRelationship();

		/**
		 * The meta object literal for the '<em><b>Description Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX_RELATIONSHIP___DESCRIPTION_DOMAIN = eINSTANCE.getDescriptionBoxRelationship__DescriptionDomain();

		/**
		 * The meta object literal for the '<em><b>Source Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX_RELATIONSHIP___SOURCE_MODULE = eINSTANCE.getDescriptionBoxRelationship__SourceModule();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxExtendsClosedWorldDefinitionsImpl <em>Description Box Extends Closed World Definitions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxExtendsClosedWorldDefinitionsImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionBoxExtendsClosedWorldDefinitions()
		 * @generated
		 */
		EClass DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS = eINSTANCE.getDescriptionBoxExtendsClosedWorldDefinitions();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__DESCRIPTION_BOX = eINSTANCE.getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Closed World Definitions</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__CLOSED_WORLD_DEFINITIONS = eINSTANCE.getDescriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions();

		/**
		 * The meta object literal for the '<em><b>Description Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___DESCRIPTION_DOMAIN = eINSTANCE.getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain();

		/**
		 * The meta object literal for the '<em><b>Target Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___TARGET_MODULE = eINSTANCE.getDescriptionBoxExtendsClosedWorldDefinitions__TargetModule();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___UUID = eINSTANCE.getDescriptionBoxExtendsClosedWorldDefinitions__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRefinementImpl <em>Description Box Refinement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionBoxRefinementImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionBoxRefinement()
		 * @generated
		 */
		EClass DESCRIPTION_BOX_REFINEMENT = eINSTANCE.getDescriptionBoxRefinement();

		/**
		 * The meta object literal for the '<em><b>Refining Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX = eINSTANCE.getDescriptionBoxRefinement_RefiningDescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Refined Description Box</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX = eINSTANCE.getDescriptionBoxRefinement_RefinedDescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Description Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX_REFINEMENT___DESCRIPTION_DOMAIN = eINSTANCE.getDescriptionBoxRefinement__DescriptionDomain();

		/**
		 * The meta object literal for the '<em><b>Target Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX_REFINEMENT___TARGET_MODULE = eINSTANCE.getDescriptionBoxRefinement__TargetModule();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DESCRIPTION_BOX_REFINEMENT___UUID = eINSTANCE.getDescriptionBoxRefinement__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.TerminologyInstanceAssertionImpl <em>Terminology Instance Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.TerminologyInstanceAssertionImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getTerminologyInstanceAssertion()
		 * @generated
		 */
		EClass TERMINOLOGY_INSTANCE_ASSERTION = eINSTANCE.getTerminologyInstanceAssertion();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceScalarDataPropertyValueImpl <em>Singleton Instance Scalar Data Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceScalarDataPropertyValueImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getSingletonInstanceScalarDataPropertyValue()
		 * @generated
		 */
		EClass SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE = eINSTANCE.getSingletonInstanceScalarDataPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX = eINSTANCE.getSingletonInstanceScalarDataPropertyValue_DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Singleton Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE = eINSTANCE.getSingletonInstanceScalarDataPropertyValue_SingletonInstance();

		/**
		 * The meta object literal for the '<em><b>Scalar Data Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY = eINSTANCE.getSingletonInstanceScalarDataPropertyValue_ScalarDataProperty();

		/**
		 * The meta object literal for the '<em><b>Scalar Property Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE = eINSTANCE.getSingletonInstanceScalarDataPropertyValue_ScalarPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___UUID = eINSTANCE.getSingletonInstanceScalarDataPropertyValue__Uuid();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___DESCRIPTION_BOX = eINSTANCE.getSingletonInstanceScalarDataPropertyValue__DescriptionBox();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyContextImpl <em>Singleton Instance Structured Data Property Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyContextImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getSingletonInstanceStructuredDataPropertyContext()
		 * @generated
		 */
		EClass SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT = eINSTANCE.getSingletonInstanceStructuredDataPropertyContext();

		/**
		 * The meta object literal for the '<em><b>Structured Data Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY = eINSTANCE.getSingletonInstanceStructuredDataPropertyContext_StructuredDataProperty();

		/**
		 * The meta object literal for the '<em><b>Structured Property Tuples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES = eINSTANCE.getSingletonInstanceStructuredDataPropertyContext_StructuredPropertyTuples();

		/**
		 * The meta object literal for the '<em><b>Scalar Data Property Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES = eINSTANCE.getSingletonInstanceStructuredDataPropertyContext_ScalarDataPropertyValues();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT___DESCRIPTION_BOX = eINSTANCE.getSingletonInstanceStructuredDataPropertyContext__DescriptionBox();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyValueImpl <em>Singleton Instance Structured Data Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.SingletonInstanceStructuredDataPropertyValueImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getSingletonInstanceStructuredDataPropertyValue()
		 * @generated
		 */
		EClass SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE = eINSTANCE.getSingletonInstanceStructuredDataPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX = eINSTANCE.getSingletonInstanceStructuredDataPropertyValue_DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Singleton Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE = eINSTANCE.getSingletonInstanceStructuredDataPropertyValue_SingletonInstance();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___UUID = eINSTANCE.getSingletonInstanceStructuredDataPropertyValue__Uuid();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___DESCRIPTION_BOX = eINSTANCE.getSingletonInstanceStructuredDataPropertyValue__DescriptionBox();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.StructuredDataPropertyTupleImpl <em>Structured Data Property Tuple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.StructuredDataPropertyTupleImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getStructuredDataPropertyTuple()
		 * @generated
		 */
		EClass STRUCTURED_DATA_PROPERTY_TUPLE = eINSTANCE.getStructuredDataPropertyTuple();

		/**
		 * The meta object literal for the '<em><b>Structured Data Property Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT = eINSTANCE.getStructuredDataPropertyTuple_StructuredDataPropertyContext();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURED_DATA_PROPERTY_TUPLE___DESCRIPTION_BOX = eINSTANCE.getStructuredDataPropertyTuple__DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRUCTURED_DATA_PROPERTY_TUPLE___UUID = eINSTANCE.getStructuredDataPropertyTuple__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ScalarDataPropertyValueImpl <em>Scalar Data Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ScalarDataPropertyValueImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getScalarDataPropertyValue()
		 * @generated
		 */
		EClass SCALAR_DATA_PROPERTY_VALUE = eINSTANCE.getScalarDataPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Structured Data Property Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT = eINSTANCE.getScalarDataPropertyValue_StructuredDataPropertyContext();

		/**
		 * The meta object literal for the '<em><b>Scalar Data Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY = eINSTANCE.getScalarDataPropertyValue_ScalarDataProperty();

		/**
		 * The meta object literal for the '<em><b>Scalar Property Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE = eINSTANCE.getScalarDataPropertyValue_ScalarPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_DATA_PROPERTY_VALUE___DESCRIPTION_BOX = eINSTANCE.getScalarDataPropertyValue__DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCALAR_DATA_PROPERTY_VALUE___UUID = eINSTANCE.getScalarDataPropertyValue__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptualEntitySingletonInstanceImpl <em>Conceptual Entity Singleton Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptualEntitySingletonInstanceImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getConceptualEntitySingletonInstance()
		 * @generated
		 */
		EClass CONCEPTUAL_ENTITY_SINGLETON_INSTANCE = eINSTANCE.getConceptualEntitySingletonInstance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME = eINSTANCE.getConceptualEntitySingletonInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___DESCRIPTION_BOX = eINSTANCE.getConceptualEntitySingletonInstance__DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___IRI = eINSTANCE.getConceptualEntitySingletonInstance__Iri();

		/**
		 * The meta object literal for the '<em><b>Abbrev IRI</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___ABBREV_IRI = eINSTANCE.getConceptualEntitySingletonInstance__AbbrevIRI();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___NAME = eINSTANCE.getConceptualEntitySingletonInstance__Name();

		/**
		 * The meta object literal for the '<em><b>Conceptual Entity Singleton Classifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER = eINSTANCE.getConceptualEntitySingletonInstance__ConceptualEntitySingletonClassifier();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___UUID = eINSTANCE.getConceptualEntitySingletonInstance__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptInstanceImpl <em>Concept Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ConceptInstanceImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getConceptInstance()
		 * @generated
		 */
		EClass CONCEPT_INSTANCE = eINSTANCE.getConceptInstance();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_INSTANCE__DESCRIPTION_BOX = eINSTANCE.getConceptInstance_DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Singleton Concept Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER = eINSTANCE.getConceptInstance_SingletonConceptClassifier();

		/**
		 * The meta object literal for the '<em><b>Conceptual Entity Singleton Classifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER = eINSTANCE.getConceptInstance__ConceptualEntitySingletonClassifier();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONCEPT_INSTANCE___DESCRIPTION_BOX = eINSTANCE.getConceptInstance__DescriptionBox();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceImpl <em>Reified Relationship Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getReifiedRelationshipInstance()
		 * @generated
		 */
		EClass REIFIED_RELATIONSHIP_INSTANCE = eINSTANCE.getReifiedRelationshipInstance();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX = eINSTANCE.getReifiedRelationshipInstance_DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Singleton Reified Relationship Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER = eINSTANCE.getReifiedRelationshipInstance_SingletonReifiedRelationshipClassifier();

		/**
		 * The meta object literal for the '<em><b>Conceptual Entity Singleton Classifier</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER = eINSTANCE.getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_INSTANCE___DESCRIPTION_BOX = eINSTANCE.getReifiedRelationshipInstance__DescriptionBox();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceDomainImpl <em>Reified Relationship Instance Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceDomainImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getReifiedRelationshipInstanceDomain()
		 * @generated
		 */
		EClass REIFIED_RELATIONSHIP_INSTANCE_DOMAIN = eINSTANCE.getReifiedRelationshipInstanceDomain();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DESCRIPTION_BOX = eINSTANCE.getReifiedRelationshipInstanceDomain_DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Reified Relationship Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__REIFIED_RELATIONSHIP_INSTANCE = eINSTANCE.getReifiedRelationshipInstanceDomain_ReifiedRelationshipInstance();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DOMAIN = eINSTANCE.getReifiedRelationshipInstanceDomain_Domain();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_INSTANCE_DOMAIN___DESCRIPTION_BOX = eINSTANCE.getReifiedRelationshipInstanceDomain__DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_INSTANCE_DOMAIN___UUID = eINSTANCE.getReifiedRelationshipInstanceDomain__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceRangeImpl <em>Reified Relationship Instance Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.ReifiedRelationshipInstanceRangeImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getReifiedRelationshipInstanceRange()
		 * @generated
		 */
		EClass REIFIED_RELATIONSHIP_INSTANCE_RANGE = eINSTANCE.getReifiedRelationshipInstanceRange();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_INSTANCE_RANGE__DESCRIPTION_BOX = eINSTANCE.getReifiedRelationshipInstanceRange_DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Reified Relationship Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_INSTANCE_RANGE__REIFIED_RELATIONSHIP_INSTANCE = eINSTANCE.getReifiedRelationshipInstanceRange_ReifiedRelationshipInstance();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REIFIED_RELATIONSHIP_INSTANCE_RANGE__RANGE = eINSTANCE.getReifiedRelationshipInstanceRange_Range();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_INSTANCE_RANGE___DESCRIPTION_BOX = eINSTANCE.getReifiedRelationshipInstanceRange__DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REIFIED_RELATIONSHIP_INSTANCE_RANGE___UUID = eINSTANCE.getReifiedRelationshipInstanceRange__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.impl.UnreifiedRelationshipInstanceTupleImpl <em>Unreified Relationship Instance Tuple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.UnreifiedRelationshipInstanceTupleImpl
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getUnreifiedRelationshipInstanceTuple()
		 * @generated
		 */
		EClass UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE = eINSTANCE.getUnreifiedRelationshipInstanceTuple();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX = eINSTANCE.getUnreifiedRelationshipInstanceTuple_DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Unreified Relationship</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP = eINSTANCE.getUnreifiedRelationshipInstanceTuple_UnreifiedRelationship();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN = eINSTANCE.getUnreifiedRelationshipInstanceTuple_Domain();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE = eINSTANCE.getUnreifiedRelationshipInstanceTuple_Range();

		/**
		 * The meta object literal for the '<em><b>Description Box</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___DESCRIPTION_BOX = eINSTANCE.getUnreifiedRelationshipInstanceTuple__DescriptionBox();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___UUID = eINSTANCE.getUnreifiedRelationshipInstanceTuple__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind <em>Description Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind
		 * @see gov.nasa.jpl.imce.oml.model.descriptions.impl.DescriptionsPackageImpl#getDescriptionKind()
		 * @generated
		 */
		EEnum DESCRIPTION_KIND = eINSTANCE.getDescriptionKind();

	}

} //DescriptionsPackage
