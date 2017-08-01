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
import java.lang.reflect.Field;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class LiftOMLBundle2XcoreNewProjectWizardPage extends WizardNewProjectCreationPage {
  protected LiftOMLBundle2XcoreMetamodelWizard wizard;
  
  @Override
  public void dispose() {
    this.wizard = null;
    super.dispose();
  }
  
  public LiftOMLBundle2XcoreNewProjectWizardPage(final String initialProjectName, final LiftOMLBundle2XcoreMetamodelWizard wizard) {
    super("Lift OML Bundle to New Xcore Project");
    this.wizard = wizard;
    this.setInitialProjectName(initialProjectName);
  }
  
  @Override
  protected boolean validatePage() {
    boolean _xifexpression = false;
    boolean _validatePage = super.validatePage();
    if (_validatePage) {
      boolean _xblockexpression = false;
      {
        final IPath locationPath = this.getLocationPath();
        IPath _xifexpression_1 = null;
        boolean _equals = Platform.getLocation().equals(locationPath);
        if (_equals) {
          _xifexpression_1 = null;
        } else {
          _xifexpression_1 = locationPath;
        }
        this.wizard.setGenModelProjectLocation(_xifexpression_1);
        final IPath projectPath = this.getProjectHandle().getFullPath();
        this.wizard.setGenModelContainerPath(projectPath.append("src"));
        _xblockexpression = true;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  @Override
  public void createControl(final Composite parent) {
    super.createControl(parent);
    Control _control = this.getControl();
    this.createWorkingSetGroup(((Composite) _control), this.wizard.sselection, 
      new String[] { "org.eclipse.jdt.ui.JavaWorkingSetPage", "org.eclipse.pde.ui.pluginWorkingSet", "org.eclipse.ui.resourceWorkingSetPage" });
  }
  
  public void setProjectName(final String name) {
    try {
      try {
        final Field field = WizardNewProjectCreationPage.class.getDeclaredField("projectNameField");
        field.setAccessible(true);
        Object _get = field.get(this);
        final Text textField = ((Text) _get);
        textField.setText(name);
        textField.setEnabled(false);
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchFieldException) {
          final NoSuchFieldException e = (NoSuchFieldException)_t;
          String _message = e.getMessage();
          String _plus = ("setProjectName: " + _message);
          throw new IllegalArgumentException(_plus, e);
        } else if (_t instanceof SecurityException) {
          final SecurityException e_1 = (SecurityException)_t;
          String _message_1 = e_1.getMessage();
          String _plus_1 = ("setProjectName: " + _message_1);
          throw new IllegalArgumentException(_plus_1, e_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
