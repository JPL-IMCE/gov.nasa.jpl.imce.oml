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
package gov.nasa.jpl.imce.oml.model.runtime.impl;

import gov.nasa.jpl.imce.oml.model.runtime.OMLRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.runtime.OMLStructure;
import gov.nasa.jpl.imce.oml.model.runtime.OMLStructureDataPropertyToStructure;
import gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OML Structure Data Property To Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OMLStructureDataPropertyToStructureImpl extends OMLRelationshipFromStructureImpl implements OMLStructureDataPropertyToStructure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLStructureDataPropertyToStructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePackage.Literals.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLStructure omlTarget() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == OMLRelationshipToStructure.class) {
			switch (baseOperationID) {
				case RuntimePackage.OML_RELATIONSHIP_TO_STRUCTURE___OML_TARGET: return RuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE___OML_TARGET;
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
			case RuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE___OML_TARGET:
				return omlTarget();
		}
		return super.eInvoke(operationID, arguments);
	}

} //OMLStructureDataPropertyToStructureImpl
