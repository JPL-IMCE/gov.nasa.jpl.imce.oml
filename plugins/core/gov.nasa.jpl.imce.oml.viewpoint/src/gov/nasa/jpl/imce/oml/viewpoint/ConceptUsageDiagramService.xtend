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
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import java.util.AbstractMap.SimpleEntry
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.Map.Entry
import java.util.Queue
import java.util.Set
import org.eclipse.sirius.diagram.DDiagram
import org.eclipse.sirius.diagram.DSemanticDiagram

/*
 * Used to query for visual elements in the 'Concept Usage Diagram'
 * 
 * The 'Concept Usage Diagram' will show all {@link ReifiedRelationship}s and
 * its domain and range if it is the selected root {@link Concept}.  Including
 * those which have an {@link Aspect} as its target (range) in which
 * the {@link Aspect} is a superAspect to the root {@link Concept}.
 * 
 * Will only show {@link ReifiedRelationship}s and {@link Concept}s
 * from this {@link TerminologyBox} only. * 
 * 
 * Containers: Concept
 * Edges: Reified/UnReified Relationships
 */
class ConceptUsageDiagramService {
	
	/*
	 * Gets root {@link Concept} which the passed {@link DDiagram}
	 * was created from
	 * 
	 * @param The diagram
	 * @return The root {@link Concept}
	 */
	def Concept getRootConcept(DDiagram d){
		return (d as DSemanticDiagram).target as Concept
	}	
	
	/*
	 * Gets all {@link EntityRelationship}s with the 
	 * passed {@link} Concept as its relation domain
	 * 
	 * @param c The root Concept
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<EntityRelationship> getDirectVisualRelationshipsWithRootAsDomain(Concept c){
		return getUsageReltionships(c).
		filter(EntityRelationship).
		filter[f | f.source == c].
		toSet
	}
	
	/*
	 * Gets all {@link ReifiedRelationship}s with the 
	 * passed {@link} Concept as its relation range
	 * 
	 * @param c The root Concept
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<ReifiedRelationship> getDirectVisualRelationshipsWithRootAsRange(Concept c){
		return getUsageReltionships(c).
		filter(ReifiedRelationship).
		filter[f | (f.target == c) && (f instanceof Concept)].
		toSet
	}	
	
	/*
	 * Gets all {@link ReifiedRelationship}s with the 
	 * passed {@link} Concept as its relation range
	 * 
	 * @param c The root Concept
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<ReifiedRelationship> getDirectVisualRelationshipsWithAspectAsDomain(DDiagram d){
		val c = getRootConcept(d)
		return getUsageReltionships(c).
		filter(ReifiedRelationship).
		filter[f | (f.target == c) && (f.source instanceof Aspect)].
		toSet
	}
	
	/*
	 * Gets equivalent {@link Concept} for the given
	 * {@link ReifiedRelationship} which has an {@link Aspect}
	 * as its domain
	 * 
	 * @param rel The {@link ReifiedRelationship}
	 * @return Set of {@link Concept}s
	 */
	def Set<Concept> getConceptRoots(ReifiedRelationship rel)
	{
		val newRootConcepts = new HashSet<Concept>
		val aspect = rel.source
		
		if(aspect.tbox === null) return newRootConcepts
		
		OMLExtensions.allImportedTerminologies(aspect.tbox)
        .map[boxStatements]
        .flatten
        .filterNull
		.filter(AspectSpecializationAxiom).
		filter[f | 
			(f.superAspect == aspect) && (f.subEntity instanceof Concept) 
		].
		forEach[ax |
			newRootConcepts.add(ax.subEntity as Concept)
		]
		
		newRootConcepts		
	}
	
	/*
	 * Gets all {@link ReifiedRelationship}s that are indirectly connected
	 * to the {@link Concept} 'c' in which 'c' would be the source
	 * 
	 * @param c Root {@link Concept}
	 * @return Set<ReifiedRelationship> Set of indirectly connected relationships
	 */
	def Set<ReifiedRelationship> getIndirectRelationshipsWithRootAsSource(Concept c){
		val relationships = new HashSet<ReifiedRelationship>
		
        getUsageReltionships(c).
		filter(ReifiedRelationship).
		filter[f | f.source instanceof Aspect].
		forEach[t | 
			relationships.add(t as ReifiedRelationship)
		]
		
		relationships		
	}	
	
	/*
	 * Gets all {@link ReifiedRelationship}s that are indirectly connected
	 * to the {@link Concept} 'c' in which 'c' would be the target
	 * 
	 * @param c Root {@link Concept}
	 * @return Set<ReifiedRelationship> Set of indirectly connected relationships
	 */
	def Set<ReifiedRelationship> getIndirectRelationshipsWithRootAsTarget(Concept c){
	    val relationships = new HashSet<ReifiedRelationship>
		
        getUsageReltionships(c).
		filter(ReifiedRelationship).
		filter[f | f.target instanceof Aspect].
		forEach[t | 
			relationships.add(t as ReifiedRelationship)
		]
		
		relationships			
	}
	
