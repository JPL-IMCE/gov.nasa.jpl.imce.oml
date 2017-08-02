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

import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreMetamodelWizardPage;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreNewProjectWizardPage;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.xcore.ui.EmptyXcoreProjectWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LiftOMLBundle2XcoreMetamodelWizard extends EmptyXcoreProjectWizard {
  protected IStructuredSelection sselection;
  
  protected LiftOMLBundle2XcoreMetamodelWizardPage page1;
  
  protected WizardNewProjectCreationPage newProjectCreationPage1;
  
  protected WizardNewProjectCreationPage newProjectCreationPage2;
  
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
    final String qname = OMLExtensions.convertIRItoNamespace(iri);
    LiftOMLBundle2XcoreMetamodelWizardPage _liftOMLBundle2XcoreMetamodelWizardPage = new LiftOMLBundle2XcoreMetamodelWizardPage(qname, this.omlBundle);
    this.page1 = _liftOMLBundle2XcoreMetamodelWizardPage;
    this.addPage(this.page1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(qname, "");
    _builder.append(".edit");
    LiftOMLBundle2XcoreNewProjectWizardPage _liftOMLBundle2XcoreNewProjectWizardPage = new LiftOMLBundle2XcoreNewProjectWizardPage(_builder.toString(), this);
    this.newProjectCreationPage1 = _liftOMLBundle2XcoreNewProjectWizardPage;
    this.addPage(this.newProjectCreationPage1);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(qname, "");
    _builder_1.append(".ecore");
    LiftOMLBundle2XcoreNewProjectWizardPage _liftOMLBundle2XcoreNewProjectWizardPage_1 = new LiftOMLBundle2XcoreNewProjectWizardPage(_builder_1.toString(), this);
    this.newProjectCreationPage = _liftOMLBundle2XcoreNewProjectWizardPage_1;
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
      String _substring = qname.substring(0, _minus);
      qname = _substring;
    }
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
  
  public LiftOMLBundle2XcoreNewProjectWizardPage getLiftOMLBundle2XcoreNewProjectWizardPage1() {
    return ((LiftOMLBundle2XcoreNewProjectWizardPage) this.newProjectCreationPage1);
  }
  
  public LiftOMLBundle2XcoreNewProjectWizardPage getLiftOMLBundle2XcoreNewProjectWizardPage2() {
    return ((LiftOMLBundle2XcoreNewProjectWizardPage) this.newProjectCreationPage2);
  }
  
  public LiftOMLBundle2XcoreNewProjectWizardPage getLiftOMLBundle2XcoreNewProjectWizardPage() {
    return ((LiftOMLBundle2XcoreNewProjectWizardPage) this.newProjectCreationPage);
  }
  
  @Override
  protected String[] getRequiredBundles() {
    return new String[] { "org.eclipse.core.runtime", "org.eclipse.emf.ecore", "org.eclipse.emf.codegen.ecore", "org.eclipse.emf.cdo", "org.eclipse.xtext.xbase.lib", "org.eclipse.emf.ecore.xcore", "org.eclipse.emf.ecore.xcore.lib", "gov.nasa.jpl.imce.oml.runtime" };
  }
}
