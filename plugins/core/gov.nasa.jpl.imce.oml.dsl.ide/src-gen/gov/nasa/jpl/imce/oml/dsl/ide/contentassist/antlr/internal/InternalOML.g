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

// Entry rule entryRuleAnnotation
entryRuleAnnotation
:
{ before(grammarAccess.getAnnotationRule()); }
	 ruleAnnotation
{ after(grammarAccess.getAnnotationRule()); } 
	 EOF 
;

// Rule Annotation
ruleAnnotation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotationAccess().getGroup()); }
		(rule__Annotation__Group__0)
		{ after(grammarAccess.getAnnotationAccess().getGroup()); }
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

// Entry rule entryRuleValue
entryRuleValue
:
{ before(grammarAccess.getValueRule()); }
	 ruleValue
{ after(grammarAccess.getValueRule()); } 
	 EOF 
;

// Rule Value
ruleValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getValueAccess().getAlternatives()); }
		(rule__Value__Alternatives)
		{ after(grammarAccess.getValueAccess().getAlternatives()); }
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

rule__Extent__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExtentAccess().getAnnotationPropertiesAssignment_1_0()); }
		(rule__Extent__AnnotationPropertiesAssignment_1_0)
		{ after(grammarAccess.getExtentAccess().getAnnotationPropertiesAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getExtentAccess().getModulesAssignment_1_1()); }
		(rule__Extent__ModulesAssignment_1_1)
		{ after(grammarAccess.getExtentAccess().getModulesAssignment_1_1()); }
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

rule__TerminologyGraph__Alternatives_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_5_0()); }
		(rule__TerminologyGraph__AnnotationsAssignment_5_0)
		{ after(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_5_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsAssignment_5_1()); }
		(rule__TerminologyGraph__BoxAxiomsAssignment_5_1)
		{ after(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsAssignment_5_1()); }
	)
	|
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getBoxStatementsAssignment_5_2()); }
		(rule__TerminologyGraph__BoxStatementsAssignment_5_2)
		{ after(grammarAccess.getTerminologyGraphAccess().getBoxStatementsAssignment_5_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__Alternatives_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getAnnotationsAssignment_5_0()); }
		(rule__Bundle__AnnotationsAssignment_5_0)
		{ after(grammarAccess.getBundleAccess().getAnnotationsAssignment_5_0()); }
	)
	|
	(
		{ before(grammarAccess.getBundleAccess().getBoxAxiomsAssignment_5_1()); }
		(rule__Bundle__BoxAxiomsAssignment_5_1)
		{ after(grammarAccess.getBundleAccess().getBoxAxiomsAssignment_5_1()); }
	)
	|
	(
		{ before(grammarAccess.getBundleAccess().getBoxStatementsAssignment_5_2()); }
		(rule__Bundle__BoxStatementsAssignment_5_2)
		{ after(grammarAccess.getBundleAccess().getBoxStatementsAssignment_5_2()); }
	)
	|
	(
		{ before(grammarAccess.getBundleAccess().getBundleStatementsAssignment_5_3()); }
		(rule__Bundle__BundleStatementsAssignment_5_3)
		{ after(grammarAccess.getBundleAccess().getBundleStatementsAssignment_5_3()); }
	)
	|
	(
		{ before(grammarAccess.getBundleAccess().getBundleAxiomsAssignment_5_4()); }
		(rule__Bundle__BundleAxiomsAssignment_5_4)
		{ after(grammarAccess.getBundleAccess().getBundleAxiomsAssignment_5_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__Alternatives_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_5_0()); }
		(rule__DescriptionBox__AnnotationsAssignment_5_0)
		{ after(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_5_0()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsAssignment_5_1()); }
		(rule__DescriptionBox__ClosedWorldDefinitionsAssignment_5_1)
		{ after(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsAssignment_5_1()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsAssignment_5_2()); }
		(rule__DescriptionBox__DescriptionBoxRefinementsAssignment_5_2)
		{ after(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsAssignment_5_2()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getConceptInstancesAssignment_5_3()); }
		(rule__DescriptionBox__ConceptInstancesAssignment_5_3)
		{ after(grammarAccess.getDescriptionBoxAccess().getConceptInstancesAssignment_5_3()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesAssignment_5_4()); }
		(rule__DescriptionBox__ReifiedRelationshipInstancesAssignment_5_4)
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesAssignment_5_4()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsAssignment_5_5()); }
		(rule__DescriptionBox__ReifiedRelationshipInstanceDomainsAssignment_5_5)
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsAssignment_5_5()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesAssignment_5_6()); }
		(rule__DescriptionBox__ReifiedRelationshipInstanceRangesAssignment_5_6)
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesAssignment_5_6()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesAssignment_5_7()); }
		(rule__DescriptionBox__UnreifiedRelationshipInstanceTuplesAssignment_5_7)
		{ after(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesAssignment_5_7()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesAssignment_5_8()); }
		(rule__DescriptionBox__SingletonScalarDataPropertyValuesAssignment_5_8)
		{ after(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesAssignment_5_8()); }
	)
	|
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesAssignment_5_9()); }
		(rule__DescriptionBox__SingletonStructuredDataPropertyValuesAssignment_5_9)
		{ after(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesAssignment_5_9()); }
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
		{ before(grammarAccess.getAtomicEntityAccess().getConceptParserRuleCall_1()); }
		ruleConcept
		{ after(grammarAccess.getAtomicEntityAccess().getConceptParserRuleCall_1()); }
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
		{ before(grammarAccess.getEntityRelationshipAccess().getUnreifiedRelationshipParserRuleCall_1()); }
		ruleUnreifiedRelationship
		{ after(grammarAccess.getEntityRelationshipAccess().getUnreifiedRelationshipParserRuleCall_1()); }
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

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Alternatives_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredPropertyTuplesAssignment_6_0()); }
		(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredPropertyTuplesAssignment_6_0)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredPropertyTuplesAssignment_6_0()); }
	)
	|
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyValuesAssignment_6_1()); }
		(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__ScalarDataPropertyValuesAssignment_6_1)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyValuesAssignment_6_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__Alternatives_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_3_0()); }
		(rule__RestrictionStructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_3_0)
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_3_0()); }
	)
	|
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_3_1()); }
		(rule__RestrictionStructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_3_1)
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_3_1()); }
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

rule__SingletonInstanceStructuredDataPropertyValue__Alternatives_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesAssignment_5_0()); }
		(rule__SingletonInstanceStructuredDataPropertyValue__StructuredPropertyTuplesAssignment_5_0)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesAssignment_5_0()); }
	)
	|
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesAssignment_5_1()); }
		(rule__SingletonInstanceStructuredDataPropertyValue__ScalarDataPropertyValuesAssignment_5_1)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesAssignment_5_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__Alternatives_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_3_0()); }
		(rule__StructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_3_0)
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesAssignment_3_0()); }
	)
	|
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_3_1()); }
		(rule__StructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_3_1)
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesAssignment_3_1()); }
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

rule__Value__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getValueAccess().getDECIMALTerminalRuleCall_0()); }
		RULE_DECIMAL
		{ after(grammarAccess.getValueAccess().getDECIMALTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getValueAccess().getINTTerminalRuleCall_1()); }
		RULE_INT
		{ after(grammarAccess.getValueAccess().getINTTerminalRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_2()); }
		RULE_STRING
		{ after(grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getValueAccess().getUUIDTerminalRuleCall_3()); }
		RULE_UUID
		{ after(grammarAccess.getValueAccess().getUUIDTerminalRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getValueAccess().getHEXTerminalRuleCall_4()); }
		RULE_HEX
		{ after(grammarAccess.getValueAccess().getHEXTerminalRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getValueAccess().getFLOATTerminalRuleCall_5()); }
		RULE_FLOAT
		{ after(grammarAccess.getValueAccess().getFLOATTerminalRuleCall_5()); }
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
	{ before(grammarAccess.getExtentAccess().getAlternatives_1()); }
	(rule__Extent__Alternatives_1)*
	{ after(grammarAccess.getExtentAccess().getAlternatives_1()); }
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


