/*
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */
 package gov.nasa.jpl.imce.oml.dsl.tests

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.model.common.Extent
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLFileTests extends OMLTest {

//	@Inject
//	ParseHelper<Extent> parseHelper

	@Inject extension FormatterTestHelper

//	@Inject 
//	extension ValidationTestHelper

	/*
	 * Tell the `testFile` method to verify
	 * that the result of parsing an OML test file 
	 * is precisely an OML TerminologyExtent
	 */
 	protected override Class<? extends EObject> getRootObjectType(URI uri) {
        return typeof(Extent)
    }

	@Test 
	def void testBase() {
		val topURL = OMLFileTests.getResource("/")
		System.out.println("topURL="+topURL)
		
		val baseURL = OMLFileTests.getResource("/ModuleTests/imce.jpl.nasa.gov/foundation/base/base.oml")
		System.out.println("baseURL="+baseURL)
		
		testFile("ModuleTests/imce.jpl.nasa.gov/foundation/base/base.oml")
	}
	
	@Test 
	def void testMission() {
		val topURL = OMLFileTests.getResource("/")
		System.out.println("topURL="+topURL)
		
		val missionURL = OMLFileTests.getResource("/ModuleTests/imce.jpl.nasa.gov/foundation/mission/mission.oml")
		System.out.println("missionURL="+missionURL)
		
		testFile("ModuleTests/imce.jpl.nasa.gov/foundation/mission/mission.oml", "ModuleTests/imce.jpl.nasa.gov/foundation/base/base.oml")
	}
	
	@Test 
	def void format1() {
		assertFormatted[
			preferences[
				put(FormatterPreferenceKeys.indentation, "\t")
				put(FormatterPreferenceKeys.tabWidth, 2)
			]
// Works with grammar-based formatting; doesn't work without.
//
			expectation = 
'''open terminology <http://imce.jpl.nasa.gov/foundation/base/base> {

	aspect IdentifiedElement

}
'''

			toBeFormatted = '''
				 open 
				 
				  terminology 
				  
				    <http://imce.jpl.nasa.gov/foundation/base/base>       {
					
					    aspect 
					  IdentifiedElement
				}
			'''

// Without grammar-based formatting.
//			expectation = 
//'''
//
//open terminology <http://imce.jpl.nasa.gov/foundation/base/base> {
//	aspect IdentifiedElement
//}
//'''
//			toBeFormatted = '''
//				 open 
//				 
//				  terminology 
//				  
//				    <http://imce.jpl.nasa.gov/foundation/base/base>       {
//					aspect IdentifiedElement
//				}
//			'''
		]
	}
}