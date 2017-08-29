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
package gov.nasa.jpl.imce.oml.model.datatypes;

import com.google.common.base.Objects;

/**
 * https://www.w3.org/TR/xmlschema11-2/#language
 * https://tools.ietf.org/rfc/bcp/bcp47
 * http://www.ietf.org/rfc/rfc4646.txt
 * http://www.ietf.org/rfc/rfc4647.txt
 * 
 * [a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})
 */
@SuppressWarnings("all")
public class LanguageTagValue {
  public String value;
  
  public LanguageTagValue(final String value) {
    this.value = value;
  }
  
  @Override
  public boolean equals(final Object that) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (that instanceof LanguageTagValue) {
      _matched=true;
      _switchResult = Objects.equal(this.value, ((LanguageTagValue)that).value);
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
