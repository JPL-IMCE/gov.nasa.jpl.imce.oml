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
import gov.nasa.jpl.imce.oml.model.common.Extent
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLTerminologyGraph3Test{

	@Inject
	ParseHelper<Extent> parseHelper

	@Inject 
	extension ValidationTestHelper

	@Test 
	def void terminologyGraph3() {
		
		val result = parseHelper.parse(
'''
annotationProperty rdfs:label=<http://www.w3.org/2000/01/rdf-schema#label>

annotationProperty dc:description=<http://purl.org/dc/elements/1.1/#description>

open terminology <http://imce.jpl.nasa.gov/foundation/base/base> {

	aspect IdentifiedElement

}

open terminology <http://imce.jpl.nasa.gov/foundation/mission/mission> {

	extends <http://imce.jpl.nasa.gov/foundation/base/base>

 	@rdfs:label = "PerformingElement"
	aspect PerformingElement

	concept Component

	concept Function

	reifiedRelationship Performs {
		inverseFunctional
		asymmetric
		irreflexive
  		unreified=performs
  		inverse=isPerformedBy
  		source=Component
  		target=Function
 	}

}
''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		System.out.println(this.class.name + " OK!")
	}
	
}
