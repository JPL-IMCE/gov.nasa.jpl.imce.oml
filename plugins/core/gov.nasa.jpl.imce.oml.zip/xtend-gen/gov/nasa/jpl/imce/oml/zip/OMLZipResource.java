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
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.zip.OMLSpecificationTables;
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceSet;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * An OMLZipResource is a kind of Resource that is loaded from and saved to an *.omlzip file
 * whose location corresponds to the mapping of the Resource URI according to the OMLCatalog
 * associated with its OMLZipResourceSet.
 */
@SuppressWarnings("all")
public class OMLZipResource extends ResourceImpl {
  public OMLZipResource(final URI uri) {
    super(uri);
  }
  
  /**
   * The URIConverter of an OMLZipResource is
   * the CatalogURIConverter associated with its OMLZipResourceSet.
   */
  @Override
  protected URIConverter getURIConverter() {
    URIConverter _xblockexpression = null;
    {
      final ResourceSet rs = this.getResourceSet();
      URIConverter _switchResult = null;
      boolean _matched = false;
      if (rs instanceof OMLZipResourceSet) {
        _matched=true;
        _switchResult = ((OMLZipResourceSet)rs).getCatalogURIConverter();
      }
      if (!_matched) {
        _switchResult = super.getURIConverter();
      }
      _xblockexpression = _switchResult;
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
    final ResourceSet rs = this.getResourceSet();
    boolean _matched = false;
    if (rs instanceof OMLZipResourceSet) {
      _matched=true;
      final URI omlZipFile = ((OMLZipResourceSet)rs).getCatalogURIConverter().normalize(this.uri);
      if ((((null == omlZipFile) || (!Objects.equal("file", omlZipFile.scheme()))) || (!omlZipFile.lastSegment().endsWith(".omlzip")))) {
        throw new IllegalArgumentException(((("OMLZipResource.load() requires the uri to be normalized as a file://....*.omlzip; uri=" + this.uri) + " is instead normalized as: ") + omlZipFile));
      }
      String _fileString = omlZipFile.toFileString();
      File _file = new File(_fileString);
      OMLSpecificationTables.load(rs, this, _file);
    }
    if (!_matched) {
      {
        final OMLCatalog c = OMLExtensions.getCatalog(rs);
        if ((null == c)) {
          throw new IllegalArgumentException("OMLZipResource.load(): requires an OMLCatalog on this resource set!");
        }
        File _switchResult_1 = null;
        String _scheme = this.uri.scheme();
        if (_scheme != null) {
          switch (_scheme) {
            case "http":
              File _xblockexpression = null;
              {
                final String resolved = c.resolveURI(this.uri.toString());
                if (((null == resolved) || (!resolved.startsWith("file:")))) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("OMLZipResource.load(): No catalog mapping for URI: ");
                  _builder.append(this.uri);
                  throw new IllegalArgumentException(_builder.toString());
                }
                _xblockexpression = new File((resolved + ".omlzip"));
              }
              _switchResult_1 = _xblockexpression;
              break;
            default:
              File _xifexpression = null;
              boolean _isFile = this.uri.isFile();
              if (_isFile) {
                String _fileString = this.uri.toFileString();
                _xifexpression = new File(_fileString);
              } else {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("OMLZipResource.load(): unrecognized URI scheme in: ");
                _builder.append(this.uri);
                _builder.append(" (must be either http or file): ");
                boolean _isFile_1 = this.uri.isFile();
                _builder.append(_isFile_1);
                throw new IllegalArgumentException(_builder.toString());
              }
              _switchResult_1 = _xifexpression;
              break;
          }
        } else {
          File _xifexpression = null;
          boolean _isFile = this.uri.isFile();
          if (_isFile) {
            String _fileString = this.uri.toFileString();
            _xifexpression = new File(_fileString);
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("OMLZipResource.load(): unrecognized URI scheme in: ");
            _builder.append(this.uri);
            _builder.append(" (must be either http or file): ");
            boolean _isFile_1 = this.uri.isFile();
            _builder.append(_isFile_1);
            throw new IllegalArgumentException(_builder.toString());
          }
          _switchResult_1 = _xifexpression;
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
        int _size_1 = this.contents.size();
        String _plus = ("OMLZipResource should have 1 OML Extent but it has " + Integer.valueOf(_size_1));
        String _plus_1 = (_plus + " toplevel EObjects instead.");
        throw new IllegalArgumentException(_plus_1);
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
        String _plus_2 = ("OMLZipResource should have 1 OML Extent but it has " + _elvis);
        throw new IllegalArgumentException(_plus_2);
      }
    } finally {
      os.close();
    }
  }
  
  public final static Pattern KeyValue = Pattern.compile("\"([^\"]*)\":(null|\"(.*?)\"|\\{\"literalType\":\"[^\"]*\",\"value\":\\[\"(\\\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\\\"|\\n|\\r|[^\"]+?)\")*\\]\\}|\\[\"(\\\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\\\"|\\n|\\r|[^\"]+?)\")*\\]),?");
  
  protected static List<Map<String, String>> lines2tuples(final ArrayList<String> lines) {
    final ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
    final Consumer<String> _function = (String line) -> {
      final HashMap<String, String> map = new HashMap<String, String>();
      Assert.isTrue(line.startsWith("{"));
      Assert.isTrue(line.endsWith("}"));
      int _length = line.length();
      int _minus = (_length - 1);
      final String keyValues = line.substring(1, _minus);
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
    };
    lines.forEach(_function);
    return list;
  }
  
  protected static List<Map<String, String>> lines2tuples(final ArrayList<String> lines, final int limit) {
    final ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
    int i = 0;
    final int max = lines.size();
    while ((i < max)) {
      {
        int _plusPlus = i++;
        final String line = lines.get(_plusPlus);
        final HashMap<String, String> map = new HashMap<String, String>();
        Assert.isTrue(line.startsWith("{"));
        Assert.isTrue(line.endsWith("}"));
        int _length = line.length();
        int _minus = (_length - 1);
        final String keyValues = line.substring(1, _minus);
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
        int _size = list.size();
        int _modulo = (_size % 1000);
        boolean _equals = (0 == _modulo);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("lines2typles: ");
          int _size_1 = list.size();
          _builder.append(_size_1);
          _builder.append(" (");
          int _size_2 = list.size();
          int _multiply = (_size_2 * 100);
          int _size_3 = lines.size();
          int _divide = (_multiply / _size_3);
          _builder.append(_divide);
          _builder.append(")");
          System.out.println(_builder);
        }
        int _size_4 = list.size();
        boolean _greaterThan = (_size_4 > limit);
        if (_greaterThan) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("lines2typles: ");
          int _size_5 = list.size();
          _builder_1.append(_size_5);
          _builder_1.append(" (");
          int _size_6 = list.size();
          _builder_1.append(_size_6);
          _builder_1.append(") exceeds limit (");
          _builder_1.append(limit);
          _builder_1.append(")");
          System.out.println(_builder_1);
          return list;
        }
      }
    }
    return list;
  }
}
