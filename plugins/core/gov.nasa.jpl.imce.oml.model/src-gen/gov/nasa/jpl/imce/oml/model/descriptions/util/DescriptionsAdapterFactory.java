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
package gov.nasa.jpl.imce.oml.model.descriptions.util;

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;
import gov.nasa.jpl.imce.oml.model.common.Resource;

import gov.nasa.jpl.imce.oml.model.descriptions.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage
 * @generated
 */
public class DescriptionsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DescriptionsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DescriptionsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionsSwitch<Adapter> modelSwitch =
		new DescriptionsSwitch<Adapter>() {
			@Override
			public Adapter caseDescriptionBox(DescriptionBox object) {
				return createDescriptionBoxAdapter();
			}
			@Override
			public Adapter caseDescriptionBoxRelationship(DescriptionBoxRelationship object) {
				return createDescriptionBoxRelationshipAdapter();
			}
			@Override
			public Adapter caseDescriptionBoxExtendsClosedWorldDefinitions(DescriptionBoxExtendsClosedWorldDefinitions object) {
				return createDescriptionBoxExtendsClosedWorldDefinitionsAdapter();
			}
			@Override
			public Adapter caseDescriptionBoxRefinement(DescriptionBoxRefinement object) {
				return createDescriptionBoxRefinementAdapter();
			}
			@Override
			public Adapter caseTerminologyInstanceAssertion(TerminologyInstanceAssertion object) {
				return createTerminologyInstanceAssertionAdapter();
			}
			@Override
			public Adapter caseSingletonInstanceScalarDataPropertyValue(SingletonInstanceScalarDataPropertyValue object) {
				return createSingletonInstanceScalarDataPropertyValueAdapter();
			}
			@Override
			public Adapter caseSingletonInstanceStructuredDataPropertyContext(SingletonInstanceStructuredDataPropertyContext object) {
				return createSingletonInstanceStructuredDataPropertyContextAdapter();
			}
			@Override
			public Adapter caseSingletonInstanceStructuredDataPropertyValue(SingletonInstanceStructuredDataPropertyValue object) {
				return createSingletonInstanceStructuredDataPropertyValueAdapter();
			}
			@Override
			public Adapter caseStructuredDataPropertyTuple(StructuredDataPropertyTuple object) {
				return createStructuredDataPropertyTupleAdapter();
			}
			@Override
			public Adapter caseScalarDataPropertyValue(ScalarDataPropertyValue object) {
				return createScalarDataPropertyValueAdapter();
			}
			@Override
			public Adapter caseConceptualEntitySingletonInstance(ConceptualEntitySingletonInstance object) {
				return createConceptualEntitySingletonInstanceAdapter();
			}
			@Override
			public Adapter caseConceptInstance(ConceptInstance object) {
				return createConceptInstanceAdapter();
			}
			@Override
			public Adapter caseReifiedRelationshipInstance(ReifiedRelationshipInstance object) {
				return createReifiedRelationshipInstanceAdapter();
			}
			@Override
			public Adapter caseReifiedRelationshipInstanceDomain(ReifiedRelationshipInstanceDomain object) {
				return createReifiedRelationshipInstanceDomainAdapter();
			}
			@Override
			public Adapter caseReifiedRelationshipInstanceRange(ReifiedRelationshipInstanceRange object) {
				return createReifiedRelationshipInstanceRangeAdapter();
			}
			@Override
			public Adapter caseUnreifiedRelationshipInstanceTuple(UnreifiedRelationshipInstanceTuple object) {
				return createUnreifiedRelationshipInstanceTupleAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseModule(Module object) {
				return createModuleAdapter();
			}
			@Override
			public Adapter caseModuleEdge(ModuleEdge object) {
				return createModuleEdgeAdapter();
			}
			@Override
			public Adapter caseModuleElement(ModuleElement object) {
				return createModuleElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox <em>Description Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
	 * @generated
	 */
	public Adapter createDescriptionBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship <em>Description Box Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRelationship
	 * @generated
	 */
	public Adapter createDescriptionBoxRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions <em>Description Box Extends Closed World Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
	 * @generated
	 */
	public Adapter createDescriptionBoxExtendsClosedWorldDefinitionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement <em>Description Box Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement
	 * @generated
	 */
	public Adapter createDescriptionBoxRefinementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.TerminologyInstanceAssertion <em>Terminology Instance Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.TerminologyInstanceAssertion
	 * @generated
	 */
	public Adapter createTerminologyInstanceAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue <em>Singleton Instance Scalar Data Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
	 * @generated
	 */
	public Adapter createSingletonInstanceScalarDataPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext <em>Singleton Instance Structured Data Property Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext
	 * @generated
	 */
	public Adapter createSingletonInstanceStructuredDataPropertyContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue <em>Singleton Instance Structured Data Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
	 * @generated
	 */
	public Adapter createSingletonInstanceStructuredDataPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple <em>Structured Data Property Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple
	 * @generated
	 */
	public Adapter createStructuredDataPropertyTupleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue <em>Scalar Data Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
	 * @generated
	 */
	public Adapter createScalarDataPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance <em>Conceptual Entity Singleton Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance
	 * @generated
	 */
	public Adapter createConceptualEntitySingletonInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance <em>Concept Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
	 * @generated
	 */
	public Adapter createConceptInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance <em>Reified Relationship Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
	 * @generated
	 */
	public Adapter createReifiedRelationshipInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain <em>Reified Relationship Instance Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
	 * @generated
	 */
	public Adapter createReifiedRelationshipInstanceDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange <em>Reified Relationship Instance Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
	 * @generated
	 */
	public Adapter createReifiedRelationshipInstanceRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple <em>Unreified Relationship Instance Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple
	 * @generated
	 */
	public Adapter createUnreifiedRelationshipInstanceTupleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module
	 * @generated
	 */
	public Adapter createModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ModuleEdge <em>Module Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleEdge
	 * @generated
	 */
	public Adapter createModuleEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ModuleElement <em>Module Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleElement
	 * @generated
	 */
	public Adapter createModuleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DescriptionsAdapterFactory
