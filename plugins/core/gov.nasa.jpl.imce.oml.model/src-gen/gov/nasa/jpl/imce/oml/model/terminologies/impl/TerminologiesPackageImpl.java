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
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;

import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipDomain;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromEntity;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipFromStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipRange;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.Datatype;
import gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TermAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnaryTermKind;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;

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
public class TerminologiesPackageImpl extends EPackageImpl implements TerminologiesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBoxStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBoxAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyExtensionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryTermKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directedBinaryRelationshipKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptualEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unreifiedRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass datatypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipFromEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipFromStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipToScalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipToStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityStructuredDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityExistentialRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityUniversalRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aspectSpecializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptSpecializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipSpecializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyExistentialRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyUniversalRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyParticularRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restrictedDataRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iriScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plainLiteralScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synonymScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarOneOfRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarOneOfLiteralAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum terminologyKindEEnum = null;

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
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TerminologiesPackageImpl() {
		super(eNS_URI, TerminologiesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TerminologiesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TerminologiesPackage init() {
		if (isInited) return (TerminologiesPackage)EPackage.Registry.INSTANCE.getEPackage(TerminologiesPackage.eNS_URI);

		// Obtain or create and register package
		TerminologiesPackageImpl theTerminologiesPackage = (TerminologiesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TerminologiesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TerminologiesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTerminologiesPackage.createPackageContents();

		// Initialize created meta-data
		theTerminologiesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTerminologiesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TerminologiesPackage.eNS_URI, theTerminologiesPackage);
		return theTerminologiesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBox() {
		return terminologyBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerminologyBox_Kind() {
		return (EAttribute)terminologyBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBox_BoxAxioms() {
		return (EReference)terminologyBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBox_BoxStatements() {
		return (EReference)terminologyBoxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBoxStatement() {
		return terminologyBoxStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBoxStatement_Tbox() {
		return (EReference)terminologyBoxStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyAxiom() {
		return terminologyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyAxiom__Source() {
		return terminologyAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyAxiom__SourceModule() {
		return terminologyAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyAxiom__Target() {
		return terminologyAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyAxiom__TargetModule() {
		return terminologyAxiomEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBoxAxiom() {
		return terminologyBoxAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBoxAxiom_Tbox() {
		return (EReference)terminologyBoxAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyExtensionAxiom() {
		return terminologyExtensionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyExtensionAxiom_ExtendedTerminology() {
		return (EReference)terminologyExtensionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyExtensionAxiom__ExtendingTerminology() {
		return terminologyExtensionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyExtensionAxiom__Source() {
		return terminologyExtensionAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyExtensionAxiom__Target() {
		return terminologyExtensionAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyExtensionAxiom__Uuid() {
		return terminologyExtensionAxiomEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerm_Name() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerm__Iri() {
		return termEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerm__AbbrevIRI() {
		return termEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerm__Name() {
		return termEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerm__Uuid() {
		return termEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryTermKind() {
		return unaryTermKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectedBinaryRelationshipKind() {
		return directedBinaryRelationshipKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDirectedBinaryRelationshipKind__RelationDomain() {
		return directedBinaryRelationshipKindEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDirectedBinaryRelationshipKind__RelationRange() {
		return directedBinaryRelationshipKindEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptualEntity() {
		return conceptualEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAspect() {
		return aspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcept() {
		return conceptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityRelationship() {
		return entityRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRelationship_Source() {
		return (EReference)entityRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRelationship_Target() {
		return (EReference)entityRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsFunctional() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsInverseFunctional() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsEssential() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsInverseEssential() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsSymmetric() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsAsymmetric() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsReflexive() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsIrreflexive() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsTransitive() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityRelationship__RelationDomain() {
		return entityRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityRelationship__RelationRange() {
		return entityRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationship() {
		return reifiedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReifiedRelationship_UnreifiedPropertyName() {
		return (EAttribute)reifiedRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReifiedRelationship_UnreifiedInversePropertyName() {
		return (EAttribute)reifiedRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnreifiedRelationship() {
		return unreifiedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatatype() {
		return datatypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRange() {
		return dataRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalar() {
		return scalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationship() {
		return dataRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataRelationship__Source() {
		return dataRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataRelationship__RelationDomain() {
		return dataRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataRelationship__Target() {
		return dataRelationshipEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataRelationship__RelationRange() {
		return dataRelationshipEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipDomain() {
		return dataRelationshipDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipFromEntity() {
		return dataRelationshipFromEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataRelationshipFromEntity_Domain() {
		return (EReference)dataRelationshipFromEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataRelationshipFromEntity_IsIdentityCriteria() {
		return (EAttribute)dataRelationshipFromEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipFromStructure() {
		return dataRelationshipFromStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataRelationshipFromStructure_Domain() {
		return (EReference)dataRelationshipFromStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipRange() {
		return dataRelationshipRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipToScalar() {
		return dataRelationshipToScalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataRelationshipToScalar_Range() {
		return (EReference)dataRelationshipToScalarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipToStructure() {
		return dataRelationshipToStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataRelationshipToStructure_Range() {
		return (EReference)dataRelationshipToStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityStructuredDataProperty() {
		return entityStructuredDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityStructuredDataProperty__Uuid() {
		return entityStructuredDataPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityStructuredDataProperty__Source() {
		return entityStructuredDataPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityStructuredDataProperty__Target() {
		return entityStructuredDataPropertyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataProperty() {
		return entityScalarDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityScalarDataProperty__Uuid() {
		return entityScalarDataPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityScalarDataProperty__Source() {
		return entityScalarDataPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityScalarDataProperty__Target() {
		return entityScalarDataPropertyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuredDataProperty() {
		return structuredDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStructuredDataProperty__Uuid() {
		return structuredDataPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStructuredDataProperty__Source() {
		return structuredDataPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStructuredDataProperty__Target() {
		return structuredDataPropertyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarDataProperty() {
		return scalarDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarDataProperty__Uuid() {
		return scalarDataPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarDataProperty__Source() {
		return scalarDataPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarDataProperty__Target() {
		return scalarDataPropertyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructure() {
		return structureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTermAxiom() {
		return termAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityRestrictionAxiom() {
		return entityRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRestrictionAxiom_RestrictedRelation() {
		return (EReference)entityRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRestrictionAxiom_RestrictedRange() {
		return (EReference)entityRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRestrictionAxiom_RestrictedDomain() {
		return (EReference)entityRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityExistentialRestrictionAxiom() {
		return entityExistentialRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityExistentialRestrictionAxiom__Uuid() {
		return entityExistentialRestrictionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityUniversalRestrictionAxiom() {
		return entityUniversalRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityUniversalRestrictionAxiom__Uuid() {
		return entityUniversalRestrictionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecializationAxiom() {
		return specializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSpecializationAxiom__Child() {
		return specializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSpecializationAxiom__Parent() {
		return specializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAspectSpecializationAxiom() {
		return aspectSpecializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAspectSpecializationAxiom_SubEntity() {
		return (EReference)aspectSpecializationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAspectSpecializationAxiom_SuperAspect() {
		return (EReference)aspectSpecializationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAspectSpecializationAxiom__Child() {
		return aspectSpecializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAspectSpecializationAxiom__Parent() {
		return aspectSpecializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAspectSpecializationAxiom__Uuid() {
		return aspectSpecializationAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptSpecializationAxiom() {
		return conceptSpecializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptSpecializationAxiom_SubConcept() {
		return (EReference)conceptSpecializationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptSpecializationAxiom_SuperConcept() {
		return (EReference)conceptSpecializationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptSpecializationAxiom__Child() {
		return conceptSpecializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptSpecializationAxiom__Parent() {
		return conceptSpecializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptSpecializationAxiom__Uuid() {
		return conceptSpecializationAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipSpecializationAxiom() {
		return reifiedRelationshipSpecializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipSpecializationAxiom_SubRelationship() {
		return (EReference)reifiedRelationshipSpecializationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipSpecializationAxiom_SuperRelationship() {
		return (EReference)reifiedRelationshipSpecializationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSpecializationAxiom__Child() {
		return reifiedRelationshipSpecializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSpecializationAxiom__Parent() {
		return reifiedRelationshipSpecializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSpecializationAxiom__Uuid() {
		return reifiedRelationshipSpecializationAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataPropertyRestrictionAxiom() {
		return entityScalarDataPropertyRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyRestrictionAxiom_RestrictedEntity() {
		return (EReference)entityScalarDataPropertyRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyRestrictionAxiom_ScalarProperty() {
		return (EReference)entityScalarDataPropertyRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataPropertyExistentialRestrictionAxiom() {
		return entityScalarDataPropertyExistentialRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyExistentialRestrictionAxiom_ScalarRestriction() {
		return (EReference)entityScalarDataPropertyExistentialRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityScalarDataPropertyExistentialRestrictionAxiom__Uuid() {
		return entityScalarDataPropertyExistentialRestrictionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataPropertyUniversalRestrictionAxiom() {
		return entityScalarDataPropertyUniversalRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction() {
		return (EReference)entityScalarDataPropertyUniversalRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityScalarDataPropertyUniversalRestrictionAxiom__Uuid() {
		return entityScalarDataPropertyUniversalRestrictionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataPropertyParticularRestrictionAxiom() {
		return entityScalarDataPropertyParticularRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityScalarDataPropertyParticularRestrictionAxiom_LiteralValue() {
		return (EAttribute)entityScalarDataPropertyParticularRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityScalarDataPropertyParticularRestrictionAxiom__Uuid() {
		return entityScalarDataPropertyParticularRestrictionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestrictedDataRange() {
		return restrictedDataRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictedDataRange_RestrictedRange() {
		return (EReference)restrictedDataRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryScalarRestriction() {
		return binaryScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryScalarRestriction_Length() {
		return (EAttribute)binaryScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryScalarRestriction_MinLength() {
		return (EAttribute)binaryScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryScalarRestriction_MaxLength() {
		return (EAttribute)binaryScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIRIScalarRestriction() {
		return iriScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRIScalarRestriction_Length() {
		return (EAttribute)iriScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRIScalarRestriction_MinLength() {
		return (EAttribute)iriScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRIScalarRestriction_MaxLength() {
		return (EAttribute)iriScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRIScalarRestriction_Pattern() {
		return (EAttribute)iriScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericScalarRestriction() {
		return numericScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericScalarRestriction_MinInclusive() {
		return (EAttribute)numericScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericScalarRestriction_MaxInclusive() {
		return (EAttribute)numericScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericScalarRestriction_MinExclusive() {
		return (EAttribute)numericScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericScalarRestriction_MaxExclusive() {
		return (EAttribute)numericScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlainLiteralScalarRestriction() {
		return plainLiteralScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_Length() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_MinLength() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_MaxLength() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_Pattern() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_LangRange() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringScalarRestriction() {
		return stringScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringScalarRestriction_Length() {
		return (EAttribute)stringScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringScalarRestriction_MinLength() {
		return (EAttribute)stringScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringScalarRestriction_MaxLength() {
		return (EAttribute)stringScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringScalarRestriction_Pattern() {
		return (EAttribute)stringScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeScalarRestriction() {
		return timeScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeScalarRestriction_MinInclusive() {
		return (EAttribute)timeScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeScalarRestriction_MaxInclusive() {
		return (EAttribute)timeScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeScalarRestriction_MinExclusive() {
		return (EAttribute)timeScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeScalarRestriction_MaxExclusive() {
		return (EAttribute)timeScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynonymScalarRestriction() {
		return synonymScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarOneOfRestriction() {
		return scalarOneOfRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarOneOfLiteralAxiom() {
		return scalarOneOfLiteralAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarOneOfLiteralAxiom_Axiom() {
		return (EReference)scalarOneOfLiteralAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarOneOfLiteralAxiom_Value() {
		return (EAttribute)scalarOneOfLiteralAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarOneOfLiteralAxiom__Uuid() {
		return scalarOneOfLiteralAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTerminologyKind() {
		return terminologyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologiesFactory getTerminologiesFactory() {
		return (TerminologiesFactory)getEFactoryInstance();
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
		terminologyBoxEClass = createEClass(TERMINOLOGY_BOX);
		createEAttribute(terminologyBoxEClass, TERMINOLOGY_BOX__KIND);
		createEReference(terminologyBoxEClass, TERMINOLOGY_BOX__BOX_AXIOMS);
		createEReference(terminologyBoxEClass, TERMINOLOGY_BOX__BOX_STATEMENTS);

		terminologyBoxStatementEClass = createEClass(TERMINOLOGY_BOX_STATEMENT);
		createEReference(terminologyBoxStatementEClass, TERMINOLOGY_BOX_STATEMENT__TBOX);

		terminologyAxiomEClass = createEClass(TERMINOLOGY_AXIOM);
		createEOperation(terminologyAxiomEClass, TERMINOLOGY_AXIOM___SOURCE);
		createEOperation(terminologyAxiomEClass, TERMINOLOGY_AXIOM___SOURCE_MODULE);
		createEOperation(terminologyAxiomEClass, TERMINOLOGY_AXIOM___TARGET);
		createEOperation(terminologyAxiomEClass, TERMINOLOGY_AXIOM___TARGET_MODULE);

		terminologyBoxAxiomEClass = createEClass(TERMINOLOGY_BOX_AXIOM);
		createEReference(terminologyBoxAxiomEClass, TERMINOLOGY_BOX_AXIOM__TBOX);

		terminologyExtensionAxiomEClass = createEClass(TERMINOLOGY_EXTENSION_AXIOM);
		createEReference(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY);
		createEOperation(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM___EXTENDING_TERMINOLOGY);
		createEOperation(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM___SOURCE);
		createEOperation(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM___TARGET);
		createEOperation(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM___UUID);

		termEClass = createEClass(TERM);
		createEAttribute(termEClass, TERM__NAME);
		createEOperation(termEClass, TERM___IRI);
		createEOperation(termEClass, TERM___ABBREV_IRI);
		createEOperation(termEClass, TERM___NAME);
		createEOperation(termEClass, TERM___UUID);

		unaryTermKindEClass = createEClass(UNARY_TERM_KIND);

		directedBinaryRelationshipKindEClass = createEClass(DIRECTED_BINARY_RELATIONSHIP_KIND);
		createEOperation(directedBinaryRelationshipKindEClass, DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_DOMAIN);
		createEOperation(directedBinaryRelationshipKindEClass, DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_RANGE);

		entityEClass = createEClass(ENTITY);

		conceptualEntityEClass = createEClass(CONCEPTUAL_ENTITY);

		aspectEClass = createEClass(ASPECT);

		conceptEClass = createEClass(CONCEPT);

		entityRelationshipEClass = createEClass(ENTITY_RELATIONSHIP);
		createEReference(entityRelationshipEClass, ENTITY_RELATIONSHIP__SOURCE);
		createEReference(entityRelationshipEClass, ENTITY_RELATIONSHIP__TARGET);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_FUNCTIONAL);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_ESSENTIAL);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_SYMMETRIC);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_ASYMMETRIC);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_REFLEXIVE);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_IRREFLEXIVE);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_TRANSITIVE);
		createEOperation(entityRelationshipEClass, ENTITY_RELATIONSHIP___RELATION_DOMAIN);
		createEOperation(entityRelationshipEClass, ENTITY_RELATIONSHIP___RELATION_RANGE);

		reifiedRelationshipEClass = createEClass(REIFIED_RELATIONSHIP);
		createEAttribute(reifiedRelationshipEClass, REIFIED_RELATIONSHIP__UNREIFIED_PROPERTY_NAME);
		createEAttribute(reifiedRelationshipEClass, REIFIED_RELATIONSHIP__UNREIFIED_INVERSE_PROPERTY_NAME);

		unreifiedRelationshipEClass = createEClass(UNREIFIED_RELATIONSHIP);

		datatypeEClass = createEClass(DATATYPE);

		dataRangeEClass = createEClass(DATA_RANGE);

		scalarEClass = createEClass(SCALAR);

		dataRelationshipEClass = createEClass(DATA_RELATIONSHIP);
		createEOperation(dataRelationshipEClass, DATA_RELATIONSHIP___SOURCE);
		createEOperation(dataRelationshipEClass, DATA_RELATIONSHIP___RELATION_DOMAIN);
		createEOperation(dataRelationshipEClass, DATA_RELATIONSHIP___TARGET);
		createEOperation(dataRelationshipEClass, DATA_RELATIONSHIP___RELATION_RANGE);

		dataRelationshipDomainEClass = createEClass(DATA_RELATIONSHIP_DOMAIN);

		dataRelationshipFromEntityEClass = createEClass(DATA_RELATIONSHIP_FROM_ENTITY);
		createEReference(dataRelationshipFromEntityEClass, DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN);
		createEAttribute(dataRelationshipFromEntityEClass, DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA);

		dataRelationshipFromStructureEClass = createEClass(DATA_RELATIONSHIP_FROM_STRUCTURE);
		createEReference(dataRelationshipFromStructureEClass, DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN);

		dataRelationshipRangeEClass = createEClass(DATA_RELATIONSHIP_RANGE);

		dataRelationshipToScalarEClass = createEClass(DATA_RELATIONSHIP_TO_SCALAR);
		createEReference(dataRelationshipToScalarEClass, DATA_RELATIONSHIP_TO_SCALAR__RANGE);

		dataRelationshipToStructureEClass = createEClass(DATA_RELATIONSHIP_TO_STRUCTURE);
		createEReference(dataRelationshipToStructureEClass, DATA_RELATIONSHIP_TO_STRUCTURE__RANGE);

		entityStructuredDataPropertyEClass = createEClass(ENTITY_STRUCTURED_DATA_PROPERTY);
		createEOperation(entityStructuredDataPropertyEClass, ENTITY_STRUCTURED_DATA_PROPERTY___UUID);
		createEOperation(entityStructuredDataPropertyEClass, ENTITY_STRUCTURED_DATA_PROPERTY___SOURCE);
		createEOperation(entityStructuredDataPropertyEClass, ENTITY_STRUCTURED_DATA_PROPERTY___TARGET);

		entityScalarDataPropertyEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY);
		createEOperation(entityScalarDataPropertyEClass, ENTITY_SCALAR_DATA_PROPERTY___UUID);
		createEOperation(entityScalarDataPropertyEClass, ENTITY_SCALAR_DATA_PROPERTY___SOURCE);
		createEOperation(entityScalarDataPropertyEClass, ENTITY_SCALAR_DATA_PROPERTY___TARGET);

		structuredDataPropertyEClass = createEClass(STRUCTURED_DATA_PROPERTY);
		createEOperation(structuredDataPropertyEClass, STRUCTURED_DATA_PROPERTY___UUID);
		createEOperation(structuredDataPropertyEClass, STRUCTURED_DATA_PROPERTY___SOURCE);
		createEOperation(structuredDataPropertyEClass, STRUCTURED_DATA_PROPERTY___TARGET);

		scalarDataPropertyEClass = createEClass(SCALAR_DATA_PROPERTY);
		createEOperation(scalarDataPropertyEClass, SCALAR_DATA_PROPERTY___UUID);
		createEOperation(scalarDataPropertyEClass, SCALAR_DATA_PROPERTY___SOURCE);
		createEOperation(scalarDataPropertyEClass, SCALAR_DATA_PROPERTY___TARGET);

		structureEClass = createEClass(STRUCTURE);

		termAxiomEClass = createEClass(TERM_AXIOM);

		entityRestrictionAxiomEClass = createEClass(ENTITY_RESTRICTION_AXIOM);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN);

		entityExistentialRestrictionAxiomEClass = createEClass(ENTITY_EXISTENTIAL_RESTRICTION_AXIOM);
		createEOperation(entityExistentialRestrictionAxiomEClass, ENTITY_EXISTENTIAL_RESTRICTION_AXIOM___UUID);

		entityUniversalRestrictionAxiomEClass = createEClass(ENTITY_UNIVERSAL_RESTRICTION_AXIOM);
		createEOperation(entityUniversalRestrictionAxiomEClass, ENTITY_UNIVERSAL_RESTRICTION_AXIOM___UUID);

		specializationAxiomEClass = createEClass(SPECIALIZATION_AXIOM);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___CHILD);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___PARENT);

		aspectSpecializationAxiomEClass = createEClass(ASPECT_SPECIALIZATION_AXIOM);
		createEReference(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY);
		createEReference(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT);
		createEOperation(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM___CHILD);
		createEOperation(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM___PARENT);
		createEOperation(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM___UUID);

		conceptSpecializationAxiomEClass = createEClass(CONCEPT_SPECIALIZATION_AXIOM);
		createEReference(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT);
		createEReference(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT);
		createEOperation(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM___CHILD);
		createEOperation(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM___PARENT);
		createEOperation(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM___UUID);

		reifiedRelationshipSpecializationAxiomEClass = createEClass(REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM);
		createEReference(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP);
		createEReference(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP);
		createEOperation(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___CHILD);
		createEOperation(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___PARENT);
		createEOperation(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___UUID);

		entityScalarDataPropertyRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY);
		createEReference(entityScalarDataPropertyRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY);

		entityScalarDataPropertyExistentialRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyExistentialRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION);
		createEOperation(entityScalarDataPropertyExistentialRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM___UUID);

		entityScalarDataPropertyUniversalRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyUniversalRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION);
		createEOperation(entityScalarDataPropertyUniversalRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM___UUID);

		entityScalarDataPropertyParticularRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM);
		createEAttribute(entityScalarDataPropertyParticularRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__LITERAL_VALUE);
		createEOperation(entityScalarDataPropertyParticularRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID);

		restrictedDataRangeEClass = createEClass(RESTRICTED_DATA_RANGE);
		createEReference(restrictedDataRangeEClass, RESTRICTED_DATA_RANGE__RESTRICTED_RANGE);

		binaryScalarRestrictionEClass = createEClass(BINARY_SCALAR_RESTRICTION);
		createEAttribute(binaryScalarRestrictionEClass, BINARY_SCALAR_RESTRICTION__LENGTH);
		createEAttribute(binaryScalarRestrictionEClass, BINARY_SCALAR_RESTRICTION__MIN_LENGTH);
		createEAttribute(binaryScalarRestrictionEClass, BINARY_SCALAR_RESTRICTION__MAX_LENGTH);

		iriScalarRestrictionEClass = createEClass(IRI_SCALAR_RESTRICTION);
		createEAttribute(iriScalarRestrictionEClass, IRI_SCALAR_RESTRICTION__LENGTH);
		createEAttribute(iriScalarRestrictionEClass, IRI_SCALAR_RESTRICTION__MIN_LENGTH);
		createEAttribute(iriScalarRestrictionEClass, IRI_SCALAR_RESTRICTION__MAX_LENGTH);
		createEAttribute(iriScalarRestrictionEClass, IRI_SCALAR_RESTRICTION__PATTERN);

		numericScalarRestrictionEClass = createEClass(NUMERIC_SCALAR_RESTRICTION);
		createEAttribute(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE);
		createEAttribute(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE);
		createEAttribute(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE);
		createEAttribute(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE);

		plainLiteralScalarRestrictionEClass = createEClass(PLAIN_LITERAL_SCALAR_RESTRICTION);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE);

		stringScalarRestrictionEClass = createEClass(STRING_SCALAR_RESTRICTION);
		createEAttribute(stringScalarRestrictionEClass, STRING_SCALAR_RESTRICTION__LENGTH);
		createEAttribute(stringScalarRestrictionEClass, STRING_SCALAR_RESTRICTION__MIN_LENGTH);
		createEAttribute(stringScalarRestrictionEClass, STRING_SCALAR_RESTRICTION__MAX_LENGTH);
		createEAttribute(stringScalarRestrictionEClass, STRING_SCALAR_RESTRICTION__PATTERN);

		timeScalarRestrictionEClass = createEClass(TIME_SCALAR_RESTRICTION);
		createEAttribute(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE);
		createEAttribute(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE);
		createEAttribute(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE);
		createEAttribute(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE);

		synonymScalarRestrictionEClass = createEClass(SYNONYM_SCALAR_RESTRICTION);

		scalarOneOfRestrictionEClass = createEClass(SCALAR_ONE_OF_RESTRICTION);

		scalarOneOfLiteralAxiomEClass = createEClass(SCALAR_ONE_OF_LITERAL_AXIOM);
		createEReference(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM);
		createEAttribute(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM__VALUE);
		createEOperation(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM___UUID);

		// Create enums
		terminologyKindEEnum = createEEnum(TERMINOLOGY_KIND);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		terminologyBoxEClass.getESuperTypes().add(theCommonPackage.getModule());
		terminologyBoxStatementEClass.getESuperTypes().add(theCommonPackage.getModuleElement());
		terminologyAxiomEClass.getESuperTypes().add(theCommonPackage.getModuleEdge());
		terminologyBoxAxiomEClass.getESuperTypes().add(this.getTerminologyAxiom());
		terminologyExtensionAxiomEClass.getESuperTypes().add(this.getTerminologyBoxAxiom());
		termEClass.getESuperTypes().add(this.getTerminologyBoxStatement());
		termEClass.getESuperTypes().add(theCommonPackage.getResource());
		entityEClass.getESuperTypes().add(this.getTerm());
		aspectEClass.getESuperTypes().add(this.getEntity());
		aspectEClass.getESuperTypes().add(this.getUnaryTermKind());
		conceptEClass.getESuperTypes().add(this.getEntity());
		conceptEClass.getESuperTypes().add(this.getConceptualEntity());
		conceptEClass.getESuperTypes().add(this.getUnaryTermKind());
		entityRelationshipEClass.getESuperTypes().add(this.getTerm());
		entityRelationshipEClass.getESuperTypes().add(this.getDirectedBinaryRelationshipKind());
		reifiedRelationshipEClass.getESuperTypes().add(this.getEntityRelationship());
		reifiedRelationshipEClass.getESuperTypes().add(this.getEntity());
		reifiedRelationshipEClass.getESuperTypes().add(this.getConceptualEntity());
		unreifiedRelationshipEClass.getESuperTypes().add(this.getEntityRelationship());
		datatypeEClass.getESuperTypes().add(this.getTerm());
		dataRangeEClass.getESuperTypes().add(this.getDatatype());
		scalarEClass.getESuperTypes().add(this.getDataRange());
		scalarEClass.getESuperTypes().add(this.getUnaryTermKind());
		dataRelationshipEClass.getESuperTypes().add(this.getTerm());
		dataRelationshipEClass.getESuperTypes().add(this.getDirectedBinaryRelationshipKind());
		dataRelationshipDomainEClass.getESuperTypes().add(theCommonPackage.getElement());
		dataRelationshipDomainEClass.getESuperTypes().add(theCommonPackage.getResource());
		dataRelationshipFromEntityEClass.getESuperTypes().add(this.getDataRelationshipDomain());
		dataRelationshipFromStructureEClass.getESuperTypes().add(this.getDataRelationshipDomain());
		dataRelationshipRangeEClass.getESuperTypes().add(theCommonPackage.getElement());
		dataRelationshipRangeEClass.getESuperTypes().add(theCommonPackage.getResource());
		dataRelationshipToScalarEClass.getESuperTypes().add(this.getDataRelationshipRange());
		dataRelationshipToStructureEClass.getESuperTypes().add(this.getDataRelationshipRange());
		entityStructuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationship());
		entityStructuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipFromEntity());
		entityStructuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipToStructure());
		entityScalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationship());
		entityScalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipFromEntity());
		entityScalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipToScalar());
		structuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationship());
		structuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipFromStructure());
		structuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipToStructure());
		scalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationship());
		scalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipFromStructure());
		scalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipToScalar());
		structureEClass.getESuperTypes().add(this.getDatatype());
		structureEClass.getESuperTypes().add(this.getUnaryTermKind());
		termAxiomEClass.getESuperTypes().add(this.getTerminologyBoxStatement());
		entityRestrictionAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		entityExistentialRestrictionAxiomEClass.getESuperTypes().add(this.getEntityRestrictionAxiom());
		entityUniversalRestrictionAxiomEClass.getESuperTypes().add(this.getEntityRestrictionAxiom());
		specializationAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		aspectSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		conceptSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		reifiedRelationshipSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		entityScalarDataPropertyRestrictionAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		entityScalarDataPropertyExistentialRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		entityScalarDataPropertyUniversalRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		entityScalarDataPropertyParticularRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		restrictedDataRangeEClass.getESuperTypes().add(this.getDataRange());
		binaryScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		iriScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		numericScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		plainLiteralScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		stringScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		timeScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		synonymScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		scalarOneOfRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		scalarOneOfLiteralAxiomEClass.getESuperTypes().add(this.getTermAxiom());

		// Initialize classes, features, and operations; add parameters
		initEClass(terminologyBoxEClass, TerminologyBox.class, "TerminologyBox", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerminologyBox_Kind(), this.getTerminologyKind(), "kind", null, 1, 1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyBox_BoxAxioms(), this.getTerminologyBoxAxiom(), this.getTerminologyBoxAxiom_Tbox(), "boxAxioms", null, 0, -1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyBox_BoxStatements(), this.getTerminologyBoxStatement(), this.getTerminologyBoxStatement_Tbox(), "boxStatements", null, 0, -1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminologyBoxStatementEClass, TerminologyBoxStatement.class, "TerminologyBoxStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBoxStatement_Tbox(), this.getTerminologyBox(), this.getTerminologyBox_BoxStatements(), "tbox", null, 1, 1, TerminologyBoxStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminologyAxiomEClass, TerminologyAxiom.class, "TerminologyAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTerminologyAxiom__Source(), this.getTerminologyBox(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyAxiom__SourceModule(), theCommonPackage.getModule(), "sourceModule", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyAxiom__Target(), this.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyAxiom__TargetModule(), theCommonPackage.getModule(), "targetModule", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyBoxAxiomEClass, TerminologyBoxAxiom.class, "TerminologyBoxAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBoxAxiom_Tbox(), this.getTerminologyBox(), this.getTerminologyBox_BoxAxioms(), "tbox", null, 1, 1, TerminologyBoxAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminologyExtensionAxiomEClass, TerminologyExtensionAxiom.class, "TerminologyExtensionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyExtensionAxiom_ExtendedTerminology(), this.getTerminologyBox(), null, "extendedTerminology", null, 1, 1, TerminologyExtensionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerminologyExtensionAxiom__ExtendingTerminology(), this.getTerminologyBox(), "extendingTerminology", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyExtensionAxiom__Source(), this.getTerminologyBox(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyExtensionAxiom__Target(), this.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyExtensionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(termEClass, Term.class, "Term", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerm_Name(), theCommonPackage.getLocalName(), "name", null, 1, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerm__Iri(), theCommonPackage.getIRI(), "iri", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerm__AbbrevIRI(), theEcorePackage.getEString(), "abbrevIRI", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerm__Name(), theCommonPackage.getLocalName(), "name", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerm__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(unaryTermKindEClass, UnaryTermKind.class, "UnaryTermKind", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directedBinaryRelationshipKindEClass, DirectedBinaryRelationshipKind.class, "DirectedBinaryRelationshipKind", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDirectedBinaryRelationshipKind__RelationDomain(), this.getTerm(), "relationDomain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDirectedBinaryRelationshipKind__RelationRange(), this.getTerm(), "relationRange", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptualEntityEClass, ConceptualEntity.class, "ConceptualEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(aspectEClass, Aspect.class, "Aspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptEClass, Concept.class, "Concept", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityRelationshipEClass, EntityRelationship.class, "EntityRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityRelationship_Source(), this.getEntity(), null, "source", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityRelationship_Target(), this.getEntity(), null, "target", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsFunctional(), theEcorePackage.getEBoolean(), "isFunctional", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsInverseFunctional(), theEcorePackage.getEBoolean(), "isInverseFunctional", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsEssential(), theEcorePackage.getEBoolean(), "isEssential", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsInverseEssential(), theEcorePackage.getEBoolean(), "isInverseEssential", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsSymmetric(), theEcorePackage.getEBoolean(), "isSymmetric", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsAsymmetric(), theEcorePackage.getEBoolean(), "isAsymmetric", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsReflexive(), theEcorePackage.getEBoolean(), "isReflexive", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsIrreflexive(), theEcorePackage.getEBoolean(), "isIrreflexive", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsTransitive(), theEcorePackage.getEBoolean(), "isTransitive", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityRelationship__RelationDomain(), this.getTerm(), "relationDomain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityRelationship__RelationRange(), this.getTerm(), "relationRange", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipEClass, ReifiedRelationship.class, "ReifiedRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReifiedRelationship_UnreifiedPropertyName(), theCommonPackage.getLocalName(), "unreifiedPropertyName", null, 1, 1, ReifiedRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReifiedRelationship_UnreifiedInversePropertyName(), theCommonPackage.getLocalName(), "unreifiedInversePropertyName", null, 0, 1, ReifiedRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unreifiedRelationshipEClass, UnreifiedRelationship.class, "UnreifiedRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(datatypeEClass, Datatype.class, "Datatype", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataRangeEClass, DataRange.class, "DataRange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarEClass, Scalar.class, "Scalar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataRelationshipEClass, DataRelationship.class, "DataRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDataRelationship__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataRelationship__RelationDomain(), this.getTerm(), "relationDomain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataRelationship__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataRelationship__RelationRange(), this.getTerm(), "relationRange", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(dataRelationshipDomainEClass, DataRelationshipDomain.class, "DataRelationshipDomain", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataRelationshipFromEntityEClass, DataRelationshipFromEntity.class, "DataRelationshipFromEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataRelationshipFromEntity_Domain(), this.getEntity(), null, "domain", null, 1, 1, DataRelationshipFromEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataRelationshipFromEntity_IsIdentityCriteria(), theEcorePackage.getEBoolean(), "isIdentityCriteria", null, 1, 1, DataRelationshipFromEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataRelationshipFromStructureEClass, DataRelationshipFromStructure.class, "DataRelationshipFromStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataRelationshipFromStructure_Domain(), this.getStructure(), null, "domain", null, 1, 1, DataRelationshipFromStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataRelationshipRangeEClass, DataRelationshipRange.class, "DataRelationshipRange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataRelationshipToScalarEClass, DataRelationshipToScalar.class, "DataRelationshipToScalar", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataRelationshipToScalar_Range(), this.getDataRange(), null, "range", null, 1, 1, DataRelationshipToScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataRelationshipToStructureEClass, DataRelationshipToStructure.class, "DataRelationshipToStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataRelationshipToStructure_Range(), this.getStructure(), null, "range", null, 1, 1, DataRelationshipToStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityStructuredDataPropertyEClass, EntityStructuredDataProperty.class, "EntityStructuredDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityStructuredDataProperty__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityStructuredDataProperty__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityStructuredDataProperty__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyEClass, EntityScalarDataProperty.class, "EntityScalarDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityScalarDataProperty__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityScalarDataProperty__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityScalarDataProperty__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(structuredDataPropertyEClass, StructuredDataProperty.class, "StructuredDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getStructuredDataProperty__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getStructuredDataProperty__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getStructuredDataProperty__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(scalarDataPropertyEClass, ScalarDataProperty.class, "ScalarDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getScalarDataProperty__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getScalarDataProperty__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getScalarDataProperty__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(termAxiomEClass, TermAxiom.class, "TermAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityRestrictionAxiomEClass, EntityRestrictionAxiom.class, "EntityRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityRestrictionAxiom_RestrictedRelation(), this.getEntityRelationship(), null, "restrictedRelation", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityRestrictionAxiom_RestrictedRange(), this.getEntity(), null, "restrictedRange", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityRestrictionAxiom_RestrictedDomain(), this.getEntity(), null, "restrictedDomain", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityExistentialRestrictionAxiomEClass, EntityExistentialRestrictionAxiom.class, "EntityExistentialRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityExistentialRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityUniversalRestrictionAxiomEClass, EntityUniversalRestrictionAxiom.class, "EntityUniversalRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityUniversalRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(specializationAxiomEClass, SpecializationAxiom.class, "SpecializationAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(aspectSpecializationAxiomEClass, AspectSpecializationAxiom.class, "AspectSpecializationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAspectSpecializationAxiom_SubEntity(), this.getEntity(), null, "subEntity", null, 1, 1, AspectSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAspectSpecializationAxiom_SuperAspect(), this.getAspect(), null, "superAspect", null, 1, 1, AspectSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAspectSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAspectSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAspectSpecializationAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptSpecializationAxiomEClass, ConceptSpecializationAxiom.class, "ConceptSpecializationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptSpecializationAxiom_SubConcept(), this.getConcept(), null, "subConcept", null, 1, 1, ConceptSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptSpecializationAxiom_SuperConcept(), this.getConcept(), null, "superConcept", null, 1, 1, ConceptSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptSpecializationAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipSpecializationAxiomEClass, ReifiedRelationshipSpecializationAxiom.class, "ReifiedRelationshipSpecializationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipSpecializationAxiom_SubRelationship(), this.getReifiedRelationship(), null, "subRelationship", null, 1, 1, ReifiedRelationshipSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipSpecializationAxiom_SuperRelationship(), this.getReifiedRelationship(), null, "superRelationship", null, 1, 1, ReifiedRelationshipSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipSpecializationAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyRestrictionAxiomEClass, EntityScalarDataPropertyRestrictionAxiom.class, "EntityScalarDataPropertyRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyRestrictionAxiom_RestrictedEntity(), this.getEntity(), null, "restrictedEntity", null, 1, 1, EntityScalarDataPropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityScalarDataPropertyRestrictionAxiom_ScalarProperty(), this.getEntityScalarDataProperty(), null, "scalarProperty", null, 1, 1, EntityScalarDataPropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityScalarDataPropertyExistentialRestrictionAxiomEClass, EntityScalarDataPropertyExistentialRestrictionAxiom.class, "EntityScalarDataPropertyExistentialRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyExistentialRestrictionAxiom_ScalarRestriction(), this.getDataRange(), null, "scalarRestriction", null, 1, 1, EntityScalarDataPropertyExistentialRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityScalarDataPropertyExistentialRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyUniversalRestrictionAxiomEClass, EntityScalarDataPropertyUniversalRestrictionAxiom.class, "EntityScalarDataPropertyUniversalRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction(), this.getDataRange(), null, "scalarRestriction", null, 1, 1, EntityScalarDataPropertyUniversalRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityScalarDataPropertyUniversalRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyParticularRestrictionAxiomEClass, EntityScalarDataPropertyParticularRestrictionAxiom.class, "EntityScalarDataPropertyParticularRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntityScalarDataPropertyParticularRestrictionAxiom_LiteralValue(), theCommonPackage.getLexicalValue(), "literalValue", null, 1, 1, EntityScalarDataPropertyParticularRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityScalarDataPropertyParticularRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(restrictedDataRangeEClass, RestrictedDataRange.class, "RestrictedDataRange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRestrictedDataRange_RestrictedRange(), this.getDataRange(), null, "restrictedRange", null, 1, 1, RestrictedDataRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryScalarRestrictionEClass, BinaryScalarRestriction.class, "BinaryScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryScalarRestriction_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryScalarRestriction_MinLength(), theEcorePackage.getEInt(), "minLength", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryScalarRestriction_MaxLength(), theEcorePackage.getEInt(), "maxLength", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iriScalarRestrictionEClass, IRIScalarRestriction.class, "IRIScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIRIScalarRestriction_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_MinLength(), theEcorePackage.getEInt(), "minLength", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_MaxLength(), theEcorePackage.getEInt(), "maxLength", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_Pattern(), theCommonPackage.getPattern(), "pattern", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericScalarRestrictionEClass, NumericScalarRestriction.class, "NumericScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericScalarRestriction_MinInclusive(), theCommonPackage.getLexicalNumber(), "minInclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericScalarRestriction_MaxInclusive(), theCommonPackage.getLexicalNumber(), "maxInclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericScalarRestriction_MinExclusive(), theCommonPackage.getLexicalNumber(), "minExclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericScalarRestriction_MaxExclusive(), theCommonPackage.getLexicalNumber(), "maxExclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plainLiteralScalarRestrictionEClass, PlainLiteralScalarRestriction.class, "PlainLiteralScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlainLiteralScalarRestriction_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_MinLength(), theEcorePackage.getEInt(), "minLength", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_MaxLength(), theEcorePackage.getEInt(), "maxLength", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_Pattern(), theCommonPackage.getPattern(), "pattern", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_LangRange(), theCommonPackage.getLangRange(), "langRange", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringScalarRestrictionEClass, StringScalarRestriction.class, "StringScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringScalarRestriction_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_MinLength(), theEcorePackage.getEInt(), "minLength", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_MaxLength(), theEcorePackage.getEInt(), "maxLength", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_Pattern(), theCommonPackage.getPattern(), "pattern", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeScalarRestrictionEClass, TimeScalarRestriction.class, "TimeScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeScalarRestriction_MinInclusive(), theCommonPackage.getLexicalTime(), "minInclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeScalarRestriction_MaxInclusive(), theCommonPackage.getLexicalTime(), "maxInclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeScalarRestriction_MinExclusive(), theCommonPackage.getLexicalTime(), "minExclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeScalarRestriction_MaxExclusive(), theCommonPackage.getLexicalTime(), "maxExclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(synonymScalarRestrictionEClass, SynonymScalarRestriction.class, "SynonymScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarOneOfRestrictionEClass, ScalarOneOfRestriction.class, "ScalarOneOfRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarOneOfLiteralAxiomEClass, ScalarOneOfLiteralAxiom.class, "ScalarOneOfLiteralAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarOneOfLiteralAxiom_Axiom(), this.getScalarOneOfRestriction(), null, "axiom", null, 1, 1, ScalarOneOfLiteralAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarOneOfLiteralAxiom_Value(), theCommonPackage.getLexicalValue(), "value", null, 1, 1, ScalarOneOfLiteralAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getScalarOneOfLiteralAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(terminologyKindEEnum, TerminologyKind.class, "TerminologyKind");
		addEEnumLiteral(terminologyKindEEnum, TerminologyKind.OPEN_WORLD_DEFINITIONS);
		addEEnumLiteral(terminologyKindEEnum, TerminologyKind.CLOSED_WORLD_DESIGNATIONS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://imce.jpl.nasa.gov/oml/Glossary
		createGlossaryAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotSchema
		createNotSchemaAnnotations();
		// http://imce.jpl.nasa.gov/oml/Collection
		createCollectionAnnotations();
		// http://imce.jpl.nasa.gov/oml/ImplicitExtent
		createImplicitExtentAnnotations();
		// http://imce.jpl.nasa.gov/oml/CopyConstructor
		createCopyConstructorAnnotations();
		// http://imce.jpl.nasa.gov/oml/DerivedUUID
		createDerivedUUIDAnnotations();
		// http://imce.jpl.nasa.gov/oml/Scala
		createScalaAnnotations();
		// http://imce.jpl.nasa.gov/oml/Override
		createOverrideAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotFunctionalAPI
		createNotFunctionalAPIAnnotations();
		// http://imce.jpl.nasa.gov/oml/NamespaceUUID
		createNamespaceUUIDAnnotations();
		// http://imce.jpl.nasa.gov/oml/FunctionalInterface
		createFunctionalInterfaceAnnotations();
		// http://imce.jpl.nasa.gov/oml/OverrideVal
		createOverrideValAnnotations();
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
		  (terminologyKindEEnum, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBoxEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBoxStatementEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBoxAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyExtensionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (termEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (unaryTermKindEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (directedBinaryRelationshipKindEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptualEntityEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (aspectEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (unreifiedRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (datatypeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRangeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipDomainEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipFromEntityEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationshipFromEntity_IsIdentityCriteria(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipFromStructureEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipRangeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipToScalarEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipToStructureEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityStructuredDataPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (structuredDataPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarDataPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (structureEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (termAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityExistentialRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityUniversalRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (specializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (aspectSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyExistentialRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyUniversalRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyParticularRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (restrictedDataRangeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (binaryScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (iriScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (numericScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (plainLiteralScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (stringScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (timeScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (synonymScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarOneOfRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarOneOfLiteralAxiomEClass, 
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
		  (getTerminologyBox_BoxAxioms(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox_BoxStatements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__SourceModule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__TargetModule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__ExtendingTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__AbbrevIRI(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDirectedBinaryRelationshipKind__RelationDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDirectedBinaryRelationshipKind__RelationRange(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityRelationship__RelationDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityRelationship__RelationRange(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__RelationDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__RelationRange(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityExistentialRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityUniversalRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyExistentialRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyUniversalRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyParticularRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarOneOfLiteralAxiom__Uuid(), 
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
		  (getTerminologyBox_BoxAxioms(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getTerminologyBox_BoxStatements(), 
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
		  (getTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__SourceModule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__TargetModule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__ExtendingTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__AbbrevIRI(), 
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
		  (getTerminologyBoxAxiom_Tbox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom_ExtendedTerminology(), 
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
		  (terminologyExtensionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityExistentialRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityUniversalRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (aspectSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyExistentialRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyUniversalRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyParticularRestrictionAxiomEClass, 
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
		  (getTerminologyExtensionAxiom__ExtendingTerminology(), 
		   source, 
		   new String[] {
			 "code", "extent.terminologyBoxOfTerminologyBoxAxiom.get(this)"
		   });	
		addAnnotation
		  (getTerm__Iri(), 
		   source, 
		   new String[] {
			 "code", "extent.terminologyBoxOfTerminologyBoxStatement.get(this).flatMap(_.iri().map(_ + \"#\" + name))"
		   });	
		addAnnotation
		  (getTerm__AbbrevIRI(), 
		   source, 
		   new String[] {
			 "code", "extent.terminologyBoxOfTerminologyBoxStatement.get(this).map(tbox => tbox.nsPrefix+\":\"+name)"
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
		  (getTerminologyExtensionAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__AbbrevIRI(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm_Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityRelationship__RelationDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityRelationship__RelationRange(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__RelationDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__RelationRange(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Parent(), 
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
		  (getTerminologyExtensionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityExistentialRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityUniversalRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyExistentialRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyUniversalRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyParticularRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarOneOfLiteralAxiom__Uuid(), 
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
		  (termEClass, 
		   source, 
		   new String[] {
			 "namespace", "tbox",
			 "factors", "name"
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
		  (getEntityStructuredDataProperty__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Uuid(), 
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
		  (getEntityStructuredDataProperty__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Uuid(), 
		   source, 
		   new String[] {
		   });
	}

} //TerminologiesPackageImpl
