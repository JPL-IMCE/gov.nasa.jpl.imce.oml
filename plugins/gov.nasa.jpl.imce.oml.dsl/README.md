# Xtext concrete syntax grammar for the Ontological Modeling Language

[W3C-compliant EBNF visualization of the Ontological Modeling Language EBNF grammar](doc/OML-EBNF-Description.xhtml)

This [W3C-compliant EBNF grammar](http://www.w3.org/TR/xquery/#EBNFNotation) was produced 
using [Gunther Rademacher's online converstion service](http://bottlecaps.de/convert/)
the Xtext-generated Antlr grammar from the 
[Ontological Modeling Language Xtext specification](src/gov/nasa/jpl/imce/oml/dsl/OntologicalModelingLanguage.xtext).

## OML & XText

There two Eclipse-based OML resource formats available:
- `*.oml` is the OML Xtext-based textual concrete syntax format.
- `*.omlzip` is the OML json-lines zip archive format.

An `XTextResourceSet` should be able to handle the `*.omlzip` format in addition to the XText-based `*.oml` format.
A non-`XTextResourceSet` should be able to handle the `*.omlzip` format but not the XText-based `*.oml` format.
An `OMLZipResourceSet` only handles the `*.omlzip` format.

## XText notes

### [Datatype rules](https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html#datatype-rules)

The Xtext documentation claims that Xtext's datatype rules are context-senstive.
In practice, this means that:
- Lexical tokens must be unambiguously parsed via context-free lexical rules.
- Values of datatypes may be parsed via (context-sensitive) parsing rules expressed in terms of (context-free) lexical tokens (or other datatype rules).

Unfortunately, this leaves unclear how to deal with the case where datatypes have overlapping sets of syntactic representations.
This case arises in OML with the syntax of positive numbers (i.e., `['0'..'9']+`) and decimals which includes hexadecimal numbers
and positive numbers possibly prefixed with a sign, possibly suffixed with an exponent or a radix. 

The solution to handle overlapping datatypes involves creating an abstract datatype for each overlap and disjoint subtypes for each non-overlapping sub-region.

For this example, i.e., `PositiveIntegerValue` and `DecimalValue`, the datatypes are as follows:

```
// corresponds to the disjoint union of the values parsed by the lexical rules DIGITS + DECIMAL
abstract class AbstractDecimalValue

// corresponds to the values parsed by the lexical rule DIGITS
class PositiveIntegerValue extends AbstractDecimalValue

// corresponds to the values parsed by the lexical rule DECIMAL excluding those parsed by the lexical rule DIGITS
class DecimalValue extends AbstractDecimalValue
```
