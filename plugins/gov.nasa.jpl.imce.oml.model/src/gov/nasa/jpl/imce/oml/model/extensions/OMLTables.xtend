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
package gov.nasa.jpl.imce.oml.model.extensions

import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.CommonFactory
import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.common.LiteralBoolean
import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal
import gov.nasa.jpl.imce.oml.model.common.LiteralFloat
import gov.nasa.jpl.imce.oml.model.common.LiteralNumber
import gov.nasa.jpl.imce.oml.model.common.LiteralRational
import gov.nasa.jpl.imce.oml.model.common.LiteralReal
import gov.nasa.jpl.imce.oml.model.common.LiteralString
import gov.nasa.jpl.imce.oml.model.common.LiteralURI
import gov.nasa.jpl.imce.oml.model.common.LiteralUUID
import gov.nasa.jpl.imce.oml.model.common.LiteralValue
import gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue
import gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue
import gov.nasa.jpl.imce.oml.model.datatypes.FloatValue
import gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue
import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue
import gov.nasa.jpl.imce.oml.model.datatypes.RationalValue
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue
import gov.nasa.jpl.imce.oml.model.datatypes.RealValue
import gov.nasa.jpl.imce.oml.model.datatypes.URIValue
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionKind
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
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
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Predicate
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Structure
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyKind
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
import java.util.ArrayList
import java.util.Comparator
import java.util.List
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Collectors
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedAspect
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedConcept
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictionKind

/**
 * OMLTables is a collection of extension queries for OML Extent and conversion methods for OML values.
 * 
 * These queries are used in OMLSpecificationTables.save(Extent, ZipArchiveOutputStream).
 * The value conversion methods are used in several OMLSpecificationTables.read*(Stream<String>) methods.
 */
class OMLTables {
	
  static def <T extends CrossReferencabilityKind> Comparator<T> crossReferencabilityComparator() {
  	new Comparator<T> {
  		override int compare(T t1, T t2) {
  			t1.uuid().compareTo(t2.uuid())
  		}
  	}
  }
  
