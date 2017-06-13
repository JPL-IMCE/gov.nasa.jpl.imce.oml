/*
 * Copyright 2017 California Institute of Technology ("Caltech").
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
package gov.nasa.jpl.imce.oml.dsl.generator

import com.google.inject.Inject
import gov.nasa.jpl.imce.oml.model.bundles.Bundle
import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Concept
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.DataRange
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.Entity
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.Scalar
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Structure
import gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty
import gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.Term
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement
import gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage
import java.util.ArrayList
import java.util.Collection
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set
import org.eclipse.core.resources.IProject
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class OMLGenerator extends AbstractGenerator {

	@Inject extension OMLExtensions

	static val xCoreKeywords = newArrayList('refers', 'contains', 'extends', 'imports', 'id')

	protected var Bundle omlBundle
	protected var IProject ecoreProjectHandle
	protected var IProject editProjectHandle
	protected var IProject uiProjectHandle
	protected var String dsmlName
	
	public def void setEcoreProjectHandle(IProject ecoreProjectHandle) {
		this.ecoreProjectHandle = ecoreProjectHandle
	}
	
	public def void setEditProjectHandle(IProject editProjectHandle) {
		this.editProjectHandle = editProjectHandle
	}
	
	public def void setUIProjectHandle(IProject uiProjectHandle) {
		this.uiProjectHandle = uiProjectHandle
	}
	
	public def void setDSMLName(String dsmlName) {
		this.dsmlName = dsmlName
	}
	
	public def Bundle getBundle() { omlBundle }
	
	override afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		super.afterGenerate(input, fsa, context)
		omlBundle = null
		ecoreProjectHandle = null
		editProjectHandle = null
		uiProjectHandle = null
	}
	
	override beforeGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		super.beforeGenerate(input, fsa, context)
		EcoreUtil2.resolveAll(input)
		
		val rs = input.resourceSet
		val errors = rs.resources.map[errors].flatten
		if (!errors.empty) {
			val message = '''
			«errors.size» errors: 
			«FOR e : errors»
				«e.location» line: «e.line», column: «e.column» «e.message»
			«ENDFOR»
			'''
			throw new IllegalArgumentException(message)
		}
		val warnings = rs.resources.map[warnings].flatten
		if (!warnings.empty) {
			val message = '''
			«warnings.size» warnings: 
			«FOR w : warnings»
				«w.location» line: «w.line», column: «w.column» «w.message»
			«ENDFOR»
			'''
			throw new IllegalArgumentException(message)
		}
		val missing = rs.resources.filter[!loaded]
		if (!missing.empty) {
			val message = '''
			«missing.size» missing resources: 
			«FOR m : missing»
				«m.URI»
			«ENDFOR»
			'''
			throw new IllegalArgumentException(message)
		}
		
		switch top : input.contents.get(0) {
			Extent: {
				val bundles = top.modules.filter(Bundle)
				if (bundles.size != 1) 
					throw new IllegalArgumentException("There should be exactly 1 Bundle in "+input)
				omlBundle = bundles.get(0)
			}
			default:
				throw new IllegalArgumentException("There should be exactly 1 Bundle in "+input)
		}
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (!resource.contents.empty) {
			switch top : resource.contents.get(0) {
				Extent: {

					val bundles = top.modules.filter(Bundle)
					for (bundle : bundles) {
						val allTboxes = new HashSet<TerminologyBox>()
						allTboxes.addAll(bundle.allImportedTerminologies)
						allTboxes.addAll(bundle.allImportedBundles.map[allImportedTerminologies].flatten)
						for (terminology : allTboxes) {
							val filename = terminology.validQName + ".xcore"
							val contents = new TerminologyToXcoreGenerator(this, allTboxes, terminology, dsmlName).doGenerate
							System.out.println("generating: " + filename)
							fsa.generateFile(filename, contents)
						}
					}
				}
				default: {
					// nothing to do.
				}
			}
		}
	}

	private static class TerminologyToXcoreGenerator {

		val String XSD_NS = 'http://www.w3.org/2001/XMLSchema#'

		val Set<TerminologyBox> terminologies
		val TerminologyBox terminology
		val Map<String, String> imports
		val OMLGenerator generator
		
		val String packageNsURI
		val String packageEQName
		val String packageQName
		val String packageTName
		val String dsmlName
		
		new(OMLGenerator generator, Iterable<TerminologyBox> terminologies, TerminologyBox terminology,  String dsmlName) {
			this.generator = generator
			this.terminologies = new HashSet()
			for (t : terminologies) {
				this.terminologies.add(t)
			}
			this.terminology = terminology
			this.imports = new HashMap<String, String>()
			
			val eInfo = generator.editProjectHandle
			val eLoc = eInfo.fullPath
			val eSegs = eLoc.segments
			
			val pInfo = generator.ecoreProjectHandle
			val pLoc = pInfo.fullPath
			val pSegs = pLoc.segments
			
			this.packageEQName = eSegs.join('.')
			this.packageQName = pSegs.join('.')
			
			this.packageNsURI = terminology.getIri
			this.dsmlName = dsmlName 
			
			this.packageTName = terminology.validQName
		}

		def protected imported(String qualifiedName) {
			val sections = qualifiedName.split('\\.')
			val simpleName = sections.get(sections.size - 1).legalName
			val legalQName = qualifiedName.legalName
			switch existing:imports.get(simpleName) {
				case null:
					imports.put(simpleName, legalQName)
				case existing != legalQName:
					return legalQName
			}
			simpleName
		}

		def protected imported(EClass eClass) {
			imported('gov.nasa.jpl.imce.oml.runtime.' + eClass.name)
		}

		def protected imported(Term term) {
			if (term.tbox !== null && term.tbox != terminology && !term.iri.startsWith(XSD_NS))
				imported(term.qualifieddName)
			else
				term.name()
		}

		def doGenerate() '''
			«val body = terminology.convertToBody»
			«terminology.convertToPackage»
			
			«terminology.convertToImports»
			
			/*
			 * This annotation specifies:
			 * - The provenance of an OML term mapped to an Xcore definition as part of mapping an OML bundle to an M2 Xcore metamodel.
			 * - For M1 element instances of such an M2 xcore definition, the OML term to which the M1 instance needs to be mapped back.
			 *   Note that there are two possible mappings:
			 *   - as an OML TerminologyBox (lifting instances to a vocabulary)
			 *   - as an OML DescriptionBox (converting DSL elements to OML instances).
			 *
			 * Synopsis (in generated xcore):
			 *
			 * @OMLProvenance(kind="<OML term metaclass>", iri="<OML term IRI>")
			 * <xcore term definition>
			 */
			annotation "http://imce.jpl.nasa.gov/oml/runtime/OMLProvenance" as OMLProvenance
			
			/*
			 * OML provides the flexibility to specify the binding of an OML DataRange to a particular implementation with this annotation.
			 * OML DataRanges are specified according to the restrictions of the OWL2-DL datatype map, which includes
			 * a subset of XML Schema 1.1 datatypes (e.g., xsd:decimal, xsd:integer, xsd:int, xsd:long, ...)
			 * Some numeric datatypes like xsd:decimal, owl:rational, owl:real allow for numbers represented with arbitrarily long strings.
			 * Unfortunately most binding implementationd, including the Java XML Binding (JAXB) use finite-precision 
			 * numbers (even java.math.BigDecimal!). This means that in special cases where, e.g., a 40-digit xsd:decimal is needed,
			 * such implementations would either loose some information or produce errors.
			 * Instead of a fixed datatype binding to a limited implementation capability, this annotation allows
			 * an OML vocabulary designer to customize the binding individual OML DataRanges.
			 *
			 * Synopsis (in oml source):
			 *
			 * annotationProperty oml:JavaDatatypeBinding = <http://imce.jpl.nasa.gov/oml/runtime/OML2JavaDatatypeBinding>
			 *
			 * @oml:JavaDatatypeBinding(type="<java datatype qualified name>")
			 * <oml datarange kind> <datarange name> { ... }
			 *
			 * (in generated xcore):
			 *
			 * @OMLProvenance(kind="<OML datarange metaclass>", iri="<OML datarange IRI>")
			 * type <OML datarange name> wraps <java datatype qualified name>
			 *
			 */
			annotation "http://imce.jpl.nasa.gov/oml/runtime/OML2JavaDatatypeBinding" as OML2JavaDatatypeBinding
						
			«body»
		'''

		def protected convertToPackage(TerminologyBox terminology) '''
			@Ecore(
				nsURI="«packageNsURI»"
			)
			@GenModel(
				copyrightText="\nCopyright 2017 California Institute of Technology (\"Caltech\").\nU.S. Government sponsorship acknowledged.\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n     http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.\n",
				modelPluginVariables="org.eclipse.xtext.xbase.lib org.eclipse.emf.ecore.xcore.lib org.eclipse.emf.cdo",
				rootExtendsClass="org.eclipse.emf.internal.cdo.CDOObjectImpl",
				rootExtendsInterface="org.eclipse.emf.cdo.CDOObject",
				childCreationExtenders="true",
				complianceLevel="8.0",
				featureDelegation="None",
				modelDirectory="/«packageQName»/src-gen/",
				editDirectory="/«packageEQName»/src-gen",
				editPluginClass="«packageEQName».BundleEditPlugin"
			)
			package «packageTName»
		'''

		def protected convertToImports(TerminologyBox terminology) '''
			«FOR anImport : imports.values.sort AFTER '\n'»
				import «anImport»
			«ENDFOR»
		'''

		def protected convertToBody(TerminologyBox terminology) '''
			«FOR type : terminology.boxStatements.filter(Term).sortBy[validName] SEPARATOR '\n'»
				«type.convertToType»
			«ENDFOR»
		'''

		def protected dispatch convertToType(ScalarOneOfRestriction range) '''
			«val axioms = allTBoxStatementsOfType(ScalarOneOfLiteralAxiom).filter[a|a.axiom === range]»
			enum «range.name()» {
				«FOR literal : axioms.sortBy[value]»
					«literal.value»
				«ENDFOR»
			} 
		'''

		def String lookupOML2JavaDatatypeBinding(DataRange range) {
			range.tbox.annotations.findFirst [
				subject == range && property.iri == "http://imce.jpl.nasa.gov/oml/runtime/OML2JavaDatatypeBinding"
			]?.value ?: 'java.lang.String'
		}

		def String facet(DataRange range, EAttribute facet) {
			if (!range.eIsSet(facet))
				''
			else 
			'''
			@ExtendedMetaData(key="«facet.name»",value="«range.eGet(facet)»")
			'''
		}

		def String facets(DataRange range, EAttribute ... facets) {
			val buff = new StringBuffer()
			buff.append(
			'''
			@OMLProvenance(kind="«range.eClass.name»",iri="«range.iri»")
			''')
			for (f: facets) {
				val ext = facet(range, f)
				if (!ext.empty)	{
					buff.append(ext)
				}
			}
			buff.toString
		}

		def protected dispatch convertToType(BinaryScalarRestriction range) '''
			«facets(
				range, 
				TerminologiesPackage.eINSTANCE.binaryScalarRestriction_Length,
				TerminologiesPackage.eINSTANCE.binaryScalarRestriction_MinLength,
				TerminologiesPackage.eINSTANCE.binaryScalarRestriction_MaxLength)»
			type «range.validName» wraps «range.lookupOML2JavaDatatypeBinding»
		'''

		def protected dispatch convertToType(IRIScalarRestriction range) '''
			«facets(
				range, 
				TerminologiesPackage.eINSTANCE.IRIScalarRestriction_Length,
				TerminologiesPackage.eINSTANCE.IRIScalarRestriction_MinLength,
				TerminologiesPackage.eINSTANCE.IRIScalarRestriction_MaxLength,
				TerminologiesPackage.eINSTANCE.IRIScalarRestriction_MaxLength)»
			type «range.validName» wraps «range.lookupOML2JavaDatatypeBinding»
		'''

		def protected dispatch convertToType(NumericScalarRestriction range) '''
			«facets(
				range, 
				TerminologiesPackage.eINSTANCE.numericScalarRestriction_MinInclusive,
				TerminologiesPackage.eINSTANCE.numericScalarRestriction_MaxInclusive,
				TerminologiesPackage.eINSTANCE.numericScalarRestriction_MinExclusive,
				TerminologiesPackage.eINSTANCE.numericScalarRestriction_MaxExclusive)»
			type «range.validName» wraps «range.lookupOML2JavaDatatypeBinding»
		'''

		def protected dispatch convertToType(PlainLiteralScalarRestriction range) '''
			«facets(
				range, 
				TerminologiesPackage.eINSTANCE.plainLiteralScalarRestriction_Length,
				TerminologiesPackage.eINSTANCE.plainLiteralScalarRestriction_MinLength,
				TerminologiesPackage.eINSTANCE.plainLiteralScalarRestriction_MaxLength,
				TerminologiesPackage.eINSTANCE.plainLiteralScalarRestriction_Pattern,
				TerminologiesPackage.eINSTANCE.plainLiteralScalarRestriction_LangRange)»
			type «range.validName» wraps «range.lookupOML2JavaDatatypeBinding»
		'''

		def protected dispatch convertToType(Scalar scalar) '''
			@OMLProvenance(kind="«scalar.eClass.name»",iri="«scalar.iri»")
			type «scalar.validName» wraps «scalar.lookupOML2JavaDatatypeBinding»
		'''

		def protected dispatch convertToType(StringScalarRestriction range) '''
			«facets(
				range, 
				TerminologiesPackage.eINSTANCE.stringScalarRestriction_Length,
				TerminologiesPackage.eINSTANCE.stringScalarRestriction_MinLength,
				TerminologiesPackage.eINSTANCE.stringScalarRestriction_MaxLength,
				TerminologiesPackage.eINSTANCE.stringScalarRestriction_Pattern)»
			type «range.validName» wraps «range.lookupOML2JavaDatatypeBinding»
		'''

		def protected dispatch convertToType(SynonymScalarRestriction range) '''
			@OMLProvenance(kind="«range.eClass.name»",iri="«range.iri»")
			type «range.validName» wraps «range.lookupOML2JavaDatatypeBinding»
		'''

		def protected dispatch convertToType(TimeScalarRestriction range) '''
			«facets(
				range, 
				TerminologiesPackage.eINSTANCE.timeScalarRestriction_MinInclusive,
				TerminologiesPackage.eINSTANCE.timeScalarRestriction_MaxInclusive,
				TerminologiesPackage.eINSTANCE.timeScalarRestriction_MinExclusive,
				TerminologiesPackage.eINSTANCE.timeScalarRestriction_MaxExclusive)»
			type «range.validName» wraps «range.lookupOML2JavaDatatypeBinding»
		'''

		def protected dispatch convertToType(Structure structure) '''
			@OMLProvenance(kind="«structure.eClass.name»",iri="«structure.iri»")
			class «structure.validName» extends «OMLRuntimePackage.Literals.OML_STRUCTURE.imported»
			{
				«structure.dataProperties»			
			}
		'''

		def protected dispatch convertToType(Aspect aspect) '''
			@OMLProvenance(kind="«aspect.eClass.name»",iri="«aspect.iri»")
			interface «aspect.validName» «aspect.extendedTypes»
			{
				«aspect.dataProperties»
				«aspect.entityOperations»
			}
		'''

		def protected dispatch convertToType(Concept concept) '''
			@OMLProvenance(kind="«concept.eClass.name»",iri="«concept.iri»")
			class «concept.validName» «concept.extendedTypes»
			{
				«concept.dataProperties»
				«concept.entityProperties»
				«concept.entityOperations»
			}
		'''

		def protected dispatch convertToType(ReifiedRelationship relationship) '''
			@OMLProvenance(kind="«relationship.eClass.name»",iri="«relationship.iri»")
			class «relationship.validName» «relationship.extendedTypes»
			{
				«relationship.dataProperties»
				«relationship.entityProperties»
				«val superClasses = allTBoxStatementsOfType(ReifiedRelationshipSpecializationAxiom).filter[subRelationship == relationship].map[superRelationship]»
				«IF superClasses.empty || superClasses.get(0).source!=relationship.source»			
					op «relationship.source.imported» getOmlSource() {
						super.omlSource as «relationship.source.imported»
					}
					op void setOmlSource(«'gov.nasa.jpl.imce.oml.runtime.OMLEntity'.imported» source) {
						if (source!==null && !(source instanceof «relationship.source.imported»))
							throw new «'java.lang.IllegalArgumentException'.imported»
						super.omlSource = source
					}
				«ENDIF»
				«IF superClasses.empty || superClasses.get(0).target!=relationship.target»			
					op «relationship.target.imported» getOmlTarget() {
						super.omlTarget as «relationship.target.imported»
					}
					op void setOmlTarget(«'gov.nasa.jpl.imce.oml.runtime.OMLEntity'.imported» target) {
						if (target!==null && !(target instanceof «relationship.target.imported»))
							throw new «'java.lang.IllegalArgumentException'.imported»
						super.omlTarget = target
					}
				«ENDIF»
				«relationship.entityOperations»
			}
		'''

		def protected dispatch convertToType(Term t) '''
			// «t.eClass.name»: «t.name()»
		'''

		def protected dispatch extendedTypes(Aspect aspect) {
			val types = new ArrayList<String>()
			types.addAll(allTBoxStatementsOfType(AspectSpecializationAxiom).filter[subEntity == aspect].map [
				superAspect.imported
			].sort)
			if(types.empty) types.add(OMLRuntimePackage.Literals.OML_ASPECT.imported)
			types.convertToExtends
		}

		def protected dispatch extendedTypes(Concept concept) {
			val types = new ArrayList<String>()
			types.addAll(allTBoxStatementsOfType(ConceptSpecializationAxiom).filter[subConcept == concept].map [
				superConcept.imported
			].sort)
			if(types.empty) types.add(OMLRuntimePackage.Literals.OML_CONCEPT.imported)
			types.addAll(allTBoxStatementsOfType(AspectSpecializationAxiom).filter[subEntity == concept].map [
				superAspect.imported
			].sort)
			types.convertToExtends
		}

		def protected dispatch extendedTypes(ReifiedRelationship relationship) {
			val types = new ArrayList<String>()
			types.addAll(allTBoxStatementsOfType(ReifiedRelationshipSpecializationAxiom).filter [
				subRelationship == relationship
			].map[superRelationship.imported].sort)
			if(types.empty) types.add(OMLRuntimePackage.Literals.OML_REIFIED_RELATIONSHIP.imported)
			types.addAll(allTBoxStatementsOfType(AspectSpecializationAxiom).filter[subEntity == relationship].map [
				superAspect.imported
			].sort)
			types.convertToExtends
		}

		def protected dispatch dataProperties(Structure structure) '''
			«FOR property : allTBoxStatementsOfType(ScalarDataProperty).filter[domain == structure].sortBy[name()]»
				«property.dataContainer»«property.range.imported»[1] «property.validName»
			«ENDFOR»
			«FOR property : allTBoxStatementsOfType(StructuredDataProperty).filter[domain == structure].sortBy[name()]»
				contains «property.dataContainer»«property.range.imported»[1] «property.validName»
			«ENDFOR»
		'''

		def protected dispatch dataProperties(Entity entity) '''
			«FOR property : allTBoxStatementsOfType(EntityScalarDataProperty).filter[domain == entity].sortBy[name()]»
				@OMLProvenance(kind="«property.eClass.name»",iri="«property.iri»")
				«property.dataContainer»«property.range.imported»[1] «property.validName»
			«ENDFOR»
			«FOR property : allTBoxStatementsOfType(EntityStructuredDataProperty).filter[domain == entity].sortBy[name()]»
				@OMLProvenance(kind="«property.eClass.name»",iri="«property.iri»")
				contains «property.dataContainer»«property.range.imported»[1] «property.validName»
			«ENDFOR»
		'''

		def protected dataContainer(DataRelationship dr) {
			switch dr.target {
				ScalarOneOfRestriction:
					''
				default:
					''
			}
		}

		def protected entityProperties(Entity entity) '''
			«FOR property : allTBoxStatementsOfType(UnreifiedRelationship).filter[source == entity].sortBy[name()]»
				@OMLProvenance(kind="«property.eClass.name»",iri="«property.iri»")
				refers «property.target.imported»[1] «property.validName»
			«ENDFOR»
		'''

		def protected entityOperations(Entity entity) '''
			«FOR relationship : allTBoxStatementsOfType(ReifiedRelationship).filter[source == entity].sortBy[targetName]»
				op «relationship.target.imported»«IF !relationship.isIsFunctional»[]«ENDIF» «relationship.targetName»() {
					omlInverseReferencers(«relationship.imported»).filter[omlSource === this].map[omlTarget].toEList«IF relationship.isIsFunctional».findFirst[true]«ENDIF»
				}
			«ENDFOR»			
			«FOR relationship : allTBoxStatementsOfType(ReifiedRelationship).filter[target == entity && unreifiedInversePropertyName !== null].sortBy[sourceName]»
				op «relationship.source.imported»«IF !relationship.isIsInverseFunctional»[]«ENDIF» «relationship.sourceName»() {
					omlInverseReferencers(«relationship.imported»).filter[omlTarget === this].map[omlSource].toEList«IF relationship.isIsInverseFunctional».findFirst[true]«ENDIF»
				}
			«ENDFOR»			
			«FOR axiom : allTBoxStatementsOfType(EntityUniversalRestrictionAxiom).filter[restrictedDomain == entity && restrictedRelation.isIsFunctional].sortBy[restrictedRange.toFirstLower]»
				@OMLProvenance(kind="«axiom.eClass.name»",restrictedDomain="«axiom.restrictedDomain.abbrevIRI»",restrictedRelation="«axiom.restrictedRelation.abbrevIRI»",restrictedRange="«axiom.restrictedRange.abbrevIRI»")
				op «axiom.restrictedRange.imported» «axiom.restrictedRange.toFirstLower»() {
					omlInverseReferencers(«axiom.restrictedRelation.imported»).filter[omlSource === this].map[omlTarget].findFirst[true] as «axiom.restrictedRange.imported»
				}
			«ENDFOR»			
			«FOR axiom : allTBoxStatementsOfType(EntityUniversalRestrictionAxiom).filter[restrictedRange == entity && restrictedRelation.hasRelationshipInverse && restrictedRelation.isIsInverseFunctional].sortBy[restrictedDomain.toFirstLower]»
				@OMLProvenance(kind="«axiom.eClass.name»",restrictedDomain="«axiom.restrictedDomain.abbrevIRI»",restrictedRelation="«axiom.restrictedRelation.abbrevIRI»",restrictedRange="«axiom.restrictedRange.abbrevIRI»")
				op «axiom.restrictedDomain.imported» «axiom.restrictedDomain.toFirstLower»() {
					omlInverseReferencers(«axiom.restrictedRelation.imported»).filter[omlTarget === this].map[omlSource].findFirst[true] as «axiom.restrictedDomain.imported»
				}
			«ENDFOR»			
		'''

		def protected convertToExtends(Collection<String> types) '''
		«IF (!types.isEmpty)»
			extends «types.join(', ')» 
		«ENDIF»'''

		def protected Boolean hasRelationshipInverse(EntityRelationship relationship) {
			switch relationship {
				ReifiedRelationship:
					relationship.unreifiedInversePropertyName !== null
				default:
					false
			}
		}

		def protected sourceName(ReifiedRelationship relationship) {
			val s = switch s : relationship.unreifiedInversePropertyName {
				case null:
					''
				case s.length > 0:
					s.toFirstLower
				default:
					s
			}
			return if(xCoreKeywords.contains(s)) '^' + s else s
		}

		def protected targetName(ReifiedRelationship relationship) {
			val s = switch s : relationship.name() {
				case null:
					''
				case s.length > 0:
					s.toFirstLower
				default:
					s
			}
			return if(xCoreKeywords.contains(s)) '^' + s else s
		}

		def protected toFirstLower(Term term) {
			val s = switch s : term.name() {
				case null:
					''
				case s.length > 0:
					s.toFirstLower
				default:
					s
			}
			return if(xCoreKeywords.contains(s)) '^' + s else s
		}

		def protected qualifieddName(Term term) {
			val simpleName = term.name()
			val packageQName = term.tbox.validQName
			packageQName + '.' + simpleName
		}

		def protected <T extends TerminologyBoxAxiom> Iterable<T> allTBoxAxiomsOfType(Class<T> type) {
			terminologies.map[boxAxioms].flatten.filter(type)
		}

		def protected <T extends TerminologyBoxStatement> Iterable<T> allTBoxStatementsOfType(Class<T> type) {
			terminologies.map[boxStatements].flatten.filter(type)
		}

		def toFirstUpper(String s) {
			Character.toUpperCase(s.charAt(0)) + s.substring(1)
		}

		def toFirstLower(String s) {
			Character.toLowerCase(s.charAt(0)) + s.substring(1)
		}
	}

	def protected static dispatch validName(DataRelationship dr) {
		switch s : dr.name() {
			case null:
				''
			default: {
				var valid = s.replaceAll("[\\. -]", "_")
				if (valid.matches("^[0-9].*")) {
					valid = "_" + valid
				}
				if(xCoreKeywords.contains(valid)) '^' + valid else valid
			}
		}
	}

	def protected static dispatch validName(UnreifiedRelationship dr) {
		switch s : dr.name() {
			case null:
				''
			default: {
				var valid = s.replaceAll("[\\. -]", "_")
				if (valid.matches("^[0-9].*")) {
					valid = "_" + valid
				}
				if(xCoreKeywords.contains(valid)) '^' + valid else valid
			}
		}
	}

	def protected static dispatch validName(Term type) {
		switch s : type.name() {
			case null:
				''
			default:
				s.toFirstUpper
		}
	}

	def protected static dispatch validName(TerminologyBox terminology) {
		terminology.name.legalName
	}

	def protected static validQName(TerminologyBox terminology) {
		val iri = terminology.iri()
		val qname = OMLExtensions.convertIRItoNamespace(iri)
		qname
	}
	
	def protected static legalName(String name) {
		var valid = name
		if (valid.length > 0) {
			valid = valid.replaceAll("[ -]", "_")
		}
		if (valid.matches("^[0-9].*")) {
			valid = "_" + valid
		}
		valid
	}

}
