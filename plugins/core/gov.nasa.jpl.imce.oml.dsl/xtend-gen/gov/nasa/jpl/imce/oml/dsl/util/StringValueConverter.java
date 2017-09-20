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

import com.google.common.base.Objects;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.util.GenericValueConverter;
import gov.nasa.jpl.imce.oml.model.datatypes.StringValue;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class StringValueConverter extends GenericValueConverter<StringValue> {
  @Inject
  protected IValueConverterService valueConverterService;
  
  @Override
  public String toEscapedString(final StringValue value) {
    return (("\"" + value.value) + "\"");
  }
  
  @Override
  public StringValue toValue(final String string, final INode node) {
    StringValue _xblockexpression = null;
    {
      if ((string == null)) {
        return null;
      }
      StringValue _xtrycatchfinallyexpression = null;
      try {
        StringValue _xblockexpression_1 = null;
        {
          int _length = string.length();
          boolean _equals = (_length == 1);
          if (_equals) {
            String _stringNotClosedMessage = this.getStringNotClosedMessage();
            throw new ValueConverterWithValueException(_stringNotClosedMessage, node, "", null);
          }
          final String s = this.convertFromString(string, node);
          _xblockexpression_1 = new StringValue(s);
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
  protected String getInvalidEscapeSequenceMessage() {
    return "Invalid escape sequence (valid ones are  \\b  \\t  \\n  \\f  \\r  \\\"  \\\'  \\\\ )";
  }
  
  /**
   * @since 2.7
   */
  protected String getStringNotClosedMessage() {
    return "String literal is not properly closed";
  }
  
  /**
   * @since 2.7
   */
  protected boolean isHexSequence(final char[] in, final int off, final int chars) {
    for (int i = off; ((i < in.length) && (i < (off + chars))); i++) {
      {
        final char c = in[i];
        boolean _matched = false;
        if (Objects.equal(c, "0")) {
          _matched=true;
        }
        if (!_matched) {
          if (Objects.equal(c, "1")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "2")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "3")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "4")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "5")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "6")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "7")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "8")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "9")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "a")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "b")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "c")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "d")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "e")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "f")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "A")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "B")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "C")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "D")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "E")) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(c, "F")) {
            _matched=true;
          }
        }
        if (_matched) {
        }
        if (!_matched) {
          return false;
        }
      }
    }
    return true;
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
  protected String convertFromString(final String literal, final INode node) throws ValueConverterWithValueException {
    final char[] in = literal.toCharArray();
    int off = 1;
    int _length = literal.length();
    final int len = (_length - 1);
    char aChar = 0;
    char[] out = new char[len];
    int outLen = 0;
    final int end = (off + len);
    String errorMessage = null;
    int errorIndex = (-1);
    int errorLength = (-1);
    while ((off < (end - 1))) {
      {
        int _plusPlus = off++;
        aChar = in[_plusPlus];
        boolean _equals = Objects.equal(Character.valueOf(aChar), "\\");
        if (_equals) {
          if ((off < end)) {
            int _plusPlus_1 = off++;
            aChar = in[_plusPlus_1];
            boolean _matched = false;
            if (Objects.equal(aChar, "u")) {
              _matched=true;
              int value = 0;
              if ((((off + 4) > end) || (!this.isHexSequence(in, off, 4)))) {
                int _plusPlus_2 = outLen++;
                out[_plusPlus_2] = aChar;
                if ((errorMessage == null)) {
                  errorMessage = "Invalid unicode";
                  errorIndex = (off - 2);
                  errorLength = 2;
                }
              } else {
                for (int i = 0; (i < 4); i++) {
                  {
                    int _plusPlus_3 = off++;
                    aChar = in[_plusPlus_3];
                    boolean _matched_1 = false;
                    if (Objects.equal(aChar, "0")) {
                      _matched_1=true;
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "1")) {
                        _matched_1=true;
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "2")) {
                        _matched_1=true;
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "3")) {
                        _matched_1=true;
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "4")) {
                        _matched_1=true;
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "5")) {
                        _matched_1=true;
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "6")) {
                        _matched_1=true;
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "7")) {
                        _matched_1=true;
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "8")) {
                        _matched_1=true;
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "9")) {
                        _matched_1=true;
                      }
                    }
                    if (_matched_1) {
                      value = (((value << 4) + aChar) - '0');
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "a")) {
                        _matched_1=true;
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "b")) {
                          _matched_1=true;
                        }
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "c")) {
                          _matched_1=true;
                        }
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "d")) {
                          _matched_1=true;
                        }
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "e")) {
                          _matched_1=true;
                        }
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "f")) {
                          _matched_1=true;
                        }
                      }
                      if (_matched_1) {
                        value = ((((value << 4) + 10) + aChar) - 'a');
                      }
                    }
                    if (!_matched_1) {
                      if (Objects.equal(aChar, "A")) {
                        _matched_1=true;
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "B")) {
                          _matched_1=true;
                        }
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "C")) {
                          _matched_1=true;
                        }
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "D")) {
                          _matched_1=true;
                        }
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "E")) {
                          _matched_1=true;
                        }
                      }
                      if (!_matched_1) {
                        if (Objects.equal(aChar, "F")) {
                          _matched_1=true;
                        }
                      }
                      if (_matched_1) {
                        value = ((((value << 4) + 10) + aChar) - 'A');
                      }
                    }
                    if (!_matched_1) {
                      throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
                    }
                  }
                }
                int _plusPlus_3 = outLen++;
                out[_plusPlus_3] = ((char) value);
              }
            }
            if (!_matched) {
              if (Objects.equal(aChar, "t")) {
                _matched=true;
                int _plusPlus_4 = outLen++;
                out[_plusPlus_4] = '\t';
              }
            }
            if (!_matched) {
              if (Objects.equal(aChar, "r")) {
                _matched=true;
                int _plusPlus_5 = outLen++;
                out[_plusPlus_5] = '\r';
              }
            }
            if (!_matched) {
              if (Objects.equal(aChar, "n")) {
                _matched=true;
                int _plusPlus_6 = outLen++;
                out[_plusPlus_6] = '\n';
              }
            }
            if (!_matched) {
              if (Objects.equal(aChar, "f")) {
                _matched=true;
                int _plusPlus_7 = outLen++;
                out[_plusPlus_7] = '\f';
              }
            }
            if (!_matched) {
              if (Objects.equal(aChar, "b")) {
                _matched=true;
                int _plusPlus_8 = outLen++;
                out[_plusPlus_8] = '\b';
              }
            }
            if (!_matched) {
              if (Objects.equal(aChar, "\"")) {
                _matched=true;
                int _plusPlus_9 = outLen++;
                out[_plusPlus_9] = '\"';
              }
            }
            if (!_matched) {
              if (Objects.equal(aChar, "\'")) {
                _matched=true;
                int _plusPlus_10 = outLen++;
                out[_plusPlus_10] = '\'';
              }
            }
            if (!_matched) {
              if (Objects.equal(aChar, "\\")) {
                _matched=true;
                int _plusPlus_11 = outLen++;
                out[_plusPlus_11] = '\\';
              }
            }
            if (!_matched) {
              {
                if ((errorMessage == null)) {
                  errorMessage = this.getInvalidEscapeSequenceMessage();
                  errorIndex = (off - 2);
                  errorLength = 2;
                }
                int _plusPlus_12 = outLen++;
                out[_plusPlus_12] = aChar;
              }
            }
          } else {
            if ((errorMessage == null)) {
              errorMessage = this.getInvalidEscapeSequenceMessage();
              errorIndex = (off - 1);
              errorLength = 1;
            }
            int _plusPlus_12 = outLen++;
            out[_plusPlus_12] = aChar;
          }
        } else {
          int _plusPlus_13 = outLen++;
          out[_plusPlus_13] = aChar;
        }
      }
    }
    if ((off < end)) {
      if ((off != (end - 1))) {
        throw new IllegalStateException();
      }
      aChar = in[off];
      char _get = in[0];
      char _get_1 = in[off];
      boolean _notEquals = (_get != _get_1);
      if (_notEquals) {
        int _plusPlus = outLen++;
        out[_plusPlus] = aChar;
        if ((errorMessage == null)) {
          char _get_2 = in[off];
          boolean _equals = Objects.equal(Character.valueOf(_get_2), "\\");
          if (_equals) {
            errorMessage = this.getInvalidEscapeSequenceMessage();
            errorIndex = off;
            errorLength = 1;
          } else {
            errorMessage = this.getStringNotClosedMessage();
          }
        } else {
          errorMessage = this.getStringNotClosedMessage();
          errorIndex = (-1);
          errorLength = (-1);
        }
      }
    }
    if ((errorMessage != null)) {
      String _string = new String(out, 0, outLen);
      throw new ValueConverterWithValueException(errorMessage, node, _string, errorIndex, errorLength, null);
    }
    return new String(out, 0, outLen);
  }
}
