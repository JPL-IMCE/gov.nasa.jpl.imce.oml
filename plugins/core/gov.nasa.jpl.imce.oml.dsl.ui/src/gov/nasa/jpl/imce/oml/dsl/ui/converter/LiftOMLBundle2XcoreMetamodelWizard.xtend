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

import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import org.eclipse.emf.ecore.xcore.ui.EmptyXcoreProjectWizard
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.core.runtime.IPath
import org.eclipse.ui.IWorkbench
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.CoreException
import java.io.UnsupportedEncodingException
import java.io.IOException
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage

class LiftOMLBundle2XcoreMetamodelWizard extends EmptyXcoreProjectWizard {
	protected IStructuredSelection sselection
	protected LiftOMLBundle2XcoreMetamodelWizardPage page1
	protected WizardNewProjectCreationPage newProjectCreationPage1;
	protected WizardNewProjectCreationPage newProjectCreationPage2;
	protected Bundle omlBundle

	new(IWorkbench wb, IStructuredSelection sselection, Bundle omlBundle) {
		this.sselection = sselection
		this.omlBundle = omlBundle
		
		init(wb, sselection)
		
		setWindowTitle("New Lift OML Bundle 2 Xcore Metamodel Wizard")
	}

	override void addPages() {
		val iri = omlBundle.iri()
		val qname = OMLExtensions.convertIRItoNamespace(iri)
				
		page1 = new LiftOMLBundle2XcoreMetamodelWizardPage(qname, omlBundle)
		addPage(page1)
		newProjectCreationPage1 = new LiftOMLBundle2XcoreNewProjectWizardPage('''«qname».edit''', this)
		addPage(newProjectCreationPage1)
		//newProjectCreationPage2 = new LiftOMLBundle2NewXcoreProjectWizardPage('''«qname».ui''', this)
		//addPage(newProjectCreationPage2)
		newProjectCreationPage = new LiftOMLBundle2XcoreNewProjectWizardPage('''«qname».ecore''', this)
		addPage(newProjectCreationPage)
		
	}

	def void setGenModelProjectLocation(IPath location) {
		this.genModelProjectLocation = location	
	}
	
	def void setGenModelContainerPath(IPath path) {
		this.genModelContainerPath = path	
	}
	
	def void updateDsmlPluginNames() {
		var String qname = page1.getDSLQualifiedName()
		if(qname.endsWith(".ecore")) qname = qname.substring(0, qname.length() - 6)
		//page2.setDsmlEcorePluginName('''«qname».ecore''')
		//page2.setDsmlEditPluginName('''«qname».edit''')
		//page2.setDsmlUIPluginName('''«qname».ui''')
		//page2.setPageComplete(true)
	}
	
	override modifyWorkspace(IProgressMonitor progressMonitor) throws CoreException, UnsupportedEncodingException, IOException {
		super.modifyWorkspace(progressMonitor)
	}

	override boolean performFinish() {
		super.performFinish()
	}

	def LiftOMLBundle2XcoreMetamodelWizardPage getLiftOMLBundle2XcoreMetamodelWizardPage() {
		return page1
	}
	
	def LiftOMLBundle2XcoreNewProjectWizardPage getLiftOMLBundle2XcoreNewProjectWizardPage1() {
		return newProjectCreationPage1 as LiftOMLBundle2XcoreNewProjectWizardPage
	}
	
	def LiftOMLBundle2XcoreNewProjectWizardPage getLiftOMLBundle2XcoreNewProjectWizardPage2() {
		return newProjectCreationPage2 as LiftOMLBundle2XcoreNewProjectWizardPage
	}
	
	def LiftOMLBundle2XcoreNewProjectWizardPage getLiftOMLBundle2XcoreNewProjectWizardPage() {
		return newProjectCreationPage as LiftOMLBundle2XcoreNewProjectWizardPage
	}
	
	override protected String[] getRequiredBundles() {
		#[
			"org.eclipse.core.runtime",
			"org.eclipse.emf.ecore",
			"org.eclipse.emf.codegen.ecore",
			"org.eclipse.emf.cdo",
			"org.eclipse.xtext.xbase.lib",
			"org.eclipse.emf.ecore.xcore",
			"org.eclipse.emf.ecore.xcore.lib",
			"gov.nasa.jpl.imce.oml.runtime"
		]
	}

}
