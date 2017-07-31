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
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement
import java.util.AbstractMap.SimpleEntry
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedHashSet
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.Map.Entry
import java.util.Queue
import java.util.Set

class TerminologyService {
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
	 * Gets all {@link Entity} that are directly connected (relationship/axiom)
	 * to the passed {@link Entity}
	 * @param e The entity which to find connections 
	 */
	def Set<Entity> getConnectedEntities(Entity e){
		val entities = new HashSet<Entity>
		e.tbox.boxStatements.
		forEach[t | 
			val entry = getSourceAndTarget(t)
			if(entry != null){
				val n1 = entry.key
				val n2 = entry.value
				if(n1 == e){
					entities.add(n2)
				} else if (n2 == e){
					entities.add(n1)
				}
			}						
		]
		entities.add(e)
		entities		
	}
	
	/*
	 * Gets all {@link Concept}s that are connected, directly
	 * and indirectly, to the passed {@ Concept}.  For indirect
	 * connections this method only finds the first Concept, not all
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
		while(queue.peek() != null){
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
	 * @param c Root Concept
	 * @return Set<TerminologyBoxStatement> The set of {@link EntityRelationship}s, 
	 * {@link SpecializationAxiom}s and	{@link EntityRestrictionAxiom}s. connected to c
	 */
	def Set<TerminologyBoxStatement> getUsageReltionships(Concept c){
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
		while(queue.peek() != null){
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
	
	/*
	 * Gets all {@link ReifiedRelationship}s that are indirectly connected
	 * to the {@link Concept} 'c' in which 'c' would be the source
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
	
	private def Map<Entity,List<Entry<Entity,TerminologyBoxStatement>>> buildEntityGraph(Entity c){
				
		// Key: Entity
		// Value: List of Entity, Relationship/Axiom pairs
		val graph = new HashMap<Entity,List<Entry<Entity,TerminologyBoxStatement>>>
		
		// Build graph
		c.tbox.boxStatements.
		forEach[relOrAx |
			val entry = getSourceAndTarget(relOrAx)
			if(entry != null){
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