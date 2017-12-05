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

import com.google.inject.Inject;
import com.google.inject.Provider;
import gov.nasa.jpl.imce.oml.dsl.tests.OMLInjectorProvider;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import java.io.ByteArrayOutputStream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OMLInjectorProvider.class)
@SuppressWarnings("all")
public class OMLAnnotationTest3a {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  private final CommonFactory commonF = CommonFactory.eINSTANCE;
  
  private final TerminologiesFactory terminologiesF = TerminologiesFactory.eINSTANCE;
  
  private final GraphsFactory graphsF = GraphsFactory.eINSTANCE;
  
  @Test
  public void test() {
    try {
      final XtextResourceSet rs = this.resourceSetProvider.get();
      final Resource r = rs.createResource(URI.createFileURI("file:OMLAnnoationTest3.oml"));
      final Extent e = this.commonF.createExtent();
      r.getContents().add(e);
      final AnnotationProperty ap1 = this.commonF.createAnnotationProperty();
      ap1.setExtent(e);
      ap1.setAbbrevIRI("test:doc1");
      ap1.setIri("http://www.example.org/OMLAnnotationTest3#doc1");
      final AnnotationProperty ap2 = this.commonF.createAnnotationProperty();
      ap2.setExtent(e);
      ap2.setAbbrevIRI("test:doc2");
      ap2.setIri("http://www.example.org/OMLAnnotationTest3#doc2");
      final TerminologyGraph g = this.graphsF.createTerminologyGraph();
      e.getModules().add(g);
      g.setIri("http://www.example.org/OMLAnnotationTest3");
      this.addAnnotation(g, ap1, "Un graphe...");
      this.addAnnotation(g, ap2, "A graph...");
      final Concept c = this.terminologiesF.createConcept();
      c.setTbox(g);
      c.setName("Box");
      this.addAnnotation(c, ap1, "Une boite...");
      this.addAnnotation(c, ap2, "A box...");
      final ByteArrayOutputStream bos = new ByteArrayOutputStream();
      final SaveOptions.Builder builder = SaveOptions.newBuilder();
      builder.format();
      final SaveOptions s = builder.getOptions();
      r.save(bos, s.toOptionsMap());
      final String text = bos.toString();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotationProperty test:doc1=<http://www.example.org/OMLAnnotationTest3#doc1>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("annotationProperty test:doc2=<http://www.example.org/OMLAnnotationTest3#doc2>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@test:doc1=\"Un graphe...\"");
      _builder.newLine();
      _builder.append("@test:doc2=\"A graph...\"");
      _builder.newLine();
      _builder.append("open terminology <http://www.example.org/OMLAnnotationTest3> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@test:doc1=\"Une boite...\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@test:doc2=\"A box...\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("concept Box");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(text, expected);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void addAnnotation(final LogicalElement e, final AnnotationProperty ap, final String v) {
    final AnnotationPropertyValue av = this.commonF.createAnnotationPropertyValue();
    EList<AnnotationPropertyValue> _annotations = e.getAnnotations();
    _annotations.add(av);
    av.setProperty(ap);
    final LiteralQuotedString s = this.commonF.createLiteralQuotedString();
    QuotedStringValue _quotedStringValue = new QuotedStringValue(v);
    s.setString(_quotedStringValue);
    av.setValue(s);
  }
}
