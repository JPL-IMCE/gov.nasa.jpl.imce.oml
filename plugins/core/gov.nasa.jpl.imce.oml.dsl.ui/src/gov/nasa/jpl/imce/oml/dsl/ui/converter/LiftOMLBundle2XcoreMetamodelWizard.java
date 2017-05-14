package gov.nasa.jpl.imce.oml.dsl.ui.converter;

import org.eclipse.jface.wizard.Wizard;

public class LiftOMLBundle2XcoreMetamodelWizard extends Wizard {

	protected LiftOMLBundle2XcoreMetamodelWizardPage page;
	
	public LiftOMLBundle2XcoreMetamodelWizard() {
		setWindowTitle("New Lift OML Bundle 2 Xcore Metamodel Wizard");
	}

	@Override
	public void addPages() {
		page = new LiftOMLBundle2XcoreMetamodelWizardPage();
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
