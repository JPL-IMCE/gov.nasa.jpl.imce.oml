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

import gov.nasa.jpl.imce.oml.dsl.OMLStandaloneSetup;
import gov.nasa.jpl.imce.oml.dsl.tests.OMLInjectorProvider;
import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import java.io.ByteArrayOutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
public class OMLFormattingTest1 {
  @Test
  public void test() {
    try {
      OMLStandaloneSetup.doSetup();
      final CommonFactory omlCommonFactory = CommonFactory.eINSTANCE;
      final TerminologiesFactory omlTerminologiesFactory = TerminologiesFactory.eINSTANCE;
      final GraphsFactory omlGraphsFactory = GraphsFactory.eINSTANCE;
      final Extent extent1 = omlCommonFactory.createExtent();
      final TerminologyGraph tbox1 = omlGraphsFactory.createTerminologyGraph();
      tbox1.setExtent(extent1);
      tbox1.setIri("http://test");
      final Concept concept1 = omlTerminologiesFactory.createConcept();
      concept1.setName("Concept1");
      concept1.setTbox(tbox1);
      final XtextResourceSet resourceSet = new XtextResourceSet();
      final Resource res = resourceSet.createResource(URI.createURI("test.oml"));
      res.getContents().add(extent1);
      final ByteArrayOutputStream bos = new ByteArrayOutputStream();
      final SaveOptions.Builder builder = SaveOptions.newBuilder();
      builder.format();
      final SaveOptions s = builder.getOptions();
      res.save(bos, s.toOptionsMap());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
