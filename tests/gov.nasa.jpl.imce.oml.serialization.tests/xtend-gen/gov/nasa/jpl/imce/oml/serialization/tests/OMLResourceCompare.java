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
package gov.nasa.jpl.imce.oml.serialization.tests;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind;
import gov.nasa.jpl.imce.oml.model.common.LiteralBoolean;
import gov.nasa.jpl.imce.oml.model.common.LiteralDateTime;
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal;
import gov.nasa.jpl.imce.oml.model.common.LiteralFloat;
import gov.nasa.jpl.imce.oml.model.common.LiteralNumber;
import gov.nasa.jpl.imce.oml.model.common.LiteralRational;
import gov.nasa.jpl.imce.oml.model.common.LiteralReal;
import gov.nasa.jpl.imce.oml.model.common.LiteralString;
import gov.nasa.jpl.imce.oml.model.common.LiteralURI;
import gov.nasa.jpl.imce.oml.model.common.LiteralUUID;
import gov.nasa.jpl.imce.oml.model.common.LiteralValue;
import gov.nasa.jpl.imce.oml.model.datatypes.DateTimeValue;
import gov.nasa.jpl.imce.oml.model.datatypes.URIValue;
import gov.nasa.jpl.imce.oml.model.datatypes.UUIDValue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Reflection-based OML Resource Comparison.
 */
