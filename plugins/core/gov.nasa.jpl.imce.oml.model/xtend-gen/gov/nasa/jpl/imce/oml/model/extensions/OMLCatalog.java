package gov.nasa.jpl.imce.oml.model.extensions;

import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.apache.xml.resolver.Catalog;

@SuppressWarnings("all")
public class OMLCatalog extends Catalog {
  protected Set<URL> parsedCatalogs = new HashSet<URL>();
  
  public boolean hasParsedCatalog(final URL aUrl) {
    return this.parsedCatalogs.contains(aUrl);
  }
  
  public void parseCatalog(final URL aUrl) throws IOException {
    boolean _add = this.parsedCatalogs.add(aUrl);
    if (_add) {
      super.parseCatalog(aUrl);
    }
  }
  
  public Set<URL> getParsedCatalogs() {
    return ImmutableSet.<URL>copyOf(this.parsedCatalogs);
  }
}
