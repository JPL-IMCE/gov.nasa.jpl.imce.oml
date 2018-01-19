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
import java.util.Map
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream
import org.apache.commons.compress.archivers.zip.ZipFile
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
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
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
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

  protected val Map<String, Pair<Module, Map<String,String>>> modules
  protected val Map<String, Pair<LogicalElement, Map<String,String>>> logicalElements
  protected val Map<String, Pair<Entity, Map<String,String>>> entities
  protected val Map<String, Pair<EntityRelationship, Map<String,String>>> entityRelationships
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
  
  new() {
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
  
    modules = new HashMap<String, Pair<Module, Map<String,String>>>()
    	logicalElements = new HashMap<String, Pair<LogicalElement, Map<String,String>>>()
    entities = new HashMap<String, Pair<Entity, Map<String,String>>>()
    entityRelationships = new HashMap<String, Pair<EntityRelationship, Map<String,String>>>()
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
    zos.putArchiveEntry(entry)
    try {
      zos.write(terminologyGraphsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Bundle
    entry = new ZipArchiveEntry("Bundles.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(bundlesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // DescriptionBox
    entry = new ZipArchiveEntry("DescriptionBoxes.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(descriptionBoxesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // AnnotationProperty
    entry = new ZipArchiveEntry("AnnotationProperties.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(annotationPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Aspect
    entry = new ZipArchiveEntry("Aspects.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(aspectsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Concept
    entry = new ZipArchiveEntry("Concepts.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(conceptsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Scalar
    entry = new ZipArchiveEntry("Scalars.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // Structure
    entry = new ZipArchiveEntry("Structures.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(structuresByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ConceptDesignationTerminologyAxiom
    entry = new ZipArchiveEntry("ConceptDesignationTerminologyAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(conceptDesignationTerminologyAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // TerminologyExtensionAxiom
    entry = new ZipArchiveEntry("TerminologyExtensionAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(terminologyExtensionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // TerminologyNestingAxiom
    entry = new ZipArchiveEntry("TerminologyNestingAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(terminologyNestingAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // BundledTerminologyAxiom
    entry = new ZipArchiveEntry("BundledTerminologyAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(bundledTerminologyAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // DescriptionBoxExtendsClosedWorldDefinitions
    entry = new ZipArchiveEntry("DescriptionBoxExtendsClosedWorldDefinitions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(descriptionBoxExtendsClosedWorldDefinitionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // DescriptionBoxRefinement
    entry = new ZipArchiveEntry("DescriptionBoxRefinements.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(descriptionBoxRefinementsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // BinaryScalarRestriction
    entry = new ZipArchiveEntry("BinaryScalarRestrictions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(binaryScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // IRIScalarRestriction
    entry = new ZipArchiveEntry("IRIScalarRestrictions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(iriScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // NumericScalarRestriction
    entry = new ZipArchiveEntry("NumericScalarRestrictions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(numericScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // PlainLiteralScalarRestriction
    entry = new ZipArchiveEntry("PlainLiteralScalarRestrictions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(plainLiteralScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ScalarOneOfRestriction
    entry = new ZipArchiveEntry("ScalarOneOfRestrictions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarOneOfRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ScalarOneOfLiteralAxiom
    entry = new ZipArchiveEntry("ScalarOneOfLiteralAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarOneOfLiteralAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // StringScalarRestriction
    entry = new ZipArchiveEntry("StringScalarRestrictions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(stringScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SynonymScalarRestriction
    entry = new ZipArchiveEntry("SynonymScalarRestrictions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(synonymScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // TimeScalarRestriction
    entry = new ZipArchiveEntry("TimeScalarRestrictions.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(timeScalarRestrictionsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityScalarDataProperty
    entry = new ZipArchiveEntry("EntityScalarDataProperties.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityScalarDataPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityStructuredDataProperty
    entry = new ZipArchiveEntry("EntityStructuredDataProperties.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityStructuredDataPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ScalarDataProperty
    entry = new ZipArchiveEntry("ScalarDataProperties.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarDataPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // StructuredDataProperty
    entry = new ZipArchiveEntry("StructuredDataProperties.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(structuredDataPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationship
    entry = new ZipArchiveEntry("ReifiedRelationships.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ForwardProperty
    entry = new ZipArchiveEntry("ForwardProperties.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(forwardPropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // InverseProperty
    entry = new ZipArchiveEntry("InverseProperties.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(inversePropertiesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // UnreifiedRelationship
    entry = new ZipArchiveEntry("UnreifiedRelationships.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(unreifiedRelationshipsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ChainRule
    entry = new ZipArchiveEntry("ChainRules.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(chainRulesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // RuleBodySegment
    entry = new ZipArchiveEntry("RuleBodySegments.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(ruleBodySegmentsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SegmentPredicate
    entry = new ZipArchiveEntry("SegmentPredicates.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(segmentPredicatesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityExistentialRestrictionAxiom
    entry = new ZipArchiveEntry("EntityExistentialRestrictionAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityExistentialRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityUniversalRestrictionAxiom
    entry = new ZipArchiveEntry("EntityUniversalRestrictionAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityUniversalRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityScalarDataPropertyExistentialRestrictionAxiom
    entry = new ZipArchiveEntry("EntityScalarDataPropertyExistentialRestrictionAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityScalarDataPropertyExistentialRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityScalarDataPropertyParticularRestrictionAxiom
    entry = new ZipArchiveEntry("EntityScalarDataPropertyParticularRestrictionAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityScalarDataPropertyParticularRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityScalarDataPropertyUniversalRestrictionAxiom
    entry = new ZipArchiveEntry("EntityScalarDataPropertyUniversalRestrictionAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityScalarDataPropertyUniversalRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // EntityStructuredDataPropertyParticularRestrictionAxiom
    entry = new ZipArchiveEntry("EntityStructuredDataPropertyParticularRestrictionAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(entityStructuredDataPropertyParticularRestrictionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // RestrictionStructuredDataPropertyTuple
    entry = new ZipArchiveEntry("RestrictionStructuredDataPropertyTuples.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(restrictionStructuredDataPropertyTuplesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // RestrictionScalarDataPropertyValue
    entry = new ZipArchiveEntry("RestrictionScalarDataPropertyValues.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(restrictionScalarDataPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // AspectSpecializationAxiom
    entry = new ZipArchiveEntry("AspectSpecializationAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(aspectSpecializationAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ConceptSpecializationAxiom
    entry = new ZipArchiveEntry("ConceptSpecializationAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(conceptSpecializationAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipSpecializationAxiom
    entry = new ZipArchiveEntry("ReifiedRelationshipSpecializationAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipSpecializationAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SubDataPropertyOfAxiom
    entry = new ZipArchiveEntry("SubDataPropertyOfAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(subDataPropertyOfAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SubObjectPropertyOfAxiom
    entry = new ZipArchiveEntry("SubObjectPropertyOfAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(subObjectPropertyOfAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // RootConceptTaxonomyAxiom
    entry = new ZipArchiveEntry("RootConceptTaxonomyAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(rootConceptTaxonomyAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // AnonymousConceptUnionAxiom
    entry = new ZipArchiveEntry("AnonymousConceptUnionAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(anonymousConceptUnionAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SpecificDisjointConceptAxiom
    entry = new ZipArchiveEntry("SpecificDisjointConceptAxioms.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(specificDisjointConceptAxiomsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ConceptInstance
    entry = new ZipArchiveEntry("ConceptInstances.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(conceptInstancesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipInstance
    entry = new ZipArchiveEntry("ReifiedRelationshipInstances.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipInstancesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipInstanceDomain
    entry = new ZipArchiveEntry("ReifiedRelationshipInstanceDomains.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipInstanceDomainsByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ReifiedRelationshipInstanceRange
    entry = new ZipArchiveEntry("ReifiedRelationshipInstanceRanges.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(reifiedRelationshipInstanceRangesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // UnreifiedRelationshipInstanceTuple
    entry = new ZipArchiveEntry("UnreifiedRelationshipInstanceTuples.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(unreifiedRelationshipInstanceTuplesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SingletonInstanceStructuredDataPropertyValue
    entry = new ZipArchiveEntry("SingletonInstanceStructuredDataPropertyValues.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(singletonInstanceStructuredDataPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // SingletonInstanceScalarDataPropertyValue
    entry = new ZipArchiveEntry("SingletonInstanceScalarDataPropertyValues.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(singletonInstanceScalarDataPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // StructuredDataPropertyTuple
    entry = new ZipArchiveEntry("StructuredDataPropertyTuples.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(structuredDataPropertyTuplesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // ScalarDataPropertyValue
    entry = new ZipArchiveEntry("ScalarDataPropertyValues.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(scalarDataPropertyValuesByteArray(e))
    } finally {
      zos.closeArchiveEntry()
    }
    // AnnotationPropertyValue
    entry = new ZipArchiveEntry("AnnotationPropertyValues.json")
    zos.putArchiveEntry(entry)
    try {
      zos.write(annotationPropertyValuesByteArray(e))
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
      pw.print(OMLTables.toString(it.isIdentityCriteria))
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
      pw.print(OMLTables.toString(it.isIdentityCriteria))
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
      pw.print(OMLTables.toString(it.isAsymmetric))
      pw.print(",")
      pw.print("\"isEssential\":")
      pw.print(OMLTables.toString(it.isEssential))
      pw.print(",")
      pw.print("\"isFunctional\":")
      pw.print(OMLTables.toString(it.isFunctional))
      pw.print(",")
      pw.print("\"isInverseEssential\":")
      pw.print(OMLTables.toString(it.isInverseEssential))
      pw.print(",")
      pw.print("\"isInverseFunctional\":")
      pw.print(OMLTables.toString(it.isInverseFunctional))
      pw.print(",")
      pw.print("\"isIrreflexive\":")
      pw.print(OMLTables.toString(it.isIrreflexive))
      pw.print(",")
      pw.print("\"isReflexive\":")
      pw.print(OMLTables.toString(it.isReflexive))
      pw.print(",")
      pw.print("\"isSymmetric\":")
      pw.print(OMLTables.toString(it.isSymmetric))
      pw.print(",")
      pw.print("\"isTransitive\":")
      pw.print(OMLTables.toString(it.isTransitive))
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
      pw.print(OMLTables.toString(it.isAsymmetric))
      pw.print(",")
      pw.print("\"isEssential\":")
      pw.print(OMLTables.toString(it.isEssential))
      pw.print(",")
      pw.print("\"isFunctional\":")
      pw.print(OMLTables.toString(it.isFunctional))
      pw.print(",")
      pw.print("\"isInverseEssential\":")
      pw.print(OMLTables.toString(it.isInverseEssential))
      pw.print(",")
      pw.print("\"isInverseFunctional\":")
      pw.print(OMLTables.toString(it.isInverseFunctional))
      pw.print(",")
      pw.print("\"isIrreflexive\":")
      pw.print(OMLTables.toString(it.isIrreflexive))
      pw.print(",")
      pw.print("\"isReflexive\":")
      pw.print(OMLTables.toString(it.isReflexive))
      pw.print(",")
      pw.print("\"isSymmetric\":")
      pw.print(OMLTables.toString(it.isSymmetric))
      pw.print(",")
      pw.print("\"isTransitive\":")
      pw.print(OMLTables.toString(it.isTransitive))
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
      pw.print("\"singletonReifiedRelationshipClassifierUUID\":")
      pw.print("\"")
      pw.print(it.singletonReifiedRelationshipClassifier.uuid())
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
  
  		    	    
  static def void load(ResourceSet rs, OMLZipResource r, File omlZipFile) {

    val tables = new OMLSpecificationTables()
    
    val zip = new ZipFile(omlZipFile)
  	Collections.list(zip.entries).forEach[ze | 
      val is = zip.getInputStream(ze)
      val buffer = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
      val lines = new ArrayList<String>()
      lines.addAll(buffer.lines().iterator.toIterable)
      switch ze.name {
  	    case "TerminologyGraphs.json":
  	      tables.readTerminologyGraphs(lines)
  	    case "Bundles.json":
  	      tables.readBundles(lines)
  	    case "DescriptionBoxes.json":
  	      tables.readDescriptionBoxes(lines)
  	    case "AnnotationProperties.json":
  	      tables.readAnnotationProperties(lines)
  	    case "Aspects.json":
  	      tables.readAspects(lines)
  	    case "Concepts.json":
  	      tables.readConcepts(lines)
  	    case "Scalars.json":
  	      tables.readScalars(lines)
  	    case "Structures.json":
  	      tables.readStructures(lines)
  	    case "ConceptDesignationTerminologyAxioms.json":
  	      tables.readConceptDesignationTerminologyAxioms(lines)
  	    case "TerminologyExtensionAxioms.json":
  	      tables.readTerminologyExtensionAxioms(lines)
  	    case "TerminologyNestingAxioms.json":
  	      tables.readTerminologyNestingAxioms(lines)
  	    case "BundledTerminologyAxioms.json":
  	      tables.readBundledTerminologyAxioms(lines)
  	    case "DescriptionBoxExtendsClosedWorldDefinitions.json":
  	      tables.readDescriptionBoxExtendsClosedWorldDefinitions(lines)
  	    case "DescriptionBoxRefinements.json":
  	      tables.readDescriptionBoxRefinements(lines)
  	    case "BinaryScalarRestrictions.json":
  	      tables.readBinaryScalarRestrictions(lines)
  	    case "IRIScalarRestrictions.json":
  	      tables.readIRIScalarRestrictions(lines)
  	    case "NumericScalarRestrictions.json":
  	      tables.readNumericScalarRestrictions(lines)
  	    case "PlainLiteralScalarRestrictions.json":
  	      tables.readPlainLiteralScalarRestrictions(lines)
  	    case "ScalarOneOfRestrictions.json":
  	      tables.readScalarOneOfRestrictions(lines)
  	    case "ScalarOneOfLiteralAxioms.json":
  	      tables.readScalarOneOfLiteralAxioms(lines)
  	    case "StringScalarRestrictions.json":
  	      tables.readStringScalarRestrictions(lines)
  	    case "SynonymScalarRestrictions.json":
  	      tables.readSynonymScalarRestrictions(lines)
  	    case "TimeScalarRestrictions.json":
  	      tables.readTimeScalarRestrictions(lines)
  	    case "EntityScalarDataProperties.json":
  	      tables.readEntityScalarDataProperties(lines)
  	    case "EntityStructuredDataProperties.json":
  	      tables.readEntityStructuredDataProperties(lines)
  	    case "ScalarDataProperties.json":
  	      tables.readScalarDataProperties(lines)
  	    case "StructuredDataProperties.json":
  	      tables.readStructuredDataProperties(lines)
  	    case "ReifiedRelationships.json":
  	      tables.readReifiedRelationships(lines)
  	    case "ForwardProperties.json":
  	      tables.readForwardProperties(lines)
  	    case "InverseProperties.json":
  	      tables.readInverseProperties(lines)
  	    case "UnreifiedRelationships.json":
  	      tables.readUnreifiedRelationships(lines)
  	    case "ChainRules.json":
  	      tables.readChainRules(lines)
  	    case "RuleBodySegments.json":
  	      tables.readRuleBodySegments(lines)
  	    case "SegmentPredicates.json":
  	      tables.readSegmentPredicates(lines)
  	    case "EntityExistentialRestrictionAxioms.json":
  	      tables.readEntityExistentialRestrictionAxioms(lines)
  	    case "EntityUniversalRestrictionAxioms.json":
  	      tables.readEntityUniversalRestrictionAxioms(lines)
  	    case "EntityScalarDataPropertyExistentialRestrictionAxioms.json":
  	      tables.readEntityScalarDataPropertyExistentialRestrictionAxioms(lines)
  	    case "EntityScalarDataPropertyParticularRestrictionAxioms.json":
  	      tables.readEntityScalarDataPropertyParticularRestrictionAxioms(lines)
  	    case "EntityScalarDataPropertyUniversalRestrictionAxioms.json":
  	      tables.readEntityScalarDataPropertyUniversalRestrictionAxioms(lines)
  	    case "EntityStructuredDataPropertyParticularRestrictionAxioms.json":
  	      tables.readEntityStructuredDataPropertyParticularRestrictionAxioms(lines)
  	    case "RestrictionStructuredDataPropertyTuples.json":
  	      tables.readRestrictionStructuredDataPropertyTuples(lines)
  	    case "RestrictionScalarDataPropertyValues.json":
  	      tables.readRestrictionScalarDataPropertyValues(lines)
  	    case "AspectSpecializationAxioms.json":
  	      tables.readAspectSpecializationAxioms(lines)
  	    case "ConceptSpecializationAxioms.json":
  	      tables.readConceptSpecializationAxioms(lines)
  	    case "ReifiedRelationshipSpecializationAxioms.json":
  	      tables.readReifiedRelationshipSpecializationAxioms(lines)
  	    case "SubDataPropertyOfAxioms.json":
  	      tables.readSubDataPropertyOfAxioms(lines)
  	    case "SubObjectPropertyOfAxioms.json":
  	      tables.readSubObjectPropertyOfAxioms(lines)
  	    case "RootConceptTaxonomyAxioms.json":
  	      tables.readRootConceptTaxonomyAxioms(lines)
  	    case "AnonymousConceptUnionAxioms.json":
  	      tables.readAnonymousConceptUnionAxioms(lines)
  	    case "SpecificDisjointConceptAxioms.json":
  	      tables.readSpecificDisjointConceptAxioms(lines)
  	    case "ConceptInstances.json":
  	      tables.readConceptInstances(lines)
  	    case "ReifiedRelationshipInstances.json":
  	      tables.readReifiedRelationshipInstances(lines)
  	    case "ReifiedRelationshipInstanceDomains.json":
  	      tables.readReifiedRelationshipInstanceDomains(lines)
  	    case "ReifiedRelationshipInstanceRanges.json":
  	      tables.readReifiedRelationshipInstanceRanges(lines)
  	    case "UnreifiedRelationshipInstanceTuples.json":
  	      tables.readUnreifiedRelationshipInstanceTuples(lines)
  	    case "SingletonInstanceStructuredDataPropertyValues.json":
  	      tables.readSingletonInstanceStructuredDataPropertyValues(lines)
  	    case "SingletonInstanceScalarDataPropertyValues.json":
  	      tables.readSingletonInstanceScalarDataPropertyValues(lines)
  	    case "StructuredDataPropertyTuples.json":
  	      tables.readStructuredDataPropertyTuples(lines)
  	    case "ScalarDataPropertyValues.json":
  	      tables.readScalarDataPropertyValues(lines)
  	    case "AnnotationPropertyValues.json":
  	      tables.readAnnotationPropertyValues(lines)
        default:
          throw new IllegalArgumentException("OMLSpecificationTables.load(): unrecognized table name: "+ze.name)
      }
    ]
    tables.resolve(rs, r)
  }

  protected def void readTerminologyGraphs(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createTerminologyGraph()
  	  val uuid = kv.remove("uuid")
  	  oml.kind = OMLTables.toTerminologyKind(kv.remove("kind"))
  	  oml.iri = OMLTables.toIRI(kv.remove("iri"))
  	  val pair = new Pair<TerminologyGraph, Map<String,String>>(oml, kv)
  	  terminologyGraphs.put(uuid, pair)
  	]
  }
  
  protected def void readBundles(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createBundle()
  	  val uuid = kv.remove("uuid")
  	  oml.kind = OMLTables.toTerminologyKind(kv.remove("kind"))
  	  oml.iri = OMLTables.toIRI(kv.remove("iri"))
  	  val pair = new Pair<Bundle, Map<String,String>>(oml, kv)
  	  bundles.put(uuid, pair)
  	]
  }
  
  protected def void readDescriptionBoxes(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createDescriptionBox()
  	  val uuid = kv.remove("uuid")
  	  oml.kind = OMLTables.toDescriptionKind(kv.remove("kind"))
  	  oml.iri = OMLTables.toIRI(kv.remove("iri"))
  	  val pair = new Pair<DescriptionBox, Map<String,String>>(oml, kv)
  	  descriptionBoxes.put(uuid, pair)
  	]
  }
  
  protected def void readAnnotationProperties(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createAnnotationProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.iri = OMLTables.toIRI(kv.remove("iri"))
  	  oml.abbrevIRI = OMLTables.toAbbrevIRI(kv.remove("abbrevIRI"))
  	  val pair = new Pair<AnnotationProperty, Map<String,String>>(oml, kv)
  	  annotationProperties.put(uuid, pair)
  	]
  }
  
  protected def void readAspects(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createAspect()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<Aspect, Map<String,String>>(oml, kv)
  	  aspects.put(uuid, pair)
  	]
  }
  
  protected def void readConcepts(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createConcept()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<Concept, Map<String,String>>(oml, kv)
  	  concepts.put(uuid, pair)
  	]
  }
  
  protected def void readScalars(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createScalar()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<Scalar, Map<String,String>>(oml, kv)
  	  scalars.put(uuid, pair)
  	]
  }
  
  protected def void readStructures(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createStructure()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<Structure, Map<String,String>>(oml, kv)
  	  structures.put(uuid, pair)
  	]
  }
  
  protected def void readConceptDesignationTerminologyAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createConceptDesignationTerminologyAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ConceptDesignationTerminologyAxiom, Map<String,String>>(oml, kv)
  	  conceptDesignationTerminologyAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readTerminologyExtensionAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createTerminologyExtensionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<TerminologyExtensionAxiom, Map<String,String>>(oml, kv)
  	  terminologyExtensionAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readTerminologyNestingAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createTerminologyNestingAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<TerminologyNestingAxiom, Map<String,String>>(oml, kv)
  	  terminologyNestingAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readBundledTerminologyAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createBundledTerminologyAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<BundledTerminologyAxiom, Map<String,String>>(oml, kv)
  	  bundledTerminologyAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readDescriptionBoxExtendsClosedWorldDefinitions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createDescriptionBoxExtendsClosedWorldDefinitions()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<DescriptionBoxExtendsClosedWorldDefinitions, Map<String,String>>(oml, kv)
  	  descriptionBoxExtendsClosedWorldDefinitions.put(uuid, pair)
  	]
  }
  
  protected def void readDescriptionBoxRefinements(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createDescriptionBoxRefinement()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<DescriptionBoxRefinement, Map<String,String>>(oml, kv)
  	  descriptionBoxRefinements.put(uuid, pair)
  	]
  }
  
  protected def void readBinaryScalarRestrictions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createBinaryScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.length = OMLTables.toPositiveIntegerLiteral(kv.remove("length"))
  	  oml.minLength = OMLTables.toPositiveIntegerLiteral(kv.remove("minLength"))
  	  oml.maxLength = OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<BinaryScalarRestriction, Map<String,String>>(oml, kv)
  	  binaryScalarRestrictions.put(uuid, pair)
  	]
  }
  
  protected def void readIRIScalarRestrictions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createIRIScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.length = OMLTables.toPositiveIntegerLiteral(kv.remove("length"))
  	  oml.minLength = OMLTables.toPositiveIntegerLiteral(kv.remove("minLength"))
  	  oml.maxLength = OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  oml.pattern = OMLTables.toLiteralPattern(kv.remove("pattern"))
  	  val pair = new Pair<IRIScalarRestriction, Map<String,String>>(oml, kv)
  	  iriScalarRestrictions.put(uuid, pair)
  	]
  }
  
  protected def void readNumericScalarRestrictions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createNumericScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.minExclusive = OMLTables.toLiteralNumber(kv.remove("minExclusive"))
  	  oml.minInclusive = OMLTables.toLiteralNumber(kv.remove("minInclusive"))
  	  oml.maxExclusive = OMLTables.toLiteralNumber(kv.remove("maxExclusive"))
  	  oml.maxInclusive = OMLTables.toLiteralNumber(kv.remove("maxInclusive"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<NumericScalarRestriction, Map<String,String>>(oml, kv)
  	  numericScalarRestrictions.put(uuid, pair)
  	]
  }
  
  protected def void readPlainLiteralScalarRestrictions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createPlainLiteralScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.length = OMLTables.toPositiveIntegerLiteral(kv.remove("length"))
  	  oml.minLength = OMLTables.toPositiveIntegerLiteral(kv.remove("minLength"))
  	  oml.maxLength = OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  oml.langRange = OMLTables.toLanguageTagDataType(kv.remove("langRange"))
  	  oml.pattern = OMLTables.toLiteralPattern(kv.remove("pattern"))
  	  val pair = new Pair<PlainLiteralScalarRestriction, Map<String,String>>(oml, kv)
  	  plainLiteralScalarRestrictions.put(uuid, pair)
  	]
  }
  
  protected def void readScalarOneOfRestrictions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createScalarOneOfRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ScalarOneOfRestriction, Map<String,String>>(oml, kv)
  	  scalarOneOfRestrictions.put(uuid, pair)
  	]
  }
  
  protected def void readScalarOneOfLiteralAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createScalarOneOfLiteralAxiom()
  	  val uuid = kv.remove("uuid")
  	  oml.value = OMLTables.toLiteralValue(kv.remove("value"))
  	  val pair = new Pair<ScalarOneOfLiteralAxiom, Map<String,String>>(oml, kv)
  	  scalarOneOfLiteralAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readStringScalarRestrictions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createStringScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.length = OMLTables.toPositiveIntegerLiteral(kv.remove("length"))
  	  oml.minLength = OMLTables.toPositiveIntegerLiteral(kv.remove("minLength"))
  	  oml.maxLength = OMLTables.toPositiveIntegerLiteral(kv.remove("maxLength"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  oml.pattern = OMLTables.toLiteralPattern(kv.remove("pattern"))
  	  val pair = new Pair<StringScalarRestriction, Map<String,String>>(oml, kv)
  	  stringScalarRestrictions.put(uuid, pair)
  	]
  }
  
  protected def void readSynonymScalarRestrictions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createSynonymScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<SynonymScalarRestriction, Map<String,String>>(oml, kv)
  	  synonymScalarRestrictions.put(uuid, pair)
  	]
  }
  
  protected def void readTimeScalarRestrictions(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createTimeScalarRestriction()
  	  val uuid = kv.remove("uuid")
  	  oml.minExclusive = OMLTables.toLiteralDateTime(kv.remove("minExclusive"))
  	  oml.minInclusive = OMLTables.toLiteralDateTime(kv.remove("minInclusive"))
  	  oml.maxExclusive = OMLTables.toLiteralDateTime(kv.remove("maxExclusive"))
  	  oml.maxInclusive = OMLTables.toLiteralDateTime(kv.remove("maxInclusive"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<TimeScalarRestriction, Map<String,String>>(oml, kv)
  	  timeScalarRestrictions.put(uuid, pair)
  	]
  }
  
  protected def void readEntityScalarDataProperties(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createEntityScalarDataProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.isIdentityCriteria = OMLTables.toEBoolean(kv.remove("isIdentityCriteria"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<EntityScalarDataProperty, Map<String,String>>(oml, kv)
  	  entityScalarDataProperties.put(uuid, pair)
  	]
  }
  
  protected def void readEntityStructuredDataProperties(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createEntityStructuredDataProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.isIdentityCriteria = OMLTables.toEBoolean(kv.remove("isIdentityCriteria"))
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<EntityStructuredDataProperty, Map<String,String>>(oml, kv)
  	  entityStructuredDataProperties.put(uuid, pair)
  	]
  }
  
  protected def void readScalarDataProperties(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createScalarDataProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ScalarDataProperty, Map<String,String>>(oml, kv)
  	  scalarDataProperties.put(uuid, pair)
  	]
  }
  
  protected def void readStructuredDataProperties(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createStructuredDataProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<StructuredDataProperty, Map<String,String>>(oml, kv)
  	  structuredDataProperties.put(uuid, pair)
  	]
  }
  
  protected def void readReifiedRelationships(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
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
  	]
  }
  
  protected def void readForwardProperties(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createForwardProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ForwardProperty, Map<String,String>>(oml, kv)
  	  forwardProperties.put(uuid, pair)
  	]
  }
  
  protected def void readInverseProperties(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createInverseProperty()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<InverseProperty, Map<String,String>>(oml, kv)
  	  inverseProperties.put(uuid, pair)
  	]
  }
  
  protected def void readUnreifiedRelationships(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
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
  	]
  }
  
  protected def void readChainRules(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createChainRule()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ChainRule, Map<String,String>>(oml, kv)
  	  chainRules.put(uuid, pair)
  	]
  }
  
  protected def void readRuleBodySegments(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createRuleBodySegment()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<RuleBodySegment, Map<String,String>>(oml, kv)
  	  ruleBodySegments.put(uuid, pair)
  	]
  }
  
  protected def void readSegmentPredicates(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createSegmentPredicate()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SegmentPredicate, Map<String,String>>(oml, kv)
  	  segmentPredicates.put(uuid, pair)
  	]
  }
  
  protected def void readEntityExistentialRestrictionAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createEntityExistentialRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityExistentialRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityExistentialRestrictionAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readEntityUniversalRestrictionAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createEntityUniversalRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityUniversalRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityUniversalRestrictionAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readEntityScalarDataPropertyExistentialRestrictionAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createEntityScalarDataPropertyExistentialRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityScalarDataPropertyExistentialRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityScalarDataPropertyExistentialRestrictionAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readEntityScalarDataPropertyParticularRestrictionAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createEntityScalarDataPropertyParticularRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  oml.literalValue = OMLTables.toLiteralValue(kv.remove("literalValue"))
  	  val pair = new Pair<EntityScalarDataPropertyParticularRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityScalarDataPropertyParticularRestrictionAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readEntityScalarDataPropertyUniversalRestrictionAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createEntityScalarDataPropertyUniversalRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityScalarDataPropertyUniversalRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityScalarDataPropertyUniversalRestrictionAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readEntityStructuredDataPropertyParticularRestrictionAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createEntityStructuredDataPropertyParticularRestrictionAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<EntityStructuredDataPropertyParticularRestrictionAxiom, Map<String,String>>(oml, kv)
  	  entityStructuredDataPropertyParticularRestrictionAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readRestrictionStructuredDataPropertyTuples(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createRestrictionStructuredDataPropertyTuple()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<RestrictionStructuredDataPropertyTuple, Map<String,String>>(oml, kv)
  	  restrictionStructuredDataPropertyTuples.put(uuid, pair)
  	]
  }
  
  protected def void readRestrictionScalarDataPropertyValues(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createRestrictionScalarDataPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  oml.scalarPropertyValue = OMLTables.toLiteralValue(kv.remove("scalarPropertyValue"))
  	  val pair = new Pair<RestrictionScalarDataPropertyValue, Map<String,String>>(oml, kv)
  	  restrictionScalarDataPropertyValues.put(uuid, pair)
  	]
  }
  
  protected def void readAspectSpecializationAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createAspectSpecializationAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<AspectSpecializationAxiom, Map<String,String>>(oml, kv)
  	  aspectSpecializationAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readConceptSpecializationAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createConceptSpecializationAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ConceptSpecializationAxiom, Map<String,String>>(oml, kv)
  	  conceptSpecializationAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readReifiedRelationshipSpecializationAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createReifiedRelationshipSpecializationAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ReifiedRelationshipSpecializationAxiom, Map<String,String>>(oml, kv)
  	  reifiedRelationshipSpecializationAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readSubDataPropertyOfAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createSubDataPropertyOfAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SubDataPropertyOfAxiom, Map<String,String>>(oml, kv)
  	  subDataPropertyOfAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readSubObjectPropertyOfAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createSubObjectPropertyOfAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SubObjectPropertyOfAxiom, Map<String,String>>(oml, kv)
  	  subObjectPropertyOfAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readRootConceptTaxonomyAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createRootConceptTaxonomyAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<RootConceptTaxonomyAxiom, Map<String,String>>(oml, kv)
  	  rootConceptTaxonomyAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readAnonymousConceptUnionAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createAnonymousConceptUnionAxiom()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<AnonymousConceptUnionAxiom, Map<String,String>>(oml, kv)
  	  anonymousConceptUnionAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readSpecificDisjointConceptAxioms(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createSpecificDisjointConceptAxiom()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SpecificDisjointConceptAxiom, Map<String,String>>(oml, kv)
  	  specificDisjointConceptAxioms.put(uuid, pair)
  	]
  }
  
  protected def void readConceptInstances(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createConceptInstance()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ConceptInstance, Map<String,String>>(oml, kv)
  	  conceptInstances.put(uuid, pair)
  	]
  }
  
  protected def void readReifiedRelationshipInstances(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createReifiedRelationshipInstance()
  	  val uuid = kv.remove("uuid")
  	  oml.name = OMLTables.toLocalName(kv.remove("name"))
  	  val pair = new Pair<ReifiedRelationshipInstance, Map<String,String>>(oml, kv)
  	  reifiedRelationshipInstances.put(uuid, pair)
  	]
  }
  
  protected def void readReifiedRelationshipInstanceDomains(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createReifiedRelationshipInstanceDomain()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ReifiedRelationshipInstanceDomain, Map<String,String>>(oml, kv)
  	  reifiedRelationshipInstanceDomains.put(uuid, pair)
  	]
  }
  
  protected def void readReifiedRelationshipInstanceRanges(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createReifiedRelationshipInstanceRange()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<ReifiedRelationshipInstanceRange, Map<String,String>>(oml, kv)
  	  reifiedRelationshipInstanceRanges.put(uuid, pair)
  	]
  }
  
  protected def void readUnreifiedRelationshipInstanceTuples(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createUnreifiedRelationshipInstanceTuple()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<UnreifiedRelationshipInstanceTuple, Map<String,String>>(oml, kv)
  	  unreifiedRelationshipInstanceTuples.put(uuid, pair)
  	]
  }
  
  protected def void readSingletonInstanceStructuredDataPropertyValues(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createSingletonInstanceStructuredDataPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<SingletonInstanceStructuredDataPropertyValue, Map<String,String>>(oml, kv)
  	  singletonInstanceStructuredDataPropertyValues.put(uuid, pair)
  	]
  }
  
  protected def void readSingletonInstanceScalarDataPropertyValues(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createSingletonInstanceScalarDataPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  oml.scalarPropertyValue = OMLTables.toLiteralValue(kv.remove("scalarPropertyValue"))
  	  val pair = new Pair<SingletonInstanceScalarDataPropertyValue, Map<String,String>>(oml, kv)
  	  singletonInstanceScalarDataPropertyValues.put(uuid, pair)
  	]
  }
  
  protected def void readStructuredDataPropertyTuples(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createStructuredDataPropertyTuple()
  	  val uuid = kv.remove("uuid")
  	  val pair = new Pair<StructuredDataPropertyTuple, Map<String,String>>(oml, kv)
  	  structuredDataPropertyTuples.put(uuid, pair)
  	]
  }
  
  protected def void readScalarDataPropertyValues(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createScalarDataPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  oml.scalarPropertyValue = OMLTables.toLiteralValue(kv.remove("scalarPropertyValue"))
  	  val pair = new Pair<ScalarDataPropertyValue, Map<String,String>>(oml, kv)
  	  scalarDataPropertyValues.put(uuid, pair)
  	]
  }
  
  protected def void readAnnotationPropertyValues(ArrayList<String> lines) {
  	val kvs = OMLZipResource.lines2tuples(lines)
  	kvs.forEach[kv|
  	  val oml = createAnnotationPropertyValue()
  	  val uuid = kv.remove("uuid")
  	  oml.value = OMLTables.toLiteralString(kv.remove("value"))
  	  val pair = new Pair<AnnotationPropertyValue, Map<String,String>>(oml, kv)
  	  annotationPropertyValues.put(uuid, pair)
  	]
  }
  

  protected def <U,V extends U> void includeMap(Map<String, Pair<U, Map<String, String>>> uMap, Map<String, Pair<V, Map<String, String>>> vMap) {
    vMap.forEach[uuid,kv|uMap.put(uuid, new Pair<U, Map<String, String>>(kv.key, Collections.emptyMap))]
  }
  
  protected def void resolve(ResourceSet rs, OMLZipResource r) {
	// Lookup table for LogicalElement cross references
    includeMap(logicalElements, terminologyGraphs)
    includeMap(logicalElements, bundles)
    includeMap(logicalElements, descriptionBoxes)
    includeMap(logicalElements, aspects)
    includeMap(logicalElements, concepts)
    includeMap(logicalElements, scalars)
    includeMap(logicalElements, structures)
    includeMap(logicalElements, conceptDesignationTerminologyAxioms)
    includeMap(logicalElements, terminologyExtensionAxioms)
    includeMap(logicalElements, terminologyNestingAxioms)
    includeMap(logicalElements, bundledTerminologyAxioms)
    includeMap(logicalElements, descriptionBoxExtendsClosedWorldDefinitions)
    includeMap(logicalElements, descriptionBoxRefinements)
    includeMap(logicalElements, binaryScalarRestrictions)
    includeMap(logicalElements, iriScalarRestrictions)
    includeMap(logicalElements, numericScalarRestrictions)
    includeMap(logicalElements, plainLiteralScalarRestrictions)
    includeMap(logicalElements, scalarOneOfRestrictions)
    includeMap(logicalElements, scalarOneOfLiteralAxioms)
    includeMap(logicalElements, stringScalarRestrictions)
    includeMap(logicalElements, synonymScalarRestrictions)
    includeMap(logicalElements, timeScalarRestrictions)
    includeMap(logicalElements, entityScalarDataProperties)
    includeMap(logicalElements, entityStructuredDataProperties)
    includeMap(logicalElements, scalarDataProperties)
    includeMap(logicalElements, structuredDataProperties)
    includeMap(logicalElements, reifiedRelationships)
    includeMap(logicalElements, forwardProperties)
    includeMap(logicalElements, inverseProperties)
    includeMap(logicalElements, unreifiedRelationships)
    includeMap(logicalElements, chainRules)
    includeMap(logicalElements, ruleBodySegments)
    includeMap(logicalElements, segmentPredicates)
    includeMap(logicalElements, entityExistentialRestrictionAxioms)
    includeMap(logicalElements, entityUniversalRestrictionAxioms)
    includeMap(logicalElements, entityScalarDataPropertyExistentialRestrictionAxioms)
    includeMap(logicalElements, entityScalarDataPropertyParticularRestrictionAxioms)
    includeMap(logicalElements, entityScalarDataPropertyUniversalRestrictionAxioms)
    includeMap(logicalElements, entityStructuredDataPropertyParticularRestrictionAxioms)
    includeMap(logicalElements, restrictionStructuredDataPropertyTuples)
    includeMap(logicalElements, restrictionScalarDataPropertyValues)
    includeMap(logicalElements, aspectSpecializationAxioms)
    includeMap(logicalElements, conceptSpecializationAxioms)
    includeMap(logicalElements, reifiedRelationshipSpecializationAxioms)
    includeMap(logicalElements, subDataPropertyOfAxioms)
    includeMap(logicalElements, subObjectPropertyOfAxioms)
    includeMap(logicalElements, rootConceptTaxonomyAxioms)
    includeMap(logicalElements, anonymousConceptUnionAxioms)
    includeMap(logicalElements, specificDisjointConceptAxioms)
    includeMap(logicalElements, conceptInstances)
    includeMap(logicalElements, reifiedRelationshipInstances)
    includeMap(logicalElements, reifiedRelationshipInstanceDomains)
    includeMap(logicalElements, reifiedRelationshipInstanceRanges)
    includeMap(logicalElements, unreifiedRelationshipInstanceTuples)
    includeMap(logicalElements, singletonInstanceStructuredDataPropertyValues)
    includeMap(logicalElements, singletonInstanceScalarDataPropertyValues)
    includeMap(logicalElements, structuredDataPropertyTuples)
    includeMap(logicalElements, scalarDataPropertyValues)
  	
	// Lookup table for Entity cross references
  	includeMap(entities, aspects)
  	includeMap(entities, concepts)
  	includeMap(entities, reifiedRelationships)
    
	// Lookup table for EntityRelationship cross references
    includeMap(entityRelationships, reifiedRelationships)
    includeMap(entityRelationships, unreifiedRelationships)
    
	// Lookup table for DataRange cross references
    includeMap(dataRanges, scalars)
    includeMap(dataRanges, binaryScalarRestrictions)
    includeMap(dataRanges, iriScalarRestrictions)
    includeMap(dataRanges, numericScalarRestrictions)
    includeMap(dataRanges, plainLiteralScalarRestrictions)
    includeMap(dataRanges, scalarOneOfRestrictions)
    includeMap(dataRanges, stringScalarRestrictions)
    includeMap(dataRanges, synonymScalarRestrictions)
    includeMap(dataRanges, timeScalarRestrictions)
  	
	// Lookup table for DataRelationshipToScalar cross references
  	includeMap(dataRelationshipToScalars, entityScalarDataProperties)
  	includeMap(dataRelationshipToScalars, scalarDataProperties)
  	
	// Lookup table for DataRelationshipToStructure cross references
  	includeMap(dataRelationshipToStructures, entityStructuredDataProperties)
  	includeMap(dataRelationshipToStructures, structuredDataProperties)
  	
	// Lookup table for RestrictionStructuredDataPropertyContext cross references
  	includeMap(restrictionStructuredDataPropertyContexts, entityStructuredDataPropertyParticularRestrictionAxioms)
  	includeMap(restrictionStructuredDataPropertyContexts, restrictionStructuredDataPropertyTuples)
  	
	// Lookup table for TerminologyBox cross references
  	includeMap(terminologyBoxes, terminologyGraphs)
  	includeMap(terminologyBoxes, bundles)
  	
	// Lookup table for ConceptTreeDisjunction cross references
  	includeMap(conceptTreeDisjunctions, rootConceptTaxonomyAxioms)
  	includeMap(conceptTreeDisjunctions, anonymousConceptUnionAxioms)
  	
	// Lookup table for ConceptualEntitySingletonInstance cross references
  	includeMap(conceptualEntitySingletonInstances, conceptInstances)
  	includeMap(conceptualEntitySingletonInstances, reifiedRelationshipInstances)
  	
	// Lookup table for SingletonInstanceStructuredDataPropertyContext cross references
  	includeMap(singletonInstanceStructuredDataPropertyContexts, singletonInstanceStructuredDataPropertyValues)
  	includeMap(singletonInstanceStructuredDataPropertyContexts, structuredDataPropertyTuples)
  	
    resolveAnnotationProperties(rs)
    resolveAspects(rs)
    resolveConcepts(rs)
    resolveScalars(rs)
    resolveStructures(rs)
    resolveConceptDesignationTerminologyAxioms(rs)
    resolveTerminologyExtensionAxioms(rs)
    resolveTerminologyNestingAxioms(rs)
    resolveBundledTerminologyAxioms(rs)
    resolveDescriptionBoxExtendsClosedWorldDefinitions(rs)
    resolveDescriptionBoxRefinements(rs)
    resolveBinaryScalarRestrictions(rs)
    resolveIRIScalarRestrictions(rs)
    resolveNumericScalarRestrictions(rs)
    resolvePlainLiteralScalarRestrictions(rs)
    resolveScalarOneOfRestrictions(rs)
    resolveScalarOneOfLiteralAxioms(rs)
    resolveStringScalarRestrictions(rs)
    resolveSynonymScalarRestrictions(rs)
    resolveTimeScalarRestrictions(rs)
    resolveEntityScalarDataProperties(rs)
    resolveEntityStructuredDataProperties(rs)
    resolveScalarDataProperties(rs)
    resolveStructuredDataProperties(rs)
    resolveReifiedRelationships(rs)
    resolveForwardProperties(rs)
    resolveInverseProperties(rs)
    resolveUnreifiedRelationships(rs)
    resolveChainRules(rs)
    resolveRuleBodySegments(rs)
    resolveSegmentPredicates(rs)
    resolveEntityExistentialRestrictionAxioms(rs)
    resolveEntityUniversalRestrictionAxioms(rs)
    resolveEntityScalarDataPropertyExistentialRestrictionAxioms(rs)
    resolveEntityScalarDataPropertyParticularRestrictionAxioms(rs)
    resolveEntityScalarDataPropertyUniversalRestrictionAxioms(rs)
    resolveEntityStructuredDataPropertyParticularRestrictionAxioms(rs)
    resolveRestrictionStructuredDataPropertyTuples(rs)
    resolveRestrictionScalarDataPropertyValues(rs)
    resolveAspectSpecializationAxioms(rs)
    resolveConceptSpecializationAxioms(rs)
    resolveReifiedRelationshipSpecializationAxioms(rs)
    resolveSubDataPropertyOfAxioms(rs)
    resolveSubObjectPropertyOfAxioms(rs)
    resolveRootConceptTaxonomyAxioms(rs)
    resolveAnonymousConceptUnionAxioms(rs)
    resolveSpecificDisjointConceptAxioms(rs)
    resolveConceptInstances(rs)
    resolveReifiedRelationshipInstances(rs)
    resolveReifiedRelationshipInstanceDomains(rs)
    resolveReifiedRelationshipInstanceRanges(rs)
    resolveUnreifiedRelationshipInstanceTuples(rs)
    resolveSingletonInstanceStructuredDataPropertyValues(rs)
    resolveSingletonInstanceScalarDataPropertyValues(rs)
    resolveStructuredDataPropertyTuples(rs)
    resolveScalarDataPropertyValues(rs)
    resolveAnnotationPropertyValues(rs)
    
    	val ext = createExtent()
    	ext.getModules.addAll(terminologyGraphs.values.map[key])
    	ext.getModules.addAll(bundles.values.map[key])
    	ext.getModules.addAll(descriptionBoxes.values.map[key])
    	r.contents.add(ext)
  }

  protected def void resolveAnnotationProperties(ResourceSet rs) {
  	annotationProperties.forEach[uuid, oml_kv |
  	  val AnnotationProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String moduleXRef = kv.remove("moduleUUID")
  	    val Pair<Module, Map<String, String>> modulePair = modules.get(moduleXRef)
  	    if (null === modulePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for module in annotationProperties")
  	    oml.module = modulePair.key
  	  }
  	]
  }
  
  protected def void resolveAspects(ResourceSet rs) {
  	aspects.forEach[uuid, oml_kv |
  	  val Aspect oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in aspects")
  	    oml.tbox = tboxPair.key
  	  }
  	]
  }
  
  protected def void resolveConcepts(ResourceSet rs) {
  	concepts.forEach[uuid, oml_kv |
  	  val Concept oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in concepts")
  	    oml.tbox = tboxPair.key
  	  }
  	]
  }
  
  protected def void resolveScalars(ResourceSet rs) {
  	scalars.forEach[uuid, oml_kv |
  	  val Scalar oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in scalars")
  	    oml.tbox = tboxPair.key
  	  }
  	]
  }
  
  protected def void resolveStructures(ResourceSet rs) {
  	structures.forEach[uuid, oml_kv |
  	  val Structure oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in structures")
  	    oml.tbox = tboxPair.key
  	  }
  	]
  }
  
  protected def void resolveConceptDesignationTerminologyAxioms(ResourceSet rs) {
  	conceptDesignationTerminologyAxioms.forEach[uuid, oml_kv |
  	  val ConceptDesignationTerminologyAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in conceptDesignationTerminologyAxioms")
  	    oml.tbox = tboxPair.key
  	    val String designatedConceptXRef = kv.remove("designatedConceptUUID")
  	    val Pair<Concept, Map<String, String>> designatedConceptPair = concepts.get(designatedConceptXRef)
  	    if (null === designatedConceptPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for designatedConcept in conceptDesignationTerminologyAxioms")
  	    oml.designatedConcept = designatedConceptPair.key
  	    val String designatedTerminologyIRI = kv.remove("designatedTerminologyIRI")
  	    loadOMLZipResource(rs, URI.createURI(designatedTerminologyIRI))
  	    val Pair<TerminologyBox, Map<String, String>> designatedTerminologyPair = terminologyBoxes.get(designatedTerminologyIRI)
  	    if (null === designatedTerminologyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for designatedTerminology in conceptDesignationTerminologyAxioms")
  	    oml.designatedTerminology = designatedTerminologyPair.key		  	  
  	  }
  	]
  }
  
  protected def void resolveTerminologyExtensionAxioms(ResourceSet rs) {
  	terminologyExtensionAxioms.forEach[uuid, oml_kv |
  	  val TerminologyExtensionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in terminologyExtensionAxioms")
  	    oml.tbox = tboxPair.key
  	    val String extendedTerminologyIRI = kv.remove("extendedTerminologyIRI")
  	    loadOMLZipResource(rs, URI.createURI(extendedTerminologyIRI))
  	    val Pair<TerminologyBox, Map<String, String>> extendedTerminologyPair = terminologyBoxes.get(extendedTerminologyIRI)
  	    if (null === extendedTerminologyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for extendedTerminology in terminologyExtensionAxioms")
  	    oml.extendedTerminology = extendedTerminologyPair.key		  	  
  	  }
  	]
  }
  
  protected def void resolveTerminologyNestingAxioms(ResourceSet rs) {
  	terminologyNestingAxioms.forEach[uuid, oml_kv |
  	  val TerminologyNestingAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in terminologyNestingAxioms")
  	    oml.tbox = tboxPair.key
  	    val String nestingContextXRef = kv.remove("nestingContextUUID")
  	    val Pair<Concept, Map<String, String>> nestingContextPair = concepts.get(nestingContextXRef)
  	    if (null === nestingContextPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for nestingContext in terminologyNestingAxioms")
  	    oml.nestingContext = nestingContextPair.key
  	    val String nestingTerminologyIRI = kv.remove("nestingTerminologyIRI")
  	    loadOMLZipResource(rs, URI.createURI(nestingTerminologyIRI))
  	    val Pair<TerminologyBox, Map<String, String>> nestingTerminologyPair = terminologyBoxes.get(nestingTerminologyIRI)
  	    if (null === nestingTerminologyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for nestingTerminology in terminologyNestingAxioms")
  	    oml.nestingTerminology = nestingTerminologyPair.key		  	  
  	  }
  	]
  }
  
  protected def void resolveBundledTerminologyAxioms(ResourceSet rs) {
  	bundledTerminologyAxioms.forEach[uuid, oml_kv |
  	  val BundledTerminologyAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String bundleXRef = kv.remove("bundleUUID")
  	    val Pair<Bundle, Map<String, String>> bundlePair = bundles.get(bundleXRef)
  	    if (null === bundlePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for bundle in bundledTerminologyAxioms")
  	    oml.bundle = bundlePair.key
  	    val String bundledTerminologyIRI = kv.remove("bundledTerminologyIRI")
  	    loadOMLZipResource(rs, URI.createURI(bundledTerminologyIRI))
  	    val Pair<TerminologyBox, Map<String, String>> bundledTerminologyPair = terminologyBoxes.get(bundledTerminologyIRI)
  	    if (null === bundledTerminologyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for bundledTerminology in bundledTerminologyAxioms")
  	    oml.bundledTerminology = bundledTerminologyPair.key		  	  
  	  }
  	]
  }
  
  protected def void resolveDescriptionBoxExtendsClosedWorldDefinitions(ResourceSet rs) {
  	descriptionBoxExtendsClosedWorldDefinitions.forEach[uuid, oml_kv |
  	  val DescriptionBoxExtendsClosedWorldDefinitions oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.remove("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null === descriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in descriptionBoxExtendsClosedWorldDefinitions")
  	    oml.descriptionBox = descriptionBoxPair.key
  	    val String closedWorldDefinitionsIRI = kv.remove("closedWorldDefinitionsIRI")
  	    loadOMLZipResource(rs, URI.createURI(closedWorldDefinitionsIRI))
  	    val Pair<TerminologyBox, Map<String, String>> closedWorldDefinitionsPair = terminologyBoxes.get(closedWorldDefinitionsIRI)
  	    if (null === closedWorldDefinitionsPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for closedWorldDefinitions in descriptionBoxExtendsClosedWorldDefinitions")
  	    oml.closedWorldDefinitions = closedWorldDefinitionsPair.key		  	  
  	  }
  	]
  }
  
  protected def void resolveDescriptionBoxRefinements(ResourceSet rs) {
  	descriptionBoxRefinements.forEach[uuid, oml_kv |
  	  val DescriptionBoxRefinement oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String refiningDescriptionBoxXRef = kv.remove("refiningDescriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> refiningDescriptionBoxPair = descriptionBoxes.get(refiningDescriptionBoxXRef)
  	    if (null === refiningDescriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for refiningDescriptionBox in descriptionBoxRefinements")
  	    oml.refiningDescriptionBox = refiningDescriptionBoxPair.key
  	    val String refinedDescriptionBoxIRI = kv.remove("refinedDescriptionBoxIRI")
  	    loadOMLZipResource(rs, URI.createURI(refinedDescriptionBoxIRI))
  	    val Pair<DescriptionBox, Map<String, String>> refinedDescriptionBoxPair = descriptionBoxes.get(refinedDescriptionBoxIRI)
  	    if (null === refinedDescriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for refinedDescriptionBox in descriptionBoxRefinements")
  	    oml.refinedDescriptionBox = refinedDescriptionBoxPair.key		  	  
  	  }
  	]
  }
  
  protected def void resolveBinaryScalarRestrictions(ResourceSet rs) {
  	binaryScalarRestrictions.forEach[uuid, oml_kv |
  	  val BinaryScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in binaryScalarRestrictions")
  	    oml.tbox = tboxPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in binaryScalarRestrictions")
  	    oml.restrictedRange = restrictedRangePair.key
  	  }
  	]
  }
  
  protected def void resolveIRIScalarRestrictions(ResourceSet rs) {
  	iriScalarRestrictions.forEach[uuid, oml_kv |
  	  val IRIScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in iriScalarRestrictions")
  	    oml.tbox = tboxPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in iriScalarRestrictions")
  	    oml.restrictedRange = restrictedRangePair.key
  	  }
  	]
  }
  
  protected def void resolveNumericScalarRestrictions(ResourceSet rs) {
  	numericScalarRestrictions.forEach[uuid, oml_kv |
  	  val NumericScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in numericScalarRestrictions")
  	    oml.tbox = tboxPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in numericScalarRestrictions")
  	    oml.restrictedRange = restrictedRangePair.key
  	  }
  	]
  }
  
  protected def void resolvePlainLiteralScalarRestrictions(ResourceSet rs) {
  	plainLiteralScalarRestrictions.forEach[uuid, oml_kv |
  	  val PlainLiteralScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in plainLiteralScalarRestrictions")
  	    oml.tbox = tboxPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in plainLiteralScalarRestrictions")
  	    oml.restrictedRange = restrictedRangePair.key
  	  }
  	]
  }
  
  protected def void resolveScalarOneOfRestrictions(ResourceSet rs) {
  	scalarOneOfRestrictions.forEach[uuid, oml_kv |
  	  val ScalarOneOfRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in scalarOneOfRestrictions")
  	    oml.tbox = tboxPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in scalarOneOfRestrictions")
  	    oml.restrictedRange = restrictedRangePair.key
  	  }
  	]
  }
  
  protected def void resolveScalarOneOfLiteralAxioms(ResourceSet rs) {
  	scalarOneOfLiteralAxioms.forEach[uuid, oml_kv |
  	  val ScalarOneOfLiteralAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in scalarOneOfLiteralAxioms")
  	    oml.tbox = tboxPair.key
  	    val String axiomXRef = kv.remove("axiomUUID")
  	    val Pair<ScalarOneOfRestriction, Map<String, String>> axiomPair = scalarOneOfRestrictions.get(axiomXRef)
  	    if (null === axiomPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for axiom in scalarOneOfLiteralAxioms")
  	    oml.axiom = axiomPair.key
  	    val String valueTypeXRef = kv.remove("valueTypeUUID")
  	    if ("null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null === valueTypePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for valueType in scalarOneOfLiteralAxioms")
  	      oml.valueType = valueTypePair.key
  	    }
  	  }
  	]
  }
  
  protected def void resolveStringScalarRestrictions(ResourceSet rs) {
  	stringScalarRestrictions.forEach[uuid, oml_kv |
  	  val StringScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in stringScalarRestrictions")
  	    oml.tbox = tboxPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in stringScalarRestrictions")
  	    oml.restrictedRange = restrictedRangePair.key
  	  }
  	]
  }
  
  protected def void resolveSynonymScalarRestrictions(ResourceSet rs) {
  	synonymScalarRestrictions.forEach[uuid, oml_kv |
  	  val SynonymScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in synonymScalarRestrictions")
  	    oml.tbox = tboxPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in synonymScalarRestrictions")
  	    oml.restrictedRange = restrictedRangePair.key
  	  }
  	]
  }
  
  protected def void resolveTimeScalarRestrictions(ResourceSet rs) {
  	timeScalarRestrictions.forEach[uuid, oml_kv |
  	  val TimeScalarRestriction oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in timeScalarRestrictions")
  	    oml.tbox = tboxPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<DataRange, Map<String, String>> restrictedRangePair = dataRanges.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in timeScalarRestrictions")
  	    oml.restrictedRange = restrictedRangePair.key
  	  }
  	]
  }
  
  protected def void resolveEntityScalarDataProperties(ResourceSet rs) {
  	entityScalarDataProperties.forEach[uuid, oml_kv |
  	  val EntityScalarDataProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityScalarDataProperties")
  	    oml.tbox = tboxPair.key
  	    val String domainXRef = kv.remove("domainUUID")
  	    val Pair<Entity, Map<String, String>> domainPair = entities.get(domainXRef)
  	    if (null === domainPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for domain in entityScalarDataProperties")
  	    oml.domain = domainPair.key
  	    val String rangeXRef = kv.remove("rangeUUID")
  	    val Pair<DataRange, Map<String, String>> rangePair = dataRanges.get(rangeXRef)
  	    if (null === rangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for range in entityScalarDataProperties")
  	    oml.range = rangePair.key
  	  }
  	]
  }
  
  protected def void resolveEntityStructuredDataProperties(ResourceSet rs) {
  	entityStructuredDataProperties.forEach[uuid, oml_kv |
  	  val EntityStructuredDataProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityStructuredDataProperties")
  	    oml.tbox = tboxPair.key
  	    val String domainXRef = kv.remove("domainUUID")
  	    val Pair<Entity, Map<String, String>> domainPair = entities.get(domainXRef)
  	    if (null === domainPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for domain in entityStructuredDataProperties")
  	    oml.domain = domainPair.key
  	    val String rangeXRef = kv.remove("rangeUUID")
  	    val Pair<Structure, Map<String, String>> rangePair = structures.get(rangeXRef)
  	    if (null === rangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for range in entityStructuredDataProperties")
  	    oml.range = rangePair.key
  	  }
  	]
  }
  
  protected def void resolveScalarDataProperties(ResourceSet rs) {
  	scalarDataProperties.forEach[uuid, oml_kv |
  	  val ScalarDataProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in scalarDataProperties")
  	    oml.tbox = tboxPair.key
  	    val String domainXRef = kv.remove("domainUUID")
  	    val Pair<Structure, Map<String, String>> domainPair = structures.get(domainXRef)
  	    if (null === domainPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for domain in scalarDataProperties")
  	    oml.domain = domainPair.key
  	    val String rangeXRef = kv.remove("rangeUUID")
  	    val Pair<DataRange, Map<String, String>> rangePair = dataRanges.get(rangeXRef)
  	    if (null === rangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for range in scalarDataProperties")
  	    oml.range = rangePair.key
  	  }
  	]
  }
  
  protected def void resolveStructuredDataProperties(ResourceSet rs) {
  	structuredDataProperties.forEach[uuid, oml_kv |
  	  val StructuredDataProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in structuredDataProperties")
  	    oml.tbox = tboxPair.key
  	    val String domainXRef = kv.remove("domainUUID")
  	    val Pair<Structure, Map<String, String>> domainPair = structures.get(domainXRef)
  	    if (null === domainPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for domain in structuredDataProperties")
  	    oml.domain = domainPair.key
  	    val String rangeXRef = kv.remove("rangeUUID")
  	    val Pair<Structure, Map<String, String>> rangePair = structures.get(rangeXRef)
  	    if (null === rangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for range in structuredDataProperties")
  	    oml.range = rangePair.key
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationships(ResourceSet rs) {
  	reifiedRelationships.forEach[uuid, oml_kv |
  	  val ReifiedRelationship oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in reifiedRelationships")
  	    oml.tbox = tboxPair.key
  	    val String sourceXRef = kv.remove("sourceUUID")
  	    val Pair<Entity, Map<String, String>> sourcePair = entities.get(sourceXRef)
  	    if (null === sourcePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for source in reifiedRelationships")
  	    oml.source = sourcePair.key
  	    val String targetXRef = kv.remove("targetUUID")
  	    val Pair<Entity, Map<String, String>> targetPair = entities.get(targetXRef)
  	    if (null === targetPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for target in reifiedRelationships")
  	    oml.target = targetPair.key
  	  }
  	]
  }
  
  protected def void resolveForwardProperties(ResourceSet rs) {
  	forwardProperties.forEach[uuid, oml_kv |
  	  val ForwardProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID")
  	    val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = reifiedRelationships.get(reifiedRelationshipXRef)
  	    if (null === reifiedRelationshipPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in forwardProperties")
  	    oml.reifiedRelationship = reifiedRelationshipPair.key
  	  }
  	]
  }
  
  protected def void resolveInverseProperties(ResourceSet rs) {
  	inverseProperties.forEach[uuid, oml_kv |
  	  val InverseProperty oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String reifiedRelationshipXRef = kv.remove("reifiedRelationshipUUID")
  	    val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipPair = reifiedRelationships.get(reifiedRelationshipXRef)
  	    if (null === reifiedRelationshipPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationship in inverseProperties")
  	    oml.reifiedRelationship = reifiedRelationshipPair.key
  	  }
  	]
  }
  
  protected def void resolveUnreifiedRelationships(ResourceSet rs) {
  	unreifiedRelationships.forEach[uuid, oml_kv |
  	  val UnreifiedRelationship oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in unreifiedRelationships")
  	    oml.tbox = tboxPair.key
  	    val String sourceXRef = kv.remove("sourceUUID")
  	    val Pair<Entity, Map<String, String>> sourcePair = entities.get(sourceXRef)
  	    if (null === sourcePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for source in unreifiedRelationships")
  	    oml.source = sourcePair.key
  	    val String targetXRef = kv.remove("targetUUID")
  	    val Pair<Entity, Map<String, String>> targetPair = entities.get(targetXRef)
  	    if (null === targetPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for target in unreifiedRelationships")
  	    oml.target = targetPair.key
  	  }
  	]
  }
  
  protected def void resolveChainRules(ResourceSet rs) {
  	chainRules.forEach[uuid, oml_kv |
  	  val ChainRule oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in chainRules")
  	    oml.tbox = tboxPair.key
  	    val String headXRef = kv.remove("headUUID")
  	    val Pair<UnreifiedRelationship, Map<String, String>> headPair = unreifiedRelationships.get(headXRef)
  	    if (null === headPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for head in chainRules")
  	    oml.head = headPair.key
  	  }
  	]
  }
  
  protected def void resolveRuleBodySegments(ResourceSet rs) {
  	ruleBodySegments.forEach[uuid, oml_kv |
  	  val RuleBodySegment oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String previousSegmentXRef = kv.remove("previousSegmentUUID")
  	    if ("null" != previousSegmentXRef) {
  	      val Pair<RuleBodySegment, Map<String, String>> previousSegmentPair = ruleBodySegments.get(previousSegmentXRef)
  	      if (null === previousSegmentPair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for previousSegment in ruleBodySegments")
  	      oml.previousSegment = previousSegmentPair.key
  	    }
  	    val String ruleXRef = kv.remove("ruleUUID")
  	    if ("null" != ruleXRef) {
  	      val Pair<ChainRule, Map<String, String>> rulePair = chainRules.get(ruleXRef)
  	      if (null === rulePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for rule in ruleBodySegments")
  	      oml.rule = rulePair.key
  	    }
  	  }
  	]
  }
  
  protected def void resolveSegmentPredicates(ResourceSet rs) {
  	segmentPredicates.forEach[uuid, oml_kv |
  	  val SegmentPredicate oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String bodySegmentXRef = kv.remove("bodySegmentUUID")
  	    val Pair<RuleBodySegment, Map<String, String>> bodySegmentPair = ruleBodySegments.get(bodySegmentXRef)
  	    if (null === bodySegmentPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for bodySegment in segmentPredicates")
  	    oml.bodySegment = bodySegmentPair.key
  	    val String predicateXRef = kv.remove("predicateUUID")
  	    if ("null" != predicateXRef) {
  	      val Pair<Predicate, Map<String, String>> predicatePair = predicates.get(predicateXRef)
  	      if (null === predicatePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for predicate in segmentPredicates")
  	      oml.predicate = predicatePair.key
  	    }
  	    val String reifiedRelationshipSourceXRef = kv.remove("reifiedRelationshipSourceUUID")
  	    if ("null" != reifiedRelationshipSourceXRef) {
  	      val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipSourcePair = reifiedRelationships.get(reifiedRelationshipSourceXRef)
  	      if (null === reifiedRelationshipSourcePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationshipSource in segmentPredicates")
  	      oml.reifiedRelationshipSource = reifiedRelationshipSourcePair.key
  	    }
  	    val String reifiedRelationshipInverseSourceXRef = kv.remove("reifiedRelationshipInverseSourceUUID")
  	    if ("null" != reifiedRelationshipInverseSourceXRef) {
  	      val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipInverseSourcePair = reifiedRelationships.get(reifiedRelationshipInverseSourceXRef)
  	      if (null === reifiedRelationshipInverseSourcePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationshipInverseSource in segmentPredicates")
  	      oml.reifiedRelationshipInverseSource = reifiedRelationshipInverseSourcePair.key
  	    }
  	    val String reifiedRelationshipTargetXRef = kv.remove("reifiedRelationshipTargetUUID")
  	    if ("null" != reifiedRelationshipTargetXRef) {
  	      val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipTargetPair = reifiedRelationships.get(reifiedRelationshipTargetXRef)
  	      if (null === reifiedRelationshipTargetPair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationshipTarget in segmentPredicates")
  	      oml.reifiedRelationshipTarget = reifiedRelationshipTargetPair.key
  	    }
  	    val String reifiedRelationshipInverseTargetXRef = kv.remove("reifiedRelationshipInverseTargetUUID")
  	    if ("null" != reifiedRelationshipInverseTargetXRef) {
  	      val Pair<ReifiedRelationship, Map<String, String>> reifiedRelationshipInverseTargetPair = reifiedRelationships.get(reifiedRelationshipInverseTargetXRef)
  	      if (null === reifiedRelationshipInverseTargetPair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationshipInverseTarget in segmentPredicates")
  	      oml.reifiedRelationshipInverseTarget = reifiedRelationshipInverseTargetPair.key
  	    }
  	    val String unreifiedRelationshipInverseXRef = kv.remove("unreifiedRelationshipInverseUUID")
  	    if ("null" != unreifiedRelationshipInverseXRef) {
  	      val Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipInversePair = unreifiedRelationships.get(unreifiedRelationshipInverseXRef)
  	      if (null === unreifiedRelationshipInversePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for unreifiedRelationshipInverse in segmentPredicates")
  	      oml.unreifiedRelationshipInverse = unreifiedRelationshipInversePair.key
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityExistentialRestrictionAxioms(ResourceSet rs) {
  	entityExistentialRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityExistentialRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityExistentialRestrictionAxioms")
  	    oml.tbox = tboxPair.key
  	    val String restrictedDomainXRef = kv.remove("restrictedDomainUUID")
  	    val Pair<Entity, Map<String, String>> restrictedDomainPair = entities.get(restrictedDomainXRef)
  	    if (null === restrictedDomainPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedDomain in entityExistentialRestrictionAxioms")
  	    oml.restrictedDomain = restrictedDomainPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<Entity, Map<String, String>> restrictedRangePair = entities.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in entityExistentialRestrictionAxioms")
  	    oml.restrictedRange = restrictedRangePair.key
  	    val String restrictedRelationshipXRef = kv.remove("restrictedRelationshipUUID")
  	    val Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = restrictableRelationships.get(restrictedRelationshipXRef)
  	    if (null === restrictedRelationshipPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRelationship in entityExistentialRestrictionAxioms")
  	    oml.restrictedRelationship = restrictedRelationshipPair.key
  	  }
  	]
  }
  
  protected def void resolveEntityUniversalRestrictionAxioms(ResourceSet rs) {
  	entityUniversalRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityUniversalRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityUniversalRestrictionAxioms")
  	    oml.tbox = tboxPair.key
  	    val String restrictedDomainXRef = kv.remove("restrictedDomainUUID")
  	    val Pair<Entity, Map<String, String>> restrictedDomainPair = entities.get(restrictedDomainXRef)
  	    if (null === restrictedDomainPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedDomain in entityUniversalRestrictionAxioms")
  	    oml.restrictedDomain = restrictedDomainPair.key
  	    val String restrictedRangeXRef = kv.remove("restrictedRangeUUID")
  	    val Pair<Entity, Map<String, String>> restrictedRangePair = entities.get(restrictedRangeXRef)
  	    if (null === restrictedRangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRange in entityUniversalRestrictionAxioms")
  	    oml.restrictedRange = restrictedRangePair.key
  	    val String restrictedRelationshipXRef = kv.remove("restrictedRelationshipUUID")
  	    val Pair<RestrictableRelationship, Map<String, String>> restrictedRelationshipPair = restrictableRelationships.get(restrictedRelationshipXRef)
  	    if (null === restrictedRelationshipPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedRelationship in entityUniversalRestrictionAxioms")
  	    oml.restrictedRelationship = restrictedRelationshipPair.key
  	  }
  	]
  }
  
  protected def void resolveEntityScalarDataPropertyExistentialRestrictionAxioms(ResourceSet rs) {
  	entityScalarDataPropertyExistentialRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityScalarDataPropertyExistentialRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityScalarDataPropertyExistentialRestrictionAxioms")
  	    oml.tbox = tboxPair.key
  	    val String restrictedEntityXRef = kv.remove("restrictedEntityUUID")
  	    val Pair<Entity, Map<String, String>> restrictedEntityPair = entities.get(restrictedEntityXRef)
  	    if (null === restrictedEntityPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyExistentialRestrictionAxioms")
  	    oml.restrictedEntity = restrictedEntityPair.key
  	    val String scalarPropertyXRef = kv.remove("scalarPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = entityScalarDataProperties.get(scalarPropertyXRef)
  	    if (null === scalarPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyExistentialRestrictionAxioms")
  	    oml.scalarProperty = scalarPropertyPair.key
  	    val String scalarRestrictionXRef = kv.remove("scalarRestrictionUUID")
  	    val Pair<DataRange, Map<String, String>> scalarRestrictionPair = dataRanges.get(scalarRestrictionXRef)
  	    if (null === scalarRestrictionPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for scalarRestriction in entityScalarDataPropertyExistentialRestrictionAxioms")
  	    oml.scalarRestriction = scalarRestrictionPair.key
  	  }
  	]
  }
  
  protected def void resolveEntityScalarDataPropertyParticularRestrictionAxioms(ResourceSet rs) {
  	entityScalarDataPropertyParticularRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityScalarDataPropertyParticularRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityScalarDataPropertyParticularRestrictionAxioms")
  	    oml.tbox = tboxPair.key
  	    val String restrictedEntityXRef = kv.remove("restrictedEntityUUID")
  	    val Pair<Entity, Map<String, String>> restrictedEntityPair = entities.get(restrictedEntityXRef)
  	    if (null === restrictedEntityPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyParticularRestrictionAxioms")
  	    oml.restrictedEntity = restrictedEntityPair.key
  	    val String scalarPropertyXRef = kv.remove("scalarPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = entityScalarDataProperties.get(scalarPropertyXRef)
  	    if (null === scalarPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyParticularRestrictionAxioms")
  	    oml.scalarProperty = scalarPropertyPair.key
  	    val String valueTypeXRef = kv.remove("valueTypeUUID")
  	    if ("null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null === valueTypePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for valueType in entityScalarDataPropertyParticularRestrictionAxioms")
  	      oml.valueType = valueTypePair.key
  	    }
  	  }
  	]
  }
  
  protected def void resolveEntityScalarDataPropertyUniversalRestrictionAxioms(ResourceSet rs) {
  	entityScalarDataPropertyUniversalRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityScalarDataPropertyUniversalRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityScalarDataPropertyUniversalRestrictionAxioms")
  	    oml.tbox = tboxPair.key
  	    val String restrictedEntityXRef = kv.remove("restrictedEntityUUID")
  	    val Pair<Entity, Map<String, String>> restrictedEntityPair = entities.get(restrictedEntityXRef)
  	    if (null === restrictedEntityPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedEntity in entityScalarDataPropertyUniversalRestrictionAxioms")
  	    oml.restrictedEntity = restrictedEntityPair.key
  	    val String scalarPropertyXRef = kv.remove("scalarPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> scalarPropertyPair = entityScalarDataProperties.get(scalarPropertyXRef)
  	    if (null === scalarPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for scalarProperty in entityScalarDataPropertyUniversalRestrictionAxioms")
  	    oml.scalarProperty = scalarPropertyPair.key
  	    val String scalarRestrictionXRef = kv.remove("scalarRestrictionUUID")
  	    val Pair<DataRange, Map<String, String>> scalarRestrictionPair = dataRanges.get(scalarRestrictionXRef)
  	    if (null === scalarRestrictionPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for scalarRestriction in entityScalarDataPropertyUniversalRestrictionAxioms")
  	    oml.scalarRestriction = scalarRestrictionPair.key
  	  }
  	]
  }
  
  protected def void resolveEntityStructuredDataPropertyParticularRestrictionAxioms(ResourceSet rs) {
  	entityStructuredDataPropertyParticularRestrictionAxioms.forEach[uuid, oml_kv |
  	  val EntityStructuredDataPropertyParticularRestrictionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in entityStructuredDataPropertyParticularRestrictionAxioms")
  	    oml.tbox = tboxPair.key
  	    val String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID")
  	    val Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = dataRelationshipToStructures.get(structuredDataPropertyXRef)
  	    if (null === structuredDataPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for structuredDataProperty in entityStructuredDataPropertyParticularRestrictionAxioms")
  	    oml.structuredDataProperty = structuredDataPropertyPair.key
  	    val String restrictedEntityXRef = kv.remove("restrictedEntityUUID")
  	    val Pair<Entity, Map<String, String>> restrictedEntityPair = entities.get(restrictedEntityXRef)
  	    if (null === restrictedEntityPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for restrictedEntity in entityStructuredDataPropertyParticularRestrictionAxioms")
  	    oml.restrictedEntity = restrictedEntityPair.key
  	  }
  	]
  }
  
  protected def void resolveRestrictionStructuredDataPropertyTuples(ResourceSet rs) {
  	restrictionStructuredDataPropertyTuples.forEach[uuid, oml_kv |
  	  val RestrictionStructuredDataPropertyTuple oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID")
  	    val Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef)
  	    if (null === structuredDataPropertyContextPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for structuredDataPropertyContext in restrictionStructuredDataPropertyTuples")
  	    oml.structuredDataPropertyContext = structuredDataPropertyContextPair.key
  	    val String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID")
  	    val Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = dataRelationshipToStructures.get(structuredDataPropertyXRef)
  	    if (null === structuredDataPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for structuredDataProperty in restrictionStructuredDataPropertyTuples")
  	    oml.structuredDataProperty = structuredDataPropertyPair.key
  	  }
  	]
  }
  
  protected def void resolveRestrictionScalarDataPropertyValues(ResourceSet rs) {
  	restrictionScalarDataPropertyValues.forEach[uuid, oml_kv |
  	  val RestrictionScalarDataPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID")
  	    val Pair<RestrictionStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = restrictionStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef)
  	    if (null === structuredDataPropertyContextPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for structuredDataPropertyContext in restrictionScalarDataPropertyValues")
  	    oml.structuredDataPropertyContext = structuredDataPropertyContextPair.key
  	    val String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID")
  	    val Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = dataRelationshipToScalars.get(scalarDataPropertyXRef)
  	    if (null === scalarDataPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for scalarDataProperty in restrictionScalarDataPropertyValues")
  	    oml.scalarDataProperty = scalarDataPropertyPair.key
  	    val String valueTypeXRef = kv.remove("valueTypeUUID")
  	    if ("null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null === valueTypePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for valueType in restrictionScalarDataPropertyValues")
  	      oml.valueType = valueTypePair.key
  	    }
  	  }
  	]
  }
  
  protected def void resolveAspectSpecializationAxioms(ResourceSet rs) {
  	aspectSpecializationAxioms.forEach[uuid, oml_kv |
  	  val AspectSpecializationAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in aspectSpecializationAxioms")
  	    oml.tbox = tboxPair.key
  	    val String superAspectXRef = kv.remove("superAspectUUID")
  	    val Pair<Aspect, Map<String, String>> superAspectPair = aspects.get(superAspectXRef)
  	    if (null === superAspectPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for superAspect in aspectSpecializationAxioms")
  	    oml.superAspect = superAspectPair.key
  	    val String subEntityXRef = kv.remove("subEntityUUID")
  	    val Pair<Entity, Map<String, String>> subEntityPair = entities.get(subEntityXRef)
  	    if (null === subEntityPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for subEntity in aspectSpecializationAxioms")
  	    oml.subEntity = subEntityPair.key
  	  }
  	]
  }
  
  protected def void resolveConceptSpecializationAxioms(ResourceSet rs) {
  	conceptSpecializationAxioms.forEach[uuid, oml_kv |
  	  val ConceptSpecializationAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in conceptSpecializationAxioms")
  	    oml.tbox = tboxPair.key
  	    val String superConceptXRef = kv.remove("superConceptUUID")
  	    val Pair<Concept, Map<String, String>> superConceptPair = concepts.get(superConceptXRef)
  	    if (null === superConceptPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for superConcept in conceptSpecializationAxioms")
  	    oml.superConcept = superConceptPair.key
  	    val String subConceptXRef = kv.remove("subConceptUUID")
  	    val Pair<Concept, Map<String, String>> subConceptPair = concepts.get(subConceptXRef)
  	    if (null === subConceptPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for subConcept in conceptSpecializationAxioms")
  	    oml.subConcept = subConceptPair.key
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipSpecializationAxioms(ResourceSet rs) {
  	reifiedRelationshipSpecializationAxioms.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipSpecializationAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in reifiedRelationshipSpecializationAxioms")
  	    oml.tbox = tboxPair.key
  	    val String superRelationshipXRef = kv.remove("superRelationshipUUID")
  	    val Pair<ReifiedRelationship, Map<String, String>> superRelationshipPair = reifiedRelationships.get(superRelationshipXRef)
  	    if (null === superRelationshipPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for superRelationship in reifiedRelationshipSpecializationAxioms")
  	    oml.superRelationship = superRelationshipPair.key
  	    val String subRelationshipXRef = kv.remove("subRelationshipUUID")
  	    val Pair<ReifiedRelationship, Map<String, String>> subRelationshipPair = reifiedRelationships.get(subRelationshipXRef)
  	    if (null === subRelationshipPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for subRelationship in reifiedRelationshipSpecializationAxioms")
  	    oml.subRelationship = subRelationshipPair.key
  	  }
  	]
  }
  
  protected def void resolveSubDataPropertyOfAxioms(ResourceSet rs) {
  	subDataPropertyOfAxioms.forEach[uuid, oml_kv |
  	  val SubDataPropertyOfAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in subDataPropertyOfAxioms")
  	    oml.tbox = tboxPair.key
  	    val String subPropertyXRef = kv.remove("subPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> subPropertyPair = entityScalarDataProperties.get(subPropertyXRef)
  	    if (null === subPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for subProperty in subDataPropertyOfAxioms")
  	    oml.subProperty = subPropertyPair.key
  	    val String superPropertyXRef = kv.remove("superPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> superPropertyPair = entityScalarDataProperties.get(superPropertyXRef)
  	    if (null === superPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for superProperty in subDataPropertyOfAxioms")
  	    oml.superProperty = superPropertyPair.key
  	  }
  	]
  }
  
  protected def void resolveSubObjectPropertyOfAxioms(ResourceSet rs) {
  	subObjectPropertyOfAxioms.forEach[uuid, oml_kv |
  	  val SubObjectPropertyOfAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String tboxXRef = kv.remove("tboxUUID")
  	    val Pair<TerminologyBox, Map<String, String>> tboxPair = terminologyBoxes.get(tboxXRef)
  	    if (null === tboxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for tbox in subObjectPropertyOfAxioms")
  	    oml.tbox = tboxPair.key
  	    val String subPropertyXRef = kv.remove("subPropertyUUID")
  	    val Pair<UnreifiedRelationship, Map<String, String>> subPropertyPair = unreifiedRelationships.get(subPropertyXRef)
  	    if (null === subPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for subProperty in subObjectPropertyOfAxioms")
  	    oml.subProperty = subPropertyPair.key
  	    val String superPropertyXRef = kv.remove("superPropertyUUID")
  	    val Pair<UnreifiedRelationship, Map<String, String>> superPropertyPair = unreifiedRelationships.get(superPropertyXRef)
  	    if (null === superPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for superProperty in subObjectPropertyOfAxioms")
  	    oml.superProperty = superPropertyPair.key
  	  }
  	]
  }
  
  protected def void resolveRootConceptTaxonomyAxioms(ResourceSet rs) {
  	rootConceptTaxonomyAxioms.forEach[uuid, oml_kv |
  	  val RootConceptTaxonomyAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String bundleXRef = kv.remove("bundleUUID")
  	    val Pair<Bundle, Map<String, String>> bundlePair = bundles.get(bundleXRef)
  	    if (null === bundlePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for bundle in rootConceptTaxonomyAxioms")
  	    oml.bundle = bundlePair.key
  	    val String rootXRef = kv.remove("rootUUID")
  	    val Pair<Concept, Map<String, String>> rootPair = concepts.get(rootXRef)
  	    if (null === rootPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for root in rootConceptTaxonomyAxioms")
  	    oml.root = rootPair.key
  	  }
  	]
  }
  
  protected def void resolveAnonymousConceptUnionAxioms(ResourceSet rs) {
  	anonymousConceptUnionAxioms.forEach[uuid, oml_kv |
  	  val AnonymousConceptUnionAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String disjointTaxonomyParentXRef = kv.remove("disjointTaxonomyParentUUID")
  	    val Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = conceptTreeDisjunctions.get(disjointTaxonomyParentXRef)
  	    if (null === disjointTaxonomyParentPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for disjointTaxonomyParent in anonymousConceptUnionAxioms")
  	    oml.disjointTaxonomyParent = disjointTaxonomyParentPair.key
  	  }
  	]
  }
  
  protected def void resolveSpecificDisjointConceptAxioms(ResourceSet rs) {
  	specificDisjointConceptAxioms.forEach[uuid, oml_kv |
  	  val SpecificDisjointConceptAxiom oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String disjointTaxonomyParentXRef = kv.remove("disjointTaxonomyParentUUID")
  	    val Pair<ConceptTreeDisjunction, Map<String, String>> disjointTaxonomyParentPair = conceptTreeDisjunctions.get(disjointTaxonomyParentXRef)
  	    if (null === disjointTaxonomyParentPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for disjointTaxonomyParent in specificDisjointConceptAxioms")
  	    oml.disjointTaxonomyParent = disjointTaxonomyParentPair.key
  	    val String disjointLeafXRef = kv.remove("disjointLeafUUID")
  	    val Pair<Concept, Map<String, String>> disjointLeafPair = concepts.get(disjointLeafXRef)
  	    if (null === disjointLeafPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for disjointLeaf in specificDisjointConceptAxioms")
  	    oml.disjointLeaf = disjointLeafPair.key
  	  }
  	]
  }
  
  protected def void resolveConceptInstances(ResourceSet rs) {
  	conceptInstances.forEach[uuid, oml_kv |
  	  val ConceptInstance oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.remove("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null === descriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in conceptInstances")
  	    oml.descriptionBox = descriptionBoxPair.key
  	    val String singletonConceptClassifierXRef = kv.remove("singletonConceptClassifierUUID")
  	    val Pair<Concept, Map<String, String>> singletonConceptClassifierPair = concepts.get(singletonConceptClassifierXRef)
  	    if (null === singletonConceptClassifierPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for singletonConceptClassifier in conceptInstances")
  	    oml.singletonConceptClassifier = singletonConceptClassifierPair.key
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipInstances(ResourceSet rs) {
  	reifiedRelationshipInstances.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipInstance oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.remove("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null === descriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstances")
  	    oml.descriptionBox = descriptionBoxPair.key
  	    val String singletonReifiedRelationshipClassifierXRef = kv.remove("singletonReifiedRelationshipClassifierUUID")
  	    val Pair<ReifiedRelationship, Map<String, String>> singletonReifiedRelationshipClassifierPair = reifiedRelationships.get(singletonReifiedRelationshipClassifierXRef)
  	    if (null === singletonReifiedRelationshipClassifierPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for singletonReifiedRelationshipClassifier in reifiedRelationshipInstances")
  	    oml.singletonReifiedRelationshipClassifier = singletonReifiedRelationshipClassifierPair.key
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipInstanceDomains(ResourceSet rs) {
  	reifiedRelationshipInstanceDomains.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipInstanceDomain oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.remove("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null === descriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstanceDomains")
  	    oml.descriptionBox = descriptionBoxPair.key
  	    val String reifiedRelationshipInstanceXRef = kv.remove("reifiedRelationshipInstanceUUID")
  	    val Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef)
  	    if (null === reifiedRelationshipInstancePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationshipInstance in reifiedRelationshipInstanceDomains")
  	    oml.reifiedRelationshipInstance = reifiedRelationshipInstancePair.key
  	    val String domainXRef = kv.remove("domainUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = conceptualEntitySingletonInstances.get(domainXRef)
  	    if (null === domainPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for domain in reifiedRelationshipInstanceDomains")
  	    oml.domain = domainPair.key
  	  }
  	]
  }
  
  protected def void resolveReifiedRelationshipInstanceRanges(ResourceSet rs) {
  	reifiedRelationshipInstanceRanges.forEach[uuid, oml_kv |
  	  val ReifiedRelationshipInstanceRange oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.remove("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null === descriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in reifiedRelationshipInstanceRanges")
  	    oml.descriptionBox = descriptionBoxPair.key
  	    val String reifiedRelationshipInstanceXRef = kv.remove("reifiedRelationshipInstanceUUID")
  	    val Pair<ReifiedRelationshipInstance, Map<String, String>> reifiedRelationshipInstancePair = reifiedRelationshipInstances.get(reifiedRelationshipInstanceXRef)
  	    if (null === reifiedRelationshipInstancePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for reifiedRelationshipInstance in reifiedRelationshipInstanceRanges")
  	    oml.reifiedRelationshipInstance = reifiedRelationshipInstancePair.key
  	    val String rangeXRef = kv.remove("rangeUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = conceptualEntitySingletonInstances.get(rangeXRef)
  	    if (null === rangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for range in reifiedRelationshipInstanceRanges")
  	    oml.range = rangePair.key
  	  }
  	]
  }
  
  protected def void resolveUnreifiedRelationshipInstanceTuples(ResourceSet rs) {
  	unreifiedRelationshipInstanceTuples.forEach[uuid, oml_kv |
  	  val UnreifiedRelationshipInstanceTuple oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.remove("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null === descriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in unreifiedRelationshipInstanceTuples")
  	    oml.descriptionBox = descriptionBoxPair.key
  	    val String unreifiedRelationshipXRef = kv.remove("unreifiedRelationshipUUID")
  	    val Pair<UnreifiedRelationship, Map<String, String>> unreifiedRelationshipPair = unreifiedRelationships.get(unreifiedRelationshipXRef)
  	    if (null === unreifiedRelationshipPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for unreifiedRelationship in unreifiedRelationshipInstanceTuples")
  	    oml.unreifiedRelationship = unreifiedRelationshipPair.key
  	    val String domainXRef = kv.remove("domainUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> domainPair = conceptualEntitySingletonInstances.get(domainXRef)
  	    if (null === domainPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for domain in unreifiedRelationshipInstanceTuples")
  	    oml.domain = domainPair.key
  	    val String rangeXRef = kv.remove("rangeUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> rangePair = conceptualEntitySingletonInstances.get(rangeXRef)
  	    if (null === rangePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for range in unreifiedRelationshipInstanceTuples")
  	    oml.range = rangePair.key
  	  }
  	]
  }
  
  protected def void resolveSingletonInstanceStructuredDataPropertyValues(ResourceSet rs) {
  	singletonInstanceStructuredDataPropertyValues.forEach[uuid, oml_kv |
  	  val SingletonInstanceStructuredDataPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.remove("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null === descriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in singletonInstanceStructuredDataPropertyValues")
  	    oml.descriptionBox = descriptionBoxPair.key
  	    val String singletonInstanceXRef = kv.remove("singletonInstanceUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = conceptualEntitySingletonInstances.get(singletonInstanceXRef)
  	    if (null === singletonInstancePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for singletonInstance in singletonInstanceStructuredDataPropertyValues")
  	    oml.singletonInstance = singletonInstancePair.key
  	    val String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID")
  	    val Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = dataRelationshipToStructures.get(structuredDataPropertyXRef)
  	    if (null === structuredDataPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for structuredDataProperty in singletonInstanceStructuredDataPropertyValues")
  	    oml.structuredDataProperty = structuredDataPropertyPair.key
  	  }
  	]
  }
  
  protected def void resolveSingletonInstanceScalarDataPropertyValues(ResourceSet rs) {
  	singletonInstanceScalarDataPropertyValues.forEach[uuid, oml_kv |
  	  val SingletonInstanceScalarDataPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String descriptionBoxXRef = kv.remove("descriptionBoxUUID")
  	    val Pair<DescriptionBox, Map<String, String>> descriptionBoxPair = descriptionBoxes.get(descriptionBoxXRef)
  	    if (null === descriptionBoxPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for descriptionBox in singletonInstanceScalarDataPropertyValues")
  	    oml.descriptionBox = descriptionBoxPair.key
  	    val String singletonInstanceXRef = kv.remove("singletonInstanceUUID")
  	    val Pair<ConceptualEntitySingletonInstance, Map<String, String>> singletonInstancePair = conceptualEntitySingletonInstances.get(singletonInstanceXRef)
  	    if (null === singletonInstancePair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for singletonInstance in singletonInstanceScalarDataPropertyValues")
  	    oml.singletonInstance = singletonInstancePair.key
  	    val String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID")
  	    val Pair<EntityScalarDataProperty, Map<String, String>> scalarDataPropertyPair = entityScalarDataProperties.get(scalarDataPropertyXRef)
  	    if (null === scalarDataPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for scalarDataProperty in singletonInstanceScalarDataPropertyValues")
  	    oml.scalarDataProperty = scalarDataPropertyPair.key
  	    val String valueTypeXRef = kv.remove("valueTypeUUID")
  	    if ("null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null === valueTypePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for valueType in singletonInstanceScalarDataPropertyValues")
  	      oml.valueType = valueTypePair.key
  	    }
  	  }
  	]
  }
  
  protected def void resolveStructuredDataPropertyTuples(ResourceSet rs) {
  	structuredDataPropertyTuples.forEach[uuid, oml_kv |
  	  val StructuredDataPropertyTuple oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID")
  	    val Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef)
  	    if (null === structuredDataPropertyContextPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for structuredDataPropertyContext in structuredDataPropertyTuples")
  	    oml.structuredDataPropertyContext = structuredDataPropertyContextPair.key
  	    val String structuredDataPropertyXRef = kv.remove("structuredDataPropertyUUID")
  	    val Pair<DataRelationshipToStructure, Map<String, String>> structuredDataPropertyPair = dataRelationshipToStructures.get(structuredDataPropertyXRef)
  	    if (null === structuredDataPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for structuredDataProperty in structuredDataPropertyTuples")
  	    oml.structuredDataProperty = structuredDataPropertyPair.key
  	  }
  	]
  }
  
  protected def void resolveScalarDataPropertyValues(ResourceSet rs) {
  	scalarDataPropertyValues.forEach[uuid, oml_kv |
  	  val ScalarDataPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String structuredDataPropertyContextXRef = kv.remove("structuredDataPropertyContextUUID")
  	    val Pair<SingletonInstanceStructuredDataPropertyContext, Map<String, String>> structuredDataPropertyContextPair = singletonInstanceStructuredDataPropertyContexts.get(structuredDataPropertyContextXRef)
  	    if (null === structuredDataPropertyContextPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for structuredDataPropertyContext in scalarDataPropertyValues")
  	    oml.structuredDataPropertyContext = structuredDataPropertyContextPair.key
  	    val String scalarDataPropertyXRef = kv.remove("scalarDataPropertyUUID")
  	    val Pair<DataRelationshipToScalar, Map<String, String>> scalarDataPropertyPair = dataRelationshipToScalars.get(scalarDataPropertyXRef)
  	    if (null === scalarDataPropertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for scalarDataProperty in scalarDataPropertyValues")
  	    oml.scalarDataProperty = scalarDataPropertyPair.key
  	    val String valueTypeXRef = kv.remove("valueTypeUUID")
  	    if ("null" != valueTypeXRef) {
  	      val Pair<DataRange, Map<String, String>> valueTypePair = dataRanges.get(valueTypeXRef)
  	      if (null === valueTypePair)
  	        throw new IllegalArgumentException("Null cross-reference lookup for valueType in scalarDataPropertyValues")
  	      oml.valueType = valueTypePair.key
  	    }
  	  }
  	]
  }
  
  protected def void resolveAnnotationPropertyValues(ResourceSet rs) {
  	annotationPropertyValues.forEach[uuid, oml_kv |
  	  val AnnotationPropertyValue oml = oml_kv.key
  	  val Map<String, String> kv = oml_kv.value
  	  if (!kv.empty) {
  	    val String subjectXRef = kv.remove("subjectUUID")
  	    val Pair<LogicalElement, Map<String, String>> subjectPair = logicalElements.get(subjectXRef)
  	    if (null === subjectPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for subject in annotationPropertyValues")
  	    oml.subject = subjectPair.key
  	    val String propertyXRef = kv.remove("propertyUUID")
  	    val Pair<AnnotationProperty, Map<String, String>> propertyPair = annotationProperties.get(propertyXRef)
  	    if (null === propertyPair)
  	      throw new IllegalArgumentException("Null cross-reference lookup for property in annotationPropertyValues")
  	    oml.property = propertyPair.key
  	  }
  	]
  }
  

  protected def OMLZipResource loadOMLZipResource(ResourceSet rs, URI uri) {
  	val r = rs.getResource(uri, true)
  	switch r {
  		OMLZipResource: {
  		  r.contents.get(0).eAllContents.forEach[e|
  		    switch e {
  	          TerminologyGraph: {
  	          	val pair = new Pair<TerminologyGraph, Map<String,String>>(e, Collections.emptyMap)
  	            terminologyGraphs.put(e.uuid(), pair)
  	            logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	            terminologyGraphs.put(e.iri(), pair)
  	            terminologyBoxes.put(e.uuid(), new Pair<TerminologyBox, Map<String,String>>(e, Collections.emptyMap))
  	            terminologyBoxes.put(e.iri(), new Pair<TerminologyBox, Map<String,String>>(e, Collections.emptyMap))
  	          }
  	          Bundle: {
  	          	val pair = new Pair<Bundle, Map<String,String>>(e, Collections.emptyMap)
  	            bundles.put(e.uuid(), pair)
  	            logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	            bundles.put(e.iri(), pair)
  	            terminologyBoxes.put(e.uuid(), new Pair<TerminologyBox, Map<String,String>>(e, Collections.emptyMap))
  	            terminologyBoxes.put(e.iri(), new Pair<TerminologyBox, Map<String,String>>(e, Collections.emptyMap))
  	          }
  	          DescriptionBox: {
  	          	val pair = new Pair<DescriptionBox, Map<String,String>>(e, Collections.emptyMap)
  	            descriptionBoxes.put(e.uuid(), pair)
  	            logicalElements.put(e.uuid(), new Pair<LogicalElement, Map<String,String>>(e, Collections.emptyMap))
  	            descriptionBoxes.put(e.iri(), pair)
  	          }
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
  		    	}
  		  ]
  		  return r
  		}
  		default:
  		  throw new IllegalArgumentException("OMLTables.loadOMLZipResource("+uri+") should have produce an OMLZipResource!")
    }
  }
  
}
