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
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package gov.nasa.jpl.imce.oml.dsl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package gov.nasa.jpl.imce.oml.dsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import gov.nasa.jpl.imce.oml.dsl.services.OMLGrammarAccess;

}
@parser::members {
	private OMLGrammarAccess grammarAccess;

	public void setGrammarAccess(OMLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleExtent
entryRuleExtent
:
{ before(grammarAccess.getExtentRule()); }
	 ruleExtent
{ after(grammarAccess.getExtentRule()); } 
	 EOF 
;

// Rule Extent
ruleExtent 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExtentAccess().getGroup()); }
		(rule__Extent__Group__0)
		{ after(grammarAccess.getExtentAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnnotationProperty
entryRuleAnnotationProperty
:
{ before(grammarAccess.getAnnotationPropertyRule()); }
	 ruleAnnotationProperty
{ after(grammarAccess.getAnnotationPropertyRule()); } 
	 EOF 
;

// Rule AnnotationProperty
ruleAnnotationProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotationPropertyAccess().getGroup()); }
		(rule__AnnotationProperty__Group__0)
		{ after(grammarAccess.getAnnotationPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnnotationPropertyValue
entryRuleAnnotationPropertyValue
:
{ before(grammarAccess.getAnnotationPropertyValueRule()); }
	 ruleAnnotationPropertyValue
{ after(grammarAccess.getAnnotationPropertyValueRule()); } 
	 EOF 
;

// Rule AnnotationPropertyValue
ruleAnnotationPropertyValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotationPropertyValueAccess().getGroup()); }
		(rule__AnnotationPropertyValue__Group__0)
		{ after(grammarAccess.getAnnotationPropertyValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleModule
entryRuleModule
:
{ before(grammarAccess.getModuleRule()); }
	 ruleModule
{ after(grammarAccess.getModuleRule()); } 
	 EOF 
;

// Rule Module
ruleModule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getModuleAccess().getAlternatives()); }
		(rule__Module__Alternatives)
		{ after(grammarAccess.getModuleAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminologyBox
entryRuleTerminologyBox
:
{ before(grammarAccess.getTerminologyBoxRule()); }
	 ruleTerminologyBox
{ after(grammarAccess.getTerminologyBoxRule()); } 
	 EOF 
;

// Rule TerminologyBox
ruleTerminologyBox 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyBoxAccess().getAlternatives()); }
		(rule__TerminologyBox__Alternatives)
		{ after(grammarAccess.getTerminologyBoxAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminologyGraph
entryRuleTerminologyGraph
:
{ before(grammarAccess.getTerminologyGraphRule()); }
	 ruleTerminologyGraph
{ after(grammarAccess.getTerminologyGraphRule()); } 
	 EOF 
;

// Rule TerminologyGraph
ruleTerminologyGraph 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getGroup()); }
		(rule__TerminologyGraph__Group__0)
		{ after(grammarAccess.getTerminologyGraphAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBundle
entryRuleBundle
:
{ before(grammarAccess.getBundleRule()); }
	 ruleBundle
{ after(grammarAccess.getBundleRule()); } 
	 EOF 
;

// Rule Bundle
ruleBundle 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBundleAccess().getGroup()); }
		(rule__Bundle__Group__0)
		{ after(grammarAccess.getBundleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescriptionBox
entryRuleDescriptionBox
:
{ before(grammarAccess.getDescriptionBoxRule()); }
	 ruleDescriptionBox
{ after(grammarAccess.getDescriptionBoxRule()); } 
	 EOF 
;

// Rule DescriptionBox
ruleDescriptionBox 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getGroup()); }
		(rule__DescriptionBox__Group__0)
		{ after(grammarAccess.getDescriptionBoxAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminologyBoxAxiom
entryRuleTerminologyBoxAxiom
:
{ before(grammarAccess.getTerminologyBoxAxiomRule()); }
	 ruleTerminologyBoxAxiom
{ after(grammarAccess.getTerminologyBoxAxiomRule()); } 
	 EOF 
;

// Rule TerminologyBoxAxiom
ruleTerminologyBoxAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyBoxAxiomAccess().getAlternatives()); }
		(rule__TerminologyBoxAxiom__Alternatives)
		{ after(grammarAccess.getTerminologyBoxAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBundledTerminologyAxiom
entryRuleBundledTerminologyAxiom
:
{ before(grammarAccess.getBundledTerminologyAxiomRule()); }
	 ruleBundledTerminologyAxiom
{ after(grammarAccess.getBundledTerminologyAxiomRule()); } 
	 EOF 
;

// Rule BundledTerminologyAxiom
ruleBundledTerminologyAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBundledTerminologyAxiomAccess().getGroup()); }
		(rule__BundledTerminologyAxiom__Group__0)
		{ after(grammarAccess.getBundledTerminologyAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConceptDesignationTerminologyAxiom
entryRuleConceptDesignationTerminologyAxiom
:
{ before(grammarAccess.getConceptDesignationTerminologyAxiomRule()); }
	 ruleConceptDesignationTerminologyAxiom
{ after(grammarAccess.getConceptDesignationTerminologyAxiomRule()); } 
	 EOF 
;

// Rule ConceptDesignationTerminologyAxiom
ruleConceptDesignationTerminologyAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getGroup()); }
		(rule__ConceptDesignationTerminologyAxiom__Group__0)
		{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminologyExtensionAxiom
entryRuleTerminologyExtensionAxiom
:
{ before(grammarAccess.getTerminologyExtensionAxiomRule()); }
	 ruleTerminologyExtensionAxiom
{ after(grammarAccess.getTerminologyExtensionAxiomRule()); } 
	 EOF 
;

// Rule TerminologyExtensionAxiom
ruleTerminologyExtensionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getGroup()); }
		(rule__TerminologyExtensionAxiom__Group__0)
		{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminologyNestingAxiom
entryRuleTerminologyNestingAxiom
:
{ before(grammarAccess.getTerminologyNestingAxiomRule()); }
	 ruleTerminologyNestingAxiom
{ after(grammarAccess.getTerminologyNestingAxiomRule()); } 
	 EOF 
;

// Rule TerminologyNestingAxiom
ruleTerminologyNestingAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyNestingAxiomAccess().getGroup()); }
		(rule__TerminologyNestingAxiom__Group__0)
		{ after(grammarAccess.getTerminologyNestingAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminologyBoxStatement
entryRuleTerminologyBoxStatement
:
{ before(grammarAccess.getTerminologyBoxStatementRule()); }
	 ruleTerminologyBoxStatement
{ after(grammarAccess.getTerminologyBoxStatementRule()); } 
	 EOF 
;

// Rule TerminologyBoxStatement
ruleTerminologyBoxStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyBoxStatementAccess().getAlternatives()); }
		(rule__TerminologyBoxStatement__Alternatives)
		{ after(grammarAccess.getTerminologyBoxStatementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerm
entryRuleTerm
:
{ before(grammarAccess.getTermRule()); }
	 ruleTerm
{ after(grammarAccess.getTermRule()); } 
	 EOF 
;

// Rule Term
ruleTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTermAccess().getAlternatives()); }
		(rule__Term__Alternatives)
		{ after(grammarAccess.getTermAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAtomicEntity
entryRuleAtomicEntity
:
{ before(grammarAccess.getAtomicEntityRule()); }
	 ruleAtomicEntity
{ after(grammarAccess.getAtomicEntityRule()); } 
	 EOF 
;

// Rule AtomicEntity
ruleAtomicEntity 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAtomicEntityAccess().getAlternatives()); }
		(rule__AtomicEntity__Alternatives)
		{ after(grammarAccess.getAtomicEntityAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityRelationship
entryRuleEntityRelationship
:
{ before(grammarAccess.getEntityRelationshipRule()); }
	 ruleEntityRelationship
{ after(grammarAccess.getEntityRelationshipRule()); } 
	 EOF 
;

// Rule EntityRelationship
ruleEntityRelationship 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityRelationshipAccess().getAlternatives()); }
		(rule__EntityRelationship__Alternatives)
		{ after(grammarAccess.getEntityRelationshipAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDatatype
entryRuleDatatype
:
{ before(grammarAccess.getDatatypeRule()); }
	 ruleDatatype
{ after(grammarAccess.getDatatypeRule()); } 
	 EOF 
;

// Rule Datatype
ruleDatatype 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDatatypeAccess().getAlternatives()); }
		(rule__Datatype__Alternatives)
		{ after(grammarAccess.getDatatypeAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarDataRange
entryRuleScalarDataRange
:
{ before(grammarAccess.getScalarDataRangeRule()); }
	 ruleScalarDataRange
{ after(grammarAccess.getScalarDataRangeRule()); } 
	 EOF 
;

// Rule ScalarDataRange
ruleScalarDataRange 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarDataRangeAccess().getAlternatives()); }
		(rule__ScalarDataRange__Alternatives)
		{ after(grammarAccess.getScalarDataRangeAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRestrictedDataRange
entryRuleRestrictedDataRange
:
{ before(grammarAccess.getRestrictedDataRangeRule()); }
	 ruleRestrictedDataRange
{ after(grammarAccess.getRestrictedDataRangeRule()); } 
	 EOF 
;

// Rule RestrictedDataRange
ruleRestrictedDataRange 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getAlternatives()); }
		(rule__RestrictedDataRange__Alternatives)
		{ after(grammarAccess.getRestrictedDataRangeAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDataRelationship
entryRuleDataRelationship
:
{ before(grammarAccess.getDataRelationshipRule()); }
	 ruleDataRelationship
{ after(grammarAccess.getDataRelationshipRule()); } 
	 EOF 
;

// Rule DataRelationship
ruleDataRelationship 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDataRelationshipAccess().getAlternatives()); }
		(rule__DataRelationship__Alternatives)
		{ after(grammarAccess.getDataRelationshipAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTermAxiom
entryRuleTermAxiom
:
{ before(grammarAccess.getTermAxiomRule()); }
	 ruleTermAxiom
{ after(grammarAccess.getTermAxiomRule()); } 
	 EOF 
;

// Rule TermAxiom
ruleTermAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTermAxiomAccess().getAlternatives()); }
		(rule__TermAxiom__Alternatives)
		{ after(grammarAccess.getTermAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityRestrictionAxiom
entryRuleEntityRestrictionAxiom
:
{ before(grammarAccess.getEntityRestrictionAxiomRule()); }
	 ruleEntityRestrictionAxiom
{ after(grammarAccess.getEntityRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityRestrictionAxiom
ruleEntityRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityRestrictionAxiomAccess().getAlternatives()); }
		(rule__EntityRestrictionAxiom__Alternatives)
		{ after(grammarAccess.getEntityRestrictionAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityScalarDataPropertyRestrictionAxiom
entryRuleEntityScalarDataPropertyRestrictionAxiom
:
{ before(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomRule()); }
	 ruleEntityScalarDataPropertyRestrictionAxiom
{ after(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityScalarDataPropertyRestrictionAxiom
ruleEntityScalarDataPropertyRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getAlternatives()); }
		(rule__EntityScalarDataPropertyRestrictionAxiom__Alternatives)
		{ after(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityStructuredDataPropertyRestrictionAxiom
entryRuleEntityStructuredDataPropertyRestrictionAxiom
:
{ before(grammarAccess.getEntityStructuredDataPropertyRestrictionAxiomRule()); }
	 ruleEntityStructuredDataPropertyRestrictionAxiom
{ after(grammarAccess.getEntityStructuredDataPropertyRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityStructuredDataPropertyRestrictionAxiom
ruleEntityStructuredDataPropertyRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyRestrictionAxiomAccess().getEntityStructuredDataPropertyParticularRestrictionAxiomParserRuleCall()); }
		ruleEntityStructuredDataPropertyParticularRestrictionAxiom
		{ after(grammarAccess.getEntityStructuredDataPropertyRestrictionAxiomAccess().getEntityStructuredDataPropertyParticularRestrictionAxiomParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSpecializationAxiom
entryRuleSpecializationAxiom
:
{ before(grammarAccess.getSpecializationAxiomRule()); }
	 ruleSpecializationAxiom
{ after(grammarAccess.getSpecializationAxiomRule()); } 
	 EOF 
;

// Rule SpecializationAxiom
ruleSpecializationAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSpecializationAxiomAccess().getAlternatives()); }
		(rule__SpecializationAxiom__Alternatives)
		{ after(grammarAccess.getSpecializationAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminologyBundleStatement
entryRuleTerminologyBundleStatement
:
{ before(grammarAccess.getTerminologyBundleStatementRule()); }
	 ruleTerminologyBundleStatement
{ after(grammarAccess.getTerminologyBundleStatementRule()); } 
	 EOF 
;

// Rule TerminologyBundleStatement
ruleTerminologyBundleStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyBundleStatementAccess().getRootConceptTaxonomyAxiomParserRuleCall()); }
		ruleRootConceptTaxonomyAxiom
		{ after(grammarAccess.getTerminologyBundleStatementAccess().getRootConceptTaxonomyAxiomParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminologyBundleAxiom
entryRuleTerminologyBundleAxiom
:
{ before(grammarAccess.getTerminologyBundleAxiomRule()); }
	 ruleTerminologyBundleAxiom
{ after(grammarAccess.getTerminologyBundleAxiomRule()); } 
	 EOF 
;

// Rule TerminologyBundleAxiom
ruleTerminologyBundleAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminologyBundleAxiomAccess().getBundledTerminologyAxiomParserRuleCall()); }
		ruleBundledTerminologyAxiom
		{ after(grammarAccess.getTerminologyBundleAxiomAccess().getBundledTerminologyAxiomParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDisjointUnionOfConceptsAxiom
entryRuleDisjointUnionOfConceptsAxiom
:
{ before(grammarAccess.getDisjointUnionOfConceptsAxiomRule()); }
	 ruleDisjointUnionOfConceptsAxiom
{ after(grammarAccess.getDisjointUnionOfConceptsAxiomRule()); } 
	 EOF 
;

// Rule DisjointUnionOfConceptsAxiom
ruleDisjointUnionOfConceptsAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getAlternatives()); }
		(rule__DisjointUnionOfConceptsAxiom__Alternatives)
		{ after(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAspect
entryRuleAspect
:
{ before(grammarAccess.getAspectRule()); }
	 ruleAspect
{ after(grammarAccess.getAspectRule()); } 
	 EOF 
;

// Rule Aspect
ruleAspect 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAspectAccess().getGroup()); }
		(rule__Aspect__Group__0)
		{ after(grammarAccess.getAspectAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCardinalityRestrictedAspect
entryRuleCardinalityRestrictedAspect
:
{ before(grammarAccess.getCardinalityRestrictedAspectRule()); }
	 ruleCardinalityRestrictedAspect
{ after(grammarAccess.getCardinalityRestrictedAspectRule()); } 
	 EOF 
;

// Rule CardinalityRestrictedAspect
ruleCardinalityRestrictedAspect 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getGroup()); }
		(rule__CardinalityRestrictedAspect__Group__0)
		{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConcept
entryRuleConcept
:
{ before(grammarAccess.getConceptRule()); }
	 ruleConcept
{ after(grammarAccess.getConceptRule()); } 
	 EOF 
;

// Rule Concept
ruleConcept 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptAccess().getGroup()); }
		(rule__Concept__Group__0)
		{ after(grammarAccess.getConceptAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCardinalityRestrictedConcept
entryRuleCardinalityRestrictedConcept
:
{ before(grammarAccess.getCardinalityRestrictedConceptRule()); }
	 ruleCardinalityRestrictedConcept
{ after(grammarAccess.getCardinalityRestrictedConceptRule()); } 
	 EOF 
;

// Rule CardinalityRestrictedConcept
ruleCardinalityRestrictedConcept 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getGroup()); }
		(rule__CardinalityRestrictedConcept__Group__0)
		{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReifiedRelationship
entryRuleReifiedRelationship
:
{ before(grammarAccess.getReifiedRelationshipRule()); }
	 ruleReifiedRelationship
{ after(grammarAccess.getReifiedRelationshipRule()); } 
	 EOF 
;

// Rule ReifiedRelationship
ruleReifiedRelationship 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getGroup()); }
		(rule__ReifiedRelationship__Group__0)
		{ after(grammarAccess.getReifiedRelationshipAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleForwardProperty
entryRuleForwardProperty
:
{ before(grammarAccess.getForwardPropertyRule()); }
	 ruleForwardProperty
{ after(grammarAccess.getForwardPropertyRule()); } 
	 EOF 
;

// Rule ForwardProperty
ruleForwardProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getForwardPropertyAccess().getNameAssignment()); }
		(rule__ForwardProperty__NameAssignment)
		{ after(grammarAccess.getForwardPropertyAccess().getNameAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInverseProperty
entryRuleInverseProperty
:
{ before(grammarAccess.getInversePropertyRule()); }
	 ruleInverseProperty
{ after(grammarAccess.getInversePropertyRule()); } 
	 EOF 
;

// Rule InverseProperty
ruleInverseProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInversePropertyAccess().getNameAssignment()); }
		(rule__InverseProperty__NameAssignment)
		{ after(grammarAccess.getInversePropertyAccess().getNameAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReifiedRelationshipRestriction
entryRuleReifiedRelationshipRestriction
:
{ before(grammarAccess.getReifiedRelationshipRestrictionRule()); }
	 ruleReifiedRelationshipRestriction
{ after(grammarAccess.getReifiedRelationshipRestrictionRule()); } 
	 EOF 
;

// Rule ReifiedRelationshipRestriction
ruleReifiedRelationshipRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getGroup()); }
		(rule__ReifiedRelationshipRestriction__Group__0)
		{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCardinalityRestrictedReifiedRelationship
entryRuleCardinalityRestrictedReifiedRelationship
:
{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipRule()); }
	 ruleCardinalityRestrictedReifiedRelationship
{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipRule()); } 
	 EOF 
;

// Rule CardinalityRestrictedReifiedRelationship
ruleCardinalityRestrictedReifiedRelationship 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getGroup()); }
		(rule__CardinalityRestrictedReifiedRelationship__Group__0)
		{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUnreifiedRelationship
entryRuleUnreifiedRelationship
:
{ before(grammarAccess.getUnreifiedRelationshipRule()); }
	 ruleUnreifiedRelationship
{ after(grammarAccess.getUnreifiedRelationshipRule()); } 
	 EOF 
;

// Rule UnreifiedRelationship
ruleUnreifiedRelationship 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getGroup()); }
		(rule__UnreifiedRelationship__Group__0)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalar
entryRuleScalar
:
{ before(grammarAccess.getScalarRule()); }
	 ruleScalar
{ after(grammarAccess.getScalarRule()); } 
	 EOF 
;

// Rule Scalar
ruleScalar 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarAccess().getGroup()); }
		(rule__Scalar__Group__0)
		{ after(grammarAccess.getScalarAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructure
entryRuleStructure
:
{ before(grammarAccess.getStructureRule()); }
	 ruleStructure
{ after(grammarAccess.getStructureRule()); } 
	 EOF 
;

// Rule Structure
ruleStructure 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructureAccess().getGroup()); }
		(rule__Structure__Group__0)
		{ after(grammarAccess.getStructureAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityStructuredDataProperty
entryRuleEntityStructuredDataProperty
:
{ before(grammarAccess.getEntityStructuredDataPropertyRule()); }
	 ruleEntityStructuredDataProperty
{ after(grammarAccess.getEntityStructuredDataPropertyRule()); } 
	 EOF 
;

// Rule EntityStructuredDataProperty
ruleEntityStructuredDataProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getGroup()); }
		(rule__EntityStructuredDataProperty__Group__0)
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityScalarDataProperty
entryRuleEntityScalarDataProperty
:
{ before(grammarAccess.getEntityScalarDataPropertyRule()); }
	 ruleEntityScalarDataProperty
{ after(grammarAccess.getEntityScalarDataPropertyRule()); } 
	 EOF 
;

// Rule EntityScalarDataProperty
ruleEntityScalarDataProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getGroup()); }
		(rule__EntityScalarDataProperty__Group__0)
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredDataProperty
entryRuleStructuredDataProperty
:
{ before(grammarAccess.getStructuredDataPropertyRule()); }
	 ruleStructuredDataProperty
{ after(grammarAccess.getStructuredDataPropertyRule()); } 
	 EOF 
;

