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
import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializedReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import java.io.ByteArrayOutputStream;
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
public class OMLSpecializedReifiedRelationshipTest1 {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  private final CommonFactory commonF = CommonFactory.eINSTANCE;
  
  private final TerminologiesFactory terminologiesF = TerminologiesFactory.eINSTANCE;
  
  private final GraphsFactory graphsF = GraphsFactory.eINSTANCE;
  
  @Test
  public void test() {
    final XtextResourceSet rs = this.resourceSetProvider.get();
    final Resource r1 = rs.createResource(URI.createFileURI("file:OMLSpecializedReifiedRelationshipTest1.oml"));
    final Extent e1 = this.commonF.createExtent();
    r1.getContents().add(e1);
    final TerminologyGraph g = this.graphsF.createTerminologyGraph();
    g.setExtent(e1);
    g.setIri("http://www.example.org/OMLSpecializedReifiedRelationshipTest1");
    final Concept c1 = this.terminologiesF.createConcept();
    c1.setTbox(g);
    c1.setName("A");
    final Aspect c2 = this.terminologiesF.createAspect();
    c2.setTbox(g);
    c2.setName("B");
    final Concept c3 = this.terminologiesF.createConcept();
    c3.setTbox(g);
    c3.setName("C");
    final Concept c4 = this.terminologiesF.createConcept();
    c4.setTbox(g);
    c4.setName("D");
    final ConceptSpecializationAxiom c3_extends_c1 = this.terminologiesF.createConceptSpecializationAxiom();
    c3_extends_c1.setTbox(g);
    c3_extends_c1.setSubConcept(c3);
    c3_extends_c1.setSuperConcept(c1);
    final AspectSpecializationAxiom c4_extends_c2 = this.terminologiesF.createAspectSpecializationAxiom();
    c4_extends_c2.setTbox(g);
    c4_extends_c2.setSubEntity(c4);
    c4_extends_c2.setSuperAspect(c2);
    final ReifiedRelationship rr = this.terminologiesF.createReifiedRelationship();
    rr.setTbox(g);
    rr.setName("R");
    rr.setSource(c1);
    rr.setTarget(c2);
    final ForwardProperty rrf = this.terminologiesF.createForwardProperty();
    rrf.setReifiedRelationship(rr);
    rrf.setName("r");
    final SpecializedReifiedRelationship sr1 = this.terminologiesF.createSpecializedReifiedRelationship();
    sr1.setTbox(g);
    sr1.setName("R1");
    sr1.setSource(c3);
    sr1.setTarget(c2);
    sr1.setGeneral(rr);
    final SpecializedReifiedRelationship sr2 = this.terminologiesF.createSpecializedReifiedRelationship();
    sr2.setTbox(g);
    sr2.setName("R2");
    sr2.setSource(c3);
    sr2.setTarget(c4);
    sr2.setGeneral(sr1);
    OMLExtensions.normalize(e1);
    final String text1 = this.serialize(r1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("open terminology <http://www.example.org/OMLSpecializedReifiedRelationshipTest1> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("aspect B");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("concept A");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("concept C");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("concept D");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("C extendsConcept A");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("reifiedRelationship R {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("unreified = r");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source = A");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("target = B }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("reifiedRelationship R1 extends R {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source = C");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("target = B }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("reifiedRelationship R2 extends R1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source = C");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("target = D }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("D extendsAspect B");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String expected1 = _builder.toString();
    Assert.assertEquals(text1, expected1);
  }
  
  public String serialize(final Resource r) {
    try {
      String _xblockexpression = null;
      {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final SaveOptions.Builder builder = SaveOptions.newBuilder();
        builder.format();
        final SaveOptions s = builder.getOptions();
        r.save(bos, s.toOptionsMap());
        _xblockexpression = bos.toString();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
