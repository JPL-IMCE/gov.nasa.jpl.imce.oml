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
import gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue
import org.eclipse.emf.common.util.URI
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

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

		val onValue = createLiteralQuotedString
		onValue.string = new QuotedStringValue("On")
		on.value = onValue

		val off = createScalarOneOfLiteralAxiom
		off.tbox = tbox1
		off.axiom = s2
		// off.valueType = s2
		val offValue = createLiteralQuotedString
		offValue.string = new QuotedStringValue("Off")
		off.value = offValue

		return #[new Pair<URI, Extent>(URI.createURI(tbox1.iri()), extent)]
	}

	@Test
	def void test1() {
		compareSavedAndLoaded(example1)
	}

}
