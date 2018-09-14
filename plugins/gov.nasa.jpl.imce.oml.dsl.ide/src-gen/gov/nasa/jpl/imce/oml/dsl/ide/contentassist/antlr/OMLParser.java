/*
 * Copyright 2017 California Institute of Technology (\"Caltech\").
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
package gov.nasa.jpl.imce.oml.dsl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import gov.nasa.jpl.imce.oml.dsl.ide.contentassist.antlr.internal.InternalOMLParser;
import gov.nasa.jpl.imce.oml.dsl.services.OMLGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class OMLParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(OMLGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, OMLGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModuleAccess().getAlternatives(), "rule__Module__Alternatives");
			builder.put(grammarAccess.getTerminologyBoxAccess().getAlternatives(), "rule__TerminologyBox__Alternatives");
			builder.put(grammarAccess.getTerminologyGraphAccess().getAlternatives_6(), "rule__TerminologyGraph__Alternatives_6");
			builder.put(grammarAccess.getBundleAccess().getAlternatives_6(), "rule__Bundle__Alternatives_6");
			builder.put(grammarAccess.getDescriptionBoxAccess().getAlternatives_6(), "rule__DescriptionBox__Alternatives_6");
			builder.put(grammarAccess.getTerminologyBoxAxiomAccess().getAlternatives(), "rule__TerminologyBoxAxiom__Alternatives");
			builder.put(grammarAccess.getTerminologyBoxStatementAccess().getAlternatives(), "rule__TerminologyBoxStatement__Alternatives");
			builder.put(grammarAccess.getTermAccess().getAlternatives(), "rule__Term__Alternatives");
			builder.put(grammarAccess.getAtomicEntityAccess().getAlternatives(), "rule__AtomicEntity__Alternatives");
			builder.put(grammarAccess.getEntityRelationshipAccess().getAlternatives(), "rule__EntityRelationship__Alternatives");
			builder.put(grammarAccess.getDatatypeAccess().getAlternatives(), "rule__Datatype__Alternatives");
			builder.put(grammarAccess.getScalarDataRangeAccess().getAlternatives(), "rule__ScalarDataRange__Alternatives");
			builder.put(grammarAccess.getRestrictedDataRangeAccess().getAlternatives(), "rule__RestrictedDataRange__Alternatives");
			builder.put(grammarAccess.getDataRelationshipAccess().getAlternatives(), "rule__DataRelationship__Alternatives");
			builder.put(grammarAccess.getTermAxiomAccess().getAlternatives(), "rule__TermAxiom__Alternatives");
			builder.put(grammarAccess.getEntityRestrictionAxiomAccess().getAlternatives(), "rule__EntityRestrictionAxiom__Alternatives");
			builder.put(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getAlternatives(), "rule__EntityScalarDataPropertyRestrictionAxiom__Alternatives");
			builder.put(grammarAccess.getSpecializationAxiomAccess().getAlternatives(), "rule__SpecializationAxiom__Alternatives");
			builder.put(grammarAccess.getConceptTreeDisjunctionAccess().getAlternatives(), "rule__ConceptTreeDisjunction__Alternatives");
			builder.put(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getAlternatives(), "rule__DisjointUnionOfConceptsAxiom__Alternatives");
			builder.put(grammarAccess.getSegmentPredicateAccess().getAlternatives(), "rule__SegmentPredicate__Alternatives");
			builder.put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAlternatives_7(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Alternatives_7");
			builder.put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAlternatives_4(), "rule__RestrictionStructuredDataPropertyTuple__Alternatives_4");
			builder.put(grammarAccess.getTerminologyInstanceAssertionAccess().getAlternatives(), "rule__TerminologyInstanceAssertion__Alternatives");
			builder.put(grammarAccess.getConceptualEntitySingletonInstanceAccess().getAlternatives(), "rule__ConceptualEntitySingletonInstance__Alternatives");
			builder.put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAlternatives_6(), "rule__SingletonInstanceStructuredDataPropertyValue__Alternatives_6");
			builder.put(grammarAccess.getStructuredDataPropertyTupleAccess().getAlternatives_4(), "rule__StructuredDataPropertyTuple__Alternatives_4");
			builder.put(grammarAccess.getReferenceAccess().getAlternatives(), "rule__Reference__Alternatives");
			builder.put(grammarAccess.getQNAMEAccess().getAlternatives(), "rule__QNAME__Alternatives");
			builder.put(grammarAccess.getLiteralValueAccess().getAlternatives(), "rule__LiteralValue__Alternatives");
			builder.put(grammarAccess.getLiteralBooleanAccess().getBoolAlternatives_1_0(), "rule__LiteralBoolean__BoolAlternatives_1_0");
			builder.put(grammarAccess.getLiteralStringAccess().getAlternatives(), "rule__LiteralString__Alternatives");
			builder.put(grammarAccess.getLiteralNumberAccess().getAlternatives(), "rule__LiteralNumber__Alternatives");
			builder.put(grammarAccess.getLiteralDecimalAccess().getAlternatives(), "rule__LiteralDecimal__Alternatives");
			builder.put(grammarAccess.getTerminologyKindAccess().getAlternatives(), "rule__TerminologyKind__Alternatives");
			builder.put(grammarAccess.getCardinalityRestrictionKindAccess().getAlternatives(), "rule__CardinalityRestrictionKind__Alternatives");
			builder.put(grammarAccess.getDescriptionKindAccess().getAlternatives(), "rule__DescriptionKind__Alternatives");
			builder.put(grammarAccess.getExtentAccess().getGroup(), "rule__Extent__Group__0");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getGroup(), "rule__AnnotationProperty__Group__0");
			builder.put(grammarAccess.getAnnotationPropertyValueAccess().getGroup(), "rule__AnnotationPropertyValue__Group__0");
			builder.put(grammarAccess.getTerminologyGraphAccess().getGroup(), "rule__TerminologyGraph__Group__0");
			builder.put(grammarAccess.getBundleAccess().getGroup(), "rule__Bundle__Group__0");
			builder.put(grammarAccess.getDescriptionBoxAccess().getGroup(), "rule__DescriptionBox__Group__0");
			builder.put(grammarAccess.getBundledTerminologyAxiomAccess().getGroup(), "rule__BundledTerminologyAxiom__Group__0");
			builder.put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getGroup(), "rule__ConceptDesignationTerminologyAxiom__Group__0");
			builder.put(grammarAccess.getTerminologyExtensionAxiomAccess().getGroup(), "rule__TerminologyExtensionAxiom__Group__0");
			builder.put(grammarAccess.getTerminologyNestingAxiomAccess().getGroup(), "rule__TerminologyNestingAxiom__Group__0");
			builder.put(grammarAccess.getAspectAccess().getGroup(), "rule__Aspect__Group__0");
			builder.put(grammarAccess.getCardinalityRestrictedAspectAccess().getGroup(), "rule__CardinalityRestrictedAspect__Group__0");
			builder.put(grammarAccess.getCardinalityRestrictedAspectAccess().getGroup_6(), "rule__CardinalityRestrictedAspect__Group_6__0");
			builder.put(grammarAccess.getConceptAccess().getGroup(), "rule__Concept__Group__0");
			builder.put(grammarAccess.getCardinalityRestrictedConceptAccess().getGroup(), "rule__CardinalityRestrictedConcept__Group__0");
			builder.put(grammarAccess.getCardinalityRestrictedConceptAccess().getGroup_6(), "rule__CardinalityRestrictedConcept__Group_6__0");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getGroup(), "rule__ReifiedRelationship__Group__0");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getGroup_8(), "rule__ReifiedRelationship__Group_8__0");
			builder.put(grammarAccess.getReifiedRelationshipRestrictionAccess().getGroup(), "rule__ReifiedRelationshipRestriction__Group__0");
			builder.put(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getGroup(), "rule__CardinalityRestrictedReifiedRelationship__Group__0");
			builder.put(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getGroup_6(), "rule__CardinalityRestrictedReifiedRelationship__Group_6__0");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getGroup(), "rule__UnreifiedRelationship__Group__0");
			builder.put(grammarAccess.getScalarAccess().getGroup(), "rule__Scalar__Group__0");
			builder.put(grammarAccess.getStructureAccess().getGroup(), "rule__Structure__Group__0");
			builder.put(grammarAccess.getEntityStructuredDataPropertyAccess().getGroup(), "rule__EntityStructuredDataProperty__Group__0");
			builder.put(grammarAccess.getEntityScalarDataPropertyAccess().getGroup(), "rule__EntityScalarDataProperty__Group__0");
			builder.put(grammarAccess.getStructuredDataPropertyAccess().getGroup(), "rule__StructuredDataProperty__Group__0");
			builder.put(grammarAccess.getScalarDataPropertyAccess().getGroup(), "rule__ScalarDataProperty__Group__0");
			builder.put(grammarAccess.getChainRuleAccess().getGroup(), "rule__ChainRule__Group__0");
			builder.put(grammarAccess.getRuleBodySegmentAccess().getGroup(), "rule__RuleBodySegment__Group__0");
			builder.put(grammarAccess.getRuleBodySegmentAccess().getGroup_1(), "rule__RuleBodySegment__Group_1__0");
			builder.put(grammarAccess.getSegmentPredicateAccess().getGroup_1(), "rule__SegmentPredicate__Group_1__0");
			builder.put(grammarAccess.getSegmentPredicateAccess().getGroup_2(), "rule__SegmentPredicate__Group_2__0");
			builder.put(grammarAccess.getSegmentPredicateAccess().getGroup_3(), "rule__SegmentPredicate__Group_3__0");
			builder.put(grammarAccess.getSegmentPredicateAccess().getGroup_4(), "rule__SegmentPredicate__Group_4__0");
			builder.put(grammarAccess.getSegmentPredicateAccess().getGroup_5(), "rule__SegmentPredicate__Group_5__0");
			builder.put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getGroup(), "rule__AnonymousConceptUnionAxiom__Group__0");
			builder.put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getGroup(), "rule__RootConceptTaxonomyAxiom__Group__0");
			builder.put(grammarAccess.getSpecificDisjointConceptAxiomAccess().getGroup(), "rule__SpecificDisjointConceptAxiom__Group__0");
			builder.put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getGroup(), "rule__EntityExistentialRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getGroup(), "rule__EntityUniversalRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getAspectSpecializationAxiomAccess().getGroup(), "rule__AspectSpecializationAxiom__Group__0");
			builder.put(grammarAccess.getConceptSpecializationAxiomAccess().getGroup(), "rule__ConceptSpecializationAxiom__Group__0");
			builder.put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getGroup(), "rule__ReifiedRelationshipSpecializationAxiom__Group__0");
			builder.put(grammarAccess.getSubObjectPropertyOfAxiomAccess().getGroup(), "rule__SubObjectPropertyOfAxiom__Group__0");
			builder.put(grammarAccess.getSubDataPropertyOfAxiomAccess().getGroup(), "rule__SubDataPropertyOfAxiom__Group__0");
			builder.put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getGroup(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getGroup(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getGroup_7(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__0");
			builder.put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getGroup(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getGroup(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__0");
			builder.put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getGroup(), "rule__RestrictionStructuredDataPropertyTuple__Group__0");
			builder.put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getGroup(), "rule__RestrictionScalarDataPropertyValue__Group__0");
			builder.put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getGroup_4(), "rule__RestrictionScalarDataPropertyValue__Group_4__0");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup(), "rule__BinaryScalarRestriction__Group__0");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_0(), "rule__BinaryScalarRestriction__Group_4_0__0");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_1(), "rule__BinaryScalarRestriction__Group_4_1__0");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_2(), "rule__BinaryScalarRestriction__Group_4_2__0");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getGroup(), "rule__IRIScalarRestriction__Group__0");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_0(), "rule__IRIScalarRestriction__Group_4_0__0");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_1(), "rule__IRIScalarRestriction__Group_4_1__0");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_2(), "rule__IRIScalarRestriction__Group_4_2__0");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_3(), "rule__IRIScalarRestriction__Group_4_3__0");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getGroup(), "rule__NumericScalarRestriction__Group__0");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_0(), "rule__NumericScalarRestriction__Group_4_0__0");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_1(), "rule__NumericScalarRestriction__Group_4_1__0");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_2(), "rule__NumericScalarRestriction__Group_4_2__0");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_3(), "rule__NumericScalarRestriction__Group_4_3__0");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup(), "rule__PlainLiteralScalarRestriction__Group__0");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_0(), "rule__PlainLiteralScalarRestriction__Group_4_0__0");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_1(), "rule__PlainLiteralScalarRestriction__Group_4_1__0");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_2(), "rule__PlainLiteralScalarRestriction__Group_4_2__0");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_3(), "rule__PlainLiteralScalarRestriction__Group_4_3__0");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_4(), "rule__PlainLiteralScalarRestriction__Group_4_4__0");
			builder.put(grammarAccess.getScalarOneOfRestrictionAccess().getGroup(), "rule__ScalarOneOfRestriction__Group__0");
			builder.put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getGroup(), "rule__ScalarOneOfLiteralAxiom__Group__0");
			builder.put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getGroup_5(), "rule__ScalarOneOfLiteralAxiom__Group_5__0");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getGroup(), "rule__StringScalarRestriction__Group__0");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_0(), "rule__StringScalarRestriction__Group_4_0__0");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_1(), "rule__StringScalarRestriction__Group_4_1__0");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_2(), "rule__StringScalarRestriction__Group_4_2__0");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_3(), "rule__StringScalarRestriction__Group_4_3__0");
			builder.put(grammarAccess.getSynonymScalarRestrictionAccess().getGroup(), "rule__SynonymScalarRestriction__Group__0");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getGroup(), "rule__TimeScalarRestriction__Group__0");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_0(), "rule__TimeScalarRestriction__Group_4_0__0");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_1(), "rule__TimeScalarRestriction__Group_4_1__0");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_2(), "rule__TimeScalarRestriction__Group_4_2__0");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_3(), "rule__TimeScalarRestriction__Group_4_3__0");
			builder.put(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getGroup(), "rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__0");
			builder.put(grammarAccess.getDescriptionBoxRefinementAccess().getGroup(), "rule__DescriptionBoxRefinement__Group__0");
			builder.put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getGroup(), "rule__SingletonInstanceScalarDataPropertyValue__Group__0");
			builder.put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getGroup_6(), "rule__SingletonInstanceScalarDataPropertyValue__Group_6__0");
			builder.put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getGroup(), "rule__SingletonInstanceStructuredDataPropertyValue__Group__0");
			builder.put(grammarAccess.getStructuredDataPropertyTupleAccess().getGroup(), "rule__StructuredDataPropertyTuple__Group__0");
			builder.put(grammarAccess.getScalarDataPropertyValueAccess().getGroup(), "rule__ScalarDataPropertyValue__Group__0");
			builder.put(grammarAccess.getScalarDataPropertyValueAccess().getGroup_4(), "rule__ScalarDataPropertyValue__Group_4__0");
			builder.put(grammarAccess.getConceptInstanceAccess().getGroup(), "rule__ConceptInstance__Group__0");
			builder.put(grammarAccess.getReifiedRelationshipInstanceAccess().getGroup(), "rule__ReifiedRelationshipInstance__Group__0");
			builder.put(grammarAccess.getInstanceRelationshipValueRestrictionAccess().getGroup(), "rule__InstanceRelationshipValueRestriction__Group__0");
			builder.put(grammarAccess.getInstanceRelationshipExistentialRangeRestrictionAccess().getGroup(), "rule__InstanceRelationshipExistentialRangeRestriction__Group__0");
			builder.put(grammarAccess.getInstanceRelationshipUniversalRangeRestrictionAccess().getGroup(), "rule__InstanceRelationshipUniversalRangeRestriction__Group__0");
			builder.put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getGroup(), "rule__ReifiedRelationshipInstanceDomain__Group__0");
			builder.put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getGroup(), "rule__ReifiedRelationshipInstanceRange__Group__0");
			builder.put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getGroup(), "rule__UnreifiedRelationshipInstanceTuple__Group__0");
			builder.put(grammarAccess.getLiteralBooleanAccess().getGroup(), "rule__LiteralBoolean__Group__0");
			builder.put(grammarAccess.getLiteralDateTimeAccess().getGroup(), "rule__LiteralDateTime__Group__0");
			builder.put(grammarAccess.getLiteralQuotedStringAccess().getGroup(), "rule__LiteralQuotedString__Group__0");
			builder.put(grammarAccess.getLiteralRawStringAccess().getGroup(), "rule__LiteralRawString__Group__0");
			builder.put(grammarAccess.getLiteralUUIDAccess().getGroup(), "rule__LiteralUUID__Group__0");
			builder.put(grammarAccess.getLiteralURIAccess().getGroup(), "rule__LiteralURI__Group__0");
			builder.put(grammarAccess.getLiteralRealAccess().getGroup(), "rule__LiteralReal__Group__0");
			builder.put(grammarAccess.getLiteralRationalAccess().getGroup(), "rule__LiteralRational__Group__0");
			builder.put(grammarAccess.getLiteralFloatAccess().getGroup(), "rule__LiteralFloat__Group__0");
			builder.put(grammarAccess.getLiteralDecimalAccess().getGroup_0(), "rule__LiteralDecimal__Group_0__0");
			builder.put(grammarAccess.getExtentAccess().getModulesAssignment_1(), "rule__Extent__ModulesAssignment_1");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIAssignment_1(), "rule__AnnotationProperty__AbbrevIRIAssignment_1");
			builder.put(grammarAccess.getAnnotationPropertyAccess().getIriAssignment_3(), "rule__AnnotationProperty__IriAssignment_3");
			builder.put(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAssignment_1(), "rule__AnnotationPropertyValue__PropertyAssignment_1");
			builder.put(grammarAccess.getAnnotationPropertyValueAccess().getValueAssignment_3(), "rule__AnnotationPropertyValue__ValueAssignment_3");
			builder.put(grammarAccess.getTerminologyGraphAccess().getAnnotationPropertiesAssignment_0(), "rule__TerminologyGraph__AnnotationPropertiesAssignment_0");
			builder.put(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_1(), "rule__TerminologyGraph__AnnotationsAssignment_1");
			builder.put(grammarAccess.getTerminologyGraphAccess().getKindAssignment_2(), "rule__TerminologyGraph__KindAssignment_2");
			builder.put(grammarAccess.getTerminologyGraphAccess().getIriAssignment_4(), "rule__TerminologyGraph__IriAssignment_4");
			builder.put(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsAssignment_6_0(), "rule__TerminologyGraph__BoxAxiomsAssignment_6_0");
			builder.put(grammarAccess.getTerminologyGraphAccess().getBoxStatementsAssignment_6_1(), "rule__TerminologyGraph__BoxStatementsAssignment_6_1");
			builder.put(grammarAccess.getBundleAccess().getAnnotationPropertiesAssignment_0(), "rule__Bundle__AnnotationPropertiesAssignment_0");
			builder.put(grammarAccess.getBundleAccess().getAnnotationsAssignment_1(), "rule__Bundle__AnnotationsAssignment_1");
			builder.put(grammarAccess.getBundleAccess().getKindAssignment_2(), "rule__Bundle__KindAssignment_2");
			builder.put(grammarAccess.getBundleAccess().getIriAssignment_4(), "rule__Bundle__IriAssignment_4");
			builder.put(grammarAccess.getBundleAccess().getBoxAxiomsAssignment_6_0(), "rule__Bundle__BoxAxiomsAssignment_6_0");
			builder.put(grammarAccess.getBundleAccess().getBoxStatementsAssignment_6_1(), "rule__Bundle__BoxStatementsAssignment_6_1");
			builder.put(grammarAccess.getBundleAccess().getBundleStatementsAssignment_6_2(), "rule__Bundle__BundleStatementsAssignment_6_2");
			builder.put(grammarAccess.getBundleAccess().getBundleAxiomsAssignment_6_3(), "rule__Bundle__BundleAxiomsAssignment_6_3");
			builder.put(grammarAccess.getDescriptionBoxAccess().getAnnotationPropertiesAssignment_0(), "rule__DescriptionBox__AnnotationPropertiesAssignment_0");
			builder.put(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_1(), "rule__DescriptionBox__AnnotationsAssignment_1");
			builder.put(grammarAccess.getDescriptionBoxAccess().getKindAssignment_2(), "rule__DescriptionBox__KindAssignment_2");
			builder.put(grammarAccess.getDescriptionBoxAccess().getIriAssignment_4(), "rule__DescriptionBox__IriAssignment_4");
			builder.put(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsAssignment_6_0(), "rule__DescriptionBox__ClosedWorldDefinitionsAssignment_6_0");
			builder.put(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsAssignment_6_1(), "rule__DescriptionBox__DescriptionBoxRefinementsAssignment_6_1");
			builder.put(grammarAccess.getDescriptionBoxAccess().getConceptInstancesAssignment_6_2(), "rule__DescriptionBox__ConceptInstancesAssignment_6_2");
			builder.put(grammarAccess.getDescriptionBoxAccess().getInstanceRelationshipValueRestrictionsAssignment_6_3(), "rule__DescriptionBox__InstanceRelationshipValueRestrictionsAssignment_6_3");
			builder.put(grammarAccess.getDescriptionBoxAccess().getInstanceRelationshipExistentialRangeRestrictionsAssignment_6_4(), "rule__DescriptionBox__InstanceRelationshipExistentialRangeRestrictionsAssignment_6_4");
			builder.put(grammarAccess.getDescriptionBoxAccess().getInstanceRelationshipUniversalRangeRestrictionsAssignment_6_5(), "rule__DescriptionBox__InstanceRelationshipUniversalRangeRestrictionsAssignment_6_5");
			builder.put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesAssignment_6_6(), "rule__DescriptionBox__ReifiedRelationshipInstancesAssignment_6_6");
			builder.put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsAssignment_6_7(), "rule__DescriptionBox__ReifiedRelationshipInstanceDomainsAssignment_6_7");
			builder.put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesAssignment_6_8(), "rule__DescriptionBox__ReifiedRelationshipInstanceRangesAssignment_6_8");
			builder.put(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesAssignment_6_9(), "rule__DescriptionBox__UnreifiedRelationshipInstanceTuplesAssignment_6_9");
			builder.put(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesAssignment_6_10(), "rule__DescriptionBox__SingletonScalarDataPropertyValuesAssignment_6_10");
			builder.put(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesAssignment_6_11(), "rule__DescriptionBox__SingletonStructuredDataPropertyValuesAssignment_6_11");
			builder.put(grammarAccess.getBundledTerminologyAxiomAccess().getAnnotationsAssignment_0(), "rule__BundledTerminologyAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyAssignment_2(), "rule__BundledTerminologyAxiom__BundledTerminologyAssignment_2");
			builder.put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getAnnotationsAssignment_0(), "rule__ConceptDesignationTerminologyAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyAssignment_4(), "rule__ConceptDesignationTerminologyAxiom__DesignatedTerminologyAssignment_4");
			builder.put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptAssignment_6(), "rule__ConceptDesignationTerminologyAxiom__DesignatedConceptAssignment_6");
			builder.put(grammarAccess.getTerminologyExtensionAxiomAccess().getAnnotationsAssignment_0(), "rule__TerminologyExtensionAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyAssignment_2(), "rule__TerminologyExtensionAxiom__ExtendedTerminologyAssignment_2");
			builder.put(grammarAccess.getTerminologyNestingAxiomAccess().getAnnotationsAssignment_0(), "rule__TerminologyNestingAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyAssignment_4(), "rule__TerminologyNestingAxiom__NestingTerminologyAssignment_4");
			builder.put(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextAssignment_6(), "rule__TerminologyNestingAxiom__NestingContextAssignment_6");
			builder.put(grammarAccess.getAspectAccess().getAnnotationsAssignment_0(), "rule__Aspect__AnnotationsAssignment_0");
			builder.put(grammarAccess.getAspectAccess().getNameAssignment_2(), "rule__Aspect__NameAssignment_2");
			builder.put(grammarAccess.getCardinalityRestrictedAspectAccess().getAnnotationsAssignment_0(), "rule__CardinalityRestrictedAspect__AnnotationsAssignment_0");
			builder.put(grammarAccess.getCardinalityRestrictedAspectAccess().getNameAssignment_2(), "rule__CardinalityRestrictedAspect__NameAssignment_2");
			builder.put(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictionKindAssignment_3(), "rule__CardinalityRestrictedAspect__RestrictionKindAssignment_3");
			builder.put(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedCardinalityAssignment_4(), "rule__CardinalityRestrictedAspect__RestrictedCardinalityAssignment_4");
			builder.put(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRelationshipAssignment_5(), "rule__CardinalityRestrictedAspect__RestrictedRelationshipAssignment_5");
			builder.put(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRangeAssignment_6_1(), "rule__CardinalityRestrictedAspect__RestrictedRangeAssignment_6_1");
			builder.put(grammarAccess.getConceptAccess().getAnnotationsAssignment_0(), "rule__Concept__AnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptAccess().getNameAssignment_2(), "rule__Concept__NameAssignment_2");
			builder.put(grammarAccess.getCardinalityRestrictedConceptAccess().getAnnotationsAssignment_0(), "rule__CardinalityRestrictedConcept__AnnotationsAssignment_0");
			builder.put(grammarAccess.getCardinalityRestrictedConceptAccess().getNameAssignment_2(), "rule__CardinalityRestrictedConcept__NameAssignment_2");
			builder.put(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictionKindAssignment_3(), "rule__CardinalityRestrictedConcept__RestrictionKindAssignment_3");
			builder.put(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedCardinalityAssignment_4(), "rule__CardinalityRestrictedConcept__RestrictedCardinalityAssignment_4");
			builder.put(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRelationshipAssignment_5(), "rule__CardinalityRestrictedConcept__RestrictedRelationshipAssignment_5");
			builder.put(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRangeAssignment_6_1(), "rule__CardinalityRestrictedConcept__RestrictedRangeAssignment_6_1");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationship__AnnotationsAssignment_0");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getNameAssignment_2(), "rule__ReifiedRelationship__NameAssignment_2");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalAssignment_4_0(), "rule__ReifiedRelationship__IsFunctionalAssignment_4_0");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalAssignment_4_1(), "rule__ReifiedRelationship__IsInverseFunctionalAssignment_4_1");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsEssentialAssignment_4_2(), "rule__ReifiedRelationship__IsEssentialAssignment_4_2");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialAssignment_4_3(), "rule__ReifiedRelationship__IsInverseEssentialAssignment_4_3");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricAssignment_4_4(), "rule__ReifiedRelationship__IsSymmetricAssignment_4_4");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAssignment_4_5(), "rule__ReifiedRelationship__IsAsymmetricAssignment_4_5");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveAssignment_4_6(), "rule__ReifiedRelationship__IsReflexiveAssignment_4_6");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveAssignment_4_7(), "rule__ReifiedRelationship__IsIrreflexiveAssignment_4_7");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveAssignment_4_8(), "rule__ReifiedRelationship__IsTransitiveAssignment_4_8");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getForwardPropertyAssignment_7(), "rule__ReifiedRelationship__ForwardPropertyAssignment_7");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getInversePropertyAssignment_8_2(), "rule__ReifiedRelationship__InversePropertyAssignment_8_2");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getSourceAssignment_11(), "rule__ReifiedRelationship__SourceAssignment_11");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getTargetAssignment_14(), "rule__ReifiedRelationship__TargetAssignment_14");
			builder.put(grammarAccess.getForwardPropertyAccess().getNameAssignment(), "rule__ForwardProperty__NameAssignment");
			builder.put(grammarAccess.getInversePropertyAccess().getNameAssignment(), "rule__InverseProperty__NameAssignment");
			builder.put(grammarAccess.getReifiedRelationshipRestrictionAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getReifiedRelationshipRestrictionAccess().getNameAssignment_2(), "rule__ReifiedRelationshipRestriction__NameAssignment_2");
			builder.put(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceAssignment_6(), "rule__ReifiedRelationshipRestriction__SourceAssignment_6");
			builder.put(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetAssignment_9(), "rule__ReifiedRelationshipRestriction__TargetAssignment_9");
			builder.put(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getAnnotationsAssignment_0(), "rule__CardinalityRestrictedReifiedRelationship__AnnotationsAssignment_0");
			builder.put(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getNameAssignment_2(), "rule__CardinalityRestrictedReifiedRelationship__NameAssignment_2");
			builder.put(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictionKindAssignment_3(), "rule__CardinalityRestrictedReifiedRelationship__RestrictionKindAssignment_3");
			builder.put(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedCardinalityAssignment_4(), "rule__CardinalityRestrictedReifiedRelationship__RestrictedCardinalityAssignment_4");
			builder.put(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRelationshipAssignment_5(), "rule__CardinalityRestrictedReifiedRelationship__RestrictedRelationshipAssignment_5");
			builder.put(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRangeAssignment_6_1(), "rule__CardinalityRestrictedReifiedRelationship__RestrictedRangeAssignment_6_1");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAssignment_0(), "rule__UnreifiedRelationship__AnnotationsAssignment_0");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getNameAssignment_2(), "rule__UnreifiedRelationship__NameAssignment_2");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalAssignment_4_0(), "rule__UnreifiedRelationship__IsFunctionalAssignment_4_0");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalAssignment_4_1(), "rule__UnreifiedRelationship__IsInverseFunctionalAssignment_4_1");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialAssignment_4_2(), "rule__UnreifiedRelationship__IsEssentialAssignment_4_2");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialAssignment_4_3(), "rule__UnreifiedRelationship__IsInverseEssentialAssignment_4_3");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricAssignment_4_4(), "rule__UnreifiedRelationship__IsSymmetricAssignment_4_4");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAssignment_4_5(), "rule__UnreifiedRelationship__IsAsymmetricAssignment_4_5");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveAssignment_4_6(), "rule__UnreifiedRelationship__IsReflexiveAssignment_4_6");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveAssignment_4_7(), "rule__UnreifiedRelationship__IsIrreflexiveAssignment_4_7");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveAssignment_4_8(), "rule__UnreifiedRelationship__IsTransitiveAssignment_4_8");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getSourceAssignment_7(), "rule__UnreifiedRelationship__SourceAssignment_7");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getTargetAssignment_10(), "rule__UnreifiedRelationship__TargetAssignment_10");
			builder.put(grammarAccess.getScalarAccess().getAnnotationsAssignment_0(), "rule__Scalar__AnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarAccess().getNameAssignment_2(), "rule__Scalar__NameAssignment_2");
			builder.put(grammarAccess.getStructureAccess().getAnnotationsAssignment_0(), "rule__Structure__AnnotationsAssignment_0");
			builder.put(grammarAccess.getStructureAccess().getNameAssignment_2(), "rule__Structure__NameAssignment_2");
			builder.put(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAssignment_0(), "rule__EntityStructuredDataProperty__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaAssignment_2(), "rule__EntityStructuredDataProperty__IsIdentityCriteriaAssignment_2");
			builder.put(grammarAccess.getEntityStructuredDataPropertyAccess().getNameAssignment_3(), "rule__EntityStructuredDataProperty__NameAssignment_3");
			builder.put(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainAssignment_6(), "rule__EntityStructuredDataProperty__DomainAssignment_6");
			builder.put(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeAssignment_8(), "rule__EntityStructuredDataProperty__RangeAssignment_8");
			builder.put(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAssignment_0(), "rule__EntityScalarDataProperty__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaAssignment_2(), "rule__EntityScalarDataProperty__IsIdentityCriteriaAssignment_2");
			builder.put(grammarAccess.getEntityScalarDataPropertyAccess().getNameAssignment_3(), "rule__EntityScalarDataProperty__NameAssignment_3");
			builder.put(grammarAccess.getEntityScalarDataPropertyAccess().getDomainAssignment_6(), "rule__EntityScalarDataProperty__DomainAssignment_6");
			builder.put(grammarAccess.getEntityScalarDataPropertyAccess().getRangeAssignment_8(), "rule__EntityScalarDataProperty__RangeAssignment_8");
			builder.put(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAssignment_0(), "rule__StructuredDataProperty__AnnotationsAssignment_0");
			builder.put(grammarAccess.getStructuredDataPropertyAccess().getNameAssignment_2(), "rule__StructuredDataProperty__NameAssignment_2");
			builder.put(grammarAccess.getStructuredDataPropertyAccess().getDomainAssignment_5(), "rule__StructuredDataProperty__DomainAssignment_5");
			builder.put(grammarAccess.getStructuredDataPropertyAccess().getRangeAssignment_7(), "rule__StructuredDataProperty__RangeAssignment_7");
			builder.put(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAssignment_0(), "rule__ScalarDataProperty__AnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarDataPropertyAccess().getNameAssignment_2(), "rule__ScalarDataProperty__NameAssignment_2");
			builder.put(grammarAccess.getScalarDataPropertyAccess().getDomainAssignment_5(), "rule__ScalarDataProperty__DomainAssignment_5");
			builder.put(grammarAccess.getScalarDataPropertyAccess().getRangeAssignment_7(), "rule__ScalarDataProperty__RangeAssignment_7");
			builder.put(grammarAccess.getChainRuleAccess().getNameAssignment_1(), "rule__ChainRule__NameAssignment_1");
			builder.put(grammarAccess.getChainRuleAccess().getHeadAssignment_3(), "rule__ChainRule__HeadAssignment_3");
			builder.put(grammarAccess.getChainRuleAccess().getFirstSegmentAssignment_5(), "rule__ChainRule__FirstSegmentAssignment_5");
			builder.put(grammarAccess.getRuleBodySegmentAccess().getPredicateAssignment_0(), "rule__RuleBodySegment__PredicateAssignment_0");
			builder.put(grammarAccess.getRuleBodySegmentAccess().getNextSegmentAssignment_1_1(), "rule__RuleBodySegment__NextSegmentAssignment_1_1");
			builder.put(grammarAccess.getSegmentPredicateAccess().getPredicateAssignment_0(), "rule__SegmentPredicate__PredicateAssignment_0");
			builder.put(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceAssignment_1_2(), "rule__SegmentPredicate__ReifiedRelationshipSourceAssignment_1_2");
			builder.put(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceAssignment_2_2(), "rule__SegmentPredicate__ReifiedRelationshipInverseSourceAssignment_2_2");
			builder.put(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetAssignment_3_2(), "rule__SegmentPredicate__ReifiedRelationshipTargetAssignment_3_2");
			builder.put(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetAssignment_4_2(), "rule__SegmentPredicate__ReifiedRelationshipInverseTargetAssignment_4_2");
			builder.put(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseAssignment_5_2(), "rule__SegmentPredicate__UnreifiedRelationshipInverseAssignment_5_2");
			builder.put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAssignment_0(), "rule__AnonymousConceptUnionAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameAssignment_3(), "rule__AnonymousConceptUnionAxiom__NameAssignment_3");
			builder.put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsAssignment_6(), "rule__AnonymousConceptUnionAxiom__DisjunctionsAssignment_6");
			builder.put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAssignment_0(), "rule__RootConceptTaxonomyAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootAssignment_3(), "rule__RootConceptTaxonomyAxiom__RootAssignment_3");
			builder.put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsAssignment_6(), "rule__RootConceptTaxonomyAxiom__DisjunctionsAssignment_6");
			builder.put(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAssignment_0(), "rule__SpecificDisjointConceptAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafAssignment_3(), "rule__SpecificDisjointConceptAxiom__DisjointLeafAssignment_3");
			builder.put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityExistentialRestrictionAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainAssignment_2(), "rule__EntityExistentialRestrictionAxiom__RestrictedDomainAssignment_2");
			builder.put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipAssignment_4(), "rule__EntityExistentialRestrictionAxiom__RestrictedRelationshipAssignment_4");
			builder.put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeAssignment_6(), "rule__EntityExistentialRestrictionAxiom__RestrictedRangeAssignment_6");
			builder.put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityUniversalRestrictionAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainAssignment_2(), "rule__EntityUniversalRestrictionAxiom__RestrictedDomainAssignment_2");
			builder.put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipAssignment_4(), "rule__EntityUniversalRestrictionAxiom__RestrictedRelationshipAssignment_4");
			builder.put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeAssignment_6(), "rule__EntityUniversalRestrictionAxiom__RestrictedRangeAssignment_6");
			builder.put(grammarAccess.getAspectSpecializationAxiomAccess().getAnnotationsAssignment_0(), "rule__AspectSpecializationAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityAssignment_1(), "rule__AspectSpecializationAxiom__SubEntityAssignment_1");
			builder.put(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAssignment_3(), "rule__AspectSpecializationAxiom__SuperAspectAssignment_3");
			builder.put(grammarAccess.getConceptSpecializationAxiomAccess().getAnnotationsAssignment_0(), "rule__ConceptSpecializationAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptAssignment_1(), "rule__ConceptSpecializationAxiom__SubConceptAssignment_1");
			builder.put(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptAssignment_3(), "rule__ConceptSpecializationAxiom__SuperConceptAssignment_3");
			builder.put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipSpecializationAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipAssignment_1(), "rule__ReifiedRelationshipSpecializationAxiom__SubRelationshipAssignment_1");
			builder.put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipAssignment_3(), "rule__ReifiedRelationshipSpecializationAxiom__SuperRelationshipAssignment_3");
			builder.put(grammarAccess.getSubObjectPropertyOfAxiomAccess().getAnnotationsAssignment_0(), "rule__SubObjectPropertyOfAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyAssignment_1(), "rule__SubObjectPropertyOfAxiom__SubPropertyAssignment_1");
			builder.put(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSuperPropertyAssignment_3(), "rule__SubObjectPropertyOfAxiom__SuperPropertyAssignment_3");
			builder.put(grammarAccess.getSubDataPropertyOfAxiomAccess().getAnnotationsAssignment_0(), "rule__SubDataPropertyOfAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyAssignment_1(), "rule__SubDataPropertyOfAxiom__SubPropertyAssignment_1");
			builder.put(grammarAccess.getSubDataPropertyOfAxiomAccess().getSuperPropertyAssignment_3(), "rule__SubDataPropertyOfAxiom__SuperPropertyAssignment_3");
			builder.put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityAssignment_2(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__RestrictedEntityAssignment_2");
			builder.put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyAssignment_4(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarPropertyAssignment_4");
			builder.put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionAssignment_6(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarRestrictionAssignment_6");
			builder.put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_2(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_2");
			builder.put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyAssignment_4(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__ScalarPropertyAssignment_4");
			builder.put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueAssignment_6(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__LiteralValueAssignment_6");
			builder.put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeAssignment_7_1(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__ValueTypeAssignment_7_1");
			builder.put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityAssignment_2(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__RestrictedEntityAssignment_2");
			builder.put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyAssignment_4(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarPropertyAssignment_4");
			builder.put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionAssignment_6(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarRestrictionAssignment_6");
			builder.put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_2(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_2");
			builder.put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyAssignment_4(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyAssignment_4");
			builder.put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsAssignment_7_0(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyRestrictionsAssignment_7_0");
			builder.put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsAssignment_7_1(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__ScalarDataPropertyRestrictionsAssignment_7_1");
			builder.put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAnnotationsAssignment_0(), "rule__RestrictionStructuredDataPropertyTuple__AnnotationsAssignment_0");
			builder.put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_1(), "rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyAssignment_1");
			builder.put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsAssignment_4_0(), "rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyRestrictionsAssignment_4_0");
			builder.put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsAssignment_4_1(), "rule__RestrictionStructuredDataPropertyTuple__ScalarDataPropertyRestrictionsAssignment_4_1");
			builder.put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getAnnotationsAssignment_0(), "rule__RestrictionScalarDataPropertyValue__AnnotationsAssignment_0");
			builder.put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_1(), "rule__RestrictionScalarDataPropertyValue__ScalarDataPropertyAssignment_1");
			builder.put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_3(), "rule__RestrictionScalarDataPropertyValue__ScalarPropertyValueAssignment_3");
			builder.put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeAssignment_4_1(), "rule__RestrictionScalarDataPropertyValue__ValueTypeAssignment_4_1");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__BinaryScalarRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getNameAssignment_2(), "rule__BinaryScalarRestriction__NameAssignment_2");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getLengthAssignment_4_0_1(), "rule__BinaryScalarRestriction__LengthAssignment_4_0_1");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthAssignment_4_1_1(), "rule__BinaryScalarRestriction__MinLengthAssignment_4_1_1");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthAssignment_4_2_1(), "rule__BinaryScalarRestriction__MaxLengthAssignment_4_2_1");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__BinaryScalarRestriction__RestrictedRangeAssignment_6");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__IRIScalarRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getNameAssignment_2(), "rule__IRIScalarRestriction__NameAssignment_2");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getLengthAssignment_4_0_1(), "rule__IRIScalarRestriction__LengthAssignment_4_0_1");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthAssignment_4_1_1(), "rule__IRIScalarRestriction__MinLengthAssignment_4_1_1");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthAssignment_4_2_1(), "rule__IRIScalarRestriction__MaxLengthAssignment_4_2_1");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getPatternAssignment_4_3_1(), "rule__IRIScalarRestriction__PatternAssignment_4_3_1");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__IRIScalarRestriction__RestrictedRangeAssignment_6");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__NumericScalarRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getNameAssignment_2(), "rule__NumericScalarRestriction__NameAssignment_2");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveAssignment_4_0_1(), "rule__NumericScalarRestriction__MinInclusiveAssignment_4_0_1");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveAssignment_4_1_1(), "rule__NumericScalarRestriction__MaxInclusiveAssignment_4_1_1");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveAssignment_4_2_1(), "rule__NumericScalarRestriction__MinExclusiveAssignment_4_2_1");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveAssignment_4_3_1(), "rule__NumericScalarRestriction__MaxExclusiveAssignment_4_3_1");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__NumericScalarRestriction__RestrictedRangeAssignment_6");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__PlainLiteralScalarRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameAssignment_2(), "rule__PlainLiteralScalarRestriction__NameAssignment_2");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthAssignment_4_0_1(), "rule__PlainLiteralScalarRestriction__LengthAssignment_4_0_1");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthAssignment_4_1_1(), "rule__PlainLiteralScalarRestriction__MinLengthAssignment_4_1_1");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthAssignment_4_2_1(), "rule__PlainLiteralScalarRestriction__MaxLengthAssignment_4_2_1");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternAssignment_4_3_1(), "rule__PlainLiteralScalarRestriction__PatternAssignment_4_3_1");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeAssignment_4_4_1(), "rule__PlainLiteralScalarRestriction__LangRangeAssignment_4_4_1");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__PlainLiteralScalarRestriction__RestrictedRangeAssignment_6");
			builder.put(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAssignment_0(), "rule__ScalarOneOfRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarOneOfRestrictionAccess().getNameAssignment_2(), "rule__ScalarOneOfRestriction__NameAssignment_2");
			builder.put(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__ScalarOneOfRestriction__RestrictedRangeAssignment_5");
			builder.put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAssignment_0(), "rule__ScalarOneOfLiteralAxiom__AnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomAssignment_2(), "rule__ScalarOneOfLiteralAxiom__AxiomAssignment_2");
			builder.put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueAssignment_4(), "rule__ScalarOneOfLiteralAxiom__ValueAssignment_4");
			builder.put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeAssignment_5_1(), "rule__ScalarOneOfLiteralAxiom__ValueTypeAssignment_5_1");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__StringScalarRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getNameAssignment_2(), "rule__StringScalarRestriction__NameAssignment_2");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getLengthAssignment_4_0_1(), "rule__StringScalarRestriction__LengthAssignment_4_0_1");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getMinLengthAssignment_4_1_1(), "rule__StringScalarRestriction__MinLengthAssignment_4_1_1");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthAssignment_4_2_1(), "rule__StringScalarRestriction__MaxLengthAssignment_4_2_1");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getPatternAssignment_4_3_1(), "rule__StringScalarRestriction__PatternAssignment_4_3_1");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__StringScalarRestriction__RestrictedRangeAssignment_6");
			builder.put(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__SynonymScalarRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getSynonymScalarRestrictionAccess().getNameAssignment_2(), "rule__SynonymScalarRestriction__NameAssignment_2");
			builder.put(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__SynonymScalarRestriction__RestrictedRangeAssignment_5");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__TimeScalarRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getNameAssignment_2(), "rule__TimeScalarRestriction__NameAssignment_2");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveAssignment_4_0_1(), "rule__TimeScalarRestriction__MinInclusiveAssignment_4_0_1");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveAssignment_4_1_1(), "rule__TimeScalarRestriction__MaxInclusiveAssignment_4_1_1");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveAssignment_4_2_1(), "rule__TimeScalarRestriction__MinExclusiveAssignment_4_2_1");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveAssignment_4_3_1(), "rule__TimeScalarRestriction__MaxExclusiveAssignment_4_3_1");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__TimeScalarRestriction__RestrictedRangeAssignment_6");
			builder.put(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getAnnotationsAssignment_0(), "rule__DescriptionBoxExtendsClosedWorldDefinitions__AnnotationsAssignment_0");
			builder.put(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsAssignment_2(), "rule__DescriptionBoxExtendsClosedWorldDefinitions__ClosedWorldDefinitionsAssignment_2");
			builder.put(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAssignment_0(), "rule__DescriptionBoxRefinement__AnnotationsAssignment_0");
			builder.put(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxAssignment_2(), "rule__DescriptionBoxRefinement__RefinedDescriptionBoxAssignment_2");
			builder.put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getAnnotationsAssignment_0(), "rule__SingletonInstanceScalarDataPropertyValue__AnnotationsAssignment_0");
			builder.put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceAssignment_1(), "rule__SingletonInstanceScalarDataPropertyValue__SingletonInstanceAssignment_1");
			builder.put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_3(), "rule__SingletonInstanceScalarDataPropertyValue__ScalarDataPropertyAssignment_3");
			builder.put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_5(), "rule__SingletonInstanceScalarDataPropertyValue__ScalarPropertyValueAssignment_5");
			builder.put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeAssignment_6_1(), "rule__SingletonInstanceScalarDataPropertyValue__ValueTypeAssignment_6_1");
			builder.put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAnnotationsAssignment_0(), "rule__SingletonInstanceStructuredDataPropertyValue__AnnotationsAssignment_0");
			builder.put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceAssignment_1(), "rule__SingletonInstanceStructuredDataPropertyValue__SingletonInstanceAssignment_1");
			builder.put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyAssignment_3(), "rule__SingletonInstanceStructuredDataPropertyValue__StructuredDataPropertyAssignment_3");
			builder.put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesAssignment_6_0(), "rule__SingletonInstanceStructuredDataPropertyValue__StructuredPropertyTuplesAssignment_6_0");
			builder.put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesAssignment_6_1(), "rule__SingletonInstanceStructuredDataPropertyValue__ScalarDataPropertyValuesAssignment_6_1");
			builder.put(grammarAccess.getStructuredDataPropertyTupleAccess().getAnnotationsAssignment_0(), "rule__StructuredDataPropertyTuple__AnnotationsAssignment_0");
			builder.put(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_1(), "rule__StructuredDataPropertyTuple__StructuredDataPropertyAssignment_1");
			builder.put(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_4_0(), "rule__StructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_4_0");
			builder.put(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_4_1(), "rule__StructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_4_1");
			builder.put(grammarAccess.getScalarDataPropertyValueAccess().getAnnotationsAssignment_0(), "rule__ScalarDataPropertyValue__AnnotationsAssignment_0");
			builder.put(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_1(), "rule__ScalarDataPropertyValue__ScalarDataPropertyAssignment_1");
			builder.put(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_3(), "rule__ScalarDataPropertyValue__ScalarPropertyValueAssignment_3");
			builder.put(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeAssignment_4_1(), "rule__ScalarDataPropertyValue__ValueTypeAssignment_4_1");
			builder.put(grammarAccess.getConceptInstanceAccess().getAnnotationsAssignment_0(), "rule__ConceptInstance__AnnotationsAssignment_0");
			builder.put(grammarAccess.getConceptInstanceAccess().getNameAssignment_3(), "rule__ConceptInstance__NameAssignment_3");
			builder.put(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierAssignment_5(), "rule__ConceptInstance__SingletonConceptClassifierAssignment_5");
			builder.put(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipInstance__AnnotationsAssignment_0");
			builder.put(grammarAccess.getReifiedRelationshipInstanceAccess().getNameAssignment_3(), "rule__ReifiedRelationshipInstance__NameAssignment_3");
			builder.put(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonConceptualRelationshipClassifierAssignment_5(), "rule__ReifiedRelationshipInstance__SingletonConceptualRelationshipClassifierAssignment_5");
			builder.put(grammarAccess.getInstanceRelationshipValueRestrictionAccess().getAnnotationsAssignment_0(), "rule__InstanceRelationshipValueRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getInstanceRelationshipValueRestrictionAccess().getDomainAssignment_1(), "rule__InstanceRelationshipValueRestriction__DomainAssignment_1");
			builder.put(grammarAccess.getInstanceRelationshipValueRestrictionAccess().getRestrictedRelationshipAssignment_3(), "rule__InstanceRelationshipValueRestriction__RestrictedRelationshipAssignment_3");
			builder.put(grammarAccess.getInstanceRelationshipValueRestrictionAccess().getRangeAssignment_5(), "rule__InstanceRelationshipValueRestriction__RangeAssignment_5");
			builder.put(grammarAccess.getInstanceRelationshipExistentialRangeRestrictionAccess().getAnnotationsAssignment_0(), "rule__InstanceRelationshipExistentialRangeRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getInstanceRelationshipExistentialRangeRestrictionAccess().getDomainAssignment_2(), "rule__InstanceRelationshipExistentialRangeRestriction__DomainAssignment_2");
			builder.put(grammarAccess.getInstanceRelationshipExistentialRangeRestrictionAccess().getRestrictedRelationshipAssignment_4(), "rule__InstanceRelationshipExistentialRangeRestriction__RestrictedRelationshipAssignment_4");
			builder.put(grammarAccess.getInstanceRelationshipExistentialRangeRestrictionAccess().getRangeAssignment_6(), "rule__InstanceRelationshipExistentialRangeRestriction__RangeAssignment_6");
			builder.put(grammarAccess.getInstanceRelationshipUniversalRangeRestrictionAccess().getAnnotationsAssignment_0(), "rule__InstanceRelationshipUniversalRangeRestriction__AnnotationsAssignment_0");
			builder.put(grammarAccess.getInstanceRelationshipUniversalRangeRestrictionAccess().getDomainAssignment_2(), "rule__InstanceRelationshipUniversalRangeRestriction__DomainAssignment_2");
			builder.put(grammarAccess.getInstanceRelationshipUniversalRangeRestrictionAccess().getRestrictedRelationshipAssignment_4(), "rule__InstanceRelationshipUniversalRangeRestriction__RestrictedRelationshipAssignment_4");
			builder.put(grammarAccess.getInstanceRelationshipUniversalRangeRestrictionAccess().getRangeAssignment_6(), "rule__InstanceRelationshipUniversalRangeRestriction__RangeAssignment_6");
			builder.put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipInstanceDomain__AnnotationsAssignment_0");
			builder.put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceAssignment_3(), "rule__ReifiedRelationshipInstanceDomain__ReifiedRelationshipInstanceAssignment_3");
			builder.put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainAssignment_6(), "rule__ReifiedRelationshipInstanceDomain__DomainAssignment_6");
			builder.put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipInstanceRange__AnnotationsAssignment_0");
			builder.put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceAssignment_3(), "rule__ReifiedRelationshipInstanceRange__ReifiedRelationshipInstanceAssignment_3");
			builder.put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeAssignment_6(), "rule__ReifiedRelationshipInstanceRange__RangeAssignment_6");
			builder.put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAssignment_0(), "rule__UnreifiedRelationshipInstanceTuple__AnnotationsAssignment_0");
			builder.put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipAssignment_4(), "rule__UnreifiedRelationshipInstanceTuple__UnreifiedRelationshipAssignment_4");
			builder.put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainAssignment_6(), "rule__UnreifiedRelationshipInstanceTuple__DomainAssignment_6");
			builder.put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeAssignment_8(), "rule__UnreifiedRelationshipInstanceTuple__RangeAssignment_8");
			builder.put(grammarAccess.getLiteralBooleanAccess().getBoolAssignment_1(), "rule__LiteralBoolean__BoolAssignment_1");
			builder.put(grammarAccess.getLiteralDateTimeAccess().getDateTimeAssignment_1(), "rule__LiteralDateTime__DateTimeAssignment_1");
			builder.put(grammarAccess.getLiteralQuotedStringAccess().getStringAssignment_1(), "rule__LiteralQuotedString__StringAssignment_1");
			builder.put(grammarAccess.getLiteralRawStringAccess().getStringAssignment_1(), "rule__LiteralRawString__StringAssignment_1");
			builder.put(grammarAccess.getLiteralUUIDAccess().getUuidAssignment_1(), "rule__LiteralUUID__UuidAssignment_1");
			builder.put(grammarAccess.getLiteralURIAccess().getUriAssignment_1(), "rule__LiteralURI__UriAssignment_1");
			builder.put(grammarAccess.getLiteralRealAccess().getRealAssignment_1(), "rule__LiteralReal__RealAssignment_1");
			builder.put(grammarAccess.getLiteralRationalAccess().getRationalAssignment_1(), "rule__LiteralRational__RationalAssignment_1");
			builder.put(grammarAccess.getLiteralFloatAccess().getFloatAssignment_1(), "rule__LiteralFloat__FloatAssignment_1");
			builder.put(grammarAccess.getLiteralDecimalAccess().getDecimalAssignment_0_1(), "rule__LiteralDecimal__DecimalAssignment_0_1");
			builder.put(grammarAccess.getLiteralDecimalAccess().getDecimalAssignment_1(), "rule__LiteralDecimal__DecimalAssignment_1");
			builder.put(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), "rule__ReifiedRelationship__UnorderedGroup_4");
			builder.put(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), "rule__UnreifiedRelationship__UnorderedGroup_4");
			builder.put(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), "rule__BinaryScalarRestriction__UnorderedGroup_4");
			builder.put(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), "rule__IRIScalarRestriction__UnorderedGroup_4");
			builder.put(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), "rule__NumericScalarRestriction__UnorderedGroup_4");
			builder.put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), "rule__PlainLiteralScalarRestriction__UnorderedGroup_4");
			builder.put(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), "rule__StringScalarRestriction__UnorderedGroup_4");
			builder.put(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), "rule__TimeScalarRestriction__UnorderedGroup_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private OMLGrammarAccess grammarAccess;

	@Override
	protected InternalOMLParser createParser() {
		InternalOMLParser result = new InternalOMLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public OMLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(OMLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
