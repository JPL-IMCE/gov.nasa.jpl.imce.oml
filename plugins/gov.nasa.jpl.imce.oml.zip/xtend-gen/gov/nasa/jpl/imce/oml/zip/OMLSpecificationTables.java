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
package gov.nasa.jpl.imce.oml.zip;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesFactory;
import gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction;
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.extensions.OMLTables;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectKind;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedAspect;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedConcept;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptKind;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
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
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
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
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import gov.nasa.jpl.imce.oml.zip.OMLZipResource;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @generated
 */
@SuppressWarnings("all")
public class OMLSpecificationTables {
  protected final Map<String, Pair<TerminologyGraph, Map<String, String>>> terminologyGraphs;
  
  protected final Map<String, Pair<Bundle, Map<String, String>>> bundles;
  
  protected final Map<String, Pair<DescriptionBox, Map<String, String>>> descriptionBoxes;
  
  protected final Map<String, Pair<AnnotationProperty, Map<String, String>>> annotationProperties;
  
  protected final Map<String, Pair<Aspect, Map<String, String>>> aspects;
  
  protected final Map<String, Pair<Concept, Map<String, String>>> concepts;
  
  protected final Map<String, Pair<Scalar, Map<String, String>>> scalars;
  
  protected final Map<String, Pair<Structure, Map<String, String>>> structures;
  
  protected final Map<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>> conceptDesignationTerminologyAxioms;
  
  protected final Map<String, Pair<TerminologyExtensionAxiom, Map<String, String>>> terminologyExtensionAxioms;
  
  protected final Map<String, Pair<TerminologyNestingAxiom, Map<String, String>>> terminologyNestingAxioms;
  
  protected final Map<String, Pair<BundledTerminologyAxiom, Map<String, String>>> bundledTerminologyAxioms;
  
  protected final Map<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>> descriptionBoxExtendsClosedWorldDefinitions;
  
  protected final Map<String, Pair<DescriptionBoxRefinement, Map<String, String>>> descriptionBoxRefinements;
  
  protected final Map<String, Pair<BinaryScalarRestriction, Map<String, String>>> binaryScalarRestrictions;
  
  protected final Map<String, Pair<IRIScalarRestriction, Map<String, String>>> iriScalarRestrictions;
  
  protected final Map<String, Pair<NumericScalarRestriction, Map<String, String>>> numericScalarRestrictions;
  
  protected final Map<String, Pair<PlainLiteralScalarRestriction, Map<String, String>>> plainLiteralScalarRestrictions;
  
  protected final Map<String, Pair<ScalarOneOfRestriction, Map<String, String>>> scalarOneOfRestrictions;
  
  protected final Map<String, Pair<ScalarOneOfLiteralAxiom, Map<String, String>>> scalarOneOfLiteralAxioms;
  
  protected final Map<String, Pair<StringScalarRestriction, Map<String, String>>> stringScalarRestrictions;
  
  protected final Map<String, Pair<SynonymScalarRestriction, Map<String, String>>> synonymScalarRestrictions;
  
  protected final Map<String, Pair<TimeScalarRestriction, Map<String, String>>> timeScalarRestrictions;
  
  protected final Map<String, Pair<EntityScalarDataProperty, Map<String, String>>> entityScalarDataProperties;
  
  protected final Map<String, Pair<EntityStructuredDataProperty, Map<String, String>>> entityStructuredDataProperties;
  
  protected final Map<String, Pair<ScalarDataProperty, Map<String, String>>> scalarDataProperties;
  
  protected final Map<String, Pair<StructuredDataProperty, Map<String, String>>> structuredDataProperties;
  
  protected final Map<String, Pair<ReifiedRelationship, Map<String, String>>> reifiedRelationships;
  
  protected final Map<String, Pair<ReifiedRelationshipRestriction, Map<String, String>>> reifiedRelationshipRestrictions;
  
  protected final Map<String, Pair<ForwardProperty, Map<String, String>>> forwardProperties;
  
  protected final Map<String, Pair<InverseProperty, Map<String, String>>> inverseProperties;
  
  protected final Map<String, Pair<UnreifiedRelationship, Map<String, String>>> unreifiedRelationships;
  
  protected final Map<String, Pair<ChainRule, Map<String, String>>> chainRules;
  
  protected final Map<String, Pair<RuleBodySegment, Map<String, String>>> ruleBodySegments;
  
  protected final Map<String, Pair<SegmentPredicate, Map<String, String>>> segmentPredicates;
  
  protected final Map<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>> entityExistentialRestrictionAxioms;
  
  protected final Map<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>> entityUniversalRestrictionAxioms;
  
  protected final Map<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>> entityScalarDataPropertyExistentialRestrictionAxioms;
  
  protected final Map<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>> entityScalarDataPropertyParticularRestrictionAxioms;
  
  protected final Map<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>> entityScalarDataPropertyUniversalRestrictionAxioms;
  
  protected final Map<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>> entityStructuredDataPropertyParticularRestrictionAxioms;
  
  protected final Map<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>> restrictionStructuredDataPropertyTuples;
  
  protected final Map<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>> restrictionScalarDataPropertyValues;
  
  protected final Map<String, Pair<AspectSpecializationAxiom, Map<String, String>>> aspectSpecializationAxioms;
  
  protected final Map<String, Pair<ConceptSpecializationAxiom, Map<String, String>>> conceptSpecializationAxioms;
  
  protected final Map<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>> reifiedRelationshipSpecializationAxioms;
  
  protected final Map<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>> subDataPropertyOfAxioms;
  
  protected final Map<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>> subObjectPropertyOfAxioms;
  
  protected final Map<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>> rootConceptTaxonomyAxioms;
  
  protected final Map<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>> anonymousConceptUnionAxioms;
  
  protected final Map<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>> specificDisjointConceptAxioms;
  
  protected final Map<String, Pair<ConceptInstance, Map<String, String>>> conceptInstances;
  
  protected final Map<String, Pair<ReifiedRelationshipInstance, Map<String, String>>> reifiedRelationshipInstances;
  
  protected final Map<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>> reifiedRelationshipInstanceDomains;
  
  protected final Map<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>> reifiedRelationshipInstanceRanges;
  
  protected final Map<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>> unreifiedRelationshipInstanceTuples;
  
  protected final Map<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>> singletonInstanceStructuredDataPropertyValues;
  
  protected final Map<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>> singletonInstanceScalarDataPropertyValues;
  
  protected final Map<String, Pair<StructuredDataPropertyTuple, Map<String, String>>> structuredDataPropertyTuples;
  
  protected final Map<String, Pair<ScalarDataPropertyValue, Map<String, String>>> scalarDataPropertyValues;
  
  protected final Map<String, Pair<AnnotationPropertyValue, Map<String, String>>> annotationPropertyValues;
  
  protected final Map<String, Pair<CardinalityRestrictedAspect, Map<String, String>>> cardinalityRestrictedAspects;
  
  protected final Map<String, Pair<CardinalityRestrictedConcept, Map<String, String>>> cardinalityRestrictedConcepts;
  
  protected final Map<String, Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>>> cardinalityRestrictedReifiedRelationships;
  
  protected final Map<String, Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>>> modules;
  
  protected final Map<String, Pair<LogicalElement, Map<String, String>>> logicalElements;
  
  protected final Map<String, Pair<Entity, Map<String, String>>> entities;
  
  protected final Map<String, Pair<AspectKind, Map<String, String>>> aspectKinds;
  
  protected final Map<String, Pair<ConceptKind, Map<String, String>>> conceptKinds;
  
  protected final Map<String, Pair<EntityRelationship, Map<String, String>>> entityRelationships;
  
  protected final Map<String, Pair<ConceptualRelationship, Map<String, String>>> conceptualRelationships;
  
  protected final Map<String, Pair<DataRange, Map<String, String>>> dataRanges;
  
  protected final Map<String, Pair<DataRelationshipToScalar, Map<String, String>>> dataRelationshipToScalars;
  
  protected final Map<String, Pair<DataRelationshipToStructure, Map<String, String>>> dataRelationshipToStructures;
  
  protected final Map<String, Pair<Predicate, Map<String, String>>> predicates;
  
  protected final Map<String, Pair<RestrictableRelationship, Map<String, String>>> restrictableRelationships;
  
  protected final Map<String, Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>> restrictionStructuredDataPropertyContexts;
  
  protected final Map<String, Pair<TerminologyBox, Map<String, String>>> terminologyBoxes;
  
  protected final Map<String, Pair<ConceptTreeDisjunction, Map<String, String>>> conceptTreeDisjunctions;
  
  protected final Map<String, Pair<ConceptualEntitySingletonInstance, Map<String, String>>> conceptualEntitySingletonInstances;
  
  protected final Map<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>> singletonInstanceStructuredDataPropertyContexts;
  
  @Extension
  private CommonFactory omlCommonFactory;
  
  @Extension
  private TerminologiesFactory omlTerminologiesFactory;
  
  @Extension
  private GraphsFactory omlGraphsFactory;
  
  @Extension
  private BundlesFactory omlBundlesFactory;
  
  @Extension
  private DescriptionsFactory omlDescriptionsFactory;
  
  protected final Queue<String> iriLoadQueue;
  
  protected final Set<String> visitedIRIs;
  
  protected final Queue<gov.nasa.jpl.imce.oml.model.common.Module> moduleQueue;
  
  protected final Set<gov.nasa.jpl.imce.oml.model.common.Module> visitedModules;
  
  protected final Map<String, gov.nasa.jpl.imce.oml.model.common.Module> iri2module;
  
  public OMLSpecificationTables() {
    LinkedList<String> _linkedList = new LinkedList<String>();
    this.iriLoadQueue = _linkedList;
    HashSet<String> _hashSet = new HashSet<String>();
    this.visitedIRIs = _hashSet;
    LinkedList<gov.nasa.jpl.imce.oml.model.common.Module> _linkedList_1 = new LinkedList<gov.nasa.jpl.imce.oml.model.common.Module>();
    this.moduleQueue = _linkedList_1;
    HashSet<gov.nasa.jpl.imce.oml.model.common.Module> _hashSet_1 = new HashSet<gov.nasa.jpl.imce.oml.model.common.Module>();
    this.visitedModules = _hashSet_1;
    HashMap<String, gov.nasa.jpl.imce.oml.model.common.Module> _hashMap = new HashMap<String, gov.nasa.jpl.imce.oml.model.common.Module>();
    this.iri2module = _hashMap;
    this.omlCommonFactory = CommonFactory.eINSTANCE;
    this.omlTerminologiesFactory = TerminologiesFactory.eINSTANCE;
    this.omlGraphsFactory = GraphsFactory.eINSTANCE;
    this.omlBundlesFactory = BundlesFactory.eINSTANCE;
    this.omlDescriptionsFactory = DescriptionsFactory.eINSTANCE;
    HashMap<String, Pair<TerminologyGraph, Map<String, String>>> _hashMap_1 = new HashMap<String, Pair<TerminologyGraph, Map<String, String>>>();
    this.terminologyGraphs = _hashMap_1;
    HashMap<String, Pair<Bundle, Map<String, String>>> _hashMap_2 = new HashMap<String, Pair<Bundle, Map<String, String>>>();
    this.bundles = _hashMap_2;
    HashMap<String, Pair<DescriptionBox, Map<String, String>>> _hashMap_3 = new HashMap<String, Pair<DescriptionBox, Map<String, String>>>();
    this.descriptionBoxes = _hashMap_3;
    HashMap<String, Pair<AnnotationProperty, Map<String, String>>> _hashMap_4 = new HashMap<String, Pair<AnnotationProperty, Map<String, String>>>();
    this.annotationProperties = _hashMap_4;
    HashMap<String, Pair<Aspect, Map<String, String>>> _hashMap_5 = new HashMap<String, Pair<Aspect, Map<String, String>>>();
    this.aspects = _hashMap_5;
    HashMap<String, Pair<Concept, Map<String, String>>> _hashMap_6 = new HashMap<String, Pair<Concept, Map<String, String>>>();
    this.concepts = _hashMap_6;
    HashMap<String, Pair<Scalar, Map<String, String>>> _hashMap_7 = new HashMap<String, Pair<Scalar, Map<String, String>>>();
    this.scalars = _hashMap_7;
    HashMap<String, Pair<Structure, Map<String, String>>> _hashMap_8 = new HashMap<String, Pair<Structure, Map<String, String>>>();
    this.structures = _hashMap_8;
    HashMap<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>> _hashMap_9 = new HashMap<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>>();
    this.conceptDesignationTerminologyAxioms = _hashMap_9;
    HashMap<String, Pair<TerminologyExtensionAxiom, Map<String, String>>> _hashMap_10 = new HashMap<String, Pair<TerminologyExtensionAxiom, Map<String, String>>>();
    this.terminologyExtensionAxioms = _hashMap_10;
    HashMap<String, Pair<TerminologyNestingAxiom, Map<String, String>>> _hashMap_11 = new HashMap<String, Pair<TerminologyNestingAxiom, Map<String, String>>>();
    this.terminologyNestingAxioms = _hashMap_11;
    HashMap<String, Pair<BundledTerminologyAxiom, Map<String, String>>> _hashMap_12 = new HashMap<String, Pair<BundledTerminologyAxiom, Map<String, String>>>();
    this.bundledTerminologyAxioms = _hashMap_12;
    HashMap<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>> _hashMap_13 = new HashMap<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>>();
    this.descriptionBoxExtendsClosedWorldDefinitions = _hashMap_13;
    HashMap<String, Pair<DescriptionBoxRefinement, Map<String, String>>> _hashMap_14 = new HashMap<String, Pair<DescriptionBoxRefinement, Map<String, String>>>();
    this.descriptionBoxRefinements = _hashMap_14;
    HashMap<String, Pair<BinaryScalarRestriction, Map<String, String>>> _hashMap_15 = new HashMap<String, Pair<BinaryScalarRestriction, Map<String, String>>>();
    this.binaryScalarRestrictions = _hashMap_15;
    HashMap<String, Pair<IRIScalarRestriction, Map<String, String>>> _hashMap_16 = new HashMap<String, Pair<IRIScalarRestriction, Map<String, String>>>();
    this.iriScalarRestrictions = _hashMap_16;
    HashMap<String, Pair<NumericScalarRestriction, Map<String, String>>> _hashMap_17 = new HashMap<String, Pair<NumericScalarRestriction, Map<String, String>>>();
    this.numericScalarRestrictions = _hashMap_17;
    HashMap<String, Pair<PlainLiteralScalarRestriction, Map<String, String>>> _hashMap_18 = new HashMap<String, Pair<PlainLiteralScalarRestriction, Map<String, String>>>();
    this.plainLiteralScalarRestrictions = _hashMap_18;
    HashMap<String, Pair<ScalarOneOfRestriction, Map<String, String>>> _hashMap_19 = new HashMap<String, Pair<ScalarOneOfRestriction, Map<String, String>>>();
    this.scalarOneOfRestrictions = _hashMap_19;
    HashMap<String, Pair<ScalarOneOfLiteralAxiom, Map<String, String>>> _hashMap_20 = new HashMap<String, Pair<ScalarOneOfLiteralAxiom, Map<String, String>>>();
    this.scalarOneOfLiteralAxioms = _hashMap_20;
    HashMap<String, Pair<StringScalarRestriction, Map<String, String>>> _hashMap_21 = new HashMap<String, Pair<StringScalarRestriction, Map<String, String>>>();
    this.stringScalarRestrictions = _hashMap_21;
    HashMap<String, Pair<SynonymScalarRestriction, Map<String, String>>> _hashMap_22 = new HashMap<String, Pair<SynonymScalarRestriction, Map<String, String>>>();
    this.synonymScalarRestrictions = _hashMap_22;
    HashMap<String, Pair<TimeScalarRestriction, Map<String, String>>> _hashMap_23 = new HashMap<String, Pair<TimeScalarRestriction, Map<String, String>>>();
    this.timeScalarRestrictions = _hashMap_23;
    HashMap<String, Pair<EntityScalarDataProperty, Map<String, String>>> _hashMap_24 = new HashMap<String, Pair<EntityScalarDataProperty, Map<String, String>>>();
    this.entityScalarDataProperties = _hashMap_24;
    HashMap<String, Pair<EntityStructuredDataProperty, Map<String, String>>> _hashMap_25 = new HashMap<String, Pair<EntityStructuredDataProperty, Map<String, String>>>();
    this.entityStructuredDataProperties = _hashMap_25;
    HashMap<String, Pair<ScalarDataProperty, Map<String, String>>> _hashMap_26 = new HashMap<String, Pair<ScalarDataProperty, Map<String, String>>>();
    this.scalarDataProperties = _hashMap_26;
    HashMap<String, Pair<StructuredDataProperty, Map<String, String>>> _hashMap_27 = new HashMap<String, Pair<StructuredDataProperty, Map<String, String>>>();
    this.structuredDataProperties = _hashMap_27;
    HashMap<String, Pair<ReifiedRelationship, Map<String, String>>> _hashMap_28 = new HashMap<String, Pair<ReifiedRelationship, Map<String, String>>>();
    this.reifiedRelationships = _hashMap_28;
    HashMap<String, Pair<ReifiedRelationshipRestriction, Map<String, String>>> _hashMap_29 = new HashMap<String, Pair<ReifiedRelationshipRestriction, Map<String, String>>>();
    this.reifiedRelationshipRestrictions = _hashMap_29;
    HashMap<String, Pair<ForwardProperty, Map<String, String>>> _hashMap_30 = new HashMap<String, Pair<ForwardProperty, Map<String, String>>>();
    this.forwardProperties = _hashMap_30;
    HashMap<String, Pair<InverseProperty, Map<String, String>>> _hashMap_31 = new HashMap<String, Pair<InverseProperty, Map<String, String>>>();
    this.inverseProperties = _hashMap_31;
    HashMap<String, Pair<UnreifiedRelationship, Map<String, String>>> _hashMap_32 = new HashMap<String, Pair<UnreifiedRelationship, Map<String, String>>>();
    this.unreifiedRelationships = _hashMap_32;
    HashMap<String, Pair<ChainRule, Map<String, String>>> _hashMap_33 = new HashMap<String, Pair<ChainRule, Map<String, String>>>();
    this.chainRules = _hashMap_33;
    HashMap<String, Pair<RuleBodySegment, Map<String, String>>> _hashMap_34 = new HashMap<String, Pair<RuleBodySegment, Map<String, String>>>();
    this.ruleBodySegments = _hashMap_34;
    HashMap<String, Pair<SegmentPredicate, Map<String, String>>> _hashMap_35 = new HashMap<String, Pair<SegmentPredicate, Map<String, String>>>();
    this.segmentPredicates = _hashMap_35;
    HashMap<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>> _hashMap_36 = new HashMap<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>>();
    this.entityExistentialRestrictionAxioms = _hashMap_36;
    HashMap<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>> _hashMap_37 = new HashMap<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>>();
    this.entityUniversalRestrictionAxioms = _hashMap_37;
    HashMap<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>> _hashMap_38 = new HashMap<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyExistentialRestrictionAxioms = _hashMap_38;
    HashMap<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>> _hashMap_39 = new HashMap<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyParticularRestrictionAxioms = _hashMap_39;
    HashMap<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>> _hashMap_40 = new HashMap<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyUniversalRestrictionAxioms = _hashMap_40;
    HashMap<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>> _hashMap_41 = new HashMap<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>>();
    this.entityStructuredDataPropertyParticularRestrictionAxioms = _hashMap_41;
    HashMap<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>> _hashMap_42 = new HashMap<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>>();
    this.restrictionStructuredDataPropertyTuples = _hashMap_42;
    HashMap<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>> _hashMap_43 = new HashMap<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>>();
    this.restrictionScalarDataPropertyValues = _hashMap_43;
    HashMap<String, Pair<AspectSpecializationAxiom, Map<String, String>>> _hashMap_44 = new HashMap<String, Pair<AspectSpecializationAxiom, Map<String, String>>>();
    this.aspectSpecializationAxioms = _hashMap_44;
    HashMap<String, Pair<ConceptSpecializationAxiom, Map<String, String>>> _hashMap_45 = new HashMap<String, Pair<ConceptSpecializationAxiom, Map<String, String>>>();
    this.conceptSpecializationAxioms = _hashMap_45;
    HashMap<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>> _hashMap_46 = new HashMap<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>>();
    this.reifiedRelationshipSpecializationAxioms = _hashMap_46;
    HashMap<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>> _hashMap_47 = new HashMap<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>>();
    this.subDataPropertyOfAxioms = _hashMap_47;
    HashMap<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>> _hashMap_48 = new HashMap<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>>();
    this.subObjectPropertyOfAxioms = _hashMap_48;
    HashMap<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>> _hashMap_49 = new HashMap<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>>();
    this.rootConceptTaxonomyAxioms = _hashMap_49;
    HashMap<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>> _hashMap_50 = new HashMap<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>>();
    this.anonymousConceptUnionAxioms = _hashMap_50;
    HashMap<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>> _hashMap_51 = new HashMap<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>>();
    this.specificDisjointConceptAxioms = _hashMap_51;
    HashMap<String, Pair<ConceptInstance, Map<String, String>>> _hashMap_52 = new HashMap<String, Pair<ConceptInstance, Map<String, String>>>();
    this.conceptInstances = _hashMap_52;
    HashMap<String, Pair<ReifiedRelationshipInstance, Map<String, String>>> _hashMap_53 = new HashMap<String, Pair<ReifiedRelationshipInstance, Map<String, String>>>();
    this.reifiedRelationshipInstances = _hashMap_53;
    HashMap<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>> _hashMap_54 = new HashMap<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>>();
    this.reifiedRelationshipInstanceDomains = _hashMap_54;
    HashMap<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>> _hashMap_55 = new HashMap<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>>();
    this.reifiedRelationshipInstanceRanges = _hashMap_55;
    HashMap<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>> _hashMap_56 = new HashMap<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>>();
    this.unreifiedRelationshipInstanceTuples = _hashMap_56;
    HashMap<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>> _hashMap_57 = new HashMap<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>>();
    this.singletonInstanceStructuredDataPropertyValues = _hashMap_57;
    HashMap<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>> _hashMap_58 = new HashMap<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>>();
    this.singletonInstanceScalarDataPropertyValues = _hashMap_58;
    HashMap<String, Pair<StructuredDataPropertyTuple, Map<String, String>>> _hashMap_59 = new HashMap<String, Pair<StructuredDataPropertyTuple, Map<String, String>>>();
    this.structuredDataPropertyTuples = _hashMap_59;
    HashMap<String, Pair<ScalarDataPropertyValue, Map<String, String>>> _hashMap_60 = new HashMap<String, Pair<ScalarDataPropertyValue, Map<String, String>>>();
    this.scalarDataPropertyValues = _hashMap_60;
    HashMap<String, Pair<AnnotationPropertyValue, Map<String, String>>> _hashMap_61 = new HashMap<String, Pair<AnnotationPropertyValue, Map<String, String>>>();
    this.annotationPropertyValues = _hashMap_61;
    HashMap<String, Pair<CardinalityRestrictedAspect, Map<String, String>>> _hashMap_62 = new HashMap<String, Pair<CardinalityRestrictedAspect, Map<String, String>>>();
    this.cardinalityRestrictedAspects = _hashMap_62;
    HashMap<String, Pair<CardinalityRestrictedConcept, Map<String, String>>> _hashMap_63 = new HashMap<String, Pair<CardinalityRestrictedConcept, Map<String, String>>>();
    this.cardinalityRestrictedConcepts = _hashMap_63;
    HashMap<String, Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>>> _hashMap_64 = new HashMap<String, Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>>>();
    this.cardinalityRestrictedReifiedRelationships = _hashMap_64;
    HashMap<String, Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>>> _hashMap_65 = new HashMap<String, Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>>>();
    this.modules = _hashMap_65;
    HashMap<String, Pair<LogicalElement, Map<String, String>>> _hashMap_66 = new HashMap<String, Pair<LogicalElement, Map<String, String>>>();
    this.logicalElements = _hashMap_66;
    HashMap<String, Pair<Entity, Map<String, String>>> _hashMap_67 = new HashMap<String, Pair<Entity, Map<String, String>>>();
    this.entities = _hashMap_67;
    HashMap<String, Pair<AspectKind, Map<String, String>>> _hashMap_68 = new HashMap<String, Pair<AspectKind, Map<String, String>>>();
    this.aspectKinds = _hashMap_68;
    HashMap<String, Pair<ConceptKind, Map<String, String>>> _hashMap_69 = new HashMap<String, Pair<ConceptKind, Map<String, String>>>();
    this.conceptKinds = _hashMap_69;
    HashMap<String, Pair<EntityRelationship, Map<String, String>>> _hashMap_70 = new HashMap<String, Pair<EntityRelationship, Map<String, String>>>();
    this.entityRelationships = _hashMap_70;
    HashMap<String, Pair<ConceptualRelationship, Map<String, String>>> _hashMap_71 = new HashMap<String, Pair<ConceptualRelationship, Map<String, String>>>();
    this.conceptualRelationships = _hashMap_71;
    HashMap<String, Pair<DataRange, Map<String, String>>> _hashMap_72 = new HashMap<String, Pair<DataRange, Map<String, String>>>();
    this.dataRanges = _hashMap_72;
    HashMap<String, Pair<DataRelationshipToScalar, Map<String, String>>> _hashMap_73 = new HashMap<String, Pair<DataRelationshipToScalar, Map<String, String>>>();
    this.dataRelationshipToScalars = _hashMap_73;
    HashMap<String, Pair<DataRelationshipToStructure, Map<String, String>>> _hashMap_74 = new HashMap<String, Pair<DataRelationshipToStructure, Map<String, String>>>();
    this.dataRelationshipToStructures = _hashMap_74;
    HashMap<String, Pair<Predicate, Map<String, String>>> _hashMap_75 = new HashMap<String, Pair<Predicate, Map<String, String>>>();
    this.predicates = _hashMap_75;
    HashMap<String, Pair<RestrictableRelationship, Map<String, String>>> _hashMap_76 = new HashMap<String, Pair<RestrictableRelationship, Map<String, String>>>();
    this.restrictableRelationships = _hashMap_76;
    HashMap<String, Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>> _hashMap_77 = new HashMap<String, Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>>();
    this.restrictionStructuredDataPropertyContexts = _hashMap_77;
    HashMap<String, Pair<TerminologyBox, Map<String, String>>> _hashMap_78 = new HashMap<String, Pair<TerminologyBox, Map<String, String>>>();
    this.terminologyBoxes = _hashMap_78;
    HashMap<String, Pair<ConceptTreeDisjunction, Map<String, String>>> _hashMap_79 = new HashMap<String, Pair<ConceptTreeDisjunction, Map<String, String>>>();
    this.conceptTreeDisjunctions = _hashMap_79;
    HashMap<String, Pair<ConceptualEntitySingletonInstance, Map<String, String>>> _hashMap_80 = new HashMap<String, Pair<ConceptualEntitySingletonInstance, Map<String, String>>>();
    this.conceptualEntitySingletonInstances = _hashMap_80;
    HashMap<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>> _hashMap_81 = new HashMap<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>>();
    this.singletonInstanceStructuredDataPropertyContexts = _hashMap_81;
  }
  
