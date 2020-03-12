## Legacy OML (v0.9.7.5)

### Abstract syntax:
https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml/tree/master/plugins/gov.nasa.jpl.imce.oml.model/model

### Concrete syntax:
https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml/blob/master/plugins/gov.nasa.jpl.imce.oml.dsl/src/gov/nasa/jpl/imce/oml/dsl/OML.xtext

### Example vocabularies:
https://github.com/JPL-IMCE/gov.nasa.jpl.imce.ontologies.public/tree/feature/IMCEIS-1715-create-temporary-branch-of-ontologie/oml

## New OML (v0.5)

### Abstract syntax:
https://github.com/opencaesar/oml-server/blob/master/oml-server/io.opencaesar.oml/src/main/java/io/opencaesar/oml/Oml.xcore

### Concrete syntax:
https://github.com/opencaesar/oml-server/blob/master/oml-server/io.opencaesar.oml.dsl/src/main/java/io/opencaesar/oml/dsl/Oml.xtext

### Example vocabularies:
https://github.com/opencaesar/vocabularies/tree/master/src/main/oml

# High Level Comparison

| Criteria | Legacy OML | New OML |
| --- | --- | --- |
| Abstract Syntax | Abstract Classes (58)<br>Concrete Classes (80) | Abstract Classes (41)<br>Concrete Classes (63) |
| Textual Syntax | Similar to N-triples syntax<br>Less concise / readable | Similar to Turtle syntax<br>More concise / readable |
| Semantics | Equivalent mapping to OWL | Equivalent mapping to OWL |
| API | 5 EPackage APIs<br>Extensions API | 1 EPackage API<br>Read, Write, Index, Search, Visitor and Writer API |
| Packaging | Eclipse Updatesite | Eclipse Updatesite<br>Language Server (supporting LSP) |
| IDE | Eclipse | Eclipse<br>Any IDE supporting LSP (e.g., Theia, VSCode) |

# Mapping Overview

The following sections are meant to present a high level overview of the mapping between the Legacy OML and the New OML.

The detailed mapping between Legacy OML and new OML is given by the following transformation:

https://github.jpl.nasa.gov/imce-caesar/adapters.opencaesar/blob/master/legacy2oml/src/main/java/io/opencaesar/legacy2oml/Legacy2Oml.xtend

Note that the transformation is partial:
- Covers the subset of Vocabularies used by the IMCE vocabularies
- Does not cover Descriptions yet

# Literals

| Legacy OML | Examples | New OML | Examples |
| --- | --- | --- | ---
| LiteralBoolean | true<br>false | BooleanLiteral | true<br>false |
| LiteralDecimal | 23434343434343434343<br>2.3<br>-45.666666 | DecimalLiteral | 234343434343434343434<br>2.3<br>-45.666666 |
| LiteralFloat | 2.0<br>45.6 | DoubleLiteral<br>(64-bit) | 2.0<br>45.6 |
|   | | IntegerLiteral<br>(32-bit) | 2<br>456<br>-567
| LiteralQuoted<br>StringLiteralRawString<br>LiteralDateTime<br>LiteralUUID<br>LiteralURI<br>LiteralReal<br>LiteralRational | "abc"<br>'''hello'''<br>1956-06-25T04:00:00-05:00<br>uuid=487646ab-c6f6-45f6-be29-c12c45d64c29<br>http://opencaesar.github.io<br>23.4<br>4/5| QuotedLiteral | "abc"<br>'''hello'''<br>"1956-06-25T04:00:00-05:00"^^xsd:dateTime<br>"487646ab-c6f6-45f6-be29-c12c45d64c29"<br>"http://opencaesar.github.io"^^xsd:anyURI<br>"23.4"^^owl:real<br>"4/5"^^owl:rational

# Annotations

| Legacy OML | New OML |
| --- | --- |
| AnnotationProperty<br>AnnotationPropertyValue | AnnotationProperty<br>Annotation |
|   |   |

### Examples (Legacy OML)
```
annotationProperty rdfs:label=<http://www.w3.org/2000/01/rdfschema#label>

@rdfs:label="RDF Schema"
open terminology <http://www.w3.org/2000/01/rdf-schema> {
    @rdfs:label="Product"
    concept Product
} 
```

