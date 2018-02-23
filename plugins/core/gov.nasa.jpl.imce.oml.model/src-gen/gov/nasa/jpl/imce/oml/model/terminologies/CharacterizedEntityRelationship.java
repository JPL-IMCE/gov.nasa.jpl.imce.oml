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
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterized Entity Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML CharacterizedEntityRelationship specifies the characteristics
 * of an OML EntityRelationship.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsFunctional <em>Is Functional</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsInverseFunctional <em>Is Inverse Functional</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsEssential <em>Is Essential</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsInverseEssential <em>Is Inverse Essential</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsSymmetric <em>Is Symmetric</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsAsymmetric <em>Is Asymmetric</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsReflexive <em>Is Reflexive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsIrreflexive <em>Is Irreflexive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsTransitive <em>Is Transitive</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship()
 * @model abstract="true"
 * @generated
 */
public interface CharacterizedEntityRelationship extends EntityRelationship {
	/**
	 * Returns the value of the '<em><b>Is Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 0 <= target.size <= 1
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Functional</em>' attribute.
	 * @see #setIsFunctional(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsFunctional()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsFunctional();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsFunctional <em>Is Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Functional</em>' attribute.
	 * @see #isIsFunctional()
	 * @generated
	 */
	void setIsFunctional(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Inverse Functional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 0 <= source.size <= 1
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Inverse Functional</em>' attribute.
	 * @see #setIsInverseFunctional(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsInverseFunctional()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsInverseFunctional();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsInverseFunctional <em>Is Inverse Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Inverse Functional</em>' attribute.
	 * @see #isIsInverseFunctional()
	 * @generated
	 */
	void setIsInverseFunctional(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1 <= target.size
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Essential</em>' attribute.
	 * @see #setIsEssential(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsEssential()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsEssential();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsEssential <em>Is Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Essential</em>' attribute.
	 * @see #isIsEssential()
	 * @generated
	 */
	void setIsEssential(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Inverse Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1 <= source.size
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Inverse Essential</em>' attribute.
	 * @see #setIsInverseEssential(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsInverseEssential()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsInverseEssential();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsInverseEssential <em>Is Inverse Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Inverse Essential</em>' attribute.
	 * @see #isIsInverseEssential()
	 * @generated
	 */
	void setIsInverseEssential(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relationship is symmetric
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Symmetric</em>' attribute.
	 * @see #setIsSymmetric(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsSymmetric()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsSymmetric();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsSymmetric <em>Is Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Symmetric</em>' attribute.
	 * @see #isIsSymmetric()
	 * @generated
	 */
	void setIsSymmetric(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Asymmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relationship is asymmetric
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Asymmetric</em>' attribute.
	 * @see #setIsAsymmetric(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsAsymmetric()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsAsymmetric();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsAsymmetric <em>Is Asymmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Asymmetric</em>' attribute.
	 * @see #isIsAsymmetric()
	 * @generated
	 */
	void setIsAsymmetric(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Reflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relationship is reflexive
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Reflexive</em>' attribute.
	 * @see #setIsReflexive(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsReflexive()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsReflexive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsReflexive <em>Is Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Reflexive</em>' attribute.
	 * @see #isIsReflexive()
	 * @generated
	 */
	void setIsReflexive(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Irreflexive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relationship is irreflexive
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Irreflexive</em>' attribute.
	 * @see #setIsIrreflexive(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsIrreflexive()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsIrreflexive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsIrreflexive <em>Is Irreflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Irreflexive</em>' attribute.
	 * @see #isIsIrreflexive()
	 * @generated
	 */
	void setIsIrreflexive(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Transitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this relationship is transitive
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Transitive</em>' attribute.
	 * @see #setIsTransitive(boolean)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCharacterizedEntityRelationship_IsTransitive()
	 * @model unique="false" required="true"
	 * @generated
	 */
	boolean isIsTransitive();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship#isIsTransitive <em>Is Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Transitive</em>' attribute.
	 * @see #isIsTransitive()
	 * @generated
	 */
	void setIsTransitive(boolean value);

} // CharacterizedEntityRelationship
