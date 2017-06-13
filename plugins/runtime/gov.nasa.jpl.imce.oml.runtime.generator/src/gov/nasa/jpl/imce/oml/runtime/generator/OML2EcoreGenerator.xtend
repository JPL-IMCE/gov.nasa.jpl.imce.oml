package gov.nasa.jpl.imce.oml.runtime.generator

import gov.nasa.jpl.imce.oml.model.common.Extent
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox
import gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyContext
import gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue
import gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple
import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions
import gov.nasa.jpl.imce.oml.model.terminologies.DataRelationship
import gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship
import gov.nasa.jpl.imce.oml.runtime.OMLConcept
import gov.nasa.jpl.imce.oml.runtime.OMLDescription
import gov.nasa.jpl.imce.oml.runtime.OMLEntity
import gov.nasa.jpl.imce.oml.runtime.OMLReifiedRelationship
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimeFactory
import gov.nasa.jpl.imce.oml.runtime.OMLStructure
import java.io.File
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet

class OML2EcoreGenerator {

	extension OMLExtensions = new OMLExtensions
	var Set<DescriptionBox> allDboxes
	var Map<ConceptualEntitySingletonInstance, OMLEntity> mapping
	
	static val xCoreKeywords = newArrayList('refers', 'contains', 'extends', 'imports', 'id')

	def generate(File file, IPath parentPath) {
		this.mapping = new HashMap<ConceptualEntitySingletonInstance, OMLEntity>();
		this.allDboxes = new HashSet<DescriptionBox>();
		val rs = new XtextResourceSet
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		val uri = URI.createFileURI(file.getPath())
		val resource = rs.getResource(uri, true)
		if (!resource.contents.empty) {
			val outResourceSet = new ResourceSetImpl();
			var extent = resource.contents.get(0) as Extent;
			val dBoxes = extent.modules.filter(DescriptionBox)
			for (dBox : dBoxes) {
				allDboxes.addAll(dBox.allImportedDescriptions)
			}
			for (description : allDboxes) {
				val filename = description.validQName + ".omlruntime"
				val path = parentPath.append('/'+filename)
				val outResource = outResourceSet.createResource(URI.createPlatformResourceURI(path.toString, true));
				System.out.println("generating: " + filename)
				val contents = new DescriptionToEcoreGenerator(this, description).generate
				outResource.contents += contents
			}
			for (instance : mapping.keySet) {
				if (instance instanceof ReifiedRelationshipInstance) {
					val reifiedRelationInstance = instance as ReifiedRelationshipInstance
					val omlReifiedRelationship = mapping.get(instance) as OMLReifiedRelationship
					omlReifiedRelationship.omlSource = mapping.get(getDomain(reifiedRelationInstance))
					omlReifiedRelationship.omlTarget = mapping.get(getRange(reifiedRelationInstance))
				}
			}
			for (outResource : outResourceSet.resources) {
				outResource.save(emptyMap)			
			}
		}
	}

	private static class DescriptionToEcoreGenerator {

		val OML2EcoreGenerator generator
		val DescriptionBox description
		
		new(OML2EcoreGenerator generator, DescriptionBox description) {
			this.generator = generator
			this.description = description
		}
		
		def OMLDescription generate() {
			val omlDescription = OMLRuntimeFactory.eINSTANCE.createOMLDescription();
			omlDescription.omlIRI = description.getIri
			omlDescription.omlContents += description.conceptInstances.map[doGenerate]
			omlDescription.omlContents += description.reifiedRelationshipInstances.map[doGenerate]
			omlDescription
		}
		
		def dispatch OMLConcept doGenerate(ConceptInstance instance) {
			val className = instance.singletonConceptClassifier.getName
			val nsUri = instance.singletonConceptClassifier.tbox.getIri
			val omlConcept = doGenerate(instance, className, nsUri) as OMLConcept
			omlConcept
		}
				
