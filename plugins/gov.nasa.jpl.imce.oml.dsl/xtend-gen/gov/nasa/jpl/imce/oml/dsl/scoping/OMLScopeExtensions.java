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
import gov.nasa.jpl.imce.oml.model.common.Resource;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectKind;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptKind;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.Predicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
  
  private final static String RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE = "RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE";
  
  private final static String RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE = "RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE";
  
  public static void clearCache(final ResourceSet rs) {
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE);
    rs.getLoadOptions().remove(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE);
  }
  
  public static void initializeCache(final ResourceSet rs) {
    Map<Object, Object> _loadOptions = rs.getLoadOptions();
    HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> _hashMap = new HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>>();
    _loadOptions.put(OMLScopeExtensions.RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE, _hashMap);
    Map<Object, Object> _loadOptions_1 = rs.getLoadOptions();
    HashMap<gov.nasa.jpl.imce.oml.model.common.Module, IScope> _hashMap_1 = new HashMap<gov.nasa.jpl.imce.oml.model.common.Module, IScope>();
    _loadOptions_1.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE, _hashMap_1);
    Map<Object, Object> _loadOptions_2 = rs.getLoadOptions();
    HashMap<DescriptionBox, IScope> _hashMap_2 = new HashMap<DescriptionBox, IScope>();
    _loadOptions_2.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE, _hashMap_2);
    Map<Object, Object> _loadOptions_3 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_3 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_3.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE, _hashMap_3);
    Map<Object, Object> _loadOptions_4 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_4 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_4.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE, _hashMap_4);
    Map<Object, Object> _loadOptions_5 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_5 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_5.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE, _hashMap_5);
    Map<Object, Object> _loadOptions_6 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_6 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_6.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE, _hashMap_6);
    Map<Object, Object> _loadOptions_7 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_7 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_7.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE, _hashMap_7);
    Map<Object, Object> _loadOptions_8 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_8 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_8.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE, _hashMap_8);
    Map<Object, Object> _loadOptions_9 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_9 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_9.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE, _hashMap_9);
    Map<Object, Object> _loadOptions_10 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_10 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_10.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE, _hashMap_10);
    Map<Object, Object> _loadOptions_11 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_11 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_11.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE, _hashMap_11);
    Map<Object, Object> _loadOptions_12 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_12 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_12.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE, _hashMap_12);
    Map<Object, Object> _loadOptions_13 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_13 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_13.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE, _hashMap_13);
    Map<Object, Object> _loadOptions_14 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_14 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_14.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE, _hashMap_14);
    Map<Object, Object> _loadOptions_15 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_15 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_15.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE, _hashMap_15);
    Map<Object, Object> _loadOptions_16 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_16 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_16.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE, _hashMap_16);
    Map<Object, Object> _loadOptions_17 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_17 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_17.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE, _hashMap_17);
    Map<Object, Object> _loadOptions_18 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_18 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_18.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE, _hashMap_18);
    Map<Object, Object> _loadOptions_19 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_19 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_19.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE, _hashMap_19);
    Map<Object, Object> _loadOptions_20 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_20 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_20.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE, _hashMap_20);
    Map<Object, Object> _loadOptions_21 = rs.getLoadOptions();
    HashMap<TerminologyBox, IScope> _hashMap_21 = new HashMap<TerminologyBox, IScope>();
    _loadOptions_21.put(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE, _hashMap_21);
  }
  
  public static HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> lookupImportedResourceNameCache(final ResourceSet rs) {
    HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> _xblockexpression = null;
    {
      final Object cache = rs.getLoadOptions().get(OMLScopeExtensions.RESOURCE_SET_OML_IMPORTED_RESOURCE_NAME_CACHE);
      HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> lookupImportedResourceNameCache(final EObject e) {
    HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (e!=null) {
        _eResource=e.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      final ResourceSet rs = _resourceSet;
      HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> _xifexpression = null;
      if ((null != rs)) {
        _xifexpression = OMLScopeExtensions.lookupImportedResourceNameCache(rs);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static HashMap<gov.nasa.jpl.imce.oml.model.common.Module, IScope> lookupAllTerminologiesCache(final gov.nasa.jpl.imce.oml.model.common.Module m) {
    HashMap<gov.nasa.jpl.imce.oml.model.common.Module, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (m!=null) {
        _eResource=m.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_TERMINOLOGIES_CACHE);
      }
      final Object cache = _get;
      HashMap<gov.nasa.jpl.imce.oml.model.common.Module, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<gov.nasa.jpl.imce.oml.model.common.Module, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<DescriptionBox, IScope> lookupAllDescriptionsCache(final DescriptionBox m) {
    HashMap<DescriptionBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (m!=null) {
        _eResource=m.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_DESCRIPTIONS_CACHE);
      }
      final Object cache = _get;
      HashMap<DescriptionBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<DescriptionBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllEntitiesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITIES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllRangesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RANGES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllStructuresCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllAspectsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ASPECTS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllConceptsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllConceptualRelationshipsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_CONCEPTUAL_RELATIONSHIPS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllReifiedRelationshipRestrictionsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIP_RESTRICTIONS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllReifiedRelationshipsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_REIFIED_RELATIONSHIPS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllUnreifiedRelationshipsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_UNREIFIED_RELATIONSHIPS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllEntityRelationshipsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_RELATIONSHIPS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllPredicatesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_PREDICATES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllForwardPropertiesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_FORWARD_PROPERTIES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllInversePropertiesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_INVERSE_PROPERTIES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllRestrictableRelationshipsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_RESTRICTABLE_RELATIONSHIPS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllEntityScalarDataPropertiesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_SCALAR_DATA_PROPERTIES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllEntityStructuredDataPropertiesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_ENTITY_STRUCTURED_DATA_PROPERTIES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllScalarDataPropertiesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_DATA_PROPERTIES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllStructuredDataPropertiesCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_STRUCTURED_DATA_PROPERTIES_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<TerminologyBox, IScope> lookupAllScalarOneOfRestrictionsCache(final TerminologyBox tbox) {
    HashMap<TerminologyBox, IScope> _xblockexpression = null;
    {
      org.eclipse.emf.ecore.resource.Resource _eResource = null;
      if (tbox!=null) {
        _eResource=tbox.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      Map<Object, Object> _loadOptions = null;
      if (_resourceSet!=null) {
        _loadOptions=_resourceSet.getLoadOptions();
      }
      Object _get = null;
      if (_loadOptions!=null) {
        _get=_loadOptions.get(OMLScopeExtensions.RESOURCE_SET_OML_SCOPE_EXTENSIONS_ALL_SCALAR_ONE_OF_RESTRICTIONS_CACHE);
      }
      final Object cache = _get;
      HashMap<TerminologyBox, IScope> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<TerminologyBox, IScope>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
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
      gov.nasa.jpl.imce.oml.model.common.Module _moduleContext = null;
      if (_subject!=null) {
        _moduleContext=_subject.moduleContext();
      }
      Iterable<gov.nasa.jpl.imce.oml.model.common.Module> _allImportedModules = null;
      if (_moduleContext!=null) {
        _allImportedModules=this._oMLExtensions.allImportedModules(_moduleContext);
      }
      Iterable<gov.nasa.jpl.imce.oml.model.common.Module> _filterNull = null;
      if (_allImportedModules!=null) {
        _filterNull=IterableExtensions.<gov.nasa.jpl.imce.oml.model.common.Module>filterNull(_allImportedModules);
      }
      final Iterable<gov.nasa.jpl.imce.oml.model.common.Module> modules = _filterNull;
      final Function1<gov.nasa.jpl.imce.oml.model.common.Module, EList<AnnotationProperty>> _function = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
        return it.getAnnotationProperties();
      };
      Iterable<EList<AnnotationProperty>> _map = IterableExtensions.<gov.nasa.jpl.imce.oml.model.common.Module, EList<AnnotationProperty>>map(modules, _function);
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
      final Function1<org.eclipse.emf.ecore.resource.Resource, Iterable<Extent>> _function = (org.eclipse.emf.ecore.resource.Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<org.eclipse.emf.ecore.resource.Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
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
      final Function1<org.eclipse.emf.ecore.resource.Resource, Iterable<Extent>> _function = (org.eclipse.emf.ecore.resource.Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<org.eclipse.emf.ecore.resource.Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
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
      final HashMap<gov.nasa.jpl.imce.oml.model.common.Module, IScope> cache = OMLScopeExtensions.lookupAllTerminologiesCache(context);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<gov.nasa.jpl.imce.oml.model.common.Module, IScope> _function = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
          return this.computeAllTerminologies(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(context, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllTerminologies = this.computeAllTerminologies(context);
        _elvis = _computeAllTerminologies;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  public IScope allTerminologies(final DescriptionBox context) {
    IScope _xblockexpression = null;
    {
      final HashMap<gov.nasa.jpl.imce.oml.model.common.Module, IScope> cache = OMLScopeExtensions.lookupAllTerminologiesCache(context);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<gov.nasa.jpl.imce.oml.model.common.Module, IScope> _function = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
          return this.computeAllTerminologies(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(context, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllTerminologies = this.computeAllTerminologies(context);
        _elvis = _computeAllTerminologies;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllTerminologies(final gov.nasa.jpl.imce.oml.model.common.Module context) {
    IScope _xblockexpression = null;
    {
      final Function1<org.eclipse.emf.ecore.resource.Resource, Iterable<Extent>> _function = (org.eclipse.emf.ecore.resource.Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<org.eclipse.emf.ecore.resource.Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
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
      final HashMap<DescriptionBox, IScope> cache = OMLScopeExtensions.lookupAllDescriptionsCache(context);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<DescriptionBox, IScope> _function = (DescriptionBox it) -> {
          return this.computeAllDescriptions(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(context, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllDescriptions = this.computeAllDescriptions(context);
        _elvis = _computeAllDescriptions;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllDescriptions(final DescriptionBox context) {
    IScope _xblockexpression = null;
    {
      final Function1<org.eclipse.emf.ecore.resource.Resource, Iterable<Extent>> _function = (org.eclipse.emf.ecore.resource.Resource it) -> {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<org.eclipse.emf.ecore.resource.Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
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
  
  /**
   * This method can be invoked very often for large models.
   * To enable read-only cache optimization, invoke OMLLinkingService.initializeCache(ResourceSet)
   */
  public <T extends Resource> QualifiedName importedResourceNameFunction(final Pair<TerminologyBox, T> p) {
    QualifiedName _xblockexpression = null;
    {
      final HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> importedResourceNameCache = OMLScopeExtensions.lookupImportedResourceNameCache(p.getKey());
      QualifiedName _xifexpression = null;
      if ((null != importedResourceNameCache)) {
        QualifiedName _xblockexpression_1 = null;
        {
          final java.util.function.Function<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> _function = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
            return new HashMap<Resource, QualifiedName>();
          };
          final HashMap<Resource, QualifiedName> nameMap = importedResourceNameCache.computeIfAbsent(p.getKey(), _function);
          final java.util.function.Function<Resource, QualifiedName> _function_1 = (Resource it) -> {
            String _nsPrefix = p.getKey().nsPrefix();
            String _plus = (_nsPrefix + ":");
            String _name = p.getValue().name();
            String _plus_1 = (_plus + _name);
            return this.qnc.toQualifiedName(_plus_1);
          };
          _xblockexpression_1 = nameMap.computeIfAbsent(p.getValue(), _function_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _nsPrefix = p.getKey().nsPrefix();
        String _plus = (_nsPrefix + ":");
        String _name = p.getValue().name();
        String _plus_1 = (_plus + _name);
        _xifexpression = this.qnc.toQualifiedName(_plus_1);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * This method can be invoked very often for large models.
   * To enable read-only cache optimization, invoke OMLLinkingService.initializeCache(ResourceSet)
   */
  public <T extends Resource> QualifiedName importedBundleNameFunction(final Pair<Bundle, T> p) {
    QualifiedName _xblockexpression = null;
    {
      final HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> importedResourceNameCache = OMLScopeExtensions.lookupImportedResourceNameCache(p.getKey());
      QualifiedName _xifexpression = null;
      if ((null != importedResourceNameCache)) {
        QualifiedName _xblockexpression_1 = null;
        {
          final java.util.function.Function<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> _function = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
            return new HashMap<Resource, QualifiedName>();
          };
          final HashMap<Resource, QualifiedName> nameMap = importedResourceNameCache.computeIfAbsent(p.getKey(), _function);
          final java.util.function.Function<Resource, QualifiedName> _function_1 = (Resource it) -> {
            String _nsPrefix = p.getKey().nsPrefix();
            String _plus = (_nsPrefix + ":");
            String _name = p.getValue().name();
            String _plus_1 = (_plus + _name);
            return this.qnc.toQualifiedName(_plus_1);
          };
          _xblockexpression_1 = nameMap.computeIfAbsent(p.getValue(), _function_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _nsPrefix = p.getKey().nsPrefix();
        String _plus = (_nsPrefix + ":");
        String _name = p.getValue().name();
        String _plus_1 = (_plus + _name);
        _xifexpression = this.qnc.toQualifiedName(_plus_1);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * This method can be invoked very often for large models.
   * To enable read-only cache optimization, invoke OMLLinkingService.initializeCache(ResourceSet)
   */
  public <T extends Resource> QualifiedName importedDescriptionNameFunction(final Pair<DescriptionBox, T> p) {
    QualifiedName _xblockexpression = null;
    {
      final HashMap<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> importedResourceNameCache = OMLScopeExtensions.lookupImportedResourceNameCache(p.getKey());
      QualifiedName _xifexpression = null;
      if ((null != importedResourceNameCache)) {
        QualifiedName _xblockexpression_1 = null;
        {
          final java.util.function.Function<gov.nasa.jpl.imce.oml.model.common.Module, HashMap<Resource, QualifiedName>> _function = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
            return new HashMap<Resource, QualifiedName>();
          };
          final HashMap<Resource, QualifiedName> nameMap = importedResourceNameCache.computeIfAbsent(p.getKey(), _function);
          final java.util.function.Function<Resource, QualifiedName> _function_1 = (Resource it) -> {
            String _nsPrefix = p.getKey().nsPrefix();
            String _plus = (_nsPrefix + ":");
            String _name = p.getValue().name();
            String _plus_1 = (_plus + _name);
            return this.qnc.toQualifiedName(_plus_1);
          };
          _xblockexpression_1 = nameMap.computeIfAbsent(p.getValue(), _function_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _nsPrefix = p.getKey().nsPrefix();
        String _plus = (_nsPrefix + ":");
        String _name = p.getValue().name();
        String _plus_1 = (_plus + _name);
        _xifexpression = this.qnc.toQualifiedName(_plus_1);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public IScope allEntitiesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllEntitiesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllEntities(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllEntities = this.computeAllEntities(tbox);
        _elvis = _computeAllEntities;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllEntities(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Entity>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localEntities(it);
    };
    final Function<Pair<TerminologyBox, Entity>, QualifiedName> _function_1 = (Pair<TerminologyBox, Entity> it) -> {
      return this.<Entity>importedResourceNameFunction(it);
    };
    return this.<Entity>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allRangesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllRangesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllRanges(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllRanges = this.computeAllRanges(tbox);
        _elvis = _computeAllRanges;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllRanges(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<DataRange>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localRanges(it);
    };
    final Function<Pair<TerminologyBox, DataRange>, QualifiedName> _function_1 = (Pair<TerminologyBox, DataRange> it) -> {
      return this.<DataRange>importedResourceNameFunction(it);
    };
    return this.<DataRange>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allStructuresScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllStructuresCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllStructures(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllStructures = this.computeAllStructures(tbox);
        _elvis = _computeAllStructures;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllStructures(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Structure>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localStructures(it);
    };
    final Function<Pair<TerminologyBox, Structure>, QualifiedName> _function_1 = (Pair<TerminologyBox, Structure> it) -> {
      return this.<Structure>importedResourceNameFunction(it);
    };
    return this.<Structure>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allAspectsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllAspectsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllAspects(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllAspects = this.computeAllAspects(tbox);
        _elvis = _computeAllAspects;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllAspects(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<AspectKind>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localAspects(it);
    };
    final Function<Pair<TerminologyBox, AspectKind>, QualifiedName> _function_1 = (Pair<TerminologyBox, AspectKind> it) -> {
      return this.<AspectKind>importedResourceNameFunction(it);
    };
    return this.<AspectKind>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allConceptsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllConceptsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllConcepts(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllConcepts = this.computeAllConcepts(tbox);
        _elvis = _computeAllConcepts;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllConcepts(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ConceptKind>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localConcepts(it);
    };
    final Function<Pair<TerminologyBox, ConceptKind>, QualifiedName> _function_1 = (Pair<TerminologyBox, ConceptKind> it) -> {
      return this.<ConceptKind>importedResourceNameFunction(it);
    };
    return this.<ConceptKind>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allConceptualRelationshipsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllConceptualRelationshipsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllConceptualRelationships(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllConceptualRelationships = this.computeAllConceptualRelationships(tbox);
        _elvis = _computeAllConceptualRelationships;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllConceptualRelationships(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ConceptualRelationship>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localConceptualRelationships(it);
    };
    final Function<Pair<TerminologyBox, ConceptualRelationship>, QualifiedName> _function_1 = (Pair<TerminologyBox, ConceptualRelationship> it) -> {
      return this.<ConceptualRelationship>importedResourceNameFunction(it);
    };
    return this.<ConceptualRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allReifiedRelationshipRestrictionsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllReifiedRelationshipRestrictionsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllReifiedRelationshipRestrictions(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllReifiedRelationshipRestrictions = this.computeAllReifiedRelationshipRestrictions(tbox);
        _elvis = _computeAllReifiedRelationshipRestrictions;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllReifiedRelationshipRestrictions(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ReifiedRelationshipRestriction>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localReifiedRelationshipRestrictions(it);
    };
    final Function<Pair<TerminologyBox, ReifiedRelationshipRestriction>, QualifiedName> _function_1 = (Pair<TerminologyBox, ReifiedRelationshipRestriction> it) -> {
      return this.<ReifiedRelationshipRestriction>importedResourceNameFunction(it);
    };
    return this.<ReifiedRelationshipRestriction>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allReifiedRelationshipsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllReifiedRelationshipsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllReifiedRelationships(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllReifiedRelationships = this.computeAllReifiedRelationships(tbox);
        _elvis = _computeAllReifiedRelationships;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllReifiedRelationships(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ConceptualRelationship>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localReifiedRelationships(it);
    };
    final Function<Pair<TerminologyBox, ConceptualRelationship>, QualifiedName> _function_1 = (Pair<TerminologyBox, ConceptualRelationship> it) -> {
      return this.<ConceptualRelationship>importedResourceNameFunction(it);
    };
    return this.<ConceptualRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allUnreifiedRelationshipsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllUnreifiedRelationshipsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllUnreifiedRelationships(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllUnreifiedRelationships = this.computeAllUnreifiedRelationships(tbox);
        _elvis = _computeAllUnreifiedRelationships;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllUnreifiedRelationships(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<UnreifiedRelationship>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localUnreifiedRelationships(it);
    };
    final Function<Pair<TerminologyBox, UnreifiedRelationship>, QualifiedName> _function_1 = (Pair<TerminologyBox, UnreifiedRelationship> it) -> {
      return this.<UnreifiedRelationship>importedResourceNameFunction(it);
    };
    return this.<UnreifiedRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allEntityRelationshipsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllEntityRelationshipsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllEntityRelationships(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllEntityRelationships = this.computeAllEntityRelationships(tbox);
        _elvis = _computeAllEntityRelationships;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllEntityRelationships(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<EntityRelationship>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localEntityRelationships(it);
    };
    final Function<Pair<TerminologyBox, EntityRelationship>, QualifiedName> _function_1 = (Pair<TerminologyBox, EntityRelationship> it) -> {
      return this.<EntityRelationship>importedResourceNameFunction(it);
    };
    return this.<EntityRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allPredicatesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllPredicatesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllPredicates(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllPredicates = this.computeAllPredicates(tbox);
        _elvis = _computeAllPredicates;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllPredicates(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Predicate>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localPredicates(it);
    };
    final Function<Pair<TerminologyBox, Predicate>, QualifiedName> _function_1 = (Pair<TerminologyBox, Predicate> it) -> {
      return this.<Predicate>importedResourceNameFunction(it);
    };
    return this.<Predicate>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allForwardPropertiesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllForwardPropertiesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllForwardProperties(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllForwardProperties = this.computeAllForwardProperties(tbox);
        _elvis = _computeAllForwardProperties;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllForwardProperties(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ForwardProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localForwardProperties(it);
    };
    final Function<Pair<TerminologyBox, ForwardProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, ForwardProperty> it) -> {
      return this.<ForwardProperty>importedResourceNameFunction(it);
    };
    return this.<ForwardProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allInversePropertiesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllInversePropertiesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllInverseProperties(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllInverseProperties = this.computeAllInverseProperties(tbox);
        _elvis = _computeAllInverseProperties;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllInverseProperties(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<InverseProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localInverseProperties(it);
    };
    final Function<Pair<TerminologyBox, InverseProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, InverseProperty> it) -> {
      return this.<InverseProperty>importedResourceNameFunction(it);
    };
    return this.<InverseProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allRestrictableRelationshipsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllRestrictableRelationshipsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllRestrictableRelationships(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllRestrictableRelationships = this.computeAllRestrictableRelationships(tbox);
        _elvis = _computeAllRestrictableRelationships;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllRestrictableRelationships(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<RestrictableRelationship>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localRestrictableRelationships(it);
    };
    final Function<Pair<TerminologyBox, RestrictableRelationship>, QualifiedName> _function_1 = (Pair<TerminologyBox, RestrictableRelationship> it) -> {
      return this.<RestrictableRelationship>importedResourceNameFunction(it);
    };
    return this.<RestrictableRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allEntityScalarDataPropertiesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllEntityScalarDataPropertiesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllEntityScalarDataProperties(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllEntityScalarDataProperties = this.computeAllEntityScalarDataProperties(tbox);
        _elvis = _computeAllEntityScalarDataProperties;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllEntityScalarDataProperties(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<EntityScalarDataProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localEntityScalarDataProperties(it);
    };
    final Function<Pair<TerminologyBox, EntityScalarDataProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, EntityScalarDataProperty> it) -> {
      return this.<EntityScalarDataProperty>importedResourceNameFunction(it);
    };
    return this.<EntityScalarDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allEntityStructuredDataPropertiesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllEntityStructuredDataPropertiesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllEntityStructuredDataProperties(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllEntityStructuredDataProperties = this.computeAllEntityStructuredDataProperties(tbox);
        _elvis = _computeAllEntityStructuredDataProperties;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllEntityStructuredDataProperties(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<EntityStructuredDataProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localEntityStructuredDataProperties(it);
    };
    final Function<Pair<TerminologyBox, EntityStructuredDataProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, EntityStructuredDataProperty> it) -> {
      return this.<EntityStructuredDataProperty>importedResourceNameFunction(it);
    };
    return this.<EntityStructuredDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allScalarDataPropertiesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllScalarDataPropertiesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllScalarDataProperties(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllScalarDataProperties = this.computeAllScalarDataProperties(tbox);
        _elvis = _computeAllScalarDataProperties;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllScalarDataProperties(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ScalarDataProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localScalarDataProperties(it);
    };
    final Function<Pair<TerminologyBox, ScalarDataProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, ScalarDataProperty> it) -> {
      return this.<ScalarDataProperty>importedResourceNameFunction(it);
    };
    return this.<ScalarDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allStructuredDataPropertiesScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllStructuredDataPropertiesCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllStructuredDataProperties(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllStructuredDataProperties = this.computeAllStructuredDataProperties(tbox);
        _elvis = _computeAllStructuredDataProperties;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllStructuredDataProperties(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<StructuredDataProperty>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localStructuredDataProperties(it);
    };
    final Function<Pair<TerminologyBox, StructuredDataProperty>, QualifiedName> _function_1 = (Pair<TerminologyBox, StructuredDataProperty> it) -> {
      return this.<StructuredDataProperty>importedResourceNameFunction(it);
    };
    return this.<StructuredDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allScalarOneOfRestrictionsScope(final TerminologyBox tbox) {
    IScope _xblockexpression = null;
    {
      final HashMap<TerminologyBox, IScope> cache = OMLScopeExtensions.lookupAllScalarOneOfRestrictionsCache(tbox);
      IScope _elvis = null;
      IScope _computeIfAbsent = null;
      if (cache!=null) {
        final java.util.function.Function<TerminologyBox, IScope> _function = (TerminologyBox it) -> {
          return this.computeAllScalarOneOfRestrictions(it);
        };
        _computeIfAbsent=cache.computeIfAbsent(tbox, _function);
      }
      if (_computeIfAbsent != null) {
        _elvis = _computeIfAbsent;
      } else {
        IScope _computeAllScalarOneOfRestrictions = this.computeAllScalarOneOfRestrictions(tbox);
        _elvis = _computeAllScalarOneOfRestrictions;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  private IScope computeAllScalarOneOfRestrictions(final TerminologyBox tbox) {
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
    final Function<TerminologyBox, Iterable<ConceptKind>> _function = (TerminologyBox it) -> {
      return this._oMLExtensions.localConcepts(it);
    };
    final Function<Pair<TerminologyBox, ConceptKind>, QualifiedName> _function_1 = (Pair<TerminologyBox, ConceptKind> it) -> {
      return this.<ConceptKind>importedResourceNameFunction(it);
    };
    return this.<ConceptKind>bundleScope(b, _function, _function_1);
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
  
  public IScope allRangesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      final Iterable<TerminologyBox> tboxes = this._oMLExtensions.allImportedTerminologiesFromDescription(dbox);
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = (TerminologyBox tbox) -> {
        final Function<DataRange, QualifiedName> _function_1 = (DataRange importedThing) -> {
          return this.<DataRange>importedResourceNameFunction(Pair.<TerminologyBox, DataRange>of(tbox, importedThing));
        };
        return Scopes.<DataRange>scopedElementsFor(
          this._oMLExtensions.localRanges(tbox), _function_1);
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
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
        final Function<ConceptKind, QualifiedName> _function_1 = (ConceptKind importedThing) -> {
          return this.<ConceptKind>importedResourceNameFunction(Pair.<TerminologyBox, ConceptKind>of(tbox, importedThing));
        };
        return Scopes.<ConceptKind>scopedElementsFor(
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
        final Function<ConceptualRelationship, QualifiedName> _function_1 = (ConceptualRelationship importedThing) -> {
          return this.<ConceptualRelationship>importedResourceNameFunction(Pair.<TerminologyBox, ConceptualRelationship>of(tbox, importedThing));
        };
        return Scopes.<ConceptualRelationship>scopedElementsFor(
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
