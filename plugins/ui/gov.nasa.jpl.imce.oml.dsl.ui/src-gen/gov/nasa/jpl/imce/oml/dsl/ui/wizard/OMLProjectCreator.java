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

import org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class OMLProjectCreator extends AbstractPluginProjectCreator {
	protected static final String DSL_PROJECT_NAME = "gov.nasa.jpl.imce.oml.dsl";

	@Inject
	private OMLNewProjectWizardInitialContents initialContents;

	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;

	@Inject
	private IOutputConfigurationProvider outputConfigurationProvider;

	@Override
	protected PluginProjectFactory createProjectFactory() {
		PluginProjectFactory projectFactory = super.createProjectFactory();
		projectFactory.setWithPluginXml(false);
		return projectFactory;
	}

	@Override
	protected OMLProjectInfo getProjectInfo() {
		return (OMLProjectInfo) super.getProjectInfo();
	}

	@Override
	protected String getModelFolderName() {
		return "src";
	}

	@Override
	protected List<String> getAllFolders() {
		Set<OutputConfiguration> outputConfigurations = outputConfigurationProvider.getOutputConfigurations();
		String outputFolder = "src-gen";
		for (OutputConfiguration outputConfiguration : outputConfigurations) {
			if (IFileSystemAccess.DEFAULT_OUTPUT.equals(outputConfiguration.getName())) {
				outputFolder = outputConfiguration.getOutputDirectory();
				break;
			}
		}
		return ImmutableList.of(getModelFolderName(), outputFolder);
	}

	@Override
	protected List<String> getRequiredBundles() {
		return Lists.newArrayList(DSL_PROJECT_NAME);
	}

	@Override
	protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
		IFileSystemAccess2 access = getFileSystemAccess(project, monitor);
		initialContents.generateInitialContents(access);
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

	protected IFileSystemAccess2 getFileSystemAccess(final IProject project, final IProgressMonitor monitor) {
		EclipseResourceFileSystemAccess2 access = fileSystemAccessProvider.get();
		access.setContext(project);
		access.setMonitor(monitor);
		OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
		defaultOutput.setDescription("Output Folder");
		defaultOutput.setOutputDirectory("./");
		defaultOutput.setOverrideExistingResources(true);
		defaultOutput.setCreateOutputDirectory(true);
		defaultOutput.setCleanUpDerivedResources(false);
		defaultOutput.setSetDerivedProperty(false);
		defaultOutput.setKeepLocalHistory(false);
		HashMap<String, OutputConfiguration> outputConfigurations = new HashMap<String, OutputConfiguration>();
		outputConfigurations.put(IFileSystemAccess.DEFAULT_OUTPUT, defaultOutput);
		access.setOutputConfigurations(outputConfigurations);
		return access;
	}
}
