package gov.nasa.jpl.imce.oml.dsl.ui.converter;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class LiftOMLBundle2XcoreMetamodelWizardPage extends WizardPage {
	private Text dslQualifiedNameText;
	private Text dsmlBundleSpecificationPath;

	/**
	 * Create the wizard.
	 */
	public LiftOMLBundle2XcoreMetamodelWizardPage() {
		super("wizardPage");
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
		dsmlBundleSpecificationLabel.setAlignment(SWT.RIGHT);
		dsmlBundleSpecificationLabel.setText("DSML Specification:");
		
		dsmlBundleSpecificationPath = new Text(container, SWT.BORDER);
		dsmlBundleSpecificationPath.setEnabled(false);
		dsmlBundleSpecificationPath.setEditable(false);
		
		Label dsmlQualifiedNameLabel = new Label(container, SWT.NONE);
		dsmlQualifiedNameLabel.setAlignment(SWT.RIGHT);
		dsmlQualifiedNameLabel.setText("DSML qualified name:");
		
		dslQualifiedNameText = new Text(container, SWT.BORDER);
		dslQualifiedNameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!dslQualifiedNameText.getText().isEmpty())
					setPageComplete(true);
			}
		});
		dslQualifiedNameText.setTextLimit(80);
		
		setPageComplete(false);
	}
	
	
}
