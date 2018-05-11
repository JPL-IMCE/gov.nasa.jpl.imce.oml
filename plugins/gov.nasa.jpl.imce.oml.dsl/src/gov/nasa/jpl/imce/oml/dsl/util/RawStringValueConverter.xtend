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

import com.google.inject.Inject
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.conversion.ValueConverterWithValueException
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue

class RawStringValueConverter extends GenericValueConverter<RawStringValue> {
	
	@Inject
	protected IValueConverterService valueConverterService;

	override def String toEscapedString(RawStringValue value) {
		return "\"\"\"" + value.value + "\"\"\""
	}
	
	override def RawStringValue toValue(String string, INode node) {
		if (string === null)
			return null
		try {
			val s = convertFromString(string, node)
			new RawStringValue(s)
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}

	/**
	 * @since 2.7
	 */
	protected def String getInvalidTripleQuoteMessage() {
		return "A RawStringValue cannot contain triple quotes: '\"\"\"'";
	}
	
	/**
	 * @since 2.7
	 */
	protected def String getRawStringNotQuotedMessage() {
		return "RawString literal must begin and end with triple quotes, \"\"\", and must not contain triple quotes.";
	}

	/**
	 * Converts a string literal (including leading and trailing tiple quote) to a semantic
	 * string value. Recovers from invalid escape sequences and announces the first problem with a
	 * {@link ValueConverterWithValueException}.
	 * 
	 * @since 2.7
	 * @throws ValueConverterWithValueException if the given string is syntactically invalid.
	 * @see Strings#convertFromJavaString(String, boolean)
	 */
	protected def String convertFromString(String literal, INode node) throws ValueConverterWithValueException {
		if (literal.length < 6)
			throw new ValueConverterWithValueException(getRawStringNotQuotedMessage(), node, "", null) 
			
		val contents = literal.substring(3, literal.length - 3)
		val index = contents.indexOf("\"\"\"")
		if (index >= 0)
			throw new ValueConverterWithValueException(getInvalidTripleQuoteMessage, node, contents, index, 3, null)
		else
			return contents
	}

}