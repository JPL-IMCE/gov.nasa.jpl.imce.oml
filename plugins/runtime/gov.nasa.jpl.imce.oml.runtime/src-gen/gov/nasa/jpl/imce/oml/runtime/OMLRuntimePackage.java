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
 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimeFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel copyrightText='\nCopyright 2017 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' childCreationExtenders='true' extensibleProviderFactory='true' complianceLevel='8.0' featureDelegation='None' modelName='OMLRuntime' prefix='OMLRuntime' modelDirectory='/gov.nasa.jpl.imce.oml.runtime/src-gen/' editDirectory='/gov.nasa.jpl.imce.oml.runtime.edit/src-gen/' basePackage='gov.nasa.jpl.imce.oml'"
 *        annotation="http://www.eclipse.org/emf/2011/Xcore OMLProvenance='http://imce.jpl.nasa.gov/oml/runtime/OMLProvenance'"
 * @generated
 */
public interface OMLRuntimePackage extends EPackage {
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
	OMLRuntimePackage eINSTANCE = gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLObjectImpl <em>OML Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLObjectImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLObject()
	 * @generated
	 */
	int OML_OBJECT = 0;

	/**
	 * The number of structural features of the '<em>OML Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_OBJECT_FEATURE_COUNT = 0;

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
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLDescription()
	 * @generated
	 */
	int OML_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Oml IRI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION__OML_IRI = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Oml Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION__OML_CONTENTS = OML_OBJECT_FEATURE_COUNT + 1;

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
	 * The number of operations of the '<em>OML Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_DESCRIPTION_OPERATION_COUNT = OML_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureImpl <em>OML Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLStructure()
	 * @generated
	 */
	int OML_STRUCTURE = 2;

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
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl <em>OML Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLEntity()
	 * @generated
	 */
	int OML_ENTITY = 3;

	/**
	 * The feature id for the '<em><b>Oml Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY__OML_NAME = OML_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Oml Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY__OML_DESCRIPTION = OML_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OML Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ENTITY_FEATURE_COUNT = OML_OBJECT_FEATURE_COUNT + 2;

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
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLAspect()
	 * @generated
	 */
	int OML_ASPECT = 4;

	/**
	 * The feature id for the '<em><b>Oml Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ASPECT__OML_NAME = OML_ENTITY__OML_NAME;

	/**
	 * The feature id for the '<em><b>Oml Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_ASPECT__OML_DESCRIPTION = OML_ENTITY__OML_DESCRIPTION;

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
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLConcept()
	 * @generated
	 */
	int OML_CONCEPT = 5;

	/**
	 * The feature id for the '<em><b>Oml Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_CONCEPT__OML_NAME = OML_ENTITY__OML_NAME;

	/**
	 * The feature id for the '<em><b>Oml Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_CONCEPT__OML_DESCRIPTION = OML_ENTITY__OML_DESCRIPTION;

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
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLReifiedRelationshipImpl <em>OML Reified Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLReifiedRelationshipImpl
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLReifiedRelationship()
	 * @generated
	 */
	int OML_REIFIED_RELATIONSHIP = 6;

	/**
	 * The feature id for the '<em><b>Oml Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP__OML_NAME = OML_ENTITY__OML_NAME;

	/**
	 * The feature id for the '<em><b>Oml Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP__OML_DESCRIPTION = OML_ENTITY__OML_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Oml Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP__OML_SOURCE = OML_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Oml Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP__OML_TARGET = OML_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OML Reified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP_FEATURE_COUNT = OML_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Oml Inverse Referencers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP___OML_INVERSE_REFERENCERS__CLASS = OML_ENTITY___OML_INVERSE_REFERENCERS__CLASS;

	/**
	 * The number of operations of the '<em>OML Reified Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OML_REIFIED_RELATIONSHIP_OPERATION_COUNT = OML_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>IRI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getIRI()
	 * @generated
	 */
	int IRI = 7;

	/**
	 * The meta object id for the '<em>Local Name</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getLocalName()
	 * @generated
	 */
	int LOCAL_NAME = 8;

