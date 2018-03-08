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
package gov.nasa.jpl.imce.oml.dsl.linking;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.dsl.scoping.OMLScopeExtensions;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.xml.resolver.Catalog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * OMLLinkingService resolves Xtext cross-references in OML textual models.
 * The implementation of getLinkedObjects(context, ref, node) involves a significant work
 * to find the intended reference in the scope of possible objects in the context for the given reference property.
 * 
 * The result of this expensive cross-reference linking service can be cached when the resource set will not change
 * (i.e., the contents are effectively read-only).
 */
@SuppressWarnings("all")
public class OMLLinkingService extends DefaultLinkingService {
  private final static String RESOURCE_SET_READONLY_OML_LINKING_CACHE = "RESOURCE_SET_READONLY_OML_LINKING_CACHE";
  
  public static void clearCache(final ResourceSet rs) {
    OMLScopeExtensions.clearCache(rs);
    rs.getLoadOptions().remove(OMLLinkingService.RESOURCE_SET_READONLY_OML_LINKING_CACHE);
  }
  
  public static void initializeCache(final ResourceSet rs) {
    OMLScopeExtensions.initializeCache(rs);
    final HashMap<EObject, HashMap<EReference, List<EObject>>> cache = new HashMap<EObject, HashMap<EReference, List<EObject>>>();
    final Object prev = rs.getLoadOptions().put(OMLLinkingService.RESOURCE_SET_READONLY_OML_LINKING_CACHE, cache);
    if ((null != prev)) {
      throw new IllegalArgumentException("OMLLinkingService.initializeReadOnlyOMLLinkiCache(): The cache should be initialized only once!");
    }
  }
  
