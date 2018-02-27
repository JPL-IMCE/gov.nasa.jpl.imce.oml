package gov.nasa.jpl.imce.oml.model.extensions;

import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogEntry;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class OMLCatalog extends Catalog {
  protected Set<URL> parsedCatalogs = new HashSet<URL>();
  
  protected URL parsing = null;
  
  public boolean hasParsedCatalog(final URL aUrl) {
    return this.parsedCatalogs.contains(aUrl);
  }
  
  /**
   * Wrapper around Catalog.parseCatalog(URL) to keep track of the catalogs parsed and to report silent errors.
   */
  @Override
  public synchronized void parseCatalog(final URL aUrl) throws IOException {
    boolean _hasParsedCatalog = this.hasParsedCatalog(aUrl);
    boolean _not = (!_hasParsedCatalog);
    if (_not) {
      this.parsing = aUrl;
      super.parseCatalog(aUrl);
      if ((null != this.parsing)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Failed to parse catalog: ");
        _builder.append(aUrl);
        throw new IOException(_builder.toString());
      }
    }
  }
  
  @Override
  protected synchronized void parsePendingCatalogs() throws MalformedURLException, IOException {
    super.parsePendingCatalogs();
    if ((null != this.parsing)) {
      this.parsedCatalogs.add(this.parsing);
    }
    this.parsing = null;
  }
  
  public Set<URL> getParsedCatalogs() {
    return ImmutableSet.<URL>copyOf(this.parsedCatalogs);
  }
  
  public Vector<CatalogEntry> entries() {
    return this.catalogEntries;
  }
}
