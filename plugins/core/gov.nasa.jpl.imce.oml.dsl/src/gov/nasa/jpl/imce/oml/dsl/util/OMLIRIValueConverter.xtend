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
package gov.nasa.jpl.imce.oml.dsl.util

import com.google.inject.Inject
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter
import org.eclipse.xtext.nodemodel.INode

class OMLIRIValueConverter extends AbstractLexerBasedConverter<String> {
	
	@Inject
	protected IValueConverterService valueConverterService;

	override toEscapedString(String value) {
		return '<'+value+'>'
	}
	
	override toValue(String string, INode node) throws ValueConverterException {
		if (!string.startsWith('<') || !string.endsWith('>'))
			throw new ValueConverterException("Invalid IRI", node, null);
		return string.substring(1, string.length-1)
	}
	
}