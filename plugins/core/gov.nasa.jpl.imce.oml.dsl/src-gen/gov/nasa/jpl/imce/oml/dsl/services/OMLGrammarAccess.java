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
	public class AnnotationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCommercialAtKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cPropertyAnnotationPropertyCrossReference_1_0 = (CrossReference)cPropertyAssignment_1.eContents().get(0);
		private final RuleCall cPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1 = (RuleCall)cPropertyAnnotationPropertyCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueSTRINGTerminalRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		///*
		// * Note that the concrete syntax for the Annotation.subject is defined implicitly
		// * in the sense that the subject of an Annotation is always the preceding
		// * TerminologyThing or the subject of the preceding Annotation.
		// * 
		// * For example, the following shows the concrete syntax for 2 Concepts, Foo and Bar
		// * and of 3 Annotations; the first two Annotations have Foo as their subject because 
		// * Foo is the first preceding TerminologyThing; the third Annotation has Bar as its subject
		// * because it appears after the TerminologyThing Bar.
		// * 
		// * concept Foo
		// * @rdfs:label = "foo"
		// * @dc:description = "A Foo is ..."
		// * 
		// * concept Bar
		// * @rdfs:label = "bar
		// * 
		// * @see jpl.imce.oml.specification.linking.OMLLinkingService
		// */ Annotation:
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
		private final RuleCall cAnnotationsAnnotationParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindTerminologyKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Keyword cTerminologyKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIriAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIriIRITerminalRuleCall_3_0 = (RuleCall)cIriAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cAnnotationsAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationParserRuleCall_5_0_0 = (RuleCall)cAnnotationsAssignment_5_0.eContents().get(0);
		private final Assignment cBoxAxiomsAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0 = (RuleCall)cBoxAxiomsAssignment_5_1.eContents().get(0);
		private final Assignment cBoxStatementsAssignment_5_2 = (Assignment)cAlternatives_5.eContents().get(2);
		private final RuleCall cBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0 = (RuleCall)cBoxStatementsAssignment_5_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//TerminologyGraph:
		//	annotations+=Annotation*
		//	kind=TerminologyKind 'terminology' iri=IRI
		//	'{' (annotations+=Annotation | boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=Annotation* kind=TerminologyKind 'terminology' iri=IRI '{' (annotations+=Annotation |
		//boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=Annotation*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_0_0() { return cAnnotationsAnnotationParserRuleCall_0_0; }
		
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
		
		//(annotations+=Annotation | boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }
		
		//annotations+=Annotation
		public Assignment getAnnotationsAssignment_5_0() { return cAnnotationsAssignment_5_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_5_0_0() { return cAnnotationsAnnotationParserRuleCall_5_0_0; }
		
		//boxAxioms+=TerminologyBoxAxiom
		public Assignment getBoxAxiomsAssignment_5_1() { return cBoxAxiomsAssignment_5_1; }
		
		//TerminologyBoxAxiom
		public RuleCall getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0() { return cBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0; }
		
		//boxStatements+=TerminologyBoxStatement
		public Assignment getBoxStatementsAssignment_5_2() { return cBoxStatementsAssignment_5_2; }
		
		//TerminologyBoxStatement
		public RuleCall getBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0() { return cBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class BundleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Bundle");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindTerminologyKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Keyword cBundleKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIriAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIriIRITerminalRuleCall_3_0 = (RuleCall)cIriAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cAnnotationsAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationParserRuleCall_5_0_0 = (RuleCall)cAnnotationsAssignment_5_0.eContents().get(0);
		private final Assignment cBoxAxiomsAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0 = (RuleCall)cBoxAxiomsAssignment_5_1.eContents().get(0);
		private final Assignment cBoxStatementsAssignment_5_2 = (Assignment)cAlternatives_5.eContents().get(2);
		private final RuleCall cBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0 = (RuleCall)cBoxStatementsAssignment_5_2.eContents().get(0);
		private final Assignment cBundleStatementsAssignment_5_3 = (Assignment)cAlternatives_5.eContents().get(3);
		private final RuleCall cBundleStatementsTerminologyBundleStatementParserRuleCall_5_3_0 = (RuleCall)cBundleStatementsAssignment_5_3.eContents().get(0);
		private final Assignment cBundleAxiomsAssignment_5_4 = (Assignment)cAlternatives_5.eContents().get(4);
		private final RuleCall cBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_4_0 = (RuleCall)cBundleAxiomsAssignment_5_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Bundle:
		//	annotations+=Annotation*
		//	kind=TerminologyKind 'bundle' iri=IRI
		//	'{' (annotations+=Annotation | boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement |
		//	bundleStatements+=TerminologyBundleStatement | bundleAxioms+=TerminologyBundleAxiom)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=Annotation* kind=TerminologyKind 'bundle' iri=IRI '{' (annotations+=Annotation |
		//boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement | bundleStatements+=TerminologyBundleStatement
		//| bundleAxioms+=TerminologyBundleAxiom)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=Annotation*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_0_0() { return cAnnotationsAnnotationParserRuleCall_0_0; }
		
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
		
		//(annotations+=Annotation | boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement |
		//bundleStatements+=TerminologyBundleStatement | bundleAxioms+=TerminologyBundleAxiom)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }
		
		//annotations+=Annotation
		public Assignment getAnnotationsAssignment_5_0() { return cAnnotationsAssignment_5_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_5_0_0() { return cAnnotationsAnnotationParserRuleCall_5_0_0; }
		
		//boxAxioms+=TerminologyBoxAxiom
		public Assignment getBoxAxiomsAssignment_5_1() { return cBoxAxiomsAssignment_5_1; }
		
		//TerminologyBoxAxiom
		public RuleCall getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0() { return cBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0; }
		
		//boxStatements+=TerminologyBoxStatement
		public Assignment getBoxStatementsAssignment_5_2() { return cBoxStatementsAssignment_5_2; }
		
		//TerminologyBoxStatement
		public RuleCall getBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0() { return cBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0; }
		
		//bundleStatements+=TerminologyBundleStatement
		public Assignment getBundleStatementsAssignment_5_3() { return cBundleStatementsAssignment_5_3; }
		
		//TerminologyBundleStatement
		public RuleCall getBundleStatementsTerminologyBundleStatementParserRuleCall_5_3_0() { return cBundleStatementsTerminologyBundleStatementParserRuleCall_5_3_0; }
		
		//bundleAxioms+=TerminologyBundleAxiom
		public Assignment getBundleAxiomsAssignment_5_4() { return cBundleAxiomsAssignment_5_4; }
		
		//TerminologyBundleAxiom
		public RuleCall getBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_4_0() { return cBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class DescriptionBoxElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBox");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cAnnotationsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationParserRuleCall_0_0 = (RuleCall)cAnnotationsAssignment_0.eContents().get(0);
		private final Assignment cKindAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKindDescriptionKindEnumRuleCall_1_0 = (RuleCall)cKindAssignment_1.eContents().get(0);
		private final Keyword cDescriptionBoxKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIriAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIriIRITerminalRuleCall_3_0 = (RuleCall)cIriAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cAnnotationsAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cAnnotationsAnnotationParserRuleCall_5_0_0 = (RuleCall)cAnnotationsAssignment_5_0.eContents().get(0);
		private final Assignment cClosedWorldDefinitionsAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_1_0 = (RuleCall)cClosedWorldDefinitionsAssignment_5_1.eContents().get(0);
		private final Assignment cDescriptionBoxRefinementsAssignment_5_2 = (Assignment)cAlternatives_5.eContents().get(2);
		private final RuleCall cDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_2_0 = (RuleCall)cDescriptionBoxRefinementsAssignment_5_2.eContents().get(0);
		private final Assignment cConceptInstancesAssignment_5_3 = (Assignment)cAlternatives_5.eContents().get(3);
		private final RuleCall cConceptInstancesConceptInstanceParserRuleCall_5_3_0 = (RuleCall)cConceptInstancesAssignment_5_3.eContents().get(0);
		private final Assignment cReifiedRelationshipInstancesAssignment_5_4 = (Assignment)cAlternatives_5.eContents().get(4);
		private final RuleCall cReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_4_0 = (RuleCall)cReifiedRelationshipInstancesAssignment_5_4.eContents().get(0);
		private final Assignment cReifiedRelationshipInstanceDomainsAssignment_5_5 = (Assignment)cAlternatives_5.eContents().get(5);
		private final RuleCall cReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_5_0 = (RuleCall)cReifiedRelationshipInstanceDomainsAssignment_5_5.eContents().get(0);
		private final Assignment cReifiedRelationshipInstanceRangesAssignment_5_6 = (Assignment)cAlternatives_5.eContents().get(6);
		private final RuleCall cReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_6_0 = (RuleCall)cReifiedRelationshipInstanceRangesAssignment_5_6.eContents().get(0);
		private final Assignment cUnreifiedRelationshipInstanceTuplesAssignment_5_7 = (Assignment)cAlternatives_5.eContents().get(7);
		private final RuleCall cUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_7_0 = (RuleCall)cUnreifiedRelationshipInstanceTuplesAssignment_5_7.eContents().get(0);
		private final Assignment cSingletonScalarDataPropertyValuesAssignment_5_8 = (Assignment)cAlternatives_5.eContents().get(8);
		private final RuleCall cSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_8_0 = (RuleCall)cSingletonScalarDataPropertyValuesAssignment_5_8.eContents().get(0);
		private final Assignment cSingletonStructuredDataPropertyValuesAssignment_5_9 = (Assignment)cAlternatives_5.eContents().get(9);
		private final RuleCall cSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_9_0 = (RuleCall)cSingletonStructuredDataPropertyValuesAssignment_5_9.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//DescriptionBox:
		//	annotations+=Annotation*
		//	kind=DescriptionKind 'descriptionBox' iri=IRI
		//	'{' (annotations+=Annotation | closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//	descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//	reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//	reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//	reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//	unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//	singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//	singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//annotations+=Annotation* kind=DescriptionKind 'descriptionBox' iri=IRI '{' (annotations+=Annotation |
		//closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//annotations+=Annotation*
		public Assignment getAnnotationsAssignment_0() { return cAnnotationsAssignment_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_0_0() { return cAnnotationsAnnotationParserRuleCall_0_0; }
		
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
		
		//(annotations+=Annotation | closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
		//descriptionBoxRefinements+=DescriptionBoxRefinement | conceptInstances+=ConceptInstance |
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance |
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain |
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange |
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple |
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue |
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }
		
		//annotations+=Annotation
		public Assignment getAnnotationsAssignment_5_0() { return cAnnotationsAssignment_5_0; }
		
		//Annotation
		public RuleCall getAnnotationsAnnotationParserRuleCall_5_0_0() { return cAnnotationsAnnotationParserRuleCall_5_0_0; }
		
		//closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions
		public Assignment getClosedWorldDefinitionsAssignment_5_1() { return cClosedWorldDefinitionsAssignment_5_1; }
		
		//DescriptionBoxExtendsClosedWorldDefinitions
		public RuleCall getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_1_0() { return cClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_1_0; }
		
		//descriptionBoxRefinements+=DescriptionBoxRefinement
		public Assignment getDescriptionBoxRefinementsAssignment_5_2() { return cDescriptionBoxRefinementsAssignment_5_2; }
		
		//DescriptionBoxRefinement
		public RuleCall getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_2_0() { return cDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_2_0; }
		
		//conceptInstances+=ConceptInstance
		public Assignment getConceptInstancesAssignment_5_3() { return cConceptInstancesAssignment_5_3; }
		
		//ConceptInstance
		public RuleCall getConceptInstancesConceptInstanceParserRuleCall_5_3_0() { return cConceptInstancesConceptInstanceParserRuleCall_5_3_0; }
		
		//reifiedRelationshipInstances+=ReifiedRelationshipInstance
		public Assignment getReifiedRelationshipInstancesAssignment_5_4() { return cReifiedRelationshipInstancesAssignment_5_4; }
		
		//ReifiedRelationshipInstance
		public RuleCall getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_4_0() { return cReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_4_0; }
		
		//reifiedRelationshipInstanceDomains+=ReifiedRelationshipInstanceDomain
		public Assignment getReifiedRelationshipInstanceDomainsAssignment_5_5() { return cReifiedRelationshipInstanceDomainsAssignment_5_5; }
		
		//ReifiedRelationshipInstanceDomain
		public RuleCall getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_5_0() { return cReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_5_0; }
		
		//reifiedRelationshipInstanceRanges+=ReifiedRelationshipInstanceRange
		public Assignment getReifiedRelationshipInstanceRangesAssignment_5_6() { return cReifiedRelationshipInstanceRangesAssignment_5_6; }
		
		//ReifiedRelationshipInstanceRange
		public RuleCall getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_6_0() { return cReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_6_0; }
		
		//unreifiedRelationshipInstanceTuples+=UnreifiedRelationshipInstanceTuple
		public Assignment getUnreifiedRelationshipInstanceTuplesAssignment_5_7() { return cUnreifiedRelationshipInstanceTuplesAssignment_5_7; }
		
		//UnreifiedRelationshipInstanceTuple
		public RuleCall getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_7_0() { return cUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_7_0; }
		
		//singletonScalarDataPropertyValues+=SingletonInstanceScalarDataPropertyValue
		public Assignment getSingletonScalarDataPropertyValuesAssignment_5_8() { return cSingletonScalarDataPropertyValuesAssignment_5_8; }
		
		//SingletonInstanceScalarDataPropertyValue
		public RuleCall getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_8_0() { return cSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_8_0; }
		
		//singletonStructuredDataPropertyValues+=SingletonInstanceStructuredDataPropertyValue
		public Assignment getSingletonStructuredDataPropertyValuesAssignment_5_9() { return cSingletonStructuredDataPropertyValuesAssignment_5_9; }
		
		//SingletonInstanceStructuredDataPropertyValue
		public RuleCall getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_9_0() { return cSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_9_0; }
		
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
		private final Keyword cBundlesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBundledTerminologyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cBundledTerminologyTerminologyBoxCrossReference_1_0 = (CrossReference)cBundledTerminologyAssignment_1.eContents().get(0);
		private final RuleCall cBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1 = (RuleCall)cBundledTerminologyTerminologyBoxCrossReference_1_0.eContents().get(1);
		
		//// 1 TerminologyBundleAxiom
		//BundledTerminologyAxiom:
		//	'bundles' bundledTerminology=[TerminologyBox|ExternalReference];
		@Override public ParserRule getRule() { return rule; }
		
		//'bundles' bundledTerminology=[TerminologyBox|ExternalReference]
		public Group getGroup() { return cGroup; }
		
		//'bundles'
		public Keyword getBundlesKeyword_0() { return cBundlesKeyword_0; }
		
		//bundledTerminology=[TerminologyBox|ExternalReference]
		public Assignment getBundledTerminologyAssignment_1() { return cBundledTerminologyAssignment_1; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getBundledTerminologyTerminologyBoxCrossReference_1_0() { return cBundledTerminologyTerminologyBoxCrossReference_1_0; }
		
		//ExternalReference
		public RuleCall getBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1() { return cBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1; }
	}
	public class ConceptDesignationTerminologyAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ConceptDesignationTerminologyAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cConceptDesignationTerminologyAxiomKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cDesignatedTerminologyKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cDesignatedTerminologyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cDesignatedTerminologyTerminologyBoxCrossReference_3_0 = (CrossReference)cDesignatedTerminologyAssignment_3.eContents().get(0);
		private final RuleCall cDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1 = (RuleCall)cDesignatedTerminologyTerminologyBoxCrossReference_3_0.eContents().get(1);
		private final Keyword cDesignatedConceptKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDesignatedConceptAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDesignatedConceptConceptCrossReference_5_0 = (CrossReference)cDesignatedConceptAssignment_5.eContents().get(0);
		private final RuleCall cDesignatedConceptConceptReferenceParserRuleCall_5_0_1 = (RuleCall)cDesignatedConceptConceptCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//// 3 TerminologyBoxAxioms
		//ConceptDesignationTerminologyAxiom:
		//	'conceptDesignationTerminologyAxiom'
		//	'{'
		//	'designatedTerminology' designatedTerminology=[TerminologyBox|ExternalReference]
		//	'designatedConcept' designatedConcept=[Concept|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'conceptDesignationTerminologyAxiom' '{' 'designatedTerminology'
		//designatedTerminology=[TerminologyBox|ExternalReference] 'designatedConcept' designatedConcept=[Concept|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'conceptDesignationTerminologyAxiom'
		public Keyword getConceptDesignationTerminologyAxiomKeyword_0() { return cConceptDesignationTerminologyAxiomKeyword_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }
		
		//'designatedTerminology'
		public Keyword getDesignatedTerminologyKeyword_2() { return cDesignatedTerminologyKeyword_2; }
		
		//designatedTerminology=[TerminologyBox|ExternalReference]
		public Assignment getDesignatedTerminologyAssignment_3() { return cDesignatedTerminologyAssignment_3; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getDesignatedTerminologyTerminologyBoxCrossReference_3_0() { return cDesignatedTerminologyTerminologyBoxCrossReference_3_0; }
		
		//ExternalReference
		public RuleCall getDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1() { return cDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1; }
		
		//'designatedConcept'
		public Keyword getDesignatedConceptKeyword_4() { return cDesignatedConceptKeyword_4; }
		
		//designatedConcept=[Concept|Reference]
		public Assignment getDesignatedConceptAssignment_5() { return cDesignatedConceptAssignment_5; }
		
		//[Concept|Reference]
		public CrossReference getDesignatedConceptConceptCrossReference_5_0() { return cDesignatedConceptConceptCrossReference_5_0; }
		
		//Reference
		public RuleCall getDesignatedConceptConceptReferenceParserRuleCall_5_0_1() { return cDesignatedConceptConceptReferenceParserRuleCall_5_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class TerminologyExtensionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyExtensionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cExtendsKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExtendedTerminologyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cExtendedTerminologyTerminologyBoxCrossReference_1_0 = (CrossReference)cExtendedTerminologyAssignment_1.eContents().get(0);
		private final RuleCall cExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1 = (RuleCall)cExtendedTerminologyTerminologyBoxCrossReference_1_0.eContents().get(1);
		
		//TerminologyExtensionAxiom:
		//	'extends' extendedTerminology=[TerminologyBox|ExternalReference];
		@Override public ParserRule getRule() { return rule; }
		
		//'extends' extendedTerminology=[TerminologyBox|ExternalReference]
		public Group getGroup() { return cGroup; }
		
		//'extends'
		public Keyword getExtendsKeyword_0() { return cExtendsKeyword_0; }
		
		//extendedTerminology=[TerminologyBox|ExternalReference]
		public Assignment getExtendedTerminologyAssignment_1() { return cExtendedTerminologyAssignment_1; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getExtendedTerminologyTerminologyBoxCrossReference_1_0() { return cExtendedTerminologyTerminologyBoxCrossReference_1_0; }
		
		//ExternalReference
		public RuleCall getExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1() { return cExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1; }
	}
	public class TerminologyNestingAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TerminologyNestingAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTerminologyNestingAxiomKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cNestingTerminologyKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNestingTerminologyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cNestingTerminologyTerminologyBoxCrossReference_3_0 = (CrossReference)cNestingTerminologyAssignment_3.eContents().get(0);
		private final RuleCall cNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1 = (RuleCall)cNestingTerminologyTerminologyBoxCrossReference_3_0.eContents().get(1);
		private final Keyword cNestingContextKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cNestingContextAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cNestingContextConceptCrossReference_5_0 = (CrossReference)cNestingContextAssignment_5.eContents().get(0);
		private final RuleCall cNestingContextConceptReferenceParserRuleCall_5_0_1 = (RuleCall)cNestingContextConceptCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//TerminologyNestingAxiom:
		//	'terminologyNestingAxiom'
		//	'{'
		//	'nestingTerminology' nestingTerminology=[TerminologyBox|ExternalReference]
		//	'nestingContext' nestingContext=[Concept|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'terminologyNestingAxiom' '{' 'nestingTerminology' nestingTerminology=[TerminologyBox|ExternalReference]
		//'nestingContext' nestingContext=[Concept|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'terminologyNestingAxiom'
		public Keyword getTerminologyNestingAxiomKeyword_0() { return cTerminologyNestingAxiomKeyword_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }
		
		//'nestingTerminology'
		public Keyword getNestingTerminologyKeyword_2() { return cNestingTerminologyKeyword_2; }
		
		//nestingTerminology=[TerminologyBox|ExternalReference]
		public Assignment getNestingTerminologyAssignment_3() { return cNestingTerminologyAssignment_3; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getNestingTerminologyTerminologyBoxCrossReference_3_0() { return cNestingTerminologyTerminologyBoxCrossReference_3_0; }
		
		//ExternalReference
		public RuleCall getNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1() { return cNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1; }
		
		//'nestingContext'
		public Keyword getNestingContextKeyword_4() { return cNestingContextKeyword_4; }
		
		//nestingContext=[Concept|Reference]
		public Assignment getNestingContextAssignment_5() { return cNestingContextAssignment_5; }
		
		//[Concept|Reference]
		public CrossReference getNestingContextConceptCrossReference_5_0() { return cNestingContextConceptCrossReference_5_0; }
		
		//Reference
		public RuleCall getNestingContextConceptReferenceParserRuleCall_5_0_1() { return cNestingContextConceptReferenceParserRuleCall_5_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
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
		private final Keyword cAspectKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//// 2 Atomic Entity Terms
		//Aspect:
		//	'aspect' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//'aspect' name=ID
		public Group getGroup() { return cGroup; }
		
		//'aspect'
		public Keyword getAspectKeyword_0() { return cAspectKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}
	public class ConceptElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Concept");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cConceptKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Concept:
		//	'concept' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//'concept' name=ID
		public Group getGroup() { return cGroup; }
		
		//'concept'
		public Keyword getConceptKeyword_0() { return cConceptKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}
	public class ReifiedRelationshipElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationship");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReifiedRelationshipKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Assignment cIsFunctionalAssignment_3_0 = (Assignment)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cIsFunctionalFunctionalKeyword_3_0_0 = (Keyword)cIsFunctionalAssignment_3_0.eContents().get(0);
		private final Assignment cIsInverseFunctionalAssignment_3_1 = (Assignment)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cIsInverseFunctionalInverseFunctionalKeyword_3_1_0 = (Keyword)cIsInverseFunctionalAssignment_3_1.eContents().get(0);
		private final Assignment cIsEssentialAssignment_3_2 = (Assignment)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cIsEssentialEssentialKeyword_3_2_0 = (Keyword)cIsEssentialAssignment_3_2.eContents().get(0);
		private final Assignment cIsInverseEssentialAssignment_3_3 = (Assignment)cUnorderedGroup_3.eContents().get(3);
		private final Keyword cIsInverseEssentialInverseEssentialKeyword_3_3_0 = (Keyword)cIsInverseEssentialAssignment_3_3.eContents().get(0);
		private final Assignment cIsSymmetricAssignment_3_4 = (Assignment)cUnorderedGroup_3.eContents().get(4);
		private final Keyword cIsSymmetricSymmetricKeyword_3_4_0 = (Keyword)cIsSymmetricAssignment_3_4.eContents().get(0);
		private final Assignment cIsAsymmetricAssignment_3_5 = (Assignment)cUnorderedGroup_3.eContents().get(5);
		private final Keyword cIsAsymmetricAsymmetricKeyword_3_5_0 = (Keyword)cIsAsymmetricAssignment_3_5.eContents().get(0);
		private final Assignment cIsReflexiveAssignment_3_6 = (Assignment)cUnorderedGroup_3.eContents().get(6);
		private final Keyword cIsReflexiveReflexiveKeyword_3_6_0 = (Keyword)cIsReflexiveAssignment_3_6.eContents().get(0);
		private final Assignment cIsIrreflexiveAssignment_3_7 = (Assignment)cUnorderedGroup_3.eContents().get(7);
		private final Keyword cIsIrreflexiveIrreflexiveKeyword_3_7_0 = (Keyword)cIsIrreflexiveAssignment_3_7.eContents().get(0);
		private final Assignment cIsTransitiveAssignment_3_8 = (Assignment)cUnorderedGroup_3.eContents().get(8);
		private final Keyword cIsTransitiveTransitiveKeyword_3_8_0 = (Keyword)cIsTransitiveAssignment_3_8.eContents().get(0);
		private final Keyword cUnreifiedKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cUnreifiedPropertyNameAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cUnreifiedPropertyNameIDTerminalRuleCall_6_0 = (RuleCall)cUnreifiedPropertyNameAssignment_6.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cInverseKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Keyword cEqualsSignKeyword_7_1 = (Keyword)cGroup_7.eContents().get(1);
		private final Assignment cUnreifiedInversePropertyNameAssignment_7_2 = (Assignment)cGroup_7.eContents().get(2);
		private final RuleCall cUnreifiedInversePropertyNameIDTerminalRuleCall_7_2_0 = (RuleCall)cUnreifiedInversePropertyNameAssignment_7_2.eContents().get(0);
		private final Keyword cSourceKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Keyword cEqualsSignKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Assignment cSourceAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final CrossReference cSourceEntityCrossReference_10_0 = (CrossReference)cSourceAssignment_10.eContents().get(0);
		private final RuleCall cSourceEntityReferenceParserRuleCall_10_0_1 = (RuleCall)cSourceEntityCrossReference_10_0.eContents().get(1);
		private final Keyword cTargetKeyword_11 = (Keyword)cGroup.eContents().get(11);
		private final Keyword cEqualsSignKeyword_12 = (Keyword)cGroup.eContents().get(12);
		private final Assignment cTargetAssignment_13 = (Assignment)cGroup.eContents().get(13);
		private final CrossReference cTargetEntityCrossReference_13_0 = (CrossReference)cTargetAssignment_13.eContents().get(0);
		private final RuleCall cTargetEntityReferenceParserRuleCall_13_0_1 = (RuleCall)cTargetEntityCrossReference_13_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_14 = (Keyword)cGroup.eContents().get(14);
		
		//// 2 EntityRelationship Terms
		//ReifiedRelationship:
		//	'reifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
		//	isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
		//	isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
		//	'unreified' '=' unreifiedPropertyName=ID ('inverse' '=' unreifiedInversePropertyName=ID)?
		//	'source' '=' source=[Entity|Reference]
		//	'target' '=' target=[Entity|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'reifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
		//isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
		//isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
		//'unreified' '=' unreifiedPropertyName=ID ('inverse' '=' unreifiedInversePropertyName=ID)? 'source' '='
		//source=[Entity|Reference] 'target' '=' target=[Entity|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'reifiedRelationship'
		public Keyword getReifiedRelationshipKeyword_0() { return cReifiedRelationshipKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? & isEssential?='essential'? &
		//isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? & isAsymmetric?='asymmetric'? &
		//isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }
		
		//isFunctional?='functional'?
		public Assignment getIsFunctionalAssignment_3_0() { return cIsFunctionalAssignment_3_0; }
		
		//'functional'
		public Keyword getIsFunctionalFunctionalKeyword_3_0_0() { return cIsFunctionalFunctionalKeyword_3_0_0; }
		
		//isInverseFunctional?='inverseFunctional'?
		public Assignment getIsInverseFunctionalAssignment_3_1() { return cIsInverseFunctionalAssignment_3_1; }
		
		//'inverseFunctional'
		public Keyword getIsInverseFunctionalInverseFunctionalKeyword_3_1_0() { return cIsInverseFunctionalInverseFunctionalKeyword_3_1_0; }
		
		//isEssential?='essential'?
		public Assignment getIsEssentialAssignment_3_2() { return cIsEssentialAssignment_3_2; }
		
		//'essential'
		public Keyword getIsEssentialEssentialKeyword_3_2_0() { return cIsEssentialEssentialKeyword_3_2_0; }
		
		//isInverseEssential?='inverseEssential'?
		public Assignment getIsInverseEssentialAssignment_3_3() { return cIsInverseEssentialAssignment_3_3; }
		
		//'inverseEssential'
		public Keyword getIsInverseEssentialInverseEssentialKeyword_3_3_0() { return cIsInverseEssentialInverseEssentialKeyword_3_3_0; }
		
		//isSymmetric?='symmetric'?
		public Assignment getIsSymmetricAssignment_3_4() { return cIsSymmetricAssignment_3_4; }
		
		//'symmetric'
		public Keyword getIsSymmetricSymmetricKeyword_3_4_0() { return cIsSymmetricSymmetricKeyword_3_4_0; }
		
		//isAsymmetric?='asymmetric'?
		public Assignment getIsAsymmetricAssignment_3_5() { return cIsAsymmetricAssignment_3_5; }
		
		//'asymmetric'
		public Keyword getIsAsymmetricAsymmetricKeyword_3_5_0() { return cIsAsymmetricAsymmetricKeyword_3_5_0; }
		
		//isReflexive?='reflexive'?
		public Assignment getIsReflexiveAssignment_3_6() { return cIsReflexiveAssignment_3_6; }
		
		//'reflexive'
		public Keyword getIsReflexiveReflexiveKeyword_3_6_0() { return cIsReflexiveReflexiveKeyword_3_6_0; }
		
		//isIrreflexive?='irreflexive'?
		public Assignment getIsIrreflexiveAssignment_3_7() { return cIsIrreflexiveAssignment_3_7; }
		
		//'irreflexive'
		public Keyword getIsIrreflexiveIrreflexiveKeyword_3_7_0() { return cIsIrreflexiveIrreflexiveKeyword_3_7_0; }
		
		//isTransitive?='transitive'?
		public Assignment getIsTransitiveAssignment_3_8() { return cIsTransitiveAssignment_3_8; }
		
		//'transitive'
		public Keyword getIsTransitiveTransitiveKeyword_3_8_0() { return cIsTransitiveTransitiveKeyword_3_8_0; }
		
		//'unreified'
		public Keyword getUnreifiedKeyword_4() { return cUnreifiedKeyword_4; }
		
		//'='
		public Keyword getEqualsSignKeyword_5() { return cEqualsSignKeyword_5; }
		
		//unreifiedPropertyName=ID
		public Assignment getUnreifiedPropertyNameAssignment_6() { return cUnreifiedPropertyNameAssignment_6; }
		
		//ID
		public RuleCall getUnreifiedPropertyNameIDTerminalRuleCall_6_0() { return cUnreifiedPropertyNameIDTerminalRuleCall_6_0; }
		
		//('inverse' '=' unreifiedInversePropertyName=ID)?
		public Group getGroup_7() { return cGroup_7; }
		
		//'inverse'
		public Keyword getInverseKeyword_7_0() { return cInverseKeyword_7_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_7_1() { return cEqualsSignKeyword_7_1; }
		
		//unreifiedInversePropertyName=ID
		public Assignment getUnreifiedInversePropertyNameAssignment_7_2() { return cUnreifiedInversePropertyNameAssignment_7_2; }
		
		//ID
		public RuleCall getUnreifiedInversePropertyNameIDTerminalRuleCall_7_2_0() { return cUnreifiedInversePropertyNameIDTerminalRuleCall_7_2_0; }
		
		//'source'
		public Keyword getSourceKeyword_8() { return cSourceKeyword_8; }
		
		//'='
		public Keyword getEqualsSignKeyword_9() { return cEqualsSignKeyword_9; }
		
		//source=[Entity|Reference]
		public Assignment getSourceAssignment_10() { return cSourceAssignment_10; }
		
		//[Entity|Reference]
		public CrossReference getSourceEntityCrossReference_10_0() { return cSourceEntityCrossReference_10_0; }
		
		//Reference
		public RuleCall getSourceEntityReferenceParserRuleCall_10_0_1() { return cSourceEntityReferenceParserRuleCall_10_0_1; }
		
		//'target'
		public Keyword getTargetKeyword_11() { return cTargetKeyword_11; }
		
		//'='
		public Keyword getEqualsSignKeyword_12() { return cEqualsSignKeyword_12; }
		
		//target=[Entity|Reference]
		public Assignment getTargetAssignment_13() { return cTargetAssignment_13; }
		
		//[Entity|Reference]
		public CrossReference getTargetEntityCrossReference_13_0() { return cTargetEntityCrossReference_13_0; }
		
		//Reference
		public RuleCall getTargetEntityReferenceParserRuleCall_13_0_1() { return cTargetEntityReferenceParserRuleCall_13_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_14() { return cRightCurlyBracketKeyword_14; }
	}
	public class UnreifiedRelationshipElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UnreifiedRelationship");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cUnreifiedRelationshipKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Assignment cIsFunctionalAssignment_3_0 = (Assignment)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cIsFunctionalFunctionalKeyword_3_0_0 = (Keyword)cIsFunctionalAssignment_3_0.eContents().get(0);
		private final Assignment cIsInverseFunctionalAssignment_3_1 = (Assignment)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cIsInverseFunctionalInverseFunctionalKeyword_3_1_0 = (Keyword)cIsInverseFunctionalAssignment_3_1.eContents().get(0);
		private final Assignment cIsEssentialAssignment_3_2 = (Assignment)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cIsEssentialEssentialKeyword_3_2_0 = (Keyword)cIsEssentialAssignment_3_2.eContents().get(0);
		private final Assignment cIsInverseEssentialAssignment_3_3 = (Assignment)cUnorderedGroup_3.eContents().get(3);
		private final Keyword cIsInverseEssentialInverseEssentialKeyword_3_3_0 = (Keyword)cIsInverseEssentialAssignment_3_3.eContents().get(0);
		private final Assignment cIsSymmetricAssignment_3_4 = (Assignment)cUnorderedGroup_3.eContents().get(4);
		private final Keyword cIsSymmetricSymmetricKeyword_3_4_0 = (Keyword)cIsSymmetricAssignment_3_4.eContents().get(0);
		private final Assignment cIsAsymmetricAssignment_3_5 = (Assignment)cUnorderedGroup_3.eContents().get(5);
		private final Keyword cIsAsymmetricAsymmetricKeyword_3_5_0 = (Keyword)cIsAsymmetricAssignment_3_5.eContents().get(0);
		private final Assignment cIsReflexiveAssignment_3_6 = (Assignment)cUnorderedGroup_3.eContents().get(6);
		private final Keyword cIsReflexiveReflexiveKeyword_3_6_0 = (Keyword)cIsReflexiveAssignment_3_6.eContents().get(0);
		private final Assignment cIsIrreflexiveAssignment_3_7 = (Assignment)cUnorderedGroup_3.eContents().get(7);
		private final Keyword cIsIrreflexiveIrreflexiveKeyword_3_7_0 = (Keyword)cIsIrreflexiveAssignment_3_7.eContents().get(0);
		private final Assignment cIsTransitiveAssignment_3_8 = (Assignment)cUnorderedGroup_3.eContents().get(8);
		private final Keyword cIsTransitiveTransitiveKeyword_3_8_0 = (Keyword)cIsTransitiveAssignment_3_8.eContents().get(0);
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
		
		//UnreifiedRelationship:
		//	'unreifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
		//	isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
		//	isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
		//	'source' '=' source=[Entity|Reference]
		//	'target' '=' target=[Entity|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'unreifiedRelationship' name=ID '{' (isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? &
		//isEssential?='essential'? & isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? &
		//isAsymmetric?='asymmetric'? & isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?)
		//'source' '=' source=[Entity|Reference] 'target' '=' target=[Entity|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'unreifiedRelationship'
		public Keyword getUnreifiedRelationshipKeyword_0() { return cUnreifiedRelationshipKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//isFunctional?='functional'? & isInverseFunctional?='inverseFunctional'? & isEssential?='essential'? &
		//isInverseEssential?='inverseEssential'? & isSymmetric?='symmetric'? & isAsymmetric?='asymmetric'? &
		//isReflexive?='reflexive'? & isIrreflexive?='irreflexive'? & isTransitive?='transitive'?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }
		
		//isFunctional?='functional'?
		public Assignment getIsFunctionalAssignment_3_0() { return cIsFunctionalAssignment_3_0; }
		
		//'functional'
		public Keyword getIsFunctionalFunctionalKeyword_3_0_0() { return cIsFunctionalFunctionalKeyword_3_0_0; }
		
		//isInverseFunctional?='inverseFunctional'?
		public Assignment getIsInverseFunctionalAssignment_3_1() { return cIsInverseFunctionalAssignment_3_1; }
		
		//'inverseFunctional'
		public Keyword getIsInverseFunctionalInverseFunctionalKeyword_3_1_0() { return cIsInverseFunctionalInverseFunctionalKeyword_3_1_0; }
		
		//isEssential?='essential'?
		public Assignment getIsEssentialAssignment_3_2() { return cIsEssentialAssignment_3_2; }
		
		//'essential'
		public Keyword getIsEssentialEssentialKeyword_3_2_0() { return cIsEssentialEssentialKeyword_3_2_0; }
		
		//isInverseEssential?='inverseEssential'?
		public Assignment getIsInverseEssentialAssignment_3_3() { return cIsInverseEssentialAssignment_3_3; }
		
		//'inverseEssential'
		public Keyword getIsInverseEssentialInverseEssentialKeyword_3_3_0() { return cIsInverseEssentialInverseEssentialKeyword_3_3_0; }
		
		//isSymmetric?='symmetric'?
		public Assignment getIsSymmetricAssignment_3_4() { return cIsSymmetricAssignment_3_4; }
		
		//'symmetric'
		public Keyword getIsSymmetricSymmetricKeyword_3_4_0() { return cIsSymmetricSymmetricKeyword_3_4_0; }
		
		//isAsymmetric?='asymmetric'?
		public Assignment getIsAsymmetricAssignment_3_5() { return cIsAsymmetricAssignment_3_5; }
		
		//'asymmetric'
		public Keyword getIsAsymmetricAsymmetricKeyword_3_5_0() { return cIsAsymmetricAsymmetricKeyword_3_5_0; }
		
		//isReflexive?='reflexive'?
		public Assignment getIsReflexiveAssignment_3_6() { return cIsReflexiveAssignment_3_6; }
		
		//'reflexive'
		public Keyword getIsReflexiveReflexiveKeyword_3_6_0() { return cIsReflexiveReflexiveKeyword_3_6_0; }
		
		//isIrreflexive?='irreflexive'?
		public Assignment getIsIrreflexiveAssignment_3_7() { return cIsIrreflexiveAssignment_3_7; }
		
		//'irreflexive'
		public Keyword getIsIrreflexiveIrreflexiveKeyword_3_7_0() { return cIsIrreflexiveIrreflexiveKeyword_3_7_0; }
		
		//isTransitive?='transitive'?
		public Assignment getIsTransitiveAssignment_3_8() { return cIsTransitiveAssignment_3_8; }
		
		//'transitive'
		public Keyword getIsTransitiveTransitiveKeyword_3_8_0() { return cIsTransitiveTransitiveKeyword_3_8_0; }
		
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
	public class ScalarElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Scalar");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cScalarKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//// 2 Datatypes
		//Scalar:
		//	'scalar' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//'scalar' name=ID
		public Group getGroup() { return cGroup; }
		
		//'scalar'
		public Keyword getScalarKeyword_0() { return cScalarKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}
	public class StructureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Structure");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStructureKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Structure:
		//	'structure' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//'structure' name=ID
		public Group getGroup() { return cGroup; }
		
		//'structure'
		public Keyword getStructureKeyword_0() { return cStructureKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}
	public class EntityStructuredDataPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityStructuredDataProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEntityStructuredDataPropertyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIsIdentityCriteriaAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsIdentityCriteriaPlusSignKeyword_1_0 = (Keyword)cIsIdentityCriteriaAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cDomainKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDomainAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDomainEntityCrossReference_5_0 = (CrossReference)cDomainAssignment_5.eContents().get(0);
		private final RuleCall cDomainEntityReferenceParserRuleCall_5_0_1 = (RuleCall)cDomainEntityCrossReference_5_0.eContents().get(1);
		private final Keyword cRangeKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cRangeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cRangeStructureCrossReference_7_0 = (CrossReference)cRangeAssignment_7.eContents().get(0);
		private final RuleCall cRangeStructureReferenceParserRuleCall_7_0_1 = (RuleCall)cRangeStructureCrossReference_7_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//// 4 DataRelationship Terms
		//EntityStructuredDataProperty:
		//	'entityStructuredDataProperty' isIdentityCriteria?='+'? name=ID '{'
		//	'domain' domain=[Entity|Reference]
		//	'range' range=[Structure|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'entityStructuredDataProperty' isIdentityCriteria?='+'? name=ID '{' 'domain' domain=[Entity|Reference] 'range'
		//range=[Structure|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'entityStructuredDataProperty'
		public Keyword getEntityStructuredDataPropertyKeyword_0() { return cEntityStructuredDataPropertyKeyword_0; }
		
		//isIdentityCriteria?='+'?
		public Assignment getIsIdentityCriteriaAssignment_1() { return cIsIdentityCriteriaAssignment_1; }
		
		//'+'
		public Keyword getIsIdentityCriteriaPlusSignKeyword_1_0() { return cIsIdentityCriteriaPlusSignKeyword_1_0; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'domain'
		public Keyword getDomainKeyword_4() { return cDomainKeyword_4; }
		
		//domain=[Entity|Reference]
		public Assignment getDomainAssignment_5() { return cDomainAssignment_5; }
		
		//[Entity|Reference]
		public CrossReference getDomainEntityCrossReference_5_0() { return cDomainEntityCrossReference_5_0; }
		
		//Reference
		public RuleCall getDomainEntityReferenceParserRuleCall_5_0_1() { return cDomainEntityReferenceParserRuleCall_5_0_1; }
		
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
	public class EntityScalarDataPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEntityScalarDataPropertyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIsIdentityCriteriaAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsIdentityCriteriaPlusSignKeyword_1_0 = (Keyword)cIsIdentityCriteriaAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cDomainKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDomainAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDomainEntityCrossReference_5_0 = (CrossReference)cDomainAssignment_5.eContents().get(0);
		private final RuleCall cDomainEntityReferenceParserRuleCall_5_0_1 = (RuleCall)cDomainEntityCrossReference_5_0.eContents().get(1);
		private final Keyword cRangeKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cRangeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cRangeDataRangeCrossReference_7_0 = (CrossReference)cRangeAssignment_7.eContents().get(0);
		private final RuleCall cRangeDataRangeReferenceParserRuleCall_7_0_1 = (RuleCall)cRangeDataRangeCrossReference_7_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//EntityScalarDataProperty:
		//	'entityScalarDataProperty' isIdentityCriteria?='+'? name=ID '{'
		//	'domain' domain=[Entity|Reference]
		//	'range' range=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'entityScalarDataProperty' isIdentityCriteria?='+'? name=ID '{' 'domain' domain=[Entity|Reference] 'range'
		//range=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'entityScalarDataProperty'
		public Keyword getEntityScalarDataPropertyKeyword_0() { return cEntityScalarDataPropertyKeyword_0; }
		
		//isIdentityCriteria?='+'?
		public Assignment getIsIdentityCriteriaAssignment_1() { return cIsIdentityCriteriaAssignment_1; }
		
		//'+'
		public Keyword getIsIdentityCriteriaPlusSignKeyword_1_0() { return cIsIdentityCriteriaPlusSignKeyword_1_0; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'domain'
		public Keyword getDomainKeyword_4() { return cDomainKeyword_4; }
		
		//domain=[Entity|Reference]
		public Assignment getDomainAssignment_5() { return cDomainAssignment_5; }
		
		//[Entity|Reference]
		public CrossReference getDomainEntityCrossReference_5_0() { return cDomainEntityCrossReference_5_0; }
		
		//Reference
		public RuleCall getDomainEntityReferenceParserRuleCall_5_0_1() { return cDomainEntityReferenceParserRuleCall_5_0_1; }
		
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
	public class StructuredDataPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStructuredDataPropertyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cDomainKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cDomainAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cDomainStructureCrossReference_4_0 = (CrossReference)cDomainAssignment_4.eContents().get(0);
		private final RuleCall cDomainStructureReferenceParserRuleCall_4_0_1 = (RuleCall)cDomainStructureCrossReference_4_0.eContents().get(1);
		private final Keyword cRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRangeStructureCrossReference_6_0 = (CrossReference)cRangeAssignment_6.eContents().get(0);
		private final RuleCall cRangeStructureReferenceParserRuleCall_6_0_1 = (RuleCall)cRangeStructureCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//StructuredDataProperty:
		//	'structuredDataProperty' name=ID '{'
		//	'domain' domain=[Structure|Reference]
		//	'range' range=[Structure|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'structuredDataProperty' name=ID '{' 'domain' domain=[Structure|Reference] 'range' range=[Structure|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'structuredDataProperty'
		public Keyword getStructuredDataPropertyKeyword_0() { return cStructuredDataPropertyKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//'domain'
		public Keyword getDomainKeyword_3() { return cDomainKeyword_3; }
		
		//domain=[Structure|Reference]
		public Assignment getDomainAssignment_4() { return cDomainAssignment_4; }
		
		//[Structure|Reference]
		public CrossReference getDomainStructureCrossReference_4_0() { return cDomainStructureCrossReference_4_0; }
		
		//Reference
		public RuleCall getDomainStructureReferenceParserRuleCall_4_0_1() { return cDomainStructureReferenceParserRuleCall_4_0_1; }
		
		//'range'
		public Keyword getRangeKeyword_5() { return cRangeKeyword_5; }
		
		//range=[Structure|Reference]
		public Assignment getRangeAssignment_6() { return cRangeAssignment_6; }
		
		//[Structure|Reference]
		public CrossReference getRangeStructureCrossReference_6_0() { return cRangeStructureCrossReference_6_0; }
		
		//Reference
		public RuleCall getRangeStructureReferenceParserRuleCall_6_0_1() { return cRangeStructureReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class ScalarDataPropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataProperty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cScalarDataPropertyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cDomainKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cDomainAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cDomainStructureCrossReference_4_0 = (CrossReference)cDomainAssignment_4.eContents().get(0);
		private final RuleCall cDomainStructureReferenceParserRuleCall_4_0_1 = (RuleCall)cDomainStructureCrossReference_4_0.eContents().get(1);
		private final Keyword cRangeKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cRangeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cRangeDataRangeCrossReference_6_0 = (CrossReference)cRangeAssignment_6.eContents().get(0);
		private final RuleCall cRangeDataRangeReferenceParserRuleCall_6_0_1 = (RuleCall)cRangeDataRangeCrossReference_6_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//ScalarDataProperty:
		//	'scalarDataProperty' name=ID '{'
		//	'domain' domain=[Structure|Reference]
		//	'range' range=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'scalarDataProperty' name=ID '{' 'domain' domain=[Structure|Reference] 'range' range=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'scalarDataProperty'
		public Keyword getScalarDataPropertyKeyword_0() { return cScalarDataPropertyKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//'domain'
		public Keyword getDomainKeyword_3() { return cDomainKeyword_3; }
		
		//domain=[Structure|Reference]
		public Assignment getDomainAssignment_4() { return cDomainAssignment_4; }
		
		//[Structure|Reference]
		public CrossReference getDomainStructureCrossReference_4_0() { return cDomainStructureCrossReference_4_0; }
		
		//Reference
		public RuleCall getDomainStructureReferenceParserRuleCall_4_0_1() { return cDomainStructureReferenceParserRuleCall_4_0_1; }
		
		//'range'
		public Keyword getRangeKeyword_5() { return cRangeKeyword_5; }
		
		//range=[DataRange|Reference]
		public Assignment getRangeAssignment_6() { return cRangeAssignment_6; }
		
		//[DataRange|Reference]
		public CrossReference getRangeDataRangeCrossReference_6_0() { return cRangeDataRangeCrossReference_6_0; }
		
		//Reference
		public RuleCall getRangeDataRangeReferenceParserRuleCall_6_0_1() { return cRangeDataRangeReferenceParserRuleCall_6_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class AnonymousConceptUnionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.AnonymousConceptUnionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAnonymousConceptUnionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDisjunctionsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0 = (RuleCall)cDisjunctionsAssignment_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//// ConceptTreeDisjunctions and DisjointUnionOfConceptsAxioms
		//AnonymousConceptUnionAxiom:
		//	'anonymousConceptUnion' '(' name=ID ')' '{'
		//	disjunctions+=DisjointUnionOfConceptsAxiom*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'anonymousConceptUnion' '(' name=ID ')' '{' disjunctions+=DisjointUnionOfConceptsAxiom* '}'
		public Group getGroup() { return cGroup; }
		
		//'anonymousConceptUnion'
		public Keyword getAnonymousConceptUnionKeyword_0() { return cAnonymousConceptUnionKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//disjunctions+=DisjointUnionOfConceptsAxiom*
		public Assignment getDisjunctionsAssignment_5() { return cDisjunctionsAssignment_5; }
		
		//DisjointUnionOfConceptsAxiom
		public RuleCall getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0() { return cDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class RootConceptTaxonomyAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RootConceptTaxonomyAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRootConceptTaxonomyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRootAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRootConceptCrossReference_2_0 = (CrossReference)cRootAssignment_2.eContents().get(0);
		private final RuleCall cRootConceptReferenceParserRuleCall_2_0_1 = (RuleCall)cRootConceptCrossReference_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDisjunctionsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0 = (RuleCall)cDisjunctionsAssignment_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//RootConceptTaxonomyAxiom:
		//	'rootConceptTaxonomy' '(' root=[Concept|Reference] ')'
		//	'{'
		//	disjunctions+=DisjointUnionOfConceptsAxiom*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'rootConceptTaxonomy' '(' root=[Concept|Reference] ')' '{' disjunctions+=DisjointUnionOfConceptsAxiom* '}'
		public Group getGroup() { return cGroup; }
		
		//'rootConceptTaxonomy'
		public Keyword getRootConceptTaxonomyKeyword_0() { return cRootConceptTaxonomyKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//root=[Concept|Reference]
		public Assignment getRootAssignment_2() { return cRootAssignment_2; }
		
		//[Concept|Reference]
		public CrossReference getRootConceptCrossReference_2_0() { return cRootConceptCrossReference_2_0; }
		
		//Reference
		public RuleCall getRootConceptReferenceParserRuleCall_2_0_1() { return cRootConceptReferenceParserRuleCall_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//disjunctions+=DisjointUnionOfConceptsAxiom*
		public Assignment getDisjunctionsAssignment_5() { return cDisjunctionsAssignment_5; }
		
		//DisjointUnionOfConceptsAxiom
		public RuleCall getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0() { return cDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class SpecificDisjointConceptAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SpecificDisjointConceptAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDisjointLeafKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDisjointLeafAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cDisjointLeafConceptCrossReference_2_0 = (CrossReference)cDisjointLeafAssignment_2.eContents().get(0);
		private final RuleCall cDisjointLeafConceptReferenceParserRuleCall_2_0_1 = (RuleCall)cDisjointLeafConceptCrossReference_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//SpecificDisjointConceptAxiom:
		//	'disjointLeaf' '(' disjointLeaf=[Concept|Reference] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//'disjointLeaf' '(' disjointLeaf=[Concept|Reference] ')'
		public Group getGroup() { return cGroup; }
		
		//'disjointLeaf'
		public Keyword getDisjointLeafKeyword_0() { return cDisjointLeafKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//disjointLeaf=[Concept|Reference]
		public Assignment getDisjointLeafAssignment_2() { return cDisjointLeafAssignment_2; }
		
		//[Concept|Reference]
		public CrossReference getDisjointLeafConceptCrossReference_2_0() { return cDisjointLeafConceptCrossReference_2_0; }
		
		//Reference
		public RuleCall getDisjointLeafConceptReferenceParserRuleCall_2_0_1() { return cDisjointLeafConceptReferenceParserRuleCall_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}
	public class EntityExistentialRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityExistentialRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSomeEntitiesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRestrictedDomainAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRestrictedDomainEntityCrossReference_1_0 = (CrossReference)cRestrictedDomainAssignment_1.eContents().get(0);
		private final RuleCall cRestrictedDomainEntityReferenceParserRuleCall_1_0_1 = (RuleCall)cRestrictedDomainEntityCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cRestrictedRelationAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cRestrictedRelationReifiedRelationshipCrossReference_3_0 = (CrossReference)cRestrictedRelationAssignment_3.eContents().get(0);
		private final RuleCall cRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cRestrictedRelationReifiedRelationshipCrossReference_3_0.eContents().get(1);
		private final Keyword cInKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeEntityCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_5_0.eContents().get(1);
		
		//// 2 EntityRestrictionAxioms
		//EntityExistentialRestrictionAxiom:
		//	'someEntities'
		//	restrictedDomain=[Entity|Reference]
		//	'.'
		//	restrictedRelation=[ReifiedRelationship|Reference]
		//	'in' restrictedRange=[Entity|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//'someEntities' restrictedDomain=[Entity|Reference] '.' restrictedRelation=[ReifiedRelationship|Reference] 'in'
		//restrictedRange=[Entity|Reference]
		public Group getGroup() { return cGroup; }
		
		//'someEntities'
		public Keyword getSomeEntitiesKeyword_0() { return cSomeEntitiesKeyword_0; }
		
		//restrictedDomain=[Entity|Reference]
		public Assignment getRestrictedDomainAssignment_1() { return cRestrictedDomainAssignment_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedDomainEntityCrossReference_1_0() { return cRestrictedDomainEntityCrossReference_1_0; }
		
		//Reference
		public RuleCall getRestrictedDomainEntityReferenceParserRuleCall_1_0_1() { return cRestrictedDomainEntityReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//restrictedRelation=[ReifiedRelationship|Reference]
		public Assignment getRestrictedRelationAssignment_3() { return cRestrictedRelationAssignment_3; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getRestrictedRelationReifiedRelationshipCrossReference_3_0() { return cRestrictedRelationReifiedRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1() { return cRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1; }
		
		//'in'
		public Keyword getInKeyword_4() { return cInKeyword_4; }
		
		//restrictedRange=[Entity|Reference]
		public Assignment getRestrictedRangeAssignment_5() { return cRestrictedRangeAssignment_5; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedRangeEntityCrossReference_5_0() { return cRestrictedRangeEntityCrossReference_5_0; }
		
		//Reference
		public RuleCall getRestrictedRangeEntityReferenceParserRuleCall_5_0_1() { return cRestrictedRangeEntityReferenceParserRuleCall_5_0_1; }
	}
	public class EntityUniversalRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityUniversalRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAllEntitiesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRestrictedDomainAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRestrictedDomainEntityCrossReference_1_0 = (CrossReference)cRestrictedDomainAssignment_1.eContents().get(0);
		private final RuleCall cRestrictedDomainEntityReferenceParserRuleCall_1_0_1 = (RuleCall)cRestrictedDomainEntityCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cRestrictedRelationAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cRestrictedRelationReifiedRelationshipCrossReference_3_0 = (CrossReference)cRestrictedRelationAssignment_3.eContents().get(0);
		private final RuleCall cRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cRestrictedRelationReifiedRelationshipCrossReference_3_0.eContents().get(1);
		private final Keyword cInKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeEntityCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeEntityReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeEntityCrossReference_5_0.eContents().get(1);
		
		//EntityUniversalRestrictionAxiom:
		//	'allEntities'
		//	restrictedDomain=[Entity|Reference]
		//	'.'
		//	restrictedRelation=[ReifiedRelationship|Reference]
		//	'in' restrictedRange=[Entity|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//'allEntities' restrictedDomain=[Entity|Reference] '.' restrictedRelation=[ReifiedRelationship|Reference] 'in'
		//restrictedRange=[Entity|Reference]
		public Group getGroup() { return cGroup; }
		
		//'allEntities'
		public Keyword getAllEntitiesKeyword_0() { return cAllEntitiesKeyword_0; }
		
		//restrictedDomain=[Entity|Reference]
		public Assignment getRestrictedDomainAssignment_1() { return cRestrictedDomainAssignment_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedDomainEntityCrossReference_1_0() { return cRestrictedDomainEntityCrossReference_1_0; }
		
		//Reference
		public RuleCall getRestrictedDomainEntityReferenceParserRuleCall_1_0_1() { return cRestrictedDomainEntityReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//restrictedRelation=[ReifiedRelationship|Reference]
		public Assignment getRestrictedRelationAssignment_3() { return cRestrictedRelationAssignment_3; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getRestrictedRelationReifiedRelationshipCrossReference_3_0() { return cRestrictedRelationReifiedRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1() { return cRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1; }
		
		//'in'
		public Keyword getInKeyword_4() { return cInKeyword_4; }
		
		//restrictedRange=[Entity|Reference]
		public Assignment getRestrictedRangeAssignment_5() { return cRestrictedRangeAssignment_5; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedRangeEntityCrossReference_5_0() { return cRestrictedRangeEntityCrossReference_5_0; }
		
		//Reference
		public RuleCall getRestrictedRangeEntityReferenceParserRuleCall_5_0_1() { return cRestrictedRangeEntityReferenceParserRuleCall_5_0_1; }
	}
	public class AspectSpecializationAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.AspectSpecializationAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSubEntityAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSubEntityEntityCrossReference_0_0 = (CrossReference)cSubEntityAssignment_0.eContents().get(0);
		private final RuleCall cSubEntityEntityReferenceParserRuleCall_0_0_1 = (RuleCall)cSubEntityEntityCrossReference_0_0.eContents().get(1);
		private final Keyword cExtendsAspectKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cSuperAspectAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cSuperAspectAspectCrossReference_2_0 = (CrossReference)cSuperAspectAssignment_2.eContents().get(0);
		private final RuleCall cSuperAspectAspectReferenceParserRuleCall_2_0_1 = (RuleCall)cSuperAspectAspectCrossReference_2_0.eContents().get(1);
		
		//// 3 SpecializationAxioms
		//AspectSpecializationAxiom:
		//	subEntity=[Entity|Reference] 'extendsAspect' superAspect=[Aspect|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//subEntity=[Entity|Reference] 'extendsAspect' superAspect=[Aspect|Reference]
		public Group getGroup() { return cGroup; }
		
		//subEntity=[Entity|Reference]
		public Assignment getSubEntityAssignment_0() { return cSubEntityAssignment_0; }
		
		//[Entity|Reference]
		public CrossReference getSubEntityEntityCrossReference_0_0() { return cSubEntityEntityCrossReference_0_0; }
		
		//Reference
		public RuleCall getSubEntityEntityReferenceParserRuleCall_0_0_1() { return cSubEntityEntityReferenceParserRuleCall_0_0_1; }
		
		//'extendsAspect'
		public Keyword getExtendsAspectKeyword_1() { return cExtendsAspectKeyword_1; }
		
		//superAspect=[Aspect|Reference]
		public Assignment getSuperAspectAssignment_2() { return cSuperAspectAssignment_2; }
		
		//[Aspect|Reference]
		public CrossReference getSuperAspectAspectCrossReference_2_0() { return cSuperAspectAspectCrossReference_2_0; }
		
		//Reference
		public RuleCall getSuperAspectAspectReferenceParserRuleCall_2_0_1() { return cSuperAspectAspectReferenceParserRuleCall_2_0_1; }
	}
	public class ConceptSpecializationAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ConceptSpecializationAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSubConceptAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSubConceptConceptCrossReference_0_0 = (CrossReference)cSubConceptAssignment_0.eContents().get(0);
		private final RuleCall cSubConceptConceptReferenceParserRuleCall_0_0_1 = (RuleCall)cSubConceptConceptCrossReference_0_0.eContents().get(1);
		private final Keyword cExtendsConceptKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cSuperConceptAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cSuperConceptConceptCrossReference_2_0 = (CrossReference)cSuperConceptAssignment_2.eContents().get(0);
		private final RuleCall cSuperConceptConceptReferenceParserRuleCall_2_0_1 = (RuleCall)cSuperConceptConceptCrossReference_2_0.eContents().get(1);
		
		//ConceptSpecializationAxiom:
		//	subConcept=[Concept|Reference] 'extendsConcept' superConcept=[Concept|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//subConcept=[Concept|Reference] 'extendsConcept' superConcept=[Concept|Reference]
		public Group getGroup() { return cGroup; }
		
		//subConcept=[Concept|Reference]
		public Assignment getSubConceptAssignment_0() { return cSubConceptAssignment_0; }
		
		//[Concept|Reference]
		public CrossReference getSubConceptConceptCrossReference_0_0() { return cSubConceptConceptCrossReference_0_0; }
		
		//Reference
		public RuleCall getSubConceptConceptReferenceParserRuleCall_0_0_1() { return cSubConceptConceptReferenceParserRuleCall_0_0_1; }
		
		//'extendsConcept'
		public Keyword getExtendsConceptKeyword_1() { return cExtendsConceptKeyword_1; }
		
		//superConcept=[Concept|Reference]
		public Assignment getSuperConceptAssignment_2() { return cSuperConceptAssignment_2; }
		
		//[Concept|Reference]
		public CrossReference getSuperConceptConceptCrossReference_2_0() { return cSuperConceptConceptCrossReference_2_0; }
		
		//Reference
		public RuleCall getSuperConceptConceptReferenceParserRuleCall_2_0_1() { return cSuperConceptConceptReferenceParserRuleCall_2_0_1; }
	}
	public class ReifiedRelationshipSpecializationAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipSpecializationAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSubRelationshipAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSubRelationshipReifiedRelationshipCrossReference_0_0 = (CrossReference)cSubRelationshipAssignment_0.eContents().get(0);
		private final RuleCall cSubRelationshipReifiedRelationshipReferenceParserRuleCall_0_0_1 = (RuleCall)cSubRelationshipReifiedRelationshipCrossReference_0_0.eContents().get(1);
		private final Keyword cExtendsRelationshipKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cSuperRelationshipAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cSuperRelationshipReifiedRelationshipCrossReference_2_0 = (CrossReference)cSuperRelationshipAssignment_2.eContents().get(0);
		private final RuleCall cSuperRelationshipReifiedRelationshipReferenceParserRuleCall_2_0_1 = (RuleCall)cSuperRelationshipReifiedRelationshipCrossReference_2_0.eContents().get(1);
		
		//ReifiedRelationshipSpecializationAxiom:
		//	subRelationship=[ReifiedRelationship|Reference] 'extendsRelationship'
		//	superRelationship=[ReifiedRelationship|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//subRelationship=[ReifiedRelationship|Reference] 'extendsRelationship' superRelationship=[ReifiedRelationship|Reference]
		public Group getGroup() { return cGroup; }
		
		//subRelationship=[ReifiedRelationship|Reference]
		public Assignment getSubRelationshipAssignment_0() { return cSubRelationshipAssignment_0; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getSubRelationshipReifiedRelationshipCrossReference_0_0() { return cSubRelationshipReifiedRelationshipCrossReference_0_0; }
		
		//Reference
		public RuleCall getSubRelationshipReifiedRelationshipReferenceParserRuleCall_0_0_1() { return cSubRelationshipReifiedRelationshipReferenceParserRuleCall_0_0_1; }
		
		//'extendsRelationship'
		public Keyword getExtendsRelationshipKeyword_1() { return cExtendsRelationshipKeyword_1; }
		
		//superRelationship=[ReifiedRelationship|Reference]
		public Assignment getSuperRelationshipAssignment_2() { return cSuperRelationshipAssignment_2; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getSuperRelationshipReifiedRelationshipCrossReference_2_0() { return cSuperRelationshipReifiedRelationshipCrossReference_2_0; }
		
		//Reference
		public RuleCall getSuperRelationshipReifiedRelationshipReferenceParserRuleCall_2_0_1() { return cSuperRelationshipReifiedRelationshipReferenceParserRuleCall_2_0_1; }
	}
	public class EntityScalarDataPropertyExistentialRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataPropertyExistentialRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSomeDataKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRestrictedEntityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRestrictedEntityEntityCrossReference_1_0 = (CrossReference)cRestrictedEntityAssignment_1.eContents().get(0);
		private final RuleCall cRestrictedEntityEntityReferenceParserRuleCall_1_0_1 = (RuleCall)cRestrictedEntityEntityCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cScalarPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cScalarPropertyEntityScalarDataPropertyCrossReference_3_0 = (CrossReference)cScalarPropertyAssignment_3.eContents().get(0);
		private final RuleCall cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1 = (RuleCall)cScalarPropertyEntityScalarDataPropertyCrossReference_3_0.eContents().get(1);
		private final Keyword cInKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cScalarRestrictionAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cScalarRestrictionDataRangeCrossReference_5_0 = (CrossReference)cScalarRestrictionAssignment_5.eContents().get(0);
		private final RuleCall cScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cScalarRestrictionDataRangeCrossReference_5_0.eContents().get(1);
		
		//// 3 EntityScalarDataPropertyRestrictionAxioms
		//EntityScalarDataPropertyExistentialRestrictionAxiom:
		//	'someData'
		//	restrictedEntity=[Entity|Reference]
		//	'.'
		//	scalarProperty=[EntityScalarDataProperty|Reference]
		//	'in' scalarRestriction=[DataRange|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//'someData' restrictedEntity=[Entity|Reference] '.' scalarProperty=[EntityScalarDataProperty|Reference] 'in'
		//scalarRestriction=[DataRange|Reference]
		public Group getGroup() { return cGroup; }
		
		//'someData'
		public Keyword getSomeDataKeyword_0() { return cSomeDataKeyword_0; }
		
		//restrictedEntity=[Entity|Reference]
		public Assignment getRestrictedEntityAssignment_1() { return cRestrictedEntityAssignment_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedEntityEntityCrossReference_1_0() { return cRestrictedEntityEntityCrossReference_1_0; }
		
		//Reference
		public RuleCall getRestrictedEntityEntityReferenceParserRuleCall_1_0_1() { return cRestrictedEntityEntityReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//scalarProperty=[EntityScalarDataProperty|Reference]
		public Assignment getScalarPropertyAssignment_3() { return cScalarPropertyAssignment_3; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getScalarPropertyEntityScalarDataPropertyCrossReference_3_0() { return cScalarPropertyEntityScalarDataPropertyCrossReference_3_0; }
		
		//Reference
		public RuleCall getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1() { return cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1; }
		
		//'in'
		public Keyword getInKeyword_4() { return cInKeyword_4; }
		
		//scalarRestriction=[DataRange|Reference]
		public Assignment getScalarRestrictionAssignment_5() { return cScalarRestrictionAssignment_5; }
		
		//[DataRange|Reference]
		public CrossReference getScalarRestrictionDataRangeCrossReference_5_0() { return cScalarRestrictionDataRangeCrossReference_5_0; }
		
		//Reference
		public RuleCall getScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1() { return cScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1; }
	}
	public class EntityScalarDataPropertyParticularRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataPropertyParticularRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEveryKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRestrictedEntityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRestrictedEntityEntityCrossReference_1_0 = (CrossReference)cRestrictedEntityAssignment_1.eContents().get(0);
		private final RuleCall cRestrictedEntityEntityReferenceParserRuleCall_1_0_1 = (RuleCall)cRestrictedEntityEntityCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cScalarPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cScalarPropertyEntityScalarDataPropertyCrossReference_3_0 = (CrossReference)cScalarPropertyAssignment_3.eContents().get(0);
		private final RuleCall cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1 = (RuleCall)cScalarPropertyEntityScalarDataPropertyCrossReference_3_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cLiteralValueAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cLiteralValueValueParserRuleCall_5_0 = (RuleCall)cLiteralValueAssignment_5.eContents().get(0);
		
		//EntityScalarDataPropertyParticularRestrictionAxiom:
		//	'every'
		//	restrictedEntity=[Entity|Reference]
		//	'.' scalarProperty=[EntityScalarDataProperty|Reference]
		//	'=' literalValue=Value;
		@Override public ParserRule getRule() { return rule; }
		
		//'every' restrictedEntity=[Entity|Reference] '.' scalarProperty=[EntityScalarDataProperty|Reference] '='
		//literalValue=Value
		public Group getGroup() { return cGroup; }
		
		//'every'
		public Keyword getEveryKeyword_0() { return cEveryKeyword_0; }
		
		//restrictedEntity=[Entity|Reference]
		public Assignment getRestrictedEntityAssignment_1() { return cRestrictedEntityAssignment_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedEntityEntityCrossReference_1_0() { return cRestrictedEntityEntityCrossReference_1_0; }
		
		//Reference
		public RuleCall getRestrictedEntityEntityReferenceParserRuleCall_1_0_1() { return cRestrictedEntityEntityReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//scalarProperty=[EntityScalarDataProperty|Reference]
		public Assignment getScalarPropertyAssignment_3() { return cScalarPropertyAssignment_3; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getScalarPropertyEntityScalarDataPropertyCrossReference_3_0() { return cScalarPropertyEntityScalarDataPropertyCrossReference_3_0; }
		
		//Reference
		public RuleCall getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1() { return cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }
		
		//literalValue=Value
		public Assignment getLiteralValueAssignment_5() { return cLiteralValueAssignment_5; }
		
		//Value
		public RuleCall getLiteralValueValueParserRuleCall_5_0() { return cLiteralValueValueParserRuleCall_5_0; }
	}
	public class EntityScalarDataPropertyUniversalRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityScalarDataPropertyUniversalRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAllDataKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRestrictedEntityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRestrictedEntityEntityCrossReference_1_0 = (CrossReference)cRestrictedEntityAssignment_1.eContents().get(0);
		private final RuleCall cRestrictedEntityEntityReferenceParserRuleCall_1_0_1 = (RuleCall)cRestrictedEntityEntityCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cScalarPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cScalarPropertyEntityScalarDataPropertyCrossReference_3_0 = (CrossReference)cScalarPropertyAssignment_3.eContents().get(0);
		private final RuleCall cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1 = (RuleCall)cScalarPropertyEntityScalarDataPropertyCrossReference_3_0.eContents().get(1);
		private final Keyword cInKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cScalarRestrictionAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cScalarRestrictionDataRangeCrossReference_5_0 = (CrossReference)cScalarRestrictionAssignment_5.eContents().get(0);
		private final RuleCall cScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cScalarRestrictionDataRangeCrossReference_5_0.eContents().get(1);
		
		//EntityScalarDataPropertyUniversalRestrictionAxiom:
		//	'allData'
		//	restrictedEntity=[Entity|Reference]
		//	'.' scalarProperty=[EntityScalarDataProperty|Reference]
		//	'in' scalarRestriction=[DataRange|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//'allData' restrictedEntity=[Entity|Reference] '.' scalarProperty=[EntityScalarDataProperty|Reference] 'in'
		//scalarRestriction=[DataRange|Reference]
		public Group getGroup() { return cGroup; }
		
		//'allData'
		public Keyword getAllDataKeyword_0() { return cAllDataKeyword_0; }
		
		//restrictedEntity=[Entity|Reference]
		public Assignment getRestrictedEntityAssignment_1() { return cRestrictedEntityAssignment_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedEntityEntityCrossReference_1_0() { return cRestrictedEntityEntityCrossReference_1_0; }
		
		//Reference
		public RuleCall getRestrictedEntityEntityReferenceParserRuleCall_1_0_1() { return cRestrictedEntityEntityReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//scalarProperty=[EntityScalarDataProperty|Reference]
		public Assignment getScalarPropertyAssignment_3() { return cScalarPropertyAssignment_3; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getScalarPropertyEntityScalarDataPropertyCrossReference_3_0() { return cScalarPropertyEntityScalarDataPropertyCrossReference_3_0; }
		
		//Reference
		public RuleCall getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1() { return cScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1; }
		
		//'in'
		public Keyword getInKeyword_4() { return cInKeyword_4; }
		
		//scalarRestriction=[DataRange|Reference]
		public Assignment getScalarRestrictionAssignment_5() { return cScalarRestrictionAssignment_5; }
		
		//[DataRange|Reference]
		public CrossReference getScalarRestrictionDataRangeCrossReference_5_0() { return cScalarRestrictionDataRangeCrossReference_5_0; }
		
		//Reference
		public RuleCall getScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1() { return cScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1; }
	}
	public class EntityStructuredDataPropertyParticularRestrictionAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.EntityStructuredDataPropertyParticularRestrictionAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEveryKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRestrictedEntityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRestrictedEntityEntityCrossReference_1_0 = (CrossReference)cRestrictedEntityAssignment_1.eContents().get(0);
		private final RuleCall cRestrictedEntityEntityReferenceParserRuleCall_1_0_1 = (RuleCall)cRestrictedEntityEntityCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cStructuredDataPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cStructuredDataPropertyEntityStructuredDataPropertyCrossReference_3_0 = (CrossReference)cStructuredDataPropertyAssignment_3.eContents().get(0);
		private final RuleCall cStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_3_0_1 = (RuleCall)cStructuredDataPropertyEntityStructuredDataPropertyCrossReference_3_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Assignment cStructuredPropertyTuplesAssignment_6_0 = (Assignment)cAlternatives_6.eContents().get(0);
		private final RuleCall cStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_6_0_0 = (RuleCall)cStructuredPropertyTuplesAssignment_6_0.eContents().get(0);
		private final Assignment cScalarDataPropertyValuesAssignment_6_1 = (Assignment)cAlternatives_6.eContents().get(1);
		private final RuleCall cScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_6_1_0 = (RuleCall)cScalarDataPropertyValuesAssignment_6_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//// 1 EntityStructuredDataPropertyRestrictionAxiom
		//EntityStructuredDataPropertyParticularRestrictionAxiom:
		//	'every'
		//	restrictedEntity=[Entity|Reference]
		//	'.'
		//	structuredDataProperty=[EntityStructuredDataProperty|Reference]
		//	'='
		//	'{' (structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple |
		//	scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'every' restrictedEntity=[Entity|Reference] '.' structuredDataProperty=[EntityStructuredDataProperty|Reference] '=' '{'
		//(structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple |
		//scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//'every'
		public Keyword getEveryKeyword_0() { return cEveryKeyword_0; }
		
		//restrictedEntity=[Entity|Reference]
		public Assignment getRestrictedEntityAssignment_1() { return cRestrictedEntityAssignment_1; }
		
		//[Entity|Reference]
		public CrossReference getRestrictedEntityEntityCrossReference_1_0() { return cRestrictedEntityEntityCrossReference_1_0; }
		
		//Reference
		public RuleCall getRestrictedEntityEntityReferenceParserRuleCall_1_0_1() { return cRestrictedEntityEntityReferenceParserRuleCall_1_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//structuredDataProperty=[EntityStructuredDataProperty|Reference]
		public Assignment getStructuredDataPropertyAssignment_3() { return cStructuredDataPropertyAssignment_3; }
		
		//[EntityStructuredDataProperty|Reference]
		public CrossReference getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_3_0() { return cStructuredDataPropertyEntityStructuredDataPropertyCrossReference_3_0; }
		
		//Reference
		public RuleCall getStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_3_0_1() { return cStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_3_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//(structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple |
		//scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)*
		public Alternatives getAlternatives_6() { return cAlternatives_6; }
		
		//structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple
		public Assignment getStructuredPropertyTuplesAssignment_6_0() { return cStructuredPropertyTuplesAssignment_6_0; }
		
		//RestrictionStructuredDataPropertyTuple
		public RuleCall getStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_6_0_0() { return cStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_6_0_0; }
		
		//scalarDataPropertyValues+=RestrictionScalarDataPropertyValue
		public Assignment getScalarDataPropertyValuesAssignment_6_1() { return cScalarDataPropertyValuesAssignment_6_1; }
		
		//RestrictionScalarDataPropertyValue
		public RuleCall getScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_6_1_0() { return cScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_6_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class RestrictionStructuredDataPropertyTupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RestrictionStructuredDataPropertyTuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStructuredDataPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cStructuredDataPropertyStructuredDataPropertyCrossReference_0_0 = (CrossReference)cStructuredDataPropertyAssignment_0.eContents().get(0);
		private final RuleCall cStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_0_0_1 = (RuleCall)cStructuredDataPropertyStructuredDataPropertyCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cStructuredPropertyTuplesAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_3_0_0 = (RuleCall)cStructuredPropertyTuplesAssignment_3_0.eContents().get(0);
		private final Assignment cScalarDataPropertyValuesAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final RuleCall cScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_3_1_0 = (RuleCall)cScalarDataPropertyValuesAssignment_3_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//RestrictionStructuredDataPropertyTuple:
		//	structuredDataProperty=[StructuredDataProperty|Reference]
		//	'=' '{' (structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple |
		//	scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//structuredDataProperty=[StructuredDataProperty|Reference] '=' '{'
		//(structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple |
		//scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//structuredDataProperty=[StructuredDataProperty|Reference]
		public Assignment getStructuredDataPropertyAssignment_0() { return cStructuredDataPropertyAssignment_0; }
		
		//[StructuredDataProperty|Reference]
		public CrossReference getStructuredDataPropertyStructuredDataPropertyCrossReference_0_0() { return cStructuredDataPropertyStructuredDataPropertyCrossReference_0_0; }
		
		//Reference
		public RuleCall getStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_0_0_1() { return cStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_0_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple |
		//scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)*
		public Alternatives getAlternatives_3() { return cAlternatives_3; }
		
		//structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple
		public Assignment getStructuredPropertyTuplesAssignment_3_0() { return cStructuredPropertyTuplesAssignment_3_0; }
		
		//RestrictionStructuredDataPropertyTuple
		public RuleCall getStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_3_0_0() { return cStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_3_0_0; }
		
		//scalarDataPropertyValues+=RestrictionScalarDataPropertyValue
		public Assignment getScalarDataPropertyValuesAssignment_3_1() { return cScalarDataPropertyValuesAssignment_3_1; }
		
		//RestrictionScalarDataPropertyValue
		public RuleCall getScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_3_1_0() { return cScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_3_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class RestrictionScalarDataPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.RestrictionScalarDataPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cScalarDataPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cScalarDataPropertyScalarDataPropertyCrossReference_0_0 = (CrossReference)cScalarDataPropertyAssignment_0.eContents().get(0);
		private final RuleCall cScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_0_0_1 = (RuleCall)cScalarDataPropertyScalarDataPropertyCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cScalarPropertyValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cScalarPropertyValueValueParserRuleCall_2_0 = (RuleCall)cScalarPropertyValueAssignment_2.eContents().get(0);
		
		//RestrictionScalarDataPropertyValue:
		//	scalarDataProperty=[ScalarDataProperty|Reference]
		//	'='
		//	scalarPropertyValue=Value;
		@Override public ParserRule getRule() { return rule; }
		
		//scalarDataProperty=[ScalarDataProperty|Reference] '=' scalarPropertyValue=Value
		public Group getGroup() { return cGroup; }
		
		//scalarDataProperty=[ScalarDataProperty|Reference]
		public Assignment getScalarDataPropertyAssignment_0() { return cScalarDataPropertyAssignment_0; }
		
		//[ScalarDataProperty|Reference]
		public CrossReference getScalarDataPropertyScalarDataPropertyCrossReference_0_0() { return cScalarDataPropertyScalarDataPropertyCrossReference_0_0; }
		
		//Reference
		public RuleCall getScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_0_0_1() { return cScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_0_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }
		
		//scalarPropertyValue=Value
		public Assignment getScalarPropertyValueAssignment_2() { return cScalarPropertyValueAssignment_2; }
		
		//Value
		public RuleCall getScalarPropertyValueValueParserRuleCall_2_0() { return cScalarPropertyValueValueParserRuleCall_2_0; }
	}
	public class BinaryScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.BinaryScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cBinaryScalarRestrictionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cLengthKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cLengthAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cLengthINTTerminalRuleCall_3_0_1_0 = (RuleCall)cLengthAssignment_3_0_1.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cMinLengthKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cMinLengthINTTerminalRuleCall_3_1_1_0 = (RuleCall)cMinLengthAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cMaxLengthKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cMaxLengthINTTerminalRuleCall_3_2_1_0 = (RuleCall)cMaxLengthAssignment_3_2_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//// 8 RestrictedDataRanges + 1 ScalarOneOfLiteralAxiom
		//BinaryScalarRestriction:
		//	'binaryScalarRestriction' name=ID
		//	'{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'binaryScalarRestriction' name=ID '{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength'
		//maxLength=INT)?) 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'binaryScalarRestriction'
		public Keyword getBinaryScalarRestrictionKeyword_0() { return cBinaryScalarRestrictionKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }
		
		//('length' length=INT)?
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//'length'
		public Keyword getLengthKeyword_3_0_0() { return cLengthKeyword_3_0_0; }
		
		//length=INT
		public Assignment getLengthAssignment_3_0_1() { return cLengthAssignment_3_0_1; }
		
		//INT
		public RuleCall getLengthINTTerminalRuleCall_3_0_1_0() { return cLengthINTTerminalRuleCall_3_0_1_0; }
		
		//('minLength' minLength=INT)?
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_3_1_0() { return cMinLengthKeyword_3_1_0; }
		
		//minLength=INT
		public Assignment getMinLengthAssignment_3_1_1() { return cMinLengthAssignment_3_1_1; }
		
		//INT
		public RuleCall getMinLengthINTTerminalRuleCall_3_1_1_0() { return cMinLengthINTTerminalRuleCall_3_1_1_0; }
		
		//('maxLength' maxLength=INT)?
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_3_2_0() { return cMaxLengthKeyword_3_2_0; }
		
		//maxLength=INT
		public Assignment getMaxLengthAssignment_3_2_1() { return cMaxLengthAssignment_3_2_1; }
		
		//INT
		public RuleCall getMaxLengthINTTerminalRuleCall_3_2_1_0() { return cMaxLengthINTTerminalRuleCall_3_2_1_0; }
		
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
	public class IRIScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IRIScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIriScalarRestrictionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cLengthKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cLengthAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cLengthINTTerminalRuleCall_3_0_1_0 = (RuleCall)cLengthAssignment_3_0_1.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cMinLengthKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cMinLengthINTTerminalRuleCall_3_1_1_0 = (RuleCall)cMinLengthAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cMaxLengthKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cMaxLengthINTTerminalRuleCall_3_2_1_0 = (RuleCall)cMaxLengthAssignment_3_2_1.eContents().get(0);
		private final Group cGroup_3_3 = (Group)cUnorderedGroup_3.eContents().get(3);
		private final Keyword cPatternKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cPatternAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final RuleCall cPatternSTRINGTerminalRuleCall_3_3_1_0 = (RuleCall)cPatternAssignment_3_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//IRIScalarRestriction:
		//	'iriScalarRestriction' name=ID
		//	'{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern'
		//	pattern=STRING)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'iriScalarRestriction' name=ID '{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)?
		//& ('pattern' pattern=STRING)?) 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'iriScalarRestriction'
		public Keyword getIriScalarRestrictionKeyword_0() { return cIriScalarRestrictionKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern' pattern=STRING)?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }
		
		//('length' length=INT)?
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//'length'
		public Keyword getLengthKeyword_3_0_0() { return cLengthKeyword_3_0_0; }
		
		//length=INT
		public Assignment getLengthAssignment_3_0_1() { return cLengthAssignment_3_0_1; }
		
		//INT
		public RuleCall getLengthINTTerminalRuleCall_3_0_1_0() { return cLengthINTTerminalRuleCall_3_0_1_0; }
		
		//('minLength' minLength=INT)?
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_3_1_0() { return cMinLengthKeyword_3_1_0; }
		
		//minLength=INT
		public Assignment getMinLengthAssignment_3_1_1() { return cMinLengthAssignment_3_1_1; }
		
		//INT
		public RuleCall getMinLengthINTTerminalRuleCall_3_1_1_0() { return cMinLengthINTTerminalRuleCall_3_1_1_0; }
		
		//('maxLength' maxLength=INT)?
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_3_2_0() { return cMaxLengthKeyword_3_2_0; }
		
		//maxLength=INT
		public Assignment getMaxLengthAssignment_3_2_1() { return cMaxLengthAssignment_3_2_1; }
		
		//INT
		public RuleCall getMaxLengthINTTerminalRuleCall_3_2_1_0() { return cMaxLengthINTTerminalRuleCall_3_2_1_0; }
		
		//('pattern' pattern=STRING)?
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_3_3_0() { return cPatternKeyword_3_3_0; }
		
		//pattern=STRING
		public Assignment getPatternAssignment_3_3_1() { return cPatternAssignment_3_3_1; }
		
		//STRING
		public RuleCall getPatternSTRINGTerminalRuleCall_3_3_1_0() { return cPatternSTRINGTerminalRuleCall_3_3_1_0; }
		
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
	public class NumericScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.NumericScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNumericScalarRestrictionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cMinInclusiveKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cMinInclusiveAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cMinInclusiveSTRINGTerminalRuleCall_3_0_1_0 = (RuleCall)cMinInclusiveAssignment_3_0_1.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cMaxInclusiveKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cMaxInclusiveAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0 = (RuleCall)cMaxInclusiveAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cMinExclusiveKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cMinExclusiveAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cMinExclusiveSTRINGTerminalRuleCall_3_2_1_0 = (RuleCall)cMinExclusiveAssignment_3_2_1.eContents().get(0);
		private final Group cGroup_3_3 = (Group)cUnorderedGroup_3.eContents().get(3);
		private final Keyword cMaxExclusiveKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cMaxExclusiveAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final RuleCall cMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0 = (RuleCall)cMaxExclusiveAssignment_3_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//NumericScalarRestriction:
		//	'numericScalarRestriction' name=ID
		//	'{' (('minInclusive' minInclusive=STRING)? & ('maxInclusive' maxInclusive=STRING)? & ('minExclusive'
		//	minExclusive=STRING)? & ('maxExclusive' maxExclusive=STRING)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'numericScalarRestriction' name=ID '{' (('minInclusive' minInclusive=STRING)? & ('maxInclusive' maxInclusive=STRING)? &
		//('minExclusive' minExclusive=STRING)? & ('maxExclusive' maxExclusive=STRING)?) 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'numericScalarRestriction'
		public Keyword getNumericScalarRestrictionKeyword_0() { return cNumericScalarRestrictionKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('minInclusive' minInclusive=STRING)? & ('maxInclusive' maxInclusive=STRING)? & ('minExclusive' minExclusive=STRING)? &
		//('maxExclusive' maxExclusive=STRING)?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }
		
		//('minInclusive' minInclusive=STRING)?
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//'minInclusive'
		public Keyword getMinInclusiveKeyword_3_0_0() { return cMinInclusiveKeyword_3_0_0; }
		
		//minInclusive=STRING
		public Assignment getMinInclusiveAssignment_3_0_1() { return cMinInclusiveAssignment_3_0_1; }
		
		//STRING
		public RuleCall getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0() { return cMinInclusiveSTRINGTerminalRuleCall_3_0_1_0; }
		
		//('maxInclusive' maxInclusive=STRING)?
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//'maxInclusive'
		public Keyword getMaxInclusiveKeyword_3_1_0() { return cMaxInclusiveKeyword_3_1_0; }
		
		//maxInclusive=STRING
		public Assignment getMaxInclusiveAssignment_3_1_1() { return cMaxInclusiveAssignment_3_1_1; }
		
		//STRING
		public RuleCall getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0() { return cMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0; }
		
		//('minExclusive' minExclusive=STRING)?
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//'minExclusive'
		public Keyword getMinExclusiveKeyword_3_2_0() { return cMinExclusiveKeyword_3_2_0; }
		
		//minExclusive=STRING
		public Assignment getMinExclusiveAssignment_3_2_1() { return cMinExclusiveAssignment_3_2_1; }
		
		//STRING
		public RuleCall getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0() { return cMinExclusiveSTRINGTerminalRuleCall_3_2_1_0; }
		
		//('maxExclusive' maxExclusive=STRING)?
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//'maxExclusive'
		public Keyword getMaxExclusiveKeyword_3_3_0() { return cMaxExclusiveKeyword_3_3_0; }
		
		//maxExclusive=STRING
		public Assignment getMaxExclusiveAssignment_3_3_1() { return cMaxExclusiveAssignment_3_3_1; }
		
		//STRING
		public RuleCall getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0() { return cMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0; }
		
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
	public class PlainLiteralScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.PlainLiteralScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPlainLiteralScalarRestrictionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cLengthKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cLengthAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cLengthINTTerminalRuleCall_3_0_1_0 = (RuleCall)cLengthAssignment_3_0_1.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cMinLengthKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cMinLengthINTTerminalRuleCall_3_1_1_0 = (RuleCall)cMinLengthAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cMaxLengthKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cMaxLengthINTTerminalRuleCall_3_2_1_0 = (RuleCall)cMaxLengthAssignment_3_2_1.eContents().get(0);
		private final Group cGroup_3_3 = (Group)cUnorderedGroup_3.eContents().get(3);
		private final Keyword cPatternKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cPatternAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final RuleCall cPatternSTRINGTerminalRuleCall_3_3_1_0 = (RuleCall)cPatternAssignment_3_3_1.eContents().get(0);
		private final Group cGroup_3_4 = (Group)cUnorderedGroup_3.eContents().get(4);
		private final Keyword cLangRangeKeyword_3_4_0 = (Keyword)cGroup_3_4.eContents().get(0);
		private final Assignment cLangRangeAssignment_3_4_1 = (Assignment)cGroup_3_4.eContents().get(1);
		private final RuleCall cLangRangeSTRINGTerminalRuleCall_3_4_1_0 = (RuleCall)cLangRangeAssignment_3_4_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//PlainLiteralScalarRestriction:
		//	'plainLiteralScalarRestriction' name=ID
		//	'{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern'
		//	pattern=STRING)? & ('langRange' langRange=STRING)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'plainLiteralScalarRestriction' name=ID '{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength'
		//maxLength=INT)? & ('pattern' pattern=STRING)? & ('langRange' langRange=STRING)?) 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'plainLiteralScalarRestriction'
		public Keyword getPlainLiteralScalarRestrictionKeyword_0() { return cPlainLiteralScalarRestrictionKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern' pattern=STRING)? &
		//('langRange' langRange=STRING)?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }
		
		//('length' length=INT)?
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//'length'
		public Keyword getLengthKeyword_3_0_0() { return cLengthKeyword_3_0_0; }
		
		//length=INT
		public Assignment getLengthAssignment_3_0_1() { return cLengthAssignment_3_0_1; }
		
		//INT
		public RuleCall getLengthINTTerminalRuleCall_3_0_1_0() { return cLengthINTTerminalRuleCall_3_0_1_0; }
		
		//('minLength' minLength=INT)?
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_3_1_0() { return cMinLengthKeyword_3_1_0; }
		
		//minLength=INT
		public Assignment getMinLengthAssignment_3_1_1() { return cMinLengthAssignment_3_1_1; }
		
		//INT
		public RuleCall getMinLengthINTTerminalRuleCall_3_1_1_0() { return cMinLengthINTTerminalRuleCall_3_1_1_0; }
		
		//('maxLength' maxLength=INT)?
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_3_2_0() { return cMaxLengthKeyword_3_2_0; }
		
		//maxLength=INT
		public Assignment getMaxLengthAssignment_3_2_1() { return cMaxLengthAssignment_3_2_1; }
		
		//INT
		public RuleCall getMaxLengthINTTerminalRuleCall_3_2_1_0() { return cMaxLengthINTTerminalRuleCall_3_2_1_0; }
		
		//('pattern' pattern=STRING)?
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_3_3_0() { return cPatternKeyword_3_3_0; }
		
		//pattern=STRING
		public Assignment getPatternAssignment_3_3_1() { return cPatternAssignment_3_3_1; }
		
		//STRING
		public RuleCall getPatternSTRINGTerminalRuleCall_3_3_1_0() { return cPatternSTRINGTerminalRuleCall_3_3_1_0; }
		
		//('langRange' langRange=STRING)?
		public Group getGroup_3_4() { return cGroup_3_4; }
		
		//'langRange'
		public Keyword getLangRangeKeyword_3_4_0() { return cLangRangeKeyword_3_4_0; }
		
		//langRange=STRING
		public Assignment getLangRangeAssignment_3_4_1() { return cLangRangeAssignment_3_4_1; }
		
		//STRING
		public RuleCall getLangRangeSTRINGTerminalRuleCall_3_4_1_0() { return cLangRangeSTRINGTerminalRuleCall_3_4_1_0; }
		
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
	public class ScalarOneOfRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarOneOfRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cScalarOneOfRestrictionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cRestrictedRangeKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRestrictedRangeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_4_0 = (CrossReference)cRestrictedRangeAssignment_4.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_4_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ScalarOneOfRestriction:
		//	'scalarOneOfRestriction' name=ID
		//	'{'
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'scalarOneOfRestriction' name=ID '{' 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'scalarOneOfRestriction'
		public Keyword getScalarOneOfRestrictionKeyword_0() { return cScalarOneOfRestrictionKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_3() { return cRestrictedRangeKeyword_3; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_4() { return cRestrictedRangeAssignment_4; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_4_0() { return cRestrictedRangeDataRangeCrossReference_4_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class ScalarOneOfLiteralAxiomElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarOneOfLiteralAxiom");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cOneOfKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cAxiomAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cAxiomScalarOneOfRestrictionCrossReference_1_0 = (CrossReference)cAxiomAssignment_1.eContents().get(0);
		private final RuleCall cAxiomScalarOneOfRestrictionReferenceParserRuleCall_1_0_1 = (RuleCall)cAxiomScalarOneOfRestrictionCrossReference_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueSTRINGTerminalRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//ScalarOneOfLiteralAxiom:
		//	'oneOf'
		//	axiom=[ScalarOneOfRestriction|Reference]
		//	'=' value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//'oneOf' axiom=[ScalarOneOfRestriction|Reference] '=' value=STRING
		public Group getGroup() { return cGroup; }
		
		//'oneOf'
		public Keyword getOneOfKeyword_0() { return cOneOfKeyword_0; }
		
		//axiom=[ScalarOneOfRestriction|Reference]
		public Assignment getAxiomAssignment_1() { return cAxiomAssignment_1; }
		
		//[ScalarOneOfRestriction|Reference]
		public CrossReference getAxiomScalarOneOfRestrictionCrossReference_1_0() { return cAxiomScalarOneOfRestrictionCrossReference_1_0; }
		
		//Reference
		public RuleCall getAxiomScalarOneOfRestrictionReferenceParserRuleCall_1_0_1() { return cAxiomScalarOneOfRestrictionReferenceParserRuleCall_1_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//value=STRING
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_3_0() { return cValueSTRINGTerminalRuleCall_3_0; }
	}
	public class StringScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.StringScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStringScalarRestrictionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cLengthKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cLengthAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cLengthINTTerminalRuleCall_3_0_1_0 = (RuleCall)cLengthAssignment_3_0_1.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cMinLengthKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cMinLengthAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cMinLengthINTTerminalRuleCall_3_1_1_0 = (RuleCall)cMinLengthAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cMaxLengthKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cMaxLengthAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cMaxLengthINTTerminalRuleCall_3_2_1_0 = (RuleCall)cMaxLengthAssignment_3_2_1.eContents().get(0);
		private final Group cGroup_3_3 = (Group)cUnorderedGroup_3.eContents().get(3);
		private final Keyword cPatternKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cPatternAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final RuleCall cPatternSTRINGTerminalRuleCall_3_3_1_0 = (RuleCall)cPatternAssignment_3_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//StringScalarRestriction:
		//	'stringScalarRestriction' name=ID
		//	'{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern'
		//	pattern=STRING)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'stringScalarRestriction' name=ID '{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength'
		//maxLength=INT)? & ('pattern' pattern=STRING)?) 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'stringScalarRestriction'
		public Keyword getStringScalarRestrictionKeyword_0() { return cStringScalarRestrictionKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern' pattern=STRING)?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }
		
		//('length' length=INT)?
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//'length'
		public Keyword getLengthKeyword_3_0_0() { return cLengthKeyword_3_0_0; }
		
		//length=INT
		public Assignment getLengthAssignment_3_0_1() { return cLengthAssignment_3_0_1; }
		
		//INT
		public RuleCall getLengthINTTerminalRuleCall_3_0_1_0() { return cLengthINTTerminalRuleCall_3_0_1_0; }
		
		//('minLength' minLength=INT)?
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//'minLength'
		public Keyword getMinLengthKeyword_3_1_0() { return cMinLengthKeyword_3_1_0; }
		
		//minLength=INT
		public Assignment getMinLengthAssignment_3_1_1() { return cMinLengthAssignment_3_1_1; }
		
		//INT
		public RuleCall getMinLengthINTTerminalRuleCall_3_1_1_0() { return cMinLengthINTTerminalRuleCall_3_1_1_0; }
		
		//('maxLength' maxLength=INT)?
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//'maxLength'
		public Keyword getMaxLengthKeyword_3_2_0() { return cMaxLengthKeyword_3_2_0; }
		
		//maxLength=INT
		public Assignment getMaxLengthAssignment_3_2_1() { return cMaxLengthAssignment_3_2_1; }
		
		//INT
		public RuleCall getMaxLengthINTTerminalRuleCall_3_2_1_0() { return cMaxLengthINTTerminalRuleCall_3_2_1_0; }
		
		//('pattern' pattern=STRING)?
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//'pattern'
		public Keyword getPatternKeyword_3_3_0() { return cPatternKeyword_3_3_0; }
		
		//pattern=STRING
		public Assignment getPatternAssignment_3_3_1() { return cPatternAssignment_3_3_1; }
		
		//STRING
		public RuleCall getPatternSTRINGTerminalRuleCall_3_3_1_0() { return cPatternSTRINGTerminalRuleCall_3_3_1_0; }
		
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
	public class SynonymScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SynonymScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSynonymScalarRestrictionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cRestrictedRangeKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRestrictedRangeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_4_0 = (CrossReference)cRestrictedRangeAssignment_4.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_4_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//SynonymScalarRestriction:
		//	'synonymScalarRestriction' name=ID
		//	'{'
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'synonymScalarRestriction' name=ID '{' 'restrictedRange' restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'synonymScalarRestriction'
		public Keyword getSynonymScalarRestrictionKeyword_0() { return cSynonymScalarRestrictionKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//'restrictedRange'
		public Keyword getRestrictedRangeKeyword_3() { return cRestrictedRangeKeyword_3; }
		
		//restrictedRange=[DataRange|Reference]
		public Assignment getRestrictedRangeAssignment_4() { return cRestrictedRangeAssignment_4; }
		
		//[DataRange|Reference]
		public CrossReference getRestrictedRangeDataRangeCrossReference_4_0() { return cRestrictedRangeDataRangeCrossReference_4_0; }
		
		//Reference
		public RuleCall getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1() { return cRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class TimeScalarRestrictionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.TimeScalarRestriction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTimeScalarRestrictionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cMinInclusiveKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cMinInclusiveAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cMinInclusiveSTRINGTerminalRuleCall_3_0_1_0 = (RuleCall)cMinInclusiveAssignment_3_0_1.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cMaxInclusiveKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cMaxInclusiveAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0 = (RuleCall)cMaxInclusiveAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cMinExclusiveKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cMinExclusiveAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cMinExclusiveSTRINGTerminalRuleCall_3_2_1_0 = (RuleCall)cMinExclusiveAssignment_3_2_1.eContents().get(0);
		private final Group cGroup_3_3 = (Group)cUnorderedGroup_3.eContents().get(3);
		private final Keyword cMaxExclusiveKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cMaxExclusiveAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final RuleCall cMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0 = (RuleCall)cMaxExclusiveAssignment_3_3_1.eContents().get(0);
		private final Keyword cRestrictedRangeKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRestrictedRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRestrictedRangeDataRangeCrossReference_5_0 = (CrossReference)cRestrictedRangeAssignment_5.eContents().get(0);
		private final RuleCall cRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = (RuleCall)cRestrictedRangeDataRangeCrossReference_5_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//TimeScalarRestriction:
		//	'timeScalarRestriction' name=ID
		//	'{' (('minInclusive' minInclusive=STRING)? & ('maxInclusive' maxInclusive=STRING)? & ('minExclusive'
		//	minExclusive=STRING)? & ('maxExclusive' maxExclusive=STRING)?)
		//	'restrictedRange' restrictedRange=[DataRange|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'timeScalarRestriction' name=ID '{' (('minInclusive' minInclusive=STRING)? & ('maxInclusive' maxInclusive=STRING)? &
		//('minExclusive' minExclusive=STRING)? & ('maxExclusive' maxExclusive=STRING)?) 'restrictedRange'
		//restrictedRange=[DataRange|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'timeScalarRestriction'
		public Keyword getTimeScalarRestrictionKeyword_0() { return cTimeScalarRestrictionKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('minInclusive' minInclusive=STRING)? & ('maxInclusive' maxInclusive=STRING)? & ('minExclusive' minExclusive=STRING)? &
		//('maxExclusive' maxExclusive=STRING)?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }
		
		//('minInclusive' minInclusive=STRING)?
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//'minInclusive'
		public Keyword getMinInclusiveKeyword_3_0_0() { return cMinInclusiveKeyword_3_0_0; }
		
		//minInclusive=STRING
		public Assignment getMinInclusiveAssignment_3_0_1() { return cMinInclusiveAssignment_3_0_1; }
		
		//STRING
		public RuleCall getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0() { return cMinInclusiveSTRINGTerminalRuleCall_3_0_1_0; }
		
		//('maxInclusive' maxInclusive=STRING)?
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//'maxInclusive'
		public Keyword getMaxInclusiveKeyword_3_1_0() { return cMaxInclusiveKeyword_3_1_0; }
		
		//maxInclusive=STRING
		public Assignment getMaxInclusiveAssignment_3_1_1() { return cMaxInclusiveAssignment_3_1_1; }
		
		//STRING
		public RuleCall getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0() { return cMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0; }
		
		//('minExclusive' minExclusive=STRING)?
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//'minExclusive'
		public Keyword getMinExclusiveKeyword_3_2_0() { return cMinExclusiveKeyword_3_2_0; }
		
		//minExclusive=STRING
		public Assignment getMinExclusiveAssignment_3_2_1() { return cMinExclusiveAssignment_3_2_1; }
		
		//STRING
		public RuleCall getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0() { return cMinExclusiveSTRINGTerminalRuleCall_3_2_1_0; }
		
		//('maxExclusive' maxExclusive=STRING)?
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//'maxExclusive'
		public Keyword getMaxExclusiveKeyword_3_3_0() { return cMaxExclusiveKeyword_3_3_0; }
		
		//maxExclusive=STRING
		public Assignment getMaxExclusiveAssignment_3_3_1() { return cMaxExclusiveAssignment_3_3_1; }
		
		//STRING
		public RuleCall getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0() { return cMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0; }
		
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
		private final Keyword cExtendsKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cClosedWorldDefinitionsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cClosedWorldDefinitionsTerminologyBoxCrossReference_1_0 = (CrossReference)cClosedWorldDefinitionsAssignment_1.eContents().get(0);
		private final RuleCall cClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_1_0_1 = (RuleCall)cClosedWorldDefinitionsTerminologyBoxCrossReference_1_0.eContents().get(1);
		
		//DescriptionBoxExtendsClosedWorldDefinitions:
		//	'extends' closedWorldDefinitions=[TerminologyBox|ExternalReference];
		@Override public ParserRule getRule() { return rule; }
		
		//'extends' closedWorldDefinitions=[TerminologyBox|ExternalReference]
		public Group getGroup() { return cGroup; }
		
		//'extends'
		public Keyword getExtendsKeyword_0() { return cExtendsKeyword_0; }
		
		//closedWorldDefinitions=[TerminologyBox|ExternalReference]
		public Assignment getClosedWorldDefinitionsAssignment_1() { return cClosedWorldDefinitionsAssignment_1; }
		
		//[TerminologyBox|ExternalReference]
		public CrossReference getClosedWorldDefinitionsTerminologyBoxCrossReference_1_0() { return cClosedWorldDefinitionsTerminologyBoxCrossReference_1_0; }
		
		//ExternalReference
		public RuleCall getClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_1_0_1() { return cClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_1_0_1; }
	}
	public class DescriptionBoxRefinementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxRefinement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRefinesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRefinedDescriptionBoxAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefinedDescriptionBoxDescriptionBoxCrossReference_1_0 = (CrossReference)cRefinedDescriptionBoxAssignment_1.eContents().get(0);
		private final RuleCall cRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_1_0_1 = (RuleCall)cRefinedDescriptionBoxDescriptionBoxCrossReference_1_0.eContents().get(1);
		
		//DescriptionBoxRefinement:
		//	'refines' refinedDescriptionBox=[DescriptionBox|ExternalReference];
		@Override public ParserRule getRule() { return rule; }
		
		//'refines' refinedDescriptionBox=[DescriptionBox|ExternalReference]
		public Group getGroup() { return cGroup; }
		
		//'refines'
		public Keyword getRefinesKeyword_0() { return cRefinesKeyword_0; }
		
		//refinedDescriptionBox=[DescriptionBox|ExternalReference]
		public Assignment getRefinedDescriptionBoxAssignment_1() { return cRefinedDescriptionBoxAssignment_1; }
		
		//[DescriptionBox|ExternalReference]
		public CrossReference getRefinedDescriptionBoxDescriptionBoxCrossReference_1_0() { return cRefinedDescriptionBoxDescriptionBoxCrossReference_1_0; }
		
		//ExternalReference
		public RuleCall getRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_1_0_1() { return cRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_1_0_1; }
	}
	public class SingletonInstanceScalarDataPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceScalarDataPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSingletonInstanceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0 = (CrossReference)cSingletonInstanceAssignment_0.eContents().get(0);
		private final RuleCall cSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1 = (RuleCall)cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0.eContents().get(1);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cScalarDataPropertyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cScalarDataPropertyEntityScalarDataPropertyCrossReference_2_0 = (CrossReference)cScalarDataPropertyAssignment_2.eContents().get(0);
		private final RuleCall cScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_2_0_1 = (RuleCall)cScalarDataPropertyEntityScalarDataPropertyCrossReference_2_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cScalarPropertyValueAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cScalarPropertyValueValueParserRuleCall_4_0 = (RuleCall)cScalarPropertyValueAssignment_4.eContents().get(0);
		
		//SingletonInstanceScalarDataPropertyValue:
		//	singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		//	'.'
		//	scalarDataProperty=[EntityScalarDataProperty|Reference]
		//	'='
		//	scalarPropertyValue=Value;
		@Override public ParserRule getRule() { return rule; }
		
		//singletonInstance=[ConceptualEntitySingletonInstance|Reference] '.'
		//scalarDataProperty=[EntityScalarDataProperty|Reference] '=' scalarPropertyValue=Value
		public Group getGroup() { return cGroup; }
		
		//singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getSingletonInstanceAssignment_0() { return cSingletonInstanceAssignment_0; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0() { return cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0; }
		
		//Reference
		public RuleCall getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1() { return cSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
		
		//scalarDataProperty=[EntityScalarDataProperty|Reference]
		public Assignment getScalarDataPropertyAssignment_2() { return cScalarDataPropertyAssignment_2; }
		
		//[EntityScalarDataProperty|Reference]
		public CrossReference getScalarDataPropertyEntityScalarDataPropertyCrossReference_2_0() { return cScalarDataPropertyEntityScalarDataPropertyCrossReference_2_0; }
		
		//Reference
		public RuleCall getScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_2_0_1() { return cScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_2_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }
		
		//scalarPropertyValue=Value
		public Assignment getScalarPropertyValueAssignment_4() { return cScalarPropertyValueAssignment_4; }
		
		//Value
		public RuleCall getScalarPropertyValueValueParserRuleCall_4_0() { return cScalarPropertyValueValueParserRuleCall_4_0; }
	}
	public class SingletonInstanceStructuredDataPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceStructuredDataPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSingletonInstanceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0 = (CrossReference)cSingletonInstanceAssignment_0.eContents().get(0);
		private final RuleCall cSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1 = (RuleCall)cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0.eContents().get(1);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cStructuredDataPropertyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cStructuredDataPropertyDataRelationshipToStructureCrossReference_2_0 = (CrossReference)cStructuredDataPropertyAssignment_2.eContents().get(0);
		private final RuleCall cStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_2_0_1 = (RuleCall)cStructuredDataPropertyDataRelationshipToStructureCrossReference_2_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cStructuredPropertyTuplesAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0 = (RuleCall)cStructuredPropertyTuplesAssignment_5_0.eContents().get(0);
		private final Assignment cScalarDataPropertyValuesAssignment_5_1 = (Assignment)cAlternatives_5.eContents().get(1);
		private final RuleCall cScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0 = (RuleCall)cScalarDataPropertyValuesAssignment_5_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//SingletonInstanceStructuredDataPropertyValue:
		//	singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		//	'.'
		//	structuredDataProperty=[DataRelationshipToStructure|Reference]
		//	'=' '{' (structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//singletonInstance=[ConceptualEntitySingletonInstance|Reference] '.'
		//structuredDataProperty=[DataRelationshipToStructure|Reference] '=' '{'
		//(structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//singletonInstance=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getSingletonInstanceAssignment_0() { return cSingletonInstanceAssignment_0; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0() { return cSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0; }
		
		//Reference
		public RuleCall getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1() { return cSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
		
		//structuredDataProperty=[DataRelationshipToStructure|Reference]
		public Assignment getStructuredDataPropertyAssignment_2() { return cStructuredDataPropertyAssignment_2; }
		
		//[DataRelationshipToStructure|Reference]
		public CrossReference getStructuredDataPropertyDataRelationshipToStructureCrossReference_2_0() { return cStructuredDataPropertyDataRelationshipToStructureCrossReference_2_0; }
		
		//Reference
		public RuleCall getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_2_0_1() { return cStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_2_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//(structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
		public Alternatives getAlternatives_5() { return cAlternatives_5; }
		
		//structuredPropertyTuples+=StructuredDataPropertyTuple
		public Assignment getStructuredPropertyTuplesAssignment_5_0() { return cStructuredPropertyTuplesAssignment_5_0; }
		
		//StructuredDataPropertyTuple
		public RuleCall getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0() { return cStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0; }
		
		//scalarDataPropertyValues+=ScalarDataPropertyValue
		public Assignment getScalarDataPropertyValuesAssignment_5_1() { return cScalarDataPropertyValuesAssignment_5_1; }
		
		//ScalarDataPropertyValue
		public RuleCall getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0() { return cScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class StructuredDataPropertyTupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStructuredDataPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cStructuredDataPropertyDataRelationshipToStructureCrossReference_0_0 = (CrossReference)cStructuredDataPropertyAssignment_0.eContents().get(0);
		private final RuleCall cStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_0_0_1 = (RuleCall)cStructuredDataPropertyDataRelationshipToStructureCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cStructuredPropertyTuplesAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0 = (RuleCall)cStructuredPropertyTuplesAssignment_3_0.eContents().get(0);
		private final Assignment cScalarDataPropertyValuesAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final RuleCall cScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0 = (RuleCall)cScalarDataPropertyValuesAssignment_3_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//StructuredDataPropertyTuple:
		//	structuredDataProperty=[DataRelationshipToStructure|Reference]
		//	'=' '{' (structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//structuredDataProperty=[DataRelationshipToStructure|Reference] '=' '{'
		//(structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)* '}'
		public Group getGroup() { return cGroup; }
		
		//structuredDataProperty=[DataRelationshipToStructure|Reference]
		public Assignment getStructuredDataPropertyAssignment_0() { return cStructuredDataPropertyAssignment_0; }
		
		//[DataRelationshipToStructure|Reference]
		public CrossReference getStructuredDataPropertyDataRelationshipToStructureCrossReference_0_0() { return cStructuredDataPropertyDataRelationshipToStructureCrossReference_0_0; }
		
		//Reference
		public RuleCall getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_0_0_1() { return cStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_0_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(structuredPropertyTuples+=StructuredDataPropertyTuple | scalarDataPropertyValues+=ScalarDataPropertyValue)*
		public Alternatives getAlternatives_3() { return cAlternatives_3; }
		
		//structuredPropertyTuples+=StructuredDataPropertyTuple
		public Assignment getStructuredPropertyTuplesAssignment_3_0() { return cStructuredPropertyTuplesAssignment_3_0; }
		
		//StructuredDataPropertyTuple
		public RuleCall getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0() { return cStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0; }
		
		//scalarDataPropertyValues+=ScalarDataPropertyValue
		public Assignment getScalarDataPropertyValuesAssignment_3_1() { return cScalarDataPropertyValuesAssignment_3_1; }
		
		//ScalarDataPropertyValue
		public RuleCall getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0() { return cScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class ScalarDataPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cScalarDataPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cScalarDataPropertyDataRelationshipToScalarCrossReference_0_0 = (CrossReference)cScalarDataPropertyAssignment_0.eContents().get(0);
		private final RuleCall cScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_0_0_1 = (RuleCall)cScalarDataPropertyDataRelationshipToScalarCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cScalarPropertyValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cScalarPropertyValueValueParserRuleCall_2_0 = (RuleCall)cScalarPropertyValueAssignment_2.eContents().get(0);
		
		//ScalarDataPropertyValue:
		//	scalarDataProperty=[DataRelationshipToScalar|Reference]
		//	'='
		//	scalarPropertyValue=Value;
		@Override public ParserRule getRule() { return rule; }
		
		//scalarDataProperty=[DataRelationshipToScalar|Reference] '=' scalarPropertyValue=Value
		public Group getGroup() { return cGroup; }
		
		//scalarDataProperty=[DataRelationshipToScalar|Reference]
		public Assignment getScalarDataPropertyAssignment_0() { return cScalarDataPropertyAssignment_0; }
		
		//[DataRelationshipToScalar|Reference]
		public CrossReference getScalarDataPropertyDataRelationshipToScalarCrossReference_0_0() { return cScalarDataPropertyDataRelationshipToScalarCrossReference_0_0; }
		
		//Reference
		public RuleCall getScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_0_0_1() { return cScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_0_0_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }
		
		//scalarPropertyValue=Value
		public Assignment getScalarPropertyValueAssignment_2() { return cScalarPropertyValueAssignment_2; }
		
		//Value
		public RuleCall getScalarPropertyValueValueParserRuleCall_2_0() { return cScalarPropertyValueValueParserRuleCall_2_0; }
	}
	public class ConceptInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ConceptInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cConceptInstanceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cIsAKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cSingletonConceptClassifierAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cSingletonConceptClassifierConceptCrossReference_4_0 = (CrossReference)cSingletonConceptClassifierAssignment_4.eContents().get(0);
		private final RuleCall cSingletonConceptClassifierConceptReferenceParserRuleCall_4_0_1 = (RuleCall)cSingletonConceptClassifierConceptCrossReference_4_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ConceptInstance:
		//	'conceptInstance' '(' name=ID 'is-a' singletonConceptClassifier=[Concept|Reference] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//'conceptInstance' '(' name=ID 'is-a' singletonConceptClassifier=[Concept|Reference] ')'
		public Group getGroup() { return cGroup; }
		
		//'conceptInstance'
		public Keyword getConceptInstanceKeyword_0() { return cConceptInstanceKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'is-a'
		public Keyword getIsAKeyword_3() { return cIsAKeyword_3; }
		
		//singletonConceptClassifier=[Concept|Reference]
		public Assignment getSingletonConceptClassifierAssignment_4() { return cSingletonConceptClassifierAssignment_4; }
		
		//[Concept|Reference]
		public CrossReference getSingletonConceptClassifierConceptCrossReference_4_0() { return cSingletonConceptClassifierConceptCrossReference_4_0; }
		
		//Reference
		public RuleCall getSingletonConceptClassifierConceptReferenceParserRuleCall_4_0_1() { return cSingletonConceptClassifierConceptReferenceParserRuleCall_4_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class ReifiedRelationshipInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReifiedRelationshipInstanceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cIsAKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cSingletonReifiedRelationshipClassifierAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0 = (CrossReference)cSingletonReifiedRelationshipClassifierAssignment_4.eContents().get(0);
		private final RuleCall cSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_4_0_1 = (RuleCall)cSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ReifiedRelationshipInstance:
		//	'reifiedRelationshipInstance' '(' name=ID 'is-a'
		//	singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference] ')';
		@Override public ParserRule getRule() { return rule; }
		
		//'reifiedRelationshipInstance' '(' name=ID 'is-a' singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference]
		//')'
		public Group getGroup() { return cGroup; }
		
		//'reifiedRelationshipInstance'
		public Keyword getReifiedRelationshipInstanceKeyword_0() { return cReifiedRelationshipInstanceKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'is-a'
		public Keyword getIsAKeyword_3() { return cIsAKeyword_3; }
		
		//singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference]
		public Assignment getSingletonReifiedRelationshipClassifierAssignment_4() { return cSingletonReifiedRelationshipClassifierAssignment_4; }
		
		//[ReifiedRelationship|Reference]
		public CrossReference getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0() { return cSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0; }
		
		//Reference
		public RuleCall getSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_4_0_1() { return cSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_4_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class ReifiedRelationshipInstanceDomainElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceDomain");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDomainKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReifiedRelationshipInstanceAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0 = (CrossReference)cReifiedRelationshipInstanceAssignment_2.eContents().get(0);
		private final RuleCall cReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1 = (RuleCall)cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDomainAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDomainConceptualEntitySingletonInstanceCrossReference_5_0 = (CrossReference)cDomainAssignment_5.eContents().get(0);
		private final RuleCall cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1 = (RuleCall)cDomainConceptualEntitySingletonInstanceCrossReference_5_0.eContents().get(1);
		
		//ReifiedRelationshipInstanceDomain:
		//	'domain'
		//	'(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] ')'
		//	'=' domain=[ConceptualEntitySingletonInstance|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//'domain' '(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] ')' '='
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Group getGroup() { return cGroup; }
		
		//'domain'
		public Keyword getDomainKeyword_0() { return cDomainKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference]
		public Assignment getReifiedRelationshipInstanceAssignment_2() { return cReifiedRelationshipInstanceAssignment_2; }
		
		//[ReifiedRelationshipInstance|Reference]
		public CrossReference getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0() { return cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0; }
		
		//Reference
		public RuleCall getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1() { return cReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
		
		//'='
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }
		
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getDomainAssignment_5() { return cDomainAssignment_5; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getDomainConceptualEntitySingletonInstanceCrossReference_5_0() { return cDomainConceptualEntitySingletonInstanceCrossReference_5_0; }
		
		//Reference
		public RuleCall getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1() { return cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1; }
	}
	public class ReifiedRelationshipInstanceRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceRange");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRangeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReifiedRelationshipInstanceAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0 = (CrossReference)cReifiedRelationshipInstanceAssignment_2.eContents().get(0);
		private final RuleCall cReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1 = (RuleCall)cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cRangeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRangeConceptualEntitySingletonInstanceCrossReference_5_0 = (CrossReference)cRangeAssignment_5.eContents().get(0);
		private final RuleCall cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1 = (RuleCall)cRangeConceptualEntitySingletonInstanceCrossReference_5_0.eContents().get(1);
		
		//ReifiedRelationshipInstanceRange:
		//	'range'
		//	'(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] ')'
		//	'=' range=[ConceptualEntitySingletonInstance|Reference];
		@Override public ParserRule getRule() { return rule; }
		
		//'range' '(' reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference] ')' '='
		//range=[ConceptualEntitySingletonInstance|Reference]
		public Group getGroup() { return cGroup; }
		
		//'range'
		public Keyword getRangeKeyword_0() { return cRangeKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//reifiedRelationshipInstance=[ReifiedRelationshipInstance|Reference]
		public Assignment getReifiedRelationshipInstanceAssignment_2() { return cReifiedRelationshipInstanceAssignment_2; }
		
		//[ReifiedRelationshipInstance|Reference]
		public CrossReference getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0() { return cReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0; }
		
		//Reference
		public RuleCall getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1() { return cReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
		
		//'='
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }
		
		//range=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getRangeAssignment_5() { return cRangeAssignment_5; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getRangeConceptualEntitySingletonInstanceCrossReference_5_0() { return cRangeConceptualEntitySingletonInstanceCrossReference_5_0; }
		
		//Reference
		public RuleCall getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1() { return cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1; }
	}
	public class UnreifiedRelationshipInstanceTupleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UnreifiedRelationshipInstanceTuple");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTupleKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cUnreifiedRelationshipKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cUnreifiedRelationshipAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0 = (CrossReference)cUnreifiedRelationshipAssignment_3.eContents().get(0);
		private final RuleCall cUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_3_0_1 = (RuleCall)cUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0.eContents().get(1);
		private final Keyword cDomainKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDomainAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cDomainConceptualEntitySingletonInstanceCrossReference_5_0 = (CrossReference)cDomainAssignment_5.eContents().get(0);
		private final RuleCall cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1 = (RuleCall)cDomainConceptualEntitySingletonInstanceCrossReference_5_0.eContents().get(1);
		private final Keyword cRangeKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cRangeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cRangeConceptualEntitySingletonInstanceCrossReference_7_0 = (CrossReference)cRangeAssignment_7.eContents().get(0);
		private final RuleCall cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_7_0_1 = (RuleCall)cRangeConceptualEntitySingletonInstanceCrossReference_7_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//UnreifiedRelationshipInstanceTuple:
		//	'tuple'
		//	'{'
		//	'unreifiedRelationship' unreifiedRelationship=[UnreifiedRelationship|Reference]
		//	'domain' domain=[ConceptualEntitySingletonInstance|Reference]
		//	'range' range=[ConceptualEntitySingletonInstance|Reference]
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'tuple' '{' 'unreifiedRelationship' unreifiedRelationship=[UnreifiedRelationship|Reference] 'domain'
		//domain=[ConceptualEntitySingletonInstance|Reference] 'range' range=[ConceptualEntitySingletonInstance|Reference] '}'
		public Group getGroup() { return cGroup; }
		
		//'tuple'
		public Keyword getTupleKeyword_0() { return cTupleKeyword_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }
		
		//'unreifiedRelationship'
		public Keyword getUnreifiedRelationshipKeyword_2() { return cUnreifiedRelationshipKeyword_2; }
		
		//unreifiedRelationship=[UnreifiedRelationship|Reference]
		public Assignment getUnreifiedRelationshipAssignment_3() { return cUnreifiedRelationshipAssignment_3; }
		
		//[UnreifiedRelationship|Reference]
		public CrossReference getUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0() { return cUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0; }
		
		//Reference
		public RuleCall getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_3_0_1() { return cUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_3_0_1; }
		
		//'domain'
		public Keyword getDomainKeyword_4() { return cDomainKeyword_4; }
		
		//domain=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getDomainAssignment_5() { return cDomainAssignment_5; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getDomainConceptualEntitySingletonInstanceCrossReference_5_0() { return cDomainConceptualEntitySingletonInstanceCrossReference_5_0; }
		
		//Reference
		public RuleCall getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1() { return cDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1; }
		
		//'range'
		public Keyword getRangeKeyword_6() { return cRangeKeyword_6; }
		
		//range=[ConceptualEntitySingletonInstance|Reference]
		public Assignment getRangeAssignment_7() { return cRangeAssignment_7; }
		
		//[ConceptualEntitySingletonInstance|Reference]
		public CrossReference getRangeConceptualEntitySingletonInstanceCrossReference_7_0() { return cRangeConceptualEntitySingletonInstanceCrossReference_7_0; }
		
		//Reference
		public RuleCall getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_7_0_1() { return cRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_7_0_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_8() { return cRightCurlyBracketKeyword_8; }
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
	public class ValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.Value");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cDECIMALTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cUUIDTerminalRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cHEXTerminalRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cFLOATTerminalRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//Value:
		//	DECIMAL | INT | STRING | UUID | HEX | FLOAT;
		@Override public ParserRule getRule() { return rule; }
		
		//DECIMAL | INT | STRING | UUID | HEX | FLOAT
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//DECIMAL
		public RuleCall getDECIMALTerminalRuleCall_0() { return cDECIMALTerminalRuleCall_0; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_2() { return cSTRINGTerminalRuleCall_2; }
		
		//UUID
		public RuleCall getUUIDTerminalRuleCall_3() { return cUUIDTerminalRuleCall_3; }
		
		//HEX
		public RuleCall getHEXTerminalRuleCall_4() { return cHEXTerminalRuleCall_4; }
		
		//FLOAT
		public RuleCall getFLOATTerminalRuleCall_5() { return cFLOATTerminalRuleCall_5; }
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
	private final AnnotationElements pAnnotation;
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
	private final ValueElements pValue;
	private final TerminalRule tSTRING;
	private final TerminalRule tIRI;
	private final TerminalRule tABBREV_IRI;
	private final TerminalRule tID;
	private final TerminalRule tUUID;
	private final TerminalRule tHEX_12DIGITS;
	private final TerminalRule tHEX_8DIGITS;
	private final TerminalRule tHEX_4DIGITS;
	private final TerminalRule tHEX_DIGIT;
	private final TerminalRule tHEX;
	private final TerminalRule tINT;
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
		this.pAnnotation = new AnnotationElements();
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
		this.pValue = new ValueElements();
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.STRING");
		this.tIRI = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.IRI");
		this.tABBREV_IRI = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ABBREV_IRI");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.ID");
		this.tUUID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.UUID");
		this.tHEX_12DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_12DIGITS");
		this.tHEX_8DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_8DIGITS");
		this.tHEX_4DIGITS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_4DIGITS");
		this.tHEX_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX_DIGIT");
		this.tHEX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.HEX");
		this.tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "gov.nasa.jpl.imce.oml.dsl.OML.INT");
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
	
	///*
	// * Note that the concrete syntax for the Annotation.subject is defined implicitly
	// * in the sense that the subject of an Annotation is always the preceding
	// * TerminologyThing or the subject of the preceding Annotation.
	// * 
	// * For example, the following shows the concrete syntax for 2 Concepts, Foo and Bar
	// * and of 3 Annotations; the first two Annotations have Foo as their subject because 
	// * Foo is the first preceding TerminologyThing; the third Annotation has Bar as its subject
	// * because it appears after the TerminologyThing Bar.
	// * 
	// * concept Foo
	// * @rdfs:label = "foo"
	// * @dc:description = "A Foo is ..."
	// * 
	// * concept Bar
	// * @rdfs:label = "bar
	// * 
	// * @see jpl.imce.oml.specification.linking.OMLLinkingService
	// */ Annotation:
	//	'@' property=[AnnotationProperty|ABBREV_IRI]
	//	'=' value=STRING;
	public AnnotationElements getAnnotationAccess() {
		return pAnnotation;
	}
	
	public ParserRule getAnnotationRule() {
		return getAnnotationAccess().getRule();
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
	//	annotations+=Annotation*
	//	kind=TerminologyKind 'terminology' iri=IRI
	//	'{' (annotations+=Annotation | boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement)*
	//	'}';
	public TerminologyGraphElements getTerminologyGraphAccess() {
		return pTerminologyGraph;
	}
	
	public ParserRule getTerminologyGraphRule() {
		return getTerminologyGraphAccess().getRule();
	}
	
	//Bundle:
	//	annotations+=Annotation*
	//	kind=TerminologyKind 'bundle' iri=IRI
	//	'{' (annotations+=Annotation | boxAxioms+=TerminologyBoxAxiom | boxStatements+=TerminologyBoxStatement |
	//	bundleStatements+=TerminologyBundleStatement | bundleAxioms+=TerminologyBundleAxiom)*
	//	'}';
	public BundleElements getBundleAccess() {
		return pBundle;
	}
	
	public ParserRule getBundleRule() {
		return getBundleAccess().getRule();
	}
	
	//DescriptionBox:
	//	annotations+=Annotation*
	//	kind=DescriptionKind 'descriptionBox' iri=IRI
	//	'{' (annotations+=Annotation | closedWorldDefinitions+=DescriptionBoxExtendsClosedWorldDefinitions |
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
	//	'bundles' bundledTerminology=[TerminologyBox|ExternalReference];
	public BundledTerminologyAxiomElements getBundledTerminologyAxiomAccess() {
		return pBundledTerminologyAxiom;
	}
	
	public ParserRule getBundledTerminologyAxiomRule() {
		return getBundledTerminologyAxiomAccess().getRule();
	}
	
	//// 3 TerminologyBoxAxioms
	//ConceptDesignationTerminologyAxiom:
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
	//	'extends' extendedTerminology=[TerminologyBox|ExternalReference];
	public TerminologyExtensionAxiomElements getTerminologyExtensionAxiomAccess() {
		return pTerminologyExtensionAxiom;
	}
	
	public ParserRule getTerminologyExtensionAxiomRule() {
		return getTerminologyExtensionAxiomAccess().getRule();
	}
	
	//TerminologyNestingAxiom:
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
	//	'aspect' name=ID;
	public AspectElements getAspectAccess() {
		return pAspect;
	}
	
	public ParserRule getAspectRule() {
		return getAspectAccess().getRule();
	}
	
	//Concept:
	//	'concept' name=ID;
	public ConceptElements getConceptAccess() {
		return pConcept;
	}
	
	public ParserRule getConceptRule() {
		return getConceptAccess().getRule();
	}
	
	//// 2 EntityRelationship Terms
	//ReifiedRelationship:
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
	//	'scalar' name=ID;
	public ScalarElements getScalarAccess() {
		return pScalar;
	}
	
	public ParserRule getScalarRule() {
		return getScalarAccess().getRule();
	}
	
	//Structure:
	//	'structure' name=ID;
	public StructureElements getStructureAccess() {
		return pStructure;
	}
	
	public ParserRule getStructureRule() {
		return getStructureAccess().getRule();
	}
	
	//// 4 DataRelationship Terms
	//EntityStructuredDataProperty:
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
	//	'disjointLeaf' '(' disjointLeaf=[Concept|Reference] ')';
	public SpecificDisjointConceptAxiomElements getSpecificDisjointConceptAxiomAccess() {
		return pSpecificDisjointConceptAxiom;
	}
	
	public ParserRule getSpecificDisjointConceptAxiomRule() {
		return getSpecificDisjointConceptAxiomAccess().getRule();
	}
	
	//// 2 EntityRestrictionAxioms
	//EntityExistentialRestrictionAxiom:
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
	//	subEntity=[Entity|Reference] 'extendsAspect' superAspect=[Aspect|Reference];
	public AspectSpecializationAxiomElements getAspectSpecializationAxiomAccess() {
		return pAspectSpecializationAxiom;
	}
	
	public ParserRule getAspectSpecializationAxiomRule() {
		return getAspectSpecializationAxiomAccess().getRule();
	}
	
	//ConceptSpecializationAxiom:
	//	subConcept=[Concept|Reference] 'extendsConcept' superConcept=[Concept|Reference];
	public ConceptSpecializationAxiomElements getConceptSpecializationAxiomAccess() {
		return pConceptSpecializationAxiom;
	}
	
	public ParserRule getConceptSpecializationAxiomRule() {
		return getConceptSpecializationAxiomAccess().getRule();
	}
	
	//ReifiedRelationshipSpecializationAxiom:
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
	//	'every'
	//	restrictedEntity=[Entity|Reference]
	//	'.' scalarProperty=[EntityScalarDataProperty|Reference]
	//	'=' literalValue=Value;
	public EntityScalarDataPropertyParticularRestrictionAxiomElements getEntityScalarDataPropertyParticularRestrictionAxiomAccess() {
		return pEntityScalarDataPropertyParticularRestrictionAxiom;
	}
	
	public ParserRule getEntityScalarDataPropertyParticularRestrictionAxiomRule() {
		return getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRule();
	}
	
	//EntityScalarDataPropertyUniversalRestrictionAxiom:
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
	//	'every'
	//	restrictedEntity=[Entity|Reference]
	//	'.'
	//	structuredDataProperty=[EntityStructuredDataProperty|Reference]
	//	'='
	//	'{' (structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple |
	//	scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)*
	//	'}';
	public EntityStructuredDataPropertyParticularRestrictionAxiomElements getEntityStructuredDataPropertyParticularRestrictionAxiomAccess() {
		return pEntityStructuredDataPropertyParticularRestrictionAxiom;
	}
	
	public ParserRule getEntityStructuredDataPropertyParticularRestrictionAxiomRule() {
		return getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRule();
	}
	
	//RestrictionStructuredDataPropertyTuple:
	//	structuredDataProperty=[StructuredDataProperty|Reference]
	//	'=' '{' (structuredPropertyTuples+=RestrictionStructuredDataPropertyTuple |
	//	scalarDataPropertyValues+=RestrictionScalarDataPropertyValue)*
	//	'}';
	public RestrictionStructuredDataPropertyTupleElements getRestrictionStructuredDataPropertyTupleAccess() {
		return pRestrictionStructuredDataPropertyTuple;
	}
	
	public ParserRule getRestrictionStructuredDataPropertyTupleRule() {
		return getRestrictionStructuredDataPropertyTupleAccess().getRule();
	}
	
	//RestrictionScalarDataPropertyValue:
	//	scalarDataProperty=[ScalarDataProperty|Reference]
	//	'='
	//	scalarPropertyValue=Value;
	public RestrictionScalarDataPropertyValueElements getRestrictionScalarDataPropertyValueAccess() {
		return pRestrictionScalarDataPropertyValue;
	}
	
	public ParserRule getRestrictionScalarDataPropertyValueRule() {
		return getRestrictionScalarDataPropertyValueAccess().getRule();
	}
	
	//// 8 RestrictedDataRanges + 1 ScalarOneOfLiteralAxiom
	//BinaryScalarRestriction:
	//	'binaryScalarRestriction' name=ID
	//	'{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public BinaryScalarRestrictionElements getBinaryScalarRestrictionAccess() {
		return pBinaryScalarRestriction;
	}
	
	public ParserRule getBinaryScalarRestrictionRule() {
		return getBinaryScalarRestrictionAccess().getRule();
	}
	
	//IRIScalarRestriction:
	//	'iriScalarRestriction' name=ID
	//	'{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern'
	//	pattern=STRING)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public IRIScalarRestrictionElements getIRIScalarRestrictionAccess() {
		return pIRIScalarRestriction;
	}
	
	public ParserRule getIRIScalarRestrictionRule() {
		return getIRIScalarRestrictionAccess().getRule();
	}
	
	//NumericScalarRestriction:
	//	'numericScalarRestriction' name=ID
	//	'{' (('minInclusive' minInclusive=STRING)? & ('maxInclusive' maxInclusive=STRING)? & ('minExclusive'
	//	minExclusive=STRING)? & ('maxExclusive' maxExclusive=STRING)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public NumericScalarRestrictionElements getNumericScalarRestrictionAccess() {
		return pNumericScalarRestriction;
	}
	
	public ParserRule getNumericScalarRestrictionRule() {
		return getNumericScalarRestrictionAccess().getRule();
	}
	
	//PlainLiteralScalarRestriction:
	//	'plainLiteralScalarRestriction' name=ID
	//	'{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern'
	//	pattern=STRING)? & ('langRange' langRange=STRING)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public PlainLiteralScalarRestrictionElements getPlainLiteralScalarRestrictionAccess() {
		return pPlainLiteralScalarRestriction;
	}
	
	public ParserRule getPlainLiteralScalarRestrictionRule() {
		return getPlainLiteralScalarRestrictionAccess().getRule();
	}
	
	//ScalarOneOfRestriction:
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
	//	'oneOf'
	//	axiom=[ScalarOneOfRestriction|Reference]
	//	'=' value=STRING;
	public ScalarOneOfLiteralAxiomElements getScalarOneOfLiteralAxiomAccess() {
		return pScalarOneOfLiteralAxiom;
	}
	
	public ParserRule getScalarOneOfLiteralAxiomRule() {
		return getScalarOneOfLiteralAxiomAccess().getRule();
	}
	
	//StringScalarRestriction:
	//	'stringScalarRestriction' name=ID
	//	'{' (('length' length=INT)? & ('minLength' minLength=INT)? & ('maxLength' maxLength=INT)? & ('pattern'
	//	pattern=STRING)?)
	//	'restrictedRange' restrictedRange=[DataRange|Reference]
	//	'}';
	public StringScalarRestrictionElements getStringScalarRestrictionAccess() {
		return pStringScalarRestriction;
	}
	
	public ParserRule getStringScalarRestrictionRule() {
		return getStringScalarRestrictionAccess().getRule();
	}
	
	//SynonymScalarRestriction:
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
	//	'timeScalarRestriction' name=ID
	//	'{' (('minInclusive' minInclusive=STRING)? & ('maxInclusive' maxInclusive=STRING)? & ('minExclusive'
	//	minExclusive=STRING)? & ('maxExclusive' maxExclusive=STRING)?)
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
	//	'extends' closedWorldDefinitions=[TerminologyBox|ExternalReference];
	public DescriptionBoxExtendsClosedWorldDefinitionsElements getDescriptionBoxExtendsClosedWorldDefinitionsAccess() {
		return pDescriptionBoxExtendsClosedWorldDefinitions;
	}
	
	public ParserRule getDescriptionBoxExtendsClosedWorldDefinitionsRule() {
		return getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getRule();
	}
	
	//DescriptionBoxRefinement:
	//	'refines' refinedDescriptionBox=[DescriptionBox|ExternalReference];
	public DescriptionBoxRefinementElements getDescriptionBoxRefinementAccess() {
		return pDescriptionBoxRefinement;
	}
	
	public ParserRule getDescriptionBoxRefinementRule() {
		return getDescriptionBoxRefinementAccess().getRule();
	}
	
	//SingletonInstanceScalarDataPropertyValue:
	//	singletonInstance=[ConceptualEntitySingletonInstance|Reference]
	//	'.'
	//	scalarDataProperty=[EntityScalarDataProperty|Reference]
	//	'='
	//	scalarPropertyValue=Value;
	public SingletonInstanceScalarDataPropertyValueElements getSingletonInstanceScalarDataPropertyValueAccess() {
		return pSingletonInstanceScalarDataPropertyValue;
	}
	
	public ParserRule getSingletonInstanceScalarDataPropertyValueRule() {
		return getSingletonInstanceScalarDataPropertyValueAccess().getRule();
	}
	
	//SingletonInstanceStructuredDataPropertyValue:
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
	//	scalarDataProperty=[DataRelationshipToScalar|Reference]
	//	'='
	//	scalarPropertyValue=Value;
	public ScalarDataPropertyValueElements getScalarDataPropertyValueAccess() {
		return pScalarDataPropertyValue;
	}
	
	public ParserRule getScalarDataPropertyValueRule() {
		return getScalarDataPropertyValueAccess().getRule();
	}
	
	//ConceptInstance:
	//	'conceptInstance' '(' name=ID 'is-a' singletonConceptClassifier=[Concept|Reference] ')';
	public ConceptInstanceElements getConceptInstanceAccess() {
		return pConceptInstance;
	}
	
	public ParserRule getConceptInstanceRule() {
		return getConceptInstanceAccess().getRule();
	}
	
	//ReifiedRelationshipInstance:
	//	'reifiedRelationshipInstance' '(' name=ID 'is-a'
	//	singletonReifiedRelationshipClassifier=[ReifiedRelationship|Reference] ')';
	public ReifiedRelationshipInstanceElements getReifiedRelationshipInstanceAccess() {
		return pReifiedRelationshipInstance;
	}
	
	public ParserRule getReifiedRelationshipInstanceRule() {
		return getReifiedRelationshipInstanceAccess().getRule();
	}
	
	//ReifiedRelationshipInstanceDomain:
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
	
	//Value:
	//	DECIMAL | INT | STRING | UUID | HEX | FLOAT;
	public ValueElements getValueAccess() {
		return pValue;
	}
	
	public ParserRule getValueRule() {
		return getValueAccess().getRule();
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
	
	//terminal ABBREV_IRI:
	//	('a'..'z' | 'A'..'Z' | '_' | '0'..'9') ('a'..'z' | 'A'..'Z' | '_' | '-' | '.' | '0'..'9')* ':' ('a'..'z' | 'A'..'Z' |
	//	'_' | '0'..'9') ('a'..'z' | 'A'..'Z' | '_' | '-' | '.' | '0'..'9')*;
	public TerminalRule getABBREV_IRIRule() {
		return tABBREV_IRI;
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '-' | '.' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return tID;
	}
	
	//terminal UUID:
	//	HEX_8DIGITS '-' HEX_4DIGITS '-' HEX_4DIGITS '-' HEX_4DIGITS '-' HEX_12DIGITS;
	public TerminalRule getUUIDRule() {
		return tUUID;
	}
	
	//terminal HEX_12DIGITS:
	//	HEX_8DIGITS HEX_4DIGITS;
	public TerminalRule getHEX_12DIGITSRule() {
		return tHEX_12DIGITS;
	}
	
	//terminal HEX_8DIGITS:
	//	HEX_4DIGITS HEX_4DIGITS;
	public TerminalRule getHEX_8DIGITSRule() {
		return tHEX_8DIGITS;
	}
	
	//terminal HEX_4DIGITS:
	//	HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT;
	public TerminalRule getHEX_4DIGITSRule() {
		return tHEX_4DIGITS;
	}
	
	//terminal HEX_DIGIT:
	//	'0'..'9' | 'a'..'f' | 'A'..'F';
	public TerminalRule getHEX_DIGITRule() {
		return tHEX_DIGIT;
	}
	
	//terminal HEX:
	//	('0x' | '0X') ('0'..'9' | 'a'..'f' | 'A'..'F' | '_')+ ('#' (('b' | 'B') ('i' | 'I') | ('l' | 'L')))?;
	public TerminalRule getHEXRule() {
		return tHEX;
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return tINT;
	}
	
	//terminal DECIMAL:
	//	INT (('e' | 'E') ('+' | '-')? INT)? (('b' | 'B') ('i' | 'I' | 'd' | 'D') | ('l' | 'L' | 'd' | 'D' | 'f' | 'F'))?;
	public TerminalRule getDECIMALRule() {
		return tDECIMAL;
	}
	
	//terminal FLOAT:
	//	'-'? ('0'..'9'+ '.' '0'..'9'+) (('e' | 'E') ('+' | '-')? '0'..'9'+)?;
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
