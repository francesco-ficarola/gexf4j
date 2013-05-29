gexf4j - A java library for the GEXF file format
=================

Latest Version: **0.4.4-BETA**

Author: *Francesco Ficarola*

Tests Author: *Tadas Subonis*

v0.2 Author: *Javier Campanini*

About
------------------
GEXF File Format Java Library. It supports [GEXF 1.2](http://gexf.net/format/index.html). This library is used to create and write GEXF files for visualizing graphs using Gephi and any other GEXF-supporting application.
Versions up to [0.2.0](https://github.com/jmcampanini/gexf4j-core) are mantained by Javier Campanini, under the Apache License, Version 2.0. The new version 0.3.0 and later will be maintained by Francesco Ficarola, under the same license. 

License
------------------
Copyright [2012] [Francesco Ficarola]

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

Version 0.4.2 - BETA (by Francesco Ficarola)
------------------

The following changes have been applied:

* Everything was integrated in the pom.xml file to correctly work with Maven.
* Version 0.4.2 was uploaded to [Maven Central](http://search.maven.org/#browse%7C322148902).

Version 0.4.1 - BETA (by Francesco Ficarola)
------------------

All libraries were added into the pom.xml as maven dependencies.

Version 0.4.0 - BETA (pull request by dankeris)
------------------
The following changes have been applied:

* Unit tests have been included
* STAX impementation has been changed from JDK default to woodstox
* Stream writing has been added for convenience

Additional changes:

* SimpleDateFormat variables are now safe for multi-threading
* Javadoc has been updated

Version 0.3.2 - ALPHA (pull request by dankeris)
------------------
The following changes were applied:

* Changed OutputStream writing to Writer output
* Added capability to add encoding to document

Version 0.3.1 - ALPHA (by Francesco Ficarola)
------------------
The following changes were applied:

* Javadoc was added
* Bug fix for the not-inclusion of the timeformat attribute in static graphs
* Smart names for the method parameters
* Two examples about static and dynamic graphs have been added (package "it.uniroma1.dis.wiserver.gexf4j.examples")

Version 0.3.0 - ALPHA (by Francesco Ficarola)
------------------
The following changes were applied:

* "timetype" attribute is renamed to "timeformat"
* "slices" and "slice" are renamed "spells" and "spell" correspondingly
* Now the "timeformat" can be integer, double (default), date, dateTime
* Open intervals (non-inclusive) are added: "startopen" and "endopen" attributes
* Bug fix on some "Attribute setTitle(String title)" method: the expression in checkArgument was wrong
* The methods "setStartDate(Date d)" and "setEndDate(d)" are changed in "setStartValue(Object o)" and "setEndValue(Object o)", respectly
* The Methods "Date getStartDate()" and "Date getEndDate()" are changed in "Object getStartValue()" and "Object getEndValue()", respectly

Version 0.2 - ALPHA (by Javier Campanini)
------------------
NOTE: The alpha version does NOT have a full test suite.

The underlying API has changed dramatically. Gexf4j now supports the entire GEXF file format, including:

* Data Graphs
* Dynamics
* Hierarchy
* Phylogeny
* Visualization

Installing
------------------

Run the following commands to compile and package gexf4j:

	$ git clone https://github.com/francesco-ficarola/gexf4j.git
	$ mvn clean package

If everything is fine, you will find the jar file in the target/ directory.

Sample Code
------------------
In the following paths:

* src/examples/java
* src/test/java
* src/test/resources

you can find some example code (and resulting output files) that shows how to build GEXF graphs by using the gexf4j library.
