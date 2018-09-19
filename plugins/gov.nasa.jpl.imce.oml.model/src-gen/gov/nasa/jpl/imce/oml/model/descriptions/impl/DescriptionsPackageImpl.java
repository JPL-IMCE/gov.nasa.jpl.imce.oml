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
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;

import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipEnumerationRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipExistentialRangeRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipUniversalRangeRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipValueRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.descriptions.TerminologyInstanceAssertion;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
public class DescriptionsPackageImpl extends EPackageImpl implements DescriptionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxExtendsClosedWorldDefinitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxRefinementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyInstanceAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singletonInstanceScalarDataPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singletonInstanceStructuredDataPropertyContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singletonInstanceStructuredDataPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredDataPropertyTupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarDataPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptualEntitySingletonInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceRelationshipEnumerationRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceRelationshipOneOfRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceRelationshipValueRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceRelationshipExistentialRangeRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceRelationshipUniversalRangeRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipInstanceDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipInstanceRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unreifiedRelationshipInstanceTupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum descriptionKindEEnum = null;

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
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DescriptionsPackageImpl() {
		super(eNS_URI, DescriptionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DescriptionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DescriptionsPackage init() {
		if (isInited) return (DescriptionsPackage)EPackage.Registry.INSTANCE.getEPackage(DescriptionsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDescriptionsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DescriptionsPackageImpl theDescriptionsPackage = registeredDescriptionsPackage instanceof DescriptionsPackageImpl ? (DescriptionsPackageImpl)registeredDescriptionsPackage : new DescriptionsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		TerminologiesPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDescriptionsPackage.createPackageContents();

		// Initialize created meta-data
		theDescriptionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDescriptionsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DescriptionsPackage.eNS_URI, theDescriptionsPackage);
		return theDescriptionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionBox() {
		return descriptionBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptionBox_Kind() {
		return (EAttribute)descriptionBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_DescriptionBoxRefinements() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ClosedWorldDefinitions() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ConceptInstances() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ReifiedRelationshipInstances() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_InstanceRelationshipEnumerationRestrictions() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_InstanceRelationshipValueRestrictions() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_InstanceRelationshipExistentialRangeRestrictions() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_InstanceRelationshipUniversalRangeRestrictions() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ReifiedRelationshipInstanceDomains() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ReifiedRelationshipInstanceRanges() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_UnreifiedRelationshipInstanceTuples() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_SingletonScalarDataPropertyValues() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_SingletonStructuredDataPropertyValues() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBox__ModuleEdges() {
		return descriptionBoxEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBox__ModuleElements() {
		return descriptionBoxEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionBoxRelationship() {
		return descriptionBoxRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRelationship__DescriptionDomain() {
		return descriptionBoxRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRelationship__SourceModule() {
		return descriptionBoxRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionBoxExtendsClosedWorldDefinitions() {
		return descriptionBoxExtendsClosedWorldDefinitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox() {
		return (EReference)descriptionBoxExtendsClosedWorldDefinitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions() {
		return (EReference)descriptionBoxExtendsClosedWorldDefinitionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain() {
		return descriptionBoxExtendsClosedWorldDefinitionsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxExtendsClosedWorldDefinitions__TargetModule() {
		return descriptionBoxExtendsClosedWorldDefinitionsEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxExtendsClosedWorldDefinitions__Uuid() {
		return descriptionBoxExtendsClosedWorldDefinitionsEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionBoxRefinement() {
		return descriptionBoxRefinementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBoxRefinement_RefiningDescriptionBox() {
		return (EReference)descriptionBoxRefinementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBoxRefinement_RefinedDescriptionBox() {
		return (EReference)descriptionBoxRefinementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRefinement__DescriptionDomain() {
		return descriptionBoxRefinementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRefinement__TargetModule() {
		return descriptionBoxRefinementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRefinement__Uuid() {
		return descriptionBoxRefinementEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyInstanceAssertion() {
		return terminologyInstanceAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingletonInstanceScalarDataPropertyValue() {
		return singletonInstanceScalarDataPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceScalarDataPropertyValue_DescriptionBox() {
		return (EReference)singletonInstanceScalarDataPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceScalarDataPropertyValue_SingletonInstance() {
		return (EReference)singletonInstanceScalarDataPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceScalarDataPropertyValue_ScalarDataProperty() {
		return (EReference)singletonInstanceScalarDataPropertyValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceScalarDataPropertyValue_ScalarPropertyValue() {
		return (EReference)singletonInstanceScalarDataPropertyValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceScalarDataPropertyValue_ValueType() {
		return (EReference)singletonInstanceScalarDataPropertyValueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceScalarDataPropertyValue__Uuid() {
		return singletonInstanceScalarDataPropertyValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceScalarDataPropertyValue__DescriptionBox() {
		return singletonInstanceScalarDataPropertyValueEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceScalarDataPropertyValue__ModuleContext() {
		return singletonInstanceScalarDataPropertyValueEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceScalarDataPropertyValue__AllNestedElements() {
		return singletonInstanceScalarDataPropertyValueEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingletonInstanceStructuredDataPropertyContext() {
		return singletonInstanceStructuredDataPropertyContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceStructuredDataPropertyContext_StructuredDataProperty() {
		return (EReference)singletonInstanceStructuredDataPropertyContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceStructuredDataPropertyContext_StructuredPropertyTuples() {
		return (EReference)singletonInstanceStructuredDataPropertyContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceStructuredDataPropertyContext_ScalarDataPropertyValues() {
		return (EReference)singletonInstanceStructuredDataPropertyContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceStructuredDataPropertyContext__DescriptionBox() {
		return singletonInstanceStructuredDataPropertyContextEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceStructuredDataPropertyContext__ModuleContext() {
		return singletonInstanceStructuredDataPropertyContextEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceStructuredDataPropertyContext__AllNestedRestrictionElements() {
		return singletonInstanceStructuredDataPropertyContextEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingletonInstanceStructuredDataPropertyValue() {
		return singletonInstanceStructuredDataPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceStructuredDataPropertyValue_DescriptionBox() {
		return (EReference)singletonInstanceStructuredDataPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstanceStructuredDataPropertyValue_SingletonInstance() {
		return (EReference)singletonInstanceStructuredDataPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceStructuredDataPropertyValue__Uuid() {
		return singletonInstanceStructuredDataPropertyValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceStructuredDataPropertyValue__DescriptionBox() {
		return singletonInstanceStructuredDataPropertyValueEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingletonInstanceStructuredDataPropertyValue__AllNestedElements() {
		return singletonInstanceStructuredDataPropertyValueEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuredDataPropertyTuple() {
		return structuredDataPropertyTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredDataPropertyTuple_StructuredDataPropertyContext() {
		return (EReference)structuredDataPropertyTupleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStructuredDataPropertyTuple__DescriptionBox() {
		return structuredDataPropertyTupleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStructuredDataPropertyTuple__Uuid() {
		return structuredDataPropertyTupleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarDataPropertyValue() {
		return scalarDataPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarDataPropertyValue_StructuredDataPropertyContext() {
		return (EReference)scalarDataPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarDataPropertyValue_ScalarDataProperty() {
		return (EReference)scalarDataPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarDataPropertyValue_ScalarPropertyValue() {
		return (EReference)scalarDataPropertyValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarDataPropertyValue_ValueType() {
		return (EReference)scalarDataPropertyValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarDataPropertyValue__DescriptionBox() {
		return scalarDataPropertyValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarDataPropertyValue__Uuid() {
		return scalarDataPropertyValueEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarDataPropertyValue__ModuleContext() {
		return scalarDataPropertyValueEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptualEntitySingletonInstance() {
		return conceptualEntitySingletonInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConceptualEntitySingletonInstance_Name() {
		return (EAttribute)conceptualEntitySingletonInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__DescriptionBox() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__Iri() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__AbbrevIRI() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__Name() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__ConceptualEntitySingletonClassifier() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__Uuid() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__ModuleContext() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptInstance() {
		return conceptInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptInstance_DescriptionBox() {
		return (EReference)conceptInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptInstance_SingletonConceptClassifier() {
		return (EReference)conceptInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptInstance__ConceptualEntitySingletonClassifier() {
		return conceptInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptInstance__DescriptionBox() {
		return conceptInstanceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptInstance__AllNestedElements() {
		return conceptInstanceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceRelationshipEnumerationRestriction() {
		return instanceRelationshipEnumerationRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipEnumerationRestriction_DescriptionBox() {
		return (EReference)instanceRelationshipEnumerationRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipEnumerationRestriction_Domain() {
		return (EReference)instanceRelationshipEnumerationRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipEnumerationRestriction_RestrictedRelationship() {
		return (EReference)instanceRelationshipEnumerationRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipEnumerationRestriction_References() {
		return (EReference)instanceRelationshipEnumerationRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipEnumerationRestriction__DescriptionBox() {
		return instanceRelationshipEnumerationRestrictionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipEnumerationRestriction__Uuid() {
		return instanceRelationshipEnumerationRestrictionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipEnumerationRestriction__ModuleContext() {
		return instanceRelationshipEnumerationRestrictionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipEnumerationRestriction__AllNestedElements() {
		return instanceRelationshipEnumerationRestrictionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceRelationshipOneOfRestriction() {
		return instanceRelationshipOneOfRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipOneOfRestriction_Enumeration() {
		return (EReference)instanceRelationshipOneOfRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipOneOfRestriction_Range() {
		return (EReference)instanceRelationshipOneOfRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipOneOfRestriction__Uuid() {
		return instanceRelationshipOneOfRestrictionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipOneOfRestriction__ModuleContext() {
		return instanceRelationshipOneOfRestrictionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipOneOfRestriction__AllNestedElements() {
		return instanceRelationshipOneOfRestrictionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceRelationshipValueRestriction() {
		return instanceRelationshipValueRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipValueRestriction_DescriptionBox() {
		return (EReference)instanceRelationshipValueRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipValueRestriction_Domain() {
		return (EReference)instanceRelationshipValueRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipValueRestriction_RestrictedRelationship() {
		return (EReference)instanceRelationshipValueRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipValueRestriction_Range() {
		return (EReference)instanceRelationshipValueRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipValueRestriction__DescriptionBox() {
		return instanceRelationshipValueRestrictionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipValueRestriction__Uuid() {
		return instanceRelationshipValueRestrictionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipValueRestriction__ModuleContext() {
		return instanceRelationshipValueRestrictionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipValueRestriction__AllNestedElements() {
		return instanceRelationshipValueRestrictionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceRelationshipExistentialRangeRestriction() {
		return instanceRelationshipExistentialRangeRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipExistentialRangeRestriction_DescriptionBox() {
		return (EReference)instanceRelationshipExistentialRangeRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipExistentialRangeRestriction_Domain() {
		return (EReference)instanceRelationshipExistentialRangeRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipExistentialRangeRestriction_RestrictedRelationship() {
		return (EReference)instanceRelationshipExistentialRangeRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipExistentialRangeRestriction_Range() {
		return (EReference)instanceRelationshipExistentialRangeRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipExistentialRangeRestriction__DescriptionBox() {
		return instanceRelationshipExistentialRangeRestrictionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipExistentialRangeRestriction__Uuid() {
		return instanceRelationshipExistentialRangeRestrictionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipExistentialRangeRestriction__ModuleContext() {
		return instanceRelationshipExistentialRangeRestrictionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipExistentialRangeRestriction__AllNestedElements() {
		return instanceRelationshipExistentialRangeRestrictionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceRelationshipUniversalRangeRestriction() {
		return instanceRelationshipUniversalRangeRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipUniversalRangeRestriction_DescriptionBox() {
		return (EReference)instanceRelationshipUniversalRangeRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipUniversalRangeRestriction_Domain() {
		return (EReference)instanceRelationshipUniversalRangeRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipUniversalRangeRestriction_RestrictedRelationship() {
		return (EReference)instanceRelationshipUniversalRangeRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceRelationshipUniversalRangeRestriction_Range() {
		return (EReference)instanceRelationshipUniversalRangeRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipUniversalRangeRestriction__DescriptionBox() {
		return instanceRelationshipUniversalRangeRestrictionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipUniversalRangeRestriction__Uuid() {
		return instanceRelationshipUniversalRangeRestrictionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipUniversalRangeRestriction__ModuleContext() {
		return instanceRelationshipUniversalRangeRestrictionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceRelationshipUniversalRangeRestriction__AllNestedElements() {
		return instanceRelationshipUniversalRangeRestrictionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipInstance() {
		return reifiedRelationshipInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstance_DescriptionBox() {
		return (EReference)reifiedRelationshipInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstance_SingletonConceptualRelationshipClassifier() {
		return (EReference)reifiedRelationshipInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier() {
		return reifiedRelationshipInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstance__DescriptionBox() {
		return reifiedRelationshipInstanceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstance__AllNestedElements() {
		return reifiedRelationshipInstanceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipInstanceDomain() {
		return reifiedRelationshipInstanceDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceDomain_DescriptionBox() {
		return (EReference)reifiedRelationshipInstanceDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceDomain_ReifiedRelationshipInstance() {
		return (EReference)reifiedRelationshipInstanceDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceDomain_Domain() {
		return (EReference)reifiedRelationshipInstanceDomainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstanceDomain__DescriptionBox() {
		return reifiedRelationshipInstanceDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstanceDomain__Uuid() {
		return reifiedRelationshipInstanceDomainEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstanceDomain__ModuleContext() {
		return reifiedRelationshipInstanceDomainEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstanceDomain__AllNestedElements() {
		return reifiedRelationshipInstanceDomainEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipInstanceRange() {
		return reifiedRelationshipInstanceRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceRange_DescriptionBox() {
		return (EReference)reifiedRelationshipInstanceRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceRange_ReifiedRelationshipInstance() {
		return (EReference)reifiedRelationshipInstanceRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceRange_Range() {
		return (EReference)reifiedRelationshipInstanceRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstanceRange__DescriptionBox() {
		return reifiedRelationshipInstanceRangeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstanceRange__Uuid() {
		return reifiedRelationshipInstanceRangeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstanceRange__ModuleContext() {
		return reifiedRelationshipInstanceRangeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstanceRange__AllNestedElements() {
		return reifiedRelationshipInstanceRangeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnreifiedRelationshipInstanceTuple() {
		return unreifiedRelationshipInstanceTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInstanceTuple_DescriptionBox() {
		return (EReference)unreifiedRelationshipInstanceTupleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInstanceTuple_UnreifiedRelationship() {
		return (EReference)unreifiedRelationshipInstanceTupleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInstanceTuple_Domain() {
		return (EReference)unreifiedRelationshipInstanceTupleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInstanceTuple_Range() {
		return (EReference)unreifiedRelationshipInstanceTupleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnreifiedRelationshipInstanceTuple__DescriptionBox() {
		return unreifiedRelationshipInstanceTupleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnreifiedRelationshipInstanceTuple__Uuid() {
		return unreifiedRelationshipInstanceTupleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnreifiedRelationshipInstanceTuple__ModuleContext() {
		return unreifiedRelationshipInstanceTupleEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnreifiedRelationshipInstanceTuple__AllNestedElements() {
		return unreifiedRelationshipInstanceTupleEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDescriptionKind() {
		return descriptionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionsFactory getDescriptionsFactory() {
		return (DescriptionsFactory)getEFactoryInstance();
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
		descriptionBoxEClass = createEClass(DESCRIPTION_BOX);
		createEAttribute(descriptionBoxEClass, DESCRIPTION_BOX__KIND);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__CONCEPT_INSTANCES);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTIONS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__INSTANCE_RELATIONSHIP_VALUE_RESTRICTIONS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTIONS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTIONS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES);
		createEOperation(descriptionBoxEClass, DESCRIPTION_BOX___MODULE_EDGES);
		createEOperation(descriptionBoxEClass, DESCRIPTION_BOX___MODULE_ELEMENTS);

		descriptionBoxRelationshipEClass = createEClass(DESCRIPTION_BOX_RELATIONSHIP);
		createEOperation(descriptionBoxRelationshipEClass, DESCRIPTION_BOX_RELATIONSHIP___DESCRIPTION_DOMAIN);
		createEOperation(descriptionBoxRelationshipEClass, DESCRIPTION_BOX_RELATIONSHIP___SOURCE_MODULE);

		descriptionBoxExtendsClosedWorldDefinitionsEClass = createEClass(DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS);
		createEReference(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__DESCRIPTION_BOX);
		createEReference(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__CLOSED_WORLD_DEFINITIONS);
		createEOperation(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___DESCRIPTION_DOMAIN);
		createEOperation(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___TARGET_MODULE);
		createEOperation(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___UUID);

		descriptionBoxRefinementEClass = createEClass(DESCRIPTION_BOX_REFINEMENT);
		createEReference(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX);
		createEReference(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX);
		createEOperation(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT___DESCRIPTION_DOMAIN);
		createEOperation(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT___TARGET_MODULE);
		createEOperation(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT___UUID);

		terminologyInstanceAssertionEClass = createEClass(TERMINOLOGY_INSTANCE_ASSERTION);

		singletonInstanceScalarDataPropertyValueEClass = createEClass(SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE);
		createEReference(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__DESCRIPTION_BOX);
		createEReference(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE);
		createEReference(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY);
		createEReference(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE);
		createEReference(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE);
		createEOperation(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___UUID);
		createEOperation(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___DESCRIPTION_BOX);
		createEOperation(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___MODULE_CONTEXT);
		createEOperation(singletonInstanceScalarDataPropertyValueEClass, SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE___ALL_NESTED_ELEMENTS);

		singletonInstanceStructuredDataPropertyContextEClass = createEClass(SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT);
		createEReference(singletonInstanceStructuredDataPropertyContextEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY);
		createEReference(singletonInstanceStructuredDataPropertyContextEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_PROPERTY_TUPLES);
		createEReference(singletonInstanceStructuredDataPropertyContextEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_VALUES);
		createEOperation(singletonInstanceStructuredDataPropertyContextEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT___DESCRIPTION_BOX);
		createEOperation(singletonInstanceStructuredDataPropertyContextEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT___MODULE_CONTEXT);
		createEOperation(singletonInstanceStructuredDataPropertyContextEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_CONTEXT___ALL_NESTED_RESTRICTION_ELEMENTS);

		singletonInstanceStructuredDataPropertyValueEClass = createEClass(SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE);
		createEReference(singletonInstanceStructuredDataPropertyValueEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__DESCRIPTION_BOX);
		createEReference(singletonInstanceStructuredDataPropertyValueEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE);
		createEOperation(singletonInstanceStructuredDataPropertyValueEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___UUID);
		createEOperation(singletonInstanceStructuredDataPropertyValueEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___DESCRIPTION_BOX);
		createEOperation(singletonInstanceStructuredDataPropertyValueEClass, SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE___ALL_NESTED_ELEMENTS);

		structuredDataPropertyTupleEClass = createEClass(STRUCTURED_DATA_PROPERTY_TUPLE);
		createEReference(structuredDataPropertyTupleEClass, STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		createEOperation(structuredDataPropertyTupleEClass, STRUCTURED_DATA_PROPERTY_TUPLE___DESCRIPTION_BOX);
		createEOperation(structuredDataPropertyTupleEClass, STRUCTURED_DATA_PROPERTY_TUPLE___UUID);

		scalarDataPropertyValueEClass = createEClass(SCALAR_DATA_PROPERTY_VALUE);
		createEReference(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		createEReference(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY);
		createEReference(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE);
		createEReference(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE);
		createEOperation(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE___DESCRIPTION_BOX);
		createEOperation(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE___UUID);
		createEOperation(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE___MODULE_CONTEXT);

		conceptualEntitySingletonInstanceEClass = createEClass(CONCEPTUAL_ENTITY_SINGLETON_INSTANCE);
		createEAttribute(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE__NAME);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___DESCRIPTION_BOX);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___IRI);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___ABBREV_IRI);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___NAME);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___UUID);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___MODULE_CONTEXT);

		conceptInstanceEClass = createEClass(CONCEPT_INSTANCE);
		createEReference(conceptInstanceEClass, CONCEPT_INSTANCE__DESCRIPTION_BOX);
		createEReference(conceptInstanceEClass, CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER);
		createEOperation(conceptInstanceEClass, CONCEPT_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER);
		createEOperation(conceptInstanceEClass, CONCEPT_INSTANCE___DESCRIPTION_BOX);
		createEOperation(conceptInstanceEClass, CONCEPT_INSTANCE___ALL_NESTED_ELEMENTS);

		instanceRelationshipEnumerationRestrictionEClass = createEClass(INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION);
		createEReference(instanceRelationshipEnumerationRestrictionEClass, INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DESCRIPTION_BOX);
		createEReference(instanceRelationshipEnumerationRestrictionEClass, INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__DOMAIN);
		createEReference(instanceRelationshipEnumerationRestrictionEClass, INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__RESTRICTED_RELATIONSHIP);
		createEReference(instanceRelationshipEnumerationRestrictionEClass, INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION__REFERENCES);
		createEOperation(instanceRelationshipEnumerationRestrictionEClass, INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION___DESCRIPTION_BOX);
		createEOperation(instanceRelationshipEnumerationRestrictionEClass, INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION___UUID);
		createEOperation(instanceRelationshipEnumerationRestrictionEClass, INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION___MODULE_CONTEXT);
		createEOperation(instanceRelationshipEnumerationRestrictionEClass, INSTANCE_RELATIONSHIP_ENUMERATION_RESTRICTION___ALL_NESTED_ELEMENTS);

		instanceRelationshipOneOfRestrictionEClass = createEClass(INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION);
		createEReference(instanceRelationshipOneOfRestrictionEClass, INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__ENUMERATION);
		createEReference(instanceRelationshipOneOfRestrictionEClass, INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION__RANGE);
		createEOperation(instanceRelationshipOneOfRestrictionEClass, INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION___UUID);
		createEOperation(instanceRelationshipOneOfRestrictionEClass, INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION___MODULE_CONTEXT);
		createEOperation(instanceRelationshipOneOfRestrictionEClass, INSTANCE_RELATIONSHIP_ONE_OF_RESTRICTION___ALL_NESTED_ELEMENTS);

		instanceRelationshipValueRestrictionEClass = createEClass(INSTANCE_RELATIONSHIP_VALUE_RESTRICTION);
		createEReference(instanceRelationshipValueRestrictionEClass, INSTANCE_RELATIONSHIP_VALUE_RESTRICTION__DESCRIPTION_BOX);
		createEReference(instanceRelationshipValueRestrictionEClass, INSTANCE_RELATIONSHIP_VALUE_RESTRICTION__DOMAIN);
		createEReference(instanceRelationshipValueRestrictionEClass, INSTANCE_RELATIONSHIP_VALUE_RESTRICTION__RESTRICTED_RELATIONSHIP);
		createEReference(instanceRelationshipValueRestrictionEClass, INSTANCE_RELATIONSHIP_VALUE_RESTRICTION__RANGE);
		createEOperation(instanceRelationshipValueRestrictionEClass, INSTANCE_RELATIONSHIP_VALUE_RESTRICTION___DESCRIPTION_BOX);
		createEOperation(instanceRelationshipValueRestrictionEClass, INSTANCE_RELATIONSHIP_VALUE_RESTRICTION___UUID);
		createEOperation(instanceRelationshipValueRestrictionEClass, INSTANCE_RELATIONSHIP_VALUE_RESTRICTION___MODULE_CONTEXT);
		createEOperation(instanceRelationshipValueRestrictionEClass, INSTANCE_RELATIONSHIP_VALUE_RESTRICTION___ALL_NESTED_ELEMENTS);

		instanceRelationshipExistentialRangeRestrictionEClass = createEClass(INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION);
		createEReference(instanceRelationshipExistentialRangeRestrictionEClass, INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION__DESCRIPTION_BOX);
		createEReference(instanceRelationshipExistentialRangeRestrictionEClass, INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION__DOMAIN);
		createEReference(instanceRelationshipExistentialRangeRestrictionEClass, INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION__RESTRICTED_RELATIONSHIP);
		createEReference(instanceRelationshipExistentialRangeRestrictionEClass, INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION__RANGE);
		createEOperation(instanceRelationshipExistentialRangeRestrictionEClass, INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION___DESCRIPTION_BOX);
		createEOperation(instanceRelationshipExistentialRangeRestrictionEClass, INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION___UUID);
		createEOperation(instanceRelationshipExistentialRangeRestrictionEClass, INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION___MODULE_CONTEXT);
		createEOperation(instanceRelationshipExistentialRangeRestrictionEClass, INSTANCE_RELATIONSHIP_EXISTENTIAL_RANGE_RESTRICTION___ALL_NESTED_ELEMENTS);

		instanceRelationshipUniversalRangeRestrictionEClass = createEClass(INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION);
		createEReference(instanceRelationshipUniversalRangeRestrictionEClass, INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION__DESCRIPTION_BOX);
		createEReference(instanceRelationshipUniversalRangeRestrictionEClass, INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION__DOMAIN);
		createEReference(instanceRelationshipUniversalRangeRestrictionEClass, INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION__RESTRICTED_RELATIONSHIP);
		createEReference(instanceRelationshipUniversalRangeRestrictionEClass, INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION__RANGE);
		createEOperation(instanceRelationshipUniversalRangeRestrictionEClass, INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION___DESCRIPTION_BOX);
		createEOperation(instanceRelationshipUniversalRangeRestrictionEClass, INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION___UUID);
		createEOperation(instanceRelationshipUniversalRangeRestrictionEClass, INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION___MODULE_CONTEXT);
		createEOperation(instanceRelationshipUniversalRangeRestrictionEClass, INSTANCE_RELATIONSHIP_UNIVERSAL_RANGE_RESTRICTION___ALL_NESTED_ELEMENTS);

		reifiedRelationshipInstanceEClass = createEClass(REIFIED_RELATIONSHIP_INSTANCE);
		createEReference(reifiedRelationshipInstanceEClass, REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX);
		createEReference(reifiedRelationshipInstanceEClass, REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_CONCEPTUAL_RELATIONSHIP_CLASSIFIER);
		createEOperation(reifiedRelationshipInstanceEClass, REIFIED_RELATIONSHIP_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER);
		createEOperation(reifiedRelationshipInstanceEClass, REIFIED_RELATIONSHIP_INSTANCE___DESCRIPTION_BOX);
		createEOperation(reifiedRelationshipInstanceEClass, REIFIED_RELATIONSHIP_INSTANCE___ALL_NESTED_ELEMENTS);

		reifiedRelationshipInstanceDomainEClass = createEClass(REIFIED_RELATIONSHIP_INSTANCE_DOMAIN);
		createEReference(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DESCRIPTION_BOX);
		createEReference(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__REIFIED_RELATIONSHIP_INSTANCE);
		createEReference(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DOMAIN);
		createEOperation(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN___DESCRIPTION_BOX);
		createEOperation(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN___UUID);
		createEOperation(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN___MODULE_CONTEXT);
		createEOperation(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN___ALL_NESTED_ELEMENTS);

		reifiedRelationshipInstanceRangeEClass = createEClass(REIFIED_RELATIONSHIP_INSTANCE_RANGE);
		createEReference(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE__DESCRIPTION_BOX);
		createEReference(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE__REIFIED_RELATIONSHIP_INSTANCE);
		createEReference(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE__RANGE);
		createEOperation(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE___DESCRIPTION_BOX);
		createEOperation(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE___UUID);
		createEOperation(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE___MODULE_CONTEXT);
		createEOperation(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE___ALL_NESTED_ELEMENTS);

		unreifiedRelationshipInstanceTupleEClass = createEClass(UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE);
		createEReference(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX);
		createEReference(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP);
		createEReference(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN);
		createEReference(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE);
		createEOperation(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___DESCRIPTION_BOX);
		createEOperation(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___UUID);
		createEOperation(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___MODULE_CONTEXT);
		createEOperation(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE___ALL_NESTED_ELEMENTS);

		// Create enums
		descriptionKindEEnum = createEEnum(DESCRIPTION_KIND);
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
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		TerminologiesPackage theTerminologiesPackage = (TerminologiesPackage)EPackage.Registry.INSTANCE.getEPackage(TerminologiesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		descriptionBoxEClass.getESuperTypes().add(theCommonPackage.getModule());
		descriptionBoxRelationshipEClass.getESuperTypes().add(theCommonPackage.getModuleEdge());
		descriptionBoxExtendsClosedWorldDefinitionsEClass.getESuperTypes().add(this.getDescriptionBoxRelationship());
		descriptionBoxRefinementEClass.getESuperTypes().add(this.getDescriptionBoxRelationship());
		terminologyInstanceAssertionEClass.getESuperTypes().add(theCommonPackage.getModuleElement());
		singletonInstanceScalarDataPropertyValueEClass.getESuperTypes().add(theCommonPackage.getModuleElement());
		singletonInstanceScalarDataPropertyValueEClass.getESuperTypes().add(theCommonPackage.getValueCrossReferenceTuple());
		singletonInstanceStructuredDataPropertyContextEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		singletonInstanceStructuredDataPropertyValueEClass.getESuperTypes().add(this.getSingletonInstanceStructuredDataPropertyContext());
		singletonInstanceStructuredDataPropertyValueEClass.getESuperTypes().add(theCommonPackage.getModuleElement());
		structuredDataPropertyTupleEClass.getESuperTypes().add(this.getSingletonInstanceStructuredDataPropertyContext());
		scalarDataPropertyValueEClass.getESuperTypes().add(theCommonPackage.getLogicalElement());
		scalarDataPropertyValueEClass.getESuperTypes().add(theCommonPackage.getValueCrossReferenceTuple());
		conceptualEntitySingletonInstanceEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		conceptualEntitySingletonInstanceEClass.getESuperTypes().add(theCommonPackage.getResource());
		conceptInstanceEClass.getESuperTypes().add(this.getConceptualEntitySingletonInstance());
		instanceRelationshipEnumerationRestrictionEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		instanceRelationshipEnumerationRestrictionEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		instanceRelationshipOneOfRestrictionEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		instanceRelationshipValueRestrictionEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		instanceRelationshipValueRestrictionEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		instanceRelationshipExistentialRangeRestrictionEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		instanceRelationshipExistentialRangeRestrictionEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		instanceRelationshipUniversalRangeRestrictionEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		instanceRelationshipUniversalRangeRestrictionEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		reifiedRelationshipInstanceEClass.getESuperTypes().add(this.getConceptualEntitySingletonInstance());
		reifiedRelationshipInstanceDomainEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		reifiedRelationshipInstanceDomainEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		reifiedRelationshipInstanceRangeEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		reifiedRelationshipInstanceRangeEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		unreifiedRelationshipInstanceTupleEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		unreifiedRelationshipInstanceTupleEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());

		// Initialize classes, features, and operations; add parameters
		initEClass(descriptionBoxEClass, DescriptionBox.class, "DescriptionBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptionBox_Kind(), this.getDescriptionKind(), "kind", null, 1, 1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_DescriptionBoxRefinements(), this.getDescriptionBoxRefinement(), this.getDescriptionBoxRefinement_RefiningDescriptionBox(), "descriptionBoxRefinements", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ClosedWorldDefinitions(), this.getDescriptionBoxExtendsClosedWorldDefinitions(), this.getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox(), "closedWorldDefinitions", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ConceptInstances(), this.getConceptInstance(), this.getConceptInstance_DescriptionBox(), "conceptInstances", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ReifiedRelationshipInstances(), this.getReifiedRelationshipInstance(), this.getReifiedRelationshipInstance_DescriptionBox(), "reifiedRelationshipInstances", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_InstanceRelationshipEnumerationRestrictions(), this.getInstanceRelationshipEnumerationRestriction(), this.getInstanceRelationshipEnumerationRestriction_DescriptionBox(), "instanceRelationshipEnumerationRestrictions", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_InstanceRelationshipValueRestrictions(), this.getInstanceRelationshipValueRestriction(), this.getInstanceRelationshipValueRestriction_DescriptionBox(), "instanceRelationshipValueRestrictions", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_InstanceRelationshipExistentialRangeRestrictions(), this.getInstanceRelationshipExistentialRangeRestriction(), this.getInstanceRelationshipExistentialRangeRestriction_DescriptionBox(), "instanceRelationshipExistentialRangeRestrictions", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_InstanceRelationshipUniversalRangeRestrictions(), this.getInstanceRelationshipUniversalRangeRestriction(), this.getInstanceRelationshipUniversalRangeRestriction_DescriptionBox(), "instanceRelationshipUniversalRangeRestrictions", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ReifiedRelationshipInstanceDomains(), this.getReifiedRelationshipInstanceDomain(), this.getReifiedRelationshipInstanceDomain_DescriptionBox(), "reifiedRelationshipInstanceDomains", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ReifiedRelationshipInstanceRanges(), this.getReifiedRelationshipInstanceRange(), this.getReifiedRelationshipInstanceRange_DescriptionBox(), "reifiedRelationshipInstanceRanges", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_UnreifiedRelationshipInstanceTuples(), this.getUnreifiedRelationshipInstanceTuple(), this.getUnreifiedRelationshipInstanceTuple_DescriptionBox(), "unreifiedRelationshipInstanceTuples", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_SingletonScalarDataPropertyValues(), this.getSingletonInstanceScalarDataPropertyValue(), this.getSingletonInstanceScalarDataPropertyValue_DescriptionBox(), "singletonScalarDataPropertyValues", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_SingletonStructuredDataPropertyValues(), this.getSingletonInstanceStructuredDataPropertyValue(), this.getSingletonInstanceStructuredDataPropertyValue_DescriptionBox(), "singletonStructuredDataPropertyValues", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDescriptionBox__ModuleEdges(), theCommonPackage.getModuleEdge(), "moduleEdges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBox__ModuleElements(), theCommonPackage.getModuleElement(), "moduleElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(descriptionBoxRelationshipEClass, DescriptionBoxRelationship.class, "DescriptionBoxRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDescriptionBoxRelationship__DescriptionDomain(), this.getDescriptionBox(), "descriptionDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBoxRelationship__SourceModule(), theCommonPackage.getModule(), "sourceModule", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(descriptionBoxExtendsClosedWorldDefinitionsEClass, DescriptionBoxExtendsClosedWorldDefinitions.class, "DescriptionBoxExtendsClosedWorldDefinitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ClosedWorldDefinitions(), "descriptionBox", null, 1, 1, DescriptionBoxExtendsClosedWorldDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions(), theTerminologiesPackage.getTerminologyBox(), null, "closedWorldDefinitions", null, 1, 1, DescriptionBoxExtendsClosedWorldDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain(), this.getDescriptionBox(), "descriptionDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBoxExtendsClosedWorldDefinitions__TargetModule(), theCommonPackage.getModule(), "targetModule", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBoxExtendsClosedWorldDefinitions__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(descriptionBoxRefinementEClass, DescriptionBoxRefinement.class, "DescriptionBoxRefinement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionBoxRefinement_RefiningDescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_DescriptionBoxRefinements(), "refiningDescriptionBox", null, 1, 1, DescriptionBoxRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBoxRefinement_RefinedDescriptionBox(), this.getDescriptionBox(), null, "refinedDescriptionBox", null, 1, 1, DescriptionBoxRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDescriptionBoxRefinement__DescriptionDomain(), this.getDescriptionBox(), "descriptionDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBoxRefinement__TargetModule(), theCommonPackage.getModule(), "targetModule", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBoxRefinement__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyInstanceAssertionEClass, TerminologyInstanceAssertion.class, "TerminologyInstanceAssertion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(singletonInstanceScalarDataPropertyValueEClass, SingletonInstanceScalarDataPropertyValue.class, "SingletonInstanceScalarDataPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingletonInstanceScalarDataPropertyValue_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_SingletonScalarDataPropertyValues(), "descriptionBox", null, 1, 1, SingletonInstanceScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingletonInstanceScalarDataPropertyValue_SingletonInstance(), this.getConceptualEntitySingletonInstance(), null, "singletonInstance", null, 1, 1, SingletonInstanceScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingletonInstanceScalarDataPropertyValue_ScalarDataProperty(), theTerminologiesPackage.getEntityScalarDataProperty(), null, "scalarDataProperty", null, 1, 1, SingletonInstanceScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingletonInstanceScalarDataPropertyValue_ScalarPropertyValue(), theCommonPackage.getLiteralValue(), null, "scalarPropertyValue", null, 1, 1, SingletonInstanceScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingletonInstanceScalarDataPropertyValue_ValueType(), theTerminologiesPackage.getDataRange(), null, "valueType", null, 0, 1, SingletonInstanceScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSingletonInstanceScalarDataPropertyValue__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingletonInstanceScalarDataPropertyValue__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingletonInstanceScalarDataPropertyValue__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingletonInstanceScalarDataPropertyValue__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(singletonInstanceStructuredDataPropertyContextEClass, SingletonInstanceStructuredDataPropertyContext.class, "SingletonInstanceStructuredDataPropertyContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingletonInstanceStructuredDataPropertyContext_StructuredDataProperty(), theTerminologiesPackage.getDataRelationshipToStructure(), null, "structuredDataProperty", null, 1, 1, SingletonInstanceStructuredDataPropertyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingletonInstanceStructuredDataPropertyContext_StructuredPropertyTuples(), this.getStructuredDataPropertyTuple(), this.getStructuredDataPropertyTuple_StructuredDataPropertyContext(), "structuredPropertyTuples", null, 0, -1, SingletonInstanceStructuredDataPropertyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingletonInstanceStructuredDataPropertyContext_ScalarDataPropertyValues(), this.getScalarDataPropertyValue(), this.getScalarDataPropertyValue_StructuredDataPropertyContext(), "scalarDataPropertyValues", null, 0, -1, SingletonInstanceStructuredDataPropertyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSingletonInstanceStructuredDataPropertyContext__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingletonInstanceStructuredDataPropertyContext__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingletonInstanceStructuredDataPropertyContext__AllNestedRestrictionElements(), theCommonPackage.getLogicalElement(), "allNestedRestrictionElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(singletonInstanceStructuredDataPropertyValueEClass, SingletonInstanceStructuredDataPropertyValue.class, "SingletonInstanceStructuredDataPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingletonInstanceStructuredDataPropertyValue_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_SingletonStructuredDataPropertyValues(), "descriptionBox", null, 1, 1, SingletonInstanceStructuredDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingletonInstanceStructuredDataPropertyValue_SingletonInstance(), this.getConceptualEntitySingletonInstance(), null, "singletonInstance", null, 1, 1, SingletonInstanceStructuredDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSingletonInstanceStructuredDataPropertyValue__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingletonInstanceStructuredDataPropertyValue__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSingletonInstanceStructuredDataPropertyValue__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(structuredDataPropertyTupleEClass, StructuredDataPropertyTuple.class, "StructuredDataPropertyTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredDataPropertyTuple_StructuredDataPropertyContext(), this.getSingletonInstanceStructuredDataPropertyContext(), this.getSingletonInstanceStructuredDataPropertyContext_StructuredPropertyTuples(), "structuredDataPropertyContext", null, 1, 1, StructuredDataPropertyTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getStructuredDataPropertyTuple__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getStructuredDataPropertyTuple__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(scalarDataPropertyValueEClass, ScalarDataPropertyValue.class, "ScalarDataPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarDataPropertyValue_StructuredDataPropertyContext(), this.getSingletonInstanceStructuredDataPropertyContext(), this.getSingletonInstanceStructuredDataPropertyContext_ScalarDataPropertyValues(), "structuredDataPropertyContext", null, 1, 1, ScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarDataPropertyValue_ScalarDataProperty(), theTerminologiesPackage.getDataRelationshipToScalar(), null, "scalarDataProperty", null, 1, 1, ScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarDataPropertyValue_ScalarPropertyValue(), theCommonPackage.getLiteralValue(), null, "scalarPropertyValue", null, 1, 1, ScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarDataPropertyValue_ValueType(), theTerminologiesPackage.getDataRange(), null, "valueType", null, 0, 1, ScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getScalarDataPropertyValue__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getScalarDataPropertyValue__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getScalarDataPropertyValue__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptualEntitySingletonInstanceEClass, ConceptualEntitySingletonInstance.class, "ConceptualEntitySingletonInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConceptualEntitySingletonInstance_Name(), theCommonPackage.getLocalName(), "name", null, 1, 1, ConceptualEntitySingletonInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__Iri(), theCommonPackage.getIRI(), "iri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__AbbrevIRI(), theEcorePackage.getEString(), "abbrevIRI", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__Name(), theCommonPackage.getLocalName(), "name", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__ConceptualEntitySingletonClassifier(), theTerminologiesPackage.getConceptualEntity(), "conceptualEntitySingletonClassifier", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptInstanceEClass, ConceptInstance.class, "ConceptInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptInstance_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ConceptInstances(), "descriptionBox", null, 1, 1, ConceptInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptInstance_SingletonConceptClassifier(), theTerminologiesPackage.getConceptKind(), null, "singletonConceptClassifier", null, 1, 1, ConceptInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptInstance__ConceptualEntitySingletonClassifier(), theTerminologiesPackage.getConceptualEntity(), "conceptualEntitySingletonClassifier", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptInstance__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptInstance__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(instanceRelationshipEnumerationRestrictionEClass, InstanceRelationshipEnumerationRestriction.class, "InstanceRelationshipEnumerationRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceRelationshipEnumerationRestriction_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_InstanceRelationshipEnumerationRestrictions(), "descriptionBox", null, 1, 1, InstanceRelationshipEnumerationRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipEnumerationRestriction_Domain(), this.getConceptualEntitySingletonInstance(), null, "domain", null, 1, 1, InstanceRelationshipEnumerationRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipEnumerationRestriction_RestrictedRelationship(), theTerminologiesPackage.getRestrictableRelationship(), null, "restrictedRelationship", null, 1, 1, InstanceRelationshipEnumerationRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipEnumerationRestriction_References(), this.getInstanceRelationshipOneOfRestriction(), this.getInstanceRelationshipOneOfRestriction_Enumeration(), "references", null, 0, -1, InstanceRelationshipEnumerationRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInstanceRelationshipEnumerationRestriction__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipEnumerationRestriction__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipEnumerationRestriction__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipEnumerationRestriction__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(instanceRelationshipOneOfRestrictionEClass, InstanceRelationshipOneOfRestriction.class, "InstanceRelationshipOneOfRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceRelationshipOneOfRestriction_Enumeration(), this.getInstanceRelationshipEnumerationRestriction(), this.getInstanceRelationshipEnumerationRestriction_References(), "enumeration", null, 1, 1, InstanceRelationshipOneOfRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipOneOfRestriction_Range(), this.getConceptualEntitySingletonInstance(), null, "range", null, 1, 1, InstanceRelationshipOneOfRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInstanceRelationshipOneOfRestriction__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipOneOfRestriction__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipOneOfRestriction__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(instanceRelationshipValueRestrictionEClass, InstanceRelationshipValueRestriction.class, "InstanceRelationshipValueRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceRelationshipValueRestriction_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_InstanceRelationshipValueRestrictions(), "descriptionBox", null, 1, 1, InstanceRelationshipValueRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipValueRestriction_Domain(), this.getConceptualEntitySingletonInstance(), null, "domain", null, 1, 1, InstanceRelationshipValueRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipValueRestriction_RestrictedRelationship(), theTerminologiesPackage.getRestrictableRelationship(), null, "restrictedRelationship", null, 1, 1, InstanceRelationshipValueRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipValueRestriction_Range(), this.getConceptualEntitySingletonInstance(), null, "range", null, 1, 1, InstanceRelationshipValueRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInstanceRelationshipValueRestriction__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipValueRestriction__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipValueRestriction__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipValueRestriction__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(instanceRelationshipExistentialRangeRestrictionEClass, InstanceRelationshipExistentialRangeRestriction.class, "InstanceRelationshipExistentialRangeRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceRelationshipExistentialRangeRestriction_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_InstanceRelationshipExistentialRangeRestrictions(), "descriptionBox", null, 1, 1, InstanceRelationshipExistentialRangeRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipExistentialRangeRestriction_Domain(), this.getConceptualEntitySingletonInstance(), null, "domain", null, 1, 1, InstanceRelationshipExistentialRangeRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipExistentialRangeRestriction_RestrictedRelationship(), theTerminologiesPackage.getRestrictableRelationship(), null, "restrictedRelationship", null, 1, 1, InstanceRelationshipExistentialRangeRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipExistentialRangeRestriction_Range(), theTerminologiesPackage.getEntity(), null, "range", null, 1, 1, InstanceRelationshipExistentialRangeRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInstanceRelationshipExistentialRangeRestriction__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipExistentialRangeRestriction__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipExistentialRangeRestriction__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipExistentialRangeRestriction__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(instanceRelationshipUniversalRangeRestrictionEClass, InstanceRelationshipUniversalRangeRestriction.class, "InstanceRelationshipUniversalRangeRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceRelationshipUniversalRangeRestriction_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_InstanceRelationshipUniversalRangeRestrictions(), "descriptionBox", null, 1, 1, InstanceRelationshipUniversalRangeRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipUniversalRangeRestriction_Domain(), this.getConceptualEntitySingletonInstance(), null, "domain", null, 1, 1, InstanceRelationshipUniversalRangeRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipUniversalRangeRestriction_RestrictedRelationship(), theTerminologiesPackage.getRestrictableRelationship(), null, "restrictedRelationship", null, 1, 1, InstanceRelationshipUniversalRangeRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceRelationshipUniversalRangeRestriction_Range(), theTerminologiesPackage.getEntity(), null, "range", null, 1, 1, InstanceRelationshipUniversalRangeRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInstanceRelationshipUniversalRangeRestriction__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipUniversalRangeRestriction__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipUniversalRangeRestriction__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceRelationshipUniversalRangeRestriction__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipInstanceEClass, ReifiedRelationshipInstance.class, "ReifiedRelationshipInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipInstance_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ReifiedRelationshipInstances(), "descriptionBox", null, 1, 1, ReifiedRelationshipInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstance_SingletonConceptualRelationshipClassifier(), theTerminologiesPackage.getConceptualRelationship(), null, "singletonConceptualRelationshipClassifier", null, 1, 1, ReifiedRelationshipInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier(), theTerminologiesPackage.getConceptualEntity(), "conceptualEntitySingletonClassifier", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstance__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstance__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipInstanceDomainEClass, ReifiedRelationshipInstanceDomain.class, "ReifiedRelationshipInstanceDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipInstanceDomain_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ReifiedRelationshipInstanceDomains(), "descriptionBox", null, 1, 1, ReifiedRelationshipInstanceDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstanceDomain_ReifiedRelationshipInstance(), this.getReifiedRelationshipInstance(), null, "reifiedRelationshipInstance", null, 1, 1, ReifiedRelationshipInstanceDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstanceDomain_Domain(), this.getConceptualEntitySingletonInstance(), null, "domain", null, 1, 1, ReifiedRelationshipInstanceDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstanceDomain__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstanceDomain__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstanceDomain__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstanceDomain__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipInstanceRangeEClass, ReifiedRelationshipInstanceRange.class, "ReifiedRelationshipInstanceRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipInstanceRange_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ReifiedRelationshipInstanceRanges(), "descriptionBox", null, 1, 1, ReifiedRelationshipInstanceRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstanceRange_ReifiedRelationshipInstance(), this.getReifiedRelationshipInstance(), null, "reifiedRelationshipInstance", null, 1, 1, ReifiedRelationshipInstanceRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstanceRange_Range(), this.getConceptualEntitySingletonInstance(), null, "range", null, 1, 1, ReifiedRelationshipInstanceRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstanceRange__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstanceRange__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstanceRange__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstanceRange__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(unreifiedRelationshipInstanceTupleEClass, UnreifiedRelationshipInstanceTuple.class, "UnreifiedRelationshipInstanceTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnreifiedRelationshipInstanceTuple_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_UnreifiedRelationshipInstanceTuples(), "descriptionBox", null, 1, 1, UnreifiedRelationshipInstanceTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnreifiedRelationshipInstanceTuple_UnreifiedRelationship(), theTerminologiesPackage.getUnreifiedRelationship(), null, "unreifiedRelationship", null, 1, 1, UnreifiedRelationshipInstanceTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnreifiedRelationshipInstanceTuple_Domain(), this.getConceptualEntitySingletonInstance(), null, "domain", null, 1, 1, UnreifiedRelationshipInstanceTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnreifiedRelationshipInstanceTuple_Range(), this.getConceptualEntitySingletonInstance(), null, "range", null, 1, 1, UnreifiedRelationshipInstanceTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getUnreifiedRelationshipInstanceTuple__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getUnreifiedRelationshipInstanceTuple__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getUnreifiedRelationshipInstanceTuple__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getUnreifiedRelationshipInstanceTuple__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(descriptionKindEEnum, DescriptionKind.class, "DescriptionKind");
		addEEnumLiteral(descriptionKindEEnum, DescriptionKind.FINAL);
		addEEnumLiteral(descriptionKindEEnum, DescriptionKind.PARTIAL);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://imce.jpl.nasa.gov/oml/Glossary
		createGlossaryAnnotations();
		// http://imce.jpl.nasa.gov/oml/Scala
		createScalaAnnotations();
		// http://imce.jpl.nasa.gov/oml/Collection
		createCollectionAnnotations();
		// http://imce.jpl.nasa.gov/oml/ImplicitExtent
		createImplicitExtentAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotSchema
		createNotSchemaAnnotations();
		// http://imce.jpl.nasa.gov/oml/Override
		createOverrideAnnotations();
		// http://imce.jpl.nasa.gov/oml/CopyConstructor
		createCopyConstructorAnnotations();
		// http://imce.jpl.nasa.gov/oml/DerivedUUID
		createDerivedUUIDAnnotations();
		// http://imce.jpl.nasa.gov/oml/IRIReference
		createIRIReferenceAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotFunctionalAPI
		createNotFunctionalAPIAnnotations();
		// http://imce.jpl.nasa.gov/oml/Factory
		createFactoryAnnotations();
		// http://imce.jpl.nasa.gov/oml/NamespaceUUID
		createNamespaceUUIDAnnotations();
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
		  (descriptionKindEEnum,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (descriptionBoxEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (descriptionBoxRelationshipEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (descriptionBoxExtendsClosedWorldDefinitionsEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (descriptionBoxRefinementEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (terminologyInstanceAssertionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (singletonInstanceScalarDataPropertyValueEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (singletonInstanceStructuredDataPropertyContextEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (singletonInstanceStructuredDataPropertyValueEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (structuredDataPropertyTupleEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (scalarDataPropertyValueEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (conceptualEntitySingletonInstanceEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (conceptInstanceEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipEnumerationRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipOneOfRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipValueRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipExistentialRangeRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipUniversalRangeRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (reifiedRelationshipInstanceEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (reifiedRelationshipInstanceDomainEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (reifiedRelationshipInstanceRangeEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (unreifiedRelationshipInstanceTupleEClass,
		   source,
		   new String[] {
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
		  (getDescriptionBox__ModuleEdges(),
		   source,
		   new String[] {
			   "code", "extent.lookupDescriptionBoxRefinements(this) ++ extent.lookupClosedWorldDefinitions(this)"
		   });
		addAnnotation
		  (getDescriptionBox__ModuleElements(),
		   source,
		   new String[] {
			   "code", "extent.lookupConceptInstances(this) ++\n\t\textent.lookupReifiedRelationshipInstances(this) ++\n\t\textent.lookupInstanceRelationshipEnumerationRestrictions(this) ++\n\t\textent.lookupInstanceRelationshipValueRestrictions(this) ++\n\t\textent.lookupInstanceRelationshipExistentialRangeRestrictions(this) ++\n\t\textent.lookupInstanceRelationshipUniversalRangeRestrictions(this) ++\n\t\textent.lookupReifiedRelationshipInstanceDomains(this) ++\n\t\textent.lookupReifiedRelationshipInstanceRanges(this) ++\n\t\textent.lookupUnreifiedRelationshipInstanceTuples(this) ++\n\t\textent.lookupSingletonScalarDataPropertyValues(this) ++\n\t\textent.lookupSingletonStructuredDataPropertyValues(this)"
		   });
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfDescriptionBoxExtendsClosedWorldDefinitions.get(this)"
		   });
		addAnnotation
		  (getDescriptionBoxRefinement__DescriptionDomain(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfDescriptionBoxRefinement.get(this)"
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfSingletonInstanceScalarDataPropertyValue.get(this)"
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext__AllNestedRestrictionElements(),
		   source,
		   new String[] {
			   "code", "extent.lookupStructuredPropertyTuples(this).flatMap{ r => scala.collection.immutable.Set.empty[resolver.api.LogicalElement] + r ++ r.allNestedRestrictionElements() } ++\n\t\textent.lookupScalarDataPropertyValues(this)"
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfSingletonInstanceStructuredDataPropertyValue.get(this)"
		   });
		addAnnotation
		  (getStructuredDataPropertyTuple__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.singletonInstanceStructuredDataPropertyContextOfStructuredDataPropertyTuple.get(this).flatMap(_.descriptionBox())"
		   });
		addAnnotation
		  (getScalarDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.singletonInstanceStructuredDataPropertyContextOfScalarDataPropertyValue.get(this).flatMap(_.descriptionBox())"
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__Iri(),
		   source,
		   new String[] {
			   "code", "descriptionBox().flatMap(_.iri())"
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__AbbrevIRI(),
		   source,
		   new String[] {
			   "code", "descriptionBox().map(dbox => dbox.nsPrefix+\":\"+name)"
		   });
		addAnnotation
		  (getConceptInstance__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfConceptInstance.get(this)"
		   });
		addAnnotation
		  (getConceptInstance__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfInstanceRelationshipEnumerationRestriction.get(this)"
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "extent.instanceRelationshipEnumerationRestrictionOfInstanceRelationshipOneOfRestriction.collect {\n\t\t\t\tcase (oneOf, enumRestriction) if enumRestriction == this => oneOf\n\t\t\t}.to[scala.collection.immutable.Set]"
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__ModuleContext(),
		   source,
		   new String[] {
			   "code", "extent.instanceRelationshipEnumerationRestrictionOfInstanceRelationshipOneOfRestriction.get(this).flatMap(_.descriptionBox())"
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfInstanceRelationshipValueRestriction.get(this)"
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfInstanceRelationshipExistentialRangeRestriction.get(this)"
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfInstanceRelationshipUniversalRangeRestriction.get(this)"
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfReifiedRelationshipInstance.get(this)"
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfReifiedRelationshipInstanceDomain.get(this)"
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfReifiedRelationshipInstanceRange.get(this)"
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__DescriptionBox(),
		   source,
		   new String[] {
			   "code", "extent.descriptionBoxOfUnreifiedRelationshipInstanceTuple.get(this)"
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__AllNestedElements(),
		   source,
		   new String[] {
			   "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
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
		  (getDescriptionBox__ModuleEdges(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox__ModuleElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_DescriptionBoxRefinements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_ClosedWorldDefinitions(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_ConceptInstances(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstances(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_InstanceRelationshipEnumerationRestrictions(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_InstanceRelationshipValueRestrictions(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_InstanceRelationshipExistentialRangeRestrictions(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_InstanceRelationshipUniversalRangeRestrictions(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstanceDomains(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstanceRanges(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_UnreifiedRelationshipInstanceTuples(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_SingletonScalarDataPropertyValues(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getDescriptionBox_SingletonStructuredDataPropertyValues(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext__AllNestedRestrictionElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext_StructuredPropertyTuples(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext_ScalarDataPropertyValues(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getConceptInstance__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction_References(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__AllNestedElements(),
		   source,
		   new String[] {
			   "kind", "Set"
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
		  (getDescriptionBox__ModuleEdges(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox__ModuleElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRelationship__DescriptionDomain(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRelationship__SourceModule(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__TargetModule(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement__DescriptionDomain(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement__TargetModule(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext__AllNestedRestrictionElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getStructuredDataPropertyTuple__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getScalarDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getScalarDataPropertyValue__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__Iri(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__AbbrevIRI(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptInstance__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptInstance__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__AllNestedElements(),
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
		  (getDescriptionBox__ModuleEdges(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox__ModuleElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRelationship__DescriptionDomain(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRelationship__SourceModule(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__TargetModule(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement__DescriptionDomain(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement__TargetModule(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyContext__AllNestedRestrictionElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getStructuredDataPropertyTuple__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getStructuredDataPropertyTuple__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getScalarDataPropertyValue__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getScalarDataPropertyValue__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getScalarDataPropertyValue__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__Iri(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__AbbrevIRI(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__Name(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__ConceptualEntitySingletonClassifier(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptInstance__ConceptualEntitySingletonClassifier(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptInstance__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptInstance__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__AllNestedElements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__ModuleContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__AllNestedElements(),
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
		  (getDescriptionBox__ModuleEdges(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getStructuredDataPropertyTuple__DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__Iri(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__AbbrevIRI(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance_Name(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptInstance__ConceptualEntitySingletonClassifier(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier(),
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/CopyConstructor</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCopyConstructorAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/CopyConstructor";
		addAnnotation
		  (getDescriptionBox_DescriptionBoxRefinements(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_ClosedWorldDefinitions(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_ConceptInstances(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstances(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_InstanceRelationshipEnumerationRestrictions(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_InstanceRelationshipValueRestrictions(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_InstanceRelationshipExistentialRangeRestrictions(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_InstanceRelationshipUniversalRangeRestrictions(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstanceDomains(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstanceRanges(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_UnreifiedRelationshipInstanceTuples(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_SingletonScalarDataPropertyValues(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBox_SingletonStructuredDataPropertyValues(),
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/DerivedUUID</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDerivedUUIDAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/DerivedUUID";
		addAnnotation
		  (descriptionBoxExtendsClosedWorldDefinitionsEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (descriptionBoxRefinementEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (singletonInstanceScalarDataPropertyValueEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (singletonInstanceStructuredDataPropertyContextEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (singletonInstanceStructuredDataPropertyValueEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (structuredDataPropertyTupleEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (scalarDataPropertyValueEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipEnumerationRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipOneOfRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipValueRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipExistentialRangeRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (instanceRelationshipUniversalRangeRestrictionEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (reifiedRelationshipInstanceDomainEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (reifiedRelationshipInstanceRangeEClass,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (unreifiedRelationshipInstanceTupleEClass,
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/IRIReference</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createIRIReferenceAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/IRIReference";
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__TargetModule(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement__TargetModule(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement_RefinedDescriptionBox(),
		   source,
		   new String[] {
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
		  (getDescriptionBoxExtendsClosedWorldDefinitions__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getStructuredDataPropertyTuple__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getScalarDataPropertyValue__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__Name(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptualEntitySingletonInstance__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange__Uuid(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple__Uuid(),
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Factory</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createFactoryAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Factory";
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getDescriptionBoxRefinement_RefiningDescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceScalarDataPropertyValue_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSingletonInstanceStructuredDataPropertyValue_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getStructuredDataPropertyTuple_StructuredDataPropertyContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getScalarDataPropertyValue_StructuredDataPropertyContext(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getConceptInstance_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipEnumerationRestriction_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipOneOfRestriction_Enumeration(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipValueRestriction_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipExistentialRangeRestriction_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getInstanceRelationshipUniversalRangeRestriction_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstance_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceDomain_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getReifiedRelationshipInstanceRange_DescriptionBox(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getUnreifiedRelationshipInstanceTuple_DescriptionBox(),
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
		  (conceptualEntitySingletonInstanceEClass,
		   source,
		   new String[] {
			   "namespace", "descriptionBox",
			   "factors", "name"
		   });
	}

} //DescriptionsPackageImpl
