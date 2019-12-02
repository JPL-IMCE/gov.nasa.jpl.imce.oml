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

import gov.nasa.jpl.imce.oml.model.bundles.BundlesFactory
import gov.nasa.jpl.imce.oml.model.common.CommonFactory
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceSet
import java.net.URL

/**
 * Convenience class for writing mixed OML & OMLZip Load Tests.
 * 
 * All the OML factory methods (e.g., createTerminologyGraph, createConcept, ...)
 * can be invoked by name without explicitly referring to the appropriate factory instance.
 */
abstract class MixedOMLLoadTest {

    protected static extension CommonFactory = CommonFactory.eINSTANCE
    protected static extension TerminologiesFactory = TerminologiesFactory.eINSTANCE
    protected static extension GraphsFactory = GraphsFactory.eINSTANCE
    protected static extension BundlesFactory = BundlesFactory.eINSTANCE
    protected static extension DescriptionsFactory = DescriptionsFactory.eINSTANCE
    
	protected var URL omlCatalogFileURL
	protected var OMLZipResourceSet rs
	
	new() {
		OMLZipResourceSet.doSetup()
	}
	
	protected def initialize(URL omlCatalogFileURL) {
		this.omlCatalogFileURL = omlCatalogFileURL
		this.rs = new OMLZipResourceSet(omlCatalogFileURL)
	}
	
}