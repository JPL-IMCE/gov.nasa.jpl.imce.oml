package gov.nasa.jpl.imce.oml.viewpoint

import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import java.util.Set
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import java.util.HashSet

class DiagramUtil {
	/*
	 * Returns a set of {@link EntityStructuredDataProperty}s such that each {@link EntityStructuredDataProperty} [p]
	 * has as its domain the {@link Entity} [e] as its domain and [p] is declared either directly in the same
	 * {@link TerminologyBox} as [e] or in some other {@link TerminologyBox} imported from it.
	 * 
	 * @param The Entity
	 * @return Set of {@link EntityStructuredDataProperty}
	 */

	def Set<EntityStructuredDataProperty> getContainedEntityStructuredDataProperties(Entity e){
		
		if(e.tbox === null) return new HashSet<EntityStructuredDataProperty>()
		
		OMLExtensions.allImportedTerminologies(e.tbox)
        .map[boxStatements]
        .flatten
        .filterNull
	    .filter(EntityStructuredDataProperty)
	    .filter[f | f.relationDomain == e]
	    .toSet
	  
//	    val set = e.tbox.boxStatements.
//	    filter(EntityStructuredDataProperty).toSet
//	    
//	    if(set.isEmpty) return set;
//	    
//	    set.filter[f | f.relationDomain == e].
//	    toSet
	}
	
	/*
	 * Returns a set of {@link EntityScalarDataProperty}s in this {@link TerminologyBox}
	 * that have the passed {@link Entity} as its domain
	 * 
	 * @param The Entity
	 * @return Set of {@link EntityScalarDataProperty}
	 */
	def Set<EntityScalarDataProperty> getContainedEntityScalarDataProperties(Entity e){		
		
		if(e.tbox === null) return new HashSet<EntityScalarDataProperty>()
		
		OMLExtensions.allImportedTerminologies(e.tbox)
		.map[boxStatements]
	    .flatten
        .filterNull
	    .filter(EntityScalarDataProperty)
	    .filter[f | f.relationDomain == e]
	    .toSet

//        val set = e?.tbox?.boxStatements	  
//	    .filter(EntityScalarDataProperty)
//	    .toSet
//	    
//	    if(set.isEmpty) return set;
//	    
//	    set.filter[f | f.relationDomain == e].
//	    toSet
	}
}