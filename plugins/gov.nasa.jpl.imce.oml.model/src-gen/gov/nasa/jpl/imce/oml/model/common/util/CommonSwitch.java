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
package gov.nasa.jpl.imce.oml.model.common.util;

import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.ExtrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IdentityKind;
import gov.nasa.jpl.imce.oml.model.common.IntrinsicIdentityKind;
import gov.nasa.jpl.imce.oml.model.common.LiteralBoolean;
import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime;
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal;
import gov.nasa.jpl.imce.oml.model.common.LiteralFloat;
import gov.nasa.jpl.imce.oml.model.common.LiteralNumber;
import gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString;
import gov.nasa.jpl.imce.oml.model.common.LiteralRational;
import gov.nasa.jpl.imce.oml.model.common.LiteralRawString;
import gov.nasa.jpl.imce.oml.model.common.LiteralReal;
import gov.nasa.jpl.imce.oml.model.common.LiteralString;
import gov.nasa.jpl.imce.oml.model.common.LiteralURI;
import gov.nasa.jpl.imce.oml.model.common.LiteralUUID;
import gov.nasa.jpl.imce.oml.model.common.LiteralValue;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;
import gov.nasa.jpl.imce.oml.model.common.NonCrossReferencableKind;
import gov.nasa.jpl.imce.oml.model.common.NonLogicalElement;
import gov.nasa.jpl.imce.oml.model.common.Resource;
import gov.nasa.jpl.imce.oml.model.common.ValueCrossReferenceTuple;

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
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage
 * @generated
 */
