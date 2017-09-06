/**
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
package gov.nasa.jpl.imce.oml.viewpoint;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Used to query for visual elements for the 'Aspect/Concept Class Diagram'
 * 
 * The 'Aspect/Concept Class Diagram' will show all {@link ReifiedRelationship}s
 * that have a selected root {@link Aspect} or {@link Concept} as its domain or range
 * (from this {@link TerminologyBox} only).
 * 
 * It also shows {@link SpecializationAxiom}s that have the selected {@Aspect} or
 * {@link Concept} as its child (superEntity/Concept/Aspect)
 * 
 * Containers: Concept, Aspect
 * Edges: Reified/UnReified Relationships, Specialization Axioms
 */
@SuppressWarnings("all")
public class AspectConceptClassDiagramService {
  /**
   * Gets root {@link Entity} which the passed {@link DDiagram}
   * was created from
   * 
   * @param The diagram
   * @return The Diagram
   */
  public Entity getRootEntity(final DDiagram d) {
    EObject _target = ((DSemanticDiagram) d).getTarget();
    return ((Entity) _target);
  }
  
  /**
   * Gets all {@link EntityRelationship}s within the {@link TeminologyBox}
   * which have as its relationDomain the root {@link Entity} associated
   * with the passed {@link DDiagram}
   * 
   * @param d The Diagram
   * @return Set of {@link ReifiedRelationship}s
   */
  public Set<EntityRelationship> getVisualRelationshipsWithRootAsDomain(final DDiagram d) {
    Set<EntityRelationship> _xblockexpression = null;
    {
      final Entity e = this.getRootEntity(d);
      final Set<EntityRelationship> set = IterableExtensions.<EntityRelationship>toSet(Iterables.<EntityRelationship>filter(e.getTbox().getBoxStatements(), EntityRelationship.class));
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<EntityRelationship, Boolean> _function = (EntityRelationship f) -> {
        Entity _source = f.getSource();
        return Boolean.valueOf(Objects.equal(_source, e));
      };
      _xblockexpression = IterableExtensions.<EntityRelationship>toSet(IterableExtensions.<EntityRelationship>filter(set, _function));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link EntityRelationship}s within the {@link TeminologyBox}
   * which have as its relation range the root {@link Entity} associated
   * with the passed {@link DDiagram}
   * 
   * @param d The Diagram
   * @return Set of {@link ReifiedRelationship}s
   */
  public Set<ReifiedRelationship> getVisualRelationshipsWithRootAsRange(final DDiagram d) {
    Set<ReifiedRelationship> _xblockexpression = null;
    {
      final Entity e = this.getRootEntity(d);
      final Set<ReifiedRelationship> set = IterableExtensions.<ReifiedRelationship>toSet(Iterables.<ReifiedRelationship>filter(e.getTbox().getBoxStatements(), ReifiedRelationship.class));
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<ReifiedRelationship, Boolean> _function = (ReifiedRelationship f) -> {
        Entity _target = f.getTarget();
        return Boolean.valueOf(Objects.equal(_target, e));
      };
      _xblockexpression = IterableExtensions.<ReifiedRelationship>toSet(IterableExtensions.<ReifiedRelationship>filter(set, _function));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link Entity}s in this {@link TerminologyBox} that are directly connected
   * (relationship/axiom) to the root {@link Entity} associated
   * with the passed {@link DDiagram}
   * 
   *  @param d The Diagram
   *  @return Set of {@link Entity}s
   */
  public Set<Entity> getVisualEntities(final DDiagram d) {
    HashSet<Entity> _xblockexpression = null;
    {
      final Entity e = this.getRootEntity(d);
      final HashSet<Entity> entities = new HashSet<Entity>();
      final Consumer<TerminologyBoxStatement> _function = (TerminologyBoxStatement t) -> {
        if ((t instanceof SpecializationAxiom)) {
          final Entity n = ((SpecializationAxiom) t).child();
          boolean _equals = Objects.equal(n, e);
          if (_equals) {
            entities.add(((SpecializationAxiom) t).parent());
          }
        } else {
          if ((t instanceof EntityRestrictionAxiom)) {
            final Entity n_1 = ((EntityRestrictionAxiom) t).getRestrictedDomain();
            boolean _equals_1 = Objects.equal(n_1, e);
            if (_equals_1) {
              entities.add(((EntityRestrictionAxiom) t).getRestrictedRange());
            }
          } else {
            if ((t instanceof EntityRelationship)) {
              final Entity n1 = ((EntityRelationship) t).getSource();
              final Entity n2 = ((EntityRelationship) t).getTarget();
              boolean _equals_2 = Objects.equal(n1, e);
              if (_equals_2) {
                entities.add(n2);
              } else {
                boolean _equals_3 = Objects.equal(n2, e);
                if (_equals_3) {
                  entities.add(n1);
                }
              }
            }
          }
        }
      };
      e.getTbox().getBoxStatements().forEach(_function);
      entities.add(e);
      _xblockexpression = entities;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link AspectSpcializationAxiom}s in this {@link TerminologyBox}
   * that have to the root {@link Entity} associated
   * with the passed {@link DDiagram} as its sub-Entity
   * 
   * @param d The diagram
   * @return Set of {@link AspectSpecializationAxiom}s
   */
  public Set<AspectSpecializationAxiom> getVisualAspectAxioms(final DDiagram d) {
    Set<AspectSpecializationAxiom> _xblockexpression = null;
    {
      final Entity e = this.getRootEntity(d);
      final Set<AspectSpecializationAxiom> set = IterableExtensions.<AspectSpecializationAxiom>toSet(Iterables.<AspectSpecializationAxiom>filter(e.getTbox().getBoxStatements(), AspectSpecializationAxiom.class));
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<AspectSpecializationAxiom, Boolean> _function = (AspectSpecializationAxiom f) -> {
        Entity _subEntity = f.getSubEntity();
        return Boolean.valueOf(Objects.equal(_subEntity, e));
      };
      _xblockexpression = IterableExtensions.<AspectSpecializationAxiom>toSet(IterableExtensions.<AspectSpecializationAxiom>filter(set, _function));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link ConceptSpcializationAxiom}s in this {@link TerminologyBox}
   * that have to the root {@link Entity} associated with the passed
   * {@link DDiagram} as its sub-Concept
   * 
   * @paramd The Diagram
   * @return Set of {@link ConceptSpecializationAxiom}s
   */
  public Set<ConceptSpecializationAxiom> getVisualConceptAxioms(final DDiagram d) {
    Set<ConceptSpecializationAxiom> _xblockexpression = null;
    {
      final Entity c = this.getRootEntity(d);
      final Set<ConceptSpecializationAxiom> set = IterableExtensions.<ConceptSpecializationAxiom>toSet(Iterables.<ConceptSpecializationAxiom>filter(c.getTbox().getBoxStatements(), ConceptSpecializationAxiom.class));
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<ConceptSpecializationAxiom, Boolean> _function = (ConceptSpecializationAxiom f) -> {
        Concept _subConcept = f.getSubConcept();
        return Boolean.valueOf(Objects.equal(_subConcept, c));
      };
      _xblockexpression = IterableExtensions.<ConceptSpecializationAxiom>toSet(IterableExtensions.<ConceptSpecializationAxiom>filter(set, _function));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link EntityRestrictionAxiom}s in this {@link TerminologyBox}
   * that have to the root {@link Entity} associated with the passed
   * {@link DDiagram} as its restricted Domain
   * 
   * @param The root Entity
   * @return Set of {@link EntityRestrictionAxiom}s
   */
  public Set<EntityRestrictionAxiom> getVisualRestrictionAxioms(final Entity e) {
    Set<EntityRestrictionAxiom> _xblockexpression = null;
    {
      final Set<EntityRestrictionAxiom> set = IterableExtensions.<EntityRestrictionAxiom>toSet(Iterables.<EntityRestrictionAxiom>filter(e.getTbox().getBoxStatements(), EntityRestrictionAxiom.class));
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<EntityRestrictionAxiom, Boolean> _function = (EntityRestrictionAxiom f) -> {
        Entity _restrictedDomain = f.getRestrictedDomain();
        return Boolean.valueOf(Objects.equal(_restrictedDomain, e));
      };
      _xblockexpression = IterableExtensions.<EntityRestrictionAxiom>toSet(IterableExtensions.<EntityRestrictionAxiom>filter(set, _function));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets the label for the given {@link EntityRestrictionAxiom}
   * 
   * @param e The {@link EntityRestrictionAxiom}
   * @return '<<existential>>' or '<<universal>>'
   */
  public String getAxiomLabel(final EntityRestrictionAxiom ax) {
    String _xblockexpression = null;
    {
      if ((ax instanceof EntityExistentialRestrictionAxiom)) {
        return "<<existential>>";
      }
      _xblockexpression = "<<universal>>";
    }
    return _xblockexpression;
  }
}