// Rule StructuredDataProperty
ruleStructuredDataProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredDataPropertyAccess().getGroup()); }
		(rule__StructuredDataProperty__Group__0)
		{ after(grammarAccess.getStructuredDataPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarDataProperty
entryRuleScalarDataProperty
:
{ before(grammarAccess.getScalarDataPropertyRule()); }
	 ruleScalarDataProperty
{ after(grammarAccess.getScalarDataPropertyRule()); } 
	 EOF 
;

// Rule ScalarDataProperty
ruleScalarDataProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarDataPropertyAccess().getGroup()); }
		(rule__ScalarDataProperty__Group__0)
		{ after(grammarAccess.getScalarDataPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRule
entryRuleRule
:
{ before(grammarAccess.getRuleRule()); }
	 ruleRule
{ after(grammarAccess.getRuleRule()); } 
	 EOF 
;

// Rule Rule
ruleRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRuleAccess().getChainRuleParserRuleCall()); }
		ruleChainRule
		{ after(grammarAccess.getRuleAccess().getChainRuleParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleChainRule
entryRuleChainRule
:
{ before(grammarAccess.getChainRuleRule()); }
	 ruleChainRule
{ after(grammarAccess.getChainRuleRule()); } 
	 EOF 
;

// Rule ChainRule
ruleChainRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getChainRuleAccess().getGroup()); }
		(rule__ChainRule__Group__0)
		{ after(grammarAccess.getChainRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRuleBodySegment
entryRuleRuleBodySegment
:
{ before(grammarAccess.getRuleBodySegmentRule()); }
	 ruleRuleBodySegment
{ after(grammarAccess.getRuleBodySegmentRule()); } 
	 EOF 
;

// Rule RuleBodySegment
ruleRuleBodySegment 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRuleBodySegmentAccess().getGroup()); }
		(rule__RuleBodySegment__Group__0)
		{ after(grammarAccess.getRuleBodySegmentAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSegmentPredicate
entryRuleSegmentPredicate
:
{ before(grammarAccess.getSegmentPredicateRule()); }
	 ruleSegmentPredicate
{ after(grammarAccess.getSegmentPredicateRule()); } 
	 EOF 
;

// Rule SegmentPredicate
ruleSegmentPredicate 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getAlternatives()); }
		(rule__SegmentPredicate__Alternatives)
		{ after(grammarAccess.getSegmentPredicateAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnonymousConceptUnionAxiom
entryRuleAnonymousConceptUnionAxiom
:
{ before(grammarAccess.getAnonymousConceptUnionAxiomRule()); }
	 ruleAnonymousConceptUnionAxiom
{ after(grammarAccess.getAnonymousConceptUnionAxiomRule()); } 
	 EOF 
;

// Rule AnonymousConceptUnionAxiom
ruleAnonymousConceptUnionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getGroup()); }
		(rule__AnonymousConceptUnionAxiom__Group__0)
		{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRootConceptTaxonomyAxiom
entryRuleRootConceptTaxonomyAxiom
:
{ before(grammarAccess.getRootConceptTaxonomyAxiomRule()); }
	 ruleRootConceptTaxonomyAxiom
{ after(grammarAccess.getRootConceptTaxonomyAxiomRule()); } 
	 EOF 
;

// Rule RootConceptTaxonomyAxiom
ruleRootConceptTaxonomyAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getGroup()); }
		(rule__RootConceptTaxonomyAxiom__Group__0)
		{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSpecificDisjointConceptAxiom
entryRuleSpecificDisjointConceptAxiom
:
{ before(grammarAccess.getSpecificDisjointConceptAxiomRule()); }
	 ruleSpecificDisjointConceptAxiom
{ after(grammarAccess.getSpecificDisjointConceptAxiomRule()); } 
	 EOF 
;

// Rule SpecificDisjointConceptAxiom
ruleSpecificDisjointConceptAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getGroup()); }
		(rule__SpecificDisjointConceptAxiom__Group__0)
		{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityExistentialRestrictionAxiom
entryRuleEntityExistentialRestrictionAxiom
:
{ before(grammarAccess.getEntityExistentialRestrictionAxiomRule()); }
	 ruleEntityExistentialRestrictionAxiom
{ after(grammarAccess.getEntityExistentialRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityExistentialRestrictionAxiom
ruleEntityExistentialRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getGroup()); }
		(rule__EntityExistentialRestrictionAxiom__Group__0)
		{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityUniversalRestrictionAxiom
entryRuleEntityUniversalRestrictionAxiom
:
{ before(grammarAccess.getEntityUniversalRestrictionAxiomRule()); }
	 ruleEntityUniversalRestrictionAxiom
{ after(grammarAccess.getEntityUniversalRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityUniversalRestrictionAxiom
ruleEntityUniversalRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getGroup()); }
		(rule__EntityUniversalRestrictionAxiom__Group__0)
		{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAspectSpecializationAxiom
entryRuleAspectSpecializationAxiom
:
{ before(grammarAccess.getAspectSpecializationAxiomRule()); }
	 ruleAspectSpecializationAxiom
{ after(grammarAccess.getAspectSpecializationAxiomRule()); } 
	 EOF 
;

// Rule AspectSpecializationAxiom
ruleAspectSpecializationAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAspectSpecializationAxiomAccess().getGroup()); }
		(rule__AspectSpecializationAxiom__Group__0)
		{ after(grammarAccess.getAspectSpecializationAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConceptSpecializationAxiom
entryRuleConceptSpecializationAxiom
:
{ before(grammarAccess.getConceptSpecializationAxiomRule()); }
	 ruleConceptSpecializationAxiom
{ after(grammarAccess.getConceptSpecializationAxiomRule()); } 
	 EOF 
;

// Rule ConceptSpecializationAxiom
ruleConceptSpecializationAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptSpecializationAxiomAccess().getGroup()); }
		(rule__ConceptSpecializationAxiom__Group__0)
		{ after(grammarAccess.getConceptSpecializationAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReifiedRelationshipSpecializationAxiom
entryRuleReifiedRelationshipSpecializationAxiom
:
{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomRule()); }
	 ruleReifiedRelationshipSpecializationAxiom
{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomRule()); } 
	 EOF 
;

// Rule ReifiedRelationshipSpecializationAxiom
ruleReifiedRelationshipSpecializationAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getGroup()); }
		(rule__ReifiedRelationshipSpecializationAxiom__Group__0)
		{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSubObjectPropertyOfAxiom
entryRuleSubObjectPropertyOfAxiom
:
{ before(grammarAccess.getSubObjectPropertyOfAxiomRule()); }
	 ruleSubObjectPropertyOfAxiom
{ after(grammarAccess.getSubObjectPropertyOfAxiomRule()); } 
	 EOF 
;

// Rule SubObjectPropertyOfAxiom
ruleSubObjectPropertyOfAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getGroup()); }
		(rule__SubObjectPropertyOfAxiom__Group__0)
		{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSubDataPropertyOfAxiom
entryRuleSubDataPropertyOfAxiom
:
{ before(grammarAccess.getSubDataPropertyOfAxiomRule()); }
	 ruleSubDataPropertyOfAxiom
{ after(grammarAccess.getSubDataPropertyOfAxiomRule()); } 
	 EOF 
;

// Rule SubDataPropertyOfAxiom
ruleSubDataPropertyOfAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getGroup()); }
		(rule__SubDataPropertyOfAxiom__Group__0)
		{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom
entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom
:
{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule()); }
	 ruleEntityScalarDataPropertyExistentialRestrictionAxiom
{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityScalarDataPropertyExistentialRestrictionAxiom
ruleEntityScalarDataPropertyExistentialRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getGroup()); }
		(rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__0)
		{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityScalarDataPropertyParticularRestrictionAxiom
entryRuleEntityScalarDataPropertyParticularRestrictionAxiom
:
{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule()); }
	 ruleEntityScalarDataPropertyParticularRestrictionAxiom
{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityScalarDataPropertyParticularRestrictionAxiom
ruleEntityScalarDataPropertyParticularRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getGroup()); }
		(rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__0)
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom
entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom
:
{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule()); }
	 ruleEntityScalarDataPropertyUniversalRestrictionAxiom
{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityScalarDataPropertyUniversalRestrictionAxiom
ruleEntityScalarDataPropertyUniversalRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getGroup()); }
		(rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__0)
		{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom
entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom
:
{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule()); }
	 ruleEntityStructuredDataPropertyParticularRestrictionAxiom
{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule()); } 
	 EOF 
;

// Rule EntityStructuredDataPropertyParticularRestrictionAxiom
ruleEntityStructuredDataPropertyParticularRestrictionAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getGroup()); }
		(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__0)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRestrictionStructuredDataPropertyTuple
entryRuleRestrictionStructuredDataPropertyTuple
:
{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleRule()); }
	 ruleRestrictionStructuredDataPropertyTuple
{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleRule()); } 
	 EOF 
;

// Rule RestrictionStructuredDataPropertyTuple
ruleRestrictionStructuredDataPropertyTuple 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getGroup()); }
		(rule__RestrictionStructuredDataPropertyTuple__Group__0)
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRestrictionScalarDataPropertyValue
entryRuleRestrictionScalarDataPropertyValue
:
{ before(grammarAccess.getRestrictionScalarDataPropertyValueRule()); }
	 ruleRestrictionScalarDataPropertyValue
{ after(grammarAccess.getRestrictionScalarDataPropertyValueRule()); } 
	 EOF 
;

// Rule RestrictionScalarDataPropertyValue
ruleRestrictionScalarDataPropertyValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getGroup()); }
		(rule__RestrictionScalarDataPropertyValue__Group__0)
		{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBinaryScalarRestriction
entryRuleBinaryScalarRestriction
:
{ before(grammarAccess.getBinaryScalarRestrictionRule()); }
	 ruleBinaryScalarRestriction
{ after(grammarAccess.getBinaryScalarRestrictionRule()); } 
	 EOF 
;

// Rule BinaryScalarRestriction
ruleBinaryScalarRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getGroup()); }
		(rule__BinaryScalarRestriction__Group__0)
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIRIScalarRestriction
entryRuleIRIScalarRestriction
:
{ before(grammarAccess.getIRIScalarRestrictionRule()); }
	 ruleIRIScalarRestriction
{ after(grammarAccess.getIRIScalarRestrictionRule()); } 
	 EOF 
;

// Rule IRIScalarRestriction
ruleIRIScalarRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup()); }
		(rule__IRIScalarRestriction__Group__0)
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNumericScalarRestriction
entryRuleNumericScalarRestriction
:
{ before(grammarAccess.getNumericScalarRestrictionRule()); }
	 ruleNumericScalarRestriction
{ after(grammarAccess.getNumericScalarRestrictionRule()); } 
	 EOF 
;

// Rule NumericScalarRestriction
ruleNumericScalarRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup()); }
		(rule__NumericScalarRestriction__Group__0)
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePlainLiteralScalarRestriction
entryRulePlainLiteralScalarRestriction
:
{ before(grammarAccess.getPlainLiteralScalarRestrictionRule()); }
	 rulePlainLiteralScalarRestriction
{ after(grammarAccess.getPlainLiteralScalarRestrictionRule()); } 
	 EOF 
;

// Rule PlainLiteralScalarRestriction
rulePlainLiteralScalarRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup()); }
		(rule__PlainLiteralScalarRestriction__Group__0)
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarOneOfRestriction
entryRuleScalarOneOfRestriction
:
{ before(grammarAccess.getScalarOneOfRestrictionRule()); }
	 ruleScalarOneOfRestriction
{ after(grammarAccess.getScalarOneOfRestrictionRule()); } 
	 EOF 
;

// Rule ScalarOneOfRestriction
ruleScalarOneOfRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarOneOfRestrictionAccess().getGroup()); }
		(rule__ScalarOneOfRestriction__Group__0)
		{ after(grammarAccess.getScalarOneOfRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarOneOfLiteralAxiom
entryRuleScalarOneOfLiteralAxiom
:
{ before(grammarAccess.getScalarOneOfLiteralAxiomRule()); }
	 ruleScalarOneOfLiteralAxiom
{ after(grammarAccess.getScalarOneOfLiteralAxiomRule()); } 
	 EOF 
;

// Rule ScalarOneOfLiteralAxiom
ruleScalarOneOfLiteralAxiom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getGroup()); }
		(rule__ScalarOneOfLiteralAxiom__Group__0)
		{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStringScalarRestriction
entryRuleStringScalarRestriction
:
{ before(grammarAccess.getStringScalarRestrictionRule()); }
	 ruleStringScalarRestriction
{ after(grammarAccess.getStringScalarRestrictionRule()); } 
	 EOF 
;

// Rule StringScalarRestriction
ruleStringScalarRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup()); }
		(rule__StringScalarRestriction__Group__0)
		{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSynonymScalarRestriction
entryRuleSynonymScalarRestriction
:
{ before(grammarAccess.getSynonymScalarRestrictionRule()); }
	 ruleSynonymScalarRestriction
{ after(grammarAccess.getSynonymScalarRestrictionRule()); } 
	 EOF 
;

// Rule SynonymScalarRestriction
ruleSynonymScalarRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSynonymScalarRestrictionAccess().getGroup()); }
		(rule__SynonymScalarRestriction__Group__0)
		{ after(grammarAccess.getSynonymScalarRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTimeScalarRestriction
entryRuleTimeScalarRestriction
:
{ before(grammarAccess.getTimeScalarRestrictionRule()); }
	 ruleTimeScalarRestriction
{ after(grammarAccess.getTimeScalarRestrictionRule()); } 
	 EOF 
;

// Rule TimeScalarRestriction
ruleTimeScalarRestriction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup()); }
		(rule__TimeScalarRestriction__Group__0)
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConceptualEntitySingletonInstance
entryRuleConceptualEntitySingletonInstance
:
{ before(grammarAccess.getConceptualEntitySingletonInstanceRule()); }
	 ruleConceptualEntitySingletonInstance
{ after(grammarAccess.getConceptualEntitySingletonInstanceRule()); } 
	 EOF 
;

// Rule ConceptualEntitySingletonInstance
ruleConceptualEntitySingletonInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptualEntitySingletonInstanceAccess().getAlternatives()); }
		(rule__ConceptualEntitySingletonInstance__Alternatives)
		{ after(grammarAccess.getConceptualEntitySingletonInstanceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescriptionBoxExtendsClosedWorldDefinitions
entryRuleDescriptionBoxExtendsClosedWorldDefinitions
:
{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule()); }
	 ruleDescriptionBoxExtendsClosedWorldDefinitions
{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule()); } 
	 EOF 
;

// Rule DescriptionBoxExtendsClosedWorldDefinitions
ruleDescriptionBoxExtendsClosedWorldDefinitions 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getGroup()); }
		(rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__0)
		{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDescriptionBoxRefinement
entryRuleDescriptionBoxRefinement
:
{ before(grammarAccess.getDescriptionBoxRefinementRule()); }
	 ruleDescriptionBoxRefinement
{ after(grammarAccess.getDescriptionBoxRefinementRule()); } 
	 EOF 
;

// Rule DescriptionBoxRefinement
ruleDescriptionBoxRefinement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDescriptionBoxRefinementAccess().getGroup()); }
		(rule__DescriptionBoxRefinement__Group__0)
		{ after(grammarAccess.getDescriptionBoxRefinementAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSingletonInstanceScalarDataPropertyValue
entryRuleSingletonInstanceScalarDataPropertyValue
:
{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule()); }
	 ruleSingletonInstanceScalarDataPropertyValue
{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule()); } 
	 EOF 
;

// Rule SingletonInstanceScalarDataPropertyValue
ruleSingletonInstanceScalarDataPropertyValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getGroup()); }
		(rule__SingletonInstanceScalarDataPropertyValue__Group__0)
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSingletonInstanceStructuredDataPropertyValue
entryRuleSingletonInstanceStructuredDataPropertyValue
:
{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule()); }
	 ruleSingletonInstanceStructuredDataPropertyValue
{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule()); } 
	 EOF 
;

// Rule SingletonInstanceStructuredDataPropertyValue
ruleSingletonInstanceStructuredDataPropertyValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getGroup()); }
		(rule__SingletonInstanceStructuredDataPropertyValue__Group__0)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStructuredDataPropertyTuple
entryRuleStructuredDataPropertyTuple
:
{ before(grammarAccess.getStructuredDataPropertyTupleRule()); }
	 ruleStructuredDataPropertyTuple
{ after(grammarAccess.getStructuredDataPropertyTupleRule()); } 
	 EOF 
;

// Rule StructuredDataPropertyTuple
ruleStructuredDataPropertyTuple 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getGroup()); }
		(rule__StructuredDataPropertyTuple__Group__0)
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScalarDataPropertyValue
entryRuleScalarDataPropertyValue
:
{ before(grammarAccess.getScalarDataPropertyValueRule()); }
	 ruleScalarDataPropertyValue
{ after(grammarAccess.getScalarDataPropertyValueRule()); } 
	 EOF 
;

// Rule ScalarDataPropertyValue
ruleScalarDataPropertyValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScalarDataPropertyValueAccess().getGroup()); }
		(rule__ScalarDataPropertyValue__Group__0)
		{ after(grammarAccess.getScalarDataPropertyValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConceptInstance
entryRuleConceptInstance
:
{ before(grammarAccess.getConceptInstanceRule()); }
	 ruleConceptInstance
{ after(grammarAccess.getConceptInstanceRule()); } 
	 EOF 
;

// Rule ConceptInstance
ruleConceptInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getGroup()); }
		(rule__ConceptInstance__Group__0)
		{ after(grammarAccess.getConceptInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReifiedRelationshipInstance
entryRuleReifiedRelationshipInstance
:
{ before(grammarAccess.getReifiedRelationshipInstanceRule()); }
	 ruleReifiedRelationshipInstance
{ after(grammarAccess.getReifiedRelationshipInstanceRule()); } 
	 EOF 
;

// Rule ReifiedRelationshipInstance
ruleReifiedRelationshipInstance 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getGroup()); }
		(rule__ReifiedRelationshipInstance__Group__0)
		{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReifiedRelationshipInstanceDomain
entryRuleReifiedRelationshipInstanceDomain
:
{ before(grammarAccess.getReifiedRelationshipInstanceDomainRule()); }
	 ruleReifiedRelationshipInstanceDomain
{ after(grammarAccess.getReifiedRelationshipInstanceDomainRule()); } 
	 EOF 
;

// Rule ReifiedRelationshipInstanceDomain
ruleReifiedRelationshipInstanceDomain 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getGroup()); }
		(rule__ReifiedRelationshipInstanceDomain__Group__0)
		{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReifiedRelationshipInstanceRange
entryRuleReifiedRelationshipInstanceRange
:
{ before(grammarAccess.getReifiedRelationshipInstanceRangeRule()); }
	 ruleReifiedRelationshipInstanceRange
{ after(grammarAccess.getReifiedRelationshipInstanceRangeRule()); } 
	 EOF 
;

// Rule ReifiedRelationshipInstanceRange
ruleReifiedRelationshipInstanceRange 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getGroup()); }
		(rule__ReifiedRelationshipInstanceRange__Group__0)
		{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUnreifiedRelationshipInstanceTuple
entryRuleUnreifiedRelationshipInstanceTuple
:
{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleRule()); }
	 ruleUnreifiedRelationshipInstanceTuple
{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleRule()); } 
	 EOF 
;