public class CommonSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CommonPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonSwitch() {
		if (modelPackage == null) {
			modelPackage = CommonPackage.eINSTANCE;
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
			case CommonPackage.LITERAL_VALUE: {
				LiteralValue literalValue = (LiteralValue)theEObject;
				T result = caseLiteralValue(literalValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_BOOLEAN: {
				LiteralBoolean literalBoolean = (LiteralBoolean)theEObject;
				T result = caseLiteralBoolean(literalBoolean);
				if (result == null) result = caseLiteralValue(literalBoolean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_DATE_TIME: {
				LiteralDateTime literalDateTime = (LiteralDateTime)theEObject;
				T result = caseLiteralDateTime(literalDateTime);
				if (result == null) result = caseLiteralValue(literalDateTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_STRING: {
				LiteralString literalString = (LiteralString)theEObject;
				T result = caseLiteralString(literalString);
				if (result == null) result = caseLiteralValue(literalString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_QUOTED_STRING: {
				LiteralQuotedString literalQuotedString = (LiteralQuotedString)theEObject;
				T result = caseLiteralQuotedString(literalQuotedString);
				if (result == null) result = caseLiteralString(literalQuotedString);
				if (result == null) result = caseLiteralValue(literalQuotedString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_RAW_STRING: {
				LiteralRawString literalRawString = (LiteralRawString)theEObject;
				T result = caseLiteralRawString(literalRawString);
				if (result == null) result = caseLiteralString(literalRawString);
				if (result == null) result = caseLiteralValue(literalRawString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_UUID: {
				LiteralUUID literalUUID = (LiteralUUID)theEObject;
				T result = caseLiteralUUID(literalUUID);
				if (result == null) result = caseLiteralValue(literalUUID);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_URI: {
				LiteralURI literalURI = (LiteralURI)theEObject;
				T result = caseLiteralURI(literalURI);
				if (result == null) result = caseLiteralValue(literalURI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_NUMBER: {
				LiteralNumber literalNumber = (LiteralNumber)theEObject;
				T result = caseLiteralNumber(literalNumber);
				if (result == null) result = caseLiteralValue(literalNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_REAL: {
				LiteralReal literalReal = (LiteralReal)theEObject;
				T result = caseLiteralReal(literalReal);
				if (result == null) result = caseLiteralNumber(literalReal);
				if (result == null) result = caseLiteralValue(literalReal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_RATIONAL: {
				LiteralRational literalRational = (LiteralRational)theEObject;
				T result = caseLiteralRational(literalRational);
				if (result == null) result = caseLiteralNumber(literalRational);
				if (result == null) result = caseLiteralValue(literalRational);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_FLOAT: {
				LiteralFloat literalFloat = (LiteralFloat)theEObject;
				T result = caseLiteralFloat(literalFloat);
				if (result == null) result = caseLiteralNumber(literalFloat);
				if (result == null) result = caseLiteralValue(literalFloat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LITERAL_DECIMAL: {
				LiteralDecimal literalDecimal = (LiteralDecimal)theEObject;
				T result = caseLiteralDecimal(literalDecimal);
				if (result == null) result = caseLiteralNumber(literalDecimal);
				if (result == null) result = caseLiteralValue(literalDecimal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.CROSS_REFERENCABILITY_KIND: {
				CrossReferencabilityKind crossReferencabilityKind = (CrossReferencabilityKind)theEObject;
				T result = caseCrossReferencabilityKind(crossReferencabilityKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.CROSS_REFERENCABLE_KIND: {
				CrossReferencableKind crossReferencableKind = (CrossReferencableKind)theEObject;
				T result = caseCrossReferencableKind(crossReferencableKind);
				if (result == null) result = caseCrossReferencabilityKind(crossReferencableKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.NON_CROSS_REFERENCABLE_KIND: {
				NonCrossReferencableKind nonCrossReferencableKind = (NonCrossReferencableKind)theEObject;
				T result = caseNonCrossReferencableKind(nonCrossReferencableKind);
				if (result == null) result = caseCrossReferencabilityKind(nonCrossReferencableKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.IDENTITY_KIND: {
				IdentityKind identityKind = (IdentityKind)theEObject;
				T result = caseIdentityKind(identityKind);
				if (result == null) result = caseCrossReferencabilityKind(identityKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.INTRINSIC_IDENTITY_KIND: {
				IntrinsicIdentityKind intrinsicIdentityKind = (IntrinsicIdentityKind)theEObject;
				T result = caseIntrinsicIdentityKind(intrinsicIdentityKind);
				if (result == null) result = caseIdentityKind(intrinsicIdentityKind);
				if (result == null) result = caseCrossReferencableKind(intrinsicIdentityKind);
				if (result == null) result = caseCrossReferencabilityKind(intrinsicIdentityKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.EXTRINSIC_IDENTITY_KIND: {
				ExtrinsicIdentityKind extrinsicIdentityKind = (ExtrinsicIdentityKind)theEObject;
				T result = caseExtrinsicIdentityKind(extrinsicIdentityKind);
				if (result == null) result = caseIdentityKind(extrinsicIdentityKind);
				if (result == null) result = caseCrossReferencabilityKind(extrinsicIdentityKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.ELEMENT_CROSS_REFERENCE_TUPLE: {
				ElementCrossReferenceTuple elementCrossReferenceTuple = (ElementCrossReferenceTuple)theEObject;
				T result = caseElementCrossReferenceTuple(elementCrossReferenceTuple);
				if (result == null) result = caseExtrinsicIdentityKind(elementCrossReferenceTuple);
				if (result == null) result = caseCrossReferencableKind(elementCrossReferenceTuple);
				if (result == null) result = caseLogicalElement(elementCrossReferenceTuple);
				if (result == null) result = caseIdentityKind(elementCrossReferenceTuple);
				if (result == null) result = caseCrossReferencabilityKind(elementCrossReferenceTuple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.VALUE_CROSS_REFERENCE_TUPLE: {
				ValueCrossReferenceTuple valueCrossReferenceTuple = (ValueCrossReferenceTuple)theEObject;
				T result = caseValueCrossReferenceTuple(valueCrossReferenceTuple);
				if (result == null) result = caseExtrinsicIdentityKind(valueCrossReferenceTuple);
				if (result == null) result = caseNonCrossReferencableKind(valueCrossReferenceTuple);
				if (result == null) result = caseIdentityKind(valueCrossReferenceTuple);
				if (result == null) result = caseCrossReferencabilityKind(valueCrossReferenceTuple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.LOGICAL_ELEMENT: {
				LogicalElement logicalElement = (LogicalElement)theEObject;
				T result = caseLogicalElement(logicalElement);
				if (result == null) result = caseIdentityKind(logicalElement);
				if (result == null) result = caseCrossReferencabilityKind(logicalElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.NON_LOGICAL_ELEMENT: {
				NonLogicalElement nonLogicalElement = (NonLogicalElement)theEObject;
				T result = caseNonLogicalElement(nonLogicalElement);
				if (result == null) result = caseIdentityKind(nonLogicalElement);
				if (result == null) result = caseCrossReferencabilityKind(nonLogicalElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseLogicalElement(resource);
				if (result == null) result = caseIntrinsicIdentityKind(resource);
				if (result == null) result = caseIdentityKind(resource);
				if (result == null) result = caseCrossReferencableKind(resource);
				if (result == null) result = caseCrossReferencabilityKind(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.MODULE_ELEMENT: {
				ModuleElement moduleElement = (ModuleElement)theEObject;
				T result = caseModuleElement(moduleElement);
				if (result == null) result = caseLogicalElement(moduleElement);
				if (result == null) result = caseIdentityKind(moduleElement);
				if (result == null) result = caseCrossReferencabilityKind(moduleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.MODULE_EDGE: {
				ModuleEdge moduleEdge = (ModuleEdge)theEObject;
				T result = caseModuleEdge(moduleEdge);
				if (result == null) result = caseElementCrossReferenceTuple(moduleEdge);
				if (result == null) result = caseExtrinsicIdentityKind(moduleEdge);
				if (result == null) result = caseCrossReferencableKind(moduleEdge);
				if (result == null) result = caseLogicalElement(moduleEdge);
				if (result == null) result = caseIdentityKind(moduleEdge);
				if (result == null) result = caseCrossReferencabilityKind(moduleEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.ANNOTATION_PROPERTY: {
				AnnotationProperty annotationProperty = (AnnotationProperty)theEObject;
				T result = caseAnnotationProperty(annotationProperty);
				if (result == null) result = caseIntrinsicIdentityKind(annotationProperty);
				if (result == null) result = caseNonLogicalElement(annotationProperty);
				if (result == null) result = caseIdentityKind(annotationProperty);
				if (result == null) result = caseCrossReferencableKind(annotationProperty);
				if (result == null) result = caseCrossReferencabilityKind(annotationProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.ANNOTATION_PROPERTY_VALUE: {
				AnnotationPropertyValue annotationPropertyValue = (AnnotationPropertyValue)theEObject;
				T result = caseAnnotationPropertyValue(annotationPropertyValue);
				if (result == null) result = caseValueCrossReferenceTuple(annotationPropertyValue);
				if (result == null) result = caseNonLogicalElement(annotationPropertyValue);
				if (result == null) result = caseExtrinsicIdentityKind(annotationPropertyValue);
				if (result == null) result = caseNonCrossReferencableKind(annotationPropertyValue);
				if (result == null) result = caseIdentityKind(annotationPropertyValue);
				if (result == null) result = caseCrossReferencabilityKind(annotationPropertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.EXTENT: {
				Extent extent = (Extent)theEObject;
				T result = caseExtent(extent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonPackage.MODULE: {
				gov.nasa.jpl.imce.oml.model.common.Module module = (gov.nasa.jpl.imce.oml.model.common.Module)theEObject;
				T result = caseModule(module);
				if (result == null) result = caseResource(module);
				if (result == null) result = caseLogicalElement(module);
				if (result == null) result = caseIntrinsicIdentityKind(module);
				if (result == null) result = caseIdentityKind(module);
				if (result == null) result = caseCrossReferencableKind(module);
				if (result == null) result = caseCrossReferencabilityKind(module);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralValue(LiteralValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralBoolean(LiteralBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Date Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Date Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralDateTime(LiteralDateTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralString(LiteralString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Quoted String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Quoted String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralQuotedString(LiteralQuotedString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Raw String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Raw String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralRawString(LiteralRawString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal UUID</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal UUID</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralUUID(LiteralUUID object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal URI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal URI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralURI(LiteralURI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralNumber(LiteralNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Real</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Real</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralReal(LiteralReal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Rational</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Rational</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralRational(LiteralRational object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Float</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Float</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralFloat(LiteralFloat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Decimal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Decimal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralDecimal(LiteralDecimal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cross Referencability Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cross Referencability Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCrossReferencabilityKind(CrossReferencabilityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cross Referencable Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cross Referencable Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCrossReferencableKind(CrossReferencableKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Cross Referencable Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Cross Referencable Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonCrossReferencableKind(NonCrossReferencableKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentityKind(IdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intrinsic Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intrinsic Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntrinsicIdentityKind(IntrinsicIdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extrinsic Identity Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extrinsic Identity Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtrinsicIdentityKind(ExtrinsicIdentityKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Cross Reference Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Cross Reference Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCrossReferenceTuple(ElementCrossReferenceTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Cross Reference Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Cross Reference Tuple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueCrossReferenceTuple(ValueCrossReferenceTuple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalElement(LogicalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Logical Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Logical Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonLogicalElement(NonLogicalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleElement(ModuleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleEdge(ModuleEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationProperty(AnnotationProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationPropertyValue(AnnotationPropertyValue object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(gov.nasa.jpl.imce.oml.model.common.Module object) {
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

} //CommonSwitch
