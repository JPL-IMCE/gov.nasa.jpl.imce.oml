# gov.nasa.jpl.imce.oml.serialization.tests

## Writing OMLZip Serialization/Load Comparison Unit Tests

The [OMLSaveLoadComparisonTest](/src/gov/nasa/jpl/imce/oml/serialization/tests/OMLSaveLoadComparisonTest.xtend) facilitates writing such unit tests.

For example, the following code:

```
class OMLZipTests extends OMLSaveLoadComparisonTest {
	
	static def Pair<URI,Extent>[] example1() {
        val extent = createExtent
        
        val tbox1 = createTerminologyGraph
        tbox1.extent = extent
        tbox1.iri = "http://test"
        
        val concept1 = createConcept
        concept1.name = "Concept1"
        concept1.tbox = tbox1
        
        return #[ new Pair<URI,Extent>(URI.createURI(tbox1.iri()), extent) ]
	}
	
	@Test
	def void test1() {
		compareSavedAndLoaded(example1)
	}
}
```

yields the following OML TerminologyGraph (in textual syntax):

```
open terminology <http://test> {

  concept Concept1

}
```

This unit test serializes the above in the OMLZip tabular representation: a zip archive of 66 Json-lines files.
In this example, only 2 of the 66 Json-lines files are non-empty in the OMLZip serialization:

`TerminologyGraphs.json` contains:

```
{"uuid":"7f5eca4b-cbd8-5c7d-86e0-efbb0d2ec0a3","kind":"OpenWorldDefinitions","iri":"http://test"}
```

`Concepts.json` contains:

```
{"uuid":"63d547f6-544b-59ad-9701-a8f15494dbdb","tboxUUID":"7f5eca4b-cbd8-5c7d-86e0-efbb0d2ec0a3","name":"Concept1"}
```

