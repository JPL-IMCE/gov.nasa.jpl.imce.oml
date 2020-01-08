/**
 * Copyright 2016 California Institute of Technology ("Caltech").
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
package gov.nasa.jpl.imce.oml.model.extensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LiteralBoolean;
import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime;
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal;
import gov.nasa.jpl.imce.oml.model.common.LiteralFloat;
import gov.nasa.jpl.imce.oml.model.common.LiteralNumber;
import gov.nasa.jpl.imce.oml.model.common.LiteralRational;
import gov.nasa.jpl.imce.oml.model.common.LiteralRawString;
import gov.nasa.jpl.imce.oml.model.common.LiteralReal;
import gov.nasa.jpl.imce.oml.model.common.LiteralString;
import gov.nasa.jpl.imce.oml.model.common.LiteralURI;
import gov.nasa.jpl.imce.oml.model.common.LiteralUUID;
import gov.nasa.jpl.imce.oml.model.common.LiteralValue;
import gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue;
import gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue;
import gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue;
import gov.nasa.jpl.imce.oml.model.datatypes.FloatValue;
import gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;
import gov.nasa.jpl.imce.oml.model.datatypes.RationalValue;
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue;
import gov.nasa.jpl.imce.oml.model.datatypes.RealValue;
import gov.nasa.jpl.imce.oml.model.datatypes.URIValue;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipEnumerationRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipExistentialRangeRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipUniversalRangeRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipValueRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedAspect;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedConcept;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictionKind;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Predicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * OMLTables is a collection of extension queries for OML Extent and conversion methods for OML values.
 * 
 * These queries are used in OMLSpecificationTables.save(Extent, ZipArchiveOutputStream).
 * The value conversion methods are used in several OMLSpecificationTables.read*(Stream<String>) methods.
 */
@SuppressWarnings("all")
public class OMLTables {
  public static <T extends CrossReferencabilityKind> Comparator<T> crossReferencabilityComparator() {
    return new Comparator<T>() {
      @Override
      public int compare(final T t1, final T t2) {
        return t1.uuid().compareTo(t2.uuid());
      }
    };
  }
  
