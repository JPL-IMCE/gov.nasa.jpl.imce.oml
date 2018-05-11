/*
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
package gov.nasa.jpl.imce.oml.dsl.tests

import gov.nasa.jpl.imce.oml.dsl.OMLStandaloneSetup
import gov.nasa.jpl.imce.oml.model.common.CommonFactory
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory
import java.io.ByteArrayOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.SaveOptions.Builder
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLFormattingTest1 {
	
	@Test
	def void test() {
        OMLStandaloneSetup.doSetup
        
        val omlCommonFactory = CommonFactory.eINSTANCE
        val omlTerminologiesFactory = TerminologiesFactory.eINSTANCE
        val omlGraphsFactory = GraphsFactory.eINSTANCE
        
        val extent1 = omlCommonFactory.createExtent
        
        val tbox1 = omlGraphsFactory.createTerminologyGraph
        tbox1.extent = extent1
        tbox1.iri = "http://test"
        
        val concept1 = omlTerminologiesFactory.createConcept
        concept1.name = "Concept1"
        concept1.tbox = tbox1
        
        val XtextResourceSet resourceSet = new XtextResourceSet()
        
        val res = resourceSet.createResource(URI.createURI("test.oml"))
        res.getContents().add(extent1)
        
		val ByteArrayOutputStream bos = new ByteArrayOutputStream()
		
		val Builder builder = SaveOptions.newBuilder()
		builder.format()

		val SaveOptions s = builder.getOptions()

		res.save(bos, s.toOptionsMap())
	}
}