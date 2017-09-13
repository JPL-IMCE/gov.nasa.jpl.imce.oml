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
 * 
 * The 'Aspect/Concept Class Diagram' will show all {@link ReifiedRelationship}s
 * that have a selected root {@link Aspect} or {@link Concept} as its domain or range 
 * (from this {@link TerminologyBox} only).
 * 
 * It also shows {@link SpecializationAxiom}s that have the selected {@Aspect} or
 * {@link Concept} as its child (superEntity/Concept/Aspect) * 
 * 
 * Containers: Concept, Aspect
 * Edges: Reified/UnReified Relationships, Specialization Axioms
 * 
 */
class AspectConceptClassDiagramService {
	
	/*
	 * Gets root {@link Entity} which the passed {@link DDiagram}
	 * was created from
	 * 
	 * @param The diagram
	 * @return The Diagram
	 */
	def Entity getRootEntity(DDiagram d){
		return (d as DSemanticDiagram).target as Entity
	}

     /*
	 * Gets all {@link EntityRelationship}s within the {@link TeminologyBox} 
	 * which have as its relationDomain the root {@link Entity} associated 
	 * with the passed {@link DDiagram} 
	 * 
	 * @param d The Diagram
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<EntityRelationship> getVisualRelationshipsWithRootAsDomain(DDiagram d){
		val e = getRootEntity(d)
		val set = e?.tbox?.boxStatements?.filterNull.
		filter(EntityRelationship).
		toSet
		
		if(set.empty) return set;
		
		set.filter[f | f.source == e].
		toSet
	}
	
	/*
	 * Gets all {@link EntityRelationship}s within the {@link TeminologyBox} 
	 * which have as its relation range the root {@link Entity} associated 
	 * with the passed {@link DDiagram} 
	 * 
	 * @param d The Diagram
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<ReifiedRelationship> getVisualRelationshipsWithRootAsRange(DDiagram d){
		val e = getRootEntity(d)
		val set = e?.tbox?.boxStatements?.filterNull.
		filter(ReifiedRelationship).
		toSet
		
		if(set.empty) return set;
		
		set.filter[f | f.target == e].
		toSet
	}	

	/*
	 * Gets all {@link Entity}s in this {@link TerminologyBox} that are directly connected 
	 * (relationship/axiom) to the root {@link Entity} associated 
	 * with the passed {@link DDiagram} 
	 * 
	 *  @param d The Diagram
	 *  @return Set of {@link Entity}s
	 */
	def Set<Entity> getVisualEntities(DDiagram d){
		val e = getRootEntity(d)
		val entities = new HashSet<Entity>
		e?.tbox?.boxStatements?.filterNull.
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
	 * Gets all {@link AspectSpcializationAxiom}s in this {@link TerminologyBox}
	 * that have to the root {@link Entity} associated 
	 * with the passed {@link DDiagram} as its sub-Entity
	 * 
	 * @param d The diagram
	 * @return Set of {@link AspectSpecializationAxiom}s
	 */
	 def Set<AspectSpecializationAxiom> getVisualAspectAxioms(DDiagram d){
	 	val e = getRootEntity(d)
	 	val set = e?.tbox?.boxStatements?.filterNull.
	 	filter(AspectSpecializationAxiom).
	 	toSet
	 	
	 	if(set.isEmpty) return set;
	 	
	 	set.filter[f | f.subEntity == e].
	 	toSet
	 }
	
	/*
	 * Gets all {@link ConceptSpcializationAxiom}s in this {@link TerminologyBox}
	 * that have to the root {@link Entity} associated with the passed 
	 * {@link DDiagram} as its sub-Concept
	 * 
	 * @paramd The Diagram
	 * @return Set of {@link ConceptSpecializationAxiom}s
	 */
	 def Set<ConceptSpecializationAxiom> getVisualConceptAxioms(DDiagram d){
	 	val c = getRootEntity(d)
	 	val set = c?.tbox?.boxStatements?.filterNull.
	 	filter(ConceptSpecializationAxiom).
	 	toSet
	 	
	 	if(set.isEmpty) return set;
	 	
	 	set.filter[f | f.subConcept == c].
	 	toSet
	 }
	 
	 /*
	  * Gets all {@link EntityRestrictionAxiom}s in this {@link TerminologyBox}
	 * that have to the root {@link Entity} associated with the passed 
	 * {@link DDiagram} as its restricted Domain
	  * 
	  * @param The root Entity
	  * @return Set of {@link EntityRestrictionAxiom}s
	  */
	  def Set<EntityRestrictionAxiom> getVisualRestrictionAxioms(Entity e){
	  	val set = e?.tbox?.boxStatements?.filterNull.
	  	filter(EntityRestrictionAxiom).
	  	toSet
	  	
	  	if(set.isEmpty) return set;
	  	
	  	set.filter(f | f.restrictedDomain == e).
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