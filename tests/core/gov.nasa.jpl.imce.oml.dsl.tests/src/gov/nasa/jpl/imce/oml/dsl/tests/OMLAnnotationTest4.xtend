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
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
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

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLAnnotationTest4 {

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	val commonF = CommonFactory.eINSTANCE
	val terminologiesF = TerminologiesFactory.eINSTANCE
	val graphsF = GraphsFactory.eINSTANCE

	@Test
	def void test() {

		val rs = resourceSetProvider.get
		val r = rs.createResource(URI.createFileURI("file:OMLAnnoationTest4.oml"))

		val Extent e = commonF.createExtent()
		r.getContents.add(e)

		val AnnotationProperty ap1 = commonF.createAnnotationProperty
		ap1.extent = e
		ap1.abbrevIRI = "test:doc1"
		ap1.iri = "http://www.example.org/OMLAnnotationTest4#doc1"

		val AnnotationProperty ap2 = commonF.createAnnotationProperty
		ap2.extent = e
		ap2.abbrevIRI = "test:doc2"
		ap2.iri = "http://www.example.org/OMLAnnotationTest4#doc2"

		val TerminologyGraph g = graphsF.createTerminologyGraph()
		e.getModules.add(g)
		g.setIri("http://www.example.org/OMLAnnotationTest4")
		addAnnotation(g, ap1, "Un graphe...")
		addAnnotation(g, ap2, "A graph...")

		val Concept c1 = terminologiesF.createConcept
		c1.tbox = g
		c1.name = "Box1"
		addAnnotation(c1, ap1, "12341234-1234-1234-1234-123412341234")

		val Concept c2 = terminologiesF.createConcept
		c2.tbox = g
		c2.name = "Box2"
		addAnnotation(c2, ap1, "http://example.org")

		val _string_ = terminologiesF.createScalar
		_string_.tbox = g
		_string_.name = "String"
		addAnnotation(_string_, ap1, "java.lang.String")
		
		val ByteArrayOutputStream bos = new ByteArrayOutputStream()
		val Builder builder = SaveOptions.newBuilder()
		builder.format()
		val SaveOptions s = builder.getOptions();
		r.save(bos, s.toOptionsMap());
		val String text = bos.toString
		
		val String expected = '''
			annotationProperty test:doc1=<http://www.example.org/OMLAnnotationTest4#doc1>
			
			annotationProperty test:doc2=<http://www.example.org/OMLAnnotationTest4#doc2>
			
			@test:doc1="Un graphe..."
			@test:doc2="A graph..."
			open terminology <http://www.example.org/OMLAnnotationTest4> {
			
				@test:doc1="12341234-1234-1234-1234-123412341234"
				concept Box1
			
				@test:doc1="http://example.org"
				concept Box2
			
				@test:doc1="java.lang.String"
				scalar String
			
			}
		'''

		assertEquals(text, expected)
	}

	def void addAnnotation(Element e, AnnotationProperty ap, String v) {
		val AnnotationPropertyValue av = commonF.createAnnotationPropertyValue
		e.annotations += av
		av.property = ap
		av.value = v
	}
}
