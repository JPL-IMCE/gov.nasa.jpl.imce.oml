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
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
import org.eclipse.xtext.resource.XtextResource
import com.google.common.collect.Iterables
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.Strings
import org.junit.Assert
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.Concept

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLRuleTest4 {

	@Inject
	ParseHelper<Extent> parseHelper

	@Test
	def void ruleTest1() {

		val text = '''
open terminology <http://example.org/Foo> {
	
	aspect A
	concept B
	concept C
	
	reifiedRelationship P {
		unreified=p
		source=A
		target=B
	}
	
	unreifiedRelationship q {
		source=C
		target=B
	}
	
	unreifiedRelationship r {
		source=A
		target=C
	}
	
	unreifiedRelationship s {
		source=P
		target=C
	}
	
	rule pqr infers Foo:r if aspect(Foo:A) && reifiedRelationship(Foo:P) && concept(Foo:B) && inv(Foo:q)

	rule psr infers Foo:r if aspect(Foo:A) && inv(source(Foo:P)) && reifiedRelationship(Foo:P) && Foo:s

}
'''
		val result = parseHelper.parse(text)

		assertNotNull(result)
		val r = result.eResource as XtextResource
		assertNoSyntaxErrors(r)

		val tbox = result.modules.filter(TerminologyBox).head
		assertNotNull(tbox)

		val aspects = tbox.boxStatements.filter(Aspect)
		
		val A = aspects.filter[name() == "A"].head
		assertNotNull(A)
		
		val concepts = tbox.boxStatements.filter(Concept)
		
		val B = concepts.filter[name() == "B"].head
		assertNotNull(B)
		
		val rrs = tbox.boxStatements.filter(ReifiedRelationship)
		
		val P = rrs.filter[name() == "P"].head
		assertNotNull(P)
		
		val urs = tbox.boxStatements.filter(UnreifiedRelationship)
		
		val Q = urs.filter[name() == "q"].head
		assertNotNull(Q)
		
		val R = urs.filter[name() == "r"].head
		assertNotNull(R)
		
		val S = urs.filter[name() == "s"].head
		assertNotNull(S)
		
		val rules = tbox.boxStatements.filter(ChainRule)
		
		val r1 = rules.filter[name() == "pqr"].head
		assertNotNull(r1)
		
		assertEquals(r1.getHead, R)
		val tail11 = r1.getFirstSegment
		assertNotNull(tail11)
		
		assertEquals(tail11.getPredicate.termPredicate, A)
		
		val tail12 = tail11.getNextSegment
		assertNotNull(tail12)
		assertEquals(tail12.getPredicate.termPredicate, P)
		
		val tail13 = tail12.getNextSegment
		assertNotNull(tail13)
		
		assertEquals(tail13.getPredicate.termPredicate, B)
		
		val tail14 = tail13.getNextSegment
		assertNotNull(tail14)
		assertEquals(tail14.getPredicate.termPredicate, Q)
		
		assertNull(tail14.getNextSegment)
		
		val r2 = rules.filter[name() == "psr"].head
		assertNotNull(r2)
		
		assertEquals(r2.getHead, R)
		val tail21 = r2.getFirstSegment
		assertNotNull(tail21)
		
		assertEquals(tail21.getPredicate.termPredicate, A)
		
		val tail22 = tail21.getNextSegment
		assertNotNull(tail22)
		assertEquals(tail22.getPredicate.termPredicate, P)
		
		val tail23 = tail22.getNextSegment
		assertNotNull(tail23)
		assertEquals(tail23.getPredicate.termPredicate, P)
		
		val tail24 = tail23.getNextSegment
		assertNotNull(tail24)
		assertEquals(tail24.getPredicate.termPredicate, S)
		
		assertNull(tail24.getNextSegment)
	}

	// @see org.eclipse.xtext.testing.formatter.FormatterTestHelper.assertNoSyntaxErrors(XtextResource)
	def void assertNoSyntaxErrors(XtextResource resource) {
		val Iterable<INode> syntaxErrors = resource.getParseResult().getSyntaxErrors()
		if (!Iterables.isEmpty(syntaxErrors)) {
			val StringBuilder builder = new StringBuilder()
			builder.append("This document can't be formatted because of syntax errors:\n")
			for (INode node : syntaxErrors) {
				val SyntaxErrorMessage msg = node.getSyntaxErrorMessage()
				builder.append(String.format("Line %02d: %s\n", node.getTotalStartLine(), msg.getMessage()))
			}
			fail(builder, resource.getParseResult().getRootNode().getText())
		}
	}
	
	// @see org.eclipse.xtext.testing.formatter.FormatterTestHelper.fail(CharSequence, CharSequence)
	def void fail(CharSequence error, CharSequence document) {
		val StringBuilder builder = new StringBuilder(Strings.trimTrailingLineBreak(error))
		if (document != null) {
			builder.append("\n----------------------------------------------------------\n")
			builder.append(Strings.trimTrailingLineBreak(document))
			builder.append("\n----------------------------------------------------------")
		}
		val String msg = builder.toString()
		System.err.println(msg)
		Assert.fail(msg)
	}
	
}
