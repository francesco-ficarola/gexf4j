gexf4j - The new java library for the latest .gexf file format
=================

Latest Version: [0.3.0-ALPHA](http://github.com/francesco-ficarola/gexf4j)

About
------------------
GEXF File Format Java Library. Supports [GEXF 1.2](http://gexf.net/format/index.html). This library is used to create and write GEXF Files for visualizing graphs using Gephi and any other GEXF-supporting application.
Versions up to [0.2.0](https://github.com/jmcampanini/gexf4j-core) are mantained by Javier Campanini, under the Apache License, Version 2.0. The new version 0.3.0 and later will be maintained by Francesco Ficarola, under the same license. 

License
------------------
Copyright [2012] [Francesco Ficarola]

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

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

Also introduced in 0.2 is a chaining API, allowing for a more descriptive interaction with the API. Here's an example:

	Node gephi = gexf.getGraph().createNode("0");
	gephi
		.setLabel("Gephi")
		.setStartDate(toDate("2009-03-01"))
		.getAttributeValues()
			.addValue(attUrl, "http://gephi.org")
			.addValue(attIndegree, "1");

Installing
------------------
You have two options:

1. Download the latest JAR files from the download page
2. Download the source, and compile/install using maven2 (mvn clean && mvn package)

Sample Code
------------------
The following code creates the same graph located on: http://gexf.net/format/data.html

	Gexf gexf = new GexfImpl();
	
	gexf.getMetadata()
		.setLastModified(toDate("2009-03-20"))
		.setCreator("Gephi.org")
		.setDescription("A Web network");
	
	AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
	gexf.getGraph().getAttributeLists().add(attrList);
	
	Attribute attUrl = attrList.createAttribute("0", AttributeType.STRING, "url");
	Attribute attIndegree = attrList.createAttribute("1", AttributeType.FLOAT, "indegree");
	Attribute attFrog = attrList.createAttribute("2", AttributeType.BOOLEAN, "frog")
		.setDefaultValue("true");
	
	Node gephi = gexf.getGraph().createNode("0");
	gephi
		.setLabel("Gephi")
		.getAttributeValues()
			.addValue(attUrl, "http://gephi.org")
			.addValue(attIndegree, "1");
	
	Node webatlas = gexf.getGraph().createNode("1");
	webatlas
		.setLabel("Webatlas")
		.getAttributeValues()
			.addValue(attUrl, "http://webatlas.fr")
			.addValue(attIndegree, "2");
	
	Node rtgi = gexf.getGraph().createNode("2");
	rtgi
		.setLabel("RTGI")
		.getAttributeValues()
			.addValue(attUrl, "http://rtgi.fr")
			.addValue(attIndegree, "1");
	
	Node blab = gexf.getGraph().createNode("3");
	blab
		.setLabel("BarabasiLab")
		.getAttributeValues()
			.addValue(attUrl, "http://barabasilab.com")
			.addValue(attIndegree, "1")
			.addValue(attFrog, "false");
	
	gephi.connectTo("0", webatlas);
	gephi.connectTo("1", rtgi);
	webatlas.connectTo("2", gephi);
	rtgi.connectTo("3", webatlas);
	gephi.connectTo("4", blab);
