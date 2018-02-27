/*
 * Copyright 2017 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.dsl.tests

import com.google.inject.Inject
import com.google.inject.Provider
import gov.nasa.jpl.imce.oml.model.common.CommonFactory
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.graphs.GraphsFactory
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory
import java.io.ByteArrayOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.SaveOptions.Builder
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(OMLInjectorProvider)
class OMLSpecializedReifiedRelationshipTest1 {
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	val commonF = CommonFactory.eINSTANCE
	val terminologiesF = TerminologiesFactory.eINSTANCE
	val graphsF = GraphsFactory.eINSTANCE
	
	@Test
	def void test() {

		val rs = resourceSetProvider.get
		
		val r1 = rs.createResource(URI.createFileURI("file:OMLSpecializedReifiedRelationshipTest1.oml"))
		val Extent e1 = commonF.createExtent()
		r1.getContents.add(e1)

		val TerminologyGraph g = graphsF.createTerminologyGraph()
		g.extent = e1
		g.iri = "http://www.example.org/OMLSpecializedReifiedRelationshipTest1"

		//=========
		
		val Concept A1 = terminologiesF.createConcept
		A1.tbox = g
		A1.name = "A1"
		
		val Aspect B1 = terminologiesF.createAspect
		B1.tbox = g
		B1.name = "B1"
		
		val ReifiedRelationship U1 = terminologiesF.createReifiedRelationship
		U1.tbox = g
		U1.name = "U1"
		U1.source = A1
		U1.target = B1
		
		val u1 = terminologiesF.createForwardProperty
		u1.name = "u1"
		u1.reifiedRelationship = U1
		
		// =========
		
		val Concept C1 = terminologiesF.createConcept
		C1.tbox = g
		C1.name = "C1"
		
		val Aspect D1 = terminologiesF.createAspect
		D1.tbox = g
		D1.name = "D1"
		
		val ReifiedRelationship V1 = terminologiesF.createReifiedRelationship
		V1.tbox = g
		V1.name = "V1"
		V1.source = C1
		V1.target = D1
		
		val v1 = terminologiesF.createForwardProperty
		v1.name = "v1"
		v1.reifiedRelationship = V1
		
		// =============
		
		
		val Concept A2 = terminologiesF.createConcept
		A2.tbox = g
		A2.name = "A2"
		
		val A2_extends_A1 = terminologiesF.createConceptSpecializationAxiom
		A2_extends_A1.tbox = g
		A2_extends_A1.subConcept = A2
		A2_extends_A1.superConcept = A1
		
		val Aspect B2 = terminologiesF.createAspect
		B2.tbox = g
		B2.name = "B2"
		
		val B2_extends_B1 = terminologiesF.createAspectSpecializationAxiom
		B2_extends_B1.tbox = g
		B2_extends_B1.subEntity = B2
		B2_extends_B1.superAspect = B1
		
		val Concept A3 = terminologiesF.createConcept
		A3.tbox = g
		A3.name = "A3"
		
		val A3_extends_A2 = terminologiesF.createConceptSpecializationAxiom
		A3_extends_A2.tbox = g
		A3_extends_A2.subConcept = A3
		A3_extends_A2.superConcept = A2
		
		val Aspect B3 = terminologiesF.createAspect
		B3.tbox = g
		B3.name = "B3"
		
		val B3_extends_B2 = terminologiesF.createAspectSpecializationAxiom
		B3_extends_B2.tbox = g
		B3_extends_B2.subEntity = B3
		B3_extends_B2.superAspect = B2
		
		val Concept C2 = terminologiesF.createConcept
		C2.tbox = g
		C2.name = "C2"
		
		val C2_extends_C1 = terminologiesF.createConceptSpecializationAxiom
		C2_extends_C1.tbox = g
		C2_extends_C1.subConcept = C2
		C2_extends_C1.superConcept = C1
		
		val Concept D2 = terminologiesF.createConcept
		D2.tbox = g
		D2.name = "D2"
		
		val D2_extends_D1 = terminologiesF.createAspectSpecializationAxiom
		D2_extends_D1.tbox = g
		D2_extends_D1.subEntity = D2
		D2_extends_D1.superAspect = D1
		
		val Concept C3 = terminologiesF.createConcept
		C3.tbox = g
		C3.name = "C3"
		
		val C3_extends_C2 = terminologiesF.createConceptSpecializationAxiom
		C3_extends_C2.tbox = g
		C3_extends_C2.subConcept = C3
		C3_extends_C2.superConcept = C2
		
		val Concept D3 = terminologiesF.createConcept
		D3.tbox = g
		D3.name = "D3"
		
		val D3_extends_D2 = terminologiesF.createConceptSpecializationAxiom
		D3_extends_D2.tbox = g
		D3_extends_D2.subConcept = D3
		D3_extends_D2.superConcept = D2
		
		val Concept E = terminologiesF.createConcept
		E.tbox = g
		E.name = "E"
		
		val E_extends_A2 = terminologiesF.createConceptSpecializationAxiom
		E_extends_A2.tbox = g
		E_extends_A2.subConcept = E
		E_extends_A2.superConcept = A2
		
		val E_extends_C3 = terminologiesF.createConceptSpecializationAxiom
		E_extends_C3.tbox = g
		E_extends_C3.subConcept = E
		E_extends_C3.superConcept = C3
		
		val Concept F = terminologiesF.createConcept
		F.tbox = g
		F.name = "F"
		
		val F_extends_B2 = terminologiesF.createAspectSpecializationAxiom
		F_extends_B2.tbox = g
		F_extends_B2.subEntity = F
		F_extends_B2.superAspect = B2
		
		val F_extends_D3 = terminologiesF.createConceptSpecializationAxiom
		F_extends_D3.tbox = g
		F_extends_D3.subConcept = F
		F_extends_D3.superConcept = D3
		
		val Concept G = terminologiesF.createConcept
		G.tbox = g
		G.name = "G"
		
		val G_extends_E = terminologiesF.createConceptSpecializationAxiom
		G_extends_E.tbox = g
		G_extends_E.subConcept = G
		G_extends_E.superConcept = E
		
		val Concept H = terminologiesF.createConcept
		H.tbox = g
		H.name = "H"
		
		val H_extends_F = terminologiesF.createConceptSpecializationAxiom
		H_extends_F.tbox = g
		H_extends_F.subConcept = H
		H_extends_F.superConcept = F
		
		val ReifiedRelationship U2 = terminologiesF.createReifiedRelationship
		U2.tbox = g
		U2.name = "R"
		U2.source = A2
		U2.target = B2
		
		val u2 = terminologiesF.createForwardProperty
		u2.reifiedRelationship = U2
		u2.name = "u2"
		
		val U2_extends_U1 = terminologiesF.createReifiedRelationshipSpecializationAxiom
		U2_extends_U1.tbox = g
		U2_extends_U1.subRelationship = U2
		U2_extends_U1.superRelationship = U1
		
		val U3 = terminologiesF.createPartialReifiedRelationship
		U3.tbox = g
		U3.name = "U3"
		U3.source = A3
		U3.target = B3
		
		val U3_extends_U2 = terminologiesF.createReifiedRelationshipSpecializationAxiom
		U3_extends_U2.tbox = g
		U3_extends_U2.subRelationship = U3
		U3_extends_U2.superRelationship = U2
		
		val V2 = terminologiesF.createPartialReifiedRelationship
		V2.tbox = g
		V2.name = "V2"
		V2.source = C2
		V2.target = D2
		
		val V2_extends_V1 = terminologiesF.createReifiedRelationshipSpecializationAxiom
		V2_extends_V1.tbox = g
		V2_extends_V1.subRelationship = V2
		V2_extends_V1.superRelationship = V1
		
		val V3 = terminologiesF.createPartialReifiedRelationship
		V3.tbox = g
		V3.name = "V3"
		V3.source = C3
		V3.target = D3
		
		val V3_extends_V2 = terminologiesF.createReifiedRelationshipSpecializationAxiom
		V3_extends_V2.tbox = g
		V3_extends_V2.subRelationship = V3
		V3_extends_V2.superRelationship = V2
		
		val W = terminologiesF.createPartialReifiedRelationship
		W.tbox = g
		W.name = "W"
		W.source = E
		W.target = F
		
		val W_extends_U2 = terminologiesF.createReifiedRelationshipSpecializationAxiom
		W_extends_U2.tbox = g
		W_extends_U2.subRelationship = W
		W_extends_U2.superRelationship = U2
		
		val W_extends_V3 = terminologiesF.createReifiedRelationshipSpecializationAxiom
		W_extends_V3.tbox = g
		W_extends_V3.subRelationship = W
		W_extends_V3.superRelationship = V3
		
		val ReifiedRelationship X = terminologiesF.createReifiedRelationship
		X.tbox = g
		X.name = "X"
		X.source = G
		X.target = H
		
		val x = terminologiesF.createForwardProperty
		x.reifiedRelationship = X
		x.name = "x"
		
		val X_extends_W = terminologiesF.createReifiedRelationshipSpecializationAxiom
		X_extends_W.tbox = g
		X_extends_W.subRelationship = X
		X_extends_W.superRelationship = W
		
		OMLExtensions.normalize(e1)
		
		val String text1 = serialize(r1)
		val String expected1 = '''
open terminology <http://www.example.org/OMLSpecializedReifiedRelationshipTest1> {

	aspect B1

	aspect B2

	aspect B3

	aspect D1

	concept A1

	concept A2

	concept A3

	concept C1

	concept C2

	concept C3

	concept D2

	concept D3

	concept E

	concept F

	concept G

	concept H

	A2 extendsConcept A1

	A3 extendsConcept A2

	C2 extendsConcept C1

	C3 extendsConcept C2

	D3 extendsConcept D2

	E extendsConcept A2

	E extendsConcept C3

	F extendsConcept D3

	G extendsConcept E

	H extendsConcept F

	reifiedRelationship R {
		unreified = u2
		source = A2
		target = B2 }

	reifiedRelationship U1 {
		unreified = u1
		source = A1
		target = B1 }

	reifiedRelationship V1 {
		unreified = v1
		source = C1
		target = D1 }

	reifiedRelationship X {
		unreified = x
		source = G
		target = H }

	reifiedRelationship U3 {
		source = A3
		target = B3 }

	reifiedRelationship V2 {
		source = C2
		target = D2 }

	reifiedRelationship V3 {
		source = C3
		target = D3 }

	reifiedRelationship W {
		source = E
		target = F }

	R extendsRelationship U1

	U3 extendsRelationship R

	V2 extendsRelationship V1

	V3 extendsRelationship V2

	W extendsRelationship R

	W extendsRelationship V3

	X extendsRelationship W

	B2 extendsAspect B1

	B3 extendsAspect B2

	D2 extendsAspect D1

	F extendsAspect B2

}
		'''
		
		assertEquals(text1, expected1)
		
	}
	
	def String serialize(Resource r) {
		val ByteArrayOutputStream bos = new ByteArrayOutputStream()
		val Builder builder = SaveOptions.newBuilder()
		builder.format()
		val SaveOptions s = builder.getOptions();
		r.save(bos, s.toOptionsMap());
		bos.toString
	}
}