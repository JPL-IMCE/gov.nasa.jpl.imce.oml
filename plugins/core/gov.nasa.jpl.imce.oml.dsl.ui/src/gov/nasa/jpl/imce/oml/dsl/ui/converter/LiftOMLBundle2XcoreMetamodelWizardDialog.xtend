package gov.nasa.jpl.imce.oml.dsl.ui.converter

import org.eclipse.jface.wizard.WizardDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.wizard.IWizardPage
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin

class LiftOMLBundle2XcoreMetamodelWizardDialog extends WizardDialog {
	protected var LiftOMLBundle2XcoreMetamodelWizard liftWizard
	protected var IProject ecoreProjectHandle
	protected var IProject editProjectHandle
	protected var IProject uiProjectHandle
	protected var String dsmlName
	
	override close() {
		liftWizard = null
		ecoreProjectHandle = null
		editProjectHandle = null
		uiProjectHandle = null
		super.close()
	}
	
	new(Shell parentShell, LiftOMLBundle2XcoreMetamodelWizard liftWizard) {
		super(parentShell, liftWizard)
		this.liftWizard = liftWizard
	}

	override protected void nextPressed() {
		val IWizardPage c = currentPage
		if (c === liftWizard.liftOMLBundle2XcoreMetamodelWizardPage) {
			liftWizard.updateDsmlPluginNames()
		} else if (c == liftWizard.liftOMLBundle2DSMLPluginsWizardPage) {
			var qname = liftWizard.liftOMLBundle2DSMLPluginsWizardPage.dsmlEcorePluginName
			liftWizard.liftOMLBundle2NewXcoreProjectWizardPage.projectName = qname
		}
		super.nextPressed()
	}

	override protected finishPressed() {
		ecoreProjectHandle = liftWizard.liftOMLBundle2NewXcoreProjectWizardPage.projectHandle
		editProjectHandle = ResourcesPlugin.getWorkspace().getRoot().getProject(liftWizard.liftOMLBundle2DSMLPluginsWizardPage.dsmlEditPluginName)
		uiProjectHandle = ResourcesPlugin.getWorkspace().getRoot().getProject(liftWizard.liftOMLBundle2DSMLPluginsWizardPage.dsmlUIPluginName)
		dsmlName = liftWizard.liftOMLBundle2XcoreMetamodelWizardPage.DSLName
		super.finishPressed()
	}

	public def IProject ecoreProjectHandle() { ecoreProjectHandle }
	public def IProject edirProjectHandle() { editProjectHandle }
	public def IProject uiProjectHandle() { uiProjectHandle }
}
