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
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedConcept;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictionKind;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import gov.nasa.jpl.imce.oml.serialization.tests.MixedOMLSaveLoadComparisonTest;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
@SuppressWarnings("all")
public class OMLZip6Test extends MixedOMLSaveLoadComparisonTest {
  public Pair<URI, Extent>[] example1() {
    final Extent ext1 = MixedOMLSaveLoadComparisonTest._commonFactory.createExtent();
    final TerminologyGraph tbox1 = MixedOMLSaveLoadComparisonTest._graphsFactory.createTerminologyGraph();
    tbox1.setExtent(ext1);
    tbox1.setIri(this.toAbsoluteTempHttpURI("test1.oml"));
    final Concept concept1 = MixedOMLSaveLoadComparisonTest._terminologiesFactory.createConcept();
    concept1.setName("Concept1");
    concept1.setTbox(tbox1);
    final Extent ext2 = MixedOMLSaveLoadComparisonTest._commonFactory.createExtent();
    final TerminologyGraph tbox2 = MixedOMLSaveLoadComparisonTest._graphsFactory.createTerminologyGraph();
    tbox2.setExtent(ext2);
    tbox2.setIri(this.toAbsoluteTempHttpURI("test2.omlzip"));
    final TerminologyExtensionAxiom tbox12 = MixedOMLSaveLoadComparisonTest._terminologiesFactory.createTerminologyExtensionAxiom();
    tbox12.setExtendedTerminology(tbox1);
    tbox12.setTbox(tbox2);
    final Concept concept2 = MixedOMLSaveLoadComparisonTest._terminologiesFactory.createConcept();
    concept2.setName("Concept2");
    concept2.setTbox(tbox2);
    final ConceptSpecializationAxiom concept12 = MixedOMLSaveLoadComparisonTest._terminologiesFactory.createConceptSpecializationAxiom();
    concept12.setTbox(tbox2);
    concept12.setSubConcept(concept2);
    concept12.setSuperConcept(concept1);
    final UnreifiedRelationship rel12 = MixedOMLSaveLoadComparisonTest._terminologiesFactory.createUnreifiedRelationship();
    rel12.setTbox(tbox2);
    rel12.setName("rel12");
    rel12.setSource(concept1);
    rel12.setTarget(concept2);
    final CardinalityRestrictedConcept concept3 = MixedOMLSaveLoadComparisonTest._terminologiesFactory.createCardinalityRestrictedConcept();
    concept3.setTbox(tbox2);
    concept3.setName("Concept3");
    concept3.setRestrictedRelationship(rel12);
    concept3.setRestrictedRange(concept2);
    concept3.setRestrictionKind(CardinalityRestrictionKind.MIN);
    PositiveIntegerValue _positiveIntegerValue = new PositiveIntegerValue("2");
    concept3.setRestrictedCardinality(_positiveIntegerValue);
    final URI uri1 = URI.createURI(tbox1.iri());
    final URI uri2 = URI.createURI(tbox2.iri());
    Pair<URI, Extent> _pair = new Pair<URI, Extent>(uri1, ext1);
    Pair<URI, Extent> _pair_1 = new Pair<URI, Extent>(uri2, ext2);
    return new Pair[] { _pair, _pair_1 };
  }
  
  @Test
  public void test1() {
    this.compareSavedAndLoaded(this.example1());
  }
}
