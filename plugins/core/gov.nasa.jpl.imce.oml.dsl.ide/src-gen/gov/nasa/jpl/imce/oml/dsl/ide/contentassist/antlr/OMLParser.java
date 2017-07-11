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
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAlternatives_6(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Alternatives_6");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAlternatives_3(), "rule__RestrictionStructuredDataPropertyTuple__Alternatives_3");
					put(grammarAccess.getTerminologyInstanceAssertionAccess().getAlternatives(), "rule__TerminologyInstanceAssertion__Alternatives");
					put(grammarAccess.getConceptualEntitySingletonInstanceAccess().getAlternatives(), "rule__ConceptualEntitySingletonInstance__Alternatives");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAlternatives_5(), "rule__SingletonInstanceStructuredDataPropertyValue__Alternatives_5");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getAlternatives_3(), "rule__StructuredDataPropertyTuple__Alternatives_3");
					put(grammarAccess.getReferenceAccess().getAlternatives(), "rule__Reference__Alternatives");
					put(grammarAccess.getQNAMEAccess().getAlternatives(), "rule__QNAME__Alternatives");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getTerminologyKindAccess().getAlternatives(), "rule__TerminologyKind__Alternatives");
					put(grammarAccess.getDescriptionKindAccess().getAlternatives(), "rule__DescriptionKind__Alternatives");
					put(grammarAccess.getExtentAccess().getGroup(), "rule__Extent__Group__0");
					put(grammarAccess.getAnnotationPropertyAccess().getGroup(), "rule__AnnotationProperty__Group__0");
					put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
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
					put(grammarAccess.getReifiedRelationshipAccess().getGroup_7(), "rule__ReifiedRelationship__Group_7__0");
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
					put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_0(), "rule__BinaryScalarRestriction__Group_3_0__0");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_1(), "rule__BinaryScalarRestriction__Group_3_1__0");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_2(), "rule__BinaryScalarRestriction__Group_3_2__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup(), "rule__IRIScalarRestriction__Group__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_0(), "rule__IRIScalarRestriction__Group_3_0__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_1(), "rule__IRIScalarRestriction__Group_3_1__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_2(), "rule__IRIScalarRestriction__Group_3_2__0");
					put(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_3(), "rule__IRIScalarRestriction__Group_3_3__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup(), "rule__NumericScalarRestriction__Group__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_0(), "rule__NumericScalarRestriction__Group_3_0__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_1(), "rule__NumericScalarRestriction__Group_3_1__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_2(), "rule__NumericScalarRestriction__Group_3_2__0");
					put(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_3(), "rule__NumericScalarRestriction__Group_3_3__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup(), "rule__PlainLiteralScalarRestriction__Group__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_0(), "rule__PlainLiteralScalarRestriction__Group_3_0__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_1(), "rule__PlainLiteralScalarRestriction__Group_3_1__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_2(), "rule__PlainLiteralScalarRestriction__Group_3_2__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_3(), "rule__PlainLiteralScalarRestriction__Group_3_3__0");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_4(), "rule__PlainLiteralScalarRestriction__Group_3_4__0");
					put(grammarAccess.getScalarOneOfRestrictionAccess().getGroup(), "rule__ScalarOneOfRestriction__Group__0");
					put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getGroup(), "rule__ScalarOneOfLiteralAxiom__Group__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup(), "rule__StringScalarRestriction__Group__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_0(), "rule__StringScalarRestriction__Group_3_0__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_1(), "rule__StringScalarRestriction__Group_3_1__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_2(), "rule__StringScalarRestriction__Group_3_2__0");
					put(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_3(), "rule__StringScalarRestriction__Group_3_3__0");
					put(grammarAccess.getSynonymScalarRestrictionAccess().getGroup(), "rule__SynonymScalarRestriction__Group__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup(), "rule__TimeScalarRestriction__Group__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_0(), "rule__TimeScalarRestriction__Group_3_0__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_1(), "rule__TimeScalarRestriction__Group_3_1__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_2(), "rule__TimeScalarRestriction__Group_3_2__0");
					put(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_3(), "rule__TimeScalarRestriction__Group_3_3__0");
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
					put(grammarAccess.getExtentAccess().getAnnotationPropertiesAssignment_1_0(), "rule__Extent__AnnotationPropertiesAssignment_1_0");
					put(grammarAccess.getExtentAccess().getModulesAssignment_1_1(), "rule__Extent__ModulesAssignment_1_1");
					put(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIAssignment_1(), "rule__AnnotationProperty__AbbrevIRIAssignment_1");
					put(grammarAccess.getAnnotationPropertyAccess().getIriAssignment_3(), "rule__AnnotationProperty__IriAssignment_3");
					put(grammarAccess.getAnnotationAccess().getPropertyAssignment_1(), "rule__Annotation__PropertyAssignment_1");
					put(grammarAccess.getAnnotationAccess().getValueAssignment_3(), "rule__Annotation__ValueAssignment_3");
					put(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_0(), "rule__TerminologyGraph__AnnotationsAssignment_0");
					put(grammarAccess.getTerminologyGraphAccess().getKindAssignment_1(), "rule__TerminologyGraph__KindAssignment_1");
					put(grammarAccess.getTerminologyGraphAccess().getIriAssignment_3(), "rule__TerminologyGraph__IriAssignment_3");
					put(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_5_0(), "rule__TerminologyGraph__AnnotationsAssignment_5_0");
					put(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsAssignment_5_1(), "rule__TerminologyGraph__BoxAxiomsAssignment_5_1");
					put(grammarAccess.getTerminologyGraphAccess().getBoxStatementsAssignment_5_2(), "rule__TerminologyGraph__BoxStatementsAssignment_5_2");
					put(grammarAccess.getBundleAccess().getAnnotationsAssignment_0(), "rule__Bundle__AnnotationsAssignment_0");
					put(grammarAccess.getBundleAccess().getKindAssignment_1(), "rule__Bundle__KindAssignment_1");
					put(grammarAccess.getBundleAccess().getIriAssignment_3(), "rule__Bundle__IriAssignment_3");
					put(grammarAccess.getBundleAccess().getAnnotationsAssignment_5_0(), "rule__Bundle__AnnotationsAssignment_5_0");
					put(grammarAccess.getBundleAccess().getBoxAxiomsAssignment_5_1(), "rule__Bundle__BoxAxiomsAssignment_5_1");
					put(grammarAccess.getBundleAccess().getBoxStatementsAssignment_5_2(), "rule__Bundle__BoxStatementsAssignment_5_2");
					put(grammarAccess.getBundleAccess().getBundleStatementsAssignment_5_3(), "rule__Bundle__BundleStatementsAssignment_5_3");
					put(grammarAccess.getBundleAccess().getBundleAxiomsAssignment_5_4(), "rule__Bundle__BundleAxiomsAssignment_5_4");
					put(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_0(), "rule__DescriptionBox__AnnotationsAssignment_0");
					put(grammarAccess.getDescriptionBoxAccess().getKindAssignment_1(), "rule__DescriptionBox__KindAssignment_1");
					put(grammarAccess.getDescriptionBoxAccess().getIriAssignment_3(), "rule__DescriptionBox__IriAssignment_3");
					put(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_5_0(), "rule__DescriptionBox__AnnotationsAssignment_5_0");
					put(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsAssignment_5_1(), "rule__DescriptionBox__ClosedWorldDefinitionsAssignment_5_1");
					put(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsAssignment_5_2(), "rule__DescriptionBox__DescriptionBoxRefinementsAssignment_5_2");
					put(grammarAccess.getDescriptionBoxAccess().getConceptInstancesAssignment_5_3(), "rule__DescriptionBox__ConceptInstancesAssignment_5_3");
					put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesAssignment_5_4(), "rule__DescriptionBox__ReifiedRelationshipInstancesAssignment_5_4");
					put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsAssignment_5_5(), "rule__DescriptionBox__ReifiedRelationshipInstanceDomainsAssignment_5_5");
					put(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesAssignment_5_6(), "rule__DescriptionBox__ReifiedRelationshipInstanceRangesAssignment_5_6");
					put(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesAssignment_5_7(), "rule__DescriptionBox__UnreifiedRelationshipInstanceTuplesAssignment_5_7");
					put(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesAssignment_5_8(), "rule__DescriptionBox__SingletonScalarDataPropertyValuesAssignment_5_8");
					put(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesAssignment_5_9(), "rule__DescriptionBox__SingletonStructuredDataPropertyValuesAssignment_5_9");
					put(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyAssignment_1(), "rule__BundledTerminologyAxiom__BundledTerminologyAssignment_1");
					put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyAssignment_3(), "rule__ConceptDesignationTerminologyAxiom__DesignatedTerminologyAssignment_3");
					put(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptAssignment_5(), "rule__ConceptDesignationTerminologyAxiom__DesignatedConceptAssignment_5");
					put(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyAssignment_1(), "rule__TerminologyExtensionAxiom__ExtendedTerminologyAssignment_1");
					put(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyAssignment_3(), "rule__TerminologyNestingAxiom__NestingTerminologyAssignment_3");
					put(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextAssignment_5(), "rule__TerminologyNestingAxiom__NestingContextAssignment_5");
					put(grammarAccess.getAspectAccess().getNameAssignment_1(), "rule__Aspect__NameAssignment_1");
					put(grammarAccess.getConceptAccess().getNameAssignment_1(), "rule__Concept__NameAssignment_1");
					put(grammarAccess.getReifiedRelationshipAccess().getNameAssignment_1(), "rule__ReifiedRelationship__NameAssignment_1");
					put(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalAssignment_3_0(), "rule__ReifiedRelationship__IsFunctionalAssignment_3_0");
					put(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalAssignment_3_1(), "rule__ReifiedRelationship__IsInverseFunctionalAssignment_3_1");
					put(grammarAccess.getReifiedRelationshipAccess().getIsEssentialAssignment_3_2(), "rule__ReifiedRelationship__IsEssentialAssignment_3_2");
					put(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialAssignment_3_3(), "rule__ReifiedRelationship__IsInverseEssentialAssignment_3_3");
					put(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricAssignment_3_4(), "rule__ReifiedRelationship__IsSymmetricAssignment_3_4");
					put(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAssignment_3_5(), "rule__ReifiedRelationship__IsAsymmetricAssignment_3_5");
					put(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveAssignment_3_6(), "rule__ReifiedRelationship__IsReflexiveAssignment_3_6");
					put(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveAssignment_3_7(), "rule__ReifiedRelationship__IsIrreflexiveAssignment_3_7");
					put(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveAssignment_3_8(), "rule__ReifiedRelationship__IsTransitiveAssignment_3_8");
					put(grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameAssignment_6(), "rule__ReifiedRelationship__UnreifiedPropertyNameAssignment_6");
					put(grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameAssignment_7_2(), "rule__ReifiedRelationship__UnreifiedInversePropertyNameAssignment_7_2");
					put(grammarAccess.getReifiedRelationshipAccess().getSourceAssignment_10(), "rule__ReifiedRelationship__SourceAssignment_10");
					put(grammarAccess.getReifiedRelationshipAccess().getTargetAssignment_13(), "rule__ReifiedRelationship__TargetAssignment_13");
					put(grammarAccess.getUnreifiedRelationshipAccess().getNameAssignment_1(), "rule__UnreifiedRelationship__NameAssignment_1");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalAssignment_3_0(), "rule__UnreifiedRelationship__IsFunctionalAssignment_3_0");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalAssignment_3_1(), "rule__UnreifiedRelationship__IsInverseFunctionalAssignment_3_1");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialAssignment_3_2(), "rule__UnreifiedRelationship__IsEssentialAssignment_3_2");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialAssignment_3_3(), "rule__UnreifiedRelationship__IsInverseEssentialAssignment_3_3");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricAssignment_3_4(), "rule__UnreifiedRelationship__IsSymmetricAssignment_3_4");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAssignment_3_5(), "rule__UnreifiedRelationship__IsAsymmetricAssignment_3_5");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveAssignment_3_6(), "rule__UnreifiedRelationship__IsReflexiveAssignment_3_6");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveAssignment_3_7(), "rule__UnreifiedRelationship__IsIrreflexiveAssignment_3_7");
					put(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveAssignment_3_8(), "rule__UnreifiedRelationship__IsTransitiveAssignment_3_8");
					put(grammarAccess.getUnreifiedRelationshipAccess().getSourceAssignment_6(), "rule__UnreifiedRelationship__SourceAssignment_6");
					put(grammarAccess.getUnreifiedRelationshipAccess().getTargetAssignment_9(), "rule__UnreifiedRelationship__TargetAssignment_9");
					put(grammarAccess.getScalarAccess().getNameAssignment_1(), "rule__Scalar__NameAssignment_1");
					put(grammarAccess.getStructureAccess().getNameAssignment_1(), "rule__Structure__NameAssignment_1");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaAssignment_1(), "rule__EntityStructuredDataProperty__IsIdentityCriteriaAssignment_1");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getNameAssignment_2(), "rule__EntityStructuredDataProperty__NameAssignment_2");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainAssignment_5(), "rule__EntityStructuredDataProperty__DomainAssignment_5");
					put(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeAssignment_7(), "rule__EntityStructuredDataProperty__RangeAssignment_7");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaAssignment_1(), "rule__EntityScalarDataProperty__IsIdentityCriteriaAssignment_1");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getNameAssignment_2(), "rule__EntityScalarDataProperty__NameAssignment_2");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getDomainAssignment_5(), "rule__EntityScalarDataProperty__DomainAssignment_5");
					put(grammarAccess.getEntityScalarDataPropertyAccess().getRangeAssignment_7(), "rule__EntityScalarDataProperty__RangeAssignment_7");
					put(grammarAccess.getStructuredDataPropertyAccess().getNameAssignment_1(), "rule__StructuredDataProperty__NameAssignment_1");
					put(grammarAccess.getStructuredDataPropertyAccess().getDomainAssignment_4(), "rule__StructuredDataProperty__DomainAssignment_4");
					put(grammarAccess.getStructuredDataPropertyAccess().getRangeAssignment_6(), "rule__StructuredDataProperty__RangeAssignment_6");
					put(grammarAccess.getScalarDataPropertyAccess().getNameAssignment_1(), "rule__ScalarDataProperty__NameAssignment_1");
					put(grammarAccess.getScalarDataPropertyAccess().getDomainAssignment_4(), "rule__ScalarDataProperty__DomainAssignment_4");
					put(grammarAccess.getScalarDataPropertyAccess().getRangeAssignment_6(), "rule__ScalarDataProperty__RangeAssignment_6");
					put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameAssignment_2(), "rule__AnonymousConceptUnionAxiom__NameAssignment_2");
					put(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsAssignment_5(), "rule__AnonymousConceptUnionAxiom__DisjunctionsAssignment_5");
					put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootAssignment_2(), "rule__RootConceptTaxonomyAxiom__RootAssignment_2");
					put(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsAssignment_5(), "rule__RootConceptTaxonomyAxiom__DisjunctionsAssignment_5");
					put(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafAssignment_2(), "rule__SpecificDisjointConceptAxiom__DisjointLeafAssignment_2");
					put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainAssignment_1(), "rule__EntityExistentialRestrictionAxiom__RestrictedDomainAssignment_1");
					put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationAssignment_3(), "rule__EntityExistentialRestrictionAxiom__RestrictedRelationAssignment_3");
					put(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeAssignment_5(), "rule__EntityExistentialRestrictionAxiom__RestrictedRangeAssignment_5");
					put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainAssignment_1(), "rule__EntityUniversalRestrictionAxiom__RestrictedDomainAssignment_1");
					put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationAssignment_3(), "rule__EntityUniversalRestrictionAxiom__RestrictedRelationAssignment_3");
					put(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeAssignment_5(), "rule__EntityUniversalRestrictionAxiom__RestrictedRangeAssignment_5");
					put(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityAssignment_0(), "rule__AspectSpecializationAxiom__SubEntityAssignment_0");
					put(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAssignment_2(), "rule__AspectSpecializationAxiom__SuperAspectAssignment_2");
					put(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptAssignment_0(), "rule__ConceptSpecializationAxiom__SubConceptAssignment_0");
					put(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptAssignment_2(), "rule__ConceptSpecializationAxiom__SuperConceptAssignment_2");
					put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipAssignment_0(), "rule__ReifiedRelationshipSpecializationAxiom__SubRelationshipAssignment_0");
					put(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipAssignment_2(), "rule__ReifiedRelationshipSpecializationAxiom__SuperRelationshipAssignment_2");
					put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityAssignment_1(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__RestrictedEntityAssignment_1");
					put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyAssignment_3(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarPropertyAssignment_3");
					put(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionAssignment_5(), "rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarRestrictionAssignment_5");
					put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_1(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_1");
					put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyAssignment_3(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__ScalarPropertyAssignment_3");
					put(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueAssignment_5(), "rule__EntityScalarDataPropertyParticularRestrictionAxiom__LiteralValueAssignment_5");
					put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityAssignment_1(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__RestrictedEntityAssignment_1");
					put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyAssignment_3(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarPropertyAssignment_3");
					put(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionAssignment_5(), "rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarRestrictionAssignment_5");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_1(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_1");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyAssignment_3(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyAssignment_3");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredPropertyTuplesAssignment_6_0(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredPropertyTuplesAssignment_6_0");
					put(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyValuesAssignment_6_1(), "rule__EntityStructuredDataPropertyParticularRestrictionAxiom__ScalarDataPropertyValuesAssignment_6_1");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_0(), "rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyAssignment_0");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_3_0(), "rule__RestrictionStructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_3_0");
					put(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_3_1(), "rule__RestrictionStructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_3_1");
					put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_0(), "rule__RestrictionScalarDataPropertyValue__ScalarDataPropertyAssignment_0");
					put(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_2(), "rule__RestrictionScalarDataPropertyValue__ScalarPropertyValueAssignment_2");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getNameAssignment_1(), "rule__BinaryScalarRestriction__NameAssignment_1");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getLengthAssignment_3_0_1(), "rule__BinaryScalarRestriction__LengthAssignment_3_0_1");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthAssignment_3_1_1(), "rule__BinaryScalarRestriction__MinLengthAssignment_3_1_1");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthAssignment_3_2_1(), "rule__BinaryScalarRestriction__MaxLengthAssignment_3_2_1");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__BinaryScalarRestriction__RestrictedRangeAssignment_5");
					put(grammarAccess.getIRIScalarRestrictionAccess().getNameAssignment_1(), "rule__IRIScalarRestriction__NameAssignment_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getLengthAssignment_3_0_1(), "rule__IRIScalarRestriction__LengthAssignment_3_0_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthAssignment_3_1_1(), "rule__IRIScalarRestriction__MinLengthAssignment_3_1_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthAssignment_3_2_1(), "rule__IRIScalarRestriction__MaxLengthAssignment_3_2_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getPatternAssignment_3_3_1(), "rule__IRIScalarRestriction__PatternAssignment_3_3_1");
					put(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__IRIScalarRestriction__RestrictedRangeAssignment_5");
					put(grammarAccess.getNumericScalarRestrictionAccess().getNameAssignment_1(), "rule__NumericScalarRestriction__NameAssignment_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveAssignment_3_0_1(), "rule__NumericScalarRestriction__MinInclusiveAssignment_3_0_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveAssignment_3_1_1(), "rule__NumericScalarRestriction__MaxInclusiveAssignment_3_1_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveAssignment_3_2_1(), "rule__NumericScalarRestriction__MinExclusiveAssignment_3_2_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveAssignment_3_3_1(), "rule__NumericScalarRestriction__MaxExclusiveAssignment_3_3_1");
					put(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__NumericScalarRestriction__RestrictedRangeAssignment_5");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameAssignment_1(), "rule__PlainLiteralScalarRestriction__NameAssignment_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthAssignment_3_0_1(), "rule__PlainLiteralScalarRestriction__LengthAssignment_3_0_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthAssignment_3_1_1(), "rule__PlainLiteralScalarRestriction__MinLengthAssignment_3_1_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthAssignment_3_2_1(), "rule__PlainLiteralScalarRestriction__MaxLengthAssignment_3_2_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternAssignment_3_3_1(), "rule__PlainLiteralScalarRestriction__PatternAssignment_3_3_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeAssignment_3_4_1(), "rule__PlainLiteralScalarRestriction__LangRangeAssignment_3_4_1");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__PlainLiteralScalarRestriction__RestrictedRangeAssignment_5");
					put(grammarAccess.getScalarOneOfRestrictionAccess().getNameAssignment_1(), "rule__ScalarOneOfRestriction__NameAssignment_1");
					put(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeAssignment_4(), "rule__ScalarOneOfRestriction__RestrictedRangeAssignment_4");
					put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomAssignment_1(), "rule__ScalarOneOfLiteralAxiom__AxiomAssignment_1");
					put(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueAssignment_3(), "rule__ScalarOneOfLiteralAxiom__ValueAssignment_3");
					put(grammarAccess.getStringScalarRestrictionAccess().getNameAssignment_1(), "rule__StringScalarRestriction__NameAssignment_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getLengthAssignment_3_0_1(), "rule__StringScalarRestriction__LengthAssignment_3_0_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getMinLengthAssignment_3_1_1(), "rule__StringScalarRestriction__MinLengthAssignment_3_1_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthAssignment_3_2_1(), "rule__StringScalarRestriction__MaxLengthAssignment_3_2_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getPatternAssignment_3_3_1(), "rule__StringScalarRestriction__PatternAssignment_3_3_1");
					put(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__StringScalarRestriction__RestrictedRangeAssignment_5");
					put(grammarAccess.getSynonymScalarRestrictionAccess().getNameAssignment_1(), "rule__SynonymScalarRestriction__NameAssignment_1");
					put(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeAssignment_4(), "rule__SynonymScalarRestriction__RestrictedRangeAssignment_4");
					put(grammarAccess.getTimeScalarRestrictionAccess().getNameAssignment_1(), "rule__TimeScalarRestriction__NameAssignment_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveAssignment_3_0_1(), "rule__TimeScalarRestriction__MinInclusiveAssignment_3_0_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveAssignment_3_1_1(), "rule__TimeScalarRestriction__MaxInclusiveAssignment_3_1_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveAssignment_3_2_1(), "rule__TimeScalarRestriction__MinExclusiveAssignment_3_2_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveAssignment_3_3_1(), "rule__TimeScalarRestriction__MaxExclusiveAssignment_3_3_1");
					put(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeAssignment_5(), "rule__TimeScalarRestriction__RestrictedRangeAssignment_5");
					put(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsAssignment_1(), "rule__DescriptionBoxExtendsClosedWorldDefinitions__ClosedWorldDefinitionsAssignment_1");
					put(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxAssignment_1(), "rule__DescriptionBoxRefinement__RefinedDescriptionBoxAssignment_1");
					put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceAssignment_0(), "rule__SingletonInstanceScalarDataPropertyValue__SingletonInstanceAssignment_0");
					put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_2(), "rule__SingletonInstanceScalarDataPropertyValue__ScalarDataPropertyAssignment_2");
					put(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_4(), "rule__SingletonInstanceScalarDataPropertyValue__ScalarPropertyValueAssignment_4");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceAssignment_0(), "rule__SingletonInstanceStructuredDataPropertyValue__SingletonInstanceAssignment_0");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyAssignment_2(), "rule__SingletonInstanceStructuredDataPropertyValue__StructuredDataPropertyAssignment_2");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesAssignment_5_0(), "rule__SingletonInstanceStructuredDataPropertyValue__StructuredPropertyTuplesAssignment_5_0");
					put(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesAssignment_5_1(), "rule__SingletonInstanceStructuredDataPropertyValue__ScalarDataPropertyValuesAssignment_5_1");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_0(), "rule__StructuredDataPropertyTuple__StructuredDataPropertyAssignment_0");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_3_0(), "rule__StructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_3_0");
					put(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_3_1(), "rule__StructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_3_1");
					put(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_0(), "rule__ScalarDataPropertyValue__ScalarDataPropertyAssignment_0");
					put(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_2(), "rule__ScalarDataPropertyValue__ScalarPropertyValueAssignment_2");
					put(grammarAccess.getConceptInstanceAccess().getNameAssignment_2(), "rule__ConceptInstance__NameAssignment_2");
					put(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierAssignment_4(), "rule__ConceptInstance__SingletonConceptClassifierAssignment_4");
					put(grammarAccess.getReifiedRelationshipInstanceAccess().getNameAssignment_2(), "rule__ReifiedRelationshipInstance__NameAssignment_2");
					put(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierAssignment_4(), "rule__ReifiedRelationshipInstance__SingletonReifiedRelationshipClassifierAssignment_4");
					put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceAssignment_2(), "rule__ReifiedRelationshipInstanceDomain__ReifiedRelationshipInstanceAssignment_2");
					put(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainAssignment_5(), "rule__ReifiedRelationshipInstanceDomain__DomainAssignment_5");
					put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceAssignment_2(), "rule__ReifiedRelationshipInstanceRange__ReifiedRelationshipInstanceAssignment_2");
					put(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeAssignment_5(), "rule__ReifiedRelationshipInstanceRange__RangeAssignment_5");
					put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipAssignment_3(), "rule__UnreifiedRelationshipInstanceTuple__UnreifiedRelationshipAssignment_3");
					put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainAssignment_5(), "rule__UnreifiedRelationshipInstanceTuple__DomainAssignment_5");
					put(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeAssignment_7(), "rule__UnreifiedRelationshipInstanceTuple__RangeAssignment_7");
					put(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), "rule__ReifiedRelationship__UnorderedGroup_3");
					put(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), "rule__UnreifiedRelationship__UnorderedGroup_3");
					put(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), "rule__BinaryScalarRestriction__UnorderedGroup_3");
					put(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), "rule__IRIScalarRestriction__UnorderedGroup_3");
					put(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), "rule__NumericScalarRestriction__UnorderedGroup_3");
					put(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), "rule__PlainLiteralScalarRestriction__UnorderedGroup_3");
					put(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), "rule__StringScalarRestriction__UnorderedGroup_3");
					put(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), "rule__TimeScalarRestriction__UnorderedGroup_3");
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
