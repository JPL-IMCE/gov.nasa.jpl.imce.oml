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
class OMLZip1Test extends OMLSaveLoadComparisonTest {
	
	static def Pair<URI,Extent>[] example1() {
        val extent = createExtent
        
        val tbox1 = createTerminologyGraph
        tbox1.extent = extent
        tbox1.iri = "http://test"
        
        val concept1 = createConcept
        concept1.name = "Concept1"
        concept1.tbox = tbox1
        
        val scalar1 = createScalar
        scalar1.name = "integer"
        scalar1.tbox = tbox1
        
        val scalarDP1 = createEntityScalarDataProperty
        scalarDP1.name = "p1"
        scalarDP1.domain = concept1
        scalarDP1.range = scalar1
        scalarDP1.tbox = tbox1
        scalarDP1.isIdentityCriteria = true
        
        val scalarDP2 = createEntityScalarDataProperty
        scalarDP2.name = "p2"
        scalarDP2.domain = concept1
        scalarDP2.range = scalar1
        scalarDP2.tbox = tbox1
        scalarDP2.isIdentityCriteria = false
        
        return #[ new Pair<URI,Extent>(URI.createURI(tbox1.iri()), extent) ]
	}
	
	@Test
	def void test1() {
		compareSavedAndLoaded(example1)
	}
	
	static def Pair<URI,Extent>[] example2() {
        val ext1 = createExtent
        
        val tbox1 = createTerminologyGraph
        tbox1.extent = ext1
        tbox1.iri = "http://test1"
        
        val concept1 = createConcept
        concept1.name = "Concept1"
        concept1.tbox = tbox1
         
        val ext2= createExtent
        
        val tbox2 = createTerminologyGraph
        tbox2.extent = ext2
        tbox2.iri = "http://test2"
        
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
        
        return #[ 
        	new Pair<URI,Extent>(URI.createURI(tbox1.iri()), ext1),
        	new Pair<URI,Extent>(URI.createURI(tbox2.iri()), ext2)
        ]
	}
	
	@Test
	def void test2() {
		compareSavedAndLoaded(example2)
	}
}