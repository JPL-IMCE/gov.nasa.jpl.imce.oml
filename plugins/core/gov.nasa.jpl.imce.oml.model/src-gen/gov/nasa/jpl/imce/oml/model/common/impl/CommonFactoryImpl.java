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
			case CommonPackage.LITERAL_PATTERN: return (EObject)createLiteralPattern();
			case CommonPackage.LITERAL_DATE_TIME: return (EObject)createLiteralDateTime();
			case CommonPackage.LITERAL_LANGUAGE_TAG: return (EObject)createLiteralLanguageTag();
			case CommonPackage.LITERAL_STRING: return (EObject)createLiteralString();
			case CommonPackage.LITERAL_UUID: return (EObject)createLiteralUUID();
			case CommonPackage.LITERAL_URI: return (EObject)createLiteralURI();
			case CommonPackage.LITERAL_NUMBER: return (EObject)createLiteralNumber();
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
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralPattern createLiteralPattern() {
		LiteralPatternImpl literalPattern = new LiteralPatternImpl();
		return literalPattern;
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
	public LiteralLanguageTag createLiteralLanguageTag() {
		LiteralLanguageTagImpl literalLanguageTag = new LiteralLanguageTagImpl();
		return literalLanguageTag;
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
	public LiteralNumber createLiteralNumber() {
		LiteralNumberImpl literalNumber = new LiteralNumberImpl();
		return literalNumber;
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
