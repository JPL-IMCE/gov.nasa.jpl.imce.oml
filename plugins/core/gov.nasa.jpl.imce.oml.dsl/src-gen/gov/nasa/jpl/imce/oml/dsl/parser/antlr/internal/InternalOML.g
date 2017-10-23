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
grammar InternalOML;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package gov.nasa.jpl.imce.oml.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package gov.nasa.jpl.imce.oml.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import gov.nasa.jpl.imce.oml.dsl.services.OMLGrammarAccess;

}

@parser::members {

 	private OMLGrammarAccess grammarAccess;

    public InternalOMLParser(TokenStream input, OMLGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Extent";
   	}

   	@Override
   	protected OMLGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleExtent
entryRuleExtent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExtentRule()); }
	iv_ruleExtent=ruleExtent
	{ $current=$iv_ruleExtent.current; }
	EOF;

// Rule Extent
ruleExtent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getExtentAccess().getExtentAction_0(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getExtentAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_1_0_0());
					}
					lv_annotationProperties_1_0=ruleAnnotationProperty
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExtentRule());
						}
						add(
							$current,
							"annotationProperties",
							lv_annotationProperties_1_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationProperty");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getExtentAccess().getModulesModuleParserRuleCall_1_1_0());
					}
					lv_modules_2_0=ruleModule
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExtentRule());
						}
						add(
							$current,
							"modules",
							lv_modules_2_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.Module");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleAnnotationProperty
entryRuleAnnotationProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationPropertyRule()); }
	iv_ruleAnnotationProperty=ruleAnnotationProperty
	{ $current=$iv_ruleAnnotationProperty.current; }
	EOF;

// Rule AnnotationProperty
ruleAnnotationProperty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='annotationProperty'
		{
			newLeafNode(otherlv_0, grammarAccess.getAnnotationPropertyAccess().getAnnotationPropertyKeyword_0());
		}
		(
			(
				lv_abbrevIRI_1_0=RULE_ABBREV_IRI
				{
					newLeafNode(lv_abbrevIRI_1_0, grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIABBREV_IRITerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"abbrevIRI",
						lv_abbrevIRI_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ABBREV_IRI");
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getAnnotationPropertyAccess().getEqualsSignKeyword_2());
		}
		(
			(
				lv_iri_3_0=RULE_IRI
				{
					newLeafNode(lv_iri_3_0, grammarAccess.getAnnotationPropertyAccess().getIriIRITerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"iri",
						lv_iri_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
				}
			)
		)
	)
;

// Entry rule entryRuleAnnotationPropertyValue
entryRuleAnnotationPropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationPropertyValueRule()); }
	iv_ruleAnnotationPropertyValue=ruleAnnotationPropertyValue
	{ $current=$iv_ruleAnnotationPropertyValue.current; }
	EOF;

// Rule AnnotationPropertyValue
ruleAnnotationPropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='@'
		{
			newLeafNode(otherlv_0, grammarAccess.getAnnotationPropertyValueAccess().getCommercialAtKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationPropertyValueRule());
					}
				}
				otherlv_1=RULE_ABBREV_IRI
				{
					newLeafNode(otherlv_1, grammarAccess.getAnnotationPropertyValueAccess().getPropertyAnnotationPropertyCrossReference_1_0());
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getAnnotationPropertyValueAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAnnotationPropertyValueAccess().getValueLiteralStringParserRuleCall_3_0());
				}
				lv_value_3_0=ruleLiteralString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAnnotationPropertyValueRule());
					}
					set(
						$current,
						"value",
						lv_value_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleModule
entryRuleModule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModuleRule()); }
	iv_ruleModule=ruleModule
	{ $current=$iv_ruleModule.current; }
	EOF;

// Rule Module
ruleModule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getModuleAccess().getTerminologyBoxParserRuleCall_0());
		}
		this_TerminologyBox_0=ruleTerminologyBox
		{
			$current = $this_TerminologyBox_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getModuleAccess().getDescriptionBoxParserRuleCall_1());
		}
		this_DescriptionBox_1=ruleDescriptionBox
		{
			$current = $this_DescriptionBox_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTerminologyBox
entryRuleTerminologyBox returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminologyBoxRule()); }
	iv_ruleTerminologyBox=ruleTerminologyBox
	{ $current=$iv_ruleTerminologyBox.current; }
	EOF;

// Rule TerminologyBox
ruleTerminologyBox returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTerminologyBoxAccess().getBundleParserRuleCall_0());
		}
		this_Bundle_0=ruleBundle
		{
			$current = $this_Bundle_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTerminologyBoxAccess().getTerminologyGraphParserRuleCall_1());
		}
		this_TerminologyGraph_1=ruleTerminologyGraph
		{
			$current = $this_TerminologyGraph_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTerminologyGraph
entryRuleTerminologyGraph returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminologyGraphRule()); }
	iv_ruleTerminologyGraph=ruleTerminologyGraph
	{ $current=$iv_ruleTerminologyGraph.current; }
	EOF;

// Rule TerminologyGraph
ruleTerminologyGraph returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_1_0());
				}
				lv_kind_1_0=ruleTerminologyKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
					}
					set(
						$current,
						"kind",
						lv_kind_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='terminology'
		{
			newLeafNode(otherlv_2, grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_2());
		}
		(
			(
				lv_iri_3_0=RULE_IRI
				{
					newLeafNode(lv_iri_3_0, grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTerminologyGraphRule());
					}
					setWithLastConsumed(
						$current,
						"iri",
						lv_iri_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0());
					}
					lv_boxAxioms_5_0=ruleTerminologyBoxAxiom
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
						}
						add(
							$current,
							"boxAxioms",
							lv_boxAxioms_5_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxAxiom");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0());
					}
					lv_boxStatements_6_0=ruleTerminologyBoxStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
						}
						add(
							$current,
							"boxStatements",
							lv_boxStatements_6_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleBundle
entryRuleBundle returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBundleRule()); }
	iv_ruleBundle=ruleBundle
	{ $current=$iv_ruleBundle.current; }
	EOF;

// Rule Bundle
ruleBundle returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getBundleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBundleRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_1_0());
				}
				lv_kind_1_0=ruleTerminologyKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBundleRule());
					}
					set(
						$current,
						"kind",
						lv_kind_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='bundle'
		{
			newLeafNode(otherlv_2, grammarAccess.getBundleAccess().getBundleKeyword_2());
		}
		(
			(
				lv_iri_3_0=RULE_IRI
				{
					newLeafNode(lv_iri_3_0, grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBundleRule());
					}
					setWithLastConsumed(
						$current,
						"iri",
						lv_iri_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0());
					}
					lv_boxAxioms_5_0=ruleTerminologyBoxAxiom
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBundleRule());
						}
						add(
							$current,
							"boxAxioms",
							lv_boxAxioms_5_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxAxiom");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0());
					}
					lv_boxStatements_6_0=ruleTerminologyBoxStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBundleRule());
						}
						add(
							$current,
							"boxStatements",
							lv_boxStatements_6_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_5_2_0());
					}
					lv_bundleStatements_7_0=ruleTerminologyBundleStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBundleRule());
						}
						add(
							$current,
							"bundleStatements",
							lv_bundleStatements_7_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBundleStatement");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_3_0());
					}
					lv_bundleAxioms_8_0=ruleTerminologyBundleAxiom
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBundleRule());
						}
						add(
							$current,
							"bundleAxioms",
							lv_bundleAxioms_8_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBundleAxiom");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleDescriptionBox
entryRuleDescriptionBox returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDescriptionBoxRule()); }
	iv_ruleDescriptionBox=ruleDescriptionBox
	{ $current=$iv_ruleDescriptionBox.current; }
	EOF;

// Rule DescriptionBox
ruleDescriptionBox returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_1_0());
				}
				lv_kind_1_0=ruleDescriptionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
					}
					set(
						$current,
						"kind",
						lv_kind_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='descriptionBox'
		{
			newLeafNode(otherlv_2, grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_2());
		}
		(
			(
				lv_iri_3_0=RULE_IRI
				{
					newLeafNode(lv_iri_3_0, grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDescriptionBoxRule());
					}
					setWithLastConsumed(
						$current,
						"iri",
						lv_iri_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_0_0());
					}
					lv_closedWorldDefinitions_5_0=ruleDescriptionBoxExtendsClosedWorldDefinitions
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"closedWorldDefinitions",
							lv_closedWorldDefinitions_5_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxExtendsClosedWorldDefinitions");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_1_0());
					}
					lv_descriptionBoxRefinements_6_0=ruleDescriptionBoxRefinement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"descriptionBoxRefinements",
							lv_descriptionBoxRefinements_6_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxRefinement");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_5_2_0());
					}
					lv_conceptInstances_7_0=ruleConceptInstance
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"conceptInstances",
							lv_conceptInstances_7_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ConceptInstance");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_3_0());
					}
					lv_reifiedRelationshipInstances_8_0=ruleReifiedRelationshipInstance
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"reifiedRelationshipInstances",
							lv_reifiedRelationshipInstances_8_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstance");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_4_0());
					}
					lv_reifiedRelationshipInstanceDomains_9_0=ruleReifiedRelationshipInstanceDomain
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"reifiedRelationshipInstanceDomains",
							lv_reifiedRelationshipInstanceDomains_9_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceDomain");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_5_0());
					}
					lv_reifiedRelationshipInstanceRanges_10_0=ruleReifiedRelationshipInstanceRange
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"reifiedRelationshipInstanceRanges",
							lv_reifiedRelationshipInstanceRanges_10_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceRange");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_6_0());
					}
					lv_unreifiedRelationshipInstanceTuples_11_0=ruleUnreifiedRelationshipInstanceTuple
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"unreifiedRelationshipInstanceTuples",
							lv_unreifiedRelationshipInstanceTuples_11_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.UnreifiedRelationshipInstanceTuple");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_7_0());
					}
					lv_singletonScalarDataPropertyValues_12_0=ruleSingletonInstanceScalarDataPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"singletonScalarDataPropertyValues",
							lv_singletonScalarDataPropertyValues_12_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceScalarDataPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_8_0());
					}
					lv_singletonStructuredDataPropertyValues_13_0=ruleSingletonInstanceStructuredDataPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"singletonStructuredDataPropertyValues",
							lv_singletonStructuredDataPropertyValues_13_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceStructuredDataPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_14='}'
		{
			newLeafNode(otherlv_14, grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleTerminologyBoxAxiom
entryRuleTerminologyBoxAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminologyBoxAxiomRule()); }
	iv_ruleTerminologyBoxAxiom=ruleTerminologyBoxAxiom
	{ $current=$iv_ruleTerminologyBoxAxiom.current; }
	EOF;

// Rule TerminologyBoxAxiom
ruleTerminologyBoxAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getConceptDesignationTerminologyAxiomParserRuleCall_0());
		}
		this_ConceptDesignationTerminologyAxiom_0=ruleConceptDesignationTerminologyAxiom
		{
			$current = $this_ConceptDesignationTerminologyAxiom_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyExtensionAxiomParserRuleCall_1());
		}
		this_TerminologyExtensionAxiom_1=ruleTerminologyExtensionAxiom
		{
			$current = $this_TerminologyExtensionAxiom_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyNestingAxiomParserRuleCall_2());
		}
		this_TerminologyNestingAxiom_2=ruleTerminologyNestingAxiom
		{
			$current = $this_TerminologyNestingAxiom_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleBundledTerminologyAxiom
entryRuleBundledTerminologyAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBundledTerminologyAxiomRule()); }
	iv_ruleBundledTerminologyAxiom=ruleBundledTerminologyAxiom
	{ $current=$iv_ruleBundledTerminologyAxiom.current; }
	EOF;

// Rule BundledTerminologyAxiom
ruleBundledTerminologyAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getBundledTerminologyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBundledTerminologyAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='bundles'
		{
			newLeafNode(otherlv_1, grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBundledTerminologyAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_2_0());
				}
				ruleExternalReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleConceptDesignationTerminologyAxiom
entryRuleConceptDesignationTerminologyAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomRule()); }
	iv_ruleConceptDesignationTerminologyAxiom=ruleConceptDesignationTerminologyAxiom
	{ $current=$iv_ruleConceptDesignationTerminologyAxiom.current; }
	EOF;

