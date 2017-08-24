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
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.CommonFactory
import gov.nasa.jpl.imce.oml.model.common.Element
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar
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

import static org.junit.Assert.*
import org.eclipse.emf.ecore.resource.Resource

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLDescriptionTest1 {
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	val commonF = CommonFactory.eINSTANCE
	val terminologiesF = TerminologiesFactory.eINSTANCE
	val graphsF = GraphsFactory.eINSTANCE

	@Test
	def void test() {

		val rs = resourceSetProvider.get
		val r1 = rs.createResource(URI.createFileURI("file:OMLAnnoationTest2.oml"))

		val Extent e = commonF.createExtent()
		r1.getContents.add(e)

		val AnnotationProperty ap1 = commonF.createAnnotationProperty
		ap1.extent = e
		ap1.abbrevIRI = "test:doc1"
		ap1.iri = "http://www.example.org/OMLAnnotationTest2#doc1"

		val AnnotationProperty ap2 = commonF.createAnnotationProperty
		ap2.extent = e
		ap2.abbrevIRI = "test:doc2"
		ap2.iri = "http://www.example.org/OMLAnnotationTest2#doc2"

		val TerminologyGraph g = graphsF.createTerminologyGraph()
		e.getModules.add(g)
		g.setIri("http://www.example.org/OMLAnnotationTest2")
		addAnnotation(g, ap1, "Un graphe...")
		addAnnotation(g, ap2, "A graph...")

		val Concept c = terminologiesF.createConcept
		c.tbox = g
		c.name = "Box"
		addAnnotation(c, ap1, "Une boite...")
		addAnnotation(c, ap2, "A box...")
		
		val Scalar sc = terminologiesF.createScalar
		sc.tbox = g
		sc.name = "String"
		
		val EntityScalarDataProperty dp = terminologiesF.createEntityScalarDataProperty
		dp.tbox = g
		dp.name = "name"
		dp.domain = c
		dp.range = sc
		
		val String text1 = serialize(r1)
		
		
		val String expected = '''
			annotationProperty test:doc1=<http://www.example.org/OMLAnnotationTest2#doc1>
			
			annotationProperty test:doc2=<http://www.example.org/OMLAnnotationTest2#doc2>
			
			@test:doc1="Un graphe..."
			@test:doc2="A graph..."
			open terminology <http://www.example.org/OMLAnnotationTest2> {
			
				@test:doc1="Une boite..."
				@test:doc2="A box..."
				concept Box
			
				scalar String
			
				entityScalarDataProperty name {
					domain Box
					range String
				}
			
			}
		'''

		assertEquals(text1, expected)
	}

	def void addAnnotation(Element e, AnnotationProperty ap, String v) {
		val AnnotationPropertyValue av = commonF.createAnnotationPropertyValue
		e.annotations += av
		av.property = ap
		av.value = v
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