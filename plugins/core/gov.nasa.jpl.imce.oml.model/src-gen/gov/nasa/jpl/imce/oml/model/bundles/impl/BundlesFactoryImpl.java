/**
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
			case BundlesPackage.BUNDLE: return createBundle();
			case BundlesPackage.SPECIFIC_DISJOINT_CONCEPT_AXIOM: return createSpecificDisjointConceptAxiom();
			case BundlesPackage.ANONYMOUS_CONCEPT_UNION_AXIOM: return createAnonymousConceptUnionAxiom();
			case BundlesPackage.ROOT_CONCEPT_TAXONOMY_AXIOM: return createRootConceptTaxonomyAxiom();
			case BundlesPackage.BUNDLED_TERMINOLOGY_AXIOM: return createBundledTerminologyAxiom();
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
