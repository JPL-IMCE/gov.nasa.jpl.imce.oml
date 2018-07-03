/*
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package gov.nasa.jpl.imce.oml.viewpoint

import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Structure
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
import java.util.LinkedHashSet
import java.util.Set
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom

/*
 * Used to query for visual elements in the "Terminology Diagram"
 * 
 * The "Terminology Diagram" will show all {@link Entity}s and
 * {@link SpecializationAxiom}s for a given {@link TerminologyGraph} 
 * 
 * 
 * Containers: Concept, Aspect, Structure, Scalar
 * Edges: Reified/UnReified Relationships, Restriction/Specialization Axioms
 * 
 */
class TerminologyDiagramService {

	/*
	 * Get all visual entities for the {@link TerminologyGraph}
	 */
	def Set<Entity> getVisualEntities(TerminologyGraph tg) {
		val entities = new LinkedHashSet<Entity>()

		for (statement : tg?.boxStatements) {
			switch statement {
				EntityRelationship: {
					entities.add(statement.relationSource)
					entities.add(statement.relationTarget)
				}
				SpecializationAxiom: {
					entities.add(statement.child)
					entities.add(statement.parent)
				}
				Entity: {
					entities.add(statement)
				}
			}
		}
		entities
	}

	/*
	 * Returns a set of {@link ScalarDataProperty}s that have the passed
	 * {@link Structure} as its domain that are found
	 * in the transitive closure of imports from the {@link TeminologyBox} associated 
	 * with the passed {@link Structure}.
	 *  
	 * 
	 * @param The Structure
	 * @return Set of {@link ScalarDataProperty}
	 */
	def Set<ScalarDataProperty> getContainedScalarDataProperties(Structure c) {
		val set = c?.tbox?.boxStatements?.filter(ScalarDataProperty)?.toSet

		if(set.isEmpty) return set;

		set.filterNull.filter[f|f.domain == c].toSet
	}

	/*
	 * Returns a set of {@link StructuredDataProperty}s that have the passed
	 * {@link Structure} as its domain that are found
	 * in the transitive closure of imports from the {@link TeminologyBox} associated 
	 * with the passed {@link Structure}.
	 * 
	 * @param The Structure
	 * @return Set of {@link StucturedDataProperty}
	 */
	def Set<StructuredDataProperty> getContainedStructuredDataProperties(Structure c) {
		val set = c?.tbox?.boxStatements?.filter(StructuredDataProperty)?.toSet

		if(set.isEmpty) return set;

		set.filterNull.filter[f|f.domain == c].toSet
	}

	/*
	 * Returns a set of {@link StringScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link StringScalarRestriction}
	 */
	def Set<StringScalarRestriction> getContainedStringScalarRestrictions(TerminologyGraph c) {
		return c.boxStatements.filterNull.filter(StringScalarRestriction).toSet
	}

	/*
	 * Returns a set of {@link NumericScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link NumericScalarRestriction}
	 */
	def Set<NumericScalarRestriction> getContainedNumericScalarRestrictions(TerminologyGraph c) {
		return c.boxStatements.filterNull.filter(NumericScalarRestriction).toSet
	}

	/*
	 * Returns a set of {@link BinaryScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link NumericScalarRestriction}
	 */
	def Set<BinaryScalarRestriction> getContainedBinaryScalarRestrictions(TerminologyGraph c) {
		return c.boxStatements.filterNull.filter(BinaryScalarRestriction).toSet
	}

	/*
	 * Returns a set of {@link IRIScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link IRIScalarRestriction}
	 */
	def Set<IRIScalarRestriction> getContainedIRIScalarRestrictions(TerminologyGraph c) {
		return c.boxStatements.filterNull.filter(IRIScalarRestriction).toSet
	}

	/*
	 * Returns a set of {@link PlainLiteralScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link PlainLiteralScalarRestriction}
	 */
	def Set<PlainLiteralScalarRestriction> getContainedPlainLiteralScalarRestrictions(TerminologyGraph c) {
		return c.boxStatements.filterNull.filter(PlainLiteralScalarRestriction).toSet
	}

	/*
	 * Returns a set of {@link TimeScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link TimeScalarRestriction}
	 */
	def Set<TimeScalarRestriction> getContainedTimeScalarRestrictions(TerminologyGraph c) {
		return c.boxStatements.filterNull.filter(TimeScalarRestriction).toSet
	}

	/*
	 * Returns a set of {@link SynonymScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link SynonymScalarRestriction}
	 */
	def Set<SynonymScalarRestriction> getContainedSynonymScalarRestrictions(TerminologyGraph c) {
		return c.boxStatements.filterNull.filter(SynonymScalarRestriction).toSet
	}

	/*
	 * Returns a set of {@link ScalarOneOfRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link ScalarOneOfRestriction}
	 */
	def Set<ScalarOneOfRestriction> getContainedScalarOneOfRestrictions(TerminologyGraph c) {
		return c.boxStatements.filterNull.filter(ScalarOneOfRestriction).toSet
	}

	/*
	 * Gets class name for a {@link RestrictedDataRange}
	 * 
	 * @return Name of implemented class
	 */
	def String getRestrictedRangeLabel(RestrictedDataRange r) {
		val result = r.class.simpleName
		return result.substring(0, result.length - 4)
	}

	/*
	 * Gets label for a {@link RestrictedDataRange} Node
	 * 
	 * @return String representation for Scalar Restriction
	 */
	def String getDetailedLabel(RestrictedDataRange r) {

		var label = new StringBuilder
		label.append(r.name())

		switch r {
			StringScalarRestriction: {
				label.append("\npattern: " + r.pattern)
			}
			IRIScalarRestriction: {
				label.append("\npattern: " + r.pattern)
			}
			PlainLiteralScalarRestriction: {
				label.append("\npattern: " + r.pattern)
				label.append("\nlangRange: " + r.langRange)
			}
			NumericScalarRestriction: {
				if(r.minInclusive !== null) label.append("\n\nminInclusive: " + r.minInclusive)
				if(r.maxInclusive !== null) label.append("\nmaxInclusive: " + r.maxInclusive)
				if(r.minExclusive !== null) label.append("\nminExclusive: " + r.minExclusive)
				if(r.maxExclusive !== null) label.append("\nmaxExclusive: " + r.maxExclusive)
			}
		}
		label.toString
	}

	/*
	 * Gets the label for the given {@link EntityRestrictionAxiom}
	 * 
	 * @param e The {@link EntityRestrictionAxiom}
	 * @return EntityRestrictionAxiom label
	 */
	def String getAxiomLabel(EntityRestrictionAxiom ax) {
		switch ax {
			EntityExistentialRestrictionAxiom:
				'''some «ax.restrictedRelationship.abbrevIRI» in'''
			EntityUniversalRestrictionAxiom:
				'''all «ax.restrictedRelationship.abbrevIRI» in'''
		}
	}
}
