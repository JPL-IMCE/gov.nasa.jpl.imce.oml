/*
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
package gov.nasa.jpl.imce.oml.dsl

import gov.nasa.jpl.imce.oml.dsl.linking.OWLLinkingService
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.linking.ILinkingService
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.formatting2.IFormatter2
import gov.nasa.jpl.imce.oml.dsl.formatting2.OntologicalModelingLanguageFormatter
import org.eclipse.xtext.IGrammarAccess
import gov.nasa.jpl.imce.oml.dsl.scoping.OMLImportedNamespaceAwareLocalScopeProvider
import gov.nasa.jpl.imce.oml.dsl.util.OMLValueConverterService
import gov.nasa.jpl.imce.oml.dsl.util.OMLQualifiedNameConverter
import gov.nasa.jpl.imce.oml.dsl.util.OMLQualifiedNameProvider
import gov.nasa.jpl.imce.oml.dsl.services.OntologicalModelingLanguageGrammarAccess
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer
import gov.nasa.jpl.imce.oml.dsl.serializer.OntologicalModelingLanguageCrossReferenceSerializer

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class OntologicalModelingLanguageRuntimeModule extends AbstractOntologicalModelingLanguageRuntimeModule {
	
	override def Class<? extends ILinkingService> bindILinkingService() {
		OWLLinkingService
	}
	
	override def Class<? extends IScopeProvider> bindIScopeProvider() {
		OMLImportedNamespaceAwareLocalScopeProvider
	}
	
    override def Class<? extends IValueConverterService> bindIValueConverterService() {
        OMLValueConverterService
    }

    override def Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
        OMLQualifiedNameProvider
    }

	def Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
	    OMLQualifiedNameConverter
	}
	
	override def Class<? extends IGrammarAccess> bindIGrammarAccess() {
		OntologicalModelingLanguageGrammarAccess
	}
	
	override def Class<? extends IFormatter2> bindIFormatter2() {
		OntologicalModelingLanguageFormatter
	}
	
	def Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		OntologicalModelingLanguageCrossReferenceSerializer
	}
	
}
