 
package gov.nasa.jpl.imce.oml.rcp.parts;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import javax.annotation.PreDestroy;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;

public class PlaygroundPart {
	@Inject
	public PlaygroundPart() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
	}
	
	
	@PreDestroy
	public void preDestroy() {
		
	}
	
	
	@Focus
	public void onFocus() {
		
	}
	
	
	@Persist
	public void save() {
		
	}
	
}