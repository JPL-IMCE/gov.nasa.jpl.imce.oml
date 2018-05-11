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
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OMLInjectorProvider.class)
@SuppressWarnings("all")
public class OMLRuleTest1 {
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
      _builder.append("concept A");
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
      _builder.append("unreifiedRelationship p {");
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
      _builder.append("source=B");
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
      _builder.append("rule pqr infers Foo:r if Foo:p && Foo:q");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      final Extent result = this.parseHelper.parse(text);
      Assert.assertNotNull(result);
      final Resource r = result.eResource();
      Assert.assertTrue(r.getErrors().isEmpty());
      final TerminologyBox tbox = IterableExtensions.<TerminologyBox>head(Iterables.<TerminologyBox>filter(result.getModules(), TerminologyBox.class));
      Assert.assertNotNull(tbox);
      final Iterable<UnreifiedRelationship> urs = Iterables.<UnreifiedRelationship>filter(tbox.getBoxStatements(), UnreifiedRelationship.class);
      final Function1<UnreifiedRelationship, Boolean> _function = (UnreifiedRelationship it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "p"));
      };
      final UnreifiedRelationship P = IterableExtensions.<UnreifiedRelationship>head(IterableExtensions.<UnreifiedRelationship>filter(urs, _function));
      Assert.assertNotNull(P);
      final Function1<UnreifiedRelationship, Boolean> _function_1 = (UnreifiedRelationship it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "q"));
      };
      final UnreifiedRelationship Q = IterableExtensions.<UnreifiedRelationship>head(IterableExtensions.<UnreifiedRelationship>filter(urs, _function_1));
      Assert.assertNotNull(Q);
      final Function1<UnreifiedRelationship, Boolean> _function_2 = (UnreifiedRelationship it) -> {
        String _name = it.name();
        return Boolean.valueOf(Objects.equal(_name, "r"));
      };
      final UnreifiedRelationship R = IterableExtensions.<UnreifiedRelationship>head(IterableExtensions.<UnreifiedRelationship>filter(urs, _function_2));
      Assert.assertNotNull(R);
      final ChainRule rule = IterableExtensions.<ChainRule>head(Iterables.<ChainRule>filter(tbox.getBoxStatements(), ChainRule.class));
      Assert.assertNotNull(rule);
      Assert.assertEquals(rule.getHead(), R);
      final RuleBodySegment tail1 = rule.getFirstSegment();
      Assert.assertNotNull(tail1);
      Assert.assertEquals(tail1.getPredicate().termPredicate(), P);
      final RuleBodySegment tail2 = tail1.getNextSegment();
      Assert.assertNotNull(tail2);
      Assert.assertEquals(tail2.getPredicate().termPredicate(), Q);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
