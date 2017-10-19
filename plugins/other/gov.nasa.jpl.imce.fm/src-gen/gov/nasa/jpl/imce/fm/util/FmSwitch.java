/**
 */
package gov.nasa.jpl.imce.fm.util;

import gov.nasa.jpl.imce.fm.BinaryCompositeAssociation;
import gov.nasa.jpl.imce.fm.BinaryDirectedRelationship;
import gov.nasa.jpl.imce.fm.Entity;
import gov.nasa.jpl.imce.fm.EssentialAttribute;
import gov.nasa.jpl.imce.fm.EssentialReference;
import gov.nasa.jpl.imce.fm.Extent;
import gov.nasa.jpl.imce.fm.FmPackage;
import gov.nasa.jpl.imce.fm.InformationCarryingMetaclass;
import gov.nasa.jpl.imce.fm.InformationContainerMetaclass;
import gov.nasa.jpl.imce.fm.Metaclass;
import gov.nasa.jpl.imce.fm.NaturalInteger;
import gov.nasa.jpl.imce.fm.PrimitiveType;
import gov.nasa.jpl.imce.fm.Type;
import gov.nasa.jpl.imce.fm.Value;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.fm.FmPackage
 * @generated
 */
public class FmSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmSwitch() {
		if (modelPackage == null) {
			modelPackage = FmPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FmPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.BOOLEAN: {
				gov.nasa.jpl.imce.fm.Boolean boolean_ = (gov.nasa.jpl.imce.fm.Boolean)theEObject;
				T result = caseBoolean(boolean_);
				if (result == null) result = casePrimitiveType(boolean_);
				if (result == null) result = caseType(boolean_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.STRING: {
				gov.nasa.jpl.imce.fm.String string = (gov.nasa.jpl.imce.fm.String)theEObject;
				T result = caseString(string);
				if (result == null) result = casePrimitiveType(string);
				if (result == null) result = caseType(string);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.INTEGER: {
				gov.nasa.jpl.imce.fm.Integer integer = (gov.nasa.jpl.imce.fm.Integer)theEObject;
				T result = caseInteger(integer);
				if (result == null) result = casePrimitiveType(integer);
				if (result == null) result = caseType(integer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.NATURAL_INTEGER: {
				NaturalInteger naturalInteger = (NaturalInteger)theEObject;
				T result = caseNaturalInteger(naturalInteger);
				if (result == null) result = casePrimitiveType(naturalInteger);
				if (result == null) result = caseType(naturalInteger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.METACLASS: {
				Metaclass metaclass = (Metaclass)theEObject;
				T result = caseMetaclass(metaclass);
				if (result == null) result = caseType(metaclass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.INFORMATION_CARRYING_METACLASS: {
				InformationCarryingMetaclass informationCarryingMetaclass = (InformationCarryingMetaclass)theEObject;
				T result = caseInformationCarryingMetaclass(informationCarryingMetaclass);
				if (result == null) result = caseMetaclass(informationCarryingMetaclass);
				if (result == null) result = caseType(informationCarryingMetaclass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.INFORMATION_CONTAINER_METACLASS: {
				InformationContainerMetaclass informationContainerMetaclass = (InformationContainerMetaclass)theEObject;
				T result = caseInformationContainerMetaclass(informationContainerMetaclass);
				if (result == null) result = caseMetaclass(informationContainerMetaclass);
				if (result == null) result = caseType(informationContainerMetaclass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = caseInformationCarryingMetaclass(value);
				if (result == null) result = caseMetaclass(value);
				if (result == null) result = caseType(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.ENTITY: {
				Entity entity = (Entity)theEObject;
				T result = caseEntity(entity);
				if (result == null) result = caseInformationCarryingMetaclass(entity);
				if (result == null) result = caseInformationContainerMetaclass(entity);
				if (result == null) result = caseMetaclass(entity);
				if (result == null) result = caseType(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.EXTENT: {
				Extent extent = (Extent)theEObject;
				T result = caseExtent(extent);
				if (result == null) result = caseInformationContainerMetaclass(extent);
				if (result == null) result = caseMetaclass(extent);
				if (result == null) result = caseType(extent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.BINARY_DIRECTED_RELATIONSHIP: {
				BinaryDirectedRelationship binaryDirectedRelationship = (BinaryDirectedRelationship)theEObject;
				T result = caseBinaryDirectedRelationship(binaryDirectedRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.BINARY_COMPOSITE_ASSOCIATION: {
				BinaryCompositeAssociation binaryCompositeAssociation = (BinaryCompositeAssociation)theEObject;
				T result = caseBinaryCompositeAssociation(binaryCompositeAssociation);
				if (result == null) result = caseBinaryDirectedRelationship(binaryCompositeAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.ESSENTIAL_REFERENCE: {
				EssentialReference essentialReference = (EssentialReference)theEObject;
				T result = caseEssentialReference(essentialReference);
				if (result == null) result = caseBinaryDirectedRelationship(essentialReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmPackage.ESSENTIAL_ATTRIBUTE: {
				EssentialAttribute essentialAttribute = (EssentialAttribute)theEObject;
				T result = caseEssentialAttribute(essentialAttribute);
				if (result == null) result = caseBinaryDirectedRelationship(essentialAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolean(gov.nasa.jpl.imce.fm.Boolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseString(gov.nasa.jpl.imce.fm.String object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteger(gov.nasa.jpl.imce.fm.Integer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Natural Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Natural Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNaturalInteger(NaturalInteger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metaclass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metaclass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaclass(Metaclass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Information Carrying Metaclass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Information Carrying Metaclass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInformationCarryingMetaclass(InformationCarryingMetaclass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Information Container Metaclass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Information Container Metaclass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInformationContainerMetaclass(InformationContainerMetaclass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtent(Extent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Directed Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Directed Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryDirectedRelationship(BinaryDirectedRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Composite Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Composite Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryCompositeAssociation(BinaryCompositeAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Essential Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Essential Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEssentialReference(EssentialReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Essential Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Essential Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEssentialAttribute(EssentialAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //FmSwitch
