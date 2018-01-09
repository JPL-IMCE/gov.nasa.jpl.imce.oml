/*
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
package gov.nasa.jpl.imce.oml.serialization.tests

import org.eclipse.emf.common.util.URI

import org.junit.Assert
import org.junit.Test
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runner.RunWith

import gov.nasa.jpl.imce.oml.model.common.Extent

@RunWith(BlockJUnit4ClassRunner)
class OMLZip3Test extends OMLSaveLoadComparisonTest {
	
	static def Pair<URI,Extent>[] example1() {
        val extent = createExtent
        
        val tbox1 = createTerminologyGraph
        tbox1.extent = extent
        tbox1.iri = "https://test"
        
        val concept1 = createConcept
        concept1.name = "Concept1"
        concept1.tbox = tbox1
        
        return #[ new Pair<URI,Extent>(URI.createURI(tbox1.iri()), extent) ]
	}
	
	@Test
	def void test1() {
	try {
		compareSavedAndLoaded(example1)
		Assert.fail("There should have been an exception!")
	} catch (IllegalArgumentException e) {
		Assert.assertEquals("No catalog mapping for URI: https://test", e.message)
	}
	
	}
	
}