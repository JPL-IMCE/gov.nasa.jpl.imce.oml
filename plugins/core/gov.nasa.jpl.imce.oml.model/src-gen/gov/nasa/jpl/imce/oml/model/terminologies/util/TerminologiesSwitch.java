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
package gov.nasa.jpl.imce.oml.model.terminologies.util;

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
import gov.nasa.jpl.imce.oml.model.common.NonCrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.Resource;
import gov.nasa.jpl.imce.oml.model.common.ValueCrossReferenceTuple;

import gov.nasa.jpl.imce.oml.model.terminologies.*;

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
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
 * @generated
 */
public class TerminologiesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TerminologiesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologiesSwitch() {
		if (modelPackage == null) {
			modelPackage = TerminologiesPackage.eINSTANCE;
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
			case TerminologiesPackage.TERMINOLOGY_BOX: {
				TerminologyBox terminologyBox = (TerminologyBox)theEObject;
				T result = caseTerminologyBox(terminologyBox);
				if (result == null) result = caseModule(terminologyBox);
				if (result == null) result = caseResource(terminologyBox);
				if (result == null) result = caseLogicalElement(terminologyBox);
				if (result == null) result = caseIntrinsicIdentityKind(terminologyBox);
				if (result == null) result = caseIdentityKind(terminologyBox);
				if (result == null) result = caseCrossReferencableKind(terminologyBox);
				if (result == null) result = caseCrossReferencabilityKind(terminologyBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.TERMINOLOGY_BOX_STATEMENT: {
				TerminologyBoxStatement terminologyBoxStatement = (TerminologyBoxStatement)theEObject;
				T result = caseTerminologyBoxStatement(terminologyBoxStatement);
				if (result == null) result = caseModuleElement(terminologyBoxStatement);
				if (result == null) result = caseLogicalElement(terminologyBoxStatement);
				if (result == null) result = caseIdentityKind(terminologyBoxStatement);
				if (result == null) result = caseCrossReferencabilityKind(terminologyBoxStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.TERMINOLOGY_AXIOM: {
				TerminologyAxiom terminologyAxiom = (TerminologyAxiom)theEObject;
				T result = caseTerminologyAxiom(terminologyAxiom);
				if (result == null) result = caseModuleEdge(terminologyAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(terminologyAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(terminologyAxiom);
				if (result == null) result = caseCrossReferencableKind(terminologyAxiom);
				if (result == null) result = caseLogicalElement(terminologyAxiom);
				if (result == null) result = caseIdentityKind(terminologyAxiom);
				if (result == null) result = caseCrossReferencabilityKind(terminologyAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.TERMINOLOGY_BOX_AXIOM: {
				TerminologyBoxAxiom terminologyBoxAxiom = (TerminologyBoxAxiom)theEObject;
				T result = caseTerminologyBoxAxiom(terminologyBoxAxiom);
				if (result == null) result = caseTerminologyAxiom(terminologyBoxAxiom);
				if (result == null) result = caseModuleEdge(terminologyBoxAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(terminologyBoxAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(terminologyBoxAxiom);
				if (result == null) result = caseCrossReferencableKind(terminologyBoxAxiom);
				if (result == null) result = caseLogicalElement(terminologyBoxAxiom);
				if (result == null) result = caseIdentityKind(terminologyBoxAxiom);
				if (result == null) result = caseCrossReferencabilityKind(terminologyBoxAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.TERMINOLOGY_EXTENSION_AXIOM: {
				TerminologyExtensionAxiom terminologyExtensionAxiom = (TerminologyExtensionAxiom)theEObject;
				T result = caseTerminologyExtensionAxiom(terminologyExtensionAxiom);
				if (result == null) result = caseTerminologyBoxAxiom(terminologyExtensionAxiom);
				if (result == null) result = caseTerminologyAxiom(terminologyExtensionAxiom);
				if (result == null) result = caseModuleEdge(terminologyExtensionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(terminologyExtensionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(terminologyExtensionAxiom);
				if (result == null) result = caseCrossReferencableKind(terminologyExtensionAxiom);
				if (result == null) result = caseLogicalElement(terminologyExtensionAxiom);
				if (result == null) result = caseIdentityKind(terminologyExtensionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(terminologyExtensionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = caseTerminologyBoxStatement(term);
				if (result == null) result = caseResource(term);
				if (result == null) result = caseModuleElement(term);
				if (result == null) result = caseIntrinsicIdentityKind(term);
				if (result == null) result = caseLogicalElement(term);
				if (result == null) result = caseCrossReferencableKind(term);
				if (result == null) result = caseIdentityKind(term);
				if (result == null) result = caseCrossReferencabilityKind(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.UNARY_TERM_KIND: {
				UnaryTermKind unaryTermKind = (UnaryTermKind)theEObject;
				T result = caseUnaryTermKind(unaryTermKind);
				if (result == null) result = caseTerm(unaryTermKind);
				if (result == null) result = caseTerminologyBoxStatement(unaryTermKind);
				if (result == null) result = caseResource(unaryTermKind);
				if (result == null) result = caseModuleElement(unaryTermKind);
				if (result == null) result = caseIntrinsicIdentityKind(unaryTermKind);
				if (result == null) result = caseLogicalElement(unaryTermKind);
				if (result == null) result = caseCrossReferencableKind(unaryTermKind);
				if (result == null) result = caseIdentityKind(unaryTermKind);
				if (result == null) result = caseCrossReferencabilityKind(unaryTermKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DIRECTED_BINARY_RELATIONSHIP_KIND: {
				DirectedBinaryRelationshipKind directedBinaryRelationshipKind = (DirectedBinaryRelationshipKind)theEObject;
				T result = caseDirectedBinaryRelationshipKind(directedBinaryRelationshipKind);
				if (result == null) result = caseTerm(directedBinaryRelationshipKind);
				if (result == null) result = caseTerminologyBoxStatement(directedBinaryRelationshipKind);
				if (result == null) result = caseResource(directedBinaryRelationshipKind);
				if (result == null) result = caseModuleElement(directedBinaryRelationshipKind);
				if (result == null) result = caseIntrinsicIdentityKind(directedBinaryRelationshipKind);
				if (result == null) result = caseLogicalElement(directedBinaryRelationshipKind);
				if (result == null) result = caseCrossReferencableKind(directedBinaryRelationshipKind);
				if (result == null) result = caseIdentityKind(directedBinaryRelationshipKind);
				if (result == null) result = caseCrossReferencabilityKind(directedBinaryRelationshipKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY: {
				Entity entity = (Entity)theEObject;
				T result = caseEntity(entity);
				if (result == null) result = caseTerm(entity);
				if (result == null) result = caseTerminologyBoxStatement(entity);
				if (result == null) result = caseResource(entity);
				if (result == null) result = caseModuleElement(entity);
				if (result == null) result = caseIntrinsicIdentityKind(entity);
				if (result == null) result = caseLogicalElement(entity);
				if (result == null) result = caseCrossReferencableKind(entity);
				if (result == null) result = caseIdentityKind(entity);
				if (result == null) result = caseCrossReferencabilityKind(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.CONCEPTUAL_ENTITY: {
				ConceptualEntity conceptualEntity = (ConceptualEntity)theEObject;
				T result = caseConceptualEntity(conceptualEntity);
				if (result == null) result = caseEntity(conceptualEntity);
				if (result == null) result = caseTerm(conceptualEntity);
				if (result == null) result = caseTerminologyBoxStatement(conceptualEntity);
				if (result == null) result = caseResource(conceptualEntity);
				if (result == null) result = caseModuleElement(conceptualEntity);
				if (result == null) result = caseIntrinsicIdentityKind(conceptualEntity);
				if (result == null) result = caseLogicalElement(conceptualEntity);
				if (result == null) result = caseCrossReferencableKind(conceptualEntity);
				if (result == null) result = caseIdentityKind(conceptualEntity);
				if (result == null) result = caseCrossReferencabilityKind(conceptualEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ASPECT: {
				Aspect aspect = (Aspect)theEObject;
				T result = caseAspect(aspect);
				if (result == null) result = caseEntity(aspect);
				if (result == null) result = caseUnaryTermKind(aspect);
				if (result == null) result = caseTerm(aspect);
				if (result == null) result = caseTerminologyBoxStatement(aspect);
				if (result == null) result = caseResource(aspect);
				if (result == null) result = caseModuleElement(aspect);
				if (result == null) result = caseIntrinsicIdentityKind(aspect);
				if (result == null) result = caseLogicalElement(aspect);
				if (result == null) result = caseCrossReferencableKind(aspect);
				if (result == null) result = caseIdentityKind(aspect);
				if (result == null) result = caseCrossReferencabilityKind(aspect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.CONCEPT: {
				Concept concept = (Concept)theEObject;
				T result = caseConcept(concept);
				if (result == null) result = caseConceptualEntity(concept);
				if (result == null) result = caseUnaryTermKind(concept);
				if (result == null) result = caseEntity(concept);
				if (result == null) result = caseTerm(concept);
				if (result == null) result = caseTerminologyBoxStatement(concept);
				if (result == null) result = caseResource(concept);
				if (result == null) result = caseModuleElement(concept);
				if (result == null) result = caseIntrinsicIdentityKind(concept);
				if (result == null) result = caseLogicalElement(concept);
				if (result == null) result = caseCrossReferencableKind(concept);
				if (result == null) result = caseIdentityKind(concept);
				if (result == null) result = caseCrossReferencabilityKind(concept);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_RELATIONSHIP: {
				EntityRelationship entityRelationship = (EntityRelationship)theEObject;
				T result = caseEntityRelationship(entityRelationship);
				if (result == null) result = caseDirectedBinaryRelationshipKind(entityRelationship);
				if (result == null) result = caseTerm(entityRelationship);
				if (result == null) result = caseTerminologyBoxStatement(entityRelationship);
				if (result == null) result = caseResource(entityRelationship);
				if (result == null) result = caseModuleElement(entityRelationship);
				if (result == null) result = caseIntrinsicIdentityKind(entityRelationship);
				if (result == null) result = caseLogicalElement(entityRelationship);
				if (result == null) result = caseCrossReferencableKind(entityRelationship);
				if (result == null) result = caseIdentityKind(entityRelationship);
				if (result == null) result = caseCrossReferencabilityKind(entityRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP: {
				ReifiedRelationship reifiedRelationship = (ReifiedRelationship)theEObject;
				T result = caseReifiedRelationship(reifiedRelationship);
				if (result == null) result = caseEntityRelationship(reifiedRelationship);
				if (result == null) result = caseConceptualEntity(reifiedRelationship);
				if (result == null) result = caseDirectedBinaryRelationshipKind(reifiedRelationship);
				if (result == null) result = caseEntity(reifiedRelationship);
				if (result == null) result = caseTerm(reifiedRelationship);
				if (result == null) result = caseTerminologyBoxStatement(reifiedRelationship);
				if (result == null) result = caseResource(reifiedRelationship);
				if (result == null) result = caseModuleElement(reifiedRelationship);
				if (result == null) result = caseIntrinsicIdentityKind(reifiedRelationship);
				if (result == null) result = caseLogicalElement(reifiedRelationship);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationship);
				if (result == null) result = caseIdentityKind(reifiedRelationship);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP: {
				UnreifiedRelationship unreifiedRelationship = (UnreifiedRelationship)theEObject;
				T result = caseUnreifiedRelationship(unreifiedRelationship);
				if (result == null) result = caseEntityRelationship(unreifiedRelationship);
				if (result == null) result = caseDirectedBinaryRelationshipKind(unreifiedRelationship);
				if (result == null) result = caseTerm(unreifiedRelationship);
				if (result == null) result = caseTerminologyBoxStatement(unreifiedRelationship);
				if (result == null) result = caseResource(unreifiedRelationship);
				if (result == null) result = caseModuleElement(unreifiedRelationship);
				if (result == null) result = caseIntrinsicIdentityKind(unreifiedRelationship);
				if (result == null) result = caseLogicalElement(unreifiedRelationship);
				if (result == null) result = caseCrossReferencableKind(unreifiedRelationship);
				if (result == null) result = caseIdentityKind(unreifiedRelationship);
				if (result == null) result = caseCrossReferencabilityKind(unreifiedRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATATYPE: {
				Datatype datatype = (Datatype)theEObject;
				T result = caseDatatype(datatype);
				if (result == null) result = caseTerm(datatype);
				if (result == null) result = caseTerminologyBoxStatement(datatype);
				if (result == null) result = caseResource(datatype);
				if (result == null) result = caseModuleElement(datatype);
				if (result == null) result = caseIntrinsicIdentityKind(datatype);
				if (result == null) result = caseLogicalElement(datatype);
				if (result == null) result = caseCrossReferencableKind(datatype);
				if (result == null) result = caseIdentityKind(datatype);
				if (result == null) result = caseCrossReferencabilityKind(datatype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATA_RANGE: {
				DataRange dataRange = (DataRange)theEObject;
				T result = caseDataRange(dataRange);
				if (result == null) result = caseDatatype(dataRange);
				if (result == null) result = caseTerm(dataRange);
				if (result == null) result = caseTerminologyBoxStatement(dataRange);
				if (result == null) result = caseResource(dataRange);
				if (result == null) result = caseModuleElement(dataRange);
				if (result == null) result = caseIntrinsicIdentityKind(dataRange);
				if (result == null) result = caseLogicalElement(dataRange);
				if (result == null) result = caseCrossReferencableKind(dataRange);
				if (result == null) result = caseIdentityKind(dataRange);
				if (result == null) result = caseCrossReferencabilityKind(dataRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SCALAR: {
				Scalar scalar = (Scalar)theEObject;
				T result = caseScalar(scalar);
				if (result == null) result = caseDataRange(scalar);
				if (result == null) result = caseUnaryTermKind(scalar);
				if (result == null) result = caseDatatype(scalar);
				if (result == null) result = caseTerm(scalar);
				if (result == null) result = caseTerminologyBoxStatement(scalar);
				if (result == null) result = caseResource(scalar);
				if (result == null) result = caseModuleElement(scalar);
				if (result == null) result = caseIntrinsicIdentityKind(scalar);
				if (result == null) result = caseLogicalElement(scalar);
				if (result == null) result = caseCrossReferencableKind(scalar);
				if (result == null) result = caseIdentityKind(scalar);
				if (result == null) result = caseCrossReferencabilityKind(scalar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATA_RELATIONSHIP: {
				DataRelationship dataRelationship = (DataRelationship)theEObject;
				T result = caseDataRelationship(dataRelationship);
				if (result == null) result = caseDirectedBinaryRelationshipKind(dataRelationship);
				if (result == null) result = caseTerm(dataRelationship);
				if (result == null) result = caseTerminologyBoxStatement(dataRelationship);
				if (result == null) result = caseResource(dataRelationship);
				if (result == null) result = caseModuleElement(dataRelationship);
				if (result == null) result = caseIntrinsicIdentityKind(dataRelationship);
				if (result == null) result = caseLogicalElement(dataRelationship);
				if (result == null) result = caseCrossReferencableKind(dataRelationship);
				if (result == null) result = caseIdentityKind(dataRelationship);
				if (result == null) result = caseCrossReferencabilityKind(dataRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATA_RELATIONSHIP_DOMAIN: {
				DataRelationshipDomain dataRelationshipDomain = (DataRelationshipDomain)theEObject;
				T result = caseDataRelationshipDomain(dataRelationshipDomain);
				if (result == null) result = caseDataRelationship(dataRelationshipDomain);
				if (result == null) result = caseDirectedBinaryRelationshipKind(dataRelationshipDomain);
				if (result == null) result = caseTerm(dataRelationshipDomain);
				if (result == null) result = caseTerminologyBoxStatement(dataRelationshipDomain);
				if (result == null) result = caseResource(dataRelationshipDomain);
				if (result == null) result = caseModuleElement(dataRelationshipDomain);
				if (result == null) result = caseIntrinsicIdentityKind(dataRelationshipDomain);
				if (result == null) result = caseLogicalElement(dataRelationshipDomain);
				if (result == null) result = caseCrossReferencableKind(dataRelationshipDomain);
				if (result == null) result = caseIdentityKind(dataRelationshipDomain);
				if (result == null) result = caseCrossReferencabilityKind(dataRelationshipDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_ENTITY: {
				DataRelationshipFromEntity dataRelationshipFromEntity = (DataRelationshipFromEntity)theEObject;
				T result = caseDataRelationshipFromEntity(dataRelationshipFromEntity);
				if (result == null) result = caseDataRelationshipDomain(dataRelationshipFromEntity);
				if (result == null) result = caseDataRelationship(dataRelationshipFromEntity);
				if (result == null) result = caseDirectedBinaryRelationshipKind(dataRelationshipFromEntity);
				if (result == null) result = caseTerm(dataRelationshipFromEntity);
				if (result == null) result = caseTerminologyBoxStatement(dataRelationshipFromEntity);
				if (result == null) result = caseResource(dataRelationshipFromEntity);
				if (result == null) result = caseModuleElement(dataRelationshipFromEntity);
				if (result == null) result = caseIntrinsicIdentityKind(dataRelationshipFromEntity);
				if (result == null) result = caseLogicalElement(dataRelationshipFromEntity);
				if (result == null) result = caseCrossReferencableKind(dataRelationshipFromEntity);
				if (result == null) result = caseIdentityKind(dataRelationshipFromEntity);
				if (result == null) result = caseCrossReferencabilityKind(dataRelationshipFromEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATA_RELATIONSHIP_FROM_STRUCTURE: {
				DataRelationshipFromStructure dataRelationshipFromStructure = (DataRelationshipFromStructure)theEObject;
				T result = caseDataRelationshipFromStructure(dataRelationshipFromStructure);
				if (result == null) result = caseDataRelationshipDomain(dataRelationshipFromStructure);
				if (result == null) result = caseDataRelationship(dataRelationshipFromStructure);
				if (result == null) result = caseDirectedBinaryRelationshipKind(dataRelationshipFromStructure);
				if (result == null) result = caseTerm(dataRelationshipFromStructure);
				if (result == null) result = caseTerminologyBoxStatement(dataRelationshipFromStructure);
				if (result == null) result = caseResource(dataRelationshipFromStructure);
				if (result == null) result = caseModuleElement(dataRelationshipFromStructure);
				if (result == null) result = caseIntrinsicIdentityKind(dataRelationshipFromStructure);
				if (result == null) result = caseLogicalElement(dataRelationshipFromStructure);
				if (result == null) result = caseCrossReferencableKind(dataRelationshipFromStructure);
				if (result == null) result = caseIdentityKind(dataRelationshipFromStructure);
				if (result == null) result = caseCrossReferencabilityKind(dataRelationshipFromStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATA_RELATIONSHIP_RANGE: {
				DataRelationshipRange dataRelationshipRange = (DataRelationshipRange)theEObject;
				T result = caseDataRelationshipRange(dataRelationshipRange);
				if (result == null) result = caseDataRelationship(dataRelationshipRange);
				if (result == null) result = caseDirectedBinaryRelationshipKind(dataRelationshipRange);
				if (result == null) result = caseTerm(dataRelationshipRange);
				if (result == null) result = caseTerminologyBoxStatement(dataRelationshipRange);
				if (result == null) result = caseResource(dataRelationshipRange);
				if (result == null) result = caseModuleElement(dataRelationshipRange);
				if (result == null) result = caseIntrinsicIdentityKind(dataRelationshipRange);
				if (result == null) result = caseLogicalElement(dataRelationshipRange);
				if (result == null) result = caseCrossReferencableKind(dataRelationshipRange);
				if (result == null) result = caseIdentityKind(dataRelationshipRange);
				if (result == null) result = caseCrossReferencabilityKind(dataRelationshipRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATA_RELATIONSHIP_TO_SCALAR: {
				DataRelationshipToScalar dataRelationshipToScalar = (DataRelationshipToScalar)theEObject;
				T result = caseDataRelationshipToScalar(dataRelationshipToScalar);
				if (result == null) result = caseDataRelationshipRange(dataRelationshipToScalar);
				if (result == null) result = caseDataRelationship(dataRelationshipToScalar);
				if (result == null) result = caseDirectedBinaryRelationshipKind(dataRelationshipToScalar);
				if (result == null) result = caseTerm(dataRelationshipToScalar);
				if (result == null) result = caseTerminologyBoxStatement(dataRelationshipToScalar);
				if (result == null) result = caseResource(dataRelationshipToScalar);
				if (result == null) result = caseModuleElement(dataRelationshipToScalar);
				if (result == null) result = caseIntrinsicIdentityKind(dataRelationshipToScalar);
				if (result == null) result = caseLogicalElement(dataRelationshipToScalar);
				if (result == null) result = caseCrossReferencableKind(dataRelationshipToScalar);
				if (result == null) result = caseIdentityKind(dataRelationshipToScalar);
				if (result == null) result = caseCrossReferencabilityKind(dataRelationshipToScalar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.DATA_RELATIONSHIP_TO_STRUCTURE: {
				DataRelationshipToStructure dataRelationshipToStructure = (DataRelationshipToStructure)theEObject;
				T result = caseDataRelationshipToStructure(dataRelationshipToStructure);
				if (result == null) result = caseDataRelationshipRange(dataRelationshipToStructure);
				if (result == null) result = caseDataRelationship(dataRelationshipToStructure);
				if (result == null) result = caseDirectedBinaryRelationshipKind(dataRelationshipToStructure);
				if (result == null) result = caseTerm(dataRelationshipToStructure);
				if (result == null) result = caseTerminologyBoxStatement(dataRelationshipToStructure);
				if (result == null) result = caseResource(dataRelationshipToStructure);
				if (result == null) result = caseModuleElement(dataRelationshipToStructure);
				if (result == null) result = caseIntrinsicIdentityKind(dataRelationshipToStructure);
				if (result == null) result = caseLogicalElement(dataRelationshipToStructure);
				if (result == null) result = caseCrossReferencableKind(dataRelationshipToStructure);
				if (result == null) result = caseIdentityKind(dataRelationshipToStructure);
				if (result == null) result = caseCrossReferencabilityKind(dataRelationshipToStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY: {
				EntityStructuredDataProperty entityStructuredDataProperty = (EntityStructuredDataProperty)theEObject;
				T result = caseEntityStructuredDataProperty(entityStructuredDataProperty);
				if (result == null) result = caseDataRelationshipFromEntity(entityStructuredDataProperty);
				if (result == null) result = caseDataRelationshipToStructure(entityStructuredDataProperty);
				if (result == null) result = caseDirectedBinaryRelationshipKind(entityStructuredDataProperty);
				if (result == null) result = caseDataRelationshipDomain(entityStructuredDataProperty);
				if (result == null) result = caseDataRelationshipRange(entityStructuredDataProperty);
				if (result == null) result = caseDataRelationship(entityStructuredDataProperty);
				if (result == null) result = caseTerm(entityStructuredDataProperty);
				if (result == null) result = caseTerminologyBoxStatement(entityStructuredDataProperty);
				if (result == null) result = caseResource(entityStructuredDataProperty);
				if (result == null) result = caseModuleElement(entityStructuredDataProperty);
				if (result == null) result = caseIntrinsicIdentityKind(entityStructuredDataProperty);
				if (result == null) result = caseLogicalElement(entityStructuredDataProperty);
				if (result == null) result = caseCrossReferencableKind(entityStructuredDataProperty);
				if (result == null) result = caseIdentityKind(entityStructuredDataProperty);
				if (result == null) result = caseCrossReferencabilityKind(entityStructuredDataProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY: {
				EntityScalarDataProperty entityScalarDataProperty = (EntityScalarDataProperty)theEObject;
				T result = caseEntityScalarDataProperty(entityScalarDataProperty);
				if (result == null) result = caseDataRelationshipFromEntity(entityScalarDataProperty);
				if (result == null) result = caseDataRelationshipToScalar(entityScalarDataProperty);
				if (result == null) result = caseDirectedBinaryRelationshipKind(entityScalarDataProperty);
				if (result == null) result = caseDataRelationshipDomain(entityScalarDataProperty);
				if (result == null) result = caseDataRelationshipRange(entityScalarDataProperty);
				if (result == null) result = caseDataRelationship(entityScalarDataProperty);
				if (result == null) result = caseTerm(entityScalarDataProperty);
				if (result == null) result = caseTerminologyBoxStatement(entityScalarDataProperty);
				if (result == null) result = caseResource(entityScalarDataProperty);
				if (result == null) result = caseModuleElement(entityScalarDataProperty);
				if (result == null) result = caseIntrinsicIdentityKind(entityScalarDataProperty);
				if (result == null) result = caseLogicalElement(entityScalarDataProperty);
				if (result == null) result = caseCrossReferencableKind(entityScalarDataProperty);
				if (result == null) result = caseIdentityKind(entityScalarDataProperty);
				if (result == null) result = caseCrossReferencabilityKind(entityScalarDataProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.STRUCTURED_DATA_PROPERTY: {
				StructuredDataProperty structuredDataProperty = (StructuredDataProperty)theEObject;
				T result = caseStructuredDataProperty(structuredDataProperty);
				if (result == null) result = caseDataRelationshipFromStructure(structuredDataProperty);
				if (result == null) result = caseDataRelationshipToStructure(structuredDataProperty);
				if (result == null) result = caseDirectedBinaryRelationshipKind(structuredDataProperty);
				if (result == null) result = caseDataRelationshipDomain(structuredDataProperty);
				if (result == null) result = caseDataRelationshipRange(structuredDataProperty);
				if (result == null) result = caseDataRelationship(structuredDataProperty);
				if (result == null) result = caseTerm(structuredDataProperty);
				if (result == null) result = caseTerminologyBoxStatement(structuredDataProperty);
				if (result == null) result = caseResource(structuredDataProperty);
				if (result == null) result = caseModuleElement(structuredDataProperty);
				if (result == null) result = caseIntrinsicIdentityKind(structuredDataProperty);
				if (result == null) result = caseLogicalElement(structuredDataProperty);
				if (result == null) result = caseCrossReferencableKind(structuredDataProperty);
				if (result == null) result = caseIdentityKind(structuredDataProperty);
				if (result == null) result = caseCrossReferencabilityKind(structuredDataProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SCALAR_DATA_PROPERTY: {
				ScalarDataProperty scalarDataProperty = (ScalarDataProperty)theEObject;
				T result = caseScalarDataProperty(scalarDataProperty);
				if (result == null) result = caseDataRelationshipFromStructure(scalarDataProperty);
				if (result == null) result = caseDataRelationshipToScalar(scalarDataProperty);
				if (result == null) result = caseDirectedBinaryRelationshipKind(scalarDataProperty);
				if (result == null) result = caseDataRelationshipDomain(scalarDataProperty);
				if (result == null) result = caseDataRelationshipRange(scalarDataProperty);
				if (result == null) result = caseDataRelationship(scalarDataProperty);
				if (result == null) result = caseTerm(scalarDataProperty);
				if (result == null) result = caseTerminologyBoxStatement(scalarDataProperty);
				if (result == null) result = caseResource(scalarDataProperty);
				if (result == null) result = caseModuleElement(scalarDataProperty);
				if (result == null) result = caseIntrinsicIdentityKind(scalarDataProperty);
				if (result == null) result = caseLogicalElement(scalarDataProperty);
				if (result == null) result = caseCrossReferencableKind(scalarDataProperty);
				if (result == null) result = caseIdentityKind(scalarDataProperty);
				if (result == null) result = caseCrossReferencabilityKind(scalarDataProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.STRUCTURE: {
				Structure structure = (Structure)theEObject;
				T result = caseStructure(structure);
				if (result == null) result = caseDatatype(structure);
				if (result == null) result = caseUnaryTermKind(structure);
				if (result == null) result = caseTerm(structure);
				if (result == null) result = caseTerminologyBoxStatement(structure);
				if (result == null) result = caseResource(structure);
				if (result == null) result = caseModuleElement(structure);
				if (result == null) result = caseIntrinsicIdentityKind(structure);
				if (result == null) result = caseLogicalElement(structure);
				if (result == null) result = caseCrossReferencableKind(structure);
				if (result == null) result = caseIdentityKind(structure);
				if (result == null) result = caseCrossReferencabilityKind(structure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseTerm(rule);
				if (result == null) result = caseTerminologyBoxStatement(rule);
				if (result == null) result = caseResource(rule);
				if (result == null) result = caseModuleElement(rule);
				if (result == null) result = caseIntrinsicIdentityKind(rule);
				if (result == null) result = caseLogicalElement(rule);
				if (result == null) result = caseCrossReferencableKind(rule);
				if (result == null) result = caseIdentityKind(rule);
				if (result == null) result = caseCrossReferencabilityKind(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.CHAIN_RULE: {
				ChainRule chainRule = (ChainRule)theEObject;
				T result = caseChainRule(chainRule);
				if (result == null) result = caseRule(chainRule);
				if (result == null) result = caseTerm(chainRule);
				if (result == null) result = caseTerminologyBoxStatement(chainRule);
				if (result == null) result = caseResource(chainRule);
				if (result == null) result = caseModuleElement(chainRule);
				if (result == null) result = caseIntrinsicIdentityKind(chainRule);
				if (result == null) result = caseLogicalElement(chainRule);
				if (result == null) result = caseCrossReferencableKind(chainRule);
				if (result == null) result = caseIdentityKind(chainRule);
				if (result == null) result = caseCrossReferencabilityKind(chainRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.RULE_BODY_SEGMENT: {
				RuleBodySegment ruleBodySegment = (RuleBodySegment)theEObject;
				T result = caseRuleBodySegment(ruleBodySegment);
				if (result == null) result = caseElementCrossReferenceTuple(ruleBodySegment);
				if (result == null) result = caseExtrinsicIdentityKind(ruleBodySegment);
				if (result == null) result = caseCrossReferencableKind(ruleBodySegment);
				if (result == null) result = caseLogicalElement(ruleBodySegment);
				if (result == null) result = caseIdentityKind(ruleBodySegment);
				if (result == null) result = caseCrossReferencabilityKind(ruleBodySegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SEGMENT_PREDICATE: {
				SegmentPredicate segmentPredicate = (SegmentPredicate)theEObject;
				T result = caseSegmentPredicate(segmentPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(segmentPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(segmentPredicate);
				if (result == null) result = caseCrossReferencableKind(segmentPredicate);
				if (result == null) result = caseLogicalElement(segmentPredicate);
				if (result == null) result = caseIdentityKind(segmentPredicate);
				if (result == null) result = caseCrossReferencabilityKind(segmentPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.UNARY_SEGMENT_PREDICATE: {
				UnarySegmentPredicate unarySegmentPredicate = (UnarySegmentPredicate)theEObject;
				T result = caseUnarySegmentPredicate(unarySegmentPredicate);
				if (result == null) result = caseSegmentPredicate(unarySegmentPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(unarySegmentPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(unarySegmentPredicate);
				if (result == null) result = caseCrossReferencableKind(unarySegmentPredicate);
				if (result == null) result = caseLogicalElement(unarySegmentPredicate);
				if (result == null) result = caseIdentityKind(unarySegmentPredicate);
				if (result == null) result = caseCrossReferencabilityKind(unarySegmentPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ASPECT_PREDICATE: {
				AspectPredicate aspectPredicate = (AspectPredicate)theEObject;
				T result = caseAspectPredicate(aspectPredicate);
				if (result == null) result = caseUnarySegmentPredicate(aspectPredicate);
				if (result == null) result = caseSegmentPredicate(aspectPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(aspectPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(aspectPredicate);
				if (result == null) result = caseCrossReferencableKind(aspectPredicate);
				if (result == null) result = caseLogicalElement(aspectPredicate);
				if (result == null) result = caseIdentityKind(aspectPredicate);
				if (result == null) result = caseCrossReferencabilityKind(aspectPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.CONCEPT_PREDICATE: {
				ConceptPredicate conceptPredicate = (ConceptPredicate)theEObject;
				T result = caseConceptPredicate(conceptPredicate);
				if (result == null) result = caseUnarySegmentPredicate(conceptPredicate);
				if (result == null) result = caseSegmentPredicate(conceptPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(conceptPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(conceptPredicate);
				if (result == null) result = caseCrossReferencableKind(conceptPredicate);
				if (result == null) result = caseLogicalElement(conceptPredicate);
				if (result == null) result = caseIdentityKind(conceptPredicate);
				if (result == null) result = caseCrossReferencabilityKind(conceptPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP_PREDICATE: {
				ReifiedRelationshipPredicate reifiedRelationshipPredicate = (ReifiedRelationshipPredicate)theEObject;
				T result = caseReifiedRelationshipPredicate(reifiedRelationshipPredicate);
				if (result == null) result = caseUnarySegmentPredicate(reifiedRelationshipPredicate);
				if (result == null) result = caseSegmentPredicate(reifiedRelationshipPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipPredicate);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipPredicate);
				if (result == null) result = caseLogicalElement(reifiedRelationshipPredicate);
				if (result == null) result = caseIdentityKind(reifiedRelationshipPredicate);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.BINARY_SEGMENT_PROPERTY_PREDICATE: {
				BinarySegmentPropertyPredicate binarySegmentPropertyPredicate = (BinarySegmentPropertyPredicate)theEObject;
				T result = caseBinarySegmentPropertyPredicate(binarySegmentPropertyPredicate);
				if (result == null) result = caseSegmentPredicate(binarySegmentPropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(binarySegmentPropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(binarySegmentPropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(binarySegmentPropertyPredicate);
				if (result == null) result = caseLogicalElement(binarySegmentPropertyPredicate);
				if (result == null) result = caseIdentityKind(binarySegmentPropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(binarySegmentPropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.BINARY_SEGMENT_FORWARD_PROPERTY_PREDICATE: {
				BinarySegmentForwardPropertyPredicate binarySegmentForwardPropertyPredicate = (BinarySegmentForwardPropertyPredicate)theEObject;
				T result = caseBinarySegmentForwardPropertyPredicate(binarySegmentForwardPropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(binarySegmentForwardPropertyPredicate);
				if (result == null) result = caseSegmentPredicate(binarySegmentForwardPropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(binarySegmentForwardPropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(binarySegmentForwardPropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(binarySegmentForwardPropertyPredicate);
				if (result == null) result = caseLogicalElement(binarySegmentForwardPropertyPredicate);
				if (result == null) result = caseIdentityKind(binarySegmentForwardPropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(binarySegmentForwardPropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.BINARY_SEGMENT_REVERSE_PROPERTY_PREDICATE: {
				BinarySegmentReversePropertyPredicate binarySegmentReversePropertyPredicate = (BinarySegmentReversePropertyPredicate)theEObject;
				T result = caseBinarySegmentReversePropertyPredicate(binarySegmentReversePropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(binarySegmentReversePropertyPredicate);
				if (result == null) result = caseSegmentPredicate(binarySegmentReversePropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(binarySegmentReversePropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(binarySegmentReversePropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(binarySegmentReversePropertyPredicate);
				if (result == null) result = caseLogicalElement(binarySegmentReversePropertyPredicate);
				if (result == null) result = caseIdentityKind(binarySegmentReversePropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(binarySegmentReversePropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP_PROPERTY_PREDICATE: {
				ReifiedRelationshipPropertyPredicate reifiedRelationshipPropertyPredicate = (ReifiedRelationshipPropertyPredicate)theEObject;
				T result = caseReifiedRelationshipPropertyPredicate(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseBinarySegmentForwardPropertyPredicate(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseSegmentPredicate(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseLogicalElement(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseIdentityKind(reifiedRelationshipPropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipPropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE: {
				ReifiedRelationshipInversePropertyPredicate reifiedRelationshipInversePropertyPredicate = (ReifiedRelationshipInversePropertyPredicate)theEObject;
				T result = caseReifiedRelationshipInversePropertyPredicate(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseBinarySegmentReversePropertyPredicate(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseSegmentPredicate(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseLogicalElement(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseIdentityKind(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipInversePropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_PROPERTY_PREDICATE: {
				ReifiedRelationshipSourcePropertyPredicate reifiedRelationshipSourcePropertyPredicate = (ReifiedRelationshipSourcePropertyPredicate)theEObject;
				T result = caseReifiedRelationshipSourcePropertyPredicate(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseBinarySegmentForwardPropertyPredicate(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseSegmentPredicate(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseLogicalElement(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseIdentityKind(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipSourcePropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SOURCE_INVERSE_PROPERTY_PREDICATE: {
				ReifiedRelationshipSourceInversePropertyPredicate reifiedRelationshipSourceInversePropertyPredicate = (ReifiedRelationshipSourceInversePropertyPredicate)theEObject;
				T result = caseReifiedRelationshipSourceInversePropertyPredicate(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseBinarySegmentReversePropertyPredicate(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseSegmentPredicate(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseLogicalElement(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseIdentityKind(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipSourceInversePropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP_TARGET_PROPERTY_PREDICATE: {
				ReifiedRelationshipTargetPropertyPredicate reifiedRelationshipTargetPropertyPredicate = (ReifiedRelationshipTargetPropertyPredicate)theEObject;
				T result = caseReifiedRelationshipTargetPropertyPredicate(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseBinarySegmentForwardPropertyPredicate(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseSegmentPredicate(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseLogicalElement(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseIdentityKind(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipTargetPropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP_TARGET_INVERSE_PROPERTY_PREDICATE: {
				ReifiedRelationshipTargetInversePropertyPredicate reifiedRelationshipTargetInversePropertyPredicate = (ReifiedRelationshipTargetInversePropertyPredicate)theEObject;
				T result = caseReifiedRelationshipTargetInversePropertyPredicate(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseBinarySegmentReversePropertyPredicate(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseSegmentPredicate(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseLogicalElement(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseIdentityKind(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipTargetInversePropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_PROPERTY_PREDICATE: {
				UnreifiedRelationshipPropertyPredicate unreifiedRelationshipPropertyPredicate = (UnreifiedRelationshipPropertyPredicate)theEObject;
				T result = caseUnreifiedRelationshipPropertyPredicate(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseBinarySegmentForwardPropertyPredicate(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseSegmentPredicate(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseLogicalElement(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseIdentityKind(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(unreifiedRelationshipPropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.UNREIFIED_RELATIONSHIP_INVERSE_PROPERTY_PREDICATE: {
				UnreifiedRelationshipInversePropertyPredicate unreifiedRelationshipInversePropertyPredicate = (UnreifiedRelationshipInversePropertyPredicate)theEObject;
				T result = caseUnreifiedRelationshipInversePropertyPredicate(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseBinarySegmentReversePropertyPredicate(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseBinarySegmentPropertyPredicate(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseSegmentPredicate(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseElementCrossReferenceTuple(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseExtrinsicIdentityKind(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseCrossReferencableKind(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseLogicalElement(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseIdentityKind(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = caseCrossReferencabilityKind(unreifiedRelationshipInversePropertyPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.TERM_AXIOM: {
				TermAxiom termAxiom = (TermAxiom)theEObject;
				T result = caseTermAxiom(termAxiom);
				if (result == null) result = caseTerminologyBoxStatement(termAxiom);
				if (result == null) result = caseModuleElement(termAxiom);
				if (result == null) result = caseLogicalElement(termAxiom);
				if (result == null) result = caseIdentityKind(termAxiom);
				if (result == null) result = caseCrossReferencabilityKind(termAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_RESTRICTION_AXIOM: {
				EntityRestrictionAxiom entityRestrictionAxiom = (EntityRestrictionAxiom)theEObject;
				T result = caseEntityRestrictionAxiom(entityRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityRestrictionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(entityRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityRestrictionAxiom);
				if (result == null) result = caseCrossReferencableKind(entityRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_EXISTENTIAL_RESTRICTION_AXIOM: {
				EntityExistentialRestrictionAxiom entityExistentialRestrictionAxiom = (EntityExistentialRestrictionAxiom)theEObject;
				T result = caseEntityExistentialRestrictionAxiom(entityExistentialRestrictionAxiom);
				if (result == null) result = caseEntityRestrictionAxiom(entityExistentialRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityExistentialRestrictionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(entityExistentialRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityExistentialRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityExistentialRestrictionAxiom);
				if (result == null) result = caseCrossReferencableKind(entityExistentialRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityExistentialRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityExistentialRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityExistentialRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityExistentialRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_UNIVERSAL_RESTRICTION_AXIOM: {
				EntityUniversalRestrictionAxiom entityUniversalRestrictionAxiom = (EntityUniversalRestrictionAxiom)theEObject;
				T result = caseEntityUniversalRestrictionAxiom(entityUniversalRestrictionAxiom);
				if (result == null) result = caseEntityRestrictionAxiom(entityUniversalRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityUniversalRestrictionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(entityUniversalRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityUniversalRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityUniversalRestrictionAxiom);
				if (result == null) result = caseCrossReferencableKind(entityUniversalRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityUniversalRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityUniversalRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityUniversalRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityUniversalRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SPECIALIZATION_AXIOM: {
				SpecializationAxiom specializationAxiom = (SpecializationAxiom)theEObject;
				T result = caseSpecializationAxiom(specializationAxiom);
				if (result == null) result = caseTermAxiom(specializationAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(specializationAxiom);
				if (result == null) result = caseTerminologyBoxStatement(specializationAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(specializationAxiom);
				if (result == null) result = caseCrossReferencableKind(specializationAxiom);
				if (result == null) result = caseModuleElement(specializationAxiom);
				if (result == null) result = caseLogicalElement(specializationAxiom);
				if (result == null) result = caseIdentityKind(specializationAxiom);
				if (result == null) result = caseCrossReferencabilityKind(specializationAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ASPECT_SPECIALIZATION_AXIOM: {
				AspectSpecializationAxiom aspectSpecializationAxiom = (AspectSpecializationAxiom)theEObject;
				T result = caseAspectSpecializationAxiom(aspectSpecializationAxiom);
				if (result == null) result = caseSpecializationAxiom(aspectSpecializationAxiom);
				if (result == null) result = caseTermAxiom(aspectSpecializationAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(aspectSpecializationAxiom);
				if (result == null) result = caseTerminologyBoxStatement(aspectSpecializationAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(aspectSpecializationAxiom);
				if (result == null) result = caseCrossReferencableKind(aspectSpecializationAxiom);
				if (result == null) result = caseModuleElement(aspectSpecializationAxiom);
				if (result == null) result = caseLogicalElement(aspectSpecializationAxiom);
				if (result == null) result = caseIdentityKind(aspectSpecializationAxiom);
				if (result == null) result = caseCrossReferencabilityKind(aspectSpecializationAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.CONCEPT_SPECIALIZATION_AXIOM: {
				ConceptSpecializationAxiom conceptSpecializationAxiom = (ConceptSpecializationAxiom)theEObject;
				T result = caseConceptSpecializationAxiom(conceptSpecializationAxiom);
				if (result == null) result = caseSpecializationAxiom(conceptSpecializationAxiom);
				if (result == null) result = caseTermAxiom(conceptSpecializationAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(conceptSpecializationAxiom);
				if (result == null) result = caseTerminologyBoxStatement(conceptSpecializationAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(conceptSpecializationAxiom);
				if (result == null) result = caseCrossReferencableKind(conceptSpecializationAxiom);
				if (result == null) result = caseModuleElement(conceptSpecializationAxiom);
				if (result == null) result = caseLogicalElement(conceptSpecializationAxiom);
				if (result == null) result = caseIdentityKind(conceptSpecializationAxiom);
				if (result == null) result = caseCrossReferencabilityKind(conceptSpecializationAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM: {
				ReifiedRelationshipSpecializationAxiom reifiedRelationshipSpecializationAxiom = (ReifiedRelationshipSpecializationAxiom)theEObject;
				T result = caseReifiedRelationshipSpecializationAxiom(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseSpecializationAxiom(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseTermAxiom(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseTerminologyBoxStatement(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseCrossReferencableKind(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseModuleElement(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseLogicalElement(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseIdentityKind(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = caseCrossReferencabilityKind(reifiedRelationshipSpecializationAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SUB_OBJECT_PROPERTY_OF_AXIOM: {
				SubObjectPropertyOfAxiom subObjectPropertyOfAxiom = (SubObjectPropertyOfAxiom)theEObject;
				T result = caseSubObjectPropertyOfAxiom(subObjectPropertyOfAxiom);
				if (result == null) result = caseTermAxiom(subObjectPropertyOfAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(subObjectPropertyOfAxiom);
				if (result == null) result = caseTerminologyBoxStatement(subObjectPropertyOfAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(subObjectPropertyOfAxiom);
				if (result == null) result = caseCrossReferencableKind(subObjectPropertyOfAxiom);
				if (result == null) result = caseModuleElement(subObjectPropertyOfAxiom);
				if (result == null) result = caseLogicalElement(subObjectPropertyOfAxiom);
				if (result == null) result = caseIdentityKind(subObjectPropertyOfAxiom);
				if (result == null) result = caseCrossReferencabilityKind(subObjectPropertyOfAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SUB_DATA_PROPERTY_OF_AXIOM: {
				SubDataPropertyOfAxiom subDataPropertyOfAxiom = (SubDataPropertyOfAxiom)theEObject;
				T result = caseSubDataPropertyOfAxiom(subDataPropertyOfAxiom);
				if (result == null) result = caseTermAxiom(subDataPropertyOfAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(subDataPropertyOfAxiom);
				if (result == null) result = caseTerminologyBoxStatement(subDataPropertyOfAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(subDataPropertyOfAxiom);
				if (result == null) result = caseCrossReferencableKind(subDataPropertyOfAxiom);
				if (result == null) result = caseModuleElement(subDataPropertyOfAxiom);
				if (result == null) result = caseLogicalElement(subDataPropertyOfAxiom);
				if (result == null) result = caseIdentityKind(subDataPropertyOfAxiom);
				if (result == null) result = caseCrossReferencabilityKind(subDataPropertyOfAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM: {
				EntityScalarDataPropertyRestrictionAxiom entityScalarDataPropertyRestrictionAxiom = (EntityScalarDataPropertyRestrictionAxiom)theEObject;
				T result = caseEntityScalarDataPropertyRestrictionAxiom(entityScalarDataPropertyRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityScalarDataPropertyRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityScalarDataPropertyRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityScalarDataPropertyRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityScalarDataPropertyRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityScalarDataPropertyRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityScalarDataPropertyRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityScalarDataPropertyRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM: {
				EntityScalarDataPropertyExistentialRestrictionAxiom entityScalarDataPropertyExistentialRestrictionAxiom = (EntityScalarDataPropertyExistentialRestrictionAxiom)theEObject;
				T result = caseEntityScalarDataPropertyExistentialRestrictionAxiom(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseEntityScalarDataPropertyRestrictionAxiom(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseCrossReferencableKind(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityScalarDataPropertyExistentialRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM: {
				EntityScalarDataPropertyUniversalRestrictionAxiom entityScalarDataPropertyUniversalRestrictionAxiom = (EntityScalarDataPropertyUniversalRestrictionAxiom)theEObject;
				T result = caseEntityScalarDataPropertyUniversalRestrictionAxiom(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseEntityScalarDataPropertyRestrictionAxiom(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseCrossReferencableKind(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityScalarDataPropertyUniversalRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM: {
				EntityScalarDataPropertyParticularRestrictionAxiom entityScalarDataPropertyParticularRestrictionAxiom = (EntityScalarDataPropertyParticularRestrictionAxiom)theEObject;
				T result = caseEntityScalarDataPropertyParticularRestrictionAxiom(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseEntityScalarDataPropertyRestrictionAxiom(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseValueCrossReferenceTuple(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseNonCrossReferencableKind(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityScalarDataPropertyParticularRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_RESTRICTION_AXIOM: {
				EntityStructuredDataPropertyRestrictionAxiom entityStructuredDataPropertyRestrictionAxiom = (EntityStructuredDataPropertyRestrictionAxiom)theEObject;
				T result = caseEntityStructuredDataPropertyRestrictionAxiom(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseCrossReferencableKind(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityStructuredDataPropertyRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.ENTITY_STRUCTURED_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM: {
				EntityStructuredDataPropertyParticularRestrictionAxiom entityStructuredDataPropertyParticularRestrictionAxiom = (EntityStructuredDataPropertyParticularRestrictionAxiom)theEObject;
				T result = caseEntityStructuredDataPropertyParticularRestrictionAxiom(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseEntityStructuredDataPropertyRestrictionAxiom(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseRestrictionStructuredDataPropertyContext(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseTermAxiom(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseElementCrossReferenceTuple(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseTerminologyBoxStatement(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseCrossReferencableKind(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseModuleElement(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseLogicalElement(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseIdentityKind(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = caseCrossReferencabilityKind(entityStructuredDataPropertyParticularRestrictionAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_CONTEXT: {
				RestrictionStructuredDataPropertyContext restrictionStructuredDataPropertyContext = (RestrictionStructuredDataPropertyContext)theEObject;
				T result = caseRestrictionStructuredDataPropertyContext(restrictionStructuredDataPropertyContext);
				if (result == null) result = caseModuleElement(restrictionStructuredDataPropertyContext);
				if (result == null) result = caseElementCrossReferenceTuple(restrictionStructuredDataPropertyContext);
				if (result == null) result = caseLogicalElement(restrictionStructuredDataPropertyContext);
				if (result == null) result = caseExtrinsicIdentityKind(restrictionStructuredDataPropertyContext);
				if (result == null) result = caseCrossReferencableKind(restrictionStructuredDataPropertyContext);
				if (result == null) result = caseIdentityKind(restrictionStructuredDataPropertyContext);
				if (result == null) result = caseCrossReferencabilityKind(restrictionStructuredDataPropertyContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.RESTRICTION_STRUCTURED_DATA_PROPERTY_TUPLE: {
				RestrictionStructuredDataPropertyTuple restrictionStructuredDataPropertyTuple = (RestrictionStructuredDataPropertyTuple)theEObject;
				T result = caseRestrictionStructuredDataPropertyTuple(restrictionStructuredDataPropertyTuple);
				if (result == null) result = caseRestrictionStructuredDataPropertyContext(restrictionStructuredDataPropertyTuple);
				if (result == null) result = caseModuleElement(restrictionStructuredDataPropertyTuple);
				if (result == null) result = caseElementCrossReferenceTuple(restrictionStructuredDataPropertyTuple);
				if (result == null) result = caseLogicalElement(restrictionStructuredDataPropertyTuple);
				if (result == null) result = caseExtrinsicIdentityKind(restrictionStructuredDataPropertyTuple);
				if (result == null) result = caseCrossReferencableKind(restrictionStructuredDataPropertyTuple);
				if (result == null) result = caseIdentityKind(restrictionStructuredDataPropertyTuple);
				if (result == null) result = caseCrossReferencabilityKind(restrictionStructuredDataPropertyTuple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.RESTRICTION_SCALAR_DATA_PROPERTY_VALUE: {
				RestrictionScalarDataPropertyValue restrictionScalarDataPropertyValue = (RestrictionScalarDataPropertyValue)theEObject;
				T result = caseRestrictionScalarDataPropertyValue(restrictionScalarDataPropertyValue);
				if (result == null) result = caseLogicalElement(restrictionScalarDataPropertyValue);
				if (result == null) result = caseValueCrossReferenceTuple(restrictionScalarDataPropertyValue);
				if (result == null) result = caseExtrinsicIdentityKind(restrictionScalarDataPropertyValue);
				if (result == null) result = caseNonCrossReferencableKind(restrictionScalarDataPropertyValue);
				if (result == null) result = caseIdentityKind(restrictionScalarDataPropertyValue);
				if (result == null) result = caseCrossReferencabilityKind(restrictionScalarDataPropertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.RESTRICTED_DATA_RANGE: {
				RestrictedDataRange restrictedDataRange = (RestrictedDataRange)theEObject;
				T result = caseRestrictedDataRange(restrictedDataRange);
				if (result == null) result = caseDataRange(restrictedDataRange);
				if (result == null) result = caseDatatype(restrictedDataRange);
				if (result == null) result = caseTerm(restrictedDataRange);
				if (result == null) result = caseTerminologyBoxStatement(restrictedDataRange);
				if (result == null) result = caseResource(restrictedDataRange);
				if (result == null) result = caseModuleElement(restrictedDataRange);
				if (result == null) result = caseIntrinsicIdentityKind(restrictedDataRange);
				if (result == null) result = caseLogicalElement(restrictedDataRange);
				if (result == null) result = caseCrossReferencableKind(restrictedDataRange);
				if (result == null) result = caseIdentityKind(restrictedDataRange);
				if (result == null) result = caseCrossReferencabilityKind(restrictedDataRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.BINARY_SCALAR_RESTRICTION: {
				BinaryScalarRestriction binaryScalarRestriction = (BinaryScalarRestriction)theEObject;
				T result = caseBinaryScalarRestriction(binaryScalarRestriction);
				if (result == null) result = caseRestrictedDataRange(binaryScalarRestriction);
				if (result == null) result = caseDataRange(binaryScalarRestriction);
				if (result == null) result = caseDatatype(binaryScalarRestriction);
				if (result == null) result = caseTerm(binaryScalarRestriction);
				if (result == null) result = caseTerminologyBoxStatement(binaryScalarRestriction);
				if (result == null) result = caseResource(binaryScalarRestriction);
				if (result == null) result = caseModuleElement(binaryScalarRestriction);
				if (result == null) result = caseIntrinsicIdentityKind(binaryScalarRestriction);
				if (result == null) result = caseLogicalElement(binaryScalarRestriction);
				if (result == null) result = caseCrossReferencableKind(binaryScalarRestriction);
				if (result == null) result = caseIdentityKind(binaryScalarRestriction);
				if (result == null) result = caseCrossReferencabilityKind(binaryScalarRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.IRI_SCALAR_RESTRICTION: {
				IRIScalarRestriction iriScalarRestriction = (IRIScalarRestriction)theEObject;
				T result = caseIRIScalarRestriction(iriScalarRestriction);
				if (result == null) result = caseRestrictedDataRange(iriScalarRestriction);
				if (result == null) result = caseDataRange(iriScalarRestriction);
				if (result == null) result = caseDatatype(iriScalarRestriction);
				if (result == null) result = caseTerm(iriScalarRestriction);
				if (result == null) result = caseTerminologyBoxStatement(iriScalarRestriction);
				if (result == null) result = caseResource(iriScalarRestriction);
				if (result == null) result = caseModuleElement(iriScalarRestriction);
				if (result == null) result = caseIntrinsicIdentityKind(iriScalarRestriction);
				if (result == null) result = caseLogicalElement(iriScalarRestriction);
				if (result == null) result = caseCrossReferencableKind(iriScalarRestriction);
				if (result == null) result = caseIdentityKind(iriScalarRestriction);
				if (result == null) result = caseCrossReferencabilityKind(iriScalarRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.NUMERIC_SCALAR_RESTRICTION: {
				NumericScalarRestriction numericScalarRestriction = (NumericScalarRestriction)theEObject;
				T result = caseNumericScalarRestriction(numericScalarRestriction);
				if (result == null) result = caseRestrictedDataRange(numericScalarRestriction);
				if (result == null) result = caseDataRange(numericScalarRestriction);
				if (result == null) result = caseDatatype(numericScalarRestriction);
				if (result == null) result = caseTerm(numericScalarRestriction);
				if (result == null) result = caseTerminologyBoxStatement(numericScalarRestriction);
				if (result == null) result = caseResource(numericScalarRestriction);
				if (result == null) result = caseModuleElement(numericScalarRestriction);
				if (result == null) result = caseIntrinsicIdentityKind(numericScalarRestriction);
				if (result == null) result = caseLogicalElement(numericScalarRestriction);
				if (result == null) result = caseCrossReferencableKind(numericScalarRestriction);
				if (result == null) result = caseIdentityKind(numericScalarRestriction);
				if (result == null) result = caseCrossReferencabilityKind(numericScalarRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.PLAIN_LITERAL_SCALAR_RESTRICTION: {
				PlainLiteralScalarRestriction plainLiteralScalarRestriction = (PlainLiteralScalarRestriction)theEObject;
				T result = casePlainLiteralScalarRestriction(plainLiteralScalarRestriction);
				if (result == null) result = caseRestrictedDataRange(plainLiteralScalarRestriction);
				if (result == null) result = caseDataRange(plainLiteralScalarRestriction);
				if (result == null) result = caseDatatype(plainLiteralScalarRestriction);
				if (result == null) result = caseTerm(plainLiteralScalarRestriction);
				if (result == null) result = caseTerminologyBoxStatement(plainLiteralScalarRestriction);
				if (result == null) result = caseResource(plainLiteralScalarRestriction);
				if (result == null) result = caseModuleElement(plainLiteralScalarRestriction);
				if (result == null) result = caseIntrinsicIdentityKind(plainLiteralScalarRestriction);
				if (result == null) result = caseLogicalElement(plainLiteralScalarRestriction);
				if (result == null) result = caseCrossReferencableKind(plainLiteralScalarRestriction);
				if (result == null) result = caseIdentityKind(plainLiteralScalarRestriction);
				if (result == null) result = caseCrossReferencabilityKind(plainLiteralScalarRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.STRING_SCALAR_RESTRICTION: {
				StringScalarRestriction stringScalarRestriction = (StringScalarRestriction)theEObject;
				T result = caseStringScalarRestriction(stringScalarRestriction);
				if (result == null) result = caseRestrictedDataRange(stringScalarRestriction);
				if (result == null) result = caseDataRange(stringScalarRestriction);
				if (result == null) result = caseDatatype(stringScalarRestriction);
				if (result == null) result = caseTerm(stringScalarRestriction);
				if (result == null) result = caseTerminologyBoxStatement(stringScalarRestriction);
				if (result == null) result = caseResource(stringScalarRestriction);
				if (result == null) result = caseModuleElement(stringScalarRestriction);
				if (result == null) result = caseIntrinsicIdentityKind(stringScalarRestriction);
				if (result == null) result = caseLogicalElement(stringScalarRestriction);
				if (result == null) result = caseCrossReferencableKind(stringScalarRestriction);
				if (result == null) result = caseIdentityKind(stringScalarRestriction);
				if (result == null) result = caseCrossReferencabilityKind(stringScalarRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.TIME_SCALAR_RESTRICTION: {
				TimeScalarRestriction timeScalarRestriction = (TimeScalarRestriction)theEObject;
				T result = caseTimeScalarRestriction(timeScalarRestriction);
				if (result == null) result = caseRestrictedDataRange(timeScalarRestriction);
				if (result == null) result = caseDataRange(timeScalarRestriction);
				if (result == null) result = caseDatatype(timeScalarRestriction);
				if (result == null) result = caseTerm(timeScalarRestriction);
				if (result == null) result = caseTerminologyBoxStatement(timeScalarRestriction);
				if (result == null) result = caseResource(timeScalarRestriction);
				if (result == null) result = caseModuleElement(timeScalarRestriction);
				if (result == null) result = caseIntrinsicIdentityKind(timeScalarRestriction);
				if (result == null) result = caseLogicalElement(timeScalarRestriction);
				if (result == null) result = caseCrossReferencableKind(timeScalarRestriction);
				if (result == null) result = caseIdentityKind(timeScalarRestriction);
				if (result == null) result = caseCrossReferencabilityKind(timeScalarRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SYNONYM_SCALAR_RESTRICTION: {
				SynonymScalarRestriction synonymScalarRestriction = (SynonymScalarRestriction)theEObject;
				T result = caseSynonymScalarRestriction(synonymScalarRestriction);
				if (result == null) result = caseRestrictedDataRange(synonymScalarRestriction);
				if (result == null) result = caseDataRange(synonymScalarRestriction);
				if (result == null) result = caseDatatype(synonymScalarRestriction);
				if (result == null) result = caseTerm(synonymScalarRestriction);
				if (result == null) result = caseTerminologyBoxStatement(synonymScalarRestriction);
				if (result == null) result = caseResource(synonymScalarRestriction);
				if (result == null) result = caseModuleElement(synonymScalarRestriction);
				if (result == null) result = caseIntrinsicIdentityKind(synonymScalarRestriction);
				if (result == null) result = caseLogicalElement(synonymScalarRestriction);
				if (result == null) result = caseCrossReferencableKind(synonymScalarRestriction);
				if (result == null) result = caseIdentityKind(synonymScalarRestriction);
				if (result == null) result = caseCrossReferencabilityKind(synonymScalarRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SCALAR_ONE_OF_RESTRICTION: {
				ScalarOneOfRestriction scalarOneOfRestriction = (ScalarOneOfRestriction)theEObject;
				T result = caseScalarOneOfRestriction(scalarOneOfRestriction);
				if (result == null) result = caseRestrictedDataRange(scalarOneOfRestriction);
				if (result == null) result = caseDataRange(scalarOneOfRestriction);
				if (result == null) result = caseDatatype(scalarOneOfRestriction);
				if (result == null) result = caseTerm(scalarOneOfRestriction);
				if (result == null) result = caseTerminologyBoxStatement(scalarOneOfRestriction);
				if (result == null) result = caseResource(scalarOneOfRestriction);
				if (result == null) result = caseModuleElement(scalarOneOfRestriction);
				if (result == null) result = caseIntrinsicIdentityKind(scalarOneOfRestriction);
				if (result == null) result = caseLogicalElement(scalarOneOfRestriction);
				if (result == null) result = caseCrossReferencableKind(scalarOneOfRestriction);
				if (result == null) result = caseIdentityKind(scalarOneOfRestriction);
				if (result == null) result = caseCrossReferencabilityKind(scalarOneOfRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TerminologiesPackage.SCALAR_ONE_OF_LITERAL_AXIOM: {
				ScalarOneOfLiteralAxiom scalarOneOfLiteralAxiom = (ScalarOneOfLiteralAxiom)theEObject;
				T result = caseScalarOneOfLiteralAxiom(scalarOneOfLiteralAxiom);
				if (result == null) result = caseTermAxiom(scalarOneOfLiteralAxiom);
				if (result == null) result = caseValueCrossReferenceTuple(scalarOneOfLiteralAxiom);
				if (result == null) result = caseTerminologyBoxStatement(scalarOneOfLiteralAxiom);
				if (result == null) result = caseExtrinsicIdentityKind(scalarOneOfLiteralAxiom);
				if (result == null) result = caseNonCrossReferencableKind(scalarOneOfLiteralAxiom);
				if (result == null) result = caseModuleElement(scalarOneOfLiteralAxiom);
				if (result == null) result = caseLogicalElement(scalarOneOfLiteralAxiom);
				if (result == null) result = caseIdentityKind(scalarOneOfLiteralAxiom);
				if (result == null) result = caseCrossReferencabilityKind(scalarOneOfLiteralAxiom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Box Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Box Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyBoxStatement(TerminologyBoxStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Terminology Extension Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminology Extension Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminologyExtensionAxiom(TerminologyExtensionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerm(Term object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Term Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Term Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryTermKind(UnaryTermKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directed Binary Relationship Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directed Binary Relationship Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectedBinaryRelationshipKind(DirectedBinaryRelationshipKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conceptual Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conceptual Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptualEntity(ConceptualEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspect(Aspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcept(Concept object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityRelationship(EntityRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationship(ReifiedRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unreified Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unreified Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnreifiedRelationship(UnreifiedRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Datatype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Datatype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatatype(Datatype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRange(DataRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalar(Scalar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRelationship(DataRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Relationship Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Relationship Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRelationshipDomain(DataRelationshipDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Relationship From Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Relationship From Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRelationshipFromEntity(DataRelationshipFromEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Relationship From Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Relationship From Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRelationshipFromStructure(DataRelationshipFromStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Relationship Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Relationship Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRelationshipRange(DataRelationshipRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Relationship To Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Relationship To Scalar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRelationshipToScalar(DataRelationshipToScalar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Relationship To Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Relationship To Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataRelationshipToStructure(DataRelationshipToStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Structured Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Structured Data Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityStructuredDataProperty(EntityStructuredDataProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Scalar Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Scalar Data Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityScalarDataProperty(EntityScalarDataProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Data Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredDataProperty(StructuredDataProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Data Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarDataProperty(ScalarDataProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructure(Structure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Chain Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Chain Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChainRule(ChainRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Body Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Body Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleBodySegment(RuleBodySegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Segment Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Segment Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSegmentPredicate(SegmentPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Segment Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Segment Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnarySegmentPredicate(UnarySegmentPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspectPredicate(AspectPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptPredicate(ConceptPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipPredicate(ReifiedRelationshipPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Segment Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Segment Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinarySegmentPropertyPredicate(BinarySegmentPropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Segment Forward Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Segment Forward Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinarySegmentForwardPropertyPredicate(BinarySegmentForwardPropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Segment Reverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Segment Reverse Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinarySegmentReversePropertyPredicate(BinarySegmentReversePropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipPropertyPredicate(ReifiedRelationshipPropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Inverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Inverse Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipInversePropertyPredicate(ReifiedRelationshipInversePropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Source Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Source Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipSourcePropertyPredicate(ReifiedRelationshipSourcePropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Source Inverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Source Inverse Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipSourceInversePropertyPredicate(ReifiedRelationshipSourceInversePropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Target Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Target Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipTargetPropertyPredicate(ReifiedRelationshipTargetPropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Target Inverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Target Inverse Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipTargetInversePropertyPredicate(ReifiedRelationshipTargetInversePropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unreified Relationship Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unreified Relationship Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnreifiedRelationshipPropertyPredicate(UnreifiedRelationshipPropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unreified Relationship Inverse Property Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unreified Relationship Inverse Property Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnreifiedRelationshipInversePropertyPredicate(UnreifiedRelationshipInversePropertyPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTermAxiom(TermAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityRestrictionAxiom(EntityRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Existential Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Existential Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityExistentialRestrictionAxiom(EntityExistentialRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Universal Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Universal Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityUniversalRestrictionAxiom(EntityUniversalRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specialization Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializationAxiom(SpecializationAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect Specialization Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspectSpecializationAxiom(AspectSpecializationAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept Specialization Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConceptSpecializationAxiom(ConceptSpecializationAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reified Relationship Specialization Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reified Relationship Specialization Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReifiedRelationshipSpecializationAxiom(ReifiedRelationshipSpecializationAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Object Property Of Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Object Property Of Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubObjectPropertyOfAxiom(SubObjectPropertyOfAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Data Property Of Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Data Property Of Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubDataPropertyOfAxiom(SubDataPropertyOfAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Scalar Data Property Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Scalar Data Property Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityScalarDataPropertyRestrictionAxiom(EntityScalarDataPropertyRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Scalar Data Property Existential Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Scalar Data Property Existential Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityScalarDataPropertyExistentialRestrictionAxiom(EntityScalarDataPropertyExistentialRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Scalar Data Property Universal Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Scalar Data Property Universal Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityScalarDataPropertyUniversalRestrictionAxiom(EntityScalarDataPropertyUniversalRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Scalar Data Property Particular Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Scalar Data Property Particular Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityScalarDataPropertyParticularRestrictionAxiom(EntityScalarDataPropertyParticularRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Structured Data Property Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Structured Data Property Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityStructuredDataPropertyRestrictionAxiom(EntityStructuredDataPropertyRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Structured Data Property Particular Restriction Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Structured Data Property Particular Restriction Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntityStructuredDataPropertyParticularRestrictionAxiom(EntityStructuredDataPropertyParticularRestrictionAxiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Restriction Structured Data Property Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Restriction Structured Data Property Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestrictionStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Restriction Structured Data Property Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Restriction Structured Data Property Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestrictionStructuredDataPropertyTuple(RestrictionStructuredDataPropertyTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Restriction Scalar Data Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Restriction Scalar Data Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestrictionScalarDataPropertyValue(RestrictionScalarDataPropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Restricted Data Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Restricted Data Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestrictedDataRange(RestrictedDataRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Scalar Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryScalarRestriction(BinaryScalarRestriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRI Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRI Scalar Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIRIScalarRestriction(IRIScalarRestriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Scalar Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericScalarRestriction(NumericScalarRestriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plain Literal Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plain Literal Scalar Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlainLiteralScalarRestriction(PlainLiteralScalarRestriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Scalar Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringScalarRestriction(StringScalarRestriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Scalar Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeScalarRestriction(TimeScalarRestriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Synonym Scalar Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synonym Scalar Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSynonymScalarRestriction(SynonymScalarRestriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar One Of Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar One Of Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarOneOfRestriction(ScalarOneOfRestriction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar One Of Literal Axiom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar One Of Literal Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarOneOfLiteralAxiom(ScalarOneOfLiteralAxiom object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Non Cross Referencable Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Cross Referencable Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonCrossReferencableKind(NonCrossReferencableKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Cross Reference Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Cross Reference Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueCrossReferenceTuple(ValueCrossReferenceTuple object) {
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

} //TerminologiesSwitch
