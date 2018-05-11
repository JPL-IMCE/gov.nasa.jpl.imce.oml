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
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;

@SuppressWarnings("all")
public abstract class GenericValueConverter<T extends Object> extends AbstractLexerBasedConverter<T> {
  /**
   * This method is equivalent to AbstractLexerBasedConverter<T>.assertTokens
   * The difference is that when troubleshooting ValueConverterException using the debugger,
   * there are local variables to help better understand why comparisons failed.
   */
  @Override
  protected void assertTokens(final T value, final TokenSource tokenSource, final String escapedString) {
    if ((tokenSource == null)) {
      return;
    }
    final Token token = tokenSource.nextToken();
    final String tokenString = token.getText();
    boolean _equals = escapedString.equals(tokenString);
    boolean _not = (!_equals);
    if (_not) {
      throw this.createTokenContentMismatchException(value, escapedString, token);
    }
    final String ruleName = this.getRuleName().toUpperCase();
    final String tokenRUleName = this.getRuleName(token);
    boolean _equals_1 = ruleName.equals(tokenRUleName);
    boolean _not_1 = (!_equals_1);
    if (_not_1) {
      throw this.createTokenTypeMismatchException(value, escapedString, token);
    }
    final T reparsedValue = this.toValue(tokenString, null);
    if (((!Objects.equal(value, reparsedValue)) && (!value.equals(reparsedValue)))) {
      throw this.createTokenContentMismatchException(value, escapedString, token);
    }
  }
}
