Selenium-Maven-Template
=======================

A customized version of [Ardesco/Selenium-Maven-Template](https://github.com/Ardesco/Selenium-Maven-Template) for jump start selenium tests in Firefox / Eclipse.

## Getting Started

1. Clone or [download](https://github.com/tsaiyl/Selenium-Maven-Template/archive/master.zip) and extract this project.
2. Eclipse -> Import -> Existing Projects into Workspace -> select cloned or extracted `Selenium-Maven-Template` project.
3. Wait for Eclipse to download maven dependencies.
4. After maven deps are downloaded, you should see no error, only some warnings in Eclipse.
5. Right click `pom.xml` -> Run as -> Build... -> Goals: `clean verify` -> Run
6. Firefox should launch and run 2 tests in `com.lazerycode.selenium.tests.GoogleExampleIT`.
7. You may delete the 2 tests and add your own tests in class `com.lazerycode.selenium.tests.GoogleExampleIT`.

