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
public class OMLTerminologyGraph1Test {
  @Inject
  private ParseHelper<Extent> parseHelper;
  
  @Test
  public void terminologyGraph1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotationProperty rdfs:label=<http://www.w3.org/2000/01/rdf-schema#label>");
      _builder.newLine();
      _builder.append("annotationProperty 1.1:title=<http://purl.org/dc/elements/1.1/title>");
      _builder.newLine();
      _builder.append("annotationProperty owl2-mof2:hasBinaryDependencySource=<http://imce.jpl.nasa.gov/foundation/owl2-mof2/owl2-mof2#hasBinaryDependencySource>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("open terminology <http://imce.jpl.nasa.gov/foundation/mission/mission>");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@rdfs:label = \"Performing Element\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@rdfs:label = \"A performing element\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@1.1:title = \"Performing Element\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept PerformingElement");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept Foo-Bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("scalar decimal");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("stringScalarRestriction integer {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("maxLength 10");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("pattern /[\\\\\\\\-+]?[0-9]+/");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("restrictedRange decimal");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("numericScalarRestriction XSDlong {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("minInclusive -9223372036854775808");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("maxInclusive 9223372036854775807");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("restrictedRange decimal");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("open terminology <http://purl.org/dc/elements/1.1/> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept Foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("open terminology <http://example.org> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("extends <http://purl.org/dc/elements/1.1/>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept Bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Bar extendsConcept 1.1:Foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
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
      final AnnotationPropertyValue a = IterableExtensions.<AnnotationPropertyValue>head(c.getAnnotations());
      final AnnotationProperty a_prop = a.getProperty();
      final Element a_subj = a.getSubject();
      final StringValue a_value = a.getValue();
      Assert.assertEquals("Performing Element", a_value.value);
      Assert.assertSame(ap, a_prop);
      Assert.assertSame(c, a_subj);
      String _name = this.getClass().getName();
      String _plus = (_name + " OK!");
      System.out.println(_plus);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
