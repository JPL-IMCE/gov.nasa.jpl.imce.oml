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
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Used to query for visual elements in the 'Terminology Diagram'
 * 
 * The 'Terminology Diagram' will show all {@link Entity}s and
 * {@link SpecializationAxiom}s for a given {@link TerminologyGraph}
 * 
 * 
 * Containers: Concept, Aspect, Structure, Scalar
 * Edges: Reified/UnReified Relationships, Restriction/Specialization Axioms
 */
@SuppressWarnings("all")
public class TerminologyDiagramService {
  /**
   * Get all visual entities for the {@link TerminologyGraph}
   */
  public Set<Entity> getVisualEntities(final TerminologyGraph tg) {
    LinkedHashSet<Entity> _xblockexpression = null;
    {
      final LinkedHashSet<Entity> entities = new LinkedHashSet<Entity>();
      EList<TerminologyBoxStatement> _boxStatements = tg.getBoxStatements();
      for (final TerminologyBoxStatement statement : _boxStatements) {
        {
          if ((statement instanceof Entity)) {
            entities.add(((Entity) statement));
          }
          if ((statement instanceof SpecializationAxiom)) {
            final SpecializationAxiom temp = ((SpecializationAxiom) statement);
            entities.add(temp.child());
            entities.add(temp.parent());
          }
        }
      }
      _xblockexpression = entities;
    }
    return _xblockexpression;
  }
  
  /**
   * Returns a set of {@link ScalarDataProperty}s that have the passed
   * {@link Structure} as its domain
   * 
   * @param The Structure
   * @return Set of {@link ScalarDataProperty}
   */
  public Set<ScalarDataProperty> getContainedScalarDataProperties(final Structure c) {
    final Function1<ScalarDataProperty, Boolean> _function = (ScalarDataProperty f) -> {
      Structure _domain = f.getDomain();
      return Boolean.valueOf(Objects.equal(_domain, c));
    };
    return IterableExtensions.<ScalarDataProperty>toSet(IterableExtensions.<ScalarDataProperty>filter(Iterables.<ScalarDataProperty>filter(c.getTbox().getBoxStatements(), ScalarDataProperty.class), _function));
  }
  
  /**
   * Returns a set of {@link StructuredDataProperty}s that have the passed
   * {@link Structure} as its domain
   * 
   * @param The Structure
   * @return Set of {@link StucturedDataProperty}
   */
  public Set<StructuredDataProperty> getContainedStructuredDataProperties(final Structure c) {
    final Function1<StructuredDataProperty, Boolean> _function = (StructuredDataProperty f) -> {
      Structure _domain = f.getDomain();
      return Boolean.valueOf(Objects.equal(_domain, c));
    };
    return IterableExtensions.<StructuredDataProperty>toSet(IterableExtensions.<StructuredDataProperty>filter(Iterables.<StructuredDataProperty>filter(c.getTbox().getBoxStatements(), StructuredDataProperty.class), _function));
  }
  
