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
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Existential Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EntityExistentialRestrictionAxiomImpl extends EntityRestrictionAxiomImpl implements EntityExistentialRestrictionAxiom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityExistentialRestrictionAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.ENTITY_EXISTENTIAL_RESTRICTION_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		String _uuid = this.getTbox().uuid();
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _uuid);
		EntityRelationship _restrictedRelation = this.getRestrictedRelation();
		String _uuid_1 = null;
		if (_restrictedRelation!=null) {
			_uuid_1=_restrictedRelation.uuid();
		}
		String _string = null;
		if (_uuid_1!=null) {
			_string=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("restrictedRelation", _string);
		Entity _restrictedDomain = this.getRestrictedDomain();
		String _uuid_2 = null;
		if (_restrictedDomain!=null) {
			_uuid_2=_restrictedDomain.uuid();
		}
		String _string_1 = null;
		if (_uuid_2!=null) {
			_string_1=_uuid_2.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("restrictedDomain", _string_1);
		Entity _restrictedRange = this.getRestrictedRange();
		String _uuid_3 = null;
		if (_restrictedRange!=null) {
			_uuid_3=_restrictedRange.uuid();
		}
		String _string_2 = null;
		if (_uuid_3!=null) {
			_string_2=_uuid_3.toString();
		}
		Pair<String, String> _mappedTo_3 = Pair.<String, String>of("restrictedRange", _string_2);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"EntityExistentialRestrictionAxiom", _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3);
		String _string_3 = null;
		if (_derivedUUID!=null) {
			_string_3=_derivedUUID.toString();
		}
		return _string_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TerminologiesPackage.ENTITY_EXISTENTIAL_RESTRICTION_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EntityExistentialRestrictionAxiomImpl
