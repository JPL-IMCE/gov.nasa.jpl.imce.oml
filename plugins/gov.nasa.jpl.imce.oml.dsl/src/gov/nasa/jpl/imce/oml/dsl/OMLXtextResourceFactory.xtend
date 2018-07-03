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

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IResourceFactory
import com.google.inject.Provider
import com.google.inject.Inject

class OMLXtextResourceFactory implements IResourceFactory  {
	
	Provider<OMLXtextResource> provider
	
	@Inject
	new(Provider<OMLXtextResource> resourceProvider) {
		this.provider = resourceProvider
	}
	
	override Resource createResource(URI uri) {
		val OMLXtextResource r = provider.get()
		r.URI = uri
		r
	}
	
}