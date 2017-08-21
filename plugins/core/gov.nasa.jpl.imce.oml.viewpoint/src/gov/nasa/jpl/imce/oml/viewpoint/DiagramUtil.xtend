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
	    return c.tbox.boxStatements.
	    filter(EntityStructuredDataProperty).
	    filter[f | f.domain == c].
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
	    return c.tbox.boxStatements.
	    filter(EntityScalarDataProperty).
	    filter[f | f.domain == c].
	    toSet
	}
}