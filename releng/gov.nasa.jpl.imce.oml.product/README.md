# OML Workbench

The OML Workbench is an Eclipse RCP application available for the following platforms:

| Platform | File |
|----------|------|
| Linux 32-bit | `gov.nasa.jpl.imce.oml.product-<version>-linux.gtk.x86.tar.gz` |
| Linux 64-bit | `gov.nasa.jpl.imce.oml.product-<version>-linux.gtk.x86_64.tar.gz` |
| MacOSX 64-bit | `gov.nasa.jpl.imce.oml.product-<version>-macosx.cocoa.x86_64.tar.gz` |
| Windows 32-bit | `gov.nasa.jpl.imce.oml.product-<version>-win32.win32.x86.zip` |
| Windows 64-bit | `gov.nasa.jpl.imce.oml.product-<version>-win32.win32.x86_64.zip` |

Note that on MacOSX, running the OML Workbench requires disabling Apple security:
- On MacOSX Mountain Lion (10.8) to El Capitan (10.11):

	1 Go to "System Preferences"
	2 Choose "Security & Privacy"
	3 Click the lock at the bottom of the dialog to unlock. You may need to enter your password / a super user password.
	4 Select "Anywhere" under "Allow apps download from:"
	
- On MacOSX Sierra (10.12):

	1 Open a new terminal
	2 Type the following command: `sudo spctl --master-disable` - you will be prompted for a superuser password
	3 Follow the steps above for El Capitan - the command from step 2 will let the "Anywhere" option reappear.

## Eclipse limitations

### One `oml.catalog.xml` per Eclipse project

If an Eclipse project has multiple `oml.catalog.xml` files,
it is possible for distinct OML files to define the same OML module IRI.
Since OML files become EMF Resources via mapping through an `oml.catalog.xml`,
this situation results in the same OML module IRI becoming the same URI
for distinct EMF Resources, a violation of the uniqueness requirement for EMF Resource URIs.

If this situation happens, there will be lots of strange and possibly misleading EMF errors.
Reorganize the files so as to make sure that there is at most one `oml.catalog.xml` file
in any given Eclipse project. 