### Examples (New OML)
```
@rdfs:label "RDF Schema"
vocabulary <http://www.w3.org/2000/01/rdf-schema> with # as rdfs { 
    annotation property label
    
    @rdfs:label "Product"
    concept Product
    
    @deprecated   // this defaults to the boolean literal of true
    concept Function
    
    @color "Rouge"#fr // adds an annotation to a referenced element
    ref concept analysis:Activity
}
```

## Ontologies

| Legacy OML | New OML |
| --- | --- |
| TerminologyGraph <br>TerminologyKind | Vocabulary |
| Bundle | Bundle |
| DescriptionBox <br>DescriptionKind | Description |

### Examples (Legacy OML) 
```
open terminology <http://purl.org/dc/elements/1.1/> { … } 

closed bundle <http://project/bundle> { … }

partial description <http://europa/clipper> { … }
```

### Examples (New OML)
```
vocabulary <http://purl.org/dc/elements/1.1> with / as dc { … } 

bundle <http://project/bundle> with # as project { … }

description <http://europa/clipper> with # as clipper { … }

//Note: the <IRI> should not end with a fragment separator. The separator is specified with "with" keyword and can only be # or /
```

# Imports

| Legacy OML | New OML |
| --- | --- |
| TerminologyExtensionAxiom | VocabularyExtension<br>BundleExtension |
| BundledTerminologyAxiom | BundleInclusion |
| DescriptionBoxExtendsClosedWorldDefinitions<br>DescriptionBoxRefinement | DescriptionUsage<br>DescriptionExtension |
|   |   |

### Examples (Legacy OML)
```
open terminology <http://analysis> {
    extends <http://base>
    extends <http://base>
    …
}
```

### Examples (New OML)
```
vocabulary <http://analysis> with # as analysis {
    extends <../base/base.oml> 
    extends <../base/mission.oml>
    …
}

//Note: support for import with IRI is forthcoming in an upcoming revision
```

# Types

| Legacy OML | New OML |
| --- | --- |
| Concept | Concept |
| Aspect | Aspect |
| ReifiedRelationship<br>ReifiedRelationshipRestriction | RelationEntity |
| Structure | Structure |
| Scalar<br>BinaryScalarRestriction<br>IRIScalarRestriction<br>NumericScalarRestriction<br>PlainLiteralScalarRestriction<br>StringScalarRestriction<br>TimeScalar<br>RestrictionSynonymScalarRestriction | FacetedScalar (< Scalar) |
|   | ScalarOneOfRestriction<br>ScalarOneOfLiteralAxiom | EnumeratdScalar (< Scalar) |

### Examples (Legacy OML)
```
aspect Container
aspect ContainedElement
reified relation Contains {
    inverseFunctional
    asymmetric
    irreflexive
    unreified = contains
    inverse = isContainedIn
    source = Container
    target = ContainedElement
}
structure Point
numericScalarRestriction int {
    minInclusive -2147483648
    maxInclusive 2147483647
    restrictedRange long
}
scalarOneOfRestriction Color {
    restrictedRange XMLSchema:string
}
oneOf Color = "Red"
oneOf Color = "Blue"
```

### Examples (New OML)
```
 apect Container
 aspect ContainedElement
 relation entity Contains [
     from Container
     to ContainedElement
     forward contains
     inverse isContainedIn
     inverseFunctional
     asymmetric
     irreflexive
]
structure Point
scalar int :> long [
    minInclusive -2147483648
    maxInclusive 2147483647
]
enumerated scalar Color [
    "Red",
    "Blue"
]
 ```

# Relations and Properties

| Legacy OML | New OML |
| --- | --- |
| ForwardProperty<br>InverseProperty| ForwardRelation<br>InverseRelation |
| UnreifiedRelationship | ForwardRelation  |
| EntityScalarDataProperty<br>ScalarDataProperty | ScalarProperty |
| EntityStructuredDataProperty<br>StructuredDataProperty | StructuredProperty |

Note: New OML does not have an UnreifiedRelationship. All relations are reified by definition but youc can use them in either a reified or unreified fashion in descriptions.

### Examples (Legacy OML)
```
unreifiedRelationship contains {
    functional
    source= Container
    target= ContainedElement
}
entityScalarDataProperty + hasContainmentIndex { //this is a key property 
    domain ContainedElement
    range XMLSchema:string
}
structuredDataProperty x {
    domain ContainedElement
    range Point
}
```

