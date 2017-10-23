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
import gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue
import gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLAnnotationTest3b {

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	val commonF = CommonFactory.eINSTANCE
	val terminologiesF = TerminologiesFactory.eINSTANCE
	val graphsF = GraphsFactory.eINSTANCE

	@Test
	def void test() {

		val rs = resourceSetProvider.get
		val r = rs.createResource(URI.createFileURI("file:OMLAnnoationTest3.oml"))

		val Extent e = commonF.createExtent()
		r.getContents.add(e)

		val AnnotationProperty ap1 = commonF.createAnnotationProperty
		ap1.extent = e
		ap1.abbrevIRI = "test:doc1"
		ap1.iri = "http://www.example.org/OMLAnnotationTest3#doc1"

		val AnnotationProperty ap2 = commonF.createAnnotationProperty
		ap2.extent = e
		ap2.abbrevIRI = "test:doc2"
		ap2.iri = "http://www.example.org/OMLAnnotationTest3#doc2"

		val TerminologyGraph g = graphsF.createTerminologyGraph()
		e.getModules.add(g)
		g.setIri("http://www.example.org/OMLAnnotationTest3")
		addRawAnnotation(g, ap1, '''Un graphe...
    Ceci est une description tres longue...
    </foo>
    
    "string"
    
    ''')
		addQuotedAnnotation(g, ap2, "A graph...")

		val Concept c = terminologiesF.createConcept
		c.tbox = g
		c.name = "Box"
		addQuotedAnnotation(c, ap1, "Une boite...")
		addQuotedAnnotation(c, ap2, "A box...")

		val ByteArrayOutputStream bos = new ByteArrayOutputStream()
		val Builder builder = SaveOptions.newBuilder()
		builder.format()
		val SaveOptions s = builder.getOptions();
		r.save(bos, s.toOptionsMap());
		val String text = bos.toString
		
		val String expected = '''
			annotationProperty test:doc1=<http://www.example.org/OMLAnnotationTest3#doc1>
			
			annotationProperty test:doc2=<http://www.example.org/OMLAnnotationTest3#doc2>
			
			@test:doc1="""Un graphe...
			    Ceci est une description tres longue...
			    </foo>
			    
			    "string"
			    
			"""
			@test:doc2="A graph..."
			open terminology <http://www.example.org/OMLAnnotationTest3> {
			
				@test:doc1="Une boite..."
				@test:doc2="A box..."
				concept Box
			
			}
		'''

		assertEquals(text, expected)
	}

	def void addQuotedAnnotation(Element e, AnnotationProperty ap, String v) {
		val AnnotationPropertyValue av = commonF.createAnnotationPropertyValue
		e.annotations += av
		av.property = ap
		val s = commonF.createLiteralQuotedString()
		s.string = new QuotedStringValue(v)
		av.value = s
	}
	
	
	def void addRawAnnotation(Element e, AnnotationProperty ap, String v) {
		val AnnotationPropertyValue av = commonF.createAnnotationPropertyValue
		e.annotations += av
		av.property = ap
		val s = commonF.createLiteralRawString()
		s.string = new RawStringValue(v)
		av.value = s
	}
}
