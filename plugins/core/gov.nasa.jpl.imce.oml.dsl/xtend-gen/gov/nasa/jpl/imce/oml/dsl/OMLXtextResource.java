/**
 * Copyright 2016 California Institute of Technology ("Caltech").
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
package gov.nasa.jpl.imce.oml.dsl;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * OMLXtextResource is a specialization of Xtext's LazyLinkingResource for the OML domain.
 * 
 * Why is this specialization necessary? When loading/saving an OML Xtext resource,
 * the resource's http URI is mapped through a CatalogURIConverter to a file URI.
 * This URIConverter mapping appends a 'file.extension', (I.e., 'oml') if needed
 * via the OMLXtextResource's default load/save options.
 * 
 * Since the EMF API does not provide a URIConverter the information about the kind of resource,
 * the only alternative involves passing this information via the resource's default load/save options.
 * Since EMF's Resource default load/save option information is protected, it is therefore necessary
 * to specify this information in the context of a specialization.
 */
@SuppressWarnings("all")
public class OMLXtextResource extends LazyLinkingResource {
  private final static Map<Object, Object> defaultOptions = new Function0<Map<Object, Object>>() {
    public Map<Object, Object> apply() {
      HashMap<Object, Object> _xblockexpression = null;
      {
        final HashMap<Object, Object> options = new HashMap<Object, Object>();
        options.put("file.extension", "oml");
        _xblockexpression = options;
      }
      return _xblockexpression;
    }
  }.apply();
  
  public OMLXtextResource() {
    super();
    this.defaultLoadOptions = OMLXtextResource.defaultOptions;
    this.defaultSaveOptions = OMLXtextResource.defaultOptions;
  }
}
