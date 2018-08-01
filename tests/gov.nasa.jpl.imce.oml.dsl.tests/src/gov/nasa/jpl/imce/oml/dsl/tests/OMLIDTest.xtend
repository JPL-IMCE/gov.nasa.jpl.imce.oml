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

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLIDTest {

	@Test
	def void test1() {
		checkSame("Component")
	}
	
	@Test
	def void test2() {
		checkSame("0123Component")
	}
	
	@Test
	def void test3() {
		checkSame("0123-Component")
	}
	
	@Test
	def void test4() {
		checkSame("'0123-?!@#$%^&*()[]=+|-Component'")
	}
	
	@Test
	def void test5() {
		checkEscaped("0123-?!@#$%^&*()[]=+|-Component")
	}	
	
	@Test
	def void test6() {
		checkIllegal("'0123-?!@#$%^&*()[]=+|-Component")
	}	
	
	@Test
	def void test7() {
		checkIllegal("0123-'?!@#$%^&*()[]=+|-Component")
	}	
	
	@Test
	def void test8() {
		checkEscaped("0123 Component")
	}
		
	@Test
	def void test9() {
		checkIllegal("'0123' Component")
	}
		
	@Test
	def void test10() {
		checkIllegal("0123' 'Component")
	}
	
	def checkSame(String s) {
		Assert.assertEquals(OMLExtensions.wrapOMLIDIfNeeded(s), s)
	}
	
	
	def checkEscaped(String s) {
		Assert.assertEquals(OMLExtensions.wrapOMLIDIfNeeded(s), "'" + s + "'")
	}
	
	def checkIllegal(String s) {
		try {
			OMLExtensions.wrapOMLIDIfNeeded(s)
			Assert.fail('''Expected IllegalArgumentException for ill-formed OML ID: «s»''')
		} catch(IllegalArgumentException e) {
			Assert.assertTrue(e.message.startsWith("Illegal OML ID string:"))
		}
	}
}