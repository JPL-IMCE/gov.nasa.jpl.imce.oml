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
import gov.nasa.jpl.imce.oml.model.common.LiteralNumber;
import gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
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
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
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
      EList<TerminologyBoxStatement> _boxStatements = null;
      if (tg!=null) {
        _boxStatements=tg.getBoxStatements();
      }
      for (final TerminologyBoxStatement statement : _boxStatements) {
        boolean _matched = false;
        if (statement instanceof EntityRelationship) {
          _matched=true;
          entities.add(((EntityRelationship)statement).getSource());
          entities.add(((EntityRelationship)statement).getTarget());
        }
        if (!_matched) {
          if (statement instanceof SpecializationAxiom) {
            _matched=true;
            entities.add(((SpecializationAxiom)statement).child());
            entities.add(((SpecializationAxiom)statement).parent());
          }
        }
        if (!_matched) {
          if (statement instanceof Entity) {
            _matched=true;
            entities.add(((Entity)statement));
          }
        }
      }
      _xblockexpression = entities;
    }
    return _xblockexpression;
  }
  
  /**
   * Returns a set of {@link ScalarDataProperty}s that have the passed
   * {@link Structure} as its domain that are found
   * in the transitive closure of imports from the {@link TeminologyBox} associated
   * with the passed {@link Structure}.
   * 
   * 
   * @param The Structure
   * @return Set of {@link ScalarDataProperty}
   */
  public Set<ScalarDataProperty> getContainedScalarDataProperties(final Structure c) {
    Set<ScalarDataProperty> _xblockexpression = null;
    {
      TerminologyBox _tbox = null;
      if (c!=null) {
        _tbox=c.getTbox();
      }
      EList<TerminologyBoxStatement> _boxStatements = null;
      if (_tbox!=null) {
        _boxStatements=_tbox.getBoxStatements();
      }
      Iterable<ScalarDataProperty> _filter = null;
      if (_boxStatements!=null) {
        _filter=Iterables.<ScalarDataProperty>filter(_boxStatements, ScalarDataProperty.class);
      }
      Set<ScalarDataProperty> _set = null;
      if (_filter!=null) {
        _set=IterableExtensions.<ScalarDataProperty>toSet(_filter);
      }
      final Set<ScalarDataProperty> set = _set;
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<ScalarDataProperty, Boolean> _function = (ScalarDataProperty f) -> {
        Structure _domain = f.getDomain();
        return Boolean.valueOf(Objects.equal(_domain, c));
      };
      _xblockexpression = IterableExtensions.<ScalarDataProperty>toSet(IterableExtensions.<ScalarDataProperty>filter(IterableExtensions.<ScalarDataProperty>filterNull(set), _function));
    }
    return _xblockexpression;
  }
  
  /**
   * Returns a set of {@link StructuredDataProperty}s that have the passed
   * {@link Structure} as its domain that are found
   * in the transitive closure of imports from the {@link TeminologyBox} associated
   * with the passed {@link Structure}.
   * 
   * @param The Structure
   * @return Set of {@link StucturedDataProperty}
   */
  public Set<StructuredDataProperty> getContainedStructuredDataProperties(final Structure c) {
    Set<StructuredDataProperty> _xblockexpression = null;
    {
      TerminologyBox _tbox = null;
      if (c!=null) {
        _tbox=c.getTbox();
      }
      EList<TerminologyBoxStatement> _boxStatements = null;
      if (_tbox!=null) {
        _boxStatements=_tbox.getBoxStatements();
      }
      Iterable<StructuredDataProperty> _filter = null;
      if (_boxStatements!=null) {
        _filter=Iterables.<StructuredDataProperty>filter(_boxStatements, StructuredDataProperty.class);
      }
      Set<StructuredDataProperty> _set = null;
      if (_filter!=null) {
        _set=IterableExtensions.<StructuredDataProperty>toSet(_filter);
      }
      final Set<StructuredDataProperty> set = _set;
      boolean _isEmpty = set.isEmpty();
      if (_isEmpty) {
        return set;
      }
      final Function1<StructuredDataProperty, Boolean> _function = (StructuredDataProperty f) -> {
        Structure _domain = f.getDomain();
        return Boolean.valueOf(Objects.equal(_domain, c));
      };
      _xblockexpression = IterableExtensions.<StructuredDataProperty>toSet(IterableExtensions.<StructuredDataProperty>filter(IterableExtensions.<StructuredDataProperty>filterNull(set), _function));
    }
    return _xblockexpression;
  }
  
  /**
   * Returns a set of {@link StringScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link StringScalarRestriction}
   */
  public Set<StringScalarRestriction> getContainedStringScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<StringScalarRestriction>toSet(Iterables.<StringScalarRestriction>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(c.getBoxStatements()), StringScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link NumericScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link NumericScalarRestriction}
   */
  public Set<NumericScalarRestriction> getContainedNumericScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<NumericScalarRestriction>toSet(Iterables.<NumericScalarRestriction>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(c.getBoxStatements()), NumericScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link BinaryScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link NumericScalarRestriction}
   */
  public Set<BinaryScalarRestriction> getContainedBinaryScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<BinaryScalarRestriction>toSet(Iterables.<BinaryScalarRestriction>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(c.getBoxStatements()), BinaryScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link IRIScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar
   * @return Set of {@link IRIScalarRestriction}
   */
  public Set<IRIScalarRestriction> getContainedIRIScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<IRIScalarRestriction>toSet(Iterables.<IRIScalarRestriction>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(c.getBoxStatements()), IRIScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link PlainLiteralScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link PlainLiteralScalarRestriction}
   */
  public Set<PlainLiteralScalarRestriction> getContainedPlainLiteralScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<PlainLiteralScalarRestriction>toSet(Iterables.<PlainLiteralScalarRestriction>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(c.getBoxStatements()), PlainLiteralScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link TimeScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link TimeScalarRestriction}
   */
  public Set<TimeScalarRestriction> getContainedTimeScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<TimeScalarRestriction>toSet(Iterables.<TimeScalarRestriction>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(c.getBoxStatements()), TimeScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link SynonymScalarRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link SynonymScalarRestriction}
   */
  public Set<SynonymScalarRestriction> getContainedSynonymScalarRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<SynonymScalarRestriction>toSet(Iterables.<SynonymScalarRestriction>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(c.getBoxStatements()), SynonymScalarRestriction.class));
  }
  
  /**
   * Returns a set of {@link ScalarOneOfRestriction}s that have the passed
   * {@link Scalar} as its domain
   * 
   * @param The Scalar}
   * @return Set of {@link ScalarOneOfRestriction}
   */
  public Set<ScalarOneOfRestriction> getContainedScalarOneOfRestrictions(final TerminologyGraph c) {
    return IterableExtensions.<ScalarOneOfRestriction>toSet(Iterables.<ScalarOneOfRestriction>filter(IterableExtensions.<TerminologyBoxStatement>filterNull(c.getBoxStatements()), ScalarOneOfRestriction.class));
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
      boolean _matched = false;
      if (r instanceof StringScalarRestriction) {
        _matched=true;
        PatternValue _pattern = ((StringScalarRestriction)r).getPattern();
        String _plus = ("\npattern: " + _pattern);
        label.append(_plus);
      }
      if (!_matched) {
        if (r instanceof IRIScalarRestriction) {
          _matched=true;
          PatternValue _pattern = ((IRIScalarRestriction)r).getPattern();
          String _plus = ("\npattern: " + _pattern);
          label.append(_plus);
        }
      }
      if (!_matched) {
        if (r instanceof PlainLiteralScalarRestriction) {
          _matched=true;
          PatternValue _pattern = ((PlainLiteralScalarRestriction)r).getPattern();
          String _plus = ("\npattern: " + _pattern);
          label.append(_plus);
          LanguageTagValue _langRange = ((PlainLiteralScalarRestriction)r).getLangRange();
          String _plus_1 = ("\nlangRange: " + _langRange);
          label.append(_plus_1);
        }
      }
      if (!_matched) {
        if (r instanceof NumericScalarRestriction) {
          _matched=true;
          LiteralNumber _minInclusive = ((NumericScalarRestriction)r).getMinInclusive();
          boolean _tripleNotEquals = (_minInclusive != null);
          if (_tripleNotEquals) {
            LiteralNumber _minInclusive_1 = ((NumericScalarRestriction)r).getMinInclusive();
            String _plus = ("\n\nminInclusive: " + _minInclusive_1);
            label.append(_plus);
          }
          LiteralNumber _maxInclusive = ((NumericScalarRestriction)r).getMaxInclusive();
          boolean _tripleNotEquals_1 = (_maxInclusive != null);
          if (_tripleNotEquals_1) {
            LiteralNumber _maxInclusive_1 = ((NumericScalarRestriction)r).getMaxInclusive();
            String _plus_1 = ("\nmaxInclusive: " + _maxInclusive_1);
            label.append(_plus_1);
          }
          LiteralNumber _minExclusive = ((NumericScalarRestriction)r).getMinExclusive();
          boolean _tripleNotEquals_2 = (_minExclusive != null);
          if (_tripleNotEquals_2) {
            LiteralNumber _minExclusive_1 = ((NumericScalarRestriction)r).getMinExclusive();
            String _plus_2 = ("\nminExclusive: " + _minExclusive_1);
            label.append(_plus_2);
          }
          LiteralNumber _maxExclusive = ((NumericScalarRestriction)r).getMaxExclusive();
          boolean _tripleNotEquals_3 = (_maxExclusive != null);
          if (_tripleNotEquals_3) {
            LiteralNumber _maxExclusive_1 = ((NumericScalarRestriction)r).getMaxExclusive();
            String _plus_3 = ("\nmaxExclusive: " + _maxExclusive_1);
            label.append(_plus_3);
          }
        }
      }
      _xblockexpression = label.toString();
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
