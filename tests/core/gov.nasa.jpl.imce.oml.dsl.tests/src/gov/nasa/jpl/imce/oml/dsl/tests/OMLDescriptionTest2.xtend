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
import gov.nasa.jpl.imce.oml.model.datatypes.FloatValue
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
import gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLDescriptionTest2 {
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	val commonF = CommonFactory.eINSTANCE
	val terminologiesF = TerminologiesFactory.eINSTANCE
	val graphsF = GraphsFactory.eINSTANCE
	val descriptionsF = DescriptionsFactory.eINSTANCE
	
	@Test
	def void test() {

		val rs = resourceSetProvider.get
		
		val r1 = rs.createResource(URI.createFileURI("file:OMLDescriptionTest2A.oml"))
		val Extent e1 = commonF.createExtent()
		r1.getContents.add(e1)

		val TerminologyGraph g = graphsF.createTerminologyGraph()
		g.extent = e1
		g.iri = "http://www.example.org/OMLDescriptionTest2A"

		val Concept c = terminologiesF.createConcept
		c.tbox = g
		c.name = "Box"
		
		val Scalar sc = terminologiesF.createScalar
		sc.tbox = g
		sc.name = "String"
		
		val StringScalarRestriction scr = terminologiesF.createStringScalarRestriction
		scr.tbox = g
		scr.name = "NonEmptyString"
		scr.restrictedRange = sc
		scr.minLength = new PositiveIntegerValue("1")
		
		val Scalar sc_double = terminologiesF.createScalar
		sc_double.tbox = g
		sc_double.name = "Double"
		
		val Scalar sc_boolean = terminologiesF.createScalar
		sc_boolean.tbox = g
		sc_boolean.name = "Boolean"
		
		val zero = commonF.createLiteralDecimal
		zero.decimal = new PositiveIntegerValue("0")
		
		val sc_positive_double = terminologiesF.createNumericScalarRestriction
		sc_positive_double.tbox = g
		sc_positive_double.name = "PositiveDouble"
		sc_positive_double.restrictedRange = sc_double
		sc_positive_double.minInclusive = zero
		
		val EntityScalarDataProperty dp1 = terminologiesF.createEntityScalarDataProperty
		dp1.tbox = g
		dp1.name = "name"
		dp1.domain = c
		dp1.range = sc
		
		val EntityScalarDataProperty dp2 = terminologiesF.createEntityScalarDataProperty
		dp2.tbox = g
		dp2.name = "length"
		dp2.domain = c
		dp2.range = sc_positive_double
		
		val EntityScalarDataProperty dp3 = terminologiesF.createEntityScalarDataProperty
		dp3.tbox = g
		dp3.name = "isSmall"
		dp3.domain = c
		dp3.range = sc_boolean
		
		val String text1 = serialize(r1)
		val String expected1 = '''
			open terminology <http://www.example.org/OMLDescriptionTest2A> {
			
				concept Box
			
				scalar String
			
				stringScalarRestriction NonEmptyString {
					minLength 1
					restrictedRange String
				}
			
				scalar Double
			
				scalar Boolean
			
				numericScalarRestriction PositiveDouble {
					minInclusive 0
					restrictedRange Double
				}
			
				entityScalarDataProperty name {
					domain Box
					range String
				}

				entityScalarDataProperty ^length {
					domain Box
					range PositiveDouble
				}
			
				entityScalarDataProperty isSmall {
					domain Box
					range Boolean
				}
			
			}
		'''
		
		assertEquals(text1, expected1)
		
		val r2 = rs.createResource(URI.createFileURI("file:OMLDescriptionTest2B.oml"))
		val Extent e2 = commonF.createExtent()
		r2.getContents.add(e2)
		
		val DescriptionBox db = descriptionsF.createDescriptionBox
		db.extent = e2
		db.iri = "http://www.example.org/OMLDescriptionTest2B"
		
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
		
		val ci_name_lit = commonF.createLiteralQuotedString
		ci_name_lit.string = new QuotedStringValue('box #0')
		
		ci_name.valueType = scr
		ci_name.scalarPropertyValue = ci_name_lit
		
		val SingletonInstanceScalarDataPropertyValue ci_length = descriptionsF.createSingletonInstanceScalarDataPropertyValue
		ci_length.descriptionBox = db
		ci_length.scalarDataProperty = dp2
		ci_length.singletonInstance = ci
		
		val ci_length_lit = commonF.createLiteralFloat
		ci_length_lit.^float = new FloatValue('123.45')
		
		ci_length.scalarPropertyValue = ci_length_lit
		ci_length.valueType = sc_positive_double
		
		val SingletonInstanceScalarDataPropertyValue ci_isSmall = descriptionsF.createSingletonInstanceScalarDataPropertyValue
		ci_isSmall.descriptionBox = db
		ci_isSmall.scalarDataProperty = dp3
		ci_isSmall.singletonInstance = ci
		
		val ci_isSmall_lit = commonF.createLiteralBoolean
		ci_isSmall_lit.value = false
		ci_isSmall.scalarPropertyValue = ci_isSmall_lit
		
		val String text2 = serialize(r2)
		val String expected2 =
		'''
		final descriptionBox <http://www.example.org/OMLDescriptionTest2B> {
		
			extends <http://www.example.org/OMLDescriptionTest2A>
		
			conceptInstance(boite0 is-a OMLDescriptionTest2A:Box)
		
			boite0 . OMLDescriptionTest2A:name = "box #0" ^^ OMLDescriptionTest2A:NonEmptyString
		
			boite0 . OMLDescriptionTest2A:length = 123.45 ^^ OMLDescriptionTest2A:PositiveDouble
		
			boite0 . OMLDescriptionTest2A:isSmall = false
		
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