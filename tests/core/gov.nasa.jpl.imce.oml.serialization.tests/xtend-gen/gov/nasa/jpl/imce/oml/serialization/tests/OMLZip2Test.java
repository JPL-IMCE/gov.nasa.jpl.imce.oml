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
import gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString;
import gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.serialization.tests.OMLSaveLoadComparisonTest;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
@SuppressWarnings("all")
public class OMLZip2Test extends OMLSaveLoadComparisonTest {
  public static Pair<URI, Extent>[] example1() {
    final Extent extent = OMLSaveLoadComparisonTest._commonFactory.createExtent();
    final TerminologyGraph tbox1 = OMLSaveLoadComparisonTest._graphsFactory.createTerminologyGraph();
    tbox1.setExtent(extent);
    tbox1.setIri("http://test");
    final Scalar s1 = OMLSaveLoadComparisonTest._terminologiesFactory.createScalar();
    s1.setTbox(tbox1);
    s1.setName("string");
    final ScalarOneOfRestriction s2 = OMLSaveLoadComparisonTest._terminologiesFactory.createScalarOneOfRestriction();
    s2.setTbox(tbox1);
    s2.setName("OnOff");
    s2.setRestrictedRange(s1);
    final ScalarOneOfLiteralAxiom on = OMLSaveLoadComparisonTest._terminologiesFactory.createScalarOneOfLiteralAxiom();
    on.setTbox(tbox1);
    on.setAxiom(s2);
    on.setValueType(s2);
    final LiteralQuotedString onValue = OMLSaveLoadComparisonTest._commonFactory.createLiteralQuotedString();
    QuotedStringValue _quotedStringValue = new QuotedStringValue("On");
    onValue.setString(_quotedStringValue);
    on.setValue(onValue);
    final ScalarOneOfLiteralAxiom off = OMLSaveLoadComparisonTest._terminologiesFactory.createScalarOneOfLiteralAxiom();
    off.setTbox(tbox1);
    off.setAxiom(s2);
    final LiteralQuotedString offValue = OMLSaveLoadComparisonTest._commonFactory.createLiteralQuotedString();
    QuotedStringValue _quotedStringValue_1 = new QuotedStringValue("Off");
    offValue.setString(_quotedStringValue_1);
    off.setValue(offValue);
    URI _createURI = URI.createURI(tbox1.iri());
    Pair<URI, Extent> _pair = new Pair<URI, Extent>(_createURI, extent);
    return new Pair[] { _pair };
  }
  
  @Test
  public void test1() {
    this.compareSavedAndLoaded(OMLZip2Test.example1());
  }
}
