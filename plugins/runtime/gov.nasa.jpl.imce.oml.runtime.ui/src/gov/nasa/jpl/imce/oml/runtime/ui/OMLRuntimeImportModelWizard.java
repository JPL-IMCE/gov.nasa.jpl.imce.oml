/**
 * 
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package gov.nasa.jpl.imce.oml.runtime.ui;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardResourceImportPage;

import gov.nasa.jpl.imce.oml.runtime.OMLRuntimeFactory;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage;
import gov.nasa.jpl.imce.oml.runtime.generator.OML2EcoreGenerator;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OMLRuntimeImportModelWizard extends Wizard implements IImportWizard {

	/**
	 * The supported extensions for created files.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS =
		Collections.unmodifiableList(Arrays.asList(OMLRuntimeEditorPlugin.INSTANCE.getString("_UI_OMLRuntimeEditorFilenameExtensions").split("\\s*,\\s*")));

	/**
	 * A formatted list of supported file extensions, suitable for display.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS =
		OMLRuntimeEditorPlugin.INSTANCE.getString("_UI_OMLRuntimeEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLRuntimePackage omlRuntimePackage = OMLRuntimePackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLRuntimeFactory omlRuntimeFactory = omlRuntimePackage.getOMLRuntimeFactory();

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLRuntimeModelWizardImportPage importPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * Caches the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected List<String> initialObjectNames;

	/**
	 * This just records the information.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(OMLRuntimeEditorPlugin.INSTANCE.getString("FileImport_title"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(OMLRuntimeEditorPlugin.INSTANCE.getImage("full/wizban/NewOMLRuntime")));
	}

	/**
	 * Returns the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			for (EClassifier eClassifier : omlRuntimePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						initialObjectNames.add(eClass.getName());
					}
				}
			}
			Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		}
		return initialObjectNames;
	}

	/**
	 * Do the work after everything is specified.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean performFinish() {
		File file = importPage.getModelFile();
		IPath path = importPage.getResourcePath();
		
		OML2EcoreGenerator generator = new OML2EcoreGenerator();
		generator.generate(file, path);

		return true;
	}

	
	/**
	 * This is the one page of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class OMLRuntimeModelWizardImportPage extends WizardResourceImportPage {
		
	    protected Button overwriteExistingResourcesCheckbox;
	    protected Combo sourceNameField;
	    protected Button sourceBrowseButton;

	    /**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public OMLRuntimeModelWizardImportPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		@Override
		protected ITreeContentProvider getFileProvider() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected ITreeContentProvider getFolderProvider() {
			// TODO Auto-generated method stub
			return null;
		}

	    @Override
		protected void createOptionsGroupButtons(Group optionsGroup) {
	        overwriteExistingResourcesCheckbox = new Button(optionsGroup, SWT.CHECK);
	        overwriteExistingResourcesCheckbox.setFont(optionsGroup.getFont());
	        overwriteExistingResourcesCheckbox.setText(OMLRuntimeEditorPlugin.INSTANCE.getString("FileImport_overwriteExisting"));
	    }

		@Override
		protected void createSourceGroup(Composite parent) {
	        Composite sourceContainerGroup = new Composite(parent, SWT.NONE);
	        GridLayout layout = new GridLayout();
	        layout.numColumns = 3;
	        sourceContainerGroup.setLayout(layout);
	        sourceContainerGroup.setFont(parent.getFont());
	        sourceContainerGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));

	        Label groupLabel = new Label(sourceContainerGroup, SWT.NONE);
	        groupLabel.setText(OMLRuntimeEditorPlugin.INSTANCE.getString("FileImport_fromDirectory"));
	        groupLabel.setFont(parent.getFont());

	        // source name entry field
	        sourceNameField = new Combo(sourceContainerGroup, SWT.BORDER);
	        GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
	        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
	        sourceNameField.setLayoutData(data);
	        sourceNameField.setFont(parent.getFont());
	        sourceNameField.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					updatePageCompletion();
				}
			});
	        sourceNameField.addSelectionListener(new SelectionAdapter() {
	        	@Override
	        	public void widgetSelected(SelectionEvent e) {
					updatePageCompletion();
	        	}
			});

	        // source browse button
	        sourceBrowseButton = new Button(sourceContainerGroup, SWT.PUSH);
	        sourceBrowseButton.setText(OMLRuntimeEditorPlugin.INSTANCE.getString("FileImport_browse"));
	        sourceBrowseButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
	        sourceBrowseButton.setFont(parent.getFont());
	        sourceBrowseButton.addSelectionListener(new SelectionAdapter() {
	            @Override
				public void widgetSelected(SelectionEvent e) {
					handleSourceBrowseButtonPressed();
	            }
	        });
	        setButtonLayoutData(sourceBrowseButton);
	    }

	    protected void handleSourceBrowseButtonPressed() {
			String currentSource = this.sourceNameField.getText().trim();
			FileDialog dialog = new FileDialog(getContainer().getShell(),SWT.OPEN | SWT.SHEET);
			dialog.setText(OMLRuntimeEditorPlugin.INSTANCE.getString("FileImport_selectSourceTitle"));
			dialog.setFilterPath(currentSource);
			dialog.setFilterExtensions(new String[] {"*.oml"}); //$NON-NLS-1$
			String selectedFileName = dialog.open();
			if (selectedFileName != null) {
				this.sourceNameField.setText(selectedFileName);
			}
	    }

	    protected boolean validateSourceGroup() {
			String currentSource = this.sourceNameField.getText().trim();
	        if (currentSource.length()==0) {
	            setErrorMessage(OMLRuntimeEditorPlugin.INSTANCE.getString("FileImport_emptySource"));
	            return false;
	        }
	        File sourceFile = new File(currentSource);
	        if (!sourceFile.exists()) {
	        	setErrorMessage(OMLRuntimeEditorPlugin.INSTANCE.getString("FileImport_sourceDoesNotExist"));
	            return false;
	        }
	        return true;
	    }
	
		public File getModelFile() {
			String currentSource = this.sourceNameField.getText().trim();
			return new File(currentSource);
		}
		
		public IPath getResourcePath() {
			return super.getResourcePath();
	    }
	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
		@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		importPage = new OMLRuntimeModelWizardImportPage("Whatever", selection);
		importPage.setTitle(OMLRuntimeEditorPlugin.INSTANCE.getString("_UI_OMLRuntimeImportModelWizard_label"));
		importPage.setDescription(OMLRuntimeEditorPlugin.INSTANCE.getString("_UI_OMLRuntimeImportModelWizard_description"));
		addPage(importPage);
	}

}
