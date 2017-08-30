package gov.nasa.jpl.imce.oml.viewpoint;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.scoping.OMLScopeExtensions;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DiagramUtil {
  @Inject
  @Extension
  private OMLScopeExtensions _oMLScopeExtensions;
  
  /**
   * Returns a set of {@link EntityStructuredDataProperty}s that have the passed
   * {@link Concept} as its domain
   * 
   * @param The Concept
   * @return Set of {@link EntityStructuredDataProperty}
   */
  public Set<EntityStructuredDataProperty> getContainedEntityStructuredDataProperties(final Entity c) {
    Set<EntityStructuredDataProperty> _xblockexpression = null;
    {
      final Set<EntityStructuredDataProperty> set = IterableExtensions.<EntityStructuredDataProperty>toSet(Iterables.<EntityStructuredDataProperty>filter(c.getTbox().getBoxStatements(), EntityStructuredDataProperty.class));
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<EntityStructuredDataProperty, Boolean> _function = (EntityStructuredDataProperty f) -> {
        Term _relationDomain = f.relationDomain();
        return Boolean.valueOf(Objects.equal(_relationDomain, c));
      };
      _xblockexpression = IterableExtensions.<EntityStructuredDataProperty>toSet(IterableExtensions.<EntityStructuredDataProperty>filter(set, _function));
    }
    return _xblockexpression;
  }
  
  /**
   * Returns a set of {@link EntityScalarDataProperty}s that have the passed
   * {@link Concept} as its domain
   * 
   * @param The Concept
   * @return Set of {@link EntityScalarDataProperty}
   */
  public Set<EntityScalarDataProperty> getContainedEntityScalarDataProperties(final Entity c) {
    Set<EntityScalarDataProperty> _xblockexpression = null;
    {
      final Set<EntityScalarDataProperty> set = IterableExtensions.<EntityScalarDataProperty>toSet(Iterables.<EntityScalarDataProperty>filter(c.getTbox().getBoxStatements(), EntityScalarDataProperty.class));
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<EntityScalarDataProperty, Boolean> _function = (EntityScalarDataProperty f) -> {
        Term _relationDomain = f.relationDomain();
        return Boolean.valueOf(Objects.equal(_relationDomain, c));
      };
      _xblockexpression = IterableExtensions.<EntityScalarDataProperty>toSet(IterableExtensions.<EntityScalarDataProperty>filter(set, _function));
    }
    return _xblockexpression;
  }
}
