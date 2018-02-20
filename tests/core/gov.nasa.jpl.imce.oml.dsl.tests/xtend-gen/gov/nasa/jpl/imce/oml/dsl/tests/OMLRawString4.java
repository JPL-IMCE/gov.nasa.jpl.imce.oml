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
import gov.nasa.jpl.imce.oml.model.common.LiteralRawString;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
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
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OMLInjectorProvider.class)
@SuppressWarnings("all")
public class OMLRawString4 {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  private final CommonFactory commonF = CommonFactory.eINSTANCE;
  
  private final GraphsFactory graphsF = GraphsFactory.eINSTANCE;
  
  @Test
  public void test() {
    try {
      final XtextResourceSet rs = this.resourceSetProvider.get();
      final Resource r = rs.createResource(URI.createFileURI("file:OMLRawString.oml"));
      final Extent e = this.commonF.createExtent();
      r.getContents().add(e);
      final TerminologyGraph g = this.graphsF.createTerminologyGraph();
      e.getModules().add(g);
      g.setIri("http://www.example.org/OMLRawString");
      final AnnotationProperty ap1 = this.commonF.createAnnotationProperty();
      ap1.setModule(g);
      ap1.setAbbrevIRI("test:doc1");
      ap1.setIri("http://www.example.org/OMLRawString#doc1");
      final AnnotationProperty ap2 = this.commonF.createAnnotationProperty();
      ap2.setModule(g);
      ap2.setAbbrevIRI("test:doc2");
      ap2.setIri("http://www.example.org/OMLRawString#doc2");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Latch Valve: \"LP - 3/8\" other");
      this.addAnnotation(g, ap1, _builder.toString());
      final ByteArrayOutputStream bos = new ByteArrayOutputStream();
      final SaveOptions.Builder builder = SaveOptions.newBuilder();
      builder.format();
      final SaveOptions s = builder.getOptions();
      r.save(bos, s.toOptionsMap());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void addAnnotation(final LogicalElement e, final AnnotationProperty ap, final String v) {
    final AnnotationPropertyValue av = this.commonF.createAnnotationPropertyValue();
    EList<AnnotationPropertyValue> _annotations = e.getAnnotations();
    _annotations.add(av);
    av.setProperty(ap);
    final LiteralRawString s = this.commonF.createLiteralRawString();
    RawStringValue _rawStringValue = new RawStringValue(v);
    s.setString(_rawStringValue);
    av.setValue(s);
  }
}
