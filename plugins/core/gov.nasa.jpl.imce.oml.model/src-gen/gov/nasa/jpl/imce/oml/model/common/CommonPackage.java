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
package gov.nasa.jpl.imce.oml.model.common;

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
 * @see gov.nasa.jpl.imce.oml.model.common.CommonFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel copyrightText='\nCopyright 2017 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' childCreationExtenders='true' complianceLevel='8.0' featureDelegation='None' modelDirectory='/gov.nasa.jpl.imce.oml.model/src-gen/' editDirectory='/gov.nasa.jpl.imce.oml.model.edit/src-gen/' editPluginClass='gov.nasa.jpl.imce.oml.model.edit.provider.OMLEditPlugin' basePackage='gov.nasa.jpl.imce.oml.model'"
 *        annotation="http://www.eclipse.org/emf/2011/Xcore Collection='http://imce.jpl.nasa.gov/oml/Collection' ResolverAPI='http://imce.jpl.nasa.gov/oml/ResolverAPI' Override='http://imce.jpl.nasa.gov/oml/Override' OverrideVal='http://imce.jpl.nasa.gov/oml/OverrideVal' NotFunctionalAPI='http://imce.jpl.nasa.gov/oml/NotFunctionalAPI' FunctionalInterface='http://imce.jpl.nasa.gov/oml/FunctionalInterface' NotSchema='http://imce.jpl.nasa.gov/oml/NotSchema' ValueTable='http://imce.jpl.nasa.gov/oml/ValueTable' Scala='http://imce.jpl.nasa.gov/oml/Scala' IsOrderingKey='http://imce.jpl.nasa.gov/oml/IsOrderingKey' CopyConstructor='http://imce.jpl.nasa.gov/oml/CopyConstructor' Glossary='http://imce.jpl.nasa.gov/oml/Glossary' ExtentContainer='http://imce.jpl.nasa.gov/oml/ExtentContainer' ExtentManaged='http://imce.jpl.nasa.gov/oml/ExtentManaged' Factory='http://imce.jpl.nasa.gov/oml/Factory' ImplicitExtent='http://imce.jpl.nasa.gov/oml/ImplicitExtent' NamespaceUUID='http://imce.jpl.nasa.gov/oml/NamespaceUUID' DerivedUUID='http://imce.jpl.nasa.gov/oml/DerivedUUID' IRIReference='http://imce.jpl.nasa.gov/oml/IRIReference'"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "common";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://imce.jpl.nasa.gov/oml/common";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "omlc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonPackage eINSTANCE = gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralPatternImpl <em>Literal Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralPatternImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralPattern()
	 * @generated
	 */
	int LITERAL_PATTERN = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PATTERN__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Literal Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PATTERN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Literal Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PATTERN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralValueImpl <em>Literal Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralValueImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralValue()
	 * @generated
	 */
	int LITERAL_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Literal Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Literal Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralDateTimeImpl <em>Literal Date Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralDateTimeImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralDateTime()
	 * @generated
	 */
	int LITERAL_DATE_TIME = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DATE_TIME__VALUE = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Date Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DATE_TIME_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Date Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DATE_TIME_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralLanguageTagImpl <em>Literal Language Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralLanguageTagImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralLanguageTag()
	 * @generated
	 */
	int LITERAL_LANGUAGE_TAG = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_LANGUAGE_TAG__VALUE = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Language Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_LANGUAGE_TAG_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Language Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_LANGUAGE_TAG_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralStringImpl <em>Literal String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralStringImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralString()
	 * @generated
	 */
	int LITERAL_STRING = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING__VALUE = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralUUIDImpl <em>Literal UUID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralUUIDImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralUUID()
	 * @generated
	 */
	int LITERAL_UUID = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_UUID__VALUE = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal UUID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_UUID_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal UUID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_UUID_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralURIImpl <em>Literal URI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralURIImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralURI()
	 * @generated
	 */
	int LITERAL_URI = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_URI__VALUE = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal URI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_URI_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal URI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_URI_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralNumberImpl <em>Literal Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralNumberImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralNumber()
	 * @generated
	 */
	int LITERAL_NUMBER = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NUMBER__VALUE = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NUMBER_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NUMBER_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl <em>Annotation Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAnnotationPropertyValue()
	 * @generated
	 */
	int ANNOTATION_PROPERTY_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE__UUID = 0;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE__SUBJECT = 1;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE__PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE__VALUE = 3;

	/**
	 * The number of structural features of the '<em>Annotation Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Annotation Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ElementImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__UUID = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ANNOTATIONS = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT___UUID = 0;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT___MODULE_CONTEXT = 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ResourceImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 10;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___IRI = 0;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___NAME = 1;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___ABBREV_IRI = 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl <em>Module Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getModuleElement()
	 * @generated
	 */
	int MODULE_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT__UUID = ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT__ANNOTATIONS = ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Module Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT___UUID = ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT___MODULE_CONTEXT = ELEMENT___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>All Nested Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT___ALL_NESTED_ELEMENTS = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Module Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleEdgeImpl <em>Module Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ModuleEdgeImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getModuleEdge()
	 * @generated
	 */
	int MODULE_EDGE = 12;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE__UUID = ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE__ANNOTATIONS = ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Module Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE___UUID = ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE___SOURCE_MODULE = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE___TARGET_MODULE = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE___MODULE_CONTEXT = ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Module Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl <em>Annotation Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAnnotationProperty()
	 * @generated
	 */
	int ANNOTATION_PROPERTY = 13;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__EXTENT = 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__UUID = 1;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__IRI = 2;

	/**
	 * The feature id for the '<em><b>Abbrev IRI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__ABBREV_IRI = 3;

	/**
	 * The number of structural features of the '<em>Annotation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Annotation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ExtentImpl <em>Extent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ExtentImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getExtent()
	 * @generated
	 */
	int EXTENT = 14;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENT__MODULES = 0;

	/**
	 * The feature id for the '<em><b>Annotation Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENT__ANNOTATION_PROPERTIES = 1;

	/**
	 * The number of structural features of the '<em>Extent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Extent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 15;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__UUID = ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ANNOTATIONS = ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EXTENT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__IRI = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Module Edges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___MODULE_EDGES = ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___IRI = ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Ns Prefix</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___NS_PREFIX = ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___NAME = ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___ABBREV_IRI = ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___UUID = ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___MODULE_CONTEXT = ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Module Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___MODULE_ELEMENTS = ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The meta object id for the '<em>IRI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getIRI()
	 * @generated
	 */
	int IRI = 16;

	/**
	 * The meta object id for the '<em>Local Name</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLocalName()
	 * @generated
	 */
	int LOCAL_NAME = 17;

	/**
	 * The meta object id for the '<em>UUID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getUUID()
	 * @generated
	 */
	int UUID = 18;

	/**
	 * The meta object id for the '<em>Abbrev IRI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAbbrevIRI()
	 * @generated
	 */
	int ABBREV_IRI = 19;

	/**
	 * The meta object id for the '<em>Namespace Prefix</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getNamespacePrefix()
	 * @generated
	 */
	int NAMESPACE_PREFIX = 20;


	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralPattern <em>Literal Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Pattern</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralPattern
	 * @generated
	 */
	EClass getLiteralPattern();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralPattern#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralPattern#getValue()
	 * @see #getLiteralPattern()
	 * @generated
	 */
	EAttribute getLiteralPattern_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralValue
	 * @generated
	 */
	EClass getLiteralValue();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime <em>Literal Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Date Time</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDateTime
	 * @generated
	 */
	EClass getLiteralDateTime();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#getValue()
	 * @see #getLiteralDateTime()
	 * @generated
	 */
	EAttribute getLiteralDateTime_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralLanguageTag <em>Literal Language Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Language Tag</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralLanguageTag
	 * @generated
	 */
	EClass getLiteralLanguageTag();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralLanguageTag#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralLanguageTag#getValue()
	 * @see #getLiteralLanguageTag()
	 * @generated
	 */
	EAttribute getLiteralLanguageTag_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralString <em>Literal String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal String</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralString
	 * @generated
	 */
	EClass getLiteralString();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralString#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralString#getValue()
	 * @see #getLiteralString()
	 * @generated
	 */
	EAttribute getLiteralString_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID <em>Literal UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal UUID</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralUUID
	 * @generated
	 */
	EClass getLiteralUUID();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralUUID#getValue()
	 * @see #getLiteralUUID()
	 * @generated
	 */
	EAttribute getLiteralUUID_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralURI <em>Literal URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal URI</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralURI
	 * @generated
	 */
	EClass getLiteralURI();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralURI#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralURI#getValue()
	 * @see #getLiteralURI()
	 * @generated
	 */
	EAttribute getLiteralURI_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralNumber <em>Literal Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Number</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralNumber
	 * @generated
	 */
	EClass getLiteralNumber();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralNumber#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralNumber#getValue()
	 * @see #getLiteralNumber()
	 * @generated
	 */
	EAttribute getLiteralNumber_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue <em>Annotation Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Property Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
	 * @generated
	 */
	EClass getAnnotationPropertyValue();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getUuid()
	 * @see #getAnnotationPropertyValue()
	 * @generated
	 */
	EAttribute getAnnotationPropertyValue_Uuid();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Subject</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getSubject()
	 * @see #getAnnotationPropertyValue()
	 * @generated
	 */
	EReference getAnnotationPropertyValue_Subject();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getProperty()
	 * @see #getAnnotationPropertyValue()
	 * @generated
	 */
	EReference getAnnotationPropertyValue_Property();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getValue()
	 * @see #getAnnotationPropertyValue()
	 * @generated
	 */
	EAttribute getAnnotationPropertyValue_Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.Element#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Element#getUuid()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Uuid();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.common.Element#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Element#getAnnotations()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Annotations();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Element#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Element#uuid()
	 * @generated
	 */
	EOperation getElement__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Element#moduleContext() <em>Module Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Context</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Element#moduleContext()
	 * @generated
	 */
	EOperation getElement__ModuleContext();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Resource#iri() <em>Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Iri</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Resource#iri()
	 * @generated
	 */
	EOperation getResource__Iri();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Resource#name() <em>Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Name</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Resource#name()
	 * @generated
	 */
	EOperation getResource__Name();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Resource#abbrevIRI() <em>Abbrev IRI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Abbrev IRI</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Resource#abbrevIRI()
	 * @generated
	 */
	EOperation getResource__AbbrevIRI();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.ModuleElement <em>Module Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Element</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleElement
	 * @generated
	 */
	EClass getModuleElement();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.ModuleElement#allNestedElements() <em>All Nested Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Nested Elements</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleElement#allNestedElements()
	 * @generated
	 */
	EOperation getModuleElement__AllNestedElements();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.ModuleEdge <em>Module Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Edge</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleEdge
	 * @generated
	 */
	EClass getModuleEdge();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.ModuleEdge#sourceModule() <em>Source Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source Module</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleEdge#sourceModule()
	 * @generated
	 */
	EOperation getModuleEdge__SourceModule();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.ModuleEdge#targetModule() <em>Target Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Module</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleEdge#targetModule()
	 * @generated
	 */
	EOperation getModuleEdge__TargetModule();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.ModuleEdge#moduleContext() <em>Module Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Context</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleEdge#moduleContext()
	 * @generated
	 */
	EOperation getModuleEdge__ModuleContext();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty <em>Annotation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Property</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty
	 * @generated
	 */
	EClass getAnnotationProperty();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Extent</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getExtent()
	 * @see #getAnnotationProperty()
	 * @generated
	 */
	EReference getAnnotationProperty_Extent();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getUuid()
	 * @see #getAnnotationProperty()
	 * @generated
	 */
	EAttribute getAnnotationProperty_Uuid();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getIri <em>Iri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iri</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getIri()
	 * @see #getAnnotationProperty()
	 * @generated
	 */
	EAttribute getAnnotationProperty_Iri();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getAbbrevIRI <em>Abbrev IRI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abbrev IRI</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getAbbrevIRI()
	 * @see #getAnnotationProperty()
	 * @generated
	 */
	EAttribute getAnnotationProperty_AbbrevIRI();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.Extent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extent</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Extent
	 * @generated
	 */
	EClass getExtent();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.common.Extent#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modules</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Extent#getModules()
	 * @see #getExtent()
	 * @generated
	 */
	EReference getExtent_Modules();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.common.Extent#getAnnotationProperties <em>Annotation Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotation Properties</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Extent#getAnnotationProperties()
	 * @see #getExtent()
	 * @generated
	 */
	EReference getExtent_AnnotationProperties();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the container reference '{@link gov.nasa.jpl.imce.oml.model.common.Module#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Extent</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#getExtent()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Extent();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.Module#getIri <em>Iri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iri</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#getIri()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Iri();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Module#moduleEdges() <em>Module Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Edges</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#moduleEdges()
	 * @generated
	 */
	EOperation getModule__ModuleEdges();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Module#iri() <em>Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Iri</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#iri()
	 * @generated
	 */
	EOperation getModule__Iri();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Module#nsPrefix() <em>Ns Prefix</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Ns Prefix</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#nsPrefix()
	 * @generated
	 */
	EOperation getModule__NsPrefix();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Module#name() <em>Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Name</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#name()
	 * @generated
	 */
	EOperation getModule__Name();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Module#abbrevIRI() <em>Abbrev IRI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Abbrev IRI</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#abbrevIRI()
	 * @generated
	 */
	EOperation getModule__AbbrevIRI();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Module#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#uuid()
	 * @generated
	 */
	EOperation getModule__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Module#moduleContext() <em>Module Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Context</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#moduleContext()
	 * @generated
	 */
	EOperation getModule__ModuleContext();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.Module#moduleElements() <em>Module Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Elements</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#moduleElements()
	 * @generated
	 */
	EOperation getModule__ModuleElements();

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
	 * Returns the meta object for data type '{@link java.lang.String <em>UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UUID</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getUUID();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Abbrev IRI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Abbrev IRI</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getAbbrevIRI();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Namespace Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Namespace Prefix</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNamespacePrefix();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

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
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralPatternImpl <em>Literal Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralPatternImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralPattern()
		 * @generated
		 */
		EClass LITERAL_PATTERN = eINSTANCE.getLiteralPattern();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_PATTERN__VALUE = eINSTANCE.getLiteralPattern_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralValueImpl <em>Literal Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralValueImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralValue()
		 * @generated
		 */
		EClass LITERAL_VALUE = eINSTANCE.getLiteralValue();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralDateTimeImpl <em>Literal Date Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralDateTimeImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralDateTime()
		 * @generated
		 */
		EClass LITERAL_DATE_TIME = eINSTANCE.getLiteralDateTime();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_DATE_TIME__VALUE = eINSTANCE.getLiteralDateTime_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralLanguageTagImpl <em>Literal Language Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralLanguageTagImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralLanguageTag()
		 * @generated
		 */
		EClass LITERAL_LANGUAGE_TAG = eINSTANCE.getLiteralLanguageTag();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_LANGUAGE_TAG__VALUE = eINSTANCE.getLiteralLanguageTag_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralStringImpl <em>Literal String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralStringImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralString()
		 * @generated
		 */
		EClass LITERAL_STRING = eINSTANCE.getLiteralString();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_STRING__VALUE = eINSTANCE.getLiteralString_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralUUIDImpl <em>Literal UUID</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralUUIDImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralUUID()
		 * @generated
		 */
		EClass LITERAL_UUID = eINSTANCE.getLiteralUUID();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_UUID__VALUE = eINSTANCE.getLiteralUUID_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralURIImpl <em>Literal URI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralURIImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralURI()
		 * @generated
		 */
		EClass LITERAL_URI = eINSTANCE.getLiteralURI();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_URI__VALUE = eINSTANCE.getLiteralURI_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralNumberImpl <em>Literal Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralNumberImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralNumber()
		 * @generated
		 */
		EClass LITERAL_NUMBER = eINSTANCE.getLiteralNumber();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_NUMBER__VALUE = eINSTANCE.getLiteralNumber_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl <em>Annotation Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAnnotationPropertyValue()
		 * @generated
		 */
		EClass ANNOTATION_PROPERTY_VALUE = eINSTANCE.getAnnotationPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_PROPERTY_VALUE__UUID = eINSTANCE.getAnnotationPropertyValue_Uuid();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_PROPERTY_VALUE__SUBJECT = eINSTANCE.getAnnotationPropertyValue_Subject();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_PROPERTY_VALUE__PROPERTY = eINSTANCE.getAnnotationPropertyValue_Property();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_PROPERTY_VALUE__VALUE = eINSTANCE.getAnnotationPropertyValue_Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ElementImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__UUID = eINSTANCE.getElement_Uuid();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ANNOTATIONS = eINSTANCE.getElement_Annotations();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ELEMENT___UUID = eINSTANCE.getElement__Uuid();

		/**
		 * The meta object literal for the '<em><b>Module Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ELEMENT___MODULE_CONTEXT = eINSTANCE.getElement__ModuleContext();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ResourceImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RESOURCE___IRI = eINSTANCE.getResource__Iri();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RESOURCE___NAME = eINSTANCE.getResource__Name();

		/**
		 * The meta object literal for the '<em><b>Abbrev IRI</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RESOURCE___ABBREV_IRI = eINSTANCE.getResource__AbbrevIRI();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl <em>Module Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getModuleElement()
		 * @generated
		 */
		EClass MODULE_ELEMENT = eINSTANCE.getModuleElement();

		/**
		 * The meta object literal for the '<em><b>All Nested Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE_ELEMENT___ALL_NESTED_ELEMENTS = eINSTANCE.getModuleElement__AllNestedElements();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleEdgeImpl <em>Module Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ModuleEdgeImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getModuleEdge()
		 * @generated
		 */
		EClass MODULE_EDGE = eINSTANCE.getModuleEdge();

		/**
		 * The meta object literal for the '<em><b>Source Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE_EDGE___SOURCE_MODULE = eINSTANCE.getModuleEdge__SourceModule();

		/**
		 * The meta object literal for the '<em><b>Target Module</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE_EDGE___TARGET_MODULE = eINSTANCE.getModuleEdge__TargetModule();

		/**
		 * The meta object literal for the '<em><b>Module Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE_EDGE___MODULE_CONTEXT = eINSTANCE.getModuleEdge__ModuleContext();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl <em>Annotation Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAnnotationProperty()
		 * @generated
		 */
		EClass ANNOTATION_PROPERTY = eINSTANCE.getAnnotationProperty();

		/**
		 * The meta object literal for the '<em><b>Extent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_PROPERTY__EXTENT = eINSTANCE.getAnnotationProperty_Extent();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_PROPERTY__UUID = eINSTANCE.getAnnotationProperty_Uuid();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_PROPERTY__IRI = eINSTANCE.getAnnotationProperty_Iri();

		/**
		 * The meta object literal for the '<em><b>Abbrev IRI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_PROPERTY__ABBREV_IRI = eINSTANCE.getAnnotationProperty_AbbrevIRI();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ExtentImpl <em>Extent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ExtentImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getExtent()
		 * @generated
		 */
		EClass EXTENT = eINSTANCE.getExtent();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENT__MODULES = eINSTANCE.getExtent_Modules();

		/**
		 * The meta object literal for the '<em><b>Annotation Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENT__ANNOTATION_PROPERTIES = eINSTANCE.getExtent_AnnotationProperties();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ModuleImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Extent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__EXTENT = eINSTANCE.getModule_Extent();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__IRI = eINSTANCE.getModule_Iri();

		/**
		 * The meta object literal for the '<em><b>Module Edges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___MODULE_EDGES = eINSTANCE.getModule__ModuleEdges();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___IRI = eINSTANCE.getModule__Iri();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___NS_PREFIX = eINSTANCE.getModule__NsPrefix();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___NAME = eINSTANCE.getModule__Name();

		/**
		 * The meta object literal for the '<em><b>Abbrev IRI</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___ABBREV_IRI = eINSTANCE.getModule__AbbrevIRI();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___UUID = eINSTANCE.getModule__Uuid();

		/**
		 * The meta object literal for the '<em><b>Module Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___MODULE_CONTEXT = eINSTANCE.getModule__ModuleContext();

		/**
		 * The meta object literal for the '<em><b>Module Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___MODULE_ELEMENTS = eINSTANCE.getModule__ModuleElements();

		/**
		 * The meta object literal for the '<em>IRI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getIRI()
		 * @generated
		 */
		EDataType IRI = eINSTANCE.getIRI();

		/**
		 * The meta object literal for the '<em>Local Name</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLocalName()
		 * @generated
		 */
		EDataType LOCAL_NAME = eINSTANCE.getLocalName();

		/**
		 * The meta object literal for the '<em>UUID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getUUID()
		 * @generated
		 */
		EDataType UUID = eINSTANCE.getUUID();

		/**
		 * The meta object literal for the '<em>Abbrev IRI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAbbrevIRI()
		 * @generated
		 */
		EDataType ABBREV_IRI = eINSTANCE.getAbbrevIRI();

		/**
		 * The meta object literal for the '<em>Namespace Prefix</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getNamespacePrefix()
		 * @generated
		 */
		EDataType NAMESPACE_PREFIX = eINSTANCE.getNamespacePrefix();

	}

} //CommonPackage
