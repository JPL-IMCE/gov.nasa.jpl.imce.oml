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
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class AspectConceptClassDiagramService {
  /**
   * Gets root {@link Entity} which the passed {@link DDiagram}
   * was created from
   * 
   * @param The diagram
   * @return The root {@link Entity}
   */
  public Entity getRootEntity(final DDiagram d) {
    EObject _target = ((DSemanticDiagram) d).getTarget();
    return ((Entity) _target);
  }
  
  /**
   * Gets all {@link EntityRelationship}s with the
   * passed {@link} Concept as its relation domain
   * 
   * @param c The root Concept
   * @return Set of {@link ReifiedRelationship}s
   */
  public Set<EntityRelationship> getVisualRelationshipsWithRootAsDomain(final Entity e) {
    TerminologyBox _tbox = e.getTbox();
    EList<TerminologyBoxStatement> _boxStatements = _tbox.getBoxStatements();
    Iterable<EntityRelationship> _filter = Iterables.<EntityRelationship>filter(_boxStatements, EntityRelationship.class);
    final Function1<EntityRelationship, Boolean> _function = (EntityRelationship f) -> {
      Entity _source = f.getSource();
      return Boolean.valueOf(Objects.equal(_source, e));
    };
    Iterable<EntityRelationship> _filter_1 = IterableExtensions.<EntityRelationship>filter(_filter, _function);
    return IterableExtensions.<EntityRelationship>toSet(_filter_1);
  }
  
  /**
   * Gets all {@link ReifiedRelationship}s with the
   * passed {@link} Concept as its relation range
   * 
   * @param c The root Concept
   * @return Set of {@link ReifiedRelationship}s
   */
  public Set<ReifiedRelationship> getVisualRelationshipsWithRootAsRange(final Entity e) {
    TerminologyBox _tbox = e.getTbox();
    EList<TerminologyBoxStatement> _boxStatements = _tbox.getBoxStatements();
    Iterable<ReifiedRelationship> _filter = Iterables.<ReifiedRelationship>filter(_boxStatements, ReifiedRelationship.class);
    final Function1<ReifiedRelationship, Boolean> _function = (ReifiedRelationship f) -> {
      Entity _target = f.getTarget();
      return Boolean.valueOf(Objects.equal(_target, e));
    };
    Iterable<ReifiedRelationship> _filter_1 = IterableExtensions.<ReifiedRelationship>filter(_filter, _function);
    return IterableExtensions.<ReifiedRelationship>toSet(_filter_1);
  }
  
  /**
   * Gets all {@link Entity} that are directly connected (relationship/axiom)
   * to the passed {@link Entity}
   * @param e The entity which to find connections
   */
  public Set<Entity> getVisualEntities(final Entity e) {
    HashSet<Entity> _xblockexpression = null;
    {
      final HashSet<Entity> entities = new HashSet<Entity>();
      TerminologyBox _tbox = e.getTbox();
      EList<TerminologyBoxStatement> _boxStatements = _tbox.getBoxStatements();
      final Consumer<TerminologyBoxStatement> _function = (TerminologyBoxStatement t) -> {
        if ((t instanceof SpecializationAxiom)) {
          final Entity n = ((SpecializationAxiom) t).child();
          boolean _equals = Objects.equal(n, e);
          if (_equals) {
            Entity _parent = ((SpecializationAxiom) t).parent();
            entities.add(_parent);
          }
        } else {
          if ((t instanceof EntityRestrictionAxiom)) {
            final Entity n_1 = ((EntityRestrictionAxiom) t).getRestrictedDomain();
            boolean _equals_1 = Objects.equal(n_1, e);
            if (_equals_1) {
              Entity _restrictedRange = ((EntityRestrictionAxiom) t).getRestrictedRange();
              entities.add(_restrictedRange);
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
      _boxStatements.forEach(_function);
      entities.add(e);
      _xblockexpression = entities;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link AspectSpcializationAxiom}s that have the passed
   * {@link Entity} as its sub-Entity
   * 
   * @param e The root {@link Entity}
   * @return Set of {@link AspectSpecializationAxiom}s
   */
  public Set<AspectSpecializationAxiom> getVisualAspectAxioms(final Entity e) {
    TerminologyBox _tbox = e.getTbox();
    EList<TerminologyBoxStatement> _boxStatements = _tbox.getBoxStatements();
    Iterable<AspectSpecializationAxiom> _filter = Iterables.<AspectSpecializationAxiom>filter(_boxStatements, AspectSpecializationAxiom.class);
    final Function1<AspectSpecializationAxiom, Boolean> _function = (AspectSpecializationAxiom f) -> {
      Entity _subEntity = f.getSubEntity();
      return Boolean.valueOf(Objects.equal(_subEntity, e));
    };
    Iterable<AspectSpecializationAxiom> _filter_1 = IterableExtensions.<AspectSpecializationAxiom>filter(_filter, _function);
    return IterableExtensions.<AspectSpecializationAxiom>toSet(_filter_1);
  }
  
  /**
   * Gets all {@link ConceptSpcializationAxiom}s that have the passed
   * {@link Concept} as its sub-Concept
   * 
   * @param c The root {@link Concept}
   * @return Set of {@link ConceptSpecializationAxiom}s
   */
  public Set<ConceptSpecializationAxiom> getVisualConceptAxioms(final Concept e) {
    TerminologyBox _tbox = e.getTbox();
    EList<TerminologyBoxStatement> _boxStatements = _tbox.getBoxStatements();
    Iterable<ConceptSpecializationAxiom> _filter = Iterables.<ConceptSpecializationAxiom>filter(_boxStatements, ConceptSpecializationAxiom.class);
    final Function1<ConceptSpecializationAxiom, Boolean> _function = (ConceptSpecializationAxiom f) -> {
      Concept _subConcept = f.getSubConcept();
      return Boolean.valueOf(Objects.equal(_subConcept, e));
    };
    Iterable<ConceptSpecializationAxiom> _filter_1 = IterableExtensions.<ConceptSpecializationAxiom>filter(_filter, _function);
    return IterableExtensions.<ConceptSpecializationAxiom>toSet(_filter_1);
  }
  
  /**
   * Gets all {@link EntityRestrictionAxiom}s that have the passed
   * {@link Entity} as its restricted Domain
   * 
   * @param The root Entity
   * @return Set of {@link EntityRestrictionAxiom}s
   */
  public Set<EntityRestrictionAxiom> getVisualRestrictionAxioms(final Entity e) {
    TerminologyBox _tbox = e.getTbox();
    EList<TerminologyBoxStatement> _boxStatements = _tbox.getBoxStatements();
    Iterable<EntityRestrictionAxiom> _filter = Iterables.<EntityRestrictionAxiom>filter(_boxStatements, EntityRestrictionAxiom.class);
    final Function1<EntityRestrictionAxiom, Boolean> _function = (EntityRestrictionAxiom f) -> {
      Entity _restrictedDomain = f.getRestrictedDomain();
      return Boolean.valueOf(Objects.equal(_restrictedDomain, e));
    };
    Iterable<EntityRestrictionAxiom> _filter_1 = IterableExtensions.<EntityRestrictionAxiom>filter(_filter, _function);
    return IterableExtensions.<EntityRestrictionAxiom>toSet(_filter_1);
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
