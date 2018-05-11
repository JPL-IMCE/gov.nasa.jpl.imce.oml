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
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*
import org.eclipse.emf.ecore.util.EcoreUtil
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLAnnotationTest1b {

	@Inject
	ParseHelper<Extent> parseHelper

	@Inject 
	extension ValidationTestHelper
	
	@Test 
	def void test() {
		
		val input =
'''
annotationProperty rdfs:label=<http://www.w3.org/2000/01/rdf-schema#label>

open terminology <http://imce.jpl.nasa.gov/foundation/mission/mission>
{	
    
    @rdfs:label = """Performing Element
    This is a long description...
    </foo>
    
    "string"
     
    """
    concept PerformingElement

}
'''
		val result = parseHelper.parse(input)
		assertNotNull(result)
		result.assertNoErrors
		
		val r = result.eResource
		EcoreUtil.resolveAll(r)
		
		val tbox = result.modules.filter(TerminologyBox).head
		tbox.nsPrefix.assertEquals("mission")
		
		val ap = tbox.annotationProperties.head
		
		val c = tbox.boxStatements.filter(Concept).head
		c.name().assertEquals("PerformingElement")
		
		val a = c.annotations.head
		val a_prop = a.property
		val a_subj = a.subject
		val a_value = a.value.stringValue.value
		
		assertTrue(a_value.contains("Performing Element"))
		assertTrue(a_value.contains("</foo>"))
		assertTrue(a_value.contains("\"string\""))
		ap.assertSame(a_prop)
		c.assertSame(a_subj)
		
		System.out.println(this.class.name + " OK!")
	}

}
