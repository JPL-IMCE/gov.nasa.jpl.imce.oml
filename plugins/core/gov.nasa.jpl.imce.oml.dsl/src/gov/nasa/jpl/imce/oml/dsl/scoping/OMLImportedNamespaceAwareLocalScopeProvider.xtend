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
package gov.nasa.jpl.imce.oml.dsl.scoping

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.dsl.util.OMLImportNormalizer
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage
import gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.CommonPackage
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.ImportNormalizer
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializedReifiedRelationship

class OMLImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	
	@Inject IQualifiedNameConverter qnc
		
	override def List<ImportNormalizer> getImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		val res = new ArrayList<ImportNormalizer>();
		switch context {
			Bundle: {
				for (ap : context.annotationProperties) {
					res.add(new OMLImportNormalizer(qnc.toQualifiedName(ap.iri()), ap.abbrevIRI))
				}
				for (e : context.boxAxioms) {
					res.add(new OMLImportNormalizer(qnc.toQualifiedName(e?.target?.iri()?:""), e.target?.name?:""))
				}
				for (e : context.bundleAxioms) {
					res.add(new OMLImportNormalizer(qnc.toQualifiedName(e?.target?.iri()?:""), e.target?.name?:""))
				}
			}
			TerminologyGraph: {
				for (ap : context.annotationProperties) {
					res.add(new OMLImportNormalizer(qnc.toQualifiedName(ap.iri()), ap.abbrevIRI))
				}
				for (e : context.boxAxioms) {
					res.add(new OMLImportNormalizer(qnc.toQualifiedName(e?.target?.iri()?:""), e.target?.name?:""))
				}
			}
			DescriptionBox: {
				for (ap : context.annotationProperties) {
					res.add(new OMLImportNormalizer(qnc.toQualifiedName(ap.iri()), ap.abbrevIRI))
				}
				for (e : context.closedWorldDefinitions) {
					res.add(new OMLImportNormalizer(qnc.toQualifiedName(e?.closedWorldDefinitions?.iri()?:""), e.closedWorldDefinitions?.name?:""))
				}
				for (e : context.descriptionBoxRefinements) {
					res.add(new OMLImportNormalizer(qnc.toQualifiedName(e?.refinedDescriptionBox?.iri()?:""), e.refinedDescriptionBox?.name?:""))
				}
			}
		}
		res.addAll(super.getImportedNamespaceResolvers(context, ignoreCase));
		
		
		return res;
	}
	
	@Inject extension OMLScopeExtensions
	
	override protected getImportedNamespace(EObject object) {
		switch object {
			ModuleEdge:
				object.targetModule?.iri()	
			default:
				super.getImportedNamespace(object)
		}	
	}
	
 	override getScope(EObject context, EReference reference) {
 		var IScope scope = null
		switch context {
 			AnnotationPropertyValue:
 				if (reference == CommonPackage.eINSTANCE.annotationPropertyValue_Property) {
 					scope = scope_Annotation_property(context, reference)
				}
					
			TerminologyExtensionAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.terminologyExtensionAxiom_ExtendedTerminology)
					scope = context.tbox.allTerminologies
				
			SpecializedReifiedRelationship:
				if (reference == TerminologiesPackage.eINSTANCE.entityRelationship_Source ||
					reference == TerminologiesPackage.eINSTANCE.entityRelationship_Target)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.specializedReifiedRelationship_General)
					scope = context.tbox.allConceptualRelationshipsScope
				
			EntityRelationship:
				if (reference == TerminologiesPackage.eINSTANCE.entityRelationship_Source ||
					reference == TerminologiesPackage.eINSTANCE.entityRelationship_Target)
					scope = context.tbox.allEntitiesScope
					
			AspectSpecializationAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.aspectSpecializationAxiom_SubEntity)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.aspectSpecializationAxiom_SuperAspect)
					scope = context.getTbox.allAspectsScope
					
			ConceptSpecializationAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.conceptSpecializationAxiom_SubConcept)
					scope = context.tbox.allConceptsScope
				else if (reference == TerminologiesPackage.eINSTANCE.conceptSpecializationAxiom_SuperConcept)
					scope = context.tbox.allConceptsScope
					
			SubObjectPropertyOfAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.subObjectPropertyOfAxiom_SubProperty)
					scope = context.tbox.allUnreifiedRelationshipsScope
				else if (reference == TerminologiesPackage.eINSTANCE.subObjectPropertyOfAxiom_SuperProperty)
					scope = context.tbox.allUnreifiedRelationshipsScope
					
			SubDataPropertyOfAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.subDataPropertyOfAxiom_SubProperty)
					scope = context.tbox.allEntityScalarDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.subDataPropertyOfAxiom_SuperProperty)
					scope = context.tbox.allEntityScalarDataPropertiesScope
					
			RestrictedDataRange:
				if (reference == TerminologiesPackage.eINSTANCE.restrictedDataRange_RestrictedRange)
					scope = context.tbox.allRangesScope
				
			EntityScalarDataProperty:
				if (reference == TerminologiesPackage.eINSTANCE.dataRelationshipFromEntity_Domain)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.dataRelationshipToScalar_Range)
					scope = context.tbox.allRangesScope
					
			EntityStructuredDataProperty:
				if (reference == TerminologiesPackage.eINSTANCE.dataRelationshipFromEntity_Domain)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.dataRelationshipToStructure_Range)
					scope = context.tbox.allStructuresScope
					
			ScalarDataProperty:
				if (reference == TerminologiesPackage.eINSTANCE.dataRelationshipFromStructure_Domain)
					scope = context.tbox.allStructuresScope
				else if (reference == TerminologiesPackage.eINSTANCE.dataRelationshipToScalar_Range)
					scope = context.tbox.allRangesScope
				
			StructuredDataProperty:
				if (reference == TerminologiesPackage.eINSTANCE.dataRelationshipFromStructure_Domain)
					scope = context.tbox.allStructuresScope
				else if (reference == TerminologiesPackage.eINSTANCE.dataRelationshipToStructure_Range)
					scope = context.tbox.allStructuresScope
				
			ChainRule:
				if (reference == TerminologiesPackage.eINSTANCE.chainRule_Head)
					scope = context.tbox.allUnreifiedRelationshipsScope
					
			SegmentPredicate:
				if (reference == TerminologiesPackage.eINSTANCE.segmentPredicate_Predicate)
					scope = context.getBodySegment?.chainRule?.tbox?.allPredicatesScope
				else if (reference == TerminologiesPackage.eINSTANCE.segmentPredicate_ReifiedRelationshipInverseSource)
					scope = context.getBodySegment?.chainRule?.tbox?.allReifiedRelationshipsScope
				else if (reference == TerminologiesPackage.eINSTANCE.segmentPredicate_ReifiedRelationshipInverseTarget)
					scope = context.getBodySegment?.chainRule?.tbox?.allReifiedRelationshipsScope
				else if (reference == TerminologiesPackage.eINSTANCE.segmentPredicate_ReifiedRelationshipSource)
					scope = context.getBodySegment?.chainRule?.tbox?.allReifiedRelationshipsScope
				else if (reference == TerminologiesPackage.eINSTANCE.segmentPredicate_ReifiedRelationshipTarget)
					scope = context.getBodySegment?.chainRule?.tbox?.allReifiedRelationshipsScope
				else if (reference == TerminologiesPackage.eINSTANCE.segmentPredicate_UnreifiedRelationshipInverse)
					scope = context.getBodySegment?.chainRule?.tbox?.allUnreifiedRelationshipsScope
				
			EntityRestrictionAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.entityRestrictionAxiom_RestrictedRelationship)
					scope = context.tbox.allRestrictableRelationshipsScope
				else if (reference == TerminologiesPackage.eINSTANCE.entityRestrictionAxiom_RestrictedDomain)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.entityRestrictionAxiom_RestrictedRange)
					scope = context.tbox.allEntitiesScope
				
			EntityScalarDataPropertyExistentialRestrictionAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyRestrictionAxiom_RestrictedEntity)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyRestrictionAxiom_ScalarProperty)
					scope = context.tbox.allEntityScalarDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyExistentialRestrictionAxiom_ScalarRestriction)
					scope = context.tbox.allRangesScope
				
			EntityScalarDataPropertyParticularRestrictionAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyRestrictionAxiom_RestrictedEntity)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyRestrictionAxiom_ScalarProperty)
					scope = context.tbox.allEntityScalarDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyParticularRestrictionAxiom_ValueType)
					scope = context.tbox.allRangesScope
			
			EntityScalarDataPropertyUniversalRestrictionAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyRestrictionAxiom_RestrictedEntity)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyRestrictionAxiom_ScalarProperty)
					scope = context.tbox.allEntityScalarDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.entityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction)
					scope = context.tbox.allRangesScope
				
			EntityStructuredDataPropertyParticularRestrictionAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.entityStructuredDataPropertyRestrictionAxiom_RestrictedEntity)
					scope = context.tbox.allEntitiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.restrictionStructuredDataPropertyContext_StructuredDataProperty)
					scope = context.tbox.allEntityStructuredDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.restrictionStructuredDataPropertyContext_ScalarDataPropertyRestrictions)
					scope = context.tbox.allScalarDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.restrictionStructuredDataPropertyContext_StructuredDataPropertyRestrictions)
					scope = context.tbox.allStructuredDataPropertiesScope
			
			RestrictionStructuredDataPropertyTuple:
				if (reference == TerminologiesPackage.eINSTANCE.restrictionStructuredDataPropertyContext_StructuredDataProperty)
					scope = context.terminologyBox()?.allEntityStructuredDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.restrictionStructuredDataPropertyContext_ScalarDataPropertyRestrictions)
					scope = context.terminologyBox()?.allScalarDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.restrictionStructuredDataPropertyContext_StructuredDataPropertyRestrictions)
					scope = context.terminologyBox()?.allStructuredDataPropertiesScope
			
			RestrictionScalarDataPropertyValue:
				if (reference == TerminologiesPackage.eINSTANCE.restrictionScalarDataPropertyValue_ScalarDataProperty)
					scope = context.terminologyBox()?.allScalarDataPropertiesScope
				else if (reference == TerminologiesPackage.eINSTANCE.restrictionScalarDataPropertyValue_ValueType)
					scope = context.terminologyBox()?.allRangesScope
					
			ScalarOneOfLiteralAxiom:
				if (reference == TerminologiesPackage.eINSTANCE.scalarOneOfLiteralAxiom_Axiom)
					scope = context.tbox.allScalarOneOfRestrictionsScope
				else if (reference == TerminologiesPackage.eINSTANCE.scalarOneOfLiteralAxiom_ValueType)
					scope = context.tbox.allRangesScope
				
			RootConceptTaxonomyAxiom:
				if (reference == BundlesPackage.eINSTANCE.rootConceptTaxonomyAxiom_Root)
					scope = context.bundle.allConceptsScope
					
			SpecificDisjointConceptAxiom:
				if (reference == BundlesPackage.eINSTANCE.specificDisjointConceptAxiom_DisjointLeaf)
					scope = context.disjointTaxonomyParent.bundleContainer().allConceptsScope
				
			DisjointUnionOfConceptsAxiom:
				{}
				
			BundledTerminologyAxiom:
				if (reference == BundlesPackage.eINSTANCE.bundledTerminologyAxiom_BundledTerminology)
					scope = scope_BundledTerminologyAxiom_bundledTerminology(context)
					
			ConceptDesignationTerminologyAxiom:
				if (reference == GraphsPackage.eINSTANCE.conceptDesignationTerminologyAxiom_DesignatedTerminology)
					scope = scope_ConceptDesignationTerminologyAxiom_designatedTerminology(context)
				else if (reference == GraphsPackage.eINSTANCE.conceptDesignationTerminologyAxiom_DesignatedConcept)
					scope = scope_ConceptDesignationTerminologyAxiom_designatedConcept(context)
					
			TerminologyNestingAxiom:
				if (reference == GraphsPackage.eINSTANCE.terminologyNestingAxiom_NestingTerminology)
					scope = context.tbox.allTerminologies
				else if (reference == GraphsPackage.eINSTANCE.terminologyNestingAxiom_NestingContext)
					scope = context.tbox.allConceptsScope
					
			DescriptionBoxExtendsClosedWorldDefinitions:
				if (reference == DescriptionsPackage.eINSTANCE.descriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions)
					scope = context.descriptionBox.allTerminologies
				
			DescriptionBoxRefinement:
				if (reference == DescriptionsPackage.eINSTANCE.descriptionBoxRefinement_RefinedDescriptionBox)
					scope = context.descriptionDomain.allDescriptions
					
			SingletonInstanceScalarDataPropertyValue:
				if (reference == DescriptionsPackage.eINSTANCE.singletonInstanceScalarDataPropertyValue_SingletonInstance)
					scope = context.descriptionBox()?.allConceptualEntitySingletonInstanceScope
				else if (reference == DescriptionsPackage.eINSTANCE.singletonInstanceScalarDataPropertyValue_ScalarDataProperty)
					scope = context.descriptionBox()?.allEntityScalarDataPropertiesScope
				else if (reference == DescriptionsPackage.eINSTANCE.singletonInstanceScalarDataPropertyValue_ValueType)
					scope = context.descriptionBox()?.allRangesScope
					
			SingletonInstanceStructuredDataPropertyValue:
				if (reference == DescriptionsPackage.eINSTANCE.singletonInstanceStructuredDataPropertyValue_SingletonInstance)
					scope = context.descriptionBox()?.allConceptualEntitySingletonInstanceScope
				else if (reference == DescriptionsPackage.eINSTANCE.singletonInstanceStructuredDataPropertyContext_StructuredDataProperty)
					scope = context.descriptionBox()?.allEntityStructuredDataPropertiesScope
					
			StructuredDataPropertyTuple:
				if (reference == DescriptionsPackage.eINSTANCE.singletonInstanceStructuredDataPropertyContext_StructuredDataProperty)
					scope = context.descriptionBox()?.allStructuredDataPropertiesScope
			
			ScalarDataPropertyValue:
				if (reference == DescriptionsPackage.eINSTANCE.scalarDataPropertyValue_ScalarDataProperty)
					scope = context.descriptionBox()?.allScalarDataPropertiesScope
				else if (reference == DescriptionsPackage.eINSTANCE.scalarDataPropertyValue_ValueType)
					scope = context.descriptionBox()?.allRangesScope
			
			ConceptInstance:
				if (reference == DescriptionsPackage.eINSTANCE.conceptInstance_SingletonConceptClassifier)
					scope = context.descriptionBox()?.allConceptsScope		
					
			ReifiedRelationshipInstance:
				if (reference == DescriptionsPackage.eINSTANCE.reifiedRelationshipInstance__ConceptualEntitySingletonClassifier)
					scope = context.descriptionBox()?.allReifiedRelationshipScope
					
			ReifiedRelationshipInstanceDomain:
				if (reference == DescriptionsPackage.eINSTANCE.reifiedRelationshipInstanceDomain_ReifiedRelationshipInstance)
					scope = context.descriptionBox()?.allReifiedRelationshipInstancesScope
				else if (reference == DescriptionsPackage.eINSTANCE.reifiedRelationshipInstanceDomain_Domain)
					scope = context.descriptionBox()?.allConceptualEntitySingletonInstanceScope
					
			ReifiedRelationshipInstanceRange:
				if (reference == DescriptionsPackage.eINSTANCE.reifiedRelationshipInstanceRange_ReifiedRelationshipInstance)
					scope = context.descriptionBox()?.allReifiedRelationshipInstancesScope
				else if (reference == DescriptionsPackage.eINSTANCE.reifiedRelationshipInstanceRange_Range)
					scope = context.descriptionBox()?.allConceptualEntitySingletonInstanceScope
					
			UnreifiedRelationshipInstanceTuple:
				if (reference == DescriptionsPackage.eINSTANCE.unreifiedRelationshipInstanceTuple_UnreifiedRelationship)
					scope = context.descriptionBox()?.allUnreifiedRelationshipScope
				else if (reference == DescriptionsPackage.eINSTANCE.unreifiedRelationshipInstanceTuple_Domain)
					scope = context.descriptionBox()?.allConceptualEntitySingletonInstanceScope
				else if (reference == DescriptionsPackage.eINSTANCE.unreifiedRelationshipInstanceTuple_Range)
					scope = context.descriptionBox()?.allConceptualEntitySingletonInstanceScope
					
		} 
		if (null !== scope)
			scope
		else
			super.getScope(context, reference)
	}
	
	
}