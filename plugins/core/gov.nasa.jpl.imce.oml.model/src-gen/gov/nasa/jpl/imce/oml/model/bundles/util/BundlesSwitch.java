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
package gov.nasa.jpl.imce.oml.model.bundles.util;

import gov.nasa.jpl.imce.oml.model.bundles.*;

import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;
import gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;
import gov.nasa.jpl.imce.oml.model.common.Resource;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage
 * @generated
 */
public class BundlesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BundlesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundlesSwitch() {
		if (modelPackage == null) {
			modelPackage = BundlesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BundlesPackage.BUNDLE: {
				Bundle bundle = (Bundle)theEObject;
				T result = caseBundle(bundle);
				if (result == null) result = caseTerminologyBox(bundle);
				if (result == null) result = caseModule(bundle);
				if (result == null) result = caseResource(bundle);
				if (result == null) result = caseLogicalElement(bundle);
				if (result == null) result = caseIntrinsicIdentityKind(bundle);
				if (result == null) result = caseIdentityKind(bundle);
				if (result == null) result = caseCrossReferencableKind(bundle);
				if (result == null) result = caseCrossReferencabilityKind(bundle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BundlesPackage.TERMINOLOGY_BUNDLE_STATEMENT: {
				TerminologyBundleStatement terminologyBundleStatement = (TerminologyBundleStatement)theEObject;
				T result = caseTerminologyBundleStatement(terminologyBundleStatement);
				if (result == null) result = caseModuleElement(terminologyBundleStatement);
				if (result == null) result = caseLogicalElement(terminologyBundleStatement);
				if (result == null) result = caseIdentityKind(terminologyBundleStatement);
				if (result == null) result = caseCrossReferencabilityKind(terminologyBundleStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BundlesPackage.TERMINOLOGY_BUNDLE_AXIOM: {
				TerminologyBundleAxiom terminologyBundleAxiom = (TerminologyBundleAxiom)theEObject;
				T result = caseTerminologyBundleAxiom(terminologyBundleAxiom);
				if (result == null) result = caseTerminologyAxiom(terminologyBundleAxiom);
				if (result == null) result = caseModuleEdge(terminologyBundleAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(terminologyBundleAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(terminologyBundleAxiom);
				if (result == null) result = caseCrossReferencableKind(terminologyBundleAxiom);
				if (result == null) result = caseLogicalElement(terminologyBundleAxiom);
				if (result == null) result = caseIdentityKind(terminologyBundleAxiom);
				if (result == null) result = caseCrossReferencabilityKind(terminologyBundleAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BundlesPackage.CONCEPT_TREE_DISJUNCTION: {
				ConceptTreeDisjunction conceptTreeDisjunction = (ConceptTreeDisjunction)theEObject;
				T result = caseConceptTreeDisjunction(conceptTreeDisjunction);
				if (result == null) result = caseElementCrossReferenceTuple(conceptTreeDisjunction);
				if (result == null) result = caseExtrinsicIdentityKind(conceptTreeDisjunction);
				if (result == null) result = caseCrossReferencableKind(conceptTreeDisjunction);
				if (result == null) result = caseLogicalElement(conceptTreeDisjunction);
				if (result == null) result = caseIdentityKind(conceptTreeDisjunction);
				if (result == null) result = caseCrossReferencabilityKind(conceptTreeDisjunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BundlesPackage.DISJOINT_UNION_OF_CONCEPTS_AXIOM: {
				DisjointUnionOfConceptsAxiom disjointUnionOfConceptsAxiom = (DisjointUnionOfConceptsAxiom)theEObject;
				T result = caseDisjointUnionOfConceptsAxiom(disjointUnionOfConceptsAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(disjointUnionOfConceptsAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(disjointUnionOfConceptsAxiom);
				if (result == null) result = caseCrossReferencableKind(disjointUnionOfConceptsAxiom);
				if (result == null) result = caseLogicalElement(disjointUnionOfConceptsAxiom);
				if (result == null) result = caseIdentityKind(disjointUnionOfConceptsAxiom);
				if (result == null) result = caseCrossReferencabilityKind(disjointUnionOfConceptsAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM: {
				SpecificDisjointConceptAxiom specificDisjointConceptAxiom = (SpecificDisjointConceptAxiom)theEObject;
				T result = caseSpecificDisjointConceptAxiom(specificDisjointConceptAxiom);
				if (result == null) result = caseDisjointUnionOfConceptsAxiom(specificDisjointConceptAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(specificDisjointConceptAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(specificDisjointConceptAxiom);
				if (result == null) result = caseCrossReferencableKind(specificDisjointConceptAxiom);
				if (result == null) result = caseLogicalElement(specificDisjointConceptAxiom);
				if (result == null) result = caseIdentityKind(specificDisjointConceptAxiom);
				if (result == null) result = caseCrossReferencabilityKind(specificDisjointConceptAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM: {
				AnonymousConceptUnionAxiom anonymousConceptUnionAxiom = (AnonymousConceptUnionAxiom)theEObject;
				T result = caseAnonymousConceptUnionAxiom(anonymousConceptUnionAxiom);
				if (result == null) result = caseDisjointUnionOfConceptsAxiom(anonymousConceptUnionAxiom);
				if (result == null) result = caseConceptTreeDisjunction(anonymousConceptUnionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(anonymousConceptUnionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(anonymousConceptUnionAxiom);
				if (result == null) result = caseCrossReferencableKind(anonymousConceptUnionAxiom);
				if (result == null) result = caseLogicalElement(anonymousConceptUnionAxiom);
				if (result == null) result = caseIdentityKind(anonymousConceptUnionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(anonymousConceptUnionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM: {
				RootConceptTaxonomyAxiom rootConceptTaxonomyAxiom = (RootConceptTaxonomyAxiom)theEObject;
				T result = caseRootConceptTaxonomyAxiom(rootConceptTaxonomyAxiom);
				if (result == null) result = caseTerminologyBundleStatement(rootConceptTaxonomyAxiom);
				if (result == null) result = caseConceptTreeDisjunction(rootConceptTaxonomyAxiom);
				if (result == null) result = caseModuleElement(rootConceptTaxonomyAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(rootConceptTaxonomyAxiom);
				if (result == null) result = caseLogicalElement(rootConceptTaxonomyAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(rootConceptTaxonomyAxiom);
				if (result == null) result = caseCrossReferencableKind(rootConceptTaxonomyAxiom);
				if (result == null) result = caseIdentityKind(rootConceptTaxonomyAxiom);
				if (result == null) result = caseCrossReferencabilityKind(rootConceptTaxonomyAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM: {
				BundledTerminologyAxiom bundledTerminologyAxiom = (BundledTerminologyAxiom)theEObject;
				T result = caseBundledTerminologyAxiom(bundledTerminologyAxiom);
				if (result == null) result = caseTerminologyBundleAxiom(bundledTerminologyAxiom);
				if (result == null) result = caseTerminologyAxiom(bundledTerminologyAxiom);
				if (result == null) result = caseModuleEdge(bundledTerminologyAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(bundledTerminologyAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(bundledTerminologyAxiom);
				if (result == null) result = caseCrossReferencableKind(bundledTerminologyAxiom);
				if (result == null) result = caseLogicalElement(bundledTerminologyAxiom);
				if (result == null) result = caseIdentityKind(bundledTerminologyAxiom);
				if (result == null) result = caseCrossReferencabilityKind(bundledTerminologyAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBundle(Bundle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Bundle Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Bundle Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyBundleStatement(TerminologyBundleStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Bundle Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Bundle Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyBundleAxiom(TerminologyBundleAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Tree Disjunction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Tree Disjunction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptTreeDisjunction(ConceptTreeDisjunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disjoint Union Of Concepts Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disjoint Union Of Concepts Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisjointUnionOfConceptsAxiom(DisjointUnionOfConceptsAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Disjoint Concept Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Disjoint Concept Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificDisjointConceptAxiom(SpecificDisjointConceptAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anonymous Concept Union Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anonymous Concept Union Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnonymousConceptUnionAxiom(AnonymousConceptUnionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Concept Taxonomy Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Concept Taxonomy Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootConceptTaxonomyAxiom(RootConceptTaxonomyAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundled Terminology Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundled Terminology Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBundledTerminologyAxiom(BundledTerminologyAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cross Referencability Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cross Referencability Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCrossReferencabilityKind(CrossReferencabilityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentityKind(IdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalElement(LogicalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cross Referencable Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cross Referencable Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCrossReferencableKind(CrossReferencableKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intrinsic Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intrinsic Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntrinsicIdentityKind(IntrinsicIdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyBox(TerminologyBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleElement(ModuleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extrinsic Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extrinsic Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtrinsicIdentityKind(ExtrinsicIdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Cross Reference Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Cross Reference Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCrossReferenceTuple(ElementCrossReferenceTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleEdge(ModuleEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyAxiom(TerminologyAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //BundlesSwitch
