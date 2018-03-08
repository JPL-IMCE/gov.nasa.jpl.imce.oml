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

import com.google.common.base.Function
import com.google.common.collect.Lists
import com.google.common.collect.Sets
import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.common.LogicalElement
import gov.nasa.jpl.imce.oml.model.common.Module
import gov.nasa.jpl.imce.oml.model.common.Resource
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import java.util.ArrayList
import java.util.HashMap
import java.util.Set
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.emf.ecore.EObject

class OMLScopeExtensions {
	
	@Inject extension OMLExtensions
	
	static val RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE = "RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE"
	static val RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE"
	
	static def void clearCache(ResourceSet rs) {
		rs.loadOptions.remove(RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE)
		rs.loadOptions.remove(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE)
	}
	
	static def void initializeCache(ResourceSet rs) {
		rs.loadOptions.put(RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE, new HashMap<Module, HashMap<Resource, QualifiedName>>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE, new HashMap<Module, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE, new HashMap<DescriptionBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE, new HashMap<TerminologyBox, IScope>())
		rs.loadOptions.put(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE, new HashMap<TerminologyBox, IScope>())
	}
	
	static def HashMap<Module, HashMap<Resource, QualifiedName>> lookupImportedResourceNameCache(ResourceSet rs) {
		val cache = rs.loadOptions.get(RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE)
		switch cache {
			HashMap<Module, HashMap<Resource, QualifiedName>>:
				cache
		}
	}
	
	static def HashMap<Module, HashMap<Resource, QualifiedName>> lookupImportedResourceNameCache(EObject e) {
		val rs = e?.eResource?.resourceSet
		if (null !== rs)
			lookupImportedResourceNameCache(rs)
		else
			null
	}
	
