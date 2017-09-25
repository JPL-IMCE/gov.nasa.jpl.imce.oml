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

import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import java.util.HashSet
import java.util.Set

class SubHeirarchyService {
	
	/**
	 * Returns all of the {@link Concept}s which have the passed {@link Concept} c
	 * as its superConcept for all {@link ConceptSpecializationAxiom}s in this
	 * {@link TerminologyBox}
	 * 
	 * @param c The {@Concept} which is the superConcept
	 * @return Set of {@link Concept}s that are subConcepts to the passed {@link Concept}
	 */
	def Set<Concept> getSubConcepts(Concept c){
		
		val concepts  = new HashSet<Concept>()
		
		c?.tbox
		?.boxStatements
		.filter(ConceptSpecializationAxiom)
		.filter[cs | cs.superConcept == c]
		.forEach[cs | concepts.add(cs.subConcept)]
		
		return concepts
	}
	
	/**
	 * Returns all of the {@link Entity}s which have the passed {@link Aspect} c
	 * as its superAspect for all {@link AspectSpecializationAxiom}s in this
	 * {@link TerminologyBox}
	 * 
	 * @param c The {@Concept} which is the superConcept
	 * @return Set of {@link Entity}s that are subEntites to the passed {@link Aspect}
	 */
	def Set<Entity> getSubEntities(Aspect a){
		
		val entities  = new HashSet<Entity>()
		
		a?.tbox
		?.boxStatements
		.filter(AspectSpecializationAxiom)
		.filter[cs | cs.superAspect == a]
		.forEach[s | entities.add(s.subEntity)]
		
		return entities
	}
	
}