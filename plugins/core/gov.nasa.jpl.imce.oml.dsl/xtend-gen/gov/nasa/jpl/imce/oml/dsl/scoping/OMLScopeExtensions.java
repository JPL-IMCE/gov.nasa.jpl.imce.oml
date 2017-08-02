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
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Extent;
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
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
      Element _subject = annotation.getSubject();
      Module _moduleContext = null;
      if (_subject!=null) {
        _moduleContext=_subject.moduleContext();
      }
      Iterable<Module> _allImportedModules = null;
      if (_moduleContext!=null) {
        _allImportedModules=this._oMLExtensions.allImportedModules(_moduleContext);
      }
      Iterable<Extent> _map = null;
      if (_allImportedModules!=null) {
        final Function1<Module, Extent> _function = (Module it) -> {
          return it.getExtent();
        };
        _map=IterableExtensions.<Module, Extent>map(_allImportedModules, _function);
      }
      Iterable<Extent> _filterNull = null;
      if (_map!=null) {
        _filterNull=IterableExtensions.<Extent>filterNull(_map);
      }
      final Iterable<Extent> extents = _filterNull;
      final Function1<Extent, EList<AnnotationProperty>> _function_1 = (Extent it) -> {
        return it.getAnnotationProperties();
      };
      Iterable<EList<AnnotationProperty>> _map_1 = IterableExtensions.<Extent, EList<AnnotationProperty>>map(extents, _function_1);
      Iterable<AnnotationProperty> _flatten = null;
      if (_map_1!=null) {
        _flatten=Iterables.<AnnotationProperty>concat(_map_1);
      }
      Iterable<AnnotationProperty> _filterNull_1 = null;
      if (_flatten!=null) {
        _filterNull_1=IterableExtensions.<AnnotationProperty>filterNull(_flatten);
      }
      final Iterable<AnnotationProperty> annoationProperties = _filterNull_1;
      final Function<AnnotationProperty, QualifiedName> _function_2 = (AnnotationProperty it) -> {
        String _abbrevIRI = it.getAbbrevIRI();
        return this.qnc.toQualifiedName(_abbrevIRI);
      };
      _xblockexpression = Scopes.<AnnotationProperty>scopeFor(annoationProperties, _function_2, IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope scope_BundledTerminologyAxiom_bundledTerminology(final BundledTerminologyAxiom context) {
    IScope _xblockexpression = null;
    {
      Resource _eResource = context.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      EList<Resource> _resources = _resourceSet.getResources();
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        EList<EObject> _contents = it.getContents();
        return Iterables.<Extent>filter(_contents, Extent.class);
      };
      List<Iterable<Extent>> _map = ListExtensions.<Resource, Iterable<Extent>>map(_resources, _function);
      final Iterable<Extent> exts = Iterables.<Extent>concat(_map);
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = (Extent it) -> {
        Iterable<TerminologyGraph> _terminologyGraphs = this._oMLExtensions.terminologyGraphs(it);
        Iterable<Bundle> _bundles = this._oMLExtensions.bundles(it);
        return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
      };
      Iterable<Iterable<TerminologyBox>> _map_1 = IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1);
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(_map_1);
      final Function<TerminologyBox, QualifiedName> _function_2 = (TerminologyBox it) -> {
        String _nsPrefix = it.nsPrefix();
        return this.qnc.toQualifiedName(_nsPrefix);
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope scope_ConceptDesignationTerminologyAxiom_designatedTerminology(final ConceptDesignationTerminologyAxiom context) {
    IScope _xblockexpression = null;
    {
      Resource _eResource = context.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      EList<Resource> _resources = _resourceSet.getResources();
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        EList<EObject> _contents = it.getContents();
        return Iterables.<Extent>filter(_contents, Extent.class);
      };
      List<Iterable<Extent>> _map = ListExtensions.<Resource, Iterable<Extent>>map(_resources, _function);
      final Iterable<Extent> exts = Iterables.<Extent>concat(_map);
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = (Extent it) -> {
        Iterable<TerminologyGraph> _terminologyGraphs = this._oMLExtensions.terminologyGraphs(it);
        Iterable<Bundle> _bundles = this._oMLExtensions.bundles(it);
        return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
      };
      Iterable<Iterable<TerminologyBox>> _map_1 = IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1);
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(_map_1);
      final Function<TerminologyBox, QualifiedName> _function_2 = (TerminologyBox it) -> {
        String _nsPrefix = it.nsPrefix();
        return this.qnc.toQualifiedName(_nsPrefix);
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope scope_ConceptDesignationTerminologyAxiom_designatedConcept(final ConceptDesignationTerminologyAxiom context) {
    TerminologyBox _designatedTerminology = context.getDesignatedTerminology();
    return this.allConceptsScope(_designatedTerminology);
  }
  
  public IScope allTerminologies(final TerminologyBox context) {
    IScope _xblockexpression = null;
    {
      Resource _eResource = context.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      EList<Resource> _resources = _resourceSet.getResources();
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        EList<EObject> _contents = it.getContents();
        return Iterables.<Extent>filter(_contents, Extent.class);
      };
      List<Iterable<Extent>> _map = ListExtensions.<Resource, Iterable<Extent>>map(_resources, _function);
      final Iterable<Extent> exts = Iterables.<Extent>concat(_map);
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = (Extent it) -> {
        Iterable<TerminologyGraph> _terminologyGraphs = this._oMLExtensions.terminologyGraphs(it);
        Iterable<Bundle> _bundles = this._oMLExtensions.bundles(it);
        return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
      };
      Iterable<Iterable<TerminologyBox>> _map_1 = IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1);
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(_map_1);
      final Function<TerminologyBox, QualifiedName> _function_2 = (TerminologyBox it) -> {
        String _nsPrefix = it.nsPrefix();
        return this.qnc.toQualifiedName(_nsPrefix);
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope allTerminologies(final DescriptionBox context) {
    IScope _xblockexpression = null;
    {
      Resource _eResource = context.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      EList<Resource> _resources = _resourceSet.getResources();
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        EList<EObject> _contents = it.getContents();
        return Iterables.<Extent>filter(_contents, Extent.class);
      };
      List<Iterable<Extent>> _map = ListExtensions.<Resource, Iterable<Extent>>map(_resources, _function);
      final Iterable<Extent> exts = Iterables.<Extent>concat(_map);
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = (Extent it) -> {
        Iterable<TerminologyGraph> _terminologyGraphs = this._oMLExtensions.terminologyGraphs(it);
        Iterable<Bundle> _bundles = this._oMLExtensions.bundles(it);
        return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
      };
      Iterable<Iterable<TerminologyBox>> _map_1 = IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1);
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(_map_1);
      final Function<TerminologyBox, QualifiedName> _function_2 = (TerminologyBox it) -> {
        String _nsPrefix = it.nsPrefix();
        return this.qnc.toQualifiedName(_nsPrefix);
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope allDescriptions(final DescriptionBox context) {
    IScope _xblockexpression = null;
    {
      Resource _eResource = context.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      EList<Resource> _resources = _resourceSet.getResources();
      final Function1<Resource, Iterable<Extent>> _function = (Resource it) -> {
        EList<EObject> _contents = it.getContents();
        return Iterables.<Extent>filter(_contents, Extent.class);
      };
      List<Iterable<Extent>> _map = ListExtensions.<Resource, Iterable<Extent>>map(_resources, _function);
      final Iterable<Extent> exts = Iterables.<Extent>concat(_map);
      final Function1<Extent, Iterable<DescriptionBox>> _function_1 = (Extent it) -> {
        return this._oMLExtensions.descriptions(it);
      };
      Iterable<Iterable<DescriptionBox>> _map_1 = IterableExtensions.<Extent, Iterable<DescriptionBox>>map(exts, _function_1);
      final Iterable<DescriptionBox> tboxes = Iterables.<DescriptionBox>concat(_map_1);
      final Function<DescriptionBox, QualifiedName> _function_2 = (DescriptionBox it) -> {
        String _nsPrefix = it.nsPrefix();
        return this.qnc.toQualifiedName(_nsPrefix);
      };
      _xblockexpression = Scopes.<DescriptionBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  /**
   * Computes an IScope for
   */
  public <T extends Element> IScope terminologyScope(final TerminologyBox tbox, final Function<TerminologyBox, Iterable<T>> localScopeFunction, final Function<Pair<TerminologyBox, T>, QualifiedName> nameFunction) {
    SimpleScope _xblockexpression = null;
    {
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      Iterable<T> _apply = localScopeFunction.apply(tbox);
      Iterable<IEObjectDescription> _scopedElementsFor = Scopes.scopedElementsFor(_apply);
      Iterables.<IEObjectDescription>addAll(result, _scopedElementsFor);
      Iterable<TerminologyBox> _allImportedTerminologies = this._oMLExtensions.allImportedTerminologies(tbox);
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox importedTbox) -> {
        Iterable<T> _apply_1 = localScopeFunction.apply(importedTbox);
        final Function<T, QualifiedName> _function_1 = (T importedThing) -> {
          Pair<TerminologyBox, T> _of = Pair.<TerminologyBox, T>of(importedTbox, importedThing);
          return nameFunction.apply(_of);
        };
        return Scopes.<T>scopedElementsFor(_apply_1, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(_allImportedTerminologies, _function);
      Iterable<IEObjectDescription> _flatten = Iterables.<IEObjectDescription>concat(_map);
      Iterables.<IEObjectDescription>addAll(result, _flatten);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public <T extends gov.nasa.jpl.imce.oml.model.common.Resource> QualifiedName importedResourceNameFunction(final Pair<TerminologyBox, T> p) {
    TerminologyBox _key = p.getKey();
    String _nsPrefix = _key.nsPrefix();
    String _plus = (_nsPrefix + ":");
    T _value = p.getValue();
    String _name = _value.name();
    String _plus_1 = (_plus + _name);
    return this.qnc.toQualifiedName(_plus_1);
  }
  
  public <T extends gov.nasa.jpl.imce.oml.model.common.Resource> QualifiedName importedBundleNameFunction(final Pair<Bundle, T> p) {
    Bundle _key = p.getKey();
    String _nsPrefix = _key.nsPrefix();
    String _plus = (_nsPrefix + ":");
    T _value = p.getValue();
    String _name = _value.name();
    String _plus_1 = (_plus + _name);
    return this.qnc.toQualifiedName(_plus_1);
  }
  
  public <T extends gov.nasa.jpl.imce.oml.model.common.Resource> QualifiedName importedDescriptionNameFunction(final Pair<DescriptionBox, T> p) {
    DescriptionBox _key = p.getKey();
    String _nsPrefix = _key.nsPrefix();
    String _plus = (_nsPrefix + ":");
    T _value = p.getValue();
    String _name = _value.name();
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
  
  public <T extends Element> IScope bundleScope(final Bundle bundle, final Function<TerminologyBox, Iterable<T>> localScopeFunction, final Function<Pair<TerminologyBox, T>, QualifiedName> nameFunction) {
    SimpleScope _xblockexpression = null;
    {
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Set<Bundle> allBundles = Sets.<Bundle>newHashSet();
      allBundles.add(bundle);
      Iterable<Bundle> _allImportedBundles = this._oMLExtensions.allImportedBundles(bundle);
      Iterables.<Bundle>addAll(allBundles, _allImportedBundles);
      final Set<TerminologyBox> allTBoxes = Sets.<TerminologyBox>newHashSet();
      allTBoxes.addAll(allBundles);
      final Function1<Bundle, Iterable<TerminologyBox>> _function = (Bundle it) -> {
        return this._oMLExtensions.allImportedTerminologies(it);
      };
      Iterable<Iterable<TerminologyBox>> _map = IterableExtensions.<Bundle, Iterable<TerminologyBox>>map(allBundles, _function);
      Iterable<TerminologyBox> _flatten = Iterables.<TerminologyBox>concat(_map);
      Iterables.<TerminologyBox>addAll(allTBoxes, _flatten);
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_1 = (TerminologyBox tbox) -> {
        Iterable<T> _apply = localScopeFunction.apply(tbox);
        final Function<T, QualifiedName> _function_2 = (T e) -> {
          Pair<TerminologyBox, T> _of = Pair.<TerminologyBox, T>of(tbox, e);
          return nameFunction.apply(_of);
        };
        return Scopes.<T>scopedElementsFor(_apply, _function_2);
      };
      Iterable<Iterable<IEObjectDescription>> _map_1 = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(allTBoxes, _function_1);
      Iterable<IEObjectDescription> _flatten_1 = Iterables.<IEObjectDescription>concat(_map_1);
      Iterables.<IEObjectDescription>addAll(result, _flatten_1);
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
  
  public <T extends Element> IScope descriptionScope(final DescriptionBox dbox, final Function<DescriptionBox, Iterable<T>> localScopeFunction, final Function<Pair<DescriptionBox, T>, QualifiedName> nameFunction) {
    SimpleScope _xblockexpression = null;
    {
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      Iterable<T> _apply = localScopeFunction.apply(dbox);
      Iterable<IEObjectDescription> _scopedElementsFor = Scopes.scopedElementsFor(_apply);
      Iterables.<IEObjectDescription>addAll(result, _scopedElementsFor);
      Iterable<DescriptionBox> _allImportedDescriptions = this._oMLExtensions.allImportedDescriptions(dbox);
      final Function1<DescriptionBox, Iterable<IEObjectDescription>> _function = (DescriptionBox importedDbox) -> {
        Iterable<T> _apply_1 = localScopeFunction.apply(importedDbox);
        final Function<T, QualifiedName> _function_1 = (T importedThing) -> {
          Pair<DescriptionBox, T> _of = Pair.<DescriptionBox, T>of(importedDbox, importedThing);
          return nameFunction.apply(_of);
        };
        return Scopes.<T>scopedElementsFor(_apply_1, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<DescriptionBox, Iterable<IEObjectDescription>>map(_allImportedDescriptions, _function);
      Iterable<IEObjectDescription> _flatten = Iterables.<IEObjectDescription>concat(_map);
      Iterables.<IEObjectDescription>addAll(result, _flatten);
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
        Iterable<EntityStructuredDataProperty> _localEntityStructuredDataProperties = this._oMLExtensions.localEntityStructuredDataProperties(tbox);
        final Function<EntityStructuredDataProperty, QualifiedName> _function_1 = (EntityStructuredDataProperty importedThing) -> {
          Pair<TerminologyBox, EntityStructuredDataProperty> _of = Pair.<TerminologyBox, EntityStructuredDataProperty>of(tbox, importedThing);
          return this.<EntityStructuredDataProperty>importedResourceNameFunction(_of);
        };
        return Scopes.<EntityStructuredDataProperty>scopedElementsFor(_localEntityStructuredDataProperties, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function);
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(_map);
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
        Iterable<EntityScalarDataProperty> _localEntityScalarDataProperties = this._oMLExtensions.localEntityScalarDataProperties(tbox);
        final Function<EntityScalarDataProperty, QualifiedName> _function_1 = (EntityScalarDataProperty importedThing) -> {
          Pair<TerminologyBox, EntityScalarDataProperty> _of = Pair.<TerminologyBox, EntityScalarDataProperty>of(tbox, importedThing);
          return this.<EntityScalarDataProperty>importedResourceNameFunction(_of);
        };
        return Scopes.<EntityScalarDataProperty>scopedElementsFor(_localEntityScalarDataProperties, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function);
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(_map);
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
        Iterable<StructuredDataProperty> _localStructuredDataProperties = this._oMLExtensions.localStructuredDataProperties(tbox);
        final Function<StructuredDataProperty, QualifiedName> _function_1 = (StructuredDataProperty importedThing) -> {
          Pair<TerminologyBox, StructuredDataProperty> _of = Pair.<TerminologyBox, StructuredDataProperty>of(tbox, importedThing);
          return this.<StructuredDataProperty>importedResourceNameFunction(_of);
        };
        return Scopes.<StructuredDataProperty>scopedElementsFor(_localStructuredDataProperties, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function);
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(_map);
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
        Iterable<ScalarDataProperty> _localScalarDataProperties = this._oMLExtensions.localScalarDataProperties(tbox);
        final Function<ScalarDataProperty, QualifiedName> _function_1 = (ScalarDataProperty importedThing) -> {
          Pair<TerminologyBox, ScalarDataProperty> _of = Pair.<TerminologyBox, ScalarDataProperty>of(tbox, importedThing);
          return this.<ScalarDataProperty>importedResourceNameFunction(_of);
        };
        return Scopes.<ScalarDataProperty>scopedElementsFor(_localScalarDataProperties, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function);
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(_map);
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
        Iterable<Concept> _localConcepts = this._oMLExtensions.localConcepts(tbox);
        final Function<Concept, QualifiedName> _function_1 = (Concept importedThing) -> {
          Pair<TerminologyBox, Concept> _of = Pair.<TerminologyBox, Concept>of(tbox, importedThing);
          return this.<Concept>importedResourceNameFunction(_of);
        };
        return Scopes.<Concept>scopedElementsFor(_localConcepts, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function);
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(_map);
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
        Iterable<ReifiedRelationship> _localReifiedRelationships = this._oMLExtensions.localReifiedRelationships(tbox);
        final Function<ReifiedRelationship, QualifiedName> _function_1 = (ReifiedRelationship importedThing) -> {
          Pair<TerminologyBox, ReifiedRelationship> _of = Pair.<TerminologyBox, ReifiedRelationship>of(tbox, importedThing);
          return this.<ReifiedRelationship>importedResourceNameFunction(_of);
        };
        return Scopes.<ReifiedRelationship>scopedElementsFor(_localReifiedRelationships, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function);
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(_map);
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
        Iterable<UnreifiedRelationship> _localUnreifiedRelationships = this._oMLExtensions.localUnreifiedRelationships(tbox);
        final Function<UnreifiedRelationship, QualifiedName> _function_1 = (UnreifiedRelationship importedThing) -> {
          Pair<TerminologyBox, UnreifiedRelationship> _of = Pair.<TerminologyBox, UnreifiedRelationship>of(tbox, importedThing);
          return this.<UnreifiedRelationship>importedResourceNameFunction(_of);
        };
        return Scopes.<UnreifiedRelationship>scopedElementsFor(_localUnreifiedRelationships, _function_1);
      };
      Iterable<Iterable<IEObjectDescription>> _map = IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function);
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(_map);
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
}