	/*
	 * Gets all {@link EntityUniversalRestrictionAxiom}s that have the passed
	 * {@link Concept} as its restricted domain
	 * 
	 * @param c The root {@link Concept}
	 * @return Set of {@link EntityUniversalRestrictionAxioms}s
	 */
	def Set<EntityUniversalRestrictionAxiom> getUniversalAxiomWithRootAsSource(Concept c){
		return getUsageReltionships(c).
		filter(EntityUniversalRestrictionAxiom).
		filter[f | f.restrictedDomain == c].
		toSet
	}

	/*
	 * Gets all {@link EntityUniversalRestrictionAxiom}s that have the passed
	 * {@link Concept} as its restricted range
	 * 
	 * @param c The root {@link Concept}
	 * @return Set of {@link EntityUniversalRestrictionAxioms}s
	 */
	def Set<EntityUniversalRestrictionAxiom> getUniversalAxiomWithRootAsTarget(Concept c){
		return getUsageReltionships(c).
		filter(EntityUniversalRestrictionAxiom).
		filter[f | f.restrictedRange == c].
		toSet
	}	
	
	/*
	 * Gets all {@link EntityExitenstialRestrictionAxiom}s that have the passed
	 * {@link Concept} as its restricted domain
	 * 
	 * @param c The root {@link Concept}
	 * @return Set of {@link EntityExistentialRestrictionAxioms}s
	 */
	def Set<EntityExistentialRestrictionAxiom> getExistentialAxiomWithRootAsSource(Concept c){
		return getUsageReltionships(c).
		filter(EntityExistentialRestrictionAxiom).
		filter[f | f.restrictedDomain == c].
		toSet
	}
	
	/*
	 * Gets all {@link EntityExistentialRestrictionAxiom}s that have the passed
	 * {@link Concept} as its restricted domain
	 * 
	 * @param c The root {@link Concept}
	 * @return Set of {@link EntityExistentialRestrictionAxioms}s
	 */
	def Set<EntityExistentialRestrictionAxiom> getExistentialAxiomWithRootAsTarget(Concept c){
		return getUsageReltionships(c).
		filter(EntityExistentialRestrictionAxiom).
		filter[f | f.restrictedRange == c].
		toSet
	}	
	
	/*
	 * Gets all {@link Concept}s that are connected, directly
	 * and indirectly, to the passed {@ Concept}.  For indirect
	 * connections this method only finds the first Concept, not all
	 * 
	 * @param c Root concept
	 * @return Set<Concept> The set of {@link Concept}s connected to c 
	 */
	def Set<Concept> getConnectedConcepts(Concept c){
		val graph = buildEntityGraph(c)
		val concepts = new HashSet<Concept>
		// For graph search
		val queue = new LinkedList<Entity> as Queue<Entity>
		
		// Since graph was created as an undirected graph
		// nodes need to be marked in order to terminate search
		val visited =  new HashSet<Entity>
		// Put initial entities on queue if they are not Entity Relationships
		graph.get(c).
		forEach[e |
			// c <relOrAx> cpt
			val entity = e.key
			val relOrAx = e.value			
			visited.add(entity)
			if(relOrAx instanceof EntityRelationship){
				if(entity instanceof Concept){
					// Concept is connected
				    concepts.add(entity as Concept)
				}
				else if(entity instanceof Aspect){
					// Add 'Concepts' connected to this Aspect
					graph.get(entity).forEach[t |
						val node = t.key
						if((node instanceof Concept) && (t.value instanceof SpecializationAxiom)){
							concepts.add(node as Concept)
							visited.add(node)
						}
					]
				}
				
			} else {
				// Put axiom nodes on queue
				// Put Aspects on queue to travel
				queue.add(entity)
			}			
		]
		visited.add(c)		
		
		// Search graph for connected concepts along path
		// of root concept passed as method arg
		while(queue.peek() !== null){
			val node = queue.poll()
			// Check for entity relationships to Concepts
			var foundConnnection = false
			for(e : graph.get(node)){
				// node <relOrAx> n
				val n = e.key
				val relOrAx = e.value
				if((relOrAx instanceof EntityRelationship) && (n instanceof Concept)){
					    concepts.add(n as Concept)
					    visited.add(n)
					    // No need to go further. 
					    // Don't travel further along this path
					    foundConnnection = true
			    } else {
			    	if(foundConnnection){
			    		// Already found connection
			    		visited.add(n)
			    	}
			    	else if(!(relOrAx instanceof EntityRelationship) && (n instanceof Concept)){
			    		// Axiom to Concept
					    visited.add(n)
			        } else {
			    	      // n is Aspect and relOrAx is an Axiom AND connection not found yet
			    	      // put n on queue to search that path	
			    	      if(!visited.contains(n)){
			    	          visited.add(n)
			    	          queue.add(n)
			    	      }		
			        }    	    			    	
			    }
		    }
		}
		concepts.add(c)
		concepts
	}	
	
