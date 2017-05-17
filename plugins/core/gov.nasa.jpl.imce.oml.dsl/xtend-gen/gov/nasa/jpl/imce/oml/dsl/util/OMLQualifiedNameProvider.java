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
package gov.nasa.jpl.imce.oml.dsl.util;

import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

@SuppressWarnings("all")
public class OMLQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
  @Inject
  private IQualifiedNameConverter qnc;
  
  public QualifiedName qualifiedName(final AnnotationProperty ap) {
    String _iri = ap.getIri();
    String _plus = ("AnnotationProperty<" + _iri);
    String _plus_1 = (_plus + ">");
    return this.qnc.toQualifiedName(_plus_1);
  }
  
  public QualifiedName qualifiedName(final Term term) {
    return this.qnc.toQualifiedName(term.abbrevIRI());
  }
  
  public QualifiedName qualifiedName(final ConceptualEntitySingletonInstance i) {
    return this.qnc.toQualifiedName(i.abbrevIRI());
  }
  
  public QualifiedName qualifiedName(final ModuleEdge edge) {
    String _kind = OMLExtensions.kind(edge);
    String _plus = (_kind + "(");
    Module _sourceModule = edge.sourceModule();
    String _iri = null;
    if (_sourceModule!=null) {
      _iri=_sourceModule.iri();
    }
    String _plus_1 = (_plus + _iri);
    String _plus_2 = (_plus_1 + "->");
    Module _targetModule = edge.targetModule();
    String _iri_1 = null;
    if (_targetModule!=null) {
      _iri_1=_targetModule.iri();
    }
    String _plus_3 = (_plus_2 + _iri_1);
    String _plus_4 = (_plus_3 + ")");
    return this.qnc.toQualifiedName(_plus_4);
  }
  
  public QualifiedName qualifiedName(final DescriptionBox m) {
    String _string = m.getKind().toString();
    String _plus = (_string + " ");
    String _kind = OMLExtensions.kind(m);
    String _plus_1 = (_plus + _kind);
    String _plus_2 = (_plus_1 + "<");
    String _iri = m.iri();
    String _plus_3 = (_plus_2 + _iri);
    String _plus_4 = (_plus_3 + ">");
    return this.qnc.toQualifiedName(_plus_4);
  }
  
  public QualifiedName qualifiedName(final Bundle m) {
    String _string = m.getKind().toString();
    String _plus = (_string + " ");
    String _kind = OMLExtensions.kind(m);
    String _plus_1 = (_plus + _kind);
    String _plus_2 = (_plus_1 + "<");
    String _iri = m.iri();
    String _plus_3 = (_plus_2 + _iri);
    String _plus_4 = (_plus_3 + ">");
    return this.qnc.toQualifiedName(_plus_4);
  }
  
  public QualifiedName qualifiedName(final TerminologyGraph m) {
    String _string = m.getKind().toString();
    String _plus = (_string + " ");
    String _kind = OMLExtensions.kind(m);
    String _plus_1 = (_plus + _kind);
    String _plus_2 = (_plus_1 + "<");
    String _iri = m.iri();
    String _plus_3 = (_plus_2 + _iri);
    String _plus_4 = (_plus_3 + ">");
    return this.qnc.toQualifiedName(_plus_4);
  }
}
