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
package gov.nasa.jpl.imce.oml.dsl.util

import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter
import org.antlr.runtime.TokenSource
import org.antlr.runtime.Token

abstract class GenericValueConverter<T> extends AbstractLexerBasedConverter<T> {
	
	/*
	 * This method is equivalent to AbstractLexerBasedConverter<T>.assertTokens
	 * The difference is that when troubleshooting ValueConverterException using the debugger,
	 * there are local variables to help better understand why comparisons failed.
	 */
	override protected void assertTokens(T value, TokenSource tokenSource, String escapedString) {
		if (tokenSource === null)
			return;
		val Token token = tokenSource.nextToken()
		val String tokenString = token.getText()
		if (!escapedString.equals(tokenString)) {
			throw createTokenContentMismatchException(value, escapedString, token);
		}
		val String ruleName = getRuleName().toUpperCase()
		val String tokenRUleName = getRuleName(token)
		if (!ruleName.equals(tokenRUleName)) {
			throw createTokenTypeMismatchException(value, escapedString, token);
		}
		val T reparsedValue = toValue(tokenString, null);
		if (value != reparsedValue && !value.equals(reparsedValue)) {
			throw createTokenContentMismatchException(value, escapedString, token);
		}
	}
}