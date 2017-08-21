package gov.nasa.jpl.imce.oml.viewpoint;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DiagramUtil {
  /**
   * Returns a set of {@link EntityStructuredDataProperty}s that have the passed
   * {@link Concept} as its domain
   * 
   * @param The Concept
   * @return Set of {@link EntityStructuredDataProperty}
   */
  public Set<EntityStructuredDataProperty> getContainedEntityStructuredDataProperties(final Entity c) {
    final Function1<EntityStructuredDataProperty, Boolean> _function = (EntityStructuredDataProperty f) -> {
      Entity _domain = f.getDomain();
      return Boolean.valueOf(Objects.equal(_domain, c));
    };
    return IterableExtensions.<EntityStructuredDataProperty>toSet(IterableExtensions.<EntityStructuredDataProperty>filter(Iterables.<EntityStructuredDataProperty>filter(c.getTbox().getBoxStatements(), EntityStructuredDataProperty.class), _function));
  }
  
  /**
   * Returns a set of {@link EntityScalarDataProperty}s that have the passed
   * {@link Concept} as its domain
   * 
   * @param The Concept
   * @return Set of {@link EntityScalarDataProperty}
   */
  public Set<EntityScalarDataProperty> getContainedEntityScalarDataProperties(final Entity c) {
    final Function1<EntityScalarDataProperty, Boolean> _function = (EntityScalarDataProperty f) -> {
      Entity _domain = f.getDomain();
      return Boolean.valueOf(Objects.equal(_domain, c));
    };
    return IterableExtensions.<EntityScalarDataProperty>toSet(IterableExtensions.<EntityScalarDataProperty>filter(Iterables.<EntityScalarDataProperty>filter(c.getTbox().getBoxStatements(), EntityScalarDataProperty.class), _function));
  }
}
