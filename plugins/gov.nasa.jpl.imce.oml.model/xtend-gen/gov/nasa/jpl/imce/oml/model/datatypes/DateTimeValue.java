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
 * https://www.w3.org/TR/xmlschema11-2/#rf-lexicalMappings-datetime
 * 
 * dateTimeLexicalRep ::= yearFrag '-' monthFrag '-' dayFrag 'T' ((hourFrag ':' minuteFrag ':' secondFrag) | endOfDayFrag) timezoneFrag?
 * 
 * [56]   yearFrag ::= '-'? (([1-9] digit digit digit+) | ('0' digit digit digit))
 * [57]   monthFrag ::= ('0' [1-9]) | ('1' [0-2])
 * [58]   dayFrag ::= ('0' [1-9]) | ([12] digit) | ('3' [01])
 * [59]   hourFrag ::= ([01] digit) | ('2' [0-3])
 * [60]   minuteFrag ::= [0-5] digit
 * [61]   secondFrag ::= ([0-5] digit) ('.' digit+)?
 * [62]   endOfDayFrag ::= '24:00:00' ('.' '0'+)?
 * [63]   timezoneFrag ::= 'Z' | ('+' | '-') (('0' digit | '1' [0-3]) ':' minuteFrag | '14:00')
 */
@SuppressWarnings("all")
public class DateTimeValue {
  public String value;
  
  public DateTimeValue(final String value) {
    this.value = value;
  }
  
  @Override
  public boolean equals(final Object that) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (that instanceof DateTimeValue) {
      _matched=true;
      _switchResult = Objects.equal(this.value, ((DateTimeValue)that).value);
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  @Override
  public String toString() {
    return this.value;
  }
}
