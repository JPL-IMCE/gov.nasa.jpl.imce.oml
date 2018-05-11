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
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLRuleTest1 {

	@Inject
	ParseHelper<Extent> parseHelper

	@Test
	def void ruleTest1() {

		val text = '''
open terminology <http://example.org/Foo> {
	
	concept A
	concept B
	concept C
	
	unreifiedRelationship p {
		source=A
		target=B
	}
	
	unreifiedRelationship q {
		source=B
		target=C
	}
	
	unreifiedRelationship r {
		source=A
		target=C
	}
	
	rule pqr infers Foo:r if Foo:p && Foo:q
	
}
'''
		val result = parseHelper.parse(text)

		assertNotNull(result)
		val r = result.eResource
		assertTrue(r.errors.empty)

		val tbox = result.modules.filter(TerminologyBox).head
		assertNotNull(tbox)

		val urs = tbox.boxStatements.filter(UnreifiedRelationship)
		val P = urs.filter[name() == "p"].head
		assertNotNull(P)

		val Q = urs.filter[name() == "q"].head
		assertNotNull(Q)
		
		val R = urs.filter[name() == "r"].head
		assertNotNull(R)
		
		val rule = tbox.boxStatements.filter(ChainRule).head
		assertNotNull(rule)
		
		assertEquals(rule.getHead, R)
		val tail1 = rule.getFirstSegment
		assertNotNull(tail1)
		
		assertEquals(tail1.getPredicate.termPredicate, P)
		
		val tail2 = tail1.getNextSegment
		assertNotNull(tail2)
		assertEquals(tail2.getPredicate.termPredicate, Q)
	}

}
