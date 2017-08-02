package gov.nasa.jpl.imce.oml.viewpoint;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ConceptUsageDiagramService {
  public Concept getRootConcept(final DDiagram d) {
    EObject _target = ((DSemanticDiagram) d).getTarget();
    return ((Concept) _target);
  }
  
  /**
   * Gets all {@link EntityRelationship}s with the
   * passed {@link} Concept as its relation domain
   * 
   * @param c The root Concept
   * @return Set of {@link ReifiedRelationship}s
   */
  public Set<ReifiedRelationship> getVisualRelationshipsWithRootAsDomain(final Concept c) {
    final Function1<ReifiedRelationship, Boolean> _function = (ReifiedRelationship f) -> {
      Entity _source = f.getSource();
      return Boolean.valueOf(Objects.equal(_source, c));
    };
    return IterableExtensions.<ReifiedRelationship>toSet(IterableExtensions.<ReifiedRelationship>filter(Iterables.<ReifiedRelationship>filter(this.getUsageReltionships(c), ReifiedRelationship.class), _function));
  }
  
  /**
   * Gets all {@link ReifiedRelationship}s with the
   * passed {@link} Concept as its relation range
   * 
   * @param c The root Concept
   * @return Set of {@link ReifiedRelationship}s
   */
  public Set<ReifiedRelationship> getVisualRelationshipsWithRootAsRange(final Concept c) {
    final Function1<ReifiedRelationship, Boolean> _function = (ReifiedRelationship f) -> {
      Entity _target = f.getTarget();
      return Boolean.valueOf(Objects.equal(_target, c));
    };
    return IterableExtensions.<ReifiedRelationship>toSet(IterableExtensions.<ReifiedRelationship>filter(Iterables.<ReifiedRelationship>filter(this.getUsageReltionships(c), ReifiedRelationship.class), _function));
  }
  
  /**
   * Gets all {@link ReifiedRelationship}s that are indirectly connected
   * to the {@link Concept} 'c' in which 'c' would be the source
   * 
   * @param c Root {@link Concept}
   * @return Set<ReifiedRelationship> Set of indirectly connected relationships
   */
  public Set<ReifiedRelationship> getIndirectRelationshipsWithRootAsSource(final Concept c) {
    HashSet<ReifiedRelationship> _xblockexpression = null;
    {
      final HashSet<ReifiedRelationship> relationships = new HashSet<ReifiedRelationship>();
      final Function1<ReifiedRelationship, Boolean> _function = (ReifiedRelationship f) -> {
        Entity _source = f.getSource();
        return Boolean.valueOf((_source instanceof Aspect));
      };
      final Consumer<ReifiedRelationship> _function_1 = (ReifiedRelationship t) -> {
        relationships.add(((ReifiedRelationship) t));
      };
      IterableExtensions.<ReifiedRelationship>filter(Iterables.<ReifiedRelationship>filter(this.getUsageReltionships(c), ReifiedRelationship.class), _function).forEach(_function_1);
      _xblockexpression = relationships;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link ReifiedRelationship}s that are indirectly connected
   * to the {@link Concept} 'c' in which 'c' would be the target
   * 
   * @param c Root {@link Concept}
   * @return Set<ReifiedRelationship> Set of indirectly connected relationships
   */
  public Set<ReifiedRelationship> getIndirectRelationshipsWithRootAsTarget(final Concept c) {
    HashSet<ReifiedRelationship> _xblockexpression = null;
    {
      final HashSet<ReifiedRelationship> relationships = new HashSet<ReifiedRelationship>();
      final Function1<ReifiedRelationship, Boolean> _function = (ReifiedRelationship f) -> {
        Entity _target = f.getTarget();
        return Boolean.valueOf((_target instanceof Aspect));
      };
      final Consumer<ReifiedRelationship> _function_1 = (ReifiedRelationship t) -> {
        relationships.add(((ReifiedRelationship) t));
      };
      IterableExtensions.<ReifiedRelationship>filter(Iterables.<ReifiedRelationship>filter(this.getUsageReltionships(c), ReifiedRelationship.class), _function).forEach(_function_1);
      _xblockexpression = relationships;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets all {@link EntityUniversalRestrictionAxiom}s that have the passed
   * {@link Concept} as its restricted domain
   * 
   * @param c The root {@link Concept}
   * @return Set of {@link EntityUniversalRestrictionAxioms}s
   */
  public Set<EntityUniversalRestrictionAxiom> getUniversalAxiomWithRootAsSource(final Concept c) {
    final Function1<EntityUniversalRestrictionAxiom, Boolean> _function = (EntityUniversalRestrictionAxiom f) -> {
      Entity _restrictedDomain = f.getRestrictedDomain();
      return Boolean.valueOf(Objects.equal(_restrictedDomain, c));
    };
    return IterableExtensions.<EntityUniversalRestrictionAxiom>toSet(IterableExtensions.<EntityUniversalRestrictionAxiom>filter(Iterables.<EntityUniversalRestrictionAxiom>filter(this.getUsageReltionships(c), EntityUniversalRestrictionAxiom.class), _function));
  }
  
  /**
   * Gets all {@link EntityUniversalRestrictionAxiom}s that have the passed
   * {@link Concept} as its restricted range
   * 
   * @param c The root {@link Concept}
   * @return Set of {@link EntityUniversalRestrictionAxioms}s
   */
  public Set<EntityUniversalRestrictionAxiom> getUniversalAxiomWithRootAsTarget(final Concept c) {
    final Function1<EntityUniversalRestrictionAxiom, Boolean> _function = (EntityUniversalRestrictionAxiom f) -> {
      Entity _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<EntityUniversalRestrictionAxiom>toSet(IterableExtensions.<EntityUniversalRestrictionAxiom>filter(Iterables.<EntityUniversalRestrictionAxiom>filter(this.getUsageReltionships(c), EntityUniversalRestrictionAxiom.class), _function));
  }
  
  /**
   * Gets all {@link EntityExitenstialRestrictionAxiom}s that have the passed
   * {@link Concept} as its restricted domain
   * 
   * @param c The root {@link Concept}
   * @return Set of {@link EntityExistentialRestrictionAxioms}s
   */
  public Set<EntityExistentialRestrictionAxiom> getExistentialAxiomWithRootAsSource(final Concept c) {
    final Function1<EntityExistentialRestrictionAxiom, Boolean> _function = (EntityExistentialRestrictionAxiom f) -> {
      Entity _restrictedDomain = f.getRestrictedDomain();
      return Boolean.valueOf(Objects.equal(_restrictedDomain, c));
    };
    return IterableExtensions.<EntityExistentialRestrictionAxiom>toSet(IterableExtensions.<EntityExistentialRestrictionAxiom>filter(Iterables.<EntityExistentialRestrictionAxiom>filter(this.getUsageReltionships(c), EntityExistentialRestrictionAxiom.class), _function));
  }
  
  /**
   * Gets all {@link EntityExistentialRestrictionAxiom}s that have the passed
   * {@link Concept} as its restricted domain
   * 
   * @param c The root {@link Concept}
   * @return Set of {@link EntityExistentialRestrictionAxioms}s
   */
  public Set<EntityExistentialRestrictionAxiom> getExistentialAxiomWithRootAsTarget(final Concept c) {
    final Function1<EntityExistentialRestrictionAxiom, Boolean> _function = (EntityExistentialRestrictionAxiom f) -> {
      Entity _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<EntityExistentialRestrictionAxiom>toSet(IterableExtensions.<EntityExistentialRestrictionAxiom>filter(Iterables.<EntityExistentialRestrictionAxiom>filter(this.getUsageReltionships(c), EntityExistentialRestrictionAxiom.class), _function));
  }
  
  /**
   * Gets all {@link Concept}s that are connected, directly
   * and indirectly, to the passed {@ Concept}.  For indirect
   * connections this method only finds the first Concept, not all
   * 
   * @param c Root concept
   * @return Set<Concept> The set of {@link Concept}s connected to c
   */
  public Set<Concept> getConnectedConcepts(final Concept c) {
    HashSet<Concept> _xblockexpression = null;
    {
      final Map<Entity, List<Map.Entry<Entity, TerminologyBoxStatement>>> graph = this.buildEntityGraph(c);
      final HashSet<Concept> concepts = new HashSet<Concept>();
      LinkedList<Entity> _linkedList = new LinkedList<Entity>();
      final Queue<Entity> queue = ((Queue<Entity>) _linkedList);
      final HashSet<Entity> visited = new HashSet<Entity>();
      final Consumer<Map.Entry<Entity, TerminologyBoxStatement>> _function = (Map.Entry<Entity, TerminologyBoxStatement> e) -> {
        final Entity entity = e.getKey();
        final TerminologyBoxStatement relOrAx = e.getValue();
        visited.add(entity);
        if ((relOrAx instanceof EntityRelationship)) {
          if ((entity instanceof Concept)) {
            concepts.add(((Concept) entity));
          } else {
            if ((entity instanceof Aspect)) {
              final Consumer<Map.Entry<Entity, TerminologyBoxStatement>> _function_1 = (Map.Entry<Entity, TerminologyBoxStatement> t) -> {
                final Entity node = t.getKey();
                if (((node instanceof Concept) && (t.getValue() instanceof SpecializationAxiom))) {
                  concepts.add(((Concept) node));
                  visited.add(node);
                }
              };
              graph.get(entity).forEach(_function_1);
            }
          }
        } else {
          queue.add(entity);
        }
      };
      graph.get(c).forEach(_function);
      visited.add(c);
      while ((!Objects.equal(queue.peek(), null))) {
        {
          final Entity node = queue.poll();
          boolean foundConnnection = false;
          List<Map.Entry<Entity, TerminologyBoxStatement>> _get = graph.get(node);
          for (final Map.Entry<Entity, TerminologyBoxStatement> e : _get) {
            {
              final Entity n = e.getKey();
              final TerminologyBoxStatement relOrAx = e.getValue();
              if (((relOrAx instanceof EntityRelationship) && (n instanceof Concept))) {
                concepts.add(((Concept) n));
                visited.add(n);
                foundConnnection = true;
              } else {
                if (foundConnnection) {
                  visited.add(n);
                } else {
                  if (((!(relOrAx instanceof EntityRelationship)) && (n instanceof Concept))) {
                    visited.add(n);
                  } else {
                    boolean _contains = visited.contains(n);
                    boolean _not = (!_contains);
                    if (_not) {
                      visited.add(n);
                      queue.add(n);
                    }
                  }
                }
              }
            }
          }
        }
      }
      concepts.add(c);
      _xblockexpression = concepts;
    }
    return _xblockexpression;
  }
  
  /**
   * Same as 'getConnectedConcepts' but returns all
   * {@link EntityRelationship}s, {@link SpecializationAxiom}s and
   * {@link EntityRestrictionAxiom}s.
   * 
   * @param c Root Concept
   * @return Set<TerminologyBoxStatement> The set of {@link EntityRelationship}s,
   * {@link SpecializationAxiom}s and	{@link EntityRestrictionAxiom}s. connected to c
   */
  private Set<TerminologyBoxStatement> getUsageReltionships(final Concept c) {
    HashSet<TerminologyBoxStatement> _xblockexpression = null;
    {
      final Map<Entity, List<Map.Entry<Entity, TerminologyBoxStatement>>> graph = this.buildEntityGraph(c);
      final HashSet<TerminologyBoxStatement> relationships = new HashSet<TerminologyBoxStatement>();
      LinkedList<Entity> _linkedList = new LinkedList<Entity>();
      final Queue<Entity> queue = ((Queue<Entity>) _linkedList);
      final HashSet<Entity> visited = new HashSet<Entity>();
      final Consumer<Map.Entry<Entity, TerminologyBoxStatement>> _function = (Map.Entry<Entity, TerminologyBoxStatement> e) -> {
        final Entity entity = e.getKey();
        final TerminologyBoxStatement relOrAx = e.getValue();
        visited.add(entity);
        if ((relOrAx instanceof EntityRelationship)) {
          if ((entity instanceof Concept)) {
            relationships.add(relOrAx);
          } else {
            if ((entity instanceof Aspect)) {
              final Consumer<Map.Entry<Entity, TerminologyBoxStatement>> _function_1 = (Map.Entry<Entity, TerminologyBoxStatement> t) -> {
                final Entity node = t.getKey();
                if ((node instanceof Concept)) {
                  relationships.add(relOrAx);
                  visited.add(node);
                }
              };
              graph.get(entity).forEach(_function_1);
            }
          }
        } else {
          queue.add(entity);
        }
      };
      graph.get(c).forEach(_function);
      visited.add(c);
      while ((!Objects.equal(queue.peek(), null))) {
        {
          final Entity node = queue.poll();
          boolean foundConnnection = false;
          List<Map.Entry<Entity, TerminologyBoxStatement>> _get = graph.get(node);
          for (final Map.Entry<Entity, TerminologyBoxStatement> e : _get) {
            {
              final Entity n = e.getKey();
              final TerminologyBoxStatement relOrAx = e.getValue();
              if ((((relOrAx instanceof EntityRelationship) || (relOrAx instanceof EntityRestrictionAxiom)) && (n instanceof Concept))) {
                relationships.add(relOrAx);
                visited.add(n);
                foundConnnection = true;
              } else {
                if (foundConnnection) {
                  visited.add(n);
                } else {
                  if (((!((relOrAx instanceof EntityRelationship) || (relOrAx instanceof EntityRestrictionAxiom))) && (n instanceof Concept))) {
                    visited.add(n);
                  } else {
                    boolean _contains = visited.contains(n);
                    boolean _not = (!_contains);
                    if (_not) {
                      visited.add(n);
                      queue.add(n);
                    }
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = relationships;
    }
    return _xblockexpression;
  }
  
  private Map<Entity, List<Map.Entry<Entity, TerminologyBoxStatement>>> buildEntityGraph(final Entity c) {
    HashMap<Entity, List<Map.Entry<Entity, TerminologyBoxStatement>>> _xblockexpression = null;
    {
      final HashMap<Entity, List<Map.Entry<Entity, TerminologyBoxStatement>>> graph = new HashMap<Entity, List<Map.Entry<Entity, TerminologyBoxStatement>>>();
      final Consumer<TerminologyBoxStatement> _function = (TerminologyBoxStatement relOrAx) -> {
        final Map.Entry<Entity, Entity> entry = this.getSourceAndTarget(relOrAx);
        boolean _notEquals = (!Objects.equal(entry, null));
        if (_notEquals) {
          final Entity source = entry.getKey();
          final Entity target = entry.getValue();
          boolean _containsKey = graph.containsKey(source);
          if (_containsKey) {
            final AbstractMap.SimpleEntry<Entity, TerminologyBoxStatement> pair = new AbstractMap.SimpleEntry<Entity, TerminologyBoxStatement>(target, relOrAx);
            graph.get(source).add(pair);
          } else {
            final ArrayList<Map.Entry<Entity, TerminologyBoxStatement>> list = new ArrayList<Map.Entry<Entity, TerminologyBoxStatement>>();
            AbstractMap.SimpleEntry<Entity, TerminologyBoxStatement> _simpleEntry = new AbstractMap.SimpleEntry<Entity, TerminologyBoxStatement>(target, relOrAx);
            list.add(_simpleEntry);
            graph.put(source, list);
          }
          boolean _containsKey_1 = graph.containsKey(target);
          if (_containsKey_1) {
            final AbstractMap.SimpleEntry<Entity, TerminologyBoxStatement> pair2 = new AbstractMap.SimpleEntry<Entity, TerminologyBoxStatement>(source, relOrAx);
            graph.get(target).add(pair2);
          } else {
            final ArrayList<Map.Entry<Entity, TerminologyBoxStatement>> list_1 = new ArrayList<Map.Entry<Entity, TerminologyBoxStatement>>();
            AbstractMap.SimpleEntry<Entity, TerminologyBoxStatement> _simpleEntry_1 = new AbstractMap.SimpleEntry<Entity, TerminologyBoxStatement>(source, relOrAx);
            list_1.add(_simpleEntry_1);
            graph.put(target, list_1);
          }
        }
      };
      c.getTbox().getBoxStatements().forEach(_function);
      _xblockexpression = graph;
    }
    return _xblockexpression;
  }
  
  private Map.Entry<Entity, Entity> getSourceAndTarget(final TerminologyBoxStatement t) {
    Object _xblockexpression = null;
    {
      if ((t instanceof EntityRestrictionAxiom)) {
        final Entity n1 = ((EntityRestrictionAxiom) t).getRestrictedRange();
        final Entity n2 = ((EntityRestrictionAxiom) t).getRestrictedDomain();
        return new AbstractMap.SimpleEntry<Entity, Entity>(n1, n2);
      } else {
        if ((t instanceof SpecializationAxiom)) {
          final Entity n1_1 = ((SpecializationAxiom) t).child();
          final Entity n2_1 = ((SpecializationAxiom) t).parent();
          return new AbstractMap.SimpleEntry<Entity, Entity>(n1_1, n2_1);
        } else {
          if ((t instanceof EntityRelationship)) {
            final Entity n1_2 = ((EntityRelationship) t).getSource();
            final Entity n2_2 = ((EntityRelationship) t).getTarget();
            return new AbstractMap.SimpleEntry<Entity, Entity>(n1_2, n2_2);
          }
        }
      }
      _xblockexpression = null;
    }
    return ((Map.Entry<Entity, Entity>)_xblockexpression);
  }
}
