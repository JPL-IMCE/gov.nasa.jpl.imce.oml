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
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;

import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.BinarySegmentForwardPropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.BinarySegmentPropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.BinarySegmentReversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptPredicate;
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
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipPropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSourceInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSourcePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipTargetInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipTargetPropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.Rule;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate;
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
import gov.nasa.jpl.imce.oml.model.terminologies.UnarySegmentPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.UnaryTermKind;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipPropertyPredicate;

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
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chainRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleBodySegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass segmentPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unarySegmentPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aspectPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binarySegmentPropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binarySegmentForwardPropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binarySegmentReversePropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipPropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipInversePropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipSourcePropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipSourceInversePropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipTargetPropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipTargetInversePropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unreifiedRelationshipPropertyPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unreifiedRelationshipInversePropertyPredicateEClass = null;

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
	private EClass entityStructuredDataPropertyRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityStructuredDataPropertyParticularRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restrictionStructuredDataPropertyContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restrictionStructuredDataPropertyTupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restrictionScalarDataPropertyValueEClass = null;

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
	public EOperation getTerminologyBoxStatement__ModuleContext() {
		return terminologyBoxStatementEClass.getEOperations().get(0);
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
	public EOperation getTerm__AllNestedElements() {
		return termEClass.getEOperations().get(4);
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
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChainRule() {
		return chainRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChainRule_Head() {
		return (EReference)chainRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChainRule_FirstSegment() {
		return (EReference)chainRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleBodySegment() {
		return ruleBodySegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleBodySegment_Predicate() {
		return (EReference)ruleBodySegmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleBodySegment_NextSegment() {
		return (EReference)ruleBodySegmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleBodySegment_PreviousSegment() {
		return (EReference)ruleBodySegmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleBodySegment_Rule() {
		return (EReference)ruleBodySegmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRuleBodySegment__Position() {
		return ruleBodySegmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRuleBodySegment__ChainRule() {
		return ruleBodySegmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRuleBodySegment__Uuid() {
		return ruleBodySegmentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRuleBodySegment__ModuleContext() {
		return ruleBodySegmentEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSegmentPredicate() {
		return segmentPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSegmentPredicate_BodySegment() {
		return (EReference)segmentPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSegmentPredicate__TermPredicate() {
		return segmentPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSegmentPredicate__ModuleContext() {
		return segmentPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnarySegmentPredicate() {
		return unarySegmentPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAspectPredicate() {
		return aspectPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAspectPredicate_Aspect() {
		return (EReference)aspectPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAspectPredicate__TermPredicate() {
		return aspectPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAspectPredicate__Uuid() {
		return aspectPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptPredicate() {
		return conceptPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptPredicate_Concept() {
		return (EReference)conceptPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptPredicate__TermPredicate() {
		return conceptPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptPredicate__Uuid() {
		return conceptPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipPredicate() {
		return reifiedRelationshipPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipPredicate_ReifiedRelationship() {
		return (EReference)reifiedRelationshipPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipPredicate__TermPredicate() {
		return reifiedRelationshipPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipPredicate__Uuid() {
		return reifiedRelationshipPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinarySegmentPropertyPredicate() {
		return binarySegmentPropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinarySegmentForwardPropertyPredicate() {
		return binarySegmentForwardPropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinarySegmentReversePropertyPredicate() {
		return binarySegmentReversePropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipPropertyPredicate() {
		return reifiedRelationshipPropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipPropertyPredicate_ReifiedRelationship() {
		return (EReference)reifiedRelationshipPropertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipPropertyPredicate__TermPredicate() {
		return reifiedRelationshipPropertyPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipPropertyPredicate__Uuid() {
		return reifiedRelationshipPropertyPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipInversePropertyPredicate() {
		return reifiedRelationshipInversePropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInversePropertyPredicate_ReifiedRelationship() {
		return (EReference)reifiedRelationshipInversePropertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInversePropertyPredicate__TermPredicate() {
		return reifiedRelationshipInversePropertyPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInversePropertyPredicate__Uuid() {
		return reifiedRelationshipInversePropertyPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipSourcePropertyPredicate() {
		return reifiedRelationshipSourcePropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipSourcePropertyPredicate_ReifiedRelationship() {
		return (EReference)reifiedRelationshipSourcePropertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSourcePropertyPredicate__TermPredicate() {
		return reifiedRelationshipSourcePropertyPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSourcePropertyPredicate__Uuid() {
		return reifiedRelationshipSourcePropertyPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipSourceInversePropertyPredicate() {
		return reifiedRelationshipSourceInversePropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipSourceInversePropertyPredicate_ReifiedRelationship() {
		return (EReference)reifiedRelationshipSourceInversePropertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSourceInversePropertyPredicate__TermPredicate() {
		return reifiedRelationshipSourceInversePropertyPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSourceInversePropertyPredicate__Uuid() {
		return reifiedRelationshipSourceInversePropertyPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipTargetPropertyPredicate() {
		return reifiedRelationshipTargetPropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipTargetPropertyPredicate_ReifiedRelationship() {
		return (EReference)reifiedRelationshipTargetPropertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipTargetPropertyPredicate__TermPredicate() {
		return reifiedRelationshipTargetPropertyPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipTargetPropertyPredicate__Uuid() {
		return reifiedRelationshipTargetPropertyPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipTargetInversePropertyPredicate() {
		return reifiedRelationshipTargetInversePropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipTargetInversePropertyPredicate_ReifiedRelationship() {
		return (EReference)reifiedRelationshipTargetInversePropertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipTargetInversePropertyPredicate__TermPredicate() {
		return reifiedRelationshipTargetInversePropertyPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipTargetInversePropertyPredicate__Uuid() {
		return reifiedRelationshipTargetInversePropertyPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnreifiedRelationshipPropertyPredicate() {
		return unreifiedRelationshipPropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipPropertyPredicate_UnreifiedRelationship() {
		return (EReference)unreifiedRelationshipPropertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnreifiedRelationshipPropertyPredicate__TermPredicate() {
		return unreifiedRelationshipPropertyPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnreifiedRelationshipPropertyPredicate__Uuid() {
		return unreifiedRelationshipPropertyPredicateEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnreifiedRelationshipInversePropertyPredicate() {
		return unreifiedRelationshipInversePropertyPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInversePropertyPredicate_UnreifiedRelationship() {
		return (EReference)unreifiedRelationshipInversePropertyPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnreifiedRelationshipInversePropertyPredicate__TermPredicate() {
		return unreifiedRelationshipInversePropertyPredicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnreifiedRelationshipInversePropertyPredicate__Uuid() {
		return unreifiedRelationshipInversePropertyPredicateEClass.getEOperations().get(1);
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
	public EOperation getEntityRestrictionAxiom__AllNestedElements() {
		return entityRestrictionAxiomEClass.getEOperations().get(0);
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
	public EOperation getSpecializationAxiom__AllNestedElements() {
		return specializationAxiomEClass.getEOperations().get(2);
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
	public EOperation getEntityScalarDataPropertyRestrictionAxiom__AllNestedElements() {
		return entityScalarDataPropertyRestrictionAxiomEClass.getEOperations().get(0);
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
	public EReference getEntityScalarDataPropertyParticularRestrictionAxiom_LiteralValue() {
		return (EReference)entityScalarDataPropertyParticularRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyParticularRestrictionAxiom_ValueType() {
		return (EReference)entityScalarDataPropertyParticularRestrictionAxiomEClass.getEStructuralFeatures().get(1);
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
	public EClass getEntityStructuredDataPropertyRestrictionAxiom() {
		return entityStructuredDataPropertyRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityStructuredDataPropertyRestrictionAxiom_RestrictedEntity() {
		return (EReference)entityStructuredDataPropertyRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityStructuredDataPropertyParticularRestrictionAxiom() {
		return entityStructuredDataPropertyParticularRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityStructuredDataPropertyParticularRestrictionAxiom__TerminologyBox() {
		return entityStructuredDataPropertyParticularRestrictionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityStructuredDataPropertyParticularRestrictionAxiom__Uuid() {
		return entityStructuredDataPropertyParticularRestrictionAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityStructuredDataPropertyParticularRestrictionAxiom__AllNestedElements() {
		return entityStructuredDataPropertyParticularRestrictionAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestrictionStructuredDataPropertyContext() {
		return restrictionStructuredDataPropertyContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictionStructuredDataPropertyContext_StructuredDataProperty() {
		return (EReference)restrictionStructuredDataPropertyContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictionStructuredDataPropertyContext_StructuredDataPropertyRestrictions() {
		return (EReference)restrictionStructuredDataPropertyContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictionStructuredDataPropertyContext_ScalarDataPropertyRestrictions() {
		return (EReference)restrictionStructuredDataPropertyContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionStructuredDataPropertyContext__TerminologyBox() {
		return restrictionStructuredDataPropertyContextEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionStructuredDataPropertyContext__AllNestedRestrictionElements() {
		return restrictionStructuredDataPropertyContextEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestrictionStructuredDataPropertyTuple() {
		return restrictionStructuredDataPropertyTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictionStructuredDataPropertyTuple_StructuredDataPropertyContext() {
		return (EReference)restrictionStructuredDataPropertyTupleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionStructuredDataPropertyTuple__TerminologyBox() {
		return restrictionStructuredDataPropertyTupleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionStructuredDataPropertyTuple__Uuid() {
		return restrictionStructuredDataPropertyTupleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionStructuredDataPropertyTuple__ModuleContext() {
		return restrictionStructuredDataPropertyTupleEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionStructuredDataPropertyTuple__AllNestedElements() {
		return restrictionStructuredDataPropertyTupleEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestrictionScalarDataPropertyValue() {
		return restrictionScalarDataPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictionScalarDataPropertyValue_StructuredDataPropertyContext() {
		return (EReference)restrictionScalarDataPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictionScalarDataPropertyValue_ScalarDataProperty() {
		return (EReference)restrictionScalarDataPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictionScalarDataPropertyValue_ScalarPropertyValue() {
		return (EReference)restrictionScalarDataPropertyValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictionScalarDataPropertyValue_ValueType() {
		return (EReference)restrictionScalarDataPropertyValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionScalarDataPropertyValue__TerminologyBox() {
		return restrictionScalarDataPropertyValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionScalarDataPropertyValue__Uuid() {
		return restrictionScalarDataPropertyValueEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRestrictionScalarDataPropertyValue__ModuleContext() {
		return restrictionScalarDataPropertyValueEClass.getEOperations().get(2);
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
	public EReference getNumericScalarRestriction_MinInclusive() {
		return (EReference)numericScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericScalarRestriction_MaxInclusive() {
		return (EReference)numericScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericScalarRestriction_MinExclusive() {
		return (EReference)numericScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericScalarRestriction_MaxExclusive() {
		return (EReference)numericScalarRestrictionEClass.getEStructuralFeatures().get(3);
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
	public EReference getTimeScalarRestriction_MinInclusive() {
		return (EReference)timeScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeScalarRestriction_MaxInclusive() {
		return (EReference)timeScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeScalarRestriction_MinExclusive() {
		return (EReference)timeScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeScalarRestriction_MaxExclusive() {
		return (EReference)timeScalarRestrictionEClass.getEStructuralFeatures().get(3);
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
	public EReference getScalarOneOfLiteralAxiom_Value() {
		return (EReference)scalarOneOfLiteralAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarOneOfLiteralAxiom_ValueType() {
		return (EReference)scalarOneOfLiteralAxiomEClass.getEStructuralFeatures().get(2);
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
	public EOperation getScalarOneOfLiteralAxiom__AllNestedElements() {
		return scalarOneOfLiteralAxiomEClass.getEOperations().get(1);
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
		createEOperation(terminologyBoxStatementEClass, TERMINOLOGY_BOX_STATEMENT___MODULE_CONTEXT);

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
		createEOperation(termEClass, TERM___ALL_NESTED_ELEMENTS);

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

		ruleEClass = createEClass(RULE);

		chainRuleEClass = createEClass(CHAIN_RULE);
		createEReference(chainRuleEClass, CHAIN_RULE__HEAD);
		createEReference(chainRuleEClass, CHAIN_RULE__FIRST_SEGMENT);

		ruleBodySegmentEClass = createEClass(RULE_BODY_SEGMENT);
		createEReference(ruleBodySegmentEClass, RULE_BODY_SEGMENT__PREDICATE);
		createEReference(ruleBodySegmentEClass, RULE_BODY_SEGMENT__NEXT_SEGMENT);
		createEReference(ruleBodySegmentEClass, RULE_BODY_SEGMENT__PREVIOUS_SEGMENT);
		createEReference(ruleBodySegmentEClass, RULE_BODY_SEGMENT__RULE);
		createEOperation(ruleBodySegmentEClass, RULE_BODY_SEGMENT___POSITION);
		createEOperation(ruleBodySegmentEClass, RULE_BODY_SEGMENT___CHAIN_RULE);
		createEOperation(ruleBodySegmentEClass, RULE_BODY_SEGMENT___UUID);
		createEOperation(ruleBodySegmentEClass, RULE_BODY_SEGMENT___MODULE_CONTEXT);

		segmentPredicateEClass = createEClass(SEGMENT_PREDICATE);
		createEReference(segmentPredicateEClass, SEGMENT_PREDICATE__BODY_SEGMENT);
		createEOperation(segmentPredicateEClass, SEGMENT_PREDICATE___TERM_PREDICATE);
		createEOperation(segmentPredicateEClass, SEGMENT_PREDICATE___MODULE_CONTEXT);

		unarySegmentPredicateEClass = createEClass(UNARY_SEGMENT_PREDICATE);

		aspectPredicateEClass = createEClass(ASPECT_PREDICATE);
		createEReference(aspectPredicateEClass, ASPECT_PREDICATE__ASPECT);
		createEOperation(aspectPredicateEClass, ASPECT_PREDICATE___TERM_PREDICATE);
		createEOperation(aspectPredicateEClass, ASPECT_PREDICATE___UUID);

		conceptPredicateEClass = createEClass(CONCEPT_PREDICATE);
		createEReference(conceptPredicateEClass, CONCEPT_PREDICATE__CONCEPT);
		createEOperation(conceptPredicateEClass, CONCEPT_PREDICATE___TERM_PREDICATE);
		createEOperation(conceptPredicateEClass, CONCEPT_PREDICATE___UUID);

		reifiedRelationshipPredicateEClass = createEClass(REIFIED_RELATIONSHIP_PREDICATE);
		createEReference(reifiedRelationshipPredicateEClass, REIFIED_RELATIONSHIP_PREDICATE__REIFIED_RELATIONSHIP);
		createEOperation(reifiedRelationshipPredicateEClass, REIFIED_RELATIONSHIP_PREDICATE___TERM_PREDICATE);
		createEOperation(reifiedRelationshipPredicateEClass, REIFIED_RELATIONSHIP_PREDICATE___UUID);

		binarySegmentPropertyPredicateEClass = createEClass(BINARY_SEGMENT_PROPERTY_PREDICATE);

		binarySegmentForwardPropertyPredicateEClass = createEClass(BINARY_SEGMENT_FORWARD_PROPERTY_PREDICATE);

		binarySegmentReversePropertyPredicateEClass = createEClass(BINARY_SEGMENT_REVERSE_PROPERTY_PREDICATE);

		reifiedRelationshipPropertyPredicateEClass = createEClass(REIFIED_RELATIONSHIP_PROPERTY_PREDICATE);
		createEReference(reifiedRelationshipPropertyPredicateEClass, REIFIED_RELATIONSHIP_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP);
		createEOperation(reifiedRelationshipPropertyPredicateEClass, REIFIED_RELATIONSHIP_PROPERTY_PREDICATE___TERM_PREDICATE);
		createEOperation(reifiedRelationshipPropertyPredicateEClass, REIFIED_RELATIONSHIP_PROPERTY_PREDICATE___UUID);

		reifiedRelationshipInversePropertyPredicateEClass = createEClass(REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE);
		createEReference(reifiedRelationshipInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP);
		createEOperation(reifiedRelationshipInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE___TERM_PREDICATE);
		createEOperation(reifiedRelationshipInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE___UUID);

		reifiedRelationshipSourcePropertyPredicateEClass = createEClass(REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE);
		createEReference(reifiedRelationshipSourcePropertyPredicateEClass, REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP);
		createEOperation(reifiedRelationshipSourcePropertyPredicateEClass, REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE___TERM_PREDICATE);
		createEOperation(reifiedRelationshipSourcePropertyPredicateEClass, REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE___UUID);

		reifiedRelationshipSourceInversePropertyPredicateEClass = createEClass(REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE);
		createEReference(reifiedRelationshipSourceInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP);
		createEOperation(reifiedRelationshipSourceInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE___TERM_PREDICATE);
		createEOperation(reifiedRelationshipSourceInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE___UUID);

		reifiedRelationshipTargetPropertyPredicateEClass = createEClass(REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE);
		createEReference(reifiedRelationshipTargetPropertyPredicateEClass, REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP);
		createEOperation(reifiedRelationshipTargetPropertyPredicateEClass, REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE___TERM_PREDICATE);
		createEOperation(reifiedRelationshipTargetPropertyPredicateEClass, REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE___UUID);

		reifiedRelationshipTargetInversePropertyPredicateEClass = createEClass(REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE);
		createEReference(reifiedRelationshipTargetInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE__REIFIED_RELATIONSHIP);
		createEOperation(reifiedRelationshipTargetInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE___TERM_PREDICATE);
		createEOperation(reifiedRelationshipTargetInversePropertyPredicateEClass, REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE___UUID);

		unreifiedRelationshipPropertyPredicateEClass = createEClass(UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE);
		createEReference(unreifiedRelationshipPropertyPredicateEClass, UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP);
		createEOperation(unreifiedRelationshipPropertyPredicateEClass, UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE___TERM_PREDICATE);
		createEOperation(unreifiedRelationshipPropertyPredicateEClass, UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE___UUID);

		unreifiedRelationshipInversePropertyPredicateEClass = createEClass(UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE);
		createEReference(unreifiedRelationshipInversePropertyPredicateEClass, UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE__UNREIFIED_RELATIONSHIP);
		createEOperation(unreifiedRelationshipInversePropertyPredicateEClass, UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE___TERM_PREDICATE);
		createEOperation(unreifiedRelationshipInversePropertyPredicateEClass, UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE___UUID);

		termAxiomEClass = createEClass(TERM_AXIOM);

		entityRestrictionAxiomEClass = createEClass(ENTITY_RESTRICTION_AXIOM);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN);
		createEOperation(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM___ALL_NESTED_ELEMENTS);

		entityExistentialRestrictionAxiomEClass = createEClass(ENTITY_EXISTENTIAL_RESTRICTION_AXIOM);
		createEOperation(entityExistentialRestrictionAxiomEClass, ENTITY_EXISTENTIAL_RESTRICTION_AXIOM___UUID);

		entityUniversalRestrictionAxiomEClass = createEClass(ENTITY_UNIVERSAL_RESTRICTION_AXIOM);
		createEOperation(entityUniversalRestrictionAxiomEClass, ENTITY_UNIVERSAL_RESTRICTION_AXIOM___UUID);

		specializationAxiomEClass = createEClass(SPECIALIZATION_AXIOM);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___CHILD);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___PARENT);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___ALL_NESTED_ELEMENTS);

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
		createEOperation(entityScalarDataPropertyRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM___ALL_NESTED_ELEMENTS);

		entityScalarDataPropertyExistentialRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyExistentialRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION);
		createEOperation(entityScalarDataPropertyExistentialRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM___UUID);

		entityScalarDataPropertyUniversalRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyUniversalRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION);
		createEOperation(entityScalarDataPropertyUniversalRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM___UUID);

		entityScalarDataPropertyParticularRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyParticularRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__LITERAL_VALUE);
		createEReference(entityScalarDataPropertyParticularRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__VALUE_TYPE);
		createEOperation(entityScalarDataPropertyParticularRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID);

		entityStructuredDataPropertyRestrictionAxiomEClass = createEClass(ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM);
		createEReference(entityStructuredDataPropertyRestrictionAxiomEClass, ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY);

		entityStructuredDataPropertyParticularRestrictionAxiomEClass = createEClass(ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM);
		createEOperation(entityStructuredDataPropertyParticularRestrictionAxiomEClass, ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___TERMINOLOGY_BOX);
		createEOperation(entityStructuredDataPropertyParticularRestrictionAxiomEClass, ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___UUID);
		createEOperation(entityStructuredDataPropertyParticularRestrictionAxiomEClass, ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM___ALL_NESTED_ELEMENTS);

		restrictionStructuredDataPropertyContextEClass = createEClass(RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT);
		createEReference(restrictionStructuredDataPropertyContextEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY);
		createEReference(restrictionStructuredDataPropertyContextEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__STRUCTURED_DATA_PROPERTY_RESTRICTIONS);
		createEReference(restrictionStructuredDataPropertyContextEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT__SCALAR_DATA_PROPERTY_RESTRICTIONS);
		createEOperation(restrictionStructuredDataPropertyContextEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT___TERMINOLOGY_BOX);
		createEOperation(restrictionStructuredDataPropertyContextEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT___ALL_NESTED_RESTRICTION_ELEMENTS);

		restrictionStructuredDataPropertyTupleEClass = createEClass(RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE);
		createEReference(restrictionStructuredDataPropertyTupleEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		createEOperation(restrictionStructuredDataPropertyTupleEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE___TERMINOLOGY_BOX);
		createEOperation(restrictionStructuredDataPropertyTupleEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE___UUID);
		createEOperation(restrictionStructuredDataPropertyTupleEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE___MODULE_CONTEXT);
		createEOperation(restrictionStructuredDataPropertyTupleEClass, RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE___ALL_NESTED_ELEMENTS);

		restrictionScalarDataPropertyValueEClass = createEClass(RESTRICTION_SCALAR_DATA_PROPERTY_VALUE);
		createEReference(restrictionScalarDataPropertyValueEClass, RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT);
		createEReference(restrictionScalarDataPropertyValueEClass, RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY);
		createEReference(restrictionScalarDataPropertyValueEClass, RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE);
		createEReference(restrictionScalarDataPropertyValueEClass, RESTRICTION_SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE);
		createEOperation(restrictionScalarDataPropertyValueEClass, RESTRICTION_SCALAR_DATA_PROPERTY_VALUE___TERMINOLOGY_BOX);
		createEOperation(restrictionScalarDataPropertyValueEClass, RESTRICTION_SCALAR_DATA_PROPERTY_VALUE___UUID);
		createEOperation(restrictionScalarDataPropertyValueEClass, RESTRICTION_SCALAR_DATA_PROPERTY_VALUE___MODULE_CONTEXT);

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
		createEReference(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE);
		createEReference(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE);
		createEReference(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE);
		createEReference(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE);

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
		createEReference(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE);
		createEReference(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE);
		createEReference(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE);
		createEReference(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE);

		synonymScalarRestrictionEClass = createEClass(SYNONYM_SCALAR_RESTRICTION);

		scalarOneOfRestrictionEClass = createEClass(SCALAR_ONE_OF_RESTRICTION);

		scalarOneOfLiteralAxiomEClass = createEClass(SCALAR_ONE_OF_LITERAL_AXIOM);
		createEReference(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM);
		createEReference(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM__VALUE);
		createEReference(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM__VALUE_TYPE);
		createEOperation(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM___UUID);
		createEOperation(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM___ALL_NESTED_ELEMENTS);

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
		unaryTermKindEClass.getESuperTypes().add(this.getTerm());
		directedBinaryRelationshipKindEClass.getESuperTypes().add(this.getTerm());
		entityEClass.getESuperTypes().add(this.getTerm());
		conceptualEntityEClass.getESuperTypes().add(this.getEntity());
		aspectEClass.getESuperTypes().add(this.getEntity());
		aspectEClass.getESuperTypes().add(this.getUnaryTermKind());
		conceptEClass.getESuperTypes().add(this.getConceptualEntity());
		conceptEClass.getESuperTypes().add(this.getUnaryTermKind());
		entityRelationshipEClass.getESuperTypes().add(this.getTerm());
		entityRelationshipEClass.getESuperTypes().add(this.getDirectedBinaryRelationshipKind());
		reifiedRelationshipEClass.getESuperTypes().add(this.getEntityRelationship());
		reifiedRelationshipEClass.getESuperTypes().add(this.getConceptualEntity());
		unreifiedRelationshipEClass.getESuperTypes().add(this.getEntityRelationship());
		datatypeEClass.getESuperTypes().add(this.getTerm());
		dataRangeEClass.getESuperTypes().add(this.getDatatype());
		scalarEClass.getESuperTypes().add(this.getDataRange());
		scalarEClass.getESuperTypes().add(this.getUnaryTermKind());
		dataRelationshipEClass.getESuperTypes().add(this.getTerm());
		dataRelationshipEClass.getESuperTypes().add(this.getDirectedBinaryRelationshipKind());
		dataRelationshipDomainEClass.getESuperTypes().add(this.getDataRelationship());
		dataRelationshipFromEntityEClass.getESuperTypes().add(this.getDataRelationshipDomain());
		dataRelationshipFromStructureEClass.getESuperTypes().add(this.getDataRelationshipDomain());
		dataRelationshipRangeEClass.getESuperTypes().add(this.getDataRelationship());
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
		ruleEClass.getESuperTypes().add(this.getTerm());
		chainRuleEClass.getESuperTypes().add(this.getRule());
		ruleBodySegmentEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		segmentPredicateEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		unarySegmentPredicateEClass.getESuperTypes().add(this.getSegmentPredicate());
		aspectPredicateEClass.getESuperTypes().add(this.getUnarySegmentPredicate());
		conceptPredicateEClass.getESuperTypes().add(this.getUnarySegmentPredicate());
		reifiedRelationshipPredicateEClass.getESuperTypes().add(this.getUnarySegmentPredicate());
		binarySegmentPropertyPredicateEClass.getESuperTypes().add(this.getSegmentPredicate());
		binarySegmentForwardPropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentPropertyPredicate());
		binarySegmentReversePropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentPropertyPredicate());
		reifiedRelationshipPropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentForwardPropertyPredicate());
		reifiedRelationshipInversePropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentReversePropertyPredicate());
		reifiedRelationshipSourcePropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentForwardPropertyPredicate());
		reifiedRelationshipSourceInversePropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentReversePropertyPredicate());
		reifiedRelationshipTargetPropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentForwardPropertyPredicate());
		reifiedRelationshipTargetInversePropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentReversePropertyPredicate());
		unreifiedRelationshipPropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentForwardPropertyPredicate());
		unreifiedRelationshipInversePropertyPredicateEClass.getESuperTypes().add(this.getBinarySegmentReversePropertyPredicate());
		termAxiomEClass.getESuperTypes().add(this.getTerminologyBoxStatement());
		entityRestrictionAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		entityRestrictionAxiomEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		entityExistentialRestrictionAxiomEClass.getESuperTypes().add(this.getEntityRestrictionAxiom());
		entityUniversalRestrictionAxiomEClass.getESuperTypes().add(this.getEntityRestrictionAxiom());
		specializationAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		specializationAxiomEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		aspectSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		conceptSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		reifiedRelationshipSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		entityScalarDataPropertyRestrictionAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		entityScalarDataPropertyRestrictionAxiomEClass.getESuperTypes().add(theCommonPackage.getExtrinsicIdentityKind());
		entityScalarDataPropertyExistentialRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		entityScalarDataPropertyExistentialRestrictionAxiomEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		entityScalarDataPropertyUniversalRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		entityScalarDataPropertyUniversalRestrictionAxiomEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		entityScalarDataPropertyParticularRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		entityScalarDataPropertyParticularRestrictionAxiomEClass.getESuperTypes().add(theCommonPackage.getValueCrossReferenceTuple());
		entityStructuredDataPropertyRestrictionAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		entityStructuredDataPropertyRestrictionAxiomEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		entityStructuredDataPropertyParticularRestrictionAxiomEClass.getESuperTypes().add(this.getEntityStructuredDataPropertyRestrictionAxiom());
		entityStructuredDataPropertyParticularRestrictionAxiomEClass.getESuperTypes().add(this.getRestrictionStructuredDataPropertyContext());
		restrictionStructuredDataPropertyContextEClass.getESuperTypes().add(theCommonPackage.getModuleElement());
		restrictionStructuredDataPropertyContextEClass.getESuperTypes().add(theCommonPackage.getElementCrossReferenceTuple());
		restrictionStructuredDataPropertyTupleEClass.getESuperTypes().add(this.getRestrictionStructuredDataPropertyContext());
		restrictionScalarDataPropertyValueEClass.getESuperTypes().add(theCommonPackage.getLogicalElement());
		restrictionScalarDataPropertyValueEClass.getESuperTypes().add(theCommonPackage.getValueCrossReferenceTuple());
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
		scalarOneOfLiteralAxiomEClass.getESuperTypes().add(theCommonPackage.getValueCrossReferenceTuple());

		// Initialize classes, features, and operations; add parameters
		initEClass(terminologyBoxEClass, TerminologyBox.class, "TerminologyBox", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerminologyBox_Kind(), this.getTerminologyKind(), "kind", null, 1, 1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyBox_BoxAxioms(), this.getTerminologyBoxAxiom(), this.getTerminologyBoxAxiom_Tbox(), "boxAxioms", null, 0, -1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyBox_BoxStatements(), this.getTerminologyBoxStatement(), this.getTerminologyBoxStatement_Tbox(), "boxStatements", null, 0, -1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminologyBoxStatementEClass, TerminologyBoxStatement.class, "TerminologyBoxStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBoxStatement_Tbox(), this.getTerminologyBox(), this.getTerminologyBox_BoxStatements(), "tbox", null, 1, 1, TerminologyBoxStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerminologyBoxStatement__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

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

		initEOperation(getTerm__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

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

		initEClass(ruleEClass, Rule.class, "Rule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(chainRuleEClass, ChainRule.class, "ChainRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChainRule_Head(), this.getUnreifiedRelationship(), null, "head", null, 1, 1, ChainRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChainRule_FirstSegment(), this.getRuleBodySegment(), this.getRuleBodySegment_Rule(), "firstSegment", null, 1, 1, ChainRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleBodySegmentEClass, RuleBodySegment.class, "RuleBodySegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleBodySegment_Predicate(), this.getSegmentPredicate(), this.getSegmentPredicate_BodySegment(), "predicate", null, 1, 1, RuleBodySegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleBodySegment_NextSegment(), this.getRuleBodySegment(), this.getRuleBodySegment_PreviousSegment(), "nextSegment", null, 0, 1, RuleBodySegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleBodySegment_PreviousSegment(), this.getRuleBodySegment(), this.getRuleBodySegment_NextSegment(), "previousSegment", null, 0, 1, RuleBodySegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleBodySegment_Rule(), this.getChainRule(), this.getChainRule_FirstSegment(), "rule", null, 0, 1, RuleBodySegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRuleBodySegment__Position(), theEcorePackage.getEInt(), "position", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRuleBodySegment__ChainRule(), this.getChainRule(), "chainRule", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRuleBodySegment__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRuleBodySegment__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(segmentPredicateEClass, SegmentPredicate.class, "SegmentPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSegmentPredicate_BodySegment(), this.getRuleBodySegment(), this.getRuleBodySegment_Predicate(), "bodySegment", null, 1, 1, SegmentPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSegmentPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSegmentPredicate__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(unarySegmentPredicateEClass, UnarySegmentPredicate.class, "UnarySegmentPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(aspectPredicateEClass, AspectPredicate.class, "AspectPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAspectPredicate_Aspect(), this.getAspect(), null, "aspect", null, 1, 1, AspectPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAspectPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAspectPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptPredicateEClass, ConceptPredicate.class, "ConceptPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptPredicate_Concept(), this.getConcept(), null, "concept", null, 1, 1, ConceptPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipPredicateEClass, ReifiedRelationshipPredicate.class, "ReifiedRelationshipPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipPredicate_ReifiedRelationship(), this.getReifiedRelationship(), null, "reifiedRelationship", null, 1, 1, ReifiedRelationshipPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(binarySegmentPropertyPredicateEClass, BinarySegmentPropertyPredicate.class, "BinarySegmentPropertyPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binarySegmentForwardPropertyPredicateEClass, BinarySegmentForwardPropertyPredicate.class, "BinarySegmentForwardPropertyPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binarySegmentReversePropertyPredicateEClass, BinarySegmentReversePropertyPredicate.class, "BinarySegmentReversePropertyPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reifiedRelationshipPropertyPredicateEClass, ReifiedRelationshipPropertyPredicate.class, "ReifiedRelationshipPropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipPropertyPredicate_ReifiedRelationship(), this.getReifiedRelationship(), null, "reifiedRelationship", null, 1, 1, ReifiedRelationshipPropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipPropertyPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipPropertyPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipInversePropertyPredicateEClass, ReifiedRelationshipInversePropertyPredicate.class, "ReifiedRelationshipInversePropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipInversePropertyPredicate_ReifiedRelationship(), this.getReifiedRelationship(), null, "reifiedRelationship", null, 1, 1, ReifiedRelationshipInversePropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipInversePropertyPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipInversePropertyPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipSourcePropertyPredicateEClass, ReifiedRelationshipSourcePropertyPredicate.class, "ReifiedRelationshipSourcePropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipSourcePropertyPredicate_ReifiedRelationship(), this.getReifiedRelationship(), null, "reifiedRelationship", null, 1, 1, ReifiedRelationshipSourcePropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipSourcePropertyPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipSourcePropertyPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipSourceInversePropertyPredicateEClass, ReifiedRelationshipSourceInversePropertyPredicate.class, "ReifiedRelationshipSourceInversePropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipSourceInversePropertyPredicate_ReifiedRelationship(), this.getReifiedRelationship(), null, "reifiedRelationship", null, 1, 1, ReifiedRelationshipSourceInversePropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipSourceInversePropertyPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipSourceInversePropertyPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipTargetPropertyPredicateEClass, ReifiedRelationshipTargetPropertyPredicate.class, "ReifiedRelationshipTargetPropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipTargetPropertyPredicate_ReifiedRelationship(), this.getReifiedRelationship(), null, "reifiedRelationship", null, 1, 1, ReifiedRelationshipTargetPropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipTargetPropertyPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipTargetPropertyPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipTargetInversePropertyPredicateEClass, ReifiedRelationshipTargetInversePropertyPredicate.class, "ReifiedRelationshipTargetInversePropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipTargetInversePropertyPredicate_ReifiedRelationship(), this.getReifiedRelationship(), null, "reifiedRelationship", null, 1, 1, ReifiedRelationshipTargetInversePropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipTargetInversePropertyPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipTargetInversePropertyPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(unreifiedRelationshipPropertyPredicateEClass, UnreifiedRelationshipPropertyPredicate.class, "UnreifiedRelationshipPropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnreifiedRelationshipPropertyPredicate_UnreifiedRelationship(), this.getUnreifiedRelationship(), null, "unreifiedRelationship", null, 1, 1, UnreifiedRelationshipPropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getUnreifiedRelationshipPropertyPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getUnreifiedRelationshipPropertyPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(unreifiedRelationshipInversePropertyPredicateEClass, UnreifiedRelationshipInversePropertyPredicate.class, "UnreifiedRelationshipInversePropertyPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnreifiedRelationshipInversePropertyPredicate_UnreifiedRelationship(), this.getUnreifiedRelationship(), null, "unreifiedRelationship", null, 1, 1, UnreifiedRelationshipInversePropertyPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getUnreifiedRelationshipInversePropertyPredicate__TermPredicate(), this.getTerm(), "termPredicate", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getUnreifiedRelationshipInversePropertyPredicate__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(termAxiomEClass, TermAxiom.class, "TermAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityRestrictionAxiomEClass, EntityRestrictionAxiom.class, "EntityRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityRestrictionAxiom_RestrictedRelation(), this.getEntityRelationship(), null, "restrictedRelation", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityRestrictionAxiom_RestrictedRange(), this.getEntity(), null, "restrictedRange", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityRestrictionAxiom_RestrictedDomain(), this.getEntity(), null, "restrictedDomain", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityRestrictionAxiom__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityExistentialRestrictionAxiomEClass, EntityExistentialRestrictionAxiom.class, "EntityExistentialRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityExistentialRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityUniversalRestrictionAxiomEClass, EntityUniversalRestrictionAxiom.class, "EntityUniversalRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityUniversalRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(specializationAxiomEClass, SpecializationAxiom.class, "SpecializationAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSpecializationAxiom__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

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

		initEOperation(getEntityScalarDataPropertyRestrictionAxiom__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyExistentialRestrictionAxiomEClass, EntityScalarDataPropertyExistentialRestrictionAxiom.class, "EntityScalarDataPropertyExistentialRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyExistentialRestrictionAxiom_ScalarRestriction(), this.getDataRange(), null, "scalarRestriction", null, 1, 1, EntityScalarDataPropertyExistentialRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityScalarDataPropertyExistentialRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyUniversalRestrictionAxiomEClass, EntityScalarDataPropertyUniversalRestrictionAxiom.class, "EntityScalarDataPropertyUniversalRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction(), this.getDataRange(), null, "scalarRestriction", null, 1, 1, EntityScalarDataPropertyUniversalRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityScalarDataPropertyUniversalRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyParticularRestrictionAxiomEClass, EntityScalarDataPropertyParticularRestrictionAxiom.class, "EntityScalarDataPropertyParticularRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyParticularRestrictionAxiom_LiteralValue(), theCommonPackage.getLiteralValue(), null, "literalValue", null, 1, 1, EntityScalarDataPropertyParticularRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityScalarDataPropertyParticularRestrictionAxiom_ValueType(), this.getDataRange(), null, "valueType", null, 0, 1, EntityScalarDataPropertyParticularRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityScalarDataPropertyParticularRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityStructuredDataPropertyRestrictionAxiomEClass, EntityStructuredDataPropertyRestrictionAxiom.class, "EntityStructuredDataPropertyRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityStructuredDataPropertyRestrictionAxiom_RestrictedEntity(), this.getEntity(), null, "restrictedEntity", null, 1, 1, EntityStructuredDataPropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityStructuredDataPropertyParticularRestrictionAxiomEClass, EntityStructuredDataPropertyParticularRestrictionAxiom.class, "EntityStructuredDataPropertyParticularRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityStructuredDataPropertyParticularRestrictionAxiom__TerminologyBox(), this.getTerminologyBox(), "terminologyBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityStructuredDataPropertyParticularRestrictionAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityStructuredDataPropertyParticularRestrictionAxiom__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(restrictionStructuredDataPropertyContextEClass, RestrictionStructuredDataPropertyContext.class, "RestrictionStructuredDataPropertyContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRestrictionStructuredDataPropertyContext_StructuredDataProperty(), this.getDataRelationshipToStructure(), null, "structuredDataProperty", null, 1, 1, RestrictionStructuredDataPropertyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestrictionStructuredDataPropertyContext_StructuredDataPropertyRestrictions(), this.getRestrictionStructuredDataPropertyTuple(), this.getRestrictionStructuredDataPropertyTuple_StructuredDataPropertyContext(), "structuredDataPropertyRestrictions", null, 0, -1, RestrictionStructuredDataPropertyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestrictionStructuredDataPropertyContext_ScalarDataPropertyRestrictions(), this.getRestrictionScalarDataPropertyValue(), this.getRestrictionScalarDataPropertyValue_StructuredDataPropertyContext(), "scalarDataPropertyRestrictions", null, 0, -1, RestrictionStructuredDataPropertyContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRestrictionStructuredDataPropertyContext__TerminologyBox(), this.getTerminologyBox(), "terminologyBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRestrictionStructuredDataPropertyContext__AllNestedRestrictionElements(), theCommonPackage.getLogicalElement(), "allNestedRestrictionElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(restrictionStructuredDataPropertyTupleEClass, RestrictionStructuredDataPropertyTuple.class, "RestrictionStructuredDataPropertyTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRestrictionStructuredDataPropertyTuple_StructuredDataPropertyContext(), this.getRestrictionStructuredDataPropertyContext(), this.getRestrictionStructuredDataPropertyContext_StructuredDataPropertyRestrictions(), "structuredDataPropertyContext", null, 1, 1, RestrictionStructuredDataPropertyTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRestrictionStructuredDataPropertyTuple__TerminologyBox(), this.getTerminologyBox(), "terminologyBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRestrictionStructuredDataPropertyTuple__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRestrictionStructuredDataPropertyTuple__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRestrictionStructuredDataPropertyTuple__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(restrictionScalarDataPropertyValueEClass, RestrictionScalarDataPropertyValue.class, "RestrictionScalarDataPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRestrictionScalarDataPropertyValue_StructuredDataPropertyContext(), this.getRestrictionStructuredDataPropertyContext(), this.getRestrictionStructuredDataPropertyContext_ScalarDataPropertyRestrictions(), "structuredDataPropertyContext", null, 1, 1, RestrictionScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestrictionScalarDataPropertyValue_ScalarDataProperty(), this.getDataRelationshipToScalar(), null, "scalarDataProperty", null, 1, 1, RestrictionScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestrictionScalarDataPropertyValue_ScalarPropertyValue(), theCommonPackage.getLiteralValue(), null, "scalarPropertyValue", null, 1, 1, RestrictionScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRestrictionScalarDataPropertyValue_ValueType(), this.getDataRange(), null, "valueType", null, 0, 1, RestrictionScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRestrictionScalarDataPropertyValue__TerminologyBox(), this.getTerminologyBox(), "terminologyBox", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRestrictionScalarDataPropertyValue__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRestrictionScalarDataPropertyValue__ModuleContext(), theCommonPackage.getModule(), "moduleContext", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(restrictedDataRangeEClass, RestrictedDataRange.class, "RestrictedDataRange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRestrictedDataRange_RestrictedRange(), this.getDataRange(), null, "restrictedRange", null, 1, 1, RestrictedDataRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryScalarRestrictionEClass, BinaryScalarRestriction.class, "BinaryScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryScalarRestriction_Length(), theCommonPackage.getPositiveIntegerLiteral(), "length", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryScalarRestriction_MinLength(), theCommonPackage.getPositiveIntegerLiteral(), "minLength", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryScalarRestriction_MaxLength(), theCommonPackage.getPositiveIntegerLiteral(), "maxLength", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iriScalarRestrictionEClass, IRIScalarRestriction.class, "IRIScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIRIScalarRestriction_Length(), theCommonPackage.getPositiveIntegerLiteral(), "length", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_MinLength(), theCommonPackage.getPositiveIntegerLiteral(), "minLength", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_MaxLength(), theCommonPackage.getPositiveIntegerLiteral(), "maxLength", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_Pattern(), theCommonPackage.getLiteralPattern(), "pattern", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericScalarRestrictionEClass, NumericScalarRestriction.class, "NumericScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumericScalarRestriction_MinInclusive(), theCommonPackage.getLiteralNumber(), null, "minInclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumericScalarRestriction_MaxInclusive(), theCommonPackage.getLiteralNumber(), null, "maxInclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumericScalarRestriction_MinExclusive(), theCommonPackage.getLiteralNumber(), null, "minExclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumericScalarRestriction_MaxExclusive(), theCommonPackage.getLiteralNumber(), null, "maxExclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plainLiteralScalarRestrictionEClass, PlainLiteralScalarRestriction.class, "PlainLiteralScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlainLiteralScalarRestriction_Length(), theCommonPackage.getPositiveIntegerLiteral(), "length", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_MinLength(), theCommonPackage.getPositiveIntegerLiteral(), "minLength", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_MaxLength(), theCommonPackage.getPositiveIntegerLiteral(), "maxLength", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_Pattern(), theCommonPackage.getLiteralPattern(), "pattern", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_LangRange(), theCommonPackage.getLanguageTagDataType(), "langRange", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringScalarRestrictionEClass, StringScalarRestriction.class, "StringScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringScalarRestriction_Length(), theCommonPackage.getPositiveIntegerLiteral(), "length", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_MinLength(), theCommonPackage.getPositiveIntegerLiteral(), "minLength", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_MaxLength(), theCommonPackage.getPositiveIntegerLiteral(), "maxLength", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_Pattern(), theCommonPackage.getLiteralPattern(), "pattern", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeScalarRestrictionEClass, TimeScalarRestriction.class, "TimeScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeScalarRestriction_MinInclusive(), theCommonPackage.getLiteralDateTime(), null, "minInclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimeScalarRestriction_MaxInclusive(), theCommonPackage.getLiteralDateTime(), null, "maxInclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimeScalarRestriction_MinExclusive(), theCommonPackage.getLiteralDateTime(), null, "minExclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimeScalarRestriction_MaxExclusive(), theCommonPackage.getLiteralDateTime(), null, "maxExclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(synonymScalarRestrictionEClass, SynonymScalarRestriction.class, "SynonymScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarOneOfRestrictionEClass, ScalarOneOfRestriction.class, "ScalarOneOfRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarOneOfLiteralAxiomEClass, ScalarOneOfLiteralAxiom.class, "ScalarOneOfLiteralAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarOneOfLiteralAxiom_Axiom(), this.getScalarOneOfRestriction(), null, "axiom", null, 1, 1, ScalarOneOfLiteralAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarOneOfLiteralAxiom_Value(), theCommonPackage.getLiteralValue(), null, "value", null, 1, 1, ScalarOneOfLiteralAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarOneOfLiteralAxiom_ValueType(), this.getDataRange(), null, "valueType", null, 0, 1, ScalarOneOfLiteralAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getScalarOneOfLiteralAxiom__Uuid(), theCommonPackage.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getScalarOneOfLiteralAxiom__AllNestedElements(), theCommonPackage.getLogicalElement(), "allNestedElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

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
		// http://imce.jpl.nasa.gov/oml/Scala
		createScalaAnnotations();
		// http://imce.jpl.nasa.gov/oml/ImplicitExtent
		createImplicitExtentAnnotations();
		// http://imce.jpl.nasa.gov/oml/Factory
		createFactoryAnnotations();
		// http://imce.jpl.nasa.gov/oml/IRIReference
		createIRIReferenceAnnotations();
		// http://imce.jpl.nasa.gov/oml/CopyConstructor
		createCopyConstructorAnnotations();
		// http://imce.jpl.nasa.gov/oml/DerivedUUID
		createDerivedUUIDAnnotations();
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
		  (ruleEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (chainRuleEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (ruleBodySegmentEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (segmentPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (unarySegmentPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (aspectPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (binarySegmentPropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (binarySegmentForwardPropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (binarySegmentReversePropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipPropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipInversePropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipSourcePropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipSourceInversePropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipTargetPropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipTargetInversePropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (unreifiedRelationshipPropertyPredicateEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (unreifiedRelationshipInversePropertyPredicateEClass, 
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
		  (entityStructuredDataPropertyRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityStructuredDataPropertyParticularRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (restrictionStructuredDataPropertyContextEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (restrictionStructuredDataPropertyTupleEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (restrictionScalarDataPropertyValueEClass, 
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
		  (getTerminologyBoxStatement__ModuleContext(), 
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
		  (getTerm__AllNestedElements(), 
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
		  (getRuleBodySegment__Position(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRuleBodySegment__ChainRule(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRuleBodySegment__ModuleContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSegmentPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSegmentPredicate__ModuleContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipPropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipInversePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSourcePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSourceInversePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipTargetPropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipTargetInversePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getUnreifiedRelationshipPropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getUnreifiedRelationshipInversePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityRestrictionAxiom__AllNestedElements(), 
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
		  (getSpecializationAxiom__AllNestedElements(), 
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
		  (getEntityScalarDataPropertyRestrictionAxiom__AllNestedElements(), 
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
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyContext__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyContext__AllNestedRestrictionElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__ModuleContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__AllNestedElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue__ModuleContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarOneOfLiteralAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarOneOfLiteralAxiom__AllNestedElements(), 
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
		addAnnotation
		  (getTerm__AllNestedElements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getEntityRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getSpecializationAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyContext__AllNestedRestrictionElements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyContext_StructuredDataPropertyRestrictions(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyContext_ScalarDataPropertyRestrictions(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__AllNestedElements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
		   });	
		addAnnotation
		  (getScalarOneOfLiteralAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "kind", "Set"
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
		  (getTerminologyBoxStatement__ModuleContext(), 
		   source, 
		   new String[] {
			 "code", "extent.terminologyBoxOfTerminologyBoxStatement.get(this)"
		   });	
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
			 "code", "extent.terminologyBoxOfTerminologyBoxStatement.get(this).flatMap(tbox => tbox.iri().map(i =>  gov.nasa.jpl.imce.oml.tables.taggedTypes.iri(i + \"#\" + name)))"
		   });	
		addAnnotation
		  (getTerm__AbbrevIRI(), 
		   source, 
		   new String[] {
			 "code", "extent.terminologyBoxOfTerminologyBoxStatement.get(this).map(tbox => tbox.nsPrefix+\":\"+name)"
		   });	
		addAnnotation
		  (getTerm__AllNestedElements(), 
		   source, 
		   new String[] {
			 "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });	
		addAnnotation
		  (getRuleBodySegment__Position(), 
		   source, 
		   new String[] {
			 "code", "previousSegment match { \n\t\t\t\t\tcase scala.None => \n\t\t\t\t\t\t1\n\t\t\t\t\tcase scala.Some(prev) => \n\t\t\t\t\t\t1 + prev.position()\n\t\t\t\t}"
		   });	
		addAnnotation
		  (getRuleBodySegment__ChainRule(), 
		   source, 
		   new String[] {
			 "code", "rule match {\n\t\t\t\t\tcase scala.Some(r) =>\n\t\t\t\t\t\tr\n\t\t\t\t\tcase scala.None =>\n\t\t\t\t\t\tpreviousSegment match {\n\t\t\t\t\t\t\tcase scala.Some(prev) =>\n\t\t\t\t\t\t\t\tprev.chainRule()\n\t\t\t\t\t\t\tcase scala.None =>\n\t\t\t\t\t\t\t\tthrow new java.lang.IllegalArgumentException(\"chainRule() must be well-defined\")\n\t\t\t\t\t\t}\t\t\t\t}"
		   });	
		addAnnotation
		  (getRuleBodySegment__Uuid(), 
		   source, 
		   new String[] {
			 "code", "namespaceUUID(\"RuleBodySegment\",  \n\t\t\"chainRule\" -> \n\t\t\trule.fold[scala.Predef.String]{ \n\t\t\t  previousSegment.fold[scala.Predef.String]{ throw new java.lang.IllegalArgumentException(\"rule or previousSegment must be non-empty\") }{ prev => \n\t\t\t\tprev.chainRule().uuid.toString\n\t\t\t  } \n\t\t\t}{ r => \n\t\t\t  r.uuid.toString },\n\t\t\"position\" -> \n\t\t\tpreviousSegment.fold[scala.Predef.String] { \n\t\t\t  \"1\" \n\t\t\t}{ prev => \n\t\t\t  (1 + prev.position()).toString \n\t\t\t})"
		   });	
		addAnnotation
		  (getRuleBodySegment__ModuleContext(), 
		   source, 
		   new String[] {
			 "code", "chainRule().moduleContext()"
		   });	
		addAnnotation
		  (getEntityRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });	
		addAnnotation
		  (getSpecializationAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
		   });	
		addAnnotation
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__TerminologyBox(), 
		   source, 
		   new String[] {
			 "code", "extent.terminologyBoxOfTerminologyBoxStatement.get(this)"
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyContext__AllNestedRestrictionElements(), 
		   source, 
		   new String[] {
			 "code", "extent.lookupStructuredDataPropertyRestrictions(this).flatMap{ r => scala.collection.immutable.Set.empty[resolver.api.LogicalElement] + r ++ r.allNestedRestrictionElements() } ++\n\t\textent.lookupScalarDataPropertyRestrictions(this)"
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__TerminologyBox(), 
		   source, 
		   new String[] {
			 "code", "extent.restrictionStructuredDataPropertyContextOfRestrictionStructuredDataPropertyTuple.get(this).flatMap(_.terminologyBox())"
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__ModuleContext(), 
		   source, 
		   new String[] {
			 "code", "extent.restrictionStructuredDataPropertyContextOfRestrictionStructuredDataPropertyTuple.get(this).flatMap(_.moduleContext)"
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue__TerminologyBox(), 
		   source, 
		   new String[] {
			 "code", "extent.restrictionStructuredDataPropertyContextOfRestrictionScalarDataPropertyValue.get(this).flatMap(_.terminologyBox())"
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue__ModuleContext(), 
		   source, 
		   new String[] {
			 "code", "extent.restrictionStructuredDataPropertyContextOfRestrictionScalarDataPropertyValue.get(this).flatMap(_.moduleContext)"
		   });	
		addAnnotation
		  (getScalarOneOfLiteralAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
			 "code", "scala.collection.immutable.Set.empty[resolver.api.LogicalElement]"
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
		  (getTerminologyBoxStatement__ModuleContext(), 
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
		  (getTerm__AllNestedElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRuleBodySegment__ModuleContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSegmentPredicate__ModuleContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSpecializationAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataPropertyRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__AllNestedElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyContext__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyContext__AllNestedRestrictionElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__ModuleContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__AllNestedElements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue__ModuleContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarOneOfLiteralAxiom__AllNestedElements(), 
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
		  (getTerminologyBoxStatement_Tbox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple_StructuredDataPropertyContext(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue_StructuredDataPropertyContext(), 
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
		  (getTerminologyExtensionAxiom__Target(), 
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
		addAnnotation
		  (entityStructuredDataPropertyParticularRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (restrictionStructuredDataPropertyContextEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (restrictionStructuredDataPropertyTupleEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (restrictionScalarDataPropertyValueEClass, 
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
		  (getAspectPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipPropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipInversePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSourcePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSourceInversePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipTargetPropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipTargetInversePropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getUnreifiedRelationshipPropertyPredicate__TermPredicate(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getUnreifiedRelationshipInversePropertyPredicate__TermPredicate(), 
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
		addAnnotation
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__TerminologyBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__TerminologyBox(), 
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
		  (getEntityStructuredDataPropertyParticularRestrictionAxiom__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionStructuredDataPropertyTuple__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRestrictionScalarDataPropertyValue__Uuid(), 
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
		addAnnotation
		  (getRuleBodySegment__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipPropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipInversePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSourcePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSourceInversePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipTargetPropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipTargetInversePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getUnreifiedRelationshipPropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getUnreifiedRelationshipInversePropertyPredicate__Uuid(), 
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
		addAnnotation
		  (getRuleBodySegment__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipPropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipInversePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSourcePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSourceInversePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipTargetPropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipTargetInversePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getUnreifiedRelationshipPropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getUnreifiedRelationshipInversePropertyPredicate__Uuid(), 
		   source, 
		   new String[] {
		   });
	}

} //TerminologiesPackageImpl
