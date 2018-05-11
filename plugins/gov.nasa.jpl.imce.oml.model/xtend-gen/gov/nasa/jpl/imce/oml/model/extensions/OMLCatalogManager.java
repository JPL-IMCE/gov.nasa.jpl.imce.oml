package gov.nasa.jpl.imce.oml.model.extensions;

import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogManager;

@SuppressWarnings("all")
public class OMLCatalogManager extends CatalogManager {
  @Override
  public Catalog getPrivateCatalog() {
    final OMLCatalog catalog = new OMLCatalog();
    catalog.setCatalogManager(this);
    catalog.setupReaders();
    return catalog;
  }
}