### Examples (New OML)
```
relation  entity Contains [// all relations are reified
    from Container
    to ContainedElement
    forward contains   // this (and its inverse) are the unreified relationships
    function
]
scalar property hasContainmentIndex [
    domain ContainedElement
    range xsd:string
]
structured property x [
    domain ContainedElement
    range Point
]
aspect ContainedElement [
    key hasContainmentIndex // comma separated key properties
]
```

# Specialization Axioms

| Legacy OML | New OML |
| --- | --- |
| AspectSpecializationAxiom<br>ConceptSpecializationAxiom<br>ReifiedRelationshipSpecializationAxiom<br>SubObjectPropertyOfAxiom<br>SubDataPropertyOfAxiom | SpecializationAxiom |


### Examples (Legacy OML)
```
SuppliedElement extendsAspect ContainedElement
SuppliedElement extendsAspect IdentifiedElement
Rover extendsConcept mission:Componnet
Performs extendsRelationship Contains
ssn subDataPropertyOf id
coordinates subObjectPropertyOf location
scalarOneOfRestriction ID {
    restrictedRange XMLSchema:string
}

// structures are not specializable
```

### Examples (New OML)
```
aspect SuppliedElement :> ContainedElement, IdentifiedElement
concept Rover :> mission:Componnet
relation entity Performs :> Contains [...]
scalar property ssn :> id 
structured property coordinates :> location
scalar id :> xsd:string
structure 3DPoint :> 2DPoint

ref concept fse:Rover :> mission:Componnet
ref relation entity mission:Performs :> Runs
```

# Restriction Axioms

| Legacy OML | New OML |
| --- | --- |
| EntityExistentialRestrictionAxiom<br>EntityUniversalRestrictionAxiom<br>EntityScalarDataPropertyExistentialRestrictionAxiom<br>EntityScalarDataPropertyUniversalRestrictionAxiom | RelationRangeRestrictionAxiom<br>ScalarPropertyRangeRestrictionAxiom |
| CardinalityRestrictedConcept<br>CardinalityRestrictedAspect<br>CardinalityRestrictedReifiedRelationship<br>CardinalityRestrictionKind | RelationCardinalityRestrictionAxiom<br>CardinalityRestrictionKind |
| EntityScalarDataPropertyParticularRestrictionAxiom<br>EntityStructuredDataPropertyParticularRestrictionAxiom<br>RestrictionScalarDataPropertyValue<br>RestrictionStructuredDataPropertyTuple | ScalarPropertyValueRestrictionAxiom<br>StructuredPropertyValueRestrictionAxiom<br>ScalarPropertyValueAssertion<br>StructuredPropertyValueAssertion |

### Examples (Legacy OML)
```
concept Rover
RoverextendsConcept Component
someEntities Rover.Performs in Navigation
allEntities Rover.Contains in RoverComponent
someData Rover.mass in iso:kilograms
allData Rover.power in iso:kilowatt

// restricting structured property is not supported 

concept Rover <= 5 performs.Navigation1
concept Rover >= 2 performs.Navigation2
concept Rover== 3 performs.Navigation3

// this combines defining a concept with cardinality restriction with range restriction 

every Rover.mass= 50.0^^iso:kilogram
every Rover.startLocation= { x= 0 y= 0 }
```
### Examples (New OML)
```
concept Rover :> Component [
    restricts some relation performs to Navigation
    restricts all relation contains to RoverComponent
    restricts some scalar property mass to iso:kilogram
    restricts all scalar property power to iso:kilowatt
    restricts all structured property location to 3DPoint
]
structure USAddress :> Address [
    restricts all scalar property state to USState
]
ref concept Rover [
    restricts relation performs1 to max 5
    restricts relation performs2 to min 2 
    restricts relation performs3 to exactly 3
]
ref concept Rover [
    restricts scalar property mass to 50.0^^iso:kilogram
    restricts structured property startLocation to Point [ x 0 y 0]
]
```

# Rules

| Legacy OML | New OML |
| --- | --- |
| ChainRuleRule<br>BodySegment | Rule |
| ChainRule.head | RelationPredicate |
| SegmentPredicate.predicate | EntityPredicate<br>RelationPredicate |
| SegmentPredicate.inv | RelationPredicate |
| SegmentPredicate.source<br>SegmentPredicate.invSource<br>SegmentPredicate.target<br>SegmentPredicate.invTarget | RelationEntityPredicate |

