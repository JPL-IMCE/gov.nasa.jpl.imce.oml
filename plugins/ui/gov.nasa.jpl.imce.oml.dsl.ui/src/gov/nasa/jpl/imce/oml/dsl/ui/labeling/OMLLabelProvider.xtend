/*
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
package gov.nasa.jpl.imce.oml.dsl.ui.labeling

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Term
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class OMLLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	def text(AnnotationProperty e) {
		'AnnotationProperty ' + e.abbrevIRI
	}

	def text(AnnotationPropertyValue a) {
		(doGetText(a.subject)?.toString ?: '') + '@' + (a.property?.abbrevIRI ?: '') + ' = ...'
	}

	def text(Term e) {
		OMLExtensions.kind(e) + '(' + (e.abbrevIRI() ?: "") + ')'
	}

	def text(ConceptualEntitySingletonInstance e) {
		OMLExtensions.kind(e) + '(' + (e.abbrevIRI() ?: "") + ')'
	}

	def text(ModuleEdge e) {
		OMLExtensions.kind(e) + '(' + (e.sourceModule()?.nsPrefix() ?: "") + '->' +
			(e.targetModule()?.nsPrefix() ?: "") + ')'
	}

	def text(DescriptionBox m) {
		m.kind.toString + ' ' + OMLExtensions.kind(m) + '(' + m.nsPrefix() + ')'
	}

	def text(Bundle m) {
		m.kind.toString + ' ' + OMLExtensions.kind(m) + '(' + m.nsPrefix() + ')'
	}

	def text(TerminologyGraph m) {
		m.kind.toString + ' ' + OMLExtensions.kind(m) + '(' + m.nsPrefix() + ')'
	}

	def text(EntityExistentialRestrictionAxiom ax) {
		'someEntities ' + (ax.restrictedRelation?.abbrevIRI() ?: "") + '.' + (ax.restrictedDomain?.abbrevIRI() ?: "") +
			' in ' + ax.restrictedRange?.abbrevIRI() ?: ""
	}

	def text(EntityUniversalRestrictionAxiom ax) {
		'allEntities ' + (ax.restrictedRelation?.abbrevIRI() ?: "") + '.' + (ax.restrictedDomain?.abbrevIRI() ?: "") +
			' in ' + ax.restrictedRange?.abbrevIRI() ?: ""
	}

	def text(EntityScalarDataPropertyExistentialRestrictionAxiom ax) {
		'someData ' + (ax.restrictedEntity?.abbrevIRI() ?: "") + '.' + (ax.scalarProperty?.abbrevIRI() ?: "") + ' in ' +
			ax.scalarRestriction?.abbrevIRI() ?: ""
	}

	def text(EntityScalarDataPropertyUniversalRestrictionAxiom ax) {
		'allData ' + (ax.restrictedEntity?.abbrevIRI() ?: "") + '.' + (ax.scalarProperty?.abbrevIRI() ?: "") + ' in ' +
			ax.scalarRestriction?.abbrevIRI() ?: ""
	}

	def text(EntityScalarDataPropertyParticularRestrictionAxiom ax) {
		'allData ' + (ax.restrictedEntity?.abbrevIRI() ?: "") + '.' + (ax.scalarProperty?.abbrevIRI() ?: "") + ' = ...'
	}

	def text(ScalarOneOfLiteralAxiom ax) {
		'oneOf ' + text(ax.axiom?.abbrevIRI ?: "") + ' = ' + ax.value
	}

	def text(SpecializationAxiom ax) {
		OMLExtensions.kind(ax) + ' ' + (ax.child()?.abbrevIRI() ?: "") + ' <: ' + ax.parent()?.abbrevIRI() ?: ""
	}

	def text(SingletonInstanceStructuredDataPropertyValue e) {
		(e.singletonInstance?.abbrevIRI ?: "") + ' . ' + (e.structuredDataProperty?.abbrevIRI ?: "")
	}

	def text(SingletonInstanceScalarDataPropertyValue e) {
		(e.singletonInstance?.abbrevIRI ?: "") + ' . ' + (e.scalarDataProperty?.abbrevIRI ?: "") + ' = ' +
			e.scalarPropertyValue
	}

	def text(SingletonInstanceStructuredDataPropertyContext e) {
		' . ' + e.structuredDataProperty.abbrevIRI ?: ""
	}

	def text(StructuredDataPropertyTuple e) {
		' . ' + e.structuredDataProperty.abbrevIRI ?: ""
	}

	def text(ScalarDataPropertyValue e) {
		' . ' + (e.scalarDataProperty?.abbrevIRI ?: "") + ' = ' + e.scalarPropertyValue
	}

	def text(ReifiedRelationshipInstanceDomain e) {
		'domain(' + (e.reifiedRelationshipInstance?.abbrevIRI ?: "") + ') = ' + e.domain?.abbrevIRI ?: ""
	}

	def text(ReifiedRelationshipInstanceRange e) {
		'range(' + (e.reifiedRelationshipInstance?.abbrevIRI ?: "") + ') = ' + e.range?.abbrevIRI ?: ""
	}

	def text(UnreifiedRelationshipInstanceTuple e) {
		'tuple(' + (e.domain?.abbrevIRI ?: "") + ' . ' + (e.unreifiedRelationship?.abbrevIRI ?: "") + ' ) = ' +
			e.range?.abbrevIRI ?: ""
	}

}
