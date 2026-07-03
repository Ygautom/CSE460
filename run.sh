#!/usr/bin/env bash
set -e
rm -rf out
javac -d out $(find src -name "*.java")
java -cp out smartcityhub.app.SmartCityHubApp
