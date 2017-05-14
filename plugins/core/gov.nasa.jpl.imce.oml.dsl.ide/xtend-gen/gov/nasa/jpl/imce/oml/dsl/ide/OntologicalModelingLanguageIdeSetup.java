/**
 * Copyright 2016 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.dsl.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import gov.nasa.jpl.imce.oml.dsl.OntologicalModelingLanguageRuntimeModule;
import gov.nasa.jpl.imce.oml.dsl.OntologicalModelingLanguageStandaloneSetup;
import gov.nasa.jpl.imce.oml.dsl.ide.OntologicalModelingLanguageIdeModule;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class OntologicalModelingLanguageIdeSetup extends OntologicalModelingLanguageStandaloneSetup {
  public Injector createInjector() {
    OntologicalModelingLanguageRuntimeModule _ontologicalModelingLanguageRuntimeModule = new OntologicalModelingLanguageRuntimeModule();
    OntologicalModelingLanguageIdeModule _ontologicalModelingLanguageIdeModule = new OntologicalModelingLanguageIdeModule();
    return Guice.createInjector(Modules2.mixin(_ontologicalModelingLanguageRuntimeModule, _ontologicalModelingLanguageIdeModule));
  }
}