  public static HashMap<EObject, HashMap<EReference, List<EObject>>> lookupReadOnlyOMLLinkingCache(final ResourceSet rs) {
    HashMap<EObject, HashMap<EReference, List<EObject>>> _xblockexpression = null;
    {
      final Object cache = rs.getLoadOptions().get(OMLLinkingService.RESOURCE_SET_READONLY_OML_LINKING_CACHE);
      HashMap<EObject, HashMap<EReference, List<EObject>>> _switchResult = null;
      boolean _matched = false;
      if (cache instanceof HashMap) {
        _matched=true;
        _switchResult = ((HashMap<EObject, HashMap<EReference, List<EObject>>>)cache);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static HashMap<EObject, HashMap<EReference, List<EObject>>> lookupReadOnlyOMLLinkingCache(final EObject context) {
    HashMap<EObject, HashMap<EReference, List<EObject>>> _xblockexpression = null;
    {
      Resource _eResource = null;
      if (context!=null) {
        _eResource=context.eResource();
      }
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      final ResourceSet rs = _resourceSet;
      HashMap<EObject, HashMap<EReference, List<EObject>>> _xifexpression = null;
      if ((null != rs)) {
        _xifexpression = OMLLinkingService.lookupReadOnlyOMLLinkingCache(rs);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Override
  public List<EObject> getLinkedObjects(final EObject context, final EReference ref, final INode node) throws IllegalNodeException {
    try {
      List<EObject> _xblockexpression = null;
      {
        final EClass requiredType = ref.getEReferenceType();
        if ((null == requiredType)) {
          return Collections.<EObject>emptyList();
        }
        final String crossRefString = this.getCrossRefNodeAsString(node);
        if (((null == crossRefString) || crossRefString.equals(""))) {
          return Collections.<EObject>emptyList();
        }
        if ((crossRefString.startsWith("<") && crossRefString.endsWith(">"))) {
          final ResourceSet rs = context.eResource().getResourceSet();
          if ((null == rs)) {
            return Collections.<EObject>emptyList();
          }
          int _length = crossRefString.length();
          int _minus = (_length - 1);
          final String crossRefIRI = crossRefString.substring(1, _minus);
          final int fragmentIndex = crossRefIRI.indexOf("#");
          String _xifexpression = null;
          if (((-1) == fragmentIndex)) {
            _xifexpression = crossRefIRI;
          } else {
            _xifexpression = crossRefIRI.substring(1, (fragmentIndex - 1));
          }
          final String resourceIRI = _xifexpression;
          if ((fragmentIndex > 0)) {
            throw new IllegalNodeException(node, 
              ("Cross-reference cannot specify a fragment OML Entity: " + crossRefIRI));
          }
          final Catalog catalog = OMLExtensions.findCatalogIfExists(context.eResource());
          if ((null == catalog)) {
            final EClassifier refType = ref.getEType();
            boolean _matched = false;
            EClass _bundle = BundlesPackage.eINSTANCE.getBundle();
            if (Objects.equal(refType, _bundle)) {
              _matched=true;
              final Function1<Resource, Iterable<Bundle>> _function = (Resource it) -> {
                final Function1<Extent, Iterable<Bundle>> _function_1 = (Extent it_1) -> {
                  return Iterables.<Bundle>filter(it_1.getModules(), Bundle.class);
                };
                return Iterables.<Bundle>concat(IterableExtensions.<Extent, Iterable<Bundle>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function_1));
              };
              final Function1<Bundle, Boolean> _function_1 = (Bundle b) -> {
                String _iri = b.iri();
                return Boolean.valueOf(Objects.equal(_iri, resourceIRI));
              };
              final Bundle bundle = IterableExtensions.<Bundle>findFirst(Iterables.<Bundle>concat(ListExtensions.<Resource, Iterable<Bundle>>map(rs.getResources(), _function)), _function_1);
              if ((null != bundle)) {
                return Collections.<EObject>singletonList(bundle);
              }
            }
            if (!_matched) {
              EClass _terminologyBox = TerminologiesPackage.eINSTANCE.getTerminologyBox();
              if (Objects.equal(refType, _terminologyBox)) {
                _matched=true;
                final Function1<Resource, Iterable<TerminologyBox>> _function_2 = (Resource it) -> {
                  final Function1<Extent, Iterable<TerminologyBox>> _function_3 = (Extent it_1) -> {
                    return Iterables.<TerminologyBox>filter(it_1.getModules(), TerminologyBox.class);
                  };
                  return Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function_3));
                };
                final Function1<TerminologyBox, Boolean> _function_3 = (TerminologyBox tbox) -> {
                  String _iri = tbox.iri();
                  return Boolean.valueOf(Objects.equal(_iri, resourceIRI));
                };
                final TerminologyBox tbox = IterableExtensions.<TerminologyBox>findFirst(Iterables.<TerminologyBox>concat(ListExtensions.<Resource, Iterable<TerminologyBox>>map(rs.getResources(), _function_2)), _function_3);
                if ((null != tbox)) {
                  return Collections.<EObject>singletonList(tbox);
                }
              }
            }
            if (!_matched) {
              EClass _descriptionBox = DescriptionsPackage.eINSTANCE.getDescriptionBox();
              if (Objects.equal(refType, _descriptionBox)) {
                _matched=true;
                final Function1<Resource, Iterable<DescriptionBox>> _function_4 = (Resource it) -> {
                  final Function1<Extent, Iterable<DescriptionBox>> _function_5 = (Extent it_1) -> {
                    return Iterables.<DescriptionBox>filter(it_1.getModules(), DescriptionBox.class);
                  };
                  return Iterables.<DescriptionBox>concat(IterableExtensions.<Extent, Iterable<DescriptionBox>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function_5));
                };
                final Function1<DescriptionBox, Boolean> _function_5 = (DescriptionBox dbox) -> {
                  String _iri = dbox.iri();
                  return Boolean.valueOf(Objects.equal(_iri, resourceIRI));
                };
                final DescriptionBox dbox = IterableExtensions.<DescriptionBox>findFirst(Iterables.<DescriptionBox>concat(ListExtensions.<Resource, Iterable<DescriptionBox>>map(rs.getResources(), _function_4)), _function_5);
                if ((null != dbox)) {
                  return Collections.<EObject>singletonList(dbox);
                }
              }
            }
            if (!_matched) {
            }
            throw new IllegalNodeException(node, 
              (((("IRI Cross-reference resolution for " + crossRefString) + " requires an ") + 
                OMLExtensions.OML_CATALOG_XML) + " file; but no such catalog file was found!"));
          } else {
            String _elvis = null;
            String _resolveURI = catalog.resolveURI((resourceIRI + ".oml"));
            if (_resolveURI != null) {
              _elvis = _resolveURI;
            } else {
              String _resolveURI_1 = catalog.resolveURI((resourceIRI + ".omlzip"));
              _elvis = _resolveURI_1;
            }
            final String resolvedIRI = _elvis;
            if (((null == resolvedIRI) || Objects.equal(resolvedIRI, resourceIRI))) {
              return Collections.<EObject>emptyList();
            }
            final Resource resolvedOML = rs.getResource(URI.createURI(resolvedIRI), true);
            final StringBuffer problems = new StringBuffer();
            final Consumer<Resource.Diagnostic> _function_6 = (Resource.Diagnostic e) -> {
              boolean _matched_1 = false;
              if (e instanceof Diagnostic) {
                _matched_1=true;
                String _message = ((Diagnostic)e).getMessage();
                String _plus = ("\n" + _message);
                String _plus_1 = (_plus + " at ");
                String _location = ((Diagnostic)e).getLocation();
                String _plus_2 = (_plus_1 + _location);
                String _plus_3 = (_plus_2 + " line:");
                int _line = ((Diagnostic)e).getLine();
                String _plus_4 = (_plus_3 + Integer.valueOf(_line));
                String _plus_5 = (_plus_4 + ", column:");
                int _column = ((Diagnostic)e).getColumn();
                String _plus_6 = (_plus_5 + Integer.valueOf(_column));
                String _plus_7 = (_plus_6 + 
                  ", offset:");
                int _offset = ((Diagnostic)e).getOffset();
                String _plus_8 = (_plus_7 + Integer.valueOf(_offset));
                String _plus_9 = (_plus_8 + ", length:");
                int _length_1 = ((Diagnostic)e).getLength();
                String _plus_10 = (_plus_9 + Integer.valueOf(_length_1));
                problems.append(_plus_10);
              }
              if (!_matched_1) {
                String _message = e.getMessage();
                String _plus = ("\n" + _message);
                String _plus_1 = (_plus + " at ");
                String _location = e.getLocation();
                String _plus_2 = (_plus_1 + _location);
                String _plus_3 = (_plus_2 + " line:");
                int _line = e.getLine();
                String _plus_4 = (_plus_3 + Integer.valueOf(_line));
                String _plus_5 = (_plus_4 + ", column:");
                int _column = e.getColumn();
                String _plus_6 = (_plus_5 + Integer.valueOf(_column));
                problems.append(_plus_6);
              }
            };
            resolvedOML.getErrors().forEach(_function_6);
            final Consumer<Resource.Diagnostic> _function_7 = (Resource.Diagnostic e) -> {
              boolean _matched_1 = false;
              if (e instanceof Diagnostic) {
                _matched_1=true;
                String _message = ((Diagnostic)e).getMessage();
                String _plus = (_message + " at ");
                String _location = ((Diagnostic)e).getLocation();
                String _plus_1 = (_plus + _location);
                String _plus_2 = (_plus_1 + " line:");
                int _line = ((Diagnostic)e).getLine();
                String _plus_3 = (_plus_2 + Integer.valueOf(_line));
                String _plus_4 = (_plus_3 + ", column:");
                int _column = ((Diagnostic)e).getColumn();
                String _plus_5 = (_plus_4 + Integer.valueOf(_column));
                String _plus_6 = (_plus_5 + 
                  ", offset:");
                int _offset = ((Diagnostic)e).getOffset();
                String _plus_7 = (_plus_6 + Integer.valueOf(_offset));
                String _plus_8 = (_plus_7 + ", length:");
                int _length_1 = ((Diagnostic)e).getLength();
                String _plus_9 = (_plus_8 + Integer.valueOf(_length_1));
                problems.append(_plus_9);
              }
              if (!_matched_1) {
                String _message = e.getMessage();
                String _plus = (_message + " at ");
                String _location = e.getLocation();
                String _plus_1 = (_plus + _location);
                String _plus_2 = (_plus_1 + " line:");
                int _line = e.getLine();
                String _plus_3 = (_plus_2 + Integer.valueOf(_line));
                String _plus_4 = (_plus_3 + ", column:");
                int _column = e.getColumn();
                String _plus_5 = (_plus_4 + Integer.valueOf(_column));
                problems.append(_plus_5);
              }
            };
            resolvedOML.getWarnings().forEach(_function_7);
            if (((!resolvedOML.getErrors().isEmpty()) || (!resolvedOML.getWarnings().isEmpty()))) {
              String _string = problems.toString();
              String _plus = ((((("IRI cross reference problems\nCross reference:\n" + crossRefString) + 
                "\nResolved IRI:\n") + resolvedIRI) + 
                "\n") + _string);
              throw new IllegalNodeException(node, _plus);
            }
            final EClassifier refType_1 = ref.getEType();
            boolean _matched_1 = false;
            EClass _bundle_1 = BundlesPackage.eINSTANCE.getBundle();
            if (Objects.equal(refType_1, _bundle_1)) {
              _matched_1=true;
              final Function1<Resource, Iterable<Bundle>> _function_8 = (Resource it) -> {
                final Function1<Extent, Iterable<Bundle>> _function_9 = (Extent it_1) -> {
                  return Iterables.<Bundle>filter(it_1.getModules(), Bundle.class);
                };
                return Iterables.<Bundle>concat(IterableExtensions.<Extent, Iterable<Bundle>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function_9));
              };
              final Function1<Bundle, Boolean> _function_9 = (Bundle b) -> {
                return Boolean.valueOf((Objects.equal(b.iri(), resolvedIRI) || Objects.equal(b.iri(), resourceIRI)));
              };
              final Bundle bundle_1 = IterableExtensions.<Bundle>findFirst(Iterables.<Bundle>concat(ListExtensions.<Resource, Iterable<Bundle>>map(rs.getResources(), _function_8)), _function_9);
              List<EObject> _xifexpression_1 = null;
              if ((null == bundle_1)) {
                _xifexpression_1 = Collections.<EObject>emptyList();
              } else {
                _xifexpression_1 = Collections.<EObject>singletonList(bundle_1);
              }
              return _xifexpression_1;
            }
            if (!_matched_1) {
              EClass _terminologyBox_1 = TerminologiesPackage.eINSTANCE.getTerminologyBox();
              if (Objects.equal(refType_1, _terminologyBox_1)) {
                _matched_1=true;
                final Function1<Resource, Iterable<TerminologyBox>> _function_10 = (Resource it) -> {
                  final Function1<Extent, Iterable<TerminologyBox>> _function_11 = (Extent it_1) -> {
                    return Iterables.<TerminologyBox>filter(it_1.getModules(), TerminologyBox.class);
                  };
                  return Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function_11));
                };
                final Function1<TerminologyBox, Boolean> _function_11 = (TerminologyBox tbox_1) -> {
                  return Boolean.valueOf((Objects.equal(tbox_1.iri(), resolvedIRI) || Objects.equal(tbox_1.iri(), resourceIRI)));
                };
                final TerminologyBox tbox_1 = IterableExtensions.<TerminologyBox>findFirst(Iterables.<TerminologyBox>concat(ListExtensions.<Resource, Iterable<TerminologyBox>>map(rs.getResources(), _function_10)), _function_11);
                List<EObject> _xifexpression_2 = null;
                if ((null == tbox_1)) {
                  _xifexpression_2 = Collections.<EObject>emptyList();
                } else {
                  _xifexpression_2 = Collections.<EObject>singletonList(tbox_1);
                }
                return _xifexpression_2;
              }
            }
            if (!_matched_1) {
              EClass _descriptionBox_1 = DescriptionsPackage.eINSTANCE.getDescriptionBox();
              if (Objects.equal(refType_1, _descriptionBox_1)) {
                _matched_1=true;
                final Function1<Resource, Iterable<DescriptionBox>> _function_12 = (Resource it) -> {
                  final Function1<Extent, Iterable<DescriptionBox>> _function_13 = (Extent it_1) -> {
                    return Iterables.<DescriptionBox>filter(it_1.getModules(), DescriptionBox.class);
                  };
                  return Iterables.<DescriptionBox>concat(IterableExtensions.<Extent, Iterable<DescriptionBox>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function_13));
                };
                final Function1<DescriptionBox, Boolean> _function_13 = (DescriptionBox dbox_1) -> {
                  return Boolean.valueOf((Objects.equal(dbox_1.iri(), resolvedIRI) || Objects.equal(dbox_1.iri(), resourceIRI)));
                };
                final DescriptionBox dbox_1 = IterableExtensions.<DescriptionBox>findFirst(Iterables.<DescriptionBox>concat(ListExtensions.<Resource, Iterable<DescriptionBox>>map(rs.getResources(), _function_12)), _function_13);
                List<EObject> _xifexpression_3 = null;
                if ((null == dbox_1)) {
                  _xifexpression_3 = Collections.<EObject>emptyList();
                } else {
                  _xifexpression_3 = Collections.<EObject>singletonList(dbox_1);
                }
                return _xifexpression_3;
              }
            }
            return Collections.<EObject>emptyList();
          }
        }
        HashMap<EReference, List<EObject>> refCache = null;
        final HashMap<EObject, HashMap<EReference, List<EObject>>> contextCache = OMLLinkingService.lookupReadOnlyOMLLinkingCache(context);
        if ((null != contextCache)) {
          final Function<EObject, HashMap<EReference, List<EObject>>> _function_14 = (EObject it) -> {
            return new HashMap<EReference, List<EObject>>();
          };
          refCache = contextCache.computeIfAbsent(context, _function_14);
          final List<EObject> result = refCache.get(ref);
          if ((null != result)) {
            return result;
          }
        }
        if ((AnnotationPropertyValue.class.isInstance(context) && Objects.equal(ref, CommonPackage.eINSTANCE.getAnnotationPropertyValue_Property()))) {
          final AnnotationPropertyValue aContext = AnnotationPropertyValue.class.cast(context);
          final INode nextNode = node.getParent().getNextSibling();
          final EObject nextSE = IterableExtensions.<ILeafNode>head(nextNode.getLeafNodes()).getSemanticElement();
          boolean _matched_2 = false;
          if (nextSE instanceof LogicalElement) {
            _matched_2=true;
            aContext.setSubject(((LogicalElement)nextSE));
          }
          if (!_matched_2) {
            if (nextSE instanceof AnnotationPropertyValue) {
              _matched_2=true;
              final Iterable<ILeafNode> nextLeafNodes = nextNode.getLeafNodes();
              final Function1<ILeafNode, Boolean> _function_15 = (ILeafNode n) -> {
                return Boolean.valueOf(CrossReference.class.isInstance(n.getGrammarElement()));
              };
              final ILeafNode n1 = IterableExtensions.<ILeafNode>findFirst(nextLeafNodes, _function_15);
              this.getLinkedObjects(nextSE, ref, n1);
              aContext.setSubject(((AnnotationPropertyValue)nextSE).getSubject());
            }
          }
        }
        final IScope scope = this.getScope(context, ref);
        final QualifiedName qualifiedLinkName = this.qualifiedNameConverter.toQualifiedName(crossRefString);
        final IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedLinkName);
        List<EObject> _xifexpression_4 = null;
        if ((null == eObjectDescription)) {
          List<EObject> _xblockexpression_1 = null;
          {
            final List<EObject> defaultResult = super.getLinkedObjects(context, ref, node);
            List<EObject> _xifexpression_5 = null;
            if (((defaultResult != null) && (!defaultResult.isEmpty()))) {
              _xifexpression_5 = defaultResult;
            } else {
              _xifexpression_5 = Collections.<EObject>emptyList();
            }
            _xblockexpression_1 = _xifexpression_5;
          }
          _xifexpression_4 = _xblockexpression_1;
        } else {
          List<EObject> _xblockexpression_2 = null;
          {
            final EObject e = eObjectDescription.getEObjectOrProxy();
            _xblockexpression_2 = Collections.<EObject>singletonList(e);
          }
          _xifexpression_4 = _xblockexpression_2;
        }
        final List<EObject> result_1 = _xifexpression_4;
        if (refCache!=null) {
          refCache.put(ref, result_1);
        }
        _xblockexpression = result_1;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
