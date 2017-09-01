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
package gov.nasa.jpl.imce.oml.model.common.impl;

import gov.nasa.jpl.imce.oml.model.common.*;

import gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue;
import gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue;
import gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue;
import gov.nasa.jpl.imce.oml.model.datatypes.FloatValue;
import gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;
import gov.nasa.jpl.imce.oml.model.datatypes.RationalValue;
import gov.nasa.jpl.imce.oml.model.datatypes.RealValue;
import gov.nasa.jpl.imce.oml.model.datatypes.StringValue;
import gov.nasa.jpl.imce.oml.model.datatypes.URIValue;
import gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonFactoryImpl extends EFactoryImpl implements CommonFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommonFactory init() {
		try {
			CommonFactory theCommonFactory = (CommonFactory)EPackage.Registry.INSTANCE.getEFactory(CommonPackage.eNS_URI);
			if (theCommonFactory != null) {
				return theCommonFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommonFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CommonPackage.LITERAL_DATE_TIME: return (EObject)createLiteralDateTime();
			case CommonPackage.LITERAL_STRING: return (EObject)createLiteralString();
			case CommonPackage.LITERAL_UUID: return (EObject)createLiteralUUID();
			case CommonPackage.LITERAL_URI: return (EObject)createLiteralURI();
			case CommonPackage.LITERAL_REAL: return (EObject)createLiteralReal();
			case CommonPackage.LITERAL_RATIONAL: return (EObject)createLiteralRational();
			case CommonPackage.LITERAL_FLOAT: return (EObject)createLiteralFloat();
			case CommonPackage.LITERAL_DECIMAL: return (EObject)createLiteralDecimal();
			case CommonPackage.ANNOTATION_PROPERTY_VALUE: return (EObject)createAnnotationPropertyValue();
			case CommonPackage.ANNOTATION_PROPERTY: return (EObject)createAnnotationProperty();
			case CommonPackage.EXTENT: return (EObject)createExtent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CommonPackage.IRI:
				return createIRIFromString(eDataType, initialValue);
			case CommonPackage.LOCAL_NAME:
				return createLocalNameFromString(eDataType, initialValue);
			case CommonPackage.UUID:
				return createUUIDFromString(eDataType, initialValue);
			case CommonPackage.ABBREV_IRI:
				return createAbbrevIRIFromString(eDataType, initialValue);
			case CommonPackage.NAMESPACE_PREFIX:
				return createNamespacePrefixFromString(eDataType, initialValue);
			case CommonPackage.POSITIVE_INTEGER_LITERAL:
				return createPositiveIntegerLiteralFromString(eDataType, initialValue);
			case CommonPackage.LITERAL_PATTERN:
				return createLiteralPatternFromString(eDataType, initialValue);
			case CommonPackage.REAL_DATA_TYPE:
				return createRealDataTypeFromString(eDataType, initialValue);
			case CommonPackage.RATIONAL_DATA_TYPE:
				return createRationalDataTypeFromString(eDataType, initialValue);
			case CommonPackage.FLOAT_DATA_TYPE:
				return createFloatDataTypeFromString(eDataType, initialValue);
			case CommonPackage.ABSTRACT_DECIMAL_DATA_TYPE:
				return createAbstractDecimalDataTypeFromString(eDataType, initialValue);
			case CommonPackage.DECIMAL_DATA_TYPE:
				return createDecimalDataTypeFromString(eDataType, initialValue);
			case CommonPackage.DATE_TIME_DATA_TYPE:
				return createDateTimeDataTypeFromString(eDataType, initialValue);
			case CommonPackage.LANGUAGE_TAG_DATA_TYPE:
				return createLanguageTagDataTypeFromString(eDataType, initialValue);
			case CommonPackage.STRING_DATA_TYPE:
				return createStringDataTypeFromString(eDataType, initialValue);
			case CommonPackage.UUID_DATA_TYPE:
				return createUUIDDataTypeFromString(eDataType, initialValue);
			case CommonPackage.URI_DATA_TYPE:
				return createURIDataTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CommonPackage.IRI:
				return convertIRIToString(eDataType, instanceValue);
			case CommonPackage.LOCAL_NAME:
				return convertLocalNameToString(eDataType, instanceValue);
			case CommonPackage.UUID:
				return convertUUIDToString(eDataType, instanceValue);
			case CommonPackage.ABBREV_IRI:
				return convertAbbrevIRIToString(eDataType, instanceValue);
			case CommonPackage.NAMESPACE_PREFIX:
				return convertNamespacePrefixToString(eDataType, instanceValue);
			case CommonPackage.POSITIVE_INTEGER_LITERAL:
				return convertPositiveIntegerLiteralToString(eDataType, instanceValue);
			case CommonPackage.LITERAL_PATTERN:
				return convertLiteralPatternToString(eDataType, instanceValue);
			case CommonPackage.REAL_DATA_TYPE:
				return convertRealDataTypeToString(eDataType, instanceValue);
			case CommonPackage.RATIONAL_DATA_TYPE:
				return convertRationalDataTypeToString(eDataType, instanceValue);
			case CommonPackage.FLOAT_DATA_TYPE:
				return convertFloatDataTypeToString(eDataType, instanceValue);
			case CommonPackage.ABSTRACT_DECIMAL_DATA_TYPE:
				return convertAbstractDecimalDataTypeToString(eDataType, instanceValue);
			case CommonPackage.DECIMAL_DATA_TYPE:
				return convertDecimalDataTypeToString(eDataType, instanceValue);
			case CommonPackage.DATE_TIME_DATA_TYPE:
				return convertDateTimeDataTypeToString(eDataType, instanceValue);
			case CommonPackage.LANGUAGE_TAG_DATA_TYPE:
				return convertLanguageTagDataTypeToString(eDataType, instanceValue);
			case CommonPackage.STRING_DATA_TYPE:
				return convertStringDataTypeToString(eDataType, instanceValue);
			case CommonPackage.UUID_DATA_TYPE:
				return convertUUIDDataTypeToString(eDataType, instanceValue);
			case CommonPackage.URI_DATA_TYPE:
				return convertURIDataTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralDateTime createLiteralDateTime() {
		LiteralDateTimeImpl literalDateTime = new LiteralDateTimeImpl();
		return literalDateTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralString createLiteralString() {
		LiteralStringImpl literalString = new LiteralStringImpl();
		return literalString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralUUID createLiteralUUID() {
		LiteralUUIDImpl literalUUID = new LiteralUUIDImpl();
		return literalUUID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralURI createLiteralURI() {
		LiteralURIImpl literalURI = new LiteralURIImpl();
		return literalURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralReal createLiteralReal() {
		LiteralRealImpl literalReal = new LiteralRealImpl();
		return literalReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralRational createLiteralRational() {
		LiteralRationalImpl literalRational = new LiteralRationalImpl();
		return literalRational;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralFloat createLiteralFloat() {
		LiteralFloatImpl literalFloat = new LiteralFloatImpl();
		return literalFloat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralDecimal createLiteralDecimal() {
		LiteralDecimalImpl literalDecimal = new LiteralDecimalImpl();
		return literalDecimal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationPropertyValue createAnnotationPropertyValue() {
		AnnotationPropertyValueImpl annotationPropertyValue = new AnnotationPropertyValueImpl();
		return annotationPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationProperty createAnnotationProperty() {
		AnnotationPropertyImpl annotationProperty = new AnnotationPropertyImpl();
		return annotationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extent createExtent() {
		ExtentImpl extent = new ExtentImpl();
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIRIFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIRIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createLocalNameFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLocalNameToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createUUIDFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUUIDToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAbbrevIRIFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAbbrevIRIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNamespacePrefixFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNamespacePrefixToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositiveIntegerValue createPositiveIntegerLiteralFromString(EDataType eDataType, String initialValue) {
		return (PositiveIntegerValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPositiveIntegerLiteralToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternValue createLiteralPatternFromString(EDataType eDataType, String initialValue) {
		return (PatternValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLiteralPatternToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealValue createRealDataTypeFromString(EDataType eDataType, String initialValue) {
		return (RealValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRealDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RationalValue createRationalDataTypeFromString(EDataType eDataType, String initialValue) {
		return (RationalValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRationalDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatValue createFloatDataTypeFromString(EDataType eDataType, String initialValue) {
		return (FloatValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFloatDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDecimalValue createAbstractDecimalDataTypeFromString(EDataType eDataType, String initialValue) {
		return (AbstractDecimalValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAbstractDecimalDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecimalValue createDecimalDataTypeFromString(EDataType eDataType, String initialValue) {
		return (DecimalValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDecimalDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTimeValue createDateTimeDataTypeFromString(EDataType eDataType, String initialValue) {
		return (DateTimeValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDateTimeDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageTagValue createLanguageTagDataTypeFromString(EDataType eDataType, String initialValue) {
		return (LanguageTagValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLanguageTagDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValue createStringDataTypeFromString(EDataType eDataType, String initialValue) {
		return (StringValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UUIDValue createUUIDDataTypeFromString(EDataType eDataType, String initialValue) {
		return (UUIDValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUUIDDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URIValue createURIDataTypeFromString(EDataType eDataType, String initialValue) {
		return (URIValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURIDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonPackage getCommonPackage() {
		return (CommonPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommonPackage getPackage() {
		return CommonPackage.eINSTANCE;
	}

} //CommonFactoryImpl
