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
import gov.nasa.jpl.imce.oml.model.extensions.OMLTables;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
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
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext;
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
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipInversePropertyPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipPropertyPredicate;
import gov.nasa.jpl.imce.oml.zip.OMLZipResource;
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceSet;
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
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
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
  
  protected final Map<String, Pair<UnreifiedRelationship, Map<String, String>>> unreifiedRelationships;
  
  protected final Map<String, Pair<ChainRule, Map<String, String>>> chainRules;
  
  protected final Map<String, Pair<RuleBodySegment, Map<String, String>>> ruleBodySegments;
  
  protected final Map<String, Pair<AspectPredicate, Map<String, String>>> aspectPredicates;
  
  protected final Map<String, Pair<ConceptPredicate, Map<String, String>>> conceptPredicates;
  
  protected final Map<String, Pair<ReifiedRelationshipPredicate, Map<String, String>>> reifiedRelationshipPredicates;
  
  protected final Map<String, Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>>> reifiedRelationshipPropertyPredicates;
  
  protected final Map<String, Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>>> reifiedRelationshipSourcePropertyPredicates;
  
  protected final Map<String, Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>>> reifiedRelationshipTargetPropertyPredicates;
  
  protected final Map<String, Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>>> unreifiedRelationshipPropertyPredicates;
  
  protected final Map<String, Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>>> reifiedRelationshipInversePropertyPredicates;
  
  protected final Map<String, Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>>> reifiedRelationshipSourceInversePropertyPredicates;
  
  protected final Map<String, Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>>> reifiedRelationshipTargetInversePropertyPredicates;
  
  protected final Map<String, Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>>> unreifiedRelationshipInversePropertyPredicates;
  
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
  
  protected final Map<String, Pair<Module, Map<String, String>>> modules;
  
  protected final Map<String, Pair<LogicalElement, Map<String, String>>> logicalElements;
  
  protected final Map<String, Pair<Entity, Map<String, String>>> entities;
  
  protected final Map<String, Pair<EntityRelationship, Map<String, String>>> entityRelationships;
  
  protected final Map<String, Pair<DataRange, Map<String, String>>> dataRanges;
  
  protected final Map<String, Pair<DataRelationshipToScalar, Map<String, String>>> dataRelationshipToScalars;
  
  protected final Map<String, Pair<DataRelationshipToStructure, Map<String, String>>> dataRelationshipToStructures;
  
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
  
  public OMLSpecificationTables() {
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
    HashMap<String, Pair<UnreifiedRelationship, Map<String, String>>> _hashMap_28 = new HashMap<String, Pair<UnreifiedRelationship, Map<String, String>>>();
    this.unreifiedRelationships = _hashMap_28;
    HashMap<String, Pair<ChainRule, Map<String, String>>> _hashMap_29 = new HashMap<String, Pair<ChainRule, Map<String, String>>>();
    this.chainRules = _hashMap_29;
    HashMap<String, Pair<RuleBodySegment, Map<String, String>>> _hashMap_30 = new HashMap<String, Pair<RuleBodySegment, Map<String, String>>>();
    this.ruleBodySegments = _hashMap_30;
    HashMap<String, Pair<AspectPredicate, Map<String, String>>> _hashMap_31 = new HashMap<String, Pair<AspectPredicate, Map<String, String>>>();
    this.aspectPredicates = _hashMap_31;
    HashMap<String, Pair<ConceptPredicate, Map<String, String>>> _hashMap_32 = new HashMap<String, Pair<ConceptPredicate, Map<String, String>>>();
    this.conceptPredicates = _hashMap_32;
    HashMap<String, Pair<ReifiedRelationshipPredicate, Map<String, String>>> _hashMap_33 = new HashMap<String, Pair<ReifiedRelationshipPredicate, Map<String, String>>>();
    this.reifiedRelationshipPredicates = _hashMap_33;
    HashMap<String, Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>>> _hashMap_34 = new HashMap<String, Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>>>();
    this.reifiedRelationshipPropertyPredicates = _hashMap_34;
    HashMap<String, Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>>> _hashMap_35 = new HashMap<String, Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>>>();
    this.reifiedRelationshipSourcePropertyPredicates = _hashMap_35;
    HashMap<String, Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>>> _hashMap_36 = new HashMap<String, Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>>>();
    this.reifiedRelationshipTargetPropertyPredicates = _hashMap_36;
    HashMap<String, Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>>> _hashMap_37 = new HashMap<String, Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>>>();
    this.unreifiedRelationshipPropertyPredicates = _hashMap_37;
    HashMap<String, Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>>> _hashMap_38 = new HashMap<String, Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>>>();
    this.reifiedRelationshipInversePropertyPredicates = _hashMap_38;
    HashMap<String, Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>>> _hashMap_39 = new HashMap<String, Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>>>();
    this.reifiedRelationshipSourceInversePropertyPredicates = _hashMap_39;
    HashMap<String, Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>>> _hashMap_40 = new HashMap<String, Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>>>();
    this.reifiedRelationshipTargetInversePropertyPredicates = _hashMap_40;
    HashMap<String, Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>>> _hashMap_41 = new HashMap<String, Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>>>();
    this.unreifiedRelationshipInversePropertyPredicates = _hashMap_41;
    HashMap<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>> _hashMap_42 = new HashMap<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>>();
    this.entityExistentialRestrictionAxioms = _hashMap_42;
    HashMap<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>> _hashMap_43 = new HashMap<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>>();
    this.entityUniversalRestrictionAxioms = _hashMap_43;
    HashMap<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>> _hashMap_44 = new HashMap<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyExistentialRestrictionAxioms = _hashMap_44;
    HashMap<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>> _hashMap_45 = new HashMap<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyParticularRestrictionAxioms = _hashMap_45;
    HashMap<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>> _hashMap_46 = new HashMap<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>>();
    this.entityScalarDataPropertyUniversalRestrictionAxioms = _hashMap_46;
    HashMap<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>> _hashMap_47 = new HashMap<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>>();
    this.entityStructuredDataPropertyParticularRestrictionAxioms = _hashMap_47;
    HashMap<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>> _hashMap_48 = new HashMap<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>>();
    this.restrictionStructuredDataPropertyTuples = _hashMap_48;
    HashMap<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>> _hashMap_49 = new HashMap<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>>();
    this.restrictionScalarDataPropertyValues = _hashMap_49;
    HashMap<String, Pair<AspectSpecializationAxiom, Map<String, String>>> _hashMap_50 = new HashMap<String, Pair<AspectSpecializationAxiom, Map<String, String>>>();
    this.aspectSpecializationAxioms = _hashMap_50;
    HashMap<String, Pair<ConceptSpecializationAxiom, Map<String, String>>> _hashMap_51 = new HashMap<String, Pair<ConceptSpecializationAxiom, Map<String, String>>>();
    this.conceptSpecializationAxioms = _hashMap_51;
    HashMap<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>> _hashMap_52 = new HashMap<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>>();
    this.reifiedRelationshipSpecializationAxioms = _hashMap_52;
    HashMap<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>> _hashMap_53 = new HashMap<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>>();
    this.subDataPropertyOfAxioms = _hashMap_53;
    HashMap<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>> _hashMap_54 = new HashMap<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>>();
    this.subObjectPropertyOfAxioms = _hashMap_54;
    HashMap<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>> _hashMap_55 = new HashMap<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>>();
    this.rootConceptTaxonomyAxioms = _hashMap_55;
    HashMap<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>> _hashMap_56 = new HashMap<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>>();
    this.anonymousConceptUnionAxioms = _hashMap_56;
    HashMap<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>> _hashMap_57 = new HashMap<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>>();
    this.specificDisjointConceptAxioms = _hashMap_57;
    HashMap<String, Pair<ConceptInstance, Map<String, String>>> _hashMap_58 = new HashMap<String, Pair<ConceptInstance, Map<String, String>>>();
    this.conceptInstances = _hashMap_58;
    HashMap<String, Pair<ReifiedRelationshipInstance, Map<String, String>>> _hashMap_59 = new HashMap<String, Pair<ReifiedRelationshipInstance, Map<String, String>>>();
    this.reifiedRelationshipInstances = _hashMap_59;
    HashMap<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>> _hashMap_60 = new HashMap<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>>();
    this.reifiedRelationshipInstanceDomains = _hashMap_60;
    HashMap<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>> _hashMap_61 = new HashMap<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>>();
    this.reifiedRelationshipInstanceRanges = _hashMap_61;
    HashMap<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>> _hashMap_62 = new HashMap<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>>();
    this.unreifiedRelationshipInstanceTuples = _hashMap_62;
    HashMap<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>> _hashMap_63 = new HashMap<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>>();
    this.singletonInstanceStructuredDataPropertyValues = _hashMap_63;
    HashMap<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>> _hashMap_64 = new HashMap<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>>();
    this.singletonInstanceScalarDataPropertyValues = _hashMap_64;
    HashMap<String, Pair<StructuredDataPropertyTuple, Map<String, String>>> _hashMap_65 = new HashMap<String, Pair<StructuredDataPropertyTuple, Map<String, String>>>();
    this.structuredDataPropertyTuples = _hashMap_65;
    HashMap<String, Pair<ScalarDataPropertyValue, Map<String, String>>> _hashMap_66 = new HashMap<String, Pair<ScalarDataPropertyValue, Map<String, String>>>();
    this.scalarDataPropertyValues = _hashMap_66;
    HashMap<String, Pair<AnnotationPropertyValue, Map<String, String>>> _hashMap_67 = new HashMap<String, Pair<AnnotationPropertyValue, Map<String, String>>>();
    this.annotationPropertyValues = _hashMap_67;
    HashMap<String, Pair<Module, Map<String, String>>> _hashMap_68 = new HashMap<String, Pair<Module, Map<String, String>>>();
    this.modules = _hashMap_68;
    HashMap<String, Pair<LogicalElement, Map<String, String>>> _hashMap_69 = new HashMap<String, Pair<LogicalElement, Map<String, String>>>();
    this.logicalElements = _hashMap_69;
    HashMap<String, Pair<Entity, Map<String, String>>> _hashMap_70 = new HashMap<String, Pair<Entity, Map<String, String>>>();
    this.entities = _hashMap_70;
    HashMap<String, Pair<EntityRelationship, Map<String, String>>> _hashMap_71 = new HashMap<String, Pair<EntityRelationship, Map<String, String>>>();
    this.entityRelationships = _hashMap_71;
    HashMap<String, Pair<DataRange, Map<String, String>>> _hashMap_72 = new HashMap<String, Pair<DataRange, Map<String, String>>>();
    this.dataRanges = _hashMap_72;
    HashMap<String, Pair<DataRelationshipToScalar, Map<String, String>>> _hashMap_73 = new HashMap<String, Pair<DataRelationshipToScalar, Map<String, String>>>();
    this.dataRelationshipToScalars = _hashMap_73;
    HashMap<String, Pair<DataRelationshipToStructure, Map<String, String>>> _hashMap_74 = new HashMap<String, Pair<DataRelationshipToStructure, Map<String, String>>>();
    this.dataRelationshipToStructures = _hashMap_74;
    HashMap<String, Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>> _hashMap_75 = new HashMap<String, Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>>();
    this.restrictionStructuredDataPropertyContexts = _hashMap_75;
    HashMap<String, Pair<TerminologyBox, Map<String, String>>> _hashMap_76 = new HashMap<String, Pair<TerminologyBox, Map<String, String>>>();
    this.terminologyBoxes = _hashMap_76;
    HashMap<String, Pair<ConceptTreeDisjunction, Map<String, String>>> _hashMap_77 = new HashMap<String, Pair<ConceptTreeDisjunction, Map<String, String>>>();
    this.conceptTreeDisjunctions = _hashMap_77;
    HashMap<String, Pair<ConceptualEntitySingletonInstance, Map<String, String>>> _hashMap_78 = new HashMap<String, Pair<ConceptualEntitySingletonInstance, Map<String, String>>>();
    this.conceptualEntitySingletonInstances = _hashMap_78;
    HashMap<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>> _hashMap_79 = new HashMap<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>>();
    this.singletonInstanceStructuredDataPropertyContexts = _hashMap_79;
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
      ZipArchiveEntry _zipArchiveEntry_28 = new ZipArchiveEntry("UnreifiedRelationships.json");
      entry = _zipArchiveEntry_28;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.unreifiedRelationshipsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_29 = new ZipArchiveEntry("ChainRules.json");
      entry = _zipArchiveEntry_29;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.chainRulesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_30 = new ZipArchiveEntry("RuleBodySegments.json");
      entry = _zipArchiveEntry_30;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.ruleBodySegmentsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_31 = new ZipArchiveEntry("AspectPredicates.json");
      entry = _zipArchiveEntry_31;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.aspectPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_32 = new ZipArchiveEntry("ConceptPredicates.json");
      entry = _zipArchiveEntry_32;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_33 = new ZipArchiveEntry("ReifiedRelationshipPredicates.json");
      entry = _zipArchiveEntry_33;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_34 = new ZipArchiveEntry("ReifiedRelationshipPropertyPredicates.json");
      entry = _zipArchiveEntry_34;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipPropertyPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_35 = new ZipArchiveEntry("ReifiedRelationshipSourcePropertyPredicates.json");
      entry = _zipArchiveEntry_35;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipSourcePropertyPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_36 = new ZipArchiveEntry("ReifiedRelationshipTargetPropertyPredicates.json");
      entry = _zipArchiveEntry_36;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipTargetPropertyPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_37 = new ZipArchiveEntry("UnreifiedRelationshipPropertyPredicates.json");
      entry = _zipArchiveEntry_37;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.unreifiedRelationshipPropertyPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_38 = new ZipArchiveEntry("ReifiedRelationshipInversePropertyPredicates.json");
      entry = _zipArchiveEntry_38;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInversePropertyPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_39 = new ZipArchiveEntry("ReifiedRelationshipSourceInversePropertyPredicates.json");
      entry = _zipArchiveEntry_39;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipSourceInversePropertyPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_40 = new ZipArchiveEntry("ReifiedRelationshipTargetInversePropertyPredicates.json");
      entry = _zipArchiveEntry_40;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipTargetInversePropertyPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_41 = new ZipArchiveEntry("UnreifiedRelationshipInversePropertyPredicates.json");
      entry = _zipArchiveEntry_41;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.unreifiedRelationshipInversePropertyPredicatesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_42 = new ZipArchiveEntry("EntityExistentialRestrictionAxioms.json");
      entry = _zipArchiveEntry_42;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityExistentialRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_43 = new ZipArchiveEntry("EntityUniversalRestrictionAxioms.json");
      entry = _zipArchiveEntry_43;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityUniversalRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_44 = new ZipArchiveEntry("EntityScalarDataPropertyExistentialRestrictionAxioms.json");
      entry = _zipArchiveEntry_44;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyExistentialRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_45 = new ZipArchiveEntry("EntityScalarDataPropertyParticularRestrictionAxioms.json");
      entry = _zipArchiveEntry_45;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyParticularRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_46 = new ZipArchiveEntry("EntityScalarDataPropertyUniversalRestrictionAxioms.json");
      entry = _zipArchiveEntry_46;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityScalarDataPropertyUniversalRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_47 = new ZipArchiveEntry("EntityStructuredDataPropertyParticularRestrictionAxioms.json");
      entry = _zipArchiveEntry_47;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.entityStructuredDataPropertyParticularRestrictionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_48 = new ZipArchiveEntry("RestrictionStructuredDataPropertyTuples.json");
      entry = _zipArchiveEntry_48;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.restrictionStructuredDataPropertyTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_49 = new ZipArchiveEntry("RestrictionScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_49;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.restrictionScalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_50 = new ZipArchiveEntry("AspectSpecializationAxioms.json");
      entry = _zipArchiveEntry_50;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.aspectSpecializationAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_51 = new ZipArchiveEntry("ConceptSpecializationAxioms.json");
      entry = _zipArchiveEntry_51;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptSpecializationAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_52 = new ZipArchiveEntry("ReifiedRelationshipSpecializationAxioms.json");
      entry = _zipArchiveEntry_52;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipSpecializationAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_53 = new ZipArchiveEntry("SubDataPropertyOfAxioms.json");
      entry = _zipArchiveEntry_53;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.subDataPropertyOfAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_54 = new ZipArchiveEntry("SubObjectPropertyOfAxioms.json");
      entry = _zipArchiveEntry_54;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.subObjectPropertyOfAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_55 = new ZipArchiveEntry("RootConceptTaxonomyAxioms.json");
      entry = _zipArchiveEntry_55;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.rootConceptTaxonomyAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_56 = new ZipArchiveEntry("AnonymousConceptUnionAxioms.json");
      entry = _zipArchiveEntry_56;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.anonymousConceptUnionAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_57 = new ZipArchiveEntry("SpecificDisjointConceptAxioms.json");
      entry = _zipArchiveEntry_57;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.specificDisjointConceptAxiomsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_58 = new ZipArchiveEntry("ConceptInstances.json");
      entry = _zipArchiveEntry_58;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.conceptInstancesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_59 = new ZipArchiveEntry("ReifiedRelationshipInstances.json");
      entry = _zipArchiveEntry_59;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstancesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_60 = new ZipArchiveEntry("ReifiedRelationshipInstanceDomains.json");
      entry = _zipArchiveEntry_60;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstanceDomainsByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_61 = new ZipArchiveEntry("ReifiedRelationshipInstanceRanges.json");
      entry = _zipArchiveEntry_61;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.reifiedRelationshipInstanceRangesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_62 = new ZipArchiveEntry("UnreifiedRelationshipInstanceTuples.json");
      entry = _zipArchiveEntry_62;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.unreifiedRelationshipInstanceTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_63 = new ZipArchiveEntry("SingletonInstanceStructuredDataPropertyValues.json");
      entry = _zipArchiveEntry_63;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.singletonInstanceStructuredDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_64 = new ZipArchiveEntry("SingletonInstanceScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_64;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.singletonInstanceScalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_65 = new ZipArchiveEntry("StructuredDataPropertyTuples.json");
      entry = _zipArchiveEntry_65;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.structuredDataPropertyTuplesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_66 = new ZipArchiveEntry("ScalarDataPropertyValues.json");
      entry = _zipArchiveEntry_66;
      zos.putArchiveEntry(entry);
      try {
        zos.write(OMLSpecificationTables.scalarDataPropertyValuesByteArray(e));
      } finally {
        zos.closeArchiveEntry();
      }
      ZipArchiveEntry _zipArchiveEntry_67 = new ZipArchiveEntry("AnnotationPropertyValues.json");
      entry = _zipArchiveEntry_67;
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
  
  public static byte[] terminologyGraphsByteArray(final Extent e) {
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
  
  public static byte[] bundlesByteArray(final Extent e) {
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
  
  public static byte[] descriptionBoxesByteArray(final Extent e) {
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
  
  public static byte[] annotationPropertiesByteArray(final Extent e) {
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
  
  public static byte[] aspectsByteArray(final Extent e) {
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
  
  public static byte[] conceptsByteArray(final Extent e) {
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
  
  public static byte[] scalarsByteArray(final Extent e) {
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
  
  public static byte[] structuresByteArray(final Extent e) {
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
  
  public static byte[] conceptDesignationTerminologyAxiomsByteArray(final Extent e) {
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
  
  public static byte[] terminologyExtensionAxiomsByteArray(final Extent e) {
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
  
  public static byte[] terminologyNestingAxiomsByteArray(final Extent e) {
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
  
  public static byte[] bundledTerminologyAxiomsByteArray(final Extent e) {
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
  
  public static byte[] descriptionBoxExtendsClosedWorldDefinitionsByteArray(final Extent e) {
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
  
  public static byte[] descriptionBoxRefinementsByteArray(final Extent e) {
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
  
  public static byte[] binaryScalarRestrictionsByteArray(final Extent e) {
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
  
  public static byte[] iriScalarRestrictionsByteArray(final Extent e) {
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
  
  public static byte[] numericScalarRestrictionsByteArray(final Extent e) {
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
  
  public static byte[] plainLiteralScalarRestrictionsByteArray(final Extent e) {
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
  
  public static byte[] scalarOneOfRestrictionsByteArray(final Extent e) {
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
  
  public static byte[] scalarOneOfLiteralAxiomsByteArray(final Extent e) {
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
  
  public static byte[] stringScalarRestrictionsByteArray(final Extent e) {
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
  
  public static byte[] synonymScalarRestrictionsByteArray(final Extent e) {
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
  
  public static byte[] timeScalarRestrictionsByteArray(final Extent e) {
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
  
  public static byte[] entityScalarDataPropertiesByteArray(final Extent e) {
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
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsIdentityCriteria())));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.entityScalarDataProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] entityStructuredDataPropertiesByteArray(final Extent e) {
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
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsIdentityCriteria())));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.entityStructuredDataProperties(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] scalarDataPropertiesByteArray(final Extent e) {
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
  
  public static byte[] structuredDataPropertiesByteArray(final Extent e) {
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
  
  public static byte[] reifiedRelationshipsByteArray(final Extent e) {
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
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsAsymmetric())));
      pw.print(",");
      pw.print("\"isEssential\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsEssential())));
      pw.print(",");
      pw.print("\"isFunctional\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsFunctional())));
      pw.print(",");
      pw.print("\"isInverseEssential\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsInverseEssential())));
      pw.print(",");
      pw.print("\"isInverseFunctional\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsInverseFunctional())));
      pw.print(",");
      pw.print("\"isIrreflexive\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsIrreflexive())));
      pw.print(",");
      pw.print("\"isReflexive\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsReflexive())));
      pw.print(",");
      pw.print("\"isSymmetric\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsSymmetric())));
      pw.print(",");
      pw.print("\"isTransitive\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsTransitive())));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.print(",");
      pw.print("\"unreifiedPropertyName\":");
      pw.print(OMLTables.toString(it.getUnreifiedPropertyName()));
      pw.print(",");
      pw.print("\"unreifiedInversePropertyName\":");
      pw.print(OMLTables.toString(it.getUnreifiedInversePropertyName()));
      pw.println("}");
    };
    OMLTables.reifiedRelationships(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] unreifiedRelationshipsByteArray(final Extent e) {
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
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsAsymmetric())));
      pw.print(",");
      pw.print("\"isEssential\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsEssential())));
      pw.print(",");
      pw.print("\"isFunctional\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsFunctional())));
      pw.print(",");
      pw.print("\"isInverseEssential\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsInverseEssential())));
      pw.print(",");
      pw.print("\"isInverseFunctional\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsInverseFunctional())));
      pw.print(",");
      pw.print("\"isIrreflexive\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsIrreflexive())));
      pw.print(",");
      pw.print("\"isReflexive\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsReflexive())));
      pw.print(",");
      pw.print("\"isSymmetric\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsSymmetric())));
      pw.print(",");
      pw.print("\"isTransitive\":");
      pw.print(OMLTables.toString(Boolean.valueOf(it.isIsTransitive())));
      pw.print(",");
      pw.print("\"name\":");
      pw.print(OMLTables.toString(it.name()));
      pw.println("}");
    };
    OMLTables.unreifiedRelationships(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] chainRulesByteArray(final Extent e) {
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
  
  public static byte[] ruleBodySegmentsByteArray(final Extent e) {
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
  
  public static byte[] aspectPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<AspectPredicate> _function = (AspectPredicate it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"aspectUUID\":");
      pw.print("\"");
      pw.print(it.getAspect().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"bodySegmentUUID\":");
      pw.print("\"");
      pw.print(it.getBodySegment().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.aspectPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] conceptPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ConceptPredicate> _function = (ConceptPredicate it) -> {
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
      pw.print("\"conceptUUID\":");
      pw.print("\"");
      pw.print(it.getConcept().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.conceptPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] reifiedRelationshipPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipPredicate> _function = (ReifiedRelationshipPredicate it) -> {
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
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] reifiedRelationshipPropertyPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipPropertyPredicate> _function = (ReifiedRelationshipPropertyPredicate it) -> {
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
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipPropertyPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] reifiedRelationshipSourcePropertyPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipSourcePropertyPredicate> _function = (ReifiedRelationshipSourcePropertyPredicate it) -> {
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
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipSourcePropertyPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] reifiedRelationshipTargetPropertyPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipTargetPropertyPredicate> _function = (ReifiedRelationshipTargetPropertyPredicate it) -> {
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
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipTargetPropertyPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] unreifiedRelationshipPropertyPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<UnreifiedRelationshipPropertyPredicate> _function = (UnreifiedRelationshipPropertyPredicate it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"unreifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getUnreifiedRelationship().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"bodySegmentUUID\":");
      pw.print("\"");
      pw.print(it.getBodySegment().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.unreifiedRelationshipPropertyPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] reifiedRelationshipInversePropertyPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipInversePropertyPredicate> _function = (ReifiedRelationshipInversePropertyPredicate it) -> {
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
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipInversePropertyPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] reifiedRelationshipSourceInversePropertyPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipSourceInversePropertyPredicate> _function = (ReifiedRelationshipSourceInversePropertyPredicate it) -> {
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
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipSourceInversePropertyPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] reifiedRelationshipTargetInversePropertyPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ReifiedRelationshipTargetInversePropertyPredicate> _function = (ReifiedRelationshipTargetInversePropertyPredicate it) -> {
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
      pw.print("\"reifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getReifiedRelationship().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.reifiedRelationshipTargetInversePropertyPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] unreifiedRelationshipInversePropertyPredicatesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<UnreifiedRelationshipInversePropertyPredicate> _function = (UnreifiedRelationshipInversePropertyPredicate it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"unreifiedRelationshipUUID\":");
      pw.print("\"");
      pw.print(it.getUnreifiedRelationship().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"bodySegmentUUID\":");
      pw.print("\"");
      pw.print(it.getBodySegment().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.unreifiedRelationshipInversePropertyPredicates(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] entityExistentialRestrictionAxiomsByteArray(final Extent e) {
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
      pw.print("\"restrictedRelationUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRelation().uuid());
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
      pw.println("}");
    };
    OMLTables.entityExistentialRestrictionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] entityUniversalRestrictionAxiomsByteArray(final Extent e) {
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
      pw.print("\"restrictedRelationUUID\":");
      pw.print("\"");
      pw.print(it.getRestrictedRelation().uuid());
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
      pw.println("}");
    };
    OMLTables.entityUniversalRestrictionAxioms(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] entityScalarDataPropertyExistentialRestrictionAxiomsByteArray(final Extent e) {
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
  
  public static byte[] entityScalarDataPropertyParticularRestrictionAxiomsByteArray(final Extent e) {
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
  
  public static byte[] entityScalarDataPropertyUniversalRestrictionAxiomsByteArray(final Extent e) {
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
  
  public static byte[] entityStructuredDataPropertyParticularRestrictionAxiomsByteArray(final Extent e) {
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
  
  public static byte[] restrictionStructuredDataPropertyTuplesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<RestrictionStructuredDataPropertyTuple> _function = (RestrictionStructuredDataPropertyTuple it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyContextUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataPropertyContext().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.restrictionStructuredDataPropertyTuples(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] restrictionScalarDataPropertyValuesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<RestrictionScalarDataPropertyValue> _function = (RestrictionScalarDataPropertyValue it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
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
      pw.print("\"structuredDataPropertyContextUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataPropertyContext().uuid());
      pw.print("\"");
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
  
  public static byte[] aspectSpecializationAxiomsByteArray(final Extent e) {
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
  
  public static byte[] conceptSpecializationAxiomsByteArray(final Extent e) {
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
  
  public static byte[] reifiedRelationshipSpecializationAxiomsByteArray(final Extent e) {
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
  
  public static byte[] subDataPropertyOfAxiomsByteArray(final Extent e) {
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
  
  public static byte[] subObjectPropertyOfAxiomsByteArray(final Extent e) {
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
  
  public static byte[] rootConceptTaxonomyAxiomsByteArray(final Extent e) {
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
  
  public static byte[] anonymousConceptUnionAxiomsByteArray(final Extent e) {
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
  
  public static byte[] specificDisjointConceptAxiomsByteArray(final Extent e) {
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
  
  public static byte[] conceptInstancesByteArray(final Extent e) {
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
  
  public static byte[] reifiedRelationshipInstancesByteArray(final Extent e) {
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
      pw.print("\"singletonReifiedRelationshipClassifierUUID\":");
      pw.print("\"");
      pw.print(it.getSingletonReifiedRelationshipClassifier().uuid());
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
  
  public static byte[] reifiedRelationshipInstanceDomainsByteArray(final Extent e) {
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
  
  public static byte[] reifiedRelationshipInstanceRangesByteArray(final Extent e) {
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
  
  public static byte[] unreifiedRelationshipInstanceTuplesByteArray(final Extent e) {
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
  
  public static byte[] singletonInstanceStructuredDataPropertyValuesByteArray(final Extent e) {
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
  
  public static byte[] singletonInstanceScalarDataPropertyValuesByteArray(final Extent e) {
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
  
  public static byte[] structuredDataPropertyTuplesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<StructuredDataPropertyTuple> _function = (StructuredDataPropertyTuple it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataProperty().uuid());
      pw.print("\"");
      pw.print(",");
      pw.print("\"structuredDataPropertyContextUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataPropertyContext().uuid());
      pw.print("\"");
      pw.println("}");
    };
    OMLTables.structuredDataPropertyTuples(e).forEach(_function);
    pw.close();
    return bos.toByteArray();
  }
  
  public static byte[] scalarDataPropertyValuesByteArray(final Extent e) {
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    final PrintWriter pw = new PrintWriter(bos);
    final Consumer<ScalarDataPropertyValue> _function = (ScalarDataPropertyValue it) -> {
      pw.print("{");
      pw.print("\"uuid\":");
      pw.print("\"");
      pw.print(it.uuid());
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
      pw.print("\"structuredDataPropertyContextUUID\":");
      pw.print("\"");
      pw.print(it.getStructuredDataPropertyContext().uuid());
      pw.print("\"");
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
  
  public static byte[] annotationPropertyValuesByteArray(final Extent e) {
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
  
  public static void load(final OMLZipResourceSet rs, final OMLZipResource r, final File omlZipFile) {
    try {
      final OMLSpecificationTables tables = new OMLSpecificationTables();
      final ZipFile zip = new ZipFile(omlZipFile);
      final Consumer<ZipArchiveEntry> _function = (ZipArchiveEntry ze) -> {
        try {
          final InputStream is = zip.getInputStream(ze);
          InputStreamReader _inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
          final BufferedReader buffer = new BufferedReader(_inputStreamReader);
          final ArrayList<String> lines = new ArrayList<String>();
          Iterables.<String>addAll(lines, IteratorExtensions.<String>toIterable(buffer.lines().iterator()));
          String _name = ze.getName();
          if (_name != null) {
            switch (_name) {
              case "TerminologyGraphs.json":
                tables.readTerminologyGraphs(lines);
                break;
              case "Bundles.json":
                tables.readBundles(lines);
                break;
              case "DescriptionBoxes.json":
                tables.readDescriptionBoxes(lines);
                break;
              case "AnnotationProperties.json":
                tables.readAnnotationProperties(lines);
                break;
              case "Aspects.json":
                tables.readAspects(lines);
                break;
              case "Concepts.json":
                tables.readConcepts(lines);
                break;
              case "Scalars.json":
                tables.readScalars(lines);
                break;
              case "Structures.json":
                tables.readStructures(lines);
                break;
              case "ConceptDesignationTerminologyAxioms.json":
                tables.readConceptDesignationTerminologyAxioms(lines);
                break;
              case "TerminologyExtensionAxioms.json":
                tables.readTerminologyExtensionAxioms(lines);
                break;
              case "TerminologyNestingAxioms.json":
                tables.readTerminologyNestingAxioms(lines);
                break;
              case "BundledTerminologyAxioms.json":
                tables.readBundledTerminologyAxioms(lines);
                break;
              case "DescriptionBoxExtendsClosedWorldDefinitions.json":
                tables.readDescriptionBoxExtendsClosedWorldDefinitions(lines);
                break;
              case "DescriptionBoxRefinements.json":
                tables.readDescriptionBoxRefinements(lines);
                break;
              case "BinaryScalarRestrictions.json":
                tables.readBinaryScalarRestrictions(lines);
                break;
              case "IRIScalarRestrictions.json":
                tables.readIRIScalarRestrictions(lines);
                break;
              case "NumericScalarRestrictions.json":
                tables.readNumericScalarRestrictions(lines);
                break;
              case "PlainLiteralScalarRestrictions.json":
                tables.readPlainLiteralScalarRestrictions(lines);
                break;
              case "ScalarOneOfRestrictions.json":
                tables.readScalarOneOfRestrictions(lines);
                break;
              case "ScalarOneOfLiteralAxioms.json":
                tables.readScalarOneOfLiteralAxioms(lines);
                break;
              case "StringScalarRestrictions.json":
                tables.readStringScalarRestrictions(lines);
                break;
              case "SynonymScalarRestrictions.json":
                tables.readSynonymScalarRestrictions(lines);
                break;
              case "TimeScalarRestrictions.json":
                tables.readTimeScalarRestrictions(lines);
                break;
              case "EntityScalarDataProperties.json":
                tables.readEntityScalarDataProperties(lines);
                break;
              case "EntityStructuredDataProperties.json":
                tables.readEntityStructuredDataProperties(lines);
                break;
              case "ScalarDataProperties.json":
                tables.readScalarDataProperties(lines);
                break;
              case "StructuredDataProperties.json":
                tables.readStructuredDataProperties(lines);
                break;
              case "ReifiedRelationships.json":
                tables.readReifiedRelationships(lines);
                break;
              case "UnreifiedRelationships.json":
                tables.readUnreifiedRelationships(lines);
                break;
              case "ChainRules.json":
                tables.readChainRules(lines);
                break;
              case "RuleBodySegments.json":
                tables.readRuleBodySegments(lines);
                break;
              case "AspectPredicates.json":
                tables.readAspectPredicates(lines);
                break;
              case "ConceptPredicates.json":
                tables.readConceptPredicates(lines);
                break;
              case "ReifiedRelationshipPredicates.json":
                tables.readReifiedRelationshipPredicates(lines);
                break;
              case "ReifiedRelationshipPropertyPredicates.json":
                tables.readReifiedRelationshipPropertyPredicates(lines);
                break;
              case "ReifiedRelationshipSourcePropertyPredicates.json":
                tables.readReifiedRelationshipSourcePropertyPredicates(lines);
                break;
              case "ReifiedRelationshipTargetPropertyPredicates.json":
                tables.readReifiedRelationshipTargetPropertyPredicates(lines);
                break;
              case "UnreifiedRelationshipPropertyPredicates.json":
                tables.readUnreifiedRelationshipPropertyPredicates(lines);
                break;
              case "ReifiedRelationshipInversePropertyPredicates.json":
                tables.readReifiedRelationshipInversePropertyPredicates(lines);
                break;
              case "ReifiedRelationshipSourceInversePropertyPredicates.json":
                tables.readReifiedRelationshipSourceInversePropertyPredicates(lines);
                break;
              case "ReifiedRelationshipTargetInversePropertyPredicates.json":
                tables.readReifiedRelationshipTargetInversePropertyPredicates(lines);
                break;
              case "UnreifiedRelationshipInversePropertyPredicates.json":
                tables.readUnreifiedRelationshipInversePropertyPredicates(lines);
                break;
              case "EntityExistentialRestrictionAxioms.json":
                tables.readEntityExistentialRestrictionAxioms(lines);
                break;
              case "EntityUniversalRestrictionAxioms.json":
                tables.readEntityUniversalRestrictionAxioms(lines);
                break;
              case "EntityScalarDataPropertyExistentialRestrictionAxioms.json":
                tables.readEntityScalarDataPropertyExistentialRestrictionAxioms(lines);
                break;
              case "EntityScalarDataPropertyParticularRestrictionAxioms.json":
                tables.readEntityScalarDataPropertyParticularRestrictionAxioms(lines);
                break;
              case "EntityScalarDataPropertyUniversalRestrictionAxioms.json":
                tables.readEntityScalarDataPropertyUniversalRestrictionAxioms(lines);
                break;
              case "EntityStructuredDataPropertyParticularRestrictionAxioms.json":
                tables.readEntityStructuredDataPropertyParticularRestrictionAxioms(lines);
                break;
              case "RestrictionStructuredDataPropertyTuples.json":
                tables.readRestrictionStructuredDataPropertyTuples(lines);
                break;
              case "RestrictionScalarDataPropertyValues.json":
                tables.readRestrictionScalarDataPropertyValues(lines);
                break;
              case "AspectSpecializationAxioms.json":
                tables.readAspectSpecializationAxioms(lines);
                break;
              case "ConceptSpecializationAxioms.json":
                tables.readConceptSpecializationAxioms(lines);
                break;
              case "ReifiedRelationshipSpecializationAxioms.json":
                tables.readReifiedRelationshipSpecializationAxioms(lines);
                break;
              case "SubDataPropertyOfAxioms.json":
                tables.readSubDataPropertyOfAxioms(lines);
                break;
              case "SubObjectPropertyOfAxioms.json":
                tables.readSubObjectPropertyOfAxioms(lines);
                break;
              case "RootConceptTaxonomyAxioms.json":
                tables.readRootConceptTaxonomyAxioms(lines);
                break;
              case "AnonymousConceptUnionAxioms.json":
                tables.readAnonymousConceptUnionAxioms(lines);
                break;
              case "SpecificDisjointConceptAxioms.json":
                tables.readSpecificDisjointConceptAxioms(lines);
                break;
              case "ConceptInstances.json":
                tables.readConceptInstances(lines);
                break;
              case "ReifiedRelationshipInstances.json":
                tables.readReifiedRelationshipInstances(lines);
                break;
              case "ReifiedRelationshipInstanceDomains.json":
                tables.readReifiedRelationshipInstanceDomains(lines);
                break;
              case "ReifiedRelationshipInstanceRanges.json":
                tables.readReifiedRelationshipInstanceRanges(lines);
                break;
              case "UnreifiedRelationshipInstanceTuples.json":
                tables.readUnreifiedRelationshipInstanceTuples(lines);
                break;
              case "SingletonInstanceStructuredDataPropertyValues.json":
                tables.readSingletonInstanceStructuredDataPropertyValues(lines);
                break;
              case "SingletonInstanceScalarDataPropertyValues.json":
                tables.readSingletonInstanceScalarDataPropertyValues(lines);
                break;
              case "StructuredDataPropertyTuples.json":
                tables.readStructuredDataPropertyTuples(lines);
                break;
              case "ScalarDataPropertyValues.json":
                tables.readScalarDataPropertyValues(lines);
                break;
              case "AnnotationPropertyValues.json":
                tables.readAnnotationPropertyValues(lines);
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
      tables.resolve(rs, r);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void readTerminologyGraphs(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final TerminologyGraph oml = this.omlGraphsFactory.createTerminologyGraph();
      final String uuid = kv.remove("uuid");
      oml.setKind(OMLTables.toTerminologyKind(kv.remove("kind")));
      oml.setIri(OMLTables.toIRI(kv.remove("iri")));
      final Pair<TerminologyGraph, Map<String, String>> pair = new Pair<TerminologyGraph, Map<String, String>>(oml, kv);
      this.terminologyGraphs.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readBundles(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final Bundle oml = this.omlBundlesFactory.createBundle();
      final String uuid = kv.remove("uuid");
      oml.setKind(OMLTables.toTerminologyKind(kv.remove("kind")));
      oml.setIri(OMLTables.toIRI(kv.remove("iri")));
      final Pair<Bundle, Map<String, String>> pair = new Pair<Bundle, Map<String, String>>(oml, kv);
      this.bundles.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readDescriptionBoxes(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final DescriptionBox oml = this.omlDescriptionsFactory.createDescriptionBox();
      final String uuid = kv.remove("uuid");
      oml.setKind(OMLTables.toDescriptionKind(kv.remove("kind")));
      oml.setIri(OMLTables.toIRI(kv.remove("iri")));
      final Pair<DescriptionBox, Map<String, String>> pair = new Pair<DescriptionBox, Map<String, String>>(oml, kv);
      this.descriptionBoxes.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readAnnotationProperties(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final AnnotationProperty oml = this.omlCommonFactory.createAnnotationProperty();
      final String uuid = kv.remove("uuid");
      oml.setIri(OMLTables.toIRI(kv.remove("iri")));
      oml.setAbbrevIRI(OMLTables.toAbbrevIRI(kv.remove("abbrevIRI")));
      final Pair<AnnotationProperty, Map<String, String>> pair = new Pair<AnnotationProperty, Map<String, String>>(oml, kv);
      this.annotationProperties.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readAspects(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final Aspect oml = this.omlTerminologiesFactory.createAspect();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<Aspect, Map<String, String>> pair = new Pair<Aspect, Map<String, String>>(oml, kv);
      this.aspects.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readConcepts(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final Concept oml = this.omlTerminologiesFactory.createConcept();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<Concept, Map<String, String>> pair = new Pair<Concept, Map<String, String>>(oml, kv);
      this.concepts.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readScalars(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final Scalar oml = this.omlTerminologiesFactory.createScalar();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<Scalar, Map<String, String>> pair = new Pair<Scalar, Map<String, String>>(oml, kv);
      this.scalars.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readStructures(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final Structure oml = this.omlTerminologiesFactory.createStructure();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<Structure, Map<String, String>> pair = new Pair<Structure, Map<String, String>>(oml, kv);
      this.structures.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readConceptDesignationTerminologyAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ConceptDesignationTerminologyAxiom oml = this.omlGraphsFactory.createConceptDesignationTerminologyAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> pair = new Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>(oml, kv);
      this.conceptDesignationTerminologyAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readTerminologyExtensionAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final TerminologyExtensionAxiom oml = this.omlTerminologiesFactory.createTerminologyExtensionAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<TerminologyExtensionAxiom, Map<String, String>> pair = new Pair<TerminologyExtensionAxiom, Map<String, String>>(oml, kv);
      this.terminologyExtensionAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readTerminologyNestingAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final TerminologyNestingAxiom oml = this.omlGraphsFactory.createTerminologyNestingAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<TerminologyNestingAxiom, Map<String, String>> pair = new Pair<TerminologyNestingAxiom, Map<String, String>>(oml, kv);
      this.terminologyNestingAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readBundledTerminologyAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final BundledTerminologyAxiom oml = this.omlBundlesFactory.createBundledTerminologyAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<BundledTerminologyAxiom, Map<String, String>> pair = new Pair<BundledTerminologyAxiom, Map<String, String>>(oml, kv);
      this.bundledTerminologyAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readDescriptionBoxExtendsClosedWorldDefinitions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final DescriptionBoxExtendsClosedWorldDefinitions oml = this.omlDescriptionsFactory.createDescriptionBoxExtendsClosedWorldDefinitions();
      final String uuid = kv.remove("uuid");
      final Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> pair = new Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>(oml, kv);
      this.descriptionBoxExtendsClosedWorldDefinitions.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readDescriptionBoxRefinements(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final DescriptionBoxRefinement oml = this.omlDescriptionsFactory.createDescriptionBoxRefinement();
      final String uuid = kv.remove("uuid");
      final Pair<DescriptionBoxRefinement, Map<String, String>> pair = new Pair<DescriptionBoxRefinement, Map<String, String>>(oml, kv);
      this.descriptionBoxRefinements.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readBinaryScalarRestrictions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final BinaryScalarRestriction oml = this.omlTerminologiesFactory.createBinaryScalarRestriction();
      final String uuid = kv.remove("uuid");
      oml.setLength(OMLTables.toPositiveIntegerLiteral(kv.remove("length")));
      oml.setMinLength(OMLTables.toPositiveIntegerLiteral(kv.remove("minLength")));
      oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength")));
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<BinaryScalarRestriction, Map<String, String>> pair = new Pair<BinaryScalarRestriction, Map<String, String>>(oml, kv);
      this.binaryScalarRestrictions.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readIRIScalarRestrictions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final IRIScalarRestriction oml = this.omlTerminologiesFactory.createIRIScalarRestriction();
      final String uuid = kv.remove("uuid");
      oml.setLength(OMLTables.toPositiveIntegerLiteral(kv.remove("length")));
      oml.setMinLength(OMLTables.toPositiveIntegerLiteral(kv.remove("minLength")));
      oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength")));
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      oml.setPattern(OMLTables.toLiteralPattern(kv.remove("pattern")));
      final Pair<IRIScalarRestriction, Map<String, String>> pair = new Pair<IRIScalarRestriction, Map<String, String>>(oml, kv);
      this.iriScalarRestrictions.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readNumericScalarRestrictions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final NumericScalarRestriction oml = this.omlTerminologiesFactory.createNumericScalarRestriction();
      final String uuid = kv.remove("uuid");
      oml.setMinExclusive(OMLTables.toLiteralNumber(kv.remove("minExclusive")));
      oml.setMinInclusive(OMLTables.toLiteralNumber(kv.remove("minInclusive")));
      oml.setMaxExclusive(OMLTables.toLiteralNumber(kv.remove("maxExclusive")));
      oml.setMaxInclusive(OMLTables.toLiteralNumber(kv.remove("maxInclusive")));
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<NumericScalarRestriction, Map<String, String>> pair = new Pair<NumericScalarRestriction, Map<String, String>>(oml, kv);
      this.numericScalarRestrictions.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readPlainLiteralScalarRestrictions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
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
    };
    kvs.forEach(_function);
  }
  
  protected void readScalarOneOfRestrictions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ScalarOneOfRestriction oml = this.omlTerminologiesFactory.createScalarOneOfRestriction();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<ScalarOneOfRestriction, Map<String, String>> pair = new Pair<ScalarOneOfRestriction, Map<String, String>>(oml, kv);
      this.scalarOneOfRestrictions.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readScalarOneOfLiteralAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ScalarOneOfLiteralAxiom oml = this.omlTerminologiesFactory.createScalarOneOfLiteralAxiom();
      final String uuid = kv.remove("uuid");
      oml.setValue(OMLTables.toLiteralValue(kv.remove("value")));
      final Pair<ScalarOneOfLiteralAxiom, Map<String, String>> pair = new Pair<ScalarOneOfLiteralAxiom, Map<String, String>>(oml, kv);
      this.scalarOneOfLiteralAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readStringScalarRestrictions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final StringScalarRestriction oml = this.omlTerminologiesFactory.createStringScalarRestriction();
      final String uuid = kv.remove("uuid");
      oml.setLength(OMLTables.toPositiveIntegerLiteral(kv.remove("length")));
      oml.setMinLength(OMLTables.toPositiveIntegerLiteral(kv.remove("minLength")));
      oml.setMaxLength(OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength")));
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      oml.setPattern(OMLTables.toLiteralPattern(kv.remove("pattern")));
      final Pair<StringScalarRestriction, Map<String, String>> pair = new Pair<StringScalarRestriction, Map<String, String>>(oml, kv);
      this.stringScalarRestrictions.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readSynonymScalarRestrictions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final SynonymScalarRestriction oml = this.omlTerminologiesFactory.createSynonymScalarRestriction();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<SynonymScalarRestriction, Map<String, String>> pair = new Pair<SynonymScalarRestriction, Map<String, String>>(oml, kv);
      this.synonymScalarRestrictions.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readTimeScalarRestrictions(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final TimeScalarRestriction oml = this.omlTerminologiesFactory.createTimeScalarRestriction();
      final String uuid = kv.remove("uuid");
      oml.setMinExclusive(OMLTables.toLiteralDateTime(kv.remove("minExclusive")));
      oml.setMinInclusive(OMLTables.toLiteralDateTime(kv.remove("minInclusive")));
      oml.setMaxExclusive(OMLTables.toLiteralDateTime(kv.remove("maxExclusive")));
      oml.setMaxInclusive(OMLTables.toLiteralDateTime(kv.remove("maxInclusive")));
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<TimeScalarRestriction, Map<String, String>> pair = new Pair<TimeScalarRestriction, Map<String, String>>(oml, kv);
      this.timeScalarRestrictions.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readEntityScalarDataProperties(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final EntityScalarDataProperty oml = this.omlTerminologiesFactory.createEntityScalarDataProperty();
      final String uuid = kv.remove("uuid");
      oml.setIsIdentityCriteria((OMLTables.toEBoolean(kv.remove("isIdentityCriteria"))).booleanValue());
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<EntityScalarDataProperty, Map<String, String>> pair = new Pair<EntityScalarDataProperty, Map<String, String>>(oml, kv);
      this.entityScalarDataProperties.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readEntityStructuredDataProperties(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final EntityStructuredDataProperty oml = this.omlTerminologiesFactory.createEntityStructuredDataProperty();
      final String uuid = kv.remove("uuid");
      oml.setIsIdentityCriteria((OMLTables.toEBoolean(kv.remove("isIdentityCriteria"))).booleanValue());
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<EntityStructuredDataProperty, Map<String, String>> pair = new Pair<EntityStructuredDataProperty, Map<String, String>>(oml, kv);
      this.entityStructuredDataProperties.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readScalarDataProperties(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ScalarDataProperty oml = this.omlTerminologiesFactory.createScalarDataProperty();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<ScalarDataProperty, Map<String, String>> pair = new Pair<ScalarDataProperty, Map<String, String>>(oml, kv);
      this.scalarDataProperties.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readStructuredDataProperties(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final StructuredDataProperty oml = this.omlTerminologiesFactory.createStructuredDataProperty();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<StructuredDataProperty, Map<String, String>> pair = new Pair<StructuredDataProperty, Map<String, String>>(oml, kv);
      this.structuredDataProperties.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationships(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
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
      oml.setUnreifiedPropertyName(OMLTables.toLocalName(kv.remove("unreifiedPropertyName")));
      oml.setUnreifiedInversePropertyName(OMLTables.toLocalName(kv.remove("unreifiedInversePropertyName")));
      final Pair<ReifiedRelationship, Map<String, String>> pair = new Pair<ReifiedRelationship, Map<String, String>>(oml, kv);
      this.reifiedRelationships.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readUnreifiedRelationships(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
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
    };
    kvs.forEach(_function);
  }
  
  protected void readChainRules(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ChainRule oml = this.omlTerminologiesFactory.createChainRule();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<ChainRule, Map<String, String>> pair = new Pair<ChainRule, Map<String, String>>(oml, kv);
      this.chainRules.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readRuleBodySegments(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final RuleBodySegment oml = this.omlTerminologiesFactory.createRuleBodySegment();
      final String uuid = kv.remove("uuid");
      final Pair<RuleBodySegment, Map<String, String>> pair = new Pair<RuleBodySegment, Map<String, String>>(oml, kv);
      this.ruleBodySegments.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readAspectPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final AspectPredicate oml = this.omlTerminologiesFactory.createAspectPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<AspectPredicate, Map<String, String>> pair = new Pair<AspectPredicate, Map<String, String>>(oml, kv);
      this.aspectPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readConceptPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ConceptPredicate oml = this.omlTerminologiesFactory.createConceptPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<ConceptPredicate, Map<String, String>> pair = new Pair<ConceptPredicate, Map<String, String>>(oml, kv);
      this.conceptPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipPredicate oml = this.omlTerminologiesFactory.createReifiedRelationshipPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipPredicate, Map<String, String>>(oml, kv);
      this.reifiedRelationshipPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipPropertyPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipPropertyPredicate oml = this.omlTerminologiesFactory.createReifiedRelationshipPropertyPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>>(oml, kv);
      this.reifiedRelationshipPropertyPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipSourcePropertyPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipSourcePropertyPredicate oml = this.omlTerminologiesFactory.createReifiedRelationshipSourcePropertyPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>>(oml, kv);
      this.reifiedRelationshipSourcePropertyPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipTargetPropertyPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipTargetPropertyPredicate oml = this.omlTerminologiesFactory.createReifiedRelationshipTargetPropertyPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>>(oml, kv);
      this.reifiedRelationshipTargetPropertyPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readUnreifiedRelationshipPropertyPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final UnreifiedRelationshipPropertyPredicate oml = this.omlTerminologiesFactory.createUnreifiedRelationshipPropertyPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>> pair = new Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>>(oml, kv);
      this.unreifiedRelationshipPropertyPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipInversePropertyPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipInversePropertyPredicate oml = this.omlTerminologiesFactory.createReifiedRelationshipInversePropertyPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>>(oml, kv);
      this.reifiedRelationshipInversePropertyPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipSourceInversePropertyPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipSourceInversePropertyPredicate oml = this.omlTerminologiesFactory.createReifiedRelationshipSourceInversePropertyPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>>(oml, kv);
      this.reifiedRelationshipSourceInversePropertyPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipTargetInversePropertyPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipTargetInversePropertyPredicate oml = this.omlTerminologiesFactory.createReifiedRelationshipTargetInversePropertyPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>>(oml, kv);
      this.reifiedRelationshipTargetInversePropertyPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readUnreifiedRelationshipInversePropertyPredicates(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final UnreifiedRelationshipInversePropertyPredicate oml = this.omlTerminologiesFactory.createUnreifiedRelationshipInversePropertyPredicate();
      final String uuid = kv.remove("uuid");
      final Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>> pair = new Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>>(oml, kv);
      this.unreifiedRelationshipInversePropertyPredicates.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readEntityExistentialRestrictionAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final EntityExistentialRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityExistentialRestrictionAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<EntityExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityExistentialRestrictionAxiom, Map<String, String>>(oml, kv);
      this.entityExistentialRestrictionAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readEntityUniversalRestrictionAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final EntityUniversalRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityUniversalRestrictionAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<EntityUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityUniversalRestrictionAxiom, Map<String, String>>(oml, kv);
      this.entityUniversalRestrictionAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readEntityScalarDataPropertyExistentialRestrictionAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final EntityScalarDataPropertyExistentialRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityScalarDataPropertyExistentialRestrictionAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>(oml, kv);
      this.entityScalarDataPropertyExistentialRestrictionAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readEntityScalarDataPropertyParticularRestrictionAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final EntityScalarDataPropertyParticularRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityScalarDataPropertyParticularRestrictionAxiom();
      final String uuid = kv.remove("uuid");
      oml.setLiteralValue(OMLTables.toLiteralValue(kv.remove("literalValue")));
      final Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>(oml, kv);
      this.entityScalarDataPropertyParticularRestrictionAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readEntityScalarDataPropertyUniversalRestrictionAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final EntityScalarDataPropertyUniversalRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityScalarDataPropertyUniversalRestrictionAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>(oml, kv);
      this.entityScalarDataPropertyUniversalRestrictionAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readEntityStructuredDataPropertyParticularRestrictionAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final EntityStructuredDataPropertyParticularRestrictionAxiom oml = this.omlTerminologiesFactory.createEntityStructuredDataPropertyParticularRestrictionAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>(oml, kv);
      this.entityStructuredDataPropertyParticularRestrictionAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readRestrictionStructuredDataPropertyTuples(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final RestrictionStructuredDataPropertyTuple oml = this.omlTerminologiesFactory.createRestrictionStructuredDataPropertyTuple();
      final String uuid = kv.remove("uuid");
      final Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>> pair = new Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>(oml, kv);
      this.restrictionStructuredDataPropertyTuples.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readRestrictionScalarDataPropertyValues(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final RestrictionScalarDataPropertyValue oml = this.omlTerminologiesFactory.createRestrictionScalarDataPropertyValue();
      final String uuid = kv.remove("uuid");
      oml.setScalarPropertyValue(OMLTables.toLiteralValue(kv.remove("scalarPropertyValue")));
      final Pair<RestrictionScalarDataPropertyValue, Map<String, String>> pair = new Pair<RestrictionScalarDataPropertyValue, Map<String, String>>(oml, kv);
      this.restrictionScalarDataPropertyValues.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readAspectSpecializationAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final AspectSpecializationAxiom oml = this.omlTerminologiesFactory.createAspectSpecializationAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<AspectSpecializationAxiom, Map<String, String>> pair = new Pair<AspectSpecializationAxiom, Map<String, String>>(oml, kv);
      this.aspectSpecializationAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readConceptSpecializationAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ConceptSpecializationAxiom oml = this.omlTerminologiesFactory.createConceptSpecializationAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<ConceptSpecializationAxiom, Map<String, String>> pair = new Pair<ConceptSpecializationAxiom, Map<String, String>>(oml, kv);
      this.conceptSpecializationAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipSpecializationAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipSpecializationAxiom oml = this.omlTerminologiesFactory.createReifiedRelationshipSpecializationAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>> pair = new Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>(oml, kv);
      this.reifiedRelationshipSpecializationAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readSubDataPropertyOfAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final SubDataPropertyOfAxiom oml = this.omlTerminologiesFactory.createSubDataPropertyOfAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<SubDataPropertyOfAxiom, Map<String, String>> pair = new Pair<SubDataPropertyOfAxiom, Map<String, String>>(oml, kv);
      this.subDataPropertyOfAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readSubObjectPropertyOfAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final SubObjectPropertyOfAxiom oml = this.omlTerminologiesFactory.createSubObjectPropertyOfAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<SubObjectPropertyOfAxiom, Map<String, String>> pair = new Pair<SubObjectPropertyOfAxiom, Map<String, String>>(oml, kv);
      this.subObjectPropertyOfAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readRootConceptTaxonomyAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final RootConceptTaxonomyAxiom oml = this.omlBundlesFactory.createRootConceptTaxonomyAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<RootConceptTaxonomyAxiom, Map<String, String>> pair = new Pair<RootConceptTaxonomyAxiom, Map<String, String>>(oml, kv);
      this.rootConceptTaxonomyAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readAnonymousConceptUnionAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final AnonymousConceptUnionAxiom oml = this.omlBundlesFactory.createAnonymousConceptUnionAxiom();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<AnonymousConceptUnionAxiom, Map<String, String>> pair = new Pair<AnonymousConceptUnionAxiom, Map<String, String>>(oml, kv);
      this.anonymousConceptUnionAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readSpecificDisjointConceptAxioms(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final SpecificDisjointConceptAxiom oml = this.omlBundlesFactory.createSpecificDisjointConceptAxiom();
      final String uuid = kv.remove("uuid");
      final Pair<SpecificDisjointConceptAxiom, Map<String, String>> pair = new Pair<SpecificDisjointConceptAxiom, Map<String, String>>(oml, kv);
      this.specificDisjointConceptAxioms.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readConceptInstances(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ConceptInstance oml = this.omlDescriptionsFactory.createConceptInstance();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<ConceptInstance, Map<String, String>> pair = new Pair<ConceptInstance, Map<String, String>>(oml, kv);
      this.conceptInstances.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipInstances(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipInstance oml = this.omlDescriptionsFactory.createReifiedRelationshipInstance();
      final String uuid = kv.remove("uuid");
      oml.setName(OMLTables.toLocalName(kv.remove("name")));
      final Pair<ReifiedRelationshipInstance, Map<String, String>> pair = new Pair<ReifiedRelationshipInstance, Map<String, String>>(oml, kv);
      this.reifiedRelationshipInstances.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipInstanceDomains(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipInstanceDomain oml = this.omlDescriptionsFactory.createReifiedRelationshipInstanceDomain();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipInstanceDomain, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>(oml, kv);
      this.reifiedRelationshipInstanceDomains.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readReifiedRelationshipInstanceRanges(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ReifiedRelationshipInstanceRange oml = this.omlDescriptionsFactory.createReifiedRelationshipInstanceRange();
      final String uuid = kv.remove("uuid");
      final Pair<ReifiedRelationshipInstanceRange, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceRange, Map<String, String>>(oml, kv);
      this.reifiedRelationshipInstanceRanges.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readUnreifiedRelationshipInstanceTuples(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final UnreifiedRelationshipInstanceTuple oml = this.omlDescriptionsFactory.createUnreifiedRelationshipInstanceTuple();
      final String uuid = kv.remove("uuid");
      final Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>> pair = new Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>(oml, kv);
      this.unreifiedRelationshipInstanceTuples.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readSingletonInstanceStructuredDataPropertyValues(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final SingletonInstanceStructuredDataPropertyValue oml = this.omlDescriptionsFactory.createSingletonInstanceStructuredDataPropertyValue();
      final String uuid = kv.remove("uuid");
      final Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>(oml, kv);
      this.singletonInstanceStructuredDataPropertyValues.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readSingletonInstanceScalarDataPropertyValues(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final SingletonInstanceScalarDataPropertyValue oml = this.omlDescriptionsFactory.createSingletonInstanceScalarDataPropertyValue();
      final String uuid = kv.remove("uuid");
      oml.setScalarPropertyValue(OMLTables.toLiteralValue(kv.remove("scalarPropertyValue")));
      final Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>(oml, kv);
      this.singletonInstanceScalarDataPropertyValues.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readStructuredDataPropertyTuples(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final StructuredDataPropertyTuple oml = this.omlDescriptionsFactory.createStructuredDataPropertyTuple();
      final String uuid = kv.remove("uuid");
      final Pair<StructuredDataPropertyTuple, Map<String, String>> pair = new Pair<StructuredDataPropertyTuple, Map<String, String>>(oml, kv);
      this.structuredDataPropertyTuples.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readScalarDataPropertyValues(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final ScalarDataPropertyValue oml = this.omlDescriptionsFactory.createScalarDataPropertyValue();
      final String uuid = kv.remove("uuid");
      oml.setScalarPropertyValue(OMLTables.toLiteralValue(kv.remove("scalarPropertyValue")));
      final Pair<ScalarDataPropertyValue, Map<String, String>> pair = new Pair<ScalarDataPropertyValue, Map<String, String>>(oml, kv);
      this.scalarDataPropertyValues.put(uuid, pair);
    };
    kvs.forEach(_function);
  }
  
  protected void readAnnotationPropertyValues(final ArrayList<String> lines) {
    final List<Map<String, String>> kvs = OMLZipResource.lines2tuples(lines);
    final Consumer<Map<String, String>> _function = (Map<String, String> kv) -> {
      final AnnotationPropertyValue oml = this.omlCommonFactory.createAnnotationPropertyValue();
      final String uuid = kv.remove("uuid");
      oml.setValue(OMLTables.toLiteralString(kv.remove("value")));
      final Pair<AnnotationPropertyValue, Map<String, String>> pair = new Pair<AnnotationPropertyValue, Map<String, String>>(oml, kv);
      this.annotationPropertyValues.put(uuid, pair);
    };
    kvs.forEach(_function);
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
  
  protected void resolve(final OMLZipResourceSet rs, final OMLZipResource r) {
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
    this.<LogicalElement, UnreifiedRelationship>includeMap(this.logicalElements, this.unreifiedRelationships);
    this.<LogicalElement, ChainRule>includeMap(this.logicalElements, this.chainRules);
    this.<LogicalElement, RuleBodySegment>includeMap(this.logicalElements, this.ruleBodySegments);
    this.<LogicalElement, AspectPredicate>includeMap(this.logicalElements, this.aspectPredicates);
    this.<LogicalElement, ConceptPredicate>includeMap(this.logicalElements, this.conceptPredicates);
    this.<LogicalElement, ReifiedRelationshipPredicate>includeMap(this.logicalElements, this.reifiedRelationshipPredicates);
    this.<LogicalElement, ReifiedRelationshipPropertyPredicate>includeMap(this.logicalElements, this.reifiedRelationshipPropertyPredicates);
    this.<LogicalElement, ReifiedRelationshipSourcePropertyPredicate>includeMap(this.logicalElements, this.reifiedRelationshipSourcePropertyPredicates);
    this.<LogicalElement, ReifiedRelationshipTargetPropertyPredicate>includeMap(this.logicalElements, this.reifiedRelationshipTargetPropertyPredicates);
    this.<LogicalElement, UnreifiedRelationshipPropertyPredicate>includeMap(this.logicalElements, this.unreifiedRelationshipPropertyPredicates);
    this.<LogicalElement, ReifiedRelationshipInversePropertyPredicate>includeMap(this.logicalElements, this.reifiedRelationshipInversePropertyPredicates);
    this.<LogicalElement, ReifiedRelationshipSourceInversePropertyPredicate>includeMap(this.logicalElements, this.reifiedRelationshipSourceInversePropertyPredicates);
    this.<LogicalElement, ReifiedRelationshipTargetInversePropertyPredicate>includeMap(this.logicalElements, this.reifiedRelationshipTargetInversePropertyPredicates);
    this.<LogicalElement, UnreifiedRelationshipInversePropertyPredicate>includeMap(this.logicalElements, this.unreifiedRelationshipInversePropertyPredicates);
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
    this.<LogicalElement, ReifiedRelationshipSpecializationAxiom>includeMap(this.logicalElements, this.reifiedRelationshipSpecializationAxioms);
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
    this.<EntityRelationship, ReifiedRelationship>includeMap(this.entityRelationships, this.reifiedRelationships);
    this.<EntityRelationship, UnreifiedRelationship>includeMap(this.entityRelationships, this.unreifiedRelationships);
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
    this.resolveUnreifiedRelationships(rs);
    this.resolveChainRules(rs);
    this.resolveRuleBodySegments(rs);
    this.resolveAspectPredicates(rs);
    this.resolveConceptPredicates(rs);
    this.resolveReifiedRelationshipPredicates(rs);
    this.resolveReifiedRelationshipPropertyPredicates(rs);
    this.resolveReifiedRelationshipSourcePropertyPredicates(rs);
    this.resolveReifiedRelationshipTargetPropertyPredicates(rs);
    this.resolveUnreifiedRelationshipPropertyPredicates(rs);
    this.resolveReifiedRelationshipInversePropertyPredicates(rs);
    this.resolveReifiedRelationshipSourceInversePropertyPredicates(rs);
    this.resolveReifiedRelationshipTargetInversePropertyPredicates(rs);
    this.resolveUnreifiedRelationshipInversePropertyPredicates(rs);
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
    this.resolveReifiedRelationshipSpecializationAxioms(rs);
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
    final Extent ext = this.omlCommonFactory.createExtent();
    final Function1<Pair<TerminologyGraph, Map<String, String>>, TerminologyGraph> _function = (Pair<TerminologyGraph, Map<String, String>> it) -> {
      return it.getKey();
    };
    Iterables.<Module>addAll(ext.getModules(), IterableExtensions.<Pair<TerminologyGraph, Map<String, String>>, TerminologyGraph>map(this.terminologyGraphs.values(), _function));
    final Function1<Pair<Bundle, Map<String, String>>, Bundle> _function_1 = (Pair<Bundle, Map<String, String>> it) -> {
      return it.getKey();
    };
    Iterables.<Module>addAll(ext.getModules(), IterableExtensions.<Pair<Bundle, Map<String, String>>, Bundle>map(this.bundles.values(), _function_1));
    final Function1<Pair<DescriptionBox, Map<String, String>>, DescriptionBox> _function_2 = (Pair<DescriptionBox, Map<String, String>> it) -> {
      return it.getKey();
    };
    Iterables.<Module>addAll(ext.getModules(), IterableExtensions.<Pair<DescriptionBox, Map<String, String>>, DescriptionBox>map(this.descriptionBoxes.values(), _function_2));
    r.getContents().add(ext);
  }
  
  protected void resolveAnnotationProperties(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<AnnotationProperty, Map<String, String>>> _function = (String uuid, Pair<AnnotationProperty, Map<String, String>> oml_kv) -> {
      final AnnotationProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String moduleXRef = kv.remove("moduleUUID");
        final Pair<Module, Map<String, String>> modulePair = this.modules.get(moduleXRef);
        if ((null == modulePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for module in annotationProperties");
        }
        oml.setModule(modulePair.getKey());
      }
    };
    this.annotationProperties.forEach(_function);
  }
  
  protected void resolveAspects(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<Aspect, Map<String, String>>> _function = (String uuid, Pair<Aspect, Map<String, String>> oml_kv) -> {
      final Aspect oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in aspects");
        }
        oml.setTbox(tboxPair.getKey());
      }
    };
    this.aspects.forEach(_function);
  }
  
  protected void resolveConcepts(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<Concept, Map<String, String>>> _function = (String uuid, Pair<Concept, Map<String, String>> oml_kv) -> {
      final Concept oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in concepts");
        }
        oml.setTbox(tboxPair.getKey());
      }
    };
    this.concepts.forEach(_function);
  }
  
  protected void resolveScalars(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<Scalar, Map<String, String>>> _function = (String uuid, Pair<Scalar, Map<String, String>> oml_kv) -> {
      final Scalar oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in scalars");
        }
        oml.setTbox(tboxPair.getKey());
      }
    };
    this.scalars.forEach(_function);
  }
  
  protected void resolveStructures(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<Structure, Map<String, String>>> _function = (String uuid, Pair<Structure, Map<String, String>> oml_kv) -> {
      final Structure oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in structures");
        }
        oml.setTbox(tboxPair.getKey());
      }
    };
    this.structures.forEach(_function);
  }
  
  protected void resolveConceptDesignationTerminologyAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>> _function = (String uuid, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> oml_kv) -> {
      final ConceptDesignationTerminologyAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in conceptDesignationTerminologyAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String designatedConceptXRef = kv.remove("designatedConceptUUID");
        final Pair<Concept, Map<String, String>> designatedConceptPair = this.concepts.get(designatedConceptXRef);
        if ((null == designatedConceptPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for designatedConcept in conceptDesignationTerminologyAxioms");
        }
        oml.setDesignatedConcept(designatedConceptPair.getKey());
        final String designatedTerminologyIRI = kv.remove("designatedTerminologyIRI");
        this.loadOMLZipResource(rs, URI.createURI(designatedTerminologyIRI));
        final Pair<TerminologyBox, Map<String, String>> designatedTerminologyPair = this.terminologyBoxes.get(designatedTerminologyIRI);
        if ((null == designatedTerminologyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for designatedTerminology in conceptDesignationTerminologyAxioms");
        }
        oml.setDesignatedTerminology(designatedTerminologyPair.getKey());
      }
    };
    this.conceptDesignationTerminologyAxioms.forEach(_function);
  }
  
  protected void resolveTerminologyExtensionAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<TerminologyExtensionAxiom, Map<String, String>>> _function = (String uuid, Pair<TerminologyExtensionAxiom, Map<String, String>> oml_kv) -> {
      final TerminologyExtensionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in terminologyExtensionAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String extendedTerminologyIRI = kv.remove("extendedTerminologyIRI");
        this.loadOMLZipResource(rs, URI.createURI(extendedTerminologyIRI));
        final Pair<TerminologyBox, Map<String, String>> extendedTerminologyPair = this.terminologyBoxes.get(extendedTerminologyIRI);
        if ((null == extendedTerminologyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for extendedTerminology in terminologyExtensionAxioms");
        }
        oml.setExtendedTerminology(extendedTerminologyPair.getKey());
      }
    };
    this.terminologyExtensionAxioms.forEach(_function);
  }
  
  protected void resolveTerminologyNestingAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<TerminologyNestingAxiom, Map<String, String>>> _function = (String uuid, Pair<TerminologyNestingAxiom, Map<String, String>> oml_kv) -> {
      final TerminologyNestingAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in terminologyNestingAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String nestingContextXRef = kv.remove("nestingContextUUID");
        final Pair<Concept, Map<String, String>> nestingContextPair = this.concepts.get(nestingContextXRef);
        if ((null == nestingContextPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for nestingContext in terminologyNestingAxioms");
        }
        oml.setNestingContext(nestingContextPair.getKey());
        final String nestingTerminologyIRI = kv.remove("nestingTerminologyIRI");
        this.loadOMLZipResource(rs, URI.createURI(nestingTerminologyIRI));
        final Pair<TerminologyBox, Map<String, String>> nestingTerminologyPair = this.terminologyBoxes.get(nestingTerminologyIRI);
        if ((null == nestingTerminologyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for nestingTerminology in terminologyNestingAxioms");
        }
        oml.setNestingTerminology(nestingTerminologyPair.getKey());
      }
    };
    this.terminologyNestingAxioms.forEach(_function);
  }
  
  protected void resolveBundledTerminologyAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<BundledTerminologyAxiom, Map<String, String>>> _function = (String uuid, Pair<BundledTerminologyAxiom, Map<String, String>> oml_kv) -> {
      final BundledTerminologyAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bundleXRef = kv.remove("bundleUUID");
        final Pair<Bundle, Map<String, String>> bundlePair = this.bundles.get(bundleXRef);
        if ((null == bundlePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bundle in bundledTerminologyAxioms");
        }
        oml.setBundle(bundlePair.getKey());
        final String bundledTerminologyIRI = kv.remove("bundledTerminologyIRI");
        this.loadOMLZipResource(rs, URI.createURI(bundledTerminologyIRI));
        final Pair<TerminologyBox, Map<String, String>> bundledTerminologyPair = this.terminologyBoxes.get(bundledTerminologyIRI);
        if ((null == bundledTerminologyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bundledTerminology in bundledTerminologyAxioms");
        }
        oml.setBundledTerminology(bundledTerminologyPair.getKey());
      }
    };
    this.bundledTerminologyAxioms.forEach(_function);
  }
  
  protected void resolveDescriptionBoxExtendsClosedWorldDefinitions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>> _function = (String uuid, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> oml_kv) -> {
      final DescriptionBoxExtendsClosedWorldDefinitions oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in descriptionBoxExtendsClosedWorldDefinitions");
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String closedWorldDefinitionsIRI = kv.remove("closedWorldDefinitionsIRI");
        this.loadOMLZipResource(rs, URI.createURI(closedWorldDefinitionsIRI));
        final Pair<TerminologyBox, Map<String, String>> closedWorldDefinitionsPair = this.terminologyBoxes.get(closedWorldDefinitionsIRI);
        if ((null == closedWorldDefinitionsPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for closedWorldDefinitions in descriptionBoxExtendsClosedWorldDefinitions");
        }
        oml.setClosedWorldDefinitions(closedWorldDefinitionsPair.getKey());
      }
    };
    this.descriptionBoxExtendsClosedWorldDefinitions.forEach(_function);
  }
  
  protected void resolveDescriptionBoxRefinements(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<DescriptionBoxRefinement, Map<String, String>>> _function = (String uuid, Pair<DescriptionBoxRefinement, Map<String, String>> oml_kv) -> {
      final DescriptionBoxRefinement oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String refiningDescriptionBoxXRef = kv.remove("refiningDescriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> refiningDescriptionBoxPair = this.descriptionBoxes.get(refiningDescriptionBoxXRef);
        if ((null == refiningDescriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for refiningDescriptionBox in descriptionBoxRefinements");
        }
        oml.setRefiningDescriptionBox(refiningDescriptionBoxPair.getKey());
        final String refinedDescriptionBoxIRI = kv.remove("refinedDescriptionBoxIRI");
        this.loadOMLZipResource(rs, URI.createURI(refinedDescriptionBoxIRI));
        final Pair<DescriptionBox, Map<String, String>> refinedDescriptionBoxPair = this.descriptionBoxes.get(refinedDescriptionBoxIRI);
        if ((null == refinedDescriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for refinedDescriptionBox in descriptionBoxRefinements");
        }
        oml.setRefinedDescriptionBox(refinedDescriptionBoxPair.getKey());
      }
    };
    this.descriptionBoxRefinements.forEach(_function);
  }
  
  protected void resolveBinaryScalarRestrictions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<BinaryScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<BinaryScalarRestriction, Map<String, String>> oml_kv) -> {
      final BinaryScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in binaryScalarRestrictions");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in binaryScalarRestrictions");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.binaryScalarRestrictions.forEach(_function);
  }
  
  protected void resolveIRIScalarRestrictions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<IRIScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<IRIScalarRestriction, Map<String, String>> oml_kv) -> {
      final IRIScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in iriScalarRestrictions");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in iriScalarRestrictions");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.iriScalarRestrictions.forEach(_function);
  }
  
  protected void resolveNumericScalarRestrictions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<NumericScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<NumericScalarRestriction, Map<String, String>> oml_kv) -> {
      final NumericScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in numericScalarRestrictions");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in numericScalarRestrictions");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.numericScalarRestrictions.forEach(_function);
  }
  
  protected void resolvePlainLiteralScalarRestrictions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<PlainLiteralScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<PlainLiteralScalarRestriction, Map<String, String>> oml_kv) -> {
      final PlainLiteralScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in plainLiteralScalarRestrictions");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in plainLiteralScalarRestrictions");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.plainLiteralScalarRestrictions.forEach(_function);
  }
  
  protected void resolveScalarOneOfRestrictions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ScalarOneOfRestriction, Map<String, String>>> _function = (String uuid, Pair<ScalarOneOfRestriction, Map<String, String>> oml_kv) -> {
      final ScalarOneOfRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in scalarOneOfRestrictions");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in scalarOneOfRestrictions");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.scalarOneOfRestrictions.forEach(_function);
  }
  
  protected void resolveScalarOneOfLiteralAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ScalarOneOfLiteralAxiom, Map<String, String>>> _function = (String uuid, Pair<ScalarOneOfLiteralAxiom, Map<String, String>> oml_kv) -> {
      final ScalarOneOfLiteralAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in scalarOneOfLiteralAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String axiomXRef = kv.remove("axiomUUID");
        final Pair<ScalarOneOfRestriction, Map<String, String>> axiomPair = this.scalarOneOfRestrictions.get(axiomXRef);
        if ((null == axiomPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for axiom in scalarOneOfLiteralAxioms");
        }
        oml.setAxiom(axiomPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException("Null cross-reference lookup for valueType in scalarOneOfLiteralAxioms");
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.scalarOneOfLiteralAxioms.forEach(_function);
  }
  
  protected void resolveStringScalarRestrictions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<StringScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<StringScalarRestriction, Map<String, String>> oml_kv) -> {
      final StringScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in stringScalarRestrictions");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in stringScalarRestrictions");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.stringScalarRestrictions.forEach(_function);
  }
  
  protected void resolveSynonymScalarRestrictions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<SynonymScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<SynonymScalarRestriction, Map<String, String>> oml_kv) -> {
      final SynonymScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in synonymScalarRestrictions");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in synonymScalarRestrictions");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.synonymScalarRestrictions.forEach(_function);
  }
  
  protected void resolveTimeScalarRestrictions(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<TimeScalarRestriction, Map<String, String>>> _function = (String uuid, Pair<TimeScalarRestriction, Map<String, String>> oml_kv) -> {
      final TimeScalarRestriction oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in timeScalarRestrictions");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<DataRange, Map<String, String>> restrictedRangePair = this.dataRanges.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in timeScalarRestrictions");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.timeScalarRestrictions.forEach(_function);
  }
  
  protected void resolveEntityScalarDataProperties(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<EntityScalarDataProperty, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataProperty, Map<String, String>> oml_kv) -> {
      final EntityScalarDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityScalarDataProperties");
        }
        oml.setTbox(tboxPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<Entity, Map<String, String>> domainPair = this.entities.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for domain in entityScalarDataProperties");
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<DataRange, Map<String, String>> rangePair = this.dataRanges.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for range in entityScalarDataProperties");
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.entityScalarDataProperties.forEach(_function);
  }
  
  protected void resolveEntityStructuredDataProperties(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<EntityStructuredDataProperty, Map<String, String>>> _function = (String uuid, Pair<EntityStructuredDataProperty, Map<String, String>> oml_kv) -> {
      final EntityStructuredDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityStructuredDataProperties");
        }
        oml.setTbox(tboxPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<Entity, Map<String, String>> domainPair = this.entities.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for domain in entityStructuredDataProperties");
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<Structure, Map<String, String>> rangePair = this.structures.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for range in entityStructuredDataProperties");
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.entityStructuredDataProperties.forEach(_function);
  }
  
  protected void resolveScalarDataProperties(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ScalarDataProperty, Map<String, String>>> _function = (String uuid, Pair<ScalarDataProperty, Map<String, String>> oml_kv) -> {
      final ScalarDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in scalarDataProperties");
        }
        oml.setTbox(tboxPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<Structure, Map<String, String>> domainPair = this.structures.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for domain in scalarDataProperties");
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<DataRange, Map<String, String>> rangePair = this.dataRanges.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for range in scalarDataProperties");
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.scalarDataProperties.forEach(_function);
  }
  
  protected void resolveStructuredDataProperties(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<StructuredDataProperty, Map<String, String>>> _function = (String uuid, Pair<StructuredDataProperty, Map<String, String>> oml_kv) -> {
      final StructuredDataProperty oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in structuredDataProperties");
        }
        oml.setTbox(tboxPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<Structure, Map<String, String>> domainPair = this.structures.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for domain in structuredDataProperties");
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<Structure, Map<String, String>> rangePair = this.structures.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for range in structuredDataProperties");
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.structuredDataProperties.forEach(_function);
  }
  
  protected void resolveReifiedRelationships(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationship, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationship, Map<String, String>> oml_kv) -> {
      final ReifiedRelationship oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in reifiedRelationships");
        }
        oml.setTbox(tboxPair.getKey());
        final String sourceXRef = kv.remove("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null == sourcePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for source in reifiedRelationships");
        }
        oml.setSource(sourcePair.getKey());
        final String targetXRef = kv.remove("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null == targetPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for target in reifiedRelationships");
        }
        oml.setTarget(targetPair.getKey());
      }
    };
    this.reifiedRelationships.forEach(_function);
  }
  
  protected void resolveUnreifiedRelationships(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<UnreifiedRelationship, Map<String, String>>> _function = (String uuid, Pair<UnreifiedRelationship, Map<String, String>> oml_kv) -> {
      final UnreifiedRelationship oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in unreifiedRelationships");
        }
        oml.setTbox(tboxPair.getKey());
        final String sourceXRef = kv.remove("sourceUUID");
        final Pair<Entity, Map<String, String>> sourcePair = this.entities.get(sourceXRef);
        if ((null == sourcePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for source in unreifiedRelationships");
        }
        oml.setSource(sourcePair.getKey());
        final String targetXRef = kv.remove("targetUUID");
        final Pair<Entity, Map<String, String>> targetPair = this.entities.get(targetXRef);
        if ((null == targetPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for target in unreifiedRelationships");
        }
        oml.setTarget(targetPair.getKey());
      }
    };
    this.unreifiedRelationships.forEach(_function);
  }
  
  protected void resolveChainRules(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ChainRule, Map<String, String>>> _function = (String uuid, Pair<ChainRule, Map<String, String>> oml_kv) -> {
      final ChainRule oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in chainRules");
        }
        oml.setTbox(tboxPair.getKey());
        final String headXRef = kv.remove("headUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> headPair = this.unreifiedRelationships.get(headXRef);
        if ((null == headPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for head in chainRules");
        }
        oml.setHead(headPair.getKey());
      }
    };
    this.chainRules.forEach(_function);
  }
  
  protected void resolveRuleBodySegments(final OMLZipResourceSet rs) {
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
            throw new IllegalArgumentException("Null cross-reference lookup for previousSegment in ruleBodySegments");
          }
          oml.setPreviousSegment(previousSegmentPair.getKey());
        }
        final String ruleXRef = kv.remove("ruleUUID");
        boolean _notEquals_1 = (!Objects.equal("null", ruleXRef));
        if (_notEquals_1) {
          final Pair<ChainRule, Map<String, String>> rulePair = this.chainRules.get(ruleXRef);
          if ((null == rulePair)) {
            throw new IllegalArgumentException("Null cross-reference lookup for rule in ruleBodySegments");
          }
          oml.setRule(rulePair.getKey());
        }
      }
    };
    this.ruleBodySegments.forEach(_function);
  }
  
  protected void resolveAspectPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<AspectPredicate, Map<String, String>>> _function = (String uuid, Pair<AspectPredicate, Map<String, String>> oml_kv) -> {
      final AspectPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String aspectXRef = kv.remove("aspectUUID");
        final Pair<Aspect, Map<String, String>> aspectPair = this.aspects.get(aspectXRef);
        if ((null == aspectPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for aspect in aspectPredicates");
        }
        oml.setAspect(aspectPair.getKey());
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in aspectPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
      }
    };
    this.aspectPredicates.forEach(_function);
  }
  
  protected void resolveConceptPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ConceptPredicate, Map<String, String>>> _function = (String uuid, Pair<ConceptPredicate, Map<String, String>> oml_kv) -> {
      final ConceptPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in conceptPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String conceptXRef = kv.remove("conceptUUID");
        final Pair<Concept, Map<String, String>> conceptPair = this.concepts.get(conceptXRef);
        if ((null == conceptPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for concept in conceptPredicates");
        }
        oml.setConcept(conceptPair.getKey());
      }
    };
    this.conceptPredicates.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipPredicate, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipPredicate, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in reifiedRelationshipPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in reifiedRelationshipPredicates");
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.reifiedRelationshipPredicates.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipPropertyPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipPropertyPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in reifiedRelationshipPropertyPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in reifiedRelationshipPropertyPredicates");
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.reifiedRelationshipPropertyPredicates.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipSourcePropertyPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipSourcePropertyPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in reifiedRelationshipSourcePropertyPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in reifiedRelationshipSourcePropertyPredicates");
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.reifiedRelationshipSourcePropertyPredicates.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipTargetPropertyPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipTargetPropertyPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in reifiedRelationshipTargetPropertyPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in reifiedRelationshipTargetPropertyPredicates");
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.reifiedRelationshipTargetPropertyPredicates.forEach(_function);
  }
  
  protected void resolveUnreifiedRelationshipPropertyPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>>> _function = (String uuid, Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>> oml_kv) -> {
      final UnreifiedRelationshipPropertyPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String unreifiedRelationshipXRef = kv.remove("unreifiedRelationshipUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipPair = this.unreifiedRelationships.get(unreifiedRelationshipXRef);
        if ((null == unreifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for unreifiedRelationship in unreifiedRelationshipPropertyPredicates");
        }
        oml.setUnreifiedRelationship(unreifiedRelationshipPair.getKey());
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in unreifiedRelationshipPropertyPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
      }
    };
    this.unreifiedRelationshipPropertyPredicates.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInversePropertyPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInversePropertyPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in reifiedRelationshipInversePropertyPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in reifiedRelationshipInversePropertyPredicates");
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.reifiedRelationshipInversePropertyPredicates.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipSourceInversePropertyPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipSourceInversePropertyPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in reifiedRelationshipSourceInversePropertyPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in reifiedRelationshipSourceInversePropertyPredicates");
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.reifiedRelationshipSourceInversePropertyPredicates.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipTargetInversePropertyPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipTargetInversePropertyPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in reifiedRelationshipTargetInversePropertyPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
        final String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = this.reifiedRelationships.get(reifiedRelationshipXRef);
        if ((null == reifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in reifiedRelationshipTargetInversePropertyPredicates");
        }
        oml.setReifiedRelationship(reifiedRelationshipPair.getKey());
      }
    };
    this.reifiedRelationshipTargetInversePropertyPredicates.forEach(_function);
  }
  
  protected void resolveUnreifiedRelationshipInversePropertyPredicates(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>>> _function = (String uuid, Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>> oml_kv) -> {
      final UnreifiedRelationshipInversePropertyPredicate oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String unreifiedRelationshipXRef = kv.remove("unreifiedRelationshipUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipPair = this.unreifiedRelationships.get(unreifiedRelationshipXRef);
        if ((null == unreifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for unreifiedRelationship in unreifiedRelationshipInversePropertyPredicates");
        }
        oml.setUnreifiedRelationship(unreifiedRelationshipPair.getKey());
        final String bodySegmentXRef = kv.remove("bodySegmentUUID");
        final Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = this.ruleBodySegments.get(bodySegmentXRef);
        if ((null == bodySegmentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in unreifiedRelationshipInversePropertyPredicates");
        }
        oml.setBodySegment(bodySegmentPair.getKey());
      }
    };
    this.unreifiedRelationshipInversePropertyPredicates.forEach(_function);
  }
  
  protected void resolveEntityExistentialRestrictionAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<EntityExistentialRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityExistentialRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityExistentialRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityExistentialRestrictionAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRelationXRef = kv.remove("restrictedRelationUUID");
        final Pair<EntityRelationship, Map<String, String>> restrictedRelationPair = this.entityRelationships.get(restrictedRelationXRef);
        if ((null == restrictedRelationPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRelation in entityExistentialRestrictionAxioms");
        }
        oml.setRestrictedRelation(restrictedRelationPair.getKey());
        final String restrictedDomainXRef = kv.remove("restrictedDomainUUID");
        final Pair<Entity, Map<String, String>> restrictedDomainPair = this.entities.get(restrictedDomainXRef);
        if ((null == restrictedDomainPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedDomain in entityExistentialRestrictionAxioms");
        }
        oml.setRestrictedDomain(restrictedDomainPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in entityExistentialRestrictionAxioms");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.entityExistentialRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityUniversalRestrictionAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<EntityUniversalRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityUniversalRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityUniversalRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityUniversalRestrictionAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedRelationXRef = kv.remove("restrictedRelationUUID");
        final Pair<EntityRelationship, Map<String, String>> restrictedRelationPair = this.entityRelationships.get(restrictedRelationXRef);
        if ((null == restrictedRelationPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRelation in entityUniversalRestrictionAxioms");
        }
        oml.setRestrictedRelation(restrictedRelationPair.getKey());
        final String restrictedDomainXRef = kv.remove("restrictedDomainUUID");
        final Pair<Entity, Map<String, String>> restrictedDomainPair = this.entities.get(restrictedDomainXRef);
        if ((null == restrictedDomainPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedDomain in entityUniversalRestrictionAxioms");
        }
        oml.setRestrictedDomain(restrictedDomainPair.getKey());
        final String restrictedRangeXRef = kv.remove("restrictedRangeUUID");
        final Pair<Entity, Map<String, String>> restrictedRangePair = this.entities.get(restrictedRangeXRef);
        if ((null == restrictedRangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in entityUniversalRestrictionAxioms");
        }
        oml.setRestrictedRange(restrictedRangePair.getKey());
      }
    };
    this.entityUniversalRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyExistentialRestrictionAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyExistentialRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityScalarDataPropertyExistentialRestrictionAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedEntityXRef = kv.remove("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null == restrictedEntityPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyExistentialRestrictionAxioms");
        }
        oml.setRestrictedEntity(restrictedEntityPair.getKey());
        final String scalarPropertyXRef = kv.remove("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null == scalarPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyExistentialRestrictionAxioms");
        }
        oml.setScalarProperty(scalarPropertyPair.getKey());
        final String scalarRestrictionXRef = kv.remove("scalarRestrictionUUID");
        final Pair<DataRange, Map<String, String>> scalarRestrictionPair = this.dataRanges.get(scalarRestrictionXRef);
        if ((null == scalarRestrictionPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for scalarRestriction in entityScalarDataPropertyExistentialRestrictionAxioms");
        }
        oml.setScalarRestriction(scalarRestrictionPair.getKey());
      }
    };
    this.entityScalarDataPropertyExistentialRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyParticularRestrictionAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyParticularRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityScalarDataPropertyParticularRestrictionAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedEntityXRef = kv.remove("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null == restrictedEntityPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyParticularRestrictionAxioms");
        }
        oml.setRestrictedEntity(restrictedEntityPair.getKey());
        final String scalarPropertyXRef = kv.remove("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null == scalarPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyParticularRestrictionAxioms");
        }
        oml.setScalarProperty(scalarPropertyPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException("Null cross-reference lookup for valueType in entityScalarDataPropertyParticularRestrictionAxioms");
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.entityScalarDataPropertyParticularRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityScalarDataPropertyUniversalRestrictionAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityScalarDataPropertyUniversalRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityScalarDataPropertyUniversalRestrictionAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String restrictedEntityXRef = kv.remove("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null == restrictedEntityPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyUniversalRestrictionAxioms");
        }
        oml.setRestrictedEntity(restrictedEntityPair.getKey());
        final String scalarPropertyXRef = kv.remove("scalarPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = this.entityScalarDataProperties.get(scalarPropertyXRef);
        if ((null == scalarPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyUniversalRestrictionAxioms");
        }
        oml.setScalarProperty(scalarPropertyPair.getKey());
        final String scalarRestrictionXRef = kv.remove("scalarRestrictionUUID");
        final Pair<DataRange, Map<String, String>> scalarRestrictionPair = this.dataRanges.get(scalarRestrictionXRef);
        if ((null == scalarRestrictionPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for scalarRestriction in entityScalarDataPropertyUniversalRestrictionAxioms");
        }
        oml.setScalarRestriction(scalarRestrictionPair.getKey());
      }
    };
    this.entityScalarDataPropertyUniversalRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveEntityStructuredDataPropertyParticularRestrictionAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>> _function = (String uuid, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>> oml_kv) -> {
      final EntityStructuredDataPropertyParticularRestrictionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityStructuredDataPropertyParticularRestrictionAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null == structuredDataPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for structuredDataProperty in entityStructuredDataPropertyParticularRestrictionAxioms");
        }
        oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
        final String restrictedEntityXRef = kv.remove("restrictedEntityUUID");
        final Pair<Entity, Map<String, String>> restrictedEntityPair = this.entities.get(restrictedEntityXRef);
        if ((null == restrictedEntityPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for restrictedEntity in entityStructuredDataPropertyParticularRestrictionAxioms");
        }
        oml.setRestrictedEntity(restrictedEntityPair.getKey());
      }
    };
    this.entityStructuredDataPropertyParticularRestrictionAxioms.forEach(_function);
  }
  
  protected void resolveRestrictionStructuredDataPropertyTuples(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>> _function = (String uuid, Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>> oml_kv) -> {
      final RestrictionStructuredDataPropertyTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null == structuredDataPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for structuredDataProperty in restrictionStructuredDataPropertyTuples");
        }
        oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
        final String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID");
        final Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null == structuredDataPropertyContextPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for structuredDataPropertyContext in restrictionStructuredDataPropertyTuples");
        }
        oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
      }
    };
    this.restrictionStructuredDataPropertyTuples.forEach(_function);
  }
  
  protected void resolveRestrictionScalarDataPropertyValues(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<RestrictionScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<RestrictionScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final RestrictionScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID");
        final Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = this.dataRelationshipToScalars.get(scalarDataPropertyXRef);
        if ((null == scalarDataPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for scalarDataProperty in restrictionScalarDataPropertyValues");
        }
        oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
        final String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID");
        final Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null == structuredDataPropertyContextPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for structuredDataPropertyContext in restrictionScalarDataPropertyValues");
        }
        oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException("Null cross-reference lookup for valueType in restrictionScalarDataPropertyValues");
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.restrictionScalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveAspectSpecializationAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<AspectSpecializationAxiom, Map<String, String>>> _function = (String uuid, Pair<AspectSpecializationAxiom, Map<String, String>> oml_kv) -> {
      final AspectSpecializationAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in aspectSpecializationAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String superAspectXRef = kv.remove("superAspectUUID");
        final Pair<Aspect, Map<String, String>> superAspectPair = this.aspects.get(superAspectXRef);
        if ((null == superAspectPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for superAspect in aspectSpecializationAxioms");
        }
        oml.setSuperAspect(superAspectPair.getKey());
        final String subEntityXRef = kv.remove("subEntityUUID");
        final Pair<Entity, Map<String, String>> subEntityPair = this.entities.get(subEntityXRef);
        if ((null == subEntityPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for subEntity in aspectSpecializationAxioms");
        }
        oml.setSubEntity(subEntityPair.getKey());
      }
    };
    this.aspectSpecializationAxioms.forEach(_function);
  }
  
  protected void resolveConceptSpecializationAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ConceptSpecializationAxiom, Map<String, String>>> _function = (String uuid, Pair<ConceptSpecializationAxiom, Map<String, String>> oml_kv) -> {
      final ConceptSpecializationAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in conceptSpecializationAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String superConceptXRef = kv.remove("superConceptUUID");
        final Pair<Concept, Map<String, String>> superConceptPair = this.concepts.get(superConceptXRef);
        if ((null == superConceptPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for superConcept in conceptSpecializationAxioms");
        }
        oml.setSuperConcept(superConceptPair.getKey());
        final String subConceptXRef = kv.remove("subConceptUUID");
        final Pair<Concept, Map<String, String>> subConceptPair = this.concepts.get(subConceptXRef);
        if ((null == subConceptPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for subConcept in conceptSpecializationAxioms");
        }
        oml.setSubConcept(subConceptPair.getKey());
      }
    };
    this.conceptSpecializationAxioms.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipSpecializationAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipSpecializationAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in reifiedRelationshipSpecializationAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String superRelationshipXRef = kv.remove("superRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> superRelationshipPair = this.reifiedRelationships.get(superRelationshipXRef);
        if ((null == superRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for superRelationship in reifiedRelationshipSpecializationAxioms");
        }
        oml.setSuperRelationship(superRelationshipPair.getKey());
        final String subRelationshipXRef = kv.remove("subRelationshipUUID");
        final Pair<ReifiedRelationship, Map<String, String>> subRelationshipPair = this.reifiedRelationships.get(subRelationshipXRef);
        if ((null == subRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for subRelationship in reifiedRelationshipSpecializationAxioms");
        }
        oml.setSubRelationship(subRelationshipPair.getKey());
      }
    };
    this.reifiedRelationshipSpecializationAxioms.forEach(_function);
  }
  
  protected void resolveSubDataPropertyOfAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<SubDataPropertyOfAxiom, Map<String, String>>> _function = (String uuid, Pair<SubDataPropertyOfAxiom, Map<String, String>> oml_kv) -> {
      final SubDataPropertyOfAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in subDataPropertyOfAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String subPropertyXRef = kv.remove("subPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> subPropertyPair = this.entityScalarDataProperties.get(subPropertyXRef);
        if ((null == subPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for subProperty in subDataPropertyOfAxioms");
        }
        oml.setSubProperty(subPropertyPair.getKey());
        final String superPropertyXRef = kv.remove("superPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> superPropertyPair = this.entityScalarDataProperties.get(superPropertyXRef);
        if ((null == superPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for superProperty in subDataPropertyOfAxioms");
        }
        oml.setSuperProperty(superPropertyPair.getKey());
      }
    };
    this.subDataPropertyOfAxioms.forEach(_function);
  }
  
  protected void resolveSubObjectPropertyOfAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<SubObjectPropertyOfAxiom, Map<String, String>>> _function = (String uuid, Pair<SubObjectPropertyOfAxiom, Map<String, String>> oml_kv) -> {
      final SubObjectPropertyOfAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String tboxXRef = kv.remove("tboxUUID");
        final Pair<TerminologyBox, Map<String, String>> tboxPair = this.terminologyBoxes.get(tboxXRef);
        if ((null == tboxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for tbox in subObjectPropertyOfAxioms");
        }
        oml.setTbox(tboxPair.getKey());
        final String subPropertyXRef = kv.remove("subPropertyUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> subPropertyPair = this.unreifiedRelationships.get(subPropertyXRef);
        if ((null == subPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for subProperty in subObjectPropertyOfAxioms");
        }
        oml.setSubProperty(subPropertyPair.getKey());
        final String superPropertyXRef = kv.remove("superPropertyUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> superPropertyPair = this.unreifiedRelationships.get(superPropertyXRef);
        if ((null == superPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for superProperty in subObjectPropertyOfAxioms");
        }
        oml.setSuperProperty(superPropertyPair.getKey());
      }
    };
    this.subObjectPropertyOfAxioms.forEach(_function);
  }
  
  protected void resolveRootConceptTaxonomyAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<RootConceptTaxonomyAxiom, Map<String, String>>> _function = (String uuid, Pair<RootConceptTaxonomyAxiom, Map<String, String>> oml_kv) -> {
      final RootConceptTaxonomyAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String bundleXRef = kv.remove("bundleUUID");
        final Pair<Bundle, Map<String, String>> bundlePair = this.bundles.get(bundleXRef);
        if ((null == bundlePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for bundle in rootConceptTaxonomyAxioms");
        }
        oml.setBundle(bundlePair.getKey());
        final String rootXRef = kv.remove("rootUUID");
        final Pair<Concept, Map<String, String>> rootPair = this.concepts.get(rootXRef);
        if ((null == rootPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for root in rootConceptTaxonomyAxioms");
        }
        oml.setRoot(rootPair.getKey());
      }
    };
    this.rootConceptTaxonomyAxioms.forEach(_function);
  }
  
  protected void resolveAnonymousConceptUnionAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<AnonymousConceptUnionAxiom, Map<String, String>>> _function = (String uuid, Pair<AnonymousConceptUnionAxiom, Map<String, String>> oml_kv) -> {
      final AnonymousConceptUnionAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String disjointTaxonomyParentXRef = kv.remove("disjointTaxonomyParentUUID");
        final Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = this.conceptTreeDisjunctions.get(disjointTaxonomyParentXRef);
        if ((null == disjointTaxonomyParentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for disjointTaxonomyParent in anonymousConceptUnionAxioms");
        }
        oml.setDisjointTaxonomyParent(disjointTaxonomyParentPair.getKey());
      }
    };
    this.anonymousConceptUnionAxioms.forEach(_function);
  }
  
  protected void resolveSpecificDisjointConceptAxioms(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<SpecificDisjointConceptAxiom, Map<String, String>>> _function = (String uuid, Pair<SpecificDisjointConceptAxiom, Map<String, String>> oml_kv) -> {
      final SpecificDisjointConceptAxiom oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String disjointTaxonomyParentXRef = kv.remove("disjointTaxonomyParentUUID");
        final Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = this.conceptTreeDisjunctions.get(disjointTaxonomyParentXRef);
        if ((null == disjointTaxonomyParentPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for disjointTaxonomyParent in specificDisjointConceptAxioms");
        }
        oml.setDisjointTaxonomyParent(disjointTaxonomyParentPair.getKey());
        final String disjointLeafXRef = kv.remove("disjointLeafUUID");
        final Pair<Concept, Map<String, String>> disjointLeafPair = this.concepts.get(disjointLeafXRef);
        if ((null == disjointLeafPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for disjointLeaf in specificDisjointConceptAxioms");
        }
        oml.setDisjointLeaf(disjointLeafPair.getKey());
      }
    };
    this.specificDisjointConceptAxioms.forEach(_function);
  }
  
  protected void resolveConceptInstances(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ConceptInstance, Map<String, String>>> _function = (String uuid, Pair<ConceptInstance, Map<String, String>> oml_kv) -> {
      final ConceptInstance oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in conceptInstances");
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String singletonConceptClassifierXRef = kv.remove("singletonConceptClassifierUUID");
        final Pair<Concept, Map<String, String>> singletonConceptClassifierPair = this.concepts.get(singletonConceptClassifierXRef);
        if ((null == singletonConceptClassifierPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for singletonConceptClassifier in conceptInstances");
        }
        oml.setSingletonConceptClassifier(singletonConceptClassifierPair.getKey());
      }
    };
    this.conceptInstances.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstances(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstance, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstance, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstance oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstances");
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String singletonReifiedRelationshipClassifierXRef = kv.remove("singletonReifiedRelationshipClassifierUUID");
        final Pair<ReifiedRelationship, Map<String, String>> singletonReifiedRelationshipClassifierPair = this.reifiedRelationships.get(singletonReifiedRelationshipClassifierXRef);
        if ((null == singletonReifiedRelationshipClassifierPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for singletonReifiedRelationshipClassifier in reifiedRelationshipInstances");
        }
        oml.setSingletonReifiedRelationshipClassifier(singletonReifiedRelationshipClassifierPair.getKey());
      }
    };
    this.reifiedRelationshipInstances.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstanceDomains(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstanceDomain, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstanceDomain oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstanceDomains");
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String reifiedRelationshipInstanceXRef = kv.remove("reifiedRelationshipInstanceUUID");
        final Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = this.reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef);
        if ((null == reifiedRelationshipInstancePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationshipInstance in reifiedRelationshipInstanceDomains");
        }
        oml.setReifiedRelationshipInstance(reifiedRelationshipInstancePair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = this.conceptualEntitySingletonInstances.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for domain in reifiedRelationshipInstanceDomains");
        }
        oml.setDomain(domainPair.getKey());
      }
    };
    this.reifiedRelationshipInstanceDomains.forEach(_function);
  }
  
  protected void resolveReifiedRelationshipInstanceRanges(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ReifiedRelationshipInstanceRange, Map<String, String>>> _function = (String uuid, Pair<ReifiedRelationshipInstanceRange, Map<String, String>> oml_kv) -> {
      final ReifiedRelationshipInstanceRange oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstanceRanges");
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String reifiedRelationshipInstanceXRef = kv.remove("reifiedRelationshipInstanceUUID");
        final Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = this.reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef);
        if ((null == reifiedRelationshipInstancePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationshipInstance in reifiedRelationshipInstanceRanges");
        }
        oml.setReifiedRelationshipInstance(reifiedRelationshipInstancePair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = this.conceptualEntitySingletonInstances.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for range in reifiedRelationshipInstanceRanges");
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.reifiedRelationshipInstanceRanges.forEach(_function);
  }
  
  protected void resolveUnreifiedRelationshipInstanceTuples(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>> _function = (String uuid, Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>> oml_kv) -> {
      final UnreifiedRelationshipInstanceTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in unreifiedRelationshipInstanceTuples");
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String unreifiedRelationshipXRef = kv.remove("unreifiedRelationshipUUID");
        final Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipPair = this.unreifiedRelationships.get(unreifiedRelationshipXRef);
        if ((null == unreifiedRelationshipPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for unreifiedRelationship in unreifiedRelationshipInstanceTuples");
        }
        oml.setUnreifiedRelationship(unreifiedRelationshipPair.getKey());
        final String domainXRef = kv.remove("domainUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = this.conceptualEntitySingletonInstances.get(domainXRef);
        if ((null == domainPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for domain in unreifiedRelationshipInstanceTuples");
        }
        oml.setDomain(domainPair.getKey());
        final String rangeXRef = kv.remove("rangeUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = this.conceptualEntitySingletonInstances.get(rangeXRef);
        if ((null == rangePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for range in unreifiedRelationshipInstanceTuples");
        }
        oml.setRange(rangePair.getKey());
      }
    };
    this.unreifiedRelationshipInstanceTuples.forEach(_function);
  }
  
  protected void resolveSingletonInstanceStructuredDataPropertyValues(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>> oml_kv) -> {
      final SingletonInstanceStructuredDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in singletonInstanceStructuredDataPropertyValues");
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String singletonInstanceXRef = kv.remove("singletonInstanceUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = this.conceptualEntitySingletonInstances.get(singletonInstanceXRef);
        if ((null == singletonInstancePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for singletonInstance in singletonInstanceStructuredDataPropertyValues");
        }
        oml.setSingletonInstance(singletonInstancePair.getKey());
        final String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null == structuredDataPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for structuredDataProperty in singletonInstanceStructuredDataPropertyValues");
        }
        oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
      }
    };
    this.singletonInstanceStructuredDataPropertyValues.forEach(_function);
  }
  
  protected void resolveSingletonInstanceScalarDataPropertyValues(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final SingletonInstanceScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String descriptionBoxXRef = kv.remove("descriptionBoxUUID");
        final Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = this.descriptionBoxes.get(descriptionBoxXRef);
        if ((null == descriptionBoxPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in singletonInstanceScalarDataPropertyValues");
        }
        oml.setDescriptionBox(descriptionBoxPair.getKey());
        final String singletonInstanceXRef = kv.remove("singletonInstanceUUID");
        final Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = this.conceptualEntitySingletonInstances.get(singletonInstanceXRef);
        if ((null == singletonInstancePair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for singletonInstance in singletonInstanceScalarDataPropertyValues");
        }
        oml.setSingletonInstance(singletonInstancePair.getKey());
        final String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID");
        final Pair<EntityScalarDataProperty, Map<String, String>> scalarDataPropertyPair = this.entityScalarDataProperties.get(scalarDataPropertyXRef);
        if ((null == scalarDataPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for scalarDataProperty in singletonInstanceScalarDataPropertyValues");
        }
        oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException("Null cross-reference lookup for valueType in singletonInstanceScalarDataPropertyValues");
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.singletonInstanceScalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveStructuredDataPropertyTuples(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<StructuredDataPropertyTuple, Map<String, String>>> _function = (String uuid, Pair<StructuredDataPropertyTuple, Map<String, String>> oml_kv) -> {
      final StructuredDataPropertyTuple oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID");
        final Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = this.dataRelationshipToStructures.get(structuredDataPropertyXRef);
        if ((null == structuredDataPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for structuredDataProperty in structuredDataPropertyTuples");
        }
        oml.setStructuredDataProperty(structuredDataPropertyPair.getKey());
        final String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID");
        final Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null == structuredDataPropertyContextPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for structuredDataPropertyContext in structuredDataPropertyTuples");
        }
        oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
      }
    };
    this.structuredDataPropertyTuples.forEach(_function);
  }
  
  protected void resolveScalarDataPropertyValues(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<ScalarDataPropertyValue, Map<String, String>>> _function = (String uuid, Pair<ScalarDataPropertyValue, Map<String, String>> oml_kv) -> {
      final ScalarDataPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID");
        final Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = this.dataRelationshipToScalars.get(scalarDataPropertyXRef);
        if ((null == scalarDataPropertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for scalarDataProperty in scalarDataPropertyValues");
        }
        oml.setScalarDataProperty(scalarDataPropertyPair.getKey());
        final String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID");
        final Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = this.singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef);
        if ((null == structuredDataPropertyContextPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for structuredDataPropertyContext in scalarDataPropertyValues");
        }
        oml.setStructuredDataPropertyContext(structuredDataPropertyContextPair.getKey());
        final String valueTypeXRef = kv.remove("valueTypeUUID");
        boolean _notEquals = (!Objects.equal("null", valueTypeXRef));
        if (_notEquals) {
          final Pair<DataRange, Map<String, String>> valueTypePair = this.dataRanges.get(valueTypeXRef);
          if ((null == valueTypePair)) {
            throw new IllegalArgumentException("Null cross-reference lookup for valueType in scalarDataPropertyValues");
          }
          oml.setValueType(valueTypePair.getKey());
        }
      }
    };
    this.scalarDataPropertyValues.forEach(_function);
  }
  
  protected void resolveAnnotationPropertyValues(final OMLZipResourceSet rs) {
    final BiConsumer<String, Pair<AnnotationPropertyValue, Map<String, String>>> _function = (String uuid, Pair<AnnotationPropertyValue, Map<String, String>> oml_kv) -> {
      final AnnotationPropertyValue oml = oml_kv.getKey();
      final Map<String, String> kv = oml_kv.getValue();
      boolean _isEmpty = kv.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final String subjectXRef = kv.remove("subjectUUID");
        final Pair<LogicalElement, Map<String, String>> subjectPair = this.logicalElements.get(subjectXRef);
        if ((null == subjectPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for subject in annotationPropertyValues");
        }
        oml.setSubject(subjectPair.getKey());
        final String propertyXRef = kv.remove("propertyUUID");
        final Pair<AnnotationProperty, Map<String, String>> propertyPair = this.annotationProperties.get(propertyXRef);
        if ((null == propertyPair)) {
          throw new IllegalArgumentException("Null cross-reference lookup for property in annotationPropertyValues");
        }
        oml.setProperty(propertyPair.getKey());
      }
    };
    this.annotationPropertyValues.forEach(_function);
  }
  
  protected OMLZipResource loadOMLZipResource(final OMLZipResourceSet rs, final URI uri) {
    final Resource r = rs.getResource(uri, true);
    boolean _matched = false;
    if (r instanceof OMLZipResource) {
      _matched=true;
      final Procedure1<EObject> _function = (EObject e) -> {
        boolean _matched_1 = false;
        if (e instanceof TerminologyGraph) {
          _matched_1=true;
          Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
          final Pair<TerminologyGraph, Map<String, String>> pair = new Pair<TerminologyGraph, Map<String, String>>(((TerminologyGraph)e), _emptyMap);
          this.terminologyGraphs.put(((TerminologyGraph)e).uuid(), pair);
          String _uuid = ((TerminologyGraph)e).uuid();
          Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
          Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
          this.logicalElements.put(_uuid, _pair);
          this.terminologyGraphs.put(((TerminologyGraph)e).iri(), pair);
          String _uuid_1 = ((TerminologyGraph)e).uuid();
          Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
          Pair<TerminologyBox, Map<String, String>> _pair_1 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)e), _emptyMap_2);
          this.terminologyBoxes.put(_uuid_1, _pair_1);
          String _iri = ((TerminologyGraph)e).iri();
          Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
          Pair<TerminologyBox, Map<String, String>> _pair_2 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)e), _emptyMap_3);
          this.terminologyBoxes.put(_iri, _pair_2);
        }
        if (!_matched_1) {
          if (e instanceof Bundle) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<Bundle, Map<String, String>> pair = new Pair<Bundle, Map<String, String>>(((Bundle)e), _emptyMap);
            this.bundles.put(((Bundle)e).uuid(), pair);
            String _uuid = ((Bundle)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
            this.bundles.put(((Bundle)e).iri(), pair);
            String _uuid_1 = ((Bundle)e).uuid();
            Map<String, String> _emptyMap_2 = Collections.<String, String>emptyMap();
            Pair<TerminologyBox, Map<String, String>> _pair_1 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)e), _emptyMap_2);
            this.terminologyBoxes.put(_uuid_1, _pair_1);
            String _iri = ((Bundle)e).iri();
            Map<String, String> _emptyMap_3 = Collections.<String, String>emptyMap();
            Pair<TerminologyBox, Map<String, String>> _pair_2 = new Pair<TerminologyBox, Map<String, String>>(((TerminologyBox)e), _emptyMap_3);
            this.terminologyBoxes.put(_iri, _pair_2);
          }
        }
        if (!_matched_1) {
          if (e instanceof DescriptionBox) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<DescriptionBox, Map<String, String>> pair = new Pair<DescriptionBox, Map<String, String>>(((DescriptionBox)e), _emptyMap);
            this.descriptionBoxes.put(((DescriptionBox)e).uuid(), pair);
            String _uuid = ((DescriptionBox)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
            this.descriptionBoxes.put(((DescriptionBox)e).iri(), pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof AnnotationProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<AnnotationProperty, Map<String, String>> pair = new Pair<AnnotationProperty, Map<String, String>>(((AnnotationProperty)e), _emptyMap);
            this.annotationProperties.put(((AnnotationProperty)e).uuid(), pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof Aspect) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<Aspect, Map<String, String>> pair = new Pair<Aspect, Map<String, String>>(((Aspect)e), _emptyMap);
            this.aspects.put(((Aspect)e).uuid(), pair);
            String _uuid = ((Aspect)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof Concept) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<Concept, Map<String, String>> pair = new Pair<Concept, Map<String, String>>(((Concept)e), _emptyMap);
            this.concepts.put(((Concept)e).uuid(), pair);
            String _uuid = ((Concept)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof Scalar) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<Scalar, Map<String, String>> pair = new Pair<Scalar, Map<String, String>>(((Scalar)e), _emptyMap);
            this.scalars.put(((Scalar)e).uuid(), pair);
            String _uuid = ((Scalar)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof Structure) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<Structure, Map<String, String>> pair = new Pair<Structure, Map<String, String>>(((Structure)e), _emptyMap);
            this.structures.put(((Structure)e).uuid(), pair);
            String _uuid = ((Structure)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptDesignationTerminologyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ConceptDesignationTerminologyAxiom, Map<String, String>> pair = new Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>(((ConceptDesignationTerminologyAxiom)e), _emptyMap);
            this.conceptDesignationTerminologyAxioms.put(((ConceptDesignationTerminologyAxiom)e).uuid(), pair);
            String _uuid = ((ConceptDesignationTerminologyAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof TerminologyExtensionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<TerminologyExtensionAxiom, Map<String, String>> pair = new Pair<TerminologyExtensionAxiom, Map<String, String>>(((TerminologyExtensionAxiom)e), _emptyMap);
            this.terminologyExtensionAxioms.put(((TerminologyExtensionAxiom)e).uuid(), pair);
            String _uuid = ((TerminologyExtensionAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof TerminologyNestingAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<TerminologyNestingAxiom, Map<String, String>> pair = new Pair<TerminologyNestingAxiom, Map<String, String>>(((TerminologyNestingAxiom)e), _emptyMap);
            this.terminologyNestingAxioms.put(((TerminologyNestingAxiom)e).uuid(), pair);
            String _uuid = ((TerminologyNestingAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof BundledTerminologyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<BundledTerminologyAxiom, Map<String, String>> pair = new Pair<BundledTerminologyAxiom, Map<String, String>>(((BundledTerminologyAxiom)e), _emptyMap);
            this.bundledTerminologyAxioms.put(((BundledTerminologyAxiom)e).uuid(), pair);
            String _uuid = ((BundledTerminologyAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof DescriptionBoxExtendsClosedWorldDefinitions) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>> pair = new Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>(((DescriptionBoxExtendsClosedWorldDefinitions)e), _emptyMap);
            this.descriptionBoxExtendsClosedWorldDefinitions.put(((DescriptionBoxExtendsClosedWorldDefinitions)e).uuid(), pair);
            String _uuid = ((DescriptionBoxExtendsClosedWorldDefinitions)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof DescriptionBoxRefinement) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<DescriptionBoxRefinement, Map<String, String>> pair = new Pair<DescriptionBoxRefinement, Map<String, String>>(((DescriptionBoxRefinement)e), _emptyMap);
            this.descriptionBoxRefinements.put(((DescriptionBoxRefinement)e).uuid(), pair);
            String _uuid = ((DescriptionBoxRefinement)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof BinaryScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<BinaryScalarRestriction, Map<String, String>> pair = new Pair<BinaryScalarRestriction, Map<String, String>>(((BinaryScalarRestriction)e), _emptyMap);
            this.binaryScalarRestrictions.put(((BinaryScalarRestriction)e).uuid(), pair);
            String _uuid = ((BinaryScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof IRIScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<IRIScalarRestriction, Map<String, String>> pair = new Pair<IRIScalarRestriction, Map<String, String>>(((IRIScalarRestriction)e), _emptyMap);
            this.iriScalarRestrictions.put(((IRIScalarRestriction)e).uuid(), pair);
            String _uuid = ((IRIScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof NumericScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<NumericScalarRestriction, Map<String, String>> pair = new Pair<NumericScalarRestriction, Map<String, String>>(((NumericScalarRestriction)e), _emptyMap);
            this.numericScalarRestrictions.put(((NumericScalarRestriction)e).uuid(), pair);
            String _uuid = ((NumericScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof PlainLiteralScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<PlainLiteralScalarRestriction, Map<String, String>> pair = new Pair<PlainLiteralScalarRestriction, Map<String, String>>(((PlainLiteralScalarRestriction)e), _emptyMap);
            this.plainLiteralScalarRestrictions.put(((PlainLiteralScalarRestriction)e).uuid(), pair);
            String _uuid = ((PlainLiteralScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarOneOfRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ScalarOneOfRestriction, Map<String, String>> pair = new Pair<ScalarOneOfRestriction, Map<String, String>>(((ScalarOneOfRestriction)e), _emptyMap);
            this.scalarOneOfRestrictions.put(((ScalarOneOfRestriction)e).uuid(), pair);
            String _uuid = ((ScalarOneOfRestriction)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarOneOfLiteralAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ScalarOneOfLiteralAxiom, Map<String, String>> pair = new Pair<ScalarOneOfLiteralAxiom, Map<String, String>>(((ScalarOneOfLiteralAxiom)e), _emptyMap);
            this.scalarOneOfLiteralAxioms.put(((ScalarOneOfLiteralAxiom)e).uuid(), pair);
            String _uuid = ((ScalarOneOfLiteralAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof StringScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<StringScalarRestriction, Map<String, String>> pair = new Pair<StringScalarRestriction, Map<String, String>>(((StringScalarRestriction)e), _emptyMap);
            this.stringScalarRestrictions.put(((StringScalarRestriction)e).uuid(), pair);
            String _uuid = ((StringScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof SynonymScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<SynonymScalarRestriction, Map<String, String>> pair = new Pair<SynonymScalarRestriction, Map<String, String>>(((SynonymScalarRestriction)e), _emptyMap);
            this.synonymScalarRestrictions.put(((SynonymScalarRestriction)e).uuid(), pair);
            String _uuid = ((SynonymScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof TimeScalarRestriction) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<TimeScalarRestriction, Map<String, String>> pair = new Pair<TimeScalarRestriction, Map<String, String>>(((TimeScalarRestriction)e), _emptyMap);
            this.timeScalarRestrictions.put(((TimeScalarRestriction)e).uuid(), pair);
            String _uuid = ((TimeScalarRestriction)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataProperty, Map<String, String>> pair = new Pair<EntityScalarDataProperty, Map<String, String>>(((EntityScalarDataProperty)e), _emptyMap);
            this.entityScalarDataProperties.put(((EntityScalarDataProperty)e).uuid(), pair);
            String _uuid = ((EntityScalarDataProperty)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityStructuredDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<EntityStructuredDataProperty, Map<String, String>> pair = new Pair<EntityStructuredDataProperty, Map<String, String>>(((EntityStructuredDataProperty)e), _emptyMap);
            this.entityStructuredDataProperties.put(((EntityStructuredDataProperty)e).uuid(), pair);
            String _uuid = ((EntityStructuredDataProperty)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ScalarDataProperty, Map<String, String>> pair = new Pair<ScalarDataProperty, Map<String, String>>(((ScalarDataProperty)e), _emptyMap);
            this.scalarDataProperties.put(((ScalarDataProperty)e).uuid(), pair);
            String _uuid = ((ScalarDataProperty)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof StructuredDataProperty) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<StructuredDataProperty, Map<String, String>> pair = new Pair<StructuredDataProperty, Map<String, String>>(((StructuredDataProperty)e), _emptyMap);
            this.structuredDataProperties.put(((StructuredDataProperty)e).uuid(), pair);
            String _uuid = ((StructuredDataProperty)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationship) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationship, Map<String, String>> pair = new Pair<ReifiedRelationship, Map<String, String>>(((ReifiedRelationship)e), _emptyMap);
            this.reifiedRelationships.put(((ReifiedRelationship)e).uuid(), pair);
            String _uuid = ((ReifiedRelationship)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof UnreifiedRelationship) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<UnreifiedRelationship, Map<String, String>> pair = new Pair<UnreifiedRelationship, Map<String, String>>(((UnreifiedRelationship)e), _emptyMap);
            this.unreifiedRelationships.put(((UnreifiedRelationship)e).uuid(), pair);
            String _uuid = ((UnreifiedRelationship)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ChainRule) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ChainRule, Map<String, String>> pair = new Pair<ChainRule, Map<String, String>>(((ChainRule)e), _emptyMap);
            this.chainRules.put(((ChainRule)e).uuid(), pair);
            String _uuid = ((ChainRule)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof RuleBodySegment) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<RuleBodySegment, Map<String, String>> pair = new Pair<RuleBodySegment, Map<String, String>>(((RuleBodySegment)e), _emptyMap);
            this.ruleBodySegments.put(((RuleBodySegment)e).uuid(), pair);
            String _uuid = ((RuleBodySegment)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof AspectPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<AspectPredicate, Map<String, String>> pair = new Pair<AspectPredicate, Map<String, String>>(((AspectPredicate)e), _emptyMap);
            this.aspectPredicates.put(((AspectPredicate)e).uuid(), pair);
            String _uuid = ((AspectPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ConceptPredicate, Map<String, String>> pair = new Pair<ConceptPredicate, Map<String, String>>(((ConceptPredicate)e), _emptyMap);
            this.conceptPredicates.put(((ConceptPredicate)e).uuid(), pair);
            String _uuid = ((ConceptPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipPredicate, Map<String, String>>(((ReifiedRelationshipPredicate)e), _emptyMap);
            this.reifiedRelationshipPredicates.put(((ReifiedRelationshipPredicate)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipPropertyPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipPropertyPredicate, Map<String, String>>(((ReifiedRelationshipPropertyPredicate)e), _emptyMap);
            this.reifiedRelationshipPropertyPredicates.put(((ReifiedRelationshipPropertyPredicate)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipPropertyPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipSourcePropertyPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipSourcePropertyPredicate, Map<String, String>>(((ReifiedRelationshipSourcePropertyPredicate)e), _emptyMap);
            this.reifiedRelationshipSourcePropertyPredicates.put(((ReifiedRelationshipSourcePropertyPredicate)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipSourcePropertyPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipTargetPropertyPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipTargetPropertyPredicate, Map<String, String>>(((ReifiedRelationshipTargetPropertyPredicate)e), _emptyMap);
            this.reifiedRelationshipTargetPropertyPredicates.put(((ReifiedRelationshipTargetPropertyPredicate)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipTargetPropertyPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof UnreifiedRelationshipPropertyPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>> pair = new Pair<UnreifiedRelationshipPropertyPredicate, Map<String, String>>(((UnreifiedRelationshipPropertyPredicate)e), _emptyMap);
            this.unreifiedRelationshipPropertyPredicates.put(((UnreifiedRelationshipPropertyPredicate)e).uuid(), pair);
            String _uuid = ((UnreifiedRelationshipPropertyPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInversePropertyPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipInversePropertyPredicate, Map<String, String>>(((ReifiedRelationshipInversePropertyPredicate)e), _emptyMap);
            this.reifiedRelationshipInversePropertyPredicates.put(((ReifiedRelationshipInversePropertyPredicate)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipInversePropertyPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipSourceInversePropertyPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipSourceInversePropertyPredicate, Map<String, String>>(((ReifiedRelationshipSourceInversePropertyPredicate)e), _emptyMap);
            this.reifiedRelationshipSourceInversePropertyPredicates.put(((ReifiedRelationshipSourceInversePropertyPredicate)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipSourceInversePropertyPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipTargetInversePropertyPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>> pair = new Pair<ReifiedRelationshipTargetInversePropertyPredicate, Map<String, String>>(((ReifiedRelationshipTargetInversePropertyPredicate)e), _emptyMap);
            this.reifiedRelationshipTargetInversePropertyPredicates.put(((ReifiedRelationshipTargetInversePropertyPredicate)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipTargetInversePropertyPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof UnreifiedRelationshipInversePropertyPredicate) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>> pair = new Pair<UnreifiedRelationshipInversePropertyPredicate, Map<String, String>>(((UnreifiedRelationshipInversePropertyPredicate)e), _emptyMap);
            this.unreifiedRelationshipInversePropertyPredicates.put(((UnreifiedRelationshipInversePropertyPredicate)e).uuid(), pair);
            String _uuid = ((UnreifiedRelationshipInversePropertyPredicate)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityExistentialRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<EntityExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityExistentialRestrictionAxiom, Map<String, String>>(((EntityExistentialRestrictionAxiom)e), _emptyMap);
            this.entityExistentialRestrictionAxioms.put(((EntityExistentialRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityExistentialRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityUniversalRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<EntityUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityUniversalRestrictionAxiom, Map<String, String>>(((EntityUniversalRestrictionAxiom)e), _emptyMap);
            this.entityUniversalRestrictionAxioms.put(((EntityUniversalRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityUniversalRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyExistentialRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyExistentialRestrictionAxiom)e), _emptyMap);
            this.entityScalarDataPropertyExistentialRestrictionAxioms.put(((EntityScalarDataPropertyExistentialRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityScalarDataPropertyExistentialRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyParticularRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyParticularRestrictionAxiom)e), _emptyMap);
            this.entityScalarDataPropertyParticularRestrictionAxioms.put(((EntityScalarDataPropertyParticularRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityScalarDataPropertyParticularRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityScalarDataPropertyUniversalRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>> pair = new Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String, String>>(((EntityScalarDataPropertyUniversalRestrictionAxiom)e), _emptyMap);
            this.entityScalarDataPropertyUniversalRestrictionAxioms.put(((EntityScalarDataPropertyUniversalRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityScalarDataPropertyUniversalRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>> pair = new Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String, String>>(((EntityStructuredDataPropertyParticularRestrictionAxiom)e), _emptyMap);
            this.entityStructuredDataPropertyParticularRestrictionAxioms.put(((EntityStructuredDataPropertyParticularRestrictionAxiom)e).uuid(), pair);
            String _uuid = ((EntityStructuredDataPropertyParticularRestrictionAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof RestrictionStructuredDataPropertyTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>> pair = new Pair<RestrictionStructuredDataPropertyTuple, Map<String, String>>(((RestrictionStructuredDataPropertyTuple)e), _emptyMap);
            this.restrictionStructuredDataPropertyTuples.put(((RestrictionStructuredDataPropertyTuple)e).uuid(), pair);
            String _uuid = ((RestrictionStructuredDataPropertyTuple)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof RestrictionScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<RestrictionScalarDataPropertyValue, Map<String, String>> pair = new Pair<RestrictionScalarDataPropertyValue, Map<String, String>>(((RestrictionScalarDataPropertyValue)e), _emptyMap);
            this.restrictionScalarDataPropertyValues.put(((RestrictionScalarDataPropertyValue)e).uuid(), pair);
            String _uuid = ((RestrictionScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof AspectSpecializationAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<AspectSpecializationAxiom, Map<String, String>> pair = new Pair<AspectSpecializationAxiom, Map<String, String>>(((AspectSpecializationAxiom)e), _emptyMap);
            this.aspectSpecializationAxioms.put(((AspectSpecializationAxiom)e).uuid(), pair);
            String _uuid = ((AspectSpecializationAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptSpecializationAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ConceptSpecializationAxiom, Map<String, String>> pair = new Pair<ConceptSpecializationAxiom, Map<String, String>>(((ConceptSpecializationAxiom)e), _emptyMap);
            this.conceptSpecializationAxioms.put(((ConceptSpecializationAxiom)e).uuid(), pair);
            String _uuid = ((ConceptSpecializationAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipSpecializationAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>> pair = new Pair<ReifiedRelationshipSpecializationAxiom, Map<String, String>>(((ReifiedRelationshipSpecializationAxiom)e), _emptyMap);
            this.reifiedRelationshipSpecializationAxioms.put(((ReifiedRelationshipSpecializationAxiom)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipSpecializationAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof SubDataPropertyOfAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<SubDataPropertyOfAxiom, Map<String, String>> pair = new Pair<SubDataPropertyOfAxiom, Map<String, String>>(((SubDataPropertyOfAxiom)e), _emptyMap);
            this.subDataPropertyOfAxioms.put(((SubDataPropertyOfAxiom)e).uuid(), pair);
            String _uuid = ((SubDataPropertyOfAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof SubObjectPropertyOfAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<SubObjectPropertyOfAxiom, Map<String, String>> pair = new Pair<SubObjectPropertyOfAxiom, Map<String, String>>(((SubObjectPropertyOfAxiom)e), _emptyMap);
            this.subObjectPropertyOfAxioms.put(((SubObjectPropertyOfAxiom)e).uuid(), pair);
            String _uuid = ((SubObjectPropertyOfAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof RootConceptTaxonomyAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<RootConceptTaxonomyAxiom, Map<String, String>> pair = new Pair<RootConceptTaxonomyAxiom, Map<String, String>>(((RootConceptTaxonomyAxiom)e), _emptyMap);
            this.rootConceptTaxonomyAxioms.put(((RootConceptTaxonomyAxiom)e).uuid(), pair);
            String _uuid = ((RootConceptTaxonomyAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof AnonymousConceptUnionAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<AnonymousConceptUnionAxiom, Map<String, String>> pair = new Pair<AnonymousConceptUnionAxiom, Map<String, String>>(((AnonymousConceptUnionAxiom)e), _emptyMap);
            this.anonymousConceptUnionAxioms.put(((AnonymousConceptUnionAxiom)e).uuid(), pair);
            String _uuid = ((AnonymousConceptUnionAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof SpecificDisjointConceptAxiom) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<SpecificDisjointConceptAxiom, Map<String, String>> pair = new Pair<SpecificDisjointConceptAxiom, Map<String, String>>(((SpecificDisjointConceptAxiom)e), _emptyMap);
            this.specificDisjointConceptAxioms.put(((SpecificDisjointConceptAxiom)e).uuid(), pair);
            String _uuid = ((SpecificDisjointConceptAxiom)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ConceptInstance) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ConceptInstance, Map<String, String>> pair = new Pair<ConceptInstance, Map<String, String>>(((ConceptInstance)e), _emptyMap);
            this.conceptInstances.put(((ConceptInstance)e).uuid(), pair);
            String _uuid = ((ConceptInstance)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstance) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstance, Map<String, String>> pair = new Pair<ReifiedRelationshipInstance, Map<String, String>>(((ReifiedRelationshipInstance)e), _emptyMap);
            this.reifiedRelationshipInstances.put(((ReifiedRelationshipInstance)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipInstance)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstanceDomain) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstanceDomain, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceDomain, Map<String, String>>(((ReifiedRelationshipInstanceDomain)e), _emptyMap);
            this.reifiedRelationshipInstanceDomains.put(((ReifiedRelationshipInstanceDomain)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipInstanceDomain)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ReifiedRelationshipInstanceRange) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ReifiedRelationshipInstanceRange, Map<String, String>> pair = new Pair<ReifiedRelationshipInstanceRange, Map<String, String>>(((ReifiedRelationshipInstanceRange)e), _emptyMap);
            this.reifiedRelationshipInstanceRanges.put(((ReifiedRelationshipInstanceRange)e).uuid(), pair);
            String _uuid = ((ReifiedRelationshipInstanceRange)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof UnreifiedRelationshipInstanceTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>> pair = new Pair<UnreifiedRelationshipInstanceTuple, Map<String, String>>(((UnreifiedRelationshipInstanceTuple)e), _emptyMap);
            this.unreifiedRelationshipInstanceTuples.put(((UnreifiedRelationshipInstanceTuple)e).uuid(), pair);
            String _uuid = ((UnreifiedRelationshipInstanceTuple)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof SingletonInstanceStructuredDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceStructuredDataPropertyValue, Map<String, String>>(((SingletonInstanceStructuredDataPropertyValue)e), _emptyMap);
            this.singletonInstanceStructuredDataPropertyValues.put(((SingletonInstanceStructuredDataPropertyValue)e).uuid(), pair);
            String _uuid = ((SingletonInstanceStructuredDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof SingletonInstanceScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>> pair = new Pair<SingletonInstanceScalarDataPropertyValue, Map<String, String>>(((SingletonInstanceScalarDataPropertyValue)e), _emptyMap);
            this.singletonInstanceScalarDataPropertyValues.put(((SingletonInstanceScalarDataPropertyValue)e).uuid(), pair);
            String _uuid = ((SingletonInstanceScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof StructuredDataPropertyTuple) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<StructuredDataPropertyTuple, Map<String, String>> pair = new Pair<StructuredDataPropertyTuple, Map<String, String>>(((StructuredDataPropertyTuple)e), _emptyMap);
            this.structuredDataPropertyTuples.put(((StructuredDataPropertyTuple)e).uuid(), pair);
            String _uuid = ((StructuredDataPropertyTuple)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof ScalarDataPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<ScalarDataPropertyValue, Map<String, String>> pair = new Pair<ScalarDataPropertyValue, Map<String, String>>(((ScalarDataPropertyValue)e), _emptyMap);
            this.scalarDataPropertyValues.put(((ScalarDataPropertyValue)e).uuid(), pair);
            String _uuid = ((ScalarDataPropertyValue)e).uuid();
            Map<String, String> _emptyMap_1 = Collections.<String, String>emptyMap();
            Pair<LogicalElement, Map<String, String>> _pair = new Pair<LogicalElement, Map<String, String>>(((LogicalElement)e), _emptyMap_1);
            this.logicalElements.put(_uuid, _pair);
          }
        }
        if (!_matched_1) {
          if (e instanceof AnnotationPropertyValue) {
            _matched_1=true;
            Map<String, String> _emptyMap = Collections.<String, String>emptyMap();
            final Pair<AnnotationPropertyValue, Map<String, String>> pair = new Pair<AnnotationPropertyValue, Map<String, String>>(((AnnotationPropertyValue)e), _emptyMap);
            this.annotationPropertyValues.put(((AnnotationPropertyValue)e).uuid(), pair);
          }
        }
      };
      IteratorExtensions.<EObject>forEach(((OMLZipResource)r).getContents().get(0).eAllContents(), _function);
      return ((OMLZipResource)r);
    }
    throw new IllegalArgumentException((("OMLTables.loadOMLZipResource(" + uri) + ") should have produce an OMLZipResource!"));
  }
}
