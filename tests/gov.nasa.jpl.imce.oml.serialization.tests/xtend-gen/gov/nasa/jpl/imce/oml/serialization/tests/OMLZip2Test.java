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
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LiteralRawString;
import gov.nasa.jpl.imce.oml.model.datatypes.RawStringValue;
import gov.nasa.jpl.imce.oml.model.extensions.OMLTables;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction;
import gov.nasa.jpl.imce.oml.serialization.tests.OMLSaveLoadComparisonTest;
import gov.nasa.jpl.imce.oml.zip.OMLZipResource;
import java.util.regex.Matcher;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
@SuppressWarnings("all")
public class OMLZip2Test extends OMLSaveLoadComparisonTest {
  public static Pair<URI, Extent>[] example1() {
    final Extent extent = OMLSaveLoadComparisonTest._commonFactory.createExtent();
    final TerminologyGraph tbox1 = OMLSaveLoadComparisonTest._graphsFactory.createTerminologyGraph();
    tbox1.setExtent(extent);
    tbox1.setIri("http://test");
    final Scalar s1 = OMLSaveLoadComparisonTest._terminologiesFactory.createScalar();
    s1.setTbox(tbox1);
    s1.setName("string");
    final ScalarOneOfRestriction s2 = OMLSaveLoadComparisonTest._terminologiesFactory.createScalarOneOfRestriction();
    s2.setTbox(tbox1);
    s2.setName("OnOff");
    s2.setRestrictedRange(s1);
    final ScalarOneOfLiteralAxiom on = OMLSaveLoadComparisonTest._terminologiesFactory.createScalarOneOfLiteralAxiom();
    on.setTbox(tbox1);
    on.setAxiom(s2);
    on.setValueType(s2);
    final LiteralRawString onValue = OMLSaveLoadComparisonTest._commonFactory.createLiteralRawString();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("on,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"on\",");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("true");
    RawStringValue _rawStringValue = new RawStringValue(_builder.toString());
    onValue.setString(_rawStringValue);
    on.setValue(onValue);
    final ScalarOneOfLiteralAxiom off = OMLSaveLoadComparisonTest._terminologiesFactory.createScalarOneOfLiteralAxiom();
    off.setTbox(tbox1);
    off.setAxiom(s2);
    off.setValueType(s2);
    final LiteralRawString offValue = OMLSaveLoadComparisonTest._commonFactory.createLiteralRawString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.newLine();
    _builder_1.append("This is \"on\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Ceci est \"true\"");
    _builder_1.newLine();
    RawStringValue _rawStringValue_1 = new RawStringValue(_builder_1.toString());
    offValue.setString(_rawStringValue_1);
    off.setValue(offValue);
    URI _createURI = URI.createURI(tbox1.iri());
    Pair<URI, Extent> _pair = new Pair<URI, Extent>(_createURI, extent);
    return new Pair[] { _pair };
  }
  
  @Test
  public void test1() {
    this.compareSavedAndLoaded(OMLZip2Test.example1());
  }
  
  public String array(final String s) {
    String _xblockexpression = null;
    {
      InputOutput.println();
      InputOutput.<String>println(s);
      int pass = 1;
      final Matcher a = OMLTables.StringArray.matcher(s);
      InputOutput.<String>println(("match? " + a));
      final StringBuffer buffer = new StringBuffer();
      while (a.find()) {
        {
          final String part = a.group(1);
          StringConcatenation _builder = new StringConcatenation();
          int _plusPlus = pass++;
          _builder.append(_plusPlus);
          _builder.append(": \"");
          _builder.append(part);
          _builder.append("\"");
          InputOutput.<String>println(_builder.toString());
          boolean _equals = Objects.equal("\\\\n", part);
          if (_equals) {
            buffer.append(OMLTables.NEWLINE);
          } else {
            boolean _equals_1 = Objects.equal("\\\\r", part);
            if (_equals_1) {
              buffer.append(OMLTables.LINEFEED);
            } else {
              boolean _equals_2 = Objects.equal("\\\"", part);
              if (_equals_2) {
                buffer.append(OMLTables.QUOTE);
              } else {
                buffer.append(part);
              }
            }
          }
        }
      }
      _xblockexpression = InputOutput.<String>println(buffer.toString());
    }
    return _xblockexpression;
  }
  
