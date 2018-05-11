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
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
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
import org.eclipse.xtend2.lib.StringConcatenation;
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
   * Gets all {@link EntityRelationship}s whose relation domain
   * is the root {@link Entity} associated
   * with the passed {@link DDiagram} and that are found
   * in the transitive closure of imports from the {@link TeminologyBox} associated
   * with the passed {@link DDiagram}.
   * 
   * @param d The Diagram
   * @return Set of {@link ReifiedRelationship}s
   */
  public Set<EntityRelationship> getVisualRelationshipsWithRootAsDomain(final DDiagram d) {
    Set<EntityRelationship> _xblockexpression = null;
    {
      final Entity e = this.getRootEntity(d);
      TerminologyBox _tbox = e.getTbox();
      boolean _tripleEquals = (_tbox == null);
      if (_tripleEquals) {
        return new HashSet<EntityRelationship>();
      }
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      final Function1<EntityRelationship, Boolean> _function_1 = (EntityRelationship f) -> {
        Entity _source = f.getSource();
        return Boolean.valueOf(Objects.equal(_source, e));
      };
      _xblockexpression = IterableExtensions.<EntityRelationship>toSet(IterableExtensions.<EntityRelationship>filter(Iterables.<EntityRelationship>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(OMLExtensions.allImportedTerminologies(e.getTbox()), _function))), EntityRelationship.class), _function_1));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link EntityRelationship}s whose relation range
   * is the root {@link Entity} associated
   * with the passed {@link DDiagram} and that are found
   * in the transitive closure of imports from the {@link TeminologyBox} associated
   * with the passed {@link DDiagram}.
   * 
   * @param d The Diagram
   * @return Set of {@link ReifiedRelationship}s
   */
  public Set<ReifiedRelationship> getVisualRelationshipsWithRootAsRange(final DDiagram d) {
    Set<ReifiedRelationship> _xblockexpression = null;
    {
      final Entity e = this.getRootEntity(d);
      TerminologyBox _tbox = e.getTbox();
      boolean _tripleEquals = (_tbox == null);
      if (_tripleEquals) {
        return new HashSet<ReifiedRelationship>();
      }
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      final Function1<ReifiedRelationship, Boolean> _function_1 = (ReifiedRelationship f) -> {
        Entity _target = f.getTarget();
        return Boolean.valueOf(Objects.equal(_target, e));
      };
      _xblockexpression = IterableExtensions.<ReifiedRelationship>toSet(IterableExtensions.<ReifiedRelationship>filter(Iterables.<ReifiedRelationship>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(OMLExtensions.allImportedTerminologies(e.getTbox()), _function))), 
        ReifiedRelationship.class), _function_1));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link Entity}s that are directly connected
   * (relationship/axiom) to the root {@link Entity} associated
   * with the passed {@link DDiagram} and that are found
   * in the transitive closure of imports from the {@link TeminologyBox} associated
   * with the passed {@link DDiagram}.
   * 
   *  @param d The Diagram
   *  @return Set of {@link Entity}s
   */
  public Set<Entity> getVisualEntities(final DDiagram d) {
    HashSet<Entity> _xblockexpression = null;
    {
      final Entity e = this.getRootEntity(d);
      final HashSet<Entity> entities = new HashSet<Entity>();
      TerminologyBox _tbox = e.getTbox();
      boolean _tripleEquals = (_tbox == null);
      if (_tripleEquals) {
        return entities;
      }
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      final Consumer<TerminologyBoxStatement> _function_1 = (TerminologyBoxStatement t) -> {
        boolean _matched = false;
        if (t instanceof SpecializationAxiom) {
          _matched=true;
          final Entity n = ((SpecializationAxiom)t).child();
          boolean _equals = Objects.equal(n, e);
          if (_equals) {
            entities.add(((SpecializationAxiom)t).parent());
          }
        }
        if (!_matched) {
          if (t instanceof EntityRestrictionAxiom) {
            _matched=true;
            final Entity n = ((EntityRestrictionAxiom)t).getRestrictedDomain();
            boolean _equals = Objects.equal(n, e);
            if (_equals) {
              entities.add(((EntityRestrictionAxiom)t).getRestrictedRange());
            }
          }
        }
        if (!_matched) {
          if (t instanceof EntityRelationship) {
            _matched=true;
            final Entity n1 = ((EntityRelationship) t).getSource();
            final Entity n2 = ((EntityRelationship) t).getTarget();
            boolean _equals = Objects.equal(n1, e);
            if (_equals) {
              entities.add(n2);
            } else {
              boolean _equals_1 = Objects.equal(n2, e);
              if (_equals_1) {
                entities.add(n1);
              }
            }
          }
        }
      };
      IterableExtensions.<TerminologyBoxStatement>filterNull(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(OMLExtensions.allImportedTerminologies(e.getTbox()), _function))).forEach(_function_1);
      entities.add(e);
      _xblockexpression = entities;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link AspectSpcializationAxiom}s that have to the root {@link Entity} associated
   * with the passed {@link DDiagram} as its sub-Entity and that are found
   * in the transitive closure of imports from the {@link TeminologyBox} associated
   * with the passed {@link DDiagram}.
   * 
   * @param d The diagram
   * @return Set of {@link AspectSpecializationAxiom}s
   */
  public Set<AspectSpecializationAxiom> getVisualAspectAxioms(final DDiagram d) {
    Set<AspectSpecializationAxiom> _xblockexpression = null;
    {
      final Entity e = this.getRootEntity(d);
      TerminologyBox _tbox = e.getTbox();
      boolean _tripleEquals = (_tbox == null);
      if (_tripleEquals) {
        return new HashSet<AspectSpecializationAxiom>();
      }
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      final Function1<AspectSpecializationAxiom, Boolean> _function_1 = (AspectSpecializationAxiom f) -> {
        Entity _subEntity = f.getSubEntity();
        return Boolean.valueOf(Objects.equal(_subEntity, e));
      };
      _xblockexpression = IterableExtensions.<AspectSpecializationAxiom>toSet(IterableExtensions.<AspectSpecializationAxiom>filter(Iterables.<AspectSpecializationAxiom>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(OMLExtensions.allImportedTerminologies(e.getTbox()), _function))), 
        AspectSpecializationAxiom.class), _function_1));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link ConceptSpcializationAxiom}s
   * that have to the root {@link Entity} associated with the passed
   * {@link DDiagram} as its sub-Concept and that are found
   * in the transitive closure of imports from the {@link TeminologyBox} associated
   * with the passed {@link DDiagram}.
   * 
   * @paramd The Diagram
   * @return Set of {@link ConceptSpecializationAxiom}s
   */
  public Set<ConceptSpecializationAxiom> getVisualConceptAxioms(final DDiagram d) {
    Set<ConceptSpecializationAxiom> _xblockexpression = null;
    {
      final Entity c = this.getRootEntity(d);
      TerminologyBox _tbox = c.getTbox();
      boolean _tripleEquals = (_tbox == null);
      if (_tripleEquals) {
        return new HashSet<ConceptSpecializationAxiom>();
      }
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      final Function1<ConceptSpecializationAxiom, Boolean> _function_1 = (ConceptSpecializationAxiom f) -> {
        Concept _subConcept = f.getSubConcept();
        return Boolean.valueOf(Objects.equal(_subConcept, c));
      };
      _xblockexpression = IterableExtensions.<ConceptSpecializationAxiom>toSet(IterableExtensions.<ConceptSpecializationAxiom>filter(Iterables.<ConceptSpecializationAxiom>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(OMLExtensions.allImportedTerminologies(c.getTbox()), _function))), 
        ConceptSpecializationAxiom.class), _function_1));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link EntityRestrictionAxiom}s
   * that have to the root {@link Entity} associated with the passed
   * {@link DDiagram} as its restricted Domain and that are found
   * in the transitive closure of imports from the {@link TeminologyBox} associated
   * with the passed {@link DDiagram}.
   * 
   * @param The root Entity
   * @return Set of {@link EntityRestrictionAxiom}s
   */
  public Set<EntityRestrictionAxiom> getVisualRestrictionAxioms(final Entity e) {
    Set<EntityRestrictionAxiom> _xblockexpression = null;
    {
      TerminologyBox _tbox = e.getTbox();
      boolean _tripleEquals = (_tbox == null);
      if (_tripleEquals) {
        return new HashSet<EntityRestrictionAxiom>();
      }
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      final Function1<EntityRestrictionAxiom, Boolean> _function_1 = (EntityRestrictionAxiom f) -> {
        Entity _restrictedDomain = f.getRestrictedDomain();
        return Boolean.valueOf(Objects.equal(_restrictedDomain, e));
      };
      _xblockexpression = IterableExtensions.<EntityRestrictionAxiom>toSet(IterableExtensions.<EntityRestrictionAxiom>filter(Iterables.<EntityRestrictionAxiom>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(OMLExtensions.allImportedTerminologies(e.getTbox()), _function))), 
        EntityRestrictionAxiom.class), _function_1));
    }
    return _xblockexpression;
  }
  
  /**
   * Gets the label for the given {@link EntityRestrictionAxiom}
   * 
   * @param e The {@link EntityRestrictionAxiom}
   * @return EntityRestrictionAxiom label
   */
  public String getAxiomLabel(final EntityRestrictionAxiom ax) {
    String _switchResult = null;
    boolean _matched = false;
    if (ax instanceof EntityExistentialRestrictionAxiom) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("some ");
      String _abbrevIRI = ((EntityExistentialRestrictionAxiom)ax).restrictedRelation().abbrevIRI();
      _builder.append(_abbrevIRI);
      _builder.append(" in");
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      if (ax instanceof EntityUniversalRestrictionAxiom) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("all ");
        String _abbrevIRI = ((EntityUniversalRestrictionAxiom)ax).restrictedRelation().abbrevIRI();
        _builder.append(_abbrevIRI);
        _builder.append(" in");
        _switchResult = _builder.toString();
      }
    }
    return _switchResult;
  }
}
