package gov.nasa.jpl.imce.oml.model.extensions

import org.apache.xml.resolver.Catalog
import java.net.URL
import java.io.IOException
import java.util.Set
import java.util.HashSet

class OMLCatalog extends Catalog {
	
	protected Set<URL> parsedCatalogs = new HashSet<URL>()
	
	def boolean hasParsedCatalog(URL aUrl) {
		parsedCatalogs.contains(aUrl)
	}
	
	override void parseCatalog(URL aUrl) throws IOException {
		if (parsedCatalogs.add(aUrl))	
			super.parseCatalog(aUrl)
	}
	
	def Set<URL> getParsedCatalogs() {
		parsedCatalogs.immutableCopy
	}
}