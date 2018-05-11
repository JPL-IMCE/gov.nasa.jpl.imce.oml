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
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
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
public class OMLFormattingTest4 {
  @Test
  public void test() {
    try {
      OMLStandaloneSetup.doSetup();
      final CommonFactory omlCommonFactory = CommonFactory.eINSTANCE;
      final TerminologiesFactory omlTerminologiesFactory = TerminologiesFactory.eINSTANCE;
      final GraphsFactory omlGraphsFactory = GraphsFactory.eINSTANCE;
      final Extent extent1 = omlCommonFactory.createExtent();
      final Extent extent2 = omlCommonFactory.createExtent();
      final TerminologyGraph tbox1 = omlGraphsFactory.createTerminologyGraph();
      tbox1.setExtent(extent1);
      tbox1.setIri("http://test");
      final Concept concept1 = omlTerminologiesFactory.createConcept();
      concept1.setName("Concept1");
      concept1.setTbox(tbox1);
      final TerminologyGraph tbox2 = omlGraphsFactory.createTerminologyGraph();
      tbox2.setExtent(extent2);
      tbox2.setIri("http://test2");
      final TerminologyExtensionAxiom terminologyExtension1 = omlTerminologiesFactory.createTerminologyExtensionAxiom();
      terminologyExtension1.setExtendedTerminology(tbox1);
      terminologyExtension1.setTbox(tbox2);
      final Concept concept2 = omlTerminologiesFactory.createConcept();
      concept2.setName("Concept2");
      concept2.setTbox(tbox2);
      final ConceptSpecializationAxiom concept2Extends = omlTerminologiesFactory.createConceptSpecializationAxiom();
      concept2Extends.setSuperConcept(concept1);
      concept2Extends.setSubConcept(concept2);
      concept2Extends.setTbox(tbox2);
      final XtextResourceSet resourceSet = new XtextResourceSet();
      final Resource res = resourceSet.createResource(URI.createURI("target/oml/test.oml"));
      res.getContents().add(extent1);
      res.save(Collections.EMPTY_MAP);
      final Resource res2 = resourceSet.createResource(URI.createURI("target/oml/test2.oml"));
      res2.getContents().add(extent2);
      res2.save(Collections.EMPTY_MAP);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void save(final Resource r) {
    try {
      final ByteArrayOutputStream bos = new ByteArrayOutputStream();
      final SaveOptions.Builder builder = SaveOptions.newBuilder();
      builder.format();
      final SaveOptions s = builder.getOptions();
      r.save(bos, s.toOptionsMap());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
