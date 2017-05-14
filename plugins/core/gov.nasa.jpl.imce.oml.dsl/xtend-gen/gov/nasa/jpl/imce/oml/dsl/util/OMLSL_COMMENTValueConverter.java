/**
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
package gov.nasa.jpl.imce.oml.dsl.util;

import com.google.inject.Inject;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class OMLSL_COMMENTValueConverter extends AbstractLexerBasedConverter<String> {
  @Inject
  protected IValueConverterService valueConverterService;
  
  public String toEscapedString(final String value) {
    return ("//" + value);
  }
  
  public String toValue(final String string, final INode node) throws ValueConverterException {
    boolean _startsWith = string.startsWith("//");
    boolean _not = (!_startsWith);
    if (_not) {
      throw new ValueConverterException("Invalid Single Line Comment", node, null);
    }
    return string.substring(2, string.length());
  }
}
