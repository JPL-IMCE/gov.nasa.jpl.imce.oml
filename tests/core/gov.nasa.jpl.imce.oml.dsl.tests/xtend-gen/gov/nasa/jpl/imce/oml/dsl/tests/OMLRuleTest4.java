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
package gov.nasa.jpl.imce.oml.dsl.tests;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.tests.OMLInjectorProvider;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OMLInjectorProvider.class)
@SuppressWarnings("all")
public class OMLRuleTest4 {
  @Inject
  private ParseHelper<Extent> parseHelper;
  
  @Test
  public void ruleTest1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("open terminology <http://example.org/Foo> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("aspect A");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept B");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept C");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("reifiedRelationship P {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("unreified=p");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("source=A");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("target=B");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("unreifiedRelationship q {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("source=C");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("target=B");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("unreifiedRelationship r {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("source=A");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("target=C");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("unreifiedRelationship s {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("source=P");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("target=C");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("rule pqr infers Foo:r if aspect(Foo:A) && reifiedRelationship(Foo:P) && concept(Foo:B) && inv(Foo:q)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("rule psr infers Foo:r if aspect(Foo:A) && inv(source(Foo:P)) && reifiedRelationship(Foo:P) && Foo:s");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      final Extent result = this.parseHelper.parse(text);
      Assert.assertNotNull(result);
      Resource _eResource = result.eResource();
      final XtextResource r = ((XtextResource) _eResource);
      this.assertNoSyntaxErrors(r);
      final TerminologyBox tbox = IterableExtensions.<TerminologyBox>head(Iterables.<TerminologyBox>filter(result.getModules(), TerminologyBox.class));
      Assert.assertNotNull(tbox);
      final Iterable<Aspect> aspects = Iterables.<Aspect>filter(tbox.getBoxStatements(), Aspect.class);
      final Function1<Aspect, Boolean> _function = (Aspect it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "A"));
      };
      final Aspect A = IterableExtensions.<Aspect>head(IterableExtensions.<Aspect>filter(aspects, _function));
      Assert.assertNotNull(A);
      final Iterable<Concept> concepts = Iterables.<Concept>filter(tbox.getBoxStatements(), Concept.class);
      final Function1<Concept, Boolean> _function_1 = (Concept it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "B"));
      };
      final Concept B = IterableExtensions.<Concept>head(IterableExtensions.<Concept>filter(concepts, _function_1));
      Assert.assertNotNull(B);
      final Iterable<ReifiedRelationship> rrs = Iterables.<ReifiedRelationship>filter(tbox.getBoxStatements(), ReifiedRelationship.class);
      final Function1<ReifiedRelationship, Boolean> _function_2 = (ReifiedRelationship it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "P"));
      };
      final ReifiedRelationship P = IterableExtensions.<ReifiedRelationship>head(IterableExtensions.<ReifiedRelationship>filter(rrs, _function_2));
      Assert.assertNotNull(P);
      final Iterable<UnreifiedRelationship> urs = Iterables.<UnreifiedRelationship>filter(tbox.getBoxStatements(), UnreifiedRelationship.class);
      final Function1<UnreifiedRelationship, Boolean> _function_3 = (UnreifiedRelationship it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "q"));
      };
      final UnreifiedRelationship Q = IterableExtensions.<UnreifiedRelationship>head(IterableExtensions.<UnreifiedRelationship>filter(urs, _function_3));
      Assert.assertNotNull(Q);
      final Function1<UnreifiedRelationship, Boolean> _function_4 = (UnreifiedRelationship it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "r"));
      };
      final UnreifiedRelationship R = IterableExtensions.<UnreifiedRelationship>head(IterableExtensions.<UnreifiedRelationship>filter(urs, _function_4));
      Assert.assertNotNull(R);
      final Function1<UnreifiedRelationship, Boolean> _function_5 = (UnreifiedRelationship it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "s"));
      };
      final UnreifiedRelationship S = IterableExtensions.<UnreifiedRelationship>head(IterableExtensions.<UnreifiedRelationship>filter(urs, _function_5));
      Assert.assertNotNull(S);
      final Iterable<ChainRule> rules = Iterables.<ChainRule>filter(tbox.getBoxStatements(), ChainRule.class);
      final Function1<ChainRule, Boolean> _function_6 = (ChainRule it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "pqr"));
      };
      final ChainRule r1 = IterableExtensions.<ChainRule>head(IterableExtensions.<ChainRule>filter(rules, _function_6));
      Assert.assertNotNull(r1);
      Assert.assertEquals(r1.getHead(), R);
      final RuleBodySegment tail11 = r1.getFirstSegment();
      Assert.assertNotNull(tail11);
      Assert.assertEquals(tail11.getPredicate().termPredicate(), A);
      final RuleBodySegment tail12 = tail11.getNextSegment();
      Assert.assertNotNull(tail12);
      Assert.assertEquals(tail12.getPredicate().termPredicate(), P);
      final RuleBodySegment tail13 = tail12.getNextSegment();
      Assert.assertNotNull(tail13);
      Assert.assertEquals(tail13.getPredicate().termPredicate(), B);
      final RuleBodySegment tail14 = tail13.getNextSegment();
      Assert.assertNotNull(tail14);
      Assert.assertEquals(tail14.getPredicate().termPredicate(), Q);
      Assert.assertNull(tail14.getNextSegment());
      final Function1<ChainRule, Boolean> _function_7 = (ChainRule it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "psr"));
      };
      final ChainRule r2 = IterableExtensions.<ChainRule>head(IterableExtensions.<ChainRule>filter(rules, _function_7));
      Assert.assertNotNull(r2);
      Assert.assertEquals(r2.getHead(), R);
      final RuleBodySegment tail21 = r2.getFirstSegment();
      Assert.assertNotNull(tail21);
      Assert.assertEquals(tail21.getPredicate().termPredicate(), A);
      final RuleBodySegment tail22 = tail21.getNextSegment();
      Assert.assertNotNull(tail22);
      Assert.assertEquals(tail22.getPredicate().termPredicate(), P);
      final RuleBodySegment tail23 = tail22.getNextSegment();
      Assert.assertNotNull(tail23);
      Assert.assertEquals(tail23.getPredicate().termPredicate(), P);
      final RuleBodySegment tail24 = tail23.getNextSegment();
      Assert.assertNotNull(tail24);
      Assert.assertEquals(tail24.getPredicate().termPredicate(), S);
      Assert.assertNull(tail24.getNextSegment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertNoSyntaxErrors(final XtextResource resource) {
    final Iterable<INode> syntaxErrors = resource.getParseResult().getSyntaxErrors();
    boolean _isEmpty = Iterables.isEmpty(syntaxErrors);
    boolean _not = (!_isEmpty);
    if (_not) {
      final StringBuilder builder = new StringBuilder();
      builder.append("This document can\'t be formatted because of syntax errors:\n");
      for (final INode node : syntaxErrors) {
        {
          final SyntaxErrorMessage msg = node.getSyntaxErrorMessage();
          builder.append(String.format("Line %02d: %s\n", Integer.valueOf(node.getTotalStartLine()), msg.getMessage()));
        }
      }
      this.fail(builder, resource.getParseResult().getRootNode().getText());
    }
  }
  
  public void fail(final CharSequence error, final CharSequence document) {
    CharSequence _trimTrailingLineBreak = Strings.trimTrailingLineBreak(error);
    final StringBuilder builder = new StringBuilder(_trimTrailingLineBreak);
    boolean _notEquals = (!Objects.equal(document, null));
    if (_notEquals) {
      builder.append("\n----------------------------------------------------------\n");
      builder.append(Strings.trimTrailingLineBreak(document));
      builder.append("\n----------------------------------------------------------");
    }
    final String msg = builder.toString();
    System.err.println(msg);
    Assert.fail(msg);
  }
}
