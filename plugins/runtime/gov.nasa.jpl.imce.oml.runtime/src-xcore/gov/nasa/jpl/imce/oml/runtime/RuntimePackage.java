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
package gov.nasa.jpl.imce.oml.runtime;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see gov.nasa.jpl.imce.oml.runtime.RuntimeFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel copyrightText='\nCopyright 2017 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n' bundleManifest='false' childCreationExtenders='true' complianceLevel='8.0' featureDelegation='None' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' modelDirectory='gov.nasa.jpl.imce.oml.runtime/src-xcore/' editDirectory='gov.nasa.jpl.imce.oml.runtime.edit/src-gen' editorDirectory='gov.nasa.jpl.imce.oml.runtime.ui/src-gen' modelName='OMLR' basePackage='gov.nasa.jpl.imce.oml'"
 *        annotation="http://www.eclipse.org/emf/2011/Xcore OMLProvenance='http://imce.jpl.nasa.gov/oml/runtime/OMLProvenance'"
 * @generated
 */
public interface RuntimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtime";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://imce.jpl.nasa.gov/oml/runtime";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "omlr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimePackage eINSTANCE = gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLObjectImpl <em>OML Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLObjectImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLObject()
	 * @generated
	 */
	int OML_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_OBJECT__OML_ROOT = 0;

	/**
	 * The number of structural features of the '<em>OML Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS = 0;

	/**
	 * The number of operations of the '<em>OML Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_OBJECT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLDescriptionImpl <em>OML Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLDescriptionImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLDescription()
	 * @generated
	 */
	int OML_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION__OML_ROOT = OML_OBJECT__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Desciption IRI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION__OML_DESCIPTION_IRI = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Oml Description Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS = OML_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OML Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION___OML_INVERSE_REFERENCERS__CLASS = OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The operation id for the '<em>Get OML Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION___GET_OML_ROOT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>OML Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureImpl <em>OML Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLStructure()
	 * @generated
	 */
	int OML_STRUCTURE = 2;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE__OML_ROOT = OML_OBJECT__OML_ROOT;

	/**
	 * The number of structural features of the '<em>OML Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE___OML_INVERSE_REFERENCERS__CLASS = OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLScalarImpl <em>OML Scalar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLScalarImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLScalar()
	 * @generated
	 */
	int OML_SCALAR = 3;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_SCALAR__OML_ROOT = OML_OBJECT__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_SCALAR__VALUE = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_SCALAR_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_SCALAR___OML_INVERSE_REFERENCERS__CLASS = OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_SCALAR_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl <em>OML Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLEntity()
	 * @generated
	 */
	int OML_ENTITY = 4;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY__OML_ROOT = OML_OBJECT__OML_ROOT;

	/**
	 * The number of structural features of the '<em>OML Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY___OML_INVERSE_REFERENCERS__CLASS = OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLAspectImpl <em>OML Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLAspectImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLAspect()
	 * @generated
	 */
	int OML_ASPECT = 5;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ASPECT__OML_ROOT = OML_ENTITY__OML_ROOT;

	/**
	 * The number of structural features of the '<em>OML Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ASPECT_FEATURE_COUNT = OML_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ASPECT___OML_INVERSE_REFERENCERS__CLASS = OML_ENTITY___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ASPECT_OPERATION_COUNT = OML_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLConceptImpl <em>OML Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLConceptImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLConcept()
	 * @generated
	 */
	int OML_CONCEPT = 6;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_CONCEPT__OML_ROOT = OML_ENTITY__OML_ROOT;

	/**
	 * The number of structural features of the '<em>OML Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_CONCEPT_FEATURE_COUNT = OML_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_CONCEPT___OML_INVERSE_REFERENCERS__CLASS = OML_ENTITY___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_CONCEPT_OPERATION_COUNT = OML_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromEntityImpl <em>OML Relationship From Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromEntityImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLRelationshipFromEntity()
	 * @generated
	 */
	int OML_RELATIONSHIP_FROM_ENTITY = 7;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_ENTITY__OML_ROOT = OML_OBJECT__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Relationship From Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_ENTITY_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_ENTITY___OML_INVERSE_REFERENCERS__CLASS = OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Relationship From Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_ENTITY_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromStructureImpl <em>OML Relationship From Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromStructureImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLRelationshipFromStructure()
	 * @generated
	 */
	int OML_RELATIONSHIP_FROM_STRUCTURE = 8;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_STRUCTURE__OML_ROOT = OML_OBJECT__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_STRUCTURE__OML_SOURCE = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Relationship From Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_STRUCTURE_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_STRUCTURE___OML_INVERSE_REFERENCERS__CLASS = OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Relationship From Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_FROM_STRUCTURE_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipToEntityImpl <em>OML Relationship To Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipToEntityImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLRelationshipToEntity()
	 * @generated
	 */
	int OML_RELATIONSHIP_TO_ENTITY = 9;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_ENTITY__OML_ROOT = OML_OBJECT__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_ENTITY__OML_TARGET = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Relationship To Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_ENTITY_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_ENTITY___OML_INVERSE_REFERENCERS__CLASS = OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Relationship To Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_ENTITY_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipToStructureImpl <em>OML Relationship To Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipToStructureImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLRelationshipToStructure()
	 * @generated
	 */
	int OML_RELATIONSHIP_TO_STRUCTURE = 10;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_STRUCTURE__OML_ROOT = OML_OBJECT__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_STRUCTURE__OML_TARGET = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Relationship To Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_STRUCTURE_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_STRUCTURE___OML_INVERSE_REFERENCERS__CLASS = OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Relationship To Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_RELATIONSHIP_TO_STRUCTURE_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityRelationshipImpl <em>OML Entity Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLEntityRelationship()
	 * @generated
	 */
	int OML_ENTITY_RELATIONSHIP = 11;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_RELATIONSHIP__OML_ROOT = OML_RELATIONSHIP_FROM_ENTITY__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_RELATIONSHIP__OML_SOURCE = OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE;

	/**
	 * The feature id for the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_RELATIONSHIP__OML_TARGET = OML_RELATIONSHIP_FROM_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Entity Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_RELATIONSHIP_FEATURE_COUNT = OML_RELATIONSHIP_FROM_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_RELATIONSHIP___OML_INVERSE_REFERENCERS__CLASS = OML_RELATIONSHIP_FROM_ENTITY___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Entity Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_RELATIONSHIP_OPERATION_COUNT = OML_RELATIONSHIP_FROM_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLReifiedRelationshipImpl <em>OML Reified Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLReifiedRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLReifiedRelationship()
	 * @generated
	 */
	int OML_REIFIED_RELATIONSHIP = 12;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP__OML_ROOT = OML_ENTITY_RELATIONSHIP__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP__OML_SOURCE = OML_ENTITY_RELATIONSHIP__OML_SOURCE;

	/**
	 * The feature id for the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP__OML_TARGET = OML_ENTITY_RELATIONSHIP__OML_TARGET;

	/**
	 * The number of structural features of the '<em>OML Reified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP_FEATURE_COUNT = OML_ENTITY_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP___OML_INVERSE_REFERENCERS__CLASS = OML_ENTITY_RELATIONSHIP___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Reified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP_OPERATION_COUNT = OML_ENTITY_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLUnreifiedRelationshipImpl <em>OML Unreified Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLUnreifiedRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLUnreifiedRelationship()
	 * @generated
	 */
	int OML_UNREIFIED_RELATIONSHIP = 13;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_UNREIFIED_RELATIONSHIP__OML_ROOT = OML_ENTITY_RELATIONSHIP__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_UNREIFIED_RELATIONSHIP__OML_SOURCE = OML_ENTITY_RELATIONSHIP__OML_SOURCE;

	/**
	 * The feature id for the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_UNREIFIED_RELATIONSHIP__OML_TARGET = OML_ENTITY_RELATIONSHIP__OML_TARGET;

	/**
	 * The number of structural features of the '<em>OML Unreified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_UNREIFIED_RELATIONSHIP_FEATURE_COUNT = OML_ENTITY_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_UNREIFIED_RELATIONSHIP___OML_INVERSE_REFERENCERS__CLASS = OML_ENTITY_RELATIONSHIP___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Unreified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_UNREIFIED_RELATIONSHIP_OPERATION_COUNT = OML_ENTITY_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityDataPropertyToScalarImpl <em>OML Entity Data Property To Scalar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityDataPropertyToScalarImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLEntityDataPropertyToScalar()
	 * @generated
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_SCALAR = 14;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_SCALAR__OML_ROOT = OML_RELATIONSHIP_FROM_ENTITY__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_SCALAR__OML_SOURCE = OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_SCALAR__VALUE = OML_RELATIONSHIP_FROM_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Entity Data Property To Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_SCALAR_FEATURE_COUNT = OML_RELATIONSHIP_FROM_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_SCALAR___OML_INVERSE_REFERENCERS__CLASS = OML_RELATIONSHIP_FROM_ENTITY___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Entity Data Property To Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_SCALAR_OPERATION_COUNT = OML_RELATIONSHIP_FROM_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityDataPropertyToStructureImpl <em>OML Entity Data Property To Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityDataPropertyToStructureImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLEntityDataPropertyToStructure()
	 * @generated
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE = 15;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE__OML_ROOT = OML_RELATIONSHIP_FROM_ENTITY__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE__OML_SOURCE = OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE;

	/**
	 * The feature id for the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET = OML_RELATIONSHIP_FROM_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Entity Data Property To Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE_FEATURE_COUNT = OML_RELATIONSHIP_FROM_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE___OML_INVERSE_REFERENCERS__CLASS = OML_RELATIONSHIP_FROM_ENTITY___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Entity Data Property To Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE_OPERATION_COUNT = OML_RELATIONSHIP_FROM_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToScalarImpl <em>OML Structure Data Property To Scalar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToScalarImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLStructureDataPropertyToScalar()
	 * @generated
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR = 16;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR__OML_ROOT = OML_RELATIONSHIP_FROM_STRUCTURE__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR__OML_SOURCE = OML_RELATIONSHIP_FROM_STRUCTURE__OML_SOURCE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR__VALUE = OML_RELATIONSHIP_FROM_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Structure Data Property To Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR_FEATURE_COUNT = OML_RELATIONSHIP_FROM_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR___OML_INVERSE_REFERENCERS__CLASS = OML_RELATIONSHIP_FROM_STRUCTURE___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Structure Data Property To Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR_OPERATION_COUNT = OML_RELATIONSHIP_FROM_STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToStructureImpl <em>OML Structure Data Property To Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToStructureImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLStructureDataPropertyToStructure()
	 * @generated
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE = 17;

	/**
	 * The feature id for the '<em><b>Oml Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_ROOT = OML_RELATIONSHIP_FROM_STRUCTURE__OML_ROOT;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_SOURCE = OML_RELATIONSHIP_FROM_STRUCTURE__OML_SOURCE;

	/**
	 * The feature id for the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE__OML_TARGET = OML_RELATIONSHIP_FROM_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OML Structure Data Property To Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE_FEATURE_COUNT = OML_RELATIONSHIP_FROM_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE___OML_INVERSE_REFERENCERS__CLASS = OML_RELATIONSHIP_FROM_STRUCTURE___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Structure Data Property To Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE_OPERATION_COUNT = OML_RELATIONSHIP_FROM_STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>IRI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getIRI()
	 * @generated
	 */
	int IRI = 18;

	/**
	 * The meta object id for the '<em>Lexical Value</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getLexicalValue()
	 * @generated
	 */
	int LEXICAL_VALUE = 19;


	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLObject <em>OML Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Object</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLObject
	 * @generated
	 */
	EClass getOMLObject();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.runtime.OMLObject#getOmlRoot <em>Oml Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Oml Root</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLObject#getOmlRoot()
	 * @see #getOMLObject()
	 * @generated
	 */
	EReference getOMLObject_OmlRoot();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.runtime.OMLObject#omlInverseReferencers(java.lang.Class) <em>Oml Inverse Referencers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Oml Inverse Referencers</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLObject#omlInverseReferencers(java.lang.Class)
	 * @generated
	 */
	EOperation getOMLObject__OmlInverseReferencers__Class();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription <em>OML Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Description</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLDescription
	 * @generated
	 */
	EClass getOMLDescription();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlDesciptionIRI <em>Oml Desciption IRI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oml Desciption IRI</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlDesciptionIRI()
	 * @see #getOMLDescription()
	 * @generated
	 */
	EAttribute getOMLDescription_OmlDesciptionIRI();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlDescriptionContents <em>Oml Description Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Oml Description Contents</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlDescriptionContents()
	 * @see #getOMLDescription()
	 * @generated
	 */
	EReference getOMLDescription_OmlDescriptionContents();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOMLRoot() <em>Get OML Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get OML Root</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOMLRoot()
	 * @generated
	 */
	EOperation getOMLDescription__GetOMLRoot();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLStructure <em>OML Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Structure</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLStructure
	 * @generated
	 */
	EClass getOMLStructure();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLScalar <em>OML Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Scalar</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLScalar
	 * @generated
	 */
	EClass getOMLScalar();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.runtime.OMLScalar#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLScalar#getValue()
	 * @see #getOMLScalar()
	 * @generated
	 */
	EAttribute getOMLScalar_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity <em>OML Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntity
	 * @generated
	 */
	EClass getOMLEntity();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLAspect <em>OML Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Aspect</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLAspect
	 * @generated
	 */
	EClass getOMLAspect();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLConcept <em>OML Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Concept</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLConcept
	 * @generated
	 */
	EClass getOMLConcept();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromEntity <em>OML Relationship From Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Relationship From Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromEntity
	 * @generated
	 */
	EClass getOMLRelationshipFromEntity();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromEntity#getOmlSource <em>Oml Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Oml Source</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromEntity#getOmlSource()
	 * @see #getOMLRelationshipFromEntity()
	 * @generated
	 */
	EReference getOMLRelationshipFromEntity_OmlSource();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromStructure <em>OML Relationship From Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Relationship From Structure</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromStructure
	 * @generated
	 */
	EClass getOMLRelationshipFromStructure();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromStructure#getOmlSource <em>Oml Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Oml Source</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromStructure#getOmlSource()
	 * @see #getOMLRelationshipFromStructure()
	 * @generated
	 */
	EReference getOMLRelationshipFromStructure_OmlSource();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToEntity <em>OML Relationship To Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Relationship To Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToEntity
	 * @generated
	 */
	EClass getOMLRelationshipToEntity();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToEntity#getOmlTarget <em>Oml Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Oml Target</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToEntity#getOmlTarget()
	 * @see #getOMLRelationshipToEntity()
	 * @generated
	 */
	EReference getOMLRelationshipToEntity_OmlTarget();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToStructure <em>OML Relationship To Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Relationship To Structure</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToStructure
	 * @generated
	 */
	EClass getOMLRelationshipToStructure();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToStructure#getOmlTarget <em>Oml Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Oml Target</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToStructure#getOmlTarget()
	 * @see #getOMLRelationshipToStructure()
	 * @generated
	 */
	EReference getOMLRelationshipToStructure_OmlTarget();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntityRelationship <em>OML Entity Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Entity Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntityRelationship
	 * @generated
	 */
	EClass getOMLEntityRelationship();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship <em>OML Reified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Reified Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship
	 * @generated
	 */
	EClass getOMLReifiedRelationship();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLUnreifiedRelationship <em>OML Unreified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Unreified Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLUnreifiedRelationship
	 * @generated
	 */
	EClass getOMLUnreifiedRelationship();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToScalar <em>OML Entity Data Property To Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Entity Data Property To Scalar</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToScalar
	 * @generated
	 */
	EClass getOMLEntityDataPropertyToScalar();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToScalar#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToScalar#getValue()
	 * @see #getOMLEntityDataPropertyToScalar()
	 * @generated
	 */
	EAttribute getOMLEntityDataPropertyToScalar_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToStructure <em>OML Entity Data Property To Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Entity Data Property To Structure</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToStructure
	 * @generated
	 */
	EClass getOMLEntityDataPropertyToStructure();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToScalar <em>OML Structure Data Property To Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Structure Data Property To Scalar</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToScalar
	 * @generated
	 */
	EClass getOMLStructureDataPropertyToScalar();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToScalar#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToScalar#getValue()
	 * @see #getOMLStructureDataPropertyToScalar()
	 * @generated
	 */
	EAttribute getOMLStructureDataPropertyToScalar_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToStructure <em>OML Structure Data Property To Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Structure Data Property To Structure</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToStructure
	 * @generated
	 */
	EClass getOMLStructureDataPropertyToStructure();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>IRI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IRI</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getIRI();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Lexical Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lexical Value</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getLexicalValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimeFactory getRuntimeFactory();

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
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLObjectImpl <em>OML Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLObjectImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLObject()
		 * @generated
		 */
		EClass OML_OBJECT = eINSTANCE.getOMLObject();

		/**
		 * The meta object literal for the '<em><b>Oml Root</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_OBJECT__OML_ROOT = eINSTANCE.getOMLObject_OmlRoot();

		/**
		 * The meta object literal for the '<em><b>Oml Inverse Referencers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS = eINSTANCE.getOMLObject__OmlInverseReferencers__Class();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLDescriptionImpl <em>OML Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLDescriptionImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLDescription()
		 * @generated
		 */
		EClass OML_DESCRIPTION = eINSTANCE.getOMLDescription();

		/**
		 * The meta object literal for the '<em><b>Oml Desciption IRI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OML_DESCRIPTION__OML_DESCIPTION_IRI = eINSTANCE.getOMLDescription_OmlDesciptionIRI();

		/**
		 * The meta object literal for the '<em><b>Oml Description Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS = eINSTANCE.getOMLDescription_OmlDescriptionContents();

		/**
		 * The meta object literal for the '<em><b>Get OML Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OML_DESCRIPTION___GET_OML_ROOT = eINSTANCE.getOMLDescription__GetOMLRoot();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureImpl <em>OML Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLStructure()
		 * @generated
		 */
		EClass OML_STRUCTURE = eINSTANCE.getOMLStructure();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLScalarImpl <em>OML Scalar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLScalarImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLScalar()
		 * @generated
		 */
		EClass OML_SCALAR = eINSTANCE.getOMLScalar();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OML_SCALAR__VALUE = eINSTANCE.getOMLScalar_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl <em>OML Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLEntity()
		 * @generated
		 */
		EClass OML_ENTITY = eINSTANCE.getOMLEntity();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLAspectImpl <em>OML Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLAspectImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLAspect()
		 * @generated
		 */
		EClass OML_ASPECT = eINSTANCE.getOMLAspect();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLConceptImpl <em>OML Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLConceptImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLConcept()
		 * @generated
		 */
		EClass OML_CONCEPT = eINSTANCE.getOMLConcept();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromEntityImpl <em>OML Relationship From Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromEntityImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLRelationshipFromEntity()
		 * @generated
		 */
		EClass OML_RELATIONSHIP_FROM_ENTITY = eINSTANCE.getOMLRelationshipFromEntity();

		/**
		 * The meta object literal for the '<em><b>Oml Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE = eINSTANCE.getOMLRelationshipFromEntity_OmlSource();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromStructureImpl <em>OML Relationship From Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipFromStructureImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLRelationshipFromStructure()
		 * @generated
		 */
		EClass OML_RELATIONSHIP_FROM_STRUCTURE = eINSTANCE.getOMLRelationshipFromStructure();

		/**
		 * The meta object literal for the '<em><b>Oml Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_RELATIONSHIP_FROM_STRUCTURE__OML_SOURCE = eINSTANCE.getOMLRelationshipFromStructure_OmlSource();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipToEntityImpl <em>OML Relationship To Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipToEntityImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLRelationshipToEntity()
		 * @generated
		 */
		EClass OML_RELATIONSHIP_TO_ENTITY = eINSTANCE.getOMLRelationshipToEntity();

		/**
		 * The meta object literal for the '<em><b>Oml Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_RELATIONSHIP_TO_ENTITY__OML_TARGET = eINSTANCE.getOMLRelationshipToEntity_OmlTarget();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipToStructureImpl <em>OML Relationship To Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRelationshipToStructureImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLRelationshipToStructure()
		 * @generated
		 */
		EClass OML_RELATIONSHIP_TO_STRUCTURE = eINSTANCE.getOMLRelationshipToStructure();

		/**
		 * The meta object literal for the '<em><b>Oml Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_RELATIONSHIP_TO_STRUCTURE__OML_TARGET = eINSTANCE.getOMLRelationshipToStructure_OmlTarget();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityRelationshipImpl <em>OML Entity Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLEntityRelationship()
		 * @generated
		 */
		EClass OML_ENTITY_RELATIONSHIP = eINSTANCE.getOMLEntityRelationship();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLReifiedRelationshipImpl <em>OML Reified Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLReifiedRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLReifiedRelationship()
		 * @generated
		 */
		EClass OML_REIFIED_RELATIONSHIP = eINSTANCE.getOMLReifiedRelationship();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLUnreifiedRelationshipImpl <em>OML Unreified Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLUnreifiedRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLUnreifiedRelationship()
		 * @generated
		 */
		EClass OML_UNREIFIED_RELATIONSHIP = eINSTANCE.getOMLUnreifiedRelationship();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityDataPropertyToScalarImpl <em>OML Entity Data Property To Scalar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityDataPropertyToScalarImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLEntityDataPropertyToScalar()
		 * @generated
		 */
		EClass OML_ENTITY_DATA_PROPERTY_TO_SCALAR = eINSTANCE.getOMLEntityDataPropertyToScalar();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OML_ENTITY_DATA_PROPERTY_TO_SCALAR__VALUE = eINSTANCE.getOMLEntityDataPropertyToScalar_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityDataPropertyToStructureImpl <em>OML Entity Data Property To Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityDataPropertyToStructureImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLEntityDataPropertyToStructure()
		 * @generated
		 */
		EClass OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE = eINSTANCE.getOMLEntityDataPropertyToStructure();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToScalarImpl <em>OML Structure Data Property To Scalar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToScalarImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLStructureDataPropertyToScalar()
		 * @generated
		 */
		EClass OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR = eINSTANCE.getOMLStructureDataPropertyToScalar();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR__VALUE = eINSTANCE.getOMLStructureDataPropertyToScalar_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToStructureImpl <em>OML Structure Data Property To Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureDataPropertyToStructureImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getOMLStructureDataPropertyToStructure()
		 * @generated
		 */
		EClass OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE = eINSTANCE.getOMLStructureDataPropertyToStructure();

		/**
		 * The meta object literal for the '<em>IRI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getIRI()
		 * @generated
		 */
		EDataType IRI = eINSTANCE.getIRI();

		/**
		 * The meta object literal for the '<em>Lexical Value</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.RuntimePackageImpl#getLexicalValue()
		 * @generated
		 */
		EDataType LEXICAL_VALUE = eINSTANCE.getLexicalValue();

	}

} //RuntimePackage
