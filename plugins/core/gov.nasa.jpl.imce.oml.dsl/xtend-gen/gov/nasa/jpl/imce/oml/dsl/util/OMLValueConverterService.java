/**
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
package gov.nasa.jpl.imce.oml.dsl.util;

import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.util.DateTimeValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.DecimalValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.FloatValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.LanguageTagValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.OMLExternalReferenceValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.OMLIRIValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.OMLQNAMEValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.OMLReferenceValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.OMLSL_COMMENTValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.PatternValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.PositiveIntegerValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.QuotedStringValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.RawStringValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.RealValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.URIValueConverter;
import gov.nasa.jpl.imce.oml.dsl.util.UUIDValueConverter;
import gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue;
import gov.nasa.jpl.imce.oml.model.datatypes.DecimalValue;
import gov.nasa.jpl.imce.oml.model.datatypes.FloatValue;
import gov.nasa.jpl.imce.oml.model.datatypes.LanguageTagValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PatternValue;
import gov.nasa.jpl.imce.oml.model.datatypes.PositiveIntegerValue;
import gov.nasa.jpl.imce.oml.model.datatypes.QuotedStringValue;
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue;
import gov.nasa.jpl.imce.oml.model.datatypes.RealValue;
import gov.nasa.jpl.imce.oml.model.datatypes.URIValue;
import gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.KeywordAlternativeConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class OMLValueConverterService extends DefaultTerminalConverters {
  @Inject
  private OMLReferenceValueConverter referenceValueConverter;
  
  @Inject
  private OMLQNAMEValueConverter qnameValueConverter;
  
  @Inject
  private QualifiedNameValueConverter qualifiedNameValueConverter;
  
  @Inject
  private OMLIRIValueConverter iriValueConverter;
  
  @Inject
  private OMLExternalReferenceValueConverter externalReferenceValueConverter;
  
  @Inject
  private OMLSL_COMMENTValueConverter sl_CommentValueConverter;
  
  @Inject
  private KeywordAlternativeConverter validIDValueConverter;
  
  @Inject
  private FloatValueConverter floatValueConverter;
  
  @Inject
  private DecimalValueConverter decimalValueConverter;
  
  @Inject
  private PositiveIntegerValueConverter positiveIntegerValueConverter;
  
  @Inject
  private DateTimeValueConverter dateTimeValueConverter;
  
  @Inject
  private LanguageTagValueConverter langTagValueConverter;
  
  @Inject
  private PatternValueConverter patternValueConverter;
  
  @Inject
  private RealValueConverter realValueConverter;
  
  @Inject
  private URIValueConverter uriValueConverter;
  
  @Inject
  private UUIDValueConverter uuidValueConverter;
  
  @Inject
  private QuotedStringValueConverter quotedStringValueConverter;
  
  @Inject
  private RawStringValueConverter rawStringValueConverter;
  
  @ValueConverter(rule = "Reference")
  public IValueConverter<String> Reference() {
    return this.referenceValueConverter;
  }
  
  @ValueConverter(rule = "QNAME")
  public IValueConverter<String> QNAME() {
    return this.qnameValueConverter;
  }
  
  @ValueConverter(rule = "QualifiedName")
  public IValueConverter<String> QualifiedName() {
    return this.qualifiedNameValueConverter;
  }
  
  @ValueConverter(rule = "IRI")
  public IValueConverter<String> IRI() {
    return this.iriValueConverter;
  }
  
  @ValueConverter(rule = "ExternalReference")
  public IValueConverter<String> ExternalReference() {
    return this.externalReferenceValueConverter;
  }
  
  @ValueConverter(rule = "SL_COMMENT")
  public IValueConverter<String> SL_COMMENT() {
    return this.sl_CommentValueConverter;
  }
  
  @ValueConverter(rule = "ValidID")
  public IValueConverter<String> ValidID() {
    return this.validIDValueConverter;
  }
  
  @ValueConverter(rule = "QUOTED_STRING_VALUE")
  public IValueConverter<QuotedStringValue> QuotedString() {
    return this.quotedStringValueConverter;
  }
  
  @ValueConverter(rule = "RAW_STRING_VALUE")
  public IValueConverter<RawStringValue> RawString() {
    return this.rawStringValueConverter;
  }
  
  @ValueConverter(rule = "FLOAT")
  public IValueConverter<FloatValue> FloatValue() {
    return this.floatValueConverter;
  }
  
  @ValueConverter(rule = "DECIMAL")
  public IValueConverter<DecimalValue> DecimalValue() {
    return this.decimalValueConverter;
  }
  
  @ValueConverter(rule = "DIGITS")
  public IValueConverter<PositiveIntegerValue> PositiveIntegerValue() {
    return this.positiveIntegerValueConverter;
  }
  
  @ValueConverter(rule = "DATE_TIME")
  public IValueConverter<DateTimeValue> DateTimeValue() {
    return this.dateTimeValueConverter;
  }
  
  @ValueConverter(rule = "LANG_TAG")
  public IValueConverter<LanguageTagValue> LanguageTagValue() {
    return this.langTagValueConverter;
  }
  
  @ValueConverter(rule = "PATTERN")
  public IValueConverter<PatternValue> PatternValue() {
    return this.patternValueConverter;
  }
  
  @ValueConverter(rule = "REAL")
  public IValueConverter<RealValue> RealValue() {
    return this.realValueConverter;
  }
  
  @ValueConverter(rule = "URI")
  public IValueConverter<URIValue> URIValue() {
    return this.uriValueConverter;
  }
  
  @ValueConverter(rule = "UUID")
  public IValueConverter<UUIDValue> UUIDValue() {
    return this.uuidValueConverter;
  }
  
  @Override
  public String toString(final Object value, final String lexerRule) {
    final IValueConverter<Object> conv = this.getConverter(lexerRule);
    return conv.toString(value);
  }
  
  @Override
  public Object toValue(final String string, final String lexerRule, final INode node) throws ValueConverterException {
    final IValueConverter<Object> conv = this.getConverter(lexerRule);
    return conv.toValue(string, node);
  }
}