## Legacy OML Example
```
rule R27511 infers hasElementBehavior
    if ElementBehaviorOwner 
    && hasElementBehaviorClass
    && AttributeAutomaton
    && hasRegion
    && AutomatonRegion
    && hasTransition
    && ElementBehaviorTransition
```

### Examples (New OML)
```
rule R27511 [
    ElementBehaviorOwner(x1) &
    hasElementBehaviorClass(x1 -> x2) &
    AttributeAutomaton(x2) &
    hasRegion(x2 -> x3) &
    AutomatonRegion(x3)  &
    hasTransition(x3 -> x4) &
    ElementBehaviorTransition(x4)
    => hasElementBehavior(x1 -> x4)
]
```

# Instances and Assertions

| Legacy OML | New OML |
| --- | --- |
| ConceptInstance | ConceptInstance |
| ReifiedRelationshipInstanc<br>ReifiedRelationshipInstanceDomain<br>ReifiedRelationshipInstanceRange | RelationInstance |
| UnreifiedRelationshipInstanceTuple | LinkAssertion |
| StructuredDataPropertyTuple<br>SingletonInstanceStructuredDataPropertyValue | StructuredPropertyValueAssertion |
| ScalarDataPropertyValue<br>SingletonInstanceScalarDataPropertyValue | ScalarPropertyValueAssertion |

### Examples (Legacy OML)
```
// in desc1.oml
conceptInstance (rover1 is-a fse:Rover)
rover1.fse:mass = 500^^iso:kilogram
rover1.fse:location = {
    x = 100
    y = 200
}
conceptInstance (navigation1 is-a fse:Navigation)
navigation1.fse:speed = 200^^iso:mph
reifiedRelationshipInstance (performs1 is-a fse:Performs)
domain (performs1) = rover1 
range (performs1) = navigation1
perform1.fse:startTime = "12:pm"^^XMLSchema:time

// in desc2.oml
conceptInstance (wheel1 is-a fse:Wheel)
wheel1.fse:pressure = 40.0
desc1:rover.fse:maxPower = 400.0^^iso:megawatt
tuple {
    unreifiedRelationship fse:contains
    domain desc1:rover1
    range wheel1
}
desc1:navigation1.fse:maxSpeed = 1000^^iso:kmph
```

### Examples (New OML)
```
// in desc1.oml
ci rover1 : fse:Rover [
    fse:mass 500^^iso:kilogram
    fse:location base:Point [ 
        x 100 
        y 200
    ]
]
ci navigation1 : fse:Navigation [
    fse:speed 200^^iso:mph
]
ri performs1 : fse:Performs [
    from rover1
    to navigation1
    fse:startTime "12:00pm"^^xsd:time
]

// in desc2.oml
ci wheel1 : fse:Wheel [
    fse:pressure 40.0
]
@rdfs:label "Rover1"
ref ci desc1:rover1 [
    fse:maxPower 400.0^^iso:megawatt
    fse:contains wheel1
]
ref ci desc1:navigation1 : fse:MechanicalNavigation [
    fse:maxSpeed 1000^^iso:kmph
]
```
# Reference

- New OML allows an ontology member to be referenced as a subject in axioms other than the defining one through the Reference class
- A reference can be created in the original ontology or another one
- Reference has a taxonomy that parallels the original one, i.e., there is a ConceptReference, AspectReference, RuleReference, etc.
- Each one of the Reference classes has a reference to the real element and other features that determine what can be extended about it
  - E.g., MemberReference.ownedAnnotations
  - E.g., SpecializedTermReference.ownedSpecializations
  - E.g., Entity.ownedRelationRestrictions

### Examples (New OML)
```
// in mission.oml
@rdfs:label "Environment"
concept Environment

// in behavior.oml 
@rdfs:label "BehavingElement"
aspect BehavingElement
@rdfs:comment "An environment is also a Behaving Element"
ref concept mission:Environment :> BehavingElement

// in description1.oml
@rdfs:label "Lab Equipment"
ci labMachine : mission:Component
@rdfs:label "Lab Environment"
ci labEnvironment : mission:Environment [
    influences labMachine
]

// in description2.oml
ci state1 : behavior:AutomatonState
ref ci description1:labEnvironment : behavior:AutomatonRegion [
    behavior:hasState state1
]
```

# Missing Legacy OML Features in New OML

