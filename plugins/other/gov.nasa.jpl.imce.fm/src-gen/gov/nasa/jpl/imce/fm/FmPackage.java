/**
 */
package gov.nasa.jpl.imce.fm;

import java.lang.String;

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
 * @see gov.nasa.jpl.imce.fm.FmFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='gov.nasa.jpl.imce'"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel copyrightText='\nCopyright 2017 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n' modelPluginVariables='org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo' rootExtendsClass='org.eclipse.emf.internal.cdo.CDOObjectImpl' rootExtendsInterface='org.eclipse.emf.cdo.CDOObject' childCreationExtenders='true' complianceLevel='8.0' featureDelegation='None' modelDirectory='/gov.nasa.jpl.imce.fm/src-gen/'"
 * @generated
 */
public interface FmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://imce.jpl.nasa.gov/fm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FmPackage eINSTANCE = gov.nasa.jpl.imce.fm.impl.FmPackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.TypeImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.PrimitiveTypeImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.BooleanImpl <em>Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.BooleanImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.StringImpl <em>String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.StringImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getString()
	 * @generated
	 */
	int STRING = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.IntegerImpl <em>Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.IntegerImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.NaturalIntegerImpl <em>Natural Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.NaturalIntegerImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getNaturalInteger()
	 * @generated
	 */
	int NATURAL_INTEGER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURAL_INTEGER__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Natural Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURAL_INTEGER_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Natural Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATURAL_INTEGER_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.MetaclassImpl <em>Metaclass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.MetaclassImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getMetaclass()
	 * @generated
	 */
	int METACLASS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS__NAME = TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METACLASS_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.InformationCarryingMetaclassImpl <em>Information Carrying Metaclass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.InformationCarryingMetaclassImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getInformationCarryingMetaclass()
	 * @generated
	 */
	int INFORMATION_CARRYING_METACLASS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CARRYING_METACLASS__NAME = METACLASS__NAME;

	/**
	 * The number of structural features of the '<em>Information Carrying Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CARRYING_METACLASS_FEATURE_COUNT = METACLASS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Information Carrying Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CARRYING_METACLASS_OPERATION_COUNT = METACLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.InformationContainerMetaclassImpl <em>Information Container Metaclass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.InformationContainerMetaclassImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getInformationContainerMetaclass()
	 * @generated
	 */
	int INFORMATION_CONTAINER_METACLASS = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CONTAINER_METACLASS__NAME = METACLASS__NAME;

	/**
	 * The number of structural features of the '<em>Information Container Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CONTAINER_METACLASS_FEATURE_COUNT = METACLASS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Information Container Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CONTAINER_METACLASS_OPERATION_COUNT = METACLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.ValueImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__NAME = INFORMATION_CARRYING_METACLASS__NAME;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = INFORMATION_CARRYING_METACLASS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = INFORMATION_CARRYING_METACLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.EntityImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = INFORMATION_CARRYING_METACLASS__NAME;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = INFORMATION_CARRYING_METACLASS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = INFORMATION_CARRYING_METACLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.ExtentImpl <em>Extent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.ExtentImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getExtent()
	 * @generated
	 */
	int EXTENT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENT__NAME = INFORMATION_CONTAINER_METACLASS__NAME;

	/**
	 * The number of structural features of the '<em>Extent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENT_FEATURE_COUNT = INFORMATION_CONTAINER_METACLASS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Extent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENT_OPERATION_COUNT = INFORMATION_CONTAINER_METACLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.BinaryDirectedRelationshipImpl <em>Binary Directed Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.BinaryDirectedRelationshipImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getBinaryDirectedRelationship()
	 * @generated
	 */
	int BINARY_DIRECTED_RELATIONSHIP = 12;

	/**
	 * The number of structural features of the '<em>Binary Directed Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_DIRECTED_RELATIONSHIP___DOMAIN = 0;

	/**
	 * The operation id for the '<em>Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_DIRECTED_RELATIONSHIP___RANGE = 1;

	/**
	 * The number of operations of the '<em>Binary Directed Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.BinaryCompositeAssociationImpl <em>Binary Composite Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.BinaryCompositeAssociationImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getBinaryCompositeAssociation()
	 * @generated
	 */
	int BINARY_COMPOSITE_ASSOCIATION = 13;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPOSITE_ASSOCIATION__SOURCE = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPOSITE_ASSOCIATION__SOURCE_ROLE_NAME = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPOSITE_ASSOCIATION__TARGET = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPOSITE_ASSOCIATION__TARGET_ROLE_NAME = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Binary Composite Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPOSITE_ASSOCIATION_FEATURE_COUNT = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPOSITE_ASSOCIATION___DOMAIN = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPOSITE_ASSOCIATION___RANGE = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Binary Composite Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPOSITE_ASSOCIATION_OPERATION_COUNT = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.EssentialReferenceImpl <em>Essential Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.EssentialReferenceImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getEssentialReference()
	 * @generated
	 */
	int ESSENTIAL_REFERENCE = 14;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_REFERENCE__SOURCE = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_REFERENCE__TARGET = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_REFERENCE__REFERENCE_NAME = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Essential Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_REFERENCE_FEATURE_COUNT = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_REFERENCE___DOMAIN = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_REFERENCE___RANGE = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Essential Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_REFERENCE_OPERATION_COUNT = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.fm.impl.EssentialAttributeImpl <em>Essential Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.impl.EssentialAttributeImpl
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getEssentialAttribute()
	 * @generated
	 */
	int ESSENTIAL_ATTRIBUTE = 15;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_ATTRIBUTE__SOURCE = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_ATTRIBUTE__TARGET = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_ATTRIBUTE__ATTRIBUTE_NAME = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Essential Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_ATTRIBUTE_FEATURE_COUNT = BINARY_DIRECTED_RELATIONSHIP_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_ATTRIBUTE___DOMAIN = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Range</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_ATTRIBUTE___RANGE = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Essential Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESSENTIAL_ATTRIBUTE_OPERATION_COUNT = BINARY_DIRECTED_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '<em>DT String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.fm.String
	 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getDTString()
	 * @generated
	 */
	int DT_STRING = 16;


	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see gov.nasa.jpl.imce.fm.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.fm.Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gov.nasa.jpl.imce.fm.Type#getName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Name();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see gov.nasa.jpl.imce.fm.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.Boolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean</em>'.
	 * @see gov.nasa.jpl.imce.fm.Boolean
	 * @generated
	 */
	EClass getBoolean();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String</em>'.
	 * @see gov.nasa.jpl.imce.fm.String
	 * @generated
	 */
	EClass getString();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer</em>'.
	 * @see gov.nasa.jpl.imce.fm.Integer
	 * @generated
	 */
	EClass getInteger();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.NaturalInteger <em>Natural Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Natural Integer</em>'.
	 * @see gov.nasa.jpl.imce.fm.NaturalInteger
	 * @generated
	 */
	EClass getNaturalInteger();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.Metaclass <em>Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metaclass</em>'.
	 * @see gov.nasa.jpl.imce.fm.Metaclass
	 * @generated
	 */
	EClass getMetaclass();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.InformationCarryingMetaclass <em>Information Carrying Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information Carrying Metaclass</em>'.
	 * @see gov.nasa.jpl.imce.fm.InformationCarryingMetaclass
	 * @generated
	 */
	EClass getInformationCarryingMetaclass();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.InformationContainerMetaclass <em>Information Container Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information Container Metaclass</em>'.
	 * @see gov.nasa.jpl.imce.fm.InformationContainerMetaclass
	 * @generated
	 */
	EClass getInformationContainerMetaclass();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.fm.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see gov.nasa.jpl.imce.fm.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.Extent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extent</em>'.
	 * @see gov.nasa.jpl.imce.fm.Extent
	 * @generated
	 */
	EClass getExtent();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.BinaryDirectedRelationship <em>Binary Directed Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Directed Relationship</em>'.
	 * @see gov.nasa.jpl.imce.fm.BinaryDirectedRelationship
	 * @generated
	 */
	EClass getBinaryDirectedRelationship();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.fm.BinaryDirectedRelationship#domain() <em>Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.fm.BinaryDirectedRelationship#domain()
	 * @generated
	 */
	EOperation getBinaryDirectedRelationship__Domain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.fm.BinaryDirectedRelationship#range() <em>Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Range</em>' operation.
	 * @see gov.nasa.jpl.imce.fm.BinaryDirectedRelationship#range()
	 * @generated
	 */
	EOperation getBinaryDirectedRelationship__Range();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation <em>Binary Composite Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Composite Association</em>'.
	 * @see gov.nasa.jpl.imce.fm.BinaryCompositeAssociation
	 * @generated
	 */
	EClass getBinaryCompositeAssociation();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getSource()
	 * @see #getBinaryCompositeAssociation()
	 * @generated
	 */
	EReference getBinaryCompositeAssociation_Source();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getSourceRoleName <em>Source Role Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Role Name</em>'.
	 * @see gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getSourceRoleName()
	 * @see #getBinaryCompositeAssociation()
	 * @generated
	 */
	EAttribute getBinaryCompositeAssociation_SourceRoleName();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getTarget()
	 * @see #getBinaryCompositeAssociation()
	 * @generated
	 */
	EReference getBinaryCompositeAssociation_Target();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getTargetRoleName <em>Target Role Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Role Name</em>'.
	 * @see gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#getTargetRoleName()
	 * @see #getBinaryCompositeAssociation()
	 * @generated
	 */
	EAttribute getBinaryCompositeAssociation_TargetRoleName();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#domain() <em>Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#domain()
	 * @generated
	 */
	EOperation getBinaryCompositeAssociation__Domain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#range() <em>Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Range</em>' operation.
	 * @see gov.nasa.jpl.imce.fm.BinaryCompositeAssociation#range()
	 * @generated
	 */
	EOperation getBinaryCompositeAssociation__Range();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.EssentialReference <em>Essential Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Essential Reference</em>'.
	 * @see gov.nasa.jpl.imce.fm.EssentialReference
	 * @generated
	 */
	EClass getEssentialReference();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.fm.EssentialReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see gov.nasa.jpl.imce.fm.EssentialReference#getSource()
	 * @see #getEssentialReference()
	 * @generated
	 */
	EReference getEssentialReference_Source();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.fm.EssentialReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see gov.nasa.jpl.imce.fm.EssentialReference#getTarget()
	 * @see #getEssentialReference()
	 * @generated
	 */
	EReference getEssentialReference_Target();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.fm.EssentialReference#getReferenceName <em>Reference Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Name</em>'.
	 * @see gov.nasa.jpl.imce.fm.EssentialReference#getReferenceName()
	 * @see #getEssentialReference()
	 * @generated
	 */
	EAttribute getEssentialReference_ReferenceName();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.fm.EssentialReference#domain() <em>Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.fm.EssentialReference#domain()
	 * @generated
	 */
	EOperation getEssentialReference__Domain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.fm.EssentialReference#range() <em>Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Range</em>' operation.
	 * @see gov.nasa.jpl.imce.fm.EssentialReference#range()
	 * @generated
	 */
	EOperation getEssentialReference__Range();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.fm.EssentialAttribute <em>Essential Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Essential Attribute</em>'.
	 * @see gov.nasa.jpl.imce.fm.EssentialAttribute
	 * @generated
	 */
	EClass getEssentialAttribute();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see gov.nasa.jpl.imce.fm.EssentialAttribute#getSource()
	 * @see #getEssentialAttribute()
	 * @generated
	 */
	EReference getEssentialAttribute_Source();

	/**
	 * Returns the meta object for the reference '{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see gov.nasa.jpl.imce.fm.EssentialAttribute#getTarget()
	 * @see #getEssentialAttribute()
	 * @generated
	 */
	EReference getEssentialAttribute_Target();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.fm.EssentialAttribute#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see gov.nasa.jpl.imce.fm.EssentialAttribute#getAttributeName()
	 * @see #getEssentialAttribute()
	 * @generated
	 */
	EAttribute getEssentialAttribute_AttributeName();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.fm.EssentialAttribute#domain() <em>Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Domain</em>' operation.
	 * @see gov.nasa.jpl.imce.fm.EssentialAttribute#domain()
	 * @generated
	 */
	EOperation getEssentialAttribute__Domain();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.fm.EssentialAttribute#range() <em>Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Range</em>' operation.
	 * @see gov.nasa.jpl.imce.fm.EssentialAttribute#range()
	 * @generated
	 */
	EOperation getEssentialAttribute__Range();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.fm.String <em>DT String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>DT String</em>'.
	 * @see gov.nasa.jpl.imce.fm.String
	 * @model instanceClass="gov.nasa.jpl.imce.fm.String"
	 * @generated
	 */
	EDataType getDTString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FmFactory getFmFactory();

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
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.TypeImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__NAME = eINSTANCE.getType_Name();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.PrimitiveTypeImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.BooleanImpl <em>Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.BooleanImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getBoolean()
		 * @generated
		 */
		EClass BOOLEAN = eINSTANCE.getBoolean();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.StringImpl <em>String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.StringImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getString()
		 * @generated
		 */
		EClass STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.IntegerImpl <em>Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.IntegerImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getInteger()
		 * @generated
		 */
		EClass INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.NaturalIntegerImpl <em>Natural Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.NaturalIntegerImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getNaturalInteger()
		 * @generated
		 */
		EClass NATURAL_INTEGER = eINSTANCE.getNaturalInteger();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.MetaclassImpl <em>Metaclass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.MetaclassImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getMetaclass()
		 * @generated
		 */
		EClass METACLASS = eINSTANCE.getMetaclass();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.InformationCarryingMetaclassImpl <em>Information Carrying Metaclass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.InformationCarryingMetaclassImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getInformationCarryingMetaclass()
		 * @generated
		 */
		EClass INFORMATION_CARRYING_METACLASS = eINSTANCE.getInformationCarryingMetaclass();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.InformationContainerMetaclassImpl <em>Information Container Metaclass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.InformationContainerMetaclassImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getInformationContainerMetaclass()
		 * @generated
		 */
		EClass INFORMATION_CONTAINER_METACLASS = eINSTANCE.getInformationContainerMetaclass();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.ValueImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.EntityImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.ExtentImpl <em>Extent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.ExtentImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getExtent()
		 * @generated
		 */
		EClass EXTENT = eINSTANCE.getExtent();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.BinaryDirectedRelationshipImpl <em>Binary Directed Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.BinaryDirectedRelationshipImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getBinaryDirectedRelationship()
		 * @generated
		 */
		EClass BINARY_DIRECTED_RELATIONSHIP = eINSTANCE.getBinaryDirectedRelationship();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_DIRECTED_RELATIONSHIP___DOMAIN = eINSTANCE.getBinaryDirectedRelationship__Domain();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_DIRECTED_RELATIONSHIP___RANGE = eINSTANCE.getBinaryDirectedRelationship__Range();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.BinaryCompositeAssociationImpl <em>Binary Composite Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.BinaryCompositeAssociationImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getBinaryCompositeAssociation()
		 * @generated
		 */
		EClass BINARY_COMPOSITE_ASSOCIATION = eINSTANCE.getBinaryCompositeAssociation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_COMPOSITE_ASSOCIATION__SOURCE = eINSTANCE.getBinaryCompositeAssociation_Source();

		/**
		 * The meta object literal for the '<em><b>Source Role Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_COMPOSITE_ASSOCIATION__SOURCE_ROLE_NAME = eINSTANCE.getBinaryCompositeAssociation_SourceRoleName();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_COMPOSITE_ASSOCIATION__TARGET = eINSTANCE.getBinaryCompositeAssociation_Target();

		/**
		 * The meta object literal for the '<em><b>Target Role Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_COMPOSITE_ASSOCIATION__TARGET_ROLE_NAME = eINSTANCE.getBinaryCompositeAssociation_TargetRoleName();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_COMPOSITE_ASSOCIATION___DOMAIN = eINSTANCE.getBinaryCompositeAssociation__Domain();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_COMPOSITE_ASSOCIATION___RANGE = eINSTANCE.getBinaryCompositeAssociation__Range();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.EssentialReferenceImpl <em>Essential Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.EssentialReferenceImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getEssentialReference()
		 * @generated
		 */
		EClass ESSENTIAL_REFERENCE = eINSTANCE.getEssentialReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESSENTIAL_REFERENCE__SOURCE = eINSTANCE.getEssentialReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESSENTIAL_REFERENCE__TARGET = eINSTANCE.getEssentialReference_Target();

		/**
		 * The meta object literal for the '<em><b>Reference Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESSENTIAL_REFERENCE__REFERENCE_NAME = eINSTANCE.getEssentialReference_ReferenceName();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ESSENTIAL_REFERENCE___DOMAIN = eINSTANCE.getEssentialReference__Domain();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ESSENTIAL_REFERENCE___RANGE = eINSTANCE.getEssentialReference__Range();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.fm.impl.EssentialAttributeImpl <em>Essential Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.impl.EssentialAttributeImpl
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getEssentialAttribute()
		 * @generated
		 */
		EClass ESSENTIAL_ATTRIBUTE = eINSTANCE.getEssentialAttribute();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESSENTIAL_ATTRIBUTE__SOURCE = eINSTANCE.getEssentialAttribute_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESSENTIAL_ATTRIBUTE__TARGET = eINSTANCE.getEssentialAttribute_Target();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESSENTIAL_ATTRIBUTE__ATTRIBUTE_NAME = eINSTANCE.getEssentialAttribute_AttributeName();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ESSENTIAL_ATTRIBUTE___DOMAIN = eINSTANCE.getEssentialAttribute__Domain();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ESSENTIAL_ATTRIBUTE___RANGE = eINSTANCE.getEssentialAttribute__Range();

		/**
		 * The meta object literal for the '<em>DT String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.fm.String
		 * @see gov.nasa.jpl.imce.fm.impl.FmPackageImpl#getDTString()
		 * @generated
		 */
		EDataType DT_STRING = eINSTANCE.getDTString();

	}

} //FmPackage
