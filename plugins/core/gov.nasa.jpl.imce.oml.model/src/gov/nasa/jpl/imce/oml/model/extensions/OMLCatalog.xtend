package gov.nasa.jpl.imce.oml.model.extensions

import org.apache.xml.resolver.Catalog
import java.net.URL
import java.io.IOException
import java.util.Set
import java.util.HashSet
import java.net.MalformedURLException

class OMLCatalog extends Catalog {
	
	protected Set<URL> parsedCatalogs = new HashSet<URL>()
	
	protected URL parsing = null
	
	def boolean hasParsedCatalog(URL aUrl) {
		parsedCatalogs.contains(aUrl)
	}
	
	/**
	 * Wrapper around Catalog.parseCatalog(URL) to keep track of the catalogs parsed and to report silent errors.
	 */
	synchronized override void parseCatalog(URL aUrl) throws IOException {
		if (!hasParsedCatalog(aUrl))	{
			parsing = aUrl
			super.parseCatalog(aUrl)
			if (null !== parsing)
			  throw new IOException('''Failed to parse catalog: «aUrl»''')
		}
	}
	
	override protected synchronized parsePendingCatalogs() throws MalformedURLException, IOException {
		super.parsePendingCatalogs()
		parsing = null
	}
	
	def Set<URL> getParsedCatalogs() {
		parsedCatalogs.immutableCopy
	}
}