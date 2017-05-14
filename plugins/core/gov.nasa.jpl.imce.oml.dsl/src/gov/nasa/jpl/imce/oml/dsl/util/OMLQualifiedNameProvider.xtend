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
package gov.nasa.jpl.imce.oml.dsl.util

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.terminologies.Term
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance

class OMLQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Inject IQualifiedNameConverter qnc

	def QualifiedName qualifiedName(AnnotationProperty ap) {
		return qnc.toQualifiedName('AnnotationProperty<'+ap.iri+'>')
	}
	
	def QualifiedName qualifiedName(Term term) {
		return qnc.toQualifiedName(term.abbrevIRI)
	}
	
	def QualifiedName qualifiedName(ConceptualEntitySingletonInstance i) {
		return qnc.toQualifiedName(i.abbrevIRI)
	}
	
	def QualifiedName qualifiedName(ModuleEdge edge) {
		return qnc.toQualifiedName(OMLExtensions.kind(edge)+'('+edge.sourceModule()?.iri()+'->'+edge.targetModule()?.iri()+')')
	}
	
	def QualifiedName qualifiedName(DescriptionBox m) {
		return qnc.toQualifiedName(m.kind.toString+' '+OMLExtensions.kind(m)+'<'+m.iri()+'>')
	}
	
	def QualifiedName qualifiedName(Bundle m) {
		return qnc.toQualifiedName(m.kind.toString+' '+OMLExtensions.kind(m)+'<'+m.iri()+'>')
	}
	
	def QualifiedName qualifiedName(TerminologyGraph m) {
		return qnc.toQualifiedName(m.kind.toString+' '+OMLExtensions.kind(m)+'<'+m.iri()+'>')
	}
}