rule__Annotation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__0__Impl
	rule__Annotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); }
	'@'
	{ after(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__1__Impl
	rule__Annotation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getPropertyAssignment_1()); }
	(rule__Annotation__PropertyAssignment_1)
	{ after(grammarAccess.getAnnotationAccess().getPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__2__Impl
	rule__Annotation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getAnnotationAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getValueAssignment_3()); }
	(rule__Annotation__ValueAssignment_3)
	{ after(grammarAccess.getAnnotationAccess().getValueAssignment_3()); }
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
	{ before(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_0()); }
	(rule__TerminologyGraph__AnnotationsAssignment_0)*
	{ after(grammarAccess.getTerminologyGraphAccess().getAnnotationsAssignment_0()); }
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
	{ before(grammarAccess.getTerminologyGraphAccess().getKindAssignment_1()); }
	(rule__TerminologyGraph__KindAssignment_1)
	{ after(grammarAccess.getTerminologyGraphAccess().getKindAssignment_1()); }
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
	{ before(grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_2()); }
	'terminology'
	{ after(grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_2()); }
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
	{ before(grammarAccess.getTerminologyGraphAccess().getIriAssignment_3()); }
	(rule__TerminologyGraph__IriAssignment_3)
	{ after(grammarAccess.getTerminologyGraphAccess().getIriAssignment_3()); }
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
	{ before(grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_4()); }
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
	{ before(grammarAccess.getTerminologyGraphAccess().getAlternatives_5()); }
	(rule__TerminologyGraph__Alternatives_5)*
	{ after(grammarAccess.getTerminologyGraphAccess().getAlternatives_5()); }
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
	{ before(grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_6()); }
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
	{ before(grammarAccess.getBundleAccess().getAnnotationsAssignment_0()); }
	(rule__Bundle__AnnotationsAssignment_0)*
	{ after(grammarAccess.getBundleAccess().getAnnotationsAssignment_0()); }
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
	{ before(grammarAccess.getBundleAccess().getKindAssignment_1()); }
	(rule__Bundle__KindAssignment_1)
	{ after(grammarAccess.getBundleAccess().getKindAssignment_1()); }
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
	{ before(grammarAccess.getBundleAccess().getBundleKeyword_2()); }
	'bundle'
	{ after(grammarAccess.getBundleAccess().getBundleKeyword_2()); }
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
	{ before(grammarAccess.getBundleAccess().getIriAssignment_3()); }
	(rule__Bundle__IriAssignment_3)
	{ after(grammarAccess.getBundleAccess().getIriAssignment_3()); }
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
	{ before(grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_4()); }
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
	{ before(grammarAccess.getBundleAccess().getAlternatives_5()); }
	(rule__Bundle__Alternatives_5)*
	{ after(grammarAccess.getBundleAccess().getAlternatives_5()); }
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
	{ before(grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_6()); }
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
	{ before(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_0()); }
	(rule__DescriptionBox__AnnotationsAssignment_0)*
	{ after(grammarAccess.getDescriptionBoxAccess().getAnnotationsAssignment_0()); }
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
	{ before(grammarAccess.getDescriptionBoxAccess().getKindAssignment_1()); }
	(rule__DescriptionBox__KindAssignment_1)
	{ after(grammarAccess.getDescriptionBoxAccess().getKindAssignment_1()); }
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
	{ before(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_2()); }
	'descriptionBox'
	{ after(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_2()); }
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
	{ before(grammarAccess.getDescriptionBoxAccess().getIriAssignment_3()); }
	(rule__DescriptionBox__IriAssignment_3)
	{ after(grammarAccess.getDescriptionBoxAccess().getIriAssignment_3()); }
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
	{ before(grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_4()); }
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
	{ before(grammarAccess.getDescriptionBoxAccess().getAlternatives_5()); }
	(rule__DescriptionBox__Alternatives_5)*
	{ after(grammarAccess.getDescriptionBoxAccess().getAlternatives_5()); }
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
	{ before(grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_6()); }
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
	{ before(grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_0()); }
	'bundles'
	{ after(grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_0()); }
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
	{ before(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyAssignment_1()); }
	(rule__BundledTerminologyAxiom__BundledTerminologyAssignment_1)
	{ after(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyAssignment_1()); }
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
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_0()); }
	'conceptDesignationTerminologyAxiom'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_0()); }
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
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_1()); }
	'{'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_1()); }
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
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_2()); }
	'designatedTerminology'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_2()); }
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
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyAssignment_3()); }
	(rule__ConceptDesignationTerminologyAxiom__DesignatedTerminologyAssignment_3)
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyAssignment_3()); }
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
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_4()); }
	'designatedConcept'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_4()); }
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
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptAssignment_5()); }
	(rule__ConceptDesignationTerminologyAxiom__DesignatedConceptAssignment_5)
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptAssignment_5()); }
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
	{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRightCurlyBracketKeyword_6()); }
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
	{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_0()); }
	'extends'
	{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_0()); }
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
	{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyAssignment_1()); }
	(rule__TerminologyExtensionAxiom__ExtendedTerminologyAssignment_1)
	{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyAssignment_1()); }
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
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_0()); }
	'terminologyNestingAxiom'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_0()); }
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
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_1()); }
	'{'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_1()); }
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
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_2()); }
	'nestingTerminology'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_2()); }
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
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyAssignment_3()); }
	(rule__TerminologyNestingAxiom__NestingTerminologyAssignment_3)
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyAssignment_3()); }
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
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_4()); }
	'nestingContext'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_4()); }
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
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextAssignment_5()); }
	(rule__TerminologyNestingAxiom__NestingContextAssignment_5)
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextAssignment_5()); }
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
	{ before(grammarAccess.getTerminologyNestingAxiomAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getTerminologyNestingAxiomAccess().getRightCurlyBracketKeyword_6()); }
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
	{ before(grammarAccess.getAspectAccess().getAspectKeyword_0()); }
	'aspect'
	{ after(grammarAccess.getAspectAccess().getAspectKeyword_0()); }
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
	{ before(grammarAccess.getAspectAccess().getNameAssignment_1()); }
	(rule__Aspect__NameAssignment_1)
	{ after(grammarAccess.getAspectAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getConceptAccess().getConceptKeyword_0()); }
	'concept'
	{ after(grammarAccess.getConceptAccess().getConceptKeyword_0()); }
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
	{ before(grammarAccess.getConceptAccess().getNameAssignment_1()); }
	(rule__Concept__NameAssignment_1)
	{ after(grammarAccess.getConceptAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_0()); }
	'reifiedRelationship'
	{ after(grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_0()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getNameAssignment_1()); }
	(rule__ReifiedRelationship__NameAssignment_1)
	{ after(grammarAccess.getReifiedRelationshipAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3()); }
	(rule__ReifiedRelationship__UnorderedGroup_3)
	{ after(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_4()); }
	'unreified'
	{ after(grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_4()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_5()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_5()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameAssignment_6()); }
	(rule__ReifiedRelationship__UnreifiedPropertyNameAssignment_6)
	{ after(grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameAssignment_6()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getGroup_7()); }
	(rule__ReifiedRelationship__Group_7__0)?
	{ after(grammarAccess.getReifiedRelationshipAccess().getGroup_7()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_8()); }
	'source'
	{ after(grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_8()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_9()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_9()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getSourceAssignment_10()); }
	(rule__ReifiedRelationship__SourceAssignment_10)
	{ after(grammarAccess.getReifiedRelationshipAccess().getSourceAssignment_10()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_11()); }
	'target'
	{ after(grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_11()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_12()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_12()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getTargetAssignment_13()); }
	(rule__ReifiedRelationship__TargetAssignment_13)
	{ after(grammarAccess.getReifiedRelationshipAccess().getTargetAssignment_13()); }
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
	{ before(grammarAccess.getReifiedRelationshipAccess().getRightCurlyBracketKeyword_14()); }
	'}'
	{ after(grammarAccess.getReifiedRelationshipAccess().getRightCurlyBracketKeyword_14()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationship__Group_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group_7__0__Impl
	rule__ReifiedRelationship__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_7_0()); }
	'inverse'
	{ after(grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group_7__1__Impl
	rule__ReifiedRelationship__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_7_1()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_7__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__Group_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__Group_7__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameAssignment_7_2()); }
	(rule__ReifiedRelationship__UnreifiedInversePropertyNameAssignment_7_2)
	{ after(grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameAssignment_7_2()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_0()); }
	'unreifiedRelationship'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_0()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getNameAssignment_1()); }
	(rule__UnreifiedRelationship__NameAssignment_1)
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3()); }
	(rule__UnreifiedRelationship__UnorderedGroup_3)
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_4()); }
	'source'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_4()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_5()); }
	'='
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_5()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getSourceAssignment_6()); }
	(rule__UnreifiedRelationship__SourceAssignment_6)
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getSourceAssignment_6()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_7()); }
	'target'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_7()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_8()); }
	'='
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_8()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getTargetAssignment_9()); }
	(rule__UnreifiedRelationship__TargetAssignment_9)
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getTargetAssignment_9()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipAccess().getRightCurlyBracketKeyword_10()); }
	'}'
	{ after(grammarAccess.getUnreifiedRelationshipAccess().getRightCurlyBracketKeyword_10()); }
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
	{ before(grammarAccess.getScalarAccess().getScalarKeyword_0()); }
	'scalar'
	{ after(grammarAccess.getScalarAccess().getScalarKeyword_0()); }
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
	{ before(grammarAccess.getScalarAccess().getNameAssignment_1()); }
	(rule__Scalar__NameAssignment_1)
	{ after(grammarAccess.getScalarAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getStructureAccess().getStructureKeyword_0()); }
	'structure'
	{ after(grammarAccess.getStructureAccess().getStructureKeyword_0()); }
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
	{ before(grammarAccess.getStructureAccess().getNameAssignment_1()); }
	(rule__Structure__NameAssignment_1)
	{ after(grammarAccess.getStructureAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_0()); }
	'entityStructuredDataProperty'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_0()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaAssignment_1()); }
	(rule__EntityStructuredDataProperty__IsIdentityCriteriaAssignment_1)?
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaAssignment_1()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getNameAssignment_2()); }
	(rule__EntityStructuredDataProperty__NameAssignment_2)
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getNameAssignment_2()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_4()); }
	'domain'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_4()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainAssignment_5()); }
	(rule__EntityStructuredDataProperty__DomainAssignment_5)
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainAssignment_5()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_6()); }
	'range'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_6()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeAssignment_7()); }
	(rule__EntityStructuredDataProperty__RangeAssignment_7)
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeAssignment_7()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRightCurlyBracketKeyword_8()); }
	'}'
	{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRightCurlyBracketKeyword_8()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_0()); }
	'entityScalarDataProperty'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_0()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaAssignment_1()); }
	(rule__EntityScalarDataProperty__IsIdentityCriteriaAssignment_1)?
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaAssignment_1()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getNameAssignment_2()); }
	(rule__EntityScalarDataProperty__NameAssignment_2)
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getNameAssignment_2()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_4()); }
	'domain'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_4()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getDomainAssignment_5()); }
	(rule__EntityScalarDataProperty__DomainAssignment_5)
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getDomainAssignment_5()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_6()); }
	'range'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_6()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRangeAssignment_7()); }
	(rule__EntityScalarDataProperty__RangeAssignment_7)
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRangeAssignment_7()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRightCurlyBracketKeyword_8()); }
	'}'
	{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRightCurlyBracketKeyword_8()); }
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
	{ before(grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_0()); }
	'structuredDataProperty'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_0()); }
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
	{ before(grammarAccess.getStructuredDataPropertyAccess().getNameAssignment_1()); }
	(rule__StructuredDataProperty__NameAssignment_1)
	{ after(grammarAccess.getStructuredDataPropertyAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_3()); }
	'domain'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_3()); }
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
	{ before(grammarAccess.getStructuredDataPropertyAccess().getDomainAssignment_4()); }
	(rule__StructuredDataProperty__DomainAssignment_4)
	{ after(grammarAccess.getStructuredDataPropertyAccess().getDomainAssignment_4()); }
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
	{ before(grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_5()); }
	'range'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_5()); }
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
	{ before(grammarAccess.getStructuredDataPropertyAccess().getRangeAssignment_6()); }
	(rule__StructuredDataProperty__RangeAssignment_6)
	{ after(grammarAccess.getStructuredDataPropertyAccess().getRangeAssignment_6()); }
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
	{ before(grammarAccess.getStructuredDataPropertyAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getStructuredDataPropertyAccess().getRightCurlyBracketKeyword_7()); }
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
	{ before(grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_0()); }
	'scalarDataProperty'
	{ after(grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_0()); }
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
	{ before(grammarAccess.getScalarDataPropertyAccess().getNameAssignment_1()); }
	(rule__ScalarDataProperty__NameAssignment_1)
	{ after(grammarAccess.getScalarDataPropertyAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_3()); }
	'domain'
	{ after(grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_3()); }
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
	{ before(grammarAccess.getScalarDataPropertyAccess().getDomainAssignment_4()); }
	(rule__ScalarDataProperty__DomainAssignment_4)
	{ after(grammarAccess.getScalarDataPropertyAccess().getDomainAssignment_4()); }
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
	{ before(grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_5()); }
	'range'
	{ after(grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_5()); }
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
	{ before(grammarAccess.getScalarDataPropertyAccess().getRangeAssignment_6()); }
	(rule__ScalarDataProperty__RangeAssignment_6)
	{ after(grammarAccess.getScalarDataPropertyAccess().getRangeAssignment_6()); }
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
	{ before(grammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_7()); }
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
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_0()); }
	'anonymousConceptUnion'
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_0()); }
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
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_1()); }
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
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameAssignment_2()); }
	(rule__AnonymousConceptUnionAxiom__NameAssignment_2)
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameAssignment_2()); }
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
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_3()); }
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
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_4()); }
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
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsAssignment_5()); }
	(rule__AnonymousConceptUnionAxiom__DisjunctionsAssignment_5)*
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsAssignment_5()); }
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
	{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightCurlyBracketKeyword_6()); }
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
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_0()); }
	'rootConceptTaxonomy'
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_0()); }
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
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_1()); }
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
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootAssignment_2()); }
	(rule__RootConceptTaxonomyAxiom__RootAssignment_2)
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootAssignment_2()); }
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
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_3()); }
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
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_4()); }
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
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsAssignment_5()); }
	(rule__RootConceptTaxonomyAxiom__DisjunctionsAssignment_5)*
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsAssignment_5()); }
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
	{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightCurlyBracketKeyword_6()); }
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
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_0()); }
	'disjointLeaf'
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_0()); }
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
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_1()); }
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
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafAssignment_2()); }
	(rule__SpecificDisjointConceptAxiom__DisjointLeafAssignment_2)
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafAssignment_2()); }
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
	{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getRightParenthesisKeyword_3()); }
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
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_0()); }
	'someEntities'
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_0()); }
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
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainAssignment_1()); }
	(rule__EntityExistentialRestrictionAxiom__RestrictedDomainAssignment_1)
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainAssignment_1()); }
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
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_2()); }
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
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationAssignment_3()); }
	(rule__EntityExistentialRestrictionAxiom__RestrictedRelationAssignment_3)
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationAssignment_3()); }
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
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_4()); }
	'in'
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_4()); }
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
	{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeAssignment_5()); }
	(rule__EntityExistentialRestrictionAxiom__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeAssignment_5()); }
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
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_0()); }
	'allEntities'
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_0()); }
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
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainAssignment_1()); }
	(rule__EntityUniversalRestrictionAxiom__RestrictedDomainAssignment_1)
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainAssignment_1()); }
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
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_2()); }
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
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationAssignment_3()); }
	(rule__EntityUniversalRestrictionAxiom__RestrictedRelationAssignment_3)
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationAssignment_3()); }
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
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_4()); }
	'in'
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_4()); }
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
	{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeAssignment_5()); }
	(rule__EntityUniversalRestrictionAxiom__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeAssignment_5()); }
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
	{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityAssignment_0()); }
	(rule__AspectSpecializationAxiom__SubEntityAssignment_0)
	{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityAssignment_0()); }
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
	{ before(grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_1()); }
	'extendsAspect'
	{ after(grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_1()); }
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
	{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAssignment_2()); }
	(rule__AspectSpecializationAxiom__SuperAspectAssignment_2)
	{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAssignment_2()); }
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
	{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptAssignment_0()); }
	(rule__ConceptSpecializationAxiom__SubConceptAssignment_0)
	{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptAssignment_0()); }
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
	{ before(grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_1()); }
	'extendsConcept'
	{ after(grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_1()); }
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
	{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptAssignment_2()); }
	(rule__ConceptSpecializationAxiom__SuperConceptAssignment_2)
	{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptAssignment_2()); }
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
	{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipAssignment_0()); }
	(rule__ReifiedRelationshipSpecializationAxiom__SubRelationshipAssignment_0)
	{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipAssignment_0()); }
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
	{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_1()); }
	'extendsRelationship'
	{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_1()); }
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
	{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipAssignment_2()); }
	(rule__ReifiedRelationshipSpecializationAxiom__SuperRelationshipAssignment_2)
	{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipAssignment_2()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_0()); }
	'someData'
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_0()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityAssignment_1()); }
	(rule__EntityScalarDataPropertyExistentialRestrictionAxiom__RestrictedEntityAssignment_1)
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityAssignment_1()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_2()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyAssignment_3()); }
	(rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarPropertyAssignment_3)
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyAssignment_3()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_4()); }
	'in'
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_4()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionAssignment_5()); }
	(rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarRestrictionAssignment_5)
	{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionAssignment_5()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_0()); }
	'every'
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_0()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_1()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_1)
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_1()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_2()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyAssignment_3()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__ScalarPropertyAssignment_3)
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyAssignment_3()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_4()); }
	'='
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_4()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueAssignment_5()); }
	(rule__EntityScalarDataPropertyParticularRestrictionAxiom__LiteralValueAssignment_5)
	{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueAssignment_5()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_0()); }
	'allData'
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_0()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityAssignment_1()); }
	(rule__EntityScalarDataPropertyUniversalRestrictionAxiom__RestrictedEntityAssignment_1)
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityAssignment_1()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_2()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyAssignment_3()); }
	(rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarPropertyAssignment_3)
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyAssignment_3()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_4()); }
	'in'
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_4()); }
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
	{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionAssignment_5()); }
	(rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarRestrictionAssignment_5)
	{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionAssignment_5()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_0()); }
	'every'
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_0()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_1()); }
	(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_1)
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityAssignment_1()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_2()); }
	'.'
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_2()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyAssignment_3()); }
	(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyAssignment_3)
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyAssignment_3()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_4()); }
	'='
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_4()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_5()); }
	'{'
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_5()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAlternatives_6()); }
	(rule__EntityStructuredDataPropertyParticularRestrictionAxiom__Alternatives_6)*
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAlternatives_6()); }
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
	{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRightCurlyBracketKeyword_7()); }
	'}'
	{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRightCurlyBracketKeyword_7()); }
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
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_0()); }
	(rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyAssignment_0)
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_0()); }
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
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1()); }
	'='
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1()); }
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
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAlternatives_3()); }
	(rule__RestrictionStructuredDataPropertyTuple__Alternatives_3)*
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAlternatives_3()); }
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
	{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_4()); }
	'}'
	{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_4()); }
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
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_0()); }
	(rule__RestrictionScalarDataPropertyValue__ScalarDataPropertyAssignment_0)
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_0()); }
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
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_1()); }
	'='
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_1()); }
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
	{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_2()); }
	(rule__RestrictionScalarDataPropertyValue__ScalarPropertyValueAssignment_2)
	{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_2()); }
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
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_0()); }
	'binaryScalarRestriction'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_0()); }
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
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getNameAssignment_1()); }
	(rule__BinaryScalarRestriction__NameAssignment_1)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3()); }
	(rule__BinaryScalarRestriction__UnorderedGroup_3)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3()); }
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
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
	'restrictedRange'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
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
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
	(rule__BinaryScalarRestriction__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
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
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__Group_3_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_3_0__0__Impl
	rule__BinaryScalarRestriction__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_3_0_0()); }
	'length'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_3_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_3_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getLengthAssignment_3_0_1()); }
	(rule__BinaryScalarRestriction__LengthAssignment_3_0_1)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getLengthAssignment_3_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_3_1__0__Impl
	rule__BinaryScalarRestriction__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_3_1_0()); }
	'minLength'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthAssignment_3_1_1()); }
	(rule__BinaryScalarRestriction__MinLengthAssignment_3_1_1)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_3_2__0__Impl
	rule__BinaryScalarRestriction__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_3_2_0()); }
	'maxLength'
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthAssignment_3_2_1()); }
	(rule__BinaryScalarRestriction__MaxLengthAssignment_3_2_1)
	{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthAssignment_3_2_1()); }
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
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_0()); }
	'iriScalarRestriction'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_0()); }
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
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getNameAssignment_1()); }
	(rule__IRIScalarRestriction__NameAssignment_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3()); }
	(rule__IRIScalarRestriction__UnorderedGroup_3)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3()); }
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
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
	'restrictedRange'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
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
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
	(rule__IRIScalarRestriction__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
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
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group_3_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_3_0__0__Impl
	rule__IRIScalarRestriction__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_3_0_0()); }
	'length'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_3_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_3_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getLengthAssignment_3_0_1()); }
	(rule__IRIScalarRestriction__LengthAssignment_3_0_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getLengthAssignment_3_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_3_1__0__Impl
	rule__IRIScalarRestriction__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_3_1_0()); }
	'minLength'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthAssignment_3_1_1()); }
	(rule__IRIScalarRestriction__MinLengthAssignment_3_1_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_3_2__0__Impl
	rule__IRIScalarRestriction__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_3_2_0()); }
	'maxLength'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthAssignment_3_2_1()); }
	(rule__IRIScalarRestriction__MaxLengthAssignment_3_2_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__Group_3_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_3_3__0__Impl
	rule__IRIScalarRestriction__Group_3_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_3_3_0()); }
	'pattern'
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_3_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__Group_3_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__Group_3_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIRIScalarRestrictionAccess().getPatternAssignment_3_3_1()); }
	(rule__IRIScalarRestriction__PatternAssignment_3_3_1)
	{ after(grammarAccess.getIRIScalarRestrictionAccess().getPatternAssignment_3_3_1()); }
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
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_0()); }
	'numericScalarRestriction'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_0()); }
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
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getNameAssignment_1()); }
	(rule__NumericScalarRestriction__NameAssignment_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3()); }
	(rule__NumericScalarRestriction__UnorderedGroup_3)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3()); }
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
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
	'restrictedRange'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
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
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
	(rule__NumericScalarRestriction__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
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
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group_3_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_3_0__0__Impl
	rule__NumericScalarRestriction__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0()); }
	'minInclusive'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_3_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveAssignment_3_0_1()); }
	(rule__NumericScalarRestriction__MinInclusiveAssignment_3_0_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveAssignment_3_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_3_1__0__Impl
	rule__NumericScalarRestriction__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0()); }
	'maxInclusive'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveAssignment_3_1_1()); }
	(rule__NumericScalarRestriction__MaxInclusiveAssignment_3_1_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_3_2__0__Impl
	rule__NumericScalarRestriction__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0()); }
	'minExclusive'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveAssignment_3_2_1()); }
	(rule__NumericScalarRestriction__MinExclusiveAssignment_3_2_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__Group_3_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_3_3__0__Impl
	rule__NumericScalarRestriction__Group_3_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0()); }
	'maxExclusive'
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__Group_3_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__Group_3_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveAssignment_3_3_1()); }
	(rule__NumericScalarRestriction__MaxExclusiveAssignment_3_3_1)
	{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveAssignment_3_3_1()); }
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
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_0()); }
	'plainLiteralScalarRestriction'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_0()); }
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
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameAssignment_1()); }
	(rule__PlainLiteralScalarRestriction__NameAssignment_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3()); }
	(rule__PlainLiteralScalarRestriction__UnorderedGroup_3)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3()); }
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
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
	'restrictedRange'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
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
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
	(rule__PlainLiteralScalarRestriction__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
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
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_3_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_0__0__Impl
	rule__PlainLiteralScalarRestriction__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_3_0_0()); }
	'length'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_3_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthAssignment_3_0_1()); }
	(rule__PlainLiteralScalarRestriction__LengthAssignment_3_0_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthAssignment_3_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_1__0__Impl
	rule__PlainLiteralScalarRestriction__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_3_1_0()); }
	'minLength'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthAssignment_3_1_1()); }
	(rule__PlainLiteralScalarRestriction__MinLengthAssignment_3_1_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_2__0__Impl
	rule__PlainLiteralScalarRestriction__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_3_2_0()); }
	'maxLength'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthAssignment_3_2_1()); }
	(rule__PlainLiteralScalarRestriction__MaxLengthAssignment_3_2_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_3_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_3__0__Impl
	rule__PlainLiteralScalarRestriction__Group_3_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_3_3_0()); }
	'pattern'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_3_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternAssignment_3_3_1()); }
	(rule__PlainLiteralScalarRestriction__PatternAssignment_3_3_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternAssignment_3_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__Group_3_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_4__0__Impl
	rule__PlainLiteralScalarRestriction__Group_3_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_3_4_0()); }
	'langRange'
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_3_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__Group_3_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__Group_3_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeAssignment_3_4_1()); }
	(rule__PlainLiteralScalarRestriction__LangRangeAssignment_3_4_1)
	{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeAssignment_3_4_1()); }
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
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_0()); }
	'scalarOneOfRestriction'
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_0()); }
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
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getNameAssignment_1()); }
	(rule__ScalarOneOfRestriction__NameAssignment_1)
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_3()); }
	'restrictedRange'
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_3()); }
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
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeAssignment_4()); }
	(rule__ScalarOneOfRestriction__RestrictedRangeAssignment_4)
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeAssignment_4()); }
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
	{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRightCurlyBracketKeyword_5()); }
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
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_0()); }
	'oneOf'
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_0()); }
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
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomAssignment_1()); }
	(rule__ScalarOneOfLiteralAxiom__AxiomAssignment_1)
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomAssignment_1()); }
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
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_2()); }
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
	{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueAssignment_3()); }
	(rule__ScalarOneOfLiteralAxiom__ValueAssignment_3)
	{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueAssignment_3()); }
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
	{ before(grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_0()); }
	'stringScalarRestriction'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_0()); }
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
	{ before(grammarAccess.getStringScalarRestrictionAccess().getNameAssignment_1()); }
	(rule__StringScalarRestriction__NameAssignment_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3()); }
	(rule__StringScalarRestriction__UnorderedGroup_3)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3()); }
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
	{ before(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
	'restrictedRange'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
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
	{ before(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
	(rule__StringScalarRestriction__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
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
	{ before(grammarAccess.getStringScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group_3_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_3_0__0__Impl
	rule__StringScalarRestriction__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_3_0_0()); }
	'length'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_3_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_3_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getLengthAssignment_3_0_1()); }
	(rule__StringScalarRestriction__LengthAssignment_3_0_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getLengthAssignment_3_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_3_1__0__Impl
	rule__StringScalarRestriction__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_3_1_0()); }
	'minLength'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getMinLengthAssignment_3_1_1()); }
	(rule__StringScalarRestriction__MinLengthAssignment_3_1_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getMinLengthAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_3_2__0__Impl
	rule__StringScalarRestriction__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_3_2_0()); }
	'maxLength'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthAssignment_3_2_1()); }
	(rule__StringScalarRestriction__MaxLengthAssignment_3_2_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__Group_3_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_3_3__0__Impl
	rule__StringScalarRestriction__Group_3_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_3_3_0()); }
	'pattern'
	{ after(grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_3_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__Group_3_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__Group_3_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStringScalarRestrictionAccess().getPatternAssignment_3_3_1()); }
	(rule__StringScalarRestriction__PatternAssignment_3_3_1)
	{ after(grammarAccess.getStringScalarRestrictionAccess().getPatternAssignment_3_3_1()); }
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
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_0()); }
	'synonymScalarRestriction'
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_0()); }
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
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getNameAssignment_1()); }
	(rule__SynonymScalarRestriction__NameAssignment_1)
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_3()); }
	'restrictedRange'
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_3()); }
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
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeAssignment_4()); }
	(rule__SynonymScalarRestriction__RestrictedRangeAssignment_4)
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeAssignment_4()); }
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
	{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRightCurlyBracketKeyword_5()); }
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
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_0()); }
	'timeScalarRestriction'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_0()); }
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
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getNameAssignment_1()); }
	(rule__TimeScalarRestriction__NameAssignment_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getNameAssignment_1()); }
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
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3()); }
	(rule__TimeScalarRestriction__UnorderedGroup_3)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3()); }
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
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
	'restrictedRange'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_4()); }
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
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
	(rule__TimeScalarRestriction__RestrictedRangeAssignment_5)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeAssignment_5()); }
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
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group_3_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_3_0__0__Impl
	rule__TimeScalarRestriction__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0()); }
	'minInclusive'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_3_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveAssignment_3_0_1()); }
	(rule__TimeScalarRestriction__MinInclusiveAssignment_3_0_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveAssignment_3_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_3_1__0__Impl
	rule__TimeScalarRestriction__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0()); }
	'maxInclusive'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveAssignment_3_1_1()); }
	(rule__TimeScalarRestriction__MaxInclusiveAssignment_3_1_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_3_2__0__Impl
	rule__TimeScalarRestriction__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0()); }
	'minExclusive'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveAssignment_3_2_1()); }
	(rule__TimeScalarRestriction__MinExclusiveAssignment_3_2_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__Group_3_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_3_3__0__Impl
	rule__TimeScalarRestriction__Group_3_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0()); }
	'maxExclusive'
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__Group_3_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__Group_3_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveAssignment_3_3_1()); }
	(rule__TimeScalarRestriction__MaxExclusiveAssignment_3_3_1)
	{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveAssignment_3_3_1()); }
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
	{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_0()); }
	'extends'
	{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_0()); }
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
	{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsAssignment_1()); }
	(rule__DescriptionBoxExtendsClosedWorldDefinitions__ClosedWorldDefinitionsAssignment_1)
	{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsAssignment_1()); }
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
	{ before(grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_0()); }
	'refines'
	{ after(grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_0()); }
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
	{ before(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxAssignment_1()); }
	(rule__DescriptionBoxRefinement__RefinedDescriptionBoxAssignment_1)
	{ after(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxAssignment_1()); }
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
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceAssignment_0()); }
	(rule__SingletonInstanceScalarDataPropertyValue__SingletonInstanceAssignment_0)
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceAssignment_0()); }
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
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_1()); }
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
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_2()); }
	(rule__SingletonInstanceScalarDataPropertyValue__ScalarDataPropertyAssignment_2)
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_2()); }
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
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_3()); }
	'='
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_3()); }
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
	{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_4()); }
	(rule__SingletonInstanceScalarDataPropertyValue__ScalarPropertyValueAssignment_4)
	{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_4()); }
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
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceAssignment_0()); }
	(rule__SingletonInstanceStructuredDataPropertyValue__SingletonInstanceAssignment_0)
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceAssignment_0()); }
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
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_1()); }
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
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyAssignment_2()); }
	(rule__SingletonInstanceStructuredDataPropertyValue__StructuredDataPropertyAssignment_2)
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyAssignment_2()); }
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
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_3()); }
	'='
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_3()); }
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
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_4()); }
	'{'
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_4()); }
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
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAlternatives_5()); }
	(rule__SingletonInstanceStructuredDataPropertyValue__Alternatives_5)*
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAlternatives_5()); }
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
	{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getRightCurlyBracketKeyword_6()); }
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
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_0()); }
	(rule__StructuredDataPropertyTuple__StructuredDataPropertyAssignment_0)
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyAssignment_0()); }
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
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1()); }
	'='
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1()); }
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
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2()); }
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
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getAlternatives_3()); }
	(rule__StructuredDataPropertyTuple__Alternatives_3)*
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getAlternatives_3()); }
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
	{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_4()); }
	'}'
	{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_4()); }
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
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_0()); }
	(rule__ScalarDataPropertyValue__ScalarDataPropertyAssignment_0)
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyAssignment_0()); }
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
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_1()); }
	'='
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_1()); }
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
	{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_2()); }
	(rule__ScalarDataPropertyValue__ScalarPropertyValueAssignment_2)
	{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueAssignment_2()); }
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
	{ before(grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_0()); }
	'conceptInstance'
	{ after(grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_0()); }
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
	{ before(grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_1()); }
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
	{ before(grammarAccess.getConceptInstanceAccess().getNameAssignment_2()); }
	(rule__ConceptInstance__NameAssignment_2)
	{ after(grammarAccess.getConceptInstanceAccess().getNameAssignment_2()); }
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
	{ before(grammarAccess.getConceptInstanceAccess().getIsAKeyword_3()); }
	'is-a'
	{ after(grammarAccess.getConceptInstanceAccess().getIsAKeyword_3()); }
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
	{ before(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierAssignment_4()); }
	(rule__ConceptInstance__SingletonConceptClassifierAssignment_4)
	{ after(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierAssignment_4()); }
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
	{ before(grammarAccess.getConceptInstanceAccess().getRightParenthesisKeyword_5()); }
	')'
	{ after(grammarAccess.getConceptInstanceAccess().getRightParenthesisKeyword_5()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_0()); }
	'reifiedRelationshipInstance'
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_0()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_1()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getNameAssignment_2()); }
	(rule__ReifiedRelationshipInstance__NameAssignment_2)
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getNameAssignment_2()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_3()); }
	'is-a'
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_3()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierAssignment_4()); }
	(rule__ReifiedRelationshipInstance__SingletonReifiedRelationshipClassifierAssignment_4)
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierAssignment_4()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getRightParenthesisKeyword_5()); }
	')'
	{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getRightParenthesisKeyword_5()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_0()); }
	'domain'
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_0()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_1()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceAssignment_2()); }
	(rule__ReifiedRelationshipInstanceDomain__ReifiedRelationshipInstanceAssignment_2)
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceAssignment_2()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_3()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_4()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_4()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainAssignment_5()); }
	(rule__ReifiedRelationshipInstanceDomain__DomainAssignment_5)
	{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainAssignment_5()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_0()); }
	'range'
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_0()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_1()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceAssignment_2()); }
	(rule__ReifiedRelationshipInstanceRange__ReifiedRelationshipInstanceAssignment_2)
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceAssignment_2()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_3()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_4()); }
	'='
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_4()); }
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
	{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeAssignment_5()); }
	(rule__ReifiedRelationshipInstanceRange__RangeAssignment_5)
	{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeAssignment_5()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_0()); }
	'tuple'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_0()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_1()); }
	'{'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_1()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_2()); }
	'unreifiedRelationship'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_2()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipAssignment_3()); }
	(rule__UnreifiedRelationshipInstanceTuple__UnreifiedRelationshipAssignment_3)
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipAssignment_3()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_4()); }
	'domain'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_4()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainAssignment_5()); }
	(rule__UnreifiedRelationshipInstanceTuple__DomainAssignment_5)
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainAssignment_5()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_6()); }
	'range'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_6()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeAssignment_7()); }
	(rule__UnreifiedRelationshipInstanceTuple__RangeAssignment_7)
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeAssignment_7()); }
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
	{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRightCurlyBracketKeyword_8()); }
	'}'
	{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRightCurlyBracketKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReifiedRelationship__UnorderedGroup_3
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalAssignment_3_0()); }
					(rule__ReifiedRelationship__IsFunctionalAssignment_3_0)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalAssignment_3_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalAssignment_3_1()); }
					(rule__ReifiedRelationship__IsInverseFunctionalAssignment_3_1)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalAssignment_3_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsEssentialAssignment_3_2()); }
					(rule__ReifiedRelationship__IsEssentialAssignment_3_2)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsEssentialAssignment_3_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialAssignment_3_3()); }
					(rule__ReifiedRelationship__IsInverseEssentialAssignment_3_3)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialAssignment_3_3()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricAssignment_3_4()); }
					(rule__ReifiedRelationship__IsSymmetricAssignment_3_4)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricAssignment_3_4()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAssignment_3_5()); }
					(rule__ReifiedRelationship__IsAsymmetricAssignment_3_5)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAssignment_3_5()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveAssignment_3_6()); }
					(rule__ReifiedRelationship__IsReflexiveAssignment_3_6)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveAssignment_3_6()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveAssignment_3_7()); }
					(rule__ReifiedRelationship__IsIrreflexiveAssignment_3_7)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveAssignment_3_7()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveAssignment_3_8()); }
					(rule__ReifiedRelationship__IsTransitiveAssignment_3_8)
					{ after(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveAssignment_3_8()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
	rule__ReifiedRelationship__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
	rule__ReifiedRelationship__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
	rule__ReifiedRelationship__UnorderedGroup_3__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
	rule__ReifiedRelationship__UnorderedGroup_3__4?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
	rule__ReifiedRelationship__UnorderedGroup_3__5?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
	rule__ReifiedRelationship__UnorderedGroup_3__6?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
	rule__ReifiedRelationship__UnorderedGroup_3__7?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
	rule__ReifiedRelationship__UnorderedGroup_3__8?
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnorderedGroup_3__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReifiedRelationship__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__UnreifiedRelationship__UnorderedGroup_3
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalAssignment_3_0()); }
					(rule__UnreifiedRelationship__IsFunctionalAssignment_3_0)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalAssignment_3_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalAssignment_3_1()); }
					(rule__UnreifiedRelationship__IsInverseFunctionalAssignment_3_1)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalAssignment_3_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialAssignment_3_2()); }
					(rule__UnreifiedRelationship__IsEssentialAssignment_3_2)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialAssignment_3_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialAssignment_3_3()); }
					(rule__UnreifiedRelationship__IsInverseEssentialAssignment_3_3)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialAssignment_3_3()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricAssignment_3_4()); }
					(rule__UnreifiedRelationship__IsSymmetricAssignment_3_4)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricAssignment_3_4()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAssignment_3_5()); }
					(rule__UnreifiedRelationship__IsAsymmetricAssignment_3_5)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAssignment_3_5()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveAssignment_3_6()); }
					(rule__UnreifiedRelationship__IsReflexiveAssignment_3_6)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveAssignment_3_6()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveAssignment_3_7()); }
					(rule__UnreifiedRelationship__IsIrreflexiveAssignment_3_7)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveAssignment_3_7()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveAssignment_3_8()); }
					(rule__UnreifiedRelationship__IsTransitiveAssignment_3_8)
					{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveAssignment_3_8()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	rule__UnreifiedRelationship__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	rule__UnreifiedRelationship__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	rule__UnreifiedRelationship__UnorderedGroup_3__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	rule__UnreifiedRelationship__UnorderedGroup_3__4?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	rule__UnreifiedRelationship__UnorderedGroup_3__5?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	rule__UnreifiedRelationship__UnorderedGroup_3__6?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	rule__UnreifiedRelationship__UnorderedGroup_3__7?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
	rule__UnreifiedRelationship__UnorderedGroup_3__8?
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__UnorderedGroup_3__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnreifiedRelationship__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__BinaryScalarRestriction__UnorderedGroup_3
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
	}
