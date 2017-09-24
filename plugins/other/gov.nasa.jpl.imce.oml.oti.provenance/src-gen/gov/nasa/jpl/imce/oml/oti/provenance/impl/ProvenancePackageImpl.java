/**
 */
package gov.nasa.jpl.imce.oml.oti.provenance.impl;

import gov.nasa.jpl.imce.oml.oti.provenance.OML2OTIProvenance;
import gov.nasa.jpl.imce.oml.oti.provenance.ProvenanceFactory;
import gov.nasa.jpl.imce.oml.oti.provenance.ProvenancePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProvenancePackageImpl extends EPackageImpl implements ProvenancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oml2OTIProvenanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uuidEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType omL_IRIEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType otI_TOOL_SPECIFIC_IDEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType otI_TOOL_SPECIFIC_UUIDEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType otI_TOOL_SPECIFIC_URLEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see gov.nasa.jpl.imce.oml.oti.provenance.ProvenancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProvenancePackageImpl() {
		super(eNS_URI, ProvenanceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ProvenancePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProvenancePackage init() {
		if (isInited) return (ProvenancePackage)EPackage.Registry.INSTANCE.getEPackage(ProvenancePackage.eNS_URI);

		// Obtain or create and register package
		ProvenancePackageImpl theProvenancePackage = (ProvenancePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProvenancePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProvenancePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProvenancePackage.createPackageContents();

		// Initialize created meta-data
		theProvenancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProvenancePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProvenancePackage.eNS_URI, theProvenancePackage);
		return theProvenancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOML2OTIProvenance() {
		return oml2OTIProvenanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOML2OTIProvenance_OmlUUID() {
		return (EAttribute)oml2OTIProvenanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOML2OTIProvenance_OmlIRI() {
		return (EAttribute)oml2OTIProvenanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOML2OTIProvenance_OtiID() {
		return (EAttribute)oml2OTIProvenanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOML2OTIProvenance_OtiURL() {
		return (EAttribute)oml2OTIProvenanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOML2OTIProvenance_OtiUUID() {
		return (EAttribute)oml2OTIProvenanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOML2OTIProvenance_Explanation() {
		return (EAttribute)oml2OTIProvenanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUUID() {
		return uuidEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOML_IRI() {
		return omL_IRIEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOTI_TOOL_SPECIFIC_ID() {
		return otI_TOOL_SPECIFIC_IDEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOTI_TOOL_SPECIFIC_UUID() {
		return otI_TOOL_SPECIFIC_UUIDEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOTI_TOOL_SPECIFIC_URL() {
		return otI_TOOL_SPECIFIC_URLEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvenanceFactory getProvenanceFactory() {
		return (ProvenanceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		oml2OTIProvenanceEClass = createEClass(OML2OTI_PROVENANCE);
		createEAttribute(oml2OTIProvenanceEClass, OML2OTI_PROVENANCE__OML_UUID);
		createEAttribute(oml2OTIProvenanceEClass, OML2OTI_PROVENANCE__OML_IRI);
		createEAttribute(oml2OTIProvenanceEClass, OML2OTI_PROVENANCE__OTI_ID);
		createEAttribute(oml2OTIProvenanceEClass, OML2OTI_PROVENANCE__OTI_URL);
		createEAttribute(oml2OTIProvenanceEClass, OML2OTI_PROVENANCE__OTI_UUID);
		createEAttribute(oml2OTIProvenanceEClass, OML2OTI_PROVENANCE__EXPLANATION);

		// Create data types
		uuidEDataType = createEDataType(UUID);
		omL_IRIEDataType = createEDataType(OML_IRI);
		otI_TOOL_SPECIFIC_IDEDataType = createEDataType(OTI_TOOL_SPECIFIC_ID);
		otI_TOOL_SPECIFIC_UUIDEDataType = createEDataType(OTI_TOOL_SPECIFIC_UUID);
		otI_TOOL_SPECIFIC_URLEDataType = createEDataType(OTI_TOOL_SPECIFIC_URL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(oml2OTIProvenanceEClass, OML2OTIProvenance.class, "OML2OTIProvenance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOML2OTIProvenance_OmlUUID(), this.getUUID(), "omlUUID", null, 1, 1, OML2OTIProvenance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOML2OTIProvenance_OmlIRI(), this.getOML_IRI(), "omlIRI", null, 0, 1, OML2OTIProvenance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOML2OTIProvenance_OtiID(), this.getOTI_TOOL_SPECIFIC_ID(), "otiID", null, 1, 1, OML2OTIProvenance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOML2OTIProvenance_OtiURL(), this.getOTI_TOOL_SPECIFIC_URL(), "otiURL", null, 1, 1, OML2OTIProvenance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOML2OTIProvenance_OtiUUID(), this.getOTI_TOOL_SPECIFIC_UUID(), "otiUUID", null, 0, 1, OML2OTIProvenance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOML2OTIProvenance_Explanation(), theEcorePackage.getEString(), "explanation", null, 1, 1, OML2OTIProvenance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(uuidEDataType, String.class, "UUID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(omL_IRIEDataType, String.class, "OML_IRI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(otI_TOOL_SPECIFIC_IDEDataType, String.class, "OTI_TOOL_SPECIFIC_ID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(otI_TOOL_SPECIFIC_UUIDEDataType, String.class, "OTI_TOOL_SPECIFIC_UUID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(otI_TOOL_SPECIFIC_URLEDataType, String.class, "OTI_TOOL_SPECIFIC_URL", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
		   });
	}

} //ProvenancePackageImpl
