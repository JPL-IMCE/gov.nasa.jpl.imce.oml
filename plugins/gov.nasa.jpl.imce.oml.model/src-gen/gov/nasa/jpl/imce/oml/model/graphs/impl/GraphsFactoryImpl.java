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
package gov.nasa.jpl.imce.oml.model.graphs.impl;

import gov.nasa.jpl.imce.oml.model.graphs.*;

import org.eclipse.emf.ecore.EClass;
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
public class GraphsFactoryImpl extends EFactoryImpl implements GraphsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphsFactory init() {
		try {
			GraphsFactory theGraphsFactory = (GraphsFactory)EPackage.Registry.INSTANCE.getEFactory(GraphsPackage.eNS_URI);
			if (theGraphsFactory != null) {
				return theGraphsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphsFactoryImpl() {
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
			case GraphsPackage.TERMINOLOGY_GRAPH: return createTerminologyGraph();
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM: return createConceptDesignationTerminologyAxiom();
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM: return createTerminologyNestingAxiom();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyGraph createTerminologyGraph() {
		TerminologyGraphImpl terminologyGraph = new TerminologyGraphImpl();
		return terminologyGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptDesignationTerminologyAxiom createConceptDesignationTerminologyAxiom() {
		ConceptDesignationTerminologyAxiomImpl conceptDesignationTerminologyAxiom = new ConceptDesignationTerminologyAxiomImpl();
		return conceptDesignationTerminologyAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyNestingAxiom createTerminologyNestingAxiom() {
		TerminologyNestingAxiomImpl terminologyNestingAxiom = new TerminologyNestingAxiomImpl();
		return terminologyNestingAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphsPackage getGraphsPackage() {
		return (GraphsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphsPackage getPackage() {
		return GraphsPackage.eINSTANCE;
	}

} //GraphsFactoryImpl
