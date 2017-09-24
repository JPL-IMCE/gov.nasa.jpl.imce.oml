/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ModuleElement is an OML Element defined in the scope of an OML Module
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getModuleElement()
 * @model abstract="true"
 * @generated
 */
public interface ModuleElement extends Element {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<Element> allNestedElements();

} // ModuleElement
