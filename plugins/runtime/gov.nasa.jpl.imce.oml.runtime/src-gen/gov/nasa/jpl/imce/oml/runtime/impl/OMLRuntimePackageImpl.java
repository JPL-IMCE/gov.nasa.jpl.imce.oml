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
import gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToScalar;
import gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToStructure;
import gov.nasa.jpl.imce.oml.runtime.OMLEntityRelationship;
import gov.nasa.jpl.imce.oml.runtime.OMLObject;
import gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship;
import gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromEntity;
import gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromStructure;
import gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToEntity;
import gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToStructure;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimeFactory;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage;
import gov.nasa.jpl.imce.oml.runtime.OMLStructure;
import gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToScalar;
import gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToStructure;
import gov.nasa.jpl.imce.oml.runtime.OMLUnreifiedRelationship;

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
	private EClass omlRelationshipFromEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlRelationshipFromStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlRelationshipToEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlRelationshipToStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlEntityRelationshipEClass = null;

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
	private EClass omlUnreifiedRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlEntityDataPropertyToScalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlEntityDataPropertyToStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlStructureDataPropertyToScalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omlStructureDataPropertyToStructureEClass = null;

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
	public EReference getOMLObject_OmlRoot() {
		return (EReference)omlObjectEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getOMLDescription_OmlDesciptionIRI() {
		return (EAttribute)omlDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLDescription_OmlDescriptionContents() {
		return (EReference)omlDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOMLDescription__GetOMLRoot() {
		return omlDescriptionEClass.getEOperations().get(0);
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
	public EClass getOMLRelationshipFromEntity() {
		return omlRelationshipFromEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLRelationshipFromEntity_OmlSource() {
		return (EReference)omlRelationshipFromEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLRelationshipFromStructure() {
		return omlRelationshipFromStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLRelationshipFromStructure_OmlSource() {
		return (EReference)omlRelationshipFromStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLRelationshipToEntity() {
		return omlRelationshipToEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLRelationshipToEntity_OmlTarget() {
		return (EReference)omlRelationshipToEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLRelationshipToStructure() {
		return omlRelationshipToStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMLRelationshipToStructure_OmlTarget() {
		return (EReference)omlRelationshipToStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLEntityRelationship() {
		return omlEntityRelationshipEClass;
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
	public EClass getOMLUnreifiedRelationship() {
		return omlUnreifiedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLEntityDataPropertyToScalar() {
		return omlEntityDataPropertyToScalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOMLEntityDataPropertyToScalar_Value() {
		return (EAttribute)omlEntityDataPropertyToScalarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLEntityDataPropertyToStructure() {
		return omlEntityDataPropertyToStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLStructureDataPropertyToScalar() {
		return omlStructureDataPropertyToScalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOMLStructureDataPropertyToScalar_Value() {
		return (EAttribute)omlStructureDataPropertyToScalarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMLStructureDataPropertyToStructure() {
		return omlStructureDataPropertyToStructureEClass;
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
		createEReference(omlObjectEClass, OML_OBJECT__OML_ROOT);
		createEOperation(omlObjectEClass, OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS);

		omlDescriptionEClass = createEClass(OML_DESCRIPTION);
		createEAttribute(omlDescriptionEClass, OML_DESCRIPTION__OML_DESCIPTION_IRI);
		createEReference(omlDescriptionEClass, OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS);
		createEOperation(omlDescriptionEClass, OML_DESCRIPTION___GET_OML_ROOT);

		omlStructureEClass = createEClass(OML_STRUCTURE);

		omlEntityEClass = createEClass(OML_ENTITY);

		omlAspectEClass = createEClass(OML_ASPECT);

		omlConceptEClass = createEClass(OML_CONCEPT);

		omlRelationshipFromEntityEClass = createEClass(OML_RELATIONSHIP_FROM_ENTITY);
		createEReference(omlRelationshipFromEntityEClass, OML_RELATIONSHIP_FROM_ENTITY__OML_SOURCE);

		omlRelationshipFromStructureEClass = createEClass(OML_RELATIONSHIP_FROM_STRUCTURE);
		createEReference(omlRelationshipFromStructureEClass, OML_RELATIONSHIP_FROM_STRUCTURE__OML_SOURCE);

		omlRelationshipToEntityEClass = createEClass(OML_RELATIONSHIP_TO_ENTITY);
		createEReference(omlRelationshipToEntityEClass, OML_RELATIONSHIP_TO_ENTITY__OML_TARGET);

		omlRelationshipToStructureEClass = createEClass(OML_RELATIONSHIP_TO_STRUCTURE);
		createEReference(omlRelationshipToStructureEClass, OML_RELATIONSHIP_TO_STRUCTURE__OML_TARGET);

		omlEntityRelationshipEClass = createEClass(OML_ENTITY_RELATIONSHIP);

		omlReifiedRelationshipEClass = createEClass(OML_REIFIED_RELATIONSHIP);

		omlUnreifiedRelationshipEClass = createEClass(OML_UNREIFIED_RELATIONSHIP);

		omlEntityDataPropertyToScalarEClass = createEClass(OML_ENTITY_DATA_PROPERTY_TO_SCALAR);
		createEAttribute(omlEntityDataPropertyToScalarEClass, OML_ENTITY_DATA_PROPERTY_TO_SCALAR__VALUE);

		omlEntityDataPropertyToStructureEClass = createEClass(OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE);

		omlStructureDataPropertyToScalarEClass = createEClass(OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR);
		createEAttribute(omlStructureDataPropertyToScalarEClass, OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR__VALUE);

		omlStructureDataPropertyToStructureEClass = createEClass(OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE);

		// Create data types
		iriEDataType = createEDataType(IRI);
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
		omlEntityEClass.getESuperTypes().add(this.getOMLObject());
		omlAspectEClass.getESuperTypes().add(this.getOMLEntity());
		omlConceptEClass.getESuperTypes().add(this.getOMLEntity());
		omlRelationshipFromEntityEClass.getESuperTypes().add(this.getOMLObject());
		omlRelationshipFromStructureEClass.getESuperTypes().add(this.getOMLObject());
		omlRelationshipToEntityEClass.getESuperTypes().add(this.getOMLObject());
		omlRelationshipToStructureEClass.getESuperTypes().add(this.getOMLObject());
		omlEntityRelationshipEClass.getESuperTypes().add(this.getOMLRelationshipFromEntity());
		omlEntityRelationshipEClass.getESuperTypes().add(this.getOMLRelationshipToEntity());
		omlReifiedRelationshipEClass.getESuperTypes().add(this.getOMLEntityRelationship());
		omlReifiedRelationshipEClass.getESuperTypes().add(this.getOMLEntity());
		omlUnreifiedRelationshipEClass.getESuperTypes().add(this.getOMLEntityRelationship());
		omlEntityDataPropertyToScalarEClass.getESuperTypes().add(this.getOMLRelationshipFromEntity());
		omlEntityDataPropertyToStructureEClass.getESuperTypes().add(this.getOMLRelationshipFromEntity());
		omlEntityDataPropertyToStructureEClass.getESuperTypes().add(this.getOMLRelationshipToStructure());
		omlStructureDataPropertyToScalarEClass.getESuperTypes().add(this.getOMLRelationshipFromStructure());
		omlStructureDataPropertyToStructureEClass.getESuperTypes().add(this.getOMLRelationshipFromStructure());
		omlStructureDataPropertyToStructureEClass.getESuperTypes().add(this.getOMLRelationshipToStructure());

		// Initialize classes, features, and operations; add parameters
		initEClass(omlObjectEClass, OMLObject.class, "OMLObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOMLObject_OmlRoot(), this.getOMLDescription(), this.getOMLDescription_OmlDescriptionContents(), "omlRoot", null, 1, 1, OMLObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEAttribute(getOMLDescription_OmlDesciptionIRI(), this.getIRI(), "omlDesciptionIRI", null, 0, 1, OMLDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOMLDescription_OmlDescriptionContents(), this.getOMLObject(), this.getOMLObject_OmlRoot(), "omlDescriptionContents", null, 0, -1, OMLDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOMLDescription__GetOMLRoot(), this.getOMLDescription(), "getOMLRoot", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(omlStructureEClass, OMLStructure.class, "OMLStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlEntityEClass, OMLEntity.class, "OMLEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlAspectEClass, OMLAspect.class, "OMLAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlConceptEClass, OMLConcept.class, "OMLConcept", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlRelationshipFromEntityEClass, OMLRelationshipFromEntity.class, "OMLRelationshipFromEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOMLRelationshipFromEntity_OmlSource(), this.getOMLEntity(), null, "omlSource", null, 1, 1, OMLRelationshipFromEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omlRelationshipFromStructureEClass, OMLRelationshipFromStructure.class, "OMLRelationshipFromStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOMLRelationshipFromStructure_OmlSource(), this.getOMLStructure(), null, "omlSource", null, 1, 1, OMLRelationshipFromStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omlRelationshipToEntityEClass, OMLRelationshipToEntity.class, "OMLRelationshipToEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOMLRelationshipToEntity_OmlTarget(), this.getOMLEntity(), null, "omlTarget", null, 1, 1, OMLRelationshipToEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omlRelationshipToStructureEClass, OMLRelationshipToStructure.class, "OMLRelationshipToStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOMLRelationshipToStructure_OmlTarget(), this.getOMLStructure(), null, "omlTarget", null, 1, 1, OMLRelationshipToStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omlEntityRelationshipEClass, OMLEntityRelationship.class, "OMLEntityRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlReifiedRelationshipEClass, OMLReifiedRelationship.class, "OMLReifiedRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlUnreifiedRelationshipEClass, OMLUnreifiedRelationship.class, "OMLUnreifiedRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlEntityDataPropertyToScalarEClass, OMLEntityDataPropertyToScalar.class, "OMLEntityDataPropertyToScalar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOMLEntityDataPropertyToScalar_Value(), this.getLexicalValue(), "value", null, 0, 1, OMLEntityDataPropertyToScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omlEntityDataPropertyToStructureEClass, OMLEntityDataPropertyToStructure.class, "OMLEntityDataPropertyToStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(omlStructureDataPropertyToScalarEClass, OMLStructureDataPropertyToScalar.class, "OMLStructureDataPropertyToScalar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOMLStructureDataPropertyToScalar_Value(), this.getLexicalValue(), "value", null, 0, 1, OMLStructureDataPropertyToScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omlStructureDataPropertyToStructureEClass, OMLStructureDataPropertyToStructure.class, "OMLStructureDataPropertyToStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(iriEDataType, String.class, "IRI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
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