	/**
	 * The meta object id for the '<em>Lexical Value</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getLexicalValue()
	 * @generated
	 */
	int LEXICAL_VALUE = 9;


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
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlIRI <em>Oml IRI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oml IRI</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlIRI()
	 * @see #getOMLDescription()
	 * @generated
	 */
	EAttribute getOMLDescription_OmlIRI();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlContents <em>Oml Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Oml Contents</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLDescription#getOmlContents()
	 * @see #getOMLDescription()
	 * @generated
	 */
	EReference getOMLDescription_OmlContents();

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
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity <em>OML Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Entity</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntity
	 * @generated
	 */
	EClass getOMLEntity();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlName <em>Oml Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oml Name</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlName()
	 * @see #getOMLEntity()
	 * @generated
	 */
	EAttribute getOMLEntity_OmlName();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlDescription <em>Oml Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Oml Description</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntity#getOmlDescription()
	 * @see #getOMLEntity()
	 * @generated
	 */
	EReference getOMLEntity_OmlDescription();

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
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship <em>OML Reified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OML Reified Relationship</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship
	 * @generated
	 */
	EClass getOMLReifiedRelationship();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship#getOmlSource <em>Oml Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Oml Source</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship#getOmlSource()
	 * @see #getOMLReifiedRelationship()
	 * @generated
	 */
	EReference getOMLReifiedRelationship_OmlSource();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship#getOmlTarget <em>Oml Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Oml Target</em>'.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship#getOmlTarget()
	 * @see #getOMLReifiedRelationship()
	 * @generated
	 */
	EReference getOMLReifiedRelationship_OmlTarget();

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
	 * Returns the meta object for data type '{@link java.lang.String <em>Local Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Local Name</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getLocalName();

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
	OMLRuntimeFactory getOMLRuntimeFactory();

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
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLObject()
		 * @generated
		 */
		EClass OML_OBJECT = eINSTANCE.getOMLObject();

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
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLDescription()
		 * @generated
		 */
		EClass OML_DESCRIPTION = eINSTANCE.getOMLDescription();

		/**
		 * The meta object literal for the '<em><b>Oml IRI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OML_DESCRIPTION__OML_IRI = eINSTANCE.getOMLDescription_OmlIRI();

		/**
		 * The meta object literal for the '<em><b>Oml Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_DESCRIPTION__OML_CONTENTS = eINSTANCE.getOMLDescription_OmlContents();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureImpl <em>OML Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLStructureImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLStructure()
		 * @generated
		 */
		EClass OML_STRUCTURE = eINSTANCE.getOMLStructure();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl <em>OML Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLEntityImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLEntity()
		 * @generated
		 */
		EClass OML_ENTITY = eINSTANCE.getOMLEntity();

		/**
		 * The meta object literal for the '<em><b>Oml Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OML_ENTITY__OML_NAME = eINSTANCE.getOMLEntity_OmlName();

		/**
		 * The meta object literal for the '<em><b>Oml Description</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_ENTITY__OML_DESCRIPTION = eINSTANCE.getOMLEntity_OmlDescription();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLAspectImpl <em>OML Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLAspectImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLAspect()
		 * @generated
		 */
		EClass OML_ASPECT = eINSTANCE.getOMLAspect();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLConceptImpl <em>OML Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLConceptImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLConcept()
		 * @generated
		 */
		EClass OML_CONCEPT = eINSTANCE.getOMLConcept();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.runtime.impl.OMLReifiedRelationshipImpl <em>OML Reified Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLReifiedRelationshipImpl
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getOMLReifiedRelationship()
		 * @generated
		 */
		EClass OML_REIFIED_RELATIONSHIP = eINSTANCE.getOMLReifiedRelationship();

		/**
		 * The meta object literal for the '<em><b>Oml Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_REIFIED_RELATIONSHIP__OML_SOURCE = eINSTANCE.getOMLReifiedRelationship_OmlSource();

		/**
		 * The meta object literal for the '<em><b>Oml Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OML_REIFIED_RELATIONSHIP__OML_TARGET = eINSTANCE.getOMLReifiedRelationship_OmlTarget();

		/**
		 * The meta object literal for the '<em>IRI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getIRI()
		 * @generated
		 */
		EDataType IRI = eINSTANCE.getIRI();

		/**
		 * The meta object literal for the '<em>Local Name</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getLocalName()
		 * @generated
		 */
		EDataType LOCAL_NAME = eINSTANCE.getLocalName();

		/**
		 * The meta object literal for the '<em>Lexical Value</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimePackageImpl#getLexicalValue()
		 * @generated
		 */
		EDataType LEXICAL_VALUE = eINSTANCE.getLexicalValue();

	}

} //OMLRuntimePackage
