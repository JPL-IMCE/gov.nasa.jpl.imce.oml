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
package gov.nasa.jpl.imce.oml.runtime;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage
 * @generated
 */
public interface OMLRuntimeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OMLRuntimeFactory eINSTANCE = gov.nasa.jpl.imce.oml.runtime.impl.OMLRuntimeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>OML Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Description</em>'.
	 * @generated
	 */
	OMLDescription createOMLDescription();

	/**
	 * Returns a new object of class '<em>OML Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Structure</em>'.
	 * @generated
	 */
	OMLStructure createOMLStructure();

	/**
	 * Returns a new object of class '<em>OML Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Aspect</em>'.
	 * @generated
	 */
	OMLAspect createOMLAspect();

	/**
	 * Returns a new object of class '<em>OML Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Concept</em>'.
	 * @generated
	 */
	OMLConcept createOMLConcept();

	/**
	 * Returns a new object of class '<em>OML Reified Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Reified Relationship</em>'.
	 * @generated
	 */
	OMLReifiedRelationship createOMLReifiedRelationship();

	/**
	 * Returns a new object of class '<em>OML Unreified Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Unreified Relationship</em>'.
	 * @generated
	 */
	OMLUnreifiedRelationship createOMLUnreifiedRelationship();

	/**
	 * Returns a new object of class '<em>OML Entity Data Property To Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Entity Data Property To Scalar</em>'.
	 * @generated
	 */
	OMLEntityDataPropertyToScalar createOMLEntityDataPropertyToScalar();

	/**
	 * Returns a new object of class '<em>OML Entity Data Property To Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Entity Data Property To Structure</em>'.
	 * @generated
	 */
	OMLEntityDataPropertyToStructure createOMLEntityDataPropertyToStructure();

	/**
	 * Returns a new object of class '<em>OML Structure Data Property To Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Structure Data Property To Scalar</em>'.
	 * @generated
	 */
	OMLStructureDataPropertyToScalar createOMLStructureDataPropertyToScalar();

	/**
	 * Returns a new object of class '<em>OML Structure Data Property To Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OML Structure Data Property To Structure</em>'.
	 * @generated
	 */
	OMLStructureDataPropertyToStructure createOMLStructureDataPropertyToStructure();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OMLRuntimePackage getOMLRuntimePackage();

} //OMLRuntimeFactory
