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
    final Function1<EntityStructuredDataProperty, Boolean> _function = (EntityStructuredDataProperty f) -> {
      Term _relationDomain = f.relationDomain();
      return Boolean.valueOf(Objects.equal(_relationDomain, c));
    };
    return IterableExtensions.<EntityStructuredDataProperty>toSet(IterableExtensions.<EntityStructuredDataProperty>filter(Iterables.<EntityStructuredDataProperty>filter(this._oMLScopeExtensions.allEntityStructuredDataPropertiesScope(c.getTbox()).getAllElements(), EntityStructuredDataProperty.class), _function));
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
      Term _relationDomain = f.relationDomain();
      return Boolean.valueOf(Objects.equal(_relationDomain, c));
    };
    return IterableExtensions.<EntityScalarDataProperty>toSet(IterableExtensions.<EntityScalarDataProperty>filter(Iterables.<EntityScalarDataProperty>filter(c.getTbox().getBoxStatements(), EntityScalarDataProperty.class), _function));
  }
}
