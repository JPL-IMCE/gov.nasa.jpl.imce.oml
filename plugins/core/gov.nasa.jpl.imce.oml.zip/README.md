# EMF Serialization for the Ontological Modeling Language

## GIT and *.omlzip files

For change management purposes, the `*.omlzip` serialization format yields the following benefits:

- Minimal, local formatting

  Every serialization involves some kind of formatting.
  XMI and XText serializations of OML involve global formatting:
  the serialization of OML ModuleElements is indented in the serialization of the containing OML Module.
  
  In contrast, `*.omlzip` uses local formatting because each OML object is serialized in a single [JSON line](http://jsonlines.org/).
  This local formatting is minimal because it involves a tuple of name/value pairs 
  where a value can be a string, a number, a boolean or null (no array values, no nested JSON objects). 
  
- Fast serialization

  Minimal, local formatting speeds up serialization because it eliminates the overhead
  of indentation inherent in global formatting.
  
- Simple & precise comparisons

  Global formatting complicates comparison because there are two sources of differences to consider:
  - differences in the internal representation of an object
  - differences in the global context where an object is serialized
  
  The computational complexity of comparing globally formatted representation varies with the particular format.
  For OML, XMI and XText serializations are inherently tree-based serializations; that is, labeled, ordered trees.
  Many algorithms exists for comparing such trees; depending on the properties of the tree, their time complexity
  varies between `O(n^2 log^2_n)` and `O(n^4)`. The Robust Tree Edit Distance (RTED) algorithm achieves an optional
  worst-case complexity of `O(n^3)`.
  
  With `*.omlzip`, comparison has linear worst-case complexity of `O(n)` since each JSON-lines files
  is sorted and each line is flat ordered list of name/value pairs.
  Furthermore, each of the 66 JSON lines files corresponds to one of the 66 concrete OML metaclasses.
  Therefore, additions/deletions in a particular JSON lines file correspond 
  to creating/deleting instances of the corresponding OML concrete metaclass.
  
- GIT friendly

  To configure GIT for simple & precise comparison of `*.omlzip` files in a GIT project:

  - Add the following to `.git/config`:

  ```
  [diff "zip"]
    textconv = unzip -c -q
  ```

  - Add the following to `.gitattributes`:

  ```
  *.omlzip diff=zip
  ```

  ## EMF API for OMLZip
  
  Create an [OMLZipResourceSet](/src/gov/nasa/jpl/imce/oml/zip/OMLZipResourceSet.xtend) using an [OASIS XML Catalog](https://www.oasis-open.org/committees/entity/spec-2001-08-06.html) file.
  The operations `getResource(URI, boolean)` and `createResource(URI)` on this resource set return a [OMLZipResource](/src/gov/nasa/jpl/imce/oml/zip/OMLZipResource.xtend).
  For loading or saving such a resource, the `URI` is mapped to an `*.omlzip` file location according to the catalog.
  OML `ModuleEdge` target cross-reference `IRI`s are similarly mapped for resolving the referenced target OML `Module` to an `*.omlzip` file.
  
  ## Note about Raw String encoding in omlzip.
  
  The following OML Tables use a special encoding for raw strings in [OMLSpecificationTables](./src/gov/nasa/jpl/imce/oml/zip/OMLSpecificationTables.xtend):
  
  Regular Expression Patterns:
  
  - `IRIScalarRestriction.pattern`
  - `PlainLiteralScalarRestriction.pattern`
  - `StringScalarRestriction.pattern`
  
  Values:
  
  - `AnnotationPropertyValue.value`
  - `EntityScalarDataPropertyParticularRestrictionAxiom.literalValue`
  - `RestrictionScalarDataPropertyValue.scalarPropertyValue`
  - `ScalarDataPropertyValue.scalarPropertyValue`
  - `ScalarOneOfLiteralAxiom.value`
  - `SingletonInstanceScalarDataPropertyValue.scalarPropertyValue`
  
  