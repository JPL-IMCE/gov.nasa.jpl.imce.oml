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
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleAxiom;
import gov.nasa.jpl.imce.oml.model.bundles.TerminologyBundleStatement;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LiteralBoolean;
import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime;
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal;
import gov.nasa.jpl.imce.oml.model.common.LiteralFloat;
import gov.nasa.jpl.imce.oml.model.common.LiteralQuotedString;
import gov.nasa.jpl.imce.oml.model.common.LiteralRational;
import gov.nasa.jpl.imce.oml.model.common.LiteralRawString;
import gov.nasa.jpl.imce.oml.model.common.LiteralReal;
import gov.nasa.jpl.imce.oml.model.common.LiteralString;
import gov.nasa.jpl.imce.oml.model.common.LiteralURI;
import gov.nasa.jpl.imce.oml.model.common.LiteralUUID;
import gov.nasa.jpl.imce.oml.model.common.LiteralValue;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.datatypes.StringValue;
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
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple;
import gov.nasa.jpl.imce.oml.model.extensions.CatalogURIConverter;
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalogManager;
import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectKind;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedAspect;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedConcept;
import gov.nasa.jpl.imce.oml.model.terminologies.CardinalityRestrictedReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ChainRule;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptKind;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Predicate;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictableRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Structure;
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import org.apache.xml.resolver.Catalog;
import org.apache.xml.resolver.CatalogManager;
import org.apache.xml.resolver.tools.CatalogResolver;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
  public static final class KeyComparator<T extends Object, C extends Comparable<? super C>> implements Comparator<T> {
    private final Function1<? super T, C> keyFunction;
    
    /**
     * @param keyFunction
     *            the key function to use for comparing objects. May not be <code>null</code>
     */
    public KeyComparator(final Function1<? super T, C> keyFunction) {
      this.keyFunction = Preconditions.<Function1<? super T, C>>checkNotNull(keyFunction, "keyFunction");
    }
    
    @Override
    public int compare(final T a, final T b) {
      final C c1 = this.keyFunction.apply(a);
      final C c2 = this.keyFunction.apply(b);
      boolean _equals = Objects.equal(c1, c2);
      if (_equals) {
        return 0;
      } else {
        if ((c1 != null)) {
          return c1.compareTo(c2);
        } else {
          int _compareTo = c2.compareTo(c1);
          return (-_compareTo);
        }
      }
    }
  }
  
  public final static String OML_CATALOG_XML = "oml.catalog.xml";
  
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
      final URIConverter prevConverter = rs.getURIConverter();
      boolean _matched = false;
      if (prevConverter instanceof CatalogURIConverter) {
        _matched=true;
      }
      if (!_matched) {
        {
          URIConverter _uRIConverter = rs.getURIConverter();
          final CatalogURIConverter omlc = new CatalogURIConverter(c, _uRIConverter);
          rs.setURIConverter(omlc);
        }
      }
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
          current = current.trimSegments(1);
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
      final String qprefix = IterableExtensions.join(ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(domain.split("\\.")))), ".");
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
  
  public static UUID derivedUUID(final String context, final Pair<String, String> factor1, final Pair<String, String> factor2, final Pair<String, String> factor3, final Pair<String, String> factor4, final Pair<String, String> factor5, final Pair<String, String> factor6) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      factors.add(factor2);
      factors.add(factor3);
      factors.add(factor4);
      factors.add(factor5);
      factors.add(factor6);
      _xblockexpression = OMLExtensions.derivedUUID(context, ((Pair<String, String>[])Conversions.unwrapArray(factors, Pair.class)));
    }
    return _xblockexpression;
  }
  
  public static UUID derivedUUID(final String context, final Pair<String, String> factor1, final Pair<String, String> factor2, final Pair<String, String> factor3, final Pair<String, String> factor4, final Pair<String, String> factor5, final Pair<String, String> factor6, final Pair<String, String> factor7) {
    UUID _xblockexpression = null;
    {
      final ArrayList<Pair<String, String>> factors = new ArrayList<Pair<String, String>>();
      factors.add(factor1);
      factors.add(factor2);
      factors.add(factor3);
      factors.add(factor4);
      factors.add(factor5);
      factors.add(factor6);
      factors.add(factor7);
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
  
  public static String getModuleNsURI(final gov.nasa.jpl.imce.oml.model.common.Module it) {
    String _elvis = null;
    final Function1<AnnotationPropertyValue, Boolean> _function = (AnnotationPropertyValue a) -> {
      String _iri = a.getProperty().iri();
      return Boolean.valueOf(Objects.equal(_iri, "http://imce.jpl.nasa.gov/oml/runtime#OML2EcoreNsURI"));
    };
    AnnotationPropertyValue _findFirst = IterableExtensions.<AnnotationPropertyValue>findFirst(it.getAnnotations(), _function);
    LiteralString _value = null;
    if (_findFirst!=null) {
      _value=_findFirst.getValue();
    }
    StringValue _stringValue = null;
    if (_value!=null) {
      _stringValue=_value.stringValue();
    }
    String _value_1 = null;
    if (_stringValue!=null) {
      _value_1=_stringValue.value;
    }
    if (_value_1 != null) {
      _elvis = _value_1;
    } else {
      String _iri = it.iri();
      _elvis = _iri;
    }
    return _elvis;
  }
  
  public static String getModuleNsPrefix(final gov.nasa.jpl.imce.oml.model.common.Module it) {
    String _elvis = null;
    final Function1<AnnotationPropertyValue, Boolean> _function = (AnnotationPropertyValue a) -> {
      String _iri = a.getProperty().iri();
      return Boolean.valueOf(Objects.equal(_iri, "http://imce.jpl.nasa.gov/oml/runtime#OML2EcoreNsPrefix"));
    };
    AnnotationPropertyValue _findFirst = IterableExtensions.<AnnotationPropertyValue>findFirst(it.getAnnotations(), _function);
    LiteralString _value = null;
    if (_findFirst!=null) {
      _value=_findFirst.getValue();
    }
    StringValue _stringValue = null;
    if (_value!=null) {
      _stringValue=_value.stringValue();
    }
    String _value_1 = null;
    if (_stringValue!=null) {
      _value_1=_stringValue.value;
    }
    if (_value_1 != null) {
      _elvis = _value_1;
    } else {
      String _name = it.name();
      _elvis = _name;
    }
    return _elvis;
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
    final Consumer<gov.nasa.jpl.imce.oml.model.common.Module> _function = (gov.nasa.jpl.imce.oml.model.common.Module it_1) -> {
      final Consumer<ModuleEdge> _function_1 = (ModuleEdge it_2) -> {
        EcoreUtil.resolveAll(it_2.targetModule());
      };
      it_1.moduleEdges().forEach(_function_1);
    };
    it.getModules().forEach(_function);
  }
  
  public static Iterable<TerminologyBox> allImportedTerminologies(final TerminologyBox it) {
    return OMLExtensions.collectAllImportedTerminologies(Lists.<TerminologyBox>newArrayList(it), Lists.<TerminologyBox>newArrayList(it), Sets.<TerminologyBox>newHashSet(it));
  }
  
  public static final Iterable<TerminologyBox> collectAllImportedTerminologies(final ArrayList<TerminologyBox> queue, final ArrayList<TerminologyBox> acc, final HashSet<TerminologyBox> visited) {
    Iterable<TerminologyBox> _xblockexpression = null;
    {
      boolean _isEmpty = queue.isEmpty();
      if (_isEmpty) {
        return acc;
      }
      final TerminologyBox tbox = IterableExtensions.<TerminologyBox>head(queue);
      queue.remove(tbox);
      final Function1<ModuleEdge, gov.nasa.jpl.imce.oml.model.common.Module> _function = (ModuleEdge it) -> {
        return it.targetModule();
      };
      final Function1<TerminologyBox, Boolean> _function_1 = (TerminologyBox it) -> {
        return Boolean.valueOf(visited.contains(it));
      };
      final Iterable<TerminologyBox> inc = IterableExtensions.<TerminologyBox>reject(Iterables.<TerminologyBox>filter(IterableExtensions.<gov.nasa.jpl.imce.oml.model.common.Module>filterNull(ListExtensions.<ModuleEdge, gov.nasa.jpl.imce.oml.model.common.Module>map(tbox.moduleEdges(), _function)), TerminologyBox.class), _function_1);
      Iterables.<TerminologyBox>addAll(queue, inc);
      Iterables.<TerminologyBox>addAll(acc, inc);
      Iterables.<TerminologyBox>addAll(visited, inc);
      _xblockexpression = OMLExtensions.collectAllImportedTerminologies(queue, acc, visited);
    }
    return _xblockexpression;
  }
  
  public Iterable<gov.nasa.jpl.imce.oml.model.common.Module> allImportedModules(final gov.nasa.jpl.imce.oml.model.common.Module it) {
    return this.collectAllImportedModules(Lists.<gov.nasa.jpl.imce.oml.model.common.Module>newArrayList(it), Lists.<gov.nasa.jpl.imce.oml.model.common.Module>newArrayList(it), Sets.<gov.nasa.jpl.imce.oml.model.common.Module>newHashSet(it));
  }
  
  public final Iterable<gov.nasa.jpl.imce.oml.model.common.Module> collectAllImportedModules(final ArrayList<gov.nasa.jpl.imce.oml.model.common.Module> queue, final ArrayList<gov.nasa.jpl.imce.oml.model.common.Module> acc, final HashSet<gov.nasa.jpl.imce.oml.model.common.Module> visited) {
    Iterable<gov.nasa.jpl.imce.oml.model.common.Module> _xblockexpression = null;
    {
      boolean _isEmpty = queue.isEmpty();
      if (_isEmpty) {
        return acc;
      }
      final gov.nasa.jpl.imce.oml.model.common.Module m = IterableExtensions.<gov.nasa.jpl.imce.oml.model.common.Module>head(queue);
      queue.remove(m);
      final Function1<ModuleEdge, gov.nasa.jpl.imce.oml.model.common.Module> _function = (ModuleEdge it) -> {
        return it.targetModule();
      };
      final Function1<gov.nasa.jpl.imce.oml.model.common.Module, Boolean> _function_1 = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
        return Boolean.valueOf(visited.contains(it));
      };
      final Iterable<gov.nasa.jpl.imce.oml.model.common.Module> inc = IterableExtensions.<gov.nasa.jpl.imce.oml.model.common.Module>reject(IterableExtensions.<gov.nasa.jpl.imce.oml.model.common.Module>filterNull(ListExtensions.<ModuleEdge, gov.nasa.jpl.imce.oml.model.common.Module>map(m.moduleEdges(), _function)), _function_1);
      Iterables.<gov.nasa.jpl.imce.oml.model.common.Module>addAll(queue, inc);
      Iterables.<gov.nasa.jpl.imce.oml.model.common.Module>addAll(acc, inc);
      Iterables.<gov.nasa.jpl.imce.oml.model.common.Module>addAll(visited, inc);
      _xblockexpression = this.collectAllImportedModules(queue, acc, visited);
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
    Iterable<Entity> _flatten = Iterables.<Entity>concat(IterableExtensions.<TerminologyBox, Iterable<Entity>>map(OMLExtensions.allImportedTerminologies(it), _function));
    return Iterables.<Entity>concat(_localEntities, _flatten);
  }
  
  public Iterable<ConceptualEntity> localConceptualEntities(final TerminologyBox it) {
    return Iterables.<ConceptualEntity>filter(it.getBoxStatements(), ConceptualEntity.class);
  }
  
  public Iterable<ConceptualEntity> allConceptualEntities(final TerminologyBox it) {
    Iterable<ConceptualEntity> _localConceptualEntities = this.localConceptualEntities(it);
    final Function1<TerminologyBox, Iterable<ConceptualEntity>> _function = (TerminologyBox it_1) -> {
      return this.localConceptualEntities(it_1);
    };
    Iterable<ConceptualEntity> _flatten = Iterables.<ConceptualEntity>concat(IterableExtensions.<TerminologyBox, Iterable<ConceptualEntity>>map(OMLExtensions.allImportedTerminologies(it), _function));
    return Iterables.<ConceptualEntity>concat(_localConceptualEntities, _flatten);
  }
  
  public Iterable<AspectKind> localAspects(final TerminologyBox it) {
    return Iterables.<AspectKind>filter(it.getBoxStatements(), AspectKind.class);
  }
  
  public Iterable<AspectKind> allAspects(final TerminologyBox it) {
    Iterable<AspectKind> _localAspects = this.localAspects(it);
    final Function1<TerminologyBox, Iterable<AspectKind>> _function = (TerminologyBox it_1) -> {
      return this.localAspects(it_1);
    };
    Iterable<AspectKind> _flatten = Iterables.<AspectKind>concat(IterableExtensions.<TerminologyBox, Iterable<AspectKind>>map(OMLExtensions.allImportedTerminologies(it), _function));
    return Iterables.<AspectKind>concat(_localAspects, _flatten);
  }
  
  public Iterable<ConceptKind> localConcepts(final TerminologyBox it) {
    return Iterables.<ConceptKind>filter(it.getBoxStatements(), ConceptKind.class);
  }
  
  public Iterable<ConceptKind> allConcepts(final TerminologyBox it) {
    Iterable<ConceptKind> _localConcepts = this.localConcepts(it);
    final Function1<TerminologyBox, Iterable<ConceptKind>> _function = (TerminologyBox it_1) -> {
      return this.localConcepts(it_1);
    };
    Iterable<ConceptKind> _flatten = Iterables.<ConceptKind>concat(IterableExtensions.<TerminologyBox, Iterable<ConceptKind>>map(OMLExtensions.allImportedTerminologies(it), _function));
    return Iterables.<ConceptKind>concat(_localConcepts, _flatten);
  }
  
  public Iterable<ConceptualRelationship> localConceptualRelationships(final TerminologyBox it) {
    return Iterables.<ConceptualRelationship>filter(it.getBoxStatements(), ConceptualRelationship.class);
  }
  
  public Iterable<ReifiedRelationshipRestriction> localReifiedRelationshipRestrictions(final TerminologyBox it) {
    return Iterables.<ReifiedRelationshipRestriction>filter(it.getBoxStatements(), ReifiedRelationshipRestriction.class);
  }
  
  public Iterable<ConceptualRelationship> localReifiedRelationships(final TerminologyBox it) {
    return Iterables.<ConceptualRelationship>filter(it.getBoxStatements(), ConceptualRelationship.class);
  }
  
  public Iterable<UnreifiedRelationship> localUnreifiedRelationships(final TerminologyBox it) {
    return Iterables.<UnreifiedRelationship>filter(it.getBoxStatements(), UnreifiedRelationship.class);
  }
  
  public Iterable<ConceptualRelationship> allReifiedRelationships(final TerminologyBox it) {
    Iterable<ConceptualRelationship> _localReifiedRelationships = this.localReifiedRelationships(it);
    final Function1<TerminologyBox, Iterable<ConceptualRelationship>> _function = (TerminologyBox it_1) -> {
      return this.localReifiedRelationships(it_1);
    };
    Iterable<ConceptualRelationship> _flatten = Iterables.<ConceptualRelationship>concat(IterableExtensions.<TerminologyBox, Iterable<ConceptualRelationship>>map(OMLExtensions.allImportedTerminologies(it), _function));
    return Iterables.<ConceptualRelationship>concat(_localReifiedRelationships, _flatten);
  }
  
  public Iterable<EntityRelationship> localEntityRelationships(final TerminologyBox it) {
    return Iterables.<EntityRelationship>filter(it.getBoxStatements(), EntityRelationship.class);
  }
  
  public Iterable<Predicate> localPredicates(final TerminologyBox it) {
    Iterable<Predicate> _xblockexpression = null;
    {
      final ArrayList<Predicate> result = new ArrayList<Predicate>();
      final Consumer<ConceptualRelationship> _function = (ConceptualRelationship rr) -> {
        boolean _matched = false;
        if (rr instanceof ReifiedRelationship) {
          _matched=true;
          result.add(((ReifiedRelationship)rr).getForwardProperty());
          result.add(((ReifiedRelationship)rr).getInverseProperty());
        }
      };
      this.localReifiedRelationships(it).forEach(_function);
      Iterables.<Predicate>addAll(result, this.localUnreifiedRelationships(it));
      Iterables.<Predicate>addAll(result, this.localEntities(it));
      _xblockexpression = IterableExtensions.<Predicate>filterNull(result);
    }
    return _xblockexpression;
  }
  
  public Iterable<ForwardProperty> localForwardProperties(final TerminologyBox it) {
    final Function1<ConceptualRelationship, ForwardProperty> _function = (ConceptualRelationship rr) -> {
      ForwardProperty _switchResult = null;
      boolean _matched = false;
      if (rr instanceof ReifiedRelationship) {
        _matched=true;
        _switchResult = ((ReifiedRelationship)rr).getForwardProperty();
      }
      if (!_matched) {
        _switchResult = null;
      }
      return _switchResult;
    };
    return IterableExtensions.<ForwardProperty>filterNull(IterableExtensions.<ConceptualRelationship, ForwardProperty>map(this.localReifiedRelationships(it), _function));
  }
  
  public Iterable<InverseProperty> localInverseProperties(final TerminologyBox it) {
    final Function1<ConceptualRelationship, InverseProperty> _function = (ConceptualRelationship rr) -> {
      InverseProperty _switchResult = null;
      boolean _matched = false;
      if (rr instanceof ReifiedRelationship) {
        _matched=true;
        _switchResult = ((ReifiedRelationship)rr).getInverseProperty();
      }
      if (!_matched) {
        _switchResult = null;
      }
      return _switchResult;
    };
    return IterableExtensions.<InverseProperty>filterNull(IterableExtensions.<ConceptualRelationship, InverseProperty>map(this.localReifiedRelationships(it), _function));
  }
  
  public Iterable<RestrictableRelationship> localRestrictableRelationships(final TerminologyBox it) {
    Iterable<RestrictableRelationship> _xblockexpression = null;
    {
      final ArrayList<RestrictableRelationship> result = new ArrayList<RestrictableRelationship>();
      final Consumer<ConceptualRelationship> _function = (ConceptualRelationship rr) -> {
        boolean _matched = false;
        if (rr instanceof ReifiedRelationship) {
          _matched=true;
          result.add(((ReifiedRelationship)rr).getForwardProperty());
          result.add(((ReifiedRelationship)rr).getInverseProperty());
        }
      };
      this.localReifiedRelationships(it).forEach(_function);
      Iterables.<RestrictableRelationship>addAll(result, this.localUnreifiedRelationships(it));
      _xblockexpression = IterableExtensions.<RestrictableRelationship>filterNull(result);
    }
    return _xblockexpression;
  }
  
  public Iterable<EntityRelationship> allEntityRelationships(final TerminologyBox it) {
    Iterable<EntityRelationship> _localEntityRelationships = this.localEntityRelationships(it);
    final Function1<TerminologyBox, Iterable<EntityRelationship>> _function = (TerminologyBox it_1) -> {
      return this.localEntityRelationships(it_1);
    };
    Iterable<EntityRelationship> _flatten = Iterables.<EntityRelationship>concat(IterableExtensions.<TerminologyBox, Iterable<EntityRelationship>>map(OMLExtensions.allImportedTerminologies(it), _function));
    return Iterables.<EntityRelationship>concat(_localEntityRelationships, _flatten);
  }
  
  public static EList<ReifiedRelationship> rootReifiedRelationships(final ReifiedRelationshipRestriction prr) {
    EList<ReifiedRelationship> _xblockexpression = null;
    {
      final HashSet<ReifiedRelationship> result = new HashSet<ReifiedRelationship>();
      final HashSet<ConceptualRelationship> horizon = new HashSet<ConceptualRelationship>();
      horizon.add(prr);
      final HashSet<ReifiedRelationshipSpecializationAxiom> candidates = new HashSet<ReifiedRelationshipSpecializationAxiom>();
      final Function1<TerminologyBox, Iterable<ReifiedRelationshipSpecializationAxiom>> _function = (TerminologyBox it) -> {
        return Iterables.<ReifiedRelationshipSpecializationAxiom>filter(it.getBoxStatements(), ReifiedRelationshipSpecializationAxiom.class);
      };
      final Iterable<ReifiedRelationshipSpecializationAxiom> rrs = Iterables.<ReifiedRelationshipSpecializationAxiom>concat(IterableExtensions.<TerminologyBox, Iterable<ReifiedRelationshipSpecializationAxiom>>map(OMLExtensions.allImportedTerminologies(prr.getTbox()), _function));
      Iterables.<ReifiedRelationshipSpecializationAxiom>addAll(candidates, rrs);
      boolean more = false;
      do {
        {
          more = false;
          final Function1<ReifiedRelationshipSpecializationAxiom, Boolean> _function_1 = (ReifiedRelationshipSpecializationAxiom ax) -> {
            return Boolean.valueOf(horizon.contains(ax.getSubRelationship()));
          };
          final List<ReifiedRelationshipSpecializationAxiom> axioms = IterableExtensions.<ReifiedRelationshipSpecializationAxiom>toList(IterableExtensions.<ReifiedRelationshipSpecializationAxiom>filter(candidates, _function_1));
          boolean _isEmpty = axioms.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            horizon.clear();
            final Function1<ReifiedRelationshipSpecializationAxiom, ConceptualRelationship> _function_2 = (ReifiedRelationshipSpecializationAxiom it) -> {
              return it.getSuperRelationship();
            };
            final List<ConceptualRelationship> parents = ListExtensions.<ReifiedRelationshipSpecializationAxiom, ConceptualRelationship>map(axioms, _function_2);
            final Iterable<ReifiedRelationship> moreReifiedRelationships = Iterables.<ReifiedRelationship>filter(parents, ReifiedRelationship.class);
            Iterables.<ReifiedRelationship>addAll(result, moreReifiedRelationships);
            final Iterable<ReifiedRelationshipRestriction> moreReifiedRelationshipRestrictions = Iterables.<ReifiedRelationshipRestriction>filter(parents, ReifiedRelationshipRestriction.class);
            Iterables.<ConceptualRelationship>addAll(horizon, moreReifiedRelationshipRestrictions);
            boolean _isEmpty_1 = horizon.isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            more = _not_1;
          }
        }
      } while(more);
      _xblockexpression = ECollections.<ReifiedRelationship>asEList(((ReifiedRelationship[])Conversions.unwrapArray(result, ReifiedRelationship.class)));
    }
    return _xblockexpression;
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
    return this.collectAllImportedBundles(Lists.<Bundle>newArrayList(it), Lists.<Bundle>newArrayList(it), Sets.<Bundle>newHashSet(it));
  }
  
  public final Iterable<Bundle> collectAllImportedBundles(final ArrayList<Bundle> queue, final ArrayList<Bundle> acc, final HashSet<Bundle> visited) {
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
      final Function1<Bundle, Boolean> _function_1 = (Bundle it) -> {
        return Boolean.valueOf(visited.contains(it));
      };
      final Iterable<Bundle> inc = IterableExtensions.<Bundle>reject(Iterables.<Bundle>filter(ListExtensions.<TerminologyBundleAxiom, TerminologyBox>map(bundle.getBundleAxioms(), _function), Bundle.class), _function_1);
      Iterables.<Bundle>addAll(queue, inc);
      Iterables.<Bundle>addAll(acc, inc);
      Iterables.<Bundle>addAll(visited, inc);
      _xblockexpression = this.collectAllImportedBundles(queue, acc, visited);
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
    return this.collectAllImportedTerminologiesFromDescription(Lists.<DescriptionBox>newArrayList(it), Sets.<TerminologyBox>newHashSet(), Sets.<TerminologyBox>newHashSet());
  }
  
  public final Iterable<TerminologyBox> collectAllImportedTerminologiesFromDescription(final ArrayList<DescriptionBox> queue, final HashSet<TerminologyBox> acc, final HashSet<TerminologyBox> visited) {
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
        return OMLExtensions.allImportedTerminologies(it);
      };
      final Function1<TerminologyBox, Boolean> _function_3 = (TerminologyBox it) -> {
        return Boolean.valueOf(visited.contains(it));
      };
      final Iterable<TerminologyBox> inct = IterableExtensions.<TerminologyBox>reject(Iterables.<TerminologyBox>concat(ListExtensions.<TerminologyBox, Iterable<TerminologyBox>>map(ListExtensions.<DescriptionBoxExtendsClosedWorldDefinitions, TerminologyBox>map(dbox.getClosedWorldDefinitions(), _function_1), _function_2)), _function_3);
      Iterables.<TerminologyBox>addAll(acc, inct);
      Iterables.<TerminologyBox>addAll(visited, inct);
      _xblockexpression = this.collectAllImportedTerminologiesFromDescription(queue, acc, visited);
    }
    return _xblockexpression;
  }
  
  public Iterable<DescriptionBox> allImportedDescriptions(final DescriptionBox it) {
    return this.collectAllImportedDescriptions(Lists.<DescriptionBox>newArrayList(it), Lists.<DescriptionBox>newArrayList(it), Sets.<DescriptionBox>newHashSet(it));
  }
  
  public final Iterable<DescriptionBox> collectAllImportedDescriptions(final ArrayList<DescriptionBox> queue, final ArrayList<DescriptionBox> acc, final HashSet<DescriptionBox> visited) {
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
      final Function1<DescriptionBox, Boolean> _function_1 = (DescriptionBox it) -> {
        return Boolean.valueOf(visited.contains(it));
      };
      final Iterable<DescriptionBox> inc = IterableExtensions.<DescriptionBox>reject(ListExtensions.<DescriptionBoxRefinement, DescriptionBox>map(dbox.getDescriptionBoxRefinements(), _function), _function_1);
      Iterables.<DescriptionBox>addAll(queue, inc);
      Iterables.<DescriptionBox>addAll(acc, inc);
      Iterables.<DescriptionBox>addAll(visited, inc);
      _xblockexpression = this.collectAllImportedDescriptions(queue, acc, visited);
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
  
  public static String kind(final LogicalElement e) {
    String _switchResult = null;
    boolean _matched = false;
    if (e instanceof AnonymousConceptUnionAxiom) {
      _matched=true;
      _switchResult = "AnonymousConceptUnionAxiom";
    }
    if (!_matched) {
      if (e instanceof Aspect) {
        _matched=true;
        _switchResult = "Aspect";
      }
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedAspect) {
        _matched=true;
        _switchResult = "CardinalityRestrictedAspect";
      }
    }
    if (!_matched) {
      if (e instanceof AspectSpecializationAxiom) {
        _matched=true;
        _switchResult = "AspectSpecializationAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof BinaryScalarRestriction) {
        _matched=true;
        _switchResult = "BinaryScalarRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof Bundle) {
        _matched=true;
        _switchResult = "Bundle";
      }
    }
    if (!_matched) {
      if (e instanceof BundledTerminologyAxiom) {
        _matched=true;
        _switchResult = "BundledTerminologyAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof ChainRule) {
        _matched=true;
        _switchResult = "ChainRule";
      }
    }
    if (!_matched) {
      if (e instanceof Concept) {
        _matched=true;
        _switchResult = "Concept";
      }
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedConcept) {
        _matched=true;
        _switchResult = "CardinalityRestrictedConcept";
      }
    }
    if (!_matched) {
      if (e instanceof ConceptDesignationTerminologyAxiom) {
        _matched=true;
        _switchResult = "ConceptDesignationTerminologyAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof ConceptInstance) {
        _matched=true;
        _switchResult = "ConceptInstance";
      }
    }
    if (!_matched) {
      if (e instanceof ConceptSpecializationAxiom) {
        _matched=true;
        _switchResult = "ConceptSpecializationAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof DescriptionBox) {
        _matched=true;
        _switchResult = "DescriptionBox";
      }
    }
    if (!_matched) {
      if (e instanceof DescriptionBoxExtendsClosedWorldDefinitions) {
        _matched=true;
        _switchResult = "DescriptionBoxExtendsClosedWorldDefinitions";
      }
    }
    if (!_matched) {
      if (e instanceof DescriptionBoxRefinement) {
        _matched=true;
        _switchResult = "DescriptionBoxRefinement";
      }
    }
    if (!_matched) {
      if (e instanceof EntityRestrictionAxiom) {
        _matched=true;
        _switchResult = "EntityRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataProperty) {
        _matched=true;
        _switchResult = "EntityScalarDataProperty";
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyExistentialRestrictionAxiom) {
        _matched=true;
        _switchResult = "EntityScalarDataPropertyExistentialRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyParticularRestrictionAxiom) {
        _matched=true;
        _switchResult = "EntityScalarDataPropertyParticularRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyUniversalRestrictionAxiom) {
        _matched=true;
        _switchResult = "EntityScalarDataPropertyUniversalRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof EntityStructuredDataProperty) {
        _matched=true;
        _switchResult = "EntityStructuredDataProperty";
      }
    }
    if (!_matched) {
      if (e instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
        _matched=true;
        _switchResult = "EntityStructuredDataPropertyParticularRestrictionAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof IRIScalarRestriction) {
        _matched=true;
        _switchResult = "IRIScalarRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof NumericScalarRestriction) {
        _matched=true;
        _switchResult = "NumericScalarRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipRestriction) {
        _matched=true;
        _switchResult = "ReifiedRelationshipRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof PlainLiteralScalarRestriction) {
        _matched=true;
        _switchResult = "PlainLiteralScalarRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationship) {
        _matched=true;
        _switchResult = "ReifiedRelationship";
      }
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedReifiedRelationship) {
        _matched=true;
        _switchResult = "CardinalityRestrictedReifiedRelationship";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipInstance) {
        _matched=true;
        _switchResult = "ReifiedRelationshipInstance";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipInstanceDomain) {
        _matched=true;
        _switchResult = "ReifiedRelationshipInstanceDomain";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipInstanceRange) {
        _matched=true;
        _switchResult = "ReifiedRelationshipInstanceRange";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipSpecializationAxiom) {
        _matched=true;
        _switchResult = "ReifiedRelationshipSpecializationAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof RestrictionScalarDataPropertyValue) {
        _matched=true;
        _switchResult = "RestrictionScalarDataPropertyValue";
      }
    }
    if (!_matched) {
      if (e instanceof RestrictionStructuredDataPropertyTuple) {
        _matched=true;
        _switchResult = "RestrictionStructuredDataPropertyTuple";
      }
    }
    if (!_matched) {
      if (e instanceof RootConceptTaxonomyAxiom) {
        _matched=true;
        _switchResult = "RootConceptTaxonomyAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof RuleBodySegment) {
        _matched=true;
        _switchResult = "RuleBodySegment";
      }
    }
    if (!_matched) {
      if (e instanceof Scalar) {
        _matched=true;
        _switchResult = "Scalar";
      }
    }
    if (!_matched) {
      if (e instanceof ScalarDataProperty) {
        _matched=true;
        _switchResult = "ScalarDataProperty";
      }
    }
    if (!_matched) {
      if (e instanceof ScalarDataPropertyValue) {
        _matched=true;
        _switchResult = "ScalarDataPropertyValue";
      }
    }
    if (!_matched) {
      if (e instanceof ScalarOneOfLiteralAxiom) {
        _matched=true;
        _switchResult = "ScalarOneOfLiteralAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof ScalarOneOfRestriction) {
        _matched=true;
        _switchResult = "ScalarOneOfRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof SegmentPredicate) {
        _matched=true;
        _switchResult = "SegmentPredicate";
      }
    }
    if (!_matched) {
      if (e instanceof SingletonInstanceScalarDataPropertyValue) {
        _matched=true;
        _switchResult = "SingletonInstanceScalarDataPropertyValue";
      }
    }
    if (!_matched) {
      if (e instanceof SingletonInstanceStructuredDataPropertyValue) {
        _matched=true;
        _switchResult = "SingletonInstanceStructuredDataPropertyValue";
      }
    }
    if (!_matched) {
      if (e instanceof SpecificDisjointConceptAxiom) {
        _matched=true;
        _switchResult = "SpecificDisjointConceptAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof StringScalarRestriction) {
        _matched=true;
        _switchResult = "StringScalarRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof Structure) {
        _matched=true;
        _switchResult = "Structure";
      }
    }
    if (!_matched) {
      if (e instanceof StructuredDataProperty) {
        _matched=true;
        _switchResult = "StructuredDataProperty";
      }
    }
    if (!_matched) {
      if (e instanceof StructuredDataPropertyTuple) {
        _matched=true;
        _switchResult = "StructuredDataPropertyTuple";
      }
    }
    if (!_matched) {
      if (e instanceof SubDataPropertyOfAxiom) {
        _matched=true;
        _switchResult = "SubDataPropertyOfAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof SubObjectPropertyOfAxiom) {
        _matched=true;
        _switchResult = "SubObjectPropertyOfAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof SynonymScalarRestriction) {
        _matched=true;
        _switchResult = "SynonymScalarRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof TerminologyExtensionAxiom) {
        _matched=true;
        _switchResult = "TerminologyExtensionAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof TerminologyGraph) {
        _matched=true;
        _switchResult = "TerminologyGraph";
      }
    }
    if (!_matched) {
      if (e instanceof TerminologyNestingAxiom) {
        _matched=true;
        _switchResult = "TerminologyNestingAxiom";
      }
    }
    if (!_matched) {
      if (e instanceof TimeScalarRestriction) {
        _matched=true;
        _switchResult = "TimeScalarRestriction";
      }
    }
    if (!_matched) {
      if (e instanceof UnreifiedRelationship) {
        _matched=true;
        _switchResult = "UnreifiedRelationship";
      }
    }
    if (!_matched) {
      if (e instanceof UnreifiedRelationshipInstanceTuple) {
        _matched=true;
        _switchResult = "UnreifiedRelationshipInstanceTuple";
      }
    }
    if (!_matched) {
      _switchResult = e.eClass().getName();
    }
    return _switchResult;
  }
  
  public static int kindOrder(final TerminologyBoxStatement e) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (e instanceof Aspect) {
      _matched=true;
      _switchResult = 10000;
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedAspect) {
        _matched=true;
        _switchResult = 10001;
      }
    }
    if (!_matched) {
      if (e instanceof Concept) {
        _matched=true;
        _switchResult = 10020;
      }
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedConcept) {
        _matched=true;
        _switchResult = 10021;
      }
    }
    if (!_matched) {
      if (e instanceof ConceptSpecializationAxiom) {
        _matched=true;
        _switchResult = 10022;
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationship) {
        _matched=true;
        _switchResult = 10030;
      }
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedReifiedRelationship) {
        _matched=true;
        _switchResult = 10031;
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipRestriction) {
        _matched=true;
        _switchResult = 10032;
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipSpecializationAxiom) {
        _matched=true;
        _switchResult = 10033;
      }
    }
    if (!_matched) {
      if (e instanceof AspectSpecializationAxiom) {
        _matched=true;
        _switchResult = 10040;
      }
    }
    if (!_matched) {
      if (e instanceof UnreifiedRelationship) {
        _matched=true;
        _switchResult = 10050;
      }
    }
    if (!_matched) {
      if (e instanceof ChainRule) {
        _matched=true;
        _switchResult = 10060;
      }
    }
    if (!_matched) {
      if (e instanceof Structure) {
        _matched=true;
        _switchResult = 10070;
      }
    }
    if (!_matched) {
      if (e instanceof Scalar) {
        _matched=true;
        _switchResult = 10071;
      }
    }
    if (!_matched) {
      if (e instanceof BinaryScalarRestriction) {
        _matched=true;
        _switchResult = 10072;
      }
    }
    if (!_matched) {
      if (e instanceof IRIScalarRestriction) {
        _matched=true;
        _switchResult = 10073;
      }
    }
    if (!_matched) {
      if (e instanceof NumericScalarRestriction) {
        _matched=true;
        _switchResult = 10074;
      }
    }
    if (!_matched) {
      if (e instanceof PlainLiteralScalarRestriction) {
        _matched=true;
        _switchResult = 10075;
      }
    }
    if (!_matched) {
      if (e instanceof StringScalarRestriction) {
        _matched=true;
        _switchResult = 10076;
      }
    }
    if (!_matched) {
      if (e instanceof SynonymScalarRestriction) {
        _matched=true;
        _switchResult = 10077;
      }
    }
    if (!_matched) {
      if (e instanceof TimeScalarRestriction) {
        _matched=true;
        _switchResult = 10078;
      }
    }
    if (!_matched) {
      if (e instanceof ScalarOneOfRestriction) {
        _matched=true;
        _switchResult = 10079;
      }
    }
    if (!_matched) {
      if (e instanceof ScalarOneOfLiteralAxiom) {
        _matched=true;
        _switchResult = 10080;
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataProperty) {
        _matched=true;
        _switchResult = 10090;
      }
    }
    if (!_matched) {
      if (e instanceof EntityStructuredDataProperty) {
        _matched=true;
        _switchResult = 10091;
      }
    }
    if (!_matched) {
      if (e instanceof ScalarDataProperty) {
        _matched=true;
        _switchResult = 10092;
      }
    }
    if (!_matched) {
      if (e instanceof StructuredDataProperty) {
        _matched=true;
        _switchResult = 10093;
      }
    }
    if (!_matched) {
      if (e instanceof EntityRestrictionAxiom) {
        _matched=true;
        _switchResult = 10100;
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyExistentialRestrictionAxiom) {
        _matched=true;
        _switchResult = 10101;
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyParticularRestrictionAxiom) {
        _matched=true;
        _switchResult = 10102;
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyUniversalRestrictionAxiom) {
        _matched=true;
        _switchResult = 10103;
      }
    }
    if (!_matched) {
      if (e instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
        _matched=true;
        _switchResult = 10104;
      }
    }
    if (!_matched) {
      if (e instanceof SubObjectPropertyOfAxiom) {
        _matched=true;
        _switchResult = 10202;
      }
    }
    if (!_matched) {
      if (e instanceof SubDataPropertyOfAxiom) {
        _matched=true;
        _switchResult = 10201;
      }
    }
    if (!_matched) {
      _switchResult = 0;
    }
    return _switchResult;
  }
  
  public static int kindOrder(final TerminologyBoxAxiom e) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (e instanceof TerminologyExtensionAxiom) {
      _matched=true;
      _switchResult = 1;
    }
    if (!_matched) {
      if (e instanceof TerminologyNestingAxiom) {
        _matched=true;
        _switchResult = 2;
      }
    }
    if (!_matched) {
      if (e instanceof ConceptDesignationTerminologyAxiom) {
        _matched=true;
        _switchResult = 3;
      }
    }
    if (!_matched) {
      _switchResult = 0;
    }
    return _switchResult;
  }
  
  public static int kindOrder(final TerminologyBundleAxiom e) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (e instanceof BundledTerminologyAxiom) {
      _matched=true;
      _switchResult = 1;
    }
    if (!_matched) {
      _switchResult = 0;
    }
    return _switchResult;
  }
  
  public static int kindOrder(final TerminologyBundleStatement e) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (e instanceof RootConceptTaxonomyAxiom) {
      _matched=true;
      _switchResult = 1;
    }
    if (!_matched) {
      _switchResult = 0;
    }
    return _switchResult;
  }
  
  public static String nestedKindOrder(final LogicalElement e) {
    String _switchResult = null;
    boolean _matched = false;
    if (e instanceof TerminologyGraph) {
      _matched=true;
      _switchResult = "00000-";
    }
    if (!_matched) {
      if (e instanceof Bundle) {
        _matched=true;
        _switchResult = "00001-";
      }
    }
    if (!_matched) {
      if (e instanceof DescriptionBox) {
        _matched=true;
        _switchResult = "00002-";
      }
    }
    if (!_matched) {
      if (e instanceof Aspect) {
        _matched=true;
        _switchResult = "00010-";
      }
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedAspect) {
        _matched=true;
        _switchResult = "00010+";
      }
    }
    if (!_matched) {
      if (e instanceof Concept) {
        _matched=true;
        _switchResult = "00011-";
      }
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedConcept) {
        _matched=true;
        _switchResult = "00011+";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationship) {
        _matched=true;
        _switchResult = "00012-";
      }
    }
    if (!_matched) {
      if (e instanceof CardinalityRestrictedReifiedRelationship) {
        _matched=true;
        _switchResult = "00012+";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipRestriction) {
        _matched=true;
        _switchResult = "00013-";
      }
    }
    if (!_matched) {
      if (e instanceof UnreifiedRelationship) {
        _matched=true;
        _switchResult = "00014-";
      }
    }
    if (!_matched) {
      if (e instanceof ChainRule) {
        _matched=true;
        _switchResult = "00015-";
      }
    }
    if (!_matched) {
      if (e instanceof ConceptSpecializationAxiom) {
        _matched=true;
        _switchResult = "00020-";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipSpecializationAxiom) {
        _matched=true;
        _switchResult = "00021-";
      }
    }
    if (!_matched) {
      if (e instanceof AspectSpecializationAxiom) {
        _matched=true;
        _switchResult = "00022-";
      }
    }
    if (!_matched) {
      if (e instanceof Structure) {
        _matched=true;
        _switchResult = "00030-";
      }
    }
    if (!_matched) {
      if (e instanceof Scalar) {
        _matched=true;
        _switchResult = "00031-";
      }
    }
    if (!_matched) {
      if (e instanceof BinaryScalarRestriction) {
        _matched=true;
        _switchResult = "00032-";
      }
    }
    if (!_matched) {
      if (e instanceof IRIScalarRestriction) {
        _matched=true;
        _switchResult = "00033-";
      }
    }
    if (!_matched) {
      if (e instanceof NumericScalarRestriction) {
        _matched=true;
        _switchResult = "00034-";
      }
    }
    if (!_matched) {
      if (e instanceof PlainLiteralScalarRestriction) {
        _matched=true;
        _switchResult = "00035-";
      }
    }
    if (!_matched) {
      if (e instanceof StringScalarRestriction) {
        _matched=true;
        _switchResult = "00036-";
      }
    }
    if (!_matched) {
      if (e instanceof SynonymScalarRestriction) {
        _matched=true;
        _switchResult = "00037-";
      }
    }
    if (!_matched) {
      if (e instanceof TimeScalarRestriction) {
        _matched=true;
        _switchResult = "00038-";
      }
    }
    if (!_matched) {
      if (e instanceof ScalarOneOfRestriction) {
        _matched=true;
        _switchResult = "00039-";
      }
    }
    if (!_matched) {
      if (e instanceof ScalarOneOfLiteralAxiom) {
        _matched=true;
        _switchResult = "00040-";
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataProperty) {
        _matched=true;
        _switchResult = "00050-";
      }
    }
    if (!_matched) {
      if (e instanceof EntityStructuredDataProperty) {
        _matched=true;
        _switchResult = "00051-";
      }
    }
    if (!_matched) {
      if (e instanceof ScalarDataProperty) {
        _matched=true;
        _switchResult = "00052-";
      }
    }
    if (!_matched) {
      if (e instanceof StructuredDataProperty) {
        _matched=true;
        _switchResult = "00053-";
      }
    }
    if (!_matched) {
      if (e instanceof EntityRestrictionAxiom) {
        _matched=true;
        _switchResult = "00060-";
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyExistentialRestrictionAxiom) {
        _matched=true;
        _switchResult = "00061-";
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyParticularRestrictionAxiom) {
        _matched=true;
        _switchResult = "00062-";
      }
    }
    if (!_matched) {
      if (e instanceof EntityScalarDataPropertyUniversalRestrictionAxiom) {
        _matched=true;
        _switchResult = "00063-";
      }
    }
    if (!_matched) {
      if (e instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
        _matched=true;
        _switchResult = "00064-";
      }
    }
    if (!_matched) {
      if (e instanceof RootConceptTaxonomyAxiom) {
        _matched=true;
        _switchResult = "00070-";
      }
    }
    if (!_matched) {
      if (e instanceof SpecificDisjointConceptAxiom) {
        _matched=true;
        _switchResult = "00071-";
      }
    }
    if (!_matched) {
      if (e instanceof AnonymousConceptUnionAxiom) {
        _matched=true;
        _switchResult = "00072-";
      }
    }
    if (!_matched) {
      if (e instanceof RuleBodySegment) {
        _matched=true;
        _switchResult = "00080";
      }
    }
    if (!_matched) {
      if (e instanceof SegmentPredicate) {
        _matched=true;
        _switchResult = "00090";
      }
    }
    if (!_matched) {
      if (e instanceof SingletonInstanceStructuredDataPropertyValue) {
        _matched=true;
        _switchResult = "00120";
      }
    }
    if (!_matched) {
      if (e instanceof StructuredDataPropertyTuple) {
        _matched=true;
        _switchResult = "00121";
      }
    }
    if (!_matched) {
      if (e instanceof ScalarDataPropertyValue) {
        _matched=true;
        _switchResult = "00122";
      }
    }
    if (!_matched) {
      if (e instanceof RestrictionScalarDataPropertyValue) {
        _matched=true;
        _switchResult = "00130";
      }
    }
    if (!_matched) {
      if (e instanceof RestrictionStructuredDataPropertyTuple) {
        _matched=true;
        _switchResult = "00131";
      }
    }
    if (!_matched) {
      if (e instanceof ConceptInstance) {
        _matched=true;
        _switchResult = "00140";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipInstance) {
        _matched=true;
        _switchResult = "00141";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipInstanceDomain) {
        _matched=true;
        _switchResult = "00142";
      }
    }
    if (!_matched) {
      if (e instanceof ReifiedRelationshipInstanceRange) {
        _matched=true;
        _switchResult = "00143";
      }
    }
    if (!_matched) {
      if (e instanceof UnreifiedRelationshipInstanceTuple) {
        _matched=true;
        _switchResult = "00144";
      }
    }
    if (!_matched) {
      if (e instanceof SubObjectPropertyOfAxiom) {
        _matched=true;
        _switchResult = "00150";
      }
    }
    if (!_matched) {
      if (e instanceof SubDataPropertyOfAxiom) {
        _matched=true;
        _switchResult = "00151";
      }
    }
    if (!_matched) {
      _switchResult = "0";
    }
    return _switchResult;
  }
  
  public static <T extends Object, C extends Comparable<? super C>> EList<T> sortInplaceBy(final EList<T> list, final Function1<? super T, C> key) {
    if ((key == null)) {
      throw new NullPointerException("key");
    }
    OMLExtensions.KeyComparator<T, C> _keyComparator = new OMLExtensions.KeyComparator<T, C>(key);
    ECollections.<T>sort(list, _keyComparator);
    return list;
  }
  
  protected static void _normalize(final Extent ext) {
    final ArrayList<EObject> queue = new ArrayList<EObject>();
    queue.add(ext);
    final Function1<gov.nasa.jpl.imce.oml.model.common.Module, String> _function = (gov.nasa.jpl.imce.oml.model.common.Module it) -> {
      return it.abbrevIRI();
    };
    OMLExtensions.<gov.nasa.jpl.imce.oml.model.common.Module, String>sortInplaceBy(ext.getModules(), _function);
    final Consumer<gov.nasa.jpl.imce.oml.model.common.Module> _function_1 = (gov.nasa.jpl.imce.oml.model.common.Module m) -> {
      OMLExtensions.normalize(m);
    };
    ext.getModules().forEach(_function_1);
  }
  
  /**
   * Normalizes the order of OML Elements recursively within an OML TerminologyGraph.
   */
  protected static void _normalize(final TerminologyGraph it) {
    OMLExtensions.normalizeTerminologyBoxCollections(it);
    final Consumer<LogicalElement> _function = (LogicalElement e) -> {
      OMLExtensions.normalizeAnnotations(e);
      OMLExtensions.normalizeSubElements(e);
    };
    Iterables.<LogicalElement>filter(it.eContents(), LogicalElement.class).forEach(_function);
  }
  
  /**
   * Normalizes the order of OML Elements recursively within an OML Bundle.
   */
  protected static void _normalize(final Bundle it) {
    OMLExtensions.normalizeBundleCollections(it);
    final Consumer<LogicalElement> _function = (LogicalElement e) -> {
      OMLExtensions.normalizeAnnotations(e);
      OMLExtensions.normalizeSubElements(e);
    };
    Iterables.<LogicalElement>filter(it.eContents(), LogicalElement.class).forEach(_function);
  }
  
  /**
   * Normalizes the order of OML Elements recursively within an OML DescriptionBox.
   */
  protected static void _normalize(final DescriptionBox it) {
    final Function1<AnnotationProperty, String> _function = (AnnotationProperty it_1) -> {
      return it_1.getAbbrevIRI();
    };
    OMLExtensions.<AnnotationProperty, String>sortInplaceBy(it.getAnnotationProperties(), _function);
    final Function1<DescriptionBoxRefinement, String> _function_1 = (DescriptionBoxRefinement it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<DescriptionBoxRefinement, String>sortInplaceBy(it.getDescriptionBoxRefinements(), _function_1);
    final Function1<DescriptionBoxExtendsClosedWorldDefinitions, String> _function_2 = (DescriptionBoxExtendsClosedWorldDefinitions it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<DescriptionBoxExtendsClosedWorldDefinitions, String>sortInplaceBy(it.getClosedWorldDefinitions(), _function_2);
    final Function1<ConceptInstance, String> _function_3 = (ConceptInstance it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<ConceptInstance, String>sortInplaceBy(it.getConceptInstances(), _function_3);
    final Function1<ReifiedRelationshipInstance, String> _function_4 = (ReifiedRelationshipInstance it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<ReifiedRelationshipInstance, String>sortInplaceBy(it.getReifiedRelationshipInstances(), _function_4);
    final Function1<ReifiedRelationshipInstanceDomain, String> _function_5 = (ReifiedRelationshipInstanceDomain it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<ReifiedRelationshipInstanceDomain, String>sortInplaceBy(it.getReifiedRelationshipInstanceDomains(), _function_5);
    final Function1<ReifiedRelationshipInstanceRange, String> _function_6 = (ReifiedRelationshipInstanceRange it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<ReifiedRelationshipInstanceRange, String>sortInplaceBy(it.getReifiedRelationshipInstanceRanges(), _function_6);
    final Function1<UnreifiedRelationshipInstanceTuple, String> _function_7 = (UnreifiedRelationshipInstanceTuple it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<UnreifiedRelationshipInstanceTuple, String>sortInplaceBy(it.getUnreifiedRelationshipInstanceTuples(), _function_7);
    final Function1<SingletonInstanceScalarDataPropertyValue, String> _function_8 = (SingletonInstanceScalarDataPropertyValue it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<SingletonInstanceScalarDataPropertyValue, String>sortInplaceBy(it.getSingletonScalarDataPropertyValues(), _function_8);
    final Function1<SingletonInstanceStructuredDataPropertyValue, String> _function_9 = (SingletonInstanceStructuredDataPropertyValue it_1) -> {
      return OMLExtensions.sortingCriteria(it_1);
    };
    OMLExtensions.<SingletonInstanceStructuredDataPropertyValue, String>sortInplaceBy(it.getSingletonStructuredDataPropertyValues(), _function_9);
    final Consumer<LogicalElement> _function_10 = (LogicalElement e) -> {
      OMLExtensions.normalizeAnnotations(e);
      OMLExtensions.normalizeSubElements(e);
    };
    Iterables.<LogicalElement>filter(it.eContents(), LogicalElement.class).forEach(_function_10);
  }
  
  protected static void normalizeTerminologyBoxCollections(final TerminologyBox it) {
    final Function1<AnnotationProperty, String> _function = (AnnotationProperty it_1) -> {
      return it_1.getAbbrevIRI();
    };
    OMLExtensions.<AnnotationProperty, String>sortInplaceBy(it.getAnnotationProperties(), _function);
    ECollections.<TerminologyBoxAxiom>sort(it.getBoxAxioms(), OMLExtensions.terminologyBoxAxiomComparator);
    ECollections.<TerminologyBoxStatement>sort(it.getBoxStatements(), OMLExtensions.terminologyBoxStatementComparator);
  }
  
  protected static void normalizeBundleCollections(final Bundle it) {
    OMLExtensions.normalizeTerminologyBoxCollections(it);
    ECollections.<TerminologyBundleAxiom>sort(it.getBundleAxioms(), OMLExtensions.bundleAxiomComparator);
    ECollections.<TerminologyBundleStatement>sort(it.getBundleStatements(), OMLExtensions.bundleStatementComparator);
  }
  
  protected static EList<AnnotationPropertyValue> normalizeAnnotations(final LogicalElement e) {
    final Function1<AnnotationPropertyValue, String> _function = (AnnotationPropertyValue it) -> {
      return OMLExtensions.sortingCriteria(it);
    };
    return OMLExtensions.<AnnotationPropertyValue, String>sortInplaceBy(e.getAnnotations(), _function);
  }
  
  protected static void _normalizeSubElements(final RootConceptTaxonomyAxiom e) {
    OMLExtensions.normalizeAnnotations(e.getRoot());
    final Function1<DisjointUnionOfConceptsAxiom, String> _function = (DisjointUnionOfConceptsAxiom it) -> {
      return OMLExtensions.sortingCriteria(it);
    };
    OMLExtensions.<DisjointUnionOfConceptsAxiom, String>sortInplaceBy(e.getDisjunctions(), _function);
    final Consumer<DisjointUnionOfConceptsAxiom> _function_1 = (DisjointUnionOfConceptsAxiom d) -> {
      OMLExtensions.normalizeSubElements(d);
    };
    e.getDisjunctions().forEach(_function_1);
  }
  
  protected static void _normalizeSubElements(final AnonymousConceptUnionAxiom e) {
    final Function1<DisjointUnionOfConceptsAxiom, String> _function = (DisjointUnionOfConceptsAxiom it) -> {
      return OMLExtensions.sortingCriteria(it);
    };
    OMLExtensions.<DisjointUnionOfConceptsAxiom, String>sortInplaceBy(e.getDisjunctions(), _function);
  }
  
  protected static void _normalizeSubElements(final SpecificDisjointConceptAxiom e) {
    OMLExtensions.normalizeAnnotations(e.getDisjointLeaf());
  }
  
  protected static void _normalizeSubElements(final ModuleEdge e) {
  }
  
  protected static void _normalizeSubElements(final TerminologyBoxStatement e) {
  }
  
  private final static Comparator<TerminologyBoxStatement> terminologyBoxStatementComparator = new Comparator<TerminologyBoxStatement>() {
    @Override
    public int compare(final TerminologyBoxStatement o1, final TerminologyBoxStatement o2) {
      int _xblockexpression = (int) 0;
      {
        final int k1 = OMLExtensions.kindOrder(o1);
        final int k2 = OMLExtensions.kindOrder(o2);
        if ((k1 == 0)) {
          throw new IllegalArgumentException(("terminologyBoxStatementComparator: cannot handle " + o1));
        }
        if ((k2 == 0)) {
          throw new IllegalArgumentException(("terminologyBoxStatementComparator: cannot handle " + o2));
        }
        int _xifexpression = (int) 0;
        if ((k1 < k2)) {
          _xifexpression = (-1);
        } else {
          int _xifexpression_1 = (int) 0;
          if ((k1 > k2)) {
            _xifexpression_1 = 1;
          } else {
            int _xblockexpression_1 = (int) 0;
            {
              final String u1 = OMLExtensions.sortingCriteria(o1);
              final String u2 = OMLExtensions.sortingCriteria(o2);
              _xblockexpression_1 = u1.compareTo(u2);
            }
            _xifexpression_1 = _xblockexpression_1;
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
  };
  
  private final static Comparator<TerminologyBoxAxiom> terminologyBoxAxiomComparator = new Comparator<TerminologyBoxAxiom>() {
    @Override
    public int compare(final TerminologyBoxAxiom o1, final TerminologyBoxAxiom o2) {
      int _xblockexpression = (int) 0;
      {
        final int k1 = OMLExtensions.kindOrder(o1);
        final int k2 = OMLExtensions.kindOrder(o2);
        if ((k1 == 0)) {
          throw new IllegalArgumentException(("terminologyBoxAxiomComparator: cannot handle " + o1));
        }
        if ((k2 == 0)) {
          throw new IllegalArgumentException(("terminologyBoxAxiomComparator: cannot handle " + o2));
        }
        int _xifexpression = (int) 0;
        if ((k1 < k2)) {
          _xifexpression = (-1);
        } else {
          int _xifexpression_1 = (int) 0;
          if ((k1 > k2)) {
            _xifexpression_1 = 1;
          } else {
            int _xblockexpression_1 = (int) 0;
            {
              final String u1 = OMLExtensions.sortingCriteria(o1);
              final String u2 = OMLExtensions.sortingCriteria(o2);
              _xblockexpression_1 = u1.compareTo(u2);
            }
            _xifexpression_1 = _xblockexpression_1;
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
  };
  
  private final static Comparator<TerminologyBundleStatement> bundleStatementComparator = new Comparator<TerminologyBundleStatement>() {
    @Override
    public int compare(final TerminologyBundleStatement o1, final TerminologyBundleStatement o2) {
      int _xblockexpression = (int) 0;
      {
        final int k1 = OMLExtensions.kindOrder(o1);
        final int k2 = OMLExtensions.kindOrder(o2);
        if ((k1 == 0)) {
          throw new IllegalArgumentException(("terminologyBoxStatementComparator: cannot handle " + o1));
        }
        if ((k2 == 0)) {
          throw new IllegalArgumentException(("terminologyBoxStatementComparator: cannot handle " + o2));
        }
        int _xifexpression = (int) 0;
        if ((k1 < k2)) {
          _xifexpression = (-1);
        } else {
          int _xifexpression_1 = (int) 0;
          if ((k1 > k2)) {
            _xifexpression_1 = 1;
          } else {
            int _xblockexpression_1 = (int) 0;
            {
              final String u1 = OMLExtensions.sortingCriteria(o1);
              final String u2 = OMLExtensions.sortingCriteria(o2);
              _xblockexpression_1 = u1.compareTo(u2);
            }
            _xifexpression_1 = _xblockexpression_1;
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
  };
  
  private final static Comparator<TerminologyBundleAxiom> bundleAxiomComparator = new Comparator<TerminologyBundleAxiom>() {
    @Override
    public int compare(final TerminologyBundleAxiom o1, final TerminologyBundleAxiom o2) {
      int _xblockexpression = (int) 0;
      {
        final int k1 = OMLExtensions.kindOrder(o1);
        final int k2 = OMLExtensions.kindOrder(o2);
        if ((k1 == 0)) {
          throw new IllegalArgumentException(("TerminologyBundleAxiom: cannot handle " + o1));
        }
        if ((k2 == 0)) {
          throw new IllegalArgumentException(("TerminologyBundleAxiom: cannot handle " + o2));
        }
        int _xifexpression = (int) 0;
        if ((k1 < k2)) {
          _xifexpression = (-1);
        } else {
          int _xifexpression_1 = (int) 0;
          if ((k1 > k2)) {
            _xifexpression_1 = 1;
          } else {
            int _xblockexpression_1 = (int) 0;
            {
              final String u1 = OMLExtensions.sortingCriteria(o1);
              final String u2 = OMLExtensions.sortingCriteria(o2);
              _xblockexpression_1 = u1.compareTo(u2);
            }
            _xifexpression_1 = _xblockexpression_1;
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
  };
  
  public static String sortingCriteria(final LogicalElement e) {
    String _xblockexpression = null;
    {
      String _switchResult = null;
      boolean _matched = false;
      if (e instanceof gov.nasa.jpl.imce.oml.model.common.Module) {
        _matched=true;
        _switchResult = ((gov.nasa.jpl.imce.oml.model.common.Module)e).abbrevIRI();
      }
      if (!_matched) {
        if (e instanceof ModuleEdge) {
          _matched=true;
          String _elvis = null;
          gov.nasa.jpl.imce.oml.model.common.Module _sourceModule = ((ModuleEdge)e).sourceModule();
          String _abbrevIRI = null;
          if (_sourceModule!=null) {
            _abbrevIRI=_sourceModule.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((ModuleEdge)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          gov.nasa.jpl.imce.oml.model.common.Module _targetModule = null;
          if (((ModuleEdge)e)!=null) {
            _targetModule=((ModuleEdge)e).targetModule();
          }
          String _abbrevIRI_1 = _targetModule.abbrevIRI();
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((ModuleEdge)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof AnonymousConceptUnionAxiom) {
          _matched=true;
          _switchResult = ((AnonymousConceptUnionAxiom)e).getName();
        }
      }
      if (!_matched) {
        if (e instanceof RootConceptTaxonomyAxiom) {
          _matched=true;
          String _elvis = null;
          ConceptKind _root = ((RootConceptTaxonomyAxiom)e).getRoot();
          String _abbrevIRI = null;
          if (_root!=null) {
            _abbrevIRI=_root.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((RootConceptTaxonomyAxiom)e).uuid().toString();
            _elvis = _string;
          }
          _switchResult = _elvis;
        }
      }
      if (!_matched) {
        if (e instanceof SpecificDisjointConceptAxiom) {
          _matched=true;
          String _elvis = null;
          ConceptKind _disjointLeaf = ((SpecificDisjointConceptAxiom)e).getDisjointLeaf();
          String _abbrevIRI = null;
          if (_disjointLeaf!=null) {
            _abbrevIRI=_disjointLeaf.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((SpecificDisjointConceptAxiom)e).uuid().toString();
            _elvis = _string;
          }
          _switchResult = _elvis;
        }
      }
      if (!_matched) {
        if (e instanceof Term) {
          _matched=true;
          _switchResult = ((Term)e).abbrevIRI();
        }
      }
      if (!_matched) {
        if (e instanceof EntityRestrictionAxiom) {
          _matched=true;
          String _elvis = null;
          Entity _restrictedDomain = ((EntityRestrictionAxiom)e).getRestrictedDomain();
          String _abbrevIRI = null;
          if (_restrictedDomain!=null) {
            _abbrevIRI=_restrictedDomain.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((EntityRestrictionAxiom)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          EntityRelationship _restrictedRelation = ((EntityRestrictionAxiom)e).restrictedRelation();
          String _abbrevIRI_1 = null;
          if (_restrictedRelation!=null) {
            _abbrevIRI_1=_restrictedRelation.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((EntityRestrictionAxiom)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof EntityScalarDataPropertyRestrictionAxiom) {
          _matched=true;
          String _elvis = null;
          Entity _restrictedEntity = ((EntityScalarDataPropertyRestrictionAxiom)e).getRestrictedEntity();
          String _abbrevIRI = null;
          if (_restrictedEntity!=null) {
            _abbrevIRI=_restrictedEntity.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((EntityScalarDataPropertyRestrictionAxiom)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          EntityScalarDataProperty _scalarProperty = ((EntityScalarDataPropertyRestrictionAxiom)e).getScalarProperty();
          String _abbrevIRI_1 = null;
          if (_scalarProperty!=null) {
            _abbrevIRI_1=_scalarProperty.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((EntityScalarDataPropertyRestrictionAxiom)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof EntityStructuredDataPropertyParticularRestrictionAxiom) {
          _matched=true;
          String _elvis = null;
          Entity _restrictedEntity = ((EntityStructuredDataPropertyParticularRestrictionAxiom)e).getRestrictedEntity();
          String _abbrevIRI = null;
          if (_restrictedEntity!=null) {
            _abbrevIRI=_restrictedEntity.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((EntityStructuredDataPropertyParticularRestrictionAxiom)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          DataRelationshipToStructure _structuredDataProperty = ((EntityStructuredDataPropertyParticularRestrictionAxiom)e).getStructuredDataProperty();
          String _abbrevIRI_1 = null;
          if (_structuredDataProperty!=null) {
            _abbrevIRI_1=_structuredDataProperty.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((EntityStructuredDataPropertyParticularRestrictionAxiom)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof RestrictionStructuredDataPropertyTuple) {
          _matched=true;
          String _elvis = null;
          DataRelationshipToStructure _structuredDataProperty = ((RestrictionStructuredDataPropertyTuple)e).getStructuredDataProperty();
          String _abbrevIRI = null;
          if (_structuredDataProperty!=null) {
            _abbrevIRI=_structuredDataProperty.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            _elvis = "";
          }
          String _plus = (_elvis + ".");
          String _string = ((RestrictionStructuredDataPropertyTuple)e).uuid().toString();
          _switchResult = (_plus + _string);
        }
      }
      if (!_matched) {
        if (e instanceof RestrictionScalarDataPropertyValue) {
          _matched=true;
          String _elvis = null;
          DataRelationshipToScalar _scalarDataProperty = ((RestrictionScalarDataPropertyValue)e).getScalarDataProperty();
          String _abbrevIRI = null;
          if (_scalarDataProperty!=null) {
            _abbrevIRI=_scalarDataProperty.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            _elvis = "";
          }
          String _plus = (_elvis + ".");
          String _string = ((RestrictionScalarDataPropertyValue)e).uuid().toString();
          _switchResult = (_plus + _string);
        }
      }
      if (!_matched) {
        if (e instanceof ScalarOneOfLiteralAxiom) {
          _matched=true;
          String _elvis = null;
          ScalarOneOfRestriction _axiom = ((ScalarOneOfLiteralAxiom)e).getAxiom();
          String _abbrevIRI = null;
          if (_axiom!=null) {
            _abbrevIRI=_axiom.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((ScalarOneOfLiteralAxiom)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          LiteralValue _value = ((ScalarOneOfLiteralAxiom)e).getValue();
          String _sortingCriteria = null;
          if (_value!=null) {
            _sortingCriteria=OMLExtensions.sortingCriteria(_value);
          }
          if (_sortingCriteria != null) {
            _elvis_1 = _sortingCriteria;
          } else {
            String _string_1 = ((ScalarOneOfLiteralAxiom)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof SpecializationAxiom) {
          _matched=true;
          String _elvis = null;
          Entity _child = ((SpecializationAxiom)e).child();
          String _abbrevIRI = null;
          if (_child!=null) {
            _abbrevIRI=_child.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((SpecializationAxiom)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          Entity _parent = ((SpecializationAxiom)e).parent();
          String _abbrevIRI_1 = null;
          if (_parent!=null) {
            _abbrevIRI_1=_parent.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((SpecializationAxiom)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof ConceptualEntitySingletonInstance) {
          _matched=true;
          _switchResult = ((ConceptualEntitySingletonInstance)e).abbrevIRI();
        }
      }
      if (!_matched) {
        if (e instanceof ReifiedRelationshipInstanceDomain) {
          _matched=true;
          String _elvis = null;
          ReifiedRelationshipInstance _reifiedRelationshipInstance = ((ReifiedRelationshipInstanceDomain)e).getReifiedRelationshipInstance();
          String _abbrevIRI = null;
          if (_reifiedRelationshipInstance!=null) {
            _abbrevIRI=_reifiedRelationshipInstance.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((ReifiedRelationshipInstanceDomain)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          ConceptualEntitySingletonInstance _domain = ((ReifiedRelationshipInstanceDomain)e).getDomain();
          String _abbrevIRI_1 = null;
          if (_domain!=null) {
            _abbrevIRI_1=_domain.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((ReifiedRelationshipInstanceDomain)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof ReifiedRelationshipInstanceRange) {
          _matched=true;
          String _elvis = null;
          ReifiedRelationshipInstance _reifiedRelationshipInstance = ((ReifiedRelationshipInstanceRange)e).getReifiedRelationshipInstance();
          String _abbrevIRI = null;
          if (_reifiedRelationshipInstance!=null) {
            _abbrevIRI=_reifiedRelationshipInstance.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((ReifiedRelationshipInstanceRange)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          ConceptualEntitySingletonInstance _range = ((ReifiedRelationshipInstanceRange)e).getRange();
          String _abbrevIRI_1 = null;
          if (_range!=null) {
            _abbrevIRI_1=_range.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((ReifiedRelationshipInstanceRange)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof UnreifiedRelationshipInstanceTuple) {
          _matched=true;
          String _elvis = null;
          UnreifiedRelationship _unreifiedRelationship = ((UnreifiedRelationshipInstanceTuple)e).getUnreifiedRelationship();
          String _abbrevIRI = null;
          if (_unreifiedRelationship!=null) {
            _abbrevIRI=_unreifiedRelationship.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((UnreifiedRelationshipInstanceTuple)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          ConceptualEntitySingletonInstance _domain = ((UnreifiedRelationshipInstanceTuple)e).getDomain();
          String _abbrevIRI_1 = null;
          if (_domain!=null) {
            _abbrevIRI_1=_domain.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((UnreifiedRelationshipInstanceTuple)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          String _plus_1 = (_plus + _elvis_1);
          String _plus_2 = (_plus_1 + ".");
          String _elvis_2 = null;
          ConceptualEntitySingletonInstance _range = ((UnreifiedRelationshipInstanceTuple)e).getRange();
          String _abbrevIRI_2 = null;
          if (_range!=null) {
            _abbrevIRI_2=_range.abbrevIRI();
          }
          if (_abbrevIRI_2 != null) {
            _elvis_2 = _abbrevIRI_2;
          } else {
            String _string_2 = ((UnreifiedRelationshipInstanceTuple)e).uuid().toString();
            _elvis_2 = _string_2;
          }
          _switchResult = (_plus_2 + _elvis_2);
        }
      }
      if (!_matched) {
        if (e instanceof SubObjectPropertyOfAxiom) {
          _matched=true;
          String _elvis = null;
          UnreifiedRelationship _superProperty = ((SubObjectPropertyOfAxiom)e).getSuperProperty();
          String _abbrevIRI = null;
          if (_superProperty!=null) {
            _abbrevIRI=_superProperty.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((SubObjectPropertyOfAxiom)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          UnreifiedRelationship _subProperty = ((SubObjectPropertyOfAxiom)e).getSubProperty();
          String _abbrevIRI_1 = null;
          if (_subProperty!=null) {
            _abbrevIRI_1=_subProperty.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((SubObjectPropertyOfAxiom)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof SubDataPropertyOfAxiom) {
          _matched=true;
          String _elvis = null;
          EntityScalarDataProperty _superProperty = ((SubDataPropertyOfAxiom)e).getSuperProperty();
          String _abbrevIRI = null;
          if (_superProperty!=null) {
            _abbrevIRI=_superProperty.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((SubDataPropertyOfAxiom)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          EntityScalarDataProperty _subProperty = ((SubDataPropertyOfAxiom)e).getSubProperty();
          String _abbrevIRI_1 = null;
          if (_subProperty!=null) {
            _abbrevIRI_1=_subProperty.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((SubDataPropertyOfAxiom)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof SingletonInstanceStructuredDataPropertyValue) {
          _matched=true;
          String _elvis = null;
          ConceptualEntitySingletonInstance _singletonInstance = ((SingletonInstanceStructuredDataPropertyValue)e).getSingletonInstance();
          String _abbrevIRI = null;
          if (_singletonInstance!=null) {
            _abbrevIRI=_singletonInstance.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis = _abbrevIRI;
          } else {
            String _string = ((SingletonInstanceStructuredDataPropertyValue)e).uuid().toString();
            _elvis = _string;
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          DataRelationshipToStructure _structuredDataProperty = ((SingletonInstanceStructuredDataPropertyValue)e).getStructuredDataProperty();
          String _abbrevIRI_1 = null;
          if (_structuredDataProperty!=null) {
            _abbrevIRI_1=_structuredDataProperty.abbrevIRI();
          }
          if (_abbrevIRI_1 != null) {
            _elvis_1 = _abbrevIRI_1;
          } else {
            String _string_1 = ((SingletonInstanceStructuredDataPropertyValue)e).uuid().toString();
            _elvis_1 = _string_1;
          }
          _switchResult = (_plus + _elvis_1);
        }
      }
      if (!_matched) {
        if (e instanceof StructuredDataPropertyTuple) {
          _matched=true;
          String _elvis = null;
          SingletonInstanceStructuredDataPropertyContext _structuredDataPropertyContext = ((StructuredDataPropertyTuple)e).getStructuredDataPropertyContext();
          String _uuid = null;
          if (_structuredDataPropertyContext!=null) {
            _uuid=_structuredDataPropertyContext.uuid();
          }
          if (_uuid != null) {
            _elvis = _uuid;
          } else {
            _elvis = "";
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          DataRelationshipToStructure _structuredDataProperty = ((StructuredDataPropertyTuple)e).getStructuredDataProperty();
          String _abbrevIRI = null;
          if (_structuredDataProperty!=null) {
            _abbrevIRI=_structuredDataProperty.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis_1 = _abbrevIRI;
          } else {
            _elvis_1 = "";
          }
          String _plus_1 = (_plus + _elvis_1);
          String _plus_2 = (_plus_1 + ".");
          String _string = ((StructuredDataPropertyTuple)e).uuid().toString();
          _switchResult = (_plus_2 + _string);
        }
      }
      if (!_matched) {
        if (e instanceof ScalarDataPropertyValue) {
          _matched=true;
          String _elvis = null;
          SingletonInstanceStructuredDataPropertyContext _structuredDataPropertyContext = ((ScalarDataPropertyValue)e).getStructuredDataPropertyContext();
          String _uuid = null;
          if (_structuredDataPropertyContext!=null) {
            _uuid=_structuredDataPropertyContext.uuid();
          }
          if (_uuid != null) {
            _elvis = _uuid;
          } else {
            _elvis = "";
          }
          String _plus = (_elvis + ".");
          String _elvis_1 = null;
          DataRelationshipToScalar _scalarDataProperty = ((ScalarDataPropertyValue)e).getScalarDataProperty();
          String _abbrevIRI = null;
          if (_scalarDataProperty!=null) {
            _abbrevIRI=_scalarDataProperty.abbrevIRI();
          }
          if (_abbrevIRI != null) {
            _elvis_1 = _abbrevIRI;
          } else {
            _elvis_1 = "";
          }
          String _plus_1 = (_plus + _elvis_1);
          String _plus_2 = (_plus_1 + ".");
          String _string = ((ScalarDataPropertyValue)e).uuid().toString();
          _switchResult = (_plus_2 + _string);
        }
      }
      final String c = _switchResult;
      String _nestedKindOrder = OMLExtensions.nestedKindOrder(e);
      _xblockexpression = (_nestedKindOrder + c);
    }
    return _xblockexpression;
  }
  
  public static String sortingCriteria(final LiteralValue e) {
    String _switchResult = null;
    boolean _matched = false;
    if (e instanceof LiteralBoolean) {
      _matched=true;
      _switchResult = ((LiteralBoolean)e).value().toString();
    }
    if (!_matched) {
      if (e instanceof LiteralDateTime) {
        _matched=true;
        _switchResult = ((LiteralDateTime)e).getDateTime().value;
      }
    }
    if (!_matched) {
      if (e instanceof LiteralDecimal) {
        _matched=true;
        _switchResult = ((LiteralDecimal)e).getDecimal().value;
      }
    }
    if (!_matched) {
      if (e instanceof LiteralFloat) {
        _matched=true;
        _switchResult = ((LiteralFloat)e).getFloat().value;
      }
    }
    if (!_matched) {
      if (e instanceof LiteralRational) {
        _matched=true;
        _switchResult = ((LiteralRational)e).getRational().value;
      }
    }
    if (!_matched) {
      if (e instanceof LiteralReal) {
        _matched=true;
        _switchResult = ((LiteralReal)e).getReal().value;
      }
    }
    if (!_matched) {
      if (e instanceof LiteralQuotedString) {
        _matched=true;
        _switchResult = ((LiteralQuotedString)e).getString().value;
      }
    }
    if (!_matched) {
      if (e instanceof LiteralRawString) {
        _matched=true;
        _switchResult = ((LiteralRawString)e).getString().value;
      }
    }
    if (!_matched) {
      if (e instanceof LiteralURI) {
        _matched=true;
        _switchResult = ((LiteralURI)e).getUri().value;
      }
    }
    if (!_matched) {
      if (e instanceof LiteralUUID) {
        _matched=true;
        _switchResult = ((LiteralUUID)e).getUuid().value;
      }
    }
    return _switchResult;
  }
  
  public static String sortingCriteria(final AnnotationPropertyValue e) {
    String _elvis = null;
    AnnotationProperty _property = e.getProperty();
    String _abbrevIRI = null;
    if (_property!=null) {
      _abbrevIRI=_property.getAbbrevIRI();
    }
    if (_abbrevIRI != null) {
      _elvis = _abbrevIRI;
    } else {
      String _uuid = e.uuid();
      _elvis = _uuid;
    }
    return _elvis;
  }
  
  public static void normalize(final EObject it) {
    if (it instanceof Bundle) {
      _normalize((Bundle)it);
      return;
    } else if (it instanceof TerminologyGraph) {
      _normalize((TerminologyGraph)it);
      return;
    } else if (it instanceof DescriptionBox) {
      _normalize((DescriptionBox)it);
      return;
    } else if (it instanceof Extent) {
      _normalize((Extent)it);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  protected static void normalizeSubElements(final LogicalElement e) {
    if (e instanceof AnonymousConceptUnionAxiom) {
      _normalizeSubElements((AnonymousConceptUnionAxiom)e);
      return;
    } else if (e instanceof RootConceptTaxonomyAxiom) {
      _normalizeSubElements((RootConceptTaxonomyAxiom)e);
      return;
    } else if (e instanceof SpecificDisjointConceptAxiom) {
      _normalizeSubElements((SpecificDisjointConceptAxiom)e);
      return;
    } else if (e instanceof ModuleEdge) {
      _normalizeSubElements((ModuleEdge)e);
      return;
    } else if (e instanceof TerminologyBoxStatement) {
      _normalizeSubElements((TerminologyBoxStatement)e);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
