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
package gov.nasa.jpl.imce.oml.dsl.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractEnumRuleElementFinder;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class OMLGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ExtentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Extent");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cExtentAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cAnnotationPropertiesAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cAnnotationPropertiesAnnotationPropertyParserRuleCall_1_0_0 = (RuleCall)cAnnotationPropertiesAssignment_1_0.eContents().get(0);
		private final Assignment cModulesAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cModulesModuleParserRuleCall_1_1_0 = (RuleCall)cModulesAssignment_1_1.eContents().get(0);
		
		//Extent:
		//	{Extent} (annotationProperties+=AnnotationProperty | modules+=Module)*;
		@Override public ParserRule getRule() { return rule; }
		
		//{Extent} (annotationProperties+=AnnotationProperty | modules+=Module)*
		public Group getGroup() { return cGroup; }
		
		//{Extent}
		public Action getExtentAction_0() { return cExtentAction_0; }
		
		//(annotationProperties+=AnnotationProperty | modules+=Module)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//annotationProperties+=AnnotationProperty
		public Assignment getAnnotationPropertiesAssignment_1_0() { return cAnnotationPropertiesAssignment_1_0; }
		
		//AnnotationProperty
		public RuleCall getAnnotationPropertiesAnnotationPropertyParserRuleCall_1_0_0() { return cAnnotationPropertiesAnnotationPropertyParserRuleCall_1_0_0; }
		
		//modules+=Module
		public Assignment getModulesAssignment_1_1() { return cModulesAssignment_1_1; }
		
		//Module
		public RuleCall getModulesModuleParserRuleCall_1_1_0() { return cModulesModuleParserRuleCall_1_1_0; }
	}
	public class AnnotationPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.AnnotationProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAnnotationPropertyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cAbbrevIRIAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAbbrevIRIABBREV_IRITerminalRuleCall_1_0 = (RuleCall)cAbbrevIRIAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIriAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIriIRITerminalRuleCall_3_0 = (RuleCall)cIriAssignment_3.eContents().get(0);
		
		//// syntax of Annotation & AnnotationProperties
		//AnnotationProperty:
		//	'annotationProperty' abbrevIRI=ABBREV_IRI '=' iri=IRI;
		@Override public ParserRule getRule() { return rule; }
		
		//'annotationProperty' abbrevIRI=ABBREV_IRI '=' iri=IRI
		public Group getGroup() { return cGroup; }
		
		//'annotationProperty'
		public Keyword getAnnotationPropertyKeyword_0() { return cAnnotationPropertyKeyword_0; }
		
		//abbrevIRI=ABBREV_IRI
		public Assignment getAbbrevIRIAssignment_1() { return cAbbrevIRIAssignment_1; }
		
		//ABBREV_IRI
		public RuleCall getAbbrevIRIABBREV_IRITerminalRuleCall_1_0() { return cAbbrevIRIABBREV_IRITerminalRuleCall_1_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//iri=IRI
		public Assignment getIriAssignment_3() { return cIriAssignment_3; }
		
		//IRI
		public RuleCall getIriIRITerminalRuleCall_3_0() { return cIriIRITerminalRuleCall_3_0; }
	}
	public class AnnotationPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCommercialAtKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cPropertyAnnotationPropertyCrossReference_1_0 = (CrossReference)cPropertyAssignment_1.eContents().get(0);
		private final RuleCall cPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1 = (RuleCall)cPropertyAnnotationPropertyCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueSTRINGTerminalRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//AnnotationPropertyValue:
		//	'@' property=[AnnotationProperty|ABBREV_IRI]
		//	'=' value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//'@' property=[AnnotationProperty|ABBREV_IRI] '=' value=STRING
		public Group getGroup() { return cGroup; }
		
		//'@'
		public Keyword getCommercialAtKeyword_0() { return cCommercialAtKeyword_0; }
		
		//property=[AnnotationProperty|ABBREV_IRI]
		public Assignment getPropertyAssignment_1() { return cPropertyAssignment_1; }
		
		//[AnnotationProperty|ABBREV_IRI]
		public CrossReference getPropertyAnnotationPropertyCrossReference_1_0() { return cPropertyAnnotationPropertyCrossReference_1_0; }
		
		//ABBREV_IRI
		public RuleCall getPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1() { return cPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//value=STRING
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_3_0() { return cValueSTRINGTerminalRuleCall_3_0; }
	}
	public class ModuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Module");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTerminologyBoxParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDescriptionBoxParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Module:
		//	TerminologyBox | DescriptionBox;
		@Override public ParserRule getRule() { return rule; }
		
		//TerminologyBox | DescriptionBox
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TerminologyBox
		public RuleCall getTerminologyBoxParserRuleCall_0() { return cTerminologyBoxParserRuleCall_0; }
		
		//DescriptionBox
		public RuleCall getDescriptionBoxParserRuleCall_1() { return cDescriptionBoxParserRuleCall_1; }
	}
	public class TerminologyBoxElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBox");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBundleParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTerminologyGraphParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//// 2 TerminologyBoxes
		//TerminologyBox:
		//	Bundle | TerminologyGraph;
		@Override public ParserRule getRule() { return rule; }
		
		//Bundle | TerminologyGraph
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Bundle
		public RuleCall getBundleParserRuleCall_0() { return cBundleParserRuleCall_0; }
		
		//TerminologyGraph
		public RuleCall getTerminologyGraphParserRuleCall_1() { return cTerminologyGraphParserRuleCall_1; }
	}
	public class TerminologyGraphElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyGraph");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindTerminologyKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Keyword cTerminologyKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIriAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIriIRITerminalRuleCall_3_0 = (RuleCall)cIriAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cBoxAxiomsAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0 = (RuleCall)cBoxAxiomsAssignment_5_0.eContents().get(0);
		private final Assignment cBoxStatementsAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0 = (RuleCall)cBoxStatementsAssignment_5_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//TerminologyGraph:
		//	annotations+=AnnotationPropertyValue*
		//	kind=TerminologyKind 'terminology' iri=IRI
		//	'{' (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* kind=TerminologyKind 'terminology' iri=IRI '{' (boxAxioms+=TerminologyBoxAxiom |
		//boxStatements+=TerminologyBoxStatement)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//kind=TerminologyKind
		public Assignment getKindAssignment_1() { return cKindAssignment_1; }
		
		//TerminologyKind
		public RuleCall getKindTerminologyKindEnumRuleCall_1_0() { return cKindTerminologyKindEnumRuleCall_1_0; }
		
		//'terminology'
		public Keyword getTerminologyKeyword_2() { return cTerminologyKeyword_2; }
		
		//iri=IRI
		public Assignment getIriAssignment_3() { return cIriAssignment_3; }
		
		//IRI
		public RuleCall getIriIRITerminalRuleCall_3_0() { return cIriIRITerminalRuleCall_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//(boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }
		
		//boxAxioms+=TerminologyBoxAxiom
		public Assignment getBoxAxiomsAssignment_5_0() { return cBoxAxiomsAssignment_5_0; }
		
		//TerminologyBoxAxiom
		public RuleCall getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0() { return cBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0; }
		
		//boxStatements+=TerminologyBoxStatement
		public Assignment getBoxStatementsAssignment_5_1() { return cBoxStatementsAssignment_5_1; }
		
		//TerminologyBoxStatement
		public RuleCall getBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0() { return cBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class BundleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Bundle");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindTerminologyKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Keyword cBundleKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIriAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIriIRITerminalRuleCall_3_0 = (RuleCall)cIriAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cBoxAxiomsAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0 = (RuleCall)cBoxAxiomsAssignment_5_0.eContents().get(0);
		private final Assignment cBoxStatementsAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0 = (RuleCall)cBoxStatementsAssignment_5_1.eContents().get(0);
		private final Assignment cBundleStatementsAssignment_5_2 = (Assignment)cAlternatives_5.eContents().get(2);
		private final RuleCall cBundleStatementsTerminologyBundleStatementParserRuleCall_5_2_0 = (RuleCall)cBundleStatementsAssignment_5_2.eContents().get(0);
		private final Assignment cBundleAxiomsAssignment_5_3 = (Assignment)cAlternatives_5.eContents().get(3);
		private final RuleCall cBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_3_0 = (RuleCall)cBundleAxiomsAssignment_5_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Bundle:
		//	annotations+=AnnotationPropertyValue*
		//	kind=TerminologyKind 'bundle' iri=IRI
		//	'{' (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement |
		//	bundleStatements+=TerminologyBundleStatement | bundleAxioms+=TerminologyBundleAxiom)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* kind=TerminologyKind 'bundle' iri=IRI '{' (boxAxioms+=TerminologyBoxAxiom |
		//boxStatements+=TerminologyBoxStatement | bundleStatements+=TerminologyBundleStatement |
		//bundleAxioms+=TerminologyBundleAxiom)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//kind=TerminologyKind
		public Assignment getKindAssignment_1() { return cKindAssignment_1; }
		
		//TerminologyKind
		public RuleCall getKindTerminologyKindEnumRuleCall_1_0() { return cKindTerminologyKindEnumRuleCall_1_0; }
		
		//'bundle'
		public Keyword getBundleKeyword_2() { return cBundleKeyword_2; }
		
		//iri=IRI
		public Assignment getIriAssignment_3() { return cIriAssignment_3; }
		
		//IRI
		public RuleCall getIriIRITerminalRuleCall_3_0() { return cIriIRITerminalRuleCall_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//(boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement | bundleStatements+=TerminologyBundleStatement
		//| bundleAxioms+=TerminologyBundleAxiom)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }
		
		//boxAxioms+=TerminologyBoxAxiom
		public Assignment getBoxAxiomsAssignment_5_0() { return cBoxAxiomsAssignment_5_0; }
		
		//TerminologyBoxAxiom
		public RuleCall getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0() { return cBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0; }
		
		//boxStatements+=TerminologyBoxStatement
		public Assignment getBoxStatementsAssignment_5_1() { return cBoxStatementsAssignment_5_1; }
		
		//TerminologyBoxStatement
		public RuleCall getBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0() { return cBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0; }
		
		//bundleStatements+=TerminologyBundleStatement
		public Assignment getBundleStatementsAssignment_5_2() { return cBundleStatementsAssignment_5_2; }
		
		//TerminologyBundleStatement
		public RuleCall getBundleStatementsTerminologyBundleStatementParserRuleCall_5_2_0() { return cBundleStatementsTerminologyBundleStatementParserRuleCall_5_2_0; }
		
		//bundleAxioms+=TerminologyBundleAxiom
		public Assignment getBundleAxiomsAssignment_5_3() { return cBundleAxiomsAssignment_5_3; }
		
		//TerminologyBundleAxiom
		public RuleCall getBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_3_0() { return cBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class DescriptionBoxElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBox");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindDescriptionKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Keyword cDescriptionBoxKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIriAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIriIRITerminalRuleCall_3_0 = (RuleCall)cIriAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cClosedWorldDefinitionsAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_0_0 = (RuleCall)cClosedWorldDefinitionsAssignment_5_0.eContents().get(0);
		private final Assignment cDescriptionBoxRefinementsAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_1_0 = (RuleCall)cDescriptionBoxRefinementsAssignment_5_1.eContents().get(0);
		private final Assignment cConceptInstancesAssignment_5_2 = (Assignment)cAlternatives_5.eContents().get(2);
		private final RuleCall cConceptInstancesConceptInstanceParserRuleCall_5_2_0 = (RuleCall)cConceptInstancesAssignment_5_2.eContents().get(0);
		private final Assignment cReifiedRelationshipInstancesAssignment_5_3 = (Assignment)cAlternatives_5.eContents().get(3);
		private final RuleCall cReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_3_0 = (RuleCall)cReifiedRelationshipInstancesAssignment_5_3.eContents().get(0);
		private final Assignment cReifiedRelationshipInstanceDomainsAssignment_5_4 = (Assignment)cAlternatives_5.eContents().get(4);
		private final RuleCall cReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_4_0 = (RuleCall)cReifiedRelationshipInstanceDomainsAssignment_5_4.eContents().get(0);
		private final Assignment cReifiedRelationshipInstanceRangesAssignment_5_5 = (Assignment)cAlternatives_5.eContents().get(5);
		private final RuleCall cReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_5_0 = (RuleCall)cReifiedRelationshipInstanceRangesAssignment_5_5.eContents().get(0);
		private final Assignment cUnreifiedRelationshipInstanceTuplesAssignment_5_6 = (Assignment)cAlternatives_5.eContents().get(6);
		private final RuleCall cUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_6_0 = (RuleCall)cUnreifiedRelationshipInstanceTuplesAssignment_5_6.eContents().get(0);
		private final Assignment cSingletonScalarDataPropertyValuesAssignment_5_7 = (Assignment)cAlternatives_5.eContents().get(7);
		private final RuleCall cSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_7_0 = (RuleCall)cSingletonScalarDataPropertyValuesAssignment_5_7.eContents().get(0);
		private final Assignment cSingletonStructuredDataPropertyValuesAssignment_5_8 = (Assignment)cAlternatives_5.eContents().get(8);
		private final RuleCall cSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_8_0 = (RuleCall)cSingletonStructuredDataPropertyValuesAssignment_5_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//DescriptionBox:
		//	annotations+=AnnotationPropertyValue*
		//	kind=DescriptionKind 'descriptionBox' iri=IRI
		//	'{' (closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//	descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//	reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//	reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//	reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//	unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//	singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//	singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* kind=DescriptionKind 'descriptionBox' iri=IRI '{'
		//(closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//kind=DescriptionKind
		public Assignment getKindAssignment_1() { return cKindAssignment_1; }
		
		//DescriptionKind
		public RuleCall getKindDescriptionKindEnumRuleCall_1_0() { return cKindDescriptionKindEnumRuleCall_1_0; }
		
		//'descriptionBox'
		public Keyword getDescriptionBoxKeyword_2() { return cDescriptionBoxKeyword_2; }
		
		//iri=IRI
		public Assignment getIriAssignment_3() { return cIriAssignment_3; }
		
		//IRI
		public RuleCall getIriIRITerminalRuleCall_3_0() { return cIriIRITerminalRuleCall_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//(closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }
		
		//closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions
		public Assignment getClosedWorldDefinitionsAssignment_5_0() { return cClosedWorldDefinitionsAssignment_5_0; }
		
		//DescriptionBoxExtendsClosedWorldDefinitions
		public RuleCall getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_0_0() { return cClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_0_0; }
		
		//descriptionBoxRefinements+=DescriptionBoxRefinement
		public Assignment getDescriptionBoxRefinementsAssignment_5_1() { return cDescriptionBoxRefinementsAssignment_5_1; }
		
		//DescriptionBoxRefinement
		public RuleCall getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_1_0() { return cDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_1_0; }
		
		//conceptInstances+=ConceptInstance
		public Assignment getConceptInstancesAssignment_5_2() { return cConceptInstancesAssignment_5_2; }
		
		//ConceptInstance
		public RuleCall getConceptInstancesConceptInstanceParserRuleCall_5_2_0() { return cConceptInstancesConceptInstanceParserRuleCall_5_2_0; }
		
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance
		public Assignment getReifiedRelationshipInstancesAssignment_5_3() { return cReifiedRelationshipInstancesAssignment_5_3; }
		
		//ReifiedRelationshipInstance
		public RuleCall getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_3_0() { return cReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_3_0; }
		
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain
		public Assignment getReifiedRelationshipInstanceDomainsAssignment_5_4() { return cReifiedRelationshipInstanceDomainsAssignment_5_4; }
		
		//ReifiedRelationshipInstanceDomain
		public RuleCall getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_4_0() { return cReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_4_0; }
		
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange
		public Assignment getReifiedRelationshipInstanceRangesAssignment_5_5() { return cReifiedRelationshipInstanceRangesAssignment_5_5; }
		
		//ReifiedRelationshipInstanceRange
		public RuleCall getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_5_0() { return cReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_5_0; }
		
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple
		public Assignment getUnreifiedRelationshipInstanceTuplesAssignment_5_6() { return cUnreifiedRelationshipInstanceTuplesAssignment_5_6; }
		
		//UnreifiedRelationshipInstanceTuple
		public RuleCall getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_6_0() { return cUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_6_0; }
		
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue
		public Assignment getSingletonScalarDataPropertyValuesAssignment_5_7() { return cSingletonScalarDataPropertyValuesAssignment_5_7; }
		
		//SingletonInstanceScalarDataPropertyValue
		public RuleCall getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_7_0() { return cSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_7_0; }
		
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue
		public Assignment getSingletonStructuredDataPropertyValuesAssignment_5_8() { return cSingletonStructuredDataPropertyValuesAssignment_5_8; }
		
		//SingletonInstanceStructuredDataPropertyValue
		public RuleCall getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_8_0() { return cSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_8_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class TerminologyBoxAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxAxiom");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cConceptDesignationTerminologyAxiomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTerminologyExtensionAxiomParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cTerminologyNestingAxiomParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//TerminologyBoxAxiom:
		//	ConceptDesignationTerminologyAxiom | TerminologyExtensionAxiom | TerminologyNestingAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//ConceptDesignationTerminologyAxiom | TerminologyExtensionAxiom | TerminologyNestingAxiom
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ConceptDesignationTerminologyAxiom
		public RuleCall getConceptDesignationTerminologyAxiomParserRuleCall_0() { return cConceptDesignationTerminologyAxiomParserRuleCall_0; }
		
		//TerminologyExtensionAxiom
		public RuleCall getTerminologyExtensionAxiomParserRuleCall_1() { return cTerminologyExtensionAxiomParserRuleCall_1; }
		
		//TerminologyNestingAxiom
		public RuleCall getTerminologyNestingAxiomParserRuleCall_2() { return cTerminologyNestingAxiomParserRuleCall_2; }
	}
	public class BundledTerminologyAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.BundledTerminologyAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cBundlesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cBundledTerminologyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cBundledTerminologyTerminologyBoxCrossReference_2_0 = (CrossReference)cBundledTerminologyAssignment_2.eContents().get(0);
		private final RuleCall cBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1 = (RuleCall)cBundledTerminologyTerminologyBoxCrossReference_2_0.eContents().get(1);
		
		//// 1 TerminologyBundleAxiom
		//BundledTerminologyAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'bundles' bundledTerminology=[TerminologyBox|ExternalReference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'bundles' bundledTerminology=[TerminologyBox|ExternalReference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'bundles'
		public Keyword getBundlesKeyword_1() { return cBundlesKeyword_1; }
		
		//bundledTerminology=[TerminologyBox|ExternalReference]
		public Assignment getBundledTerminologyAssignment_2() { return cBundledTerminologyAssignment_2; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getBundledTerminologyTerminologyBoxCrossReference_2_0() { return cBundledTerminologyTerminologyBoxCrossReference_2_0; }
		
		//ExternalReference
		public RuleCall getBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1() { return cBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1; }
	}
	public class ConceptDesignationTerminologyAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ConceptDesignationTerminologyAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cConceptDesignationTerminologyAxiomKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cDesignatedTerminologyKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cDesignatedTerminologyAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cDesignatedTerminologyTerminologyBoxCrossReference_4_0 = (CrossReference)cDesignatedTerminologyAssignment_4.eContents().get(0);
		private final RuleCall cDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1 = (RuleCall)cDesignatedTerminologyTerminologyBoxCrossReference_4_0.eContents().get(1);
		private final Keyword cDesignatedConceptKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDesignatedConceptAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cDesignatedConceptConceptCrossReference_6_0 = (CrossReference)cDesignatedConceptAssignment_6.eContents().get(0);
		private final RuleCall cDesignatedConceptConceptReferenceParserRuleCall_6_0_1 = (RuleCall)cDesignatedConceptConceptCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//// 3 TerminologyBoxAxioms
		//ConceptDesignationTerminologyAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'conceptDesignationTerminologyAxiom'
		//	'{'
		//	'designatedTerminology' designatedTerminology=[TerminologyBox|ExternalReference]
		//	'designatedConcept' designatedConcept=[Concept|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'conceptDesignationTerminologyAxiom' '{' 'designatedTerminology'
		//designatedTerminology=[TerminologyBox|ExternalReference] 'designatedConcept' designatedConcept=[Concept|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'conceptDesignationTerminologyAxiom'
		public Keyword getConceptDesignationTerminologyAxiomKeyword_1() { return cConceptDesignationTerminologyAxiomKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//'designatedTerminology'
		public Keyword getDesignatedTerminologyKeyword_3() { return cDesignatedTerminologyKeyword_3; }
		
		//designatedTerminology=[TerminologyBox|ExternalReference]
		public Assignment getDesignatedTerminologyAssignment_4() { return cDesignatedTerminologyAssignment_4; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getDesignatedTerminologyTerminologyBoxCrossReference_4_0() { return cDesignatedTerminologyTerminologyBoxCrossReference_4_0; }
		
		//ExternalReference
		public RuleCall getDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1() { return cDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1; }
		
		//'designatedConcept'
		public Keyword getDesignatedConceptKeyword_5() { return cDesignatedConceptKeyword_5; }
		
		//designatedConcept=[Concept|Reference]
		public Assignment getDesignatedConceptAssignment_6() { return cDesignatedConceptAssignment_6; }
		
		//[Concept|Reference]
		public CrossReference getDesignatedConceptConceptCrossReference_6_0() { return cDesignatedConceptConceptCrossReference_6_0; }
		
		//Reference
		public RuleCall getDesignatedConceptConceptReferenceParserRuleCall_6_0_1() { return cDesignatedConceptConceptReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class TerminologyExtensionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyExtensionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cExtendsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExtendedTerminologyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cExtendedTerminologyTerminologyBoxCrossReference_2_0 = (CrossReference)cExtendedTerminologyAssignment_2.eContents().get(0);
		private final RuleCall cExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1 = (RuleCall)cExtendedTerminologyTerminologyBoxCrossReference_2_0.eContents().get(1);
		
		//TerminologyExtensionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'extends' extendedTerminology=[TerminologyBox|ExternalReference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'extends' extendedTerminology=[TerminologyBox|ExternalReference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'extends'
		public Keyword getExtendsKeyword_1() { return cExtendsKeyword_1; }
		
		//extendedTerminology=[TerminologyBox|ExternalReference]
		public Assignment getExtendedTerminologyAssignment_2() { return cExtendedTerminologyAssignment_2; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getExtendedTerminologyTerminologyBoxCrossReference_2_0() { return cExtendedTerminologyTerminologyBoxCrossReference_2_0; }
		
		//ExternalReference
		public RuleCall getExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1() { return cExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1; }
	}
	public class TerminologyNestingAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyNestingAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cTerminologyNestingAxiomKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cNestingTerminologyKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cNestingTerminologyAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cNestingTerminologyTerminologyBoxCrossReference_4_0 = (CrossReference)cNestingTerminologyAssignment_4.eContents().get(0);
		private final RuleCall cNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1 = (RuleCall)cNestingTerminologyTerminologyBoxCrossReference_4_0.eContents().get(1);
		private final Keyword cNestingContextKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cNestingContextAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cNestingContextConceptCrossReference_6_0 = (CrossReference)cNestingContextAssignment_6.eContents().get(0);
		private final RuleCall cNestingContextConceptReferenceParserRuleCall_6_0_1 = (RuleCall)cNestingContextConceptCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//TerminologyNestingAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'terminologyNestingAxiom'
		//	'{'
		//	'nestingTerminology' nestingTerminology=[TerminologyBox|ExternalReference]
		//	'nestingContext' nestingContext=[Concept|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'terminologyNestingAxiom' '{' 'nestingTerminology'
		//nestingTerminology=[TerminologyBox|ExternalReference] 'nestingContext' nestingContext=[Concept|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'terminologyNestingAxiom'
		public Keyword getTerminologyNestingAxiomKeyword_1() { return cTerminologyNestingAxiomKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//'nestingTerminology'
		public Keyword getNestingTerminologyKeyword_3() { return cNestingTerminologyKeyword_3; }
		
		//nestingTerminology=[TerminologyBox|ExternalReference]
		public Assignment getNestingTerminologyAssignment_4() { return cNestingTerminologyAssignment_4; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getNestingTerminologyTerminologyBoxCrossReference_4_0() { return cNestingTerminologyTerminologyBoxCrossReference_4_0; }
		
		//ExternalReference
		public RuleCall getNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1() { return cNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1; }
		
		//'nestingContext'
		public Keyword getNestingContextKeyword_5() { return cNestingContextKeyword_5; }
		
		//nestingContext=[Concept|Reference]
		public Assignment getNestingContextAssignment_6() { return cNestingContextAssignment_6; }
		
		//[Concept|Reference]
		public CrossReference getNestingContextConceptCrossReference_6_0() { return cNestingContextConceptCrossReference_6_0; }
		
		//Reference
		public RuleCall getNestingContextConceptReferenceParserRuleCall_6_0_1() { return cNestingContextConceptReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class TerminologyBoxStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxStatement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTermAxiomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTermParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//TerminologyBoxStatement:
		//	TermAxiom | Term;
		@Override public ParserRule getRule() { return rule; }
		
		//TermAxiom | Term
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TermAxiom
		public RuleCall getTermAxiomParserRuleCall_0() { return cTermAxiomParserRuleCall_0; }
		
		//Term
		public RuleCall getTermParserRuleCall_1() { return cTermParserRuleCall_1; }
	}
	public class TermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Term");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAtomicEntityParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEntityRelationshipParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cDatatypeParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cDataRelationshipParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//Term:
		//	AtomicEntity | EntityRelationship | Datatype | DataRelationship;
		@Override public ParserRule getRule() { return rule; }
		
		//AtomicEntity | EntityRelationship | Datatype | DataRelationship
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//AtomicEntity
		public RuleCall getAtomicEntityParserRuleCall_0() { return cAtomicEntityParserRuleCall_0; }
		
		//EntityRelationship
		public RuleCall getEntityRelationshipParserRuleCall_1() { return cEntityRelationshipParserRuleCall_1; }
		
		//Datatype
		public RuleCall getDatatypeParserRuleCall_2() { return cDatatypeParserRuleCall_2; }
		
		//DataRelationship
		public RuleCall getDataRelationshipParserRuleCall_3() { return cDataRelationshipParserRuleCall_3; }
	}
	public class AtomicEntityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.AtomicEntity");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAspectParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cConceptParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AtomicEntity Entity:
		//	Aspect | Concept;
		@Override public ParserRule getRule() { return rule; }
		
		//Aspect | Concept
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Aspect
		public RuleCall getAspectParserRuleCall_0() { return cAspectParserRuleCall_0; }
		
		//Concept
		public RuleCall getConceptParserRuleCall_1() { return cConceptParserRuleCall_1; }
	}
	public class EntityRelationshipElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityRelationship");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cReifiedRelationshipParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cUnreifiedRelationshipParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EntityRelationship:
		//	ReifiedRelationship | UnreifiedRelationship;
		@Override public ParserRule getRule() { return rule; }
		
		//ReifiedRelationship | UnreifiedRelationship
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ReifiedRelationship
		public RuleCall getReifiedRelationshipParserRuleCall_0() { return cReifiedRelationshipParserRuleCall_0; }
		
		//UnreifiedRelationship
		public RuleCall getUnreifiedRelationshipParserRuleCall_1() { return cUnreifiedRelationshipParserRuleCall_1; }
	}
	public class DatatypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Datatype");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cScalarDataRangeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cStructureParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Datatype:
		//	ScalarDataRange | Structure;
		@Override public ParserRule getRule() { return rule; }
		
		//ScalarDataRange | Structure
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ScalarDataRange
		public RuleCall getScalarDataRangeParserRuleCall_0() { return cScalarDataRangeParserRuleCall_0; }
		
		//Structure
		public RuleCall getStructureParserRuleCall_1() { return cStructureParserRuleCall_1; }
	}
	public class ScalarDataRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataRange");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cScalarParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRestrictedDataRangeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//ScalarDataRange DataRange:
		//	Scalar | RestrictedDataRange;
		@Override public ParserRule getRule() { return rule; }
		
		//Scalar | RestrictedDataRange
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Scalar
		public RuleCall getScalarParserRuleCall_0() { return cScalarParserRuleCall_0; }
		
		//RestrictedDataRange
		public RuleCall getRestrictedDataRangeParserRuleCall_1() { return cRestrictedDataRangeParserRuleCall_1; }
	}
	public class RestrictedDataRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RestrictedDataRange");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBinaryScalarRestrictionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIRIScalarRestrictionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cNumericScalarRestrictionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPlainLiteralScalarRestrictionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cScalarOneOfRestrictionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cStringScalarRestrictionParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cSynonymScalarRestrictionParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cTimeScalarRestrictionParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		
		//RestrictedDataRange:
		//	BinaryScalarRestriction | IRIScalarRestriction | NumericScalarRestriction | PlainLiteralScalarRestriction |
		//	ScalarOneOfRestriction | StringScalarRestriction | SynonymScalarRestriction | TimeScalarRestriction;
		@Override public ParserRule getRule() { return rule; }
		
		//BinaryScalarRestriction | IRIScalarRestriction | NumericScalarRestriction | PlainLiteralScalarRestriction |
		//ScalarOneOfRestriction | StringScalarRestriction | SynonymScalarRestriction | TimeScalarRestriction
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//BinaryScalarRestriction
		public RuleCall getBinaryScalarRestrictionParserRuleCall_0() { return cBinaryScalarRestrictionParserRuleCall_0; }
		
		//IRIScalarRestriction
		public RuleCall getIRIScalarRestrictionParserRuleCall_1() { return cIRIScalarRestrictionParserRuleCall_1; }
		
		//NumericScalarRestriction
		public RuleCall getNumericScalarRestrictionParserRuleCall_2() { return cNumericScalarRestrictionParserRuleCall_2; }
		
		//PlainLiteralScalarRestriction
		public RuleCall getPlainLiteralScalarRestrictionParserRuleCall_3() { return cPlainLiteralScalarRestrictionParserRuleCall_3; }
		
		//ScalarOneOfRestriction
		public RuleCall getScalarOneOfRestrictionParserRuleCall_4() { return cScalarOneOfRestrictionParserRuleCall_4; }
		
		//StringScalarRestriction
		public RuleCall getStringScalarRestrictionParserRuleCall_5() { return cStringScalarRestrictionParserRuleCall_5; }
		
		//SynonymScalarRestriction
		public RuleCall getSynonymScalarRestrictionParserRuleCall_6() { return cSynonymScalarRestrictionParserRuleCall_6; }
		
		//TimeScalarRestriction
		public RuleCall getTimeScalarRestrictionParserRuleCall_7() { return cTimeScalarRestrictionParserRuleCall_7; }
	}
	public class DataRelationshipElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DataRelationship");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEntityStructuredDataPropertyParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEntityScalarDataPropertyParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cStructuredDataPropertyParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cScalarDataPropertyParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//DataRelationship:
		//	EntityStructuredDataProperty | EntityScalarDataProperty | StructuredDataProperty | ScalarDataProperty;
		@Override public ParserRule getRule() { return rule; }
		
		//EntityStructuredDataProperty | EntityScalarDataProperty | StructuredDataProperty | ScalarDataProperty
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//EntityStructuredDataProperty
		public RuleCall getEntityStructuredDataPropertyParserRuleCall_0() { return cEntityStructuredDataPropertyParserRuleCall_0; }
		
		//EntityScalarDataProperty
		public RuleCall getEntityScalarDataPropertyParserRuleCall_1() { return cEntityScalarDataPropertyParserRuleCall_1; }
		
		//StructuredDataProperty
		public RuleCall getStructuredDataPropertyParserRuleCall_2() { return cStructuredDataPropertyParserRuleCall_2; }
		
		//ScalarDataProperty
		public RuleCall getScalarDataPropertyParserRuleCall_3() { return cScalarDataPropertyParserRuleCall_3; }
	}
	public class TermAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TermAxiom");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEntityRestrictionAxiomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEntityScalarDataPropertyRestrictionAxiomParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cEntityStructuredDataPropertyRestrictionAxiomParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cScalarOneOfLiteralAxiomParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cSpecializationAxiomParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//TermAxiom:
		//	EntityRestrictionAxiom | EntityScalarDataPropertyRestrictionAxiom | EntityStructuredDataPropertyRestrictionAxiom |
		//	ScalarOneOfLiteralAxiom | SpecializationAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//EntityRestrictionAxiom | EntityScalarDataPropertyRestrictionAxiom | EntityStructuredDataPropertyRestrictionAxiom |
		//ScalarOneOfLiteralAxiom | SpecializationAxiom
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//EntityRestrictionAxiom
		public RuleCall getEntityRestrictionAxiomParserRuleCall_0() { return cEntityRestrictionAxiomParserRuleCall_0; }
		
		//EntityScalarDataPropertyRestrictionAxiom
		public RuleCall getEntityScalarDataPropertyRestrictionAxiomParserRuleCall_1() { return cEntityScalarDataPropertyRestrictionAxiomParserRuleCall_1; }
		
		//EntityStructuredDataPropertyRestrictionAxiom
		public RuleCall getEntityStructuredDataPropertyRestrictionAxiomParserRuleCall_2() { return cEntityStructuredDataPropertyRestrictionAxiomParserRuleCall_2; }
		
		//ScalarOneOfLiteralAxiom
		public RuleCall getScalarOneOfLiteralAxiomParserRuleCall_3() { return cScalarOneOfLiteralAxiomParserRuleCall_3; }
		
		//SpecializationAxiom
		public RuleCall getSpecializationAxiomParserRuleCall_4() { return cSpecializationAxiomParserRuleCall_4; }
	}
	public class EntityRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityRestrictionAxiom");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEntityExistentialRestrictionAxiomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEntityUniversalRestrictionAxiomParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EntityRestrictionAxiom:
		//	EntityExistentialRestrictionAxiom | EntityUniversalRestrictionAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//EntityExistentialRestrictionAxiom | EntityUniversalRestrictionAxiom
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//EntityExistentialRestrictionAxiom
		public RuleCall getEntityExistentialRestrictionAxiomParserRuleCall_0() { return cEntityExistentialRestrictionAxiomParserRuleCall_0; }
		
		//EntityUniversalRestrictionAxiom
		public RuleCall getEntityUniversalRestrictionAxiomParserRuleCall_1() { return cEntityUniversalRestrictionAxiomParserRuleCall_1; }
	}
	public class EntityScalarDataPropertyRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataPropertyRestrictionAxiom");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEntityScalarDataPropertyExistentialRestrictionAxiomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEntityScalarDataPropertyParticularRestrictionAxiomParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cEntityScalarDataPropertyUniversalRestrictionAxiomParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//EntityScalarDataPropertyRestrictionAxiom:
		//	EntityScalarDataPropertyExistentialRestrictionAxiom | EntityScalarDataPropertyParticularRestrictionAxiom |
		//	EntityScalarDataPropertyUniversalRestrictionAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//EntityScalarDataPropertyExistentialRestrictionAxiom | EntityScalarDataPropertyParticularRestrictionAxiom |
		//EntityScalarDataPropertyUniversalRestrictionAxiom
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//EntityScalarDataPropertyExistentialRestrictionAxiom
		public RuleCall getEntityScalarDataPropertyExistentialRestrictionAxiomParserRuleCall_0() { return cEntityScalarDataPropertyExistentialRestrictionAxiomParserRuleCall_0; }
		
		//EntityScalarDataPropertyParticularRestrictionAxiom
		public RuleCall getEntityScalarDataPropertyParticularRestrictionAxiomParserRuleCall_1() { return cEntityScalarDataPropertyParticularRestrictionAxiomParserRuleCall_1; }
		
		//EntityScalarDataPropertyUniversalRestrictionAxiom
		public RuleCall getEntityScalarDataPropertyUniversalRestrictionAxiomParserRuleCall_2() { return cEntityScalarDataPropertyUniversalRestrictionAxiomParserRuleCall_2; }
	}
	public class EntityStructuredDataPropertyRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityStructuredDataPropertyRestrictionAxiom");
		private final RuleCall cEntityStructuredDataPropertyParticularRestrictionAxiomParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//EntityStructuredDataPropertyRestrictionAxiom:
		//	EntityStructuredDataPropertyParticularRestrictionAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//EntityStructuredDataPropertyParticularRestrictionAxiom
		public RuleCall getEntityStructuredDataPropertyParticularRestrictionAxiomParserRuleCall() { return cEntityStructuredDataPropertyParticularRestrictionAxiomParserRuleCall; }
	}
	public class SpecializationAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SpecializationAxiom");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cConceptSpecializationAxiomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAspectSpecializationAxiomParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cReifiedRelationshipSpecializationAxiomParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//SpecializationAxiom:
		//	ConceptSpecializationAxiom | AspectSpecializationAxiom | ReifiedRelationshipSpecializationAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//ConceptSpecializationAxiom | AspectSpecializationAxiom | ReifiedRelationshipSpecializationAxiom
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ConceptSpecializationAxiom
		public RuleCall getConceptSpecializationAxiomParserRuleCall_0() { return cConceptSpecializationAxiomParserRuleCall_0; }
		
		//AspectSpecializationAxiom
		public RuleCall getAspectSpecializationAxiomParserRuleCall_1() { return cAspectSpecializationAxiomParserRuleCall_1; }
		
		//ReifiedRelationshipSpecializationAxiom
		public RuleCall getReifiedRelationshipSpecializationAxiomParserRuleCall_2() { return cReifiedRelationshipSpecializationAxiomParserRuleCall_2; }
	}
	public class TerminologyBundleStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBundleStatement");
		private final RuleCall cRootConceptTaxonomyAxiomParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//TerminologyBundleStatement:
		//	RootConceptTaxonomyAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//RootConceptTaxonomyAxiom
		public RuleCall getRootConceptTaxonomyAxiomParserRuleCall() { return cRootConceptTaxonomyAxiomParserRuleCall; }
	}
	public class TerminologyBundleAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBundleAxiom");
		private final RuleCall cBundledTerminologyAxiomParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//TerminologyBundleAxiom:
		//	BundledTerminologyAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//BundledTerminologyAxiom
		public RuleCall getBundledTerminologyAxiomParserRuleCall() { return cBundledTerminologyAxiomParserRuleCall; }
	}
	public class ConceptTreeDisjunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ConceptTreeDisjunction");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAnonymousConceptUnionAxiomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRootConceptTaxonomyAxiomParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//ConceptTreeDisjunction:
		//	AnonymousConceptUnionAxiom | RootConceptTaxonomyAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//AnonymousConceptUnionAxiom | RootConceptTaxonomyAxiom
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//AnonymousConceptUnionAxiom
		public RuleCall getAnonymousConceptUnionAxiomParserRuleCall_0() { return cAnonymousConceptUnionAxiomParserRuleCall_0; }
		
		//RootConceptTaxonomyAxiom
		public RuleCall getRootConceptTaxonomyAxiomParserRuleCall_1() { return cRootConceptTaxonomyAxiomParserRuleCall_1; }
	}
	public class DisjointUnionOfConceptsAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAnonymousConceptUnionAxiomParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSpecificDisjointConceptAxiomParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//DisjointUnionOfConceptsAxiom:
		//	AnonymousConceptUnionAxiom | SpecificDisjointConceptAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//AnonymousConceptUnionAxiom | SpecificDisjointConceptAxiom
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//AnonymousConceptUnionAxiom
		public RuleCall getAnonymousConceptUnionAxiomParserRuleCall_0() { return cAnonymousConceptUnionAxiomParserRuleCall_0; }
		
		//SpecificDisjointConceptAxiom
		public RuleCall getSpecificDisjointConceptAxiomParserRuleCall_1() { return cSpecificDisjointConceptAxiomParserRuleCall_1; }
	}
	public class AspectElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Aspect");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cAspectKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		//// 2 Atomic Entity Terms
		//Aspect:
		//	annotations+=AnnotationPropertyValue*
		//	'aspect' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'aspect' name=ID
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'aspect'
		public Keyword getAspectKeyword_1() { return cAspectKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
	}
	public class ConceptElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Concept");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cConceptKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		//Concept:
		//	annotations+=AnnotationPropertyValue*
		//	'concept' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'concept' name=ID
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'concept'
		public Keyword getConceptKeyword_1() { return cConceptKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
	}
	public class ReifiedRelationshipElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationship");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cReifiedRelationshipKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Assignment cIsFunctionalAssignment_4_0 = (Assignment)cUnorderedGroup_4.eContents().get(0);
		private final Keyword cIsFunctionalFunctionalKeyword_4_0_0 = (Keyword)cIsFunctionalAssignment_4_0.eContents().get(0);
		private final Assignment cIsInverseFunctionalAssignment_4_1 = (Assignment)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cIsInverseFunctionalInverseFunctionalKeyword_4_1_0 = (Keyword)cIsInverseFunctionalAssignment_4_1.eContents().get(0);
		private final Assignment cIsEssentialAssignment_4_2 = (Assignment)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cIsEssentialEssentialKeyword_4_2_0 = (Keyword)cIsEssentialAssignment_4_2.eContents().get(0);
		private final Assignment cIsInverseEssentialAssignment_4_3 = (Assignment)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cIsInverseEssentialInverseEssentialKeyword_4_3_0 = (Keyword)cIsInverseEssentialAssignment_4_3.eContents().get(0);
		private final Assignment cIsSymmetricAssignment_4_4 = (Assignment)cUnorderedGroup_4.eContents().get(4);
		private final Keyword cIsSymmetricSymmetricKeyword_4_4_0 = (Keyword)cIsSymmetricAssignment_4_4.eContents().get(0);
		private final Assignment cIsAsymmetricAssignment_4_5 = (Assignment)cUnorderedGroup_4.eContents().get(5);
		private final Keyword cIsAsymmetricAsymmetricKeyword_4_5_0 = (Keyword)cIsAsymmetricAssignment_4_5.eContents().get(0);
		private final Assignment cIsReflexiveAssignment_4_6 = (Assignment)cUnorderedGroup_4.eContents().get(6);
		private final Keyword cIsReflexiveReflexiveKeyword_4_6_0 = (Keyword)cIsReflexiveAssignment_4_6.eContents().get(0);
		private final Assignment cIsIrreflexiveAssignment_4_7 = (Assignment)cUnorderedGroup_4.eContents().get(7);
		private final Keyword cIsIrreflexiveIrreflexiveKeyword_4_7_0 = (Keyword)cIsIrreflexiveAssignment_4_7.eContents().get(0);
		private final Assignment cIsTransitiveAssignment_4_8 = (Assignment)cUnorderedGroup_4.eContents().get(8);
		private final Keyword cIsTransitiveTransitiveKeyword_4_8_0 = (Keyword)cIsTransitiveAssignment_4_8.eContents().get(0);
		private final Keyword cUnreifiedKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cEqualsSignKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cUnreifiedPropertyNameAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cUnreifiedPropertyNameIDTerminalRuleCall_7_0 = (RuleCall)cUnreifiedPropertyNameAssignment_7.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cInverseKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cEqualsSignKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Assignment cUnreifiedInversePropertyNameAssignment_8_2 = (Assignment)cGroup_8.eContents().get(2);
		private final RuleCall cUnreifiedInversePropertyNameIDTerminalRuleCall_8_2_0 = (RuleCall)cUnreifiedInversePropertyNameAssignment_8_2.eContents().get(0);
		private final Keyword cSourceKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Keyword cEqualsSignKeyword_10 = (Keyword)cGroup.eContents().get(10);
		private final Assignment cSourceAssignment_11 = (Assignment)cGroup.eContents().get(11);
		private final CrossReference cSourceEntityCrossReference_11_0 = (CrossReference)cSourceAssignment_11.eContents().get(0);
		private final RuleCall cSourceEntityReferenceParserRuleCall_11_0_1 = (RuleCall)cSourceEntityCrossReference_11_0.eContents().get(1);
		private final Keyword cTargetKeyword_12 = (Keyword)cGroup.eContents().get(12);
		private final Keyword cEqualsSignKeyword_13 = (Keyword)cGroup.eContents().get(13);
		private final Assignment cTargetAssignment_14 = (Assignment)cGroup.eContents().get(14);
		private final CrossReference cTargetEntityCrossReference_14_0 = (CrossReference)cTargetAssignment_14.eContents().get(0);
		private final RuleCall cTargetEntityReferenceParserRuleCall_14_0_1 = (RuleCall)cTargetEntityCrossReference_14_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_15 = (Keyword)cGroup.eContents().get(15);
		
		//// 2 EntityRelationship Terms
		//ReifiedRelationship:
		//	annotations+=AnnotationPropertyValue*
		//	'reifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
		//	isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
		//	isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
		//	'unreified' '=' unreifiedPropertyName=ID ('inverse' '=' unreifiedInversePropertyName=ID)?
		//	'source' '=' source=[Entity|Reference]
		//	'target' '=' target=[Entity|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'reifiedRelationship' name=ID '{' (isFunctional?='functional'? &
		//isInverseFunctional?='inverseFunctional'? & isEssential?='essential'? & isInverseEssential?='inverseEssential'? &
		//isSymmetric?='symmetric'? & isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? &
		//isTransitive?='transitive'?) 'unreified' '=' unreifiedPropertyName=ID ('inverse' '=' unreifiedInversePropertyName=ID)?
		//'source' '=' source=[Entity|Reference] 'target' '=' target=[Entity|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'reifiedRelationship'
		public Keyword getReifiedRelationshipKeyword_1() { return cReifiedRelationshipKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? & isEssential?='essential'? &
		//isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? & isAsymmetric?='asymmetric'? &
		//isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//isFunctional?='functional'?
		public Assignment getIsFunctionalAssignment_4_0() { return cIsFunctionalAssignment_4_0; }
		
		//'functional'
		public Keyword getIsFunctionalFunctionalKeyword_4_0_0() { return cIsFunctionalFunctionalKeyword_4_0_0; }
		
		//isInverseFunctional?='inverseFunctional'?
		public Assignment getIsInverseFunctionalAssignment_4_1() { return cIsInverseFunctionalAssignment_4_1; }
		
		//'inverseFunctional'
		public Keyword getIsInverseFunctionalInverseFunctionalKeyword_4_1_0() { return cIsInverseFunctionalInverseFunctionalKeyword_4_1_0; }
		
		//isEssential?='essential'?
		public Assignment getIsEssentialAssignment_4_2() { return cIsEssentialAssignment_4_2; }
		
		//'essential'
		public Keyword getIsEssentialEssentialKeyword_4_2_0() { return cIsEssentialEssentialKeyword_4_2_0; }
		
		//isInverseEssential?='inverseEssential'?
		public Assignment getIsInverseEssentialAssignment_4_3() { return cIsInverseEssentialAssignment_4_3; }
		
		//'inverseEssential'
		public Keyword getIsInverseEssentialInverseEssentialKeyword_4_3_0() { return cIsInverseEssentialInverseEssentialKeyword_4_3_0; }
		
		//isSymmetric?='symmetric'?
		public Assignment getIsSymmetricAssignment_4_4() { return cIsSymmetricAssignment_4_4; }
		
		//'symmetric'
		public Keyword getIsSymmetricSymmetricKeyword_4_4_0() { return cIsSymmetricSymmetricKeyword_4_4_0; }
		
		//isAsymmetric?='asymmetric'?
		public Assignment getIsAsymmetricAssignment_4_5() { return cIsAsymmetricAssignment_4_5; }
		
		//'asymmetric'
		public Keyword getIsAsymmetricAsymmetricKeyword_4_5_0() { return cIsAsymmetricAsymmetricKeyword_4_5_0; }
		
		//isReflexive?='reflexive'?
		public Assignment getIsReflexiveAssignment_4_6() { return cIsReflexiveAssignment_4_6; }
		
		//'reflexive'
		public Keyword getIsReflexiveReflexiveKeyword_4_6_0() { return cIsReflexiveReflexiveKeyword_4_6_0; }
		
		//isIrreflexive?='irreflexive'?
		public Assignment getIsIrreflexiveAssignment_4_7() { return cIsIrreflexiveAssignment_4_7; }
		
		//'irreflexive'
		public Keyword getIsIrreflexiveIrreflexiveKeyword_4_7_0() { return cIsIrreflexiveIrreflexiveKeyword_4_7_0; }
		
		//isTransitive?='transitive'?
		public Assignment getIsTransitiveAssignment_4_8() { return cIsTransitiveAssignment_4_8; }
		
		//'transitive'
		public Keyword getIsTransitiveTransitiveKeyword_4_8_0() { return cIsTransitiveTransitiveKeyword_4_8_0; }
		
		//'unreified'
		public Keyword getUnreifiedKeyword_5() { return cUnreifiedKeyword_5; }
		
		//'='
		public Keyword getEqualsSignKeyword_6() { return cEqualsSignKeyword_6; }
		
		//unreifiedPropertyName=ID
		public Assignment getUnreifiedPropertyNameAssignment_7() { return cUnreifiedPropertyNameAssignment_7; }
		
		//ID
		public RuleCall getUnreifiedPropertyNameIDTerminalRuleCall_7_0() { return cUnreifiedPropertyNameIDTerminalRuleCall_7_0; }
		
		//('inverse' '=' unreifiedInversePropertyName=ID)?
		public Group getGroup_8() { return cGroup_8; }
		
		//'inverse'
		public Keyword getInverseKeyword_8_0() { return cInverseKeyword_8_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_8_1() { return cEqualsSignKeyword_8_1; }
		
		//unreifiedInversePropertyName=ID
		public Assignment getUnreifiedInversePropertyNameAssignment_8_2() { return cUnreifiedInversePropertyNameAssignment_8_2; }
		
		//ID
		public RuleCall getUnreifiedInversePropertyNameIDTerminalRuleCall_8_2_0() { return cUnreifiedInversePropertyNameIDTerminalRuleCall_8_2_0; }
		
		//'source'
		public Keyword getSourceKeyword_9() { return cSourceKeyword_9; }
		
		//'='
		public Keyword getEqualsSignKeyword_10() { return cEqualsSignKeyword_10; }
		
		//source=[Entity|Reference]
		public Assignment getSourceAssignment_11() { return cSourceAssignment_11; }
		
		//[Entity|Reference]
		public CrossReference getSourceEntityCrossReference_11_0() { return cSourceEntityCrossReference_11_0; }
		
		//Reference
		public RuleCall getSourceEntityReferenceParserRuleCall_11_0_1() { return cSourceEntityReferenceParserRuleCall_11_0_1; }
		
		//'target'
		public Keyword getTargetKeyword_12() { return cTargetKeyword_12; }
		
		//'='
		public Keyword getEqualsSignKeyword_13() { return cEqualsSignKeyword_13; }
		
		//target=[Entity|Reference]
		public Assignment getTargetAssignment_14() { return cTargetAssignment_14; }
		
		//[Entity|Reference]
		public CrossReference getTargetEntityCrossReference_14_0() { return cTargetEntityCrossReference_14_0; }
		
		//Reference
		public RuleCall getTargetEntityReferenceParserRuleCall_14_0_1() { return cTargetEntityReferenceParserRuleCall_14_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_15() { return cRightCurlyBracketKeyword_15; }
	}
	public class UnreifiedRelationshipElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UnreifiedRelationship");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cUnreifiedRelationshipKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Assignment cIsFunctionalAssignment_4_0 = (Assignment)cUnorderedGroup_4.eContents().get(0);
		private final Keyword cIsFunctionalFunctionalKeyword_4_0_0 = (Keyword)cIsFunctionalAssignment_4_0.eContents().get(0);
		private final Assignment cIsInverseFunctionalAssignment_4_1 = (Assignment)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cIsInverseFunctionalInverseFunctionalKeyword_4_1_0 = (Keyword)cIsInverseFunctionalAssignment_4_1.eContents().get(0);
		private final Assignment cIsEssentialAssignment_4_2 = (Assignment)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cIsEssentialEssentialKeyword_4_2_0 = (Keyword)cIsEssentialAssignment_4_2.eContents().get(0);
		private final Assignment cIsInverseEssentialAssignment_4_3 = (Assignment)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cIsInverseEssentialInverseEssentialKeyword_4_3_0 = (Keyword)cIsInverseEssentialAssignment_4_3.eContents().get(0);
		private final Assignment cIsSymmetricAssignment_4_4 = (Assignment)cUnorderedGroup_4.eContents().get(4);
		private final Keyword cIsSymmetricSymmetricKeyword_4_4_0 = (Keyword)cIsSymmetricAssignment_4_4.eContents().get(0);
		private final Assignment cIsAsymmetricAssignment_4_5 = (Assignment)cUnorderedGroup_4.eContents().get(5);
		private final Keyword cIsAsymmetricAsymmetricKeyword_4_5_0 = (Keyword)cIsAsymmetricAssignment_4_5.eContents().get(0);
		private final Assignment cIsReflexiveAssignment_4_6 = (Assignment)cUnorderedGroup_4.eContents().get(6);
		private final Keyword cIsReflexiveReflexiveKeyword_4_6_0 = (Keyword)cIsReflexiveAssignment_4_6.eContents().get(0);
		private final Assignment cIsIrreflexiveAssignment_4_7 = (Assignment)cUnorderedGroup_4.eContents().get(7);
		private final Keyword cIsIrreflexiveIrreflexiveKeyword_4_7_0 = (Keyword)cIsIrreflexiveAssignment_4_7.eContents().get(0);
		private final Assignment cIsTransitiveAssignment_4_8 = (Assignment)cUnorderedGroup_4.eContents().get(8);
		private final Keyword cIsTransitiveTransitiveKeyword_4_8_0 = (Keyword)cIsTransitiveAssignment_4_8.eContents().get(0);
		private final Keyword cSourceKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cEqualsSignKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cSourceAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cSourceEntityCrossReference_7_0 = (CrossReference)cSourceAssignment_7.eContents().get(0);
		private final RuleCall cSourceEntityReferenceParserRuleCall_7_0_1 = (RuleCall)cSourceEntityCrossReference_7_0.eContents().get(1);
		private final Keyword cTargetKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Keyword cEqualsSignKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Assignment cTargetAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final CrossReference cTargetEntityCrossReference_10_0 = (CrossReference)cTargetAssignment_10.eContents().get(0);
		private final RuleCall cTargetEntityReferenceParserRuleCall_10_0_1 = (RuleCall)cTargetEntityCrossReference_10_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_11 = (Keyword)cGroup.eContents().get(11);
		
		//UnreifiedRelationship:
		//	annotations+=AnnotationPropertyValue*
		//	'unreifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
		//	isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
		//	isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
		//	'source' '=' source=[Entity|Reference]
		//	'target' '=' target=[Entity|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'unreifiedRelationship' name=ID '{' (isFunctional?='functional'? &
		//isInverseFunctional?='inverseFunctional'? & isEssential?='essential'? & isInverseEssential?='inverseEssential'? &
		//isSymmetric?='symmetric'? & isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? &
		//isTransitive?='transitive'?) 'source' '=' source=[Entity|Reference] 'target' '=' target=[Entity|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'unreifiedRelationship'
		public Keyword getUnreifiedRelationshipKeyword_1() { return cUnreifiedRelationshipKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? & isEssential?='essential'? &
		//isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? & isAsymmetric?='asymmetric'? &
		//isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//isFunctional?='functional'?
		public Assignment getIsFunctionalAssignment_4_0() { return cIsFunctionalAssignment_4_0; }
		
		//'functional'
		public Keyword getIsFunctionalFunctionalKeyword_4_0_0() { return cIsFunctionalFunctionalKeyword_4_0_0; }
		
		//isInverseFunctional?='inverseFunctional'?
		public Assignment getIsInverseFunctionalAssignment_4_1() { return cIsInverseFunctionalAssignment_4_1; }
		
		//'inverseFunctional'
		public Keyword getIsInverseFunctionalInverseFunctionalKeyword_4_1_0() { return cIsInverseFunctionalInverseFunctionalKeyword_4_1_0; }
		
		//isEssential?='essential'?
		public Assignment getIsEssentialAssignment_4_2() { return cIsEssentialAssignment_4_2; }
		
		//'essential'
		public Keyword getIsEssentialEssentialKeyword_4_2_0() { return cIsEssentialEssentialKeyword_4_2_0; }
		
		//isInverseEssential?='inverseEssential'?
		public Assignment getIsInverseEssentialAssignment_4_3() { return cIsInverseEssentialAssignment_4_3; }
		
		//'inverseEssential'
		public Keyword getIsInverseEssentialInverseEssentialKeyword_4_3_0() { return cIsInverseEssentialInverseEssentialKeyword_4_3_0; }
		
		//isSymmetric?='symmetric'?
		public Assignment getIsSymmetricAssignment_4_4() { return cIsSymmetricAssignment_4_4; }
		
		//'symmetric'
		public Keyword getIsSymmetricSymmetricKeyword_4_4_0() { return cIsSymmetricSymmetricKeyword_4_4_0; }
		
		//isAsymmetric?='asymmetric'?
		public Assignment getIsAsymmetricAssignment_4_5() { return cIsAsymmetricAssignment_4_5; }
		
		//'asymmetric'
		public Keyword getIsAsymmetricAsymmetricKeyword_4_5_0() { return cIsAsymmetricAsymmetricKeyword_4_5_0; }
		
		//isReflexive?='reflexive'?
		public Assignment getIsReflexiveAssignment_4_6() { return cIsReflexiveAssignment_4_6; }
		
		//'reflexive'
		public Keyword getIsReflexiveReflexiveKeyword_4_6_0() { return cIsReflexiveReflexiveKeyword_4_6_0; }
		
		//isIrreflexive?='irreflexive'?
		public Assignment getIsIrreflexiveAssignment_4_7() { return cIsIrreflexiveAssignment_4_7; }
		
		//'irreflexive'
		public Keyword getIsIrreflexiveIrreflexiveKeyword_4_7_0() { return cIsIrreflexiveIrreflexiveKeyword_4_7_0; }
		
		//isTransitive?='transitive'?
		public Assignment getIsTransitiveAssignment_4_8() { return cIsTransitiveAssignment_4_8; }
		
		//'transitive'
		public Keyword getIsTransitiveTransitiveKeyword_4_8_0() { return cIsTransitiveTransitiveKeyword_4_8_0; }
		
		//'source'
		public Keyword getSourceKeyword_5() { return cSourceKeyword_5; }
		
		//'='
		public Keyword getEqualsSignKeyword_6() { return cEqualsSignKeyword_6; }
		
		//source=[Entity|Reference]
		public Assignment getSourceAssignment_7() { return cSourceAssignment_7; }
		
		//[Entity|Reference]
		public CrossReference getSourceEntityCrossReference_7_0() { return cSourceEntityCrossReference_7_0; }
		
		//Reference
		public RuleCall getSourceEntityReferenceParserRuleCall_7_0_1() { return cSourceEntityReferenceParserRuleCall_7_0_1; }
		
		//'target'
		public Keyword getTargetKeyword_8() { return cTargetKeyword_8; }
		
		//'='
		public Keyword getEqualsSignKeyword_9() { return cEqualsSignKeyword_9; }
		
		//target=[Entity|Reference]
		public Assignment getTargetAssignment_10() { return cTargetAssignment_10; }
		
		//[Entity|Reference]
		public CrossReference getTargetEntityCrossReference_10_0() { return cTargetEntityCrossReference_10_0; }
		
		//Reference
		public RuleCall getTargetEntityReferenceParserRuleCall_10_0_1() { return cTargetEntityReferenceParserRuleCall_10_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_11() { return cRightCurlyBracketKeyword_11; }
	}
	public class ScalarElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Scalar");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cScalarKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		//// 2 Datatypes
		//Scalar:
		//	annotations+=AnnotationPropertyValue*
		//	'scalar' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'scalar' name=ID
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'scalar'
		public Keyword getScalarKeyword_1() { return cScalarKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
	}
	public class StructureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Structure");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cStructureKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		//Structure:
		//	annotations+=AnnotationPropertyValue*
		//	'structure' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'structure' name=ID
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'structure'
		public Keyword getStructureKeyword_1() { return cStructureKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
	}
	public class EntityStructuredDataPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityStructuredDataProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cEntityStructuredDataPropertyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIsIdentityCriteriaAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cIsIdentityCriteriaPlusSignKeyword_2_0 = (Keyword)cIsIdentityCriteriaAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cDomainKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDomainAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cDomainEntityCrossReference_6_0 = (CrossReference)cDomainAssignment_6.eContents().get(0);
		private final RuleCall cDomainEntityReferenceParserRuleCall_6_0_1 = (RuleCall)cDomainEntityCrossReference_6_0.eContents().get(1);
		private final Keyword cRangeKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cRangeAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final CrossReference cRangeStructureCrossReference_8_0 = (CrossReference)cRangeAssignment_8.eContents().get(0);
		private final RuleCall cRangeStructureReferenceParserRuleCall_8_0_1 = (RuleCall)cRangeStructureCrossReference_8_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//// 4 DataRelationship Terms
		//EntityStructuredDataProperty:
		//	annotations+=AnnotationPropertyValue*
		//	'entityStructuredDataProperty' isIdentityCriteria?='+'? name=ID '{'
		//	'domain' domain=[Entity|Reference]
		//	'range' range=[Structure|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'entityStructuredDataProperty' isIdentityCriteria?='+'? name=ID '{' 'domain'
		//domain=[Entity|Reference] 'range' range=[Structure|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'entityStructuredDataProperty'
		public Keyword getEntityStructuredDataPropertyKeyword_1() { return cEntityStructuredDataPropertyKeyword_1; }
		
		//isIdentityCriteria?='+'?
		public Assignment getIsIdentityCriteriaAssignment_2() { return cIsIdentityCriteriaAssignment_2; }
		
		//'+'
		public Keyword getIsIdentityCriteriaPlusSignKeyword_2_0() { return cIsIdentityCriteriaPlusSignKeyword_2_0; }
		
		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//'domain'
		public Keyword getDomainKeyword_5() { return cDomainKeyword_5; }
		
		//domain=[Entity|Reference]
		public Assignment getDomainAssignment_6() { return cDomainAssignment_6; }
		
		//[Entity|Reference]
		public CrossReference getDomainEntityCrossReference_6_0() { return cDomainEntityCrossReference_6_0; }
		
		//Reference
		public RuleCall getDomainEntityReferenceParserRuleCall_6_0_1() { return cDomainEntityReferenceParserRuleCall_6_0_1; }
		
		//'range'
		public Keyword getRangeKeyword_7() { return cRangeKeyword_7; }
		
		//range=[Structure|Reference]
		public Assignment getRangeAssignment_8() { return cRangeAssignment_8; }
		
		//[Structure|Reference]
		public CrossReference getRangeStructureCrossReference_8_0() { return cRangeStructureCrossReference_8_0; }
		
		//Reference
		public RuleCall getRangeStructureReferenceParserRuleCall_8_0_1() { return cRangeStructureReferenceParserRuleCall_8_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}
	public class EntityScalarDataPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cEntityScalarDataPropertyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIsIdentityCriteriaAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cIsIdentityCriteriaPlusSignKeyword_2_0 = (Keyword)cIsIdentityCriteriaAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cDomainKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDomainAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cDomainEntityCrossReference_6_0 = (CrossReference)cDomainAssignment_6.eContents().get(0);
		private final RuleCall cDomainEntityReferenceParserRuleCall_6_0_1 = (RuleCall)cDomainEntityCrossReference_6_0.eContents().get(1);
		private final Keyword cRangeKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cRangeAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final CrossReference cRangeDataRangeCrossReference_8_0 = (CrossReference)cRangeAssignment_8.eContents().get(0);
		private final RuleCall cRangeDataRangeReferenceParserRuleCall_8_0_1 = (RuleCall)cRangeDataRangeCrossReference_8_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//EntityScalarDataProperty:
		//	annotations+=AnnotationPropertyValue*
		//	'entityScalarDataProperty' isIdentityCriteria?='+'? name=ID '{'
		//	'domain' domain=[Entity|Reference]
		//	'range' range=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'entityScalarDataProperty' isIdentityCriteria?='+'? name=ID '{' 'domain'
		//domain=[Entity|Reference] 'range' range=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'entityScalarDataProperty'
		public Keyword getEntityScalarDataPropertyKeyword_1() { return cEntityScalarDataPropertyKeyword_1; }
		
		//isIdentityCriteria?='+'?
		public Assignment getIsIdentityCriteriaAssignment_2() { return cIsIdentityCriteriaAssignment_2; }
		
		//'+'
		public Keyword getIsIdentityCriteriaPlusSignKeyword_2_0() { return cIsIdentityCriteriaPlusSignKeyword_2_0; }
		
		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//'domain'
		public Keyword getDomainKeyword_5() { return cDomainKeyword_5; }
		
		//domain=[Entity|Reference]
		public Assignment getDomainAssignment_6() { return cDomainAssignment_6; }
		
		//[Entity|Reference]
		public CrossReference getDomainEntityCrossReference_6_0() { return cDomainEntityCrossReference_6_0; }
		
		//Reference
		public RuleCall getDomainEntityReferenceParserRuleCall_6_0_1() { return cDomainEntityReferenceParserRuleCall_6_0_1; }
		
		//'range'
		public Keyword getRangeKeyword_7() { return cRangeKeyword_7; }
		
		//range=[DataRange|Reference]
		public Assignment getRangeAssignment_8() { return cRangeAssignment_8; }
		
		//[DataRange|Reference]
		public CrossReference getRangeDataRangeCrossReference_8_0() { return cRangeDataRangeCrossReference_8_0; }
		
		//Reference
		public RuleCall getRangeDataRangeReferenceParserRuleCall_8_0_1() { return cRangeDataRangeReferenceParserRuleCall_8_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}
	public class StructuredDataPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cStructuredDataPropertyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cDomainKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDomainAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDomainStructureCrossReference_5_0 = (CrossReference)cDomainAssignment_5.eContents().get(0);
		private final RuleCall cDomainStructureReferenceParserRuleCall_5_0_1 = (RuleCall)cDomainStructureCrossReference_5_0.eContents().get(1);
		private final Keyword cRangeKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cRangeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cRangeStructureCrossReference_7_0 = (CrossReference)cRangeAssignment_7.eContents().get(0);
		private final RuleCall cRangeStructureReferenceParserRuleCall_7_0_1 = (RuleCall)cRangeStructureCrossReference_7_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//StructuredDataProperty:
		//	annotations+=AnnotationPropertyValue*
		//	'structuredDataProperty' name=ID '{'
		//	'domain' domain=[Structure|Reference]
		//	'range' range=[Structure|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'structuredDataProperty' name=ID '{' 'domain' domain=[Structure|Reference] 'range'
		//range=[Structure|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'structuredDataProperty'
		public Keyword getStructuredDataPropertyKeyword_1() { return cStructuredDataPropertyKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'domain'
		public Keyword getDomainKeyword_4() { return cDomainKeyword_4; }
		
		//domain=[Structure|Reference]
		public Assignment getDomainAssignment_5() { return cDomainAssignment_5; }
		
		//[Structure|Reference]
		public CrossReference getDomainStructureCrossReference_5_0() { return cDomainStructureCrossReference_5_0; }
		
		//Reference
		public RuleCall getDomainStructureReferenceParserRuleCall_5_0_1() { return cDomainStructureReferenceParserRuleCall_5_0_1; }
		
		//'range'
		public Keyword getRangeKeyword_6() { return cRangeKeyword_6; }
		
		//range=[Structure|Reference]
		public Assignment getRangeAssignment_7() { return cRangeAssignment_7; }
		
		//[Structure|Reference]
		public CrossReference getRangeStructureCrossReference_7_0() { return cRangeStructureCrossReference_7_0; }
		
		//Reference
		public RuleCall getRangeStructureReferenceParserRuleCall_7_0_1() { return cRangeStructureReferenceParserRuleCall_7_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_8() { return cRightCurlyBracketKeyword_8; }
	}
	public class ScalarDataPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cScalarDataPropertyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cDomainKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDomainAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDomainStructureCrossReference_5_0 = (CrossReference)cDomainAssignment_5.eContents().get(0);
		private final RuleCall cDomainStructureReferenceParserRuleCall_5_0_1 = (RuleCall)cDomainStructureCrossReference_5_0.eContents().get(1);
		private final Keyword cRangeKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cRangeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cRangeDataRangeCrossReference_7_0 = (CrossReference)cRangeAssignment_7.eContents().get(0);
		private final RuleCall cRangeDataRangeReferenceParserRuleCall_7_0_1 = (RuleCall)cRangeDataRangeCrossReference_7_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//ScalarDataProperty:
		//	annotations+=AnnotationPropertyValue*
		//	'scalarDataProperty' name=ID '{'
		//	'domain' domain=[Structure|Reference]
		//	'range' range=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'scalarDataProperty' name=ID '{' 'domain' domain=[Structure|Reference] 'range'
		//range=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'scalarDataProperty'
		public Keyword getScalarDataPropertyKeyword_1() { return cScalarDataPropertyKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'domain'
		public Keyword getDomainKeyword_4() { return cDomainKeyword_4; }
		
		//domain=[Structure|Reference]
		public Assignment getDomainAssignment_5() { return cDomainAssignment_5; }
		
		//[Structure|Reference]
		public CrossReference getDomainStructureCrossReference_5_0() { return cDomainStructureCrossReference_5_0; }
		
		//Reference
		public RuleCall getDomainStructureReferenceParserRuleCall_5_0_1() { return cDomainStructureReferenceParserRuleCall_5_0_1; }
		
		//'range'
		public Keyword getRangeKeyword_6() { return cRangeKeyword_6; }
		
		//range=[DataRange|Reference]
		public Assignment getRangeAssignment_7() { return cRangeAssignment_7; }
		
		//[DataRange|Reference]
		public CrossReference getRangeDataRangeCrossReference_7_0() { return cRangeDataRangeCrossReference_7_0; }
		
		//Reference
		public RuleCall getRangeDataRangeReferenceParserRuleCall_7_0_1() { return cRangeDataRangeReferenceParserRuleCall_7_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_8() { return cRightCurlyBracketKeyword_8; }
	}
	public class AnonymousConceptUnionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.AnonymousConceptUnionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cAnonymousConceptUnionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDisjunctionsAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0 = (RuleCall)cDisjunctionsAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//// ConceptTreeDisjunctions and DisjointUnionOfConceptsAxioms
		//AnonymousConceptUnionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'anonymousConceptUnion' '(' name=ID ')' '{'
		//	disjunctions+=DisjointUnionOfConceptsAxiom*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'anonymousConceptUnion' '(' name=ID ')' '{'
		//disjunctions+=DisjointUnionOfConceptsAxiom* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'anonymousConceptUnion'
		public Keyword getAnonymousConceptUnionKeyword_1() { return cAnonymousConceptUnionKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//disjunctions+=DisjointUnionOfConceptsAxiom*
		public Assignment getDisjunctionsAssignment_6() { return cDisjunctionsAssignment_6; }
		
		//DisjointUnionOfConceptsAxiom
		public RuleCall getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0() { return cDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class RootConceptTaxonomyAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RootConceptTaxonomyAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cRootConceptTaxonomyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cRootAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cRootConceptCrossReference_3_0 = (CrossReference)cRootAssignment_3.eContents().get(0);
		private final RuleCall cRootConceptReferenceParserRuleCall_3_0_1 = (RuleCall)cRootConceptCrossReference_3_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDisjunctionsAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0 = (RuleCall)cDisjunctionsAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//RootConceptTaxonomyAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'rootConceptTaxonomy' '(' root=[Concept|Reference] ')'
		//	'{'
		//	disjunctions+=DisjointUnionOfConceptsAxiom*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'rootConceptTaxonomy' '(' root=[Concept|Reference] ')' '{'
		//disjunctions+=DisjointUnionOfConceptsAxiom* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'rootConceptTaxonomy'
		public Keyword getRootConceptTaxonomyKeyword_1() { return cRootConceptTaxonomyKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//root=[Concept|Reference]
		public Assignment getRootAssignment_3() { return cRootAssignment_3; }
		
		//[Concept|Reference]
		public CrossReference getRootConceptCrossReference_3_0() { return cRootConceptCrossReference_3_0; }
		
		//Reference
		public RuleCall getRootConceptReferenceParserRuleCall_3_0_1() { return cRootConceptReferenceParserRuleCall_3_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//disjunctions+=DisjointUnionOfConceptsAxiom*
		public Assignment getDisjunctionsAssignment_6() { return cDisjunctionsAssignment_6; }
		
		//DisjointUnionOfConceptsAxiom
		public RuleCall getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0() { return cDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class SpecificDisjointConceptAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SpecificDisjointConceptAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cDisjointLeafKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cDisjointLeafAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cDisjointLeafConceptCrossReference_3_0 = (CrossReference)cDisjointLeafAssignment_3.eContents().get(0);
		private final RuleCall cDisjointLeafConceptReferenceParserRuleCall_3_0_1 = (RuleCall)cDisjointLeafConceptCrossReference_3_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//SpecificDisjointConceptAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'disjointLeaf' '(' disjointLeaf=[Concept|Reference] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'disjointLeaf' '(' disjointLeaf=[Concept|Reference] ')'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'disjointLeaf'
		public Keyword getDisjointLeafKeyword_1() { return cDisjointLeafKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//disjointLeaf=[Concept|Reference]
		public Assignment getDisjointLeafAssignment_3() { return cDisjointLeafAssignment_3; }
		
		//[Concept|Reference]
		public CrossReference getDisjointLeafConceptCrossReference_3_0() { return cDisjointLeafConceptCrossReference_3_0; }
		
		//Reference
		public RuleCall getDisjointLeafConceptReferenceParserRuleCall_3_0_1() { return cDisjointLeafConceptReferenceParserRuleCall_3_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}
	public class EntityExistentialRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityExistentialRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cSomeEntitiesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRestrictedDomainAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRestrictedDomainEntityCrossReference_2_0 = (CrossReference)cRestrictedDomainAssignment_2.eContents().get(0);
		private final RuleCall cRestrictedDomainEntityReferenceParserRuleCall_2_0_1 = (RuleCall)cRestrictedDomainEntityCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRestrictedRelationAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cRestrictedRelationReifiedRelationshipCrossReference_4_0 = (CrossReference)cRestrictedRelationAssignment_4.eContents().get(0);
		private final RuleCall cRestrictedRelationReifiedRelationshipReferenceParserRuleCall_4_0_1 = (RuleCall)cRestrictedRelationReifiedRelationshipCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeEntityCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_6_0.eContents().get(1);
		
		//// 2 EntityRestrictionAxioms
		//EntityExistentialRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'someEntities'
		//	restrictedDomain=[Entity|Reference]
		//	'.'
		//	restrictedRelation=[ReifiedRelationship|Reference]
		//	'in' restrictedRange=[Entity|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'someEntities' restrictedDomain=[Entity|Reference] '.'
		//restrictedRelation=[ReifiedRelationship|Reference] 'in' restrictedRange=[Entity|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'someEntities'
		public Keyword getSomeEntitiesKeyword_1() { return cSomeEntitiesKeyword_1; }
		
		//restrictedDomain=[Entity|Reference]
		public Assignment getRestrictedDomainAssignment_2() { return cRestrictedDomainAssignment_2; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedDomainEntityCrossReference_2_0() { return cRestrictedDomainEntityCrossReference_2_0; }
		
		//Reference
		public RuleCall getRestrictedDomainEntityReferenceParserRuleCall_2_0_1() { return cRestrictedDomainEntityReferenceParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//restrictedRelation=[ReifiedRelationship|Reference]
		public Assignment getRestrictedRelationAssignment_4() { return cRestrictedRelationAssignment_4; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getRestrictedRelationReifiedRelationshipCrossReference_4_0() { return cRestrictedRelationReifiedRelationshipCrossReference_4_0; }
		
		//Reference
		public RuleCall getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_4_0_1() { return cRestrictedRelationReifiedRelationshipReferenceParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//restrictedRange=[Entity|Reference]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedRangeEntityCrossReference_6_0() { return cRestrictedRangeEntityCrossReference_6_0; }
		
		//Reference
		public RuleCall getRestrictedRangeEntityReferenceParserRuleCall_6_0_1() { return cRestrictedRangeEntityReferenceParserRuleCall_6_0_1; }
	}
	public class EntityUniversalRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityUniversalRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cAllEntitiesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRestrictedDomainAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRestrictedDomainEntityCrossReference_2_0 = (CrossReference)cRestrictedDomainAssignment_2.eContents().get(0);
		private final RuleCall cRestrictedDomainEntityReferenceParserRuleCall_2_0_1 = (RuleCall)cRestrictedDomainEntityCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRestrictedRelationAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cRestrictedRelationReifiedRelationshipCrossReference_4_0 = (CrossReference)cRestrictedRelationAssignment_4.eContents().get(0);
		private final RuleCall cRestrictedRelationReifiedRelationshipReferenceParserRuleCall_4_0_1 = (RuleCall)cRestrictedRelationReifiedRelationshipCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeEntityCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_6_0.eContents().get(1);
		
		//EntityUniversalRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'allEntities'
		//	restrictedDomain=[Entity|Reference]
		//	'.'
		//	restrictedRelation=[ReifiedRelationship|Reference]
		//	'in' restrictedRange=[Entity|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'allEntities' restrictedDomain=[Entity|Reference] '.'
		//restrictedRelation=[ReifiedRelationship|Reference] 'in' restrictedRange=[Entity|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'allEntities'
		public Keyword getAllEntitiesKeyword_1() { return cAllEntitiesKeyword_1; }
		
		//restrictedDomain=[Entity|Reference]
		public Assignment getRestrictedDomainAssignment_2() { return cRestrictedDomainAssignment_2; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedDomainEntityCrossReference_2_0() { return cRestrictedDomainEntityCrossReference_2_0; }
		
		//Reference
		public RuleCall getRestrictedDomainEntityReferenceParserRuleCall_2_0_1() { return cRestrictedDomainEntityReferenceParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//restrictedRelation=[ReifiedRelationship|Reference]
		public Assignment getRestrictedRelationAssignment_4() { return cRestrictedRelationAssignment_4; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getRestrictedRelationReifiedRelationshipCrossReference_4_0() { return cRestrictedRelationReifiedRelationshipCrossReference_4_0; }
		
		//Reference
		public RuleCall getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_4_0_1() { return cRestrictedRelationReifiedRelationshipReferenceParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//restrictedRange=[Entity|Reference]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedRangeEntityCrossReference_6_0() { return cRestrictedRangeEntityCrossReference_6_0; }
		
		//Reference
		public RuleCall getRestrictedRangeEntityReferenceParserRuleCall_6_0_1() { return cRestrictedRangeEntityReferenceParserRuleCall_6_0_1; }
	}
	public class AspectSpecializationAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.AspectSpecializationAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cSubEntityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSubEntityEntityCrossReference_1_0 = (CrossReference)cSubEntityAssignment_1.eContents().get(0);
		private final RuleCall cSubEntityEntityReferenceParserRuleCall_1_0_1 = (RuleCall)cSubEntityEntityCrossReference_1_0.eContents().get(1);
		private final Keyword cExtendsAspectKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSuperAspectAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSuperAspectAspectCrossReference_3_0 = (CrossReference)cSuperAspectAssignment_3.eContents().get(0);
		private final RuleCall cSuperAspectAspectReferenceParserRuleCall_3_0_1 = (RuleCall)cSuperAspectAspectCrossReference_3_0.eContents().get(1);
		
		//// 3 SpecializationAxioms
		//AspectSpecializationAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	subEntity=[Entity|Reference] 'extendsAspect' superAspect=[Aspect|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* subEntity=[Entity|Reference] 'extendsAspect' superAspect=[Aspect|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//subEntity=[Entity|Reference]
		public Assignment getSubEntityAssignment_1() { return cSubEntityAssignment_1; }
		
		//[Entity|Reference]
		public CrossReference getSubEntityEntityCrossReference_1_0() { return cSubEntityEntityCrossReference_1_0; }
		
		//Reference
		public RuleCall getSubEntityEntityReferenceParserRuleCall_1_0_1() { return cSubEntityEntityReferenceParserRuleCall_1_0_1; }
		
		//'extendsAspect'
		public Keyword getExtendsAspectKeyword_2() { return cExtendsAspectKeyword_2; }
		
		//superAspect=[Aspect|Reference]
		public Assignment getSuperAspectAssignment_3() { return cSuperAspectAssignment_3; }
		
		//[Aspect|Reference]
		public CrossReference getSuperAspectAspectCrossReference_3_0() { return cSuperAspectAspectCrossReference_3_0; }
		
		//Reference
		public RuleCall getSuperAspectAspectReferenceParserRuleCall_3_0_1() { return cSuperAspectAspectReferenceParserRuleCall_3_0_1; }
	}
	public class ConceptSpecializationAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ConceptSpecializationAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cSubConceptAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSubConceptConceptCrossReference_1_0 = (CrossReference)cSubConceptAssignment_1.eContents().get(0);
		private final RuleCall cSubConceptConceptReferenceParserRuleCall_1_0_1 = (RuleCall)cSubConceptConceptCrossReference_1_0.eContents().get(1);
		private final Keyword cExtendsConceptKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSuperConceptAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSuperConceptConceptCrossReference_3_0 = (CrossReference)cSuperConceptAssignment_3.eContents().get(0);
		private final RuleCall cSuperConceptConceptReferenceParserRuleCall_3_0_1 = (RuleCall)cSuperConceptConceptCrossReference_3_0.eContents().get(1);
		
		//ConceptSpecializationAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	subConcept=[Concept|Reference] 'extendsConcept' superConcept=[Concept|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* subConcept=[Concept|Reference] 'extendsConcept' superConcept=[Concept|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//subConcept=[Concept|Reference]
		public Assignment getSubConceptAssignment_1() { return cSubConceptAssignment_1; }
		
		//[Concept|Reference]
		public CrossReference getSubConceptConceptCrossReference_1_0() { return cSubConceptConceptCrossReference_1_0; }
		
		//Reference
		public RuleCall getSubConceptConceptReferenceParserRuleCall_1_0_1() { return cSubConceptConceptReferenceParserRuleCall_1_0_1; }
		
		//'extendsConcept'
		public Keyword getExtendsConceptKeyword_2() { return cExtendsConceptKeyword_2; }
		
		//superConcept=[Concept|Reference]
		public Assignment getSuperConceptAssignment_3() { return cSuperConceptAssignment_3; }
		
		//[Concept|Reference]
		public CrossReference getSuperConceptConceptCrossReference_3_0() { return cSuperConceptConceptCrossReference_3_0; }
		
		//Reference
		public RuleCall getSuperConceptConceptReferenceParserRuleCall_3_0_1() { return cSuperConceptConceptReferenceParserRuleCall_3_0_1; }
	}
	public class ReifiedRelationshipSpecializationAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipSpecializationAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cSubRelationshipAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSubRelationshipReifiedRelationshipCrossReference_1_0 = (CrossReference)cSubRelationshipAssignment_1.eContents().get(0);
		private final RuleCall cSubRelationshipReifiedRelationshipReferenceParserRuleCall_1_0_1 = (RuleCall)cSubRelationshipReifiedRelationshipCrossReference_1_0.eContents().get(1);
		private final Keyword cExtendsRelationshipKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSuperRelationshipAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSuperRelationshipReifiedRelationshipCrossReference_3_0 = (CrossReference)cSuperRelationshipAssignment_3.eContents().get(0);
		private final RuleCall cSuperRelationshipReifiedRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cSuperRelationshipReifiedRelationshipCrossReference_3_0.eContents().get(1);
		
		//ReifiedRelationshipSpecializationAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	subRelationship=[ReifiedRelationship|Reference] 'extendsRelationship'
		//	superRelationship=[ReifiedRelationship|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* subRelationship=[ReifiedRelationship|Reference] 'extendsRelationship'
		//superRelationship=[ReifiedRelationship|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//subRelationship=[ReifiedRelationship|Reference]
		public Assignment getSubRelationshipAssignment_1() { return cSubRelationshipAssignment_1; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getSubRelationshipReifiedRelationshipCrossReference_1_0() { return cSubRelationshipReifiedRelationshipCrossReference_1_0; }
		
		//Reference
		public RuleCall getSubRelationshipReifiedRelationshipReferenceParserRuleCall_1_0_1() { return cSubRelationshipReifiedRelationshipReferenceParserRuleCall_1_0_1; }
		
		//'extendsRelationship'
		public Keyword getExtendsRelationshipKeyword_2() { return cExtendsRelationshipKeyword_2; }
		
		//superRelationship=[ReifiedRelationship|Reference]
		public Assignment getSuperRelationshipAssignment_3() { return cSuperRelationshipAssignment_3; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getSuperRelationshipReifiedRelationshipCrossReference_3_0() { return cSuperRelationshipReifiedRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getSuperRelationshipReifiedRelationshipReferenceParserRuleCall_3_0_1() { return cSuperRelationshipReifiedRelationshipReferenceParserRuleCall_3_0_1; }
	}
	public class EntityScalarDataPropertyExistentialRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataPropertyExistentialRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cSomeDataKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRestrictedEntityAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRestrictedEntityEntityCrossReference_2_0 = (CrossReference)cRestrictedEntityAssignment_2.eContents().get(0);
		private final RuleCall cRestrictedEntityEntityReferenceParserRuleCall_2_0_1 = (RuleCall)cRestrictedEntityEntityCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cScalarPropertyAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cScalarPropertyEntityScalarDataPropertyCrossReference_4_0 = (CrossReference)cScalarPropertyAssignment_4.eContents().get(0);
		private final RuleCall cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1 = (RuleCall)cScalarPropertyEntityScalarDataPropertyCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cScalarRestrictionAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cScalarRestrictionDataRangeCrossReference_6_0 = (CrossReference)cScalarRestrictionAssignment_6.eContents().get(0);
		private final RuleCall cScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cScalarRestrictionDataRangeCrossReference_6_0.eContents().get(1);
		
		//// 3 EntityScalarDataPropertyRestrictionAxioms
		//EntityScalarDataPropertyExistentialRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'someData'
		//	restrictedEntity=[Entity|Reference]
		//	'.'
		//	scalarProperty=[EntityScalarDataProperty|Reference]
		//	'in' scalarRestriction=[DataRange|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'someData' restrictedEntity=[Entity|Reference] '.'
		//scalarProperty=[EntityScalarDataProperty|Reference] 'in' scalarRestriction=[DataRange|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'someData'
		public Keyword getSomeDataKeyword_1() { return cSomeDataKeyword_1; }
		
		//restrictedEntity=[Entity|Reference]
		public Assignment getRestrictedEntityAssignment_2() { return cRestrictedEntityAssignment_2; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedEntityEntityCrossReference_2_0() { return cRestrictedEntityEntityCrossReference_2_0; }
		
		//Reference
		public RuleCall getRestrictedEntityEntityReferenceParserRuleCall_2_0_1() { return cRestrictedEntityEntityReferenceParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//scalarProperty=[EntityScalarDataProperty|Reference]
		public Assignment getScalarPropertyAssignment_4() { return cScalarPropertyAssignment_4; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getScalarPropertyEntityScalarDataPropertyCrossReference_4_0() { return cScalarPropertyEntityScalarDataPropertyCrossReference_4_0; }
		
		//Reference
		public RuleCall getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1() { return cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//scalarRestriction=[DataRange|Reference]
		public Assignment getScalarRestrictionAssignment_6() { return cScalarRestrictionAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getScalarRestrictionDataRangeCrossReference_6_0() { return cScalarRestrictionDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1() { return cScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1; }
	}
	public class EntityScalarDataPropertyParticularRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataPropertyParticularRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cEveryKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRestrictedEntityAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRestrictedEntityEntityCrossReference_2_0 = (CrossReference)cRestrictedEntityAssignment_2.eContents().get(0);
		private final RuleCall cRestrictedEntityEntityReferenceParserRuleCall_2_0_1 = (RuleCall)cRestrictedEntityEntityCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cScalarPropertyAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cScalarPropertyEntityScalarDataPropertyCrossReference_4_0 = (CrossReference)cScalarPropertyAssignment_4.eContents().get(0);
		private final RuleCall cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1 = (RuleCall)cScalarPropertyEntityScalarDataPropertyCrossReference_4_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cLiteralValueAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cLiteralValueLiteralValueParserRuleCall_6_0 = (RuleCall)cLiteralValueAssignment_6.eContents().get(0);
		
		//EntityScalarDataPropertyParticularRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'every'
		//	restrictedEntity=[Entity|Reference]
		//	'.' scalarProperty=[EntityScalarDataProperty|Reference]
		//	'=' literalValue=LiteralValue;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'every' restrictedEntity=[Entity|Reference] '.'
		//scalarProperty=[EntityScalarDataProperty|Reference] '=' literalValue=LiteralValue
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'every'
		public Keyword getEveryKeyword_1() { return cEveryKeyword_1; }
		
		//restrictedEntity=[Entity|Reference]
		public Assignment getRestrictedEntityAssignment_2() { return cRestrictedEntityAssignment_2; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedEntityEntityCrossReference_2_0() { return cRestrictedEntityEntityCrossReference_2_0; }
		
		//Reference
		public RuleCall getRestrictedEntityEntityReferenceParserRuleCall_2_0_1() { return cRestrictedEntityEntityReferenceParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//scalarProperty=[EntityScalarDataProperty|Reference]
		public Assignment getScalarPropertyAssignment_4() { return cScalarPropertyAssignment_4; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getScalarPropertyEntityScalarDataPropertyCrossReference_4_0() { return cScalarPropertyEntityScalarDataPropertyCrossReference_4_0; }
		
		//Reference
		public RuleCall getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1() { return cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }
		
		//literalValue=LiteralValue
		public Assignment getLiteralValueAssignment_6() { return cLiteralValueAssignment_6; }
		
		//LiteralValue
		public RuleCall getLiteralValueLiteralValueParserRuleCall_6_0() { return cLiteralValueLiteralValueParserRuleCall_6_0; }
	}
	public class EntityScalarDataPropertyUniversalRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataPropertyUniversalRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cAllDataKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRestrictedEntityAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRestrictedEntityEntityCrossReference_2_0 = (CrossReference)cRestrictedEntityAssignment_2.eContents().get(0);
		private final RuleCall cRestrictedEntityEntityReferenceParserRuleCall_2_0_1 = (RuleCall)cRestrictedEntityEntityCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cScalarPropertyAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cScalarPropertyEntityScalarDataPropertyCrossReference_4_0 = (CrossReference)cScalarPropertyAssignment_4.eContents().get(0);
		private final RuleCall cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1 = (RuleCall)cScalarPropertyEntityScalarDataPropertyCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cScalarRestrictionAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cScalarRestrictionDataRangeCrossReference_6_0 = (CrossReference)cScalarRestrictionAssignment_6.eContents().get(0);
		private final RuleCall cScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cScalarRestrictionDataRangeCrossReference_6_0.eContents().get(1);
		
		//EntityScalarDataPropertyUniversalRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'allData'
		//	restrictedEntity=[Entity|Reference]
		//	'.' scalarProperty=[EntityScalarDataProperty|Reference]
		//	'in' scalarRestriction=[DataRange|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'allData' restrictedEntity=[Entity|Reference] '.'
		//scalarProperty=[EntityScalarDataProperty|Reference] 'in' scalarRestriction=[DataRange|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'allData'
		public Keyword getAllDataKeyword_1() { return cAllDataKeyword_1; }
		
		//restrictedEntity=[Entity|Reference]
		public Assignment getRestrictedEntityAssignment_2() { return cRestrictedEntityAssignment_2; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedEntityEntityCrossReference_2_0() { return cRestrictedEntityEntityCrossReference_2_0; }
		
		//Reference
		public RuleCall getRestrictedEntityEntityReferenceParserRuleCall_2_0_1() { return cRestrictedEntityEntityReferenceParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//scalarProperty=[EntityScalarDataProperty|Reference]
		public Assignment getScalarPropertyAssignment_4() { return cScalarPropertyAssignment_4; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getScalarPropertyEntityScalarDataPropertyCrossReference_4_0() { return cScalarPropertyEntityScalarDataPropertyCrossReference_4_0; }
		
		//Reference
		public RuleCall getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1() { return cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//scalarRestriction=[DataRange|Reference]
		public Assignment getScalarRestrictionAssignment_6() { return cScalarRestrictionAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getScalarRestrictionDataRangeCrossReference_6_0() { return cScalarRestrictionDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1() { return cScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1; }
	}
	public class EntityStructuredDataPropertyParticularRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityStructuredDataPropertyParticularRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cEveryKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRestrictedEntityAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRestrictedEntityEntityCrossReference_2_0 = (CrossReference)cRestrictedEntityAssignment_2.eContents().get(0);
		private final RuleCall cRestrictedEntityEntityReferenceParserRuleCall_2_0_1 = (RuleCall)cRestrictedEntityEntityCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cStructuredDataPropertyAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cStructuredDataPropertyEntityStructuredDataPropertyCrossReference_4_0 = (CrossReference)cStructuredDataPropertyAssignment_4.eContents().get(0);
		private final RuleCall cStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_4_0_1 = (RuleCall)cStructuredDataPropertyEntityStructuredDataPropertyCrossReference_4_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Assignment cStructuredDataPropertyRestrictionsAssignment_7_0 = (Assignment)cAlternatives_7.eContents().get(0);
		private final RuleCall cStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0 = (RuleCall)cStructuredDataPropertyRestrictionsAssignment_7_0.eContents().get(0);
		private final Assignment cScalarDataPropertyRestrictionsAssignment_7_1 = (Assignment)cAlternatives_7.eContents().get(1);
		private final RuleCall cScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0 = (RuleCall)cScalarDataPropertyRestrictionsAssignment_7_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//// 1 EntityStructuredDataPropertyRestrictionAxiom
		//EntityStructuredDataPropertyParticularRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'every'
		//	restrictedEntity=[Entity|Reference]
		//	'.'
		//	structuredDataProperty=[EntityStructuredDataProperty|Reference]
		//	'='
		//	'{' (structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple |
		//	scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'every' restrictedEntity=[Entity|Reference] '.'
		//structuredDataProperty=[EntityStructuredDataProperty|Reference] '=' '{'
		//(structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple |
		//scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'every'
		public Keyword getEveryKeyword_1() { return cEveryKeyword_1; }
		
		//restrictedEntity=[Entity|Reference]
		public Assignment getRestrictedEntityAssignment_2() { return cRestrictedEntityAssignment_2; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedEntityEntityCrossReference_2_0() { return cRestrictedEntityEntityCrossReference_2_0; }
		
		//Reference
		public RuleCall getRestrictedEntityEntityReferenceParserRuleCall_2_0_1() { return cRestrictedEntityEntityReferenceParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//structuredDataProperty=[EntityStructuredDataProperty|Reference]
		public Assignment getStructuredDataPropertyAssignment_4() { return cStructuredDataPropertyAssignment_4; }
		
		//[EntityStructuredDataProperty|Reference]
		public CrossReference getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_4_0() { return cStructuredDataPropertyEntityStructuredDataPropertyCrossReference_4_0; }
		
		//Reference
		public RuleCall getStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_4_0_1() { return cStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_4_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_6() { return cLeftCurlyBracketKeyword_6; }
		
		//(structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple |
		//scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)*
		public Alternatives getAlternatives_7() { return cAlternatives_7; }
		
		//structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple
		public Assignment getStructuredDataPropertyRestrictionsAssignment_7_0() { return cStructuredDataPropertyRestrictionsAssignment_7_0; }
		
		//RestrictionStructuredDataPropertyTuple
		public RuleCall getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0() { return cStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0; }
		
		//scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue
		public Assignment getScalarDataPropertyRestrictionsAssignment_7_1() { return cScalarDataPropertyRestrictionsAssignment_7_1; }
		
		//RestrictionScalarDataPropertyValue
		public RuleCall getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0() { return cScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_8() { return cRightCurlyBracketKeyword_8; }
	}
	public class RestrictionStructuredDataPropertyTupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RestrictionStructuredDataPropertyTuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cStructuredDataPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cStructuredDataPropertyStructuredDataPropertyCrossReference_1_0 = (CrossReference)cStructuredDataPropertyAssignment_1.eContents().get(0);
		private final RuleCall cStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_1_0_1 = (RuleCall)cStructuredDataPropertyStructuredDataPropertyCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cStructuredDataPropertyRestrictionsAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0 = (RuleCall)cStructuredDataPropertyRestrictionsAssignment_4_0.eContents().get(0);
		private final Assignment cScalarDataPropertyRestrictionsAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final RuleCall cScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0 = (RuleCall)cScalarDataPropertyRestrictionsAssignment_4_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//RestrictionStructuredDataPropertyTuple:
		//	annotations+=AnnotationPropertyValue*
		//	structuredDataProperty=[StructuredDataProperty|Reference]
		//	'=' '{' (structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple |
		//	scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* structuredDataProperty=[StructuredDataProperty|Reference] '=' '{'
		//(structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple |
		//scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//structuredDataProperty=[StructuredDataProperty|Reference]
		public Assignment getStructuredDataPropertyAssignment_1() { return cStructuredDataPropertyAssignment_1; }
		
		//[StructuredDataProperty|Reference]
		public CrossReference getStructuredDataPropertyStructuredDataPropertyCrossReference_1_0() { return cStructuredDataPropertyStructuredDataPropertyCrossReference_1_0; }
		
		//Reference
		public RuleCall getStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_1_0_1() { return cStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//(structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple |
		//scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)*
		public Alternatives getAlternatives_4() { return cAlternatives_4; }
		
		//structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple
		public Assignment getStructuredDataPropertyRestrictionsAssignment_4_0() { return cStructuredDataPropertyRestrictionsAssignment_4_0; }
		
		//RestrictionStructuredDataPropertyTuple
		public RuleCall getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0() { return cStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0; }
		
		//scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue
		public Assignment getScalarDataPropertyRestrictionsAssignment_4_1() { return cScalarDataPropertyRestrictionsAssignment_4_1; }
		
		//RestrictionScalarDataPropertyValue
		public RuleCall getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0() { return cScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class RestrictionScalarDataPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RestrictionScalarDataPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cScalarDataPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cScalarDataPropertyScalarDataPropertyCrossReference_1_0 = (CrossReference)cScalarDataPropertyAssignment_1.eContents().get(0);
		private final RuleCall cScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_1_0_1 = (RuleCall)cScalarDataPropertyScalarDataPropertyCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cScalarPropertyValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cScalarPropertyValueLiteralValueParserRuleCall_3_0 = (RuleCall)cScalarPropertyValueAssignment_3.eContents().get(0);
		
		//RestrictionScalarDataPropertyValue:
		//	annotations+=AnnotationPropertyValue*
		//	scalarDataProperty=[ScalarDataProperty|Reference]
		//	'='
		//	scalarPropertyValue=LiteralValue;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* scalarDataProperty=[ScalarDataProperty|Reference] '='
		//scalarPropertyValue=LiteralValue
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//scalarDataProperty=[ScalarDataProperty|Reference]
		public Assignment getScalarDataPropertyAssignment_1() { return cScalarDataPropertyAssignment_1; }
		
		//[ScalarDataProperty|Reference]
		public CrossReference getScalarDataPropertyScalarDataPropertyCrossReference_1_0() { return cScalarDataPropertyScalarDataPropertyCrossReference_1_0; }
		
		//Reference
		public RuleCall getScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_1_0_1() { return cScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//scalarPropertyValue=LiteralValue
		public Assignment getScalarPropertyValueAssignment_3() { return cScalarPropertyValueAssignment_3; }
		
		//LiteralValue
		public RuleCall getScalarPropertyValueLiteralValueParserRuleCall_3_0() { return cScalarPropertyValueLiteralValueParserRuleCall_3_0; }
	}
	public class BinaryScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.BinaryScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cBinaryScalarRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cUnorderedGroup_4.eContents().get(0);
		private final Keyword cLengthKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Assignment cLengthAssignment_4_0_1 = (Assignment)cGroup_4_0.eContents().get(1);
		private final RuleCall cLengthDIGITSTerminalRuleCall_4_0_1_0 = (RuleCall)cLengthAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMinLengthKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMinLengthDIGITSTerminalRuleCall_4_1_1_0 = (RuleCall)cMinLengthAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMaxLengthKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMaxLengthDIGITSTerminalRuleCall_4_2_1_0 = (RuleCall)cMaxLengthAssignment_4_2_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//// 8 RestrictedDataRanges + 1 ScalarOneOfLiteralAxiom
		//BinaryScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'binaryScalarRestriction' name=ID
		//	'{' (('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'binaryScalarRestriction' name=ID '{' (('length' length=DIGITS)? & ('minLength'
		//minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)?) 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'binaryScalarRestriction'
		public Keyword getBinaryScalarRestrictionKeyword_1() { return cBinaryScalarRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('length' length=DIGITS)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'length'
		public Keyword getLengthKeyword_4_0_0() { return cLengthKeyword_4_0_0; }
		
		//length=DIGITS
		public Assignment getLengthAssignment_4_0_1() { return cLengthAssignment_4_0_1; }
		
		//DIGITS
		public RuleCall getLengthDIGITSTerminalRuleCall_4_0_1_0() { return cLengthDIGITSTerminalRuleCall_4_0_1_0; }
		
		//('minLength' minLength=DIGITS)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_4_1_0() { return cMinLengthKeyword_4_1_0; }
		
		//minLength=DIGITS
		public Assignment getMinLengthAssignment_4_1_1() { return cMinLengthAssignment_4_1_1; }
		
		//DIGITS
		public RuleCall getMinLengthDIGITSTerminalRuleCall_4_1_1_0() { return cMinLengthDIGITSTerminalRuleCall_4_1_1_0; }
		
		//('maxLength' maxLength=DIGITS)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_4_2_0() { return cMaxLengthKeyword_4_2_0; }
		
		//maxLength=DIGITS
		public Assignment getMaxLengthAssignment_4_2_1() { return cMaxLengthAssignment_4_2_1; }
		
		//DIGITS
		public RuleCall getMaxLengthDIGITSTerminalRuleCall_4_2_1_0() { return cMaxLengthDIGITSTerminalRuleCall_4_2_1_0; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_5() { return cRestrictedRangeKeyword_5; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_6_0() { return cRestrictedRangeDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class IRIScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IRIScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cIriScalarRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cUnorderedGroup_4.eContents().get(0);
		private final Keyword cLengthKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Assignment cLengthAssignment_4_0_1 = (Assignment)cGroup_4_0.eContents().get(1);
		private final RuleCall cLengthDIGITSTerminalRuleCall_4_0_1_0 = (RuleCall)cLengthAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMinLengthKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMinLengthDIGITSTerminalRuleCall_4_1_1_0 = (RuleCall)cMinLengthAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMaxLengthKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMaxLengthDIGITSTerminalRuleCall_4_2_1_0 = (RuleCall)cMaxLengthAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_3 = (Group)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cPatternKeyword_4_3_0 = (Keyword)cGroup_4_3.eContents().get(0);
		private final Assignment cPatternAssignment_4_3_1 = (Assignment)cGroup_4_3.eContents().get(1);
		private final RuleCall cPatternLiteralPatternParserRuleCall_4_3_1_0 = (RuleCall)cPatternAssignment_4_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//IRIScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'iriScalarRestriction' name=ID
		//	'{' (('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
		//	pattern=LiteralPattern)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'iriScalarRestriction' name=ID '{' (('length' length=DIGITS)? & ('minLength'
		//minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern' pattern=LiteralPattern)?) 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'iriScalarRestriction'
		public Keyword getIriScalarRestrictionKeyword_1() { return cIriScalarRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
		//pattern=LiteralPattern)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('length' length=DIGITS)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'length'
		public Keyword getLengthKeyword_4_0_0() { return cLengthKeyword_4_0_0; }
		
		//length=DIGITS
		public Assignment getLengthAssignment_4_0_1() { return cLengthAssignment_4_0_1; }
		
		//DIGITS
		public RuleCall getLengthDIGITSTerminalRuleCall_4_0_1_0() { return cLengthDIGITSTerminalRuleCall_4_0_1_0; }
		
		//('minLength' minLength=DIGITS)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_4_1_0() { return cMinLengthKeyword_4_1_0; }
		
		//minLength=DIGITS
		public Assignment getMinLengthAssignment_4_1_1() { return cMinLengthAssignment_4_1_1; }
		
		//DIGITS
		public RuleCall getMinLengthDIGITSTerminalRuleCall_4_1_1_0() { return cMinLengthDIGITSTerminalRuleCall_4_1_1_0; }
		
		//('maxLength' maxLength=DIGITS)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_4_2_0() { return cMaxLengthKeyword_4_2_0; }
		
		//maxLength=DIGITS
		public Assignment getMaxLengthAssignment_4_2_1() { return cMaxLengthAssignment_4_2_1; }
		
		//DIGITS
		public RuleCall getMaxLengthDIGITSTerminalRuleCall_4_2_1_0() { return cMaxLengthDIGITSTerminalRuleCall_4_2_1_0; }
		
		//('pattern' pattern=LiteralPattern)?
		public Group getGroup_4_3() { return cGroup_4_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_4_3_0() { return cPatternKeyword_4_3_0; }
		
		//pattern=LiteralPattern
		public Assignment getPatternAssignment_4_3_1() { return cPatternAssignment_4_3_1; }
		
		//LiteralPattern
		public RuleCall getPatternLiteralPatternParserRuleCall_4_3_1_0() { return cPatternLiteralPatternParserRuleCall_4_3_1_0; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_5() { return cRestrictedRangeKeyword_5; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_6_0() { return cRestrictedRangeDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class NumericScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.NumericScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cNumericScalarRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cUnorderedGroup_4.eContents().get(0);
		private final Keyword cMinInclusiveKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Assignment cMinInclusiveAssignment_4_0_1 = (Assignment)cGroup_4_0.eContents().get(1);
		private final RuleCall cMinInclusiveLiteralNumberParserRuleCall_4_0_1_0 = (RuleCall)cMinInclusiveAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMaxInclusiveKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMaxInclusiveAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0 = (RuleCall)cMaxInclusiveAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMinExclusiveKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMinExclusiveAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMinExclusiveLiteralNumberParserRuleCall_4_2_1_0 = (RuleCall)cMinExclusiveAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_3 = (Group)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cMaxExclusiveKeyword_4_3_0 = (Keyword)cGroup_4_3.eContents().get(0);
		private final Assignment cMaxExclusiveAssignment_4_3_1 = (Assignment)cGroup_4_3.eContents().get(1);
		private final RuleCall cMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0 = (RuleCall)cMaxExclusiveAssignment_4_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//NumericScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'numericScalarRestriction' name=ID
		//	'{' (('minInclusive' minInclusive=LiteralNumber)? & ('maxInclusive' maxInclusive=LiteralNumber)? & ('minExclusive'
		//	minExclusive=LiteralNumber)? & ('maxExclusive' maxExclusive=LiteralNumber)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'numericScalarRestriction' name=ID '{' (('minInclusive'
		//minInclusive=LiteralNumber)? & ('maxInclusive' maxInclusive=LiteralNumber)? & ('minExclusive'
		//minExclusive=LiteralNumber)? & ('maxExclusive' maxExclusive=LiteralNumber)?) 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'numericScalarRestriction'
		public Keyword getNumericScalarRestrictionKeyword_1() { return cNumericScalarRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//('minInclusive' minInclusive=LiteralNumber)? & ('maxInclusive' maxInclusive=LiteralNumber)? & ('minExclusive'
		//minExclusive=LiteralNumber)? & ('maxExclusive' maxExclusive=LiteralNumber)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('minInclusive' minInclusive=LiteralNumber)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'minInclusive'
		public Keyword getMinInclusiveKeyword_4_0_0() { return cMinInclusiveKeyword_4_0_0; }
		
		//minInclusive=LiteralNumber
		public Assignment getMinInclusiveAssignment_4_0_1() { return cMinInclusiveAssignment_4_0_1; }
		
		//LiteralNumber
		public RuleCall getMinInclusiveLiteralNumberParserRuleCall_4_0_1_0() { return cMinInclusiveLiteralNumberParserRuleCall_4_0_1_0; }
		
		//('maxInclusive' maxInclusive=LiteralNumber)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'maxInclusive'
		public Keyword getMaxInclusiveKeyword_4_1_0() { return cMaxInclusiveKeyword_4_1_0; }
		
		//maxInclusive=LiteralNumber
		public Assignment getMaxInclusiveAssignment_4_1_1() { return cMaxInclusiveAssignment_4_1_1; }
		
		//LiteralNumber
		public RuleCall getMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0() { return cMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0; }
		
		//('minExclusive' minExclusive=LiteralNumber)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'minExclusive'
		public Keyword getMinExclusiveKeyword_4_2_0() { return cMinExclusiveKeyword_4_2_0; }
		
		//minExclusive=LiteralNumber
		public Assignment getMinExclusiveAssignment_4_2_1() { return cMinExclusiveAssignment_4_2_1; }
		
		//LiteralNumber
		public RuleCall getMinExclusiveLiteralNumberParserRuleCall_4_2_1_0() { return cMinExclusiveLiteralNumberParserRuleCall_4_2_1_0; }
		
		//('maxExclusive' maxExclusive=LiteralNumber)?
		public Group getGroup_4_3() { return cGroup_4_3; }
		
		//'maxExclusive'
		public Keyword getMaxExclusiveKeyword_4_3_0() { return cMaxExclusiveKeyword_4_3_0; }
		
		//maxExclusive=LiteralNumber
		public Assignment getMaxExclusiveAssignment_4_3_1() { return cMaxExclusiveAssignment_4_3_1; }
		
		//LiteralNumber
		public RuleCall getMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0() { return cMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_5() { return cRestrictedRangeKeyword_5; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_6_0() { return cRestrictedRangeDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class PlainLiteralScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.PlainLiteralScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cPlainLiteralScalarRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cUnorderedGroup_4.eContents().get(0);
		private final Keyword cLengthKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Assignment cLengthAssignment_4_0_1 = (Assignment)cGroup_4_0.eContents().get(1);
		private final RuleCall cLengthDIGITSTerminalRuleCall_4_0_1_0 = (RuleCall)cLengthAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMinLengthKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMinLengthDIGITSTerminalRuleCall_4_1_1_0 = (RuleCall)cMinLengthAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMaxLengthKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMaxLengthDIGITSTerminalRuleCall_4_2_1_0 = (RuleCall)cMaxLengthAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_3 = (Group)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cPatternKeyword_4_3_0 = (Keyword)cGroup_4_3.eContents().get(0);
		private final Assignment cPatternAssignment_4_3_1 = (Assignment)cGroup_4_3.eContents().get(1);
		private final RuleCall cPatternLiteralPatternParserRuleCall_4_3_1_0 = (RuleCall)cPatternAssignment_4_3_1.eContents().get(0);
		private final Group cGroup_4_4 = (Group)cUnorderedGroup_4.eContents().get(4);
		private final Keyword cLangRangeKeyword_4_4_0 = (Keyword)cGroup_4_4.eContents().get(0);
		private final Assignment cLangRangeAssignment_4_4_1 = (Assignment)cGroup_4_4.eContents().get(1);
		private final RuleCall cLangRangeLiteralLanguageTagParserRuleCall_4_4_1_0 = (RuleCall)cLangRangeAssignment_4_4_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//PlainLiteralScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'plainLiteralScalarRestriction' name=ID
		//	'{' (('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
		//	pattern=LiteralPattern)? & ('langRange' langRange=LiteralLanguageTag)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'plainLiteralScalarRestriction' name=ID '{' (('length' length=DIGITS)? &
		//('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern' pattern=LiteralPattern)? & ('langRange'
		//langRange=LiteralLanguageTag)?) 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'plainLiteralScalarRestriction'
		public Keyword getPlainLiteralScalarRestrictionKeyword_1() { return cPlainLiteralScalarRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
		//pattern=LiteralPattern)? & ('langRange' langRange=LiteralLanguageTag)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('length' length=DIGITS)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'length'
		public Keyword getLengthKeyword_4_0_0() { return cLengthKeyword_4_0_0; }
		
		//length=DIGITS
		public Assignment getLengthAssignment_4_0_1() { return cLengthAssignment_4_0_1; }
		
		//DIGITS
		public RuleCall getLengthDIGITSTerminalRuleCall_4_0_1_0() { return cLengthDIGITSTerminalRuleCall_4_0_1_0; }
		
		//('minLength' minLength=DIGITS)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_4_1_0() { return cMinLengthKeyword_4_1_0; }
		
		//minLength=DIGITS
		public Assignment getMinLengthAssignment_4_1_1() { return cMinLengthAssignment_4_1_1; }
		
		//DIGITS
		public RuleCall getMinLengthDIGITSTerminalRuleCall_4_1_1_0() { return cMinLengthDIGITSTerminalRuleCall_4_1_1_0; }
		
		//('maxLength' maxLength=DIGITS)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_4_2_0() { return cMaxLengthKeyword_4_2_0; }
		
		//maxLength=DIGITS
		public Assignment getMaxLengthAssignment_4_2_1() { return cMaxLengthAssignment_4_2_1; }
		
		//DIGITS
		public RuleCall getMaxLengthDIGITSTerminalRuleCall_4_2_1_0() { return cMaxLengthDIGITSTerminalRuleCall_4_2_1_0; }
		
		//('pattern' pattern=LiteralPattern)?
		public Group getGroup_4_3() { return cGroup_4_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_4_3_0() { return cPatternKeyword_4_3_0; }
		
		//pattern=LiteralPattern
		public Assignment getPatternAssignment_4_3_1() { return cPatternAssignment_4_3_1; }
		
		//LiteralPattern
		public RuleCall getPatternLiteralPatternParserRuleCall_4_3_1_0() { return cPatternLiteralPatternParserRuleCall_4_3_1_0; }
		
		//('langRange' langRange=LiteralLanguageTag)?
		public Group getGroup_4_4() { return cGroup_4_4; }
		
		//'langRange'
		public Keyword getLangRangeKeyword_4_4_0() { return cLangRangeKeyword_4_4_0; }
		
		//langRange=LiteralLanguageTag
		public Assignment getLangRangeAssignment_4_4_1() { return cLangRangeAssignment_4_4_1; }
		
		//LiteralLanguageTag
		public RuleCall getLangRangeLiteralLanguageTagParserRuleCall_4_4_1_0() { return cLangRangeLiteralLanguageTagParserRuleCall_4_4_1_0; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_5() { return cRestrictedRangeKeyword_5; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_6_0() { return cRestrictedRangeDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class ScalarOneOfRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarOneOfRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cScalarOneOfRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cRestrictedRangeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ScalarOneOfRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'scalarOneOfRestriction' name=ID
		//	'{'
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'scalarOneOfRestriction' name=ID '{' 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'scalarOneOfRestriction'
		public Keyword getScalarOneOfRestrictionKeyword_1() { return cScalarOneOfRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_4() { return cRestrictedRangeKeyword_4; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_5() { return cRestrictedRangeAssignment_5; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_5_0() { return cRestrictedRangeDataRangeCrossReference_5_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class ScalarOneOfLiteralAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarOneOfLiteralAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cOneOfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cAxiomAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cAxiomScalarOneOfRestrictionCrossReference_2_0 = (CrossReference)cAxiomAssignment_2.eContents().get(0);
		private final RuleCall cAxiomScalarOneOfRestrictionReferenceParserRuleCall_2_0_1 = (RuleCall)cAxiomScalarOneOfRestrictionCrossReference_2_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cValueAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cValueLiteralValueParserRuleCall_4_0 = (RuleCall)cValueAssignment_4.eContents().get(0);
		
		//ScalarOneOfLiteralAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'oneOf'
		//	axiom=[ScalarOneOfRestriction|Reference]
		//	'=' value=LiteralValue;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'oneOf' axiom=[ScalarOneOfRestriction|Reference] '=' value=LiteralValue
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'oneOf'
		public Keyword getOneOfKeyword_1() { return cOneOfKeyword_1; }
		
		//axiom=[ScalarOneOfRestriction|Reference]
		public Assignment getAxiomAssignment_2() { return cAxiomAssignment_2; }
		
		//[ScalarOneOfRestriction|Reference]
		public CrossReference getAxiomScalarOneOfRestrictionCrossReference_2_0() { return cAxiomScalarOneOfRestrictionCrossReference_2_0; }
		
		//Reference
		public RuleCall getAxiomScalarOneOfRestrictionReferenceParserRuleCall_2_0_1() { return cAxiomScalarOneOfRestrictionReferenceParserRuleCall_2_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }
		
		//value=LiteralValue
		public Assignment getValueAssignment_4() { return cValueAssignment_4; }
		
		//LiteralValue
		public RuleCall getValueLiteralValueParserRuleCall_4_0() { return cValueLiteralValueParserRuleCall_4_0; }
	}
	public class StringScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.StringScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cStringScalarRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cUnorderedGroup_4.eContents().get(0);
		private final Keyword cLengthKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Assignment cLengthAssignment_4_0_1 = (Assignment)cGroup_4_0.eContents().get(1);
		private final RuleCall cLengthDIGITSTerminalRuleCall_4_0_1_0 = (RuleCall)cLengthAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMinLengthKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMinLengthDIGITSTerminalRuleCall_4_1_1_0 = (RuleCall)cMinLengthAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMaxLengthKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMaxLengthDIGITSTerminalRuleCall_4_2_1_0 = (RuleCall)cMaxLengthAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_3 = (Group)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cPatternKeyword_4_3_0 = (Keyword)cGroup_4_3.eContents().get(0);
		private final Assignment cPatternAssignment_4_3_1 = (Assignment)cGroup_4_3.eContents().get(1);
		private final RuleCall cPatternLiteralPatternParserRuleCall_4_3_1_0 = (RuleCall)cPatternAssignment_4_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//StringScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'stringScalarRestriction' name=ID
		//	'{' (('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
		//	pattern=LiteralPattern)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'stringScalarRestriction' name=ID '{' (('length' length=DIGITS)? & ('minLength'
		//minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern' pattern=LiteralPattern)?) 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'stringScalarRestriction'
		public Keyword getStringScalarRestrictionKeyword_1() { return cStringScalarRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
		//pattern=LiteralPattern)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('length' length=DIGITS)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'length'
		public Keyword getLengthKeyword_4_0_0() { return cLengthKeyword_4_0_0; }
		
		//length=DIGITS
		public Assignment getLengthAssignment_4_0_1() { return cLengthAssignment_4_0_1; }
		
		//DIGITS
		public RuleCall getLengthDIGITSTerminalRuleCall_4_0_1_0() { return cLengthDIGITSTerminalRuleCall_4_0_1_0; }
		
		//('minLength' minLength=DIGITS)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_4_1_0() { return cMinLengthKeyword_4_1_0; }
		
		//minLength=DIGITS
		public Assignment getMinLengthAssignment_4_1_1() { return cMinLengthAssignment_4_1_1; }
		
		//DIGITS
		public RuleCall getMinLengthDIGITSTerminalRuleCall_4_1_1_0() { return cMinLengthDIGITSTerminalRuleCall_4_1_1_0; }
		
		//('maxLength' maxLength=DIGITS)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_4_2_0() { return cMaxLengthKeyword_4_2_0; }
		
		//maxLength=DIGITS
		public Assignment getMaxLengthAssignment_4_2_1() { return cMaxLengthAssignment_4_2_1; }
		
		//DIGITS
		public RuleCall getMaxLengthDIGITSTerminalRuleCall_4_2_1_0() { return cMaxLengthDIGITSTerminalRuleCall_4_2_1_0; }
		
		//('pattern' pattern=LiteralPattern)?
		public Group getGroup_4_3() { return cGroup_4_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_4_3_0() { return cPatternKeyword_4_3_0; }
		
		//pattern=LiteralPattern
		public Assignment getPatternAssignment_4_3_1() { return cPatternAssignment_4_3_1; }
		
		//LiteralPattern
		public RuleCall getPatternLiteralPatternParserRuleCall_4_3_1_0() { return cPatternLiteralPatternParserRuleCall_4_3_1_0; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_5() { return cRestrictedRangeKeyword_5; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_6_0() { return cRestrictedRangeDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class SynonymScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SynonymScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cSynonymScalarRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cRestrictedRangeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//SynonymScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'synonymScalarRestriction' name=ID
		//	'{'
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'synonymScalarRestriction' name=ID '{' 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'synonymScalarRestriction'
		public Keyword getSynonymScalarRestrictionKeyword_1() { return cSynonymScalarRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_4() { return cRestrictedRangeKeyword_4; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_5() { return cRestrictedRangeAssignment_5; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_5_0() { return cRestrictedRangeDataRangeCrossReference_5_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class TimeScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TimeScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cTimeScalarRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cUnorderedGroup_4.eContents().get(0);
		private final Keyword cMinInclusiveKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Assignment cMinInclusiveAssignment_4_0_1 = (Assignment)cGroup_4_0.eContents().get(1);
		private final RuleCall cMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0 = (RuleCall)cMinInclusiveAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMaxInclusiveKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMaxInclusiveAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0 = (RuleCall)cMaxInclusiveAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMinExclusiveKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMinExclusiveAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0 = (RuleCall)cMinExclusiveAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_3 = (Group)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cMaxExclusiveKeyword_4_3_0 = (Keyword)cGroup_4_3.eContents().get(0);
		private final Assignment cMaxExclusiveAssignment_4_3_1 = (Assignment)cGroup_4_3.eContents().get(1);
		private final RuleCall cMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0 = (RuleCall)cMaxExclusiveAssignment_4_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//TimeScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'timeScalarRestriction' name=ID
		//	'{' (('minInclusive' minInclusive=LiteralDateTime)? & ('maxInclusive' maxInclusive=LiteralDateTime)? & ('minExclusive'
		//	minExclusive=LiteralDateTime)? & ('maxExclusive' maxExclusive=LiteralDateTime)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'timeScalarRestriction' name=ID '{' (('minInclusive'
		//minInclusive=LiteralDateTime)? & ('maxInclusive' maxInclusive=LiteralDateTime)? & ('minExclusive'
		//minExclusive=LiteralDateTime)? & ('maxExclusive' maxExclusive=LiteralDateTime)?) 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'timeScalarRestriction'
		public Keyword getTimeScalarRestrictionKeyword_1() { return cTimeScalarRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//('minInclusive' minInclusive=LiteralDateTime)? & ('maxInclusive' maxInclusive=LiteralDateTime)? & ('minExclusive'
		//minExclusive=LiteralDateTime)? & ('maxExclusive' maxExclusive=LiteralDateTime)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('minInclusive' minInclusive=LiteralDateTime)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'minInclusive'
		public Keyword getMinInclusiveKeyword_4_0_0() { return cMinInclusiveKeyword_4_0_0; }
		
		//minInclusive=LiteralDateTime
		public Assignment getMinInclusiveAssignment_4_0_1() { return cMinInclusiveAssignment_4_0_1; }
		
		//LiteralDateTime
		public RuleCall getMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0() { return cMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0; }
		
		//('maxInclusive' maxInclusive=LiteralDateTime)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'maxInclusive'
		public Keyword getMaxInclusiveKeyword_4_1_0() { return cMaxInclusiveKeyword_4_1_0; }
		
		//maxInclusive=LiteralDateTime
		public Assignment getMaxInclusiveAssignment_4_1_1() { return cMaxInclusiveAssignment_4_1_1; }
		
		//LiteralDateTime
		public RuleCall getMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0() { return cMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0; }
		
		//('minExclusive' minExclusive=LiteralDateTime)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'minExclusive'
		public Keyword getMinExclusiveKeyword_4_2_0() { return cMinExclusiveKeyword_4_2_0; }
		
		//minExclusive=LiteralDateTime
		public Assignment getMinExclusiveAssignment_4_2_1() { return cMinExclusiveAssignment_4_2_1; }
		
		//LiteralDateTime
		public RuleCall getMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0() { return cMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0; }
		
		//('maxExclusive' maxExclusive=LiteralDateTime)?
		public Group getGroup_4_3() { return cGroup_4_3; }
		
		//'maxExclusive'
		public Keyword getMaxExclusiveKeyword_4_3_0() { return cMaxExclusiveKeyword_4_3_0; }
		
		//maxExclusive=LiteralDateTime
		public Assignment getMaxExclusiveAssignment_4_3_1() { return cMaxExclusiveAssignment_4_3_1; }
		
		//LiteralDateTime
		public RuleCall getMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0() { return cMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_5() { return cRestrictedRangeKeyword_5; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_6_0() { return cRestrictedRangeDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class TerminologyInstanceAssertionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyInstanceAssertion");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cConceptualEntitySingletonInstanceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReifiedRelationshipInstanceDomainParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cReifiedRelationshipInstanceRangeParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cUnreifiedRelationshipInstanceTupleParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//TerminologyInstanceAssertion:
		//	ConceptualEntitySingletonInstance | ReifiedRelationshipInstanceDomain | ReifiedRelationshipInstanceRange |
		//	UnreifiedRelationshipInstanceTuple;
		@Override public ParserRule getRule() { return rule; }
		
		//ConceptualEntitySingletonInstance | ReifiedRelationshipInstanceDomain | ReifiedRelationshipInstanceRange |
		//UnreifiedRelationshipInstanceTuple
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ConceptualEntitySingletonInstance
		public RuleCall getConceptualEntitySingletonInstanceParserRuleCall_0() { return cConceptualEntitySingletonInstanceParserRuleCall_0; }
		
		//ReifiedRelationshipInstanceDomain
		public RuleCall getReifiedRelationshipInstanceDomainParserRuleCall_1() { return cReifiedRelationshipInstanceDomainParserRuleCall_1; }
		
		//ReifiedRelationshipInstanceRange
		public RuleCall getReifiedRelationshipInstanceRangeParserRuleCall_2() { return cReifiedRelationshipInstanceRangeParserRuleCall_2; }
		
		//UnreifiedRelationshipInstanceTuple
		public RuleCall getUnreifiedRelationshipInstanceTupleParserRuleCall_3() { return cUnreifiedRelationshipInstanceTupleParserRuleCall_3; }
	}
	public class ConceptualEntitySingletonInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ConceptualEntitySingletonInstance");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cConceptInstanceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReifiedRelationshipInstanceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//ConceptualEntitySingletonInstance:
		//	ConceptInstance | ReifiedRelationshipInstance;
		@Override public ParserRule getRule() { return rule; }
		
		//ConceptInstance | ReifiedRelationshipInstance
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ConceptInstance
		public RuleCall getConceptInstanceParserRuleCall_0() { return cConceptInstanceParserRuleCall_0; }
		
		//ReifiedRelationshipInstance
		public RuleCall getReifiedRelationshipInstanceParserRuleCall_1() { return cReifiedRelationshipInstanceParserRuleCall_1; }
	}
	public class DescriptionBoxExtendsClosedWorldDefinitionsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxExtendsClosedWorldDefinitions");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cExtendsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cClosedWorldDefinitionsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cClosedWorldDefinitionsTerminologyBoxCrossReference_2_0 = (CrossReference)cClosedWorldDefinitionsAssignment_2.eContents().get(0);
		private final RuleCall cClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_2_0_1 = (RuleCall)cClosedWorldDefinitionsTerminologyBoxCrossReference_2_0.eContents().get(1);
		
		//DescriptionBoxExtendsClosedWorldDefinitions:
		//	annotations+=AnnotationPropertyValue*
		//	'extends' closedWorldDefinitions=[TerminologyBox|ExternalReference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'extends' closedWorldDefinitions=[TerminologyBox|ExternalReference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'extends'
		public Keyword getExtendsKeyword_1() { return cExtendsKeyword_1; }
		
		//closedWorldDefinitions=[TerminologyBox|ExternalReference]
		public Assignment getClosedWorldDefinitionsAssignment_2() { return cClosedWorldDefinitionsAssignment_2; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getClosedWorldDefinitionsTerminologyBoxCrossReference_2_0() { return cClosedWorldDefinitionsTerminologyBoxCrossReference_2_0; }
		
		//ExternalReference
		public RuleCall getClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_2_0_1() { return cClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_2_0_1; }
	}
	public class DescriptionBoxRefinementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxRefinement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cRefinesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRefinedDescriptionBoxAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRefinedDescriptionBoxDescriptionBoxCrossReference_2_0 = (CrossReference)cRefinedDescriptionBoxAssignment_2.eContents().get(0);
		private final RuleCall cRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_2_0_1 = (RuleCall)cRefinedDescriptionBoxDescriptionBoxCrossReference_2_0.eContents().get(1);
		
		//DescriptionBoxRefinement:
		//	annotations+=AnnotationPropertyValue*
		//	'refines' refinedDescriptionBox=[DescriptionBox|ExternalReference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'refines' refinedDescriptionBox=[DescriptionBox|ExternalReference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'refines'
		public Keyword getRefinesKeyword_1() { return cRefinesKeyword_1; }
		
		//refinedDescriptionBox=[DescriptionBox|ExternalReference]
		public Assignment getRefinedDescriptionBoxAssignment_2() { return cRefinedDescriptionBoxAssignment_2; }
		
		//[DescriptionBox|ExternalReference]
		public CrossReference getRefinedDescriptionBoxDescriptionBoxCrossReference_2_0() { return cRefinedDescriptionBoxDescriptionBoxCrossReference_2_0; }
		
		//ExternalReference
		public RuleCall getRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_2_0_1() { return cRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_2_0_1; }
	}
	public class SingletonInstanceScalarDataPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceScalarDataPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cSingletonInstanceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0 = (CrossReference)cSingletonInstanceAssignment_1.eContents().get(0);
		private final RuleCall cSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1 = (RuleCall)cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cScalarDataPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cScalarDataPropertyEntityScalarDataPropertyCrossReference_3_0 = (CrossReference)cScalarDataPropertyAssignment_3.eContents().get(0);
		private final RuleCall cScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1 = (RuleCall)cScalarDataPropertyEntityScalarDataPropertyCrossReference_3_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cScalarPropertyValueAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cScalarPropertyValueLiteralValueParserRuleCall_5_0 = (RuleCall)cScalarPropertyValueAssignment_5.eContents().get(0);
		
		//SingletonInstanceScalarDataPropertyValue:
		//	annotations+=AnnotationPropertyValue*
		//	singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		//	'.'
		//	scalarDataProperty=[EntityScalarDataProperty|Reference]
		//	'='
		//	scalarPropertyValue=LiteralValue;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* singletonInstance=[ConceptualEntitySingletonInstance|Reference] '.'
		//scalarDataProperty=[EntityScalarDataProperty|Reference] '=' scalarPropertyValue=LiteralValue
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getSingletonInstanceAssignment_1() { return cSingletonInstanceAssignment_1; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0() { return cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0; }
		
		//Reference
		public RuleCall getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1() { return cSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//scalarDataProperty=[EntityScalarDataProperty|Reference]
		public Assignment getScalarDataPropertyAssignment_3() { return cScalarDataPropertyAssignment_3; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getScalarDataPropertyEntityScalarDataPropertyCrossReference_3_0() { return cScalarDataPropertyEntityScalarDataPropertyCrossReference_3_0; }
		
		//Reference
		public RuleCall getScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1() { return cScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }
		
		//scalarPropertyValue=LiteralValue
		public Assignment getScalarPropertyValueAssignment_5() { return cScalarPropertyValueAssignment_5; }
		
		//LiteralValue
		public RuleCall getScalarPropertyValueLiteralValueParserRuleCall_5_0() { return cScalarPropertyValueLiteralValueParserRuleCall_5_0; }
	}
	public class SingletonInstanceStructuredDataPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceStructuredDataPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cSingletonInstanceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0 = (CrossReference)cSingletonInstanceAssignment_1.eContents().get(0);
		private final RuleCall cSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1 = (RuleCall)cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cStructuredDataPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cStructuredDataPropertyDataRelationshipToStructureCrossReference_3_0 = (CrossReference)cStructuredDataPropertyAssignment_3.eContents().get(0);
		private final RuleCall cStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_3_0_1 = (RuleCall)cStructuredDataPropertyDataRelationshipToStructureCrossReference_3_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Assignment cStructuredPropertyTuplesAssignment_6_0 = (Assignment)cAlternatives_6.eContents().get(0);
		private final RuleCall cStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0 = (RuleCall)cStructuredPropertyTuplesAssignment_6_0.eContents().get(0);
		private final Assignment cScalarDataPropertyValuesAssignment_6_1 = (Assignment)cAlternatives_6.eContents().get(1);
		private final RuleCall cScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0 = (RuleCall)cScalarDataPropertyValuesAssignment_6_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//SingletonInstanceStructuredDataPropertyValue:
		//	annotations+=AnnotationPropertyValue*
		//	singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		//	'.'
		//	structuredDataProperty=[DataRelationshipToStructure|Reference]
		//	'=' '{' (structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* singletonInstance=[ConceptualEntitySingletonInstance|Reference] '.'
		//structuredDataProperty=[DataRelationshipToStructure|Reference] '=' '{'
		//(structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getSingletonInstanceAssignment_1() { return cSingletonInstanceAssignment_1; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0() { return cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0; }
		
		//Reference
		public RuleCall getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1() { return cSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//structuredDataProperty=[DataRelationshipToStructure|Reference]
		public Assignment getStructuredDataPropertyAssignment_3() { return cStructuredDataPropertyAssignment_3; }
		
		//[DataRelationshipToStructure|Reference]
		public CrossReference getStructuredDataPropertyDataRelationshipToStructureCrossReference_3_0() { return cStructuredDataPropertyDataRelationshipToStructureCrossReference_3_0; }
		
		//Reference
		public RuleCall getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_3_0_1() { return cStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_3_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//(structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
		public Alternatives getAlternatives_6() { return cAlternatives_6; }
		
		//structuredPropertyTuples+=StructuredDataPropertyTuple
		public Assignment getStructuredPropertyTuplesAssignment_6_0() { return cStructuredPropertyTuplesAssignment_6_0; }
		
		//StructuredDataPropertyTuple
		public RuleCall getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0() { return cStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0; }
		
		//scalarDataPropertyValues+=ScalarDataPropertyValue
		public Assignment getScalarDataPropertyValuesAssignment_6_1() { return cScalarDataPropertyValuesAssignment_6_1; }
		
		//ScalarDataPropertyValue
		public RuleCall getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0() { return cScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class StructuredDataPropertyTupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cStructuredDataPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cStructuredDataPropertyDataRelationshipToStructureCrossReference_1_0 = (CrossReference)cStructuredDataPropertyAssignment_1.eContents().get(0);
		private final RuleCall cStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_1_0_1 = (RuleCall)cStructuredDataPropertyDataRelationshipToStructureCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cStructuredPropertyTuplesAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0 = (RuleCall)cStructuredPropertyTuplesAssignment_4_0.eContents().get(0);
		private final Assignment cScalarDataPropertyValuesAssignment_4_1 = (Assignment)cAlternatives_4.eContents().get(1);
		private final RuleCall cScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0 = (RuleCall)cScalarDataPropertyValuesAssignment_4_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//StructuredDataPropertyTuple:
		//	annotations+=AnnotationPropertyValue*
		//	structuredDataProperty=[DataRelationshipToStructure|Reference]
		//	'=' '{' (structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* structuredDataProperty=[DataRelationshipToStructure|Reference] '=' '{'
		//(structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//structuredDataProperty=[DataRelationshipToStructure|Reference]
		public Assignment getStructuredDataPropertyAssignment_1() { return cStructuredDataPropertyAssignment_1; }
		
		//[DataRelationshipToStructure|Reference]
		public CrossReference getStructuredDataPropertyDataRelationshipToStructureCrossReference_1_0() { return cStructuredDataPropertyDataRelationshipToStructureCrossReference_1_0; }
		
		//Reference
		public RuleCall getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_1_0_1() { return cStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//(structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
		public Alternatives getAlternatives_4() { return cAlternatives_4; }
		
		//structuredPropertyTuples+=StructuredDataPropertyTuple
		public Assignment getStructuredPropertyTuplesAssignment_4_0() { return cStructuredPropertyTuplesAssignment_4_0; }
		
		//StructuredDataPropertyTuple
		public RuleCall getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0() { return cStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0; }
		
		//scalarDataPropertyValues+=ScalarDataPropertyValue
		public Assignment getScalarDataPropertyValuesAssignment_4_1() { return cScalarDataPropertyValuesAssignment_4_1; }
		
		//ScalarDataPropertyValue
		public RuleCall getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0() { return cScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class ScalarDataPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cScalarDataPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cScalarDataPropertyDataRelationshipToScalarCrossReference_1_0 = (CrossReference)cScalarDataPropertyAssignment_1.eContents().get(0);
		private final RuleCall cScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_1_0_1 = (RuleCall)cScalarDataPropertyDataRelationshipToScalarCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cScalarPropertyValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cScalarPropertyValueLiteralValueParserRuleCall_3_0 = (RuleCall)cScalarPropertyValueAssignment_3.eContents().get(0);
		
		//ScalarDataPropertyValue:
		//	annotations+=AnnotationPropertyValue*
		//	scalarDataProperty=[DataRelationshipToScalar|Reference]
		//	'='
		//	scalarPropertyValue=LiteralValue;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* scalarDataProperty=[DataRelationshipToScalar|Reference] '='
		//scalarPropertyValue=LiteralValue
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//scalarDataProperty=[DataRelationshipToScalar|Reference]
		public Assignment getScalarDataPropertyAssignment_1() { return cScalarDataPropertyAssignment_1; }
		
		//[DataRelationshipToScalar|Reference]
		public CrossReference getScalarDataPropertyDataRelationshipToScalarCrossReference_1_0() { return cScalarDataPropertyDataRelationshipToScalarCrossReference_1_0; }
		
		//Reference
		public RuleCall getScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_1_0_1() { return cScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//scalarPropertyValue=LiteralValue
		public Assignment getScalarPropertyValueAssignment_3() { return cScalarPropertyValueAssignment_3; }
		
		//LiteralValue
		public RuleCall getScalarPropertyValueLiteralValueParserRuleCall_3_0() { return cScalarPropertyValueLiteralValueParserRuleCall_3_0; }
	}
	public class ConceptInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ConceptInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cConceptInstanceKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cIsAKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cSingletonConceptClassifierAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cSingletonConceptClassifierConceptCrossReference_5_0 = (CrossReference)cSingletonConceptClassifierAssignment_5.eContents().get(0);
		private final RuleCall cSingletonConceptClassifierConceptReferenceParserRuleCall_5_0_1 = (RuleCall)cSingletonConceptClassifierConceptCrossReference_5_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ConceptInstance:
		//	annotations+=AnnotationPropertyValue*
		//	'conceptInstance' '(' name=ID 'is-a' singletonConceptClassifier=[Concept|Reference] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'conceptInstance' '(' name=ID 'is-a'
		//singletonConceptClassifier=[Concept|Reference] ')'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'conceptInstance'
		public Keyword getConceptInstanceKeyword_1() { return cConceptInstanceKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }
		
		//'is-a'
		public Keyword getIsAKeyword_4() { return cIsAKeyword_4; }
		
		//singletonConceptClassifier=[Concept|Reference]
		public Assignment getSingletonConceptClassifierAssignment_5() { return cSingletonConceptClassifierAssignment_5; }
		
		//[Concept|Reference]
		public CrossReference getSingletonConceptClassifierConceptCrossReference_5_0() { return cSingletonConceptClassifierConceptCrossReference_5_0; }
		
		//Reference
		public RuleCall getSingletonConceptClassifierConceptReferenceParserRuleCall_5_0_1() { return cSingletonConceptClassifierConceptReferenceParserRuleCall_5_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }
	}
	public class ReifiedRelationshipInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cReifiedRelationshipInstanceKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cIsAKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cSingletonReifiedRelationshipClassifierAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_5_0 = (CrossReference)cSingletonReifiedRelationshipClassifierAssignment_5.eContents().get(0);
		private final RuleCall cSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_5_0_1 = (RuleCall)cSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_5_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ReifiedRelationshipInstance:
		//	annotations+=AnnotationPropertyValue*
		//	'reifiedRelationshipInstance' '(' name=ID 'is-a'
		//	singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'reifiedRelationshipInstance' '(' name=ID 'is-a'
		//singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference] ')'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'reifiedRelationshipInstance'
		public Keyword getReifiedRelationshipInstanceKeyword_1() { return cReifiedRelationshipInstanceKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }
		
		//'is-a'
		public Keyword getIsAKeyword_4() { return cIsAKeyword_4; }
		
		//singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference]
		public Assignment getSingletonReifiedRelationshipClassifierAssignment_5() { return cSingletonReifiedRelationshipClassifierAssignment_5; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_5_0() { return cSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_5_0; }
		
		//Reference
		public RuleCall getSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_5_0_1() { return cSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_5_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }
	}
	public class ReifiedRelationshipInstanceDomainElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceDomain");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cDomainKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cReifiedRelationshipInstanceAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0 = (CrossReference)cReifiedRelationshipInstanceAssignment_3.eContents().get(0);
		private final RuleCall cReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1 = (RuleCall)cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDomainAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cDomainConceptualEntitySingletonInstanceCrossReference_6_0 = (CrossReference)cDomainAssignment_6.eContents().get(0);
		private final RuleCall cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1 = (RuleCall)cDomainConceptualEntitySingletonInstanceCrossReference_6_0.eContents().get(1);
		
		//ReifiedRelationshipInstanceDomain:
		//	annotations+=AnnotationPropertyValue*
		//	'domain'
		//	'(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] ')'
		//	'=' domain=[ConceptualEntitySingletonInstance|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'domain' '(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference]
		//')' '=' domain=[ConceptualEntitySingletonInstance|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'domain'
		public Keyword getDomainKeyword_1() { return cDomainKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference]
		public Assignment getReifiedRelationshipInstanceAssignment_3() { return cReifiedRelationshipInstanceAssignment_3; }
		
		//[ReifiedRelationshipInstance|Reference]
		public CrossReference getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0() { return cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0; }
		
		//Reference
		public RuleCall getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1() { return cReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//'='
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }
		
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getDomainAssignment_6() { return cDomainAssignment_6; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getDomainConceptualEntitySingletonInstanceCrossReference_6_0() { return cDomainConceptualEntitySingletonInstanceCrossReference_6_0; }
		
		//Reference
		public RuleCall getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1() { return cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1; }
	}
	public class ReifiedRelationshipInstanceRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceRange");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cRangeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cReifiedRelationshipInstanceAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0 = (CrossReference)cReifiedRelationshipInstanceAssignment_3.eContents().get(0);
		private final RuleCall cReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1 = (RuleCall)cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRangeConceptualEntitySingletonInstanceCrossReference_6_0 = (CrossReference)cRangeAssignment_6.eContents().get(0);
		private final RuleCall cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1 = (RuleCall)cRangeConceptualEntitySingletonInstanceCrossReference_6_0.eContents().get(1);
		
		//ReifiedRelationshipInstanceRange:
		//	annotations+=AnnotationPropertyValue*
		//	'range'
		//	'(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] ')'
		//	'=' range=[ConceptualEntitySingletonInstance|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'range' '(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference]
		//')' '=' range=[ConceptualEntitySingletonInstance|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'range'
		public Keyword getRangeKeyword_1() { return cRangeKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference]
		public Assignment getReifiedRelationshipInstanceAssignment_3() { return cReifiedRelationshipInstanceAssignment_3; }
		
		//[ReifiedRelationshipInstance|Reference]
		public CrossReference getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0() { return cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0; }
		
		//Reference
		public RuleCall getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1() { return cReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//'='
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }
		
		//range=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getRangeAssignment_6() { return cRangeAssignment_6; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getRangeConceptualEntitySingletonInstanceCrossReference_6_0() { return cRangeConceptualEntitySingletonInstanceCrossReference_6_0; }
		
		//Reference
		public RuleCall getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1() { return cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1; }
	}
	public class UnreifiedRelationshipInstanceTupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UnreifiedRelationshipInstanceTuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cTupleKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cUnreifiedRelationshipKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cUnreifiedRelationshipAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0 = (CrossReference)cUnreifiedRelationshipAssignment_4.eContents().get(0);
		private final RuleCall cUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_4_0_1 = (RuleCall)cUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0.eContents().get(1);
		private final Keyword cDomainKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDomainAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cDomainConceptualEntitySingletonInstanceCrossReference_6_0 = (CrossReference)cDomainAssignment_6.eContents().get(0);
		private final RuleCall cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1 = (RuleCall)cDomainConceptualEntitySingletonInstanceCrossReference_6_0.eContents().get(1);
		private final Keyword cRangeKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cRangeAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final CrossReference cRangeConceptualEntitySingletonInstanceCrossReference_8_0 = (CrossReference)cRangeAssignment_8.eContents().get(0);
		private final RuleCall cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_8_0_1 = (RuleCall)cRangeConceptualEntitySingletonInstanceCrossReference_8_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//UnreifiedRelationshipInstanceTuple:
		//	annotations+=AnnotationPropertyValue*
		//	'tuple'
		//	'{'
		//	'unreifiedRelationship' unreifiedRelationship=[UnreifiedRelationship|Reference]
		//	'domain' domain=[ConceptualEntitySingletonInstance|Reference]
		//	'range' range=[ConceptualEntitySingletonInstance|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'tuple' '{' 'unreifiedRelationship'
		//unreifiedRelationship=[UnreifiedRelationship|Reference] 'domain' domain=[ConceptualEntitySingletonInstance|Reference]
		//'range' range=[ConceptualEntitySingletonInstance|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'tuple'
		public Keyword getTupleKeyword_1() { return cTupleKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//'unreifiedRelationship'
		public Keyword getUnreifiedRelationshipKeyword_3() { return cUnreifiedRelationshipKeyword_3; }
		
		//unreifiedRelationship=[UnreifiedRelationship|Reference]
		public Assignment getUnreifiedRelationshipAssignment_4() { return cUnreifiedRelationshipAssignment_4; }
		
		//[UnreifiedRelationship|Reference]
		public CrossReference getUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0() { return cUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0; }
		
		//Reference
		public RuleCall getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_4_0_1() { return cUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_4_0_1; }
		
		//'domain'
		public Keyword getDomainKeyword_5() { return cDomainKeyword_5; }
		
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getDomainAssignment_6() { return cDomainAssignment_6; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getDomainConceptualEntitySingletonInstanceCrossReference_6_0() { return cDomainConceptualEntitySingletonInstanceCrossReference_6_0; }
		
		//Reference
		public RuleCall getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1() { return cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1; }
		
		//'range'
		public Keyword getRangeKeyword_7() { return cRangeKeyword_7; }
		
		//range=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getRangeAssignment_8() { return cRangeAssignment_8; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getRangeConceptualEntitySingletonInstanceCrossReference_8_0() { return cRangeConceptualEntitySingletonInstanceCrossReference_8_0; }
		
		//Reference
		public RuleCall getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_8_0_1() { return cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_8_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}
	public class ReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Reference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIRITerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cQNAMEParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		////----------------------------
		//Reference:
		//	IRI | QNAME;
		@Override public ParserRule getRule() { return rule; }
		
		//IRI | QNAME
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//IRI
		public RuleCall getIRITerminalRuleCall_0() { return cIRITerminalRuleCall_0; }
		
		//QNAME
		public RuleCall getQNAMEParserRuleCall_1() { return cQNAMEParserRuleCall_1; }
	}
	public class ExternalReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ExternalReference");
		private final RuleCall cIRITerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ExternalReference:
		//	IRI;
		@Override public ParserRule getRule() { return rule; }
		
		//IRI
		public RuleCall getIRITerminalRuleCall() { return cIRITerminalRuleCall; }
	}
	public class QNAMEElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.QNAME");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cABBREV_IRITerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cValidIDParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//QNAME:
		//	ABBREV_IRI | ValidID;
		@Override public ParserRule getRule() { return rule; }
		
		//ABBREV_IRI | ValidID
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ABBREV_IRI
		public RuleCall getABBREV_IRITerminalRuleCall_0() { return cABBREV_IRITerminalRuleCall_0; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_1() { return cValidIDParserRuleCall_1; }
	}
	public class ValidIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ValidID");
		private final RuleCall cIDTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ValidID:
		//	ID;
		@Override public ParserRule getRule() { return rule; }
		
		//ID
		public RuleCall getIDTerminalRuleCall() { return cIDTerminalRuleCall; }
	}
	public class LiteralPatternElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralPattern");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralPatternAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		////----------------------------
		//LiteralPattern:
		//	{LiteralPattern} value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralPattern} value=STRING
		public Group getGroup() { return cGroup; }
		
		//{LiteralPattern}
		public Action getLiteralPatternAction_0() { return cLiteralPatternAction_0; }
		
		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}
	public class LiteralValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralDateTimeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLiteralLanguageTagParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLiteralStringParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLiteralUUIDParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cLiteralURIParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cLiteralNumberParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//LiteralValue:
		//	LiteralDateTime | LiteralLanguageTag | LiteralString | LiteralUUID | LiteralURI | LiteralNumber;
		@Override public ParserRule getRule() { return rule; }
		
		//LiteralDateTime | LiteralLanguageTag | LiteralString | LiteralUUID | LiteralURI | LiteralNumber
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//LiteralDateTime
		public RuleCall getLiteralDateTimeParserRuleCall_0() { return cLiteralDateTimeParserRuleCall_0; }
		
		//LiteralLanguageTag
		public RuleCall getLiteralLanguageTagParserRuleCall_1() { return cLiteralLanguageTagParserRuleCall_1; }
		
		//LiteralString
		public RuleCall getLiteralStringParserRuleCall_2() { return cLiteralStringParserRuleCall_2; }
		
		//LiteralUUID
		public RuleCall getLiteralUUIDParserRuleCall_3() { return cLiteralUUIDParserRuleCall_3; }
		
		//LiteralURI
		public RuleCall getLiteralURIParserRuleCall_4() { return cLiteralURIParserRuleCall_4; }
		
		//LiteralNumber
		public RuleCall getLiteralNumberParserRuleCall_5() { return cLiteralNumberParserRuleCall_5; }
	}
	public class LiteralDateTimeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralDateTimeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueDATE_TIMEParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//LiteralDateTime:
		//	{LiteralDateTime} value=DATE_TIME;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralDateTime} value=DATE_TIME
		public Group getGroup() { return cGroup; }
		
		//{LiteralDateTime}
		public Action getLiteralDateTimeAction_0() { return cLiteralDateTimeAction_0; }
		
		//value=DATE_TIME
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//DATE_TIME
		public RuleCall getValueDATE_TIMEParserRuleCall_1_0() { return cValueDATE_TIMEParserRuleCall_1_0; }
	}
	public class LiteralLanguageTagElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralLanguageTag");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralLanguageTagAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueLANG_TAGParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//LiteralLanguageTag:
		//	{LiteralLanguageTag} value=LANG_TAG;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralLanguageTag} value=LANG_TAG
		public Group getGroup() { return cGroup; }
		
		//{LiteralLanguageTag}
		public Action getLiteralLanguageTagAction_0() { return cLiteralLanguageTagAction_0; }
		
		//value=LANG_TAG
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//LANG_TAG
		public RuleCall getValueLANG_TAGParserRuleCall_1_0() { return cValueLANG_TAGParserRuleCall_1_0; }
	}
	public class LiteralStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralString");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralStringAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//LiteralString:
		//	{LiteralString} value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralString} value=STRING
		public Group getGroup() { return cGroup; }
		
		//{LiteralString}
		public Action getLiteralStringAction_0() { return cLiteralStringAction_0; }
		
		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}
	public class LiteralUUIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralUUID");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralUUIDAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueUUIDTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//LiteralUUID:
		//	{LiteralUUID} value=UUID;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralUUID} value=UUID
		public Group getGroup() { return cGroup; }
		
		//{LiteralUUID}
		public Action getLiteralUUIDAction_0() { return cLiteralUUIDAction_0; }
		
		//value=UUID
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//UUID
		public RuleCall getValueUUIDTerminalRuleCall_1_0() { return cValueUUIDTerminalRuleCall_1_0; }
	}
	public class LiteralURIElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralURI");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralURIAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueURIParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//LiteralURI:
		//	{LiteralURI} value=URI;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralURI} value=URI
		public Group getGroup() { return cGroup; }
		
		//{LiteralURI}
		public Action getLiteralURIAction_0() { return cLiteralURIAction_0; }
		
		//value=URI
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//URI
		public RuleCall getValueURIParserRuleCall_1_0() { return cValueURIParserRuleCall_1_0; }
	}
	public class LiteralNumberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralNumberAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cValueAlternatives_1_0 = (Alternatives)cValueAssignment_1.eContents().get(0);
		private final RuleCall cValueREAL_VALUETerminalRuleCall_1_0_0 = (RuleCall)cValueAlternatives_1_0.eContents().get(0);
		private final RuleCall cValueRATIONALTerminalRuleCall_1_0_1 = (RuleCall)cValueAlternatives_1_0.eContents().get(1);
		private final RuleCall cValueFLOATTerminalRuleCall_1_0_2 = (RuleCall)cValueAlternatives_1_0.eContents().get(2);
		private final RuleCall cValueDECIMALTerminalRuleCall_1_0_3 = (RuleCall)cValueAlternatives_1_0.eContents().get(3);
		
		//LiteralNumber:
		//	{LiteralNumber} value=(REAL_VALUE | RATIONAL | FLOAT | DECIMAL);
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralNumber} value=(REAL_VALUE | RATIONAL | FLOAT | DECIMAL)
		public Group getGroup() { return cGroup; }
		
		//{LiteralNumber}
		public Action getLiteralNumberAction_0() { return cLiteralNumberAction_0; }
		
		//value=(REAL_VALUE | RATIONAL | FLOAT | DECIMAL)
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//(REAL_VALUE | RATIONAL | FLOAT | DECIMAL)
		public Alternatives getValueAlternatives_1_0() { return cValueAlternatives_1_0; }
		
		//REAL_VALUE
		public RuleCall getValueREAL_VALUETerminalRuleCall_1_0_0() { return cValueREAL_VALUETerminalRuleCall_1_0_0; }
		
		//RATIONAL
		public RuleCall getValueRATIONALTerminalRuleCall_1_0_1() { return cValueRATIONALTerminalRuleCall_1_0_1; }
		
		//FLOAT
		public RuleCall getValueFLOATTerminalRuleCall_1_0_2() { return cValueFLOATTerminalRuleCall_1_0_2; }
		
		//DECIMAL
		public RuleCall getValueDECIMALTerminalRuleCall_1_0_3() { return cValueDECIMALTerminalRuleCall_1_0_3; }
	}
	public class URIElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.URI");
		private final RuleCall cURI_VALUETerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//URI:
		//	URI_VALUE;
		@Override public ParserRule getRule() { return rule; }
		
		//URI_VALUE
		public RuleCall getURI_VALUETerminalRuleCall() { return cURI_VALUETerminalRuleCall; }
	}
	public class REALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.REAL");
		private final RuleCall cREAL_VALUETerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//REAL:
		//	REAL_VALUE;
		@Override public ParserRule getRule() { return rule; }
		
		//REAL_VALUE
		public RuleCall getREAL_VALUETerminalRuleCall() { return cREAL_VALUETerminalRuleCall; }
	}
	public class LANG_TAGElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LANG_TAG");
		private final RuleCall cLANGUAGE_TAGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//LANG_TAG:
		//	LANGUAGE_TAG;
		@Override public ParserRule getRule() { return rule; }
		
		//LANGUAGE_TAG
		public RuleCall getLANGUAGE_TAGTerminalRuleCall() { return cLANGUAGE_TAGTerminalRuleCall; }
	}
	public class DATE_TIMEElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DATE_TIME");
		private final RuleCall cDATETIMETerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//DATE_TIME:
		//	DATETIME;
		@Override public ParserRule getRule() { return rule; }
		
		//DATETIME
		public RuleCall getDATETIMETerminalRuleCall() { return cDATETIMETerminalRuleCall; }
	}
	
	public class TerminologyKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cOpenWorldDefinitionsEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cOpenWorldDefinitionsOpenKeyword_0_0 = (Keyword)cOpenWorldDefinitionsEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cClosedWorldDesignationsEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cClosedWorldDesignationsClosedKeyword_1_0 = (Keyword)cClosedWorldDesignationsEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum TerminologyKind:
		//	OpenWorldDefinitions='open' |
		//	ClosedWorldDesignations='closed';
		public EnumRule getRule() { return rule; }
		
		//OpenWorldDefinitions='open' | ClosedWorldDesignations='closed'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//OpenWorldDefinitions='open'
		public EnumLiteralDeclaration getOpenWorldDefinitionsEnumLiteralDeclaration_0() { return cOpenWorldDefinitionsEnumLiteralDeclaration_0; }
		
		//'open'
		public Keyword getOpenWorldDefinitionsOpenKeyword_0_0() { return cOpenWorldDefinitionsOpenKeyword_0_0; }
		
		//ClosedWorldDesignations='closed'
		public EnumLiteralDeclaration getClosedWorldDesignationsEnumLiteralDeclaration_1() { return cClosedWorldDesignationsEnumLiteralDeclaration_1; }
		
		//'closed'
		public Keyword getClosedWorldDesignationsClosedKeyword_1_0() { return cClosedWorldDesignationsClosedKeyword_1_0; }
	}
	public class DescriptionKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DescriptionKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cFinalEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cFinalFinalKeyword_0_0 = (Keyword)cFinalEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cPartialEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cPartialPartialKeyword_1_0 = (Keyword)cPartialEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum DescriptionKind:
		//	Final='final' |
		//	Partial='partial';
		public EnumRule getRule() { return rule; }
		
		//Final='final' | Partial='partial'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Final='final'
		public EnumLiteralDeclaration getFinalEnumLiteralDeclaration_0() { return cFinalEnumLiteralDeclaration_0; }
		
		//'final'
		public Keyword getFinalFinalKeyword_0_0() { return cFinalFinalKeyword_0_0; }
		
		//Partial='partial'
		public EnumLiteralDeclaration getPartialEnumLiteralDeclaration_1() { return cPartialEnumLiteralDeclaration_1; }
		
		//'partial'
		public Keyword getPartialPartialKeyword_1_0() { return cPartialPartialKeyword_1_0; }
	}
	
	private final ExtentElements pExtent;
	private final AnnotationPropertyElements pAnnotationProperty;
	private final AnnotationPropertyValueElements pAnnotationPropertyValue;
	private final ModuleElements pModule;
	private final TerminologyBoxElements pTerminologyBox;
	private final TerminologyGraphElements pTerminologyGraph;
	private final BundleElements pBundle;
	private final DescriptionBoxElements pDescriptionBox;
	private final TerminologyBoxAxiomElements pTerminologyBoxAxiom;
	private final BundledTerminologyAxiomElements pBundledTerminologyAxiom;
	private final ConceptDesignationTerminologyAxiomElements pConceptDesignationTerminologyAxiom;
	private final TerminologyExtensionAxiomElements pTerminologyExtensionAxiom;
	private final TerminologyNestingAxiomElements pTerminologyNestingAxiom;
	private final TerminologyBoxStatementElements pTerminologyBoxStatement;
	private final TermElements pTerm;
	private final AtomicEntityElements pAtomicEntity;
	private final EntityRelationshipElements pEntityRelationship;
	private final DatatypeElements pDatatype;
	private final ScalarDataRangeElements pScalarDataRange;
	private final RestrictedDataRangeElements pRestrictedDataRange;
	private final DataRelationshipElements pDataRelationship;
	private final TermAxiomElements pTermAxiom;
	private final EntityRestrictionAxiomElements pEntityRestrictionAxiom;
	private final EntityScalarDataPropertyRestrictionAxiomElements pEntityScalarDataPropertyRestrictionAxiom;
	private final EntityStructuredDataPropertyRestrictionAxiomElements pEntityStructuredDataPropertyRestrictionAxiom;
	private final SpecializationAxiomElements pSpecializationAxiom;
	private final TerminologyBundleStatementElements pTerminologyBundleStatement;
	private final TerminologyBundleAxiomElements pTerminologyBundleAxiom;
	private final ConceptTreeDisjunctionElements pConceptTreeDisjunction;
	private final DisjointUnionOfConceptsAxiomElements pDisjointUnionOfConceptsAxiom;
	private final TerminologyKindElements eTerminologyKind;
	private final AspectElements pAspect;
	private final ConceptElements pConcept;
	private final ReifiedRelationshipElements pReifiedRelationship;
	private final UnreifiedRelationshipElements pUnreifiedRelationship;
	private final ScalarElements pScalar;
	private final StructureElements pStructure;
	private final EntityStructuredDataPropertyElements pEntityStructuredDataProperty;
	private final EntityScalarDataPropertyElements pEntityScalarDataProperty;
	private final StructuredDataPropertyElements pStructuredDataProperty;
	private final ScalarDataPropertyElements pScalarDataProperty;
	private final AnonymousConceptUnionAxiomElements pAnonymousConceptUnionAxiom;
	private final RootConceptTaxonomyAxiomElements pRootConceptTaxonomyAxiom;
	private final SpecificDisjointConceptAxiomElements pSpecificDisjointConceptAxiom;
	private final EntityExistentialRestrictionAxiomElements pEntityExistentialRestrictionAxiom;
	private final EntityUniversalRestrictionAxiomElements pEntityUniversalRestrictionAxiom;
	private final AspectSpecializationAxiomElements pAspectSpecializationAxiom;
	private final ConceptSpecializationAxiomElements pConceptSpecializationAxiom;
	private final ReifiedRelationshipSpecializationAxiomElements pReifiedRelationshipSpecializationAxiom;
	private final EntityScalarDataPropertyExistentialRestrictionAxiomElements pEntityScalarDataPropertyExistentialRestrictionAxiom;
	private final EntityScalarDataPropertyParticularRestrictionAxiomElements pEntityScalarDataPropertyParticularRestrictionAxiom;
	private final EntityScalarDataPropertyUniversalRestrictionAxiomElements pEntityScalarDataPropertyUniversalRestrictionAxiom;
	private final EntityStructuredDataPropertyParticularRestrictionAxiomElements pEntityStructuredDataPropertyParticularRestrictionAxiom;
	private final RestrictionStructuredDataPropertyTupleElements pRestrictionStructuredDataPropertyTuple;
	private final RestrictionScalarDataPropertyValueElements pRestrictionScalarDataPropertyValue;
	private final BinaryScalarRestrictionElements pBinaryScalarRestriction;
	private final IRIScalarRestrictionElements pIRIScalarRestriction;
	private final NumericScalarRestrictionElements pNumericScalarRestriction;
	private final PlainLiteralScalarRestrictionElements pPlainLiteralScalarRestriction;
	private final ScalarOneOfRestrictionElements pScalarOneOfRestriction;
	private final ScalarOneOfLiteralAxiomElements pScalarOneOfLiteralAxiom;
	private final StringScalarRestrictionElements pStringScalarRestriction;
	private final SynonymScalarRestrictionElements pSynonymScalarRestriction;
	private final TimeScalarRestrictionElements pTimeScalarRestriction;
	private final DescriptionKindElements eDescriptionKind;
	private final TerminologyInstanceAssertionElements pTerminologyInstanceAssertion;
	private final ConceptualEntitySingletonInstanceElements pConceptualEntitySingletonInstance;
	private final DescriptionBoxExtendsClosedWorldDefinitionsElements pDescriptionBoxExtendsClosedWorldDefinitions;
	private final DescriptionBoxRefinementElements pDescriptionBoxRefinement;
	private final SingletonInstanceScalarDataPropertyValueElements pSingletonInstanceScalarDataPropertyValue;
	private final SingletonInstanceStructuredDataPropertyValueElements pSingletonInstanceStructuredDataPropertyValue;
	private final StructuredDataPropertyTupleElements pStructuredDataPropertyTuple;
	private final ScalarDataPropertyValueElements pScalarDataPropertyValue;
	private final ConceptInstanceElements pConceptInstance;
	private final ReifiedRelationshipInstanceElements pReifiedRelationshipInstance;
	private final ReifiedRelationshipInstanceDomainElements pReifiedRelationshipInstanceDomain;
	private final ReifiedRelationshipInstanceRangeElements pReifiedRelationshipInstanceRange;
	private final UnreifiedRelationshipInstanceTupleElements pUnreifiedRelationshipInstanceTuple;
	private final ReferenceElements pReference;
	private final ExternalReferenceElements pExternalReference;
	private final QNAMEElements pQNAME;
	private final ValidIDElements pValidID;
	private final LiteralPatternElements pLiteralPattern;
	private final LiteralValueElements pLiteralValue;
	private final LiteralDateTimeElements pLiteralDateTime;
	private final LiteralLanguageTagElements pLiteralLanguageTag;
	private final LiteralStringElements pLiteralString;
	private final LiteralUUIDElements pLiteralUUID;
	private final LiteralURIElements pLiteralURI;
	private final LiteralNumberElements pLiteralNumber;
	private final TerminalRule tDIGIT;
	private final TerminalRule tDIGIT19;
	private final TerminalRule tDIGIT02;
	private final TerminalRule tDIGIT03;
	private final TerminalRule tDIGIT05;
	private final TerminalRule tYEAR_FRAG;
	private final TerminalRule tMONTH_FRAG;
	private final TerminalRule tDAY_FRAG;
	private final TerminalRule tHOUR_FRAG;
	private final TerminalRule tMINUTE_FRAG;
	private final TerminalRule tSECOND_FRAG;
	private final TerminalRule tEND_OF_DAY_FRAG;
	private final TerminalRule tTIMEZONE_FRAG;
	private final TerminalRule tALPHA;
	private final TerminalRule tSCHEME;
	private final TerminalRule tPCT_ENCODED;
	private final TerminalRule tUNRESERVED;
	private final TerminalRule tDIGIT04;
	private final TerminalRule tDEC_OCTET;
	private final TerminalRule tIPV4_ADDRESS;
	private final TerminalRule tIUSER_PART;
	private final TerminalRule tIUSER_INFO;
	private final TerminalRule tIUNRESERVED_PART;
	private final TerminalRule tIUNRESERVED;
	private final TerminalRule tIHOST;
	private final TerminalRule tPORT;
	private final TerminalRule tIAUTHORITY;
	private final TerminalRule tIPCHAR;
	private final TerminalRule tISEGMENT;
	private final TerminalRule tIPATH;
	private final TerminalRule tIHIER_PART;
	private final TerminalRule tIFRAGMENT;
	private final TerminalRule tURI_VALUE;
	private final URIElements pURI;
	private final TerminalRule tCONSTANT_NAME;
	private final TerminalRule tREAL_VALUE;
	private final REALElements pREAL;
	private final TerminalRule tSTRING;
	private final TerminalRule tIRI;
	private final TerminalRule tLETTER;
	private final TerminalRule tLETTER_DIGIT;
	private final TerminalRule tLETTER_DIGIT_PREFIX;
	private final TerminalRule tLETTER_DIGIT_SUFFIX;
	private final TerminalRule tABBREV_IRI;
	private final TerminalRule tID_PREFIX;
	private final TerminalRule tID;
	private final TerminalRule tLANGUAGE_TAG;
	private final LANG_TAGElements pLANG_TAG;
	private final TerminalRule tDATETIME;
	private final DATE_TIMEElements pDATE_TIME;
	private final TerminalRule tUUID;
	private final TerminalRule tHEX_12DIGITS;
	private final TerminalRule tHEX_8DIGITS;
	private final TerminalRule tHEX_4DIGITS;
	private final TerminalRule tHEX_LETTER;
	private final TerminalRule tHEX_DIGIT;
	private final TerminalRule tHEX;
	private final TerminalRule tDIGITS;
	private final TerminalRule tRATIONAL;
	private final TerminalRule tDEC;
	private final TerminalRule tDECIMAL;
	private final TerminalRule tFLOAT;
	private final TerminalRule tML_COMMENT;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tWS;
	
	private final Grammar grammar;

	@Inject
	public OMLGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pExtent = new ExtentElements();
		this.pAnnotationProperty = new AnnotationPropertyElements();
		this.pAnnotationPropertyValue = new AnnotationPropertyValueElements();
		this.pModule = new ModuleElements();
		this.pTerminologyBox = new TerminologyBoxElements();
		this.pTerminologyGraph = new TerminologyGraphElements();
		this.pBundle = new BundleElements();
		this.pDescriptionBox = new DescriptionBoxElements();
		this.pTerminologyBoxAxiom = new TerminologyBoxAxiomElements();
		this.pBundledTerminologyAxiom = new BundledTerminologyAxiomElements();
		this.pConceptDesignationTerminologyAxiom = new ConceptDesignationTerminologyAxiomElements();
		this.pTerminologyExtensionAxiom = new TerminologyExtensionAxiomElements();
		this.pTerminologyNestingAxiom = new TerminologyNestingAxiomElements();
		this.pTerminologyBoxStatement = new TerminologyBoxStatementElements();
		this.pTerm = new TermElements();
		this.pAtomicEntity = new AtomicEntityElements();
		this.pEntityRelationship = new EntityRelationshipElements();
		this.pDatatype = new DatatypeElements();
		this.pScalarDataRange = new ScalarDataRangeElements();
		this.pRestrictedDataRange = new RestrictedDataRangeElements();
		this.pDataRelationship = new DataRelationshipElements();
		this.pTermAxiom = new TermAxiomElements();
		this.pEntityRestrictionAxiom = new EntityRestrictionAxiomElements();
		this.pEntityScalarDataPropertyRestrictionAxiom = new EntityScalarDataPropertyRestrictionAxiomElements();
		this.pEntityStructuredDataPropertyRestrictionAxiom = new EntityStructuredDataPropertyRestrictionAxiomElements();
		this.pSpecializationAxiom = new SpecializationAxiomElements();
		this.pTerminologyBundleStatement = new TerminologyBundleStatementElements();
		this.pTerminologyBundleAxiom = new TerminologyBundleAxiomElements();
		this.pConceptTreeDisjunction = new ConceptTreeDisjunctionElements();
		this.pDisjointUnionOfConceptsAxiom = new DisjointUnionOfConceptsAxiomElements();
		this.eTerminologyKind = new TerminologyKindElements();
		this.pAspect = new AspectElements();
		this.pConcept = new ConceptElements();
		this.pReifiedRelationship = new ReifiedRelationshipElements();
		this.pUnreifiedRelationship = new UnreifiedRelationshipElements();
		this.pScalar = new ScalarElements();
		this.pStructure = new StructureElements();
		this.pEntityStructuredDataProperty = new EntityStructuredDataPropertyElements();
		this.pEntityScalarDataProperty = new EntityScalarDataPropertyElements();
		this.pStructuredDataProperty = new StructuredDataPropertyElements();
		this.pScalarDataProperty = new ScalarDataPropertyElements();
		this.pAnonymousConceptUnionAxiom = new AnonymousConceptUnionAxiomElements();
		this.pRootConceptTaxonomyAxiom = new RootConceptTaxonomyAxiomElements();
		this.pSpecificDisjointConceptAxiom = new SpecificDisjointConceptAxiomElements();
		this.pEntityExistentialRestrictionAxiom = new EntityExistentialRestrictionAxiomElements();
		this.pEntityUniversalRestrictionAxiom = new EntityUniversalRestrictionAxiomElements();
		this.pAspectSpecializationAxiom = new AspectSpecializationAxiomElements();
		this.pConceptSpecializationAxiom = new ConceptSpecializationAxiomElements();
		this.pReifiedRelationshipSpecializationAxiom = new ReifiedRelationshipSpecializationAxiomElements();
		this.pEntityScalarDataPropertyExistentialRestrictionAxiom = new EntityScalarDataPropertyExistentialRestrictionAxiomElements();
		this.pEntityScalarDataPropertyParticularRestrictionAxiom = new EntityScalarDataPropertyParticularRestrictionAxiomElements();
		this.pEntityScalarDataPropertyUniversalRestrictionAxiom = new EntityScalarDataPropertyUniversalRestrictionAxiomElements();
		this.pEntityStructuredDataPropertyParticularRestrictionAxiom = new EntityStructuredDataPropertyParticularRestrictionAxiomElements();
		this.pRestrictionStructuredDataPropertyTuple = new RestrictionStructuredDataPropertyTupleElements();
		this.pRestrictionScalarDataPropertyValue = new RestrictionScalarDataPropertyValueElements();
		this.pBinaryScalarRestriction = new BinaryScalarRestrictionElements();
		this.pIRIScalarRestriction = new IRIScalarRestrictionElements();
		this.pNumericScalarRestriction = new NumericScalarRestrictionElements();
		this.pPlainLiteralScalarRestriction = new PlainLiteralScalarRestrictionElements();
		this.pScalarOneOfRestriction = new ScalarOneOfRestrictionElements();
		this.pScalarOneOfLiteralAxiom = new ScalarOneOfLiteralAxiomElements();
		this.pStringScalarRestriction = new StringScalarRestrictionElements();
		this.pSynonymScalarRestriction = new SynonymScalarRestrictionElements();
		this.pTimeScalarRestriction = new TimeScalarRestrictionElements();
		this.eDescriptionKind = new DescriptionKindElements();
		this.pTerminologyInstanceAssertion = new TerminologyInstanceAssertionElements();
		this.pConceptualEntitySingletonInstance = new ConceptualEntitySingletonInstanceElements();
		this.pDescriptionBoxExtendsClosedWorldDefinitions = new DescriptionBoxExtendsClosedWorldDefinitionsElements();
		this.pDescriptionBoxRefinement = new DescriptionBoxRefinementElements();
		this.pSingletonInstanceScalarDataPropertyValue = new SingletonInstanceScalarDataPropertyValueElements();
		this.pSingletonInstanceStructuredDataPropertyValue = new SingletonInstanceStructuredDataPropertyValueElements();
		this.pStructuredDataPropertyTuple = new StructuredDataPropertyTupleElements();
		this.pScalarDataPropertyValue = new ScalarDataPropertyValueElements();
		this.pConceptInstance = new ConceptInstanceElements();
		this.pReifiedRelationshipInstance = new ReifiedRelationshipInstanceElements();
		this.pReifiedRelationshipInstanceDomain = new ReifiedRelationshipInstanceDomainElements();
		this.pReifiedRelationshipInstanceRange = new ReifiedRelationshipInstanceRangeElements();
		this.pUnreifiedRelationshipInstanceTuple = new UnreifiedRelationshipInstanceTupleElements();
		this.pReference = new ReferenceElements();
		this.pExternalReference = new ExternalReferenceElements();
		this.pQNAME = new QNAMEElements();
		this.pValidID = new ValidIDElements();
		this.pLiteralPattern = new LiteralPatternElements();
		this.pLiteralValue = new LiteralValueElements();
		this.pLiteralDateTime = new LiteralDateTimeElements();
		this.pLiteralLanguageTag = new LiteralLanguageTagElements();
		this.pLiteralString = new LiteralStringElements();
		this.pLiteralUUID = new LiteralUUIDElements();
		this.pLiteralURI = new LiteralURIElements();
		this.pLiteralNumber = new LiteralNumberElements();
		this.tDIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DIGIT");
		this.tDIGIT19 = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DIGIT19");
		this.tDIGIT02 = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DIGIT02");
		this.tDIGIT03 = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DIGIT03");
		this.tDIGIT05 = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DIGIT05");
		this.tYEAR_FRAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.YEAR_FRAG");
		this.tMONTH_FRAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.MONTH_FRAG");
		this.tDAY_FRAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DAY_FRAG");
		this.tHOUR_FRAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HOUR_FRAG");
		this.tMINUTE_FRAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.MINUTE_FRAG");
		this.tSECOND_FRAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SECOND_FRAG");
		this.tEND_OF_DAY_FRAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.END_OF_DAY_FRAG");
		this.tTIMEZONE_FRAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TIMEZONE_FRAG");
		this.tALPHA = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ALPHA");
		this.tSCHEME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SCHEME");
		this.tPCT_ENCODED = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.PCT_ENCODED");
		this.tUNRESERVED = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UNRESERVED");
		this.tDIGIT04 = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DIGIT04");
		this.tDEC_OCTET = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DEC_OCTET");
		this.tIPV4_ADDRESS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IPV4_ADDRESS");
		this.tIUSER_PART = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IUSER_PART");
		this.tIUSER_INFO = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IUSER_INFO");
		this.tIUNRESERVED_PART = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IUNRESERVED_PART");
		this.tIUNRESERVED = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IUNRESERVED");
		this.tIHOST = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IHOST");
		this.tPORT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.PORT");
		this.tIAUTHORITY = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IAUTHORITY");
		this.tIPCHAR = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IPCHAR");
		this.tISEGMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ISEGMENT");
		this.tIPATH = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IPATH");
		this.tIHIER_PART = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IHIER_PART");
		this.tIFRAGMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IFRAGMENT");
		this.tURI_VALUE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.URI_VALUE");
		this.pURI = new URIElements();
		this.tCONSTANT_NAME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.CONSTANT_NAME");
		this.tREAL_VALUE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.REAL_VALUE");
		this.pREAL = new REALElements();
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.STRING");
		this.tIRI = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IRI");
		this.tLETTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LETTER");
		this.tLETTER_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LETTER_DIGIT");
		this.tLETTER_DIGIT_PREFIX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LETTER_DIGIT_PREFIX");
		this.tLETTER_DIGIT_SUFFIX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LETTER_DIGIT_SUFFIX");
		this.tABBREV_IRI = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ABBREV_IRI");
		this.tID_PREFIX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ID_PREFIX");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ID");
		this.tLANGUAGE_TAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LANGUAGE_TAG");
		this.pLANG_TAG = new LANG_TAGElements();
		this.tDATETIME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DATETIME");
		this.pDATE_TIME = new DATE_TIMEElements();
		this.tUUID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UUID");
		this.tHEX_12DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_12DIGITS");
		this.tHEX_8DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_8DIGITS");
		this.tHEX_4DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_4DIGITS");
		this.tHEX_LETTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_LETTER");
		this.tHEX_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_DIGIT");
		this.tHEX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX");
		this.tDIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
		this.tRATIONAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RATIONAL");
		this.tDEC = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DEC");
		this.tDECIMAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DECIMAL");
		this.tFLOAT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.FLOAT");
		this.tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ML_COMMENT");
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SL_COMMENT");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.WS");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("gov.nasa.jpl.imce.oml.dsl.OML".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	//Extent:
	//	{Extent} (annotationProperties+=AnnotationProperty | modules+=Module)*;
	public ExtentElements getExtentAccess() {
		return pExtent;
	}
	
	public ParserRule getExtentRule() {
		return getExtentAccess().getRule();
	}
	
	//// syntax of Annotation & AnnotationProperties
	//AnnotationProperty:
	//	'annotationProperty' abbrevIRI=ABBREV_IRI '=' iri=IRI;
	public AnnotationPropertyElements getAnnotationPropertyAccess() {
		return pAnnotationProperty;
	}
	
	public ParserRule getAnnotationPropertyRule() {
		return getAnnotationPropertyAccess().getRule();
	}
	
	//AnnotationPropertyValue:
	//	'@' property=[AnnotationProperty|ABBREV_IRI]
	//	'=' value=STRING;
	public AnnotationPropertyValueElements getAnnotationPropertyValueAccess() {
		return pAnnotationPropertyValue;
	}
	
	public ParserRule getAnnotationPropertyValueRule() {
		return getAnnotationPropertyValueAccess().getRule();
	}
	
	//Module:
	//	TerminologyBox | DescriptionBox;
	public ModuleElements getModuleAccess() {
		return pModule;
	}
	
	public ParserRule getModuleRule() {
		return getModuleAccess().getRule();
	}
	
	//// 2 TerminologyBoxes
	//TerminologyBox:
	//	Bundle | TerminologyGraph;
	public TerminologyBoxElements getTerminologyBoxAccess() {
		return pTerminologyBox;
	}
	
	public ParserRule getTerminologyBoxRule() {
		return getTerminologyBoxAccess().getRule();
	}
	
	//TerminologyGraph:
	//	annotations+=AnnotationPropertyValue*
	//	kind=TerminologyKind 'terminology' iri=IRI
	//	'{' (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
	//	'}';
	public TerminologyGraphElements getTerminologyGraphAccess() {
		return pTerminologyGraph;
	}
	
	public ParserRule getTerminologyGraphRule() {
		return getTerminologyGraphAccess().getRule();
	}
	
	//Bundle:
	//	annotations+=AnnotationPropertyValue*
	//	kind=TerminologyKind 'bundle' iri=IRI
	//	'{' (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement |
	//	bundleStatements+=TerminologyBundleStatement | bundleAxioms+=TerminologyBundleAxiom)*
	//	'}';
	public BundleElements getBundleAccess() {
		return pBundle;
	}
	
	public ParserRule getBundleRule() {
		return getBundleAccess().getRule();
	}
	
	//DescriptionBox:
	//	annotations+=AnnotationPropertyValue*
	//	kind=DescriptionKind 'descriptionBox' iri=IRI
	//	'{' (closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
	//	descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
	//	reifiedRelationshipInstances+=ReifiedRelationshipInstance |
	//	reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
	//	reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
	//	unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
	//	singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
	//	singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)*
	//	'}';
	public DescriptionBoxElements getDescriptionBoxAccess() {
		return pDescriptionBox;
	}
	
	public ParserRule getDescriptionBoxRule() {
		return getDescriptionBoxAccess().getRule();
	}
	
	//TerminologyBoxAxiom:
	//	ConceptDesignationTerminologyAxiom | TerminologyExtensionAxiom | TerminologyNestingAxiom;
	public TerminologyBoxAxiomElements getTerminologyBoxAxiomAccess() {
		return pTerminologyBoxAxiom;
	}
	
	public ParserRule getTerminologyBoxAxiomRule() {
		return getTerminologyBoxAxiomAccess().getRule();
	}
	
	//// 1 TerminologyBundleAxiom
	//BundledTerminologyAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'bundles' bundledTerminology=[TerminologyBox|ExternalReference];
	public BundledTerminologyAxiomElements getBundledTerminologyAxiomAccess() {
		return pBundledTerminologyAxiom;
	}
	
	public ParserRule getBundledTerminologyAxiomRule() {
		return getBundledTerminologyAxiomAccess().getRule();
	}
	
	//// 3 TerminologyBoxAxioms
	//ConceptDesignationTerminologyAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'conceptDesignationTerminologyAxiom'
	//	'{'
	//	'designatedTerminology' designatedTerminology=[TerminologyBox|ExternalReference]
	//	'designatedConcept' designatedConcept=[Concept|Reference]
	//	'}';
	public ConceptDesignationTerminologyAxiomElements getConceptDesignationTerminologyAxiomAccess() {
		return pConceptDesignationTerminologyAxiom;
	}
	
	public ParserRule getConceptDesignationTerminologyAxiomRule() {
		return getConceptDesignationTerminologyAxiomAccess().getRule();
	}
	
	//TerminologyExtensionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'extends' extendedTerminology=[TerminologyBox|ExternalReference];
	public TerminologyExtensionAxiomElements getTerminologyExtensionAxiomAccess() {
		return pTerminologyExtensionAxiom;
	}
	
	public ParserRule getTerminologyExtensionAxiomRule() {
		return getTerminologyExtensionAxiomAccess().getRule();
	}
	
	//TerminologyNestingAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'terminologyNestingAxiom'
	//	'{'
	//	'nestingTerminology' nestingTerminology=[TerminologyBox|ExternalReference]
	//	'nestingContext' nestingContext=[Concept|Reference]
	//	'}';
	public TerminologyNestingAxiomElements getTerminologyNestingAxiomAccess() {
		return pTerminologyNestingAxiom;
	}
	
	public ParserRule getTerminologyNestingAxiomRule() {
		return getTerminologyNestingAxiomAccess().getRule();
	}
	
	//TerminologyBoxStatement:
	//	TermAxiom | Term;
	public TerminologyBoxStatementElements getTerminologyBoxStatementAccess() {
		return pTerminologyBoxStatement;
	}
	
	public ParserRule getTerminologyBoxStatementRule() {
		return getTerminologyBoxStatementAccess().getRule();
	}
	
	//Term:
	//	AtomicEntity | EntityRelationship | Datatype | DataRelationship;
	public TermElements getTermAccess() {
		return pTerm;
	}
	
	public ParserRule getTermRule() {
		return getTermAccess().getRule();
	}
	
	//AtomicEntity Entity:
	//	Aspect | Concept;
	public AtomicEntityElements getAtomicEntityAccess() {
		return pAtomicEntity;
	}
	
	public ParserRule getAtomicEntityRule() {
		return getAtomicEntityAccess().getRule();
	}
	
	//EntityRelationship:
	//	ReifiedRelationship | UnreifiedRelationship;
	public EntityRelationshipElements getEntityRelationshipAccess() {
		return pEntityRelationship;
	}
	
	public ParserRule getEntityRelationshipRule() {
		return getEntityRelationshipAccess().getRule();
	}
	
	//Datatype:
	//	ScalarDataRange | Structure;
	public DatatypeElements getDatatypeAccess() {
		return pDatatype;
	}
	
	public ParserRule getDatatypeRule() {
		return getDatatypeAccess().getRule();
	}
	
	//ScalarDataRange DataRange:
	//	Scalar | RestrictedDataRange;
	public ScalarDataRangeElements getScalarDataRangeAccess() {
		return pScalarDataRange;
	}
	
	public ParserRule getScalarDataRangeRule() {
		return getScalarDataRangeAccess().getRule();
	}
	
	//RestrictedDataRange:
	//	BinaryScalarRestriction | IRIScalarRestriction | NumericScalarRestriction | PlainLiteralScalarRestriction |
	//	ScalarOneOfRestriction | StringScalarRestriction | SynonymScalarRestriction | TimeScalarRestriction;
	public RestrictedDataRangeElements getRestrictedDataRangeAccess() {
		return pRestrictedDataRange;
	}
	
	public ParserRule getRestrictedDataRangeRule() {
		return getRestrictedDataRangeAccess().getRule();
	}
	
	//DataRelationship:
	//	EntityStructuredDataProperty | EntityScalarDataProperty | StructuredDataProperty | ScalarDataProperty;
	public DataRelationshipElements getDataRelationshipAccess() {
		return pDataRelationship;
	}
	
	public ParserRule getDataRelationshipRule() {
		return getDataRelationshipAccess().getRule();
	}
	
	//TermAxiom:
	//	EntityRestrictionAxiom | EntityScalarDataPropertyRestrictionAxiom | EntityStructuredDataPropertyRestrictionAxiom |
	//	ScalarOneOfLiteralAxiom | SpecializationAxiom;
	public TermAxiomElements getTermAxiomAccess() {
		return pTermAxiom;
	}
	
	public ParserRule getTermAxiomRule() {
		return getTermAxiomAccess().getRule();
	}
	
	//EntityRestrictionAxiom:
	//	EntityExistentialRestrictionAxiom | EntityUniversalRestrictionAxiom;
	public EntityRestrictionAxiomElements getEntityRestrictionAxiomAccess() {
		return pEntityRestrictionAxiom;
	}
	
	public ParserRule getEntityRestrictionAxiomRule() {
		return getEntityRestrictionAxiomAccess().getRule();
	}
	
	//EntityScalarDataPropertyRestrictionAxiom:
	//	EntityScalarDataPropertyExistentialRestrictionAxiom | EntityScalarDataPropertyParticularRestrictionAxiom |
	//	EntityScalarDataPropertyUniversalRestrictionAxiom;
	public EntityScalarDataPropertyRestrictionAxiomElements getEntityScalarDataPropertyRestrictionAxiomAccess() {
		return pEntityScalarDataPropertyRestrictionAxiom;
	}
	
	public ParserRule getEntityScalarDataPropertyRestrictionAxiomRule() {
		return getEntityScalarDataPropertyRestrictionAxiomAccess().getRule();
	}
	
	//EntityStructuredDataPropertyRestrictionAxiom:
	//	EntityStructuredDataPropertyParticularRestrictionAxiom;
	public EntityStructuredDataPropertyRestrictionAxiomElements getEntityStructuredDataPropertyRestrictionAxiomAccess() {
		return pEntityStructuredDataPropertyRestrictionAxiom;
	}
	
	public ParserRule getEntityStructuredDataPropertyRestrictionAxiomRule() {
		return getEntityStructuredDataPropertyRestrictionAxiomAccess().getRule();
	}
	
	//SpecializationAxiom:
	//	ConceptSpecializationAxiom | AspectSpecializationAxiom | ReifiedRelationshipSpecializationAxiom;
	public SpecializationAxiomElements getSpecializationAxiomAccess() {
		return pSpecializationAxiom;
	}
	
	public ParserRule getSpecializationAxiomRule() {
		return getSpecializationAxiomAccess().getRule();
	}
	
	//TerminologyBundleStatement:
	//	RootConceptTaxonomyAxiom;
	public TerminologyBundleStatementElements getTerminologyBundleStatementAccess() {
		return pTerminologyBundleStatement;
	}
	
	public ParserRule getTerminologyBundleStatementRule() {
		return getTerminologyBundleStatementAccess().getRule();
	}
	
	//TerminologyBundleAxiom:
	//	BundledTerminologyAxiom;
	public TerminologyBundleAxiomElements getTerminologyBundleAxiomAccess() {
		return pTerminologyBundleAxiom;
	}
	
	public ParserRule getTerminologyBundleAxiomRule() {
		return getTerminologyBundleAxiomAccess().getRule();
	}
	
	//ConceptTreeDisjunction:
	//	AnonymousConceptUnionAxiom | RootConceptTaxonomyAxiom;
	public ConceptTreeDisjunctionElements getConceptTreeDisjunctionAccess() {
		return pConceptTreeDisjunction;
	}
	
	public ParserRule getConceptTreeDisjunctionRule() {
		return getConceptTreeDisjunctionAccess().getRule();
	}
	
	//DisjointUnionOfConceptsAxiom:
	//	AnonymousConceptUnionAxiom | SpecificDisjointConceptAxiom;
	public DisjointUnionOfConceptsAxiomElements getDisjointUnionOfConceptsAxiomAccess() {
		return pDisjointUnionOfConceptsAxiom;
	}
	
	public ParserRule getDisjointUnionOfConceptsAxiomRule() {
		return getDisjointUnionOfConceptsAxiomAccess().getRule();
	}
	
	//enum TerminologyKind:
	//	OpenWorldDefinitions='open' |
	//	ClosedWorldDesignations='closed';
	public TerminologyKindElements getTerminologyKindAccess() {
		return eTerminologyKind;
	}
	
	public EnumRule getTerminologyKindRule() {
		return getTerminologyKindAccess().getRule();
	}
	
	//// 2 Atomic Entity Terms
	//Aspect:
	//	annotations+=AnnotationPropertyValue*
	//	'aspect' name=ID;
	public AspectElements getAspectAccess() {
		return pAspect;
	}
	
	public ParserRule getAspectRule() {
		return getAspectAccess().getRule();
	}
	
	//Concept:
	//	annotations+=AnnotationPropertyValue*
	//	'concept' name=ID;
	public ConceptElements getConceptAccess() {
		return pConcept;
	}
	
	public ParserRule getConceptRule() {
		return getConceptAccess().getRule();
	}
	
	//// 2 EntityRelationship Terms
	//ReifiedRelationship:
	//	annotations+=AnnotationPropertyValue*
	//	'reifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
	//	isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
	//	isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
	//	'unreified' '=' unreifiedPropertyName=ID ('inverse' '=' unreifiedInversePropertyName=ID)?
	//	'source' '=' source=[Entity|Reference]
	//	'target' '=' target=[Entity|Reference]
	//	'}';
	public ReifiedRelationshipElements getReifiedRelationshipAccess() {
		return pReifiedRelationship;
	}
	
	public ParserRule getReifiedRelationshipRule() {
		return getReifiedRelationshipAccess().getRule();
	}
	
	//UnreifiedRelationship:
	//	annotations+=AnnotationPropertyValue*
	//	'unreifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
	//	isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
	//	isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
	//	'source' '=' source=[Entity|Reference]
	//	'target' '=' target=[Entity|Reference]
	//	'}';
	public UnreifiedRelationshipElements getUnreifiedRelationshipAccess() {
		return pUnreifiedRelationship;
	}
	
	public ParserRule getUnreifiedRelationshipRule() {
		return getUnreifiedRelationshipAccess().getRule();
	}
	
	//// 2 Datatypes
	//Scalar:
	//	annotations+=AnnotationPropertyValue*
	//	'scalar' name=ID;
	public ScalarElements getScalarAccess() {
		return pScalar;
	}
	
	public ParserRule getScalarRule() {
		return getScalarAccess().getRule();
	}
	
	//Structure:
	//	annotations+=AnnotationPropertyValue*
	//	'structure' name=ID;
	public StructureElements getStructureAccess() {
		return pStructure;
	}
	
	public ParserRule getStructureRule() {
		return getStructureAccess().getRule();
	}
	
	//// 4 DataRelationship Terms
	//EntityStructuredDataProperty:
	//	annotations+=AnnotationPropertyValue*
	//	'entityStructuredDataProperty' isIdentityCriteria?='+'? name=ID '{'
	//	'domain' domain=[Entity|Reference]
	//	'range' range=[Structure|Reference]
	//	'}';
	public EntityStructuredDataPropertyElements getEntityStructuredDataPropertyAccess() {
		return pEntityStructuredDataProperty;
	}
	
	public ParserRule getEntityStructuredDataPropertyRule() {
		return getEntityStructuredDataPropertyAccess().getRule();
	}
	
	//EntityScalarDataProperty:
	//	annotations+=AnnotationPropertyValue*
	//	'entityScalarDataProperty' isIdentityCriteria?='+'? name=ID '{'
	//	'domain' domain=[Entity|Reference]
	//	'range' range=[DataRange|Reference]
	//	'}';
	public EntityScalarDataPropertyElements getEntityScalarDataPropertyAccess() {
		return pEntityScalarDataProperty;
	}
	
	public ParserRule getEntityScalarDataPropertyRule() {
		return getEntityScalarDataPropertyAccess().getRule();
	}
	
	//StructuredDataProperty:
	//	annotations+=AnnotationPropertyValue*
	//	'structuredDataProperty' name=ID '{'
	//	'domain' domain=[Structure|Reference]
	//	'range' range=[Structure|Reference]
	//	'}';
	public StructuredDataPropertyElements getStructuredDataPropertyAccess() {
		return pStructuredDataProperty;
	}
	
	public ParserRule getStructuredDataPropertyRule() {
		return getStructuredDataPropertyAccess().getRule();
	}
	
	//ScalarDataProperty:
	//	annotations+=AnnotationPropertyValue*
	//	'scalarDataProperty' name=ID '{'
	//	'domain' domain=[Structure|Reference]
	//	'range' range=[DataRange|Reference]
	//	'}';
	public ScalarDataPropertyElements getScalarDataPropertyAccess() {
		return pScalarDataProperty;
	}
	
	public ParserRule getScalarDataPropertyRule() {
		return getScalarDataPropertyAccess().getRule();
	}
	
	//// ConceptTreeDisjunctions and DisjointUnionOfConceptsAxioms
	//AnonymousConceptUnionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'anonymousConceptUnion' '(' name=ID ')' '{'
	//	disjunctions+=DisjointUnionOfConceptsAxiom*
	//	'}';
	public AnonymousConceptUnionAxiomElements getAnonymousConceptUnionAxiomAccess() {
		return pAnonymousConceptUnionAxiom;
	}
	
	public ParserRule getAnonymousConceptUnionAxiomRule() {
		return getAnonymousConceptUnionAxiomAccess().getRule();
	}
	
	//RootConceptTaxonomyAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'rootConceptTaxonomy' '(' root=[Concept|Reference] ')'
	//	'{'
	//	disjunctions+=DisjointUnionOfConceptsAxiom*
	//	'}';
	public RootConceptTaxonomyAxiomElements getRootConceptTaxonomyAxiomAccess() {
		return pRootConceptTaxonomyAxiom;
	}
	
	public ParserRule getRootConceptTaxonomyAxiomRule() {
		return getRootConceptTaxonomyAxiomAccess().getRule();
	}
	
	//SpecificDisjointConceptAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'disjointLeaf' '(' disjointLeaf=[Concept|Reference] ')';
	public SpecificDisjointConceptAxiomElements getSpecificDisjointConceptAxiomAccess() {
		return pSpecificDisjointConceptAxiom;
	}
	
	public ParserRule getSpecificDisjointConceptAxiomRule() {
		return getSpecificDisjointConceptAxiomAccess().getRule();
	}
	
	//// 2 EntityRestrictionAxioms
	//EntityExistentialRestrictionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'someEntities'
	//	restrictedDomain=[Entity|Reference]
	//	'.'
	//	restrictedRelation=[ReifiedRelationship|Reference]
	//	'in' restrictedRange=[Entity|Reference];
	public EntityExistentialRestrictionAxiomElements getEntityExistentialRestrictionAxiomAccess() {
		return pEntityExistentialRestrictionAxiom;
	}
	
	public ParserRule getEntityExistentialRestrictionAxiomRule() {
		return getEntityExistentialRestrictionAxiomAccess().getRule();
	}
	
	//EntityUniversalRestrictionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'allEntities'
	//	restrictedDomain=[Entity|Reference]
	//	'.'
	//	restrictedRelation=[ReifiedRelationship|Reference]
	//	'in' restrictedRange=[Entity|Reference];
	public EntityUniversalRestrictionAxiomElements getEntityUniversalRestrictionAxiomAccess() {
		return pEntityUniversalRestrictionAxiom;
	}
	
	public ParserRule getEntityUniversalRestrictionAxiomRule() {
		return getEntityUniversalRestrictionAxiomAccess().getRule();
	}
	
	//// 3 SpecializationAxioms
	//AspectSpecializationAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	subEntity=[Entity|Reference] 'extendsAspect' superAspect=[Aspect|Reference];
	public AspectSpecializationAxiomElements getAspectSpecializationAxiomAccess() {
		return pAspectSpecializationAxiom;
	}
	
	public ParserRule getAspectSpecializationAxiomRule() {
		return getAspectSpecializationAxiomAccess().getRule();
	}
	
	//ConceptSpecializationAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	subConcept=[Concept|Reference] 'extendsConcept' superConcept=[Concept|Reference];
	public ConceptSpecializationAxiomElements getConceptSpecializationAxiomAccess() {
		return pConceptSpecializationAxiom;
	}
	
	public ParserRule getConceptSpecializationAxiomRule() {
		return getConceptSpecializationAxiomAccess().getRule();
	}
	
	//ReifiedRelationshipSpecializationAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	subRelationship=[ReifiedRelationship|Reference] 'extendsRelationship'
	//	superRelationship=[ReifiedRelationship|Reference];
	public ReifiedRelationshipSpecializationAxiomElements getReifiedRelationshipSpecializationAxiomAccess() {
		return pReifiedRelationshipSpecializationAxiom;
	}
	
	public ParserRule getReifiedRelationshipSpecializationAxiomRule() {
		return getReifiedRelationshipSpecializationAxiomAccess().getRule();
	}
	
	//// 3 EntityScalarDataPropertyRestrictionAxioms
	//EntityScalarDataPropertyExistentialRestrictionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'someData'
	//	restrictedEntity=[Entity|Reference]
	//	'.'
	//	scalarProperty=[EntityScalarDataProperty|Reference]
	//	'in' scalarRestriction=[DataRange|Reference];
	public EntityScalarDataPropertyExistentialRestrictionAxiomElements getEntityScalarDataPropertyExistentialRestrictionAxiomAccess() {
		return pEntityScalarDataPropertyExistentialRestrictionAxiom;
	}
	
	public ParserRule getEntityScalarDataPropertyExistentialRestrictionAxiomRule() {
		return getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRule();
	}
	
	//EntityScalarDataPropertyParticularRestrictionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'every'
	//	restrictedEntity=[Entity|Reference]
	//	'.' scalarProperty=[EntityScalarDataProperty|Reference]
	//	'=' literalValue=LiteralValue;
	public EntityScalarDataPropertyParticularRestrictionAxiomElements getEntityScalarDataPropertyParticularRestrictionAxiomAccess() {
		return pEntityScalarDataPropertyParticularRestrictionAxiom;
	}
	
	public ParserRule getEntityScalarDataPropertyParticularRestrictionAxiomRule() {
		return getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRule();
	}
	
	//EntityScalarDataPropertyUniversalRestrictionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'allData'
	//	restrictedEntity=[Entity|Reference]
	//	'.' scalarProperty=[EntityScalarDataProperty|Reference]
	//	'in' scalarRestriction=[DataRange|Reference];
	public EntityScalarDataPropertyUniversalRestrictionAxiomElements getEntityScalarDataPropertyUniversalRestrictionAxiomAccess() {
		return pEntityScalarDataPropertyUniversalRestrictionAxiom;
	}
	
	public ParserRule getEntityScalarDataPropertyUniversalRestrictionAxiomRule() {
		return getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRule();
	}
	
	//// 1 EntityStructuredDataPropertyRestrictionAxiom
	//EntityStructuredDataPropertyParticularRestrictionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'every'
	//	restrictedEntity=[Entity|Reference]
	//	'.'
	//	structuredDataProperty=[EntityStructuredDataProperty|Reference]
	//	'='
	//	'{' (structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple |
	//	scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)*
	//	'}';
	public EntityStructuredDataPropertyParticularRestrictionAxiomElements getEntityStructuredDataPropertyParticularRestrictionAxiomAccess() {
		return pEntityStructuredDataPropertyParticularRestrictionAxiom;
	}
	
	public ParserRule getEntityStructuredDataPropertyParticularRestrictionAxiomRule() {
		return getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRule();
	}
	
	//RestrictionStructuredDataPropertyTuple:
	//	annotations+=AnnotationPropertyValue*
	//	structuredDataProperty=[StructuredDataProperty|Reference]
	//	'=' '{' (structuredDataPropertyRestrictions+=RestrictionStructuredDataPropertyTuple |
	//	scalarDataPropertyRestrictions+=RestrictionScalarDataPropertyValue)*
	//	'}';
	public RestrictionStructuredDataPropertyTupleElements getRestrictionStructuredDataPropertyTupleAccess() {
		return pRestrictionStructuredDataPropertyTuple;
	}
	
	public ParserRule getRestrictionStructuredDataPropertyTupleRule() {
		return getRestrictionStructuredDataPropertyTupleAccess().getRule();
	}
	
	//RestrictionScalarDataPropertyValue:
	//	annotations+=AnnotationPropertyValue*
	//	scalarDataProperty=[ScalarDataProperty|Reference]
	//	'='
	//	scalarPropertyValue=LiteralValue;
	public RestrictionScalarDataPropertyValueElements getRestrictionScalarDataPropertyValueAccess() {
		return pRestrictionScalarDataPropertyValue;
	}
	
	public ParserRule getRestrictionScalarDataPropertyValueRule() {
		return getRestrictionScalarDataPropertyValueAccess().getRule();
	}
	
	//// 8 RestrictedDataRanges + 1 ScalarOneOfLiteralAxiom
	//BinaryScalarRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'binaryScalarRestriction' name=ID
	//	'{' (('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public BinaryScalarRestrictionElements getBinaryScalarRestrictionAccess() {
		return pBinaryScalarRestriction;
	}
	
	public ParserRule getBinaryScalarRestrictionRule() {
		return getBinaryScalarRestrictionAccess().getRule();
	}
	
	//IRIScalarRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'iriScalarRestriction' name=ID
	//	'{' (('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
	//	pattern=LiteralPattern)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public IRIScalarRestrictionElements getIRIScalarRestrictionAccess() {
		return pIRIScalarRestriction;
	}
	
	public ParserRule getIRIScalarRestrictionRule() {
		return getIRIScalarRestrictionAccess().getRule();
	}
	
	//NumericScalarRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'numericScalarRestriction' name=ID
	//	'{' (('minInclusive' minInclusive=LiteralNumber)? & ('maxInclusive' maxInclusive=LiteralNumber)? & ('minExclusive'
	//	minExclusive=LiteralNumber)? & ('maxExclusive' maxExclusive=LiteralNumber)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public NumericScalarRestrictionElements getNumericScalarRestrictionAccess() {
		return pNumericScalarRestriction;
	}
	
	public ParserRule getNumericScalarRestrictionRule() {
		return getNumericScalarRestrictionAccess().getRule();
	}
	
	//PlainLiteralScalarRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'plainLiteralScalarRestriction' name=ID
	//	'{' (('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
	//	pattern=LiteralPattern)? & ('langRange' langRange=LiteralLanguageTag)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public PlainLiteralScalarRestrictionElements getPlainLiteralScalarRestrictionAccess() {
		return pPlainLiteralScalarRestriction;
	}
	
	public ParserRule getPlainLiteralScalarRestrictionRule() {
		return getPlainLiteralScalarRestrictionAccess().getRule();
	}
	
	//ScalarOneOfRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'scalarOneOfRestriction' name=ID
	//	'{'
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public ScalarOneOfRestrictionElements getScalarOneOfRestrictionAccess() {
		return pScalarOneOfRestriction;
	}
	
	public ParserRule getScalarOneOfRestrictionRule() {
		return getScalarOneOfRestrictionAccess().getRule();
	}
	
	//ScalarOneOfLiteralAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'oneOf'
	//	axiom=[ScalarOneOfRestriction|Reference]
	//	'=' value=LiteralValue;
	public ScalarOneOfLiteralAxiomElements getScalarOneOfLiteralAxiomAccess() {
		return pScalarOneOfLiteralAxiom;
	}
	
	public ParserRule getScalarOneOfLiteralAxiomRule() {
		return getScalarOneOfLiteralAxiomAccess().getRule();
	}
	
	//StringScalarRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'stringScalarRestriction' name=ID
	//	'{' (('length' length=DIGITS)? & ('minLength' minLength=DIGITS)? & ('maxLength' maxLength=DIGITS)? & ('pattern'
	//	pattern=LiteralPattern)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public StringScalarRestrictionElements getStringScalarRestrictionAccess() {
		return pStringScalarRestriction;
	}
	
	public ParserRule getStringScalarRestrictionRule() {
		return getStringScalarRestrictionAccess().getRule();
	}
	
	//SynonymScalarRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'synonymScalarRestriction' name=ID
	//	'{'
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public SynonymScalarRestrictionElements getSynonymScalarRestrictionAccess() {
		return pSynonymScalarRestriction;
	}
	
	public ParserRule getSynonymScalarRestrictionRule() {
		return getSynonymScalarRestrictionAccess().getRule();
	}
	
	//TimeScalarRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'timeScalarRestriction' name=ID
	//	'{' (('minInclusive' minInclusive=LiteralDateTime)? & ('maxInclusive' maxInclusive=LiteralDateTime)? & ('minExclusive'
	//	minExclusive=LiteralDateTime)? & ('maxExclusive' maxExclusive=LiteralDateTime)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public TimeScalarRestrictionElements getTimeScalarRestrictionAccess() {
		return pTimeScalarRestriction;
	}
	
	public ParserRule getTimeScalarRestrictionRule() {
		return getTimeScalarRestrictionAccess().getRule();
	}
	
	//enum DescriptionKind:
	//	Final='final' |
	//	Partial='partial';
	public DescriptionKindElements getDescriptionKindAccess() {
		return eDescriptionKind;
	}
	
	public EnumRule getDescriptionKindRule() {
		return getDescriptionKindAccess().getRule();
	}
	
	//TerminologyInstanceAssertion:
	//	ConceptualEntitySingletonInstance | ReifiedRelationshipInstanceDomain | ReifiedRelationshipInstanceRange |
	//	UnreifiedRelationshipInstanceTuple;
	public TerminologyInstanceAssertionElements getTerminologyInstanceAssertionAccess() {
		return pTerminologyInstanceAssertion;
	}
	
	public ParserRule getTerminologyInstanceAssertionRule() {
		return getTerminologyInstanceAssertionAccess().getRule();
	}
	
	//ConceptualEntitySingletonInstance:
	//	ConceptInstance | ReifiedRelationshipInstance;
	public ConceptualEntitySingletonInstanceElements getConceptualEntitySingletonInstanceAccess() {
		return pConceptualEntitySingletonInstance;
	}
	
	public ParserRule getConceptualEntitySingletonInstanceRule() {
		return getConceptualEntitySingletonInstanceAccess().getRule();
	}
	
	//DescriptionBoxExtendsClosedWorldDefinitions:
	//	annotations+=AnnotationPropertyValue*
	//	'extends' closedWorldDefinitions=[TerminologyBox|ExternalReference];
	public DescriptionBoxExtendsClosedWorldDefinitionsElements getDescriptionBoxExtendsClosedWorldDefinitionsAccess() {
		return pDescriptionBoxExtendsClosedWorldDefinitions;
	}
	
	public ParserRule getDescriptionBoxExtendsClosedWorldDefinitionsRule() {
		return getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getRule();
	}
	
	//DescriptionBoxRefinement:
	//	annotations+=AnnotationPropertyValue*
	//	'refines' refinedDescriptionBox=[DescriptionBox|ExternalReference];
	public DescriptionBoxRefinementElements getDescriptionBoxRefinementAccess() {
		return pDescriptionBoxRefinement;
	}
	
	public ParserRule getDescriptionBoxRefinementRule() {
		return getDescriptionBoxRefinementAccess().getRule();
	}
	
	//SingletonInstanceScalarDataPropertyValue:
	//	annotations+=AnnotationPropertyValue*
	//	singletonInstance=[ConceptualEntitySingletonInstance|Reference]
	//	'.'
	//	scalarDataProperty=[EntityScalarDataProperty|Reference]
	//	'='
	//	scalarPropertyValue=LiteralValue;
	public SingletonInstanceScalarDataPropertyValueElements getSingletonInstanceScalarDataPropertyValueAccess() {
		return pSingletonInstanceScalarDataPropertyValue;
	}
	
	public ParserRule getSingletonInstanceScalarDataPropertyValueRule() {
		return getSingletonInstanceScalarDataPropertyValueAccess().getRule();
	}
	
	//SingletonInstanceStructuredDataPropertyValue:
	//	annotations+=AnnotationPropertyValue*
	//	singletonInstance=[ConceptualEntitySingletonInstance|Reference]
	//	'.'
	//	structuredDataProperty=[DataRelationshipToStructure|Reference]
	//	'=' '{' (structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
	//	'}';
	public SingletonInstanceStructuredDataPropertyValueElements getSingletonInstanceStructuredDataPropertyValueAccess() {
		return pSingletonInstanceStructuredDataPropertyValue;
	}
	
	public ParserRule getSingletonInstanceStructuredDataPropertyValueRule() {
		return getSingletonInstanceStructuredDataPropertyValueAccess().getRule();
	}
	
	//StructuredDataPropertyTuple:
	//	annotations+=AnnotationPropertyValue*
	//	structuredDataProperty=[DataRelationshipToStructure|Reference]
	//	'=' '{' (structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
	//	'}';
	public StructuredDataPropertyTupleElements getStructuredDataPropertyTupleAccess() {
		return pStructuredDataPropertyTuple;
	}
	
	public ParserRule getStructuredDataPropertyTupleRule() {
		return getStructuredDataPropertyTupleAccess().getRule();
	}
	
	//ScalarDataPropertyValue:
	//	annotations+=AnnotationPropertyValue*
	//	scalarDataProperty=[DataRelationshipToScalar|Reference]
	//	'='
	//	scalarPropertyValue=LiteralValue;
	public ScalarDataPropertyValueElements getScalarDataPropertyValueAccess() {
		return pScalarDataPropertyValue;
	}
	
	public ParserRule getScalarDataPropertyValueRule() {
		return getScalarDataPropertyValueAccess().getRule();
	}
	
	//ConceptInstance:
	//	annotations+=AnnotationPropertyValue*
	//	'conceptInstance' '(' name=ID 'is-a' singletonConceptClassifier=[Concept|Reference] ')';
	public ConceptInstanceElements getConceptInstanceAccess() {
		return pConceptInstance;
	}
	
	public ParserRule getConceptInstanceRule() {
		return getConceptInstanceAccess().getRule();
	}
	
	//ReifiedRelationshipInstance:
	//	annotations+=AnnotationPropertyValue*
	//	'reifiedRelationshipInstance' '(' name=ID 'is-a'
	//	singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference] ')';
	public ReifiedRelationshipInstanceElements getReifiedRelationshipInstanceAccess() {
		return pReifiedRelationshipInstance;
	}
	
	public ParserRule getReifiedRelationshipInstanceRule() {
		return getReifiedRelationshipInstanceAccess().getRule();
	}
	
	//ReifiedRelationshipInstanceDomain:
	//	annotations+=AnnotationPropertyValue*
	//	'domain'
	//	'(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] ')'
	//	'=' domain=[ConceptualEntitySingletonInstance|Reference];
	public ReifiedRelationshipInstanceDomainElements getReifiedRelationshipInstanceDomainAccess() {
		return pReifiedRelationshipInstanceDomain;
	}
	
	public ParserRule getReifiedRelationshipInstanceDomainRule() {
		return getReifiedRelationshipInstanceDomainAccess().getRule();
	}
	
	//ReifiedRelationshipInstanceRange:
	//	annotations+=AnnotationPropertyValue*
	//	'range'
	//	'(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] ')'
	//	'=' range=[ConceptualEntitySingletonInstance|Reference];
	public ReifiedRelationshipInstanceRangeElements getReifiedRelationshipInstanceRangeAccess() {
		return pReifiedRelationshipInstanceRange;
	}
	
	public ParserRule getReifiedRelationshipInstanceRangeRule() {
		return getReifiedRelationshipInstanceRangeAccess().getRule();
	}
	
	//UnreifiedRelationshipInstanceTuple:
	//	annotations+=AnnotationPropertyValue*
	//	'tuple'
	//	'{'
	//	'unreifiedRelationship' unreifiedRelationship=[UnreifiedRelationship|Reference]
	//	'domain' domain=[ConceptualEntitySingletonInstance|Reference]
	//	'range' range=[ConceptualEntitySingletonInstance|Reference]
	//	'}';
	public UnreifiedRelationshipInstanceTupleElements getUnreifiedRelationshipInstanceTupleAccess() {
		return pUnreifiedRelationshipInstanceTuple;
	}
	
	public ParserRule getUnreifiedRelationshipInstanceTupleRule() {
		return getUnreifiedRelationshipInstanceTupleAccess().getRule();
	}
	
	////----------------------------
	//Reference:
	//	IRI | QNAME;
	public ReferenceElements getReferenceAccess() {
		return pReference;
	}
	
	public ParserRule getReferenceRule() {
		return getReferenceAccess().getRule();
	}
	
	//ExternalReference:
	//	IRI;
	public ExternalReferenceElements getExternalReferenceAccess() {
		return pExternalReference;
	}
	
	public ParserRule getExternalReferenceRule() {
		return getExternalReferenceAccess().getRule();
	}
	
	//QNAME:
	//	ABBREV_IRI | ValidID;
	public QNAMEElements getQNAMEAccess() {
		return pQNAME;
	}
	
	public ParserRule getQNAMERule() {
		return getQNAMEAccess().getRule();
	}
	
	//ValidID:
	//	ID;
	public ValidIDElements getValidIDAccess() {
		return pValidID;
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	////----------------------------
	//LiteralPattern:
	//	{LiteralPattern} value=STRING;
	public LiteralPatternElements getLiteralPatternAccess() {
		return pLiteralPattern;
	}
	
	public ParserRule getLiteralPatternRule() {
		return getLiteralPatternAccess().getRule();
	}
	
	//LiteralValue:
	//	LiteralDateTime | LiteralLanguageTag | LiteralString | LiteralUUID | LiteralURI | LiteralNumber;
	public LiteralValueElements getLiteralValueAccess() {
		return pLiteralValue;
	}
	
	public ParserRule getLiteralValueRule() {
		return getLiteralValueAccess().getRule();
	}
	
	//LiteralDateTime:
	//	{LiteralDateTime} value=DATE_TIME;
	public LiteralDateTimeElements getLiteralDateTimeAccess() {
		return pLiteralDateTime;
	}
	
	public ParserRule getLiteralDateTimeRule() {
		return getLiteralDateTimeAccess().getRule();
	}
	
	//LiteralLanguageTag:
	//	{LiteralLanguageTag} value=LANG_TAG;
	public LiteralLanguageTagElements getLiteralLanguageTagAccess() {
		return pLiteralLanguageTag;
	}
	
	public ParserRule getLiteralLanguageTagRule() {
		return getLiteralLanguageTagAccess().getRule();
	}
	
	//LiteralString:
	//	{LiteralString} value=STRING;
	public LiteralStringElements getLiteralStringAccess() {
		return pLiteralString;
	}
	
	public ParserRule getLiteralStringRule() {
		return getLiteralStringAccess().getRule();
	}
	
	//LiteralUUID:
	//	{LiteralUUID} value=UUID;
	public LiteralUUIDElements getLiteralUUIDAccess() {
		return pLiteralUUID;
	}
	
	public ParserRule getLiteralUUIDRule() {
		return getLiteralUUIDAccess().getRule();
	}
	
	//LiteralURI:
	//	{LiteralURI} value=URI;
	public LiteralURIElements getLiteralURIAccess() {
		return pLiteralURI;
	}
	
	public ParserRule getLiteralURIRule() {
		return getLiteralURIAccess().getRule();
	}
	
	//LiteralNumber:
	//	{LiteralNumber} value=(REAL_VALUE | RATIONAL | FLOAT | DECIMAL);
	public LiteralNumberElements getLiteralNumberAccess() {
		return pLiteralNumber;
	}
	
	public ParserRule getLiteralNumberRule() {
		return getLiteralNumberAccess().getRule();
	}
	
	//terminal fragment DIGIT:
	//	'0'..'9';
	public TerminalRule getDIGITRule() {
		return tDIGIT;
	}
	
	//terminal fragment DIGIT19:
	//	'1'..'9';
	public TerminalRule getDIGIT19Rule() {
		return tDIGIT19;
	}
	
	//terminal fragment DIGIT02:
	//	'0'..'2';
	public TerminalRule getDIGIT02Rule() {
		return tDIGIT02;
	}
	
	//terminal fragment DIGIT03:
	//	'0'..'3';
	public TerminalRule getDIGIT03Rule() {
		return tDIGIT03;
	}
	
	//terminal fragment DIGIT05:
	//	'0'..'5';
	public TerminalRule getDIGIT05Rule() {
		return tDIGIT05;
	}
	
	//terminal fragment YEAR_FRAG:
	//	'-'? (DIGIT19 DIGIT DIGIT DIGIT+ | '0' DIGIT DIGIT DIGIT);
	public TerminalRule getYEAR_FRAGRule() {
		return tYEAR_FRAG;
	}
	
	//terminal fragment MONTH_FRAG:
	//	'0' DIGIT19 | '1' DIGIT02;
	public TerminalRule getMONTH_FRAGRule() {
		return tMONTH_FRAG;
	}
	
	//terminal fragment DAY_FRAG:
	//	'0' DIGIT19 | ('1' | '2') DIGIT | '3' ('0' | '1');
	public TerminalRule getDAY_FRAGRule() {
		return tDAY_FRAG;
	}
	
	//terminal fragment HOUR_FRAG:
	//	('0' | '1') DIGIT | '2' DIGIT03;
	public TerminalRule getHOUR_FRAGRule() {
		return tHOUR_FRAG;
	}
	
	//terminal fragment MINUTE_FRAG:
	//	DIGIT05 DIGIT;
	public TerminalRule getMINUTE_FRAGRule() {
		return tMINUTE_FRAG;
	}
	
	//terminal fragment SECOND_FRAG:
	//	DIGIT05 DIGIT ('.' DIGIT+)?;
	public TerminalRule getSECOND_FRAGRule() {
		return tSECOND_FRAG;
	}
	
	//terminal fragment END_OF_DAY_FRAG:
	//	'24:00:00' ('.' DIGIT+)?;
	public TerminalRule getEND_OF_DAY_FRAGRule() {
		return tEND_OF_DAY_FRAG;
	}
	
	//terminal fragment TIMEZONE_FRAG:
	//	'Z' | ('+' | '-') (('0' DIGIT | '1' DIGIT03) ':' MINUTE_FRAG | '14:00');
	public TerminalRule getTIMEZONE_FRAGRule() {
		return tTIMEZONE_FRAG;
	}
	
	//terminal fragment ALPHA:
	//	'a'..'z' | 'A'..'Z';
	public TerminalRule getALPHARule() {
		return tALPHA;
	}
	
	//terminal fragment SCHEME:
	//	ALPHA (ALPHA | DIGIT | '+' | '-' | '.')*;
	public TerminalRule getSCHEMERule() {
		return tSCHEME;
	}
	
	//terminal fragment PCT_ENCODED:
	//	'%' HEX_DIGIT HEX_DIGIT;
	public TerminalRule getPCT_ENCODEDRule() {
		return tPCT_ENCODED;
	}
	
	//terminal fragment UNRESERVED:
	//	ALPHA | DIGIT | '-' | '.' | '_' | '~';
	public TerminalRule getUNRESERVEDRule() {
		return tUNRESERVED;
	}
	
	//terminal fragment DIGIT04:
	//	'0'..'4';
	public TerminalRule getDIGIT04Rule() {
		return tDIGIT04;
	}
	
	//terminal fragment DEC_OCTET:
	//	DIGIT | '1' DIGIT | '2' DIGIT04 DIGIT | '25' DIGIT05;
	public TerminalRule getDEC_OCTETRule() {
		return tDEC_OCTET;
	}
	
	//terminal fragment IPV4_ADDRESS:
	//	DEC_OCTET '.' DEC_OCTET '.' DEC_OCTET '.' DEC_OCTET;
	public TerminalRule getIPV4_ADDRESSRule() {
		return tIPV4_ADDRESS;
	}
	
	//terminal fragment IUSER_PART:
	//	UNRESERVED | PCT_ENCODED+;
	public TerminalRule getIUSER_PARTRule() {
		return tIUSER_PART;
	}
	
	//terminal fragment IUSER_INFO:
	//	IUSER_PART (':' IUSER_PART)*;
	public TerminalRule getIUSER_INFORule() {
		return tIUSER_INFO;
	}
	
	//terminal fragment IUNRESERVED_PART:
	//	ALPHA | DIGIT | '-' | '_' | '~';
	public TerminalRule getIUNRESERVED_PARTRule() {
		return tIUNRESERVED_PART;
	}
	
	//terminal fragment IUNRESERVED:
	//	ALPHA IUNRESERVED_PART? ('.' IUNRESERVED_PART)*;
	public TerminalRule getIUNRESERVEDRule() {
		return tIUNRESERVED;
	}
	
	//terminal fragment IHOST:
	//	IPV4_ADDRESS | IUNRESERVED;
	public TerminalRule getIHOSTRule() {
		return tIHOST;
	}
	
	//terminal fragment PORT:
	//	DIGIT+;
	public TerminalRule getPORTRule() {
		return tPORT;
	}
	
	//terminal fragment IAUTHORITY:
	//	(IUSER_INFO '@')? IHOST (':' PORT)?;
	public TerminalRule getIAUTHORITYRule() {
		return tIAUTHORITY;
	}
	
	//terminal fragment IPCHAR:
	//	IUNRESERVED_PART | PCT_ENCODED;
	public TerminalRule getIPCHARRule() {
		return tIPCHAR;
	}
	
	//terminal fragment ISEGMENT:
	//	IPCHAR+;
	public TerminalRule getISEGMENTRule() {
		return tISEGMENT;
	}
	
	//terminal fragment IPATH:
	//	ISEGMENT ('/' ISEGMENT)*;
	public TerminalRule getIPATHRule() {
		return tIPATH;
	}
	
	//terminal fragment IHIER_PART:
	//	'//' IAUTHORITY IPATH?;
	public TerminalRule getIHIER_PARTRule() {
		return tIHIER_PART;
	}
	
	//terminal fragment IFRAGMENT:
	//	ISEGMENT;
	public TerminalRule getIFRAGMENTRule() {
		return tIFRAGMENT;
	}
	
	//terminal URI_VALUE:
	//	SCHEME ':' IHIER_PART ('#' IFRAGMENT)?;
	public TerminalRule getURI_VALUERule() {
		return tURI_VALUE;
	}
	
	//URI:
	//	URI_VALUE;
	public URIElements getURIAccess() {
		return pURI;
	}
	
	public ParserRule getURIRule() {
		return getURIAccess().getRule();
	}
	
	//terminal CONSTANT_NAME:
	//	ALPHA (ALPHA | DIGIT)*;
	public TerminalRule getCONSTANT_NAMERule() {
		return tCONSTANT_NAME;
	}
	
	//terminal REAL_VALUE:
	//	'{' ('-' | '+')? CONSTANT_NAME '}';
	public TerminalRule getREAL_VALUERule() {
		return tREAL_VALUE;
	}
	
	//REAL:
	//	REAL_VALUE;
	public REALElements getREALAccess() {
		return pREAL;
	}
	
	public ParserRule getREALRule() {
		return getREALAccess().getRule();
	}
	
	//@ Override terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"'? |
	//	"'" ('\\' . | !('\\' | "'"))* "'"?;
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	}
	
	//terminal IRI:
	//	'<' !'>'* '>';
	public TerminalRule getIRIRule() {
		return tIRI;
	}
	
	//terminal fragment LETTER:
	//	'a'..'z' | 'A'..'Z';
	public TerminalRule getLETTERRule() {
		return tLETTER;
	}
	
	//terminal fragment LETTER_DIGIT:
	//	LETTER | DIGIT;
	public TerminalRule getLETTER_DIGITRule() {
		return tLETTER_DIGIT;
	}
	
	//terminal fragment LETTER_DIGIT_PREFIX:
	//	LETTER_DIGIT | '_';
	public TerminalRule getLETTER_DIGIT_PREFIXRule() {
		return tLETTER_DIGIT_PREFIX;
	}
	
	//terminal fragment LETTER_DIGIT_SUFFIX:
	//	LETTER_DIGIT | '_' | '-' | '.';
	public TerminalRule getLETTER_DIGIT_SUFFIXRule() {
		return tLETTER_DIGIT_SUFFIX;
	}
	
	//terminal ABBREV_IRI:
	//	LETTER_DIGIT_PREFIX LETTER_DIGIT_SUFFIX* ':' LETTER_DIGIT_PREFIX LETTER_DIGIT_SUFFIX*;
	public TerminalRule getABBREV_IRIRule() {
		return tABBREV_IRI;
	}
	
	//terminal fragment ID_PREFIX:
	//	LETTER | '_';
	public TerminalRule getID_PREFIXRule() {
		return tID_PREFIX;
	}
	
	//terminal ID:
	//	'^'? ID_PREFIX LETTER_DIGIT_SUFFIX*;
	public TerminalRule getIDRule() {
		return tID;
	}
	
	//terminal LANGUAGE_TAG:
	//	'lang=' LETTER+ ('-' LETTER_DIGIT+)*;
	public TerminalRule getLANGUAGE_TAGRule() {
		return tLANGUAGE_TAG;
	}
	
	//LANG_TAG:
	//	LANGUAGE_TAG;
	public LANG_TAGElements getLANG_TAGAccess() {
		return pLANG_TAG;
	}
	
	public ParserRule getLANG_TAGRule() {
		return getLANG_TAGAccess().getRule();
	}
	
	//terminal DATETIME:
	//	YEAR_FRAG '-' MONTH_FRAG '-' DAY_FRAG 'T' (HOUR_FRAG ':' MINUTE_FRAG ':' SECOND_FRAG | END_OF_DAY_FRAG)
	//	TIMEZONE_FRAG?;
	public TerminalRule getDATETIMERule() {
		return tDATETIME;
	}
	
	//DATE_TIME:
	//	DATETIME;
	public DATE_TIMEElements getDATE_TIMEAccess() {
		return pDATE_TIME;
	}
	
	public ParserRule getDATE_TIMERule() {
		return getDATE_TIMEAccess().getRule();
	}
	
	//terminal UUID:
	//	HEX_8DIGITS '-' HEX_4DIGITS '-' HEX_4DIGITS '-' HEX_4DIGITS '-' HEX_12DIGITS;
	public TerminalRule getUUIDRule() {
		return tUUID;
	}
	
	//terminal fragment HEX_12DIGITS:
	//	HEX_8DIGITS HEX_4DIGITS;
	public TerminalRule getHEX_12DIGITSRule() {
		return tHEX_12DIGITS;
	}
	
	//terminal fragment HEX_8DIGITS:
	//	HEX_4DIGITS HEX_4DIGITS;
	public TerminalRule getHEX_8DIGITSRule() {
		return tHEX_8DIGITS;
	}
	
	//terminal fragment HEX_4DIGITS:
	//	HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT;
	public TerminalRule getHEX_4DIGITSRule() {
		return tHEX_4DIGITS;
	}
	
	//terminal fragment HEX_LETTER:
	//	'a'..'f' | 'A'..'F';
	public TerminalRule getHEX_LETTERRule() {
		return tHEX_LETTER;
	}
	
	//terminal fragment HEX_DIGIT:
	//	DIGIT | HEX_LETTER;
	public TerminalRule getHEX_DIGITRule() {
		return tHEX_DIGIT;
	}
	
	//terminal fragment HEX:
	//	('0x' | '0X') (HEX_DIGIT | '_')+ ('#' (('b' | 'B') ('i' | 'I') | ('l' | 'L')))?;
	public TerminalRule getHEXRule() {
		return tHEX;
	}
	
	//terminal DIGITS:
	//	DIGIT+;
	public TerminalRule getDIGITSRule() {
		return tDIGITS;
	}
	
	//terminal RATIONAL:
	//	('-' | '+')? DIGITS '/' DIGITS;
	public TerminalRule getRATIONALRule() {
		return tRATIONAL;
	}
	
	//terminal fragment DEC:
	//	'-'?
	//	DIGIT+ (('e' | 'E') ('+' | '-')? DIGIT+)? (('b' | 'B') ('i' | 'I' | 'd' | 'D') | ('l' | 'L' | 'd' | 'D' | 'f' |
	//	'F'))?;
	public TerminalRule getDECRule() {
		return tDEC;
	}
	
	//terminal DECIMAL:
	//	DEC | HEX;
	public TerminalRule getDECIMALRule() {
		return tDECIMAL;
	}
	
	//terminal FLOAT:
	//	'-'? (DIGIT+ '.' DIGIT+) (('e' | 'E') ('+' | '-')? DIGIT+)?;
	public TerminalRule getFLOATRule() {
		return tFLOAT;
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return tML_COMMENT;
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return tWS;
	}
}
