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
package gov.nasa.jpl.imce.oml.dsl;

import com.google.inject.Injector;
import gov.nasa.jpl.imce.oml.dsl.OntologicalModelingLanguageStandaloneSetupGenerated;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import org.eclipse.emf.ecore.EPackage;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class OntologicalModelingLanguageStandaloneSetup extends OntologicalModelingLanguageStandaloneSetupGenerated {
  public static void doSetup() {
    new OntologicalModelingLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
  
  public void register(final Injector injector) {
    boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(CommonPackage.eNS_URI);
    boolean _not = (!_containsKey);
    if (_not) {
      EPackage.Registry.INSTANCE.put(CommonPackage.eNS_URI, CommonPackage.eINSTANCE);
    }
    boolean _containsKey_1 = EPackage.Registry.INSTANCE.containsKey(TerminologiesPackage.eNS_URI);
    boolean _not_1 = (!_containsKey_1);
    if (_not_1) {
      EPackage.Registry.INSTANCE.put(TerminologiesPackage.eNS_URI, TerminologiesPackage.eINSTANCE);
    }
    boolean _containsKey_2 = EPackage.Registry.INSTANCE.containsKey(GraphsPackage.eNS_URI);
    boolean _not_2 = (!_containsKey_2);
    if (_not_2) {
      EPackage.Registry.INSTANCE.put(GraphsPackage.eNS_URI, GraphsPackage.eINSTANCE);
    }
    boolean _containsKey_3 = EPackage.Registry.INSTANCE.containsKey(BundlesPackage.eNS_URI);
    boolean _not_3 = (!_containsKey_3);
    if (_not_3) {
      EPackage.Registry.INSTANCE.put(BundlesPackage.eNS_URI, BundlesPackage.eINSTANCE);
    }
    boolean _containsKey_4 = EPackage.Registry.INSTANCE.containsKey(DescriptionsPackage.eNS_URI);
    boolean _not_4 = (!_containsKey_4);
    if (_not_4) {
      EPackage.Registry.INSTANCE.put(DescriptionsPackage.eNS_URI, DescriptionsPackage.eINSTANCE);
    }
    super.register(injector);
  }
}
