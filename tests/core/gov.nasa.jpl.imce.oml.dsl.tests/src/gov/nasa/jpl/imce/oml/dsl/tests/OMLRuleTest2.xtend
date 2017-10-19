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
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLRuleTest2 {

	@Inject extension FormatterTestHelper

	@Test
	def void ruleTest2() {
		assertFormatted[
			preferences[
				put(FormatterPreferenceKeys.indentation, "\t")
				put(FormatterPreferenceKeys.tabWidth, 2)
			]

			expectation = '''open terminology <http://example.org/Foo> {

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

	rule pqr infers Foo:r
	if Foo:p

}
'''

			toBeFormatted = '''
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
	
	rule pqr infers Foo:r if Foo:p

}
			'''
		]
	}

}
