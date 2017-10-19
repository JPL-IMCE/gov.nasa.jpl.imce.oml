/**
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */
package gov.nasa.jpl.imce.oml.dsl.tests;

import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.tests.OMLInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OMLInjectorProvider.class)
@SuppressWarnings("all")
public class OMLRuleTest2 {
  @Inject
  @Extension
  private FormatterTestHelper _formatterTestHelper;
  
  @Test
  public void ruleTest2() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<String>put(FormatterPreferenceKeys.indentation, "\t");
        it_1.<Integer>put(FormatterPreferenceKeys.tabWidth, Integer.valueOf(2));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("open terminology <http://example.org/Foo> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept A");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept B");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept C");
      _builder.newLine();
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
      _builder.newLine();
      _builder.append("\t");
      _builder.append("rule pqr infers Foo:r");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if Foo:p");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setExpectation(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("open terminology <http://example.org/Foo> {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("concept A");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("concept B");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("concept C");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unreifiedRelationship p {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("source=A");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("target=B");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unreifiedRelationship q {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("source=B");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("target=C");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("unreifiedRelationship r {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("source=A");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("target=C");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("rule pqr infers Foo:r if Foo:p");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setToBeFormatted(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
}
