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

import org.junit.Test
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runner.RunWith

import gov.nasa.jpl.imce.oml.model.common.Extent

@RunWith(BlockJUnit4ClassRunner)
class OMLZip4Test extends MixedOMLSaveLoadComparisonTest {
	
	def Pair<URI,Extent>[] example1() {
        val ext1 = createExtent
        
        val tbox1 = createTerminologyGraph
        tbox1.extent = ext1
        tbox1.iri = toAbsoluteTempFileURI("test1.oml")
        
        val concept1 = createConcept
        concept1.name = "Concept1"
        concept1.tbox = tbox1
         
        val ext2= createExtent
        
        val tbox2 = createTerminologyGraph
        tbox2.extent = ext2
        tbox2.iri = toAbsoluteTempFileURI("test2.omlzip")
        
        val tbox12 = createTerminologyExtensionAxiom
        tbox12.extendedTerminology = tbox1
        tbox12.tbox = tbox2
        
        val concept2 = createConcept
        concept2.name = "Concept2"
        concept2.tbox = tbox2
        
        val concept12 = createConceptSpecializationAxiom
        concept12.tbox = tbox2
        concept12.subConcept = concept2
        concept12.superConcept = concept1
        
        val uri1 = URI.createURI(tbox1.iri())
        val uri2 = URI.createURI(tbox2.iri())
        return #[ 
        	new Pair<URI,Extent>(uri1, ext1),
        	new Pair<URI,Extent>(uri2, ext2)
        ]
	}
	
	@Test
	def void test1() {
		compareSavedAndLoaded(example1)
	}
}