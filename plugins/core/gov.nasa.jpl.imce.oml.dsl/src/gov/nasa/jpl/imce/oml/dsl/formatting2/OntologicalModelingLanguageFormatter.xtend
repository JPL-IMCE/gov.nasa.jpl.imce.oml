/*
 * Copyright 2016 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.dsl.formatting2

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.dsl.services.OntologicalModelingLanguageGrammarAccess
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom
import gov.nasa.jpl.imce.oml.model.common.Annotation
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Structure
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple

class OntologicalModelingLanguageFormatter extends AbstractFormatter2 {
	
	@Inject extension OntologicalModelingLanguageGrammarAccess

	def dispatch void format(Extent extent, extension IFormattableDocument document) {
		extent.prepend[noSpace]
		extent.annotationProperties.forEach[format.append[setNewLines(2)]]
		val lastM = extent.modules.last
		extent.modules.forEach[m | m.format.append[setNewLines(if (lastM == m) 1 else 2)]]
	}

	def dispatch void format(AnnotationProperty annotationProperty, extension IFormattableDocument document) {
		annotationProperty.regionFor.keyword('annotationProperty').append[oneSpace]
		annotationProperty.regionFor.keyword('=').surround[noSpace]
	}
	
	def dispatch void format(Annotation annotation, extension IFormattableDocument document) {
		annotation.regionFor.keyword('@').append[noSpace]
		annotation.regionFor.keyword('=').surround[noSpace]
		annotation.regionFor.ruleCall(annotationAccess.valueSTRINGTerminalRuleCall_3_0)
	}
	
	def dispatch void format(TerminologyGraph terminologyGraph, extension IFormattableDocument document) {
		terminologyGraph.regionFor.feature(TerminologiesPackage.eINSTANCE.terminologyBox_Kind).append[oneSpace]
		terminologyGraph.regionFor.keyword('terminology').surround[oneSpace]
		terminologyGraph.regionFor.ruleCall(terminologyGraphAccess.iriIRITerminalRuleCall_2_0).surround[oneSpace]
	
		val lcurly = terminologyGraph.regionFor.keyword('{')
		val rcurly = terminologyGraph.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[setNewLines(2)]
		interior(lcurly, rcurly)[indent]
		
		terminologyGraph.annotations.forEach[format.append[setNewLines(1)]]
		terminologyGraph.boxAxioms.forEach[format.append[setNewLines(2)]]
		terminologyGraph.boxStatements.forEach[format.append[setNewLines(2)]]
	}
	
	def dispatch void format(Bundle bundle, extension IFormattableDocument document) {
		bundle.regionFor.feature(TerminologiesPackage.eINSTANCE.terminologyBox_Kind).append[oneSpace]
		bundle.regionFor.keyword('bundle').surround[oneSpace]
		bundle.regionFor.ruleCall(bundleAccess.iriIRITerminalRuleCall_2_0).surround[oneSpace]
		
		val lcurly = bundle.regionFor.keyword('{')
		val rcurly = bundle.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[setNewLines(2)]
		interior(lcurly, rcurly)[indent]
		
		bundle.annotations.forEach[format.append[setNewLines(1)]]
		bundle.boxAxioms.forEach[format.append[setNewLines(2)]]
		bundle.boxStatements.forEach[format.append[setNewLines(2)]]
		bundle.bundleAxioms.forEach[format.append[setNewLines(2)]]
		bundle.bundleStatements.forEach[format.append[setNewLines(2)]]
	}
	
	def dispatch void format(DescriptionBox descriptionBox, extension IFormattableDocument document) {
		descriptionBox.regionFor.feature(DescriptionsPackage.eINSTANCE.descriptionBox_Kind).append[oneSpace]
		descriptionBox.regionFor.keyword('descriptionBox').surround[oneSpace]
		descriptionBox.regionFor.ruleCall(descriptionBoxAccess.iriIRITerminalRuleCall_2_0).surround[oneSpace]
		
		val lcurly = descriptionBox.regionFor.keyword('{')
		val rcurly = descriptionBox.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[setNewLines(2)]
		interior(lcurly, rcurly)[indent]
		
		descriptionBox.annotations.forEach[format.append[setNewLines(1)]]
		descriptionBox.closedWorldDefinitions.forEach[format.append[setNewLines(2)]]
		descriptionBox.descriptionBoxRefinements.forEach[format.append[setNewLines(2)]]
		descriptionBox.conceptInstances.forEach[format.append[setNewLines(2)]]
		descriptionBox.reifiedRelationshipInstances.forEach[format.append[setNewLines(2)]]
		descriptionBox.reifiedRelationshipInstanceDomains.forEach[format.append[setNewLines(2)]]
		descriptionBox.reifiedRelationshipInstanceRanges.forEach[format.append[setNewLines(2)]]
		descriptionBox.unreifiedRelationshipInstanceTuples.forEach[format.append[setNewLines(2)]]
	}

	def dispatch void format(Aspect aspect, extension IFormattableDocument document) {
		aspect.regionFor.keyword('aspect').append[oneSpace]
		aspect.regionFor.ruleCall(aspectAccess.nameIDTerminalRuleCall_1_0)
	}
		
	def dispatch void format(Concept concept, extension IFormattableDocument document) {
		concept.regionFor.keyword('concept').append[oneSpace]
		concept.regionFor.ruleCall(conceptAccess.nameIDTerminalRuleCall_1_0)
	}
	
	def dispatch void format(ReifiedRelationship rr, extension IFormattableDocument document) {
		rr.regionFor.keyword('reifiedRelationship').append[oneSpace]
		rr.regionFor.ruleCall(reifiedRelationshipAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = rr.regionFor.keyword('{')
		val rcurly = rr.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		rr.regionFor.keyword('functional').prepend[newLine]
		rr.regionFor.keyword('inverseFunctional').prepend[newLine]
		rr.regionFor.keyword('essential').prepend[newLine]
		rr.regionFor.keyword('inverseEssential').prepend[newLine]
		rr.regionFor.keyword('symmetric').prepend[newLine]
		rr.regionFor.keyword('asymmetric').prepend[newLine]
		rr.regionFor.keyword('reflexive').prepend[newLine]
		rr.regionFor.keyword('irreflexive').prepend[newLine]
		rr.regionFor.keyword('transitive').prepend[newLine]
		rr.regionFor.keyword('unreified').prepend[newLine]
		rr.regionFor.keyword('inverse').prepend[newLine]
		rr.regionFor.keyword('source').prepend[newLine]
		rr.regionFor.keyword('target').prepend[newLine]
	}
	
	def dispatch void format(UnreifiedRelationship ur, extension IFormattableDocument document) {
		ur.regionFor.keyword('unreifiedRelationship').append[oneSpace]
		ur.regionFor.ruleCall(unreifiedRelationshipAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = ur.regionFor.keyword('{')
		val rcurly = ur.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		ur.regionFor.keyword('functional').prepend[newLine]
		ur.regionFor.keyword('inverseFunctional').prepend[newLine]
		ur.regionFor.keyword('essential').prepend[newLine]
		ur.regionFor.keyword('inverseEssential').prepend[newLine]
		ur.regionFor.keyword('symmetric').prepend[newLine]
		ur.regionFor.keyword('asymmetric').prepend[newLine]
		ur.regionFor.keyword('reflexive').prepend[newLine]
		ur.regionFor.keyword('irreflexive').prepend[newLine]
		ur.regionFor.keyword('transitive').prepend[newLine]
		ur.regionFor.keyword('source').prepend[newLine]
		ur.regionFor.keyword('target').prepend[newLine]
	}
	
	def dispatch void format(Scalar scalar, extension IFormattableDocument document) {
		scalar.regionFor.keyword('scalar').append[oneSpace]
	}
	
	def dispatch void format(Structure structure, extension IFormattableDocument document) {
		structure.regionFor.keyword('structure').append[oneSpace]
	}
	
	def dispatch void format(AspectSpecializationAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('extendsAspect').surround[oneSpace]
	}
	
	def dispatch void format(ConceptSpecializationAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('extendsConcept').surround[oneSpace]
	}
	
	def dispatch void format(ReifiedRelationshipSpecializationAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('extendsRelationship').surround[oneSpace]
	}
	
	def dispatch void format(ConceptDesignationTerminologyAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('conceptDesignationTerminologyAxiom').append[oneSpace]
		
		val lcurly = ax.regionFor.keyword('{')
		val rcurly = ax.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		ax.regionFor.keyword('designatedTerminology').append[oneSpace]
		ax.regionFor.ruleCall(conceptDesignationTerminologyAxiomAccess.designatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1).append[newLine]
		ax.regionFor.keyword('designatedConcept').append[oneSpace]
		ax.regionFor.ruleCall(conceptDesignationTerminologyAxiomAccess.designatedConceptConceptReferenceParserRuleCall_5_0_1).append[newLine]
	}
	
	def dispatch void format(TerminologyExtensionAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('extends').append[oneSpace]
	}
	
	def dispatch void format(TerminologyNestingAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('terminologyNestingAxiom').append[oneSpace]
		
		val lcurly = ax.regionFor.keyword('{')
		val rcurly = ax.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		ax.regionFor.keyword('nestingTerminology').append[oneSpace]
		ax.regionFor.ruleCall(terminologyNestingAxiomAccess.nestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1).append[newLine]
		ax.regionFor.keyword('nestingContext').append[oneSpace]
		ax.regionFor.ruleCall(terminologyNestingAxiomAccess.nestingContextConceptReferenceParserRuleCall_5_0_1).append[newLine]
	}
	
	def dispatch void format(BundledTerminologyAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('bundles').append[oneSpace]
	}
	
	def dispatch void format(EntityStructuredDataProperty t, extension IFormattableDocument document) {
		t.regionFor.keyword('entityStructuredDataProperty').append[oneSpace]
		t.regionFor.assignment(entityStructuredDataPropertyAccess.isIdentityCriteriaAssignment_1).surround[oneSpace]
		
		val lcurly = t.regionFor.keyword('{')
		val rcurly = t.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		t.regionFor.keyword('domain').append[oneSpace]
		t.regionFor.ruleCall(entityStructuredDataPropertyAccess.domainEntityReferenceParserRuleCall_5_0_1).append[newLine]
		t.regionFor.keyword('range').append[oneSpace]
		t.regionFor.ruleCall(entityStructuredDataPropertyAccess.rangeStructureReferenceParserRuleCall_7_0_1).append[newLine]
	}
	
	def dispatch void format(EntityScalarDataProperty t, extension IFormattableDocument document) {
		t.regionFor.keyword(entityScalarDataPropertyAccess.entityScalarDataPropertyKeyword_0).append[oneSpace]
		t.regionFor.ruleCall(entityScalarDataPropertyAccess.nameIDTerminalRuleCall_2_0).prepend[noSpace]
		t.regionFor.ruleCall(entityScalarDataPropertyAccess.nameIDTerminalRuleCall_2_0).append[oneSpace]
		
		val lcurly = t.regionFor.keyword(entityScalarDataPropertyAccess.leftCurlyBracketKeyword_3)
		val rcurly = t.regionFor.keyword(entityScalarDataPropertyAccess.rightCurlyBracketKeyword_8)
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		t.regionFor.keyword(entityScalarDataPropertyAccess.domainKeyword_4).append[oneSpace]
		t.regionFor.ruleCall(entityScalarDataPropertyAccess.domainEntityReferenceParserRuleCall_5_0_1).append[newLine]
		t.regionFor.keyword(entityScalarDataPropertyAccess.rangeKeyword_6).append[oneSpace]
		t.regionFor.ruleCall(entityScalarDataPropertyAccess.rangeDataRangeReferenceParserRuleCall_7_0_1).append[newLine]
	}
	
	def dispatch void format(StructuredDataProperty t, extension IFormattableDocument document) {
		t.regionFor.keyword('structuredDataProperty').append[oneSpace]
		t.regionFor.ruleCall(structuredDataPropertyAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = t.regionFor.keyword('{')
		val rcurly = t.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		t.regionFor.keyword('domain').append[oneSpace]
		t.regionFor.ruleCall(structuredDataPropertyAccess.domainStructureReferenceParserRuleCall_4_0_1).append[newLine]
		t.regionFor.keyword('range').append[oneSpace]
		t.regionFor.ruleCall(structuredDataPropertyAccess.rangeStructureReferenceParserRuleCall_6_0_1).append[newLine]
	}
	
	def dispatch void format(ScalarDataProperty t, extension IFormattableDocument document) {
		t.regionFor.keyword('scalarDataProperty').append[oneSpace]
		t.regionFor.ruleCall(scalarDataPropertyAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = t.regionFor.keyword(scalarDataPropertyAccess.leftCurlyBracketKeyword_2)
		val rcurly = t.regionFor.keyword(scalarDataPropertyAccess.rightCurlyBracketKeyword_7)
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		t.regionFor.keyword('domain').append[oneSpace]
		t.regionFor.ruleCall(scalarDataPropertyAccess.domainStructureReferenceParserRuleCall_4_0_1).append[newLine]
		t.regionFor.keyword('range').append[oneSpace]
		t.regionFor.ruleCall(scalarDataPropertyAccess.rangeDataRangeReferenceParserRuleCall_6_0_1).append[newLine]
	}
	
	def dispatch void format(RootConceptTaxonomyAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('rootConceptTaxonomy').append[noSpace]
		ax.regionFor.keyword('(').surround[noSpace]
		ax.regionFor.keyword(')').prepend[noSpace]
		ax.regionFor.keyword(')').append[oneSpace]
		
		val lcurly = ax.regionFor.keyword('{')
		val rcurly = ax.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		ax.regionFor.keyword('root').append[oneSpace]
		ax.disjunctions.forEach[format.append[newLine]]
	}
	
	def dispatch void format(AnonymousConceptUnionAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('anonymousConceptUnion').append[oneSpace]
		ax.regionFor.keyword('(').surround[noSpace]
		ax.regionFor.keyword(')').prepend[noSpace]
		ax.regionFor.keyword(')').append[oneSpace]
		
		val lcurly = ax.regionFor.keyword('{')
		val rcurly = ax.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		ax.regionFor.keyword('root').append[oneSpace]
		ax.disjunctions.forEach[format.append[newLine]]
	}
	
	def dispatch void format(SpecificDisjointConceptAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('disjointLeaf').append[oneSpace]
		ax.regionFor.keyword('(').surround[noSpace]
		ax.regionFor.keyword(')').prepend[noSpace]
	}
	
	def dispatch void format(EntityExistentialRestrictionAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('someEntities').append[oneSpace]
		
		ax.regionFor.keyword('.').surround[noSpace]
		ax.regionFor.keyword('in').surround[oneSpace]
	}
	
	def dispatch void format(EntityUniversalRestrictionAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('allEntities').append[oneSpace]
		
		ax.regionFor.keyword('.').surround[noSpace]
		ax.regionFor.keyword('in').surround[oneSpace]
	}
	
	def dispatch void format(EntityScalarDataPropertyExistentialRestrictionAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('someData').append[oneSpace]
		
		ax.regionFor.keyword('.').surround[noSpace]
		ax.regionFor.keyword('in').surround[oneSpace]
	}
	
	def dispatch void format(EntityScalarDataPropertyParticularRestrictionAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('allData').append[oneSpace]
		
		ax.regionFor.keyword('.').surround[noSpace]
		ax.regionFor.keyword('in').surround[oneSpace]
	}
	
	def dispatch void format(EntityScalarDataPropertyUniversalRestrictionAxiom ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('allData').append[oneSpace]
		
		ax.regionFor.keyword('.').surround[noSpace]
		ax.regionFor.keyword('in').surround[oneSpace]
	}
	
	def dispatch void format(BinaryScalarRestriction sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('binaryScalarRestriction').append[oneSpace]
		sc.regionFor.ruleCall(binaryScalarRestrictionAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = sc.regionFor.keyword('{')
		val rcurly = sc.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		sc.regionFor.keyword('length').append[oneSpace]
		sc.regionFor.ruleCall(binaryScalarRestrictionAccess.lengthINTTerminalRuleCall_3_0_1_0).append[newLine]
		sc.regionFor.keyword('minLength').append[oneSpace]
		sc.regionFor.ruleCall(binaryScalarRestrictionAccess.minLengthINTTerminalRuleCall_3_1_1_0).append[newLine]
		sc.regionFor.keyword('maxLength').append[oneSpace]
		sc.regionFor.ruleCall(binaryScalarRestrictionAccess.maxLengthINTTerminalRuleCall_3_2_1_0).append[newLine]
		sc.regionFor.keyword('restrictedRange').append[oneSpace]
		sc.regionFor.ruleCall(binaryScalarRestrictionAccess.restrictedRangeDataRangeReferenceParserRuleCall_5_0_1).append[newLine]
	}
	
	def dispatch void format(IRIScalarRestriction sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('iriScalarRestriction').append[oneSpace]
		sc.regionFor.ruleCall(IRIScalarRestrictionAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = sc.regionFor.keyword('{')
		val rcurly = sc.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		sc.regionFor.keyword('length').append[oneSpace]
		sc.regionFor.ruleCall(IRIScalarRestrictionAccess.lengthINTTerminalRuleCall_3_0_1_0).append[newLine]
		sc.regionFor.keyword('minLength').append[oneSpace]
		sc.regionFor.ruleCall(IRIScalarRestrictionAccess.minLengthINTTerminalRuleCall_3_1_1_0).append[newLine]
		sc.regionFor.keyword('maxLength').append[oneSpace]
		sc.regionFor.ruleCall(IRIScalarRestrictionAccess.maxLengthINTTerminalRuleCall_3_2_1_0).append[newLine]
		sc.regionFor.keyword('pattern').append[oneSpace]
		sc.regionFor.ruleCall(IRIScalarRestrictionAccess.patternSTRINGTerminalRuleCall_3_3_1_0).append[newLine]
		sc.regionFor.keyword('restrictedRange').append[oneSpace]
		sc.regionFor.ruleCall(IRIScalarRestrictionAccess.restrictedRangeDataRangeReferenceParserRuleCall_5_0_1).append[newLine]
	}
	
	def dispatch void format(NumericScalarRestriction sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('numericScalarRestriction').append[oneSpace]
		sc.regionFor.ruleCall(numericScalarRestrictionAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = sc.regionFor.keyword('{')
		val rcurly = sc.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		sc.regionFor.keyword('minInclusive').append[oneSpace]
		sc.regionFor.ruleCall(numericScalarRestrictionAccess.minInclusiveSTRINGTerminalRuleCall_3_0_1_0).append[newLine]
		sc.regionFor.keyword('maxInclusive').append[oneSpace]
		sc.regionFor.ruleCall(numericScalarRestrictionAccess.maxInclusiveSTRINGTerminalRuleCall_3_1_1_0).append[newLine]
		sc.regionFor.keyword('minExclusive').append[oneSpace]
		sc.regionFor.ruleCall(numericScalarRestrictionAccess.minExclusiveSTRINGTerminalRuleCall_3_2_1_0).append[newLine]
		sc.regionFor.keyword('maxExclusive').append[oneSpace]
		sc.regionFor.ruleCall(numericScalarRestrictionAccess.maxExclusiveSTRINGTerminalRuleCall_3_3_1_0).append[newLine]
		sc.regionFor.keyword('restrictedRange').append[oneSpace]
		sc.regionFor.ruleCall(numericScalarRestrictionAccess.restrictedRangeDataRangeReferenceParserRuleCall_5_0_1).append[newLine]
	}
	
	
	def dispatch void format(PlainLiteralScalarRestriction sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('plainLiteralScalarRestriction').append[oneSpace]
		sc.regionFor.ruleCall(IRIScalarRestrictionAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = sc.regionFor.keyword('{')
		val rcurly = sc.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		sc.regionFor.keyword('length').append[oneSpace]
		sc.regionFor.ruleCall(plainLiteralScalarRestrictionAccess.lengthINTTerminalRuleCall_3_0_1_0).append[newLine]
		sc.regionFor.keyword('minLength').append[oneSpace]
		sc.regionFor.ruleCall(plainLiteralScalarRestrictionAccess.minLengthINTTerminalRuleCall_3_1_1_0).append[newLine]
		sc.regionFor.keyword('maxLength').append[oneSpace]
		sc.regionFor.ruleCall(plainLiteralScalarRestrictionAccess.maxLengthINTTerminalRuleCall_3_2_1_0).append[newLine]
		sc.regionFor.keyword('pattern').append[oneSpace]
		sc.regionFor.ruleCall(plainLiteralScalarRestrictionAccess.patternSTRINGTerminalRuleCall_3_3_1_0).append[newLine]
		sc.regionFor.keyword('langRange').append[oneSpace]
		sc.regionFor.ruleCall(plainLiteralScalarRestrictionAccess.langRangeSTRINGTerminalRuleCall_3_4_1_0).append[newLine]
		sc.regionFor.keyword('restrictedRange').append[oneSpace]
		sc.regionFor.ruleCall(plainLiteralScalarRestrictionAccess.restrictedRangeDataRangeReferenceParserRuleCall_5_0_1).append[newLine]
	}
	
	def dispatch void format(ScalarOneOfRestriction sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('scalarOneOfRestriction').append[oneSpace]
		sc.regionFor.ruleCall(scalarOneOfRestrictionAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = sc.regionFor.keyword('{')
		val rcurly = sc.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		sc.regionFor.keyword('restrictedRange').append[oneSpace]
		sc.regionFor.ruleCall(scalarOneOfRestrictionAccess.restrictedRangeDataRangeReferenceParserRuleCall_4_0_1).append[newLine]
	}
	
	def dispatch void format(ScalarOneOfLiteralAxiom sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('oneOf').append[oneSpace]
		sc.regionFor.keyword('=').surround[oneSpace]
	}
	
	def dispatch void format(StringScalarRestriction sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('stringScalarRestriction').append[oneSpace]
		sc.regionFor.ruleCall(stringScalarRestrictionAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = sc.regionFor.keyword('{')
		val rcurly = sc.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		sc.regionFor.keyword('length').append[oneSpace]
		sc.regionFor.ruleCall(stringScalarRestrictionAccess.lengthINTTerminalRuleCall_3_0_1_0).append[newLine]
		sc.regionFor.keyword('minLength').append[oneSpace]
		sc.regionFor.ruleCall(stringScalarRestrictionAccess.minLengthINTTerminalRuleCall_3_1_1_0).append[newLine]
		sc.regionFor.keyword('maxLength').append[oneSpace]
		sc.regionFor.ruleCall(stringScalarRestrictionAccess.maxLengthINTTerminalRuleCall_3_2_1_0).append[newLine]
		sc.regionFor.keyword('pattern').append[oneSpace]
		sc.regionFor.ruleCall(stringScalarRestrictionAccess.patternSTRINGTerminalRuleCall_3_3_1_0).append[newLine]
		sc.regionFor.keyword('restrictedRange').append[oneSpace]
		sc.regionFor.ruleCall(stringScalarRestrictionAccess.restrictedRangeDataRangeReferenceParserRuleCall_5_0_1).append[newLine]
	}
	
	def dispatch void format(SynonymScalarRestriction sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('synonymScalarRestriction').append[oneSpace]
		sc.regionFor.ruleCall(synonymScalarRestrictionAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = sc.regionFor.keyword('{')
		val rcurly = sc.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		sc.regionFor.keyword('restrictedRange').append[oneSpace]
		sc.regionFor.ruleCall(synonymScalarRestrictionAccess.restrictedRangeDataRangeReferenceParserRuleCall_4_0_1).append[newLine]
	}
	
	def dispatch void format(TimeScalarRestriction sc, extension IFormattableDocument document) {
		sc.regionFor.keyword('timeScalarRestriction').append[oneSpace]
		sc.regionFor.ruleCall(timeScalarRestrictionAccess.nameIDTerminalRuleCall_1_0).surround[oneSpace]
		
		val lcurly = sc.regionFor.keyword('{')
		val rcurly = sc.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]
		
		sc.regionFor.keyword('minInclusive').append[oneSpace]
		sc.regionFor.ruleCall(timeScalarRestrictionAccess.minInclusiveSTRINGTerminalRuleCall_3_0_1_0).append[newLine]
		sc.regionFor.keyword('maxInclusive').append[oneSpace]
		sc.regionFor.ruleCall(timeScalarRestrictionAccess.maxInclusiveSTRINGTerminalRuleCall_3_1_1_0).append[newLine]
		sc.regionFor.keyword('minExclusive').append[oneSpace]
		sc.regionFor.ruleCall(timeScalarRestrictionAccess.minExclusiveSTRINGTerminalRuleCall_3_2_1_0).append[newLine]
		sc.regionFor.keyword('maxExclusive').append[oneSpace]
		sc.regionFor.ruleCall(timeScalarRestrictionAccess.maxExclusiveSTRINGTerminalRuleCall_3_3_1_0).append[newLine]
		sc.regionFor.keyword('restrictedRange').append[oneSpace]
		sc.regionFor.ruleCall(timeScalarRestrictionAccess.restrictedRangeDataRangeReferenceParserRuleCall_5_0_1).append[newLine]
	}
	
	def dispatch void format(DescriptionBoxExtendsClosedWorldDefinitions ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('extends').surround[oneSpace]
	}
	
	def dispatch void format(DescriptionBoxRefinement ax, extension IFormattableDocument document) {
		ax.regionFor.keyword('refines').surround[oneSpace]
	}
	
	def dispatch void format(SingletonInstanceScalarDataPropertyValue s, extension IFormattableDocument document) {
		s.regionFor.keyword('.').surround[noSpace]
		s.regionFor.keyword('=').surround[oneSpace]
	}
	
	def dispatch void format(SingletonInstanceStructuredDataPropertyValue s, extension IFormattableDocument document) {
		s.regionFor.keyword('.').surround[noSpace]
		s.regionFor.keyword('=').surround[oneSpace]
		
		val lcurly = s.regionFor.keyword('{')
		val rcurly = s.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]

		s.structuredPropertyTuples.forEach[format.append[setNewLines(1)]]
		s.scalarDataPropertyValues.forEach[format.append[setNewLines(1)]]
	}
	
	def dispatch void format(StructuredDataPropertyTuple t, extension IFormattableDocument document) {
		t.regionFor.keyword('=').surround[oneSpace]
		
		val lcurly = t.regionFor.keyword('{')
		val rcurly = t.regionFor.keyword('}')
		lcurly.prepend[oneSpace]
		lcurly.append[newLine]
		interior(lcurly, rcurly)[indent]

		t.structuredPropertyTuples.forEach[format.append[setNewLines(1)]]
		t.scalarDataPropertyValues.forEach[format.append[setNewLines(1)]]
	}
	
	def dispatch void format(ConceptInstance i, extension IFormattableDocument document) {
		i.regionFor.keyword('conceptInstance').append[noSpace]
		i.regionFor.keyword('(').surround[noSpace]
		i.regionFor.keyword('is-a').surround[oneSpace]
		i.regionFor.keyword(')').prepend[noSpace]
		i.regionFor.keyword(')').append[oneSpace]
	}
	
	def dispatch void format(ReifiedRelationshipInstance i, extension IFormattableDocument document) {
		i.regionFor.keyword('reifiedRelationshipInstance').append[noSpace]
		i.regionFor.keyword('(').surround[noSpace]
		i.regionFor.keyword('is-a').surround[oneSpace]
		i.regionFor.keyword(')').prepend[noSpace]
		i.regionFor.keyword(')').append[oneSpace]
	}
}
