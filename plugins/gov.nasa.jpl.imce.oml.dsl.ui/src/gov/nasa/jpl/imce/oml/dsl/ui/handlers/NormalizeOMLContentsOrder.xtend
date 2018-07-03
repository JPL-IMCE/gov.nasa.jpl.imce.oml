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
 package gov.nasa.jpl.imce.oml.dsl.ui.handlers

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException

import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.common.Extent
import org.eclipse.xtext.ui.editor.model.IXtextDocument

class NormalizeOMLContentsOrder extends AbstractHandler {
	
	override Object execute(ExecutionEvent event) throws ExecutionException {
		val XtextEditor editor = EditorUtils.getActiveXtextEditor(event)
		val IXtextDocument doc = editor?.document
		if (null !== doc) {
			doc.modify(normalizeOMLResource)
		}
		null
	}
	
	protected static val IUnitOfWork.Void<XtextResource> normalizeOMLResource = new IUnitOfWork.Void<XtextResource>() {

		override void process(XtextResource state) throws Exception {
			state.contents.filter(Extent).forEach [ ext |
				OMLExtensions.normalize(ext)
			]
			state.modified = true
		}
	}
	
}