  public void value(final String s) {
    InputOutput.println();
    InputOutput.<String>println(s);
    int pass = 1;
    final Matcher m = OMLTables.LiteralNumberOrValue.matcher(s);
    InputOutput.<String>println(("match? " + m));
    while (m.find()) {
      {
        InputOutput.<String>println(("pass: " + Integer.valueOf(pass)));
        InputOutput.<Integer>println(Integer.valueOf(m.groupCount()));
        for (int i = 1; (i <= m.groupCount()); i++) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(i);
          _builder.append(": ");
          String _group = m.group(i);
          _builder.append(_group);
          InputOutput.<String>println(_builder.toString());
        }
      }
    }
  }
  
  public void show(final String s) {
    InputOutput.println();
    InputOutput.<String>println(s);
    int pass = 1;
    final Matcher m = OMLZipResource.KeyValue.matcher(s);
    InputOutput.<String>println(("match? " + m));
    while (m.find()) {
      {
        InputOutput.<String>println(("pass: " + Integer.valueOf(pass)));
        InputOutput.<Integer>println(Integer.valueOf(m.groupCount()));
        for (int i = 1; (i <= m.groupCount()); i++) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(i);
          _builder.append(": ");
          String _group = m.group(i);
          _builder.append(_group);
          InputOutput.<String>println(_builder.toString());
        }
      }
    }
  }
  
  @Test
  public void test2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"value\":[\"\\n\"]");
    this.show(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\"value\":[\"\\\\n\"]");
    this.show(_builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"value\":[\"\\n\",\"This is \",\"\\\"\",\"\\\"\",\"on\"]");
    this.show(_builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("\"value\":[\"\\n\",\"This is \",\"\\\"\",\"\\\"\",\"on\",\"\\n\",\"and on...\"]");
    this.show(_builder_3.toString());
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("\"value\":[\"\\\\n\",\"This is \",\"\\\"\",\"\\\"\",\"on\"]");
    this.show(_builder_4.toString());
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("\"value\":[\"\\\\n\",\"This is \",\"\\\"\",\"\\\"\",\"on\",\"\\n\",\"and on...\"]");
    this.show(_builder_5.toString());
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("\"value\":[\"\\\\r\"]");
    this.show(_builder_6.toString());
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("\"value\":[\"\\\"\"]");
    this.show(_builder_7.toString());
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("\"value\":[\"abc\"]");
    this.show(_builder_8.toString());
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("\"value\":[\"abc\",\"def\"]");
    this.show(_builder_9.toString());
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("\"value\":[\"\\n\",\"This is \",\"\\\"\",\"\\\"\",\"on\",\"\\\"\",\"\\\"\",\"\\n\",\"\\n\",\"Ceci est \",\"\\\"\",\"true\",\"\\\"\",\"\\n\"]");
    this.show(_builder_10.toString());
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("\"value\":[\"\\\\n\",\"This is \",\"\\\"\",\"\\\"\",\"on\",\"\\\"\",\"\\\"\",\"\\\\n\",\"\\\\n\",\"Ceci est \",\"\\\"\",\"true\",\"\\\"\",\"\\\\n\"]");
    this.show(_builder_11.toString());
    StringConcatenation _builder_12 = new StringConcatenation();
    _builder_12.append("\"value\":[\"\\\\n\",\"This is \",\"\\\"\",\"\\\"\"]");
    this.show(_builder_12.toString());
    StringConcatenation _builder_13 = new StringConcatenation();
    _builder_13.append("\"value\":[\"\\\\n\",\"\\\\n\"]");
    this.show(_builder_13.toString());
    StringConcatenation _builder_14 = new StringConcatenation();
    _builder_14.append("\"value\":[\"abc\",\"\\\\r\"]");
    this.show(_builder_14.toString());
    StringConcatenation _builder_15 = new StringConcatenation();
    _builder_15.append("\"value\":\"OpenWorldDefiniions\"");
    this.show(_builder_15.toString());
    StringConcatenation _builder_16 = new StringConcatenation();
    _builder_16.append("\"value\":true");
    this.show(_builder_16.toString());
    StringConcatenation _builder_17 = new StringConcatenation();
    _builder_17.append("\"value\":false");
    this.show(_builder_17.toString());
    StringConcatenation _builder_18 = new StringConcatenation();
    _builder_18.append("{\"literalType\":\"string\",\"value\":[\"\\\"\",\"def\"]}");
    this.value(_builder_18.toString());
    StringConcatenation _builder_19 = new StringConcatenation();
    _builder_19.append("{\"literalType\":\"int\",\"value\":\"42\"}");
    this.value(_builder_19.toString());
    StringConcatenation _builder_20 = new StringConcatenation();
    _builder_20.append("[\"\\\"\",\"def\"]");
    this.value(_builder_20.toString());
    StringConcatenation _builder_21 = new StringConcatenation();
    _builder_21.append("[\"\"]");
    this.value(_builder_21.toString());
    StringConcatenation _builder_22 = new StringConcatenation();
    _builder_22.append("\"\\\\n\",\"This is \",\"\\\"\",\"\\\"\",\"on\",\"\\\"\",\"\\\"\",\"\\\\n\",\"\\\\n\",\"Ceci est \",\"\\\"\",\"true\",\"\\\"\",\"\\\\n\"");
    this.array(_builder_22.toString());
    StringConcatenation _builder_23 = new StringConcatenation();
    _builder_23.append("\"\\\\n\",\"This is \",\"\\\"\",\"\\\"\",\"on\"");
    this.array(_builder_23.toString());
    StringConcatenation _builder_24 = new StringConcatenation();
    _builder_24.append("\"\\\\n\",\"This is \",\"\\\"\",\"\\\"\"");
    this.array(_builder_24.toString());
    StringConcatenation _builder_25 = new StringConcatenation();
    _builder_25.append("\"\\\"\",\"def\"");
    this.array(_builder_25.toString());
  }
  
  @Test
  public void test3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("on,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"on\",");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("true");
    final String s1 = _builder.toString();
    final String v1 = OMLTables.toString(s1);
    final String j1 = "[\"on,\",\"\\n\",\"\t\t\",\"\\\"\",\"on\",\"\\\"\",\",\",\"\\n\",\"\t\ttrue\"]";
    Assert.assertEquals(j1, v1);
  }
}