	/*
	 * Same as 'getConnectedConcepts' but returns all
	 * {@link EntityRelationship}s, {@link SpecializationAxiom}s and
	 * {@link EntityRestrictionAxiom}s.
	 * 
	 * @param c Root Concept
	 * @return Set<TerminologyBoxStatement> The set of {@link EntityRelationship}s, 
	 * {@link SpecializationAxiom}s and	{@link EntityRestrictionAxiom}s. connected to c
	 */
	private def Set<TerminologyBoxStatement> getUsageReltionships(Concept c){
		val graph = buildEntityGraph(c)
		val relationships = new HashSet<TerminologyBoxStatement>
		// For graph search
		val queue = new LinkedList<Entity> as Queue<Entity>
		
		// Since graph was created as an undirected graph
		// nodes need to be marked in order to terminate search
		val visited =  new HashSet<Entity>
		// Put initial entities on queue if they are not Entity Relationships
		graph.get(c).
		forEach[e |
			// c <relOrAx> entity
			val entity = e.key
			val relOrAx = e.value			
			visited.add(entity)
			if(relOrAx instanceof EntityRelationship){
				if(entity instanceof Concept){
					// Concept is connected
				    relationships.add(relOrAx)
				}
				else if(entity instanceof Aspect){
					// Add 'Concepts' connected to this Aspect
					graph.get(entity).forEach[t |
						// t <edge> node
						val node = t.key
						if(node instanceof Concept){
							relationships.add(relOrAx)
							visited.add(node)
						}
					]
				}
				
			} else {
				// Put axiom nodes on queue
				// Put Aspects on queue to travel
				queue.add(entity)
			}			
		]
		visited.add(c)		
		
		// Search graph for connected concepts along path
		// of root concept passed as method arg
		while(queue.peek() !== null){
			val node = queue.poll()
			// Check for entity relationships to Concepts
			var foundConnnection = false
			for(e : graph.get(node)){
				// node <relOrAx> n
				val n = e.key
				val relOrAx = e.value
				if(((relOrAx instanceof EntityRelationship) || (relOrAx instanceof EntityRestrictionAxiom)) && 
					(n instanceof Concept)
				){
					    relationships.add(relOrAx)
					    visited.add(n)
					    // No need to go further. 
					    // Don't travel further along this path
					    foundConnnection = true
			    } else {
			    	if(foundConnnection){
			    		// Already found connection
			    		visited.add(n)
			    	}
			    	else if(!((relOrAx instanceof EntityRelationship) || (relOrAx instanceof EntityRestrictionAxiom)) && 
			    		(n instanceof Concept)){
			    		// Axiom to Concept
					    visited.add(n)
			        } else {
			    	      // n is Aspect and relOrAx is an Axiom AND connection not found yet
			    	      // put n on queue to search that path	
			    	      if(!visited.contains(n)){
			    	          visited.add(n)
			    	          queue.add(n)
			    	      }		
			        }    	    			    	
			    }
		    }
		}
		
		relationships
	}
	
	private def Map<Entity,List<Entry<Entity,TerminologyBoxStatement>>> buildEntityGraph(Entity e){
				
		// Key: Entity
		// Value: List of Entity, Relationship/Axiom pairs
		val graph = new HashMap<Entity,List<Entry<Entity,TerminologyBoxStatement>>>
		
		if(e.tbox === null) return graph
		// Build graph
		 OMLExtensions.allImportedTerminologies(e.tbox)
        .map[boxStatements]
        .flatten
        .filterNull
		.forEach[relOrAx |
			val entry = getSourceAndTarget(relOrAx)
			if(entry !== null){
				val source = entry.key
				val target = entry.value
				// Put in source entry
				if(graph.containsKey(source)){					
					val pair = new SimpleEntry(target,relOrAx)
					graph.get(source).add(pair)
					
				} else {
					// 'source' is not in graph yet
					val list = new ArrayList<Entry<Entity,TerminologyBoxStatement>>
				    list.add(new SimpleEntry(target,relOrAx))
				    graph.put(source, list)				  
				}
				// Put in target entry
				if(graph.containsKey(target)){
				    val pair2 = new SimpleEntry(source,relOrAx)
				    graph.get(target).add(pair2)
				} else{
				   	val list = new ArrayList<Entry<Entity,TerminologyBoxStatement>>
				   	list.add(new SimpleEntry(source,relOrAx))
				   	graph.put(target, list)
				}
			}
		]
		
		graph
	}
	
	private def Entry<Entity, Entity> getSourceAndTarget(TerminologyBoxStatement t){
		if(t instanceof EntityRestrictionAxiom){
				val n1 = (t as EntityRestrictionAxiom).restrictedRange
				val n2 = (t as EntityRestrictionAxiom).restrictedDomain
				return new SimpleEntry(n1,n2)
		} else if(t instanceof SpecializationAxiom){
				val n1 = (t as SpecializationAxiom).child
				val n2 = (t as SpecializationAxiom).parent
				return new SimpleEntry(n1,n2)
		} else if(t instanceof EntityRelationship){
				val n1 = (t as EntityRelationship).source
				val n2 = (t as EntityRelationship).target
				return new SimpleEntry(n1,n2)
		}
		null
	}
}