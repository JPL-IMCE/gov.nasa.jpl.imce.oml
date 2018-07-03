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

import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Restricted Reified Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML CardinalityRestrictedReifiedRelationship is an OML ConceptualRelationship defined as a named
 * cardinality restriction of an OML RestrictableRelationship whose domain is an OML ConceptualRelationship
 * and that can be optionally qualified by a restricted range OML Entity.
 * 
 * An OML CardinalityRestrictedReifiedRelationship`(RR, Min, n, Rel)` corresponds
 * to the following in OWL2 Functional Syntax:
 * 
 * ```
 * Declaration(RRlass C))
 * SubClassOf(RR ObjectMinCardinality(n Rel))
 * ```
 * 
 * An OML CardinalityRestrictedReifiedRelationship`(RR, Min, n, Rel, Ran)` corresponds
 * to the following in OWL2 Functional Syntax:
 * 
 * ```
 * Declaration(RRlass C))
 * SubClassOf(RR ObjectMinCardinality(n Rel Ran))
 * ```
 * 
 * An OML CardinalityRestrictedReifiedRelationship`(RR, Max, n, Rel)` corresponds
 * to the following in OWL2 Functional Syntax:
 * 
 * ```
 * Declaration(RRlass C))
 * SubClassOf(RR ObjectMaxCardinality(n Rel))
 * ```
 * 
 * An OML CardinalityRestrictedReifiedRelationship`(RR, Max, n, Rel, Ran)` corresponds
 * to the following in OWL2 Functional Syntax:
 * 
 * ```
 * Declaration(RRlass C))
 * SubClassOf(RR ObjectMaxCardinality(n Rel Ran))
 * ```
 * 
 * An OML CardinalityRestrictedReifiedRelationship`(RR, Equal, n, Rel)` corresponds
 * to the following in OWL2 Functional Syntax:
 * 
 * ```
 * Declaration(RRlass C))
 * SubClassOf(RR ObjectExactCardinality(n Rel))
 * ```
 * 
 * An OML CardinalityRestrictedReifiedRelationship`(RR, Equal, n, Rel)` corresponds
 * to the following in OWL2 Functional Syntax:
 * 
 * ```
 * Declaration(RRlass C))
 * SubClassOf(RR ObjectExactCardinality(n Rel))
 * ```
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship#getRestrictionKind <em>Restriction Kind</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship#getRestrictedRelationship <em>Restricted Relationship</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship#getRestrictedRange <em>Restricted Range</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship#getRestrictedCardinality <em>Restricted Cardinality</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCardinalityRestrictedReifiedRelationship()
 * @model
 * @generated
 */
public interface CardinalityRestrictedReifiedRelationship extends ConceptualRelationship {
	/**
	 * Returns the value of the '<em><b>Restriction Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restriction Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restriction Kind</em>' attribute.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictionKind
	 * @see #setRestrictionKind(CardinalityRestrictionKind)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCardinalityRestrictedReifiedRelationship_RestrictionKind()
	 * @model unique="false" required="true"
	 * @generated
	 */
	CardinalityRestrictionKind getRestrictionKind();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship#getRestrictionKind <em>Restriction Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restriction Kind</em>' attribute.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictionKind
	 * @see #getRestrictionKind()
	 * @generated
	 */
	void setRestrictionKind(CardinalityRestrictionKind value);

	/**
	 * Returns the value of the '<em><b>Restricted Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Relationship</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Relationship</em>' reference.
	 * @see #setRestrictedRelationship(RestrictableRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCardinalityRestrictedReifiedRelationship_RestrictedRelationship()
	 * @model required="true"
	 * @generated
	 */
	RestrictableRelationship getRestrictedRelationship();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship#getRestrictedRelationship <em>Restricted Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Relationship</em>' reference.
	 * @see #getRestrictedRelationship()
	 * @generated
	 */
	void setRestrictedRelationship(RestrictableRelationship value);

	/**
	 * Returns the value of the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Range</em>' reference.
	 * @see #setRestrictedRange(Entity)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCardinalityRestrictedReifiedRelationship_RestrictedRange()
	 * @model
	 * @generated
	 */
	Entity getRestrictedRange();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship#getRestrictedRange <em>Restricted Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Range</em>' reference.
	 * @see #getRestrictedRange()
	 * @generated
	 */
	void setRestrictedRange(Entity value);

	/**
	 * Returns the value of the '<em><b>Restricted Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Cardinality</em>' attribute.
	 * @see #setRestrictedCardinality(PositiveIntegerValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getCardinalityRestrictedReifiedRelationship_RestrictedCardinality()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.PositiveIntegerLiteral" required="true"
	 * @generated
	 */
	PositiveIntegerValue getRestrictedCardinality();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship#getRestrictedCardinality <em>Restricted Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Cardinality</em>' attribute.
	 * @see #getRestrictedCardinality()
	 * @generated
	 */
	void setRestrictedCardinality(PositiveIntegerValue value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getRestrictedRelationship().relation().relationSource();'"
	 * @generated
	 */
	Entity relationSource();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getRestrictedRelationship().relation().relationTarget();'"
	 * @generated
	 */
	Entity relationTarget();

} // CardinalityRestrictedReifiedRelationship
