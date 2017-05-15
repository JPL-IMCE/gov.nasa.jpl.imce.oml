package gov.nasa.jpl.imce.oml.dsl.ui.converter;

import com.google.common.base.Objects;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2DSMLPluginsWizardPage;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2NewXcoreProjectWizardPage;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreMetamodelWizard;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreMetamodelWizardPage;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
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
    final IWizardPage c = this.getCurrentPage();
    LiftOMLBundle2XcoreMetamodelWizardPage _liftOMLBundle2XcoreMetamodelWizardPage = this.liftWizard.getLiftOMLBundle2XcoreMetamodelWizardPage();
    boolean _tripleEquals = (c == _liftOMLBundle2XcoreMetamodelWizardPage);
    if (_tripleEquals) {
      this.liftWizard.updateDsmlPluginNames();
    } else {
      LiftOMLBundle2DSMLPluginsWizardPage _liftOMLBundle2DSMLPluginsWizardPage = this.liftWizard.getLiftOMLBundle2DSMLPluginsWizardPage();
      boolean _equals = Objects.equal(c, _liftOMLBundle2DSMLPluginsWizardPage);
      if (_equals) {
        String qname = this.liftWizard.getLiftOMLBundle2DSMLPluginsWizardPage().getDsmlEcorePluginName();
        LiftOMLBundle2NewXcoreProjectWizardPage _liftOMLBundle2NewXcoreProjectWizardPage = this.liftWizard.getLiftOMLBundle2NewXcoreProjectWizardPage();
        _liftOMLBundle2NewXcoreProjectWizardPage.setProjectName(qname);
      }
    }
    super.nextPressed();
  }
  
  @Override
  protected void finishPressed() {
    this.ecoreProjectHandle = this.liftWizard.getLiftOMLBundle2NewXcoreProjectWizardPage().getProjectHandle();
    this.editProjectHandle = ResourcesPlugin.getWorkspace().getRoot().getProject(this.liftWizard.getLiftOMLBundle2DSMLPluginsWizardPage().getDsmlEditPluginName());
    this.uiProjectHandle = ResourcesPlugin.getWorkspace().getRoot().getProject(this.liftWizard.getLiftOMLBundle2DSMLPluginsWizardPage().getDsmlUIPluginName());
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
