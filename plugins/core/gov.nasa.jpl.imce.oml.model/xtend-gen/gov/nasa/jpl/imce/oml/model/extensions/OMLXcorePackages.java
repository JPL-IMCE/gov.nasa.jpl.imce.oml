/**
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
 */
package gov.nasa.jpl.imce.oml.model.extensions;

import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import java.util.Map;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xcore.XcorePackage;
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class OMLXcorePackages {
  public final XtextResourceSet set;
  
  public final EPackage c;
  
  public final EPackage t;
  
  public final EPackage g;
  
  public final EPackage b;
  
  public final EPackage d;
  
  public final EPackage oml2oti;
  
  public OMLXcorePackages() {
    final String omlc = "/model/OMLCommon.xcore";
    final URI omlc_uri = URI.createPlatformResourceURI(("/gov.nasa.jpl.imce.oml.model" + omlc), false);
    final String omlt = "/model/OMLTerminologies.xcore";
    final URI omlt_uri = URI.createPlatformResourceURI(("/gov.nasa.jpl.imce.oml.model" + omlt), false);
    final String omlg = "/model/OMLGraphs.xcore";
    final URI omlg_uri = URI.createPlatformResourceURI(("/gov.nasa.jpl.imce.oml.model" + omlg), false);
    final String omlb = "/model/OMLBundles.xcore";
    final URI omlb_uri = URI.createPlatformResourceURI(("/gov.nasa.jpl.imce.oml.model" + omlb), false);
    final String omld = "/model/OMLDescriptions.xcore";
    final URI omld_uri = URI.createPlatformResourceURI(("/gov.nasa.jpl.imce.oml.model" + omld), false);
    final String oml2oti = "/model/OMLProvenanceOTI.xcore";
    final URI oml2oti_uri = URI.createPlatformResourceURI(("/gov.nasa.jpl.imce.oml.model" + oml2oti), false);
    final Procedure1<Map<URI, URI>> _function = (Map<URI, URI> uriMap) -> {
      try {
        uriMap.put(omlc_uri, URI.createURI(CommonPackage.class.getResource(omlc).toURI().toString()));
        uriMap.put(omlt_uri, URI.createURI(CommonPackage.class.getResource(omlt).toURI().toString()));
        uriMap.put(omlg_uri, URI.createURI(CommonPackage.class.getResource(omlg).toURI().toString()));
        uriMap.put(omlb_uri, URI.createURI(CommonPackage.class.getResource(omlb).toURI().toString()));
        uriMap.put(omld_uri, URI.createURI(CommonPackage.class.getResource(omld).toURI().toString()));
        uriMap.put(oml2oti_uri, URI.createURI(CommonPackage.class.getResource(oml2oti).toURI().toString()));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this.set = OMLXcorePackages.createXcoreResourceSet(_function);
    final Resource oml2oti_r = this.set.getResource(oml2oti_uri, true);
    final Resource omlc_r = this.set.getResource(omlc_uri, true);
    final Resource omlt_r = this.set.getResource(omlt_uri, true);
    final Resource omlg_r = this.set.getResource(omlg_uri, true);
    final Resource omlb_r = this.set.getResource(omlb_uri, true);
    final Resource omld_r = this.set.getResource(omld_uri, true);
    EcoreUtil.resolveAll(this.set);
    this.c = ((EPackage[])Conversions.unwrapArray(Iterables.<EPackage>filter(omlc_r.getContents(), EPackage.class), EPackage.class))[0];
    this.t = ((EPackage[])Conversions.unwrapArray(Iterables.<EPackage>filter(omlt_r.getContents(), EPackage.class), EPackage.class))[0];
    this.g = ((EPackage[])Conversions.unwrapArray(Iterables.<EPackage>filter(omlg_r.getContents(), EPackage.class), EPackage.class))[0];
    this.b = ((EPackage[])Conversions.unwrapArray(Iterables.<EPackage>filter(omlb_r.getContents(), EPackage.class), EPackage.class))[0];
    this.d = ((EPackage[])Conversions.unwrapArray(Iterables.<EPackage>filter(omld_r.getContents(), EPackage.class), EPackage.class))[0];
    this.oml2oti = ((EPackage[])Conversions.unwrapArray(Iterables.<EPackage>filter(oml2oti_r.getContents(), EPackage.class), EPackage.class))[0];
  }
  
  public static XtextResourceSet createXcoreResourceSet(final Procedure1<Map<URI, URI>> standaloneURIMapInitializer) {
    try {
      XtextResourceSet _xblockexpression = null;
      {
        final XtextResourceSet set = new XtextResourceSet();
        set.setPackageRegistry(EPackage.Registry.INSTANCE);
        final Map<URI, URI> uriMap = set.getURIConverter().getURIMap();
        IWorkspaceRoot _workspaceRoot = EcorePlugin.getWorkspaceRoot();
        boolean _tripleEquals = (null == _workspaceRoot);
        if (_tripleEquals) {
          XcoreStandaloneSetup.doSetup();
          uriMap.putAll(EcorePlugin.computePlatformURIMap(false));
          uriMap.put(
            URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore"), 
            URI.createURI(EcorePackage.class.getResource("/model/Ecore.ecore").toURI().toString()));
          uriMap.put(
            URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel"), 
            URI.createURI(EcorePackage.class.getResource("/model/Ecore.genmodel").toURI().toString()));
          uriMap.put(
            URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLNamespace.ecore"), 
            URI.createURI(XMLNamespacePackage.class.getResource("/model/XMLNamespace.ecore").toURI().toString()));
          uriMap.put(
            URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLNamespace.genmodel"), 
            URI.createURI(XMLNamespacePackage.class.getResource("/model/XMLNamespace.genmodel").toURI().toString()));
          uriMap.put(
            URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLType.ecore"), 
            URI.createURI(XMLTypePackage.class.getResource("/model/XMLType.ecore").toURI().toString()));
          uriMap.put(
            URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLType.genmodel"), 
            URI.createURI(XMLTypePackage.class.getResource("/model/XMLType.genmodel").toURI().toString()));
          final Resource ecore = set.getResource(URI.createURI(EcorePackage.eNS_URI), true);
          boolean _isEmpty = ecore.getErrors().isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            throw new IllegalArgumentException("Failed to load the Ecore package");
          }
          final Resource genModel = set.getResource(URI.createURI(GenModelPackage.eNS_URI), true);
          boolean _isEmpty_1 = genModel.getErrors().isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            throw new IllegalArgumentException("Failed to load the GenModel package");
          }
          final Resource xtext = set.getResource(URI.createURI(XtextPackage.eNS_URI), true);
          boolean _isEmpty_2 = xtext.getErrors().isEmpty();
          boolean _not_2 = (!_isEmpty_2);
          if (_not_2) {
            throw new IllegalArgumentException("Failed to load the Xtext package");
          }
          final Resource xcore = set.getResource(URI.createURI(XcorePackage.eNS_URI), true);
          boolean _isEmpty_3 = xcore.getErrors().isEmpty();
          boolean _not_3 = (!_isEmpty_3);
          if (_not_3) {
            throw new IllegalArgumentException("Failed to load the Xcore package");
          }
          standaloneURIMapInitializer.apply(uriMap);
        } else {
          uriMap.putAll(EcorePlugin.computePlatformURIMap(true));
        }
        set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        _xblockexpression = set;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
