package gov.nasa.jpl.imce.oml.runtime.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain;
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext;
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue;
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import gov.nasa.jpl.imce.oml.runtime.OMLConcept;
import gov.nasa.jpl.imce.oml.runtime.OMLDescription;
import gov.nasa.jpl.imce.oml.runtime.OMLEntity;
import gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimeFactory;
import gov.nasa.jpl.imce.oml.runtime.OMLStructure;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class OML2EcoreGenerator {
  private static class DescriptionToEcoreGenerator {
    private final OML2EcoreGenerator generator;
    
    private final DescriptionBox description;
    
    public DescriptionToEcoreGenerator(final OML2EcoreGenerator generator, final DescriptionBox description) {
      this.generator = generator;
      this.description = description;
    }
    
    public OMLDescription generate() {
      OMLDescription _xblockexpression = null;
      {
        final OMLDescription omlDescription = OMLRuntimeFactory.eINSTANCE.createOMLDescription();
        omlDescription.setOmlIRI(this.description.getIri());
        EList<OMLEntity> _omlContents = omlDescription.getOmlContents();
        final Function1<ConceptInstance, OMLEntity> _function = (ConceptInstance it) -> {
          return this.doGenerate(it);
        };
        List<OMLEntity> _map = ListExtensions.<ConceptInstance, OMLEntity>map(this.description.getConceptInstances(), _function);
        Iterables.<OMLEntity>addAll(_omlContents, _map);
        EList<OMLEntity> _omlContents_1 = omlDescription.getOmlContents();
        final Function1<ReifiedRelationshipInstance, OMLEntity> _function_1 = (ReifiedRelationshipInstance it) -> {
          return this.doGenerate(it);
        };
        List<OMLEntity> _map_1 = ListExtensions.<ReifiedRelationshipInstance, OMLEntity>map(this.description.getReifiedRelationshipInstances(), _function_1);
        Iterables.<OMLEntity>addAll(_omlContents_1, _map_1);
        _xblockexpression = omlDescription;
      }
      return _xblockexpression;
    }
    
    protected OMLConcept _doGenerate(final ConceptInstance instance) {
      OMLConcept _xblockexpression = null;
      {
        final String className = instance.getSingletonConceptClassifier().getName();
        final String nsUri = instance.getSingletonConceptClassifier().getTbox().getIri();
        OMLEntity _doGenerate = this.doGenerate(instance, className, nsUri);
        final OMLConcept omlConcept = ((OMLConcept) _doGenerate);
        _xblockexpression = omlConcept;
      }
      return _xblockexpression;
    }
    
    protected OMLReifiedRelationship _doGenerate(final ReifiedRelationshipInstance instance) {
      OMLReifiedRelationship _xblockexpression = null;
      {
        final String className = instance.getSingletonReifiedRelationshipClassifier().getName();
        final String nsUri = instance.getSingletonReifiedRelationshipClassifier().getTbox().getIri();
        OMLEntity _doGenerate = this.doGenerate(instance, className, nsUri);
        final OMLReifiedRelationship omlReifiedRelationship = ((OMLReifiedRelationship) _doGenerate);
        _xblockexpression = omlReifiedRelationship;
      }
      return _xblockexpression;
    }
    
    public OMLEntity doGenerate(final ConceptualEntitySingletonInstance instance, final String className, final String nsUri) {
      OMLEntity _xblockexpression = null;
      {
        final EPackage package_ = EPackage.Registry.INSTANCE.getEPackage(nsUri);
        final EFactory factory = EPackage.Registry.INSTANCE.getEFactory(nsUri);
        final Function1<EClassifier, Boolean> _function = (EClassifier it) -> {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, className));
        };
        EClassifier _findFirst = IterableExtensions.<EClassifier>findFirst(package_.getEClassifiers(), _function);
        final EClass class_ = ((EClass) _findFirst);
        EObject _create = factory.create(class_);
        final OMLEntity omlEntity = ((OMLEntity) _create);
        omlEntity.setOmlName(instance.getName());
        Iterable<SingletonInstanceScalarDataPropertyValue> _scalarPropertyValues = this.getScalarPropertyValues(instance);
        for (final SingletonInstanceScalarDataPropertyValue scalarPropertyValue : _scalarPropertyValues) {
          {
            final String attributeName = OML2EcoreGenerator.validName(scalarPropertyValue.getScalarDataProperty());
            final Function1<EAttribute, Boolean> _function_1 = (EAttribute it) -> {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, attributeName));
            };
            final EAttribute attribute = IterableExtensions.<EAttribute>findFirst(class_.getEAllAttributes(), _function_1);
            omlEntity.eSet(attribute, this.getPropertyValue(scalarPropertyValue));
          }
        }
        Iterable<SingletonInstanceStructuredDataPropertyValue> _structurePropertyValues = this.getStructurePropertyValues(instance);
        for (final SingletonInstanceStructuredDataPropertyValue structurePropertyValue : _structurePropertyValues) {
          {
            final String referenceName = OML2EcoreGenerator.validName(structurePropertyValue.getStructuredDataProperty());
            final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, referenceName));
            };
            final EReference reference = IterableExtensions.<EReference>findFirst(class_.getEAllReferences(), _function_1);
            omlEntity.eSet(reference, this.getPropertyValue(structurePropertyValue));
          }
        }
        this.generator.mapping.put(instance, omlEntity);
        _xblockexpression = omlEntity;
      }
      return _xblockexpression;
    }
    
    public Iterable<SingletonInstanceScalarDataPropertyValue> getScalarPropertyValues(final ConceptualEntitySingletonInstance instance) {
      final Function1<DescriptionBox, EList<SingletonInstanceScalarDataPropertyValue>> _function = (DescriptionBox it) -> {
        return it.getSingletonScalarDataPropertyValues();
      };
      final Function1<SingletonInstanceScalarDataPropertyValue, Boolean> _function_1 = (SingletonInstanceScalarDataPropertyValue it) -> {
        ConceptualEntitySingletonInstance _singletonInstance = it.getSingletonInstance();
        return Boolean.valueOf(Objects.equal(_singletonInstance, instance));
      };
      return IterableExtensions.<SingletonInstanceScalarDataPropertyValue>filter(Iterables.<SingletonInstanceScalarDataPropertyValue>concat(IterableExtensions.<DescriptionBox, EList<SingletonInstanceScalarDataPropertyValue>>map(this.generator.allDboxes, _function)), _function_1);
    }
    
    public Iterable<SingletonInstanceStructuredDataPropertyValue> getStructurePropertyValues(final ConceptualEntitySingletonInstance instance) {
      final Function1<DescriptionBox, EList<SingletonInstanceStructuredDataPropertyValue>> _function = (DescriptionBox it) -> {
        return it.getSingletonStructuredDataPropertyValues();
      };
      final Function1<SingletonInstanceStructuredDataPropertyValue, Boolean> _function_1 = (SingletonInstanceStructuredDataPropertyValue it) -> {
        ConceptualEntitySingletonInstance _singletonInstance = it.getSingletonInstance();
        return Boolean.valueOf(Objects.equal(_singletonInstance, instance));
      };
      return IterableExtensions.<SingletonInstanceStructuredDataPropertyValue>filter(Iterables.<SingletonInstanceStructuredDataPropertyValue>concat(IterableExtensions.<DescriptionBox, EList<SingletonInstanceStructuredDataPropertyValue>>map(this.generator.allDboxes, _function)), _function_1);
    }
    
    public String getPropertyValue(final SingletonInstanceScalarDataPropertyValue propertyValue) {
      return propertyValue.getScalarPropertyValue();
    }
    
    public String getPropertyValue(final ScalarDataPropertyValue propertyValue) {
      return propertyValue.getScalarPropertyValue();
    }
    
    public OMLStructure getPropertyValue(final SingletonInstanceStructuredDataPropertyContext propertyValue) {
      OMLStructure _xblockexpression = null;
      {
        final String className = propertyValue.getStructuredDataProperty().getRange().getName();
        final String nsUri = propertyValue.getStructuredDataProperty().getRange().getTbox().getIri();
        final EPackage package_ = EPackage.Registry.INSTANCE.getEPackage(nsUri);
        final EFactory factory = EPackage.Registry.INSTANCE.getEFactory(nsUri);
        final Function1<EClassifier, Boolean> _function = (EClassifier it) -> {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, className));
        };
        EClassifier _findFirst = IterableExtensions.<EClassifier>findFirst(package_.getEClassifiers(), _function);
        final EClass class_ = ((EClass) _findFirst);
        EObject _create = factory.create(class_);
        final OMLStructure omlStructure = ((OMLStructure) _create);
        EList<ScalarDataPropertyValue> _scalarDataPropertyValues = propertyValue.getScalarDataPropertyValues();
        for (final ScalarDataPropertyValue scalarPropertyValue : _scalarDataPropertyValues) {
          {
            final String attributeName = OML2EcoreGenerator.validName(scalarPropertyValue.getScalarDataProperty());
            final Function1<EAttribute, Boolean> _function_1 = (EAttribute it) -> {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, attributeName));
            };
            final EAttribute attribute = IterableExtensions.<EAttribute>findFirst(class_.getEAllAttributes(), _function_1);
            omlStructure.eSet(attribute, this.getPropertyValue(scalarPropertyValue));
          }
        }
        EList<StructuredDataPropertyTuple> _structuredPropertyTuples = propertyValue.getStructuredPropertyTuples();
        for (final StructuredDataPropertyTuple structurePropertyTuple : _structuredPropertyTuples) {
          {
            final String referenceName = OML2EcoreGenerator.validName(structurePropertyTuple.getStructuredDataProperty());
            final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, referenceName));
            };
            final EReference reference = IterableExtensions.<EReference>findFirst(class_.getEAllReferences(), _function_1);
            omlStructure.eSet(reference, this.getPropertyValue(structurePropertyTuple));
          }
        }
        _xblockexpression = omlStructure;
      }
      return _xblockexpression;
    }
    
    public OMLEntity doGenerate(final ConceptualEntitySingletonInstance instance) {
      if (instance instanceof ConceptInstance) {
        return _doGenerate((ConceptInstance)instance);
      } else if (instance instanceof ReifiedRelationshipInstance) {
        return _doGenerate((ReifiedRelationshipInstance)instance);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(instance).toString());
      }
    }
  }
  
  @Extension
  private OMLExtensions _oMLExtensions = new OMLExtensions();
  
  private Set<DescriptionBox> allDboxes;
  
  private Map<ConceptualEntitySingletonInstance, OMLEntity> mapping;
  
  private final static ArrayList<String> xCoreKeywords = CollectionLiterals.<String>newArrayList("refers", "contains", "extends", "imports", "id");
  
  public void generate(final File file, final IPath parentPath) {
    try {
      HashMap<ConceptualEntitySingletonInstance, OMLEntity> _hashMap = new HashMap<ConceptualEntitySingletonInstance, OMLEntity>();
      this.mapping = _hashMap;
      HashSet<DescriptionBox> _hashSet = new HashSet<DescriptionBox>();
      this.allDboxes = _hashSet;
      final XtextResourceSet rs = new XtextResourceSet();
      rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
      final URI uri = URI.createFileURI(file.getPath());
      final Resource resource = rs.getResource(uri, true);
      boolean _isEmpty = resource.getContents().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final ResourceSetImpl outResourceSet = new ResourceSetImpl();
        EObject _get = resource.getContents().get(0);
        Extent extent = ((Extent) _get);
        final Iterable<DescriptionBox> dBoxes = Iterables.<DescriptionBox>filter(extent.getModules(), DescriptionBox.class);
        for (final DescriptionBox dBox : dBoxes) {
          Iterables.<DescriptionBox>addAll(this.allDboxes, this._oMLExtensions.allImportedDescriptions(dBox));
        }
        for (final DescriptionBox description : this.allDboxes) {
          {
            String _validQName = OML2EcoreGenerator.validQName(description);
            final String filename = (_validQName + ".omlruntime");
            final IPath path = parentPath.append(("/" + filename));
            final Resource outResource = outResourceSet.createResource(URI.createPlatformResourceURI(path.toString(), true));
            System.out.println(("generating: " + filename));
            final OMLDescription contents = new OML2EcoreGenerator.DescriptionToEcoreGenerator(this, description).generate();
            EList<EObject> _contents = outResource.getContents();
            _contents.add(contents);
          }
        }
        Set<ConceptualEntitySingletonInstance> _keySet = this.mapping.keySet();
        for (final ConceptualEntitySingletonInstance instance : _keySet) {
          if ((instance instanceof ReifiedRelationshipInstance)) {
            final ReifiedRelationshipInstance reifiedRelationInstance = ((ReifiedRelationshipInstance) instance);
            OMLEntity _get_1 = this.mapping.get(instance);
            final OMLReifiedRelationship omlReifiedRelationship = ((OMLReifiedRelationship) _get_1);
            omlReifiedRelationship.setOmlSource(this.mapping.get(this.getDomain(reifiedRelationInstance)));
            omlReifiedRelationship.setOmlTarget(this.mapping.get(this.getRange(reifiedRelationInstance)));
          }
        }
        EList<Resource> _resources = outResourceSet.getResources();
        for (final Resource outResource : _resources) {
          outResource.save(CollectionLiterals.<Object, Object>emptyMap());
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ConceptualEntitySingletonInstance getDomain(final ReifiedRelationshipInstance instance) {
    final Function1<DescriptionBox, EList<ReifiedRelationshipInstanceDomain>> _function = (DescriptionBox it) -> {
      return it.getReifiedRelationshipInstanceDomains();
    };
    final Function1<ReifiedRelationshipInstanceDomain, Boolean> _function_1 = (ReifiedRelationshipInstanceDomain it) -> {
      ReifiedRelationshipInstance _reifiedRelationshipInstance = it.getReifiedRelationshipInstance();
      return Boolean.valueOf(Objects.equal(_reifiedRelationshipInstance, instance));
    };
    return IterableExtensions.<ReifiedRelationshipInstanceDomain>findFirst(Iterables.<ReifiedRelationshipInstanceDomain>concat(IterableExtensions.<DescriptionBox, EList<ReifiedRelationshipInstanceDomain>>map(this.allDboxes, _function)), _function_1).getDomain();
  }
  
  public ConceptualEntitySingletonInstance getRange(final ReifiedRelationshipInstance instance) {
    final Function1<DescriptionBox, EList<ReifiedRelationshipInstanceRange>> _function = (DescriptionBox it) -> {
      return it.getReifiedRelationshipInstanceRanges();
    };
    final Function1<ReifiedRelationshipInstanceRange, Boolean> _function_1 = (ReifiedRelationshipInstanceRange it) -> {
      ReifiedRelationshipInstance _reifiedRelationshipInstance = it.getReifiedRelationshipInstance();
      return Boolean.valueOf(Objects.equal(_reifiedRelationshipInstance, instance));
    };
    return IterableExtensions.<ReifiedRelationshipInstanceRange>findFirst(Iterables.<ReifiedRelationshipInstanceRange>concat(IterableExtensions.<DescriptionBox, EList<ReifiedRelationshipInstanceRange>>map(this.allDboxes, _function)), _function_1).getRange();
  }
  
  protected static String validQName(final DescriptionBox description) {
    String _xblockexpression = null;
    {
      final String iri = description.iri();
      final String qname = OMLExtensions.convertIRItoNamespace(iri);
      _xblockexpression = qname;
    }
    return _xblockexpression;
  }
  
  protected static String _validName(final DataRelationship dr) {
    String _switchResult = null;
    String _name = dr.name();
    final String s = _name;
    boolean _matched = false;
    if (Objects.equal(s, null)) {
      _matched=true;
      _switchResult = "";
    }
    if (!_matched) {
      String _xblockexpression = null;
      {
        String valid = s.replaceAll("[\\. -]", "_");
        boolean _matches = valid.matches("^[0-9].*");
        if (_matches) {
          valid = ("_" + valid);
        }
        _xblockexpression = valid;
      }
      _switchResult = _xblockexpression;
    }
    return _switchResult;
  }
  
  protected static String _validName(final UnreifiedRelationship dr) {
    String _switchResult = null;
    String _name = dr.name();
    final String s = _name;
    boolean _matched = false;
    if (Objects.equal(s, null)) {
      _matched=true;
      _switchResult = "";
    }
    if (!_matched) {
      String _xblockexpression = null;
      {
        String valid = s.replaceAll("[\\. -]", "_");
        boolean _matches = valid.matches("^[0-9].*");
        if (_matches) {
          valid = ("_" + valid);
        }
        String _xifexpression = null;
        boolean _contains = OML2EcoreGenerator.xCoreKeywords.contains(valid);
        if (_contains) {
          _xifexpression = ("^" + valid);
        } else {
          _xifexpression = valid;
        }
        _xblockexpression = _xifexpression;
      }
      _switchResult = _xblockexpression;
    }
    return _switchResult;
  }
  
  protected static String validName(final CDOObject dr) {
    if (dr instanceof UnreifiedRelationship) {
      return _validName((UnreifiedRelationship)dr);
    } else if (dr instanceof DataRelationship) {
      return _validName((DataRelationship)dr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dr).toString());
    }
  }
}
