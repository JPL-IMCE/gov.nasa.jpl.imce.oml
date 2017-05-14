package gov.nasa.jpl.imce.oml.dsl.ui.converter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.MonitorBasedCancelIndicator;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

@SuppressWarnings("all")
public class LiftOMLBundleToXcoreHandler extends AbstractHandler {
  @Inject
  private IGenerator2 generator;
  
  @Inject
  private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;
  
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Override
  public boolean isEnabled() {
    return true;
  }
  
  @Inject
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final EclipseResourceFileSystemAccess2 fsa = this.fileAccessProvider.get();
    final IProgressMonitor monitor = new NullProgressMonitor();
    fsa.setMonitor(monitor);
    final MonitorBasedCancelIndicator cancelIndicator = new MonitorBasedCancelIndicator(monitor);
    final GeneratorContext generatorContext = new GeneratorContext();
    generatorContext.setCancelIndicator(cancelIndicator);
    final ISelection selection = HandlerUtil.getCurrentSelection(event);
    if ((selection instanceof IStructuredSelection)) {
      Object _firstElement = ((IStructuredSelection) selection).getFirstElement();
      final IFile omlFile = ((IFile) _firstElement);
      final URI uri = URI.createPlatformResourceURI(omlFile.getFullPath().toString(), true);
      final ResourceSet rs = this.resourceSetProvider.get(omlFile.getProject());
      final Resource r = rs.getResource(uri, true);
      this.generate(r, omlFile, fsa, generatorContext, monitor);
      return null;
    }
    final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
    boolean _matched = false;
    if (activeEditor instanceof XtextEditor) {
      _matched=true;
      IFile _adapter = ((XtextEditor)activeEditor).getEditorInput().<IFile>getAdapter(IFile.class);
      final IFile omlFile_1 = _adapter;
      boolean _matched_1 = false;
      if (omlFile_1 instanceof IFile) {
        _matched_1=true;
        IXtextDocument _document = ((XtextEditor)activeEditor).getDocument();
        _document.<Boolean>readOnly(new IUnitOfWork<Boolean, XtextResource>() {
          @Override
          public Boolean exec(final XtextResource state) throws Exception {
            Boolean _xblockexpression = null;
            {
              LiftOMLBundleToXcoreHandler.this.generate(state, omlFile_1, fsa, generatorContext, monitor);
              _xblockexpression = Boolean.TRUE;
            }
            return _xblockexpression;
          }
        });
      }
      if (!_matched_1) {
      }
    }
    if (!_matched) {
    }
    return null;
  }
  
  public void generate(final Resource r, final IFile omlFile, final EclipseResourceFileSystemAccess2 fsa, final GeneratorContext generatorContext, final IProgressMonitor monitor) {
    this.configure(fsa, omlFile, monitor);
    this.generator.beforeGenerate(r, fsa, generatorContext);
    try {
      this.generator.doGenerate(r, fsa, generatorContext);
    } finally {
      this.generator.afterGenerate(r, fsa, generatorContext);
    }
  }
  
  /**
   * @TODO retrieve the output folder from the project's effective preferences
   */
  public void configure(final EclipseResourceFileSystemAccess2 fsa, final IFile omlFile, final IProgressMonitor monitor) {
    final String outDir = "models-gen";
    fsa.setProject(omlFile.getProject());
    fsa.setOutputPath(outDir);
    final OutputConfiguration outputConfig = fsa.getOutputConfigurations().get(EclipseResourceFileSystemAccess2.DEFAULT_OUTPUT);
    if ((outputConfig != null)) {
      outputConfig.setCreateOutputDirectory(true);
    } else {
      throw new IllegalArgumentException(
        (("LiftOMLBundleToXcoreHandler.configure - There should be a " + 
          EclipseResourceFileSystemAccess2.DEFAULT_OUTPUT) + 
          " output configuration on the EclipseResourceFileSystemAccess2"));
    }
  }
}
