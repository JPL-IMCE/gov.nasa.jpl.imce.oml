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

import com.google.inject.Inject
import com.google.inject.Provider
import gov.nasa.jpl.imce.oml.model.common.CommonFactory
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializedReifiedRelationship
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

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLSpecializedReifiedRelationshipTest1 {
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	val commonF = CommonFactory.eINSTANCE
	val terminologiesF = TerminologiesFactory.eINSTANCE
	val graphsF = GraphsFactory.eINSTANCE
	
	@Test
	def void test() {

		val rs = resourceSetProvider.get
		
		val r1 = rs.createResource(URI.createFileURI("file:OMLSpecializedReifiedRelationshipTest1.oml"))
		val Extent e1 = commonF.createExtent()
		r1.getContents.add(e1)

		val TerminologyGraph g = graphsF.createTerminologyGraph()
		g.extent = e1
		g.iri = "http://www.example.org/OMLSpecializedReifiedRelationshipTest1"

		val Concept c1 = terminologiesF.createConcept
		c1.tbox = g
		c1.name = "A"
		
		val Aspect c2 = terminologiesF.createAspect
		c2.tbox = g
		c2.name = "B"
		
		val Concept c3 = terminologiesF.createConcept
		c3.tbox = g
		c3.name = "C"
		
		val Concept c4 = terminologiesF.createConcept
		c4.tbox = g
		c4.name = "D"
		
		val c3_extends_c1 = terminologiesF.createConceptSpecializationAxiom
		c3_extends_c1.tbox = g
		c3_extends_c1.subConcept = c3
		c3_extends_c1.superConcept = c1
		
		val c4_extends_c2 = terminologiesF.createAspectSpecializationAxiom
		c4_extends_c2.tbox = g
		c4_extends_c2.subEntity = c4
		c4_extends_c2.superAspect = c2
		
		val ReifiedRelationship rr = terminologiesF.createReifiedRelationship
		rr.tbox = g
		rr.name = "R"
		rr.source = c1
		rr.target = c2
		
		val rrf = terminologiesF.createForwardProperty
		rrf.reifiedRelationship = rr
		rrf.name = "r"
		
		val SpecializedReifiedRelationship sr1 = terminologiesF.createSpecializedReifiedRelationship
		sr1.tbox = g
		sr1.name = "R1"
		sr1.source = c3
		sr1.target = c2
		sr1.general = rr
		
		val SpecializedReifiedRelationship sr2 = terminologiesF.createSpecializedReifiedRelationship
		sr2.tbox = g
		sr2.name = "R2"
		sr2.source = c3
		sr2.target = c4
		sr2.general = sr1
		
		OMLExtensions.normalize(e1)
		
		val String text1 = serialize(r1)
		val String expected1 = '''
		open terminology <http://www.example.org/OMLSpecializedReifiedRelationshipTest1> {
		
			aspect B
		
			concept A
		
			concept C
		
			concept D
		
			C extendsConcept A
		
			reifiedRelationship R {
				unreified = r
				source = A
				target = B }
		
			reifiedRelationship R1 extends R {
				source = C
				target = B }
		
			reifiedRelationship R2 extends R1 {
				source = C
				target = D }
		
			D extendsAspect B
		
		}
		'''
		
		assertEquals(text1, expected1)
		
	}
	
	def String serialize(Resource r) {
		val ByteArrayOutputStream bos = new ByteArrayOutputStream()
		val Builder builder = SaveOptions.newBuilder()
		builder.format()
		val SaveOptions s = builder.getOptions();
		r.save(bos, s.toOptionsMap());
		bos.toString
	}
}