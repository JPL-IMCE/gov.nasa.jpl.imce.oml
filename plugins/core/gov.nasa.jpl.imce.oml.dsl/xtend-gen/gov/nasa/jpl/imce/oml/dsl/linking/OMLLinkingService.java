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
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.apache.xml.resolver.Catalog;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class OMLLinkingService extends DefaultLinkingService {
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Override
  public List<EObject> getLinkedObjects(final EObject context, final EReference ref, final INode node) throws IllegalNodeException {
    try {
      final EClass requiredType = ref.getEReferenceType();
      if ((null == requiredType)) {
        return Collections.<EObject>emptyList();
      }
      final String crossRefString = this.getCrossRefNodeAsString(node);
      if (((null == crossRefString) || crossRefString.equals(""))) {
        return Collections.<EObject>emptyList();
      }
      if ((crossRefString.startsWith("<") && crossRefString.endsWith(">"))) {
        Resource _eResource = context.eResource();
        final ResourceSet rs = _eResource.getResourceSet();
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
        final String refIRI = _xifexpression;
        String _xifexpression_1 = null;
        boolean _endsWith = refIRI.endsWith("/");
        if (_endsWith) {
          int _length_1 = refIRI.length();
          int _minus_1 = (_length_1 - 1);
          _xifexpression_1 = refIRI.substring(0, _minus_1);
        } else {
          _xifexpression_1 = refIRI;
        }
        final String resourceIRI = _xifexpression_1;
        if ((fragmentIndex > 0)) {
          throw new IllegalNodeException(node, 
            ("Cross-reference cannot specify a fragment OML Entity: " + crossRefIRI));
        }
        Resource _eResource_1 = context.eResource();
        final Catalog catalog = OMLExtensions.findCatalogIfExists(_eResource_1);
        if ((null == catalog)) {
          throw new IllegalNodeException(node, 
            (((("IRI Cross-reference resolution for " + crossRefString) + " requires an ") + 
              OMLExtensions.OML_CATALOG_XML) + " file; but no such catalog file was found!"));
        } else {
          final String resolvedIRI = catalog.resolveURI((resourceIRI + ".oml"));
          if (((null == resolvedIRI) || Objects.equal(resolvedIRI, resourceIRI))) {
            return Collections.<EObject>emptyList();
          }
          URI _createURI = URI.createURI(resolvedIRI);
          final Resource resolvedOML = rs.getResource(_createURI, true);
          final StringBuffer problems = new StringBuffer();
          EList<Resource.Diagnostic> _errors = resolvedOML.getErrors();
          final Consumer<Resource.Diagnostic> _function = (Resource.Diagnostic e) -> {
            boolean _matched = false;
            if (e instanceof Diagnostic) {
              _matched=true;
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
              int _length_2 = ((Diagnostic)e).getLength();
              String _plus_10 = (_plus_9 + Integer.valueOf(_length_2));
              problems.append(_plus_10);
            }
            if (!_matched) {
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
          _errors.forEach(_function);
          EList<Resource.Diagnostic> _warnings = resolvedOML.getWarnings();
          final Consumer<Resource.Diagnostic> _function_1 = (Resource.Diagnostic e) -> {
            boolean _matched = false;
            if (e instanceof Diagnostic) {
              _matched=true;
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
              int _length_2 = ((Diagnostic)e).getLength();
              String _plus_9 = (_plus_8 + Integer.valueOf(_length_2));
              problems.append(_plus_9);
            }
            if (!_matched) {
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
          _warnings.forEach(_function_1);
          if (((!resolvedOML.getErrors().isEmpty()) || (!resolvedOML.getWarnings().isEmpty()))) {
            String _string = problems.toString();
            String _plus = ((((("IRI cross reference problems\nCross reference:\n" + crossRefString) + 
              "\nResolved IRI:\n") + resolvedIRI) + 
              "\n") + _string);
            throw new IllegalNodeException(node, _plus);
          }
          final EClassifier refType = ref.getEType();
          boolean _matched = false;
          EClass _bundle = BundlesPackage.eINSTANCE.getBundle();
          if (Objects.equal(refType, _bundle)) {
            _matched=true;
            EList<Resource> _resources = rs.getResources();
            final Function1<Resource, Iterable<Bundle>> _function_2 = (Resource it) -> {
              EList<EObject> _contents = it.getContents();
              Iterable<Extent> _filter = Iterables.<Extent>filter(_contents, Extent.class);
              final Function1<Extent, Iterable<Bundle>> _function_3 = (Extent it_1) -> {
                EList<Module> _modules = it_1.getModules();
                return Iterables.<Bundle>filter(_modules, Bundle.class);
              };
              Iterable<Iterable<Bundle>> _map = IterableExtensions.<Extent, Iterable<Bundle>>map(_filter, _function_3);
              return Iterables.<Bundle>concat(_map);
            };
            List<Iterable<Bundle>> _map = ListExtensions.<Resource, Iterable<Bundle>>map(_resources, _function_2);
            Iterable<Bundle> _flatten = Iterables.<Bundle>concat(_map);
            final Function1<Bundle, Boolean> _function_3 = (Bundle b) -> {
              String _iri = b.iri();
              return Boolean.valueOf(Objects.equal(_iri, refIRI));
            };
            final Bundle bundle = IterableExtensions.<Bundle>findFirst(_flatten, _function_3);
            List<EObject> _xifexpression_2 = null;
            if ((null == bundle)) {
              _xifexpression_2 = Collections.<EObject>emptyList();
            } else {
              _xifexpression_2 = Collections.<EObject>singletonList(bundle);
            }
            return _xifexpression_2;
          }
          if (!_matched) {
            EClass _terminologyBox = TerminologiesPackage.eINSTANCE.getTerminologyBox();
            if (Objects.equal(refType, _terminologyBox)) {
              _matched=true;
              EList<Resource> _resources_1 = rs.getResources();
              final Function1<Resource, Iterable<TerminologyBox>> _function_4 = (Resource it) -> {
                EList<EObject> _contents = it.getContents();
                Iterable<Extent> _filter = Iterables.<Extent>filter(_contents, Extent.class);
                final Function1<Extent, Iterable<TerminologyBox>> _function_5 = (Extent it_1) -> {
                  EList<Module> _modules = it_1.getModules();
                  return Iterables.<TerminologyBox>filter(_modules, TerminologyBox.class);
                };
                Iterable<Iterable<TerminologyBox>> _map_1 = IterableExtensions.<Extent, Iterable<TerminologyBox>>map(_filter, _function_5);
                return Iterables.<TerminologyBox>concat(_map_1);
              };
              List<Iterable<TerminologyBox>> _map_1 = ListExtensions.<Resource, Iterable<TerminologyBox>>map(_resources_1, _function_4);
              Iterable<TerminologyBox> _flatten_1 = Iterables.<TerminologyBox>concat(_map_1);
              final Function1<TerminologyBox, Boolean> _function_5 = (TerminologyBox tbox) -> {
                String _iri = tbox.iri();
                return Boolean.valueOf(Objects.equal(_iri, refIRI));
              };
              final TerminologyBox tbox = IterableExtensions.<TerminologyBox>findFirst(_flatten_1, _function_5);
              List<EObject> _xifexpression_3 = null;
              if ((null == tbox)) {
                _xifexpression_3 = Collections.<EObject>emptyList();
              } else {
                _xifexpression_3 = Collections.<EObject>singletonList(tbox);
              }
              return _xifexpression_3;
            }
          }
          if (!_matched) {
            EClass _descriptionBox = DescriptionsPackage.eINSTANCE.getDescriptionBox();
            if (Objects.equal(refType, _descriptionBox)) {
              _matched=true;
              EList<Resource> _resources_2 = rs.getResources();
              final Function1<Resource, Iterable<DescriptionBox>> _function_6 = (Resource it) -> {
                EList<EObject> _contents = it.getContents();
                Iterable<Extent> _filter = Iterables.<Extent>filter(_contents, Extent.class);
                final Function1<Extent, Iterable<DescriptionBox>> _function_7 = (Extent it_1) -> {
                  EList<Module> _modules = it_1.getModules();
                  return Iterables.<DescriptionBox>filter(_modules, DescriptionBox.class);
                };
                Iterable<Iterable<DescriptionBox>> _map_2 = IterableExtensions.<Extent, Iterable<DescriptionBox>>map(_filter, _function_7);
                return Iterables.<DescriptionBox>concat(_map_2);
              };
              List<Iterable<DescriptionBox>> _map_2 = ListExtensions.<Resource, Iterable<DescriptionBox>>map(_resources_2, _function_6);
              Iterable<DescriptionBox> _flatten_2 = Iterables.<DescriptionBox>concat(_map_2);
              final Function1<DescriptionBox, Boolean> _function_7 = (DescriptionBox dbox) -> {
                String _iri = dbox.iri();
                return Boolean.valueOf(Objects.equal(_iri, refIRI));
              };
              final DescriptionBox dbox = IterableExtensions.<DescriptionBox>findFirst(_flatten_2, _function_7);
              List<EObject> _xifexpression_4 = null;
              if ((null == dbox)) {
                _xifexpression_4 = Collections.<EObject>emptyList();
              } else {
                _xifexpression_4 = Collections.<EObject>singletonList(dbox);
              }
              return _xifexpression_4;
            }
          }
          return Collections.<EObject>emptyList();
        }
      }
      if ((AnnotationPropertyValue.class.isInstance(context) && Objects.equal(ref, CommonPackage.eINSTANCE.getAnnotationPropertyValue_Property()))) {
        final AnnotationPropertyValue aContext = AnnotationPropertyValue.class.cast(context);
        final INode nextNode = node.getParent().getNextSibling();
        final EObject nextSE = IterableExtensions.<ILeafNode>head(nextNode.getLeafNodes()).getSemanticElement();
        boolean _matched_1 = false;
        if (nextSE instanceof Element) {
          _matched_1=true;
          aContext.setSubject(((Element)nextSE));
        }
        if (!_matched_1) {
          if (nextSE instanceof AnnotationPropertyValue) {
            _matched_1=true;
            final Iterable<ILeafNode> nextLeafNodes = nextNode.getLeafNodes();
            final Function1<ILeafNode, Boolean> _function_8 = (ILeafNode n) -> {
              EObject _grammarElement = n.getGrammarElement();
              return Boolean.valueOf(CrossReference.class.isInstance(_grammarElement));
            };
            final ILeafNode n1 = IterableExtensions.<ILeafNode>findFirst(nextLeafNodes, _function_8);
            this.getLinkedObjects(nextSE, ref, n1);
            aContext.setSubject(((AnnotationPropertyValue)nextSE).getSubject());
          }
        }
      }
      final IScope scope = this.getScope(context, ref);
      final QualifiedName qualifiedLinkName = this.qualifiedNameConverter.toQualifiedName(crossRefString);
      final IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedLinkName);
      if ((null == eObjectDescription)) {
        final List<EObject> defaultResult = super.getLinkedObjects(context, ref, node);
        if (((defaultResult != null) && (!defaultResult.isEmpty()))) {
          return defaultResult;
        } else {
          return Collections.<EObject>emptyList();
        }
      }
      final EObject e = eObjectDescription.getEObjectOrProxy();
      return Collections.<EObject>singletonList(e);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
