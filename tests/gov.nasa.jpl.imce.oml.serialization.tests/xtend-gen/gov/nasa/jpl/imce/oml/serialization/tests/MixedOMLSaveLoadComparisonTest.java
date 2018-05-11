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
import gov.nasa.jpl.imce.oml.model.extensions.OMLCatalog;
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import gov.nasa.jpl.imce.oml.serialization.tests.OMLResourceCompare;
import gov.nasa.jpl.imce.oml.zip.OMLZipResourceSet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Convenience class for writing mixed OML & OMLZip Save/Load Comparison Tests.
 * 
 * All the OML factory methods (e.g., createTerminologyGraph, createConcept, ...)
 * can be invoked by name without explicitly referring to the appropriate factory instance.
 */
@SuppressWarnings("all")
public abstract class MixedOMLSaveLoadComparisonTest {
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
  
  protected final String fileURIPrefix;
  
  protected final String httpURIPrefix;
  
  protected XtextResourceSet rs1;
  
  protected XtextResourceSet rs2;
  
  public MixedOMLSaveLoadComparisonTest() {
    try {
      OMLZipResourceSet.doSetup();
      long _currentTimeMillis = System.currentTimeMillis();
      String _plus = ("target/oml/" + Long.valueOf(_currentTimeMillis));
      this.omlCatalogFile = MixedOMLSaveLoadComparisonTest.createOMLFolder(Paths.get(_plus));
      String _absolutePath = this.omlCatalogFile.getParentFile().getAbsolutePath();
      String _plus_1 = ("file:/" + _absolutePath);
      String _plus_2 = (_plus_1 + "/");
      this.fileURIPrefix = _plus_2;
      String _absolutePath_1 = this.omlCatalogFile.getParentFile().getAbsolutePath();
      String _plus_3 = ("http:/" + _absolutePath_1);
      String _plus_4 = (_plus_3 + "/");
      this.httpURIPrefix = _plus_4;
      XtextResourceSet _xtextResourceSet = new XtextResourceSet();
      this.rs1 = _xtextResourceSet;
      XtextResourceSet _xtextResourceSet_1 = new XtextResourceSet();
      this.rs2 = _xtextResourceSet_1;
      final OMLCatalog c1 = OMLExtensions.getCatalog(this.rs1);
      c1.parseCatalog(this.omlCatalogFile.toURI().toURL());
      final OMLCatalog c2 = OMLExtensions.getCatalog(this.rs2);
      c2.parseCatalog(this.omlCatalogFile.toURI().toURL());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String toAbsoluteTempFileURI(final String path) {
    return (this.fileURIPrefix + path);
  }
  
  protected String toAbsoluteTempHttpURI(final String path) {
    return (this.httpURIPrefix + path);
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
        Resource _xifexpression = null;
        boolean _endsWith = uri.toString().endsWith(".oml");
        if (_endsWith) {
          _xifexpression = this.rs1.createResource(uri, "oml");
        } else {
          Resource _xifexpression_1 = null;
          boolean _endsWith_1 = uri.toString().endsWith(".omlzip");
          if (_endsWith_1) {
            _xifexpression_1 = this.rs1.createResource(uri, "omlzip");
          } else {
            _xifexpression_1 = this.rs1.createResource(uri);
          }
          _xifexpression = _xifexpression_1;
        }
        final Resource r1 = _xifexpression;
        r1.getContents().add(ext1);
        r1.save(null);
        Resource _xifexpression_2 = null;
        boolean _endsWith_2 = uri.toString().endsWith(".oml");
        if (_endsWith_2) {
          _xifexpression_2 = this.rs2.createResource(uri, "oml");
        } else {
          Resource _xifexpression_3 = null;
          boolean _endsWith_3 = uri.toString().endsWith(".omlzip");
          if (_endsWith_3) {
            _xifexpression_3 = this.rs2.createResource(uri, "omlzip");
          } else {
            _xifexpression_3 = this.rs2.createResource(uri);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        final Resource r2 = _xifexpression_2;
        r2.load(null);
        OMLResourceCompare.resourceCompare(r1, r2);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    ((List<Pair<URI, Extent>>)Conversions.doWrapArray(pairs)).forEach(_function);
  }
}
