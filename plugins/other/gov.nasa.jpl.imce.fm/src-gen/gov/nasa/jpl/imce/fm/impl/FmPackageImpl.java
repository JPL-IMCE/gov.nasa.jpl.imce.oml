/**
 */
package gov.nasa.jpl.imce.fm.impl;

import gov.nasa.jpl.imce.fm.BinaryCompositeAssociation;
import gov.nasa.jpl.imce.fm.BinaryDirectedRelationship;
import gov.nasa.jpl.imce.fm.Entity;
import gov.nasa.jpl.imce.fm.EssentialAttribute;
import gov.nasa.jpl.imce.fm.EssentialReference;
import gov.nasa.jpl.imce.fm.Extent;
import gov.nasa.jpl.imce.fm.FmFactory;
import gov.nasa.jpl.imce.fm.FmPackage;
import gov.nasa.jpl.imce.fm.InformationCarryingMetaclass;
import gov.nasa.jpl.imce.fm.InformationContainerMetaclass;
import gov.nasa.jpl.imce.fm.Metaclass;
import gov.nasa.jpl.imce.fm.NaturalInteger;
import gov.nasa.jpl.imce.fm.PrimitiveType;
import gov.nasa.jpl.imce.fm.Type;
import gov.nasa.jpl.imce.fm.Value;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FmPackageImpl extends EPackageImpl implements FmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass naturalIntegerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informationCarryingMetaclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informationContainerMetaclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryDirectedRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryCompositeAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass essentialReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass essentialAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dtStringEDataType = null;

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
	 * @see gov.nasa.jpl.imce.fm.FmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FmPackageImpl() {
		super(eNS_URI, FmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FmPackage init() {
		if (isInited) return (FmPackage)EPackage.Registry.INSTANCE.getEPackage(FmPackage.eNS_URI);

		// Obtain or create and register package
		FmPackageImpl theFmPackage = (FmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FmPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFmPackage.createPackageContents();

		// Initialize created meta-data
		theFmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FmPackage.eNS_URI, theFmPackage);
		return theFmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Name() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoolean() {
		return booleanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getString() {
		return stringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteger() {
		return integerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNaturalInteger() {
		return naturalIntegerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaclass() {
		return metaclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInformationCarryingMetaclass() {
		return informationCarryingMetaclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInformationContainerMetaclass() {
		return informationContainerMetaclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtent() {
		return extentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryDirectedRelationship() {
		return binaryDirectedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryDirectedRelationship__Domain() {
		return binaryDirectedRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryDirectedRelationship__Range() {
		return binaryDirectedRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryCompositeAssociation() {
		return binaryCompositeAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryCompositeAssociation_Source() {
		return (EReference)binaryCompositeAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryCompositeAssociation_SourceRoleName() {
		return (EAttribute)binaryCompositeAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryCompositeAssociation_Target() {
		return (EReference)binaryCompositeAssociationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryCompositeAssociation_TargetRoleName() {
		return (EAttribute)binaryCompositeAssociationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryCompositeAssociation__Domain() {
		return binaryCompositeAssociationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryCompositeAssociation__Range() {
		return binaryCompositeAssociationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEssentialReference() {
		return essentialReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEssentialReference_Source() {
		return (EReference)essentialReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEssentialReference_Target() {
		return (EReference)essentialReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEssentialReference_ReferenceName() {
		return (EAttribute)essentialReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEssentialReference__Domain() {
		return essentialReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEssentialReference__Range() {
		return essentialReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEssentialAttribute() {
		return essentialAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEssentialAttribute_Source() {
		return (EReference)essentialAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEssentialAttribute_Target() {
		return (EReference)essentialAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEssentialAttribute_AttributeName() {
		return (EAttribute)essentialAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEssentialAttribute__Domain() {
		return essentialAttributeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEssentialAttribute__Range() {
		return essentialAttributeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDTString() {
		return dtStringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmFactory getFmFactory() {
		return (FmFactory)getEFactoryInstance();
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
		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__NAME);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		booleanEClass = createEClass(BOOLEAN);

		stringEClass = createEClass(STRING);

		integerEClass = createEClass(INTEGER);

		naturalIntegerEClass = createEClass(NATURAL_INTEGER);

		metaclassEClass = createEClass(METACLASS);

		informationCarryingMetaclassEClass = createEClass(INFORMATION_CARRYING_METACLASS);

		informationContainerMetaclassEClass = createEClass(INFORMATION_CONTAINER_METACLASS);

		valueEClass = createEClass(VALUE);

		entityEClass = createEClass(ENTITY);

		extentEClass = createEClass(EXTENT);

		binaryDirectedRelationshipEClass = createEClass(BINARY_DIRECTED_RELATIONSHIP);
		createEOperation(binaryDirectedRelationshipEClass, BINARY_DIRECTED_RELATIONSHIP___DOMAIN);
		createEOperation(binaryDirectedRelationshipEClass, BINARY_DIRECTED_RELATIONSHIP___RANGE);

		binaryCompositeAssociationEClass = createEClass(BINARY_COMPOSITE_ASSOCIATION);
		createEReference(binaryCompositeAssociationEClass, BINARY_COMPOSITE_ASSOCIATION__SOURCE);
		createEAttribute(binaryCompositeAssociationEClass, BINARY_COMPOSITE_ASSOCIATION__SOURCE_ROLE_NAME);
		createEReference(binaryCompositeAssociationEClass, BINARY_COMPOSITE_ASSOCIATION__TARGET);
		createEAttribute(binaryCompositeAssociationEClass, BINARY_COMPOSITE_ASSOCIATION__TARGET_ROLE_NAME);
		createEOperation(binaryCompositeAssociationEClass, BINARY_COMPOSITE_ASSOCIATION___DOMAIN);
		createEOperation(binaryCompositeAssociationEClass, BINARY_COMPOSITE_ASSOCIATION___RANGE);

		essentialReferenceEClass = createEClass(ESSENTIAL_REFERENCE);
		createEReference(essentialReferenceEClass, ESSENTIAL_REFERENCE__SOURCE);
		createEReference(essentialReferenceEClass, ESSENTIAL_REFERENCE__TARGET);
		createEAttribute(essentialReferenceEClass, ESSENTIAL_REFERENCE__REFERENCE_NAME);
		createEOperation(essentialReferenceEClass, ESSENTIAL_REFERENCE___DOMAIN);
		createEOperation(essentialReferenceEClass, ESSENTIAL_REFERENCE___RANGE);

		essentialAttributeEClass = createEClass(ESSENTIAL_ATTRIBUTE);
		createEReference(essentialAttributeEClass, ESSENTIAL_ATTRIBUTE__SOURCE);
		createEReference(essentialAttributeEClass, ESSENTIAL_ATTRIBUTE__TARGET);
		createEAttribute(essentialAttributeEClass, ESSENTIAL_ATTRIBUTE__ATTRIBUTE_NAME);
		createEOperation(essentialAttributeEClass, ESSENTIAL_ATTRIBUTE___DOMAIN);
		createEOperation(essentialAttributeEClass, ESSENTIAL_ATTRIBUTE___RANGE);

		// Create data types
		dtStringEDataType = createEDataType(DT_STRING);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		primitiveTypeEClass.getESuperTypes().add(this.getType());
		booleanEClass.getESuperTypes().add(this.getPrimitiveType());
		stringEClass.getESuperTypes().add(this.getPrimitiveType());
		integerEClass.getESuperTypes().add(this.getPrimitiveType());
		naturalIntegerEClass.getESuperTypes().add(this.getPrimitiveType());
		metaclassEClass.getESuperTypes().add(this.getType());
		informationCarryingMetaclassEClass.getESuperTypes().add(this.getMetaclass());
		informationContainerMetaclassEClass.getESuperTypes().add(this.getMetaclass());
		valueEClass.getESuperTypes().add(this.getInformationCarryingMetaclass());
		entityEClass.getESuperTypes().add(this.getInformationCarryingMetaclass());
		entityEClass.getESuperTypes().add(this.getInformationContainerMetaclass());
		extentEClass.getESuperTypes().add(this.getInformationContainerMetaclass());
		binaryCompositeAssociationEClass.getESuperTypes().add(this.getBinaryDirectedRelationship());
		essentialReferenceEClass.getESuperTypes().add(this.getBinaryDirectedRelationship());
		essentialAttributeEClass.getESuperTypes().add(this.getBinaryDirectedRelationship());

		// Initialize classes, features, and operations; add parameters
		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_Name(), this.getDTString(), "name", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanEClass, gov.nasa.jpl.imce.fm.Boolean.class, "Boolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringEClass, gov.nasa.jpl.imce.fm.String.class, "String", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerEClass, gov.nasa.jpl.imce.fm.Integer.class, "Integer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(naturalIntegerEClass, NaturalInteger.class, "NaturalInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaclassEClass, Metaclass.class, "Metaclass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(informationCarryingMetaclassEClass, InformationCarryingMetaclass.class, "InformationCarryingMetaclass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(informationContainerMetaclassEClass, InformationContainerMetaclass.class, "InformationContainerMetaclass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(extentEClass, Extent.class, "Extent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryDirectedRelationshipEClass, BinaryDirectedRelationship.class, "BinaryDirectedRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getBinaryDirectedRelationship__Domain(), this.getMetaclass(), "domain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryDirectedRelationship__Range(), this.getType(), "range", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(binaryCompositeAssociationEClass, BinaryCompositeAssociation.class, "BinaryCompositeAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryCompositeAssociation_Source(), this.getInformationContainerMetaclass(), null, "source", null, 1, 1, BinaryCompositeAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryCompositeAssociation_SourceRoleName(), this.getDTString(), "sourceRoleName", null, 1, 1, BinaryCompositeAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryCompositeAssociation_Target(), this.getInformationCarryingMetaclass(), null, "target", null, 1, 1, BinaryCompositeAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryCompositeAssociation_TargetRoleName(), this.getDTString(), "targetRoleName", null, 1, 1, BinaryCompositeAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBinaryCompositeAssociation__Domain(), this.getMetaclass(), "domain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryCompositeAssociation__Range(), this.getType(), "range", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(essentialReferenceEClass, EssentialReference.class, "EssentialReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEssentialReference_Source(), this.getInformationCarryingMetaclass(), null, "source", null, 1, 1, EssentialReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEssentialReference_Target(), this.getEntity(), null, "target", null, 1, 1, EssentialReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEssentialReference_ReferenceName(), this.getDTString(), "referenceName", null, 1, 1, EssentialReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEssentialReference__Domain(), this.getMetaclass(), "domain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEssentialReference__Range(), this.getType(), "range", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(essentialAttributeEClass, EssentialAttribute.class, "EssentialAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEssentialAttribute_Source(), this.getInformationCarryingMetaclass(), null, "source", null, 1, 1, EssentialAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEssentialAttribute_Target(), this.getPrimitiveType(), null, "target", null, 1, 1, EssentialAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEssentialAttribute_AttributeName(), this.getDTString(), "attributeName", null, 1, 1, EssentialAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEssentialAttribute__Domain(), this.getMetaclass(), "domain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEssentialAttribute__Range(), this.getType(), "range", 1, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(dtStringEDataType, gov.nasa.jpl.imce.fm.String.class, "DTString", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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

} //FmPackageImpl