  /**
   * Returns a set of {@link StringScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link StringScalarRestriction}
   */
  public Set<StringScalarRestriction> getContainedStringScalarRestrictions(final Scalar c) {
    final Function1<StringScalarRestriction, Boolean> _function = (StringScalarRestriction f) -> {
      DataRange _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<StringScalarRestriction>toSet(IterableExtensions.<StringScalarRestriction>filter(Iterables.<StringScalarRestriction>filter(c.getTbox().getBoxStatements(), StringScalarRestriction.class), _function));
  }
  
  /**
   * Returns a set of {@link NumericScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link NumericScalarRestriction}
   */
  public Set<NumericScalarRestriction> getContainedNumericScalarRestrictions(final Scalar c) {
    final Function1<NumericScalarRestriction, Boolean> _function = (NumericScalarRestriction f) -> {
      DataRange _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<NumericScalarRestriction>toSet(IterableExtensions.<NumericScalarRestriction>filter(Iterables.<NumericScalarRestriction>filter(c.getTbox().getBoxStatements(), NumericScalarRestriction.class), _function));
  }
  
  /**
   * Returns a set of {@link BinaryScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link NumericScalarRestriction}
   */
  public Set<BinaryScalarRestriction> getContainedBinaryScalarRestrictions(final Scalar c) {
    final Function1<BinaryScalarRestriction, Boolean> _function = (BinaryScalarRestriction f) -> {
      DataRange _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<BinaryScalarRestriction>toSet(IterableExtensions.<BinaryScalarRestriction>filter(Iterables.<BinaryScalarRestriction>filter(c.getTbox().getBoxStatements(), BinaryScalarRestriction.class), _function));
  }
  
  /**
   * Returns a set of {@link IRIScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link IRIScalarRestriction}
   */
  public Set<IRIScalarRestriction> getContainedIRIScalarRestrictions(final Scalar c) {
    final Function1<IRIScalarRestriction, Boolean> _function = (IRIScalarRestriction f) -> {
      DataRange _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<IRIScalarRestriction>toSet(IterableExtensions.<IRIScalarRestriction>filter(Iterables.<IRIScalarRestriction>filter(c.getTbox().getBoxStatements(), IRIScalarRestriction.class), _function));
  }
  
  /**
   * Returns a set of {@link PlainLiteralScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link PlainLiteralScalarRestriction}
   */
  public Set<PlainLiteralScalarRestriction> getContainedPlainLiteralScalarRestrictions(final Scalar c) {
    final Function1<PlainLiteralScalarRestriction, Boolean> _function = (PlainLiteralScalarRestriction f) -> {
      DataRange _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<PlainLiteralScalarRestriction>toSet(IterableExtensions.<PlainLiteralScalarRestriction>filter(Iterables.<PlainLiteralScalarRestriction>filter(c.getTbox().getBoxStatements(), PlainLiteralScalarRestriction.class), _function));
  }
  
  /**
   * Returns a set of {@link TimeScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link TimeScalarRestriction}
   */
  public Set<TimeScalarRestriction> getContainedTimeScalarRestrictions(final Scalar c) {
    final Function1<TimeScalarRestriction, Boolean> _function = (TimeScalarRestriction f) -> {
      DataRange _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<TimeScalarRestriction>toSet(IterableExtensions.<TimeScalarRestriction>filter(Iterables.<TimeScalarRestriction>filter(c.getTbox().getBoxStatements(), TimeScalarRestriction.class), _function));
  }
  
  /**
   * Returns a set of {@link SynonymScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link SynonymScalarRestriction}
   */
  public Set<SynonymScalarRestriction> getContainedSynonymScalarRestrictions(final Scalar c) {
    final Function1<SynonymScalarRestriction, Boolean> _function = (SynonymScalarRestriction f) -> {
      DataRange _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<SynonymScalarRestriction>toSet(IterableExtensions.<SynonymScalarRestriction>filter(Iterables.<SynonymScalarRestriction>filter(c.getTbox().getBoxStatements(), SynonymScalarRestriction.class), _function));
  }
  
  /**
   * Returns a set of {@link ScalarOneOfRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link ScalarOneOfRestriction}
   */
  public Set<ScalarOneOfRestriction> getContainedScalarOneOfRestrictions(final Scalar c) {
    final Function1<ScalarOneOfRestriction, Boolean> _function = (ScalarOneOfRestriction f) -> {
      DataRange _restrictedRange = f.getRestrictedRange();
      return Boolean.valueOf(Objects.equal(_restrictedRange, c));
    };
    return IterableExtensions.<ScalarOneOfRestriction>toSet(IterableExtensions.<ScalarOneOfRestriction>filter(Iterables.<ScalarOneOfRestriction>filter(c.getTbox().getBoxStatements(), ScalarOneOfRestriction.class), _function));
  }
}
