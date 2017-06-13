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
package gov.nasa.jpl.imce.oml.runtime.impl;

import gov.nasa.jpl.imce.oml.runtime.OMLAspect;
import gov.nasa.jpl.imce.oml.runtime.OMLConcept;
import gov.nasa.jpl.imce.oml.runtime.OMLDescription;
import gov.nasa.jpl.imce.oml.runtime.OMLEntity;
import gov.nasa.jpl.imce.oml.runtime.OMLObject;
import gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimeFactory;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage;
import gov.nasa.jpl.imce.oml.runtime.OMLStructure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OMLRuntimePackageImpl extends EPackageImpl implements OMLRuntimePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlAspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlConceptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlReifiedRelationshipEClass = null;

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
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OMLRuntimePackageImpl() {
		super(eNS_URI, OMLRuntimeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OMLRuntimePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OMLRuntimePackage init() {
		if (isInited) return (OMLRuntimePackage)EPackage.Registry.INSTANCE.getEPackage(OMLRuntimePackage.eNS_URI);

		// Obtain or create and register package
		OMLRuntimePackageImpl theOMLRuntimePackage = (OMLRuntimePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OMLRuntimePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OMLRuntimePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOMLRuntimePackage.createPackageContents();

		// Initialize created meta-data
		theOMLRuntimePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOMLRuntimePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OMLRuntimePackage.eNS_URI, theOMLRuntimePackage);
		return theOMLRuntimePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLObject() {
		return omlObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOMLObject__OmlInverseReferencers__Class() {
		return omlObjectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLDescription() {
		return omlDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOMLDescription_OmlIRI() {
		return (EAttribute)omlDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLDescription_OmlContents() {
		return (EReference)omlDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLStructure() {
		return omlStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLEntity() {
		return omlEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOMLEntity_OmlName() {
		return (EAttribute)omlEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLEntity_OmlDescription() {
		return (EReference)omlEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLAspect() {
		return omlAspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLConcept() {
		return omlConceptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLReifiedRelationship() {
		return omlReifiedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLReifiedRelationship_OmlSource() {
		return (EReference)omlReifiedRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLReifiedRelationship_OmlTarget() {
		return (EReference)omlReifiedRelationshipEClass.getEStructuralFeatures().get(1);
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
	public OMLRuntimeFactory getOMLRuntimeFactory() {
		return (OMLRuntimeFactory)getEFactoryInstance();
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
		omlObjectEClass = createEClass(OML_OBJECT);
		createEOperation(omlObjectEClass, OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS);

		omlDescriptionEClass = createEClass(OML_DESCRIPTION);
		createEAttribute(omlDescriptionEClass, OML_DESCRIPTION__OML_IRI);
		createEReference(omlDescriptionEClass, OML_DESCRIPTION__OML_CONTENTS);

		omlStructureEClass = createEClass(OML_STRUCTURE);

		omlEntityEClass = createEClass(OML_ENTITY);
		createEAttribute(omlEntityEClass, OML_ENTITY__OML_NAME);
		createEReference(omlEntityEClass, OML_ENTITY__OML_DESCRIPTION);

		omlAspectEClass = createEClass(OML_ASPECT);

		omlConceptEClass = createEClass(OML_CONCEPT);

		omlReifiedRelationshipEClass = createEClass(OML_REIFIED_RELATIONSHIP);
		createEReference(omlReifiedRelationshipEClass, OML_REIFIED_RELATIONSHIP__OML_SOURCE);
		createEReference(omlReifiedRelationshipEClass, OML_REIFIED_RELATIONSHIP__OML_TARGET);

		// Create data types
		iriEDataType = createEDataType(IRI);
		localNameEDataType = createEDataType(LOCAL_NAME);
		lexicalValueEDataType = createEDataType(LEXICAL_VALUE);
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
		omlDescriptionEClass.getESuperTypes().add(this.getOMLObject());
		omlStructureEClass.getESuperTypes().add(this.getOMLObject());
		omlEntityEClass.getESuperTypes().add(this.getOMLObject());
		omlAspectEClass.getESuperTypes().add(this.getOMLEntity());
		omlConceptEClass.getESuperTypes().add(this.getOMLEntity());
		omlReifiedRelationshipEClass.getESuperTypes().add(this.getOMLEntity());

		// Initialize classes, features, and operations; add parameters
		initEClass(omlObjectEClass, OMLObject.class, "OMLObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getOMLObject__OmlInverseReferencers__Class(), null, "omlInverseReferencers", 0, -1, !IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		EGenericType g1 = createEGenericType(this.getOMLObject());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "aType", 0, 1, !IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(omlDescriptionEClass, OMLDescription.class, "OMLDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOMLDescription_OmlIRI(), this.getIRI(), "omlIRI", null, 0, 1, OMLDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOMLDescription_OmlContents(), this.getOMLEntity(), this.getOMLEntity_OmlDescription(), "omlContents", null, 0, -1, OMLDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omlStructureEClass, OMLStructure.class, "OMLStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlEntityEClass, OMLEntity.class, "OMLEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOMLEntity_OmlName(), this.getLocalName(), "omlName", null, 0, 1, OMLEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOMLEntity_OmlDescription(), this.getOMLDescription(), this.getOMLDescription_OmlContents(), "omlDescription", null, 1, 1, OMLEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omlAspectEClass, OMLAspect.class, "OMLAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlConceptEClass, OMLConcept.class, "OMLConcept", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlReifiedRelationshipEClass, OMLReifiedRelationship.class, "OMLReifiedRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOMLReifiedRelationship_OmlSource(), this.getOMLEntity(), null, "omlSource", null, 1, 1, OMLReifiedRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOMLReifiedRelationship_OmlTarget(), this.getOMLEntity(), null, "omlTarget", null, 1, 1, OMLReifiedRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(iriEDataType, String.class, "IRI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(localNameEDataType, String.class, "LocalName", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lexicalValueEDataType, String.class, "LexicalValue", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
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
			 "OMLProvenance", "http://imce.jpl.nasa.gov/oml/runtime/OMLProvenance"
		   });
	}

} //OMLRuntimePackageImpl
