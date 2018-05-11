package gov.nasa.jpl.imce.oml.viewpoint;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DiagramUtil {
  /**
   * Returns a set of {@link EntityStructuredDataProperty}s such that each {@link EntityStructuredDataProperty} [p]
   * has as its domain the {@link Entity} [e] as its domain and [p] is declared either directly in the same
   * {@link TerminologyBox} as [e] or in some other {@link TerminologyBox} imported from it.
   * 
   * @param The Entity
   * @return Set of {@link EntityStructuredDataProperty}
   */
  public Set<EntityStructuredDataProperty> getContainedEntityStructuredDataProperties(final Entity e) {
    Set<EntityStructuredDataProperty> _xblockexpression = null;
    {
      TerminologyBox _tbox = e.getTbox();
      boolean _tripleEquals = (_tbox == null);
      if (_tripleEquals) {
        return new HashSet<EntityStructuredDataProperty>();
      }
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      final Function1<EntityStructuredDataProperty, Boolean> _function_1 = (EntityStructuredDataProperty f) -> {
        Term _relationDomain = f.relationDomain();
        return Boolean.valueOf(Objects.equal(_relationDomain, e));
      };
      _xblockexpression = IterableExtensions.<EntityStructuredDataProperty>toSet(IterableExtensions.<EntityStructuredDataProperty>filter(Iterables.<EntityStructuredDataProperty>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(OMLExtensions.allImportedTerminologies(e.getTbox()), _function))), EntityStructuredDataProperty.class), _function_1));
    }
    return _xblockexpression;
  }
  
  /**
   * Returns a set of {@link EntityScalarDataProperty}s in this {@link TerminologyBox}
   * that have the passed {@link Entity} as its domain
   * 
   * @param The Entity
   * @return Set of {@link EntityScalarDataProperty}
   */
  public Set<EntityScalarDataProperty> getContainedEntityScalarDataProperties(final Entity e) {
    Set<EntityScalarDataProperty> _xblockexpression = null;
    {
      TerminologyBox _tbox = e.getTbox();
      boolean _tripleEquals = (_tbox == null);
      if (_tripleEquals) {
        return new HashSet<EntityScalarDataProperty>();
      }
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      final Function1<EntityScalarDataProperty, Boolean> _function_1 = (EntityScalarDataProperty f) -> {
        Term _relationDomain = f.relationDomain();
        return Boolean.valueOf(Objects.equal(_relationDomain, e));
      };
      _xblockexpression = IterableExtensions.<EntityScalarDataProperty>toSet(IterableExtensions.<EntityScalarDataProperty>filter(Iterables.<EntityScalarDataProperty>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(OMLExtensions.allImportedTerminologies(e.getTbox()), _function))), EntityScalarDataProperty.class), _function_1));
    }
    return _xblockexpression;
  }
}
