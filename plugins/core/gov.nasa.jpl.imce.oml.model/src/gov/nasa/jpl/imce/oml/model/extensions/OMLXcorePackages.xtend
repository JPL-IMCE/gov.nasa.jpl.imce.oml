/**
 *
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
 package gov.nasa.jpl.imce.oml.model.extensions

import gov.nasa.jpl.imce.oml.model.common.CommonPackage
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage
import org.eclipse.emf.ecore.xml.type.XMLTypePackage
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.eclipse.xtext.XtextPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.ecore.xcore.XcorePackage

class OMLXcorePackages {
	
	public val XtextResourceSet set
	public val EPackage c
	public val EPackage t
	public val EPackage g
	public val EPackage b
	public val EPackage d
	public val EPackage oml2oti
	
	new() {
		
		val omlc = "/model/OMLCommon.xcore"
		val omlc_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model"+omlc, false)
		val omlt = "/model/OMLTerminologies.xcore"
		val omlt_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model"+omlt, false)
		val omlg = "/model/OMLGraphs.xcore"
		val omlg_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model"+omlg, false)
		val omlb = "/model/OMLBundles.xcore"
		val omlb_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model"+omlb, false)
		val omld = "/model/OMLDescriptions.xcore"
		val omld_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model"+omld, false)
		val oml2oti = "/model/OMLProvenanceOTI.xcore"
		val oml2oti_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model"+oml2oti, false)
		
		this.set = createXcoreResourceSet(
			[Map<URI,URI> uriMap | 
			uriMap.put(omlc_uri, URI.createURI(CommonPackage.getResource(omlc).toURI.toString))
			uriMap.put(omlt_uri, URI.createURI(CommonPackage.getResource(omlt).toURI.toString))
			uriMap.put(omlg_uri, URI.createURI(CommonPackage.getResource(omlg).toURI.toString))
			uriMap.put(omlb_uri, URI.createURI(CommonPackage.getResource(omlb).toURI.toString))
			uriMap.put(omld_uri, URI.createURI(CommonPackage.getResource(omld).toURI.toString))
			uriMap.put(oml2oti_uri, URI.createURI(CommonPackage.getResource(oml2oti).toURI.toString))
				])
			
		val oml2oti_r = set.getResource(oml2oti_uri, true)
		val omlc_r = set.getResource(omlc_uri, true)
		val omlt_r = set.getResource(omlt_uri, true)
		val omlg_r = set.getResource(omlg_uri, true)
		val omlb_r = set.getResource(omlb_uri, true)
		val omld_r = set.getResource(omld_uri, true)
		EcoreUtil.resolveAll(set)
      	
      	this.c = omlc_r.getContents().filter(EPackage).get(0)
     	this.t = omlt_r.getContents().filter(EPackage).get(0)
     	this.g = omlg_r.getContents().filter(EPackage).get(0)
      	this.b = omlb_r.getContents().filter(EPackage).get(0)
      	this.d = omld_r.getContents().filter(EPackage).get(0)
      	this.oml2oti = oml2oti_r.getContents().filter(EPackage).get(0)
	}
	
	static def XtextResourceSet createXcoreResourceSet(Procedure1<Map<URI,URI>> standaloneURIMapInitializer) {
		val set = new XtextResourceSet();
		set.setPackageRegistry(EPackage.Registry.INSTANCE)
		val Map<URI, URI> uriMap = set.getURIConverter().getURIMap()
		if (null === EcorePlugin.workspaceRoot) {
			XcoreStandaloneSetup.doSetup()
			uriMap.putAll(EcorePlugin.computePlatformURIMap(false))
			uriMap.put(
				URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore"),
				URI.createURI(EcorePackage.getResource("/model/Ecore.ecore").toURI.toString))
			uriMap.put(
				URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel"),
				URI.createURI(EcorePackage.getResource("/model/Ecore.genmodel").toURI.toString))
			uriMap.put(
				URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLNamespace.ecore"),
				URI.createURI(XMLNamespacePackage.getResource("/model/XMLNamespace.ecore").toURI.toString))
			uriMap.put(
				URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLNamespace.genmodel"),
				URI.createURI(XMLNamespacePackage.getResource("/model/XMLNamespace.genmodel").toURI.toString))
			uriMap.put(
				URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLType.ecore"),
				URI.createURI(XMLTypePackage.getResource("/model/XMLType.ecore").toURI.toString))
			uriMap.put(
				URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLType.genmodel"),
				URI.createURI(XMLTypePackage.getResource("/model/XMLType.genmodel").toURI.toString))
				
			val ecore = set.getResource(URI.createURI(EcorePackage.eNS_URI), true)
			if (!ecore.errors.empty) {
				throw new java.lang.IllegalArgumentException("Failed to load the Ecore package")
			}
			val genModel = set.getResource(URI.createURI(GenModelPackage.eNS_URI), true)
			if (!genModel.errors.empty) {
				throw new java.lang.IllegalArgumentException("Failed to load the GenModel package")
			}
			val xtext = set.getResource(URI.createURI(XtextPackage.eNS_URI), true)
			if (!xtext.errors.empty) {
				throw new java.lang.IllegalArgumentException("Failed to load the Xtext package")
			}
			val xcore = set.getResource(URI.createURI(XcorePackage.eNS_URI), true)
			if (!xcore.errors.empty) {
				throw new java.lang.IllegalArgumentException("Failed to load the Xcore package")
			}
			standaloneURIMapInitializer.apply(uriMap)
		} else {
			uriMap.putAll(EcorePlugin.computePlatformURIMap(true))
		}
		set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE)
		set
	}
	
}