| Area | Legacy OML | New OML |
| --- | --- | --- |
| Root of Resource | Extent (containing multiple ontologies) | Resource has one ontology as root |
| Root of Taxonomy | RootConceptTaxonomyAxiom | Not needed tooling concern |
| Bundle Disjunction Axiom | SpecificDisjointConceptAxiom<br>AnonymousConceptUnionAxiom | Such axioms are generated as part of the transformation to OWL only |
| Individual Enumeration | InstanceRelationshipEnumerationRestriction<br>InstanceRelationshipOneOfRestriction<br>InstanceRelationshipValueRestriction | Can we think of use cases for this? |
| Restrictions on Instances | InstanceRelationshipExistentialRangeRestriction<br>InstanceRelationshipUniversalRangeRestriction | Restrictions belong to Vocabularies not Descriptions! |
| Vocabulary Nesting | TerminologyNestingAxiom<br>ConceptDesignationTerminologyAxiom | Not sure about the semantics of this (is this a tooling concern only)? |

# API

| Legacy OML | New OML |
| --- | --- |
| gov.nasa.jpl.imce.oml.model.common.\* gov.nasa.jpl.imce.oml.model.terminologies.\* gov.nasa.jpl.imce.oml.model.graphs.\* gov.nasa.jpl.imce.oml.model.bundles.\* gov.nasa.jpl.imce.oml.model.descriptions.\* | io.New.oml.\* |
| gov.nasa.jpl.imce.oml.model.extensions.Extensions | io.New.oml.util.OmlRead io.New.oml.util.OmlIndex io.New.oml.util.OmlSearch io.New.oml.util.OmlWrite io.New.oml.util.OmlVisitor io.New.oml.util.OmlWriter |
| gov.nasa.jpl.imce.oml.model.extensions.OMLTables gov.nasa.jpl.imce.oml.model.extensions.Catalog gov.nasa.jpl.imce.oml.model.extensions.CatalogManager gov.nasa.jpl.imce.oml.model.extensions.CatalogURIConverter |   |

### Examples (New OML)
```
//  io.opencaesar.oml.*
concept.name
annotation.owningElement

// io.opencaesar.oml.util.OmlRead 
annotation.annotatedElement
ontologies.getDependeeOntologies

// io.opencaesar.oml.util.OmlIndex
entity.findRelationEntitiesWithSource
scalarProperty.findKeyAxiomWithProperty 

// io.opencaesar.oml.util.OmlSearch
element.findAnnotations
term.findSpecializedTerms

// io.opencaesar.oml.util.OmlWrite
OmlWrite.create(Class<T>)
Annotation.create

// io.opencaesar.oml.util.OmlVisitor
class Oml2Owl extends OmlVisitor {
    override caseAnnotation (Annotation annotation) {…}
    override caseVocabulary (Vocabulary vocabulary) {…}
}

// io.opencaesar.oml.util.OmlWriter
val writer= new OmlWriter (outputResourceSet)
writer.loadDependentResource (resourceURI)
writer.start
val vocabulary = oml.createVocabulary (iri, pefix, uri)
writer.addVocabularyExtension(vocabulary, extendedVocabularyIri)
writer.addConcept (vocabulary, conceptIri)
writer.addSpecializationAxiom (vocabulary, specializingIri, specializedIri)
writer.finish
writer.save(options)
``` 

### Example Adapters (New OML)
- Legacy2Oml : converts legacy OML models to new OML (written with OmlWriter API)
   - https://github.jpl.nasa.gov/imce-caesar/adapters.opencaesar/blob/master/legacy2oml/src/main/java/io/opencaesar/legacy2oml/Legacy2Oml.xtend
- Ecore2Oml: converts Ecore models to OML models (written with OmlWriter API)
   - https://github.com/opencaesar/ecore-adapter/blob/master/ecore-adapter/ecore2oml/src/main/java/io/opencaesar/ecore2oml/EcoreToOml.xtend
- Oml2Bikeshed: converts Oml models to Bikeshed specs
   - https://github.com/opencaesar/oml-bikeshed/blob/master/oml2bikeshed/src/main/java/io/opencaesar/oml2bikeshed/OmlToBikeshed.xtend
- Oml2Owl: converts Oml models to Owl models (written with OmlVisitor API)
   - https://github.com/opencaesar/owl-adapter/blob/master/owl-adapter/oml2owl/src/main/java/io/opencaesar/oml2owl/Oml2Owl.xtend
