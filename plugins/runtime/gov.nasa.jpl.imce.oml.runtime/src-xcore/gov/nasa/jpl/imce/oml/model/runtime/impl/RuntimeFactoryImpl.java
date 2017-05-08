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

import gov.nasa.jpl.imce.oml.model.runtime.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimeFactoryImpl extends EFactoryImpl implements RuntimeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuntimeFactory init() {
		try {
			RuntimeFactory theRuntimeFactory = (RuntimeFactory)EPackage.Registry.INSTANCE.getEFactory(RuntimePackage.eNS_URI);
			if (theRuntimeFactory != null) {
				return theRuntimeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RuntimeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RuntimePackage.OML_DESCRIPTION: return (EObject)createOMLDescription();
			case RuntimePackage.OML_STRUCTURE: return (EObject)createOMLStructure();
			case RuntimePackage.OML_CONCEPT: return (EObject)createOMLConcept();
			case RuntimePackage.OML_REIFIED_RELATIONSHIP: return (EObject)createOMLReifiedRelationship();
			case RuntimePackage.OML_UNREIFIED_RELATIONSHIP: return (EObject)createOMLUnreifiedRelationship();
			case RuntimePackage.OML_ENTITY_DATA_PROPERTY_TO_SCALAR: return (EObject)createOMLEntityDataPropertyToScalar();
			case RuntimePackage.OML_ENTITY_DATA_PROPERTY_TO_STRUCTURE: return (EObject)createOMLEntityDataPropertyToStructure();
			case RuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_SCALAR: return (EObject)createOMLStructureDataPropertyToScalar();
			case RuntimePackage.OML_STRUCTURE_DATA_PROPERTY_TO_STRUCTURE: return (EObject)createOMLStructureDataPropertyToStructure();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case RuntimePackage.IRI:
				return createIRIFromString(eDataType, initialValue);
			case RuntimePackage.LEXICAL_VALUE:
				return createLexicalValueFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case RuntimePackage.IRI:
				return convertIRIToString(eDataType, instanceValue);
			case RuntimePackage.LEXICAL_VALUE:
				return convertLexicalValueToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLDescription createOMLDescription() {
		OMLDescriptionImpl omlDescription = new OMLDescriptionImpl();
		return omlDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLStructure createOMLStructure() {
		OMLStructureImpl omlStructure = new OMLStructureImpl();
		return omlStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLConcept createOMLConcept() {
		OMLConceptImpl omlConcept = new OMLConceptImpl();
		return omlConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLReifiedRelationship createOMLReifiedRelationship() {
		OMLReifiedRelationshipImpl omlReifiedRelationship = new OMLReifiedRelationshipImpl();
		return omlReifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLUnreifiedRelationship createOMLUnreifiedRelationship() {
		OMLUnreifiedRelationshipImpl omlUnreifiedRelationship = new OMLUnreifiedRelationshipImpl();
		return omlUnreifiedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLEntityDataPropertyToScalar createOMLEntityDataPropertyToScalar() {
		OMLEntityDataPropertyToScalarImpl omlEntityDataPropertyToScalar = new OMLEntityDataPropertyToScalarImpl();
		return omlEntityDataPropertyToScalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLEntityDataPropertyToStructure createOMLEntityDataPropertyToStructure() {
		OMLEntityDataPropertyToStructureImpl omlEntityDataPropertyToStructure = new OMLEntityDataPropertyToStructureImpl();
		return omlEntityDataPropertyToStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLStructureDataPropertyToScalar createOMLStructureDataPropertyToScalar() {
		OMLStructureDataPropertyToScalarImpl omlStructureDataPropertyToScalar = new OMLStructureDataPropertyToScalarImpl();
		return omlStructureDataPropertyToScalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLStructureDataPropertyToStructure createOMLStructureDataPropertyToStructure() {
		OMLStructureDataPropertyToStructureImpl omlStructureDataPropertyToStructure = new OMLStructureDataPropertyToStructureImpl();
		return omlStructureDataPropertyToStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIRIFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIRIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createLexicalValueFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLexicalValueToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimePackage getRuntimePackage() {
		return (RuntimePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RuntimePackage getPackage() {
		return RuntimePackage.eINSTANCE;
	}

} //RuntimeFactoryImpl