// Rule UnreifiedRelationshipInstanceTuple
ruleUnreifiedRelationshipInstanceTuple 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getGroup()); }
		(rule__UnreifiedRelationshipInstanceTuple__Group__0)
		{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReference
entryRuleReference
:
{ before(grammarAccess.getReferenceRule()); }
	 ruleReference
{ after(grammarAccess.getReferenceRule()); } 
	 EOF 
;

// Rule Reference
ruleReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReferenceAccess().getAlternatives()); }
		(rule__Reference__Alternatives)
		{ after(grammarAccess.getReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExternalReference
entryRuleExternalReference
:
{ before(grammarAccess.getExternalReferenceRule()); }
	 ruleExternalReference
{ after(grammarAccess.getExternalReferenceRule()); } 
	 EOF 
;

// Rule ExternalReference
ruleExternalReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExternalReferenceAccess().getIRITerminalRuleCall()); }
		RULE_IRI
		{ after(grammarAccess.getExternalReferenceAccess().getIRITerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQNAME
entryRuleQNAME
:
{ before(grammarAccess.getQNAMERule()); }
	 ruleQNAME
{ after(grammarAccess.getQNAMERule()); } 
	 EOF 
;

// Rule QNAME
ruleQNAME 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQNAMEAccess().getAlternatives()); }
		(rule__QNAME__Alternatives)
		{ after(grammarAccess.getQNAMEAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleValidID
entryRuleValidID
:
{ before(grammarAccess.getValidIDRule()); }
	 ruleValidID
{ after(grammarAccess.getValidIDRule()); } 
	 EOF 
;

// Rule ValidID
ruleValidID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); }
		RULE_ID
		{ after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralValue
entryRuleLiteralValue
:
{ before(grammarAccess.getLiteralValueRule()); }
	 ruleLiteralValue
{ after(grammarAccess.getLiteralValueRule()); } 
	 EOF 
;

// Rule LiteralValue
ruleLiteralValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralValueAccess().getAlternatives()); }
		(rule__LiteralValue__Alternatives)
		{ after(grammarAccess.getLiteralValueAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralBoolean
entryRuleLiteralBoolean
:
{ before(grammarAccess.getLiteralBooleanRule()); }
	 ruleLiteralBoolean
{ after(grammarAccess.getLiteralBooleanRule()); } 
	 EOF 
;

// Rule LiteralBoolean
ruleLiteralBoolean 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralBooleanAccess().getGroup()); }
		(rule__LiteralBoolean__Group__0)
		{ after(grammarAccess.getLiteralBooleanAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralDateTime
entryRuleLiteralDateTime
:
{ before(grammarAccess.getLiteralDateTimeRule()); }
	 ruleLiteralDateTime
{ after(grammarAccess.getLiteralDateTimeRule()); } 
	 EOF 
;

// Rule LiteralDateTime
ruleLiteralDateTime 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralDateTimeAccess().getGroup()); }
		(rule__LiteralDateTime__Group__0)
		{ after(grammarAccess.getLiteralDateTimeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralString
entryRuleLiteralString
:
{ before(grammarAccess.getLiteralStringRule()); }
	 ruleLiteralString
{ after(grammarAccess.getLiteralStringRule()); } 
	 EOF 
;

// Rule LiteralString
ruleLiteralString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralStringAccess().getAlternatives()); }
		(rule__LiteralString__Alternatives)
		{ after(grammarAccess.getLiteralStringAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralQuotedString
entryRuleLiteralQuotedString
:
{ before(grammarAccess.getLiteralQuotedStringRule()); }
	 ruleLiteralQuotedString
{ after(grammarAccess.getLiteralQuotedStringRule()); } 
	 EOF 
;

// Rule LiteralQuotedString
ruleLiteralQuotedString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralQuotedStringAccess().getGroup()); }
		(rule__LiteralQuotedString__Group__0)
		{ after(grammarAccess.getLiteralQuotedStringAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralRawString
entryRuleLiteralRawString
:
{ before(grammarAccess.getLiteralRawStringRule()); }
	 ruleLiteralRawString
{ after(grammarAccess.getLiteralRawStringRule()); } 
	 EOF 
;

// Rule LiteralRawString
ruleLiteralRawString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralRawStringAccess().getGroup()); }
		(rule__LiteralRawString__Group__0)
		{ after(grammarAccess.getLiteralRawStringAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUUIDDataType
entryRuleUUIDDataType
:
{ before(grammarAccess.getUUIDDataTypeRule()); }
	 ruleUUIDDataType
{ after(grammarAccess.getUUIDDataTypeRule()); } 
	 EOF 
;

// Rule UUIDDataType
ruleUUIDDataType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUUIDDataTypeAccess().getUUIDTerminalRuleCall()); }
		RULE_UUID
		{ after(grammarAccess.getUUIDDataTypeAccess().getUUIDTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralUUID
entryRuleLiteralUUID
:
{ before(grammarAccess.getLiteralUUIDRule()); }
	 ruleLiteralUUID
{ after(grammarAccess.getLiteralUUIDRule()); } 
	 EOF 
;

// Rule LiteralUUID
ruleLiteralUUID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralUUIDAccess().getGroup()); }
		(rule__LiteralUUID__Group__0)
		{ after(grammarAccess.getLiteralUUIDAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleURIDataType
entryRuleURIDataType
:
{ before(grammarAccess.getURIDataTypeRule()); }
	 ruleURIDataType
{ after(grammarAccess.getURIDataTypeRule()); } 
	 EOF 
;

// Rule URIDataType
ruleURIDataType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getURIDataTypeAccess().getURITerminalRuleCall()); }
		RULE_URI
		{ after(grammarAccess.getURIDataTypeAccess().getURITerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralURI
entryRuleLiteralURI
:
{ before(grammarAccess.getLiteralURIRule()); }
	 ruleLiteralURI
{ after(grammarAccess.getLiteralURIRule()); } 
	 EOF 
;

// Rule LiteralURI
ruleLiteralURI 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralURIAccess().getGroup()); }
		(rule__LiteralURI__Group__0)
		{ after(grammarAccess.getLiteralURIAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralNumber
entryRuleLiteralNumber
:
{ before(grammarAccess.getLiteralNumberRule()); }
	 ruleLiteralNumber
{ after(grammarAccess.getLiteralNumberRule()); } 
	 EOF 
;

// Rule LiteralNumber
ruleLiteralNumber 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralNumberAccess().getAlternatives()); }
		(rule__LiteralNumber__Alternatives)
		{ after(grammarAccess.getLiteralNumberAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralReal
entryRuleLiteralReal
:
{ before(grammarAccess.getLiteralRealRule()); }
	 ruleLiteralReal
{ after(grammarAccess.getLiteralRealRule()); } 
	 EOF 
;

// Rule LiteralReal
ruleLiteralReal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralRealAccess().getGroup()); }
		(rule__LiteralReal__Group__0)
		{ after(grammarAccess.getLiteralRealAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralRational
entryRuleLiteralRational
:
{ before(grammarAccess.getLiteralRationalRule()); }
	 ruleLiteralRational
{ after(grammarAccess.getLiteralRationalRule()); } 
	 EOF 
;

// Rule LiteralRational
ruleLiteralRational 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralRationalAccess().getGroup()); }
		(rule__LiteralRational__Group__0)
		{ after(grammarAccess.getLiteralRationalAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRationalDataType
entryRuleRationalDataType
:
{ before(grammarAccess.getRationalDataTypeRule()); }
	 ruleRationalDataType
{ after(grammarAccess.getRationalDataTypeRule()); } 
	 EOF 
;

// Rule RationalDataType
ruleRationalDataType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRationalDataTypeAccess().getRATIONALTerminalRuleCall()); }
		RULE_RATIONAL
		{ after(grammarAccess.getRationalDataTypeAccess().getRATIONALTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralFloat
entryRuleLiteralFloat
:
{ before(grammarAccess.getLiteralFloatRule()); }
	 ruleLiteralFloat
{ after(grammarAccess.getLiteralFloatRule()); } 
	 EOF 
;

// Rule LiteralFloat
ruleLiteralFloat 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralFloatAccess().getGroup()); }
		(rule__LiteralFloat__Group__0)
		{ after(grammarAccess.getLiteralFloatAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralDecimal
entryRuleLiteralDecimal
:
{ before(grammarAccess.getLiteralDecimalRule()); }
	 ruleLiteralDecimal
{ after(grammarAccess.getLiteralDecimalRule()); } 
	 EOF 
;

// Rule LiteralDecimal
ruleLiteralDecimal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralDecimalAccess().getAlternatives()); }
		(rule__LiteralDecimal__Alternatives)
		{ after(grammarAccess.getLiteralDecimalAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePositiveIntegerLiteral
entryRulePositiveIntegerLiteral
:
{ before(grammarAccess.getPositiveIntegerLiteralRule()); }
	 rulePositiveIntegerLiteral
{ after(grammarAccess.getPositiveIntegerLiteralRule()); } 
	 EOF 
;

// Rule PositiveIntegerLiteral
rulePositiveIntegerLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPositiveIntegerLiteralAccess().getDIGITSTerminalRuleCall()); }
		RULE_DIGITS
		{ after(grammarAccess.getPositiveIntegerLiteralAccess().getDIGITSTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule TerminologyKind
ruleTerminologyKind
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyKindAccess().getAlternatives()); }
		(rule__TerminologyKind__Alternatives)
		{ after(grammarAccess.getTerminologyKindAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule CardinalityRestrictionKind
ruleCardinalityRestrictionKind
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictionKindAccess().getAlternatives()); }
		(rule__CardinalityRestrictionKind__Alternatives)
		{ after(grammarAccess.getCardinalityRestrictionKindAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule DescriptionKind
ruleDescriptionKind
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionKindAccess().getAlternatives()); }
		(rule__DescriptionKind__Alternatives)
		{ after(grammarAccess.getDescriptionKindAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Module__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getModuleAccess().getTerminologyBoxParserRuleCall_0()); }
		ruleTerminologyBox
		{ after(grammarAccess.getModuleAccess().getTerminologyBoxParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getModuleAccess().getDescriptionBoxParserRuleCall_1()); }
		ruleDescriptionBox
		{ after(grammarAccess.getModuleAccess().getDescriptionBoxParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyBox__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyBoxAccess().getBundleParserRuleCall_0()); }
		ruleBundle
		{ after(grammarAccess.getTerminologyBoxAccess().getBundleParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyBoxAccess().getTerminologyGraphParserRuleCall_1()); }
		ruleTerminologyGraph
		{ after(grammarAccess.getTerminologyBoxAccess().getTerminologyGraphParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Alternatives_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsAssignment_6_0()); }
		(rule__TerminologyGraph__BoxAxiomsAssignment_6_0)
		{ after(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsAssignment_6_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getBoxStatementsAssignment_6_1()); }
		(rule__TerminologyGraph__BoxStatementsAssignment_6_1)
		{ after(grammarAccess.getTerminologyGraphAccess().getBoxStatementsAssignment_6_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Alternatives_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBoxAxiomsAssignment_6_0()); }
		(rule__Bundle__BoxAxiomsAssignment_6_0)
		{ after(grammarAccess.getBundleAccess().getBoxAxiomsAssignment_6_0()); }
	)
	|
	(
		{ before(grammarAccess.getBundleAccess().getBoxStatementsAssignment_6_1()); }
		(rule__Bundle__BoxStatementsAssignment_6_1)
		{ after(grammarAccess.getBundleAccess().getBoxStatementsAssignment_6_1()); }
	)
	|
	(
		{ before(grammarAccess.getBundleAccess().getBundleStatementsAssignment_6_2()); }
		(rule__Bundle__BundleStatementsAssignment_6_2)
		{ after(grammarAccess.getBundleAccess().getBundleStatementsAssignment_6_2()); }
	)
	|
	(
		{ before(grammarAccess.getBundleAccess().getBundleAxiomsAssignment_6_3()); }
		(rule__Bundle__BundleAxiomsAssignment_6_3)
		{ after(grammarAccess.getBundleAccess().getBundleAxiomsAssignment_6_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Alternatives_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsAssignment_6_0()); }
		(rule__DescriptionBox__ClosedWorldDefinitionsAssignment_6_0)
		{ after(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsAssignment_6_0()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsAssignment_6_1()); }
		(rule__DescriptionBox__DescriptionBoxRefinementsAssignment_6_1)
		{ after(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsAssignment_6_1()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getConceptInstancesAssignment_6_2()); }
		(rule__DescriptionBox__ConceptInstancesAssignment_6_2)
		{ after(grammarAccess.getDescriptionBoxAccess().getConceptInstancesAssignment_6_2()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesAssignment_6_3()); }
		(rule__DescriptionBox__ReifiedRelationshipInstancesAssignment_6_3)
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesAssignment_6_3()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsAssignment_6_4()); }
		(rule__DescriptionBox__ReifiedRelationshipInstanceDomainsAssignment_6_4)
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsAssignment_6_4()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesAssignment_6_5()); }
		(rule__DescriptionBox__ReifiedRelationshipInstanceRangesAssignment_6_5)
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesAssignment_6_5()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesAssignment_6_6()); }
		(rule__DescriptionBox__UnreifiedRelationshipInstanceTuplesAssignment_6_6)
		{ after(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesAssignment_6_6()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesAssignment_6_7()); }
		(rule__DescriptionBox__SingletonScalarDataPropertyValuesAssignment_6_7)
		{ after(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesAssignment_6_7()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesAssignment_6_8()); }
		(rule__DescriptionBox__SingletonStructuredDataPropertyValuesAssignment_6_8)
		{ after(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesAssignment_6_8()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyBoxAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyBoxAxiomAccess().getConceptDesignationTerminologyAxiomParserRuleCall_0()); }
		ruleConceptDesignationTerminologyAxiom
		{ after(grammarAccess.getTerminologyBoxAxiomAccess().getConceptDesignationTerminologyAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyExtensionAxiomParserRuleCall_1()); }
		ruleTerminologyExtensionAxiom
		{ after(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyExtensionAxiomParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyNestingAxiomParserRuleCall_2()); }
		ruleTerminologyNestingAxiom
		{ after(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyNestingAxiomParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyBoxStatement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyBoxStatementAccess().getTermAxiomParserRuleCall_0()); }
		ruleTermAxiom
		{ after(grammarAccess.getTerminologyBoxStatementAccess().getTermAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyBoxStatementAccess().getTermParserRuleCall_1()); }
		ruleTerm
		{ after(grammarAccess.getTerminologyBoxStatementAccess().getTermParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Term__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTermAccess().getAtomicEntityParserRuleCall_0()); }
		ruleAtomicEntity
		{ after(grammarAccess.getTermAccess().getAtomicEntityParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTermAccess().getEntityRelationshipParserRuleCall_1()); }
		ruleEntityRelationship
		{ after(grammarAccess.getTermAccess().getEntityRelationshipParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getTermAccess().getDatatypeParserRuleCall_2()); }
		ruleDatatype
		{ after(grammarAccess.getTermAccess().getDatatypeParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getTermAccess().getDataRelationshipParserRuleCall_3()); }
		ruleDataRelationship
		{ after(grammarAccess.getTermAccess().getDataRelationshipParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getTermAccess().getRuleParserRuleCall_4()); }
		ruleRule
		{ after(grammarAccess.getTermAccess().getRuleParserRuleCall_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AtomicEntity__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAtomicEntityAccess().getAspectParserRuleCall_0()); }
		ruleAspect
		{ after(grammarAccess.getAtomicEntityAccess().getAspectParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicEntityAccess().getCardinalityRestrictedAspectParserRuleCall_1()); }
		ruleCardinalityRestrictedAspect
		{ after(grammarAccess.getAtomicEntityAccess().getCardinalityRestrictedAspectParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicEntityAccess().getConceptParserRuleCall_2()); }
		ruleConcept
		{ after(grammarAccess.getAtomicEntityAccess().getConceptParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getAtomicEntityAccess().getCardinalityRestrictedConceptParserRuleCall_3()); }
		ruleCardinalityRestrictedConcept
		{ after(grammarAccess.getAtomicEntityAccess().getCardinalityRestrictedConceptParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityRelationship__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityRelationshipAccess().getReifiedRelationshipParserRuleCall_0()); }
		ruleReifiedRelationship
		{ after(grammarAccess.getEntityRelationshipAccess().getReifiedRelationshipParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getEntityRelationshipAccess().getReifiedRelationshipRestrictionParserRuleCall_1()); }
		ruleReifiedRelationshipRestriction
		{ after(grammarAccess.getEntityRelationshipAccess().getReifiedRelationshipRestrictionParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getEntityRelationshipAccess().getCardinalityRestrictedReifiedRelationshipParserRuleCall_2()); }
		ruleCardinalityRestrictedReifiedRelationship
		{ after(grammarAccess.getEntityRelationshipAccess().getCardinalityRestrictedReifiedRelationshipParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getEntityRelationshipAccess().getUnreifiedRelationshipParserRuleCall_3()); }
		ruleUnreifiedRelationship
		{ after(grammarAccess.getEntityRelationshipAccess().getUnreifiedRelationshipParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Datatype__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDatatypeAccess().getScalarDataRangeParserRuleCall_0()); }
		ruleScalarDataRange
		{ after(grammarAccess.getDatatypeAccess().getScalarDataRangeParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getDatatypeAccess().getStructureParserRuleCall_1()); }
		ruleStructure
		{ after(grammarAccess.getDatatypeAccess().getStructureParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataRange__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataRangeAccess().getScalarParserRuleCall_0()); }
		ruleScalar
		{ after(grammarAccess.getScalarDataRangeAccess().getScalarParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getScalarDataRangeAccess().getRestrictedDataRangeParserRuleCall_1()); }
		ruleRestrictedDataRange
		{ after(grammarAccess.getScalarDataRangeAccess().getRestrictedDataRangeParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictedDataRange__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getBinaryScalarRestrictionParserRuleCall_0()); }
		ruleBinaryScalarRestriction
		{ after(grammarAccess.getRestrictedDataRangeAccess().getBinaryScalarRestrictionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getIRIScalarRestrictionParserRuleCall_1()); }
		ruleIRIScalarRestriction
		{ after(grammarAccess.getRestrictedDataRangeAccess().getIRIScalarRestrictionParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getNumericScalarRestrictionParserRuleCall_2()); }
		ruleNumericScalarRestriction
		{ after(grammarAccess.getRestrictedDataRangeAccess().getNumericScalarRestrictionParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getPlainLiteralScalarRestrictionParserRuleCall_3()); }
		rulePlainLiteralScalarRestriction
		{ after(grammarAccess.getRestrictedDataRangeAccess().getPlainLiteralScalarRestrictionParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getScalarOneOfRestrictionParserRuleCall_4()); }
		ruleScalarOneOfRestriction
		{ after(grammarAccess.getRestrictedDataRangeAccess().getScalarOneOfRestrictionParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getStringScalarRestrictionParserRuleCall_5()); }
		ruleStringScalarRestriction
		{ after(grammarAccess.getRestrictedDataRangeAccess().getStringScalarRestrictionParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getSynonymScalarRestrictionParserRuleCall_6()); }
		ruleSynonymScalarRestriction
		{ after(grammarAccess.getRestrictedDataRangeAccess().getSynonymScalarRestrictionParserRuleCall_6()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictedDataRangeAccess().getTimeScalarRestrictionParserRuleCall_7()); }
		ruleTimeScalarRestriction
		{ after(grammarAccess.getRestrictedDataRangeAccess().getTimeScalarRestrictionParserRuleCall_7()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DataRelationship__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDataRelationshipAccess().getEntityStructuredDataPropertyParserRuleCall_0()); }
		ruleEntityStructuredDataProperty
		{ after(grammarAccess.getDataRelationshipAccess().getEntityStructuredDataPropertyParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getDataRelationshipAccess().getEntityScalarDataPropertyParserRuleCall_1()); }
		ruleEntityScalarDataProperty
		{ after(grammarAccess.getDataRelationshipAccess().getEntityScalarDataPropertyParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getDataRelationshipAccess().getStructuredDataPropertyParserRuleCall_2()); }
		ruleStructuredDataProperty
		{ after(grammarAccess.getDataRelationshipAccess().getStructuredDataPropertyParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getDataRelationshipAccess().getScalarDataPropertyParserRuleCall_3()); }
		ruleScalarDataProperty
		{ after(grammarAccess.getDataRelationshipAccess().getScalarDataPropertyParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TermAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTermAxiomAccess().getEntityRestrictionAxiomParserRuleCall_0()); }
		ruleEntityRestrictionAxiom
		{ after(grammarAccess.getTermAxiomAccess().getEntityRestrictionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTermAxiomAccess().getEntityScalarDataPropertyRestrictionAxiomParserRuleCall_1()); }
		ruleEntityScalarDataPropertyRestrictionAxiom
		{ after(grammarAccess.getTermAxiomAccess().getEntityScalarDataPropertyRestrictionAxiomParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getTermAxiomAccess().getEntityStructuredDataPropertyRestrictionAxiomParserRuleCall_2()); }
		ruleEntityStructuredDataPropertyRestrictionAxiom
		{ after(grammarAccess.getTermAxiomAccess().getEntityStructuredDataPropertyRestrictionAxiomParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getTermAxiomAccess().getScalarOneOfLiteralAxiomParserRuleCall_3()); }
		ruleScalarOneOfLiteralAxiom
		{ after(grammarAccess.getTermAxiomAccess().getScalarOneOfLiteralAxiomParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getTermAxiomAccess().getSpecializationAxiomParserRuleCall_4()); }
		ruleSpecializationAxiom
		{ after(grammarAccess.getTermAxiomAccess().getSpecializationAxiomParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getTermAxiomAccess().getSubObjectPropertyOfAxiomParserRuleCall_5()); }
		ruleSubObjectPropertyOfAxiom
		{ after(grammarAccess.getTermAxiomAccess().getSubObjectPropertyOfAxiomParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getTermAxiomAccess().getSubDataPropertyOfAxiomParserRuleCall_6()); }
		ruleSubDataPropertyOfAxiom
		{ after(grammarAccess.getTermAxiomAccess().getSubDataPropertyOfAxiomParserRuleCall_6()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityRestrictionAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityRestrictionAxiomAccess().getEntityExistentialRestrictionAxiomParserRuleCall_0()); }
		ruleEntityExistentialRestrictionAxiom
		{ after(grammarAccess.getEntityRestrictionAxiomAccess().getEntityExistentialRestrictionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getEntityRestrictionAxiomAccess().getEntityUniversalRestrictionAxiomParserRuleCall_1()); }
		ruleEntityUniversalRestrictionAxiom
		{ after(grammarAccess.getEntityRestrictionAxiomAccess().getEntityUniversalRestrictionAxiomParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyRestrictionAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyExistentialRestrictionAxiomParserRuleCall_0()); }
		ruleEntityScalarDataPropertyExistentialRestrictionAxiom
		{ after(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyExistentialRestrictionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyParticularRestrictionAxiomParserRuleCall_1()); }
		ruleEntityScalarDataPropertyParticularRestrictionAxiom
		{ after(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyParticularRestrictionAxiomParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyUniversalRestrictionAxiomParserRuleCall_2()); }
		ruleEntityScalarDataPropertyUniversalRestrictionAxiom
		{ after(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyUniversalRestrictionAxiomParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecializationAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSpecializationAxiomAccess().getConceptSpecializationAxiomParserRuleCall_0()); }
		ruleConceptSpecializationAxiom
		{ after(grammarAccess.getSpecializationAxiomAccess().getConceptSpecializationAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializationAxiomAccess().getAspectSpecializationAxiomParserRuleCall_1()); }
		ruleAspectSpecializationAxiom
		{ after(grammarAccess.getSpecializationAxiomAccess().getAspectSpecializationAxiomParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getSpecializationAxiomAccess().getReifiedRelationshipSpecializationAxiomParserRuleCall_2()); }
		ruleReifiedRelationshipSpecializationAxiom
		{ after(grammarAccess.getSpecializationAxiomAccess().getReifiedRelationshipSpecializationAxiomParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DisjointUnionOfConceptsAxiom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getAnonymousConceptUnionAxiomParserRuleCall_0()); }
		ruleAnonymousConceptUnionAxiom
		{ after(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getAnonymousConceptUnionAxiomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getSpecificDisjointConceptAxiomParserRuleCall_1()); }
		ruleSpecificDisjointConceptAxiom
		{ after(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getSpecificDisjointConceptAxiomParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getPredicateAssignment_0()); }
		(rule__SegmentPredicate__PredicateAssignment_0)
		{ after(grammarAccess.getSegmentPredicateAccess().getPredicateAssignment_0()); }
	)
	|
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getGroup_1()); }
		(rule__SegmentPredicate__Group_1__0)
		{ after(grammarAccess.getSegmentPredicateAccess().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getGroup_2()); }
		(rule__SegmentPredicate__Group_2__0)
		{ after(grammarAccess.getSegmentPredicateAccess().getGroup_2()); }
	)
	|
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getGroup_3()); }
		(rule__SegmentPredicate__Group_3__0)
		{ after(grammarAccess.getSegmentPredicateAccess().getGroup_3()); }
	)
	|
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getGroup_4()); }
		(rule__SegmentPredicate__Group_4__0)
		{ after(grammarAccess.getSegmentPredicateAccess().getGroup_4()); }
	)
	|
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getGroup_5()); }
		(rule__SegmentPredicate__Group_5__0)
		{ after(grammarAccess.getSegmentPredicateAccess().getGroup_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Alternatives_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsAssignment_7_0()); }
		(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyRestrictionsAssignment_7_0)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsAssignment_7_0()); }
	)
	|
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsAssignment_7_1()); }
		(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__ScalarDataPropertyRestrictionsAssignment_7_1)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsAssignment_7_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Alternatives_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsAssignment_4_0()); }
		(rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyRestrictionsAssignment_4_0)
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsAssignment_4_0()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsAssignment_4_1()); }
		(rule__RestrictionStructuredDataPropertyTuple__ScalarDataPropertyRestrictionsAssignment_4_1)
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsAssignment_4_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptualEntitySingletonInstance__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptualEntitySingletonInstanceAccess().getConceptInstanceParserRuleCall_0()); }
		ruleConceptInstance
		{ after(grammarAccess.getConceptualEntitySingletonInstanceAccess().getConceptInstanceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getConceptualEntitySingletonInstanceAccess().getReifiedRelationshipInstanceParserRuleCall_1()); }
		ruleReifiedRelationshipInstance
		{ after(grammarAccess.getConceptualEntitySingletonInstanceAccess().getReifiedRelationshipInstanceParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Alternatives_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesAssignment_6_0()); }
		(rule__SingletonInstanceStructuredDataPropertyValue__StructuredPropertyTuplesAssignment_6_0)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesAssignment_6_0()); }
	)
	|
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesAssignment_6_1()); }
		(rule__SingletonInstanceStructuredDataPropertyValue__ScalarDataPropertyValuesAssignment_6_1)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesAssignment_6_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Alternatives_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_4_0()); }
		(rule__StructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_4_0)
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_4_0()); }
	)
	|
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_4_1()); }
		(rule__StructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_4_1)
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_4_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0()); }
		RULE_IRI
		{ after(grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getReferenceAccess().getQNAMEParserRuleCall_1()); }
		ruleQNAME
		{ after(grammarAccess.getReferenceAccess().getQNAMEParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__QNAME__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0()); }
		RULE_ABBREV_IRI
		{ after(grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getQNAMEAccess().getValidIDParserRuleCall_1()); }
		ruleValidID
		{ after(grammarAccess.getQNAMEAccess().getValidIDParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralValue__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralValueAccess().getLiteralBooleanParserRuleCall_0()); }
		ruleLiteralBoolean
		{ after(grammarAccess.getLiteralValueAccess().getLiteralBooleanParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralValueAccess().getLiteralDateTimeParserRuleCall_1()); }
		ruleLiteralDateTime
		{ after(grammarAccess.getLiteralValueAccess().getLiteralDateTimeParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralValueAccess().getLiteralStringParserRuleCall_2()); }
		ruleLiteralString
		{ after(grammarAccess.getLiteralValueAccess().getLiteralStringParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralValueAccess().getLiteralUUIDParserRuleCall_3()); }
		ruleLiteralUUID
		{ after(grammarAccess.getLiteralValueAccess().getLiteralUUIDParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralValueAccess().getLiteralURIParserRuleCall_4()); }
		ruleLiteralURI
		{ after(grammarAccess.getLiteralValueAccess().getLiteralURIParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralValueAccess().getLiteralNumberParserRuleCall_5()); }
		ruleLiteralNumber
		{ after(grammarAccess.getLiteralValueAccess().getLiteralNumberParserRuleCall_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralBoolean__BoolAlternatives_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralBooleanAccess().getBoolTRUETerminalRuleCall_1_0_0()); }
		RULE_TRUE
		{ after(grammarAccess.getLiteralBooleanAccess().getBoolTRUETerminalRuleCall_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralBooleanAccess().getBoolFALSETerminalRuleCall_1_0_1()); }
		RULE_FALSE
		{ after(grammarAccess.getLiteralBooleanAccess().getBoolFALSETerminalRuleCall_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralString__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralStringAccess().getLiteralQuotedStringParserRuleCall_0()); }
		ruleLiteralQuotedString
		{ after(grammarAccess.getLiteralStringAccess().getLiteralQuotedStringParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralStringAccess().getLiteralRawStringParserRuleCall_1()); }
		ruleLiteralRawString
		{ after(grammarAccess.getLiteralStringAccess().getLiteralRawStringParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralNumber__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralNumberAccess().getLiteralRealParserRuleCall_0()); }
		ruleLiteralReal
		{ after(grammarAccess.getLiteralNumberAccess().getLiteralRealParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralNumberAccess().getLiteralRationalParserRuleCall_1()); }
		ruleLiteralRational
		{ after(grammarAccess.getLiteralNumberAccess().getLiteralRationalParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralNumberAccess().getLiteralFloatParserRuleCall_2()); }
		ruleLiteralFloat
		{ after(grammarAccess.getLiteralNumberAccess().getLiteralFloatParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralNumberAccess().getLiteralDecimalParserRuleCall_3()); }
		ruleLiteralDecimal
		{ after(grammarAccess.getLiteralNumberAccess().getLiteralDecimalParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDecimal__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralDecimalAccess().getGroup_0()); }
		(rule__LiteralDecimal__Group_0__0)
		{ after(grammarAccess.getLiteralDecimalAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralDecimalAccess().getDecimalAssignment_1()); }
		(rule__LiteralDecimal__DecimalAssignment_1)
		{ after(grammarAccess.getLiteralDecimalAccess().getDecimalAssignment_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyKind__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0()); }
		('open')
		{ after(grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyKindAccess().getClosedWorldDesignationsEnumLiteralDeclaration_1()); }
		('closed')
		{ after(grammarAccess.getTerminologyKindAccess().getClosedWorldDesignationsEnumLiteralDeclaration_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictionKind__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictionKindAccess().getMinEnumLiteralDeclaration_0()); }
		('<=')
		{ after(grammarAccess.getCardinalityRestrictionKindAccess().getMinEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getCardinalityRestrictionKindAccess().getMaxEnumLiteralDeclaration_1()); }
		('>=')
		{ after(grammarAccess.getCardinalityRestrictionKindAccess().getMaxEnumLiteralDeclaration_1()); }
	)
	|
	(
		{ before(grammarAccess.getCardinalityRestrictionKindAccess().getExactEnumLiteralDeclaration_2()); }
		('==')
		{ after(grammarAccess.getCardinalityRestrictionKindAccess().getExactEnumLiteralDeclaration_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionKind__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0()); }
		('final')
		{ after(grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionKindAccess().getPartialEnumLiteralDeclaration_1()); }
		('partial')
		{ after(grammarAccess.getDescriptionKindAccess().getPartialEnumLiteralDeclaration_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Extent__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Extent__Group__0__Impl
	rule__Extent__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Extent__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExtentAccess().getExtentAction_0()); }
	()
	{ after(grammarAccess.getExtentAccess().getExtentAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Extent__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Extent__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Extent__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExtentAccess().getModulesAssignment_1()); }
	(rule__Extent__ModulesAssignment_1)*
	{ after(grammarAccess.getExtentAccess().getModulesAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationProperty__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__0__Impl
	rule__AnnotationProperty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getAnnotationPropertyKeyword_0()); }
	'annotationProperty'
	{ after(grammarAccess.getAnnotationPropertyAccess().getAnnotationPropertyKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__1__Impl
	rule__AnnotationProperty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIAssignment_1()); }
	(rule__AnnotationProperty__AbbrevIRIAssignment_1)
	{ after(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__2__Impl
	rule__AnnotationProperty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getAnnotationPropertyAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationProperty__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyAccess().getIriAssignment_3()); }
	(rule__AnnotationProperty__IriAssignment_3)
	{ after(grammarAccess.getAnnotationPropertyAccess().getIriAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationPropertyValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyValue__Group__0__Impl
	rule__AnnotationPropertyValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyValueAccess().getCommercialAtKeyword_0()); }
	'@'
	{ after(grammarAccess.getAnnotationPropertyValueAccess().getCommercialAtKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyValue__Group__1__Impl
	rule__AnnotationPropertyValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAssignment_1()); }
	(rule__AnnotationPropertyValue__PropertyAssignment_1)
	{ after(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyValue__Group__2__Impl
	rule__AnnotationPropertyValue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyValueAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getAnnotationPropertyValueAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationPropertyValue__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationPropertyValueAccess().getValueAssignment_3()); }
	(rule__AnnotationPropertyValue__ValueAssignment_3)
	{ after(grammarAccess.getAnnotationPropertyValueAccess().getValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminologyGraph__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyGraph__Group__0__Impl
	rule__TerminologyGraph__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyGraphAccess().getAnnotationPropertiesAssignment_0()); }
	(rule__TerminologyGraph__AnnotationPropertiesAssignment_0)*
	{ after(grammarAccess.getTerminologyGraphAccess().getAnnotationPropertiesAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyGraph__Group__1__Impl
	rule__TerminologyGraph__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_1()); }
	(rule__TerminologyGraph__AnnotationsAssignment_1)*
	{ after(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyGraph__Group__2__Impl
	rule__TerminologyGraph__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyGraphAccess().getKindAssignment_2()); }
	(rule__TerminologyGraph__KindAssignment_2)
	{ after(grammarAccess.getTerminologyGraphAccess().getKindAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyGraph__Group__3__Impl
	rule__TerminologyGraph__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_3()); }
	'terminology'
	{ after(grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyGraph__Group__4__Impl
	rule__TerminologyGraph__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyGraphAccess().getIriAssignment_4()); }
	(rule__TerminologyGraph__IriAssignment_4)
	{ after(grammarAccess.getTerminologyGraphAccess().getIriAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyGraph__Group__5__Impl
	rule__TerminologyGraph__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_5()); }
	'{'
	{ after(grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyGraph__Group__6__Impl
	rule__TerminologyGraph__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyGraphAccess().getAlternatives_6()); }
	(rule__TerminologyGraph__Alternatives_6)*
	{ after(grammarAccess.getTerminologyGraphAccess().getAlternatives_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyGraph__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Bundle__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__0__Impl
	rule__Bundle__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getAnnotationPropertiesAssignment_0()); }
	(rule__Bundle__AnnotationPropertiesAssignment_0)*
	{ after(grammarAccess.getBundleAccess().getAnnotationPropertiesAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__1__Impl
	rule__Bundle__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getAnnotationsAssignment_1()); }
	(rule__Bundle__AnnotationsAssignment_1)*
	{ after(grammarAccess.getBundleAccess().getAnnotationsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__2__Impl
	rule__Bundle__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getKindAssignment_2()); }
	(rule__Bundle__KindAssignment_2)
	{ after(grammarAccess.getBundleAccess().getKindAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__3__Impl
	rule__Bundle__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getBundleKeyword_3()); }
	'bundle'
	{ after(grammarAccess.getBundleAccess().getBundleKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__4__Impl
	rule__Bundle__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getIriAssignment_4()); }
	(rule__Bundle__IriAssignment_4)
	{ after(grammarAccess.getBundleAccess().getIriAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__5__Impl
	rule__Bundle__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_5()); }
	'{'
	{ after(grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__6__Impl
	rule__Bundle__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getAlternatives_6()); }
	(rule__Bundle__Alternatives_6)*
	{ after(grammarAccess.getBundleAccess().getAlternatives_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Bundle__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DescriptionBox__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBox__Group__0__Impl
	rule__DescriptionBox__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxAccess().getAnnotationPropertiesAssignment_0()); }
	(rule__DescriptionBox__AnnotationPropertiesAssignment_0)*
	{ after(grammarAccess.getDescriptionBoxAccess().getAnnotationPropertiesAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBox__Group__1__Impl
	rule__DescriptionBox__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_1()); }
	(rule__DescriptionBox__AnnotationsAssignment_1)*
	{ after(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBox__Group__2__Impl
	rule__DescriptionBox__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxAccess().getKindAssignment_2()); }
	(rule__DescriptionBox__KindAssignment_2)
	{ after(grammarAccess.getDescriptionBoxAccess().getKindAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBox__Group__3__Impl
	rule__DescriptionBox__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_3()); }
	'descriptionBox'
	{ after(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBox__Group__4__Impl
	rule__DescriptionBox__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxAccess().getIriAssignment_4()); }
	(rule__DescriptionBox__IriAssignment_4)
	{ after(grammarAccess.getDescriptionBoxAccess().getIriAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBox__Group__5__Impl
	rule__DescriptionBox__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_5()); }
	'{'
	{ after(grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBox__Group__6__Impl
	rule__DescriptionBox__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxAccess().getAlternatives_6()); }
	(rule__DescriptionBox__Alternatives_6)*
	{ after(grammarAccess.getDescriptionBoxAccess().getAlternatives_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBox__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BundledTerminologyAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundledTerminologyAxiom__Group__0__Impl
	rule__BundledTerminologyAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BundledTerminologyAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundledTerminologyAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__BundledTerminologyAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getBundledTerminologyAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundledTerminologyAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundledTerminologyAxiom__Group__1__Impl
	rule__BundledTerminologyAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BundledTerminologyAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_1()); }
	'bundles'
	{ after(grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundledTerminologyAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BundledTerminologyAxiom__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BundledTerminologyAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyAssignment_2()); }
	(rule__BundledTerminologyAxiom__BundledTerminologyAssignment_2)
	{ after(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptDesignationTerminologyAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptDesignationTerminologyAxiom__Group__0__Impl
	rule__ConceptDesignationTerminologyAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__ConceptDesignationTerminologyAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptDesignationTerminologyAxiom__Group__1__Impl
	rule__ConceptDesignationTerminologyAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_1()); }
	'conceptDesignationTerminologyAxiom'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptDesignationTerminologyAxiom__Group__2__Impl
	rule__ConceptDesignationTerminologyAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptDesignationTerminologyAxiom__Group__3__Impl
	rule__ConceptDesignationTerminologyAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_3()); }
	'designatedTerminology'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptDesignationTerminologyAxiom__Group__4__Impl
	rule__ConceptDesignationTerminologyAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyAssignment_4()); }
	(rule__ConceptDesignationTerminologyAxiom__DesignatedTerminologyAssignment_4)
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptDesignationTerminologyAxiom__Group__5__Impl
	rule__ConceptDesignationTerminologyAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_5()); }
	'designatedConcept'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptDesignationTerminologyAxiom__Group__6__Impl
	rule__ConceptDesignationTerminologyAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptAssignment_6()); }
	(rule__ConceptDesignationTerminologyAxiom__DesignatedConceptAssignment_6)
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptDesignationTerminologyAxiom__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminologyExtensionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyExtensionAxiom__Group__0__Impl
	rule__TerminologyExtensionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyExtensionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__TerminologyExtensionAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyExtensionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyExtensionAxiom__Group__1__Impl
	rule__TerminologyExtensionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyExtensionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_1()); }
	'extends'
	{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyExtensionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyExtensionAxiom__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyExtensionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyAssignment_2()); }
	(rule__TerminologyExtensionAxiom__ExtendedTerminologyAssignment_2)
	{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminologyNestingAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyNestingAxiom__Group__0__Impl
	rule__TerminologyNestingAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__TerminologyNestingAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyNestingAxiom__Group__1__Impl
	rule__TerminologyNestingAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_1()); }
	'terminologyNestingAxiom'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyNestingAxiom__Group__2__Impl
	rule__TerminologyNestingAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyNestingAxiom__Group__3__Impl
	rule__TerminologyNestingAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_3()); }
	'nestingTerminology'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyNestingAxiom__Group__4__Impl
	rule__TerminologyNestingAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyAssignment_4()); }
	(rule__TerminologyNestingAxiom__NestingTerminologyAssignment_4)
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyNestingAxiom__Group__5__Impl
	rule__TerminologyNestingAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_5()); }
	'nestingContext'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyNestingAxiom__Group__6__Impl
	rule__TerminologyNestingAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextAssignment_6()); }
	(rule__TerminologyNestingAxiom__NestingContextAssignment_6)
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminologyNestingAxiom__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Aspect__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__0__Impl
	rule__Aspect__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getAnnotationsAssignment_0()); }
	(rule__Aspect__AnnotationsAssignment_0)*
	{ after(grammarAccess.getAspectAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__1__Impl
	rule__Aspect__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getAspectKeyword_1()); }
	'aspect'
	{ after(grammarAccess.getAspectAccess().getAspectKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getNameAssignment_2()); }
	(rule__Aspect__NameAssignment_2)
	{ after(grammarAccess.getAspectAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CardinalityRestrictedAspect__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group__0__Impl
	rule__CardinalityRestrictedAspect__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getAnnotationsAssignment_0()); }
	(rule__CardinalityRestrictedAspect__AnnotationsAssignment_0)*
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group__1__Impl
	rule__CardinalityRestrictedAspect__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getAspectKeyword_1()); }
	'aspect'
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getAspectKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group__2__Impl
	rule__CardinalityRestrictedAspect__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getNameAssignment_2()); }
	(rule__CardinalityRestrictedAspect__NameAssignment_2)
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group__3__Impl
	rule__CardinalityRestrictedAspect__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictionKindAssignment_3()); }
	(rule__CardinalityRestrictedAspect__RestrictionKindAssignment_3)
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictionKindAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group__4__Impl
	rule__CardinalityRestrictedAspect__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedCardinalityAssignment_4()); }
	(rule__CardinalityRestrictedAspect__RestrictedCardinalityAssignment_4)
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedCardinalityAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group__5__Impl
	rule__CardinalityRestrictedAspect__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRelationshipAssignment_5()); }
	(rule__CardinalityRestrictedAspect__RestrictedRelationshipAssignment_5)
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRelationshipAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getGroup_6()); }
	(rule__CardinalityRestrictedAspect__Group_6__0)?
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CardinalityRestrictedAspect__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group_6__0__Impl
	rule__CardinalityRestrictedAspect__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getFullStopKeyword_6_0()); }
	'.'
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getFullStopKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedAspect__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRangeAssignment_6_1()); }
	(rule__CardinalityRestrictedAspect__RestrictedRangeAssignment_6_1)
	{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRangeAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Concept__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group__0__Impl
	rule__Concept__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getAnnotationsAssignment_0()); }
	(rule__Concept__AnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group__1__Impl
	rule__Concept__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getConceptKeyword_1()); }
	'concept'
	{ after(grammarAccess.getConceptAccess().getConceptKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Concept__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptAccess().getNameAssignment_2()); }
	(rule__Concept__NameAssignment_2)
	{ after(grammarAccess.getConceptAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CardinalityRestrictedConcept__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group__0__Impl
	rule__CardinalityRestrictedConcept__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getAnnotationsAssignment_0()); }
	(rule__CardinalityRestrictedConcept__AnnotationsAssignment_0)*
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group__1__Impl
	rule__CardinalityRestrictedConcept__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getConceptKeyword_1()); }
	'concept'
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getConceptKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group__2__Impl
	rule__CardinalityRestrictedConcept__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getNameAssignment_2()); }
	(rule__CardinalityRestrictedConcept__NameAssignment_2)
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group__3__Impl
	rule__CardinalityRestrictedConcept__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictionKindAssignment_3()); }
	(rule__CardinalityRestrictedConcept__RestrictionKindAssignment_3)
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictionKindAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group__4__Impl
	rule__CardinalityRestrictedConcept__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedCardinalityAssignment_4()); }
	(rule__CardinalityRestrictedConcept__RestrictedCardinalityAssignment_4)
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedCardinalityAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group__5__Impl
	rule__CardinalityRestrictedConcept__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRelationshipAssignment_5()); }
	(rule__CardinalityRestrictedConcept__RestrictedRelationshipAssignment_5)
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRelationshipAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getGroup_6()); }
	(rule__CardinalityRestrictedConcept__Group_6__0)?
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CardinalityRestrictedConcept__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group_6__0__Impl
	rule__CardinalityRestrictedConcept__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getFullStopKeyword_6_0()); }
	'.'
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getFullStopKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedConcept__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRangeAssignment_6_1()); }
	(rule__CardinalityRestrictedConcept__RestrictedRangeAssignment_6_1)
	{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRangeAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationship__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__0__Impl
	rule__ReifiedRelationship__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getAnnotationsAssignment_0()); }
	(rule__ReifiedRelationship__AnnotationsAssignment_0)*
	{ after(grammarAccess.getReifiedRelationshipAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__1__Impl
	rule__ReifiedRelationship__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_1()); }
	'reifiedRelationship'
	{ after(grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__2__Impl
	rule__ReifiedRelationship__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getNameAssignment_2()); }
	(rule__ReifiedRelationship__NameAssignment_2)
	{ after(grammarAccess.getReifiedRelationshipAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__3__Impl
	rule__ReifiedRelationship__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__4__Impl
	rule__ReifiedRelationship__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4()); }
	(rule__ReifiedRelationship__UnorderedGroup_4)
	{ after(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__5__Impl
	rule__ReifiedRelationship__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_5()); }
	'unreified'
	{ after(grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__6__Impl
	rule__ReifiedRelationship__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_6()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__7__Impl
	rule__ReifiedRelationship__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getForwardPropertyAssignment_7()); }
	(rule__ReifiedRelationship__ForwardPropertyAssignment_7)
	{ after(grammarAccess.getReifiedRelationshipAccess().getForwardPropertyAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__8__Impl
	rule__ReifiedRelationship__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getGroup_8()); }
	(rule__ReifiedRelationship__Group_8__0)?
	{ after(grammarAccess.getReifiedRelationshipAccess().getGroup_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__9__Impl
	rule__ReifiedRelationship__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_9()); }
	'source'
	{ after(grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__10__Impl
	rule__ReifiedRelationship__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_10()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__11__Impl
	rule__ReifiedRelationship__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getSourceAssignment_11()); }
	(rule__ReifiedRelationship__SourceAssignment_11)
	{ after(grammarAccess.getReifiedRelationshipAccess().getSourceAssignment_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__12
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__12__Impl
	rule__ReifiedRelationship__Group__13
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__12__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_12()); }
	'target'
	{ after(grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_12()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__13
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__13__Impl
	rule__ReifiedRelationship__Group__14
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__13__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_13()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_13()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__14
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__14__Impl
	rule__ReifiedRelationship__Group__15
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__14__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getTargetAssignment_14()); }
	(rule__ReifiedRelationship__TargetAssignment_14)
	{ after(grammarAccess.getReifiedRelationshipAccess().getTargetAssignment_14()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__15
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group__15__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group__15__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getRightCurlyBracketKeyword_15()); }
	'}'
	{ after(grammarAccess.getReifiedRelationshipAccess().getRightCurlyBracketKeyword_15()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationship__Group_8__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group_8__0__Impl
	rule__ReifiedRelationship__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_8__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_8_0()); }
	'inverse'
	{ after(grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_8_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_8__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group_8__1__Impl
	rule__ReifiedRelationship__Group_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_8__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_8_1()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_8_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_8__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group_8__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_8__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getInversePropertyAssignment_8_2()); }
	(rule__ReifiedRelationship__InversePropertyAssignment_8_2)
	{ after(grammarAccess.getReifiedRelationshipAccess().getInversePropertyAssignment_8_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationshipRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__0__Impl
	rule__ReifiedRelationshipRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__ReifiedRelationshipRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__1__Impl
	rule__ReifiedRelationshipRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getReifiedRelationshipRestrictionKeyword_1()); }
	'reifiedRelationshipRestriction'
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getReifiedRelationshipRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__2__Impl
	rule__ReifiedRelationshipRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getNameAssignment_2()); }
	(rule__ReifiedRelationshipRestriction__NameAssignment_2)
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__3__Impl
	rule__ReifiedRelationshipRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__4__Impl
	rule__ReifiedRelationshipRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceKeyword_4()); }
	'source'
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__5__Impl
	rule__ReifiedRelationshipRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getEqualsSignKeyword_5()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getEqualsSignKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__6__Impl
	rule__ReifiedRelationshipRestriction__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceAssignment_6()); }
	(rule__ReifiedRelationshipRestriction__SourceAssignment_6)
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__7__Impl
	rule__ReifiedRelationshipRestriction__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetKeyword_7()); }
	'target'
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__8__Impl
	rule__ReifiedRelationshipRestriction__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getEqualsSignKeyword_8()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getEqualsSignKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__9__Impl
	rule__ReifiedRelationshipRestriction__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetAssignment_9()); }
	(rule__ReifiedRelationshipRestriction__TargetAssignment_9)
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetAssignment_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipRestriction__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getRightCurlyBracketKeyword_10()); }
	'}'
	{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getRightCurlyBracketKeyword_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CardinalityRestrictedReifiedRelationship__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group__0__Impl
	rule__CardinalityRestrictedReifiedRelationship__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getAnnotationsAssignment_0()); }
	(rule__CardinalityRestrictedReifiedRelationship__AnnotationsAssignment_0)*
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group__1__Impl
	rule__CardinalityRestrictedReifiedRelationship__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getReifiedRelationshipKeyword_1()); }
	'reifiedRelationship'
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getReifiedRelationshipKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group__2__Impl
	rule__CardinalityRestrictedReifiedRelationship__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getNameAssignment_2()); }
	(rule__CardinalityRestrictedReifiedRelationship__NameAssignment_2)
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group__3__Impl
	rule__CardinalityRestrictedReifiedRelationship__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictionKindAssignment_3()); }
	(rule__CardinalityRestrictedReifiedRelationship__RestrictionKindAssignment_3)
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictionKindAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group__4__Impl
	rule__CardinalityRestrictedReifiedRelationship__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedCardinalityAssignment_4()); }
	(rule__CardinalityRestrictedReifiedRelationship__RestrictedCardinalityAssignment_4)
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedCardinalityAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group__5__Impl
	rule__CardinalityRestrictedReifiedRelationship__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRelationshipAssignment_5()); }
	(rule__CardinalityRestrictedReifiedRelationship__RestrictedRelationshipAssignment_5)
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRelationshipAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getGroup_6()); }
	(rule__CardinalityRestrictedReifiedRelationship__Group_6__0)?
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CardinalityRestrictedReifiedRelationship__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group_6__0__Impl
	rule__CardinalityRestrictedReifiedRelationship__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getFullStopKeyword_6_0()); }
	'.'
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getFullStopKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CardinalityRestrictedReifiedRelationship__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRangeAssignment_6_1()); }
	(rule__CardinalityRestrictedReifiedRelationship__RestrictedRangeAssignment_6_1)
	{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRangeAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UnreifiedRelationship__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__0__Impl
	rule__UnreifiedRelationship__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAssignment_0()); }
	(rule__UnreifiedRelationship__AnnotationsAssignment_0)*
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__1__Impl
	rule__UnreifiedRelationship__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_1()); }
	'unreifiedRelationship'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__2__Impl
	rule__UnreifiedRelationship__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getNameAssignment_2()); }
	(rule__UnreifiedRelationship__NameAssignment_2)
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__3__Impl
	rule__UnreifiedRelationship__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__4__Impl
	rule__UnreifiedRelationship__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4()); }
	(rule__UnreifiedRelationship__UnorderedGroup_4)
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__5__Impl
	rule__UnreifiedRelationship__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_5()); }
	'source'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__6__Impl
	rule__UnreifiedRelationship__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_6()); }
	'='
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__7__Impl
	rule__UnreifiedRelationship__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getSourceAssignment_7()); }
	(rule__UnreifiedRelationship__SourceAssignment_7)
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getSourceAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__8__Impl
	rule__UnreifiedRelationship__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_8()); }
	'target'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__9__Impl
	rule__UnreifiedRelationship__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_9()); }
	'='
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__10__Impl
	rule__UnreifiedRelationship__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getTargetAssignment_10()); }
	(rule__UnreifiedRelationship__TargetAssignment_10)
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getTargetAssignment_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__Group__11__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__Group__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getRightCurlyBracketKeyword_11()); }
	'}'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getRightCurlyBracketKeyword_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Scalar__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scalar__Group__0__Impl
	rule__Scalar__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarAccess().getAnnotationsAssignment_0()); }
	(rule__Scalar__AnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scalar__Group__1__Impl
	rule__Scalar__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarAccess().getScalarKeyword_1()); }
	'scalar'
	{ after(grammarAccess.getScalarAccess().getScalarKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scalar__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarAccess().getNameAssignment_2()); }
	(rule__Scalar__NameAssignment_2)
	{ after(grammarAccess.getScalarAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Structure__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group__0__Impl
	rule__Structure__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getAnnotationsAssignment_0()); }
	(rule__Structure__AnnotationsAssignment_0)*
	{ after(grammarAccess.getStructureAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group__1__Impl
	rule__Structure__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getStructureKeyword_1()); }
	'structure'
	{ after(grammarAccess.getStructureAccess().getStructureKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Structure__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructureAccess().getNameAssignment_2()); }
	(rule__Structure__NameAssignment_2)
	{ after(grammarAccess.getStructureAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityStructuredDataProperty__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__0__Impl
	rule__EntityStructuredDataProperty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAssignment_0()); }
	(rule__EntityStructuredDataProperty__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__1__Impl
	rule__EntityStructuredDataProperty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_1()); }
	'entityStructuredDataProperty'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__2__Impl
	rule__EntityStructuredDataProperty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaAssignment_2()); }
	(rule__EntityStructuredDataProperty__IsIdentityCriteriaAssignment_2)?
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__3__Impl
	rule__EntityStructuredDataProperty__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getNameAssignment_3()); }
	(rule__EntityStructuredDataProperty__NameAssignment_3)
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__4__Impl
	rule__EntityStructuredDataProperty__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__5__Impl
	rule__EntityStructuredDataProperty__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_5()); }
	'domain'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__6__Impl
	rule__EntityStructuredDataProperty__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainAssignment_6()); }
	(rule__EntityStructuredDataProperty__DomainAssignment_6)
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__7__Impl
	rule__EntityStructuredDataProperty__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_7()); }
	'range'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__8__Impl
	rule__EntityStructuredDataProperty__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeAssignment_8()); }
	(rule__EntityStructuredDataProperty__RangeAssignment_8)
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataProperty__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRightCurlyBracketKeyword_9()); }
	'}'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRightCurlyBracketKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityScalarDataProperty__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__0__Impl
	rule__EntityScalarDataProperty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAssignment_0()); }
	(rule__EntityScalarDataProperty__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__1__Impl
	rule__EntityScalarDataProperty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_1()); }
	'entityScalarDataProperty'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__2__Impl
	rule__EntityScalarDataProperty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaAssignment_2()); }
	(rule__EntityScalarDataProperty__IsIdentityCriteriaAssignment_2)?
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__3__Impl
	rule__EntityScalarDataProperty__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getNameAssignment_3()); }
	(rule__EntityScalarDataProperty__NameAssignment_3)
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__4__Impl
	rule__EntityScalarDataProperty__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__5__Impl
	rule__EntityScalarDataProperty__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_5()); }
	'domain'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__6__Impl
	rule__EntityScalarDataProperty__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getDomainAssignment_6()); }
	(rule__EntityScalarDataProperty__DomainAssignment_6)
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getDomainAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__7__Impl
	rule__EntityScalarDataProperty__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_7()); }
	'range'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__8__Impl
	rule__EntityScalarDataProperty__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRangeAssignment_8()); }
	(rule__EntityScalarDataProperty__RangeAssignment_8)
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRangeAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataProperty__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRightCurlyBracketKeyword_9()); }
	'}'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRightCurlyBracketKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredDataProperty__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__0__Impl
	rule__StructuredDataProperty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAssignment_0()); }
	(rule__StructuredDataProperty__AnnotationsAssignment_0)*
	{ after(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__1__Impl
	rule__StructuredDataProperty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_1()); }
	'structuredDataProperty'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__2__Impl
	rule__StructuredDataProperty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getNameAssignment_2()); }
	(rule__StructuredDataProperty__NameAssignment_2)
	{ after(grammarAccess.getStructuredDataPropertyAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__3__Impl
	rule__StructuredDataProperty__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__4__Impl
	rule__StructuredDataProperty__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_4()); }
	'domain'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__5__Impl
	rule__StructuredDataProperty__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getDomainAssignment_5()); }
	(rule__StructuredDataProperty__DomainAssignment_5)
	{ after(grammarAccess.getStructuredDataPropertyAccess().getDomainAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__6__Impl
	rule__StructuredDataProperty__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_6()); }
	'range'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__7__Impl
	rule__StructuredDataProperty__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getRangeAssignment_7()); }
	(rule__StructuredDataProperty__RangeAssignment_7)
	{ after(grammarAccess.getStructuredDataPropertyAccess().getRangeAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataProperty__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyAccess().getRightCurlyBracketKeyword_8()); }
	'}'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getRightCurlyBracketKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarDataProperty__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__0__Impl
	rule__ScalarDataProperty__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAssignment_0()); }
	(rule__ScalarDataProperty__AnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__1__Impl
	rule__ScalarDataProperty__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_1()); }
	'scalarDataProperty'
	{ after(grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__2__Impl
	rule__ScalarDataProperty__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getNameAssignment_2()); }
	(rule__ScalarDataProperty__NameAssignment_2)
	{ after(grammarAccess.getScalarDataPropertyAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__3__Impl
	rule__ScalarDataProperty__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__4__Impl
	rule__ScalarDataProperty__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_4()); }
	'domain'
	{ after(grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__5__Impl
	rule__ScalarDataProperty__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getDomainAssignment_5()); }
	(rule__ScalarDataProperty__DomainAssignment_5)
	{ after(grammarAccess.getScalarDataPropertyAccess().getDomainAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__6__Impl
	rule__ScalarDataProperty__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_6()); }
	'range'
	{ after(grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__7__Impl
	rule__ScalarDataProperty__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getRangeAssignment_7()); }
	(rule__ScalarDataProperty__RangeAssignment_7)
	{ after(grammarAccess.getScalarDataPropertyAccess().getRangeAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataProperty__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_8()); }
	'}'
	{ after(grammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ChainRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChainRule__Group__0__Impl
	rule__ChainRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChainRuleAccess().getRuleKeyword_0()); }
	'rule'
	{ after(grammarAccess.getChainRuleAccess().getRuleKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChainRule__Group__1__Impl
	rule__ChainRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChainRuleAccess().getNameAssignment_1()); }
	(rule__ChainRule__NameAssignment_1)
	{ after(grammarAccess.getChainRuleAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChainRule__Group__2__Impl
	rule__ChainRule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChainRuleAccess().getInfersKeyword_2()); }
	'infers'
	{ after(grammarAccess.getChainRuleAccess().getInfersKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChainRule__Group__3__Impl
	rule__ChainRule__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChainRuleAccess().getHeadAssignment_3()); }
	(rule__ChainRule__HeadAssignment_3)
	{ after(grammarAccess.getChainRuleAccess().getHeadAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChainRule__Group__4__Impl
	rule__ChainRule__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChainRuleAccess().getIfKeyword_4()); }
	'if'
	{ after(grammarAccess.getChainRuleAccess().getIfKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChainRule__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChainRuleAccess().getFirstSegmentAssignment_5()); }
	(rule__ChainRule__FirstSegmentAssignment_5)
	{ after(grammarAccess.getChainRuleAccess().getFirstSegmentAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleBodySegment__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleBodySegment__Group__0__Impl
	rule__RuleBodySegment__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleBodySegment__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleBodySegmentAccess().getPredicateAssignment_0()); }
	(rule__RuleBodySegment__PredicateAssignment_0)
	{ after(grammarAccess.getRuleBodySegmentAccess().getPredicateAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleBodySegment__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleBodySegment__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleBodySegment__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleBodySegmentAccess().getGroup_1()); }
	(rule__RuleBodySegment__Group_1__0)?
	{ after(grammarAccess.getRuleBodySegmentAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleBodySegment__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleBodySegment__Group_1__0__Impl
	rule__RuleBodySegment__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleBodySegment__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleBodySegmentAccess().getAmpersandAmpersandKeyword_1_0()); }
	'&&'
	{ after(grammarAccess.getRuleBodySegmentAccess().getAmpersandAmpersandKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleBodySegment__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleBodySegment__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleBodySegment__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleBodySegmentAccess().getNextSegmentAssignment_1_1()); }
	(rule__RuleBodySegment__NextSegmentAssignment_1_1)
	{ after(grammarAccess.getRuleBodySegmentAccess().getNextSegmentAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SegmentPredicate__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_1__0__Impl
	rule__SegmentPredicate__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getSourceKeyword_1_0()); }
	'source'
	{ after(grammarAccess.getSegmentPredicateAccess().getSourceKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_1__1__Impl
	rule__SegmentPredicate__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_1_1()); }
	'('
	{ after(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_1__2__Impl
	rule__SegmentPredicate__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceAssignment_1_2()); }
	(rule__SegmentPredicate__ReifiedRelationshipSourceAssignment_1_2)
	{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_1_3()); }
	')'
	{ after(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SegmentPredicate__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_2__0__Impl
	rule__SegmentPredicate__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getInvSourceKeyword_2_0()); }
	'invSource'
	{ after(grammarAccess.getSegmentPredicateAccess().getInvSourceKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_2__1__Impl
	rule__SegmentPredicate__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_2_1()); }
	'('
	{ after(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_2__2__Impl
	rule__SegmentPredicate__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceAssignment_2_2()); }
	(rule__SegmentPredicate__ReifiedRelationshipInverseSourceAssignment_2_2)
	{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceAssignment_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_2_3()); }
	')'
	{ after(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SegmentPredicate__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_3__0__Impl
	rule__SegmentPredicate__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getTargetKeyword_3_0()); }
	'target'
	{ after(grammarAccess.getSegmentPredicateAccess().getTargetKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_3__1__Impl
	rule__SegmentPredicate__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_3_1()); }
	'('
	{ after(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_3__2__Impl
	rule__SegmentPredicate__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetAssignment_3_2()); }
	(rule__SegmentPredicate__ReifiedRelationshipTargetAssignment_3_2)
	{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetAssignment_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_3_3()); }
	')'
	{ after(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SegmentPredicate__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_4__0__Impl
	rule__SegmentPredicate__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getInvTargetKeyword_4_0()); }
	'invTarget'
	{ after(grammarAccess.getSegmentPredicateAccess().getInvTargetKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_4__1__Impl
	rule__SegmentPredicate__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_4_1()); }
	'('
	{ after(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_4__2__Impl
	rule__SegmentPredicate__Group_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetAssignment_4_2()); }
	(rule__SegmentPredicate__ReifiedRelationshipInverseTargetAssignment_4_2)
	{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetAssignment_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_4_3()); }
	')'
	{ after(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SegmentPredicate__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_5__0__Impl
	rule__SegmentPredicate__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getInvKeyword_5_0()); }
	'inv'
	{ after(grammarAccess.getSegmentPredicateAccess().getInvKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_5__1__Impl
	rule__SegmentPredicate__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_5_1()); }
	'('
	{ after(grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_5__2__Impl
	rule__SegmentPredicate__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseAssignment_5_2()); }
	(rule__SegmentPredicate__UnreifiedRelationshipInverseAssignment_5_2)
	{ after(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SegmentPredicate__Group_5__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_5_3()); }
	')'
	{ after(grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnonymousConceptUnionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnonymousConceptUnionAxiom__Group__0__Impl
	rule__AnonymousConceptUnionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__AnonymousConceptUnionAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnonymousConceptUnionAxiom__Group__1__Impl
	rule__AnonymousConceptUnionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_1()); }
	'anonymousConceptUnion'
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnonymousConceptUnionAxiom__Group__2__Impl
	rule__AnonymousConceptUnionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnonymousConceptUnionAxiom__Group__3__Impl
	rule__AnonymousConceptUnionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameAssignment_3()); }
	(rule__AnonymousConceptUnionAxiom__NameAssignment_3)
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnonymousConceptUnionAxiom__Group__4__Impl
	rule__AnonymousConceptUnionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnonymousConceptUnionAxiom__Group__5__Impl
	rule__AnonymousConceptUnionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_5()); }
	'{'
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnonymousConceptUnionAxiom__Group__6__Impl
	rule__AnonymousConceptUnionAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsAssignment_6()); }
	(rule__AnonymousConceptUnionAxiom__DisjunctionsAssignment_6)*
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnonymousConceptUnionAxiom__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RootConceptTaxonomyAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RootConceptTaxonomyAxiom__Group__0__Impl
	rule__RootConceptTaxonomyAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__RootConceptTaxonomyAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RootConceptTaxonomyAxiom__Group__1__Impl
	rule__RootConceptTaxonomyAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_1()); }
	'rootConceptTaxonomy'
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RootConceptTaxonomyAxiom__Group__2__Impl
	rule__RootConceptTaxonomyAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RootConceptTaxonomyAxiom__Group__3__Impl
	rule__RootConceptTaxonomyAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootAssignment_3()); }
	(rule__RootConceptTaxonomyAxiom__RootAssignment_3)
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RootConceptTaxonomyAxiom__Group__4__Impl
	rule__RootConceptTaxonomyAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RootConceptTaxonomyAxiom__Group__5__Impl
	rule__RootConceptTaxonomyAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_5()); }
	'{'
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RootConceptTaxonomyAxiom__Group__6__Impl
	rule__RootConceptTaxonomyAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsAssignment_6()); }
	(rule__RootConceptTaxonomyAxiom__DisjunctionsAssignment_6)*
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RootConceptTaxonomyAxiom__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SpecificDisjointConceptAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SpecificDisjointConceptAxiom__Group__0__Impl
	rule__SpecificDisjointConceptAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__SpecificDisjointConceptAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SpecificDisjointConceptAxiom__Group__1__Impl
	rule__SpecificDisjointConceptAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_1()); }
	'disjointLeaf'
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SpecificDisjointConceptAxiom__Group__2__Impl
	rule__SpecificDisjointConceptAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SpecificDisjointConceptAxiom__Group__3__Impl
	rule__SpecificDisjointConceptAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafAssignment_3()); }
	(rule__SpecificDisjointConceptAxiom__DisjointLeafAssignment_3)
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SpecificDisjointConceptAxiom__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityExistentialRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityExistentialRestrictionAxiom__Group__0__Impl
	rule__EntityExistentialRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__EntityExistentialRestrictionAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityExistentialRestrictionAxiom__Group__1__Impl
	rule__EntityExistentialRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_1()); }
	'someEntities'
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityExistentialRestrictionAxiom__Group__2__Impl
	rule__EntityExistentialRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainAssignment_2()); }
	(rule__EntityExistentialRestrictionAxiom__RestrictedDomainAssignment_2)
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityExistentialRestrictionAxiom__Group__3__Impl
	rule__EntityExistentialRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_3()); }
	'.'
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityExistentialRestrictionAxiom__Group__4__Impl
	rule__EntityExistentialRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipAssignment_4()); }
	(rule__EntityExistentialRestrictionAxiom__RestrictedRelationshipAssignment_4)
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityExistentialRestrictionAxiom__Group__5__Impl
	rule__EntityExistentialRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_5()); }
	'in'
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityExistentialRestrictionAxiom__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeAssignment_6()); }
	(rule__EntityExistentialRestrictionAxiom__RestrictedRangeAssignment_6)
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityUniversalRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityUniversalRestrictionAxiom__Group__0__Impl
	rule__EntityUniversalRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__EntityUniversalRestrictionAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityUniversalRestrictionAxiom__Group__1__Impl
	rule__EntityUniversalRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_1()); }
	'allEntities'
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityUniversalRestrictionAxiom__Group__2__Impl
	rule__EntityUniversalRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainAssignment_2()); }
	(rule__EntityUniversalRestrictionAxiom__RestrictedDomainAssignment_2)
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityUniversalRestrictionAxiom__Group__3__Impl
	rule__EntityUniversalRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_3()); }
	'.'
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityUniversalRestrictionAxiom__Group__4__Impl
	rule__EntityUniversalRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipAssignment_4()); }
	(rule__EntityUniversalRestrictionAxiom__RestrictedRelationshipAssignment_4)
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityUniversalRestrictionAxiom__Group__5__Impl
	rule__EntityUniversalRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_5()); }
	'in'
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityUniversalRestrictionAxiom__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeAssignment_6()); }
	(rule__EntityUniversalRestrictionAxiom__RestrictedRangeAssignment_6)
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AspectSpecializationAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectSpecializationAxiom__Group__0__Impl
	rule__AspectSpecializationAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectSpecializationAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__AspectSpecializationAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getAspectSpecializationAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectSpecializationAxiom__Group__1__Impl
	rule__AspectSpecializationAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityAssignment_1()); }
	(rule__AspectSpecializationAxiom__SubEntityAssignment_1)
	{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectSpecializationAxiom__Group__2__Impl
	rule__AspectSpecializationAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_2()); }
	'extendsAspect'
	{ after(grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AspectSpecializationAxiom__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAssignment_3()); }
	(rule__AspectSpecializationAxiom__SuperAspectAssignment_3)
	{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptSpecializationAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptSpecializationAxiom__Group__0__Impl
	rule__ConceptSpecializationAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptSpecializationAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__ConceptSpecializationAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptSpecializationAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptSpecializationAxiom__Group__1__Impl
	rule__ConceptSpecializationAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptAssignment_1()); }
	(rule__ConceptSpecializationAxiom__SubConceptAssignment_1)
	{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptSpecializationAxiom__Group__2__Impl
	rule__ConceptSpecializationAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_2()); }
	'extendsConcept'
	{ after(grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptSpecializationAxiom__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptAssignment_3()); }
	(rule__ConceptSpecializationAxiom__SuperConceptAssignment_3)
	{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationshipSpecializationAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipSpecializationAxiom__Group__0__Impl
	rule__ReifiedRelationshipSpecializationAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__ReifiedRelationshipSpecializationAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipSpecializationAxiom__Group__1__Impl
	rule__ReifiedRelationshipSpecializationAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipAssignment_1()); }
	(rule__ReifiedRelationshipSpecializationAxiom__SubRelationshipAssignment_1)
	{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipSpecializationAxiom__Group__2__Impl
	rule__ReifiedRelationshipSpecializationAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_2()); }
	'extendsRelationship'
	{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipSpecializationAxiom__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipAssignment_3()); }
	(rule__ReifiedRelationshipSpecializationAxiom__SuperRelationshipAssignment_3)
	{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SubObjectPropertyOfAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SubObjectPropertyOfAxiom__Group__0__Impl
	rule__SubObjectPropertyOfAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__SubObjectPropertyOfAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SubObjectPropertyOfAxiom__Group__1__Impl
	rule__SubObjectPropertyOfAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyAssignment_1()); }
	(rule__SubObjectPropertyOfAxiom__SubPropertyAssignment_1)
	{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SubObjectPropertyOfAxiom__Group__2__Impl
	rule__SubObjectPropertyOfAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubObjectPropertyOfKeyword_2()); }
	'subObjectPropertyOf'
	{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubObjectPropertyOfKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SubObjectPropertyOfAxiom__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSuperPropertyAssignment_3()); }
	(rule__SubObjectPropertyOfAxiom__SuperPropertyAssignment_3)
	{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSuperPropertyAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SubDataPropertyOfAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SubDataPropertyOfAxiom__Group__0__Impl
	rule__SubDataPropertyOfAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__SubDataPropertyOfAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SubDataPropertyOfAxiom__Group__1__Impl
	rule__SubDataPropertyOfAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyAssignment_1()); }
	(rule__SubDataPropertyOfAxiom__SubPropertyAssignment_1)
	{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SubDataPropertyOfAxiom__Group__2__Impl
	rule__SubDataPropertyOfAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubDataPropertyOfKeyword_2()); }
	'subDataPropertyOf'
	{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubDataPropertyOfKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SubDataPropertyOfAxiom__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getSuperPropertyAssignment_3()); }
	(rule__SubDataPropertyOfAxiom__SuperPropertyAssignment_3)
	{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getSuperPropertyAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__0__Impl
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__EntityScalarDataPropertyExistentialRestrictionAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__1__Impl
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_1()); }
	'someData'
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__2__Impl
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityAssignment_2()); }
	(rule__EntityScalarDataPropertyExistentialRestrictionAxiom__RestrictedEntityAssignment_2)
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__3__Impl
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_3()); }
	'.'
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__4__Impl
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyAssignment_4()); }
	(rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarPropertyAssignment_4)
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__5__Impl
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_5()); }
	'in'
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionAssignment_6()); }
	(rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarRestrictionAssignment_6)
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__0__Impl
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__1__Impl
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1()); }
	'every'
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__2__Impl
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_2()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_2)
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__3__Impl
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3()); }
	'.'
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__4__Impl
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyAssignment_4()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__ScalarPropertyAssignment_4)
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__5__Impl
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5()); }
	'='
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__6__Impl
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueAssignment_6()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__LiteralValueAssignment_6)
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getGroup_7()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__0)?
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getGroup_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__0__Impl
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_7_0()); }
	'^^'
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__Group_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeAssignment_7_1()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__ValueTypeAssignment_7_1)
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeAssignment_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__0__Impl
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__EntityScalarDataPropertyUniversalRestrictionAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__1__Impl
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_1()); }
	'allData'
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__2__Impl
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityAssignment_2()); }
	(rule__EntityScalarDataPropertyUniversalRestrictionAxiom__RestrictedEntityAssignment_2)
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__3__Impl
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_3()); }
	'.'
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__4__Impl
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyAssignment_4()); }
	(rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarPropertyAssignment_4)
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__5__Impl
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_5()); }
	'in'
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionAssignment_6()); }
	(rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarRestrictionAssignment_6)
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__0__Impl
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__1__Impl
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1()); }
	'every'
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__2__Impl
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_2()); }
	(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_2)
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__3__Impl
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3()); }
	'.'
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__4__Impl
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyAssignment_4()); }
	(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyAssignment_4)
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__5__Impl
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5()); }
	'='
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__6__Impl
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_6()); }
	'{'
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__7__Impl
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAlternatives_7()); }
	(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Alternatives_7)*
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAlternatives_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRightCurlyBracketKeyword_8()); }
	'}'
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRightCurlyBracketKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RestrictionStructuredDataPropertyTuple__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionStructuredDataPropertyTuple__Group__0__Impl
	rule__RestrictionStructuredDataPropertyTuple__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAnnotationsAssignment_0()); }
	(rule__RestrictionStructuredDataPropertyTuple__AnnotationsAssignment_0)*
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionStructuredDataPropertyTuple__Group__1__Impl
	rule__RestrictionStructuredDataPropertyTuple__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_1()); }
	(rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyAssignment_1)
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionStructuredDataPropertyTuple__Group__2__Impl
	rule__RestrictionStructuredDataPropertyTuple__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionStructuredDataPropertyTuple__Group__3__Impl
	rule__RestrictionStructuredDataPropertyTuple__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionStructuredDataPropertyTuple__Group__4__Impl
	rule__RestrictionStructuredDataPropertyTuple__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAlternatives_4()); }
	(rule__RestrictionStructuredDataPropertyTuple__Alternatives_4)*
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAlternatives_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionStructuredDataPropertyTuple__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RestrictionScalarDataPropertyValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionScalarDataPropertyValue__Group__0__Impl
	rule__RestrictionScalarDataPropertyValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getAnnotationsAssignment_0()); }
	(rule__RestrictionScalarDataPropertyValue__AnnotationsAssignment_0)*
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionScalarDataPropertyValue__Group__1__Impl
	rule__RestrictionScalarDataPropertyValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_1()); }
	(rule__RestrictionScalarDataPropertyValue__ScalarDataPropertyAssignment_1)
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionScalarDataPropertyValue__Group__2__Impl
	rule__RestrictionScalarDataPropertyValue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionScalarDataPropertyValue__Group__3__Impl
	rule__RestrictionScalarDataPropertyValue__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_3()); }
	(rule__RestrictionScalarDataPropertyValue__ScalarPropertyValueAssignment_3)
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionScalarDataPropertyValue__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getGroup_4()); }
	(rule__RestrictionScalarDataPropertyValue__Group_4__0)?
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RestrictionScalarDataPropertyValue__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionScalarDataPropertyValue__Group_4__0__Impl
	rule__RestrictionScalarDataPropertyValue__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0()); }
	'^^'
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RestrictionScalarDataPropertyValue__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeAssignment_4_1()); }
	(rule__RestrictionScalarDataPropertyValue__ValueTypeAssignment_4_1)
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group__0__Impl
	rule__BinaryScalarRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__BinaryScalarRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group__1__Impl
	rule__BinaryScalarRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_1()); }
	'binaryScalarRestriction'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group__2__Impl
	rule__BinaryScalarRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getNameAssignment_2()); }
	(rule__BinaryScalarRestriction__NameAssignment_2)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group__3__Impl
	rule__BinaryScalarRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group__4__Impl
	rule__BinaryScalarRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4()); }
	(rule__BinaryScalarRestriction__UnorderedGroup_4)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group__5__Impl
	rule__BinaryScalarRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
	'restrictedRange'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group__6__Impl
	rule__BinaryScalarRestriction__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
	(rule__BinaryScalarRestriction__RestrictedRangeAssignment_6)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__Group_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_4_0__0__Impl
	rule__BinaryScalarRestriction__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_4_0_0()); }
	'length'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_4_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getLengthAssignment_4_0_1()); }
	(rule__BinaryScalarRestriction__LengthAssignment_4_0_1)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getLengthAssignment_4_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__Group_4_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_4_1__0__Impl
	rule__BinaryScalarRestriction__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_4_1_0()); }
	'minLength'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_4_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthAssignment_4_1_1()); }
	(rule__BinaryScalarRestriction__MinLengthAssignment_4_1_1)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthAssignment_4_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_4_2__0__Impl
	rule__BinaryScalarRestriction__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_4_2_0()); }
	'maxLength'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthAssignment_4_2_1()); }
	(rule__BinaryScalarRestriction__MaxLengthAssignment_4_2_1)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group__0__Impl
	rule__IRIScalarRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__IRIScalarRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group__1__Impl
	rule__IRIScalarRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_1()); }
	'iriScalarRestriction'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group__2__Impl
	rule__IRIScalarRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getNameAssignment_2()); }
	(rule__IRIScalarRestriction__NameAssignment_2)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group__3__Impl
	rule__IRIScalarRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group__4__Impl
	rule__IRIScalarRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4()); }
	(rule__IRIScalarRestriction__UnorderedGroup_4)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group__5__Impl
	rule__IRIScalarRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
	'restrictedRange'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group__6__Impl
	rule__IRIScalarRestriction__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
	(rule__IRIScalarRestriction__RestrictedRangeAssignment_6)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_4_0__0__Impl
	rule__IRIScalarRestriction__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_4_0_0()); }
	'length'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_4_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getLengthAssignment_4_0_1()); }
	(rule__IRIScalarRestriction__LengthAssignment_4_0_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getLengthAssignment_4_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group_4_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_4_1__0__Impl
	rule__IRIScalarRestriction__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_4_1_0()); }
	'minLength'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_4_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthAssignment_4_1_1()); }
	(rule__IRIScalarRestriction__MinLengthAssignment_4_1_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthAssignment_4_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_4_2__0__Impl
	rule__IRIScalarRestriction__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_4_2_0()); }
	'maxLength'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthAssignment_4_2_1()); }
	(rule__IRIScalarRestriction__MaxLengthAssignment_4_2_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group_4_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_4_3__0__Impl
	rule__IRIScalarRestriction__Group_4_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_4_3_0()); }
	'pattern'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_4_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_4_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_4_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getPatternAssignment_4_3_1()); }
	(rule__IRIScalarRestriction__PatternAssignment_4_3_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getPatternAssignment_4_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group__0__Impl
	rule__NumericScalarRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__NumericScalarRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group__1__Impl
	rule__NumericScalarRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_1()); }
	'numericScalarRestriction'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group__2__Impl
	rule__NumericScalarRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getNameAssignment_2()); }
	(rule__NumericScalarRestriction__NameAssignment_2)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group__3__Impl
	rule__NumericScalarRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group__4__Impl
	rule__NumericScalarRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4()); }
	(rule__NumericScalarRestriction__UnorderedGroup_4)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group__5__Impl
	rule__NumericScalarRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
	'restrictedRange'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group__6__Impl
	rule__NumericScalarRestriction__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
	(rule__NumericScalarRestriction__RestrictedRangeAssignment_6)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_4_0__0__Impl
	rule__NumericScalarRestriction__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0()); }
	'minInclusive'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_4_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveAssignment_4_0_1()); }
	(rule__NumericScalarRestriction__MinInclusiveAssignment_4_0_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveAssignment_4_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group_4_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_4_1__0__Impl
	rule__NumericScalarRestriction__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0()); }
	'maxInclusive'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveAssignment_4_1_1()); }
	(rule__NumericScalarRestriction__MaxInclusiveAssignment_4_1_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveAssignment_4_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_4_2__0__Impl
	rule__NumericScalarRestriction__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0()); }
	'minExclusive'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveAssignment_4_2_1()); }
	(rule__NumericScalarRestriction__MinExclusiveAssignment_4_2_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group_4_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_4_3__0__Impl
	rule__NumericScalarRestriction__Group_4_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0()); }
	'maxExclusive'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_4_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_4_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveAssignment_4_3_1()); }
	(rule__NumericScalarRestriction__MaxExclusiveAssignment_4_3_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveAssignment_4_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group__0__Impl
	rule__PlainLiteralScalarRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__PlainLiteralScalarRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group__1__Impl
	rule__PlainLiteralScalarRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_1()); }
	'plainLiteralScalarRestriction'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group__2__Impl
	rule__PlainLiteralScalarRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameAssignment_2()); }
	(rule__PlainLiteralScalarRestriction__NameAssignment_2)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group__3__Impl
	rule__PlainLiteralScalarRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group__4__Impl
	rule__PlainLiteralScalarRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4()); }
	(rule__PlainLiteralScalarRestriction__UnorderedGroup_4)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group__5__Impl
	rule__PlainLiteralScalarRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
	'restrictedRange'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group__6__Impl
	rule__PlainLiteralScalarRestriction__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
	(rule__PlainLiteralScalarRestriction__RestrictedRangeAssignment_6)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_0__0__Impl
	rule__PlainLiteralScalarRestriction__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_4_0_0()); }
	'length'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthAssignment_4_0_1()); }
	(rule__PlainLiteralScalarRestriction__LengthAssignment_4_0_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthAssignment_4_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_4_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_1__0__Impl
	rule__PlainLiteralScalarRestriction__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_4_1_0()); }
	'minLength'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_4_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthAssignment_4_1_1()); }
	(rule__PlainLiteralScalarRestriction__MinLengthAssignment_4_1_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthAssignment_4_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_2__0__Impl
	rule__PlainLiteralScalarRestriction__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_4_2_0()); }
	'maxLength'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthAssignment_4_2_1()); }
	(rule__PlainLiteralScalarRestriction__MaxLengthAssignment_4_2_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_4_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_3__0__Impl
	rule__PlainLiteralScalarRestriction__Group_4_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_4_3_0()); }
	'pattern'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_4_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternAssignment_4_3_1()); }
	(rule__PlainLiteralScalarRestriction__PatternAssignment_4_3_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternAssignment_4_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_4_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_4__0__Impl
	rule__PlainLiteralScalarRestriction__Group_4_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_4_4_0()); }
	'langRange'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_4_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_4_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_4_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeAssignment_4_4_1()); }
	(rule__PlainLiteralScalarRestriction__LangRangeAssignment_4_4_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeAssignment_4_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarOneOfRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfRestriction__Group__0__Impl
	rule__ScalarOneOfRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__ScalarOneOfRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfRestriction__Group__1__Impl
	rule__ScalarOneOfRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_1()); }
	'scalarOneOfRestriction'
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfRestriction__Group__2__Impl
	rule__ScalarOneOfRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getNameAssignment_2()); }
	(rule__ScalarOneOfRestriction__NameAssignment_2)
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfRestriction__Group__3__Impl
	rule__ScalarOneOfRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfRestriction__Group__4__Impl
	rule__ScalarOneOfRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_4()); }
	'restrictedRange'
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfRestriction__Group__5__Impl
	rule__ScalarOneOfRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeAssignment_5()); }
	(rule__ScalarOneOfRestriction__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfRestriction__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarOneOfLiteralAxiom__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfLiteralAxiom__Group__0__Impl
	rule__ScalarOneOfLiteralAxiom__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAssignment_0()); }
	(rule__ScalarOneOfLiteralAxiom__AnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfLiteralAxiom__Group__1__Impl
	rule__ScalarOneOfLiteralAxiom__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_1()); }
	'oneOf'
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfLiteralAxiom__Group__2__Impl
	rule__ScalarOneOfLiteralAxiom__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomAssignment_2()); }
	(rule__ScalarOneOfLiteralAxiom__AxiomAssignment_2)
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfLiteralAxiom__Group__3__Impl
	rule__ScalarOneOfLiteralAxiom__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_3()); }
	'='
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfLiteralAxiom__Group__4__Impl
	rule__ScalarOneOfLiteralAxiom__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueAssignment_4()); }
	(rule__ScalarOneOfLiteralAxiom__ValueAssignment_4)
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfLiteralAxiom__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getGroup_5()); }
	(rule__ScalarOneOfLiteralAxiom__Group_5__0)?
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarOneOfLiteralAxiom__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfLiteralAxiom__Group_5__0__Impl
	rule__ScalarOneOfLiteralAxiom__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_5_0()); }
	'^^'
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarOneOfLiteralAxiom__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeAssignment_5_1()); }
	(rule__ScalarOneOfLiteralAxiom__ValueTypeAssignment_5_1)
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group__0__Impl
	rule__StringScalarRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__StringScalarRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group__1__Impl
	rule__StringScalarRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_1()); }
	'stringScalarRestriction'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group__2__Impl
	rule__StringScalarRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getNameAssignment_2()); }
	(rule__StringScalarRestriction__NameAssignment_2)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group__3__Impl
	rule__StringScalarRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group__4__Impl
	rule__StringScalarRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4()); }
	(rule__StringScalarRestriction__UnorderedGroup_4)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group__5__Impl
	rule__StringScalarRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
	'restrictedRange'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group__6__Impl
	rule__StringScalarRestriction__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
	(rule__StringScalarRestriction__RestrictedRangeAssignment_6)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_4_0__0__Impl
	rule__StringScalarRestriction__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_4_0_0()); }
	'length'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_4_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getLengthAssignment_4_0_1()); }
	(rule__StringScalarRestriction__LengthAssignment_4_0_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getLengthAssignment_4_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group_4_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_4_1__0__Impl
	rule__StringScalarRestriction__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_4_1_0()); }
	'minLength'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_4_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getMinLengthAssignment_4_1_1()); }
	(rule__StringScalarRestriction__MinLengthAssignment_4_1_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getMinLengthAssignment_4_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_4_2__0__Impl
	rule__StringScalarRestriction__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_4_2_0()); }
	'maxLength'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthAssignment_4_2_1()); }
	(rule__StringScalarRestriction__MaxLengthAssignment_4_2_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group_4_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_4_3__0__Impl
	rule__StringScalarRestriction__Group_4_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_4_3_0()); }
	'pattern'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_4_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_4_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_4_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getPatternAssignment_4_3_1()); }
	(rule__StringScalarRestriction__PatternAssignment_4_3_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getPatternAssignment_4_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SynonymScalarRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SynonymScalarRestriction__Group__0__Impl
	rule__SynonymScalarRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__SynonymScalarRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SynonymScalarRestriction__Group__1__Impl
	rule__SynonymScalarRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_1()); }
	'synonymScalarRestriction'
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SynonymScalarRestriction__Group__2__Impl
	rule__SynonymScalarRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getNameAssignment_2()); }
	(rule__SynonymScalarRestriction__NameAssignment_2)
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SynonymScalarRestriction__Group__3__Impl
	rule__SynonymScalarRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SynonymScalarRestriction__Group__4__Impl
	rule__SynonymScalarRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
	'restrictedRange'
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SynonymScalarRestriction__Group__5__Impl
	rule__SynonymScalarRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
	(rule__SynonymScalarRestriction__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SynonymScalarRestriction__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group__0__Impl
	rule__TimeScalarRestriction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAssignment_0()); }
	(rule__TimeScalarRestriction__AnnotationsAssignment_0)*
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group__1__Impl
	rule__TimeScalarRestriction__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_1()); }
	'timeScalarRestriction'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group__2__Impl
	rule__TimeScalarRestriction__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getNameAssignment_2()); }
	(rule__TimeScalarRestriction__NameAssignment_2)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group__3__Impl
	rule__TimeScalarRestriction__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group__4__Impl
	rule__TimeScalarRestriction__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4()); }
	(rule__TimeScalarRestriction__UnorderedGroup_4)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group__5__Impl
	rule__TimeScalarRestriction__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
	'restrictedRange'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group__6__Impl
	rule__TimeScalarRestriction__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
	(rule__TimeScalarRestriction__RestrictedRangeAssignment_6)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_4_0__0__Impl
	rule__TimeScalarRestriction__Group_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0()); }
	'minInclusive'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_4_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveAssignment_4_0_1()); }
	(rule__TimeScalarRestriction__MinInclusiveAssignment_4_0_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveAssignment_4_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group_4_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_4_1__0__Impl
	rule__TimeScalarRestriction__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0()); }
	'maxInclusive'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveAssignment_4_1_1()); }
	(rule__TimeScalarRestriction__MaxInclusiveAssignment_4_1_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveAssignment_4_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_4_2__0__Impl
	rule__TimeScalarRestriction__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0()); }
	'minExclusive'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveAssignment_4_2_1()); }
	(rule__TimeScalarRestriction__MinExclusiveAssignment_4_2_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group_4_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_4_3__0__Impl
	rule__TimeScalarRestriction__Group_4_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0()); }
	'maxExclusive'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_4_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_4_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveAssignment_4_3_1()); }
	(rule__TimeScalarRestriction__MaxExclusiveAssignment_4_3_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveAssignment_4_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__0__Impl
	rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getAnnotationsAssignment_0()); }
	(rule__DescriptionBoxExtendsClosedWorldDefinitions__AnnotationsAssignment_0)*
	{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__1__Impl
	rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_1()); }
	'extends'
	{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxExtendsClosedWorldDefinitions__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsAssignment_2()); }
	(rule__DescriptionBoxExtendsClosedWorldDefinitions__ClosedWorldDefinitionsAssignment_2)
	{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__DescriptionBoxRefinement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBoxRefinement__Group__0__Impl
	rule__DescriptionBoxRefinement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxRefinement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAssignment_0()); }
	(rule__DescriptionBoxRefinement__AnnotationsAssignment_0)*
	{ after(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxRefinement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBoxRefinement__Group__1__Impl
	rule__DescriptionBoxRefinement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxRefinement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_1()); }
	'refines'
	{ after(grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxRefinement__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__DescriptionBoxRefinement__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxRefinement__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxAssignment_2()); }
	(rule__DescriptionBoxRefinement__RefinedDescriptionBoxAssignment_2)
	{ after(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SingletonInstanceScalarDataPropertyValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group__0__Impl
	rule__SingletonInstanceScalarDataPropertyValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getAnnotationsAssignment_0()); }
	(rule__SingletonInstanceScalarDataPropertyValue__AnnotationsAssignment_0)*
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group__1__Impl
	rule__SingletonInstanceScalarDataPropertyValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceAssignment_1()); }
	(rule__SingletonInstanceScalarDataPropertyValue__SingletonInstanceAssignment_1)
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group__2__Impl
	rule__SingletonInstanceScalarDataPropertyValue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group__3__Impl
	rule__SingletonInstanceScalarDataPropertyValue__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_3()); }
	(rule__SingletonInstanceScalarDataPropertyValue__ScalarDataPropertyAssignment_3)
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group__4__Impl
	rule__SingletonInstanceScalarDataPropertyValue__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_4()); }
	'='
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group__5__Impl
	rule__SingletonInstanceScalarDataPropertyValue__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_5()); }
	(rule__SingletonInstanceScalarDataPropertyValue__ScalarPropertyValueAssignment_5)
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getGroup_6()); }
	(rule__SingletonInstanceScalarDataPropertyValue__Group_6__0)?
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SingletonInstanceScalarDataPropertyValue__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group_6__0__Impl
	rule__SingletonInstanceScalarDataPropertyValue__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_6_0()); }
	'^^'
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceScalarDataPropertyValue__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeAssignment_6_1()); }
	(rule__SingletonInstanceScalarDataPropertyValue__ValueTypeAssignment_6_1)
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SingletonInstanceStructuredDataPropertyValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceStructuredDataPropertyValue__Group__0__Impl
	rule__SingletonInstanceStructuredDataPropertyValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAnnotationsAssignment_0()); }
	(rule__SingletonInstanceStructuredDataPropertyValue__AnnotationsAssignment_0)*
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceStructuredDataPropertyValue__Group__1__Impl
	rule__SingletonInstanceStructuredDataPropertyValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceAssignment_1()); }
	(rule__SingletonInstanceStructuredDataPropertyValue__SingletonInstanceAssignment_1)
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceStructuredDataPropertyValue__Group__2__Impl
	rule__SingletonInstanceStructuredDataPropertyValue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceStructuredDataPropertyValue__Group__3__Impl
	rule__SingletonInstanceStructuredDataPropertyValue__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyAssignment_3()); }
	(rule__SingletonInstanceStructuredDataPropertyValue__StructuredDataPropertyAssignment_3)
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceStructuredDataPropertyValue__Group__4__Impl
	rule__SingletonInstanceStructuredDataPropertyValue__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_4()); }
	'='
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceStructuredDataPropertyValue__Group__5__Impl
	rule__SingletonInstanceStructuredDataPropertyValue__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_5()); }
	'{'
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceStructuredDataPropertyValue__Group__6__Impl
	rule__SingletonInstanceStructuredDataPropertyValue__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAlternatives_6()); }
	(rule__SingletonInstanceStructuredDataPropertyValue__Alternatives_6)*
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAlternatives_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingletonInstanceStructuredDataPropertyValue__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getRightCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredDataPropertyTuple__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataPropertyTuple__Group__0__Impl
	rule__StructuredDataPropertyTuple__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getAnnotationsAssignment_0()); }
	(rule__StructuredDataPropertyTuple__AnnotationsAssignment_0)*
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataPropertyTuple__Group__1__Impl
	rule__StructuredDataPropertyTuple__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_1()); }
	(rule__StructuredDataPropertyTuple__StructuredDataPropertyAssignment_1)
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataPropertyTuple__Group__2__Impl
	rule__StructuredDataPropertyTuple__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataPropertyTuple__Group__3__Impl
	rule__StructuredDataPropertyTuple__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataPropertyTuple__Group__4__Impl
	rule__StructuredDataPropertyTuple__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getAlternatives_4()); }
	(rule__StructuredDataPropertyTuple__Alternatives_4)*
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getAlternatives_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StructuredDataPropertyTuple__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarDataPropertyValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataPropertyValue__Group__0__Impl
	rule__ScalarDataPropertyValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getAnnotationsAssignment_0()); }
	(rule__ScalarDataPropertyValue__AnnotationsAssignment_0)*
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataPropertyValue__Group__1__Impl
	rule__ScalarDataPropertyValue__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_1()); }
	(rule__ScalarDataPropertyValue__ScalarDataPropertyAssignment_1)
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataPropertyValue__Group__2__Impl
	rule__ScalarDataPropertyValue__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataPropertyValue__Group__3__Impl
	rule__ScalarDataPropertyValue__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_3()); }
	(rule__ScalarDataPropertyValue__ScalarPropertyValueAssignment_3)
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataPropertyValue__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getGroup_4()); }
	(rule__ScalarDataPropertyValue__Group_4__0)?
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ScalarDataPropertyValue__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataPropertyValue__Group_4__0__Impl
	rule__ScalarDataPropertyValue__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0()); }
	'^^'
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ScalarDataPropertyValue__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeAssignment_4_1()); }
	(rule__ScalarDataPropertyValue__ValueTypeAssignment_4_1)
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConceptInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__0__Impl
	rule__ConceptInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getAnnotationsAssignment_0()); }
	(rule__ConceptInstance__AnnotationsAssignment_0)*
	{ after(grammarAccess.getConceptInstanceAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__1__Impl
	rule__ConceptInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_1()); }
	'conceptInstance'
	{ after(grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__2__Impl
	rule__ConceptInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__3__Impl
	rule__ConceptInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getNameAssignment_3()); }
	(rule__ConceptInstance__NameAssignment_3)
	{ after(grammarAccess.getConceptInstanceAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__4__Impl
	rule__ConceptInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getIsAKeyword_4()); }
	'is-a'
	{ after(grammarAccess.getConceptInstanceAccess().getIsAKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__5__Impl
	rule__ConceptInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierAssignment_5()); }
	(rule__ConceptInstance__SingletonConceptClassifierAssignment_5)
	{ after(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConceptInstance__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConceptInstanceAccess().getRightParenthesisKeyword_6()); }
	')'
	{ after(grammarAccess.getConceptInstanceAccess().getRightParenthesisKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationshipInstance__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstance__Group__0__Impl
	rule__ReifiedRelationshipInstance__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAssignment_0()); }
	(rule__ReifiedRelationshipInstance__AnnotationsAssignment_0)*
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstance__Group__1__Impl
	rule__ReifiedRelationshipInstance__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_1()); }
	'reifiedRelationshipInstance'
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstance__Group__2__Impl
	rule__ReifiedRelationshipInstance__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstance__Group__3__Impl
	rule__ReifiedRelationshipInstance__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getNameAssignment_3()); }
	(rule__ReifiedRelationshipInstance__NameAssignment_3)
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getNameAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstance__Group__4__Impl
	rule__ReifiedRelationshipInstance__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_4()); }
	'is-a'
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstance__Group__5__Impl
	rule__ReifiedRelationshipInstance__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonConceptualRelationshipClassifierAssignment_5()); }
	(rule__ReifiedRelationshipInstance__SingletonConceptualRelationshipClassifierAssignment_5)
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonConceptualRelationshipClassifierAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstance__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getRightParenthesisKeyword_6()); }
	')'
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getRightParenthesisKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationshipInstanceDomain__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceDomain__Group__0__Impl
	rule__ReifiedRelationshipInstanceDomain__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAssignment_0()); }
	(rule__ReifiedRelationshipInstanceDomain__AnnotationsAssignment_0)*
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceDomain__Group__1__Impl
	rule__ReifiedRelationshipInstanceDomain__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_1()); }
	'domain'
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceDomain__Group__2__Impl
	rule__ReifiedRelationshipInstanceDomain__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceDomain__Group__3__Impl
	rule__ReifiedRelationshipInstanceDomain__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceAssignment_3()); }
	(rule__ReifiedRelationshipInstanceDomain__ReifiedRelationshipInstanceAssignment_3)
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceDomain__Group__4__Impl
	rule__ReifiedRelationshipInstanceDomain__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceDomain__Group__5__Impl
	rule__ReifiedRelationshipInstanceDomain__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_5()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceDomain__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainAssignment_6()); }
	(rule__ReifiedRelationshipInstanceDomain__DomainAssignment_6)
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationshipInstanceRange__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceRange__Group__0__Impl
	rule__ReifiedRelationshipInstanceRange__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAssignment_0()); }
	(rule__ReifiedRelationshipInstanceRange__AnnotationsAssignment_0)*
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceRange__Group__1__Impl
	rule__ReifiedRelationshipInstanceRange__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_1()); }
	'range'
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceRange__Group__2__Impl
	rule__ReifiedRelationshipInstanceRange__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceRange__Group__3__Impl
	rule__ReifiedRelationshipInstanceRange__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceAssignment_3()); }
	(rule__ReifiedRelationshipInstanceRange__ReifiedRelationshipInstanceAssignment_3)
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceRange__Group__4__Impl
	rule__ReifiedRelationshipInstanceRange__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceRange__Group__5__Impl
	rule__ReifiedRelationshipInstanceRange__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_5()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationshipInstanceRange__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeAssignment_6()); }
	(rule__ReifiedRelationshipInstanceRange__RangeAssignment_6)
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UnreifiedRelationshipInstanceTuple__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__0__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAssignment_0()); }
	(rule__UnreifiedRelationshipInstanceTuple__AnnotationsAssignment_0)*
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__1__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_1()); }
	'tuple'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__2__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__3__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_3()); }
	'unreifiedRelationship'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__4__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipAssignment_4()); }
	(rule__UnreifiedRelationshipInstanceTuple__UnreifiedRelationshipAssignment_4)
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__5__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_5()); }
	'domain'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__6__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainAssignment_6()); }
	(rule__UnreifiedRelationshipInstanceTuple__DomainAssignment_6)
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainAssignment_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__7__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_7()); }
	'range'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__8__Impl
	rule__UnreifiedRelationshipInstanceTuple__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeAssignment_8()); }
	(rule__UnreifiedRelationshipInstanceTuple__RangeAssignment_8)
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationshipInstanceTuple__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRightCurlyBracketKeyword_9()); }
	'}'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRightCurlyBracketKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralBoolean__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralBoolean__Group__0__Impl
	rule__LiteralBoolean__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralBoolean__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralBooleanAccess().getLiteralBooleanAction_0()); }
	()
	{ after(grammarAccess.getLiteralBooleanAccess().getLiteralBooleanAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralBoolean__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralBoolean__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralBoolean__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralBooleanAccess().getBoolAssignment_1()); }
	(rule__LiteralBoolean__BoolAssignment_1)
	{ after(grammarAccess.getLiteralBooleanAccess().getBoolAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralDateTime__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralDateTime__Group__0__Impl
	rule__LiteralDateTime__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDateTime__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralDateTimeAccess().getLiteralDateTimeAction_0()); }
	()
	{ after(grammarAccess.getLiteralDateTimeAccess().getLiteralDateTimeAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDateTime__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralDateTime__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDateTime__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralDateTimeAccess().getDateTimeAssignment_1()); }
	(rule__LiteralDateTime__DateTimeAssignment_1)
	{ after(grammarAccess.getLiteralDateTimeAccess().getDateTimeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralQuotedString__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralQuotedString__Group__0__Impl
	rule__LiteralQuotedString__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralQuotedString__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralQuotedStringAccess().getLiteralQuotedStringAction_0()); }
	()
	{ after(grammarAccess.getLiteralQuotedStringAccess().getLiteralQuotedStringAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralQuotedString__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralQuotedString__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralQuotedString__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralQuotedStringAccess().getStringAssignment_1()); }
	(rule__LiteralQuotedString__StringAssignment_1)
	{ after(grammarAccess.getLiteralQuotedStringAccess().getStringAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralRawString__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralRawString__Group__0__Impl
	rule__LiteralRawString__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRawString__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRawStringAccess().getLiteralRawStringAction_0()); }
	()
	{ after(grammarAccess.getLiteralRawStringAccess().getLiteralRawStringAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRawString__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralRawString__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRawString__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRawStringAccess().getStringAssignment_1()); }
	(rule__LiteralRawString__StringAssignment_1)
	{ after(grammarAccess.getLiteralRawStringAccess().getStringAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralUUID__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralUUID__Group__0__Impl
	rule__LiteralUUID__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralUUID__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralUUIDAccess().getLiteralUUIDAction_0()); }
	()
	{ after(grammarAccess.getLiteralUUIDAccess().getLiteralUUIDAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralUUID__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralUUID__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralUUID__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralUUIDAccess().getUuidAssignment_1()); }
	(rule__LiteralUUID__UuidAssignment_1)
	{ after(grammarAccess.getLiteralUUIDAccess().getUuidAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralURI__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralURI__Group__0__Impl
	rule__LiteralURI__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralURI__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralURIAccess().getLiteralURIAction_0()); }
	()
	{ after(grammarAccess.getLiteralURIAccess().getLiteralURIAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralURI__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralURI__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralURI__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralURIAccess().getUriAssignment_1()); }
	(rule__LiteralURI__UriAssignment_1)
	{ after(grammarAccess.getLiteralURIAccess().getUriAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralReal__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralReal__Group__0__Impl
	rule__LiteralReal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralReal__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRealAccess().getLiteralRealAction_0()); }
	()
	{ after(grammarAccess.getLiteralRealAccess().getLiteralRealAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralReal__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralReal__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralReal__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRealAccess().getRealAssignment_1()); }
	(rule__LiteralReal__RealAssignment_1)
	{ after(grammarAccess.getLiteralRealAccess().getRealAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralRational__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralRational__Group__0__Impl
	rule__LiteralRational__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRational__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRationalAccess().getLiteralRationalAction_0()); }
	()
	{ after(grammarAccess.getLiteralRationalAccess().getLiteralRationalAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRational__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralRational__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRational__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralRationalAccess().getRationalAssignment_1()); }
	(rule__LiteralRational__RationalAssignment_1)
	{ after(grammarAccess.getLiteralRationalAccess().getRationalAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralFloat__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralFloat__Group__0__Impl
	rule__LiteralFloat__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralFloat__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralFloatAccess().getLiteralFloatAction_0()); }
	()
	{ after(grammarAccess.getLiteralFloatAccess().getLiteralFloatAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralFloat__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralFloat__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralFloat__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralFloatAccess().getFloatAssignment_1()); }
	(rule__LiteralFloat__FloatAssignment_1)
	{ after(grammarAccess.getLiteralFloatAccess().getFloatAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralDecimal__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralDecimal__Group_0__0__Impl
	rule__LiteralDecimal__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDecimal__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralDecimalAccess().getLiteralDecimalAction_0_0()); }
	()
	{ after(grammarAccess.getLiteralDecimalAccess().getLiteralDecimalAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDecimal__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralDecimal__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDecimal__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralDecimalAccess().getDecimalAssignment_0_1()); }
	(rule__LiteralDecimal__DecimalAssignment_0_1)
	{ after(grammarAccess.getLiteralDecimalAccess().getDecimalAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationship__UnorderedGroup_4
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalAssignment_4_0()); }
					(rule__ReifiedRelationship__IsFunctionalAssignment_4_0)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalAssignment_4_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalAssignment_4_1()); }
					(rule__ReifiedRelationship__IsInverseFunctionalAssignment_4_1)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalAssignment_4_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsEssentialAssignment_4_2()); }
					(rule__ReifiedRelationship__IsEssentialAssignment_4_2)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsEssentialAssignment_4_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialAssignment_4_3()); }
					(rule__ReifiedRelationship__IsInverseEssentialAssignment_4_3)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialAssignment_4_3()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricAssignment_4_4()); }
					(rule__ReifiedRelationship__IsSymmetricAssignment_4_4)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricAssignment_4_4()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAssignment_4_5()); }
					(rule__ReifiedRelationship__IsAsymmetricAssignment_4_5)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAssignment_4_5()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveAssignment_4_6()); }
					(rule__ReifiedRelationship__IsReflexiveAssignment_4_6)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveAssignment_4_6()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveAssignment_4_7()); }
					(rule__ReifiedRelationship__IsIrreflexiveAssignment_4_7)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveAssignment_4_7()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveAssignment_4_8()); }
					(rule__ReifiedRelationship__IsTransitiveAssignment_4_8)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveAssignment_4_8()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
	rule__ReifiedRelationship__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
	rule__ReifiedRelationship__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
	rule__ReifiedRelationship__UnorderedGroup_4__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
	rule__ReifiedRelationship__UnorderedGroup_4__4?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
	rule__ReifiedRelationship__UnorderedGroup_4__5?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
	rule__ReifiedRelationship__UnorderedGroup_4__6?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
	rule__ReifiedRelationship__UnorderedGroup_4__7?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
	rule__ReifiedRelationship__UnorderedGroup_4__8?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_4__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__UnreifiedRelationship__UnorderedGroup_4
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalAssignment_4_0()); }
					(rule__UnreifiedRelationship__IsFunctionalAssignment_4_0)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalAssignment_4_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalAssignment_4_1()); }
					(rule__UnreifiedRelationship__IsInverseFunctionalAssignment_4_1)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalAssignment_4_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialAssignment_4_2()); }
					(rule__UnreifiedRelationship__IsEssentialAssignment_4_2)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialAssignment_4_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialAssignment_4_3()); }
					(rule__UnreifiedRelationship__IsInverseEssentialAssignment_4_3)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialAssignment_4_3()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricAssignment_4_4()); }
					(rule__UnreifiedRelationship__IsSymmetricAssignment_4_4)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricAssignment_4_4()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAssignment_4_5()); }
					(rule__UnreifiedRelationship__IsAsymmetricAssignment_4_5)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAssignment_4_5()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveAssignment_4_6()); }
					(rule__UnreifiedRelationship__IsReflexiveAssignment_4_6)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveAssignment_4_6()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveAssignment_4_7()); }
					(rule__UnreifiedRelationship__IsIrreflexiveAssignment_4_7)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveAssignment_4_7()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveAssignment_4_8()); }
					(rule__UnreifiedRelationship__IsTransitiveAssignment_4_8)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveAssignment_4_8()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	rule__UnreifiedRelationship__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	rule__UnreifiedRelationship__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	rule__UnreifiedRelationship__UnorderedGroup_4__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	rule__UnreifiedRelationship__UnorderedGroup_4__4?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	rule__UnreifiedRelationship__UnorderedGroup_4__5?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	rule__UnreifiedRelationship__UnorderedGroup_4__6?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	rule__UnreifiedRelationship__UnorderedGroup_4__7?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
	rule__UnreifiedRelationship__UnorderedGroup_4__8?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_4__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__UnorderedGroup_4
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
	}
