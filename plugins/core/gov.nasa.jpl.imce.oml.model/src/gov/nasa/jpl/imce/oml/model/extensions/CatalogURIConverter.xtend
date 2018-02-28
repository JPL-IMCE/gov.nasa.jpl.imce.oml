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
package gov.nasa.jpl.imce.oml.model.extensions

import java.io.InputStream
import java.io.IOException
import java.io.OutputStream
import java.util.Collection
import java.util.LinkedHashMap
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ContentHandler
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.URIHandler
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl
import java.net.URL
import org.eclipse.core.runtime.FileLocator

/**
 * CatalogURIConverter is a kind of ExtensibleURIConverterImpl
 * where normalization involves resolving an URI through an OASIS XML Catalog
 * or deferring to a parent URIConverter if the catalog-based resolution fails.
 * 
 * Note that a CatalogURIConverter cannot be the parent of another CatalogURIConverter.
 * This may be over-restrictive but allowing this could lead to infinite loops in
 * normalize(URI) if the same OMLCatalog fails to resolve a URI and is also the catalog
 * of a CatalogURIConverter whose uriConverter parent is another CatalogURIConverter with the same OMLCatalog.
 */
class CatalogURIConverter extends ExtensibleURIConverterImpl {

	protected URIConverter uriConverter

	protected OMLCatalog catalog

	/**
	 * Initialize an CatalogURIConverter using an OMLCatalog
	 * as the basis for URI normalization.
	 */
	new(OMLCatalog catalog) {
		this(catalog, URIHandler.DEFAULT_HANDLERS, ContentHandler.Registry.INSTANCE.contentHandlers(), null)
	}

	/**
	 * Initialize an CatalogURIConverter using an OMLCatalog
	 * as the basis for URI normalization and a parent URIConverter for other cases.
	 */
	new(OMLCatalog catalog, URIConverter converter) {
		this(catalog, URIHandler.DEFAULT_HANDLERS, ContentHandler.Registry.INSTANCE.contentHandlers(), converter)
	}

	/**
	 * Initialize an CatalogURIConverter using an OMLCatalog
	 * as the basis for URI normalization and a parent URIConverter for other cases.
	 */
	new(OMLCatalog catalog, Collection<URIHandler> uriHandlers, Collection<ContentHandler> contentHandlers,
		URIConverter converter) {
		super(uriHandlers, contentHandlers)
		this.catalog = catalog
		this.uriConverter = converter
		
		switch converter {
			CatalogURIConverter:
				throw new IllegalArgumentException("A CatalogURIConverter cannot be the parent of another CatalogURIConverter!")
			default: {
			}
		}
	}

	/**
	 * Normalizing a URI is resolving that URI according to the rewrite rules defined in an OASIS XML Catalog.
	 * If the catalog fails to resolve the URI to a file, then this method requires a parent uriConverter
	 * to delegate normalizing the URI.
	 */
	override def URI normalize(URI uri) {
		if (uri.file)
			uri
		else if (uri.platform) {
			val purl = new URL(uri.toString)
			val furl = FileLocator.toFileURL(purl)
			if (furl != purl)
				URI.createFileURI(furl.file)
			else
				throw new IllegalArgumentException(
					"CatalogURIConverter.normalize() failed to resolve platform URI: " + uri)
		} else {
			val resolved = catalog.resolveURI(uri.toString)
			if (null !== resolved && resolved.startsWith("file:"))
				URI.createURI(resolved)
			else if (null !== uriConverter)
				uriConverter.normalize(uri)
			else
				throw new IllegalArgumentException('''No parent URIConverter and no catalog mapping for URI: «uri»''')
		}
	}

