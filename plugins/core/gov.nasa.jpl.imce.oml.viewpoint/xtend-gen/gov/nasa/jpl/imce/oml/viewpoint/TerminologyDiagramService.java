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
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange;
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
 * Used to query for visual elements in the "Terminology Diagram"
 * 
 * The "Terminology Diagram" will show all {@link Entity}s and
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
  public Set<StringScalarRestriction> getContainedStringScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<StringScalarRestriction>toSet(Iterables.<StringScalarRestriction>filter(c.getBoxStatements(), StringScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link NumericScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link NumericScalarRestriction}
   */
  public Set<NumericScalarRestriction> getContainedNumericScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<NumericScalarRestriction>toSet(Iterables.<NumericScalarRestriction>filter(c.getBoxStatements(), NumericScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link BinaryScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link NumericScalarRestriction}
   */
  public Set<BinaryScalarRestriction> getContainedBinaryScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<BinaryScalarRestriction>toSet(Iterables.<BinaryScalarRestriction>filter(c.getBoxStatements(), BinaryScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link IRIScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link IRIScalarRestriction}
   */
  public Set<IRIScalarRestriction> getContainedIRIScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<IRIScalarRestriction>toSet(Iterables.<IRIScalarRestriction>filter(c.getBoxStatements(), IRIScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link PlainLiteralScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link PlainLiteralScalarRestriction}
   */
  public Set<PlainLiteralScalarRestriction> getContainedPlainLiteralScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<PlainLiteralScalarRestriction>toSet(Iterables.<PlainLiteralScalarRestriction>filter(c.getBoxStatements(), PlainLiteralScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link TimeScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link TimeScalarRestriction}
   */
  public Set<TimeScalarRestriction> getContainedTimeScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<TimeScalarRestriction>toSet(Iterables.<TimeScalarRestriction>filter(c.getBoxStatements(), TimeScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link SynonymScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link SynonymScalarRestriction}
   */
  public Set<SynonymScalarRestriction> getContainedSynonymScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<SynonymScalarRestriction>toSet(Iterables.<SynonymScalarRestriction>filter(c.getBoxStatements(), SynonymScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link ScalarOneOfRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link ScalarOneOfRestriction}
   */
  public Set<ScalarOneOfRestriction> getContainedScalarOneOfRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<ScalarOneOfRestriction>toSet(Iterables.<ScalarOneOfRestriction>filter(c.getBoxStatements(), ScalarOneOfRestriction.class));
  }
  
  /**
   * Gets class name for a {@link RestrictedDataRange}
   * 
   * @return Name of implemented class
   */
  public String getRestrictedRangeLabel(final RestrictedDataRange r) {
    final String result = r.getClass().getSimpleName();
    int _length = result.length();
    int _minus = (_length - 4);
    return result.substring(0, _minus);
  }
  
  /**
   * Gets label for a {@link RestrictedDataRange} Node
   * 
   * @return String representation for Scalar Restriction
   */
  public String getDetailedLabel(final RestrictedDataRange r) {
    String _xblockexpression = null;
    {
      StringBuilder label = new StringBuilder();
      label.append(r.name());
      if ((r instanceof StringScalarRestriction)) {
        String _pattern = ((StringScalarRestriction) r).getPattern();
        String _plus = ("\npattern: " + _pattern);
        label.append(_plus);
      }
      if ((r instanceof IRIScalarRestriction)) {
        String _pattern_1 = ((IRIScalarRestriction) r).getPattern();
        String _plus_1 = ("\npattern: " + _pattern_1);
        label.append(_plus_1);
      }
      if ((r instanceof PlainLiteralScalarRestriction)) {
        String _pattern_2 = ((PlainLiteralScalarRestriction) r).getPattern();
        String _plus_2 = ("\npattern: " + _pattern_2);
        label.append(_plus_2);
        String _langRange = ((PlainLiteralScalarRestriction) r).getLangRange();
        String _plus_3 = ("\nlangRange: " + _langRange);
        label.append(_plus_3);
      }
      if ((r instanceof NumericScalarRestriction)) {
        String _minInclusive = ((NumericScalarRestriction) r).getMinInclusive();
        boolean _tripleNotEquals = (_minInclusive != null);
        if (_tripleNotEquals) {
          String _minInclusive_1 = ((NumericScalarRestriction) r).getMinInclusive();
          String _plus_4 = ("\n\nminInclusive: " + _minInclusive_1);
          label.append(_plus_4);
        }
        String _maxInclusive = ((NumericScalarRestriction) r).getMaxInclusive();
        boolean _tripleNotEquals_1 = (_maxInclusive != null);
        if (_tripleNotEquals_1) {
          String _maxInclusive_1 = ((NumericScalarRestriction) r).getMaxInclusive();
          String _plus_5 = ("\nmaxInclusive: " + _maxInclusive_1);
          label.append(_plus_5);
        }
        String _minExclusive = ((NumericScalarRestriction) r).getMinExclusive();
        boolean _tripleNotEquals_2 = (_minExclusive != null);
        if (_tripleNotEquals_2) {
          String _minExclusive_1 = ((NumericScalarRestriction) r).getMinExclusive();
          String _plus_6 = ("\nminExclusive: " + _minExclusive_1);
          label.append(_plus_6);
        }
        String _maxExclusive = ((NumericScalarRestriction) r).getMaxExclusive();
        boolean _tripleNotEquals_3 = (_maxExclusive != null);
        if (_tripleNotEquals_3) {
          String _maxExclusive_1 = ((NumericScalarRestriction) r).getMaxExclusive();
          String _plus_7 = ("\nmaxExclusive: " + _maxExclusive_1);
          label.append(_plus_7);
        }
      }
      if ((r instanceof BinaryScalarRestriction)) {
        int _minLength = ((BinaryScalarRestriction) r).getMinLength();
        String _plus_8 = ("\n\nnmaxLength: " + Integer.valueOf(_minLength));
        String _plus_9 = (_plus_8 + "\nmaxLength: ");
        int _maxLength = ((BinaryScalarRestriction) r).getMaxLength();
        String _plus_10 = (_plus_9 + Integer.valueOf(_maxLength));
        label.append(_plus_10);
      }
      if ((r instanceof TimeScalarRestriction)) {
        String _minInclusive_2 = ((TimeScalarRestriction) r).getMinInclusive();
        boolean _tripleNotEquals_4 = (_minInclusive_2 != null);
        if (_tripleNotEquals_4) {
          String _minInclusive_3 = ((TimeScalarRestriction) r).getMinInclusive();
          String _plus_11 = ("\n\nminInclusive: " + _minInclusive_3);
          label.append(_plus_11);
        }
        String _maxInclusive_2 = ((TimeScalarRestriction) r).getMaxInclusive();
        boolean _tripleNotEquals_5 = (_maxInclusive_2 != null);
        if (_tripleNotEquals_5) {
          String _maxInclusive_3 = ((TimeScalarRestriction) r).getMaxInclusive();
          String _plus_12 = ("\nmaxInclusive: " + _maxInclusive_3);
          label.append(_plus_12);
        }
        String _minExclusive_2 = ((TimeScalarRestriction) r).getMinExclusive();
        boolean _tripleNotEquals_6 = (_minExclusive_2 != null);
        if (_tripleNotEquals_6) {
          String _minExclusive_3 = ((TimeScalarRestriction) r).getMinExclusive();
          String _plus_13 = ("\nminExclusive: " + _minExclusive_3);
          label.append(_plus_13);
        }
        String _maxExclusive_2 = ((TimeScalarRestriction) r).getMaxExclusive();
        boolean _tripleNotEquals_7 = (_maxExclusive_2 != null);
        if (_tripleNotEquals_7) {
          String _maxExclusive_3 = ((TimeScalarRestriction) r).getMaxExclusive();
          String _plus_14 = ("\nmaxExclusive: " + _maxExclusive_3);
          label.append(_plus_14);
        }
      }
      _xblockexpression = label.toString();
    }
    return _xblockexpression;
  }
}
