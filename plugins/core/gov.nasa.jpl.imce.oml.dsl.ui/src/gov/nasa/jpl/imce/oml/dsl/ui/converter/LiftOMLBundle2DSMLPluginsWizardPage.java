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
package gov.nasa.jpl.imce.oml.dsl.ui.converter;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class LiftOMLBundle2DSMLPluginsWizardPage extends WizardPage {
	
	private Text dsmlEcorePluginName;
	private Text dsmlEditPluginName;
	private Text dsmlUIPluginName;
	
	/**
	 * Create the wizard.
	 */
	public LiftOMLBundle2DSMLPluginsWizardPage() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label dsmlEcorePluginLabel = new Label(container, SWT.NONE);
		dsmlEcorePluginLabel.setToolTipText("If needed, customize the Java package qualified name for the DSML metamodel plugin.");
		dsmlEcorePluginLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		dsmlEcorePluginLabel.setText("DSML ecore plugin:");
		
		dsmlEcorePluginName = new Text(container, SWT.BORDER);
		dsmlEcorePluginName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label dsmlEditPluginLabel = new Label(container, SWT.NONE);
		dsmlEditPluginLabel.setToolTipText("If needed, customize the Java package qualified name for the DSML edit plugin.");
		dsmlEditPluginLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		dsmlEditPluginLabel.setText("DSML edit plugin:");
		
		dsmlEditPluginName = new Text(container, SWT.BORDER);
		dsmlEditPluginName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label dsmlUIPluginLabel = new Label(container, SWT.NONE);
		dsmlUIPluginLabel.setToolTipText("If needed, customize the Java package qualified name for the DSML Eclipse UI plugin.");
		dsmlUIPluginLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		dsmlUIPluginLabel.setText("DSML ui plugin:");
		
		dsmlUIPluginName = new Text(container, SWT.BORDER);
		dsmlUIPluginName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		setPageComplete(true);
	}

	public void setDsmlEcorePluginName(String dsmlEcorePluginName) {
		this.dsmlEcorePluginName.setText(dsmlEcorePluginName);
	}
	
	public String getDsmlEcorePluginName() {
		return dsmlEcorePluginName.getText();
	}

	public void setDsmlEditPluginName(String dsmlEditPluginName) {
		this.dsmlEditPluginName.setText(dsmlEditPluginName);
	}
	
	public String getDsmlEditPluginName() {
		return dsmlEditPluginName.getText();
	}

	public void setDsmlUIPluginName(String dsmlUIPluginName) {
		this.dsmlUIPluginName.setText(dsmlUIPluginName);
	}
	
	public String getDsmlUIPluginName() {
		return dsmlUIPluginName.getText();
	}

}
