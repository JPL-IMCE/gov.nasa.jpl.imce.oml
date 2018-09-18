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
		private final Assignment cModulesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cModulesModuleParserRuleCall_1_0 = (RuleCall)cModulesAssignment_1.eContents().get(0);
		
		//Extent:
		//	{Extent} modules+=Module*;
		@Override public ParserRule getRule() { return rule; }
		
		//{Extent} modules+=Module*
		public Group getGroup() { return cGroup; }
		
		//{Extent}
		public Action getExtentAction_0() { return cExtentAction_0; }
		
		//modules+=Module*
		public Assignment getModulesAssignment_1() { return cModulesAssignment_1; }
		
		//Module
		public RuleCall getModulesModuleParserRuleCall_1_0() { return cModulesModuleParserRuleCall_1_0; }
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
		private final RuleCall cValueLiteralStringParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//AnnotationPropertyValue:
		//	'@' property=[AnnotationProperty|ABBREV_IRI]
		//	'=' value=LiteralString;
		@Override public ParserRule getRule() { return rule; }
		
		//'@' property=[AnnotationProperty|ABBREV_IRI] '=' value=LiteralString
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
		
		//value=LiteralString
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//LiteralString
		public RuleCall getValueLiteralStringParserRuleCall_3_0() { return cValueLiteralStringParserRuleCall_3_0; }
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
		private final Assignment cAnnotationPropertiesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0 = (RuleCall)cAnnotationPropertiesAssignment_0.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_1_0 = (RuleCall)cAnnotationsAssignment_1.eContents().get(0);
		private final Assignment cKindAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cKindTerminologyKindEnumRuleCall_2_0 = (RuleCall)cKindAssignment_2.eContents().get(0);
		private final Keyword cTerminologyKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cIriAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cIriIRITerminalRuleCall_4_0 = (RuleCall)cIriAssignment_4.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Assignment cBoxAxiomsAssignment_6_0 = (Assignment)cAlternatives_6.eContents().get(0);
		private final RuleCall cBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0 = (RuleCall)cBoxAxiomsAssignment_6_0.eContents().get(0);
		private final Assignment cBoxStatementsAssignment_6_1 = (Assignment)cAlternatives_6.eContents().get(1);
		private final RuleCall cBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0 = (RuleCall)cBoxStatementsAssignment_6_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//TerminologyGraph:
		//	annotationProperties+=AnnotationProperty*
		//	annotations+=AnnotationPropertyValue*
		//	kind=TerminologyKind 'terminology' iri=IRI
		//	'{' (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotationProperties+=AnnotationProperty* annotations+=AnnotationPropertyValue* kind=TerminologyKind 'terminology'
		//iri=IRI '{' (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotationProperties+=AnnotationProperty*
		public Assignment getAnnotationPropertiesAssignment_0() { return cAnnotationPropertiesAssignment_0; }
		
		//AnnotationProperty
		public RuleCall getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0() { return cAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_1() { return cAnnotationsAssignment_1; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_1_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_1_0; }
		
		//kind=TerminologyKind
		public Assignment getKindAssignment_2() { return cKindAssignment_2; }
		
		//TerminologyKind
		public RuleCall getKindTerminologyKindEnumRuleCall_2_0() { return cKindTerminologyKindEnumRuleCall_2_0; }
		
		//'terminology'
		public Keyword getTerminologyKeyword_3() { return cTerminologyKeyword_3; }
		
		//iri=IRI
		public Assignment getIriAssignment_4() { return cIriAssignment_4; }
		
		//IRI
		public RuleCall getIriIRITerminalRuleCall_4_0() { return cIriIRITerminalRuleCall_4_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//(boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
		public Alternatives getAlternatives_6() { return cAlternatives_6; }
		
		//boxAxioms+=TerminologyBoxAxiom
		public Assignment getBoxAxiomsAssignment_6_0() { return cBoxAxiomsAssignment_6_0; }
		
		//TerminologyBoxAxiom
		public RuleCall getBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0() { return cBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0; }
		
		//boxStatements+=TerminologyBoxStatement
		public Assignment getBoxStatementsAssignment_6_1() { return cBoxStatementsAssignment_6_1; }
		
		//TerminologyBoxStatement
		public RuleCall getBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0() { return cBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class BundleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Bundle");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationPropertiesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0 = (RuleCall)cAnnotationPropertiesAssignment_0.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_1_0 = (RuleCall)cAnnotationsAssignment_1.eContents().get(0);
		private final Assignment cKindAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cKindTerminologyKindEnumRuleCall_2_0 = (RuleCall)cKindAssignment_2.eContents().get(0);
		private final Keyword cBundleKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cIriAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cIriIRITerminalRuleCall_4_0 = (RuleCall)cIriAssignment_4.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Assignment cBoxAxiomsAssignment_6_0 = (Assignment)cAlternatives_6.eContents().get(0);
		private final RuleCall cBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0 = (RuleCall)cBoxAxiomsAssignment_6_0.eContents().get(0);
		private final Assignment cBoxStatementsAssignment_6_1 = (Assignment)cAlternatives_6.eContents().get(1);
		private final RuleCall cBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0 = (RuleCall)cBoxStatementsAssignment_6_1.eContents().get(0);
		private final Assignment cBundleStatementsAssignment_6_2 = (Assignment)cAlternatives_6.eContents().get(2);
		private final RuleCall cBundleStatementsTerminologyBundleStatementParserRuleCall_6_2_0 = (RuleCall)cBundleStatementsAssignment_6_2.eContents().get(0);
		private final Assignment cBundleAxiomsAssignment_6_3 = (Assignment)cAlternatives_6.eContents().get(3);
		private final RuleCall cBundleAxiomsTerminologyBundleAxiomParserRuleCall_6_3_0 = (RuleCall)cBundleAxiomsAssignment_6_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//Bundle:
		//	annotationProperties+=AnnotationProperty*
		//	annotations+=AnnotationPropertyValue*
		//	kind=TerminologyKind 'bundle' iri=IRI
		//	'{' (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement |
		//	bundleStatements+=TerminologyBundleStatement | bundleAxioms+=TerminologyBundleAxiom)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotationProperties+=AnnotationProperty* annotations+=AnnotationPropertyValue* kind=TerminologyKind 'bundle' iri=IRI
		//'{' (boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement |
		//bundleStatements+=TerminologyBundleStatement | bundleAxioms+=TerminologyBundleAxiom)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotationProperties+=AnnotationProperty*
		public Assignment getAnnotationPropertiesAssignment_0() { return cAnnotationPropertiesAssignment_0; }
		
		//AnnotationProperty
		public RuleCall getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0() { return cAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_1() { return cAnnotationsAssignment_1; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_1_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_1_0; }
		
		//kind=TerminologyKind
		public Assignment getKindAssignment_2() { return cKindAssignment_2; }
		
		//TerminologyKind
		public RuleCall getKindTerminologyKindEnumRuleCall_2_0() { return cKindTerminologyKindEnumRuleCall_2_0; }
		
		//'bundle'
		public Keyword getBundleKeyword_3() { return cBundleKeyword_3; }
		
		//iri=IRI
		public Assignment getIriAssignment_4() { return cIriAssignment_4; }
		
		//IRI
		public RuleCall getIriIRITerminalRuleCall_4_0() { return cIriIRITerminalRuleCall_4_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//(boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement | bundleStatements+=TerminologyBundleStatement
		//| bundleAxioms+=TerminologyBundleAxiom)*
		public Alternatives getAlternatives_6() { return cAlternatives_6; }
		
		//boxAxioms+=TerminologyBoxAxiom
		public Assignment getBoxAxiomsAssignment_6_0() { return cBoxAxiomsAssignment_6_0; }
		
		//TerminologyBoxAxiom
		public RuleCall getBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0() { return cBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0; }
		
		//boxStatements+=TerminologyBoxStatement
		public Assignment getBoxStatementsAssignment_6_1() { return cBoxStatementsAssignment_6_1; }
		
		//TerminologyBoxStatement
		public RuleCall getBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0() { return cBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0; }
		
		//bundleStatements+=TerminologyBundleStatement
		public Assignment getBundleStatementsAssignment_6_2() { return cBundleStatementsAssignment_6_2; }
		
		//TerminologyBundleStatement
		public RuleCall getBundleStatementsTerminologyBundleStatementParserRuleCall_6_2_0() { return cBundleStatementsTerminologyBundleStatementParserRuleCall_6_2_0; }
		
		//bundleAxioms+=TerminologyBundleAxiom
		public Assignment getBundleAxiomsAssignment_6_3() { return cBundleAxiomsAssignment_6_3; }
		
		//TerminologyBundleAxiom
		public RuleCall getBundleAxiomsTerminologyBundleAxiomParserRuleCall_6_3_0() { return cBundleAxiomsTerminologyBundleAxiomParserRuleCall_6_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class DescriptionBoxElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBox");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationPropertiesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0 = (RuleCall)cAnnotationPropertiesAssignment_0.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_1_0 = (RuleCall)cAnnotationsAssignment_1.eContents().get(0);
		private final Assignment cKindAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cKindDescriptionKindEnumRuleCall_2_0 = (RuleCall)cKindAssignment_2.eContents().get(0);
		private final Keyword cDescriptionBoxKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cIriAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cIriIRITerminalRuleCall_4_0 = (RuleCall)cIriAssignment_4.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Assignment cClosedWorldDefinitionsAssignment_6_0 = (Assignment)cAlternatives_6.eContents().get(0);
		private final RuleCall cClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_6_0_0 = (RuleCall)cClosedWorldDefinitionsAssignment_6_0.eContents().get(0);
		private final Assignment cDescriptionBoxRefinementsAssignment_6_1 = (Assignment)cAlternatives_6.eContents().get(1);
		private final RuleCall cDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_6_1_0 = (RuleCall)cDescriptionBoxRefinementsAssignment_6_1.eContents().get(0);
		private final Assignment cConceptInstancesAssignment_6_2 = (Assignment)cAlternatives_6.eContents().get(2);
		private final RuleCall cConceptInstancesConceptInstanceParserRuleCall_6_2_0 = (RuleCall)cConceptInstancesAssignment_6_2.eContents().get(0);
		private final Assignment cInstanceRelationshipEnumerationRestrictionsAssignment_6_3 = (Assignment)cAlternatives_6.eContents().get(3);
		private final RuleCall cInstanceRelationshipEnumerationRestrictionsInstanceRelationshipEnumerationRestrictionParserRuleCall_6_3_0 = (RuleCall)cInstanceRelationshipEnumerationRestrictionsAssignment_6_3.eContents().get(0);
		private final Assignment cInstanceRelationshipValueRestrictionsAssignment_6_4 = (Assignment)cAlternatives_6.eContents().get(4);
		private final RuleCall cInstanceRelationshipValueRestrictionsInstanceRelationshipValueRestrictionParserRuleCall_6_4_0 = (RuleCall)cInstanceRelationshipValueRestrictionsAssignment_6_4.eContents().get(0);
		private final Assignment cInstanceRelationshipExistentialRangeRestrictionsAssignment_6_5 = (Assignment)cAlternatives_6.eContents().get(5);
		private final RuleCall cInstanceRelationshipExistentialRangeRestrictionsInstanceRelationshipExistentialRangeRestrictionParserRuleCall_6_5_0 = (RuleCall)cInstanceRelationshipExistentialRangeRestrictionsAssignment_6_5.eContents().get(0);
		private final Assignment cInstanceRelationshipUniversalRangeRestrictionsAssignment_6_6 = (Assignment)cAlternatives_6.eContents().get(6);
		private final RuleCall cInstanceRelationshipUniversalRangeRestrictionsInstanceRelationshipUniversalRangeRestrictionParserRuleCall_6_6_0 = (RuleCall)cInstanceRelationshipUniversalRangeRestrictionsAssignment_6_6.eContents().get(0);
		private final Assignment cReifiedRelationshipInstancesAssignment_6_7 = (Assignment)cAlternatives_6.eContents().get(7);
		private final RuleCall cReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_6_7_0 = (RuleCall)cReifiedRelationshipInstancesAssignment_6_7.eContents().get(0);
		private final Assignment cReifiedRelationshipInstanceDomainsAssignment_6_8 = (Assignment)cAlternatives_6.eContents().get(8);
		private final RuleCall cReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_6_8_0 = (RuleCall)cReifiedRelationshipInstanceDomainsAssignment_6_8.eContents().get(0);
		private final Assignment cReifiedRelationshipInstanceRangesAssignment_6_9 = (Assignment)cAlternatives_6.eContents().get(9);
		private final RuleCall cReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_6_9_0 = (RuleCall)cReifiedRelationshipInstanceRangesAssignment_6_9.eContents().get(0);
		private final Assignment cUnreifiedRelationshipInstanceTuplesAssignment_6_10 = (Assignment)cAlternatives_6.eContents().get(10);
		private final RuleCall cUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_6_10_0 = (RuleCall)cUnreifiedRelationshipInstanceTuplesAssignment_6_10.eContents().get(0);
		private final Assignment cSingletonScalarDataPropertyValuesAssignment_6_11 = (Assignment)cAlternatives_6.eContents().get(11);
		private final RuleCall cSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_6_11_0 = (RuleCall)cSingletonScalarDataPropertyValuesAssignment_6_11.eContents().get(0);
		private final Assignment cSingletonStructuredDataPropertyValuesAssignment_6_12 = (Assignment)cAlternatives_6.eContents().get(12);
		private final RuleCall cSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_6_12_0 = (RuleCall)cSingletonStructuredDataPropertyValuesAssignment_6_12.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//DescriptionBox:
		//	annotationProperties+=AnnotationProperty*
		//	annotations+=AnnotationPropertyValue*
		//	kind=DescriptionKind 'descriptionBox' iri=IRI
		//	'{' (closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//	descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//	instanceRelationshipEnumerationRestrictions+=InstanceRelationshipEnumerationRestriction |
		//	instanceRelationshipValueRestrictions+=InstanceRelationshipValueRestriction |
		//	instanceRelationshipExistentialRangeRestrictions+=InstanceRelationshipExistentialRangeRestriction |
		//	instanceRelationshipUniversalRangeRestrictions+=InstanceRelationshipUniversalRangeRestriction |
		//	reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//	reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//	reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//	unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//	singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//	singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotationProperties+=AnnotationProperty* annotations+=AnnotationPropertyValue* kind=DescriptionKind 'descriptionBox'
		//iri=IRI '{' (closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//instanceRelationshipEnumerationRestrictions+=InstanceRelationshipEnumerationRestriction |
		//instanceRelationshipValueRestrictions+=InstanceRelationshipValueRestriction |
		//instanceRelationshipExistentialRangeRestrictions+=InstanceRelationshipExistentialRangeRestriction |
		//instanceRelationshipUniversalRangeRestrictions+=InstanceRelationshipUniversalRangeRestriction |
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotationProperties+=AnnotationProperty*
		public Assignment getAnnotationPropertiesAssignment_0() { return cAnnotationPropertiesAssignment_0; }
		
		//AnnotationProperty
		public RuleCall getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0() { return cAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_1() { return cAnnotationsAssignment_1; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_1_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_1_0; }
		
		//kind=DescriptionKind
		public Assignment getKindAssignment_2() { return cKindAssignment_2; }
		
		//DescriptionKind
		public RuleCall getKindDescriptionKindEnumRuleCall_2_0() { return cKindDescriptionKindEnumRuleCall_2_0; }
		
		//'descriptionBox'
		public Keyword getDescriptionBoxKeyword_3() { return cDescriptionBoxKeyword_3; }
		
		//iri=IRI
		public Assignment getIriAssignment_4() { return cIriAssignment_4; }
		
		//IRI
		public RuleCall getIriIRITerminalRuleCall_4_0() { return cIriIRITerminalRuleCall_4_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//(closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//instanceRelationshipEnumerationRestrictions+=InstanceRelationshipEnumerationRestriction |
		//instanceRelationshipValueRestrictions+=InstanceRelationshipValueRestriction |
		//instanceRelationshipExistentialRangeRestrictions+=InstanceRelationshipExistentialRangeRestriction |
		//instanceRelationshipUniversalRangeRestrictions+=InstanceRelationshipUniversalRangeRestriction |
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)*
		public Alternatives getAlternatives_6() { return cAlternatives_6; }
		
		//closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions
		public Assignment getClosedWorldDefinitionsAssignment_6_0() { return cClosedWorldDefinitionsAssignment_6_0; }
		
		//DescriptionBoxExtendsClosedWorldDefinitions
		public RuleCall getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_6_0_0() { return cClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_6_0_0; }
		
		//descriptionBoxRefinements+=DescriptionBoxRefinement
		public Assignment getDescriptionBoxRefinementsAssignment_6_1() { return cDescriptionBoxRefinementsAssignment_6_1; }
		
		//DescriptionBoxRefinement
		public RuleCall getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_6_1_0() { return cDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_6_1_0; }
		
		//conceptInstances+=ConceptInstance
		public Assignment getConceptInstancesAssignment_6_2() { return cConceptInstancesAssignment_6_2; }
		
		//ConceptInstance
		public RuleCall getConceptInstancesConceptInstanceParserRuleCall_6_2_0() { return cConceptInstancesConceptInstanceParserRuleCall_6_2_0; }
		
		//instanceRelationshipEnumerationRestrictions+=InstanceRelationshipEnumerationRestriction
		public Assignment getInstanceRelationshipEnumerationRestrictionsAssignment_6_3() { return cInstanceRelationshipEnumerationRestrictionsAssignment_6_3; }
		
		//InstanceRelationshipEnumerationRestriction
		public RuleCall getInstanceRelationshipEnumerationRestrictionsInstanceRelationshipEnumerationRestrictionParserRuleCall_6_3_0() { return cInstanceRelationshipEnumerationRestrictionsInstanceRelationshipEnumerationRestrictionParserRuleCall_6_3_0; }
		
		//instanceRelationshipValueRestrictions+=InstanceRelationshipValueRestriction
		public Assignment getInstanceRelationshipValueRestrictionsAssignment_6_4() { return cInstanceRelationshipValueRestrictionsAssignment_6_4; }
		
		//InstanceRelationshipValueRestriction
		public RuleCall getInstanceRelationshipValueRestrictionsInstanceRelationshipValueRestrictionParserRuleCall_6_4_0() { return cInstanceRelationshipValueRestrictionsInstanceRelationshipValueRestrictionParserRuleCall_6_4_0; }
		
		//instanceRelationshipExistentialRangeRestrictions+=InstanceRelationshipExistentialRangeRestriction
		public Assignment getInstanceRelationshipExistentialRangeRestrictionsAssignment_6_5() { return cInstanceRelationshipExistentialRangeRestrictionsAssignment_6_5; }
		
		//InstanceRelationshipExistentialRangeRestriction
		public RuleCall getInstanceRelationshipExistentialRangeRestrictionsInstanceRelationshipExistentialRangeRestrictionParserRuleCall_6_5_0() { return cInstanceRelationshipExistentialRangeRestrictionsInstanceRelationshipExistentialRangeRestrictionParserRuleCall_6_5_0; }
		
		//instanceRelationshipUniversalRangeRestrictions+=InstanceRelationshipUniversalRangeRestriction
		public Assignment getInstanceRelationshipUniversalRangeRestrictionsAssignment_6_6() { return cInstanceRelationshipUniversalRangeRestrictionsAssignment_6_6; }
		
		//InstanceRelationshipUniversalRangeRestriction
		public RuleCall getInstanceRelationshipUniversalRangeRestrictionsInstanceRelationshipUniversalRangeRestrictionParserRuleCall_6_6_0() { return cInstanceRelationshipUniversalRangeRestrictionsInstanceRelationshipUniversalRangeRestrictionParserRuleCall_6_6_0; }
		
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance
		public Assignment getReifiedRelationshipInstancesAssignment_6_7() { return cReifiedRelationshipInstancesAssignment_6_7; }
		
		//ReifiedRelationshipInstance
		public RuleCall getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_6_7_0() { return cReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_6_7_0; }
		
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain
		public Assignment getReifiedRelationshipInstanceDomainsAssignment_6_8() { return cReifiedRelationshipInstanceDomainsAssignment_6_8; }
		
		//ReifiedRelationshipInstanceDomain
		public RuleCall getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_6_8_0() { return cReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_6_8_0; }
		
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange
		public Assignment getReifiedRelationshipInstanceRangesAssignment_6_9() { return cReifiedRelationshipInstanceRangesAssignment_6_9; }
		
		//ReifiedRelationshipInstanceRange
		public RuleCall getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_6_9_0() { return cReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_6_9_0; }
		
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple
		public Assignment getUnreifiedRelationshipInstanceTuplesAssignment_6_10() { return cUnreifiedRelationshipInstanceTuplesAssignment_6_10; }
		
		//UnreifiedRelationshipInstanceTuple
		public RuleCall getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_6_10_0() { return cUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_6_10_0; }
		
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue
		public Assignment getSingletonScalarDataPropertyValuesAssignment_6_11() { return cSingletonScalarDataPropertyValuesAssignment_6_11; }
		
		//SingletonInstanceScalarDataPropertyValue
		public RuleCall getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_6_11_0() { return cSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_6_11_0; }
		
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue
		public Assignment getSingletonStructuredDataPropertyValuesAssignment_6_12() { return cSingletonStructuredDataPropertyValuesAssignment_6_12; }
		
		//SingletonInstanceStructuredDataPropertyValue
		public RuleCall getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_6_12_0() { return cSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_6_12_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
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
		private final RuleCall cRuleParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//Term:
		//	AtomicEntity | EntityRelationship | Datatype | DataRelationship | Rule;
		@Override public ParserRule getRule() { return rule; }
		
		//AtomicEntity | EntityRelationship | Datatype | DataRelationship | Rule
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//AtomicEntity
		public RuleCall getAtomicEntityParserRuleCall_0() { return cAtomicEntityParserRuleCall_0; }
		
		//EntityRelationship
		public RuleCall getEntityRelationshipParserRuleCall_1() { return cEntityRelationshipParserRuleCall_1; }
		
		//Datatype
		public RuleCall getDatatypeParserRuleCall_2() { return cDatatypeParserRuleCall_2; }
		
		//DataRelationship
		public RuleCall getDataRelationshipParserRuleCall_3() { return cDataRelationshipParserRuleCall_3; }
		
		//Rule
		public RuleCall getRuleParserRuleCall_4() { return cRuleParserRuleCall_4; }
	}
	public class AtomicEntityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.AtomicEntity");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAspectParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cCardinalityRestrictedAspectParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cConceptParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cCardinalityRestrictedConceptParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//AtomicEntity Entity:
		//	Aspect | CardinalityRestrictedAspect | Concept | CardinalityRestrictedConcept;
		@Override public ParserRule getRule() { return rule; }
		
		//Aspect | CardinalityRestrictedAspect | Concept | CardinalityRestrictedConcept
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Aspect
		public RuleCall getAspectParserRuleCall_0() { return cAspectParserRuleCall_0; }
		
		//CardinalityRestrictedAspect
		public RuleCall getCardinalityRestrictedAspectParserRuleCall_1() { return cCardinalityRestrictedAspectParserRuleCall_1; }
		
		//Concept
		public RuleCall getConceptParserRuleCall_2() { return cConceptParserRuleCall_2; }
		
		//CardinalityRestrictedConcept
		public RuleCall getCardinalityRestrictedConceptParserRuleCall_3() { return cCardinalityRestrictedConceptParserRuleCall_3; }
	}
	public class EntityRelationshipElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityRelationship");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cReifiedRelationshipParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReifiedRelationshipRestrictionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cCardinalityRestrictedReifiedRelationshipParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cUnreifiedRelationshipParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//EntityRelationship:
		//	ReifiedRelationship | ReifiedRelationshipRestriction | CardinalityRestrictedReifiedRelationship |
		//	UnreifiedRelationship;
		@Override public ParserRule getRule() { return rule; }
		
		//ReifiedRelationship | ReifiedRelationshipRestriction | CardinalityRestrictedReifiedRelationship | UnreifiedRelationship
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ReifiedRelationship
		public RuleCall getReifiedRelationshipParserRuleCall_0() { return cReifiedRelationshipParserRuleCall_0; }
		
		//ReifiedRelationshipRestriction
		public RuleCall getReifiedRelationshipRestrictionParserRuleCall_1() { return cReifiedRelationshipRestrictionParserRuleCall_1; }
		
		//CardinalityRestrictedReifiedRelationship
		public RuleCall getCardinalityRestrictedReifiedRelationshipParserRuleCall_2() { return cCardinalityRestrictedReifiedRelationshipParserRuleCall_2; }
		
		//UnreifiedRelationship
		public RuleCall getUnreifiedRelationshipParserRuleCall_3() { return cUnreifiedRelationshipParserRuleCall_3; }
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
		private final RuleCall cSubObjectPropertyOfAxiomParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cSubDataPropertyOfAxiomParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		
		//TermAxiom:
		//	EntityRestrictionAxiom | EntityScalarDataPropertyRestrictionAxiom | EntityStructuredDataPropertyRestrictionAxiom |
		//	ScalarOneOfLiteralAxiom | SpecializationAxiom | SubObjectPropertyOfAxiom | SubDataPropertyOfAxiom;
		@Override public ParserRule getRule() { return rule; }
		
		//EntityRestrictionAxiom | EntityScalarDataPropertyRestrictionAxiom | EntityStructuredDataPropertyRestrictionAxiom |
		//ScalarOneOfLiteralAxiom | SpecializationAxiom | SubObjectPropertyOfAxiom | SubDataPropertyOfAxiom
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
		
		//SubObjectPropertyOfAxiom
		public RuleCall getSubObjectPropertyOfAxiomParserRuleCall_5() { return cSubObjectPropertyOfAxiomParserRuleCall_5; }
		
		//SubDataPropertyOfAxiom
		public RuleCall getSubDataPropertyOfAxiomParserRuleCall_6() { return cSubDataPropertyOfAxiomParserRuleCall_6; }
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
	public class CardinalityRestrictedAspectElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.CardinalityRestrictedAspect");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cAspectKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cRestrictionKindAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0 = (RuleCall)cRestrictionKindAssignment_3.eContents().get(0);
		private final Assignment cRestrictedCardinalityAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0 = (RuleCall)cRestrictedCardinalityAssignment_4.eContents().get(0);
		private final Assignment cRestrictedRelationshipAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0 = (CrossReference)cRestrictedRelationshipAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cFullStopKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cRestrictedRangeAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cRestrictedRangeEntityCrossReference_6_1_0 = (CrossReference)cRestrictedRangeAssignment_6_1.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_6_1_0.eContents().get(1);
		
		//CardinalityRestrictedAspect:
		//	annotations+=AnnotationPropertyValue*
		//	'aspect' name=ID
		//	restrictionKind=CardinalityRestrictionKind
		//	restrictedCardinality=PositiveIntegerLiteral
		//	restrictedRelationship=[RestrictableRelationship|Reference] ('.' restrictedRange=[Entity|Reference])?;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'aspect' name=ID restrictionKind=CardinalityRestrictionKind
		//restrictedCardinality=PositiveIntegerLiteral restrictedRelationship=[RestrictableRelationship|Reference] ('.'
		//restrictedRange=[Entity|Reference])?
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
		
		//restrictionKind=CardinalityRestrictionKind
		public Assignment getRestrictionKindAssignment_3() { return cRestrictionKindAssignment_3; }
		
		//CardinalityRestrictionKind
		public RuleCall getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0() { return cRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0; }
		
		//restrictedCardinality=PositiveIntegerLiteral
		public Assignment getRestrictedCardinalityAssignment_4() { return cRestrictedCardinalityAssignment_4; }
		
		//PositiveIntegerLiteral
		public RuleCall getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0() { return cRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0; }
		
		//restrictedRelationship=[RestrictableRelationship|Reference]
		public Assignment getRestrictedRelationshipAssignment_5() { return cRestrictedRelationshipAssignment_5; }
		
		//[RestrictableRelationship|Reference]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0; }
		
		//Reference
		public RuleCall getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1() { return cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1; }
		
		//('.' restrictedRange=[Entity|Reference])?
		public Group getGroup_6() { return cGroup_6; }
		
		//'.'
		public Keyword getFullStopKeyword_6_0() { return cFullStopKeyword_6_0; }
		
		//restrictedRange=[Entity|Reference]
		public Assignment getRestrictedRangeAssignment_6_1() { return cRestrictedRangeAssignment_6_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedRangeEntityCrossReference_6_1_0() { return cRestrictedRangeEntityCrossReference_6_1_0; }
		
		//Reference
		public RuleCall getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1() { return cRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1; }
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
	public class CardinalityRestrictedConceptElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.CardinalityRestrictedConcept");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cConceptKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cRestrictionKindAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0 = (RuleCall)cRestrictionKindAssignment_3.eContents().get(0);
		private final Assignment cRestrictedCardinalityAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0 = (RuleCall)cRestrictedCardinalityAssignment_4.eContents().get(0);
		private final Assignment cRestrictedRelationshipAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0 = (CrossReference)cRestrictedRelationshipAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cFullStopKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cRestrictedRangeAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cRestrictedRangeEntityCrossReference_6_1_0 = (CrossReference)cRestrictedRangeAssignment_6_1.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_6_1_0.eContents().get(1);
		
		//CardinalityRestrictedConcept:
		//	annotations+=AnnotationPropertyValue*
		//	'concept' name=ID
		//	restrictionKind=CardinalityRestrictionKind
		//	restrictedCardinality=PositiveIntegerLiteral
		//	restrictedRelationship=[RestrictableRelationship|Reference] ('.' restrictedRange=[Entity|Reference])?;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'concept' name=ID restrictionKind=CardinalityRestrictionKind
		//restrictedCardinality=PositiveIntegerLiteral restrictedRelationship=[RestrictableRelationship|Reference] ('.'
		//restrictedRange=[Entity|Reference])?
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
		
		//restrictionKind=CardinalityRestrictionKind
		public Assignment getRestrictionKindAssignment_3() { return cRestrictionKindAssignment_3; }
		
		//CardinalityRestrictionKind
		public RuleCall getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0() { return cRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0; }
		
		//restrictedCardinality=PositiveIntegerLiteral
		public Assignment getRestrictedCardinalityAssignment_4() { return cRestrictedCardinalityAssignment_4; }
		
		//PositiveIntegerLiteral
		public RuleCall getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0() { return cRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0; }
		
		//restrictedRelationship=[RestrictableRelationship|Reference]
		public Assignment getRestrictedRelationshipAssignment_5() { return cRestrictedRelationshipAssignment_5; }
		
		//[RestrictableRelationship|Reference]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0; }
		
		//Reference
		public RuleCall getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1() { return cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1; }
		
		//('.' restrictedRange=[Entity|Reference])?
		public Group getGroup_6() { return cGroup_6; }
		
		//'.'
		public Keyword getFullStopKeyword_6_0() { return cFullStopKeyword_6_0; }
		
		//restrictedRange=[Entity|Reference]
		public Assignment getRestrictedRangeAssignment_6_1() { return cRestrictedRangeAssignment_6_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedRangeEntityCrossReference_6_1_0() { return cRestrictedRangeEntityCrossReference_6_1_0; }
		
		//Reference
		public RuleCall getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1() { return cRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1; }
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
		private final Assignment cForwardPropertyAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cForwardPropertyForwardPropertyParserRuleCall_7_0 = (RuleCall)cForwardPropertyAssignment_7.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cInverseKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cEqualsSignKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Assignment cInversePropertyAssignment_8_2 = (Assignment)cGroup_8.eContents().get(2);
		private final RuleCall cInversePropertyInversePropertyParserRuleCall_8_2_0 = (RuleCall)cInversePropertyAssignment_8_2.eContents().get(0);
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
		//	'unreified' '=' forwardProperty=ForwardProperty ('inverse' '=' inverseProperty=InverseProperty)?
		//	'source' '=' source=[Entity|Reference]
		//	'target' '=' target=[Entity|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'reifiedRelationship' name=ID '{' (isFunctional?='functional'? &
		//isInverseFunctional?='inverseFunctional'? & isEssential?='essential'? & isInverseEssential?='inverseEssential'? &
		//isSymmetric?='symmetric'? & isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? &
		//isTransitive?='transitive'?) 'unreified' '=' forwardProperty=ForwardProperty ('inverse' '='
		//inverseProperty=InverseProperty)? 'source' '=' source=[Entity|Reference] 'target' '=' target=[Entity|Reference] '}'
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
		
		//forwardProperty=ForwardProperty
		public Assignment getForwardPropertyAssignment_7() { return cForwardPropertyAssignment_7; }
		
		//ForwardProperty
		public RuleCall getForwardPropertyForwardPropertyParserRuleCall_7_0() { return cForwardPropertyForwardPropertyParserRuleCall_7_0; }
		
		//('inverse' '=' inverseProperty=InverseProperty)?
		public Group getGroup_8() { return cGroup_8; }
		
		//'inverse'
		public Keyword getInverseKeyword_8_0() { return cInverseKeyword_8_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_8_1() { return cEqualsSignKeyword_8_1; }
		
		//inverseProperty=InverseProperty
		public Assignment getInversePropertyAssignment_8_2() { return cInversePropertyAssignment_8_2; }
		
		//InverseProperty
		public RuleCall getInversePropertyInversePropertyParserRuleCall_8_2_0() { return cInversePropertyInversePropertyParserRuleCall_8_2_0; }
		
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
	public class ForwardPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ForwardProperty");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//ForwardProperty:
		//	name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class InversePropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.InverseProperty");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//InverseProperty:
		//	name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class ReifiedRelationshipRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cReifiedRelationshipRestrictionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cSourceKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cSourceAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cSourceEntityCrossReference_6_0 = (CrossReference)cSourceAssignment_6.eContents().get(0);
		private final RuleCall cSourceEntityReferenceParserRuleCall_6_0_1 = (RuleCall)cSourceEntityCrossReference_6_0.eContents().get(1);
		private final Keyword cTargetKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Keyword cEqualsSignKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cTargetAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final CrossReference cTargetEntityCrossReference_9_0 = (CrossReference)cTargetAssignment_9.eContents().get(0);
		private final RuleCall cTargetEntityReferenceParserRuleCall_9_0_1 = (RuleCall)cTargetEntityCrossReference_9_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_10 = (Keyword)cGroup.eContents().get(10);
		
		//ReifiedRelationshipRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'reifiedRelationshipRestriction' name=ID '{'
		//	'source' '=' source=[Entity|Reference]
		//	'target' '=' target=[Entity|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'reifiedRelationshipRestriction' name=ID '{' 'source' '='
		//source=[Entity|Reference] 'target' '=' target=[Entity|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'reifiedRelationshipRestriction'
		public Keyword getReifiedRelationshipRestrictionKeyword_1() { return cReifiedRelationshipRestrictionKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'source'
		public Keyword getSourceKeyword_4() { return cSourceKeyword_4; }
		
		//'='
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }
		
		//source=[Entity|Reference]
		public Assignment getSourceAssignment_6() { return cSourceAssignment_6; }
		
		//[Entity|Reference]
		public CrossReference getSourceEntityCrossReference_6_0() { return cSourceEntityCrossReference_6_0; }
		
		//Reference
		public RuleCall getSourceEntityReferenceParserRuleCall_6_0_1() { return cSourceEntityReferenceParserRuleCall_6_0_1; }
		
		//'target'
		public Keyword getTargetKeyword_7() { return cTargetKeyword_7; }
		
		//'='
		public Keyword getEqualsSignKeyword_8() { return cEqualsSignKeyword_8; }
		
		//target=[Entity|Reference]
		public Assignment getTargetAssignment_9() { return cTargetAssignment_9; }
		
		//[Entity|Reference]
		public CrossReference getTargetEntityCrossReference_9_0() { return cTargetEntityCrossReference_9_0; }
		
		//Reference
		public RuleCall getTargetEntityReferenceParserRuleCall_9_0_1() { return cTargetEntityReferenceParserRuleCall_9_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_10() { return cRightCurlyBracketKeyword_10; }
	}
	public class CardinalityRestrictedReifiedRelationshipElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.CardinalityRestrictedReifiedRelationship");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cReifiedRelationshipKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cRestrictionKindAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0 = (RuleCall)cRestrictionKindAssignment_3.eContents().get(0);
		private final Assignment cRestrictedCardinalityAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0 = (RuleCall)cRestrictedCardinalityAssignment_4.eContents().get(0);
		private final Assignment cRestrictedRelationshipAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0 = (CrossReference)cRestrictedRelationshipAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cFullStopKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cRestrictedRangeAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cRestrictedRangeEntityCrossReference_6_1_0 = (CrossReference)cRestrictedRangeAssignment_6_1.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_6_1_0.eContents().get(1);
		
		//CardinalityRestrictedReifiedRelationship:
		//	annotations+=AnnotationPropertyValue*
		//	'reifiedRelationship' name=ID
		//	restrictionKind=CardinalityRestrictionKind
		//	restrictedCardinality=PositiveIntegerLiteral
		//	restrictedRelationship=[RestrictableRelationship|Reference] ('.' restrictedRange=[Entity|Reference])?;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'reifiedRelationship' name=ID restrictionKind=CardinalityRestrictionKind
		//restrictedCardinality=PositiveIntegerLiteral restrictedRelationship=[RestrictableRelationship|Reference] ('.'
		//restrictedRange=[Entity|Reference])?
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
		
		//restrictionKind=CardinalityRestrictionKind
		public Assignment getRestrictionKindAssignment_3() { return cRestrictionKindAssignment_3; }
		
		//CardinalityRestrictionKind
		public RuleCall getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0() { return cRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0; }
		
		//restrictedCardinality=PositiveIntegerLiteral
		public Assignment getRestrictedCardinalityAssignment_4() { return cRestrictedCardinalityAssignment_4; }
		
		//PositiveIntegerLiteral
		public RuleCall getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0() { return cRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0; }
		
		//restrictedRelationship=[RestrictableRelationship|Reference]
		public Assignment getRestrictedRelationshipAssignment_5() { return cRestrictedRelationshipAssignment_5; }
		
		//[RestrictableRelationship|Reference]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_5_0; }
		
		//Reference
		public RuleCall getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1() { return cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1; }
		
		//('.' restrictedRange=[Entity|Reference])?
		public Group getGroup_6() { return cGroup_6; }
		
		//'.'
		public Keyword getFullStopKeyword_6_0() { return cFullStopKeyword_6_0; }
		
		//restrictedRange=[Entity|Reference]
		public Assignment getRestrictedRangeAssignment_6_1() { return cRestrictedRangeAssignment_6_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedRangeEntityCrossReference_6_1_0() { return cRestrictedRangeEntityCrossReference_6_1_0; }
		
		//Reference
		public RuleCall getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1() { return cRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1; }
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
	public class RuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Rule");
		private final RuleCall cChainRuleParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//// 5 Rules
		//Rule:
		//	ChainRule;
		@Override public ParserRule getRule() { return rule; }
		
		//ChainRule
		public RuleCall getChainRuleParserRuleCall() { return cChainRuleParserRuleCall; }
	}
	public class ChainRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ChainRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRuleKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cInfersKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cHeadAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cHeadRestrictableRelationshipCrossReference_3_0 = (CrossReference)cHeadAssignment_3.eContents().get(0);
		private final RuleCall cHeadRestrictableRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cHeadRestrictableRelationshipCrossReference_3_0.eContents().get(1);
		private final Keyword cIfKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cFirstSegmentAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cFirstSegmentRuleBodySegmentParserRuleCall_5_0 = (RuleCall)cFirstSegmentAssignment_5.eContents().get(0);
		
		//ChainRule:
		//	'rule' name=ID 'infers' head=[RestrictableRelationship|Reference] 'if' firstSegment=RuleBodySegment;
		@Override public ParserRule getRule() { return rule; }
		
		//'rule' name=ID 'infers' head=[RestrictableRelationship|Reference] 'if' firstSegment=RuleBodySegment
		public Group getGroup() { return cGroup; }
		
		//'rule'
		public Keyword getRuleKeyword_0() { return cRuleKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'infers'
		public Keyword getInfersKeyword_2() { return cInfersKeyword_2; }
		
		//head=[RestrictableRelationship|Reference]
		public Assignment getHeadAssignment_3() { return cHeadAssignment_3; }
		
		//[RestrictableRelationship|Reference]
		public CrossReference getHeadRestrictableRelationshipCrossReference_3_0() { return cHeadRestrictableRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getHeadRestrictableRelationshipReferenceParserRuleCall_3_0_1() { return cHeadRestrictableRelationshipReferenceParserRuleCall_3_0_1; }
		
		//'if'
		public Keyword getIfKeyword_4() { return cIfKeyword_4; }
		
		//firstSegment=RuleBodySegment
		public Assignment getFirstSegmentAssignment_5() { return cFirstSegmentAssignment_5; }
		
		//RuleBodySegment
		public RuleCall getFirstSegmentRuleBodySegmentParserRuleCall_5_0() { return cFirstSegmentRuleBodySegmentParserRuleCall_5_0; }
	}
	public class RuleBodySegmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RuleBodySegment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPredicateAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cPredicateSegmentPredicateParserRuleCall_0_0 = (RuleCall)cPredicateAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cAmpersandAmpersandKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cNextSegmentAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cNextSegmentRuleBodySegmentParserRuleCall_1_1_0 = (RuleCall)cNextSegmentAssignment_1_1.eContents().get(0);
		
		//RuleBodySegment:
		//	predicate=SegmentPredicate ('&&' nextSegment=RuleBodySegment)?;
		@Override public ParserRule getRule() { return rule; }
		
		//predicate=SegmentPredicate ('&&' nextSegment=RuleBodySegment)?
		public Group getGroup() { return cGroup; }
		
		//predicate=SegmentPredicate
		public Assignment getPredicateAssignment_0() { return cPredicateAssignment_0; }
		
		//SegmentPredicate
		public RuleCall getPredicateSegmentPredicateParserRuleCall_0_0() { return cPredicateSegmentPredicateParserRuleCall_0_0; }
		
		//('&&' nextSegment=RuleBodySegment)?
		public Group getGroup_1() { return cGroup_1; }
		
		//'&&'
		public Keyword getAmpersandAmpersandKeyword_1_0() { return cAmpersandAmpersandKeyword_1_0; }
		
		//nextSegment=RuleBodySegment
		public Assignment getNextSegmentAssignment_1_1() { return cNextSegmentAssignment_1_1; }
		
		//RuleBodySegment
		public RuleCall getNextSegmentRuleBodySegmentParserRuleCall_1_1_0() { return cNextSegmentRuleBodySegmentParserRuleCall_1_1_0; }
	}
	public class SegmentPredicateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SegmentPredicate");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cPredicateAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final CrossReference cPredicatePredicateCrossReference_0_0 = (CrossReference)cPredicateAssignment_0.eContents().get(0);
		private final RuleCall cPredicatePredicateQNAMEParserRuleCall_0_0_1 = (RuleCall)cPredicatePredicateCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cSourceKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cReifiedRelationshipSourceAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cReifiedRelationshipSourceReifiedRelationshipCrossReference_1_2_0 = (CrossReference)cReifiedRelationshipSourceAssignment_1_2.eContents().get(0);
		private final RuleCall cReifiedRelationshipSourceReifiedRelationshipQNAMEParserRuleCall_1_2_0_1 = (RuleCall)cReifiedRelationshipSourceReifiedRelationshipCrossReference_1_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cInvSourceKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Assignment cReifiedRelationshipInverseSourceAssignment_2_2 = (Assignment)cGroup_2.eContents().get(2);
		private final CrossReference cReifiedRelationshipInverseSourceReifiedRelationshipCrossReference_2_2_0 = (CrossReference)cReifiedRelationshipInverseSourceAssignment_2_2.eContents().get(0);
		private final RuleCall cReifiedRelationshipInverseSourceReifiedRelationshipQNAMEParserRuleCall_2_2_0_1 = (RuleCall)cReifiedRelationshipInverseSourceReifiedRelationshipCrossReference_2_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Keyword cTargetKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cReifiedRelationshipTargetAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final CrossReference cReifiedRelationshipTargetReifiedRelationshipCrossReference_3_2_0 = (CrossReference)cReifiedRelationshipTargetAssignment_3_2.eContents().get(0);
		private final RuleCall cReifiedRelationshipTargetReifiedRelationshipQNAMEParserRuleCall_3_2_0_1 = (RuleCall)cReifiedRelationshipTargetReifiedRelationshipCrossReference_3_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cInvTargetKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Assignment cReifiedRelationshipInverseTargetAssignment_4_2 = (Assignment)cGroup_4.eContents().get(2);
		private final CrossReference cReifiedRelationshipInverseTargetReifiedRelationshipCrossReference_4_2_0 = (CrossReference)cReifiedRelationshipInverseTargetAssignment_4_2.eContents().get(0);
		private final RuleCall cReifiedRelationshipInverseTargetReifiedRelationshipQNAMEParserRuleCall_4_2_0_1 = (RuleCall)cReifiedRelationshipInverseTargetReifiedRelationshipCrossReference_4_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Keyword cInvKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cUnreifiedRelationshipInverseAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final CrossReference cUnreifiedRelationshipInverseUnreifiedRelationshipCrossReference_5_2_0 = (CrossReference)cUnreifiedRelationshipInverseAssignment_5_2.eContents().get(0);
		private final RuleCall cUnreifiedRelationshipInverseUnreifiedRelationshipQNAMEParserRuleCall_5_2_0_1 = (RuleCall)cUnreifiedRelationshipInverseUnreifiedRelationshipCrossReference_5_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5_3 = (Keyword)cGroup_5.eContents().get(3);
		
		//SegmentPredicate:
		//	predicate=[Predicate|QNAME] |
		//	'source' '(' reifiedRelationshipSource=[ReifiedRelationship|QNAME] ')' |
		//	'invSource' '(' reifiedRelationshipInverseSource=[ReifiedRelationship|QNAME] ')' |
		//	'target' '(' reifiedRelationshipTarget=[ReifiedRelationship|QNAME] ')' |
		//	'invTarget' '(' reifiedRelationshipInverseTarget=[ReifiedRelationship|QNAME] ')' |
		//	'inv' '(' unreifiedRelationshipInverse=[UnreifiedRelationship|QNAME] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//predicate=[Predicate|QNAME] | 'source' '(' reifiedRelationshipSource=[ReifiedRelationship|QNAME] ')' | 'invSource' '('
		//reifiedRelationshipInverseSource=[ReifiedRelationship|QNAME] ')' | 'target' '('
		//reifiedRelationshipTarget=[ReifiedRelationship|QNAME] ')' | 'invTarget' '('
		//reifiedRelationshipInverseTarget=[ReifiedRelationship|QNAME] ')' | 'inv' '('
		//unreifiedRelationshipInverse=[UnreifiedRelationship|QNAME] ')'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//predicate=[Predicate|QNAME]
		public Assignment getPredicateAssignment_0() { return cPredicateAssignment_0; }
		
		//[Predicate|QNAME]
		public CrossReference getPredicatePredicateCrossReference_0_0() { return cPredicatePredicateCrossReference_0_0; }
		
		//QNAME
		public RuleCall getPredicatePredicateQNAMEParserRuleCall_0_0_1() { return cPredicatePredicateQNAMEParserRuleCall_0_0_1; }
		
		//'source' '(' reifiedRelationshipSource=[ReifiedRelationship|QNAME] ')'
		public Group getGroup_1() { return cGroup_1; }
		
		//'source'
		public Keyword getSourceKeyword_1_0() { return cSourceKeyword_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1_1() { return cLeftParenthesisKeyword_1_1; }
		
		//reifiedRelationshipSource=[ReifiedRelationship|QNAME]
		public Assignment getReifiedRelationshipSourceAssignment_1_2() { return cReifiedRelationshipSourceAssignment_1_2; }
		
		//[ReifiedRelationship|QNAME]
		public CrossReference getReifiedRelationshipSourceReifiedRelationshipCrossReference_1_2_0() { return cReifiedRelationshipSourceReifiedRelationshipCrossReference_1_2_0; }
		
		//QNAME
		public RuleCall getReifiedRelationshipSourceReifiedRelationshipQNAMEParserRuleCall_1_2_0_1() { return cReifiedRelationshipSourceReifiedRelationshipQNAMEParserRuleCall_1_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_3() { return cRightParenthesisKeyword_1_3; }
		
		//'invSource' '(' reifiedRelationshipInverseSource=[ReifiedRelationship|QNAME] ')'
		public Group getGroup_2() { return cGroup_2; }
		
		//'invSource'
		public Keyword getInvSourceKeyword_2_0() { return cInvSourceKeyword_2_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_1() { return cLeftParenthesisKeyword_2_1; }
		
		//reifiedRelationshipInverseSource=[ReifiedRelationship|QNAME]
		public Assignment getReifiedRelationshipInverseSourceAssignment_2_2() { return cReifiedRelationshipInverseSourceAssignment_2_2; }
		
		//[ReifiedRelationship|QNAME]
		public CrossReference getReifiedRelationshipInverseSourceReifiedRelationshipCrossReference_2_2_0() { return cReifiedRelationshipInverseSourceReifiedRelationshipCrossReference_2_2_0; }
		
		//QNAME
		public RuleCall getReifiedRelationshipInverseSourceReifiedRelationshipQNAMEParserRuleCall_2_2_0_1() { return cReifiedRelationshipInverseSourceReifiedRelationshipQNAMEParserRuleCall_2_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_3() { return cRightParenthesisKeyword_2_3; }
		
		//'target' '(' reifiedRelationshipTarget=[ReifiedRelationship|QNAME] ')'
		public Group getGroup_3() { return cGroup_3; }
		
		//'target'
		public Keyword getTargetKeyword_3_0() { return cTargetKeyword_3_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3_1() { return cLeftParenthesisKeyword_3_1; }
		
		//reifiedRelationshipTarget=[ReifiedRelationship|QNAME]
		public Assignment getReifiedRelationshipTargetAssignment_3_2() { return cReifiedRelationshipTargetAssignment_3_2; }
		
		//[ReifiedRelationship|QNAME]
		public CrossReference getReifiedRelationshipTargetReifiedRelationshipCrossReference_3_2_0() { return cReifiedRelationshipTargetReifiedRelationshipCrossReference_3_2_0; }
		
		//QNAME
		public RuleCall getReifiedRelationshipTargetReifiedRelationshipQNAMEParserRuleCall_3_2_0_1() { return cReifiedRelationshipTargetReifiedRelationshipQNAMEParserRuleCall_3_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3_3() { return cRightParenthesisKeyword_3_3; }
		
		//'invTarget' '(' reifiedRelationshipInverseTarget=[ReifiedRelationship|QNAME] ')'
		public Group getGroup_4() { return cGroup_4; }
		
		//'invTarget'
		public Keyword getInvTargetKeyword_4_0() { return cInvTargetKeyword_4_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_4_1() { return cLeftParenthesisKeyword_4_1; }
		
		//reifiedRelationshipInverseTarget=[ReifiedRelationship|QNAME]
		public Assignment getReifiedRelationshipInverseTargetAssignment_4_2() { return cReifiedRelationshipInverseTargetAssignment_4_2; }
		
		//[ReifiedRelationship|QNAME]
		public CrossReference getReifiedRelationshipInverseTargetReifiedRelationshipCrossReference_4_2_0() { return cReifiedRelationshipInverseTargetReifiedRelationshipCrossReference_4_2_0; }
		
		//QNAME
		public RuleCall getReifiedRelationshipInverseTargetReifiedRelationshipQNAMEParserRuleCall_4_2_0_1() { return cReifiedRelationshipInverseTargetReifiedRelationshipQNAMEParserRuleCall_4_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4_3() { return cRightParenthesisKeyword_4_3; }
		
		//'inv' '(' unreifiedRelationshipInverse=[UnreifiedRelationship|QNAME] ')'
		public Group getGroup_5() { return cGroup_5; }
		
		//'inv'
		public Keyword getInvKeyword_5_0() { return cInvKeyword_5_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_5_1() { return cLeftParenthesisKeyword_5_1; }
		
		//unreifiedRelationshipInverse=[UnreifiedRelationship|QNAME]
		public Assignment getUnreifiedRelationshipInverseAssignment_5_2() { return cUnreifiedRelationshipInverseAssignment_5_2; }
		
		//[UnreifiedRelationship|QNAME]
		public CrossReference getUnreifiedRelationshipInverseUnreifiedRelationshipCrossReference_5_2_0() { return cUnreifiedRelationshipInverseUnreifiedRelationshipCrossReference_5_2_0; }
		
		//QNAME
		public RuleCall getUnreifiedRelationshipInverseUnreifiedRelationshipQNAMEParserRuleCall_5_2_0_1() { return cUnreifiedRelationshipInverseUnreifiedRelationshipQNAMEParserRuleCall_5_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5_3() { return cRightParenthesisKeyword_5_3; }
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
		
		//// 3 ConceptTreeDisjunctions and DisjointUnionOfConceptsAxioms
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
		private final RuleCall cDisjointLeafConceptQNAMEParserRuleCall_3_0_1 = (RuleCall)cDisjointLeafConceptCrossReference_3_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//SpecificDisjointConceptAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'disjointLeaf' '(' disjointLeaf=[Concept|QNAME] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'disjointLeaf' '(' disjointLeaf=[Concept|QNAME] ')'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'disjointLeaf'
		public Keyword getDisjointLeafKeyword_1() { return cDisjointLeafKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//disjointLeaf=[Concept|QNAME]
		public Assignment getDisjointLeafAssignment_3() { return cDisjointLeafAssignment_3; }
		
		//[Concept|QNAME]
		public CrossReference getDisjointLeafConceptCrossReference_3_0() { return cDisjointLeafConceptCrossReference_3_0; }
		
		//QNAME
		public RuleCall getDisjointLeafConceptQNAMEParserRuleCall_3_0_1() { return cDisjointLeafConceptQNAMEParserRuleCall_3_0_1; }
		
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
		private final RuleCall cRestrictedDomainEntityQNAMEParserRuleCall_2_0_1 = (RuleCall)cRestrictedDomainEntityCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRestrictedRelationshipAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0 = (CrossReference)cRestrictedRelationshipAssignment_4.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeEntityCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityQNAMEParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_6_0.eContents().get(1);
		
		//// 2 EntityRestrictionAxioms
		//EntityExistentialRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'someEntities'
		//	restrictedDomain=[Entity|QNAME]
		//	'.'
		//	restrictedRelationship=[RestrictableRelationship|QNAME]
		//	'in'
		//	restrictedRange=[Entity|QNAME];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'someEntities' restrictedDomain=[Entity|QNAME] '.'
		//restrictedRelationship=[RestrictableRelationship|QNAME] 'in' restrictedRange=[Entity|QNAME]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'someEntities'
		public Keyword getSomeEntitiesKeyword_1() { return cSomeEntitiesKeyword_1; }
		
		//restrictedDomain=[Entity|QNAME]
		public Assignment getRestrictedDomainAssignment_2() { return cRestrictedDomainAssignment_2; }
		
		//[Entity|QNAME]
		public CrossReference getRestrictedDomainEntityCrossReference_2_0() { return cRestrictedDomainEntityCrossReference_2_0; }
		
		//QNAME
		public RuleCall getRestrictedDomainEntityQNAMEParserRuleCall_2_0_1() { return cRestrictedDomainEntityQNAMEParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//restrictedRelationship=[RestrictableRelationship|QNAME]
		public Assignment getRestrictedRelationshipAssignment_4() { return cRestrictedRelationshipAssignment_4; }
		
		//[RestrictableRelationship|QNAME]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0; }
		
		//QNAME
		public RuleCall getRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1() { return cRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//restrictedRange=[Entity|QNAME]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[Entity|QNAME]
		public CrossReference getRestrictedRangeEntityCrossReference_6_0() { return cRestrictedRangeEntityCrossReference_6_0; }
		
		//QNAME
		public RuleCall getRestrictedRangeEntityQNAMEParserRuleCall_6_0_1() { return cRestrictedRangeEntityQNAMEParserRuleCall_6_0_1; }
	}
	public class EntityUniversalRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityUniversalRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cAllEntitiesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRestrictedDomainAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRestrictedDomainEntityCrossReference_2_0 = (CrossReference)cRestrictedDomainAssignment_2.eContents().get(0);
		private final RuleCall cRestrictedDomainEntityQNAMEParserRuleCall_2_0_1 = (RuleCall)cRestrictedDomainEntityCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRestrictedRelationshipAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0 = (CrossReference)cRestrictedRelationshipAssignment_4.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeEntityCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityQNAMEParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_6_0.eContents().get(1);
		
		//EntityUniversalRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'allEntities'
		//	restrictedDomain=[Entity|QNAME]
		//	'.'
		//	restrictedRelationship=[RestrictableRelationship|QNAME]
		//	'in'
		//	restrictedRange=[Entity|QNAME];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'allEntities' restrictedDomain=[Entity|QNAME] '.'
		//restrictedRelationship=[RestrictableRelationship|QNAME] 'in' restrictedRange=[Entity|QNAME]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'allEntities'
		public Keyword getAllEntitiesKeyword_1() { return cAllEntitiesKeyword_1; }
		
		//restrictedDomain=[Entity|QNAME]
		public Assignment getRestrictedDomainAssignment_2() { return cRestrictedDomainAssignment_2; }
		
		//[Entity|QNAME]
		public CrossReference getRestrictedDomainEntityCrossReference_2_0() { return cRestrictedDomainEntityCrossReference_2_0; }
		
		//QNAME
		public RuleCall getRestrictedDomainEntityQNAMEParserRuleCall_2_0_1() { return cRestrictedDomainEntityQNAMEParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//restrictedRelationship=[RestrictableRelationship|QNAME]
		public Assignment getRestrictedRelationshipAssignment_4() { return cRestrictedRelationshipAssignment_4; }
		
		//[RestrictableRelationship|QNAME]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0; }
		
		//QNAME
		public RuleCall getRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1() { return cRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//restrictedRange=[Entity|QNAME]
		public Assignment getRestrictedRangeAssignment_6() { return cRestrictedRangeAssignment_6; }
		
		//[Entity|QNAME]
		public CrossReference getRestrictedRangeEntityCrossReference_6_0() { return cRestrictedRangeEntityCrossReference_6_0; }
		
		//QNAME
		public RuleCall getRestrictedRangeEntityQNAMEParserRuleCall_6_0_1() { return cRestrictedRangeEntityQNAMEParserRuleCall_6_0_1; }
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
		private final CrossReference cSubRelationshipConceptualRelationshipCrossReference_1_0 = (CrossReference)cSubRelationshipAssignment_1.eContents().get(0);
		private final RuleCall cSubRelationshipConceptualRelationshipReferenceParserRuleCall_1_0_1 = (RuleCall)cSubRelationshipConceptualRelationshipCrossReference_1_0.eContents().get(1);
		private final Keyword cExtendsRelationshipKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSuperRelationshipAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSuperRelationshipConceptualRelationshipCrossReference_3_0 = (CrossReference)cSuperRelationshipAssignment_3.eContents().get(0);
		private final RuleCall cSuperRelationshipConceptualRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cSuperRelationshipConceptualRelationshipCrossReference_3_0.eContents().get(1);
		
		//ReifiedRelationshipSpecializationAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	subRelationship=[ConceptualRelationship|Reference] 'extendsRelationship'
		//	superRelationship=[ConceptualRelationship|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* subRelationship=[ConceptualRelationship|Reference] 'extendsRelationship'
		//superRelationship=[ConceptualRelationship|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//subRelationship=[ConceptualRelationship|Reference]
		public Assignment getSubRelationshipAssignment_1() { return cSubRelationshipAssignment_1; }
		
		//[ConceptualRelationship|Reference]
		public CrossReference getSubRelationshipConceptualRelationshipCrossReference_1_0() { return cSubRelationshipConceptualRelationshipCrossReference_1_0; }
		
		//Reference
		public RuleCall getSubRelationshipConceptualRelationshipReferenceParserRuleCall_1_0_1() { return cSubRelationshipConceptualRelationshipReferenceParserRuleCall_1_0_1; }
		
		//'extendsRelationship'
		public Keyword getExtendsRelationshipKeyword_2() { return cExtendsRelationshipKeyword_2; }
		
		//superRelationship=[ConceptualRelationship|Reference]
		public Assignment getSuperRelationshipAssignment_3() { return cSuperRelationshipAssignment_3; }
		
		//[ConceptualRelationship|Reference]
		public CrossReference getSuperRelationshipConceptualRelationshipCrossReference_3_0() { return cSuperRelationshipConceptualRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getSuperRelationshipConceptualRelationshipReferenceParserRuleCall_3_0_1() { return cSuperRelationshipConceptualRelationshipReferenceParserRuleCall_3_0_1; }
	}
	public class SubObjectPropertyOfAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SubObjectPropertyOfAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cSubPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSubPropertyUnreifiedRelationshipCrossReference_1_0 = (CrossReference)cSubPropertyAssignment_1.eContents().get(0);
		private final RuleCall cSubPropertyUnreifiedRelationshipReferenceParserRuleCall_1_0_1 = (RuleCall)cSubPropertyUnreifiedRelationshipCrossReference_1_0.eContents().get(1);
		private final Keyword cSubObjectPropertyOfKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSuperPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSuperPropertyUnreifiedRelationshipCrossReference_3_0 = (CrossReference)cSuperPropertyAssignment_3.eContents().get(0);
		private final RuleCall cSuperPropertyUnreifiedRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cSuperPropertyUnreifiedRelationshipCrossReference_3_0.eContents().get(1);
		
		//// 2 Sub*PropertyOfAxioms
		//SubObjectPropertyOfAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	subProperty=[UnreifiedRelationship|Reference]
		//	'subObjectPropertyOf'
		//	superProperty=[UnreifiedRelationship|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* subProperty=[UnreifiedRelationship|Reference] 'subObjectPropertyOf'
		//superProperty=[UnreifiedRelationship|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//subProperty=[UnreifiedRelationship|Reference]
		public Assignment getSubPropertyAssignment_1() { return cSubPropertyAssignment_1; }
		
		//[UnreifiedRelationship|Reference]
		public CrossReference getSubPropertyUnreifiedRelationshipCrossReference_1_0() { return cSubPropertyUnreifiedRelationshipCrossReference_1_0; }
		
		//Reference
		public RuleCall getSubPropertyUnreifiedRelationshipReferenceParserRuleCall_1_0_1() { return cSubPropertyUnreifiedRelationshipReferenceParserRuleCall_1_0_1; }
		
		//'subObjectPropertyOf'
		public Keyword getSubObjectPropertyOfKeyword_2() { return cSubObjectPropertyOfKeyword_2; }
		
		//superProperty=[UnreifiedRelationship|Reference]
		public Assignment getSuperPropertyAssignment_3() { return cSuperPropertyAssignment_3; }
		
		//[UnreifiedRelationship|Reference]
		public CrossReference getSuperPropertyUnreifiedRelationshipCrossReference_3_0() { return cSuperPropertyUnreifiedRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getSuperPropertyUnreifiedRelationshipReferenceParserRuleCall_3_0_1() { return cSuperPropertyUnreifiedRelationshipReferenceParserRuleCall_3_0_1; }
	}
	public class SubDataPropertyOfAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SubDataPropertyOfAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cSubPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSubPropertyEntityScalarDataPropertyCrossReference_1_0 = (CrossReference)cSubPropertyAssignment_1.eContents().get(0);
		private final RuleCall cSubPropertyEntityScalarDataPropertyReferenceParserRuleCall_1_0_1 = (RuleCall)cSubPropertyEntityScalarDataPropertyCrossReference_1_0.eContents().get(1);
		private final Keyword cSubDataPropertyOfKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSuperPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSuperPropertyEntityScalarDataPropertyCrossReference_3_0 = (CrossReference)cSuperPropertyAssignment_3.eContents().get(0);
		private final RuleCall cSuperPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1 = (RuleCall)cSuperPropertyEntityScalarDataPropertyCrossReference_3_0.eContents().get(1);
		
		//SubDataPropertyOfAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	subProperty=[EntityScalarDataProperty|Reference]
		//	'subDataPropertyOf'
		//	superProperty=[EntityScalarDataProperty|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* subProperty=[EntityScalarDataProperty|Reference] 'subDataPropertyOf'
		//superProperty=[EntityScalarDataProperty|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//subProperty=[EntityScalarDataProperty|Reference]
		public Assignment getSubPropertyAssignment_1() { return cSubPropertyAssignment_1; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getSubPropertyEntityScalarDataPropertyCrossReference_1_0() { return cSubPropertyEntityScalarDataPropertyCrossReference_1_0; }
		
		//Reference
		public RuleCall getSubPropertyEntityScalarDataPropertyReferenceParserRuleCall_1_0_1() { return cSubPropertyEntityScalarDataPropertyReferenceParserRuleCall_1_0_1; }
		
		//'subDataPropertyOf'
		public Keyword getSubDataPropertyOfKeyword_2() { return cSubDataPropertyOfKeyword_2; }
		
		//superProperty=[EntityScalarDataProperty|Reference]
		public Assignment getSuperPropertyAssignment_3() { return cSuperPropertyAssignment_3; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getSuperPropertyEntityScalarDataPropertyCrossReference_3_0() { return cSuperPropertyEntityScalarDataPropertyCrossReference_3_0; }
		
		//Reference
		public RuleCall getSuperPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1() { return cSuperPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1; }
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
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cCircumflexAccentCircumflexAccentKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cValueTypeAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final CrossReference cValueTypeDataRangeCrossReference_7_1_0 = (CrossReference)cValueTypeAssignment_7_1.eContents().get(0);
		private final RuleCall cValueTypeDataRangeReferenceParserRuleCall_7_1_0_1 = (RuleCall)cValueTypeDataRangeCrossReference_7_1_0.eContents().get(1);
		
		//EntityScalarDataPropertyParticularRestrictionAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'every'
		//	restrictedEntity=[Entity|Reference]
		//	'.' scalarProperty=[EntityScalarDataProperty|Reference]
		//	'=' literalValue=LiteralValue ('^^' valueType=[DataRange|Reference])?;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'every' restrictedEntity=[Entity|Reference] '.'
		//scalarProperty=[EntityScalarDataProperty|Reference] '=' literalValue=LiteralValue ('^^'
		//valueType=[DataRange|Reference])?
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
		
		//('^^' valueType=[DataRange|Reference])?
		public Group getGroup_7() { return cGroup_7; }
		
		//'^^'
		public Keyword getCircumflexAccentCircumflexAccentKeyword_7_0() { return cCircumflexAccentCircumflexAccentKeyword_7_0; }
		
		//valueType=[DataRange|Reference]
		public Assignment getValueTypeAssignment_7_1() { return cValueTypeAssignment_7_1; }
		
		//[DataRange|Reference]
		public CrossReference getValueTypeDataRangeCrossReference_7_1_0() { return cValueTypeDataRangeCrossReference_7_1_0; }
		
		//Reference
		public RuleCall getValueTypeDataRangeReferenceParserRuleCall_7_1_0_1() { return cValueTypeDataRangeReferenceParserRuleCall_7_1_0_1; }
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
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCircumflexAccentCircumflexAccentKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cValueTypeAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cValueTypeDataRangeCrossReference_4_1_0 = (CrossReference)cValueTypeAssignment_4_1.eContents().get(0);
		private final RuleCall cValueTypeDataRangeReferenceParserRuleCall_4_1_0_1 = (RuleCall)cValueTypeDataRangeCrossReference_4_1_0.eContents().get(1);
		
		//RestrictionScalarDataPropertyValue:
		//	annotations+=AnnotationPropertyValue*
		//	scalarDataProperty=[ScalarDataProperty|Reference]
		//	'='
		//	scalarPropertyValue=LiteralValue ('^^' valueType=[DataRange|Reference])?;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* scalarDataProperty=[ScalarDataProperty|Reference] '='
		//scalarPropertyValue=LiteralValue ('^^' valueType=[DataRange|Reference])?
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
		
		//('^^' valueType=[DataRange|Reference])?
		public Group getGroup_4() { return cGroup_4; }
		
		//'^^'
		public Keyword getCircumflexAccentCircumflexAccentKeyword_4_0() { return cCircumflexAccentCircumflexAccentKeyword_4_0; }
		
		//valueType=[DataRange|Reference]
		public Assignment getValueTypeAssignment_4_1() { return cValueTypeAssignment_4_1; }
		
		//[DataRange|Reference]
		public CrossReference getValueTypeDataRangeCrossReference_4_1_0() { return cValueTypeDataRangeCrossReference_4_1_0; }
		
		//Reference
		public RuleCall getValueTypeDataRangeReferenceParserRuleCall_4_1_0_1() { return cValueTypeDataRangeReferenceParserRuleCall_4_1_0_1; }
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
		private final RuleCall cLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0 = (RuleCall)cLengthAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMinLengthKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0 = (RuleCall)cMinLengthAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMaxLengthKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0 = (RuleCall)cMaxLengthAssignment_4_2_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//// 8 RestrictedDataRanges + 1 ScalarOneOfLiteralAxiom
		//BinaryScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'binaryScalarRestriction' name=ID
		//	'{' (('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//	maxLength=PositiveIntegerLiteral)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'binaryScalarRestriction' name=ID '{' (('length' length=PositiveIntegerLiteral)? &
		//('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength' maxLength=PositiveIntegerLiteral)?) 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
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
		
		//('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//maxLength=PositiveIntegerLiteral)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('length' length=PositiveIntegerLiteral)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'length'
		public Keyword getLengthKeyword_4_0_0() { return cLengthKeyword_4_0_0; }
		
		//length=PositiveIntegerLiteral
		public Assignment getLengthAssignment_4_0_1() { return cLengthAssignment_4_0_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0() { return cLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0; }
		
		//('minLength' minLength=PositiveIntegerLiteral)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_4_1_0() { return cMinLengthKeyword_4_1_0; }
		
		//minLength=PositiveIntegerLiteral
		public Assignment getMinLengthAssignment_4_1_1() { return cMinLengthAssignment_4_1_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0() { return cMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0; }
		
		//('maxLength' maxLength=PositiveIntegerLiteral)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_4_2_0() { return cMaxLengthKeyword_4_2_0; }
		
		//maxLength=PositiveIntegerLiteral
		public Assignment getMaxLengthAssignment_4_2_1() { return cMaxLengthAssignment_4_2_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0() { return cMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0; }
		
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
		private final RuleCall cLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0 = (RuleCall)cLengthAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMinLengthKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0 = (RuleCall)cMinLengthAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMaxLengthKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0 = (RuleCall)cMaxLengthAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_3 = (Group)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cPatternKeyword_4_3_0 = (Keyword)cGroup_4_3.eContents().get(0);
		private final Assignment cPatternAssignment_4_3_1 = (Assignment)cGroup_4_3.eContents().get(1);
		private final RuleCall cPatternPATTERNTerminalRuleCall_4_3_1_0 = (RuleCall)cPatternAssignment_4_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//IRIScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'iriScalarRestriction' name=ID
		//	'{' (('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//	maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'iriScalarRestriction' name=ID '{' (('length' length=PositiveIntegerLiteral)? &
		//('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength' maxLength=PositiveIntegerLiteral)? & ('pattern'
		//pattern=PATTERN)?) 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
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
		
		//('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('length' length=PositiveIntegerLiteral)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'length'
		public Keyword getLengthKeyword_4_0_0() { return cLengthKeyword_4_0_0; }
		
		//length=PositiveIntegerLiteral
		public Assignment getLengthAssignment_4_0_1() { return cLengthAssignment_4_0_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0() { return cLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0; }
		
		//('minLength' minLength=PositiveIntegerLiteral)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_4_1_0() { return cMinLengthKeyword_4_1_0; }
		
		//minLength=PositiveIntegerLiteral
		public Assignment getMinLengthAssignment_4_1_1() { return cMinLengthAssignment_4_1_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0() { return cMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0; }
		
		//('maxLength' maxLength=PositiveIntegerLiteral)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_4_2_0() { return cMaxLengthKeyword_4_2_0; }
		
		//maxLength=PositiveIntegerLiteral
		public Assignment getMaxLengthAssignment_4_2_1() { return cMaxLengthAssignment_4_2_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0() { return cMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0; }
		
		//('pattern' pattern=PATTERN)?
		public Group getGroup_4_3() { return cGroup_4_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_4_3_0() { return cPatternKeyword_4_3_0; }
		
		//pattern=PATTERN
		public Assignment getPatternAssignment_4_3_1() { return cPatternAssignment_4_3_1; }
		
		//PATTERN
		public RuleCall getPatternPATTERNTerminalRuleCall_4_3_1_0() { return cPatternPATTERNTerminalRuleCall_4_3_1_0; }
		
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
		private final RuleCall cLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0 = (RuleCall)cLengthAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMinLengthKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0 = (RuleCall)cMinLengthAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMaxLengthKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0 = (RuleCall)cMaxLengthAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_3 = (Group)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cPatternKeyword_4_3_0 = (Keyword)cGroup_4_3.eContents().get(0);
		private final Assignment cPatternAssignment_4_3_1 = (Assignment)cGroup_4_3.eContents().get(1);
		private final RuleCall cPatternPATTERNTerminalRuleCall_4_3_1_0 = (RuleCall)cPatternAssignment_4_3_1.eContents().get(0);
		private final Group cGroup_4_4 = (Group)cUnorderedGroup_4.eContents().get(4);
		private final Keyword cLangRangeKeyword_4_4_0 = (Keyword)cGroup_4_4.eContents().get(0);
		private final Assignment cLangRangeAssignment_4_4_1 = (Assignment)cGroup_4_4.eContents().get(1);
		private final RuleCall cLangRangeLANG_TAGTerminalRuleCall_4_4_1_0 = (RuleCall)cLangRangeAssignment_4_4_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//PlainLiteralScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'plainLiteralScalarRestriction' name=ID
		//	'{' (('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//	maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)? & ('langRange' langRange=LANG_TAG)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'plainLiteralScalarRestriction' name=ID '{' (('length'
		//length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)? & ('langRange' langRange=LANG_TAG)?)
		//'restrictedRange' restrictedRange=[DataRange|Reference] '}'
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
		
		//('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)? & ('langRange' langRange=LANG_TAG)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('length' length=PositiveIntegerLiteral)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'length'
		public Keyword getLengthKeyword_4_0_0() { return cLengthKeyword_4_0_0; }
		
		//length=PositiveIntegerLiteral
		public Assignment getLengthAssignment_4_0_1() { return cLengthAssignment_4_0_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0() { return cLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0; }
		
		//('minLength' minLength=PositiveIntegerLiteral)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_4_1_0() { return cMinLengthKeyword_4_1_0; }
		
		//minLength=PositiveIntegerLiteral
		public Assignment getMinLengthAssignment_4_1_1() { return cMinLengthAssignment_4_1_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0() { return cMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0; }
		
		//('maxLength' maxLength=PositiveIntegerLiteral)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_4_2_0() { return cMaxLengthKeyword_4_2_0; }
		
		//maxLength=PositiveIntegerLiteral
		public Assignment getMaxLengthAssignment_4_2_1() { return cMaxLengthAssignment_4_2_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0() { return cMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0; }
		
		//('pattern' pattern=PATTERN)?
		public Group getGroup_4_3() { return cGroup_4_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_4_3_0() { return cPatternKeyword_4_3_0; }
		
		//pattern=PATTERN
		public Assignment getPatternAssignment_4_3_1() { return cPatternAssignment_4_3_1; }
		
		//PATTERN
		public RuleCall getPatternPATTERNTerminalRuleCall_4_3_1_0() { return cPatternPATTERNTerminalRuleCall_4_3_1_0; }
		
		//('langRange' langRange=LANG_TAG)?
		public Group getGroup_4_4() { return cGroup_4_4; }
		
		//'langRange'
		public Keyword getLangRangeKeyword_4_4_0() { return cLangRangeKeyword_4_4_0; }
		
		//langRange=LANG_TAG
		public Assignment getLangRangeAssignment_4_4_1() { return cLangRangeAssignment_4_4_1; }
		
		//LANG_TAG
		public RuleCall getLangRangeLANG_TAGTerminalRuleCall_4_4_1_0() { return cLangRangeLANG_TAGTerminalRuleCall_4_4_1_0; }
		
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
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cCircumflexAccentCircumflexAccentKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cValueTypeAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final CrossReference cValueTypeDataRangeCrossReference_5_1_0 = (CrossReference)cValueTypeAssignment_5_1.eContents().get(0);
		private final RuleCall cValueTypeDataRangeReferenceParserRuleCall_5_1_0_1 = (RuleCall)cValueTypeDataRangeCrossReference_5_1_0.eContents().get(1);
		
		//ScalarOneOfLiteralAxiom:
		//	annotations+=AnnotationPropertyValue*
		//	'oneOf'
		//	axiom=[ScalarOneOfRestriction|Reference]
		//	'=' value=LiteralValue ('^^' valueType=[DataRange|Reference])?;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'oneOf' axiom=[ScalarOneOfRestriction|Reference] '=' value=LiteralValue ('^^'
		//valueType=[DataRange|Reference])?
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
		
		//('^^' valueType=[DataRange|Reference])?
		public Group getGroup_5() { return cGroup_5; }
		
		//'^^'
		public Keyword getCircumflexAccentCircumflexAccentKeyword_5_0() { return cCircumflexAccentCircumflexAccentKeyword_5_0; }
		
		//valueType=[DataRange|Reference]
		public Assignment getValueTypeAssignment_5_1() { return cValueTypeAssignment_5_1; }
		
		//[DataRange|Reference]
		public CrossReference getValueTypeDataRangeCrossReference_5_1_0() { return cValueTypeDataRangeCrossReference_5_1_0; }
		
		//Reference
		public RuleCall getValueTypeDataRangeReferenceParserRuleCall_5_1_0_1() { return cValueTypeDataRangeReferenceParserRuleCall_5_1_0_1; }
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
		private final RuleCall cLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0 = (RuleCall)cLengthAssignment_4_0_1.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Keyword cMinLengthKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0 = (RuleCall)cMinLengthAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cMaxLengthKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0 = (RuleCall)cMaxLengthAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_4_3 = (Group)cUnorderedGroup_4.eContents().get(3);
		private final Keyword cPatternKeyword_4_3_0 = (Keyword)cGroup_4_3.eContents().get(0);
		private final Assignment cPatternAssignment_4_3_1 = (Assignment)cGroup_4_3.eContents().get(1);
		private final RuleCall cPatternPATTERNTerminalRuleCall_4_3_1_0 = (RuleCall)cPatternAssignment_4_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRestrictedRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_6_0 = (CrossReference)cRestrictedRangeAssignment_6.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//StringScalarRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'stringScalarRestriction' name=ID
		//	'{' (('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//	maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'stringScalarRestriction' name=ID '{' (('length' length=PositiveIntegerLiteral)? &
		//('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength' maxLength=PositiveIntegerLiteral)? & ('pattern'
		//pattern=PATTERN)?) 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
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
		
		//('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
		//maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }
		
		//('length' length=PositiveIntegerLiteral)?
		public Group getGroup_4_0() { return cGroup_4_0; }
		
		//'length'
		public Keyword getLengthKeyword_4_0_0() { return cLengthKeyword_4_0_0; }
		
		//length=PositiveIntegerLiteral
		public Assignment getLengthAssignment_4_0_1() { return cLengthAssignment_4_0_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0() { return cLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0; }
		
		//('minLength' minLength=PositiveIntegerLiteral)?
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_4_1_0() { return cMinLengthKeyword_4_1_0; }
		
		//minLength=PositiveIntegerLiteral
		public Assignment getMinLengthAssignment_4_1_1() { return cMinLengthAssignment_4_1_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0() { return cMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0; }
		
		//('maxLength' maxLength=PositiveIntegerLiteral)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_4_2_0() { return cMaxLengthKeyword_4_2_0; }
		
		//maxLength=PositiveIntegerLiteral
		public Assignment getMaxLengthAssignment_4_2_1() { return cMaxLengthAssignment_4_2_1; }
		
		//PositiveIntegerLiteral
		public RuleCall getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0() { return cMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0; }
		
		//('pattern' pattern=PATTERN)?
		public Group getGroup_4_3() { return cGroup_4_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_4_3_0() { return cPatternKeyword_4_3_0; }
		
		//pattern=PATTERN
		public Assignment getPatternAssignment_4_3_1() { return cPatternAssignment_4_3_1; }
		
		//PATTERN
		public RuleCall getPatternPATTERNTerminalRuleCall_4_3_1_0() { return cPatternPATTERNTerminalRuleCall_4_3_1_0; }
		
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
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cCircumflexAccentCircumflexAccentKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cValueTypeAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final CrossReference cValueTypeDataRangeCrossReference_6_1_0 = (CrossReference)cValueTypeAssignment_6_1.eContents().get(0);
		private final RuleCall cValueTypeDataRangeReferenceParserRuleCall_6_1_0_1 = (RuleCall)cValueTypeDataRangeCrossReference_6_1_0.eContents().get(1);
		
		//SingletonInstanceScalarDataPropertyValue:
		//	annotations+=AnnotationPropertyValue*
		//	singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		//	'.'
		//	scalarDataProperty=[EntityScalarDataProperty|Reference]
		//	'='
		//	scalarPropertyValue=LiteralValue ('^^' valueType=[DataRange|Reference])?;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* singletonInstance=[ConceptualEntitySingletonInstance|Reference] '.'
		//scalarDataProperty=[EntityScalarDataProperty|Reference] '=' scalarPropertyValue=LiteralValue ('^^'
		//valueType=[DataRange|Reference])?
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
		
		//('^^' valueType=[DataRange|Reference])?
		public Group getGroup_6() { return cGroup_6; }
		
		//'^^'
		public Keyword getCircumflexAccentCircumflexAccentKeyword_6_0() { return cCircumflexAccentCircumflexAccentKeyword_6_0; }
		
		//valueType=[DataRange|Reference]
		public Assignment getValueTypeAssignment_6_1() { return cValueTypeAssignment_6_1; }
		
		//[DataRange|Reference]
		public CrossReference getValueTypeDataRangeCrossReference_6_1_0() { return cValueTypeDataRangeCrossReference_6_1_0; }
		
		//Reference
		public RuleCall getValueTypeDataRangeReferenceParserRuleCall_6_1_0_1() { return cValueTypeDataRangeReferenceParserRuleCall_6_1_0_1; }
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
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCircumflexAccentCircumflexAccentKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cValueTypeAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cValueTypeDataRangeCrossReference_4_1_0 = (CrossReference)cValueTypeAssignment_4_1.eContents().get(0);
		private final RuleCall cValueTypeDataRangeReferenceParserRuleCall_4_1_0_1 = (RuleCall)cValueTypeDataRangeCrossReference_4_1_0.eContents().get(1);
		
		//ScalarDataPropertyValue:
		//	annotations+=AnnotationPropertyValue*
		//	scalarDataProperty=[DataRelationshipToScalar|Reference]
		//	'='
		//	scalarPropertyValue=LiteralValue ('^^' valueType=[DataRange|Reference])?;
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* scalarDataProperty=[DataRelationshipToScalar|Reference] '='
		//scalarPropertyValue=LiteralValue ('^^' valueType=[DataRange|Reference])?
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
		
		//('^^' valueType=[DataRange|Reference])?
		public Group getGroup_4() { return cGroup_4; }
		
		//'^^'
		public Keyword getCircumflexAccentCircumflexAccentKeyword_4_0() { return cCircumflexAccentCircumflexAccentKeyword_4_0; }
		
		//valueType=[DataRange|Reference]
		public Assignment getValueTypeAssignment_4_1() { return cValueTypeAssignment_4_1; }
		
		//[DataRange|Reference]
		public CrossReference getValueTypeDataRangeCrossReference_4_1_0() { return cValueTypeDataRangeCrossReference_4_1_0; }
		
		//Reference
		public RuleCall getValueTypeDataRangeReferenceParserRuleCall_4_1_0_1() { return cValueTypeDataRangeReferenceParserRuleCall_4_1_0_1; }
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
		private final Assignment cSingletonConceptualRelationshipClassifierAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cSingletonConceptualRelationshipClassifierConceptualRelationshipCrossReference_5_0 = (CrossReference)cSingletonConceptualRelationshipClassifierAssignment_5.eContents().get(0);
		private final RuleCall cSingletonConceptualRelationshipClassifierConceptualRelationshipReferenceParserRuleCall_5_0_1 = (RuleCall)cSingletonConceptualRelationshipClassifierConceptualRelationshipCrossReference_5_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ReifiedRelationshipInstance:
		//	annotations+=AnnotationPropertyValue*
		//	'reifiedRelationshipInstance' '(' name=ID 'is-a'
		//	singletonConceptualRelationshipClassifier=[ConceptualRelationship|Reference] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'reifiedRelationshipInstance' '(' name=ID 'is-a'
		//singletonConceptualRelationshipClassifier=[ConceptualRelationship|Reference] ')'
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
		
		//singletonConceptualRelationshipClassifier=[ConceptualRelationship|Reference]
		public Assignment getSingletonConceptualRelationshipClassifierAssignment_5() { return cSingletonConceptualRelationshipClassifierAssignment_5; }
		
		//[ConceptualRelationship|Reference]
		public CrossReference getSingletonConceptualRelationshipClassifierConceptualRelationshipCrossReference_5_0() { return cSingletonConceptualRelationshipClassifierConceptualRelationshipCrossReference_5_0; }
		
		//Reference
		public RuleCall getSingletonConceptualRelationshipClassifierConceptualRelationshipReferenceParserRuleCall_5_0_1() { return cSingletonConceptualRelationshipClassifierConceptualRelationshipReferenceParserRuleCall_5_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }
	}
	public class InstanceRelationshipEnumerationRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.InstanceRelationshipEnumerationRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cDomainAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cDomainConceptualEntitySingletonInstanceCrossReference_1_0 = (CrossReference)cDomainAssignment_1.eContents().get(0);
		private final RuleCall cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1 = (RuleCall)cDomainConceptualEntitySingletonInstanceCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cRestrictedRelationshipAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_3_0 = (CrossReference)cRestrictedRelationshipAssignment_3.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_3_0.eContents().get(1);
		private final Keyword cInKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cReferencesAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cReferencesInstanceRelationshipOneOfRestrictionParserRuleCall_6_0 = (RuleCall)cReferencesAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//InstanceRelationshipEnumerationRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	domain=[ConceptualEntitySingletonInstance|Reference]
		//	'.' restrictedRelationship=[RestrictableRelationship|Reference]
		//	'in' '{' references+=InstanceRelationshipOneOfRestriction* '}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* domain=[ConceptualEntitySingletonInstance|Reference] '.'
		//restrictedRelationship=[RestrictableRelationship|Reference] 'in' '{' references+=InstanceRelationshipOneOfRestriction*
		//'}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getDomainAssignment_1() { return cDomainAssignment_1; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getDomainConceptualEntitySingletonInstanceCrossReference_1_0() { return cDomainConceptualEntitySingletonInstanceCrossReference_1_0; }
		
		//Reference
		public RuleCall getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1() { return cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//restrictedRelationship=[RestrictableRelationship|Reference]
		public Assignment getRestrictedRelationshipAssignment_3() { return cRestrictedRelationshipAssignment_3; }
		
		//[RestrictableRelationship|Reference]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_3_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_3_0_1() { return cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_3_0_1; }
		
		//'in'
		public Keyword getInKeyword_4() { return cInKeyword_4; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//references+=InstanceRelationshipOneOfRestriction*
		public Assignment getReferencesAssignment_6() { return cReferencesAssignment_6; }
		
		//InstanceRelationshipOneOfRestriction
		public RuleCall getReferencesInstanceRelationshipOneOfRestrictionParserRuleCall_6_0() { return cReferencesInstanceRelationshipOneOfRestrictionParserRuleCall_6_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class InstanceRelationshipOneOfRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.InstanceRelationshipOneOfRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cRangeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRangeConceptualEntitySingletonInstanceCrossReference_1_0 = (CrossReference)cRangeAssignment_1.eContents().get(0);
		private final RuleCall cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1 = (RuleCall)cRangeConceptualEntitySingletonInstanceCrossReference_1_0.eContents().get(1);
		
		//InstanceRelationshipOneOfRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	range=[ConceptualEntitySingletonInstance|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* range=[ConceptualEntitySingletonInstance|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//range=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getRangeAssignment_1() { return cRangeAssignment_1; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getRangeConceptualEntitySingletonInstanceCrossReference_1_0() { return cRangeConceptualEntitySingletonInstanceCrossReference_1_0; }
		
		//Reference
		public RuleCall getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1() { return cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1; }
	}
	public class InstanceRelationshipValueRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.InstanceRelationshipValueRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cDomainAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cDomainConceptualEntitySingletonInstanceCrossReference_1_0 = (CrossReference)cDomainAssignment_1.eContents().get(0);
		private final RuleCall cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1 = (RuleCall)cDomainConceptualEntitySingletonInstanceCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cRestrictedRelationshipAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_3_0 = (CrossReference)cRestrictedRelationshipAssignment_3.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_3_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRangeConceptualEntitySingletonInstanceCrossReference_5_0 = (CrossReference)cRangeAssignment_5.eContents().get(0);
		private final RuleCall cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1 = (RuleCall)cRangeConceptualEntitySingletonInstanceCrossReference_5_0.eContents().get(1);
		
		//InstanceRelationshipValueRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	domain=[ConceptualEntitySingletonInstance|Reference]
		//	'.' restrictedRelationship=[RestrictableRelationship|Reference]
		//	'=' range=[ConceptualEntitySingletonInstance|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* domain=[ConceptualEntitySingletonInstance|Reference] '.'
		//restrictedRelationship=[RestrictableRelationship|Reference] '=' range=[ConceptualEntitySingletonInstance|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getDomainAssignment_1() { return cDomainAssignment_1; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getDomainConceptualEntitySingletonInstanceCrossReference_1_0() { return cDomainConceptualEntitySingletonInstanceCrossReference_1_0; }
		
		//Reference
		public RuleCall getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1() { return cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//restrictedRelationship=[RestrictableRelationship|Reference]
		public Assignment getRestrictedRelationshipAssignment_3() { return cRestrictedRelationshipAssignment_3; }
		
		//[RestrictableRelationship|Reference]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_3_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_3_0_1() { return cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_3_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }
		
		//range=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getRangeAssignment_5() { return cRangeAssignment_5; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getRangeConceptualEntitySingletonInstanceCrossReference_5_0() { return cRangeConceptualEntitySingletonInstanceCrossReference_5_0; }
		
		//Reference
		public RuleCall getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1() { return cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1; }
	}
	public class InstanceRelationshipExistentialRangeRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.InstanceRelationshipExistentialRangeRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cSomeEntitiesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDomainAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cDomainConceptualEntitySingletonInstanceCrossReference_2_0 = (CrossReference)cDomainAssignment_2.eContents().get(0);
		private final RuleCall cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_2_0_1 = (RuleCall)cDomainConceptualEntitySingletonInstanceCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRestrictedRelationshipAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0 = (CrossReference)cRestrictedRelationshipAssignment_4.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_4_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRangeEntityCrossReference_6_0 = (CrossReference)cRangeAssignment_6.eContents().get(0);
		private final RuleCall cRangeEntityReferenceParserRuleCall_6_0_1 = (RuleCall)cRangeEntityCrossReference_6_0.eContents().get(1);
		
		//InstanceRelationshipExistentialRangeRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'someEntities'
		//	domain=[ConceptualEntitySingletonInstance|Reference]
		//	'.' restrictedRelationship=[RestrictableRelationship|Reference]
		//	'in' range=[Entity|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'someEntities' domain=[ConceptualEntitySingletonInstance|Reference] '.'
		//restrictedRelationship=[RestrictableRelationship|Reference] 'in' range=[Entity|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'someEntities'
		public Keyword getSomeEntitiesKeyword_1() { return cSomeEntitiesKeyword_1; }
		
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getDomainAssignment_2() { return cDomainAssignment_2; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getDomainConceptualEntitySingletonInstanceCrossReference_2_0() { return cDomainConceptualEntitySingletonInstanceCrossReference_2_0; }
		
		//Reference
		public RuleCall getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_2_0_1() { return cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//restrictedRelationship=[RestrictableRelationship|Reference]
		public Assignment getRestrictedRelationshipAssignment_4() { return cRestrictedRelationshipAssignment_4; }
		
		//[RestrictableRelationship|Reference]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0; }
		
		//Reference
		public RuleCall getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_4_0_1() { return cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//range=[Entity|Reference]
		public Assignment getRangeAssignment_6() { return cRangeAssignment_6; }
		
		//[Entity|Reference]
		public CrossReference getRangeEntityCrossReference_6_0() { return cRangeEntityCrossReference_6_0; }
		
		//Reference
		public RuleCall getRangeEntityReferenceParserRuleCall_6_0_1() { return cRangeEntityReferenceParserRuleCall_6_0_1; }
	}
	public class InstanceRelationshipUniversalRangeRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.InstanceRelationshipUniversalRangeRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationPropertyValueParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Keyword cAllEntitiesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDomainAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cDomainConceptualEntitySingletonInstanceCrossReference_2_0 = (CrossReference)cDomainAssignment_2.eContents().get(0);
		private final RuleCall cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_2_0_1 = (RuleCall)cDomainConceptualEntitySingletonInstanceCrossReference_2_0.eContents().get(1);
		private final Keyword cFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRestrictedRelationshipAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0 = (CrossReference)cRestrictedRelationshipAssignment_4.eContents().get(0);
		private final RuleCall cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_4_0_1 = (RuleCall)cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRangeEntityCrossReference_6_0 = (CrossReference)cRangeAssignment_6.eContents().get(0);
		private final RuleCall cRangeEntityReferenceParserRuleCall_6_0_1 = (RuleCall)cRangeEntityCrossReference_6_0.eContents().get(1);
		
		//InstanceRelationshipUniversalRangeRestriction:
		//	annotations+=AnnotationPropertyValue*
		//	'allEntities'
		//	domain=[ConceptualEntitySingletonInstance|Reference]
		//	'.' restrictedRelationship=[RestrictableRelationship|Reference]
		//	'in' range=[Entity|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=AnnotationPropertyValue* 'allEntities' domain=[ConceptualEntitySingletonInstance|Reference] '.'
		//restrictedRelationship=[RestrictableRelationship|Reference] 'in' range=[Entity|Reference]
		public Group getGroup() { return cGroup; }
		
		//annotations+=AnnotationPropertyValue*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//AnnotationPropertyValue
		public RuleCall getAnnotationsAnnotationPropertyValueParserRuleCall_0_0() { return cAnnotationsAnnotationPropertyValueParserRuleCall_0_0; }
		
		//'allEntities'
		public Keyword getAllEntitiesKeyword_1() { return cAllEntitiesKeyword_1; }
		
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getDomainAssignment_2() { return cDomainAssignment_2; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getDomainConceptualEntitySingletonInstanceCrossReference_2_0() { return cDomainConceptualEntitySingletonInstanceCrossReference_2_0; }
		
		//Reference
		public RuleCall getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_2_0_1() { return cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_2_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_3() { return cFullStopKeyword_3; }
		
		//restrictedRelationship=[RestrictableRelationship|Reference]
		public Assignment getRestrictedRelationshipAssignment_4() { return cRestrictedRelationshipAssignment_4; }
		
		//[RestrictableRelationship|Reference]
		public CrossReference getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0() { return cRestrictedRelationshipRestrictableRelationshipCrossReference_4_0; }
		
		//Reference
		public RuleCall getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_4_0_1() { return cRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//range=[Entity|Reference]
		public Assignment getRangeAssignment_6() { return cRangeAssignment_6; }
		
		//[Entity|Reference]
		public CrossReference getRangeEntityCrossReference_6_0() { return cRangeEntityCrossReference_6_0; }
		
		//Reference
		public RuleCall getRangeEntityReferenceParserRuleCall_6_0_1() { return cRangeEntityReferenceParserRuleCall_6_0_1; }
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
	public class LiteralValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralBooleanParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLiteralDateTimeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLiteralStringParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLiteralUUIDParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cLiteralURIParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cLiteralNumberParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		////----------------------------
		//LiteralValue:
		//	LiteralBoolean | LiteralDateTime | LiteralString | LiteralUUID | LiteralURI | LiteralNumber;
		@Override public ParserRule getRule() { return rule; }
		
		//LiteralBoolean | LiteralDateTime | LiteralString | LiteralUUID | LiteralURI | LiteralNumber
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//LiteralBoolean
		public RuleCall getLiteralBooleanParserRuleCall_0() { return cLiteralBooleanParserRuleCall_0; }
		
		//LiteralDateTime
		public RuleCall getLiteralDateTimeParserRuleCall_1() { return cLiteralDateTimeParserRuleCall_1; }
		
		//LiteralString
		public RuleCall getLiteralStringParserRuleCall_2() { return cLiteralStringParserRuleCall_2; }
		
		//LiteralUUID
		public RuleCall getLiteralUUIDParserRuleCall_3() { return cLiteralUUIDParserRuleCall_3; }
		
		//LiteralURI
		public RuleCall getLiteralURIParserRuleCall_4() { return cLiteralURIParserRuleCall_4; }
		
		//LiteralNumber
		public RuleCall getLiteralNumberParserRuleCall_5() { return cLiteralNumberParserRuleCall_5; }
	}
	public class LiteralBooleanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralBoolean");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralBooleanAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cBoolAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cBoolAlternatives_1_0 = (Alternatives)cBoolAssignment_1.eContents().get(0);
		private final RuleCall cBoolTRUETerminalRuleCall_1_0_0 = (RuleCall)cBoolAlternatives_1_0.eContents().get(0);
		private final RuleCall cBoolFALSETerminalRuleCall_1_0_1 = (RuleCall)cBoolAlternatives_1_0.eContents().get(1);
		
		//LiteralBoolean:
		//	{LiteralBoolean} bool=(TRUE | FALSE);
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralBoolean} bool=(TRUE | FALSE)
		public Group getGroup() { return cGroup; }
		
		//{LiteralBoolean}
		public Action getLiteralBooleanAction_0() { return cLiteralBooleanAction_0; }
		
		//bool=(TRUE | FALSE)
		public Assignment getBoolAssignment_1() { return cBoolAssignment_1; }
		
		//(TRUE | FALSE)
		public Alternatives getBoolAlternatives_1_0() { return cBoolAlternatives_1_0; }
		
		//TRUE
		public RuleCall getBoolTRUETerminalRuleCall_1_0_0() { return cBoolTRUETerminalRuleCall_1_0_0; }
		
		//FALSE
		public RuleCall getBoolFALSETerminalRuleCall_1_0_1() { return cBoolFALSETerminalRuleCall_1_0_1; }
	}
	public class LiteralDateTimeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralDateTimeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cDateTimeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cDateTimeDATE_TIMETerminalRuleCall_1_0 = (RuleCall)cDateTimeAssignment_1.eContents().get(0);
		
		//LiteralDateTime:
		//	{LiteralDateTime} dateTime=DATE_TIME;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralDateTime} dateTime=DATE_TIME
		public Group getGroup() { return cGroup; }
		
		//{LiteralDateTime}
		public Action getLiteralDateTimeAction_0() { return cLiteralDateTimeAction_0; }
		
		//dateTime=DATE_TIME
		public Assignment getDateTimeAssignment_1() { return cDateTimeAssignment_1; }
		
		//DATE_TIME
		public RuleCall getDateTimeDATE_TIMETerminalRuleCall_1_0() { return cDateTimeDATE_TIMETerminalRuleCall_1_0; }
	}
	public class LiteralStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralString");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralQuotedStringParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLiteralRawStringParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//LiteralString:
		//	LiteralQuotedString | LiteralRawString;
		@Override public ParserRule getRule() { return rule; }
		
		//LiteralQuotedString | LiteralRawString
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//LiteralQuotedString
		public RuleCall getLiteralQuotedStringParserRuleCall_0() { return cLiteralQuotedStringParserRuleCall_0; }
		
		//LiteralRawString
		public RuleCall getLiteralRawStringParserRuleCall_1() { return cLiteralRawStringParserRuleCall_1; }
	}
	public class LiteralQuotedStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralQuotedString");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralQuotedStringAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cStringAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cStringQUOTED_STRING_VALUETerminalRuleCall_1_0 = (RuleCall)cStringAssignment_1.eContents().get(0);
		
		//LiteralQuotedString:
		//	{LiteralQuotedString} string=QUOTED_STRING_VALUE;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralQuotedString} string=QUOTED_STRING_VALUE
		public Group getGroup() { return cGroup; }
		
		//{LiteralQuotedString}
		public Action getLiteralQuotedStringAction_0() { return cLiteralQuotedStringAction_0; }
		
		//string=QUOTED_STRING_VALUE
		public Assignment getStringAssignment_1() { return cStringAssignment_1; }
		
		//QUOTED_STRING_VALUE
		public RuleCall getStringQUOTED_STRING_VALUETerminalRuleCall_1_0() { return cStringQUOTED_STRING_VALUETerminalRuleCall_1_0; }
	}
	public class LiteralRawStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralRawString");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralRawStringAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cStringAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cStringRAW_STRING_VALUETerminalRuleCall_1_0 = (RuleCall)cStringAssignment_1.eContents().get(0);
		
		//LiteralRawString:
		//	{LiteralRawString} string=RAW_STRING_VALUE;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralRawString} string=RAW_STRING_VALUE
		public Group getGroup() { return cGroup; }
		
		//{LiteralRawString}
		public Action getLiteralRawStringAction_0() { return cLiteralRawStringAction_0; }
		
		//string=RAW_STRING_VALUE
		public Assignment getStringAssignment_1() { return cStringAssignment_1; }
		
		//RAW_STRING_VALUE
		public RuleCall getStringRAW_STRING_VALUETerminalRuleCall_1_0() { return cStringRAW_STRING_VALUETerminalRuleCall_1_0; }
	}
	public class UUIDDataTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UUIDDataType");
		private final RuleCall cUUIDTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//UUIDDataType UUIDDataType:
		//	UUID;
		@Override public ParserRule getRule() { return rule; }
		
		//UUID
		public RuleCall getUUIDTerminalRuleCall() { return cUUIDTerminalRuleCall; }
	}
	public class LiteralUUIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralUUID");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralUUIDAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cUuidAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cUuidUUIDDataTypeParserRuleCall_1_0 = (RuleCall)cUuidAssignment_1.eContents().get(0);
		
		//LiteralUUID:
		//	{LiteralUUID} uuid=UUIDDataType;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralUUID} uuid=UUIDDataType
		public Group getGroup() { return cGroup; }
		
		//{LiteralUUID}
		public Action getLiteralUUIDAction_0() { return cLiteralUUIDAction_0; }
		
		//uuid=UUIDDataType
		public Assignment getUuidAssignment_1() { return cUuidAssignment_1; }
		
		//UUIDDataType
		public RuleCall getUuidUUIDDataTypeParserRuleCall_1_0() { return cUuidUUIDDataTypeParserRuleCall_1_0; }
	}
	public class URIDataTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.URIDataType");
		private final RuleCall cURITerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//URIDataType URIDataType:
		//	URI;
		@Override public ParserRule getRule() { return rule; }
		
		//URI
		public RuleCall getURITerminalRuleCall() { return cURITerminalRuleCall; }
	}
	public class LiteralURIElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralURI");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralURIAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cUriAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cUriURIDataTypeParserRuleCall_1_0 = (RuleCall)cUriAssignment_1.eContents().get(0);
		
		//LiteralURI:
		//	{LiteralURI} uri=URIDataType;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralURI} uri=URIDataType
		public Group getGroup() { return cGroup; }
		
		//{LiteralURI}
		public Action getLiteralURIAction_0() { return cLiteralURIAction_0; }
		
		//uri=URIDataType
		public Assignment getUriAssignment_1() { return cUriAssignment_1; }
		
		//URIDataType
		public RuleCall getUriURIDataTypeParserRuleCall_1_0() { return cUriURIDataTypeParserRuleCall_1_0; }
	}
	public class LiteralNumberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralRealParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLiteralRationalParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLiteralFloatParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLiteralDecimalParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//LiteralNumber:
		//	LiteralReal | LiteralRational | LiteralFloat | LiteralDecimal;
		@Override public ParserRule getRule() { return rule; }
		
		//LiteralReal | LiteralRational | LiteralFloat | LiteralDecimal
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//LiteralReal
		public RuleCall getLiteralRealParserRuleCall_0() { return cLiteralRealParserRuleCall_0; }
		
		//LiteralRational
		public RuleCall getLiteralRationalParserRuleCall_1() { return cLiteralRationalParserRuleCall_1; }
		
		//LiteralFloat
		public RuleCall getLiteralFloatParserRuleCall_2() { return cLiteralFloatParserRuleCall_2; }
		
		//LiteralDecimal
		public RuleCall getLiteralDecimalParserRuleCall_3() { return cLiteralDecimalParserRuleCall_3; }
	}
	public class LiteralRealElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralReal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralRealAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cRealAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cRealREALTerminalRuleCall_1_0 = (RuleCall)cRealAssignment_1.eContents().get(0);
		
		//LiteralReal:
		//	{LiteralReal} real=REAL;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralReal} real=REAL
		public Group getGroup() { return cGroup; }
		
		//{LiteralReal}
		public Action getLiteralRealAction_0() { return cLiteralRealAction_0; }
		
		//real=REAL
		public Assignment getRealAssignment_1() { return cRealAssignment_1; }
		
		//REAL
		public RuleCall getRealREALTerminalRuleCall_1_0() { return cRealREALTerminalRuleCall_1_0; }
	}
	public class LiteralRationalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralRational");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralRationalAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cRationalAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cRationalRationalDataTypeParserRuleCall_1_0 = (RuleCall)cRationalAssignment_1.eContents().get(0);
		
		//LiteralRational:
		//	{LiteralRational} rational=RationalDataType;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralRational} rational=RationalDataType
		public Group getGroup() { return cGroup; }
		
		//{LiteralRational}
		public Action getLiteralRationalAction_0() { return cLiteralRationalAction_0; }
		
		//rational=RationalDataType
		public Assignment getRationalAssignment_1() { return cRationalAssignment_1; }
		
		//RationalDataType
		public RuleCall getRationalRationalDataTypeParserRuleCall_1_0() { return cRationalRationalDataTypeParserRuleCall_1_0; }
	}
	public class RationalDataTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RationalDataType");
		private final RuleCall cRATIONALTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//RationalDataType RationalDataType:
		//	RATIONAL;
		@Override public ParserRule getRule() { return rule; }
		
		//RATIONAL
		public RuleCall getRATIONALTerminalRuleCall() { return cRATIONALTerminalRuleCall; }
	}
	public class LiteralFloatElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralFloat");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLiteralFloatAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cFloatAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFloatFLOATTerminalRuleCall_1_0 = (RuleCall)cFloatAssignment_1.eContents().get(0);
		
		//LiteralFloat:
		//	{LiteralFloat} float=FLOAT;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralFloat} float=FLOAT
		public Group getGroup() { return cGroup; }
		
		//{LiteralFloat}
		public Action getLiteralFloatAction_0() { return cLiteralFloatAction_0; }
		
		//float=FLOAT
		public Assignment getFloatAssignment_1() { return cFloatAssignment_1; }
		
		//FLOAT
		public RuleCall getFloatFLOATTerminalRuleCall_1_0() { return cFloatFLOATTerminalRuleCall_1_0; }
	}
	public class LiteralDecimalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LiteralDecimal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cLiteralDecimalAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cDecimalAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cDecimalDIGITSTerminalRuleCall_0_1_0 = (RuleCall)cDecimalAssignment_0_1.eContents().get(0);
		private final Assignment cDecimalAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cDecimalDECIMALTerminalRuleCall_1_0 = (RuleCall)cDecimalAssignment_1.eContents().get(0);
		
		//LiteralDecimal:
		//	{LiteralDecimal} decimal=DIGITS | decimal=DECIMAL;
		@Override public ParserRule getRule() { return rule; }
		
		//{LiteralDecimal} decimal=DIGITS | decimal=DECIMAL
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{LiteralDecimal} decimal=DIGITS
		public Group getGroup_0() { return cGroup_0; }
		
		//{LiteralDecimal}
		public Action getLiteralDecimalAction_0_0() { return cLiteralDecimalAction_0_0; }
		
		//decimal=DIGITS
		public Assignment getDecimalAssignment_0_1() { return cDecimalAssignment_0_1; }
		
		//DIGITS
		public RuleCall getDecimalDIGITSTerminalRuleCall_0_1_0() { return cDecimalDIGITSTerminalRuleCall_0_1_0; }
		
		//decimal=DECIMAL
		public Assignment getDecimalAssignment_1() { return cDecimalAssignment_1; }
		
		//DECIMAL
		public RuleCall getDecimalDECIMALTerminalRuleCall_1_0() { return cDecimalDECIMALTerminalRuleCall_1_0; }
	}
	public class PositiveIntegerLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
		private final RuleCall cDIGITSTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//PositiveIntegerLiteral PositiveIntegerLiteral:
		//	DIGITS;
		@Override public ParserRule getRule() { return rule; }
		
		//DIGITS
		public RuleCall getDIGITSTerminalRuleCall() { return cDIGITSTerminalRuleCall; }
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
	public class CardinalityRestrictionKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.CardinalityRestrictionKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cMinEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cMinLessThanSignEqualsSignKeyword_0_0 = (Keyword)cMinEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cMaxEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cMaxGreaterThanSignEqualsSignKeyword_1_0 = (Keyword)cMaxEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cExactEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cExactEqualsSignEqualsSignKeyword_2_0 = (Keyword)cExactEnumLiteralDeclaration_2.eContents().get(0);
		
		//enum CardinalityRestrictionKind:
		//	Min='<=' |
		//	Max='>=' |
		//	Exact='==';
		public EnumRule getRule() { return rule; }
		
		//Min='<=' | Max='>=' | Exact='=='
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Min='<='
		public EnumLiteralDeclaration getMinEnumLiteralDeclaration_0() { return cMinEnumLiteralDeclaration_0; }
		
		//'<='
		public Keyword getMinLessThanSignEqualsSignKeyword_0_0() { return cMinLessThanSignEqualsSignKeyword_0_0; }
		
		//Max='>='
		public EnumLiteralDeclaration getMaxEnumLiteralDeclaration_1() { return cMaxEnumLiteralDeclaration_1; }
		
		//'>='
		public Keyword getMaxGreaterThanSignEqualsSignKeyword_1_0() { return cMaxGreaterThanSignEqualsSignKeyword_1_0; }
		
		//Exact='=='
		public EnumLiteralDeclaration getExactEnumLiteralDeclaration_2() { return cExactEnumLiteralDeclaration_2; }
		
		//'=='
		public Keyword getExactEqualsSignEqualsSignKeyword_2_0() { return cExactEqualsSignEqualsSignKeyword_2_0; }
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
	private final CardinalityRestrictionKindElements eCardinalityRestrictionKind;
	private final AspectElements pAspect;
	private final CardinalityRestrictedAspectElements pCardinalityRestrictedAspect;
	private final ConceptElements pConcept;
	private final CardinalityRestrictedConceptElements pCardinalityRestrictedConcept;
	private final ReifiedRelationshipElements pReifiedRelationship;
	private final ForwardPropertyElements pForwardProperty;
	private final InversePropertyElements pInverseProperty;
	private final ReifiedRelationshipRestrictionElements pReifiedRelationshipRestriction;
	private final CardinalityRestrictedReifiedRelationshipElements pCardinalityRestrictedReifiedRelationship;
	private final UnreifiedRelationshipElements pUnreifiedRelationship;
	private final ScalarElements pScalar;
	private final StructureElements pStructure;
	private final EntityStructuredDataPropertyElements pEntityStructuredDataProperty;
	private final EntityScalarDataPropertyElements pEntityScalarDataProperty;
	private final StructuredDataPropertyElements pStructuredDataProperty;
	private final ScalarDataPropertyElements pScalarDataProperty;
	private final RuleElements pRule;
	private final ChainRuleElements pChainRule;
	private final RuleBodySegmentElements pRuleBodySegment;
	private final SegmentPredicateElements pSegmentPredicate;
	private final AnonymousConceptUnionAxiomElements pAnonymousConceptUnionAxiom;
	private final RootConceptTaxonomyAxiomElements pRootConceptTaxonomyAxiom;
	private final SpecificDisjointConceptAxiomElements pSpecificDisjointConceptAxiom;
	private final EntityExistentialRestrictionAxiomElements pEntityExistentialRestrictionAxiom;
	private final EntityUniversalRestrictionAxiomElements pEntityUniversalRestrictionAxiom;
	private final AspectSpecializationAxiomElements pAspectSpecializationAxiom;
	private final ConceptSpecializationAxiomElements pConceptSpecializationAxiom;
	private final ReifiedRelationshipSpecializationAxiomElements pReifiedRelationshipSpecializationAxiom;
	private final SubObjectPropertyOfAxiomElements pSubObjectPropertyOfAxiom;
	private final SubDataPropertyOfAxiomElements pSubDataPropertyOfAxiom;
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
	private final InstanceRelationshipEnumerationRestrictionElements pInstanceRelationshipEnumerationRestriction;
	private final InstanceRelationshipOneOfRestrictionElements pInstanceRelationshipOneOfRestriction;
	private final InstanceRelationshipValueRestrictionElements pInstanceRelationshipValueRestriction;
	private final InstanceRelationshipExistentialRangeRestrictionElements pInstanceRelationshipExistentialRangeRestriction;
	private final InstanceRelationshipUniversalRangeRestrictionElements pInstanceRelationshipUniversalRangeRestriction;
	private final ReifiedRelationshipInstanceDomainElements pReifiedRelationshipInstanceDomain;
	private final ReifiedRelationshipInstanceRangeElements pReifiedRelationshipInstanceRange;
	private final UnreifiedRelationshipInstanceTupleElements pUnreifiedRelationshipInstanceTuple;
	private final ReferenceElements pReference;
	private final ExternalReferenceElements pExternalReference;
	private final QNAMEElements pQNAME;
	private final ValidIDElements pValidID;
	private final LiteralValueElements pLiteralValue;
	private final LiteralBooleanElements pLiteralBoolean;
	private final LiteralDateTimeElements pLiteralDateTime;
	private final LiteralStringElements pLiteralString;
	private final LiteralQuotedStringElements pLiteralQuotedString;
	private final LiteralRawStringElements pLiteralRawString;
	private final UUIDDataTypeElements pUUIDDataType;
	private final LiteralUUIDElements pLiteralUUID;
	private final URIDataTypeElements pURIDataType;
	private final LiteralURIElements pLiteralURI;
	private final LiteralNumberElements pLiteralNumber;
	private final LiteralRealElements pLiteralReal;
	private final LiteralRationalElements pLiteralRational;
	private final RationalDataTypeElements pRationalDataType;
	private final TerminalRule tRATIONAL;
	private final LiteralFloatElements pLiteralFloat;
	private final LiteralDecimalElements pLiteralDecimal;
	private final PositiveIntegerLiteralElements pPositiveIntegerLiteral;
	private final TerminalRule tFALSE;
	private final TerminalRule tTRUE;
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
	private final TerminalRule tURI;
	private final TerminalRule tCONSTANT_NAME;
	private final TerminalRule tREAL;
	private final TerminalRule tPATTERN;
	private final TerminalRule tQUOTED_STRING_VALUE;
	private final TerminalRule tRAW_STRING_VALUE;
	private final TerminalRule tIRI;
	private final TerminalRule tLETTER;
	private final TerminalRule tLETTER_DIGIT;
	private final TerminalRule tLETTER_DIGIT_PREFIX;
	private final TerminalRule tLETTER_DIGIT_SUFFIX;
	private final TerminalRule tABBREV_IRI;
	private final TerminalRule tLANG_TAG;
	private final TerminalRule tDATE_TIME;
	private final TerminalRule tUUID;
	private final TerminalRule tHEX_12DIGITS;
	private final TerminalRule tHEX_8DIGITS;
	private final TerminalRule tHEX_4DIGITS;
	private final TerminalRule tHEX_LETTER;
	private final TerminalRule tHEX_DIGIT;
	private final TerminalRule tHEX;
	private final TerminalRule tDIGITS;
	private final TerminalRule tDEC;
	private final TerminalRule tDECIMAL;
	private final TerminalRule tFLOAT;
	private final TerminalRule tID;
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
		this.eCardinalityRestrictionKind = new CardinalityRestrictionKindElements();
		this.pAspect = new AspectElements();
		this.pCardinalityRestrictedAspect = new CardinalityRestrictedAspectElements();
		this.pConcept = new ConceptElements();
		this.pCardinalityRestrictedConcept = new CardinalityRestrictedConceptElements();
		this.pReifiedRelationship = new ReifiedRelationshipElements();
		this.pForwardProperty = new ForwardPropertyElements();
		this.pInverseProperty = new InversePropertyElements();
		this.pReifiedRelationshipRestriction = new ReifiedRelationshipRestrictionElements();
		this.pCardinalityRestrictedReifiedRelationship = new CardinalityRestrictedReifiedRelationshipElements();
		this.pUnreifiedRelationship = new UnreifiedRelationshipElements();
		this.pScalar = new ScalarElements();
		this.pStructure = new StructureElements();
		this.pEntityStructuredDataProperty = new EntityStructuredDataPropertyElements();
		this.pEntityScalarDataProperty = new EntityScalarDataPropertyElements();
		this.pStructuredDataProperty = new StructuredDataPropertyElements();
		this.pScalarDataProperty = new ScalarDataPropertyElements();
		this.pRule = new RuleElements();
		this.pChainRule = new ChainRuleElements();
		this.pRuleBodySegment = new RuleBodySegmentElements();
		this.pSegmentPredicate = new SegmentPredicateElements();
		this.pAnonymousConceptUnionAxiom = new AnonymousConceptUnionAxiomElements();
		this.pRootConceptTaxonomyAxiom = new RootConceptTaxonomyAxiomElements();
		this.pSpecificDisjointConceptAxiom = new SpecificDisjointConceptAxiomElements();
		this.pEntityExistentialRestrictionAxiom = new EntityExistentialRestrictionAxiomElements();
		this.pEntityUniversalRestrictionAxiom = new EntityUniversalRestrictionAxiomElements();
		this.pAspectSpecializationAxiom = new AspectSpecializationAxiomElements();
		this.pConceptSpecializationAxiom = new ConceptSpecializationAxiomElements();
		this.pReifiedRelationshipSpecializationAxiom = new ReifiedRelationshipSpecializationAxiomElements();
		this.pSubObjectPropertyOfAxiom = new SubObjectPropertyOfAxiomElements();
		this.pSubDataPropertyOfAxiom = new SubDataPropertyOfAxiomElements();
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
		this.pInstanceRelationshipEnumerationRestriction = new InstanceRelationshipEnumerationRestrictionElements();
		this.pInstanceRelationshipOneOfRestriction = new InstanceRelationshipOneOfRestrictionElements();
		this.pInstanceRelationshipValueRestriction = new InstanceRelationshipValueRestrictionElements();
		this.pInstanceRelationshipExistentialRangeRestriction = new InstanceRelationshipExistentialRangeRestrictionElements();
		this.pInstanceRelationshipUniversalRangeRestriction = new InstanceRelationshipUniversalRangeRestrictionElements();
		this.pReifiedRelationshipInstanceDomain = new ReifiedRelationshipInstanceDomainElements();
		this.pReifiedRelationshipInstanceRange = new ReifiedRelationshipInstanceRangeElements();
		this.pUnreifiedRelationshipInstanceTuple = new UnreifiedRelationshipInstanceTupleElements();
		this.pReference = new ReferenceElements();
		this.pExternalReference = new ExternalReferenceElements();
		this.pQNAME = new QNAMEElements();
		this.pValidID = new ValidIDElements();
		this.pLiteralValue = new LiteralValueElements();
		this.pLiteralBoolean = new LiteralBooleanElements();
		this.pLiteralDateTime = new LiteralDateTimeElements();
		this.pLiteralString = new LiteralStringElements();
		this.pLiteralQuotedString = new LiteralQuotedStringElements();
		this.pLiteralRawString = new LiteralRawStringElements();
		this.pUUIDDataType = new UUIDDataTypeElements();
		this.pLiteralUUID = new LiteralUUIDElements();
		this.pURIDataType = new URIDataTypeElements();
		this.pLiteralURI = new LiteralURIElements();
		this.pLiteralNumber = new LiteralNumberElements();
		this.pLiteralReal = new LiteralRealElements();
		this.pLiteralRational = new LiteralRationalElements();
		this.pRationalDataType = new RationalDataTypeElements();
		this.tRATIONAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RATIONAL");
		this.pLiteralFloat = new LiteralFloatElements();
		this.pLiteralDecimal = new LiteralDecimalElements();
		this.pPositiveIntegerLiteral = new PositiveIntegerLiteralElements();
		this.tFALSE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.FALSE");
		this.tTRUE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TRUE");
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
		this.tURI = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.URI");
		this.tCONSTANT_NAME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.CONSTANT_NAME");
		this.tREAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.REAL");
		this.tPATTERN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.PATTERN");
		this.tQUOTED_STRING_VALUE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.QUOTED_STRING_VALUE");
		this.tRAW_STRING_VALUE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RAW_STRING_VALUE");
		this.tIRI = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IRI");
		this.tLETTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LETTER");
		this.tLETTER_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LETTER_DIGIT");
		this.tLETTER_DIGIT_PREFIX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LETTER_DIGIT_PREFIX");
		this.tLETTER_DIGIT_SUFFIX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LETTER_DIGIT_SUFFIX");
		this.tABBREV_IRI = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ABBREV_IRI");
		this.tLANG_TAG = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.LANG_TAG");
		this.tDATE_TIME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DATE_TIME");
		this.tUUID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UUID");
		this.tHEX_12DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_12DIGITS");
		this.tHEX_8DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_8DIGITS");
		this.tHEX_4DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_4DIGITS");
		this.tHEX_LETTER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_LETTER");
		this.tHEX_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_DIGIT");
		this.tHEX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX");
		this.tDIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
		this.tDEC = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DEC");
		this.tDECIMAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DECIMAL");
		this.tFLOAT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.FLOAT");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ID");
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
	//	{Extent} modules+=Module*;
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
	//	'=' value=LiteralString;
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
	//	annotationProperties+=AnnotationProperty*
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
	//	annotationProperties+=AnnotationProperty*
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
	//	annotationProperties+=AnnotationProperty*
	//	annotations+=AnnotationPropertyValue*
	//	kind=DescriptionKind 'descriptionBox' iri=IRI
	//	'{' (closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
	//	descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
	//	instanceRelationshipEnumerationRestrictions+=InstanceRelationshipEnumerationRestriction |
	//	instanceRelationshipValueRestrictions+=InstanceRelationshipValueRestriction |
	//	instanceRelationshipExistentialRangeRestrictions+=InstanceRelationshipExistentialRangeRestriction |
	//	instanceRelationshipUniversalRangeRestrictions+=InstanceRelationshipUniversalRangeRestriction |
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
	//	AtomicEntity | EntityRelationship | Datatype | DataRelationship | Rule;
	public TermElements getTermAccess() {
		return pTerm;
	}
	
	public ParserRule getTermRule() {
		return getTermAccess().getRule();
	}
	
	//AtomicEntity Entity:
	//	Aspect | CardinalityRestrictedAspect | Concept | CardinalityRestrictedConcept;
	public AtomicEntityElements getAtomicEntityAccess() {
		return pAtomicEntity;
	}
	
	public ParserRule getAtomicEntityRule() {
		return getAtomicEntityAccess().getRule();
	}
	
	//EntityRelationship:
	//	ReifiedRelationship | ReifiedRelationshipRestriction | CardinalityRestrictedReifiedRelationship |
	//	UnreifiedRelationship;
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
	//	ScalarOneOfLiteralAxiom | SpecializationAxiom | SubObjectPropertyOfAxiom | SubDataPropertyOfAxiom;
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
	
	//enum CardinalityRestrictionKind:
	//	Min='<=' |
	//	Max='>=' |
	//	Exact='==';
	public CardinalityRestrictionKindElements getCardinalityRestrictionKindAccess() {
		return eCardinalityRestrictionKind;
	}
	
	public EnumRule getCardinalityRestrictionKindRule() {
		return getCardinalityRestrictionKindAccess().getRule();
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
	
	//CardinalityRestrictedAspect:
	//	annotations+=AnnotationPropertyValue*
	//	'aspect' name=ID
	//	restrictionKind=CardinalityRestrictionKind
	//	restrictedCardinality=PositiveIntegerLiteral
	//	restrictedRelationship=[RestrictableRelationship|Reference] ('.' restrictedRange=[Entity|Reference])?;
	public CardinalityRestrictedAspectElements getCardinalityRestrictedAspectAccess() {
		return pCardinalityRestrictedAspect;
	}
	
	public ParserRule getCardinalityRestrictedAspectRule() {
		return getCardinalityRestrictedAspectAccess().getRule();
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
	
	//CardinalityRestrictedConcept:
	//	annotations+=AnnotationPropertyValue*
	//	'concept' name=ID
	//	restrictionKind=CardinalityRestrictionKind
	//	restrictedCardinality=PositiveIntegerLiteral
	//	restrictedRelationship=[RestrictableRelationship|Reference] ('.' restrictedRange=[Entity|Reference])?;
	public CardinalityRestrictedConceptElements getCardinalityRestrictedConceptAccess() {
		return pCardinalityRestrictedConcept;
	}
	
	public ParserRule getCardinalityRestrictedConceptRule() {
		return getCardinalityRestrictedConceptAccess().getRule();
	}
	
	//// 2 EntityRelationship Terms
	//ReifiedRelationship:
	//	annotations+=AnnotationPropertyValue*
	//	'reifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
	//	isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
	//	isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
	//	'unreified' '=' forwardProperty=ForwardProperty ('inverse' '=' inverseProperty=InverseProperty)?
	//	'source' '=' source=[Entity|Reference]
	//	'target' '=' target=[Entity|Reference]
	//	'}';
	public ReifiedRelationshipElements getReifiedRelationshipAccess() {
		return pReifiedRelationship;
	}
	
	public ParserRule getReifiedRelationshipRule() {
		return getReifiedRelationshipAccess().getRule();
	}
	
	//ForwardProperty:
	//	name=ID;
	public ForwardPropertyElements getForwardPropertyAccess() {
		return pForwardProperty;
	}
	
	public ParserRule getForwardPropertyRule() {
		return getForwardPropertyAccess().getRule();
	}
	
	//InverseProperty:
	//	name=ID;
	public InversePropertyElements getInversePropertyAccess() {
		return pInverseProperty;
	}
	
	public ParserRule getInversePropertyRule() {
		return getInversePropertyAccess().getRule();
	}
	
	//ReifiedRelationshipRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'reifiedRelationshipRestriction' name=ID '{'
	//	'source' '=' source=[Entity|Reference]
	//	'target' '=' target=[Entity|Reference]
	//	'}';
	public ReifiedRelationshipRestrictionElements getReifiedRelationshipRestrictionAccess() {
		return pReifiedRelationshipRestriction;
	}
	
	public ParserRule getReifiedRelationshipRestrictionRule() {
		return getReifiedRelationshipRestrictionAccess().getRule();
	}
	
	//CardinalityRestrictedReifiedRelationship:
	//	annotations+=AnnotationPropertyValue*
	//	'reifiedRelationship' name=ID
	//	restrictionKind=CardinalityRestrictionKind
	//	restrictedCardinality=PositiveIntegerLiteral
	//	restrictedRelationship=[RestrictableRelationship|Reference] ('.' restrictedRange=[Entity|Reference])?;
	public CardinalityRestrictedReifiedRelationshipElements getCardinalityRestrictedReifiedRelationshipAccess() {
		return pCardinalityRestrictedReifiedRelationship;
	}
	
	public ParserRule getCardinalityRestrictedReifiedRelationshipRule() {
		return getCardinalityRestrictedReifiedRelationshipAccess().getRule();
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
	
	//// 5 Rules
	//Rule:
	//	ChainRule;
	public RuleElements getRuleAccess() {
		return pRule;
	}
	
	public ParserRule getRuleRule() {
		return getRuleAccess().getRule();
	}
	
	//ChainRule:
	//	'rule' name=ID 'infers' head=[RestrictableRelationship|Reference] 'if' firstSegment=RuleBodySegment;
	public ChainRuleElements getChainRuleAccess() {
		return pChainRule;
	}
	
	public ParserRule getChainRuleRule() {
		return getChainRuleAccess().getRule();
	}
	
	//RuleBodySegment:
	//	predicate=SegmentPredicate ('&&' nextSegment=RuleBodySegment)?;
	public RuleBodySegmentElements getRuleBodySegmentAccess() {
		return pRuleBodySegment;
	}
	
	public ParserRule getRuleBodySegmentRule() {
		return getRuleBodySegmentAccess().getRule();
	}
	
	//SegmentPredicate:
	//	predicate=[Predicate|QNAME] |
	//	'source' '(' reifiedRelationshipSource=[ReifiedRelationship|QNAME] ')' |
	//	'invSource' '(' reifiedRelationshipInverseSource=[ReifiedRelationship|QNAME] ')' |
	//	'target' '(' reifiedRelationshipTarget=[ReifiedRelationship|QNAME] ')' |
	//	'invTarget' '(' reifiedRelationshipInverseTarget=[ReifiedRelationship|QNAME] ')' |
	//	'inv' '(' unreifiedRelationshipInverse=[UnreifiedRelationship|QNAME] ')';
	public SegmentPredicateElements getSegmentPredicateAccess() {
		return pSegmentPredicate;
	}
	
	public ParserRule getSegmentPredicateRule() {
		return getSegmentPredicateAccess().getRule();
	}
	
	//// 3 ConceptTreeDisjunctions and DisjointUnionOfConceptsAxioms
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
	//	'disjointLeaf' '(' disjointLeaf=[Concept|QNAME] ')';
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
	//	restrictedDomain=[Entity|QNAME]
	//	'.'
	//	restrictedRelationship=[RestrictableRelationship|QNAME]
	//	'in'
	//	restrictedRange=[Entity|QNAME];
	public EntityExistentialRestrictionAxiomElements getEntityExistentialRestrictionAxiomAccess() {
		return pEntityExistentialRestrictionAxiom;
	}
	
	public ParserRule getEntityExistentialRestrictionAxiomRule() {
		return getEntityExistentialRestrictionAxiomAccess().getRule();
	}
	
	//EntityUniversalRestrictionAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	'allEntities'
	//	restrictedDomain=[Entity|QNAME]
	//	'.'
	//	restrictedRelationship=[RestrictableRelationship|QNAME]
	//	'in'
	//	restrictedRange=[Entity|QNAME];
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
	//	subRelationship=[ConceptualRelationship|Reference] 'extendsRelationship'
	//	superRelationship=[ConceptualRelationship|Reference];
	public ReifiedRelationshipSpecializationAxiomElements getReifiedRelationshipSpecializationAxiomAccess() {
		return pReifiedRelationshipSpecializationAxiom;
	}
	
	public ParserRule getReifiedRelationshipSpecializationAxiomRule() {
		return getReifiedRelationshipSpecializationAxiomAccess().getRule();
	}
	
	//// 2 Sub*PropertyOfAxioms
	//SubObjectPropertyOfAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	subProperty=[UnreifiedRelationship|Reference]
	//	'subObjectPropertyOf'
	//	superProperty=[UnreifiedRelationship|Reference];
	public SubObjectPropertyOfAxiomElements getSubObjectPropertyOfAxiomAccess() {
		return pSubObjectPropertyOfAxiom;
	}
	
	public ParserRule getSubObjectPropertyOfAxiomRule() {
		return getSubObjectPropertyOfAxiomAccess().getRule();
	}
	
	//SubDataPropertyOfAxiom:
	//	annotations+=AnnotationPropertyValue*
	//	subProperty=[EntityScalarDataProperty|Reference]
	//	'subDataPropertyOf'
	//	superProperty=[EntityScalarDataProperty|Reference];
	public SubDataPropertyOfAxiomElements getSubDataPropertyOfAxiomAccess() {
		return pSubDataPropertyOfAxiom;
	}
	
	public ParserRule getSubDataPropertyOfAxiomRule() {
		return getSubDataPropertyOfAxiomAccess().getRule();
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
	//	'=' literalValue=LiteralValue ('^^' valueType=[DataRange|Reference])?;
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
	//	scalarPropertyValue=LiteralValue ('^^' valueType=[DataRange|Reference])?;
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
	//	'{' (('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
	//	maxLength=PositiveIntegerLiteral)?)
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
	//	'{' (('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
	//	maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)?)
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
	//	'{' (('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
	//	maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)? & ('langRange' langRange=LANG_TAG)?)
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
	//	'=' value=LiteralValue ('^^' valueType=[DataRange|Reference])?;
	public ScalarOneOfLiteralAxiomElements getScalarOneOfLiteralAxiomAccess() {
		return pScalarOneOfLiteralAxiom;
	}
	
	public ParserRule getScalarOneOfLiteralAxiomRule() {
		return getScalarOneOfLiteralAxiomAccess().getRule();
	}
	
	//StringScalarRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'stringScalarRestriction' name=ID
	//	'{' (('length' length=PositiveIntegerLiteral)? & ('minLength' minLength=PositiveIntegerLiteral)? & ('maxLength'
	//	maxLength=PositiveIntegerLiteral)? & ('pattern' pattern=PATTERN)?)
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
	//	scalarPropertyValue=LiteralValue ('^^' valueType=[DataRange|Reference])?;
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
	//	scalarPropertyValue=LiteralValue ('^^' valueType=[DataRange|Reference])?;
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
	//	singletonConceptualRelationshipClassifier=[ConceptualRelationship|Reference] ')';
	public ReifiedRelationshipInstanceElements getReifiedRelationshipInstanceAccess() {
		return pReifiedRelationshipInstance;
	}
	
	public ParserRule getReifiedRelationshipInstanceRule() {
		return getReifiedRelationshipInstanceAccess().getRule();
	}
	
	//InstanceRelationshipEnumerationRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	domain=[ConceptualEntitySingletonInstance|Reference]
	//	'.' restrictedRelationship=[RestrictableRelationship|Reference]
	//	'in' '{' references+=InstanceRelationshipOneOfRestriction* '}';
	public InstanceRelationshipEnumerationRestrictionElements getInstanceRelationshipEnumerationRestrictionAccess() {
		return pInstanceRelationshipEnumerationRestriction;
	}
	
	public ParserRule getInstanceRelationshipEnumerationRestrictionRule() {
		return getInstanceRelationshipEnumerationRestrictionAccess().getRule();
	}
	
	//InstanceRelationshipOneOfRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	range=[ConceptualEntitySingletonInstance|Reference];
	public InstanceRelationshipOneOfRestrictionElements getInstanceRelationshipOneOfRestrictionAccess() {
		return pInstanceRelationshipOneOfRestriction;
	}
	
	public ParserRule getInstanceRelationshipOneOfRestrictionRule() {
		return getInstanceRelationshipOneOfRestrictionAccess().getRule();
	}
	
	//InstanceRelationshipValueRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	domain=[ConceptualEntitySingletonInstance|Reference]
	//	'.' restrictedRelationship=[RestrictableRelationship|Reference]
	//	'=' range=[ConceptualEntitySingletonInstance|Reference];
	public InstanceRelationshipValueRestrictionElements getInstanceRelationshipValueRestrictionAccess() {
		return pInstanceRelationshipValueRestriction;
	}
	
	public ParserRule getInstanceRelationshipValueRestrictionRule() {
		return getInstanceRelationshipValueRestrictionAccess().getRule();
	}
	
	//InstanceRelationshipExistentialRangeRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'someEntities'
	//	domain=[ConceptualEntitySingletonInstance|Reference]
	//	'.' restrictedRelationship=[RestrictableRelationship|Reference]
	//	'in' range=[Entity|Reference];
	public InstanceRelationshipExistentialRangeRestrictionElements getInstanceRelationshipExistentialRangeRestrictionAccess() {
		return pInstanceRelationshipExistentialRangeRestriction;
	}
	
	public ParserRule getInstanceRelationshipExistentialRangeRestrictionRule() {
		return getInstanceRelationshipExistentialRangeRestrictionAccess().getRule();
	}
	
	//InstanceRelationshipUniversalRangeRestriction:
	//	annotations+=AnnotationPropertyValue*
	//	'allEntities'
	//	domain=[ConceptualEntitySingletonInstance|Reference]
	//	'.' restrictedRelationship=[RestrictableRelationship|Reference]
	//	'in' range=[Entity|Reference];
	public InstanceRelationshipUniversalRangeRestrictionElements getInstanceRelationshipUniversalRangeRestrictionAccess() {
		return pInstanceRelationshipUniversalRangeRestriction;
	}
	
	public ParserRule getInstanceRelationshipUniversalRangeRestrictionRule() {
		return getInstanceRelationshipUniversalRangeRestrictionAccess().getRule();
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
	//LiteralValue:
	//	LiteralBoolean | LiteralDateTime | LiteralString | LiteralUUID | LiteralURI | LiteralNumber;
	public LiteralValueElements getLiteralValueAccess() {
		return pLiteralValue;
	}
	
	public ParserRule getLiteralValueRule() {
		return getLiteralValueAccess().getRule();
	}
	
	//LiteralBoolean:
	//	{LiteralBoolean} bool=(TRUE | FALSE);
	public LiteralBooleanElements getLiteralBooleanAccess() {
		return pLiteralBoolean;
	}
	
	public ParserRule getLiteralBooleanRule() {
		return getLiteralBooleanAccess().getRule();
	}
	
	//LiteralDateTime:
	//	{LiteralDateTime} dateTime=DATE_TIME;
	public LiteralDateTimeElements getLiteralDateTimeAccess() {
		return pLiteralDateTime;
	}
	
	public ParserRule getLiteralDateTimeRule() {
		return getLiteralDateTimeAccess().getRule();
	}
	
	//LiteralString:
	//	LiteralQuotedString | LiteralRawString;
	public LiteralStringElements getLiteralStringAccess() {
		return pLiteralString;
	}
	
	public ParserRule getLiteralStringRule() {
		return getLiteralStringAccess().getRule();
	}
	
	//LiteralQuotedString:
	//	{LiteralQuotedString} string=QUOTED_STRING_VALUE;
	public LiteralQuotedStringElements getLiteralQuotedStringAccess() {
		return pLiteralQuotedString;
	}
	
	public ParserRule getLiteralQuotedStringRule() {
		return getLiteralQuotedStringAccess().getRule();
	}
	
	//LiteralRawString:
	//	{LiteralRawString} string=RAW_STRING_VALUE;
	public LiteralRawStringElements getLiteralRawStringAccess() {
		return pLiteralRawString;
	}
	
	public ParserRule getLiteralRawStringRule() {
		return getLiteralRawStringAccess().getRule();
	}
	
	//UUIDDataType UUIDDataType:
	//	UUID;
	public UUIDDataTypeElements getUUIDDataTypeAccess() {
		return pUUIDDataType;
	}
	
	public ParserRule getUUIDDataTypeRule() {
		return getUUIDDataTypeAccess().getRule();
	}
	
	//LiteralUUID:
	//	{LiteralUUID} uuid=UUIDDataType;
	public LiteralUUIDElements getLiteralUUIDAccess() {
		return pLiteralUUID;
	}
	
	public ParserRule getLiteralUUIDRule() {
		return getLiteralUUIDAccess().getRule();
	}
	
	//URIDataType URIDataType:
	//	URI;
	public URIDataTypeElements getURIDataTypeAccess() {
		return pURIDataType;
	}
	
	public ParserRule getURIDataTypeRule() {
		return getURIDataTypeAccess().getRule();
	}
	
	//LiteralURI:
	//	{LiteralURI} uri=URIDataType;
	public LiteralURIElements getLiteralURIAccess() {
		return pLiteralURI;
	}
	
	public ParserRule getLiteralURIRule() {
		return getLiteralURIAccess().getRule();
	}
	
	//LiteralNumber:
	//	LiteralReal | LiteralRational | LiteralFloat | LiteralDecimal;
	public LiteralNumberElements getLiteralNumberAccess() {
		return pLiteralNumber;
	}
	
	public ParserRule getLiteralNumberRule() {
		return getLiteralNumberAccess().getRule();
	}
	
	//LiteralReal:
	//	{LiteralReal} real=REAL;
	public LiteralRealElements getLiteralRealAccess() {
		return pLiteralReal;
	}
	
	public ParserRule getLiteralRealRule() {
		return getLiteralRealAccess().getRule();
	}
	
	//LiteralRational:
	//	{LiteralRational} rational=RationalDataType;
	public LiteralRationalElements getLiteralRationalAccess() {
		return pLiteralRational;
	}
	
	public ParserRule getLiteralRationalRule() {
		return getLiteralRationalAccess().getRule();
	}
	
	//RationalDataType RationalDataType:
	//	RATIONAL;
	public RationalDataTypeElements getRationalDataTypeAccess() {
		return pRationalDataType;
	}
	
	public ParserRule getRationalDataTypeRule() {
		return getRationalDataTypeAccess().getRule();
	}
	
	//terminal RATIONAL returns RationalDataType:
	//	'-'? DIGIT+ '/' DIGIT+;
	public TerminalRule getRATIONALRule() {
		return tRATIONAL;
	}
	
	//LiteralFloat:
	//	{LiteralFloat} float=FLOAT;
	public LiteralFloatElements getLiteralFloatAccess() {
		return pLiteralFloat;
	}
	
	public ParserRule getLiteralFloatRule() {
		return getLiteralFloatAccess().getRule();
	}
	
	//LiteralDecimal:
	//	{LiteralDecimal} decimal=DIGITS | decimal=DECIMAL;
	public LiteralDecimalElements getLiteralDecimalAccess() {
		return pLiteralDecimal;
	}
	
	public ParserRule getLiteralDecimalRule() {
		return getLiteralDecimalAccess().getRule();
	}
	
	//PositiveIntegerLiteral PositiveIntegerLiteral:
	//	DIGITS;
	public PositiveIntegerLiteralElements getPositiveIntegerLiteralAccess() {
		return pPositiveIntegerLiteral;
	}
	
	public ParserRule getPositiveIntegerLiteralRule() {
		return getPositiveIntegerLiteralAccess().getRule();
	}
	
	//terminal FALSE returns ecore::EBoolean:
	//	'false';
	public TerminalRule getFALSERule() {
		return tFALSE;
	}
	
	//terminal TRUE returns ecore::EBoolean:
	//	'true';
	public TerminalRule getTRUERule() {
		return tTRUE;
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
	
	//terminal URI returns URIDataType:
	//	SCHEME ':' IHIER_PART ('#' IFRAGMENT)?;
	public TerminalRule getURIRule() {
		return tURI;
	}
	
	//terminal CONSTANT_NAME:
	//	ALPHA (ALPHA | DIGIT)*;
	public TerminalRule getCONSTANT_NAMERule() {
		return tCONSTANT_NAME;
	}
	
	//terminal REAL returns RealDataType:
	//	'{' ('-' | '+')? CONSTANT_NAME '}';
	public TerminalRule getREALRule() {
		return tREAL;
	}
	
	//terminal PATTERN returns LiteralPattern:
	//	'/' (!'/' | '\\/')* '/';
	public TerminalRule getPATTERNRule() {
		return tPATTERN;
	}
	
	//terminal QUOTED_STRING_VALUE returns QuotedStringDataType:
	//	'"' ('\\' . ('b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\') | !('\\' | '"'))* '"';
	public TerminalRule getQUOTED_STRING_VALUERule() {
		return tQUOTED_STRING_VALUE;
	}
	
	//terminal RAW_STRING_VALUE returns RawStringDataType:
	//	'"""'->'"""';
	public TerminalRule getRAW_STRING_VALUERule() {
		return tRAW_STRING_VALUE;
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
	
	//terminal LANG_TAG returns LanguageTagDataType:
	//	'lang=' LETTER+ ('-' LETTER_DIGIT+)*;
	public TerminalRule getLANG_TAGRule() {
		return tLANG_TAG;
	}
	
	//terminal DATE_TIME returns DateTimeDataType:
	//	'dateTime=' YEAR_FRAG '-' MONTH_FRAG '-' DAY_FRAG 'T' (HOUR_FRAG ':' MINUTE_FRAG ':' SECOND_FRAG | END_OF_DAY_FRAG)
	//	TIMEZONE_FRAG?;
	public TerminalRule getDATE_TIMERule() {
		return tDATE_TIME;
	}
	
	//terminal UUID returns UUIDDataType:
	//	'uuid=' HEX_8DIGITS '-' HEX_4DIGITS '-' HEX_4DIGITS '-' HEX_4DIGITS '-' HEX_12DIGITS;
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
	
	//terminal DIGITS returns PositiveIntegerLiteral:
	//	DIGIT+;
	public TerminalRule getDIGITSRule() {
		return tDIGITS;
	}
	
	//terminal fragment DEC:
	//	'-'?
	//	DIGIT+ (('e' | 'E') ('+' | '-')? DIGIT+)? (('b' | 'B') ('i' | 'I' | 'd' | 'D') | ('l' | 'L' | 'd' | 'D' | 'f' |
	//	'F'))?;
	public TerminalRule getDECRule() {
		return tDEC;
	}
	
	//terminal DECIMAL returns DecimalDataType:
	//	DEC | HEX;
	public TerminalRule getDECIMALRule() {
		return tDECIMAL;
	}
	
	//terminal FLOAT returns FloatDataType:
	//	'-'? (DIGIT+ '.' DIGIT+) (('e' | 'E') ('+' | '-')? DIGIT+)?;
	public TerminalRule getFLOATRule() {
		return tFLOAT;
	}
	
	//terminal ID:
	//	'^'? LETTER_DIGIT_PREFIX LETTER_DIGIT_SUFFIX* |
	//	'^'? '\'' LETTER_DIGIT_PREFIX !'\''* '\'';
	public TerminalRule getIDRule() {
		return tID;
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
