/*
 * Copyright 2017 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.dsl.ui.wizard;

import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;

import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import com.google.inject.Inject;

public class OMLNewProjectWizard extends XtextNewProjectWizard {

	private OMLWizardNewProjectCreationPage mainPage;

	@Inject
	public OMLNewProjectWizard(IProjectCreator projectCreator) {
		super(projectCreator);
		setWindowTitle("New OML Project");
	}

	protected OMLWizardNewProjectCreationPage getMainPage() {
		return mainPage;
	}

	/**
	 * Use this method to add pages to the wizard.
	 * The one-time generated version of this class will add a default new project page to the wizard.
	 */
	@Override
	public void addPages() {
		mainPage = createMainPage("basicNewProjectPage");
		mainPage.setTitle("OML Project");
		mainPage.setDescription("Create a new OML project.");
		addPage(mainPage);
	}

	protected OMLWizardNewProjectCreationPage createMainPage(String pageName) {
		return new OMLWizardNewProjectCreationPage(pageName);
	}

	/**
	 * Use this method to read the project settings from the wizard pages and feed them into the project info class.
	 */
	@Override
	protected IExtendedProjectInfo getProjectInfo() {
		OMLProjectInfo projectInfo = new OMLProjectInfo();
		projectInfo.setProjectName(mainPage.getProjectName());
		if (!mainPage.useDefaults()) {
			projectInfo.setLocationPath(mainPage.getLocationPath());
		}
		return projectInfo;
	}

}