:
	rule__BinaryScalarRestriction__UnorderedGroup_4__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_0()); }
					(rule__BinaryScalarRestriction__Group_4_0__0)
					{ after(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_1()); }
					(rule__BinaryScalarRestriction__Group_4_1__0)
					{ after(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_2()); }
					(rule__BinaryScalarRestriction__Group_4_2__0)
					{ after(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_4_2()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__UnorderedGroup_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__UnorderedGroup_4__Impl
	rule__BinaryScalarRestriction__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__UnorderedGroup_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__UnorderedGroup_4__Impl
	rule__BinaryScalarRestriction__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__UnorderedGroup_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__UnorderedGroup_4
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_4__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_0()); }
					(rule__IRIScalarRestriction__Group_4_0__0)
					{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_1()); }
					(rule__IRIScalarRestriction__Group_4_1__0)
					{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_2()); }
					(rule__IRIScalarRestriction__Group_4_2__0)
					{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_3()); }
					(rule__IRIScalarRestriction__Group_4_3__0)
					{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup_4_3()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_4__Impl
	rule__IRIScalarRestriction__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_4__Impl
	rule__IRIScalarRestriction__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_4__Impl
	rule__IRIScalarRestriction__UnorderedGroup_4__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__UnorderedGroup_4
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_4__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_0()); }
					(rule__NumericScalarRestriction__Group_4_0__0)
					{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_1()); }
					(rule__NumericScalarRestriction__Group_4_1__0)
					{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_2()); }
					(rule__NumericScalarRestriction__Group_4_2__0)
					{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_3()); }
					(rule__NumericScalarRestriction__Group_4_3__0)
					{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup_4_3()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_4__Impl
	rule__NumericScalarRestriction__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_4__Impl
	rule__NumericScalarRestriction__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_4__Impl
	rule__NumericScalarRestriction__UnorderedGroup_4__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__UnorderedGroup_4
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_0()); }
					(rule__PlainLiteralScalarRestriction__Group_4_0__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_1()); }
					(rule__PlainLiteralScalarRestriction__Group_4_1__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_2()); }
					(rule__PlainLiteralScalarRestriction__Group_4_2__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_3()); }
					(rule__PlainLiteralScalarRestriction__Group_4_3__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_3()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_4()); }
					(rule__PlainLiteralScalarRestriction__Group_4_4__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_4_4()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__Impl
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__Impl
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__Impl
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__Impl
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__4?
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_4__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__UnorderedGroup_4
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
	}
