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
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement;
import gov.nasa.jpl.imce.oml.model.common.Annotation;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
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
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogManager;
import org.apache.xml.resolver.tools.CatalogResolver;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class OMLExtensions {
  public final static String OML_CATALOG_XML = "oml.catalog.xml";
  
  private final static String RESOURCE_SET_CATALOG_MANAGER = "RESOURCE_SET_CATALOG_MANAGER";
  
  private final static String RESOURCE_SET_CATALOG_RESOLVER = "RESOURCE_SET_CATALOG_RESOLVER";
  
  private final static String RESOURCE_SET_CATALOG_INSTANCE = "RESOURCE_SET_CATALOG_INSTANCE";
  
  public static CatalogManager getOrCreateCatalogManager(final ResourceSet rs) {
    Object _elvis = null;
    Map<Object, Object> _loadOptions = rs.getLoadOptions();
    Object _get = _loadOptions.get(OMLExtensions.RESOURCE_SET_CATALOG_MANAGER);
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
      Map<Object, Object> _loadOptions_1 = rs.getLoadOptions();
      _loadOptions_1.putIfAbsent(OMLExtensions.RESOURCE_SET_CATALOG_MANAGER, cm);
      return cm;
    } else {
      return null;
    }
  }
  
  public static CatalogResolver getOrCreateCatalogResolver(final ResourceSet rs) {
    Object _elvis = null;
    Map<Object, Object> _loadOptions = rs.getLoadOptions();
    Object _get = _loadOptions.get(OMLExtensions.RESOURCE_SET_CATALOG_RESOLVER);
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
      Map<Object, Object> _loadOptions_1 = rs.getLoadOptions();
      _loadOptions_1.putIfAbsent(OMLExtensions.RESOURCE_SET_CATALOG_RESOLVER, cr);
      return cr;
    } else {
      return null;
    }
  }
  
  public static OMLCatalog getCatalog(final ResourceSet rs) {
    Object _elvis = null;
    Map<Object, Object> _loadOptions = rs.getLoadOptions();
    Object _get = _loadOptions.get(OMLExtensions.RESOURCE_SET_CATALOG_INSTANCE);
    if (_get != null) {
      _elvis = _get;
    } else {
      CatalogResolver _orCreateCatalogResolver = OMLExtensions.getOrCreateCatalogResolver(rs);
      Catalog _catalog = _orCreateCatalogResolver.getCatalog();
      _elvis = _catalog;
    }
    final Object o = _elvis;
    boolean _isInstance = OMLCatalog.class.isInstance(o);
    if (_isInstance) {
      final OMLCatalog c = OMLCatalog.class.cast(o);
      Map<Object, Object> _loadOptions_1 = rs.getLoadOptions();
      _loadOptions_1.putIfAbsent(OMLExtensions.RESOURCE_SET_CATALOG_INSTANCE, c);
      return c;
    } else {
      return null;
    }
  }
  
  public static OMLCatalog findCatalogIfExists(final Resource r) {
    OMLCatalog _xblockexpression = null;
    {
      final ResourceSet rs = r.getResourceSet();
      URIConverter _uRIConverter = rs.getURIConverter();
      URI _uRI = r.getURI();
      final URI uri = _uRIConverter.normalize(_uRI);
      final URI ruri = CommonPlugin.resolve(uri);
      final URI luri = CommonPlugin.asLocalURI(ruri);
      URI _trimSegments = luri.trimSegments(1);
      _xblockexpression = OMLExtensions.findCatalogIfExists(rs, _trimSegments);
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
        final URI omlC = current.appendSegment(OMLExtensions.OML_CATALOG_XML);
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
        }
        return c;
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException ex = (IOException)_t;
          URI _trimSegments = current.trimSegments(1);
          current = _trimSegments;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return null;
  }
  
  public static String convertIRItoNamespace(final String iri) {
    String _xblockexpression = null;
    {
      final int index1 = iri.indexOf("://");
      final String pname = iri.substring((index1 + 3));
      final int index2 = pname.indexOf("/");
      String _xifexpression = null;
      if ((index2 > 0)) {
        _xifexpression = pname.substring(0, index2);
      } else {
        _xifexpression = pname;
      }
      final String domain = _xifexpression;
      String[] _split = domain.split("\\.");
      List<String> _reverse = ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(_split)));
      final String qprefix = IterableExtensions.join(_reverse, ".");
      String _xifexpression_1 = null;
      if ((index2 > 0)) {
        _xifexpression_1 = pname.substring(index2);
      } else {
        _xifexpression_1 = "";
      }
      final String qsuffix = _xifexpression_1;
      final String qname = (qprefix + qsuffix).replaceAll("[/-]", ".");
      _xblockexpression = qname;
    }
    return _xblockexpression;
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
      List<String> _map = ListExtensions.<Pair<String, String>, String>map(((List<Pair<String, String>>)Conversions.doWrapArray(factors)), _function);
      String _join = IterableExtensions.join(_map, ",");
      final String name = (namespace + _join);
      NameBasedGenerator _nameBasedGenerator = Generators.nameBasedGenerator(NameBasedGenerator.NAMESPACE_URL);
      _xblockexpression = _nameBasedGenerator.generate(name);
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
      List<String> _map = ListExtensions.<Pair<String, String>, String>map(((List<Pair<String, String>>)Conversions.doWrapArray(factors)), _function);
      String _join = IterableExtensions.join(_map, ",");
      final String name = (context + _join);
      NameBasedGenerator _nameBasedGenerator = Generators.nameBasedGenerator(NameBasedGenerator.NAMESPACE_URL);
      _xblockexpression = _nameBasedGenerator.generate(name);
    }
    return _xblockexpression;
  }
  
  public static String getModuleNsURI(final Module it) {
    String _elvis = null;
    EList<Annotation> _annotations = it.getAnnotations();
    final Function1<Annotation, Boolean> _function = (Annotation a) -> {
      AnnotationProperty _property = a.getProperty();
      String _iri = _property.getIri();
      return Boolean.valueOf(Objects.equal(_iri, "http://imce.jpl.nasa.gov/oml/runtime#OML2EcoreNsURI"));
    };
    Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_annotations, _function);
    String _value = null;
    if (_findFirst!=null) {
      _value=_findFirst.getValue();
    }
    if (_value != null) {
      _elvis = _value;
    } else {
      String _iri = it.iri();
      _elvis = _iri;
    }
    return _elvis;
  }
  
  public static String getModuleNsPrefix(final Module it) {
    String _elvis = null;
    EList<Annotation> _annotations = it.getAnnotations();
    final Function1<Annotation, Boolean> _function = (Annotation a) -> {
      AnnotationProperty _property = a.getProperty();
      String _iri = _property.getIri();
      return Boolean.valueOf(Objects.equal(_iri, "http://imce.jpl.nasa.gov/oml/runtime#OML2EcoreNsPrefix"));
    };
    Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_annotations, _function);
    String _value = null;
    if (_findFirst!=null) {
      _value=_findFirst.getValue();
    }
    if (_value != null) {
      _elvis = _value;
    } else {
      String _name = it.name();
      _elvis = _name;
    }
    return _elvis;
  }
  
  public Iterable<TerminologyBox> terminologies(final Extent it) {
    EList<Module> _modules = it.getModules();
    return Iterables.<TerminologyBox>filter(_modules, TerminologyBox.class);
  }
  
  public Iterable<TerminologyGraph> terminologyGraphs(final Extent it) {
    EList<Module> _modules = it.getModules();
    return Iterables.<TerminologyGraph>filter(_modules, TerminologyGraph.class);
  }
  
  public Iterable<DescriptionBox> descriptions(final Extent it) {
    EList<Module> _modules = it.getModules();
    return Iterables.<DescriptionBox>filter(_modules, DescriptionBox.class);
  }
  
  public Iterable<Bundle> bundles(final Extent it) {
    EList<Module> _modules = it.getModules();
    return Iterables.<Bundle>filter(_modules, Bundle.class);
  }
  
  public void phasedResolveAll(final Extent it) {
    EList<Module> _modules = it.getModules();
    final Consumer<Module> _function = (Module it_1) -> {
      EList<ModuleEdge> _moduleEdges = it_1.moduleEdges();
      final Consumer<ModuleEdge> _function_1 = (ModuleEdge it_2) -> {
        Module _targetModule = it_2.targetModule();
        EcoreUtil.resolveAll(_targetModule);
      };
      _moduleEdges.forEach(_function_1);
    };
    _modules.forEach(_function);
  }
  
  public Iterable<TerminologyBox> allImportedTerminologies(final TerminologyBox it) {
    ArrayList<TerminologyBox> _newArrayList = Lists.<TerminologyBox>newArrayList(it);
    ArrayList<TerminologyBox> _newArrayList_1 = Lists.<TerminologyBox>newArrayList(it);
    return this.collectAllImportedTerminologies(_newArrayList, _newArrayList_1);
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
      EList<ModuleEdge> _moduleEdges = tbox.moduleEdges();
      final Function1<ModuleEdge, Module> _function = (ModuleEdge it) -> {
        return it.targetModule();
      };
      List<Module> _map = ListExtensions.<ModuleEdge, Module>map(_moduleEdges, _function);
      Iterable<Module> _filterNull = IterableExtensions.<Module>filterNull(_map);
      final Iterable<TerminologyBox> inc = Iterables.<TerminologyBox>filter(_filterNull, TerminologyBox.class);
      Iterables.<TerminologyBox>addAll(queue, inc);
      Iterables.<TerminologyBox>addAll(acc, inc);
      _xblockexpression = this.collectAllImportedTerminologies(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<Module> allImportedModules(final Module it) {
    ArrayList<Module> _newArrayList = Lists.<Module>newArrayList(it);
    ArrayList<Module> _newArrayList_1 = Lists.<Module>newArrayList(it);
    return this.collectAllImportedModules(_newArrayList, _newArrayList_1);
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
      EList<ModuleEdge> _moduleEdges = m.moduleEdges();
      final Function1<ModuleEdge, Module> _function = (ModuleEdge it) -> {
        return it.targetModule();
      };
      List<Module> _map = ListExtensions.<ModuleEdge, Module>map(_moduleEdges, _function);
      final Iterable<Module> inc = IterableExtensions.<Module>filterNull(_map);
      Iterables.<Module>addAll(queue, inc);
      Iterables.<Module>addAll(acc, inc);
      _xblockexpression = this.collectAllImportedModules(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<Entity> localEntities(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<Entity>filter(_boxStatements, Entity.class);
  }
  
  public Iterable<Entity> allEntities(final TerminologyBox it) {
    Iterable<Entity> _localEntities = this.localEntities(it);
    Iterable<TerminologyBox> _allImportedTerminologies = this.allImportedTerminologies(it);
    final Function1<TerminologyBox, Iterable<Entity>> _function = (TerminologyBox it_1) -> {
      return this.localEntities(it_1);
    };
    Iterable<Iterable<Entity>> _map = IterableExtensions.<TerminologyBox, Iterable<Entity>>map(_allImportedTerminologies, _function);
    Iterable<Entity> _flatten = Iterables.<Entity>concat(_map);
    return Iterables.<Entity>concat(_localEntities, _flatten);
  }
  
  public Iterable<Aspect> localAspects(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<Aspect>filter(_boxStatements, Aspect.class);
  }
  
  public Iterable<Aspect> allAspects(final TerminologyBox it) {
    Iterable<Aspect> _localAspects = this.localAspects(it);
    Iterable<TerminologyBox> _allImportedTerminologies = this.allImportedTerminologies(it);
    final Function1<TerminologyBox, Iterable<Aspect>> _function = (TerminologyBox it_1) -> {
      return this.localAspects(it_1);
    };
    Iterable<Iterable<Aspect>> _map = IterableExtensions.<TerminologyBox, Iterable<Aspect>>map(_allImportedTerminologies, _function);
    Iterable<Aspect> _flatten = Iterables.<Aspect>concat(_map);
    return Iterables.<Aspect>concat(_localAspects, _flatten);
  }
  
  public Iterable<Concept> localConcepts(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<Concept>filter(_boxStatements, Concept.class);
  }
  
  public Iterable<Concept> allConcepts(final TerminologyBox it) {
    Iterable<Concept> _localConcepts = this.localConcepts(it);
    Iterable<TerminologyBox> _allImportedTerminologies = this.allImportedTerminologies(it);
    final Function1<TerminologyBox, Iterable<Concept>> _function = (TerminologyBox it_1) -> {
      return this.localConcepts(it_1);
    };
    Iterable<Iterable<Concept>> _map = IterableExtensions.<TerminologyBox, Iterable<Concept>>map(_allImportedTerminologies, _function);
    Iterable<Concept> _flatten = Iterables.<Concept>concat(_map);
    return Iterables.<Concept>concat(_localConcepts, _flatten);
  }
  
  public Iterable<ReifiedRelationship> localReifiedRelationships(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<ReifiedRelationship>filter(_boxStatements, ReifiedRelationship.class);
  }
  
  public Iterable<UnreifiedRelationship> localUnreifiedRelationships(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<UnreifiedRelationship>filter(_boxStatements, UnreifiedRelationship.class);
  }
  
  public Iterable<ReifiedRelationship> allReifiedRelationships(final TerminologyBox it) {
    Iterable<ReifiedRelationship> _localReifiedRelationships = this.localReifiedRelationships(it);
    Iterable<TerminologyBox> _allImportedTerminologies = this.allImportedTerminologies(it);
    final Function1<TerminologyBox, Iterable<ReifiedRelationship>> _function = (TerminologyBox it_1) -> {
      return this.localReifiedRelationships(it_1);
    };
    Iterable<Iterable<ReifiedRelationship>> _map = IterableExtensions.<TerminologyBox, Iterable<ReifiedRelationship>>map(_allImportedTerminologies, _function);
    Iterable<ReifiedRelationship> _flatten = Iterables.<ReifiedRelationship>concat(_map);
    return Iterables.<ReifiedRelationship>concat(_localReifiedRelationships, _flatten);
  }
  
  public Iterable<EntityRelationship> localEntityRelationships(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<EntityRelationship>filter(_boxStatements, EntityRelationship.class);
  }
  
  public Iterable<EntityRelationship> allEntityRelationships(final TerminologyBox it) {
    Iterable<EntityRelationship> _localEntityRelationships = this.localEntityRelationships(it);
    Iterable<TerminologyBox> _allImportedTerminologies = this.allImportedTerminologies(it);
    final Function1<TerminologyBox, Iterable<EntityRelationship>> _function = (TerminologyBox it_1) -> {
      return this.localEntityRelationships(it_1);
    };
    Iterable<Iterable<EntityRelationship>> _map = IterableExtensions.<TerminologyBox, Iterable<EntityRelationship>>map(_allImportedTerminologies, _function);
    Iterable<EntityRelationship> _flatten = Iterables.<EntityRelationship>concat(_map);
    return Iterables.<EntityRelationship>concat(_localEntityRelationships, _flatten);
  }
  
  public Iterable<DataRange> localRanges(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<DataRange>filter(_boxStatements, DataRange.class);
  }
  
  public Iterable<Structure> localStructures(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<Structure>filter(_boxStatements, Structure.class);
  }
  
  public Iterable<EntityScalarDataProperty> localEntityScalarDataProperties(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<EntityScalarDataProperty>filter(_boxStatements, EntityScalarDataProperty.class);
  }
  
  public Iterable<EntityStructuredDataProperty> localEntityStructuredDataProperties(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<EntityStructuredDataProperty>filter(_boxStatements, EntityStructuredDataProperty.class);
  }
  
  public Iterable<ScalarDataProperty> localScalarDataProperties(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<ScalarDataProperty>filter(_boxStatements, ScalarDataProperty.class);
  }
  
  public Iterable<StructuredDataProperty> localStructuredDataProperties(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<StructuredDataProperty>filter(_boxStatements, StructuredDataProperty.class);
  }
  
  public Iterable<ScalarOneOfRestriction> localScalarOneOfRestrictions(final TerminologyBox it) {
    EList<TerminologyBoxStatement> _boxStatements = it.getBoxStatements();
    return Iterables.<ScalarOneOfRestriction>filter(_boxStatements, ScalarOneOfRestriction.class);
  }
  
  public Iterable<Bundle> allImportedBundles(final Bundle it) {
    ArrayList<Bundle> _newArrayList = Lists.<Bundle>newArrayList(it);
    ArrayList<Bundle> _newArrayList_1 = Lists.<Bundle>newArrayList(it);
    return this.collectAllImportedBundles(_newArrayList, _newArrayList_1);
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
      EList<TerminologyBundleAxiom> _bundleAxioms = bundle.getBundleAxioms();
      final Function1<TerminologyBundleAxiom, TerminologyBox> _function = (TerminologyBundleAxiom it) -> {
        return it.target();
      };
      List<TerminologyBox> _map = ListExtensions.<TerminologyBundleAxiom, TerminologyBox>map(_bundleAxioms, _function);
      final Iterable<Bundle> inc = Iterables.<Bundle>filter(_map, Bundle.class);
      Iterables.<Bundle>addAll(queue, inc);
      Iterables.<Bundle>addAll(acc, inc);
      _xblockexpression = this.collectAllImportedBundles(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<AnonymousConceptUnionAxiom> localAnonymousConceptUnionAxioms(final Bundle it) {
    EList<TerminologyBundleStatement> _bundleStatements = it.getBundleStatements();
    return Iterables.<AnonymousConceptUnionAxiom>filter(_bundleStatements, AnonymousConceptUnionAxiom.class);
  }
  
  public Iterable<RootConceptTaxonomyAxiom> localRootConceptTaxonomyAxioms(final Bundle it) {
    EList<TerminologyBundleStatement> _bundleStatements = it.getBundleStatements();
    return Iterables.<RootConceptTaxonomyAxiom>filter(_bundleStatements, RootConceptTaxonomyAxiom.class);
  }
  
  public Iterable<TerminologyBox> allImportedTerminologiesFromDescription(final DescriptionBox it) {
    ArrayList<DescriptionBox> _newArrayList = Lists.<DescriptionBox>newArrayList(it);
    HashSet<TerminologyBox> _newHashSet = Sets.<TerminologyBox>newHashSet();
    return this.collectAllImportedTerminologiesFromDescription(_newArrayList, _newHashSet);
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
      EList<DescriptionBoxRefinement> _descriptionBoxRefinements = dbox.getDescriptionBoxRefinements();
      final Function1<DescriptionBoxRefinement, DescriptionBox> _function = (DescriptionBoxRefinement it) -> {
        return it.getRefinedDescriptionBox();
      };
      final List<DescriptionBox> incd = ListExtensions.<DescriptionBoxRefinement, DescriptionBox>map(_descriptionBoxRefinements, _function);
      queue.addAll(incd);
      EList<DescriptionBoxExtendsClosedWorldDefinitions> _closedWorldDefinitions = dbox.getClosedWorldDefinitions();
      final Function1<DescriptionBoxExtendsClosedWorldDefinitions, TerminologyBox> _function_1 = (DescriptionBoxExtendsClosedWorldDefinitions it) -> {
        return it.getClosedWorldDefinitions();
      };
      List<TerminologyBox> _map = ListExtensions.<DescriptionBoxExtendsClosedWorldDefinitions, TerminologyBox>map(_closedWorldDefinitions, _function_1);
      final Function1<TerminologyBox, Iterable<TerminologyBox>> _function_2 = (TerminologyBox it) -> {
        return this.allImportedTerminologies(it);
      };
      List<Iterable<TerminologyBox>> _map_1 = ListExtensions.<TerminologyBox, Iterable<TerminologyBox>>map(_map, _function_2);
      final Iterable<TerminologyBox> inct = Iterables.<TerminologyBox>concat(_map_1);
      Iterables.<TerminologyBox>addAll(acc, inct);
      _xblockexpression = this.collectAllImportedTerminologiesFromDescription(queue, acc);
    }
    return _xblockexpression;
  }
  
  public Iterable<DescriptionBox> allImportedDescriptions(final DescriptionBox it) {
    ArrayList<DescriptionBox> _newArrayList = Lists.<DescriptionBox>newArrayList(it);
    ArrayList<DescriptionBox> _newArrayList_1 = Lists.<DescriptionBox>newArrayList(it);
    return this.collectAllImportedDescriptions(_newArrayList, _newArrayList_1);
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
      EList<DescriptionBoxRefinement> _descriptionBoxRefinements = dbox.getDescriptionBoxRefinements();
      final Function1<DescriptionBoxRefinement, DescriptionBox> _function = (DescriptionBoxRefinement it) -> {
        return it.getRefinedDescriptionBox();
      };
      final List<DescriptionBox> inc = ListExtensions.<DescriptionBoxRefinement, DescriptionBox>map(_descriptionBoxRefinements, _function);
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
      EClass _eClass = e.eClass();
      _switchResult = _eClass.getName();
    }
    return _switchResult;
  }
}
