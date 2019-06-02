#!/bin/bash
set -x

VERSION=$(cat release/version)

sed  -i 's/^\(\s*version\s*: \s*\).*/\1'"${VERSION}"'/' source-code/kubernetes/spring-demo/Chart.yaml 

cat source-code/kubernetes/spring-demo/Chart.yaml 
helm init --client-only
helm repo add harbor  ${HELM_URL} --ca-file ${HELM_CA_PATH} --username ${HELM_USER} --password ${HELM_PASSWORD}
helm push source-code/kubernetes/spring-demo harbor --ca-file source-code/kubernetes/harbor.pem  --username jeff --password 'Pivotal!23'
# pks login -a ${PKS_ENDPOINT} -u ${PKS_USER} -p ${PKS_PASSWORD} -k
# pks get-credentials ${PKS_CLUSTER}
#kubectl get pods
#template=`cat "spring-demo-pod.yml" | sed "s/{VERSION}/$VERSION/g"`
# apply the yml with the substituted value
#echo "$template" > ../pks-build/spring-demo-modified.yml

