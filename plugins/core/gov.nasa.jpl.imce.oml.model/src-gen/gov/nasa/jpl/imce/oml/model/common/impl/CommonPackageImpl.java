/**
 * 
 * Copyright 2016 California Institute of Technology ("Caltech").
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

import gov.nasa.jpl.imce.oml.model.common.Annotation;
import gov.nasa.jpl.imce.oml.model.common.AnnotationEntry;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationSubjectPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;
import gov.nasa.jpl.imce.oml.model.common.Resource;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationPropertyTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationSubjectTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationSubjectPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType localNameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lexicalValueEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lexicalNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lexicalTimeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType patternEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uuidEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType langRangeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType abbrevIRIEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType namespacePrefixEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommonPackageImpl() {
		super(eNS_URI, CommonFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CommonPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommonPackage init() {
		if (isInited) return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Obtain or create and register package
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommonPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCommonPackage.createPackageContents();

		// Initialize created meta-data
		theCommonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommonPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommonPackage.eNS_URI, theCommonPackage);
		return theCommonPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Uuid() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getElement__Uuid() {
		return elementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResource__Iri() {
		return resourceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResource__Name() {
		return resourceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResource__AbbrevIRI() {
		return resourceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleElement() {
		return moduleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleEdge() {
		return moduleEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModuleEdge__SourceModule() {
		return moduleEdgeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModuleEdge__TargetModule() {
		return moduleEdgeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationProperty() {
		return annotationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationProperty_Extent() {
		return (EReference)annotationPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationProperty_Uuid() {
		return (EAttribute)annotationPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationProperty_Iri() {
		return (EAttribute)annotationPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationProperty_AbbrevIRI() {
		return (EAttribute)annotationPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationPropertyTable() {
		return annotationPropertyTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationPropertyTable_Key() {
		return (EReference)annotationPropertyTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationPropertyTable_Value() {
		return (EReference)annotationPropertyTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationEntry() {
		return annotationEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationEntry_Module() {
		return (EReference)annotationEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationEntry_Subject() {
		return (EReference)annotationEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationEntry_Value() {
		return (EAttribute)annotationEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationSubjectTable() {
		return annotationSubjectTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationSubjectTable_Key() {
		return (EReference)annotationSubjectTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationSubjectTable_Value() {
		return (EReference)annotationSubjectTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationSubjectPropertyValue() {
		return annotationSubjectPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationSubjectPropertyValue_Property() {
		return (EReference)annotationSubjectPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationSubjectPropertyValue_Value() {
		return (EAttribute)annotationSubjectPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Module() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Property() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Subject() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Value() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtent() {
		return extentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtent_Modules() {
		return (EReference)extentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtent_AnnotationProperties() {
		return (EReference)extentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Extent() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModule_Iri() {
		return (EAttribute)moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Annotations() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModule__ModuleEdges() {
		return moduleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModule__Iri() {
		return moduleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModule__NsPrefix() {
		return moduleEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModule__Name() {
		return moduleEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModule__AbbrevIRI() {
		return moduleEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModule__Uuid() {
		return moduleEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIRI() {
		return iriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLocalName() {
		return localNameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLexicalValue() {
		return lexicalValueEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLexicalNumber() {
		return lexicalNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLexicalTime() {
		return lexicalTimeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPattern() {
		return patternEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUUID() {
		return uuidEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLangRange() {
		return langRangeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAbbrevIRI() {
		return abbrevIRIEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNamespacePrefix() {
		return namespacePrefixEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonFactory getCommonFactory() {
		return (CommonFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__UUID);
		createEOperation(elementEClass, ELEMENT___UUID);

		resourceEClass = createEClass(RESOURCE);
		createEOperation(resourceEClass, RESOURCE___IRI);
		createEOperation(resourceEClass, RESOURCE___NAME);
		createEOperation(resourceEClass, RESOURCE___ABBREV_IRI);

		moduleElementEClass = createEClass(MODULE_ELEMENT);

		moduleEdgeEClass = createEClass(MODULE_EDGE);
		createEOperation(moduleEdgeEClass, MODULE_EDGE___SOURCE_MODULE);
		createEOperation(moduleEdgeEClass, MODULE_EDGE___TARGET_MODULE);

		annotationPropertyEClass = createEClass(ANNOTATION_PROPERTY);
		createEReference(annotationPropertyEClass, ANNOTATION_PROPERTY__EXTENT);
		createEAttribute(annotationPropertyEClass, ANNOTATION_PROPERTY__UUID);
		createEAttribute(annotationPropertyEClass, ANNOTATION_PROPERTY__IRI);
		createEAttribute(annotationPropertyEClass, ANNOTATION_PROPERTY__ABBREV_IRI);

		annotationPropertyTableEClass = createEClass(ANNOTATION_PROPERTY_TABLE);
		createEReference(annotationPropertyTableEClass, ANNOTATION_PROPERTY_TABLE__KEY);
		createEReference(annotationPropertyTableEClass, ANNOTATION_PROPERTY_TABLE__VALUE);

		annotationEntryEClass = createEClass(ANNOTATION_ENTRY);
		createEReference(annotationEntryEClass, ANNOTATION_ENTRY__MODULE);
		createEReference(annotationEntryEClass, ANNOTATION_ENTRY__SUBJECT);
		createEAttribute(annotationEntryEClass, ANNOTATION_ENTRY__VALUE);

		annotationSubjectTableEClass = createEClass(ANNOTATION_SUBJECT_TABLE);
		createEReference(annotationSubjectTableEClass, ANNOTATION_SUBJECT_TABLE__KEY);
		createEReference(annotationSubjectTableEClass, ANNOTATION_SUBJECT_TABLE__VALUE);

		annotationSubjectPropertyValueEClass = createEClass(ANNOTATION_SUBJECT_PROPERTY_VALUE);
		createEReference(annotationSubjectPropertyValueEClass, ANNOTATION_SUBJECT_PROPERTY_VALUE__PROPERTY);
		createEAttribute(annotationSubjectPropertyValueEClass, ANNOTATION_SUBJECT_PROPERTY_VALUE__VALUE);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__MODULE);
		createEReference(annotationEClass, ANNOTATION__PROPERTY);
		createEReference(annotationEClass, ANNOTATION__SUBJECT);
		createEAttribute(annotationEClass, ANNOTATION__VALUE);

		extentEClass = createEClass(EXTENT);
		createEReference(extentEClass, EXTENT__MODULES);
		createEReference(extentEClass, EXTENT__ANNOTATION_PROPERTIES);

		moduleEClass = createEClass(MODULE);
		createEReference(moduleEClass, MODULE__EXTENT);
		createEAttribute(moduleEClass, MODULE__IRI);
		createEReference(moduleEClass, MODULE__ANNOTATIONS);
		createEOperation(moduleEClass, MODULE___MODULE_EDGES);
		createEOperation(moduleEClass, MODULE___IRI);
		createEOperation(moduleEClass, MODULE___NS_PREFIX);
		createEOperation(moduleEClass, MODULE___NAME);
		createEOperation(moduleEClass, MODULE___ABBREV_IRI);
		createEOperation(moduleEClass, MODULE___UUID);

		// Create data types
		iriEDataType = createEDataType(IRI);
		localNameEDataType = createEDataType(LOCAL_NAME);
		lexicalValueEDataType = createEDataType(LEXICAL_VALUE);
		lexicalNumberEDataType = createEDataType(LEXICAL_NUMBER);
		lexicalTimeEDataType = createEDataType(LEXICAL_TIME);
		patternEDataType = createEDataType(PATTERN);
		uuidEDataType = createEDataType(UUID);
		langRangeEDataType = createEDataType(LANG_RANGE);
		abbrevIRIEDataType = createEDataType(ABBREV_IRI);
		namespacePrefixEDataType = createEDataType(NAMESPACE_PREFIX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		moduleElementEClass.getESuperTypes().add(this.getElement());
		moduleEdgeEClass.getESuperTypes().add(this.getElement());
		moduleEClass.getESuperTypes().add(this.getElement());
		moduleEClass.getESuperTypes().add(this.getResource());

		// Initialize classes, features, and operations; add parameters
		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Uuid(), this.getUUID(), "uuid", null, 1, 1, Element.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getElement__Uuid(), this.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getResource__Iri(), this.getIRI(), "iri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getResource__Name(), this.getLocalName(), "name", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getResource__AbbrevIRI(), theEcorePackage.getEString(), "abbrevIRI", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(moduleElementEClass, ModuleElement.class, "ModuleElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moduleEdgeEClass, ModuleEdge.class, "ModuleEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getModuleEdge__SourceModule(), this.getModule(), "sourceModule", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getModuleEdge__TargetModule(), this.getModule(), "targetModule", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(annotationPropertyEClass, AnnotationProperty.class, "AnnotationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationProperty_Extent(), this.getExtent(), this.getExtent_AnnotationProperties(), "extent", null, 1, 1, AnnotationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationProperty_Uuid(), this.getUUID(), "uuid", null, 1, 1, AnnotationProperty.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationProperty_Iri(), this.getIRI(), "iri", null, 1, 1, AnnotationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationProperty_AbbrevIRI(), this.getAbbrevIRI(), "abbrevIRI", null, 1, 1, AnnotationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationPropertyTableEClass, Map.Entry.class, "AnnotationPropertyTable", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationPropertyTable_Key(), this.getAnnotationProperty(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationPropertyTable_Value(), this.getAnnotationEntry(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEntryEClass, AnnotationEntry.class, "AnnotationEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationEntry_Module(), this.getModule(), null, "module", null, 1, 1, AnnotationEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationEntry_Subject(), this.getElement(), null, "subject", null, 1, 1, AnnotationEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationEntry_Value(), theEcorePackage.getEString(), "value", null, 1, 1, AnnotationEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationSubjectTableEClass, Map.Entry.class, "AnnotationSubjectTable", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationSubjectTable_Key(), this.getElement(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationSubjectTable_Value(), this.getAnnotationSubjectPropertyValue(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationSubjectPropertyValueEClass, AnnotationSubjectPropertyValue.class, "AnnotationSubjectPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationSubjectPropertyValue_Property(), this.getAnnotationProperty(), null, "property", null, 1, 1, AnnotationSubjectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationSubjectPropertyValue_Value(), theEcorePackage.getEString(), "value", null, 1, 1, AnnotationSubjectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_Module(), this.getModule(), this.getModule_Annotations(), "module", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_Property(), this.getAnnotationProperty(), null, "property", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_Subject(), this.getElement(), null, "subject", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_Value(), theEcorePackage.getEString(), "value", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extentEClass, Extent.class, "Extent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtent_Modules(), this.getModule(), this.getModule_Extent(), "modules", null, 0, -1, Extent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtent_AnnotationProperties(), this.getAnnotationProperty(), this.getAnnotationProperty_Extent(), "annotationProperties", null, 0, -1, Extent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleEClass, Module.class, "Module", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModule_Extent(), this.getExtent(), this.getExtent_Modules(), "extent", null, 1, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_Iri(), this.getIRI(), "iri", null, 1, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Annotations(), this.getAnnotation(), this.getAnnotation_Module(), "annotations", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModule__ModuleEdges(), this.getModuleEdge(), "moduleEdges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getModule__Iri(), this.getIRI(), "iri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getModule__NsPrefix(), this.getNamespacePrefix(), "nsPrefix", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getModule__Name(), this.getLocalName(), "name", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getModule__AbbrevIRI(), theEcorePackage.getEString(), "abbrevIRI", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getModule__Uuid(), this.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(iriEDataType, String.class, "IRI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(localNameEDataType, String.class, "LocalName", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lexicalValueEDataType, String.class, "LexicalValue", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lexicalNumberEDataType, String.class, "LexicalNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lexicalTimeEDataType, String.class, "LexicalTime", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(patternEDataType, String.class, "Pattern", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uuidEDataType, String.class, "UUID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(langRangeEDataType, String.class, "LangRange", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(abbrevIRIEDataType, String.class, "AbbrevIRI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(namespacePrefixEDataType, String.class, "NamespacePrefix", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotFunctionalAPI
		createNotFunctionalAPIAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotSchema
		createNotSchemaAnnotations();
		// http://imce.jpl.nasa.gov/oml/ImplicitExtent
		createImplicitExtentAnnotations();
		// http://imce.jpl.nasa.gov/oml/IsOrderingKey
		createIsOrderingKeyAnnotations();
		// http://imce.jpl.nasa.gov/oml/Glossary
		createGlossaryAnnotations();
		// http://imce.jpl.nasa.gov/oml/ExtentManaged
		createExtentManagedAnnotations();
		// http://imce.jpl.nasa.gov/oml/NamespaceUUID
		createNamespaceUUIDAnnotations();
		// http://imce.jpl.nasa.gov/oml/Scala
		createScalaAnnotations();
		// http://imce.jpl.nasa.gov/oml/Collection
		createCollectionAnnotations();
		// http://imce.jpl.nasa.gov/oml/ValueTable
		createValueTableAnnotations();
		// http://imce.jpl.nasa.gov/oml/ExtentContainer
		createExtentContainerAnnotations();
		// http://imce.jpl.nasa.gov/oml/ResolverAPI
		createResolverAPIAnnotations();
		// http://imce.jpl.nasa.gov/oml/Override
		createOverrideAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2011/Xcore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "Collection", "http://imce.jpl.nasa.gov/oml/Collection",
			 "ResolverAPI", "http://imce.jpl.nasa.gov/oml/ResolverAPI",
			 "Override", "http://imce.jpl.nasa.gov/oml/Override",
			 "OverrideVal", "http://imce.jpl.nasa.gov/oml/OverrideVal",
			 "NotFunctionalAPI", "http://imce.jpl.nasa.gov/oml/NotFunctionalAPI",
			 "FunctionalInterface", "http://imce.jpl.nasa.gov/oml/FunctionalInterface",
			 "NotSchema", "http://imce.jpl.nasa.gov/oml/NotSchema",
			 "ValueTable", "http://imce.jpl.nasa.gov/oml/ValueTable",
			 "Scala", "http://imce.jpl.nasa.gov/oml/Scala",
			 "IsOrderingKey", "http://imce.jpl.nasa.gov/oml/IsOrderingKey",
			 "CopyConstructor", "http://imce.jpl.nasa.gov/oml/CopyConstructor",
			 "Glossary", "http://imce.jpl.nasa.gov/oml/Glossary",
			 "ExtentContainer", "http://imce.jpl.nasa.gov/oml/ExtentContainer",
			 "ExtentManaged", "http://imce.jpl.nasa.gov/oml/ExtentManaged",
			 "ImplicitExtent", "http://imce.jpl.nasa.gov/oml/ImplicitExtent",
			 "NamespaceUUID", "http://imce.jpl.nasa.gov/oml/NamespaceUUID",
			 "DerivedUUID", "http://imce.jpl.nasa.gov/oml/DerivedUUID"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/NotFunctionalAPI</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNotFunctionalAPIAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/NotFunctionalAPI";	
		addAnnotation
		  (getElement__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationProperty_Extent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationPropertyTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectPropertyValueEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getExtent_Modules(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getExtent_AnnotationProperties(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule_Extent(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/NotSchema</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNotSchemaAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/NotSchema";	
		addAnnotation
		  (getElement__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getResource__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getResource__Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getResource__AbbrevIRI(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModuleEdge__SourceModule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModuleEdge__TargetModule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationProperty_Extent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationPropertyTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectPropertyValueEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getExtent_Modules(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getExtent_AnnotationProperties(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__ModuleEdges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__NsPrefix(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__AbbrevIRI(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule_Extent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule_Annotations(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/ImplicitExtent</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImplicitExtentAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/ImplicitExtent";	
		addAnnotation
		  (getElement_Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getResource__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getResource__AbbrevIRI(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModuleEdge__SourceModule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModuleEdge__TargetModule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__ModuleEdges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getModule__AbbrevIRI(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/IsOrderingKey</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createIsOrderingKeyAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/IsOrderingKey";	
		addAnnotation
		  (getElement_Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationProperty_Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationPropertyTable_Key(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationEntry_Module(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationEntry_Subject(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationEntry_Value(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotation_Property(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotation_Subject(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotation_Value(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Glossary</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGlossaryAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Glossary";	
		addAnnotation
		  (resourceEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (moduleElementEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (moduleEdgeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationPropertyTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationEntryEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectPropertyValueEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (extentEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (moduleEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/ExtentManaged</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtentManagedAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/ExtentManaged";	
		addAnnotation
		  (annotationPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (moduleEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/NamespaceUUID</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNamespaceUUIDAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/NamespaceUUID";	
		addAnnotation
		  (annotationPropertyEClass, 
		   source, 
		   new String[] {
			 "namespace", "iri",
			 "factors", ""
		   });	
		addAnnotation
		  (moduleEClass, 
		   source, 
		   new String[] {
			 "namespace", "iri",
			 "factors", ""
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Scala</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createScalaAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Scala";	
		addAnnotation
		  (getAnnotationProperty_Uuid(), 
		   source, 
		   new String[] {
			 "code", "com.fasterxml.uuid.Generators.nameBasedGenerator(com.fasterxml.uuid.impl.NameBasedGenerator.NAMESPACE_URL).generate(iri)"
		   });	
		addAnnotation
		  (getModule__Iri(), 
		   source, 
		   new String[] {
			 "code", "scala.Some(iri)"
		   });	
		addAnnotation
		  (getModule__NsPrefix(), 
		   source, 
		   new String[] {
			 "code", "iri.substring(1+iri.lastIndexOf(\'/\'))"
		   });	
		addAnnotation
		  (getModule__AbbrevIRI(), 
		   source, 
		   new String[] {
			 "code", "scala.Some(nsPrefix)"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Collection</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCollectionAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Collection";	
		addAnnotation
		  (getAnnotationPropertyTable_Value(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getModule_Annotations(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/ValueTable</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createValueTableAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/ValueTable";	
		addAnnotation
		  (annotationEntryEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/ExtentContainer</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtentContainerAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/ExtentContainer";	
		addAnnotation
		  (extentEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/ResolverAPI</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createResolverAPIAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/ResolverAPI";	
		addAnnotation
		  (extentEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Override</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOverrideAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Override";	
		addAnnotation
		  (getModule__Iri(), 
		   source, 
		   new String[] {
		   });
	}

} //CommonPackageImpl
