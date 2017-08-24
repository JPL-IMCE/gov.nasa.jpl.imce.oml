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
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
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
	val descriptionsF = DescriptionsFactory.eINSTANCE
	
	@Test
	def void test() {

		val rs = resourceSetProvider.get
		
		val r1 = rs.createResource(URI.createFileURI("file:OMLDescriptionTest1A.oml"))
		val Extent e1 = commonF.createExtent()
		r1.getContents.add(e1)

		val TerminologyGraph g = graphsF.createTerminologyGraph()
		g.extent = e1
		g.iri = "http://www.example.org/OMLDescriptionTest1A"

		val Concept c = terminologiesF.createConcept
		c.tbox = g
		c.name = "Box"
		
		val Scalar sc = terminologiesF.createScalar
		sc.tbox = g
		sc.name = "String"
		
		val Scalar sc_double = terminologiesF.createScalar
		sc_double.tbox = g
		sc_double.name = "Double"
		
		val EntityScalarDataProperty dp1 = terminologiesF.createEntityScalarDataProperty
		dp1.tbox = g
		dp1.name = "name"
		dp1.domain = c
		dp1.range = sc
		
		val EntityScalarDataProperty dp2 = terminologiesF.createEntityScalarDataProperty
		dp2.tbox = g
		dp2.name = "length"
		dp2.domain = c
		dp2.range = sc_double
		
		val String text1 = serialize(r1)
		val String expected1 = '''
			open terminology <http://www.example.org/OMLDescriptionTest1A> {
			
				concept Box
			
				scalar String
			
				scalar Double
			
				entityScalarDataProperty name {
					domain Box
					range String
				}

				entityScalarDataProperty ^length {
					domain Box
					range Double
				}
			
			}
		'''
		
		assertEquals(text1, expected1)
		
		val r2 = rs.createResource(URI.createFileURI("file:OMLDescriptionTest1B.oml"))
		val Extent e2 = commonF.createExtent()
		r2.getContents.add(e2)
		
		val DescriptionBox db = descriptionsF.createDescriptionBox
		db.extent = e2
		db.iri = "http://www.example.org/OMLDescriptionTest1B"
		
		val DescriptionBoxExtendsClosedWorldDefinitions ext = descriptionsF.createDescriptionBoxExtendsClosedWorldDefinitions
		ext.descriptionBox = db
		ext.closedWorldDefinitions = g
		
		val ConceptInstance ci = descriptionsF.createConceptInstance
		ci.descriptionBox = db
		ci.name = "boite0"
		ci.singletonConceptClassifier = c
		
		val SingletonInstanceScalarDataPropertyValue ci_name = descriptionsF.createSingletonInstanceScalarDataPropertyValue
		ci_name.descriptionBox = db
		ci_name.scalarDataProperty = dp1
		ci_name.singletonInstance = ci
		
		val ci_name_lit = commonF.createLiteralString
		ci_name_lit.value = 'box #0'
		ci_name.scalarPropertyValue = ci_name_lit
		
		val SingletonInstanceScalarDataPropertyValue ci_length = descriptionsF.createSingletonInstanceScalarDataPropertyValue
		ci_length.descriptionBox = db
		ci_length.scalarDataProperty = dp2
		ci_length.singletonInstance = ci
		
		val ci_length_lit = commonF.createLiteralNumber
		ci_length_lit.value = '123.45'
		ci_length.scalarPropertyValue = ci_length_lit
		
		val String text2 = serialize(r2)
		val String expected2 =
		'''
		final descriptionBox <http://www.example.org/OMLDescriptionTest1B> {
		
			extends <http://www.example.org/OMLDescriptionTest1A>
		
			conceptInstance(boite0 is-a OMLDescriptionTest1A:Box)
		
			boite0 . OMLDescriptionTest1A:name = "box #0"
		
			boite0 . OMLDescriptionTest1A:length = 123.45
		
		}
		'''
		
		assertEquals(text2, expected2)
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