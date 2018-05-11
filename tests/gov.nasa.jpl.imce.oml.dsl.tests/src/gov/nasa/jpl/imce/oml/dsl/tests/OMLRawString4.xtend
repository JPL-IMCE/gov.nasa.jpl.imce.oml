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
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.common.LogicalElement
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
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
class OMLRawString4 {

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	val commonF = CommonFactory.eINSTANCE
	val graphsF = GraphsFactory.eINSTANCE

	@Test
	def void test() {

		val rs = resourceSetProvider.get
		val r = rs.createResource(URI.createFileURI("file:OMLRawString.oml"))

		val Extent e = commonF.createExtent()
		r.getContents.add(e)

		val TerminologyGraph g = graphsF.createTerminologyGraph()
		e.getModules.add(g)
		g.setIri("http://www.example.org/OMLRawString")
		
		val AnnotationProperty ap1 = commonF.createAnnotationProperty
		ap1.module = g
		ap1.abbrevIRI = "test:doc1"
		ap1.iri = "http://www.example.org/OMLRawString#doc1"

		val AnnotationProperty ap2 = commonF.createAnnotationProperty
		ap2.module = g
		ap2.abbrevIRI = "test:doc2"
		ap2.iri = "http://www.example.org/OMLRawString#doc2"

		addAnnotation(g, ap1, '''Latch Valve: "LP - 3/8" other''')

		val ByteArrayOutputStream bos = new ByteArrayOutputStream()
		val Builder builder = SaveOptions.newBuilder()
		builder.format()
		val SaveOptions s = builder.getOptions();
		r.save(bos, s.toOptionsMap());
	}	
	
	def void addAnnotation(LogicalElement e, AnnotationProperty ap, String v) {
		val AnnotationPropertyValue av = commonF.createAnnotationPropertyValue
		e.annotations += av
		av.property = ap
		val s = commonF.createLiteralRawString()
		s.string = new RawStringValue(v)
		av.value = s
	}
}