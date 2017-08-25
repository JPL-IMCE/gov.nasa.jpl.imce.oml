### Release process

```shell
export V=<major>.<minor>.<patch>.<build>
git branch releases/$V
git checkout releases/$V
mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=$V -Dtycho.mode=maven -Dproperties=oml.version 
git add -A
git commit -S -m"Release $V"
git push -u origin releases/$V
```

Verify the build on https://travis-ci.org/JPL-IMCE/gov.nasa.jpl.imce.oml.tycho
If successful, it should deploy the artifacts to https://bintray.com/jpl-imce/gov.nasa.jpl.imce/gov.nasa.jpl.imce.oml

The versioned artifacts are only uploaded to [bintray](https://bintray.com/jpl-imce/gov.nasa.jpl.imce/gov.nasa.jpl.imce.oml).

#### Manual publishing via the web UI

After uploading the artifacts, the bintray web UI will show a notification to either "Discard" or "Publish" the versioned artifacts.

#### Manual publishing via the [CLI](https://www.jfrog.com/getcli/)

- [Configure the CLI with credentials to the bintray repository](https://www.jfrog.com/confluence/display/CLI/CLI+for+JFrog+Bintray#CLIforJFrogBintray-Configuration)

	```
	jfrog bt c
	```
	
- [Query the details of a package](https://www.jfrog.com/confluence/display/CLI/CLI+for+JFrog+Bintray#CLIforJFrogBintray-GettingPackageDetails)

	```
	jfrog bt ps jpl-imce/gov.nasa.jpl.imce/gov.nasa.jpl.imce.oml
	```
	
    This query is useful to see the list of "versions" of a package and which, if any, is the "latestVersion" (published).
    Note that the versions after the "latestVersion" are not published.
    
- [Publish a package version](https://www.jfrog.com/confluence/display/CLI/CLI+for+JFrog+Bintray#CLIforJFrogBintray-PublishingaVersion)

	
	```
	jfrog bt vp jpl-imce/gov.nasa.jpl.imce/gov.nasa.jpl.imce.oml/<version>
	```
	

- [Delete a package version](https://www.jfrog.com/confluence/display/CLI/CLI+for+JFrog+Bintray#CLIforJFrogBintray-DeletingaVersion)

	
	```
	jfrog bt vd jpl-imce/gov.nasa.jpl.imce/gov.nasa.jpl.imce.oml/<version>
	```
	
	Note that this command allows deleting both published and unpublished package versions.
	