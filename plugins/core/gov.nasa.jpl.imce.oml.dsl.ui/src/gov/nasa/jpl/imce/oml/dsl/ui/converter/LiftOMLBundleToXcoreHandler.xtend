package gov.nasa.jpl.imce.oml.dsl.ui.converter

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.xtext.builder.MonitorBasedCancelIndicator
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.IProgressMonitor

class LiftOMLBundleToXcoreHandler extends AbstractHandler {

	@Inject
	protected IGenerator2 generator

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

		val ISelection selection = HandlerUtil.getCurrentSelection(event)
		if (selection instanceof IStructuredSelection) {
			val omlFile = (selection as IStructuredSelection).firstElement as IFile
			val URI uri = URI.createPlatformResourceURI(omlFile.getFullPath().toString(), true)
			val rs = resourceSetProvider.get(omlFile.getProject)
			val Resource r = rs.getResource(uri, true)

			generate(r, omlFile, fsa, generatorContext, monitor)
			return null
		}
		val IEditorPart activeEditor = HandlerUtil.getActiveEditor(event)
		switch activeEditor {
			XtextEditor:
				switch omlFile : activeEditor.getEditorInput.getAdapter(IFile) {
					IFile:
						activeEditor.document.readOnly(new IUnitOfWork<Boolean, XtextResource>() {

							override exec(XtextResource state) throws Exception {
								generate(state, omlFile, fsa, generatorContext, monitor)
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

	def void generate(Resource r, IFile omlFile, EclipseResourceFileSystemAccess2 fsa,
		GeneratorContext generatorContext, IProgressMonitor monitor) {
		configure(fsa, omlFile, monitor)
		generator.beforeGenerate(r, fsa, generatorContext)
		try {
			generator.doGenerate(r, fsa, generatorContext)
		} finally {
			generator.afterGenerate(r, fsa, generatorContext)

		}
	}

	/*
	 * @TODO retrieve the output folder from the project's effective preferences
	 */
	def void configure(EclipseResourceFileSystemAccess2 fsa, IFile omlFile, IProgressMonitor monitor) {
		val outDir = "models-gen"
		fsa.project = omlFile.project
		
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
		