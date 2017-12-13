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
import gov.nasa.jpl.imce.oml.model.terminologies.AspectPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipPropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSourceInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSourcePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipTargetInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipTargetPropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
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
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipPropertyPredicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
  public static List<AnnotationProperty> annotationProperties(final Extent e) {
    List<AnnotationProperty> _xblockexpression = null;
    {
      final List<AnnotationProperty> result = new ArrayList<AnnotationProperty>();
      result.addAll(e.getAnnotationProperties());
      final Function1<AnnotationProperty, String> _function = (AnnotationProperty it) -> {
        return it.uuid();
      };
      ListExtensions.<AnnotationProperty, String>sortInplaceBy(result, _function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<AnnotationPropertyValue> annotationPropertyValues(final Extent e) {
    List<AnnotationPropertyValue> _xblockexpression = null;
    {
      final List<AnnotationPropertyValue> result = new ArrayList<AnnotationPropertyValue>();
      Iterables.<AnnotationPropertyValue>addAll(result, IteratorExtensions.<AnnotationPropertyValue>toIterable(Iterators.<AnnotationPropertyValue>filter(e.eAllContents(), AnnotationPropertyValue.class)));
      final Function1<AnnotationPropertyValue, String> _function = (AnnotationPropertyValue it) -> {
        return it.uuid();
      };
      ListExtensions.<AnnotationPropertyValue, String>sortInplaceBy(result, _function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<TerminologyGraph> terminologyGraphs(final Extent e) {
    List<TerminologyGraph> _xblockexpression = null;
    {
      final List<TerminologyGraph> result = new ArrayList<TerminologyGraph>();
      Iterables.<TerminologyGraph>addAll(result, Iterables.<TerminologyGraph>filter(e.getModules(), TerminologyGraph.class));
      final Function1<TerminologyGraph, String> _function = (TerminologyGraph it) -> {
        return it.uuid();
      };
      ListExtensions.<TerminologyGraph, String>sortInplaceBy(result, _function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<Bundle> bundles(final Extent e) {
    List<Bundle> _xblockexpression = null;
    {
      final List<Bundle> result = new ArrayList<Bundle>();
      Iterables.<Bundle>addAll(result, Iterables.<Bundle>filter(e.getModules(), Bundle.class));
      final Function1<Bundle, String> _function = (Bundle it) -> {
        return it.uuid();
      };
      ListExtensions.<Bundle, String>sortInplaceBy(result, _function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<DescriptionBox> descriptionBoxes(final Extent e) {
    List<DescriptionBox> _xblockexpression = null;
    {
      final List<DescriptionBox> result = new ArrayList<DescriptionBox>();
      Iterables.<DescriptionBox>addAll(result, Iterables.<DescriptionBox>filter(e.getModules(), DescriptionBox.class));
      final Function1<DescriptionBox, String> _function = (DescriptionBox it) -> {
        return it.uuid();
      };
      ListExtensions.<DescriptionBox, String>sortInplaceBy(result, _function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<TerminologyBox> terminologies(final Extent e) {
    List<TerminologyBox> _xblockexpression = null;
    {
      final List<TerminologyBox> result = new ArrayList<TerminologyBox>();
      Iterables.<TerminologyBox>addAll(result, Iterables.<TerminologyBox>filter(e.getModules(), TerminologyBox.class));
      final Function1<TerminologyBox, String> _function = (TerminologyBox it) -> {
        return it.uuid();
      };
      ListExtensions.<TerminologyBox, String>sortInplaceBy(result, _function);
      _xblockexpression = result;
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
      final Function1<TerminologyExtensionAxiom, String> _function_1 = (TerminologyExtensionAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<TerminologyExtensionAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<TerminologyNestingAxiom, String> _function_1 = (TerminologyNestingAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<TerminologyNestingAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ConceptDesignationTerminologyAxiom, String> _function_1 = (ConceptDesignationTerminologyAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<ConceptDesignationTerminologyAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<BundledTerminologyAxiom, String> _function_1 = (BundledTerminologyAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<BundledTerminologyAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<DescriptionBoxExtendsClosedWorldDefinitions, String> _function_1 = (DescriptionBoxExtendsClosedWorldDefinitions it) -> {
        return it.uuid();
      };
      ListExtensions.<DescriptionBoxExtendsClosedWorldDefinitions, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<DescriptionBoxRefinement, String> _function_1 = (DescriptionBoxRefinement it) -> {
        return it.uuid();
      };
      ListExtensions.<DescriptionBoxRefinement, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<Aspect, String> _function_1 = (Aspect it) -> {
        return it.uuid();
      };
      ListExtensions.<Aspect, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<Concept, String> _function_1 = (Concept it) -> {
        return it.uuid();
      };
      ListExtensions.<Concept, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ReifiedRelationship, String> _function_1 = (ReifiedRelationship it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationship, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<UnreifiedRelationship, String> _function_1 = (UnreifiedRelationship it) -> {
        return it.uuid();
      };
      ListExtensions.<UnreifiedRelationship, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<Scalar, String> _function_1 = (Scalar it) -> {
        return it.uuid();
      };
      ListExtensions.<Scalar, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<Structure, String> _function_1 = (Structure it) -> {
        return it.uuid();
      };
      ListExtensions.<Structure, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<BinaryScalarRestriction, String> _function_1 = (BinaryScalarRestriction it) -> {
        return it.uuid();
      };
      ListExtensions.<BinaryScalarRestriction, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<IRIScalarRestriction, String> _function_1 = (IRIScalarRestriction it) -> {
        return it.uuid();
      };
      ListExtensions.<IRIScalarRestriction, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<NumericScalarRestriction, String> _function_1 = (NumericScalarRestriction it) -> {
        return it.uuid();
      };
      ListExtensions.<NumericScalarRestriction, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<PlainLiteralScalarRestriction, String> _function_1 = (PlainLiteralScalarRestriction it) -> {
        return it.uuid();
      };
      ListExtensions.<PlainLiteralScalarRestriction, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ScalarOneOfRestriction, String> _function_1 = (ScalarOneOfRestriction it) -> {
        return it.uuid();
      };
      ListExtensions.<ScalarOneOfRestriction, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ScalarOneOfLiteralAxiom, String> _function_1 = (ScalarOneOfLiteralAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<ScalarOneOfLiteralAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<StringScalarRestriction, String> _function_1 = (StringScalarRestriction it) -> {
        return it.uuid();
      };
      ListExtensions.<StringScalarRestriction, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<SynonymScalarRestriction, String> _function_1 = (SynonymScalarRestriction it) -> {
        return it.uuid();
      };
      ListExtensions.<SynonymScalarRestriction, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<TimeScalarRestriction, String> _function_1 = (TimeScalarRestriction it) -> {
        return it.uuid();
      };
      ListExtensions.<TimeScalarRestriction, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<EntityScalarDataProperty, String> _function_1 = (EntityScalarDataProperty it) -> {
        return it.uuid();
      };
      ListExtensions.<EntityScalarDataProperty, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<EntityStructuredDataProperty, String> _function_1 = (EntityStructuredDataProperty it) -> {
        return it.uuid();
      };
      ListExtensions.<EntityStructuredDataProperty, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ScalarDataProperty, String> _function_1 = (ScalarDataProperty it) -> {
        return it.uuid();
      };
      ListExtensions.<ScalarDataProperty, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<StructuredDataProperty, String> _function_1 = (StructuredDataProperty it) -> {
        return it.uuid();
      };
      ListExtensions.<StructuredDataProperty, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<AspectSpecializationAxiom, String> _function_1 = (AspectSpecializationAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<AspectSpecializationAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ConceptSpecializationAxiom, String> _function_1 = (ConceptSpecializationAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<ConceptSpecializationAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ReifiedRelationshipSpecializationAxiom, String> _function_1 = (ReifiedRelationshipSpecializationAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipSpecializationAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<SubDataPropertyOfAxiom, String> _function_1 = (SubDataPropertyOfAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<SubDataPropertyOfAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<SubObjectPropertyOfAxiom, String> _function_1 = (SubObjectPropertyOfAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<SubObjectPropertyOfAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<EntityExistentialRestrictionAxiom, String> _function_1 = (EntityExistentialRestrictionAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<EntityExistentialRestrictionAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<EntityUniversalRestrictionAxiom, String> _function_1 = (EntityUniversalRestrictionAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<EntityUniversalRestrictionAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<EntityScalarDataPropertyExistentialRestrictionAxiom, String> _function_1 = (EntityScalarDataPropertyExistentialRestrictionAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<EntityScalarDataPropertyExistentialRestrictionAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<EntityScalarDataPropertyParticularRestrictionAxiom, String> _function_1 = (EntityScalarDataPropertyParticularRestrictionAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<EntityScalarDataPropertyParticularRestrictionAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<EntityScalarDataPropertyUniversalRestrictionAxiom, String> _function_1 = (EntityScalarDataPropertyUniversalRestrictionAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<EntityScalarDataPropertyUniversalRestrictionAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<EntityStructuredDataPropertyParticularRestrictionAxiom, String> _function_1 = (EntityStructuredDataPropertyParticularRestrictionAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<EntityStructuredDataPropertyParticularRestrictionAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<RootConceptTaxonomyAxiom, String> _function_1 = (RootConceptTaxonomyAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<RootConceptTaxonomyAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<SpecificDisjointConceptAxiom, String> _function_1 = (SpecificDisjointConceptAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<SpecificDisjointConceptAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<AnonymousConceptUnionAxiom, String> _function_1 = (AnonymousConceptUnionAxiom it) -> {
        return it.uuid();
      };
      ListExtensions.<AnonymousConceptUnionAxiom, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ChainRule, String> _function_1 = (ChainRule it) -> {
        return it.uuid();
      };
      ListExtensions.<ChainRule, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<RuleBodySegment, String> _function_1 = (RuleBodySegment it) -> {
        return it.uuid();
      };
      ListExtensions.<RuleBodySegment, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<AspectPredicate> aspectPredicates(final Extent e) {
    List<AspectPredicate> _xblockexpression = null;
    {
      final List<AspectPredicate> result = new ArrayList<AspectPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<AspectPredicate>addAll(result, Iterables.<AspectPredicate>filter(r.allNestedElements(), AspectPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<AspectPredicate, String> _function_1 = (AspectPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<AspectPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<ConceptPredicate> conceptPredicates(final Extent e) {
    List<ConceptPredicate> _xblockexpression = null;
    {
      final List<ConceptPredicate> result = new ArrayList<ConceptPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<ConceptPredicate>addAll(result, Iterables.<ConceptPredicate>filter(r.allNestedElements(), ConceptPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<ConceptPredicate, String> _function_1 = (ConceptPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<ConceptPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipInversePropertyPredicate> reifiedRelationshipInversePropertyPredicates(final Extent e) {
    List<ReifiedRelationshipInversePropertyPredicate> _xblockexpression = null;
    {
      final List<ReifiedRelationshipInversePropertyPredicate> result = new ArrayList<ReifiedRelationshipInversePropertyPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<ReifiedRelationshipInversePropertyPredicate>addAll(result, Iterables.<ReifiedRelationshipInversePropertyPredicate>filter(r.allNestedElements(), ReifiedRelationshipInversePropertyPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<ReifiedRelationshipInversePropertyPredicate, String> _function_1 = (ReifiedRelationshipInversePropertyPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipInversePropertyPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipPredicate> reifiedRelationshipPredicates(final Extent e) {
    List<ReifiedRelationshipPredicate> _xblockexpression = null;
    {
      final List<ReifiedRelationshipPredicate> result = new ArrayList<ReifiedRelationshipPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<ReifiedRelationshipPredicate>addAll(result, Iterables.<ReifiedRelationshipPredicate>filter(r.allNestedElements(), ReifiedRelationshipPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<ReifiedRelationshipPredicate, String> _function_1 = (ReifiedRelationshipPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipPropertyPredicate> reifiedRelationshipPropertyPredicates(final Extent e) {
    List<ReifiedRelationshipPropertyPredicate> _xblockexpression = null;
    {
      final List<ReifiedRelationshipPropertyPredicate> result = new ArrayList<ReifiedRelationshipPropertyPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<ReifiedRelationshipPropertyPredicate>addAll(result, Iterables.<ReifiedRelationshipPropertyPredicate>filter(r.allNestedElements(), ReifiedRelationshipPropertyPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<ReifiedRelationshipPropertyPredicate, String> _function_1 = (ReifiedRelationshipPropertyPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipPropertyPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipSourceInversePropertyPredicate> reifiedRelationshipSourceInversePropertyPredicates(final Extent e) {
    List<ReifiedRelationshipSourceInversePropertyPredicate> _xblockexpression = null;
    {
      final List<ReifiedRelationshipSourceInversePropertyPredicate> result = new ArrayList<ReifiedRelationshipSourceInversePropertyPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<ReifiedRelationshipSourceInversePropertyPredicate>addAll(result, Iterables.<ReifiedRelationshipSourceInversePropertyPredicate>filter(r.allNestedElements(), ReifiedRelationshipSourceInversePropertyPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<ReifiedRelationshipSourceInversePropertyPredicate, String> _function_1 = (ReifiedRelationshipSourceInversePropertyPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipSourceInversePropertyPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipSourcePropertyPredicate> reifiedRelationshipSourcePropertyPredicates(final Extent e) {
    List<ReifiedRelationshipSourcePropertyPredicate> _xblockexpression = null;
    {
      final List<ReifiedRelationshipSourcePropertyPredicate> result = new ArrayList<ReifiedRelationshipSourcePropertyPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<ReifiedRelationshipSourcePropertyPredicate>addAll(result, Iterables.<ReifiedRelationshipSourcePropertyPredicate>filter(r.allNestedElements(), ReifiedRelationshipSourcePropertyPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<ReifiedRelationshipSourcePropertyPredicate, String> _function_1 = (ReifiedRelationshipSourcePropertyPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipSourcePropertyPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipTargetInversePropertyPredicate> reifiedRelationshipTargetInversePropertyPredicates(final Extent e) {
    List<ReifiedRelationshipTargetInversePropertyPredicate> _xblockexpression = null;
    {
      final List<ReifiedRelationshipTargetInversePropertyPredicate> result = new ArrayList<ReifiedRelationshipTargetInversePropertyPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<ReifiedRelationshipTargetInversePropertyPredicate>addAll(result, Iterables.<ReifiedRelationshipTargetInversePropertyPredicate>filter(r.allNestedElements(), ReifiedRelationshipTargetInversePropertyPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<ReifiedRelationshipTargetInversePropertyPredicate, String> _function_1 = (ReifiedRelationshipTargetInversePropertyPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipTargetInversePropertyPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<ReifiedRelationshipTargetPropertyPredicate> reifiedRelationshipTargetPropertyPredicates(final Extent e) {
    List<ReifiedRelationshipTargetPropertyPredicate> _xblockexpression = null;
    {
      final List<ReifiedRelationshipTargetPropertyPredicate> result = new ArrayList<ReifiedRelationshipTargetPropertyPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<ReifiedRelationshipTargetPropertyPredicate>addAll(result, Iterables.<ReifiedRelationshipTargetPropertyPredicate>filter(r.allNestedElements(), ReifiedRelationshipTargetPropertyPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<ReifiedRelationshipTargetPropertyPredicate, String> _function_1 = (ReifiedRelationshipTargetPropertyPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipTargetPropertyPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<UnreifiedRelationshipInversePropertyPredicate> unreifiedRelationshipInversePropertyPredicates(final Extent e) {
    List<UnreifiedRelationshipInversePropertyPredicate> _xblockexpression = null;
    {
      final List<UnreifiedRelationshipInversePropertyPredicate> result = new ArrayList<UnreifiedRelationshipInversePropertyPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<UnreifiedRelationshipInversePropertyPredicate>addAll(result, Iterables.<UnreifiedRelationshipInversePropertyPredicate>filter(r.allNestedElements(), UnreifiedRelationshipInversePropertyPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<UnreifiedRelationshipInversePropertyPredicate, String> _function_1 = (UnreifiedRelationshipInversePropertyPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<UnreifiedRelationshipInversePropertyPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static List<UnreifiedRelationshipPropertyPredicate> unreifiedRelationshipPropertyPredicates(final Extent e) {
    List<UnreifiedRelationshipPropertyPredicate> _xblockexpression = null;
    {
      final List<UnreifiedRelationshipPropertyPredicate> result = new ArrayList<UnreifiedRelationshipPropertyPredicate>();
      final Consumer<TerminologyGraph> _function = (TerminologyGraph b) -> {
        final Consumer<ChainRule> _function_1 = (ChainRule r) -> {
          Iterables.<UnreifiedRelationshipPropertyPredicate>addAll(result, Iterables.<UnreifiedRelationshipPropertyPredicate>filter(r.allNestedElements(), UnreifiedRelationshipPropertyPredicate.class));
        };
        Iterables.<ChainRule>filter(b.getBoxStatements(), ChainRule.class).forEach(_function_1);
      };
      OMLTables.terminologyGraphs(e).forEach(_function);
      final Function1<UnreifiedRelationshipPropertyPredicate, String> _function_1 = (UnreifiedRelationshipPropertyPredicate it) -> {
        return it.uuid();
      };
      ListExtensions.<UnreifiedRelationshipPropertyPredicate, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ConceptInstance, String> _function_1 = (ConceptInstance it) -> {
        return it.uuid();
      };
      ListExtensions.<ConceptInstance, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ReifiedRelationshipInstance, String> _function_1 = (ReifiedRelationshipInstance it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipInstance, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ReifiedRelationshipInstanceDomain, String> _function_1 = (ReifiedRelationshipInstanceDomain it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipInstanceDomain, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ReifiedRelationshipInstanceRange, String> _function_1 = (ReifiedRelationshipInstanceRange it) -> {
        return it.uuid();
      };
      ListExtensions.<ReifiedRelationshipInstanceRange, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<RestrictionScalarDataPropertyValue, String> _function_1 = (RestrictionScalarDataPropertyValue it) -> {
        return it.uuid();
      };
      ListExtensions.<RestrictionScalarDataPropertyValue, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<RestrictionStructuredDataPropertyTuple, String> _function_1 = (RestrictionStructuredDataPropertyTuple it) -> {
        return it.uuid();
      };
      ListExtensions.<RestrictionStructuredDataPropertyTuple, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<ScalarDataPropertyValue, String> _function_1 = (ScalarDataPropertyValue it) -> {
        return it.uuid();
      };
      ListExtensions.<ScalarDataPropertyValue, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<SingletonInstanceScalarDataPropertyValue, String> _function_1 = (SingletonInstanceScalarDataPropertyValue it) -> {
        return it.uuid();
      };
      ListExtensions.<SingletonInstanceScalarDataPropertyValue, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<SingletonInstanceStructuredDataPropertyValue, String> _function_1 = (SingletonInstanceStructuredDataPropertyValue it) -> {
        return it.uuid();
      };
      ListExtensions.<SingletonInstanceStructuredDataPropertyValue, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<StructuredDataPropertyTuple, String> _function_1 = (StructuredDataPropertyTuple it) -> {
        return it.uuid();
      };
      ListExtensions.<StructuredDataPropertyTuple, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
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
      final Function1<UnreifiedRelationshipInstanceTuple, String> _function_1 = (UnreifiedRelationshipInstanceTuple it) -> {
        return it.uuid();
      };
      ListExtensions.<UnreifiedRelationshipInstanceTuple, String>sortInplaceBy(result, _function_1);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected static String _toString(final String value) {
    String _replaceAll = value.replaceAll("\"", "\\\"");
    String _plus = ("\"" + _replaceAll);
    return (_plus + "\"");
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
      _builder.append("{\"literalType\":\"LiteralBooleanType\",\"value\":\"");
      String _value = ((LiteralBoolean)value).value();
      _builder.append(_value);
      _builder.append("\"}");
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
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{\"literalType\":\"LiteralStringType\",\"value\":\"");
        String _value = ((LiteralString)value).value();
        _builder.append(_value);
        _builder.append("\"}");
        _switchResult = _builder.toString();
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
  
  protected final static Pattern LiteralNumberOrValue = Pattern.compile("\\{\"literalType\":\"(.*)\",\"value\":\"(.*)\"\\}");
  
  public static LiteralNumber toLiteralNumber(final String value) {
    LiteralNumber _xblockexpression = null;
    {
      final Matcher m = OMLTables.LiteralNumberOrValue.matcher(value);
      LiteralNumber _xifexpression = null;
      boolean _find = m.find();
      if (_find) {
        LiteralNumber _xblockexpression_1 = null;
        {
          final String litType = m.group(1);
          final String litValue = m.group(2);
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
    LiteralValue _xblockexpression = null;
    {
      final Matcher m = OMLTables.LiteralNumberOrValue.matcher(value);
      LiteralValue _xifexpression = null;
      boolean _find = m.find();
      if (_find) {
        LiteralValue _xblockexpression_1 = null;
        {
          final String litType = m.group(1);
          final String litValue = m.group(2);
          LiteralValue _switchResult = null;
          if (litType != null) {
            switch (litType) {
              case "LiteralBooleanType":
                LiteralBoolean _xblockexpression_2 = null;
                {
                  final LiteralBoolean lit = CommonFactory.eINSTANCE.createLiteralBoolean();
                  lit.setBool(Boolean.parseBoolean(litValue));
                  _xblockexpression_2 = lit;
                }
                _switchResult = _xblockexpression_2;
                break;
              case "LiteralDateTimeType":
                LiteralDateTime _xblockexpression_3 = null;
                {
                  final LiteralDateTime lit = CommonFactory.eINSTANCE.createLiteralDateTime();
                  DateTimeValue _dateTimeValue = new DateTimeValue(litValue);
                  lit.setDateTime(_dateTimeValue);
                  _xblockexpression_3 = lit;
                }
                _switchResult = _xblockexpression_3;
                break;
              case "LiteralStringType":
                LiteralRawString _xblockexpression_4 = null;
                {
                  final LiteralRawString lit = CommonFactory.eINSTANCE.createLiteralRawString();
                  RawStringValue _rawStringValue = new RawStringValue(litValue);
                  lit.setString(_rawStringValue);
                  _xblockexpression_4 = lit;
                }
                _switchResult = _xblockexpression_4;
                break;
              case "LiteralUUIDType":
                LiteralRawString _xblockexpression_5 = null;
                {
                  final LiteralRawString lit = CommonFactory.eINSTANCE.createLiteralRawString();
                  RawStringValue _rawStringValue = new RawStringValue(litValue);
                  lit.setString(_rawStringValue);
                  _xblockexpression_5 = lit;
                }
                _switchResult = _xblockexpression_5;
                break;
              case "LiteralURIType":
                LiteralURI _xblockexpression_6 = null;
                {
                  final LiteralURI lit = CommonFactory.eINSTANCE.createLiteralURI();
                  URIValue _uRIValue = new URIValue(litValue);
                  lit.setUri(_uRIValue);
                  _xblockexpression_6 = lit;
                }
                _switchResult = _xblockexpression_6;
                break;
              case "LiteralDecimalType":
                LiteralDecimal _xblockexpression_7 = null;
                {
                  final LiteralDecimal lit = CommonFactory.eINSTANCE.createLiteralDecimal();
                  DecimalValue _decimalValue = new DecimalValue(litValue);
                  lit.setDecimal(_decimalValue);
                  _xblockexpression_7 = lit;
                }
                _switchResult = _xblockexpression_7;
                break;
              case "LiteralPositiveIntegerType":
                LiteralDecimal _xblockexpression_8 = null;
                {
                  final LiteralDecimal lit = CommonFactory.eINSTANCE.createLiteralDecimal();
                  PositiveIntegerValue _positiveIntegerValue = new PositiveIntegerValue(litValue);
                  lit.setDecimal(_positiveIntegerValue);
                  _xblockexpression_8 = lit;
                }
                _switchResult = _xblockexpression_8;
                break;
              case "LiteralFloatType":
                LiteralFloat _xblockexpression_9 = null;
                {
                  final LiteralFloat lit = CommonFactory.eINSTANCE.createLiteralFloat();
                  FloatValue _floatValue = new FloatValue(litValue);
                  lit.setFloat(_floatValue);
                  _xblockexpression_9 = lit;
                }
                _switchResult = _xblockexpression_9;
                break;
              case "LiteralRationalType":
                LiteralRational _xblockexpression_10 = null;
                {
                  final LiteralRational lit = CommonFactory.eINSTANCE.createLiteralRational();
                  RationalValue _rationalValue = new RationalValue(litValue);
                  lit.setRational(_rationalValue);
                  _xblockexpression_10 = lit;
                }
                _switchResult = _xblockexpression_10;
                break;
              case "LiteralRealType":
                LiteralReal _xblockexpression_11 = null;
                {
                  final LiteralReal lit = CommonFactory.eINSTANCE.createLiteralReal();
                  RealValue _realValue = new RealValue(litValue);
                  lit.setReal(_realValue);
                  _xblockexpression_11 = lit;
                }
                _switchResult = _xblockexpression_11;
                break;
              default:
                throw new IllegalArgumentException(("OMLTables.toLiteralValue(value): unrecognized type: " + litType));
            }
          } else {
            throw new IllegalArgumentException(("OMLTables.toLiteralValue(value): unrecognized type: " + litType));
          }
          _xblockexpression_1 = _switchResult;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        throw new IllegalArgumentException(("OMLTables.toLiteralValue(value): ill-formed value=" + value));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
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
  
  public static String toString(final Object value) {
    if (value instanceof LiteralNumber) {
      return _toString((LiteralNumber)value);
    } else if (value instanceof LiteralValue) {
      return _toString((LiteralValue)value);
    } else if (value instanceof DescriptionKind) {
      return _toString((DescriptionKind)value);
    } else if (value instanceof TerminologyKind) {
      return _toString((TerminologyKind)value);
    } else if (value instanceof PositiveIntegerValue) {
      return _toString((PositiveIntegerValue)value);
    } else if (value instanceof String) {
      return _toString((String)value);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(value).toString());
    }
  }
}
