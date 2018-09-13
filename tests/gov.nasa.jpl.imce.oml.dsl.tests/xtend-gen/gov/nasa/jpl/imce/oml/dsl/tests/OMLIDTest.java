/**
 * Copyright 2017 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.dsl.tests;

import gov.nasa.jpl.imce.oml.dsl.tests.OMLInjectorProvider;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(OMLInjectorProvider.class)
@SuppressWarnings("all")
public class OMLIDTest {
  @Test
  public void test1() {
    this.checkSame("Component");
  }
  
  @Test
  public void test2() {
    this.checkSame("0123Component");
  }
  
  @Test
  public void test3() {
    this.checkSame("0123-Component");
  }
  
  @Test
  public void test4() {
    this.checkSame("\'0123-?!@#$%^&*()[]=+|-Component\'");
  }
  
  @Test
  public void test5() {
    this.checkEscaped("0123-?!@#$%^&*()[]=+|-Component");
  }
  
  @Test
  public void test6() {
    this.checkIllegal("\'0123-?!@#$%^&*()[]=+|-Component");
  }
  
  @Test
  public void test7() {
    this.checkIllegal("0123-\'?!@#$%^&*()[]=+|-Component");
  }
  
  @Test
  public void test8() {
    this.checkEscaped("0123 Component");
  }
  
  @Test
  public void test9() {
    this.checkIllegal("\'0123\' Component");
  }
  
  @Test
  public void test10() {
    this.checkIllegal("0123\' \'Component");
  }
  
  public void checkSame(final String s) {
    Assert.assertEquals(OMLExtensions.wrapOMLIDIfNeeded(s), s);
  }
  
  public void checkEscaped(final String s) {
    Assert.assertEquals(OMLExtensions.wrapOMLIDIfNeeded(s), (("\'" + s) + "\'"));
  }
  
  public void checkIllegal(final String s) {
    try {
      OMLExtensions.wrapOMLIDIfNeeded(s);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Expected IllegalArgumentException for ill-formed OML ID: ");
      _builder.append(s);
      Assert.fail(_builder.toString());
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
        Assert.assertTrue(e.getMessage().startsWith("Illegal OML ID string:"));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
