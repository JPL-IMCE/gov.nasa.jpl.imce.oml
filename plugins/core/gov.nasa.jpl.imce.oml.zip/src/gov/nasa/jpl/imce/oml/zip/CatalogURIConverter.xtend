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

import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl
import org.eclipse.emf.ecore.resource.URIHandler
import java.util.Collection
import org.eclipse.emf.ecore.resource.ContentHandler
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog
import org.eclipse.emf.common.util.URI

/**
 * CatalogURIConverter is a kind of ExtensibleURIConverterImpl
 * where normalization involves resolving an URI through an OASIS XML Catalog.
 */
class CatalogURIConverter extends ExtensibleURIConverterImpl {
	
	protected OMLCatalog catalog
	
	/**
	 * Initialize an CatalogURIConverter using an OMLCatalog
	 * as the basis for URI normalization.
	 */
	new(OMLCatalog catalog) {
		this(catalog, URIHandler.DEFAULT_HANDLERS, ContentHandler.Registry.INSTANCE.contentHandlers())
	}
	
	/**
	 * Initialize an CatalogURIConverter using an OMLCatalog
	 * as the basis for URI normalization.
	 */
	new(OMLCatalog catalog, Collection<URIHandler> uriHandlers, Collection<ContentHandler> contentHandlers) {
		super(uriHandlers, contentHandlers)
		this.catalog = catalog
	}
	
	/**
	 * Normalizing a URI is resolving that URI according to the rewrite rules defined in an OASIS XML Catalog.
	 */
	override def URI normalize(URI uri) {
		val resolved = catalog.resolveURI(uri.toString)
		URI.createURI(resolved + ".omlzip")
	}
	
}