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

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.tests.OMLInjectorProvider;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.datatypes.StringValue;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OMLInjectorProvider.class)
@SuppressWarnings("all")
public class OMLAnnotationTest2 {
  @Inject
  private ParseHelper<Extent> parseHelper;
  
  @Test
  public void test() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotationProperty rdfs:label=<http://www.w3.org/2000/01/rdf-schema#label>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("open terminology <http://imce.jpl.nasa.gov/foundation/mission/mission>");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@rdfs:label = \"Performing Element\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@rdfs:label = \"A performing element\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept PerformingElement");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Extent result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      Assert.assertTrue(errors.isEmpty());
      final Resource r = result.eResource();
      EcoreUtil.resolveAll(r);
      final AnnotationProperty ap = IterableExtensions.<AnnotationProperty>head(result.getAnnotationProperties());
      final TerminologyBox tbox = IterableExtensions.<TerminologyBox>head(Iterables.<TerminologyBox>filter(result.getModules(), TerminologyBox.class));
      Assert.assertEquals(tbox.nsPrefix(), "mission");
      final Concept c = IterableExtensions.<Concept>head(Iterables.<Concept>filter(tbox.getBoxStatements(), Concept.class));
      Assert.assertEquals(c.name(), "PerformingElement");
      final EList<AnnotationPropertyValue> ann = c.getAnnotations();
      Assert.assertEquals(2, ann.size());
      final Consumer<AnnotationPropertyValue> _function = (AnnotationPropertyValue a) -> {
        final AnnotationProperty a_prop = a.getProperty();
        final Element a_subj = a.getSubject();
        final StringValue a_value = a.getValue();
        Assert.assertTrue((a_value.value.equals("Performing Element") || a_value.value.equals("A performing element")));
        Assert.assertSame(ap, a_prop);
        Assert.assertSame(c, a_subj);
      };
      ann.forEach(_function);
      String _name = this.getClass().getName();
      String _plus = (_name + " OK!");
      System.out.println(_plus);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
