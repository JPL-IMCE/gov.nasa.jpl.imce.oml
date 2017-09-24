/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML Extent is an in-memory store of all OML Element(s)
 * loaded from external OML documents.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.Extent#getModules <em>Modules</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.Extent#getAnnotationProperties <em>Annotation Properties</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getExtent()
 * @model
 * @generated
 */
public interface Extent extends EObject {
	/**
	 * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.common.Module}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.common.Module#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modules</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getExtent_Modules()
	 * @see gov.nasa.jpl.imce.oml.model.common.Module#getExtent
	 * @model opposite="extent" containment="true"
	 * @generated
	 */
	EList<Module> getModules();

	/**
	 * Returns the value of the '<em><b>Annotation Properties</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Properties</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getExtent_AnnotationProperties()
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getExtent
	 * @model opposite="extent" containment="true"
	 * @generated
	 */
	EList<AnnotationProperty> getAnnotationProperties();

} // Extent
