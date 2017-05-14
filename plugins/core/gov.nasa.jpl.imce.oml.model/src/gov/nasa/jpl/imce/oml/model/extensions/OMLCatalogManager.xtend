package gov.nasa.jpl.imce.oml.model.extensions

import org.apache.xml.resolver.CatalogManager

class OMLCatalogManager extends CatalogManager {

	override getPrivateCatalog() {
		val catalog = new OMLCatalog()
		catalog.setCatalogManager(this)
		catalog.setupReaders()
		catalog.loadSystemCatalogs()
		return catalog
	}

}
