#!/bin/bash

set -e

# Get the tag for this commit
t=$(git name-rev --tags --name-only $(git rev-parse HEAD));

if test "undefined" != "$t"; then

	# This is an untagged build.
	mvn -e clean verify;
	
else

	# This is a tagged build.
	
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

    mvn -e deploy;

fi
