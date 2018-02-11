/*
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
package gov.nasa.jpl.imce.oml.zip

import java.io.File
import java.io.IOException
import java.io.OutputStream
import java.util.ArrayList
import java.util.HashMap
import java.util.Map
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import gov.nasa.jpl.imce.oml.model.common.Extent
import org.eclipse.core.runtime.Assert
import java.util.regex.Pattern
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import static extension gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions.getCatalog
import gov.nasa.jpl.imce.oml.model.extensions.CatalogURIConverter

/**
 * An OMLZipResource is a kind of Resource that is loaded from and saved to an *.omlzip file
 * whose location corresponds to the mapping of the Resource URI according to the OMLCatalog
 * associated with its OMLZipResourceSet.
 */
class OMLZipResource extends ResourceImpl {

	var CatalogURIConverter uriConverter = null
	
	new(URI uri) {
		super(uri)
	}

	/**
	 * The URIConverter of an OMLZipResource is 
	 * the CatalogURIConverter associated with its OMLZipResourceSet.
	 */
	override protected def URIConverter getURIConverter() {
		val rs = getResourceSet
		switch rs {
			OMLZipResourceSet:
				uriConverter = rs.getCatalogURIConverter
			default: {
				val omlCatalog = rs.getCatalog
				if (null === omlCatalog)
					throw new IllegalArgumentException('''OMLZipResource.getURIConverter: there must be an OMLCatalog on the resource set!''')
				uriConverter = new CatalogURIConverter(omlCatalog)
			}
		}
		uriConverter
	}
	
	/**
	 * Loading an OMLZipResource involves mapping its URI to an *.omlzip file according to the CatalogURIConverter associated with its ResourceSet.
	 * If successful, the contents of the loaded OMLZipResource is a single toplevel OML Extent whose contents
	 * is the result of parsing all the tables in the *.omlzip file.
	 */
	override def void load(Map<?, ?> options) throws IOException {
		val rs = getResourceSet
		switch rs {
			OMLZipResourceSet: {
				switch uri.scheme {
					case "http": {
						val omlZipFile = rs.getCatalogURIConverter.normalize(uri)
						if (null === omlZipFile || "file" != omlZipFile.scheme || !omlZipFile.lastSegment.endsWith(".omlzip"))
							throw new IllegalArgumentException("OMLZipResource.load() requires the uri to be normalized as a file://....*.omlzip; uri="+uri+" is instead normalized as: "+omlZipFile)
						OMLSpecificationTables.load(rs, this, new File(omlZipFile.toFileString))
					}
					
					default:
						if (uri.file)
							OMLSpecificationTables.load(rs, this, new File(uri.toFileString))
						else
							throw new IllegalArgumentException('''OMLZipResource.load(): unrecognized URI scheme in: «uri» (must be either http or file): «uri.isFile»''')
				}
				
				
			}
			default: {
				val OMLCatalog c = OMLExtensions.getCatalog(rs)
				if (null === c) 
					throw new IllegalArgumentException("OMLZipResource.load(): requires an OMLCatalog on this resource set!")
					
				val File omlFile = switch uri.scheme {
					case "http": {
						val resolved = c.resolveURI(uri.toString)
						if (null === resolved || !resolved.startsWith("file:"))
							throw new IllegalArgumentException('''OMLZipResource.load(): No catalog mapping for URI: «uri»''')
						val resolvedURI = new java.net.URI(resolved + ".omlzip")
						new File(resolvedURI)
					}
					
					default:
						if (uri.file)
							new File(uri.toFileString)
						else
							throw new IllegalArgumentException('''OMLZipResource.load(): unrecognized URI scheme in: «uri» (must be either http or file): «uri.isFile»''')
				}
				
				if (!omlFile.exists)
					throw new IllegalArgumentException('''OMLZipResource.load(): URI: «uri» resolves to a non-existent file: «omlFile»''')
				OMLSpecificationTables.load(rs, this, omlFile)
			}
		}
	}
	
	/**
	 * Saving an OMLZipResource involves producing a zip archive with multiple Json lines files, one for
	 * each OML concrete metaclass and whose contents is precisely the Json serialization of each instance
	 * of that concrete metaclass in the OMLZipResource contents.
	 */
	override protected def void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		val ZipArchiveOutputStream os = new ZipArchiveOutputStream(outputStream)
		try {
			if (1 != contents.size)
				throw new IllegalArgumentException("OMLZipResource should have 1 OML Extent but it has "+contents.size+" toplevel EObjects instead.")
			val root = contents.get(0)
			switch root {
				Extent:
					OMLSpecificationTables.save(root, os)
				default:
					throw new IllegalArgumentException("OMLZipResource should have 1 OML Extent but it has "+(root?.eClass?.name ?: "null"))
			}
		} finally {
			os.close
		}
	}

   public static val Pattern KeyValue = Pattern.compile("\"([^\"]*)\":(null|\"(.*?)\"|\\{\"literalType\":\"[^\"]*\",\"value\":\\[\"(\\\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\\\"|\\n|\\r|[^\"]+?)\")*\\]\\}|\\[\"(\\\\\\\"|\\n|\\r|[^\"]+?)\"(,\"(\\\\\\\"|\\n|\\r|[^\"]+?)\")*\\]),?")
  
   protected static def ArrayList<Map<String, String>> lines2tuples(ArrayList<String> lines) {
   	val list = new ArrayList<Map<String, String>>()
   	while (!lines.empty) {
   		val line = lines.remove(lines.size - 1)
  	    val map = new HashMap<String, String>()
  	    Assert.isTrue(line.startsWith("{"))
  	    Assert.isTrue(line.endsWith("}"))
  	    val keyValues = line.substring(1, line.length-1)
  	    val m = KeyValue.matcher(keyValues)
  	    while (m.find()) {
  	    		val key = m.group(1)
  	    		val value = m.group(3) ?: m.group(2)
  	    		map.put(key, value)
  	    }
  		list.add(map)
  	}
  	return list
  }

}
