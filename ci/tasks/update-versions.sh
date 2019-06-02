#!/bin/sh
set -x

ls
VERSION=$(cat release/version)
cp -R config/* config-updated
cp -R config/.git config-updated

sed  -i 's/^\(\s*springdemoimage\s*: \s*\).*/\1'"${VERSION}"'/' config-updated/values.yml
cat config-updated/values.yml
git config --global user.email "nobody@concourse-ci.org"
git config --global user.name "Concourse"
cd config-updated
git add .
git commit -m "update version by ci" || :