  public static List<AnnotationProperty> annotationProperties(final Extent e) {
    List<AnnotationProperty> _xblockexpression = null;
    {
      final ArrayList<AnnotationProperty> result = new ArrayList<AnnotationProperty>();
      final Consumer<gov.nasa.jpl.imce.oml.model.common.Module> _function = (gov.nasa.jpl.imce.oml.model.common.Module m) -> {
        result.addAll(m.getAnnotationProperties());
      };
      e.getModules().forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<AnnotationProperty>crossReferencabilityComparator()).collect(Collectors.<AnnotationProperty>toList());
    }
    return _xblockexpression;
  }
  
  public static List<AnnotationPropertyValue> annotationPropertyValues(final Extent e) {
    List<AnnotationPropertyValue> _xblockexpression = null;
    {
      final List<AnnotationPropertyValue> result = new ArrayList<AnnotationPropertyValue>();
      Iterables.<AnnotationPropertyValue>addAll(result, IteratorExtensions.<AnnotationPropertyValue>toIterable(Iterators.<AnnotationPropertyValue>filter(e.eAllContents(), AnnotationPropertyValue.class)));
      _xblockexpression = result.parallelStream().sorted(OMLTables.<AnnotationPropertyValue>crossReferencabilityComparator()).collect(Collectors.<AnnotationPropertyValue>toList());
    }
    return _xblockexpression;
  }
  
  public static List<TerminologyGraph> terminologyGraphs(final Extent e) {
    List<TerminologyGraph> _xblockexpression = null;
    {
      final List<TerminologyGraph> result = new ArrayList<TerminologyGraph>();
      Iterables.<TerminologyGraph>addAll(result, Iterables.<TerminologyGraph>filter(e.getModules(), TerminologyGraph.class));
      _xblockexpression = result.parallelStream().sorted(OMLTables.<TerminologyGraph>crossReferencabilityComparator()).collect(Collectors.<TerminologyGraph>toList());
    }
    return _xblockexpression;
  }
  
  public static List<Bundle> bundles(final Extent e) {
    List<Bundle> _xblockexpression = null;
    {
      final List<Bundle> result = new ArrayList<Bundle>();
      Iterables.<Bundle>addAll(result, Iterables.<Bundle>filter(e.getModules(), Bundle.class));
      _xblockexpression = result.parallelStream().sorted(OMLTables.<Bundle>crossReferencabilityComparator()).collect(Collectors.<Bundle>toList());
    }
    return _xblockexpression;
  }
  
  public static List<DescriptionBox> descriptionBoxes(final Extent e) {
    List<DescriptionBox> _xblockexpression = null;
    {
      final List<DescriptionBox> result = new ArrayList<DescriptionBox>();
      Iterables.<DescriptionBox>addAll(result, Iterables.<DescriptionBox>filter(e.getModules(), DescriptionBox.class));
      _xblockexpression = result.parallelStream().sorted(OMLTables.<DescriptionBox>crossReferencabilityComparator()).collect(Collectors.<DescriptionBox>toList());
    }
    return _xblockexpression;
  }
  
  public static List<TerminologyBox> terminologies(final Extent e) {
    List<TerminologyBox> _xblockexpression = null;
    {
      final List<TerminologyBox> result = new ArrayList<TerminologyBox>();
      Iterables.<TerminologyBox>addAll(result, Iterables.<TerminologyBox>filter(e.getModules(), TerminologyBox.class));
      _xblockexpression = result.parallelStream().sorted(OMLTables.<TerminologyBox>crossReferencabilityComparator()).collect(Collectors.<TerminologyBox>toList());
    }
    return _xblockexpression;
  }
  
  public static List<TerminologyExtensionAxiom> terminologyExtensionAxioms(final Extent e) {
    List<TerminologyExtensionAxiom> _xblockexpression = null;
    {
      final List<TerminologyExtensionAxiom> result = new ArrayList<TerminologyExtensionAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<TerminologyExtensionAxiom>addAll(result, Iterables.<TerminologyExtensionAxiom>filter(tbox.getBoxAxioms(), TerminologyExtensionAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<TerminologyExtensionAxiom>crossReferencabilityComparator()).collect(Collectors.<TerminologyExtensionAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<TerminologyNestingAxiom> terminologyNestingAxioms(final Extent e) {
    List<TerminologyNestingAxiom> _xblockexpression = null;
    {
      final List<TerminologyNestingAxiom> result = new ArrayList<TerminologyNestingAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<TerminologyNestingAxiom>addAll(result, Iterables.<TerminologyNestingAxiom>filter(tbox.getBoxAxioms(), TerminologyNestingAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<TerminologyNestingAxiom>crossReferencabilityComparator()).collect(Collectors.<TerminologyNestingAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ConceptDesignationTerminologyAxiom> conceptDesignationTerminologyAxioms(final Extent e) {
    List<ConceptDesignationTerminologyAxiom> _xblockexpression = null;
    {
      final List<ConceptDesignationTerminologyAxiom> result = new ArrayList<ConceptDesignationTerminologyAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<ConceptDesignationTerminologyAxiom>addAll(result, Iterables.<ConceptDesignationTerminologyAxiom>filter(tbox.getBoxAxioms(), ConceptDesignationTerminologyAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ConceptDesignationTerminologyAxiom>crossReferencabilityComparator()).collect(Collectors.<ConceptDesignationTerminologyAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<BundledTerminologyAxiom> bundledTerminologyAxioms(final Extent e) {
    List<BundledTerminologyAxiom> _xblockexpression = null;
    {
      final List<BundledTerminologyAxiom> result = new ArrayList<BundledTerminologyAxiom>();
      final Consumer<Bundle> _function = (Bundle b) -> {
        Iterables.<BundledTerminologyAxiom>addAll(result, Iterables.<BundledTerminologyAxiom>filter(b.getBundleAxioms(), BundledTerminologyAxiom.class));
      };
      OMLTables.bundles(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<BundledTerminologyAxiom>crossReferencabilityComparator()).collect(Collectors.<BundledTerminologyAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<DescriptionBoxExtendsClosedWorldDefinitions> descriptionBoxExtendsClosedWorldDefinitions(final Extent e) {
    List<DescriptionBoxExtendsClosedWorldDefinitions> _xblockexpression = null;
    {
      final List<DescriptionBoxExtendsClosedWorldDefinitions> result = new ArrayList<DescriptionBoxExtendsClosedWorldDefinitions>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getClosedWorldDefinitions());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<DescriptionBoxExtendsClosedWorldDefinitions>crossReferencabilityComparator()).collect(Collectors.<DescriptionBoxExtendsClosedWorldDefinitions>toList());
    }
    return _xblockexpression;
  }
  
  public static List<DescriptionBoxRefinement> descriptionBoxRefinements(final Extent e) {
    List<DescriptionBoxRefinement> _xblockexpression = null;
    {
      final List<DescriptionBoxRefinement> result = new ArrayList<DescriptionBoxRefinement>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getDescriptionBoxRefinements());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<DescriptionBoxRefinement>crossReferencabilityComparator()).collect(Collectors.<DescriptionBoxRefinement>toList());
    }
    return _xblockexpression;
  }
  
  public static List<Aspect> aspects(final Extent e) {
    List<Aspect> _xblockexpression = null;
    {
      final List<Aspect> result = new ArrayList<Aspect>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<Aspect>addAll(result, Iterables.<Aspect>filter(tbox.getBoxStatements(), Aspect.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<Aspect>crossReferencabilityComparator()).collect(Collectors.<Aspect>toList());
    }
    return _xblockexpression;
  }
  
  public static List<CardinalityRestrictedAspect> cardinalityRestrictedAspects(final Extent e) {
    List<CardinalityRestrictedAspect> _xblockexpression = null;
    {
      final List<CardinalityRestrictedAspect> result = new ArrayList<CardinalityRestrictedAspect>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<CardinalityRestrictedAspect>addAll(result, Iterables.<CardinalityRestrictedAspect>filter(tbox.getBoxStatements(), CardinalityRestrictedAspect.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<CardinalityRestrictedAspect>crossReferencabilityComparator()).collect(Collectors.<CardinalityRestrictedAspect>toList());
    }
    return _xblockexpression;
  }
  
  public static List<Concept> concepts(final Extent e) {
    List<Concept> _xblockexpression = null;
    {
      final List<Concept> result = new ArrayList<Concept>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<Concept>addAll(result, Iterables.<Concept>filter(tbox.getBoxStatements(), Concept.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<Concept>crossReferencabilityComparator()).collect(Collectors.<Concept>toList());
    }
    return _xblockexpression;
  }
  
  public static List<CardinalityRestrictedConcept> cardinalityRestrictedConcepts(final Extent e) {
    List<CardinalityRestrictedConcept> _xblockexpression = null;
    {
      final List<CardinalityRestrictedConcept> result = new ArrayList<CardinalityRestrictedConcept>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<CardinalityRestrictedConcept>addAll(result, Iterables.<CardinalityRestrictedConcept>filter(tbox.getBoxStatements(), CardinalityRestrictedConcept.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<CardinalityRestrictedConcept>crossReferencabilityComparator()).collect(Collectors.<CardinalityRestrictedConcept>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipRestriction> reifiedRelationshipRestrictions(final Extent e) {
    List<ReifiedRelationshipRestriction> _xblockexpression = null;
    {
      final List<ReifiedRelationshipRestriction> result = new ArrayList<ReifiedRelationshipRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<ReifiedRelationshipRestriction>addAll(result, Iterables.<ReifiedRelationshipRestriction>filter(tbox.getBoxStatements(), ReifiedRelationshipRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ReifiedRelationshipRestriction>crossReferencabilityComparator()).collect(Collectors.<ReifiedRelationshipRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<CardinalityRestrictedReifiedRelationship> cardinalityRestrictedReifiedRelationships(final Extent e) {
    List<CardinalityRestrictedReifiedRelationship> _xblockexpression = null;
    {
      final List<CardinalityRestrictedReifiedRelationship> result = new ArrayList<CardinalityRestrictedReifiedRelationship>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<CardinalityRestrictedReifiedRelationship>addAll(result, Iterables.<CardinalityRestrictedReifiedRelationship>filter(tbox.getBoxStatements(), CardinalityRestrictedReifiedRelationship.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<CardinalityRestrictedReifiedRelationship>crossReferencabilityComparator()).collect(Collectors.<CardinalityRestrictedReifiedRelationship>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationship> reifiedRelationships(final Extent e) {
    List<ReifiedRelationship> _xblockexpression = null;
    {
      final List<ReifiedRelationship> result = new ArrayList<ReifiedRelationship>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<ReifiedRelationship>addAll(result, Iterables.<ReifiedRelationship>filter(tbox.getBoxStatements(), ReifiedRelationship.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ReifiedRelationship>crossReferencabilityComparator()).collect(Collectors.<ReifiedRelationship>toList());
    }
    return _xblockexpression;
  }
  
  public static Iterable<ForwardProperty> forwardProperties(final Extent e) {
    List<ForwardProperty> _xblockexpression = null;
    {
      final List<ForwardProperty> result = new ArrayList<ForwardProperty>();
      final Function1<ReifiedRelationship, ForwardProperty> _function = (ReifiedRelationship it) -> {
        return it.getForwardProperty();
      };
      Iterables.<ForwardProperty>addAll(result, IterableExtensions.<ForwardProperty>filterNull(ListExtensions.<ReifiedRelationship, ForwardProperty>map(OMLTables.reifiedRelationships(e), _function)));
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ForwardProperty>crossReferencabilityComparator()).collect(Collectors.<ForwardProperty>toList());
    }
    return _xblockexpression;
  }
  
  public static Iterable<InverseProperty> inverseProperties(final Extent e) {
    List<InverseProperty> _xblockexpression = null;
    {
      final List<InverseProperty> result = new ArrayList<InverseProperty>();
      final Function1<ReifiedRelationship, InverseProperty> _function = (ReifiedRelationship it) -> {
        return it.getInverseProperty();
      };
      Iterables.<InverseProperty>addAll(result, IterableExtensions.<InverseProperty>filterNull(ListExtensions.<ReifiedRelationship, InverseProperty>map(OMLTables.reifiedRelationships(e), _function)));
      _xblockexpression = result.parallelStream().sorted(OMLTables.<InverseProperty>crossReferencabilityComparator()).collect(Collectors.<InverseProperty>toList());
    }
    return _xblockexpression;
  }
  
  public static List<UnreifiedRelationship> unreifiedRelationships(final Extent e) {
    List<UnreifiedRelationship> _xblockexpression = null;
    {
      final List<UnreifiedRelationship> result = new ArrayList<UnreifiedRelationship>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<UnreifiedRelationship>addAll(result, Iterables.<UnreifiedRelationship>filter(tbox.getBoxStatements(), UnreifiedRelationship.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<UnreifiedRelationship>crossReferencabilityComparator()).collect(Collectors.<UnreifiedRelationship>toList());
    }
    return _xblockexpression;
  }
  
  public static List<Scalar> scalars(final Extent e) {
    List<Scalar> _xblockexpression = null;
    {
      final List<Scalar> result = new ArrayList<Scalar>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<Scalar>addAll(result, Iterables.<Scalar>filter(tbox.getBoxStatements(), Scalar.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<Scalar>crossReferencabilityComparator()).collect(Collectors.<Scalar>toList());
    }
    return _xblockexpression;
  }
  
  public static List<Structure> structures(final Extent e) {
    List<Structure> _xblockexpression = null;
    {
      final List<Structure> result = new ArrayList<Structure>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<Structure>addAll(result, Iterables.<Structure>filter(tbox.getBoxStatements(), Structure.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<Structure>crossReferencabilityComparator()).collect(Collectors.<Structure>toList());
    }
    return _xblockexpression;
  }
  
  public static List<BinaryScalarRestriction> binaryScalarRestrictions(final Extent e) {
    List<BinaryScalarRestriction> _xblockexpression = null;
    {
      final List<BinaryScalarRestriction> result = new ArrayList<BinaryScalarRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<BinaryScalarRestriction>addAll(result, Iterables.<BinaryScalarRestriction>filter(tbox.getBoxStatements(), BinaryScalarRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<BinaryScalarRestriction>crossReferencabilityComparator()).collect(Collectors.<BinaryScalarRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<IRIScalarRestriction> iriScalarRestrictions(final Extent e) {
    List<IRIScalarRestriction> _xblockexpression = null;
    {
      final List<IRIScalarRestriction> result = new ArrayList<IRIScalarRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<IRIScalarRestriction>addAll(result, Iterables.<IRIScalarRestriction>filter(tbox.getBoxStatements(), IRIScalarRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<IRIScalarRestriction>crossReferencabilityComparator()).collect(Collectors.<IRIScalarRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<NumericScalarRestriction> numericScalarRestrictions(final Extent e) {
    List<NumericScalarRestriction> _xblockexpression = null;
    {
      final List<NumericScalarRestriction> result = new ArrayList<NumericScalarRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<NumericScalarRestriction>addAll(result, Iterables.<NumericScalarRestriction>filter(tbox.getBoxStatements(), NumericScalarRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<NumericScalarRestriction>crossReferencabilityComparator()).collect(Collectors.<NumericScalarRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<PlainLiteralScalarRestriction> plainLiteralScalarRestrictions(final Extent e) {
    List<PlainLiteralScalarRestriction> _xblockexpression = null;
    {
      final List<PlainLiteralScalarRestriction> result = new ArrayList<PlainLiteralScalarRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<PlainLiteralScalarRestriction>addAll(result, Iterables.<PlainLiteralScalarRestriction>filter(tbox.getBoxStatements(), PlainLiteralScalarRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<PlainLiteralScalarRestriction>crossReferencabilityComparator()).collect(Collectors.<PlainLiteralScalarRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ScalarOneOfRestriction> scalarOneOfRestrictions(final Extent e) {
    List<ScalarOneOfRestriction> _xblockexpression = null;
    {
      final List<ScalarOneOfRestriction> result = new ArrayList<ScalarOneOfRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<ScalarOneOfRestriction>addAll(result, Iterables.<ScalarOneOfRestriction>filter(tbox.getBoxStatements(), ScalarOneOfRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ScalarOneOfRestriction>crossReferencabilityComparator()).collect(Collectors.<ScalarOneOfRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ScalarOneOfLiteralAxiom> scalarOneOfLiteralAxioms(final Extent e) {
    List<ScalarOneOfLiteralAxiom> _xblockexpression = null;
    {
      final List<ScalarOneOfLiteralAxiom> result = new ArrayList<ScalarOneOfLiteralAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<ScalarOneOfLiteralAxiom>addAll(result, Iterables.<ScalarOneOfLiteralAxiom>filter(tbox.getBoxStatements(), ScalarOneOfLiteralAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ScalarOneOfLiteralAxiom>crossReferencabilityComparator()).collect(Collectors.<ScalarOneOfLiteralAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<StringScalarRestriction> stringScalarRestrictions(final Extent e) {
    List<StringScalarRestriction> _xblockexpression = null;
    {
      final List<StringScalarRestriction> result = new ArrayList<StringScalarRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<StringScalarRestriction>addAll(result, Iterables.<StringScalarRestriction>filter(tbox.getBoxStatements(), StringScalarRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<StringScalarRestriction>crossReferencabilityComparator()).collect(Collectors.<StringScalarRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<SynonymScalarRestriction> synonymScalarRestrictions(final Extent e) {
    List<SynonymScalarRestriction> _xblockexpression = null;
    {
      final List<SynonymScalarRestriction> result = new ArrayList<SynonymScalarRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<SynonymScalarRestriction>addAll(result, Iterables.<SynonymScalarRestriction>filter(tbox.getBoxStatements(), SynonymScalarRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<SynonymScalarRestriction>crossReferencabilityComparator()).collect(Collectors.<SynonymScalarRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<TimeScalarRestriction> timeScalarRestrictions(final Extent e) {
    List<TimeScalarRestriction> _xblockexpression = null;
    {
      final List<TimeScalarRestriction> result = new ArrayList<TimeScalarRestriction>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<TimeScalarRestriction>addAll(result, Iterables.<TimeScalarRestriction>filter(tbox.getBoxStatements(), TimeScalarRestriction.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<TimeScalarRestriction>crossReferencabilityComparator()).collect(Collectors.<TimeScalarRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<EntityScalarDataProperty> entityScalarDataProperties(final Extent e) {
    List<EntityScalarDataProperty> _xblockexpression = null;
    {
      final List<EntityScalarDataProperty> result = new ArrayList<EntityScalarDataProperty>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<EntityScalarDataProperty>addAll(result, Iterables.<EntityScalarDataProperty>filter(tbox.getBoxStatements(), EntityScalarDataProperty.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<EntityScalarDataProperty>crossReferencabilityComparator()).collect(Collectors.<EntityScalarDataProperty>toList());
    }
    return _xblockexpression;
  }
  
  public static List<EntityStructuredDataProperty> entityStructuredDataProperties(final Extent e) {
    List<EntityStructuredDataProperty> _xblockexpression = null;
    {
      final List<EntityStructuredDataProperty> result = new ArrayList<EntityStructuredDataProperty>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<EntityStructuredDataProperty>addAll(result, Iterables.<EntityStructuredDataProperty>filter(tbox.getBoxStatements(), EntityStructuredDataProperty.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<EntityStructuredDataProperty>crossReferencabilityComparator()).collect(Collectors.<EntityStructuredDataProperty>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ScalarDataProperty> scalarDataProperties(final Extent e) {
    List<ScalarDataProperty> _xblockexpression = null;
    {
      final List<ScalarDataProperty> result = new ArrayList<ScalarDataProperty>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<ScalarDataProperty>addAll(result, Iterables.<ScalarDataProperty>filter(tbox.getBoxStatements(), ScalarDataProperty.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ScalarDataProperty>crossReferencabilityComparator()).collect(Collectors.<ScalarDataProperty>toList());
    }
    return _xblockexpression;
  }
  
  public static List<StructuredDataProperty> structuredDataProperties(final Extent e) {
    List<StructuredDataProperty> _xblockexpression = null;
    {
      final List<StructuredDataProperty> result = new ArrayList<StructuredDataProperty>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<StructuredDataProperty>addAll(result, Iterables.<StructuredDataProperty>filter(tbox.getBoxStatements(), StructuredDataProperty.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<StructuredDataProperty>crossReferencabilityComparator()).collect(Collectors.<StructuredDataProperty>toList());
    }
    return _xblockexpression;
  }
  
  public static List<AspectSpecializationAxiom> aspectSpecializationAxioms(final Extent e) {
    List<AspectSpecializationAxiom> _xblockexpression = null;
    {
      final List<AspectSpecializationAxiom> result = new ArrayList<AspectSpecializationAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<AspectSpecializationAxiom>addAll(result, Iterables.<AspectSpecializationAxiom>filter(tbox.getBoxStatements(), AspectSpecializationAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<AspectSpecializationAxiom>crossReferencabilityComparator()).collect(Collectors.<AspectSpecializationAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ConceptSpecializationAxiom> conceptSpecializationAxioms(final Extent e) {
    List<ConceptSpecializationAxiom> _xblockexpression = null;
    {
      final List<ConceptSpecializationAxiom> result = new ArrayList<ConceptSpecializationAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<ConceptSpecializationAxiom>addAll(result, Iterables.<ConceptSpecializationAxiom>filter(tbox.getBoxStatements(), ConceptSpecializationAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ConceptSpecializationAxiom>crossReferencabilityComparator()).collect(Collectors.<ConceptSpecializationAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipSpecializationAxiom> reifiedRelationshipSpecializationAxioms(final Extent e) {
    List<ReifiedRelationshipSpecializationAxiom> _xblockexpression = null;
    {
      final List<ReifiedRelationshipSpecializationAxiom> result = new ArrayList<ReifiedRelationshipSpecializationAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<ReifiedRelationshipSpecializationAxiom>addAll(result, Iterables.<ReifiedRelationshipSpecializationAxiom>filter(tbox.getBoxStatements(), ReifiedRelationshipSpecializationAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ReifiedRelationshipSpecializationAxiom>crossReferencabilityComparator()).collect(Collectors.<ReifiedRelationshipSpecializationAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<SubDataPropertyOfAxiom> subDataPropertyOfAxioms(final Extent e) {
    List<SubDataPropertyOfAxiom> _xblockexpression = null;
    {
      final List<SubDataPropertyOfAxiom> result = new ArrayList<SubDataPropertyOfAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<SubDataPropertyOfAxiom>addAll(result, Iterables.<SubDataPropertyOfAxiom>filter(tbox.getBoxStatements(), SubDataPropertyOfAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<SubDataPropertyOfAxiom>crossReferencabilityComparator()).collect(Collectors.<SubDataPropertyOfAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<SubObjectPropertyOfAxiom> subObjectPropertyOfAxioms(final Extent e) {
    List<SubObjectPropertyOfAxiom> _xblockexpression = null;
    {
      final List<SubObjectPropertyOfAxiom> result = new ArrayList<SubObjectPropertyOfAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<SubObjectPropertyOfAxiom>addAll(result, Iterables.<SubObjectPropertyOfAxiom>filter(tbox.getBoxStatements(), SubObjectPropertyOfAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<SubObjectPropertyOfAxiom>crossReferencabilityComparator()).collect(Collectors.<SubObjectPropertyOfAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<EntityExistentialRestrictionAxiom> entityExistentialRestrictionAxioms(final Extent e) {
    List<EntityExistentialRestrictionAxiom> _xblockexpression = null;
    {
      final List<EntityExistentialRestrictionAxiom> result = new ArrayList<EntityExistentialRestrictionAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<EntityExistentialRestrictionAxiom>addAll(result, Iterables.<EntityExistentialRestrictionAxiom>filter(tbox.getBoxStatements(), EntityExistentialRestrictionAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<EntityExistentialRestrictionAxiom>crossReferencabilityComparator()).collect(Collectors.<EntityExistentialRestrictionAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<EntityUniversalRestrictionAxiom> entityUniversalRestrictionAxioms(final Extent e) {
    List<EntityUniversalRestrictionAxiom> _xblockexpression = null;
    {
      final List<EntityUniversalRestrictionAxiom> result = new ArrayList<EntityUniversalRestrictionAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<EntityUniversalRestrictionAxiom>addAll(result, Iterables.<EntityUniversalRestrictionAxiom>filter(tbox.getBoxStatements(), EntityUniversalRestrictionAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<EntityUniversalRestrictionAxiom>crossReferencabilityComparator()).collect(Collectors.<EntityUniversalRestrictionAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<EntityScalarDataPropertyExistentialRestrictionAxiom> entityScalarDataPropertyExistentialRestrictionAxioms(final Extent e) {
    List<EntityScalarDataPropertyExistentialRestrictionAxiom> _xblockexpression = null;
    {
      final List<EntityScalarDataPropertyExistentialRestrictionAxiom> result = new ArrayList<EntityScalarDataPropertyExistentialRestrictionAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<EntityScalarDataPropertyExistentialRestrictionAxiom>addAll(result, Iterables.<EntityScalarDataPropertyExistentialRestrictionAxiom>filter(tbox.getBoxStatements(), EntityScalarDataPropertyExistentialRestrictionAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<EntityScalarDataPropertyExistentialRestrictionAxiom>crossReferencabilityComparator()).collect(Collectors.<EntityScalarDataPropertyExistentialRestrictionAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<EntityScalarDataPropertyParticularRestrictionAxiom> entityScalarDataPropertyParticularRestrictionAxioms(final Extent e) {
    List<EntityScalarDataPropertyParticularRestrictionAxiom> _xblockexpression = null;
    {
      final List<EntityScalarDataPropertyParticularRestrictionAxiom> result = new ArrayList<EntityScalarDataPropertyParticularRestrictionAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<EntityScalarDataPropertyParticularRestrictionAxiom>addAll(result, Iterables.<EntityScalarDataPropertyParticularRestrictionAxiom>filter(tbox.getBoxStatements(), EntityScalarDataPropertyParticularRestrictionAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<EntityScalarDataPropertyParticularRestrictionAxiom>crossReferencabilityComparator()).collect(Collectors.<EntityScalarDataPropertyParticularRestrictionAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<EntityScalarDataPropertyUniversalRestrictionAxiom> entityScalarDataPropertyUniversalRestrictionAxioms(final Extent e) {
    List<EntityScalarDataPropertyUniversalRestrictionAxiom> _xblockexpression = null;
    {
      final List<EntityScalarDataPropertyUniversalRestrictionAxiom> result = new ArrayList<EntityScalarDataPropertyUniversalRestrictionAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<EntityScalarDataPropertyUniversalRestrictionAxiom>addAll(result, Iterables.<EntityScalarDataPropertyUniversalRestrictionAxiom>filter(tbox.getBoxStatements(), EntityScalarDataPropertyUniversalRestrictionAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<EntityScalarDataPropertyUniversalRestrictionAxiom>crossReferencabilityComparator()).collect(Collectors.<EntityScalarDataPropertyUniversalRestrictionAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<EntityStructuredDataPropertyParticularRestrictionAxiom> entityStructuredDataPropertyParticularRestrictionAxioms(final Extent e) {
    List<EntityStructuredDataPropertyParticularRestrictionAxiom> _xblockexpression = null;
    {
      final List<EntityStructuredDataPropertyParticularRestrictionAxiom> result = new ArrayList<EntityStructuredDataPropertyParticularRestrictionAxiom>();
      final Consumer<TerminologyBox> _function = (TerminologyBox tbox) -> {
        Iterables.<EntityStructuredDataPropertyParticularRestrictionAxiom>addAll(result, Iterables.<EntityStructuredDataPropertyParticularRestrictionAxiom>filter(tbox.getBoxStatements(), EntityStructuredDataPropertyParticularRestrictionAxiom.class));
      };
      OMLTables.terminologies(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<EntityStructuredDataPropertyParticularRestrictionAxiom>crossReferencabilityComparator()).collect(Collectors.<EntityStructuredDataPropertyParticularRestrictionAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<RootConceptTaxonomyAxiom> rootConceptTaxonomyAxioms(final Extent e) {
    List<RootConceptTaxonomyAxiom> _xblockexpression = null;
    {
      final List<RootConceptTaxonomyAxiom> result = new ArrayList<RootConceptTaxonomyAxiom>();
      final Consumer<Bundle> _function = (Bundle b) -> {
        Iterables.<RootConceptTaxonomyAxiom>addAll(result, Iterables.<RootConceptTaxonomyAxiom>filter(b.getBundleStatements(), RootConceptTaxonomyAxiom.class));
      };
      OMLTables.bundles(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<RootConceptTaxonomyAxiom>crossReferencabilityComparator()).collect(Collectors.<RootConceptTaxonomyAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<SpecificDisjointConceptAxiom> specificDisjointConceptAxioms(final Extent e) {
    List<SpecificDisjointConceptAxiom> _xblockexpression = null;
    {
      final List<SpecificDisjointConceptAxiom> result = new ArrayList<SpecificDisjointConceptAxiom>();
      final Consumer<Bundle> _function = (Bundle b) -> {
        final Consumer<RootConceptTaxonomyAxiom> _function_1 = (RootConceptTaxonomyAxiom r) -> {
          Iterables.<SpecificDisjointConceptAxiom>addAll(result, Iterables.<SpecificDisjointConceptAxiom>filter(r.allNestedElements(), SpecificDisjointConceptAxiom.class));
        };
        Iterables.<RootConceptTaxonomyAxiom>filter(b.getBoxStatements(), RootConceptTaxonomyAxiom.class).forEach(_function_1);
      };
      OMLTables.bundles(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<SpecificDisjointConceptAxiom>crossReferencabilityComparator()).collect(Collectors.<SpecificDisjointConceptAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<AnonymousConceptUnionAxiom> anonymousConceptUnionAxioms(final Extent e) {
    List<AnonymousConceptUnionAxiom> _xblockexpression = null;
    {
      final List<AnonymousConceptUnionAxiom> result = new ArrayList<AnonymousConceptUnionAxiom>();
      final Consumer<Bundle> _function = (Bundle b) -> {
        final Consumer<RootConceptTaxonomyAxiom> _function_1 = (RootConceptTaxonomyAxiom r) -> {
          Iterables.<AnonymousConceptUnionAxiom>addAll(result, Iterables.<AnonymousConceptUnionAxiom>filter(r.allNestedElements(), AnonymousConceptUnionAxiom.class));
        };
        Iterables.<RootConceptTaxonomyAxiom>filter(b.getBoxStatements(), RootConceptTaxonomyAxiom.class).forEach(_function_1);
      };
      OMLTables.bundles(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<AnonymousConceptUnionAxiom>crossReferencabilityComparator()).collect(Collectors.<AnonymousConceptUnionAxiom>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ChainRule> chainRules(final Extent e) {
    List<ChainRule> _xblockexpression = null;
    {
      final List<ChainRule> result = new ArrayList<ChainRule>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        Iterables.<ChainRule>addAll(result, Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class));
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ChainRule>crossReferencabilityComparator()).collect(Collectors.<ChainRule>toList());
    }
    return _xblockexpression;
  }
  
  public static List<RuleBodySegment> ruleBodySegments(final Extent e) {
    List<RuleBodySegment> _xblockexpression = null;
    {
      final List<RuleBodySegment> result = new ArrayList<RuleBodySegment>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<RuleBodySegment>addAll(result, Iterables.<RuleBodySegment>filter(r.allNestedElements(), RuleBodySegment.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<RuleBodySegment>crossReferencabilityComparator()).collect(Collectors.<RuleBodySegment>toList());
    }
    return _xblockexpression;
  }
  
  public static List<SegmentPredicate> segmentPredicates(final Extent e) {
    List<SegmentPredicate> _xblockexpression = null;
    {
      final List<SegmentPredicate> result = new ArrayList<SegmentPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<SegmentPredicate>addAll(result, Iterables.<SegmentPredicate>filter(r.allNestedElements(), SegmentPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<SegmentPredicate>crossReferencabilityComparator()).collect(Collectors.<SegmentPredicate>toList());
    }
    return _xblockexpression;
  }
  
  public static List<Predicate> predicates(final Extent e) {
    List<Predicate> _xblockexpression = null;
    {
      final List<Predicate> result = new ArrayList<Predicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph t) -> {
        final Consumer<Predicate> _function_1 = (Predicate p) -> {
          CollectionExtensions.<Predicate>addAll(result, p);
        };
        Iterables.<Predicate>filter(t.getBoxStatements(), Predicate.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Consumer<TerminologyGraph> _function_1 = (TerminologyGraph t) -> {
        final Consumer<ReifiedRelationship> _function_2 = (ReifiedRelationship rr) -> {
          result.add(rr.getForwardProperty());
          InverseProperty _inverseProperty = rr.getInverseProperty();
          boolean _tripleNotEquals = (null != _inverseProperty);
          if (_tripleNotEquals) {
            result.add(rr.getInverseProperty());
          }
        };
        Iterables.<ReifiedRelationship>filter(t.getBoxStatements(), ReifiedRelationship.class).forEach(_function_2);
      };
      OMLTables.terminologyGraphs(e).forEach(_function_1);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<Predicate>crossReferencabilityComparator()).collect(Collectors.<Predicate>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ConceptInstance> conceptInstances(final Extent e) {
    List<ConceptInstance> _xblockexpression = null;
    {
      final List<ConceptInstance> result = new ArrayList<ConceptInstance>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getConceptInstances());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ConceptInstance>crossReferencabilityComparator()).collect(Collectors.<ConceptInstance>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipInstance> reifiedRelationshipInstances(final Extent e) {
    List<ReifiedRelationshipInstance> _xblockexpression = null;
    {
      final List<ReifiedRelationshipInstance> result = new ArrayList<ReifiedRelationshipInstance>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getReifiedRelationshipInstances());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ReifiedRelationshipInstance>crossReferencabilityComparator()).collect(Collectors.<ReifiedRelationshipInstance>toList());
    }
    return _xblockexpression;
  }
  
  public static List<InstanceRelationshipExistentialRangeRestriction> instanceRelationshipExistentialRangeRestrictions(final Extent e) {
    List<InstanceRelationshipExistentialRangeRestriction> _xblockexpression = null;
    {
      final List<InstanceRelationshipExistentialRangeRestriction> result = new ArrayList<InstanceRelationshipExistentialRangeRestriction>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getInstanceRelationshipExistentialRangeRestrictions());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<InstanceRelationshipExistentialRangeRestriction>crossReferencabilityComparator()).collect(Collectors.<InstanceRelationshipExistentialRangeRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<InstanceRelationshipUniversalRangeRestriction> instanceRelationshipUniversalRangeRestrictions(final Extent e) {
    List<InstanceRelationshipUniversalRangeRestriction> _xblockexpression = null;
    {
      final List<InstanceRelationshipUniversalRangeRestriction> result = new ArrayList<InstanceRelationshipUniversalRangeRestriction>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getInstanceRelationshipUniversalRangeRestrictions());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<InstanceRelationshipUniversalRangeRestriction>crossReferencabilityComparator()).collect(Collectors.<InstanceRelationshipUniversalRangeRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<InstanceRelationshipEnumerationRestriction> instanceRelationshipEnumerationRestrictions(final Extent e) {
    List<InstanceRelationshipEnumerationRestriction> _xblockexpression = null;
    {
      final List<InstanceRelationshipEnumerationRestriction> result = new ArrayList<InstanceRelationshipEnumerationRestriction>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getInstanceRelationshipEnumerationRestrictions());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<InstanceRelationshipEnumerationRestriction>crossReferencabilityComparator()).collect(Collectors.<InstanceRelationshipEnumerationRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<InstanceRelationshipOneOfRestriction> instanceRelationshipOneOfRestrictions(final Extent e) {
    List<InstanceRelationshipOneOfRestriction> _xblockexpression = null;
    {
      final List<InstanceRelationshipOneOfRestriction> result = new ArrayList<InstanceRelationshipOneOfRestriction>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        final Consumer<InstanceRelationshipEnumerationRestriction> _function_1 = (InstanceRelationshipEnumerationRestriction r) -> {
          result.addAll(r.getReferences());
        };
        dbox.getInstanceRelationshipEnumerationRestrictions().forEach(_function_1);
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<InstanceRelationshipOneOfRestriction>crossReferencabilityComparator()).collect(Collectors.<InstanceRelationshipOneOfRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<InstanceRelationshipValueRestriction> instanceRelationshipValueRestrictions(final Extent e) {
    List<InstanceRelationshipValueRestriction> _xblockexpression = null;
    {
      final List<InstanceRelationshipValueRestriction> result = new ArrayList<InstanceRelationshipValueRestriction>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getInstanceRelationshipValueRestrictions());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<InstanceRelationshipValueRestriction>crossReferencabilityComparator()).collect(Collectors.<InstanceRelationshipValueRestriction>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipInstanceDomain> reifiedRelationshipInstanceDomains(final Extent e) {
    List<ReifiedRelationshipInstanceDomain> _xblockexpression = null;
    {
      final List<ReifiedRelationshipInstanceDomain> result = new ArrayList<ReifiedRelationshipInstanceDomain>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getReifiedRelationshipInstanceDomains());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ReifiedRelationshipInstanceDomain>crossReferencabilityComparator()).collect(Collectors.<ReifiedRelationshipInstanceDomain>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipInstanceRange> reifiedRelationshipInstanceRanges(final Extent e) {
    List<ReifiedRelationshipInstanceRange> _xblockexpression = null;
    {
      final List<ReifiedRelationshipInstanceRange> result = new ArrayList<ReifiedRelationshipInstanceRange>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getReifiedRelationshipInstanceRanges());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ReifiedRelationshipInstanceRange>crossReferencabilityComparator()).collect(Collectors.<ReifiedRelationshipInstanceRange>toList());
    }
    return _xblockexpression;
  }
  
  public static List<RestrictionScalarDataPropertyValue> restrictionScalarDataPropertyValues(final Extent e) {
    List<RestrictionScalarDataPropertyValue> _xblockexpression = null;
    {
      final List<RestrictionScalarDataPropertyValue> result = new ArrayList<RestrictionScalarDataPropertyValue>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<EntityStructuredDataPropertyParticularRestrictionAxiom> _function_1 = (EntityStructuredDataPropertyParticularRestrictionAxiom r) -> {
          Iterables.<RestrictionScalarDataPropertyValue>addAll(result, Iterables.<RestrictionScalarDataPropertyValue>filter(r.allNestedElements(), RestrictionScalarDataPropertyValue.class));
        };
        Iterables.<EntityStructuredDataPropertyParticularRestrictionAxiom>filter(b.getBoxStatements(), EntityStructuredDataPropertyParticularRestrictionAxiom.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<RestrictionScalarDataPropertyValue>crossReferencabilityComparator()).collect(Collectors.<RestrictionScalarDataPropertyValue>toList());
    }
    return _xblockexpression;
  }
  
  public static List<RestrictionStructuredDataPropertyTuple> restrictionStructuredDataPropertyTuples(final Extent e) {
    List<RestrictionStructuredDataPropertyTuple> _xblockexpression = null;
    {
      final List<RestrictionStructuredDataPropertyTuple> result = new ArrayList<RestrictionStructuredDataPropertyTuple>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<EntityStructuredDataPropertyParticularRestrictionAxiom> _function_1 = (EntityStructuredDataPropertyParticularRestrictionAxiom r) -> {
          Iterables.<RestrictionStructuredDataPropertyTuple>addAll(result, Iterables.<RestrictionStructuredDataPropertyTuple>filter(r.allNestedElements(), RestrictionStructuredDataPropertyTuple.class));
        };
        Iterables.<EntityStructuredDataPropertyParticularRestrictionAxiom>filter(b.getBoxStatements(), EntityStructuredDataPropertyParticularRestrictionAxiom.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<RestrictionStructuredDataPropertyTuple>crossReferencabilityComparator()).collect(Collectors.<RestrictionStructuredDataPropertyTuple>toList());
    }
    return _xblockexpression;
  }
  
  public static List<ScalarDataPropertyValue> scalarDataPropertyValues(final Extent e) {
    List<ScalarDataPropertyValue> _xblockexpression = null;
    {
      final List<ScalarDataPropertyValue> result = new ArrayList<ScalarDataPropertyValue>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        final Consumer<SingletonInstanceStructuredDataPropertyValue> _function_1 = (SingletonInstanceStructuredDataPropertyValue s) -> {
          Iterables.<ScalarDataPropertyValue>addAll(result, Iterables.<ScalarDataPropertyValue>filter(s.allNestedElements(), ScalarDataPropertyValue.class));
        };
        dbox.getSingletonStructuredDataPropertyValues().forEach(_function_1);
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<ScalarDataPropertyValue>crossReferencabilityComparator()).collect(Collectors.<ScalarDataPropertyValue>toList());
    }
    return _xblockexpression;
  }
  
  public static List<SingletonInstanceScalarDataPropertyValue> singletonInstanceScalarDataPropertyValues(final Extent e) {
    List<SingletonInstanceScalarDataPropertyValue> _xblockexpression = null;
    {
      final List<SingletonInstanceScalarDataPropertyValue> result = new ArrayList<SingletonInstanceScalarDataPropertyValue>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getSingletonScalarDataPropertyValues());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<SingletonInstanceScalarDataPropertyValue>crossReferencabilityComparator()).collect(Collectors.<SingletonInstanceScalarDataPropertyValue>toList());
    }
    return _xblockexpression;
  }
  
  public static List<SingletonInstanceStructuredDataPropertyValue> singletonInstanceStructuredDataPropertyValues(final Extent e) {
    List<SingletonInstanceStructuredDataPropertyValue> _xblockexpression = null;
    {
      final List<SingletonInstanceStructuredDataPropertyValue> result = new ArrayList<SingletonInstanceStructuredDataPropertyValue>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getSingletonStructuredDataPropertyValues());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<SingletonInstanceStructuredDataPropertyValue>crossReferencabilityComparator()).collect(Collectors.<SingletonInstanceStructuredDataPropertyValue>toList());
    }
    return _xblockexpression;
  }
  
  public static List<StructuredDataPropertyTuple> structuredDataPropertyTuples(final Extent e) {
    List<StructuredDataPropertyTuple> _xblockexpression = null;
    {
      final List<StructuredDataPropertyTuple> result = new ArrayList<StructuredDataPropertyTuple>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        final Consumer<SingletonInstanceStructuredDataPropertyValue> _function_1 = (SingletonInstanceStructuredDataPropertyValue s) -> {
          Iterables.<StructuredDataPropertyTuple>addAll(result, Iterables.<StructuredDataPropertyTuple>filter(s.allNestedElements(), StructuredDataPropertyTuple.class));
        };
        dbox.getSingletonStructuredDataPropertyValues().forEach(_function_1);
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<StructuredDataPropertyTuple>crossReferencabilityComparator()).collect(Collectors.<StructuredDataPropertyTuple>toList());
    }
    return _xblockexpression;
  }
  
  public static List<UnreifiedRelationshipInstanceTuple> unreifiedRelationshipInstanceTuples(final Extent e) {
    List<UnreifiedRelationshipInstanceTuple> _xblockexpression = null;
    {
      final List<UnreifiedRelationshipInstanceTuple> result = new ArrayList<UnreifiedRelationshipInstanceTuple>();
      final Consumer<DescriptionBox> _function = (DescriptionBox dbox) -> {
        result.addAll(dbox.getUnreifiedRelationshipInstanceTuples());
      };
      OMLTables.descriptionBoxes(e).forEach(_function);
      _xblockexpression = result.parallelStream().sorted(OMLTables.<UnreifiedRelationshipInstanceTuple>crossReferencabilityComparator()).collect(Collectors.<UnreifiedRelationshipInstanceTuple>toList());
    }
    return _xblockexpression;
  }
  
  public final static char QUOTE = '\"';
  
  public final static char NEWLINE = '\n';
  
  public final static char LINEFEED = '\r';
  
  protected static String toStringArray(final String rawString) {
    String _xifexpression = null;
    if (((null == rawString) || rawString.isEmpty())) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[\"\"]");
      _xifexpression = _builder.toString();
    } else {
      String _xblockexpression = null;
      {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        String value = rawString;
        boolean empty = true;
        boolean continue_ = true;
        do {
          {
            final int qi = value.indexOf(OMLTables.QUOTE);
            final int ni = value.indexOf(OMLTables.NEWLINE);
            final int li = value.indexOf(OMLTables.LINEFEED);
            if ((0 == qi)) {
              if (empty) {
                empty = false;
              } else {
                buffer.append(",");
              }
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("\"\\\"\"");
              buffer.append(_builder_1);
              value = value.substring(1);
            } else {
              if ((0 == ni)) {
                if (empty) {
                  empty = false;
                } else {
                  buffer.append(",");
                }
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("\"\\n\"");
                buffer.append(_builder_2);
                value = value.substring(1);
              } else {
                if ((0 == li)) {
                  if (empty) {
                    empty = false;
                  } else {
                    buffer.append(",");
                  }
                  StringConcatenation _builder_3 = new StringConcatenation();
                  _builder_3.append("\"\\r\"");
                  buffer.append(_builder_3);
                  value = value.substring(1);
                } else {
                  if ((((0 < qi) && (((-1) == ni) || (qi < ni))) && (((-1) == li) || (qi < li)))) {
                    if (empty) {
                      empty = false;
                    } else {
                      buffer.append(",");
                    }
                    StringConcatenation _builder_4 = new StringConcatenation();
                    _builder_4.append("\"");
                    String _substring = value.substring(0, qi);
                    _builder_4.append(_substring);
                    _builder_4.append("\",\"\\\"\"");
                    buffer.append(_builder_4);
                    value = value.substring((qi + 1));
                  } else {
                    if ((((0 < ni) && (((-1) == qi) || (ni < qi))) && (((-1) == li) || (ni < li)))) {
                      if (empty) {
                        empty = false;
                      } else {
                        buffer.append(",");
                      }
                      StringConcatenation _builder_5 = new StringConcatenation();
                      _builder_5.append("\"");
                      String _substring_1 = value.substring(0, ni);
                      _builder_5.append(_substring_1);
                      _builder_5.append("\",\"\\n\"");
                      buffer.append(_builder_5);
                      value = value.substring((ni + 1));
                    } else {
                      if ((((0 < li) && (((-1) == qi) || (li < qi))) && (((-1) == ni) || (li < ni)))) {
                        if (empty) {
                          empty = false;
                        } else {
                          buffer.append(",");
                        }
                        StringConcatenation _builder_6 = new StringConcatenation();
                        _builder_6.append("\"");
                        String _substring_2 = value.substring(0, li);
                        _builder_6.append(_substring_2);
                        _builder_6.append("\",\"\\r\"");
                        buffer.append(_builder_6);
                        value = value.substring((li + 1));
                      } else {
                        if (empty) {
                          empty = false;
                        } else {
                          buffer.append(",");
                        }
                        StringConcatenation _builder_7 = new StringConcatenation();
                        _builder_7.append("\"");
                        _builder_7.append(value);
                        _builder_7.append("\"]");
                        buffer.append(_builder_7);
                        continue_ = false;
                      }
                    }
                  }
                }
              }
            }
          }
        } while(continue_);
        _xblockexpression = buffer.toString();
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected static String _toString(final PatternValue value) {
    return OMLTables.toStringArray(value.value);
  }
  
  protected static String _toString(final LiteralString value) {
    return OMLTables.toStringArray(value.value());
  }
  
  protected static String _toString(final String value) {
    String _xblockexpression = null;
    {
      final int qi = value.indexOf(OMLTables.QUOTE);
      final int ni = value.indexOf(OMLTables.NEWLINE);
      final int li = value.indexOf(OMLTables.LINEFEED);
      String _xifexpression = null;
      if ((((qi > 0) || (ni > 0)) || (li > 0))) {
        _xifexpression = OMLTables.toStringArray(value);
      } else {
        _xifexpression = (("\"" + value) + "\"");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected static String _toString(final LanguageTagValue value) {
    return (("\"" + value.value) + "\"");
  }
  
  protected static String _toString(final PositiveIntegerValue value) {
    return (("\"" + value.value) + "\"");
  }
  
  protected static String _toString(final LiteralNumber value) {
    String _switchResult = null;
    boolean _matched = false;
    if (value instanceof LiteralDecimal) {
      _matched=true;
      String _switchResult_1 = null;
      AbstractDecimalValue _decimal = ((LiteralDecimal)value).getDecimal();
      boolean _matched_1 = false;
      if (_decimal instanceof DecimalValue) {
        _matched_1=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{\"literalType\":\"LiteralDecimalType\",\"value\":\"");
        String _value = ((LiteralDecimal)value).value();
        _builder.append(_value);
        _builder.append("\"}");
        _switchResult_1 = _builder.toString();
      }
      if (!_matched_1) {
        if (_decimal instanceof PositiveIntegerValue) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("{\"literalType\":\"LiteralPositiveIntegerType\",\"value\":\"");
          String _value = ((LiteralDecimal)value).value();
          _builder.append(_value);
          _builder.append("\"}");
          _switchResult_1 = _builder.toString();
        }
      }
      _switchResult = _switchResult_1;
    }
    if (!_matched) {
      if (value instanceof LiteralFloat) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{\"literalType\":\"LiteralFloatType\",\"value\":\"");
        String _value = ((LiteralFloat)value).value();
        _builder.append(_value);
        _builder.append("\"}");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (value instanceof LiteralRational) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{\"literalType\":\"LiteralRationalType\",\"value\":\"");
        String _value = ((LiteralRational)value).value();
        _builder.append(_value);
        _builder.append("\"}");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (value instanceof LiteralReal) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{\"literalType\":\"LiteralRealType\",\"value\":\"");
        String _value = ((LiteralReal)value).value();
        _builder.append(_value);
        _builder.append("\"}");
        _switchResult = _builder.toString();
      }
    }
    return _switchResult;
  }
  
  protected static String _toString(final LiteralValue value) {
    String _switchResult = null;
    boolean _matched = false;
    if (value instanceof LiteralBoolean) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _value = ((LiteralBoolean)value).value();
      _builder.append(_value);
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      if (value instanceof LiteralDateTime) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{\"literalType\":\"LiteralDateTimeType\",\"value\":\"");
        String _value = ((LiteralDateTime)value).value();
        _builder.append(_value);
        _builder.append("\"}");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (value instanceof LiteralString) {
        _matched=true;
        _switchResult = OMLTables.toStringArray(((LiteralString)value).value());
      }
    }
    if (!_matched) {
      if (value instanceof LiteralUUID) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{\"literalType\":\"LiteralUUIDType\",\"value\":\"");
        String _value = ((LiteralUUID)value).value();
        _builder.append(_value);
        _builder.append("\"}");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (value instanceof LiteralURI) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{\"literalType\":\"LiteralURIType\",\"value\":\"");
        String _value = ((LiteralURI)value).value();
        _builder.append(_value);
        _builder.append("\"}");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (value instanceof LiteralNumber) {
        _matched=true;
        _switchResult = OMLTables.toString(value);
      }
    }
    return _switchResult;
  }
  
  protected static String _toString(final DescriptionKind value) {
    String _string = value.toString();
    String _plus = ("\"" + _string);
    return (_plus + "\"");
  }
  
  protected static String _toString(final TerminologyKind value) {
    String _string = value.toString();
    String _plus = ("\"" + _string);
    return (_plus + "\"");
  }
  
  protected static String _toString(final LiteralURI value) {
    return (("\"" + value.getUri().value) + "\"");
  }
  
  protected static String _toString(final LiteralUUID value) {
    String _string = value.getUuid().toString();
    String _plus = ("\"" + _string);
    return (_plus + "\"");
  }
  
  public static Boolean toEBoolean(final String value) {
    return Boolean.valueOf(Boolean.parseBoolean(value));
  }
  
  public static String toAbbrevIRI(final String value) {
    return value;
  }
  
  public static String toIRI(final String value) {
    return value;
  }
  
  public static LanguageTagValue toLanguageTagDataType(final String value) {
    return new LanguageTagValue(value);
  }
  
  public static String toLocalName(final String value) {
    return value;
  }
  
  public static PatternValue toLiteralPattern(final String value) {
    return new PatternValue(value);
  }
  
  public static PositiveIntegerValue toPositiveIntegerLiteral(final String value) {
    return new PositiveIntegerValue(value);
  }
  
  public static LiteralDateTime toLiteralDateTime(final String value) {
    final LiteralDateTime lit = CommonFactory.eINSTANCE.createLiteralDateTime();
    DateTimeValue _dateTimeValue = new DateTimeValue(value);
    lit.setDateTime(_dateTimeValue);
    return lit;
  }
  
  public static LiteralString toLiteralString(final String value) {
    final LiteralRawString lit = CommonFactory.eINSTANCE.createLiteralRawString();
    RawStringValue _rawStringValue = new RawStringValue(value);
    lit.setString(_rawStringValue);
    return lit;
  }
  
  public final static Pattern LiteralNumberOrValue = new Function0<Pattern>() {
    public Pattern apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(\\{\"literalType\":\"(.*)\",\"value\":(\"(.*)\"|\\[\"(\\\\\"|\\n|\\r|[^\"]*?)\"(,\"(\\\\\"|\\n|\\r|[^\"]*?)\")*\\])\\}|\\[\"(\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\"|\\n|\\r|[^\"]*?)\")*\\])");
      Pattern _compile = Pattern.compile(_builder.toString());
      return _compile;
    }
  }.apply();
  
  public final static Pattern StringArray = new Function0<Pattern>() {
    public Pattern apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"(\\\\\"|\\n|\\r|[^\"]+?)\",?");
      Pattern _compile = Pattern.compile(_builder.toString());
      return _compile;
    }
  }.apply();
  
  public static String toValue(final Matcher m) {
    String _xifexpression = null;
    if (((null != m.group(4)) && (!m.group(4).isEmpty()))) {
      _xifexpression = m.group(4);
    } else {
      String _xblockexpression = null;
      {
        String _xifexpression_1 = null;
        if (((null == m.group(2)) || m.group(2).isEmpty())) {
          _xifexpression_1 = m.group(1);
        } else {
          _xifexpression_1 = m.group(3);
        }
        final String stringArray = _xifexpression_1;
        boolean _equals = Objects.equal("\"\"", stringArray);
        if (_equals) {
          return "";
        }
        boolean _startsWith = stringArray.startsWith("[");
        boolean _not = (!_startsWith);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("toValue(");
          _builder.append(stringArray);
          _builder.append(") should start with \'[\'. ");
          throw new IllegalArgumentException(_builder.toString());
        }
        boolean _endsWith = stringArray.endsWith("]");
        boolean _not_1 = (!_endsWith);
        if (_not_1) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("toValue(");
          _builder_1.append(stringArray);
          _builder_1.append(") should end with \']\'. ");
          throw new IllegalArgumentException(_builder_1.toString());
        }
        final StringBuffer buffer = new StringBuffer();
        int _length = stringArray.length();
        int _minus = (_length - 1);
        final Matcher a = OMLTables.StringArray.matcher(stringArray.substring(1, _minus));
        while (a.find()) {
          {
            final String part = a.group(1);
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("\\n");
            boolean _equals_1 = Objects.equal(_builder_2.toString(), part);
            if (_equals_1) {
              buffer.append(OMLTables.NEWLINE);
            } else {
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("\\r");
              boolean _equals_2 = Objects.equal(_builder_3.toString(), part);
              if (_equals_2) {
                buffer.append(OMLTables.LINEFEED);
              } else {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("\\\"");
                boolean _equals_3 = Objects.equal(_builder_4.toString(), part);
                if (_equals_3) {
                  buffer.append(OMLTables.QUOTE);
                } else {
                  buffer.append(part);
                }
              }
            }
          }
        }
        _xblockexpression = buffer.toString();
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public static LiteralNumber toLiteralNumber(final String value) {
    LiteralNumber _xblockexpression = null;
    {
      String _elvis = null;
      if (value != null) {
        _elvis = value;
      } else {
        _elvis = "";
      }
      final Matcher m = OMLTables.LiteralNumberOrValue.matcher(_elvis);
      LiteralNumber _xifexpression = null;
      boolean _find = m.find();
      if (_find) {
        LiteralNumber _xblockexpression_1 = null;
        {
          String _elvis_1 = null;
          String _group = m.group(2);
          if (_group != null) {
            _elvis_1 = _group;
          } else {
            _elvis_1 = "";
          }
          final String litType = _elvis_1;
          final String litValue = OMLTables.toValue(m);
          LiteralNumber _switchResult = null;
          if (litType != null) {
            switch (litType) {
              case "LiteralDecimalType":
                LiteralDecimal _xblockexpression_2 = null;
                {
                  final LiteralDecimal lit = CommonFactory.eINSTANCE.createLiteralDecimal();
                  DecimalValue _decimalValue = new DecimalValue(litValue);
                  lit.setDecimal(_decimalValue);
                  _xblockexpression_2 = lit;
                }
                _switchResult = _xblockexpression_2;
                break;
              case "LiteralPositiveIntegerType":
                LiteralDecimal _xblockexpression_3 = null;
                {
                  final LiteralDecimal lit = CommonFactory.eINSTANCE.createLiteralDecimal();
                  PositiveIntegerValue _positiveIntegerValue = new PositiveIntegerValue(litValue);
                  lit.setDecimal(_positiveIntegerValue);
                  _xblockexpression_3 = lit;
                }
                _switchResult = _xblockexpression_3;
                break;
              case "LiteralFloatType":
                LiteralFloat _xblockexpression_4 = null;
                {
                  final LiteralFloat lit = CommonFactory.eINSTANCE.createLiteralFloat();
                  FloatValue _floatValue = new FloatValue(litValue);
                  lit.setFloat(_floatValue);
                  _xblockexpression_4 = lit;
                }
                _switchResult = _xblockexpression_4;
                break;
              case "LiteralRationalType":
                LiteralRational _xblockexpression_5 = null;
                {
                  final LiteralRational lit = CommonFactory.eINSTANCE.createLiteralRational();
                  RationalValue _rationalValue = new RationalValue(litValue);
                  lit.setRational(_rationalValue);
                  _xblockexpression_5 = lit;
                }
                _switchResult = _xblockexpression_5;
                break;
              case "LiteralRealType":
                LiteralReal _xblockexpression_6 = null;
                {
                  final LiteralReal lit = CommonFactory.eINSTANCE.createLiteralReal();
                  RealValue _realValue = new RealValue(litValue);
                  lit.setReal(_realValue);
                  _xblockexpression_6 = lit;
                }
                _switchResult = _xblockexpression_6;
                break;
              default:
                throw new IllegalArgumentException(("OMLTables.toLiteralNumber(value): unrecognized type: " + litType));
            }
          } else {
            throw new IllegalArgumentException(("OMLTables.toLiteralNumber(value): unrecognized type: " + litType));
          }
          _xblockexpression_1 = _switchResult;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        throw new IllegalArgumentException(("OMLTables.toLiteralNumber(value): ill-formed value=" + value));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static LiteralValue toLiteralValue(final String value) {
    LiteralValue _xifexpression = null;
    if (((null == value) || value.isEmpty())) {
      LiteralRawString _xblockexpression = null;
      {
        final LiteralRawString lit = CommonFactory.eINSTANCE.createLiteralRawString();
        RawStringValue _rawStringValue = new RawStringValue("");
        lit.setString(_rawStringValue);
        _xblockexpression = lit;
      }
      _xifexpression = _xblockexpression;
    } else {
      LiteralValue _xblockexpression_1 = null;
      {
        final Matcher m = OMLTables.LiteralNumberOrValue.matcher(value);
        LiteralValue _xifexpression_1 = null;
        boolean _find = m.find();
        if (_find) {
          LiteralValue _xblockexpression_2 = null;
          {
            String _elvis = null;
            String _group = m.group(2);
            if (_group != null) {
              _elvis = _group;
            } else {
              _elvis = "";
            }
            final String litType = _elvis;
            final String litValue = OMLTables.toValue(m);
            LiteralValue _switchResult = null;
            if (litType != null) {
              switch (litType) {
                case "LiteralBooleanType":
                  LiteralBoolean _xblockexpression_3 = null;
                  {
                    final LiteralBoolean lit = CommonFactory.eINSTANCE.createLiteralBoolean();
                    lit.setBool(Boolean.parseBoolean(litValue));
                    _xblockexpression_3 = lit;
                  }
                  _switchResult = _xblockexpression_3;
                  break;
                case "LiteralDateTimeType":
                  LiteralDateTime _xblockexpression_4 = null;
                  {
                    final LiteralDateTime lit = CommonFactory.eINSTANCE.createLiteralDateTime();
                    DateTimeValue _dateTimeValue = new DateTimeValue(litValue);
                    lit.setDateTime(_dateTimeValue);
                    _xblockexpression_4 = lit;
                  }
                  _switchResult = _xblockexpression_4;
                  break;
                case "LiteralStringType":
                  LiteralRawString _xblockexpression_5 = null;
                  {
                    final LiteralRawString lit = CommonFactory.eINSTANCE.createLiteralRawString();
                    RawStringValue _rawStringValue = new RawStringValue(litValue);
                    lit.setString(_rawStringValue);
                    _xblockexpression_5 = lit;
                  }
                  _switchResult = _xblockexpression_5;
                  break;
                case "LiteralUUIDType":
                  LiteralRawString _xblockexpression_6 = null;
                  {
                    final LiteralRawString lit = CommonFactory.eINSTANCE.createLiteralRawString();
                    RawStringValue _rawStringValue = new RawStringValue(litValue);
                    lit.setString(_rawStringValue);
                    _xblockexpression_6 = lit;
                  }
                  _switchResult = _xblockexpression_6;
                  break;
                case "LiteralURIType":
                  LiteralURI _xblockexpression_7 = null;
                  {
                    final LiteralURI lit = CommonFactory.eINSTANCE.createLiteralURI();
                    URIValue _uRIValue = new URIValue(litValue);
                    lit.setUri(_uRIValue);
                    _xblockexpression_7 = lit;
                  }
                  _switchResult = _xblockexpression_7;
                  break;
                case "LiteralDecimalType":
                  LiteralDecimal _xblockexpression_8 = null;
                  {
                    final LiteralDecimal lit = CommonFactory.eINSTANCE.createLiteralDecimal();
                    DecimalValue _decimalValue = new DecimalValue(litValue);
                    lit.setDecimal(_decimalValue);
                    _xblockexpression_8 = lit;
                  }
                  _switchResult = _xblockexpression_8;
                  break;
                case "LiteralPositiveIntegerType":
                  LiteralDecimal _xblockexpression_9 = null;
                  {
                    final LiteralDecimal lit = CommonFactory.eINSTANCE.createLiteralDecimal();
                    PositiveIntegerValue _positiveIntegerValue = new PositiveIntegerValue(litValue);
                    lit.setDecimal(_positiveIntegerValue);
                    _xblockexpression_9 = lit;
                  }
                  _switchResult = _xblockexpression_9;
                  break;
                case "LiteralFloatType":
                  LiteralFloat _xblockexpression_10 = null;
                  {
                    final LiteralFloat lit = CommonFactory.eINSTANCE.createLiteralFloat();
                    FloatValue _floatValue = new FloatValue(litValue);
                    lit.setFloat(_floatValue);
                    _xblockexpression_10 = lit;
                  }
                  _switchResult = _xblockexpression_10;
                  break;
                case "LiteralRationalType":
                  LiteralRational _xblockexpression_11 = null;
                  {
                    final LiteralRational lit = CommonFactory.eINSTANCE.createLiteralRational();
                    RationalValue _rationalValue = new RationalValue(litValue);
                    lit.setRational(_rationalValue);
                    _xblockexpression_11 = lit;
                  }
                  _switchResult = _xblockexpression_11;
                  break;
                case "LiteralRealType":
                  LiteralReal _xblockexpression_12 = null;
                  {
                    final LiteralReal lit = CommonFactory.eINSTANCE.createLiteralReal();
                    RealValue _realValue = new RealValue(litValue);
                    lit.setReal(_realValue);
                    _xblockexpression_12 = lit;
                  }
                  _switchResult = _xblockexpression_12;
                  break;
                case "":
                  LiteralRawString _xblockexpression_13 = null;
                  {
                    final LiteralRawString lit = CommonFactory.eINSTANCE.createLiteralRawString();
                    RawStringValue _rawStringValue = new RawStringValue(litValue);
                    lit.setString(_rawStringValue);
                    _xblockexpression_13 = lit;
                  }
                  _switchResult = _xblockexpression_13;
                  break;
                default:
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("OMLTables.toLiteralValue(value): unrecognized type: ");
                  _builder.append(litType);
                  _builder.append(" for value: ");
                  _builder.append(value);
                  throw new IllegalArgumentException(_builder.toString());
              }
            } else {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("OMLTables.toLiteralValue(value): unrecognized type: ");
              _builder.append(litType);
              _builder.append(" for value: ");
              _builder.append(value);
              throw new IllegalArgumentException(_builder.toString());
            }
            _xblockexpression_2 = _switchResult;
          }
          _xifexpression_1 = _xblockexpression_2;
        } else {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("OMLTables.toLiteralValue(value): ill-formed value=");
          _builder.append(value);
          throw new IllegalArgumentException(_builder.toString());
        }
        _xblockexpression_1 = _xifexpression_1;
      }
      _xifexpression = _xblockexpression_1;
    }
    return _xifexpression;
  }
  
  public static DescriptionKind toDescriptionKind(final String value) {
    if (value != null) {
      switch (value) {
        case "Partial":
          return DescriptionKind.PARTIAL;
        case "Final":
          return DescriptionKind.FINAL;
        default:
          throw new IllegalArgumentException((value + " is not a legal DescriptionKind"));
      }
    } else {
      throw new IllegalArgumentException((value + " is not a legal DescriptionKind"));
    }
  }
  
  public static TerminologyKind toTerminologyKind(final String value) {
    if (value != null) {
      switch (value) {
        case "OpenWorldDefinitions":
          return TerminologyKind.OPEN_WORLD_DEFINITIONS;
        case "ClosedWorldDesignations":
          return TerminologyKind.CLOSED_WORLD_DESIGNATIONS;
        default:
          throw new IllegalArgumentException((value + " is not a legal TerminologyKind"));
      }
    } else {
      throw new IllegalArgumentException((value + " is not a legal TerminologyKind"));
    }
  }
  
  public static CardinalityRestrictionKind toCardinalityRestrictionKind(final String value) {
    if (value != null) {
      switch (value) {
        case "<=":
          return CardinalityRestrictionKind.MIN;
        case "MinCardinalityRestriction":
          return CardinalityRestrictionKind.MIN;
        case ">=":
          return CardinalityRestrictionKind.MAX;
        case "MaxCardinalityRestriction":
          return CardinalityRestrictionKind.MAX;
        case "==":
          return CardinalityRestrictionKind.EXACT;
        case "ExactCardinalityRestriction":
          return CardinalityRestrictionKind.EXACT;
        default:
          throw new IllegalArgumentException((value + " is not a legal CardinalityRestrictionKind"));
      }
    } else {
      throw new IllegalArgumentException((value + " is not a legal CardinalityRestrictionKind"));
    }
  }
  
  protected static String _toString(final CardinalityRestrictionKind value) {
    String _switchResult = null;
    if (value != null) {
      switch (value) {
        case MIN:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\"<=\"");
          _switchResult = _builder.toString();
          break;
        case MAX:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("\">=\"");
          _switchResult = _builder_1.toString();
          break;
        case EXACT:
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("\"==\"");
          _switchResult = _builder_2.toString();
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  public static String toString(final Object value) {
    if (value instanceof LiteralNumber) {
      return _toString((LiteralNumber)value);
    } else if (value instanceof LiteralString) {
      return _toString((LiteralString)value);
    } else if (value instanceof LiteralURI) {
      return _toString((LiteralURI)value);
    } else if (value instanceof LiteralUUID) {
      return _toString((LiteralUUID)value);
    } else if (value instanceof LiteralValue) {
      return _toString((LiteralValue)value);
    } else if (value instanceof DescriptionKind) {
      return _toString((DescriptionKind)value);
    } else if (value instanceof CardinalityRestrictionKind) {
      return _toString((CardinalityRestrictionKind)value);
    } else if (value instanceof TerminologyKind) {
      return _toString((TerminologyKind)value);
    } else if (value instanceof PositiveIntegerValue) {
      return _toString((PositiveIntegerValue)value);
    } else if (value instanceof String) {
      return _toString((String)value);
    } else if (value instanceof LanguageTagValue) {
      return _toString((LanguageTagValue)value);
    } else if (value instanceof PatternValue) {
      return _toString((PatternValue)value);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(value).toString());
    }
  }
}
