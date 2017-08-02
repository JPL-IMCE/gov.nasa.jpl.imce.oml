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

import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Platform
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage

class LiftOMLBundle2XcoreNewProjectWizardPage extends WizardNewProjectCreationPage {

	protected var LiftOMLBundle2XcoreMetamodelWizard wizard

	override dispose() {
		wizard = null
		super.dispose()
	}
	
	new(String initialProjectName, LiftOMLBundle2XcoreMetamodelWizard wizard) {
		super("Lift OML Bundle to New Xcore Project")
		this.wizard = wizard
		this.initialProjectName = initialProjectName
	}

	override protected validatePage() {
		if (super.validatePage()) {
			val IPath locationPath = getLocationPath()
			wizard.genModelProjectLocation = if(Platform.getLocation().equals(locationPath)) null else locationPath
			val IPath projectPath = getProjectHandle().getFullPath()
			wizard.genModelContainerPath = projectPath.append("src")
			true
		} else {
			false
		}
	}

	override createControl(Composite parent) {
		super.createControl(parent)
		createWorkingSetGroup(getControl() as Composite, wizard.sselection,
			#["org.eclipse.jdt.ui.JavaWorkingSetPage", "org.eclipse.pde.ui.pluginWorkingSet",
				"org.eclipse.ui.resourceWorkingSetPage"])
	}

	public def void setProjectName(String name) {
		try {
			val field = WizardNewProjectCreationPage.getDeclaredField("projectNameField")
			field.accessible = true
			val Text textField = field.get(this) as Text
			textField.text = name
			textField.enabled = false
		} catch (NoSuchFieldException e) {
			throw new IllegalArgumentException("setProjectName: " + e.getMessage, e)
		} catch (SecurityException e) {
			throw new IllegalArgumentException("setProjectName: " + e.getMessage, e)
		} 
	}

}
