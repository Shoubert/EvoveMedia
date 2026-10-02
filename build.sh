#!/usr/bin/env bash
# Compile all Java sources and run the headless smoke test. Needs JDK 17+.
set -euo pipefail
cd "$(dirname "$0")"
rm -rf out
javac -d out $(find src -name "*.java")
java -Djava.awt.headless=true -cp out javaflix.SmokeTest
echo "Run the GUI: java -cp out javaflix.JavaFlix"
