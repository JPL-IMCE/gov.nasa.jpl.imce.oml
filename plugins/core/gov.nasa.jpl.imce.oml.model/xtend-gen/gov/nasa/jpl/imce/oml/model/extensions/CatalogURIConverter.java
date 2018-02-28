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

import com.google.common.base.Objects;
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
@SuppressWarnings("all")
public class CatalogURIConverter extends ExtensibleURIConverterImpl {
  /**
   * Xtend equivalent of the private definition in org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl.OptionMap
   */
  public static class OptionsMap implements Map<Object, Object> {
    private final static Object NO_KEY = new Object();
    
    protected Object key;
    
    protected Object value;
    
    protected Map<?, ?> options;
    
    protected Map<?, ?> defaultOptions;
    
    protected Map<Object, Object> mergedMap;
    
    public OptionsMap(final Object key, final Object value, final Map<?, ?> options) {
      this(key, value, options, null);
    }
    
    public OptionsMap(final Map<?, ?> options, final Map<?, ?> defaultOptions) {
      this(CatalogURIConverter.OptionsMap.NO_KEY, null, options, defaultOptions);
    }
    
    public OptionsMap(final Object key, final Object value, final Map<?, ?> options, final Map<?, ?> defaultOptions) {
      this.options = options;
      this.defaultOptions = defaultOptions;
      this.key = key;
      this.value = value;
      this.mergedMap = null;
    }
    
    protected Map<Object, Object> mergedMap() {
      Map<Object, Object> _xblockexpression = null;
      {
        if ((null == this.mergedMap)) {
          int _xifexpression = (int) 0;
          if ((null == this.options)) {
            _xifexpression = 0;
          } else {
            _xifexpression = this.options.size();
          }
          final int optionsCount = _xifexpression;
          int _xifexpression_1 = (int) 0;
          if ((null == this.defaultOptions)) {
            _xifexpression_1 = 0;
          } else {
            _xifexpression_1 = this.defaultOptions.size();
          }
          final int defaultOptionsCount = _xifexpression_1;
          int _xifexpression_2 = (int) 0;
          boolean _equals = Objects.equal(CatalogURIConverter.OptionsMap.NO_KEY, this.key);
          if (_equals) {
            _xifexpression_2 = 0;
          } else {
            _xifexpression_2 = 1;
          }
          final int keyCount = _xifexpression_2;
          LinkedHashMap<Object, Object> _linkedHashMap = new LinkedHashMap<Object, Object>(((optionsCount + defaultOptionsCount) + keyCount));
          this.mergedMap = _linkedHashMap;
          if ((null != this.defaultOptions)) {
            this.mergedMap.putAll(this.defaultOptions);
          }
          if ((null != this.options)) {
            this.mergedMap.putAll(this.options);
          }
          boolean _notEquals = (!Objects.equal(this.key, CatalogURIConverter.OptionsMap.NO_KEY));
          if (_notEquals) {
            this.mergedMap.put(this.key, this.value);
          }
        }
        _xblockexpression = this.mergedMap;
      }
      return _xblockexpression;
    }
    
