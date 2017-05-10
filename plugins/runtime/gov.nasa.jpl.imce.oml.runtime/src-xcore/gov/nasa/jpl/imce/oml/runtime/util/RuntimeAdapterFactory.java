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
package gov.nasa.jpl.imce.oml.runtime.util;

import gov.nasa.jpl.imce.oml.runtime.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.runtime.RuntimePackage
 * @generated
 */
public class RuntimeAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RuntimePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RuntimePackage.eINSTANCE;
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
	protected RuntimeSwitch<Adapter> modelSwitch =
		new RuntimeSwitch<Adapter>() {
			@Override
			public Adapter caseOMLObject(OMLObject object) {
				return createOMLObjectAdapter();
			}
			@Override
			public Adapter caseOMLDescription(OMLDescription object) {
				return createOMLDescriptionAdapter();
			}
			@Override
			public Adapter caseOMLStructure(OMLStructure object) {
				return createOMLStructureAdapter();
			}
			@Override
			public Adapter caseOMLScalar(OMLScalar object) {
				return createOMLScalarAdapter();
			}
			@Override
			public Adapter caseOMLEntity(OMLEntity object) {
				return createOMLEntityAdapter();
			}
			@Override
			public Adapter caseOMLAspect(OMLAspect object) {
				return createOMLAspectAdapter();
			}
			@Override
			public Adapter caseOMLConcept(OMLConcept object) {
				return createOMLConceptAdapter();
			}
			@Override
			public Adapter caseOMLRelationshipFromEntity(OMLRelationshipFromEntity object) {
				return createOMLRelationshipFromEntityAdapter();
			}
			@Override
			public Adapter caseOMLRelationshipFromStructure(OMLRelationshipFromStructure object) {
				return createOMLRelationshipFromStructureAdapter();
			}
			@Override
			public Adapter caseOMLRelationshipToEntity(OMLRelationshipToEntity object) {
				return createOMLRelationshipToEntityAdapter();
			}
			@Override
			public Adapter caseOMLRelationshipToStructure(OMLRelationshipToStructure object) {
				return createOMLRelationshipToStructureAdapter();
			}
			@Override
			public Adapter caseOMLEntityRelationship(OMLEntityRelationship object) {
				return createOMLEntityRelationshipAdapter();
			}
			@Override
			public Adapter caseOMLReifiedRelationship(OMLReifiedRelationship object) {
				return createOMLReifiedRelationshipAdapter();
			}
			@Override
			public Adapter caseOMLUnreifiedRelationship(OMLUnreifiedRelationship object) {
				return createOMLUnreifiedRelationshipAdapter();
			}
			@Override
			public Adapter caseOMLEntityDataPropertyToScalar(OMLEntityDataPropertyToScalar object) {
				return createOMLEntityDataPropertyToScalarAdapter();
			}
			@Override
			public Adapter caseOMLEntityDataPropertyToStructure(OMLEntityDataPropertyToStructure object) {
				return createOMLEntityDataPropertyToStructureAdapter();
			}
			@Override
			public Adapter caseOMLStructureDataPropertyToScalar(OMLStructureDataPropertyToScalar object) {
				return createOMLStructureDataPropertyToScalarAdapter();
			}
			@Override
			public Adapter caseOMLStructureDataPropertyToStructure(OMLStructureDataPropertyToStructure object) {
				return createOMLStructureDataPropertyToStructureAdapter();
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
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLObject <em>OML Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLObject
	 * @generated
	 */
	public Adapter createOMLObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLDescription <em>OML Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLDescription
	 * @generated
	 */
	public Adapter createOMLDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLStructure <em>OML Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLStructure
	 * @generated
	 */
	public Adapter createOMLStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLScalar <em>OML Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLScalar
	 * @generated
	 */
	public Adapter createOMLScalarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntity <em>OML Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntity
	 * @generated
	 */
	public Adapter createOMLEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLAspect <em>OML Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLAspect
	 * @generated
	 */
	public Adapter createOMLAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLConcept <em>OML Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLConcept
	 * @generated
	 */
	public Adapter createOMLConceptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromEntity <em>OML Relationship From Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromEntity
	 * @generated
	 */
	public Adapter createOMLRelationshipFromEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromStructure <em>OML Relationship From Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipFromStructure
	 * @generated
	 */
	public Adapter createOMLRelationshipFromStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToEntity <em>OML Relationship To Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToEntity
	 * @generated
	 */
	public Adapter createOMLRelationshipToEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToStructure <em>OML Relationship To Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLRelationshipToStructure
	 * @generated
	 */
	public Adapter createOMLRelationshipToStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntityRelationship <em>OML Entity Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntityRelationship
	 * @generated
	 */
	public Adapter createOMLEntityRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship <em>OML Reified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship
	 * @generated
	 */
	public Adapter createOMLReifiedRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLUnreifiedRelationship <em>OML Unreified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLUnreifiedRelationship
	 * @generated
	 */
	public Adapter createOMLUnreifiedRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToScalar <em>OML Entity Data Property To Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToScalar
	 * @generated
	 */
	public Adapter createOMLEntityDataPropertyToScalarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToStructure <em>OML Entity Data Property To Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLEntityDataPropertyToStructure
	 * @generated
	 */
	public Adapter createOMLEntityDataPropertyToStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToScalar <em>OML Structure Data Property To Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToScalar
	 * @generated
	 */
	public Adapter createOMLStructureDataPropertyToScalarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToStructure <em>OML Structure Data Property To Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.runtime.OMLStructureDataPropertyToStructure
	 * @generated
	 */
	public Adapter createOMLStructureDataPropertyToStructureAdapter() {
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

} //RuntimeAdapterFactory
