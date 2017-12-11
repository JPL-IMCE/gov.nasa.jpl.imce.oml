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
package gov.nasa.jpl.imce.oml.serialization.tests;

import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.serialization.tests.OMLSaveLoadComparisonTest;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
@SuppressWarnings("all")
public class OMLZip1Test extends OMLSaveLoadComparisonTest {
  public static Pair<URI, Extent>[] example1() {
    final Extent extent = OMLSaveLoadComparisonTest._commonFactory.createExtent();
    final TerminologyGraph tbox1 = OMLSaveLoadComparisonTest._graphsFactory.createTerminologyGraph();
    tbox1.setExtent(extent);
    tbox1.setIri("http://test");
    final Concept concept1 = OMLSaveLoadComparisonTest._terminologiesFactory.createConcept();
    concept1.setName("Concept1");
    concept1.setTbox(tbox1);
    URI _createURI = URI.createURI(tbox1.iri());
    Pair<URI, Extent> _pair = new Pair<URI, Extent>(_createURI, extent);
    return new Pair[] { _pair };
  }
  
  @Test
  public void test1() {
    this.compareSavedAndLoaded(OMLZip1Test.example1());
  }
  
  public static Pair<URI, Extent>[] example2() {
    final Extent ext1 = OMLSaveLoadComparisonTest._commonFactory.createExtent();
    final TerminologyGraph tbox1 = OMLSaveLoadComparisonTest._graphsFactory.createTerminologyGraph();
    tbox1.setExtent(ext1);
    tbox1.setIri("http://test1");
    final Concept concept1 = OMLSaveLoadComparisonTest._terminologiesFactory.createConcept();
    concept1.setName("Concept1");
    concept1.setTbox(tbox1);
    final Extent ext2 = OMLSaveLoadComparisonTest._commonFactory.createExtent();
    final TerminologyGraph tbox2 = OMLSaveLoadComparisonTest._graphsFactory.createTerminologyGraph();
    tbox2.setExtent(ext2);
    tbox2.setIri("http://test2");
    final TerminologyExtensionAxiom tbox12 = OMLSaveLoadComparisonTest._terminologiesFactory.createTerminologyExtensionAxiom();
    tbox12.setExtendedTerminology(tbox1);
    tbox12.setTbox(tbox2);
    final Concept concept2 = OMLSaveLoadComparisonTest._terminologiesFactory.createConcept();
    concept2.setName("Concept2");
    concept2.setTbox(tbox2);
    final ConceptSpecializationAxiom concept12 = OMLSaveLoadComparisonTest._terminologiesFactory.createConceptSpecializationAxiom();
    concept12.setTbox(tbox2);
    concept12.setSubConcept(concept2);
    concept12.setSuperConcept(concept1);
    URI _createURI = URI.createURI(tbox1.iri());
    Pair<URI, Extent> _pair = new Pair<URI, Extent>(_createURI, ext1);
    URI _createURI_1 = URI.createURI(tbox2.iri());
    Pair<URI, Extent> _pair_1 = new Pair<URI, Extent>(_createURI_1, ext2);
    return new Pair[] { _pair, _pair_1 };
  }
  
  @Test
  public void test2() {
    this.compareSavedAndLoaded(OMLZip1Test.example2());
  }
}
