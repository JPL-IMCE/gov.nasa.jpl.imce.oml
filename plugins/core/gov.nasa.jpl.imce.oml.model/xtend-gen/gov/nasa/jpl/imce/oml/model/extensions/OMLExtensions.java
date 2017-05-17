/**
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.model.extensions;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.NameBasedGenerator;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom;
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalogManager;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogManager;
import org.apache.xml.resolver.tools.CatalogResolver;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class OMLExtensions {
  private final static String RESOURCE_SET_CATALOG_MANAGER = "RESOURCE_SET_CATALOG_MANAGER";
  
  private final static String RESOURCE_SET_CATALOG_RESOLVER = "RESOURCE_SET_CATALOG_RESOLVER";
  
  private final static String RESOURCE_SET_CATALOG_INSTANCE = "RESOURCE_SET_CATALOG_INSTANCE";
  
  public static CatalogManager getOrCreateCatalogManager(final ResourceSet rs) {
    Object _elvis = null;
    Object _get = rs.getLoadOptions().get(OMLExtensions.RESOURCE_SET_CATALOG_MANAGER);
    if (_get != null) {
      _elvis = _get;
    } else {
      OMLCatalogManager _oMLCatalogManager = new OMLCatalogManager();
      _elvis = _oMLCatalogManager;
    }
    final Object o = _elvis;
    boolean _isInstance = OMLCatalogManager.class.isInstance(o);
    if (_isInstance) {
      final OMLCatalogManager cm = OMLCatalogManager.class.cast(o);
      cm.setUseStaticCatalog(false);
      cm.setCatalogClassName("gov.nasa.jpl.imce.oml.extensions.OMLCatalog");
      rs.getLoadOptions().putIfAbsent(OMLExtensions.RESOURCE_SET_CATALOG_MANAGER, cm);
      return cm;
    } else {
      return null;
    }
  }
  
  public static CatalogResolver getOrCreateCatalogResolver(final ResourceSet rs) {
    Object _elvis = null;
    Object _get = rs.getLoadOptions().get(OMLExtensions.RESOURCE_SET_CATALOG_RESOLVER);
    if (_get != null) {
      _elvis = _get;
    } else {
      CatalogManager _orCreateCatalogManager = OMLExtensions.getOrCreateCatalogManager(rs);
      CatalogResolver _catalogResolver = new CatalogResolver(_orCreateCatalogManager);
      _elvis = _catalogResolver;
    }
    final Object o = _elvis;
    boolean _isInstance = CatalogResolver.class.isInstance(o);
    if (_isInstance) {
      final CatalogResolver cr = CatalogResolver.class.cast(o);
      rs.getLoadOptions().putIfAbsent(OMLExtensions.RESOURCE_SET_CATALOG_RESOLVER, cr);
      return cr;
    } else {
      return null;
    }
  }
  
  public static OMLCatalog getCatalog(final ResourceSet rs) {
    Object _elvis = null;
    Object _get = rs.getLoadOptions().get(OMLExtensions.RESOURCE_SET_CATALOG_INSTANCE);
    if (_get != null) {
      _elvis = _get;
    } else {
      Catalog _catalog = OMLExtensions.getOrCreateCatalogResolver(rs).getCatalog();
      _elvis = _catalog;
    }
    final Object o = _elvis;
    boolean _isInstance = OMLCatalog.class.isInstance(o);
    if (_isInstance) {
      final OMLCatalog c = OMLCatalog.class.cast(o);
      rs.getLoadOptions().putIfAbsent(OMLExtensions.RESOURCE_SET_CATALOG_INSTANCE, c);
      return c;
    } else {
      return null;
    }
  }
  
  public static OMLCatalog findCatalogIfExists(final Resource r) {
    OMLCatalog _xblockexpression = null;
    {
      final ResourceSet rs = r.getResourceSet();
      final URI uri = rs.getURIConverter().normalize(r.getURI());
      final URI ruri = CommonPlugin.resolve(uri);
      final URI luri = CommonPlugin.asLocalURI(ruri);
      _xblockexpression = OMLExtensions.findCatalogIfExists(rs, luri.trimSegments(1));
    }
    return _xblockexpression;
  }
  
  public static OMLCatalog findCatalogIfExists(final ResourceSet rs, final URI path) {
    final OMLCatalog c = OMLExtensions.getCatalog(rs);
    if ((null == c)) {
      return null;
    }
    URI current = path;
    while ((current.segmentCount() > 0)) {
      try {
        System.out.println(("# Searching for OML catalog in: " + current));
        final URI omlC = current.appendSegment("oml.catalog.xml");
        String _string = omlC.toString();
        final URL omlURL = new URL(_string);
        final InputStream omlS = omlURL.openStream();
        omlS.close();
        boolean _hasParsedCatalog = c.hasParsedCatalog(omlURL);
        boolean _not = (!_hasParsedCatalog);
        if (_not) {
          String _string_1 = omlC.toString();
          URL _uRL = new URL(_string_1);
          c.parseCatalog(_uRL);
          System.out.println(("# Found catalog: " + omlC));
        }
        return c;
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException ex = (IOException)_t;
          current = current.trimSegments(1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return null;
  }
  
  public static UUID namespaceUUID(final String namespace) {
    ArrayList<Pair<String, String>> _arrayList = new ArrayList<Pair<String, String>>();
    return OMLExtensions.namespaceUUID(namespace, ((Pair<String, String>[])Conversions.unwrapArray(_arrayList, Pair.class)));
  }
  
  public static UUID namespaceUUID(final String namespace, final Pair<String, String> factor1) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      _xblockexpression = OMLExtensions.namespaceUUID(namespace, ((Pair<String, String>[])Conversions.unwrapArray(factors, Pair.class)));
    }
    return _xblockexpression;
  }
  
  public static UUID namespaceUUID(final String namespace, final Pair<String, String> factor1, final Pair<String, String> factor2) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      factors.add(factor2);
      _xblockexpression = OMLExtensions.namespaceUUID(namespace, ((Pair<String, String>[])Conversions.unwrapArray(factors, Pair.class)));
    }
    return _xblockexpression;
  }
  
  public static UUID namespaceUUID(final String namespace, final Pair<String, String>[] factors) {
    UUID _xblockexpression = null;
    {
      final Function1<Pair<String, String>, String> _function = (Pair<String, String> pair) -> {
        String _elvis = null;
        String _key = pair.getKey();
        if (_key != null) {
          _elvis = _key;
        } else {
          _elvis = "";
        }
        String _plus = (_elvis + ":");
        String _elvis_1 = null;
        String _value = pair.getValue();
        if (_value != null) {
          _elvis_1 = _value;
        } else {
          _elvis_1 = "";
        }
        return (_plus + _elvis_1);
      };
      String _join = IterableExtensions.join(ListExtensions.<Pair<String, String>, String>map(((List<Pair<String, String>>)Conversions.doWrapArray(factors)), _function), ",");
      final String name = (namespace + _join);
      _xblockexpression = Generators.nameBasedGenerator(NameBasedGenerator.NAMESPACE_URL).generate(name);
    }
    return _xblockexpression;
  }
  
  public static UUID derivedUUID(final String context) {
    ArrayList<Pair<String, String>> _arrayList = new ArrayList<Pair<String, String>>();
    return OMLExtensions.derivedUUID(context, ((Pair<String, String>[])Conversions.unwrapArray(_arrayList, Pair.class)));
  }
  
  public static UUID derivedUUID(final String context, final Pair<String, String> factor1) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      _xblockexpression = OMLExtensions.derivedUUID(context, ((Pair<String, String>[])Conversions.unwrapArray(factors, Pair.class)));
    }
    return _xblockexpression;
  }
  
  public static UUID derivedUUID(final String context, final Pair<String, String> factor1, final Pair<String, String> factor2) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      factors.add(factor2);
      _xblockexpression = OMLExtensions.derivedUUID(context, ((Pair<String, String>[])Conversions.unwrapArray(factors, Pair.class)));
    }
    return _xblockexpression;
  }
  
  public static UUID derivedUUID(final String context, final Pair<String, String> factor1, final Pair<String, String> factor2, final Pair<String, String> factor3) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      factors.add(factor2);
      factors.add(factor3);
      _xblockexpression = OMLExtensions.derivedUUID(context, ((Pair<String, String>[])Conversions.unwrapArray(factors, Pair.class)));
    }
    return _xblockexpression;
  }
  
  public static UUID derivedUUID(final String context, final Pair<String, String> factor1, final Pair<String, String> factor2, final Pair<String, String> factor3, final Pair<String, String> factor4) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      factors.add(factor2);
      factors.add(factor3);
      factors.add(factor4);
      _xblockexpression = OMLExtensions.derivedUUID(context, ((Pair<String, String>[])Conversions.unwrapArray(factors, Pair.class)));
    }
    return _xblockexpression;
  }
  
  public static UUID derivedUUID(final String context, final Pair<String, String> factor1, final Pair<String, String> factor2, final Pair<String, String> factor3, final Pair<String, String> factor4, final Pair<String, String> factor5) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      factors.add(factor2);
      factors.add(factor3);
      factors.add(factor4);
      factors.add(factor5);
      _xblockexpression = OMLExtensions.derivedUUID(context, ((Pair<String, String>[])Conversions.unwrapArray(factors, Pair.class)));
    }
    return _xblockexpression;
  }
  
  public static UUID derivedUUID(final String context, final Pair<String, String>[] factors) {
    UUID _xblockexpression = null;
    {
      final Function1<Pair<String, String>, String> _function = (Pair<String, String> pair) -> {
        String _elvis = null;
        String _key = pair.getKey();
        if (_key != null) {
          _elvis = _key;
        } else {
          _elvis = "";
        }
        String _plus = (_elvis + ":");
        String _elvis_1 = null;
        String _value = pair.getValue();
        if (_value != null) {
          _elvis_1 = _value;
        } else {
          _elvis_1 = "";
        }
        return (_plus + _elvis_1);
      };
      String _join = IterableExtensions.join(ListExtensions.<Pair<String, String>, String>map(((List<Pair<String, String>>)Conversions.doWrapArray(factors)), _function), ",");
      final String name = (context + _join);
      _xblockexpression = Generators.nameBasedGenerator(NameBasedGenerator.NAMESPACE_URL).generate(name);
    }
    return _xblockexpression;
  }
  
  public Iterable<TerminologyBox> terminologies(final Extent it) {
    return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
  }
  
  public Iterable<TerminologyGraph> terminologyGraphs(final Extent it) {
    return Iterables.<TerminologyGraph>filter(it.getModules(), TerminologyGraph.class);
  }
  
  public Iterable<DescriptionBox> descriptions(final Extent it) {
    return Iterables.<DescriptionBox>filter(it.getModules(), DescriptionBox.class);
  }
  
  public Iterable<Bundle> bundles(final Extent it) {
    return Iterables.<Bundle>filter(it.getModules(), Bundle.class);
  }
  
  public void phasedResolveAll(final Extent it) {
    final Consumer<TerminologyGraph> _function = (TerminologyGraph it_1) -> {
      final Consumer<TerminologyBoxAxiom> _function_1 = (TerminologyBoxAxiom it_2) -> {
        boolean _matched = false;
        if (it_2 instanceof TerminologyExtensionAxiom) {
          _matched=true;
          EcoreUtil.resolveAll(it_2);
        }
      };
      it_1.getBoxAxioms().forEach(_function_1);
    };
    this.terminologyGraphs(it).forEach(_function);
    final Consumer<TerminologyGraph> _function_1 = (TerminologyGraph it_1) -> {
      final Consumer<TerminologyBoxAxiom> _function_2 = (TerminologyBoxAxiom it_2) -> {
        boolean _matched = false;
        if (it_2 instanceof SpecializationAxiom) {
          _matched=true;
          EcoreUtil.resolveAll(it_2);
        }
      };
      it_1.getBoxAxioms().forEach(_function_2);
    };
    this.terminologyGraphs(it).forEach(_function_1);
  }
  
  public Iterable<TerminologyBox> allImportedTerminologies(final TerminologyBox it) {
    return this.collectAllImportedTerminologies(Lists.<TerminologyBox>newArrayList(it), Lists.<TerminologyBox>newArrayList(it));
  }
  
  public final Iterable<TerminologyBox> collectAllImportedTerminologies(final ArrayList<TerminologyBox> queue, final ArrayList<TerminologyBox> acc) {
    Iterable<TerminologyBox> _xblockexpression = null;
    {
      boolean _isEmpty = queue.isEmpty();
      if (_isEmpty) {
        return acc;
      }
      final TerminologyBox tbox = IterableExtensions.<TerminologyBox>head(queue);
      queue.remove(tbox);
      final Function1<TerminologyBoxAxiom, TerminologyBox> _function = (TerminologyBoxAxiom it) -> {
        return it.target();
      };
      final Iterable<TerminologyBox> inc = IterableExtensions.<TerminologyBox>filterNull(ListExtensions.<TerminologyBoxAxiom, TerminologyBox>map(tbox.getBoxAxioms(), _function));
      Iterables.<TerminologyBox>addAll(queue, inc);
      Iterables.<TerminologyBox>addAll(acc, inc);
      _xblockexpression = this.collectAllImportedTerminologies(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<Module> allImportedModules(final Module it) {
    return this.collectAllImportedModules(Lists.<Module>newArrayList(it), Lists.<Module>newArrayList(it));
  }
  
  public final Iterable<Module> collectAllImportedModules(final ArrayList<Module> queue, final ArrayList<Module> acc) {
    Iterable<Module> _xblockexpression = null;
    {
      boolean _isEmpty = queue.isEmpty();
      if (_isEmpty) {
        return acc;
      }
      final Module m = IterableExtensions.<Module>head(queue);
      queue.remove(m);
      final Function1<ModuleEdge, Module> _function = (ModuleEdge it) -> {
        return it.targetModule();
      };
      final Iterable<Module> inc = IterableExtensions.<Module>filterNull(ListExtensions.<ModuleEdge, Module>map(m.moduleEdges(), _function));
      Iterables.<Module>addAll(queue, inc);
      Iterables.<Module>addAll(acc, inc);
      _xblockexpression = this.collectAllImportedModules(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<Entity> localEntities(final TerminologyBox it) {
    return Iterables.<Entity>filter(it.getBoxStatements(), Entity.class);
  }
  
  public Iterable<Entity> allEntities(final TerminologyBox it) {
    Iterable<Entity> _localEntities = this.localEntities(it);
    final Function1<TerminologyBox, Iterable<Entity>> _function = (TerminologyBox it_1) -> {
      return this.localEntities(it_1);
    };
    Iterable<Entity> _flatten = Iterables.<Entity>concat(IterableExtensions.<TerminologyBox, Iterable<Entity>>map(this.allImportedTerminologies(it), _function));
    return Iterables.<Entity>concat(_localEntities, _flatten);
  }
  
  public Iterable<Aspect> localAspects(final TerminologyBox it) {
    return Iterables.<Aspect>filter(it.getBoxStatements(), Aspect.class);
  }
  
  public Iterable<Aspect> allAspects(final TerminologyBox it) {
    Iterable<Aspect> _localAspects = this.localAspects(it);
    final Function1<TerminologyBox, Iterable<Aspect>> _function = (TerminologyBox it_1) -> {
      return this.localAspects(it_1);
    };
    Iterable<Aspect> _flatten = Iterables.<Aspect>concat(IterableExtensions.<TerminologyBox, Iterable<Aspect>>map(this.allImportedTerminologies(it), _function));
    return Iterables.<Aspect>concat(_localAspects, _flatten);
  }
  
  public Iterable<Concept> localConcepts(final TerminologyBox it) {
    return Iterables.<Concept>filter(it.getBoxStatements(), Concept.class);
  }
  
  public Iterable<Concept> allConcepts(final TerminologyBox it) {
    Iterable<Concept> _localConcepts = this.localConcepts(it);
    final Function1<TerminologyBox, Iterable<Concept>> _function = (TerminologyBox it_1) -> {
      return this.localConcepts(it_1);
    };
    Iterable<Concept> _flatten = Iterables.<Concept>concat(IterableExtensions.<TerminologyBox, Iterable<Concept>>map(this.allImportedTerminologies(it), _function));
    return Iterables.<Concept>concat(_localConcepts, _flatten);
  }
  
  public Iterable<ReifiedRelationship> localReifiedRelationships(final TerminologyBox it) {
    return Iterables.<ReifiedRelationship>filter(it.getBoxStatements(), ReifiedRelationship.class);
  }
  
  public Iterable<UnreifiedRelationship> localUnreifiedRelationships(final TerminologyBox it) {
    return Iterables.<UnreifiedRelationship>filter(it.getBoxStatements(), UnreifiedRelationship.class);
  }
  
  public Iterable<ReifiedRelationship> allReifiedRelationships(final TerminologyBox it) {
    Iterable<ReifiedRelationship> _localReifiedRelationships = this.localReifiedRelationships(it);
    final Function1<TerminologyBox, Iterable<ReifiedRelationship>> _function = (TerminologyBox it_1) -> {
      return this.localReifiedRelationships(it_1);
    };
    Iterable<ReifiedRelationship> _flatten = Iterables.<ReifiedRelationship>concat(IterableExtensions.<TerminologyBox, Iterable<ReifiedRelationship>>map(this.allImportedTerminologies(it), _function));
    return Iterables.<ReifiedRelationship>concat(_localReifiedRelationships, _flatten);
  }
  
  public Iterable<EntityRelationship> localEntityRelationships(final TerminologyBox it) {
    return Iterables.<EntityRelationship>filter(it.getBoxStatements(), EntityRelationship.class);
  }
  
  public Iterable<EntityRelationship> allEntityRelationships(final TerminologyBox it) {
    Iterable<EntityRelationship> _localEntityRelationships = this.localEntityRelationships(it);
    final Function1<TerminologyBox, Iterable<EntityRelationship>> _function = (TerminologyBox it_1) -> {
      return this.localEntityRelationships(it_1);
    };
    Iterable<EntityRelationship> _flatten = Iterables.<EntityRelationship>concat(IterableExtensions.<TerminologyBox, Iterable<EntityRelationship>>map(this.allImportedTerminologies(it), _function));
    return Iterables.<EntityRelationship>concat(_localEntityRelationships, _flatten);
  }
  
  public Iterable<DataRange> localRanges(final TerminologyBox it) {
    return Iterables.<DataRange>filter(it.getBoxStatements(), DataRange.class);
  }
  
  public Iterable<Structure> localStructures(final TerminologyBox it) {
    return Iterables.<Structure>filter(it.getBoxStatements(), Structure.class);
  }
  
  public Iterable<EntityScalarDataProperty> localEntityScalarDataProperties(final TerminologyBox it) {
    return Iterables.<EntityScalarDataProperty>filter(it.getBoxStatements(), EntityScalarDataProperty.class);
  }
  
  public Iterable<EntityStructuredDataProperty> localEntityStructuredDataProperties(final TerminologyBox it) {
    return Iterables.<EntityStructuredDataProperty>filter(it.getBoxStatements(), EntityStructuredDataProperty.class);
  }
  
  public Iterable<ScalarDataProperty> localScalarDataProperties(final TerminologyBox it) {
    return Iterables.<ScalarDataProperty>filter(it.getBoxStatements(), ScalarDataProperty.class);
  }
  
  public Iterable<StructuredDataProperty> localStructuredDataProperties(final TerminologyBox it) {
    return Iterables.<StructuredDataProperty>filter(it.getBoxStatements(), StructuredDataProperty.class);
  }
  
  public Iterable<ScalarOneOfRestriction> localScalarOneOfRestrictions(final TerminologyBox it) {
    return Iterables.<ScalarOneOfRestriction>filter(it.getBoxStatements(), ScalarOneOfRestriction.class);
  }
  
  public Iterable<Bundle> allImportedBundles(final Bundle it) {
    return this.collectAllImportedBundles(Lists.<Bundle>newArrayList(it), Lists.<Bundle>newArrayList(it));
  }
  
  public final Iterable<Bundle> collectAllImportedBundles(final ArrayList<Bundle> queue, final ArrayList<Bundle> acc) {
    Iterable<Bundle> _xblockexpression = null;
    {
      boolean _isEmpty = queue.isEmpty();
      if (_isEmpty) {
        return acc;
      }
      final Bundle bundle = IterableExtensions.<Bundle>head(queue);
      queue.remove(bundle);
      final Function1<TerminologyBundleAxiom, TerminologyBox> _function = (TerminologyBundleAxiom it) -> {
        return it.target();
      };
      final Iterable<Bundle> inc = Iterables.<Bundle>filter(ListExtensions.<TerminologyBundleAxiom, TerminologyBox>map(bundle.getBundleAxioms(), _function), Bundle.class);
      Iterables.<Bundle>addAll(queue, inc);
      Iterables.<Bundle>addAll(acc, inc);
      _xblockexpression = this.collectAllImportedBundles(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<AnonymousConceptUnionAxiom> localAnonymousConceptUnionAxioms(final Bundle it) {
    return Iterables.<AnonymousConceptUnionAxiom>filter(it.getBundleStatements(), AnonymousConceptUnionAxiom.class);
  }
  
  public Iterable<RootConceptTaxonomyAxiom> localRootConceptTaxonomyAxioms(final Bundle it) {
    return Iterables.<RootConceptTaxonomyAxiom>filter(it.getBundleStatements(), RootConceptTaxonomyAxiom.class);
  }
  
  public Iterable<TerminologyBox> allImportedTerminologiesFromDescription(final DescriptionBox it) {
    return this.collectAllImportedTerminologiesFromDescription(Lists.<DescriptionBox>newArrayList(it), Sets.<TerminologyBox>newHashSet());
  }
  
  public final Iterable<TerminologyBox> collectAllImportedTerminologiesFromDescription(final ArrayList<DescriptionBox> queue, final HashSet<TerminologyBox> acc) {
    Iterable<TerminologyBox> _xblockexpression = null;
    {
      boolean _isEmpty = queue.isEmpty();
      if (_isEmpty) {
        return acc;
      }
      final DescriptionBox dbox = IterableExtensions.<DescriptionBox>head(queue);
      queue.remove(dbox);
      final Function1<DescriptionBoxRefinement, DescriptionBox> _function = (DescriptionBoxRefinement it) -> {
        return it.getRefinedDescriptionBox();
      };
      final List<DescriptionBox> incd = ListExtensions.<DescriptionBoxRefinement, DescriptionBox>map(dbox.getDescriptionBoxRefinements(), _function);
      queue.addAll(incd);
      final Function1<DescriptionBoxExtendsClosedWorldDefinitions, TerminologyBox> _function_1 = (DescriptionBoxExtendsClosedWorldDefinitions it) -> {
        return it.getClosedWorldDefinitions();
      };
      final Function1<TerminologyBox, Iterable<TerminologyBox>> _function_2 = (TerminologyBox it) -> {
        return this.allImportedTerminologies(it);
      };
      final Iterable<TerminologyBox> inct = Iterables.<TerminologyBox>concat(ListExtensions.<TerminologyBox, Iterable<TerminologyBox>>map(ListExtensions.<DescriptionBoxExtendsClosedWorldDefinitions, TerminologyBox>map(dbox.getClosedWorldDefinitions(), _function_1), _function_2));
      Iterables.<TerminologyBox>addAll(acc, inct);
      _xblockexpression = this.collectAllImportedTerminologiesFromDescription(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<DescriptionBox> allImportedDescriptions(final DescriptionBox it) {
    return this.collectAllImportedDescriptions(Lists.<DescriptionBox>newArrayList(it), Lists.<DescriptionBox>newArrayList(it));
  }
  
  public final Iterable<DescriptionBox> collectAllImportedDescriptions(final ArrayList<DescriptionBox> queue, final ArrayList<DescriptionBox> acc) {
    Iterable<DescriptionBox> _xblockexpression = null;
    {
      boolean _isEmpty = queue.isEmpty();
      if (_isEmpty) {
        return acc;
      }
      final DescriptionBox dbox = IterableExtensions.<DescriptionBox>head(queue);
      queue.remove(dbox);
      final Function1<DescriptionBoxRefinement, DescriptionBox> _function = (DescriptionBoxRefinement it) -> {
        return it.getRefinedDescriptionBox();
      };
      final List<DescriptionBox> inc = ListExtensions.<DescriptionBoxRefinement, DescriptionBox>map(dbox.getDescriptionBoxRefinements(), _function);
      queue.addAll(inc);
      acc.addAll(inc);
      _xblockexpression = this.collectAllImportedDescriptions(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<ConceptualEntitySingletonInstance> localConceptualEntitySingletonInstances(final DescriptionBox it) {
    EList<ConceptInstance> _conceptInstances = it.getConceptInstances();
    EList<ReifiedRelationshipInstance> _reifiedRelationshipInstances = it.getReifiedRelationshipInstances();
    return Iterables.<ConceptualEntitySingletonInstance>concat(_conceptInstances, _reifiedRelationshipInstances);
  }
  
  public Iterable<ReifiedRelationshipInstance> localReifiedRelationshipInstances(final DescriptionBox it) {
    return it.getReifiedRelationshipInstances();
  }
  
  public static String kind(final Element e) {
    String _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(e, DescriptionBox.class)) {
      _matched=true;
      _switchResult = "DescriptionBox";
    }
    if (!_matched) {
      if (Objects.equal(e, TerminologyGraph.class)) {
        _matched=true;
        _switchResult = "TerminologyGraph";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, Bundle.class)) {
        _matched=true;
        _switchResult = "Bundle";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, DescriptionBoxExtendsClosedWorldDefinitions.class)) {
        _matched=true;
        _switchResult = "DescriptionBoxExtendsClosedWorldDefinitions";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, DescriptionBoxRefinement.class)) {
        _matched=true;
        _switchResult = "DescriptionBoxRefinement";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ConceptDesignationTerminologyAxiom.class)) {
        _matched=true;
        _switchResult = "ConceptDesignationTerminologyAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, TerminologyExtensionAxiom.class)) {
        _matched=true;
        _switchResult = "TerminologyExtensionAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, TerminologyNestingAxiom.class)) {
        _matched=true;
        _switchResult = "TerminologyNestingAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, BundledTerminologyAxiom.class)) {
        _matched=true;
        _switchResult = "BundledTerminologyAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, EntityExistentialRestrictionAxiom.class)) {
        _matched=true;
        _switchResult = "EntityExistentialRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, EntityUniversalRestrictionAxiom.class)) {
        _matched=true;
        _switchResult = "EntityUniversalRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, EntityScalarDataPropertyExistentialRestrictionAxiom.class)) {
        _matched=true;
        _switchResult = "EntityScalarDataPropertyExistentialRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, EntityScalarDataPropertyParticularRestrictionAxiom.class)) {
        _matched=true;
        _switchResult = "EntityScalarDataPropertyParticularRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, EntityScalarDataPropertyUniversalRestrictionAxiom.class)) {
        _matched=true;
        _switchResult = "EntityScalarDataPropertyUniversalRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ScalarOneOfLiteralAxiom.class)) {
        _matched=true;
        _switchResult = "ScalarOneOfLiteralAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, AspectSpecializationAxiom.class)) {
        _matched=true;
        _switchResult = "AspectSpecializationAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ConceptSpecializationAxiom.class)) {
        _matched=true;
        _switchResult = "ConceptSpecializationAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ReifiedRelationshipSpecializationAxiom.class)) {
        _matched=true;
        _switchResult = "ReifiedRelationshipSpecializationAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, AnonymousConceptUnionAxiom.class)) {
        _matched=true;
        _switchResult = "AnonymousConceptTaxonomyAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, SpecificDisjointConceptAxiom.class)) {
        _matched=true;
        _switchResult = "SpecificDisjointConceptAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, RootConceptTaxonomyAxiom.class)) {
        _matched=true;
        _switchResult = "RootConceptTaxonomyAxiom";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ReifiedRelationshipInstanceDomain.class)) {
        _matched=true;
        _switchResult = "ReifiedRelationshipInstanceDomain";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ReifiedRelationshipInstanceRange.class)) {
        _matched=true;
        _switchResult = "ReifiedRelationshipInstanceRange";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, SingletonInstanceScalarDataPropertyValue.class)) {
        _matched=true;
        _switchResult = "SingletonInstanceScalarDataPropertyValue";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ConceptInstance.class)) {
        _matched=true;
        _switchResult = "ConceptInstance";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ReifiedRelationshipInstance.class)) {
        _matched=true;
        _switchResult = "ReifiedRelationshipInstance";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, StructuredDataPropertyTuple.class)) {
        _matched=true;
        _switchResult = "StructuredDataPropertyTuple";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ScalarDataPropertyValue.class)) {
        _matched=true;
        _switchResult = "ScalarDataPropertyValue";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, SingletonInstanceStructuredDataPropertyValue.class)) {
        _matched=true;
        _switchResult = "SingletonInstanceStructuredDataPropertyValue";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, UnreifiedRelationshipInstanceTuple.class)) {
        _matched=true;
        _switchResult = "UnreifiedRelationshipInstanceTuple";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, EntityScalarDataProperty.class)) {
        _matched=true;
        _switchResult = "EntityScalarDataProperty";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, EntityStructuredDataProperty.class)) {
        _matched=true;
        _switchResult = "EntityStructuredDataProperty";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ScalarDataProperty.class)) {
        _matched=true;
        _switchResult = "ScalarDataProperty";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, StructuredDataProperty.class)) {
        _matched=true;
        _switchResult = "StructuredDataProperty";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, BinaryScalarRestriction.class)) {
        _matched=true;
        _switchResult = "BinaryScalarRestriction";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, IRIScalarRestriction.class)) {
        _matched=true;
        _switchResult = "IRIScalarRestriction";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, NumericScalarRestriction.class)) {
        _matched=true;
        _switchResult = "NumericScalarRestriction";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, PlainLiteralScalarRestriction.class)) {
        _matched=true;
        _switchResult = "PlainLiteralScalarRestriction";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ScalarOneOfRestriction.class)) {
        _matched=true;
        _switchResult = "ScalarOneOfRestriction";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, StringScalarRestriction.class)) {
        _matched=true;
        _switchResult = "StringScalarRestriction";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, SynonymScalarRestriction.class)) {
        _matched=true;
        _switchResult = "SynonymScalarRestriction";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, TimeScalarRestriction.class)) {
        _matched=true;
        _switchResult = "TimeScalarRestriction";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, Scalar.class)) {
        _matched=true;
        _switchResult = "Scalar";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, Structure.class)) {
        _matched=true;
        _switchResult = "Structure";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, Aspect.class)) {
        _matched=true;
        _switchResult = "Aspect";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, Concept.class)) {
        _matched=true;
        _switchResult = "Concept";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, ReifiedRelationship.class)) {
        _matched=true;
        _switchResult = "ReifiedRelationship";
      }
    }
    if (!_matched) {
      if (Objects.equal(e, UnreifiedRelationship.class)) {
        _matched=true;
        _switchResult = "UnreifiedRelationship";
      }
    }
    if (!_matched) {
      _switchResult = e.eClass().getName();
    }
    return _switchResult;
  }
}
