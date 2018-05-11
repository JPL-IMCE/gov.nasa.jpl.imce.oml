/**
 *
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package gov.nasa.jpl.imce.oml.model.extensions

import com.fasterxml.uuid.Generators
import com.fasterxml.uuid.impl.NameBasedGenerator
import com.google.common.collect.Lists
import com.google.common.collect.Sets
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.common.LiteralBoolean
import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal
import gov.nasa.jpl.imce.oml.model.common.LiteralFloat
import gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString
import gov.nasa.jpl.imce.oml.model.common.LiteralRational
import gov.nasa.jpl.imce.oml.model.common.LiteralRawString
import gov.nasa.jpl.imce.oml.model.common.LiteralReal
import gov.nasa.jpl.imce.oml.model.common.LiteralURI
import gov.nasa.jpl.imce.oml.model.common.LiteralUUID
import gov.nasa.jpl.imce.oml.model.common.LiteralValue
import gov.nasa.jpl.imce.oml.model.common.LogicalElement
import gov.nasa.jpl.imce.oml.model.common.Module
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Predicate
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Structure
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Term
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
import java.io.IOException
import java.net.URL
import java.util.ArrayList
import java.util.Comparator
import java.util.HashSet
import java.util.UUID
import org.apache.xml.resolver.CatalogManager
import org.apache.xml.resolver.tools.CatalogResolver
import org.eclipse.emf.common.CommonPlugin
import org.eclipse.emf.common.util.ECollections
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.xbase.lib.Functions.Function1

import static com.google.common.base.Preconditions.checkNotNull

public class OMLExtensions {

	static public val String OML_CATALOG_XML = "oml.catalog.xml"

	static val String RESOURCE_SET_CATALOG_MANAGER = "RESOURCE_SET_CATALOG_MANAGER"
	static val String RESOURCE_SET_CATALOG_RESOLVER = "RESOURCE_SET_CATALOG_RESOLVER"
	static val String RESOURCE_SET_CATALOG_INSTANCE = "RESOURCE_SET_CATALOG_INSTANCE"

	static def CatalogManager getOrCreateCatalogManager(ResourceSet rs) {
		val o = rs.loadOptions.get(RESOURCE_SET_CATALOG_MANAGER) ?: new OMLCatalogManager()
		if (OMLCatalogManager.isInstance(o)) {
			val cm = OMLCatalogManager.cast(o)
			cm.useStaticCatalog = false
			cm.catalogClassName = "gov.nasa.jpl.imce.oml.extensions.OMLCatalog"
			rs.loadOptions.putIfAbsent(RESOURCE_SET_CATALOG_MANAGER, cm)
			return cm
		} else {
			return null
		}
	}

	static def CatalogResolver getOrCreateCatalogResolver(ResourceSet rs) {
		val o = rs.loadOptions.get(RESOURCE_SET_CATALOG_RESOLVER) ?: new CatalogResolver(getOrCreateCatalogManager(rs))
		if (CatalogResolver.isInstance(o)) {
			val cr = CatalogResolver.cast(o)
			rs.loadOptions.putIfAbsent(RESOURCE_SET_CATALOG_RESOLVER, cr)
			return cr
		} else {
			return null
		}
	}

	// CatalogURIConverter!
	static def OMLCatalog getCatalog(ResourceSet rs) {
		val o = rs.loadOptions.get(RESOURCE_SET_CATALOG_INSTANCE) ?: getOrCreateCatalogResolver(rs).catalog
		if (OMLCatalog.isInstance(o)) {
			val c = OMLCatalog.cast(o)
			rs.loadOptions.putIfAbsent(RESOURCE_SET_CATALOG_INSTANCE, c)
			val prevConverter = rs.URIConverter
			switch prevConverter {
				CatalogURIConverter: {
					// The resource set already has a CatalogURIConverter as its URIConverter.
				}
				default: {
					// Use the resource set's URIConverter as the parent of a new CatalogURIConverter.
					val omlc = new CatalogURIConverter(c, rs.URIConverter)
					rs.URIConverter = omlc
				}	
			}
			return c
		} else {
			return null
		}
	}

	static def OMLCatalog findCatalogIfExists(Resource r) {
		val rs = r.resourceSet
		val uri = rs.URIConverter.normalize(r.URI)
		val ruri = CommonPlugin.resolve(uri)
		val luri = CommonPlugin.asLocalURI(ruri)
		findCatalogIfExists(rs, luri.trimSegments(1))
	}

	static def OMLCatalog findCatalogIfExists(ResourceSet rs, URI path) {
		val c = rs.catalog
		if (null === c)
			return null

		var current = path
		while (current.segmentCount > 0) {
			try {
				// System.out.println("# Searching for OML catalog in: " + current)
				val omlC = current.appendSegment(OML_CATALOG_XML)
				val omlURL = new URL(omlC.toString)

				// check the catalog file can be opened.
				val omlS = omlURL.openStream
				omlS.close

				if (!c.hasParsedCatalog(omlURL)) {
					c.parseCatalog(new URL(omlC.toString))
				// System.out.println("# Found catalog: " + omlC)
				}

				return c
			} catch (IOException ex) {
				current = current.trimSegments(1)
			}
		}
		return null
	}

	static def String convertIRItoNamespace(String iri) {
		val index1 = iri.indexOf("://")
		val pname = iri.substring(index1 + 3)
		val index2 = pname.indexOf("/")
		val domain = if(index2 > 0) pname.substring(0, index2) else pname
		val qprefix = domain.split("\\.").reverse.join(".")
		val qsuffix = if(index2 > 0) pname.substring(index2) else ""
		val qname = (qprefix + qsuffix).replaceAll("[/-]", ".")
		qname
	}

	static def UUID namespaceUUID(String namespace) {
		namespaceUUID(namespace, new ArrayList<Pair<String, String>>())
	}

	static def UUID namespaceUUID(
		String namespace,
		Pair<String, String> factor1
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		namespaceUUID(namespace, factors)
	}

	static def UUID namespaceUUID(
		String namespace,
		Pair<String, String> factor1,
		Pair<String, String> factor2
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		factors.add(factor2)
		namespaceUUID(namespace, factors)
	}

	static def UUID namespaceUUID(String namespace, Pair<String, String>[] factors) {
		val name = namespace + factors.map[pair|(pair.key ?: "") + ":" + (pair.value ?: "")].join(",")
		Generators.nameBasedGenerator(NameBasedGenerator.NAMESPACE_URL).generate(name)
	}

	static def UUID derivedUUID(String context) {
		derivedUUID(context, new ArrayList<Pair<String, String>>())
	}

	static def UUID derivedUUID(
		String context,
		Pair<String, String> factor1
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		derivedUUID(context, factors)
	}

	static def UUID derivedUUID(
		String context,
		Pair<String, String> factor1,
		Pair<String, String> factor2
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		factors.add(factor2)
		derivedUUID(context, factors)
	}

	static def UUID derivedUUID(
		String context,
		Pair<String, String> factor1,
		Pair<String, String> factor2,
		Pair<String, String> factor3
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		factors.add(factor2)
		factors.add(factor3)
		derivedUUID(context, factors)
	}

	static def UUID derivedUUID(
		String context,
		Pair<String, String> factor1,
		Pair<String, String> factor2,
		Pair<String, String> factor3,
		Pair<String, String> factor4
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		factors.add(factor2)
		factors.add(factor3)
		factors.add(factor4)
		derivedUUID(context, factors)
	}

	static def UUID derivedUUID(
		String context,
		Pair<String, String> factor1,
		Pair<String, String> factor2,
		Pair<String, String> factor3,
		Pair<String, String> factor4,
		Pair<String, String> factor5
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		factors.add(factor2)
		factors.add(factor3)
		factors.add(factor4)
		factors.add(factor5)
		derivedUUID(context, factors)
	}
	
	static def UUID derivedUUID(
		String context,
		Pair<String, String> factor1,
		Pair<String, String> factor2,
		Pair<String, String> factor3,
		Pair<String, String> factor4,
		Pair<String, String> factor5,
		Pair<String, String> factor6
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		factors.add(factor2)
		factors.add(factor3)
		factors.add(factor4)
		factors.add(factor5)
		factors.add(factor6)
		derivedUUID(context, factors)
	}

	static def UUID derivedUUID(
		String context,
		Pair<String, String> factor1,
		Pair<String, String> factor2,
		Pair<String, String> factor3,
		Pair<String, String> factor4,
		Pair<String, String> factor5,
		Pair<String, String> factor6,
		Pair<String, String> factor7
	) {
		val factors = new ArrayList<Pair<String, String>>()
		factors.add(factor1)
		factors.add(factor2)
		factors.add(factor3)
		factors.add(factor4)
		factors.add(factor5)
		factors.add(factor6)
		factors.add(factor7)
		derivedUUID(context, factors)
	}

	static def derivedUUID(String context, Pair<String, String>[] factors) {
		val name = context + factors.map[pair|(pair.key ?: "") + ":" + (pair.value ?: "")].join(",")
		Generators.nameBasedGenerator(NameBasedGenerator.NAMESPACE_URL).generate(name)
	}

	static def String getModuleNsURI(Module it) {
		annotations.findFirst[a|a.property.iri() == "http://imce.jpl.nasa.gov/oml/runtime#OML2EcoreNsURI"]?.value?.stringValue?.value ?: iri()
	}

	static def String getModuleNsPrefix(Module it) {
		annotations.findFirst[a|a.property.iri() == "http://imce.jpl.nasa.gov/oml/runtime#OML2EcoreNsPrefix"]?.value?.stringValue?.value ?: name()
	}

	def Iterable<TerminologyBox> terminologies(Extent it) {
		it.modules.filter(TerminologyBox)
	}

	def Iterable<TerminologyGraph> terminologyGraphs(Extent it) {
		it.modules.filter(TerminologyGraph)
	}

	def Iterable<DescriptionBox> descriptions(Extent it) {
		it.modules.filter(DescriptionBox)
	}

	def Iterable<Bundle> bundles(Extent it) {
		it.modules.filter(Bundle)
	}

	def phasedResolveAll(Extent it) {
		modules.forEach [
			moduleEdges.forEach [
				EcoreUtil.resolveAll(targetModule)
			]
		]
	}

	static def Iterable<TerminologyBox> allImportedTerminologies(TerminologyBox it) {
		collectAllImportedTerminologies(Lists.newArrayList(it), Lists.newArrayList(it), Sets.newHashSet(it))
	}

	static final def Iterable<TerminologyBox> collectAllImportedTerminologies(
		ArrayList<TerminologyBox> queue,
		ArrayList<TerminologyBox> acc,
		HashSet<TerminologyBox> visited
	) {
		if (queue.isEmpty)
			return acc

		val tbox = queue.head
		queue.remove(tbox)

		val inc = tbox.moduleEdges.map[targetModule].filterNull.filter(TerminologyBox).reject[visited.contains(it)]
		queue.addAll(inc)
		acc.addAll(inc)
		visited.addAll(inc)

		collectAllImportedTerminologies(queue, acc, visited)
	}

	def Iterable<Module> allImportedModules(Module it) {
		collectAllImportedModules(Lists.newArrayList(it), Lists.newArrayList(it), Sets.newHashSet(it))
	}

	final def Iterable<Module> collectAllImportedModules(
		ArrayList<Module> queue,
		ArrayList<Module> acc,
		HashSet<Module> visited
	) {
		if (queue.isEmpty)
			return acc

		val m = queue.head
		queue.remove(m)

		val inc = m.moduleEdges.map[targetModule].filterNull.reject[visited.contains(it)]
		queue.addAll(inc)
		acc.addAll(inc)
		visited.addAll(inc)

		collectAllImportedModules(queue, acc, visited)
	}

	def Iterable<Entity> localEntities(TerminologyBox it) {
		boxStatements.filter(Entity)
	}

	def Iterable<Entity> allEntities(TerminologyBox it) {
		localEntities + allImportedTerminologies(it).map[localEntities].flatten
	}

	def Iterable<ConceptualEntity> localConceptualEntities(TerminologyBox it) {
		boxStatements.filter(ConceptualEntity)
	}

	def Iterable<ConceptualEntity> allConceptualEntities(TerminologyBox it) {
		localConceptualEntities + allImportedTerminologies(it).map[localConceptualEntities].flatten
	}

	def Iterable<Aspect> localAspects(TerminologyBox it) {
		boxStatements.filter(Aspect)
	}

	def Iterable<Aspect> allAspects(TerminologyBox it) {
		localAspects + allImportedTerminologies(it).map[localAspects].flatten
	}

	def Iterable<Concept> localConcepts(TerminologyBox it) {
		boxStatements.filter(Concept)
	}

	def Iterable<Concept> allConcepts(TerminologyBox it) {
		localConcepts + allImportedTerminologies(it).map[localConcepts].flatten
	}

	def Iterable<ConceptualRelationship> localConceptualRelationships(TerminologyBox it) {
		boxStatements.filter(ConceptualRelationship)
	}

	def Iterable<ReifiedRelationshipRestriction> localReifiedRelationshipRestrictions(TerminologyBox it) {
		boxStatements.filter(ReifiedRelationshipRestriction)
	}

	def Iterable<ReifiedRelationship> localReifiedRelationships(TerminologyBox it) {
		boxStatements.filter(ReifiedRelationship)
	}

	def Iterable<UnreifiedRelationship> localUnreifiedRelationships(TerminologyBox it) {
		boxStatements.filter(UnreifiedRelationship)
	}

	def Iterable<ReifiedRelationship> allReifiedRelationships(TerminologyBox it) {
		localReifiedRelationships + allImportedTerminologies(it).map[localReifiedRelationships].flatten
	}

	def Iterable<EntityRelationship> localEntityRelationships(TerminologyBox it) {
		boxStatements.filter(EntityRelationship)
	}

	def Iterable<Predicate> localPredicates(TerminologyBox it) {
		val result = new ArrayList<Predicate>()
		localReifiedRelationships.forEach[rr| 
			result.add(rr.forwardProperty)
			result.add(rr.inverseProperty)
		]
		result.addAll(localUnreifiedRelationships)
		result.addAll(localEntities)
		result.filterNull
	}
	
	def Iterable<ForwardProperty> localForwardProperties(TerminologyBox it) {
		localReifiedRelationships.map[forwardProperty].filterNull
	}

	def Iterable<InverseProperty> localInverseProperties(TerminologyBox it) {
		localReifiedRelationships.map[inverseProperty].filterNull
	}

	def Iterable<RestrictableRelationship> localRestrictableRelationships(TerminologyBox it) {
		val result = new ArrayList<RestrictableRelationship>()
		localReifiedRelationships.forEach[rr| 
			result.add(rr.forwardProperty)
			result.add(rr.inverseProperty)
		]
		result.addAll(localUnreifiedRelationships)
		result.filterNull
	}
	
	def Iterable<EntityRelationship> allEntityRelationships(TerminologyBox it) {
		localEntityRelationships + allImportedTerminologies(it).map[localEntityRelationships].flatten
	}

	static def EList<ReifiedRelationship> rootReifiedRelationships(ReifiedRelationshipRestriction prr) {
		val result = new HashSet<ReifiedRelationship>()
		
		val horizon = new HashSet<ConceptualRelationship>()
		horizon.add(prr)
		val candidates = new HashSet<ReifiedRelationshipSpecializationAxiom>()
		
		val rrs = allImportedTerminologies(prr.tbox).map[boxStatements.filter(ReifiedRelationshipSpecializationAxiom)].flatten
		candidates.addAll(rrs)
		
		var more = false
		do {
			more = false
			val axioms = candidates.filter[ax|horizon.contains(ax.subRelationship)].toList
			if (!axioms.empty) {
				horizon.clear
				val parents = axioms.map[superRelationship]
				
				val moreReifiedRelationships = parents.filter(ReifiedRelationship)
				result.addAll(moreReifiedRelationships)
				
				val moreReifiedRelationshipRestrictions = parents.filter(ReifiedRelationshipRestriction)
				horizon.addAll(moreReifiedRelationshipRestrictions)
				
				more = !horizon.empty
			}
		} while (more)
		
		ECollections.asEList(result)
	}
	
	def Iterable<DataRange> localRanges(TerminologyBox it) {
		boxStatements.filter(DataRange)
	}

	def Iterable<Structure> localStructures(TerminologyBox it) {
		boxStatements.filter(Structure)
	}

	def Iterable<EntityScalarDataProperty> localEntityScalarDataProperties(TerminologyBox it) {
		boxStatements.filter(EntityScalarDataProperty)
	}

	def Iterable<EntityStructuredDataProperty> localEntityStructuredDataProperties(TerminologyBox it) {
		boxStatements.filter(EntityStructuredDataProperty)
	}

	def Iterable<ScalarDataProperty> localScalarDataProperties(TerminologyBox it) {
		boxStatements.filter(ScalarDataProperty)
	}

	def Iterable<StructuredDataProperty> localStructuredDataProperties(TerminologyBox it) {
		boxStatements.filter(StructuredDataProperty)
	}

	def Iterable<ScalarOneOfRestriction> localScalarOneOfRestrictions(TerminologyBox it) {
		boxStatements.filter(ScalarOneOfRestriction)
	}

	def Iterable<Bundle> allImportedBundles(Bundle it) {
		collectAllImportedBundles(Lists.newArrayList(it), Lists.newArrayList(it), Sets.newHashSet(it))
	}

	final def Iterable<Bundle> collectAllImportedBundles(
		ArrayList<Bundle> queue,
		ArrayList<Bundle> acc,
		HashSet<Bundle> visited
	) {
		if (queue.isEmpty)
			return acc

		val bundle = queue.head
		queue.remove(bundle)

		val inc = bundle.bundleAxioms.map[target].filter(Bundle).reject[visited.contains(it)]
		queue.addAll(inc)
		acc.addAll(inc)
		visited.addAll(inc)

		collectAllImportedBundles(queue, acc, visited)
	}

	def Iterable<AnonymousConceptUnionAxiom> localAnonymousConceptUnionAxioms(Bundle it) {
		bundleStatements.filter(AnonymousConceptUnionAxiom)
	}

	def Iterable<RootConceptTaxonomyAxiom> localRootConceptTaxonomyAxioms(Bundle it) {
		bundleStatements.filter(RootConceptTaxonomyAxiom)
	}

	def Iterable<TerminologyBox> allImportedTerminologiesFromDescription(DescriptionBox it) {
		collectAllImportedTerminologiesFromDescription(Lists.newArrayList(it), Sets.newHashSet(), Sets.newHashSet())
	}

	final def Iterable<TerminologyBox> collectAllImportedTerminologiesFromDescription(
		ArrayList<DescriptionBox> queue,
		HashSet<TerminologyBox> acc,
		HashSet<TerminologyBox> visited
	) {
		if (queue.isEmpty)
			return acc

		val dbox = queue.head
		queue.remove(dbox)

		val incd = dbox.descriptionBoxRefinements.map[refinedDescriptionBox]
		queue.addAll(incd)

		val inct = dbox.closedWorldDefinitions.map[closedWorldDefinitions].map[allImportedTerminologies].flatten.reject[visited.contains(it)]
		acc.addAll(inct)
		visited.addAll(inct)

		collectAllImportedTerminologiesFromDescription(queue, acc, visited)
	}

	def Iterable<DescriptionBox> allImportedDescriptions(DescriptionBox it) {
		collectAllImportedDescriptions(Lists.newArrayList(it), Lists.newArrayList(it), Sets.newHashSet(it))
	}

	final def Iterable<DescriptionBox> collectAllImportedDescriptions(
		ArrayList<DescriptionBox> queue,
		ArrayList<DescriptionBox> acc,
		HashSet<DescriptionBox> visited
	) {
		if (queue.isEmpty)
			return acc

		val dbox = queue.head
		queue.remove(dbox)

		val inc = dbox.descriptionBoxRefinements.map[refinedDescriptionBox].reject[visited.contains(it)]
		queue.addAll(inc)
		acc.addAll(inc)
		visited.addAll(inc)

		collectAllImportedDescriptions(queue, acc, visited)
	}

	def Iterable<ConceptualEntitySingletonInstance> localConceptualEntitySingletonInstances(DescriptionBox it) {
		conceptInstances + reifiedRelationshipInstances
	}

	def Iterable<ReifiedRelationshipInstance> localReifiedRelationshipInstances(DescriptionBox it) {
		reifiedRelationshipInstances
	}

	static def String kind(LogicalElement e) {
		switch e {
			AnonymousConceptUnionAxiom:
				'AnonymousConceptUnionAxiom'
			Aspect:
				'Aspect'
			AspectSpecializationAxiom:
				'AspectSpecializationAxiom'
			BinaryScalarRestriction:
				'BinaryScalarRestriction'
			Bundle:
				'Bundle'
			BundledTerminologyAxiom:
				'BundledTerminologyAxiom'
			ChainRule:
				'ChainRule'
			Concept:
				'Concept'
			ConceptDesignationTerminologyAxiom:
				'ConceptDesignationTerminologyAxiom'
			ConceptInstance:
				'ConceptInstance'
			ConceptSpecializationAxiom:
				'ConceptSpecializationAxiom'
			DescriptionBox:
				'DescriptionBox'
			DescriptionBoxExtendsClosedWorldDefinitions:
				'DescriptionBoxExtendsClosedWorldDefinitions'
			DescriptionBoxRefinement:
				'DescriptionBoxRefinement'
			EntityRestrictionAxiom:
				'EntityRestrictionAxiom'
			EntityScalarDataProperty:
				'EntityScalarDataProperty'
			EntityScalarDataPropertyExistentialRestrictionAxiom:
				'EntityScalarDataPropertyExistentialRestrictionAxiom'
			EntityScalarDataPropertyParticularRestrictionAxiom:
				'EntityScalarDataPropertyParticularRestrictionAxiom'
			EntityScalarDataPropertyUniversalRestrictionAxiom:
				'EntityScalarDataPropertyUniversalRestrictionAxiom'
			EntityStructuredDataProperty:
				'EntityStructuredDataProperty'
			EntityStructuredDataPropertyParticularRestrictionAxiom:
				'EntityStructuredDataPropertyParticularRestrictionAxiom'
			IRIScalarRestriction:
				'IRIScalarRestriction'
			NumericScalarRestriction:
				'NumericScalarRestriction'
			ReifiedRelationshipRestriction:
				'ReifiedRelationshipRestriction'
			PlainLiteralScalarRestriction:
				'PlainLiteralScalarRestriction'
			ReifiedRelationship:
				'ReifiedRelationship'
			ReifiedRelationshipInstance:
				'ReifiedRelationshipInstance'
			ReifiedRelationshipInstanceDomain:
				'ReifiedRelationshipInstanceDomain'
			ReifiedRelationshipInstanceRange:
				'ReifiedRelationshipInstanceRange'
			ReifiedRelationshipSpecializationAxiom:
				'ReifiedRelationshipSpecializationAxiom'
			RestrictionScalarDataPropertyValue:
				'RestrictionScalarDataPropertyValue'
			RestrictionStructuredDataPropertyTuple:
				'RestrictionStructuredDataPropertyTuple'
			RootConceptTaxonomyAxiom:
				'RootConceptTaxonomyAxiom'
			RuleBodySegment:
				'RuleBodySegment'
			Scalar:
				'Scalar'
			ScalarDataProperty:
				'ScalarDataProperty'
			ScalarDataPropertyValue:
				'ScalarDataPropertyValue'
			ScalarOneOfLiteralAxiom:
				'ScalarOneOfLiteralAxiom'
			ScalarOneOfRestriction:
				'ScalarOneOfRestriction'
			SegmentPredicate:
				'SegmentPredicate'
			SingletonInstanceScalarDataPropertyValue:
				'SingletonInstanceScalarDataPropertyValue'
			SingletonInstanceStructuredDataPropertyValue:
				'SingletonInstanceStructuredDataPropertyValue'
			SpecificDisjointConceptAxiom:
				'SpecificDisjointConceptAxiom'
			StringScalarRestriction:
				'StringScalarRestriction'
			Structure:
				'Structure'
			StructuredDataProperty:
				'StructuredDataProperty'
			StructuredDataPropertyTuple:
				'StructuredDataPropertyTuple'
			SubDataPropertyOfAxiom:
				'SubDataPropertyOfAxiom'
			SubObjectPropertyOfAxiom:
				'SubObjectPropertyOfAxiom'
			SynonymScalarRestriction:
				'SynonymScalarRestriction'
			TerminologyExtensionAxiom:
				'TerminologyExtensionAxiom'
			TerminologyGraph:
				'TerminologyGraph'
			TerminologyNestingAxiom:
				'TerminologyNestingAxiom'
			TimeScalarRestriction:
				'TimeScalarRestriction'
			UnreifiedRelationship:
				'UnreifiedRelationship'
			UnreifiedRelationshipInstanceTuple:
				'UnreifiedRelationshipInstanceTuple'
			default:
				e.eClass.name
		}
	}

	static def int kindOrder(TerminologyBoxStatement e) {
		switch e {
			Aspect:
				10000
			Concept:
				10020
			ConceptSpecializationAxiom:
				10021
			ReifiedRelationship:
				10030
			ReifiedRelationshipRestriction:
				10031
			ReifiedRelationshipSpecializationAxiom:
				10032
			AspectSpecializationAxiom:
				10040
			UnreifiedRelationship:
				10050
			ChainRule:
				10060
			Structure:
				10070
			Scalar:
				10071
			BinaryScalarRestriction:
				10072
			IRIScalarRestriction:
				10073
			NumericScalarRestriction:
				10074
			PlainLiteralScalarRestriction:
				10075
			StringScalarRestriction:
				10076
			SynonymScalarRestriction:
				10077
			TimeScalarRestriction:
				10078
			ScalarOneOfRestriction:
				10079
			ScalarOneOfLiteralAxiom:
				10080
			EntityScalarDataProperty:
				10090
			EntityStructuredDataProperty:
				10091
			ScalarDataProperty:
				10092
			StructuredDataProperty:
				10093
			EntityRestrictionAxiom:
				10100
			EntityScalarDataPropertyExistentialRestrictionAxiom:
				10101
			EntityScalarDataPropertyParticularRestrictionAxiom:
				10102
			EntityScalarDataPropertyUniversalRestrictionAxiom:
				10103
			EntityStructuredDataPropertyParticularRestrictionAxiom:
				10104
			SubObjectPropertyOfAxiom:
				10202	
			SubDataPropertyOfAxiom:
				10201
			default:
				0
		}
	}

	static def int kindOrder(TerminologyBoxAxiom e) {
		switch e {
			TerminologyExtensionAxiom:
				1
			TerminologyNestingAxiom:
				2
			ConceptDesignationTerminologyAxiom:
				3
			default:
				0
		}
	}

	static def int kindOrder(TerminologyBundleAxiom e) {
		switch e {
			BundledTerminologyAxiom:
				1
			default:
				0
		}
	}

	static def int kindOrder(TerminologyBundleStatement e) {
		switch e {
			RootConceptTaxonomyAxiom:
				1
			default:
				0
		}
	}

	static def String nestedKindOrder(LogicalElement e) {
		switch e {
			TerminologyGraph:
				"00000-"
			Bundle:
				"00001-"
			DescriptionBox:
				"00002-"
			Aspect:
				"00010-"
			Concept:
				"00011-"
			ReifiedRelationship:
				"00012-"
			ReifiedRelationshipRestriction:
				"00013-"
			UnreifiedRelationship:
				"00014-"
			ChainRule:
				"00015-"
			ConceptSpecializationAxiom:
				"00020-"
			ReifiedRelationshipSpecializationAxiom:
				"00021-"
			AspectSpecializationAxiom:
				"00022-"
			Structure:
				"00030-"
			Scalar:
				"00031-"
			BinaryScalarRestriction:
				"00032-"
			IRIScalarRestriction:
				"00033-"
			NumericScalarRestriction:
				"00034-"
			PlainLiteralScalarRestriction:
				"00035-"
			StringScalarRestriction:
				"00036-"
			SynonymScalarRestriction:
				"00037-"
			TimeScalarRestriction:
				"00038-"
			ScalarOneOfRestriction:
				"00039-"
			ScalarOneOfLiteralAxiom:
				"00040-"
			EntityScalarDataProperty:
				"00050-"
			EntityStructuredDataProperty:
				"00051-"
			ScalarDataProperty:
				"00052-"
			StructuredDataProperty:
				"00053-"
			EntityRestrictionAxiom:
				"00060-"
			EntityScalarDataPropertyExistentialRestrictionAxiom:
				"00061-"
			EntityScalarDataPropertyParticularRestrictionAxiom:
				"00062-"
			EntityScalarDataPropertyUniversalRestrictionAxiom:
				"00063-"
			EntityStructuredDataPropertyParticularRestrictionAxiom:
				"00064-"
			RootConceptTaxonomyAxiom:
				"00070-"
			SpecificDisjointConceptAxiom:
				"00071-"
			AnonymousConceptUnionAxiom:
				"00072-"
			RuleBodySegment:
				"00080"
			SegmentPredicate:
				"00090"
			SingletonInstanceStructuredDataPropertyValue:
				"00120"
			StructuredDataPropertyTuple:
				"00121"
			ScalarDataPropertyValue:
				"00122"
			RestrictionScalarDataPropertyValue:
				"00130"
			RestrictionStructuredDataPropertyTuple:
				"00131"
			ConceptInstance:
				"00140"
			ReifiedRelationshipInstance:
				"00141"
			ReifiedRelationshipInstanceDomain:
				"00142"
			ReifiedRelationshipInstanceRange:
				"00143"
			UnreifiedRelationshipInstanceTuple:
				"00144"
			SubObjectPropertyOfAxiom:
				"00150"
			SubDataPropertyOfAxiom:
				"00151"
			default:
				"0"
		}

	}

	// Workaround to https://github.com/eclipse/xtext-lib/issues/65
	public static final class KeyComparator<T, C extends Comparable<? super C>> implements Comparator<T> {
		private final Function1<? super T, C> keyFunction;

		/**
		 * @param keyFunction
		 *            the key function to use for comparing objects. May not be <code>null</code>
		 */
		public new(Function1<? super T, C> keyFunction) {
			this.keyFunction = checkNotNull(keyFunction, "keyFunction");
		}

		override public def int compare(T a, T b) {
			val C c1 = keyFunction.apply(a);
			val C c2 = keyFunction.apply(b);
			if (c1 == c2) {
				return 0
			} else if (c1 !== null) {
				return c1.compareTo(c2)
			} else {
				return -c2.compareTo(c1)
			}
		}
	}

	// Workaround to https://github.com/eclipse/xtext-lib/issues/65
	static def <T, C extends Comparable<? super C>> EList<T> sortInplaceBy(EList<T> list,
		Functions.Function1<? super T, C> key) {
		if (key === null)
			throw new NullPointerException("key")
		ECollections.sort(list, new KeyComparator<T, C>(key));
		return list;
	}

	// XText 2.12 workaround for https://github.com/eclipse/xtext-core/issues/543
	// Delete previous concrete syntax INodes before changing the order of elements.
	// This is important as subsequent serialization will trigger formatting the contents.
	// During that process, XText would use cached INodes, if available and doing so could produce incorrectly formatted text 
	// that can be ill-formed according to the grammar.
	static def dispatch void normalize(Extent ext) {
		
		val queue = new ArrayList<EObject>()
		queue.add(ext)
				
		sortInplaceBy(ext.modules, [abbrevIRI])
		ext.modules.forEach [ m |
			normalize(m)
		]
	}

	/**
	 * Normalizes the order of OML Elements recursively within an OML TerminologyGraph.
	 */
	static def dispatch void normalize(TerminologyGraph it) {
		normalizeTerminologyBoxCollections
		eContents.filter(LogicalElement).forEach [ e |
			normalizeAnnotations(e)
			normalizeSubElements(e)
		]
	}

	/**
	 * Normalizes the order of OML Elements recursively within an OML Bundle.
	 */
	static def dispatch void normalize(Bundle it) {
		normalizeBundleCollections
		eContents.filter(LogicalElement).forEach [ e |
			normalizeAnnotations(e)
			normalizeSubElements(e)
		]
	}

	/**
	 * Normalizes the order of OML Elements recursively within an OML DescriptionBox.
	 */
	static def dispatch void normalize(DescriptionBox it) {
		sortInplaceBy(annotationProperties, [abbrevIRI])
		sortInplaceBy(descriptionBoxRefinements, [sortingCriteria])
		sortInplaceBy(closedWorldDefinitions, [sortingCriteria])
		sortInplaceBy(conceptInstances, [sortingCriteria])
		sortInplaceBy(reifiedRelationshipInstances, [sortingCriteria])
		sortInplaceBy(reifiedRelationshipInstanceDomains, [sortingCriteria])
		sortInplaceBy(reifiedRelationshipInstanceRanges, [sortingCriteria])
		sortInplaceBy(unreifiedRelationshipInstanceTuples, [sortingCriteria])
		sortInplaceBy(singletonScalarDataPropertyValues, [sortingCriteria])
		sortInplaceBy(singletonStructuredDataPropertyValues, [sortingCriteria])
		eContents.filter(LogicalElement).forEach [ e |
			normalizeAnnotations(e)
			normalizeSubElements(e)
		]
	}

	protected static def void normalizeTerminologyBoxCollections(TerminologyBox it) {
		sortInplaceBy(annotationProperties, [abbrevIRI])
		ECollections.sort(boxAxioms, terminologyBoxAxiomComparator)
		ECollections.sort(boxStatements, terminologyBoxStatementComparator)
	}

	protected static def void normalizeBundleCollections(Bundle it) {
		normalizeTerminologyBoxCollections
		ECollections.sort(bundleAxioms, bundleAxiomComparator)
		ECollections.sort(bundleStatements, bundleStatementComparator)
	}

	protected static def normalizeAnnotations(LogicalElement e) {
		sortInplaceBy(e.annotations, [sortingCriteria])
	}

	protected static def dispatch void normalizeSubElements(RootConceptTaxonomyAxiom e) {
		normalizeAnnotations(e.root)
		sortInplaceBy(e.disjunctions, [sortingCriteria])
		e.disjunctions.forEach[d|normalizeSubElements(d)]
	}

	protected static def dispatch void normalizeSubElements(AnonymousConceptUnionAxiom e) {
		sortInplaceBy(e.disjunctions, [sortingCriteria])
	}

	protected static def dispatch void normalizeSubElements(SpecificDisjointConceptAxiom e) {
		normalizeAnnotations(e.disjointLeaf)
	}

	protected static def dispatch void normalizeSubElements(ModuleEdge e) {
	}
	
	protected static def dispatch void normalizeSubElements(TerminologyBoxStatement e) {
	}
	
	static val terminologyBoxStatementComparator = new Comparator<TerminologyBoxStatement> {
		override int compare(TerminologyBoxStatement o1, TerminologyBoxStatement o2) {
			val k1 = o1.kindOrder
			val k2 = o2.kindOrder
			if (k1 == 0)
				throw new IllegalArgumentException("terminologyBoxStatementComparator: cannot handle " + o1)
			if (k2 == 0)
				throw new IllegalArgumentException("terminologyBoxStatementComparator: cannot handle " + o2)
			if (k1 < k2)
				-1
			else if (k1 > k2)
				1
			else {
				val u1 = o1.sortingCriteria
				val u2 = o2.sortingCriteria
				u1.compareTo(u2)
			}
		}
	}

	static val terminologyBoxAxiomComparator = new Comparator<TerminologyBoxAxiom> {
		override int compare(TerminologyBoxAxiom o1, TerminologyBoxAxiom o2) {
			val k1 = o1.kindOrder
			val k2 = o2.kindOrder
			if (k1 == 0)
				throw new IllegalArgumentException("terminologyBoxAxiomComparator: cannot handle " + o1)
			if (k2 == 0)
				throw new IllegalArgumentException("terminologyBoxAxiomComparator: cannot handle " + o2)
			if (k1 < k2)
				-1
			else if (k1 > k2)
				1
			else {
				val u1 = o1.sortingCriteria
				val u2 = o2.sortingCriteria
				u1.compareTo(u2)
			}
		}
	}

	static val bundleStatementComparator = new Comparator<TerminologyBundleStatement> {
		override int compare(TerminologyBundleStatement o1, TerminologyBundleStatement o2) {
			val k1 = o1.kindOrder
			val k2 = o2.kindOrder
			if (k1 == 0)
				throw new IllegalArgumentException("terminologyBoxStatementComparator: cannot handle " + o1)
			if (k2 == 0)
				throw new IllegalArgumentException("terminologyBoxStatementComparator: cannot handle " + o2)
			if (k1 < k2)
				-1
			else if (k1 > k2)
				1
			else {
				val u1 = o1.sortingCriteria
				val u2 = o2.sortingCriteria
				u1.compareTo(u2)
			}
		}
	}

	static val bundleAxiomComparator = new Comparator<TerminologyBundleAxiom> {
		override int compare(TerminologyBundleAxiom o1, TerminologyBundleAxiom o2) {
			val k1 = o1.kindOrder
			val k2 = o2.kindOrder
			if (k1 == 0)
				throw new IllegalArgumentException("TerminologyBundleAxiom: cannot handle " + o1)
			if (k2 == 0)
				throw new IllegalArgumentException("TerminologyBundleAxiom: cannot handle " + o2)
			if (k1 < k2)
				-1
			else if (k1 > k2)
				1
			else {
				val u1 = o1.sortingCriteria
				val u2 = o2.sortingCriteria
				u1.compareTo(u2)
			}
		}
	}

	static def String sortingCriteria(LogicalElement e) {
		val c = switch e {
			Module:
				e.abbrevIRI
			ModuleEdge:
				(e.sourceModule?.abbrevIRI ?: e.uuid().toString) + "." +
					(e?.targetModule.abbrevIRI ?: e.uuid().toString)
			AnonymousConceptUnionAxiom:
				e.name
			RootConceptTaxonomyAxiom:
				e.root?.abbrevIRI ?: e.uuid().toString
			SpecificDisjointConceptAxiom:
				e.disjointLeaf?.abbrevIRI ?: e.uuid().toString
			Term:
				e.abbrevIRI
			EntityRestrictionAxiom:
				(e.restrictedDomain?.abbrevIRI ?: e.uuid().toString) + "." +
					(e.restrictedRelation?.abbrevIRI ?: e.uuid().toString)
			EntityScalarDataPropertyRestrictionAxiom:
				(e.restrictedEntity?.abbrevIRI ?: e.uuid().toString) + "." +
					(e.scalarProperty?.abbrevIRI ?: e.uuid().toString)
			EntityStructuredDataPropertyParticularRestrictionAxiom:
				(e.restrictedEntity?.abbrevIRI ?: e.uuid().toString) + "." +
					(e.structuredDataProperty?.abbrevIRI ?: e.uuid().toString)
			RestrictionStructuredDataPropertyTuple:
				(e.structuredDataProperty?.abbrevIRI ?: "") + "." + e.uuid().toString
			RestrictionScalarDataPropertyValue:
				(e.scalarDataProperty?.abbrevIRI ?: "") + "." + e.uuid().toString
			ScalarOneOfLiteralAxiom:
				(e.axiom?.abbrevIRI ?: e.uuid().toString) + "." + (e.value?.sortingCriteria ?: e.uuid().toString)
			SpecializationAxiom:
				(e.child?.abbrevIRI ?: e.uuid().toString) + "." + (e.parent?.abbrevIRI ?: e.uuid().toString)
			ConceptualEntitySingletonInstance:
				e.abbrevIRI
			ReifiedRelationshipInstanceDomain:
				(e.reifiedRelationshipInstance?.abbrevIRI ?: e.uuid().toString) + "." +
					(e.domain?.abbrevIRI ?: e.uuid().toString)
			ReifiedRelationshipInstanceRange:
				(e.reifiedRelationshipInstance?.abbrevIRI ?: e.uuid().toString) + "." +
					(e.range?.abbrevIRI ?: e.uuid().toString)
			UnreifiedRelationshipInstanceTuple:
				(e.unreifiedRelationship?.abbrevIRI ?: e.uuid().toString) + "." +
					(e.domain?.abbrevIRI ?: e.uuid().toString) + "." + (e.range?.abbrevIRI ?: e.uuid().toString)
			SubObjectPropertyOfAxiom:
				(e.superProperty?.abbrevIRI ?: e.uuid().toString) + "." +
				(e.subProperty?.abbrevIRI ?: e.uuid().toString)
			SubDataPropertyOfAxiom:
				(e.superProperty?.abbrevIRI ?: e.uuid().toString) + "." +
				(e.subProperty?.abbrevIRI ?: e.uuid().toString)
			SingletonInstanceStructuredDataPropertyValue:
				(e.singletonInstance?.abbrevIRI ?: e.uuid().toString) + "." +
				(e.structuredDataProperty?.abbrevIRI ?: e.uuid().toString)
			StructuredDataPropertyTuple:
				(e.structuredDataPropertyContext?.uuid() ?: "") + "." +
				(e.structuredDataProperty?.abbrevIRI ?: "") + "." + e.uuid().toString
			ScalarDataPropertyValue:
				(e.structuredDataPropertyContext?.uuid() ?: "") + "." +
				(e.scalarDataProperty?.abbrevIRI ?: "") + "." + e.uuid().toString
		}
		nestedKindOrder(e) + c
	}

	static def String sortingCriteria(LiteralValue e) {
		switch e {
			LiteralBoolean:
				e.value.toString
			LiteralDateTime:
				e.dateTime.value
			LiteralDecimal:
				e.decimal.value
			LiteralFloat:
				e.float.value
			LiteralRational:
				e.rational.value
			LiteralReal:
				e.real.value
			LiteralQuotedString:
				e.string.value
			LiteralRawString:
				e.string.value
			LiteralURI:
				e.uri.value
			LiteralUUID:
				e.uuid.value
		}
	}

	static def String sortingCriteria(AnnotationPropertyValue e) {
		e.property?.abbrevIRI ?: e.uuid()
	}
}
