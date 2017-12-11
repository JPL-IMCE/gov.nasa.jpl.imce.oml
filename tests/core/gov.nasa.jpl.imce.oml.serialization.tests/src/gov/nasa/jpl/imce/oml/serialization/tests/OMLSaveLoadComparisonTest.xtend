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
package gov.nasa.jpl.imce.oml.serialization.tests

import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceSet
import java.nio.file.Path
import java.nio.file.Paths
import org.eclipse.emf.common.util.URI
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.common.CommonFactory
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.bundles.BundlesFactory
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory
import org.eclipse.xtext.util.Files

/**
 * Convenience class for writing OMLZip Save/Load Comparison Tests.
 * 
 * All the OML factory methods (e.g., createTerminologyGraph, createConcept, ...)
 * can be invoked by name without explicitly referring to the appropriate factory instance.
 */
abstract class OMLSaveLoadComparisonTest {

    protected static extension CommonFactory = CommonFactory.eINSTANCE
    protected static extension TerminologiesFactory = TerminologiesFactory.eINSTANCE
    protected static extension GraphsFactory = GraphsFactory.eINSTANCE
    protected static extension BundlesFactory = BundlesFactory.eINSTANCE
    protected static extension DescriptionsFactory = DescriptionsFactory.eINSTANCE
    
    protected static def File deleteAndCreateOMLFolder(Path path) {
    		val d = path.toFile
    		Files.sweepFolder(d)
    		d.mkdirs
    		
    		val c = path.resolve("oml.catalog.xml").toFile
    		val pw = new PrintWriter(new FileOutputStream(c))
    		pw.println("<?xml version='1.0'?>")
    		pw.println('<catalog xmlns="urn:oasis:names:tc:entity:xmlns:xml:catalog" prefer="public">')
    		pw.println('	<rewriteURI rewritePrefix="file:./" uriStartString="http://"/>')
    		pw.println('</catalog>')
    		pw.close
    		
    		c
    }
    
	protected var File omlCatalogFile
	protected var OMLZipResourceSet rs1
	protected var OMLZipResourceSet rs2
	
	new() {
		OMLZipResourceSet.doSetup()
		omlCatalogFile = deleteAndCreateOMLFolder(Paths.get("./target/oml"))
		rs1 = new OMLZipResourceSet(omlCatalogFile.toURI.toURL)
		rs2 = new OMLZipResourceSet(omlCatalogFile.toURI.toURL)
	}
	
	/**
	 * Execute a Save/Load Compare Unit Test.
	 * For each <URI, Extent> pair: <uri, ext>, the following 3 steps are performed:
	 * - use rs1 to create an OMLZipResource, r1, at uri with contents ext and save this resource
	 * - use rs2 to load an OMLZipResource, r2, from uri
	 * - check that there are no structural differences in the contents of r1 (as created) and of r2 (as loaded).
	 */
	protected def void compareSavedAndLoaded(Pair<URI, Extent> ... pairs) {
		pairs.forEach[pair| 
			val uri = pair.key
			val ext1 = pair.value
		
			// Save ...
			val r1 = rs1.createResource(uri)
			r1.contents.add(ext1)
			r1.save(null)
		
			// Load...
			val r2 = rs2.getResource(uri, true)
		
			// Check...
			OMLResourceCompare.resourceCompare(r1, r2)
		]
	}
}