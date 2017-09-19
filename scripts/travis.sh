#!/bin/bash

set -e

# Get the tag for this commit
t=$(git name-rev --tags --name-only $(git rev-parse HEAD));


if test -z "${TRAVIS_TAG}"; then

	if test "undefined" != "$t"; then
		echo "#";
		echo "# Bypass build; there is a tag, $t, that should have triggered a deployment build"
		echo "#";
	else
                echo "#";
                echo "# This is an untagged build.";
                echo "#";
                mvn -e clean verify | ./scripts/filter.sh;
        fi;

else
    
	if test "undefined" != "$t"; then

                cat > ~/.m2/settings.xml << EOF
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd/"> 
  <servers>
    <server>
      <id>bintray</id>
      <username>$BINTRAY_USER</username>
      <password>$BINTRAY_APIKEY</password>
    </server>
  </servers>
</settings>
EOF

               echo "#";
               echo "# This is a tagged build: $t (if successful, artifacts will be deployed under $BINTRAY_USER)";
               echo "#";	       
               mvn -e deploy | ./scripts/filter.sh;

        else

               echo "#";
               echo "# This should have been a tagged build; however, there is no GIT tag!";
               echo "#";

	fi;
	
fi
