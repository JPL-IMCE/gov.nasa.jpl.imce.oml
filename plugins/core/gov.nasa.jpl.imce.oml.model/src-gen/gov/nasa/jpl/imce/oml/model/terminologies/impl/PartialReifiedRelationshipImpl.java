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
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.PartialReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partial Reified Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PartialReifiedRelationshipImpl extends ConceptualRelationshipImpl implements PartialReifiedRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartialReifiedRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.PARTIAL_REIFIED_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogicalElement> allNestedElements() {
		return ECollections.<LogicalElement>emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReifiedRelationship> rootReifiedRelationships() {
		return OMLExtensions.rootReifiedRelationships(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ModuleElement.class) {
			switch (baseOperationID) {
				case CommonPackage.MODULE_ELEMENT___ALL_NESTED_ELEMENTS: return TerminologiesPackage.PARTIAL_REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Term.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.TERM___ALL_NESTED_ELEMENTS: return TerminologiesPackage.PARTIAL_REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ConceptualRelationship.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___ROOT_REIFIED_RELATIONSHIPS: return TerminologiesPackage.PARTIAL_REIFIED_RELATIONSHIP___ROOT_REIFIED_RELATIONSHIPS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case TerminologiesPackage.PARTIAL_REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS:
				return allNestedElements();
			case TerminologiesPackage.PARTIAL_REIFIED_RELATIONSHIP___ROOT_REIFIED_RELATIONSHIPS:
				return rootReifiedRelationships();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PartialReifiedRelationshipImpl
