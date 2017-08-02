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
package gov.nasa.jpl.imce.oml.runtime;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OML Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * TODO: Improve performance, usage of EcoreUtil.UsageCrossReferencer may not be as efficient as
 *       another implementation utilizing code that is used by "aql:self.eInverse(base::Contains)"
 * 		according to Maged
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage#getOMLObject()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface OMLObject extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" aTypeUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><T> _xblockexpression = null;\n{\n\t<%org.eclipse.emf.ecore.resource.Resource%> _eResource = this.eResource();\n\tfinal <%org.eclipse.emf.ecore.resource.ResourceSet%> resourceSet = _eResource.getResourceSet();\n\t<%org.eclipse.emf.common.util.EList%><<%org.eclipse.emf.common.notify.Adapter%>> _eAdapters = resourceSet.eAdapters();\n\tfinal <%java.lang.Iterable%><<%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>> adapters = <%com.google.common.collect.Iterables%>.<<%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>>filter(_eAdapters, <%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>.class);\n\t<%org.eclipse.emf.common.util.EList%><T> _xifexpression = null;\n\tboolean _isEmpty = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.isEmpty(adapters);\n\tif (_isEmpty)\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><T> _xblockexpression_1 = null;\n\t\t{\n\t\t\tfinal <%java.util.Collection%><<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>> references = <%org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer%>.find(this, resourceSet);\n\t\t\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>, <%org.eclipse.emf.ecore.EObject%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>, <%org.eclipse.emf.ecore.EObject%>>()\n\t\t\t{\n\t\t\t\tpublic <%org.eclipse.emf.ecore.EObject%> apply(final <%org.eclipse.emf.ecore.EStructuralFeature.Setting%> it)\n\t\t\t\t{\n\t\t\t\t\treturn it.getEObject();\n\t\t\t\t}\n\t\t\t};\n\t\t\t<%java.lang.Iterable%><<%org.eclipse.emf.ecore.EObject%>> _map = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>, <%org.eclipse.emf.ecore.EObject%>>map(references, _function);\n\t\t\t<%java.lang.Iterable%><T> _filter = <%com.google.common.collect.Iterables%>.<T>filter(_map, aType);\n\t\t\t_xblockexpression_1 = <%org.eclipse.emf.common.util.ECollections%>.<T>asEList(((T[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_filter, <%gov.nasa.jpl.imce.oml.runtime.OMLObject%>.class)));\n\t\t}\n\t\t_xifexpression = _xblockexpression_1;\n\t}\n\telse\n\t{\n\t\t<%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%> _get = ((<%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(adapters, <%org.eclipse.emf.ecore.util.ECrossReferenceAdapter%>.class))[0];\n\t\t<%java.util.Collection%><<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>> _inverseReferences = _get.getInverseReferences(this);\n\t\t<%java.lang.Iterable%><T> _filter = <%com.google.common.collect.Iterables%>.<T>filter(_inverseReferences, aType);\n\t\t_xifexpression = <%org.eclipse.emf.common.util.ECollections%>.<T>asEList(((T[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_filter, <%gov.nasa.jpl.imce.oml.runtime.OMLObject%>.class)));\n\t}\n\t_xblockexpression = _xifexpression;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	<T extends OMLObject> EList<T> omlInverseReferencers(Class<T> aType);

} // OMLObject
