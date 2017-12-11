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
import java.util.stream.Stream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

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
   * Loading an OMLZipResource involves mapping its URI to an *.omlzip file according to the CatalogURIConverter associated with its OMLZipResourceSet.
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
      OMLSpecificationTables.load(((OMLZipResourceSet)rs), this, _file);
    }
    if (!_matched) {
      Class<? extends ResourceSet> _class = null;
      if (rs!=null) {
        _class=rs.getClass();
      }
      String _name = null;
      if (_class!=null) {
        _name=_class.getName();
      }
      String _plus = ("OMLZipResource must be loaded within an OMLZipResourceSet, not a " + _name);
      throw new IllegalArgumentException(_plus);
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
  
  protected final static Pattern KeyValue = Pattern.compile("\"([^\"]*)\":\"(.*?)\",?");
  
  protected static List<Map<String, String>> lines2tuples(final Stream<String> lines) {
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
          final String value = m.group(2);
          map.put(key, value);
        }
      }
      list.add(map);
    };
    lines.forEach(_function);
    return list;
  }
}
