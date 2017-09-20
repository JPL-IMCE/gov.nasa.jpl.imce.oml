# Eclipse P2 Update Site for the Ontological Modeling Language Workbench

The OML Workbench update site is compatible with Eclipse Neon.3 packages that do *NOT* include EMF Parsley 1.1.1.
EMF Parsley 1.1.1 is a feature included in the Eclipse Neon.3 Modeling package which includes Xtext 2.10.

However, OML Workbench requires Xtext 2.11. Since there is no available version of EMF Parsley for Xtext 2.11,
trying to install Xtext 2.11 or the OML Workbench into the Eclipse Neon.3 Modeling package will result in a conflict between:
- EMF Parsley 1.1.1 which requires Xtext 2.10
- OML Workbench which requires Xtext 2.11

## Update Site locations

In Eclipse, add update sites for:
- Xtext 2.11 (http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/)
	- Make sure Xtext 2.11 is installed properly before trying to install the OML Workbench.

- Sirius 4.1.6 http://download.eclipse.org/sirius/updates/releases/4.1.6/neon
    - See: https://wiki.eclipse.org/Sirius/Update_Sites
    
- The OML Workbench; either:
	- a local update side archive downloaded from here: https://bintray.com/jpl-imce/gov.nasa.jpl.imce.oml/gov.nasa.jpl.imce.oml.updatesite
	- the direct OML Workbench UpdateSite where the archive has been "exploded" on deployment here: https://dl.bintray.com/jpl-imce/gov.nasa.jpl.imce.oml
	
## Development/Deployment notes

Bintray has the capability of "exploding" an archive on upload.
See: https://bintray.com/docs/api/#_content_uploading_publishing
	
Unfortunately, a side-effect of this is that, while uploading an archive does result in exploding its contents on bintray,
uploading a non-archive file results in http 400 (Bad Request).
See for example: https://travis-ci.org/JPL-IMCE/gov.nasa.jpl.imce.oml/builds/268745668#L2859
	
These errors happened with the [pom.xml](pom.xml) configured with the following:

```
	<distributionManagement>
		<repository>
			<id>bintray</id>
			<url>https://api.bintray.com/content/jpl-imce/gov.nasa.jpl.imce.oml/${project.artifactId}/${project.version};publish=1;override=0;explode=1</url>
		</repository>
	</distributionManagement>
```

Unfortunately, it is very difficult to find whether there is a way to use Maven and/or Eclipse/Tycho to deploy artifact files
to different repositories according to whether the file is an archive (i.e., use a bintray repository with the "explode=1" option)
or not (i.e., use a bintray repository with the "explode=0" option).

So, for now, the solution involves uploading the P2 update site archive outside of Eclipse/Tycho using Bintray's "explode=1" option.
