///*
// * Copyright 2016 California Institute of Technology ("Caltech").
// * U.S. Government sponsorship acknowledged.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// * License Terms
// */
//package gov.nasa.jpl.imce.oml.serialization.tests
//
//import java.net.URL
//import org.eclipse.emf.ecore.EObject
//import org.eclipse.emf.common.util.URI
//import org.eclipse.xtext.testing.XtextRunner
//import org.junit.Test
//import org.junit.runner.RunWith
//import gov.nasa.jpl.imce.oml.model.common.Extent
//
//import static org.junit.Assert.assertNotNull
//import static org.junit.Assert.assertNull
//import static org.junit.Assert.assertTrue
//import gov.nasa.jpl.imce.oml.model.common.Module
//import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
//import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
//import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal
//import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
//
//@RunWith(XtextRunner)
//class OMLZipLoadTest2 extends MixedOMLLoadTest {
//	
//    @Test
//    def void xmlSchema() {
//    	val URL catalogFileURL = OMLZipLoadTest1.getResource("/demo/oml.catalog.xml")
//    	initialize(catalogFileURL)
//		val r1 = rs.createResource(URI.createURI("http://europa.jpl.nasa.gov/efse/functionlist/FunctionList/Baseline.omlzip"))
//		assertNotNull(r1)
//		r1.load(null)
//		assertTrue(1 == r1.contents.size)
//		val EObject root = r1.contents.get(0)
//		assertTrue(typeof(Extent).isInstance(root))
//		val Extent ext = typeof(Extent).cast(root)
//		assertTrue(ext.modules.size == 1)
//		val Module m = ext.modules.get(0)
//		assertTrue(typeof(DescriptionBox).isInstance(m))
//		
//	}
//	
//}