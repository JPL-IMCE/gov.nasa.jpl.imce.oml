/*
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
package gov.nasa.jpl.imce.oml.serialization.tests

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.common.util.EList
import gov.nasa.jpl.imce.oml.model.common.CrossReferencabilityKind
import java.util.Map
import java.util.HashMap
import gov.nasa.jpl.imce.oml.zip.OMLZipResource

/**
 * Reflection-based OML Resource Comparison.
 */
class OMLResourceCompare {
	
	/**
	 * Returns the EClass that is the type of an ETypedElement or null.
	 */
	static def EClass EClassType(ETypedElement f) {
		val c = f.EType
		switch c {
			EClass:
				c
			default:
				null
		}
	}
	
	/**
	 * Structural comparison of the contents of two OMLZipResources.
	 */
	static def void resourceCompare
	(Resource r1, Resource r2) 
	throws IllegalArgumentException {
		if (!OMLZipResource.isInstance(r1))
			throw new IllegalArgumentException("resourceCompare(r1,_) must be an OMLZipResource!")
		
		if (!OMLZipResource.isInstance(r2))
			throw new IllegalArgumentException("resourceCompare(_,r2) must be an OMLZipResource!")
		
		if (1 != r1.contents.size)
			throw new IllegalArgumentException("resourceCompare(r1 has "+r1.contents.size+" toplevel elements (there should be 1)")
		val top1 = r1.contents.get(0)
		
		if (1 != r2.contents.size)
			throw new IllegalArgumentException("resourceCompare(r2 has "+r2.contents.size+" toplevel elements (there should be 1)")
		val top2 = r1.contents.get(0)
		
		compare("/", top1, top2)
	}
	
	/**
	 * Compare two EObjects in terms of their EAttribute values and their EReference collections,
	 * making sure that they have the same EAttributes & EReferences.
	 */
	static protected def void compare
	(String path, EObject e1, EObject e2)
	throws IllegalArgumentException {
		val ec1 = e1.eClass
		val ec2 = e2.eClass
		if (ec1 != ec2)
			throw new IllegalArgumentException("compare("+path+") different metaclasses: "+ec1.name+" vs. "+ec2.name)
		ec1.EAllAttributes.forEach[attr|
			val loc = path+"@"+attr.name
			System.out.println("... "+loc)
			val v1 = e1.eGet(attr)
			val v2 = e2.eGet(attr)
			if (v1 != v2)
				throw new IllegalArgumentException("compare("+loc+") different attribute values: "+v1+" vs. "+v2)
		]
		ec1.EAllStructuralFeatures.filter(EReference).filter[containment || null === EOpposite].forEach[f|
			val loc = path+"/"+f.name
			val t = f.EClassType
			val Object v1 = e1.eGet(f)
			val Object v2 = e2.eGet(f)
			if (null === v1 && null === v2)
				return
			else if (null !== v1 && null === v2)
				throw new IllegalArgumentException("compareReferences("+path+") non-null vs. null")
			else if (null === v1 && null !== v2)
				throw new IllegalArgumentException("compareReferences("+path+") null vs. non-null")
			else 
				compareReferences(loc, f, t, e1, v1, e2, v2)
		]
	}
	
	/**
	 * Reference comparison is undefined for arbitrary EObjects that are not OML CrossReferencabilityKinds.
	 */
	static protected def dispatch void compareReferences
	(String path, EReference f, EClass t, EObject e1, Object v1, EObject e2, Object v2)
	throws IllegalArgumentException {
		throw new IllegalArgumentException("compareReferences("+path+") unhandled case for '"+f.name+": "+t.name)
	}
	
	/**
	 * Reference comparison for OML CrossReferencabilityKinds.
	 */
	static protected def dispatch void compareReferences
	(String path, EReference f, EClass t, EObject e1, CrossReferencabilityKind v1, EObject e2, CrossReferencabilityKind v2)
	throws IllegalArgumentException {
		val uuid1 = v1.uuid()
		val uuid2 = v2.uuid()
		if (uuid1 != uuid2)
			throw new IllegalArgumentException("compareReferences("+path+") uuid mismatch:"+uuid1+" vs "+uuid2)
		compare(path, v1, v2)
	}
	
	/**
	 * Reference comparison for collections of OML CrossReferencabilityKinds.
	 */
	static protected def dispatch void compareReferences
	(String path, EReference f, EClass t, EObject e1, EList<CrossReferencabilityKind> v1, EObject e2, EList<CrossReferencabilityKind> v2)
	throws IllegalArgumentException {
		val n1 = v1.size
		val n2 = v2.size
		if (n1 != n2)
			throw new IllegalArgumentException("compareReferences("+path+") collection size mismatch: "+n1+" vs "+n2)
		val Map<String, CrossReferencabilityKind> v1Map = new HashMap<String, CrossReferencabilityKind>()
		v1.forEach[u1|
			val uuid = u1.uuid()
			if (null === uuid)
				throw new IllegalArgumentException("compareReferences("+path+") left null uuid: "+u1)
			val old = v1Map.put(uuid, u1)
			if (null !== old)
				throw new IllegalArgumentException("compareReferences("+path+") left uuid conflict: "+old+" vs "+u1)
		]
		val Map<String, CrossReferencabilityKind> v2Map = new HashMap<String, CrossReferencabilityKind>()
		v2.forEach[u2|
			val uuid = u2.uuid()
			if (null === uuid)
				throw new IllegalArgumentException("compareReferences("+path+") right null uuid: "+u2)
			val old = v2Map.put(uuid, u2)
			if (null !== old)
				throw new IllegalArgumentException("compareReferences("+path+") right uuid conflict: "+old+" vs "+u2)
		]
		v1Map.forEach[uuid, u1|
			val u2 = v2Map.get(uuid)
			if (null === u2)
				throw new IllegalArgumentException("compareReferences("+path+") collection mismatch: "+uuid+" vs N/A")
			compare(path+"["+uuid+"]", u1, u2)
		]
	}
}