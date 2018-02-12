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
import gov.nasa.jpl.imce.oml.serialization.tests.OMLSaveLoadComparisonTest;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
@SuppressWarnings("all")
public class OMLZip3Test extends OMLSaveLoadComparisonTest {
  public static Pair<URI, Extent>[] example1() {
    final Extent extent = OMLSaveLoadComparisonTest._commonFactory.createExtent();
    final TerminologyGraph tbox1 = OMLSaveLoadComparisonTest._graphsFactory.createTerminologyGraph();
    tbox1.setExtent(extent);
    tbox1.setIri("https://test");
    final Concept concept1 = OMLSaveLoadComparisonTest._terminologiesFactory.createConcept();
    concept1.setName("Concept1");
    concept1.setTbox(tbox1);
    URI _createURI = URI.createURI(tbox1.iri());
    Pair<URI, Extent> _pair = new Pair<URI, Extent>(_createURI, extent);
    return new Pair[] { _pair };
  }
  
  @Test
  public void test1() {
    try {
      this.compareSavedAndLoaded(OMLZip3Test.example1());
      Assert.fail("There should have been an exception!");
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
        Assert.assertEquals("No parent URIConverter and no catalog mapping for URI: https://test", e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
