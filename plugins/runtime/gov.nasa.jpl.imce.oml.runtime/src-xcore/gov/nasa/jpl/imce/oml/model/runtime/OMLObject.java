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
package gov.nasa.jpl.imce.oml.model.runtime;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OML Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.runtime.OMLObject#getOmlRoot <em>Oml Root</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage#getOMLObject()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface OMLObject extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Oml Root</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.runtime.OMLDescription#getOmlDescriptionContents <em>Oml Description Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oml Root</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oml Root</em>' container reference.
	 * @see #setOmlRoot(OMLDescription)
	 * @see gov.nasa.jpl.imce.oml.model.runtime.RuntimePackage#getOMLObject_OmlRoot()
	 * @see gov.nasa.jpl.imce.oml.model.runtime.OMLDescription#getOmlDescriptionContents
	 * @model opposite="omlDescriptionContents" required="true" transient="false"
	 * @generated
	 */
	OMLDescription getOmlRoot();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.runtime.OMLObject#getOmlRoot <em>Oml Root</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml Root</em>' container reference.
	 * @see #getOmlRoot()
	 * @generated
	 */
	void setOmlRoot(OMLDescription value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" aTypeUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><T> _xblockexpression = null;\n{\n\tfinal <%org.eclipse.emf.ecore.resource.ResourceSet%> resourceSet = this.eResource().getResourceSet();\n\tfinal <%java.lang.Iterable%><<%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>> adapters = <%com.google.common.collect.Iterables%>.<<%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>>filter(resourceSet.eAdapters(), <%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>.class);\n\t<%org.eclipse.emf.common.util.EList%><T> _xifexpression = null;\n\tboolean _isEmpty = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.isEmpty(adapters);\n\tif (_isEmpty)\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><T> _xblockexpression_1 = null;\n\t\t{\n\t\t\tfinal <%java.util.Collection%><<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>> references = <%org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer%>.find(this, resourceSet);\n\t\t\t_xblockexpression_1 = <%org.eclipse.emf.common.util.ECollections%>.<T>asEList(((T[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(<%com.google.common.collect.Iterables%>.<T>filter(<%com.google.common.collect.Iterables%>.<<%gov.nasa.jpl.imce.oml.model.runtime.OMLObject%>>filter(references, <%gov.nasa.jpl.imce.oml.model.runtime.OMLObject%>.class), aType), <%gov.nasa.jpl.imce.oml.model.runtime.OMLObject%>.class)));\n\t\t}\n\t\t_xifexpression = _xblockexpression_1;\n\t}\n\telse\n\t{\n\t\t_xifexpression = <%org.eclipse.emf.common.util.ECollections%>.<T>asEList(((T[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(<%com.google.common.collect.Iterables%>.<T>filter(<%com.google.common.collect.Iterables%>.<<%gov.nasa.jpl.imce.oml.model.runtime.OMLObject%>>filter(((<%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(adapters, <%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>.class))[0].getInverseReferences(this), <%gov.nasa.jpl.imce.oml.model.runtime.OMLObject%>.class), aType), <%gov.nasa.jpl.imce.oml.model.runtime.OMLObject%>.class)));\n\t}\n\t_xblockexpression = _xifexpression;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	<T extends OMLObject> EList<T> omlInverseReferencers(Class<T> aType);

} // OMLObject
