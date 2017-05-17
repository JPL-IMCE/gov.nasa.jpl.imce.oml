/**
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
package gov.nasa.jpl.imce.oml.dsl.ui.converter;

import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2DSMLPluginsWizardPage;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2NewXcoreProjectWizardPage;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreMetamodelWizardPage;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.xcore.ui.EmptyXcoreProjectWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class LiftOMLBundle2XcoreMetamodelWizard extends EmptyXcoreProjectWizard {
  protected IStructuredSelection sselection;
  
  protected LiftOMLBundle2XcoreMetamodelWizardPage page1;
  
  protected LiftOMLBundle2DSMLPluginsWizardPage page2;
  
  protected Bundle omlBundle;
  
  public LiftOMLBundle2XcoreMetamodelWizard(final IWorkbench wb, final IStructuredSelection sselection, final Bundle omlBundle) {
    this.sselection = sselection;
    this.omlBundle = omlBundle;
    this.init(wb, sselection);
    this.setWindowTitle("New Lift OML Bundle 2 Xcore Metamodel Wizard");
  }
  
  @Override
  public void addPages() {
    final String iri = this.omlBundle.iri();
    final int index1 = iri.indexOf("://");
    final String pname = iri.substring((index1 + 3));
    final int index2 = pname.indexOf("/");
    String _xifexpression = null;
    if ((index2 > 0)) {
      _xifexpression = pname.substring(0, index2);
    } else {
      _xifexpression = pname;
    }
    final String domain = _xifexpression;
    final String qprefix = IterableExtensions.join(ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(domain.split("\\.")))), ".");
    String _xifexpression_1 = null;
    if ((index2 > 0)) {
      _xifexpression_1 = pname.substring(index2);
    } else {
      _xifexpression_1 = "";
    }
    final String qsuffix = _xifexpression_1;
    final String qname = (qprefix + qsuffix).replaceAll("[/-]", ".");
    LiftOMLBundle2XcoreMetamodelWizardPage _liftOMLBundle2XcoreMetamodelWizardPage = new LiftOMLBundle2XcoreMetamodelWizardPage(qname, this.omlBundle);
    this.page1 = _liftOMLBundle2XcoreMetamodelWizardPage;
    this.addPage(this.page1);
    LiftOMLBundle2DSMLPluginsWizardPage _liftOMLBundle2DSMLPluginsWizardPage = new LiftOMLBundle2DSMLPluginsWizardPage();
    this.page2 = _liftOMLBundle2DSMLPluginsWizardPage;
    this.addPage(this.page2);
    LiftOMLBundle2NewXcoreProjectWizardPage _liftOMLBundle2NewXcoreProjectWizardPage = new LiftOMLBundle2NewXcoreProjectWizardPage(qname, this);
    this.newProjectCreationPage = _liftOMLBundle2NewXcoreProjectWizardPage;
    this.addPage(this.newProjectCreationPage);
  }
  
  public void setGenModelProjectLocation(final IPath location) {
    this.genModelProjectLocation = location;
  }
  
  public void setGenModelContainerPath(final IPath path) {
    this.genModelContainerPath = path;
  }
  
  public void updateDsmlPluginNames() {
    String qname = this.page1.getDSLQualifiedName();
    boolean _endsWith = qname.endsWith(".ecore");
    if (_endsWith) {
      int _length = qname.length();
      int _minus = (_length - 6);
      qname = qname.substring(0, _minus);
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(qname);
    _builder.append(".ecore");
    this.page2.setDsmlEcorePluginName(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(qname);
    _builder_1.append(".edit");
    this.page2.setDsmlEditPluginName(_builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(qname);
    _builder_2.append(".ui");
    this.page2.setDsmlUIPluginName(_builder_2.toString());
    this.page2.setPageComplete(true);
  }
  
  @Override
  public void modifyWorkspace(final IProgressMonitor progressMonitor) throws CoreException, UnsupportedEncodingException, IOException {
    super.modifyWorkspace(progressMonitor);
  }
  
  @Override
  public boolean performFinish() {
    return super.performFinish();
  }
  
  public LiftOMLBundle2XcoreMetamodelWizardPage getLiftOMLBundle2XcoreMetamodelWizardPage() {
    return this.page1;
  }
  
  public LiftOMLBundle2DSMLPluginsWizardPage getLiftOMLBundle2DSMLPluginsWizardPage() {
    return this.page2;
  }
  
  public LiftOMLBundle2NewXcoreProjectWizardPage getLiftOMLBundle2NewXcoreProjectWizardPage() {
    return ((LiftOMLBundle2NewXcoreProjectWizardPage) this.newProjectCreationPage);
  }
  
  @Override
  protected String[] getRequiredBundles() {
    return new String[] { "org.eclipse.core.runtime", "org.eclipse.emf.ecore", "org.eclipse.emf.codegen.ecore", "org.eclipse.emf.cdo", "org.eclipse.xtext.xbase.lib", "org.eclipse.emf.ecore.xcore", "org.eclipse.emf.ecore.xcore.lib", "gov.nasa.jpl.imce.oml.runtime" };
  }
}
