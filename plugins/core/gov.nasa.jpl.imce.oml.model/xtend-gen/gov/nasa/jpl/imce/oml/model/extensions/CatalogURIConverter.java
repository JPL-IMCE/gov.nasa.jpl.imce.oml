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
package gov.nasa.jpl.imce.oml.model.extensions;

import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * CatalogURIConverter is a kind of ExtensibleURIConverterImpl
 * where normalization involves resolving an URI through an OASIS XML Catalog.
 */
@SuppressWarnings("all")
public class CatalogURIConverter extends ExtensibleURIConverterImpl {
  protected URIConverter uriConverter;
  
  protected OMLCatalog catalog;
  
  /**
   * Initialize an CatalogURIConverter using an OMLCatalog
   * as the basis for URI normalization.
   */
  public CatalogURIConverter(final OMLCatalog catalog) {
    this(catalog, URIHandler.DEFAULT_HANDLERS, ContentHandler.Registry.INSTANCE.contentHandlers(), null);
  }
  
  /**
   * Initialize an CatalogURIConverter using an OMLCatalog
   * as the basis for URI normalization and a parent URIConverter for other cases.
   */
  public CatalogURIConverter(final OMLCatalog catalog, final URIConverter converter) {
    this(catalog, URIHandler.DEFAULT_HANDLERS, ContentHandler.Registry.INSTANCE.contentHandlers(), converter);
  }
  
  /**
   * Initialize an CatalogURIConverter using an OMLCatalog
   * as the basis for URI normalization and a parent URIConverter for other cases.
   */
  public CatalogURIConverter(final OMLCatalog catalog, final Collection<URIHandler> uriHandlers, final Collection<ContentHandler> contentHandlers, final URIConverter converter) {
    super(uriHandlers, contentHandlers);
    this.catalog = catalog;
    this.uriConverter = converter;
  }
  
  /**
   * Normalizing a URI is resolving that URI according to the rewrite rules defined in an OASIS XML Catalog.
   */
  @Override
  public URI normalize(final URI uri) {
    try {
      URI _xifexpression = null;
      boolean _isFile = uri.isFile();
      if (_isFile) {
        _xifexpression = uri;
      } else {
        URI _xblockexpression = null;
        {
          final String resolved = this.catalog.resolveURI(uri.toString());
          URI _xifexpression_1 = null;
          if (((null != resolved) && resolved.startsWith("file:"))) {
            _xifexpression_1 = URI.createURI(resolved);
          } else {
            URI _xifexpression_2 = null;
            if ((null != this.uriConverter)) {
              _xifexpression_2 = this.uriConverter.normalize(uri);
            } else {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("No parent URIConverter and no catalog mapping for URI: ");
              _builder.append(uri);
              throw new IllegalArgumentException(_builder.toString());
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xblockexpression = _xifexpression_1;
        }
        _xifexpression = _xblockexpression;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
