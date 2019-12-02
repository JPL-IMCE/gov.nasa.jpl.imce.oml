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

import java.net.URL
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import gov.nasa.jpl.imce.oml.model.common.Extent

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertNull
import static org.junit.Assert.assertTrue
import gov.nasa.jpl.imce.oml.model.common.Module
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal

@RunWith(XtextRunner)
class OMLZipLoadTest1 extends MixedOMLLoadTest {
	
    @Test
    def void xmlSchema() {
    	val URL catalogFileURL = OMLZipLoadTest1.getResource("/OML/oml.catalog.xml")
    	initialize(catalogFileURL)
		val r1 = rs.createResource(URI.createURI("http://www.w3.org/2001/XMLSchema.omlzip"))
		assertNotNull(r1)
		r1.load(null)
		assertTrue(1 == r1.contents.size)
		val EObject root = r1.contents.get(0)
		assertTrue(typeof(Extent).isInstance(root))
		val Extent ext = typeof(Extent).cast(root)
		assertTrue(ext.modules.size == 1)
		val Module m = ext.modules.get(0)
		assertTrue(typeof(TerminologyGraph).isInstance(m))
		val TerminologyGraph g = typeof(TerminologyGraph).cast(m)
		val ns = g.boxStatements.filter(NumericScalarRestriction)
		assertTrue(12 == ns.size)
		
		val NumericScalarRestriction r_unsignedLong = ns.findFirst[n|n.getName() == "unsignedLong"]
		assertNotNull(r_unsignedLong)
		assertNull("minExclusive", r_unsignedLong.minExclusive)
		assertNull("minInclusive", r_unsignedLong.minInclusive)
		assertNull("maxExclusive", r_unsignedLong.maxExclusive)
		assertNotNull("maxInclusive", r_unsignedLong.maxInclusive)
		val r_unsignedLong_max = r_unsignedLong.maxInclusive
		assertTrue(typeof(LiteralDecimal).isInstance(r_unsignedLong_max))
		val r_unsignedLong_max_value = typeof(LiteralDecimal).cast(r_unsignedLong_max).decimal
		assertTrue("18446744073709551615" == r_unsignedLong_max_value.value)
		
		val NumericScalarRestriction r_int = ns.findFirst[n|n.getName() == "int"]
		assertNotNull(r_int)
		assertNull("minExclusive", r_int.minExclusive)
		assertNotNull("minInclusive", r_int.minInclusive)
		val r_int_minInclusive = r_int.minInclusive
		assertTrue(typeof(LiteralDecimal).isInstance(r_int_minInclusive))
		val r_int_minInclusive_value = typeof(LiteralDecimal).cast(r_int_minInclusive)
		assertTrue("-2147483648" == r_int_minInclusive_value.value)
		assertNull("maxExclusive", r_int.maxExclusive)
		assertNotNull("maxInclusive", r_int.maxInclusive)
		val r_int_maxInclusive = r_int.maxInclusive
		assertTrue(typeof(LiteralDecimal).isInstance(r_int_maxInclusive))
		val r_int_maxInclusive_value = typeof(LiteralDecimal).cast(r_int_maxInclusive)
		assertTrue("2147483647" == r_int_maxInclusive_value.value)
		
	}
	
}