	/**
	 * This logic is similar to EMF's ResourceImpl.createOutputStream except for
	 * the 'file.extension' appended after URIConverter mapping if it is not present.
	 */
	override def OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		val normalized = normalize(uri)
		val normalizedExt = normalized.fileExtension
		val fileExtension = options?.get("file.extension")
		switch fileExtension {
			String: 
				if (!fileExtension.nullOrEmpty) {
					val normalizedFileURI = 
					if (null === normalizedExt)
						normalized.appendFileExtension(fileExtension)
					else if (normalizedExt == fileExtension)
						normalized
					else
						throw new IllegalArgumentException(
							'''CatalogURIConverter.createOutputStream() invalid URI file extension «normalizedExt» should be instead «fileExtension» in normalized URI: «normalized»''')
						
					getURIHandler(normalizedFileURI).createOutputStream(normalizedFileURI,
						new OptionsMap(URIConverter.OPTION_URI_CONVERTER, this, options))
				} else
					throw new IllegalArgumentException(
						"CatalogURIConverter.createOutputStream() requires the option: 'file.extension' to append a resource-specific OML file extension.")
						
			default:
				if (null !== uriConverter)
					uriConverter.createOutputStream(uri, options)
				else
					throw new IllegalArgumentException(
						"CatalogURIConverter.createOutputStream() requires the option: 'file.extension' to append a resource-specific OML file extension.")
		}
	}

	/**
	 * This logic is similar to EMF's ResourceImpl.createInputStream except for
	 * the 'file.extension' appended after URIConverter mapping if it is not present.
	 */
	override def InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		val normalized = normalize(uri)
		val normalizedExt = normalized.fileExtension
		val fileExtension = options?.get("file.extension")
		switch fileExtension {
			String:
				if (!fileExtension.nullOrEmpty) {
					val normalizedFileURI = 
					if (null === normalizedExt)
						normalized.appendFileExtension(fileExtension)
					else if (normalizedExt == fileExtension)
						normalized
					else
						throw new IllegalArgumentException(
							'''CatalogURIConverter.createInputStream() invalid URI file extension «normalizedExt» should be instead «fileExtension» in normalized URI: «normalized»''')
						
					getURIHandler(normalizedFileURI).createInputStream(normalizedFileURI,
						new OptionsMap(URIConverter.OPTION_URI_CONVERTER, this, options))
				} else
					throw new IllegalArgumentException(
						"CatalogURIConverter.createInputStream() requires the option: 'file.extension' to append a resource-specific OML file extension.")
				
			default:
				if (null !== uriConverter)
					uriConverter.createInputStream(uri, options)
				else
					throw new IllegalArgumentException(
						"CatalogURIConverter.createInputStream() requires the option: 'file.extension' to append a resource-specific OML file extension.")
		}
	}

	/*
	 * Xtend equivalent of the private definition in org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl.OptionMap
	 */
	static public class OptionsMap implements Map<Object, Object> {
		private static final Object NO_KEY = new Object()

		protected Object key
		protected Object value
		protected Map<?, ?> options
		protected Map<?, ?> defaultOptions
		protected Map<Object, Object> mergedMap

		public new(Object key, Object value, Map<?, ?> options) {
			this(key, value, options, null)
		}

		public new(Map<?, ?> options, Map<?, ?> defaultOptions) {
			this(NO_KEY, null, options, defaultOptions)
		}

		public new(Object key, Object value, Map<?, ?> options, Map<?, ?> defaultOptions) {
			this.options = options
			this.defaultOptions = defaultOptions
			this.key = key
			this.value = value
			this.mergedMap = null
		}

		protected def Map<Object, Object> mergedMap() {
			if (null === mergedMap) {
				val optionsCount = if(null === options) 0 else options.size()
				val defaultOptionsCount = if(null === defaultOptions) 0 else defaultOptions.size()
				val keyCount = if(NO_KEY == key) 0 else 1

				mergedMap = new LinkedHashMap<Object, Object>(optionsCount + defaultOptionsCount + keyCount)
				if (null !== defaultOptions)
					mergedMap.putAll(defaultOptions)

				if (null !== options)
					mergedMap.putAll(options)

				if (key != NO_KEY)
					mergedMap.put(key, value)

			}
			mergedMap
		}

		override public def void clear() {
			throw new UnsupportedOperationException();
		}

		override public def boolean containsKey(Object key) {
			if (null !== mergedMap)
				mergedMap.containsKey(key)
			else
				(this.key == key) || (null !== options && options.containsKey(key)) ||
					(null !== defaultOptions && defaultOptions.containsKey(key))
		}

		override public def boolean containsValue(Object value) {
			return mergedMap().containsValue(value);
		}

		override public def Set<Map.Entry<Object, Object>> entrySet() {
			return mergedMap().entrySet();
		}

		override public def Object get(Object key) {
			if (null !== mergedMap)
				mergedMap.get(key)
			else if (this.key == key)
				value
			else if (null !== options && options.containsKey(key))
				options.get(key)
			else if (null !== defaultOptions && defaultOptions.containsKey(key))
				defaultOptions.get(key)
			else
				null
		}

		override public def boolean isEmpty() {
			if (null !== mergedMap)
				mergedMap.isEmpty
			else
				(NO_KEY == key) && (null === options || options.isEmpty) &&
					(null === defaultOptions || defaultOptions.isEmpty)
		}

		override public def Set<Object> keySet() {
			mergedMap().keySet()
		}

		override public def Object put(Object key, Object value) {
			throw new UnsupportedOperationException()
		}

		override public def void putAll(Map<? extends Object, ? extends Object> t) {
			throw new UnsupportedOperationException()
		}

		override public def Object remove(Object key) {
			throw new UnsupportedOperationException()
		}

		override public def int size() {
			mergedMap.size()
		}

		override public def Collection<Object> values() {
			mergedMap.values()
		}

		override public def int hashCode() {
			mergedMap.hashCode()
		}

		override public def boolean equals(Object o) {
			mergedMap === o
		}

		override public def String toString() {
			mergedMap.toString()
		}
	}
}
