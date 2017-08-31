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

import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.ide.contentassist.antlr.internal.InternalOMLParser;
import gov.nasa.jpl.imce.oml.dsl.services.OMLGrammarAccess;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class OMLParser extends AbstractContentAssistParser {

	@Inject
	private OMLGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalOMLParser createParser() {
		InternalOMLParser result = new InternalOMLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getExtentAccess().getAlternatives_1(), "rule__Extent__Alternatives_1");
					put(grammarAccess.getModuleAccess().getAlternatives(), "rule__Module__Alternatives");
					put(grammarAccess.getTerminologyBoxAccess().getAlternatives(), "rule__TerminologyBox__Alternatives");
					put(grammarAccess.getTerminologyGraphAccess().getAlternatives_5(), "rule__TerminologyGraph__Alternatives_5");
					put(grammarAccess.getBundleAccess().getAlternatives_5(), "rule__Bundle__Alternatives_5");
					put(grammarAccess.getDescriptionBoxAccess().getAlternatives_5(), "rule__DescriptionBox__Alternatives_5");
					put(grammarAccess.getTerminologyBoxAxiomAccess().getAlternatives(), "rule__TerminologyBoxAxiom__Alternatives");
					put(grammarAccess.getTerminologyBoxStatementAccess().getAlternatives(), "rule__TerminologyBoxStatement__Alternatives");
					put(grammarAccess.getTermAccess().getAlternatives(), "rule__Term__Alternatives");
					put(grammarAccess.getAtomicEntityAccess().getAlternatives(), "rule__AtomicEntity__Alternatives");
					put(grammarAccess.getEntityRelationshipAccess().getAlternatives(), "rule__EntityRelationship__Alternatives");
					put(grammarAccess.getDatatypeAccess().getAlternatives(), "rule__Datatype__Alternatives");
					put(grammarAccess.getScalarDataRangeAccess().getAlternatives(), "rule__ScalarDataRange__Alternatives");
					put(grammarAccess.getRestrictedDataRangeAccess().getAlternatives(), "rule__RestrictedDataRange__Alternatives");
					put(grammarAccess.getDataRelationshipAccess().getAlternatives(), "rule__DataRelationship__Alternatives");
					put(grammarAccess.getTermAxiomAccess().getAlternatives(), "rule__TermAxiom__Alternatives");
					put(grammarAccess.getEntityRestrictionAxiomAccess().getAlternatives(), "rule__EntityRestrictionAxiom__Alternatives");
					put(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getAlternatives(), "rule__EntityScalarDataPropertyRestrictionAxiom__Alternatives");
					put(grammarAccess.getSpecializationAxiomAccess().getAlternatives(), "rule__SpecializationAxiom__Alternatives");
					put(grammarAccess.getConceptTreeDisjunctionAccess().getAlternatives(), "rule__ConceptTreeDisjunction__Alternatives");
					put(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getAlternatives(), "rule__DisjointUnionOfConceptsAxiom__Alternatives");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAlternatives_7(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Alternatives_7");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAlternatives_4(), "rule__RestrictionStructuredDataPropertyTuple__Alternatives_4");
					put(grammarAccess.getTerminologyInstanceAssertionAccess().getAlternatives(), "rule__TerminologyInstanceAssertion__Alternatives");
					put(grammarAccess.getConceptualEntitySingletonInstanceAccess().getAlternatives(), "rule__ConceptualEntitySingletonInstance__Alternatives");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAlternatives_6(), "rule__SingletonInstanceStructuredDataPropertyValue__Alternatives_6");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getAlternatives_4(), "rule__StructuredDataPropertyTuple__Alternatives_4");
					put(grammarAccess.getReferenceAccess().getAlternatives(), "rule__Reference__Alternatives");
					put(grammarAccess.getQNAMEAccess().getAlternatives(), "rule__QNAME__Alternatives");
					put(grammarAccess.getLiteralValueAccess().getAlternatives(), "rule__LiteralValue__Alternatives");
					put(grammarAccess.getLiteralNumberAccess().getAlternatives(), "rule__LiteralNumber__Alternatives");
					put(grammarAccess.getLiteralDecimalAccess().getAlternatives(), "rule__LiteralDecimal__Alternatives");
					put(grammarAccess.getTerminologyKindAccess().getAlternatives(), "rule__TerminologyKind__Alternatives");
					put(grammarAccess.getDescriptionKindAccess().getAlternatives(), "rule__DescriptionKind__Alternatives");
					put(grammarAccess.getExtentAccess().getGroup(), "rule__Extent__Group__0");
					put(grammarAccess.getAnnotationPropertyAccess().getGroup(), "rule__AnnotationProperty__Group__0");
					put(grammarAccess.getAnnotationPropertyValueAccess().getGroup(), "rule__AnnotationPropertyValue__Group__0");
					put(grammarAccess.getTerminologyGraphAccess().getGroup(), "rule__TerminologyGraph__Group__0");
					put(grammarAccess.getBundleAccess().getGroup(), "rule__Bundle__Group__0");
					put(grammarAccess.getDescriptionBoxAccess().getGroup(), "rule__DescriptionBox__Group__0");
					put(grammarAccess.getBundledTerminologyAxiomAccess().getGroup(), "rule__BundledTerminologyAxiom__Group__0");
					put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getGroup(), "rule__ConceptDesignationTerminologyAxiom__Group__0");
					put(grammarAccess.getTerminologyExtensionAxiomAccess().getGroup(), "rule__TerminologyExtensionAxiom__Group__0");
					put(grammarAccess.getTerminologyNestingAxiomAccess().getGroup(), "rule__TerminologyNestingAxiom__Group__0");
					put(grammarAccess.getAspectAccess().getGroup(), "rule__Aspect__Group__0");
					put(grammarAccess.getConceptAccess().getGroup(), "rule__Concept__Group__0");
					put(grammarAccess.getReifiedRelationshipAccess().getGroup(), "rule__ReifiedRelationship__Group__0");
					put(grammarAccess.getReifiedRelationshipAccess().getGroup_8(), "rule__ReifiedRelationship__Group_8__0");
					put(grammarAccess.getUnreifiedRelationshipAccess().getGroup(), "rule__UnreifiedRelationship__Group__0");
					put(grammarAccess.getScalarAccess().getGroup(), "rule__Scalar__Group__0");
					put(grammarAccess.getStructureAccess().getGroup(), "rule__Structure__Group__0");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getGroup(), "rule__EntityStructuredDataProperty__Group__0");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getGroup(), "rule__EntityScalarDataProperty__Group__0");
					put(grammarAccess.getStructuredDataPropertyAccess().getGroup(), "rule__StructuredDataProperty__Group__0");
					put(grammarAccess.getScalarDataPropertyAccess().getGroup(), "rule__ScalarDataProperty__Group__0");
					put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getGroup(), "rule__AnonymousConceptUnionAxiom__Group__0");
					put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getGroup(), "rule__RootConceptTaxonomyAxiom__Group__0");
					put(grammarAccess.getSpecificDisjointConceptAxiomAccess().getGroup(), "rule__SpecificDisjointConceptAxiom__Group__0");
					put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getGroup(), "rule__EntityExistentialRestrictionAxiom__Group__0");
					put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getGroup(), "rule__EntityUniversalRestrictionAxiom__Group__0");
					put(grammarAccess.getAspectSpecializationAxiomAccess().getGroup(), "rule__AspectSpecializationAxiom__Group__0");
					put(grammarAccess.getConceptSpecializationAxiomAccess().getGroup(), "rule__ConceptSpecializationAxiom__Group__0");
					put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getGroup(), "rule__ReifiedRelationshipSpecializationAxiom__Group__0");
					put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getGroup(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__0");
					put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getGroup(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__0");
					put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getGroup(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__0");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getGroup(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__0");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getGroup(), "rule__RestrictionStructuredDataPropertyTuple__Group__0");
					put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getGroup(), "rule__RestrictionScalarDataPropertyValue__Group__0");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup(), "rule__BinaryScalarRestriction__Group__0");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_0(), "rule__BinaryScalarRestriction__Group_4_0__0");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_1(), "rule__BinaryScalarRestriction__Group_4_1__0");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_2(), "rule__BinaryScalarRestriction__Group_4_2__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup(), "rule__IRIScalarRestriction__Group__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_0(), "rule__IRIScalarRestriction__Group_4_0__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_1(), "rule__IRIScalarRestriction__Group_4_1__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_2(), "rule__IRIScalarRestriction__Group_4_2__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_3(), "rule__IRIScalarRestriction__Group_4_3__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup(), "rule__NumericScalarRestriction__Group__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_0(), "rule__NumericScalarRestriction__Group_4_0__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_1(), "rule__NumericScalarRestriction__Group_4_1__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_2(), "rule__NumericScalarRestriction__Group_4_2__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_3(), "rule__NumericScalarRestriction__Group_4_3__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup(), "rule__PlainLiteralScalarRestriction__Group__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_0(), "rule__PlainLiteralScalarRestriction__Group_4_0__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_1(), "rule__PlainLiteralScalarRestriction__Group_4_1__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_2(), "rule__PlainLiteralScalarRestriction__Group_4_2__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_3(), "rule__PlainLiteralScalarRestriction__Group_4_3__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_4(), "rule__PlainLiteralScalarRestriction__Group_4_4__0");
					put(grammarAccess.getScalarOneOfRestrictionAccess().getGroup(), "rule__ScalarOneOfRestriction__Group__0");
					put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getGroup(), "rule__ScalarOneOfLiteralAxiom__Group__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup(), "rule__StringScalarRestriction__Group__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_0(), "rule__StringScalarRestriction__Group_4_0__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_1(), "rule__StringScalarRestriction__Group_4_1__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_2(), "rule__StringScalarRestriction__Group_4_2__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_3(), "rule__StringScalarRestriction__Group_4_3__0");
					put(grammarAccess.getSynonymScalarRestrictionAccess().getGroup(), "rule__SynonymScalarRestriction__Group__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup(), "rule__TimeScalarRestriction__Group__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_0(), "rule__TimeScalarRestriction__Group_4_0__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_1(), "rule__TimeScalarRestriction__Group_4_1__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_2(), "rule__TimeScalarRestriction__Group_4_2__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_3(), "rule__TimeScalarRestriction__Group_4_3__0");
					put(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getGroup(), "rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__0");
					put(grammarAccess.getDescriptionBoxRefinementAccess().getGroup(), "rule__DescriptionBoxRefinement__Group__0");
					put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getGroup(), "rule__SingletonInstanceScalarDataPropertyValue__Group__0");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getGroup(), "rule__SingletonInstanceStructuredDataPropertyValue__Group__0");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getGroup(), "rule__StructuredDataPropertyTuple__Group__0");
					put(grammarAccess.getScalarDataPropertyValueAccess().getGroup(), "rule__ScalarDataPropertyValue__Group__0");
					put(grammarAccess.getConceptInstanceAccess().getGroup(), "rule__ConceptInstance__Group__0");
					put(grammarAccess.getReifiedRelationshipInstanceAccess().getGroup(), "rule__ReifiedRelationshipInstance__Group__0");
					put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getGroup(), "rule__ReifiedRelationshipInstanceDomain__Group__0");
					put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getGroup(), "rule__ReifiedRelationshipInstanceRange__Group__0");
					put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getGroup(), "rule__UnreifiedRelationshipInstanceTuple__Group__0");
					put(grammarAccess.getLiteralDateTimeAccess().getGroup(), "rule__LiteralDateTime__Group__0");
					put(grammarAccess.getLiteralStringAccess().getGroup(), "rule__LiteralString__Group__0");
					put(grammarAccess.getLiteralUUIDAccess().getGroup(), "rule__LiteralUUID__Group__0");
					put(grammarAccess.getLiteralURIAccess().getGroup(), "rule__LiteralURI__Group__0");
					put(grammarAccess.getLiteralRealAccess().getGroup(), "rule__LiteralReal__Group__0");
					put(grammarAccess.getLiteralRationalAccess().getGroup(), "rule__LiteralRational__Group__0");
					put(grammarAccess.getLiteralFloatAccess().getGroup(), "rule__LiteralFloat__Group__0");
					put(grammarAccess.getLiteralDecimalAccess().getGroup_0(), "rule__LiteralDecimal__Group_0__0");
					put(grammarAccess.getExtentAccess().getAnnotationPropertiesAssignment_1_0(), "rule__Extent__AnnotationPropertiesAssignment_1_0");
					put(grammarAccess.getExtentAccess().getModulesAssignment_1_1(), "rule__Extent__ModulesAssignment_1_1");
					put(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIAssignment_1(), "rule__AnnotationProperty__AbbrevIRIAssignment_1");
					put(grammarAccess.getAnnotationPropertyAccess().getIriAssignment_3(), "rule__AnnotationProperty__IriAssignment_3");
					put(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAssignment_1(), "rule__AnnotationPropertyValue__PropertyAssignment_1");
					put(grammarAccess.getAnnotationPropertyValueAccess().getValueAssignment_3(), "rule__AnnotationPropertyValue__ValueAssignment_3");
					put(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_0(), "rule__TerminologyGraph__AnnotationsAssignment_0");
					put(grammarAccess.getTerminologyGraphAccess().getKindAssignment_1(), "rule__TerminologyGraph__KindAssignment_1");
					put(grammarAccess.getTerminologyGraphAccess().getIriAssignment_3(), "rule__TerminologyGraph__IriAssignment_3");
					put(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsAssignment_5_0(), "rule__TerminologyGraph__BoxAxiomsAssignment_5_0");
					put(grammarAccess.getTerminologyGraphAccess().getBoxStatementsAssignment_5_1(), "rule__TerminologyGraph__BoxStatementsAssignment_5_1");
					put(grammarAccess.getBundleAccess().getAnnotationsAssignment_0(), "rule__Bundle__AnnotationsAssignment_0");
					put(grammarAccess.getBundleAccess().getKindAssignment_1(), "rule__Bundle__KindAssignment_1");
					put(grammarAccess.getBundleAccess().getIriAssignment_3(), "rule__Bundle__IriAssignment_3");
					put(grammarAccess.getBundleAccess().getBoxAxiomsAssignment_5_0(), "rule__Bundle__BoxAxiomsAssignment_5_0");
					put(grammarAccess.getBundleAccess().getBoxStatementsAssignment_5_1(), "rule__Bundle__BoxStatementsAssignment_5_1");
					put(grammarAccess.getBundleAccess().getBundleStatementsAssignment_5_2(), "rule__Bundle__BundleStatementsAssignment_5_2");
					put(grammarAccess.getBundleAccess().getBundleAxiomsAssignment_5_3(), "rule__Bundle__BundleAxiomsAssignment_5_3");
					put(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_0(), "rule__DescriptionBox__AnnotationsAssignment_0");
					put(grammarAccess.getDescriptionBoxAccess().getKindAssignment_1(), "rule__DescriptionBox__KindAssignment_1");
					put(grammarAccess.getDescriptionBoxAccess().getIriAssignment_3(), "rule__DescriptionBox__IriAssignment_3");
					put(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsAssignment_5_0(), "rule__DescriptionBox__ClosedWorldDefinitionsAssignment_5_0");
					put(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsAssignment_5_1(), "rule__DescriptionBox__DescriptionBoxRefinementsAssignment_5_1");
					put(grammarAccess.getDescriptionBoxAccess().getConceptInstancesAssignment_5_2(), "rule__DescriptionBox__ConceptInstancesAssignment_5_2");
					put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesAssignment_5_3(), "rule__DescriptionBox__ReifiedRelationshipInstancesAssignment_5_3");
					put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsAssignment_5_4(), "rule__DescriptionBox__ReifiedRelationshipInstanceDomainsAssignment_5_4");
					put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesAssignment_5_5(), "rule__DescriptionBox__ReifiedRelationshipInstanceRangesAssignment_5_5");
					put(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesAssignment_5_6(), "rule__DescriptionBox__UnreifiedRelationshipInstanceTuplesAssignment_5_6");
					put(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesAssignment_5_7(), "rule__DescriptionBox__SingletonScalarDataPropertyValuesAssignment_5_7");
					put(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesAssignment_5_8(), "rule__DescriptionBox__SingletonStructuredDataPropertyValuesAssignment_5_8");
					put(grammarAccess.getBundledTerminologyAxiomAccess().getAnnotationsAssignment_0(), "rule__BundledTerminologyAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyAssignment_2(), "rule__BundledTerminologyAxiom__BundledTerminologyAssignment_2");
					put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getAnnotationsAssignment_0(), "rule__ConceptDesignationTerminologyAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyAssignment_4(), "rule__ConceptDesignationTerminologyAxiom__DesignatedTerminologyAssignment_4");
					put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptAssignment_6(), "rule__ConceptDesignationTerminologyAxiom__DesignatedConceptAssignment_6");
					put(grammarAccess.getTerminologyExtensionAxiomAccess().getAnnotationsAssignment_0(), "rule__TerminologyExtensionAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyAssignment_2(), "rule__TerminologyExtensionAxiom__ExtendedTerminologyAssignment_2");
					put(grammarAccess.getTerminologyNestingAxiomAccess().getAnnotationsAssignment_0(), "rule__TerminologyNestingAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyAssignment_4(), "rule__TerminologyNestingAxiom__NestingTerminologyAssignment_4");
					put(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextAssignment_6(), "rule__TerminologyNestingAxiom__NestingContextAssignment_6");
					put(grammarAccess.getAspectAccess().getAnnotationsAssignment_0(), "rule__Aspect__AnnotationsAssignment_0");
					put(grammarAccess.getAspectAccess().getNameAssignment_2(), "rule__Aspect__NameAssignment_2");
					put(grammarAccess.getConceptAccess().getAnnotationsAssignment_0(), "rule__Concept__AnnotationsAssignment_0");
					put(grammarAccess.getConceptAccess().getNameAssignment_2(), "rule__Concept__NameAssignment_2");
					put(grammarAccess.getReifiedRelationshipAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationship__AnnotationsAssignment_0");
					put(grammarAccess.getReifiedRelationshipAccess().getNameAssignment_2(), "rule__ReifiedRelationship__NameAssignment_2");
					put(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalAssignment_4_0(), "rule__ReifiedRelationship__IsFunctionalAssignment_4_0");
					put(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalAssignment_4_1(), "rule__ReifiedRelationship__IsInverseFunctionalAssignment_4_1");
					put(grammarAccess.getReifiedRelationshipAccess().getIsEssentialAssignment_4_2(), "rule__ReifiedRelationship__IsEssentialAssignment_4_2");
					put(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialAssignment_4_3(), "rule__ReifiedRelationship__IsInverseEssentialAssignment_4_3");
					put(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricAssignment_4_4(), "rule__ReifiedRelationship__IsSymmetricAssignment_4_4");
					put(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAssignment_4_5(), "rule__ReifiedRelationship__IsAsymmetricAssignment_4_5");
					put(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveAssignment_4_6(), "rule__ReifiedRelationship__IsReflexiveAssignment_4_6");
					put(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveAssignment_4_7(), "rule__ReifiedRelationship__IsIrreflexiveAssignment_4_7");
					put(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveAssignment_4_8(), "rule__ReifiedRelationship__IsTransitiveAssignment_4_8");
					put(grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameAssignment_7(), "rule__ReifiedRelationship__UnreifiedPropertyNameAssignment_7");
					put(grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameAssignment_8_2(), "rule__ReifiedRelationship__UnreifiedInversePropertyNameAssignment_8_2");
					put(grammarAccess.getReifiedRelationshipAccess().getSourceAssignment_11(), "rule__ReifiedRelationship__SourceAssignment_11");
					put(grammarAccess.getReifiedRelationshipAccess().getTargetAssignment_14(), "rule__ReifiedRelationship__TargetAssignment_14");
					put(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAssignment_0(), "rule__UnreifiedRelationship__AnnotationsAssignment_0");
					put(grammarAccess.getUnreifiedRelationshipAccess().getNameAssignment_2(), "rule__UnreifiedRelationship__NameAssignment_2");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalAssignment_4_0(), "rule__UnreifiedRelationship__IsFunctionalAssignment_4_0");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalAssignment_4_1(), "rule__UnreifiedRelationship__IsInverseFunctionalAssignment_4_1");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialAssignment_4_2(), "rule__UnreifiedRelationship__IsEssentialAssignment_4_2");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialAssignment_4_3(), "rule__UnreifiedRelationship__IsInverseEssentialAssignment_4_3");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricAssignment_4_4(), "rule__UnreifiedRelationship__IsSymmetricAssignment_4_4");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAssignment_4_5(), "rule__UnreifiedRelationship__IsAsymmetricAssignment_4_5");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveAssignment_4_6(), "rule__UnreifiedRelationship__IsReflexiveAssignment_4_6");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveAssignment_4_7(), "rule__UnreifiedRelationship__IsIrreflexiveAssignment_4_7");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveAssignment_4_8(), "rule__UnreifiedRelationship__IsTransitiveAssignment_4_8");
					put(grammarAccess.getUnreifiedRelationshipAccess().getSourceAssignment_7(), "rule__UnreifiedRelationship__SourceAssignment_7");
					put(grammarAccess.getUnreifiedRelationshipAccess().getTargetAssignment_10(), "rule__UnreifiedRelationship__TargetAssignment_10");
					put(grammarAccess.getScalarAccess().getAnnotationsAssignment_0(), "rule__Scalar__AnnotationsAssignment_0");
					put(grammarAccess.getScalarAccess().getNameAssignment_2(), "rule__Scalar__NameAssignment_2");
					put(grammarAccess.getStructureAccess().getAnnotationsAssignment_0(), "rule__Structure__AnnotationsAssignment_0");
					put(grammarAccess.getStructureAccess().getNameAssignment_2(), "rule__Structure__NameAssignment_2");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAssignment_0(), "rule__EntityStructuredDataProperty__AnnotationsAssignment_0");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaAssignment_2(), "rule__EntityStructuredDataProperty__IsIdentityCriteriaAssignment_2");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getNameAssignment_3(), "rule__EntityStructuredDataProperty__NameAssignment_3");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainAssignment_6(), "rule__EntityStructuredDataProperty__DomainAssignment_6");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeAssignment_8(), "rule__EntityStructuredDataProperty__RangeAssignment_8");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAssignment_0(), "rule__EntityScalarDataProperty__AnnotationsAssignment_0");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaAssignment_2(), "rule__EntityScalarDataProperty__IsIdentityCriteriaAssignment_2");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getNameAssignment_3(), "rule__EntityScalarDataProperty__NameAssignment_3");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getDomainAssignment_6(), "rule__EntityScalarDataProperty__DomainAssignment_6");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getRangeAssignment_8(), "rule__EntityScalarDataProperty__RangeAssignment_8");
					put(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAssignment_0(), "rule__StructuredDataProperty__AnnotationsAssignment_0");
					put(grammarAccess.getStructuredDataPropertyAccess().getNameAssignment_2(), "rule__StructuredDataProperty__NameAssignment_2");
					put(grammarAccess.getStructuredDataPropertyAccess().getDomainAssignment_5(), "rule__StructuredDataProperty__DomainAssignment_5");
					put(grammarAccess.getStructuredDataPropertyAccess().getRangeAssignment_7(), "rule__StructuredDataProperty__RangeAssignment_7");
					put(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAssignment_0(), "rule__ScalarDataProperty__AnnotationsAssignment_0");
					put(grammarAccess.getScalarDataPropertyAccess().getNameAssignment_2(), "rule__ScalarDataProperty__NameAssignment_2");
					put(grammarAccess.getScalarDataPropertyAccess().getDomainAssignment_5(), "rule__ScalarDataProperty__DomainAssignment_5");
					put(grammarAccess.getScalarDataPropertyAccess().getRangeAssignment_7(), "rule__ScalarDataProperty__RangeAssignment_7");
					put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAssignment_0(), "rule__AnonymousConceptUnionAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameAssignment_3(), "rule__AnonymousConceptUnionAxiom__NameAssignment_3");
					put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsAssignment_6(), "rule__AnonymousConceptUnionAxiom__DisjunctionsAssignment_6");
					put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAssignment_0(), "rule__RootConceptTaxonomyAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootAssignment_3(), "rule__RootConceptTaxonomyAxiom__RootAssignment_3");
					put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsAssignment_6(), "rule__RootConceptTaxonomyAxiom__DisjunctionsAssignment_6");
					put(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAssignment_0(), "rule__SpecificDisjointConceptAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafAssignment_3(), "rule__SpecificDisjointConceptAxiom__DisjointLeafAssignment_3");
					put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityExistentialRestrictionAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainAssignment_2(), "rule__EntityExistentialRestrictionAxiom__RestrictedDomainAssignment_2");
					put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationAssignment_4(), "rule__EntityExistentialRestrictionAxiom__RestrictedRelationAssignment_4");
					put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeAssignment_6(), "rule__EntityExistentialRestrictionAxiom__RestrictedRangeAssignment_6");
					put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityUniversalRestrictionAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainAssignment_2(), "rule__EntityUniversalRestrictionAxiom__RestrictedDomainAssignment_2");
					put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationAssignment_4(), "rule__EntityUniversalRestrictionAxiom__RestrictedRelationAssignment_4");
					put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeAssignment_6(), "rule__EntityUniversalRestrictionAxiom__RestrictedRangeAssignment_6");
					put(grammarAccess.getAspectSpecializationAxiomAccess().getAnnotationsAssignment_0(), "rule__AspectSpecializationAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityAssignment_1(), "rule__AspectSpecializationAxiom__SubEntityAssignment_1");
					put(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAssignment_3(), "rule__AspectSpecializationAxiom__SuperAspectAssignment_3");
					put(grammarAccess.getConceptSpecializationAxiomAccess().getAnnotationsAssignment_0(), "rule__ConceptSpecializationAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptAssignment_1(), "rule__ConceptSpecializationAxiom__SubConceptAssignment_1");
					put(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptAssignment_3(), "rule__ConceptSpecializationAxiom__SuperConceptAssignment_3");
					put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipSpecializationAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipAssignment_1(), "rule__ReifiedRelationshipSpecializationAxiom__SubRelationshipAssignment_1");
					put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipAssignment_3(), "rule__ReifiedRelationshipSpecializationAxiom__SuperRelationshipAssignment_3");
					put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityAssignment_2(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__RestrictedEntityAssignment_2");
					put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyAssignment_4(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarPropertyAssignment_4");
					put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionAssignment_6(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarRestrictionAssignment_6");
					put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_2(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_2");
					put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyAssignment_4(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__ScalarPropertyAssignment_4");
					put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueAssignment_6(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__LiteralValueAssignment_6");
					put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityAssignment_2(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__RestrictedEntityAssignment_2");
					put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyAssignment_4(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarPropertyAssignment_4");
					put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionAssignment_6(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarRestrictionAssignment_6");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAssignment_0(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_2(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_2");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyAssignment_4(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyAssignment_4");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsAssignment_7_0(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyRestrictionsAssignment_7_0");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsAssignment_7_1(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__ScalarDataPropertyRestrictionsAssignment_7_1");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAnnotationsAssignment_0(), "rule__RestrictionStructuredDataPropertyTuple__AnnotationsAssignment_0");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_1(), "rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyAssignment_1");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsAssignment_4_0(), "rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyRestrictionsAssignment_4_0");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsAssignment_4_1(), "rule__RestrictionStructuredDataPropertyTuple__ScalarDataPropertyRestrictionsAssignment_4_1");
					put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getAnnotationsAssignment_0(), "rule__RestrictionScalarDataPropertyValue__AnnotationsAssignment_0");
					put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_1(), "rule__RestrictionScalarDataPropertyValue__ScalarDataPropertyAssignment_1");
					put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_3(), "rule__RestrictionScalarDataPropertyValue__ScalarPropertyValueAssignment_3");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__BinaryScalarRestriction__AnnotationsAssignment_0");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getNameAssignment_2(), "rule__BinaryScalarRestriction__NameAssignment_2");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getLengthAssignment_4_0_1(), "rule__BinaryScalarRestriction__LengthAssignment_4_0_1");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthAssignment_4_1_1(), "rule__BinaryScalarRestriction__MinLengthAssignment_4_1_1");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthAssignment_4_2_1(), "rule__BinaryScalarRestriction__MaxLengthAssignment_4_2_1");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__BinaryScalarRestriction__RestrictedRangeAssignment_6");
					put(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__IRIScalarRestriction__AnnotationsAssignment_0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getNameAssignment_2(), "rule__IRIScalarRestriction__NameAssignment_2");
					put(grammarAccess.getIRIScalarRestrictionAccess().getLengthAssignment_4_0_1(), "rule__IRIScalarRestriction__LengthAssignment_4_0_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthAssignment_4_1_1(), "rule__IRIScalarRestriction__MinLengthAssignment_4_1_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthAssignment_4_2_1(), "rule__IRIScalarRestriction__MaxLengthAssignment_4_2_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getPatternAssignment_4_3_1(), "rule__IRIScalarRestriction__PatternAssignment_4_3_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__IRIScalarRestriction__RestrictedRangeAssignment_6");
					put(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__NumericScalarRestriction__AnnotationsAssignment_0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getNameAssignment_2(), "rule__NumericScalarRestriction__NameAssignment_2");
					put(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveAssignment_4_0_1(), "rule__NumericScalarRestriction__MinInclusiveAssignment_4_0_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveAssignment_4_1_1(), "rule__NumericScalarRestriction__MaxInclusiveAssignment_4_1_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveAssignment_4_2_1(), "rule__NumericScalarRestriction__MinExclusiveAssignment_4_2_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveAssignment_4_3_1(), "rule__NumericScalarRestriction__MaxExclusiveAssignment_4_3_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__NumericScalarRestriction__RestrictedRangeAssignment_6");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__PlainLiteralScalarRestriction__AnnotationsAssignment_0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameAssignment_2(), "rule__PlainLiteralScalarRestriction__NameAssignment_2");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthAssignment_4_0_1(), "rule__PlainLiteralScalarRestriction__LengthAssignment_4_0_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthAssignment_4_1_1(), "rule__PlainLiteralScalarRestriction__MinLengthAssignment_4_1_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthAssignment_4_2_1(), "rule__PlainLiteralScalarRestriction__MaxLengthAssignment_4_2_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternAssignment_4_3_1(), "rule__PlainLiteralScalarRestriction__PatternAssignment_4_3_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeAssignment_4_4_1(), "rule__PlainLiteralScalarRestriction__LangRangeAssignment_4_4_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__PlainLiteralScalarRestriction__RestrictedRangeAssignment_6");
					put(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAssignment_0(), "rule__ScalarOneOfRestriction__AnnotationsAssignment_0");
					put(grammarAccess.getScalarOneOfRestrictionAccess().getNameAssignment_2(), "rule__ScalarOneOfRestriction__NameAssignment_2");
					put(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__ScalarOneOfRestriction__RestrictedRangeAssignment_5");
					put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAssignment_0(), "rule__ScalarOneOfLiteralAxiom__AnnotationsAssignment_0");
					put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomAssignment_2(), "rule__ScalarOneOfLiteralAxiom__AxiomAssignment_2");
					put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueAssignment_4(), "rule__ScalarOneOfLiteralAxiom__ValueAssignment_4");
					put(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__StringScalarRestriction__AnnotationsAssignment_0");
					put(grammarAccess.getStringScalarRestrictionAccess().getNameAssignment_2(), "rule__StringScalarRestriction__NameAssignment_2");
					put(grammarAccess.getStringScalarRestrictionAccess().getLengthAssignment_4_0_1(), "rule__StringScalarRestriction__LengthAssignment_4_0_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getMinLengthAssignment_4_1_1(), "rule__StringScalarRestriction__MinLengthAssignment_4_1_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthAssignment_4_2_1(), "rule__StringScalarRestriction__MaxLengthAssignment_4_2_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getPatternAssignment_4_3_1(), "rule__StringScalarRestriction__PatternAssignment_4_3_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__StringScalarRestriction__RestrictedRangeAssignment_6");
					put(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__SynonymScalarRestriction__AnnotationsAssignment_0");
					put(grammarAccess.getSynonymScalarRestrictionAccess().getNameAssignment_2(), "rule__SynonymScalarRestriction__NameAssignment_2");
					put(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__SynonymScalarRestriction__RestrictedRangeAssignment_5");
					put(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAssignment_0(), "rule__TimeScalarRestriction__AnnotationsAssignment_0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getNameAssignment_2(), "rule__TimeScalarRestriction__NameAssignment_2");
					put(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveAssignment_4_0_1(), "rule__TimeScalarRestriction__MinInclusiveAssignment_4_0_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveAssignment_4_1_1(), "rule__TimeScalarRestriction__MaxInclusiveAssignment_4_1_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveAssignment_4_2_1(), "rule__TimeScalarRestriction__MinExclusiveAssignment_4_2_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveAssignment_4_3_1(), "rule__TimeScalarRestriction__MaxExclusiveAssignment_4_3_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeAssignment_6(), "rule__TimeScalarRestriction__RestrictedRangeAssignment_6");
					put(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getAnnotationsAssignment_0(), "rule__DescriptionBoxExtendsClosedWorldDefinitions__AnnotationsAssignment_0");
					put(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsAssignment_2(), "rule__DescriptionBoxExtendsClosedWorldDefinitions__ClosedWorldDefinitionsAssignment_2");
					put(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAssignment_0(), "rule__DescriptionBoxRefinement__AnnotationsAssignment_0");
					put(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxAssignment_2(), "rule__DescriptionBoxRefinement__RefinedDescriptionBoxAssignment_2");
					put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getAnnotationsAssignment_0(), "rule__SingletonInstanceScalarDataPropertyValue__AnnotationsAssignment_0");
					put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceAssignment_1(), "rule__SingletonInstanceScalarDataPropertyValue__SingletonInstanceAssignment_1");
					put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_3(), "rule__SingletonInstanceScalarDataPropertyValue__ScalarDataPropertyAssignment_3");
					put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_5(), "rule__SingletonInstanceScalarDataPropertyValue__ScalarPropertyValueAssignment_5");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAnnotationsAssignment_0(), "rule__SingletonInstanceStructuredDataPropertyValue__AnnotationsAssignment_0");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceAssignment_1(), "rule__SingletonInstanceStructuredDataPropertyValue__SingletonInstanceAssignment_1");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyAssignment_3(), "rule__SingletonInstanceStructuredDataPropertyValue__StructuredDataPropertyAssignment_3");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesAssignment_6_0(), "rule__SingletonInstanceStructuredDataPropertyValue__StructuredPropertyTuplesAssignment_6_0");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesAssignment_6_1(), "rule__SingletonInstanceStructuredDataPropertyValue__ScalarDataPropertyValuesAssignment_6_1");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getAnnotationsAssignment_0(), "rule__StructuredDataPropertyTuple__AnnotationsAssignment_0");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_1(), "rule__StructuredDataPropertyTuple__StructuredDataPropertyAssignment_1");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_4_0(), "rule__StructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_4_0");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_4_1(), "rule__StructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_4_1");
					put(grammarAccess.getScalarDataPropertyValueAccess().getAnnotationsAssignment_0(), "rule__ScalarDataPropertyValue__AnnotationsAssignment_0");
					put(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_1(), "rule__ScalarDataPropertyValue__ScalarDataPropertyAssignment_1");
					put(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_3(), "rule__ScalarDataPropertyValue__ScalarPropertyValueAssignment_3");
					put(grammarAccess.getConceptInstanceAccess().getAnnotationsAssignment_0(), "rule__ConceptInstance__AnnotationsAssignment_0");
					put(grammarAccess.getConceptInstanceAccess().getNameAssignment_3(), "rule__ConceptInstance__NameAssignment_3");
					put(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierAssignment_5(), "rule__ConceptInstance__SingletonConceptClassifierAssignment_5");
					put(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipInstance__AnnotationsAssignment_0");
					put(grammarAccess.getReifiedRelationshipInstanceAccess().getNameAssignment_3(), "rule__ReifiedRelationshipInstance__NameAssignment_3");
					put(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierAssignment_5(), "rule__ReifiedRelationshipInstance__SingletonReifiedRelationshipClassifierAssignment_5");
					put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipInstanceDomain__AnnotationsAssignment_0");
					put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceAssignment_3(), "rule__ReifiedRelationshipInstanceDomain__ReifiedRelationshipInstanceAssignment_3");
					put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainAssignment_6(), "rule__ReifiedRelationshipInstanceDomain__DomainAssignment_6");
					put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAssignment_0(), "rule__ReifiedRelationshipInstanceRange__AnnotationsAssignment_0");
					put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceAssignment_3(), "rule__ReifiedRelationshipInstanceRange__ReifiedRelationshipInstanceAssignment_3");
					put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeAssignment_6(), "rule__ReifiedRelationshipInstanceRange__RangeAssignment_6");
					put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAssignment_0(), "rule__UnreifiedRelationshipInstanceTuple__AnnotationsAssignment_0");
					put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipAssignment_4(), "rule__UnreifiedRelationshipInstanceTuple__UnreifiedRelationshipAssignment_4");
					put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainAssignment_6(), "rule__UnreifiedRelationshipInstanceTuple__DomainAssignment_6");
					put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeAssignment_8(), "rule__UnreifiedRelationshipInstanceTuple__RangeAssignment_8");
					put(grammarAccess.getLiteralDateTimeAccess().getDateTimeAssignment_1(), "rule__LiteralDateTime__DateTimeAssignment_1");
					put(grammarAccess.getLiteralStringAccess().getStringAssignment_1(), "rule__LiteralString__StringAssignment_1");
					put(grammarAccess.getLiteralUUIDAccess().getUuidAssignment_1(), "rule__LiteralUUID__UuidAssignment_1");
					put(grammarAccess.getLiteralURIAccess().getUriAssignment_1(), "rule__LiteralURI__UriAssignment_1");
					put(grammarAccess.getLiteralRealAccess().getRealAssignment_1(), "rule__LiteralReal__RealAssignment_1");
					put(grammarAccess.getLiteralRationalAccess().getRationalAssignment_1(), "rule__LiteralRational__RationalAssignment_1");
					put(grammarAccess.getLiteralFloatAccess().getFloatAssignment_1(), "rule__LiteralFloat__FloatAssignment_1");
					put(grammarAccess.getLiteralDecimalAccess().getDecimalAssignment_0_1(), "rule__LiteralDecimal__DecimalAssignment_0_1");
					put(grammarAccess.getLiteralDecimalAccess().getDecimalAssignment_1(), "rule__LiteralDecimal__DecimalAssignment_1");
					put(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), "rule__ReifiedRelationship__UnorderedGroup_4");
					put(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), "rule__UnreifiedRelationship__UnorderedGroup_4");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), "rule__BinaryScalarRestriction__UnorderedGroup_4");
					put(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), "rule__IRIScalarRestriction__UnorderedGroup_4");
					put(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), "rule__NumericScalarRestriction__UnorderedGroup_4");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), "rule__PlainLiteralScalarRestriction__UnorderedGroup_4");
					put(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), "rule__StringScalarRestriction__UnorderedGroup_4");
					put(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), "rule__TimeScalarRestriction__UnorderedGroup_4");
				}
			};
		}
		return nameMappings.get(element);
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
}
