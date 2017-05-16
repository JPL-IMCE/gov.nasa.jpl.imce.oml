package gov.nasa.jpl.imce.oml.model.extensions;

import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogManager;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class OMLCatalogManager extends CatalogManager {
  @Override
  public Catalog getPrivateCatalog() {
    try {
      final OMLCatalog catalog = new OMLCatalog();
      catalog.setCatalogManager(this);
      catalog.setupReaders();
      catalog.loadSystemCatalogs();
      return catalog;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
