package gov.nasa.jpl.imce.oml.viewpoint

import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import java.util.Set

class DiagramUtil {
	
	/*
	 * Returns a set of {@link EntityStructuredDataProperty}s that have the passed
	 * {@link Concept} as its domain
	 * 
	 * @param The Concept
	 * @return Set of {@link EntityStructuredDataProperty}
	 */
	def Set<EntityStructuredDataProperty> getContainedEntityStructuredDataProperties(Entity c){
	   // return c.tbox.allEntityStructuredDataPropertiesScope.allElements.
	    val set = c.tbox.boxStatements.
	    filter(EntityStructuredDataProperty).toSet
	    
	    if(set.isEmpty) return set;
	    
	    set.filter[f | f.relationDomain == c].
	    toSet
	}
	
	/*
	 * Returns a set of {@link EntityScalarDataProperty}s that have the passed
	 * {@link Concept} as its domain
	 * 
	 * @param The Concept
	 * @return Set of {@link EntityScalarDataProperty}
	 */
	def Set<EntityScalarDataProperty> getContainedEntityScalarDataProperties(Entity c){
		// aql:diagram.oclAsType(diagram::DSemanticDiagram).target.oclAsType(graphs::TerminologyGraph).boxStatements->filter(terminologies::EntityScalarDataProperty)->select(s | s.relationDomain() = self)
	    val set = c.tbox.boxStatements.
	    filter(EntityScalarDataProperty).toSet
	    
	    if(set.isEmpty) return set;
	    
	    set.filter[f | f.relationDomain == c].
	    toSet
	}
}