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

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import java.util.HashSet
import java.util.Set
import org.eclipse.sirius.diagram.DDiagram
import org.eclipse.sirius.diagram.DSemanticDiagram
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom

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
	def Entity getRootEntity(DDiagram d) {
		return (d as DSemanticDiagram).target as Entity
	}

	/*
	 * Gets all {@link EntityRelationship}s whose relation domain 
	 * is the root {@link Entity} associated 
	 * with the passed {@link DDiagram} and that are found
	 * in the transitive closure of imports from the {@link TeminologyBox} associated 
	 * with the passed {@link DDiagram}.
	 * 
	 * @param d The Diagram
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<EntityRelationship> getVisualRelationshipsWithRootAsDomain(DDiagram d) {
		val e = getRootEntity(d)

		if(e.tbox === null) return new HashSet<EntityRelationship>()

		OMLExtensions.allImportedTerminologies(e.tbox).map[boxStatements].flatten.filterNull.filter(EntityRelationship).
			filter[f|f.relationSource == e].toSet

	}

	/*
	 * Gets all {@link EntityRelationship}s whose relation range 
	 * is the root {@link Entity} associated 
	 * with the passed {@link DDiagram} and that are found
	 * in the transitive closure of imports from the {@link TeminologyBox} associated 
	 * with the passed {@link DDiagram}.
	 * 
	 * @param d The Diagram
	 * @return Set of {@link ReifiedRelationship}s
	 */
	def Set<ReifiedRelationship> getVisualRelationshipsWithRootAsRange(DDiagram d) {
		val e = getRootEntity(d)

		if(e.tbox === null) return new HashSet<ReifiedRelationship>()

		OMLExtensions.allImportedTerminologies(e.tbox).map[boxStatements].flatten.filterNull.filter(
			ReifiedRelationship).filter[f|f.target == e].toSet
	}

	/*
	 * Gets all {@link Entity}s that are directly connected 
	 * (relationship/axiom) to the root {@link Entity} associated 
	 * with the passed {@link DDiagram} and that are found
	 * in the transitive closure of imports from the {@link TeminologyBox} associated 
	 * with the passed {@link DDiagram}.
	 * 
	 *  @param d The Diagram
	 *  @return Set of {@link Entity}s
	 */
	def Set<Entity> getVisualEntities(DDiagram d) {
		val e = getRootEntity(d)
		val entities = new HashSet<Entity>

		if(e.tbox === null) return entities

		OMLExtensions.allImportedTerminologies(e.tbox).map[boxStatements].flatten.filterNull.forEach [ t |
			switch t {
				SpecializationAxiom: {
					val n = t.child
					if (n == e) {
						entities.add(t.parent)
					}
				}
				EntityRestrictionAxiom: {
					val n = t.restrictedDomain
					if (n == e) {
						entities.add(t.restrictedRange)
					}
				}
				EntityRelationship: {
					val n1 = (t as EntityRelationship).relationSource
					val n2 = (t as EntityRelationship).relationTarget
					if (n1 == e) {
						entities.add(n2)
					} else if (n2 == e) {
						entities.add(n1)
					}
				}
			}
		]
		entities.add(e)
		entities
	}

	/*
	 * Gets all {@link AspectSpcializationAxiom}s that have to the root {@link Entity} associated 
	 * with the passed {@link DDiagram} as its sub-Entity and that are found
	 * in the transitive closure of imports from the {@link TeminologyBox} associated 
	 * with the passed {@link DDiagram}.
	 * 
	 * @param d The diagram
	 * @return Set of {@link AspectSpecializationAxiom}s
	 */
	def Set<AspectSpecializationAxiom> getVisualAspectAxioms(DDiagram d) {
		val e = getRootEntity(d)

		if(e.tbox === null) return new HashSet<AspectSpecializationAxiom>()

		OMLExtensions.allImportedTerminologies(e.tbox).map[boxStatements].flatten.filterNull.filter(
			AspectSpecializationAxiom).filter[f|f.subEntity == e].toSet
	}

	/*
	 * Gets all {@link ConceptSpcializationAxiom}s
	 * that have to the root {@link Entity} associated with the passed 
	 * {@link DDiagram} as its sub-Concept and that are found
	 * in the transitive closure of imports from the {@link TeminologyBox} associated 
	 * with the passed {@link DDiagram}.
	 * 
	 * @paramd The Diagram
	 * @return Set of {@link ConceptSpecializationAxiom}s
	 */
	def Set<ConceptSpecializationAxiom> getVisualConceptAxioms(DDiagram d) {
		val c = getRootEntity(d)

		if(c.tbox === null) return new HashSet<ConceptSpecializationAxiom>()

		OMLExtensions.allImportedTerminologies(c.tbox).map[boxStatements].flatten.filterNull.filter(
			ConceptSpecializationAxiom).filter[f|f.subConcept == c].toSet
	}

	/*
	 * Gets all {@link EntityRestrictionAxiom}s 
	 * that have to the root {@link Entity} associated with the passed 
	 * {@link DDiagram} as its restricted Domain and that are found
	 * in the transitive closure of imports from the {@link TeminologyBox} associated 
	 * with the passed {@link DDiagram}.
	 * 
	 * @param The root Entity
	 * @return Set of {@link EntityRestrictionAxiom}s
	 */
	def Set<EntityRestrictionAxiom> getVisualRestrictionAxioms(Entity e) {
		if(e.tbox === null) return new HashSet<EntityRestrictionAxiom>()

		OMLExtensions.allImportedTerminologies(e.tbox).map[boxStatements].flatten.filterNull.filter(
			EntityRestrictionAxiom).filter(f|f.restrictedDomain == e).toSet
	}

	/*
	 * Gets the label for the given {@link EntityRestrictionAxiom}
	 * 
	 * @param e The {@link EntityRestrictionAxiom}
	 * @return EntityRestrictionAxiom label
	 */
	def String getAxiomLabel(EntityRestrictionAxiom ax) {
		switch ax {
			EntityExistentialRestrictionAxiom:
				'''some «ax.restrictedRelation.abbrevIRI» in'''
			EntityUniversalRestrictionAxiom:
				'''all «ax.restrictedRelation.abbrevIRI» in'''
		}
	}
}
