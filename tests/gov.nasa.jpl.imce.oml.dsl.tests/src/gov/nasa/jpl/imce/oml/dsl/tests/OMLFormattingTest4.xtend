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
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.SaveOptions.Builder
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Collections

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLFormattingTest4 {

	@Test
	def void test() {
		OMLStandaloneSetup.doSetup

		val omlCommonFactory = CommonFactory.eINSTANCE
		val omlTerminologiesFactory = TerminologiesFactory.eINSTANCE
		val omlGraphsFactory = GraphsFactory.eINSTANCE

		val extent1 = omlCommonFactory.createExtent
		val extent2 = omlCommonFactory.createExtent

		/** TBOX 1 */
		val tbox1 = omlGraphsFactory.createTerminologyGraph
		tbox1.extent = extent1
		tbox1.iri = "http://test"

		val concept1 = omlTerminologiesFactory.createConcept
		concept1.name = "Concept1"
		concept1.tbox = tbox1

		/** TBOX 2 */
		val tbox2 = omlGraphsFactory.createTerminologyGraph
		tbox2.extent = extent2
		tbox2.iri = "http://test2"

		val terminologyExtension1 = omlTerminologiesFactory.createTerminologyExtensionAxiom
		terminologyExtension1.extendedTerminology = tbox1
		terminologyExtension1.tbox = tbox2

		val concept2 = omlTerminologiesFactory.createConcept
		concept2.name = "Concept2"
		concept2.tbox = tbox2

		val concept2Extends = omlTerminologiesFactory.createConceptSpecializationAxiom
		concept2Extends.superConcept = concept1
		concept2Extends.subConcept = concept2
		concept2Extends.tbox = tbox2

		val resourceSet = new XtextResourceSet()

		val res = resourceSet.createResource(URI.createURI("target/oml/test.oml"))
		res.getContents().add(extent1)
		res.save(Collections.EMPTY_MAP)

		val res2 = resourceSet.createResource(URI.createURI("target/oml/test2.oml"))
		res2.getContents().add(extent2)
		res2.save(Collections.EMPTY_MAP)

	}
	
	def void save(Resource r) {
		
		val ByteArrayOutputStream bos = new ByteArrayOutputStream()

		val Builder builder = SaveOptions.newBuilder()
		builder.format()

		val SaveOptions s = builder.getOptions()

		r.save(bos, s.toOptionsMap())
	}
}
