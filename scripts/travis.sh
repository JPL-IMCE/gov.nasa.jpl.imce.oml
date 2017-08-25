#!/bin/bash

set -e

# Is this a travis deployment?
if test -n "${TRAVIS_TAG}" && -n "${TRAVIS_SECURE_ENV_VARS}"; then

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

else
    
    # Get the tag for this commit
    t=$(git name-rev --tags --name-only $(git rev-parse HEAD));

    if test "undefined" != "$t"; then

	echo "# Tagged commits are reserved for deployment";
       	exit -1;

    else

	mvn -e clean verify;

    fi;
  
fi
