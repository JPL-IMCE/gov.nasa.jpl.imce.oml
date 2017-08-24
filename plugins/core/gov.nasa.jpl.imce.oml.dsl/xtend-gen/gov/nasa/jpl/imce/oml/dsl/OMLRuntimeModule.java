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
package gov.nasa.jpl.imce.oml.dsl;

import gov.nasa.jpl.imce.oml.dsl.AbstractOMLRuntimeModule;
import gov.nasa.jpl.imce.oml.dsl.formatting2.OMLFormatter;
import gov.nasa.jpl.imce.oml.dsl.linking.OMLLinkingService;
import gov.nasa.jpl.imce.oml.dsl.scoping.OMLImportedNamespaceAwareLocalScopeProvider;
import gov.nasa.jpl.imce.oml.dsl.serializer.OMLCrossReferenceSerializer;
import gov.nasa.jpl.imce.oml.dsl.services.OMLGrammarAccess;
import gov.nasa.jpl.imce.oml.dsl.util.OMLQualifiedNameConverter;
import gov.nasa.jpl.imce.oml.dsl.util.OMLQualifiedNameProvider;
import gov.nasa.jpl.imce.oml.dsl.util.OMLValueConverterService;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class OMLRuntimeModule extends AbstractOMLRuntimeModule {
  @Override
  public Class<? extends ILinkingService> bindILinkingService() {
    return OMLLinkingService.class;
  }
  
  @Override
  public Class<? extends IScopeProvider> bindIScopeProvider() {
    return OMLImportedNamespaceAwareLocalScopeProvider.class;
  }
  
  @Override
  public Class<? extends IValueConverterService> bindIValueConverterService() {
    return OMLValueConverterService.class;
  }
  
  @Override
  public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
    return OMLQualifiedNameProvider.class;
  }
  
  public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
    return OMLQualifiedNameConverter.class;
  }
  
  @Override
  public Class<? extends IGrammarAccess> bindIGrammarAccess() {
    return OMLGrammarAccess.class;
  }
  
  @Override
  public Class<? extends IFormatter2> bindIFormatter2() {
    return OMLFormatter.class;
  }
  
  public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
    return OMLCrossReferenceSerializer.class;
  }
}
