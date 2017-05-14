/**
 * Copyright 2016 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.dsl.ui.labeling;

import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.common.Annotation;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
@SuppressWarnings("all")
public class OntologicalModelingLanguageLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public OntologicalModelingLanguageLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public String text(final AnnotationProperty e) {
    String _abbrevIRI = e.getAbbrevIRI();
    return ("AnnotationProperty " + _abbrevIRI);
  }
  
  public String text(final Annotation a) {
    String _elvis = null;
    Object _doGetText = this.doGetText(a.getSubject());
    String _string = null;
    if (_doGetText!=null) {
      _string=_doGetText.toString();
    }
    if (_string != null) {
      _elvis = _string;
    } else {
      _elvis = "";
    }
    String _plus = (_elvis + "@");
    String _elvis_1 = null;
    AnnotationProperty _property = a.getProperty();
    String _abbrevIRI = null;
    if (_property!=null) {
      _abbrevIRI=_property.getAbbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus_1 = (_plus + _elvis_1);
    return (_plus_1 + " = ...");
  }
  
  public String text(final Term e) {
    String _kind = OMLExtensions.kind(e);
    String _plus = (_kind + "(");
    String _elvis = null;
    String _abbrevIRI = e.abbrevIRI();
    if (_abbrevIRI != null) {
      _elvis = _abbrevIRI;
    } else {
      _elvis = "";
    }
    String _plus_1 = (_plus + _elvis);
    return (_plus_1 + ")");
  }
  
  public String text(final ConceptualEntitySingletonInstance e) {
    String _kind = OMLExtensions.kind(e);
    String _plus = (_kind + "(");
    String _elvis = null;
    String _abbrevIRI = e.abbrevIRI();
    if (_abbrevIRI != null) {
      _elvis = _abbrevIRI;
    } else {
      _elvis = "";
    }
    String _plus_1 = (_plus + _elvis);
    return (_plus_1 + ")");
  }
  
  public String text(final ModuleEdge e) {
    String _kind = OMLExtensions.kind(e);
    String _plus = (_kind + "(");
    String _elvis = null;
    Module _sourceModule = e.sourceModule();
    String _nsPrefix = null;
    if (_sourceModule!=null) {
      _nsPrefix=_sourceModule.nsPrefix();
    }
    if (_nsPrefix != null) {
      _elvis = _nsPrefix;
    } else {
      _elvis = "";
    }
    String _plus_1 = (_plus + _elvis);
    String _plus_2 = (_plus_1 + "->");
    String _elvis_1 = null;
    Module _targetModule = e.targetModule();
    String _nsPrefix_1 = null;
    if (_targetModule!=null) {
      _nsPrefix_1=_targetModule.nsPrefix();
    }
    if (_nsPrefix_1 != null) {
      _elvis_1 = _nsPrefix_1;
    } else {
      _elvis_1 = "";
    }
    String _plus_3 = (_plus_2 + _elvis_1);
    return (_plus_3 + ")");
  }
  
  public String text(final DescriptionBox m) {
    String _string = m.getKind().toString();
    String _plus = (_string + " ");
    String _kind = OMLExtensions.kind(m);
    String _plus_1 = (_plus + _kind);
    String _plus_2 = (_plus_1 + "(");
    String _nsPrefix = m.nsPrefix();
    String _plus_3 = (_plus_2 + _nsPrefix);
    return (_plus_3 + ")");
  }
  
  public String text(final Bundle m) {
    String _string = m.getKind().toString();
    String _plus = (_string + " ");
    String _kind = OMLExtensions.kind(m);
    String _plus_1 = (_plus + _kind);
    String _plus_2 = (_plus_1 + "(");
    String _nsPrefix = m.nsPrefix();
    String _plus_3 = (_plus_2 + _nsPrefix);
    return (_plus_3 + ")");
  }
  
  public String text(final TerminologyGraph m) {
    String _string = m.getKind().toString();
    String _plus = (_string + " ");
    String _kind = OMLExtensions.kind(m);
    String _plus_1 = (_plus + _kind);
    String _plus_2 = (_plus_1 + "(");
    String _nsPrefix = m.nsPrefix();
    String _plus_3 = (_plus_2 + _nsPrefix);
    return (_plus_3 + ")");
  }
  
  public String text(final EntityExistentialRestrictionAxiom ax) {
    String _elvis = null;
    String _elvis_1 = null;
    EntityRelationship _restrictedRelation = ax.getRestrictedRelation();
    String _abbrevIRI = null;
    if (_restrictedRelation!=null) {
      _abbrevIRI=_restrictedRelation.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus = ("someEntities " + _elvis_1);
    String _plus_1 = (_plus + ".");
    String _elvis_2 = null;
    Entity _restrictedDomain = ax.getRestrictedDomain();
    String _abbrevIRI_1 = null;
    if (_restrictedDomain!=null) {
      _abbrevIRI_1=_restrictedDomain.abbrevIRI();
    }
    if (_abbrevIRI_1 != null) {
      _elvis_2 = _abbrevIRI_1;
    } else {
      _elvis_2 = "";
    }
    String _plus_2 = (_plus_1 + _elvis_2);
    String _plus_3 = (_plus_2 + 
      " in ");
    Entity _restrictedRange = ax.getRestrictedRange();
    String _abbrevIRI_2 = null;
    if (_restrictedRange!=null) {
      _abbrevIRI_2=_restrictedRange.abbrevIRI();
    }
    String _plus_4 = (_plus_3 + _abbrevIRI_2);
    if (_plus_4 != null) {
      _elvis = _plus_4;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final EntityUniversalRestrictionAxiom ax) {
    String _elvis = null;
    String _elvis_1 = null;
    EntityRelationship _restrictedRelation = ax.getRestrictedRelation();
    String _abbrevIRI = null;
    if (_restrictedRelation!=null) {
      _abbrevIRI=_restrictedRelation.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus = ("allEntities " + _elvis_1);
    String _plus_1 = (_plus + ".");
    String _elvis_2 = null;
    Entity _restrictedDomain = ax.getRestrictedDomain();
    String _abbrevIRI_1 = null;
    if (_restrictedDomain!=null) {
      _abbrevIRI_1=_restrictedDomain.abbrevIRI();
    }
    if (_abbrevIRI_1 != null) {
      _elvis_2 = _abbrevIRI_1;
    } else {
      _elvis_2 = "";
    }
    String _plus_2 = (_plus_1 + _elvis_2);
    String _plus_3 = (_plus_2 + 
      " in ");
    Entity _restrictedRange = ax.getRestrictedRange();
    String _abbrevIRI_2 = null;
    if (_restrictedRange!=null) {
      _abbrevIRI_2=_restrictedRange.abbrevIRI();
    }
    String _plus_4 = (_plus_3 + _abbrevIRI_2);
    if (_plus_4 != null) {
      _elvis = _plus_4;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final EntityScalarDataPropertyExistentialRestrictionAxiom ax) {
    String _elvis = null;
    String _elvis_1 = null;
    Entity _restrictedEntity = ax.getRestrictedEntity();
    String _abbrevIRI = null;
    if (_restrictedEntity!=null) {
      _abbrevIRI=_restrictedEntity.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus = ("someData " + _elvis_1);
    String _plus_1 = (_plus + ".");
    String _elvis_2 = null;
    EntityScalarDataProperty _scalarProperty = ax.getScalarProperty();
    String _abbrevIRI_1 = null;
    if (_scalarProperty!=null) {
      _abbrevIRI_1=_scalarProperty.abbrevIRI();
    }
    if (_abbrevIRI_1 != null) {
      _elvis_2 = _abbrevIRI_1;
    } else {
      _elvis_2 = "";
    }
    String _plus_2 = (_plus_1 + _elvis_2);
    String _plus_3 = (_plus_2 + " in ");
    DataRange _scalarRestriction = ax.getScalarRestriction();
    String _abbrevIRI_2 = null;
    if (_scalarRestriction!=null) {
      _abbrevIRI_2=_scalarRestriction.abbrevIRI();
    }
    String _plus_4 = (_plus_3 + _abbrevIRI_2);
    if (_plus_4 != null) {
      _elvis = _plus_4;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final EntityScalarDataPropertyUniversalRestrictionAxiom ax) {
    String _elvis = null;
    String _elvis_1 = null;
    Entity _restrictedEntity = ax.getRestrictedEntity();
    String _abbrevIRI = null;
    if (_restrictedEntity!=null) {
      _abbrevIRI=_restrictedEntity.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus = ("allData " + _elvis_1);
    String _plus_1 = (_plus + ".");
    String _elvis_2 = null;
    EntityScalarDataProperty _scalarProperty = ax.getScalarProperty();
    String _abbrevIRI_1 = null;
    if (_scalarProperty!=null) {
      _abbrevIRI_1=_scalarProperty.abbrevIRI();
    }
    if (_abbrevIRI_1 != null) {
      _elvis_2 = _abbrevIRI_1;
    } else {
      _elvis_2 = "";
    }
    String _plus_2 = (_plus_1 + _elvis_2);
    String _plus_3 = (_plus_2 + " in ");
    DataRange _scalarRestriction = ax.getScalarRestriction();
    String _abbrevIRI_2 = null;
    if (_scalarRestriction!=null) {
      _abbrevIRI_2=_scalarRestriction.abbrevIRI();
    }
    String _plus_4 = (_plus_3 + _abbrevIRI_2);
    if (_plus_4 != null) {
      _elvis = _plus_4;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final EntityScalarDataPropertyParticularRestrictionAxiom ax) {
    String _elvis = null;
    Entity _restrictedEntity = ax.getRestrictedEntity();
    String _abbrevIRI = null;
    if (_restrictedEntity!=null) {
      _abbrevIRI=_restrictedEntity.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis = _abbrevIRI;
    } else {
      _elvis = "";
    }
    String _plus = ("allData " + _elvis);
    String _plus_1 = (_plus + ".");
    String _elvis_1 = null;
    EntityScalarDataProperty _scalarProperty = ax.getScalarProperty();
    String _abbrevIRI_1 = null;
    if (_scalarProperty!=null) {
      _abbrevIRI_1=_scalarProperty.abbrevIRI();
    }
    if (_abbrevIRI_1 != null) {
      _elvis_1 = _abbrevIRI_1;
    } else {
      _elvis_1 = "";
    }
    String _plus_2 = (_plus_1 + _elvis_1);
    return (_plus_2 + " = ...");
  }
  
  public String text(final ScalarOneOfLiteralAxiom ax) {
    String _elvis = null;
    ScalarOneOfRestriction _axiom = ax.getAxiom();
    String _abbrevIRI = null;
    if (_axiom!=null) {
      _abbrevIRI=_axiom.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis = _abbrevIRI;
    } else {
      _elvis = "";
    }
    Object _text = this.text(_elvis);
    String _plus = ("oneOf " + _text);
    String _plus_1 = (_plus + " = ");
    String _value = ax.getValue();
    return (_plus_1 + _value);
  }
  
  public String text(final SpecializationAxiom ax) {
    String _elvis = null;
    String _kind = OMLExtensions.kind(ax);
    String _plus = (_kind + " ");
    String _elvis_1 = null;
    Entity _child = ax.child();
    String _abbrevIRI = null;
    if (_child!=null) {
      _abbrevIRI=_child.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus_1 = (_plus + _elvis_1);
    String _plus_2 = (_plus_1 + " <: ");
    Entity _parent = ax.parent();
    String _abbrevIRI_1 = null;
    if (_parent!=null) {
      _abbrevIRI_1=_parent.abbrevIRI();
    }
    String _plus_3 = (_plus_2 + _abbrevIRI_1);
    if (_plus_3 != null) {
      _elvis = _plus_3;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final SingletonInstanceStructuredDataPropertyValue e) {
    String _elvis = null;
    ConceptualEntitySingletonInstance _singletonInstance = e.getSingletonInstance();
    String _abbrevIRI = null;
    if (_singletonInstance!=null) {
      _abbrevIRI=_singletonInstance.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis = _abbrevIRI;
    } else {
      _elvis = "";
    }
    String _plus = (_elvis + " . ");
    String _elvis_1 = null;
    DataRelationshipToStructure _structuredDataProperty = e.getStructuredDataProperty();
    String _abbrevIRI_1 = null;
    if (_structuredDataProperty!=null) {
      _abbrevIRI_1=_structuredDataProperty.abbrevIRI();
    }
    if (_abbrevIRI_1 != null) {
      _elvis_1 = _abbrevIRI_1;
    } else {
      _elvis_1 = "";
    }
    return (_plus + _elvis_1);
  }
  
  public String text(final SingletonInstanceScalarDataPropertyValue e) {
    String _elvis = null;
    ConceptualEntitySingletonInstance _singletonInstance = e.getSingletonInstance();
    String _abbrevIRI = null;
    if (_singletonInstance!=null) {
      _abbrevIRI=_singletonInstance.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis = _abbrevIRI;
    } else {
      _elvis = "";
    }
    String _plus = (_elvis + " . ");
    String _elvis_1 = null;
    EntityScalarDataProperty _scalarDataProperty = e.getScalarDataProperty();
    String _abbrevIRI_1 = null;
    if (_scalarDataProperty!=null) {
      _abbrevIRI_1=_scalarDataProperty.abbrevIRI();
    }
    if (_abbrevIRI_1 != null) {
      _elvis_1 = _abbrevIRI_1;
    } else {
      _elvis_1 = "";
    }
    String _plus_1 = (_plus + _elvis_1);
    String _plus_2 = (_plus_1 + " = ");
    String _scalarPropertyValue = e.getScalarPropertyValue();
    return (_plus_2 + _scalarPropertyValue);
  }
  
  public String text(final SingletonInstanceStructuredDataPropertyContext e) {
    String _elvis = null;
    String _abbrevIRI = e.getStructuredDataProperty().abbrevIRI();
    String _plus = (" . " + _abbrevIRI);
    if (_plus != null) {
      _elvis = _plus;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final StructuredDataPropertyTuple e) {
    String _elvis = null;
    String _abbrevIRI = e.getStructuredDataProperty().abbrevIRI();
    String _plus = (" . " + _abbrevIRI);
    if (_plus != null) {
      _elvis = _plus;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final ScalarDataPropertyValue e) {
    String _elvis = null;
    DataRelationshipToScalar _scalarDataProperty = e.getScalarDataProperty();
    String _abbrevIRI = null;
    if (_scalarDataProperty!=null) {
      _abbrevIRI=_scalarDataProperty.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis = _abbrevIRI;
    } else {
      _elvis = "";
    }
    String _plus = (" . " + _elvis);
    String _plus_1 = (_plus + " = ");
    String _scalarPropertyValue = e.getScalarPropertyValue();
    return (_plus_1 + _scalarPropertyValue);
  }
  
  public String text(final ReifiedRelationshipInstanceDomain e) {
    String _elvis = null;
    String _elvis_1 = null;
    ReifiedRelationshipInstance _reifiedRelationshipInstance = e.getReifiedRelationshipInstance();
    String _abbrevIRI = null;
    if (_reifiedRelationshipInstance!=null) {
      _abbrevIRI=_reifiedRelationshipInstance.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus = ("domain(" + _elvis_1);
    String _plus_1 = (_plus + ") = ");
    ConceptualEntitySingletonInstance _domain = e.getDomain();
    String _abbrevIRI_1 = null;
    if (_domain!=null) {
      _abbrevIRI_1=_domain.abbrevIRI();
    }
    String _plus_2 = (_plus_1 + _abbrevIRI_1);
    if (_plus_2 != null) {
      _elvis = _plus_2;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final ReifiedRelationshipInstanceRange e) {
    String _elvis = null;
    String _elvis_1 = null;
    ReifiedRelationshipInstance _reifiedRelationshipInstance = e.getReifiedRelationshipInstance();
    String _abbrevIRI = null;
    if (_reifiedRelationshipInstance!=null) {
      _abbrevIRI=_reifiedRelationshipInstance.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus = ("range(" + _elvis_1);
    String _plus_1 = (_plus + ") = ");
    ConceptualEntitySingletonInstance _range = e.getRange();
    String _abbrevIRI_1 = null;
    if (_range!=null) {
      _abbrevIRI_1=_range.abbrevIRI();
    }
    String _plus_2 = (_plus_1 + _abbrevIRI_1);
    if (_plus_2 != null) {
      _elvis = _plus_2;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  public String text(final UnreifiedRelationshipInstanceTuple e) {
    String _elvis = null;
    String _elvis_1 = null;
    ConceptualEntitySingletonInstance _domain = e.getDomain();
    String _abbrevIRI = null;
    if (_domain!=null) {
      _abbrevIRI=_domain.abbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis_1 = _abbrevIRI;
    } else {
      _elvis_1 = "";
    }
    String _plus = ("tuple(" + _elvis_1);
    String _plus_1 = (_plus + " . ");
    String _elvis_2 = null;
    UnreifiedRelationship _unreifiedRelationship = e.getUnreifiedRelationship();
    String _abbrevIRI_1 = null;
    if (_unreifiedRelationship!=null) {
      _abbrevIRI_1=_unreifiedRelationship.abbrevIRI();
    }
    if (_abbrevIRI_1 != null) {
      _elvis_2 = _abbrevIRI_1;
    } else {
      _elvis_2 = "";
    }
    String _plus_2 = (_plus_1 + _elvis_2);
    String _plus_3 = (_plus_2 + " ) = ");
    ConceptualEntitySingletonInstance _range = e.getRange();
    String _abbrevIRI_2 = null;
    if (_range!=null) {
      _abbrevIRI_2=_range.abbrevIRI();
    }
    String _plus_4 = (_plus_3 + _abbrevIRI_2);
    if (_plus_4 != null) {
      _elvis = _plus_4;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
}
