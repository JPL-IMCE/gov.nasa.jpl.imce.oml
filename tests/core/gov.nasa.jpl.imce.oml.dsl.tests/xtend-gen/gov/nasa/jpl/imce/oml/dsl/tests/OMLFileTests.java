/**
 * Copyright 2016 California Institute of Technology ("Caltech").
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
import gov.nasa.jpl.imce.oml.dsl.tests.OMLTest;
import gov.nasa.jpl.imce.oml.dsl.tests.OntologicalModelingLanguageInjectorProvider;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import java.net.URL;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
@InjectWith(OntologicalModelingLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class OMLFileTests extends OMLTest {
  @Inject
  @Extension
  private FormatterTestHelper _formatterTestHelper;
  
  /**
   * Tell the `testFile` method to verify
   * that the result of parsing an OML test file
   * is precisely an OML TerminologyExtent
   */
  @Override
  protected Class<? extends EObject> getRootObjectType(final URI uri) {
    return Extent.class;
  }
  
  @Test
  public void testBase() {
    final URL topURL = OMLFileTests.class.getResource("/");
    System.out.println(("topURL=" + topURL));
    final URL baseURL = OMLFileTests.class.getResource("/ModuleTests/imce.jpl.nasa.gov/foundation/base/base.oml");
    System.out.println(("baseURL=" + baseURL));
    this.testFile("ModuleTests/imce.jpl.nasa.gov/foundation/base/base.oml");
  }
  
  @Test
  public void testMission() {
    final URL topURL = OMLFileTests.class.getResource("/");
    System.out.println(("topURL=" + topURL));
    final URL missionURL = OMLFileTests.class.getResource("/ModuleTests/imce.jpl.nasa.gov/foundation/mission/mission.oml");
    System.out.println(("missionURL=" + missionURL));
    this.testFile("ModuleTests/imce.jpl.nasa.gov/foundation/mission/mission.oml", "ModuleTests/imce.jpl.nasa.gov/foundation/base/base.oml");
  }
  
  @Test
  public void format1() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<String>put(FormatterPreferenceKeys.indentation, "\t");
        it_1.<Integer>put(FormatterPreferenceKeys.tabWidth, Integer.valueOf(2));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("open terminology <http://imce.jpl.nasa.gov/foundation/base/base> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("aspect IdentifiedElement");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setExpectation(_builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append("open ");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("terminology ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<http://imce.jpl.nasa.gov/foundation/base/base>       {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("aspect ");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("IdentifiedElement");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setToBeFormatted(_builder_1);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
}