// Rule ConceptDesignationTerminologyAxiom
ruleConceptDesignationTerminologyAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConceptDesignationTerminologyAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='conceptDesignationTerminologyAxiom'
		{
			newLeafNode(otherlv_1, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='designatedTerminology'
		{
			newLeafNode(otherlv_3, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_4_0());
				}
				ruleExternalReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='designatedConcept'
		{
			newLeafNode(otherlv_5, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleTerminologyExtensionAxiom
entryRuleTerminologyExtensionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminologyExtensionAxiomRule()); }
	iv_ruleTerminologyExtensionAxiom=ruleTerminologyExtensionAxiom
	{ $current=$iv_ruleTerminologyExtensionAxiom.current; }
	EOF;

// Rule TerminologyExtensionAxiom
ruleTerminologyExtensionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTerminologyExtensionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTerminologyExtensionAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='extends'
		{
			newLeafNode(otherlv_1, grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTerminologyExtensionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_2_0());
				}
				ruleExternalReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleTerminologyNestingAxiom
entryRuleTerminologyNestingAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminologyNestingAxiomRule()); }
	iv_ruleTerminologyNestingAxiom=ruleTerminologyNestingAxiom
	{ $current=$iv_ruleTerminologyNestingAxiom.current; }
	EOF;

// Rule TerminologyNestingAxiom
ruleTerminologyNestingAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTerminologyNestingAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='terminologyNestingAxiom'
		{
			newLeafNode(otherlv_1, grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='nestingTerminology'
		{
			newLeafNode(otherlv_3, grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_4_0());
				}
				ruleExternalReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='nestingContext'
		{
			newLeafNode(otherlv_5, grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getTerminologyNestingAxiomAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleTerminologyBoxStatement
entryRuleTerminologyBoxStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminologyBoxStatementRule()); }
	iv_ruleTerminologyBoxStatement=ruleTerminologyBoxStatement
	{ $current=$iv_ruleTerminologyBoxStatement.current; }
	EOF;

// Rule TerminologyBoxStatement
ruleTerminologyBoxStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTerminologyBoxStatementAccess().getTermAxiomParserRuleCall_0());
		}
		this_TermAxiom_0=ruleTermAxiom
		{
			$current = $this_TermAxiom_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTerminologyBoxStatementAccess().getTermParserRuleCall_1());
		}
		this_Term_1=ruleTerm
		{
			$current = $this_Term_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTerm
entryRuleTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTermRule()); }
	iv_ruleTerm=ruleTerm
	{ $current=$iv_ruleTerm.current; }
	EOF;

// Rule Term
ruleTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTermAccess().getAtomicEntityParserRuleCall_0());
		}
		this_AtomicEntity_0=ruleAtomicEntity
		{
			$current = $this_AtomicEntity_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAccess().getEntityRelationshipParserRuleCall_1());
		}
		this_EntityRelationship_1=ruleEntityRelationship
		{
			$current = $this_EntityRelationship_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAccess().getDatatypeParserRuleCall_2());
		}
		this_Datatype_2=ruleDatatype
		{
			$current = $this_Datatype_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAccess().getDataRelationshipParserRuleCall_3());
		}
		this_DataRelationship_3=ruleDataRelationship
		{
			$current = $this_DataRelationship_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAccess().getRuleParserRuleCall_4());
		}
		this_Rule_4=ruleRule
		{
			$current = $this_Rule_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAtomicEntity
entryRuleAtomicEntity returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAtomicEntityRule()); }
	iv_ruleAtomicEntity=ruleAtomicEntity
	{ $current=$iv_ruleAtomicEntity.current; }
	EOF;

// Rule AtomicEntity
ruleAtomicEntity returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAtomicEntityAccess().getAspectParserRuleCall_0());
		}
		this_Aspect_0=ruleAspect
		{
			$current = $this_Aspect_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAtomicEntityAccess().getConceptParserRuleCall_1());
		}
		this_Concept_1=ruleConcept
		{
			$current = $this_Concept_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleEntityRelationship
entryRuleEntityRelationship returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityRelationshipRule()); }
	iv_ruleEntityRelationship=ruleEntityRelationship
	{ $current=$iv_ruleEntityRelationship.current; }
	EOF;

// Rule EntityRelationship
ruleEntityRelationship returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEntityRelationshipAccess().getReifiedRelationshipParserRuleCall_0());
		}
		this_ReifiedRelationship_0=ruleReifiedRelationship
		{
			$current = $this_ReifiedRelationship_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEntityRelationshipAccess().getUnreifiedRelationshipParserRuleCall_1());
		}
		this_UnreifiedRelationship_1=ruleUnreifiedRelationship
		{
			$current = $this_UnreifiedRelationship_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleDatatype
entryRuleDatatype returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDatatypeRule()); }
	iv_ruleDatatype=ruleDatatype
	{ $current=$iv_ruleDatatype.current; }
	EOF;

// Rule Datatype
ruleDatatype returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getDatatypeAccess().getScalarDataRangeParserRuleCall_0());
		}
		this_ScalarDataRange_0=ruleScalarDataRange
		{
			$current = $this_ScalarDataRange_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDatatypeAccess().getStructureParserRuleCall_1());
		}
		this_Structure_1=ruleStructure
		{
			$current = $this_Structure_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleScalarDataRange
entryRuleScalarDataRange returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScalarDataRangeRule()); }
	iv_ruleScalarDataRange=ruleScalarDataRange
	{ $current=$iv_ruleScalarDataRange.current; }
	EOF;

// Rule ScalarDataRange
ruleScalarDataRange returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getScalarDataRangeAccess().getScalarParserRuleCall_0());
		}
		this_Scalar_0=ruleScalar
		{
			$current = $this_Scalar_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getScalarDataRangeAccess().getRestrictedDataRangeParserRuleCall_1());
		}
		this_RestrictedDataRange_1=ruleRestrictedDataRange
		{
			$current = $this_RestrictedDataRange_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleRestrictedDataRange
entryRuleRestrictedDataRange returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRestrictedDataRangeRule()); }
	iv_ruleRestrictedDataRange=ruleRestrictedDataRange
	{ $current=$iv_ruleRestrictedDataRange.current; }
	EOF;

// Rule RestrictedDataRange
ruleRestrictedDataRange returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getBinaryScalarRestrictionParserRuleCall_0());
		}
		this_BinaryScalarRestriction_0=ruleBinaryScalarRestriction
		{
			$current = $this_BinaryScalarRestriction_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getIRIScalarRestrictionParserRuleCall_1());
		}
		this_IRIScalarRestriction_1=ruleIRIScalarRestriction
		{
			$current = $this_IRIScalarRestriction_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getNumericScalarRestrictionParserRuleCall_2());
		}
		this_NumericScalarRestriction_2=ruleNumericScalarRestriction
		{
			$current = $this_NumericScalarRestriction_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getPlainLiteralScalarRestrictionParserRuleCall_3());
		}
		this_PlainLiteralScalarRestriction_3=rulePlainLiteralScalarRestriction
		{
			$current = $this_PlainLiteralScalarRestriction_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getScalarOneOfRestrictionParserRuleCall_4());
		}
		this_ScalarOneOfRestriction_4=ruleScalarOneOfRestriction
		{
			$current = $this_ScalarOneOfRestriction_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getStringScalarRestrictionParserRuleCall_5());
		}
		this_StringScalarRestriction_5=ruleStringScalarRestriction
		{
			$current = $this_StringScalarRestriction_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getSynonymScalarRestrictionParserRuleCall_6());
		}
		this_SynonymScalarRestriction_6=ruleSynonymScalarRestriction
		{
			$current = $this_SynonymScalarRestriction_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getTimeScalarRestrictionParserRuleCall_7());
		}
		this_TimeScalarRestriction_7=ruleTimeScalarRestriction
		{
			$current = $this_TimeScalarRestriction_7.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleDataRelationship
entryRuleDataRelationship returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDataRelationshipRule()); }
	iv_ruleDataRelationship=ruleDataRelationship
	{ $current=$iv_ruleDataRelationship.current; }
	EOF;

// Rule DataRelationship
ruleDataRelationship returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getDataRelationshipAccess().getEntityStructuredDataPropertyParserRuleCall_0());
		}
		this_EntityStructuredDataProperty_0=ruleEntityStructuredDataProperty
		{
			$current = $this_EntityStructuredDataProperty_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDataRelationshipAccess().getEntityScalarDataPropertyParserRuleCall_1());
		}
		this_EntityScalarDataProperty_1=ruleEntityScalarDataProperty
		{
			$current = $this_EntityScalarDataProperty_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDataRelationshipAccess().getStructuredDataPropertyParserRuleCall_2());
		}
		this_StructuredDataProperty_2=ruleStructuredDataProperty
		{
			$current = $this_StructuredDataProperty_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDataRelationshipAccess().getScalarDataPropertyParserRuleCall_3());
		}
		this_ScalarDataProperty_3=ruleScalarDataProperty
		{
			$current = $this_ScalarDataProperty_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTermAxiom
entryRuleTermAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTermAxiomRule()); }
	iv_ruleTermAxiom=ruleTermAxiom
	{ $current=$iv_ruleTermAxiom.current; }
	EOF;

// Rule TermAxiom
ruleTermAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTermAxiomAccess().getEntityRestrictionAxiomParserRuleCall_0());
		}
		this_EntityRestrictionAxiom_0=ruleEntityRestrictionAxiom
		{
			$current = $this_EntityRestrictionAxiom_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAxiomAccess().getEntityScalarDataPropertyRestrictionAxiomParserRuleCall_1());
		}
		this_EntityScalarDataPropertyRestrictionAxiom_1=ruleEntityScalarDataPropertyRestrictionAxiom
		{
			$current = $this_EntityScalarDataPropertyRestrictionAxiom_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAxiomAccess().getEntityStructuredDataPropertyRestrictionAxiomParserRuleCall_2());
		}
		this_EntityStructuredDataPropertyRestrictionAxiom_2=ruleEntityStructuredDataPropertyRestrictionAxiom
		{
			$current = $this_EntityStructuredDataPropertyRestrictionAxiom_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAxiomAccess().getScalarOneOfLiteralAxiomParserRuleCall_3());
		}
		this_ScalarOneOfLiteralAxiom_3=ruleScalarOneOfLiteralAxiom
		{
			$current = $this_ScalarOneOfLiteralAxiom_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAxiomAccess().getSpecializationAxiomParserRuleCall_4());
		}
		this_SpecializationAxiom_4=ruleSpecializationAxiom
		{
			$current = $this_SpecializationAxiom_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleEntityRestrictionAxiom
entryRuleEntityRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityRestrictionAxiomRule()); }
	iv_ruleEntityRestrictionAxiom=ruleEntityRestrictionAxiom
	{ $current=$iv_ruleEntityRestrictionAxiom.current; }
	EOF;

// Rule EntityRestrictionAxiom
ruleEntityRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEntityRestrictionAxiomAccess().getEntityExistentialRestrictionAxiomParserRuleCall_0());
		}
		this_EntityExistentialRestrictionAxiom_0=ruleEntityExistentialRestrictionAxiom
		{
			$current = $this_EntityExistentialRestrictionAxiom_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEntityRestrictionAxiomAccess().getEntityUniversalRestrictionAxiomParserRuleCall_1());
		}
		this_EntityUniversalRestrictionAxiom_1=ruleEntityUniversalRestrictionAxiom
		{
			$current = $this_EntityUniversalRestrictionAxiom_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleEntityScalarDataPropertyRestrictionAxiom
entryRuleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomRule()); }
	iv_ruleEntityScalarDataPropertyRestrictionAxiom=ruleEntityScalarDataPropertyRestrictionAxiom
	{ $current=$iv_ruleEntityScalarDataPropertyRestrictionAxiom.current; }
	EOF;

// Rule EntityScalarDataPropertyRestrictionAxiom
ruleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyExistentialRestrictionAxiomParserRuleCall_0());
		}
		this_EntityScalarDataPropertyExistentialRestrictionAxiom_0=ruleEntityScalarDataPropertyExistentialRestrictionAxiom
		{
			$current = $this_EntityScalarDataPropertyExistentialRestrictionAxiom_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyParticularRestrictionAxiomParserRuleCall_1());
		}
		this_EntityScalarDataPropertyParticularRestrictionAxiom_1=ruleEntityScalarDataPropertyParticularRestrictionAxiom
		{
			$current = $this_EntityScalarDataPropertyParticularRestrictionAxiom_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyUniversalRestrictionAxiomParserRuleCall_2());
		}
		this_EntityScalarDataPropertyUniversalRestrictionAxiom_2=ruleEntityScalarDataPropertyUniversalRestrictionAxiom
		{
			$current = $this_EntityScalarDataPropertyUniversalRestrictionAxiom_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleEntityStructuredDataPropertyRestrictionAxiom
entryRuleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityStructuredDataPropertyRestrictionAxiomRule()); }
	iv_ruleEntityStructuredDataPropertyRestrictionAxiom=ruleEntityStructuredDataPropertyRestrictionAxiom
	{ $current=$iv_ruleEntityStructuredDataPropertyRestrictionAxiom.current; }
	EOF;

