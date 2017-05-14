# Xcore specification for JPL's Ontological Modeling Language

## Notes about specifying the OML metamodel in Xcore

The OML metamodel is split into five small packages organized in a small tree
of acyclic package dependencies as shown below:

- [OML Common](src/main/resources/model/OMLCommon.xcore)

  `OML Common` defines common constructs for the other packages.
  
  - [OML Terminologies](src/main/resources/model/OMLTerminologies.xcore)
  
    `OML Terminologies` depends on `OML Common` to define constructs for specifying terminologies.
    
    - [OML Graphs](src/main/resources/model/OMLGraphs.xcore)
    
      `OML Graphs` depends on `OML Terminologies`. An `OML TerminologyGraph` specifies an open-world vocabulary
      that can extent vocabularies from other `OML Graphs`.
      
    - [OML Bundles](src/main/resources/model/OMLBundles.xcore)
    
      `OML Bundles` depends on `OML Terminologies`. An `OML Bundle` aggregates the vocabulary of other `OML Terminologies`
      and optionally specifies a limited form of closed-world semantics via disjunctions axioms among `OML Concepts`.
      
    - [OML Descriptions](src/main/resources/model/OMLDescriptions.xcore)
  
      `OML Descriptions` depends on `OML Terminologies`. An `OML DescriptionBox` specifies a partial or complete
      description of instances of `OML Terms` defined in a closed-world `OML Bundle`.

### [Cross-reference properties](https://wiki.eclipse.org/Xcore#Specifying_a_Cross_Reference)

An `Xcore` cross-reference is specified as a feature of an `Xcore` class with the following syntax: 

    `refers <type>[<multiplicity>] <referenceProperty>`
    
In OML, `<multiplicity>` is always `1`. This restriction is necessary to map the Xcore metamodel 
to a normalized relational database schema (4th or 5th normal form) and to an immutable, functional metamodel.

### [Derived features](https://wiki.eclipse.org/Xcore#Specifying_a_Derived_Feature)

The EMF Xcore UI 1.4.0 editor allows specifying a derived feature in two ways:

    `derived <type> <name>`
    
    `derived <type> <name> get { <expression> }`
    
The first form could be interesting if the derived feature could be specified in a specialized class.
Unfortunately, the generated code prevents this approach. Instead use the second form where `<expression>`
is a call to an operation that can be implemented in a specialized class.

### Beware of nullable EMF cross-references!

In EMF, a cross-reference property may be null regardless of its multiplicity.
With Xcore, Xtext and Xtend, this means that an expression of the form `a.b` 
where `a` is a cross-reference property will induce an NPE whenever `a` is null.

In OML, all such expressions use the Xtend elvis operator: `a?.b` or `a?.b ?: c`.
- Note that `a?.b` is equivalent to `a?.b ?: null`.
- Note that `?:` has lower priority than many other operators; this means it may necessary 
to add parentheses to ensure correct evaluation order.

    For example, `(a?x?:0) + (a?y?:0)` is not the same thing as `a?x?:0 + a?y?:0`.
    - In the former case, `(a?x?:0)` and `(a?y?:0)` are evaluated first and their result subsequently added.
    - In the latter case, `a?x` is evaluated, and it if is null, then the evaluation of `0 + a?y?:0` yields the result.
    
### Multiple code generation

There are 5 code generators that use the OML metamodel specification in Xcore as input:

1) The Eclipse Xcore code generator that produces the EMF-based OML metamodel API in Java.

2) An Xtend-based [gitbook glossary document generator](https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml.core/blob/master/gov.nasa.jpl.imce.oml.generators/src/gov/nasa/jpl/imce/oml/generators/OMLSpecificationDocGenerator.xtend)

3) An Xtend-based [normalized relational database schema generator](https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml.core/blob/master/gov.nasa.jpl.imce.oml.generators/src/gov/nasa/jpl/imce/oml/generators/OMLSpecificationTablesGenerator.xtend)

4) An Xtend-based [immutable, functional metamodel API generator](https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml.core/blob/master/gov.nasa.jpl.imce.oml.generators/src/gov/nasa/jpl/imce/oml/generators/OMLSpecificationResolverAPIGenerator.xtend)

5) An Xtend-based [immutable, functional metamodel implementation generator](https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml.core/blob/master/gov.nasa.jpl.imce.oml.generators/src/gov/nasa/jpl/imce/oml/generators/OMLSpecificationResolverLibraryGenerator.xtend)
