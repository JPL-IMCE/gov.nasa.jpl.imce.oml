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
import gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue

class QuotedStringValueConverter extends GenericValueConverter<QuotedStringValue> {
	
	@Inject
	protected IValueConverterService valueConverterService;

	override String toEscapedString(QuotedStringValue value) {
		return "\"" + value.value + "\""
	}
	
	override QuotedStringValue toValue(String string, INode node) {
		if (string === null)
			return null
		try {
			if (string.length() == 1) {
				throw new ValueConverterWithValueException(getStringNotClosedMessage(), node, "", null)
			}
			val s = convertFromString(string, node)
			new QuotedStringValue(s)
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}

	/**
	 * @since 2.7
	 */
	protected def String getInvalidEscapeSequenceMessage() {
		return "Invalid escape sequence for QuotedString (valid ones are  \\b  \\t  \\n  \\f  \\r  \\\"  \\'  \\\\ )";
	}
	
	/**
	 * @since 2.7
	 */
	protected def String getStringNotClosedMessage() {
		return "QuotedString literal is not properly closed";
	}

	/**
	 * @since 2.7
	 */
	protected def boolean isHexSequence(char[] in, int off, int chars) {
		for (var int i = off; i < in.length && i < off + chars; i++) {
			val char c = in.get(i)
			switch (c) {
				case '0',
				case '1',
				case '2',
				case '3',
				case '4',
				case '5',
				case '6',
				case '7',
				case '8',
				case '9',
				case 'a',
				case 'b',
				case 'c',
				case 'd',
				case 'e',
				case 'f',
				case 'A',
				case 'B',
				case 'C',
				case 'D',
				case 'E',
				case 'F':
					{}
				default:
					return false
			}
		}
		return true
	}

	/**
	 * Converts a string literal (including leading and trailing single or double quote) to a semantic
	 * string value. Recovers from invalid escape sequences and announces the first problem with a
	 * {@link ValueConverterWithValueException}.
	 * 
	 * @since 2.7
	 * @throws ValueConverterWithValueException if the given string is syntactically invalid.
	 * @see Strings#convertFromJavaString(String, boolean)
	 */
	protected def String convertFromString(String literal, INode node) throws ValueConverterWithValueException {
		val char[] in = literal.toCharArray()
		var int off = 1
		val int len = literal.length() - 1
		var char aChar
		var char[] out = newCharArrayOfSize(len)
		var int outLen = 0
		val int end = off + len

		var String errorMessage = null
		var int errorIndex = -1
		var int errorLength = -1
		while (off < end - 1) {
			aChar = in.get(off++)
			if (aChar == '\\') {
				if (off < end) {
					aChar = in.get(off++)
					switch (aChar) {
						case 'u': {
							// Try to read the xxxx
							var int value = 0
							if (off + 4 > end || !isHexSequence(in, off, 4)) {
								out.set(outLen++, aChar)
								if (errorMessage === null) {
									errorMessage = "Invalid unicode"
									errorIndex = off - 2
									errorLength = 2
								}
							} else {
								for (var int i = 0; i < 4; i++) {
									aChar = in.get(off++)
									switch (aChar) {
										case '0',
										case '1',
										case '2',
										case '3',
										case '4',
										case '5',
										case '6',
										case '7',
										case '8',
										case '9':
											value = (value << 4) + aChar - '0'
										case 'a',
										case 'b',
										case 'c',
										case 'd',
										case 'e',
										case 'f':
											value = (value << 4) + 10 + aChar - 'a'
										case 'A',
										case 'B',
										case 'C',
										case 'D',
										case 'E',
										case 'F':
											value = (value << 4) + 10 + aChar - 'A'
										default:
											throw new IllegalArgumentException("Malformed \\uxxxx encoding.")
									}
								}
								out.set(outLen++, value as char)
							}
						}
						case 't':
							out.set(outLen++, '\t')
						case 'r':
							out.set(outLen++, '\r')
						case 'n':
							out.set(outLen++, '\n')
						case 'f':
							out.set(outLen++, '\f')
						case 'b':
							out.set(outLen++, '\b')
						case '"':
							out.set(outLen++, '"')
						case '\'':
							out.set(outLen++, '\'')
						case '\\':
							out.set(outLen++, '\\')
						default: {
							if (errorMessage === null) {
								errorMessage = getInvalidEscapeSequenceMessage()
								errorIndex = off - 2
								errorLength = 2
							}
							out.set(outLen++, aChar)	
						}
					}
				} else {
					if (errorMessage === null) {
						errorMessage = getInvalidEscapeSequenceMessage()
						errorIndex = off - 1
						errorLength = 1
					}
					out.set(outLen++, aChar)
				}
			} else {
				out.set(outLen++, aChar)
			}
		}
		if (off < end) {
			if (off != end - 1) {
				throw new IllegalStateException()
			}
			aChar = in.get(off)
			if (in.get(0) != in.get(off)) {
				out.set(outLen++, aChar)
				if (errorMessage === null) {
					if (in.get(off) == '\\') {
						errorMessage = getInvalidEscapeSequenceMessage()
						errorIndex = off
						errorLength = 1
					} else {
						errorMessage = getStringNotClosedMessage()
					}
				} else {
					errorMessage = getStringNotClosedMessage()
					errorIndex = -1
					errorLength = -1
				}
			}
		}
		if (errorMessage !== null) {
			throw new ValueConverterWithValueException(errorMessage, node, new String(out, 0, outLen), errorIndex,
					errorLength, null)
		}
		return new String(out, 0, outLen)
	}

}