/*
 * Copyright 2016 California Institute of Technology ("Caltech").
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
package gov.nasa.jpl.imce.oml.serialization.tests

import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue
import gov.nasa.jpl.imce.oml.model.extensions.OMLTables
import gov.nasa.jpl.imce.oml.zip.OMLZipResource
import org.eclipse.emf.common.util.URI
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.Assert

@RunWith(BlockJUnit4ClassRunner)
class OMLZip2Test extends OMLSaveLoadComparisonTest {

	static def Pair<URI, Extent>[] example1() {
		val extent = createExtent

		val tbox1 = createTerminologyGraph
		tbox1.extent = extent
		tbox1.iri = "http://test"

		val s1 = createScalar
		s1.tbox = tbox1
		s1.name = "string"

		val s2 = createScalarOneOfRestriction
		s2.tbox = tbox1
		s2.name = "OnOff"
		s2.restrictedRange = s1

		val on = createScalarOneOfLiteralAxiom
		on.tbox = tbox1
		on.axiom = s2
		on.valueType = s2

		val onValue = createLiteralRawString
		onValue.string = new RawStringValue('''on,
		"on",
		true''')
		on.value = onValue

		val off = createScalarOneOfLiteralAxiom
		off.tbox = tbox1
		off.axiom = s2
		off.valueType = s2
		
		val offValue = createLiteralRawString
		offValue.string = new RawStringValue('''
			
			This is "on"
			
			Ceci est "true"
		''')
		off.value = offValue

		return #[new Pair<URI, Extent>(URI.createURI(tbox1.iri()), extent)]
	}

	@Test
	def void test1() {
		compareSavedAndLoaded(example1)
	}

	// For development purposes, this is helpful to understand the string regex parsing processes involved in OML.
	
	def array(String s) {
		println()
		println(s)
		var pass = 1
		val a = OMLTables.StringArray.matcher(s)
		println("match? " + a)
		val buffer = new StringBuffer()
		while (a.find()) {
			val part = a.group(1)
			println('''«pass++»: "«part»"''')
			if ("\\\\n" == part)
				buffer.append(OMLTables.NEWLINE)
			else if ("\\\\r" == part)
				buffer.append(OMLTables.LINEFEED)
			else if ("\\\"" == part)
				buffer.append(OMLTables.QUOTE)
			else
				buffer.append(part)
			}
		println(buffer.toString)
	}
	
	def value(String s) {
		println()
		println(s)
		var pass = 1
		val m = OMLTables.LiteralNumberOrValue.matcher(s)
		println("match? " + m)
		while (m.find()) {
			println("pass: " + pass)
			println(m.groupCount)
			for (var i = 1; i <= m.groupCount; i++) {
				println('''«i»: «m.group(i)»''')
			}
		}
	}
	def show(String s) {
		println()
		println(s)
		var pass = 1
		val m = OMLZipResource.KeyValue.matcher(s)
		println("match? " + m)
		while (m.find()) {
			println("pass: " + pass)
			println(m.groupCount)
			for (var i = 1; i <= m.groupCount; i++) {
				println('''«i»: «m.group(i)»''')
			}
		}
	}

	@Test
	def void test2() {
		show('''"value":["\n"]''')
		show('''"value":["\\n"]''')
		show('''"value":["\n","This is ","\"","\"","on"]''')
		show('''"value":["\n","This is ","\"","\"","on","\n","and on..."]''')
		show('''"value":["\\n","This is ","\"","\"","on"]''')
		show('''"value":["\\n","This is ","\"","\"","on","\n","and on..."]''')
		show('''"value":["\\r"]''')
		show('''"value":["\""]''')
		show('''"value":["abc"]''')
		show('''"value":["abc","def"]''')

		show('''"value":["\n","This is ","\"","\"","on","\"","\"","\n","\n","Ceci est ","\"","true","\"","\n"]''')
		show('''"value":["\\n","This is ","\"","\"","on","\"","\"","\\n","\\n","Ceci est ","\"","true","\"","\\n"]''')
		show('''"value":["\\n","This is ","\"","\""]''')
		show('''"value":["\\n","\\n"]''')
		show('''"value":["abc","\\r"]''')
		show('''"value":"OpenWorldDefiniions"''')
		show('''"value":true''')
		show('''"value":false''')
		
		value('''{"literalType":"string","value":["\"","def"]}''')
		value('''{"literalType":"int","value":"42"}''')
		value('''["\"","def"]''')
		
		array('''"\\n","This is ","\"","\"","on","\"","\"","\\n","\\n","Ceci est ","\"","true","\"","\\n"''')
		array('''"\\n","This is ","\"","\"","on"''')
		array('''"\\n","This is ","\"","\""''')
		array('''"\"","def"''')
	}

	@Test
	def void test3() {
		val s1 = '''on,
		"on",
		true'''
		val v1 = OMLTables.toString(s1)
		val j1 = "[\"on,\",\"\\n\",\"\t\t\",\"\\\"\",\"on\",\"\\\"\",\",\",\"\\n\",\"\t\ttrue\"]"
		Assert.assertEquals(j1, v1)
	}
}
