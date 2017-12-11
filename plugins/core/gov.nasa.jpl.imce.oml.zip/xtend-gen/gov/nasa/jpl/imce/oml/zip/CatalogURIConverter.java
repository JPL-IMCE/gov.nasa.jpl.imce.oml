/**
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
package gov.nasa.jpl.imce.oml.zip;

import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * CatalogURIConverter is a kind of ExtensibleURIConverterImpl
 * where normalization involves resolving an URI through an OASIS XML Catalog.
 */
@SuppressWarnings("all")
public class CatalogURIConverter extends ExtensibleURIConverterImpl {
  protected OMLCatalog catalog;
  
  /**
   * Initialize an CatalogURIConverter using an OMLCatalog
   * as the basis for URI normalization.
   */
  public CatalogURIConverter(final OMLCatalog catalog) {
    this(catalog, URIHandler.DEFAULT_HANDLERS, ContentHandler.Registry.INSTANCE.contentHandlers());
  }
  
  /**
   * Initialize an CatalogURIConverter using an OMLCatalog
   * as the basis for URI normalization.
   */
  public CatalogURIConverter(final OMLCatalog catalog, final Collection<URIHandler> uriHandlers, final Collection<ContentHandler> contentHandlers) {
    super(uriHandlers, contentHandlers);
    this.catalog = catalog;
  }
  
  /**
   * Normalizing a URI is resolving that URI according to the rewrite rules defined in an OASIS XML Catalog.
   */
  @Override
  public URI normalize(final URI uri) {
    try {
      URI _xblockexpression = null;
      {
        final String resolved = this.catalog.resolveURI(uri.toString());
        _xblockexpression = URI.createURI((resolved + ".omlzip"));
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
