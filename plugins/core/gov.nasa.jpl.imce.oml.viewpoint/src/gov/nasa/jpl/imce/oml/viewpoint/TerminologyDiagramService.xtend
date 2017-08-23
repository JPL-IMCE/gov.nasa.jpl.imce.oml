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
	def Set<Entity> getVisualEntities(TerminologyGraph tg){
		val entities  = new LinkedHashSet<Entity>()
		
		for(statement : tg.boxStatements){
			if (statement instanceof Entity){
				entities.add(statement as Entity)
			}
			if(statement instanceof SpecializationAxiom){
				val temp = statement as SpecializationAxiom
				entities.add(temp.child)
				entities.add(temp.parent)
			}
		}
		
		entities
	}		
	
	/*
	 * Returns a set of {@link ScalarDataProperty}s that have the passed
	 * {@link Structure} as its domain
	 * 
	 * @param The Structure
	 * @return Set of {@link ScalarDataProperty}
	 */
	def Set<ScalarDataProperty> getContainedScalarDataProperties(Structure c){
	    return c.tbox.boxStatements.
	    filter(ScalarDataProperty).
	    filter[f | f.domain == c].
	    toSet
	}	
	
	/*
	 * Returns a set of {@link StructuredDataProperty}s that have the passed
	 * {@link Structure} as its domain
	 * 
	 * @param The Structure
	 * @return Set of {@link StucturedDataProperty}
	 */
	def Set<StructuredDataProperty> getContainedStructuredDataProperties(Structure c){
	    return c.tbox.boxStatements.
	    filter(StructuredDataProperty).
	    filter[f | f.domain == c].
	    toSet
	}
	
	/*
	 * Returns a set of {@link StringScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link StringScalarRestriction}
	 */
	def Set<StringScalarRestriction> getContainedStringScalarRestrictions(TerminologyGraph c){
	    return c.boxStatements.
	    filter(StringScalarRestriction).
	    toSet
	}	
	
	/*
	 * Returns a set of {@link NumericScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link NumericScalarRestriction}
	 */
	def Set<NumericScalarRestriction> getContainedNumericScalarRestrictions(TerminologyGraph c){
	    return c.boxStatements.
	    filter(NumericScalarRestriction).
	    toSet
	}
	
	/*
	 * Returns a set of {@link BinaryScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link NumericScalarRestriction}
	 */
	def Set<BinaryScalarRestriction> getContainedBinaryScalarRestrictions(TerminologyGraph c){
	    return c.boxStatements.
	    filter(BinaryScalarRestriction).
	    toSet
	}
	
	/*
	 * Returns a set of {@link IRIScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link IRIScalarRestriction}
	 */
	def Set<IRIScalarRestriction> getContainedIRIScalarRestrictions(TerminologyGraph c){
	    return c.boxStatements.
	    filter(IRIScalarRestriction).
	    toSet
	}
	
	/*
	 * Returns a set of {@link PlainLiteralScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link PlainLiteralScalarRestriction}
	 */
	def Set<PlainLiteralScalarRestriction> getContainedPlainLiteralScalarRestrictions(TerminologyGraph c){
	    return c.boxStatements.
	    filter(PlainLiteralScalarRestriction).
	    toSet
	}
	
	
	/*
	 * Returns a set of {@link TimeScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link TimeScalarRestriction}
	 */
	def Set<TimeScalarRestriction> getContainedTimeScalarRestrictions(TerminologyGraph c){
	    return c.boxStatements.
	    filter(TimeScalarRestriction).
	    toSet
	}
	
	/*
	 * Returns a set of {@link SynonymScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link SynonymScalarRestriction}
	 */
	def Set<SynonymScalarRestriction> getContainedSynonymScalarRestrictions(TerminologyGraph c){
	    return c.boxStatements.
	    filter(SynonymScalarRestriction).
	    toSet
	}
	
	/*
	 * Returns a set of {@link ScalarOneOfRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link ScalarOneOfRestriction}
	 */
	def Set<ScalarOneOfRestriction> getContainedScalarOneOfRestrictions(TerminologyGraph c){
	    return c.boxStatements.
	    filter(ScalarOneOfRestriction).
	    toSet
	}
	
	/*
	 * Gets class name for a {@link RestrictedDataRange}
	 * 
	 * @return Name of implemented class
	 */
	def String getRestrictedRangeLabel(RestrictedDataRange r){
		val result = r.class.simpleName
		return result.substring(0, result.length-4)
	}
	
	/*
	 * Gets label for a {@link RestrictedDataRange} Node
	 * 
	 * @return String representation for Scalar Restriction
	 */
	def String getDetailedLabel(RestrictedDataRange r){
		
		var label = new StringBuilder
		label.append(r.name())
		
		if(r instanceof StringScalarRestriction){
			label.append("\npattern: " + (r as StringScalarRestriction).pattern)
		}
		if(r instanceof IRIScalarRestriction){
			label.append("\npattern: " + (r as IRIScalarRestriction).pattern)
		}
		if(r instanceof PlainLiteralScalarRestriction){
			label.append("\npattern: " + (r as PlainLiteralScalarRestriction).pattern)
			label.append("\nlangRange: " + (r as PlainLiteralScalarRestriction).langRange)
		}
		if(r instanceof NumericScalarRestriction){
			if((r as NumericScalarRestriction).minInclusive !== null) label.append("\n\nminInclusive: " + (r as NumericScalarRestriction).minInclusive)
			if((r as NumericScalarRestriction).maxInclusive !== null) label.append("\nmaxInclusive: " + (r as NumericScalarRestriction).maxInclusive) 
			if((r as NumericScalarRestriction).minExclusive !== null) label.append("\nminExclusive: " + (r as NumericScalarRestriction).minExclusive) 
		    if((r as NumericScalarRestriction).maxExclusive !== null) label.append("\nmaxExclusive: " + (r as NumericScalarRestriction).maxExclusive)
		}
		if(r instanceof BinaryScalarRestriction){
			label.append( "\n\nnmaxLength: " + (r as BinaryScalarRestriction).minLength + "\nmaxLength: " + (r as BinaryScalarRestriction).maxLength)
		}
		if(r instanceof TimeScalarRestriction){
			if((r as TimeScalarRestriction).minInclusive !== null) label.append("\n\nminInclusive: " + (r as TimeScalarRestriction).minInclusive)
			if((r as TimeScalarRestriction).maxInclusive !== null) label.append("\nmaxInclusive: " + (r as TimeScalarRestriction).maxInclusive) 
			if((r as TimeScalarRestriction).minExclusive !== null) label.append("\nminExclusive: " + (r as TimeScalarRestriction).minExclusive) 
		    if((r as TimeScalarRestriction).maxExclusive !== null) label.append("\nmaxExclusive: " + (r as TimeScalarRestriction).maxExclusive)
		}
		
		label.toString
	}
	
}