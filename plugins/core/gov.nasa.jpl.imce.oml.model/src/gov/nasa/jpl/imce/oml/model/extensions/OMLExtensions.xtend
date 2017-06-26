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
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom
import gov.nasa.jpl.imce.oml.model.common.Module
import gov.nasa.jpl.imce.oml.model.common.Element
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Structure
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance
import java.io.IOException
import java.net.URL
import java.util.ArrayList
import java.util.UUID
import org.apache.xml.resolver.CatalogManager
import org.apache.xml.resolver.tools.CatalogResolver
import org.eclipse.emf.common.CommonPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import com.google.common.collect.Sets
import java.util.HashSet

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

	static def OMLCatalog getCatalog(ResourceSet rs) {
		val o = rs.loadOptions.get(RESOURCE_SET_CATALOG_INSTANCE) ?: getOrCreateCatalogResolver(rs).catalog
		if (OMLCatalog.isInstance(o)) {
			val c = OMLCatalog.cast(o)
			rs.loadOptions.putIfAbsent(RESOURCE_SET_CATALOG_INSTANCE, c)
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
				System.out.println("# Searching for OML catalog in: " + current)
				val omlC = current.appendSegment(OML_CATALOG_XML)
				val omlURL = new URL(omlC.toString)

				// check the catalog file can be opened.
				val omlS = omlURL.openStream
				omlS.close

				if (!c.hasParsedCatalog(omlURL)) {
					c.parseCatalog(new URL(omlC.toString))
					System.out.println("# Found catalog: " + omlC)
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

	static def derivedUUID(String context, Pair<String, String>[] factors) {
		val name = context + factors.map[pair|(pair.key ?: "") + ":" + (pair.value ?: "")].join(",")
		Generators.nameBasedGenerator(NameBasedGenerator.NAMESPACE_URL).generate(name)
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

	def Iterable<TerminologyBox> allImportedTerminologies(TerminologyBox it) {
		collectAllImportedTerminologies(Lists.newArrayList(it), Lists.newArrayList(it))
	}

	final def Iterable<TerminologyBox> collectAllImportedTerminologies(
		ArrayList<TerminologyBox> queue,
		ArrayList<TerminologyBox> acc
	) {
		if (queue.isEmpty)
			return acc

		val tbox = queue.head
		queue.remove(tbox)

		val inc = tbox.moduleEdges.map[targetModule].filterNull.filter(TerminologyBox)
		queue.addAll(inc)
		acc.addAll(inc)

		collectAllImportedTerminologies(queue, acc)
	}

	def Iterable<Module> allImportedModules(Module it) {
		collectAllImportedModules(Lists.newArrayList(it), Lists.newArrayList(it))
	}

	final def Iterable<Module> collectAllImportedModules(
		ArrayList<Module> queue,
		ArrayList<Module> acc
	) {
		if (queue.isEmpty)
			return acc

		val m = queue.head
		queue.remove(m)

		val inc = m.moduleEdges.map[targetModule].filterNull
		queue.addAll(inc)
		acc.addAll(inc)

		collectAllImportedModules(queue, acc)
	}

	def Iterable<Entity> localEntities(TerminologyBox it) {
		boxStatements.filter(Entity)
	}

	def Iterable<Entity> allEntities(TerminologyBox it) {
		localEntities + allImportedTerminologies(it).map[localEntities].flatten
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

	def Iterable<EntityRelationship> allEntityRelationships(TerminologyBox it) {
		localEntityRelationships + allImportedTerminologies(it).map[localEntityRelationships].flatten
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
		collectAllImportedBundles(Lists.newArrayList(it), Lists.newArrayList(it))
	}

	final def Iterable<Bundle> collectAllImportedBundles(
		ArrayList<Bundle> queue,
		ArrayList<Bundle> acc
	) {
		if (queue.isEmpty)
			return acc

		val bundle = queue.head
		queue.remove(bundle)

		val inc = bundle.bundleAxioms.map[target].filter(Bundle)
		queue.addAll(inc)
		acc.addAll(inc)

		collectAllImportedBundles(queue, acc)
	}

	def Iterable<AnonymousConceptUnionAxiom> localAnonymousConceptUnionAxioms(Bundle it) {
		bundleStatements.filter(AnonymousConceptUnionAxiom)
	}

	def Iterable<RootConceptTaxonomyAxiom> localRootConceptTaxonomyAxioms(Bundle it) {
		bundleStatements.filter(RootConceptTaxonomyAxiom)
	}

	def Iterable<TerminologyBox> allImportedTerminologiesFromDescription(DescriptionBox it) {
		collectAllImportedTerminologiesFromDescription(Lists.newArrayList(it), Sets.newHashSet())
	}

	final def Iterable<TerminologyBox> collectAllImportedTerminologiesFromDescription(
		ArrayList<DescriptionBox> queue,
		HashSet<TerminologyBox> acc
	) {
		if (queue.isEmpty)
			return acc

		val dbox = queue.head
		queue.remove(dbox)

		val incd = dbox.descriptionBoxRefinements.map[refinedDescriptionBox]
		queue.addAll(incd)

		val inct = dbox.closedWorldDefinitions.map[closedWorldDefinitions].map[allImportedTerminologies].flatten
		acc.addAll(inct)

		collectAllImportedTerminologiesFromDescription(queue, acc)
	}

	def Iterable<DescriptionBox> allImportedDescriptions(DescriptionBox it) {
		collectAllImportedDescriptions(Lists.newArrayList(it), Lists.newArrayList(it))
	}

	final def Iterable<DescriptionBox> collectAllImportedDescriptions(
		ArrayList<DescriptionBox> queue,
		ArrayList<DescriptionBox> acc
	) {
		if (queue.isEmpty)
			return acc

		val dbox = queue.head
		queue.remove(dbox)

		val inc = dbox.descriptionBoxRefinements.map[refinedDescriptionBox]
		queue.addAll(inc)
		acc.addAll(inc)

		collectAllImportedDescriptions(queue, acc)
	}

	def Iterable<ConceptualEntitySingletonInstance> localConceptualEntitySingletonInstances(DescriptionBox it) {
		conceptInstances + reifiedRelationshipInstances
	}

	def Iterable<ReifiedRelationshipInstance> localReifiedRelationshipInstances(DescriptionBox it) {
		reifiedRelationshipInstances
	}

	static def String kind(Element e) {
		switch e {
			case DescriptionBox:
				'DescriptionBox'
			case TerminologyGraph:
				'TerminologyGraph'
			case Bundle:
				'Bundle'
			case DescriptionBoxExtendsClosedWorldDefinitions:
				'DescriptionBoxExtendsClosedWorldDefinitions'
			case DescriptionBoxRefinement:
				'DescriptionBoxRefinement'
			case ConceptDesignationTerminologyAxiom:
				'ConceptDesignationTerminologyAxiom'
			case TerminologyExtensionAxiom:
				'TerminologyExtensionAxiom'
			case TerminologyNestingAxiom:
				'TerminologyNestingAxiom'
			case BundledTerminologyAxiom:
				'BundledTerminologyAxiom'
			case EntityExistentialRestrictionAxiom:
				'EntityExistentialRestrictionAxiom'
			case EntityUniversalRestrictionAxiom:
				'EntityUniversalRestrictionAxiom'
			case EntityScalarDataPropertyExistentialRestrictionAxiom:
				'EntityScalarDataPropertyExistentialRestrictionAxiom'
			case EntityScalarDataPropertyParticularRestrictionAxiom:
				'EntityScalarDataPropertyParticularRestrictionAxiom'
			case EntityScalarDataPropertyUniversalRestrictionAxiom:
				'EntityScalarDataPropertyUniversalRestrictionAxiom'
			case ScalarOneOfLiteralAxiom:
				'ScalarOneOfLiteralAxiom'
			case AspectSpecializationAxiom:
				'AspectSpecializationAxiom'
			case ConceptSpecializationAxiom:
				'ConceptSpecializationAxiom'
			case ReifiedRelationshipSpecializationAxiom:
				'ReifiedRelationshipSpecializationAxiom'
			case AnonymousConceptUnionAxiom:
				'AnonymousConceptTaxonomyAxiom'
			case SpecificDisjointConceptAxiom:
				'SpecificDisjointConceptAxiom'
			case RootConceptTaxonomyAxiom:
				'RootConceptTaxonomyAxiom'
			case ReifiedRelationshipInstanceDomain:
				'ReifiedRelationshipInstanceDomain'
			case ReifiedRelationshipInstanceRange:
				'ReifiedRelationshipInstanceRange'
			case SingletonInstanceScalarDataPropertyValue:
				'SingletonInstanceScalarDataPropertyValue'
			case ConceptInstance:
				'ConceptInstance'
			case ReifiedRelationshipInstance:
				'ReifiedRelationshipInstance'
			case StructuredDataPropertyTuple:
				'StructuredDataPropertyTuple'
			case ScalarDataPropertyValue:
				'ScalarDataPropertyValue'
			case SingletonInstanceStructuredDataPropertyValue:
				'SingletonInstanceStructuredDataPropertyValue'
			case UnreifiedRelationshipInstanceTuple:
				'UnreifiedRelationshipInstanceTuple'
			case EntityScalarDataProperty:
				'EntityScalarDataProperty'
			case EntityStructuredDataProperty:
				'EntityStructuredDataProperty'
			case ScalarDataProperty:
				'ScalarDataProperty'
			case StructuredDataProperty:
				'StructuredDataProperty'
			case BinaryScalarRestriction:
				'BinaryScalarRestriction'
			case IRIScalarRestriction:
				'IRIScalarRestriction'
			case NumericScalarRestriction:
				'NumericScalarRestriction'
			case PlainLiteralScalarRestriction:
				'PlainLiteralScalarRestriction'
			case ScalarOneOfRestriction:
				'ScalarOneOfRestriction'
			case StringScalarRestriction:
				'StringScalarRestriction'
			case SynonymScalarRestriction:
				'SynonymScalarRestriction'
			case TimeScalarRestriction:
				'TimeScalarRestriction'
			case Scalar:
				'Scalar'
			case Structure:
				'Structure'
			case Aspect:
				'Aspect'
			case Concept:
				'Concept'
			case ReifiedRelationship:
				'ReifiedRelationship'
			case UnreifiedRelationship:
				'UnreifiedRelationship'
			default:
				e.eClass.name
		}
	}
}
