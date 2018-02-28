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

import com.google.common.base.Objects;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.extensions.CatalogURIConverter;
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.zip.OMLSpecificationTables;
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceSet;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * An OMLZipResource is a kind of Resource that is loaded from and saved to an *.omlzip file
 * whose location corresponds to the mapping of the Resource URI according to the OMLCatalog
 * associated with its OMLZipResourceSet.
 * 
 * Similar to OMLXtextResource, an OMLZipResource specifies in default load/save options
 * the `file.extension' for OMLZipResource, i.e., 'omlzip'.
 */
@SuppressWarnings("all")
public class OMLZipResource extends ResourceImpl {
  private final static String OML_SPECIFICATION_TABLES = "OMLSpecificationTables";
  
  public static OMLSpecificationTables getOrInitializeOMLSpecificationTables(final ResourceSet rs) {
    OMLSpecificationTables _xblockexpression = null;
    {
      boolean _containsKey = rs.getLoadOptions().containsKey(OMLZipResource.OML_SPECIFICATION_TABLES);
      boolean _not = (!_containsKey);
      if (_not) {
        final OMLSpecificationTables tables = new OMLSpecificationTables();
        rs.getLoadOptions().put(OMLZipResource.OML_SPECIFICATION_TABLES, tables);
        final Consumer<Resource> _function = (Resource r) -> {
          final Consumer<EObject> _function_1 = (EObject e) -> {
            boolean _matched = false;
            if (e instanceof Extent) {
              _matched=true;
              final Consumer<Module> _function_2 = (Module m) -> {
                tables.queueModule(m);
              };
              ((Extent)e).getModules().forEach(_function_2);
            }
          };
          r.getContents().forEach(_function_1);
        };
        rs.getResources().forEach(_function);
        tables.processQueue(rs);
      }
      final Object tables_1 = rs.getLoadOptions().get(OMLZipResource.OML_SPECIFICATION_TABLES);
      OMLSpecificationTables _switchResult = null;
      boolean _matched = false;
      if (tables_1 instanceof OMLSpecificationTables) {
        _matched=true;
        _switchResult = ((OMLSpecificationTables)tables_1);
      }
      if (!_matched) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("OMLZipResource.initializeOMLSpecificationTables: should be already initialized, instead got: ");
        _builder.append(tables_1);
        throw new IllegalArgumentException(_builder.toString());
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static void clearOMLSpecificationTables(final ResourceSet rs) {
    boolean _containsKey = rs.getLoadOptions().containsKey(OMLZipResource.OML_SPECIFICATION_TABLES);
    boolean _not = (!_containsKey);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("OMLZipResource.initializeOMLSpecificationTables: not initialized!");
      throw new IllegalArgumentException(_builder.toString());
    }
    rs.getLoadOptions().remove(OMLZipResource.OML_SPECIFICATION_TABLES);
  }
  
  private final static Map<Object, Object> defaultOptions = new Function0<Map<Object, Object>>() {
    public Map<Object, Object> apply() {
      HashMap<Object, Object> _xblockexpression = null;
      {
        final HashMap<Object, Object> options = new HashMap<Object, Object>();
        options.put("file.extension", "omlzip");
        _xblockexpression = options;
      }
      return _xblockexpression;
    }
  }.apply();
  
  private CatalogURIConverter uriConverter = null;
  
  public OMLZipResource() {
    super();
    this.defaultLoadOptions = OMLZipResource.defaultOptions;
    this.defaultSaveOptions = OMLZipResource.defaultOptions;
  }
  
  /**
   * The URIConverter of an OMLZipResource is
   * the CatalogURIConverter associated with its OMLZipResourceSet.
   */
  @Override
  protected URIConverter getURIConverter() {
    CatalogURIConverter _xblockexpression = null;
    {
      final ResourceSet rs = this.getResourceSet();
      boolean _matched = false;
      if (rs instanceof OMLZipResourceSet) {
        _matched=true;
        this.uriConverter = ((OMLZipResourceSet)rs).getCatalogURIConverter();
      }
      if (!_matched) {
        {
          final OMLCatalog omlCatalog = OMLExtensions.getCatalog(rs);
          if ((null == omlCatalog)) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("OMLZipResource.getURIConverter: there must be an OMLCatalog on the resource set!");
            throw new IllegalArgumentException(_builder.toString());
          }
          CatalogURIConverter _catalogURIConverter = new CatalogURIConverter(omlCatalog);
          this.uriConverter = _catalogURIConverter;
        }
      }
      _xblockexpression = this.uriConverter;
    }
    return _xblockexpression;
  }
  
  /**
   * Loading an OMLZipResource involves mapping its URI to an *.omlzip file according to the CatalogURIConverter associated with its ResourceSet.
   * If successful, the contents of the loaded OMLZipResource is a single toplevel OML Extent whose contents
   * is the result of parsing all the tables in the *.omlzip file.
   */
  @Override
  public void load(final Map<?, ?> options) throws IOException {
    System.out.println(("OMLZip. Loading: " + this.uri));
    final long started = System.currentTimeMillis();
    Map<?, ?> _xifexpression = null;
    if ((null == options)) {
      _xifexpression = new HashMap<Object, Object>();
    } else {
      Map<?, ?> _xblockexpression = null;
      {
        Object _elvis = null;
        Object _get = options.get(URIConverter.OPTION_RESPONSE);
        if (_get != null) {
          _elvis = _get;
        } else {
          HashMap<Object, Object> _hashMap = new HashMap<Object, Object>();
          _elvis = _hashMap;
        }
        final Object r = _elvis;
        Map<?, ?> _switchResult = null;
        boolean _matched = false;
        if (r instanceof Map) {
          _matched=true;
          _switchResult = ((Map<?, ?>)r);
        }
        if (!_matched) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("OMLZipResource.load(options) the entry for ");
          _builder.append(URIConverter.OPTION_RESPONSE);
          _builder.append(" must be a Map<Object,Object>!");
          throw new IllegalArgumentException(_builder.toString());
        }
        _xblockexpression = _switchResult;
      }
      _xifexpression = _xblockexpression;
    }
    final Map<?, ?> response = _xifexpression;
    final CatalogURIConverter.OptionsMap effectiveOptions = new CatalogURIConverter.OptionsMap(URIConverter.OPTION_RESPONSE, response, options, 
      this.defaultLoadOptions);
    final ResourceSet rs = this.getResourceSet();
    boolean _matched = false;
    if (rs instanceof OMLZipResourceSet) {
      _matched=true;
      File _switchResult_1 = null;
      String _scheme = this.uri.scheme();
      if (_scheme != null) {
        switch (_scheme) {
          case "http":
            File _xblockexpression_1 = null;
            {
              final URI normalized = ((OMLZipResourceSet)rs).getCatalogURIConverter().normalize(this.uri);
              final String normalizedExt = normalized.fileExtension();
              Object _get = null;
              if (effectiveOptions!=null) {
                _get=effectiveOptions.get("file.extension");
              }
              final Object fileExtension = _get;
              File _switchResult_2 = null;
              boolean _matched_1 = false;
              if (fileExtension instanceof String) {
                _matched_1=true;
                File _xifexpression_1 = null;
                boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(((String)fileExtension));
                boolean _not = (!_isNullOrEmpty);
                if (_not) {
                  File _xblockexpression_2 = null;
                  {
                    URI _xifexpression_2 = null;
                    if ((null == normalizedExt)) {
                      _xifexpression_2 = normalized.appendFileExtension(((String)fileExtension));
                    } else {
                      URI _xifexpression_3 = null;
                      boolean _equals = Objects.equal(normalizedExt, fileExtension);
                      if (_equals) {
                        _xifexpression_3 = normalized;
                      } else {
                        StringConcatenation _builder = new StringConcatenation();
                        _builder.append("OMLZipResource.load(options) invalid URI file extension ");
                        _builder.append(normalizedExt);
                        _builder.append(" should be instead ");
                        _builder.append(((String)fileExtension));
                        _builder.append(" in normalized URI: ");
                        _builder.append(normalized);
                        throw new IllegalArgumentException(_builder.toString());
                      }
                      _xifexpression_2 = _xifexpression_3;
                    }
                    final URI normalizedFileURI = _xifexpression_2;
                    String _fileString = normalizedFileURI.toFileString();
                    _xblockexpression_2 = new File(_fileString);
                  }
                  _xifexpression_1 = _xblockexpression_2;
                } else {
                  throw new IllegalArgumentException(
                    ("OMLZipResource.load() requires a non-null \'file.extension\' option: " + this.uri));
                }
                _switchResult_2 = _xifexpression_1;
              }
              _xblockexpression_1 = _switchResult_2;
            }
            _switchResult_1 = _xblockexpression_1;
            break;
          case "platform":
            File _xblockexpression_2 = null;
            {
              String _string = this.uri.toString();
              final URL purl = new URL(_string);
              final URL furl = FileLocator.toFileURL(purl);
              File _xifexpression_1 = null;
              boolean _notEquals = (!Objects.equal(furl, purl));
              if (_notEquals) {
                String _file = furl.getFile();
                _xifexpression_1 = new File(_file);
              } else {
                throw new IllegalArgumentException(
                  ("OMLZipResource.load() failed to resolve platform URL: " + this.uri));
              }
              _xblockexpression_2 = _xifexpression_1;
            }
            _switchResult_1 = _xblockexpression_2;
            break;
          default:
            File _xifexpression_1 = null;
            boolean _isFile = this.uri.isFile();
            if (_isFile) {
              String _fileString = this.uri.toFileString();
              _xifexpression_1 = new File(_fileString);
            } else {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("OMLZipResource.load(): unrecognized URI scheme in: ");
              _builder.append(this.uri);
              _builder.append(" (must be either http or file): ");
              boolean _isFile_1 = this.uri.isFile();
              _builder.append(_isFile_1);
              throw new IllegalArgumentException(_builder.toString());
            }
            _switchResult_1 = _xifexpression_1;
            break;
        }
      } else {
        File _xifexpression_1 = null;
        boolean _isFile = this.uri.isFile();
        if (_isFile) {
          String _fileString = this.uri.toFileString();
          _xifexpression_1 = new File(_fileString);
        } else {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("OMLZipResource.load(): unrecognized URI scheme in: ");
          _builder.append(this.uri);
          _builder.append(" (must be either http or file): ");
          boolean _isFile_1 = this.uri.isFile();
          _builder.append(_isFile_1);
          throw new IllegalArgumentException(_builder.toString());
        }
        _switchResult_1 = _xifexpression_1;
      }
      final File omlFile = _switchResult_1;
      boolean _exists = omlFile.exists();
      boolean _not = (!_exists);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("OMLZipResource.load(): URI: ");
        _builder_1.append(this.uri);
        _builder_1.append(" resolves to a non-existent file: ");
        _builder_1.append(omlFile);
        throw new IllegalArgumentException(_builder_1.toString());
      }
      OMLSpecificationTables.load(rs, this, omlFile);
    }
    if (!_matched) {
      {
        final OMLCatalog c = OMLExtensions.getCatalog(rs);
        if ((null == c)) {
          throw new IllegalArgumentException(
            "OMLZipResource.load(): requires an OMLCatalog on this resource set!");
        }
        File _switchResult_1 = null;
        String _scheme = this.uri.scheme();
        if (_scheme != null) {
          switch (_scheme) {
            case "http":
              File _xblockexpression_1 = null;
              {
                final String resolved = c.resolveURI(this.uri.toString());
                if (((null == resolved) || (!resolved.startsWith("file:")))) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("OMLZipResource.load(): No catalog mapping for URI: ");
                  _builder.append(this.uri);
                  throw new IllegalArgumentException(_builder.toString());
                }
                final URI resolvedURI = URI.createURI(resolved);
                final String resolvedExt = resolvedURI.fileExtension();
                Object _get = null;
                if (effectiveOptions!=null) {
                  _get=effectiveOptions.get("file.extension");
                }
                final Object fileExtension = _get;
                File _switchResult_2 = null;
                boolean _matched_1 = false;
                if (fileExtension instanceof String) {
                  _matched_1=true;
                  File _xifexpression_1 = null;
                  boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(((String)fileExtension));
                  boolean _not = (!_isNullOrEmpty);
                  if (_not) {
                    File _xblockexpression_2 = null;
                    {
                      URI _xifexpression_2 = null;
                      if ((null == resolvedExt)) {
                        _xifexpression_2 = resolvedURI.appendFileExtension(((String)fileExtension));
                      } else {
                        URI _xifexpression_3 = null;
                        boolean _equals = Objects.equal(resolvedExt, fileExtension);
                        if (_equals) {
                          _xifexpression_3 = resolvedURI;
                        } else {
                          StringConcatenation _builder_1 = new StringConcatenation();
                          _builder_1.append("OMLZipResource.load(options) invalid URI file extension ");
                          _builder_1.append(resolvedExt);
                          _builder_1.append(" should be instead ");
                          _builder_1.append(((String)fileExtension));
                          _builder_1.append(" in resolved URI: ");
                          _builder_1.append(resolvedURI);
                          throw new IllegalArgumentException(_builder_1.toString());
                        }
                        _xifexpression_2 = _xifexpression_3;
                      }
                      final URI normalizedFileURI = _xifexpression_2;
                      String _fileString = normalizedFileURI.toFileString();
                      _xblockexpression_2 = new File(_fileString);
                    }
                    _xifexpression_1 = _xblockexpression_2;
                  } else {
                    throw new IllegalArgumentException(
                      ("OMLZipResource.load() requires a non-null \'file.extension\' option: " + this.uri));
                  }
                  _switchResult_2 = _xifexpression_1;
                }
                _xblockexpression_1 = _switchResult_2;
              }
              _switchResult_1 = _xblockexpression_1;
              break;
            case "platform":
              File _xblockexpression_2 = null;
              {
                String _string = this.uri.toString();
                final URL purl = new URL(_string);
                final URL furl = FileLocator.toFileURL(purl);
                File _xifexpression_1 = null;
                boolean _notEquals = (!Objects.equal(furl, purl));
                if (_notEquals) {
                  String _file = furl.getFile();
                  _xifexpression_1 = new File(_file);
                } else {
                  throw new IllegalArgumentException(
                    ("OMLZipResource.load() failed to resolve platform URL: " + this.uri));
                }
                _xblockexpression_2 = _xifexpression_1;
              }
              _switchResult_1 = _xblockexpression_2;
              break;
            default:
              File _xifexpression_1 = null;
              boolean _isFile = this.uri.isFile();
              if (_isFile) {
                String _fileString = this.uri.toFileString();
                _xifexpression_1 = new File(_fileString);
              } else {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("OMLZipResource.load(): unrecognized URI scheme in: ");
                _builder.append(this.uri);
                _builder.append(" (must be either http or file): ");
                boolean _isFile_1 = this.uri.isFile();
                _builder.append(_isFile_1);
                throw new IllegalArgumentException(_builder.toString());
              }
              _switchResult_1 = _xifexpression_1;
              break;
          }
        } else {
          File _xifexpression_1 = null;
          boolean _isFile = this.uri.isFile();
          if (_isFile) {
            String _fileString = this.uri.toFileString();
            _xifexpression_1 = new File(_fileString);
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("OMLZipResource.load(): unrecognized URI scheme in: ");
            _builder.append(this.uri);
            _builder.append(" (must be either http or file): ");
            boolean _isFile_1 = this.uri.isFile();
            _builder.append(_isFile_1);
            throw new IllegalArgumentException(_builder.toString());
          }
          _switchResult_1 = _xifexpression_1;
        }
        final File omlFile = _switchResult_1;
        boolean _exists = omlFile.exists();
        boolean _not = (!_exists);
        if (_not) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("OMLZipResource.load(): URI: ");
          _builder_1.append(this.uri);
          _builder_1.append(" resolves to a non-existent file: ");
          _builder_1.append(omlFile);
          throw new IllegalArgumentException(_builder_1.toString());
        }
        OMLSpecificationTables.load(rs, this, omlFile);
        final long done = System.currentTimeMillis();
        final long delta = (done - started);
        System.out.println((((("OMLZip: Loaded " + this.uri) + " in: ") + Long.valueOf(delta)) + "ms"));
      }
    }
  }
  
  /**
   * Saving an OMLZipResource involves producing a zip archive with multiple Json lines files, one for
   * each OML concrete metaclass and whose contents is precisely the Json serialization of each instance
   * of that concrete metaclass in the OMLZipResource contents.
   */
  @Override
  protected void doSave(final OutputStream outputStream, final Map<?, ?> options) throws IOException {
    final ZipArchiveOutputStream os = new ZipArchiveOutputStream(outputStream);
    try {
      int _size = this.contents.size();
      boolean _notEquals = (1 != _size);
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("OMLZipResource should have 1 OML Extent but it has ");
        int _size_1 = this.contents.size();
        _builder.append(_size_1);
        _builder.append(" toplevel EObjects instead.");
        throw new IllegalArgumentException(_builder.toString());
      }
      final EObject root = this.contents.get(0);
      boolean _matched = false;
      if (root instanceof Extent) {
        _matched=true;
        OMLSpecificationTables.save(((Extent)root), os);
      }
      if (!_matched) {
        String _elvis = null;
        EClass _eClass = null;
        if (root!=null) {
          _eClass=root.eClass();
        }
        String _name = null;
        if (_eClass!=null) {
          _name=_eClass.getName();
        }
        if (_name != null) {
          _elvis = _name;
        } else {
          _elvis = "null";
        }
        String _plus = ("OMLZipResource should have 1 OML Extent but it has " + _elvis);
        throw new IllegalArgumentException(_plus);
      }
    } finally {
      os.close();
    }
  }
  
  public final static Pattern KeyValue = Pattern.compile(
    "\"([^\"]*)\":(null|\"(.*?)\"|\\{\"literalType\":\"[^\"]*\",\"value\":\\[\"(\\\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\\\"|\\n|\\r|[^\"]+?)\")*\\]\\}|\\[\"(\\\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\\\"|\\n|\\r|[^\"]+?)\")*\\]),?");
  
  protected static ArrayList<Map<String, String>> lines2tuples(final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
    while ((!lines.isEmpty())) {
      {
        int _size = lines.size();
        int _minus = (_size - 1);
        final String line = lines.remove(_minus);
        final HashMap<String, String> map = new HashMap<String, String>();
        Assert.isTrue(line.startsWith("{"));
        Assert.isTrue(line.endsWith("}"));
        int _length = line.length();
        int _minus_1 = (_length - 1);
        final String keyValues = line.substring(1, _minus_1);
        final Matcher m = OMLZipResource.KeyValue.matcher(keyValues);
        while (m.find()) {
          {
            final String key = m.group(1);
            String _elvis = null;
            String _group = m.group(3);
            if (_group != null) {
              _elvis = _group;
            } else {
              String _group_1 = m.group(2);
              _elvis = _group_1;
            }
            final String value = _elvis;
            map.put(key, value);
          }
        }
        list.add(map);
      }
    }
    return list;
  }
}
