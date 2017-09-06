package gov.nasa.jpl.imce.oml.viewpoint

import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import java.util.Set

class DiagramUtil {
	/*
	 * Returns a set of {@link EntityStructuredDataProperty}s such that each {@link EntityStructuredDataProperty} [p]
	 * has as its domain the {@link Entity} [e] as its domain and [p] is declared either directly in the same
	 * {@link TerminologyBox} as [e] or in some other {@link TerminologyBox} imported from it.
	 * 
	 * @param The Entity
	 * @return Set of {@link EntityStructuredDataProperty}
	 */

	def Set<EntityStructuredDataProperty> getContainedEntityStructuredDataProperties(Entity c){
	    val set = c.tbox.boxStatements.
	    filter(EntityStructuredDataProperty).toSet
	    
	    if(set.isEmpty) return set;
	    
	    set.filter[f | f.relationDomain == c].
	    toSet
	}
	
	/*
	 * Returns a set of {@link EntityScalarDataProperty}s in this {@link TerminologyBox}
	 * that have the passed {@link Entity} as its domain
	 * 
	 * @param The Entity
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