:
	rule__BinaryScalarRestriction__UnorderedGroup_3__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_0()); }
					(rule__BinaryScalarRestriction__Group_3_0__0)
					{ after(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_1()); }
					(rule__BinaryScalarRestriction__Group_3_1__0)
					{ after(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_2()); }
					(rule__BinaryScalarRestriction__Group_3_2__0)
					{ after(grammarAccess.getBinaryScalarRestrictionAccess().getGroup_3_2()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__UnorderedGroup_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__UnorderedGroup_3__Impl
	rule__BinaryScalarRestriction__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__UnorderedGroup_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__UnorderedGroup_3__Impl
	rule__BinaryScalarRestriction__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__UnorderedGroup_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BinaryScalarRestriction__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__IRIScalarRestriction__UnorderedGroup_3
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_3__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_0()); }
					(rule__IRIScalarRestriction__Group_3_0__0)
					{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_1()); }
					(rule__IRIScalarRestriction__Group_3_1__0)
					{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_2()); }
					(rule__IRIScalarRestriction__Group_3_2__0)
					{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_3()); }
					(rule__IRIScalarRestriction__Group_3_3__0)
					{ after(grammarAccess.getIRIScalarRestrictionAccess().getGroup_3_3()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_3__Impl
	rule__IRIScalarRestriction__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_3__Impl
	rule__IRIScalarRestriction__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_3__Impl
	rule__IRIScalarRestriction__UnorderedGroup_3__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__UnorderedGroup_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IRIScalarRestriction__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericScalarRestriction__UnorderedGroup_3
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_3__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_0()); }
					(rule__NumericScalarRestriction__Group_3_0__0)
					{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_1()); }
					(rule__NumericScalarRestriction__Group_3_1__0)
					{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_2()); }
					(rule__NumericScalarRestriction__Group_3_2__0)
					{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_3()); }
					(rule__NumericScalarRestriction__Group_3_3__0)
					{ after(grammarAccess.getNumericScalarRestrictionAccess().getGroup_3_3()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_3__Impl
	rule__NumericScalarRestriction__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_3__Impl
	rule__NumericScalarRestriction__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_3__Impl
	rule__NumericScalarRestriction__UnorderedGroup_3__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__UnorderedGroup_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericScalarRestriction__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__PlainLiteralScalarRestriction__UnorderedGroup_3
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_0()); }
					(rule__PlainLiteralScalarRestriction__Group_3_0__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_1()); }
					(rule__PlainLiteralScalarRestriction__Group_3_1__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_2()); }
					(rule__PlainLiteralScalarRestriction__Group_3_2__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_3()); }
					(rule__PlainLiteralScalarRestriction__Group_3_3__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_3()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_4()); }
					(rule__PlainLiteralScalarRestriction__Group_3_4__0)
					{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getGroup_3_4()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__Impl
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__Impl
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__Impl
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__Impl
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__4?
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__UnorderedGroup_3__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PlainLiteralScalarRestriction__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__StringScalarRestriction__UnorderedGroup_3
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
	}
