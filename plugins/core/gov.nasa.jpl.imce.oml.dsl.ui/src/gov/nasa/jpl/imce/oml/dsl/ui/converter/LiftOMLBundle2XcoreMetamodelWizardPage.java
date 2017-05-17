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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import gov.nasa.jpl.imce.oml.model.bundles.Bundle;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;

public class LiftOMLBundle2XcoreMetamodelWizardPage extends WizardPage {
	private Text dslQualifiedNameText;
	private Text dsmlBundleSpecificationPath;
	protected Bundle omlBundle;
	protected String initialQName;
	private Text dsmlNameText;
	
	@Override
	public void dispose() {
		omlBundle = null;
		super.dispose();
	}
	/**
	 * Create the wizard.
	 */
	public LiftOMLBundle2XcoreMetamodelWizardPage(String initialQName, Bundle omlBundle) {
		super("wizardPage");
		this.omlBundle = omlBundle;
		this.initialQName = initialQName;
		setTitle("Lift OML Bundle to Xcore Metamodel Wizard");
		setDescription("Generates Eclipse plugins for a Domain-Specific Modeling Language (DSML) implementation of a DSML vocabulary and syntax specified in an OML Bundle.");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label dsmlBundleSpecificationLabel = new Label(container, SWT.NONE);
		dsmlBundleSpecificationLabel.setToolTipText("The IRI of the selected OML Bundle (read-only).");
		dsmlBundleSpecificationLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		dsmlBundleSpecificationLabel.setAlignment(SWT.RIGHT);
		dsmlBundleSpecificationLabel.setText("DSML Specification Bundle IRI:");
		
		dsmlBundleSpecificationPath = new Text(container, SWT.BORDER);
		dsmlBundleSpecificationPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		dsmlBundleSpecificationPath.setEnabled(false);
		dsmlBundleSpecificationPath.setEditable(false);
		dsmlBundleSpecificationPath.setText(omlBundle.iri());
		
		Label dsmlQualifiedNameLabel = new Label(container, SWT.NONE);
		dsmlQualifiedNameLabel.setToolTipText("A Java package namepace prefix (with \".\") for the generated DSML plugins variants (prefix + \".ecore\", prefix + \".edit\", ...).");
		dsmlQualifiedNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		dsmlQualifiedNameLabel.setAlignment(SWT.RIGHT);
		dsmlQualifiedNameLabel.setText("DSML qualified name:");
		
		dslQualifiedNameText = new Text(container, SWT.BORDER);
		dslQualifiedNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		dslQualifiedNameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setPageComplete(!dslQualifiedNameText.getText().isEmpty() && !dsmlNameText.getText().isEmpty());
			}
		});
		dslQualifiedNameText.setText(initialQName);
		
		Label dsmlNameLabel = new Label(container, SWT.NONE);
		dsmlNameLabel.setToolTipText("The unqualified name of the DSML metamodel (without \".\").");
		dsmlNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		dsmlNameLabel.setText("DSML name:");
		dsmlNameLabel.setAlignment(SWT.RIGHT);
		
		dsmlNameText = new Text(container, SWT.BORDER);
		dsmlNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		dsmlNameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setPageComplete(!dslQualifiedNameText.getText().isEmpty() && !dsmlNameText.getText().isEmpty());
			}
		});
		
		setPageComplete(false);
	}

	public String getDSLName() {
		return dsmlNameText.getText();
	}
	
	public String getDSLQualifiedName() {
		return dslQualifiedNameText.getText();
	}
	
}
