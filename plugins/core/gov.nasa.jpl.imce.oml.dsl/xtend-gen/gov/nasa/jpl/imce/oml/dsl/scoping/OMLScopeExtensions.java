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
package gov.nasa.jpl.imce.oml.dsl.scoping;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import java.util.ArrayList;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class OMLScopeExtensions {
  @Inject
  @Extension
  private OMLExtensions _oMLExtensions;
  
  @Inject
  private IQualifiedNameConverter qnc;
  
  /**
   * The syntax of Annotation involves "@<annotation property abbrev IRI> = <annotation value>".
   * Therefore, construct the resolvable scope of AnnotationProperties
   * in terms of the abbrevIRI of each AnnotationProperty accessible from all imported modules.
   * 
   * This scope computation accounts for possible parsing errors resulting in EFeature values being null.
   */
  public IScope scope_Annotation_property(final AnnotationPropertyValue annotation, final EReference eRef) {
    IScope _xblockexpression = null;
    {
      LogicalElement _subject = annotation.getSubject();
      Module _moduleContext = null;
      if (_subject!=null) {
        _moduleContext=_subject.moduleContext();
      }
      Iterable<Module> _allImportedModules = null;
      if (_moduleContext!=null) {
        _allImportedModules=this._oMLExtensions.allImportedModules(_moduleContext);
      }
      Iterable<Module> _filterNull = null;
      if (_allImportedModules!=null) {
        _filterNull=IterableExtensions.<Module>filterNull(_allImportedModules);
      }
      final Iterable<Module> modules = _filterNull;
      final Function1<Module, EList<AnnotationProperty>> _function = (Module it) -> {
        return it.getAnnotationProperties();
      };
      Iterable<EList<AnnotationProperty>> _map = IterableExtensions.<Module, EList<AnnotationProperty>>map(modules, _function);
      Iterable<AnnotationProperty> _flatten = null;
      if (_map!=null) {
        _flatten=Iterables.<AnnotationProperty>concat(_map);
      }
      Iterable<AnnotationProperty> _filterNull_1 = null;
      if (_flatten!=null) {
        _filterNull_1=IterableExtensions.<AnnotationProperty>filterNull(_flatten);
      }
      final Iterable<AnnotationProperty> annoationProperties = _filterNull_1;
      final Function<AnnotationProperty, QualifiedName> _function_1 = (AnnotationProperty it) -> {
        return this.qnc.toQualifiedName(it.getAbbrevIRI());
      };
      _xblockexpression = Scopes.<AnnotationProperty>scopeFor(annoationProperties, _function_1, IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope scope_BundledTerminologyAxiom_bundledTerminology(final BundledTerminologyAxiom context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = (Extent it) -> {
        Iterable<TerminologyGraph> _terminologyGraphs = this._oMLExtensions.terminologyGraphs(it);
        Iterable<Bundle> _bundles = this._oMLExtensions.bundles(it);
        return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final Function<TerminologyBox, QualifiedName> _function_2 = (TerminologyBox it) -> {
        return this.qnc.toQualifiedName(it.nsPrefix());
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope scope_ConceptDesignationTerminologyAxiom_designatedTerminology(final ConceptDesignationTerminologyAxiom context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = (Extent it) -> {
        Iterable<TerminologyGraph> _terminologyGraphs = this._oMLExtensions.terminologyGraphs(it);
        Iterable<Bundle> _bundles = this._oMLExtensions.bundles(it);
        return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final Function<TerminologyBox, QualifiedName> _function_2 = (TerminologyBox it) -> {
        return this.qnc.toQualifiedName(it.nsPrefix());
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope scope_ConceptDesignationTerminologyAxiom_designatedConcept(final ConceptDesignationTerminologyAxiom context) {
    return this.allConceptsScope(context.getDesignatedTerminology());
  }
  
  public IScope allTerminologies(final TerminologyBox context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = (Extent it) -> {
        Iterable<TerminologyGraph> _terminologyGraphs = this._oMLExtensions.terminologyGraphs(it);
        Iterable<Bundle> _bundles = this._oMLExtensions.bundles(it);
        return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final Function<TerminologyBox, QualifiedName> _function_2 = (TerminologyBox it) -> {
        return this.qnc.toQualifiedName(it.nsPrefix());
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope allTerminologies(final DescriptionBox context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = (Extent it) -> {
        Iterable<TerminologyGraph> _terminologyGraphs = this._oMLExtensions.terminologyGraphs(it);
        Iterable<Bundle> _bundles = this._oMLExtensions.bundles(it);
        return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final Function<TerminologyBox, QualifiedName> _function_2 = (TerminologyBox it) -> {
        return this.qnc.toQualifiedName(it.nsPrefix());
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope allDescriptions(final DescriptionBox context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<DescriptionBox>> _function_1 = (Extent it) -> {
        return this._oMLExtensions.descriptions(it);
      };
      final Iterable<DescriptionBox> tboxes = Iterables.<DescriptionBox>concat(IterableExtensions.<Extent, Iterable<DescriptionBox>>map(exts, _function_1));
      final Function<DescriptionBox, QualifiedName> _function_2 = (DescriptionBox it) -> {
        return this.qnc.toQualifiedName(it.nsPrefix());
      };
      _xblockexpression = Scopes.<DescriptionBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  /**
   * Computes an IScope for
   */
  public <T extends LogicalElement> IScope terminologyScope(final TerminologyBox tbox, final Function<TerminologyBox, Iterable<T>> localScopeFunction, final Function<Pair<TerminologyBox, T>, QualifiedName> nameFunction) {
    SimpleScope _xblockexpression = null;
    {
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      Iterables.<IEObjectDescription>addAll(result, Scopes.scopedElementsFor(localScopeFunction.apply(tbox)));
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox importedTbox) -> {
        final Function<T, QualifiedName> _function_1 = (T importedThing) -> {
          return nameFunction.apply(Pair.<TerminologyBox, T>of(importedTbox, importedThing));
        };
        return Scopes.<T>scopedElementsFor(
          localScopeFunction.apply(importedTbox), _function_1);
      };
      Iterables.<IEObjectDescription>addAll(result, 
        Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(OMLExtensions.allImportedTerminologies(tbox), _function)));
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public <T extends gov.nasa.jpl.imce.oml.model.common.Resource> QualifiedName importedResourceNameFunction(final Pair<TerminologyBox, T> p) {
    String _nsPrefix = p.getKey().nsPrefix();
    String _plus = (_nsPrefix + ":");
    String _name = p.getValue().name();
    String _plus_1 = (_plus + _name);
    return this.qnc.toQualifiedName(_plus_1);
  }
  
  public <T extends gov.nasa.jpl.imce.oml.model.common.Resource> QualifiedName importedBundleNameFunction(final Pair<Bundle, T> p) {
    String _nsPrefix = p.getKey().nsPrefix();
    String _plus = (_nsPrefix + ":");
    String _name = p.getValue().name();
    String _plus_1 = (_plus + _name);
    return this.qnc.toQualifiedName(_plus_1);
  }
  
  public <T extends gov.nasa.jpl.imce.oml.model.common.Resource> QualifiedName importedDescriptionNameFunction(final Pair<DescriptionBox, T> p) {
    String _nsPrefix = p.getKey().nsPrefix();
    String _plus = (_nsPrefix + ":");
    String _name = p.getValue().name();
    String _plus_1 = (_plus + _name);
    return this.qnc.toQualifiedName(_plus_1);
  }
  
  public IScope allEntitiesScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Entity>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localEntities(it);
    };
    final Function<Pair<TerminologyBox, Entity>, QualifiedName> _function_1 = (Pair<TerminologyBox, Entity> it) -> {
      return this.<Entity>importedResourceNameFunction(it);
    };
    return this.<Entity>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allRangesScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<DataRange>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localRanges(it);
    };
    final Function<Pair<TerminologyBox, DataRange>, QualifiedName> _function_1 = (Pair<TerminologyBox, DataRange> it) -> {
      return this.<DataRange>importedResourceNameFunction(it);
    };
    return this.<DataRange>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allStructuresScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Structure>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localStructures(it);
    };
    final Function<Pair<TerminologyBox, Structure>, QualifiedName> _function_1 = (Pair<TerminologyBox, Structure> it) -> {
      return this.<Structure>importedResourceNameFunction(it);
    };
    return this.<Structure>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allAspectsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Aspect>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localAspects(it);
    };
    final Function<Pair<TerminologyBox, Aspect>, QualifiedName> _function_1 = (Pair<TerminologyBox, Aspect> it) -> {
      return this.<Aspect>importedResourceNameFunction(it);
    };
    return this.<Aspect>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allConceptsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Concept>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localConcepts(it);
    };
    final Function<Pair<TerminologyBox, Concept>, QualifiedName> _function_1 = (Pair<TerminologyBox, Concept> it) -> {
      return this.<Concept>importedResourceNameFunction(it);
    };
    return this.<Concept>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allReifiedRelationshipsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ReifiedRelationship>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localReifiedRelationships(it);
    };
    final Function<Pair<TerminologyBox, ReifiedRelationship>, QualifiedName> _function_1 = (Pair<TerminologyBox, ReifiedRelationship> it) -> {
      return this.<ReifiedRelationship>importedResourceNameFunction(it);
    };
    return this.<ReifiedRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allUnreifiedRelationshipsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<UnreifiedRelationship>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localUnreifiedRelationships(it);
    };
    final Function<Pair<TerminologyBox, UnreifiedRelationship>, QualifiedName> _function_1 = (Pair<TerminologyBox, UnreifiedRelationship> it) -> {
      return this.<UnreifiedRelationship>importedResourceNameFunction(it);
    };
    return this.<UnreifiedRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allEntityRelationshipsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<EntityRelationship>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localEntityRelationships(it);
    };
    final Function<Pair<TerminologyBox, EntityRelationship>, QualifiedName> _function_1 = (Pair<TerminologyBox, EntityRelationship> it) -> {
      return this.<EntityRelationship>importedResourceNameFunction(it);
    };
    return this.<EntityRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allEntityScalarDataPropertiesScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<EntityScalarDataProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localEntityScalarDataProperties(it);
    };
    final Function<Pair<TerminologyBox, EntityScalarDataProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, EntityScalarDataProperty> it) -> {
      return this.<EntityScalarDataProperty>importedResourceNameFunction(it);
    };
    return this.<EntityScalarDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allEntityStructuredDataPropertiesScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<EntityStructuredDataProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localEntityStructuredDataProperties(it);
    };
    final Function<Pair<TerminologyBox, EntityStructuredDataProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, EntityStructuredDataProperty> it) -> {
      return this.<EntityStructuredDataProperty>importedResourceNameFunction(it);
    };
    return this.<EntityStructuredDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allScalarDataPropertiesScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ScalarDataProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localScalarDataProperties(it);
    };
    final Function<Pair<TerminologyBox, ScalarDataProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, ScalarDataProperty> it) -> {
      return this.<ScalarDataProperty>importedResourceNameFunction(it);
    };
    return this.<ScalarDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allStructuredDataPropertiesScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<StructuredDataProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localStructuredDataProperties(it);
    };
    final Function<Pair<TerminologyBox, StructuredDataProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, StructuredDataProperty> it) -> {
      return this.<StructuredDataProperty>importedResourceNameFunction(it);
    };
    return this.<StructuredDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allScalarOneOfRestrictionsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ScalarOneOfRestriction>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localScalarOneOfRestrictions(it);
    };
    final Function<Pair<TerminologyBox, ScalarOneOfRestriction>, QualifiedName> _function_1 = (Pair<TerminologyBox, ScalarOneOfRestriction> it) -> {
      return this.<ScalarOneOfRestriction>importedResourceNameFunction(it);
    };
    return this.<ScalarOneOfRestriction>terminologyScope(tbox, _function, _function_1);
  }
  
  public <T extends LogicalElement> IScope bundleScope(final Bundle bundle, final Function<TerminologyBox, Iterable<T>> localScopeFunction, final Function<Pair<TerminologyBox, T>, QualifiedName> nameFunction) {
    SimpleScope _xblockexpression = null;
    {
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Set<Bundle> allBundles = Sets.<Bundle>newHashSet();
      allBundles.add(bundle);
      Iterables.<Bundle>addAll(allBundles, this._oMLExtensions.allImportedBundles(bundle));
      final Set<TerminologyBox> allTBoxes = Sets.<TerminologyBox>newHashSet();
      allTBoxes.addAll(allBundles);
      final Function1<Bundle, Iterable<TerminologyBox>> _function = (Bundle b) -> {
        return OMLExtensions.allImportedTerminologies(b);
      };
      Iterables.<TerminologyBox>addAll(allTBoxes, Iterables.<TerminologyBox>concat(IterableExtensions.<Bundle, Iterable<TerminologyBox>>map(allBundles, _function)));
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_1 = (TerminologyBox tbox) -> {
        final Function<T, QualifiedName> _function_2 = (T e) -> {
          return nameFunction.apply(Pair.<TerminologyBox, T>of(tbox, e));
        };
        return Scopes.<T>scopedElementsFor(
          localScopeFunction.apply(tbox), _function_2);
      };
      Iterables.<IEObjectDescription>addAll(result, 
        Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(allTBoxes, _function_1)));
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allConceptsScope(final Bundle b) {
    final Function<TerminologyBox, Iterable<Concept>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localConcepts(it);
    };
    final Function<Pair<TerminologyBox, Concept>, QualifiedName> _function_1 = (Pair<TerminologyBox, Concept> it) -> {
      return this.<Concept>importedResourceNameFunction(it);
    };
    return this.<Concept>bundleScope(b, _function, _function_1);
  }
  
  public <T extends LogicalElement> IScope descriptionScope(final DescriptionBox dbox, final Function<DescriptionBox, Iterable<T>> localScopeFunction, final Function<Pair<DescriptionBox, T>, QualifiedName> nameFunction) {
    SimpleScope _xblockexpression = null;
    {
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      Iterables.<IEObjectDescription>addAll(result, Scopes.scopedElementsFor(localScopeFunction.apply(dbox)));
      final Function1<DescriptionBox, Iterable<IEObjectDescription>> _function = (DescriptionBox importedDbox) -> {
        final Function<T, QualifiedName> _function_1 = (T importedThing) -> {
          return nameFunction.apply(Pair.<DescriptionBox, T>of(importedDbox, importedThing));
        };
        return Scopes.<T>scopedElementsFor(
          localScopeFunction.apply(importedDbox), _function_1);
      };
      Iterables.<IEObjectDescription>addAll(result, 
        Iterables.<IEObjectDescription>concat(IterableExtensions.<DescriptionBox, Iterable<IEObjectDescription>>map(this._oMLExtensions.allImportedDescriptions(dbox), _function)));
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allConceptualEntitySingletonInstanceScope(final DescriptionBox dbox) {
    final Function<DescriptionBox, Iterable<ConceptualEntitySingletonInstance>> _function = (DescriptionBox it) -> {
      return this._oMLExtensions.localConceptualEntitySingletonInstances(it);
    };
    final Function<Pair<DescriptionBox, ConceptualEntitySingletonInstance>, QualifiedName> _function_1 = (Pair<DescriptionBox, ConceptualEntitySingletonInstance> it) -> {
      return this.<ConceptualEntitySingletonInstance>importedDescriptionNameFunction(it);
    };
    return this.<ConceptualEntitySingletonInstance>descriptionScope(dbox, _function, _function_1);
  }
  
  public IScope allReifiedRelationshipInstancesScope(final DescriptionBox dbox) {
    final Function<DescriptionBox, Iterable<ReifiedRelationshipInstance>> _function = (DescriptionBox it) -> {
      return this._oMLExtensions.localReifiedRelationshipInstances(it);
    };
    final Function<Pair<DescriptionBox, ReifiedRelationshipInstance>, QualifiedName> _function_1 = (Pair<DescriptionBox, ReifiedRelationshipInstance> it) -> {
      return this.<ReifiedRelationshipInstance>importedDescriptionNameFunction(it);
    };
    return this.<ReifiedRelationshipInstance>descriptionScope(dbox, _function, _function_1);
  }
  
  public IScope allEntityStructuredDataPropertiesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      final Iterable<TerminologyBox> tboxes = this._oMLExtensions.allImportedTerminologiesFromDescription(dbox);
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox tbox) -> {
        final Function<EntityStructuredDataProperty, QualifiedName> _function_1 = (EntityStructuredDataProperty importedThing) -> {
          return this.<EntityStructuredDataProperty>importedResourceNameFunction(Pair.<TerminologyBox, EntityStructuredDataProperty>of(tbox, importedThing));
        };
        return Scopes.<EntityStructuredDataProperty>scopedElementsFor(
          this._oMLExtensions.localEntityStructuredDataProperties(tbox), _function_1);
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allEntityScalarDataPropertiesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      final Iterable<TerminologyBox> tboxes = this._oMLExtensions.allImportedTerminologiesFromDescription(dbox);
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox tbox) -> {
        final Function<EntityScalarDataProperty, QualifiedName> _function_1 = (EntityScalarDataProperty importedThing) -> {
          return this.<EntityScalarDataProperty>importedResourceNameFunction(Pair.<TerminologyBox, EntityScalarDataProperty>of(tbox, importedThing));
        };
        return Scopes.<EntityScalarDataProperty>scopedElementsFor(
          this._oMLExtensions.localEntityScalarDataProperties(tbox), _function_1);
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allStructuredDataPropertiesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      final Iterable<TerminologyBox> tboxes = this._oMLExtensions.allImportedTerminologiesFromDescription(dbox);
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox tbox) -> {
        final Function<StructuredDataProperty, QualifiedName> _function_1 = (StructuredDataProperty importedThing) -> {
          return this.<StructuredDataProperty>importedResourceNameFunction(Pair.<TerminologyBox, StructuredDataProperty>of(tbox, importedThing));
        };
        return Scopes.<StructuredDataProperty>scopedElementsFor(
          this._oMLExtensions.localStructuredDataProperties(tbox), _function_1);
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allScalarDataPropertiesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      final Iterable<TerminologyBox> tboxes = this._oMLExtensions.allImportedTerminologiesFromDescription(dbox);
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox tbox) -> {
        final Function<ScalarDataProperty, QualifiedName> _function_1 = (ScalarDataProperty importedThing) -> {
          return this.<ScalarDataProperty>importedResourceNameFunction(Pair.<TerminologyBox, ScalarDataProperty>of(tbox, importedThing));
        };
        return Scopes.<ScalarDataProperty>scopedElementsFor(
          this._oMLExtensions.localScalarDataProperties(tbox), _function_1);
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allConceptsScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      final Iterable<TerminologyBox> tboxes = this._oMLExtensions.allImportedTerminologiesFromDescription(dbox);
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox tbox) -> {
        final Function<Concept, QualifiedName> _function_1 = (Concept importedThing) -> {
          return this.<Concept>importedResourceNameFunction(Pair.<TerminologyBox, Concept>of(tbox, importedThing));
        };
        return Scopes.<Concept>scopedElementsFor(
          this._oMLExtensions.localConcepts(tbox), _function_1);
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allReifiedRelationshipScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      final Iterable<TerminologyBox> tboxes = this._oMLExtensions.allImportedTerminologiesFromDescription(dbox);
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox tbox) -> {
        final Function<ReifiedRelationship, QualifiedName> _function_1 = (ReifiedRelationship importedThing) -> {
          return this.<ReifiedRelationship>importedResourceNameFunction(Pair.<TerminologyBox, ReifiedRelationship>of(tbox, importedThing));
        };
        return Scopes.<ReifiedRelationship>scopedElementsFor(
          this._oMLExtensions.localReifiedRelationships(tbox), _function_1);
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allUnreifiedRelationshipScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      final Iterable<TerminologyBox> tboxes = this._oMLExtensions.allImportedTerminologiesFromDescription(dbox);
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox tbox) -> {
        final Function<UnreifiedRelationship, QualifiedName> _function_1 = (UnreifiedRelationship importedThing) -> {
          return this.<UnreifiedRelationship>importedResourceNameFunction(Pair.<TerminologyBox, UnreifiedRelationship>of(tbox, importedThing));
        };
        return Scopes.<UnreifiedRelationship>scopedElementsFor(
          this._oMLExtensions.localUnreifiedRelationships(tbox), _function_1);
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
}
