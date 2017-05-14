/**
 * 
 * Copyright 2016 California Institute of Technology ("Caltech").
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
package gov.nasa.jpl.imce.oml.model.bundles.impl;

import gov.nasa.jpl.imce.oml.model.bundles.*;

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
public class BundlesFactoryImpl extends EFactoryImpl implements BundlesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BundlesFactory init() {
		try {
			BundlesFactory theBundlesFactory = (BundlesFactory)EPackage.Registry.INSTANCE.getEFactory(BundlesPackage.eNS_URI);
			if (theBundlesFactory != null) {
				return theBundlesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BundlesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundlesFactoryImpl() {
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
			case BundlesPackage.BUNDLE: return (EObject)createBundle();
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM: return (EObject)createSpecificDisjointConceptAxiom();
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM: return (EObject)createAnonymousConceptUnionAxiom();
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM: return (EObject)createRootConceptTaxonomyAxiom();
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM: return (EObject)createBundledTerminologyAxiom();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle createBundle() {
		BundleImpl bundle = new BundleImpl();
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificDisjointConceptAxiom createSpecificDisjointConceptAxiom() {
		SpecificDisjointConceptAxiomImpl specificDisjointConceptAxiom = new SpecificDisjointConceptAxiomImpl();
		return specificDisjointConceptAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnonymousConceptUnionAxiom createAnonymousConceptUnionAxiom() {
		AnonymousConceptUnionAxiomImpl anonymousConceptUnionAxiom = new AnonymousConceptUnionAxiomImpl();
		return anonymousConceptUnionAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootConceptTaxonomyAxiom createRootConceptTaxonomyAxiom() {
		RootConceptTaxonomyAxiomImpl rootConceptTaxonomyAxiom = new RootConceptTaxonomyAxiomImpl();
		return rootConceptTaxonomyAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundledTerminologyAxiom createBundledTerminologyAxiom() {
		BundledTerminologyAxiomImpl bundledTerminologyAxiom = new BundledTerminologyAxiomImpl();
		return bundledTerminologyAxiom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundlesPackage getBundlesPackage() {
		return (BundlesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BundlesPackage getPackage() {
		return BundlesPackage.eINSTANCE;
	}

} //BundlesFactoryImpl