	static def HashMap<Module, IScope> lookupAllTerminologiesCache(Module m) {
		val cache = m?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE)
		switch cache {
			HashMap<Module, IScope>:
				cache
		}
	}
	
	static def HashMap<DescriptionBox, IScope> lookupAllDescriptionsCache(DescriptionBox m) {
		val cache = m?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE)
		switch cache {
			HashMap<DescriptionBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllEntitiesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllRangesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllStructuresCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllAspectsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllConceptsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllConceptualRelationshipsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllReifiedRelationshipRestrictionsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllReifiedRelationshipsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllUnreifiedRelationshipsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllEntityRelationshipsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllPredicatesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllForwardPropertiesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllInversePropertiesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllRestrictableRelationshipsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllEntityScalarDataPropertiesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllEntityStructuredDataPropertiesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllScalarDataPropertiesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllStructuredDataPropertiesCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	static def HashMap<TerminologyBox, IScope> lookupAllScalarOneOfRestrictionsCache(TerminologyBox tbox) {
		val cache = tbox?.eResource?.resourceSet?.loadOptions?.get(RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE)
		switch cache {
			HashMap<TerminologyBox, IScope>:
				cache
		}
	}
	
	@Inject IQualifiedNameConverter qnc
	
	/*
	 * The syntax of Annotation involves "@<annotation property abbrev IRI> = <annotation value>".
	 * Therefore, construct the resolvable scope of AnnotationProperties
	 * in terms of the abbrevIRI of each AnnotationProperty accessible from all imported modules.
	 * 
	 * This scope computation accounts for possible parsing errors resulting in EFeature values being null.
	 */
	def scope_Annotation_property(AnnotationPropertyValue annotation, EReference eRef) {
		val modules =
			annotation.subject?. // may be null!
			moduleContext?. // may be null!
			allImportedModules?. // may be null!
			filterNull // remove nulls!
		val annoationProperties = modules.map[annotationProperties]?. // may be null!
			flatten?. // may be null!
			filterNull // remove nulls!
		Scopes.scopeFor(annoationProperties, [qnc.toQualifiedName(it.abbrevIRI)], IScope.NULLSCOPE)
	}
	
	def scope_BundledTerminologyAxiom_bundledTerminology(BundledTerminologyAxiom context) {
		val exts = context.eResource.resourceSet.resources.map[contents.filter(Extent)].flatten
		val tboxes = exts.map[terminologyGraphs + bundles].flatten
		Scopes.scopeFor(
			tboxes,
			[ qnc.toQualifiedName(it.nsPrefix) ],
			IScope.NULLSCOPE)	
	}
	
	def scope_ConceptDesignationTerminologyAxiom_designatedTerminology(ConceptDesignationTerminologyAxiom context) {
		val exts = context.eResource.resourceSet.resources.map[contents.filter(Extent)].flatten
		val tboxes = exts.map[terminologyGraphs + bundles].flatten
		Scopes.scopeFor(
			tboxes,
			[ qnc.toQualifiedName(it.nsPrefix) ],
			IScope.NULLSCOPE)	
	}
	
	def scope_ConceptDesignationTerminologyAxiom_designatedConcept(ConceptDesignationTerminologyAxiom context) {
		context.designatedTerminology.allConceptsScope
	}
	
	def IScope allTerminologies(TerminologyBox context) {
		val cache = lookupAllTerminologiesCache(context)
		cache?.computeIfAbsent(context, [computeAllTerminologies]) ?: computeAllTerminologies(context)
	}
	
	def IScope allTerminologies(DescriptionBox context) {
		val cache = lookupAllTerminologiesCache(context)
		cache?.computeIfAbsent(context, [computeAllTerminologies]) ?: computeAllTerminologies(context)
	}
	
	private def IScope computeAllTerminologies(Module context) {
		val exts = context.eResource.resourceSet.resources.map[contents.filter(Extent)].flatten
		val tboxes = exts.map[terminologyGraphs + bundles].flatten
		Scopes.scopeFor(
			tboxes,
			[qnc.toQualifiedName(it.nsPrefix) ], 
			IScope.NULLSCOPE)
	}
	
	def IScope allDescriptions(DescriptionBox context) {
		val cache = lookupAllDescriptionsCache(context)
		cache?.computeIfAbsent(context, [computeAllDescriptions]) ?: computeAllDescriptions(context)
	}
	
	private def IScope computeAllDescriptions(DescriptionBox context) {
		val exts = context.eResource.resourceSet.resources.map[contents.filter(Extent)].flatten
		val tboxes = exts.map[descriptions].flatten
		Scopes.scopeFor(
			tboxes,
			[qnc.toQualifiedName(it.nsPrefix) ], 
			IScope.NULLSCOPE)
	}
	
	// =================================================
	
	/*
	 * Computes an IScope for 
	 */
	def <T extends LogicalElement> IScope terminologyScope(
		TerminologyBox tbox,
		Function<TerminologyBox, Iterable<T>> localScopeFunction,
		Function<Pair<TerminologyBox, T>, QualifiedName> nameFunction
	) {
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		result.addAll(Scopes.scopedElementsFor(localScopeFunction.apply(tbox)))
		result.addAll(OMLExtensions.allImportedTerminologies(tbox).map[importedTbox|
			Scopes.scopedElementsFor(
				localScopeFunction.apply(importedTbox), 
				[importedThing| nameFunction.apply(Pair.of(importedTbox, importedThing)) ]
			)
		].flatten)
		new SimpleScope(result)
	}
	
	/*
	 * This method can be invoked very often for large models.
	 * To enable read-only cache optimization, invoke OMLLinkingService.initializeCache(ResourceSet)
	 */
	def <T extends Resource> QualifiedName importedResourceNameFunction(Pair<TerminologyBox, T> p) {
		val importedResourceNameCache = lookupImportedResourceNameCache(p.key)
		if (null !== importedResourceNameCache) {
			val nameMap = importedResourceNameCache.computeIfAbsent(p.key, [new HashMap<Resource, QualifiedName>()])
			nameMap.computeIfAbsent(p.value, [qnc.toQualifiedName(p.key.nsPrefix + ":" + p.value.name())])
		} else
			qnc.toQualifiedName(p.key.nsPrefix + ":" + p.value.name())
	}
	
	/*
	 * This method can be invoked very often for large models.
	 * To enable read-only cache optimization, invoke OMLLinkingService.initializeCache(ResourceSet)
	 */
	def <T extends Resource> QualifiedName importedBundleNameFunction(Pair<Bundle, T> p) {
		val importedResourceNameCache = lookupImportedResourceNameCache(p.key)
		if (null !== importedResourceNameCache) {
			val nameMap = importedResourceNameCache.computeIfAbsent(p.key, [new HashMap<Resource, QualifiedName>()])
			nameMap.computeIfAbsent(p.value, [qnc.toQualifiedName(p.key.nsPrefix + ":" + p.value.name())])
		} else
			qnc.toQualifiedName(p.key.nsPrefix + ":" + p.value.name())
	}
	
	/*
	 * This method can be invoked very often for large models.
	 * To enable read-only cache optimization, invoke OMLLinkingService.initializeCache(ResourceSet)
	 */
	def <T extends Resource> QualifiedName importedDescriptionNameFunction(Pair<DescriptionBox, T> p) {
		val importedResourceNameCache = lookupImportedResourceNameCache(p.key)
		if (null !== importedResourceNameCache) {
			val nameMap = importedResourceNameCache.computeIfAbsent(p.key, [new HashMap<Resource, QualifiedName>()])
			nameMap.computeIfAbsent(p.value, [qnc.toQualifiedName(p.key.nsPrefix + ":" + p.value.name())])
		} else
			qnc.toQualifiedName(p.key.nsPrefix + ":" + p.value.name())
	}
	
	def IScope allEntitiesScope(TerminologyBox tbox) {
		val cache = lookupAllEntitiesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllEntities]) ?: computeAllEntities(tbox)
	}
	
	private def IScope computeAllEntities(TerminologyBox tbox) {
		terminologyScope(tbox, [localEntities], [importedResourceNameFunction])
	}
	
	def IScope allRangesScope(TerminologyBox tbox) {
		val cache = lookupAllRangesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllRanges]) ?: computeAllRanges(tbox)
	}
	
	private def IScope computeAllRanges(TerminologyBox tbox) {
		terminologyScope(tbox, [localRanges], [importedResourceNameFunction])
	}
	
	def IScope allStructuresScope(TerminologyBox tbox) {
		val cache = lookupAllStructuresCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllStructures]) ?: computeAllStructures(tbox)
	}
	
	private def IScope computeAllStructures(TerminologyBox tbox) {
		terminologyScope(tbox, [localStructures], [importedResourceNameFunction])
	}
	
	def IScope allAspectsScope(TerminologyBox tbox) {
		val cache = lookupAllAspectsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllAspects]) ?: computeAllAspects(tbox)
	}
	
	private def IScope computeAllAspects(TerminologyBox tbox) {
		terminologyScope(tbox, [localAspects], [importedResourceNameFunction])
	}
	
	def IScope allConceptsScope(TerminologyBox tbox) {
		val cache = lookupAllConceptsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllConcepts]) ?: computeAllConcepts(tbox)
	}
	
	private def IScope computeAllConcepts(TerminologyBox tbox) {
		terminologyScope(tbox, [localConcepts], [importedResourceNameFunction])
	}
	
	def IScope allConceptualRelationshipsScope(TerminologyBox tbox) {
		val cache = lookupAllConceptualRelationshipsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllConceptualRelationships]) ?: computeAllConceptualRelationships(tbox)
	}
	
	private def IScope computeAllConceptualRelationships(TerminologyBox tbox) {
		terminologyScope(tbox, [localConceptualRelationships], [importedResourceNameFunction])
	}
	
	def IScope allReifiedRelationshipRestrictionsScope(TerminologyBox tbox) {
		val cache = lookupAllReifiedRelationshipRestrictionsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllReifiedRelationshipRestrictions]) ?: computeAllReifiedRelationshipRestrictions(tbox)
	}
	
	private def IScope computeAllReifiedRelationshipRestrictions(TerminologyBox tbox) {
		terminologyScope(tbox, [localReifiedRelationshipRestrictions], [importedResourceNameFunction])
	}
	
	def IScope allReifiedRelationshipsScope(TerminologyBox tbox) {
		val cache = lookupAllReifiedRelationshipsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllReifiedRelationships]) ?: computeAllReifiedRelationships(tbox)
	}
	
	private def IScope computeAllReifiedRelationships(TerminologyBox tbox) {
		terminologyScope(tbox, [localReifiedRelationships], [importedResourceNameFunction])
	}
	
	def IScope allUnreifiedRelationshipsScope(TerminologyBox tbox) {
		val cache = lookupAllUnreifiedRelationshipsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllUnreifiedRelationships]) ?: computeAllUnreifiedRelationships(tbox)
	}
	
	private def IScope computeAllUnreifiedRelationships(TerminologyBox tbox) {
		terminologyScope(tbox, [localUnreifiedRelationships], [importedResourceNameFunction])
	}
	
	def IScope allEntityRelationshipsScope(TerminologyBox tbox) {
		val cache = lookupAllEntityRelationshipsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllEntityRelationships]) ?: computeAllEntityRelationships(tbox)
	}
	
	private def IScope computeAllEntityRelationships(TerminologyBox tbox) {
		terminologyScope(tbox, [localEntityRelationships], [importedResourceNameFunction])
	}
	
	def IScope allPredicatesScope(TerminologyBox tbox) {
		val cache = lookupAllPredicatesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllPredicates]) ?: computeAllPredicates(tbox)
	}
	
	private def IScope computeAllPredicates(TerminologyBox tbox) {
		terminologyScope(tbox, [localPredicates], [importedResourceNameFunction])
	}
	
	def IScope allForwardPropertiesScope(TerminologyBox tbox) {
		val cache = lookupAllForwardPropertiesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllForwardProperties]) ?: computeAllForwardProperties(tbox)
	}
	
	private def IScope computeAllForwardProperties(TerminologyBox tbox) {
		terminologyScope(tbox, [localForwardProperties], [importedResourceNameFunction])
	}
	
	def IScope allInversePropertiesScope(TerminologyBox tbox) {
		val cache = lookupAllInversePropertiesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllInverseProperties]) ?: computeAllInverseProperties(tbox)
	}
	
	private def IScope computeAllInverseProperties(TerminologyBox tbox) {
		terminologyScope(tbox, [localInverseProperties], [importedResourceNameFunction])
	}
	
	def IScope allRestrictableRelationshipsScope(TerminologyBox tbox) {
		val cache = lookupAllRestrictableRelationshipsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllRestrictableRelationships]) ?: computeAllRestrictableRelationships(tbox)
	}
	
	private def IScope computeAllRestrictableRelationships(TerminologyBox tbox) {
		terminologyScope(tbox, [localRestrictableRelationships], [importedResourceNameFunction])
	}
	
	def IScope allEntityScalarDataPropertiesScope(TerminologyBox tbox) {
		val cache = lookupAllEntityScalarDataPropertiesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllEntityScalarDataProperties]) ?: computeAllEntityScalarDataProperties(tbox)
	}
	
	private def IScope computeAllEntityScalarDataProperties(TerminologyBox tbox) {
		terminologyScope(tbox, [localEntityScalarDataProperties], [importedResourceNameFunction])
	}
	
	def IScope allEntityStructuredDataPropertiesScope(TerminologyBox tbox) {
		val cache = lookupAllEntityStructuredDataPropertiesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllEntityStructuredDataProperties]) ?: computeAllEntityStructuredDataProperties(tbox)
	}
	
	private def IScope computeAllEntityStructuredDataProperties(TerminologyBox tbox) {
		terminologyScope(tbox, [localEntityStructuredDataProperties], [importedResourceNameFunction])
	}
	
	def IScope allScalarDataPropertiesScope(TerminologyBox tbox) {
		val cache = lookupAllScalarDataPropertiesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllScalarDataProperties]) ?: computeAllScalarDataProperties(tbox)
	}
	
	private def IScope computeAllScalarDataProperties(TerminologyBox tbox) {
		terminologyScope(tbox, [localScalarDataProperties], [importedResourceNameFunction])
	}
	
	def IScope allStructuredDataPropertiesScope(TerminologyBox tbox) {
		val cache = lookupAllStructuredDataPropertiesCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllStructuredDataProperties]) ?: computeAllStructuredDataProperties(tbox)
	}
	
	private def IScope computeAllStructuredDataProperties(TerminologyBox tbox) {
		terminologyScope(tbox, [localStructuredDataProperties], [importedResourceNameFunction])
	}
	
	def IScope allScalarOneOfRestrictionsScope(TerminologyBox tbox) {
		val cache = lookupAllScalarOneOfRestrictionsCache(tbox)
		cache?.computeIfAbsent(tbox, [computeAllScalarOneOfRestrictions]) ?: computeAllScalarOneOfRestrictions(tbox)
	}
	
	private def IScope computeAllScalarOneOfRestrictions(TerminologyBox tbox) {
		terminologyScope(tbox, [localScalarOneOfRestrictions], [importedResourceNameFunction])
	}
	
	def <T extends LogicalElement> IScope bundleScope(
		Bundle bundle,
		Function<TerminologyBox, Iterable<T>> localScopeFunction,
		Function<Pair<TerminologyBox, T>, QualifiedName> nameFunction
	) {
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val Set<Bundle> allBundles = Sets.newHashSet()
		allBundles.add(bundle)
		allBundles.addAll(bundle.allImportedBundles)
		
		val Set<TerminologyBox> allTBoxes = Sets.newHashSet()
		allTBoxes.addAll(allBundles)
		allTBoxes.addAll(allBundles.map[b|OMLExtensions.allImportedTerminologies(b)].flatten)
		result.addAll(allTBoxes.map[tbox|
			Scopes.scopedElementsFor(
				localScopeFunction.apply(tbox), 
				[e| nameFunction.apply(Pair.of(tbox, e)) ]
			)
		].flatten)
		new SimpleScope(result)
	}
	
	def IScope allConceptsScope(Bundle b) {
		bundleScope(b, [localConcepts], [importedResourceNameFunction])
	}
	
	// =================================================
	
	def <T extends LogicalElement> IScope descriptionScope(
		DescriptionBox dbox,
		Function<DescriptionBox, Iterable<T>> localScopeFunction,
		Function<Pair<DescriptionBox, T>, QualifiedName> nameFunction
	) {
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		result.addAll(Scopes.scopedElementsFor(localScopeFunction.apply(dbox)))
		result.addAll(dbox.allImportedDescriptions.map[importedDbox|
			Scopes.scopedElementsFor(
				localScopeFunction.apply(importedDbox), 
				[importedThing| nameFunction.apply(Pair.of(importedDbox, importedThing)) ]
			)
		].flatten)
		new SimpleScope(result)
	}
	
	def IScope allConceptualEntitySingletonInstanceScope(DescriptionBox dbox) {
		descriptionScope(dbox, [localConceptualEntitySingletonInstances], [importedDescriptionNameFunction])
	}
	
	def IScope allReifiedRelationshipInstancesScope(DescriptionBox dbox) {
		descriptionScope(dbox, [localReifiedRelationshipInstances], [importedDescriptionNameFunction])
	}
	
	def IScope allRangesScope(DescriptionBox dbox) {
		val tboxes = dbox.allImportedTerminologiesFromDescription()
		
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val inc = tboxes.map [ tbox |
			Scopes.scopedElementsFor(
				tbox.localRanges,
				[importedThing|importedResourceNameFunction(Pair.of(tbox, importedThing))]
			)
		].flatten
		result.addAll(inc)
		new SimpleScope(result)
	}
	
	def IScope allEntityStructuredDataPropertiesScope(DescriptionBox dbox) {
		val tboxes = dbox.allImportedTerminologiesFromDescription()
		
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val inc = tboxes.map [ tbox |
			Scopes.scopedElementsFor(
				tbox.localEntityStructuredDataProperties,
				[importedThing|importedResourceNameFunction(Pair.of(tbox, importedThing))]
			)
		].flatten
		result.addAll(inc)
		new SimpleScope(result)
	}
	
	def IScope allEntityScalarDataPropertiesScope(DescriptionBox dbox) {
		val tboxes = dbox.allImportedTerminologiesFromDescription()
		
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val inc = tboxes.map [ tbox |
			Scopes.scopedElementsFor(
				tbox.localEntityScalarDataProperties,
				[importedThing|importedResourceNameFunction(Pair.of(tbox, importedThing))]
			)
		].flatten
		result.addAll(inc)
		new SimpleScope(result)
	}
	
	def IScope allStructuredDataPropertiesScope(DescriptionBox dbox) {
		val tboxes = dbox.allImportedTerminologiesFromDescription()
		
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val inc = tboxes.map [ tbox |
			Scopes.scopedElementsFor(
				tbox.localStructuredDataProperties,
				[importedThing|importedResourceNameFunction(Pair.of(tbox, importedThing))]
			)
		].flatten
		result.addAll(inc)
		new SimpleScope(result)
	}
	
	def IScope allScalarDataPropertiesScope(DescriptionBox dbox) {
		val tboxes = dbox.allImportedTerminologiesFromDescription()
		
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val inc = tboxes.map [ tbox |
			Scopes.scopedElementsFor(
				tbox.localScalarDataProperties,
				[importedThing|importedResourceNameFunction(Pair.of(tbox, importedThing))]
			)
		].flatten
		result.addAll(inc)
		new SimpleScope(result)
	}
	
	def IScope allConceptsScope(DescriptionBox dbox) {
		val tboxes = dbox.allImportedTerminologiesFromDescription()
		
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val inc = tboxes.map [ tbox |
			Scopes.scopedElementsFor(
				tbox.localConcepts,
				[importedThing|importedResourceNameFunction(Pair.of(tbox, importedThing))]
			)
		].flatten
		result.addAll(inc)
		new SimpleScope(result)
	}
	
	def IScope allReifiedRelationshipScope(DescriptionBox dbox) {
		val tboxes = dbox.allImportedTerminologiesFromDescription()
		
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val inc = tboxes.map [ tbox |
			Scopes.scopedElementsFor(
				tbox.localReifiedRelationships,
				[importedThing|importedResourceNameFunction(Pair.of(tbox, importedThing))]
			)
		].flatten
		result.addAll(inc)
		new SimpleScope(result)
	}
	
	def IScope allUnreifiedRelationshipScope(DescriptionBox dbox) {
		val tboxes = dbox.allImportedTerminologiesFromDescription()
		
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		val inc = tboxes.map [ tbox |
			Scopes.scopedElementsFor(
				tbox.localUnreifiedRelationships,
				[importedThing|importedResourceNameFunction(Pair.of(tbox, importedThing))]
			)
		].flatten
		result.addAll(inc)
		new SimpleScope(result)
	}
}