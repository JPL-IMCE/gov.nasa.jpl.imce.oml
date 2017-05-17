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

// Entry rule entryRuleAnnotation
entryRuleAnnotation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnotationRule()); }
	iv_ruleAnnotation=ruleAnnotation
	{ $current=$iv_ruleAnnotation.current; }
	EOF;

// Rule Annotation
ruleAnnotation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='@'
		{
			newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationRule());
					}
				}
				otherlv_1=RULE_ABBREV_IRI
				{
					newLeafNode(otherlv_1, grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyCrossReference_1_0());
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getEqualsSignKeyword_2());
		}
		(
			(
				lv_value_3_0=RULE_STRING
				{
					newLeafNode(lv_value_3_0, grammarAccess.getAnnotationAccess().getValueSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnnotationRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
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
					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_0_0());
				}
				lv_kind_0_0=ruleTerminologyKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
					}
					set(
						$current,
						"kind",
						lv_kind_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='terminology'
		{
			newLeafNode(otherlv_1, grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_1());
		}
		(
			(
				lv_iri_2_0=RULE_IRI
				{
					newLeafNode(lv_iri_2_0, grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTerminologyGraphRule());
					}
					setWithLastConsumed(
						$current,
						"iri",
						lv_iri_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_4_0_0());
					}
					lv_annotations_4_0=ruleAnnotation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
						}
						add(
							$current,
							"annotations",
							lv_annotations_4_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_4_1_0());
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
						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_4_2_0());
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
			newLeafNode(otherlv_7, grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_5());
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
					newCompositeNode(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_0_0());
				}
				lv_kind_0_0=ruleTerminologyKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBundleRule());
					}
					set(
						$current,
						"kind",
						lv_kind_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='bundle'
		{
			newLeafNode(otherlv_1, grammarAccess.getBundleAccess().getBundleKeyword_1());
		}
		(
			(
				lv_iri_2_0=RULE_IRI
				{
					newLeafNode(lv_iri_2_0, grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBundleRule());
					}
					setWithLastConsumed(
						$current,
						"iri",
						lv_iri_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_4_0_0());
					}
					lv_annotations_4_0=ruleAnnotation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBundleRule());
						}
						add(
							$current,
							"annotations",
							lv_annotations_4_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_4_1_0());
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
						newCompositeNode(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_4_2_0());
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
						newCompositeNode(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_4_3_0());
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
						newCompositeNode(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_4_4_0());
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
			newLeafNode(otherlv_9, grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_5());
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
		otherlv_0='bundles'
		{
			newLeafNode(otherlv_0, grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBundledTerminologyAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_1_0());
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
		otherlv_0='conceptDesignationTerminologyAxiom'
		{
			newLeafNode(otherlv_0, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_0());
		}
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_1());
		}
		otherlv_2='designatedTerminology'
		{
			newLeafNode(otherlv_2, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_3_0());
				}
				ruleExternalReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='designatedConcept'
		{
			newLeafNode(otherlv_4, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRightCurlyBracketKeyword_6());
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
		otherlv_0='extends'
		{
			newLeafNode(otherlv_0, grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTerminologyExtensionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_1_0());
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
		otherlv_0='terminologyNestingAxiom'
		{
			newLeafNode(otherlv_0, grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_0());
		}
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_1());
		}
		otherlv_2='nestingTerminology'
		{
			newLeafNode(otherlv_2, grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_3_0());
				}
				ruleExternalReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='nestingContext'
		{
			newLeafNode(otherlv_4, grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getTerminologyNestingAxiomAccess().getRightCurlyBracketKeyword_6());
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
			newCompositeNode(grammarAccess.getTermAxiomAccess().getScalarOneOfLiteralAxiomParserRuleCall_2());
		}
		this_ScalarOneOfLiteralAxiom_2=ruleScalarOneOfLiteralAxiom
		{
			$current = $this_ScalarOneOfLiteralAxiom_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTermAxiomAccess().getSpecializationAxiomParserRuleCall_3());
		}
		this_SpecializationAxiom_3=ruleSpecializationAxiom
		{
			$current = $this_SpecializationAxiom_3.current;
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
		otherlv_0='aspect'
		{
			newLeafNode(otherlv_0, grammarAccess.getAspectAccess().getAspectKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAspectRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
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
		otherlv_0='concept'
		{
			newLeafNode(otherlv_0, grammarAccess.getConceptAccess().getConceptKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
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
		otherlv_0='reifiedRelationship'
		{
			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>((
									lv_isFunctional_4_0='functional'
									{
										newLeafNode(lv_isFunctional_4_0, grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>((
									lv_isInverseFunctional_5_0='inverseFunctional'
									{
										newLeafNode(lv_isInverseFunctional_5_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>((
									lv_isEssential_6_0='essential'
									{
										newLeafNode(lv_isEssential_6_0, grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3);
					}
								({true}?=>((
									lv_isInverseEssential_7_0='inverseEssential'
									{
										newLeafNode(lv_isInverseEssential_7_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4);
					}
								({true}?=>((
									lv_isSymmetric_8_0='symmetric'
									{
										newLeafNode(lv_isSymmetric_8_0, grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5);
					}
								({true}?=>((
									lv_isAsymmetric_9_0='asymmetric'
									{
										newLeafNode(lv_isAsymmetric_9_0, grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6);
					}
								({true}?=>((
									lv_isReflexive_10_0='reflexive'
									{
										newLeafNode(lv_isReflexive_10_0, grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7);
					}
								({true}?=>((
									lv_isIrreflexive_11_0='irreflexive'
									{
										newLeafNode(lv_isIrreflexive_11_0, grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8);
					}
								({true}?=>((
									lv_isTransitive_12_0='transitive'
									{
										newLeafNode(lv_isTransitive_12_0, grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
				}
		)
		otherlv_13='unreified'
		{
			newLeafNode(otherlv_13, grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_4());
		}
		otherlv_14='='
		{
			newLeafNode(otherlv_14, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_5());
		}
		(
			(
				lv_unreifiedPropertyName_15_0=RULE_ID
				{
					newLeafNode(lv_unreifiedPropertyName_15_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameIDTerminalRuleCall_6_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
					}
					setWithLastConsumed(
						$current,
						"unreifiedPropertyName",
						lv_unreifiedPropertyName_15_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		(
			otherlv_16='inverse'
			{
				newLeafNode(otherlv_16, grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_7_0());
			}
			otherlv_17='='
			{
				newLeafNode(otherlv_17, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_7_1());
			}
			(
				(
					lv_unreifiedInversePropertyName_18_0=RULE_ID
					{
						newLeafNode(lv_unreifiedInversePropertyName_18_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameIDTerminalRuleCall_7_2_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
						}
						setWithLastConsumed(
							$current,
							"unreifiedInversePropertyName",
							lv_unreifiedInversePropertyName_18_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ID");
					}
				)
			)
		)?
		otherlv_19='source'
		{
			newLeafNode(otherlv_19, grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_8());
		}
		otherlv_20='='
		{
			newLeafNode(otherlv_20, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_9());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_10_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_22='target'
		{
			newLeafNode(otherlv_22, grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_11());
		}
		otherlv_23='='
		{
			newLeafNode(otherlv_23, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_12());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_13_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_25='}'
		{
			newLeafNode(otherlv_25, grammarAccess.getReifiedRelationshipAccess().getRightCurlyBracketKeyword_14());
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
		otherlv_0='unreifiedRelationship'
		{
			newLeafNode(otherlv_0, grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>((
									lv_isFunctional_4_0='functional'
									{
										newLeafNode(lv_isFunctional_4_0, grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>((
									lv_isInverseFunctional_5_0='inverseFunctional'
									{
										newLeafNode(lv_isInverseFunctional_5_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>((
									lv_isEssential_6_0='essential'
									{
										newLeafNode(lv_isEssential_6_0, grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3);
					}
								({true}?=>((
									lv_isInverseEssential_7_0='inverseEssential'
									{
										newLeafNode(lv_isInverseEssential_7_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4);
					}
								({true}?=>((
									lv_isSymmetric_8_0='symmetric'
									{
										newLeafNode(lv_isSymmetric_8_0, grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5);
					}
								({true}?=>((
									lv_isAsymmetric_9_0='asymmetric'
									{
										newLeafNode(lv_isAsymmetric_9_0, grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6);
					}
								({true}?=>((
									lv_isReflexive_10_0='reflexive'
									{
										newLeafNode(lv_isReflexive_10_0, grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7);
					}
								({true}?=>((
									lv_isIrreflexive_11_0='irreflexive'
									{
										newLeafNode(lv_isIrreflexive_11_0, grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8);
					}
								({true}?=>((
									lv_isTransitive_12_0='transitive'
									{
										newLeafNode(lv_isTransitive_12_0, grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0());
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
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
				}
		)
		otherlv_13='source'
		{
			newLeafNode(otherlv_13, grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_4());
		}
		otherlv_14='='
		{
			newLeafNode(otherlv_14, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_16='target'
		{
			newLeafNode(otherlv_16, grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_7());
		}
		otherlv_17='='
		{
			newLeafNode(otherlv_17, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_8());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_9_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_19='}'
		{
			newLeafNode(otherlv_19, grammarAccess.getUnreifiedRelationshipAccess().getRightCurlyBracketKeyword_10());
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
		otherlv_0='scalar'
		{
			newLeafNode(otherlv_0, grammarAccess.getScalarAccess().getScalarKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
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
		otherlv_0='structure'
		{
			newLeafNode(otherlv_0, grammarAccess.getStructureAccess().getStructureKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructureRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
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
		otherlv_0='entityStructuredDataProperty'
		{
			newLeafNode(otherlv_0, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_0());
		}
		(
			(
				lv_isIdentityCriteria_1_0='+'
				{
					newLeafNode(lv_isIdentityCriteria_1_0, grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0());
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
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
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
			newLeafNode(otherlv_3, grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3());
		}
		otherlv_4='domain'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='range'
		{
			newLeafNode(otherlv_6, grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_6());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getEntityStructuredDataPropertyAccess().getRightCurlyBracketKeyword_8());
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
		otherlv_0='entityScalarDataProperty'
		{
			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_0());
		}
		(
			(
				lv_isIdentityCriteria_1_0='+'
				{
					newLeafNode(lv_isIdentityCriteria_1_0, grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0());
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
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
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
			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
		}
		otherlv_4='domain'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='range'
		{
			newLeafNode(otherlv_6, grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_6());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getEntityScalarDataPropertyAccess().getRightCurlyBracketKeyword_8());
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
		otherlv_0='structuredDataProperty'
		{
			newLeafNode(otherlv_0, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='domain'
		{
			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='range'
		{
			newLeafNode(otherlv_5, grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getStructuredDataPropertyAccess().getRightCurlyBracketKeyword_7());
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
		otherlv_0='scalarDataProperty'
		{
			newLeafNode(otherlv_0, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarDataPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='domain'
		{
			newLeafNode(otherlv_3, grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='range'
		{
			newLeafNode(otherlv_5, grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarDataPropertyRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_6_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_7());
		}
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
		otherlv_0='anonymousConceptUnion'
		{
			newLeafNode(otherlv_0, grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAnonymousConceptUnionAxiomRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_3());
		}
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0());
				}
				lv_disjunctions_5_0=ruleDisjointUnionOfConceptsAxiom
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAnonymousConceptUnionAxiomRule());
					}
					add(
						$current,
						"disjunctions",
						lv_disjunctions_5_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightCurlyBracketKeyword_6());
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
		otherlv_0='rootConceptTaxonomy'
		{
			newLeafNode(otherlv_0, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRootConceptTaxonomyAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_3());
		}
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0());
				}
				lv_disjunctions_5_0=ruleDisjointUnionOfConceptsAxiom
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRootConceptTaxonomyAxiomRule());
					}
					add(
						$current,
						"disjunctions",
						lv_disjunctions_5_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightCurlyBracketKeyword_6());
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
		otherlv_0='disjointLeaf'
		{
			newLeafNode(otherlv_0, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getSpecificDisjointConceptAxiomAccess().getRightParenthesisKeyword_3());
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
		otherlv_0='someEntities'
		{
			newLeafNode(otherlv_0, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='.'
		{
			newLeafNode(otherlv_2, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='in'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0());
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
		otherlv_0='allEntities'
		{
			newLeafNode(otherlv_0, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='.'
		{
			newLeafNode(otherlv_2, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='in'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0());
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
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_0_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='extendsAspect'
		{
			newLeafNode(otherlv_1, grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_2_0());
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
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_0_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='extendsConcept'
		{
			newLeafNode(otherlv_1, grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_2_0());
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
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_0_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='extendsRelationship'
		{
			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipCrossReference_2_0());
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
		otherlv_0='someData'
		{
			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='.'
		{
			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='in'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_5_0());
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
		otherlv_0='allData'
		{
			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAllDataKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=','
		{
			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getCommaKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='='
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_4());
		}
		(
			(
				lv_literalValue_5_0=RULE_STRING
				{
					newLeafNode(lv_literalValue_5_0, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueSTRINGTerminalRuleCall_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
					}
					setWithLastConsumed(
						$current,
						"literalValue",
						lv_literalValue_5_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
				}
			)
		)
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
		otherlv_0='allData'
		{
			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='.'
		{
			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='in'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
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
		otherlv_0='binaryScalarRestriction'
		{
			newLeafNode(otherlv_0, grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_4='length'
								{
									newLeafNode(otherlv_4, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_3_0_0());
								}
								(
									(
										lv_length_5_0=RULE_INT
										{
											newLeafNode(lv_length_5_0, grammarAccess.getBinaryScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"length",
												lv_length_5_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>(otherlv_6='minLength'
								{
									newLeafNode(otherlv_6, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
								}
								(
									(
										lv_minLength_7_0=RULE_INT
										{
											newLeafNode(lv_minLength_7_0, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"minLength",
												lv_minLength_7_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>(otherlv_8='maxLength'
								{
									newLeafNode(otherlv_8, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
								}
								(
									(
										lv_maxLength_9_0=RULE_INT
										{
											newLeafNode(lv_maxLength_9_0, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"maxLength",
												lv_maxLength_9_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
				}
		)
		otherlv_10='restrictedRange'
		{
			newLeafNode(otherlv_10, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_12='}'
		{
			newLeafNode(otherlv_12, grammarAccess.getBinaryScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
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
		otherlv_0='iriScalarRestriction'
		{
			newLeafNode(otherlv_0, grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_4='length'
								{
									newLeafNode(otherlv_4, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_3_0_0());
								}
								(
									(
										lv_length_5_0=RULE_INT
										{
											newLeafNode(lv_length_5_0, grammarAccess.getIRIScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"length",
												lv_length_5_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>(otherlv_6='minLength'
								{
									newLeafNode(otherlv_6, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
								}
								(
									(
										lv_minLength_7_0=RULE_INT
										{
											newLeafNode(lv_minLength_7_0, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"minLength",
												lv_minLength_7_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>(otherlv_8='maxLength'
								{
									newLeafNode(otherlv_8, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
								}
								(
									(
										lv_maxLength_9_0=RULE_INT
										{
											newLeafNode(lv_maxLength_9_0, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"maxLength",
												lv_maxLength_9_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3);
					}
								({true}?=>(otherlv_10='pattern'
								{
									newLeafNode(otherlv_10, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_3_3_0());
								}
								(
									(
										lv_pattern_11_0=RULE_STRING
										{
											newLeafNode(lv_pattern_11_0, grammarAccess.getIRIScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"pattern",
												lv_pattern_11_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
				}
		)
		otherlv_12='restrictedRange'
		{
			newLeafNode(otherlv_12, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_14='}'
		{
			newLeafNode(otherlv_14, grammarAccess.getIRIScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
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
		otherlv_0='numericScalarRestriction'
		{
			newLeafNode(otherlv_0, grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_4='minInclusive'
								{
									newLeafNode(otherlv_4, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0());
								}
								(
									(
										lv_minInclusive_5_0=RULE_STRING
										{
											newLeafNode(lv_minInclusive_5_0, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"minInclusive",
												lv_minInclusive_5_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>(otherlv_6='maxInclusive'
								{
									newLeafNode(otherlv_6, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0());
								}
								(
									(
										lv_maxInclusive_7_0=RULE_STRING
										{
											newLeafNode(lv_maxInclusive_7_0, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"maxInclusive",
												lv_maxInclusive_7_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>(otherlv_8='minExclusive'
								{
									newLeafNode(otherlv_8, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0());
								}
								(
									(
										lv_minExclusive_9_0=RULE_STRING
										{
											newLeafNode(lv_minExclusive_9_0, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"minExclusive",
												lv_minExclusive_9_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3);
					}
								({true}?=>(otherlv_10='maxExclusive'
								{
									newLeafNode(otherlv_10, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0());
								}
								(
									(
										lv_maxExclusive_11_0=RULE_STRING
										{
											newLeafNode(lv_maxExclusive_11_0, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"maxExclusive",
												lv_maxExclusive_11_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
				}
		)
		otherlv_12='restrictedRange'
		{
			newLeafNode(otherlv_12, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_14='}'
		{
			newLeafNode(otherlv_14, grammarAccess.getNumericScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
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
		otherlv_0='plainLiteralScalarRestriction'
		{
			newLeafNode(otherlv_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_4='length'
								{
									newLeafNode(otherlv_4, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_3_0_0());
								}
								(
									(
										lv_length_5_0=RULE_INT
										{
											newLeafNode(lv_length_5_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"length",
												lv_length_5_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>(otherlv_6='minLength'
								{
									newLeafNode(otherlv_6, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
								}
								(
									(
										lv_minLength_7_0=RULE_INT
										{
											newLeafNode(lv_minLength_7_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"minLength",
												lv_minLength_7_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>(otherlv_8='maxLength'
								{
									newLeafNode(otherlv_8, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
								}
								(
									(
										lv_maxLength_9_0=RULE_INT
										{
											newLeafNode(lv_maxLength_9_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"maxLength",
												lv_maxLength_9_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3);
					}
								({true}?=>(otherlv_10='pattern'
								{
									newLeafNode(otherlv_10, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_3_3_0());
								}
								(
									(
										lv_pattern_11_0=RULE_STRING
										{
											newLeafNode(lv_pattern_11_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"pattern",
												lv_pattern_11_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4);
					}
								({true}?=>(otherlv_12='langRange'
								{
									newLeafNode(otherlv_12, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_3_4_0());
								}
								(
									(
										lv_langRange_13_0=RULE_STRING
										{
											newLeafNode(lv_langRange_13_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeSTRINGTerminalRuleCall_3_4_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"langRange",
												lv_langRange_13_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
				}
		)
		otherlv_14='restrictedRange'
		{
			newLeafNode(otherlv_14, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_16='}'
		{
			newLeafNode(otherlv_16, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
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
		otherlv_0='scalarOneOfRestriction'
		{
			newLeafNode(otherlv_0, grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='restrictedRange'
		{
			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getScalarOneOfRestrictionAccess().getRightCurlyBracketKeyword_5());
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
		otherlv_0='oneOf'
		{
			newLeafNode(otherlv_0, grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_1_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_2());
		}
		(
			(
				lv_value_3_0=RULE_STRING
				{
					newLeafNode(lv_value_3_0, grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_3_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
				}
			)
		)
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
		otherlv_0='stringScalarRestriction'
		{
			newLeafNode(otherlv_0, grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_4='length'
								{
									newLeafNode(otherlv_4, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_3_0_0());
								}
								(
									(
										lv_length_5_0=RULE_INT
										{
											newLeafNode(lv_length_5_0, grammarAccess.getStringScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"length",
												lv_length_5_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>(otherlv_6='minLength'
								{
									newLeafNode(otherlv_6, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
								}
								(
									(
										lv_minLength_7_0=RULE_INT
										{
											newLeafNode(lv_minLength_7_0, grammarAccess.getStringScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"minLength",
												lv_minLength_7_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>(otherlv_8='maxLength'
								{
									newLeafNode(otherlv_8, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
								}
								(
									(
										lv_maxLength_9_0=RULE_INT
										{
											newLeafNode(lv_maxLength_9_0, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"maxLength",
												lv_maxLength_9_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3);
					}
								({true}?=>(otherlv_10='pattern'
								{
									newLeafNode(otherlv_10, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_3_3_0());
								}
								(
									(
										lv_pattern_11_0=RULE_STRING
										{
											newLeafNode(lv_pattern_11_0, grammarAccess.getStringScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"pattern",
												lv_pattern_11_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
				}
		)
		otherlv_12='restrictedRange'
		{
			newLeafNode(otherlv_12, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_14='}'
		{
			newLeafNode(otherlv_14, grammarAccess.getStringScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
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
		otherlv_0='synonymScalarRestriction'
		{
			newLeafNode(otherlv_0, grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='restrictedRange'
		{
			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getSynonymScalarRestrictionAccess().getRightCurlyBracketKeyword_5());
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
		otherlv_0='timeScalarRestriction'
		{
			newLeafNode(otherlv_0, grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{ 
				  getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
				}
				(
					(
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0);
					}
								({true}?=>(otherlv_4='minInclusive'
								{
									newLeafNode(otherlv_4, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0());
								}
								(
									(
										lv_minInclusive_5_0=RULE_STRING
										{
											newLeafNode(lv_minInclusive_5_0, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"minInclusive",
												lv_minInclusive_5_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1);
					}
								({true}?=>(otherlv_6='maxInclusive'
								{
									newLeafNode(otherlv_6, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0());
								}
								(
									(
										lv_maxInclusive_7_0=RULE_STRING
										{
											newLeafNode(lv_maxInclusive_7_0, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"maxInclusive",
												lv_maxInclusive_7_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2);
					}
								({true}?=>(otherlv_8='minExclusive'
								{
									newLeafNode(otherlv_8, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0());
								}
								(
									(
										lv_minExclusive_9_0=RULE_STRING
										{
											newLeafNode(lv_minExclusive_9_0, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"minExclusive",
												lv_minExclusive_9_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)|
			(
				{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
					{
						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3);
					}
								({true}?=>(otherlv_10='maxExclusive'
								{
									newLeafNode(otherlv_10, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0());
								}
								(
									(
										lv_maxExclusive_11_0=RULE_STRING
										{
											newLeafNode(lv_maxExclusive_11_0, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0());
										}
										{
											if ($current==null) {
												$current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
											}
											setWithLastConsumed(
												$current,
												"maxExclusive",
												lv_maxExclusive_11_0,
												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
										}
									)
								)
								))
					{ 
						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
					}
				)
			)
					)*
				)
			)
				{ 
				  getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
				}
		)
		otherlv_12='restrictedRange'
		{
			newLeafNode(otherlv_12, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_14='}'
		{
			newLeafNode(otherlv_14, grammarAccess.getTimeScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
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
					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_0_0());
				}
				lv_kind_0_0=ruleDescriptionKind
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
					}
					set(
						$current,
						"kind",
						lv_kind_0_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionKind");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='descriptionBox'
		{
			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_1());
		}
		(
			(
				lv_iri_2_0=RULE_IRI
				{
					newLeafNode(lv_iri_2_0, grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDescriptionBoxRule());
					}
					setWithLastConsumed(
						$current,
						"iri",
						lv_iri_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationParserRuleCall_4_0_0());
					}
					lv_annotations_4_0=ruleAnnotation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
						}
						add(
							$current,
							"annotations",
							lv_annotations_4_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_4_1_0());
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
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_4_2_0());
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
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_4_3_0());
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
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_4_4_0());
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
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_4_5_0());
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
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_4_6_0());
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
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_4_7_0());
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
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_4_8_0());
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
						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_4_9_0());
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
			newLeafNode(otherlv_14, grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_5());
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
		otherlv_0='extends'
		{
			newLeafNode(otherlv_0, grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxCrossReference_1_0());
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
		otherlv_0='refines'
		{
			newLeafNode(otherlv_0, grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDescriptionBoxRefinementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxCrossReference_1_0());
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
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='.'
		{
			newLeafNode(otherlv_1, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='='
		{
			newLeafNode(otherlv_3, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_4_0());
				}
				lv_scalarPropertyValue_4_0=ruleValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
					}
					set(
						$current,
						"scalarPropertyValue",
						lv_scalarPropertyValue_4_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.Value");
					afterParserOrEnumRuleCall();
				}
			)
		)
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
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='.'
		{
			newLeafNode(otherlv_1, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='='
		{
			newLeafNode(otherlv_3, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_3());
		}
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0());
					}
					lv_structuredPropertyTuples_5_0=ruleStructuredDataPropertyTuple
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
						}
						add(
							$current,
							"structuredPropertyTuples",
							lv_structuredPropertyTuples_5_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0());
					}
					lv_scalarDataPropertyValues_6_0=ruleScalarDataPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
						}
						add(
							$current,
							"scalarDataPropertyValues",
							lv_scalarDataPropertyValues_6_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getRightCurlyBracketKeyword_6());
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
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredDataPropertyTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_0_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='='
		{
			newLeafNode(otherlv_1, grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0());
					}
					lv_structuredPropertyTuples_3_0=ruleStructuredDataPropertyTuple
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
						}
						add(
							$current,
							"structuredPropertyTuples",
							lv_structuredPropertyTuples_3_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0());
					}
					lv_scalarDataPropertyValues_4_0=ruleScalarDataPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
						}
						add(
							$current,
							"scalarDataPropertyValues",
							lv_scalarDataPropertyValues_4_0,
							"gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_4());
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
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScalarDataPropertyValueRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarCrossReference_0_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='='
		{
			newLeafNode(otherlv_1, grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0());
				}
				lv_scalarPropertyValue_2_0=ruleValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScalarDataPropertyValueRule());
					}
					set(
						$current,
						"scalarPropertyValue",
						lv_scalarPropertyValue_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.Value");
					afterParserOrEnumRuleCall();
				}
			)
		)
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
		otherlv_0='conceptInstance'
		{
			newLeafNode(otherlv_0, grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptInstanceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='is-a'
		{
			newLeafNode(otherlv_3, grammarAccess.getConceptInstanceAccess().getIsAKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConceptInstanceRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getConceptInstanceAccess().getRightParenthesisKeyword_5());
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
		otherlv_0='reifiedRelationshipInstance'
		{
			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
				}
			)
		)
		otherlv_3='is-a'
		{
			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceAccess().getRightParenthesisKeyword_5());
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
		otherlv_0='domain'
		{
			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_3());
		}
		otherlv_4='='
		{
			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0());
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
		otherlv_0='range'
		{
			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_3());
		}
		otherlv_4='='
		{
			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceCrossReference_5_0());
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
		otherlv_0='tuple'
		{
			newLeafNode(otherlv_0, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_0());
		}
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_1());
		}
		otherlv_2='unreifiedRelationship'
		{
			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='domain'
		{
			newLeafNode(otherlv_4, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_4());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='range'
		{
			newLeafNode(otherlv_6, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_6());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_7_0());
				}
				ruleReference
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8='}'
		{
			newLeafNode(otherlv_8, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRightCurlyBracketKeyword_8());
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

// Entry rule entryRuleValue
entryRuleValue returns [String current=null]:
	{ newCompositeNode(grammarAccess.getValueRule()); }
	iv_ruleValue=ruleValue
	{ $current=$iv_ruleValue.current.getText(); }
	EOF;

// Rule Value
ruleValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_DECIMAL_0=RULE_DECIMAL
		{
			$current.merge(this_DECIMAL_0);
		}
		{
			newLeafNode(this_DECIMAL_0, grammarAccess.getValueAccess().getDECIMALTerminalRuleCall_0());
		}
		    |
		this_STRING_1=RULE_STRING
		{
			$current.merge(this_STRING_1);
		}
		{
			newLeafNode(this_STRING_1, grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_1());
		}
		    |
		this_INT_2=RULE_INT
		{
			$current.merge(this_INT_2);
		}
		{
			newLeafNode(this_INT_2, grammarAccess.getValueAccess().getINTTerminalRuleCall_2());
		}
		    |
		this_UUID_3=RULE_UUID
		{
			$current.merge(this_UUID_3);
		}
		{
			newLeafNode(this_UUID_3, grammarAccess.getValueAccess().getUUIDTerminalRuleCall_3());
		}
		    |
		this_HEX_4=RULE_HEX
		{
			$current.merge(this_HEX_4);
		}
		{
			newLeafNode(this_HEX_4, grammarAccess.getValueAccess().getHEXTerminalRuleCall_4());
		}
		    |
		this_FLOAT_5=RULE_FLOAT
		{
			$current.merge(this_FLOAT_5);
		}
		{
			newLeafNode(this_FLOAT_5, grammarAccess.getValueAccess().getFLOATTerminalRuleCall_5());
		}
	)
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

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_IRI : '<' ~('>')* '>';

RULE_ABBREV_IRI : ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')+ ':' ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;

RULE_UUID : RULE_HEX_8DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_12DIGITS;

fragment RULE_HEX_12DIGITS : RULE_HEX_8DIGITS RULE_HEX_4DIGITS;

fragment RULE_HEX_8DIGITS : RULE_HEX_4DIGITS RULE_HEX_4DIGITS;

fragment RULE_HEX_4DIGITS : RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT;

fragment RULE_HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_INT : '0'..'9' ('0'..'9'|'_')*;

RULE_DECIMAL : RULE_INT (('e'|'E') ('+'|'-')? RULE_INT)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_FLOAT : '-'? ('0'..'9')+ '.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