  static def List<AnnotationProperty> annotationProperties(Extent e) {
  	val ArrayList<AnnotationProperty> result = new ArrayList<AnnotationProperty>()
  	e.modules.forEach[m|result.addAll(m.annotationProperties)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<AnnotationPropertyValue> annotationPropertyValues(Extent e) {
  	val List<AnnotationPropertyValue> result = new ArrayList<AnnotationPropertyValue>()
  	result.addAll(e.eAllContents.filter(AnnotationPropertyValue).toIterable)
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  // modules
  
  static def List<TerminologyGraph> terminologyGraphs(Extent e) {
  	val List<TerminologyGraph> result = new ArrayList<TerminologyGraph>()
  	result.addAll(e.modules.filter(TerminologyGraph))
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<Bundle> bundles(Extent e) {
  	val List<Bundle> result = new ArrayList<Bundle>()
  	result.addAll(e.modules.filter(Bundle))
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<DescriptionBox> descriptionBoxes(Extent e) {
  	val List<DescriptionBox> result = new ArrayList<DescriptionBox>()
  	result.addAll(e.modules.filter(DescriptionBox))
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<TerminologyBox> terminologies(Extent e) {
  	val List<TerminologyBox> result = new ArrayList<TerminologyBox>()
  	result.addAll(e.modules.filter(TerminologyBox))
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  // module edges
  
  static def List<TerminologyExtensionAxiom> terminologyExtensionAxioms(Extent e) {
  	val List<TerminologyExtensionAxiom> result = new ArrayList<TerminologyExtensionAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxAxioms.filter(TerminologyExtensionAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<TerminologyNestingAxiom> terminologyNestingAxioms(Extent e) {
  	val List<TerminologyNestingAxiom> result = new ArrayList<TerminologyNestingAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxAxioms.filter(TerminologyNestingAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ConceptDesignationTerminologyAxiom> conceptDesignationTerminologyAxioms(Extent e) {
  	val List<ConceptDesignationTerminologyAxiom> result = new ArrayList<ConceptDesignationTerminologyAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxAxioms.filter(ConceptDesignationTerminologyAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<BundledTerminologyAxiom> bundledTerminologyAxioms(Extent e) {
  	val List<BundledTerminologyAxiom> result = new ArrayList<BundledTerminologyAxiom>()
  	e.bundles.forEach[b | result.addAll(b.bundleAxioms.filter(BundledTerminologyAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<DescriptionBoxExtendsClosedWorldDefinitions> descriptionBoxExtendsClosedWorldDefinitions(Extent e) {
  	val List<DescriptionBoxExtendsClosedWorldDefinitions> result = new ArrayList<DescriptionBoxExtendsClosedWorldDefinitions>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.closedWorldDefinitions)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<DescriptionBoxRefinement> descriptionBoxRefinements(Extent e) {
  	val List<DescriptionBoxRefinement> result = new ArrayList<DescriptionBoxRefinement>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.descriptionBoxRefinements)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  // Terms
  
  static def List<Aspect> aspects(Extent e) {
  	val List<Aspect> result = new ArrayList<Aspect>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(Aspect))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<CardinalityRestrictedAspect> cardinalityRestrictedAspects(Extent e) {
  	val List<CardinalityRestrictedAspect> result = new ArrayList<CardinalityRestrictedAspect>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(CardinalityRestrictedAspect))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<Concept> concepts(Extent e) {
  	val List<Concept> result = new ArrayList<Concept>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(Concept))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<CardinalityRestrictedConcept> cardinalityRestrictedConcepts(Extent e) {
  	val List<CardinalityRestrictedConcept> result = new ArrayList<CardinalityRestrictedConcept>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(CardinalityRestrictedConcept))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ReifiedRelationshipRestriction> reifiedRelationshipRestrictions(Extent e) {
  	val List<ReifiedRelationshipRestriction> result = new ArrayList<ReifiedRelationshipRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(ReifiedRelationshipRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<CardinalityRestrictedReifiedRelationship> cardinalityRestrictedReifiedRelationships(Extent e) {
  	val List<CardinalityRestrictedReifiedRelationship> result = new ArrayList<CardinalityRestrictedReifiedRelationship>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(CardinalityRestrictedReifiedRelationship))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ReifiedRelationship> reifiedRelationships(Extent e) {
  	val List<ReifiedRelationship> result = new ArrayList<ReifiedRelationship>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(ReifiedRelationship))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def Iterable<ForwardProperty> forwardProperties(Extent e) {
  	val List<ForwardProperty> result = new ArrayList<ForwardProperty>()
  	result.addAll(reifiedRelationships(e).map[forwardProperty].filterNull)
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def Iterable<InverseProperty> inverseProperties(Extent e) {
  	val List<InverseProperty> result = new ArrayList<InverseProperty>()
  	result.addAll(reifiedRelationships(e).map[inverseProperty].filterNull)
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<UnreifiedRelationship> unreifiedRelationships(Extent e) {
  	val List<UnreifiedRelationship> result = new ArrayList<UnreifiedRelationship>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(UnreifiedRelationship))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<Scalar> scalars(Extent e) {
  	val List<Scalar> result = new ArrayList<Scalar>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(Scalar))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<Structure> structures(Extent e) {
  	val List<Structure> result = new ArrayList<Structure>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(Structure))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<BinaryScalarRestriction> binaryScalarRestrictions(Extent e) {
  	val List<BinaryScalarRestriction> result = new ArrayList<BinaryScalarRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(BinaryScalarRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<IRIScalarRestriction> iriScalarRestrictions(Extent e) {
  	val List<IRIScalarRestriction> result = new ArrayList<IRIScalarRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(IRIScalarRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<NumericScalarRestriction> numericScalarRestrictions(Extent e) {
  	val List<NumericScalarRestriction> result = new ArrayList<NumericScalarRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(NumericScalarRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<PlainLiteralScalarRestriction> plainLiteralScalarRestrictions(Extent e) {
  	val List<PlainLiteralScalarRestriction> result = new ArrayList<PlainLiteralScalarRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(PlainLiteralScalarRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ScalarOneOfRestriction> scalarOneOfRestrictions(Extent e) {
  	val List<ScalarOneOfRestriction> result = new ArrayList<ScalarOneOfRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(ScalarOneOfRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ScalarOneOfLiteralAxiom> scalarOneOfLiteralAxioms(Extent e) {
  	val List<ScalarOneOfLiteralAxiom> result = new ArrayList<ScalarOneOfLiteralAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(ScalarOneOfLiteralAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<StringScalarRestriction> stringScalarRestrictions(Extent e) {
  	val List<StringScalarRestriction> result = new ArrayList<StringScalarRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(StringScalarRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<SynonymScalarRestriction> synonymScalarRestrictions(Extent e) {
  	val List<SynonymScalarRestriction> result = new ArrayList<SynonymScalarRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(SynonymScalarRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<TimeScalarRestriction> timeScalarRestrictions(Extent e) {
  	val List<TimeScalarRestriction> result = new ArrayList<TimeScalarRestriction>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(TimeScalarRestriction))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  // data property terms
  
  static def List<EntityScalarDataProperty> entityScalarDataProperties(Extent e) {
  	val List<EntityScalarDataProperty> result = new ArrayList<EntityScalarDataProperty>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(EntityScalarDataProperty))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<EntityStructuredDataProperty> entityStructuredDataProperties(Extent e) {
  	val List<EntityStructuredDataProperty> result = new ArrayList<EntityStructuredDataProperty>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(EntityStructuredDataProperty))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ScalarDataProperty> scalarDataProperties(Extent e) {
  	val List<ScalarDataProperty> result = new ArrayList<ScalarDataProperty>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(ScalarDataProperty))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<StructuredDataProperty> structuredDataProperties(Extent e) {
  	val List<StructuredDataProperty> result = new ArrayList<StructuredDataProperty>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(StructuredDataProperty))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  // specialization axioms
  
  static def List<AspectSpecializationAxiom> aspectSpecializationAxioms(Extent e) {
  	val List<AspectSpecializationAxiom> result = new ArrayList<AspectSpecializationAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(AspectSpecializationAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ConceptSpecializationAxiom> conceptSpecializationAxioms(Extent e) {
  	val List<ConceptSpecializationAxiom> result = new ArrayList<ConceptSpecializationAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(ConceptSpecializationAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ReifiedRelationshipSpecializationAxiom> reifiedRelationshipSpecializationAxioms(Extent e) {
  	val List<ReifiedRelationshipSpecializationAxiom> result = new ArrayList<ReifiedRelationshipSpecializationAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(ReifiedRelationshipSpecializationAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<SubDataPropertyOfAxiom> subDataPropertyOfAxioms(Extent e) {
  	val List<SubDataPropertyOfAxiom> result = new ArrayList<SubDataPropertyOfAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(SubDataPropertyOfAxiom)) ]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<SubObjectPropertyOfAxiom> subObjectPropertyOfAxioms(Extent e) {
  	val List<SubObjectPropertyOfAxiom> result = new ArrayList<SubObjectPropertyOfAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(SubObjectPropertyOfAxiom)) ]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<EntityExistentialRestrictionAxiom> entityExistentialRestrictionAxioms(Extent e) {
  	val List<EntityExistentialRestrictionAxiom> result = new ArrayList<EntityExistentialRestrictionAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(EntityExistentialRestrictionAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<EntityUniversalRestrictionAxiom> entityUniversalRestrictionAxioms(Extent e) {
  	val List<EntityUniversalRestrictionAxiom> result = new ArrayList<EntityUniversalRestrictionAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(EntityUniversalRestrictionAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<EntityScalarDataPropertyExistentialRestrictionAxiom> entityScalarDataPropertyExistentialRestrictionAxioms(Extent e) {
  	val List<EntityScalarDataPropertyExistentialRestrictionAxiom> result = new ArrayList<EntityScalarDataPropertyExistentialRestrictionAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(EntityScalarDataPropertyExistentialRestrictionAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<EntityScalarDataPropertyParticularRestrictionAxiom> entityScalarDataPropertyParticularRestrictionAxioms(Extent e) {
  	val List<EntityScalarDataPropertyParticularRestrictionAxiom> result = new ArrayList<EntityScalarDataPropertyParticularRestrictionAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(EntityScalarDataPropertyParticularRestrictionAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<EntityScalarDataPropertyUniversalRestrictionAxiom> entityScalarDataPropertyUniversalRestrictionAxioms(Extent e) {
  	val List<EntityScalarDataPropertyUniversalRestrictionAxiom> result = new ArrayList<EntityScalarDataPropertyUniversalRestrictionAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(EntityScalarDataPropertyUniversalRestrictionAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<EntityStructuredDataPropertyParticularRestrictionAxiom> entityStructuredDataPropertyParticularRestrictionAxioms(Extent e) {
  	val List<EntityStructuredDataPropertyParticularRestrictionAxiom> result = new ArrayList<EntityStructuredDataPropertyParticularRestrictionAxiom>()
  	e.terminologies.forEach[tbox | result.addAll(tbox.boxStatements.filter(EntityStructuredDataPropertyParticularRestrictionAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  // disjunctions
  
  static def List<RootConceptTaxonomyAxiom> rootConceptTaxonomyAxioms(Extent e) {
  	val List<RootConceptTaxonomyAxiom> result = new ArrayList<RootConceptTaxonomyAxiom>()
  	e.bundles.forEach[b | result.addAll(b.bundleStatements.filter(RootConceptTaxonomyAxiom))]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<SpecificDisjointConceptAxiom> specificDisjointConceptAxioms(Extent e) {
  	val List<SpecificDisjointConceptAxiom> result = new ArrayList<SpecificDisjointConceptAxiom>()
  	e.bundles.forEach[b | b.boxStatements.filter(RootConceptTaxonomyAxiom).forEach[r |
  		result.addAll(r.allNestedElements.filter(SpecificDisjointConceptAxiom))
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<AnonymousConceptUnionAxiom> anonymousConceptUnionAxioms(Extent e) {
  	val List<AnonymousConceptUnionAxiom> result = new ArrayList<AnonymousConceptUnionAxiom>()
  	e.bundles.forEach[b | b.boxStatements.filter(RootConceptTaxonomyAxiom).forEach[r |
  		result.addAll(r.allNestedElements.filter(AnonymousConceptUnionAxiom))
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  // chain rules
  
  static def List<ChainRule> chainRules(Extent e) {
  	val List<ChainRule> result = new ArrayList<ChainRule>()
  	e.terminologyGraphs.forEach[b | result.addAll(b.boxStatements.filter(ChainRule)) ]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<RuleBodySegment> ruleBodySegments(Extent e) {
  	val List<RuleBodySegment> result = new ArrayList<RuleBodySegment>()
  	e.terminologyGraphs.forEach[b | b.boxStatements.filter(ChainRule).forEach[r |
  		result.addAll(r.allNestedElements.filter(RuleBodySegment))
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<SegmentPredicate> segmentPredicates(Extent e) {
  	val List<SegmentPredicate> result = new ArrayList<SegmentPredicate>()
  	e.terminologyGraphs.forEach[b | b.boxStatements.filter(ChainRule).forEach[r |
  		result.addAll(r.allNestedElements.filter(SegmentPredicate))
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<Predicate> predicates(Extent e) {
  	val List<Predicate> result = new ArrayList<Predicate>()
  	e.terminologyGraphs.forEach[t | t.boxStatements.filter(Predicate).forEach[p |
  		result.addAll(p)
  	]]
  	e.terminologyGraphs.forEach[t | t.boxStatements.filter(ReifiedRelationship).forEach[rr |
  		result.add(rr.forwardProperty)
  		if (null !== rr.inverseProperty) result.add(rr.inverseProperty)
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  // instances
  
  static def List<ConceptInstance> conceptInstances(Extent e) {
  	val List<ConceptInstance> result = new ArrayList<ConceptInstance>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.conceptInstances)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ReifiedRelationshipInstance> reifiedRelationshipInstances(Extent e) {
  	val List<ReifiedRelationshipInstance> result = new ArrayList<ReifiedRelationshipInstance>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.reifiedRelationshipInstances)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ReifiedRelationshipInstanceDomain> reifiedRelationshipInstanceDomains(Extent e) {
  	val List<ReifiedRelationshipInstanceDomain> result = new ArrayList<ReifiedRelationshipInstanceDomain>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.reifiedRelationshipInstanceDomains)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ReifiedRelationshipInstanceRange> reifiedRelationshipInstanceRanges(Extent e) {
  	val List<ReifiedRelationshipInstanceRange> result = new ArrayList<ReifiedRelationshipInstanceRange>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.reifiedRelationshipInstanceRanges)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<RestrictionScalarDataPropertyValue> restrictionScalarDataPropertyValues(Extent e) {
  	val List<RestrictionScalarDataPropertyValue> result = new ArrayList<RestrictionScalarDataPropertyValue>()
  	e.terminologyGraphs.forEach[b | b.boxStatements.filter(EntityStructuredDataPropertyParticularRestrictionAxiom).forEach[r |
  		result.addAll(r.allNestedElements.filter(RestrictionScalarDataPropertyValue))
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<RestrictionStructuredDataPropertyTuple> restrictionStructuredDataPropertyTuples(Extent e) {
  	val List<RestrictionStructuredDataPropertyTuple> result = new ArrayList<RestrictionStructuredDataPropertyTuple>()
  	e.terminologyGraphs.forEach[b | b.boxStatements.filter(EntityStructuredDataPropertyParticularRestrictionAxiom).forEach[r |
  		result.addAll(r.allNestedElements.filter(RestrictionStructuredDataPropertyTuple))
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<ScalarDataPropertyValue> scalarDataPropertyValues(Extent e) {
  	val List<ScalarDataPropertyValue> result = new ArrayList<ScalarDataPropertyValue>()
  	e.descriptionBoxes.forEach[dbox | dbox.singletonStructuredDataPropertyValues.forEach[s|
  		result.addAll(s.allNestedElements.filter(ScalarDataPropertyValue))
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<SingletonInstanceScalarDataPropertyValue> singletonInstanceScalarDataPropertyValues(Extent e) {
  	val List<SingletonInstanceScalarDataPropertyValue> result = new ArrayList<SingletonInstanceScalarDataPropertyValue>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.singletonScalarDataPropertyValues)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<SingletonInstanceStructuredDataPropertyValue> singletonInstanceStructuredDataPropertyValues(Extent e) {
  	val List<SingletonInstanceStructuredDataPropertyValue> result = new ArrayList<SingletonInstanceStructuredDataPropertyValue>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.singletonStructuredDataPropertyValues)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<StructuredDataPropertyTuple> structuredDataPropertyTuples(Extent e) {
  	val List<StructuredDataPropertyTuple> result = new ArrayList<StructuredDataPropertyTuple>()
  	e.descriptionBoxes.forEach[dbox | dbox.singletonStructuredDataPropertyValues.forEach[s|
  		result.addAll(s.allNestedElements.filter(StructuredDataPropertyTuple))
  	]]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
  
  static def List<UnreifiedRelationshipInstanceTuple> unreifiedRelationshipInstanceTuples(Extent e) {
  	val List<UnreifiedRelationshipInstanceTuple> result = new ArrayList<UnreifiedRelationshipInstanceTuple>()
  	e.descriptionBoxes.forEach[dbox | result.addAll(dbox.unreifiedRelationshipInstanceTuples)]
  	result.parallelStream.sorted(crossReferencabilityComparator()).collect(Collectors.toList)
  }
	
  public static val char QUOTE = '"'
  public static val char NEWLINE = '\n'
  public static val char LINEFEED = '\r'
  
  protected static def String toStringArray(String rawString) {
		if (null === rawString || rawString.empty) {
			'''[""]'''
		} else {
			val buffer = new StringBuffer()
			buffer.append("[")
			var value = rawString
			var empty = true
			var continue = true
			do {
				val qi = value.indexOf(QUOTE)
				val ni = value.indexOf(NEWLINE)
				val li = value.indexOf(LINEFEED)

				if (0 == qi) {
					if (empty) empty = false else buffer.append(",")
					buffer.append('''"\""''')
					value = value.substring(1)
				} else if (0 == ni) {
					if (empty) empty = false else buffer.append(",")
					buffer.append('''"\n"''')
					value = value.substring(1)
				} else if (0 == li) {
					if (empty) empty = false else buffer.append(",")
					buffer.append('''"\r"''')
					value = value.substring(1)
				} else if (0 < qi && (-1 == ni || qi < ni) && (-1 == li || qi < li)) {
					if (empty) empty = false else buffer.append(",")
					buffer.append('''"«value.substring(0, qi)»","\""''')
					value = value.substring(qi + 1)
				} else if (0 < ni && (-1 == qi || ni < qi) && (-1 == li || ni < li)) {
					if (empty) empty = false else buffer.append(",")
					buffer.append('''"«value.substring(0, ni)»","\n"''')
					value = value.substring(ni + 1)
				} else if (0 < li && (-1 == qi || li < qi) && (-1 == ni || li < ni)) {
					if (empty) empty = false else buffer.append(",")
					buffer.append('''"«value.substring(0,li)»","\r"''')
					value = value.substring(li + 1)
				} else {
					if (empty) empty = false else buffer.append(",")
					buffer.append('''"«value»"]''')
					continue=false
				}
			} while (continue)
			buffer.toString
		}
	}
  
  static def dispatch String toString(PatternValue value) {
  	toStringArray(value.value)
  }
  
  static def dispatch String toString(LiteralString value) {
  	toStringArray(value.value)
  }
  
  static def dispatch String toString(String value) {
  	val qi = value.indexOf(QUOTE)
	val ni = value.indexOf(NEWLINE)
	val li = value.indexOf(LINEFEED)
	
	if (qi > 0 || ni > 0 || li > 0)
		toStringArray(value)
	else	
  		"\"" + value + "\""
  }
  
  static def dispatch String toString(LanguageTagValue value) {
  	"\"" + value.value + "\""
  }

  static def dispatch String toString(PositiveIntegerValue value) {
  	"\"" + value.value + "\""
  }
  
  static def dispatch String toString(LiteralNumber value) {
  	switch value {
  		LiteralDecimal:
  		  switch value.decimal {
  		  	DecimalValue:
  		  		'''{"literalType":"LiteralDecimalType","value":"«value.value»"}'''
  		  	PositiveIntegerValue:
  		  		'''{"literalType":"LiteralPositiveIntegerType","value":"«value.value»"}'''
  		  }
  		LiteralFloat:
  		  '''{"literalType":"LiteralFloatType","value":"«value.value»"}'''
  		LiteralRational:
  		  '''{"literalType":"LiteralRationalType","value":"«value.value»"}'''
  		LiteralReal:
  		  '''{"literalType":"LiteralRealType","value":"«value.value»"}'''
  	}
  }
  
  static def dispatch String toString(LiteralValue value) {
  	switch value {
  		LiteralBoolean:
  			 '''«value.value»'''
  		LiteralDateTime:
  			 '''{"literalType":"LiteralDateTimeType","value":"«value.value»"}'''
  		LiteralString:
  			 toStringArray(value.value)
  		LiteralUUID:
  			 '''{"literalType":"LiteralUUIDType","value":"«value.value»"}'''
  		LiteralURI:
  			 '''{"literalType":"LiteralURIType","value":"«value.value»"}'''
  		LiteralNumber:
  			toString(value)
  	}
  }
  
  static def dispatch String toString(DescriptionKind value) {
  	"\"" + value.toString + "\""
  }
  
  static def dispatch String toString(TerminologyKind value) {
  	"\"" + value.toString + "\""
  }
  
  static def dispatch String toString(LiteralURI value) {
  	"\"" + value.uri.value + "\""
  }
  
  static def dispatch String toString(LiteralUUID value) {
  	"\"" + value.uuid.toString + "\""
  }
  
  static def Boolean toEBoolean(String value) {
	return Boolean.parseBoolean(value)
  }
  
  static def String toAbbrevIRI(String value) {
	return value
  }
  
  static def String toIRI(String value) {
	return value
  }
  
  static def LanguageTagValue toLanguageTagDataType(String value) {
	return new LanguageTagValue(value)
  }
  
  static def String toLocalName(String value) {
	return value
  }
  
  static def PatternValue toLiteralPattern(String value) {
	return new PatternValue(value)
  }
  
  static def PositiveIntegerValue toPositiveIntegerLiteral(String value) {
	return new PositiveIntegerValue(value)
  }
  
  static def LiteralDateTime toLiteralDateTime(String value) {
	val lit = CommonFactory.eINSTANCE.createLiteralDateTime()
	lit.dateTime = new DateTimeValue(value)
	return lit
  }
  
  static def LiteralString toLiteralString(String value) {
	val lit = CommonFactory.eINSTANCE.createLiteralRawString()
	lit.string = new RawStringValue(value)
	return lit
  }
  
  public static val Pattern LiteralNumberOrValue = Pattern.compile("(\\{\"literalType\":\"(.*)\",\"value\":(\"(.*)\"|\\[\"(\\\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\\\"|\\n|\\r|[^\"]+?)\")*\\])\\}|\\[\"(\\\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\\\"|\\n|\\r|[^\"]+?)\")*\\])")
  public static val Pattern StringArray = Pattern.compile("\"(\\\\\\\"|\\n|\\r|[^\"]+?)\",?")
  
  static def String toValue(Matcher m) {
		if (null !== m.group(4) && !m.group(4).empty)
			m.group(4)
		else {
			val stringArray = if (null === m.group(2) || m.group(2).empty) m.group(1) else m.group(3)
			if (!stringArray.startsWith("["))
				throw new IllegalArgumentException('''toValue(«stringArray») should start with '['. ''')
			if (!stringArray.endsWith("]"))
				throw new IllegalArgumentException('''toValue(«stringArray») should end with ']'. ''')
			val buffer = new StringBuffer()
			val a = StringArray.matcher(stringArray.substring(1, stringArray.length-1))
			while (a.find()) {
				val part = a.group(1)
				if ("\\\\n" == part)
					buffer.append(NEWLINE)
				else if ("\\\\r" == part)
					buffer.append(LINEFEED)
				else if ("\\\"" == part)
					buffer.append(QUOTE)
				else
					buffer.append(part)
			}
			buffer.toString
		}
	}
  
  static def LiteralNumber toLiteralNumber(String value) {
  	val Matcher m = LiteralNumberOrValue.matcher(value ?: "")
  	if (m.find) {
  		val litType = m.group(2) ?: ""
  		val litValue = toValue(m)
  		switch litType {
  			case "LiteralDecimalType": {
  				val lit = CommonFactory.eINSTANCE.createLiteralDecimal
  				lit.decimal = new DecimalValue(litValue)
  				lit
  				}
  			case "LiteralPositiveIntegerType": {
  				val lit = CommonFactory.eINSTANCE.createLiteralDecimal
  				lit.decimal = new PositiveIntegerValue(litValue)
  				lit
  				}
  		  	case "LiteralFloatType": {
  		  		val lit = CommonFactory.eINSTANCE.createLiteralFloat
  				lit.float = new FloatValue(litValue)
  				lit
  		  		}
  		  	case "LiteralRationalType": {
  		  		val lit = CommonFactory.eINSTANCE.createLiteralRational
  				lit.rational = new RationalValue(litValue)
  				lit
  		  		}
  			case "LiteralRealType": {
  				val lit = CommonFactory.eINSTANCE.createLiteralReal
  				lit.real = new RealValue(litValue)
  				lit
  				}
  			default:
 				throw new IllegalArgumentException("OMLTables.toLiteralNumber(value): unrecognized type: "+litType)
  		}
  	} else
		throw new IllegalArgumentException("OMLTables.toLiteralNumber(value): ill-formed value="+value)
  }
  
  static def LiteralValue toLiteralValue(String value) {
		if (null === value || value.empty) {
			val lit = CommonFactory.eINSTANCE.createLiteralRawString
			lit.string = new RawStringValue("")
			lit
		} else {
			val m = LiteralNumberOrValue.matcher(value)
			if (m.find) {
				val litType = m.group(2) ?: ""
				val litValue = toValue(m)
				switch litType {
					case "LiteralBooleanType": {
						val lit = CommonFactory.eINSTANCE.createLiteralBoolean
						lit.bool = Boolean.parseBoolean(litValue)
						lit
					}
					case "LiteralDateTimeType": {
						val lit = CommonFactory.eINSTANCE.createLiteralDateTime
						lit.dateTime = new DateTimeValue(litValue)
						lit
					}
					case "LiteralStringType": {
						val lit = CommonFactory.eINSTANCE.createLiteralRawString
						lit.string = new RawStringValue(litValue)
						lit
					}
					case "LiteralUUIDType": {
						val lit = CommonFactory.eINSTANCE.createLiteralRawString
						lit.string = new RawStringValue(litValue)
						lit
					}
					case "LiteralURIType": {
						val lit = CommonFactory.eINSTANCE.createLiteralURI
						lit.uri = new URIValue(litValue)
						lit
					}
					case "LiteralDecimalType": {
						val lit = CommonFactory.eINSTANCE.createLiteralDecimal
						lit.decimal = new DecimalValue(litValue)
						lit
					}
					case "LiteralPositiveIntegerType": {
						val lit = CommonFactory.eINSTANCE.createLiteralDecimal
						lit.decimal = new PositiveIntegerValue(litValue)
						lit
					}
					case "LiteralFloatType": {
						val lit = CommonFactory.eINSTANCE.createLiteralFloat
						lit.float = new FloatValue(litValue)
						lit
					}
					case "LiteralRationalType": {
						val lit = CommonFactory.eINSTANCE.createLiteralRational
						lit.rational = new RationalValue(litValue)
						lit
					}
					case "LiteralRealType": {
						val lit = CommonFactory.eINSTANCE.createLiteralReal
						lit.real = new RealValue(litValue)
						lit
					}
					case "": {
						val lit = CommonFactory.eINSTANCE.createLiteralRawString
						lit.string = new RawStringValue(litValue)
						lit
					}
					default:
						throw new IllegalArgumentException('''OMLTables.toLiteralValue(value): unrecognized type: «litType» for value: «value»''')
				}
			} else
				throw new IllegalArgumentException('''OMLTables.toLiteralValue(value): ill-formed value=«value»''')
		}
	}
  
  static def DescriptionKind toDescriptionKind(String value) {
  	switch value {
  		case "Partial":
  			return DescriptionKind.PARTIAL
  		case "Final":
  			return DescriptionKind.FINAL
  		default:
  			throw new IllegalArgumentException(value +" is not a legal DescriptionKind")
  	}  
  }
  
  static def TerminologyKind toTerminologyKind(String value) {
  	switch value {
  		case "OpenWorldDefinitions":
  			return TerminologyKind.OPEN_WORLD_DEFINITIONS
  		case "ClosedWorldDesignations":
  			return TerminologyKind.CLOSED_WORLD_DESIGNATIONS
  		default:
  			throw new IllegalArgumentException(value +" is not a legal TerminologyKind")
  	}
  }
  
  static def CardinalityRestrictionKind toCardinalityRestrictionKind(String value) {
  	switch value {
  		case "<=":
  			return CardinalityRestrictionKind.MIN
  		case ">=":
  			return CardinalityRestrictionKind.MAX
  		case "==":
  			return CardinalityRestrictionKind.EXACT
  		default:
  			throw new IllegalArgumentException(value +" is not a legal CardinalityRestrictionKind")
  	}
  }
  
  static def dispatch String toString(CardinalityRestrictionKind value) {
  	switch value {
  		case CardinalityRestrictionKind.MIN:
  			'''"<="'''
  		case CardinalityRestrictionKind.MAX:
  			'''">="'''
  		case CardinalityRestrictionKind.EXACT:
  			'''"=="'''
  	}
  }
}