// Rule EntityStructuredDataPropertyRestrictionAxiom
ruleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getEntityStructuredDataPropertyRestrictionAxiomAccess().getEntityStructuredDataPropertyParticularRestrictionAxiomParserRuleCall());
	}
	this_EntityStructuredDataPropertyParticularRestrictionAxiom_0=ruleEntityStructuredDataPropertyParticularRestrictionAxiom
	{
		$current = $this_EntityStructuredDataPropertyParticularRestrictionAxiom_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleSpecializationAxiom
entryRuleSpecializationAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSpecializationAxiomRule()); }
	iv_ruleSpecializationAxiom=ruleSpecializationAxiom
	{ $current=$iv_ruleSpecializationAxiom.current; }
	EOF;

// Rule SpecializationAxiom
ruleSpecializationAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getConceptSpecializationAxiomParserRuleCall_0());
		}
		this_ConceptSpecializationAxiom_0=ruleConceptSpecializationAxiom
		{
			$current = $this_ConceptSpecializationAxiom_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getAspectSpecializationAxiomParserRuleCall_1());
		}
		this_AspectSpecializationAxiom_1=ruleAspectSpecializationAxiom
		{
			$current = $this_AspectSpecializationAxiom_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getReifiedRelationshipSpecializationAxiomParserRuleCall_2());
		}
		this_ReifiedRelationshipSpecializationAxiom_2=ruleReifiedRelationshipSpecializationAxiom
		{
			$current = $this_ReifiedRelationshipSpecializationAxiom_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTerminologyBundleStatement
entryRuleTerminologyBundleStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminologyBundleStatementRule()); }
	iv_ruleTerminologyBundleStatement=ruleTerminologyBundleStatement
	{ $current=$iv_ruleTerminologyBundleStatement.current; }
	EOF;

// Rule TerminologyBundleStatement
ruleTerminologyBundleStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getTerminologyBundleStatementAccess().getRootConceptTaxonomyAxiomParserRuleCall());
	}
	this_RootConceptTaxonomyAxiom_0=ruleRootConceptTaxonomyAxiom
	{
		$current = $this_RootConceptTaxonomyAxiom_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleTerminologyBundleAxiom
entryRuleTerminologyBundleAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminologyBundleAxiomRule()); }
	iv_ruleTerminologyBundleAxiom=ruleTerminologyBundleAxiom
	{ $current=$iv_ruleTerminologyBundleAxiom.current; }
	EOF;

// Rule TerminologyBundleAxiom
ruleTerminologyBundleAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getTerminologyBundleAxiomAccess().getBundledTerminologyAxiomParserRuleCall());
	}
	this_BundledTerminologyAxiom_0=ruleBundledTerminologyAxiom
	{
		$current = $this_BundledTerminologyAxiom_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleDisjointUnionOfConceptsAxiom
entryRuleDisjointUnionOfConceptsAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDisjointUnionOfConceptsAxiomRule()); }
	iv_ruleDisjointUnionOfConceptsAxiom=ruleDisjointUnionOfConceptsAxiom
	{ $current=$iv_ruleDisjointUnionOfConceptsAxiom.current; }
	EOF;

// Rule DisjointUnionOfConceptsAxiom
ruleDisjointUnionOfConceptsAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getAnonymousConceptUnionAxiomParserRuleCall_0());
		}
		this_AnonymousConceptUnionAxiom_0=ruleAnonymousConceptUnionAxiom
		{
			$current = $this_AnonymousConceptUnionAxiom_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getSpecificDisjointConceptAxiomParserRuleCall_1());
		}
		this_SpecificDisjointConceptAxiom_1=ruleSpecificDisjointConceptAxiom
		{
			$current = $this_SpecificDisjointConceptAxiom_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAspect
entryRuleAspect returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAspectRule()); }
	iv_ruleAspect=ruleAspect
	{ $current=$iv_ruleAspect.current; }
	EOF;

// Rule Aspect
ruleAspect returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getAspectAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAspectRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='aspect'
		{
			newLeafNode(otherlv_1, grammarAccess.getAspectAccess().getAspectKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAspectRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleConcept
entryRuleConcept returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConceptRule()); }
	iv_ruleConcept=ruleConcept
	{ $current=$iv_ruleConcept.current; }
	EOF;

// Rule Concept
ruleConcept returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getConceptAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConceptRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='concept'
		{
			newLeafNode(otherlv_1, grammarAccess.getConceptAccess().getConceptKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleReifiedRelationship
entryRuleReifiedRelationship returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReifiedRelationshipRule()); }
	iv_ruleReifiedRelationship=ruleReifiedRelationship
	{ $current=$iv_ruleReifiedRelationship.current; }
	EOF;

