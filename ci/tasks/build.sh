#!/bin/bash

set -eux
export ROOT_FOLDER="$( pwd )"

VERSION=$(cat source-code/.git/ref)
VERSION=${VERSION:0:6}
SCRIPT_DIR=$(dirname "$0")
M2_HOME="${ROOT_FOLDER}/.m2"
M2_CACHE="${ROOT_FOLDER}/maven"
source ${SCRIPT_DIR}/mvn-tools.sh



generate_settings
ls

pushd source-code
    set_revision_to_pom ${VERSION}
    ls
	mvn clean package -DskipTests
popd

mkdir packed-release/target
cp source-code/docker/Dockerfile packed-release/target/
cp source-code/kubernetes/*.yml packed-release/target/  || :
cp source-code/target/service-demo-${VERSION}.jar packed-release/target/
tar zcvf packed-release/release-${VERSION}.tgz -C packed-release/target .
ls packed-release