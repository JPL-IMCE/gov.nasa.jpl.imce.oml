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

import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreMetamodelWizard;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreMetamodelWizardPage;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

@SuppressWarnings("all")
public class LiftOMLBundle2XcoreMetamodelWizardDialog extends WizardDialog {
  protected LiftOMLBundle2XcoreMetamodelWizard liftWizard;
  
  protected IProject ecoreProjectHandle;
  
  protected IProject editProjectHandle;
  
  protected IProject uiProjectHandle;
  
  protected String dsmlName;
  
  @Override
  public boolean close() {
    boolean _xblockexpression = false;
    {
      this.liftWizard = null;
      this.ecoreProjectHandle = null;
      this.editProjectHandle = null;
      this.uiProjectHandle = null;
      _xblockexpression = super.close();
    }
    return _xblockexpression;
  }
  
  public LiftOMLBundle2XcoreMetamodelWizardDialog(final Shell parentShell, final LiftOMLBundle2XcoreMetamodelWizard liftWizard) {
    super(parentShell, liftWizard);
    this.liftWizard = liftWizard;
  }
  
  @Override
  protected void nextPressed() {
    IWizardPage _currentPage = this.getCurrentPage();
    LiftOMLBundle2XcoreMetamodelWizardPage _liftOMLBundle2XcoreMetamodelWizardPage = this.liftWizard.getLiftOMLBundle2XcoreMetamodelWizardPage();
    boolean _tripleEquals = (_currentPage == _liftOMLBundle2XcoreMetamodelWizardPage);
    if (_tripleEquals) {
      this.liftWizard.updateDsmlPluginNames();
    }
    super.nextPressed();
  }
  
  @Override
  protected void finishPressed() {
    IWizardPage _currentPage = this.getCurrentPage();
    LiftOMLBundle2XcoreMetamodelWizardPage _liftOMLBundle2XcoreMetamodelWizardPage = this.liftWizard.getLiftOMLBundle2XcoreMetamodelWizardPage();
    boolean _tripleEquals = (_currentPage == _liftOMLBundle2XcoreMetamodelWizardPage);
    if (_tripleEquals) {
      this.liftWizard.updateDsmlPluginNames();
    }
    this.ecoreProjectHandle = this.liftWizard.getLiftOMLBundle2XcoreNewProjectWizardPage().getProjectHandle();
    this.editProjectHandle = this.liftWizard.getLiftOMLBundle2XcoreNewProjectWizardPage1().getProjectHandle();
    this.dsmlName = this.liftWizard.getLiftOMLBundle2XcoreMetamodelWizardPage().getDSLName();
    super.finishPressed();
  }
  
  public IProject ecoreProjectHandle() {
    return this.ecoreProjectHandle;
  }
  
  public IProject edirProjectHandle() {
    return this.editProjectHandle;
  }
  
  public IProject uiProjectHandle() {
    return this.uiProjectHandle;
  }
}
