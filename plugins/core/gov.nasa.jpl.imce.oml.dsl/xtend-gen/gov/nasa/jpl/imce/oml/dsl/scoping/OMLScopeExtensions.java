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
package gov.nasa.jpl.imce.oml.dsl.scoping;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.common.Annotation;
import gov.nasa.jpl.imce.oml.model.common.AnnotationProperty;
import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.Module;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions;
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
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
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
   * in terms of the abbrevIRI of each AnnotationProperty in the TerminologyExtent.
   * 
   * @TODO See the workaround in OMLImportedNamespaceAwareLocalScopeProvider.getScope
   */
  public IScope scope_Annotation_property(final Annotation annotation, final EReference eRef) {
    IScope _xblockexpression = null;
    {
      final Function1<Module, EList<AnnotationProperty>> _function = new Function1<Module, EList<AnnotationProperty>>() {
        public EList<AnnotationProperty> apply(final Module it) {
          return it.getExtent().getAnnotationProperties();
        }
      };
      final Iterable<AnnotationProperty> annoationProperties = Iterables.<AnnotationProperty>concat(IterableExtensions.<Module, EList<AnnotationProperty>>map(this._oMLExtensions.allImportedModules(annotation.getModule()), _function));
      final Function<AnnotationProperty, QualifiedName> _function_1 = new Function<AnnotationProperty, QualifiedName>() {
        public QualifiedName apply(final AnnotationProperty it) {
          return OMLScopeExtensions.this.qnc.toQualifiedName(it.getAbbrevIRI());
        }
      };
      _xblockexpression = Scopes.<AnnotationProperty>scopeFor(annoationProperties, _function_1, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope scope_BundledTerminologyAxiom_bundledTerminology(final BundledTerminologyAxiom context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          Iterable<TerminologyGraph> _terminologyGraphs = OMLScopeExtensions.this._oMLExtensions.terminologyGraphs(it);
          Iterable<Bundle> _bundles = OMLScopeExtensions.this._oMLExtensions.bundles(it);
          return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final Function<TerminologyBox, QualifiedName> _function_2 = new Function<TerminologyBox, QualifiedName>() {
        public QualifiedName apply(final TerminologyBox it) {
          return OMLScopeExtensions.this.qnc.toQualifiedName(it.nsPrefix());
        }
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope scope_ConceptDesignationTerminologyAxiom_designatedTerminology(final ConceptDesignationTerminologyAxiom context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          Iterable<TerminologyGraph> _terminologyGraphs = OMLScopeExtensions.this._oMLExtensions.terminologyGraphs(it);
          Iterable<Bundle> _bundles = OMLScopeExtensions.this._oMLExtensions.bundles(it);
          return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final Function<TerminologyBox, QualifiedName> _function_2 = new Function<TerminologyBox, QualifiedName>() {
        public QualifiedName apply(final TerminologyBox it) {
          return OMLScopeExtensions.this.qnc.toQualifiedName(it.nsPrefix());
        }
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
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          Iterable<TerminologyGraph> _terminologyGraphs = OMLScopeExtensions.this._oMLExtensions.terminologyGraphs(it);
          Iterable<Bundle> _bundles = OMLScopeExtensions.this._oMLExtensions.bundles(it);
          return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final Function<TerminologyBox, QualifiedName> _function_2 = new Function<TerminologyBox, QualifiedName>() {
        public QualifiedName apply(final TerminologyBox it) {
          return OMLScopeExtensions.this.qnc.toQualifiedName(it.nsPrefix());
        }
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope allTerminologies(final DescriptionBox context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          Iterable<TerminologyGraph> _terminologyGraphs = OMLScopeExtensions.this._oMLExtensions.terminologyGraphs(it);
          Iterable<Bundle> _bundles = OMLScopeExtensions.this._oMLExtensions.bundles(it);
          return Iterables.<TerminologyBox>concat(_terminologyGraphs, _bundles);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final Function<TerminologyBox, QualifiedName> _function_2 = new Function<TerminologyBox, QualifiedName>() {
        public QualifiedName apply(final TerminologyBox it) {
          return OMLScopeExtensions.this.qnc.toQualifiedName(it.nsPrefix());
        }
      };
      _xblockexpression = Scopes.<TerminologyBox>scopeFor(tboxes, _function_2, 
        IScope.NULLSCOPE);
    }
    return _xblockexpression;
  }
  
  public IScope allDescriptions(final DescriptionBox context) {
    IScope _xblockexpression = null;
    {
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(context.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<DescriptionBox>> _function_1 = new Function1<Extent, Iterable<DescriptionBox>>() {
        public Iterable<DescriptionBox> apply(final Extent it) {
          return OMLScopeExtensions.this._oMLExtensions.descriptions(it);
        }
      };
      final Iterable<DescriptionBox> tboxes = Iterables.<DescriptionBox>concat(IterableExtensions.<Extent, Iterable<DescriptionBox>>map(exts, _function_1));
      final Function<DescriptionBox, QualifiedName> _function_2 = new Function<DescriptionBox, QualifiedName>() {
        public QualifiedName apply(final DescriptionBox it) {
          return OMLScopeExtensions.this.qnc.toQualifiedName(it.nsPrefix());
        }
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
      Iterables.<IEObjectDescription>addAll(result, Scopes.scopedElementsFor(localScopeFunction.apply(tbox)));
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox importedTbox) {
          final Function<T, QualifiedName> _function = new Function<T, QualifiedName>() {
            public QualifiedName apply(final T importedThing) {
              return nameFunction.apply(Pair.<TerminologyBox, T>of(importedTbox, importedThing));
            }
          };
          return Scopes.<T>scopedElementsFor(
            localScopeFunction.apply(importedTbox), _function);
        }
      };
      Iterables.<IEObjectDescription>addAll(result, 
        Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(this._oMLExtensions.allImportedTerminologies(tbox), _function)));
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
    final Function<TerminologyBox, Iterable<Entity>> _function = new Function<TerminologyBox, Iterable<Entity>>() {
      public Iterable<Entity> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localEntities(it);
      }
    };
    final Function<Pair<TerminologyBox, Entity>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, Entity>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, Entity> it) {
        return OMLScopeExtensions.this.<Entity>importedResourceNameFunction(it);
      }
    };
    return this.<Entity>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allRangesScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<DataRange>> _function = new Function<TerminologyBox, Iterable<DataRange>>() {
      public Iterable<DataRange> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localRanges(it);
      }
    };
    final Function<Pair<TerminologyBox, DataRange>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, DataRange>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, DataRange> it) {
        return OMLScopeExtensions.this.<DataRange>importedResourceNameFunction(it);
      }
    };
    return this.<DataRange>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allStructuresScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Structure>> _function = new Function<TerminologyBox, Iterable<Structure>>() {
      public Iterable<Structure> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localStructures(it);
      }
    };
    final Function<Pair<TerminologyBox, Structure>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, Structure>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, Structure> it) {
        return OMLScopeExtensions.this.<Structure>importedResourceNameFunction(it);
      }
    };
    return this.<Structure>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allAspectsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Aspect>> _function = new Function<TerminologyBox, Iterable<Aspect>>() {
      public Iterable<Aspect> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localAspects(it);
      }
    };
    final Function<Pair<TerminologyBox, Aspect>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, Aspect>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, Aspect> it) {
        return OMLScopeExtensions.this.<Aspect>importedResourceNameFunction(it);
      }
    };
    return this.<Aspect>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allConceptsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<Concept>> _function = new Function<TerminologyBox, Iterable<Concept>>() {
      public Iterable<Concept> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localConcepts(it);
      }
    };
    final Function<Pair<TerminologyBox, Concept>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, Concept>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, Concept> it) {
        return OMLScopeExtensions.this.<Concept>importedResourceNameFunction(it);
      }
    };
    return this.<Concept>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allReifiedRelationshipsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ReifiedRelationship>> _function = new Function<TerminologyBox, Iterable<ReifiedRelationship>>() {
      public Iterable<ReifiedRelationship> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localReifiedRelationships(it);
      }
    };
    final Function<Pair<TerminologyBox, ReifiedRelationship>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, ReifiedRelationship>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, ReifiedRelationship> it) {
        return OMLScopeExtensions.this.<ReifiedRelationship>importedResourceNameFunction(it);
      }
    };
    return this.<ReifiedRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allEntityRelationshipsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<EntityRelationship>> _function = new Function<TerminologyBox, Iterable<EntityRelationship>>() {
      public Iterable<EntityRelationship> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localEntityRelationships(it);
      }
    };
    final Function<Pair<TerminologyBox, EntityRelationship>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, EntityRelationship>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, EntityRelationship> it) {
        return OMLScopeExtensions.this.<EntityRelationship>importedResourceNameFunction(it);
      }
    };
    return this.<EntityRelationship>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allEntityScalarDataPropertiesScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<EntityScalarDataProperty>> _function = new Function<TerminologyBox, Iterable<EntityScalarDataProperty>>() {
      public Iterable<EntityScalarDataProperty> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localEntityScalarDataProperties(it);
      }
    };
    final Function<Pair<TerminologyBox, EntityScalarDataProperty>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, EntityScalarDataProperty>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, EntityScalarDataProperty> it) {
        return OMLScopeExtensions.this.<EntityScalarDataProperty>importedResourceNameFunction(it);
      }
    };
    return this.<EntityScalarDataProperty>terminologyScope(tbox, _function, _function_1);
  }
  
  public IScope allScalarOneOfRestrictionsScope(final TerminologyBox tbox) {
    final Function<TerminologyBox, Iterable<ScalarOneOfRestriction>> _function = new Function<TerminologyBox, Iterable<ScalarOneOfRestriction>>() {
      public Iterable<ScalarOneOfRestriction> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localScalarOneOfRestrictions(it);
      }
    };
    final Function<Pair<TerminologyBox, ScalarOneOfRestriction>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, ScalarOneOfRestriction>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, ScalarOneOfRestriction> it) {
        return OMLScopeExtensions.this.<ScalarOneOfRestriction>importedResourceNameFunction(it);
      }
    };
    return this.<ScalarOneOfRestriction>terminologyScope(tbox, _function, _function_1);
  }
  
  public <T extends Element> IScope bundleScope(final Bundle bundle, final Function<TerminologyBox, Iterable<T>> localScopeFunction, final Function<Pair<TerminologyBox, T>, QualifiedName> nameFunction) {
    SimpleScope _xblockexpression = null;
    {
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Set<Bundle> allBundles = Sets.<Bundle>newHashSet();
      allBundles.add(bundle);
      Iterables.<Bundle>addAll(allBundles, this._oMLExtensions.allImportedBundles(bundle));
      final Set<TerminologyBox> allTBoxes = Sets.<TerminologyBox>newHashSet();
      allTBoxes.addAll(allBundles);
      final Function1<Bundle, Iterable<TerminologyBox>> _function = new Function1<Bundle, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Bundle it) {
          return OMLScopeExtensions.this._oMLExtensions.allImportedTerminologies(it);
        }
      };
      Iterables.<TerminologyBox>addAll(allTBoxes, Iterables.<TerminologyBox>concat(IterableExtensions.<Bundle, Iterable<TerminologyBox>>map(allBundles, _function)));
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_1 = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox tbox) {
          final Function<T, QualifiedName> _function = new Function<T, QualifiedName>() {
            public QualifiedName apply(final T e) {
              return nameFunction.apply(Pair.<TerminologyBox, T>of(tbox, e));
            }
          };
          return Scopes.<T>scopedElementsFor(
            localScopeFunction.apply(tbox), _function);
        }
      };
      Iterables.<IEObjectDescription>addAll(result, 
        Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(allTBoxes, _function_1)));
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allConceptsScope(final Bundle b) {
    final Function<TerminologyBox, Iterable<Concept>> _function = new Function<TerminologyBox, Iterable<Concept>>() {
      public Iterable<Concept> apply(final TerminologyBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localConcepts(it);
      }
    };
    final Function<Pair<TerminologyBox, Concept>, QualifiedName> _function_1 = new Function<Pair<TerminologyBox, Concept>, QualifiedName>() {
      public QualifiedName apply(final Pair<TerminologyBox, Concept> it) {
        return OMLScopeExtensions.this.<Concept>importedResourceNameFunction(it);
      }
    };
    return this.<Concept>bundleScope(b, _function, _function_1);
  }
  
  public <T extends Element> IScope descriptionScope(final DescriptionBox dbox, final Function<DescriptionBox, Iterable<T>> localScopeFunction, final Function<Pair<DescriptionBox, T>, QualifiedName> nameFunction) {
    SimpleScope _xblockexpression = null;
    {
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      Iterables.<IEObjectDescription>addAll(result, Scopes.scopedElementsFor(localScopeFunction.apply(dbox)));
      final Function1<DescriptionBox, Iterable<IEObjectDescription>> _function = new Function1<DescriptionBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final DescriptionBox importedDbox) {
          final Function<T, QualifiedName> _function = new Function<T, QualifiedName>() {
            public QualifiedName apply(final T importedThing) {
              return nameFunction.apply(Pair.<DescriptionBox, T>of(importedDbox, importedThing));
            }
          };
          return Scopes.<T>scopedElementsFor(
            localScopeFunction.apply(importedDbox), _function);
        }
      };
      Iterables.<IEObjectDescription>addAll(result, 
        Iterables.<IEObjectDescription>concat(IterableExtensions.<DescriptionBox, Iterable<IEObjectDescription>>map(this._oMLExtensions.allImportedDescriptions(dbox), _function)));
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allConceptualEntitySingletonInstanceScope(final DescriptionBox dbox) {
    final Function<DescriptionBox, Iterable<ConceptualEntitySingletonInstance>> _function = new Function<DescriptionBox, Iterable<ConceptualEntitySingletonInstance>>() {
      public Iterable<ConceptualEntitySingletonInstance> apply(final DescriptionBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localConceptualEntitySingletonInstances(it);
      }
    };
    final Function<Pair<DescriptionBox, ConceptualEntitySingletonInstance>, QualifiedName> _function_1 = new Function<Pair<DescriptionBox, ConceptualEntitySingletonInstance>, QualifiedName>() {
      public QualifiedName apply(final Pair<DescriptionBox, ConceptualEntitySingletonInstance> it) {
        return OMLScopeExtensions.this.<ConceptualEntitySingletonInstance>importedDescriptionNameFunction(it);
      }
    };
    return this.<ConceptualEntitySingletonInstance>descriptionScope(dbox, _function, _function_1);
  }
  
  public IScope allReifiedRelationshipInstancesScope(final DescriptionBox dbox) {
    final Function<DescriptionBox, Iterable<ReifiedRelationshipInstance>> _function = new Function<DescriptionBox, Iterable<ReifiedRelationshipInstance>>() {
      public Iterable<ReifiedRelationshipInstance> apply(final DescriptionBox it) {
        return OMLScopeExtensions.this._oMLExtensions.localReifiedRelationshipInstances(it);
      }
    };
    final Function<Pair<DescriptionBox, ReifiedRelationshipInstance>, QualifiedName> _function_1 = new Function<Pair<DescriptionBox, ReifiedRelationshipInstance>, QualifiedName>() {
      public QualifiedName apply(final Pair<DescriptionBox, ReifiedRelationshipInstance> it) {
        return OMLScopeExtensions.this.<ReifiedRelationshipInstance>importedDescriptionNameFunction(it);
      }
    };
    return this.<ReifiedRelationshipInstance>descriptionScope(dbox, _function, _function_1);
  }
  
  protected void forceResolvingTerminologiesUsedInDescriptionBox(final DescriptionBox dbox) {
    final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
      public Iterable<Extent> apply(final Resource it) {
        return Iterables.<Extent>filter(it.getContents(), Extent.class);
      }
    };
    final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(dbox.eResource().getResourceSet().getResources(), _function));
    final Function1<Extent, Iterable<DescriptionBox>> _function_1 = new Function1<Extent, Iterable<DescriptionBox>>() {
      public Iterable<DescriptionBox> apply(final Extent it) {
        return Iterables.<DescriptionBox>filter(it.getModules(), DescriptionBox.class);
      }
    };
    final Function1<DescriptionBox, EList<DescriptionBoxExtendsClosedWorldDefinitions>> _function_2 = new Function1<DescriptionBox, EList<DescriptionBoxExtendsClosedWorldDefinitions>>() {
      public EList<DescriptionBoxExtendsClosedWorldDefinitions> apply(final DescriptionBox it) {
        return it.getClosedWorldDefinitions();
      }
    };
    final List<DescriptionBoxExtendsClosedWorldDefinitions> ax = IterableExtensions.<DescriptionBoxExtendsClosedWorldDefinitions>toList(Iterables.<DescriptionBoxExtendsClosedWorldDefinitions>concat(IterableExtensions.<DescriptionBox, EList<DescriptionBoxExtendsClosedWorldDefinitions>>map(Iterables.<DescriptionBox>concat(IterableExtensions.<Extent, Iterable<DescriptionBox>>map(exts, _function_1)), _function_2)));
    final Function1<DescriptionBoxExtendsClosedWorldDefinitions, TerminologyBox> _function_3 = new Function1<DescriptionBoxExtendsClosedWorldDefinitions, TerminologyBox>() {
      public TerminologyBox apply(final DescriptionBoxExtendsClosedWorldDefinitions it) {
        return it.getClosedWorldDefinitions();
      }
    };
    final List<TerminologyBox> tboxes = ListExtensions.<DescriptionBoxExtendsClosedWorldDefinitions, TerminologyBox>map(ax, _function_3);
    final Consumer<TerminologyBox> _function_4 = new Consumer<TerminologyBox>() {
      public void accept(final TerminologyBox it) {
        EcoreUtil2.resolveAll(it);
      }
    };
    tboxes.forEach(_function_4);
  }
  
  public IScope allEntityStructuredDataPropertiesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      this.forceResolvingTerminologiesUsedInDescriptionBox(dbox);
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(dbox.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_2 = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox tbox) {
          final Function<EntityStructuredDataProperty, QualifiedName> _function = new Function<EntityStructuredDataProperty, QualifiedName>() {
            public QualifiedName apply(final EntityStructuredDataProperty importedThing) {
              return OMLScopeExtensions.this.<EntityStructuredDataProperty>importedResourceNameFunction(Pair.<TerminologyBox, EntityStructuredDataProperty>of(tbox, importedThing));
            }
          };
          return Scopes.<EntityStructuredDataProperty>scopedElementsFor(
            OMLScopeExtensions.this._oMLExtensions.localEntityStructuredDataProperties(tbox), _function);
        }
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function_2));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allEntityScalarDataPropertiesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      this.forceResolvingTerminologiesUsedInDescriptionBox(dbox);
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(dbox.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_2 = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox tbox) {
          final Function<EntityScalarDataProperty, QualifiedName> _function = new Function<EntityScalarDataProperty, QualifiedName>() {
            public QualifiedName apply(final EntityScalarDataProperty importedThing) {
              return OMLScopeExtensions.this.<EntityScalarDataProperty>importedResourceNameFunction(Pair.<TerminologyBox, EntityScalarDataProperty>of(tbox, importedThing));
            }
          };
          return Scopes.<EntityScalarDataProperty>scopedElementsFor(
            OMLScopeExtensions.this._oMLExtensions.localEntityScalarDataProperties(tbox), _function);
        }
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function_2));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allStructuredDataPropertiesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      this.forceResolvingTerminologiesUsedInDescriptionBox(dbox);
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(dbox.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_2 = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox tbox) {
          final Function<StructuredDataProperty, QualifiedName> _function = new Function<StructuredDataProperty, QualifiedName>() {
            public QualifiedName apply(final StructuredDataProperty importedThing) {
              return OMLScopeExtensions.this.<StructuredDataProperty>importedResourceNameFunction(Pair.<TerminologyBox, StructuredDataProperty>of(tbox, importedThing));
            }
          };
          return Scopes.<StructuredDataProperty>scopedElementsFor(
            OMLScopeExtensions.this._oMLExtensions.localStructuredDataProperties(tbox), _function);
        }
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function_2));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allScalarDataPropertiesScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      this.forceResolvingTerminologiesUsedInDescriptionBox(dbox);
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(dbox.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_2 = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox tbox) {
          final Function<ScalarDataProperty, QualifiedName> _function = new Function<ScalarDataProperty, QualifiedName>() {
            public QualifiedName apply(final ScalarDataProperty importedThing) {
              return OMLScopeExtensions.this.<ScalarDataProperty>importedResourceNameFunction(Pair.<TerminologyBox, ScalarDataProperty>of(tbox, importedThing));
            }
          };
          return Scopes.<ScalarDataProperty>scopedElementsFor(
            OMLScopeExtensions.this._oMLExtensions.localScalarDataProperties(tbox), _function);
        }
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function_2));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allConceptsScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      this.forceResolvingTerminologiesUsedInDescriptionBox(dbox);
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(dbox.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_2 = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox tbox) {
          final Function<Concept, QualifiedName> _function = new Function<Concept, QualifiedName>() {
            public QualifiedName apply(final Concept importedThing) {
              return OMLScopeExtensions.this.<Concept>importedResourceNameFunction(Pair.<TerminologyBox, Concept>of(tbox, importedThing));
            }
          };
          return Scopes.<Concept>scopedElementsFor(
            OMLScopeExtensions.this._oMLExtensions.localConcepts(tbox), _function);
        }
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function_2));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allReifiedRelationshipScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      this.forceResolvingTerminologiesUsedInDescriptionBox(dbox);
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(dbox.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_2 = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox tbox) {
          final Function<ReifiedRelationship, QualifiedName> _function = new Function<ReifiedRelationship, QualifiedName>() {
            public QualifiedName apply(final ReifiedRelationship importedThing) {
              return OMLScopeExtensions.this.<ReifiedRelationship>importedResourceNameFunction(Pair.<TerminologyBox, ReifiedRelationship>of(tbox, importedThing));
            }
          };
          return Scopes.<ReifiedRelationship>scopedElementsFor(
            OMLScopeExtensions.this._oMLExtensions.localReifiedRelationships(tbox), _function);
        }
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function_2));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
  
  public IScope allUnreifiedRelationshipScope(final DescriptionBox dbox) {
    SimpleScope _xblockexpression = null;
    {
      this.forceResolvingTerminologiesUsedInDescriptionBox(dbox);
      final Function1<Resource, Iterable<Extent>> _function = new Function1<Resource, Iterable<Extent>>() {
        public Iterable<Extent> apply(final Resource it) {
          return Iterables.<Extent>filter(it.getContents(), Extent.class);
        }
      };
      final Iterable<Extent> exts = Iterables.<Extent>concat(ListExtensions.<Resource, Iterable<Extent>>map(dbox.eResource().getResourceSet().getResources(), _function));
      final Function1<Extent, Iterable<TerminologyBox>> _function_1 = new Function1<Extent, Iterable<TerminologyBox>>() {
        public Iterable<TerminologyBox> apply(final Extent it) {
          return Iterables.<TerminologyBox>filter(it.getModules(), TerminologyBox.class);
        }
      };
      final Iterable<TerminologyBox> tboxes = Iterables.<TerminologyBox>concat(IterableExtensions.<Extent, Iterable<TerminologyBox>>map(exts, _function_1));
      final ArrayList<IEObjectDescription> result = Lists.<IEObjectDescription>newArrayList();
      final Function1<TerminologyBox, Iterable<IEObjectDescription>> _function_2 = new Function1<TerminologyBox, Iterable<IEObjectDescription>>() {
        public Iterable<IEObjectDescription> apply(final TerminologyBox tbox) {
          final Function<UnreifiedRelationship, QualifiedName> _function = new Function<UnreifiedRelationship, QualifiedName>() {
            public QualifiedName apply(final UnreifiedRelationship importedThing) {
              return OMLScopeExtensions.this.<UnreifiedRelationship>importedResourceNameFunction(Pair.<TerminologyBox, UnreifiedRelationship>of(tbox, importedThing));
            }
          };
          return Scopes.<UnreifiedRelationship>scopedElementsFor(
            OMLScopeExtensions.this._oMLExtensions.localUnreifiedRelationships(tbox), _function);
        }
      };
      final Iterable<IEObjectDescription> inc = Iterables.<IEObjectDescription>concat(IterableExtensions.<TerminologyBox, Iterable<IEObjectDescription>>map(tboxes, _function_2));
      Iterables.<IEObjectDescription>addAll(result, inc);
      _xblockexpression = new SimpleScope(result);
    }
    return _xblockexpression;
  }
}
