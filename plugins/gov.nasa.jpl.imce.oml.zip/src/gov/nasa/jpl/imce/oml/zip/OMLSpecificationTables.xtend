/*
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


package gov.nasa.jpl.imce.oml.zip

import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.IllegalArgumentException
import java.nio.charset.StandardCharsets
import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.Map
import java.util.Queue
import java.util.Set
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream
import org.apache.commons.compress.archivers.zip.ZipFile
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.lib.Pair

import gov.nasa.jpl.imce.oml.model.extensions.OMLTables
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.common.LogicalElement
import gov.nasa.jpl.imce.oml.model.common.Module
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.AspectKind
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedAspect
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedConcept
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptKind
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Predicate
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Structure
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship

import gov.nasa.jpl.imce.oml.model.common.CommonFactory
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.bundles.BundlesFactory
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory

/**
 * @generated
 */
class OMLSpecificationTables {

  protected val Map<String, Pair<TerminologyGraph, Map<String,String>>> terminologyGraphs
  protected val Map<String, Pair<Bundle, Map<String,String>>> bundles
  protected val Map<String, Pair<DescriptionBox, Map<String,String>>> descriptionBoxes
  protected val Map<String, Pair<AnnotationProperty, Map<String,String>>> annotationProperties
  protected val Map<String, Pair<Aspect, Map<String,String>>> aspects
  protected val Map<String, Pair<Concept, Map<String,String>>> concepts
  protected val Map<String, Pair<Scalar, Map<String,String>>> scalars
  protected val Map<String, Pair<Structure, Map<String,String>>> structures
  protected val Map<String, Pair<ConceptDesignationTerminologyAxiom, Map<String,String>>> conceptDesignationTerminologyAxioms
  protected val Map<String, Pair<TerminologyExtensionAxiom, Map<String,String>>> terminologyExtensionAxioms
  protected val Map<String, Pair<TerminologyNestingAxiom, Map<String,String>>> terminologyNestingAxioms
  protected val Map<String, Pair<BundledTerminologyAxiom, Map<String,String>>> bundledTerminologyAxioms
  protected val Map<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String,String>>> descriptionBoxExtendsClosedWorldDefinitions
  protected val Map<String, Pair<DescriptionBoxRefinement, Map<String,String>>> descriptionBoxRefinements
  protected val Map<String, Pair<BinaryScalarRestriction, Map<String,String>>> binaryScalarRestrictions
  protected val Map<String, Pair<IRIScalarRestriction, Map<String,String>>> iriScalarRestrictions
  protected val Map<String, Pair<NumericScalarRestriction, Map<String,String>>> numericScalarRestrictions
  protected val Map<String, Pair<PlainLiteralScalarRestriction, Map<String,String>>> plainLiteralScalarRestrictions
  protected val Map<String, Pair<ScalarOneOfRestriction, Map<String,String>>> scalarOneOfRestrictions
  protected val Map<String, Pair<ScalarOneOfLiteralAxiom, Map<String,String>>> scalarOneOfLiteralAxioms
  protected val Map<String, Pair<StringScalarRestriction, Map<String,String>>> stringScalarRestrictions
  protected val Map<String, Pair<SynonymScalarRestriction, Map<String,String>>> synonymScalarRestrictions
  protected val Map<String, Pair<TimeScalarRestriction, Map<String,String>>> timeScalarRestrictions
  protected val Map<String, Pair<EntityScalarDataProperty, Map<String,String>>> entityScalarDataProperties
  protected val Map<String, Pair<EntityStructuredDataProperty, Map<String,String>>> entityStructuredDataProperties
  protected val Map<String, Pair<ScalarDataProperty, Map<String,String>>> scalarDataProperties
  protected val Map<String, Pair<StructuredDataProperty, Map<String,String>>> structuredDataProperties
  protected val Map<String, Pair<ReifiedRelationship, Map<String,String>>> reifiedRelationships
  protected val Map<String, Pair<ReifiedRelationshipRestriction, Map<String,String>>> reifiedRelationshipRestrictions
  protected val Map<String, Pair<ForwardProperty, Map<String,String>>> forwardProperties
  protected val Map<String, Pair<InverseProperty, Map<String,String>>> inverseProperties
  protected val Map<String, Pair<UnreifiedRelationship, Map<String,String>>> unreifiedRelationships
  protected val Map<String, Pair<ChainRule, Map<String,String>>> chainRules
  protected val Map<String, Pair<RuleBodySegment, Map<String,String>>> ruleBodySegments
  protected val Map<String, Pair<SegmentPredicate, Map<String,String>>> segmentPredicates
  protected val Map<String, Pair<EntityExistentialRestrictionAxiom, Map<String,String>>> entityExistentialRestrictionAxioms
  protected val Map<String, Pair<EntityUniversalRestrictionAxiom, Map<String,String>>> entityUniversalRestrictionAxioms
  protected val Map<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String,String>>> entityScalarDataPropertyExistentialRestrictionAxioms
  protected val Map<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String,String>>> entityScalarDataPropertyParticularRestrictionAxioms
  protected val Map<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String,String>>> entityScalarDataPropertyUniversalRestrictionAxioms
  protected val Map<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String,String>>> entityStructuredDataPropertyParticularRestrictionAxioms
  protected val Map<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String,String>>> restrictionStructuredDataPropertyTuples
  protected val Map<String, Pair<RestrictionScalarDataPropertyValue, Map<String,String>>> restrictionScalarDataPropertyValues
  protected val Map<String, Pair<AspectSpecializationAxiom, Map<String,String>>> aspectSpecializationAxioms
  protected val Map<String, Pair<ConceptSpecializationAxiom, Map<String,String>>> conceptSpecializationAxioms
  protected val Map<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String,String>>> reifiedRelationshipSpecializationAxioms
  protected val Map<String, Pair<SubDataPropertyOfAxiom, Map<String,String>>> subDataPropertyOfAxioms
  protected val Map<String, Pair<SubObjectPropertyOfAxiom, Map<String,String>>> subObjectPropertyOfAxioms
  protected val Map<String, Pair<RootConceptTaxonomyAxiom, Map<String,String>>> rootConceptTaxonomyAxioms
  protected val Map<String, Pair<AnonymousConceptUnionAxiom, Map<String,String>>> anonymousConceptUnionAxioms
  protected val Map<String, Pair<SpecificDisjointConceptAxiom, Map<String,String>>> specificDisjointConceptAxioms
  protected val Map<String, Pair<ConceptInstance, Map<String,String>>> conceptInstances
  protected val Map<String, Pair<ReifiedRelationshipInstance, Map<String,String>>> reifiedRelationshipInstances
  protected val Map<String, Pair<ReifiedRelationshipInstanceDomain, Map<String,String>>> reifiedRelationshipInstanceDomains
  protected val Map<String, Pair<ReifiedRelationshipInstanceRange, Map<String,String>>> reifiedRelationshipInstanceRanges
  protected val Map<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String,String>>> unreifiedRelationshipInstanceTuples
  protected val Map<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String,String>>> singletonInstanceStructuredDataPropertyValues
  protected val Map<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String,String>>> singletonInstanceScalarDataPropertyValues
  protected val Map<String, Pair<StructuredDataPropertyTuple, Map<String,String>>> structuredDataPropertyTuples
  protected val Map<String, Pair<ScalarDataPropertyValue, Map<String,String>>> scalarDataPropertyValues
  protected val Map<String, Pair<AnnotationPropertyValue, Map<String,String>>> annotationPropertyValues
  protected val Map<String, Pair<CardinalityRestrictedAspect, Map<String,String>>> cardinalityRestrictedAspects
  protected val Map<String, Pair<CardinalityRestrictedConcept, Map<String,String>>> cardinalityRestrictedConcepts
  protected val Map<String, Pair<CardinalityRestrictedReifiedRelationship, Map<String,String>>> cardinalityRestrictedReifiedRelationships

  protected val Map<String, Pair<Module, Map<String,String>>> modules
  protected val Map<String, Pair<LogicalElement, Map<String,String>>> logicalElements
  protected val Map<String, Pair<Entity, Map<String,String>>> entities
  protected val Map<String, Pair<AspectKind, Map<String,String>>> aspectKinds
  protected val Map<String, Pair<ConceptKind, Map<String,String>>> conceptKinds
  protected val Map<String, Pair<EntityRelationship, Map<String,String>>> entityRelationships
  protected val Map<String, Pair<ConceptualRelationship, Map<String,String>>> conceptualRelationships
  protected val Map<String, Pair<DataRange, Map<String,String>>> dataRanges 
  protected val Map<String, Pair<DataRelationshipToScalar, Map<String,String>>> dataRelationshipToScalars
  protected val Map<String, Pair<DataRelationshipToStructure, Map<String,String>>> dataRelationshipToStructures
  protected val Map<String, Pair<Predicate, Map<String,String>>> predicates
  protected val Map<String, Pair<RestrictableRelationship, Map<String,String>>> restrictableRelationships
  protected val Map<String, Pair<RestrictionStructuredDataPropertyContext, Map<String,String>>> restrictionStructuredDataPropertyContexts
  protected val Map<String, Pair<TerminologyBox, Map<String,String>>> terminologyBoxes
  protected val Map<String, Pair<ConceptTreeDisjunction, Map<String,String>>> conceptTreeDisjunctions
  protected val Map<String, Pair<ConceptualEntitySingletonInstance, Map<String,String>>> conceptualEntitySingletonInstances
  protected val Map<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String,String>>> singletonInstanceStructuredDataPropertyContexts

  extension CommonFactory omlCommonFactory
  extension TerminologiesFactory omlTerminologiesFactory
  extension GraphsFactory omlGraphsFactory
  extension BundlesFactory omlBundlesFactory
  extension DescriptionsFactory omlDescriptionsFactory
  
  protected val Queue<String> iriLoadQueue
  protected val Set<String> visitedIRIs
  protected val Queue<Module> moduleQueue
  protected val Set<Module> visitedModules
  protected val Map<String, Module> iri2module
  
  new() {
	iriLoadQueue = new LinkedList<String>()
	visitedIRIs = new HashSet<String>()
	moduleQueue = new LinkedList<Module>()
	visitedModules = new HashSet<Module>()
	iri2module = new HashMap<String, Module>()

  	omlCommonFactory = CommonFactory.eINSTANCE
  	omlTerminologiesFactory = TerminologiesFactory.eINSTANCE
  	omlGraphsFactory = GraphsFactory.eINSTANCE
  	omlBundlesFactory = BundlesFactory.eINSTANCE
  	omlDescriptionsFactory = DescriptionsFactory.eINSTANCE
  	
  	terminologyGraphs = new HashMap<String, Pair<TerminologyGraph, Map<String,String>>>()
  	bundles = new HashMap<String, Pair<Bundle, Map<String,String>>>()
  	descriptionBoxes = new HashMap<String, Pair<DescriptionBox, Map<String,String>>>()
  	annotationProperties = new HashMap<String, Pair<AnnotationProperty, Map<String,String>>>()
  	aspects = new HashMap<String, Pair<Aspect, Map<String,String>>>()
  	concepts = new HashMap<String, Pair<Concept, Map<String,String>>>()
  	scalars = new HashMap<String, Pair<Scalar, Map<String,String>>>()
  	structures = new HashMap<String, Pair<Structure, Map<String,String>>>()
  	conceptDesignationTerminologyAxioms = new HashMap<String, Pair<ConceptDesignationTerminologyAxiom, Map<String,String>>>()
  	terminologyExtensionAxioms = new HashMap<String, Pair<TerminologyExtensionAxiom, Map<String,String>>>()
  	terminologyNestingAxioms = new HashMap<String, Pair<TerminologyNestingAxiom, Map<String,String>>>()
  	bundledTerminologyAxioms = new HashMap<String, Pair<BundledTerminologyAxiom, Map<String,String>>>()
  	descriptionBoxExtendsClosedWorldDefinitions = new HashMap<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String,String>>>()
  	descriptionBoxRefinements = new HashMap<String, Pair<DescriptionBoxRefinement, Map<String,String>>>()
  	binaryScalarRestrictions = new HashMap<String, Pair<BinaryScalarRestriction, Map<String,String>>>()
  	iriScalarRestrictions = new HashMap<String, Pair<IRIScalarRestriction, Map<String,String>>>()
  	numericScalarRestrictions = new HashMap<String, Pair<NumericScalarRestriction, Map<String,String>>>()
  	plainLiteralScalarRestrictions = new HashMap<String, Pair<PlainLiteralScalarRestriction, Map<String,String>>>()
  	scalarOneOfRestrictions = new HashMap<String, Pair<ScalarOneOfRestriction, Map<String,String>>>()
  	scalarOneOfLiteralAxioms = new HashMap<String, Pair<ScalarOneOfLiteralAxiom, Map<String,String>>>()
  	stringScalarRestrictions = new HashMap<String, Pair<StringScalarRestriction, Map<String,String>>>()
  	synonymScalarRestrictions = new HashMap<String, Pair<SynonymScalarRestriction, Map<String,String>>>()
  	timeScalarRestrictions = new HashMap<String, Pair<TimeScalarRestriction, Map<String,String>>>()
  	entityScalarDataProperties = new HashMap<String, Pair<EntityScalarDataProperty, Map<String,String>>>()
  	entityStructuredDataProperties = new HashMap<String, Pair<EntityStructuredDataProperty, Map<String,String>>>()
  	scalarDataProperties = new HashMap<String, Pair<ScalarDataProperty, Map<String,String>>>()
  	structuredDataProperties = new HashMap<String, Pair<StructuredDataProperty, Map<String,String>>>()
  	reifiedRelationships = new HashMap<String, Pair<ReifiedRelationship, Map<String,String>>>()
  	reifiedRelationshipRestrictions = new HashMap<String, Pair<ReifiedRelationshipRestriction, Map<String,String>>>()
  	forwardProperties = new HashMap<String, Pair<ForwardProperty, Map<String,String>>>()
  	inverseProperties = new HashMap<String, Pair<InverseProperty, Map<String,String>>>()
  	unreifiedRelationships = new HashMap<String, Pair<UnreifiedRelationship, Map<String,String>>>()
  	chainRules = new HashMap<String, Pair<ChainRule, Map<String,String>>>()
  	ruleBodySegments = new HashMap<String, Pair<RuleBodySegment, Map<String,String>>>()
  	segmentPredicates = new HashMap<String, Pair<SegmentPredicate, Map<String,String>>>()
  	entityExistentialRestrictionAxioms = new HashMap<String, Pair<EntityExistentialRestrictionAxiom, Map<String,String>>>()
  	entityUniversalRestrictionAxioms = new HashMap<String, Pair<EntityUniversalRestrictionAxiom, Map<String,String>>>()
  	entityScalarDataPropertyExistentialRestrictionAxioms = new HashMap<String, Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String,String>>>()
  	entityScalarDataPropertyParticularRestrictionAxioms = new HashMap<String, Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String,String>>>()
  	entityScalarDataPropertyUniversalRestrictionAxioms = new HashMap<String, Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String,String>>>()
  	entityStructuredDataPropertyParticularRestrictionAxioms = new HashMap<String, Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String,String>>>()
  	restrictionStructuredDataPropertyTuples = new HashMap<String, Pair<RestrictionStructuredDataPropertyTuple, Map<String,String>>>()
  	restrictionScalarDataPropertyValues = new HashMap<String, Pair<RestrictionScalarDataPropertyValue, Map<String,String>>>()
  	aspectSpecializationAxioms = new HashMap<String, Pair<AspectSpecializationAxiom, Map<String,String>>>()
  	conceptSpecializationAxioms = new HashMap<String, Pair<ConceptSpecializationAxiom, Map<String,String>>>()
  	reifiedRelationshipSpecializationAxioms = new HashMap<String, Pair<ReifiedRelationshipSpecializationAxiom, Map<String,String>>>()
  	subDataPropertyOfAxioms = new HashMap<String, Pair<SubDataPropertyOfAxiom, Map<String,String>>>()
  	subObjectPropertyOfAxioms = new HashMap<String, Pair<SubObjectPropertyOfAxiom, Map<String,String>>>()
  	rootConceptTaxonomyAxioms = new HashMap<String, Pair<RootConceptTaxonomyAxiom, Map<String,String>>>()
  	anonymousConceptUnionAxioms = new HashMap<String, Pair<AnonymousConceptUnionAxiom, Map<String,String>>>()
  	specificDisjointConceptAxioms = new HashMap<String, Pair<SpecificDisjointConceptAxiom, Map<String,String>>>()
  	conceptInstances = new HashMap<String, Pair<ConceptInstance, Map<String,String>>>()
  	reifiedRelationshipInstances = new HashMap<String, Pair<ReifiedRelationshipInstance, Map<String,String>>>()
  	reifiedRelationshipInstanceDomains = new HashMap<String, Pair<ReifiedRelationshipInstanceDomain, Map<String,String>>>()
  	reifiedRelationshipInstanceRanges = new HashMap<String, Pair<ReifiedRelationshipInstanceRange, Map<String,String>>>()
  	unreifiedRelationshipInstanceTuples = new HashMap<String, Pair<UnreifiedRelationshipInstanceTuple, Map<String,String>>>()
  	singletonInstanceStructuredDataPropertyValues = new HashMap<String, Pair<SingletonInstanceStructuredDataPropertyValue, Map<String,String>>>()
  	singletonInstanceScalarDataPropertyValues = new HashMap<String, Pair<SingletonInstanceScalarDataPropertyValue, Map<String,String>>>()
  	structuredDataPropertyTuples = new HashMap<String, Pair<StructuredDataPropertyTuple, Map<String,String>>>()
  	scalarDataPropertyValues = new HashMap<String, Pair<ScalarDataPropertyValue, Map<String,String>>>()
  	annotationPropertyValues = new HashMap<String, Pair<AnnotationPropertyValue, Map<String,String>>>()
  	cardinalityRestrictedAspects = new HashMap<String, Pair<CardinalityRestrictedAspect, Map<String,String>>>()
  	cardinalityRestrictedConcepts = new HashMap<String, Pair<CardinalityRestrictedConcept, Map<String,String>>>()
  	cardinalityRestrictedReifiedRelationships = new HashMap<String, Pair<CardinalityRestrictedReifiedRelationship, Map<String,String>>>()
  
    modules = new HashMap<String, Pair<Module, Map<String,String>>>()
    logicalElements = new HashMap<String, Pair<LogicalElement, Map<String,String>>>()
    entities = new HashMap<String, Pair<Entity, Map<String,String>>>()
    aspectKinds = new HashMap<String, Pair<AspectKind, Map<String,String>>>()
    conceptKinds = new HashMap<String, Pair<ConceptKind, Map<String,String>>>()
    entityRelationships = new HashMap<String, Pair<EntityRelationship, Map<String,String>>>()
    conceptualRelationships = new HashMap<String, Pair<ConceptualRelationship, Map<String,String>>>()
    dataRanges = new HashMap<String, Pair<DataRange, Map<String,String>>>()
    dataRelationshipToScalars = new HashMap<String, Pair<DataRelationshipToScalar, Map<String,String>>>()
    dataRelationshipToStructures = new HashMap<String, Pair<DataRelationshipToStructure, Map<String,String>>>()
    predicates = new HashMap<String, Pair<Predicate, Map<String,String>>>()
    restrictableRelationships = new HashMap<String, Pair<RestrictableRelationship, Map<String,String>>>()
    restrictionStructuredDataPropertyContexts = new HashMap<String, Pair<RestrictionStructuredDataPropertyContext, Map<String,String>>>()
    terminologyBoxes = new HashMap<String, Pair<TerminologyBox, Map<String,String>>>()
    conceptTreeDisjunctions = new HashMap<String, Pair<ConceptTreeDisjunction, Map<String,String>>>()
    conceptualEntitySingletonInstances = new HashMap<String, Pair<ConceptualEntitySingletonInstance, Map<String,String>>>()
    singletonInstanceStructuredDataPropertyContexts = new HashMap<String, Pair<SingletonInstanceStructuredDataPropertyContext, Map<String,String>>>()
  }
  
