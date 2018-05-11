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
import gov.nasa.jpl.imce.oml.dsl.util.GenericValueConverter;
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class RawStringValueConverter extends GenericValueConverter<RawStringValue> {
  @Inject
  protected IValueConverterService valueConverterService;
  
  @Override
  public String toEscapedString(final RawStringValue value) {
    return (("\"\"\"" + value.value) + "\"\"\"");
  }
  
  @Override
  public RawStringValue toValue(final String string, final INode node) {
    RawStringValue _xblockexpression = null;
    {
      if ((string == null)) {
        return null;
      }
      RawStringValue _xtrycatchfinallyexpression = null;
      try {
        RawStringValue _xblockexpression_1 = null;
        {
          final String s = this.convertFromString(string, node);
          _xblockexpression_1 = new RawStringValue(s);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          final IllegalArgumentException e = (IllegalArgumentException)_t;
          String _message = e.getMessage();
          throw new ValueConverterException(_message, node, e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * @since 2.7
   */
  protected String getInvalidTripleQuoteMessage() {
    return "A RawStringValue cannot contain triple quotes: \'\"\"\"\'";
  }
  
  /**
   * @since 2.7
   */
  protected String getRawStringNotQuotedMessage() {
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
  protected String convertFromString(final String literal, final INode node) throws ValueConverterWithValueException {
    int _length = literal.length();
    boolean _lessThan = (_length < 6);
    if (_lessThan) {
      String _rawStringNotQuotedMessage = this.getRawStringNotQuotedMessage();
      throw new ValueConverterWithValueException(_rawStringNotQuotedMessage, node, "", null);
    }
    int _length_1 = literal.length();
    int _minus = (_length_1 - 3);
    final String contents = literal.substring(3, _minus);
    final int index = contents.indexOf("\"\"\"");
    if ((index >= 0)) {
      String _invalidTripleQuoteMessage = this.getInvalidTripleQuoteMessage();
      throw new ValueConverterWithValueException(_invalidTripleQuoteMessage, node, contents, index, 3, null);
    } else {
      return contents;
    }
  }
}
