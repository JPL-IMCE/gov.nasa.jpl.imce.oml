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
import java.util.List
import java.util.Map
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import gov.nasa.jpl.imce.oml.model.common.Extent
import org.eclipse.core.runtime.Assert
import java.util.regex.Pattern

/**
 * An OMLZipResource is a kind of Resource that is loaded from and saved to an *.omlzip file
 * whose location corresponds to the mapping of the Resource URI according to the OMLCatalog
 * associated with its OMLZipResourceSet.
 */
class OMLZipResource extends ResourceImpl {

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
				rs.getCatalogURIConverter
			default:
				super.getURIConverter()
		}
		
	}
	
	/**
	 * Loading an OMLZipResource involves mapping its URI to an *.omlzip file according to the CatalogURIConverter associated with its OMLZipResourceSet.
	 * If successful, the contents of the loaded OMLZipResource is a single toplevel OML Extent whose contents
	 * is the result of parsing all the tables in the *.omlzip file.
	 */
	override def void load(Map<?, ?> options) throws IOException {
		val rs = getResourceSet
		switch rs {
			OMLZipResourceSet: {
				val omlZipFile = rs.getCatalogURIConverter.normalize(uri)
				if (null === omlZipFile || "file" != omlZipFile.scheme || !omlZipFile.lastSegment.endsWith(".omlzip"))
					throw new IllegalArgumentException("OMLZipResource.load() requires the uri to be normalized as a file://....*.omlzip; uri="+uri+" is instead normalized as: "+omlZipFile)
				OMLSpecificationTables.load(rs, this, new File(omlZipFile.toFileString))
			}
			default:
				throw new IllegalArgumentException("OMLZipResource must be loaded within an OMLZipResourceSet, not a "+rs?.class?.name)
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

   protected static val Pattern KeyValue = Pattern.compile("\"([^\"]*)\":(null|\"(.*?)\"|\\{\"literalType\":\"[^\"]*\",\"value\":\".*?\"\\}),?")
   
   protected static def List<Map<String, String>> lines2tuples(ArrayList<String> lines) {
   	val list = new ArrayList<Map<String, String>>()
  	lines.forEach[ line | 
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
  	]
  	return list
  }
}
