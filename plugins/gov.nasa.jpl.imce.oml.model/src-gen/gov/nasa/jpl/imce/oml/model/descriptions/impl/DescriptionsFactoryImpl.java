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
package gov.nasa.jpl.imce.oml.model.descriptions.impl;

import gov.nasa.jpl.imce.oml.model.descriptions.*;

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
public class DescriptionsFactoryImpl extends EFactoryImpl implements DescriptionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DescriptionsFactory init() {
		try {
			DescriptionsFactory theDescriptionsFactory = (DescriptionsFactory)EPackage.Registry.INSTANCE.getEFactory(DescriptionsPackage.eNS_URI);
			if (theDescriptionsFactory != null) {
				return theDescriptionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DescriptionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionsFactoryImpl() {
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
			case DescriptionsPackage.DESCRIPTION_BOX: return createDescriptionBox();
			case DescriptionsPackage.DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS: return createDescriptionBoxExtendsClosedWorldDefinitions();
			case DescriptionsPackage.DESCRIPTION_BOX_REFINEMENT: return createDescriptionBoxRefinement();
			case DescriptionsPackage.SINGLETON_INSTANCE_SCALAR_DATA_PROPERTY_VALUE: return createSingletonInstanceScalarDataPropertyValue();
			case DescriptionsPackage.SINGLETON_INSTANCE_STRUCTURED_DATA_PROPERTY_VALUE: return createSingletonInstanceStructuredDataPropertyValue();
			case DescriptionsPackage.STRUCTURED_DATA_PROPERTY_TUPLE: return createStructuredDataPropertyTuple();
			case DescriptionsPackage.SCALAR_DATA_PROPERTY_VALUE: return createScalarDataPropertyValue();
			case DescriptionsPackage.CONCEPT_INSTANCE: return createConceptInstance();
			case DescriptionsPackage.INSTANCE_RELATIONSHIP_VALUE_RESTRICTION: return createInstanceRelationshipValueRestriction();
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE: return createReifiedRelationshipInstance();
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE_DOMAIN: return createReifiedRelationshipInstanceDomain();
			case DescriptionsPackage.REIFIED_RELATIONSHIP_INSTANCE_RANGE: return createReifiedRelationshipInstanceRange();
			case DescriptionsPackage.UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE: return createUnreifiedRelationshipInstanceTuple();
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
			case DescriptionsPackage.DESCRIPTION_KIND:
				return createDescriptionKindFromString(eDataType, initialValue);
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
			case DescriptionsPackage.DESCRIPTION_KIND:
				return convertDescriptionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBox createDescriptionBox() {
		DescriptionBoxImpl descriptionBox = new DescriptionBoxImpl();
		return descriptionBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBoxExtendsClosedWorldDefinitions createDescriptionBoxExtendsClosedWorldDefinitions() {
		DescriptionBoxExtendsClosedWorldDefinitionsImpl descriptionBoxExtendsClosedWorldDefinitions = new DescriptionBoxExtendsClosedWorldDefinitionsImpl();
		return descriptionBoxExtendsClosedWorldDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBoxRefinement createDescriptionBoxRefinement() {
		DescriptionBoxRefinementImpl descriptionBoxRefinement = new DescriptionBoxRefinementImpl();
		return descriptionBoxRefinement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingletonInstanceScalarDataPropertyValue createSingletonInstanceScalarDataPropertyValue() {
		SingletonInstanceScalarDataPropertyValueImpl singletonInstanceScalarDataPropertyValue = new SingletonInstanceScalarDataPropertyValueImpl();
		return singletonInstanceScalarDataPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingletonInstanceStructuredDataPropertyValue createSingletonInstanceStructuredDataPropertyValue() {
		SingletonInstanceStructuredDataPropertyValueImpl singletonInstanceStructuredDataPropertyValue = new SingletonInstanceStructuredDataPropertyValueImpl();
		return singletonInstanceStructuredDataPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredDataPropertyTuple createStructuredDataPropertyTuple() {
		StructuredDataPropertyTupleImpl structuredDataPropertyTuple = new StructuredDataPropertyTupleImpl();
		return structuredDataPropertyTuple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarDataPropertyValue createScalarDataPropertyValue() {
		ScalarDataPropertyValueImpl scalarDataPropertyValue = new ScalarDataPropertyValueImpl();
		return scalarDataPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptInstance createConceptInstance() {
		ConceptInstanceImpl conceptInstance = new ConceptInstanceImpl();
		return conceptInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceRelationshipValueRestriction createInstanceRelationshipValueRestriction() {
		InstanceRelationshipValueRestrictionImpl instanceRelationshipValueRestriction = new InstanceRelationshipValueRestrictionImpl();
		return instanceRelationshipValueRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationshipInstance createReifiedRelationshipInstance() {
		ReifiedRelationshipInstanceImpl reifiedRelationshipInstance = new ReifiedRelationshipInstanceImpl();
		return reifiedRelationshipInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationshipInstanceDomain createReifiedRelationshipInstanceDomain() {
		ReifiedRelationshipInstanceDomainImpl reifiedRelationshipInstanceDomain = new ReifiedRelationshipInstanceDomainImpl();
		return reifiedRelationshipInstanceDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReifiedRelationshipInstanceRange createReifiedRelationshipInstanceRange() {
		ReifiedRelationshipInstanceRangeImpl reifiedRelationshipInstanceRange = new ReifiedRelationshipInstanceRangeImpl();
		return reifiedRelationshipInstanceRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnreifiedRelationshipInstanceTuple createUnreifiedRelationshipInstanceTuple() {
		UnreifiedRelationshipInstanceTupleImpl unreifiedRelationshipInstanceTuple = new UnreifiedRelationshipInstanceTupleImpl();
		return unreifiedRelationshipInstanceTuple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionKind createDescriptionKindFromString(EDataType eDataType, String initialValue) {
		DescriptionKind result = DescriptionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDescriptionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionsPackage getDescriptionsPackage() {
		return (DescriptionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DescriptionsPackage getPackage() {
		return DescriptionsPackage.eINSTANCE;
	}

} //DescriptionsFactoryImpl
