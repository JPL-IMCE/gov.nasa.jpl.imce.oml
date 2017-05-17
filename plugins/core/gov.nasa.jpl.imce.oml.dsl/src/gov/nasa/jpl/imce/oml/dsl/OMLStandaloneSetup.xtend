/*
 * Copyright 2017 California Institute of Technology ("Caltech").
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
package gov.nasa.jpl.imce.oml.dsl

import com.google.inject.Injector
import org.eclipse.emf.ecore.EPackage
import gov.nasa.jpl.imce.oml.model.common.CommonPackage
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
import gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class OMLStandaloneSetup extends OMLStandaloneSetupGenerated {

	def static void doSetup() {
		new OMLStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	override def register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey(CommonPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(CommonPackage.eNS_URI, CommonPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey(TerminologiesPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(TerminologiesPackage.eNS_URI, TerminologiesPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey(GraphsPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(GraphsPackage.eNS_URI, GraphsPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey(BundlesPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(BundlesPackage.eNS_URI, BundlesPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey(DescriptionsPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(DescriptionsPackage.eNS_URI, DescriptionsPackage.eINSTANCE);
		}
		super.register(injector)
	}
}
