/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML Resource is an abstraction for
 * everything in a vocabulary that is identifiable
 * locally by name within the vocabulary and
 * globally by an IRI across multiple vocabularies.
 * For a particular OML Resource, the constraints
 * between its name and its IRI depend on what kind of OML Resource it is.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getResource()
 * @model abstract="true"
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.IRI" unique="false"
	 * @generated
	 */
	String iri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.LocalName" unique="false" required="true"
	 * @generated
	 */
	String name();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	String abbrevIRI();

} // Resource
