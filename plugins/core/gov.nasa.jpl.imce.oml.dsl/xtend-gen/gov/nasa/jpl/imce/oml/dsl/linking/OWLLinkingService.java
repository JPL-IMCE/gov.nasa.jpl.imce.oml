/**
 * Copyright 2016 California Institute of Technology ("Caltech").
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
import gov.nasa.jpl.imce.oml.model.common.Annotation;
import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
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

@SuppressWarnings("all")
public class OWLLinkingService extends DefaultLinkingService {
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
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
          throw new IllegalNodeException(node, ("Cross-reference cannot specify a fragment OML Entity: " + crossRefIRI));
        }
        final Catalog catalog = OMLExtensions.findCatalogIfExists(context.eResource());
        if ((null != catalog)) {
          final String resolvedIRI = catalog.resolveURI((resourceIRI + ".oml"));
          if (((null == resolvedIRI) || Objects.equal(resolvedIRI, resourceIRI))) {
            return Collections.<EObject>emptyList();
          }
          final Resource resolvedOML = rs.getResource(URI.createURI(resolvedIRI), true);
          final StringBuffer problems = new StringBuffer();
          final Consumer<Resource.Diagnostic> _function = new Consumer<Resource.Diagnostic>() {
            public void accept(final Resource.Diagnostic e) {
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
                String _plus_7 = (_plus_6 + ", offset:");
                int _offset = ((Diagnostic)e).getOffset();
                String _plus_8 = (_plus_7 + Integer.valueOf(_offset));
                String _plus_9 = (_plus_8 + ", length:");
                int _length = ((Diagnostic)e).getLength();
                String _plus_10 = (_plus_9 + Integer.valueOf(_length));
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
            }
          };
          resolvedOML.getErrors().forEach(_function);
          final Consumer<Resource.Diagnostic> _function_1 = new Consumer<Resource.Diagnostic>() {
            public void accept(final Resource.Diagnostic e) {
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
                String _plus_6 = (_plus_5 + ", offset:");
                int _offset = ((Diagnostic)e).getOffset();
                String _plus_7 = (_plus_6 + Integer.valueOf(_offset));
                String _plus_8 = (_plus_7 + ", length:");
                int _length = ((Diagnostic)e).getLength();
                String _plus_9 = (_plus_8 + Integer.valueOf(_length));
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
            }
          };
          resolvedOML.getWarnings().forEach(_function_1);
          if (((!resolvedOML.getErrors().isEmpty()) || (!resolvedOML.getWarnings().isEmpty()))) {
            String _string = problems.toString();
            String _plus = (("Problem loading: " + resolvedIRI) + _string);
            throw new IllegalNodeException(node, _plus);
          }
        }
        final EClassifier refType = ref.getEType();
        boolean _matched = false;
        EClass _bundle = BundlesPackage.eINSTANCE.getBundle();
        if (Objects.equal(refType, _bundle)) {
          _matched=true;
          final Function1<Resource, Iterable<Bundle>> _function_2 = new Function1<Resource, Iterable<Bundle>>() {
            public Iterable<Bundle> apply(final Resource it) {
              final Function1<Extent, Iterable<Bundle>> _function = new Function1<Extent, Iterable<Bundle>>() {
                public Iterable<Bundle> apply(final Extent it) {
                  return Iterables.<Bundle>filter(it.getModules(), Bundle.class);
                }
              };
              return Iterables.<Bundle>concat(IterableExtensions.<Extent, Iterable<Bundle>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function));
            }
          };
          final Function1<Bundle, Boolean> _function_3 = new Function1<Bundle, Boolean>() {
            public Boolean apply(final Bundle b) {
              String _iri = b.iri();
              return Boolean.valueOf(Objects.equal(_iri, resourceIRI));
            }
          };
          final Bundle bundle = IterableExtensions.<Bundle>findFirst(Iterables.<Bundle>concat(ListExtensions.<Resource, Iterable<Bundle>>map(rs.getResources(), _function_2)), _function_3);
          List<EObject> _xifexpression_1 = null;
          if ((null == bundle)) {
            _xifexpression_1 = Collections.<EObject>emptyList();
          } else {
            _xifexpression_1 = Collections.<EObject>singletonList(bundle);
          }
          return _xifexpression_1;
        }
        if (!_matched) {
          EClass _terminologyBox = TerminologiesPackage.eINSTANCE.getTerminologyBox();
          if (Objects.equal(refType, _terminologyBox)) {
            _matched=true;
            final Function1<Resource, Iterable<TerminologyBox>> _function_4 = new Function1<Resource, Iterable<TerminologyBox>>() {
              public Iterable<TerminologyBox> apply(final Resource it) {
                final Function1<Extent, Iterable<TerminologyBox>> _function = new Function1<Extent, Iterable<TerminologyBox>>() {
                  public Iterable<TerminologyBox> apply(final Extent it) {
                    return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
                  }
                };
                return Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function));
              }
            };
            final Function1<TerminologyBox, Boolean> _function_5 = new Function1<TerminologyBox, Boolean>() {
              public Boolean apply(final TerminologyBox tbox) {
                String _iri = tbox.iri();
                return Boolean.valueOf(Objects.equal(_iri, resourceIRI));
              }
            };
            final TerminologyBox tbox = IterableExtensions.<TerminologyBox>findFirst(Iterables.<TerminologyBox>concat(ListExtensions.<Resource, Iterable<TerminologyBox>>map(rs.getResources(), _function_4)), _function_5);
            List<EObject> _xifexpression_2 = null;
            if ((null == tbox)) {
              _xifexpression_2 = Collections.<EObject>emptyList();
            } else {
              _xifexpression_2 = Collections.<EObject>singletonList(tbox);
            }
            return _xifexpression_2;
          }
        }
        if (!_matched) {
          EClass _descriptionBox = DescriptionsPackage.eINSTANCE.getDescriptionBox();
          if (Objects.equal(refType, _descriptionBox)) {
            _matched=true;
            final Function1<Resource, Iterable<DescriptionBox>> _function_6 = new Function1<Resource, Iterable<DescriptionBox>>() {
              public Iterable<DescriptionBox> apply(final Resource it) {
                final Function1<Extent, Iterable<DescriptionBox>> _function = new Function1<Extent, Iterable<DescriptionBox>>() {
                  public Iterable<DescriptionBox> apply(final Extent it) {
                    return Iterables.<DescriptionBox>filter(it.getModules(), DescriptionBox.class);
                  }
                };
                return Iterables.<DescriptionBox>concat(IterableExtensions.<Extent, Iterable<DescriptionBox>>map(Iterables.<Extent>filter(it.getContents(), Extent.class), _function));
              }
            };
            final Function1<DescriptionBox, Boolean> _function_7 = new Function1<DescriptionBox, Boolean>() {
              public Boolean apply(final DescriptionBox dbox) {
                String _iri = dbox.iri();
                return Boolean.valueOf(Objects.equal(_iri, resourceIRI));
              }
            };
            final DescriptionBox dbox = IterableExtensions.<DescriptionBox>findFirst(Iterables.<DescriptionBox>concat(ListExtensions.<Resource, Iterable<DescriptionBox>>map(rs.getResources(), _function_6)), _function_7);
            List<EObject> _xifexpression_3 = null;
            if ((null == dbox)) {
              _xifexpression_3 = Collections.<EObject>emptyList();
            } else {
              _xifexpression_3 = Collections.<EObject>singletonList(dbox);
            }
            return _xifexpression_3;
          }
        }
        return Collections.<EObject>emptyList();
      }
      if ((Annotation.class.isInstance(context) && Objects.equal(ref, CommonPackage.eINSTANCE.getAnnotation_Property()))) {
        final Annotation aContext = Annotation.class.cast(context);
        final INode nextNode = node.getParent().getNextSibling();
        final EObject nextSE = IterableExtensions.<ILeafNode>head(nextNode.getLeafNodes()).getSemanticElement();
        boolean _matched_1 = false;
        if (nextSE instanceof Element) {
          _matched_1=true;
          aContext.setSubject(((Element)nextSE));
        }
        if (!_matched_1) {
          if (nextSE instanceof Annotation) {
            _matched_1=true;
            final Iterable<ILeafNode> nextLeafNodes = nextNode.getLeafNodes();
            final Function1<ILeafNode, Boolean> _function_8 = new Function1<ILeafNode, Boolean>() {
              public Boolean apply(final ILeafNode n) {
                return Boolean.valueOf(CrossReference.class.isInstance(n.getGrammarElement()));
              }
            };
            final ILeafNode n1 = IterableExtensions.<ILeafNode>findFirst(nextLeafNodes, _function_8);
            this.getLinkedObjects(nextSE, ref, n1);
            aContext.setSubject(((Annotation)nextSE).getSubject());
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
