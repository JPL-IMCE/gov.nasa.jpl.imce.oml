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
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipExistentialRangeRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipUniversalRangeRestriction;
import gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipValueRestriction;
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
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedAspect;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedConcept;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
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
    final gov.nasa.jpl.imce.oml.model.common.Module lastM = IterableExtensions.<gov.nasa.jpl.imce.oml.model.common.Module>last(extent.getModules());
    final Consumer<gov.nasa.jpl.imce.oml.model.common.Module> _function_1 = (gov.nasa.jpl.imce.oml.model.common.Module m) -> {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        int _xifexpression = (int) 0;
        boolean _equals = Objects.equal(lastM, m);
        if (_equals) {
          _xifexpression = 1;
        } else {
          _xifexpression = 2;
        }
        it.setNewLines(_xifexpression);
      };
      document.<gov.nasa.jpl.imce.oml.model.common.Module>append(document.<gov.nasa.jpl.imce.oml.model.common.Module>format(m), _function_2);
    };
    extent.getModules().forEach(_function_1);
  }
  
  protected void _format(final AnnotationProperty annotationProperty, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(annotationProperty).keyword("annotationProperty"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(annotationProperty).keyword("="), _function_1);
  }
  
  protected void _format(final AnnotationPropertyValue annotation, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(annotation).keyword("@"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(annotation).keyword("="), _function_1);
  }
  
  protected void _format(final TerminologyGraph terminologyGraph, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationProperty> _function = (AnnotationProperty it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<AnnotationProperty>append(document.<AnnotationProperty>format(it), _function_1);
    };
    terminologyGraph.getAnnotationProperties().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(terminologyGraph).feature(TerminologiesPackage.eINSTANCE.getTerminologyBox_Kind()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(terminologyGraph).keyword("terminology"), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(terminologyGraph).ruleCall(this._oMLGrammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_4_0()), _function_3);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(terminologyGraph).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(terminologyGraph).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.append(lcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_6);
    final Consumer<AnnotationPropertyValue> _function_7 = (AnnotationPropertyValue ax) -> {
      this.format(ax, document);
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
        it.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(ax, _function_8);
    };
    terminologyGraph.getAnnotations().forEach(_function_7);
    final Consumer<TerminologyBoxAxiom> _function_8 = (TerminologyBoxAxiom ax) -> {
      this.format(ax, document);
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
        it.setNewLines(2);
      };
      document.<TerminologyBoxAxiom>append(ax, _function_9);
    };
    terminologyGraph.getBoxAxioms().forEach(_function_8);
    final Consumer<TerminologyBoxStatement> _function_9 = (TerminologyBoxStatement ax) -> {
      this.format(ax, document);
      final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
        it.setNewLines(2);
      };
      document.<TerminologyBoxStatement>append(ax, _function_10);
    };
    terminologyGraph.getBoxStatements().forEach(_function_9);
  }
  
  protected void _format(final Bundle bundle, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationProperty> _function = (AnnotationProperty it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<AnnotationProperty>append(document.<AnnotationProperty>format(it), _function_1);
    };
    bundle.getAnnotationProperties().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(bundle).feature(TerminologiesPackage.eINSTANCE.getTerminologyBox_Kind()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(bundle).keyword("bundle"), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(bundle).ruleCall(this._oMLGrammarAccess.getBundleAccess().getIriIRITerminalRuleCall_4_0()), _function_3);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(bundle).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(bundle).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.append(lcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_6);
    final Consumer<AnnotationPropertyValue> _function_7 = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_8);
    };
    bundle.getAnnotations().forEach(_function_7);
    final Consumer<TerminologyBoxAxiom> _function_8 = (TerminologyBoxAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBoxAxiom>append(document.<TerminologyBoxAxiom>format(it), _function_9);
    };
    bundle.getBoxAxioms().forEach(_function_8);
    final Consumer<TerminologyBoxStatement> _function_9 = (TerminologyBoxStatement it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBoxStatement>append(document.<TerminologyBoxStatement>format(it), _function_10);
    };
    bundle.getBoxStatements().forEach(_function_9);
    final Consumer<TerminologyBundleAxiom> _function_10 = (TerminologyBundleAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBundleAxiom>append(document.<TerminologyBundleAxiom>format(it), _function_11);
    };
    bundle.getBundleAxioms().forEach(_function_10);
    final Consumer<TerminologyBundleStatement> _function_11 = (TerminologyBundleStatement it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<TerminologyBundleStatement>append(document.<TerminologyBundleStatement>format(it), _function_12);
    };
    bundle.getBundleStatements().forEach(_function_11);
  }
  
  protected void _format(final DescriptionBox descriptionBox, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationProperty> _function = (AnnotationProperty it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<AnnotationProperty>append(document.<AnnotationProperty>format(it), _function_1);
    };
    descriptionBox.getAnnotationProperties().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(descriptionBox).feature(DescriptionsPackage.eINSTANCE.getDescriptionBox_Kind()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(descriptionBox).keyword("descriptionBox"), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(descriptionBox).ruleCall(this._oMLGrammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_4_0()), _function_3);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(descriptionBox).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(descriptionBox).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.append(lcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_6);
    final Consumer<AnnotationPropertyValue> _function_7 = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_8);
    };
    descriptionBox.getAnnotations().forEach(_function_7);
    final Consumer<DescriptionBoxExtendsClosedWorldDefinitions> _function_8 = (DescriptionBoxExtendsClosedWorldDefinitions it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<DescriptionBoxExtendsClosedWorldDefinitions>append(document.<DescriptionBoxExtendsClosedWorldDefinitions>format(it), _function_9);
    };
    descriptionBox.getClosedWorldDefinitions().forEach(_function_8);
    final Consumer<DescriptionBoxRefinement> _function_9 = (DescriptionBoxRefinement it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<DescriptionBoxRefinement>append(document.<DescriptionBoxRefinement>format(it), _function_10);
    };
    descriptionBox.getDescriptionBoxRefinements().forEach(_function_9);
    final Consumer<ConceptInstance> _function_10 = (ConceptInstance it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<ConceptInstance>append(document.<ConceptInstance>format(it), _function_11);
    };
    descriptionBox.getConceptInstances().forEach(_function_10);
    final Consumer<ReifiedRelationshipInstance> _function_11 = (ReifiedRelationshipInstance it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<ReifiedRelationshipInstance>append(document.<ReifiedRelationshipInstance>format(it), _function_12);
    };
    descriptionBox.getReifiedRelationshipInstances().forEach(_function_11);
    final Consumer<InstanceRelationshipExistentialRangeRestriction> _function_12 = (InstanceRelationshipExistentialRangeRestriction it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<InstanceRelationshipExistentialRangeRestriction>append(document.<InstanceRelationshipExistentialRangeRestriction>format(it), _function_13);
    };
    descriptionBox.getInstanceRelationshipExistentialRangeRestrictions().forEach(_function_12);
    final Consumer<InstanceRelationshipUniversalRangeRestriction> _function_13 = (InstanceRelationshipUniversalRangeRestriction it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<InstanceRelationshipUniversalRangeRestriction>append(document.<InstanceRelationshipUniversalRangeRestriction>format(it), _function_14);
    };
    descriptionBox.getInstanceRelationshipUniversalRangeRestrictions().forEach(_function_13);
    final Consumer<InstanceRelationshipValueRestriction> _function_14 = (InstanceRelationshipValueRestriction it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<InstanceRelationshipValueRestriction>append(document.<InstanceRelationshipValueRestriction>format(it), _function_15);
    };
    descriptionBox.getInstanceRelationshipValueRestrictions().forEach(_function_14);
    final Consumer<ReifiedRelationshipInstanceDomain> _function_15 = (ReifiedRelationshipInstanceDomain it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_16 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<ReifiedRelationshipInstanceDomain>append(document.<ReifiedRelationshipInstanceDomain>format(it), _function_16);
    };
    descriptionBox.getReifiedRelationshipInstanceDomains().forEach(_function_15);
    final Consumer<ReifiedRelationshipInstanceRange> _function_16 = (ReifiedRelationshipInstanceRange it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_17 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<ReifiedRelationshipInstanceRange>append(document.<ReifiedRelationshipInstanceRange>format(it), _function_17);
    };
    descriptionBox.getReifiedRelationshipInstanceRanges().forEach(_function_16);
    final Consumer<UnreifiedRelationshipInstanceTuple> _function_17 = (UnreifiedRelationshipInstanceTuple it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_18 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<UnreifiedRelationshipInstanceTuple>append(document.<UnreifiedRelationshipInstanceTuple>format(it), _function_18);
    };
    descriptionBox.getUnreifiedRelationshipInstanceTuples().forEach(_function_17);
    final Consumer<SingletonInstanceScalarDataPropertyValue> _function_18 = (SingletonInstanceScalarDataPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_19 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<SingletonInstanceScalarDataPropertyValue>append(document.<SingletonInstanceScalarDataPropertyValue>format(it), _function_19);
    };
    descriptionBox.getSingletonScalarDataPropertyValues().forEach(_function_18);
    final Consumer<SingletonInstanceStructuredDataPropertyValue> _function_19 = (SingletonInstanceStructuredDataPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_20 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<SingletonInstanceStructuredDataPropertyValue>append(document.<SingletonInstanceStructuredDataPropertyValue>format(it), _function_20);
    };
    descriptionBox.getSingletonStructuredDataPropertyValues().forEach(_function_19);
  }
  
  protected void _format(final Aspect aspect, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    aspect.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(aspect).keyword("aspect"), _function_1);
  }
  
  protected void _format(final CardinalityRestrictedAspect aspect, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    aspect.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(aspect).keyword("aspect"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(aspect).keyword("<="), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(aspect).keyword(">="), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(aspect).keyword("=="), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(aspect).keyword("."), _function_5);
  }
  
  protected void _format(final Concept concept, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    concept.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(concept).keyword("concept"), _function_1);
  }
  
  protected void _format(final CardinalityRestrictedConcept concept, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    concept.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(concept).keyword("concept"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(concept).keyword("<="), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(concept).keyword(">="), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(concept).keyword("=="), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(concept).keyword("."), _function_5);
  }
  
  protected void _format(final ReifiedRelationship rr, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    rr.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(rr).keyword("reifiedRelationship"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(rr).ruleCall(this._oMLGrammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(rr).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(rr).keyword("}");
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
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("functional"), _function_6);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("inverseFunctional"), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("essential"), _function_8);
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("inverseEssential"), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("symmetric"), _function_10);
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("asymmetric"), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("reflexive"), _function_12);
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("irreflexive"), _function_13);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("transitive"), _function_14);
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("unreified"), _function_15);
    final Procedure1<IHiddenRegionFormatter> _function_16 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("inverse"), _function_16);
    final Procedure1<IHiddenRegionFormatter> _function_17 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("source"), _function_17);
    final Procedure1<IHiddenRegionFormatter> _function_18 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(rr).keyword("target"), _function_18);
  }
  
  protected void _format(final ReifiedRelationshipRestriction prr, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    prr.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(prr).keyword("reifiedRelationship"), _function_1);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(prr).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(prr).keyword("}");
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
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(prr).keyword("source"), _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(prr).keyword("target"), _function_6);
  }
  
  protected void _format(final CardinalityRestrictedReifiedRelationship rr, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    rr.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(rr).keyword("reifiedRelationship"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(rr).keyword("<="), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(rr).keyword(">="), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(rr).keyword("=="), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(rr).keyword("."), _function_5);
  }
  
  protected void _format(final UnreifiedRelationship ur, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ur.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ur).keyword("unreifiedRelationship"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ur).ruleCall(this._oMLGrammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(ur).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(ur).keyword("}");
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
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("functional"), _function_6);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("inverseFunctional"), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("essential"), _function_8);
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("inverseEssential"), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("symmetric"), _function_10);
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("asymmetric"), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("reflexive"), _function_12);
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("irreflexive"), _function_13);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("transitive"), _function_14);
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("source"), _function_15);
    final Procedure1<IHiddenRegionFormatter> _function_16 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(this.textRegionExtensions.regionFor(ur).keyword("target"), _function_16);
  }
  
  protected void _format(final Scalar scalar, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    scalar.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(scalar).keyword("scalar"), _function_1);
  }
  
  protected void _format(final Structure structure, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    structure.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(structure).keyword("structure"), _function_1);
  }
  
  protected void _format(final ChainRule chainRule, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    chainRule.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(chainRule).keyword("rule"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(chainRule).keyword("infers"), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(document.prepend(this.textRegionExtensions.regionFor(chainRule).keyword("if"), _function_3), _function_4), _function_5);
    RuleBodySegment _firstSegment = chainRule.getFirstSegment();
    if (_firstSegment!=null) {
      document.<RuleBodySegment>format(_firstSegment);
    }
  }
  
  protected void _format(final RuleBodySegment tailSegment, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    tailSegment.getAnnotations().forEach(_function);
    SegmentPredicate _predicate = tailSegment.getPredicate();
    if (_predicate!=null) {
      document.<SegmentPredicate>format(_predicate);
    }
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(document.prepend(this.textRegionExtensions.regionFor(tailSegment).keyword("&&"), _function_1), _function_2), _function_3);
    RuleBodySegment _nextSegment = tailSegment.getNextSegment();
    if (_nextSegment!=null) {
      document.<RuleBodySegment>format(_nextSegment);
    }
  }
  
  protected void _format(final SegmentPredicate sp, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sp.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sp).keyword("source"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sp).keyword("invSource"), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sp).keyword("target"), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sp).keyword("invTarget"), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sp).keyword("inv"), _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sp).keyword("("), _function_6);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sp).keyword(")"), _function_7);
  }
  
  protected void _format(final AspectSpecializationAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("extendsAspect"), _function_1);
  }
  
  protected void _format(final ConceptSpecializationAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("extendsConcept"), _function_1);
  }
  
  protected void _format(final ReifiedRelationshipSpecializationAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("extendsRelationship"), _function_1);
  }
  
  protected void _format(final SubObjectPropertyOfAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("subObjectPropertyOf"), _function_1);
  }
  
  protected void _format(final SubDataPropertyOfAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("subDataPropertyOf"), _function_1);
  }
  
  protected void _format(final ConceptDesignationTerminologyAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("conceptDesignationTerminologyAxiom"), _function_1);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(ax).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(ax).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(ax).keyword("designatedTerminology"), _function_5), _function_6);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(ax).keyword("designatedConcept"), _function_7), _function_8);
  }
  
  protected void _format(final TerminologyExtensionAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("extends"), _function_1);
  }
  
  protected void _format(final TerminologyNestingAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("terminologyNestingAxiom"), _function_1);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(ax).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(ax).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(ax).keyword("nestingTerminology"), _function_5), _function_6);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(ax).keyword("nestingContext"), _function_7), _function_8);
  }
  
  protected void _format(final BundledTerminologyAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("bundles"), _function_1);
  }
  
  protected void _format(final EntityStructuredDataProperty t, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    t.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(t).keyword("entityStructuredDataProperty"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(t).assignment(this._oMLGrammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaAssignment_2()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(t).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(t).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(t).keyword("domain"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(t).keyword("range"), _function_8), _function_9);
  }
  
  protected void _format(final EntityScalarDataProperty t, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    t.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(t).keyword("entityScalarDataProperty"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(t).assignment(this._oMLGrammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaAssignment_2()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(t).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(t).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(t).keyword("domain"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(t).keyword("range"), _function_8), _function_9);
  }
  
  protected void _format(final StructuredDataProperty t, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    t.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(t).keyword("structuredDataProperty"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(t).ruleCall(this._oMLGrammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(t).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(t).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(t).keyword("domain"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(t).keyword("range"), _function_8), _function_9);
  }
  
  protected void _format(final ScalarDataProperty t, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    t.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(t).keyword("scalarDataProperty"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(t).ruleCall(this._oMLGrammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(t).keyword(this._oMLGrammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(t).keyword(this._oMLGrammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_8());
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(t).keyword("domain"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(t).keyword("range"), _function_8), _function_9);
  }
  
  protected void _format(final RootConceptTaxonomyAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("rootConceptTaxonomy"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("("), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(ax).keyword(")"), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword(")"), _function_4);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(ax).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(ax).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_6);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("root"), _function_8);
    final Consumer<DisjointUnionOfConceptsAxiom> _function_9 = (DisjointUnionOfConceptsAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<DisjointUnionOfConceptsAxiom>append(document.<DisjointUnionOfConceptsAxiom>format(it), _function_10);
    };
    ax.getDisjunctions().forEach(_function_9);
  }
  
  protected void _format(final AnonymousConceptUnionAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("anonymousConceptUnion"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("("), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(ax).keyword(")"), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword(")"), _function_4);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(ax).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(ax).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.append(lcurly, _function_6);
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("root"), _function_8);
    final Consumer<DisjointUnionOfConceptsAxiom> _function_9 = (DisjointUnionOfConceptsAxiom it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<DisjointUnionOfConceptsAxiom>append(document.<DisjointUnionOfConceptsAxiom>format(it), _function_10);
    };
    ax.getDisjunctions().forEach(_function_9);
  }
  
  protected void _format(final SpecificDisjointConceptAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("disjointLeaf"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("("), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(ax).keyword(")"), _function_3);
  }
  
  protected void _format(final EntityRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("someEntities"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("allEntities"), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("."), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("in"), _function_4);
  }
  
  protected void _format(final EntityScalarDataPropertyExistentialRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("someData"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("."), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("in"), _function_3);
  }
  
  protected void _format(final EntityScalarDataPropertyParticularRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("every"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("."), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("="), _function_3);
  }
  
  protected void _format(final EntityScalarDataPropertyUniversalRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("allData"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("."), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("in"), _function_3);
  }
  
  protected void _format(final EntityStructuredDataPropertyParticularRestrictionAxiom ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ax).keyword("every"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("."), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("="), _function_3);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(ax).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(ax).keyword("}");
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
    final Consumer<RestrictionStructuredDataPropertyTuple> _function_7 = (RestrictionStructuredDataPropertyTuple it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<RestrictionStructuredDataPropertyTuple>append(document.<RestrictionStructuredDataPropertyTuple>format(it), _function_8);
    };
    ax.getStructuredDataPropertyRestrictions().forEach(_function_7);
    final Consumer<RestrictionScalarDataPropertyValue> _function_8 = (RestrictionScalarDataPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<RestrictionScalarDataPropertyValue>append(document.<RestrictionScalarDataPropertyValue>format(it), _function_9);
    };
    ax.getScalarDataPropertyRestrictions().forEach(_function_8);
  }
  
  protected void _format(final RestrictionStructuredDataPropertyTuple t, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    t.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(t).keyword("="), _function_1);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(t).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(t).keyword("}");
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
    final Consumer<RestrictionStructuredDataPropertyTuple> _function_5 = (RestrictionStructuredDataPropertyTuple it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<RestrictionStructuredDataPropertyTuple>append(document.<RestrictionStructuredDataPropertyTuple>format(it), _function_6);
    };
    t.getStructuredDataPropertyRestrictions().forEach(_function_5);
    final Consumer<RestrictionScalarDataPropertyValue> _function_6 = (RestrictionScalarDataPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<RestrictionScalarDataPropertyValue>append(document.<RestrictionScalarDataPropertyValue>format(it), _function_7);
    };
    t.getScalarDataPropertyRestrictions().forEach(_function_6);
  }
  
  protected void _format(final RestrictionScalarDataPropertyValue s, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    s.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(s).keyword("."), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(s).keyword("="), _function_2);
  }
  
  protected void _format(final BinaryScalarRestriction sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("binaryScalarRestriction"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).ruleCall(this._oMLGrammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(sc).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(sc).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("length"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("minLength"), _function_8), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("maxLength"), _function_10), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("restrictedRange"), _function_12), _function_13);
  }
  
  protected void _format(final IRIScalarRestriction sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("iriScalarRestriction"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).ruleCall(this._oMLGrammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(sc).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(sc).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("length"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("minLength"), _function_8), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("maxLength"), _function_10), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("pattern"), _function_12), _function_13);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("restrictedRange"), _function_14), _function_15);
  }
  
  protected void _format(final NumericScalarRestriction sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("numericScalarRestriction"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).ruleCall(this._oMLGrammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(sc).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(sc).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("minInclusive"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("maxInclusive"), _function_8), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("minExclusive"), _function_10), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("maxExclusive"), _function_12), _function_13);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("restrictedRange"), _function_14), _function_15);
  }
  
  protected void _format(final PlainLiteralScalarRestriction sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("plainLiteralScalarRestriction"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).ruleCall(this._oMLGrammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(sc).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(sc).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("length"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("minLength"), _function_8), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("maxLength"), _function_10), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("pattern"), _function_12), _function_13);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("langRange"), _function_14), _function_15);
    final Procedure1<IHiddenRegionFormatter> _function_16 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_17 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("restrictedRange"), _function_16), _function_17);
  }
  
  protected void _format(final ScalarOneOfRestriction sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("scalarOneOfRestriction"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).ruleCall(this._oMLGrammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(sc).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(sc).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("restrictedRange"), _function_6), _function_7);
  }
  
  protected void _format(final ScalarOneOfLiteralAxiom sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("oneOf"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).keyword("="), _function_2);
  }
  
  protected void _format(final StringScalarRestriction sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("stringScalarRestriction"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).ruleCall(this._oMLGrammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(sc).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(sc).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("length"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("minLength"), _function_8), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("maxLength"), _function_10), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("pattern"), _function_12), _function_13);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("restrictedRange"), _function_14), _function_15);
  }
  
  protected void _format(final SynonymScalarRestriction sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("synonymScalarRestriction"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).ruleCall(this._oMLGrammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(sc).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(sc).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("restrictedRange"), _function_6), _function_7);
  }
  
  protected void _format(final TimeScalarRestriction sc, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    sc.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(sc).keyword("timeScalarRestriction"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(sc).ruleCall(this._oMLGrammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0()), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(sc).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(sc).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(lcurly, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(rcurly, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(lcurly, rcurly, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("minInclusive"), _function_6), _function_7);
    final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("maxInclusive"), _function_8), _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("minExclusive"), _function_10), _function_11);
    final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("maxExclusive"), _function_12), _function_13);
    final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.prepend(document.append(this.textRegionExtensions.regionFor(sc).keyword("restrictedRange"), _function_14), _function_15);
  }
  
  protected void _format(final DescriptionBoxExtendsClosedWorldDefinitions ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("extends"), _function_1);
  }
  
  protected void _format(final DescriptionBoxRefinement ax, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    ax.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ax).keyword("refines"), _function_1);
  }
  
  protected void _format(final SingletonInstanceScalarDataPropertyValue s, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    s.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(s).keyword("."), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(s).keyword("="), _function_2);
  }
  
  protected void _format(final SingletonInstanceStructuredDataPropertyValue s, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    s.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(s).keyword("."), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(s).keyword("="), _function_2);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(s).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(s).keyword("}");
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
    final Consumer<StructuredDataPropertyTuple> _function_6 = (StructuredDataPropertyTuple it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<StructuredDataPropertyTuple>append(document.<StructuredDataPropertyTuple>format(it), _function_7);
    };
    s.getStructuredPropertyTuples().forEach(_function_6);
    final Consumer<ScalarDataPropertyValue> _function_7 = (ScalarDataPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<ScalarDataPropertyValue>append(document.<ScalarDataPropertyValue>format(it), _function_8);
    };
    s.getScalarDataPropertyValues().forEach(_function_7);
  }
  
  protected void _format(final StructuredDataPropertyTuple t, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    t.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(t).keyword("="), _function_1);
    final ISemanticRegion lcurly = this.textRegionExtensions.regionFor(t).keyword("{");
    final ISemanticRegion rcurly = this.textRegionExtensions.regionFor(t).keyword("}");
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
    final Consumer<StructuredDataPropertyTuple> _function_5 = (StructuredDataPropertyTuple it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<StructuredDataPropertyTuple>append(document.<StructuredDataPropertyTuple>format(it), _function_6);
    };
    t.getStructuredPropertyTuples().forEach(_function_5);
    final Consumer<ScalarDataPropertyValue> _function_6 = (ScalarDataPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<ScalarDataPropertyValue>append(document.<ScalarDataPropertyValue>format(it), _function_7);
    };
    t.getScalarDataPropertyValues().forEach(_function_6);
  }
  
  protected void _format(final ScalarDataPropertyValue s, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    s.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(s).keyword("."), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(s).keyword("="), _function_2);
  }
  
  protected void _format(final ConceptInstance i, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    i.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(i).keyword("conceptInstance"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("("), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("is-a"), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(i).keyword(")"), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(i).keyword(")"), _function_5);
  }
  
  protected void _format(final ReifiedRelationshipInstance i, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    i.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(i).keyword("reifiedRelationshipInstance"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("("), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("is-a"), _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(i).keyword(")"), _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(i).keyword(")"), _function_5);
  }
  
  protected void _format(final InstanceRelationshipValueRestriction i, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    i.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("."), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("="), _function_2);
  }
  
  protected void _format(final InstanceRelationshipExistentialRangeRestriction i, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    i.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(i).keyword("someEntities"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("."), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("in"), _function_3);
  }
  
  protected void _format(final InstanceRelationshipUniversalRangeRestriction i, @Extension final IFormattableDocument document) {
    final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(1);
      };
      document.<AnnotationPropertyValue>append(document.<AnnotationPropertyValue>format(it), _function_1);
    };
    i.getAnnotations().forEach(_function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(i).keyword("someEntities"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("."), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(i).keyword("in"), _function_3);
  }
  
  public void format(final Object t, final IFormattableDocument document) {
    if (t instanceof EntityScalarDataProperty) {
      _format((EntityScalarDataProperty)t, document);
      return;
    } else if (t instanceof EntityStructuredDataProperty) {
      _format((EntityStructuredDataProperty)t, document);
      return;
    } else if (t instanceof ScalarDataProperty) {
      _format((ScalarDataProperty)t, document);
      return;
    } else if (t instanceof StructuredDataProperty) {
      _format((StructuredDataProperty)t, document);
      return;
    } else if (t instanceof BinaryScalarRestriction) {
      _format((BinaryScalarRestriction)t, document);
      return;
    } else if (t instanceof CardinalityRestrictedConcept) {
      _format((CardinalityRestrictedConcept)t, document);
      return;
    } else if (t instanceof CardinalityRestrictedReifiedRelationship) {
      _format((CardinalityRestrictedReifiedRelationship)t, document);
      return;
    } else if (t instanceof Concept) {
      _format((Concept)t, document);
      return;
    } else if (t instanceof IRIScalarRestriction) {
      _format((IRIScalarRestriction)t, document);
      return;
    } else if (t instanceof NumericScalarRestriction) {
      _format((NumericScalarRestriction)t, document);
      return;
    } else if (t instanceof PlainLiteralScalarRestriction) {
      _format((PlainLiteralScalarRestriction)t, document);
      return;
    } else if (t instanceof ReifiedRelationship) {
      _format((ReifiedRelationship)t, document);
      return;
    } else if (t instanceof ReifiedRelationshipRestriction) {
      _format((ReifiedRelationshipRestriction)t, document);
      return;
    } else if (t instanceof ScalarOneOfRestriction) {
      _format((ScalarOneOfRestriction)t, document);
      return;
    } else if (t instanceof StringScalarRestriction) {
      _format((StringScalarRestriction)t, document);
      return;
    } else if (t instanceof SynonymScalarRestriction) {
      _format((SynonymScalarRestriction)t, document);
      return;
    } else if (t instanceof TimeScalarRestriction) {
      _format((TimeScalarRestriction)t, document);
      return;
    } else if (t instanceof UnreifiedRelationship) {
      _format((UnreifiedRelationship)t, document);
      return;
    } else if (t instanceof Aspect) {
      _format((Aspect)t, document);
      return;
    } else if (t instanceof CardinalityRestrictedAspect) {
      _format((CardinalityRestrictedAspect)t, document);
      return;
    } else if (t instanceof Scalar) {
      _format((Scalar)t, document);
      return;
    } else if (t instanceof BundledTerminologyAxiom) {
      _format((BundledTerminologyAxiom)t, document);
      return;
    } else if (t instanceof ConceptDesignationTerminologyAxiom) {
      _format((ConceptDesignationTerminologyAxiom)t, document);
      return;
    } else if (t instanceof TerminologyNestingAxiom) {
      _format((TerminologyNestingAxiom)t, document);
      return;
    } else if (t instanceof AspectSpecializationAxiom) {
      _format((AspectSpecializationAxiom)t, document);
      return;
    } else if (t instanceof ChainRule) {
      _format((ChainRule)t, document);
      return;
    } else if (t instanceof ConceptSpecializationAxiom) {
      _format((ConceptSpecializationAxiom)t, document);
      return;
    } else if (t instanceof EntityScalarDataPropertyExistentialRestrictionAxiom) {
      _format((EntityScalarDataPropertyExistentialRestrictionAxiom)t, document);
      return;
    } else if (t instanceof EntityScalarDataPropertyParticularRestrictionAxiom) {
      _format((EntityScalarDataPropertyParticularRestrictionAxiom)t, document);
      return;
    } else if (t instanceof EntityScalarDataPropertyUniversalRestrictionAxiom) {
      _format((EntityScalarDataPropertyUniversalRestrictionAxiom)t, document);
      return;
    } else if (t instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
      _format((EntityStructuredDataPropertyParticularRestrictionAxiom)t, document);
      return;
    } else if (t instanceof ReifiedRelationshipSpecializationAxiom) {
      _format((ReifiedRelationshipSpecializationAxiom)t, document);
      return;
    } else if (t instanceof Structure) {
      _format((Structure)t, document);
      return;
    } else if (t instanceof TerminologyExtensionAxiom) {
      _format((TerminologyExtensionAxiom)t, document);
      return;
    } else if (t instanceof Bundle) {
      _format((Bundle)t, document);
      return;
    } else if (t instanceof ConceptInstance) {
      _format((ConceptInstance)t, document);
      return;
    } else if (t instanceof DescriptionBoxExtendsClosedWorldDefinitions) {
      _format((DescriptionBoxExtendsClosedWorldDefinitions)t, document);
      return;
    } else if (t instanceof DescriptionBoxRefinement) {
      _format((DescriptionBoxRefinement)t, document);
      return;
    } else if (t instanceof ReifiedRelationshipInstance) {
      _format((ReifiedRelationshipInstance)t, document);
      return;
    } else if (t instanceof TerminologyGraph) {
      _format((TerminologyGraph)t, document);
      return;
    } else if (t instanceof EntityRestrictionAxiom) {
      _format((EntityRestrictionAxiom)t, document);
      return;
    } else if (t instanceof ScalarOneOfLiteralAxiom) {
      _format((ScalarOneOfLiteralAxiom)t, document);
      return;
    } else if (t instanceof SubDataPropertyOfAxiom) {
      _format((SubDataPropertyOfAxiom)t, document);
      return;
    } else if (t instanceof SubObjectPropertyOfAxiom) {
      _format((SubObjectPropertyOfAxiom)t, document);
      return;
    } else if (t instanceof AnonymousConceptUnionAxiom) {
      _format((AnonymousConceptUnionAxiom)t, document);
      return;
    } else if (t instanceof RootConceptTaxonomyAxiom) {
      _format((RootConceptTaxonomyAxiom)t, document);
      return;
    } else if (t instanceof SpecificDisjointConceptAxiom) {
      _format((SpecificDisjointConceptAxiom)t, document);
      return;
    } else if (t instanceof DescriptionBox) {
      _format((DescriptionBox)t, document);
      return;
    } else if (t instanceof InstanceRelationshipExistentialRangeRestriction) {
      _format((InstanceRelationshipExistentialRangeRestriction)t, document);
      return;
    } else if (t instanceof InstanceRelationshipUniversalRangeRestriction) {
      _format((InstanceRelationshipUniversalRangeRestriction)t, document);
      return;
    } else if (t instanceof InstanceRelationshipValueRestriction) {
      _format((InstanceRelationshipValueRestriction)t, document);
      return;
    } else if (t instanceof SingletonInstanceStructuredDataPropertyValue) {
      _format((SingletonInstanceStructuredDataPropertyValue)t, document);
      return;
    } else if (t instanceof StructuredDataPropertyTuple) {
      _format((StructuredDataPropertyTuple)t, document);
      return;
    } else if (t instanceof RestrictionStructuredDataPropertyTuple) {
      _format((RestrictionStructuredDataPropertyTuple)t, document);
      return;
    } else if (t instanceof AnnotationPropertyValue) {
      _format((AnnotationPropertyValue)t, document);
      return;
    } else if (t instanceof ScalarDataPropertyValue) {
      _format((ScalarDataPropertyValue)t, document);
      return;
    } else if (t instanceof SingletonInstanceScalarDataPropertyValue) {
      _format((SingletonInstanceScalarDataPropertyValue)t, document);
      return;
    } else if (t instanceof RestrictionScalarDataPropertyValue) {
      _format((RestrictionScalarDataPropertyValue)t, document);
      return;
    } else if (t instanceof RuleBodySegment) {
      _format((RuleBodySegment)t, document);
      return;
    } else if (t instanceof SegmentPredicate) {
      _format((SegmentPredicate)t, document);
      return;
    } else if (t instanceof AnnotationProperty) {
      _format((AnnotationProperty)t, document);
      return;
    } else if (t instanceof XtextResource) {
      _format((XtextResource)t, document);
      return;
    } else if (t instanceof Extent) {
      _format((Extent)t, document);
      return;
    } else if (t instanceof EObject) {
      _format((EObject)t, document);
      return;
    } else if (t == null) {
      _format((Void)null, document);
      return;
    } else if (t != null) {
      _format(t, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, document).toString());
    }
  }
}