:
	rule__StringScalarRestriction__UnorderedGroup_4__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_0()); }
					(rule__StringScalarRestriction__Group_4_0__0)
					{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_1()); }
					(rule__StringScalarRestriction__Group_4_1__0)
					{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_2()); }
					(rule__StringScalarRestriction__Group_4_2__0)
					{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_3()); }
					(rule__StringScalarRestriction__Group_4_3__0)
					{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup_4_3()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__UnorderedGroup_4__Impl
	rule__StringScalarRestriction__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__UnorderedGroup_4__Impl
	rule__StringScalarRestriction__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__UnorderedGroup_4__Impl
	rule__StringScalarRestriction__UnorderedGroup_4__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__UnorderedGroup_4
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_4__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_4__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_0()); }
					(rule__TimeScalarRestriction__Group_4_0__0)
					{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_1()); }
					(rule__TimeScalarRestriction__Group_4_1__0)
					{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_2()); }
					(rule__TimeScalarRestriction__Group_4_2__0)
					{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_3()); }
					(rule__TimeScalarRestriction__Group_4_3__0)
					{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup_4_3()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_4__Impl
	rule__TimeScalarRestriction__UnorderedGroup_4__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_4__Impl
	rule__TimeScalarRestriction__UnorderedGroup_4__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_4__Impl
	rule__TimeScalarRestriction__UnorderedGroup_4__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_4__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__Extent__ModulesAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExtentAccess().getModulesModuleParserRuleCall_1_0()); }
		ruleModule
		{ after(grammarAccess.getExtentAccess().getModulesModuleParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__AbbrevIRIAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIABBREV_IRITerminalRuleCall_1_0()); }
		RULE_ABBREV_IRI
		{ after(grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIABBREV_IRITerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationProperty__IriAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyAccess().getIriIRITerminalRuleCall_3_0()); }
		RULE_IRI
		{ after(grammarAccess.getAnnotationPropertyAccess().getIriIRITerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__PropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAnnotationPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1()); }
			RULE_ABBREV_IRI
			{ after(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getAnnotationPropertyValueAccess().getPropertyAnnotationPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationPropertyValue__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationPropertyValueAccess().getValueLiteralStringParserRuleCall_3_0()); }
		ruleLiteralString
		{ after(grammarAccess.getAnnotationPropertyValueAccess().getValueLiteralStringParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__AnnotationPropertiesAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0()); }
		ruleAnnotationProperty
		{ after(grammarAccess.getTerminologyGraphAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__AnnotationsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__KindAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_2_0()); }
		ruleTerminologyKind
		{ after(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__IriAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_4_0()); }
		RULE_IRI
		{ after(grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__BoxAxiomsAssignment_6_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0()); }
		ruleTerminologyBoxAxiom
		{ after(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__BoxStatementsAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0()); }
		ruleTerminologyBoxStatement
		{ after(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__AnnotationPropertiesAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0()); }
		ruleAnnotationProperty
		{ after(grammarAccess.getBundleAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__AnnotationsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getBundleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__KindAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_2_0()); }
		ruleTerminologyKind
		{ after(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__IriAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_4_0()); }
		RULE_IRI
		{ after(grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__BoxAxiomsAssignment_6_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0()); }
		ruleTerminologyBoxAxiom
		{ after(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__BoxStatementsAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0()); }
		ruleTerminologyBoxStatement
		{ after(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__BundleStatementsAssignment_6_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_6_2_0()); }
		ruleTerminologyBundleStatement
		{ after(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_6_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__BundleAxiomsAssignment_6_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_6_3_0()); }
		ruleTerminologyBundleAxiom
		{ after(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_6_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__AnnotationPropertiesAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0()); }
		ruleAnnotationProperty
		{ after(grammarAccess.getDescriptionBoxAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__AnnotationsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__KindAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_2_0()); }
		ruleDescriptionKind
		{ after(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__IriAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_4_0()); }
		RULE_IRI
		{ after(grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ClosedWorldDefinitionsAssignment_6_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_6_0_0()); }
		ruleDescriptionBoxExtendsClosedWorldDefinitions
		{ after(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_6_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__DescriptionBoxRefinementsAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_6_1_0()); }
		ruleDescriptionBoxRefinement
		{ after(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ConceptInstancesAssignment_6_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_6_2_0()); }
		ruleConceptInstance
		{ after(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_6_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ReifiedRelationshipInstancesAssignment_6_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_6_3_0()); }
		ruleReifiedRelationshipInstance
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_6_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ReifiedRelationshipInstanceDomainsAssignment_6_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_6_4_0()); }
		ruleReifiedRelationshipInstanceDomain
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_6_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ReifiedRelationshipInstanceRangesAssignment_6_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_6_5_0()); }
		ruleReifiedRelationshipInstanceRange
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_6_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__UnreifiedRelationshipInstanceTuplesAssignment_6_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_6_6_0()); }
		ruleUnreifiedRelationshipInstanceTuple
		{ after(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_6_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__SingletonScalarDataPropertyValuesAssignment_6_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_6_7_0()); }
		ruleSingletonInstanceScalarDataPropertyValue
		{ after(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_6_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__SingletonStructuredDataPropertyValuesAssignment_6_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_6_8_0()); }
		ruleSingletonInstanceStructuredDataPropertyValue
		{ after(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_6_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundledTerminologyAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundledTerminologyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getBundledTerminologyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundledTerminologyAxiom__BundledTerminologyAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_2_0()); }
		(
			{ before(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__DesignatedTerminologyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_4_0()); }
		(
			{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__DesignatedConceptAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_6_0()); }
		(
			{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyExtensionAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyExtensionAxiom__ExtendedTerminologyAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_2_0()); }
		(
			{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyNestingAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getTerminologyNestingAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__NestingTerminologyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_4_0()); }
		(
			{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__NestingContextAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_6_0()); }
		(
			{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getAspectAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__RestrictionKindAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0()); }
		ruleCardinalityRestrictionKind
		{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__RestrictedCardinalityAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__RestrictedRelationshipAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0()); }
		(
			{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedAspect__RestrictedRangeAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRangeEntityCrossReference_6_1_0()); }
		(
			{ before(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1()); }
		)
		{ after(grammarAccess.getCardinalityRestrictedAspectAccess().getRestrictedRangeEntityCrossReference_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getConceptAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__RestrictionKindAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0()); }
		ruleCardinalityRestrictionKind
		{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__RestrictedCardinalityAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__RestrictedRelationshipAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0()); }
		(
			{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedConcept__RestrictedRangeAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRangeEntityCrossReference_6_1_0()); }
		(
			{ before(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1()); }
		)
		{ after(grammarAccess.getCardinalityRestrictedConceptAccess().getRestrictedRangeEntityCrossReference_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getReifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsFunctionalAssignment_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0()); }
			'functional'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsInverseFunctionalAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0()); }
			'inverseFunctional'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsEssentialAssignment_4_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0()); }
			'essential'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsInverseEssentialAssignment_4_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0()); }
			'inverseEssential'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsSymmetricAssignment_4_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0()); }
			'symmetric'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsAsymmetricAssignment_4_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0()); }
			'asymmetric'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsReflexiveAssignment_4_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0()); }
			'reflexive'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsIrreflexiveAssignment_4_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0()); }
			'irreflexive'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsTransitiveAssignment_4_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0()); }
			'transitive'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__ForwardPropertyAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getForwardPropertyForwardPropertyParserRuleCall_7_0()); }
		ruleForwardProperty
		{ after(grammarAccess.getReifiedRelationshipAccess().getForwardPropertyForwardPropertyParserRuleCall_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__InversePropertyAssignment_8_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getInversePropertyInversePropertyParserRuleCall_8_2_0()); }
		ruleInverseProperty
		{ after(grammarAccess.getReifiedRelationshipAccess().getInversePropertyInversePropertyParserRuleCall_8_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__SourceAssignment_11
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_11_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getSourceEntityReferenceParserRuleCall_11_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipAccess().getSourceEntityReferenceParserRuleCall_11_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_11_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__TargetAssignment_14
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_14_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getTargetEntityReferenceParserRuleCall_14_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipAccess().getTargetEntityReferenceParserRuleCall_14_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_14_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ForwardProperty__NameAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getForwardPropertyAccess().getNameIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getForwardPropertyAccess().getNameIDTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InverseProperty__NameAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInversePropertyAccess().getNameIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getInversePropertyAccess().getNameIDTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__SourceAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceEntityCrossReference_6_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceEntityReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceEntityReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceEntityCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipRestriction__TargetAssignment_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetEntityCrossReference_9_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetEntityReferenceParserRuleCall_9_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetEntityReferenceParserRuleCall_9_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetEntityCrossReference_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__RestrictionKindAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0()); }
		ruleCardinalityRestrictionKind
		{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictionKindCardinalityRestrictionKindEnumRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__RestrictedCardinalityAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedCardinalityPositiveIntegerLiteralParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__RestrictedRelationshipAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0()); }
		(
			{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRelationshipRestrictableRelationshipReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CardinalityRestrictedReifiedRelationship__RestrictedRangeAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRangeEntityCrossReference_6_1_0()); }
		(
			{ before(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRangeEntityReferenceParserRuleCall_6_1_0_1()); }
		)
		{ after(grammarAccess.getCardinalityRestrictedReifiedRelationshipAccess().getRestrictedRangeEntityCrossReference_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsFunctionalAssignment_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0()); }
			'functional'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsInverseFunctionalAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0()); }
			'inverseFunctional'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsEssentialAssignment_4_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0()); }
			'essential'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsInverseEssentialAssignment_4_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0()); }
			'inverseEssential'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsSymmetricAssignment_4_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0()); }
			'symmetric'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsAsymmetricAssignment_4_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0()); }
			'asymmetric'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsReflexiveAssignment_4_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0()); }
			'reflexive'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsIrreflexiveAssignment_4_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0()); }
			'irreflexive'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsTransitiveAssignment_4_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0()); }
			'transitive'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__SourceAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_7_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityReferenceParserRuleCall_7_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityReferenceParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__TargetAssignment_10
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_10_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityReferenceParserRuleCall_10_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityReferenceParserRuleCall_10_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_10_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getScalarAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getStructureAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__IsIdentityCriteriaAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0()); }
			'+'
			{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__DomainAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_6_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__RangeAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_8_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_8_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_8_0_1()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__IsIdentityCriteriaAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0()); }
			'+'
			{ after(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__DomainAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_6_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__RangeAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_8_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_8_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_8_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__DomainAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_5_0()); }
		(
			{ before(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__RangeAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0()); }
		(
			{ before(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_7_0_1()); }
			ruleReference
			{ after(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__DomainAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_5_0()); }
		(
			{ before(grammarAccess.getScalarDataPropertyAccess().getDomainStructureReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarDataPropertyAccess().getDomainStructureReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__RangeAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0()); }
		(
			{ before(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_7_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getChainRuleAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getChainRuleAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__HeadAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getChainRuleAccess().getHeadUnreifiedRelationshipCrossReference_3_0()); }
		(
			{ before(grammarAccess.getChainRuleAccess().getHeadUnreifiedRelationshipReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getChainRuleAccess().getHeadUnreifiedRelationshipReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getChainRuleAccess().getHeadUnreifiedRelationshipCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChainRule__FirstSegmentAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getChainRuleAccess().getFirstSegmentRuleBodySegmentParserRuleCall_5_0()); }
		ruleRuleBodySegment
		{ after(grammarAccess.getChainRuleAccess().getFirstSegmentRuleBodySegmentParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleBodySegment__PredicateAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleBodySegmentAccess().getPredicateSegmentPredicateParserRuleCall_0_0()); }
		ruleSegmentPredicate
		{ after(grammarAccess.getRuleBodySegmentAccess().getPredicateSegmentPredicateParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleBodySegment__NextSegmentAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleBodySegmentAccess().getNextSegmentRuleBodySegmentParserRuleCall_1_1_0()); }
		ruleRuleBodySegment
		{ after(grammarAccess.getRuleBodySegmentAccess().getNextSegmentRuleBodySegmentParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__PredicateAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getPredicatePredicateCrossReference_0_0()); }
		(
			{ before(grammarAccess.getSegmentPredicateAccess().getPredicatePredicateQNAMEParserRuleCall_0_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getSegmentPredicateAccess().getPredicatePredicateQNAMEParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getSegmentPredicateAccess().getPredicatePredicateCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__ReifiedRelationshipSourceAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceReifiedRelationshipCrossReference_1_2_0()); }
		(
			{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceReifiedRelationshipQNAMEParserRuleCall_1_2_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceReifiedRelationshipQNAMEParserRuleCall_1_2_0_1()); }
		)
		{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceReifiedRelationshipCrossReference_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__ReifiedRelationshipInverseSourceAssignment_2_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceReifiedRelationshipCrossReference_2_2_0()); }
		(
			{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceReifiedRelationshipQNAMEParserRuleCall_2_2_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceReifiedRelationshipQNAMEParserRuleCall_2_2_0_1()); }
		)
		{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceReifiedRelationshipCrossReference_2_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__ReifiedRelationshipTargetAssignment_3_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetReifiedRelationshipCrossReference_3_2_0()); }
		(
			{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetReifiedRelationshipQNAMEParserRuleCall_3_2_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetReifiedRelationshipQNAMEParserRuleCall_3_2_0_1()); }
		)
		{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetReifiedRelationshipCrossReference_3_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__ReifiedRelationshipInverseTargetAssignment_4_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetReifiedRelationshipCrossReference_4_2_0()); }
		(
			{ before(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetReifiedRelationshipQNAMEParserRuleCall_4_2_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetReifiedRelationshipQNAMEParserRuleCall_4_2_0_1()); }
		)
		{ after(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetReifiedRelationshipCrossReference_4_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SegmentPredicate__UnreifiedRelationshipInverseAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseUnreifiedRelationshipCrossReference_5_2_0()); }
		(
			{ before(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseUnreifiedRelationshipQNAMEParserRuleCall_5_2_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseUnreifiedRelationshipQNAMEParserRuleCall_5_2_0_1()); }
		)
		{ after(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseUnreifiedRelationshipCrossReference_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__DisjunctionsAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0()); }
		ruleDisjointUnionOfConceptsAxiom
		{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__RootAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_3_0()); }
		(
			{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__DisjunctionsAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0()); }
		ruleDisjointUnionOfConceptsAxiom
		{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__DisjointLeafAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_3_0()); }
		(
			{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptQNAMEParserRuleCall_3_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptQNAMEParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__RestrictedDomainAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0()); }
		(
			{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityQNAMEParserRuleCall_2_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityQNAMEParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__RestrictedRelationshipAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0()); }
		(
			{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__RestrictedRangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0()); }
		(
			{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityQNAMEParserRuleCall_6_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityQNAMEParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__RestrictedDomainAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0()); }
		(
			{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityQNAMEParserRuleCall_2_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityQNAMEParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__RestrictedRelationshipAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0()); }
		(
			{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipQNAMEParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__RestrictedRangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0()); }
		(
			{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityQNAMEParserRuleCall_6_0_1()); }
			ruleQNAME
			{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityQNAMEParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getAspectSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__SubEntityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__SuperAspectAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_3_0()); }
		(
			{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getConceptSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__SubConceptAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_1_0()); }
		(
			{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__SuperConceptAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_3_0()); }
		(
			{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__SubRelationshipAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipConceptualRelationshipCrossReference_1_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipConceptualRelationshipReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipConceptualRelationshipReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipConceptualRelationshipCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__SuperRelationshipAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipConceptualRelationshipCrossReference_3_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipConceptualRelationshipReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipConceptualRelationshipReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipConceptualRelationshipCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__SubPropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyUnreifiedRelationshipCrossReference_1_0()); }
		(
			{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyUnreifiedRelationshipReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyUnreifiedRelationshipReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyUnreifiedRelationshipCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubObjectPropertyOfAxiom__SuperPropertyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSuperPropertyUnreifiedRelationshipCrossReference_3_0()); }
		(
			{ before(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSuperPropertyUnreifiedRelationshipReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSuperPropertyUnreifiedRelationshipReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSuperPropertyUnreifiedRelationshipCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__SubPropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyEntityScalarDataPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyEntityScalarDataPropertyReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyEntityScalarDataPropertyReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyEntityScalarDataPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SubDataPropertyOfAxiom__SuperPropertyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getSuperPropertyEntityScalarDataPropertyCrossReference_3_0()); }
		(
			{ before(grammarAccess.getSubDataPropertyOfAxiomAccess().getSuperPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getSuperPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getSubDataPropertyOfAxiomAccess().getSuperPropertyEntityScalarDataPropertyCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__RestrictedEntityAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarPropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarRestrictionAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__ScalarPropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__LiteralValueAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueLiteralValueParserRuleCall_6_0()); }
		ruleLiteralValue
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueLiteralValueParserRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__ValueTypeAssignment_7_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeDataRangeCrossReference_7_1_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeDataRangeReferenceParserRuleCall_7_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeDataRangeReferenceParserRuleCall_7_1_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeDataRangeCrossReference_7_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__RestrictedEntityAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarPropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarRestrictionAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_4_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyRestrictionsAssignment_7_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0()); }
		ruleRestrictionStructuredDataPropertyTuple
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__ScalarDataPropertyRestrictionsAssignment_7_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0()); }
		ruleRestrictionScalarDataPropertyValue
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyRestrictionsAssignment_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0()); }
		ruleRestrictionStructuredDataPropertyTuple
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__ScalarDataPropertyRestrictionsAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0()); }
		ruleRestrictionScalarDataPropertyValue
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__ScalarDataPropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__ScalarPropertyValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0()); }
		ruleLiteralValue
		{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__ValueTypeAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_4_1_0()); }
		(
			{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeDataRangeReferenceParserRuleCall_4_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeDataRangeReferenceParserRuleCall_4_1_0_1()); }
		)
		{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__LengthAssignment_4_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__MinLengthAssignment_4_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__MaxLengthAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__RestrictedRangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__LengthAssignment_4_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__MinLengthAssignment_4_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__MaxLengthAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__PatternAssignment_4_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0()); }
		RULE_PATTERN
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__RestrictedRangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__MinInclusiveAssignment_4_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveLiteralNumberParserRuleCall_4_0_1_0()); }
		ruleLiteralNumber
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveLiteralNumberParserRuleCall_4_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__MaxInclusiveAssignment_4_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0()); }
		ruleLiteralNumber
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__MinExclusiveAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveLiteralNumberParserRuleCall_4_2_1_0()); }
		ruleLiteralNumber
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveLiteralNumberParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__MaxExclusiveAssignment_4_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0()); }
		ruleLiteralNumber
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__RestrictedRangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__LengthAssignment_4_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__MinLengthAssignment_4_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__MaxLengthAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__PatternAssignment_4_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0()); }
		RULE_PATTERN
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__LangRangeAssignment_4_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeLANG_TAGTerminalRuleCall_4_4_1_0()); }
		RULE_LANG_TAG
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeLANG_TAGTerminalRuleCall_4_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__RestrictedRangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__AxiomAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_2_0()); }
		(
			{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__ValueAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueLiteralValueParserRuleCall_4_0()); }
		ruleLiteralValue
		{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueLiteralValueParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__ValueTypeAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeDataRangeCrossReference_5_1_0()); }
		(
			{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeDataRangeReferenceParserRuleCall_5_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeDataRangeReferenceParserRuleCall_5_1_0_1()); }
		)
		{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeDataRangeCrossReference_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__LengthAssignment_4_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getStringScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__MinLengthAssignment_4_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getStringScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__MaxLengthAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0()); }
		rulePositiveIntegerLiteral
		{ after(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__PatternAssignment_4_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0()); }
		RULE_PATTERN
		{ after(grammarAccess.getStringScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__RestrictedRangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__MinInclusiveAssignment_4_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0()); }
		ruleLiteralDateTime
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__MaxInclusiveAssignment_4_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0()); }
		ruleLiteralDateTime
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__MinExclusiveAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0()); }
		ruleLiteralDateTime
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__MaxExclusiveAssignment_4_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0()); }
		ruleLiteralDateTime
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__RestrictedRangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxExtendsClosedWorldDefinitions__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxExtendsClosedWorldDefinitions__ClosedWorldDefinitionsAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxCrossReference_2_0()); }
		(
			{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_2_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxRefinement__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxRefinement__RefinedDescriptionBoxAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxCrossReference_2_0()); }
		(
			{ before(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_2_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__SingletonInstanceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__ScalarDataPropertyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyCrossReference_3_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__ScalarPropertyValueAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_5_0()); }
		ruleLiteralValue
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__ValueTypeAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_6_1_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeDataRangeReferenceParserRuleCall_6_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeDataRangeReferenceParserRuleCall_6_1_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__SingletonInstanceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__StructuredDataPropertyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_3_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__StructuredPropertyTuplesAssignment_6_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0()); }
		ruleStructuredDataPropertyTuple
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__ScalarDataPropertyValuesAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0()); }
		ruleScalarDataPropertyValue
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__StructuredDataPropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_1_0()); }
		(
			{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0()); }
		ruleStructuredDataPropertyTuple
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0()); }
		ruleScalarDataPropertyValue
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__ScalarDataPropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarCrossReference_1_0()); }
		(
			{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__ScalarPropertyValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0()); }
		ruleLiteralValue
		{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__ValueTypeAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_4_1_0()); }
		(
			{ before(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeDataRangeReferenceParserRuleCall_4_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeDataRangeReferenceParserRuleCall_4_1_0_1()); }
		)
		{ after(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getConceptInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__SingletonConceptClassifierAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_5_0()); }
		(
			{ before(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__NameAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_3_0()); }
		RULE_ID
		{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__SingletonConceptualRelationshipClassifierAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonConceptualRelationshipClassifierConceptualRelationshipCrossReference_5_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonConceptualRelationshipClassifierConceptualRelationshipReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonConceptualRelationshipClassifierConceptualRelationshipReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonConceptualRelationshipClassifierConceptualRelationshipCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__ReifiedRelationshipInstanceAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__DomainAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__ReifiedRelationshipInstanceAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__RangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceCrossReference_6_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
		ruleAnnotationPropertyValue
		{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__UnreifiedRelationshipAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__DomainAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__RangeAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_8_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_8_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_8_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralBoolean__BoolAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralBooleanAccess().getBoolAlternatives_1_0()); }
		(rule__LiteralBoolean__BoolAlternatives_1_0)
		{ after(grammarAccess.getLiteralBooleanAccess().getBoolAlternatives_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDateTime__DateTimeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralDateTimeAccess().getDateTimeDATE_TIMETerminalRuleCall_1_0()); }
		RULE_DATE_TIME
		{ after(grammarAccess.getLiteralDateTimeAccess().getDateTimeDATE_TIMETerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralQuotedString__StringAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralQuotedStringAccess().getStringQUOTED_STRING_VALUETerminalRuleCall_1_0()); }
		RULE_QUOTED_STRING_VALUE
		{ after(grammarAccess.getLiteralQuotedStringAccess().getStringQUOTED_STRING_VALUETerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRawString__StringAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralRawStringAccess().getStringRAW_STRING_VALUETerminalRuleCall_1_0()); }
		RULE_RAW_STRING_VALUE
		{ after(grammarAccess.getLiteralRawStringAccess().getStringRAW_STRING_VALUETerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralUUID__UuidAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralUUIDAccess().getUuidUUIDDataTypeParserRuleCall_1_0()); }
		ruleUUIDDataType
		{ after(grammarAccess.getLiteralUUIDAccess().getUuidUUIDDataTypeParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralURI__UriAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralURIAccess().getUriURIDataTypeParserRuleCall_1_0()); }
		ruleURIDataType
		{ after(grammarAccess.getLiteralURIAccess().getUriURIDataTypeParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralReal__RealAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralRealAccess().getRealREALTerminalRuleCall_1_0()); }
		RULE_REAL
		{ after(grammarAccess.getLiteralRealAccess().getRealREALTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralRational__RationalAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralRationalAccess().getRationalRationalDataTypeParserRuleCall_1_0()); }
		ruleRationalDataType
		{ after(grammarAccess.getLiteralRationalAccess().getRationalRationalDataTypeParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralFloat__FloatAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralFloatAccess().getFloatFLOATTerminalRuleCall_1_0()); }
		RULE_FLOAT
		{ after(grammarAccess.getLiteralFloatAccess().getFloatFLOATTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDecimal__DecimalAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralDecimalAccess().getDecimalDIGITSTerminalRuleCall_0_1_0()); }
		RULE_DIGITS
		{ after(grammarAccess.getLiteralDecimalAccess().getDecimalDIGITSTerminalRuleCall_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralDecimal__DecimalAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralDecimalAccess().getDecimalDECIMALTerminalRuleCall_1_0()); }
		RULE_DECIMAL
		{ after(grammarAccess.getLiteralDecimalAccess().getDecimalDECIMALTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

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
