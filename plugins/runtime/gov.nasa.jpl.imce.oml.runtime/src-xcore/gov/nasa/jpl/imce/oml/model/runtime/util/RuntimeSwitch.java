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
package gov.nasa.jpl.imce.oml.model.runtime.util;

import gov.nasa.jpl.imce.oml.model.runtime.*;

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
 * @see gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage
 * @generated
 */
public class RuntimeSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RuntimePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeSwitch() {
		if (modelPackage == null) {
			modelPackage = RuntimePackage.eINSTANCE;
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
			case RuntimePackage.OML_OBJECT: {
				OMLObject omlObject = (OMLObject)theEObject;
				T result = caseOMLObject(omlObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_DESCRIPTION: {
				OMLDescription omlDescription = (OMLDescription)theEObject;
				T result = caseOMLDescription(omlDescription);
				if (result == null) result = caseOMLObject(omlDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_STRUCTURE: {
				OMLStructure omlStructure = (OMLStructure)theEObject;
				T result = caseOMLStructure(omlStructure);
				if (result == null) result = caseOMLObject(omlStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_ENTITY: {
				OMLEntity omlEntity = (OMLEntity)theEObject;
				T result = caseOMLEntity(omlEntity);
				if (result == null) result = caseOMLObject(omlEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_CONCEPT: {
				OMLConcept omlConcept = (OMLConcept)theEObject;
				T result = caseOMLConcept(omlConcept);
				if (result == null) result = caseOMLEntity(omlConcept);
				if (result == null) result = caseOMLObject(omlConcept);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_RELATIONSHIP_FROM_ENTITY: {
				OMLRelationshipFromEntity omlRelationshipFromEntity = (OMLRelationshipFromEntity)theEObject;
				T result = caseOMLRelationshipFromEntity(omlRelationshipFromEntity);
				if (result == null) result = caseOMLObject(omlRelationshipFromEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_RELATIONSHIP_FROM_STRUCTURE: {
				OMLRelationshipFromStructure omlRelationshipFromStructure = (OMLRelationshipFromStructure)theEObject;
				T result = caseOMLRelationshipFromStructure(omlRelationshipFromStructure);
				if (result == null) result = caseOMLObject(omlRelationshipFromStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_RELATIONSHIP_TO_ENTITY: {
				OMLRelationshipToEntity omlRelationshipToEntity = (OMLRelationshipToEntity)theEObject;
				T result = caseOMLRelationshipToEntity(omlRelationshipToEntity);
				if (result == null) result = caseOMLObject(omlRelationshipToEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_RELATIONSHIP_TO_STRUCTURE: {
				OMLRelationshipToStructure omlRelationshipToStructure = (OMLRelationshipToStructure)theEObject;
				T result = caseOMLRelationshipToStructure(omlRelationshipToStructure);
				if (result == null) result = caseOMLObject(omlRelationshipToStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_ENTITY_RELATIONSHIP: {
				OMLEntityRelationship omlEntityRelationship = (OMLEntityRelationship)theEObject;
				T result = caseOMLEntityRelationship(omlEntityRelationship);
				if (result == null) result = caseOMLRelationshipFromEntity(omlEntityRelationship);
				if (result == null) result = caseOMLRelationshipToEntity(omlEntityRelationship);
				if (result == null) result = caseOMLObject(omlEntityRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_REIFIED_RELATIONSHIP: {
				OMLReifiedRelationship omlReifiedRelationship = (OMLReifiedRelationship)theEObject;
				T result = caseOMLReifiedRelationship(omlReifiedRelationship);
				if (result == null) result = caseOMLEntityRelationship(omlReifiedRelationship);
				if (result == null) result = caseOMLEntity(omlReifiedRelationship);
				if (result == null) result = caseOMLRelationshipFromEntity(omlReifiedRelationship);
				if (result == null) result = caseOMLRelationshipToEntity(omlReifiedRelationship);
				if (result == null) result = caseOMLObject(omlReifiedRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_UNREIFIED_RELATIONSHIP: {
				OMLUnreifiedRelationship omlUnreifiedRelationship = (OMLUnreifiedRelationship)theEObject;
				T result = caseOMLUnreifiedRelationship(omlUnreifiedRelationship);
				if (result == null) result = caseOMLEntityRelationship(omlUnreifiedRelationship);
				if (result == null) result = caseOMLRelationshipFromEntity(omlUnreifiedRelationship);
				if (result == null) result = caseOMLRelationshipToEntity(omlUnreifiedRelationship);
				if (result == null) result = caseOMLObject(omlUnreifiedRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_ENTITY_DATA_PROPERTY_TO_SCALAR: {
				OMLEntityDataPropertyToScalar omlEntityDataPropertyToScalar = (OMLEntityDataPropertyToScalar)theEObject;
				T result = caseOMLEntityDataPropertyToScalar(omlEntityDataPropertyToScalar);
				if (result == null) result = caseOMLRelationshipFromEntity(omlEntityDataPropertyToScalar);
				if (result == null) result = caseOMLObject(omlEntityDataPropertyToScalar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE: {
				OMLEntityDataPropertyToStructure omlEntityDataPropertyToStructure = (OMLEntityDataPropertyToStructure)theEObject;
				T result = caseOMLEntityDataPropertyToStructure(omlEntityDataPropertyToStructure);
				if (result == null) result = caseOMLRelationshipFromEntity(omlEntityDataPropertyToStructure);
				if (result == null) result = caseOMLRelationshipToStructure(omlEntityDataPropertyToStructure);
				if (result == null) result = caseOMLObject(omlEntityDataPropertyToStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR: {
				OMLStructureDataPropertyToScalar omlStructureDataPropertyToScalar = (OMLStructureDataPropertyToScalar)theEObject;
				T result = caseOMLStructureDataPropertyToScalar(omlStructureDataPropertyToScalar);
				if (result == null) result = caseOMLRelationshipFromStructure(omlStructureDataPropertyToScalar);
				if (result == null) result = caseOMLObject(omlStructureDataPropertyToScalar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE: {
				OMLStructureDataPropertyToStructure omlStructureDataPropertyToStructure = (OMLStructureDataPropertyToStructure)theEObject;
				T result = caseOMLStructureDataPropertyToStructure(omlStructureDataPropertyToStructure);
				if (result == null) result = caseOMLRelationshipFromStructure(omlStructureDataPropertyToStructure);
				if (result == null) result = caseOMLRelationshipToStructure(omlStructureDataPropertyToStructure);
				if (result == null) result = caseOMLObject(omlStructureDataPropertyToStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLObject(OMLObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLDescription(OMLDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLStructure(OMLStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLEntity(OMLEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Concept</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Concept</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLConcept(OMLConcept object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Relationship From Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Relationship From Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLRelationshipFromEntity(OMLRelationshipFromEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Relationship From Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Relationship From Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLRelationshipFromStructure(OMLRelationshipFromStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Relationship To Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Relationship To Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLRelationshipToEntity(OMLRelationshipToEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Relationship To Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Relationship To Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLRelationshipToStructure(OMLRelationshipToStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Entity Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Entity Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLEntityRelationship(OMLEntityRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Reified Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Reified Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLReifiedRelationship(OMLReifiedRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Unreified Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Unreified Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLUnreifiedRelationship(OMLUnreifiedRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Entity Data Property To Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Entity Data Property To Scalar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLEntityDataPropertyToScalar(OMLEntityDataPropertyToScalar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Entity Data Property To Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Entity Data Property To Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLEntityDataPropertyToStructure(OMLEntityDataPropertyToStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Structure Data Property To Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Structure Data Property To Scalar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLStructureDataPropertyToScalar(OMLStructureDataPropertyToScalar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OML Structure Data Property To Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OML Structure Data Property To Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMLStructureDataPropertyToStructure(OMLStructureDataPropertyToStructure object) {
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

} //RuntimeSwitch
