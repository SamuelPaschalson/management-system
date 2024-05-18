#!/bin/sh
##############################################################################
# Copyright 2014-2020 Apache Software Foundation.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
##############################################################################
# ----------------------------------------------------------------------------
# Maven Wrapper
# ----------------------------------------------------------------------------

#NATIVE_MAVEN_PROJECT_VERSION@#

WRAPPER_EXECUTABLE="./mvnw"
if [ -f "$WRAPPER_EXECUTABLE" ]
then
  WRAPPER_EXECUTABLE="$(pwd)/mvnw"
elif [ -f "$WRAPPER_EXECUTABLE.bat" ]
then
  WRAPPER_EXECUTABLE="$(pwd)/mvnw.bat"
fi

if [ -n "$MAVEN_HOME" ]; then
    MVN="$MAVEN_HOME/bin/mvn"
else
    MVN="mvn"
fi

$MVN -f "${BASH_SOURCE%/*}/pom.xml" "$@"
EXIT_CODE=$?
if [ "$EXIT_CODE" -ne 0 ]; then
    exit $EXIT_CODE
fi