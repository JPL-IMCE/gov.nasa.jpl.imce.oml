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
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.common.Extent
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*
import org.eclipse.emf.ecore.util.EcoreUtil
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLTerminologyGraph1Test{

	@Inject
	ParseHelper<Extent> parseHelper

	@Test 
	def void terminologyGraph1() {
		
		val result = parseHelper.parse(
'''
annotationProperty rdfs:label=<http://www.w3.org/2000/01/rdf-schema#label>
annotationProperty 1.1:title=<http://purl.org/dc/elements/1.1/title>
annotationProperty owl2-mof2:hasBinaryDependencySource=<http://imce.jpl.nasa.gov/foundation/owl2-mof2/owl2-mof2#hasBinaryDependencySource>

open terminology <http://imce.jpl.nasa.gov/foundation/mission/mission>
{

	@rdfs:label = "Performing Element"
	@rdfs:label = "A performing element"
	@1.1:title = "Performing Element"
	concept PerformingElement

	concept Foo-Bar
	
	scalar decimal
	
	stringScalarRestriction integer {
		maxLength 10
		pattern /[\\\\-+]?[0-9]+/
		restrictedRange decimal
	}
	
	numericScalarRestriction XSDlong {
		minInclusive -9223372036854775808
		maxInclusive 9223372036854775807
		restrictedRange decimal
	}
}

open terminology <http://purl.org/dc/elements/1.1/> {
	
	concept Foo
}

open terminology <http://example.org> {
	
	extends <http://purl.org/dc/elements/1.1/>

	concept Bar
	
	Bar extendsConcept 1.1:Foo
	
}

''')
		assertNotNull(result)
		val errors = result.eResource.errors
		assertTrue(errors.empty)
		
		val r = result.eResource
		EcoreUtil.resolveAll(r)
		
		val ap = result.annotationProperties.head
		
		val tbox = result.modules.filter(TerminologyBox).head
		tbox.nsPrefix.assertEquals("mission")
		
		val c = tbox.boxStatements.filter(Concept).head
		c.name().assertEquals("PerformingElement")
		
		val a = c.annotations.head
		val a_prop = a.property
		val a_subj = a.subject
		val a_value = a.value
		
		"Performing Element".assertEquals(a_value.value.value)
		ap.assertSame(a_prop)
		c.assertSame(a_subj)
		
		System.out.println(this.class.name + " OK!")
	}

}
