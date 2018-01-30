#!/usr/bin/env bash

. $(dirname $0)/travis-tail.sh

travis_tail 60 docker run --rm -v $(pwd):/root/sources -w /root/sources -e TRAVIS_TAG="${TRAVIS_TAG}" -e BINTRAY_USER="${BINTRAY_USER}" -e BINTRAY_APIKEY="${BINTRAY_APIKEY}" maven:3.5-jdk-8 ./scripts/travis.sh