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
package gov.nasa.jpl.imce.oml.dsl.ui.handlers;

import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import java.util.function.Consumer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

@SuppressWarnings("all")
public class NormalizeOMLContentsOrder extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    Object _xblockexpression = null;
    {
      final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
      IXtextDocument _document = null;
      if (editor!=null) {
        _document=editor.getDocument();
      }
      final IXtextDocument doc = _document;
      if ((null != doc)) {
        doc.<Object>modify(NormalizeOMLContentsOrder.normalizeOMLResource);
      }
      _xblockexpression = null;
    }
    return _xblockexpression;
  }
  
  protected final static IUnitOfWork.Void<XtextResource> normalizeOMLResource = new IUnitOfWork.Void<XtextResource>() {
    @Override
    public void process(final XtextResource state) throws Exception {
      final Consumer<Extent> _function = (Extent ext) -> {
        OMLExtensions.normalize(ext);
      };
      Iterables.<Extent>filter(state.getContents(), Extent.class).forEach(_function);
      state.setModified(true);
    }
  };
}
