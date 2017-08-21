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

import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
import java.util.HashSet
import java.util.Set
import org.eclipse.sirius.diagram.DDiagram
import org.eclipse.sirius.diagram.DSemanticDiagram

/*
 * Used to query for visual elements for the 'Aspect/Concept Class Diagram'
 * Containers: Concept, Aspect
 * Edges: ...
 * 
 * The 'Aspect/Concept Class Diagram' will show all {@link ReifiedRelationship}s
 * that have a selected root {@link Aspect} or {@link Concept} as its domain or range 
 * (from this {@link TerminologyBox} only) .
 * It also shows {@link SpecializationAxiom}s that have the selected {@Aspect} or
 * {@link Concept} as its child (superEntity/Concept/Aspect)
 * 
 */
class AspectConceptClassDiagramService {
	
	/*
	 * Gets root {@link Entity} which the passed {@link DDiagram}
	 * was created from
	 * 
	 * @param The diagram
	 * @return The root {@link Entity}
	 */
	def Entity getRootEntity(DDiagram d){
		return (d as DSemanticDiagram).target as Entity
	}

     /*
	 * Gets all {@link EntityRelationship}s with the 
	 * passed {@link} Concept as its relation domain
	 * 
	 * @param c The root Concept
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<EntityRelationship> getVisualRelationshipsWithRootAsDomain(DDiagram d){
		val e = getRootEntity(d)
		return e.tbox.boxStatements.
		filter(EntityRelationship).
		filter[f | f.source == e].
		toSet
	}
	
	/*
	 * Gets all {@link ReifiedRelationship}s with the 
	 * passed {@link} Concept as its relation range
	 * 
	 * @param c The root Concept
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<ReifiedRelationship> getVisualRelationshipsWithRootAsRange(DDiagram d){
		val e = getRootEntity(d)
		return e.tbox.boxStatements.
		filter(ReifiedRelationship).
		filter[f | f.target == e].
		toSet
	}	

	/*
	 * Gets all {@link Entity} that are directly connected (relationship/axiom)
	 * to the passed {@link Entity}
	 * @param e The entity which to find connections 
	 */
	def Set<Entity> getVisualEntities(DDiagram d){
		val e = getRootEntity(d)
		val entities = new HashSet<Entity>
		e.tbox.boxStatements.
		forEach[t | 
			 if(t instanceof SpecializationAxiom){
				val n = (t as SpecializationAxiom).child
				if(n == e){
					entities.add((t as SpecializationAxiom).parent)
				}
		    } else if(t instanceof EntityRestrictionAxiom){
				val n = (t as EntityRestrictionAxiom).restrictedDomain
				if(n == e){
					entities.add((t as EntityRestrictionAxiom).restrictedRange)
				}
			} else if(t instanceof EntityRelationship){
				val n1 = (t as EntityRelationship).source
				val n2 = (t as EntityRelationship).target
				if(n1 == e){
					entities.add(n2)
				} else if(n2 == e){
					entities.add(n1)
				}
		   }								
		]
		entities.add(e)
		entities		
	}
	
	/*
	 * Gets all {@link AspectSpcializationAxiom}s that have the passed
	 * {@link Entity} as its sub-Entity
	 * 
	 * @param e The root {@link Entity}
	 * @return Set of {@link AspectSpecializationAxiom}s
	 */
	 def Set<AspectSpecializationAxiom> getVisualAspectAxioms(DDiagram d){
	 	val e = getRootEntity(d)
	 	return e.tbox.boxStatements.
	 	filter(AspectSpecializationAxiom).
	 	filter[f | f.subEntity == e].
	 	toSet
	 }
	
	/*
	 * Gets all {@link ConceptSpcializationAxiom}s that have the passed
	 * {@link Concept} as its sub-Concept
	 * 
	 * @param c The root {@link Concept}
	 * @return Set of {@link ConceptSpecializationAxiom}s
	 */
	 def Set<ConceptSpecializationAxiom> getVisualConceptAxioms(DDiagram d){
	 	val c = getRootEntity(d)
	 	return c.tbox.boxStatements.
	 	filter(ConceptSpecializationAxiom).
	 	filter[f | f.subConcept == c].
	 	toSet
	 }
	 
	 /*
	  * Gets all {@link EntityRestrictionAxiom}s that have the passed
	  * {@link Entity} as its restricted Domain
	  * 
	  * @param The root Entity
	  * @return Set of {@link EntityRestrictionAxiom}s
	  */
	  def Set<EntityRestrictionAxiom> getVisualRestrictionAxioms(Entity e){
	  	return e.tbox.boxStatements.
	  	filter(EntityRestrictionAxiom).
	  	filter(f | f.restrictedDomain == e).
	  	toSet
	  }
	  
	  /*
	   * Gets the label for the given {@link EntityRestrictionAxiom}
	   * 
	   * @param e The {@link EntityRestrictionAxiom}
	   * @return '<<existential>>' or '<<universal>>'
	   */
	   def String getAxiomLabel(EntityRestrictionAxiom ax){
	   	if(ax instanceof EntityExistentialRestrictionAxiom){
	   	  return "<<existential>>"	
	   	}
	   	
	   	  "<<universal>>" 
	   }
}