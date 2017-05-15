package gov.nasa.jpl.imce.oml.dsl.ui.converter

import com.google.inject.Inject
import com.google.inject.Provider
import gov.nasa.jpl.imce.oml.dsl.generator.OntologicalModelingLanguageGenerator
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.window.Window
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import org.eclipse.xtext.builder.MonitorBasedCancelIndicator
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.ui.IWorkbenchWindow
import org.eclipse.ui.IWorkbench

class LiftOMLBundleToXcoreHandler extends AbstractHandler {

	@Inject
	protected OntologicalModelingLanguageGenerator generator

	@Inject
	protected Provider<EclipseResourceFileSystemAccess2> fileAccessProvider

	@Inject
	IResourceSetProvider resourceSetProvider

	override boolean isEnabled() {
		true
	}

	@Inject
	override Object execute(ExecutionEvent event) throws ExecutionException {

		val EclipseResourceFileSystemAccess2 fsa = fileAccessProvider.get()
		val IProgressMonitor monitor = new NullProgressMonitor()
		fsa.monitor = monitor

		val MonitorBasedCancelIndicator cancelIndicator = new MonitorBasedCancelIndicator(monitor)
		val GeneratorContext generatorContext = new GeneratorContext()
		generatorContext.setCancelIndicator(cancelIndicator)

		val IStructuredSelection sselection = HandlerUtil.getCurrentStructuredSelection(event)
		val IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event)
		val IWorkbench wb = window?.workbench
		
		if (sselection !== null) {
			val omlFile = sselection.firstElement as IFile
			if (omlFile !== null) {
				val URI uri = URI.createPlatformResourceURI(omlFile.getFullPath().toString(), true)
				val rs = resourceSetProvider.get(omlFile.getProject)
				val Resource r = rs.getResource(uri, true)

				generate(wb, sselection, event, r, omlFile, fsa, generatorContext, monitor)
				return null
			}
		}
		val IEditorPart activeEditor = HandlerUtil.getActiveEditor(event)
		switch activeEditor {
			XtextEditor:
				switch omlFile : activeEditor.getEditorInput.getAdapter(IFile) {
					IFile:
						activeEditor.document.readOnly(new IUnitOfWork<Boolean, XtextResource>() {

							override exec(XtextResource state) throws Exception {
								generate(wb, sselection, event, state, omlFile, fsa, generatorContext, monitor)
								Boolean.TRUE
							}
						})
					default: {
					}
				}
			default: {
			}
		}
		return null
	}

	def void generate(IWorkbench wb, IStructuredSelection sselection, ExecutionEvent event, Resource r, IFile omlFile,
		EclipseResourceFileSystemAccess2 fsa, GeneratorContext generatorContext,
		IProgressMonitor monitor) throws ExecutionException {

			try {
				generator.beforeGenerate(r, fsa, generatorContext)
			} catch (IllegalArgumentException e) {
				throw new ExecutionException("LiftOMLBundleToXcore error: " + e.getMessage, e)
			}

			val omlBundle = generator.getBundle

			val shell = HandlerUtil.getActiveShell(event)
			val wizard = new LiftOMLBundle2XcoreMetamodelWizard(wb, sselection, omlBundle);
			val wDialog = new LiftOMLBundle2XcoreMetamodelWizardDialog(shell, wizard);

			if (wDialog.open == Window.OK) {
				try {
					if (!wDialog.ecoreProjectHandle.exists)
						wDialog.ecoreProjectHandle.create(monitor)
					
					if (!wDialog.ecoreProjectHandle.open)
						wDialog.ecoreProjectHandle.open(monitor)
						
					generator.ecoreProjectHandle = wDialog.ecoreProjectHandle
					generator.editProjectHandle = wDialog.editProjectHandle
					generator.UIProjectHandle = wDialog.uiProjectHandle
					generator.DSMLName = wDialog.dsmlName
					
					configure(fsa, wDialog.ecoreProjectHandle, monitor)
					generator.doGenerate(r, fsa, generatorContext)
				} catch (IllegalArgumentException e) {
					throw new ExecutionException("LiftOMLBundleToXcore error: " + e.getMessage, e)
				} finally {
					generator.afterGenerate(r, fsa, generatorContext)
				}
			}
		}

		def void configure(EclipseResourceFileSystemAccess2 fsa, IProject metamodelProject, IProgressMonitor monitor) {
			// See org.eclipse.emf.codegen.ecore.ui.EmptyProjectWizard.modifyWorkspace(IProgressMonitor)
			val outDir = "model"
			fsa.project = metamodelProject

			// Note: as a side effect, this sets the EclipseResourceFileSystemAccess2.DEFAULT_OUTPUT output configuration.
			fsa.outputPath = outDir
			val outputConfig = fsa.outputConfigurations.get(EclipseResourceFileSystemAccess2.DEFAULT_OUTPUT)
			if (outputConfig !== null) {
				outputConfig.createOutputDirectory = true
			} else
				throw new IllegalArgumentException(
					"LiftOMLBundleToXcoreHandler.configure - There should be a " +
						EclipseResourceFileSystemAccess2.DEFAULT_OUTPUT +
						" output configuration on the EclipseResourceFileSystemAccess2")
				}
			}
			