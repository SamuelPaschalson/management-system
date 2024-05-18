@echo off
@REM -----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one or more
@REM contributor license agreements.  See the NOTICE file distributed with
@REM this work for additional information regarding copyright ownership.
@REM The ASF licenses this file to You under the Apache License, Version 2.0
@REM (the "License"); you may not use this file except in compliance with
@REM the License.  You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM -----------------------------------------------------------------------------

@REM -----------------------------------------------------------------------------
@REM Maven Wrapper
@REM -----------------------------------------------------------------------------

@SETLOCAL

SET MAVEN_HOME=%M2_HOME%
IF NOT DEFINED MAVEN_HOME (
    SET MAVEN_HOME=%M3_HOME%
)

IF NOT DEFINED MAVEN_HOME (
    SET MAVEN_HOME=%MAVEN_HOME%
)

IF NOT DEFINED MAVEN_HOME (
    IF NOT "%MAVEN_HOME%"=="" (
        SET MAVEN_HOME=%MAVEN_HOME%
    )
)

IF NOT DEFINED MAVEN_HOME (
    SET MAVEN_EXECUTABLE=mvn
) ELSE (
    SET MAVEN_EXECUTABLE=%MAVEN_HOME%\bin\mvn
)

%MAVEN_EXECUTABLE% -f "%~dp0\pom.xml" %*

ENDLOCAL