:
	rule__StringScalarRestriction__UnorderedGroup_3__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_0()); }
					(rule__StringScalarRestriction__Group_3_0__0)
					{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_1()); }
					(rule__StringScalarRestriction__Group_3_1__0)
					{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_2()); }
					(rule__StringScalarRestriction__Group_3_2__0)
					{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_3()); }
					(rule__StringScalarRestriction__Group_3_3__0)
					{ after(grammarAccess.getStringScalarRestrictionAccess().getGroup_3_3()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__UnorderedGroup_3__Impl
	rule__StringScalarRestriction__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__UnorderedGroup_3__Impl
	rule__StringScalarRestriction__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__UnorderedGroup_3__Impl
	rule__StringScalarRestriction__UnorderedGroup_3__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__UnorderedGroup_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StringScalarRestriction__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__TimeScalarRestriction__UnorderedGroup_3
	@init {
		int stackSize = keepStackSize();
		getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_3__0
	?
;
finally {
	getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_3__Impl
	@init {
		int stackSize = keepStackSize();
		boolean selected = false;
	}
:
		(
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_0()); }
					(rule__TimeScalarRestriction__Group_3_0__0)
					{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_0()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_1()); }
					(rule__TimeScalarRestriction__Group_3_1__0)
					{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_1()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_2()); }
					(rule__TimeScalarRestriction__Group_3_2__0)
					{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_2()); }
				)
			)
		)|
		( 
			{getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3)}?=>(
				{
					getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3);
				}
				{
					selected = true;
				}
				(
					{ before(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_3()); }
					(rule__TimeScalarRestriction__Group_3_3__0)
					{ after(grammarAccess.getTimeScalarRestrictionAccess().getGroup_3_3()); }
				)
			)
		)
		)
