/**
 * 
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package gov.nasa.jpl.imce.oml.model.graphs;

import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminology Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML TerminologyGraph is an OML TerminologyBox with no statements our axioms involving OML Bundle(s).
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage#getTerminologyGraph()
 * @model
 * @generated
 */
public interface TerminologyGraph extends TerminologyBox {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.boxAxioms.getOrElse(this, scala.collection.immutable.Set.empty[resolver.api.ModuleEdge])'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%&gt;&gt;asEList(((&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%&gt;&gt;filter(this.getBoxAxioms(), &lt;%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%&gt;.class), &lt;%gov.nasa.jpl.imce.oml.model.common.ModuleEdge%&gt;.class)));'"
	 * @generated
	 */
	EList<ModuleEdge> moduleEdges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.lookupBoxStatements(this)'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleElement%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleElement%&gt;&gt; mes = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.ModuleElement%&gt;&gt;();\n\tmes.addAll(this.getBoxStatements());\n\t_xblockexpression = mes;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	EList<ModuleElement> moduleElements();

} // TerminologyGraph
