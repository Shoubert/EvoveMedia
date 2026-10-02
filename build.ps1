# Compile all Java sources and run the headless smoke test. Needs JDK 17+.
$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot
if (Test-Path out) { Remove-Item -Recurse -Force out }
javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object FullName)
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
java "-Djava.awt.headless=true" -cp out javaflix.SmokeTest
Write-Host "Run the GUI: java -cp out javaflix.JavaFlix"