    @Override
    public void clear() {
      throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean containsKey(final Object key) {
      boolean _xifexpression = false;
      if ((null != this.mergedMap)) {
        _xifexpression = this.mergedMap.containsKey(key);
      } else {
        _xifexpression = ((Objects.equal(this.key, key) || ((null != this.options) && this.options.containsKey(key))) || ((null != this.defaultOptions) && this.defaultOptions.containsKey(key)));
      }
      return _xifexpression;
    }
    
    @Override
    public boolean containsValue(final Object value) {
      return this.mergedMap().containsValue(value);
    }
    
    @Override
    public Set<Map.Entry<Object, Object>> entrySet() {
      return this.mergedMap().entrySet();
    }
    
    @Override
    public Object get(final Object key) {
      Object _xifexpression = null;
      if ((null != this.mergedMap)) {
        _xifexpression = this.mergedMap.get(key);
      } else {
        Object _xifexpression_1 = null;
        boolean _equals = Objects.equal(this.key, key);
        if (_equals) {
          _xifexpression_1 = this.value;
        } else {
          Object _xifexpression_2 = null;
          if (((null != this.options) && this.options.containsKey(key))) {
            _xifexpression_2 = this.options.get(key);
          } else {
            Object _xifexpression_3 = null;
            if (((null != this.defaultOptions) && this.defaultOptions.containsKey(key))) {
              _xifexpression_3 = this.defaultOptions.get(key);
            } else {
              _xifexpression_3 = null;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    }
    
    @Override
    public boolean isEmpty() {
      boolean _xifexpression = false;
      if ((null != this.mergedMap)) {
        _xifexpression = this.mergedMap.isEmpty();
      } else {
        _xifexpression = ((Objects.equal(CatalogURIConverter.OptionsMap.NO_KEY, this.key) && ((null == this.options) || this.options.isEmpty())) && ((null == this.defaultOptions) || this.defaultOptions.isEmpty()));
      }
      return _xifexpression;
    }
    
    @Override
    public Set<Object> keySet() {
      return this.mergedMap().keySet();
    }
    
    @Override
    public Object put(final Object key, final Object value) {
      throw new UnsupportedOperationException();
    }
    
    @Override
    public void putAll(final Map<?, ?> t) {
      throw new UnsupportedOperationException();
    }
    
    @Override
    public Object remove(final Object key) {
      throw new UnsupportedOperationException();
    }
    
    @Override
    public int size() {
      return this.mergedMap.size();
    }
    
    @Override
    public Collection<Object> values() {
      return this.mergedMap.values();
    }
    
    @Override
    public int hashCode() {
      return this.mergedMap.hashCode();
    }
    
    @Override
    public boolean equals(final Object o) {
      return (this.mergedMap == o);
    }
    
    @Override
    public String toString() {
      return this.mergedMap.toString();
    }
  }
  
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
    boolean _matched = false;
    if (converter instanceof CatalogURIConverter) {
      _matched=true;
      throw new IllegalArgumentException("A CatalogURIConverter cannot be the parent of another CatalogURIConverter!");
    }
  }
  
  /**
   * Normalizing a URI is resolving that URI according to the rewrite rules defined in an OASIS XML Catalog.
   * If the catalog fails to resolve the URI to a file, then this method requires a parent uriConverter
   * to delegate normalizing the URI.
   */
  @Override
  public URI normalize(final URI uri) {
    try {
      URI _xifexpression = null;
      boolean _isFile = uri.isFile();
      if (_isFile) {
        _xifexpression = uri;
      } else {
        URI _xifexpression_1 = null;
        boolean _isPlatform = uri.isPlatform();
        if (_isPlatform) {
          URI _xblockexpression = null;
          {
            String _string = uri.toString();
            final URL purl = new URL(_string);
            final URL furl = FileLocator.toFileURL(purl);
            URI _xifexpression_2 = null;
            boolean _notEquals = (!Objects.equal(furl, purl));
            if (_notEquals) {
              _xifexpression_2 = URI.createFileURI(furl.getFile());
            } else {
              throw new IllegalArgumentException(
                ("CatalogURIConverter.normalize() failed to resolve platform URI: " + uri));
            }
            _xblockexpression = _xifexpression_2;
          }
          _xifexpression_1 = _xblockexpression;
        } else {
          URI _xblockexpression_1 = null;
          {
            final String resolved = this.catalog.resolveURI(uri.toString());
            URI _xifexpression_2 = null;
            if (((null != resolved) && resolved.startsWith("file:"))) {
              _xifexpression_2 = URI.createURI(resolved);
            } else {
              URI _xifexpression_3 = null;
              if ((null != this.uriConverter)) {
                _xifexpression_3 = this.uriConverter.normalize(uri);
              } else {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("No parent URIConverter and no catalog mapping for URI: ");
                _builder.append(uri);
                throw new IllegalArgumentException(_builder.toString());
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xblockexpression_1 = _xifexpression_2;
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * This logic is similar to EMF's ResourceImpl.createOutputStream except for
   * the 'file.extension' appended after URIConverter mapping if it is not present.
   */
  @Override
  public OutputStream createOutputStream(final URI uri, final Map<?, ?> options) throws IOException {
    OutputStream _xblockexpression = null;
    {
      final URI normalized = this.normalize(uri);
      final String normalizedExt = normalized.fileExtension();
      Object _get = null;
      if (options!=null) {
        _get=options.get("file.extension");
      }
      final Object fileExtension = _get;
      OutputStream _switchResult = null;
      boolean _matched = false;
      if (fileExtension instanceof String) {
        _matched=true;
        OutputStream _xifexpression = null;
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(((String)fileExtension));
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          OutputStream _xblockexpression_1 = null;
          {
            URI _xifexpression_1 = null;
            if ((null == normalizedExt)) {
              _xifexpression_1 = normalized.appendFileExtension(((String)fileExtension));
            } else {
              URI _xifexpression_2 = null;
              boolean _equals = Objects.equal(normalizedExt, fileExtension);
              if (_equals) {
                _xifexpression_2 = normalized;
              } else {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("CatalogURIConverter.createOutputStream() invalid URI file extension ");
                _builder.append(normalizedExt);
                _builder.append(" should be instead ");
                _builder.append(((String)fileExtension));
                _builder.append(" in normalized URI: ");
                _builder.append(normalized);
                throw new IllegalArgumentException(_builder.toString());
              }
              _xifexpression_1 = _xifexpression_2;
            }
            final URI normalizedFileURI = _xifexpression_1;
            URIHandler _uRIHandler = this.getURIHandler(normalizedFileURI);
            CatalogURIConverter.OptionsMap _optionsMap = new CatalogURIConverter.OptionsMap(URIConverter.OPTION_URI_CONVERTER, this, options);
            _xblockexpression_1 = _uRIHandler.createOutputStream(normalizedFileURI, _optionsMap);
          }
          _xifexpression = _xblockexpression_1;
        } else {
          throw new IllegalArgumentException(
            "CatalogURIConverter.createOutputStream() requires the option: \'file.extension\' to append a resource-specific OML file extension.");
        }
        _switchResult = _xifexpression;
      }
      if (!_matched) {
        OutputStream _xifexpression = null;
        if ((null != this.uriConverter)) {
          _xifexpression = this.uriConverter.createOutputStream(uri, options);
        } else {
          throw new IllegalArgumentException(
            "CatalogURIConverter.createOutputStream() requires the option: \'file.extension\' to append a resource-specific OML file extension.");
        }
        _switchResult = _xifexpression;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  /**
   * This logic is similar to EMF's ResourceImpl.createInputStream except for
   * the 'file.extension' appended after URIConverter mapping if it is not present.
   */
  @Override
  public InputStream createInputStream(final URI uri, final Map<?, ?> options) throws IOException {
    InputStream _xblockexpression = null;
    {
      final URI normalized = this.normalize(uri);
      final String normalizedExt = normalized.fileExtension();
      Object _get = null;
      if (options!=null) {
        _get=options.get("file.extension");
      }
      final Object fileExtension = _get;
      InputStream _switchResult = null;
      boolean _matched = false;
      if (fileExtension instanceof String) {
        _matched=true;
        InputStream _xifexpression = null;
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(((String)fileExtension));
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          InputStream _xblockexpression_1 = null;
          {
            URI _xifexpression_1 = null;
            if ((null == normalizedExt)) {
              _xifexpression_1 = normalized.appendFileExtension(((String)fileExtension));
            } else {
              URI _xifexpression_2 = null;
              boolean _equals = Objects.equal(normalizedExt, fileExtension);
              if (_equals) {
                _xifexpression_2 = normalized;
              } else {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("CatalogURIConverter.createInputStream() invalid URI file extension ");
                _builder.append(normalizedExt);
                _builder.append(" should be instead ");
                _builder.append(((String)fileExtension));
                _builder.append(" in normalized URI: ");
                _builder.append(normalized);
                throw new IllegalArgumentException(_builder.toString());
              }
              _xifexpression_1 = _xifexpression_2;
            }
            final URI normalizedFileURI = _xifexpression_1;
            URIHandler _uRIHandler = this.getURIHandler(normalizedFileURI);
            CatalogURIConverter.OptionsMap _optionsMap = new CatalogURIConverter.OptionsMap(URIConverter.OPTION_URI_CONVERTER, this, options);
            _xblockexpression_1 = _uRIHandler.createInputStream(normalizedFileURI, _optionsMap);
          }
          _xifexpression = _xblockexpression_1;
        } else {
          throw new IllegalArgumentException(
            "CatalogURIConverter.createInputStream() requires the option: \'file.extension\' to append a resource-specific OML file extension.");
        }
        _switchResult = _xifexpression;
      }
      if (!_matched) {
        InputStream _xifexpression = null;
        if ((null != this.uriConverter)) {
          _xifexpression = this.uriConverter.createInputStream(uri, options);
        } else {
          throw new IllegalArgumentException(
            "CatalogURIConverter.createInputStream() requires the option: \'file.extension\' to append a resource-specific OML file extension.");
        }
        _switchResult = _xifexpression;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
