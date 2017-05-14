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
package gov.nasa.jpl.imce.oml.model.graphs.impl;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;

import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphsPackageImpl extends EPackageImpl implements GraphsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptDesignationTerminologyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyNestingAxiomEClass = null;

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
	 * @see gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphsPackageImpl() {
		super(eNS_URI, GraphsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraphsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphsPackage init() {
		if (isInited) return (GraphsPackage)EPackage.Registry.INSTANCE.getEPackage(GraphsPackage.eNS_URI);

		// Obtain or create and register package
		GraphsPackageImpl theGraphsPackage = (GraphsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraphsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraphsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TerminologiesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraphsPackage.createPackageContents();

		// Initialize created meta-data
		theGraphsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphsPackage.eNS_URI, theGraphsPackage);
		return theGraphsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyGraph() {
		return terminologyGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyGraph__ModuleEdges() {
		return terminologyGraphEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptDesignationTerminologyAxiom() {
		return conceptDesignationTerminologyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptDesignationTerminologyAxiom_DesignatedTerminology() {
		return (EReference)conceptDesignationTerminologyAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptDesignationTerminologyAxiom_DesignatedConcept() {
		return (EReference)conceptDesignationTerminologyAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph() {
		return conceptDesignationTerminologyAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptDesignationTerminologyAxiom__Source() {
		return conceptDesignationTerminologyAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptDesignationTerminologyAxiom__Target() {
		return conceptDesignationTerminologyAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptDesignationTerminologyAxiom__Uuid() {
		return conceptDesignationTerminologyAxiomEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyNestingAxiom() {
		return terminologyNestingAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyNestingAxiom_NestingTerminology() {
		return (EReference)terminologyNestingAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyNestingAxiom_NestingContext() {
		return (EReference)terminologyNestingAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyNestingAxiom__NestedTerminology() {
		return terminologyNestingAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyNestingAxiom__Source() {
		return terminologyNestingAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyNestingAxiom__Target() {
		return terminologyNestingAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyNestingAxiom__Uuid() {
		return terminologyNestingAxiomEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphsFactory getGraphsFactory() {
		return (GraphsFactory)getEFactoryInstance();
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
		terminologyGraphEClass = createEClass(TERMINOLOGY_GRAPH);
		createEOperation(terminologyGraphEClass, TERMINOLOGY_GRAPH___MODULE_EDGES);

		conceptDesignationTerminologyAxiomEClass = createEClass(CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM);
		createEReference(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY);
		createEReference(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT);
		createEOperation(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___DESIGNATION_TERMINOLOGY_GRAPH);
		createEOperation(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___SOURCE);
		createEOperation(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___TARGET);
		createEOperation(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___UUID);

		terminologyNestingAxiomEClass = createEClass(TERMINOLOGY_NESTING_AXIOM);
		createEReference(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY);
		createEReference(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT);
		createEOperation(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM___NESTED_TERMINOLOGY);
		createEOperation(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM___SOURCE);
		createEOperation(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM___TARGET);
		createEOperation(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM___UUID);
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
		terminologyGraphEClass.getESuperTypes().add(theTerminologiesPackage.getTerminologyBox());
		conceptDesignationTerminologyAxiomEClass.getESuperTypes().add(theTerminologiesPackage.getTerminologyBoxAxiom());
		terminologyNestingAxiomEClass.getESuperTypes().add(theTerminologiesPackage.getTerminologyBoxAxiom());

		// Initialize classes, features, and operations; add parameters
		initEClass(terminologyGraphEClass, TerminologyGraph.class, "TerminologyGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTerminologyGraph__ModuleEdges(), theCommonPackage.getModuleEdge(), "moduleEdges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptDesignationTerminologyAxiomEClass, ConceptDesignationTerminologyAxiom.class, "ConceptDesignationTerminologyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptDesignationTerminologyAxiom_DesignatedTerminology(), theTerminologiesPackage.getTerminologyBox(), null, "designatedTerminology", null, 1, 1, ConceptDesignationTerminologyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptDesignationTerminologyAxiom_DesignatedConcept(), theTerminologiesPackage.getConcept(), null, "designatedConcept", null, 1, 1, ConceptDesignationTerminologyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph(), this.getTerminologyGraph(), "designationTerminologyGraph", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptDesignationTerminologyAxiom__Source(), theTerminologiesPackage.getTerminologyBox(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptDesignationTerminologyAxiom__Target(), theTerminologiesPackage.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptDesignationTerminologyAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyNestingAxiomEClass, TerminologyNestingAxiom.class, "TerminologyNestingAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyNestingAxiom_NestingTerminology(), theTerminologiesPackage.getTerminologyBox(), null, "nestingTerminology", null, 1, 1, TerminologyNestingAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyNestingAxiom_NestingContext(), theTerminologiesPackage.getConcept(), null, "nestingContext", null, 1, 1, TerminologyNestingAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerminologyNestingAxiom__NestedTerminology(), this.getTerminologyGraph(), "nestedTerminology", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyNestingAxiom__Source(), theTerminologiesPackage.getTerminologyBox(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyNestingAxiom__Target(), theTerminologiesPackage.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyNestingAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

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
		// http://imce.jpl.nasa.gov/oml/DerivedUUID
		createDerivedUUIDAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotFunctionalAPI
		createNotFunctionalAPIAnnotations();
		// http://imce.jpl.nasa.gov/oml/CopyConstructor
		createCopyConstructorAnnotations();
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
		  (terminologyGraphEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptDesignationTerminologyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyNestingAxiomEClass, 
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
		  (getTerminologyGraph__ModuleEdges(), 
		   source, 
		   new String[] {
			 "code", "boxAxioms"
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph(), 
		   source, 
		   new String[] {
			 "code", "extent.terminologyBoxOfTerminologyBoxAxiom.get(this) match {\n      case scala.Some(g: resolver.api.TerminologyGraph) => scala.Some(g)\n      case _ => scala.None\n    }"
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
			 "code", "designationTerminologyGraph()"
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__NestedTerminology(), 
		   source, 
		   new String[] {
			 "code", "extent.terminologyBoxOfTerminologyBoxAxiom.get(this) match {\n      case scala.Some(g: resolver.api.TerminologyGraph) => scala.Some(g)\n      case _ => scala.None\n    }"
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Source(), 
		   source, 
		   new String[] {
			 "code", "nestedTerminology()"
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
		  (getTerminologyGraph__ModuleEdges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__NestedTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Target(), 
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
		  (getTerminologyGraph__ModuleEdges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__NestedTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Uuid(), 
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
		  (getTerminologyGraph__ModuleEdges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Target(), 
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
		  (conceptDesignationTerminologyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyNestingAxiomEClass, 
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
		  (getConceptDesignationTerminologyAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Uuid(), 
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
		  (getTerminologyNestingAxiom_NestingTerminology(), 
		   source, 
		   new String[] {
		   });
	}

} //GraphsPackageImpl
