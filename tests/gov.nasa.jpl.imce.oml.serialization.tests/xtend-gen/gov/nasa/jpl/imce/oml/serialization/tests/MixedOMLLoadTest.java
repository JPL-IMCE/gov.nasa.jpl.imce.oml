/**
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
package gov.nasa.jpl.imce.oml.serialization.tests;

import gov.nasa.jpl.imce.oml.model.bundles.BundlesFactory;
import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceSet;
import java.net.URL;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Convenience class for writing mixed OML & OMLZip Load Tests.
 * 
 * All the OML factory methods (e.g., createTerminologyGraph, createConcept, ...)
 * can be invoked by name without explicitly referring to the appropriate factory instance.
 */
@SuppressWarnings("all")
public abstract class MixedOMLLoadTest {
  @Extension
  protected static CommonFactory _commonFactory = CommonFactory.eINSTANCE;
  
  @Extension
  protected static TerminologiesFactory _terminologiesFactory = TerminologiesFactory.eINSTANCE;
  
  @Extension
  protected static GraphsFactory _graphsFactory = GraphsFactory.eINSTANCE;
  
  @Extension
  protected static BundlesFactory _bundlesFactory = BundlesFactory.eINSTANCE;
  
  @Extension
  protected static DescriptionsFactory _descriptionsFactory = DescriptionsFactory.eINSTANCE;
  
  protected URL omlCatalogFileURL;
  
  protected OMLZipResourceSet rs;
  
  public MixedOMLLoadTest() {
    OMLZipResourceSet.doSetup();
  }
  
  protected OMLZipResourceSet initialize(final URL omlCatalogFileURL) {
    OMLZipResourceSet _xblockexpression = null;
    {
      this.omlCatalogFileURL = omlCatalogFileURL;
      OMLZipResourceSet _oMLZipResourceSet = new OMLZipResourceSet(omlCatalogFileURL);
      _xblockexpression = this.rs = _oMLZipResourceSet;
    }
    return _xblockexpression;
  }
}
