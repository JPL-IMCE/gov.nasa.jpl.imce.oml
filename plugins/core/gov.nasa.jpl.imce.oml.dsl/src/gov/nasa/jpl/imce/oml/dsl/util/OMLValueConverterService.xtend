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
import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.impl.KeywordAlternativeConverter
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter

class OMLValueConverterService extends DefaultTerminalConverters {

	@Inject OMLReferenceValueConverter referenceValueConverter

	@Inject OMLQNAMEValueConverter qnameValueConverter

	@Inject QualifiedNameValueConverter qualifiedNameValueConverter

	@Inject OMLIRIValueConverter iriValueConverter

	@Inject OMLExternalReferenceValueConverter externalReferenceValueConverter
	
	@Inject OMLSL_COMMENTValueConverter sl_CommentValueConverter

	@Inject KeywordAlternativeConverter validIDValueConverter

	@ValueConverter(rule="Reference")
	def IValueConverter<String> Reference() {
		referenceValueConverter;
	}

	@ValueConverter(rule="QNAME")
	def IValueConverter<String> QNAME() {
		qnameValueConverter;
	}

	@ValueConverter(rule="QualifiedName")
	def IValueConverter<String> QualifiedName() {
		qualifiedNameValueConverter;
	}

	@ValueConverter(rule="IRI")
	def IValueConverter<String> IRI() {
		iriValueConverter;
	}

	@ValueConverter(rule="ExternalReference")
	def IValueConverter<String> ExternalReference() {
		externalReferenceValueConverter;
	}
	
	@ValueConverter(rule="SL_COMMENT")
	def IValueConverter<String> SL_COMMENT() {
		sl_CommentValueConverter;
	}

	@ValueConverter(rule="ValidID")
	def IValueConverter<String> ValidID() {
		validIDValueConverter;
	}
}