@SuppressWarnings("all")
public class OMLResourceCompare {
  /**
   * Returns the EClass that is the type of an ETypedElement or null.
   */
  public static EClass EClassType(final ETypedElement f) {
    EClass _xblockexpression = null;
    {
      final EClassifier c = f.getEType();
      EClass _switchResult = null;
      boolean _matched = false;
      if (c instanceof EClass) {
        _matched=true;
        _switchResult = ((EClass)c);
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  /**
   * Structural comparison of the contents of two OMLZipResources.
   */
  public static void resourceCompare(final Resource r1, final Resource r2) throws IllegalArgumentException {
    int _size = r1.getContents().size();
    boolean _notEquals = (1 != _size);
    if (_notEquals) {
      int _size_1 = r1.getContents().size();
      String _plus = ("resourceCompare(r1 has " + Integer.valueOf(_size_1));
      String _plus_1 = (_plus + " toplevel elements (there should be 1)");
      throw new IllegalArgumentException(_plus_1);
    }
    final EObject top1 = r1.getContents().get(0);
    int _size_2 = r2.getContents().size();
    boolean _notEquals_1 = (1 != _size_2);
    if (_notEquals_1) {
      int _size_3 = r2.getContents().size();
      String _plus_2 = ("resourceCompare(r2 has " + Integer.valueOf(_size_3));
      String _plus_3 = (_plus_2 + " toplevel elements (there should be 1)");
      throw new IllegalArgumentException(_plus_3);
    }
    final EObject top2 = r2.getContents().get(0);
    OMLResourceCompare.compare("/", top1, top2);
  }
  
  /**
   * Compare two EObjects in terms of their EAttribute values and their EReference collections,
   * making sure that they have the same EAttributes & EReferences.
   */
  protected static void compare(final String path, final EObject e1, final EObject e2) throws IllegalArgumentException {
    final EClass ec1 = e1.eClass();
    final EClass ec2 = e2.eClass();
    boolean _notEquals = (!Objects.equal(ec1, ec2));
    if (_notEquals) {
      String _name = ec1.getName();
      String _plus = ((("compare(" + path) + ") different metaclasses: ") + _name);
      String _plus_1 = (_plus + " vs. ");
      String _name_1 = ec2.getName();
      String _plus_2 = (_plus_1 + _name_1);
      throw new IllegalArgumentException(_plus_2);
    }
    final Consumer<EAttribute> _function = (EAttribute attr) -> {
      String _name_2 = attr.getName();
      final String loc = ((path + "@") + _name_2);
      System.out.println(("... " + loc));
      final Object v1 = e1.eGet(attr);
      final Object v2 = e2.eGet(attr);
      boolean _notEquals_1 = (!Objects.equal(v1, v2));
      if (_notEquals_1) {
        throw new IllegalArgumentException(((((("compare(" + loc) + ") different attribute values: ") + v1) + " vs. ") + v2));
      }
    };
    ec1.getEAllAttributes().forEach(_function);
    final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
      return Boolean.valueOf((it.isContainment() || (null == it.getEOpposite())));
    };
    final Consumer<EReference> _function_2 = (EReference f) -> {
      String _name_2 = f.getName();
      final String loc = ((path + "/") + _name_2);
      final EClass t = OMLResourceCompare.EClassType(f);
      final Object v1 = e1.eGet(f);
      final Object v2 = e2.eGet(f);
      if (((null == v1) && (null == v2))) {
        return;
      } else {
        if (((null != v1) && (null == v2))) {
          throw new IllegalArgumentException((("compareReferences(" + path) + ") non-null vs. null"));
        } else {
          if (((null == v1) && (null != v2))) {
            throw new IllegalArgumentException((("compareReferences(" + path) + ") null vs. non-null"));
          } else {
            OMLResourceCompare.compareReferences(loc, f, t, e1, v1, e2, v2);
          }
        }
      }
    };
    IterableExtensions.<EReference>filter(Iterables.<EReference>filter(ec1.getEAllStructuralFeatures(), EReference.class), _function_1).forEach(_function_2);
  }
  
  /**
   * Reference comparison is undefined for arbitrary EObjects that are not OML CrossReferencabilityKinds.
   */
  protected static void _compareReferences(final String path, final EReference f, final EClass t, final EObject e1, final Object v1, final EObject e2, final Object v2) throws IllegalArgumentException {
    String _name = f.getName();
    String _plus = ((("compareReferences(" + path) + ") unhandled case for \'") + _name);
    String _plus_1 = (_plus + ": ");
    String _name_1 = t.getName();
    String _plus_2 = (_plus_1 + _name_1);
    throw new IllegalArgumentException(_plus_2);
  }
  
  protected static void _compareReferences(final String path, final EReference f, final EClass t, final EObject e1, final LiteralNumber v1, final EObject e2, final LiteralNumber v2) throws IllegalArgumentException {
    boolean _matched = false;
    if (v1 instanceof LiteralDecimal) {
      _matched=true;
      boolean _matched_1 = false;
      if (v2 instanceof LiteralDecimal) {
        _matched_1=true;
        boolean _notEquals = (!Objects.equal(((LiteralDecimal)v1).getDecimal().value, ((LiteralDecimal)v2).getDecimal().value));
        if (_notEquals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralDecimal value mismatch \'");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (");
          _builder.append(((LiteralDecimal)v1).getDecimal().value);
          _builder.append(" vs. ");
          _builder.append(((LiteralDecimal)v2).getDecimal().value);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
      if (!_matched_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("compareReferences(");
        _builder.append(path);
        _builder.append(") LiteralDecimal type mismatch ");
        String _name = f.getName();
        _builder.append(_name);
        _builder.append(": ");
        String _name_1 = t.getName();
        _builder.append(_name_1);
        _builder.append(" (mismatch with: ");
        _builder.append(v2);
        _builder.append(")");
        throw new IllegalArgumentException(_builder.toString());
      }
    }
    if (!_matched) {
      if (v1 instanceof LiteralFloat) {
        _matched=true;
        boolean _matched_1 = false;
        if (v2 instanceof LiteralFloat) {
          _matched_1=true;
          boolean _notEquals = (!Objects.equal(((LiteralFloat)v1).getFloat().value, ((LiteralFloat)v2).getFloat().value));
          if (_notEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("compareReferences(");
            _builder.append(path);
            _builder.append(") LiteralFloat value mismatch \'");
            String _name = f.getName();
            _builder.append(_name);
            _builder.append(": ");
            String _name_1 = t.getName();
            _builder.append(_name_1);
            _builder.append(" (");
            _builder.append(((LiteralFloat)v1).getFloat().value);
            _builder.append(" vs. ");
            _builder.append(((LiteralFloat)v2).getFloat().value);
            _builder.append(")");
            throw new IllegalArgumentException(_builder.toString());
          }
        }
        if (!_matched_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralFloat type mismatch ");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (mismatch with: ");
          _builder.append(v2);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
    }
    if (!_matched) {
      if (v1 instanceof LiteralRational) {
        _matched=true;
        boolean _matched_1 = false;
        if (v2 instanceof LiteralRational) {
          _matched_1=true;
          boolean _notEquals = (!Objects.equal(((LiteralRational)v1).getRational().value, ((LiteralRational)v2).getRational().value));
          if (_notEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("compareReferences(");
            _builder.append(path);
            _builder.append(") LiteralRational value mismatch \'");
            String _name = f.getName();
            _builder.append(_name);
            _builder.append(": ");
            String _name_1 = t.getName();
            _builder.append(_name_1);
            _builder.append(" (");
            _builder.append(((LiteralRational)v1).getRational().value);
            _builder.append(" vs. ");
            _builder.append(((LiteralRational)v2).getRational().value);
            _builder.append(")");
            throw new IllegalArgumentException(_builder.toString());
          }
        }
        if (!_matched_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralRational type mismatch ");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (mismatch with: ");
          _builder.append(v2);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
    }
    if (!_matched) {
      if (v1 instanceof LiteralReal) {
        _matched=true;
        boolean _matched_1 = false;
        if (v2 instanceof LiteralReal) {
          _matched_1=true;
          boolean _notEquals = (!Objects.equal(((LiteralReal)v1).getReal().value, ((LiteralReal)v2).getReal().value));
          if (_notEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("compareReferences(");
            _builder.append(path);
            _builder.append(") LiteralReal value mismatch \'");
            String _name = f.getName();
            _builder.append(_name);
            _builder.append(": ");
            String _name_1 = t.getName();
            _builder.append(_name_1);
            _builder.append(" (");
            _builder.append(((LiteralReal)v1).getReal().value);
            _builder.append(" vs. ");
            _builder.append(((LiteralReal)v2).getReal().value);
            _builder.append(")");
            throw new IllegalArgumentException(_builder.toString());
          }
        }
        if (!_matched_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralReal type mismatch ");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (mismatch with: ");
          _builder.append(v2);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
    }
  }
  
  protected static void _compareReferences(final String path, final EReference f, final EClass t, final EObject e1, final LiteralValue v1, final EObject e2, final LiteralValue v2) throws IllegalArgumentException {
    boolean _matched = false;
    if (v1 instanceof LiteralBoolean) {
      _matched=true;
      boolean _matched_1 = false;
      if (v2 instanceof LiteralBoolean) {
        _matched_1=true;
        boolean _isBool = ((LiteralBoolean)v1).isBool();
        boolean _isBool_1 = ((LiteralBoolean)v2).isBool();
        boolean _notEquals = (_isBool != _isBool_1);
        if (_notEquals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralBoolean value mismatch \'");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (");
          boolean _isBool_2 = ((LiteralBoolean)v1).isBool();
          _builder.append(_isBool_2);
          _builder.append(" vs. ");
          boolean _isBool_3 = ((LiteralBoolean)v2).isBool();
          _builder.append(_isBool_3);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
      if (!_matched_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("compareReferences(");
        _builder.append(path);
        _builder.append(") LiteralBoolean type mismatch ");
        String _name = f.getName();
        _builder.append(_name);
        _builder.append(": ");
        String _name_1 = t.getName();
        _builder.append(_name_1);
        _builder.append(" (mismatch with: ");
        _builder.append(v2);
        _builder.append(")");
        throw new IllegalArgumentException(_builder.toString());
      }
    }
    if (!_matched) {
      if (v1 instanceof LiteralDateTime) {
        _matched=true;
        boolean _matched_1 = false;
        if (v2 instanceof LiteralDateTime) {
          _matched_1=true;
          DateTimeValue _dateTime = ((LiteralDateTime)v1).getDateTime();
          DateTimeValue _dateTime_1 = ((LiteralDateTime)v2).getDateTime();
          boolean _notEquals = (!Objects.equal(_dateTime, _dateTime_1));
          if (_notEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("compareReferences(");
            _builder.append(path);
            _builder.append(") LiteralDateTime value mismatch \'");
            String _name = f.getName();
            _builder.append(_name);
            _builder.append(": ");
            String _name_1 = t.getName();
            _builder.append(_name_1);
            _builder.append(" (");
            DateTimeValue _dateTime_2 = ((LiteralDateTime)v1).getDateTime();
            _builder.append(_dateTime_2);
            _builder.append(" vs. ");
            DateTimeValue _dateTime_3 = ((LiteralDateTime)v2).getDateTime();
            _builder.append(_dateTime_3);
            _builder.append(")");
            throw new IllegalArgumentException(_builder.toString());
          }
        }
        if (!_matched_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralBoolean type mismatch ");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (mismatch with: ");
          _builder.append(v2);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
    }
    if (!_matched) {
      if (v1 instanceof LiteralString) {
        _matched=true;
        boolean _matched_1 = false;
        if (v2 instanceof LiteralString) {
          _matched_1=true;
          String _value = ((LiteralString)v1).value();
          String _value_1 = ((LiteralString)v2).value();
          boolean _notEquals = (!Objects.equal(_value, _value_1));
          if (_notEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("compareReferences(");
            _builder.append(path);
            _builder.append(") LiteralString value mismatch \'");
            String _name = f.getName();
            _builder.append(_name);
            _builder.append(": ");
            String _name_1 = t.getName();
            _builder.append(_name_1);
            _builder.append(" (");
            String _value_2 = ((LiteralString)v1).value();
            _builder.append(_value_2);
            _builder.append(" vs. ");
            String _value_3 = ((LiteralString)v2).value();
            _builder.append(_value_3);
            _builder.append(")");
            throw new IllegalArgumentException(_builder.toString());
          }
        }
        if (!_matched_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralString type mismatch ");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (mismatch with: ");
          _builder.append(v2);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
    }
    if (!_matched) {
      if (v1 instanceof LiteralURI) {
        _matched=true;
        boolean _matched_1 = false;
        if (v2 instanceof LiteralURI) {
          _matched_1=true;
          URIValue _uri = ((LiteralURI)v1).getUri();
          URIValue _uri_1 = ((LiteralURI)v2).getUri();
          boolean _notEquals = (!Objects.equal(_uri, _uri_1));
          if (_notEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("compareReferences(");
            _builder.append(path);
            _builder.append(") LiteralURI value mismatch \'");
            String _name = f.getName();
            _builder.append(_name);
            _builder.append(": ");
            String _name_1 = t.getName();
            _builder.append(_name_1);
            _builder.append(" (");
            URIValue _uri_2 = ((LiteralURI)v1).getUri();
            _builder.append(_uri_2);
            _builder.append(" vs. ");
            URIValue _uri_3 = ((LiteralURI)v2).getUri();
            _builder.append(_uri_3);
            _builder.append(")");
            throw new IllegalArgumentException(_builder.toString());
          }
        }
        if (!_matched_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralURI type mismatch ");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (mismatch with: ");
          _builder.append(v2);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
    }
    if (!_matched) {
      if (v1 instanceof LiteralUUID) {
        _matched=true;
        boolean _matched_1 = false;
        if (v2 instanceof LiteralUUID) {
          _matched_1=true;
          UUIDValue _uuid = ((LiteralUUID)v1).getUuid();
          UUIDValue _uuid_1 = ((LiteralUUID)v2).getUuid();
          boolean _notEquals = (!Objects.equal(_uuid, _uuid_1));
          if (_notEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("compareReferences(");
            _builder.append(path);
            _builder.append(") LiteralUUID value mismatch \'");
            String _name = f.getName();
            _builder.append(_name);
            _builder.append(": ");
            String _name_1 = t.getName();
            _builder.append(_name_1);
            _builder.append(" (");
            UUIDValue _uuid_2 = ((LiteralUUID)v1).getUuid();
            _builder.append(_uuid_2);
            _builder.append(" vs. ");
            UUIDValue _uuid_3 = ((LiteralUUID)v2).getUuid();
            _builder.append(_uuid_3);
            _builder.append(")");
            throw new IllegalArgumentException(_builder.toString());
          }
        }
        if (!_matched_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralUUID type mismatch ");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (mismatch with: ");
          _builder.append(v2);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
    }
    if (!_matched) {
      if (v1 instanceof LiteralNumber) {
        _matched=true;
        boolean _matched_1 = false;
        if (v2 instanceof LiteralNumber) {
          _matched_1=true;
          OMLResourceCompare.compareReferences(path, f, t, e1, v1, e2, v2);
        }
        if (!_matched_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("compareReferences(");
          _builder.append(path);
          _builder.append(") LiteralNumber type mismatch ");
          String _name = f.getName();
          _builder.append(_name);
          _builder.append(": ");
          String _name_1 = t.getName();
          _builder.append(_name_1);
          _builder.append(" (mismatch with: ");
          _builder.append(v2);
          _builder.append(")");
          throw new IllegalArgumentException(_builder.toString());
        }
      }
    }
  }
  
  /**
   * Reference comparison for OML CrossReferencabilityKinds.
   */
  protected static void _compareReferences(final String path, final EReference f, final EClass t, final EObject e1, final CrossReferencabilityKind v1, final EObject e2, final CrossReferencabilityKind v2) throws IllegalArgumentException {
    final String uuid1 = v1.uuid();
    final String uuid2 = v2.uuid();
    boolean _notEquals = (!Objects.equal(uuid1, uuid2));
    if (_notEquals) {
      throw new IllegalArgumentException(((((("compareReferences(" + path) + ") uuid mismatch:") + uuid1) + " vs ") + uuid2));
    }
    OMLResourceCompare.compare(path, v1, v2);
  }
  
  /**
   * Reference comparison for collections of OML CrossReferencabilityKinds.
   */
  protected static void _compareReferences(final String path, final EReference f, final EClass t, final EObject e1, final EList<CrossReferencabilityKind> v1, final EObject e2, final EList<CrossReferencabilityKind> v2) throws IllegalArgumentException {
    final int n1 = v1.size();
    final int n2 = v2.size();
    if ((n1 != n2)) {
      throw new IllegalArgumentException(((((("compareReferences(" + path) + ") collection size mismatch: ") + Integer.valueOf(n1)) + " vs ") + Integer.valueOf(n2)));
    }
    final Map<String, CrossReferencabilityKind> v1Map = new HashMap<String, CrossReferencabilityKind>();
    final Consumer<CrossReferencabilityKind> _function = (CrossReferencabilityKind u1) -> {
      final String uuid = u1.uuid();
      if ((null == uuid)) {
        throw new IllegalArgumentException(((("compareReferences(" + path) + ") left null uuid: ") + u1));
      }
      final CrossReferencabilityKind old = v1Map.put(uuid, u1);
      if ((null != old)) {
        throw new IllegalArgumentException(((((("compareReferences(" + path) + ") left uuid conflict: ") + old) + " vs ") + u1));
      }
    };
    v1.forEach(_function);
    final Map<String, CrossReferencabilityKind> v2Map = new HashMap<String, CrossReferencabilityKind>();
    final Consumer<CrossReferencabilityKind> _function_1 = (CrossReferencabilityKind u2) -> {
      final String uuid = u2.uuid();
      if ((null == uuid)) {
        throw new IllegalArgumentException(((("compareReferences(" + path) + ") right null uuid: ") + u2));
      }
      final CrossReferencabilityKind old = v2Map.put(uuid, u2);
      if ((null != old)) {
        throw new IllegalArgumentException(((((("compareReferences(" + path) + ") right uuid conflict: ") + old) + " vs ") + u2));
      }
    };
    v2.forEach(_function_1);
    final BiConsumer<String, CrossReferencabilityKind> _function_2 = (String uuid, CrossReferencabilityKind u1) -> {
      final CrossReferencabilityKind u2 = v2Map.get(uuid);
      if ((null == u2)) {
        throw new IllegalArgumentException((((("compareReferences(" + path) + ") collection mismatch: ") + uuid) + " vs N/A"));
      }
      OMLResourceCompare.compare((((path + "[") + uuid) + "]"), u1, u2);
    };
    v1Map.forEach(_function_2);
  }
  
  protected static void compareReferences(final String path, final EReference f, final EClass t, final EObject e1, final Object v1, final EObject e2, final Object v2) throws IllegalArgumentException {
    if (v1 instanceof LiteralNumber
         && v2 instanceof LiteralNumber) {
      _compareReferences(path, f, t, e1, (LiteralNumber)v1, e2, (LiteralNumber)v2);
      return;
    } else if (v1 instanceof EList
         && v2 instanceof EList) {
      _compareReferences(path, f, t, e1, (EList<CrossReferencabilityKind>)v1, e2, (EList<CrossReferencabilityKind>)v2);
      return;
    } else if (v1 instanceof CrossReferencabilityKind
         && v2 instanceof CrossReferencabilityKind) {
      _compareReferences(path, f, t, e1, (CrossReferencabilityKind)v1, e2, (CrossReferencabilityKind)v2);
      return;
    } else if (v1 instanceof LiteralValue
         && v2 instanceof LiteralValue) {
      _compareReferences(path, f, t, e1, (LiteralValue)v1, e2, (LiteralValue)v2);
      return;
    } else if (v1 != null
         && v2 != null) {
      _compareReferences(path, f, t, e1, v1, e2, v2);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(path, f, t, e1, v1, e2, v2).toString());
    }
  }
}
