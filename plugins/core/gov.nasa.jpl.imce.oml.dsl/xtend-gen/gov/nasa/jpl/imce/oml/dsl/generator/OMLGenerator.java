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
package gov.nasa.jpl.imce.oml.dsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import gov.nasa.jpl.imce.oml.model.bundles.Bundle;
import gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange;
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.Datatype;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
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
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class OMLGenerator extends AbstractGenerator {
  private static class TerminologyToXcoreGenerator {
    @Inject
    @Extension
    private OMLExtensions _oMLExtensions;
    
    private final String XSD_NS = "http://www.w3.org/2001/XMLSchema#";
    
    private final Set<TerminologyBox> terminologies;
    
    private final TerminologyBox terminology;
    
    private final Map<String, String> imports;
    
    private final Set<String> localNames;
    
    private final OMLGenerator generator;
    
    private final String packageNsURI;
    
    private final String packageNsPrefix;
    
    private final String packageEQName;
    
    private final String packageQName;
    
    private final String packageTName;
    
    private final String dsmlName;
    
    public TerminologyToXcoreGenerator(final OMLGenerator generator, final Iterable<TerminologyBox> terminologies, final TerminologyBox terminology, final String dsmlName) {
      this.generator = generator;
      HashSet<TerminologyBox> _hashSet = new HashSet<TerminologyBox>();
      this.terminologies = _hashSet;
      for (final TerminologyBox t : terminologies) {
        this.terminologies.add(t);
      }
      this.terminology = terminology;
      HashMap<String, String> _hashMap = new HashMap<String, String>();
      this.imports = _hashMap;
      HashSet<String> _hashSet_1 = new HashSet<String>();
      this.localNames = _hashSet_1;
      final Consumer<Entity> _function = (Entity it) -> {
        this.localNames.add(it.name());
      };
      Iterables.<Entity>filter(terminology.getBoxStatements(), Entity.class).forEach(_function);
      final Consumer<Structure> _function_1 = (Structure it) -> {
        this.localNames.add(it.name());
      };
      Iterables.<Structure>filter(terminology.getBoxStatements(), Structure.class).forEach(_function_1);
      final IProject eInfo = generator.editProjectHandle;
      final IPath eLoc = eInfo.getFullPath();
      final String[] eSegs = eLoc.segments();
      final IProject pInfo = generator.ecoreProjectHandle;
      final IPath pLoc = pInfo.getFullPath();
      final String[] pSegs = pLoc.segments();
      this.packageEQName = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(eSegs)), ".");
      this.packageQName = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(pSegs)), ".");
      this.packageNsURI = OMLExtensions.getModuleNsURI(terminology);
      this.packageNsPrefix = OMLExtensions.getModuleNsPrefix(terminology);
      this.dsmlName = dsmlName;
      this.packageTName = OMLGenerator.validQName(terminology);
    }
    
    protected String imported(final String qualifiedName) {
      String _xblockexpression = null;
      {
        final String[] sections = qualifiedName.split("\\.");
        int _size = ((List<String>)Conversions.doWrapArray(sections)).size();
        int _minus = (_size - 1);
        final String simpleName = OMLGenerator.legalName(sections[_minus]);
        final String legalQName = OMLGenerator.legalName(qualifiedName);
        String _xifexpression = null;
        boolean _contains = this.localNames.contains(simpleName);
        if (_contains) {
          _xifexpression = legalQName;
        } else {
          String _switchResult = null;
          String _get = this.imports.get(simpleName);
          final String existing = _get;
          boolean _matched = false;
          if (Objects.equal(existing, null)) {
            _matched=true;
            String _xblockexpression_1 = null;
            {
              this.imports.put(simpleName, legalQName);
              _xblockexpression_1 = simpleName;
            }
            _switchResult = _xblockexpression_1;
          }
          if (!_matched) {
            boolean _notEquals = (!Objects.equal(existing, legalQName));
            if (_notEquals) {
              _matched=true;
              _switchResult = legalQName;
            }
          }
          if (!_matched) {
            _switchResult = existing;
          }
          _xifexpression = _switchResult;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
    
    protected String imported(final EClass eClass) {
      String _name = eClass.getName();
      String _plus = ("gov.nasa.jpl.imce.oml.runtime." + _name);
      return this.imported(_plus);
    }
    
    protected String imported(final Term term) {
      String _xifexpression = null;
      if ((((term.getTbox() != null) && (!Objects.equal(term.getTbox(), this.terminology))) && (!term.iri().startsWith(this.XSD_NS)))) {
        _xifexpression = this.imported(this.qualifieddName(term));
      } else {
        _xifexpression = term.name();
      }
      return _xifexpression;
    }
    
    public CharSequence doGenerate() {
      StringConcatenation _builder = new StringConcatenation();
      final CharSequence body = this.convertToBody(this.terminology);
      _builder.newLineIfNotEmpty();
      CharSequence _convertToPackage = this.convertToPackage(this.terminology);
      _builder.append(_convertToPackage);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _convertToImports = this.convertToImports(this.terminology);
      _builder.append(_convertToImports);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* This annotation specifies:");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* - The provenance of an OML term mapped to an Xcore definition as part of mapping an OML bundle to an M2 Xcore metamodel.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* - For M1 element instances of such an M2 xcore definition, the OML term to which the M1 instance needs to be mapped back.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*   Note that there are two possible mappings:");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*   - as an OML TerminologyBox (lifting instances to a vocabulary)");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*   - as an OML DescriptionBox (converting DSL elements to OML instances).");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Synopsis (in generated xcore):");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @OMLProvenance(kind=\"<OML term metaclass>\", iri=\"<OML term IRI>\")");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* <xcore term definition>");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("annotation \"http://imce.jpl.nasa.gov/oml/runtime/OMLProvenance\" as OMLProvenance");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* OML provides the flexibility to specify the binding of an OML DataRange to a particular implementation with this annotation.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* OML DataRanges are specified according to the restrictions of the OWL2-DL datatype map, which includes");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* a subset of XML Schema 1.1 datatypes (e.g., xsd:decimal, xsd:integer, xsd:int, xsd:long, ...)");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Some numeric datatypes like xsd:decimal, owl:rational, owl:real allow for numbers represented with arbitrarily long strings.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Unfortunately most binding implementationd, including the Java XML Binding (JAXB) use finite-precision ");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* numbers (even java.math.BigDecimal!). This means that in special cases where, e.g., a 40-digit xsd:decimal is needed,");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* such implementations would either loose some information or produce errors.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Instead of a fixed datatype binding to a limited implementation capability, this annotation allows");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* an OML vocabulary designer to customize the binding individual OML DataRanges.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Synopsis (in oml source):");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* annotationProperty oml:JavaDatatypeBinding = <http://imce.jpl.nasa.gov/oml/runtime/OML2JavaDatatypeBinding>");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @oml:JavaDatatypeBinding(type=\"<java datatype qualified name>\")");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* <oml datarange kind> <datarange name> { ... }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* (in generated xcore):");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @OMLProvenance(kind=\"<OML datarange metaclass>\", iri=\"<OML datarange IRI>\")");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* type <OML datarange name> wraps <java datatype qualified name>");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("annotation \"http://imce.jpl.nasa.gov/oml/runtime/OML2JavaDatatypeBinding\" as OML2JavaDatatypeBinding");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append(body);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence convertToPackage(final TerminologyBox terminology) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@Ecore(");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("nsURI=\"");
      _builder.append(this.packageNsURI, "\t");
      _builder.append("\",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("nsPrefix=\"");
      _builder.append(this.packageNsPrefix, "\t");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append(")");
      _builder.newLine();
      _builder.append("@GenModel(");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("copyrightText=\"\\nCopyright 2017 California Institute of Technology (\\\"Caltech\\\").\\nU.S. Government sponsorship acknowledged.\\n\\nLicensed under the Apache License, Version 2.0 (the \\\"License\\\");\\nyou may not use this file except in compliance with the License.\\nYou may obtain a copy of the License at\\n\\n     http://www.apache.org/licenses/LICENSE-2.0\\n\\nUnless required by applicable law or agreed to in writing, software\\ndistributed under the License is distributed on an \\\"AS IS\\\" BASIS,\\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\\nSee the License for the specific language governing permissions and\\nlimitations under the License.\\n\",");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("modelPluginVariables=\"org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo\",");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("rootExtendsClass=\"org.eclipse.emf.internal.cdo.CDOObjectImpl\",");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("rootExtendsInterface=\"org.eclipse.emf.cdo.CDOObject\",");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("childCreationExtenders=\"true\",");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("complianceLevel=\"8.0\",");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("featureDelegation=\"None\",");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("modelDirectory=\"/");
      _builder.append(this.packageQName, "\t");
      _builder.append("/src-gen/\",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("editDirectory=\"/");
      _builder.append(this.packageEQName, "\t");
      _builder.append("/src-gen\",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("editPluginClass=\"");
      _builder.append(this.packageEQName, "\t");
      _builder.append(".BundleEditPlugin\"");
      _builder.newLineIfNotEmpty();
      _builder.append(")");
      _builder.newLine();
      _builder.append("package ");
      _builder.append(this.packageTName);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence convertToImports(final TerminologyBox terminology) {
      StringConcatenation _builder = new StringConcatenation();
      {
        List<String> _sort = IterableExtensions.<String>sort(this.imports.values());
        boolean _hasElements = false;
        for(final String anImport : _sort) {
          if (!_hasElements) {
            _hasElements = true;
          }
          _builder.append("import ");
          _builder.append(anImport);
          _builder.newLineIfNotEmpty();
        }
        if (_hasElements) {
          _builder.append("\n");
        }
      }
      return _builder;
    }
    
    protected CharSequence convertToBody(final TerminologyBox terminology) {
      StringConcatenation _builder = new StringConcatenation();
      {
        final Function1<Term, String> _function = (Term it) -> {
          return OMLGenerator.validName(it);
        };
        List<Term> _sortBy = IterableExtensions.<Term, String>sortBy(Iterables.<Term>filter(terminology.getBoxStatements(), Term.class), _function);
        boolean _hasElements = false;
        for(final Term type : _sortBy) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("\n", "");
          }
          CharSequence _convertToType = this.convertToType(type);
          _builder.append(_convertToType);
          _builder.newLineIfNotEmpty();
        }
      }
      return _builder;
    }
    
    protected CharSequence _convertToType(final ScalarOneOfRestriction range) {
      StringConcatenation _builder = new StringConcatenation();
      final Function1<ScalarOneOfLiteralAxiom, Boolean> _function = (ScalarOneOfLiteralAxiom a) -> {
        ScalarOneOfRestriction _axiom = a.getAxiom();
        return Boolean.valueOf((_axiom == range));
      };
      final Iterable<ScalarOneOfLiteralAxiom> axioms = IterableExtensions.<ScalarOneOfLiteralAxiom>filter(this.<ScalarOneOfLiteralAxiom>allTBoxStatementsOfType(ScalarOneOfLiteralAxiom.class), _function);
      _builder.newLineIfNotEmpty();
      _builder.append("enum ");
      String _name = range.name();
      _builder.append(_name);
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        final Function1<ScalarOneOfLiteralAxiom, String> _function_1 = (ScalarOneOfLiteralAxiom it) -> {
          return it.getValue();
        };
        List<ScalarOneOfLiteralAxiom> _sortBy = IterableExtensions.<ScalarOneOfLiteralAxiom, String>sortBy(axioms, _function_1);
        for(final ScalarOneOfLiteralAxiom literal : _sortBy) {
          _builder.append("\t");
          String _value = literal.getValue();
          _builder.append(_value, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("} ");
      _builder.newLine();
      return _builder;
    }
    
    public String lookupOML2JavaDatatypeBinding(final DataRange range) {
      String _elvis = null;
      final Function1<AnnotationPropertyValue, Boolean> _function = (AnnotationPropertyValue it) -> {
        return Boolean.valueOf((Objects.equal(it.getSubject(), range) && Objects.equal(it.getProperty().getIri(), "http://imce.jpl.nasa.gov/oml/runtime/OML2JavaDatatypeBinding")));
      };
      AnnotationPropertyValue _findFirst = IterableExtensions.<AnnotationPropertyValue>findFirst(range.getTbox().getAnnotations(), _function);
      String _value = null;
      if (_findFirst!=null) {
        _value=_findFirst.getValue();
      }
      if (_value != null) {
        _elvis = _value;
      } else {
        _elvis = "java.lang.String";
      }
      return _elvis;
    }
    
    public String facet(final DataRange range, final EAttribute facet) {
      String _xifexpression = null;
      boolean _eIsSet = range.eIsSet(facet);
      boolean _not = (!_eIsSet);
      if (_not) {
        _xifexpression = "";
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("@ExtendedMetaData(key=\"");
        String _name = facet.getName();
        _builder.append(_name);
        _builder.append("\",value=\"");
        Object _eGet = range.eGet(facet);
        _builder.append(_eGet);
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder.toString();
      }
      return _xifexpression;
    }
    
    public String facets(final DataRange range, final EAttribute... facets) {
      String _xblockexpression = null;
      {
        final StringBuffer buff = new StringBuffer();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("@OMLProvenance(kind=\"");
        String _name = range.eClass().getName();
        _builder.append(_name);
        _builder.append("\",iri=\"");
        String _iri = range.iri();
        _builder.append(_iri);
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        buff.append(_builder);
        for (final EAttribute f : facets) {
          {
            final String ext = this.facet(range, f);
            boolean _isEmpty = ext.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              buff.append(ext);
            }
          }
        }
        _xblockexpression = buff.toString();
      }
      return _xblockexpression;
    }
    
    protected CharSequence _convertToType(final BinaryScalarRestriction range) {
      StringConcatenation _builder = new StringConcatenation();
      String _facets = this.facets(range, 
        TerminologiesPackage.eINSTANCE.getBinaryScalarRestriction_Length(), 
        TerminologiesPackage.eINSTANCE.getBinaryScalarRestriction_MinLength(), 
        TerminologiesPackage.eINSTANCE.getBinaryScalarRestriction_MaxLength());
      _builder.append(_facets);
      _builder.newLineIfNotEmpty();
      _builder.append("type ");
      String _validName = OMLGenerator.validName(range);
      _builder.append(_validName);
      _builder.append(" wraps ");
      String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(range);
      _builder.append(_lookupOML2JavaDatatypeBinding);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _convertToType(final IRIScalarRestriction range) {
      StringConcatenation _builder = new StringConcatenation();
      String _facets = this.facets(range, 
        TerminologiesPackage.eINSTANCE.getIRIScalarRestriction_Length(), 
        TerminologiesPackage.eINSTANCE.getIRIScalarRestriction_MinLength(), 
        TerminologiesPackage.eINSTANCE.getIRIScalarRestriction_MaxLength(), 
        TerminologiesPackage.eINSTANCE.getIRIScalarRestriction_MaxLength());
      _builder.append(_facets);
      _builder.newLineIfNotEmpty();
      _builder.append("type ");
      String _validName = OMLGenerator.validName(range);
      _builder.append(_validName);
      _builder.append(" wraps ");
      String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(range);
      _builder.append(_lookupOML2JavaDatatypeBinding);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _convertToType(final NumericScalarRestriction range) {
      StringConcatenation _builder = new StringConcatenation();
      String _facets = this.facets(range, 
        TerminologiesPackage.eINSTANCE.getNumericScalarRestriction_MinInclusive(), 
        TerminologiesPackage.eINSTANCE.getNumericScalarRestriction_MaxInclusive(), 
        TerminologiesPackage.eINSTANCE.getNumericScalarRestriction_MinExclusive(), 
        TerminologiesPackage.eINSTANCE.getNumericScalarRestriction_MaxExclusive());
      _builder.append(_facets);
      _builder.newLineIfNotEmpty();
      _builder.append("type ");
      String _validName = OMLGenerator.validName(range);
      _builder.append(_validName);
      _builder.append(" wraps ");
      String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(range);
      _builder.append(_lookupOML2JavaDatatypeBinding);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _convertToType(final PlainLiteralScalarRestriction range) {
      StringConcatenation _builder = new StringConcatenation();
      String _facets = this.facets(range, 
        TerminologiesPackage.eINSTANCE.getPlainLiteralScalarRestriction_Length(), 
        TerminologiesPackage.eINSTANCE.getPlainLiteralScalarRestriction_MinLength(), 
        TerminologiesPackage.eINSTANCE.getPlainLiteralScalarRestriction_MaxLength(), 
        TerminologiesPackage.eINSTANCE.getPlainLiteralScalarRestriction_Pattern(), 
        TerminologiesPackage.eINSTANCE.getPlainLiteralScalarRestriction_LangRange());
      _builder.append(_facets);
      _builder.newLineIfNotEmpty();
      _builder.append("type ");
      String _validName = OMLGenerator.validName(range);
      _builder.append(_validName);
      _builder.append(" wraps ");
      String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(range);
      _builder.append(_lookupOML2JavaDatatypeBinding);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _convertToType(final Scalar scalar) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@OMLProvenance(kind=\"");
      String _name = scalar.eClass().getName();
      _builder.append(_name);
      _builder.append("\",iri=\"");
      String _iri = scalar.iri();
      _builder.append(_iri);
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("type ");
      String _validName = OMLGenerator.validName(scalar);
      _builder.append(_validName);
      _builder.append(" wraps ");
      String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(scalar);
      _builder.append(_lookupOML2JavaDatatypeBinding);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _convertToType(final StringScalarRestriction range) {
      StringConcatenation _builder = new StringConcatenation();
      String _facets = this.facets(range, 
        TerminologiesPackage.eINSTANCE.getStringScalarRestriction_Length(), 
        TerminologiesPackage.eINSTANCE.getStringScalarRestriction_MinLength(), 
        TerminologiesPackage.eINSTANCE.getStringScalarRestriction_MaxLength(), 
        TerminologiesPackage.eINSTANCE.getStringScalarRestriction_Pattern());
      _builder.append(_facets);
      _builder.newLineIfNotEmpty();
      _builder.append("type ");
      String _validName = OMLGenerator.validName(range);
      _builder.append(_validName);
      _builder.append(" wraps ");
      String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(range);
      _builder.append(_lookupOML2JavaDatatypeBinding);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _convertToType(final SynonymScalarRestriction range) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@OMLProvenance(kind=\"");
      String _name = range.eClass().getName();
      _builder.append(_name);
      _builder.append("\",iri=\"");
      String _iri = range.iri();
      _builder.append(_iri);
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("type ");
      String _validName = OMLGenerator.validName(range);
      _builder.append(_validName);
      _builder.append(" wraps ");
      String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(range);
      _builder.append(_lookupOML2JavaDatatypeBinding);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _convertToType(final TimeScalarRestriction range) {
      StringConcatenation _builder = new StringConcatenation();
      String _facets = this.facets(range, 
        TerminologiesPackage.eINSTANCE.getTimeScalarRestriction_MinInclusive(), 
        TerminologiesPackage.eINSTANCE.getTimeScalarRestriction_MaxInclusive(), 
        TerminologiesPackage.eINSTANCE.getTimeScalarRestriction_MinExclusive(), 
        TerminologiesPackage.eINSTANCE.getTimeScalarRestriction_MaxExclusive());
      _builder.append(_facets);
      _builder.newLineIfNotEmpty();
      _builder.append("type ");
      String _validName = OMLGenerator.validName(range);
      _builder.append(_validName);
      _builder.append(" wraps ");
      String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(range);
      _builder.append(_lookupOML2JavaDatatypeBinding);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _convertToType(final Structure structure) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@OMLProvenance(kind=\"");
      String _name = structure.eClass().getName();
      _builder.append(_name);
      _builder.append("\",iri=\"");
      String _iri = structure.iri();
      _builder.append(_iri);
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("class ");
      String _validName = OMLGenerator.validName(structure);
      _builder.append(_validName);
      _builder.append(" extends ");
      String _imported = this.imported(OMLRuntimePackage.Literals.OML_STRUCTURE);
      _builder.append(_imported);
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _dataProperties = this.dataProperties(structure);
      _builder.append(_dataProperties, "\t");
      _builder.append("\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      return _builder;
    }
    
    protected CharSequence _convertToType(final Aspect aspect) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@OMLProvenance(kind=\"");
      String _name = aspect.eClass().getName();
      _builder.append(_name);
      _builder.append("\",iri=\"");
      String _iri = aspect.iri();
      _builder.append(_iri);
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("interface ");
      String _validName = OMLGenerator.validName(aspect);
      _builder.append(_validName);
      _builder.append(" ");
      CharSequence _extendedTypes = this.extendedTypes(aspect);
      _builder.append(_extendedTypes);
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _dataProperties = this.dataProperties(aspect);
      _builder.append(_dataProperties, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _entityOperations = this.entityOperations(aspect);
      _builder.append(_entityOperations, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      return _builder;
    }
    
    protected CharSequence _convertToType(final Concept concept) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@OMLProvenance(kind=\"");
      String _name = concept.eClass().getName();
      _builder.append(_name);
      _builder.append("\",iri=\"");
      String _iri = concept.iri();
      _builder.append(_iri);
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("class ");
      String _validName = OMLGenerator.validName(concept);
      _builder.append(_validName);
      _builder.append(" ");
      CharSequence _extendedTypes = this.extendedTypes(concept);
      _builder.append(_extendedTypes);
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _dataProperties = this.dataProperties(concept);
      _builder.append(_dataProperties, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _entityProperties = this.entityProperties(concept);
      _builder.append(_entityProperties, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _entityOperations = this.entityOperations(concept);
      _builder.append(_entityOperations, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      return _builder;
    }
    
    protected CharSequence _convertToType(final ReifiedRelationship relationship) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@OMLProvenance(kind=\"");
      String _name = relationship.eClass().getName();
      _builder.append(_name);
      _builder.append("\",iri=\"");
      String _iri = relationship.iri();
      _builder.append(_iri);
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("class ");
      String _validName = OMLGenerator.validName(relationship);
      _builder.append(_validName);
      _builder.append(" ");
      CharSequence _extendedTypes = this.extendedTypes(relationship);
      _builder.append(_extendedTypes);
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _dataProperties = this.dataProperties(relationship);
      _builder.append(_dataProperties, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _entityProperties = this.entityProperties(relationship);
      _builder.append(_entityProperties, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      final Function1<ReifiedRelationshipSpecializationAxiom, Boolean> _function = (ReifiedRelationshipSpecializationAxiom it) -> {
        ReifiedRelationship _subRelationship = it.getSubRelationship();
        return Boolean.valueOf(Objects.equal(_subRelationship, relationship));
      };
      final Function1<ReifiedRelationshipSpecializationAxiom, ReifiedRelationship> _function_1 = (ReifiedRelationshipSpecializationAxiom it) -> {
        return it.getSuperRelationship();
      };
      final Iterable<ReifiedRelationship> superClasses = IterableExtensions.<ReifiedRelationshipSpecializationAxiom, ReifiedRelationship>map(IterableExtensions.<ReifiedRelationshipSpecializationAxiom>filter(this.<ReifiedRelationshipSpecializationAxiom>allTBoxStatementsOfType(ReifiedRelationshipSpecializationAxiom.class), _function), _function_1);
      _builder.newLineIfNotEmpty();
      {
        if ((IterableExtensions.isEmpty(superClasses) || (!Objects.equal(((ReifiedRelationship[])Conversions.unwrapArray(superClasses, ReifiedRelationship.class))[0].getSource(), relationship.getSource())))) {
          _builder.append("\t");
          _builder.append("op ");
          String _imported = this.imported(relationship.getSource());
          _builder.append(_imported, "\t");
          _builder.append(" getOmlSource() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super.omlSource as ");
          String _imported_1 = this.imported(relationship.getSource());
          _builder.append(_imported_1, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("op void setOmlSource(");
          String _imported_2 = this.imported("gov.nasa.jpl.imce.oml.runtime.OMLEntity");
          _builder.append(_imported_2, "\t");
          _builder.append(" source) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (source!==null && !(source instanceof ");
          String _imported_3 = this.imported(relationship.getSource());
          _builder.append(_imported_3, "\t\t");
          _builder.append("))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("throw new ");
          String _imported_4 = this.imported("java.lang.IllegalArgumentException");
          _builder.append(_imported_4, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super.omlSource = source");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        if ((IterableExtensions.isEmpty(superClasses) || (!Objects.equal(((ReifiedRelationship[])Conversions.unwrapArray(superClasses, ReifiedRelationship.class))[0].getTarget(), relationship.getTarget())))) {
          _builder.append("\t");
          _builder.append("op ");
          String _imported_5 = this.imported(relationship.getTarget());
          _builder.append(_imported_5, "\t");
          _builder.append(" getOmlTarget() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super.omlTarget as ");
          String _imported_6 = this.imported(relationship.getTarget());
          _builder.append(_imported_6, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("op void setOmlTarget(");
          String _imported_7 = this.imported("gov.nasa.jpl.imce.oml.runtime.OMLEntity");
          _builder.append(_imported_7, "\t");
          _builder.append(" target) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (target!==null && !(target instanceof ");
          String _imported_8 = this.imported(relationship.getTarget());
          _builder.append(_imported_8, "\t\t");
          _builder.append("))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("throw new ");
          String _imported_9 = this.imported("java.lang.IllegalArgumentException");
          _builder.append(_imported_9, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super.omlTarget = target");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      CharSequence _entityOperations = this.entityOperations(relationship);
      _builder.append(_entityOperations, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      return _builder;
    }
    
    protected CharSequence _convertToType(final DataRelationship dr) {
      StringConcatenation _builder = new StringConcatenation();
      return _builder;
    }
    
    protected CharSequence _convertToType(final Term t) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// ");
      String _name = t.eClass().getName();
      _builder.append(_name);
      _builder.append(": ");
      String _name_1 = t.name();
      _builder.append(_name_1);
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    
    protected CharSequence _extendedTypes(final Aspect aspect) {
      CharSequence _xblockexpression = null;
      {
        final ArrayList<String> types = new ArrayList<String>();
        final Function1<AspectSpecializationAxiom, Boolean> _function = (AspectSpecializationAxiom it) -> {
          Entity _subEntity = it.getSubEntity();
          return Boolean.valueOf(Objects.equal(_subEntity, aspect));
        };
        final Function1<AspectSpecializationAxiom, String> _function_1 = (AspectSpecializationAxiom it) -> {
          return this.imported(it.getSuperAspect());
        };
        types.addAll(IterableExtensions.<String>sort(IterableExtensions.<AspectSpecializationAxiom, String>map(IterableExtensions.<AspectSpecializationAxiom>filter(this.<AspectSpecializationAxiom>allTBoxStatementsOfType(AspectSpecializationAxiom.class), _function), _function_1)));
        boolean _isEmpty = types.isEmpty();
        if (_isEmpty) {
          types.add(this.imported(OMLRuntimePackage.Literals.OML_ASPECT));
        }
        _xblockexpression = this.convertToExtends(types);
      }
      return _xblockexpression;
    }
    
    protected CharSequence _extendedTypes(final Concept concept) {
      CharSequence _xblockexpression = null;
      {
        final ArrayList<String> types = new ArrayList<String>();
        final Function1<ConceptSpecializationAxiom, Boolean> _function = (ConceptSpecializationAxiom it) -> {
          Concept _subConcept = it.getSubConcept();
          return Boolean.valueOf(Objects.equal(_subConcept, concept));
        };
        final Function1<ConceptSpecializationAxiom, String> _function_1 = (ConceptSpecializationAxiom it) -> {
          return this.imported(it.getSuperConcept());
        };
        types.addAll(IterableExtensions.<String>sort(IterableExtensions.<ConceptSpecializationAxiom, String>map(IterableExtensions.<ConceptSpecializationAxiom>filter(this.<ConceptSpecializationAxiom>allTBoxStatementsOfType(ConceptSpecializationAxiom.class), _function), _function_1)));
        boolean _isEmpty = types.isEmpty();
        if (_isEmpty) {
          types.add(this.imported(OMLRuntimePackage.Literals.OML_CONCEPT));
        }
        final Function1<AspectSpecializationAxiom, Boolean> _function_2 = (AspectSpecializationAxiom it) -> {
          Entity _subEntity = it.getSubEntity();
          return Boolean.valueOf(Objects.equal(_subEntity, concept));
        };
        final Function1<AspectSpecializationAxiom, String> _function_3 = (AspectSpecializationAxiom it) -> {
          return this.imported(it.getSuperAspect());
        };
        types.addAll(IterableExtensions.<String>sort(IterableExtensions.<AspectSpecializationAxiom, String>map(IterableExtensions.<AspectSpecializationAxiom>filter(this.<AspectSpecializationAxiom>allTBoxStatementsOfType(AspectSpecializationAxiom.class), _function_2), _function_3)));
        _xblockexpression = this.convertToExtends(types);
      }
      return _xblockexpression;
    }
    
    protected CharSequence _extendedTypes(final ReifiedRelationship relationship) {
      CharSequence _xblockexpression = null;
      {
        final ArrayList<String> types = new ArrayList<String>();
        final Function1<ReifiedRelationshipSpecializationAxiom, Boolean> _function = (ReifiedRelationshipSpecializationAxiom it) -> {
          ReifiedRelationship _subRelationship = it.getSubRelationship();
          return Boolean.valueOf(Objects.equal(_subRelationship, relationship));
        };
        final Function1<ReifiedRelationshipSpecializationAxiom, String> _function_1 = (ReifiedRelationshipSpecializationAxiom it) -> {
          return this.imported(it.getSuperRelationship());
        };
        types.addAll(IterableExtensions.<String>sort(IterableExtensions.<ReifiedRelationshipSpecializationAxiom, String>map(IterableExtensions.<ReifiedRelationshipSpecializationAxiom>filter(this.<ReifiedRelationshipSpecializationAxiom>allTBoxStatementsOfType(ReifiedRelationshipSpecializationAxiom.class), _function), _function_1)));
        boolean _isEmpty = types.isEmpty();
        if (_isEmpty) {
          types.add(this.imported(OMLRuntimePackage.Literals.OML_REIFIED_RELATIONSHIP));
        }
        final Function1<AspectSpecializationAxiom, Boolean> _function_2 = (AspectSpecializationAxiom it) -> {
          Entity _subEntity = it.getSubEntity();
          return Boolean.valueOf(Objects.equal(_subEntity, relationship));
        };
        final Function1<AspectSpecializationAxiom, String> _function_3 = (AspectSpecializationAxiom it) -> {
          return this.imported(it.getSuperAspect());
        };
        types.addAll(IterableExtensions.<String>sort(IterableExtensions.<AspectSpecializationAxiom, String>map(IterableExtensions.<AspectSpecializationAxiom>filter(this.<AspectSpecializationAxiom>allTBoxStatementsOfType(AspectSpecializationAxiom.class), _function_2), _function_3)));
        _xblockexpression = this.convertToExtends(types);
      }
      return _xblockexpression;
    }
    
    /**
     * For now, use the java datatype name as the type of a scalar data property:
     * «property.range.lookupOML2JavaDatatypeBinding»[1] «property.validName»
     * 
     * Consider mapping OML DataRanges to corresponding Ecore datatypes.
     */
    protected CharSequence _dataProperties(final Structure structure) {
      StringConcatenation _builder = new StringConcatenation();
      {
        final Function1<ScalarDataProperty, Boolean> _function = (ScalarDataProperty it) -> {
          Structure _domain = it.getDomain();
          return Boolean.valueOf(Objects.equal(_domain, structure));
        };
        final Function1<ScalarDataProperty, String> _function_1 = (ScalarDataProperty it) -> {
          return it.name();
        };
        List<ScalarDataProperty> _sortBy = IterableExtensions.<ScalarDataProperty, String>sortBy(IterableExtensions.<ScalarDataProperty>filter(this.<ScalarDataProperty>allTBoxStatementsOfType(ScalarDataProperty.class), _function), _function_1);
        for(final ScalarDataProperty property : _sortBy) {
          String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(property.getRange());
          _builder.append(_lookupOML2JavaDatatypeBinding);
          _builder.append("[1] ");
          String _validName = OMLGenerator.validName(property);
          _builder.append(_validName);
          _builder.newLineIfNotEmpty();
        }
      }
      {
        final Function1<StructuredDataProperty, Boolean> _function_2 = (StructuredDataProperty it) -> {
          Structure _domain = it.getDomain();
          return Boolean.valueOf(Objects.equal(_domain, structure));
        };
        final Function1<StructuredDataProperty, String> _function_3 = (StructuredDataProperty it) -> {
          return it.name();
        };
        List<StructuredDataProperty> _sortBy_1 = IterableExtensions.<StructuredDataProperty, String>sortBy(IterableExtensions.<StructuredDataProperty>filter(this.<StructuredDataProperty>allTBoxStatementsOfType(StructuredDataProperty.class), _function_2), _function_3);
        for(final StructuredDataProperty property_1 : _sortBy_1) {
          _builder.append("contains ");
          String _dataContainer = this.dataContainer(property_1);
          _builder.append(_dataContainer);
          String _imported = this.imported(property_1.getRange());
          _builder.append(_imported);
          _builder.append("[1] ");
          String _validName_1 = OMLGenerator.validName(property_1);
          _builder.append(_validName_1);
          _builder.newLineIfNotEmpty();
        }
      }
      return _builder;
    }
    
    /**
     * For now, use the java datatype name as the type of a scalar data property:
     * «property.range.lookupOML2JavaDatatypeBinding»[1] «property.validName»
     * 
     * Consider mapping OML DataRanges to corresponding Ecore datatypes.
     */
    protected CharSequence _dataProperties(final Entity entity) {
      StringConcatenation _builder = new StringConcatenation();
      {
        final Function1<EntityScalarDataProperty, Boolean> _function = (EntityScalarDataProperty it) -> {
          Entity _domain = it.getDomain();
          return Boolean.valueOf(Objects.equal(_domain, entity));
        };
        final Function1<EntityScalarDataProperty, String> _function_1 = (EntityScalarDataProperty it) -> {
          return it.name();
        };
        List<EntityScalarDataProperty> _sortBy = IterableExtensions.<EntityScalarDataProperty, String>sortBy(IterableExtensions.<EntityScalarDataProperty>filter(this.<EntityScalarDataProperty>allTBoxStatementsOfType(EntityScalarDataProperty.class), _function), _function_1);
        for(final EntityScalarDataProperty property : _sortBy) {
          _builder.append("@OMLProvenance(kind=\"");
          String _name = property.eClass().getName();
          _builder.append(_name);
          _builder.append("\",iri=\"");
          String _iri = property.iri();
          _builder.append(_iri);
          _builder.append("\")");
          _builder.newLineIfNotEmpty();
          String _lookupOML2JavaDatatypeBinding = this.lookupOML2JavaDatatypeBinding(property.getRange());
          _builder.append(_lookupOML2JavaDatatypeBinding);
          _builder.append("[1] ");
          String _validName = OMLGenerator.validName(property);
          _builder.append(_validName);
          _builder.newLineIfNotEmpty();
        }
      }
      {
        final Function1<EntityStructuredDataProperty, Boolean> _function_2 = (EntityStructuredDataProperty it) -> {
          Entity _domain = it.getDomain();
          return Boolean.valueOf(Objects.equal(_domain, entity));
        };
        final Function1<EntityStructuredDataProperty, String> _function_3 = (EntityStructuredDataProperty it) -> {
          return it.name();
        };
        List<EntityStructuredDataProperty> _sortBy_1 = IterableExtensions.<EntityStructuredDataProperty, String>sortBy(IterableExtensions.<EntityStructuredDataProperty>filter(this.<EntityStructuredDataProperty>allTBoxStatementsOfType(EntityStructuredDataProperty.class), _function_2), _function_3);
        for(final EntityStructuredDataProperty property_1 : _sortBy_1) {
          _builder.append("@OMLProvenance(kind=\"");
          String _name_1 = property_1.eClass().getName();
          _builder.append(_name_1);
          _builder.append("\",iri=\"");
          String _iri_1 = property_1.iri();
          _builder.append(_iri_1);
          _builder.append("\")");
          _builder.newLineIfNotEmpty();
          _builder.append("contains ");
          String _dataContainer = this.dataContainer(property_1);
          _builder.append(_dataContainer);
          String _imported = this.imported(property_1.getRange());
          _builder.append(_imported);
          _builder.append("[1] ");
          String _validName_1 = OMLGenerator.validName(property_1);
          _builder.append(_validName_1);
          _builder.newLineIfNotEmpty();
        }
      }
      return _builder;
    }
    
    protected String dataContainer(final DataRelationship dr) {
      String _switchResult = null;
      Datatype _target = dr.target();
      boolean _matched = false;
      if (_target instanceof ScalarOneOfRestriction) {
        _matched=true;
        _switchResult = "";
      }
      if (!_matched) {
        _switchResult = "";
      }
      return _switchResult;
    }
    
    protected CharSequence entityProperties(final Entity entity) {
      StringConcatenation _builder = new StringConcatenation();
      {
        final Function1<UnreifiedRelationship, Boolean> _function = (UnreifiedRelationship it) -> {
          Entity _source = it.getSource();
          return Boolean.valueOf(Objects.equal(_source, entity));
        };
        final Function1<UnreifiedRelationship, String> _function_1 = (UnreifiedRelationship it) -> {
          return it.name();
        };
        List<UnreifiedRelationship> _sortBy = IterableExtensions.<UnreifiedRelationship, String>sortBy(IterableExtensions.<UnreifiedRelationship>filter(this.<UnreifiedRelationship>allTBoxStatementsOfType(UnreifiedRelationship.class), _function), _function_1);
        for(final UnreifiedRelationship property : _sortBy) {
          _builder.append("@OMLProvenance(kind=\"");
          String _name = property.eClass().getName();
          _builder.append(_name);
          _builder.append("\",iri=\"");
          String _iri = property.iri();
          _builder.append(_iri);
          _builder.append("\")");
          _builder.newLineIfNotEmpty();
          _builder.append("refers ");
          String _imported = this.imported(property.getTarget());
          _builder.append(_imported);
          _builder.append("[1] ");
          String _validName = OMLGenerator.validName(property);
          _builder.append(_validName);
          _builder.newLineIfNotEmpty();
        }
      }
      return _builder;
    }
    
    protected CharSequence entityOperations(final Entity entity) {
      StringConcatenation _builder = new StringConcatenation();
      {
        final Function1<ReifiedRelationship, Boolean> _function = (ReifiedRelationship it) -> {
          Entity _source = it.getSource();
          return Boolean.valueOf(Objects.equal(_source, entity));
        };
        final Function1<ReifiedRelationship, String> _function_1 = (ReifiedRelationship it) -> {
          return this.targetName(it);
        };
        List<ReifiedRelationship> _sortBy = IterableExtensions.<ReifiedRelationship, String>sortBy(IterableExtensions.<ReifiedRelationship>filter(this.<ReifiedRelationship>allTBoxStatementsOfType(ReifiedRelationship.class), _function), _function_1);
        for(final ReifiedRelationship relationship : _sortBy) {
          _builder.append("op ");
          String _imported = this.imported(relationship.getTarget());
          _builder.append(_imported);
          {
            boolean _isIsFunctional = relationship.isIsFunctional();
            boolean _not = (!_isIsFunctional);
            if (_not) {
              _builder.append("[]");
            }
          }
          _builder.append(" ");
          String _targetName = this.targetName(relationship);
          _builder.append(_targetName);
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("omlInverseReferencers(");
          String _imported_1 = this.imported(relationship);
          _builder.append(_imported_1, "\t");
          _builder.append(").filter[omlSource === this].map[omlTarget].toEList");
          {
            boolean _isIsFunctional_1 = relationship.isIsFunctional();
            if (_isIsFunctional_1) {
              _builder.append(".findFirst[true]");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        final Function1<ReifiedRelationship, Boolean> _function_2 = (ReifiedRelationship it) -> {
          return Boolean.valueOf((Objects.equal(it.getTarget(), entity) && (it.getUnreifiedInversePropertyName() != null)));
        };
        final Function1<ReifiedRelationship, String> _function_3 = (ReifiedRelationship it) -> {
          return this.sourceName(it);
        };
        List<ReifiedRelationship> _sortBy_1 = IterableExtensions.<ReifiedRelationship, String>sortBy(IterableExtensions.<ReifiedRelationship>filter(this.<ReifiedRelationship>allTBoxStatementsOfType(ReifiedRelationship.class), _function_2), _function_3);
        for(final ReifiedRelationship relationship_1 : _sortBy_1) {
          _builder.append("op ");
          String _imported_2 = this.imported(relationship_1.getSource());
          _builder.append(_imported_2);
          {
            boolean _isIsInverseFunctional = relationship_1.isIsInverseFunctional();
            boolean _not_1 = (!_isIsInverseFunctional);
            if (_not_1) {
              _builder.append("[]");
            }
          }
          _builder.append(" ");
          String _sourceName = this.sourceName(relationship_1);
          _builder.append(_sourceName);
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("omlInverseReferencers(");
          String _imported_3 = this.imported(relationship_1);
          _builder.append(_imported_3, "\t");
          _builder.append(").filter[omlTarget === this].map[omlSource].toEList");
          {
            boolean _isIsInverseFunctional_1 = relationship_1.isIsInverseFunctional();
            if (_isIsInverseFunctional_1) {
              _builder.append(".findFirst[true]");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        final Function1<EntityUniversalRestrictionAxiom, Boolean> _function_4 = (EntityUniversalRestrictionAxiom it) -> {
          return Boolean.valueOf((Objects.equal(it.getRestrictedDomain(), entity) && it.getRestrictedRelation().isIsFunctional()));
        };
        final Function1<EntityUniversalRestrictionAxiom, String> _function_5 = (EntityUniversalRestrictionAxiom it) -> {
          return this.toFirstLower(it.getRestrictedRange());
        };
        List<EntityUniversalRestrictionAxiom> _sortBy_2 = IterableExtensions.<EntityUniversalRestrictionAxiom, String>sortBy(IterableExtensions.<EntityUniversalRestrictionAxiom>filter(this.<EntityUniversalRestrictionAxiom>allTBoxStatementsOfType(EntityUniversalRestrictionAxiom.class), _function_4), _function_5);
        for(final EntityUniversalRestrictionAxiom axiom : _sortBy_2) {
          _builder.append("@OMLProvenance(kind=\"");
          String _name = axiom.eClass().getName();
          _builder.append(_name);
          _builder.append("\",restrictedDomain=\"");
          String _abbrevIRI = axiom.getRestrictedDomain().abbrevIRI();
          _builder.append(_abbrevIRI);
          _builder.append("\",restrictedRelation=\"");
          String _abbrevIRI_1 = axiom.getRestrictedRelation().abbrevIRI();
          _builder.append(_abbrevIRI_1);
          _builder.append("\",restrictedRange=\"");
          String _abbrevIRI_2 = axiom.getRestrictedRange().abbrevIRI();
          _builder.append(_abbrevIRI_2);
          _builder.append("\")");
          _builder.newLineIfNotEmpty();
          _builder.append("op ");
          String _imported_4 = this.imported(axiom.getRestrictedRange());
          _builder.append(_imported_4);
          _builder.append(" ");
          String _firstLower = this.toFirstLower(axiom.getRestrictedRange());
          _builder.append(_firstLower);
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("omlInverseReferencers(");
          String _imported_5 = this.imported(axiom.getRestrictedRelation());
          _builder.append(_imported_5, "\t");
          _builder.append(").filter[omlSource === this].map[omlTarget].findFirst[true] as ");
          String _imported_6 = this.imported(axiom.getRestrictedRange());
          _builder.append(_imported_6, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        final Function1<EntityUniversalRestrictionAxiom, Boolean> _function_6 = (EntityUniversalRestrictionAxiom it) -> {
          return Boolean.valueOf(((Objects.equal(it.getRestrictedRange(), entity) && (this.hasRelationshipInverse(it.getRestrictedRelation())).booleanValue()) && it.getRestrictedRelation().isIsInverseFunctional()));
        };
        final Function1<EntityUniversalRestrictionAxiom, String> _function_7 = (EntityUniversalRestrictionAxiom it) -> {
          return this.toFirstLower(it.getRestrictedDomain());
        };
        List<EntityUniversalRestrictionAxiom> _sortBy_3 = IterableExtensions.<EntityUniversalRestrictionAxiom, String>sortBy(IterableExtensions.<EntityUniversalRestrictionAxiom>filter(this.<EntityUniversalRestrictionAxiom>allTBoxStatementsOfType(EntityUniversalRestrictionAxiom.class), _function_6), _function_7);
        for(final EntityUniversalRestrictionAxiom axiom_1 : _sortBy_3) {
          _builder.append("@OMLProvenance(kind=\"");
          String _name_1 = axiom_1.eClass().getName();
          _builder.append(_name_1);
          _builder.append("\",restrictedDomain=\"");
          String _abbrevIRI_3 = axiom_1.getRestrictedDomain().abbrevIRI();
          _builder.append(_abbrevIRI_3);
          _builder.append("\",restrictedRelation=\"");
          String _abbrevIRI_4 = axiom_1.getRestrictedRelation().abbrevIRI();
          _builder.append(_abbrevIRI_4);
          _builder.append("\",restrictedRange=\"");
          String _abbrevIRI_5 = axiom_1.getRestrictedRange().abbrevIRI();
          _builder.append(_abbrevIRI_5);
          _builder.append("\")");
          _builder.newLineIfNotEmpty();
          _builder.append("op ");
          String _imported_7 = this.imported(axiom_1.getRestrictedDomain());
          _builder.append(_imported_7);
          _builder.append(" ");
          String _firstLower_1 = this.toFirstLower(axiom_1.getRestrictedDomain());
          _builder.append(_firstLower_1);
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("omlInverseReferencers(");
          String _imported_8 = this.imported(axiom_1.getRestrictedRelation());
          _builder.append(_imported_8, "\t");
          _builder.append(").filter[omlTarget === this].map[omlSource].findFirst[true] as ");
          String _imported_9 = this.imported(axiom_1.getRestrictedDomain());
          _builder.append(_imported_9, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      return _builder;
    }
    
    protected CharSequence convertToExtends(final Collection<String> types) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isEmpty = types.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("extends ");
          String _join = IterableExtensions.join(types, ", ");
          _builder.append(_join);
          _builder.append(" ");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
        }
      }
      return _builder;
    }
    
    protected Boolean hasRelationshipInverse(final EntityRelationship relationship) {
      boolean _switchResult = false;
      boolean _matched = false;
      if (relationship instanceof ReifiedRelationship) {
        _matched=true;
        String _unreifiedInversePropertyName = ((ReifiedRelationship)relationship).getUnreifiedInversePropertyName();
        _switchResult = (_unreifiedInversePropertyName != null);
      }
      if (!_matched) {
        _switchResult = false;
      }
      return Boolean.valueOf(_switchResult);
    }
    
    protected String sourceName(final ReifiedRelationship relationship) {
      String _switchResult = null;
      String _unreifiedInversePropertyName = relationship.getUnreifiedInversePropertyName();
      final String s = _unreifiedInversePropertyName;
      boolean _matched = false;
      if (Objects.equal(s, null)) {
        _matched=true;
        _switchResult = "";
      }
      if (!_matched) {
        int _length = s.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _matched=true;
          _switchResult = this.toFirstLower(s);
        }
      }
      if (!_matched) {
        _switchResult = s;
      }
      final String s_1 = _switchResult;
      String _xifexpression = null;
      boolean _contains = OMLGenerator.xCoreKeywords.contains(s_1);
      if (_contains) {
        _xifexpression = ("^" + s_1);
      } else {
        _xifexpression = s_1;
      }
      return _xifexpression;
    }
    
    protected String targetName(final ReifiedRelationship relationship) {
      String _switchResult = null;
      String _unreifiedPropertyName = relationship.getUnreifiedPropertyName();
      final String s = _unreifiedPropertyName;
      boolean _matched = false;
      if (Objects.equal(s, null)) {
        _matched=true;
        _switchResult = "";
      }
      if (!_matched) {
        int _length = s.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _matched=true;
          _switchResult = this.toFirstLower(s);
        }
      }
      if (!_matched) {
        _switchResult = s;
      }
      final String s_1 = _switchResult;
      String _xifexpression = null;
      boolean _contains = OMLGenerator.xCoreKeywords.contains(s_1);
      if (_contains) {
        _xifexpression = ("^" + s_1);
      } else {
        _xifexpression = s_1;
      }
      return _xifexpression;
    }
    
    protected String toFirstLower(final Term term) {
      String _switchResult = null;
      String _name = term.name();
      final String s = _name;
      boolean _matched = false;
      if (Objects.equal(s, null)) {
        _matched=true;
        _switchResult = "";
      }
      if (!_matched) {
        int _length = s.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _matched=true;
          _switchResult = this.toFirstLower(s);
        }
      }
      if (!_matched) {
        _switchResult = s;
      }
      final String s_1 = _switchResult;
      String _xifexpression = null;
      boolean _contains = OMLGenerator.xCoreKeywords.contains(s_1);
      if (_contains) {
        _xifexpression = ("^" + s_1);
      } else {
        _xifexpression = s_1;
      }
      return _xifexpression;
    }
    
    protected String qualifieddName(final Term term) {
      String _xblockexpression = null;
      {
        final String simpleName = term.name();
        final String packageQName = OMLGenerator.validQName(term.getTbox());
        _xblockexpression = ((packageQName + ".") + simpleName);
      }
      return _xblockexpression;
    }
    
    protected <T extends TerminologyBoxAxiom> Iterable<T> allTBoxAxiomsOfType(final Class<T> type) {
      final Function1<TerminologyBox, EList<TerminologyBoxAxiom>> _function = (TerminologyBox it) -> {
        return it.getBoxAxioms();
      };
      return Iterables.<T>filter(Iterables.<TerminologyBoxAxiom>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxAxiom>>map(this.terminologies, _function)), type);
    }
    
    protected <T extends TerminologyBoxStatement> Iterable<T> allTBoxStatementsOfType(final Class<T> type) {
      final Function1<TerminologyBox, EList<TerminologyBoxStatement>> _function = (TerminologyBox it) -> {
        return it.getBoxStatements();
      };
      return Iterables.<T>filter(Iterables.<TerminologyBoxStatement>concat(IterableExtensions.<TerminologyBox, EList<TerminologyBoxStatement>>map(this.terminologies, _function)), type);
    }
    
    public String toFirstUpper(final String s) {
      char _upperCase = Character.toUpperCase(s.charAt(0));
      String _substring = s.substring(1);
      return (Character.valueOf(_upperCase) + _substring);
    }
    
    public String toFirstLower(final String s) {
      char _lowerCase = Character.toLowerCase(s.charAt(0));
      String _substring = s.substring(1);
      return (Character.valueOf(_lowerCase) + _substring);
    }
    
    protected CharSequence convertToType(final Term range) {
      if (range instanceof BinaryScalarRestriction) {
        return _convertToType((BinaryScalarRestriction)range);
      } else if (range instanceof IRIScalarRestriction) {
        return _convertToType((IRIScalarRestriction)range);
      } else if (range instanceof NumericScalarRestriction) {
        return _convertToType((NumericScalarRestriction)range);
      } else if (range instanceof PlainLiteralScalarRestriction) {
        return _convertToType((PlainLiteralScalarRestriction)range);
      } else if (range instanceof ScalarOneOfRestriction) {
        return _convertToType((ScalarOneOfRestriction)range);
      } else if (range instanceof StringScalarRestriction) {
        return _convertToType((StringScalarRestriction)range);
      } else if (range instanceof SynonymScalarRestriction) {
        return _convertToType((SynonymScalarRestriction)range);
      } else if (range instanceof TimeScalarRestriction) {
        return _convertToType((TimeScalarRestriction)range);
      } else if (range instanceof Scalar) {
        return _convertToType((Scalar)range);
      } else if (range instanceof Aspect) {
        return _convertToType((Aspect)range);
      } else if (range instanceof Concept) {
        return _convertToType((Concept)range);
      } else if (range instanceof ReifiedRelationship) {
        return _convertToType((ReifiedRelationship)range);
      } else if (range instanceof Structure) {
        return _convertToType((Structure)range);
      } else if (range instanceof DataRelationship) {
        return _convertToType((DataRelationship)range);
      } else if (range != null) {
        return _convertToType(range);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(range).toString());
      }
    }
    
    protected CharSequence extendedTypes(final Entity aspect) {
      if (aspect instanceof Aspect) {
        return _extendedTypes((Aspect)aspect);
      } else if (aspect instanceof Concept) {
        return _extendedTypes((Concept)aspect);
      } else if (aspect instanceof ReifiedRelationship) {
        return _extendedTypes((ReifiedRelationship)aspect);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(aspect).toString());
      }
    }
    
    protected CharSequence dataProperties(final Term structure) {
      if (structure instanceof Structure) {
        return _dataProperties((Structure)structure);
      } else if (structure instanceof Entity) {
        return _dataProperties((Entity)structure);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(structure).toString());
      }
    }
  }
  
  @Inject
  @Extension
  private OMLExtensions _oMLExtensions;
  
  private final static ArrayList<String> xCoreKeywords = CollectionLiterals.<String>newArrayList("refers", "contains", "extends", "imports", "id");
  
  protected Bundle omlBundle;
  
  protected IProject ecoreProjectHandle;
  
  protected IProject editProjectHandle;
  
  protected IProject uiProjectHandle;
  
  protected String dsmlName;
  
  public void setEcoreProjectHandle(final IProject ecoreProjectHandle) {
    this.ecoreProjectHandle = ecoreProjectHandle;
  }
  
  public void setEditProjectHandle(final IProject editProjectHandle) {
    this.editProjectHandle = editProjectHandle;
  }
  
  public void setUIProjectHandle(final IProject uiProjectHandle) {
    this.uiProjectHandle = uiProjectHandle;
  }
  
  public void setDSMLName(final String dsmlName) {
    this.dsmlName = dsmlName;
  }
  
  public Bundle getBundle() {
    return this.omlBundle;
  }
  
  @Override
  public void afterGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    super.afterGenerate(input, fsa, context);
    this.omlBundle = null;
    this.ecoreProjectHandle = null;
    this.editProjectHandle = null;
    this.uiProjectHandle = null;
  }
  
  @Override
  public void beforeGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    super.beforeGenerate(input, fsa, context);
    EcoreUtil2.resolveAll(input);
    final ResourceSet rs = input.getResourceSet();
    final Function1<Resource, EList<Resource.Diagnostic>> _function = (Resource it) -> {
      return it.getErrors();
    };
    final Iterable<Resource.Diagnostic> errors = Iterables.<Resource.Diagnostic>concat(ListExtensions.<Resource, EList<Resource.Diagnostic>>map(rs.getResources(), _function));
    boolean _isEmpty = IterableExtensions.isEmpty(errors);
    boolean _not = (!_isEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      int _size = IterableExtensions.size(errors);
      _builder.append(_size);
      _builder.append(" errors: ");
      _builder.newLineIfNotEmpty();
      {
        for(final Resource.Diagnostic e : errors) {
          String _location = e.getLocation();
          _builder.append(_location);
          _builder.append(" line: ");
          int _line = e.getLine();
          _builder.append(_line);
          _builder.append(", column: ");
          int _column = e.getColumn();
          _builder.append(_column);
          _builder.append(" ");
          String _message = e.getMessage();
          _builder.append(_message);
          _builder.newLineIfNotEmpty();
        }
      }
      final String message = _builder.toString();
      throw new IllegalArgumentException(message);
    }
    final Function1<Resource, EList<Resource.Diagnostic>> _function_1 = (Resource it) -> {
      return it.getWarnings();
    };
    final Iterable<Resource.Diagnostic> warnings = Iterables.<Resource.Diagnostic>concat(ListExtensions.<Resource, EList<Resource.Diagnostic>>map(rs.getResources(), _function_1));
    boolean _isEmpty_1 = IterableExtensions.isEmpty(warnings);
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      int _size_1 = IterableExtensions.size(warnings);
      _builder_1.append(_size_1);
      _builder_1.append(" warnings: ");
      _builder_1.newLineIfNotEmpty();
      {
        for(final Resource.Diagnostic w : warnings) {
          String _location_1 = w.getLocation();
          _builder_1.append(_location_1);
          _builder_1.append(" line: ");
          int _line_1 = w.getLine();
          _builder_1.append(_line_1);
          _builder_1.append(", column: ");
          int _column_1 = w.getColumn();
          _builder_1.append(_column_1);
          _builder_1.append(" ");
          String _message_1 = w.getMessage();
          _builder_1.append(_message_1);
          _builder_1.newLineIfNotEmpty();
        }
      }
      final String message_1 = _builder_1.toString();
      throw new IllegalArgumentException(message_1);
    }
    final Function1<Resource, Boolean> _function_2 = (Resource it) -> {
      boolean _isLoaded = it.isLoaded();
      return Boolean.valueOf((!_isLoaded));
    };
    final Iterable<Resource> missing = IterableExtensions.<Resource>filter(rs.getResources(), _function_2);
    boolean _isEmpty_2 = IterableExtensions.isEmpty(missing);
    boolean _not_2 = (!_isEmpty_2);
    if (_not_2) {
      StringConcatenation _builder_2 = new StringConcatenation();
      int _size_2 = IterableExtensions.size(missing);
      _builder_2.append(_size_2);
      _builder_2.append(" missing resources: ");
      _builder_2.newLineIfNotEmpty();
      {
        for(final Resource m : missing) {
          URI _uRI = m.getURI();
          _builder_2.append(_uRI);
          _builder_2.newLineIfNotEmpty();
        }
      }
      final String message_2 = _builder_2.toString();
      throw new IllegalArgumentException(message_2);
    }
    EObject _get = input.getContents().get(0);
    final EObject top = _get;
    boolean _matched = false;
    if (top instanceof Extent) {
      _matched=true;
      final Iterable<Bundle> bundles = Iterables.<Bundle>filter(((Extent)top).getModules(), Bundle.class);
      int _size_3 = IterableExtensions.size(bundles);
      boolean _notEquals = (_size_3 != 1);
      if (_notEquals) {
        throw new IllegalArgumentException(("There should be exactly 1 Bundle in " + input));
      }
      this.omlBundle = ((Bundle[])Conversions.unwrapArray(bundles, Bundle.class))[0];
    }
    if (!_matched) {
      throw new IllegalArgumentException(("There should be exactly 1 Bundle in " + input));
    }
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    boolean _isEmpty = resource.getContents().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EObject _get = resource.getContents().get(0);
      final EObject top = _get;
      boolean _matched = false;
      if (top instanceof Extent) {
        _matched=true;
        final Iterable<Bundle> bundles = Iterables.<Bundle>filter(((Extent)top).getModules(), Bundle.class);
        for (final Bundle bundle : bundles) {
          {
            final HashSet<TerminologyBox> allTboxes = new HashSet<TerminologyBox>();
            Iterables.<TerminologyBox>addAll(allTboxes, this._oMLExtensions.allImportedTerminologies(bundle));
            final Function1<Bundle, Iterable<TerminologyBox>> _function = (Bundle it) -> {
              return this._oMLExtensions.allImportedTerminologies(it);
            };
            Iterables.<TerminologyBox>addAll(allTboxes, Iterables.<TerminologyBox>concat(IterableExtensions.<Bundle, Iterable<TerminologyBox>>map(this._oMLExtensions.allImportedBundles(bundle), _function)));
            for (final TerminologyBox terminology : allTboxes) {
              {
                String _validQName = OMLGenerator.validQName(terminology);
                final String filename = (_validQName + ".xcore");
                final CharSequence contents = new OMLGenerator.TerminologyToXcoreGenerator(this, allTboxes, terminology, this.dsmlName).doGenerate();
                fsa.generateFile(filename, contents);
              }
            }
          }
        }
      }
      if (!_matched) {
      }
    }
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
        String _xifexpression = null;
        boolean _contains = OMLGenerator.xCoreKeywords.contains(valid);
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
        boolean _contains = OMLGenerator.xCoreKeywords.contains(valid);
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
  
  protected static String _validName(final Term type) {
    String _switchResult = null;
    String _name = type.name();
    final String s = _name;
    boolean _matched = false;
    if (Objects.equal(s, null)) {
      _matched=true;
      _switchResult = "";
    }
    if (!_matched) {
      _switchResult = StringExtensions.toFirstUpper(s);
    }
    return _switchResult;
  }
  
  protected static String _validName(final TerminologyBox terminology) {
    return OMLGenerator.legalName(terminology.name());
  }
  
  protected static String validQName(final TerminologyBox t) {
    String _xblockexpression = null;
    {
      final String uri = OMLExtensions.getModuleNsURI(t);
      final String qname = OMLExtensions.convertIRItoNamespace(uri);
      _xblockexpression = qname;
    }
    return _xblockexpression;
  }
  
  protected static String legalName(final String name) {
    String _xblockexpression = null;
    {
      String valid = name;
      int _length = valid.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        valid = valid.replaceAll("[ -]", "_");
      }
      boolean _matches = valid.matches("^[0-9].*");
      if (_matches) {
        valid = ("_" + valid);
      }
      _xblockexpression = valid;
    }
    return _xblockexpression;
  }
  
  protected static String validName(final CDOObject dr) {
    if (dr instanceof UnreifiedRelationship) {
      return _validName((UnreifiedRelationship)dr);
    } else if (dr instanceof DataRelationship) {
      return _validName((DataRelationship)dr);
    } else if (dr instanceof Term) {
      return _validName((Term)dr);
    } else if (dr instanceof TerminologyBox) {
      return _validName((TerminologyBox)dr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dr).toString());
    }
  }
}
