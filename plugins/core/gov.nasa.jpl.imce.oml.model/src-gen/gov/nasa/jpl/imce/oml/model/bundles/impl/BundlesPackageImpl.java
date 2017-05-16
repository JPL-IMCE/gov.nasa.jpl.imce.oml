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
package gov.nasa.jpl.imce.oml.model.bundles.impl;

import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesFactory;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction;
import gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class BundlesPackageImpl extends EPackageImpl implements BundlesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBundleStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBundleAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptTreeDisjunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass disjointUnionOfConceptsAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificDisjointConceptAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anonymousConceptUnionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootConceptTaxonomyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundledTerminologyAxiomEClass = null;

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
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BundlesPackageImpl() {
		super(eNS_URI, BundlesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BundlesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BundlesPackage init() {
		if (isInited) return (BundlesPackage)EPackage.Registry.INSTANCE.getEPackage(BundlesPackage.eNS_URI);

		// Obtain or create and register package
		BundlesPackageImpl theBundlesPackage = (BundlesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BundlesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BundlesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TerminologiesPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBundlesPackage.createPackageContents();

		// Initialize created meta-data
		theBundlesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBundlesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BundlesPackage.eNS_URI, theBundlesPackage);
		return theBundlesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBundle() {
		return bundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBundle_BundleAxioms() {
		return (EReference)bundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBundle_BundleStatements() {
		return (EReference)bundleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundle__ModuleEdges() {
		return bundleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBundleStatement() {
		return terminologyBundleStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBundleStatement_Bundle() {
		return (EReference)terminologyBundleStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBundleAxiom() {
		return terminologyBundleAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBundleAxiom_Bundle() {
		return (EReference)terminologyBundleAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptTreeDisjunction() {
		return conceptTreeDisjunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptTreeDisjunction_Disjunctions() {
		return (EReference)conceptTreeDisjunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptTreeDisjunction__BundleContainer() {
		return conceptTreeDisjunctionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisjointUnionOfConceptsAxiom() {
		return disjointUnionOfConceptsAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent() {
		return (EReference)disjointUnionOfConceptsAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDisjointUnionOfConceptsAxiom__ConceptTreeDisjunctionParent() {
		return disjointUnionOfConceptsAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificDisjointConceptAxiom() {
		return specificDisjointConceptAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificDisjointConceptAxiom_DisjointLeaf() {
		return (EReference)specificDisjointConceptAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSpecificDisjointConceptAxiom__Uuid() {
		return specificDisjointConceptAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnonymousConceptUnionAxiom() {
		return anonymousConceptUnionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnonymousConceptUnionAxiom_Name() {
		return (EAttribute)anonymousConceptUnionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnonymousConceptUnionAxiom__Uuid() {
		return anonymousConceptUnionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnonymousConceptUnionAxiom__BundleContainer() {
		return anonymousConceptUnionAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootConceptTaxonomyAxiom() {
		return rootConceptTaxonomyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootConceptTaxonomyAxiom_Root() {
		return (EReference)rootConceptTaxonomyAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRootConceptTaxonomyAxiom__Uuid() {
		return rootConceptTaxonomyAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRootConceptTaxonomyAxiom__BundleContainer() {
		return rootConceptTaxonomyAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBundledTerminologyAxiom() {
		return bundledTerminologyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBundledTerminologyAxiom_BundledTerminology() {
		return (EReference)bundledTerminologyAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundledTerminologyAxiom__Source() {
		return bundledTerminologyAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundledTerminologyAxiom__Target() {
		return bundledTerminologyAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundledTerminologyAxiom__Uuid() {
		return bundledTerminologyAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundlesFactory getBundlesFactory() {
		return (BundlesFactory)getEFactoryInstance();
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
		bundleEClass = createEClass(BUNDLE);
		createEReference(bundleEClass, BUNDLE__BUNDLE_AXIOMS);
		createEReference(bundleEClass, BUNDLE__BUNDLE_STATEMENTS);
		createEOperation(bundleEClass, BUNDLE___MODULE_EDGES);

		terminologyBundleStatementEClass = createEClass(TERMINOLOGY_BUNDLE_STATEMENT);
		createEReference(terminologyBundleStatementEClass, TERMINOLOGY_BUNDLE_STATEMENT__BUNDLE);

		terminologyBundleAxiomEClass = createEClass(TERMINOLOGY_BUNDLE_AXIOM);
		createEReference(terminologyBundleAxiomEClass, TERMINOLOGY_BUNDLE_AXIOM__BUNDLE);

		conceptTreeDisjunctionEClass = createEClass(CONCEPT_TREE_DISJUNCTION);
		createEReference(conceptTreeDisjunctionEClass, CONCEPT_TREE_DISJUNCTION__DISJUNCTIONS);
		createEOperation(conceptTreeDisjunctionEClass, CONCEPT_TREE_DISJUNCTION___BUNDLE_CONTAINER);

		disjointUnionOfConceptsAxiomEClass = createEClass(DISJOINT_UNION_OF_CONCEPTS_AXIOM);
		createEReference(disjointUnionOfConceptsAxiomEClass, DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT);
		createEOperation(disjointUnionOfConceptsAxiomEClass, DISJOINT_UNION_OF_CONCEPTS_AXIOM___CONCEPT_TREE_DISJUNCTION_PARENT);

		specificDisjointConceptAxiomEClass = createEClass(SPECIFIC_DISJOINT_CONCEPT_AXIOM);
		createEReference(specificDisjointConceptAxiomEClass, SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF);
		createEOperation(specificDisjointConceptAxiomEClass, SPECIFIC_DISJOINT_CONCEPT_AXIOM___UUID);

		anonymousConceptUnionAxiomEClass = createEClass(ANONYMOUS_CONCEPT_UNION_AXIOM);
		createEAttribute(anonymousConceptUnionAxiomEClass, ANONYMOUS_CONCEPT_UNION_AXIOM__NAME);
		createEOperation(anonymousConceptUnionAxiomEClass, ANONYMOUS_CONCEPT_UNION_AXIOM___UUID);
		createEOperation(anonymousConceptUnionAxiomEClass, ANONYMOUS_CONCEPT_UNION_AXIOM___BUNDLE_CONTAINER);

		rootConceptTaxonomyAxiomEClass = createEClass(ROOT_CONCEPT_TAXONOMY_AXIOM);
		createEReference(rootConceptTaxonomyAxiomEClass, ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT);
		createEOperation(rootConceptTaxonomyAxiomEClass, ROOT_CONCEPT_TAXONOMY_AXIOM___UUID);
		createEOperation(rootConceptTaxonomyAxiomEClass, ROOT_CONCEPT_TAXONOMY_AXIOM___BUNDLE_CONTAINER);

		bundledTerminologyAxiomEClass = createEClass(BUNDLED_TERMINOLOGY_AXIOM);
		createEReference(bundledTerminologyAxiomEClass, BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY);
		createEOperation(bundledTerminologyAxiomEClass, BUNDLED_TERMINOLOGY_AXIOM___SOURCE);
		createEOperation(bundledTerminologyAxiomEClass, BUNDLED_TERMINOLOGY_AXIOM___TARGET);
		createEOperation(bundledTerminologyAxiomEClass, BUNDLED_TERMINOLOGY_AXIOM___UUID);
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
		TerminologiesPackage theTerminologiesPackage = (TerminologiesPackage)EPackage.Registry.INSTANCE.getEPackage(TerminologiesPackage.eNS_URI);
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bundleEClass.getESuperTypes().add(theTerminologiesPackage.getTerminologyBox());
		terminologyBundleStatementEClass.getESuperTypes().add(theCommonPackage.getModuleElement());
		terminologyBundleAxiomEClass.getESuperTypes().add(theTerminologiesPackage.getTerminologyAxiom());
		conceptTreeDisjunctionEClass.getESuperTypes().add(theCommonPackage.getElement());
		disjointUnionOfConceptsAxiomEClass.getESuperTypes().add(theCommonPackage.getElement());
		specificDisjointConceptAxiomEClass.getESuperTypes().add(this.getDisjointUnionOfConceptsAxiom());
		specificDisjointConceptAxiomEClass.getESuperTypes().add(theCommonPackage.getElement());
		anonymousConceptUnionAxiomEClass.getESuperTypes().add(this.getDisjointUnionOfConceptsAxiom());
		anonymousConceptUnionAxiomEClass.getESuperTypes().add(this.getConceptTreeDisjunction());
		anonymousConceptUnionAxiomEClass.getESuperTypes().add(theCommonPackage.getElement());
		rootConceptTaxonomyAxiomEClass.getESuperTypes().add(this.getTerminologyBundleStatement());
		rootConceptTaxonomyAxiomEClass.getESuperTypes().add(this.getConceptTreeDisjunction());
		bundledTerminologyAxiomEClass.getESuperTypes().add(this.getTerminologyBundleAxiom());

		// Initialize classes, features, and operations; add parameters
		initEClass(bundleEClass, Bundle.class, "Bundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBundle_BundleAxioms(), this.getTerminologyBundleAxiom(), this.getTerminologyBundleAxiom_Bundle(), "bundleAxioms", null, 0, -1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBundle_BundleStatements(), this.getTerminologyBundleStatement(), this.getTerminologyBundleStatement_Bundle(), "bundleStatements", null, 0, -1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBundle__ModuleEdges(), theCommonPackage.getModuleEdge(), "moduleEdges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyBundleStatementEClass, TerminologyBundleStatement.class, "TerminologyBundleStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBundleStatement_Bundle(), this.getBundle(), this.getBundle_BundleStatements(), "bundle", null, 1, 1, TerminologyBundleStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminologyBundleAxiomEClass, TerminologyBundleAxiom.class, "TerminologyBundleAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBundleAxiom_Bundle(), this.getBundle(), this.getBundle_BundleAxioms(), "bundle", null, 1, 1, TerminologyBundleAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptTreeDisjunctionEClass, ConceptTreeDisjunction.class, "ConceptTreeDisjunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptTreeDisjunction_Disjunctions(), this.getDisjointUnionOfConceptsAxiom(), this.getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent(), "disjunctions", null, 0, -1, ConceptTreeDisjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptTreeDisjunction__BundleContainer(), this.getBundle(), "bundleContainer", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(disjointUnionOfConceptsAxiomEClass, DisjointUnionOfConceptsAxiom.class, "DisjointUnionOfConceptsAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent(), this.getConceptTreeDisjunction(), this.getConceptTreeDisjunction_Disjunctions(), "disjointTaxonomyParent", null, 1, 1, DisjointUnionOfConceptsAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDisjointUnionOfConceptsAxiom__ConceptTreeDisjunctionParent(), this.getConceptTreeDisjunction(), "conceptTreeDisjunctionParent", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(specificDisjointConceptAxiomEClass, SpecificDisjointConceptAxiom.class, "SpecificDisjointConceptAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificDisjointConceptAxiom_DisjointLeaf(), theTerminologiesPackage.getConcept(), null, "disjointLeaf", null, 1, 1, SpecificDisjointConceptAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSpecificDisjointConceptAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(anonymousConceptUnionAxiomEClass, AnonymousConceptUnionAxiom.class, "AnonymousConceptUnionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnonymousConceptUnionAxiom_Name(), theCommonPackage.getLocalName(), "name", null, 1, 1, AnonymousConceptUnionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAnonymousConceptUnionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAnonymousConceptUnionAxiom__BundleContainer(), this.getBundle(), "bundleContainer", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(rootConceptTaxonomyAxiomEClass, RootConceptTaxonomyAxiom.class, "RootConceptTaxonomyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootConceptTaxonomyAxiom_Root(), theTerminologiesPackage.getConcept(), null, "root", null, 1, 1, RootConceptTaxonomyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRootConceptTaxonomyAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRootConceptTaxonomyAxiom__BundleContainer(), this.getBundle(), "bundleContainer", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(bundledTerminologyAxiomEClass, BundledTerminologyAxiom.class, "BundledTerminologyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBundledTerminologyAxiom_BundledTerminology(), theTerminologiesPackage.getTerminologyBox(), null, "bundledTerminology", null, 1, 1, BundledTerminologyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBundledTerminologyAxiom__Source(), theTerminologiesPackage.getTerminologyBox(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBundledTerminologyAxiom__Target(), theTerminologiesPackage.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBundledTerminologyAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://imce.jpl.nasa.gov/oml/Glossary
		createGlossaryAnnotations();
		// http://imce.jpl.nasa.gov/oml/Scala
		createScalaAnnotations();
		// http://imce.jpl.nasa.gov/oml/ImplicitExtent
		createImplicitExtentAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotSchema
		createNotSchemaAnnotations();
		// http://imce.jpl.nasa.gov/oml/Override
		createOverrideAnnotations();
		// http://imce.jpl.nasa.gov/oml/Collection
		createCollectionAnnotations();
		// http://imce.jpl.nasa.gov/oml/CopyConstructor
		createCopyConstructorAnnotations();
		// http://imce.jpl.nasa.gov/oml/DerivedUUID
		createDerivedUUIDAnnotations();
		// http://imce.jpl.nasa.gov/oml/FunctionalInterface
		createFunctionalInterfaceAnnotations();
		// http://imce.jpl.nasa.gov/oml/OverrideVal
		createOverrideValAnnotations();
		// http://imce.jpl.nasa.gov/oml/NamespaceUUID
		createNamespaceUUIDAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotFunctionalAPI
		createNotFunctionalAPIAnnotations();
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
		  (bundleEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBundleStatementEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBundleAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptTreeDisjunctionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (disjointUnionOfConceptsAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (specificDisjointConceptAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (anonymousConceptUnionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (rootConceptTaxonomyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (bundledTerminologyAxiomEClass, 
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
		  (getBundle__ModuleEdges(), 
		   source, 
		   new String[] {
			 "code", "boxAxioms ++ bundleAxioms"
		   });	
		addAnnotation
		  (getDisjointUnionOfConceptsAxiom__ConceptTreeDisjunctionParent(), 
		   source, 
		   new String[] {
			 "code", "extent.conceptTreeDisjunctionOfDisjointUnionOfConceptsAxiom.get(this)"
		   });	
		addAnnotation
		  (getAnonymousConceptUnionAxiom__BundleContainer(), 
		   source, 
		   new String[] {
			 "code", "conceptTreeDisjunctionParent().flatMap(_.bundleContainer())"
		   });	
		addAnnotation
		  (getRootConceptTaxonomyAxiom__BundleContainer(), 
		   source, 
		   new String[] {
			 "code", "extent.bundleOfTerminologyBundleStatement.get(this)"
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
			 "code", "extent.bundleOfTerminologyBundleAxiom.get(this)"
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
		  (getBundle__ModuleEdges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptTreeDisjunction__BundleContainer(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDisjointUnionOfConceptsAxiom__ConceptTreeDisjunctionParent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnonymousConceptUnionAxiom__BundleContainer(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRootConceptTaxonomyAxiom__BundleContainer(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Target(), 
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
		  (getBundle__ModuleEdges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle_BundleAxioms(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle_BundleStatements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptTreeDisjunction__BundleContainer(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDisjointUnionOfConceptsAxiom__ConceptTreeDisjunctionParent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnonymousConceptUnionAxiom__BundleContainer(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRootConceptTaxonomyAxiom__BundleContainer(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Uuid(), 
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
		  (getBundle__ModuleEdges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnonymousConceptUnionAxiom__BundleContainer(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRootConceptTaxonomyAxiom__BundleContainer(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
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
		  (getBundle_BundleAxioms(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getBundle_BundleStatements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getConceptTreeDisjunction_Disjunctions(), 
		   source, 
		   new String[] {
			 "kind", "Set"
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
		  (getTerminologyBundleStatement_Bundle(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBundleAxiom_Bundle(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom_BundledTerminology(), 
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
		  (specificDisjointConceptAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (rootConceptTaxonomyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (bundledTerminologyAxiomEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/FunctionalInterface</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createFunctionalInterfaceAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/FunctionalInterface";	
		addAnnotation
		  (getSpecificDisjointConceptAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnonymousConceptUnionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRootConceptTaxonomyAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/OverrideVal</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOverrideValAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/OverrideVal";	
		addAnnotation
		  (getSpecificDisjointConceptAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnonymousConceptUnionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRootConceptTaxonomyAxiom__Uuid(), 
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
		  (anonymousConceptUnionAxiomEClass, 
		   source, 
		   new String[] {
			 "namespace", "disjointTaxonomyParent",
			 "factors", "name"
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
		  (getBundledTerminologyAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });
	}

} //BundlesPackageImpl
