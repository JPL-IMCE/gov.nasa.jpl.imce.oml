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

import gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.DirectedBinaryRelationshipKind;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conceptual Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ConceptualRelationshipImpl extends ConceptualEntityImpl implements ConceptualRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptualRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.CONCEPTUAL_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CharacterizedEntityRelationship> rootCharacterizedEntityRelationships() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity relationSource() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term relationDomain() {
		return this.relationSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity relationTarget() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term relationRange() {
		return this.relationTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == DirectedBinaryRelationshipKind.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_DOMAIN: return TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_DOMAIN;
				case TerminologiesPackage.DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_RANGE: return TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_RANGE;
				default: return -1;
			}
		}
		if (baseClass == EntityRelationship.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.ENTITY_RELATIONSHIP___RELATION_SOURCE: return TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_SOURCE;
				case TerminologiesPackage.ENTITY_RELATIONSHIP___RELATION_DOMAIN: return TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_DOMAIN;
				case TerminologiesPackage.ENTITY_RELATIONSHIP___RELATION_TARGET: return TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_TARGET;
				case TerminologiesPackage.ENTITY_RELATIONSHIP___RELATION_RANGE: return TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_RANGE;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___ROOT_CHARACTERIZED_ENTITY_RELATIONSHIPS:
				return rootCharacterizedEntityRelationships();
			case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_SOURCE:
				return relationSource();
			case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_DOMAIN:
				return relationDomain();
			case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_TARGET:
				return relationTarget();
			case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_RANGE:
				return relationRange();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConceptualRelationshipImpl
