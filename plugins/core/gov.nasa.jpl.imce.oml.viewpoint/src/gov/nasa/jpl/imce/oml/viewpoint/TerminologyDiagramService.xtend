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
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
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
 * Used to query for visual elements in the 'Terminology Diagram'
 * 
 * The 'Terminology Diagram' will show all {@link Entity}s and
 * {@link SpecializationAxiom}s for a given {@link TerminologyGraph} 
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
	def Set<StringScalarRestriction> getContainedStringScalarRestrictions(Scalar c){
	    return c.tbox.boxStatements.
	    filter(StringScalarRestriction).
	    filter[f | f.restrictedRange == c].
	    toSet
	}	
	
	/*
	 * Returns a set of {@link NumericScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link NumericScalarRestriction}
	 */
	def Set<NumericScalarRestriction> getContainedNumericScalarRestrictions(Scalar c){
	    return c.tbox.boxStatements.
	    filter(NumericScalarRestriction).
	    filter[f | f.restrictedRange == c].
	    toSet
	}
	
	/*
	 * Returns a set of {@link BinaryScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link NumericScalarRestriction}
	 */
	def Set<BinaryScalarRestriction> getContainedBinaryScalarRestrictions(Scalar c){
	    return c.tbox.boxStatements.
	    filter(BinaryScalarRestriction).
	    filter[f | f.restrictedRange == c].
	    toSet
	}
	
	/*
	 * Returns a set of {@link IRIScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar
	 * @return Set of {@link IRIScalarRestriction}
	 */
	def Set<IRIScalarRestriction> getContainedIRIScalarRestrictions(Scalar c){
	    return c.tbox.boxStatements.
	    filter(IRIScalarRestriction).
	    filter[f | f.restrictedRange == c].
	    toSet
	}
	
	/*
	 * Returns a set of {@link PlainLiteralScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link PlainLiteralScalarRestriction}
	 */
	def Set<PlainLiteralScalarRestriction> getContainedPlainLiteralScalarRestrictions(Scalar c){
	    return c.tbox.boxStatements.
	    filter(PlainLiteralScalarRestriction).
	    filter[f | f.restrictedRange == c].
	    toSet
	}
	
	
	/*
	 * Returns a set of {@link TimeScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link TimeScalarRestriction}
	 */
	def Set<TimeScalarRestriction> getContainedTimeScalarRestrictions(Scalar c){
	    return c.tbox.boxStatements.
	    filter(TimeScalarRestriction).
	    filter[f | f.restrictedRange == c].
	    toSet
	}
	
	/*
	 * Returns a set of {@link SynonymScalarRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link SynonymScalarRestriction}
	 */
	def Set<SynonymScalarRestriction> getContainedSynonymScalarRestrictions(Scalar c){
	    return c.tbox.boxStatements.
	    filter(SynonymScalarRestriction).
	    filter[f | f.restrictedRange == c].
	    toSet
	}
	
	/*
	 * Returns a set of {@link ScalarOneOfRestriction}s that have the passed
	 * {@link Scalar} as its domain
	 * 
	 * @param The Scalar}
	 * @return Set of {@link ScalarOneOfRestriction}
	 */
	def Set<ScalarOneOfRestriction> getContainedScalarOneOfRestrictions(Scalar c){
	    return c.tbox.boxStatements.
	    filter(ScalarOneOfRestriction).
	    filter[f | f.restrictedRange == c].
	    toSet
	}
}