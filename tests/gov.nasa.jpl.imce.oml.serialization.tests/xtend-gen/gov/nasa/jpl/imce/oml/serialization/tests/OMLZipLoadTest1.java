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
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.common.LiteralDecimal;
import gov.nasa.jpl.imce.oml.model.common.LiteralNumber;
import gov.nasa.jpl.imce.oml.model.datatypes.AbstractDecimalValue;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.serialization.tests.MixedOMLLoadTest;
import java.net.URL;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class OMLZipLoadTest1 extends MixedOMLLoadTest {
  @Test
  public void xmlSchema() {
    try {
      final URL catalogFileURL = OMLZipLoadTest1.class.getResource("/OML/oml.catalog.xml");
      this.initialize(catalogFileURL);
      final Resource r1 = this.rs.createResource(URI.createURI("http://www.w3.org/2001/XMLSchema.omlzip"));
      Assert.assertNotNull(r1);
      r1.load(null);
      int _size = r1.getContents().size();
      boolean _equals = (1 == _size);
      Assert.assertTrue(_equals);
      final EObject root = r1.getContents().get(0);
      Assert.assertTrue(Extent.class.isInstance(root));
      final Extent ext = Extent.class.cast(root);
      int _size_1 = ext.getModules().size();
      boolean _equals_1 = (_size_1 == 1);
      Assert.assertTrue(_equals_1);
      final gov.nasa.jpl.imce.oml.model.common.Module m = ext.getModules().get(0);
      Assert.assertTrue(TerminologyGraph.class.isInstance(m));
      final TerminologyGraph g = TerminologyGraph.class.cast(m);
      final Iterable<NumericScalarRestriction> ns = Iterables.<NumericScalarRestriction>filter(g.getBoxStatements(), NumericScalarRestriction.class);
      int _size_2 = IterableExtensions.size(ns);
      boolean _equals_2 = (12 == _size_2);
      Assert.assertTrue(_equals_2);
      final Function1<NumericScalarRestriction, Boolean> _function = (NumericScalarRestriction n) -> {
        String _name = n.getName();
        return Boolean.valueOf(Objects.equal(_name, "unsignedLong"));
      };
      final NumericScalarRestriction r_unsignedLong = IterableExtensions.<NumericScalarRestriction>findFirst(ns, _function);
      Assert.assertNotNull(r_unsignedLong);
      Assert.assertNull("minExclusive", r_unsignedLong.getMinExclusive());
      Assert.assertNull("minInclusive", r_unsignedLong.getMinInclusive());
      Assert.assertNull("maxExclusive", r_unsignedLong.getMaxExclusive());
      Assert.assertNotNull("maxInclusive", r_unsignedLong.getMaxInclusive());
      final LiteralNumber r_unsignedLong_max = r_unsignedLong.getMaxInclusive();
      Assert.assertTrue(LiteralDecimal.class.isInstance(r_unsignedLong_max));
      final AbstractDecimalValue r_unsignedLong_max_value = LiteralDecimal.class.cast(r_unsignedLong_max).getDecimal();
      boolean _equals_3 = Objects.equal("18446744073709551615", r_unsignedLong_max_value.value);
      Assert.assertTrue(_equals_3);
      final Function1<NumericScalarRestriction, Boolean> _function_1 = (NumericScalarRestriction n) -> {
        String _name = n.getName();
        return Boolean.valueOf(Objects.equal(_name, "int"));
      };
      final NumericScalarRestriction r_int = IterableExtensions.<NumericScalarRestriction>findFirst(ns, _function_1);
      Assert.assertNotNull(r_int);
      Assert.assertNull("minExclusive", r_int.getMinExclusive());
      Assert.assertNotNull("minInclusive", r_int.getMinInclusive());
      final LiteralNumber r_int_minInclusive = r_int.getMinInclusive();
      Assert.assertTrue(LiteralDecimal.class.isInstance(r_int_minInclusive));
      final LiteralDecimal r_int_minInclusive_value = LiteralDecimal.class.cast(r_int_minInclusive);
      String _value = r_int_minInclusive_value.value();
      boolean _equals_4 = Objects.equal("-2147483648", _value);
      Assert.assertTrue(_equals_4);
      Assert.assertNull("maxExclusive", r_int.getMaxExclusive());
      Assert.assertNotNull("maxInclusive", r_int.getMaxInclusive());
      final LiteralNumber r_int_maxInclusive = r_int.getMaxInclusive();
      Assert.assertTrue(LiteralDecimal.class.isInstance(r_int_maxInclusive));
      final LiteralDecimal r_int_maxInclusive_value = LiteralDecimal.class.cast(r_int_maxInclusive);
      String _value_1 = r_int_maxInclusive_value.value();
      boolean _equals_5 = Objects.equal("2147483647", _value_1);
      Assert.assertTrue(_equals_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