  static def void save(Extent e, ZipArchiveOutputStream zos) {
    var ZipArchiveEntry entry = null
    // TerminologyGraph
    entry = new ZipArchiveEntry("TerminologyGraphs.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(terminologyGraphsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Bundle
    entry = new ZipArchiveEntry("Bundles.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(bundlesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // DescriptionBox
    entry = new ZipArchiveEntry("DescriptionBoxes.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(descriptionBoxesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // AnnotationProperty
    entry = new ZipArchiveEntry("AnnotationProperties.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(annotationPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Aspect
    entry = new ZipArchiveEntry("Aspects.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(aspectsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Concept
    entry = new ZipArchiveEntry("Concepts.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(conceptsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Scalar
    entry = new ZipArchiveEntry("Scalars.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Structure
    entry = new ZipArchiveEntry("Structures.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(structuresByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ConceptDesignationTerminologyAxiom
    entry = new ZipArchiveEntry("ConceptDesignationTerminologyAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(conceptDesignationTerminologyAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // TerminologyExtensionAxiom
    entry = new ZipArchiveEntry("TerminologyExtensionAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(terminologyExtensionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // TerminologyNestingAxiom
    entry = new ZipArchiveEntry("TerminologyNestingAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(terminologyNestingAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // BundledTerminologyAxiom
    entry = new ZipArchiveEntry("BundledTerminologyAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(bundledTerminologyAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // DescriptionBoxExtendsClosedWorldDefinitions
    entry = new ZipArchiveEntry("DescriptionBoxExtendsClosedWorldDefinitions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(descriptionBoxExtendsClosedWorldDefinitionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // DescriptionBoxRefinement
    entry = new ZipArchiveEntry("DescriptionBoxRefinements.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(descriptionBoxRefinementsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // BinaryScalarRestriction
    entry = new ZipArchiveEntry("BinaryScalarRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(binaryScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // IRIScalarRestriction
    entry = new ZipArchiveEntry("IRIScalarRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(iriScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // NumericScalarRestriction
    entry = new ZipArchiveEntry("NumericScalarRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(numericScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // PlainLiteralScalarRestriction
    entry = new ZipArchiveEntry("PlainLiteralScalarRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(plainLiteralScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ScalarOneOfRestriction
    entry = new ZipArchiveEntry("ScalarOneOfRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarOneOfRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ScalarOneOfLiteralAxiom
    entry = new ZipArchiveEntry("ScalarOneOfLiteralAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarOneOfLiteralAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // StringScalarRestriction
    entry = new ZipArchiveEntry("StringScalarRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(stringScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SynonymScalarRestriction
    entry = new ZipArchiveEntry("SynonymScalarRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(synonymScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // TimeScalarRestriction
    entry = new ZipArchiveEntry("TimeScalarRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(timeScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityScalarDataProperty
    entry = new ZipArchiveEntry("EntityScalarDataProperties.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityScalarDataPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityStructuredDataProperty
    entry = new ZipArchiveEntry("EntityStructuredDataProperties.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityStructuredDataPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ScalarDataProperty
    entry = new ZipArchiveEntry("ScalarDataProperties.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarDataPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // StructuredDataProperty
    entry = new ZipArchiveEntry("StructuredDataProperties.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(structuredDataPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationship
    entry = new ZipArchiveEntry("ReifiedRelationships.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipRestriction
    entry = new ZipArchiveEntry("ReifiedRelationshipRestrictions.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ForwardProperty
    entry = new ZipArchiveEntry("ForwardProperties.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(forwardPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // InverseProperty
    entry = new ZipArchiveEntry("InverseProperties.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(inversePropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // UnreifiedRelationship
    entry = new ZipArchiveEntry("UnreifiedRelationships.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(unreifiedRelationshipsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ChainRule
    entry = new ZipArchiveEntry("ChainRules.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(chainRulesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // RuleBodySegment
    entry = new ZipArchiveEntry("RuleBodySegments.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(ruleBodySegmentsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SegmentPredicate
    entry = new ZipArchiveEntry("SegmentPredicates.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(segmentPredicatesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityExistentialRestrictionAxiom
    entry = new ZipArchiveEntry("EntityExistentialRestrictionAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityExistentialRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityUniversalRestrictionAxiom
    entry = new ZipArchiveEntry("EntityUniversalRestrictionAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityUniversalRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityScalarDataPropertyExistentialRestrictionAxiom
    entry = new ZipArchiveEntry("EntityScalarDataPropertyExistentialRestrictionAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityScalarDataPropertyExistentialRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityScalarDataPropertyParticularRestrictionAxiom
    entry = new ZipArchiveEntry("EntityScalarDataPropertyParticularRestrictionAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityScalarDataPropertyParticularRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityScalarDataPropertyUniversalRestrictionAxiom
    entry = new ZipArchiveEntry("EntityScalarDataPropertyUniversalRestrictionAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityScalarDataPropertyUniversalRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityStructuredDataPropertyParticularRestrictionAxiom
    entry = new ZipArchiveEntry("EntityStructuredDataPropertyParticularRestrictionAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityStructuredDataPropertyParticularRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // RestrictionStructuredDataPropertyTuple
    entry = new ZipArchiveEntry("RestrictionStructuredDataPropertyTuples.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(restrictionStructuredDataPropertyTuplesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // RestrictionScalarDataPropertyValue
    entry = new ZipArchiveEntry("RestrictionScalarDataPropertyValues.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(restrictionScalarDataPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // AspectSpecializationAxiom
    entry = new ZipArchiveEntry("AspectSpecializationAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(aspectSpecializationAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ConceptSpecializationAxiom
    entry = new ZipArchiveEntry("ConceptSpecializationAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(conceptSpecializationAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipSpecializationAxiom
    entry = new ZipArchiveEntry("ReifiedRelationshipSpecializationAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipSpecializationAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SubDataPropertyOfAxiom
    entry = new ZipArchiveEntry("SubDataPropertyOfAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(subDataPropertyOfAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SubObjectPropertyOfAxiom
    entry = new ZipArchiveEntry("SubObjectPropertyOfAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(subObjectPropertyOfAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // RootConceptTaxonomyAxiom
    entry = new ZipArchiveEntry("RootConceptTaxonomyAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(rootConceptTaxonomyAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // AnonymousConceptUnionAxiom
    entry = new ZipArchiveEntry("AnonymousConceptUnionAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(anonymousConceptUnionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SpecificDisjointConceptAxiom
    entry = new ZipArchiveEntry("SpecificDisjointConceptAxioms.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(specificDisjointConceptAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ConceptInstance
    entry = new ZipArchiveEntry("ConceptInstances.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(conceptInstancesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipInstance
    entry = new ZipArchiveEntry("ReifiedRelationshipInstances.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipInstancesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipInstanceDomain
    entry = new ZipArchiveEntry("ReifiedRelationshipInstanceDomains.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipInstanceDomainsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipInstanceRange
    entry = new ZipArchiveEntry("ReifiedRelationshipInstanceRanges.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipInstanceRangesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // UnreifiedRelationshipInstanceTuple
    entry = new ZipArchiveEntry("UnreifiedRelationshipInstanceTuples.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(unreifiedRelationshipInstanceTuplesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SingletonInstanceStructuredDataPropertyValue
    entry = new ZipArchiveEntry("SingletonInstanceStructuredDataPropertyValues.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(singletonInstanceStructuredDataPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SingletonInstanceScalarDataPropertyValue
    entry = new ZipArchiveEntry("SingletonInstanceScalarDataPropertyValues.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(singletonInstanceScalarDataPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // StructuredDataPropertyTuple
    entry = new ZipArchiveEntry("StructuredDataPropertyTuples.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(structuredDataPropertyTuplesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ScalarDataPropertyValue
    entry = new ZipArchiveEntry("ScalarDataPropertyValues.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarDataPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // AnnotationPropertyValue
    entry = new ZipArchiveEntry("AnnotationPropertyValues.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(annotationPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // CardinalityRestrictedAspect
    entry = new ZipArchiveEntry("CardinalityRestrictedAspects.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(cardinalityRestrictedAspectsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // CardinalityRestrictedConcept
    entry = new ZipArchiveEntry("CardinalityRestrictedConcepts.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(cardinalityRestrictedConceptsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // CardinalityRestrictedReifiedRelationship
    entry = new ZipArchiveEntry("CardinalityRestrictedReifiedRelationships.json")
    entry.time = 0L
    zos.putArchiveEntry(entry)
    try {
      zos.write(cardinalityRestrictedReifiedRelationshipsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
  }
  
  protected static def byte[] terminologyGraphsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.terminologyGraphs(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"kind\":")
      pw.print(OMLTables.toString(it.kind))
      pw.print(",")
      pw.print("\"iri\":")
      pw.print(OMLTables.toString(it.iri()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] bundlesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.bundles(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"kind\":")
      pw.print(OMLTables.toString(it.kind))
      pw.print(",")
      pw.print("\"iri\":")
      pw.print(OMLTables.toString(it.iri()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] descriptionBoxesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.descriptionBoxes(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"kind\":")
      pw.print(OMLTables.toString(it.kind))
      pw.print(",")
      pw.print("\"iri\":")
      pw.print(OMLTables.toString(it.iri()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] annotationPropertiesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.annotationProperties(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"moduleUUID\":")
      pw.print("\"")
      pw.print(it.module.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"iri\":")
      pw.print(OMLTables.toString(it.iri()))
      pw.print(",")
      pw.print("\"abbrevIRI\":")
      pw.print(OMLTables.toString(it.abbrevIRI))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] aspectsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.aspects(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] conceptsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.concepts(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] scalarsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.scalars(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] structuresByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.structures(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] conceptDesignationTerminologyAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.conceptDesignationTerminologyAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"designatedConceptUUID\":")
      pw.print("\"")
      pw.print(it.designatedConcept.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"designatedTerminologyIRI\":")
      pw.print("\"")
      pw.print(it.designatedTerminology.iri())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] terminologyExtensionAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.terminologyExtensionAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"extendedTerminologyIRI\":")
      pw.print("\"")
      pw.print(it.extendedTerminology.iri())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] terminologyNestingAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.terminologyNestingAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"nestingContextUUID\":")
      pw.print("\"")
      pw.print(it.nestingContext.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"nestingTerminologyIRI\":")
      pw.print("\"")
      pw.print(it.nestingTerminology.iri())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] bundledTerminologyAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.bundledTerminologyAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"bundleUUID\":")
      pw.print("\"")
      pw.print(it.bundle.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"bundledTerminologyIRI\":")
      pw.print("\"")
      pw.print(it.bundledTerminology.iri())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] descriptionBoxExtendsClosedWorldDefinitionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.descriptionBoxExtendsClosedWorldDefinitions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"descriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.descriptionBox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"closedWorldDefinitionsIRI\":")
      pw.print("\"")
      pw.print(it.closedWorldDefinitions.iri())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] descriptionBoxRefinementsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.descriptionBoxRefinements(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"refiningDescriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.refiningDescriptionBox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"refinedDescriptionBoxIRI\":")
      pw.print("\"")
      pw.print(it.refinedDescriptionBox.iri())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] binaryScalarRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.binaryScalarRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"length\":")
      pw.print(OMLTables.toString(it.length))
      pw.print(",")
      pw.print("\"minLength\":")
      pw.print(OMLTables.toString(it.minLength))
      pw.print(",")
      pw.print("\"maxLength\":")
      pw.print(OMLTables.toString(it.maxLength))
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] iriScalarRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.iriScalarRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"length\":")
      pw.print(OMLTables.toString(it.length))
      pw.print(",")
      pw.print("\"minLength\":")
      pw.print(OMLTables.toString(it.minLength))
      pw.print(",")
      pw.print("\"maxLength\":")
      pw.print(OMLTables.toString(it.maxLength))
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"pattern\":")
      pw.print(OMLTables.toString(it.pattern))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] numericScalarRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.numericScalarRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"minExclusive\":")
      pw.print(OMLTables.toString(it.minExclusive))
      pw.print(",")
      pw.print("\"minInclusive\":")
      pw.print(OMLTables.toString(it.minInclusive))
      pw.print(",")
      pw.print("\"maxExclusive\":")
      pw.print(OMLTables.toString(it.maxExclusive))
      pw.print(",")
      pw.print("\"maxInclusive\":")
      pw.print(OMLTables.toString(it.maxInclusive))
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] plainLiteralScalarRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.plainLiteralScalarRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"length\":")
      pw.print(OMLTables.toString(it.length))
      pw.print(",")
      pw.print("\"minLength\":")
      pw.print(OMLTables.toString(it.minLength))
      pw.print(",")
      pw.print("\"maxLength\":")
      pw.print(OMLTables.toString(it.maxLength))
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"langRange\":")
      pw.print(OMLTables.toString(it.langRange))
      pw.print(",")
      pw.print("\"pattern\":")
      pw.print(OMLTables.toString(it.pattern))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] scalarOneOfRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.scalarOneOfRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] scalarOneOfLiteralAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.scalarOneOfLiteralAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"axiomUUID\":")
      pw.print("\"")
      pw.print(it.axiom.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"value\":")
      pw.print(OMLTables.toString(it.value))
      pw.print(",")
      pw.print("\"valueTypeUUID\":")
      if (null !== valueType) {
        pw.print("\"")
        pw.print(it.valueType?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] stringScalarRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.stringScalarRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"length\":")
      pw.print(OMLTables.toString(it.length))
      pw.print(",")
      pw.print("\"minLength\":")
      pw.print(OMLTables.toString(it.minLength))
      pw.print(",")
      pw.print("\"maxLength\":")
      pw.print(OMLTables.toString(it.maxLength))
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"pattern\":")
      pw.print(OMLTables.toString(it.pattern))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] synonymScalarRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.synonymScalarRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] timeScalarRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.timeScalarRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"minExclusive\":")
      pw.print(OMLTables.toString(it.minExclusive))
      pw.print(",")
      pw.print("\"minInclusive\":")
      pw.print(OMLTables.toString(it.minInclusive))
      pw.print(",")
      pw.print("\"maxExclusive\":")
      pw.print(OMLTables.toString(it.maxExclusive))
      pw.print(",")
      pw.print("\"maxInclusive\":")
      pw.print(OMLTables.toString(it.maxInclusive))
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] entityScalarDataPropertiesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.entityScalarDataProperties(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"domainUUID\":")
      pw.print("\"")
      pw.print(it.domain.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"rangeUUID\":")
      pw.print("\"")
      pw.print(it.range.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"isIdentityCriteria\":")
      pw.print("\"")
      pw.print(it.isIdentityCriteria)
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] entityStructuredDataPropertiesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.entityStructuredDataProperties(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"domainUUID\":")
      pw.print("\"")
      pw.print(it.domain.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"rangeUUID\":")
      pw.print("\"")
      pw.print(it.range.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"isIdentityCriteria\":")
      pw.print("\"")
      pw.print(it.isIdentityCriteria)
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] scalarDataPropertiesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.scalarDataProperties(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"domainUUID\":")
      pw.print("\"")
      pw.print(it.domain.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"rangeUUID\":")
      pw.print("\"")
      pw.print(it.range.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] structuredDataPropertiesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.structuredDataProperties(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"domainUUID\":")
      pw.print("\"")
      pw.print(it.domain.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"rangeUUID\":")
      pw.print("\"")
      pw.print(it.range.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] reifiedRelationshipsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.reifiedRelationships(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"sourceUUID\":")
      pw.print("\"")
      pw.print(it.source.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"targetUUID\":")
      pw.print("\"")
      pw.print(it.target.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"isAsymmetric\":")
      pw.print("\"")
      pw.print(it.isAsymmetric)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isEssential\":")
      pw.print("\"")
      pw.print(it.isEssential)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isFunctional\":")
      pw.print("\"")
      pw.print(it.isFunctional)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isInverseEssential\":")
      pw.print("\"")
      pw.print(it.isInverseEssential)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isInverseFunctional\":")
      pw.print("\"")
      pw.print(it.isInverseFunctional)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isIrreflexive\":")
      pw.print("\"")
      pw.print(it.isIrreflexive)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isReflexive\":")
      pw.print("\"")
      pw.print(it.isReflexive)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isSymmetric\":")
      pw.print("\"")
      pw.print(it.isSymmetric)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isTransitive\":")
      pw.print("\"")
      pw.print(it.isTransitive)
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] reifiedRelationshipRestrictionsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.reifiedRelationshipRestrictions(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"sourceUUID\":")
      pw.print("\"")
      pw.print(it.source.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"targetUUID\":")
      pw.print("\"")
      pw.print(it.target.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] forwardPropertiesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.forwardProperties(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"reifiedRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.reifiedRelationship.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] inversePropertiesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.inverseProperties(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"reifiedRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.reifiedRelationship.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] unreifiedRelationshipsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.unreifiedRelationships(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"sourceUUID\":")
      pw.print("\"")
      pw.print(it.source.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"targetUUID\":")
      pw.print("\"")
      pw.print(it.target.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"isAsymmetric\":")
      pw.print("\"")
      pw.print(it.isAsymmetric)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isEssential\":")
      pw.print("\"")
      pw.print(it.isEssential)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isFunctional\":")
      pw.print("\"")
      pw.print(it.isFunctional)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isInverseEssential\":")
      pw.print("\"")
      pw.print(it.isInverseEssential)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isInverseFunctional\":")
      pw.print("\"")
      pw.print(it.isInverseFunctional)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isIrreflexive\":")
      pw.print("\"")
      pw.print(it.isIrreflexive)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isReflexive\":")
      pw.print("\"")
      pw.print(it.isReflexive)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isSymmetric\":")
      pw.print("\"")
      pw.print(it.isSymmetric)
      pw.print("\"")
      pw.print(",")
      pw.print("\"isTransitive\":")
      pw.print("\"")
      pw.print(it.isTransitive)
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] chainRulesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.chainRules(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"headUUID\":")
      pw.print("\"")
      pw.print(it.head.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] ruleBodySegmentsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.ruleBodySegments(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"previousSegmentUUID\":")
      if (null !== previousSegment) {
        pw.print("\"")
        pw.print(it.previousSegment?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"ruleUUID\":")
      if (null !== rule) {
        pw.print("\"")
        pw.print(it.rule?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] segmentPredicatesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.segmentPredicates(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"bodySegmentUUID\":")
      pw.print("\"")
      pw.print(it.bodySegment.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"predicateUUID\":")
      if (null !== predicate) {
        pw.print("\"")
        pw.print(it.predicate?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"reifiedRelationshipSourceUUID\":")
      if (null !== reifiedRelationshipSource) {
        pw.print("\"")
        pw.print(it.reifiedRelationshipSource?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"reifiedRelationshipInverseSourceUUID\":")
      if (null !== reifiedRelationshipInverseSource) {
        pw.print("\"")
        pw.print(it.reifiedRelationshipInverseSource?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"reifiedRelationshipTargetUUID\":")
      if (null !== reifiedRelationshipTarget) {
        pw.print("\"")
        pw.print(it.reifiedRelationshipTarget?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"reifiedRelationshipInverseTargetUUID\":")
      if (null !== reifiedRelationshipInverseTarget) {
        pw.print("\"")
        pw.print(it.reifiedRelationshipInverseTarget?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"unreifiedRelationshipInverseUUID\":")
      if (null !== unreifiedRelationshipInverse) {
        pw.print("\"")
        pw.print(it.unreifiedRelationshipInverse?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] entityExistentialRestrictionAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.entityExistentialRestrictionAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedDomainUUID\":")
      pw.print("\"")
      pw.print(it.restrictedDomain.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRelationship.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] entityUniversalRestrictionAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.entityUniversalRestrictionAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedDomainUUID\":")
      pw.print("\"")
      pw.print(it.restrictedDomain.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRange.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRelationship.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] entityScalarDataPropertyExistentialRestrictionAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.entityScalarDataPropertyExistentialRestrictionAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedEntityUUID\":")
      pw.print("\"")
      pw.print(it.restrictedEntity.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarPropertyUUID\":")
      pw.print("\"")
      pw.print(it.scalarProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarRestrictionUUID\":")
      pw.print("\"")
      pw.print(it.scalarRestriction.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] entityScalarDataPropertyParticularRestrictionAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.entityScalarDataPropertyParticularRestrictionAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedEntityUUID\":")
      pw.print("\"")
      pw.print(it.restrictedEntity.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarPropertyUUID\":")
      pw.print("\"")
      pw.print(it.scalarProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"literalValue\":")
      pw.print(OMLTables.toString(it.literalValue))
      pw.print(",")
      pw.print("\"valueTypeUUID\":")
      if (null !== valueType) {
        pw.print("\"")
        pw.print(it.valueType?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] entityScalarDataPropertyUniversalRestrictionAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.entityScalarDataPropertyUniversalRestrictionAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedEntityUUID\":")
      pw.print("\"")
      pw.print(it.restrictedEntity.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarPropertyUUID\":")
      pw.print("\"")
      pw.print(it.scalarProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarRestrictionUUID\":")
      pw.print("\"")
      pw.print(it.scalarRestriction.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] entityStructuredDataPropertyParticularRestrictionAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.entityStructuredDataPropertyParticularRestrictionAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"structuredDataPropertyUUID\":")
      pw.print("\"")
      pw.print(it.structuredDataProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedEntityUUID\":")
      pw.print("\"")
      pw.print(it.restrictedEntity.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] restrictionStructuredDataPropertyTuplesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.restrictionStructuredDataPropertyTuples(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"structuredDataPropertyContextUUID\":")
      pw.print("\"")
      pw.print(it.structuredDataPropertyContext.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"structuredDataPropertyUUID\":")
      pw.print("\"")
      pw.print(it.structuredDataProperty.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] restrictionScalarDataPropertyValuesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.restrictionScalarDataPropertyValues(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"structuredDataPropertyContextUUID\":")
      pw.print("\"")
      pw.print(it.structuredDataPropertyContext.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarDataPropertyUUID\":")
      pw.print("\"")
      pw.print(it.scalarDataProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarPropertyValue\":")
      pw.print(OMLTables.toString(it.scalarPropertyValue))
      pw.print(",")
      pw.print("\"valueTypeUUID\":")
      if (null !== valueType) {
        pw.print("\"")
        pw.print(it.valueType?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] aspectSpecializationAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.aspectSpecializationAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"superAspectUUID\":")
      pw.print("\"")
      pw.print(it.superAspect.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"subEntityUUID\":")
      pw.print("\"")
      pw.print(it.subEntity.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] conceptSpecializationAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.conceptSpecializationAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"superConceptUUID\":")
      pw.print("\"")
      pw.print(it.superConcept.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"subConceptUUID\":")
      pw.print("\"")
      pw.print(it.subConcept.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] reifiedRelationshipSpecializationAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.reifiedRelationshipSpecializationAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"superRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.superRelationship.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"subRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.subRelationship.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] subDataPropertyOfAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.subDataPropertyOfAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"subPropertyUUID\":")
      pw.print("\"")
      pw.print(it.subProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"superPropertyUUID\":")
      pw.print("\"")
      pw.print(it.superProperty.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] subObjectPropertyOfAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.subObjectPropertyOfAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"subPropertyUUID\":")
      pw.print("\"")
      pw.print(it.subProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"superPropertyUUID\":")
      pw.print("\"")
      pw.print(it.superProperty.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] rootConceptTaxonomyAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.rootConceptTaxonomyAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"bundleUUID\":")
      pw.print("\"")
      pw.print(it.bundle.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"rootUUID\":")
      pw.print("\"")
      pw.print(it.root.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] anonymousConceptUnionAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.anonymousConceptUnionAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"disjointTaxonomyParentUUID\":")
      pw.print("\"")
      pw.print(it.disjointTaxonomyParent.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] specificDisjointConceptAxiomsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.specificDisjointConceptAxioms(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"disjointTaxonomyParentUUID\":")
      pw.print("\"")
      pw.print(it.disjointTaxonomyParent.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"disjointLeafUUID\":")
      pw.print("\"")
      pw.print(it.disjointLeaf.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] conceptInstancesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.conceptInstances(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"descriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.descriptionBox().uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"singletonConceptClassifierUUID\":")
      pw.print("\"")
      pw.print(it.singletonConceptClassifier.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] reifiedRelationshipInstancesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.reifiedRelationshipInstances(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"descriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.descriptionBox().uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"singletonConceptualRelationshipClassifierUUID\":")
      pw.print("\"")
      pw.print(it.singletonConceptualRelationshipClassifier.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] reifiedRelationshipInstanceDomainsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.reifiedRelationshipInstanceDomains(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"descriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.descriptionBox().uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"reifiedRelationshipInstanceUUID\":")
      pw.print("\"")
      pw.print(it.reifiedRelationshipInstance.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"domainUUID\":")
      pw.print("\"")
      pw.print(it.domain.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] reifiedRelationshipInstanceRangesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.reifiedRelationshipInstanceRanges(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"descriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.descriptionBox().uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"reifiedRelationshipInstanceUUID\":")
      pw.print("\"")
      pw.print(it.reifiedRelationshipInstance.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"rangeUUID\":")
      pw.print("\"")
      pw.print(it.range.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] unreifiedRelationshipInstanceTuplesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.unreifiedRelationshipInstanceTuples(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"descriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.descriptionBox().uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"unreifiedRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.unreifiedRelationship.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"domainUUID\":")
      pw.print("\"")
      pw.print(it.domain.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"rangeUUID\":")
      pw.print("\"")
      pw.print(it.range.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] singletonInstanceStructuredDataPropertyValuesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.singletonInstanceStructuredDataPropertyValues(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"descriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.descriptionBox().uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"singletonInstanceUUID\":")
      pw.print("\"")
      pw.print(it.singletonInstance.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"structuredDataPropertyUUID\":")
      pw.print("\"")
      pw.print(it.structuredDataProperty.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] singletonInstanceScalarDataPropertyValuesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.singletonInstanceScalarDataPropertyValues(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"descriptionBoxUUID\":")
      pw.print("\"")
      pw.print(it.descriptionBox().uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"singletonInstanceUUID\":")
      pw.print("\"")
      pw.print(it.singletonInstance.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarDataPropertyUUID\":")
      pw.print("\"")
      pw.print(it.scalarDataProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarPropertyValue\":")
      pw.print(OMLTables.toString(it.scalarPropertyValue))
      pw.print(",")
      pw.print("\"valueTypeUUID\":")
      if (null !== valueType) {
        pw.print("\"")
        pw.print(it.valueType?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] structuredDataPropertyTuplesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.structuredDataPropertyTuples(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"structuredDataPropertyContextUUID\":")
      pw.print("\"")
      pw.print(it.structuredDataPropertyContext.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"structuredDataPropertyUUID\":")
      pw.print("\"")
      pw.print(it.structuredDataProperty.uuid())
      pw.print("\"")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] scalarDataPropertyValuesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.scalarDataPropertyValues(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"structuredDataPropertyContextUUID\":")
      pw.print("\"")
      pw.print(it.structuredDataPropertyContext.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarDataPropertyUUID\":")
      pw.print("\"")
      pw.print(it.scalarDataProperty.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"scalarPropertyValue\":")
      pw.print(OMLTables.toString(it.scalarPropertyValue))
      pw.print(",")
      pw.print("\"valueTypeUUID\":")
      if (null !== valueType) {
        pw.print("\"")
        pw.print(it.valueType?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] annotationPropertyValuesByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.annotationPropertyValues(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"subjectUUID\":")
      pw.print("\"")
      pw.print(it.subject.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"propertyUUID\":")
      pw.print("\"")
      pw.print(it.property.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"value\":")
      pw.print(OMLTables.toString(it.value))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] cardinalityRestrictedAspectsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.cardinalityRestrictedAspects(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      if (null !== restrictedRange) {
        pw.print("\"")
        pw.print(it.restrictedRange?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"restrictedCardinality\":")
      pw.print(OMLTables.toString(it.restrictedCardinality))
      pw.print(",")
      pw.print("\"restrictedRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRelationship.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictionKind\":")
      pw.print(OMLTables.toString(it.restrictionKind))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] cardinalityRestrictedConceptsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.cardinalityRestrictedConcepts(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      if (null !== restrictedRange) {
        pw.print("\"")
        pw.print(it.restrictedRange?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"restrictedCardinality\":")
      pw.print(OMLTables.toString(it.restrictedCardinality))
      pw.print(",")
      pw.print("\"restrictedRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRelationship.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictionKind\":")
      pw.print(OMLTables.toString(it.restrictionKind))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  protected static def byte[] cardinalityRestrictedReifiedRelationshipsByteArray(Extent e) {
  	val ByteArrayOutputStream bos = new ByteArrayOutputStream()
  	val PrintWriter pw = new PrintWriter(bos)
  	OMLTables.cardinalityRestrictedReifiedRelationships(e).forEach[it |
  	  pw.print("{")
      pw.print("\"uuid\":")
      pw.print("\"")
      pw.print(it.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"tboxUUID\":")
      pw.print("\"")
      pw.print(it.tbox.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictedRangeUUID\":")
      if (null !== restrictedRange) {
        pw.print("\"")
        pw.print(it.restrictedRange?.uuid())
        pw.print("\"")
      } else
        pw.print("null")
      pw.print(",")
      pw.print("\"name\":")
      pw.print(OMLTables.toString(it.name()))
      pw.print(",")
      pw.print("\"restrictedCardinality\":")
      pw.print(OMLTables.toString(it.restrictedCardinality))
      pw.print(",")
      pw.print("\"restrictedRelationshipUUID\":")
      pw.print("\"")
      pw.print(it.restrictedRelationship.uuid())
      pw.print("\"")
      pw.print(",")
      pw.print("\"restrictionKind\":")
      pw.print(OMLTables.toString(it.restrictionKind))
      pw.println("}")
    ]
    pw.close()
    return bos.toByteArray()
  }
  
  		    	    
  /**
   * Uses an OMLSpecificationTables for resolving cross-references in the *.oml and *.omlzip representations.
   * When there are no more OML resources to load, it is necessary to call explicitly: 
   * 
   *     OMLZipResource.clearOMLSpecificationTables(rs)
   */
  static def void load(ResourceSet rs, OMLZipResource r, File omlZipFile) {

	val fileURI = URI.createFileURI(omlZipFile.absolutePath)
	val c = OMLExtensions.findCatalogIfExists(rs, fileURI)
	if (null === c)
		throw new IllegalArgumentException("OMLSpecificationTables.load(): failed to find an OML catalog from: "+fileURI)
	if (c.parsedCatalogs.empty)
		throw new IllegalArgumentException("OMLSpecificationTables.load(): No OML catalog found from: "+fileURI)
	if (c.entries.empty)
		throw new IllegalArgumentException("OMLSpecificationTables.load(): Empty OML catalog from: "+c.parsedCatalogs.join("\n"))
						      
    val tables = OMLZipResource.getOrInitializeOMLSpecificationTables(rs)
    val ext = tables.omlCommonFactory.createExtent()
    r.contents.add(ext)
    val zip = new ZipFile(omlZipFile)
    try {
  		Collections.list(zip.entries).forEach[ze | 
      		val is = zip.getInputStream(ze)
      		val buffer = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
      		val lines = new ArrayList<String>()
      		lines.addAll(buffer.lines().iterator.toIterable)
      		is.close()
      		switch ze.name {
  	    			case "TerminologyGraphs.json":
  	    				tables.readTerminologyGraphs(ext, lines)
  	    			case "Bundles.json":
  	    				tables.readBundles(ext, lines)
  	    			case "DescriptionBoxes.json":
  	    				tables.readDescriptionBoxes(ext, lines)
  	    			case "AnnotationProperties.json":
  	    				tables.readAnnotationProperties(ext, lines)
  	    			case "Aspects.json":
  	    				tables.readAspects(ext, lines)
  	    			case "Concepts.json":
  	    				tables.readConcepts(ext, lines)
  	    			case "Scalars.json":
  	    				tables.readScalars(ext, lines)
  	    			case "Structures.json":
  	    				tables.readStructures(ext, lines)
  	    			case "ConceptDesignationTerminologyAxioms.json":
  	    				tables.readConceptDesignationTerminologyAxioms(ext, lines)
  	    			case "TerminologyExtensionAxioms.json":
  	    				tables.readTerminologyExtensionAxioms(ext, lines)
  	    			case "TerminologyNestingAxioms.json":
  	    				tables.readTerminologyNestingAxioms(ext, lines)
  	    			case "BundledTerminologyAxioms.json":
  	    				tables.readBundledTerminologyAxioms(ext, lines)
  	    			case "DescriptionBoxExtendsClosedWorldDefinitions.json":
  	    				tables.readDescriptionBoxExtendsClosedWorldDefinitions(ext, lines)
  	    			case "DescriptionBoxRefinements.json":
  	    				tables.readDescriptionBoxRefinements(ext, lines)
  	    			case "BinaryScalarRestrictions.json":
  	    				tables.readBinaryScalarRestrictions(ext, lines)
  	    			case "IRIScalarRestrictions.json":
  	    				tables.readIRIScalarRestrictions(ext, lines)
  	    			case "NumericScalarRestrictions.json":
  	    				tables.readNumericScalarRestrictions(ext, lines)
  	    			case "PlainLiteralScalarRestrictions.json":
  	    				tables.readPlainLiteralScalarRestrictions(ext, lines)
  	    			case "ScalarOneOfRestrictions.json":
  	    				tables.readScalarOneOfRestrictions(ext, lines)
  	    			case "ScalarOneOfLiteralAxioms.json":
  	    				tables.readScalarOneOfLiteralAxioms(ext, lines)
  	    			case "StringScalarRestrictions.json":
  	    				tables.readStringScalarRestrictions(ext, lines)
  	    			case "SynonymScalarRestrictions.json":
  	    				tables.readSynonymScalarRestrictions(ext, lines)
  	    			case "TimeScalarRestrictions.json":
  	    				tables.readTimeScalarRestrictions(ext, lines)
  	    			case "EntityScalarDataProperties.json":
  	    				tables.readEntityScalarDataProperties(ext, lines)
  	    			case "EntityStructuredDataProperties.json":
  	    				tables.readEntityStructuredDataProperties(ext, lines)
  	    			case "ScalarDataProperties.json":
  	    				tables.readScalarDataProperties(ext, lines)
  	    			case "StructuredDataProperties.json":
  	    				tables.readStructuredDataProperties(ext, lines)
  	    			case "ReifiedRelationships.json":
  	    				tables.readReifiedRelationships(ext, lines)
  	    			case "ReifiedRelationshipRestrictions.json":
  	    				tables.readReifiedRelationshipRestrictions(ext, lines)
  	    			case "ForwardProperties.json":
  	    				tables.readForwardProperties(ext, lines)
  	    			case "InverseProperties.json":
  	    				tables.readInverseProperties(ext, lines)
  	    			case "UnreifiedRelationships.json":
  	    				tables.readUnreifiedRelationships(ext, lines)
  	    			case "ChainRules.json":
  	    				tables.readChainRules(ext, lines)
  	    			case "RuleBodySegments.json":
  	    				tables.readRuleBodySegments(ext, lines)
  	    			case "SegmentPredicates.json":
  	    				tables.readSegmentPredicates(ext, lines)
  	    			case "EntityExistentialRestrictionAxioms.json":
  	    				tables.readEntityExistentialRestrictionAxioms(ext, lines)
  	    			case "EntityUniversalRestrictionAxioms.json":
  	    				tables.readEntityUniversalRestrictionAxioms(ext, lines)
  	    			case "EntityScalarDataPropertyExistentialRestrictionAxioms.json":
  	    				tables.readEntityScalarDataPropertyExistentialRestrictionAxioms(ext, lines)
  	    			case "EntityScalarDataPropertyParticularRestrictionAxioms.json":
  	    				tables.readEntityScalarDataPropertyParticularRestrictionAxioms(ext, lines)
  	    			case "EntityScalarDataPropertyUniversalRestrictionAxioms.json":
  	    				tables.readEntityScalarDataPropertyUniversalRestrictionAxioms(ext, lines)
  	    			case "EntityStructuredDataPropertyParticularRestrictionAxioms.json":
  	    				tables.readEntityStructuredDataPropertyParticularRestrictionAxioms(ext, lines)
  	    			case "RestrictionStructuredDataPropertyTuples.json":
  	    				tables.readRestrictionStructuredDataPropertyTuples(ext, lines)
  	    			case "RestrictionScalarDataPropertyValues.json":
  	    				tables.readRestrictionScalarDataPropertyValues(ext, lines)
  	    			case "AspectSpecializationAxioms.json":
  	    				tables.readAspectSpecializationAxioms(ext, lines)
  	    			case "ConceptSpecializationAxioms.json":
  	    				tables.readConceptSpecializationAxioms(ext, lines)
  	    			case "ReifiedRelationshipSpecializationAxioms.json":
  	    				tables.readReifiedRelationshipSpecializationAxioms(ext, lines)
  	    			case "SubDataPropertyOfAxioms.json":
  	    				tables.readSubDataPropertyOfAxioms(ext, lines)
  	    			case "SubObjectPropertyOfAxioms.json":
  	    				tables.readSubObjectPropertyOfAxioms(ext, lines)
  	    			case "RootConceptTaxonomyAxioms.json":
  	    				tables.readRootConceptTaxonomyAxioms(ext, lines)
  	    			case "AnonymousConceptUnionAxioms.json":
  	    				tables.readAnonymousConceptUnionAxioms(ext, lines)
  	    			case "SpecificDisjointConceptAxioms.json":
  	    				tables.readSpecificDisjointConceptAxioms(ext, lines)
  	    			case "ConceptInstances.json":
  	    				tables.readConceptInstances(ext, lines)
  	    			case "ReifiedRelationshipInstances.json":
  	    				tables.readReifiedRelationshipInstances(ext, lines)
  	    			case "ReifiedRelationshipInstanceDomains.json":
  	    				tables.readReifiedRelationshipInstanceDomains(ext, lines)
  	    			case "ReifiedRelationshipInstanceRanges.json":
  	    				tables.readReifiedRelationshipInstanceRanges(ext, lines)
  	    			case "UnreifiedRelationshipInstanceTuples.json":
  	    				tables.readUnreifiedRelationshipInstanceTuples(ext, lines)
  	    			case "SingletonInstanceStructuredDataPropertyValues.json":
  	    				tables.readSingletonInstanceStructuredDataPropertyValues(ext, lines)
  	    			case "SingletonInstanceScalarDataPropertyValues.json":
  	    				tables.readSingletonInstanceScalarDataPropertyValues(ext, lines)
  	    			case "StructuredDataPropertyTuples.json":
  	    				tables.readStructuredDataPropertyTuples(ext, lines)
  	    			case "ScalarDataPropertyValues.json":
  	    				tables.readScalarDataPropertyValues(ext, lines)
  	    			case "AnnotationPropertyValues.json":
  	    				tables.readAnnotationPropertyValues(ext, lines)
  	    			case "CardinalityRestrictedAspects.json":
  	    				tables.readCardinalityRestrictedAspects(ext, lines)
  	    			case "CardinalityRestrictedConcepts.json":
  	    				tables.readCardinalityRestrictedConcepts(ext, lines)
  	    			case "CardinalityRestrictedReifiedRelationships.json":
  	    				tables.readCardinalityRestrictedReifiedRelationships(ext, lines)
        			default:
          			throw new IllegalArgumentException("OMLSpecificationTables.load(): unrecognized table name: "+ze.name)
      		}
    		]
    } finally {
	    zip.close()
	}

    tables.processQueue(rs)
    
    tables.resolve(rs, r)
  }
  
  def void queueModule(Module m) {
  	moduleQueue.add(m)
  }
  
  def void processQueue(ResourceSet rs) {
    var Boolean more = false
    do {
        more = false
        if (!iriLoadQueue.empty) {
        	more = true
        	val iri = iriLoadQueue.remove
        	if (visitedIRIs.add(iri)) {
			  loadOMLZipResource(rs, URI.createURI(iri))	
     	 	}
        }
        
        if (!moduleQueue.empty) {
        	more = true
        	val m = moduleQueue.remove
        	if (visitedModules.add(m)) {
			  includeModule(m)
        	}
        }
    } while (more)
  }
  
  protected def void readTerminologyGraphs(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createTerminologyGraph()
  	  ext.getModules.add(oml)
  	  val uuid = kv.remove("uuid")
  	  oml.kind = OMLTables.toTerminologyKind(kv.remove("kind"))
  	  oml.iri = OMLTables.toIRI(kv.remove("iri"))
  	  val pair = new Pair<TerminologyGraph, Map<String,String>>(oml, kv)
  	  terminologyGraphs.put(uuid, pair)
  	  includeTerminologyGraphs(uuid, oml)
  	}
  }
  
  protected def void readBundles(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createBundle()
  	  ext.getModules.add(oml)
  	  val uuid = kv.remove("uuid")
  	  oml.kind = OMLTables.toTerminologyKind(kv.remove("kind"))
  	  oml.iri = OMLTables.toIRI(kv.remove("iri"))
  	  val pair = new Pair<Bundle, Map<String,String>>(oml, kv)
  	  bundles.put(uuid, pair)
  	  includeBundles(uuid, oml)
  	}
  }
  
  protected def void readDescriptionBoxes(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createDescriptionBox()
  	  ext.getModules.add(oml)
  	  val uuid = kv.remove("uuid")
  	  oml.kind = OMLTables.toDescriptionKind(kv.remove("kind"))
  	  oml.iri = OMLTables.toIRI(kv.remove("iri"))
  	  val pair = new Pair<DescriptionBox, Map<String,String>>(oml, kv)
  	  descriptionBoxes.put(uuid, pair)
  	  includeDescriptionBoxes(uuid, oml)
  	}
  }
  
  protected def void readAnnotationProperties(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createAnnotationProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.iri = OMLTables.toIRI(kv.remove("iri"))
  	  oml.abbrevIRI = OMLTables.toAbbrevIRI(kv.remove("abbrevIRI"))
  	  val pair = new Pair<AnnotationProperty, Map<String,String>>(oml, kv)
  	  annotationProperties.put(uuid, pair)
  	  includeAnnotationProperties(uuid, oml)
  	}
  }
  
  protected def void readAspects(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createAspect()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<Aspect, Map<String,String>>(oml, kv)
  	  aspects.put(uuid, pair)
  	  includeAspects(uuid, oml)
  	}
  }
  
  protected def void readConcepts(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createConcept()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<Concept, Map<String,String>>(oml, kv)
  	  concepts.put(uuid, pair)
  	  includeConcepts(uuid, oml)
  	}
  }
  
  protected def void readScalars(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createScalar()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<Scalar, Map<String,String>>(oml, kv)
  	  scalars.put(uuid, pair)
  	  includeScalars(uuid, oml)
  	}
  }
  
  protected def void readStructures(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createStructure()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<Structure, Map<String,String>>(oml, kv)
  	  structures.put(uuid, pair)
  	  includeStructures(uuid, oml)
  	}
  }
  
  protected def void readConceptDesignationTerminologyAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createConceptDesignationTerminologyAxiom()
  	  val uuid = kv.remove("uuid")
  	  val String designatedTerminologyIRI = kv.get("designatedTerminologyIRI")
  	  if (null === designatedTerminologyIRI)
  	  	throw new IllegalArgumentException("readConceptDesignationTerminologyAxioms: missing 'designatedTerminologyIRI' in: "+kv.toString)
  	  iriLoadQueue.add(designatedTerminologyIRI)
  	  val pair = new Pair<ConceptDesignationTerminologyAxiom, Map<String,String>>(oml, kv)
  	  conceptDesignationTerminologyAxioms.put(uuid, pair)
  	  includeConceptDesignationTerminologyAxioms(uuid, oml)
  	}
  }
  
  protected def void readTerminologyExtensionAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createTerminologyExtensionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val String extendedTerminologyIRI = kv.get("extendedTerminologyIRI")
  	  if (null === extendedTerminologyIRI)
  	  	throw new IllegalArgumentException("readTerminologyExtensionAxioms: missing 'extendedTerminologyIRI' in: "+kv.toString)
  	  iriLoadQueue.add(extendedTerminologyIRI)
  	  val pair = new Pair<TerminologyExtensionAxiom, Map<String,String>>(oml, kv)
  	  terminologyExtensionAxioms.put(uuid, pair)
  	  includeTerminologyExtensionAxioms(uuid, oml)
  	}
  }
  
  protected def void readTerminologyNestingAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createTerminologyNestingAxiom()
  	  val uuid = kv.remove("uuid")
  	  val String nestingTerminologyIRI = kv.get("nestingTerminologyIRI")
  	  if (null === nestingTerminologyIRI)
  	  	throw new IllegalArgumentException("readTerminologyNestingAxioms: missing 'nestingTerminologyIRI' in: "+kv.toString)
  	  iriLoadQueue.add(nestingTerminologyIRI)
  	  val pair = new Pair<TerminologyNestingAxiom, Map<String,String>>(oml, kv)
  	  terminologyNestingAxioms.put(uuid, pair)
  	  includeTerminologyNestingAxioms(uuid, oml)
  	}
  }
  
  protected def void readBundledTerminologyAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createBundledTerminologyAxiom()
  	  val uuid = kv.remove("uuid")
  	  val String bundledTerminologyIRI = kv.get("bundledTerminologyIRI")
  	  if (null === bundledTerminologyIRI)
  	  	throw new IllegalArgumentException("readBundledTerminologyAxioms: missing 'bundledTerminologyIRI' in: "+kv.toString)
  	  iriLoadQueue.add(bundledTerminologyIRI)
  	  val pair = new Pair<BundledTerminologyAxiom, Map<String,String>>(oml, kv)
  	  bundledTerminologyAxioms.put(uuid, pair)
  	  includeBundledTerminologyAxioms(uuid, oml)
  	}
  }
  
  protected def void readDescriptionBoxExtendsClosedWorldDefinitions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createDescriptionBoxExtendsClosedWorldDefinitions()
  	  val uuid = kv.remove("uuid")
  	  val String closedWorldDefinitionsIRI = kv.get("closedWorldDefinitionsIRI")
  	  if (null === closedWorldDefinitionsIRI)
  	  	throw new IllegalArgumentException("readDescriptionBoxExtendsClosedWorldDefinitions: missing 'closedWorldDefinitionsIRI' in: "+kv.toString)
  	  iriLoadQueue.add(closedWorldDefinitionsIRI)
  	  val pair = new Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String,String>>(oml, kv)
  	  descriptionBoxExtendsClosedWorldDefinitions.put(uuid, pair)
  	  includeDescriptionBoxExtendsClosedWorldDefinitions(uuid, oml)
  	}
  }
  
  protected def void readDescriptionBoxRefinements(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createDescriptionBoxRefinement()
  	  val uuid = kv.remove("uuid")
  	  val String refinedDescriptionBoxIRI = kv.get("refinedDescriptionBoxIRI")
  	  if (null === refinedDescriptionBoxIRI)
  	  	throw new IllegalArgumentException("readDescriptionBoxRefinements: missing 'refinedDescriptionBoxIRI' in: "+kv.toString)
  	  iriLoadQueue.add(refinedDescriptionBoxIRI)
  	  val pair = new Pair<DescriptionBoxRefinement, Map<String,String>>(oml, kv)
  	  descriptionBoxRefinements.put(uuid, pair)
  	  includeDescriptionBoxRefinements(uuid, oml)
  	}
  }
  
  protected def void readBinaryScalarRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createBinaryScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  val length_value = kv.remove("length")
  	  if (null !== length_value && length_value.length > 0)
  	  	oml.length = OMLTables.toPositiveIntegerLiteral(length_value)
  	  val minLength_value = kv.remove("minLength")
  	  if (null !== minLength_value && minLength_value.length > 0)
  	  	oml.minLength = OMLTables.toPositiveIntegerLiteral(minLength_value)
  	  val maxLength_value = kv.remove("maxLength")
  	  if (null !== maxLength_value && maxLength_value.length > 0)
  	  	oml.maxLength = OMLTables.toPositiveIntegerLiteral(maxLength_value)
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<BinaryScalarRestriction, Map<String,String>>(oml, kv)
  	  binaryScalarRestrictions.put(uuid, pair)
  	  includeBinaryScalarRestrictions(uuid, oml)
  	}
  }
  
  protected def void readIRIScalarRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createIRIScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  val length_value = kv.remove("length")
  	  if (null !== length_value && length_value.length > 0)
  	  	oml.length = OMLTables.toPositiveIntegerLiteral(length_value)
  	  val minLength_value = kv.remove("minLength")
  	  if (null !== minLength_value && minLength_value.length > 0)
  	  	oml.minLength = OMLTables.toPositiveIntegerLiteral(minLength_value)
  	  val maxLength_value = kv.remove("maxLength")
  	  if (null !== maxLength_value && maxLength_value.length > 0)
  	  	oml.maxLength = OMLTables.toPositiveIntegerLiteral(maxLength_value)
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pattern_value = kv.remove("pattern")
  	  if (null !== pattern_value && pattern_value.length > 0)
  	  	oml.pattern = OMLTables.toLiteralPattern(pattern_value)
  	  val pair = new Pair<IRIScalarRestriction, Map<String,String>>(oml, kv)
  	  iriScalarRestrictions.put(uuid, pair)
  	  includeIRIScalarRestrictions(uuid, oml)
  	}
  }
  
  protected def void readNumericScalarRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createNumericScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  val minExclusive_value = kv.remove("minExclusive")
  	  if (null !== minExclusive_value && minExclusive_value.length > 0)
  	  	oml.minExclusive = OMLTables.toLiteralNumber(minExclusive_value)
  	  val minInclusive_value = kv.remove("minInclusive")
  	  if (null !== minInclusive_value && minInclusive_value.length > 0)
  	  	oml.minInclusive = OMLTables.toLiteralNumber(minInclusive_value)
  	  val maxExclusive_value = kv.remove("maxExclusive")
  	  if (null !== maxExclusive_value && maxExclusive_value.length > 0)
  	  	oml.maxExclusive = OMLTables.toLiteralNumber(maxExclusive_value)
  	  val maxInclusive_value = kv.remove("maxInclusive")
  	  if (null !== maxInclusive_value && maxInclusive_value.length > 0)
  	  	oml.maxInclusive = OMLTables.toLiteralNumber(maxInclusive_value)
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<NumericScalarRestriction, Map<String,String>>(oml, kv)
  	  numericScalarRestrictions.put(uuid, pair)
  	  includeNumericScalarRestrictions(uuid, oml)
  	}
  }
  
  protected def void readPlainLiteralScalarRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createPlainLiteralScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  val length_value = kv.remove("length")
  	  if (null !== length_value && length_value.length > 0)
  	  	oml.length = OMLTables.toPositiveIntegerLiteral(length_value)
  	  val minLength_value = kv.remove("minLength")
  	  if (null !== minLength_value && minLength_value.length > 0)
  	  	oml.minLength = OMLTables.toPositiveIntegerLiteral(minLength_value)
  	  val maxLength_value = kv.remove("maxLength")
  	  if (null !== maxLength_value && maxLength_value.length > 0)
  	  	oml.maxLength = OMLTables.toPositiveIntegerLiteral(maxLength_value)
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val langRange_value = kv.remove("langRange")
  	  if (null !== langRange_value && langRange_value.length > 0)
  	  	oml.langRange = OMLTables.toLanguageTagDataType(langRange_value)
  	  val pattern_value = kv.remove("pattern")
  	  if (null !== pattern_value && pattern_value.length > 0)
  	  	oml.pattern = OMLTables.toLiteralPattern(pattern_value)
  	  val pair = new Pair<PlainLiteralScalarRestriction, Map<String,String>>(oml, kv)
  	  plainLiteralScalarRestrictions.put(uuid, pair)
  	  includePlainLiteralScalarRestrictions(uuid, oml)
  	}
  }
  
  protected def void readScalarOneOfRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createScalarOneOfRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ScalarOneOfRestriction, Map<String,String>>(oml, kv)
  	  scalarOneOfRestrictions.put(uuid, pair)
  	  includeScalarOneOfRestrictions(uuid, oml)
  	}
  }
  
  protected def void readScalarOneOfLiteralAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createScalarOneOfLiteralAxiom()
  	  val uuid = kv.remove("uuid")
  	  oml.value = OMLTables.toLiteralValue(kv.remove("value"))
  	  val pair = new Pair<ScalarOneOfLiteralAxiom, Map<String,String>>(oml, kv)
  	  scalarOneOfLiteralAxioms.put(uuid, pair)
  	  includeScalarOneOfLiteralAxioms(uuid, oml)
  	}
  }
  
  protected def void readStringScalarRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createStringScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  val length_value = kv.remove("length")
  	  if (null !== length_value && length_value.length > 0)
  	  	oml.length = OMLTables.toPositiveIntegerLiteral(length_value)
  	  val minLength_value = kv.remove("minLength")
  	  if (null !== minLength_value && minLength_value.length > 0)
  	  	oml.minLength = OMLTables.toPositiveIntegerLiteral(minLength_value)
  	  val maxLength_value = kv.remove("maxLength")
  	  if (null !== maxLength_value && maxLength_value.length > 0)
  	  	oml.maxLength = OMLTables.toPositiveIntegerLiteral(maxLength_value)
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pattern_value = kv.remove("pattern")
  	  if (null !== pattern_value && pattern_value.length > 0)
  	  	oml.pattern = OMLTables.toLiteralPattern(pattern_value)
  	  val pair = new Pair<StringScalarRestriction, Map<String,String>>(oml, kv)
  	  stringScalarRestrictions.put(uuid, pair)
  	  includeStringScalarRestrictions(uuid, oml)
  	}
  }
  
  protected def void readSynonymScalarRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createSynonymScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<SynonymScalarRestriction, Map<String,String>>(oml, kv)
  	  synonymScalarRestrictions.put(uuid, pair)
  	  includeSynonymScalarRestrictions(uuid, oml)
  	}
  }
  
  protected def void readTimeScalarRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createTimeScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  val minExclusive_value = kv.remove("minExclusive")
  	  if (null !== minExclusive_value && minExclusive_value.length > 0)
  	  	oml.minExclusive = OMLTables.toLiteralDateTime(minExclusive_value)
  	  val minInclusive_value = kv.remove("minInclusive")
  	  if (null !== minInclusive_value && minInclusive_value.length > 0)
  	  	oml.minInclusive = OMLTables.toLiteralDateTime(minInclusive_value)
  	  val maxExclusive_value = kv.remove("maxExclusive")
  	  if (null !== maxExclusive_value && maxExclusive_value.length > 0)
  	  	oml.maxExclusive = OMLTables.toLiteralDateTime(maxExclusive_value)
  	  val maxInclusive_value = kv.remove("maxInclusive")
  	  if (null !== maxInclusive_value && maxInclusive_value.length > 0)
  	  	oml.maxInclusive = OMLTables.toLiteralDateTime(maxInclusive_value)
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<TimeScalarRestriction, Map<String,String>>(oml, kv)
  	  timeScalarRestrictions.put(uuid, pair)
  	  includeTimeScalarRestrictions(uuid, oml)
  	}
  }
  
  protected def void readEntityScalarDataProperties(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createEntityScalarDataProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.isIdentityCriteria = OMLTables.toEBoolean(kv.remove("isIdentityCriteria"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<EntityScalarDataProperty, Map<String,String>>(oml, kv)
  	  entityScalarDataProperties.put(uuid, pair)
  	  includeEntityScalarDataProperties(uuid, oml)
  	}
  }
  
  protected def void readEntityStructuredDataProperties(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createEntityStructuredDataProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.isIdentityCriteria = OMLTables.toEBoolean(kv.remove("isIdentityCriteria"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<EntityStructuredDataProperty, Map<String,String>>(oml, kv)
  	  entityStructuredDataProperties.put(uuid, pair)
  	  includeEntityStructuredDataProperties(uuid, oml)
  	}
  }
  
  protected def void readScalarDataProperties(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createScalarDataProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ScalarDataProperty, Map<String,String>>(oml, kv)
  	  scalarDataProperties.put(uuid, pair)
  	  includeScalarDataProperties(uuid, oml)
  	}
  }
  
  protected def void readStructuredDataProperties(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createStructuredDataProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<StructuredDataProperty, Map<String,String>>(oml, kv)
  	  structuredDataProperties.put(uuid, pair)
  	  includeStructuredDataProperties(uuid, oml)
  	}
  }
  
  protected def void readReifiedRelationships(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createReifiedRelationship()
  	  val uuid = kv.remove("uuid")
  	  oml.isAsymmetric = OMLTables.toEBoolean(kv.remove("isAsymmetric"))
  	  oml.isEssential = OMLTables.toEBoolean(kv.remove("isEssential"))
  	  oml.isFunctional = OMLTables.toEBoolean(kv.remove("isFunctional"))
  	  oml.isInverseEssential = OMLTables.toEBoolean(kv.remove("isInverseEssential"))
  	  oml.isInverseFunctional = OMLTables.toEBoolean(kv.remove("isInverseFunctional"))
  	  oml.isIrreflexive = OMLTables.toEBoolean(kv.remove("isIrreflexive"))
  	  oml.isReflexive = OMLTables.toEBoolean(kv.remove("isReflexive"))
  	  oml.isSymmetric = OMLTables.toEBoolean(kv.remove("isSymmetric"))
  	  oml.isTransitive = OMLTables.toEBoolean(kv.remove("isTransitive"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ReifiedRelationship, Map<String,String>>(oml, kv)
  	  reifiedRelationships.put(uuid, pair)
  	  includeReifiedRelationships(uuid, oml)
  	}
  }
  
  protected def void readReifiedRelationshipRestrictions(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createReifiedRelationshipRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ReifiedRelationshipRestriction, Map<String,String>>(oml, kv)
  	  reifiedRelationshipRestrictions.put(uuid, pair)
  	  includeReifiedRelationshipRestrictions(uuid, oml)
  	}
  }
  
  protected def void readForwardProperties(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createForwardProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ForwardProperty, Map<String,String>>(oml, kv)
  	  forwardProperties.put(uuid, pair)
  	  includeForwardProperties(uuid, oml)
  	}
  }
  
  protected def void readInverseProperties(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createInverseProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<InverseProperty, Map<String,String>>(oml, kv)
  	  inverseProperties.put(uuid, pair)
  	  includeInverseProperties(uuid, oml)
  	}
  }
  
  protected def void readUnreifiedRelationships(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createUnreifiedRelationship()
  	  val uuid = kv.remove("uuid")
  	  oml.isAsymmetric = OMLTables.toEBoolean(kv.remove("isAsymmetric"))
  	  oml.isEssential = OMLTables.toEBoolean(kv.remove("isEssential"))
  	  oml.isFunctional = OMLTables.toEBoolean(kv.remove("isFunctional"))
  	  oml.isInverseEssential = OMLTables.toEBoolean(kv.remove("isInverseEssential"))
  	  oml.isInverseFunctional = OMLTables.toEBoolean(kv.remove("isInverseFunctional"))
  	  oml.isIrreflexive = OMLTables.toEBoolean(kv.remove("isIrreflexive"))
  	  oml.isReflexive = OMLTables.toEBoolean(kv.remove("isReflexive"))
  	  oml.isSymmetric = OMLTables.toEBoolean(kv.remove("isSymmetric"))
  	  oml.isTransitive = OMLTables.toEBoolean(kv.remove("isTransitive"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<UnreifiedRelationship, Map<String,String>>(oml, kv)
  	  unreifiedRelationships.put(uuid, pair)
  	  includeUnreifiedRelationships(uuid, oml)
  	}
  }
  
  protected def void readChainRules(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createChainRule()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ChainRule, Map<String,String>>(oml, kv)
  	  chainRules.put(uuid, pair)
  	  includeChainRules(uuid, oml)
  	}
  }
  
  protected def void readRuleBodySegments(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createRuleBodySegment()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<RuleBodySegment, Map<String,String>>(oml, kv)
  	  ruleBodySegments.put(uuid, pair)
  	  includeRuleBodySegments(uuid, oml)
  	}
  }
  
  protected def void readSegmentPredicates(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createSegmentPredicate()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SegmentPredicate, Map<String,String>>(oml, kv)
  	  segmentPredicates.put(uuid, pair)
  	  includeSegmentPredicates(uuid, oml)
  	}
  }
  
  protected def void readEntityExistentialRestrictionAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createEntityExistentialRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityExistentialRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityExistentialRestrictionAxioms.put(uuid, pair)
  	  includeEntityExistentialRestrictionAxioms(uuid, oml)
  	}
  }
  
  protected def void readEntityUniversalRestrictionAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createEntityUniversalRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityUniversalRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityUniversalRestrictionAxioms.put(uuid, pair)
  	  includeEntityUniversalRestrictionAxioms(uuid, oml)
  	}
  }
  
  protected def void readEntityScalarDataPropertyExistentialRestrictionAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createEntityScalarDataPropertyExistentialRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityScalarDataPropertyExistentialRestrictionAxioms.put(uuid, pair)
  	  includeEntityScalarDataPropertyExistentialRestrictionAxioms(uuid, oml)
  	}
  }
  
  protected def void readEntityScalarDataPropertyParticularRestrictionAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createEntityScalarDataPropertyParticularRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  oml.literalValue = OMLTables.toLiteralValue(kv.remove("literalValue"))
  	  val pair = new Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityScalarDataPropertyParticularRestrictionAxioms.put(uuid, pair)
  	  includeEntityScalarDataPropertyParticularRestrictionAxioms(uuid, oml)
  	}
  }
  
  protected def void readEntityScalarDataPropertyUniversalRestrictionAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createEntityScalarDataPropertyUniversalRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityScalarDataPropertyUniversalRestrictionAxioms.put(uuid, pair)
  	  includeEntityScalarDataPropertyUniversalRestrictionAxioms(uuid, oml)
  	}
  }
  
  protected def void readEntityStructuredDataPropertyParticularRestrictionAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createEntityStructuredDataPropertyParticularRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityStructuredDataPropertyParticularRestrictionAxioms.put(uuid, pair)
  	  includeEntityStructuredDataPropertyParticularRestrictionAxioms(uuid, oml)
  	}
  }
  
  protected def void readRestrictionStructuredDataPropertyTuples(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createRestrictionStructuredDataPropertyTuple()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<RestrictionStructuredDataPropertyTuple, Map<String,String>>(oml, kv)
  	  restrictionStructuredDataPropertyTuples.put(uuid, pair)
  	  includeRestrictionStructuredDataPropertyTuples(uuid, oml)
  	}
  }
  
  protected def void readRestrictionScalarDataPropertyValues(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createRestrictionScalarDataPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  oml.scalarPropertyValue = OMLTables.toLiteralValue(kv.remove("scalarPropertyValue"))
  	  val pair = new Pair<RestrictionScalarDataPropertyValue, Map<String,String>>(oml, kv)
  	  restrictionScalarDataPropertyValues.put(uuid, pair)
  	  includeRestrictionScalarDataPropertyValues(uuid, oml)
  	}
  }
  
  protected def void readAspectSpecializationAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createAspectSpecializationAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<AspectSpecializationAxiom, Map<String,String>>(oml, kv)
  	  aspectSpecializationAxioms.put(uuid, pair)
  	  includeAspectSpecializationAxioms(uuid, oml)
  	}
  }
  
  protected def void readConceptSpecializationAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createConceptSpecializationAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ConceptSpecializationAxiom, Map<String,String>>(oml, kv)
  	  conceptSpecializationAxioms.put(uuid, pair)
  	  includeConceptSpecializationAxioms(uuid, oml)
  	}
  }
  
  protected def void readReifiedRelationshipSpecializationAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createReifiedRelationshipSpecializationAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ReifiedRelationshipSpecializationAxiom, Map<String,String>>(oml, kv)
  	  reifiedRelationshipSpecializationAxioms.put(uuid, pair)
  	  includeReifiedRelationshipSpecializationAxioms(uuid, oml)
  	}
  }
  
  protected def void readSubDataPropertyOfAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createSubDataPropertyOfAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SubDataPropertyOfAxiom, Map<String,String>>(oml, kv)
  	  subDataPropertyOfAxioms.put(uuid, pair)
  	  includeSubDataPropertyOfAxioms(uuid, oml)
  	}
  }
  
  protected def void readSubObjectPropertyOfAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createSubObjectPropertyOfAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SubObjectPropertyOfAxiom, Map<String,String>>(oml, kv)
  	  subObjectPropertyOfAxioms.put(uuid, pair)
  	  includeSubObjectPropertyOfAxioms(uuid, oml)
  	}
  }
  
  protected def void readRootConceptTaxonomyAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createRootConceptTaxonomyAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<RootConceptTaxonomyAxiom, Map<String,String>>(oml, kv)
  	  rootConceptTaxonomyAxioms.put(uuid, pair)
  	  includeRootConceptTaxonomyAxioms(uuid, oml)
  	}
  }
  
  protected def void readAnonymousConceptUnionAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createAnonymousConceptUnionAxiom()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<AnonymousConceptUnionAxiom, Map<String,String>>(oml, kv)
  	  anonymousConceptUnionAxioms.put(uuid, pair)
  	  includeAnonymousConceptUnionAxioms(uuid, oml)
  	}
  }
  
  protected def void readSpecificDisjointConceptAxioms(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createSpecificDisjointConceptAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SpecificDisjointConceptAxiom, Map<String,String>>(oml, kv)
  	  specificDisjointConceptAxioms.put(uuid, pair)
  	  includeSpecificDisjointConceptAxioms(uuid, oml)
  	}
  }
  
  protected def void readConceptInstances(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createConceptInstance()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ConceptInstance, Map<String,String>>(oml, kv)
  	  conceptInstances.put(uuid, pair)
  	  includeConceptInstances(uuid, oml)
  	}
  }
  
  protected def void readReifiedRelationshipInstances(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createReifiedRelationshipInstance()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ReifiedRelationshipInstance, Map<String,String>>(oml, kv)
  	  reifiedRelationshipInstances.put(uuid, pair)
  	  includeReifiedRelationshipInstances(uuid, oml)
  	}
  }
  
  protected def void readReifiedRelationshipInstanceDomains(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createReifiedRelationshipInstanceDomain()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ReifiedRelationshipInstanceDomain, Map<String,String>>(oml, kv)
  	  reifiedRelationshipInstanceDomains.put(uuid, pair)
  	  includeReifiedRelationshipInstanceDomains(uuid, oml)
  	}
  }
  
  protected def void readReifiedRelationshipInstanceRanges(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createReifiedRelationshipInstanceRange()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ReifiedRelationshipInstanceRange, Map<String,String>>(oml, kv)
  	  reifiedRelationshipInstanceRanges.put(uuid, pair)
  	  includeReifiedRelationshipInstanceRanges(uuid, oml)
  	}
  }
  
  protected def void readUnreifiedRelationshipInstanceTuples(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createUnreifiedRelationshipInstanceTuple()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<UnreifiedRelationshipInstanceTuple, Map<String,String>>(oml, kv)
  	  unreifiedRelationshipInstanceTuples.put(uuid, pair)
  	  includeUnreifiedRelationshipInstanceTuples(uuid, oml)
  	}
  }
  
  protected def void readSingletonInstanceStructuredDataPropertyValues(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createSingletonInstanceStructuredDataPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SingletonInstanceStructuredDataPropertyValue, Map<String,String>>(oml, kv)
  	  singletonInstanceStructuredDataPropertyValues.put(uuid, pair)
  	  includeSingletonInstanceStructuredDataPropertyValues(uuid, oml)
  	}
  }
  
  protected def void readSingletonInstanceScalarDataPropertyValues(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createSingletonInstanceScalarDataPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  oml.scalarPropertyValue = OMLTables.toLiteralValue(kv.remove("scalarPropertyValue"))
  	  val pair = new Pair<SingletonInstanceScalarDataPropertyValue, Map<String,String>>(oml, kv)
  	  singletonInstanceScalarDataPropertyValues.put(uuid, pair)
  	  includeSingletonInstanceScalarDataPropertyValues(uuid, oml)
  	}
  }
  
  protected def void readStructuredDataPropertyTuples(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createStructuredDataPropertyTuple()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<StructuredDataPropertyTuple, Map<String,String>>(oml, kv)
  	  structuredDataPropertyTuples.put(uuid, pair)
  	  includeStructuredDataPropertyTuples(uuid, oml)
  	}
  }
  
  protected def void readScalarDataPropertyValues(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createScalarDataPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  oml.scalarPropertyValue = OMLTables.toLiteralValue(kv.remove("scalarPropertyValue"))
  	  val pair = new Pair<ScalarDataPropertyValue, Map<String,String>>(oml, kv)
  	  scalarDataPropertyValues.put(uuid, pair)
  	  includeScalarDataPropertyValues(uuid, oml)
  	}
  }
  
  protected def void readAnnotationPropertyValues(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createAnnotationPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  oml.value = OMLTables.toLiteralString(kv.remove("value"))
  	  val pair = new Pair<AnnotationPropertyValue, Map<String,String>>(oml, kv)
  	  annotationPropertyValues.put(uuid, pair)
  	  includeAnnotationPropertyValues(uuid, oml)
  	}
  }
  
  protected def void readCardinalityRestrictedAspects(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createCardinalityRestrictedAspect()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  oml.restrictedCardinality = OMLTables.toPositiveIntegerLiteral(kv.remove("restrictedCardinality"))
  	  oml.restrictionKind = OMLTables.toCardinalityRestrictionKind(kv.remove("restrictionKind"))
  	  val pair = new Pair<CardinalityRestrictedAspect, Map<String,String>>(oml, kv)
  	  cardinalityRestrictedAspects.put(uuid, pair)
  	  includeCardinalityRestrictedAspects(uuid, oml)
  	}
  }
  
  protected def void readCardinalityRestrictedConcepts(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createCardinalityRestrictedConcept()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  oml.restrictedCardinality = OMLTables.toPositiveIntegerLiteral(kv.remove("restrictedCardinality"))
  	  oml.restrictionKind = OMLTables.toCardinalityRestrictionKind(kv.remove("restrictionKind"))
  	  val pair = new Pair<CardinalityRestrictedConcept, Map<String,String>>(oml, kv)
  	  cardinalityRestrictedConcepts.put(uuid, pair)
  	  includeCardinalityRestrictedConcepts(uuid, oml)
  	}
  }
  
  protected def void readCardinalityRestrictedReifiedRelationships(Extent ext, ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	while (!kvs.empty) {
  	  val kv = kvs.remove(kvs.size - 1)
  	  val oml = createCardinalityRestrictedReifiedRelationship()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  oml.restrictedCardinality = OMLTables.toPositiveIntegerLiteral(kv.remove("restrictedCardinality"))
  	  oml.restrictionKind = OMLTables.toCardinalityRestrictionKind(kv.remove("restrictionKind"))
  	  val pair = new Pair<CardinalityRestrictedReifiedRelationship, Map<String,String>>(oml, kv)
  	  cardinalityRestrictedReifiedRelationships.put(uuid, pair)
  	  includeCardinalityRestrictedReifiedRelationships(uuid, oml)
  	}
  }
  
  protected def <U,V extends U> Boolean includeMap(Map<String, Pair<U, Map<String, String>>> uMap, Map<String, Pair<V, Map<String, String>>> vMap) {
    val Boolean[] updated = #{ false }
    vMap.forEach[uuid,kv|
    		val prev = uMap.put(uuid, new Pair<U, Map<String, String>>(kv.key, Collections.emptyMap))
        	if (null === prev) {
        		updated.set(0, true)
        	}
    ]
    updated.get(0)
  }

  protected def void includeTerminologyGraphs(String uuid, TerminologyGraph oml) {
  	queueModule(oml)
  	modules.put(uuid, new Pair<Module, Map<String, String>>(oml, Collections.emptyMap))
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	terminologyBoxes.put(uuid, new Pair<TerminologyBox, Map<String, String>>(oml, Collections.emptyMap))
  	terminologyBoxes.put(oml.iri(), new Pair<TerminologyBox, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeBundles(String uuid, Bundle oml) {
  	queueModule(oml)
  	modules.put(uuid, new Pair<Module, Map<String, String>>(oml, Collections.emptyMap))
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	terminologyBoxes.put(uuid, new Pair<TerminologyBox, Map<String, String>>(oml, Collections.emptyMap))
  	terminologyBoxes.put(oml.iri(), new Pair<TerminologyBox, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeDescriptionBoxes(String uuid, DescriptionBox oml) {
  	queueModule(oml)
  	modules.put(uuid, new Pair<Module, Map<String, String>>(oml, Collections.emptyMap))
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeAnnotationProperties(String uuid, AnnotationProperty oml) {
  	
  }
  protected def void includeAspects(String uuid, Aspect oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	entities.put(uuid, new Pair<Entity, Map<String, String>>(oml, Collections.emptyMap))
  	aspectKinds.put(uuid, new Pair<AspectKind, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeConcepts(String uuid, Concept oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	entities.put(uuid, new Pair<Entity, Map<String, String>>(oml, Collections.emptyMap))
  	conceptKinds.put(uuid, new Pair<ConceptKind, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeScalars(String uuid, Scalar oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeStructures(String uuid, Structure oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeConceptDesignationTerminologyAxioms(String uuid, ConceptDesignationTerminologyAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeTerminologyExtensionAxioms(String uuid, TerminologyExtensionAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeTerminologyNestingAxioms(String uuid, TerminologyNestingAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeBundledTerminologyAxioms(String uuid, BundledTerminologyAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeDescriptionBoxExtendsClosedWorldDefinitions(String uuid, DescriptionBoxExtendsClosedWorldDefinitions oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeDescriptionBoxRefinements(String uuid, DescriptionBoxRefinement oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeBinaryScalarRestrictions(String uuid, BinaryScalarRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeIRIScalarRestrictions(String uuid, IRIScalarRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeNumericScalarRestrictions(String uuid, NumericScalarRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includePlainLiteralScalarRestrictions(String uuid, PlainLiteralScalarRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeScalarOneOfRestrictions(String uuid, ScalarOneOfRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeScalarOneOfLiteralAxioms(String uuid, ScalarOneOfLiteralAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeStringScalarRestrictions(String uuid, StringScalarRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeSynonymScalarRestrictions(String uuid, SynonymScalarRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeTimeScalarRestrictions(String uuid, TimeScalarRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRanges.put(uuid, new Pair<DataRange, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeEntityScalarDataProperties(String uuid, EntityScalarDataProperty oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRelationshipToScalars.put(uuid, new Pair<DataRelationshipToScalar, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeEntityStructuredDataProperties(String uuid, EntityStructuredDataProperty oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRelationshipToStructures.put(uuid, new Pair<DataRelationshipToStructure, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeScalarDataProperties(String uuid, ScalarDataProperty oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRelationshipToScalars.put(uuid, new Pair<DataRelationshipToScalar, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeStructuredDataProperties(String uuid, StructuredDataProperty oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	dataRelationshipToStructures.put(uuid, new Pair<DataRelationshipToStructure, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeReifiedRelationships(String uuid, ReifiedRelationship oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	entities.put(uuid, new Pair<Entity, Map<String, String>>(oml, Collections.emptyMap))
  	entityRelationships.put(uuid, new Pair<EntityRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	conceptualRelationships.put(uuid, new Pair<ConceptualRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeReifiedRelationshipRestrictions(String uuid, ReifiedRelationshipRestriction oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	entities.put(uuid, new Pair<Entity, Map<String, String>>(oml, Collections.emptyMap))
  	entityRelationships.put(uuid, new Pair<EntityRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	conceptualRelationships.put(uuid, new Pair<ConceptualRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeForwardProperties(String uuid, ForwardProperty oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	restrictableRelationships.put(uuid, new Pair<RestrictableRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeInverseProperties(String uuid, InverseProperty oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	restrictableRelationships.put(uuid, new Pair<RestrictableRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeUnreifiedRelationships(String uuid, UnreifiedRelationship oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	entityRelationships.put(uuid, new Pair<EntityRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	restrictableRelationships.put(uuid, new Pair<RestrictableRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeChainRules(String uuid, ChainRule oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeRuleBodySegments(String uuid, RuleBodySegment oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeSegmentPredicates(String uuid, SegmentPredicate oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeEntityExistentialRestrictionAxioms(String uuid, EntityExistentialRestrictionAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeEntityUniversalRestrictionAxioms(String uuid, EntityUniversalRestrictionAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeEntityScalarDataPropertyExistentialRestrictionAxioms(String uuid, EntityScalarDataPropertyExistentialRestrictionAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeEntityScalarDataPropertyParticularRestrictionAxioms(String uuid, EntityScalarDataPropertyParticularRestrictionAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeEntityScalarDataPropertyUniversalRestrictionAxioms(String uuid, EntityScalarDataPropertyUniversalRestrictionAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeEntityStructuredDataPropertyParticularRestrictionAxioms(String uuid, EntityStructuredDataPropertyParticularRestrictionAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	restrictionStructuredDataPropertyContexts.put(uuid, new Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeRestrictionStructuredDataPropertyTuples(String uuid, RestrictionStructuredDataPropertyTuple oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	restrictionStructuredDataPropertyContexts.put(uuid, new Pair<RestrictionStructuredDataPropertyContext, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeRestrictionScalarDataPropertyValues(String uuid, RestrictionScalarDataPropertyValue oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeAspectSpecializationAxioms(String uuid, AspectSpecializationAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeConceptSpecializationAxioms(String uuid, ConceptSpecializationAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeReifiedRelationshipSpecializationAxioms(String uuid, ReifiedRelationshipSpecializationAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeSubDataPropertyOfAxioms(String uuid, SubDataPropertyOfAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeSubObjectPropertyOfAxioms(String uuid, SubObjectPropertyOfAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeRootConceptTaxonomyAxioms(String uuid, RootConceptTaxonomyAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	conceptTreeDisjunctions.put(uuid, new Pair<ConceptTreeDisjunction, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeAnonymousConceptUnionAxioms(String uuid, AnonymousConceptUnionAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	conceptTreeDisjunctions.put(uuid, new Pair<ConceptTreeDisjunction, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeSpecificDisjointConceptAxioms(String uuid, SpecificDisjointConceptAxiom oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeConceptInstances(String uuid, ConceptInstance oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	conceptualEntitySingletonInstances.put(uuid, new Pair<ConceptualEntitySingletonInstance, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeReifiedRelationshipInstances(String uuid, ReifiedRelationshipInstance oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	conceptualEntitySingletonInstances.put(uuid, new Pair<ConceptualEntitySingletonInstance, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeReifiedRelationshipInstanceDomains(String uuid, ReifiedRelationshipInstanceDomain oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeReifiedRelationshipInstanceRanges(String uuid, ReifiedRelationshipInstanceRange oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeUnreifiedRelationshipInstanceTuples(String uuid, UnreifiedRelationshipInstanceTuple oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeSingletonInstanceStructuredDataPropertyValues(String uuid, SingletonInstanceStructuredDataPropertyValue oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	singletonInstanceStructuredDataPropertyContexts.put(uuid, new Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeSingletonInstanceScalarDataPropertyValues(String uuid, SingletonInstanceScalarDataPropertyValue oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeStructuredDataPropertyTuples(String uuid, StructuredDataPropertyTuple oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	singletonInstanceStructuredDataPropertyContexts.put(uuid, new Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeScalarDataPropertyValues(String uuid, ScalarDataPropertyValue oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeAnnotationPropertyValues(String uuid, AnnotationPropertyValue oml) {
  	
  }
  protected def void includeCardinalityRestrictedAspects(String uuid, CardinalityRestrictedAspect oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	entities.put(uuid, new Pair<Entity, Map<String, String>>(oml, Collections.emptyMap))
  	aspectKinds.put(uuid, new Pair<AspectKind, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeCardinalityRestrictedConcepts(String uuid, CardinalityRestrictedConcept oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	entities.put(uuid, new Pair<Entity, Map<String, String>>(oml, Collections.emptyMap))
  	conceptKinds.put(uuid, new Pair<ConceptKind, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	
  }
  protected def void includeCardinalityRestrictedReifiedRelationships(String uuid, CardinalityRestrictedReifiedRelationship oml) {
  	logicalElements.put(uuid, new Pair<LogicalElement, Map<String, String>>(oml, Collections.emptyMap))
  	entities.put(uuid, new Pair<Entity, Map<String, String>>(oml, Collections.emptyMap))
  	entityRelationships.put(uuid, new Pair<EntityRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	conceptualRelationships.put(uuid, new Pair<ConceptualRelationship, Map<String, String>>(oml, Collections.emptyMap))
  	predicates.put(uuid, new Pair<Predicate, Map<String, String>>(oml, Collections.emptyMap))
  	
  }

  protected def void resolve(ResourceSet rs, OMLZipResource r) {

  	System.out.println("Resolve: "+r.URI)
  	val t0 = System.currentTimeMillis
  	// Lookup table for LogicalElement cross references
    if (includeMap(logicalElements, terminologyGraphs)) {
    	System.out.println("+ logicalElements, terminologyGraphs")
    }
    if (includeMap(logicalElements, bundles)) {
    	System.out.println("+ logicalElements, bundles")
    }
    if (includeMap(logicalElements, descriptionBoxes)) {
    	System.out.println("+ logicalElements, descriptionBoxes")
    }
    if (includeMap(logicalElements, aspects)) {
    	System.out.println("+ logicalElements, aspects")
    }
    if (includeMap(logicalElements, concepts)) {
    	System.out.println("+ logicalElements, concepts")
    }
    if (includeMap(logicalElements, scalars)) {
    	System.out.println("+ logicalElements, scalars")
    }
    if (includeMap(logicalElements, structures)) {
    	System.out.println("+ logicalElements, structures")
    }
    if (includeMap(logicalElements, conceptDesignationTerminologyAxioms)) {
    	System.out.println("+ logicalElements, conceptDesignationTerminologyAxioms")
    }
    if (includeMap(logicalElements, terminologyExtensionAxioms)) {
    	System.out.println("+ logicalElements, terminologyExtensionAxioms")
    }
    if (includeMap(logicalElements, terminologyNestingAxioms)) {
    	System.out.println("+ logicalElements, terminologyNestingAxioms")
    }
    if (includeMap(logicalElements, bundledTerminologyAxioms)) {
    	System.out.println("+ logicalElements, bundledTerminologyAxioms")
    }
    if (includeMap(logicalElements, descriptionBoxExtendsClosedWorldDefinitions)) {
    	System.out.println("+ logicalElements, descriptionBoxExtendsClosedWorldDefinitions")
    }
    if (includeMap(logicalElements, descriptionBoxRefinements)) {
    	System.out.println("+ logicalElements, descriptionBoxRefinements")
    }
    if (includeMap(logicalElements, binaryScalarRestrictions)) {
    	System.out.println("+ logicalElements, binaryScalarRestrictions")
    }
    if (includeMap(logicalElements, iriScalarRestrictions)) {
    	System.out.println("+ logicalElements, iriScalarRestrictions")
    }
    if (includeMap(logicalElements, numericScalarRestrictions)) {
    	System.out.println("+ logicalElements, numericScalarRestrictions")
    }
    if (includeMap(logicalElements, plainLiteralScalarRestrictions)) {
    	System.out.println("+ logicalElements, plainLiteralScalarRestrictions")
    }
    if (includeMap(logicalElements, scalarOneOfRestrictions)) {
    	System.out.println("+ logicalElements, scalarOneOfRestrictions")
    }
    if (includeMap(logicalElements, scalarOneOfLiteralAxioms)) {
    	System.out.println("+ logicalElements, scalarOneOfLiteralAxioms")
    }
    if (includeMap(logicalElements, stringScalarRestrictions)) {
    	System.out.println("+ logicalElements, stringScalarRestrictions")
    }
    if (includeMap(logicalElements, synonymScalarRestrictions)) {
    	System.out.println("+ logicalElements, synonymScalarRestrictions")
    }
    if (includeMap(logicalElements, timeScalarRestrictions)) {
    	System.out.println("+ logicalElements, timeScalarRestrictions")
    }
    if (includeMap(logicalElements, entityScalarDataProperties)) {
    	System.out.println("+ logicalElements, entityScalarDataProperties")
    }
    if (includeMap(logicalElements, entityStructuredDataProperties)) {
    	System.out.println("+ logicalElements, entityStructuredDataProperties")
    }
    if (includeMap(logicalElements, scalarDataProperties)) {
    	System.out.println("+ logicalElements, scalarDataProperties")
    }
    if (includeMap(logicalElements, structuredDataProperties)) {
    	System.out.println("+ logicalElements, structuredDataProperties")
    }
    if (includeMap(logicalElements, reifiedRelationships)) {
    	System.out.println("+ logicalElements, reifiedRelationships")
    }
    if (includeMap(logicalElements, reifiedRelationshipRestrictions)) {
    	System.out.println("+ logicalElements, reifiedRelationshipRestrictions")
    }
    if (includeMap(logicalElements, forwardProperties)) {
    	System.out.println("+ logicalElements, forwardProperties")
    }
    if (includeMap(logicalElements, inverseProperties)) {
    	System.out.println("+ logicalElements, inverseProperties")
    }
    if (includeMap(logicalElements, unreifiedRelationships)) {
    	System.out.println("+ logicalElements, unreifiedRelationships")
    }
    if (includeMap(logicalElements, chainRules)) {
    	System.out.println("+ logicalElements, chainRules")
    }
    if (includeMap(logicalElements, ruleBodySegments)) {
    	System.out.println("+ logicalElements, ruleBodySegments")
    }
    if (includeMap(logicalElements, segmentPredicates)) {
    	System.out.println("+ logicalElements, segmentPredicates")
    }
    if (includeMap(logicalElements, entityExistentialRestrictionAxioms)) {
    	System.out.println("+ logicalElements, entityExistentialRestrictionAxioms")
    }
    if (includeMap(logicalElements, entityUniversalRestrictionAxioms)) {
    	System.out.println("+ logicalElements, entityUniversalRestrictionAxioms")
    }
    if (includeMap(logicalElements, entityScalarDataPropertyExistentialRestrictionAxioms)) {
    	System.out.println("+ logicalElements, entityScalarDataPropertyExistentialRestrictionAxioms")
    }
    if (includeMap(logicalElements, entityScalarDataPropertyParticularRestrictionAxioms)) {
    	System.out.println("+ logicalElements, entityScalarDataPropertyParticularRestrictionAxioms")
    }
    if (includeMap(logicalElements, entityScalarDataPropertyUniversalRestrictionAxioms)) {
    	System.out.println("+ logicalElements, entityScalarDataPropertyUniversalRestrictionAxioms")
    }
    if (includeMap(logicalElements, entityStructuredDataPropertyParticularRestrictionAxioms)) {
    	System.out.println("+ logicalElements, entityStructuredDataPropertyParticularRestrictionAxioms")
    }
    if (includeMap(logicalElements, restrictionStructuredDataPropertyTuples)) {
    	System.out.println("+ logicalElements, restrictionStructuredDataPropertyTuples")
    }
    if (includeMap(logicalElements, restrictionScalarDataPropertyValues)) {
    	System.out.println("+ logicalElements, restrictionScalarDataPropertyValues")
    }
    if (includeMap(logicalElements, aspectSpecializationAxioms)) {
    	System.out.println("+ logicalElements, aspectSpecializationAxioms")
    }
    if (includeMap(logicalElements, conceptSpecializationAxioms)) {
    	System.out.println("+ logicalElements, conceptSpecializationAxioms")
    }
    if (includeMap(logicalElements, reifiedRelationshipSpecializationAxioms)) {
    	System.out.println("+ logicalElements, reifiedRelationshipSpecializationAxioms")
    }
    if (includeMap(logicalElements, subDataPropertyOfAxioms)) {
    	System.out.println("+ logicalElements, subDataPropertyOfAxioms")
    }
    if (includeMap(logicalElements, subObjectPropertyOfAxioms)) {
    	System.out.println("+ logicalElements, subObjectPropertyOfAxioms")
    }
    if (includeMap(logicalElements, rootConceptTaxonomyAxioms)) {
    	System.out.println("+ logicalElements, rootConceptTaxonomyAxioms")
    }
    if (includeMap(logicalElements, anonymousConceptUnionAxioms)) {
    	System.out.println("+ logicalElements, anonymousConceptUnionAxioms")
    }
    if (includeMap(logicalElements, specificDisjointConceptAxioms)) {
    	System.out.println("+ logicalElements, specificDisjointConceptAxioms")
    }
    if (includeMap(logicalElements, conceptInstances)) {
    	System.out.println("+ logicalElements, conceptInstances")
    }
    if (includeMap(logicalElements, reifiedRelationshipInstances)) {
    	System.out.println("+ logicalElements, reifiedRelationshipInstances")
    }
    if (includeMap(logicalElements, reifiedRelationshipInstanceDomains)) {
    	System.out.println("+ logicalElements, reifiedRelationshipInstanceDomains")
    }
    if (includeMap(logicalElements, reifiedRelationshipInstanceRanges)) {
    	System.out.println("+ logicalElements, reifiedRelationshipInstanceRanges")
    }
    if (includeMap(logicalElements, unreifiedRelationshipInstanceTuples)) {
    	System.out.println("+ logicalElements, unreifiedRelationshipInstanceTuples")
    }
    if (includeMap(logicalElements, singletonInstanceStructuredDataPropertyValues)) {
    	System.out.println("+ logicalElements, singletonInstanceStructuredDataPropertyValues")
    }
    if (includeMap(logicalElements, singletonInstanceScalarDataPropertyValues)) {
    	System.out.println("+ logicalElements, singletonInstanceScalarDataPropertyValues")
    }
    if (includeMap(logicalElements, structuredDataPropertyTuples)) {
    	System.out.println("+ logicalElements, structuredDataPropertyTuples")
    }
    if (includeMap(logicalElements, scalarDataPropertyValues)) {
    	System.out.println("+ logicalElements, scalarDataPropertyValues")
    }
    if (includeMap(logicalElements, cardinalityRestrictedAspects)) {
    	System.out.println("+ logicalElements, cardinalityRestrictedAspects")
    }
    if (includeMap(logicalElements, cardinalityRestrictedConcepts)) {
    	System.out.println("+ logicalElements, cardinalityRestrictedConcepts")
    }
    if (includeMap(logicalElements, cardinalityRestrictedReifiedRelationships)) {
    	System.out.println("+ logicalElements, cardinalityRestrictedReifiedRelationships")
    }

	// Lookup table for Entity cross references
  	if (includeMap(entities, aspects)) {
  		System.out.println("+ entities, aspects")
  	}
  	if (includeMap(entities, concepts)) {
  		System.out.println("+ entities, concepts")
  	}
  	if (includeMap(entities, reifiedRelationships)) {
  		System.out.println("+ entities, reifiedRelationships")
  	}
  	if (includeMap(entities, reifiedRelationshipRestrictions)) {
  		System.out.println("+ entities, reifiedRelationshipRestrictions")
  	}
  	if (includeMap(entities, cardinalityRestrictedAspects)) {
  		System.out.println("+ entities, cardinalityRestrictedAspects")
  	}
  	if (includeMap(entities, cardinalityRestrictedConcepts)) {
  		System.out.println("+ entities, cardinalityRestrictedConcepts")
  	}
  	if (includeMap(entities, cardinalityRestrictedReifiedRelationships)) {
  		System.out.println("+ entities, cardinalityRestrictedReifiedRelationships")
  	}

	// Lookup table for AspectKind cross references
  	if (includeMap(aspectKinds, aspects)) {
  		System.out.println("+ aspectKinds, aspects")
  	}
  	if (includeMap(aspectKinds, cardinalityRestrictedAspects)) {
  		System.out.println("+ aspectKinds, cardinalityRestrictedAspects")
  	}

	// Lookup table for ConceptKind cross references
  	if (includeMap(conceptKinds, concepts)) {
  		System.out.println("+ conceptKinds, concepts")
  	}
  	if (includeMap(conceptKinds, cardinalityRestrictedConcepts)) {
  		System.out.println("+ conceptKinds, cardinalityRestrictedConcepts")
  	}

	// Lookup table for EntityRelationship cross references
    if (includeMap(entityRelationships, reifiedRelationships)) {
    	System.out.println("+ entities, reifiedRelationships")
    }
    if (includeMap(entityRelationships, reifiedRelationshipRestrictions)) {
    	System.out.println("+ entities, reifiedRelationshipRestrictions")
    }
    if (includeMap(entityRelationships, unreifiedRelationships)) {
    	System.out.println("+ entities, unreifiedRelationships")
    }
    if (includeMap(entityRelationships, cardinalityRestrictedReifiedRelationships)) {
    	System.out.println("+ entities, cardinalityRestrictedReifiedRelationships")
    }

	// Lookup table for ConceptualRelationship cross references
    if (includeMap(conceptualRelationships, reifiedRelationships)) {
    	System.out.println("+ entities, reifiedRelationships")
    }
    if (includeMap(conceptualRelationships, reifiedRelationshipRestrictions)) {
    	System.out.println("+ entities, reifiedRelationshipRestrictions")
    }
    if (includeMap(conceptualRelationships, cardinalityRestrictedReifiedRelationships)) {
    	System.out.println("+ entities, cardinalityRestrictedReifiedRelationships")
    }

	// Lookup table for DataRange cross references
    if (includeMap(dataRanges, scalars)) {
    	System.out.println("+ entities, scalars")
    }
    if (includeMap(dataRanges, binaryScalarRestrictions)) {
    	System.out.println("+ entities, binaryScalarRestrictions")
    }
    if (includeMap(dataRanges, iriScalarRestrictions)) {
    	System.out.println("+ entities, iriScalarRestrictions")
    }
    if (includeMap(dataRanges, numericScalarRestrictions)) {
    	System.out.println("+ entities, numericScalarRestrictions")
    }
    if (includeMap(dataRanges, plainLiteralScalarRestrictions)) {
    	System.out.println("+ entities, plainLiteralScalarRestrictions")
    }
    if (includeMap(dataRanges, scalarOneOfRestrictions)) {
    	System.out.println("+ entities, scalarOneOfRestrictions")
    }
    if (includeMap(dataRanges, stringScalarRestrictions)) {
    	System.out.println("+ entities, stringScalarRestrictions")
    }
    if (includeMap(dataRanges, synonymScalarRestrictions)) {
    	System.out.println("+ entities, synonymScalarRestrictions")
    }
    if (includeMap(dataRanges, timeScalarRestrictions)) {
    	System.out.println("+ entities, timeScalarRestrictions")
    }

	// Lookup table for DataRelationshipToScalar cross references
  	if (includeMap(dataRelationshipToScalars, entityScalarDataProperties)) {
  		System.out.println("+ entities, entityScalarDataProperties")
  	}
  	if (includeMap(dataRelationshipToScalars, scalarDataProperties)) {
  		System.out.println("+ entities, scalarDataProperties")
  	}

	// Lookup table for DataRelationshipToStructure cross references
  	if (includeMap(dataRelationshipToStructures, entityStructuredDataProperties)) {
  		System.out.println("+ entities, entityStructuredDataProperties")
  	}
  	if (includeMap(dataRelationshipToStructures, structuredDataProperties)) {
  		System.out.println("+ entities, structuredDataProperties")
  	}

	// Lookup table for Predicate cross references
    if (includeMap(predicates, aspects)) {
    	System.out.println("+ entities, aspects")
    }
    if (includeMap(predicates, concepts)) {
    	System.out.println("+ entities, concepts")
    }
    if (includeMap(predicates, reifiedRelationships)) {
    	System.out.println("+ entities, reifiedRelationships")
    }
    if (includeMap(predicates, reifiedRelationshipRestrictions)) {
    	System.out.println("+ entities, reifiedRelationshipRestrictions")
    }
    if (includeMap(predicates, forwardProperties)) {
    	System.out.println("+ entities, forwardProperties")
    }
    if (includeMap(predicates, inverseProperties)) {
    	System.out.println("+ entities, inverseProperties")
    }
    if (includeMap(predicates, unreifiedRelationships)) {
    	System.out.println("+ entities, unreifiedRelationships")
    }
    if (includeMap(predicates, cardinalityRestrictedAspects)) {
    	System.out.println("+ entities, cardinalityRestrictedAspects")
    }
    if (includeMap(predicates, cardinalityRestrictedConcepts)) {
    	System.out.println("+ entities, cardinalityRestrictedConcepts")
    }
    if (includeMap(predicates, cardinalityRestrictedReifiedRelationships)) {
    	System.out.println("+ entities, cardinalityRestrictedReifiedRelationships")
    }

	// Lookup table for RestrictableRelationship cross references
    if (includeMap(restrictableRelationships, forwardProperties)) {
    	System.out.println("+ entities, forwardProperties")
    }
    if (includeMap(restrictableRelationships, inverseProperties)) {
    	System.out.println("+ entities, inverseProperties")
    }
    if (includeMap(restrictableRelationships, unreifiedRelationships)) {
    	System.out.println("+ entities, unreifiedRelationships")
    }

	// Lookup table for RestrictionStructuredDataPropertyContext cross references
  	if (includeMap(restrictionStructuredDataPropertyContexts, entityStructuredDataPropertyParticularRestrictionAxioms)) {
  		System.out.println("+ entities, entityStructuredDataPropertyParticularRestrictionAxioms")
  	}
  	if (includeMap(restrictionStructuredDataPropertyContexts, restrictionStructuredDataPropertyTuples)) {
  		System.out.println("+ entities, restrictionStructuredDataPropertyTuples")
  	}

	// Lookup table for TerminologyBox cross references
  	if (includeMap(terminologyBoxes, terminologyGraphs)) {
  		System.out.println("+ entities, terminologyGraphs")
  	}
  	if (includeMap(terminologyBoxes, bundles)) {
  		System.out.println("+ entities, bundles")
  	}

	// Lookup table for ConceptTreeDisjunction cross references
  	if (includeMap(conceptTreeDisjunctions, rootConceptTaxonomyAxioms)) {
  		System.out.println("+ entities, rootConceptTaxonomyAxioms")
  	}
  	if (includeMap(conceptTreeDisjunctions, anonymousConceptUnionAxioms)) {
  		System.out.println("+ entities, anonymousConceptUnionAxioms")
  	}

	// Lookup table for ConceptualEntitySingletonInstance cross references
  	if (includeMap(conceptualEntitySingletonInstances, conceptInstances)) {
  		System.out.println("+ entities, conceptInstances")
  	}
  	if (includeMap(conceptualEntitySingletonInstances, reifiedRelationshipInstances)) {
  		System.out.println("+ entities, reifiedRelationshipInstances")
  	}

	// Lookup table for SingletonInstanceStructuredDataPropertyContext cross references
  	if (includeMap(singletonInstanceStructuredDataPropertyContexts, singletonInstanceStructuredDataPropertyValues)) {
  		System.out.println("+ entities, singletonInstanceStructuredDataPropertyValues")
  	}
  	if (includeMap(singletonInstanceStructuredDataPropertyContexts, structuredDataPropertyTuples)) {
  		System.out.println("+ entities, structuredDataPropertyTuples")
  	}

  	var iterations = 0
  	val progress = new ArrayList<Boolean>(1)
  	val allDone = new ArrayList<Boolean>(1)
  	progress.add(false)
  	allDone.add(false)
    do {
    	progress.set(0, false)
    	allDone.set(0, true)
    	iterations += 1
    	System.out.println("Resolve iterations: "+iterations)
    	resolveAnnotationProperties(rs, progress, allDone)
    	resolveAspects(rs, progress, allDone)
    	resolveConcepts(rs, progress, allDone)
    	resolveScalars(rs, progress, allDone)
    	resolveStructures(rs, progress, allDone)
    	resolveConceptDesignationTerminologyAxioms(rs, progress, allDone)
    	resolveTerminologyExtensionAxioms(rs, progress, allDone)
    	resolveTerminologyNestingAxioms(rs, progress, allDone)
    	resolveBundledTerminologyAxioms(rs, progress, allDone)
    	resolveDescriptionBoxExtendsClosedWorldDefinitions(rs, progress, allDone)
    	resolveDescriptionBoxRefinements(rs, progress, allDone)
    	resolveBinaryScalarRestrictions(rs, progress, allDone)
    	resolveIRIScalarRestrictions(rs, progress, allDone)
    	resolveNumericScalarRestrictions(rs, progress, allDone)
    	resolvePlainLiteralScalarRestrictions(rs, progress, allDone)
    	resolveScalarOneOfRestrictions(rs, progress, allDone)
    	resolveScalarOneOfLiteralAxioms(rs, progress, allDone)
    	resolveStringScalarRestrictions(rs, progress, allDone)
    	resolveSynonymScalarRestrictions(rs, progress, allDone)
    	resolveTimeScalarRestrictions(rs, progress, allDone)
    	resolveEntityScalarDataProperties(rs, progress, allDone)
    	resolveEntityStructuredDataProperties(rs, progress, allDone)
    	resolveScalarDataProperties(rs, progress, allDone)
    	resolveStructuredDataProperties(rs, progress, allDone)
    	resolveReifiedRelationships(rs, progress, allDone)
    	resolveReifiedRelationshipRestrictions(rs, progress, allDone)
    	resolveForwardProperties(rs, progress, allDone)
    	resolveInverseProperties(rs, progress, allDone)
    	resolveUnreifiedRelationships(rs, progress, allDone)
    	resolveChainRules(rs, progress, allDone)
    	resolveRuleBodySegments(rs, progress, allDone)
    	resolveSegmentPredicates(rs, progress, allDone)
    	resolveEntityExistentialRestrictionAxioms(rs, progress, allDone)
    	resolveEntityUniversalRestrictionAxioms(rs, progress, allDone)
    	resolveEntityScalarDataPropertyExistentialRestrictionAxioms(rs, progress, allDone)
    	resolveEntityScalarDataPropertyParticularRestrictionAxioms(rs, progress, allDone)
    	resolveEntityScalarDataPropertyUniversalRestrictionAxioms(rs, progress, allDone)
    	resolveEntityStructuredDataPropertyParticularRestrictionAxioms(rs, progress, allDone)
    	resolveRestrictionStructuredDataPropertyTuples(rs, progress, allDone)
    	resolveRestrictionScalarDataPropertyValues(rs, progress, allDone)
    	resolveAspectSpecializationAxioms(rs, progress, allDone)
    	resolveConceptSpecializationAxioms(rs, progress, allDone)
    	resolveReifiedRelationshipSpecializationAxioms(rs, progress, allDone)
    	resolveSubDataPropertyOfAxioms(rs, progress, allDone)
    	resolveSubObjectPropertyOfAxioms(rs, progress, allDone)
    	resolveRootConceptTaxonomyAxioms(rs, progress, allDone)
    	resolveAnonymousConceptUnionAxioms(rs, progress, allDone)
    	resolveSpecificDisjointConceptAxioms(rs, progress, allDone)
    	resolveConceptInstances(rs, progress, allDone)
    	resolveReifiedRelationshipInstances(rs, progress, allDone)
    	resolveReifiedRelationshipInstanceDomains(rs, progress, allDone)
    	resolveReifiedRelationshipInstanceRanges(rs, progress, allDone)
    	resolveUnreifiedRelationshipInstanceTuples(rs, progress, allDone)
    	resolveSingletonInstanceStructuredDataPropertyValues(rs, progress, allDone)
    	resolveSingletonInstanceScalarDataPropertyValues(rs, progress, allDone)
    	resolveStructuredDataPropertyTuples(rs, progress, allDone)
    	resolveScalarDataPropertyValues(rs, progress, allDone)
    	resolveAnnotationPropertyValues(rs, progress, allDone)
    	resolveCardinalityRestrictedAspects(rs, progress, allDone)
    	resolveCardinalityRestrictedConcepts(rs, progress, allDone)
    	resolveCardinalityRestrictedReifiedRelationships(rs, progress, allDone)
    } while (!allDone.get(0) && !progress.get(0) && iterations < 10)
    if (!allDone.get(0) && !progress.get(0)) {
    	throw new IllegalArgumentException("Failed to resolve cross references within "+iterations+" iterations.")
    }
    val dt = t0 - System.currentTimeMillis
    val ms = dt % 1000
    val s = dt / 1000
    System.out.println("Resolve: "+r.URI+" in "+s+"s, "+ms+"ms")
  }

  protected def void resolveAnnotationProperties(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	annotationProperties.forEach[uuid, oml_kv |
  	  val AnnotationProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String moduleXRef = kv.get("moduleUUID")
  	    val Pair<Module, Map<String, String>> modulePair = modules.get(moduleXRef)
  	    if (null !== modulePair) {
  	    	oml.module = modulePair.key
  	    	kv.remove("moduleUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveAspects(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	aspects.forEach[uuid, oml_kv |
  	  val Aspect oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveConcepts(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	concepts.forEach[uuid, oml_kv |
  	  val Concept oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveScalars(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	scalars.forEach[uuid, oml_kv |
  	  val Scalar oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveStructures(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	structures.forEach[uuid, oml_kv |
  	  val Structure oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveConceptDesignationTerminologyAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	var more = false
  	do {
  		val queue = new HashMap<String, Pair<ConceptDesignationTerminologyAxiom, Map<String, String>>>()
  		conceptDesignationTerminologyAxioms.filter[uuid, oml_kv|!oml_kv.value.empty].forEach[uuid, oml_kv|queue.put(uuid, oml_kv)]
  		more = !queue.empty
  		if (more) {
  			queue.forEach[uuid, oml_kv |
  	  			val ConceptDesignationTerminologyAxiom oml = oml_kv.key
  	  			val Map<String, String> kv = oml_kv.value
  	  			if (!kv.empty) {
  	  				allDone.set(0, false)
  	    			val String tboxXRef = kv.get("tboxUUID")
  	    			val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    			if (null !== tboxPair) {
  	    				oml.tbox = tboxPair.key
  	    				kv.remove("tboxUUID")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	    			val String designatedConceptXRef = kv.get("designatedConceptUUID")
  	    			val Pair<ConceptKind, Map<String, String>> designatedConceptPair = conceptKinds.get(designatedConceptXRef)
  	    			if (null !== designatedConceptPair) {
  	    				oml.designatedConcept = designatedConceptPair.key
  	    				kv.remove("designatedConceptUUID")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	    			val String designatedTerminologyIRI = kv.get("designatedTerminologyIRI")
  	    			val Pair<TerminologyBox, Map<String, String>> designatedTerminologyPair = terminologyBoxes.get(designatedTerminologyIRI)
  	    			if (null !== designatedTerminologyPair) {
  	    				oml.designatedTerminology = designatedTerminologyPair.key
  	    				kv.remove("designatedTerminologyIRI")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	  			}
  			]
  		}
  	} while (more && progress.get(0))
  }
  
  protected def void resolveTerminologyExtensionAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	var more = false
  	do {
  		val queue = new HashMap<String, Pair<TerminologyExtensionAxiom, Map<String, String>>>()
  		terminologyExtensionAxioms.filter[uuid, oml_kv|!oml_kv.value.empty].forEach[uuid, oml_kv|queue.put(uuid, oml_kv)]
  		more = !queue.empty
  		if (more) {
  			queue.forEach[uuid, oml_kv |
  	  			val TerminologyExtensionAxiom oml = oml_kv.key
  	  			val Map<String, String> kv = oml_kv.value
  	  			if (!kv.empty) {
  	  				allDone.set(0, false)
  	    			val String tboxXRef = kv.get("tboxUUID")
  	    			val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    			if (null !== tboxPair) {
  	    				oml.tbox = tboxPair.key
  	    				kv.remove("tboxUUID")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	    			val String extendedTerminologyIRI = kv.get("extendedTerminologyIRI")
  	    			val Pair<TerminologyBox, Map<String, String>> extendedTerminologyPair = terminologyBoxes.get(extendedTerminologyIRI)
  	    			if (null !== extendedTerminologyPair) {
  	    				oml.extendedTerminology = extendedTerminologyPair.key
  	    				kv.remove("extendedTerminologyIRI")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	  			}
  			]
  		}
  	} while (more && progress.get(0))
  }
  
  protected def void resolveTerminologyNestingAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	var more = false
  	do {
  		val queue = new HashMap<String, Pair<TerminologyNestingAxiom, Map<String, String>>>()
  		terminologyNestingAxioms.filter[uuid, oml_kv|!oml_kv.value.empty].forEach[uuid, oml_kv|queue.put(uuid, oml_kv)]
  		more = !queue.empty
  		if (more) {
  			queue.forEach[uuid, oml_kv |
  	  			val TerminologyNestingAxiom oml = oml_kv.key
  	  			val Map<String, String> kv = oml_kv.value
  	  			if (!kv.empty) {
  	  				allDone.set(0, false)
  	    			val String tboxXRef = kv.get("tboxUUID")
  	    			val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    			if (null !== tboxPair) {
  	    				oml.tbox = tboxPair.key
  	    				kv.remove("tboxUUID")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	    			val String nestingContextXRef = kv.get("nestingContextUUID")
  	    			val Pair<ConceptKind, Map<String, String>> nestingContextPair = conceptKinds.get(nestingContextXRef)
  	    			if (null !== nestingContextPair) {
  	    				oml.nestingContext = nestingContextPair.key
  	    				kv.remove("nestingContextUUID")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	    			val String nestingTerminologyIRI = kv.get("nestingTerminologyIRI")
  	    			val Pair<TerminologyBox, Map<String, String>> nestingTerminologyPair = terminologyBoxes.get(nestingTerminologyIRI)
  	    			if (null !== nestingTerminologyPair) {
  	    				oml.nestingTerminology = nestingTerminologyPair.key
  	    				kv.remove("nestingTerminologyIRI")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	  			}
  			]
  		}
  	} while (more && progress.get(0))
  }
  
  protected def void resolveBundledTerminologyAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	var more = false
  	do {
  		val queue = new HashMap<String, Pair<BundledTerminologyAxiom, Map<String, String>>>()
  		bundledTerminologyAxioms.filter[uuid, oml_kv|!oml_kv.value.empty].forEach[uuid, oml_kv|queue.put(uuid, oml_kv)]
  		more = !queue.empty
  		if (more) {
  			queue.forEach[uuid, oml_kv |
  	  			val BundledTerminologyAxiom oml = oml_kv.key
  	  			val Map<String, String> kv = oml_kv.value
  	  			if (!kv.empty) {
  	  				allDone.set(0, false)
  	    			val String bundleXRef = kv.get("bundleUUID")
  	    			val Pair<Bundle, Map<String, String>> bundlePair = bundles.get(bundleXRef)
  	    			if (null !== bundlePair) {
  	    				oml.bundle = bundlePair.key
  	    				kv.remove("bundleUUID")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	    			val String bundledTerminologyIRI = kv.get("bundledTerminologyIRI")
  	    			val Pair<TerminologyBox, Map<String, String>> bundledTerminologyPair = terminologyBoxes.get(bundledTerminologyIRI)
  	    			if (null !== bundledTerminologyPair) {
  	    				oml.bundledTerminology = bundledTerminologyPair.key
  	    				kv.remove("bundledTerminologyIRI")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	  			}
  			]
  		}
  	} while (more && progress.get(0))
  }
  
  protected def void resolveDescriptionBoxExtendsClosedWorldDefinitions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	var more = false
  	do {
  		val queue = new HashMap<String, Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String, String>>>()
  		descriptionBoxExtendsClosedWorldDefinitions.filter[uuid, oml_kv|!oml_kv.value.empty].forEach[uuid, oml_kv|queue.put(uuid, oml_kv)]
  		more = !queue.empty
  		if (more) {
  			queue.forEach[uuid, oml_kv |
  	  			val DescriptionBoxExtendsClosedWorldDefinitions oml = oml_kv.key
  	  			val Map<String, String> kv = oml_kv.value
  	  			if (!kv.empty) {
  	  				allDone.set(0, false)
  	    			val String descriptionBoxXRef = kv.get("descriptionBoxUUID")
  	    			val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    			if (null !== descriptionBoxPair) {
  	    				oml.descriptionBox = descriptionBoxPair.key
  	    				kv.remove("descriptionBoxUUID")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	    			val String closedWorldDefinitionsIRI = kv.get("closedWorldDefinitionsIRI")
  	    			val Pair<TerminologyBox, Map<String, String>> closedWorldDefinitionsPair = terminologyBoxes.get(closedWorldDefinitionsIRI)
  	    			if (null !== closedWorldDefinitionsPair) {
  	    				oml.closedWorldDefinitions = closedWorldDefinitionsPair.key
  	    				kv.remove("closedWorldDefinitionsIRI")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	  			}
  			]
  		}
  	} while (more && progress.get(0))
  }
  
  protected def void resolveDescriptionBoxRefinements(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	var more = false
  	do {
  		val queue = new HashMap<String, Pair<DescriptionBoxRefinement, Map<String, String>>>()
  		descriptionBoxRefinements.filter[uuid, oml_kv|!oml_kv.value.empty].forEach[uuid, oml_kv|queue.put(uuid, oml_kv)]
  		more = !queue.empty
  		if (more) {
  			queue.forEach[uuid, oml_kv |
  	  			val DescriptionBoxRefinement oml = oml_kv.key
  	  			val Map<String, String> kv = oml_kv.value
  	  			if (!kv.empty) {
  	  				allDone.set(0, false)
  	    			val String refiningDescriptionBoxXRef = kv.get("refiningDescriptionBoxUUID")
  	    			val Pair<DescriptionBox, Map<String, String>> refiningDescriptionBoxPair = descriptionBoxes.get(refiningDescriptionBoxXRef)
  	    			if (null !== refiningDescriptionBoxPair) {
  	    				oml.refiningDescriptionBox = refiningDescriptionBoxPair.key
  	    				kv.remove("refiningDescriptionBoxUUID")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	    			val String refinedDescriptionBoxIRI = kv.get("refinedDescriptionBoxIRI")
  	    			val Pair<DescriptionBox, Map<String, String>> refinedDescriptionBoxPair = descriptionBoxes.get(refinedDescriptionBoxIRI)
  	    			if (null !== refinedDescriptionBoxPair) {
  	    				oml.refinedDescriptionBox = refinedDescriptionBoxPair.key
  	    				kv.remove("refinedDescriptionBoxIRI")
  	    				progress.set(0, true)
  	    			} else
  	    				progress.set(0, false)
  	  			}
  			]
  		}
  	} while (more && progress.get(0))
  }
  
  protected def void resolveBinaryScalarRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	binaryScalarRestrictions.forEach[uuid, oml_kv |
  	  val BinaryScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveIRIScalarRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	iriScalarRestrictions.forEach[uuid, oml_kv |
  	  val IRIScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveNumericScalarRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	numericScalarRestrictions.forEach[uuid, oml_kv |
  	  val NumericScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolvePlainLiteralScalarRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	plainLiteralScalarRestrictions.forEach[uuid, oml_kv |
  	  val PlainLiteralScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveScalarOneOfRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	scalarOneOfRestrictions.forEach[uuid, oml_kv |
  	  val ScalarOneOfRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveScalarOneOfLiteralAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	scalarOneOfLiteralAxioms.forEach[uuid, oml_kv |
  	  val ScalarOneOfLiteralAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String axiomXRef = kv.get("axiomUUID")
  	    val Pair<ScalarOneOfRestriction, Map<String, String>> axiomPair = scalarOneOfRestrictions.get(axiomXRef)
  	    if (null !== axiomPair) {
  	    	oml.axiom = axiomPair.key
  	    	kv.remove("axiomUUID")
  	    	progress.set(0, true)
  	    }
  	    val String valueTypeXRef = kv.get("valueTypeUUID")
  	    if (null !== valueTypeXRef && "null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null !== valueTypePair) {
  	      	oml.valueType = valueTypePair.key
  	      	kv.remove("valueTypeUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	  }
  	]
  }
  
  protected def void resolveStringScalarRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	stringScalarRestrictions.forEach[uuid, oml_kv |
  	  val StringScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveSynonymScalarRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	synonymScalarRestrictions.forEach[uuid, oml_kv |
  	  val SynonymScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveTimeScalarRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	timeScalarRestrictions.forEach[uuid, oml_kv |
  	  val TimeScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityScalarDataProperties(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	entityScalarDataProperties.forEach[uuid, oml_kv |
  	  val EntityScalarDataProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String domainXRef = kv.get("domainUUID")
  	    val Pair<Entity, Map<String, String>> domainPair = entities.get(domainXRef)
  	    if (null !== domainPair) {
  	    	oml.domain = domainPair.key
  	    	kv.remove("domainUUID")
  	    	progress.set(0, true)
  	    }
  	    val String rangeXRef = kv.get("rangeUUID")
  	    val Pair<DataRange, Map<String, String>> rangePair = dataRanges.get(rangeXRef)
  	    if (null !== rangePair) {
  	    	oml.range = rangePair.key
  	    	kv.remove("rangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityStructuredDataProperties(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	entityStructuredDataProperties.forEach[uuid, oml_kv |
  	  val EntityStructuredDataProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String domainXRef = kv.get("domainUUID")
  	    val Pair<Entity, Map<String, String>> domainPair = entities.get(domainXRef)
  	    if (null !== domainPair) {
  	    	oml.domain = domainPair.key
  	    	kv.remove("domainUUID")
  	    	progress.set(0, true)
  	    }
  	    val String rangeXRef = kv.get("rangeUUID")
  	    val Pair<Structure, Map<String, String>> rangePair = structures.get(rangeXRef)
  	    if (null !== rangePair) {
  	    	oml.range = rangePair.key
  	    	kv.remove("rangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveScalarDataProperties(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	scalarDataProperties.forEach[uuid, oml_kv |
  	  val ScalarDataProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String domainXRef = kv.get("domainUUID")
  	    val Pair<Structure, Map<String, String>> domainPair = structures.get(domainXRef)
  	    if (null !== domainPair) {
  	    	oml.domain = domainPair.key
  	    	kv.remove("domainUUID")
  	    	progress.set(0, true)
  	    }
  	    val String rangeXRef = kv.get("rangeUUID")
  	    val Pair<DataRange, Map<String, String>> rangePair = dataRanges.get(rangeXRef)
  	    if (null !== rangePair) {
  	    	oml.range = rangePair.key
  	    	kv.remove("rangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveStructuredDataProperties(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	structuredDataProperties.forEach[uuid, oml_kv |
  	  val StructuredDataProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String domainXRef = kv.get("domainUUID")
  	    val Pair<Structure, Map<String, String>> domainPair = structures.get(domainXRef)
  	    if (null !== domainPair) {
  	    	oml.domain = domainPair.key
  	    	kv.remove("domainUUID")
  	    	progress.set(0, true)
  	    }
  	    val String rangeXRef = kv.get("rangeUUID")
  	    val Pair<Structure, Map<String, String>> rangePair = structures.get(rangeXRef)
  	    if (null !== rangePair) {
  	    	oml.range = rangePair.key
  	    	kv.remove("rangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationships(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	reifiedRelationships.forEach[uuid, oml_kv |
  	  val ReifiedRelationship oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String sourceXRef = kv.get("sourceUUID")
  	    val Pair<Entity, Map<String, String>> sourcePair = entities.get(sourceXRef)
  	    if (null !== sourcePair) {
  	    	oml.source = sourcePair.key
  	    	kv.remove("sourceUUID")
  	    	progress.set(0, true)
  	    }
  	    val String targetXRef = kv.get("targetUUID")
  	    val Pair<Entity, Map<String, String>> targetPair = entities.get(targetXRef)
  	    if (null !== targetPair) {
  	    	oml.target = targetPair.key
  	    	kv.remove("targetUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipRestrictions(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	reifiedRelationshipRestrictions.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String sourceXRef = kv.get("sourceUUID")
  	    val Pair<Entity, Map<String, String>> sourcePair = entities.get(sourceXRef)
  	    if (null !== sourcePair) {
  	    	oml.source = sourcePair.key
  	    	kv.remove("sourceUUID")
  	    	progress.set(0, true)
  	    }
  	    val String targetXRef = kv.get("targetUUID")
  	    val Pair<Entity, Map<String, String>> targetPair = entities.get(targetXRef)
  	    if (null !== targetPair) {
  	    	oml.target = targetPair.key
  	    	kv.remove("targetUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveForwardProperties(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	forwardProperties.forEach[uuid, oml_kv |
  	  val ForwardProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String reifiedRelationshipXRef = kv.get("reifiedRelationshipUUID")
  	    val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = reifiedRelationships.get(reifiedRelationshipXRef)
  	    if (null !== reifiedRelationshipPair) {
  	    	oml.reifiedRelationship = reifiedRelationshipPair.key
  	    	kv.remove("reifiedRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveInverseProperties(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	inverseProperties.forEach[uuid, oml_kv |
  	  val InverseProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String reifiedRelationshipXRef = kv.get("reifiedRelationshipUUID")
  	    val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = reifiedRelationships.get(reifiedRelationshipXRef)
  	    if (null !== reifiedRelationshipPair) {
  	    	oml.reifiedRelationship = reifiedRelationshipPair.key
  	    	kv.remove("reifiedRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveUnreifiedRelationships(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	unreifiedRelationships.forEach[uuid, oml_kv |
  	  val UnreifiedRelationship oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String sourceXRef = kv.get("sourceUUID")
  	    val Pair<Entity, Map<String, String>> sourcePair = entities.get(sourceXRef)
  	    if (null !== sourcePair) {
  	    	oml.source = sourcePair.key
  	    	kv.remove("sourceUUID")
  	    	progress.set(0, true)
  	    }
  	    val String targetXRef = kv.get("targetUUID")
  	    val Pair<Entity, Map<String, String>> targetPair = entities.get(targetXRef)
  	    if (null !== targetPair) {
  	    	oml.target = targetPair.key
  	    	kv.remove("targetUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveChainRules(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	chainRules.forEach[uuid, oml_kv |
  	  val ChainRule oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String headXRef = kv.get("headUUID")
  	    val Pair<UnreifiedRelationship, Map<String, String>> headPair = unreifiedRelationships.get(headXRef)
  	    if (null !== headPair) {
  	    	oml.head = headPair.key
  	    	kv.remove("headUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveRuleBodySegments(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	ruleBodySegments.forEach[uuid, oml_kv |
  	  val RuleBodySegment oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String previousSegmentXRef = kv.get("previousSegmentUUID")
  	    if (null !== previousSegmentXRef && "null" != previousSegmentXRef) {
  	      val Pair<RuleBodySegment, Map<String, String>> previousSegmentPair = ruleBodySegments.get(previousSegmentXRef)
  	      if (null !== previousSegmentPair) {
  	      	oml.previousSegment = previousSegmentPair.key
  	      	kv.remove("previousSegmentUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String ruleXRef = kv.get("ruleUUID")
  	    if (null !== ruleXRef && "null" != ruleXRef) {
  	      val Pair<ChainRule, Map<String, String>> rulePair = chainRules.get(ruleXRef)
  	      if (null !== rulePair) {
  	      	oml.rule = rulePair.key
  	      	kv.remove("ruleUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	  }
  	]
  }
  
  protected def void resolveSegmentPredicates(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	segmentPredicates.forEach[uuid, oml_kv |
  	  val SegmentPredicate oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String bodySegmentXRef = kv.get("bodySegmentUUID")
  	    val Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = ruleBodySegments.get(bodySegmentXRef)
  	    if (null !== bodySegmentPair) {
  	    	oml.bodySegment = bodySegmentPair.key
  	    	kv.remove("bodySegmentUUID")
  	    	progress.set(0, true)
  	    }
  	    val String predicateXRef = kv.get("predicateUUID")
  	    if (null !== predicateXRef && "null" != predicateXRef) {
  	      val Pair<Predicate, Map<String, String>> predicatePair = predicates.get(predicateXRef)
  	      if (null !== predicatePair) {
  	      	oml.predicate = predicatePair.key
  	      	kv.remove("predicateUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String reifiedRelationshipSourceXRef = kv.get("reifiedRelationshipSourceUUID")
  	    if (null !== reifiedRelationshipSourceXRef && "null" != reifiedRelationshipSourceXRef) {
  	      val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipSourcePair = reifiedRelationships.get(reifiedRelationshipSourceXRef)
  	      if (null !== reifiedRelationshipSourcePair) {
  	      	oml.reifiedRelationshipSource = reifiedRelationshipSourcePair.key
  	      	kv.remove("reifiedRelationshipSourceUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String reifiedRelationshipInverseSourceXRef = kv.get("reifiedRelationshipInverseSourceUUID")
  	    if (null !== reifiedRelationshipInverseSourceXRef && "null" != reifiedRelationshipInverseSourceXRef) {
  	      val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipInverseSourcePair = reifiedRelationships.get(reifiedRelationshipInverseSourceXRef)
  	      if (null !== reifiedRelationshipInverseSourcePair) {
  	      	oml.reifiedRelationshipInverseSource = reifiedRelationshipInverseSourcePair.key
  	      	kv.remove("reifiedRelationshipInverseSourceUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String reifiedRelationshipTargetXRef = kv.get("reifiedRelationshipTargetUUID")
  	    if (null !== reifiedRelationshipTargetXRef && "null" != reifiedRelationshipTargetXRef) {
  	      val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipTargetPair = reifiedRelationships.get(reifiedRelationshipTargetXRef)
  	      if (null !== reifiedRelationshipTargetPair) {
  	      	oml.reifiedRelationshipTarget = reifiedRelationshipTargetPair.key
  	      	kv.remove("reifiedRelationshipTargetUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String reifiedRelationshipInverseTargetXRef = kv.get("reifiedRelationshipInverseTargetUUID")
  	    if (null !== reifiedRelationshipInverseTargetXRef && "null" != reifiedRelationshipInverseTargetXRef) {
  	      val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipInverseTargetPair = reifiedRelationships.get(reifiedRelationshipInverseTargetXRef)
  	      if (null !== reifiedRelationshipInverseTargetPair) {
  	      	oml.reifiedRelationshipInverseTarget = reifiedRelationshipInverseTargetPair.key
  	      	kv.remove("reifiedRelationshipInverseTargetUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String unreifiedRelationshipInverseXRef = kv.get("unreifiedRelationshipInverseUUID")
  	    if (null !== unreifiedRelationshipInverseXRef && "null" != unreifiedRelationshipInverseXRef) {
  	      val Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipInversePair = unreifiedRelationships.get(unreifiedRelationshipInverseXRef)
  	      if (null !== unreifiedRelationshipInversePair) {
  	      	oml.unreifiedRelationshipInverse = unreifiedRelationshipInversePair.key
  	      	kv.remove("unreifiedRelationshipInverseUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityExistentialRestrictionAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	entityExistentialRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityExistentialRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedDomainXRef = kv.get("restrictedDomainUUID")
  	    val Pair<Entity, Map<String, String>> restrictedDomainPair = entities.get(restrictedDomainXRef)
  	    if (null !== restrictedDomainPair) {
  	    	oml.restrictedDomain = restrictedDomainPair.key
  	    	kv.remove("restrictedDomainUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<Entity, Map<String, String>> restrictedRangePair = entities.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID")
  	    val Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = restrictableRelationships.get(restrictedRelationshipXRef)
  	    if (null !== restrictedRelationshipPair) {
  	    	oml.restrictedRelationship = restrictedRelationshipPair.key
  	    	kv.remove("restrictedRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityUniversalRestrictionAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	entityUniversalRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityUniversalRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedDomainXRef = kv.get("restrictedDomainUUID")
  	    val Pair<Entity, Map<String, String>> restrictedDomainPair = entities.get(restrictedDomainXRef)
  	    if (null !== restrictedDomainPair) {
  	    	oml.restrictedDomain = restrictedDomainPair.key
  	    	kv.remove("restrictedDomainUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    val Pair<Entity, Map<String, String>> restrictedRangePair = entities.get(restrictedRangeXRef)
  	    if (null !== restrictedRangePair) {
  	    	oml.restrictedRange = restrictedRangePair.key
  	    	kv.remove("restrictedRangeUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID")
  	    val Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = restrictableRelationships.get(restrictedRelationshipXRef)
  	    if (null !== restrictedRelationshipPair) {
  	    	oml.restrictedRelationship = restrictedRelationshipPair.key
  	    	kv.remove("restrictedRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityScalarDataPropertyExistentialRestrictionAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	entityScalarDataPropertyExistentialRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityScalarDataPropertyExistentialRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedEntityXRef = kv.get("restrictedEntityUUID")
  	    val Pair<Entity, Map<String, String>> restrictedEntityPair = entities.get(restrictedEntityXRef)
  	    if (null !== restrictedEntityPair) {
  	    	oml.restrictedEntity = restrictedEntityPair.key
  	    	kv.remove("restrictedEntityUUID")
  	    	progress.set(0, true)
  	    }
  	    val String scalarPropertyXRef = kv.get("scalarPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = entityScalarDataProperties.get(scalarPropertyXRef)
  	    if (null !== scalarPropertyPair) {
  	    	oml.scalarProperty = scalarPropertyPair.key
  	    	kv.remove("scalarPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String scalarRestrictionXRef = kv.get("scalarRestrictionUUID")
  	    val Pair<DataRange, Map<String, String>> scalarRestrictionPair = dataRanges.get(scalarRestrictionXRef)
  	    if (null !== scalarRestrictionPair) {
  	    	oml.scalarRestriction = scalarRestrictionPair.key
  	    	kv.remove("scalarRestrictionUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityScalarDataPropertyParticularRestrictionAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	entityScalarDataPropertyParticularRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityScalarDataPropertyParticularRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedEntityXRef = kv.get("restrictedEntityUUID")
  	    val Pair<Entity, Map<String, String>> restrictedEntityPair = entities.get(restrictedEntityXRef)
  	    if (null !== restrictedEntityPair) {
  	    	oml.restrictedEntity = restrictedEntityPair.key
  	    	kv.remove("restrictedEntityUUID")
  	    	progress.set(0, true)
  	    }
  	    val String scalarPropertyXRef = kv.get("scalarPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = entityScalarDataProperties.get(scalarPropertyXRef)
  	    if (null !== scalarPropertyPair) {
  	    	oml.scalarProperty = scalarPropertyPair.key
  	    	kv.remove("scalarPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String valueTypeXRef = kv.get("valueTypeUUID")
  	    if (null !== valueTypeXRef && "null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null !== valueTypePair) {
  	      	oml.valueType = valueTypePair.key
  	      	kv.remove("valueTypeUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityScalarDataPropertyUniversalRestrictionAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	entityScalarDataPropertyUniversalRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityScalarDataPropertyUniversalRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedEntityXRef = kv.get("restrictedEntityUUID")
  	    val Pair<Entity, Map<String, String>> restrictedEntityPair = entities.get(restrictedEntityXRef)
  	    if (null !== restrictedEntityPair) {
  	    	oml.restrictedEntity = restrictedEntityPair.key
  	    	kv.remove("restrictedEntityUUID")
  	    	progress.set(0, true)
  	    }
  	    val String scalarPropertyXRef = kv.get("scalarPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = entityScalarDataProperties.get(scalarPropertyXRef)
  	    if (null !== scalarPropertyPair) {
  	    	oml.scalarProperty = scalarPropertyPair.key
  	    	kv.remove("scalarPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String scalarRestrictionXRef = kv.get("scalarRestrictionUUID")
  	    val Pair<DataRange, Map<String, String>> scalarRestrictionPair = dataRanges.get(scalarRestrictionXRef)
  	    if (null !== scalarRestrictionPair) {
  	    	oml.scalarRestriction = scalarRestrictionPair.key
  	    	kv.remove("scalarRestrictionUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityStructuredDataPropertyParticularRestrictionAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	entityStructuredDataPropertyParticularRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityStructuredDataPropertyParticularRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String structuredDataPropertyXRef = kv.get("structuredDataPropertyUUID")
  	    val Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = dataRelationshipToStructures.get(structuredDataPropertyXRef)
  	    if (null !== structuredDataPropertyPair) {
  	    	oml.structuredDataProperty = structuredDataPropertyPair.key
  	    	kv.remove("structuredDataPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedEntityXRef = kv.get("restrictedEntityUUID")
  	    val Pair<Entity, Map<String, String>> restrictedEntityPair = entities.get(restrictedEntityXRef)
  	    if (null !== restrictedEntityPair) {
  	    	oml.restrictedEntity = restrictedEntityPair.key
  	    	kv.remove("restrictedEntityUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveRestrictionStructuredDataPropertyTuples(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	restrictionStructuredDataPropertyTuples.forEach[uuid, oml_kv |
  	  val RestrictionStructuredDataPropertyTuple oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String structuredDataPropertyContextXRef = kv.get("structuredDataPropertyContextUUID")
  	    val Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef)
  	    if (null !== structuredDataPropertyContextPair) {
  	    	oml.structuredDataPropertyContext = structuredDataPropertyContextPair.key
  	    	kv.remove("structuredDataPropertyContextUUID")
  	    	progress.set(0, true)
  	    }
  	    val String structuredDataPropertyXRef = kv.get("structuredDataPropertyUUID")
  	    val Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = dataRelationshipToStructures.get(structuredDataPropertyXRef)
  	    if (null !== structuredDataPropertyPair) {
  	    	oml.structuredDataProperty = structuredDataPropertyPair.key
  	    	kv.remove("structuredDataPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveRestrictionScalarDataPropertyValues(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	restrictionScalarDataPropertyValues.forEach[uuid, oml_kv |
  	  val RestrictionScalarDataPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String structuredDataPropertyContextXRef = kv.get("structuredDataPropertyContextUUID")
  	    val Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef)
  	    if (null !== structuredDataPropertyContextPair) {
  	    	oml.structuredDataPropertyContext = structuredDataPropertyContextPair.key
  	    	kv.remove("structuredDataPropertyContextUUID")
  	    	progress.set(0, true)
  	    }
  	    val String scalarDataPropertyXRef = kv.get("scalarDataPropertyUUID")
  	    val Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = dataRelationshipToScalars.get(scalarDataPropertyXRef)
  	    if (null !== scalarDataPropertyPair) {
  	    	oml.scalarDataProperty = scalarDataPropertyPair.key
  	    	kv.remove("scalarDataPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String valueTypeXRef = kv.get("valueTypeUUID")
  	    if (null !== valueTypeXRef && "null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null !== valueTypePair) {
  	      	oml.valueType = valueTypePair.key
  	      	kv.remove("valueTypeUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	  }
  	]
  }
  
  protected def void resolveAspectSpecializationAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	aspectSpecializationAxioms.forEach[uuid, oml_kv |
  	  val AspectSpecializationAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String superAspectXRef = kv.get("superAspectUUID")
  	    val Pair<AspectKind, Map<String, String>> superAspectPair = aspectKinds.get(superAspectXRef)
  	    if (null !== superAspectPair) {
  	    	oml.superAspect = superAspectPair.key
  	    	kv.remove("superAspectUUID")
  	    	progress.set(0, true)
  	    }
  	    val String subEntityXRef = kv.get("subEntityUUID")
  	    val Pair<Entity, Map<String, String>> subEntityPair = entities.get(subEntityXRef)
  	    if (null !== subEntityPair) {
  	    	oml.subEntity = subEntityPair.key
  	    	kv.remove("subEntityUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveConceptSpecializationAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	conceptSpecializationAxioms.forEach[uuid, oml_kv |
  	  val ConceptSpecializationAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String superConceptXRef = kv.get("superConceptUUID")
  	    val Pair<ConceptKind, Map<String, String>> superConceptPair = conceptKinds.get(superConceptXRef)
  	    if (null !== superConceptPair) {
  	    	oml.superConcept = superConceptPair.key
  	    	kv.remove("superConceptUUID")
  	    	progress.set(0, true)
  	    }
  	    val String subConceptXRef = kv.get("subConceptUUID")
  	    val Pair<ConceptKind, Map<String, String>> subConceptPair = conceptKinds.get(subConceptXRef)
  	    if (null !== subConceptPair) {
  	    	oml.subConcept = subConceptPair.key
  	    	kv.remove("subConceptUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipSpecializationAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	reifiedRelationshipSpecializationAxioms.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipSpecializationAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String superRelationshipXRef = kv.get("superRelationshipUUID")
  	    val Pair<ConceptualRelationship, Map<String, String>> superRelationshipPair = conceptualRelationships.get(superRelationshipXRef)
  	    if (null !== superRelationshipPair) {
  	    	oml.superRelationship = superRelationshipPair.key
  	    	kv.remove("superRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	    val String subRelationshipXRef = kv.get("subRelationshipUUID")
  	    val Pair<ConceptualRelationship, Map<String, String>> subRelationshipPair = conceptualRelationships.get(subRelationshipXRef)
  	    if (null !== subRelationshipPair) {
  	    	oml.subRelationship = subRelationshipPair.key
  	    	kv.remove("subRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveSubDataPropertyOfAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	subDataPropertyOfAxioms.forEach[uuid, oml_kv |
  	  val SubDataPropertyOfAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String subPropertyXRef = kv.get("subPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> subPropertyPair = entityScalarDataProperties.get(subPropertyXRef)
  	    if (null !== subPropertyPair) {
  	    	oml.subProperty = subPropertyPair.key
  	    	kv.remove("subPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String superPropertyXRef = kv.get("superPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> superPropertyPair = entityScalarDataProperties.get(superPropertyXRef)
  	    if (null !== superPropertyPair) {
  	    	oml.superProperty = superPropertyPair.key
  	    	kv.remove("superPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveSubObjectPropertyOfAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	subObjectPropertyOfAxioms.forEach[uuid, oml_kv |
  	  val SubObjectPropertyOfAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String subPropertyXRef = kv.get("subPropertyUUID")
  	    val Pair<UnreifiedRelationship, Map<String, String>> subPropertyPair = unreifiedRelationships.get(subPropertyXRef)
  	    if (null !== subPropertyPair) {
  	    	oml.subProperty = subPropertyPair.key
  	    	kv.remove("subPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String superPropertyXRef = kv.get("superPropertyUUID")
  	    val Pair<UnreifiedRelationship, Map<String, String>> superPropertyPair = unreifiedRelationships.get(superPropertyXRef)
  	    if (null !== superPropertyPair) {
  	    	oml.superProperty = superPropertyPair.key
  	    	kv.remove("superPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveRootConceptTaxonomyAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	rootConceptTaxonomyAxioms.forEach[uuid, oml_kv |
  	  val RootConceptTaxonomyAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String bundleXRef = kv.get("bundleUUID")
  	    val Pair<Bundle, Map<String, String>> bundlePair = bundles.get(bundleXRef)
  	    if (null !== bundlePair) {
  	    	oml.bundle = bundlePair.key
  	    	kv.remove("bundleUUID")
  	    	progress.set(0, true)
  	    }
  	    val String rootXRef = kv.get("rootUUID")
  	    val Pair<ConceptKind, Map<String, String>> rootPair = conceptKinds.get(rootXRef)
  	    if (null !== rootPair) {
  	    	oml.root = rootPair.key
  	    	kv.remove("rootUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveAnonymousConceptUnionAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	anonymousConceptUnionAxioms.forEach[uuid, oml_kv |
  	  val AnonymousConceptUnionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String disjointTaxonomyParentXRef = kv.get("disjointTaxonomyParentUUID")
  	    val Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = conceptTreeDisjunctions.get(disjointTaxonomyParentXRef)
  	    if (null !== disjointTaxonomyParentPair) {
  	    	oml.disjointTaxonomyParent = disjointTaxonomyParentPair.key
  	    	kv.remove("disjointTaxonomyParentUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveSpecificDisjointConceptAxioms(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	specificDisjointConceptAxioms.forEach[uuid, oml_kv |
  	  val SpecificDisjointConceptAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String disjointTaxonomyParentXRef = kv.get("disjointTaxonomyParentUUID")
  	    val Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = conceptTreeDisjunctions.get(disjointTaxonomyParentXRef)
  	    if (null !== disjointTaxonomyParentPair) {
  	    	oml.disjointTaxonomyParent = disjointTaxonomyParentPair.key
  	    	kv.remove("disjointTaxonomyParentUUID")
  	    	progress.set(0, true)
  	    }
  	    val String disjointLeafXRef = kv.get("disjointLeafUUID")
  	    val Pair<ConceptKind, Map<String, String>> disjointLeafPair = conceptKinds.get(disjointLeafXRef)
  	    if (null !== disjointLeafPair) {
  	    	oml.disjointLeaf = disjointLeafPair.key
  	    	kv.remove("disjointLeafUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveConceptInstances(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	conceptInstances.forEach[uuid, oml_kv |
  	  val ConceptInstance oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.get("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null !== descriptionBoxPair) {
  	    	oml.descriptionBox = descriptionBoxPair.key
  	    	kv.remove("descriptionBoxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String singletonConceptClassifierXRef = kv.get("singletonConceptClassifierUUID")
  	    val Pair<ConceptKind, Map<String, String>> singletonConceptClassifierPair = conceptKinds.get(singletonConceptClassifierXRef)
  	    if (null !== singletonConceptClassifierPair) {
  	    	oml.singletonConceptClassifier = singletonConceptClassifierPair.key
  	    	kv.remove("singletonConceptClassifierUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipInstances(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	reifiedRelationshipInstances.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipInstance oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.get("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null !== descriptionBoxPair) {
  	    	oml.descriptionBox = descriptionBoxPair.key
  	    	kv.remove("descriptionBoxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String singletonConceptualRelationshipClassifierXRef = kv.get("singletonConceptualRelationshipClassifierUUID")
  	    val Pair<ConceptualRelationship, Map<String, String>> singletonConceptualRelationshipClassifierPair = conceptualRelationships.get(singletonConceptualRelationshipClassifierXRef)
  	    if (null !== singletonConceptualRelationshipClassifierPair) {
  	    	oml.singletonConceptualRelationshipClassifier = singletonConceptualRelationshipClassifierPair.key
  	    	kv.remove("singletonConceptualRelationshipClassifierUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipInstanceDomains(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	reifiedRelationshipInstanceDomains.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipInstanceDomain oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.get("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null !== descriptionBoxPair) {
  	    	oml.descriptionBox = descriptionBoxPair.key
  	    	kv.remove("descriptionBoxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String reifiedRelationshipInstanceXRef = kv.get("reifiedRelationshipInstanceUUID")
  	    val Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef)
  	    if (null !== reifiedRelationshipInstancePair) {
  	    	oml.reifiedRelationshipInstance = reifiedRelationshipInstancePair.key
  	    	kv.remove("reifiedRelationshipInstanceUUID")
  	    	progress.set(0, true)
  	    }
  	    val String domainXRef = kv.get("domainUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = conceptualEntitySingletonInstances.get(domainXRef)
  	    if (null !== domainPair) {
  	    	oml.domain = domainPair.key
  	    	kv.remove("domainUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipInstanceRanges(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	reifiedRelationshipInstanceRanges.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipInstanceRange oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.get("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null !== descriptionBoxPair) {
  	    	oml.descriptionBox = descriptionBoxPair.key
  	    	kv.remove("descriptionBoxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String reifiedRelationshipInstanceXRef = kv.get("reifiedRelationshipInstanceUUID")
  	    val Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef)
  	    if (null !== reifiedRelationshipInstancePair) {
  	    	oml.reifiedRelationshipInstance = reifiedRelationshipInstancePair.key
  	    	kv.remove("reifiedRelationshipInstanceUUID")
  	    	progress.set(0, true)
  	    }
  	    val String rangeXRef = kv.get("rangeUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = conceptualEntitySingletonInstances.get(rangeXRef)
  	    if (null !== rangePair) {
  	    	oml.range = rangePair.key
  	    	kv.remove("rangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveUnreifiedRelationshipInstanceTuples(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	unreifiedRelationshipInstanceTuples.forEach[uuid, oml_kv |
  	  val UnreifiedRelationshipInstanceTuple oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.get("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null !== descriptionBoxPair) {
  	    	oml.descriptionBox = descriptionBoxPair.key
  	    	kv.remove("descriptionBoxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String unreifiedRelationshipXRef = kv.get("unreifiedRelationshipUUID")
  	    val Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipPair = unreifiedRelationships.get(unreifiedRelationshipXRef)
  	    if (null !== unreifiedRelationshipPair) {
  	    	oml.unreifiedRelationship = unreifiedRelationshipPair.key
  	    	kv.remove("unreifiedRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	    val String domainXRef = kv.get("domainUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = conceptualEntitySingletonInstances.get(domainXRef)
  	    if (null !== domainPair) {
  	    	oml.domain = domainPair.key
  	    	kv.remove("domainUUID")
  	    	progress.set(0, true)
  	    }
  	    val String rangeXRef = kv.get("rangeUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = conceptualEntitySingletonInstances.get(rangeXRef)
  	    if (null !== rangePair) {
  	    	oml.range = rangePair.key
  	    	kv.remove("rangeUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveSingletonInstanceStructuredDataPropertyValues(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	singletonInstanceStructuredDataPropertyValues.forEach[uuid, oml_kv |
  	  val SingletonInstanceStructuredDataPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.get("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null !== descriptionBoxPair) {
  	    	oml.descriptionBox = descriptionBoxPair.key
  	    	kv.remove("descriptionBoxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String singletonInstanceXRef = kv.get("singletonInstanceUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = conceptualEntitySingletonInstances.get(singletonInstanceXRef)
  	    if (null !== singletonInstancePair) {
  	    	oml.singletonInstance = singletonInstancePair.key
  	    	kv.remove("singletonInstanceUUID")
  	    	progress.set(0, true)
  	    }
  	    val String structuredDataPropertyXRef = kv.get("structuredDataPropertyUUID")
  	    val Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = dataRelationshipToStructures.get(structuredDataPropertyXRef)
  	    if (null !== structuredDataPropertyPair) {
  	    	oml.structuredDataProperty = structuredDataPropertyPair.key
  	    	kv.remove("structuredDataPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveSingletonInstanceScalarDataPropertyValues(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	singletonInstanceScalarDataPropertyValues.forEach[uuid, oml_kv |
  	  val SingletonInstanceScalarDataPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.get("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null !== descriptionBoxPair) {
  	    	oml.descriptionBox = descriptionBoxPair.key
  	    	kv.remove("descriptionBoxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String singletonInstanceXRef = kv.get("singletonInstanceUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = conceptualEntitySingletonInstances.get(singletonInstanceXRef)
  	    if (null !== singletonInstancePair) {
  	    	oml.singletonInstance = singletonInstancePair.key
  	    	kv.remove("singletonInstanceUUID")
  	    	progress.set(0, true)
  	    }
  	    val String scalarDataPropertyXRef = kv.get("scalarDataPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> scalarDataPropertyPair = entityScalarDataProperties.get(scalarDataPropertyXRef)
  	    if (null !== scalarDataPropertyPair) {
  	    	oml.scalarDataProperty = scalarDataPropertyPair.key
  	    	kv.remove("scalarDataPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String valueTypeXRef = kv.get("valueTypeUUID")
  	    if (null !== valueTypeXRef && "null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null !== valueTypePair) {
  	      	oml.valueType = valueTypePair.key
  	      	kv.remove("valueTypeUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	  }
  	]
  }
  
  protected def void resolveStructuredDataPropertyTuples(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	structuredDataPropertyTuples.forEach[uuid, oml_kv |
  	  val StructuredDataPropertyTuple oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String structuredDataPropertyContextXRef = kv.get("structuredDataPropertyContextUUID")
  	    val Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef)
  	    if (null !== structuredDataPropertyContextPair) {
  	    	oml.structuredDataPropertyContext = structuredDataPropertyContextPair.key
  	    	kv.remove("structuredDataPropertyContextUUID")
  	    	progress.set(0, true)
  	    }
  	    val String structuredDataPropertyXRef = kv.get("structuredDataPropertyUUID")
  	    val Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = dataRelationshipToStructures.get(structuredDataPropertyXRef)
  	    if (null !== structuredDataPropertyPair) {
  	    	oml.structuredDataProperty = structuredDataPropertyPair.key
  	    	kv.remove("structuredDataPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveScalarDataPropertyValues(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	scalarDataPropertyValues.forEach[uuid, oml_kv |
  	  val ScalarDataPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String structuredDataPropertyContextXRef = kv.get("structuredDataPropertyContextUUID")
  	    val Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef)
  	    if (null !== structuredDataPropertyContextPair) {
  	    	oml.structuredDataPropertyContext = structuredDataPropertyContextPair.key
  	    	kv.remove("structuredDataPropertyContextUUID")
  	    	progress.set(0, true)
  	    }
  	    val String scalarDataPropertyXRef = kv.get("scalarDataPropertyUUID")
  	    val Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = dataRelationshipToScalars.get(scalarDataPropertyXRef)
  	    if (null !== scalarDataPropertyPair) {
  	    	oml.scalarDataProperty = scalarDataPropertyPair.key
  	    	kv.remove("scalarDataPropertyUUID")
  	    	progress.set(0, true)
  	    }
  	    val String valueTypeXRef = kv.get("valueTypeUUID")
  	    if (null !== valueTypeXRef && "null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null !== valueTypePair) {
  	      	oml.valueType = valueTypePair.key
  	      	kv.remove("valueTypeUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	  }
  	]
  }
  
  protected def void resolveAnnotationPropertyValues(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	annotationPropertyValues.forEach[uuid, oml_kv |
  	  val AnnotationPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String subjectXRef = kv.get("subjectUUID")
  	    val Pair<LogicalElement, Map<String, String>> subjectPair = logicalElements.get(subjectXRef)
  	    if (null !== subjectPair) {
  	    	oml.subject = subjectPair.key
  	    	kv.remove("subjectUUID")
  	    	progress.set(0, true)
  	    }
  	    val String propertyXRef = kv.get("propertyUUID")
  	    val Pair<AnnotationProperty, Map<String, String>> propertyPair = annotationProperties.get(propertyXRef)
  	    if (null !== propertyPair) {
  	    	oml.property = propertyPair.key
  	    	kv.remove("propertyUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveCardinalityRestrictedAspects(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	cardinalityRestrictedAspects.forEach[uuid, oml_kv |
  	  val CardinalityRestrictedAspect oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    if (null !== restrictedRangeXRef && "null" != restrictedRangeXRef) {
  	      val Pair<Entity, Map<String, String>> restrictedRangePair = entities.get(restrictedRangeXRef)
  	      if (null !== restrictedRangePair) {
  	      	oml.restrictedRange = restrictedRangePair.key
  	      	kv.remove("restrictedRangeUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID")
  	    val Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = restrictableRelationships.get(restrictedRelationshipXRef)
  	    if (null !== restrictedRelationshipPair) {
  	    	oml.restrictedRelationship = restrictedRelationshipPair.key
  	    	kv.remove("restrictedRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveCardinalityRestrictedConcepts(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	cardinalityRestrictedConcepts.forEach[uuid, oml_kv |
  	  val CardinalityRestrictedConcept oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    if (null !== restrictedRangeXRef && "null" != restrictedRangeXRef) {
  	      val Pair<Entity, Map<String, String>> restrictedRangePair = entities.get(restrictedRangeXRef)
  	      if (null !== restrictedRangePair) {
  	      	oml.restrictedRange = restrictedRangePair.key
  	      	kv.remove("restrictedRangeUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID")
  	    val Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = restrictableRelationships.get(restrictedRelationshipXRef)
  	    if (null !== restrictedRelationshipPair) {
  	    	oml.restrictedRelationship = restrictedRelationshipPair.key
  	    	kv.remove("restrictedRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def void resolveCardinalityRestrictedReifiedRelationships(ResourceSet rs, ArrayList<Boolean> progress, ArrayList<Boolean> allDone) {
  	
  	cardinalityRestrictedReifiedRelationships.forEach[uuid, oml_kv |
  	  val CardinalityRestrictedReifiedRelationship oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.get("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null !== tboxPair) {
  	    	oml.tbox = tboxPair.key
  	    	kv.remove("tboxUUID")
  	    	progress.set(0, true)
  	    }
  	    val String restrictedRangeXRef = kv.get("restrictedRangeUUID")
  	    if (null !== restrictedRangeXRef && "null" != restrictedRangeXRef) {
  	      val Pair<Entity, Map<String, String>> restrictedRangePair = entities.get(restrictedRangeXRef)
  	      if (null !== restrictedRangePair) {
  	      	oml.restrictedRange = restrictedRangePair.key
  	      	kv.remove("restrictedRangeUUID")
  	      	progress.set(0, true)
  	      }
  	    }
  	    val String restrictedRelationshipXRef = kv.get("restrictedRelationshipUUID")
  	    val Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = restrictableRelationships.get(restrictedRelationshipXRef)
  	    if (null !== restrictedRelationshipPair) {
  	    	oml.restrictedRelationship = restrictedRelationshipPair.key
  	    	kv.remove("restrictedRelationshipUUID")
  	    	progress.set(0, true)
  	    }
  	  }
  	]
  }
  
  protected def Resource loadOMLZipResource(ResourceSet rs, URI uri) {
  	val omlCatalog = OMLExtensions.getCatalog(rs)
  	if (null === omlCatalog)
  		throw new IllegalArgumentException("loadOMLZipResource: ResourceSet must have an OMLCatalog!")

	val uriString = uri.toString
  	val Resource r = if (uriString.startsWith("file:")) {
  		rs.getResource(uri, true)
  	} else if (uriString.startsWith("http:")) {
		val r0a = rs.getResource(uri, false)
		val r0b = rs.resources.findFirst[r| r.contents.exists[e|
			switch e {
				Extent:
					e.modules.exists[m|m.iri() == uriString]
				default:
					false
			}
		]]
		val r0 = r0a ?: r0b
		if (null !== r0) {
			r0
		} else {
			val r1 = omlCatalog.resolveURI(uriString + ".oml")
	  		val r2 = omlCatalog.resolveURI(uriString + ".omlzip")
	  		val r3 = omlCatalog.resolveURI(uriString)
	  				  		
	  		val f1 = if (null !== r1 && r1.startsWith("file:")) new File(r1.substring(5)) else null
	  		val f2 = if (null !== r2 && r2.startsWith("file:")) new File(r2.substring(5)) else null
	  		val f3 = if (null !== r3 && r3.startsWith("file:")) new File(r3.substring(5)) else null
	  		
	  		if (null !== f1 && f1.exists && f1.canRead)
	  			rs.getResource(URI.createURI(r1), true)
	  		else if (null !== f2 && f2.exists && f2.canRead)
	  			rs.getResource(URI.createURI(r2), true)
	  		else if (null !== f3 && f3.exists && f3.canRead)
	  			rs.getResource(URI.createURI(r3), true)
	  		else
	  			throw new IllegalArgumentException("loadOMLZipResource: "+uri+" not resolved!")
  		}
  	}
  	
  	switch r {
  		XtextResource:
  			r.contents.forEach[e|
  				switch e {
  					Extent: {
  						e.modules.forEach[queueModule]
					}
				}
			]
	}

  	r
  }

  def void includeModule(Module m) {
  	if (null !== m) {
  	  val iri = m.iri()
  	  val uuid = m.uuid()
  	  iri2module.put(iri, m)
      switch m {
    	    TerminologyGraph: {
    	  	  logicalElements.put(uuid, new Pair<LogicalElement, Map<String,String>>(m, Collections.emptyMap))
    	      terminologyGraphs.put(uuid, new Pair<TerminologyGraph, Map<String,String>>(m, Collections.emptyMap))
    	      terminologyBoxes.put(uuid, new Pair<TerminologyBox, Map<String,String>>(m, Collections.emptyMap))
    	      terminologyBoxes.put(iri, new Pair<TerminologyBox, Map<String,String>>(m, Collections.emptyMap))
    	    }
    	    Bundle: {
    	  	  logicalElements.put(uuid, new Pair<LogicalElement, Map<String,String>>(m, Collections.emptyMap))
    	      bundles.put(uuid, new Pair<Bundle, Map<String,String>>(m, Collections.emptyMap))
    	      terminologyBoxes.put(uuid, new Pair<TerminologyBox, Map<String,String>>(m, Collections.emptyMap))
    	      terminologyBoxes.put(iri, new Pair<TerminologyBox, Map<String,String>>(m, Collections.emptyMap))
    	    }
    	    DescriptionBox: {
    	  	  logicalElements.put(uuid, new Pair<LogicalElement, Map<String,String>>(m, Collections.emptyMap))
    	      descriptionBoxes.put(uuid, new Pair<DescriptionBox, Map<String,String>>(m, Collections.emptyMap))
    	      descriptionBoxes.put(iri, new Pair<DescriptionBox, Map<String,String>>(m, Collections.emptyMap))
    	    }
      }
  	
  	  modules.put(uuid, new Pair<Module, Map<String,String>>(m, Collections.emptyMap))
  	  m.eAllContents.forEach[e|
  	    switch e {
  	      AnnotationProperty: {
  	        val pair = new Pair<AnnotationProperty, Map<String,String>>(e, Collections.emptyMap)
  	        annotationProperties.put(e.uuid(), pair)
  	      }
  	      Aspect: {
  	        val pair = new Pair<Aspect, Map<String,String>>(e, Collections.emptyMap)
  	        aspects.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      Concept: {
  	        val pair = new Pair<Concept, Map<String,String>>(e, Collections.emptyMap)
  	        concepts.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      Scalar: {
  	        val pair = new Pair<Scalar, Map<String,String>>(e, Collections.emptyMap)
  	        scalars.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      Structure: {
  	        val pair = new Pair<Structure, Map<String,String>>(e, Collections.emptyMap)
  	        structures.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ConceptDesignationTerminologyAxiom: {
  	        val pair = new Pair<ConceptDesignationTerminologyAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        conceptDesignationTerminologyAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      TerminologyExtensionAxiom: {
  	        val pair = new Pair<TerminologyExtensionAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        terminologyExtensionAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      TerminologyNestingAxiom: {
  	        val pair = new Pair<TerminologyNestingAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        terminologyNestingAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      BundledTerminologyAxiom: {
  	        val pair = new Pair<BundledTerminologyAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        bundledTerminologyAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      DescriptionBoxExtendsClosedWorldDefinitions: {
  	        val pair = new Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String,String>>(e, Collections.emptyMap)
  	        descriptionBoxExtendsClosedWorldDefinitions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      DescriptionBoxRefinement: {
  	        val pair = new Pair<DescriptionBoxRefinement, Map<String,String>>(e, Collections.emptyMap)
  	        descriptionBoxRefinements.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      BinaryScalarRestriction: {
  	        val pair = new Pair<BinaryScalarRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        binaryScalarRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      IRIScalarRestriction: {
  	        val pair = new Pair<IRIScalarRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        iriScalarRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      NumericScalarRestriction: {
  	        val pair = new Pair<NumericScalarRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        numericScalarRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      PlainLiteralScalarRestriction: {
  	        val pair = new Pair<PlainLiteralScalarRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        plainLiteralScalarRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ScalarOneOfRestriction: {
  	        val pair = new Pair<ScalarOneOfRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        scalarOneOfRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ScalarOneOfLiteralAxiom: {
  	        val pair = new Pair<ScalarOneOfLiteralAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        scalarOneOfLiteralAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      StringScalarRestriction: {
  	        val pair = new Pair<StringScalarRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        stringScalarRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      SynonymScalarRestriction: {
  	        val pair = new Pair<SynonymScalarRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        synonymScalarRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      TimeScalarRestriction: {
  	        val pair = new Pair<TimeScalarRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        timeScalarRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      EntityScalarDataProperty: {
  	        val pair = new Pair<EntityScalarDataProperty, Map<String,String>>(e, Collections.emptyMap)
  	        entityScalarDataProperties.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      EntityStructuredDataProperty: {
  	        val pair = new Pair<EntityStructuredDataProperty, Map<String,String>>(e, Collections.emptyMap)
  	        entityStructuredDataProperties.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ScalarDataProperty: {
  	        val pair = new Pair<ScalarDataProperty, Map<String,String>>(e, Collections.emptyMap)
  	        scalarDataProperties.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      StructuredDataProperty: {
  	        val pair = new Pair<StructuredDataProperty, Map<String,String>>(e, Collections.emptyMap)
  	        structuredDataProperties.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ReifiedRelationship: {
  	        val pair = new Pair<ReifiedRelationship, Map<String,String>>(e, Collections.emptyMap)
  	        reifiedRelationships.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ReifiedRelationshipRestriction: {
  	        val pair = new Pair<ReifiedRelationshipRestriction, Map<String,String>>(e, Collections.emptyMap)
  	        reifiedRelationshipRestrictions.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ForwardProperty: {
  	        val pair = new Pair<ForwardProperty, Map<String,String>>(e, Collections.emptyMap)
  	        forwardProperties.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      InverseProperty: {
  	        val pair = new Pair<InverseProperty, Map<String,String>>(e, Collections.emptyMap)
  	        inverseProperties.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      UnreifiedRelationship: {
  	        val pair = new Pair<UnreifiedRelationship, Map<String,String>>(e, Collections.emptyMap)
  	        unreifiedRelationships.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ChainRule: {
  	        val pair = new Pair<ChainRule, Map<String,String>>(e, Collections.emptyMap)
  	        chainRules.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      RuleBodySegment: {
  	        val pair = new Pair<RuleBodySegment, Map<String,String>>(e, Collections.emptyMap)
  	        ruleBodySegments.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      SegmentPredicate: {
  	        val pair = new Pair<SegmentPredicate, Map<String,String>>(e, Collections.emptyMap)
  	        segmentPredicates.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      EntityExistentialRestrictionAxiom: {
  	        val pair = new Pair<EntityExistentialRestrictionAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        entityExistentialRestrictionAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      EntityUniversalRestrictionAxiom: {
  	        val pair = new Pair<EntityUniversalRestrictionAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        entityUniversalRestrictionAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      EntityScalarDataPropertyExistentialRestrictionAxiom: {
  	        val pair = new Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        entityScalarDataPropertyExistentialRestrictionAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      EntityScalarDataPropertyParticularRestrictionAxiom: {
  	        val pair = new Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        entityScalarDataPropertyParticularRestrictionAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      EntityScalarDataPropertyUniversalRestrictionAxiom: {
  	        val pair = new Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        entityScalarDataPropertyUniversalRestrictionAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      EntityStructuredDataPropertyParticularRestrictionAxiom: {
  	        val pair = new Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        entityStructuredDataPropertyParticularRestrictionAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      RestrictionStructuredDataPropertyTuple: {
  	        val pair = new Pair<RestrictionStructuredDataPropertyTuple, Map<String,String>>(e, Collections.emptyMap)
  	        restrictionStructuredDataPropertyTuples.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      RestrictionScalarDataPropertyValue: {
  	        val pair = new Pair<RestrictionScalarDataPropertyValue, Map<String,String>>(e, Collections.emptyMap)
  	        restrictionScalarDataPropertyValues.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      AspectSpecializationAxiom: {
  	        val pair = new Pair<AspectSpecializationAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        aspectSpecializationAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ConceptSpecializationAxiom: {
  	        val pair = new Pair<ConceptSpecializationAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        conceptSpecializationAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ReifiedRelationshipSpecializationAxiom: {
  	        val pair = new Pair<ReifiedRelationshipSpecializationAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        reifiedRelationshipSpecializationAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      SubDataPropertyOfAxiom: {
  	        val pair = new Pair<SubDataPropertyOfAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        subDataPropertyOfAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      SubObjectPropertyOfAxiom: {
  	        val pair = new Pair<SubObjectPropertyOfAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        subObjectPropertyOfAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      RootConceptTaxonomyAxiom: {
  	        val pair = new Pair<RootConceptTaxonomyAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        rootConceptTaxonomyAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      AnonymousConceptUnionAxiom: {
  	        val pair = new Pair<AnonymousConceptUnionAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        anonymousConceptUnionAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      SpecificDisjointConceptAxiom: {
  	        val pair = new Pair<SpecificDisjointConceptAxiom, Map<String,String>>(e, Collections.emptyMap)
  	        specificDisjointConceptAxioms.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ConceptInstance: {
  	        val pair = new Pair<ConceptInstance, Map<String,String>>(e, Collections.emptyMap)
  	        conceptInstances.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ReifiedRelationshipInstance: {
  	        val pair = new Pair<ReifiedRelationshipInstance, Map<String,String>>(e, Collections.emptyMap)
  	        reifiedRelationshipInstances.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ReifiedRelationshipInstanceDomain: {
  	        val pair = new Pair<ReifiedRelationshipInstanceDomain, Map<String,String>>(e, Collections.emptyMap)
  	        reifiedRelationshipInstanceDomains.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ReifiedRelationshipInstanceRange: {
  	        val pair = new Pair<ReifiedRelationshipInstanceRange, Map<String,String>>(e, Collections.emptyMap)
  	        reifiedRelationshipInstanceRanges.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      UnreifiedRelationshipInstanceTuple: {
  	        val pair = new Pair<UnreifiedRelationshipInstanceTuple, Map<String,String>>(e, Collections.emptyMap)
  	        unreifiedRelationshipInstanceTuples.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      SingletonInstanceStructuredDataPropertyValue: {
  	        val pair = new Pair<SingletonInstanceStructuredDataPropertyValue, Map<String,String>>(e, Collections.emptyMap)
  	        singletonInstanceStructuredDataPropertyValues.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      SingletonInstanceScalarDataPropertyValue: {
  	        val pair = new Pair<SingletonInstanceScalarDataPropertyValue, Map<String,String>>(e, Collections.emptyMap)
  	        singletonInstanceScalarDataPropertyValues.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      StructuredDataPropertyTuple: {
  	        val pair = new Pair<StructuredDataPropertyTuple, Map<String,String>>(e, Collections.emptyMap)
  	        structuredDataPropertyTuples.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      ScalarDataPropertyValue: {
  	        val pair = new Pair<ScalarDataPropertyValue, Map<String,String>>(e, Collections.emptyMap)
  	        scalarDataPropertyValues.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      AnnotationPropertyValue: {
  	        val pair = new Pair<AnnotationPropertyValue, Map<String,String>>(e, Collections.emptyMap)
  	        annotationPropertyValues.put(e.uuid(), pair)
  	      }
  	      CardinalityRestrictedAspect: {
  	        val pair = new Pair<CardinalityRestrictedAspect, Map<String,String>>(e, Collections.emptyMap)
  	        cardinalityRestrictedAspects.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      CardinalityRestrictedConcept: {
  	        val pair = new Pair<CardinalityRestrictedConcept, Map<String,String>>(e, Collections.emptyMap)
  	        cardinalityRestrictedConcepts.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	      CardinalityRestrictedReifiedRelationship: {
  	        val pair = new Pair<CardinalityRestrictedReifiedRelationship, Map<String,String>>(e, Collections.emptyMap)
  	        cardinalityRestrictedReifiedRelationships.put(e.uuid(), pair)
  	        logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	      }
  	    }
  	  ]
    }
  }
}
