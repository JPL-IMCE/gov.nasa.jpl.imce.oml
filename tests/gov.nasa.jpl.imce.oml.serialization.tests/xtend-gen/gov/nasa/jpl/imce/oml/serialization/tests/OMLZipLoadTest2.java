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
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;
import gov.nasa.jpl.imce.oml.serialization.tests.MixedOMLLoadTest;
import gov.nasa.jpl.imce.oml.serialization.tests.OMLZipLoadTest1;
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
public class OMLZipLoadTest2 extends MixedOMLLoadTest {
  @Test
  public void xmlSchema() {
    try {
      final URL catalogFileURL = OMLZipLoadTest1.class.getResource("/OML/oml.catalog.xml");
      this.initialize(catalogFileURL);
      final Resource r1 = this.rs.createResource(URI.createURI("http://imce.jpl.nasa.gov/foundation/base/base.omlzip"));
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
      final Iterable<EntityScalarDataProperty> esdp = Iterables.<EntityScalarDataProperty>filter(g.getBoxStatements(), EntityScalarDataProperty.class);
      int _size_2 = IterableExtensions.size(esdp);
      boolean _equals_2 = (9 == _size_2);
      Assert.assertTrue(_equals_2);
      final Function1<EntityScalarDataProperty, Boolean> _function = (EntityScalarDataProperty p) -> {
        String _name = p.getName();
        return Boolean.valueOf(Objects.equal(_name, "hasDescription"));
      };
      final EntityScalarDataProperty hasDescription = IterableExtensions.<EntityScalarDataProperty>findFirst(esdp, _function);
      Assert.assertTrue(hasDescription.isIsIdentityCriteria());
      final Function1<EntityScalarDataProperty, Boolean> _function_1 = (EntityScalarDataProperty p) -> {
        String _name = p.getName();
        return Boolean.valueOf(Objects.equal(_name, "hasUuid"));
      };
      final EntityScalarDataProperty hasUUID = IterableExtensions.<EntityScalarDataProperty>findFirst(esdp, _function_1);
      Assert.assertTrue(hasUUID.isIsIdentityCriteria());
      final Function1<EntityScalarDataProperty, Boolean> _function_2 = (EntityScalarDataProperty p) -> {
        String _name = p.getName();
        return Boolean.valueOf(Objects.equal(_name, "hasIndexEntry"));
      };
      final EntityScalarDataProperty hasIndexEntry = IterableExtensions.<EntityScalarDataProperty>findFirst(esdp, _function_2);
      boolean _isIsIdentityCriteria = hasIndexEntry.isIsIdentityCriteria();
      boolean _not = (!_isIsIdentityCriteria);
      Assert.assertTrue(_not);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