;
finally {
	if (selected)
		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_3__Impl
	rule__TimeScalarRestriction__UnorderedGroup_3__1?
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_3__Impl
	rule__TimeScalarRestriction__UnorderedGroup_3__2?
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_3__Impl
	rule__TimeScalarRestriction__UnorderedGroup_3__3?
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__UnorderedGroup_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TimeScalarRestriction__UnorderedGroup_3__Impl
;
finally {
	restoreStackSize(stackSize);
}


rule__Extent__AnnotationPropertiesAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExtentAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_1_0_0()); }
		ruleAnnotationProperty
		{ after(grammarAccess.getExtentAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Extent__ModulesAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExtentAccess().getModulesModuleParserRuleCall_1_1_0()); }
		ruleModule
		{ after(grammarAccess.getExtentAccess().getModulesModuleParserRuleCall_1_1_0()); }
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

rule__Annotation__PropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyCrossReference_1_0()); }
		(
			{ before(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1()); }
			RULE_ABBREV_IRI
			{ after(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyABBREV_IRITerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationAccess().getValueSTRINGTerminalRuleCall_3_0()); }
		RULE_STRING
		{ after(grammarAccess.getAnnotationAccess().getValueSTRINGTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__KindAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_1_0()); }
		ruleTerminologyKind
		{ after(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__IriAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_3_0()); }
		RULE_IRI
		{ after(grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__AnnotationsAssignment_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_5_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__BoxAxiomsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0()); }
		ruleTerminologyBoxAxiom
		{ after(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyGraph__BoxStatementsAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0()); }
		ruleTerminologyBoxStatement
		{ after(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__KindAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_1_0()); }
		ruleTerminologyKind
		{ after(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__IriAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_3_0()); }
		RULE_IRI
		{ after(grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__AnnotationsAssignment_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_5_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__BoxAxiomsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0()); }
		ruleTerminologyBoxAxiom
		{ after(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__BoxStatementsAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0()); }
		ruleTerminologyBoxStatement
		{ after(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__BundleStatementsAssignment_5_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_5_3_0()); }
		ruleTerminologyBundleStatement
		{ after(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_5_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Bundle__BundleAxiomsAssignment_5_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_4_0()); }
		ruleTerminologyBundleAxiom
		{ after(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__KindAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_1_0()); }
		ruleDescriptionKind
		{ after(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__IriAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_3_0()); }
		RULE_IRI
		{ after(grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__AnnotationsAssignment_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationParserRuleCall_5_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationParserRuleCall_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ClosedWorldDefinitionsAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_1_0()); }
		ruleDescriptionBoxExtendsClosedWorldDefinitions
		{ after(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__DescriptionBoxRefinementsAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_2_0()); }
		ruleDescriptionBoxRefinement
		{ after(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ConceptInstancesAssignment_5_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_5_3_0()); }
		ruleConceptInstance
		{ after(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_5_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ReifiedRelationshipInstancesAssignment_5_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_4_0()); }
		ruleReifiedRelationshipInstance
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ReifiedRelationshipInstanceDomainsAssignment_5_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_5_0()); }
		ruleReifiedRelationshipInstanceDomain
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__ReifiedRelationshipInstanceRangesAssignment_5_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_6_0()); }
		ruleReifiedRelationshipInstanceRange
		{ after(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__UnreifiedRelationshipInstanceTuplesAssignment_5_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_7_0()); }
		ruleUnreifiedRelationshipInstanceTuple
		{ after(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__SingletonScalarDataPropertyValuesAssignment_5_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_8_0()); }
		ruleSingletonInstanceScalarDataPropertyValue
		{ after(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBox__SingletonStructuredDataPropertyValuesAssignment_5_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_9_0()); }
		ruleSingletonInstanceStructuredDataPropertyValue
		{ after(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BundledTerminologyAxiom__BundledTerminologyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_1_0()); }
		(
			{ before(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__DesignatedTerminologyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_3_0()); }
		(
			{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptDesignationTerminologyAxiom__DesignatedConceptAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_5_0()); }
		(
			{ before(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyExtensionAxiom__ExtendedTerminologyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_1_0()); }
		(
			{ before(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxExternalReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__NestingTerminologyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_3_0()); }
		(
			{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminologyNestingAxiom__NestingContextAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_5_0()); }
		(
			{ before(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Concept__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsFunctionalAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0()); }
			'functional'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsInverseFunctionalAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0()); }
			'inverseFunctional'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsEssentialAssignment_3_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0()); }
			'essential'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsInverseEssentialAssignment_3_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0()); }
			'inverseEssential'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsSymmetricAssignment_3_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0()); }
			'symmetric'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsAsymmetricAssignment_3_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0()); }
			'asymmetric'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsReflexiveAssignment_3_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0()); }
			'reflexive'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsIrreflexiveAssignment_3_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0()); }
			'irreflexive'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__IsTransitiveAssignment_3_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0()); }
			'transitive'
			{ after(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnreifiedPropertyNameAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameIDTerminalRuleCall_6_0()); }
		RULE_ID
		{ after(grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameIDTerminalRuleCall_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__UnreifiedInversePropertyNameAssignment_7_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameIDTerminalRuleCall_7_2_0()); }
		RULE_ID
		{ after(grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameIDTerminalRuleCall_7_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__SourceAssignment_10
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_10_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getSourceEntityReferenceParserRuleCall_10_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipAccess().getSourceEntityReferenceParserRuleCall_10_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_10_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationship__TargetAssignment_13
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_13_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipAccess().getTargetEntityReferenceParserRuleCall_13_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipAccess().getTargetEntityReferenceParserRuleCall_13_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_13_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsFunctionalAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0()); }
			'functional'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsInverseFunctionalAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0()); }
			'inverseFunctional'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsEssentialAssignment_3_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0()); }
			'essential'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsInverseEssentialAssignment_3_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0()); }
			'inverseEssential'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsSymmetricAssignment_3_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0()); }
			'symmetric'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsAsymmetricAssignment_3_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0()); }
			'asymmetric'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsReflexiveAssignment_3_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0()); }
			'reflexive'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsIrreflexiveAssignment_3_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0()); }
			'irreflexive'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__IsTransitiveAssignment_3_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0()); }
			'transitive'
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__SourceAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_6_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationship__TargetAssignment_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_9_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityReferenceParserRuleCall_9_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityReferenceParserRuleCall_9_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scalar__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Structure__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__IsIdentityCriteriaAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0()); }
			'+'
			{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__DomainAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_5_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataProperty__RangeAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_7_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__IsIdentityCriteriaAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0()); }
			'+'
			{ after(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__DomainAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_5_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataProperty__RangeAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_7_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__DomainAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_4_0()); }
		(
			{ before(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataProperty__RangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_6_0()); }
		(
			{ before(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__DomainAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_4_0()); }
		(
			{ before(grammarAccess.getScalarDataPropertyAccess().getDomainStructureReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarDataPropertyAccess().getDomainStructureReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataProperty__RangeAssignment_6
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_6_0()); }
		(
			{ before(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_6_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeReferenceParserRuleCall_6_0_1()); }
		)
		{ after(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_6_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnonymousConceptUnionAxiom__DisjunctionsAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0()); }
		ruleDisjointUnionOfConceptsAxiom
		{ after(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__RootAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_2_0()); }
		(
			{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootConceptTaxonomyAxiom__DisjunctionsAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0()); }
		ruleDisjointUnionOfConceptsAxiom
		{ after(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificDisjointConceptAxiom__DisjointLeafAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_2_0()); }
		(
			{ before(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__RestrictedDomainAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__RestrictedRelationAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0()); }
		(
			{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityExistentialRestrictionAxiom__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0()); }
		(
			{ before(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__RestrictedDomainAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__RestrictedRelationAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0()); }
		(
			{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityUniversalRestrictionAxiom__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0()); }
		(
			{ before(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__SubEntityAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_0_0()); }
		(
			{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AspectSpecializationAxiom__SuperAspectAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_2_0()); }
		(
			{ before(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__SubConceptAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_0_0()); }
		(
			{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptSpecializationAxiom__SuperConceptAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_2_0()); }
		(
			{ before(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__SubRelationshipAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_0_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipSpecializationAxiom__SuperRelationshipAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipCrossReference_2_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__RestrictedEntityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarPropertyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyExistentialRestrictionAxiom__ScalarRestrictionAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__ScalarPropertyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyParticularRestrictionAxiom__LiteralValueAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueValueParserRuleCall_5_0()); }
		ruleValue
		{ after(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueValueParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__RestrictedEntityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarPropertyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityScalarDataPropertyUniversalRestrictionAxiom__ScalarRestrictionAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__RestrictedEntityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredDataPropertyAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_3_0()); }
		(
			{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__StructuredPropertyTuplesAssignment_6_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_6_0_0()); }
		ruleRestrictionStructuredDataPropertyTuple
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_6_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EntityStructuredDataPropertyParticularRestrictionAxiom__ScalarDataPropertyValuesAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_6_1_0()); }
		ruleRestrictionScalarDataPropertyValue
		{ after(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__StructuredDataPropertyAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyCrossReference_0_0()); }
		(
			{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_3_0_0()); }
		ruleRestrictionStructuredDataPropertyTuple
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionStructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_3_1_0()); }
		ruleRestrictionScalarDataPropertyValue
		{ after(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__ScalarDataPropertyAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyCrossReference_0_0()); }
		(
			{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RestrictionScalarDataPropertyValue__ScalarPropertyValueAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0()); }
		ruleValue
		{ after(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__LengthAssignment_3_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0()); }
		RULE_INT
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__MinLengthAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0()); }
		RULE_INT
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__MaxLengthAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0()); }
		RULE_INT
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryScalarRestriction__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__LengthAssignment_3_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0()); }
		RULE_INT
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__MinLengthAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0()); }
		RULE_INT
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__MaxLengthAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0()); }
		RULE_INT
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__PatternAssignment_3_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IRIScalarRestriction__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__MinInclusiveAssignment_3_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__MaxInclusiveAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__MinExclusiveAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__MaxExclusiveAssignment_3_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericScalarRestriction__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__LengthAssignment_3_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0()); }
		RULE_INT
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__MinLengthAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0()); }
		RULE_INT
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__MaxLengthAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0()); }
		RULE_INT
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__PatternAssignment_3_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__LangRangeAssignment_3_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeSTRINGTerminalRuleCall_3_4_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeSTRINGTerminalRuleCall_3_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlainLiteralScalarRestriction__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfRestriction__RestrictedRangeAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0()); }
		(
			{ before(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__AxiomAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_1_0()); }
		(
			{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionReferenceParserRuleCall_1_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarOneOfLiteralAxiom__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueSTRINGTerminalRuleCall_3_0()); }
		RULE_STRING
		{ after(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueSTRINGTerminalRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__LengthAssignment_3_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0()); }
		RULE_INT
		{ after(grammarAccess.getStringScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__MinLengthAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0()); }
		RULE_INT
		{ after(grammarAccess.getStringScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__MaxLengthAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0()); }
		RULE_INT
		{ after(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__PatternAssignment_3_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getStringScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringScalarRestriction__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SynonymScalarRestriction__RestrictedRangeAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0()); }
		(
			{ before(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__MinInclusiveAssignment_3_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__MaxInclusiveAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__MinExclusiveAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__MaxExclusiveAssignment_3_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TimeScalarRestriction__RestrictedRangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
		(
			{ before(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxExtendsClosedWorldDefinitions__ClosedWorldDefinitionsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxCrossReference_1_0()); }
		(
			{ before(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_1_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxExternalReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__DescriptionBoxRefinement__RefinedDescriptionBoxAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxCrossReference_1_0()); }
		(
			{ before(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_1_0_1()); }
			ruleExternalReference
			{ after(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxExternalReferenceParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__SingletonInstanceAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__ScalarDataPropertyAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyCrossReference_2_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceScalarDataPropertyValue__ScalarPropertyValueAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_4_0()); }
		ruleValue
		{ after(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__SingletonInstanceAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__StructuredDataPropertyAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_2_0()); }
		(
			{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__StructuredPropertyTuplesAssignment_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0()); }
		ruleStructuredDataPropertyTuple
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingletonInstanceStructuredDataPropertyValue__ScalarDataPropertyValuesAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0()); }
		ruleScalarDataPropertyValue
		{ after(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__StructuredDataPropertyAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_0_0()); }
		(
			{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__StructuredPropertyTuplesAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0()); }
		ruleStructuredDataPropertyTuple
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredDataPropertyTuple__ScalarDataPropertyValuesAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0()); }
		ruleScalarDataPropertyValue
		{ after(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__ScalarDataPropertyAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarCrossReference_0_0()); }
		(
			{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_0_0_1()); }
			ruleReference
			{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarReferenceParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ScalarDataPropertyValue__ScalarPropertyValueAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0()); }
		ruleValue
		{ after(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConceptInstance__SingletonConceptClassifierAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_4_0()); }
		(
			{ before(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstance__SingletonReifiedRelationshipClassifierAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_4_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipReferenceParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__ReifiedRelationshipInstanceAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceDomain__DomainAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__ReifiedRelationshipInstanceAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceReferenceParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReifiedRelationshipInstanceRange__RangeAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceCrossReference_5_0()); }
		(
			{ before(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__UnreifiedRelationshipAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_3_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipReferenceParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__DomainAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceReferenceParserRuleCall_5_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnreifiedRelationshipInstanceTuple__RangeAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_7_0()); }
		(
			{ before(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_7_0_1()); }
			ruleReference
			{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceReferenceParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_IRI : '<' ~('>')* '>';

RULE_ABBREV_IRI : ('a'..'z'|'A'..'Z'|'_'|'0'..'9') ('a'..'z'|'A'..'Z'|'_'|'-'|'.'|'0'..'9')* ':' ('a'..'z'|'A'..'Z'|'_'|'0'..'9') ('a'..'z'|'A'..'Z'|'_'|'-'|'.'|'0'..'9')*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'-'|'.'|'0'..'9')*;

RULE_UUID : RULE_HEX_8DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_4DIGITS '-' RULE_HEX_12DIGITS;

fragment RULE_HEX_12DIGITS : RULE_HEX_8DIGITS RULE_HEX_4DIGITS;

fragment RULE_HEX_8DIGITS : RULE_HEX_4DIGITS RULE_HEX_4DIGITS;

fragment RULE_HEX_4DIGITS : RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT RULE_HEX_DIGIT;

fragment RULE_HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_INT : ('0'..'9')+;

RULE_DECIMAL : RULE_INT (('e'|'E') ('+'|'-')? RULE_INT)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_FLOAT : '-'? ('0'..'9')+ '.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;
