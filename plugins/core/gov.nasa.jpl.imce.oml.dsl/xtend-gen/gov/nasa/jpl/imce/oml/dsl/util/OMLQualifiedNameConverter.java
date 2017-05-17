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

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

@SuppressWarnings("all")
public class OMLQualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {
  @Override
  public String toString(final QualifiedName qualifiedName) {
    String _xblockexpression = null;
    {
      if ((null == qualifiedName)) {
        throw new IllegalArgumentException("Qualified name cannot be null");
      }
      _xblockexpression = qualifiedName.toString(this.getDelimiter());
    }
    return _xblockexpression;
  }
  
  @Override
  public String getDelimiter() {
    return ":";
  }
  
  @Override
  public QualifiedName toQualifiedName(final String qualifiedNameAsString) {
    return super.toQualifiedName(qualifiedNameAsString);
  }
}
