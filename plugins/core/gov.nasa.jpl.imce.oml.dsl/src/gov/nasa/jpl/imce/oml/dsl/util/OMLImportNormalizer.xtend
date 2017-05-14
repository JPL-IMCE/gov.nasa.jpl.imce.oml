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
package gov.nasa.jpl.imce.oml.dsl.util

import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.impl.ImportNormalizer

class OMLImportNormalizer extends ImportNormalizer{
	
	IQualifiedNameConverter qnc = new OMLQualifiedNameConverter

	String prefix;
	String namespace;

	new(QualifiedName importedNamespace, String prefix) {
		super(importedNamespace, false, false)
		this.prefix = prefix
		this.namespace = qnc.toString(importedNamespace)
	}
	
	override def QualifiedName resolve(QualifiedName relativeName) {
		var relative = qnc.toString(relativeName)
		if (relative.startsWith('<') && relative.endsWith('>')) {
			if (namespace.equals(relative)) {
				return relativeName
			} else if (prefix=="" && !relative.contains(':')) {
				//relative
				relative = relative.substring(1, relative.length-1)
				return QualifiedName.create('<'+namespace +relative+'>')
			}
		} else if (prefix.equals(relative)) {
			return qnc.toQualifiedName('<'+namespace+'>')
		} else if (relative.contains(':')) {
			//QNAME
			val data = relative.split(":")
			if (prefix == data.get(0)) {
				return qnc.toQualifiedName('<'+namespace+data.get(1)+'>')
			}
		} else if (prefix == "") {
				return qnc.toQualifiedName('<'+namespace+relative+'>')
		}
		return null
	}
	
	override def QualifiedName deresolve(QualifiedName fullyQualifiedName) {
		var qualified = qnc.toString(fullyQualifiedName)
		if (qualified.startsWith('<') && qualified.endsWith('>')) {
			qualified = qualified.substring(1, qualified.length-1)
			if (qualified.startsWith(namespace)) {
				val name = qualified.replaceFirst(namespace, "")
				if (prefix != "")
					return QualifiedName.create(prefix+':'+name)
				else
					return QualifiedName.create(name)
			}
		}
		return null
	}

}