  public static void save(final Extent e, final ZipArchiveOutputStream zos) {
    try {
      ZipArchiveEntry entry = null;
      ZipArchiveEntry _zipArchiveEntry = new ZipArchiveEntry("TerminologyGraphs.json");
      entry = _zipArchiveEntry;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.terminologyGraphsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_1 = new ZipArchiveEntry("Bundles.json");
      entry = _zipArchiveEntry_1;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.bundlesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_2 = new ZipArchiveEntry("DescriptionBoxes.json");
      entry = _zipArchiveEntry_2;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.descriptionBoxesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_3 = new ZipArchiveEntry("AnnotationProperties.json");
      entry = _zipArchiveEntry_3;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.annotationPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_4 = new ZipArchiveEntry("Aspects.json");
      entry = _zipArchiveEntry_4;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.aspectsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_5 = new ZipArchiveEntry("Concepts.json");
      entry = _zipArchiveEntry_5;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_6 = new ZipArchiveEntry("Scalars.json");
      entry = _zipArchiveEntry_6;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_7 = new ZipArchiveEntry("Structures.json");
      entry = _zipArchiveEntry_7;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.structuresByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_8 = new ZipArchiveEntry("ConceptDesignationTerminologyAxioms.json");
      entry = _zipArchiveEntry_8;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptDesignationTerminologyAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_9 = new ZipArchiveEntry("TerminologyExtensionAxioms.json");
      entry = _zipArchiveEntry_9;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.terminologyExtensionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_10 = new ZipArchiveEntry("TerminologyNestingAxioms.json");
      entry = _zipArchiveEntry_10;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.terminologyNestingAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_11 = new ZipArchiveEntry("BundledTerminologyAxioms.json");
      entry = _zipArchiveEntry_11;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.bundledTerminologyAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_12 = new ZipArchiveEntry("DescriptionBoxExtendsClosedWorldDefinitions.json");
      entry = _zipArchiveEntry_12;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.descriptionBoxExtendsClosedWorldDefinitionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_13 = new ZipArchiveEntry("DescriptionBoxRefinements.json");
      entry = _zipArchiveEntry_13;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.descriptionBoxRefinementsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_14 = new ZipArchiveEntry("BinaryScalarRestrictions.json");
      entry = _zipArchiveEntry_14;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.binaryScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_15 = new ZipArchiveEntry("IRIScalarRestrictions.json");
      entry = _zipArchiveEntry_15;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.iriScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_16 = new ZipArchiveEntry("NumericScalarRestrictions.json");
      entry = _zipArchiveEntry_16;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.numericScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_17 = new ZipArchiveEntry("PlainLiteralScalarRestrictions.json");
      entry = _zipArchiveEntry_17;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.plainLiteralScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_18 = new ZipArchiveEntry("ScalarOneOfRestrictions.json");
      entry = _zipArchiveEntry_18;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarOneOfRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_19 = new ZipArchiveEntry("ScalarOneOfLiteralAxioms.json");
      entry = _zipArchiveEntry_19;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarOneOfLiteralAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_20 = new ZipArchiveEntry("StringScalarRestrictions.json");
      entry = _zipArchiveEntry_20;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.stringScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_21 = new ZipArchiveEntry("SynonymScalarRestrictions.json");
      entry = _zipArchiveEntry_21;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.synonymScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_22 = new ZipArchiveEntry("TimeScalarRestrictions.json");
      entry = _zipArchiveEntry_22;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.timeScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_23 = new ZipArchiveEntry("EntityScalarDataProperties.json");
      entry = _zipArchiveEntry_23;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_24 = new ZipArchiveEntry("EntityStructuredDataProperties.json");
      entry = _zipArchiveEntry_24;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityStructuredDataPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_25 = new ZipArchiveEntry("ScalarDataProperties.json");
      entry = _zipArchiveEntry_25;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarDataPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_26 = new ZipArchiveEntry("StructuredDataProperties.json");
      entry = _zipArchiveEntry_26;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.structuredDataPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_27 = new ZipArchiveEntry("ReifiedRelationships.json");
      entry = _zipArchiveEntry_27;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_28 = new ZipArchiveEntry("ReifiedRelationshipRestrictions.json");
      entry = _zipArchiveEntry_28;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_29 = new ZipArchiveEntry("ForwardProperties.json");
      entry = _zipArchiveEntry_29;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.forwardPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_30 = new ZipArchiveEntry("InverseProperties.json");
      entry = _zipArchiveEntry_30;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.inversePropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_31 = new ZipArchiveEntry("UnreifiedRelationships.json");
      entry = _zipArchiveEntry_31;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.unreifiedRelationshipsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_32 = new ZipArchiveEntry("ChainRules.json");
      entry = _zipArchiveEntry_32;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.chainRulesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_33 = new ZipArchiveEntry("RuleBodySegments.json");
      entry = _zipArchiveEntry_33;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.ruleBodySegmentsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_34 = new ZipArchiveEntry("SegmentPredicates.json");
      entry = _zipArchiveEntry_34;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.segmentPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_35 = new ZipArchiveEntry("EntityExistentialRestrictionAxioms.json");
      entry = _zipArchiveEntry_35;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityExistentialRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_36 = new ZipArchiveEntry("EntityUniversalRestrictionAxioms.json");
      entry = _zipArchiveEntry_36;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityUniversalRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_37 = new ZipArchiveEntry("EntityScalarDataPropertyExistentialRestrictionAxioms.json");
      entry = _zipArchiveEntry_37;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyExistentialRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_38 = new ZipArchiveEntry("EntityScalarDataPropertyParticularRestrictionAxioms.json");
      entry = _zipArchiveEntry_38;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyParticularRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_39 = new ZipArchiveEntry("EntityScalarDataPropertyUniversalRestrictionAxioms.json");
      entry = _zipArchiveEntry_39;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyUniversalRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_40 = new ZipArchiveEntry("EntityStructuredDataPropertyParticularRestrictionAxioms.json");
      entry = _zipArchiveEntry_40;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityStructuredDataPropertyParticularRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_41 = new ZipArchiveEntry("RestrictionStructuredDataPropertyTuples.json");
      entry = _zipArchiveEntry_41;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.restrictionStructuredDataPropertyTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_42 = new ZipArchiveEntry("RestrictionScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_42;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.restrictionScalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_43 = new ZipArchiveEntry("AspectSpecializationAxioms.json");
      entry = _zipArchiveEntry_43;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.aspectSpecializationAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_44 = new ZipArchiveEntry("ConceptSpecializationAxioms.json");
      entry = _zipArchiveEntry_44;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptSpecializationAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_45 = new ZipArchiveEntry("ReifiedRelationshipSpecializationAxioms.json");
      entry = _zipArchiveEntry_45;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipSpecializationAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_46 = new ZipArchiveEntry("SubDataPropertyOfAxioms.json");
      entry = _zipArchiveEntry_46;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.subDataPropertyOfAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_47 = new ZipArchiveEntry("SubObjectPropertyOfAxioms.json");
      entry = _zipArchiveEntry_47;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.subObjectPropertyOfAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_48 = new ZipArchiveEntry("RootConceptTaxonomyAxioms.json");
      entry = _zipArchiveEntry_48;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.rootConceptTaxonomyAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_49 = new ZipArchiveEntry("AnonymousConceptUnionAxioms.json");
      entry = _zipArchiveEntry_49;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.anonymousConceptUnionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_50 = new ZipArchiveEntry("SpecificDisjointConceptAxioms.json");
      entry = _zipArchiveEntry_50;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.specificDisjointConceptAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_51 = new ZipArchiveEntry("ConceptInstances.json");
      entry = _zipArchiveEntry_51;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptInstancesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_52 = new ZipArchiveEntry("ReifiedRelationshipInstances.json");
      entry = _zipArchiveEntry_52;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstancesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_53 = new ZipArchiveEntry("ReifiedRelationshipInstanceDomains.json");
      entry = _zipArchiveEntry_53;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstanceDomainsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_54 = new ZipArchiveEntry("ReifiedRelationshipInstanceRanges.json");
      entry = _zipArchiveEntry_54;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstanceRangesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_55 = new ZipArchiveEntry("UnreifiedRelationshipInstanceTuples.json");
      entry = _zipArchiveEntry_55;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.unreifiedRelationshipInstanceTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_56 = new ZipArchiveEntry("SingletonInstanceStructuredDataPropertyValues.json");
      entry = _zipArchiveEntry_56;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.singletonInstanceStructuredDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_57 = new ZipArchiveEntry("SingletonInstanceScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_57;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.singletonInstanceScalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_58 = new ZipArchiveEntry("StructuredDataPropertyTuples.json");
      entry = _zipArchiveEntry_58;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.structuredDataPropertyTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_59 = new ZipArchiveEntry("ScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_59;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_60 = new ZipArchiveEntry("AnnotationPropertyValues.json");
      entry = _zipArchiveEntry_60;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.annotationPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_61 = new ZipArchiveEntry("CardinalityRestrictedAspects.json");
      entry = _zipArchiveEntry_61;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.cardinalityRestrictedAspectsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_62 = new ZipArchiveEntry("CardinalityRestrictedConcepts.json");
      entry = _zipArchiveEntry_62;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.cardinalityRestrictedConceptsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_63 = new ZipArchiveEntry("CardinalityRestrictedReifiedRelationships.json");
      entry = _zipArchiveEntry_63;
      entry.setTime(0L);
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.cardinalityRestrictedReifiedRelationshipsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected static byte[] terminologyGraphsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<TerminologyGraph> _function = (TerminologyGraph it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"kind\":");
      pw.print(OMLTables.toString(it.getKind()));
      pw.print(",");
      pw.print("\"iri\":");
      pw.print(OMLTables.toString(it.iri()));
      pw.println("}");
    };
    OMLTables.terminologyGraphs(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] bundlesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<Bundle> _function = (Bundle it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"kind\":");
      pw.print(OMLTables.toString(it.getKind()));
      pw.print(",");
      pw.print("\"iri\":");
      pw.print(OMLTables.toString(it.iri()));
      pw.println("}");
    };
    OMLTables.bundles(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] descriptionBoxesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<DescriptionBox> _function = (DescriptionBox it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"kind\":");
      pw.print(OMLTables.toString(it.getKind()));
      pw.print(",");
      pw.print("\"iri\":");
      pw.print(OMLTables.toString(it.iri()));
      pw.println("}");
    };
    OMLTables.descriptionBoxes(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] annotationPropertiesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<AnnotationProperty> _function = (AnnotationProperty it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"moduleUUID\":");
      pw.print("\"");
      pw.print(it.getModule().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"iri\":");
      pw.print(OMLTables.toString(it.iri()));
      pw.print(",");
      pw.print("\"abbrevIRI\":");
      pw.print(OMLTables.toString(it.getAbbrevIRI()));
      pw.println("}");
    };
    OMLTables.annotationProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] aspectsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<Aspect> _function = (Aspect it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.aspects(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] conceptsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<Concept> _function = (Concept it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.concepts(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] scalarsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<Scalar> _function = (Scalar it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.scalars(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] structuresByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<Structure> _function = (Structure it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.structures(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] conceptDesignationTerminologyAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ConceptDesignationTerminologyAxiom> _function = (ConceptDesignationTerminologyAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"designatedConceptUUID\":");
      pw.print("\"");
      pw.print(it.getDesignatedConcept().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"designatedTerminologyIRI\":");
      pw.print("\"");
      pw.print(it.getDesignatedTerminology().iri());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.conceptDesignationTerminologyAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] terminologyExtensionAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<TerminologyExtensionAxiom> _function = (TerminologyExtensionAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"extendedTerminologyIRI\":");
      pw.print("\"");
      pw.print(it.getExtendedTerminology().iri());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.terminologyExtensionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] terminologyNestingAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<TerminologyNestingAxiom> _function = (TerminologyNestingAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"nestingContextUUID\":");
      pw.print("\"");
      pw.print(it.getNestingContext().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"nestingTerminologyIRI\":");
      pw.print("\"");
      pw.print(it.getNestingTerminology().iri());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.terminologyNestingAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] bundledTerminologyAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<BundledTerminologyAxiom> _function = (BundledTerminologyAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"bundleUUID\":");
      pw.print("\"");
      pw.print(it.getBundle().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"bundledTerminologyIRI\":");
      pw.print("\"");
      pw.print(it.getBundledTerminology().iri());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.bundledTerminologyAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] descriptionBoxExtendsClosedWorldDefinitionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<DescriptionBoxExtendsClosedWorldDefinitions> _function = (DescriptionBoxExtendsClosedWorldDefinitions it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"descriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.getDescriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"closedWorldDefinitionsIRI\":");
      pw.print("\"");
      pw.print(it.getClosedWorldDefinitions().iri());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.descriptionBoxExtendsClosedWorldDefinitions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] descriptionBoxRefinementsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<DescriptionBoxRefinement> _function = (DescriptionBoxRefinement it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"refiningDescriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.getRefiningDescriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"refinedDescriptionBoxIRI\":");
      pw.print("\"");
      pw.print(it.getRefinedDescriptionBox().iri());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.descriptionBoxRefinements(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] binaryScalarRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<BinaryScalarRestriction> _function = (BinaryScalarRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"length\":");
      pw.print(OMLTables.toString(it.getLength()));
      pw.print(",");
      pw.print("\"minLength\":");
      pw.print(OMLTables.toString(it.getMinLength()));
      pw.print(",");
      pw.print("\"maxLength\":");
      pw.print(OMLTables.toString(it.getMaxLength()));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.binaryScalarRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] iriScalarRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<IRIScalarRestriction> _function = (IRIScalarRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"length\":");
      pw.print(OMLTables.toString(it.getLength()));
      pw.print(",");
      pw.print("\"minLength\":");
      pw.print(OMLTables.toString(it.getMinLength()));
      pw.print(",");
      pw.print("\"maxLength\":");
      pw.print(OMLTables.toString(it.getMaxLength()));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"pattern\":");
      pw.print(OMLTables.toString(it.getPattern()));
      pw.println("}");
    };
    OMLTables.iriScalarRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] numericScalarRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<NumericScalarRestriction> _function = (NumericScalarRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"minExclusive\":");
      pw.print(OMLTables.toString(it.getMinExclusive()));
      pw.print(",");
      pw.print("\"minInclusive\":");
      pw.print(OMLTables.toString(it.getMinInclusive()));
      pw.print(",");
      pw.print("\"maxExclusive\":");
      pw.print(OMLTables.toString(it.getMaxExclusive()));
      pw.print(",");
      pw.print("\"maxInclusive\":");
      pw.print(OMLTables.toString(it.getMaxInclusive()));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.numericScalarRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] plainLiteralScalarRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<PlainLiteralScalarRestriction> _function = (PlainLiteralScalarRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"length\":");
      pw.print(OMLTables.toString(it.getLength()));
      pw.print(",");
      pw.print("\"minLength\":");
      pw.print(OMLTables.toString(it.getMinLength()));
      pw.print(",");
      pw.print("\"maxLength\":");
      pw.print(OMLTables.toString(it.getMaxLength()));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"langRange\":");
      pw.print(OMLTables.toString(it.getLangRange()));
      pw.print(",");
      pw.print("\"pattern\":");
      pw.print(OMLTables.toString(it.getPattern()));
      pw.println("}");
    };
    OMLTables.plainLiteralScalarRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] scalarOneOfRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ScalarOneOfRestriction> _function = (ScalarOneOfRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.scalarOneOfRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] scalarOneOfLiteralAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ScalarOneOfLiteralAxiom> _function = (ScalarOneOfLiteralAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"axiomUUID\":");
      pw.print("\"");
      pw.print(it.getAxiom().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"value\":");
      pw.print(OMLTables.toString(it.getValue()));
      pw.print(",");
      pw.print("\"valueTypeUUID\":");
      DataRange _valueType = it.getValueType();
      boolean _tripleNotEquals = (null != _valueType);
      if (_tripleNotEquals) {
        pw.print("\"");
        DataRange _valueType_1 = it.getValueType();
        String _uuid = null;
        if (_valueType_1!=null) {
          _uuid=_valueType_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.println("}");
    };
    OMLTables.scalarOneOfLiteralAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] stringScalarRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<StringScalarRestriction> _function = (StringScalarRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"length\":");
      pw.print(OMLTables.toString(it.getLength()));
      pw.print(",");
      pw.print("\"minLength\":");
      pw.print(OMLTables.toString(it.getMinLength()));
      pw.print(",");
      pw.print("\"maxLength\":");
      pw.print(OMLTables.toString(it.getMaxLength()));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"pattern\":");
      pw.print(OMLTables.toString(it.getPattern()));
      pw.println("}");
    };
    OMLTables.stringScalarRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] synonymScalarRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<SynonymScalarRestriction> _function = (SynonymScalarRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.synonymScalarRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] timeScalarRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<TimeScalarRestriction> _function = (TimeScalarRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"minExclusive\":");
      pw.print(OMLTables.toString(it.getMinExclusive()));
      pw.print(",");
      pw.print("\"minInclusive\":");
      pw.print(OMLTables.toString(it.getMinInclusive()));
      pw.print(",");
      pw.print("\"maxExclusive\":");
      pw.print(OMLTables.toString(it.getMaxExclusive()));
      pw.print(",");
      pw.print("\"maxInclusive\":");
      pw.print(OMLTables.toString(it.getMaxInclusive()));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.timeScalarRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] entityScalarDataPropertiesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<EntityScalarDataProperty> _function = (EntityScalarDataProperty it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"domainUUID\":");
      pw.print("\"");
      pw.print(it.getDomain().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"rangeUUID\":");
      pw.print("\"");
      pw.print(it.getRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isIdentityCriteria\":");
      pw.print("\"");
      pw.print(it.isIsIdentityCriteria());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.entityScalarDataProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] entityStructuredDataPropertiesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<EntityStructuredDataProperty> _function = (EntityStructuredDataProperty it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"domainUUID\":");
      pw.print("\"");
      pw.print(it.getDomain().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"rangeUUID\":");
      pw.print("\"");
      pw.print(it.getRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isIdentityCriteria\":");
      pw.print("\"");
      pw.print(it.isIsIdentityCriteria());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.entityStructuredDataProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] scalarDataPropertiesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ScalarDataProperty> _function = (ScalarDataProperty it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"domainUUID\":");
      pw.print("\"");
      pw.print(it.getDomain().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"rangeUUID\":");
      pw.print("\"");
      pw.print(it.getRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.scalarDataProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] structuredDataPropertiesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<StructuredDataProperty> _function = (StructuredDataProperty it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"domainUUID\":");
      pw.print("\"");
      pw.print(it.getDomain().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"rangeUUID\":");
      pw.print("\"");
      pw.print(it.getRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.structuredDataProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] reifiedRelationshipsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationship> _function = (ReifiedRelationship it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"sourceUUID\":");
      pw.print("\"");
      pw.print(it.getSource().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"targetUUID\":");
      pw.print("\"");
      pw.print(it.getTarget().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isAsymmetric\":");
      pw.print("\"");
      pw.print(it.isIsAsymmetric());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isEssential\":");
      pw.print("\"");
      pw.print(it.isIsEssential());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isFunctional\":");
      pw.print("\"");
      pw.print(it.isIsFunctional());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isInverseEssential\":");
      pw.print("\"");
      pw.print(it.isIsInverseEssential());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isInverseFunctional\":");
      pw.print("\"");
      pw.print(it.isIsInverseFunctional());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isIrreflexive\":");
      pw.print("\"");
      pw.print(it.isIsIrreflexive());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isReflexive\":");
      pw.print("\"");
      pw.print(it.isIsReflexive());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isSymmetric\":");
      pw.print("\"");
      pw.print(it.isIsSymmetric());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isTransitive\":");
      pw.print("\"");
      pw.print(it.isIsTransitive());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.reifiedRelationships(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] reifiedRelationshipRestrictionsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipRestriction> _function = (ReifiedRelationshipRestriction it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"sourceUUID\":");
      pw.print("\"");
      pw.print(it.getSource().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"targetUUID\":");
      pw.print("\"");
      pw.print(it.getTarget().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.reifiedRelationshipRestrictions(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] forwardPropertiesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ForwardProperty> _function = (ForwardProperty it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.forwardProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] inversePropertiesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<InverseProperty> _function = (InverseProperty it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.inverseProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] unreifiedRelationshipsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<UnreifiedRelationship> _function = (UnreifiedRelationship it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"sourceUUID\":");
      pw.print("\"");
      pw.print(it.getSource().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"targetUUID\":");
      pw.print("\"");
      pw.print(it.getTarget().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isAsymmetric\":");
      pw.print("\"");
      pw.print(it.isIsAsymmetric());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isEssential\":");
      pw.print("\"");
      pw.print(it.isIsEssential());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isFunctional\":");
      pw.print("\"");
      pw.print(it.isIsFunctional());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isInverseEssential\":");
      pw.print("\"");
      pw.print(it.isIsInverseEssential());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isInverseFunctional\":");
      pw.print("\"");
      pw.print(it.isIsInverseFunctional());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isIrreflexive\":");
      pw.print("\"");
      pw.print(it.isIsIrreflexive());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isReflexive\":");
      pw.print("\"");
      pw.print(it.isIsReflexive());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isSymmetric\":");
      pw.print("\"");
      pw.print(it.isIsSymmetric());
      pw.print("\"");
      pw.print(",");
      pw.print("\"isTransitive\":");
      pw.print("\"");
      pw.print(it.isIsTransitive());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.unreifiedRelationships(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] chainRulesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ChainRule> _function = (ChainRule it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"headUUID\":");
      pw.print("\"");
      pw.print(it.getHead().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.chainRules(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] ruleBodySegmentsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<RuleBodySegment> _function = (RuleBodySegment it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"previousSegmentUUID\":");
      RuleBodySegment _previousSegment = it.getPreviousSegment();
      boolean _tripleNotEquals = (null != _previousSegment);
      if (_tripleNotEquals) {
        pw.print("\"");
        RuleBodySegment _previousSegment_1 = it.getPreviousSegment();
        String _uuid = null;
        if (_previousSegment_1!=null) {
          _uuid=_previousSegment_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"ruleUUID\":");
      ChainRule _rule = it.getRule();
      boolean _tripleNotEquals_1 = (null != _rule);
      if (_tripleNotEquals_1) {
        pw.print("\"");
        ChainRule _rule_1 = it.getRule();
        String _uuid_1 = null;
        if (_rule_1!=null) {
          _uuid_1=_rule_1.uuid();
        }
        pw.print(_uuid_1);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.println("}");
    };
    OMLTables.ruleBodySegments(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] segmentPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<SegmentPredicate> _function = (SegmentPredicate it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"bodySegmentUUID\":");
      pw.print("\"");
      pw.print(it.getBodySegment().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"predicateUUID\":");
      Predicate _predicate = it.getPredicate();
      boolean _tripleNotEquals = (null != _predicate);
      if (_tripleNotEquals) {
        pw.print("\"");
        Predicate _predicate_1 = it.getPredicate();
        String _uuid = null;
        if (_predicate_1!=null) {
          _uuid=_predicate_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"reifiedRelationshipSourceUUID\":");
      ReifiedRelationship _reifiedRelationshipSource = it.getReifiedRelationshipSource();
      boolean _tripleNotEquals_1 = (null != _reifiedRelationshipSource);
      if (_tripleNotEquals_1) {
        pw.print("\"");
        ReifiedRelationship _reifiedRelationshipSource_1 = it.getReifiedRelationshipSource();
        String _uuid_1 = null;
        if (_reifiedRelationshipSource_1!=null) {
          _uuid_1=_reifiedRelationshipSource_1.uuid();
        }
        pw.print(_uuid_1);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"reifiedRelationshipInverseSourceUUID\":");
      ReifiedRelationship _reifiedRelationshipInverseSource = it.getReifiedRelationshipInverseSource();
      boolean _tripleNotEquals_2 = (null != _reifiedRelationshipInverseSource);
      if (_tripleNotEquals_2) {
        pw.print("\"");
        ReifiedRelationship _reifiedRelationshipInverseSource_1 = it.getReifiedRelationshipInverseSource();
        String _uuid_2 = null;
        if (_reifiedRelationshipInverseSource_1!=null) {
          _uuid_2=_reifiedRelationshipInverseSource_1.uuid();
        }
        pw.print(_uuid_2);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"reifiedRelationshipTargetUUID\":");
      ReifiedRelationship _reifiedRelationshipTarget = it.getReifiedRelationshipTarget();
      boolean _tripleNotEquals_3 = (null != _reifiedRelationshipTarget);
      if (_tripleNotEquals_3) {
        pw.print("\"");
        ReifiedRelationship _reifiedRelationshipTarget_1 = it.getReifiedRelationshipTarget();
        String _uuid_3 = null;
        if (_reifiedRelationshipTarget_1!=null) {
          _uuid_3=_reifiedRelationshipTarget_1.uuid();
        }
        pw.print(_uuid_3);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"reifiedRelationshipInverseTargetUUID\":");
      ReifiedRelationship _reifiedRelationshipInverseTarget = it.getReifiedRelationshipInverseTarget();
      boolean _tripleNotEquals_4 = (null != _reifiedRelationshipInverseTarget);
      if (_tripleNotEquals_4) {
        pw.print("\"");
        ReifiedRelationship _reifiedRelationshipInverseTarget_1 = it.getReifiedRelationshipInverseTarget();
        String _uuid_4 = null;
        if (_reifiedRelationshipInverseTarget_1!=null) {
          _uuid_4=_reifiedRelationshipInverseTarget_1.uuid();
        }
        pw.print(_uuid_4);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"unreifiedRelationshipInverseUUID\":");
      UnreifiedRelationship _unreifiedRelationshipInverse = it.getUnreifiedRelationshipInverse();
      boolean _tripleNotEquals_5 = (null != _unreifiedRelationshipInverse);
      if (_tripleNotEquals_5) {
        pw.print("\"");
        UnreifiedRelationship _unreifiedRelationshipInverse_1 = it.getUnreifiedRelationshipInverse();
        String _uuid_5 = null;
        if (_unreifiedRelationshipInverse_1!=null) {
          _uuid_5=_unreifiedRelationshipInverse_1.uuid();
        }
        pw.print(_uuid_5);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.println("}");
    };
    OMLTables.segmentPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] entityExistentialRestrictionAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<EntityExistentialRestrictionAxiom> _function = (EntityExistentialRestrictionAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedDomainUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedDomain().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.entityExistentialRestrictionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] entityUniversalRestrictionAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<EntityUniversalRestrictionAxiom> _function = (EntityUniversalRestrictionAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedDomainUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedDomain().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRange().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.entityUniversalRestrictionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] entityScalarDataPropertyExistentialRestrictionAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<EntityScalarDataPropertyExistentialRestrictionAxiom> _function = (EntityScalarDataPropertyExistentialRestrictionAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedEntityUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedEntity().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getScalarProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarRestrictionUUID\":");
      pw.print("\"");
      pw.print(it.getScalarRestriction().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.entityScalarDataPropertyExistentialRestrictionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] entityScalarDataPropertyParticularRestrictionAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<EntityScalarDataPropertyParticularRestrictionAxiom> _function = (EntityScalarDataPropertyParticularRestrictionAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedEntityUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedEntity().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getScalarProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"literalValue\":");
      pw.print(OMLTables.toString(it.getLiteralValue()));
      pw.print(",");
      pw.print("\"valueTypeUUID\":");
      DataRange _valueType = it.getValueType();
      boolean _tripleNotEquals = (null != _valueType);
      if (_tripleNotEquals) {
        pw.print("\"");
        DataRange _valueType_1 = it.getValueType();
        String _uuid = null;
        if (_valueType_1!=null) {
          _uuid=_valueType_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.println("}");
    };
    OMLTables.entityScalarDataPropertyParticularRestrictionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] entityScalarDataPropertyUniversalRestrictionAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<EntityScalarDataPropertyUniversalRestrictionAxiom> _function = (EntityScalarDataPropertyUniversalRestrictionAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedEntityUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedEntity().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getScalarProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarRestrictionUUID\":");
      pw.print("\"");
      pw.print(it.getScalarRestriction().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.entityScalarDataPropertyUniversalRestrictionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] entityStructuredDataPropertyParticularRestrictionAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<EntityStructuredDataPropertyParticularRestrictionAxiom> _function = (EntityStructuredDataPropertyParticularRestrictionAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedEntityUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedEntity().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.entityStructuredDataPropertyParticularRestrictionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] restrictionStructuredDataPropertyTuplesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<RestrictionStructuredDataPropertyTuple> _function = (RestrictionStructuredDataPropertyTuple it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyContextUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataPropertyContext().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataProperty().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.restrictionStructuredDataPropertyTuples(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] restrictionScalarDataPropertyValuesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<RestrictionScalarDataPropertyValue> _function = (RestrictionScalarDataPropertyValue it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyContextUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataPropertyContext().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getScalarDataProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarPropertyValue\":");
      pw.print(OMLTables.toString(it.getScalarPropertyValue()));
      pw.print(",");
      pw.print("\"valueTypeUUID\":");
      DataRange _valueType = it.getValueType();
      boolean _tripleNotEquals = (null != _valueType);
      if (_tripleNotEquals) {
        pw.print("\"");
        DataRange _valueType_1 = it.getValueType();
        String _uuid = null;
        if (_valueType_1!=null) {
          _uuid=_valueType_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.println("}");
    };
    OMLTables.restrictionScalarDataPropertyValues(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] aspectSpecializationAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<AspectSpecializationAxiom> _function = (AspectSpecializationAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"superAspectUUID\":");
      pw.print("\"");
      pw.print(it.getSuperAspect().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"subEntityUUID\":");
      pw.print("\"");
      pw.print(it.getSubEntity().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.aspectSpecializationAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] conceptSpecializationAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ConceptSpecializationAxiom> _function = (ConceptSpecializationAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"superConceptUUID\":");
      pw.print("\"");
      pw.print(it.getSuperConcept().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"subConceptUUID\":");
      pw.print("\"");
      pw.print(it.getSubConcept().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.conceptSpecializationAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] reifiedRelationshipSpecializationAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipSpecializationAxiom> _function = (ReifiedRelationshipSpecializationAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"superRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getSuperRelationship().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"subRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getSubRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipSpecializationAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] subDataPropertyOfAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<SubDataPropertyOfAxiom> _function = (SubDataPropertyOfAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"subPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getSubProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"superPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getSuperProperty().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.subDataPropertyOfAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] subObjectPropertyOfAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<SubObjectPropertyOfAxiom> _function = (SubObjectPropertyOfAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"subPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getSubProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"superPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getSuperProperty().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.subObjectPropertyOfAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] rootConceptTaxonomyAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<RootConceptTaxonomyAxiom> _function = (RootConceptTaxonomyAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"bundleUUID\":");
      pw.print("\"");
      pw.print(it.getBundle().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"rootUUID\":");
      pw.print("\"");
      pw.print(it.getRoot().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.rootConceptTaxonomyAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] anonymousConceptUnionAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<AnonymousConceptUnionAxiom> _function = (AnonymousConceptUnionAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"disjointTaxonomyParentUUID\":");
      pw.print("\"");
      pw.print(it.getDisjointTaxonomyParent().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.getName()));
      pw.println("}");
    };
    OMLTables.anonymousConceptUnionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] specificDisjointConceptAxiomsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<SpecificDisjointConceptAxiom> _function = (SpecificDisjointConceptAxiom it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"disjointTaxonomyParentUUID\":");
      pw.print("\"");
      pw.print(it.getDisjointTaxonomyParent().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"disjointLeafUUID\":");
      pw.print("\"");
      pw.print(it.getDisjointLeaf().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.specificDisjointConceptAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] conceptInstancesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ConceptInstance> _function = (ConceptInstance it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"descriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.descriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"singletonConceptClassifierUUID\":");
      pw.print("\"");
      pw.print(it.getSingletonConceptClassifier().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.conceptInstances(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] reifiedRelationshipInstancesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipInstance> _function = (ReifiedRelationshipInstance it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"descriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.descriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"singletonConceptualRelationshipClassifierUUID\":");
      pw.print("\"");
      pw.print(it.getSingletonConceptualRelationshipClassifier().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.reifiedRelationshipInstances(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] reifiedRelationshipInstanceDomainsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipInstanceDomain> _function = (ReifiedRelationshipInstanceDomain it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"descriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.descriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"reifiedRelationshipInstanceUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationshipInstance().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"domainUUID\":");
      pw.print("\"");
      pw.print(it.getDomain().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipInstanceDomains(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] reifiedRelationshipInstanceRangesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipInstanceRange> _function = (ReifiedRelationshipInstanceRange it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"descriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.descriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"reifiedRelationshipInstanceUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationshipInstance().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"rangeUUID\":");
      pw.print("\"");
      pw.print(it.getRange().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipInstanceRanges(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] unreifiedRelationshipInstanceTuplesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<UnreifiedRelationshipInstanceTuple> _function = (UnreifiedRelationshipInstanceTuple it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"descriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.descriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"unreifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getUnreifiedRelationship().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"domainUUID\":");
      pw.print("\"");
      pw.print(it.getDomain().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"rangeUUID\":");
      pw.print("\"");
      pw.print(it.getRange().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.unreifiedRelationshipInstanceTuples(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] singletonInstanceStructuredDataPropertyValuesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<SingletonInstanceStructuredDataPropertyValue> _function = (SingletonInstanceStructuredDataPropertyValue it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"descriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.descriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"singletonInstanceUUID\":");
      pw.print("\"");
      pw.print(it.getSingletonInstance().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataProperty().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.singletonInstanceStructuredDataPropertyValues(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] singletonInstanceScalarDataPropertyValuesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<SingletonInstanceScalarDataPropertyValue> _function = (SingletonInstanceScalarDataPropertyValue it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"descriptionBoxUUID\":");
      pw.print("\"");
      pw.print(it.descriptionBox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"singletonInstanceUUID\":");
      pw.print("\"");
      pw.print(it.getSingletonInstance().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getScalarDataProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarPropertyValue\":");
      pw.print(OMLTables.toString(it.getScalarPropertyValue()));
      pw.print(",");
      pw.print("\"valueTypeUUID\":");
      DataRange _valueType = it.getValueType();
      boolean _tripleNotEquals = (null != _valueType);
      if (_tripleNotEquals) {
        pw.print("\"");
        DataRange _valueType_1 = it.getValueType();
        String _uuid = null;
        if (_valueType_1!=null) {
          _uuid=_valueType_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.println("}");
    };
    OMLTables.singletonInstanceScalarDataPropertyValues(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] structuredDataPropertyTuplesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<StructuredDataPropertyTuple> _function = (StructuredDataPropertyTuple it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyContextUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataPropertyContext().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataProperty().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.structuredDataPropertyTuples(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] scalarDataPropertyValuesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ScalarDataPropertyValue> _function = (ScalarDataPropertyValue it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyContextUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataPropertyContext().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getScalarDataProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"scalarPropertyValue\":");
      pw.print(OMLTables.toString(it.getScalarPropertyValue()));
      pw.print(",");
      pw.print("\"valueTypeUUID\":");
      DataRange _valueType = it.getValueType();
      boolean _tripleNotEquals = (null != _valueType);
      if (_tripleNotEquals) {
        pw.print("\"");
        DataRange _valueType_1 = it.getValueType();
        String _uuid = null;
        if (_valueType_1!=null) {
          _uuid=_valueType_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.println("}");
    };
    OMLTables.scalarDataPropertyValues(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] annotationPropertyValuesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"subjectUUID\":");
      pw.print("\"");
      pw.print(it.getSubject().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"propertyUUID\":");
      pw.print("\"");
      pw.print(it.getProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"value\":");
      pw.print(OMLTables.toString(it.getValue()));
      pw.println("}");
    };
    OMLTables.annotationPropertyValues(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] cardinalityRestrictedAspectsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<CardinalityRestrictedAspect> _function = (CardinalityRestrictedAspect it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      Entity _restrictedRange = it.getRestrictedRange();
      boolean _tripleNotEquals = (null != _restrictedRange);
      if (_tripleNotEquals) {
        pw.print("\"");
        Entity _restrictedRange_1 = it.getRestrictedRange();
        String _uuid = null;
        if (_restrictedRange_1!=null) {
          _uuid=_restrictedRange_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"restrictedCardinality\":");
      pw.print(OMLTables.toString(it.getRestrictedCardinality()));
      pw.print(",");
      pw.print("\"restrictedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRelationship().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictionKind\":");
      pw.print(OMLTables.toString(it.getRestrictionKind()));
      pw.println("}");
    };
    OMLTables.cardinalityRestrictedAspects(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] cardinalityRestrictedConceptsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<CardinalityRestrictedConcept> _function = (CardinalityRestrictedConcept it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      Entity _restrictedRange = it.getRestrictedRange();
      boolean _tripleNotEquals = (null != _restrictedRange);
      if (_tripleNotEquals) {
        pw.print("\"");
        Entity _restrictedRange_1 = it.getRestrictedRange();
        String _uuid = null;
        if (_restrictedRange_1!=null) {
          _uuid=_restrictedRange_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"restrictedCardinality\":");
      pw.print(OMLTables.toString(it.getRestrictedCardinality()));
      pw.print(",");
      pw.print("\"restrictedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRelationship().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictionKind\":");
      pw.print(OMLTables.toString(it.getRestrictionKind()));
      pw.println("}");
    };
    OMLTables.cardinalityRestrictedConcepts(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  protected static byte[] cardinalityRestrictedReifiedRelationshipsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<CardinalityRestrictedReifiedRelationship> _function = (CardinalityRestrictedReifiedRelationship it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"tboxUUID\":");
      pw.print("\"");
      pw.print(it.getTbox().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictedRangeUUID\":");
      Entity _restrictedRange = it.getRestrictedRange();
      boolean _tripleNotEquals = (null != _restrictedRange);
      if (_tripleNotEquals) {
        pw.print("\"");
        Entity _restrictedRange_1 = it.getRestrictedRange();
        String _uuid = null;
        if (_restrictedRange_1!=null) {
          _uuid=_restrictedRange_1.uuid();
        }
        pw.print(_uuid);
        pw.print("\"");
      } else {
        pw.print("null");
      }
      pw.print(",");
      pw.print("\"sourceUUID\":");
      pw.print("\"");
      pw.print(it.getSource().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"targetUUID\":");
      pw.print("\"");
      pw.print(it.getTarget().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"restrictedCardinality\":");
      pw.print(OMLTables.toString(it.getRestrictedCardinality()));
      pw.print(",");
      pw.print("\"restrictedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRelationship().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"restrictionKind\":");
      pw.print(OMLTables.toString(it.getRestrictionKind()));
      pw.println("}");
    };
    OMLTables.cardinalityRestrictedReifiedRelationships(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  /**
   * Uses an OMLSpecificationTables for resolving cross-references in the *.oml and *.omlzip representations.
   * When there are no more OML resources to load, it is necessary to call explicitly:
   * 
   *     OMLZipResource.clearOMLSpecificationTables(rs)
   */
  public static void load(final ResourceSet rs, final OMLZipResource r, final File omlZipFile) {
    try {
      final URI fileURI = URI.createFileURI(omlZipFile.getAbsolutePath());
      final OMLCatalog c = OMLExtensions.findCatalogIfExists(rs, fileURI);
      if ((null == c)) {
        throw new IllegalArgumentException(("OMLSpecificationTables.load(): failed to find an OML catalog from: " + fileURI));
      }
      boolean _isEmpty = c.getParsedCatalogs().isEmpty();
      if (_isEmpty) {
        throw new IllegalArgumentException(("OMLSpecificationTables.load(): No OML catalog found from: " + fileURI));
      }
      boolean _isEmpty_1 = c.entries().isEmpty();
      if (_isEmpty_1) {
        String _join = IterableExtensions.join(c.getParsedCatalogs(), "\n");
        String _plus = ("OMLSpecificationTables.load(): Empty OML catalog from: " + _join);
        throw new IllegalArgumentException(_plus);
      }
      final OMLSpecificationTables tables = OMLZipResource.getOrInitializeOMLSpecificationTables(rs);
      final Extent ext = tables.omlCommonFactory.createExtent();
      r.getContents().add(ext);
      final ZipFile zip = new ZipFile(omlZipFile);
      try {
        final Consumer<ZipArchiveEntry> _function = (ZipArchiveEntry ze) -> {
          try {
            final InputStream is = zip.getInputStream(ze);
            InputStreamReader _inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            final BufferedReader buffer = new BufferedReader(_inputStreamReader);
            final ArrayList<String> lines = new ArrayList<String>();
            Iterables.<String>addAll(lines, IteratorExtensions.<String>toIterable(buffer.lines().iterator()));
            is.close();
            String _name = ze.getName();
            if (_name != null) {
              switch (_name) {
                case "TerminologyGraphs.json":
                  tables.readTerminologyGraphs(ext, lines);
                  break;
                case "Bundles.json":
                  tables.readBundles(ext, lines);
                  break;
                case "DescriptionBoxes.json":
                  tables.readDescriptionBoxes(ext, lines);
                  break;
                case "AnnotationProperties.json":
                  tables.readAnnotationProperties(ext, lines);
                  break;
                case "Aspects.json":
                  tables.readAspects(ext, lines);
                  break;
                case "Concepts.json":
                  tables.readConcepts(ext, lines);
                  break;
                case "Scalars.json":
                  tables.readScalars(ext, lines);
                  break;
                case "Structures.json":
                  tables.readStructures(ext, lines);
                  break;
                case "ConceptDesignationTerminologyAxioms.json":
                  tables.readConceptDesignationTerminologyAxioms(ext, lines);
                  break;
                case "TerminologyExtensionAxioms.json":
                  tables.readTerminologyExtensionAxioms(ext, lines);
                  break;
                case "TerminologyNestingAxioms.json":
                  tables.readTerminologyNestingAxioms(ext, lines);
                  break;
                case "BundledTerminologyAxioms.json":
                  tables.readBundledTerminologyAxioms(ext, lines);
                  break;
                case "DescriptionBoxExtendsClosedWorldDefinitions.json":
                  tables.readDescriptionBoxExtendsClosedWorldDefinitions(ext, lines);
                  break;
                case "DescriptionBoxRefinements.json":
                  tables.readDescriptionBoxRefinements(ext, lines);
                  break;
                case "BinaryScalarRestrictions.json":
                  tables.readBinaryScalarRestrictions(ext, lines);
                  break;
                case "IRIScalarRestrictions.json":
                  tables.readIRIScalarRestrictions(ext, lines);
                  break;
                case "NumericScalarRestrictions.json":
                  tables.readNumericScalarRestrictions(ext, lines);
                  break;
                case "PlainLiteralScalarRestrictions.json":
                  tables.readPlainLiteralScalarRestrictions(ext, lines);
                  break;
                case "ScalarOneOfRestrictions.json":
                  tables.readScalarOneOfRestrictions(ext, lines);
                  break;
                case "ScalarOneOfLiteralAxioms.json":
                  tables.readScalarOneOfLiteralAxioms(ext, lines);
                  break;
                case "StringScalarRestrictions.json":
                  tables.readStringScalarRestrictions(ext, lines);
                  break;
                case "SynonymScalarRestrictions.json":
                  tables.readSynonymScalarRestrictions(ext, lines);
                  break;
                case "TimeScalarRestrictions.json":
                  tables.readTimeScalarRestrictions(ext, lines);
                  break;
                case "EntityScalarDataProperties.json":
                  tables.readEntityScalarDataProperties(ext, lines);
                  break;
                case "EntityStructuredDataProperties.json":
                  tables.readEntityStructuredDataProperties(ext, lines);
                  break;
                case "ScalarDataProperties.json":
                  tables.readScalarDataProperties(ext, lines);
                  break;
                case "StructuredDataProperties.json":
                  tables.readStructuredDataProperties(ext, lines);
                  break;
                case "ReifiedRelationships.json":
                  tables.readReifiedRelationships(ext, lines);
                  break;
                case "ReifiedRelationshipRestrictions.json":
                  tables.readReifiedRelationshipRestrictions(ext, lines);
                  break;
                case "ForwardProperties.json":
                  tables.readForwardProperties(ext, lines);
                  break;
                case "InverseProperties.json":
                  tables.readInverseProperties(ext, lines);
                  break;
                case "UnreifiedRelationships.json":
                  tables.readUnreifiedRelationships(ext, lines);
                  break;
                case "ChainRules.json":
                  tables.readChainRules(ext, lines);
                  break;
                case "RuleBodySegments.json":
                  tables.readRuleBodySegments(ext, lines);
                  break;
                case "SegmentPredicates.json":
                  tables.readSegmentPredicates(ext, lines);
                  break;
                case "EntityExistentialRestrictionAxioms.json":
                  tables.readEntityExistentialRestrictionAxioms(ext, lines);
                  break;
                case "EntityUniversalRestrictionAxioms.json":
                  tables.readEntityUniversalRestrictionAxioms(ext, lines);
                  break;
                case "EntityScalarDataPropertyExistentialRestrictionAxioms.json":
                  tables.readEntityScalarDataPropertyExistentialRestrictionAxioms(ext, lines);
                  break;
                case "EntityScalarDataPropertyParticularRestrictionAxioms.json":
                  tables.readEntityScalarDataPropertyParticularRestrictionAxioms(ext, lines);
                  break;
                case "EntityScalarDataPropertyUniversalRestrictionAxioms.json":
                  tables.readEntityScalarDataPropertyUniversalRestrictionAxioms(ext, lines);
                  break;
                case "EntityStructuredDataPropertyParticularRestrictionAxioms.json":
                  tables.readEntityStructuredDataPropertyParticularRestrictionAxioms(ext, lines);
                  break;
                case "RestrictionStructuredDataPropertyTuples.json":
                  tables.readRestrictionStructuredDataPropertyTuples(ext, lines);
                  break;
                case "RestrictionScalarDataPropertyValues.json":
                  tables.readRestrictionScalarDataPropertyValues(ext, lines);
                  break;
                case "AspectSpecializationAxioms.json":
                  tables.readAspectSpecializationAxioms(ext, lines);
                  break;
                case "ConceptSpecializationAxioms.json":
                  tables.readConceptSpecializationAxioms(ext, lines);
                  break;
                case "ReifiedRelationshipSpecializationAxioms.json":
                  tables.readReifiedRelationshipSpecializationAxioms(ext, lines);
                  break;
                case "SubDataPropertyOfAxioms.json":
                  tables.readSubDataPropertyOfAxioms(ext, lines);
                  break;
                case "SubObjectPropertyOfAxioms.json":
                  tables.readSubObjectPropertyOfAxioms(ext, lines);
                  break;
                case "RootConceptTaxonomyAxioms.json":
                  tables.readRootConceptTaxonomyAxioms(ext, lines);
                  break;
                case "AnonymousConceptUnionAxioms.json":
                  tables.readAnonymousConceptUnionAxioms(ext, lines);
                  break;
                case "SpecificDisjointConceptAxioms.json":
                  tables.readSpecificDisjointConceptAxioms(ext, lines);
                  break;
                case "ConceptInstances.json":
                  tables.readConceptInstances(ext, lines);
                  break;
                case "ReifiedRelationshipInstances.json":
                  tables.readReifiedRelationshipInstances(ext, lines);
                  break;
                case "ReifiedRelationshipInstanceDomains.json":
                  tables.readReifiedRelationshipInstanceDomains(ext, lines);
                  break;
                case "ReifiedRelationshipInstanceRanges.json":
                  tables.readReifiedRelationshipInstanceRanges(ext, lines);
                  break;
                case "UnreifiedRelationshipInstanceTuples.json":
                  tables.readUnreifiedRelationshipInstanceTuples(ext, lines);
                  break;
                case "SingletonInstanceStructuredDataPropertyValues.json":
                  tables.readSingletonInstanceStructuredDataPropertyValues(ext, lines);
                  break;
                case "SingletonInstanceScalarDataPropertyValues.json":
                  tables.readSingletonInstanceScalarDataPropertyValues(ext, lines);
                  break;
                case "StructuredDataPropertyTuples.json":
                  tables.readStructuredDataPropertyTuples(ext, lines);
                  break;
                case "ScalarDataPropertyValues.json":
                  tables.readScalarDataPropertyValues(ext, lines);
                  break;
                case "AnnotationPropertyValues.json":
                  tables.readAnnotationPropertyValues(ext, lines);
                  break;
                case "CardinalityRestrictedAspects.json":
                  tables.readCardinalityRestrictedAspects(ext, lines);
                  break;
                case "CardinalityRestrictedConcepts.json":
                  tables.readCardinalityRestrictedConcepts(ext, lines);
                  break;
                case "CardinalityRestrictedReifiedRelationships.json":
                  tables.readCardinalityRestrictedReifiedRelationships(ext, lines);
                  break;
                default:
                  String _name_1 = ze.getName();
                  String _plus_1 = ("OMLSpecificationTables.load(): unrecognized table name: " + _name_1);
                  throw new IllegalArgumentException(_plus_1);
              }
            } else {
              String _name_1 = ze.getName();
              String _plus_1 = ("OMLSpecificationTables.load(): unrecognized table name: " + _name_1);
              throw new IllegalArgumentException(_plus_1);
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        };
        Collections.<ZipArchiveEntry>list(zip.getEntries()).forEach(_function);
      } finally {
        zip.close();
      }
      tables.processQueue(rs);
      tables.resolve(rs, r);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void queueModule(final gov.nasa.jpl.imce.oml.model.common.Module m) {
    this.moduleQueue.add(m);
  }
  
  public void processQueue(final ResourceSet rs) {
    Boolean more = Boolean.valueOf(false);
    do {
      {
        more = Boolean.valueOf(false);
        boolean _isEmpty = this.iriLoadQueue.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          more = Boolean.valueOf(true);
          final String iri = this.iriLoadQueue.remove();
          boolean _add = this.visitedIRIs.add(iri);
          if (_add) {
            this.loadOMLZipResource(rs, URI.createURI(iri));
          }
        }
        boolean _isEmpty_1 = this.moduleQueue.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          more = Boolean.valueOf(true);
          final gov.nasa.jpl.imce.oml.model.common.Module m = this.moduleQueue.remove();
          boolean _add_1 = this.visitedModules.add(m);
          if (_add_1) {
            this.includeModule(m);
          }
        }
      }
    } while((more).booleanValue());
  }
  
  protected void readTerminologyGraphs(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final TerminologyGraph oml = this.omlGraphsFactory.createTerminologyGraph();
        ext.getModules().add(oml);
        final String uuid = kv.remove("uuid");
        oml.setKind(OMLTables.toTerminologyKind(kv.remove("kind")));
        oml.setIri(OMLTables.toIRI(kv.remove("iri")));
        final Pair<TerminologyGraph, Map<String, String>> pair = new Pair<TerminologyGraph, Map<String, String>>(oml, kv);
        this.terminologyGraphs.put(uuid, pair);
        this.includeTerminologyGraphs(uuid, oml);
      }
    }
  }
  
  protected void readBundles(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final Bundle oml = this.omlBundlesFactory.createBundle();
        ext.getModules().add(oml);
        final String uuid = kv.remove("uuid");
        oml.setKind(OMLTables.toTerminologyKind(kv.remove("kind")));
        oml.setIri(OMLTables.toIRI(kv.remove("iri")));
        final Pair<Bundle, Map<String, String>> pair = new Pair<Bundle, Map<String, String>>(oml, kv);
        this.bundles.put(uuid, pair);
        this.includeBundles(uuid, oml);
      }
    }
  }
  
  protected void readDescriptionBoxes(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final DescriptionBox oml = this.omlDescriptionsFactory.createDescriptionBox();
        ext.getModules().add(oml);
        final String uuid = kv.remove("uuid");
        oml.setKind(OMLTables.toDescriptionKind(kv.remove("kind")));
        oml.setIri(OMLTables.toIRI(kv.remove("iri")));
        final Pair<DescriptionBox, Map<String, String>> pair = new Pair<DescriptionBox, Map<String, String>>(oml, kv);
        this.descriptionBoxes.put(uuid, pair);
        this.includeDescriptionBoxes(uuid, oml);
      }
    }
  }
  
  protected void readAnnotationProperties(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final AnnotationProperty oml = this.omlCommonFactory.createAnnotationProperty();
        final String uuid = kv.remove("uuid");
        oml.setIri(OMLTables.toIRI(kv.remove("iri")));
        oml.setAbbrevIRI(OMLTables.toAbbrevIRI(kv.remove("abbrevIRI")));
        final Pair<AnnotationProperty, Map<String, String>> pair = new Pair<AnnotationProperty, Map<String, String>>(oml, kv);
        this.annotationProperties.put(uuid, pair);
        this.includeAnnotationProperties(uuid, oml);
      }
    }
  }
  
  protected void readAspects(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final Aspect oml = this.omlTerminologiesFactory.createAspect();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<Aspect, Map<String, String>> pair = new Pair<Aspect, Map<String, String>>(oml, kv);
        this.aspects.put(uuid, pair);
        this.includeAspects(uuid, oml);
      }
    }
  }
  
  protected void readConcepts(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final Concept oml = this.omlTerminologiesFactory.createConcept();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<Concept, Map<String, String>> pair = new Pair<Concept, Map<String, String>>(oml, kv);
        this.concepts.put(uuid, pair);
        this.includeConcepts(uuid, oml);
      }
    }
  }
  
  protected void readScalars(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final Scalar oml = this.omlTerminologiesFactory.createScalar();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<Scalar, Map<String, String>> pair = new Pair<Scalar, Map<String, String>>(oml, kv);
        this.scalars.put(uuid, pair);
        this.includeScalars(uuid, oml);
      }
    }
  }
  
  protected void readStructures(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final Structure oml = this.omlTerminologiesFactory.createStructure();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<Structure, Map<String, String>> pair = new Pair<Structure, Map<String, String>>(oml, kv);
        this.structures.put(uuid, pair);
        this.includeStructures(uuid, oml);
      }
    }
  }
  
  protected void readConceptDesignationTerminologyAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ConceptDesignationTerminologyAxiom oml = this.omlGraphsFactory.createConceptDesignationTerminologyAxiom();
        final String uuid = kv.remove("uuid");
        final String designatedTerminologyIRI = kv.get("designatedTerminologyIRI");
        if ((null == designatedTerminologyIRI)) {
          String _string = kv.toString();
          String _plus = ("readConceptDesignationTerminologyAxioms: missing \'designatedTerminologyIRI\' in: " + _string);
          throw new IllegalArgumentException(_plus);
        }
        this.iriLoadQueue.add(designatedTerminologyIRI);
        final Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> pair = new Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>(oml, kv);
        this.conceptDesignationTerminologyAxioms.put(uuid, pair);
        this.includeConceptDesignationTerminologyAxioms(uuid, oml);
      }
    }
  }
  
  protected void readTerminologyExtensionAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final TerminologyExtensionAxiom oml = this.omlTerminologiesFactory.createTerminologyExtensionAxiom();
        final String uuid = kv.remove("uuid");
        final String extendedTerminologyIRI = kv.get("extendedTerminologyIRI");
        if ((null == extendedTerminologyIRI)) {
          String _string = kv.toString();
          String _plus = ("readTerminologyExtensionAxioms: missing \'extendedTerminologyIRI\' in: " + _string);
          throw new IllegalArgumentException(_plus);
        }
        this.iriLoadQueue.add(extendedTerminologyIRI);
        final Pair<TerminologyExtensionAxiom, Map<String, String>> pair = new Pair<TerminologyExtensionAxiom, Map<String, String>>(oml, kv);
        this.terminologyExtensionAxioms.put(uuid, pair);
        this.includeTerminologyExtensionAxioms(uuid, oml);
      }
    }
  }
  
  protected void readTerminologyNestingAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final TerminologyNestingAxiom oml = this.omlGraphsFactory.createTerminologyNestingAxiom();
        final String uuid = kv.remove("uuid");
        final String nestingTerminologyIRI = kv.get("nestingTerminologyIRI");
        if ((null == nestingTerminologyIRI)) {
          String _string = kv.toString();
          String _plus = ("readTerminologyNestingAxioms: missing \'nestingTerminologyIRI\' in: " + _string);
          throw new IllegalArgumentException(_plus);
        }
        this.iriLoadQueue.add(nestingTerminologyIRI);
        final Pair<TerminologyNestingAxiom, Map<String, String>> pair = new Pair<TerminologyNestingAxiom, Map<String, String>>(oml, kv);
        this.terminologyNestingAxioms.put(uuid, pair);
        this.includeTerminologyNestingAxioms(uuid, oml);
      }
    }
  }
  
  protected void readBundledTerminologyAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final BundledTerminologyAxiom oml = this.omlBundlesFactory.createBundledTerminologyAxiom();
        final String uuid = kv.remove("uuid");
        final String bundledTerminologyIRI = kv.get("bundledTerminologyIRI");
        if ((null == bundledTerminologyIRI)) {
          String _string = kv.toString();
          String _plus = ("readBundledTerminologyAxioms: missing \'bundledTerminologyIRI\' in: " + _string);
          throw new IllegalArgumentException(_plus);
        }
        this.iriLoadQueue.add(bundledTerminologyIRI);
        final Pair<BundledTerminologyAxiom, Map<String, String>> pair = new Pair<BundledTerminologyAxiom, Map<String, String>>(oml, kv);
        this.bundledTerminologyAxioms.put(uuid, pair);
        this.includeBundledTerminologyAxioms(uuid, oml);
      }
    }
  }
  
  protected void readDescriptionBoxExtendsClosedWorldDefinitions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final DescriptionBoxExtendsClosedWorldDefinitions oml = this.omlDescriptionsFactory.createDescriptionBoxExtendsClosedWorldDefinitions();
        final String uuid = kv.remove("uuid");
        final String closedWorldDefinitionsIRI = kv.get("closedWorldDefinitionsIRI");
        if ((null == closedWorldDefinitionsIRI)) {
          String _string = kv.toString();
          String _plus = ("readDescriptionBoxExtendsClosedWorldDefinitions: missing \'closedWorldDefinitionsIRI\' in: " + _string);
          throw new IllegalArgumentException(_plus);
        }
        this.iriLoadQueue.add(closedWorldDefinitionsIRI);
        final Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> pair = new Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>(oml, kv);
        this.descriptionBoxExtendsClosedWorldDefinitions.put(uuid, pair);
        this.includeDescriptionBoxExtendsClosedWorldDefinitions(uuid, oml);
      }
    }
  }
  
  protected void readDescriptionBoxRefinements(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final DescriptionBoxRefinement oml = this.omlDescriptionsFactory.createDescriptionBoxRefinement();
        final String uuid = kv.remove("uuid");
        final String refinedDescriptionBoxIRI = kv.get("refinedDescriptionBoxIRI");
        if ((null == refinedDescriptionBoxIRI)) {
          String _string = kv.toString();
          String _plus = ("readDescriptionBoxRefinements: missing \'refinedDescriptionBoxIRI\' in: " + _string);
          throw new IllegalArgumentException(_plus);
        }
        this.iriLoadQueue.add(refinedDescriptionBoxIRI);
        final Pair<DescriptionBoxRefinement, Map<String, String>> pair = new Pair<DescriptionBoxRefinement, Map<String, String>>(oml, kv);
        this.descriptionBoxRefinements.put(uuid, pair);
        this.includeDescriptionBoxRefinements(uuid, oml);
      }
    }
  }
  
  protected void readBinaryScalarRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final BinaryScalarRestriction oml = this.omlTerminologiesFactory.createBinaryScalarRestriction();
        final String uuid = kv.remove("uuid");
        final String length_value = kv.remove("length");
        if (((null != length_value) && (length_value.length() > 0))) {
          oml.setLength(OMLTables.toPositiveIntegerLiteral(length_value));
        }
        final String minLength_value = kv.remove("minLength");
        if (((null != minLength_value) && (minLength_value.length() > 0))) {
          oml.setMinLength(OMLTables.toPositiveIntegerLiteral(minLength_value));
        }
        final String maxLength_value = kv.remove("maxLength");
        if (((null != maxLength_value) && (maxLength_value.length() > 0))) {
          oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(maxLength_value));
        }
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<BinaryScalarRestriction, Map<String, String>> pair = new Pair<BinaryScalarRestriction, Map<String, String>>(oml, kv);
        this.binaryScalarRestrictions.put(uuid, pair);
        this.includeBinaryScalarRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readIRIScalarRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final IRIScalarRestriction oml = this.omlTerminologiesFactory.createIRIScalarRestriction();
        final String uuid = kv.remove("uuid");
        final String length_value = kv.remove("length");
        if (((null != length_value) && (length_value.length() > 0))) {
          oml.setLength(OMLTables.toPositiveIntegerLiteral(length_value));
        }
        final String minLength_value = kv.remove("minLength");
        if (((null != minLength_value) && (minLength_value.length() > 0))) {
          oml.setMinLength(OMLTables.toPositiveIntegerLiteral(minLength_value));
        }
        final String maxLength_value = kv.remove("maxLength");
        if (((null != maxLength_value) && (maxLength_value.length() > 0))) {
          oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(maxLength_value));
        }
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final String pattern_value = kv.remove("pattern");
        if (((null != pattern_value) && (pattern_value.length() > 0))) {
          oml.setPattern(OMLTables.toLiteralPattern(pattern_value));
        }
        final Pair<IRIScalarRestriction, Map<String, String>> pair = new Pair<IRIScalarRestriction, Map<String, String>>(oml, kv);
        this.iriScalarRestrictions.put(uuid, pair);
        this.includeIRIScalarRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readNumericScalarRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final NumericScalarRestriction oml = this.omlTerminologiesFactory.createNumericScalarRestriction();
        final String uuid = kv.remove("uuid");
        final String minExclusive_value = kv.remove("minExclusive");
        if (((null != minExclusive_value) && (minExclusive_value.length() > 0))) {
          oml.setMinExclusive(OMLTables.toLiteralNumber(minExclusive_value));
        }
        final String minInclusive_value = kv.remove("minInclusive");
        if (((null != minInclusive_value) && (minInclusive_value.length() > 0))) {
          oml.setMinInclusive(OMLTables.toLiteralNumber(minInclusive_value));
        }
        final String maxExclusive_value = kv.remove("maxExclusive");
        if (((null != maxExclusive_value) && (maxExclusive_value.length() > 0))) {
          oml.setMaxExclusive(OMLTables.toLiteralNumber(maxExclusive_value));
        }
        final String maxInclusive_value = kv.remove("maxInclusive");
        if (((null != maxInclusive_value) && (maxInclusive_value.length() > 0))) {
          oml.setMaxInclusive(OMLTables.toLiteralNumber(maxInclusive_value));
        }
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<NumericScalarRestriction, Map<String, String>> pair = new Pair<NumericScalarRestriction, Map<String, String>>(oml, kv);
        this.numericScalarRestrictions.put(uuid, pair);
        this.includeNumericScalarRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readPlainLiteralScalarRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final PlainLiteralScalarRestriction oml = this.omlTerminologiesFactory.createPlainLiteralScalarRestriction();
        final String uuid = kv.remove("uuid");
        final String length_value = kv.remove("length");
        if (((null != length_value) && (length_value.length() > 0))) {
          oml.setLength(OMLTables.toPositiveIntegerLiteral(length_value));
        }
        final String minLength_value = kv.remove("minLength");
        if (((null != minLength_value) && (minLength_value.length() > 0))) {
          oml.setMinLength(OMLTables.toPositiveIntegerLiteral(minLength_value));
        }
        final String maxLength_value = kv.remove("maxLength");
        if (((null != maxLength_value) && (maxLength_value.length() > 0))) {
          oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(maxLength_value));
        }
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final String langRange_value = kv.remove("langRange");
        if (((null != langRange_value) && (langRange_value.length() > 0))) {
          oml.setLangRange(OMLTables.toLanguageTagDataType(langRange_value));
        }
        final String pattern_value = kv.remove("pattern");
        if (((null != pattern_value) && (pattern_value.length() > 0))) {
          oml.setPattern(OMLTables.toLiteralPattern(pattern_value));
        }
        final Pair<PlainLiteralScalarRestriction, Map<String, String>> pair = new Pair<PlainLiteralScalarRestriction, Map<String, String>>(oml, kv);
        this.plainLiteralScalarRestrictions.put(uuid, pair);
        this.includePlainLiteralScalarRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readScalarOneOfRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ScalarOneOfRestriction oml = this.omlTerminologiesFactory.createScalarOneOfRestriction();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<ScalarOneOfRestriction, Map<String, String>> pair = new Pair<ScalarOneOfRestriction, Map<String, String>>(oml, kv);
        this.scalarOneOfRestrictions.put(uuid, pair);
        this.includeScalarOneOfRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readScalarOneOfLiteralAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ScalarOneOfLiteralAxiom oml = this.omlTerminologiesFactory.createScalarOneOfLiteralAxiom();
        final String uuid = kv.remove("uuid");
        oml.setValue(OMLTables.toLiteralValue(kv.remove("value")));
        final Pair<ScalarOneOfLiteralAxiom, Map<String, String>> pair = new Pair<ScalarOneOfLiteralAxiom, Map<String, String>>(oml, kv);
        this.scalarOneOfLiteralAxioms.put(uuid, pair);
        this.includeScalarOneOfLiteralAxioms(uuid, oml);
      }
    }
  }
  
  protected void readStringScalarRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final StringScalarRestriction oml = this.omlTerminologiesFactory.createStringScalarRestriction();
        final String uuid = kv.remove("uuid");
        final String length_value = kv.remove("length");
        if (((null != length_value) && (length_value.length() > 0))) {
          oml.setLength(OMLTables.toPositiveIntegerLiteral(length_value));
        }
        final String minLength_value = kv.remove("minLength");
        if (((null != minLength_value) && (minLength_value.length() > 0))) {
          oml.setMinLength(OMLTables.toPositiveIntegerLiteral(minLength_value));
        }
        final String maxLength_value = kv.remove("maxLength");
        if (((null != maxLength_value) && (maxLength_value.length() > 0))) {
          oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(maxLength_value));
        }
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final String pattern_value = kv.remove("pattern");
        if (((null != pattern_value) && (pattern_value.length() > 0))) {
          oml.setPattern(OMLTables.toLiteralPattern(pattern_value));
        }
        final Pair<StringScalarRestriction, Map<String, String>> pair = new Pair<StringScalarRestriction, Map<String, String>>(oml, kv);
        this.stringScalarRestrictions.put(uuid, pair);
        this.includeStringScalarRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readSynonymScalarRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final SynonymScalarRestriction oml = this.omlTerminologiesFactory.createSynonymScalarRestriction();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<SynonymScalarRestriction, Map<String, String>> pair = new Pair<SynonymScalarRestriction, Map<String, String>>(oml, kv);
        this.synonymScalarRestrictions.put(uuid, pair);
        this.includeSynonymScalarRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readTimeScalarRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final TimeScalarRestriction oml = this.omlTerminologiesFactory.createTimeScalarRestriction();
        final String uuid = kv.remove("uuid");
        final String minExclusive_value = kv.remove("minExclusive");
        if (((null != minExclusive_value) && (minExclusive_value.length() > 0))) {
          oml.setMinExclusive(OMLTables.toLiteralDateTime(minExclusive_value));
        }
        final String minInclusive_value = kv.remove("minInclusive");
        if (((null != minInclusive_value) && (minInclusive_value.length() > 0))) {
          oml.setMinInclusive(OMLTables.toLiteralDateTime(minInclusive_value));
        }
        final String maxExclusive_value = kv.remove("maxExclusive");
        if (((null != maxExclusive_value) && (maxExclusive_value.length() > 0))) {
          oml.setMaxExclusive(OMLTables.toLiteralDateTime(maxExclusive_value));
        }
        final String maxInclusive_value = kv.remove("maxInclusive");
        if (((null != maxInclusive_value) && (maxInclusive_value.length() > 0))) {
          oml.setMaxInclusive(OMLTables.toLiteralDateTime(maxInclusive_value));
        }
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<TimeScalarRestriction, Map<String, String>> pair = new Pair<TimeScalarRestriction, Map<String, String>>(oml, kv);
        this.timeScalarRestrictions.put(uuid, pair);
        this.includeTimeScalarRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readEntityScalarDataProperties(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final EntityScalarDataProperty oml = this.omlTerminologiesFactory.createEntityScalarDataProperty();
        final String uuid = kv.remove("uuid");
        oml.setIsIdentityCriteria((OMLTables.toEBoolean(kv.remove("isIdentityCriteria"))).booleanValue());
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<EntityScalarDataProperty, Map<String, String>> pair = new Pair<EntityScalarDataProperty, Map<String, String>>(oml, kv);
        this.entityScalarDataProperties.put(uuid, pair);
        this.includeEntityScalarDataProperties(uuid, oml);
      }
    }
  }
  
  protected void readEntityStructuredDataProperties(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final EntityStructuredDataProperty oml = this.omlTerminologiesFactory.createEntityStructuredDataProperty();
        final String uuid = kv.remove("uuid");
        oml.setIsIdentityCriteria((OMLTables.toEBoolean(kv.remove("isIdentityCriteria"))).booleanValue());
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<EntityStructuredDataProperty, Map<String, String>> pair = new Pair<EntityStructuredDataProperty, Map<String, String>>(oml, kv);
        this.entityStructuredDataProperties.put(uuid, pair);
        this.includeEntityStructuredDataProperties(uuid, oml);
      }
    }
  }
  
  protected void readScalarDataProperties(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ScalarDataProperty oml = this.omlTerminologiesFactory.createScalarDataProperty();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<ScalarDataProperty, Map<String, String>> pair = new Pair<ScalarDataProperty, Map<String, String>>(oml, kv);
        this.scalarDataProperties.put(uuid, pair);
        this.includeScalarDataProperties(uuid, oml);
      }
    }
  }
  
  protected void readStructuredDataProperties(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final StructuredDataProperty oml = this.omlTerminologiesFactory.createStructuredDataProperty();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<StructuredDataProperty, Map<String, String>> pair = new Pair<StructuredDataProperty, Map<String, String>>(oml, kv);
        this.structuredDataProperties.put(uuid, pair);
        this.includeStructuredDataProperties(uuid, oml);
      }
    }
  }
  
  protected void readReifiedRelationships(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ReifiedRelationship oml = this.omlTerminologiesFactory.createReifiedRelationship();
        final String uuid = kv.remove("uuid");
        oml.setIsAsymmetric((OMLTables.toEBoolean(kv.remove("isAsymmetric"))).booleanValue());
        oml.setIsEssential((OMLTables.toEBoolean(kv.remove("isEssential"))).booleanValue());
        oml.setIsFunctional((OMLTables.toEBoolean(kv.remove("isFunctional"))).booleanValue());
        oml.setIsInverseEssential((OMLTables.toEBoolean(kv.remove("isInverseEssential"))).booleanValue());
        oml.setIsInverseFunctional((OMLTables.toEBoolean(kv.remove("isInverseFunctional"))).booleanValue());
        oml.setIsIrreflexive((OMLTables.toEBoolean(kv.remove("isIrreflexive"))).booleanValue());
        oml.setIsReflexive((OMLTables.toEBoolean(kv.remove("isReflexive"))).booleanValue());
        oml.setIsSymmetric((OMLTables.toEBoolean(kv.remove("isSymmetric"))).booleanValue());
        oml.setIsTransitive((OMLTables.toEBoolean(kv.remove("isTransitive"))).booleanValue());
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<ReifiedRelationship, Map<String, String>> pair = new Pair<ReifiedRelationship, Map<String, String>>(oml, kv);
        this.reifiedRelationships.put(uuid, pair);
        this.includeReifiedRelationships(uuid, oml);
      }
    }
  }
  
  protected void readReifiedRelationshipRestrictions(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ReifiedRelationshipRestriction oml = this.omlTerminologiesFactory.createReifiedRelationshipRestriction();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<ReifiedRelationshipRestriction, Map<String, String>> pair = new Pair<ReifiedRelationshipRestriction, Map<String, String>>(oml, kv);
        this.reifiedRelationshipRestrictions.put(uuid, pair);
        this.includeReifiedRelationshipRestrictions(uuid, oml);
      }
    }
  }
  
  protected void readForwardProperties(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ForwardProperty oml = this.omlTerminologiesFactory.createForwardProperty();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<ForwardProperty, Map<String, String>> pair = new Pair<ForwardProperty, Map<String, String>>(oml, kv);
        this.forwardProperties.put(uuid, pair);
        this.includeForwardProperties(uuid, oml);
      }
    }
  }
  
  protected void readInverseProperties(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final InverseProperty oml = this.omlTerminologiesFactory.createInverseProperty();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<InverseProperty, Map<String, String>> pair = new Pair<InverseProperty, Map<String, String>>(oml, kv);
        this.inverseProperties.put(uuid, pair);
        this.includeInverseProperties(uuid, oml);
      }
    }
  }
  
  protected void readUnreifiedRelationships(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final UnreifiedRelationship oml = this.omlTerminologiesFactory.createUnreifiedRelationship();
        final String uuid = kv.remove("uuid");
        oml.setIsAsymmetric((OMLTables.toEBoolean(kv.remove("isAsymmetric"))).booleanValue());
        oml.setIsEssential((OMLTables.toEBoolean(kv.remove("isEssential"))).booleanValue());
        oml.setIsFunctional((OMLTables.toEBoolean(kv.remove("isFunctional"))).booleanValue());
        oml.setIsInverseEssential((OMLTables.toEBoolean(kv.remove("isInverseEssential"))).booleanValue());
        oml.setIsInverseFunctional((OMLTables.toEBoolean(kv.remove("isInverseFunctional"))).booleanValue());
        oml.setIsIrreflexive((OMLTables.toEBoolean(kv.remove("isIrreflexive"))).booleanValue());
        oml.setIsReflexive((OMLTables.toEBoolean(kv.remove("isReflexive"))).booleanValue());
        oml.setIsSymmetric((OMLTables.toEBoolean(kv.remove("isSymmetric"))).booleanValue());
        oml.setIsTransitive((OMLTables.toEBoolean(kv.remove("isTransitive"))).booleanValue());
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<UnreifiedRelationship, Map<String, String>> pair = new Pair<UnreifiedRelationship, Map<String, String>>(oml, kv);
        this.unreifiedRelationships.put(uuid, pair);
        this.includeUnreifiedRelationships(uuid, oml);
      }
    }
  }
  
  protected void readChainRules(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ChainRule oml = this.omlTerminologiesFactory.createChainRule();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<ChainRule, Map<String, String>> pair = new Pair<ChainRule, Map<String, String>>(oml, kv);
        this.chainRules.put(uuid, pair);
        this.includeChainRules(uuid, oml);
      }
    }
  }
  
  protected void readRuleBodySegments(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final RuleBodySegment oml = this.omlTerminologiesFactory.createRuleBodySegment();
        final String uuid = kv.remove("uuid");
        final Pair<RuleBodySegment, Map<String, String>> pair = new Pair<RuleBodySegment, Map<String, String>>(oml, kv);
        this.ruleBodySegments.put(uuid, pair);
        this.includeRuleBodySegments(uuid, oml);
      }
    }
  }
  
  protected void readSegmentPredicates(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final SegmentPredicate oml = this.omlTerminologiesFactory.createSegmentPredicate();
        final String uuid = kv.remove("uuid");
        final Pair<SegmentPredicate, Map<String, String>> pair = new Pair<SegmentPredicate, Map<String, String>>(oml, kv);
        this.segmentPredicates.put(uuid, pair);
        this.includeSegmentPredicates(uuid, oml);
      }
    }
  }
  
  protected void readEntityExistentialRestrictionAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final EntityExistentialRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityExistentialRestrictionAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<EntityExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityExistentialRestrictionAxiom, Map<String, String>>(oml, kv);
        this.entityExistentialRestrictionAxioms.put(uuid, pair);
        this.includeEntityExistentialRestrictionAxioms(uuid, oml);
      }
    }
  }
  
  protected void readEntityUniversalRestrictionAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final EntityUniversalRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityUniversalRestrictionAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<EntityUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityUniversalRestrictionAxiom, Map<String, String>>(oml, kv);
        this.entityUniversalRestrictionAxioms.put(uuid, pair);
        this.includeEntityUniversalRestrictionAxioms(uuid, oml);
      }
    }
  }
  
  protected void readEntityScalarDataPropertyExistentialRestrictionAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final EntityScalarDataPropertyExistentialRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityScalarDataPropertyExistentialRestrictionAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>(oml, kv);
        this.entityScalarDataPropertyExistentialRestrictionAxioms.put(uuid, pair);
        this.includeEntityScalarDataPropertyExistentialRestrictionAxioms(uuid, oml);
      }
    }
  }
  
  protected void readEntityScalarDataPropertyParticularRestrictionAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final EntityScalarDataPropertyParticularRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityScalarDataPropertyParticularRestrictionAxiom();
        final String uuid = kv.remove("uuid");
        oml.setLiteralValue(OMLTables.toLiteralValue(kv.remove("literalValue")));
        final Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>(oml, kv);
        this.entityScalarDataPropertyParticularRestrictionAxioms.put(uuid, pair);
        this.includeEntityScalarDataPropertyParticularRestrictionAxioms(uuid, oml);
      }
    }
  }
  
  protected void readEntityScalarDataPropertyUniversalRestrictionAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final EntityScalarDataPropertyUniversalRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityScalarDataPropertyUniversalRestrictionAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>(oml, kv);
        this.entityScalarDataPropertyUniversalRestrictionAxioms.put(uuid, pair);
        this.includeEntityScalarDataPropertyUniversalRestrictionAxioms(uuid, oml);
      }
    }
  }
  
  protected void readEntityStructuredDataPropertyParticularRestrictionAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final EntityStructuredDataPropertyParticularRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityStructuredDataPropertyParticularRestrictionAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>(oml, kv);
        this.entityStructuredDataPropertyParticularRestrictionAxioms.put(uuid, pair);
        this.includeEntityStructuredDataPropertyParticularRestrictionAxioms(uuid, oml);
      }
    }
  }
  
  protected void readRestrictionStructuredDataPropertyTuples(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final RestrictionStructuredDataPropertyTuple oml = this.omlTerminologiesFactory.createRestrictionStructuredDataPropertyTuple();
        final String uuid = kv.remove("uuid");
        final Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>> pair = new Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>(oml, kv);
        this.restrictionStructuredDataPropertyTuples.put(uuid, pair);
        this.includeRestrictionStructuredDataPropertyTuples(uuid, oml);
      }
    }
  }
  
  protected void readRestrictionScalarDataPropertyValues(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final RestrictionScalarDataPropertyValue oml = this.omlTerminologiesFactory.createRestrictionScalarDataPropertyValue();
        final String uuid = kv.remove("uuid");
        oml.setScalarPropertyValue(OMLTables.toLiteralValue(kv.remove("scalarPropertyValue")));
        final Pair<RestrictionScalarDataPropertyValue, Map<String, String>> pair = new Pair<RestrictionScalarDataPropertyValue, Map<String, String>>(oml, kv);
        this.restrictionScalarDataPropertyValues.put(uuid, pair);
        this.includeRestrictionScalarDataPropertyValues(uuid, oml);
      }
    }
  }
  
  protected void readAspectSpecializationAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final AspectSpecializationAxiom oml = this.omlTerminologiesFactory.createAspectSpecializationAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<AspectSpecializationAxiom, Map<String, String>> pair = new Pair<AspectSpecializationAxiom, Map<String, String>>(oml, kv);
        this.aspectSpecializationAxioms.put(uuid, pair);
        this.includeAspectSpecializationAxioms(uuid, oml);
      }
    }
  }
  
  protected void readConceptSpecializationAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ConceptSpecializationAxiom oml = this.omlTerminologiesFactory.createConceptSpecializationAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<ConceptSpecializationAxiom, Map<String, String>> pair = new Pair<ConceptSpecializationAxiom, Map<String, String>>(oml, kv);
        this.conceptSpecializationAxioms.put(uuid, pair);
        this.includeConceptSpecializationAxioms(uuid, oml);
      }
    }
  }
  
  protected void readReifiedRelationshipSpecializationAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ReifiedRelationshipSpecializationAxiom oml = this.omlTerminologiesFactory.createReifiedRelationshipSpecializationAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>> pair = new Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>(oml, kv);
        this.reifiedRelationshipSpecializationAxioms.put(uuid, pair);
        this.includeReifiedRelationshipSpecializationAxioms(uuid, oml);
      }
    }
  }
  
  protected void readSubDataPropertyOfAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final SubDataPropertyOfAxiom oml = this.omlTerminologiesFactory.createSubDataPropertyOfAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<SubDataPropertyOfAxiom, Map<String, String>> pair = new Pair<SubDataPropertyOfAxiom, Map<String, String>>(oml, kv);
        this.subDataPropertyOfAxioms.put(uuid, pair);
        this.includeSubDataPropertyOfAxioms(uuid, oml);
      }
    }
  }
  
  protected void readSubObjectPropertyOfAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final SubObjectPropertyOfAxiom oml = this.omlTerminologiesFactory.createSubObjectPropertyOfAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<SubObjectPropertyOfAxiom, Map<String, String>> pair = new Pair<SubObjectPropertyOfAxiom, Map<String, String>>(oml, kv);
        this.subObjectPropertyOfAxioms.put(uuid, pair);
        this.includeSubObjectPropertyOfAxioms(uuid, oml);
      }
    }
  }
  
  protected void readRootConceptTaxonomyAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final RootConceptTaxonomyAxiom oml = this.omlBundlesFactory.createRootConceptTaxonomyAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<RootConceptTaxonomyAxiom, Map<String, String>> pair = new Pair<RootConceptTaxonomyAxiom, Map<String, String>>(oml, kv);
        this.rootConceptTaxonomyAxioms.put(uuid, pair);
        this.includeRootConceptTaxonomyAxioms(uuid, oml);
      }
    }
  }
  
  protected void readAnonymousConceptUnionAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final AnonymousConceptUnionAxiom oml = this.omlBundlesFactory.createAnonymousConceptUnionAxiom();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<AnonymousConceptUnionAxiom, Map<String, String>> pair = new Pair<AnonymousConceptUnionAxiom, Map<String, String>>(oml, kv);
        this.anonymousConceptUnionAxioms.put(uuid, pair);
        this.includeAnonymousConceptUnionAxioms(uuid, oml);
      }
    }
  }
  
  protected void readSpecificDisjointConceptAxioms(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final SpecificDisjointConceptAxiom oml = this.omlBundlesFactory.createSpecificDisjointConceptAxiom();
        final String uuid = kv.remove("uuid");
        final Pair<SpecificDisjointConceptAxiom, Map<String, String>> pair = new Pair<SpecificDisjointConceptAxiom, Map<String, String>>(oml, kv);
        this.specificDisjointConceptAxioms.put(uuid, pair);
        this.includeSpecificDisjointConceptAxioms(uuid, oml);
      }
    }
  }
  
  protected void readConceptInstances(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ConceptInstance oml = this.omlDescriptionsFactory.createConceptInstance();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<ConceptInstance, Map<String, String>> pair = new Pair<ConceptInstance, Map<String, String>>(oml, kv);
        this.conceptInstances.put(uuid, pair);
        this.includeConceptInstances(uuid, oml);
      }
    }
  }
  
  protected void readReifiedRelationshipInstances(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ReifiedRelationshipInstance oml = this.omlDescriptionsFactory.createReifiedRelationshipInstance();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<ReifiedRelationshipInstance, Map<String, String>> pair = new Pair<ReifiedRelationshipInstance, Map<String, String>>(oml, kv);
        this.reifiedRelationshipInstances.put(uuid, pair);
        this.includeReifiedRelationshipInstances(uuid, oml);
      }
    }
  }
  
  protected void readReifiedRelationshipInstanceDomains(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ReifiedRelationshipInstanceDomain oml = this.omlDescriptionsFactory.createReifiedRelationshipInstanceDomain();
        final String uuid = kv.remove("uuid");
        final Pair<ReifiedRelationshipInstanceDomain, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>(oml, kv);
        this.reifiedRelationshipInstanceDomains.put(uuid, pair);
        this.includeReifiedRelationshipInstanceDomains(uuid, oml);
      }
    }
  }
  
  protected void readReifiedRelationshipInstanceRanges(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ReifiedRelationshipInstanceRange oml = this.omlDescriptionsFactory.createReifiedRelationshipInstanceRange();
        final String uuid = kv.remove("uuid");
        final Pair<ReifiedRelationshipInstanceRange, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceRange, Map<String, String>>(oml, kv);
        this.reifiedRelationshipInstanceRanges.put(uuid, pair);
        this.includeReifiedRelationshipInstanceRanges(uuid, oml);
      }
    }
  }
  
  protected void readUnreifiedRelationshipInstanceTuples(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final UnreifiedRelationshipInstanceTuple oml = this.omlDescriptionsFactory.createUnreifiedRelationshipInstanceTuple();
        final String uuid = kv.remove("uuid");
        final Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>> pair = new Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>(oml, kv);
        this.unreifiedRelationshipInstanceTuples.put(uuid, pair);
        this.includeUnreifiedRelationshipInstanceTuples(uuid, oml);
      }
    }
  }
  
  protected void readSingletonInstanceStructuredDataPropertyValues(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final SingletonInstanceStructuredDataPropertyValue oml = this.omlDescriptionsFactory.createSingletonInstanceStructuredDataPropertyValue();
        final String uuid = kv.remove("uuid");
        final Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>(oml, kv);
        this.singletonInstanceStructuredDataPropertyValues.put(uuid, pair);
        this.includeSingletonInstanceStructuredDataPropertyValues(uuid, oml);
      }
    }
  }
  
  protected void readSingletonInstanceScalarDataPropertyValues(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final SingletonInstanceScalarDataPropertyValue oml = this.omlDescriptionsFactory.createSingletonInstanceScalarDataPropertyValue();
        final String uuid = kv.remove("uuid");
        oml.setScalarPropertyValue(OMLTables.toLiteralValue(kv.remove("scalarPropertyValue")));
        final Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>(oml, kv);
        this.singletonInstanceScalarDataPropertyValues.put(uuid, pair);
        this.includeSingletonInstanceScalarDataPropertyValues(uuid, oml);
      }
    }
  }
  
  protected void readStructuredDataPropertyTuples(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final StructuredDataPropertyTuple oml = this.omlDescriptionsFactory.createStructuredDataPropertyTuple();
        final String uuid = kv.remove("uuid");
        final Pair<StructuredDataPropertyTuple, Map<String, String>> pair = new Pair<StructuredDataPropertyTuple, Map<String, String>>(oml, kv);
        this.structuredDataPropertyTuples.put(uuid, pair);
        this.includeStructuredDataPropertyTuples(uuid, oml);
      }
    }
  }
  
  protected void readScalarDataPropertyValues(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final ScalarDataPropertyValue oml = this.omlDescriptionsFactory.createScalarDataPropertyValue();
        final String uuid = kv.remove("uuid");
        oml.setScalarPropertyValue(OMLTables.toLiteralValue(kv.remove("scalarPropertyValue")));
        final Pair<ScalarDataPropertyValue, Map<String, String>> pair = new Pair<ScalarDataPropertyValue, Map<String, String>>(oml, kv);
        this.scalarDataPropertyValues.put(uuid, pair);
        this.includeScalarDataPropertyValues(uuid, oml);
      }
    }
  }
  
  protected void readAnnotationPropertyValues(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final AnnotationPropertyValue oml = this.omlCommonFactory.createAnnotationPropertyValue();
        final String uuid = kv.remove("uuid");
        oml.setValue(OMLTables.toLiteralString(kv.remove("value")));
        final Pair<AnnotationPropertyValue, Map<String, String>> pair = new Pair<AnnotationPropertyValue, Map<String, String>>(oml, kv);
        this.annotationPropertyValues.put(uuid, pair);
        this.includeAnnotationPropertyValues(uuid, oml);
      }
    }
  }
  
  protected void readCardinalityRestrictedAspects(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final CardinalityRestrictedAspect oml = this.omlTerminologiesFactory.createCardinalityRestrictedAspect();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        oml.setRestrictedCardinality(OMLTables.toPositiveIntegerLiteral(kv.remove("restrictedCardinality")));
        oml.setRestrictionKind(OMLTables.toCardinalityRestrictionKind(kv.remove("restrictionKind")));
        final Pair<CardinalityRestrictedAspect, Map<String, String>> pair = new Pair<CardinalityRestrictedAspect, Map<String, String>>(oml, kv);
        this.cardinalityRestrictedAspects.put(uuid, pair);
        this.includeCardinalityRestrictedAspects(uuid, oml);
      }
    }
  }
  
  protected void readCardinalityRestrictedConcepts(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final CardinalityRestrictedConcept oml = this.omlTerminologiesFactory.createCardinalityRestrictedConcept();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        oml.setRestrictedCardinality(OMLTables.toPositiveIntegerLiteral(kv.remove("restrictedCardinality")));
        oml.setRestrictionKind(OMLTables.toCardinalityRestrictionKind(kv.remove("restrictionKind")));
        final Pair<CardinalityRestrictedConcept, Map<String, String>> pair = new Pair<CardinalityRestrictedConcept, Map<String, String>>(oml, kv);
        this.cardinalityRestrictedConcepts.put(uuid, pair);
        this.includeCardinalityRestrictedConcepts(uuid, oml);
      }
    }
  }
  
  protected void readCardinalityRestrictedReifiedRelationships(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final CardinalityRestrictedReifiedRelationship oml = this.omlTerminologiesFactory.createCardinalityRestrictedReifiedRelationship();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        oml.setRestrictedCardinality(OMLTables.toPositiveIntegerLiteral(kv.remove("restrictedCardinality")));
        oml.setRestrictionKind(OMLTables.toCardinalityRestrictionKind(kv.remove("restrictionKind")));
        final Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>> pair = new Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>>(oml, kv);
        this.cardinalityRestrictedReifiedRelationships.put(uuid, pair);
        this.includeCardinalityRestrictedReifiedRelationships(uuid, oml);
      }
    }
  }
  
  protected <U extends Object, V extends U> Boolean includeMap(final Map<String, Pair<U, Map<String, String>>> uMap, final Map<String, Pair<V, Map<String, String>>> vMap) {
    Boolean _xblockexpression = null;
    {
      final Boolean[] updated = ((Boolean[])Conversions.unwrapArray(Collections.<Boolean>unmodifiableSet(CollectionLiterals.<Boolean>newHashSet(Boolean.valueOf(false))), Boolean.class));
      final BiConsumer<String, Pair<V, Map<String, String>>> _function = (String uuid, Pair<V, Map<String, String>> kv) -> {
        V _key = kv.getKey();
        Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
        Pair<U, Map<String, String>> _pair = new Pair<U, Map<String, String>>(_key, _emptyMap);
        final Pair<U, Map<String, String>> prev = uMap.put(uuid, _pair);
        if ((null == prev)) {
          updated[0] = Boolean.valueOf(true);
        }
      };
      vMap.forEach(_function);
      _xblockexpression = updated[0];
    }
    return _xblockexpression;
  }
  
  protected void includeTerminologyGraphs(final String uuid, final TerminologyGraph oml) {
    this.queueModule(oml);
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>> _pair = new Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>>(oml, _emptyMap);
    this.modules.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap_1);
    this.logicalElements.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<TerminologyBox, Map<String, String>> _pair_2 = new Pair<TerminologyBox, Map<String, String>>(oml, _emptyMap_2);
    this.terminologyBoxes.put(uuid, _pair_2);
    String _iri = oml.iri();
    Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
    Pair<TerminologyBox, Map<String, String>> _pair_3 = new Pair<TerminologyBox, Map<String, String>>(oml, _emptyMap_3);
    this.terminologyBoxes.put(_iri, _pair_3);
  }
  
  protected void includeBundles(final String uuid, final Bundle oml) {
    this.queueModule(oml);
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>> _pair = new Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>>(oml, _emptyMap);
    this.modules.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap_1);
    this.logicalElements.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<TerminologyBox, Map<String, String>> _pair_2 = new Pair<TerminologyBox, Map<String, String>>(oml, _emptyMap_2);
    this.terminologyBoxes.put(uuid, _pair_2);
    String _iri = oml.iri();
    Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
    Pair<TerminologyBox, Map<String, String>> _pair_3 = new Pair<TerminologyBox, Map<String, String>>(oml, _emptyMap_3);
    this.terminologyBoxes.put(_iri, _pair_3);
  }
  
  protected void includeDescriptionBoxes(final String uuid, final DescriptionBox oml) {
    this.queueModule(oml);
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>> _pair = new Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>>(oml, _emptyMap);
    this.modules.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap_1);
    this.logicalElements.put(uuid, _pair_1);
  }
  
  protected void includeAnnotationProperties(final String uuid, final AnnotationProperty oml) {
  }
  
  protected void includeAspects(final String uuid, final Aspect oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Entity, Map<String, String>> _pair_1 = new Pair<Entity, Map<String, String>>(oml, _emptyMap_1);
    this.entities.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_2 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_2);
    this.predicates.put(uuid, _pair_2);
  }
  
  protected void includeConcepts(final String uuid, final Concept oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Entity, Map<String, String>> _pair_1 = new Pair<Entity, Map<String, String>>(oml, _emptyMap_1);
    this.entities.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_2 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_2);
    this.predicates.put(uuid, _pair_2);
  }
  
  protected void includeScalars(final String uuid, final Scalar oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includeStructures(final String uuid, final Structure oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeConceptDesignationTerminologyAxioms(final String uuid, final ConceptDesignationTerminologyAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeTerminologyExtensionAxioms(final String uuid, final TerminologyExtensionAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeTerminologyNestingAxioms(final String uuid, final TerminologyNestingAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeBundledTerminologyAxioms(final String uuid, final BundledTerminologyAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeDescriptionBoxExtendsClosedWorldDefinitions(final String uuid, final DescriptionBoxExtendsClosedWorldDefinitions oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeDescriptionBoxRefinements(final String uuid, final DescriptionBoxRefinement oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeBinaryScalarRestrictions(final String uuid, final BinaryScalarRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includeIRIScalarRestrictions(final String uuid, final IRIScalarRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includeNumericScalarRestrictions(final String uuid, final NumericScalarRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includePlainLiteralScalarRestrictions(final String uuid, final PlainLiteralScalarRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includeScalarOneOfRestrictions(final String uuid, final ScalarOneOfRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includeScalarOneOfLiteralAxioms(final String uuid, final ScalarOneOfLiteralAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeStringScalarRestrictions(final String uuid, final StringScalarRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includeSynonymScalarRestrictions(final String uuid, final SynonymScalarRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includeTimeScalarRestrictions(final String uuid, final TimeScalarRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRange, Map<String, String>> _pair_1 = new Pair<DataRange, Map<String, String>>(oml, _emptyMap_1);
    this.dataRanges.put(uuid, _pair_1);
  }
  
  protected void includeEntityScalarDataProperties(final String uuid, final EntityScalarDataProperty oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRelationshipToScalar, Map<String, String>> _pair_1 = new Pair<DataRelationshipToScalar, Map<String, String>>(oml, _emptyMap_1);
    this.dataRelationshipToScalars.put(uuid, _pair_1);
  }
  
  protected void includeEntityStructuredDataProperties(final String uuid, final EntityStructuredDataProperty oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRelationshipToStructure, Map<String, String>> _pair_1 = new Pair<DataRelationshipToStructure, Map<String, String>>(oml, _emptyMap_1);
    this.dataRelationshipToStructures.put(uuid, _pair_1);
  }
  
  protected void includeScalarDataProperties(final String uuid, final ScalarDataProperty oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRelationshipToScalar, Map<String, String>> _pair_1 = new Pair<DataRelationshipToScalar, Map<String, String>>(oml, _emptyMap_1);
    this.dataRelationshipToScalars.put(uuid, _pair_1);
  }
  
  protected void includeStructuredDataProperties(final String uuid, final StructuredDataProperty oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<DataRelationshipToStructure, Map<String, String>> _pair_1 = new Pair<DataRelationshipToStructure, Map<String, String>>(oml, _emptyMap_1);
    this.dataRelationshipToStructures.put(uuid, _pair_1);
  }
  
  protected void includeReifiedRelationships(final String uuid, final ReifiedRelationship oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Entity, Map<String, String>> _pair_1 = new Pair<Entity, Map<String, String>>(oml, _emptyMap_1);
    this.entities.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<EntityRelationship, Map<String, String>> _pair_2 = new Pair<EntityRelationship, Map<String, String>>(oml, _emptyMap_2);
    this.entityRelationships.put(uuid, _pair_2);
    Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
    Pair<ConceptualRelationship, Map<String, String>> _pair_3 = new Pair<ConceptualRelationship, Map<String, String>>(oml, _emptyMap_3);
    this.conceptualRelationships.put(uuid, _pair_3);
    Map<String, String> _emptyMap_4 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_4 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_4);
    this.predicates.put(uuid, _pair_4);
  }
  
  protected void includeReifiedRelationshipRestrictions(final String uuid, final ReifiedRelationshipRestriction oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Entity, Map<String, String>> _pair_1 = new Pair<Entity, Map<String, String>>(oml, _emptyMap_1);
    this.entities.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<EntityRelationship, Map<String, String>> _pair_2 = new Pair<EntityRelationship, Map<String, String>>(oml, _emptyMap_2);
    this.entityRelationships.put(uuid, _pair_2);
    Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
    Pair<ConceptualRelationship, Map<String, String>> _pair_3 = new Pair<ConceptualRelationship, Map<String, String>>(oml, _emptyMap_3);
    this.conceptualRelationships.put(uuid, _pair_3);
    Map<String, String> _emptyMap_4 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_4 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_4);
    this.predicates.put(uuid, _pair_4);
  }
  
  protected void includeForwardProperties(final String uuid, final ForwardProperty oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_1 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_1);
    this.predicates.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<RestrictableRelationship, Map<String, String>> _pair_2 = new Pair<RestrictableRelationship, Map<String, String>>(oml, _emptyMap_2);
    this.restrictableRelationships.put(uuid, _pair_2);
  }
  
  protected void includeInverseProperties(final String uuid, final InverseProperty oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_1 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_1);
    this.predicates.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<RestrictableRelationship, Map<String, String>> _pair_2 = new Pair<RestrictableRelationship, Map<String, String>>(oml, _emptyMap_2);
    this.restrictableRelationships.put(uuid, _pair_2);
  }
  
  protected void includeUnreifiedRelationships(final String uuid, final UnreifiedRelationship oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<EntityRelationship, Map<String, String>> _pair_1 = new Pair<EntityRelationship, Map<String, String>>(oml, _emptyMap_1);
    this.entityRelationships.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_2 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_2);
    this.predicates.put(uuid, _pair_2);
    Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
    Pair<RestrictableRelationship, Map<String, String>> _pair_3 = new Pair<RestrictableRelationship, Map<String, String>>(oml, _emptyMap_3);
    this.restrictableRelationships.put(uuid, _pair_3);
  }
  
  protected void includeChainRules(final String uuid, final ChainRule oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeRuleBodySegments(final String uuid, final RuleBodySegment oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeSegmentPredicates(final String uuid, final SegmentPredicate oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeEntityExistentialRestrictionAxioms(final String uuid, final EntityExistentialRestrictionAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeEntityUniversalRestrictionAxioms(final String uuid, final EntityUniversalRestrictionAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeEntityScalarDataPropertyExistentialRestrictionAxioms(final String uuid, final EntityScalarDataPropertyExistentialRestrictionAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeEntityScalarDataPropertyParticularRestrictionAxioms(final String uuid, final EntityScalarDataPropertyParticularRestrictionAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeEntityScalarDataPropertyUniversalRestrictionAxioms(final String uuid, final EntityScalarDataPropertyUniversalRestrictionAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeEntityStructuredDataPropertyParticularRestrictionAxioms(final String uuid, final EntityStructuredDataPropertyParticularRestrictionAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> _pair_1 = new Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>(oml, _emptyMap_1);
    this.restrictionStructuredDataPropertyContexts.put(uuid, _pair_1);
  }
  
  protected void includeRestrictionStructuredDataPropertyTuples(final String uuid, final RestrictionStructuredDataPropertyTuple oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> _pair_1 = new Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>(oml, _emptyMap_1);
    this.restrictionStructuredDataPropertyContexts.put(uuid, _pair_1);
  }
  
  protected void includeRestrictionScalarDataPropertyValues(final String uuid, final RestrictionScalarDataPropertyValue oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeAspectSpecializationAxioms(final String uuid, final AspectSpecializationAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeConceptSpecializationAxioms(final String uuid, final ConceptSpecializationAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeReifiedRelationshipSpecializationAxioms(final String uuid, final ReifiedRelationshipSpecializationAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeSubDataPropertyOfAxioms(final String uuid, final SubDataPropertyOfAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeSubObjectPropertyOfAxioms(final String uuid, final SubObjectPropertyOfAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeRootConceptTaxonomyAxioms(final String uuid, final RootConceptTaxonomyAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<ConceptTreeDisjunction, Map<String, String>> _pair_1 = new Pair<ConceptTreeDisjunction, Map<String, String>>(oml, _emptyMap_1);
    this.conceptTreeDisjunctions.put(uuid, _pair_1);
  }
  
  protected void includeAnonymousConceptUnionAxioms(final String uuid, final AnonymousConceptUnionAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<ConceptTreeDisjunction, Map<String, String>> _pair_1 = new Pair<ConceptTreeDisjunction, Map<String, String>>(oml, _emptyMap_1);
    this.conceptTreeDisjunctions.put(uuid, _pair_1);
  }
  
  protected void includeSpecificDisjointConceptAxioms(final String uuid, final SpecificDisjointConceptAxiom oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeConceptInstances(final String uuid, final ConceptInstance oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<ConceptualEntitySingletonInstance, Map<String, String>> _pair_1 = new Pair<ConceptualEntitySingletonInstance, Map<String, String>>(oml, _emptyMap_1);
    this.conceptualEntitySingletonInstances.put(uuid, _pair_1);
  }
  
  protected void includeReifiedRelationshipInstances(final String uuid, final ReifiedRelationshipInstance oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<ConceptualEntitySingletonInstance, Map<String, String>> _pair_1 = new Pair<ConceptualEntitySingletonInstance, Map<String, String>>(oml, _emptyMap_1);
    this.conceptualEntitySingletonInstances.put(uuid, _pair_1);
  }
  
  protected void includeReifiedRelationshipInstanceDomains(final String uuid, final ReifiedRelationshipInstanceDomain oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeReifiedRelationshipInstanceRanges(final String uuid, final ReifiedRelationshipInstanceRange oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeUnreifiedRelationshipInstanceTuples(final String uuid, final UnreifiedRelationshipInstanceTuple oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeSingletonInstanceStructuredDataPropertyValues(final String uuid, final SingletonInstanceStructuredDataPropertyValue oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> _pair_1 = new Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>(oml, _emptyMap_1);
    this.singletonInstanceStructuredDataPropertyContexts.put(uuid, _pair_1);
  }
  
  protected void includeSingletonInstanceScalarDataPropertyValues(final String uuid, final SingletonInstanceScalarDataPropertyValue oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeStructuredDataPropertyTuples(final String uuid, final StructuredDataPropertyTuple oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> _pair_1 = new Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>(oml, _emptyMap_1);
    this.singletonInstanceStructuredDataPropertyContexts.put(uuid, _pair_1);
  }
  
  protected void includeScalarDataPropertyValues(final String uuid, final ScalarDataPropertyValue oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
  }
  
  protected void includeAnnotationPropertyValues(final String uuid, final AnnotationPropertyValue oml) {
  }
  
  protected void includeCardinalityRestrictedAspects(final String uuid, final CardinalityRestrictedAspect oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Entity, Map<String, String>> _pair_1 = new Pair<Entity, Map<String, String>>(oml, _emptyMap_1);
    this.entities.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_2 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_2);
    this.predicates.put(uuid, _pair_2);
  }
  
  protected void includeCardinalityRestrictedConcepts(final String uuid, final CardinalityRestrictedConcept oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Entity, Map<String, String>> _pair_1 = new Pair<Entity, Map<String, String>>(oml, _emptyMap_1);
    this.entities.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_2 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_2);
    this.predicates.put(uuid, _pair_2);
  }
  
  protected void includeCardinalityRestrictedReifiedRelationships(final String uuid, final CardinalityRestrictedReifiedRelationship oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap);
    this.logicalElements.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<Entity, Map<String, String>> _pair_1 = new Pair<Entity, Map<String, String>>(oml, _emptyMap_1);
    this.entities.put(uuid, _pair_1);
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<EntityRelationship, Map<String, String>> _pair_2 = new Pair<EntityRelationship, Map<String, String>>(oml, _emptyMap_2);
    this.entityRelationships.put(uuid, _pair_2);
    Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
    Pair<ConceptualRelationship, Map<String, String>> _pair_3 = new Pair<ConceptualRelationship, Map<String, String>>(oml, _emptyMap_3);
    this.conceptualRelationships.put(uuid, _pair_3);
    Map<String, String> _emptyMap_4 = Collections.<String, String>emptyMap();
    Pair<Predicate, Map<String, String>> _pair_4 = new Pair<Predicate, Map<String, String>>(oml, _emptyMap_4);
    this.predicates.put(uuid, _pair_4);
  }
  
  protected void resolve(final ResourceSet rs, final OMLZipResource r) {
    URI _uRI = r.getURI();
    String _plus = ("Resolve: " + _uRI);
    System.out.println(_plus);
    final long t0 = System.currentTimeMillis();
    Boolean _includeMap = this.<LogicalElement, TerminologyGraph>includeMap(this.logicalElements, this.terminologyGraphs);
    if ((_includeMap).booleanValue()) {
      System.out.println("+ logicalElements, terminologyGraphs");
    }
    Boolean _includeMap_1 = this.<LogicalElement, Bundle>includeMap(this.logicalElements, this.bundles);
    if ((_includeMap_1).booleanValue()) {
      System.out.println("+ logicalElements, bundles");
    }
    Boolean _includeMap_2 = this.<LogicalElement, DescriptionBox>includeMap(this.logicalElements, this.descriptionBoxes);
    if ((_includeMap_2).booleanValue()) {
      System.out.println("+ logicalElements, descriptionBoxes");
    }
    Boolean _includeMap_3 = this.<LogicalElement, Aspect>includeMap(this.logicalElements, this.aspects);
    if ((_includeMap_3).booleanValue()) {
      System.out.println("+ logicalElements, aspects");
    }
    Boolean _includeMap_4 = this.<LogicalElement, Concept>includeMap(this.logicalElements, this.concepts);
    if ((_includeMap_4).booleanValue()) {
      System.out.println("+ logicalElements, concepts");
    }
    Boolean _includeMap_5 = this.<LogicalElement, Scalar>includeMap(this.logicalElements, this.scalars);
    if ((_includeMap_5).booleanValue()) {
      System.out.println("+ logicalElements, scalars");
    }
    Boolean _includeMap_6 = this.<LogicalElement, Structure>includeMap(this.logicalElements, this.structures);
    if ((_includeMap_6).booleanValue()) {
      System.out.println("+ logicalElements, structures");
    }
    Boolean _includeMap_7 = this.<LogicalElement, ConceptDesignationTerminologyAxiom>includeMap(this.logicalElements, this.conceptDesignationTerminologyAxioms);
    if ((_includeMap_7).booleanValue()) {
      System.out.println("+ logicalElements, conceptDesignationTerminologyAxioms");
    }
    Boolean _includeMap_8 = this.<LogicalElement, TerminologyExtensionAxiom>includeMap(this.logicalElements, this.terminologyExtensionAxioms);
    if ((_includeMap_8).booleanValue()) {
      System.out.println("+ logicalElements, terminologyExtensionAxioms");
    }
    Boolean _includeMap_9 = this.<LogicalElement, TerminologyNestingAxiom>includeMap(this.logicalElements, this.terminologyNestingAxioms);
    if ((_includeMap_9).booleanValue()) {
      System.out.println("+ logicalElements, terminologyNestingAxioms");
    }
    Boolean _includeMap_10 = this.<LogicalElement, BundledTerminologyAxiom>includeMap(this.logicalElements, this.bundledTerminologyAxioms);
    if ((_includeMap_10).booleanValue()) {
      System.out.println("+ logicalElements, bundledTerminologyAxioms");
    }
    Boolean _includeMap_11 = this.<LogicalElement, DescriptionBoxExtendsClosedWorldDefinitions>includeMap(this.logicalElements, this.descriptionBoxExtendsClosedWorldDefinitions);
    if ((_includeMap_11).booleanValue()) {
      System.out.println("+ logicalElements, descriptionBoxExtendsClosedWorldDefinitions");
    }
    Boolean _includeMap_12 = this.<LogicalElement, DescriptionBoxRefinement>includeMap(this.logicalElements, this.descriptionBoxRefinements);
    if ((_includeMap_12).booleanValue()) {
      System.out.println("+ logicalElements, descriptionBoxRefinements");
    }
    Boolean _includeMap_13 = this.<LogicalElement, BinaryScalarRestriction>includeMap(this.logicalElements, this.binaryScalarRestrictions);
    if ((_includeMap_13).booleanValue()) {
      System.out.println("+ logicalElements, binaryScalarRestrictions");
    }
    Boolean _includeMap_14 = this.<LogicalElement, IRIScalarRestriction>includeMap(this.logicalElements, this.iriScalarRestrictions);
    if ((_includeMap_14).booleanValue()) {
      System.out.println("+ logicalElements, iriScalarRestrictions");
    }
    Boolean _includeMap_15 = this.<LogicalElement, NumericScalarRestriction>includeMap(this.logicalElements, this.numericScalarRestrictions);
    if ((_includeMap_15).booleanValue()) {
      System.out.println("+ logicalElements, numericScalarRestrictions");
    }
    Boolean _includeMap_16 = this.<LogicalElement, PlainLiteralScalarRestriction>includeMap(this.logicalElements, this.plainLiteralScalarRestrictions);
    if ((_includeMap_16).booleanValue()) {
      System.out.println("+ logicalElements, plainLiteralScalarRestrictions");
    }
    Boolean _includeMap_17 = this.<LogicalElement, ScalarOneOfRestriction>includeMap(this.logicalElements, this.scalarOneOfRestrictions);
    if ((_includeMap_17).booleanValue()) {
      System.out.println("+ logicalElements, scalarOneOfRestrictions");
    }
    Boolean _includeMap_18 = this.<LogicalElement, ScalarOneOfLiteralAxiom>includeMap(this.logicalElements, this.scalarOneOfLiteralAxioms);
    if ((_includeMap_18).booleanValue()) {
      System.out.println("+ logicalElements, scalarOneOfLiteralAxioms");
    }
    Boolean _includeMap_19 = this.<LogicalElement, StringScalarRestriction>includeMap(this.logicalElements, this.stringScalarRestrictions);
    if ((_includeMap_19).booleanValue()) {
      System.out.println("+ logicalElements, stringScalarRestrictions");
    }
    Boolean _includeMap_20 = this.<LogicalElement, SynonymScalarRestriction>includeMap(this.logicalElements, this.synonymScalarRestrictions);
    if ((_includeMap_20).booleanValue()) {
      System.out.println("+ logicalElements, synonymScalarRestrictions");
    }
    Boolean _includeMap_21 = this.<LogicalElement, TimeScalarRestriction>includeMap(this.logicalElements, this.timeScalarRestrictions);
    if ((_includeMap_21).booleanValue()) {
      System.out.println("+ logicalElements, timeScalarRestrictions");
    }
    Boolean _includeMap_22 = this.<LogicalElement, EntityScalarDataProperty>includeMap(this.logicalElements, this.entityScalarDataProperties);
    if ((_includeMap_22).booleanValue()) {
      System.out.println("+ logicalElements, entityScalarDataProperties");
    }
    Boolean _includeMap_23 = this.<LogicalElement, EntityStructuredDataProperty>includeMap(this.logicalElements, this.entityStructuredDataProperties);
    if ((_includeMap_23).booleanValue()) {
      System.out.println("+ logicalElements, entityStructuredDataProperties");
    }
    Boolean _includeMap_24 = this.<LogicalElement, ScalarDataProperty>includeMap(this.logicalElements, this.scalarDataProperties);
    if ((_includeMap_24).booleanValue()) {
      System.out.println("+ logicalElements, scalarDataProperties");
    }
    Boolean _includeMap_25 = this.<LogicalElement, StructuredDataProperty>includeMap(this.logicalElements, this.structuredDataProperties);
    if ((_includeMap_25).booleanValue()) {
      System.out.println("+ logicalElements, structuredDataProperties");
    }
    Boolean _includeMap_26 = this.<LogicalElement, ReifiedRelationship>includeMap(this.logicalElements, this.reifiedRelationships);
    if ((_includeMap_26).booleanValue()) {
      System.out.println("+ logicalElements, reifiedRelationships");
    }
    Boolean _includeMap_27 = this.<LogicalElement, ReifiedRelationshipRestriction>includeMap(this.logicalElements, this.reifiedRelationshipRestrictions);
    if ((_includeMap_27).booleanValue()) {
      System.out.println("+ logicalElements, reifiedRelationshipRestrictions");
    }
    Boolean _includeMap_28 = this.<LogicalElement, ForwardProperty>includeMap(this.logicalElements, this.forwardProperties);
    if ((_includeMap_28).booleanValue()) {
      System.out.println("+ logicalElements, forwardProperties");
    }
    Boolean _includeMap_29 = this.<LogicalElement, InverseProperty>includeMap(this.logicalElements, this.inverseProperties);
    if ((_includeMap_29).booleanValue()) {
      System.out.println("+ logicalElements, inverseProperties");
    }
    Boolean _includeMap_30 = this.<LogicalElement, UnreifiedRelationship>includeMap(this.logicalElements, this.unreifiedRelationships);
    if ((_includeMap_30).booleanValue()) {
      System.out.println("+ logicalElements, unreifiedRelationships");
    }
    Boolean _includeMap_31 = this.<LogicalElement, ChainRule>includeMap(this.logicalElements, this.chainRules);
    if ((_includeMap_31).booleanValue()) {
      System.out.println("+ logicalElements, chainRules");
    }
    Boolean _includeMap_32 = this.<LogicalElement, RuleBodySegment>includeMap(this.logicalElements, this.ruleBodySegments);
    if ((_includeMap_32).booleanValue()) {
      System.out.println("+ logicalElements, ruleBodySegments");
    }
    Boolean _includeMap_33 = this.<LogicalElement, SegmentPredicate>includeMap(this.logicalElements, this.segmentPredicates);
    if ((_includeMap_33).booleanValue()) {
      System.out.println("+ logicalElements, segmentPredicates");
    }
    Boolean _includeMap_34 = this.<LogicalElement, EntityExistentialRestrictionAxiom>includeMap(this.logicalElements, this.entityExistentialRestrictionAxioms);
    if ((_includeMap_34).booleanValue()) {
      System.out.println("+ logicalElements, entityExistentialRestrictionAxioms");
    }
    Boolean _includeMap_35 = this.<LogicalElement, EntityUniversalRestrictionAxiom>includeMap(this.logicalElements, this.entityUniversalRestrictionAxioms);
    if ((_includeMap_35).booleanValue()) {
      System.out.println("+ logicalElements, entityUniversalRestrictionAxioms");
    }
    Boolean _includeMap_36 = this.<LogicalElement, EntityScalarDataPropertyExistentialRestrictionAxiom>includeMap(this.logicalElements, this.entityScalarDataPropertyExistentialRestrictionAxioms);
    if ((_includeMap_36).booleanValue()) {
      System.out.println("+ logicalElements, entityScalarDataPropertyExistentialRestrictionAxioms");
    }
    Boolean _includeMap_37 = this.<LogicalElement, EntityScalarDataPropertyParticularRestrictionAxiom>includeMap(this.logicalElements, this.entityScalarDataPropertyParticularRestrictionAxioms);
    if ((_includeMap_37).booleanValue()) {
      System.out.println("+ logicalElements, entityScalarDataPropertyParticularRestrictionAxioms");
    }
    Boolean _includeMap_38 = this.<LogicalElement, EntityScalarDataPropertyUniversalRestrictionAxiom>includeMap(this.logicalElements, this.entityScalarDataPropertyUniversalRestrictionAxioms);
    if ((_includeMap_38).booleanValue()) {
      System.out.println("+ logicalElements, entityScalarDataPropertyUniversalRestrictionAxioms");
    }
    Boolean _includeMap_39 = this.<LogicalElement, EntityStructuredDataPropertyParticularRestrictionAxiom>includeMap(this.logicalElements, this.entityStructuredDataPropertyParticularRestrictionAxioms);
    if ((_includeMap_39).booleanValue()) {
      System.out.println("+ logicalElements, entityStructuredDataPropertyParticularRestrictionAxioms");
    }
    Boolean _includeMap_40 = this.<LogicalElement, RestrictionStructuredDataPropertyTuple>includeMap(this.logicalElements, this.restrictionStructuredDataPropertyTuples);
    if ((_includeMap_40).booleanValue()) {
      System.out.println("+ logicalElements, restrictionStructuredDataPropertyTuples");
    }
    Boolean _includeMap_41 = this.<LogicalElement, RestrictionScalarDataPropertyValue>includeMap(this.logicalElements, this.restrictionScalarDataPropertyValues);
    if ((_includeMap_41).booleanValue()) {
      System.out.println("+ logicalElements, restrictionScalarDataPropertyValues");
    }
    Boolean _includeMap_42 = this.<LogicalElement, AspectSpecializationAxiom>includeMap(this.logicalElements, this.aspectSpecializationAxioms);
    if ((_includeMap_42).booleanValue()) {
      System.out.println("+ logicalElements, aspectSpecializationAxioms");
    }
    Boolean _includeMap_43 = this.<LogicalElement, ConceptSpecializationAxiom>includeMap(this.logicalElements, this.conceptSpecializationAxioms);
    if ((_includeMap_43).booleanValue()) {
      System.out.println("+ logicalElements, conceptSpecializationAxioms");
    }
    Boolean _includeMap_44 = this.<LogicalElement, ReifiedRelationshipSpecializationAxiom>includeMap(this.logicalElements, this.reifiedRelationshipSpecializationAxioms);
    if ((_includeMap_44).booleanValue()) {
      System.out.println("+ logicalElements, reifiedRelationshipSpecializationAxioms");
    }
    Boolean _includeMap_45 = this.<LogicalElement, SubDataPropertyOfAxiom>includeMap(this.logicalElements, this.subDataPropertyOfAxioms);
    if ((_includeMap_45).booleanValue()) {
      System.out.println("+ logicalElements, subDataPropertyOfAxioms");
    }
    Boolean _includeMap_46 = this.<LogicalElement, SubObjectPropertyOfAxiom>includeMap(this.logicalElements, this.subObjectPropertyOfAxioms);
    if ((_includeMap_46).booleanValue()) {
      System.out.println("+ logicalElements, subObjectPropertyOfAxioms");
    }
    Boolean _includeMap_47 = this.<LogicalElement, RootConceptTaxonomyAxiom>includeMap(this.logicalElements, this.rootConceptTaxonomyAxioms);
    if ((_includeMap_47).booleanValue()) {
      System.out.println("+ logicalElements, rootConceptTaxonomyAxioms");
    }
    Boolean _includeMap_48 = this.<LogicalElement, AnonymousConceptUnionAxiom>includeMap(this.logicalElements, this.anonymousConceptUnionAxioms);
    if ((_includeMap_48).booleanValue()) {
      System.out.println("+ logicalElements, anonymousConceptUnionAxioms");
    }
    Boolean _includeMap_49 = this.<LogicalElement, SpecificDisjointConceptAxiom>includeMap(this.logicalElements, this.specificDisjointConceptAxioms);
    if ((_includeMap_49).booleanValue()) {
      System.out.println("+ logicalElements, specificDisjointConceptAxioms");
    }
    Boolean _includeMap_50 = this.<LogicalElement, ConceptInstance>includeMap(this.logicalElements, this.conceptInstances);
    if ((_includeMap_50).booleanValue()) {
      System.out.println("+ logicalElements, conceptInstances");
    }
    Boolean _includeMap_51 = this.<LogicalElement, ReifiedRelationshipInstance>includeMap(this.logicalElements, this.reifiedRelationshipInstances);
    if ((_includeMap_51).booleanValue()) {
      System.out.println("+ logicalElements, reifiedRelationshipInstances");
    }
    Boolean _includeMap_52 = this.<LogicalElement, ReifiedRelationshipInstanceDomain>includeMap(this.logicalElements, this.reifiedRelationshipInstanceDomains);
    if ((_includeMap_52).booleanValue()) {
      System.out.println("+ logicalElements, reifiedRelationshipInstanceDomains");
    }
    Boolean _includeMap_53 = this.<LogicalElement, ReifiedRelationshipInstanceRange>includeMap(this.logicalElements, this.reifiedRelationshipInstanceRanges);
    if ((_includeMap_53).booleanValue()) {
      System.out.println("+ logicalElements, reifiedRelationshipInstanceRanges");
    }
    Boolean _includeMap_54 = this.<LogicalElement, UnreifiedRelationshipInstanceTuple>includeMap(this.logicalElements, this.unreifiedRelationshipInstanceTuples);
    if ((_includeMap_54).booleanValue()) {
      System.out.println("+ logicalElements, unreifiedRelationshipInstanceTuples");
    }
    Boolean _includeMap_55 = this.<LogicalElement, SingletonInstanceStructuredDataPropertyValue>includeMap(this.logicalElements, this.singletonInstanceStructuredDataPropertyValues);
    if ((_includeMap_55).booleanValue()) {
      System.out.println("+ logicalElements, singletonInstanceStructuredDataPropertyValues");
    }
    Boolean _includeMap_56 = this.<LogicalElement, SingletonInstanceScalarDataPropertyValue>includeMap(this.logicalElements, this.singletonInstanceScalarDataPropertyValues);
    if ((_includeMap_56).booleanValue()) {
      System.out.println("+ logicalElements, singletonInstanceScalarDataPropertyValues");
    }
    Boolean _includeMap_57 = this.<LogicalElement, StructuredDataPropertyTuple>includeMap(this.logicalElements, this.structuredDataPropertyTuples);
    if ((_includeMap_57).booleanValue()) {
      System.out.println("+ logicalElements, structuredDataPropertyTuples");
    }
    Boolean _includeMap_58 = this.<LogicalElement, ScalarDataPropertyValue>includeMap(this.logicalElements, this.scalarDataPropertyValues);
    if ((_includeMap_58).booleanValue()) {
      System.out.println("+ logicalElements, scalarDataPropertyValues");
    }
    Boolean _includeMap_59 = this.<LogicalElement, CardinalityRestrictedAspect>includeMap(this.logicalElements, this.cardinalityRestrictedAspects);
    if ((_includeMap_59).booleanValue()) {
      System.out.println("+ logicalElements, cardinalityRestrictedAspects");
    }
    Boolean _includeMap_60 = this.<LogicalElement, CardinalityRestrictedConcept>includeMap(this.logicalElements, this.cardinalityRestrictedConcepts);
    if ((_includeMap_60).booleanValue()) {
      System.out.println("+ logicalElements, cardinalityRestrictedConcepts");
    }
    Boolean _includeMap_61 = this.<LogicalElement, CardinalityRestrictedReifiedRelationship>includeMap(this.logicalElements, this.cardinalityRestrictedReifiedRelationships);
    if ((_includeMap_61).booleanValue()) {
      System.out.println("+ logicalElements, cardinalityRestrictedReifiedRelationships");
    }
    Boolean _includeMap_62 = this.<Entity, Aspect>includeMap(this.entities, this.aspects);
    if ((_includeMap_62).booleanValue()) {
      System.out.println("+ entities, aspects");
    }
    Boolean _includeMap_63 = this.<Entity, Concept>includeMap(this.entities, this.concepts);
    if ((_includeMap_63).booleanValue()) {
      System.out.println("+ entities, concepts");
    }
    Boolean _includeMap_64 = this.<Entity, ReifiedRelationship>includeMap(this.entities, this.reifiedRelationships);
    if ((_includeMap_64).booleanValue()) {
      System.out.println("+ entities, reifiedRelationships");
    }
    Boolean _includeMap_65 = this.<Entity, ReifiedRelationshipRestriction>includeMap(this.entities, this.reifiedRelationshipRestrictions);
    if ((_includeMap_65).booleanValue()) {
      System.out.println("+ entities, reifiedRelationshipRestrictions");
    }
    Boolean _includeMap_66 = this.<Entity, CardinalityRestrictedAspect>includeMap(this.entities, this.cardinalityRestrictedAspects);
    if ((_includeMap_66).booleanValue()) {
      System.out.println("+ entities, cardinalityRestrictedAspects");
    }
    Boolean _includeMap_67 = this.<Entity, CardinalityRestrictedConcept>includeMap(this.entities, this.cardinalityRestrictedConcepts);
    if ((_includeMap_67).booleanValue()) {
      System.out.println("+ entities, cardinalityRestrictedConcepts");
    }
    Boolean _includeMap_68 = this.<Entity, CardinalityRestrictedReifiedRelationship>includeMap(this.entities, this.cardinalityRestrictedReifiedRelationships);
    if ((_includeMap_68).booleanValue()) {
      System.out.println("+ entities, cardinalityRestrictedReifiedRelationships");
    }
    Boolean _includeMap_69 = this.<EntityRelationship, ReifiedRelationship>includeMap(this.entityRelationships, this.reifiedRelationships);
    if ((_includeMap_69).booleanValue()) {
      System.out.println("+ entities, reifiedRelationships");
    }
    Boolean _includeMap_70 = this.<EntityRelationship, ReifiedRelationshipRestriction>includeMap(this.entityRelationships, this.reifiedRelationshipRestrictions);
    if ((_includeMap_70).booleanValue()) {
      System.out.println("+ entities, reifiedRelationshipRestrictions");
    }
    Boolean _includeMap_71 = this.<EntityRelationship, UnreifiedRelationship>includeMap(this.entityRelationships, this.unreifiedRelationships);
    if ((_includeMap_71).booleanValue()) {
      System.out.println("+ entities, unreifiedRelationships");
    }
    Boolean _includeMap_72 = this.<EntityRelationship, CardinalityRestrictedReifiedRelationship>includeMap(this.entityRelationships, this.cardinalityRestrictedReifiedRelationships);
    if ((_includeMap_72).booleanValue()) {
      System.out.println("+ entities, cardinalityRestrictedReifiedRelationships");
    }
    Boolean _includeMap_73 = this.<ConceptualRelationship, ReifiedRelationship>includeMap(this.conceptualRelationships, this.reifiedRelationships);
    if ((_includeMap_73).booleanValue()) {
      System.out.println("+ entities, reifiedRelationships");
    }
    Boolean _includeMap_74 = this.<ConceptualRelationship, ReifiedRelationshipRestriction>includeMap(this.conceptualRelationships, this.reifiedRelationshipRestrictions);
    if ((_includeMap_74).booleanValue()) {
      System.out.println("+ entities, reifiedRelationshipRestrictions");
    }
    Boolean _includeMap_75 = this.<ConceptualRelationship, CardinalityRestrictedReifiedRelationship>includeMap(this.conceptualRelationships, this.cardinalityRestrictedReifiedRelationships);
    if ((_includeMap_75).booleanValue()) {
      System.out.println("+ entities, cardinalityRestrictedReifiedRelationships");
    }
    Boolean _includeMap_76 = this.<DataRange, Scalar>includeMap(this.dataRanges, this.scalars);
    if ((_includeMap_76).booleanValue()) {
      System.out.println("+ entities, scalars");
    }
    Boolean _includeMap_77 = this.<DataRange, BinaryScalarRestriction>includeMap(this.dataRanges, this.binaryScalarRestrictions);
    if ((_includeMap_77).booleanValue()) {
      System.out.println("+ entities, binaryScalarRestrictions");
    }
    Boolean _includeMap_78 = this.<DataRange, IRIScalarRestriction>includeMap(this.dataRanges, this.iriScalarRestrictions);
    if ((_includeMap_78).booleanValue()) {
      System.out.println("+ entities, iriScalarRestrictions");
    }
    Boolean _includeMap_79 = this.<DataRange, NumericScalarRestriction>includeMap(this.dataRanges, this.numericScalarRestrictions);
    if ((_includeMap_79).booleanValue()) {
      System.out.println("+ entities, numericScalarRestrictions");
    }
    Boolean _includeMap_80 = this.<DataRange, PlainLiteralScalarRestriction>includeMap(this.dataRanges, this.plainLiteralScalarRestrictions);
    if ((_includeMap_80).booleanValue()) {
      System.out.println("+ entities, plainLiteralScalarRestrictions");
    }
    Boolean _includeMap_81 = this.<DataRange, ScalarOneOfRestriction>includeMap(this.dataRanges, this.scalarOneOfRestrictions);
    if ((_includeMap_81).booleanValue()) {
      System.out.println("+ entities, scalarOneOfRestrictions");
    }
    Boolean _includeMap_82 = this.<DataRange, StringScalarRestriction>includeMap(this.dataRanges, this.stringScalarRestrictions);
    if ((_includeMap_82).booleanValue()) {
      System.out.println("+ entities, stringScalarRestrictions");
    }
    Boolean _includeMap_83 = this.<DataRange, SynonymScalarRestriction>includeMap(this.dataRanges, this.synonymScalarRestrictions);
    if ((_includeMap_83).booleanValue()) {
      System.out.println("+ entities, synonymScalarRestrictions");
    }
    Boolean _includeMap_84 = this.<DataRange, TimeScalarRestriction>includeMap(this.dataRanges, this.timeScalarRestrictions);
    if ((_includeMap_84).booleanValue()) {
      System.out.println("+ entities, timeScalarRestrictions");
    }
    Boolean _includeMap_85 = this.<DataRelationshipToScalar, EntityScalarDataProperty>includeMap(this.dataRelationshipToScalars, this.entityScalarDataProperties);
    if ((_includeMap_85).booleanValue()) {
      System.out.println("+ entities, entityScalarDataProperties");
    }
    Boolean _includeMap_86 = this.<DataRelationshipToScalar, ScalarDataProperty>includeMap(this.dataRelationshipToScalars, this.scalarDataProperties);
    if ((_includeMap_86).booleanValue()) {
      System.out.println("+ entities, scalarDataProperties");
    }
    Boolean _includeMap_87 = this.<DataRelationshipToStructure, EntityStructuredDataProperty>includeMap(this.dataRelationshipToStructures, this.entityStructuredDataProperties);
    if ((_includeMap_87).booleanValue()) {
      System.out.println("+ entities, entityStructuredDataProperties");
    }
    Boolean _includeMap_88 = this.<DataRelationshipToStructure, StructuredDataProperty>includeMap(this.dataRelationshipToStructures, this.structuredDataProperties);
    if ((_includeMap_88).booleanValue()) {
      System.out.println("+ entities, structuredDataProperties");
    }
    Boolean _includeMap_89 = this.<Predicate, Aspect>includeMap(this.predicates, this.aspects);
    if ((_includeMap_89).booleanValue()) {
      System.out.println("+ entities, aspects");
    }
    Boolean _includeMap_90 = this.<Predicate, Concept>includeMap(this.predicates, this.concepts);
    if ((_includeMap_90).booleanValue()) {
      System.out.println("+ entities, concepts");
    }
    Boolean _includeMap_91 = this.<Predicate, ReifiedRelationship>includeMap(this.predicates, this.reifiedRelationships);
    if ((_includeMap_91).booleanValue()) {
      System.out.println("+ entities, reifiedRelationships");
    }
    Boolean _includeMap_92 = this.<Predicate, ReifiedRelationshipRestriction>includeMap(this.predicates, this.reifiedRelationshipRestrictions);
    if ((_includeMap_92).booleanValue()) {
      System.out.println("+ entities, reifiedRelationshipRestrictions");
    }
    Boolean _includeMap_93 = this.<Predicate, ForwardProperty>includeMap(this.predicates, this.forwardProperties);
    if ((_includeMap_93).booleanValue()) {
      System.out.println("+ entities, forwardProperties");
    }
    Boolean _includeMap_94 = this.<Predicate, InverseProperty>includeMap(this.predicates, this.inverseProperties);
    if ((_includeMap_94).booleanValue()) {
      System.out.println("+ entities, inverseProperties");
    }
    Boolean _includeMap_95 = this.<Predicate, UnreifiedRelationship>includeMap(this.predicates, this.unreifiedRelationships);
    if ((_includeMap_95).booleanValue()) {
      System.out.println("+ entities, unreifiedRelationships");
    }
    Boolean _includeMap_96 = this.<Predicate, CardinalityRestrictedAspect>includeMap(this.predicates, this.cardinalityRestrictedAspects);
    if ((_includeMap_96).booleanValue()) {
      System.out.println("+ entities, cardinalityRestrictedAspects");
    }
    Boolean _includeMap_97 = this.<Predicate, CardinalityRestrictedConcept>includeMap(this.predicates, this.cardinalityRestrictedConcepts);
    if ((_includeMap_97).booleanValue()) {
      System.out.println("+ entities, cardinalityRestrictedConcepts");
    }
    Boolean _includeMap_98 = this.<Predicate, CardinalityRestrictedReifiedRelationship>includeMap(this.predicates, this.cardinalityRestrictedReifiedRelationships);
    if ((_includeMap_98).booleanValue()) {
      System.out.println("+ entities, cardinalityRestrictedReifiedRelationships");
    }
    Boolean _includeMap_99 = this.<RestrictableRelationship, ForwardProperty>includeMap(this.restrictableRelationships, this.forwardProperties);
    if ((_includeMap_99).booleanValue()) {
      System.out.println("+ entities, forwardProperties");
    }
    Boolean _includeMap_100 = this.<RestrictableRelationship, InverseProperty>includeMap(this.restrictableRelationships, this.inverseProperties);
    if ((_includeMap_100).booleanValue()) {
      System.out.println("+ entities, inverseProperties");
    }
    Boolean _includeMap_101 = this.<RestrictableRelationship, UnreifiedRelationship>includeMap(this.restrictableRelationships, this.unreifiedRelationships);
    if ((_includeMap_101).booleanValue()) {
      System.out.println("+ entities, unreifiedRelationships");
    }
    Boolean _includeMap_102 = this.<RestrictionStructuredDataPropertyContext, EntityStructuredDataPropertyParticularRestrictionAxiom>includeMap(this.restrictionStructuredDataPropertyContexts, this.entityStructuredDataPropertyParticularRestrictionAxioms);
    if ((_includeMap_102).booleanValue()) {
      System.out.println("+ entities, entityStructuredDataPropertyParticularRestrictionAxioms");
    }
    Boolean _includeMap_103 = this.<RestrictionStructuredDataPropertyContext, RestrictionStructuredDataPropertyTuple>includeMap(this.restrictionStructuredDataPropertyContexts, this.restrictionStructuredDataPropertyTuples);
    if ((_includeMap_103).booleanValue()) {
      System.out.println("+ entities, restrictionStructuredDataPropertyTuples");
    }
    Boolean _includeMap_104 = this.<TerminologyBox, TerminologyGraph>includeMap(this.terminologyBoxes, this.terminologyGraphs);
    if ((_includeMap_104).booleanValue()) {
      System.out.println("+ entities, terminologyGraphs");
    }
    Boolean _includeMap_105 = this.<TerminologyBox, Bundle>includeMap(this.terminologyBoxes, this.bundles);
    if ((_includeMap_105).booleanValue()) {
      System.out.println("+ entities, bundles");
    }
    Boolean _includeMap_106 = this.<ConceptTreeDisjunction, RootConceptTaxonomyAxiom>includeMap(this.conceptTreeDisjunctions, this.rootConceptTaxonomyAxioms);
    if ((_includeMap_106).booleanValue()) {
      System.out.println("+ entities, rootConceptTaxonomyAxioms");
    }
    Boolean _includeMap_107 = this.<ConceptTreeDisjunction, AnonymousConceptUnionAxiom>includeMap(this.conceptTreeDisjunctions, this.anonymousConceptUnionAxioms);
    if ((_includeMap_107).booleanValue()) {
      System.out.println("+ entities, anonymousConceptUnionAxioms");
    }
    Boolean _includeMap_108 = this.<ConceptualEntitySingletonInstance, ConceptInstance>includeMap(this.conceptualEntitySingletonInstances, this.conceptInstances);
    if ((_includeMap_108).booleanValue()) {
      System.out.println("+ entities, conceptInstances");
    }
    Boolean _includeMap_109 = this.<ConceptualEntitySingletonInstance, ReifiedRelationshipInstance>includeMap(this.conceptualEntitySingletonInstances, this.reifiedRelationshipInstances);
    if ((_includeMap_109).booleanValue()) {
      System.out.println("+ entities, reifiedRelationshipInstances");
    }
    Boolean _includeMap_110 = this.<SingletonInstanceStructuredDataPropertyContext, SingletonInstanceStructuredDataPropertyValue>includeMap(this.singletonInstanceStructuredDataPropertyContexts, this.singletonInstanceStructuredDataPropertyValues);
    if ((_includeMap_110).booleanValue()) {
      System.out.println("+ entities, singletonInstanceStructuredDataPropertyValues");
    }
    Boolean _includeMap_111 = this.<SingletonInstanceStructuredDataPropertyContext, StructuredDataPropertyTuple>includeMap(this.singletonInstanceStructuredDataPropertyContexts, this.structuredDataPropertyTuples);
    if ((_includeMap_111).booleanValue()) {
      System.out.println("+ entities, structuredDataPropertyTuples");
    }
    int iterations = 0;
    final ArrayList<Boolean> progress = new ArrayList<Boolean>(1);
    final ArrayList<Boolean> allDone = new ArrayList<Boolean>(1);
    progress.add(Boolean.valueOf(false));
    allDone.add(Boolean.valueOf(false));
    do {
      {
        progress.set(0, Boolean.valueOf(false));
        allDone.set(0, Boolean.valueOf(true));
        int _iterations = iterations;
        iterations = (_iterations + 1);
        System.out.println(("Resolve iterations: " + Integer.valueOf(iterations)));
        this.resolveAnnotationProperties(rs, progress, allDone);
        this.resolveAspects(rs, progress, allDone);
        this.resolveConcepts(rs, progress, allDone);
        this.resolveScalars(rs, progress, allDone);
        this.resolveStructures(rs, progress, allDone);
        this.resolveConceptDesignationTerminologyAxioms(rs, progress, allDone);
        this.resolveTerminologyExtensionAxioms(rs, progress, allDone);
        this.resolveTerminologyNestingAxioms(rs, progress, allDone);
        this.resolveBundledTerminologyAxioms(rs, progress, allDone);
        this.resolveDescriptionBoxExtendsClosedWorldDefinitions(rs, progress, allDone);
        this.resolveDescriptionBoxRefinements(rs, progress, allDone);
        this.resolveBinaryScalarRestrictions(rs, progress, allDone);
        this.resolveIRIScalarRestrictions(rs, progress, allDone);
        this.resolveNumericScalarRestrictions(rs, progress, allDone);
        this.resolvePlainLiteralScalarRestrictions(rs, progress, allDone);
        this.resolveScalarOneOfRestrictions(rs, progress, allDone);
        this.resolveScalarOneOfLiteralAxioms(rs, progress, allDone);
        this.resolveStringScalarRestrictions(rs, progress, allDone);
        this.resolveSynonymScalarRestrictions(rs, progress, allDone);
        this.resolveTimeScalarRestrictions(rs, progress, allDone);
        this.resolveEntityScalarDataProperties(rs, progress, allDone);
        this.resolveEntityStructuredDataProperties(rs, progress, allDone);
        this.resolveScalarDataProperties(rs, progress, allDone);
        this.resolveStructuredDataProperties(rs, progress, allDone);
        this.resolveReifiedRelationships(rs, progress, allDone);
        this.resolveReifiedRelationshipRestrictions(rs, progress, allDone);
        this.resolveForwardProperties(rs, progress, allDone);
        this.resolveInverseProperties(rs, progress, allDone);
        this.resolveUnreifiedRelationships(rs, progress, allDone);
        this.resolveChainRules(rs, progress, allDone);
        this.resolveRuleBodySegments(rs, progress, allDone);
        this.resolveSegmentPredicates(rs, progress, allDone);
        this.resolveEntityExistentialRestrictionAxioms(rs, progress, allDone);
        this.resolveEntityUniversalRestrictionAxioms(rs, progress, allDone);
        this.resolveEntityScalarDataPropertyExistentialRestrictionAxioms(rs, progress, allDone);
        this.resolveEntityScalarDataPropertyParticularRestrictionAxioms(rs, progress, allDone);
        this.resolveEntityScalarDataPropertyUniversalRestrictionAxioms(rs, progress, allDone);
        this.resolveEntityStructuredDataPropertyParticularRestrictionAxioms(rs, progress, allDone);
        this.resolveRestrictionStructuredDataPropertyTuples(rs, progress, allDone);
        this.resolveRestrictionScalarDataPropertyValues(rs, progress, allDone);
        this.resolveAspectSpecializationAxioms(rs, progress, allDone);
        this.resolveConceptSpecializationAxioms(rs, progress, allDone);
        this.resolveReifiedRelationshipSpecializationAxioms(rs, progress, allDone);
        this.resolveSubDataPropertyOfAxioms(rs, progress, allDone);
        this.resolveSubObjectPropertyOfAxioms(rs, progress, allDone);
        this.resolveRootConceptTaxonomyAxioms(rs, progress, allDone);
        this.resolveAnonymousConceptUnionAxioms(rs, progress, allDone);
        this.resolveSpecificDisjointConceptAxioms(rs, progress, allDone);
        this.resolveConceptInstances(rs, progress, allDone);
        this.resolveReifiedRelationshipInstances(rs, progress, allDone);
        this.resolveReifiedRelationshipInstanceDomains(rs, progress, allDone);
        this.resolveReifiedRelationshipInstanceRanges(rs, progress, allDone);
        this.resolveUnreifiedRelationshipInstanceTuples(rs, progress, allDone);
        this.resolveSingletonInstanceStructuredDataPropertyValues(rs, progress, allDone);
        this.resolveSingletonInstanceScalarDataPropertyValues(rs, progress, allDone);
        this.resolveStructuredDataPropertyTuples(rs, progress, allDone);
        this.resolveScalarDataPropertyValues(rs, progress, allDone);
        this.resolveAnnotationPropertyValues(rs, progress, allDone);
        this.resolveCardinalityRestrictedAspects(rs, progress, allDone);
        this.resolveCardinalityRestrictedConcepts(rs, progress, allDone);
        this.resolveCardinalityRestrictedReifiedRelationships(rs, progress, allDone);
      }
    } while((((!(allDone.get(0)).booleanValue()) && (!(progress.get(0)).booleanValue())) && (iterations < 10)));
    if (((!(allDone.get(0)).booleanValue()) && (!(progress.get(0)).booleanValue()))) {
      throw new IllegalArgumentException((("Failed to resolve cross references within " + Integer.valueOf(iterations)) + " iterations."));
    }
    long _currentTimeMillis = System.currentTimeMillis();
    final long dt = (t0 - _currentTimeMillis);
    final long ms = (dt % 1000);
    final long s = (dt / 1000);
    URI _uRI_1 = r.getURI();
    String _plus_1 = ("Resolve: " + _uRI_1);
    String _plus_2 = (_plus_1 + " in ");
    String _plus_3 = (_plus_2 + Long.valueOf(s));
    String _plus_4 = (_plus_3 + "s, ");
    String _plus_5 = (_plus_4 + Long.valueOf(ms));
    String _plus_6 = (_plus_5 + "ms");
    System.out.println(_plus_6);
  }
  
  protected void resolveAnnotationProperties(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<AnnotationProperty, Map<String, String>>> _function = (String uuid, Pair<AnnotationProperty, Map<String, String>> oml_kv) -> {
      final AnnotationProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String moduleXRef = kv.get("moduleUUID");
        final Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>> modulePair = this.modules.get(moduleXRef);
        if ((null != modulePair)) {
          oml.setModule(modulePair.getKey());
          kv.remove("moduleUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.annotationProperties.forEach(_function);
  }
  
  protected void resolveAspects(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<Aspect, Map<String, String>>> _function = (String uuid, Pair<Aspect, Map<String, String>> oml_kv) -> {
      final Aspect oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.aspects.forEach(_function);
  }
  
  protected void resolveConcepts(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<Concept, Map<String, String>>> _function = (String uuid, Pair<Concept, Map<String, String>> oml_kv) -> {
      final Concept oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.concepts.forEach(_function);
  }
  
  protected void resolveScalars(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<Scalar, Map<String, String>>> _function = (String uuid, Pair<Scalar, Map<String, String>> oml_kv) -> {
      final Scalar oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.scalars.forEach(_function);
  }
  
  protected void resolveStructures(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<Structure, Map<String, String>>> _function = (String uuid, Pair<Structure, Map<String, String>> oml_kv) -> {
      final Structure oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.structures.forEach(_function);
  }
  
  protected void resolveConceptDesignationTerminologyAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    boolean more = false;
    do {
      {
        final HashMap<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>> queue = new HashMap<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>>();
        final Function2<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>, Boolean> _function = (String uuid, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> oml_kv) -> {
          boolean _isEmpty = oml_kv.getValue().isEmpty();
          return Boolean.valueOf((!_isEmpty));
        };
        final BiConsumer<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>> _function_1 = (String uuid, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> oml_kv) -> {
          queue.put(uuid, oml_kv);
        };
        MapExtensions.<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>>filter(this.conceptDesignationTerminologyAxioms, _function).forEach(_function_1);
        boolean _isEmpty = queue.isEmpty();
        boolean _not = (!_isEmpty);
        more = _not;
        if (more) {
          final BiConsumer<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>> _function_2 = (String uuid, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> oml_kv) -> {
            final ConceptDesignationTerminologyAxiom oml = oml_kv.getKey();
            final Map<String, String> kv = oml_kv.getValue();
            boolean _isEmpty_1 = kv.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              allDone.set(0, Boolean.valueOf(false));
              final String tboxXRef = kv.get("tboxUUID");
              final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
              if ((null != tboxPair)) {
                oml.setTbox(tboxPair.getKey());
                kv.remove("tboxUUID");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
              final String designatedConceptXRef = kv.get("designatedConceptUUID");
              final Pair<ConceptKind, Map<String, String>> designatedConceptPair = this.conceptKinds.get(designatedConceptXRef);
              if ((null != designatedConceptPair)) {
                oml.setDesignatedConcept(designatedConceptPair.getKey());
                kv.remove("designatedConceptUUID");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
              final String designatedTerminologyIRI = kv.get("designatedTerminologyIRI");
              final Pair<TerminologyBox, Map<String, String>> designatedTerminologyPair = this.terminologyBoxes.get(designatedTerminologyIRI);
              if ((null != designatedTerminologyPair)) {
                oml.setDesignatedTerminology(designatedTerminologyPair.getKey());
                kv.remove("designatedTerminologyIRI");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while((more && (progress.get(0)).booleanValue()));
  }
  
  protected void resolveTerminologyExtensionAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    boolean more = false;
    do {
      {
        final HashMap<String, Pair<TerminologyExtensionAxiom, Map<String, String>>> queue = new HashMap<String, Pair<TerminologyExtensionAxiom, Map<String, String>>>();
        final Function2<String, Pair<TerminologyExtensionAxiom, Map<String, String>>, Boolean> _function = (String uuid, Pair<TerminologyExtensionAxiom, Map<String, String>> oml_kv) -> {
          boolean _isEmpty = oml_kv.getValue().isEmpty();
          return Boolean.valueOf((!_isEmpty));
        };
        final BiConsumer<String, Pair<TerminologyExtensionAxiom, Map<String, String>>> _function_1 = (String uuid, Pair<TerminologyExtensionAxiom, Map<String, String>> oml_kv) -> {
          queue.put(uuid, oml_kv);
        };
        MapExtensions.<String, Pair<TerminologyExtensionAxiom, Map<String, String>>>filter(this.terminologyExtensionAxioms, _function).forEach(_function_1);
        boolean _isEmpty = queue.isEmpty();
        boolean _not = (!_isEmpty);
        more = _not;
        if (more) {
          final BiConsumer<String, Pair<TerminologyExtensionAxiom, Map<String, String>>> _function_2 = (String uuid, Pair<TerminologyExtensionAxiom, Map<String, String>> oml_kv) -> {
            final TerminologyExtensionAxiom oml = oml_kv.getKey();
            final Map<String, String> kv = oml_kv.getValue();
            boolean _isEmpty_1 = kv.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              allDone.set(0, Boolean.valueOf(false));
              final String tboxXRef = kv.get("tboxUUID");
              final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
              if ((null != tboxPair)) {
                oml.setTbox(tboxPair.getKey());
                kv.remove("tboxUUID");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
              final String extendedTerminologyIRI = kv.get("extendedTerminologyIRI");
              final Pair<TerminologyBox, Map<String, String>> extendedTerminologyPair = this.terminologyBoxes.get(extendedTerminologyIRI);
              if ((null != extendedTerminologyPair)) {
                oml.setExtendedTerminology(extendedTerminologyPair.getKey());
                kv.remove("extendedTerminologyIRI");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while((more && (progress.get(0)).booleanValue()));
  }
  
  protected void resolveTerminologyNestingAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    boolean more = false;
    do {
      {
        final HashMap<String, Pair<TerminologyNestingAxiom, Map<String, String>>> queue = new HashMap<String, Pair<TerminologyNestingAxiom, Map<String, String>>>();
        final Function2<String, Pair<TerminologyNestingAxiom, Map<String, String>>, Boolean> _function = (String uuid, Pair<TerminologyNestingAxiom, Map<String, String>> oml_kv) -> {
          boolean _isEmpty = oml_kv.getValue().isEmpty();
          return Boolean.valueOf((!_isEmpty));
        };
        final BiConsumer<String, Pair<TerminologyNestingAxiom, Map<String, String>>> _function_1 = (String uuid, Pair<TerminologyNestingAxiom, Map<String, String>> oml_kv) -> {
          queue.put(uuid, oml_kv);
        };
        MapExtensions.<String, Pair<TerminologyNestingAxiom, Map<String, String>>>filter(this.terminologyNestingAxioms, _function).forEach(_function_1);
        boolean _isEmpty = queue.isEmpty();
        boolean _not = (!_isEmpty);
        more = _not;
        if (more) {
          final BiConsumer<String, Pair<TerminologyNestingAxiom, Map<String, String>>> _function_2 = (String uuid, Pair<TerminologyNestingAxiom, Map<String, String>> oml_kv) -> {
            final TerminologyNestingAxiom oml = oml_kv.getKey();
            final Map<String, String> kv = oml_kv.getValue();
            boolean _isEmpty_1 = kv.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              allDone.set(0, Boolean.valueOf(false));
              final String tboxXRef = kv.get("tboxUUID");
              final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
              if ((null != tboxPair)) {
                oml.setTbox(tboxPair.getKey());
                kv.remove("tboxUUID");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
              final String nestingContextXRef = kv.get("nestingContextUUID");
              final Pair<ConceptKind, Map<String, String>> nestingContextPair = this.conceptKinds.get(nestingContextXRef);
              if ((null != nestingContextPair)) {
                oml.setNestingContext(nestingContextPair.getKey());
                kv.remove("nestingContextUUID");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
              final String nestingTerminologyIRI = kv.get("nestingTerminologyIRI");
              final Pair<TerminologyBox, Map<String, String>> nestingTerminologyPair = this.terminologyBoxes.get(nestingTerminologyIRI);
              if ((null != nestingTerminologyPair)) {
                oml.setNestingTerminology(nestingTerminologyPair.getKey());
                kv.remove("nestingTerminologyIRI");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while((more && (progress.get(0)).booleanValue()));
  }
  
  protected void resolveBundledTerminologyAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    boolean more = false;
    do {
      {
        final HashMap<String, Pair<BundledTerminologyAxiom, Map<String, String>>> queue = new HashMap<String, Pair<BundledTerminologyAxiom, Map<String, String>>>();
        final Function2<String, Pair<BundledTerminologyAxiom, Map<String, String>>, Boolean> _function = (String uuid, Pair<BundledTerminologyAxiom, Map<String, String>> oml_kv) -> {
          boolean _isEmpty = oml_kv.getValue().isEmpty();
          return Boolean.valueOf((!_isEmpty));
        };
        final BiConsumer<String, Pair<BundledTerminologyAxiom, Map<String, String>>> _function_1 = (String uuid, Pair<BundledTerminologyAxiom, Map<String, String>> oml_kv) -> {
          queue.put(uuid, oml_kv);
        };
        MapExtensions.<String, Pair<BundledTerminologyAxiom, Map<String, String>>>filter(this.bundledTerminologyAxioms, _function).forEach(_function_1);
        boolean _isEmpty = queue.isEmpty();
        boolean _not = (!_isEmpty);
        more = _not;
        if (more) {
          final BiConsumer<String, Pair<BundledTerminologyAxiom, Map<String, String>>> _function_2 = (String uuid, Pair<BundledTerminologyAxiom, Map<String, String>> oml_kv) -> {
            final BundledTerminologyAxiom oml = oml_kv.getKey();
            final Map<String, String> kv = oml_kv.getValue();
            boolean _isEmpty_1 = kv.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              allDone.set(0, Boolean.valueOf(false));
              final String bundleXRef = kv.get("bundleUUID");
              final Pair<Bundle, Map<String, String>> bundlePair = this.bundles.get(bundleXRef);
              if ((null != bundlePair)) {
                oml.setBundle(bundlePair.getKey());
                kv.remove("bundleUUID");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
              final String bundledTerminologyIRI = kv.get("bundledTerminologyIRI");
              final Pair<TerminologyBox, Map<String, String>> bundledTerminologyPair = this.terminologyBoxes.get(bundledTerminologyIRI);
              if ((null != bundledTerminologyPair)) {
                oml.setBundledTerminology(bundledTerminologyPair.getKey());
                kv.remove("bundledTerminologyIRI");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while((more && (progress.get(0)).booleanValue()));
  }
  
  protected void resolveDescriptionBoxExtendsClosedWorldDefinitions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    boolean more = false;
    do {
      {
        final HashMap<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>> queue = new HashMap<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>>();
        final Function2<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>, Boolean> _function = (String uuid, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> oml_kv) -> {
          boolean _isEmpty = oml_kv.getValue().isEmpty();
          return Boolean.valueOf((!_isEmpty));
        };
        final BiConsumer<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>> _function_1 = (String uuid, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> oml_kv) -> {
          queue.put(uuid, oml_kv);
        };
        MapExtensions.<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>>filter(this.descriptionBoxExtendsClosedWorldDefinitions, _function).forEach(_function_1);
        boolean _isEmpty = queue.isEmpty();
        boolean _not = (!_isEmpty);
        more = _not;
        if (more) {
          final BiConsumer<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>> _function_2 = (String uuid, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> oml_kv) -> {
            final DescriptionBoxExtendsClosedWorldDefinitions oml = oml_kv.getKey();
            final Map<String, String> kv = oml_kv.getValue();
            boolean _isEmpty_1 = kv.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              allDone.set(0, Boolean.valueOf(false));
              final String descriptionBoxXRef = kv.get("descriptionBoxUUID");
              final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
              if ((null != descriptionBoxPair)) {
                oml.setDescriptionBox(descriptionBoxPair.getKey());
                kv.remove("descriptionBoxUUID");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
              final String closedWorldDefinitionsIRI = kv.get("closedWorldDefinitionsIRI");
              final Pair<TerminologyBox, Map<String, String>> closedWorldDefinitionsPair = this.terminologyBoxes.get(closedWorldDefinitionsIRI);
              if ((null != closedWorldDefinitionsPair)) {
                oml.setClosedWorldDefinitions(closedWorldDefinitionsPair.getKey());
                kv.remove("closedWorldDefinitionsIRI");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while((more && (progress.get(0)).booleanValue()));
  }
  
  protected void resolveDescriptionBoxRefinements(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    boolean more = false;
    do {
      {
        final HashMap<String, Pair<DescriptionBoxRefinement, Map<String, String>>> queue = new HashMap<String, Pair<DescriptionBoxRefinement, Map<String, String>>>();
        final Function2<String, Pair<DescriptionBoxRefinement, Map<String, String>>, Boolean> _function = (String uuid, Pair<DescriptionBoxRefinement, Map<String, String>> oml_kv) -> {
          boolean _isEmpty = oml_kv.getValue().isEmpty();
          return Boolean.valueOf((!_isEmpty));
        };
        final BiConsumer<String, Pair<DescriptionBoxRefinement, Map<String, String>>> _function_1 = (String uuid, Pair<DescriptionBoxRefinement, Map<String, String>> oml_kv) -> {
          queue.put(uuid, oml_kv);
        };
        MapExtensions.<String, Pair<DescriptionBoxRefinement, Map<String, String>>>filter(this.descriptionBoxRefinements, _function).forEach(_function_1);
        boolean _isEmpty = queue.isEmpty();
        boolean _not = (!_isEmpty);
        more = _not;
        if (more) {
          final BiConsumer<String, Pair<DescriptionBoxRefinement, Map<String, String>>> _function_2 = (String uuid, Pair<DescriptionBoxRefinement, Map<String, String>> oml_kv) -> {
            final DescriptionBoxRefinement oml = oml_kv.getKey();
            final Map<String, String> kv = oml_kv.getValue();
            boolean _isEmpty_1 = kv.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              allDone.set(0, Boolean.valueOf(false));
              final String refiningDescriptionBoxXRef = kv.get("refiningDescriptionBoxUUID");
              final Pair<DescriptionBox, Map<String, String>> refiningDescriptionBoxPair = this.descriptionBoxes.get(refiningDescriptionBoxXRef);
              if ((null != refiningDescriptionBoxPair)) {
                oml.setRefiningDescriptionBox(refiningDescriptionBoxPair.getKey());
                kv.remove("refiningDescriptionBoxUUID");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
              final String refinedDescriptionBoxIRI = kv.get("refinedDescriptionBoxIRI");
              final Pair<DescriptionBox, Map<String, String>> refinedDescriptionBoxPair = this.descriptionBoxes.get(refinedDescriptionBoxIRI);
              if ((null != refinedDescriptionBoxPair)) {
                oml.setRefinedDescriptionBox(refinedDescriptionBoxPair.getKey());
                kv.remove("refinedDescriptionBoxIRI");
                progress.set(0, Boolean.valueOf(true));
              } else {
                progress.set(0, Boolean.valueOf(false));
              }
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while((more && (progress.get(0)).booleanValue()));
  }
  
  protected void resolveBinaryScalarRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<BinaryScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<BinaryScalarRestriction, Map<String, String>> oml_kv) -> {
      final BinaryScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.binaryScalarRestrictions.forEach(_function);
  }
  
  protected void resolveIRIScalarRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<IRIScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<IRIScalarRestriction, Map<String, String>> oml_kv) -> {
      final IRIScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.iriScalarRestrictions.forEach(_function);
  }
  
  protected void resolveNumericScalarRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<NumericScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<NumericScalarRestriction, Map<String, String>> oml_kv) -> {
      final NumericScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.numericScalarRestrictions.forEach(_function);
  }
  
  protected void resolvePlainLiteralScalarRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<PlainLiteralScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<PlainLiteralScalarRestriction, Map<String, String>> oml_kv) -> {
      final PlainLiteralScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.plainLiteralScalarRestrictions.forEach(_function);
  }
  
  protected void resolveScalarOneOfRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ScalarOneOfRestriction, Map<String, String>>> _function = (String uuid, Pair<ScalarOneOfRestriction, Map<String, String>> oml_kv) -> {
      final ScalarOneOfRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.scalarOneOfRestrictions.forEach(_function);
  }
  
  protected void resolveScalarOneOfLiteralAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ScalarOneOfLiteralAxiom, Map<String, String>>> _function = (String uuid, Pair<ScalarOneOfLiteralAxiom, Map<String, String>> oml_kv) -> {
      final ScalarOneOfLiteralAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String axiomXRef = kv.get("axiomUUID");
        final Pair<ScalarOneOfRestriction, Map<String, String>> axiomPair = this.scalarOneOfRestrictions.get(axiomXRef);
        if ((null != axiomPair)) {
          oml.setAxiom(axiomPair.getKey());
          kv.remove("axiomUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String valueTypeXRef = kv.get("valueTypeUUID");
        if (((null != valueTypeXRef) && (!Objects.equal("null", valueTypeXRef)))) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null != valueTypePair)) {
            oml.setValueType(valueTypePair.getKey());
            kv.remove("valueTypeUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
      }
    };
    this.scalarOneOfLiteralAxioms.forEach(_function);
  }
  
  protected void resolveStringScalarRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<StringScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<StringScalarRestriction, Map<String, String>> oml_kv) -> {
      final StringScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.stringScalarRestrictions.forEach(_function);
  }
  
  protected void resolveSynonymScalarRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<SynonymScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<SynonymScalarRestriction, Map<String, String>> oml_kv) -> {
      final SynonymScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.synonymScalarRestrictions.forEach(_function);
  }
  
  protected void resolveTimeScalarRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<TimeScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<TimeScalarRestriction, Map<String, String>> oml_kv) -> {
      final TimeScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.timeScalarRestrictions.forEach(_function);
  }
  
  protected void resolveEntityScalarDataProperties(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<EntityScalarDataProperty, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataProperty, Map<String, String>> oml_kv) -> {
      final EntityScalarDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String domainXRef = kv.get("domainUUID");
        final Pair<Entity, Map<String, String>> domainPair = this.entities.get(domainXRef);
        if ((null != domainPair)) {
          oml.setDomain(domainPair.getKey());
          kv.remove("domainUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String rangeXRef = kv.get("rangeUUID");
        final Pair<DataRange, Map<String, String>> rangePair = this.dataRanges.get(rangeXRef);
        if ((null != rangePair)) {
          oml.setRange(rangePair.getKey());
          kv.remove("rangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.entityScalarDataProperties.forEach(_function);
  }
  
  protected void resolveEntityStructuredDataProperties(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<EntityStructuredDataProperty, Map<String, String>>> _function = (String uuid, Pair<EntityStructuredDataProperty, Map<String, String>> oml_kv) -> {
      final EntityStructuredDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String domainXRef = kv.get("domainUUID");
        final Pair<Entity, Map<String, String>> domainPair = this.entities.get(domainXRef);
        if ((null != domainPair)) {
          oml.setDomain(domainPair.getKey());
          kv.remove("domainUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String rangeXRef = kv.get("rangeUUID");
        final Pair<Structure, Map<String, String>> rangePair = this.structures.get(rangeXRef);
        if ((null != rangePair)) {
          oml.setRange(rangePair.getKey());
          kv.remove("rangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.entityStructuredDataProperties.forEach(_function);
  }
  
  protected void resolveScalarDataProperties(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ScalarDataProperty, Map<String, String>>> _function = (String uuid, Pair<ScalarDataProperty, Map<String, String>> oml_kv) -> {
      final ScalarDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String domainXRef = kv.get("domainUUID");
        final Pair<Structure, Map<String, String>> domainPair = this.structures.get(domainXRef);
        if ((null != domainPair)) {
          oml.setDomain(domainPair.getKey());
          kv.remove("domainUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String rangeXRef = kv.get("rangeUUID");
        final Pair<DataRange, Map<String, String>> rangePair = this.dataRanges.get(rangeXRef);
        if ((null != rangePair)) {
          oml.setRange(rangePair.getKey());
          kv.remove("rangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.scalarDataProperties.forEach(_function);
  }
  
  protected void resolveStructuredDataProperties(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<StructuredDataProperty, Map<String, String>>> _function = (String uuid, Pair<StructuredDataProperty, Map<String, String>> oml_kv) -> {
      final StructuredDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String domainXRef = kv.get("domainUUID");
        final Pair<Structure, Map<String, String>> domainPair = this.structures.get(domainXRef);
        if ((null != domainPair)) {
          oml.setDomain(domainPair.getKey());
          kv.remove("domainUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String rangeXRef = kv.get("rangeUUID");
        final Pair<Structure, Map<String, String>> rangePair = this.structures.get(rangeXRef);
        if ((null != rangePair)) {
          oml.setRange(rangePair.getKey());
          kv.remove("rangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.structuredDataProperties.forEach(_function);
  }
  
  protected void resolveReifiedRelationships(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ReifiedRelationship, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationship, Map<String, String>> oml_kv) -> {
      final ReifiedRelationship oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String sourceXRef = kv.get("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null != sourcePair)) {
          oml.setSource(sourcePair.getKey());
          kv.remove("sourceUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String targetXRef = kv.get("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null != targetPair)) {
          oml.setTarget(targetPair.getKey());
          kv.remove("targetUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.reifiedRelationships.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipRestrictions(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ReifiedRelationshipRestriction, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipRestriction, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String sourceXRef = kv.get("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null != sourcePair)) {
          oml.setSource(sourcePair.getKey());
          kv.remove("sourceUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String targetXRef = kv.get("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null != targetPair)) {
          oml.setTarget(targetPair.getKey());
          kv.remove("targetUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.reifiedRelationshipRestrictions.forEach(_function);
  }
  
  protected void resolveForwardProperties(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ForwardProperty, Map<String, String>>> _function = (String uuid, Pair<ForwardProperty, Map<String, String>> oml_kv) -> {
      final ForwardProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String reifiedRelationshipXRef = kv.get("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null != reifiedRelationshipPair)) {
          oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
          kv.remove("reifiedRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.forwardProperties.forEach(_function);
  }
  
  protected void resolveInverseProperties(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<InverseProperty, Map<String, String>>> _function = (String uuid, Pair<InverseProperty, Map<String, String>> oml_kv) -> {
      final InverseProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String reifiedRelationshipXRef = kv.get("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null != reifiedRelationshipPair)) {
          oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
          kv.remove("reifiedRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.inverseProperties.forEach(_function);
  }
  
  protected void resolveUnreifiedRelationships(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<UnreifiedRelationship, Map<String, String>>> _function = (String uuid, Pair<UnreifiedRelationship, Map<String, String>> oml_kv) -> {
      final UnreifiedRelationship oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String sourceXRef = kv.get("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null != sourcePair)) {
          oml.setSource(sourcePair.getKey());
          kv.remove("sourceUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String targetXRef = kv.get("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null != targetPair)) {
          oml.setTarget(targetPair.getKey());
          kv.remove("targetUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.unreifiedRelationships.forEach(_function);
  }
  
  protected void resolveChainRules(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ChainRule, Map<String, String>>> _function = (String uuid, Pair<ChainRule, Map<String, String>> oml_kv) -> {
      final ChainRule oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String headXRef = kv.get("headUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> headPair = this.unreifiedRelationships.get(headXRef);
        if ((null != headPair)) {
          oml.setHead(headPair.getKey());
          kv.remove("headUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.chainRules.forEach(_function);
  }
  
  protected void resolveRuleBodySegments(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<RuleBodySegment, Map<String, String>>> _function = (String uuid, Pair<RuleBodySegment, Map<String, String>> oml_kv) -> {
      final RuleBodySegment oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String previousSegmentXRef = kv.get("previousSegmentUUID");
        if (((null != previousSegmentXRef) && (!Objects.equal("null", previousSegmentXRef)))) {
          final Pair<RuleBodySegment, Map<String, String>> previousSegmentPair = this.ruleBodySegments.get(previousSegmentXRef);
          if ((null != previousSegmentPair)) {
            oml.setPreviousSegment(previousSegmentPair.getKey());
            kv.remove("previousSegmentUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String ruleXRef = kv.get("ruleUUID");
        if (((null != ruleXRef) && (!Objects.equal("null", ruleXRef)))) {
          final Pair<ChainRule, Map<String, String>> rulePair = this.chainRules.get(ruleXRef);
          if ((null != rulePair)) {
            oml.setRule(rulePair.getKey());
            kv.remove("ruleUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
      }
    };
    this.ruleBodySegments.forEach(_function);
  }
  
  protected void resolveSegmentPredicates(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<SegmentPredicate, Map<String, String>>> _function = (String uuid, Pair<SegmentPredicate, Map<String, String>> oml_kv) -> {
      final SegmentPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.get("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null != bodySegmentPair)) {
          oml.setBodySegment(bodySegmentPair.getKey());
          kv.remove("bodySegmentUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String predicateXRef = kv.get("predicateUUID");
        if (((null != predicateXRef) && (!Objects.equal("null", predicateXRef)))) {
          final Pair<Predicate, Map<String, String>> predicatePair = this.predicates.get(predicateXRef);
          if ((null != predicatePair)) {
            oml.setPredicate(predicatePair.getKey());
            kv.remove("predicateUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String reifiedRelationshipSourceXRef = kv.get("reifiedRelationshipSourceUUID");
        if (((null != reifiedRelationshipSourceXRef) && (!Objects.equal("null", reifiedRelationshipSourceXRef)))) {
          final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipSourcePair = this.reifiedRelationships.get(reifiedRelationshipSourceXRef);
          if ((null != reifiedRelationshipSourcePair)) {
            oml.setReifiedRelationshipSource(reifiedRelationshipSourcePair.getKey());
            kv.remove("reifiedRelationshipSourceUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String reifiedRelationshipInverseSourceXRef = kv.get("reifiedRelationshipInverseSourceUUID");
        if (((null != reifiedRelationshipInverseSourceXRef) && (!Objects.equal("null", reifiedRelationshipInverseSourceXRef)))) {
          final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipInverseSourcePair = this.reifiedRelationships.get(reifiedRelationshipInverseSourceXRef);
          if ((null != reifiedRelationshipInverseSourcePair)) {
            oml.setReifiedRelationshipInverseSource(reifiedRelationshipInverseSourcePair.getKey());
            kv.remove("reifiedRelationshipInverseSourceUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String reifiedRelationshipTargetXRef = kv.get("reifiedRelationshipTargetUUID");
        if (((null != reifiedRelationshipTargetXRef) && (!Objects.equal("null", reifiedRelationshipTargetXRef)))) {
          final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipTargetPair = this.reifiedRelationships.get(reifiedRelationshipTargetXRef);
          if ((null != reifiedRelationshipTargetPair)) {
            oml.setReifiedRelationshipTarget(reifiedRelationshipTargetPair.getKey());
            kv.remove("reifiedRelationshipTargetUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String reifiedRelationshipInverseTargetXRef = kv.get("reifiedRelationshipInverseTargetUUID");
        if (((null != reifiedRelationshipInverseTargetXRef) && (!Objects.equal("null", reifiedRelationshipInverseTargetXRef)))) {
          final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipInverseTargetPair = this.reifiedRelationships.get(reifiedRelationshipInverseTargetXRef);
          if ((null != reifiedRelationshipInverseTargetPair)) {
            oml.setReifiedRelationshipInverseTarget(reifiedRelationshipInverseTargetPair.getKey());
            kv.remove("reifiedRelationshipInverseTargetUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String unreifiedRelationshipInverseXRef = kv.get("unreifiedRelationshipInverseUUID");
        if (((null != unreifiedRelationshipInverseXRef) && (!Objects.equal("null", unreifiedRelationshipInverseXRef)))) {
          final Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipInversePair = this.unreifiedRelationships.get(unreifiedRelationshipInverseXRef);
          if ((null != unreifiedRelationshipInversePair)) {
            oml.setUnreifiedRelationshipInverse(unreifiedRelationshipInversePair.getKey());
            kv.remove("unreifiedRelationshipInverseUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
      }
    };
    this.segmentPredicates.forEach(_function);
  }
  
  protected void resolveEntityExistentialRestrictionAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityExistentialRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityExistentialRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedDomainXRef = kv.get("restrictedDomainUUID");
        final Pair<Entity, Map<String, String>> restrictedDomainPair = this.entities.get(restrictedDomainXRef);
        if ((null != restrictedDomainPair)) {
          oml.setRestrictedDomain(restrictedDomainPair.getKey());
          kv.remove("restrictedDomainUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID");
        final Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = this.restrictableRelationships.get(restrictedRelationshipXRef);
        if ((null != restrictedRelationshipPair)) {
          oml.setRestrictedRelationship(restrictedRelationshipPair.getKey());
          kv.remove("restrictedRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.entityExistentialRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityUniversalRestrictionAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityUniversalRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityUniversalRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedDomainXRef = kv.get("restrictedDomainUUID");
        final Pair<Entity, Map<String, String>> restrictedDomainPair = this.entities.get(restrictedDomainXRef);
        if ((null != restrictedDomainPair)) {
          oml.setRestrictedDomain(restrictedDomainPair.getKey());
          kv.remove("restrictedDomainUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
        if ((null != restrictedRangePair)) {
          oml.setRestrictedRange(restrictedRangePair.getKey());
          kv.remove("restrictedRangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID");
        final Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = this.restrictableRelationships.get(restrictedRelationshipXRef);
        if ((null != restrictedRelationshipPair)) {
          oml.setRestrictedRelationship(restrictedRelationshipPair.getKey());
          kv.remove("restrictedRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.entityUniversalRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyExistentialRestrictionAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyExistentialRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedEntityXRef = kv.get("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null != restrictedEntityPair)) {
          oml.setRestrictedEntity(restrictedEntityPair.getKey());
          kv.remove("restrictedEntityUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String scalarPropertyXRef = kv.get("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null != scalarPropertyPair)) {
          oml.setScalarProperty(scalarPropertyPair.getKey());
          kv.remove("scalarPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String scalarRestrictionXRef = kv.get("scalarRestrictionUUID");
        final Pair<DataRange, Map<String, String>> scalarRestrictionPair = this.dataRanges.get(scalarRestrictionXRef);
        if ((null != scalarRestrictionPair)) {
          oml.setScalarRestriction(scalarRestrictionPair.getKey());
          kv.remove("scalarRestrictionUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.entityScalarDataPropertyExistentialRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyParticularRestrictionAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyParticularRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedEntityXRef = kv.get("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null != restrictedEntityPair)) {
          oml.setRestrictedEntity(restrictedEntityPair.getKey());
          kv.remove("restrictedEntityUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String scalarPropertyXRef = kv.get("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null != scalarPropertyPair)) {
          oml.setScalarProperty(scalarPropertyPair.getKey());
          kv.remove("scalarPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String valueTypeXRef = kv.get("valueTypeUUID");
        if (((null != valueTypeXRef) && (!Objects.equal("null", valueTypeXRef)))) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null != valueTypePair)) {
            oml.setValueType(valueTypePair.getKey());
            kv.remove("valueTypeUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
      }
    };
    this.entityScalarDataPropertyParticularRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyUniversalRestrictionAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyUniversalRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedEntityXRef = kv.get("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null != restrictedEntityPair)) {
          oml.setRestrictedEntity(restrictedEntityPair.getKey());
          kv.remove("restrictedEntityUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String scalarPropertyXRef = kv.get("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null != scalarPropertyPair)) {
          oml.setScalarProperty(scalarPropertyPair.getKey());
          kv.remove("scalarPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String scalarRestrictionXRef = kv.get("scalarRestrictionUUID");
        final Pair<DataRange, Map<String, String>> scalarRestrictionPair = this.dataRanges.get(scalarRestrictionXRef);
        if ((null != scalarRestrictionPair)) {
          oml.setScalarRestriction(scalarRestrictionPair.getKey());
          kv.remove("scalarRestrictionUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.entityScalarDataPropertyUniversalRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityStructuredDataPropertyParticularRestrictionAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityStructuredDataPropertyParticularRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String structuredDataPropertyXRef = kv.get("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null != structuredDataPropertyPair)) {
          oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
          kv.remove("structuredDataPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedEntityXRef = kv.get("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null != restrictedEntityPair)) {
          oml.setRestrictedEntity(restrictedEntityPair.getKey());
          kv.remove("restrictedEntityUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.entityStructuredDataPropertyParticularRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveRestrictionStructuredDataPropertyTuples(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>> _function = (String uuid, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>> oml_kv) -> {
      final RestrictionStructuredDataPropertyTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyContextXRef = kv.get("structuredDataPropertyContextUUID");
        final Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null != structuredDataPropertyContextPair)) {
          oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
          kv.remove("structuredDataPropertyContextUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String structuredDataPropertyXRef = kv.get("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null != structuredDataPropertyPair)) {
          oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
          kv.remove("structuredDataPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.restrictionStructuredDataPropertyTuples.forEach(_function);
  }
  
  protected void resolveRestrictionScalarDataPropertyValues(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<RestrictionScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final RestrictionScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyContextXRef = kv.get("structuredDataPropertyContextUUID");
        final Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null != structuredDataPropertyContextPair)) {
          oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
          kv.remove("structuredDataPropertyContextUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String scalarDataPropertyXRef = kv.get("scalarDataPropertyUUID");
        final Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = this.dataRelationshipToScalars.get(scalarDataPropertyXRef);
        if ((null != scalarDataPropertyPair)) {
          oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
          kv.remove("scalarDataPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String valueTypeXRef = kv.get("valueTypeUUID");
        if (((null != valueTypeXRef) && (!Objects.equal("null", valueTypeXRef)))) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null != valueTypePair)) {
            oml.setValueType(valueTypePair.getKey());
            kv.remove("valueTypeUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
      }
    };
    this.restrictionScalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveAspectSpecializationAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<AspectSpecializationAxiom, Map<String, String>>> _function = (String uuid, Pair<AspectSpecializationAxiom, Map<String, String>> oml_kv) -> {
      final AspectSpecializationAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String superAspectXRef = kv.get("superAspectUUID");
        final Pair<AspectKind, Map<String, String>> superAspectPair = this.aspectKinds.get(superAspectXRef);
        if ((null != superAspectPair)) {
          oml.setSuperAspect(superAspectPair.getKey());
          kv.remove("superAspectUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String subEntityXRef = kv.get("subEntityUUID");
        final Pair<Entity, Map<String, String>> subEntityPair = this.entities.get(subEntityXRef);
        if ((null != subEntityPair)) {
          oml.setSubEntity(subEntityPair.getKey());
          kv.remove("subEntityUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.aspectSpecializationAxioms.forEach(_function);
  }
  
  protected void resolveConceptSpecializationAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ConceptSpecializationAxiom, Map<String, String>>> _function = (String uuid, Pair<ConceptSpecializationAxiom, Map<String, String>> oml_kv) -> {
      final ConceptSpecializationAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String superConceptXRef = kv.get("superConceptUUID");
        final Pair<ConceptKind, Map<String, String>> superConceptPair = this.conceptKinds.get(superConceptXRef);
        if ((null != superConceptPair)) {
          oml.setSuperConcept(superConceptPair.getKey());
          kv.remove("superConceptUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String subConceptXRef = kv.get("subConceptUUID");
        final Pair<ConceptKind, Map<String, String>> subConceptPair = this.conceptKinds.get(subConceptXRef);
        if ((null != subConceptPair)) {
          oml.setSubConcept(subConceptPair.getKey());
          kv.remove("subConceptUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.conceptSpecializationAxioms.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipSpecializationAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipSpecializationAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String superRelationshipXRef = kv.get("superRelationshipUUID");
        final Pair<ConceptualRelationship, Map<String, String>> superRelationshipPair = this.conceptualRelationships.get(superRelationshipXRef);
        if ((null != superRelationshipPair)) {
          oml.setSuperRelationship(superRelationshipPair.getKey());
          kv.remove("superRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String subRelationshipXRef = kv.get("subRelationshipUUID");
        final Pair<ConceptualRelationship, Map<String, String>> subRelationshipPair = this.conceptualRelationships.get(subRelationshipXRef);
        if ((null != subRelationshipPair)) {
          oml.setSubRelationship(subRelationshipPair.getKey());
          kv.remove("subRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.reifiedRelationshipSpecializationAxioms.forEach(_function);
  }
  
  protected void resolveSubDataPropertyOfAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>> _function = (String uuid, Pair<SubDataPropertyOfAxiom, Map<String, String>> oml_kv) -> {
      final SubDataPropertyOfAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String subPropertyXRef = kv.get("subPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> subPropertyPair = this.entityScalarDataProperties.get(subPropertyXRef);
        if ((null != subPropertyPair)) {
          oml.setSubProperty(subPropertyPair.getKey());
          kv.remove("subPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String superPropertyXRef = kv.get("superPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> superPropertyPair = this.entityScalarDataProperties.get(superPropertyXRef);
        if ((null != superPropertyPair)) {
          oml.setSuperProperty(superPropertyPair.getKey());
          kv.remove("superPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.subDataPropertyOfAxioms.forEach(_function);
  }
  
  protected void resolveSubObjectPropertyOfAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>> _function = (String uuid, Pair<SubObjectPropertyOfAxiom, Map<String, String>> oml_kv) -> {
      final SubObjectPropertyOfAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String subPropertyXRef = kv.get("subPropertyUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> subPropertyPair = this.unreifiedRelationships.get(subPropertyXRef);
        if ((null != subPropertyPair)) {
          oml.setSubProperty(subPropertyPair.getKey());
          kv.remove("subPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String superPropertyXRef = kv.get("superPropertyUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> superPropertyPair = this.unreifiedRelationships.get(superPropertyXRef);
        if ((null != superPropertyPair)) {
          oml.setSuperProperty(superPropertyPair.getKey());
          kv.remove("superPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.subObjectPropertyOfAxioms.forEach(_function);
  }
  
  protected void resolveRootConceptTaxonomyAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>> _function = (String uuid, Pair<RootConceptTaxonomyAxiom, Map<String, String>> oml_kv) -> {
      final RootConceptTaxonomyAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bundleXRef = kv.get("bundleUUID");
        final Pair<Bundle, Map<String, String>> bundlePair = this.bundles.get(bundleXRef);
        if ((null != bundlePair)) {
          oml.setBundle(bundlePair.getKey());
          kv.remove("bundleUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String rootXRef = kv.get("rootUUID");
        final Pair<ConceptKind, Map<String, String>> rootPair = this.conceptKinds.get(rootXRef);
        if ((null != rootPair)) {
          oml.setRoot(rootPair.getKey());
          kv.remove("rootUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.rootConceptTaxonomyAxioms.forEach(_function);
  }
  
  protected void resolveAnonymousConceptUnionAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>> _function = (String uuid, Pair<AnonymousConceptUnionAxiom, Map<String, String>> oml_kv) -> {
      final AnonymousConceptUnionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String disjointTaxonomyParentXRef = kv.get("disjointTaxonomyParentUUID");
        final Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = this.conceptTreeDisjunctions.get(disjointTaxonomyParentXRef);
        if ((null != disjointTaxonomyParentPair)) {
          oml.setDisjointTaxonomyParent(disjointTaxonomyParentPair.getKey());
          kv.remove("disjointTaxonomyParentUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.anonymousConceptUnionAxioms.forEach(_function);
  }
  
  protected void resolveSpecificDisjointConceptAxioms(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>> _function = (String uuid, Pair<SpecificDisjointConceptAxiom, Map<String, String>> oml_kv) -> {
      final SpecificDisjointConceptAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String disjointTaxonomyParentXRef = kv.get("disjointTaxonomyParentUUID");
        final Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = this.conceptTreeDisjunctions.get(disjointTaxonomyParentXRef);
        if ((null != disjointTaxonomyParentPair)) {
          oml.setDisjointTaxonomyParent(disjointTaxonomyParentPair.getKey());
          kv.remove("disjointTaxonomyParentUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String disjointLeafXRef = kv.get("disjointLeafUUID");
        final Pair<ConceptKind, Map<String, String>> disjointLeafPair = this.conceptKinds.get(disjointLeafXRef);
        if ((null != disjointLeafPair)) {
          oml.setDisjointLeaf(disjointLeafPair.getKey());
          kv.remove("disjointLeafUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.specificDisjointConceptAxioms.forEach(_function);
  }
  
  protected void resolveConceptInstances(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ConceptInstance, Map<String, String>>> _function = (String uuid, Pair<ConceptInstance, Map<String, String>> oml_kv) -> {
      final ConceptInstance oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.get("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null != descriptionBoxPair)) {
          oml.setDescriptionBox(descriptionBoxPair.getKey());
          kv.remove("descriptionBoxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String singletonConceptClassifierXRef = kv.get("singletonConceptClassifierUUID");
        final Pair<ConceptKind, Map<String, String>> singletonConceptClassifierPair = this.conceptKinds.get(singletonConceptClassifierXRef);
        if ((null != singletonConceptClassifierPair)) {
          oml.setSingletonConceptClassifier(singletonConceptClassifierPair.getKey());
          kv.remove("singletonConceptClassifierUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.conceptInstances.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstances(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstance, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstance, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstance oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.get("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null != descriptionBoxPair)) {
          oml.setDescriptionBox(descriptionBoxPair.getKey());
          kv.remove("descriptionBoxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String singletonConceptualRelationshipClassifierXRef = kv.get("singletonConceptualRelationshipClassifierUUID");
        final Pair<ConceptualRelationship, Map<String, String>> singletonConceptualRelationshipClassifierPair = this.conceptualRelationships.get(singletonConceptualRelationshipClassifierXRef);
        if ((null != singletonConceptualRelationshipClassifierPair)) {
          oml.setSingletonConceptualRelationshipClassifier(singletonConceptualRelationshipClassifierPair.getKey());
          kv.remove("singletonConceptualRelationshipClassifierUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.reifiedRelationshipInstances.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstanceDomains(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstanceDomain oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.get("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null != descriptionBoxPair)) {
          oml.setDescriptionBox(descriptionBoxPair.getKey());
          kv.remove("descriptionBoxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String reifiedRelationshipInstanceXRef = kv.get("reifiedRelationshipInstanceUUID");
        final Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = this.reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef);
        if ((null != reifiedRelationshipInstancePair)) {
          oml.setReifiedRelationshipInstance(reifiedRelationshipInstancePair.getKey());
          kv.remove("reifiedRelationshipInstanceUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String domainXRef = kv.get("domainUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = this.conceptualEntitySingletonInstances.get(domainXRef);
        if ((null != domainPair)) {
          oml.setDomain(domainPair.getKey());
          kv.remove("domainUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.reifiedRelationshipInstanceDomains.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstanceRanges(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstanceRange, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstanceRange oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.get("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null != descriptionBoxPair)) {
          oml.setDescriptionBox(descriptionBoxPair.getKey());
          kv.remove("descriptionBoxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String reifiedRelationshipInstanceXRef = kv.get("reifiedRelationshipInstanceUUID");
        final Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = this.reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef);
        if ((null != reifiedRelationshipInstancePair)) {
          oml.setReifiedRelationshipInstance(reifiedRelationshipInstancePair.getKey());
          kv.remove("reifiedRelationshipInstanceUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String rangeXRef = kv.get("rangeUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = this.conceptualEntitySingletonInstances.get(rangeXRef);
        if ((null != rangePair)) {
          oml.setRange(rangePair.getKey());
          kv.remove("rangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.reifiedRelationshipInstanceRanges.forEach(_function);
  }
  
  protected void resolveUnreifiedRelationshipInstanceTuples(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>> _function = (String uuid, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>> oml_kv) -> {
      final UnreifiedRelationshipInstanceTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.get("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null != descriptionBoxPair)) {
          oml.setDescriptionBox(descriptionBoxPair.getKey());
          kv.remove("descriptionBoxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String unreifiedRelationshipXRef = kv.get("unreifiedRelationshipUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipPair = this.unreifiedRelationships.get(unreifiedRelationshipXRef);
        if ((null != unreifiedRelationshipPair)) {
          oml.setUnreifiedRelationship(unreifiedRelationshipPair.getKey());
          kv.remove("unreifiedRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String domainXRef = kv.get("domainUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = this.conceptualEntitySingletonInstances.get(domainXRef);
        if ((null != domainPair)) {
          oml.setDomain(domainPair.getKey());
          kv.remove("domainUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String rangeXRef = kv.get("rangeUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = this.conceptualEntitySingletonInstances.get(rangeXRef);
        if ((null != rangePair)) {
          oml.setRange(rangePair.getKey());
          kv.remove("rangeUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.unreifiedRelationshipInstanceTuples.forEach(_function);
  }
  
  protected void resolveSingletonInstanceStructuredDataPropertyValues(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>> oml_kv) -> {
      final SingletonInstanceStructuredDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.get("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null != descriptionBoxPair)) {
          oml.setDescriptionBox(descriptionBoxPair.getKey());
          kv.remove("descriptionBoxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String singletonInstanceXRef = kv.get("singletonInstanceUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = this.conceptualEntitySingletonInstances.get(singletonInstanceXRef);
        if ((null != singletonInstancePair)) {
          oml.setSingletonInstance(singletonInstancePair.getKey());
          kv.remove("singletonInstanceUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String structuredDataPropertyXRef = kv.get("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null != structuredDataPropertyPair)) {
          oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
          kv.remove("structuredDataPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.singletonInstanceStructuredDataPropertyValues.forEach(_function);
  }
  
  protected void resolveSingletonInstanceScalarDataPropertyValues(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final SingletonInstanceScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.get("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null != descriptionBoxPair)) {
          oml.setDescriptionBox(descriptionBoxPair.getKey());
          kv.remove("descriptionBoxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String singletonInstanceXRef = kv.get("singletonInstanceUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = this.conceptualEntitySingletonInstances.get(singletonInstanceXRef);
        if ((null != singletonInstancePair)) {
          oml.setSingletonInstance(singletonInstancePair.getKey());
          kv.remove("singletonInstanceUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String scalarDataPropertyXRef = kv.get("scalarDataPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarDataPropertyPair = this.entityScalarDataProperties.get(scalarDataPropertyXRef);
        if ((null != scalarDataPropertyPair)) {
          oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
          kv.remove("scalarDataPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String valueTypeXRef = kv.get("valueTypeUUID");
        if (((null != valueTypeXRef) && (!Objects.equal("null", valueTypeXRef)))) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null != valueTypePair)) {
            oml.setValueType(valueTypePair.getKey());
            kv.remove("valueTypeUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
      }
    };
    this.singletonInstanceScalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveStructuredDataPropertyTuples(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<StructuredDataPropertyTuple, Map<String, String>>> _function = (String uuid, Pair<StructuredDataPropertyTuple, Map<String, String>> oml_kv) -> {
      final StructuredDataPropertyTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyContextXRef = kv.get("structuredDataPropertyContextUUID");
        final Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null != structuredDataPropertyContextPair)) {
          oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
          kv.remove("structuredDataPropertyContextUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String structuredDataPropertyXRef = kv.get("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null != structuredDataPropertyPair)) {
          oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
          kv.remove("structuredDataPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.structuredDataPropertyTuples.forEach(_function);
  }
  
  protected void resolveScalarDataPropertyValues(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<ScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<ScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final ScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyContextXRef = kv.get("structuredDataPropertyContextUUID");
        final Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null != structuredDataPropertyContextPair)) {
          oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
          kv.remove("structuredDataPropertyContextUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String scalarDataPropertyXRef = kv.get("scalarDataPropertyUUID");
        final Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = this.dataRelationshipToScalars.get(scalarDataPropertyXRef);
        if ((null != scalarDataPropertyPair)) {
          oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
          kv.remove("scalarDataPropertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String valueTypeXRef = kv.get("valueTypeUUID");
        if (((null != valueTypeXRef) && (!Objects.equal("null", valueTypeXRef)))) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null != valueTypePair)) {
            oml.setValueType(valueTypePair.getKey());
            kv.remove("valueTypeUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
      }
    };
    this.scalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveAnnotationPropertyValues(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<AnnotationPropertyValue, Map<String, String>>> _function = (String uuid, Pair<AnnotationPropertyValue, Map<String, String>> oml_kv) -> {
      final AnnotationPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String subjectXRef = kv.get("subjectUUID");
        final Pair<LogicalElement, Map<String, String>> subjectPair = this.logicalElements.get(subjectXRef);
        if ((null != subjectPair)) {
          oml.setSubject(subjectPair.getKey());
          kv.remove("subjectUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String propertyXRef = kv.get("propertyUUID");
        final Pair<AnnotationProperty, Map<String, String>> propertyPair = this.annotationProperties.get(propertyXRef);
        if ((null != propertyPair)) {
          oml.setProperty(propertyPair.getKey());
          kv.remove("propertyUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.annotationPropertyValues.forEach(_function);
  }
  
  protected void resolveCardinalityRestrictedAspects(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<CardinalityRestrictedAspect, Map<String, String>>> _function = (String uuid, Pair<CardinalityRestrictedAspect, Map<String, String>> oml_kv) -> {
      final CardinalityRestrictedAspect oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        if (((null != restrictedRangeXRef) && (!Objects.equal("null", restrictedRangeXRef)))) {
          final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
          if ((null != restrictedRangePair)) {
            oml.setRestrictedRange(restrictedRangePair.getKey());
            kv.remove("restrictedRangeUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID");
        final Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = this.restrictableRelationships.get(restrictedRelationshipXRef);
        if ((null != restrictedRelationshipPair)) {
          oml.setRestrictedRelationship(restrictedRelationshipPair.getKey());
          kv.remove("restrictedRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.cardinalityRestrictedAspects.forEach(_function);
  }
  
  protected void resolveCardinalityRestrictedConcepts(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<CardinalityRestrictedConcept, Map<String, String>>> _function = (String uuid, Pair<CardinalityRestrictedConcept, Map<String, String>> oml_kv) -> {
      final CardinalityRestrictedConcept oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        if (((null != restrictedRangeXRef) && (!Objects.equal("null", restrictedRangeXRef)))) {
          final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
          if ((null != restrictedRangePair)) {
            oml.setRestrictedRange(restrictedRangePair.getKey());
            kv.remove("restrictedRangeUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID");
        final Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = this.restrictableRelationships.get(restrictedRelationshipXRef);
        if ((null != restrictedRelationshipPair)) {
          oml.setRestrictedRelationship(restrictedRelationshipPair.getKey());
          kv.remove("restrictedRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.cardinalityRestrictedConcepts.forEach(_function);
  }
  
  protected void resolveCardinalityRestrictedReifiedRelationships(final ResourceSet rs, final ArrayList<Boolean> progress, final ArrayList<Boolean> allDone) {
    final BiConsumer<String, Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>>> _function = (String uuid, Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>> oml_kv) -> {
      final CardinalityRestrictedReifiedRelationship oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.get("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null != tboxPair)) {
          oml.setTbox(tboxPair.getKey());
          kv.remove("tboxUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRangeXRef = kv.get("restrictedRangeUUID");
        if (((null != restrictedRangeXRef) && (!Objects.equal("null", restrictedRangeXRef)))) {
          final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
          if ((null != restrictedRangePair)) {
            oml.setRestrictedRange(restrictedRangePair.getKey());
            kv.remove("restrictedRangeUUID");
            progress.set(0, Boolean.valueOf(true));
          }
        }
        final String sourceXRef = kv.get("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null != sourcePair)) {
          oml.setSource(sourcePair.getKey());
          kv.remove("sourceUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String targetXRef = kv.get("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null != targetPair)) {
          oml.setTarget(targetPair.getKey());
          kv.remove("targetUUID");
          progress.set(0, Boolean.valueOf(true));
        }
        final String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID");
        final Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = this.restrictableRelationships.get(restrictedRelationshipXRef);
        if ((null != restrictedRelationshipPair)) {
          oml.setRestrictedRelationship(restrictedRelationshipPair.getKey());
          kv.remove("restrictedRelationshipUUID");
          progress.set(0, Boolean.valueOf(true));
        }
      }
    };
    this.cardinalityRestrictedReifiedRelationships.forEach(_function);
  }
  
  protected Resource loadOMLZipResource(final ResourceSet rs, final URI uri) {
    try {
      Resource _xblockexpression = null;
      {
        final OMLCatalog omlCatalog = OMLExtensions.getCatalog(rs);
        if ((null == omlCatalog)) {
          throw new IllegalArgumentException("loadOMLZipResource: ResourceSet must have an OMLCatalog!");
        }
        final String uriString = uri.toString();
        Resource _xifexpression = null;
        boolean _startsWith = uriString.startsWith("file:");
        if (_startsWith) {
          _xifexpression = rs.getResource(uri, true);
        } else {
          Resource _xifexpression_1 = null;
          boolean _startsWith_1 = uriString.startsWith("http:");
          if (_startsWith_1) {
            Resource _xblockexpression_1 = null;
            {
              final Resource r0a = rs.getResource(uri, false);
              final Function1<Resource, Boolean> _function = (Resource r) -> {
                final Function1<EObject, Boolean> _function_1 = (EObject e) -> {
                  boolean _switchResult = false;
                  boolean _matched = false;
                  if (e instanceof Extent) {
                    _matched=true;
                    final Function1<gov.nasa.jpl.imce.oml.model.common.Module, Boolean> _function_2 = (gov.nasa.jpl.imce.oml.model.common.Module m) -> {
                      String _iri = m.iri();
                      return Boolean.valueOf(Objects.equal(_iri, uriString));
                    };
                    _switchResult = IterableExtensions.<gov.nasa.jpl.imce.oml.model.common.Module>exists(((Extent)e).getModules(), _function_2);
                  }
                  if (!_matched) {
                    _switchResult = false;
                  }
                  return Boolean.valueOf(_switchResult);
                };
                return Boolean.valueOf(IterableExtensions.<EObject>exists(r.getContents(), _function_1));
              };
              final Resource r0b = IterableExtensions.<Resource>findFirst(rs.getResources(), _function);
              Resource _elvis = null;
              if (r0a != null) {
                _elvis = r0a;
              } else {
                _elvis = r0b;
              }
              final Resource r0 = _elvis;
              Resource _xifexpression_2 = null;
              if ((null != r0)) {
                _xifexpression_2 = r0;
              } else {
                Resource _xblockexpression_2 = null;
                {
                  final String r1 = omlCatalog.resolveURI((uriString + ".oml"));
                  final String r2 = omlCatalog.resolveURI((uriString + ".omlzip"));
                  final String r3 = omlCatalog.resolveURI(uriString);
                  File _xifexpression_3 = null;
                  if (((null != r1) && r1.startsWith("file:"))) {
                    String _substring = r1.substring(5);
                    _xifexpression_3 = new File(_substring);
                  } else {
                    _xifexpression_3 = null;
                  }
                  final File f1 = _xifexpression_3;
                  File _xifexpression_4 = null;
                  if (((null != r2) && r2.startsWith("file:"))) {
                    String _substring_1 = r2.substring(5);
                    _xifexpression_4 = new File(_substring_1);
                  } else {
                    _xifexpression_4 = null;
                  }
                  final File f2 = _xifexpression_4;
                  File _xifexpression_5 = null;
                  if (((null != r3) && r3.startsWith("file:"))) {
                    String _substring_2 = r3.substring(5);
                    _xifexpression_5 = new File(_substring_2);
                  } else {
                    _xifexpression_5 = null;
                  }
                  final File f3 = _xifexpression_5;
                  Resource _xifexpression_6 = null;
                  if ((((null != f1) && f1.exists()) && f1.canRead())) {
                    _xifexpression_6 = rs.getResource(URI.createURI(r1), true);
                  } else {
                    Resource _xifexpression_7 = null;
                    if ((((null != f2) && f2.exists()) && f2.canRead())) {
                      _xifexpression_7 = rs.getResource(URI.createURI(r2), true);
                    } else {
                      Resource _xifexpression_8 = null;
                      if ((((null != f3) && f3.exists()) && f3.canRead())) {
                        _xifexpression_8 = rs.getResource(URI.createURI(r3), true);
                      } else {
                        throw new IllegalArgumentException((("loadOMLZipResource: " + uri) + " not resolved!"));
                      }
                      _xifexpression_7 = _xifexpression_8;
                    }
                    _xifexpression_6 = _xifexpression_7;
                  }
                  _xblockexpression_2 = _xifexpression_6;
                }
                _xifexpression_2 = _xblockexpression_2;
              }
              _xblockexpression_1 = _xifexpression_2;
            }
            _xifexpression_1 = _xblockexpression_1;
          }
          _xifexpression = _xifexpression_1;
        }
        final Resource r = _xifexpression;
        boolean _matched = false;
        if (r instanceof XtextResource) {
          _matched=true;
          final Consumer<EObject> _function = (EObject e) -> {
            boolean _matched_1 = false;
            if (e instanceof Extent) {
              _matched_1=true;
              final Consumer<gov.nasa.jpl.imce.oml.model.common.Module> _function_1 = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
                this.queueModule(it);
              };
              ((Extent)e).getModules().forEach(_function_1);
            }
          };
          ((XtextResource)r).getContents().forEach(_function);
        }
        _xblockexpression = r;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void includeModule(final gov.nasa.jpl.imce.oml.model.common.Module m) {
    if ((null != m)) {
      final String iri = m.iri();
      final String uuid = m.uuid();
      this.iri2module.put(iri, m);
      boolean _matched = false;
      if (m instanceof TerminologyGraph) {
        _matched=true;
        Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
        Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(m, _emptyMap);
        this.logicalElements.put(uuid, _pair);
        Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
        Pair<TerminologyGraph, Map<String, String>> _pair_1 = new Pair<TerminologyGraph, Map<String, String>>(((TerminologyGraph)m), _emptyMap_1);
        this.terminologyGraphs.put(uuid, _pair_1);
        Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
        Pair<TerminologyBox, Map<String, String>> _pair_2 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)m), _emptyMap_2);
        this.terminologyBoxes.put(uuid, _pair_2);
        Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
        Pair<TerminologyBox, Map<String, String>> _pair_3 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)m), _emptyMap_3);
        this.terminologyBoxes.put(iri, _pair_3);
      }
      if (!_matched) {
        if (m instanceof Bundle) {
          _matched=true;
          Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
          Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(m, _emptyMap);
          this.logicalElements.put(uuid, _pair);
          Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
          Pair<Bundle, Map<String, String>> _pair_1 = new Pair<Bundle, Map<String, String>>(((Bundle)m), _emptyMap_1);
          this.bundles.put(uuid, _pair_1);
          Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
          Pair<TerminologyBox, Map<String, String>> _pair_2 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)m), _emptyMap_2);
          this.terminologyBoxes.put(uuid, _pair_2);
          Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
          Pair<TerminologyBox, Map<String, String>> _pair_3 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)m), _emptyMap_3);
          this.terminologyBoxes.put(iri, _pair_3);
        }
      }
      if (!_matched) {
        if (m instanceof DescriptionBox) {
          _matched=true;
          Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
          Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(m, _emptyMap);
          this.logicalElements.put(uuid, _pair);
          Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
          Pair<DescriptionBox, Map<String, String>> _pair_1 = new Pair<DescriptionBox, Map<String, String>>(((DescriptionBox)m), _emptyMap_1);
          this.descriptionBoxes.put(uuid, _pair_1);
          Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
          Pair<DescriptionBox, Map<String, String>> _pair_2 = new Pair<DescriptionBox, Map<String, String>>(((DescriptionBox)m), _emptyMap_2);
          this.descriptionBoxes.put(iri, _pair_2);
        }
      }
      Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
      Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>> _pair = new Pair<gov.nasa.jpl.imce.oml.model.common.Module, Map<String, String>>(m, _emptyMap);
      this.modules.put(uuid, _pair);
      final Procedure1<EObject> _function = (EObject e) -> {
        boolean _matched_1 = false;
        if (e instanceof AnnotationProperty) {
          _matched_1=true;
          Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
          final Pair<AnnotationProperty, Map<String, String>> pair = new Pair<AnnotationProperty, Map<String, String>>(((AnnotationProperty)e), _emptyMap_1);
          this.annotationProperties.put(((AnnotationProperty)e).uuid(), pair);
        }
        if (!_matched_1) {
          if (e instanceof Aspect) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<Aspect, Map<String, String>> pair = new Pair<Aspect, Map<String, String>>(((Aspect)e), _emptyMap_1);
            this.aspects.put(((Aspect)e).uuid(), pair);
            String _uuid = ((Aspect)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof Concept) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<Concept, Map<String, String>> pair = new Pair<Concept, Map<String, String>>(((Concept)e), _emptyMap_1);
            this.concepts.put(((Concept)e).uuid(), pair);
            String _uuid = ((Concept)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof Scalar) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<Scalar, Map<String, String>> pair = new Pair<Scalar, Map<String, String>>(((Scalar)e), _emptyMap_1);
            this.scalars.put(((Scalar)e).uuid(), pair);
            String _uuid = ((Scalar)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof Structure) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<Structure, Map<String, String>> pair = new Pair<Structure, Map<String, String>>(((Structure)e), _emptyMap_1);
            this.structures.put(((Structure)e).uuid(), pair);
            String _uuid = ((Structure)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptDesignationTerminologyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> pair = new Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>(((ConceptDesignationTerminologyAxiom)e), _emptyMap_1);
            this.conceptDesignationTerminologyAxioms.put(((ConceptDesignationTerminologyAxiom)e).uuid(), pair);
            String _uuid = ((ConceptDesignationTerminologyAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof TerminologyExtensionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<TerminologyExtensionAxiom, Map<String, String>> pair = new Pair<TerminologyExtensionAxiom, Map<String, String>>(((TerminologyExtensionAxiom)e), _emptyMap_1);
            this.terminologyExtensionAxioms.put(((TerminologyExtensionAxiom)e).uuid(), pair);
            String _uuid = ((TerminologyExtensionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof TerminologyNestingAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<TerminologyNestingAxiom, Map<String, String>> pair = new Pair<TerminologyNestingAxiom, Map<String, String>>(((TerminologyNestingAxiom)e), _emptyMap_1);
            this.terminologyNestingAxioms.put(((TerminologyNestingAxiom)e).uuid(), pair);
            String _uuid = ((TerminologyNestingAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof BundledTerminologyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<BundledTerminologyAxiom, Map<String, String>> pair = new Pair<BundledTerminologyAxiom, Map<String, String>>(((BundledTerminologyAxiom)e), _emptyMap_1);
            this.bundledTerminologyAxioms.put(((BundledTerminologyAxiom)e).uuid(), pair);
            String _uuid = ((BundledTerminologyAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof DescriptionBoxExtendsClosedWorldDefinitions) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> pair = new Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>(((DescriptionBoxExtendsClosedWorldDefinitions)e), _emptyMap_1);
            this.descriptionBoxExtendsClosedWorldDefinitions.put(((DescriptionBoxExtendsClosedWorldDefinitions)e).uuid(), pair);
            String _uuid = ((DescriptionBoxExtendsClosedWorldDefinitions)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof DescriptionBoxRefinement) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<DescriptionBoxRefinement, Map<String, String>> pair = new Pair<DescriptionBoxRefinement, Map<String, String>>(((DescriptionBoxRefinement)e), _emptyMap_1);
            this.descriptionBoxRefinements.put(((DescriptionBoxRefinement)e).uuid(), pair);
            String _uuid = ((DescriptionBoxRefinement)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof BinaryScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<BinaryScalarRestriction, Map<String, String>> pair = new Pair<BinaryScalarRestriction, Map<String, String>>(((BinaryScalarRestriction)e), _emptyMap_1);
            this.binaryScalarRestrictions.put(((BinaryScalarRestriction)e).uuid(), pair);
            String _uuid = ((BinaryScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof IRIScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<IRIScalarRestriction, Map<String, String>> pair = new Pair<IRIScalarRestriction, Map<String, String>>(((IRIScalarRestriction)e), _emptyMap_1);
            this.iriScalarRestrictions.put(((IRIScalarRestriction)e).uuid(), pair);
            String _uuid = ((IRIScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof NumericScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<NumericScalarRestriction, Map<String, String>> pair = new Pair<NumericScalarRestriction, Map<String, String>>(((NumericScalarRestriction)e), _emptyMap_1);
            this.numericScalarRestrictions.put(((NumericScalarRestriction)e).uuid(), pair);
            String _uuid = ((NumericScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof PlainLiteralScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<PlainLiteralScalarRestriction, Map<String, String>> pair = new Pair<PlainLiteralScalarRestriction, Map<String, String>>(((PlainLiteralScalarRestriction)e), _emptyMap_1);
            this.plainLiteralScalarRestrictions.put(((PlainLiteralScalarRestriction)e).uuid(), pair);
            String _uuid = ((PlainLiteralScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarOneOfRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ScalarOneOfRestriction, Map<String, String>> pair = new Pair<ScalarOneOfRestriction, Map<String, String>>(((ScalarOneOfRestriction)e), _emptyMap_1);
            this.scalarOneOfRestrictions.put(((ScalarOneOfRestriction)e).uuid(), pair);
            String _uuid = ((ScalarOneOfRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarOneOfLiteralAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ScalarOneOfLiteralAxiom, Map<String, String>> pair = new Pair<ScalarOneOfLiteralAxiom, Map<String, String>>(((ScalarOneOfLiteralAxiom)e), _emptyMap_1);
            this.scalarOneOfLiteralAxioms.put(((ScalarOneOfLiteralAxiom)e).uuid(), pair);
            String _uuid = ((ScalarOneOfLiteralAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof StringScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<StringScalarRestriction, Map<String, String>> pair = new Pair<StringScalarRestriction, Map<String, String>>(((StringScalarRestriction)e), _emptyMap_1);
            this.stringScalarRestrictions.put(((StringScalarRestriction)e).uuid(), pair);
            String _uuid = ((StringScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SynonymScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SynonymScalarRestriction, Map<String, String>> pair = new Pair<SynonymScalarRestriction, Map<String, String>>(((SynonymScalarRestriction)e), _emptyMap_1);
            this.synonymScalarRestrictions.put(((SynonymScalarRestriction)e).uuid(), pair);
            String _uuid = ((SynonymScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof TimeScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<TimeScalarRestriction, Map<String, String>> pair = new Pair<TimeScalarRestriction, Map<String, String>>(((TimeScalarRestriction)e), _emptyMap_1);
            this.timeScalarRestrictions.put(((TimeScalarRestriction)e).uuid(), pair);
            String _uuid = ((TimeScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataProperty, Map<String, String>> pair = new Pair<EntityScalarDataProperty, Map<String, String>>(((EntityScalarDataProperty)e), _emptyMap_1);
            this.entityScalarDataProperties.put(((EntityScalarDataProperty)e).uuid(), pair);
            String _uuid = ((EntityScalarDataProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityStructuredDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityStructuredDataProperty, Map<String, String>> pair = new Pair<EntityStructuredDataProperty, Map<String, String>>(((EntityStructuredDataProperty)e), _emptyMap_1);
            this.entityStructuredDataProperties.put(((EntityStructuredDataProperty)e).uuid(), pair);
            String _uuid = ((EntityStructuredDataProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ScalarDataProperty, Map<String, String>> pair = new Pair<ScalarDataProperty, Map<String, String>>(((ScalarDataProperty)e), _emptyMap_1);
            this.scalarDataProperties.put(((ScalarDataProperty)e).uuid(), pair);
            String _uuid = ((ScalarDataProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof StructuredDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<StructuredDataProperty, Map<String, String>> pair = new Pair<StructuredDataProperty, Map<String, String>>(((StructuredDataProperty)e), _emptyMap_1);
            this.structuredDataProperties.put(((StructuredDataProperty)e).uuid(), pair);
            String _uuid = ((StructuredDataProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationship) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationship, Map<String, String>> pair = new Pair<ReifiedRelationship, Map<String, String>>(((ReifiedRelationship)e), _emptyMap_1);
            this.reifiedRelationships.put(((ReifiedRelationship)e).uuid(), pair);
            String _uuid = ((ReifiedRelationship)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipRestriction, Map<String, String>> pair = new Pair<ReifiedRelationshipRestriction, Map<String, String>>(((ReifiedRelationshipRestriction)e), _emptyMap_1);
            this.reifiedRelationshipRestrictions.put(((ReifiedRelationshipRestriction)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ForwardProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ForwardProperty, Map<String, String>> pair = new Pair<ForwardProperty, Map<String, String>>(((ForwardProperty)e), _emptyMap_1);
            this.forwardProperties.put(((ForwardProperty)e).uuid(), pair);
            String _uuid = ((ForwardProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof InverseProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<InverseProperty, Map<String, String>> pair = new Pair<InverseProperty, Map<String, String>>(((InverseProperty)e), _emptyMap_1);
            this.inverseProperties.put(((InverseProperty)e).uuid(), pair);
            String _uuid = ((InverseProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof UnreifiedRelationship) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<UnreifiedRelationship, Map<String, String>> pair = new Pair<UnreifiedRelationship, Map<String, String>>(((UnreifiedRelationship)e), _emptyMap_1);
            this.unreifiedRelationships.put(((UnreifiedRelationship)e).uuid(), pair);
            String _uuid = ((UnreifiedRelationship)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ChainRule) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ChainRule, Map<String, String>> pair = new Pair<ChainRule, Map<String, String>>(((ChainRule)e), _emptyMap_1);
            this.chainRules.put(((ChainRule)e).uuid(), pair);
            String _uuid = ((ChainRule)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof RuleBodySegment) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<RuleBodySegment, Map<String, String>> pair = new Pair<RuleBodySegment, Map<String, String>>(((RuleBodySegment)e), _emptyMap_1);
            this.ruleBodySegments.put(((RuleBodySegment)e).uuid(), pair);
            String _uuid = ((RuleBodySegment)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SegmentPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SegmentPredicate, Map<String, String>> pair = new Pair<SegmentPredicate, Map<String, String>>(((SegmentPredicate)e), _emptyMap_1);
            this.segmentPredicates.put(((SegmentPredicate)e).uuid(), pair);
            String _uuid = ((SegmentPredicate)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityExistentialRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityExistentialRestrictionAxiom, Map<String, String>>(((EntityExistentialRestrictionAxiom)e), _emptyMap_1);
            this.entityExistentialRestrictionAxioms.put(((EntityExistentialRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityExistentialRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityUniversalRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityUniversalRestrictionAxiom, Map<String, String>>(((EntityUniversalRestrictionAxiom)e), _emptyMap_1);
            this.entityUniversalRestrictionAxioms.put(((EntityUniversalRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityUniversalRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyExistentialRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyExistentialRestrictionAxiom)e), _emptyMap_1);
            this.entityScalarDataPropertyExistentialRestrictionAxioms.put(((EntityScalarDataPropertyExistentialRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityScalarDataPropertyExistentialRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyParticularRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyParticularRestrictionAxiom)e), _emptyMap_1);
            this.entityScalarDataPropertyParticularRestrictionAxioms.put(((EntityScalarDataPropertyParticularRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityScalarDataPropertyParticularRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyUniversalRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyUniversalRestrictionAxiom)e), _emptyMap_1);
            this.entityScalarDataPropertyUniversalRestrictionAxioms.put(((EntityScalarDataPropertyUniversalRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityScalarDataPropertyUniversalRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>(((EntityStructuredDataPropertyParticularRestrictionAxiom)e), _emptyMap_1);
            this.entityStructuredDataPropertyParticularRestrictionAxioms.put(((EntityStructuredDataPropertyParticularRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityStructuredDataPropertyParticularRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof RestrictionStructuredDataPropertyTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>> pair = new Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>(((RestrictionStructuredDataPropertyTuple)e), _emptyMap_1);
            this.restrictionStructuredDataPropertyTuples.put(((RestrictionStructuredDataPropertyTuple)e).uuid(), pair);
            String _uuid = ((RestrictionStructuredDataPropertyTuple)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof RestrictionScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<RestrictionScalarDataPropertyValue, Map<String, String>> pair = new Pair<RestrictionScalarDataPropertyValue, Map<String, String>>(((RestrictionScalarDataPropertyValue)e), _emptyMap_1);
            this.restrictionScalarDataPropertyValues.put(((RestrictionScalarDataPropertyValue)e).uuid(), pair);
            String _uuid = ((RestrictionScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof AspectSpecializationAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<AspectSpecializationAxiom, Map<String, String>> pair = new Pair<AspectSpecializationAxiom, Map<String, String>>(((AspectSpecializationAxiom)e), _emptyMap_1);
            this.aspectSpecializationAxioms.put(((AspectSpecializationAxiom)e).uuid(), pair);
            String _uuid = ((AspectSpecializationAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptSpecializationAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ConceptSpecializationAxiom, Map<String, String>> pair = new Pair<ConceptSpecializationAxiom, Map<String, String>>(((ConceptSpecializationAxiom)e), _emptyMap_1);
            this.conceptSpecializationAxioms.put(((ConceptSpecializationAxiom)e).uuid(), pair);
            String _uuid = ((ConceptSpecializationAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipSpecializationAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>> pair = new Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>(((ReifiedRelationshipSpecializationAxiom)e), _emptyMap_1);
            this.reifiedRelationshipSpecializationAxioms.put(((ReifiedRelationshipSpecializationAxiom)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipSpecializationAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SubDataPropertyOfAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SubDataPropertyOfAxiom, Map<String, String>> pair = new Pair<SubDataPropertyOfAxiom, Map<String, String>>(((SubDataPropertyOfAxiom)e), _emptyMap_1);
            this.subDataPropertyOfAxioms.put(((SubDataPropertyOfAxiom)e).uuid(), pair);
            String _uuid = ((SubDataPropertyOfAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SubObjectPropertyOfAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SubObjectPropertyOfAxiom, Map<String, String>> pair = new Pair<SubObjectPropertyOfAxiom, Map<String, String>>(((SubObjectPropertyOfAxiom)e), _emptyMap_1);
            this.subObjectPropertyOfAxioms.put(((SubObjectPropertyOfAxiom)e).uuid(), pair);
            String _uuid = ((SubObjectPropertyOfAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof RootConceptTaxonomyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<RootConceptTaxonomyAxiom, Map<String, String>> pair = new Pair<RootConceptTaxonomyAxiom, Map<String, String>>(((RootConceptTaxonomyAxiom)e), _emptyMap_1);
            this.rootConceptTaxonomyAxioms.put(((RootConceptTaxonomyAxiom)e).uuid(), pair);
            String _uuid = ((RootConceptTaxonomyAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof AnonymousConceptUnionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<AnonymousConceptUnionAxiom, Map<String, String>> pair = new Pair<AnonymousConceptUnionAxiom, Map<String, String>>(((AnonymousConceptUnionAxiom)e), _emptyMap_1);
            this.anonymousConceptUnionAxioms.put(((AnonymousConceptUnionAxiom)e).uuid(), pair);
            String _uuid = ((AnonymousConceptUnionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SpecificDisjointConceptAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SpecificDisjointConceptAxiom, Map<String, String>> pair = new Pair<SpecificDisjointConceptAxiom, Map<String, String>>(((SpecificDisjointConceptAxiom)e), _emptyMap_1);
            this.specificDisjointConceptAxioms.put(((SpecificDisjointConceptAxiom)e).uuid(), pair);
            String _uuid = ((SpecificDisjointConceptAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptInstance) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ConceptInstance, Map<String, String>> pair = new Pair<ConceptInstance, Map<String, String>>(((ConceptInstance)e), _emptyMap_1);
            this.conceptInstances.put(((ConceptInstance)e).uuid(), pair);
            String _uuid = ((ConceptInstance)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstance) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstance, Map<String, String>> pair = new Pair<ReifiedRelationshipInstance, Map<String, String>>(((ReifiedRelationshipInstance)e), _emptyMap_1);
            this.reifiedRelationshipInstances.put(((ReifiedRelationshipInstance)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipInstance)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstanceDomain) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstanceDomain, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>(((ReifiedRelationshipInstanceDomain)e), _emptyMap_1);
            this.reifiedRelationshipInstanceDomains.put(((ReifiedRelationshipInstanceDomain)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipInstanceDomain)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstanceRange) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstanceRange, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceRange, Map<String, String>>(((ReifiedRelationshipInstanceRange)e), _emptyMap_1);
            this.reifiedRelationshipInstanceRanges.put(((ReifiedRelationshipInstanceRange)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipInstanceRange)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof UnreifiedRelationshipInstanceTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>> pair = new Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>(((UnreifiedRelationshipInstanceTuple)e), _emptyMap_1);
            this.unreifiedRelationshipInstanceTuples.put(((UnreifiedRelationshipInstanceTuple)e).uuid(), pair);
            String _uuid = ((UnreifiedRelationshipInstanceTuple)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SingletonInstanceStructuredDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>(((SingletonInstanceStructuredDataPropertyValue)e), _emptyMap_1);
            this.singletonInstanceStructuredDataPropertyValues.put(((SingletonInstanceStructuredDataPropertyValue)e).uuid(), pair);
            String _uuid = ((SingletonInstanceStructuredDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SingletonInstanceScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>(((SingletonInstanceScalarDataPropertyValue)e), _emptyMap_1);
            this.singletonInstanceScalarDataPropertyValues.put(((SingletonInstanceScalarDataPropertyValue)e).uuid(), pair);
            String _uuid = ((SingletonInstanceScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof StructuredDataPropertyTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<StructuredDataPropertyTuple, Map<String, String>> pair = new Pair<StructuredDataPropertyTuple, Map<String, String>>(((StructuredDataPropertyTuple)e), _emptyMap_1);
            this.structuredDataPropertyTuples.put(((StructuredDataPropertyTuple)e).uuid(), pair);
            String _uuid = ((StructuredDataPropertyTuple)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ScalarDataPropertyValue, Map<String, String>> pair = new Pair<ScalarDataPropertyValue, Map<String, String>>(((ScalarDataPropertyValue)e), _emptyMap_1);
            this.scalarDataPropertyValues.put(((ScalarDataPropertyValue)e).uuid(), pair);
            String _uuid = ((ScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof AnnotationPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<AnnotationPropertyValue, Map<String, String>> pair = new Pair<AnnotationPropertyValue, Map<String, String>>(((AnnotationPropertyValue)e), _emptyMap_1);
            this.annotationPropertyValues.put(((AnnotationPropertyValue)e).uuid(), pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof CardinalityRestrictedAspect) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<CardinalityRestrictedAspect, Map<String, String>> pair = new Pair<CardinalityRestrictedAspect, Map<String, String>>(((CardinalityRestrictedAspect)e), _emptyMap_1);
            this.cardinalityRestrictedAspects.put(((CardinalityRestrictedAspect)e).uuid(), pair);
            String _uuid = ((CardinalityRestrictedAspect)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof CardinalityRestrictedConcept) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<CardinalityRestrictedConcept, Map<String, String>> pair = new Pair<CardinalityRestrictedConcept, Map<String, String>>(((CardinalityRestrictedConcept)e), _emptyMap_1);
            this.cardinalityRestrictedConcepts.put(((CardinalityRestrictedConcept)e).uuid(), pair);
            String _uuid = ((CardinalityRestrictedConcept)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof CardinalityRestrictedReifiedRelationship) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>> pair = new Pair<CardinalityRestrictedReifiedRelationship, Map<String, String>>(((CardinalityRestrictedReifiedRelationship)e), _emptyMap_1);
            this.cardinalityRestrictedReifiedRelationships.put(((CardinalityRestrictedReifiedRelationship)e).uuid(), pair);
            String _uuid = ((CardinalityRestrictedReifiedRelationship)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid, _pair_1);
          }
        }
      };
      IteratorExtensions.<EObject>forEach(m.eAllContents(), _function);
    }
  }
}
