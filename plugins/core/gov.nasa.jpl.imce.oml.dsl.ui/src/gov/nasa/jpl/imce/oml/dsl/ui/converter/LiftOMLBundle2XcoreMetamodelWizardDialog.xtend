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
