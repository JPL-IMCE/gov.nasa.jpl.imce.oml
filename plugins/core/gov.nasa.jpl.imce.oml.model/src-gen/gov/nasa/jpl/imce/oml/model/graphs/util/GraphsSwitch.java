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
package gov.nasa.jpl.imce.oml.model.graphs.util;

import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;
import gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.Resource;

import gov.nasa.jpl.imce.oml.model.graphs.*;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;

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
 * @see gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage
 * @generated
 */
public class GraphsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphsSwitch() {
		if (modelPackage == null) {
			modelPackage = GraphsPackage.eINSTANCE;
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
			case GraphsPackage.TERMINOLOGY_GRAPH: {
				TerminologyGraph terminologyGraph = (TerminologyGraph)theEObject;
				T result = caseTerminologyGraph(terminologyGraph);
				if (result == null) result = caseTerminologyBox(terminologyGraph);
				if (result == null) result = caseModule(terminologyGraph);
				if (result == null) result = caseResource(terminologyGraph);
				if (result == null) result = caseLogicalElement(terminologyGraph);
				if (result == null) result = caseIntrinsicIdentityKind(terminologyGraph);
				if (result == null) result = caseIdentityKind(terminologyGraph);
				if (result == null) result = caseCrossReferencableKind(terminologyGraph);
				if (result == null) result = caseCrossReferencabilityKind(terminologyGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM: {
				ConceptDesignationTerminologyAxiom conceptDesignationTerminologyAxiom = (ConceptDesignationTerminologyAxiom)theEObject;
				T result = caseConceptDesignationTerminologyAxiom(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseTerminologyBoxAxiom(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseTerminologyAxiom(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseModuleEdge(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseCrossReferencableKind(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseLogicalElement(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseIdentityKind(conceptDesignationTerminologyAxiom);
				if (result == null) result = caseCrossReferencabilityKind(conceptDesignationTerminologyAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM: {
				TerminologyNestingAxiom terminologyNestingAxiom = (TerminologyNestingAxiom)theEObject;
				T result = caseTerminologyNestingAxiom(terminologyNestingAxiom);
				if (result == null) result = caseTerminologyBoxAxiom(terminologyNestingAxiom);
				if (result == null) result = caseTerminologyAxiom(terminologyNestingAxiom);
				if (result == null) result = caseModuleEdge(terminologyNestingAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(terminologyNestingAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(terminologyNestingAxiom);
				if (result == null) result = caseCrossReferencableKind(terminologyNestingAxiom);
				if (result == null) result = caseLogicalElement(terminologyNestingAxiom);
				if (result == null) result = caseIdentityKind(terminologyNestingAxiom);
				if (result == null) result = caseCrossReferencabilityKind(terminologyNestingAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyGraph(TerminologyGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Designation Terminology Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Designation Terminology Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptDesignationTerminologyAxiom(ConceptDesignationTerminologyAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Nesting Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Nesting Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyNestingAxiom(TerminologyNestingAxiom object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Box Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Box Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyBoxAxiom(TerminologyBoxAxiom object) {
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

} //GraphsSwitch
