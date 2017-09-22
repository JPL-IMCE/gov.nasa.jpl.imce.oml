# Eclipse P2 Update Site for the Ontological Modeling Language Workbench

The OML Workbench update site is compatible with Eclipse Oxygen packages.


## Update Site locations

In Eclipse, add update sites for either:
- The OML Workbench update site: http://dl.bintray.com/jpl-imce/gov.nasa.jpl.imce.oml/0.9
- A local archive of the OML Workbench update site available from: https://bintray.com/jpl-imce/gov.nasa.jpl.imce.oml/gov.nasa.jpl.imce.oml.updatesite

## Development/Deployment notes

Bintray has the capability of "exploding" an archive on upload.
See: https://bintray.com/docs/api/#_content_uploading_publishing

Unfortunately, there is currently no support in Eclipse/Tycho for configuring
`distributionManagement` for different kinds of artifacts to upload (archives vs. non-archives).
See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=521444

The workaround is the following:

1) Let Eclipse/Tycho upload a zip archive of the update site: https://bintray.com/jpl-imce/gov.nasa.jpl.imce.oml/gov.nasa.jpl.imce.oml.updatesite

2) Download the update site archive

3) Re-zip the update site archive to include a version-specific folder

e.g.:

```
mkdir 0.9
unzip ~/Downloads/gov.nasa.jpl.imce.oml.updatesite-0.9.0.0-M10.zip
zip -r gov.nasa.jpl.imce.oml.updatesite-0.9.0.0-M10.zip 0.9
```

Use the [JFrog CLI](https://www.jfrog.com/getcli/) to upload and explode the rezipped archive *without* the override flag

```
jfrog bt u --explode true --publish true gov.nasa.jpl.imce.oml.updatesite-0.9.0.0-M10.zip jpl-imce/gov.nasa.jpl.imce.oml/gov.nasa.jpl.imce.oml.updatesite/0.9.0.0-M10
```

Adding the override flag will result in deleting the existing artifacts (ie., the update site archive).
Without the override flag, the update site will be published in both archived and exploded forms.
