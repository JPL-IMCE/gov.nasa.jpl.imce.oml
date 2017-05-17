/**
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

import com.google.inject.Inject;
import com.google.inject.Provider;
import gov.nasa.jpl.imce.oml.dsl.generator.OMLGenerator;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreMetamodelWizard;
import gov.nasa.jpl.imce.oml.dsl.ui.converter.LiftOMLBundle2XcoreMetamodelWizardDialog;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.MonitorBasedCancelIndicator;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class LiftOMLBundleToXcoreHandler extends AbstractHandler {
  @Inject
  protected OMLGenerator generator;
  
  @Inject
  protected Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;
  
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
    final IStructuredSelection sselection = HandlerUtil.getCurrentStructuredSelection(event);
    final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
    IWorkbench _workbench = null;
    if (window!=null) {
      _workbench=window.getWorkbench();
    }
    final IWorkbench wb = _workbench;
    if ((sselection != null)) {
      Object _firstElement = sselection.getFirstElement();
      final IFile omlFile = ((IFile) _firstElement);
      if ((omlFile != null)) {
        final URI uri = URI.createPlatformResourceURI(omlFile.getFullPath().toString(), true);
        final ResourceSet rs = this.resourceSetProvider.get(omlFile.getProject());
        final Resource r = rs.getResource(uri, true);
        this.generate(wb, sselection, event, r, omlFile, fsa, generatorContext, monitor);
        return null;
      }
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
              LiftOMLBundleToXcoreHandler.this.generate(wb, sselection, event, state, omlFile_1, fsa, generatorContext, monitor);
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
  
  public void generate(final IWorkbench wb, final IStructuredSelection sselection, final ExecutionEvent event, final Resource r, final IFile omlFile, final EclipseResourceFileSystemAccess2 fsa, final GeneratorContext generatorContext, final IProgressMonitor monitor) throws ExecutionException {
    try {
      try {
        this.generator.beforeGenerate(r, fsa, generatorContext);
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          final IllegalArgumentException e = (IllegalArgumentException)_t;
          String _message = e.getMessage();
          String _plus = ("LiftOMLBundleToXcore error: " + _message);
          throw new ExecutionException(_plus, e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final Bundle omlBundle = this.generator.getBundle();
      final Shell shell = HandlerUtil.getActiveShell(event);
      final LiftOMLBundle2XcoreMetamodelWizard wizard = new LiftOMLBundle2XcoreMetamodelWizard(wb, sselection, omlBundle);
      final LiftOMLBundle2XcoreMetamodelWizardDialog wDialog = new LiftOMLBundle2XcoreMetamodelWizardDialog(shell, wizard);
      int _open = wDialog.open();
      boolean _equals = (_open == Window.OK);
      if (_equals) {
        try {
          boolean _exists = wDialog.ecoreProjectHandle.exists();
          boolean _not = (!_exists);
          if (_not) {
            wDialog.ecoreProjectHandle.create(monitor);
          }
          boolean _isOpen = wDialog.ecoreProjectHandle.isOpen();
          boolean _not_1 = (!_isOpen);
          if (_not_1) {
            wDialog.ecoreProjectHandle.open(monitor);
          }
          this.generator.setEcoreProjectHandle(wDialog.ecoreProjectHandle);
          this.generator.setEditProjectHandle(wDialog.editProjectHandle);
          this.generator.setUIProjectHandle(wDialog.uiProjectHandle);
          this.generator.setDSMLName(wDialog.dsmlName);
          this.configure(fsa, wDialog.ecoreProjectHandle, monitor);
          this.generator.doGenerate(r, fsa, generatorContext);
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof IllegalArgumentException) {
            final IllegalArgumentException e_1 = (IllegalArgumentException)_t_1;
            String _message_1 = e_1.getMessage();
            String _plus_1 = ("LiftOMLBundleToXcore error: " + _message_1);
            throw new ExecutionException(_plus_1, e_1);
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        } finally {
          this.generator.afterGenerate(r, fsa, generatorContext);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void configure(final EclipseResourceFileSystemAccess2 fsa, final IProject metamodelProject, final IProgressMonitor monitor) {
    final String outDir = "model";
    fsa.setProject(metamodelProject);
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
