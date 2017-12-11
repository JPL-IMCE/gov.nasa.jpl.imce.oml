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

import gov.nasa.jpl.imce.oml.model.bundles.BundlesFactory;
import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.common.Extent;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import gov.nasa.jpl.imce.oml.serialization.tests.OMLResourceCompare;
import gov.nasa.jpl.imce.oml.zip.OMLZipResource;
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceSet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Convenience class for writing OMLZip Save/Load Comparison Tests.
 * 
 * All the OML factory methods (e.g., createTerminologyGraph, createConcept, ...)
 * can be invoked by name without explicitly referring to the appropriate factory instance.
 */
@SuppressWarnings("all")
public abstract class OMLSaveLoadComparisonTest {
  @Extension
  protected static CommonFactory _commonFactory = CommonFactory.eINSTANCE;
  
  @Extension
  protected static TerminologiesFactory _terminologiesFactory = TerminologiesFactory.eINSTANCE;
  
  @Extension
  protected static GraphsFactory _graphsFactory = GraphsFactory.eINSTANCE;
  
  @Extension
  protected static BundlesFactory _bundlesFactory = BundlesFactory.eINSTANCE;
  
  @Extension
  protected static DescriptionsFactory _descriptionsFactory = DescriptionsFactory.eINSTANCE;
  
  protected static File createOMLFolder(final Path path) {
    try {
      File _xblockexpression = null;
      {
        final File d = path.toFile();
        d.mkdirs();
        final File c = path.resolve("oml.catalog.xml").toFile();
        FileOutputStream _fileOutputStream = new FileOutputStream(c);
        final PrintWriter pw = new PrintWriter(_fileOutputStream);
        pw.println("<?xml version=\'1.0\'?>");
        pw.println("<catalog xmlns=\"urn:oasis:names:tc:entity:xmlns:xml:catalog\" prefer=\"public\">");
        pw.println("\t<rewriteURI rewritePrefix=\"file:./\" uriStartString=\"http://\"/>");
        pw.println("</catalog>");
        pw.close();
        _xblockexpression = c;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected File omlCatalogFile;
  
  protected OMLZipResourceSet rs1;
  
  protected OMLZipResourceSet rs2;
  
  public OMLSaveLoadComparisonTest() {
    try {
      OMLZipResourceSet.doSetup();
      long _currentTimeMillis = System.currentTimeMillis();
      String _plus = ("./target/oml/" + Long.valueOf(_currentTimeMillis));
      this.omlCatalogFile = OMLSaveLoadComparisonTest.createOMLFolder(Paths.get(_plus));
      URL _uRL = this.omlCatalogFile.toURI().toURL();
      OMLZipResourceSet _oMLZipResourceSet = new OMLZipResourceSet(_uRL);
      this.rs1 = _oMLZipResourceSet;
      URL _uRL_1 = this.omlCatalogFile.toURI().toURL();
      OMLZipResourceSet _oMLZipResourceSet_1 = new OMLZipResourceSet(_uRL_1);
      this.rs2 = _oMLZipResourceSet_1;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Execute a Save/Load Compare Unit Test.
   * For each <URI, Extent> pair: <uri, ext>, the following 3 steps are performed:
   * - use rs1 to create an OMLZipResource, r1, at uri with contents ext and save this resource
   * - use rs2 to load an OMLZipResource, r2, from uri
   * - check that there are no structural differences in the contents of r1 (as created) and of r2 (as loaded).
   */
  protected void compareSavedAndLoaded(final Pair<URI, Extent>... pairs) {
    final Consumer<Pair<URI, Extent>> _function = (Pair<URI, Extent> pair) -> {
      try {
        final URI uri = pair.getKey();
        final Extent ext1 = pair.getValue();
        final OMLZipResource r1 = this.rs1.createResource(uri);
        r1.getContents().add(ext1);
        r1.save(null);
        final Resource r2 = this.rs2.getResource(uri, true);
        OMLResourceCompare.resourceCompare(r1, r2);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    ((List<Pair<URI, Extent>>)Conversions.doWrapArray(pairs)).forEach(_function);
  }
}