		def dispatch OMLReifiedRelationship doGenerate(ReifiedRelationshipInstance instance) {
			val className = instance.singletonReifiedRelationshipClassifier.getName
			val nsUri = instance.singletonReifiedRelationshipClassifier.tbox.getIri
			val omlReifiedRelationship = doGenerate(instance, className, nsUri) as OMLReifiedRelationship
			omlReifiedRelationship
		}

		def OMLEntity doGenerate(ConceptualEntitySingletonInstance instance, String className, String nsUri) {
			val package = EPackage.Registry.INSTANCE.getEPackage(nsUri)
			val factory = EPackage.Registry.INSTANCE.getEFactory(nsUri)
			val class = package.EClassifiers.findFirst[name==className] as EClass
			val omlEntity = factory.create(class) as OMLEntity
			omlEntity.omlName = instance.getName
			for (scalarPropertyValue : instance.getScalarPropertyValues) {
				val attributeName = scalarPropertyValue.scalarDataProperty.validName
				val attribute = class.EAllAttributes.findFirst[name==attributeName]
				omlEntity.eSet(attribute, scalarPropertyValue.getPropertyValue);
			}
			for (structurePropertyValue : instance.getStructurePropertyValues) {
				val referenceName = structurePropertyValue.structuredDataProperty.validName
				val reference = class.EAllReferences.findFirst[name==referenceName]
				omlEntity.eSet(reference, structurePropertyValue.getPropertyValue);
			}
			generator.mapping.put(instance, omlEntity)
			omlEntity
		}

		def Iterable<SingletonInstanceScalarDataPropertyValue> getScalarPropertyValues(ConceptualEntitySingletonInstance instance) {
			generator.allDboxes.map[singletonScalarDataPropertyValues].flatten.filter[singletonInstance == instance]
		}
	
		def Iterable<SingletonInstanceStructuredDataPropertyValue> getStructurePropertyValues(ConceptualEntitySingletonInstance instance) {
			generator.allDboxes.map[singletonStructuredDataPropertyValues].flatten.filter[singletonInstance == instance]
		}
	
		def String getPropertyValue(SingletonInstanceScalarDataPropertyValue propertyValue) {
			propertyValue.scalarPropertyValue
		}
		
		def String getPropertyValue(ScalarDataPropertyValue propertyValue) {
			propertyValue.scalarPropertyValue
		}

		def OMLStructure getPropertyValue(SingletonInstanceStructuredDataPropertyContext propertyValue) {
			val className = propertyValue.structuredDataProperty.range.getName
			val nsUri = propertyValue.structuredDataProperty.range.tbox.getIri
			val package = EPackage.Registry.INSTANCE.getEPackage(nsUri)
			val factory = EPackage.Registry.INSTANCE.getEFactory(nsUri)
			val class = package.EClassifiers.findFirst[name==className] as EClass
			val omlStructure = factory.create(class) as OMLStructure
			for (scalarPropertyValue : propertyValue.scalarDataPropertyValues) {
				val attributeName = scalarPropertyValue.scalarDataProperty.validName
				val attribute = class.EAllAttributes.findFirst[name==attributeName]
				omlStructure.eSet(attribute, scalarPropertyValue.getPropertyValue);
			}
			for (structurePropertyTuple : propertyValue.structuredPropertyTuples) {
				val referenceName = structurePropertyTuple.structuredDataProperty.validName
				val reference = class.EAllReferences.findFirst[name==referenceName]
				omlStructure.eSet(reference, structurePropertyTuple.getPropertyValue);
			}
			omlStructure
		}
		
	}

	def ConceptualEntitySingletonInstance getDomain(ReifiedRelationshipInstance instance) {
		allDboxes.map[reifiedRelationshipInstanceDomains].flatten.findFirst[reifiedRelationshipInstance == instance].domain
	}

	def ConceptualEntitySingletonInstance getRange(ReifiedRelationshipInstance instance) {
		allDboxes.map[reifiedRelationshipInstanceRanges].flatten.findFirst[reifiedRelationshipInstance == instance].range
	}

	def protected static validQName(DescriptionBox description) {
		val iri = description.iri()
		val qname = OMLExtensions.convertIRItoNamespace(iri)
		qname
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
				valid
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
}