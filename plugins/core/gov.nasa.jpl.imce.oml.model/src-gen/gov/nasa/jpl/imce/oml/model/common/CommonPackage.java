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
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralValueImpl <em>Literal Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralValueImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralValue()
	 * @generated
	 */
	int LITERAL_VALUE = 0;

	/**
	 * The number of structural features of the '<em>Literal Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE___VALUE = 0;

	/**
	 * The number of operations of the '<em>Literal Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralBooleanImpl <em>Literal Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralBooleanImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralBoolean()
	 * @generated
	 */
	int LITERAL_BOOLEAN = 1;

	/**
	 * The feature id for the '<em><b>Bool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN__BOOL = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN___VALUE = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_BOOLEAN_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 1;

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
	 * The feature id for the '<em><b>Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DATE_TIME__DATE_TIME = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Date Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DATE_TIME_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DATE_TIME___VALUE = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Date Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DATE_TIME_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralStringImpl <em>Literal String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralStringImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralString()
	 * @generated
	 */
	int LITERAL_STRING = 3;

	/**
	 * The number of structural features of the '<em>Literal String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING___STRING_VALUE = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING___VALUE = LITERAL_VALUE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_STRING_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralQuotedStringImpl <em>Literal Quoted String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralQuotedStringImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralQuotedString()
	 * @generated
	 */
	int LITERAL_QUOTED_STRING = 4;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_QUOTED_STRING__STRING = LITERAL_STRING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Quoted String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_QUOTED_STRING_FEATURE_COUNT = LITERAL_STRING_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_QUOTED_STRING___VALUE = LITERAL_STRING___VALUE;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_QUOTED_STRING___STRING_VALUE = LITERAL_STRING_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Quoted String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_QUOTED_STRING_OPERATION_COUNT = LITERAL_STRING_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralRawStringImpl <em>Literal Raw String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralRawStringImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralRawString()
	 * @generated
	 */
	int LITERAL_RAW_STRING = 5;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RAW_STRING__STRING = LITERAL_STRING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Raw String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RAW_STRING_FEATURE_COUNT = LITERAL_STRING_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RAW_STRING___VALUE = LITERAL_STRING___VALUE;

	/**
	 * The operation id for the '<em>String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RAW_STRING___STRING_VALUE = LITERAL_STRING_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Raw String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RAW_STRING_OPERATION_COUNT = LITERAL_STRING_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralUUIDImpl <em>Literal UUID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralUUIDImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralUUID()
	 * @generated
	 */
	int LITERAL_UUID = 6;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_UUID__UUID = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal UUID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_UUID_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_UUID___VALUE = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal UUID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_UUID_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralURIImpl <em>Literal URI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralURIImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralURI()
	 * @generated
	 */
	int LITERAL_URI = 7;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_URI__URI = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal URI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_URI_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_URI___VALUE = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal URI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_URI_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralNumberImpl <em>Literal Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralNumberImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralNumber()
	 * @generated
	 */
	int LITERAL_NUMBER = 8;

	/**
	 * The number of structural features of the '<em>Literal Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NUMBER_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NUMBER___VALUE = LITERAL_VALUE___VALUE;

	/**
	 * The number of operations of the '<em>Literal Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_NUMBER_OPERATION_COUNT = LITERAL_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralRealImpl <em>Literal Real</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralRealImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralReal()
	 * @generated
	 */
	int LITERAL_REAL = 9;

	/**
	 * The feature id for the '<em><b>Real</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL__REAL = LITERAL_NUMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Real</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_FEATURE_COUNT = LITERAL_NUMBER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL___VALUE = LITERAL_NUMBER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Real</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_REAL_OPERATION_COUNT = LITERAL_NUMBER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralRationalImpl <em>Literal Rational</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralRationalImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralRational()
	 * @generated
	 */
	int LITERAL_RATIONAL = 10;

	/**
	 * The feature id for the '<em><b>Rational</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL__RATIONAL = LITERAL_NUMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Rational</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_FEATURE_COUNT = LITERAL_NUMBER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL___VALUE = LITERAL_NUMBER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Rational</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_RATIONAL_OPERATION_COUNT = LITERAL_NUMBER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralFloatImpl <em>Literal Float</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralFloatImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralFloat()
	 * @generated
	 */
	int LITERAL_FLOAT = 11;

	/**
	 * The feature id for the '<em><b>Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT__FLOAT = LITERAL_NUMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Float</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT_FEATURE_COUNT = LITERAL_NUMBER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT___VALUE = LITERAL_NUMBER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Float</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FLOAT_OPERATION_COUNT = LITERAL_NUMBER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralDecimalImpl <em>Literal Decimal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralDecimalImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralDecimal()
	 * @generated
	 */
	int LITERAL_DECIMAL = 12;

	/**
	 * The feature id for the '<em><b>Decimal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DECIMAL__DECIMAL = LITERAL_NUMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Decimal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DECIMAL_FEATURE_COUNT = LITERAL_NUMBER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DECIMAL___VALUE = LITERAL_NUMBER_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Decimal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DECIMAL_OPERATION_COUNT = LITERAL_NUMBER_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.CrossReferencabilityKindImpl <em>Cross Referencability Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CrossReferencabilityKindImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getCrossReferencabilityKind()
	 * @generated
	 */
	int CROSS_REFERENCABILITY_KIND = 13;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCABILITY_KIND__UUID = 0;

	/**
	 * The number of structural features of the '<em>Cross Referencability Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCABILITY_KIND_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCABILITY_KIND___UUID = 0;

	/**
	 * The number of operations of the '<em>Cross Referencability Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCABILITY_KIND_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.CrossReferencableKindImpl <em>Cross Referencable Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CrossReferencableKindImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getCrossReferencableKind()
	 * @generated
	 */
	int CROSS_REFERENCABLE_KIND = 14;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCABLE_KIND__UUID = CROSS_REFERENCABILITY_KIND__UUID;

	/**
	 * The number of structural features of the '<em>Cross Referencable Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCABLE_KIND_FEATURE_COUNT = CROSS_REFERENCABILITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCABLE_KIND___UUID = CROSS_REFERENCABILITY_KIND___UUID;

	/**
	 * The number of operations of the '<em>Cross Referencable Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_REFERENCABLE_KIND_OPERATION_COUNT = CROSS_REFERENCABILITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.NonCrossReferencableKindImpl <em>Non Cross Referencable Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.NonCrossReferencableKindImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getNonCrossReferencableKind()
	 * @generated
	 */
	int NON_CROSS_REFERENCABLE_KIND = 15;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CROSS_REFERENCABLE_KIND__UUID = CROSS_REFERENCABILITY_KIND__UUID;

	/**
	 * The number of structural features of the '<em>Non Cross Referencable Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CROSS_REFERENCABLE_KIND_FEATURE_COUNT = CROSS_REFERENCABILITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CROSS_REFERENCABLE_KIND___UUID = CROSS_REFERENCABILITY_KIND___UUID;

	/**
	 * The number of operations of the '<em>Non Cross Referencable Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_CROSS_REFERENCABLE_KIND_OPERATION_COUNT = CROSS_REFERENCABILITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.IdentityKindImpl <em>Identity Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.IdentityKindImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getIdentityKind()
	 * @generated
	 */
	int IDENTITY_KIND = 16;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_KIND__UUID = CROSS_REFERENCABILITY_KIND__UUID;

	/**
	 * The number of structural features of the '<em>Identity Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_KIND_FEATURE_COUNT = CROSS_REFERENCABILITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_KIND___UUID = CROSS_REFERENCABILITY_KIND___UUID;

	/**
	 * The number of operations of the '<em>Identity Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_KIND_OPERATION_COUNT = CROSS_REFERENCABILITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.IntrinsicIdentityKindImpl <em>Intrinsic Identity Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.IntrinsicIdentityKindImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getIntrinsicIdentityKind()
	 * @generated
	 */
	int INTRINSIC_IDENTITY_KIND = 17;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRINSIC_IDENTITY_KIND__UUID = IDENTITY_KIND__UUID;

	/**
	 * The number of structural features of the '<em>Intrinsic Identity Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRINSIC_IDENTITY_KIND_FEATURE_COUNT = IDENTITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRINSIC_IDENTITY_KIND___UUID = IDENTITY_KIND___UUID;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRINSIC_IDENTITY_KIND___IRI = IDENTITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Intrinsic Identity Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRINSIC_IDENTITY_KIND_OPERATION_COUNT = IDENTITY_KIND_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ExtrinsicIdentityKindImpl <em>Extrinsic Identity Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ExtrinsicIdentityKindImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getExtrinsicIdentityKind()
	 * @generated
	 */
	int EXTRINSIC_IDENTITY_KIND = 18;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRINSIC_IDENTITY_KIND__UUID = IDENTITY_KIND__UUID;

	/**
	 * The number of structural features of the '<em>Extrinsic Identity Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRINSIC_IDENTITY_KIND_FEATURE_COUNT = IDENTITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRINSIC_IDENTITY_KIND___UUID = IDENTITY_KIND___UUID;

	/**
	 * The number of operations of the '<em>Extrinsic Identity Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRINSIC_IDENTITY_KIND_OPERATION_COUNT = IDENTITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ElementCrossReferenceTupleImpl <em>Element Cross Reference Tuple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ElementCrossReferenceTupleImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getElementCrossReferenceTuple()
	 * @generated
	 */
	int ELEMENT_CROSS_REFERENCE_TUPLE = 19;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CROSS_REFERENCE_TUPLE__UUID = EXTRINSIC_IDENTITY_KIND__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CROSS_REFERENCE_TUPLE__ANNOTATIONS = EXTRINSIC_IDENTITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Cross Reference Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CROSS_REFERENCE_TUPLE_FEATURE_COUNT = EXTRINSIC_IDENTITY_KIND_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CROSS_REFERENCE_TUPLE___UUID = EXTRINSIC_IDENTITY_KIND___UUID;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CROSS_REFERENCE_TUPLE___MODULE_CONTEXT = EXTRINSIC_IDENTITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Element Cross Reference Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CROSS_REFERENCE_TUPLE_OPERATION_COUNT = EXTRINSIC_IDENTITY_KIND_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ValueCrossReferenceTupleImpl <em>Value Cross Reference Tuple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ValueCrossReferenceTupleImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getValueCrossReferenceTuple()
	 * @generated
	 */
	int VALUE_CROSS_REFERENCE_TUPLE = 20;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CROSS_REFERENCE_TUPLE__UUID = EXTRINSIC_IDENTITY_KIND__UUID;

	/**
	 * The number of structural features of the '<em>Value Cross Reference Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CROSS_REFERENCE_TUPLE_FEATURE_COUNT = EXTRINSIC_IDENTITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CROSS_REFERENCE_TUPLE___UUID = EXTRINSIC_IDENTITY_KIND___UUID;

	/**
	 * The number of operations of the '<em>Value Cross Reference Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_CROSS_REFERENCE_TUPLE_OPERATION_COUNT = EXTRINSIC_IDENTITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LogicalElementImpl <em>Logical Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.LogicalElementImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLogicalElement()
	 * @generated
	 */
	int LOGICAL_ELEMENT = 21;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT__UUID = IDENTITY_KIND__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT__ANNOTATIONS = IDENTITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Logical Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT_FEATURE_COUNT = IDENTITY_KIND_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT___UUID = IDENTITY_KIND___UUID;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT___MODULE_CONTEXT = IDENTITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Logical Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT_OPERATION_COUNT = IDENTITY_KIND_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.NonLogicalElementImpl <em>Non Logical Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.NonLogicalElementImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getNonLogicalElement()
	 * @generated
	 */
	int NON_LOGICAL_ELEMENT = 22;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LOGICAL_ELEMENT__UUID = IDENTITY_KIND__UUID;

	/**
	 * The number of structural features of the '<em>Non Logical Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LOGICAL_ELEMENT_FEATURE_COUNT = IDENTITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LOGICAL_ELEMENT___UUID = IDENTITY_KIND___UUID;

	/**
	 * The number of operations of the '<em>Non Logical Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_LOGICAL_ELEMENT_OPERATION_COUNT = IDENTITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ResourceImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 23;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__UUID = LOGICAL_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ANNOTATIONS = LOGICAL_ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = LOGICAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___UUID = LOGICAL_ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___MODULE_CONTEXT = LOGICAL_ELEMENT___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___IRI = LOGICAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___NAME = LOGICAL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___ABBREV_IRI = LOGICAL_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = LOGICAL_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl <em>Module Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ModuleElementImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getModuleElement()
	 * @generated
	 */
	int MODULE_ELEMENT = 24;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT__UUID = LOGICAL_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT__ANNOTATIONS = LOGICAL_ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Module Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT_FEATURE_COUNT = LOGICAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT___UUID = LOGICAL_ELEMENT___UUID;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT___MODULE_CONTEXT = LOGICAL_ELEMENT___MODULE_CONTEXT;

	/**
	 * The operation id for the '<em>All Nested Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT___ALL_NESTED_ELEMENTS = LOGICAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Module Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_ELEMENT_OPERATION_COUNT = LOGICAL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ModuleEdgeImpl <em>Module Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ModuleEdgeImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getModuleEdge()
	 * @generated
	 */
	int MODULE_EDGE = 25;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE__UUID = ELEMENT_CROSS_REFERENCE_TUPLE__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE__ANNOTATIONS = ELEMENT_CROSS_REFERENCE_TUPLE__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Module Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE_FEATURE_COUNT = ELEMENT_CROSS_REFERENCE_TUPLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE___UUID = ELEMENT_CROSS_REFERENCE_TUPLE___UUID;

	/**
	 * The operation id for the '<em>Source Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE___SOURCE_MODULE = ELEMENT_CROSS_REFERENCE_TUPLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Target Module</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE___TARGET_MODULE = ELEMENT_CROSS_REFERENCE_TUPLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE___MODULE_CONTEXT = ELEMENT_CROSS_REFERENCE_TUPLE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Module Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_EDGE_OPERATION_COUNT = ELEMENT_CROSS_REFERENCE_TUPLE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl <em>Annotation Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAnnotationProperty()
	 * @generated
	 */
	int ANNOTATION_PROPERTY = 26;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__UUID = INTRINSIC_IDENTITY_KIND__UUID;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__EXTENT = INTRINSIC_IDENTITY_KIND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__IRI = INTRINSIC_IDENTITY_KIND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abbrev IRI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY__ABBREV_IRI = INTRINSIC_IDENTITY_KIND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Annotation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_FEATURE_COUNT = INTRINSIC_IDENTITY_KIND_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___UUID = INTRINSIC_IDENTITY_KIND_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY___IRI = INTRINSIC_IDENTITY_KIND_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Annotation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_OPERATION_COUNT = INTRINSIC_IDENTITY_KIND_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl <em>Annotation Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.AnnotationPropertyValueImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAnnotationPropertyValue()
	 * @generated
	 */
	int ANNOTATION_PROPERTY_VALUE = 27;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE__UUID = VALUE_CROSS_REFERENCE_TUPLE__UUID;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE__SUBJECT = VALUE_CROSS_REFERENCE_TUPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE__PROPERTY = VALUE_CROSS_REFERENCE_TUPLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE__VALUE = VALUE_CROSS_REFERENCE_TUPLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Annotation Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE_FEATURE_COUNT = VALUE_CROSS_REFERENCE_TUPLE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE___UUID = VALUE_CROSS_REFERENCE_TUPLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Annotation Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_PROPERTY_VALUE_OPERATION_COUNT = VALUE_CROSS_REFERENCE_TUPLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ExtentImpl <em>Extent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.ExtentImpl
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getExtent()
	 * @generated
	 */
	int EXTENT = 28;

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
	int MODULE = 29;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__UUID = RESOURCE__UUID;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ANNOTATIONS = RESOURCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EXTENT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__IRI = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Module Edges</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___MODULE_EDGES = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Iri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___IRI = RESOURCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Ns Prefix</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___NS_PREFIX = RESOURCE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___NAME = RESOURCE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Abbrev IRI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___ABBREV_IRI = RESOURCE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Uuid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___UUID = RESOURCE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Module Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___MODULE_CONTEXT = RESOURCE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Module Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___MODULE_ELEMENTS = RESOURCE_OPERATION_COUNT + 7;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 8;

	/**
	 * The meta object id for the '<em>IRI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getIRI()
	 * @generated
	 */
	int IRI = 30;

	/**
	 * The meta object id for the '<em>Local Name</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLocalName()
	 * @generated
	 */
	int LOCAL_NAME = 31;

	/**
	 * The meta object id for the '<em>UUID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getUUID()
	 * @generated
	 */
	int UUID = 32;

	/**
	 * The meta object id for the '<em>Abbrev IRI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAbbrevIRI()
	 * @generated
	 */
	int ABBREV_IRI = 33;

	/**
	 * The meta object id for the '<em>Namespace Prefix</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getNamespacePrefix()
	 * @generated
	 */
	int NAMESPACE_PREFIX = 34;

	/**
	 * The meta object id for the '<em>Positive Integer Literal</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getPositiveIntegerLiteral()
	 * @generated
	 */
	int POSITIVE_INTEGER_LITERAL = 35;

	/**
	 * The meta object id for the '<em>Literal Pattern</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.PatternValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralPattern()
	 * @generated
	 */
	int LITERAL_PATTERN = 36;

	/**
	 * The meta object id for the '<em>Real Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.RealValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getRealDataType()
	 * @generated
	 */
	int REAL_DATA_TYPE = 37;

	/**
	 * The meta object id for the '<em>Rational Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.RationalValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getRationalDataType()
	 * @generated
	 */
	int RATIONAL_DATA_TYPE = 38;

	/**
	 * The meta object id for the '<em>Float Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.FloatValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getFloatDataType()
	 * @generated
	 */
	int FLOAT_DATA_TYPE = 39;

	/**
	 * The meta object id for the '<em>Abstract Decimal Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAbstractDecimalDataType()
	 * @generated
	 */
	int ABSTRACT_DECIMAL_DATA_TYPE = 40;

	/**
	 * The meta object id for the '<em>Decimal Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getDecimalDataType()
	 * @generated
	 */
	int DECIMAL_DATA_TYPE = 41;

	/**
	 * The meta object id for the '<em>Date Time Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getDateTimeDataType()
	 * @generated
	 */
	int DATE_TIME_DATA_TYPE = 42;

	/**
	 * The meta object id for the '<em>Language Tag Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLanguageTagDataType()
	 * @generated
	 */
	int LANGUAGE_TAG_DATA_TYPE = 43;

	/**
	 * The meta object id for the '<em>String Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.StringValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getStringDataType()
	 * @generated
	 */
	int STRING_DATA_TYPE = 44;

	/**
	 * The meta object id for the '<em>Raw String Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getRawStringDataType()
	 * @generated
	 */
	int RAW_STRING_DATA_TYPE = 45;

	/**
	 * The meta object id for the '<em>Quoted String Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getQuotedStringDataType()
	 * @generated
	 */
	int QUOTED_STRING_DATA_TYPE = 46;

	/**
	 * The meta object id for the '<em>UUID Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getUUIDDataType()
	 * @generated
	 */
	int UUID_DATA_TYPE = 47;

	/**
	 * The meta object id for the '<em>URI Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.URIValue
	 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getURIDataType()
	 * @generated
	 */
	int URI_DATA_TYPE = 48;


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
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralValue#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralValue#value()
	 * @generated
	 */
	EOperation getLiteralValue__Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralBoolean <em>Literal Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Boolean</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralBoolean
	 * @generated
	 */
	EClass getLiteralBoolean();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralBoolean#isBool <em>Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bool</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralBoolean#isBool()
	 * @see #getLiteralBoolean()
	 * @generated
	 */
	EAttribute getLiteralBoolean_Bool();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralBoolean#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralBoolean#value()
	 * @generated
	 */
	EOperation getLiteralBoolean__Value();

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
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#getDateTime <em>Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Time</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#getDateTime()
	 * @see #getLiteralDateTime()
	 * @generated
	 */
	EAttribute getLiteralDateTime_DateTime();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDateTime#value()
	 * @generated
	 */
	EOperation getLiteralDateTime__Value();

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
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralString#stringValue() <em>String Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>String Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralString#stringValue()
	 * @generated
	 */
	EOperation getLiteralString__StringValue();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralString#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralString#value()
	 * @generated
	 */
	EOperation getLiteralString__Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString <em>Literal Quoted String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Quoted String</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString
	 * @generated
	 */
	EClass getLiteralQuotedString();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString#getString()
	 * @see #getLiteralQuotedString()
	 * @generated
	 */
	EAttribute getLiteralQuotedString_String();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString#stringValue() <em>String Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>String Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString#stringValue()
	 * @generated
	 */
	EOperation getLiteralQuotedString__StringValue();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralRawString <em>Literal Raw String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Raw String</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralRawString
	 * @generated
	 */
	EClass getLiteralRawString();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralRawString#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralRawString#getString()
	 * @see #getLiteralRawString()
	 * @generated
	 */
	EAttribute getLiteralRawString_String();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralRawString#stringValue() <em>String Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>String Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralRawString#stringValue()
	 * @generated
	 */
	EOperation getLiteralRawString__StringValue();

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
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralUUID#getUuid()
	 * @see #getLiteralUUID()
	 * @generated
	 */
	EAttribute getLiteralUUID_Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralUUID#value()
	 * @generated
	 */
	EOperation getLiteralUUID__Value();

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
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralURI#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralURI#getUri()
	 * @see #getLiteralURI()
	 * @generated
	 */
	EAttribute getLiteralURI_Uri();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralURI#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralURI#value()
	 * @generated
	 */
	EOperation getLiteralURI__Value();

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
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralReal <em>Literal Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Real</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralReal
	 * @generated
	 */
	EClass getLiteralReal();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralReal#getReal <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralReal#getReal()
	 * @see #getLiteralReal()
	 * @generated
	 */
	EAttribute getLiteralReal_Real();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralReal#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralReal#value()
	 * @generated
	 */
	EOperation getLiteralReal__Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralRational <em>Literal Rational</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Rational</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralRational
	 * @generated
	 */
	EClass getLiteralRational();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralRational#getRational <em>Rational</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rational</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralRational#getRational()
	 * @see #getLiteralRational()
	 * @generated
	 */
	EAttribute getLiteralRational_Rational();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralRational#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralRational#value()
	 * @generated
	 */
	EOperation getLiteralRational__Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralFloat <em>Literal Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Float</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralFloat
	 * @generated
	 */
	EClass getLiteralFloat();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralFloat#getFloat <em>Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Float</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralFloat#getFloat()
	 * @see #getLiteralFloat()
	 * @generated
	 */
	EAttribute getLiteralFloat_Float();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralFloat#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralFloat#value()
	 * @generated
	 */
	EOperation getLiteralFloat__Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDecimal <em>Literal Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Decimal</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDecimal
	 * @generated
	 */
	EClass getLiteralDecimal();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDecimal#getDecimal <em>Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decimal</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDecimal#getDecimal()
	 * @see #getLiteralDecimal()
	 * @generated
	 */
	EAttribute getLiteralDecimal_Decimal();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDecimal#value() <em>Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Value</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDecimal#value()
	 * @generated
	 */
	EOperation getLiteralDecimal__Value();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind <em>Cross Referencability Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Referencability Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind
	 * @generated
	 */
	EClass getCrossReferencabilityKind();

	/**
	 * Returns the meta object for the attribute '{@link gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind#getUuid()
	 * @see #getCrossReferencabilityKind()
	 * @generated
	 */
	EAttribute getCrossReferencabilityKind_Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind#uuid()
	 * @generated
	 */
	EOperation getCrossReferencabilityKind__Uuid();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind <em>Cross Referencable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Referencable Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind
	 * @generated
	 */
	EClass getCrossReferencableKind();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.NonCrossReferencableKind <em>Non Cross Referencable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Cross Referencable Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.NonCrossReferencableKind
	 * @generated
	 */
	EClass getNonCrossReferencableKind();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.IdentityKind <em>Identity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.IdentityKind
	 * @generated
	 */
	EClass getIdentityKind();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind <em>Intrinsic Identity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intrinsic Identity Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind
	 * @generated
	 */
	EClass getIntrinsicIdentityKind();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind#iri() <em>Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Iri</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind#iri()
	 * @generated
	 */
	EOperation getIntrinsicIdentityKind__Iri();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind <em>Extrinsic Identity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extrinsic Identity Kind</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind
	 * @generated
	 */
	EClass getExtrinsicIdentityKind();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple <em>Element Cross Reference Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Cross Reference Tuple</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple
	 * @generated
	 */
	EClass getElementCrossReferenceTuple();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.ValueCrossReferenceTuple <em>Value Cross Reference Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Cross Reference Tuple</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.ValueCrossReferenceTuple
	 * @generated
	 */
	EClass getValueCrossReferenceTuple();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.LogicalElement <em>Logical Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Element</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LogicalElement
	 * @generated
	 */
	EClass getLogicalElement();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nasa.jpl.imce.oml.model.common.LogicalElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.LogicalElement#getAnnotations()
	 * @see #getLogicalElement()
	 * @generated
	 */
	EReference getLogicalElement_Annotations();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.LogicalElement#moduleContext() <em>Module Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Module Context</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.LogicalElement#moduleContext()
	 * @generated
	 */
	EOperation getLogicalElement__ModuleContext();

	/**
	 * Returns the meta object for class '{@link gov.nasa.jpl.imce.oml.model.common.NonLogicalElement <em>Non Logical Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Logical Element</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.NonLogicalElement
	 * @generated
	 */
	EClass getNonLogicalElement();

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
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#uuid()
	 * @generated
	 */
	EOperation getAnnotationProperty__Uuid();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#iri() <em>Iri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Iri</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#iri()
	 * @generated
	 */
	EOperation getAnnotationProperty__Iri();

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
	 * Returns the meta object for the containment reference '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getValue()
	 * @see #getAnnotationPropertyValue()
	 * @generated
	 */
	EReference getAnnotationPropertyValue_Value();

	/**
	 * Returns the meta object for the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#uuid() <em>Uuid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Uuid</em>' operation.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#uuid()
	 * @generated
	 */
	EOperation getAnnotationPropertyValue__Uuid();

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
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue <em>Positive Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Positive Integer Literal</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue"
	 * @generated
	 */
	EDataType getPositiveIntegerLiteral();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.PatternValue <em>Literal Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Literal Pattern</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.PatternValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.PatternValue"
	 * @generated
	 */
	EDataType getLiteralPattern();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.RealValue <em>Real Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.RealValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.RealValue"
	 * @generated
	 */
	EDataType getRealDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.RationalValue <em>Rational Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rational Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.RationalValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.RationalValue"
	 * @generated
	 */
	EDataType getRationalDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.FloatValue <em>Float Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.FloatValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.FloatValue"
	 * @generated
	 */
	EDataType getFloatDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue <em>Abstract Decimal Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Abstract Decimal Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue"
	 * @generated
	 */
	EDataType getAbstractDecimalDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue <em>Decimal Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Decimal Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue"
	 * @generated
	 */
	EDataType getDecimalDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue <em>Date Time Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Date Time Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue"
	 * @generated
	 */
	EDataType getDateTimeDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue <em>Language Tag Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Language Tag Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue"
	 * @generated
	 */
	EDataType getLanguageTagDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.StringValue <em>String Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.StringValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.StringValue"
	 * @generated
	 */
	EDataType getStringDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue <em>Raw String Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Raw String Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue"
	 * @generated
	 */
	EDataType getRawStringDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue <em>Quoted String Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Quoted String Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue"
	 * @generated
	 */
	EDataType getQuotedStringDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue <em>UUID Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UUID Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue"
	 * @generated
	 */
	EDataType getUUIDDataType();

	/**
	 * Returns the meta object for data type '{@link gov.nasa.jpl.imce.oml.model.datatypes.URIValue <em>URI Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI Data Type</em>'.
	 * @see gov.nasa.jpl.imce.oml.model.datatypes.URIValue
	 * @model instanceClass="gov.nasa.jpl.imce.oml.model.datatypes.URIValue"
	 * @generated
	 */
	EDataType getURIDataType();

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
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralValueImpl <em>Literal Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralValueImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralValue()
		 * @generated
		 */
		EClass LITERAL_VALUE = eINSTANCE.getLiteralValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_VALUE___VALUE = eINSTANCE.getLiteralValue__Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralBooleanImpl <em>Literal Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralBooleanImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralBoolean()
		 * @generated
		 */
		EClass LITERAL_BOOLEAN = eINSTANCE.getLiteralBoolean();

		/**
		 * The meta object literal for the '<em><b>Bool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_BOOLEAN__BOOL = eINSTANCE.getLiteralBoolean_Bool();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_BOOLEAN___VALUE = eINSTANCE.getLiteralBoolean__Value();

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
		 * The meta object literal for the '<em><b>Date Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_DATE_TIME__DATE_TIME = eINSTANCE.getLiteralDateTime_DateTime();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_DATE_TIME___VALUE = eINSTANCE.getLiteralDateTime__Value();

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
		 * The meta object literal for the '<em><b>String Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_STRING___STRING_VALUE = eINSTANCE.getLiteralString__StringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_STRING___VALUE = eINSTANCE.getLiteralString__Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralQuotedStringImpl <em>Literal Quoted String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralQuotedStringImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralQuotedString()
		 * @generated
		 */
		EClass LITERAL_QUOTED_STRING = eINSTANCE.getLiteralQuotedString();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_QUOTED_STRING__STRING = eINSTANCE.getLiteralQuotedString_String();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_QUOTED_STRING___STRING_VALUE = eINSTANCE.getLiteralQuotedString__StringValue();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralRawStringImpl <em>Literal Raw String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralRawStringImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralRawString()
		 * @generated
		 */
		EClass LITERAL_RAW_STRING = eINSTANCE.getLiteralRawString();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_RAW_STRING__STRING = eINSTANCE.getLiteralRawString_String();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_RAW_STRING___STRING_VALUE = eINSTANCE.getLiteralRawString__StringValue();

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
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_UUID__UUID = eINSTANCE.getLiteralUUID_Uuid();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_UUID___VALUE = eINSTANCE.getLiteralUUID__Value();

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
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_URI__URI = eINSTANCE.getLiteralURI_Uri();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_URI___VALUE = eINSTANCE.getLiteralURI__Value();

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
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralRealImpl <em>Literal Real</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralRealImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralReal()
		 * @generated
		 */
		EClass LITERAL_REAL = eINSTANCE.getLiteralReal();

		/**
		 * The meta object literal for the '<em><b>Real</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_REAL__REAL = eINSTANCE.getLiteralReal_Real();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_REAL___VALUE = eINSTANCE.getLiteralReal__Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralRationalImpl <em>Literal Rational</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralRationalImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralRational()
		 * @generated
		 */
		EClass LITERAL_RATIONAL = eINSTANCE.getLiteralRational();

		/**
		 * The meta object literal for the '<em><b>Rational</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_RATIONAL__RATIONAL = eINSTANCE.getLiteralRational_Rational();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_RATIONAL___VALUE = eINSTANCE.getLiteralRational__Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralFloatImpl <em>Literal Float</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralFloatImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralFloat()
		 * @generated
		 */
		EClass LITERAL_FLOAT = eINSTANCE.getLiteralFloat();

		/**
		 * The meta object literal for the '<em><b>Float</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_FLOAT__FLOAT = eINSTANCE.getLiteralFloat_Float();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_FLOAT___VALUE = eINSTANCE.getLiteralFloat__Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LiteralDecimalImpl <em>Literal Decimal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LiteralDecimalImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralDecimal()
		 * @generated
		 */
		EClass LITERAL_DECIMAL = eINSTANCE.getLiteralDecimal();

		/**
		 * The meta object literal for the '<em><b>Decimal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_DECIMAL__DECIMAL = eINSTANCE.getLiteralDecimal_Decimal();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LITERAL_DECIMAL___VALUE = eINSTANCE.getLiteralDecimal__Value();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.CrossReferencabilityKindImpl <em>Cross Referencability Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CrossReferencabilityKindImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getCrossReferencabilityKind()
		 * @generated
		 */
		EClass CROSS_REFERENCABILITY_KIND = eINSTANCE.getCrossReferencabilityKind();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSS_REFERENCABILITY_KIND__UUID = eINSTANCE.getCrossReferencabilityKind_Uuid();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CROSS_REFERENCABILITY_KIND___UUID = eINSTANCE.getCrossReferencabilityKind__Uuid();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.CrossReferencableKindImpl <em>Cross Referencable Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CrossReferencableKindImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getCrossReferencableKind()
		 * @generated
		 */
		EClass CROSS_REFERENCABLE_KIND = eINSTANCE.getCrossReferencableKind();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.NonCrossReferencableKindImpl <em>Non Cross Referencable Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.NonCrossReferencableKindImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getNonCrossReferencableKind()
		 * @generated
		 */
		EClass NON_CROSS_REFERENCABLE_KIND = eINSTANCE.getNonCrossReferencableKind();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.IdentityKindImpl <em>Identity Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.IdentityKindImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getIdentityKind()
		 * @generated
		 */
		EClass IDENTITY_KIND = eINSTANCE.getIdentityKind();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.IntrinsicIdentityKindImpl <em>Intrinsic Identity Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.IntrinsicIdentityKindImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getIntrinsicIdentityKind()
		 * @generated
		 */
		EClass INTRINSIC_IDENTITY_KIND = eINSTANCE.getIntrinsicIdentityKind();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTRINSIC_IDENTITY_KIND___IRI = eINSTANCE.getIntrinsicIdentityKind__Iri();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ExtrinsicIdentityKindImpl <em>Extrinsic Identity Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ExtrinsicIdentityKindImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getExtrinsicIdentityKind()
		 * @generated
		 */
		EClass EXTRINSIC_IDENTITY_KIND = eINSTANCE.getExtrinsicIdentityKind();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ElementCrossReferenceTupleImpl <em>Element Cross Reference Tuple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ElementCrossReferenceTupleImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getElementCrossReferenceTuple()
		 * @generated
		 */
		EClass ELEMENT_CROSS_REFERENCE_TUPLE = eINSTANCE.getElementCrossReferenceTuple();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.ValueCrossReferenceTupleImpl <em>Value Cross Reference Tuple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.ValueCrossReferenceTupleImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getValueCrossReferenceTuple()
		 * @generated
		 */
		EClass VALUE_CROSS_REFERENCE_TUPLE = eINSTANCE.getValueCrossReferenceTuple();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.LogicalElementImpl <em>Logical Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.LogicalElementImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLogicalElement()
		 * @generated
		 */
		EClass LOGICAL_ELEMENT = eINSTANCE.getLogicalElement();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_ELEMENT__ANNOTATIONS = eINSTANCE.getLogicalElement_Annotations();

		/**
		 * The meta object literal for the '<em><b>Module Context</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOGICAL_ELEMENT___MODULE_CONTEXT = eINSTANCE.getLogicalElement__ModuleContext();

		/**
		 * The meta object literal for the '{@link gov.nasa.jpl.imce.oml.model.common.impl.NonLogicalElementImpl <em>Non Logical Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.NonLogicalElementImpl
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getNonLogicalElement()
		 * @generated
		 */
		EClass NON_LOGICAL_ELEMENT = eINSTANCE.getNonLogicalElement();

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
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANNOTATION_PROPERTY___UUID = eINSTANCE.getAnnotationProperty__Uuid();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANNOTATION_PROPERTY___IRI = eINSTANCE.getAnnotationProperty__Iri();

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
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_PROPERTY_VALUE__VALUE = eINSTANCE.getAnnotationPropertyValue_Value();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANNOTATION_PROPERTY_VALUE___UUID = eINSTANCE.getAnnotationPropertyValue__Uuid();

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

		/**
		 * The meta object literal for the '<em>Positive Integer Literal</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getPositiveIntegerLiteral()
		 * @generated
		 */
		EDataType POSITIVE_INTEGER_LITERAL = eINSTANCE.getPositiveIntegerLiteral();

		/**
		 * The meta object literal for the '<em>Literal Pattern</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.PatternValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLiteralPattern()
		 * @generated
		 */
		EDataType LITERAL_PATTERN = eINSTANCE.getLiteralPattern();

		/**
		 * The meta object literal for the '<em>Real Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.RealValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getRealDataType()
		 * @generated
		 */
		EDataType REAL_DATA_TYPE = eINSTANCE.getRealDataType();

		/**
		 * The meta object literal for the '<em>Rational Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.RationalValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getRationalDataType()
		 * @generated
		 */
		EDataType RATIONAL_DATA_TYPE = eINSTANCE.getRationalDataType();

		/**
		 * The meta object literal for the '<em>Float Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.FloatValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getFloatDataType()
		 * @generated
		 */
		EDataType FLOAT_DATA_TYPE = eINSTANCE.getFloatDataType();

		/**
		 * The meta object literal for the '<em>Abstract Decimal Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getAbstractDecimalDataType()
		 * @generated
		 */
		EDataType ABSTRACT_DECIMAL_DATA_TYPE = eINSTANCE.getAbstractDecimalDataType();

		/**
		 * The meta object literal for the '<em>Decimal Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getDecimalDataType()
		 * @generated
		 */
		EDataType DECIMAL_DATA_TYPE = eINSTANCE.getDecimalDataType();

		/**
		 * The meta object literal for the '<em>Date Time Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getDateTimeDataType()
		 * @generated
		 */
		EDataType DATE_TIME_DATA_TYPE = eINSTANCE.getDateTimeDataType();

		/**
		 * The meta object literal for the '<em>Language Tag Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getLanguageTagDataType()
		 * @generated
		 */
		EDataType LANGUAGE_TAG_DATA_TYPE = eINSTANCE.getLanguageTagDataType();

		/**
		 * The meta object literal for the '<em>String Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.StringValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getStringDataType()
		 * @generated
		 */
		EDataType STRING_DATA_TYPE = eINSTANCE.getStringDataType();

		/**
		 * The meta object literal for the '<em>Raw String Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getRawStringDataType()
		 * @generated
		 */
		EDataType RAW_STRING_DATA_TYPE = eINSTANCE.getRawStringDataType();

		/**
		 * The meta object literal for the '<em>Quoted String Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getQuotedStringDataType()
		 * @generated
		 */
		EDataType QUOTED_STRING_DATA_TYPE = eINSTANCE.getQuotedStringDataType();

		/**
		 * The meta object literal for the '<em>UUID Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getUUIDDataType()
		 * @generated
		 */
		EDataType UUID_DATA_TYPE = eINSTANCE.getUUIDDataType();

		/**
		 * The meta object literal for the '<em>URI Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nasa.jpl.imce.oml.model.datatypes.URIValue
		 * @see gov.nasa.jpl.imce.oml.model.common.impl.CommonPackageImpl#getURIDataType()
		 * @generated
		 */
		EDataType URI_DATA_TYPE = eINSTANCE.getURIDataType();

	}

} //CommonPackage
