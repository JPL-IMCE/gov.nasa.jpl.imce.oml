/**
 * 
 * Copyright 2016 California Institute of Technology ("Caltech").
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Terminology Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * OML supports two different interpretations for OML TerminologyBox vocabularies:
 * - An open-world interpretation where the vocabulary formalizes a particular domain
 *   that will be used for modeling particular systems in that domain.
 * - A closed-world interpretation where the vocabulary formalizes the description of
 *   a particular system modeled using the open-world vocabulary for a particular domain.
 * The difference between these interpretations primarily affects the mapping to an [OWL2-DL Class]
 * of a concrete OML ConceptualEntity as follows:
 * - For OpenWorldDefinitions, the mapped [OWL2-DL Class] has open-world semantics; that is,
 *   it classifies a set of individuals that share the characteristics and capabilities
 *   encoded in the [OWL2-DL Class].
 * - For ClosedWorldDefinitions, the mapped [OWL2-DL Class] has a closed-world semantics in
 *   the sense that it is intended to classify a singleton individual uniquely identified
 *   via the values of its identifying OML DataRelationshipFromEntity properties.
 * <!-- end-model-doc -->
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getTerminologyKind()
 * @model
 * @generated
 */
public enum TerminologyKind implements Enumerator {
	/**
	 * The '<em><b>Open World Definitions</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPEN_WORLD_DEFINITIONS_VALUE
	 * @generated
	 * @ordered
	 */
	OPEN_WORLD_DEFINITIONS(0, "OpenWorldDefinitions", "OpenWorldDefinitions"),

	/**
	 * The '<em><b>Closed World Designations</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLOSED_WORLD_DESIGNATIONS_VALUE
	 * @generated
	 * @ordered
	 */
	CLOSED_WORLD_DESIGNATIONS(0, "ClosedWorldDesignations", "ClosedWorldDesignations");

	/**
	 * The '<em><b>Open World Definitions</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each OML Entity in an OpenWorldDefinitions OML TerminologyBox has the semantics of
	 * an [OWL2-DL Class]; that is, it classifies a set of individuals
	 * that share the characteristics and capabilities encoded in the [OWL2-DL Class].
	 * A well-formed OML SpecializationAxiom establishing a taxonomic relationship between
	 * two OML Term(s) can be asserted arbitrarily in any OpenWorldDefinitions OML TerminologyBox
	 * that directly or indirectly includes the related OML Term(s).
	 * For example, suppose that OML Concept(s) `A` and `B`
	 * are defined in OpenWorldDefinitions OML TerminologyBox `P` and `Q` respectively.
	 * Suppose further that OpenWorldDefinitions OML TerminologyBox(es), `U` and `V`, each
	 * extend both `P` and `Q` where `U` asserts that `A` extends `B` while `V` asserts that `B` extends `A.
	 * This is well-formed; furthermore, an OpenWorldDefinitions OML TerminologyBox extending both `U` and `V`
	 * would force `A` and `B` to become equivalent OML Concept(s) per the open-world semantics of [OWL2-DL].
	 * <!-- end-model-doc -->
	 * @see #OPEN_WORLD_DEFINITIONS
	 * @model name="OpenWorldDefinitions"
	 * @generated
	 * @ordered
	 */
	public static final int OPEN_WORLD_DEFINITIONS_VALUE = 0;

	/**
	 * The '<em><b>Closed World Designations</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each OML ConceptualEntity in a ClosedWorldDesignation terminology describes a unique thing
	 * in the real world uniquely identifiable by the collection of its identifying OML DataRelationshipFromEntity properties
	 * (e.g., serial numbers, unique identifiers, ...).
	 * A well-formed ClosedWorldDesignations OML TerminologyBox is restricted to defining singleton OML ConceptualEntity(-ies), each as
	 * a specialization of at least one concrete OML ConceptualEntity defined  in an extended OpenWorldDefinitions OML TerminologyBox.
	 * Each OML ConceptualEntity in a ClosedWorldDesignations OML TerminologyBox maps to
	 * an [OWL2-DL Class] with an axiom asserting its equivalence to an exact cardinality restriction of 1 for
	 * each of its identifying OML DataRelationshipFromEntity properties.
	 * <!-- end-model-doc -->
	 * @see #CLOSED_WORLD_DESIGNATIONS
	 * @model name="ClosedWorldDesignations"
	 * @generated
	 * @ordered
	 */
	public static final int CLOSED_WORLD_DESIGNATIONS_VALUE = 0;

	/**
	 * An array of all the '<em><b>Terminology Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TerminologyKind[] VALUES_ARRAY =
		new TerminologyKind[] {
			OPEN_WORLD_DEFINITIONS,
			CLOSED_WORLD_DESIGNATIONS,
		};

	/**
	 * A public read-only list of all the '<em><b>Terminology Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TerminologyKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Terminology Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TerminologyKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TerminologyKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Terminology Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TerminologyKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TerminologyKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Terminology Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TerminologyKind get(int value) {
		switch (value) {
			case OPEN_WORLD_DEFINITIONS_VALUE: return OPEN_WORLD_DEFINITIONS;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TerminologyKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TerminologyKind