// Rule ReifiedRelationship
ruleReifiedRelationship returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReifiedRelationshipRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='reifiedRelationship'
		{
			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0);
					}
								({true}?=>((
									lv_isFunctional_5_0='functional'
									{
										newLeafNode(lv_isFunctional_5_0, grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isFunctional", true, "functional");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1);
					}
								({true}?=>((
									lv_isInverseFunctional_6_0='inverseFunctional'
									{
										newLeafNode(lv_isInverseFunctional_6_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isInverseFunctional", true, "inverseFunctional");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2);
					}
								({true}?=>((
									lv_isEssential_7_0='essential'
									{
										newLeafNode(lv_isEssential_7_0, grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isEssential", true, "essential");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3);
					}
								({true}?=>((
									lv_isInverseEssential_8_0='inverseEssential'
									{
										newLeafNode(lv_isInverseEssential_8_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isInverseEssential", true, "inverseEssential");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4);
					}
								({true}?=>((
									lv_isSymmetric_9_0='symmetric'
									{
										newLeafNode(lv_isSymmetric_9_0, grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isSymmetric", true, "symmetric");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5);
					}
								({true}?=>((
									lv_isAsymmetric_10_0='asymmetric'
									{
										newLeafNode(lv_isAsymmetric_10_0, grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isAsymmetric", true, "asymmetric");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6);
					}
								({true}?=>((
									lv_isReflexive_11_0='reflexive'
									{
										newLeafNode(lv_isReflexive_11_0, grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isReflexive", true, "reflexive");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7);
					}
								({true}?=>((
									lv_isIrreflexive_12_0='irreflexive'
									{
										newLeafNode(lv_isIrreflexive_12_0, grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isIrreflexive", true, "irreflexive");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8);
					}
								({true}?=>((
									lv_isTransitive_13_0='transitive'
									{
										newLeafNode(lv_isTransitive_13_0, grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isTransitive", true, "transitive");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
				}
		)
		otherlv_14='unreified'
		{
			newLeafNode(otherlv_14, grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_5());
		}
		otherlv_15='='
		{
			newLeafNode(otherlv_15, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_6());
		}
		(
			(
				lv_unreifiedPropertyName_16_0=RULE_ID
				{
					newLeafNode(lv_unreifiedPropertyName_16_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameIDTerminalRuleCall_7_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
					}
					setWithLastConsumed(
						$current,
						"unreifiedPropertyName",
						lv_unreifiedPropertyName_16_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		(
			otherlv_17='inverse'
			{
				newLeafNode(otherlv_17, grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_8_0());
			}
			otherlv_18='='
			{
				newLeafNode(otherlv_18, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_8_1());
			}
			(
				(
					lv_unreifiedInversePropertyName_19_0=RULE_ID
					{
						newLeafNode(lv_unreifiedInversePropertyName_19_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameIDTerminalRuleCall_8_2_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
						}
						setWithLastConsumed(
							$current,
							"unreifiedInversePropertyName",
							lv_unreifiedInversePropertyName_19_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ID");
					}
				)
			)
		)?
		otherlv_20='source'
		{
			newLeafNode(otherlv_20, grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_9());
		}
		otherlv_21='='
		{
			newLeafNode(otherlv_21, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_10());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_11_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_23='target'
		{
			newLeafNode(otherlv_23, grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_12());
		}
		otherlv_24='='
		{
			newLeafNode(otherlv_24, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_13());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_14_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_26='}'
		{
			newLeafNode(otherlv_26, grammarAccess.getReifiedRelationshipAccess().getRightCurlyBracketKeyword_15());
		}
	)
;

// Entry rule entryRuleUnreifiedRelationship
entryRuleUnreifiedRelationship returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnreifiedRelationshipRule()); }
	iv_ruleUnreifiedRelationship=ruleUnreifiedRelationship
	{ $current=$iv_ruleUnreifiedRelationship.current; }
	EOF;

// Rule UnreifiedRelationship
ruleUnreifiedRelationship returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnreifiedRelationshipRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='unreifiedRelationship'
		{
			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0);
					}
								({true}?=>((
									lv_isFunctional_5_0='functional'
									{
										newLeafNode(lv_isFunctional_5_0, grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isFunctional", true, "functional");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1);
					}
								({true}?=>((
									lv_isInverseFunctional_6_0='inverseFunctional'
									{
										newLeafNode(lv_isInverseFunctional_6_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isInverseFunctional", true, "inverseFunctional");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2);
					}
								({true}?=>((
									lv_isEssential_7_0='essential'
									{
										newLeafNode(lv_isEssential_7_0, grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isEssential", true, "essential");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3);
					}
								({true}?=>((
									lv_isInverseEssential_8_0='inverseEssential'
									{
										newLeafNode(lv_isInverseEssential_8_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isInverseEssential", true, "inverseEssential");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4);
					}
								({true}?=>((
									lv_isSymmetric_9_0='symmetric'
									{
										newLeafNode(lv_isSymmetric_9_0, grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isSymmetric", true, "symmetric");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5);
					}
								({true}?=>((
									lv_isAsymmetric_10_0='asymmetric'
									{
										newLeafNode(lv_isAsymmetric_10_0, grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isAsymmetric", true, "asymmetric");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6);
					}
								({true}?=>((
									lv_isReflexive_11_0='reflexive'
									{
										newLeafNode(lv_isReflexive_11_0, grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isReflexive", true, "reflexive");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7);
					}
								({true}?=>((
									lv_isIrreflexive_12_0='irreflexive'
									{
										newLeafNode(lv_isIrreflexive_12_0, grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isIrreflexive", true, "irreflexive");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8);
					}
								({true}?=>((
									lv_isTransitive_13_0='transitive'
									{
										newLeafNode(lv_isTransitive_13_0, grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0());
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
										}
										setWithLastConsumed($current, "isTransitive", true, "transitive");
									}
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
				}
		)
		otherlv_14='source'
		{
			newLeafNode(otherlv_14, grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_5());
		}
		otherlv_15='='
		{
			newLeafNode(otherlv_15, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_6());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_7_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_17='target'
		{
			newLeafNode(otherlv_17, grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_8());
		}
		otherlv_18='='
		{
			newLeafNode(otherlv_18, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_9());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_10_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_20='}'
		{
			newLeafNode(otherlv_20, grammarAccess.getUnreifiedRelationshipAccess().getRightCurlyBracketKeyword_11());
		}
	)
;

// Entry rule entryRuleScalar
entryRuleScalar returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScalarRule()); }
	iv_ruleScalar=ruleScalar
	{ $current=$iv_ruleScalar.current; }
	EOF;

// Rule Scalar
ruleScalar returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getScalarAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScalarRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='scalar'
		{
			newLeafNode(otherlv_1, grammarAccess.getScalarAccess().getScalarKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleStructure
entryRuleStructure returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructureRule()); }
	iv_ruleStructure=ruleStructure
	{ $current=$iv_ruleStructure.current; }
	EOF;

// Rule Structure
ruleStructure returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='structure'
		{
			newLeafNode(otherlv_1, grammarAccess.getStructureAccess().getStructureKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructureRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleEntityStructuredDataProperty
entryRuleEntityStructuredDataProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityStructuredDataPropertyRule()); }
	iv_ruleEntityStructuredDataProperty=ruleEntityStructuredDataProperty
	{ $current=$iv_ruleEntityStructuredDataProperty.current; }
	EOF;

// Rule EntityStructuredDataProperty
ruleEntityStructuredDataProperty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='entityStructuredDataProperty'
		{
			newLeafNode(otherlv_1, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_1());
		}
		(
			(
				lv_isIdentityCriteria_2_0='+'
				{
					newLeafNode(lv_isIdentityCriteria_2_0, grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
					}
					setWithLastConsumed($current, "isIdentityCriteria", true, "+");
				}
			)
		)?
		(
			(
				lv_name_3_0=RULE_ID
				{
					newLeafNode(lv_name_3_0, grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_4());
		}
		otherlv_5='domain'
		{
			newLeafNode(otherlv_5, grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='range'
		{
			newLeafNode(otherlv_7, grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_7());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_8_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getEntityStructuredDataPropertyAccess().getRightCurlyBracketKeyword_9());
		}
	)
;

// Entry rule entryRuleEntityScalarDataProperty
entryRuleEntityScalarDataProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityScalarDataPropertyRule()); }
	iv_ruleEntityScalarDataProperty=ruleEntityScalarDataProperty
	{ $current=$iv_ruleEntityScalarDataProperty.current; }
	EOF;

// Rule EntityScalarDataProperty
ruleEntityScalarDataProperty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='entityScalarDataProperty'
		{
			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_1());
		}
		(
			(
				lv_isIdentityCriteria_2_0='+'
				{
					newLeafNode(lv_isIdentityCriteria_2_0, grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
					}
					setWithLastConsumed($current, "isIdentityCriteria", true, "+");
				}
			)
		)?
		(
			(
				lv_name_3_0=RULE_ID
				{
					newLeafNode(lv_name_3_0, grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_4());
		}
		otherlv_5='domain'
		{
			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='range'
		{
			newLeafNode(otherlv_7, grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_7());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_8_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getEntityScalarDataPropertyAccess().getRightCurlyBracketKeyword_9());
		}
	)
;

// Entry rule entryRuleStructuredDataProperty
entryRuleStructuredDataProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructuredDataPropertyRule()); }
	iv_ruleStructuredDataProperty=ruleStructuredDataProperty
	{ $current=$iv_ruleStructuredDataProperty.current; }
	EOF;

// Rule StructuredDataProperty
ruleStructuredDataProperty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructuredDataPropertyRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='structuredDataProperty'
		{
			newLeafNode(otherlv_1, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3());
		}
		otherlv_4='domain'
		{
			newLeafNode(otherlv_4, grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='range'
		{
			newLeafNode(otherlv_6, grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_6());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getStructuredDataPropertyAccess().getRightCurlyBracketKeyword_8());
		}
	)
;

// Entry rule entryRuleScalarDataProperty
entryRuleScalarDataProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScalarDataPropertyRule()); }
	iv_ruleScalarDataProperty=ruleScalarDataProperty
	{ $current=$iv_ruleScalarDataProperty.current; }
	EOF;

// Rule ScalarDataProperty
ruleScalarDataProperty returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScalarDataPropertyRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='scalarDataProperty'
		{
			newLeafNode(otherlv_1, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarDataPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
		}
		otherlv_4='domain'
		{
			newLeafNode(otherlv_4, grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='range'
		{
			newLeafNode(otherlv_6, grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_6());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_8());
		}
	)
;

// Entry rule entryRuleRule
entryRuleRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRuleRule()); }
	iv_ruleRule=ruleRule
	{ $current=$iv_ruleRule.current; }
	EOF;

// Rule Rule
ruleRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getRuleAccess().getChainRuleParserRuleCall());
	}
	this_ChainRule_0=ruleChainRule
	{
		$current = $this_ChainRule_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleChainRule
entryRuleChainRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChainRuleRule()); }
	iv_ruleChainRule=ruleChainRule
	{ $current=$iv_ruleChainRule.current; }
	EOF;

// Rule ChainRule
ruleChainRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='rule'
		{
			newLeafNode(otherlv_0, grammarAccess.getChainRuleAccess().getRuleKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getChainRuleAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getChainRuleRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='infers'
		{
			newLeafNode(otherlv_2, grammarAccess.getChainRuleAccess().getInfersKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getChainRuleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getChainRuleAccess().getHeadUnreifiedRelationshipCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='if'
		{
			newLeafNode(otherlv_4, grammarAccess.getChainRuleAccess().getIfKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChainRuleAccess().getFirstSegmentRuleBodySegmentParserRuleCall_5_0());
				}
				lv_firstSegment_5_0=ruleRuleBodySegment
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChainRuleRule());
					}
					set(
						$current,
						"firstSegment",
						lv_firstSegment_5_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.RuleBodySegment");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleRuleBodySegment
entryRuleRuleBodySegment returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRuleBodySegmentRule()); }
	iv_ruleRuleBodySegment=ruleRuleBodySegment
	{ $current=$iv_ruleRuleBodySegment.current; }
	EOF;

// Rule RuleBodySegment
ruleRuleBodySegment returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRuleBodySegmentAccess().getPredicateSegmentPredicateParserRuleCall_0_0());
				}
				lv_predicate_0_0=ruleSegmentPredicate
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRuleBodySegmentRule());
					}
					set(
						$current,
						"predicate",
						lv_predicate_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.SegmentPredicate");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='&&'
			{
				newLeafNode(otherlv_1, grammarAccess.getRuleBodySegmentAccess().getAmpersandAmpersandKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRuleBodySegmentAccess().getNextSegmentRuleBodySegmentParserRuleCall_1_1_0());
					}
					lv_nextSegment_2_0=ruleRuleBodySegment
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRuleBodySegmentRule());
						}
						set(
							$current,
							"nextSegment",
							lv_nextSegment_2_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.RuleBodySegment");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleSegmentPredicate
entryRuleSegmentPredicate returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSegmentPredicateRule()); }
	iv_ruleSegmentPredicate=ruleSegmentPredicate
	{ $current=$iv_ruleSegmentPredicate.current; }
	EOF;

// Rule SegmentPredicate
ruleSegmentPredicate returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='aspect'
			{
				newLeafNode(otherlv_0, grammarAccess.getSegmentPredicateAccess().getAspectKeyword_0_0());
			}
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_0_1());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getAspectPredicateAction_0_2(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getAspectAspectCrossReference_0_3_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4=')'
			{
				newLeafNode(otherlv_4, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_0_4());
			}
		)
		    |
		(
			otherlv_5='concept'
			{
				newLeafNode(otherlv_5, grammarAccess.getSegmentPredicateAccess().getConceptKeyword_1_0());
			}
			otherlv_6='('
			{
				newLeafNode(otherlv_6, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_1_1());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getConceptPredicateAction_1_2(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getConceptConceptCrossReference_1_3_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_9=')'
			{
				newLeafNode(otherlv_9, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_1_4());
			}
		)
		    |
		(
			otherlv_10='reifiedRelationship'
			{
				newLeafNode(otherlv_10, grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipKeyword_2_0());
			}
			otherlv_11='('
			{
				newLeafNode(otherlv_11, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_2_1());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipPredicateAction_2_2(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipCrossReference_2_3_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_14=')'
			{
				newLeafNode(otherlv_14, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_2_4());
			}
		)
		    |
		(
			otherlv_15='property'
			{
				newLeafNode(otherlv_15, grammarAccess.getSegmentPredicateAccess().getPropertyKeyword_3_0());
			}
			otherlv_16='('
			{
				newLeafNode(otherlv_16, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_3_1());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipPropertyPredicateAction_3_2(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipCrossReference_3_3_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_19=')'
			{
				newLeafNode(otherlv_19, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_3_4());
			}
		)
		    |
		(
			otherlv_20='inv'
			{
				newLeafNode(otherlv_20, grammarAccess.getSegmentPredicateAccess().getInvKeyword_4_0());
			}
			otherlv_21='('
			{
				newLeafNode(otherlv_21, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_4_1());
			}
			otherlv_22='property'
			{
				newLeafNode(otherlv_22, grammarAccess.getSegmentPredicateAccess().getPropertyKeyword_4_2());
			}
			otherlv_23='('
			{
				newLeafNode(otherlv_23, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_4_3());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInversePropertyPredicateAction_4_4(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipCrossReference_4_5_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_26=')'
			{
				newLeafNode(otherlv_26, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_4_6());
			}
			otherlv_27=')'
			{
				newLeafNode(otherlv_27, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_4_7());
			}
		)
		    |
		(
			otherlv_28='source'
			{
				newLeafNode(otherlv_28, grammarAccess.getSegmentPredicateAccess().getSourceKeyword_5_0());
			}
			otherlv_29='('
			{
				newLeafNode(otherlv_29, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_5_1());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourcePropertyPredicateAction_5_2(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipCrossReference_5_3_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_32=')'
			{
				newLeafNode(otherlv_32, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_5_4());
			}
		)
		    |
		(
			otherlv_33='inv'
			{
				newLeafNode(otherlv_33, grammarAccess.getSegmentPredicateAccess().getInvKeyword_6_0());
			}
			otherlv_34='('
			{
				newLeafNode(otherlv_34, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_6_1());
			}
			otherlv_35='source'
			{
				newLeafNode(otherlv_35, grammarAccess.getSegmentPredicateAccess().getSourceKeyword_6_2());
			}
			otherlv_36='('
			{
				newLeafNode(otherlv_36, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_6_3());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceInversePropertyPredicateAction_6_4(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipCrossReference_6_5_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_39=')'
			{
				newLeafNode(otherlv_39, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_6_6());
			}
			otherlv_40=')'
			{
				newLeafNode(otherlv_40, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_6_7());
			}
		)
		    |
		(
			otherlv_41='target'
			{
				newLeafNode(otherlv_41, grammarAccess.getSegmentPredicateAccess().getTargetKeyword_7_0());
			}
			otherlv_42='('
			{
				newLeafNode(otherlv_42, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_7_1());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetPropertyPredicateAction_7_2(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipCrossReference_7_3_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_45=')'
			{
				newLeafNode(otherlv_45, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_7_4());
			}
		)
		    |
		(
			otherlv_46='inv'
			{
				newLeafNode(otherlv_46, grammarAccess.getSegmentPredicateAccess().getInvKeyword_8_0());
			}
			otherlv_47='('
			{
				newLeafNode(otherlv_47, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_8_1());
			}
			otherlv_48='target'
			{
				newLeafNode(otherlv_48, grammarAccess.getSegmentPredicateAccess().getTargetKeyword_8_2());
			}
			otherlv_49='('
			{
				newLeafNode(otherlv_49, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_8_3());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetInversePropertyPredicateAction_8_4(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipReifiedRelationshipCrossReference_8_5_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_52=')'
			{
				newLeafNode(otherlv_52, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_8_6());
			}
			otherlv_53=')'
			{
				newLeafNode(otherlv_53, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_8_7());
			}
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipPropertyPredicateAction_9_0(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_9_1_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			otherlv_56='inv'
			{
				newLeafNode(otherlv_56, grammarAccess.getSegmentPredicateAccess().getInvKeyword_10_0());
			}
			otherlv_57='('
			{
				newLeafNode(otherlv_57, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_10_1());
			}
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInversePropertyPredicateAction_10_2(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSegmentPredicateRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_10_3_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_60=')'
			{
				newLeafNode(otherlv_60, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_10_4());
			}
		)
	)
;

// Entry rule entryRuleAnonymousConceptUnionAxiom
entryRuleAnonymousConceptUnionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomRule()); }
	iv_ruleAnonymousConceptUnionAxiom=ruleAnonymousConceptUnionAxiom
	{ $current=$iv_ruleAnonymousConceptUnionAxiom.current; }
	EOF;

// Rule AnonymousConceptUnionAxiom
ruleAnonymousConceptUnionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAnonymousConceptUnionAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='anonymousConceptUnion'
		{
			newLeafNode(otherlv_1, grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_name_3_0=RULE_ID
				{
					newLeafNode(lv_name_3_0, grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameIDTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnonymousConceptUnionAxiomRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_4());
		}
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0());
				}
				lv_disjunctions_6_0=ruleDisjointUnionOfConceptsAxiom
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAnonymousConceptUnionAxiomRule());
					}
					add(
						$current,
						"disjunctions",
						lv_disjunctions_6_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleRootConceptTaxonomyAxiom
entryRuleRootConceptTaxonomyAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomRule()); }
	iv_ruleRootConceptTaxonomyAxiom=ruleRootConceptTaxonomyAxiom
	{ $current=$iv_ruleRootConceptTaxonomyAxiom.current; }
	EOF;

// Rule RootConceptTaxonomyAxiom
ruleRootConceptTaxonomyAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRootConceptTaxonomyAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='rootConceptTaxonomy'
		{
			newLeafNode(otherlv_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRootConceptTaxonomyAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_4());
		}
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0());
				}
				lv_disjunctions_6_0=ruleDisjointUnionOfConceptsAxiom
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRootConceptTaxonomyAxiomRule());
					}
					add(
						$current,
						"disjunctions",
						lv_disjunctions_6_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleSpecificDisjointConceptAxiom
entryRuleSpecificDisjointConceptAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomRule()); }
	iv_ruleSpecificDisjointConceptAxiom=ruleSpecificDisjointConceptAxiom
	{ $current=$iv_ruleSpecificDisjointConceptAxiom.current; }
	EOF;

// Rule SpecificDisjointConceptAxiom
ruleSpecificDisjointConceptAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSpecificDisjointConceptAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='disjointLeaf'
		{
			newLeafNode(otherlv_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getSpecificDisjointConceptAxiomAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleEntityExistentialRestrictionAxiom
entryRuleEntityExistentialRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomRule()); }
	iv_ruleEntityExistentialRestrictionAxiom=ruleEntityExistentialRestrictionAxiom
	{ $current=$iv_ruleEntityExistentialRestrictionAxiom.current; }
	EOF;

// Rule EntityExistentialRestrictionAxiom
ruleEntityExistentialRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityExistentialRestrictionAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='someEntities'
		{
			newLeafNode(otherlv_1, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='.'
		{
			newLeafNode(otherlv_3, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationEntityRelationshipCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='in'
		{
			newLeafNode(otherlv_5, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEntityUniversalRestrictionAxiom
entryRuleEntityUniversalRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomRule()); }
	iv_ruleEntityUniversalRestrictionAxiom=ruleEntityUniversalRestrictionAxiom
	{ $current=$iv_ruleEntityUniversalRestrictionAxiom.current; }
	EOF;

// Rule EntityUniversalRestrictionAxiom
ruleEntityUniversalRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityUniversalRestrictionAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='allEntities'
		{
			newLeafNode(otherlv_1, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='.'
		{
			newLeafNode(otherlv_3, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationEntityRelationshipCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='in'
		{
			newLeafNode(otherlv_5, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleAspectSpecializationAxiom
entryRuleAspectSpecializationAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAspectSpecializationAxiomRule()); }
	iv_ruleAspectSpecializationAxiom=ruleAspectSpecializationAxiom
	{ $current=$iv_ruleAspectSpecializationAxiom.current; }
	EOF;

// Rule AspectSpecializationAxiom
ruleAspectSpecializationAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAspectSpecializationAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='extendsAspect'
		{
			newLeafNode(otherlv_2, grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleConceptSpecializationAxiom
entryRuleConceptSpecializationAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConceptSpecializationAxiomRule()); }
	iv_ruleConceptSpecializationAxiom=ruleConceptSpecializationAxiom
	{ $current=$iv_ruleConceptSpecializationAxiom.current; }
	EOF;

// Rule ConceptSpecializationAxiom
ruleConceptSpecializationAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConceptSpecializationAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='extendsConcept'
		{
			newLeafNode(otherlv_2, grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleReifiedRelationshipSpecializationAxiom
entryRuleReifiedRelationshipSpecializationAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomRule()); }
	iv_ruleReifiedRelationshipSpecializationAxiom=ruleReifiedRelationshipSpecializationAxiom
	{ $current=$iv_ruleReifiedRelationshipSpecializationAxiom.current; }
	EOF;

// Rule ReifiedRelationshipSpecializationAxiom
ruleReifiedRelationshipSpecializationAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='extendsRelationship'
		{
			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom
entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule()); }
	iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom=ruleEntityScalarDataPropertyExistentialRestrictionAxiom
	{ $current=$iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom.current; }
	EOF;

// Rule EntityScalarDataPropertyExistentialRestrictionAxiom
ruleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='someData'
		{
			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='.'
		{
			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='in'
		{
			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEntityScalarDataPropertyParticularRestrictionAxiom
entryRuleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule()); }
	iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom=ruleEntityScalarDataPropertyParticularRestrictionAxiom
	{ $current=$iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom.current; }
	EOF;

// Rule EntityScalarDataPropertyParticularRestrictionAxiom
ruleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='every'
		{
			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='.'
		{
			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='='
		{
			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueLiteralValueParserRuleCall_6_0());
				}
				lv_literalValue_6_0=ruleLiteralValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
					}
					set(
						$current,
						"literalValue",
						lv_literalValue_6_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_7='^^'
			{
				newLeafNode(otherlv_7, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_7_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeDataRangeCrossReference_7_1_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom
entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule()); }
	iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom=ruleEntityScalarDataPropertyUniversalRestrictionAxiom
	{ $current=$iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom.current; }
	EOF;

// Rule EntityScalarDataPropertyUniversalRestrictionAxiom
ruleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='allData'
		{
			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='.'
		{
			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='in'
		{
			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom
entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule()); }
	iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom=ruleEntityStructuredDataPropertyParticularRestrictionAxiom
	{ $current=$iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom.current; }
	EOF;

// Rule EntityStructuredDataPropertyParticularRestrictionAxiom
ruleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='every'
		{
			newLeafNode(otherlv_1, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='.'
		{
			newLeafNode(otherlv_3, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='='
		{
			newLeafNode(otherlv_5, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5());
		}
		otherlv_6='{'
		{
			newLeafNode(otherlv_6, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_6());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0());
					}
					lv_structuredDataPropertyRestrictions_7_0=ruleRestrictionStructuredDataPropertyTuple
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
						}
						add(
							$current,
							"structuredDataPropertyRestrictions",
							lv_structuredDataPropertyRestrictions_7_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionStructuredDataPropertyTuple");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0());
					}
					lv_scalarDataPropertyRestrictions_8_0=ruleRestrictionScalarDataPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
						}
						add(
							$current,
							"scalarDataPropertyRestrictions",
							lv_scalarDataPropertyRestrictions_8_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionScalarDataPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRightCurlyBracketKeyword_8());
		}
	)
;

// Entry rule entryRuleRestrictionStructuredDataPropertyTuple
entryRuleRestrictionStructuredDataPropertyTuple returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleRule()); }
	iv_ruleRestrictionStructuredDataPropertyTuple=ruleRestrictionStructuredDataPropertyTuple
	{ $current=$iv_ruleRestrictionStructuredDataPropertyTuple.current; }
	EOF;

// Rule RestrictionStructuredDataPropertyTuple
ruleRestrictionStructuredDataPropertyTuple returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2());
		}
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0());
					}
					lv_structuredDataPropertyRestrictions_4_0=ruleRestrictionStructuredDataPropertyTuple
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
						}
						add(
							$current,
							"structuredDataPropertyRestrictions",
							lv_structuredDataPropertyRestrictions_4_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionStructuredDataPropertyTuple");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0());
					}
					lv_scalarDataPropertyRestrictions_5_0=ruleRestrictionScalarDataPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
						}
						add(
							$current,
							"scalarDataPropertyRestrictions",
							lv_scalarDataPropertyRestrictions_5_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionScalarDataPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleRestrictionScalarDataPropertyValue
entryRuleRestrictionScalarDataPropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueRule()); }
	iv_ruleRestrictionScalarDataPropertyValue=ruleRestrictionScalarDataPropertyValue
	{ $current=$iv_ruleRestrictionScalarDataPropertyValue.current; }
	EOF;

// Rule RestrictionScalarDataPropertyValue
ruleRestrictionScalarDataPropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRestrictionScalarDataPropertyValueRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRestrictionScalarDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0());
				}
				lv_scalarPropertyValue_3_0=ruleLiteralValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRestrictionScalarDataPropertyValueRule());
					}
					set(
						$current,
						"scalarPropertyValue",
						lv_scalarPropertyValue_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4='^^'
			{
				newLeafNode(otherlv_4, grammarAccess.getRestrictionScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRestrictionScalarDataPropertyValueRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_4_1_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleBinaryScalarRestriction
entryRuleBinaryScalarRestriction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBinaryScalarRestrictionRule()); }
	iv_ruleBinaryScalarRestriction=ruleBinaryScalarRestriction
	{ $current=$iv_ruleBinaryScalarRestriction.current; }
	EOF;

// Rule BinaryScalarRestriction
ruleBinaryScalarRestriction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBinaryScalarRestrictionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='binaryScalarRestriction'
		{
			newLeafNode(otherlv_1, grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0);
					}
								({true}?=>(otherlv_5='length'
								{
									newLeafNode(otherlv_5, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_4_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
										}
										lv_length_6_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getBinaryScalarRestrictionRule());
											}
											set(
												$current,
												"length",
												lv_length_6_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1);
					}
								({true}?=>(otherlv_7='minLength'
								{
									newLeafNode(otherlv_7, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
										}
										lv_minLength_8_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getBinaryScalarRestrictionRule());
											}
											set(
												$current,
												"minLength",
												lv_minLength_8_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2);
					}
								({true}?=>(otherlv_9='maxLength'
								{
									newLeafNode(otherlv_9, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
										}
										lv_maxLength_10_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getBinaryScalarRestrictionRule());
											}
											set(
												$current,
												"maxLength",
												lv_maxLength_10_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
				}
		)
		otherlv_11='restrictedRange'
		{
			newLeafNode(otherlv_11, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_13='}'
		{
			newLeafNode(otherlv_13, grammarAccess.getBinaryScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleIRIScalarRestriction
entryRuleIRIScalarRestriction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIRIScalarRestrictionRule()); }
	iv_ruleIRIScalarRestriction=ruleIRIScalarRestriction
	{ $current=$iv_ruleIRIScalarRestriction.current; }
	EOF;

// Rule IRIScalarRestriction
ruleIRIScalarRestriction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='iriScalarRestriction'
		{
			newLeafNode(otherlv_1, grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0);
					}
								({true}?=>(otherlv_5='length'
								{
									newLeafNode(otherlv_5, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_4_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
										}
										lv_length_6_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
											}
											set(
												$current,
												"length",
												lv_length_6_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1);
					}
								({true}?=>(otherlv_7='minLength'
								{
									newLeafNode(otherlv_7, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
										}
										lv_minLength_8_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
											}
											set(
												$current,
												"minLength",
												lv_minLength_8_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2);
					}
								({true}?=>(otherlv_9='maxLength'
								{
									newLeafNode(otherlv_9, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
										}
										lv_maxLength_10_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
											}
											set(
												$current,
												"maxLength",
												lv_maxLength_10_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3);
					}
								({true}?=>(otherlv_11='pattern'
								{
									newLeafNode(otherlv_11, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_4_3_0());
								}
								(
									(
										lv_pattern_12_0=RULE_PATTERN
										{
											newLeafNode(lv_pattern_12_0, grammarAccess.getIRIScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"pattern",
												lv_pattern_12_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PATTERN");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
				}
		)
		otherlv_13='restrictedRange'
		{
			newLeafNode(otherlv_13, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_15='}'
		{
			newLeafNode(otherlv_15, grammarAccess.getIRIScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleNumericScalarRestriction
entryRuleNumericScalarRestriction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumericScalarRestrictionRule()); }
	iv_ruleNumericScalarRestriction=ruleNumericScalarRestriction
	{ $current=$iv_ruleNumericScalarRestriction.current; }
	EOF;

// Rule NumericScalarRestriction
ruleNumericScalarRestriction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='numericScalarRestriction'
		{
			newLeafNode(otherlv_1, grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0);
					}
								({true}?=>(otherlv_5='minInclusive'
								{
									newLeafNode(otherlv_5, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveLiteralNumberParserRuleCall_4_0_1_0());
										}
										lv_minInclusive_6_0=ruleLiteralNumber
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
											}
											set(
												$current,
												"minInclusive",
												lv_minInclusive_6_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1);
					}
								({true}?=>(otherlv_7='maxInclusive'
								{
									newLeafNode(otherlv_7, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0());
										}
										lv_maxInclusive_8_0=ruleLiteralNumber
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
											}
											set(
												$current,
												"maxInclusive",
												lv_maxInclusive_8_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2);
					}
								({true}?=>(otherlv_9='minExclusive'
								{
									newLeafNode(otherlv_9, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveLiteralNumberParserRuleCall_4_2_1_0());
										}
										lv_minExclusive_10_0=ruleLiteralNumber
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
											}
											set(
												$current,
												"minExclusive",
												lv_minExclusive_10_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3);
					}
								({true}?=>(otherlv_11='maxExclusive'
								{
									newLeafNode(otherlv_11, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0());
										}
										lv_maxExclusive_12_0=ruleLiteralNumber
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
											}
											set(
												$current,
												"maxExclusive",
												lv_maxExclusive_12_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
				}
		)
		otherlv_13='restrictedRange'
		{
			newLeafNode(otherlv_13, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_15='}'
		{
			newLeafNode(otherlv_15, grammarAccess.getNumericScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRulePlainLiteralScalarRestriction
entryRulePlainLiteralScalarRestriction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionRule()); }
	iv_rulePlainLiteralScalarRestriction=rulePlainLiteralScalarRestriction
	{ $current=$iv_rulePlainLiteralScalarRestriction.current; }
	EOF;

// Rule PlainLiteralScalarRestriction
rulePlainLiteralScalarRestriction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='plainLiteralScalarRestriction'
		{
			newLeafNode(otherlv_1, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0);
					}
								({true}?=>(otherlv_5='length'
								{
									newLeafNode(otherlv_5, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_4_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
										}
										lv_length_6_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											set(
												$current,
												"length",
												lv_length_6_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1);
					}
								({true}?=>(otherlv_7='minLength'
								{
									newLeafNode(otherlv_7, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
										}
										lv_minLength_8_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											set(
												$current,
												"minLength",
												lv_minLength_8_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2);
					}
								({true}?=>(otherlv_9='maxLength'
								{
									newLeafNode(otherlv_9, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
										}
										lv_maxLength_10_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											set(
												$current,
												"maxLength",
												lv_maxLength_10_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3);
					}
								({true}?=>(otherlv_11='pattern'
								{
									newLeafNode(otherlv_11, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_4_3_0());
								}
								(
									(
										lv_pattern_12_0=RULE_PATTERN
										{
											newLeafNode(lv_pattern_12_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"pattern",
												lv_pattern_12_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PATTERN");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4);
					}
								({true}?=>(otherlv_13='langRange'
								{
									newLeafNode(otherlv_13, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_4_4_0());
								}
								(
									(
										lv_langRange_14_0=RULE_LANG_TAG
										{
											newLeafNode(lv_langRange_14_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeLANG_TAGTerminalRuleCall_4_4_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"langRange",
												lv_langRange_14_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LANG_TAG");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
				}
		)
		otherlv_15='restrictedRange'
		{
			newLeafNode(otherlv_15, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_17='}'
		{
			newLeafNode(otherlv_17, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleScalarOneOfRestriction
entryRuleScalarOneOfRestriction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScalarOneOfRestrictionRule()); }
	iv_ruleScalarOneOfRestriction=ruleScalarOneOfRestriction
	{ $current=$iv_ruleScalarOneOfRestriction.current; }
	EOF;

// Rule ScalarOneOfRestriction
ruleScalarOneOfRestriction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScalarOneOfRestrictionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='scalarOneOfRestriction'
		{
			newLeafNode(otherlv_1, grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_3());
		}
		otherlv_4='restrictedRange'
		{
			newLeafNode(otherlv_4, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getScalarOneOfRestrictionAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleScalarOneOfLiteralAxiom
entryRuleScalarOneOfLiteralAxiom returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomRule()); }
	iv_ruleScalarOneOfLiteralAxiom=ruleScalarOneOfLiteralAxiom
	{ $current=$iv_ruleScalarOneOfLiteralAxiom.current; }
	EOF;

// Rule ScalarOneOfLiteralAxiom
ruleScalarOneOfLiteralAxiom returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScalarOneOfLiteralAxiomRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='oneOf'
		{
			newLeafNode(otherlv_1, grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='='
		{
			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueLiteralValueParserRuleCall_4_0());
				}
				lv_value_4_0=ruleLiteralValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScalarOneOfLiteralAxiomRule());
					}
					set(
						$current,
						"value",
						lv_value_4_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_5='^^'
			{
				newLeafNode(otherlv_5, grammarAccess.getScalarOneOfLiteralAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_5_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeDataRangeCrossReference_5_1_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleStringScalarRestriction
entryRuleStringScalarRestriction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStringScalarRestrictionRule()); }
	iv_ruleStringScalarRestriction=ruleStringScalarRestriction
	{ $current=$iv_ruleStringScalarRestriction.current; }
	EOF;

// Rule StringScalarRestriction
ruleStringScalarRestriction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='stringScalarRestriction'
		{
			newLeafNode(otherlv_1, grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0);
					}
								({true}?=>(otherlv_5='length'
								{
									newLeafNode(otherlv_5, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_4_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
										}
										lv_length_6_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
											}
											set(
												$current,
												"length",
												lv_length_6_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1);
					}
								({true}?=>(otherlv_7='minLength'
								{
									newLeafNode(otherlv_7, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
										}
										lv_minLength_8_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
											}
											set(
												$current,
												"minLength",
												lv_minLength_8_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2);
					}
								({true}?=>(otherlv_9='maxLength'
								{
									newLeafNode(otherlv_9, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
										}
										lv_maxLength_10_0=rulePositiveIntegerLiteral
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
											}
											set(
												$current,
												"maxLength",
												lv_maxLength_10_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3);
					}
								({true}?=>(otherlv_11='pattern'
								{
									newLeafNode(otherlv_11, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_4_3_0());
								}
								(
									(
										lv_pattern_12_0=RULE_PATTERN
										{
											newLeafNode(lv_pattern_12_0, grammarAccess.getStringScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"pattern",
												lv_pattern_12_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.PATTERN");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
				}
		)
		otherlv_13='restrictedRange'
		{
			newLeafNode(otherlv_13, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_15='}'
		{
			newLeafNode(otherlv_15, grammarAccess.getStringScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleSynonymScalarRestriction
entryRuleSynonymScalarRestriction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSynonymScalarRestrictionRule()); }
	iv_ruleSynonymScalarRestriction=ruleSynonymScalarRestriction
	{ $current=$iv_ruleSynonymScalarRestriction.current; }
	EOF;

// Rule SynonymScalarRestriction
ruleSynonymScalarRestriction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSynonymScalarRestrictionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='synonymScalarRestriction'
		{
			newLeafNode(otherlv_1, grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
		}
		otherlv_4='restrictedRange'
		{
			newLeafNode(otherlv_4, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getSynonymScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleTimeScalarRestriction
entryRuleTimeScalarRestriction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTimeScalarRestrictionRule()); }
	iv_ruleTimeScalarRestriction=ruleTimeScalarRestriction
	{ $current=$iv_ruleTimeScalarRestriction.current; }
	EOF;

// Rule TimeScalarRestriction
ruleTimeScalarRestriction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='timeScalarRestriction'
		{
			newLeafNode(otherlv_1, grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0);
					}
								({true}?=>(otherlv_5='minInclusive'
								{
									newLeafNode(otherlv_5, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0());
										}
										lv_minInclusive_6_0=ruleLiteralDateTime
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
											}
											set(
												$current,
												"minInclusive",
												lv_minInclusive_6_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1);
					}
								({true}?=>(otherlv_7='maxInclusive'
								{
									newLeafNode(otherlv_7, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0());
										}
										lv_maxInclusive_8_0=ruleLiteralDateTime
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
											}
											set(
												$current,
												"maxInclusive",
												lv_maxInclusive_8_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2);
					}
								({true}?=>(otherlv_9='minExclusive'
								{
									newLeafNode(otherlv_9, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0());
										}
										lv_minExclusive_10_0=ruleLiteralDateTime
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
											}
											set(
												$current,
												"minExclusive",
												lv_minExclusive_10_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3);
					}
								({true}?=>(otherlv_11='maxExclusive'
								{
									newLeafNode(otherlv_11, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0());
								}
								(
									(
										{
											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0());
										}
										lv_maxExclusive_12_0=ruleLiteralDateTime
										{
											if ($current==null) {
												$current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
											}
											set(
												$current,
												"maxExclusive",
												lv_maxExclusive_12_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
											afterParserOrEnumRuleCall();
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
				}
		)
		otherlv_13='restrictedRange'
		{
			newLeafNode(otherlv_13, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_15='}'
		{
			newLeafNode(otherlv_15, grammarAccess.getTimeScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleConceptualEntitySingletonInstance
entryRuleConceptualEntitySingletonInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConceptualEntitySingletonInstanceRule()); }
	iv_ruleConceptualEntitySingletonInstance=ruleConceptualEntitySingletonInstance
	{ $current=$iv_ruleConceptualEntitySingletonInstance.current; }
	EOF;

// Rule ConceptualEntitySingletonInstance
ruleConceptualEntitySingletonInstance returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getConceptualEntitySingletonInstanceAccess().getConceptInstanceParserRuleCall_0());
		}
		this_ConceptInstance_0=ruleConceptInstance
		{
			$current = $this_ConceptInstance_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getConceptualEntitySingletonInstanceAccess().getReifiedRelationshipInstanceParserRuleCall_1());
		}
		this_ReifiedRelationshipInstance_1=ruleReifiedRelationshipInstance
		{
			$current = $this_ReifiedRelationshipInstance_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleDescriptionBoxExtendsClosedWorldDefinitions
entryRuleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule()); }
	iv_ruleDescriptionBoxExtendsClosedWorldDefinitions=ruleDescriptionBoxExtendsClosedWorldDefinitions
	{ $current=$iv_ruleDescriptionBoxExtendsClosedWorldDefinitions.current; }
	EOF;

// Rule DescriptionBoxExtendsClosedWorldDefinitions
ruleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='extends'
		{
			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxCrossReference_2_0());
				}
				ruleExternalReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleDescriptionBoxRefinement
entryRuleDescriptionBoxRefinement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDescriptionBoxRefinementRule()); }
	iv_ruleDescriptionBoxRefinement=ruleDescriptionBoxRefinement
	{ $current=$iv_ruleDescriptionBoxRefinement.current; }
	EOF;

// Rule DescriptionBoxRefinement
ruleDescriptionBoxRefinement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDescriptionBoxRefinementRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='refines'
		{
			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDescriptionBoxRefinementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxCrossReference_2_0());
				}
				ruleExternalReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleSingletonInstanceScalarDataPropertyValue
entryRuleSingletonInstanceScalarDataPropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule()); }
	iv_ruleSingletonInstanceScalarDataPropertyValue=ruleSingletonInstanceScalarDataPropertyValue
	{ $current=$iv_ruleSingletonInstanceScalarDataPropertyValue.current; }
	EOF;

// Rule SingletonInstanceScalarDataPropertyValue
ruleSingletonInstanceScalarDataPropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='.'
		{
			newLeafNode(otherlv_2, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='='
		{
			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_5_0());
				}
				lv_scalarPropertyValue_5_0=ruleLiteralValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
					}
					set(
						$current,
						"scalarPropertyValue",
						lv_scalarPropertyValue_5_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6='^^'
			{
				newLeafNode(otherlv_6, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_6_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_6_1_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleSingletonInstanceStructuredDataPropertyValue
entryRuleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule()); }
	iv_ruleSingletonInstanceStructuredDataPropertyValue=ruleSingletonInstanceStructuredDataPropertyValue
	{ $current=$iv_ruleSingletonInstanceStructuredDataPropertyValue.current; }
	EOF;

// Rule SingletonInstanceStructuredDataPropertyValue
ruleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='.'
		{
			newLeafNode(otherlv_2, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='='
		{
			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_4());
		}
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0());
					}
					lv_structuredPropertyTuples_6_0=ruleStructuredDataPropertyTuple
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
						}
						add(
							$current,
							"structuredPropertyTuples",
							lv_structuredPropertyTuples_6_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0());
					}
					lv_scalarDataPropertyValues_7_0=ruleScalarDataPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
						}
						add(
							$current,
							"scalarDataPropertyValues",
							lv_scalarDataPropertyValues_7_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleStructuredDataPropertyTuple
entryRuleStructuredDataPropertyTuple returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructuredDataPropertyTupleRule()); }
	iv_ruleStructuredDataPropertyTuple=ruleStructuredDataPropertyTuple
	{ $current=$iv_ruleStructuredDataPropertyTuple.current; }
	EOF;

// Rule StructuredDataPropertyTuple
ruleStructuredDataPropertyTuple returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredDataPropertyTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2());
		}
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0());
					}
					lv_structuredPropertyTuples_4_0=ruleStructuredDataPropertyTuple
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
						}
						add(
							$current,
							"structuredPropertyTuples",
							lv_structuredPropertyTuples_4_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0());
					}
					lv_scalarDataPropertyValues_5_0=ruleScalarDataPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
						}
						add(
							$current,
							"scalarDataPropertyValues",
							lv_scalarDataPropertyValues_5_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleScalarDataPropertyValue
entryRuleScalarDataPropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScalarDataPropertyValueRule()); }
	iv_ruleScalarDataPropertyValue=ruleScalarDataPropertyValue
	{ $current=$iv_ruleScalarDataPropertyValue.current; }
	EOF;

// Rule ScalarDataPropertyValue
ruleScalarDataPropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScalarDataPropertyValueRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0());
				}
				lv_scalarPropertyValue_3_0=ruleLiteralValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScalarDataPropertyValueRule());
					}
					set(
						$current,
						"scalarPropertyValue",
						lv_scalarPropertyValue_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4='^^'
			{
				newLeafNode(otherlv_4, grammarAccess.getScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getScalarDataPropertyValueRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_4_1_0());
					}
					ruleReference
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleConceptInstance
entryRuleConceptInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConceptInstanceRule()); }
	iv_ruleConceptInstance=ruleConceptInstance
	{ $current=$iv_ruleConceptInstance.current; }
	EOF;

// Rule ConceptInstance
ruleConceptInstance returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getConceptInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConceptInstanceRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='conceptInstance'
		{
			newLeafNode(otherlv_1, grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_name_3_0=RULE_ID
				{
					newLeafNode(lv_name_3_0, grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptInstanceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_4='is-a'
		{
			newLeafNode(otherlv_4, grammarAccess.getConceptInstanceAccess().getIsAKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptInstanceRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=')'
		{
			newLeafNode(otherlv_6, grammarAccess.getConceptInstanceAccess().getRightParenthesisKeyword_6());
		}
	)
;

// Entry rule entryRuleReifiedRelationshipInstance
entryRuleReifiedRelationshipInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRule()); }
	iv_ruleReifiedRelationshipInstance=ruleReifiedRelationshipInstance
	{ $current=$iv_ruleReifiedRelationshipInstance.current; }
	EOF;

// Rule ReifiedRelationshipInstance
ruleReifiedRelationshipInstance returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReifiedRelationshipInstanceRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='reifiedRelationshipInstance'
		{
			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_name_3_0=RULE_ID
				{
					newLeafNode(lv_name_3_0, grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_4='is-a'
		{
			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=')'
		{
			newLeafNode(otherlv_6, grammarAccess.getReifiedRelationshipInstanceAccess().getRightParenthesisKeyword_6());
		}
	)
;

// Entry rule entryRuleReifiedRelationshipInstanceDomain
entryRuleReifiedRelationshipInstanceDomain returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainRule()); }
	iv_ruleReifiedRelationshipInstanceDomain=ruleReifiedRelationshipInstanceDomain
	{ $current=$iv_ruleReifiedRelationshipInstanceDomain.current; }
	EOF;

// Rule ReifiedRelationshipInstanceDomain
ruleReifiedRelationshipInstanceDomain returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReifiedRelationshipInstanceDomainRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='domain'
		{
			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_4());
		}
		otherlv_5='='
		{
			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleReifiedRelationshipInstanceRange
entryRuleReifiedRelationshipInstanceRange returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeRule()); }
	iv_ruleReifiedRelationshipInstanceRange=ruleReifiedRelationshipInstanceRange
	{ $current=$iv_ruleReifiedRelationshipInstanceRange.current; }
	EOF;

// Rule ReifiedRelationshipInstanceRange
ruleReifiedRelationshipInstanceRange returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReifiedRelationshipInstanceRangeRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='range'
		{
			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_4());
		}
		otherlv_5='='
		{
			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleUnreifiedRelationshipInstanceTuple
entryRuleUnreifiedRelationshipInstanceTuple returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleRule()); }
	iv_ruleUnreifiedRelationshipInstanceTuple=ruleUnreifiedRelationshipInstanceTuple
	{ $current=$iv_ruleUnreifiedRelationshipInstanceTuple.current; }
	EOF;

// Rule UnreifiedRelationshipInstanceTuple
ruleUnreifiedRelationshipInstanceTuple returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
				}
				lv_annotations_0_0=ruleAnnotationPropertyValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
					}
					add(
						$current,
						"annotations",
						lv_annotations_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='tuple'
		{
			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='unreifiedRelationship'
		{
			newLeafNode(otherlv_3, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='domain'
		{
			newLeafNode(otherlv_5, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='range'
		{
			newLeafNode(otherlv_7, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_7());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_8_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_9='}'
		{
			newLeafNode(otherlv_9, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRightCurlyBracketKeyword_9());
		}
	)
;

// Entry rule entryRuleReference
entryRuleReference returns [String current=null]:
	{ newCompositeNode(grammarAccess.getReferenceRule()); }
	iv_ruleReference=ruleReference
	{ $current=$iv_ruleReference.current.getText(); }
	EOF;

// Rule Reference
ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_IRI_0=RULE_IRI
		{
			$current.merge(this_IRI_0);
		}
		{
			newLeafNode(this_IRI_0, grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0());
		}
		    |
		{
			newCompositeNode(grammarAccess.getReferenceAccess().getQNAMEParserRuleCall_1());
		}
		this_QNAME_1=ruleQNAME
		{
			$current.merge(this_QNAME_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleExternalReference
entryRuleExternalReference returns [String current=null]:
	{ newCompositeNode(grammarAccess.getExternalReferenceRule()); }
	iv_ruleExternalReference=ruleExternalReference
	{ $current=$iv_ruleExternalReference.current.getText(); }
	EOF;

// Rule ExternalReference
ruleExternalReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_IRI_0=RULE_IRI
	{
		$current.merge(this_IRI_0);
	}
	{
		newLeafNode(this_IRI_0, grammarAccess.getExternalReferenceAccess().getIRITerminalRuleCall());
	}
;

// Entry rule entryRuleQNAME
entryRuleQNAME returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQNAMERule()); }
	iv_ruleQNAME=ruleQNAME
	{ $current=$iv_ruleQNAME.current.getText(); }
	EOF;

// Rule QNAME
ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ABBREV_IRI_0=RULE_ABBREV_IRI
		{
			$current.merge(this_ABBREV_IRI_0);
		}
		{
			newLeafNode(this_ABBREV_IRI_0, grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0());
		}
		    |
		{
			newCompositeNode(grammarAccess.getQNAMEAccess().getValidIDParserRuleCall_1());
		}
		this_ValidID_1=ruleValidID
		{
			$current.merge(this_ValidID_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleValidID
entryRuleValidID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getValidIDRule()); }
	iv_ruleValidID=ruleValidID
	{ $current=$iv_ruleValidID.current.getText(); }
	EOF;

// Rule ValidID
ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_ID_0=RULE_ID
	{
		$current.merge(this_ID_0);
	}
	{
		newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
	}
;

// Entry rule entryRuleLiteralValue
entryRuleLiteralValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralValueRule()); }
	iv_ruleLiteralValue=ruleLiteralValue
	{ $current=$iv_ruleLiteralValue.current; }
	EOF;

// Rule LiteralValue
ruleLiteralValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralBooleanParserRuleCall_0());
		}
		this_LiteralBoolean_0=ruleLiteralBoolean
		{
			$current = $this_LiteralBoolean_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralDateTimeParserRuleCall_1());
		}
		this_LiteralDateTime_1=ruleLiteralDateTime
		{
			$current = $this_LiteralDateTime_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralStringParserRuleCall_2());
		}
		this_LiteralString_2=ruleLiteralString
		{
			$current = $this_LiteralString_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralUUIDParserRuleCall_3());
		}
		this_LiteralUUID_3=ruleLiteralUUID
		{
			$current = $this_LiteralUUID_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralURIParserRuleCall_4());
		}
		this_LiteralURI_4=ruleLiteralURI
		{
			$current = $this_LiteralURI_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralNumberParserRuleCall_5());
		}
		this_LiteralNumber_5=ruleLiteralNumber
		{
			$current = $this_LiteralNumber_5.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralBoolean
entryRuleLiteralBoolean returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralBooleanRule()); }
	iv_ruleLiteralBoolean=ruleLiteralBoolean
	{ $current=$iv_ruleLiteralBoolean.current; }
	EOF;

// Rule LiteralBoolean
ruleLiteralBoolean returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralBooleanAccess().getLiteralBooleanAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_value_1_1=RULE_TRUE
					{
						newLeafNode(lv_value_1_1, grammarAccess.getLiteralBooleanAccess().getValueTRUETerminalRuleCall_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralBooleanRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_1_1,
							"gov.nasa.jpl.imce.oml.dsl.OML.TRUE");
					}
					    |
					lv_value_1_2=RULE_FALSE
					{
						newLeafNode(lv_value_1_2, grammarAccess.getLiteralBooleanAccess().getValueFALSETerminalRuleCall_1_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralBooleanRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_1_2,
							"gov.nasa.jpl.imce.oml.dsl.OML.FALSE");
					}
				)
			)
		)
	)
;

// Entry rule entryRuleLiteralDateTime
entryRuleLiteralDateTime returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralDateTimeRule()); }
	iv_ruleLiteralDateTime=ruleLiteralDateTime
	{ $current=$iv_ruleLiteralDateTime.current; }
	EOF;

// Rule LiteralDateTime
ruleLiteralDateTime returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralDateTimeAccess().getLiteralDateTimeAction_0(),
					$current);
			}
		)
		(
			(
				lv_dateTime_1_0=RULE_DATE_TIME
				{
					newLeafNode(lv_dateTime_1_0, grammarAccess.getLiteralDateTimeAccess().getDateTimeDATE_TIMETerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralDateTimeRule());
					}
					setWithLastConsumed(
						$current,
						"dateTime",
						lv_dateTime_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.DATE_TIME");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralString
entryRuleLiteralString returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralStringRule()); }
	iv_ruleLiteralString=ruleLiteralString
	{ $current=$iv_ruleLiteralString.current; }
	EOF;

// Rule LiteralString
ruleLiteralString returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getLiteralStringAccess().getLiteralQuotedStringParserRuleCall_0());
		}
		this_LiteralQuotedString_0=ruleLiteralQuotedString
		{
			$current = $this_LiteralQuotedString_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralStringAccess().getLiteralRawStringParserRuleCall_1());
		}
		this_LiteralRawString_1=ruleLiteralRawString
		{
			$current = $this_LiteralRawString_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralQuotedString
entryRuleLiteralQuotedString returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralQuotedStringRule()); }
	iv_ruleLiteralQuotedString=ruleLiteralQuotedString
	{ $current=$iv_ruleLiteralQuotedString.current; }
	EOF;

// Rule LiteralQuotedString
ruleLiteralQuotedString returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralQuotedStringAccess().getLiteralQuotedStringAction_0(),
					$current);
			}
		)
		(
			(
				lv_string_1_0=RULE_QUOTED_STRING_VALUE
				{
					newLeafNode(lv_string_1_0, grammarAccess.getLiteralQuotedStringAccess().getStringQUOTED_STRING_VALUETerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralQuotedStringRule());
					}
					setWithLastConsumed(
						$current,
						"string",
						lv_string_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.QUOTED_STRING_VALUE");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralRawString
entryRuleLiteralRawString returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralRawStringRule()); }
	iv_ruleLiteralRawString=ruleLiteralRawString
	{ $current=$iv_ruleLiteralRawString.current; }
	EOF;

// Rule LiteralRawString
ruleLiteralRawString returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralRawStringAccess().getLiteralRawStringAction_0(),
					$current);
			}
		)
		(
			(
				lv_string_1_0=RULE_RAW_STRING_VALUE
				{
					newLeafNode(lv_string_1_0, grammarAccess.getLiteralRawStringAccess().getStringRAW_STRING_VALUETerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralRawStringRule());
					}
					setWithLastConsumed(
						$current,
						"string",
						lv_string_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.RAW_STRING_VALUE");
				}
			)
		)
	)
;

// Entry rule entryRuleUUIDDataType
entryRuleUUIDDataType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getUUIDDataTypeRule()); }
	iv_ruleUUIDDataType=ruleUUIDDataType
	{ $current=$iv_ruleUUIDDataType.current.getText(); }
	EOF;

// Rule UUIDDataType
ruleUUIDDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_UUID_0=RULE_UUID
	{
		$current.merge(this_UUID_0);
	}
	{
		newLeafNode(this_UUID_0, grammarAccess.getUUIDDataTypeAccess().getUUIDTerminalRuleCall());
	}
;

// Entry rule entryRuleLiteralUUID
entryRuleLiteralUUID returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralUUIDRule()); }
	iv_ruleLiteralUUID=ruleLiteralUUID
	{ $current=$iv_ruleLiteralUUID.current; }
	EOF;

// Rule LiteralUUID
ruleLiteralUUID returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralUUIDAccess().getLiteralUUIDAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralUUIDAccess().getUuidUUIDDataTypeParserRuleCall_1_0());
				}
				lv_uuid_1_0=ruleUUIDDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralUUIDRule());
					}
					set(
						$current,
						"uuid",
						lv_uuid_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.UUIDDataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleURIDataType
entryRuleURIDataType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getURIDataTypeRule()); }
	iv_ruleURIDataType=ruleURIDataType
	{ $current=$iv_ruleURIDataType.current.getText(); }
	EOF;

// Rule URIDataType
ruleURIDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_URI_0=RULE_URI
	{
		$current.merge(this_URI_0);
	}
	{
		newLeafNode(this_URI_0, grammarAccess.getURIDataTypeAccess().getURITerminalRuleCall());
	}
;

// Entry rule entryRuleLiteralURI
entryRuleLiteralURI returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralURIRule()); }
	iv_ruleLiteralURI=ruleLiteralURI
	{ $current=$iv_ruleLiteralURI.current; }
	EOF;

// Rule LiteralURI
ruleLiteralURI returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralURIAccess().getLiteralURIAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralURIAccess().getUriURIDataTypeParserRuleCall_1_0());
				}
				lv_uri_1_0=ruleURIDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralURIRule());
					}
					set(
						$current,
						"uri",
						lv_uri_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.URIDataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralNumber
entryRuleLiteralNumber returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralNumberRule()); }
	iv_ruleLiteralNumber=ruleLiteralNumber
	{ $current=$iv_ruleLiteralNumber.current; }
	EOF;

// Rule LiteralNumber
ruleLiteralNumber returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getLiteralNumberAccess().getLiteralRealParserRuleCall_0());
		}
		this_LiteralReal_0=ruleLiteralReal
		{
			$current = $this_LiteralReal_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralNumberAccess().getLiteralRationalParserRuleCall_1());
		}
		this_LiteralRational_1=ruleLiteralRational
		{
			$current = $this_LiteralRational_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralNumberAccess().getLiteralFloatParserRuleCall_2());
		}
		this_LiteralFloat_2=ruleLiteralFloat
		{
			$current = $this_LiteralFloat_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralNumberAccess().getLiteralDecimalParserRuleCall_3());
		}
		this_LiteralDecimal_3=ruleLiteralDecimal
		{
			$current = $this_LiteralDecimal_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralReal
entryRuleLiteralReal returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralRealRule()); }
	iv_ruleLiteralReal=ruleLiteralReal
	{ $current=$iv_ruleLiteralReal.current; }
	EOF;

// Rule LiteralReal
ruleLiteralReal returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralRealAccess().getLiteralRealAction_0(),
					$current);
			}
		)
		(
			(
				lv_real_1_0=RULE_REAL
				{
					newLeafNode(lv_real_1_0, grammarAccess.getLiteralRealAccess().getRealREALTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralRealRule());
					}
					setWithLastConsumed(
						$current,
						"real",
						lv_real_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.REAL");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralRational
entryRuleLiteralRational returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralRationalRule()); }
	iv_ruleLiteralRational=ruleLiteralRational
	{ $current=$iv_ruleLiteralRational.current; }
	EOF;

// Rule LiteralRational
ruleLiteralRational returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralRationalAccess().getLiteralRationalAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLiteralRationalAccess().getRationalRationalDataTypeParserRuleCall_1_0());
				}
				lv_rational_1_0=ruleRationalDataType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLiteralRationalRule());
					}
					set(
						$current,
						"rational",
						lv_rational_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.RationalDataType");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleRationalDataType
entryRuleRationalDataType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getRationalDataTypeRule()); }
	iv_ruleRationalDataType=ruleRationalDataType
	{ $current=$iv_ruleRationalDataType.current.getText(); }
	EOF;

// Rule RationalDataType
ruleRationalDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_RATIONAL_0=RULE_RATIONAL
	{
		$current.merge(this_RATIONAL_0);
	}
	{
		newLeafNode(this_RATIONAL_0, grammarAccess.getRationalDataTypeAccess().getRATIONALTerminalRuleCall());
	}
;

// Entry rule entryRuleLiteralFloat
entryRuleLiteralFloat returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralFloatRule()); }
	iv_ruleLiteralFloat=ruleLiteralFloat
	{ $current=$iv_ruleLiteralFloat.current; }
	EOF;

// Rule LiteralFloat
ruleLiteralFloat returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getLiteralFloatAccess().getLiteralFloatAction_0(),
					$current);
			}
		)
		(
			(
				lv_float_1_0=RULE_FLOAT
				{
					newLeafNode(lv_float_1_0, grammarAccess.getLiteralFloatAccess().getFloatFLOATTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralFloatRule());
					}
					setWithLastConsumed(
						$current,
						"float",
						lv_float_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.FLOAT");
				}
			)
		)
	)
;

// Entry rule entryRuleLiteralDecimal
entryRuleLiteralDecimal returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralDecimalRule()); }
	iv_ruleLiteralDecimal=ruleLiteralDecimal
	{ $current=$iv_ruleLiteralDecimal.current; }
	EOF;

// Rule LiteralDecimal
ruleLiteralDecimal returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getLiteralDecimalAccess().getLiteralDecimalAction_0_0(),
						$current);
				}
			)
			(
				(
					lv_decimal_1_0=RULE_DIGITS
					{
						newLeafNode(lv_decimal_1_0, grammarAccess.getLiteralDecimalAccess().getDecimalDIGITSTerminalRuleCall_0_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getLiteralDecimalRule());
						}
						setWithLastConsumed(
							$current,
							"decimal",
							lv_decimal_1_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
					}
				)
			)
		)
		    |
		(
			(
				lv_decimal_2_0=RULE_DECIMAL
				{
					newLeafNode(lv_decimal_2_0, grammarAccess.getLiteralDecimalAccess().getDecimalDECIMALTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLiteralDecimalRule());
					}
					setWithLastConsumed(
						$current,
						"decimal",
						lv_decimal_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.DECIMAL");
				}
			)
		)
	)
;

// Entry rule entryRulePositiveIntegerLiteral
entryRulePositiveIntegerLiteral returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPositiveIntegerLiteralRule()); }
	iv_rulePositiveIntegerLiteral=rulePositiveIntegerLiteral
	{ $current=$iv_rulePositiveIntegerLiteral.current.getText(); }
	EOF;

// Rule PositiveIntegerLiteral
rulePositiveIntegerLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_DIGITS_0=RULE_DIGITS
	{
		$current.merge(this_DIGITS_0);
	}
	{
		newLeafNode(this_DIGITS_0, grammarAccess.getPositiveIntegerLiteralAccess().getDIGITSTerminalRuleCall());
	}
;

// Rule TerminologyKind
ruleTerminologyKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='open'
			{
				$current = grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='closed'
			{
				$current = grammarAccess.getTerminologyKindAccess().getClosedWorldDesignationsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getTerminologyKindAccess().getClosedWorldDesignationsEnumLiteralDeclaration_1());
			}
		)
	)
;

// Rule DescriptionKind
ruleDescriptionKind returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='final'
			{
				$current = grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='partial'
			{
				$current = grammarAccess.getDescriptionKindAccess().getPartialEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getDescriptionKindAccess().getPartialEnumLiteralDeclaration_1());
			}
		)
	)
;

RULE_RATIONAL : '-'? RULE_DIGIT+ '/' RULE_DIGIT+;

RULE_FALSE : 'false';

RULE_TRUE : 'true';

fragment RULE_DIGIT : '0'..'9';

fragment RULE_DIGIT19 : '1'..'9';

fragment RULE_DIGIT02 : '0'..'2';

fragment RULE_DIGIT03 : '0'..'3';

fragment RULE_DIGIT05 : '0'..'5';

fragment RULE_YEAR_FRAG : '-'? (RULE_DIGIT19 RULE_DIGIT RULE_DIGIT RULE_DIGIT+|'0' RULE_DIGIT RULE_DIGIT RULE_DIGIT);

fragment RULE_MONTH_FRAG : ('0' RULE_DIGIT19|'1' RULE_DIGIT02);

fragment RULE_DAY_FRAG : ('0' RULE_DIGIT19|('1'|'2') RULE_DIGIT|'3' ('0'|'1'));

fragment RULE_HOUR_FRAG : (('0'|'1') RULE_DIGIT|'2' RULE_DIGIT03);

fragment RULE_MINUTE_FRAG : RULE_DIGIT05 RULE_DIGIT;

fragment RULE_SECOND_FRAG : RULE_DIGIT05 RULE_DIGIT ('.' RULE_DIGIT+)?;

fragment RULE_END_OF_DAY_FRAG : '24:00:00' ('.' RULE_DIGIT+)?;

fragment RULE_TIMEZONE_FRAG : ('Z'|('+'|'-') (('0' RULE_DIGIT|'1' RULE_DIGIT03) ':' RULE_MINUTE_FRAG|'14:00'));

fragment RULE_ALPHA : ('a'..'z'|'A'..'Z');

fragment RULE_SCHEME : RULE_ALPHA (RULE_ALPHA|RULE_DIGIT|'+'|'-'|'.')*;

fragment RULE_PCT_ENCODED : '%' RULE_HEX_DIGIT RULE_HEX_DIGIT;

fragment RULE_UNRESERVED : (RULE_ALPHA|RULE_DIGIT|'-'|'.'|'_'|'~');

fragment RULE_DIGIT04 : '0'..'4';

fragment RULE_DEC_OCTET : (RULE_DIGIT|'1' RULE_DIGIT|'2' RULE_DIGIT04 RULE_DIGIT|'25' RULE_DIGIT05);

fragment RULE_IPV4_ADDRESS : RULE_DEC_OCTET '.' RULE_DEC_OCTET '.' RULE_DEC_OCTET '.' RULE_DEC_OCTET;

fragment RULE_IUSER_PART : (RULE_UNRESERVED|RULE_PCT_ENCODED)+;

fragment RULE_IUSER_INFO : RULE_IUSER_PART (':' RULE_IUSER_PART)*;

fragment RULE_IUNRESERVED_PART : (RULE_ALPHA|RULE_DIGIT|'-'|'_'|'~');

fragment RULE_IUNRESERVED : RULE_ALPHA RULE_IUNRESERVED_PART? ('.' RULE_IUNRESERVED_PART)*;

fragment RULE_IHOST : (RULE_IPV4_ADDRESS|RULE_IUNRESERVED);

fragment RULE_PORT : RULE_DIGIT+;

fragment RULE_IAUTHORITY : (RULE_IUSER_INFO '@')? RULE_IHOST (':' RULE_PORT)?;

fragment RULE_IPCHAR : (RULE_IUNRESERVED_PART|RULE_PCT_ENCODED);

fragment RULE_ISEGMENT : RULE_IPCHAR+;

fragment RULE_IPATH : RULE_ISEGMENT ('/' RULE_ISEGMENT)*;

fragment RULE_IHIER_PART : '//' RULE_IAUTHORITY RULE_IPATH?;

fragment RULE_IFRAGMENT : RULE_ISEGMENT;

RULE_URI : RULE_SCHEME ':' RULE_IHIER_PART ('#' RULE_IFRAGMENT)?;

fragment RULE_CONSTANT_NAME : RULE_ALPHA (RULE_ALPHA|RULE_DIGIT)*;

RULE_REAL : '{' ('-'|'+')? RULE_CONSTANT_NAME '}';

RULE_PATTERN : '/' (~('/')|'\\/')* '/';

RULE_QUOTED_STRING_VALUE : '"' ('\\' . ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

RULE_RAW_STRING_VALUE : '"""' ( options {greedy=false;} : . )*'"""';

RULE_IRI : '<' ~('>')* '>';

fragment RULE_LETTER : ('a'..'z'|'A'..'Z');

fragment RULE_LETTER_DIGIT : (RULE_LETTER|RULE_DIGIT);

fragment RULE_LETTER_DIGIT_PREFIX : (RULE_LETTER_DIGIT|'_');

fragment RULE_LETTER_DIGIT_SUFFIX : (RULE_LETTER_DIGIT|'_'|'-'|'.');

RULE_ABBREV_IRI : RULE_LETTER_DIGIT_PREFIX RULE_LETTER_DIGIT_SUFFIX* ':' RULE_LETTER_DIGIT_PREFIX RULE_LETTER_DIGIT_SUFFIX*;

fragment RULE_ID_PREFIX : (RULE_LETTER|'_');

RULE_ID : '^'? RULE_ID_PREFIX RULE_LETTER_DIGIT_SUFFIX*;

RULE_LANG_TAG : 'lang=' RULE_LETTER+ ('-' RULE_LETTER_DIGIT+)*;

RULE_DATE_TIME : 'dateTime=' RULE_YEAR_FRAG '-' RULE_MONTH_FRAG '-' RULE_DAY_FRAG 'T' (RULE_HOUR_FRAG ':' RULE_MINUTE_FRAG ':' RULE_SECOND_FRAG|RULE_END_OF_DAY_FRAG) RULE_TIMEZONE_FRAG?;

RULE_UUID : 'uuid=' RULE_HEX_8DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_12DIGITS;

fragment RULE_HEX_12DIGITS : RULE_HEX_8DIGITS RULE_HEX_4DIGITS;

fragment RULE_HEX_8DIGITS : RULE_HEX_4DIGITS RULE_HEX_4DIGITS;

fragment RULE_HEX_4DIGITS : RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT;

fragment RULE_HEX_LETTER : ('a'..'f'|'A'..'F');

fragment RULE_HEX_DIGIT : (RULE_DIGIT|RULE_HEX_LETTER);

fragment RULE_HEX : ('0x'|'0X') (RULE_HEX_DIGIT|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_DIGITS : RULE_DIGIT+;

fragment RULE_DEC : '-'? RULE_DIGIT+ (('e'|'E') ('+'|'-')? RULE_DIGIT+)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_DECIMAL : (RULE_DEC|RULE_HEX);

RULE_FLOAT : '-'? RULE_DIGIT+ '.' RULE_DIGIT+ (('e'|'E') ('+'|'-')? RULE_DIGIT+)?;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;
