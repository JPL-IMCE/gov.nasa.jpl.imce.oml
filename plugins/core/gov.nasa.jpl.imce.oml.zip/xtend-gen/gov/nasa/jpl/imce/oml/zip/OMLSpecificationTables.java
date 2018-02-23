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
import gov.nasa.jpl.imce.oml.model.common.Module;
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
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
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
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializedReifiedRelationship;
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
  
  protected final Map<String, Pair<ForwardProperty, Map<String, String>>> forwardProperties;
  
  protected final Map<String, Pair<InverseProperty, Map<String, String>>> inverseProperties;
  
  protected final Map<String, Pair<SpecializedReifiedRelationship, Map<String, String>>> specializedReifiedRelationships;
  
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
  
  protected final Map<String, Pair<Module, Map<String, String>>> modules;
  
  protected final Map<String, Pair<LogicalElement, Map<String, String>>> logicalElements;
  
  protected final Map<String, Pair<Entity, Map<String, String>>> entities;
  
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
  
  protected final Queue<Module> moduleQueue;
  
  protected final Set<Module> visitedModules;
  
  public OMLSpecificationTables() {
    LinkedList<String> _linkedList = new LinkedList<String>();
    this.iriLoadQueue = _linkedList;
    HashSet<String> _hashSet = new HashSet<String>();
    this.visitedIRIs = _hashSet;
    LinkedList<Module> _linkedList_1 = new LinkedList<Module>();
    this.moduleQueue = _linkedList_1;
    HashSet<Module> _hashSet_1 = new HashSet<Module>();
    this.visitedModules = _hashSet_1;
    this.omlCommonFactory = CommonFactory.eINSTANCE;
    this.omlTerminologiesFactory = TerminologiesFactory.eINSTANCE;
    this.omlGraphsFactory = GraphsFactory.eINSTANCE;
    this.omlBundlesFactory = BundlesFactory.eINSTANCE;
    this.omlDescriptionsFactory = DescriptionsFactory.eINSTANCE;
    HashMap<String, Pair<TerminologyGraph, Map<String, String>>> _hashMap = new HashMap<String, Pair<TerminologyGraph, Map<String, String>>>();
    this.terminologyGraphs = _hashMap;
    HashMap<String, Pair<Bundle, Map<String, String>>> _hashMap_1 = new HashMap<String, Pair<Bundle, Map<String, String>>>();
    this.bundles = _hashMap_1;
    HashMap<String, Pair<DescriptionBox, Map<String, String>>> _hashMap_2 = new HashMap<String, Pair<DescriptionBox, Map<String, String>>>();
    this.descriptionBoxes = _hashMap_2;
    HashMap<String, Pair<AnnotationProperty, Map<String, String>>> _hashMap_3 = new HashMap<String, Pair<AnnotationProperty, Map<String, String>>>();
    this.annotationProperties = _hashMap_3;
    HashMap<String, Pair<Aspect, Map<String, String>>> _hashMap_4 = new HashMap<String, Pair<Aspect, Map<String, String>>>();
    this.aspects = _hashMap_4;
    HashMap<String, Pair<Concept, Map<String, String>>> _hashMap_5 = new HashMap<String, Pair<Concept, Map<String, String>>>();
    this.concepts = _hashMap_5;
    HashMap<String, Pair<Scalar, Map<String, String>>> _hashMap_6 = new HashMap<String, Pair<Scalar, Map<String, String>>>();
    this.scalars = _hashMap_6;
    HashMap<String, Pair<Structure, Map<String, String>>> _hashMap_7 = new HashMap<String, Pair<Structure, Map<String, String>>>();
    this.structures = _hashMap_7;
    HashMap<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>> _hashMap_8 = new HashMap<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>>();
    this.conceptDesignationTerminologyAxioms = _hashMap_8;
    HashMap<String, Pair<TerminologyExtensionAxiom, Map<String, String>>> _hashMap_9 = new HashMap<String, Pair<TerminologyExtensionAxiom, Map<String, String>>>();
    this.terminologyExtensionAxioms = _hashMap_9;
    HashMap<String, Pair<TerminologyNestingAxiom, Map<String, String>>> _hashMap_10 = new HashMap<String, Pair<TerminologyNestingAxiom, Map<String, String>>>();
    this.terminologyNestingAxioms = _hashMap_10;
    HashMap<String, Pair<BundledTerminologyAxiom, Map<String, String>>> _hashMap_11 = new HashMap<String, Pair<BundledTerminologyAxiom, Map<String, String>>>();
    this.bundledTerminologyAxioms = _hashMap_11;
    HashMap<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>> _hashMap_12 = new HashMap<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>>();
    this.descriptionBoxExtendsClosedWorldDefinitions = _hashMap_12;
    HashMap<String, Pair<DescriptionBoxRefinement, Map<String, String>>> _hashMap_13 = new HashMap<String, Pair<DescriptionBoxRefinement, Map<String, String>>>();
    this.descriptionBoxRefinements = _hashMap_13;
    HashMap<String, Pair<BinaryScalarRestriction, Map<String, String>>> _hashMap_14 = new HashMap<String, Pair<BinaryScalarRestriction, Map<String, String>>>();
    this.binaryScalarRestrictions = _hashMap_14;
    HashMap<String, Pair<IRIScalarRestriction, Map<String, String>>> _hashMap_15 = new HashMap<String, Pair<IRIScalarRestriction, Map<String, String>>>();
    this.iriScalarRestrictions = _hashMap_15;
    HashMap<String, Pair<NumericScalarRestriction, Map<String, String>>> _hashMap_16 = new HashMap<String, Pair<NumericScalarRestriction, Map<String, String>>>();
    this.numericScalarRestrictions = _hashMap_16;
    HashMap<String, Pair<PlainLiteralScalarRestriction, Map<String, String>>> _hashMap_17 = new HashMap<String, Pair<PlainLiteralScalarRestriction, Map<String, String>>>();
    this.plainLiteralScalarRestrictions = _hashMap_17;
    HashMap<String, Pair<ScalarOneOfRestriction, Map<String, String>>> _hashMap_18 = new HashMap<String, Pair<ScalarOneOfRestriction, Map<String, String>>>();
    this.scalarOneOfRestrictions = _hashMap_18;
    HashMap<String, Pair<ScalarOneOfLiteralAxiom, Map<String, String>>> _hashMap_19 = new HashMap<String, Pair<ScalarOneOfLiteralAxiom, Map<String, String>>>();
    this.scalarOneOfLiteralAxioms = _hashMap_19;
    HashMap<String, Pair<StringScalarRestriction, Map<String, String>>> _hashMap_20 = new HashMap<String, Pair<StringScalarRestriction, Map<String, String>>>();
    this.stringScalarRestrictions = _hashMap_20;
    HashMap<String, Pair<SynonymScalarRestriction, Map<String, String>>> _hashMap_21 = new HashMap<String, Pair<SynonymScalarRestriction, Map<String, String>>>();
    this.synonymScalarRestrictions = _hashMap_21;
    HashMap<String, Pair<TimeScalarRestriction, Map<String, String>>> _hashMap_22 = new HashMap<String, Pair<TimeScalarRestriction, Map<String, String>>>();
    this.timeScalarRestrictions = _hashMap_22;
    HashMap<String, Pair<EntityScalarDataProperty, Map<String, String>>> _hashMap_23 = new HashMap<String, Pair<EntityScalarDataProperty, Map<String, String>>>();
    this.entityScalarDataProperties = _hashMap_23;
    HashMap<String, Pair<EntityStructuredDataProperty, Map<String, String>>> _hashMap_24 = new HashMap<String, Pair<EntityStructuredDataProperty, Map<String, String>>>();
    this.entityStructuredDataProperties = _hashMap_24;
    HashMap<String, Pair<ScalarDataProperty, Map<String, String>>> _hashMap_25 = new HashMap<String, Pair<ScalarDataProperty, Map<String, String>>>();
    this.scalarDataProperties = _hashMap_25;
    HashMap<String, Pair<StructuredDataProperty, Map<String, String>>> _hashMap_26 = new HashMap<String, Pair<StructuredDataProperty, Map<String, String>>>();
    this.structuredDataProperties = _hashMap_26;
    HashMap<String, Pair<ReifiedRelationship, Map<String, String>>> _hashMap_27 = new HashMap<String, Pair<ReifiedRelationship, Map<String, String>>>();
    this.reifiedRelationships = _hashMap_27;
    HashMap<String, Pair<ForwardProperty, Map<String, String>>> _hashMap_28 = new HashMap<String, Pair<ForwardProperty, Map<String, String>>>();
    this.forwardProperties = _hashMap_28;
    HashMap<String, Pair<InverseProperty, Map<String, String>>> _hashMap_29 = new HashMap<String, Pair<InverseProperty, Map<String, String>>>();
    this.inverseProperties = _hashMap_29;
    HashMap<String, Pair<SpecializedReifiedRelationship, Map<String, String>>> _hashMap_30 = new HashMap<String, Pair<SpecializedReifiedRelationship, Map<String, String>>>();
    this.specializedReifiedRelationships = _hashMap_30;
    HashMap<String, Pair<UnreifiedRelationship, Map<String, String>>> _hashMap_31 = new HashMap<String, Pair<UnreifiedRelationship, Map<String, String>>>();
    this.unreifiedRelationships = _hashMap_31;
    HashMap<String, Pair<ChainRule, Map<String, String>>> _hashMap_32 = new HashMap<String, Pair<ChainRule, Map<String, String>>>();
    this.chainRules = _hashMap_32;
    HashMap<String, Pair<RuleBodySegment, Map<String, String>>> _hashMap_33 = new HashMap<String, Pair<RuleBodySegment, Map<String, String>>>();
    this.ruleBodySegments = _hashMap_33;
    HashMap<String, Pair<SegmentPredicate, Map<String, String>>> _hashMap_34 = new HashMap<String, Pair<SegmentPredicate, Map<String, String>>>();
    this.segmentPredicates = _hashMap_34;
    HashMap<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>> _hashMap_35 = new HashMap<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>>();
    this.entityExistentialRestrictionAxioms = _hashMap_35;
    HashMap<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>> _hashMap_36 = new HashMap<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>>();
    this.entityUniversalRestrictionAxioms = _hashMap_36;
    HashMap<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>> _hashMap_37 = new HashMap<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyExistentialRestrictionAxioms = _hashMap_37;
    HashMap<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>> _hashMap_38 = new HashMap<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyParticularRestrictionAxioms = _hashMap_38;
    HashMap<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>> _hashMap_39 = new HashMap<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyUniversalRestrictionAxioms = _hashMap_39;
    HashMap<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>> _hashMap_40 = new HashMap<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>>();
    this.entityStructuredDataPropertyParticularRestrictionAxioms = _hashMap_40;
    HashMap<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>> _hashMap_41 = new HashMap<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>>();
    this.restrictionStructuredDataPropertyTuples = _hashMap_41;
    HashMap<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>> _hashMap_42 = new HashMap<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>>();
    this.restrictionScalarDataPropertyValues = _hashMap_42;
    HashMap<String, Pair<AspectSpecializationAxiom, Map<String, String>>> _hashMap_43 = new HashMap<String, Pair<AspectSpecializationAxiom, Map<String, String>>>();
    this.aspectSpecializationAxioms = _hashMap_43;
    HashMap<String, Pair<ConceptSpecializationAxiom, Map<String, String>>> _hashMap_44 = new HashMap<String, Pair<ConceptSpecializationAxiom, Map<String, String>>>();
    this.conceptSpecializationAxioms = _hashMap_44;
    HashMap<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>> _hashMap_45 = new HashMap<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>>();
    this.subDataPropertyOfAxioms = _hashMap_45;
    HashMap<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>> _hashMap_46 = new HashMap<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>>();
    this.subObjectPropertyOfAxioms = _hashMap_46;
    HashMap<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>> _hashMap_47 = new HashMap<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>>();
    this.rootConceptTaxonomyAxioms = _hashMap_47;
    HashMap<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>> _hashMap_48 = new HashMap<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>>();
    this.anonymousConceptUnionAxioms = _hashMap_48;
    HashMap<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>> _hashMap_49 = new HashMap<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>>();
    this.specificDisjointConceptAxioms = _hashMap_49;
    HashMap<String, Pair<ConceptInstance, Map<String, String>>> _hashMap_50 = new HashMap<String, Pair<ConceptInstance, Map<String, String>>>();
    this.conceptInstances = _hashMap_50;
    HashMap<String, Pair<ReifiedRelationshipInstance, Map<String, String>>> _hashMap_51 = new HashMap<String, Pair<ReifiedRelationshipInstance, Map<String, String>>>();
    this.reifiedRelationshipInstances = _hashMap_51;
    HashMap<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>> _hashMap_52 = new HashMap<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>>();
    this.reifiedRelationshipInstanceDomains = _hashMap_52;
    HashMap<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>> _hashMap_53 = new HashMap<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>>();
    this.reifiedRelationshipInstanceRanges = _hashMap_53;
    HashMap<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>> _hashMap_54 = new HashMap<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>>();
    this.unreifiedRelationshipInstanceTuples = _hashMap_54;
    HashMap<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>> _hashMap_55 = new HashMap<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>>();
    this.singletonInstanceStructuredDataPropertyValues = _hashMap_55;
    HashMap<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>> _hashMap_56 = new HashMap<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>>();
    this.singletonInstanceScalarDataPropertyValues = _hashMap_56;
    HashMap<String, Pair<StructuredDataPropertyTuple, Map<String, String>>> _hashMap_57 = new HashMap<String, Pair<StructuredDataPropertyTuple, Map<String, String>>>();
    this.structuredDataPropertyTuples = _hashMap_57;
    HashMap<String, Pair<ScalarDataPropertyValue, Map<String, String>>> _hashMap_58 = new HashMap<String, Pair<ScalarDataPropertyValue, Map<String, String>>>();
    this.scalarDataPropertyValues = _hashMap_58;
    HashMap<String, Pair<AnnotationPropertyValue, Map<String, String>>> _hashMap_59 = new HashMap<String, Pair<AnnotationPropertyValue, Map<String, String>>>();
    this.annotationPropertyValues = _hashMap_59;
    HashMap<String, Pair<Module, Map<String, String>>> _hashMap_60 = new HashMap<String, Pair<Module, Map<String, String>>>();
    this.modules = _hashMap_60;
    HashMap<String, Pair<LogicalElement, Map<String, String>>> _hashMap_61 = new HashMap<String, Pair<LogicalElement, Map<String, String>>>();
    this.logicalElements = _hashMap_61;
    HashMap<String, Pair<Entity, Map<String, String>>> _hashMap_62 = new HashMap<String, Pair<Entity, Map<String, String>>>();
    this.entities = _hashMap_62;
    HashMap<String, Pair<EntityRelationship, Map<String, String>>> _hashMap_63 = new HashMap<String, Pair<EntityRelationship, Map<String, String>>>();
    this.entityRelationships = _hashMap_63;
    HashMap<String, Pair<ConceptualRelationship, Map<String, String>>> _hashMap_64 = new HashMap<String, Pair<ConceptualRelationship, Map<String, String>>>();
    this.conceptualRelationships = _hashMap_64;
    HashMap<String, Pair<DataRange, Map<String, String>>> _hashMap_65 = new HashMap<String, Pair<DataRange, Map<String, String>>>();
    this.dataRanges = _hashMap_65;
    HashMap<String, Pair<DataRelationshipToScalar, Map<String, String>>> _hashMap_66 = new HashMap<String, Pair<DataRelationshipToScalar, Map<String, String>>>();
    this.dataRelationshipToScalars = _hashMap_66;
    HashMap<String, Pair<DataRelationshipToStructure, Map<String, String>>> _hashMap_67 = new HashMap<String, Pair<DataRelationshipToStructure, Map<String, String>>>();
    this.dataRelationshipToStructures = _hashMap_67;
    HashMap<String, Pair<Predicate, Map<String, String>>> _hashMap_68 = new HashMap<String, Pair<Predicate, Map<String, String>>>();
    this.predicates = _hashMap_68;
    HashMap<String, Pair<RestrictableRelationship, Map<String, String>>> _hashMap_69 = new HashMap<String, Pair<RestrictableRelationship, Map<String, String>>>();
    this.restrictableRelationships = _hashMap_69;
    HashMap<String, Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>> _hashMap_70 = new HashMap<String, Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>>();
    this.restrictionStructuredDataPropertyContexts = _hashMap_70;
    HashMap<String, Pair<TerminologyBox, Map<String, String>>> _hashMap_71 = new HashMap<String, Pair<TerminologyBox, Map<String, String>>>();
    this.terminologyBoxes = _hashMap_71;
    HashMap<String, Pair<ConceptTreeDisjunction, Map<String, String>>> _hashMap_72 = new HashMap<String, Pair<ConceptTreeDisjunction, Map<String, String>>>();
    this.conceptTreeDisjunctions = _hashMap_72;
    HashMap<String, Pair<ConceptualEntitySingletonInstance, Map<String, String>>> _hashMap_73 = new HashMap<String, Pair<ConceptualEntitySingletonInstance, Map<String, String>>>();
    this.conceptualEntitySingletonInstances = _hashMap_73;
    HashMap<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>> _hashMap_74 = new HashMap<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>>();
    this.singletonInstanceStructuredDataPropertyContexts = _hashMap_74;
  }
  
  public static void save(final Extent e, final ZipArchiveOutputStream zos) {
    try {
      ZipArchiveEntry entry = null;
      ZipArchiveEntry _zipArchiveEntry = new ZipArchiveEntry("TerminologyGraphs.json");
      entry = _zipArchiveEntry;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.terminologyGraphsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_1 = new ZipArchiveEntry("Bundles.json");
      entry = _zipArchiveEntry_1;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.bundlesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_2 = new ZipArchiveEntry("DescriptionBoxes.json");
      entry = _zipArchiveEntry_2;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.descriptionBoxesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_3 = new ZipArchiveEntry("AnnotationProperties.json");
      entry = _zipArchiveEntry_3;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.annotationPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_4 = new ZipArchiveEntry("Aspects.json");
      entry = _zipArchiveEntry_4;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.aspectsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_5 = new ZipArchiveEntry("Concepts.json");
      entry = _zipArchiveEntry_5;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_6 = new ZipArchiveEntry("Scalars.json");
      entry = _zipArchiveEntry_6;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_7 = new ZipArchiveEntry("Structures.json");
      entry = _zipArchiveEntry_7;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.structuresByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_8 = new ZipArchiveEntry("ConceptDesignationTerminologyAxioms.json");
      entry = _zipArchiveEntry_8;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptDesignationTerminologyAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_9 = new ZipArchiveEntry("TerminologyExtensionAxioms.json");
      entry = _zipArchiveEntry_9;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.terminologyExtensionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_10 = new ZipArchiveEntry("TerminologyNestingAxioms.json");
      entry = _zipArchiveEntry_10;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.terminologyNestingAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_11 = new ZipArchiveEntry("BundledTerminologyAxioms.json");
      entry = _zipArchiveEntry_11;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.bundledTerminologyAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_12 = new ZipArchiveEntry("DescriptionBoxExtendsClosedWorldDefinitions.json");
      entry = _zipArchiveEntry_12;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.descriptionBoxExtendsClosedWorldDefinitionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_13 = new ZipArchiveEntry("DescriptionBoxRefinements.json");
      entry = _zipArchiveEntry_13;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.descriptionBoxRefinementsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_14 = new ZipArchiveEntry("BinaryScalarRestrictions.json");
      entry = _zipArchiveEntry_14;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.binaryScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_15 = new ZipArchiveEntry("IRIScalarRestrictions.json");
      entry = _zipArchiveEntry_15;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.iriScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_16 = new ZipArchiveEntry("NumericScalarRestrictions.json");
      entry = _zipArchiveEntry_16;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.numericScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_17 = new ZipArchiveEntry("PlainLiteralScalarRestrictions.json");
      entry = _zipArchiveEntry_17;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.plainLiteralScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_18 = new ZipArchiveEntry("ScalarOneOfRestrictions.json");
      entry = _zipArchiveEntry_18;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarOneOfRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_19 = new ZipArchiveEntry("ScalarOneOfLiteralAxioms.json");
      entry = _zipArchiveEntry_19;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarOneOfLiteralAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_20 = new ZipArchiveEntry("StringScalarRestrictions.json");
      entry = _zipArchiveEntry_20;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.stringScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_21 = new ZipArchiveEntry("SynonymScalarRestrictions.json");
      entry = _zipArchiveEntry_21;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.synonymScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_22 = new ZipArchiveEntry("TimeScalarRestrictions.json");
      entry = _zipArchiveEntry_22;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.timeScalarRestrictionsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_23 = new ZipArchiveEntry("EntityScalarDataProperties.json");
      entry = _zipArchiveEntry_23;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_24 = new ZipArchiveEntry("EntityStructuredDataProperties.json");
      entry = _zipArchiveEntry_24;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityStructuredDataPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_25 = new ZipArchiveEntry("ScalarDataProperties.json");
      entry = _zipArchiveEntry_25;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarDataPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_26 = new ZipArchiveEntry("StructuredDataProperties.json");
      entry = _zipArchiveEntry_26;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.structuredDataPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_27 = new ZipArchiveEntry("ReifiedRelationships.json");
      entry = _zipArchiveEntry_27;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_28 = new ZipArchiveEntry("ForwardProperties.json");
      entry = _zipArchiveEntry_28;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.forwardPropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_29 = new ZipArchiveEntry("InverseProperties.json");
      entry = _zipArchiveEntry_29;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.inversePropertiesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_30 = new ZipArchiveEntry("SpecializedReifiedRelationships.json");
      entry = _zipArchiveEntry_30;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.specializedReifiedRelationshipsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_31 = new ZipArchiveEntry("UnreifiedRelationships.json");
      entry = _zipArchiveEntry_31;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.unreifiedRelationshipsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_32 = new ZipArchiveEntry("ChainRules.json");
      entry = _zipArchiveEntry_32;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.chainRulesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_33 = new ZipArchiveEntry("RuleBodySegments.json");
      entry = _zipArchiveEntry_33;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.ruleBodySegmentsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_34 = new ZipArchiveEntry("SegmentPredicates.json");
      entry = _zipArchiveEntry_34;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.segmentPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_35 = new ZipArchiveEntry("EntityExistentialRestrictionAxioms.json");
      entry = _zipArchiveEntry_35;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityExistentialRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_36 = new ZipArchiveEntry("EntityUniversalRestrictionAxioms.json");
      entry = _zipArchiveEntry_36;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityUniversalRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_37 = new ZipArchiveEntry("EntityScalarDataPropertyExistentialRestrictionAxioms.json");
      entry = _zipArchiveEntry_37;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyExistentialRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_38 = new ZipArchiveEntry("EntityScalarDataPropertyParticularRestrictionAxioms.json");
      entry = _zipArchiveEntry_38;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyParticularRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_39 = new ZipArchiveEntry("EntityScalarDataPropertyUniversalRestrictionAxioms.json");
      entry = _zipArchiveEntry_39;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyUniversalRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_40 = new ZipArchiveEntry("EntityStructuredDataPropertyParticularRestrictionAxioms.json");
      entry = _zipArchiveEntry_40;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityStructuredDataPropertyParticularRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_41 = new ZipArchiveEntry("RestrictionStructuredDataPropertyTuples.json");
      entry = _zipArchiveEntry_41;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.restrictionStructuredDataPropertyTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_42 = new ZipArchiveEntry("RestrictionScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_42;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.restrictionScalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_43 = new ZipArchiveEntry("AspectSpecializationAxioms.json");
      entry = _zipArchiveEntry_43;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.aspectSpecializationAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_44 = new ZipArchiveEntry("ConceptSpecializationAxioms.json");
      entry = _zipArchiveEntry_44;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptSpecializationAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_45 = new ZipArchiveEntry("SubDataPropertyOfAxioms.json");
      entry = _zipArchiveEntry_45;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.subDataPropertyOfAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_46 = new ZipArchiveEntry("SubObjectPropertyOfAxioms.json");
      entry = _zipArchiveEntry_46;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.subObjectPropertyOfAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_47 = new ZipArchiveEntry("RootConceptTaxonomyAxioms.json");
      entry = _zipArchiveEntry_47;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.rootConceptTaxonomyAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_48 = new ZipArchiveEntry("AnonymousConceptUnionAxioms.json");
      entry = _zipArchiveEntry_48;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.anonymousConceptUnionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_49 = new ZipArchiveEntry("SpecificDisjointConceptAxioms.json");
      entry = _zipArchiveEntry_49;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.specificDisjointConceptAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_50 = new ZipArchiveEntry("ConceptInstances.json");
      entry = _zipArchiveEntry_50;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptInstancesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_51 = new ZipArchiveEntry("ReifiedRelationshipInstances.json");
      entry = _zipArchiveEntry_51;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstancesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_52 = new ZipArchiveEntry("ReifiedRelationshipInstanceDomains.json");
      entry = _zipArchiveEntry_52;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstanceDomainsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_53 = new ZipArchiveEntry("ReifiedRelationshipInstanceRanges.json");
      entry = _zipArchiveEntry_53;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstanceRangesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_54 = new ZipArchiveEntry("UnreifiedRelationshipInstanceTuples.json");
      entry = _zipArchiveEntry_54;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.unreifiedRelationshipInstanceTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_55 = new ZipArchiveEntry("SingletonInstanceStructuredDataPropertyValues.json");
      entry = _zipArchiveEntry_55;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.singletonInstanceStructuredDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_56 = new ZipArchiveEntry("SingletonInstanceScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_56;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.singletonInstanceScalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_57 = new ZipArchiveEntry("StructuredDataPropertyTuples.json");
      entry = _zipArchiveEntry_57;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.structuredDataPropertyTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_58 = new ZipArchiveEntry("ScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_58;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_59 = new ZipArchiveEntry("AnnotationPropertyValues.json");
      entry = _zipArchiveEntry_59;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.annotationPropertyValuesByteArray(e));
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
  
  protected static byte[] specializedReifiedRelationshipsByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<SpecializedReifiedRelationship> _function = (SpecializedReifiedRelationship it) -> {
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
      pw.print("\"generalUUID\":");
      pw.print("\"");
      pw.print(it.getGeneral().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.specializedReifiedRelationships(e).forEach(_function);
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
  
  /**
   * Uses an OMLSpecificationTables for resolving cross-references in the *.oml and *.omlzip representations.
   * When there are no more OML resources to load, it is necessary to call explicitly:
   * 
   *     OMLZipResource.clearOMLSpecificationTables(rs)
   */
  public static void load(final ResourceSet rs, final OMLZipResource r, final File omlZipFile) {
    try {
      final OMLSpecificationTables tables = OMLZipResource.getOrInitializeOMLSpecificationTables(rs);
      final Extent ext = tables.omlCommonFactory.createExtent();
      r.getContents().add(ext);
      final ZipFile zip = new ZipFile(omlZipFile);
      final Consumer<ZipArchiveEntry> _function = (ZipArchiveEntry ze) -> {
        try {
          final InputStream is = zip.getInputStream(ze);
          InputStreamReader _inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
          final BufferedReader buffer = new BufferedReader(_inputStreamReader);
          final ArrayList<String> lines = new ArrayList<String>();
          Iterables.<String>addAll(lines, IteratorExtensions.<String>toIterable(buffer.lines().iterator()));
          buffer.close();
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
              case "ForwardProperties.json":
                tables.readForwardProperties(ext, lines);
                break;
              case "InverseProperties.json":
                tables.readInverseProperties(ext, lines);
                break;
              case "SpecializedReifiedRelationships.json":
                tables.readSpecializedReifiedRelationships(ext, lines);
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
              default:
                String _name_1 = ze.getName();
                String _plus = ("OMLSpecificationTables.load(): unrecognized table name: " + _name_1);
                throw new IllegalArgumentException(_plus);
            }
          } else {
            String _name_1 = ze.getName();
            String _plus = ("OMLSpecificationTables.load(): unrecognized table name: " + _name_1);
            throw new IllegalArgumentException(_plus);
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      Collections.<ZipArchiveEntry>list(zip.getEntries()).forEach(_function);
      zip.close();
      Boolean more = Boolean.valueOf(false);
      do {
        {
          more = Boolean.valueOf(false);
          boolean _isEmpty = tables.iriLoadQueue.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            final String iri = tables.iriLoadQueue.remove();
            boolean _add = tables.visitedIRIs.add(iri);
            if (_add) {
              more = Boolean.valueOf(true);
              tables.loadOMLZipResource(rs, URI.createURI(iri));
            }
          }
          boolean _isEmpty_1 = tables.moduleQueue.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            final Module m = tables.moduleQueue.remove();
            boolean _add_1 = tables.visitedModules.add(m);
            if (_add_1) {
              more = Boolean.valueOf(true);
              tables.includeModule(m);
            }
          }
        }
      } while((more).booleanValue());
      tables.resolve(rs, r);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
        oml.setLength(OMLTables.toPositiveIntegerLiteral(kv.remove("length")));
        oml.setMinLength(OMLTables.toPositiveIntegerLiteral(kv.remove("minLength")));
        oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength")));
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
        oml.setLength(OMLTables.toPositiveIntegerLiteral(kv.remove("length")));
        oml.setMinLength(OMLTables.toPositiveIntegerLiteral(kv.remove("minLength")));
        oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength")));
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        oml.setPattern(OMLTables.toLiteralPattern(kv.remove("pattern")));
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
        oml.setMinExclusive(OMLTables.toLiteralNumber(kv.remove("minExclusive")));
        oml.setMinInclusive(OMLTables.toLiteralNumber(kv.remove("minInclusive")));
        oml.setMaxExclusive(OMLTables.toLiteralNumber(kv.remove("maxExclusive")));
        oml.setMaxInclusive(OMLTables.toLiteralNumber(kv.remove("maxInclusive")));
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
        oml.setLength(OMLTables.toPositiveIntegerLiteral(kv.remove("length")));
        oml.setMinLength(OMLTables.toPositiveIntegerLiteral(kv.remove("minLength")));
        oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength")));
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        oml.setLangRange(OMLTables.toLanguageTagDataType(kv.remove("langRange")));
        oml.setPattern(OMLTables.toLiteralPattern(kv.remove("pattern")));
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
        oml.setLength(OMLTables.toPositiveIntegerLiteral(kv.remove("length")));
        oml.setMinLength(OMLTables.toPositiveIntegerLiteral(kv.remove("minLength")));
        oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength")));
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        oml.setPattern(OMLTables.toLiteralPattern(kv.remove("pattern")));
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
        oml.setMinExclusive(OMLTables.toLiteralDateTime(kv.remove("minExclusive")));
        oml.setMinInclusive(OMLTables.toLiteralDateTime(kv.remove("minInclusive")));
        oml.setMaxExclusive(OMLTables.toLiteralDateTime(kv.remove("maxExclusive")));
        oml.setMaxInclusive(OMLTables.toLiteralDateTime(kv.remove("maxInclusive")));
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
  
  protected void readSpecializedReifiedRelationships(final Extent ext, final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    while ((!kvs.isEmpty())) {
      {
        int _size = kvs.size();
        int _minus = (_size - 1);
        final Map<String, String> kv = kvs.remove(_minus);
        final SpecializedReifiedRelationship oml = this.omlTerminologiesFactory.createSpecializedReifiedRelationship();
        final String uuid = kv.remove("uuid");
        oml.setName(OMLTables.toLocalName(kv.remove("name")));
        final Pair<SpecializedReifiedRelationship, Map<String, String>> pair = new Pair<SpecializedReifiedRelationship, Map<String, String>>(oml, kv);
        this.specializedReifiedRelationships.put(uuid, pair);
        this.includeSpecializedReifiedRelationships(uuid, oml);
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
  
  protected <U extends Object, V extends U> void includeMap(final Map<String, Pair<U, Map<String, String>>> uMap, final Map<String, Pair<V, Map<String, String>>> vMap) {
    final BiConsumer<String, Pair<V, Map<String, String>>> _function = (String uuid, Pair<V, Map<String, String>> kv) -> {
      V _key = kv.getKey();
      Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
      Pair<U, Map<String, String>> _pair = new Pair<U, Map<String, String>>(_key, _emptyMap);
      uMap.put(uuid, _pair);
    };
    vMap.forEach(_function);
  }
  
  protected void includeTerminologyGraphs(final String uuid, final TerminologyGraph oml) {
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<Module, Map<String, String>> _pair = new Pair<Module, Map<String, String>>(oml, _emptyMap);
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
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<Module, Map<String, String>> _pair = new Pair<Module, Map<String, String>>(oml, _emptyMap);
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
    Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
    Pair<Module, Map<String, String>> _pair = new Pair<Module, Map<String, String>>(oml, _emptyMap);
    this.modules.put(uuid, _pair);
    Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
    Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(oml, _emptyMap_1);
    this.logicalElements.put(uuid, _pair_1);
    String _iri = oml.iri();
    Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
    Pair<DescriptionBox, Map<String, String>> _pair_2 = new Pair<DescriptionBox, Map<String, String>>(oml, _emptyMap_2);
    this.descriptionBoxes.put(_iri, _pair_2);
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
  
  protected void includeSpecializedReifiedRelationships(final String uuid, final SpecializedReifiedRelationship oml) {
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
  
  protected void resolve(final ResourceSet rs, final OMLZipResource r) {
    this.<LogicalElement, TerminologyGraph>includeMap(this.logicalElements, this.terminologyGraphs);
    this.<LogicalElement, Bundle>includeMap(this.logicalElements, this.bundles);
    this.<LogicalElement, DescriptionBox>includeMap(this.logicalElements, this.descriptionBoxes);
    this.<LogicalElement, Aspect>includeMap(this.logicalElements, this.aspects);
    this.<LogicalElement, Concept>includeMap(this.logicalElements, this.concepts);
    this.<LogicalElement, Scalar>includeMap(this.logicalElements, this.scalars);
    this.<LogicalElement, Structure>includeMap(this.logicalElements, this.structures);
    this.<LogicalElement, ConceptDesignationTerminologyAxiom>includeMap(this.logicalElements, this.conceptDesignationTerminologyAxioms);
    this.<LogicalElement, TerminologyExtensionAxiom>includeMap(this.logicalElements, this.terminologyExtensionAxioms);
    this.<LogicalElement, TerminologyNestingAxiom>includeMap(this.logicalElements, this.terminologyNestingAxioms);
    this.<LogicalElement, BundledTerminologyAxiom>includeMap(this.logicalElements, this.bundledTerminologyAxioms);
    this.<LogicalElement, DescriptionBoxExtendsClosedWorldDefinitions>includeMap(this.logicalElements, this.descriptionBoxExtendsClosedWorldDefinitions);
    this.<LogicalElement, DescriptionBoxRefinement>includeMap(this.logicalElements, this.descriptionBoxRefinements);
    this.<LogicalElement, BinaryScalarRestriction>includeMap(this.logicalElements, this.binaryScalarRestrictions);
    this.<LogicalElement, IRIScalarRestriction>includeMap(this.logicalElements, this.iriScalarRestrictions);
    this.<LogicalElement, NumericScalarRestriction>includeMap(this.logicalElements, this.numericScalarRestrictions);
    this.<LogicalElement, PlainLiteralScalarRestriction>includeMap(this.logicalElements, this.plainLiteralScalarRestrictions);
    this.<LogicalElement, ScalarOneOfRestriction>includeMap(this.logicalElements, this.scalarOneOfRestrictions);
    this.<LogicalElement, ScalarOneOfLiteralAxiom>includeMap(this.logicalElements, this.scalarOneOfLiteralAxioms);
    this.<LogicalElement, StringScalarRestriction>includeMap(this.logicalElements, this.stringScalarRestrictions);
    this.<LogicalElement, SynonymScalarRestriction>includeMap(this.logicalElements, this.synonymScalarRestrictions);
    this.<LogicalElement, TimeScalarRestriction>includeMap(this.logicalElements, this.timeScalarRestrictions);
    this.<LogicalElement, EntityScalarDataProperty>includeMap(this.logicalElements, this.entityScalarDataProperties);
    this.<LogicalElement, EntityStructuredDataProperty>includeMap(this.logicalElements, this.entityStructuredDataProperties);
    this.<LogicalElement, ScalarDataProperty>includeMap(this.logicalElements, this.scalarDataProperties);
    this.<LogicalElement, StructuredDataProperty>includeMap(this.logicalElements, this.structuredDataProperties);
    this.<LogicalElement, ReifiedRelationship>includeMap(this.logicalElements, this.reifiedRelationships);
    this.<LogicalElement, ForwardProperty>includeMap(this.logicalElements, this.forwardProperties);
    this.<LogicalElement, InverseProperty>includeMap(this.logicalElements, this.inverseProperties);
    this.<LogicalElement, SpecializedReifiedRelationship>includeMap(this.logicalElements, this.specializedReifiedRelationships);
    this.<LogicalElement, UnreifiedRelationship>includeMap(this.logicalElements, this.unreifiedRelationships);
    this.<LogicalElement, ChainRule>includeMap(this.logicalElements, this.chainRules);
    this.<LogicalElement, RuleBodySegment>includeMap(this.logicalElements, this.ruleBodySegments);
    this.<LogicalElement, SegmentPredicate>includeMap(this.logicalElements, this.segmentPredicates);
    this.<LogicalElement, EntityExistentialRestrictionAxiom>includeMap(this.logicalElements, this.entityExistentialRestrictionAxioms);
    this.<LogicalElement, EntityUniversalRestrictionAxiom>includeMap(this.logicalElements, this.entityUniversalRestrictionAxioms);
    this.<LogicalElement, EntityScalarDataPropertyExistentialRestrictionAxiom>includeMap(this.logicalElements, this.entityScalarDataPropertyExistentialRestrictionAxioms);
    this.<LogicalElement, EntityScalarDataPropertyParticularRestrictionAxiom>includeMap(this.logicalElements, this.entityScalarDataPropertyParticularRestrictionAxioms);
    this.<LogicalElement, EntityScalarDataPropertyUniversalRestrictionAxiom>includeMap(this.logicalElements, this.entityScalarDataPropertyUniversalRestrictionAxioms);
    this.<LogicalElement, EntityStructuredDataPropertyParticularRestrictionAxiom>includeMap(this.logicalElements, this.entityStructuredDataPropertyParticularRestrictionAxioms);
    this.<LogicalElement, RestrictionStructuredDataPropertyTuple>includeMap(this.logicalElements, this.restrictionStructuredDataPropertyTuples);
    this.<LogicalElement, RestrictionScalarDataPropertyValue>includeMap(this.logicalElements, this.restrictionScalarDataPropertyValues);
    this.<LogicalElement, AspectSpecializationAxiom>includeMap(this.logicalElements, this.aspectSpecializationAxioms);
    this.<LogicalElement, ConceptSpecializationAxiom>includeMap(this.logicalElements, this.conceptSpecializationAxioms);
    this.<LogicalElement, SubDataPropertyOfAxiom>includeMap(this.logicalElements, this.subDataPropertyOfAxioms);
    this.<LogicalElement, SubObjectPropertyOfAxiom>includeMap(this.logicalElements, this.subObjectPropertyOfAxioms);
    this.<LogicalElement, RootConceptTaxonomyAxiom>includeMap(this.logicalElements, this.rootConceptTaxonomyAxioms);
    this.<LogicalElement, AnonymousConceptUnionAxiom>includeMap(this.logicalElements, this.anonymousConceptUnionAxioms);
    this.<LogicalElement, SpecificDisjointConceptAxiom>includeMap(this.logicalElements, this.specificDisjointConceptAxioms);
    this.<LogicalElement, ConceptInstance>includeMap(this.logicalElements, this.conceptInstances);
    this.<LogicalElement, ReifiedRelationshipInstance>includeMap(this.logicalElements, this.reifiedRelationshipInstances);
    this.<LogicalElement, ReifiedRelationshipInstanceDomain>includeMap(this.logicalElements, this.reifiedRelationshipInstanceDomains);
    this.<LogicalElement, ReifiedRelationshipInstanceRange>includeMap(this.logicalElements, this.reifiedRelationshipInstanceRanges);
    this.<LogicalElement, UnreifiedRelationshipInstanceTuple>includeMap(this.logicalElements, this.unreifiedRelationshipInstanceTuples);
    this.<LogicalElement, SingletonInstanceStructuredDataPropertyValue>includeMap(this.logicalElements, this.singletonInstanceStructuredDataPropertyValues);
    this.<LogicalElement, SingletonInstanceScalarDataPropertyValue>includeMap(this.logicalElements, this.singletonInstanceScalarDataPropertyValues);
    this.<LogicalElement, StructuredDataPropertyTuple>includeMap(this.logicalElements, this.structuredDataPropertyTuples);
    this.<LogicalElement, ScalarDataPropertyValue>includeMap(this.logicalElements, this.scalarDataPropertyValues);
    this.<Entity, Aspect>includeMap(this.entities, this.aspects);
    this.<Entity, Concept>includeMap(this.entities, this.concepts);
    this.<Entity, ReifiedRelationship>includeMap(this.entities, this.reifiedRelationships);
    this.<Entity, SpecializedReifiedRelationship>includeMap(this.entities, this.specializedReifiedRelationships);
    this.<EntityRelationship, ReifiedRelationship>includeMap(this.entityRelationships, this.reifiedRelationships);
    this.<EntityRelationship, SpecializedReifiedRelationship>includeMap(this.entityRelationships, this.specializedReifiedRelationships);
    this.<EntityRelationship, UnreifiedRelationship>includeMap(this.entityRelationships, this.unreifiedRelationships);
    this.<ConceptualRelationship, ReifiedRelationship>includeMap(this.conceptualRelationships, this.reifiedRelationships);
    this.<ConceptualRelationship, SpecializedReifiedRelationship>includeMap(this.conceptualRelationships, this.specializedReifiedRelationships);
    this.<DataRange, Scalar>includeMap(this.dataRanges, this.scalars);
    this.<DataRange, BinaryScalarRestriction>includeMap(this.dataRanges, this.binaryScalarRestrictions);
    this.<DataRange, IRIScalarRestriction>includeMap(this.dataRanges, this.iriScalarRestrictions);
    this.<DataRange, NumericScalarRestriction>includeMap(this.dataRanges, this.numericScalarRestrictions);
    this.<DataRange, PlainLiteralScalarRestriction>includeMap(this.dataRanges, this.plainLiteralScalarRestrictions);
    this.<DataRange, ScalarOneOfRestriction>includeMap(this.dataRanges, this.scalarOneOfRestrictions);
    this.<DataRange, StringScalarRestriction>includeMap(this.dataRanges, this.stringScalarRestrictions);
    this.<DataRange, SynonymScalarRestriction>includeMap(this.dataRanges, this.synonymScalarRestrictions);
    this.<DataRange, TimeScalarRestriction>includeMap(this.dataRanges, this.timeScalarRestrictions);
    this.<DataRelationshipToScalar, EntityScalarDataProperty>includeMap(this.dataRelationshipToScalars, this.entityScalarDataProperties);
    this.<DataRelationshipToScalar, ScalarDataProperty>includeMap(this.dataRelationshipToScalars, this.scalarDataProperties);
    this.<DataRelationshipToStructure, EntityStructuredDataProperty>includeMap(this.dataRelationshipToStructures, this.entityStructuredDataProperties);
    this.<DataRelationshipToStructure, StructuredDataProperty>includeMap(this.dataRelationshipToStructures, this.structuredDataProperties);
    this.<Predicate, Aspect>includeMap(this.predicates, this.aspects);
    this.<Predicate, Concept>includeMap(this.predicates, this.concepts);
    this.<Predicate, ReifiedRelationship>includeMap(this.predicates, this.reifiedRelationships);
    this.<Predicate, ForwardProperty>includeMap(this.predicates, this.forwardProperties);
    this.<Predicate, InverseProperty>includeMap(this.predicates, this.inverseProperties);
    this.<Predicate, SpecializedReifiedRelationship>includeMap(this.predicates, this.specializedReifiedRelationships);
    this.<Predicate, UnreifiedRelationship>includeMap(this.predicates, this.unreifiedRelationships);
    this.<RestrictableRelationship, ForwardProperty>includeMap(this.restrictableRelationships, this.forwardProperties);
    this.<RestrictableRelationship, InverseProperty>includeMap(this.restrictableRelationships, this.inverseProperties);
    this.<RestrictableRelationship, UnreifiedRelationship>includeMap(this.restrictableRelationships, this.unreifiedRelationships);
    this.<RestrictionStructuredDataPropertyContext, EntityStructuredDataPropertyParticularRestrictionAxiom>includeMap(this.restrictionStructuredDataPropertyContexts, this.entityStructuredDataPropertyParticularRestrictionAxioms);
    this.<RestrictionStructuredDataPropertyContext, RestrictionStructuredDataPropertyTuple>includeMap(this.restrictionStructuredDataPropertyContexts, this.restrictionStructuredDataPropertyTuples);
    this.<TerminologyBox, TerminologyGraph>includeMap(this.terminologyBoxes, this.terminologyGraphs);
    this.<TerminologyBox, Bundle>includeMap(this.terminologyBoxes, this.bundles);
    this.<ConceptTreeDisjunction, RootConceptTaxonomyAxiom>includeMap(this.conceptTreeDisjunctions, this.rootConceptTaxonomyAxioms);
    this.<ConceptTreeDisjunction, AnonymousConceptUnionAxiom>includeMap(this.conceptTreeDisjunctions, this.anonymousConceptUnionAxioms);
    this.<ConceptualEntitySingletonInstance, ConceptInstance>includeMap(this.conceptualEntitySingletonInstances, this.conceptInstances);
    this.<ConceptualEntitySingletonInstance, ReifiedRelationshipInstance>includeMap(this.conceptualEntitySingletonInstances, this.reifiedRelationshipInstances);
    this.<SingletonInstanceStructuredDataPropertyContext, SingletonInstanceStructuredDataPropertyValue>includeMap(this.singletonInstanceStructuredDataPropertyContexts, this.singletonInstanceStructuredDataPropertyValues);
    this.<SingletonInstanceStructuredDataPropertyContext, StructuredDataPropertyTuple>includeMap(this.singletonInstanceStructuredDataPropertyContexts, this.structuredDataPropertyTuples);
    this.resolveAnnotationProperties(rs);
    this.resolveAspects(rs);
    this.resolveConcepts(rs);
    this.resolveScalars(rs);
    this.resolveStructures(rs);
    this.resolveConceptDesignationTerminologyAxioms(rs);
    this.resolveTerminologyExtensionAxioms(rs);
    this.resolveTerminologyNestingAxioms(rs);
    this.resolveBundledTerminologyAxioms(rs);
    this.resolveDescriptionBoxExtendsClosedWorldDefinitions(rs);
    this.resolveDescriptionBoxRefinements(rs);
    this.resolveBinaryScalarRestrictions(rs);
    this.resolveIRIScalarRestrictions(rs);
    this.resolveNumericScalarRestrictions(rs);
    this.resolvePlainLiteralScalarRestrictions(rs);
    this.resolveScalarOneOfRestrictions(rs);
    this.resolveScalarOneOfLiteralAxioms(rs);
    this.resolveStringScalarRestrictions(rs);
    this.resolveSynonymScalarRestrictions(rs);
    this.resolveTimeScalarRestrictions(rs);
    this.resolveEntityScalarDataProperties(rs);
    this.resolveEntityStructuredDataProperties(rs);
    this.resolveScalarDataProperties(rs);
    this.resolveStructuredDataProperties(rs);
    this.resolveReifiedRelationships(rs);
    this.resolveForwardProperties(rs);
    this.resolveInverseProperties(rs);
    this.resolveSpecializedReifiedRelationships(rs);
    this.resolveUnreifiedRelationships(rs);
    this.resolveChainRules(rs);
    this.resolveRuleBodySegments(rs);
    this.resolveSegmentPredicates(rs);
    this.resolveEntityExistentialRestrictionAxioms(rs);
    this.resolveEntityUniversalRestrictionAxioms(rs);
    this.resolveEntityScalarDataPropertyExistentialRestrictionAxioms(rs);
    this.resolveEntityScalarDataPropertyParticularRestrictionAxioms(rs);
    this.resolveEntityScalarDataPropertyUniversalRestrictionAxioms(rs);
    this.resolveEntityStructuredDataPropertyParticularRestrictionAxioms(rs);
    this.resolveRestrictionStructuredDataPropertyTuples(rs);
    this.resolveRestrictionScalarDataPropertyValues(rs);
    this.resolveAspectSpecializationAxioms(rs);
    this.resolveConceptSpecializationAxioms(rs);
    this.resolveSubDataPropertyOfAxioms(rs);
    this.resolveSubObjectPropertyOfAxioms(rs);
    this.resolveRootConceptTaxonomyAxioms(rs);
    this.resolveAnonymousConceptUnionAxioms(rs);
    this.resolveSpecificDisjointConceptAxioms(rs);
    this.resolveConceptInstances(rs);
    this.resolveReifiedRelationshipInstances(rs);
    this.resolveReifiedRelationshipInstanceDomains(rs);
    this.resolveReifiedRelationshipInstanceRanges(rs);
    this.resolveUnreifiedRelationshipInstanceTuples(rs);
    this.resolveSingletonInstanceStructuredDataPropertyValues(rs);
    this.resolveSingletonInstanceScalarDataPropertyValues(rs);
    this.resolveStructuredDataPropertyTuples(rs);
    this.resolveScalarDataPropertyValues(rs);
    this.resolveAnnotationPropertyValues(rs);
  }
  
  protected void resolveAnnotationProperties(final ResourceSet rs) {
    final BiConsumer<String, Pair<AnnotationProperty, Map<String, String>>> _function = (String uuid, Pair<AnnotationProperty, Map<String, String>> oml_kv) -> {
      final AnnotationProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String moduleXRef = kv.remove("moduleUUID");
        final Pair<Module, Map<String, String>> modulePair = this.modules.get(moduleXRef);
        if ((null == modulePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for module in annotationProperties: " + moduleXRef));
        }
        oml.setModule(modulePair.getKey());
      }
    };
    this.annotationProperties.forEach(_function);
  }
  
  protected void resolveAspects(final ResourceSet rs) {
    final BiConsumer<String, Pair<Aspect, Map<String, String>>> _function = (String uuid, Pair<Aspect, Map<String, String>> oml_kv) -> {
      final Aspect oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in aspects: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
      }
    };
    this.aspects.forEach(_function);
  }
  
  protected void resolveConcepts(final ResourceSet rs) {
    final BiConsumer<String, Pair<Concept, Map<String, String>>> _function = (String uuid, Pair<Concept, Map<String, String>> oml_kv) -> {
      final Concept oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in concepts: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
      }
    };
    this.concepts.forEach(_function);
  }
  
  protected void resolveScalars(final ResourceSet rs) {
    final BiConsumer<String, Pair<Scalar, Map<String, String>>> _function = (String uuid, Pair<Scalar, Map<String, String>> oml_kv) -> {
      final Scalar oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in scalars: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
      }
    };
    this.scalars.forEach(_function);
  }
  
  protected void resolveStructures(final ResourceSet rs) {
    final BiConsumer<String, Pair<Structure, Map<String, String>>> _function = (String uuid, Pair<Structure, Map<String, String>> oml_kv) -> {
      final Structure oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in structures: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
      }
    };
    this.structures.forEach(_function);
  }
  
  protected void resolveConceptDesignationTerminologyAxioms(final ResourceSet rs) {
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
              final String tboxXRef = kv.remove("tboxUUID");
              final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
              if ((null == tboxPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for tbox in conceptDesignationTerminologyAxioms: " + tboxXRef));
              }
              oml.setTbox(tboxPair.getKey());
              final String designatedConceptXRef = kv.remove("designatedConceptUUID");
              final Pair<Concept, Map<String, String>> designatedConceptPair = this.concepts.get(designatedConceptXRef);
              if ((null == designatedConceptPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for designatedConcept in conceptDesignationTerminologyAxioms: " + designatedConceptXRef));
              }
              oml.setDesignatedConcept(designatedConceptPair.getKey());
              final String designatedTerminologyIRI = kv.remove("designatedTerminologyIRI");
              final Pair<TerminologyBox, Map<String, String>> designatedTerminologyPair = this.terminologyBoxes.get(designatedTerminologyIRI);
              if ((null == designatedTerminologyPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for designatedTerminology in conceptDesignationTerminologyAxioms: " + designatedTerminologyIRI));
              }
              oml.setDesignatedTerminology(designatedTerminologyPair.getKey());
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while(more);
  }
  
  protected void resolveTerminologyExtensionAxioms(final ResourceSet rs) {
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
              final String tboxXRef = kv.remove("tboxUUID");
              final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
              if ((null == tboxPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for tbox in terminologyExtensionAxioms: " + tboxXRef));
              }
              oml.setTbox(tboxPair.getKey());
              final String extendedTerminologyIRI = kv.remove("extendedTerminologyIRI");
              final Pair<TerminologyBox, Map<String, String>> extendedTerminologyPair = this.terminologyBoxes.get(extendedTerminologyIRI);
              if ((null == extendedTerminologyPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for extendedTerminology in terminologyExtensionAxioms: " + extendedTerminologyIRI));
              }
              oml.setExtendedTerminology(extendedTerminologyPair.getKey());
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while(more);
  }
  
  protected void resolveTerminologyNestingAxioms(final ResourceSet rs) {
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
              final String tboxXRef = kv.remove("tboxUUID");
              final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
              if ((null == tboxPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for tbox in terminologyNestingAxioms: " + tboxXRef));
              }
              oml.setTbox(tboxPair.getKey());
              final String nestingContextXRef = kv.remove("nestingContextUUID");
              final Pair<Concept, Map<String, String>> nestingContextPair = this.concepts.get(nestingContextXRef);
              if ((null == nestingContextPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for nestingContext in terminologyNestingAxioms: " + nestingContextXRef));
              }
              oml.setNestingContext(nestingContextPair.getKey());
              final String nestingTerminologyIRI = kv.remove("nestingTerminologyIRI");
              final Pair<TerminologyBox, Map<String, String>> nestingTerminologyPair = this.terminologyBoxes.get(nestingTerminologyIRI);
              if ((null == nestingTerminologyPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for nestingTerminology in terminologyNestingAxioms: " + nestingTerminologyIRI));
              }
              oml.setNestingTerminology(nestingTerminologyPair.getKey());
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while(more);
  }
  
  protected void resolveBundledTerminologyAxioms(final ResourceSet rs) {
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
              final String bundleXRef = kv.remove("bundleUUID");
              final Pair<Bundle, Map<String, String>> bundlePair = this.bundles.get(bundleXRef);
              if ((null == bundlePair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for bundle in bundledTerminologyAxioms: " + bundleXRef));
              }
              oml.setBundle(bundlePair.getKey());
              final String bundledTerminologyIRI = kv.remove("bundledTerminologyIRI");
              final Pair<TerminologyBox, Map<String, String>> bundledTerminologyPair = this.terminologyBoxes.get(bundledTerminologyIRI);
              if ((null == bundledTerminologyPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for bundledTerminology in bundledTerminologyAxioms: " + bundledTerminologyIRI));
              }
              oml.setBundledTerminology(bundledTerminologyPair.getKey());
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while(more);
  }
  
  protected void resolveDescriptionBoxExtendsClosedWorldDefinitions(final ResourceSet rs) {
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
              final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
              final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
              if ((null == descriptionBoxPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for descriptionBox in descriptionBoxExtendsClosedWorldDefinitions: " + descriptionBoxXRef));
              }
              oml.setDescriptionBox(descriptionBoxPair.getKey());
              final String closedWorldDefinitionsIRI = kv.remove("closedWorldDefinitionsIRI");
              final Pair<TerminologyBox, Map<String, String>> closedWorldDefinitionsPair = this.terminologyBoxes.get(closedWorldDefinitionsIRI);
              if ((null == closedWorldDefinitionsPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for closedWorldDefinitions in descriptionBoxExtendsClosedWorldDefinitions: " + closedWorldDefinitionsIRI));
              }
              oml.setClosedWorldDefinitions(closedWorldDefinitionsPair.getKey());
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while(more);
  }
  
  protected void resolveDescriptionBoxRefinements(final ResourceSet rs) {
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
              final String refiningDescriptionBoxXRef = kv.remove("refiningDescriptionBoxUUID");
              final Pair<DescriptionBox, Map<String, String>> refiningDescriptionBoxPair = this.descriptionBoxes.get(refiningDescriptionBoxXRef);
              if ((null == refiningDescriptionBoxPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for refiningDescriptionBox in descriptionBoxRefinements: " + refiningDescriptionBoxXRef));
              }
              oml.setRefiningDescriptionBox(refiningDescriptionBoxPair.getKey());
              final String refinedDescriptionBoxIRI = kv.remove("refinedDescriptionBoxIRI");
              final Pair<DescriptionBox, Map<String, String>> refinedDescriptionBoxPair = this.descriptionBoxes.get(refinedDescriptionBoxIRI);
              if ((null == refinedDescriptionBoxPair)) {
                throw new IllegalArgumentException(("Null cross-reference lookup for refinedDescriptionBox in descriptionBoxRefinements: " + refinedDescriptionBoxIRI));
              }
              oml.setRefinedDescriptionBox(refinedDescriptionBoxPair.getKey());
            }
          };
          queue.forEach(_function_2);
        }
      }
    } while(more);
  }
  
  protected void resolveBinaryScalarRestrictions(final ResourceSet rs) {
    final BiConsumer<String, Pair<BinaryScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<BinaryScalarRestriction, Map<String, String>> oml_kv) -> {
      final BinaryScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in binaryScalarRestrictions: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in binaryScalarRestrictions: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.binaryScalarRestrictions.forEach(_function);
  }
  
  protected void resolveIRIScalarRestrictions(final ResourceSet rs) {
    final BiConsumer<String, Pair<IRIScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<IRIScalarRestriction, Map<String, String>> oml_kv) -> {
      final IRIScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in iriScalarRestrictions: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in iriScalarRestrictions: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.iriScalarRestrictions.forEach(_function);
  }
  
  protected void resolveNumericScalarRestrictions(final ResourceSet rs) {
    final BiConsumer<String, Pair<NumericScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<NumericScalarRestriction, Map<String, String>> oml_kv) -> {
      final NumericScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in numericScalarRestrictions: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in numericScalarRestrictions: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.numericScalarRestrictions.forEach(_function);
  }
  
  protected void resolvePlainLiteralScalarRestrictions(final ResourceSet rs) {
    final BiConsumer<String, Pair<PlainLiteralScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<PlainLiteralScalarRestriction, Map<String, String>> oml_kv) -> {
      final PlainLiteralScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in plainLiteralScalarRestrictions: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in plainLiteralScalarRestrictions: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.plainLiteralScalarRestrictions.forEach(_function);
  }
  
  protected void resolveScalarOneOfRestrictions(final ResourceSet rs) {
    final BiConsumer<String, Pair<ScalarOneOfRestriction, Map<String, String>>> _function = (String uuid, Pair<ScalarOneOfRestriction, Map<String, String>> oml_kv) -> {
      final ScalarOneOfRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in scalarOneOfRestrictions: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in scalarOneOfRestrictions: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.scalarOneOfRestrictions.forEach(_function);
  }
  
  protected void resolveScalarOneOfLiteralAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<ScalarOneOfLiteralAxiom, Map<String, String>>> _function = (String uuid, Pair<ScalarOneOfLiteralAxiom, Map<String, String>> oml_kv) -> {
      final ScalarOneOfLiteralAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in scalarOneOfLiteralAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String axiomXRef = kv.remove("axiomUUID");
        final Pair<ScalarOneOfRestriction, Map<String, String>> axiomPair = this.scalarOneOfRestrictions.get(axiomXRef);
        if ((null == axiomPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for axiom in scalarOneOfLiteralAxioms: " + axiomXRef));
        }
        oml.setAxiom(axiomPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for valueType in scalarOneOfLiteralAxioms: " + valueTypeXRef));
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.scalarOneOfLiteralAxioms.forEach(_function);
  }
  
  protected void resolveStringScalarRestrictions(final ResourceSet rs) {
    final BiConsumer<String, Pair<StringScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<StringScalarRestriction, Map<String, String>> oml_kv) -> {
      final StringScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in stringScalarRestrictions: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in stringScalarRestrictions: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.stringScalarRestrictions.forEach(_function);
  }
  
  protected void resolveSynonymScalarRestrictions(final ResourceSet rs) {
    final BiConsumer<String, Pair<SynonymScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<SynonymScalarRestriction, Map<String, String>> oml_kv) -> {
      final SynonymScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in synonymScalarRestrictions: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in synonymScalarRestrictions: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.synonymScalarRestrictions.forEach(_function);
  }
  
  protected void resolveTimeScalarRestrictions(final ResourceSet rs) {
    final BiConsumer<String, Pair<TimeScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<TimeScalarRestriction, Map<String, String>> oml_kv) -> {
      final TimeScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in timeScalarRestrictions: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in timeScalarRestrictions: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.timeScalarRestrictions.forEach(_function);
  }
  
  protected void resolveEntityScalarDataProperties(final ResourceSet rs) {
    final BiConsumer<String, Pair<EntityScalarDataProperty, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataProperty, Map<String, String>> oml_kv) -> {
      final EntityScalarDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in entityScalarDataProperties: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<Entity, Map<String, String>> domainPair = this.entities.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for domain in entityScalarDataProperties: " + domainXRef));
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<DataRange, Map<String, String>> rangePair = this.dataRanges.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for range in entityScalarDataProperties: " + rangeXRef));
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.entityScalarDataProperties.forEach(_function);
  }
  
  protected void resolveEntityStructuredDataProperties(final ResourceSet rs) {
    final BiConsumer<String, Pair<EntityStructuredDataProperty, Map<String, String>>> _function = (String uuid, Pair<EntityStructuredDataProperty, Map<String, String>> oml_kv) -> {
      final EntityStructuredDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in entityStructuredDataProperties: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<Entity, Map<String, String>> domainPair = this.entities.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for domain in entityStructuredDataProperties: " + domainXRef));
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<Structure, Map<String, String>> rangePair = this.structures.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for range in entityStructuredDataProperties: " + rangeXRef));
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.entityStructuredDataProperties.forEach(_function);
  }
  
  protected void resolveScalarDataProperties(final ResourceSet rs) {
    final BiConsumer<String, Pair<ScalarDataProperty, Map<String, String>>> _function = (String uuid, Pair<ScalarDataProperty, Map<String, String>> oml_kv) -> {
      final ScalarDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in scalarDataProperties: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<Structure, Map<String, String>> domainPair = this.structures.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for domain in scalarDataProperties: " + domainXRef));
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<DataRange, Map<String, String>> rangePair = this.dataRanges.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for range in scalarDataProperties: " + rangeXRef));
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.scalarDataProperties.forEach(_function);
  }
  
  protected void resolveStructuredDataProperties(final ResourceSet rs) {
    final BiConsumer<String, Pair<StructuredDataProperty, Map<String, String>>> _function = (String uuid, Pair<StructuredDataProperty, Map<String, String>> oml_kv) -> {
      final StructuredDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in structuredDataProperties: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<Structure, Map<String, String>> domainPair = this.structures.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for domain in structuredDataProperties: " + domainXRef));
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<Structure, Map<String, String>> rangePair = this.structures.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for range in structuredDataProperties: " + rangeXRef));
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.structuredDataProperties.forEach(_function);
  }
  
  protected void resolveReifiedRelationships(final ResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationship, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationship, Map<String, String>> oml_kv) -> {
      final ReifiedRelationship oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in reifiedRelationships: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String sourceXRef = kv.remove("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null == sourcePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for source in reifiedRelationships: " + sourceXRef));
        }
        oml.setSource(sourcePair.getKey());
        final String targetXRef = kv.remove("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null == targetPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for target in reifiedRelationships: " + targetXRef));
        }
        oml.setTarget(targetPair.getKey());
      }
    };
    this.reifiedRelationships.forEach(_function);
  }
  
  protected void resolveForwardProperties(final ResourceSet rs) {
    final BiConsumer<String, Pair<ForwardProperty, Map<String, String>>> _function = (String uuid, Pair<ForwardProperty, Map<String, String>> oml_kv) -> {
      final ForwardProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for reifiedRelationship in forwardProperties: " + reifiedRelationshipXRef));
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.forwardProperties.forEach(_function);
  }
  
  protected void resolveInverseProperties(final ResourceSet rs) {
    final BiConsumer<String, Pair<InverseProperty, Map<String, String>>> _function = (String uuid, Pair<InverseProperty, Map<String, String>> oml_kv) -> {
      final InverseProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for reifiedRelationship in inverseProperties: " + reifiedRelationshipXRef));
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.inverseProperties.forEach(_function);
  }
  
  protected void resolveSpecializedReifiedRelationships(final ResourceSet rs) {
    final BiConsumer<String, Pair<SpecializedReifiedRelationship, Map<String, String>>> _function = (String uuid, Pair<SpecializedReifiedRelationship, Map<String, String>> oml_kv) -> {
      final SpecializedReifiedRelationship oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in specializedReifiedRelationships: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String sourceXRef = kv.remove("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null == sourcePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for source in specializedReifiedRelationships: " + sourceXRef));
        }
        oml.setSource(sourcePair.getKey());
        final String targetXRef = kv.remove("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null == targetPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for target in specializedReifiedRelationships: " + targetXRef));
        }
        oml.setTarget(targetPair.getKey());
        final String generalXRef = kv.remove("generalUUID");
        final Pair<ConceptualRelationship, Map<String, String>> generalPair = this.conceptualRelationships.get(generalXRef);
        if ((null == generalPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for general in specializedReifiedRelationships: " + generalXRef));
        }
        oml.setGeneral(generalPair.getKey());
      }
    };
    this.specializedReifiedRelationships.forEach(_function);
  }
  
  protected void resolveUnreifiedRelationships(final ResourceSet rs) {
    final BiConsumer<String, Pair<UnreifiedRelationship, Map<String, String>>> _function = (String uuid, Pair<UnreifiedRelationship, Map<String, String>> oml_kv) -> {
      final UnreifiedRelationship oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in unreifiedRelationships: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String sourceXRef = kv.remove("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null == sourcePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for source in unreifiedRelationships: " + sourceXRef));
        }
        oml.setSource(sourcePair.getKey());
        final String targetXRef = kv.remove("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null == targetPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for target in unreifiedRelationships: " + targetXRef));
        }
        oml.setTarget(targetPair.getKey());
      }
    };
    this.unreifiedRelationships.forEach(_function);
  }
  
  protected void resolveChainRules(final ResourceSet rs) {
    final BiConsumer<String, Pair<ChainRule, Map<String, String>>> _function = (String uuid, Pair<ChainRule, Map<String, String>> oml_kv) -> {
      final ChainRule oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in chainRules: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String headXRef = kv.remove("headUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> headPair = this.unreifiedRelationships.get(headXRef);
        if ((null == headPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for head in chainRules: " + headXRef));
        }
        oml.setHead(headPair.getKey());
      }
    };
    this.chainRules.forEach(_function);
  }
  
  protected void resolveRuleBodySegments(final ResourceSet rs) {
    final BiConsumer<String, Pair<RuleBodySegment, Map<String, String>>> _function = (String uuid, Pair<RuleBodySegment, Map<String, String>> oml_kv) -> {
      final RuleBodySegment oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String previousSegmentXRef = kv.remove("previousSegmentUUID");
        boolean _notEquals = (!Objects.equal("null", previousSegmentXRef));
        if (_notEquals) {
          final Pair<RuleBodySegment, Map<String, String>> previousSegmentPair = this.ruleBodySegments.get(previousSegmentXRef);
          if ((null == previousSegmentPair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for previousSegment in ruleBodySegments: " + previousSegmentXRef));
          }
          oml.setPreviousSegment(previousSegmentPair.getKey());
        }
        final String ruleXRef = kv.remove("ruleUUID");
        boolean _notEquals_1 = (!Objects.equal("null", ruleXRef));
        if (_notEquals_1) {
          final Pair<ChainRule, Map<String, String>> rulePair = this.chainRules.get(ruleXRef);
          if ((null == rulePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for rule in ruleBodySegments: " + ruleXRef));
          }
          oml.setRule(rulePair.getKey());
        }
      }
    };
    this.ruleBodySegments.forEach(_function);
  }
  
  protected void resolveSegmentPredicates(final ResourceSet rs) {
    final BiConsumer<String, Pair<SegmentPredicate, Map<String, String>>> _function = (String uuid, Pair<SegmentPredicate, Map<String, String>> oml_kv) -> {
      final SegmentPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for bodySegment in segmentPredicates: " + bodySegmentXRef));
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String predicateXRef = kv.remove("predicateUUID");
        boolean _notEquals = (!Objects.equal("null", predicateXRef));
        if (_notEquals) {
          final Pair<Predicate, Map<String, String>> predicatePair = this.predicates.get(predicateXRef);
          if ((null == predicatePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for predicate in segmentPredicates: " + predicateXRef));
          }
          oml.setPredicate(predicatePair.getKey());
        }
        final String reifiedRelationshipSourceXRef = kv.remove("reifiedRelationshipSourceUUID");
        boolean _notEquals_1 = (!Objects.equal("null", reifiedRelationshipSourceXRef));
        if (_notEquals_1) {
          final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipSourcePair = this.reifiedRelationships.get(reifiedRelationshipSourceXRef);
          if ((null == reifiedRelationshipSourcePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for reifiedRelationshipSource in segmentPredicates: " + reifiedRelationshipSourceXRef));
          }
          oml.setReifiedRelationshipSource(reifiedRelationshipSourcePair.getKey());
        }
        final String reifiedRelationshipInverseSourceXRef = kv.remove("reifiedRelationshipInverseSourceUUID");
        boolean _notEquals_2 = (!Objects.equal("null", reifiedRelationshipInverseSourceXRef));
        if (_notEquals_2) {
          final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipInverseSourcePair = this.reifiedRelationships.get(reifiedRelationshipInverseSourceXRef);
          if ((null == reifiedRelationshipInverseSourcePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for reifiedRelationshipInverseSource in segmentPredicates: " + reifiedRelationshipInverseSourceXRef));
          }
          oml.setReifiedRelationshipInverseSource(reifiedRelationshipInverseSourcePair.getKey());
        }
        final String reifiedRelationshipTargetXRef = kv.remove("reifiedRelationshipTargetUUID");
        boolean _notEquals_3 = (!Objects.equal("null", reifiedRelationshipTargetXRef));
        if (_notEquals_3) {
          final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipTargetPair = this.reifiedRelationships.get(reifiedRelationshipTargetXRef);
          if ((null == reifiedRelationshipTargetPair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for reifiedRelationshipTarget in segmentPredicates: " + reifiedRelationshipTargetXRef));
          }
          oml.setReifiedRelationshipTarget(reifiedRelationshipTargetPair.getKey());
        }
        final String reifiedRelationshipInverseTargetXRef = kv.remove("reifiedRelationshipInverseTargetUUID");
        boolean _notEquals_4 = (!Objects.equal("null", reifiedRelationshipInverseTargetXRef));
        if (_notEquals_4) {
          final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipInverseTargetPair = this.reifiedRelationships.get(reifiedRelationshipInverseTargetXRef);
          if ((null == reifiedRelationshipInverseTargetPair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for reifiedRelationshipInverseTarget in segmentPredicates: " + reifiedRelationshipInverseTargetXRef));
          }
          oml.setReifiedRelationshipInverseTarget(reifiedRelationshipInverseTargetPair.getKey());
        }
        final String unreifiedRelationshipInverseXRef = kv.remove("unreifiedRelationshipInverseUUID");
        boolean _notEquals_5 = (!Objects.equal("null", unreifiedRelationshipInverseXRef));
        if (_notEquals_5) {
          final Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipInversePair = this.unreifiedRelationships.get(unreifiedRelationshipInverseXRef);
          if ((null == unreifiedRelationshipInversePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for unreifiedRelationshipInverse in segmentPredicates: " + unreifiedRelationshipInverseXRef));
          }
          oml.setUnreifiedRelationshipInverse(unreifiedRelationshipInversePair.getKey());
        }
      }
    };
    this.segmentPredicates.forEach(_function);
  }
  
  protected void resolveEntityExistentialRestrictionAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityExistentialRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityExistentialRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in entityExistentialRestrictionAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedDomainXRef = kv.remove("restrictedDomainUUID");
        final Pair<Entity, Map<String, String>> restrictedDomainPair = this.entities.get(restrictedDomainXRef);
        if ((null == restrictedDomainPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedDomain in entityExistentialRestrictionAxioms: " + restrictedDomainXRef));
        }
        oml.setRestrictedDomain(restrictedDomainPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in entityExistentialRestrictionAxioms: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
        final String restrictedRelationshipXRef = kv.remove("restrictedRelationshipUUID");
        final Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = this.restrictableRelationships.get(restrictedRelationshipXRef);
        if ((null == restrictedRelationshipPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRelationship in entityExistentialRestrictionAxioms: " + restrictedRelationshipXRef));
        }
        oml.setRestrictedRelationship(restrictedRelationshipPair.getKey());
      }
    };
    this.entityExistentialRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityUniversalRestrictionAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityUniversalRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityUniversalRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in entityUniversalRestrictionAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedDomainXRef = kv.remove("restrictedDomainUUID");
        final Pair<Entity, Map<String, String>> restrictedDomainPair = this.entities.get(restrictedDomainXRef);
        if ((null == restrictedDomainPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedDomain in entityUniversalRestrictionAxioms: " + restrictedDomainXRef));
        }
        oml.setRestrictedDomain(restrictedDomainPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRange in entityUniversalRestrictionAxioms: " + restrictedRangeXRef));
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
        final String restrictedRelationshipXRef = kv.remove("restrictedRelationshipUUID");
        final Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = this.restrictableRelationships.get(restrictedRelationshipXRef);
        if ((null == restrictedRelationshipPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedRelationship in entityUniversalRestrictionAxioms: " + restrictedRelationshipXRef));
        }
        oml.setRestrictedRelationship(restrictedRelationshipPair.getKey());
      }
    };
    this.entityUniversalRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyExistentialRestrictionAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyExistentialRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in entityScalarDataPropertyExistentialRestrictionAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedEntityXRef = kv.remove("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null == restrictedEntityPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyExistentialRestrictionAxioms: " + restrictedEntityXRef));
        }
        oml.setRestrictedEntity(restrictedEntityPair.getKey());
        final String scalarPropertyXRef = kv.remove("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null == scalarPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyExistentialRestrictionAxioms: " + scalarPropertyXRef));
        }
        oml.setScalarProperty(scalarPropertyPair.getKey());
        final String scalarRestrictionXRef = kv.remove("scalarRestrictionUUID");
        final Pair<DataRange, Map<String, String>> scalarRestrictionPair = this.dataRanges.get(scalarRestrictionXRef);
        if ((null == scalarRestrictionPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for scalarRestriction in entityScalarDataPropertyExistentialRestrictionAxioms: " + scalarRestrictionXRef));
        }
        oml.setScalarRestriction(scalarRestrictionPair.getKey());
      }
    };
    this.entityScalarDataPropertyExistentialRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyParticularRestrictionAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyParticularRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in entityScalarDataPropertyParticularRestrictionAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedEntityXRef = kv.remove("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null == restrictedEntityPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyParticularRestrictionAxioms: " + restrictedEntityXRef));
        }
        oml.setRestrictedEntity(restrictedEntityPair.getKey());
        final String scalarPropertyXRef = kv.remove("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null == scalarPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyParticularRestrictionAxioms: " + scalarPropertyXRef));
        }
        oml.setScalarProperty(scalarPropertyPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for valueType in entityScalarDataPropertyParticularRestrictionAxioms: " + valueTypeXRef));
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.entityScalarDataPropertyParticularRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyUniversalRestrictionAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyUniversalRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in entityScalarDataPropertyUniversalRestrictionAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedEntityXRef = kv.remove("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null == restrictedEntityPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyUniversalRestrictionAxioms: " + restrictedEntityXRef));
        }
        oml.setRestrictedEntity(restrictedEntityPair.getKey());
        final String scalarPropertyXRef = kv.remove("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null == scalarPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyUniversalRestrictionAxioms: " + scalarPropertyXRef));
        }
        oml.setScalarProperty(scalarPropertyPair.getKey());
        final String scalarRestrictionXRef = kv.remove("scalarRestrictionUUID");
        final Pair<DataRange, Map<String, String>> scalarRestrictionPair = this.dataRanges.get(scalarRestrictionXRef);
        if ((null == scalarRestrictionPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for scalarRestriction in entityScalarDataPropertyUniversalRestrictionAxioms: " + scalarRestrictionXRef));
        }
        oml.setScalarRestriction(scalarRestrictionPair.getKey());
      }
    };
    this.entityScalarDataPropertyUniversalRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityStructuredDataPropertyParticularRestrictionAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityStructuredDataPropertyParticularRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in entityStructuredDataPropertyParticularRestrictionAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null == structuredDataPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for structuredDataProperty in entityStructuredDataPropertyParticularRestrictionAxioms: " + structuredDataPropertyXRef));
        }
        oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
        final String restrictedEntityXRef = kv.remove("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null == restrictedEntityPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for restrictedEntity in entityStructuredDataPropertyParticularRestrictionAxioms: " + restrictedEntityXRef));
        }
        oml.setRestrictedEntity(restrictedEntityPair.getKey());
      }
    };
    this.entityStructuredDataPropertyParticularRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveRestrictionStructuredDataPropertyTuples(final ResourceSet rs) {
    final BiConsumer<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>> _function = (String uuid, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>> oml_kv) -> {
      final RestrictionStructuredDataPropertyTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID");
        final Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null == structuredDataPropertyContextPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for structuredDataPropertyContext in restrictionStructuredDataPropertyTuples: " + structuredDataPropertyContextXRef));
        }
        oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
        final String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null == structuredDataPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for structuredDataProperty in restrictionStructuredDataPropertyTuples: " + structuredDataPropertyXRef));
        }
        oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
      }
    };
    this.restrictionStructuredDataPropertyTuples.forEach(_function);
  }
  
  protected void resolveRestrictionScalarDataPropertyValues(final ResourceSet rs) {
    final BiConsumer<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<RestrictionScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final RestrictionScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID");
        final Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null == structuredDataPropertyContextPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for structuredDataPropertyContext in restrictionScalarDataPropertyValues: " + structuredDataPropertyContextXRef));
        }
        oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
        final String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID");
        final Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = this.dataRelationshipToScalars.get(scalarDataPropertyXRef);
        if ((null == scalarDataPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for scalarDataProperty in restrictionScalarDataPropertyValues: " + scalarDataPropertyXRef));
        }
        oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for valueType in restrictionScalarDataPropertyValues: " + valueTypeXRef));
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.restrictionScalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveAspectSpecializationAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<AspectSpecializationAxiom, Map<String, String>>> _function = (String uuid, Pair<AspectSpecializationAxiom, Map<String, String>> oml_kv) -> {
      final AspectSpecializationAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in aspectSpecializationAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String superAspectXRef = kv.remove("superAspectUUID");
        final Pair<Aspect, Map<String, String>> superAspectPair = this.aspects.get(superAspectXRef);
        if ((null == superAspectPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for superAspect in aspectSpecializationAxioms: " + superAspectXRef));
        }
        oml.setSuperAspect(superAspectPair.getKey());
        final String subEntityXRef = kv.remove("subEntityUUID");
        final Pair<Entity, Map<String, String>> subEntityPair = this.entities.get(subEntityXRef);
        if ((null == subEntityPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for subEntity in aspectSpecializationAxioms: " + subEntityXRef));
        }
        oml.setSubEntity(subEntityPair.getKey());
      }
    };
    this.aspectSpecializationAxioms.forEach(_function);
  }
  
  protected void resolveConceptSpecializationAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<ConceptSpecializationAxiom, Map<String, String>>> _function = (String uuid, Pair<ConceptSpecializationAxiom, Map<String, String>> oml_kv) -> {
      final ConceptSpecializationAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in conceptSpecializationAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String superConceptXRef = kv.remove("superConceptUUID");
        final Pair<Concept, Map<String, String>> superConceptPair = this.concepts.get(superConceptXRef);
        if ((null == superConceptPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for superConcept in conceptSpecializationAxioms: " + superConceptXRef));
        }
        oml.setSuperConcept(superConceptPair.getKey());
        final String subConceptXRef = kv.remove("subConceptUUID");
        final Pair<Concept, Map<String, String>> subConceptPair = this.concepts.get(subConceptXRef);
        if ((null == subConceptPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for subConcept in conceptSpecializationAxioms: " + subConceptXRef));
        }
        oml.setSubConcept(subConceptPair.getKey());
      }
    };
    this.conceptSpecializationAxioms.forEach(_function);
  }
  
  protected void resolveSubDataPropertyOfAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>> _function = (String uuid, Pair<SubDataPropertyOfAxiom, Map<String, String>> oml_kv) -> {
      final SubDataPropertyOfAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in subDataPropertyOfAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String subPropertyXRef = kv.remove("subPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> subPropertyPair = this.entityScalarDataProperties.get(subPropertyXRef);
        if ((null == subPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for subProperty in subDataPropertyOfAxioms: " + subPropertyXRef));
        }
        oml.setSubProperty(subPropertyPair.getKey());
        final String superPropertyXRef = kv.remove("superPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> superPropertyPair = this.entityScalarDataProperties.get(superPropertyXRef);
        if ((null == superPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for superProperty in subDataPropertyOfAxioms: " + superPropertyXRef));
        }
        oml.setSuperProperty(superPropertyPair.getKey());
      }
    };
    this.subDataPropertyOfAxioms.forEach(_function);
  }
  
  protected void resolveSubObjectPropertyOfAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>> _function = (String uuid, Pair<SubObjectPropertyOfAxiom, Map<String, String>> oml_kv) -> {
      final SubObjectPropertyOfAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for tbox in subObjectPropertyOfAxioms: " + tboxXRef));
        }
        oml.setTbox(tboxPair.getKey());
        final String subPropertyXRef = kv.remove("subPropertyUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> subPropertyPair = this.unreifiedRelationships.get(subPropertyXRef);
        if ((null == subPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for subProperty in subObjectPropertyOfAxioms: " + subPropertyXRef));
        }
        oml.setSubProperty(subPropertyPair.getKey());
        final String superPropertyXRef = kv.remove("superPropertyUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> superPropertyPair = this.unreifiedRelationships.get(superPropertyXRef);
        if ((null == superPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for superProperty in subObjectPropertyOfAxioms: " + superPropertyXRef));
        }
        oml.setSuperProperty(superPropertyPair.getKey());
      }
    };
    this.subObjectPropertyOfAxioms.forEach(_function);
  }
  
  protected void resolveRootConceptTaxonomyAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>> _function = (String uuid, Pair<RootConceptTaxonomyAxiom, Map<String, String>> oml_kv) -> {
      final RootConceptTaxonomyAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bundleXRef = kv.remove("bundleUUID");
        final Pair<Bundle, Map<String, String>> bundlePair = this.bundles.get(bundleXRef);
        if ((null == bundlePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for bundle in rootConceptTaxonomyAxioms: " + bundleXRef));
        }
        oml.setBundle(bundlePair.getKey());
        final String rootXRef = kv.remove("rootUUID");
        final Pair<Concept, Map<String, String>> rootPair = this.concepts.get(rootXRef);
        if ((null == rootPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for root in rootConceptTaxonomyAxioms: " + rootXRef));
        }
        oml.setRoot(rootPair.getKey());
      }
    };
    this.rootConceptTaxonomyAxioms.forEach(_function);
  }
  
  protected void resolveAnonymousConceptUnionAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>> _function = (String uuid, Pair<AnonymousConceptUnionAxiom, Map<String, String>> oml_kv) -> {
      final AnonymousConceptUnionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String disjointTaxonomyParentXRef = kv.remove("disjointTaxonomyParentUUID");
        final Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = this.conceptTreeDisjunctions.get(disjointTaxonomyParentXRef);
        if ((null == disjointTaxonomyParentPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for disjointTaxonomyParent in anonymousConceptUnionAxioms: " + disjointTaxonomyParentXRef));
        }
        oml.setDisjointTaxonomyParent(disjointTaxonomyParentPair.getKey());
      }
    };
    this.anonymousConceptUnionAxioms.forEach(_function);
  }
  
  protected void resolveSpecificDisjointConceptAxioms(final ResourceSet rs) {
    final BiConsumer<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>> _function = (String uuid, Pair<SpecificDisjointConceptAxiom, Map<String, String>> oml_kv) -> {
      final SpecificDisjointConceptAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String disjointTaxonomyParentXRef = kv.remove("disjointTaxonomyParentUUID");
        final Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = this.conceptTreeDisjunctions.get(disjointTaxonomyParentXRef);
        if ((null == disjointTaxonomyParentPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for disjointTaxonomyParent in specificDisjointConceptAxioms: " + disjointTaxonomyParentXRef));
        }
        oml.setDisjointTaxonomyParent(disjointTaxonomyParentPair.getKey());
        final String disjointLeafXRef = kv.remove("disjointLeafUUID");
        final Pair<Concept, Map<String, String>> disjointLeafPair = this.concepts.get(disjointLeafXRef);
        if ((null == disjointLeafPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for disjointLeaf in specificDisjointConceptAxioms: " + disjointLeafXRef));
        }
        oml.setDisjointLeaf(disjointLeafPair.getKey());
      }
    };
    this.specificDisjointConceptAxioms.forEach(_function);
  }
  
  protected void resolveConceptInstances(final ResourceSet rs) {
    final BiConsumer<String, Pair<ConceptInstance, Map<String, String>>> _function = (String uuid, Pair<ConceptInstance, Map<String, String>> oml_kv) -> {
      final ConceptInstance oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for descriptionBox in conceptInstances: " + descriptionBoxXRef));
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String singletonConceptClassifierXRef = kv.remove("singletonConceptClassifierUUID");
        final Pair<Concept, Map<String, String>> singletonConceptClassifierPair = this.concepts.get(singletonConceptClassifierXRef);
        if ((null == singletonConceptClassifierPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for singletonConceptClassifier in conceptInstances: " + singletonConceptClassifierXRef));
        }
        oml.setSingletonConceptClassifier(singletonConceptClassifierPair.getKey());
      }
    };
    this.conceptInstances.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstances(final ResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstance, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstance, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstance oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstances: " + descriptionBoxXRef));
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String singletonConceptualRelationshipClassifierXRef = kv.remove("singletonConceptualRelationshipClassifierUUID");
        final Pair<ConceptualRelationship, Map<String, String>> singletonConceptualRelationshipClassifierPair = this.conceptualRelationships.get(singletonConceptualRelationshipClassifierXRef);
        if ((null == singletonConceptualRelationshipClassifierPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for singletonConceptualRelationshipClassifier in reifiedRelationshipInstances: " + singletonConceptualRelationshipClassifierXRef));
        }
        oml.setSingletonConceptualRelationshipClassifier(singletonConceptualRelationshipClassifierPair.getKey());
      }
    };
    this.reifiedRelationshipInstances.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstanceDomains(final ResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstanceDomain oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstanceDomains: " + descriptionBoxXRef));
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String reifiedRelationshipInstanceXRef = kv.remove("reifiedRelationshipInstanceUUID");
        final Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = this.reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef);
        if ((null == reifiedRelationshipInstancePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for reifiedRelationshipInstance in reifiedRelationshipInstanceDomains: " + reifiedRelationshipInstanceXRef));
        }
        oml.setReifiedRelationshipInstance(reifiedRelationshipInstancePair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = this.conceptualEntitySingletonInstances.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for domain in reifiedRelationshipInstanceDomains: " + domainXRef));
        }
        oml.setDomain(domainPair.getKey());
      }
    };
    this.reifiedRelationshipInstanceDomains.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstanceRanges(final ResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstanceRange, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstanceRange oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstanceRanges: " + descriptionBoxXRef));
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String reifiedRelationshipInstanceXRef = kv.remove("reifiedRelationshipInstanceUUID");
        final Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = this.reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef);
        if ((null == reifiedRelationshipInstancePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for reifiedRelationshipInstance in reifiedRelationshipInstanceRanges: " + reifiedRelationshipInstanceXRef));
        }
        oml.setReifiedRelationshipInstance(reifiedRelationshipInstancePair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = this.conceptualEntitySingletonInstances.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for range in reifiedRelationshipInstanceRanges: " + rangeXRef));
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.reifiedRelationshipInstanceRanges.forEach(_function);
  }
  
  protected void resolveUnreifiedRelationshipInstanceTuples(final ResourceSet rs) {
    final BiConsumer<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>> _function = (String uuid, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>> oml_kv) -> {
      final UnreifiedRelationshipInstanceTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for descriptionBox in unreifiedRelationshipInstanceTuples: " + descriptionBoxXRef));
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String unreifiedRelationshipXRef = kv.remove("unreifiedRelationshipUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipPair = this.unreifiedRelationships.get(unreifiedRelationshipXRef);
        if ((null == unreifiedRelationshipPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for unreifiedRelationship in unreifiedRelationshipInstanceTuples: " + unreifiedRelationshipXRef));
        }
        oml.setUnreifiedRelationship(unreifiedRelationshipPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = this.conceptualEntitySingletonInstances.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for domain in unreifiedRelationshipInstanceTuples: " + domainXRef));
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = this.conceptualEntitySingletonInstances.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for range in unreifiedRelationshipInstanceTuples: " + rangeXRef));
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.unreifiedRelationshipInstanceTuples.forEach(_function);
  }
  
  protected void resolveSingletonInstanceStructuredDataPropertyValues(final ResourceSet rs) {
    final BiConsumer<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>> oml_kv) -> {
      final SingletonInstanceStructuredDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for descriptionBox in singletonInstanceStructuredDataPropertyValues: " + descriptionBoxXRef));
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String singletonInstanceXRef = kv.remove("singletonInstanceUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = this.conceptualEntitySingletonInstances.get(singletonInstanceXRef);
        if ((null == singletonInstancePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for singletonInstance in singletonInstanceStructuredDataPropertyValues: " + singletonInstanceXRef));
        }
        oml.setSingletonInstance(singletonInstancePair.getKey());
        final String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null == structuredDataPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for structuredDataProperty in singletonInstanceStructuredDataPropertyValues: " + structuredDataPropertyXRef));
        }
        oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
      }
    };
    this.singletonInstanceStructuredDataPropertyValues.forEach(_function);
  }
  
  protected void resolveSingletonInstanceScalarDataPropertyValues(final ResourceSet rs) {
    final BiConsumer<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final SingletonInstanceScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for descriptionBox in singletonInstanceScalarDataPropertyValues: " + descriptionBoxXRef));
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String singletonInstanceXRef = kv.remove("singletonInstanceUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = this.conceptualEntitySingletonInstances.get(singletonInstanceXRef);
        if ((null == singletonInstancePair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for singletonInstance in singletonInstanceScalarDataPropertyValues: " + singletonInstanceXRef));
        }
        oml.setSingletonInstance(singletonInstancePair.getKey());
        final String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarDataPropertyPair = this.entityScalarDataProperties.get(scalarDataPropertyXRef);
        if ((null == scalarDataPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for scalarDataProperty in singletonInstanceScalarDataPropertyValues: " + scalarDataPropertyXRef));
        }
        oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for valueType in singletonInstanceScalarDataPropertyValues: " + valueTypeXRef));
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.singletonInstanceScalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveStructuredDataPropertyTuples(final ResourceSet rs) {
    final BiConsumer<String, Pair<StructuredDataPropertyTuple, Map<String, String>>> _function = (String uuid, Pair<StructuredDataPropertyTuple, Map<String, String>> oml_kv) -> {
      final StructuredDataPropertyTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID");
        final Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null == structuredDataPropertyContextPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for structuredDataPropertyContext in structuredDataPropertyTuples: " + structuredDataPropertyContextXRef));
        }
        oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
        final String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null == structuredDataPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for structuredDataProperty in structuredDataPropertyTuples: " + structuredDataPropertyXRef));
        }
        oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
      }
    };
    this.structuredDataPropertyTuples.forEach(_function);
  }
  
  protected void resolveScalarDataPropertyValues(final ResourceSet rs) {
    final BiConsumer<String, Pair<ScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<ScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final ScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID");
        final Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null == structuredDataPropertyContextPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for structuredDataPropertyContext in scalarDataPropertyValues: " + structuredDataPropertyContextXRef));
        }
        oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
        final String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID");
        final Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = this.dataRelationshipToScalars.get(scalarDataPropertyXRef);
        if ((null == scalarDataPropertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for scalarDataProperty in scalarDataPropertyValues: " + scalarDataPropertyXRef));
        }
        oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException(("Null cross-reference lookup for valueType in scalarDataPropertyValues: " + valueTypeXRef));
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.scalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveAnnotationPropertyValues(final ResourceSet rs) {
    final BiConsumer<String, Pair<AnnotationPropertyValue, Map<String, String>>> _function = (String uuid, Pair<AnnotationPropertyValue, Map<String, String>> oml_kv) -> {
      final AnnotationPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String subjectXRef = kv.remove("subjectUUID");
        final Pair<LogicalElement, Map<String, String>> subjectPair = this.logicalElements.get(subjectXRef);
        if ((null == subjectPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for subject in annotationPropertyValues: " + subjectXRef));
        }
        oml.setSubject(subjectPair.getKey());
        final String propertyXRef = kv.remove("propertyUUID");
        final Pair<AnnotationProperty, Map<String, String>> propertyPair = this.annotationProperties.get(propertyXRef);
        if ((null == propertyPair)) {
          throw new IllegalArgumentException(("Null cross-reference lookup for property in annotationPropertyValues: " + propertyXRef));
        }
        oml.setProperty(propertyPair.getKey());
      }
    };
    this.annotationPropertyValues.forEach(_function);
  }
  
  protected Resource loadOMLZipResource(final ResourceSet rs, final URI uri) {
    try {
      Resource _xblockexpression = null;
      {
        final OMLCatalog omlCatalog = OMLExtensions.getCatalog(rs);
        if ((null == omlCatalog)) {
          throw new IllegalArgumentException("loadOMLZipResource: ResourceSet must have an OMLCatalog!");
        }
        boolean scan = false;
        final String uriString = uri.toString();
        Resource _xifexpression = null;
        boolean _startsWith = uriString.startsWith("file:");
        if (_startsWith) {
          Resource _xblockexpression_1 = null;
          {
            scan = true;
            _xblockexpression_1 = rs.getResource(uri, true);
          }
          _xifexpression = _xblockexpression_1;
        } else {
          Resource _xifexpression_1 = null;
          boolean _startsWith_1 = uriString.startsWith("http:");
          if (_startsWith_1) {
            Resource _xblockexpression_2 = null;
            {
              final Resource r0a = rs.getResource(uri, false);
              final Function1<Resource, Boolean> _function = (Resource r) -> {
                final Function1<EObject, Boolean> _function_1 = (EObject e) -> {
                  boolean _switchResult = false;
                  boolean _matched = false;
                  if (e instanceof Extent) {
                    _matched=true;
                    final Function1<Module, Boolean> _function_2 = (Module m) -> {
                      String _iri = m.iri();
                      return Boolean.valueOf(Objects.equal(_iri, uriString));
                    };
                    _switchResult = IterableExtensions.<Module>exists(((Extent)e).getModules(), _function_2);
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
                Resource _xblockexpression_3 = null;
                {
                  boolean _matched = false;
                  if (r0 instanceof OMLZipResource) {
                    _matched=true;
                  }
                  if (!_matched) {
                    if (r0 instanceof XtextResource) {
                      _matched=true;
                      scan = true;
                    }
                  }
                  if (!_matched) {
                  }
                  _xblockexpression_3 = r0;
                }
                _xifexpression_2 = _xblockexpression_3;
              } else {
                Resource _xblockexpression_4 = null;
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
                  scan = true;
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
                  _xblockexpression_4 = _xifexpression_6;
                }
                _xifexpression_2 = _xblockexpression_4;
              }
              _xblockexpression_2 = _xifexpression_2;
            }
            _xifexpression_1 = _xblockexpression_2;
          }
          _xifexpression = _xifexpression_1;
        }
        final Resource r = _xifexpression;
        if (scan) {
          final Consumer<EObject> _function = (EObject e) -> {
            boolean _matched = false;
            if (e instanceof Extent) {
              _matched=true;
              final Consumer<Module> _function_1 = (Module it) -> {
                this.includeModule(it);
              };
              ((Extent)e).getModules().forEach(_function_1);
            }
          };
          r.getContents().forEach(_function);
        }
        _xblockexpression = r;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void includeModule(final Module m) {
    if ((null != m)) {
      boolean _matched = false;
      if (m instanceof TerminologyGraph) {
        _matched=true;
        String _uuid = ((TerminologyGraph)m).uuid();
        Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
        Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(m, _emptyMap);
        this.logicalElements.put(_uuid, _pair);
        String _uuid_1 = ((TerminologyGraph)m).uuid();
        Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
        Pair<TerminologyGraph, Map<String, String>> _pair_1 = new Pair<TerminologyGraph, Map<String, String>>(((TerminologyGraph)m), _emptyMap_1);
        this.terminologyGraphs.put(_uuid_1, _pair_1);
        String _uuid_2 = ((TerminologyGraph)m).uuid();
        Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
        Pair<TerminologyBox, Map<String, String>> _pair_2 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)m), _emptyMap_2);
        this.terminologyBoxes.put(_uuid_2, _pair_2);
        String _iri = ((TerminologyGraph)m).iri();
        Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
        Pair<TerminologyBox, Map<String, String>> _pair_3 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)m), _emptyMap_3);
        this.terminologyBoxes.put(_iri, _pair_3);
      }
      if (!_matched) {
        if (m instanceof Bundle) {
          _matched=true;
          String _uuid = ((Bundle)m).uuid();
          Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
          Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(m, _emptyMap);
          this.logicalElements.put(_uuid, _pair);
          String _uuid_1 = ((Bundle)m).uuid();
          Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
          Pair<Bundle, Map<String, String>> _pair_1 = new Pair<Bundle, Map<String, String>>(((Bundle)m), _emptyMap_1);
          this.bundles.put(_uuid_1, _pair_1);
          String _uuid_2 = ((Bundle)m).uuid();
          Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
          Pair<TerminologyBox, Map<String, String>> _pair_2 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)m), _emptyMap_2);
          this.terminologyBoxes.put(_uuid_2, _pair_2);
          String _iri = ((Bundle)m).iri();
          Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
          Pair<TerminologyBox, Map<String, String>> _pair_3 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)m), _emptyMap_3);
          this.terminologyBoxes.put(_iri, _pair_3);
        }
      }
      if (!_matched) {
        if (m instanceof DescriptionBox) {
          _matched=true;
          String _uuid = ((DescriptionBox)m).uuid();
          Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
          Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(m, _emptyMap);
          this.logicalElements.put(_uuid, _pair);
          String _uuid_1 = ((DescriptionBox)m).uuid();
          Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
          Pair<DescriptionBox, Map<String, String>> _pair_1 = new Pair<DescriptionBox, Map<String, String>>(((DescriptionBox)m), _emptyMap_1);
          this.descriptionBoxes.put(_uuid_1, _pair_1);
          String _iri = ((DescriptionBox)m).iri();
          Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
          Pair<DescriptionBox, Map<String, String>> _pair_2 = new Pair<DescriptionBox, Map<String, String>>(((DescriptionBox)m), _emptyMap_2);
          this.descriptionBoxes.put(_iri, _pair_2);
        }
      }
      String _uuid = m.uuid();
      Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
      Pair<Module, Map<String, String>> _pair = new Pair<Module, Map<String, String>>(m, _emptyMap);
      this.modules.put(_uuid, _pair);
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
            String _uuid_1 = ((Aspect)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof Concept) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<Concept, Map<String, String>> pair = new Pair<Concept, Map<String, String>>(((Concept)e), _emptyMap_1);
            this.concepts.put(((Concept)e).uuid(), pair);
            String _uuid_1 = ((Concept)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof Scalar) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<Scalar, Map<String, String>> pair = new Pair<Scalar, Map<String, String>>(((Scalar)e), _emptyMap_1);
            this.scalars.put(((Scalar)e).uuid(), pair);
            String _uuid_1 = ((Scalar)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof Structure) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<Structure, Map<String, String>> pair = new Pair<Structure, Map<String, String>>(((Structure)e), _emptyMap_1);
            this.structures.put(((Structure)e).uuid(), pair);
            String _uuid_1 = ((Structure)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptDesignationTerminologyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> pair = new Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>(((ConceptDesignationTerminologyAxiom)e), _emptyMap_1);
            this.conceptDesignationTerminologyAxioms.put(((ConceptDesignationTerminologyAxiom)e).uuid(), pair);
            String _uuid_1 = ((ConceptDesignationTerminologyAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof TerminologyExtensionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<TerminologyExtensionAxiom, Map<String, String>> pair = new Pair<TerminologyExtensionAxiom, Map<String, String>>(((TerminologyExtensionAxiom)e), _emptyMap_1);
            this.terminologyExtensionAxioms.put(((TerminologyExtensionAxiom)e).uuid(), pair);
            String _uuid_1 = ((TerminologyExtensionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof TerminologyNestingAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<TerminologyNestingAxiom, Map<String, String>> pair = new Pair<TerminologyNestingAxiom, Map<String, String>>(((TerminologyNestingAxiom)e), _emptyMap_1);
            this.terminologyNestingAxioms.put(((TerminologyNestingAxiom)e).uuid(), pair);
            String _uuid_1 = ((TerminologyNestingAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof BundledTerminologyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<BundledTerminologyAxiom, Map<String, String>> pair = new Pair<BundledTerminologyAxiom, Map<String, String>>(((BundledTerminologyAxiom)e), _emptyMap_1);
            this.bundledTerminologyAxioms.put(((BundledTerminologyAxiom)e).uuid(), pair);
            String _uuid_1 = ((BundledTerminologyAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof DescriptionBoxExtendsClosedWorldDefinitions) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> pair = new Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>(((DescriptionBoxExtendsClosedWorldDefinitions)e), _emptyMap_1);
            this.descriptionBoxExtendsClosedWorldDefinitions.put(((DescriptionBoxExtendsClosedWorldDefinitions)e).uuid(), pair);
            String _uuid_1 = ((DescriptionBoxExtendsClosedWorldDefinitions)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof DescriptionBoxRefinement) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<DescriptionBoxRefinement, Map<String, String>> pair = new Pair<DescriptionBoxRefinement, Map<String, String>>(((DescriptionBoxRefinement)e), _emptyMap_1);
            this.descriptionBoxRefinements.put(((DescriptionBoxRefinement)e).uuid(), pair);
            String _uuid_1 = ((DescriptionBoxRefinement)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof BinaryScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<BinaryScalarRestriction, Map<String, String>> pair = new Pair<BinaryScalarRestriction, Map<String, String>>(((BinaryScalarRestriction)e), _emptyMap_1);
            this.binaryScalarRestrictions.put(((BinaryScalarRestriction)e).uuid(), pair);
            String _uuid_1 = ((BinaryScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof IRIScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<IRIScalarRestriction, Map<String, String>> pair = new Pair<IRIScalarRestriction, Map<String, String>>(((IRIScalarRestriction)e), _emptyMap_1);
            this.iriScalarRestrictions.put(((IRIScalarRestriction)e).uuid(), pair);
            String _uuid_1 = ((IRIScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof NumericScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<NumericScalarRestriction, Map<String, String>> pair = new Pair<NumericScalarRestriction, Map<String, String>>(((NumericScalarRestriction)e), _emptyMap_1);
            this.numericScalarRestrictions.put(((NumericScalarRestriction)e).uuid(), pair);
            String _uuid_1 = ((NumericScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof PlainLiteralScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<PlainLiteralScalarRestriction, Map<String, String>> pair = new Pair<PlainLiteralScalarRestriction, Map<String, String>>(((PlainLiteralScalarRestriction)e), _emptyMap_1);
            this.plainLiteralScalarRestrictions.put(((PlainLiteralScalarRestriction)e).uuid(), pair);
            String _uuid_1 = ((PlainLiteralScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarOneOfRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ScalarOneOfRestriction, Map<String, String>> pair = new Pair<ScalarOneOfRestriction, Map<String, String>>(((ScalarOneOfRestriction)e), _emptyMap_1);
            this.scalarOneOfRestrictions.put(((ScalarOneOfRestriction)e).uuid(), pair);
            String _uuid_1 = ((ScalarOneOfRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarOneOfLiteralAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ScalarOneOfLiteralAxiom, Map<String, String>> pair = new Pair<ScalarOneOfLiteralAxiom, Map<String, String>>(((ScalarOneOfLiteralAxiom)e), _emptyMap_1);
            this.scalarOneOfLiteralAxioms.put(((ScalarOneOfLiteralAxiom)e).uuid(), pair);
            String _uuid_1 = ((ScalarOneOfLiteralAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof StringScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<StringScalarRestriction, Map<String, String>> pair = new Pair<StringScalarRestriction, Map<String, String>>(((StringScalarRestriction)e), _emptyMap_1);
            this.stringScalarRestrictions.put(((StringScalarRestriction)e).uuid(), pair);
            String _uuid_1 = ((StringScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SynonymScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SynonymScalarRestriction, Map<String, String>> pair = new Pair<SynonymScalarRestriction, Map<String, String>>(((SynonymScalarRestriction)e), _emptyMap_1);
            this.synonymScalarRestrictions.put(((SynonymScalarRestriction)e).uuid(), pair);
            String _uuid_1 = ((SynonymScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof TimeScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<TimeScalarRestriction, Map<String, String>> pair = new Pair<TimeScalarRestriction, Map<String, String>>(((TimeScalarRestriction)e), _emptyMap_1);
            this.timeScalarRestrictions.put(((TimeScalarRestriction)e).uuid(), pair);
            String _uuid_1 = ((TimeScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataProperty, Map<String, String>> pair = new Pair<EntityScalarDataProperty, Map<String, String>>(((EntityScalarDataProperty)e), _emptyMap_1);
            this.entityScalarDataProperties.put(((EntityScalarDataProperty)e).uuid(), pair);
            String _uuid_1 = ((EntityScalarDataProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityStructuredDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityStructuredDataProperty, Map<String, String>> pair = new Pair<EntityStructuredDataProperty, Map<String, String>>(((EntityStructuredDataProperty)e), _emptyMap_1);
            this.entityStructuredDataProperties.put(((EntityStructuredDataProperty)e).uuid(), pair);
            String _uuid_1 = ((EntityStructuredDataProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ScalarDataProperty, Map<String, String>> pair = new Pair<ScalarDataProperty, Map<String, String>>(((ScalarDataProperty)e), _emptyMap_1);
            this.scalarDataProperties.put(((ScalarDataProperty)e).uuid(), pair);
            String _uuid_1 = ((ScalarDataProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof StructuredDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<StructuredDataProperty, Map<String, String>> pair = new Pair<StructuredDataProperty, Map<String, String>>(((StructuredDataProperty)e), _emptyMap_1);
            this.structuredDataProperties.put(((StructuredDataProperty)e).uuid(), pair);
            String _uuid_1 = ((StructuredDataProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationship) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationship, Map<String, String>> pair = new Pair<ReifiedRelationship, Map<String, String>>(((ReifiedRelationship)e), _emptyMap_1);
            this.reifiedRelationships.put(((ReifiedRelationship)e).uuid(), pair);
            String _uuid_1 = ((ReifiedRelationship)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ForwardProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ForwardProperty, Map<String, String>> pair = new Pair<ForwardProperty, Map<String, String>>(((ForwardProperty)e), _emptyMap_1);
            this.forwardProperties.put(((ForwardProperty)e).uuid(), pair);
            String _uuid_1 = ((ForwardProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof InverseProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<InverseProperty, Map<String, String>> pair = new Pair<InverseProperty, Map<String, String>>(((InverseProperty)e), _emptyMap_1);
            this.inverseProperties.put(((InverseProperty)e).uuid(), pair);
            String _uuid_1 = ((InverseProperty)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SpecializedReifiedRelationship) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SpecializedReifiedRelationship, Map<String, String>> pair = new Pair<SpecializedReifiedRelationship, Map<String, String>>(((SpecializedReifiedRelationship)e), _emptyMap_1);
            this.specializedReifiedRelationships.put(((SpecializedReifiedRelationship)e).uuid(), pair);
            String _uuid_1 = ((SpecializedReifiedRelationship)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof UnreifiedRelationship) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<UnreifiedRelationship, Map<String, String>> pair = new Pair<UnreifiedRelationship, Map<String, String>>(((UnreifiedRelationship)e), _emptyMap_1);
            this.unreifiedRelationships.put(((UnreifiedRelationship)e).uuid(), pair);
            String _uuid_1 = ((UnreifiedRelationship)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ChainRule) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ChainRule, Map<String, String>> pair = new Pair<ChainRule, Map<String, String>>(((ChainRule)e), _emptyMap_1);
            this.chainRules.put(((ChainRule)e).uuid(), pair);
            String _uuid_1 = ((ChainRule)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof RuleBodySegment) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<RuleBodySegment, Map<String, String>> pair = new Pair<RuleBodySegment, Map<String, String>>(((RuleBodySegment)e), _emptyMap_1);
            this.ruleBodySegments.put(((RuleBodySegment)e).uuid(), pair);
            String _uuid_1 = ((RuleBodySegment)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SegmentPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SegmentPredicate, Map<String, String>> pair = new Pair<SegmentPredicate, Map<String, String>>(((SegmentPredicate)e), _emptyMap_1);
            this.segmentPredicates.put(((SegmentPredicate)e).uuid(), pair);
            String _uuid_1 = ((SegmentPredicate)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityExistentialRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityExistentialRestrictionAxiom, Map<String, String>>(((EntityExistentialRestrictionAxiom)e), _emptyMap_1);
            this.entityExistentialRestrictionAxioms.put(((EntityExistentialRestrictionAxiom)e).uuid(), pair);
            String _uuid_1 = ((EntityExistentialRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityUniversalRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityUniversalRestrictionAxiom, Map<String, String>>(((EntityUniversalRestrictionAxiom)e), _emptyMap_1);
            this.entityUniversalRestrictionAxioms.put(((EntityUniversalRestrictionAxiom)e).uuid(), pair);
            String _uuid_1 = ((EntityUniversalRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyExistentialRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyExistentialRestrictionAxiom)e), _emptyMap_1);
            this.entityScalarDataPropertyExistentialRestrictionAxioms.put(((EntityScalarDataPropertyExistentialRestrictionAxiom)e).uuid(), pair);
            String _uuid_1 = ((EntityScalarDataPropertyExistentialRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyParticularRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyParticularRestrictionAxiom)e), _emptyMap_1);
            this.entityScalarDataPropertyParticularRestrictionAxioms.put(((EntityScalarDataPropertyParticularRestrictionAxiom)e).uuid(), pair);
            String _uuid_1 = ((EntityScalarDataPropertyParticularRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyUniversalRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyUniversalRestrictionAxiom)e), _emptyMap_1);
            this.entityScalarDataPropertyUniversalRestrictionAxioms.put(((EntityScalarDataPropertyUniversalRestrictionAxiom)e).uuid(), pair);
            String _uuid_1 = ((EntityScalarDataPropertyUniversalRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>(((EntityStructuredDataPropertyParticularRestrictionAxiom)e), _emptyMap_1);
            this.entityStructuredDataPropertyParticularRestrictionAxioms.put(((EntityStructuredDataPropertyParticularRestrictionAxiom)e).uuid(), pair);
            String _uuid_1 = ((EntityStructuredDataPropertyParticularRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof RestrictionStructuredDataPropertyTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>> pair = new Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>(((RestrictionStructuredDataPropertyTuple)e), _emptyMap_1);
            this.restrictionStructuredDataPropertyTuples.put(((RestrictionStructuredDataPropertyTuple)e).uuid(), pair);
            String _uuid_1 = ((RestrictionStructuredDataPropertyTuple)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof RestrictionScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<RestrictionScalarDataPropertyValue, Map<String, String>> pair = new Pair<RestrictionScalarDataPropertyValue, Map<String, String>>(((RestrictionScalarDataPropertyValue)e), _emptyMap_1);
            this.restrictionScalarDataPropertyValues.put(((RestrictionScalarDataPropertyValue)e).uuid(), pair);
            String _uuid_1 = ((RestrictionScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof AspectSpecializationAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<AspectSpecializationAxiom, Map<String, String>> pair = new Pair<AspectSpecializationAxiom, Map<String, String>>(((AspectSpecializationAxiom)e), _emptyMap_1);
            this.aspectSpecializationAxioms.put(((AspectSpecializationAxiom)e).uuid(), pair);
            String _uuid_1 = ((AspectSpecializationAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptSpecializationAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ConceptSpecializationAxiom, Map<String, String>> pair = new Pair<ConceptSpecializationAxiom, Map<String, String>>(((ConceptSpecializationAxiom)e), _emptyMap_1);
            this.conceptSpecializationAxioms.put(((ConceptSpecializationAxiom)e).uuid(), pair);
            String _uuid_1 = ((ConceptSpecializationAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SubDataPropertyOfAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SubDataPropertyOfAxiom, Map<String, String>> pair = new Pair<SubDataPropertyOfAxiom, Map<String, String>>(((SubDataPropertyOfAxiom)e), _emptyMap_1);
            this.subDataPropertyOfAxioms.put(((SubDataPropertyOfAxiom)e).uuid(), pair);
            String _uuid_1 = ((SubDataPropertyOfAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SubObjectPropertyOfAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SubObjectPropertyOfAxiom, Map<String, String>> pair = new Pair<SubObjectPropertyOfAxiom, Map<String, String>>(((SubObjectPropertyOfAxiom)e), _emptyMap_1);
            this.subObjectPropertyOfAxioms.put(((SubObjectPropertyOfAxiom)e).uuid(), pair);
            String _uuid_1 = ((SubObjectPropertyOfAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof RootConceptTaxonomyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<RootConceptTaxonomyAxiom, Map<String, String>> pair = new Pair<RootConceptTaxonomyAxiom, Map<String, String>>(((RootConceptTaxonomyAxiom)e), _emptyMap_1);
            this.rootConceptTaxonomyAxioms.put(((RootConceptTaxonomyAxiom)e).uuid(), pair);
            String _uuid_1 = ((RootConceptTaxonomyAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof AnonymousConceptUnionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<AnonymousConceptUnionAxiom, Map<String, String>> pair = new Pair<AnonymousConceptUnionAxiom, Map<String, String>>(((AnonymousConceptUnionAxiom)e), _emptyMap_1);
            this.anonymousConceptUnionAxioms.put(((AnonymousConceptUnionAxiom)e).uuid(), pair);
            String _uuid_1 = ((AnonymousConceptUnionAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SpecificDisjointConceptAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SpecificDisjointConceptAxiom, Map<String, String>> pair = new Pair<SpecificDisjointConceptAxiom, Map<String, String>>(((SpecificDisjointConceptAxiom)e), _emptyMap_1);
            this.specificDisjointConceptAxioms.put(((SpecificDisjointConceptAxiom)e).uuid(), pair);
            String _uuid_1 = ((SpecificDisjointConceptAxiom)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptInstance) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ConceptInstance, Map<String, String>> pair = new Pair<ConceptInstance, Map<String, String>>(((ConceptInstance)e), _emptyMap_1);
            this.conceptInstances.put(((ConceptInstance)e).uuid(), pair);
            String _uuid_1 = ((ConceptInstance)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstance) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstance, Map<String, String>> pair = new Pair<ReifiedRelationshipInstance, Map<String, String>>(((ReifiedRelationshipInstance)e), _emptyMap_1);
            this.reifiedRelationshipInstances.put(((ReifiedRelationshipInstance)e).uuid(), pair);
            String _uuid_1 = ((ReifiedRelationshipInstance)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstanceDomain) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstanceDomain, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>(((ReifiedRelationshipInstanceDomain)e), _emptyMap_1);
            this.reifiedRelationshipInstanceDomains.put(((ReifiedRelationshipInstanceDomain)e).uuid(), pair);
            String _uuid_1 = ((ReifiedRelationshipInstanceDomain)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstanceRange) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstanceRange, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceRange, Map<String, String>>(((ReifiedRelationshipInstanceRange)e), _emptyMap_1);
            this.reifiedRelationshipInstanceRanges.put(((ReifiedRelationshipInstanceRange)e).uuid(), pair);
            String _uuid_1 = ((ReifiedRelationshipInstanceRange)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof UnreifiedRelationshipInstanceTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>> pair = new Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>(((UnreifiedRelationshipInstanceTuple)e), _emptyMap_1);
            this.unreifiedRelationshipInstanceTuples.put(((UnreifiedRelationshipInstanceTuple)e).uuid(), pair);
            String _uuid_1 = ((UnreifiedRelationshipInstanceTuple)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SingletonInstanceStructuredDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>(((SingletonInstanceStructuredDataPropertyValue)e), _emptyMap_1);
            this.singletonInstanceStructuredDataPropertyValues.put(((SingletonInstanceStructuredDataPropertyValue)e).uuid(), pair);
            String _uuid_1 = ((SingletonInstanceStructuredDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof SingletonInstanceScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>(((SingletonInstanceScalarDataPropertyValue)e), _emptyMap_1);
            this.singletonInstanceScalarDataPropertyValues.put(((SingletonInstanceScalarDataPropertyValue)e).uuid(), pair);
            String _uuid_1 = ((SingletonInstanceScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof StructuredDataPropertyTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<StructuredDataPropertyTuple, Map<String, String>> pair = new Pair<StructuredDataPropertyTuple, Map<String, String>>(((StructuredDataPropertyTuple)e), _emptyMap_1);
            this.structuredDataPropertyTuples.put(((StructuredDataPropertyTuple)e).uuid(), pair);
            String _uuid_1 = ((StructuredDataPropertyTuple)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            final Pair<ScalarDataPropertyValue, Map<String, String>> pair = new Pair<ScalarDataPropertyValue, Map<String, String>>(((ScalarDataPropertyValue)e), _emptyMap_1);
            this.scalarDataPropertyValues.put(((ScalarDataPropertyValue)e).uuid(), pair);
            String _uuid_1 = ((ScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair_1 = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_2);
            this.logicalElements.put(_uuid_1, _pair_1);
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
      };
      IteratorExtensions.<EObject>forEach(m.eAllContents(), _function);
    }
  }
}
