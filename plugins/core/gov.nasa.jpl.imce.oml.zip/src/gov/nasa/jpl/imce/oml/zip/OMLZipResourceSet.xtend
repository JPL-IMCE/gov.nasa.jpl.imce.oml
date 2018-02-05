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
package gov.nasa.jpl.imce.oml.zip

import gov.nasa.jpl.imce.oml.dsl.OMLStandaloneSetup
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import java.net.URL
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup

/**
 * An OMLZipResourceSet is a ResourceSet for creating, loading and saving OMLZipResource(s)
 * according to an OASIS XML Catalog-based mapping of Resource URIs to files locations
 * relative to the location of the catalog file itself.
 * 
 * @TODO:
 * 1) Decide whether to enable the URIResourceMap cache.
 *    Currently, this cache is disabled because uriResouceMap == null by default.
 *    Enabling it would entail at least the following:
 *    - in the constructor: 	setURIResourceMap(new HashMap<URI,Resource>())
 *    - listening to resource changes, particularly w.r.t. the resource URI.
 */
class OMLZipResourceSet extends ResourceSetImpl {
	
	/**
	 * Registers the OML-specific content & extension from the plugin.xml:
	 * 
	 * <extension point="org.eclipse.emf.ecore.extension_parser">
	 *   <parser class="gov.nasa.jpl.imce.oml.zip.OMLZipResourceFactory" type="omlzip"/>
	 * </extension>
	 * <extension point="org.eclipse.emf.ecore.content_parser">
	 *   <parser class="gov.nasa.jpl.imce.oml.zip.OMLZipResourceFactory" contentTypeIdentifier="omlzip"/>
	 * </extension>
	 */
	def static void doSetup() {
		XcoreStandaloneSetup.doSetup
		OMLStandaloneSetup.doSetup
		
		Resource.Factory.Registry.INSTANCE.contentTypeToFactoryMap.put("omlzip", new OMLZipResourceFactory())
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("omlzip", new OMLZipResourceFactory())
	}
		
	/**
	 * Get or initialize an OMLCatalog associated to the ResourceSet rs and parse omlCatalogFile.
	 * 
	 * If the ResourceSet is an OMLZipResourceSet, then creating or saving a resource for a given URI
	 * will involve mapping that URI according to the OMLCatalog's rewrite rules parsed from omlCatalogFile.
	 * 
	 * If the ResourceSet is an XTextResourceSet, then OML ModuleEdge cross-references will
	 * involve mapping the ModuleEdge target IRI according to the OMLCatalog's rewrite rules parsed from omlCatalogFile.
	 */
	static def OMLCatalog configure(ResourceSet rs, URL omlCatalogFile) {
		val OMLCatalog c = OMLExtensions.getCatalog(rs)
		if (null === c) 
			throw new IllegalArgumentException("OMLZipResourceSet.configure: no OMLCatalog on this resource set!")
		c.parseCatalog(omlCatalogFile)
		c
	}
	
	protected CatalogURIConverter catalogURIConverter
	
	/**
	 * Returns the CatalogURIConverter constructed at initialization from parsing an OASIS XML Catalog file in an OMLCatalog.
	 */
	def CatalogURIConverter getCatalogURIConverter() {
		if (null === catalogURIConverter) 
			throw new IllegalArgumentException("OMLZipResourceSet.getCatalogURIConverter: not yet configured!")
		return catalogURIConverter
	}
	
	/**
	 * Parse the OASIS XML Catalog file (omlCatalogFile) in an OMLCatalog to initialize this OMLZipResourceSet.
	 * 
	 */
	new(URL omlCatalogFile) {
		val c = configure(this, omlCatalogFile)
		this.catalogURIConverter = new CatalogURIConverter(c)
	}
	
	/**
	 * Create an OMLZipREsource.
	 */
	override def Resource createResource(URI uri) {
		val last = uri.lastSegment
		if (null === last)
			super.createResource(uri, "omlzip")
		else if (last.endsWith(".oml"))
			createResource(uri, "oml")
		else if (last.endsWith(".omlzip"))
			createResource(uri, "omlzip")
		else
			super.createResource(uri)
	}
	
	override protected Resource demandCreateResource(URI uri) {
		val Resource r = createResource(uri)
		return r
	}
	
}