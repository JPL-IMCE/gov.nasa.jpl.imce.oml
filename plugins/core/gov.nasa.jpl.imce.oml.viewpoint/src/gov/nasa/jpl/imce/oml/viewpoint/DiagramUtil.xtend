package gov.nasa.jpl.imce.oml.viewpoint

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.dsl.scoping.OMLScopeExtensions
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import java.util.Set

class DiagramUtil {
	
	@Inject extension OMLScopeExtensions
	
	/*
	 * Returns a set of {@link EntityStructuredDataProperty}s that have the passed
	 * {@link Concept} as its domain
	 * 
	 * @param The Concept
	 * @return Set of {@link EntityStructuredDataProperty}
	 */
	def Set<EntityStructuredDataProperty> getContainedEntityStructuredDataProperties(Entity c){
	    return c.tbox.allEntityStructuredDataPropertiesScope.allElements.
	    filter(EntityStructuredDataProperty).
	    filter[f | f.relationDomain == c].
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
	    return c.tbox.boxStatements.
	    filter(EntityScalarDataProperty).
	    filter[f | f.relationDomain == c].
	    toSet
	}
}