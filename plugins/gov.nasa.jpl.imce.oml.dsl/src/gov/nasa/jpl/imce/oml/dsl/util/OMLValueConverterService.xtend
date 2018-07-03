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
import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.impl.KeywordAlternativeConverter
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter
import gov.nasa.jpl.imce.oml.model.datatypes.FloatValue
import gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue
import gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue
import gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue
import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue
import gov.nasa.jpl.imce.oml.model.datatypes.RealValue
import gov.nasa.jpl.imce.oml.model.datatypes.URIValue
import gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.nodemodel.INode
import gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue

class OMLValueConverterService extends DefaultTerminalConverters {

	@Inject OMLReferenceValueConverter referenceValueConverter

	@Inject OMLQNAMEValueConverter qnameValueConverter

	@Inject QualifiedNameValueConverter qualifiedNameValueConverter

	@Inject OMLIRIValueConverter iriValueConverter

	@Inject OMLExternalReferenceValueConverter externalReferenceValueConverter
	
	@Inject OMLSL_COMMENTValueConverter sl_CommentValueConverter

	@Inject KeywordAlternativeConverter validIDValueConverter

	@Inject FloatValueConverter floatValueConverter
	
	@Inject DecimalValueConverter decimalValueConverter
	
	@Inject PositiveIntegerValueConverter positiveIntegerValueConverter
	
	@Inject DateTimeValueConverter dateTimeValueConverter
	
	@Inject LanguageTagValueConverter langTagValueConverter
	
	@Inject PatternValueConverter patternValueConverter
	
	@Inject RealValueConverter realValueConverter
	
	@Inject URIValueConverter uriValueConverter
	
	@Inject UUIDValueConverter uuidValueConverter
	
	@Inject QuotedStringValueConverter quotedStringValueConverter
	
	@Inject RawStringValueConverter rawStringValueConverter
	
	@ValueConverter(rule="Reference")
	def IValueConverter<String> Reference() {
		referenceValueConverter
	}

	@ValueConverter(rule="QNAME")
	def IValueConverter<String> QNAME() {
		qnameValueConverter
	}

	@ValueConverter(rule="QualifiedName")
	def IValueConverter<String> QualifiedName() {
		qualifiedNameValueConverter
	}

	@ValueConverter(rule="IRI")
	def IValueConverter<String> IRI() {
		iriValueConverter
	}

	@ValueConverter(rule="ExternalReference")
	def IValueConverter<String> ExternalReference() {
		externalReferenceValueConverter
	}
	
	@ValueConverter(rule="SL_COMMENT")
	def IValueConverter<String> SL_COMMENT() {
		sl_CommentValueConverter
	}

	@ValueConverter(rule="ValidID")
	def IValueConverter<String> ValidID() {
		validIDValueConverter
	}
	
	@ValueConverter(rule="QUOTED_STRING_VALUE")
	def IValueConverter<QuotedStringValue> QuotedString() {
		quotedStringValueConverter
	}
	
	@ValueConverter(rule="RAW_STRING_VALUE")
	def IValueConverter<RawStringValue> RawString() {
		rawStringValueConverter
	}
	
	@ValueConverter(rule="FLOAT")
	def IValueConverter<FloatValue> FloatValue() {
		floatValueConverter
	}
	
	@ValueConverter(rule="DECIMAL")
	def IValueConverter<DecimalValue> DecimalValue() {
		decimalValueConverter
	}
	
	@ValueConverter(rule="DIGITS")
	def IValueConverter<PositiveIntegerValue> PositiveIntegerValue() {
		positiveIntegerValueConverter
	}
	
	@ValueConverter(rule="DATE_TIME")
	def IValueConverter<DateTimeValue> DateTimeValue() {
		dateTimeValueConverter
	}
	
	@ValueConverter(rule="LANG_TAG")
	def IValueConverter<LanguageTagValue> LanguageTagValue() {
		langTagValueConverter
	}
	
	@ValueConverter(rule="PATTERN")
	def IValueConverter<PatternValue> PatternValue() {
		patternValueConverter
	}
	
	@ValueConverter(rule="REAL")
	def IValueConverter<RealValue> RealValue() {
		realValueConverter
	}
	
	@ValueConverter(rule="URI")
	def IValueConverter<URIValue> URIValue() {
		uriValueConverter
	}
	
	@ValueConverter(rule="UUID")
	def IValueConverter<UUIDValue> UUIDValue() {
		uuidValueConverter
	}
	
	override String toString(Object value, String lexerRule) {
		val conv = getConverter(lexerRule)
		return conv.toString(value);
	}

	override Object toValue(String string, String lexerRule, INode node) throws ValueConverterException {
		val conv = getConverter(lexerRule)
		return conv.toValue(string, node);
	}
	
}
