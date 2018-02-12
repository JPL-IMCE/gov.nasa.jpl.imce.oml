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

import com.google.inject.Provider;
import gov.nasa.jpl.imce.oml.dsl.OMLStandaloneSetup;
import gov.nasa.jpl.imce.oml.model.extensions.CatalogURIConverter;
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.zip.OMLZipResource;
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceFactory;
import java.net.URL;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup;
import org.eclipse.xtext.xbase.lib.Exceptions;

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
@SuppressWarnings("all")
public class OMLZipResourceSet extends ResourceSetImpl {
  private final static Provider<OMLZipResource> omlZipResourceProvider = new Provider<OMLZipResource>() {
    @Override
    public OMLZipResource get() {
      OMLZipResource _xblockexpression = null;
      {
        final OMLZipResource r = new OMLZipResource();
        _xblockexpression = r;
      }
      return _xblockexpression;
    }
  };
  
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
  public static void doSetup() {
    XcoreStandaloneSetup.doSetup();
    OMLStandaloneSetup.doSetup();
    Map<String, Object> _contentTypeToFactoryMap = Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap();
    OMLZipResourceFactory _oMLZipResourceFactory = new OMLZipResourceFactory(OMLZipResourceSet.omlZipResourceProvider);
    _contentTypeToFactoryMap.put("omlzip", _oMLZipResourceFactory);
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    OMLZipResourceFactory _oMLZipResourceFactory_1 = new OMLZipResourceFactory(OMLZipResourceSet.omlZipResourceProvider);
    _extensionToFactoryMap.put("omlzip", _oMLZipResourceFactory_1);
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
  public static OMLCatalog configure(final ResourceSet rs, final URL omlCatalogFile) {
    try {
      OMLCatalog _xblockexpression = null;
      {
        final OMLCatalog c = OMLExtensions.getCatalog(rs);
        if ((null == c)) {
          throw new IllegalArgumentException("OMLZipResourceSet.configure: no OMLCatalog on this resource set!");
        }
        c.parseCatalog(omlCatalogFile);
        _xblockexpression = c;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected CatalogURIConverter catalogURIConverter;
  
  /**
   * Returns the CatalogURIConverter constructed at initialization from parsing an OASIS XML Catalog file in an OMLCatalog.
   */
  public CatalogURIConverter getCatalogURIConverter() {
    if ((null == this.catalogURIConverter)) {
      throw new IllegalArgumentException("OMLZipResourceSet.getCatalogURIConverter: not yet configured!");
    }
    return this.catalogURIConverter;
  }
  
  /**
   * Parse the OASIS XML Catalog file (omlCatalogFile) in an OMLCatalog to initialize this OMLZipResourceSet.
   */
  public OMLZipResourceSet(final URL omlCatalogFile) {
    final OMLCatalog c = OMLZipResourceSet.configure(this, omlCatalogFile);
    CatalogURIConverter _catalogURIConverter = new CatalogURIConverter(c);
    this.catalogURIConverter = _catalogURIConverter;
  }
  
  /**
   * Create an OMLZipREsource.
   */
  @Override
  public Resource createResource(final URI uri) {
    Resource _xblockexpression = null;
    {
      final String last = uri.lastSegment();
      Resource _xifexpression = null;
      if ((null == last)) {
        _xifexpression = super.createResource(uri, "omlzip");
      } else {
        Resource _xifexpression_1 = null;
        boolean _endsWith = last.endsWith(".oml");
        if (_endsWith) {
          _xifexpression_1 = this.createResource(uri, "oml");
        } else {
          Resource _xifexpression_2 = null;
          boolean _endsWith_1 = last.endsWith(".omlzip");
          if (_endsWith_1) {
            _xifexpression_2 = this.createResource(uri, "omlzip");
          } else {
            _xifexpression_2 = super.createResource(uri);
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  protected Resource demandCreateResource(final URI uri) {
    final Resource r = this.createResource(uri);
    return r;
  }
}
