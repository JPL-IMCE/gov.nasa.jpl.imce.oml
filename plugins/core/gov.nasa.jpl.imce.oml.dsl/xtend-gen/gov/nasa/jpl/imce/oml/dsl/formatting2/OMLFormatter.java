/**
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
package gov.nasa.jpl.imce.oml.dsl.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.services.OMLGrammarAccess;
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement;
import gov.nasa.jpl.imce.oml.model.common.Annotation;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class OMLFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private OMLGrammarAccess _oMLGrammarAccess;
  
  protected void _format(final Extent extent, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.<Extent>prepend(extent, _function);
    EList<AnnotationProperty> _annotationProperties = extent.getAnnotationProperties();
    final Consumer<AnnotationProperty> _function_1 = (AnnotationProperty it) -> {
      AnnotationProperty _format = document.<AnnotationProperty>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<AnnotationProperty>append(_format, _function_2);
    };
    _annotationProperties.forEach(_function_1);
    EList<Module> _modules = extent.getModules();
    final Module lastM = IterableExtensions.<Module>last(_modules);
    EList<Module> _modules_1 = extent.getModules();
    final Consumer<Module> _function_2 = (Module m) -> {
      Module _format = document.<Module>format(m);
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
        int _xifexpression = (int) 0;
        boolean _equals = Objects.equal(lastM, m);
        if (_equals) {
          _xifexpression = 1;
        } else {
          _xifexpression = 2;
        }
        it.setNewLines(_xifexpression);
      };
      document.<Module>append(_format, _function_3);
    };
    _modules_1.forEach(_function_2);
  }
  
  protected void _format(final AnnotationProperty annotationProperty, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(annotationProperty);
    ISemanticRegion _keyword = _regionFor.keyword("annotationProperty");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(annotationProperty);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(_keyword_1, _function_1);
  }
  
  protected void _format(final Annotation annotation, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(annotation);
    ISemanticRegion _keyword = _regionFor.keyword("@");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(annotation);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(annotation);
    OMLGrammarAccess.AnnotationElements _annotationAccess = this._oMLGrammarAccess.getAnnotationAccess();
    RuleCall _valueSTRINGTerminalRuleCall_3_0 = _annotationAccess.getValueSTRINGTerminalRuleCall_3_0();
    _regionFor_2.ruleCall(_valueSTRINGTerminalRuleCall_3_0);
  }
  
  protected void _format(final TerminologyGraph terminologyGraph, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(terminologyGraph);
    EAttribute _terminologyBox_Kind = TerminologiesPackage.eINSTANCE.getTerminologyBox_Kind();
    ISemanticRegion _feature = _regionFor.feature(_terminologyBox_Kind);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_feature, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(terminologyGraph);
    ISemanticRegion _keyword = _regionFor_1.keyword("terminology");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(terminologyGraph);
    OMLGrammarAccess.TerminologyGraphElements _terminologyGraphAccess = this._oMLGrammarAccess.getTerminologyGraphAccess();
    RuleCall _iriIRITerminalRuleCall_3_0 = _terminologyGraphAccess.getIriIRITerminalRuleCall_3_0();
    ISemanticRegion _ruleCall = _regionFor_2.ruleCall(_iriIRITerminalRuleCall_3_0);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(terminologyGraph);
    final ISemanticRegion lcurly = _regionFor_3.keyword("{");
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(terminologyGraph);
    final ISemanticRegion rcurly = _regionFor_4.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.append(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    EList<Annotation> _annotations = terminologyGraph.getAnnotations();
    final Consumer<Annotation> _function_6 = (Annotation it) -> {
      Annotation _format = document.<Annotation>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<Annotation>append(_format, _function_7);
    };
    _annotations.forEach(_function_6);
    EList<TerminologyBoxAxiom> _boxAxioms = terminologyGraph.getBoxAxioms();
    final Consumer<TerminologyBoxAxiom> _function_7 = (TerminologyBoxAxiom it) -> {
      TerminologyBoxAxiom _format = document.<TerminologyBoxAxiom>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBoxAxiom>append(_format, _function_8);
    };
    _boxAxioms.forEach(_function_7);
    EList<TerminologyBoxStatement> _boxStatements = terminologyGraph.getBoxStatements();
    final Consumer<TerminologyBoxStatement> _function_8 = (TerminologyBoxStatement it) -> {
      TerminologyBoxStatement _format = document.<TerminologyBoxStatement>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBoxStatement>append(_format, _function_9);
    };
    _boxStatements.forEach(_function_8);
  }
  
  protected void _format(final Bundle bundle, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(bundle);
    EAttribute _terminologyBox_Kind = TerminologiesPackage.eINSTANCE.getTerminologyBox_Kind();
    ISemanticRegion _feature = _regionFor.feature(_terminologyBox_Kind);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_feature, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(bundle);
    ISemanticRegion _keyword = _regionFor_1.keyword("bundle");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(bundle);
    OMLGrammarAccess.BundleElements _bundleAccess = this._oMLGrammarAccess.getBundleAccess();
    RuleCall _iriIRITerminalRuleCall_3_0 = _bundleAccess.getIriIRITerminalRuleCall_3_0();
    ISemanticRegion _ruleCall = _regionFor_2.ruleCall(_iriIRITerminalRuleCall_3_0);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(bundle);
    final ISemanticRegion lcurly = _regionFor_3.keyword("{");
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(bundle);
    final ISemanticRegion rcurly = _regionFor_4.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.append(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    EList<Annotation> _annotations = bundle.getAnnotations();
    final Consumer<Annotation> _function_6 = (Annotation it) -> {
      Annotation _format = document.<Annotation>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<Annotation>append(_format, _function_7);
    };
    _annotations.forEach(_function_6);
    EList<TerminologyBoxAxiom> _boxAxioms = bundle.getBoxAxioms();
    final Consumer<TerminologyBoxAxiom> _function_7 = (TerminologyBoxAxiom it) -> {
      TerminologyBoxAxiom _format = document.<TerminologyBoxAxiom>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBoxAxiom>append(_format, _function_8);
    };
    _boxAxioms.forEach(_function_7);
    EList<TerminologyBoxStatement> _boxStatements = bundle.getBoxStatements();
    final Consumer<TerminologyBoxStatement> _function_8 = (TerminologyBoxStatement it) -> {
      TerminologyBoxStatement _format = document.<TerminologyBoxStatement>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBoxStatement>append(_format, _function_9);
    };
    _boxStatements.forEach(_function_8);
    EList<TerminologyBundleAxiom> _bundleAxioms = bundle.getBundleAxioms();
    final Consumer<TerminologyBundleAxiom> _function_9 = (TerminologyBundleAxiom it) -> {
      TerminologyBundleAxiom _format = document.<TerminologyBundleAxiom>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBundleAxiom>append(_format, _function_10);
    };
    _bundleAxioms.forEach(_function_9);
    EList<TerminologyBundleStatement> _bundleStatements = bundle.getBundleStatements();
    final Consumer<TerminologyBundleStatement> _function_10 = (TerminologyBundleStatement it) -> {
      TerminologyBundleStatement _format = document.<TerminologyBundleStatement>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBundleStatement>append(_format, _function_11);
    };
    _bundleStatements.forEach(_function_10);
  }
  
  protected void _format(final DescriptionBox descriptionBox, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(descriptionBox);
    EAttribute _descriptionBox_Kind = DescriptionsPackage.eINSTANCE.getDescriptionBox_Kind();
    ISemanticRegion _feature = _regionFor.feature(_descriptionBox_Kind);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_feature, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(descriptionBox);
    ISemanticRegion _keyword = _regionFor_1.keyword("descriptionBox");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(descriptionBox);
    OMLGrammarAccess.DescriptionBoxElements _descriptionBoxAccess = this._oMLGrammarAccess.getDescriptionBoxAccess();
    RuleCall _iriIRITerminalRuleCall_3_0 = _descriptionBoxAccess.getIriIRITerminalRuleCall_3_0();
    ISemanticRegion _ruleCall = _regionFor_2.ruleCall(_iriIRITerminalRuleCall_3_0);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(descriptionBox);
    final ISemanticRegion lcurly = _regionFor_3.keyword("{");
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(descriptionBox);
    final ISemanticRegion rcurly = _regionFor_4.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.append(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    EList<Annotation> _annotations = descriptionBox.getAnnotations();
    final Consumer<Annotation> _function_6 = (Annotation it) -> {
      Annotation _format = document.<Annotation>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<Annotation>append(_format, _function_7);
    };
    _annotations.forEach(_function_6);
    EList<DescriptionBoxExtendsClosedWorldDefinitions> _closedWorldDefinitions = descriptionBox.getClosedWorldDefinitions();
    final Consumer<DescriptionBoxExtendsClosedWorldDefinitions> _function_7 = (DescriptionBoxExtendsClosedWorldDefinitions it) -> {
      DescriptionBoxExtendsClosedWorldDefinitions _format = document.<DescriptionBoxExtendsClosedWorldDefinitions>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<DescriptionBoxExtendsClosedWorldDefinitions>append(_format, _function_8);
    };
    _closedWorldDefinitions.forEach(_function_7);
    EList<DescriptionBoxRefinement> _descriptionBoxRefinements = descriptionBox.getDescriptionBoxRefinements();
    final Consumer<DescriptionBoxRefinement> _function_8 = (DescriptionBoxRefinement it) -> {
      DescriptionBoxRefinement _format = document.<DescriptionBoxRefinement>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<DescriptionBoxRefinement>append(_format, _function_9);
    };
    _descriptionBoxRefinements.forEach(_function_8);
    EList<ConceptInstance> _conceptInstances = descriptionBox.getConceptInstances();
    final Consumer<ConceptInstance> _function_9 = (ConceptInstance it) -> {
      ConceptInstance _format = document.<ConceptInstance>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<ConceptInstance>append(_format, _function_10);
    };
    _conceptInstances.forEach(_function_9);
    EList<ReifiedRelationshipInstance> _reifiedRelationshipInstances = descriptionBox.getReifiedRelationshipInstances();
    final Consumer<ReifiedRelationshipInstance> _function_10 = (ReifiedRelationshipInstance it) -> {
      ReifiedRelationshipInstance _format = document.<ReifiedRelationshipInstance>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<ReifiedRelationshipInstance>append(_format, _function_11);
    };
    _reifiedRelationshipInstances.forEach(_function_10);
    EList<ReifiedRelationshipInstanceDomain> _reifiedRelationshipInstanceDomains = descriptionBox.getReifiedRelationshipInstanceDomains();
    final Consumer<ReifiedRelationshipInstanceDomain> _function_11 = (ReifiedRelationshipInstanceDomain it) -> {
      ReifiedRelationshipInstanceDomain _format = document.<ReifiedRelationshipInstanceDomain>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<ReifiedRelationshipInstanceDomain>append(_format, _function_12);
    };
    _reifiedRelationshipInstanceDomains.forEach(_function_11);
    EList<ReifiedRelationshipInstanceRange> _reifiedRelationshipInstanceRanges = descriptionBox.getReifiedRelationshipInstanceRanges();
    final Consumer<ReifiedRelationshipInstanceRange> _function_12 = (ReifiedRelationshipInstanceRange it) -> {
      ReifiedRelationshipInstanceRange _format = document.<ReifiedRelationshipInstanceRange>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<ReifiedRelationshipInstanceRange>append(_format, _function_13);
    };
    _reifiedRelationshipInstanceRanges.forEach(_function_12);
    EList<UnreifiedRelationshipInstanceTuple> _unreifiedRelationshipInstanceTuples = descriptionBox.getUnreifiedRelationshipInstanceTuples();
    final Consumer<UnreifiedRelationshipInstanceTuple> _function_13 = (UnreifiedRelationshipInstanceTuple it) -> {
      UnreifiedRelationshipInstanceTuple _format = document.<UnreifiedRelationshipInstanceTuple>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<UnreifiedRelationshipInstanceTuple>append(_format, _function_14);
    };
    _unreifiedRelationshipInstanceTuples.forEach(_function_13);
  }
  
  protected void _format(final Aspect aspect, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(aspect);
    ISemanticRegion _keyword = _regionFor.keyword("aspect");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(aspect);
    OMLGrammarAccess.AspectElements _aspectAccess = this._oMLGrammarAccess.getAspectAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _aspectAccess.getNameIDTerminalRuleCall_1_0();
    _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
  }
  
  protected void _format(final Concept concept, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(concept);
    ISemanticRegion _keyword = _regionFor.keyword("concept");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(concept);
    OMLGrammarAccess.ConceptElements _conceptAccess = this._oMLGrammarAccess.getConceptAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _conceptAccess.getNameIDTerminalRuleCall_1_0();
    _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
  }
  
  protected void _format(final ReifiedRelationship rr, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword = _regionFor.keyword("reifiedRelationship");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(rr);
    OMLGrammarAccess.ReifiedRelationshipElements _reifiedRelationshipAccess = this._oMLGrammarAccess.getReifiedRelationshipAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _reifiedRelationshipAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(rr);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(rr);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("functional");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_2 = _regionFor_5.keyword("inverseFunctional");
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_2, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_3 = _regionFor_6.keyword("essential");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_3, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_4 = _regionFor_7.keyword("inverseEssential");
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_4, _function_8);
    ISemanticRegionsFinder _regionFor_8 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_5 = _regionFor_8.keyword("symmetric");
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_5, _function_9);
    ISemanticRegionsFinder _regionFor_9 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_6 = _regionFor_9.keyword("asymmetric");
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_6, _function_10);
    ISemanticRegionsFinder _regionFor_10 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_7 = _regionFor_10.keyword("reflexive");
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_7, _function_11);
    ISemanticRegionsFinder _regionFor_11 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_8 = _regionFor_11.keyword("irreflexive");
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_8, _function_12);
    ISemanticRegionsFinder _regionFor_12 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_9 = _regionFor_12.keyword("transitive");
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_9, _function_13);
    ISemanticRegionsFinder _regionFor_13 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_10 = _regionFor_13.keyword("unreified");
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_10, _function_14);
    ISemanticRegionsFinder _regionFor_14 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_11 = _regionFor_14.keyword("inverse");
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_11, _function_15);
    ISemanticRegionsFinder _regionFor_15 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_12 = _regionFor_15.keyword("source");
    final Procedure1<IHiddenRegionFormatter> _function_16 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_12, _function_16);
    ISemanticRegionsFinder _regionFor_16 = this.textRegionExtensions.regionFor(rr);
    ISemanticRegion _keyword_13 = _regionFor_16.keyword("target");
    final Procedure1<IHiddenRegionFormatter> _function_17 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_13, _function_17);
  }
  
  protected void _format(final UnreifiedRelationship ur, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword = _regionFor.keyword("unreifiedRelationship");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ur);
    OMLGrammarAccess.UnreifiedRelationshipElements _unreifiedRelationshipAccess = this._oMLGrammarAccess.getUnreifiedRelationshipAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _unreifiedRelationshipAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ur);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(ur);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("functional");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_2 = _regionFor_5.keyword("inverseFunctional");
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_2, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_3 = _regionFor_6.keyword("essential");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_3, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_4 = _regionFor_7.keyword("inverseEssential");
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_4, _function_8);
    ISemanticRegionsFinder _regionFor_8 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_5 = _regionFor_8.keyword("symmetric");
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_5, _function_9);
    ISemanticRegionsFinder _regionFor_9 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_6 = _regionFor_9.keyword("asymmetric");
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_6, _function_10);
    ISemanticRegionsFinder _regionFor_10 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_7 = _regionFor_10.keyword("reflexive");
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_7, _function_11);
    ISemanticRegionsFinder _regionFor_11 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_8 = _regionFor_11.keyword("irreflexive");
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_8, _function_12);
    ISemanticRegionsFinder _regionFor_12 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_9 = _regionFor_12.keyword("transitive");
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_9, _function_13);
    ISemanticRegionsFinder _regionFor_13 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_10 = _regionFor_13.keyword("source");
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_10, _function_14);
    ISemanticRegionsFinder _regionFor_14 = this.textRegionExtensions.regionFor(ur);
    ISemanticRegion _keyword_11 = _regionFor_14.keyword("target");
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(_keyword_11, _function_15);
  }
  
  protected void _format(final Scalar scalar, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(scalar);
    ISemanticRegion _keyword = _regionFor.keyword("scalar");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
  }
  
  protected void _format(final Structure structure, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(structure);
    ISemanticRegion _keyword = _regionFor.keyword("structure");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
  }
  
  protected void _format(final AspectSpecializationAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("extendsAspect");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
  }
  
  protected void _format(final ConceptSpecializationAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("extendsConcept");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
  }
  
  protected void _format(final ReifiedRelationshipSpecializationAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("extendsRelationship");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
  }
  
  protected void _format(final ConceptDesignationTerminologyAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("conceptDesignationTerminologyAxiom");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion lcurly = _regionFor_1.keyword("{");
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion rcurly = _regionFor_2.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_3);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_3.keyword("designatedTerminology");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(ax);
    OMLGrammarAccess.ConceptDesignationTerminologyAxiomElements _conceptDesignationTerminologyAxiomAccess = this._oMLGrammarAccess.getConceptDesignationTerminologyAxiomAccess();
    RuleCall _designatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1 = _conceptDesignationTerminologyAxiomAccess.getDesignatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1();
    ISemanticRegion _ruleCall = _regionFor_4.ruleCall(_designatedTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_5.keyword("designatedConcept");
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(ax);
    OMLGrammarAccess.ConceptDesignationTerminologyAxiomElements _conceptDesignationTerminologyAxiomAccess_1 = this._oMLGrammarAccess.getConceptDesignationTerminologyAxiomAccess();
    RuleCall _designatedConceptConceptReferenceParserRuleCall_5_0_1 = _conceptDesignationTerminologyAxiomAccess_1.getDesignatedConceptConceptReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall_1 = _regionFor_6.ruleCall(_designatedConceptConceptReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_7);
  }
  
  protected void _format(final TerminologyExtensionAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("extends");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
  }
  
  protected void _format(final TerminologyNestingAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("terminologyNestingAxiom");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion lcurly = _regionFor_1.keyword("{");
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion rcurly = _regionFor_2.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_3);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_3.keyword("nestingTerminology");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(ax);
    OMLGrammarAccess.TerminologyNestingAxiomElements _terminologyNestingAxiomAccess = this._oMLGrammarAccess.getTerminologyNestingAxiomAccess();
    RuleCall _nestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1 = _terminologyNestingAxiomAccess.getNestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1();
    ISemanticRegion _ruleCall = _regionFor_4.ruleCall(_nestingTerminologyTerminologyBoxExternalReferenceParserRuleCall_3_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_5.keyword("nestingContext");
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(ax);
    OMLGrammarAccess.TerminologyNestingAxiomElements _terminologyNestingAxiomAccess_1 = this._oMLGrammarAccess.getTerminologyNestingAxiomAccess();
    RuleCall _nestingContextConceptReferenceParserRuleCall_5_0_1 = _terminologyNestingAxiomAccess_1.getNestingContextConceptReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall_1 = _regionFor_6.ruleCall(_nestingContextConceptReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_7);
  }
  
  protected void _format(final BundledTerminologyAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("bundles");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
  }
  
  protected void _format(final EntityStructuredDataProperty t, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword = _regionFor.keyword("entityStructuredDataProperty");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.EntityStructuredDataPropertyElements _entityStructuredDataPropertyAccess = this._oMLGrammarAccess.getEntityStructuredDataPropertyAccess();
    Assignment _isIdentityCriteriaAssignment_1 = _entityStructuredDataPropertyAccess.getIsIdentityCriteriaAssignment_1();
    ISemanticRegion _assignment = _regionFor_1.assignment(_isIdentityCriteriaAssignment_1);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_assignment, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("domain");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.EntityStructuredDataPropertyElements _entityStructuredDataPropertyAccess_1 = this._oMLGrammarAccess.getEntityStructuredDataPropertyAccess();
    RuleCall _domainEntityReferenceParserRuleCall_5_0_1 = _entityStructuredDataPropertyAccess_1.getDomainEntityReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall = _regionFor_5.ruleCall(_domainEntityReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("range");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.EntityStructuredDataPropertyElements _entityStructuredDataPropertyAccess_2 = this._oMLGrammarAccess.getEntityStructuredDataPropertyAccess();
    RuleCall _rangeStructureReferenceParserRuleCall_7_0_1 = _entityStructuredDataPropertyAccess_2.getRangeStructureReferenceParserRuleCall_7_0_1();
    ISemanticRegion _ruleCall_1 = _regionFor_7.ruleCall(_rangeStructureReferenceParserRuleCall_7_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_8);
  }
  
  protected void _format(final EntityScalarDataProperty t, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword = _regionFor.keyword("entityScalarDataProperty");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.EntityScalarDataPropertyElements _entityScalarDataPropertyAccess = this._oMLGrammarAccess.getEntityScalarDataPropertyAccess();
    Assignment _isIdentityCriteriaAssignment_1 = _entityScalarDataPropertyAccess.getIsIdentityCriteriaAssignment_1();
    ISemanticRegion _assignment = _regionFor_1.assignment(_isIdentityCriteriaAssignment_1);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_assignment, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("domain");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.EntityScalarDataPropertyElements _entityScalarDataPropertyAccess_1 = this._oMLGrammarAccess.getEntityScalarDataPropertyAccess();
    RuleCall _domainEntityReferenceParserRuleCall_5_0_1 = _entityScalarDataPropertyAccess_1.getDomainEntityReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall = _regionFor_5.ruleCall(_domainEntityReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("range");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.EntityScalarDataPropertyElements _entityScalarDataPropertyAccess_2 = this._oMLGrammarAccess.getEntityScalarDataPropertyAccess();
    RuleCall _rangeDataRangeReferenceParserRuleCall_7_0_1 = _entityScalarDataPropertyAccess_2.getRangeDataRangeReferenceParserRuleCall_7_0_1();
    ISemanticRegion _ruleCall_1 = _regionFor_7.ruleCall(_rangeDataRangeReferenceParserRuleCall_7_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_8);
  }
  
  protected void _format(final StructuredDataProperty t, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword = _regionFor.keyword("structuredDataProperty");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.StructuredDataPropertyElements _structuredDataPropertyAccess = this._oMLGrammarAccess.getStructuredDataPropertyAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _structuredDataPropertyAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("domain");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.StructuredDataPropertyElements _structuredDataPropertyAccess_1 = this._oMLGrammarAccess.getStructuredDataPropertyAccess();
    RuleCall _domainStructureReferenceParserRuleCall_4_0_1 = _structuredDataPropertyAccess_1.getDomainStructureReferenceParserRuleCall_4_0_1();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_domainStructureReferenceParserRuleCall_4_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("range");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.StructuredDataPropertyElements _structuredDataPropertyAccess_2 = this._oMLGrammarAccess.getStructuredDataPropertyAccess();
    RuleCall _rangeStructureReferenceParserRuleCall_6_0_1 = _structuredDataPropertyAccess_2.getRangeStructureReferenceParserRuleCall_6_0_1();
    ISemanticRegion _ruleCall_2 = _regionFor_7.ruleCall(_rangeStructureReferenceParserRuleCall_6_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_2, _function_8);
  }
  
  protected void _format(final ScalarDataProperty t, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword = _regionFor.keyword("scalarDataProperty");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.ScalarDataPropertyElements _scalarDataPropertyAccess = this._oMLGrammarAccess.getScalarDataPropertyAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _scalarDataPropertyAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.ScalarDataPropertyElements _scalarDataPropertyAccess_1 = this._oMLGrammarAccess.getScalarDataPropertyAccess();
    Keyword _leftCurlyBracketKeyword_2 = _scalarDataPropertyAccess_1.getLeftCurlyBracketKeyword_2();
    final ISemanticRegion lcurly = _regionFor_2.keyword(_leftCurlyBracketKeyword_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.ScalarDataPropertyElements _scalarDataPropertyAccess_2 = this._oMLGrammarAccess.getScalarDataPropertyAccess();
    Keyword _rightCurlyBracketKeyword_7 = _scalarDataPropertyAccess_2.getRightCurlyBracketKeyword_7();
    final ISemanticRegion rcurly = _regionFor_3.keyword(_rightCurlyBracketKeyword_7);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("domain");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.ScalarDataPropertyElements _scalarDataPropertyAccess_3 = this._oMLGrammarAccess.getScalarDataPropertyAccess();
    RuleCall _domainStructureReferenceParserRuleCall_4_0_1 = _scalarDataPropertyAccess_3.getDomainStructureReferenceParserRuleCall_4_0_1();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_domainStructureReferenceParserRuleCall_4_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("range");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(t);
    OMLGrammarAccess.ScalarDataPropertyElements _scalarDataPropertyAccess_4 = this._oMLGrammarAccess.getScalarDataPropertyAccess();
    RuleCall _rangeDataRangeReferenceParserRuleCall_6_0_1 = _scalarDataPropertyAccess_4.getRangeDataRangeReferenceParserRuleCall_6_0_1();
    ISemanticRegion _ruleCall_2 = _regionFor_7.ruleCall(_rangeDataRangeReferenceParserRuleCall_6_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_2, _function_8);
  }
  
  protected void _format(final RootConceptTaxonomyAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("rootConceptTaxonomy");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(_keyword_2, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_3 = _regionFor_3.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_3, _function_3);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion lcurly = _regionFor_4.keyword("{");
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion rcurly = _regionFor_5.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_4 = _regionFor_6.keyword("root");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_7);
    EList<DisjointUnionOfConceptsAxiom> _disjunctions = ax.getDisjunctions();
    final Consumer<DisjointUnionOfConceptsAxiom> _function_8 = (DisjointUnionOfConceptsAxiom it) -> {
      DisjointUnionOfConceptsAxiom _format = document.<DisjointUnionOfConceptsAxiom>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<DisjointUnionOfConceptsAxiom>append(_format, _function_9);
    };
    _disjunctions.forEach(_function_8);
  }
  
  protected void _format(final AnonymousConceptUnionAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("anonymousConceptUnion");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(_keyword_2, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_3 = _regionFor_3.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_3, _function_3);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion lcurly = _regionFor_4.keyword("{");
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion rcurly = _regionFor_5.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_4 = _regionFor_6.keyword("root");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_7);
    EList<DisjointUnionOfConceptsAxiom> _disjunctions = ax.getDisjunctions();
    final Consumer<DisjointUnionOfConceptsAxiom> _function_8 = (DisjointUnionOfConceptsAxiom it) -> {
      DisjointUnionOfConceptsAxiom _format = document.<DisjointUnionOfConceptsAxiom>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<DisjointUnionOfConceptsAxiom>append(_format, _function_9);
    };
    _disjunctions.forEach(_function_8);
  }
  
  protected void _format(final SpecificDisjointConceptAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("disjointLeaf");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(_keyword_2, _function_2);
  }
  
  protected void _format(final EntityExistentialRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("someEntities");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("in");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_2, _function_2);
  }
  
  protected void _format(final EntityUniversalRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("allEntities");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("in");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_2, _function_2);
  }
  
  protected void _format(final EntityScalarDataPropertyExistentialRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("someData");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("in");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_2, _function_2);
  }
  
  protected void _format(final EntityScalarDataPropertyParticularRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("every");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_2, _function_2);
  }
  
  protected void _format(final EntityScalarDataPropertyUniversalRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("allData");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("in");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_2, _function_2);
  }
  
  protected void _format(final EntityStructuredDataPropertyParticularRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("every");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_2, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion lcurly = _regionFor_3.keyword("{");
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(ax);
    final ISemanticRegion rcurly = _regionFor_4.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    EList<RestrictionStructuredDataPropertyTuple> _structuredPropertyTuples = ax.getStructuredPropertyTuples();
    final Consumer<RestrictionStructuredDataPropertyTuple> _function_6 = (RestrictionStructuredDataPropertyTuple it) -> {
      RestrictionStructuredDataPropertyTuple _format = document.<RestrictionStructuredDataPropertyTuple>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<RestrictionStructuredDataPropertyTuple>append(_format, _function_7);
    };
    _structuredPropertyTuples.forEach(_function_6);
    EList<RestrictionScalarDataPropertyValue> _scalarDataPropertyValues = ax.getScalarDataPropertyValues();
    final Consumer<RestrictionScalarDataPropertyValue> _function_7 = (RestrictionScalarDataPropertyValue it) -> {
      RestrictionScalarDataPropertyValue _format = document.<RestrictionScalarDataPropertyValue>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<RestrictionScalarDataPropertyValue>append(_format, _function_8);
    };
    _scalarDataPropertyValues.forEach(_function_7);
  }
  
  protected void _format(final RestrictionStructuredDataPropertyTuple t, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword = _regionFor.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion lcurly = _regionFor_1.keyword("{");
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion rcurly = _regionFor_2.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_3);
    EList<RestrictionStructuredDataPropertyTuple> _structuredPropertyTuples = t.getStructuredPropertyTuples();
    final Consumer<RestrictionStructuredDataPropertyTuple> _function_4 = (RestrictionStructuredDataPropertyTuple it) -> {
      RestrictionStructuredDataPropertyTuple _format = document.<RestrictionStructuredDataPropertyTuple>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<RestrictionStructuredDataPropertyTuple>append(_format, _function_5);
    };
    _structuredPropertyTuples.forEach(_function_4);
    EList<RestrictionScalarDataPropertyValue> _scalarDataPropertyValues = t.getScalarDataPropertyValues();
    final Consumer<RestrictionScalarDataPropertyValue> _function_5 = (RestrictionScalarDataPropertyValue it) -> {
      RestrictionScalarDataPropertyValue _format = document.<RestrictionScalarDataPropertyValue>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<RestrictionScalarDataPropertyValue>append(_format, _function_6);
    };
    _scalarDataPropertyValues.forEach(_function_5);
  }
  
  protected void _format(final RestrictionScalarDataPropertyValue s, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(s);
    ISemanticRegion _keyword = _regionFor.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(s);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
  }
  
  protected void _format(final BinaryScalarRestriction sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("binaryScalarRestriction");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.BinaryScalarRestrictionElements _binaryScalarRestrictionAccess = this._oMLGrammarAccess.getBinaryScalarRestrictionAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _binaryScalarRestrictionAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("length");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.BinaryScalarRestrictionElements _binaryScalarRestrictionAccess_1 = this._oMLGrammarAccess.getBinaryScalarRestrictionAccess();
    RuleCall _lengthINTTerminalRuleCall_3_0_1_0 = _binaryScalarRestrictionAccess_1.getLengthINTTerminalRuleCall_3_0_1_0();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_lengthINTTerminalRuleCall_3_0_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("minLength");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.BinaryScalarRestrictionElements _binaryScalarRestrictionAccess_2 = this._oMLGrammarAccess.getBinaryScalarRestrictionAccess();
    RuleCall _minLengthINTTerminalRuleCall_3_1_1_0 = _binaryScalarRestrictionAccess_2.getMinLengthINTTerminalRuleCall_3_1_1_0();
    ISemanticRegion _ruleCall_2 = _regionFor_7.ruleCall(_minLengthINTTerminalRuleCall_3_1_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_2, _function_8);
    ISemanticRegionsFinder _regionFor_8 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_3 = _regionFor_8.keyword("maxLength");
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_3, _function_9);
    ISemanticRegionsFinder _regionFor_9 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.BinaryScalarRestrictionElements _binaryScalarRestrictionAccess_3 = this._oMLGrammarAccess.getBinaryScalarRestrictionAccess();
    RuleCall _maxLengthINTTerminalRuleCall_3_2_1_0 = _binaryScalarRestrictionAccess_3.getMaxLengthINTTerminalRuleCall_3_2_1_0();
    ISemanticRegion _ruleCall_3 = _regionFor_9.ruleCall(_maxLengthINTTerminalRuleCall_3_2_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_3, _function_10);
    ISemanticRegionsFinder _regionFor_10 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_4 = _regionFor_10.keyword("restrictedRange");
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_11);
    ISemanticRegionsFinder _regionFor_11 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.BinaryScalarRestrictionElements _binaryScalarRestrictionAccess_4 = this._oMLGrammarAccess.getBinaryScalarRestrictionAccess();
    RuleCall _restrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = _binaryScalarRestrictionAccess_4.getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall_4 = _regionFor_11.ruleCall(_restrictedRangeDataRangeReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_4, _function_12);
  }
  
  protected void _format(final IRIScalarRestriction sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("iriScalarRestriction");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.IRIScalarRestrictionElements _iRIScalarRestrictionAccess = this._oMLGrammarAccess.getIRIScalarRestrictionAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _iRIScalarRestrictionAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("length");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.IRIScalarRestrictionElements _iRIScalarRestrictionAccess_1 = this._oMLGrammarAccess.getIRIScalarRestrictionAccess();
    RuleCall _lengthINTTerminalRuleCall_3_0_1_0 = _iRIScalarRestrictionAccess_1.getLengthINTTerminalRuleCall_3_0_1_0();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_lengthINTTerminalRuleCall_3_0_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("minLength");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.IRIScalarRestrictionElements _iRIScalarRestrictionAccess_2 = this._oMLGrammarAccess.getIRIScalarRestrictionAccess();
    RuleCall _minLengthINTTerminalRuleCall_3_1_1_0 = _iRIScalarRestrictionAccess_2.getMinLengthINTTerminalRuleCall_3_1_1_0();
    ISemanticRegion _ruleCall_2 = _regionFor_7.ruleCall(_minLengthINTTerminalRuleCall_3_1_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_2, _function_8);
    ISemanticRegionsFinder _regionFor_8 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_3 = _regionFor_8.keyword("maxLength");
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_3, _function_9);
    ISemanticRegionsFinder _regionFor_9 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.IRIScalarRestrictionElements _iRIScalarRestrictionAccess_3 = this._oMLGrammarAccess.getIRIScalarRestrictionAccess();
    RuleCall _maxLengthINTTerminalRuleCall_3_2_1_0 = _iRIScalarRestrictionAccess_3.getMaxLengthINTTerminalRuleCall_3_2_1_0();
    ISemanticRegion _ruleCall_3 = _regionFor_9.ruleCall(_maxLengthINTTerminalRuleCall_3_2_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_3, _function_10);
    ISemanticRegionsFinder _regionFor_10 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_4 = _regionFor_10.keyword("pattern");
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_11);
    ISemanticRegionsFinder _regionFor_11 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.IRIScalarRestrictionElements _iRIScalarRestrictionAccess_4 = this._oMLGrammarAccess.getIRIScalarRestrictionAccess();
    RuleCall _patternSTRINGTerminalRuleCall_3_3_1_0 = _iRIScalarRestrictionAccess_4.getPatternSTRINGTerminalRuleCall_3_3_1_0();
    ISemanticRegion _ruleCall_4 = _regionFor_11.ruleCall(_patternSTRINGTerminalRuleCall_3_3_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_4, _function_12);
    ISemanticRegionsFinder _regionFor_12 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_5 = _regionFor_12.keyword("restrictedRange");
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_5, _function_13);
    ISemanticRegionsFinder _regionFor_13 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.IRIScalarRestrictionElements _iRIScalarRestrictionAccess_5 = this._oMLGrammarAccess.getIRIScalarRestrictionAccess();
    RuleCall _restrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = _iRIScalarRestrictionAccess_5.getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall_5 = _regionFor_13.ruleCall(_restrictedRangeDataRangeReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_5, _function_14);
  }
  
  protected void _format(final NumericScalarRestriction sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("numericScalarRestriction");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.NumericScalarRestrictionElements _numericScalarRestrictionAccess = this._oMLGrammarAccess.getNumericScalarRestrictionAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _numericScalarRestrictionAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("minInclusive");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.NumericScalarRestrictionElements _numericScalarRestrictionAccess_1 = this._oMLGrammarAccess.getNumericScalarRestrictionAccess();
    RuleCall _minInclusiveSTRINGTerminalRuleCall_3_0_1_0 = _numericScalarRestrictionAccess_1.getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_minInclusiveSTRINGTerminalRuleCall_3_0_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("maxInclusive");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.NumericScalarRestrictionElements _numericScalarRestrictionAccess_2 = this._oMLGrammarAccess.getNumericScalarRestrictionAccess();
    RuleCall _maxInclusiveSTRINGTerminalRuleCall_3_1_1_0 = _numericScalarRestrictionAccess_2.getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0();
    ISemanticRegion _ruleCall_2 = _regionFor_7.ruleCall(_maxInclusiveSTRINGTerminalRuleCall_3_1_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_2, _function_8);
    ISemanticRegionsFinder _regionFor_8 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_3 = _regionFor_8.keyword("minExclusive");
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_3, _function_9);
    ISemanticRegionsFinder _regionFor_9 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.NumericScalarRestrictionElements _numericScalarRestrictionAccess_3 = this._oMLGrammarAccess.getNumericScalarRestrictionAccess();
    RuleCall _minExclusiveSTRINGTerminalRuleCall_3_2_1_0 = _numericScalarRestrictionAccess_3.getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0();
    ISemanticRegion _ruleCall_3 = _regionFor_9.ruleCall(_minExclusiveSTRINGTerminalRuleCall_3_2_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_3, _function_10);
    ISemanticRegionsFinder _regionFor_10 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_4 = _regionFor_10.keyword("maxExclusive");
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_11);
    ISemanticRegionsFinder _regionFor_11 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.NumericScalarRestrictionElements _numericScalarRestrictionAccess_4 = this._oMLGrammarAccess.getNumericScalarRestrictionAccess();
    RuleCall _maxExclusiveSTRINGTerminalRuleCall_3_3_1_0 = _numericScalarRestrictionAccess_4.getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0();
    ISemanticRegion _ruleCall_4 = _regionFor_11.ruleCall(_maxExclusiveSTRINGTerminalRuleCall_3_3_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_4, _function_12);
    ISemanticRegionsFinder _regionFor_12 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_5 = _regionFor_12.keyword("restrictedRange");
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_5, _function_13);
    ISemanticRegionsFinder _regionFor_13 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.NumericScalarRestrictionElements _numericScalarRestrictionAccess_5 = this._oMLGrammarAccess.getNumericScalarRestrictionAccess();
    RuleCall _restrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = _numericScalarRestrictionAccess_5.getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall_5 = _regionFor_13.ruleCall(_restrictedRangeDataRangeReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_5, _function_14);
  }
  
  protected void _format(final PlainLiteralScalarRestriction sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("plainLiteralScalarRestriction");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.IRIScalarRestrictionElements _iRIScalarRestrictionAccess = this._oMLGrammarAccess.getIRIScalarRestrictionAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _iRIScalarRestrictionAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("length");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.PlainLiteralScalarRestrictionElements _plainLiteralScalarRestrictionAccess = this._oMLGrammarAccess.getPlainLiteralScalarRestrictionAccess();
    RuleCall _lengthINTTerminalRuleCall_3_0_1_0 = _plainLiteralScalarRestrictionAccess.getLengthINTTerminalRuleCall_3_0_1_0();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_lengthINTTerminalRuleCall_3_0_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("minLength");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.PlainLiteralScalarRestrictionElements _plainLiteralScalarRestrictionAccess_1 = this._oMLGrammarAccess.getPlainLiteralScalarRestrictionAccess();
    RuleCall _minLengthINTTerminalRuleCall_3_1_1_0 = _plainLiteralScalarRestrictionAccess_1.getMinLengthINTTerminalRuleCall_3_1_1_0();
    ISemanticRegion _ruleCall_2 = _regionFor_7.ruleCall(_minLengthINTTerminalRuleCall_3_1_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_2, _function_8);
    ISemanticRegionsFinder _regionFor_8 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_3 = _regionFor_8.keyword("maxLength");
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_3, _function_9);
    ISemanticRegionsFinder _regionFor_9 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.PlainLiteralScalarRestrictionElements _plainLiteralScalarRestrictionAccess_2 = this._oMLGrammarAccess.getPlainLiteralScalarRestrictionAccess();
    RuleCall _maxLengthINTTerminalRuleCall_3_2_1_0 = _plainLiteralScalarRestrictionAccess_2.getMaxLengthINTTerminalRuleCall_3_2_1_0();
    ISemanticRegion _ruleCall_3 = _regionFor_9.ruleCall(_maxLengthINTTerminalRuleCall_3_2_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_3, _function_10);
    ISemanticRegionsFinder _regionFor_10 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_4 = _regionFor_10.keyword("pattern");
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_11);
    ISemanticRegionsFinder _regionFor_11 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.PlainLiteralScalarRestrictionElements _plainLiteralScalarRestrictionAccess_3 = this._oMLGrammarAccess.getPlainLiteralScalarRestrictionAccess();
    RuleCall _patternSTRINGTerminalRuleCall_3_3_1_0 = _plainLiteralScalarRestrictionAccess_3.getPatternSTRINGTerminalRuleCall_3_3_1_0();
    ISemanticRegion _ruleCall_4 = _regionFor_11.ruleCall(_patternSTRINGTerminalRuleCall_3_3_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_4, _function_12);
    ISemanticRegionsFinder _regionFor_12 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_5 = _regionFor_12.keyword("langRange");
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_5, _function_13);
    ISemanticRegionsFinder _regionFor_13 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.PlainLiteralScalarRestrictionElements _plainLiteralScalarRestrictionAccess_4 = this._oMLGrammarAccess.getPlainLiteralScalarRestrictionAccess();
    RuleCall _langRangeSTRINGTerminalRuleCall_3_4_1_0 = _plainLiteralScalarRestrictionAccess_4.getLangRangeSTRINGTerminalRuleCall_3_4_1_0();
    ISemanticRegion _ruleCall_5 = _regionFor_13.ruleCall(_langRangeSTRINGTerminalRuleCall_3_4_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_5, _function_14);
    ISemanticRegionsFinder _regionFor_14 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_6 = _regionFor_14.keyword("restrictedRange");
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_6, _function_15);
    ISemanticRegionsFinder _regionFor_15 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.PlainLiteralScalarRestrictionElements _plainLiteralScalarRestrictionAccess_5 = this._oMLGrammarAccess.getPlainLiteralScalarRestrictionAccess();
    RuleCall _restrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = _plainLiteralScalarRestrictionAccess_5.getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall_6 = _regionFor_15.ruleCall(_restrictedRangeDataRangeReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_16 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_6, _function_16);
  }
  
  protected void _format(final ScalarOneOfRestriction sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("scalarOneOfRestriction");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.ScalarOneOfRestrictionElements _scalarOneOfRestrictionAccess = this._oMLGrammarAccess.getScalarOneOfRestrictionAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _scalarOneOfRestrictionAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("restrictedRange");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.ScalarOneOfRestrictionElements _scalarOneOfRestrictionAccess_1 = this._oMLGrammarAccess.getScalarOneOfRestrictionAccess();
    RuleCall _restrictedRangeDataRangeReferenceParserRuleCall_4_0_1 = _scalarOneOfRestrictionAccess_1.getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_restrictedRangeDataRangeReferenceParserRuleCall_4_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
  }
  
  protected void _format(final ScalarOneOfLiteralAxiom sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("oneOf");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
  }
  
  protected void _format(final StringScalarRestriction sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("stringScalarRestriction");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.StringScalarRestrictionElements _stringScalarRestrictionAccess = this._oMLGrammarAccess.getStringScalarRestrictionAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _stringScalarRestrictionAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("length");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.StringScalarRestrictionElements _stringScalarRestrictionAccess_1 = this._oMLGrammarAccess.getStringScalarRestrictionAccess();
    RuleCall _lengthINTTerminalRuleCall_3_0_1_0 = _stringScalarRestrictionAccess_1.getLengthINTTerminalRuleCall_3_0_1_0();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_lengthINTTerminalRuleCall_3_0_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("minLength");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.StringScalarRestrictionElements _stringScalarRestrictionAccess_2 = this._oMLGrammarAccess.getStringScalarRestrictionAccess();
    RuleCall _minLengthINTTerminalRuleCall_3_1_1_0 = _stringScalarRestrictionAccess_2.getMinLengthINTTerminalRuleCall_3_1_1_0();
    ISemanticRegion _ruleCall_2 = _regionFor_7.ruleCall(_minLengthINTTerminalRuleCall_3_1_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_2, _function_8);
    ISemanticRegionsFinder _regionFor_8 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_3 = _regionFor_8.keyword("maxLength");
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_3, _function_9);
    ISemanticRegionsFinder _regionFor_9 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.StringScalarRestrictionElements _stringScalarRestrictionAccess_3 = this._oMLGrammarAccess.getStringScalarRestrictionAccess();
    RuleCall _maxLengthINTTerminalRuleCall_3_2_1_0 = _stringScalarRestrictionAccess_3.getMaxLengthINTTerminalRuleCall_3_2_1_0();
    ISemanticRegion _ruleCall_3 = _regionFor_9.ruleCall(_maxLengthINTTerminalRuleCall_3_2_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_3, _function_10);
    ISemanticRegionsFinder _regionFor_10 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_4 = _regionFor_10.keyword("pattern");
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_11);
    ISemanticRegionsFinder _regionFor_11 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.StringScalarRestrictionElements _stringScalarRestrictionAccess_4 = this._oMLGrammarAccess.getStringScalarRestrictionAccess();
    RuleCall _patternSTRINGTerminalRuleCall_3_3_1_0 = _stringScalarRestrictionAccess_4.getPatternSTRINGTerminalRuleCall_3_3_1_0();
    ISemanticRegion _ruleCall_4 = _regionFor_11.ruleCall(_patternSTRINGTerminalRuleCall_3_3_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_4, _function_12);
    ISemanticRegionsFinder _regionFor_12 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_5 = _regionFor_12.keyword("restrictedRange");
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_5, _function_13);
    ISemanticRegionsFinder _regionFor_13 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.StringScalarRestrictionElements _stringScalarRestrictionAccess_5 = this._oMLGrammarAccess.getStringScalarRestrictionAccess();
    RuleCall _restrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = _stringScalarRestrictionAccess_5.getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall_5 = _regionFor_13.ruleCall(_restrictedRangeDataRangeReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_5, _function_14);
  }
  
  protected void _format(final SynonymScalarRestriction sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("synonymScalarRestriction");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.SynonymScalarRestrictionElements _synonymScalarRestrictionAccess = this._oMLGrammarAccess.getSynonymScalarRestrictionAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _synonymScalarRestrictionAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("restrictedRange");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.SynonymScalarRestrictionElements _synonymScalarRestrictionAccess_1 = this._oMLGrammarAccess.getSynonymScalarRestrictionAccess();
    RuleCall _restrictedRangeDataRangeReferenceParserRuleCall_4_0_1 = _synonymScalarRestrictionAccess_1.getRestrictedRangeDataRangeReferenceParserRuleCall_4_0_1();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_restrictedRangeDataRangeReferenceParserRuleCall_4_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
  }
  
  protected void _format(final TimeScalarRestriction sc, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword = _regionFor.keyword("timeScalarRestriction");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.TimeScalarRestrictionElements _timeScalarRestrictionAccess = this._oMLGrammarAccess.getTimeScalarRestrictionAccess();
    RuleCall _nameIDTerminalRuleCall_1_0 = _timeScalarRestrictionAccess.getNameIDTerminalRuleCall_1_0();
    ISemanticRegion _ruleCall = _regionFor_1.ruleCall(_nameIDTerminalRuleCall_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_ruleCall, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(sc);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword("minInclusive");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_1, _function_5);
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.TimeScalarRestrictionElements _timeScalarRestrictionAccess_1 = this._oMLGrammarAccess.getTimeScalarRestrictionAccess();
    RuleCall _minInclusiveSTRINGTerminalRuleCall_3_0_1_0 = _timeScalarRestrictionAccess_1.getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0();
    ISemanticRegion _ruleCall_1 = _regionFor_5.ruleCall(_minInclusiveSTRINGTerminalRuleCall_3_0_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_1, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_2 = _regionFor_6.keyword("maxInclusive");
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_2, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.TimeScalarRestrictionElements _timeScalarRestrictionAccess_2 = this._oMLGrammarAccess.getTimeScalarRestrictionAccess();
    RuleCall _maxInclusiveSTRINGTerminalRuleCall_3_1_1_0 = _timeScalarRestrictionAccess_2.getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0();
    ISemanticRegion _ruleCall_2 = _regionFor_7.ruleCall(_maxInclusiveSTRINGTerminalRuleCall_3_1_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_2, _function_8);
    ISemanticRegionsFinder _regionFor_8 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_3 = _regionFor_8.keyword("minExclusive");
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_3, _function_9);
    ISemanticRegionsFinder _regionFor_9 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.TimeScalarRestrictionElements _timeScalarRestrictionAccess_3 = this._oMLGrammarAccess.getTimeScalarRestrictionAccess();
    RuleCall _minExclusiveSTRINGTerminalRuleCall_3_2_1_0 = _timeScalarRestrictionAccess_3.getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0();
    ISemanticRegion _ruleCall_3 = _regionFor_9.ruleCall(_minExclusiveSTRINGTerminalRuleCall_3_2_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_3, _function_10);
    ISemanticRegionsFinder _regionFor_10 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_4 = _regionFor_10.keyword("maxExclusive");
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_11);
    ISemanticRegionsFinder _regionFor_11 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.TimeScalarRestrictionElements _timeScalarRestrictionAccess_4 = this._oMLGrammarAccess.getTimeScalarRestrictionAccess();
    RuleCall _maxExclusiveSTRINGTerminalRuleCall_3_3_1_0 = _timeScalarRestrictionAccess_4.getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0();
    ISemanticRegion _ruleCall_4 = _regionFor_11.ruleCall(_maxExclusiveSTRINGTerminalRuleCall_3_3_1_0);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_4, _function_12);
    ISemanticRegionsFinder _regionFor_12 = this.textRegionExtensions.regionFor(sc);
    ISemanticRegion _keyword_5 = _regionFor_12.keyword("restrictedRange");
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_5, _function_13);
    ISemanticRegionsFinder _regionFor_13 = this.textRegionExtensions.regionFor(sc);
    OMLGrammarAccess.TimeScalarRestrictionElements _timeScalarRestrictionAccess_5 = this._oMLGrammarAccess.getTimeScalarRestrictionAccess();
    RuleCall _restrictedRangeDataRangeReferenceParserRuleCall_5_0_1 = _timeScalarRestrictionAccess_5.getRestrictedRangeDataRangeReferenceParserRuleCall_5_0_1();
    ISemanticRegion _ruleCall_5 = _regionFor_13.ruleCall(_restrictedRangeDataRangeReferenceParserRuleCall_5_0_1);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(_ruleCall_5, _function_14);
  }
  
  protected void _format(final DescriptionBoxExtendsClosedWorldDefinitions ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("extends");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
  }
  
  protected void _format(final DescriptionBoxRefinement ax, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ax);
    ISemanticRegion _keyword = _regionFor.keyword("refines");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
  }
  
  protected void _format(final SingletonInstanceScalarDataPropertyValue s, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(s);
    ISemanticRegion _keyword = _regionFor.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(s);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
  }
  
  protected void _format(final SingletonInstanceStructuredDataPropertyValue s, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(s);
    ISemanticRegion _keyword = _regionFor.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(s);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(s);
    final ISemanticRegion lcurly = _regionFor_2.keyword("{");
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(s);
    final ISemanticRegion rcurly = _regionFor_3.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    EList<StructuredDataPropertyTuple> _structuredPropertyTuples = s.getStructuredPropertyTuples();
    final Consumer<StructuredDataPropertyTuple> _function_5 = (StructuredDataPropertyTuple it) -> {
      StructuredDataPropertyTuple _format = document.<StructuredDataPropertyTuple>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<StructuredDataPropertyTuple>append(_format, _function_6);
    };
    _structuredPropertyTuples.forEach(_function_5);
    EList<ScalarDataPropertyValue> _scalarDataPropertyValues = s.getScalarDataPropertyValues();
    final Consumer<ScalarDataPropertyValue> _function_6 = (ScalarDataPropertyValue it) -> {
      ScalarDataPropertyValue _format = document.<ScalarDataPropertyValue>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<ScalarDataPropertyValue>append(_format, _function_7);
    };
    _scalarDataPropertyValues.forEach(_function_6);
  }
  
  protected void _format(final StructuredDataPropertyTuple t, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(t);
    ISemanticRegion _keyword = _regionFor.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion lcurly = _regionFor_1.keyword("{");
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(t);
    final ISemanticRegion rcurly = _regionFor_2.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_3);
    EList<StructuredDataPropertyTuple> _structuredPropertyTuples = t.getStructuredPropertyTuples();
    final Consumer<StructuredDataPropertyTuple> _function_4 = (StructuredDataPropertyTuple it) -> {
      StructuredDataPropertyTuple _format = document.<StructuredDataPropertyTuple>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<StructuredDataPropertyTuple>append(_format, _function_5);
    };
    _structuredPropertyTuples.forEach(_function_4);
    EList<ScalarDataPropertyValue> _scalarDataPropertyValues = t.getScalarDataPropertyValues();
    final Consumer<ScalarDataPropertyValue> _function_5 = (ScalarDataPropertyValue it) -> {
      ScalarDataPropertyValue _format = document.<ScalarDataPropertyValue>format(it);
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<ScalarDataPropertyValue>append(_format, _function_6);
    };
    _scalarDataPropertyValues.forEach(_function_5);
  }
  
  protected void _format(final ScalarDataPropertyValue s, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(s);
    ISemanticRegion _keyword = _regionFor.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(s);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_1, _function_1);
  }
  
  protected void _format(final ConceptInstance i, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword = _regionFor.keyword("conceptInstance");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("is-a");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_2, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword_3 = _regionFor_3.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(_keyword_3, _function_3);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword_4 = _regionFor_4.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_4);
  }
  
  protected void _format(final ReifiedRelationshipInstance i, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword = _regionFor.keyword("reifiedRelationshipInstance");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("is-a");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(_keyword_2, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword_3 = _regionFor_3.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(_keyword_3, _function_3);
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(i);
    ISemanticRegion _keyword_4 = _regionFor_4.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword_4, _function_4);
  }
  
  public void format(final Object sc, final IFormattableDocument document) {
    if (sc instanceof BinaryScalarRestriction) {
      _format((BinaryScalarRestriction)sc, document);
      return;
    } else if (sc instanceof IRIScalarRestriction) {
      _format((IRIScalarRestriction)sc, document);
      return;
    } else if (sc instanceof NumericScalarRestriction) {
      _format((NumericScalarRestriction)sc, document);
      return;
    } else if (sc instanceof PlainLiteralScalarRestriction) {
      _format((PlainLiteralScalarRestriction)sc, document);
      return;
    } else if (sc instanceof ScalarOneOfRestriction) {
      _format((ScalarOneOfRestriction)sc, document);
      return;
    } else if (sc instanceof StringScalarRestriction) {
      _format((StringScalarRestriction)sc, document);
      return;
    } else if (sc instanceof SynonymScalarRestriction) {
      _format((SynonymScalarRestriction)sc, document);
      return;
    } else if (sc instanceof TimeScalarRestriction) {
      _format((TimeScalarRestriction)sc, document);
      return;
    } else if (sc instanceof Scalar) {
      _format((Scalar)sc, document);
      return;
    } else if (sc instanceof Aspect) {
      _format((Aspect)sc, document);
      return;
    } else if (sc instanceof AspectSpecializationAxiom) {
      _format((AspectSpecializationAxiom)sc, document);
      return;
    } else if (sc instanceof Concept) {
      _format((Concept)sc, document);
      return;
    } else if (sc instanceof ConceptSpecializationAxiom) {
      _format((ConceptSpecializationAxiom)sc, document);
      return;
    } else if (sc instanceof EntityExistentialRestrictionAxiom) {
      _format((EntityExistentialRestrictionAxiom)sc, document);
      return;
    } else if (sc instanceof EntityScalarDataProperty) {
      _format((EntityScalarDataProperty)sc, document);
      return;
    } else if (sc instanceof EntityScalarDataPropertyExistentialRestrictionAxiom) {
      _format((EntityScalarDataPropertyExistentialRestrictionAxiom)sc, document);
      return;
    } else if (sc instanceof EntityScalarDataPropertyParticularRestrictionAxiom) {
      _format((EntityScalarDataPropertyParticularRestrictionAxiom)sc, document);
      return;
    } else if (sc instanceof EntityScalarDataPropertyUniversalRestrictionAxiom) {
      _format((EntityScalarDataPropertyUniversalRestrictionAxiom)sc, document);
      return;
    } else if (sc instanceof EntityStructuredDataProperty) {
      _format((EntityStructuredDataProperty)sc, document);
      return;
    } else if (sc instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
      _format((EntityStructuredDataPropertyParticularRestrictionAxiom)sc, document);
      return;
    } else if (sc instanceof EntityUniversalRestrictionAxiom) {
      _format((EntityUniversalRestrictionAxiom)sc, document);
      return;
    } else if (sc instanceof ReifiedRelationship) {
      _format((ReifiedRelationship)sc, document);
      return;
    } else if (sc instanceof ReifiedRelationshipSpecializationAxiom) {
      _format((ReifiedRelationshipSpecializationAxiom)sc, document);
      return;
    } else if (sc instanceof ScalarDataProperty) {
      _format((ScalarDataProperty)sc, document);
      return;
    } else if (sc instanceof Structure) {
      _format((Structure)sc, document);
      return;
    } else if (sc instanceof StructuredDataProperty) {
      _format((StructuredDataProperty)sc, document);
      return;
    } else if (sc instanceof UnreifiedRelationship) {
      _format((UnreifiedRelationship)sc, document);
      return;
    } else if (sc instanceof BundledTerminologyAxiom) {
      _format((BundledTerminologyAxiom)sc, document);
      return;
    } else if (sc instanceof ConceptInstance) {
      _format((ConceptInstance)sc, document);
      return;
    } else if (sc instanceof ReifiedRelationshipInstance) {
      _format((ReifiedRelationshipInstance)sc, document);
      return;
    } else if (sc instanceof ConceptDesignationTerminologyAxiom) {
      _format((ConceptDesignationTerminologyAxiom)sc, document);
      return;
    } else if (sc instanceof TerminologyNestingAxiom) {
      _format((TerminologyNestingAxiom)sc, document);
      return;
    } else if (sc instanceof ScalarOneOfLiteralAxiom) {
      _format((ScalarOneOfLiteralAxiom)sc, document);
      return;
    } else if (sc instanceof TerminologyExtensionAxiom) {
      _format((TerminologyExtensionAxiom)sc, document);
      return;
    } else if (sc instanceof Bundle) {
      _format((Bundle)sc, document);
      return;
    } else if (sc instanceof RootConceptTaxonomyAxiom) {
      _format((RootConceptTaxonomyAxiom)sc, document);
      return;
    } else if (sc instanceof DescriptionBoxExtendsClosedWorldDefinitions) {
      _format((DescriptionBoxExtendsClosedWorldDefinitions)sc, document);
      return;
    } else if (sc instanceof DescriptionBoxRefinement) {
      _format((DescriptionBoxRefinement)sc, document);
      return;
    } else if (sc instanceof TerminologyGraph) {
      _format((TerminologyGraph)sc, document);
      return;
    } else if (sc instanceof AnonymousConceptUnionAxiom) {
      _format((AnonymousConceptUnionAxiom)sc, document);
      return;
    } else if (sc instanceof SpecificDisjointConceptAxiom) {
      _format((SpecificDisjointConceptAxiom)sc, document);
      return;
    } else if (sc instanceof DescriptionBox) {
      _format((DescriptionBox)sc, document);
      return;
    } else if (sc instanceof SingletonInstanceScalarDataPropertyValue) {
      _format((SingletonInstanceScalarDataPropertyValue)sc, document);
      return;
    } else if (sc instanceof SingletonInstanceStructuredDataPropertyValue) {
      _format((SingletonInstanceStructuredDataPropertyValue)sc, document);
      return;
    } else if (sc instanceof StructuredDataPropertyTuple) {
      _format((StructuredDataPropertyTuple)sc, document);
      return;
    } else if (sc instanceof RestrictionStructuredDataPropertyTuple) {
      _format((RestrictionStructuredDataPropertyTuple)sc, document);
      return;
    } else if (sc instanceof ScalarDataPropertyValue) {
      _format((ScalarDataPropertyValue)sc, document);
      return;
    } else if (sc instanceof RestrictionScalarDataPropertyValue) {
      _format((RestrictionScalarDataPropertyValue)sc, document);
      return;
    } else if (sc instanceof XtextResource) {
      _format((XtextResource)sc, document);
      return;
    } else if (sc instanceof Annotation) {
      _format((Annotation)sc, document);
      return;
    } else if (sc instanceof AnnotationProperty) {
      _format((AnnotationProperty)sc, document);
      return;
    } else if (sc instanceof Extent) {
      _format((Extent)sc, document);
      return;
    } else if (sc instanceof EObject) {
      _format((EObject)sc, document);
      return;
    } else if (sc == null) {
      _format((Void)null, document);
      return;
    } else if (sc != null) {
      _format(sc, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(sc, document).toString());
    }
  }
}
