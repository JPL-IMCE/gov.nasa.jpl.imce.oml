# Xcore-based runtime for DSL-specific metamodels lifted from OML Bundles

### Restrictions on specifying DSLs in OML

- package names, class names, type names must be valid Java identifiers.

- The last segment of a package qualifier cannot begin with 'xml' regardless of lower/upper case letters
  (see: https://www.w3.org/TR/REC-xml-names/#xmlReserved)

### Limitations in Xcore

Although Xcore supports 