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

import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.common.Module
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import java.net.URL
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty

@RunWith(XtextRunner)
class OMLZipLoadTest2 extends MixedOMLLoadTest {
	
    @Test
    def void xmlSchema() {
    	val URL catalogFileURL = OMLZipLoadTest1.getResource("/OML/oml.catalog.xml")
    	initialize(catalogFileURL)
		val r1 = rs.createResource(URI.createURI("http://imce.jpl.nasa.gov/foundation/base/base.omlzip"))
		assertNotNull(r1)
		r1.load(null)
		assertTrue(1 == r1.contents.size)
		val EObject root = r1.contents.get(0)
		assertTrue(typeof(Extent).isInstance(root))
		val Extent ext = typeof(Extent).cast(root)
		assertTrue(ext.modules.size == 1)
		val Module m = ext.modules.get(0)
		assertTrue(typeof(TerminologyGraph).isInstance(m))
		val TerminologyGraph g = typeof(TerminologyGraph).cast(m)
		
		val esdp = g.boxStatements.filter(EntityScalarDataProperty)
		assertTrue(9 == esdp.size)
		
		val EntityScalarDataProperty hasDescription = esdp.findFirst[p|p.getName() == "hasDescription"]
		assertTrue(hasDescription.isIsIdentityCriteria)
		
		val EntityScalarDataProperty hasUUID = esdp.findFirst[p|p.getName() == "hasUuid"]
		assertTrue(hasUUID.isIsIdentityCriteria)
		
		val EntityScalarDataProperty hasIndexEntry = esdp.findFirst[p|p.getName() == "hasIndexEntry"]
		assertTrue(!hasIndexEntry.isIsIdentityCriteria)
		
	}
	
}