gexf4j - A java library for the GEXF file format
=================

Latest Version: [0.3.1-ALPHA](http://github.com/francesco-ficarola/gexf4j)

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
You have two options:

1. Download the latest version of the JAR file from the [download page](https://github.com/francesco-ficarola/gexf4j/downloads)
2. Download the source, and compile/install using maven2 (mvn clean && mvn package)

Dependecies
------------------
Gexf4j library needs [com.google.common.base.Preconditions](http://code.google.com/p/guava-libraries/). You can find a version of that library in the lib directory, too.

Sample Code
------------------
The following code builds [this static graph](https://github.com/downloads/francesco-ficarola/gexf4j/static_graph_sample.gexf).

	Gexf gexf = new GexfImpl();
	Calendar date = Calendar.getInstance();
	
	gexf.getMetadata()
		.setLastModified(date.getTime())
		.setCreator("Gephi.org")
		.setDescription("A Web network");

	Graph graph = gexf.getGraph();
	graph.setDefaultEdgeType(EdgeType.UNDIRECTED).setMode(Mode.STATIC);
	
	AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
	graph.getAttributeLists().add(attrList);
	
	Attribute attUrl = attrList.createAttribute("0", AttributeType.STRING, "url");
	Attribute attIndegree = attrList.createAttribute("1", AttributeType.FLOAT, "indegree");
	Attribute attFrog = attrList.createAttribute("2", AttributeType.BOOLEAN, "frog")
		.setDefaultValue("true");
 
	
	Node gephi = graph.createNode("0");
	gephi
		.setLabel("Gephi")
		.getAttributeValues()
			.addValue(attUrl, "http://gephi.org")
			.addValue(attIndegree, "1");
	
	Node webatlas = graph.createNode("1");
	webatlas
		.setLabel("Webatlas")
		.getAttributeValues()
			.addValue(attUrl, "http://webatlas.fr")
			.addValue(attIndegree, "2");
	
	Node rtgi = graph.createNode("2");
	rtgi
		.setLabel("RTGI")
		.getAttributeValues()
			.addValue(attUrl, "http://rtgi.fr")
			.addValue(attIndegree, "1");
	
	Node blab = graph.createNode("3");
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

	StaxGraphWriter graphWriter = new StaxGraphWriter();
	File f = new File("static_graph_sample.gexf");
	FileOutputStream fos;
	try {
		fos = new FileOutputStream(f, false);
		graphWriter.writeToStream(gexf, fos);
		System.out.println(f.getAbsolutePath());
	} catch (IOException e) {
		e.printStackTrace();
	}


The following code builds [this dynamic graph](https://github.com/downloads/francesco-ficarola/gexf4j/dynamic_graph_sample.gexf).

	Gexf gexf = new GexfImpl();
	Calendar date = Calendar.getInstance();
	
	gexf.getMetadata()
		.setLastModified(date.getTime())
		.setCreator("Gephi.org")
		.setDescription("A Web network");


	Graph graph = gexf.getGraph();
	graph.
		setDefaultEdgeType(EdgeType.UNDIRECTED)
		.setMode(Mode.DYNAMIC)
		.setTimeType(TimeFormat.XSDDATETIME);
	
	AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
	graph.getAttributeLists().add(attrList);
	
	Attribute attUrl = attrList.createAttribute("0", AttributeType.STRING, "url");
	Attribute attIndegree = attrList.createAttribute("1", AttributeType.FLOAT, "indegree");
	Attribute attFrog = attrList.createAttribute("2", AttributeType.BOOLEAN, "frog")
		.setDefaultValue("true");
 
	
	/** Node Gephi */
	Node gephi = graph.createNode("0");
	gephi
		.setLabel("Gephi")
		.getAttributeValues()
			.addValue(attUrl, "http://gephi.org")
			.addValue(attIndegree, "1");
	
	Spell spellGephi = new SpellImpl();
	date.set(2012, 3, 28, 16, 10, 0);
	date.set(Calendar.MILLISECOND, 0);
	spellGephi.setStartValue(date.getTime());
	gephi.getSpells().add(spellGephi);
	
	
	/** Node Webatlas */
	Node webatlas = graph.createNode("1");
	webatlas
		.setLabel("Webatlas")
		.getAttributeValues()
			.addValue(attUrl, "http://webatlas.fr")
			.addValue(attIndegree, "2");
	
	Spell spellWebatlas1 = new SpellImpl();
	date.set(Calendar.MINUTE, 15);
	spellWebatlas1.setStartValue(date.getTime());
	date.set(2012, 3, 28, 18, 57, 2);
	spellWebatlas1.setEndValue(date.getTime());
	webatlas.getSpells().add(spellWebatlas1);
	
	Spell spellWebatlas2 = new SpellImpl();
	date.set(2012, 3, 28, 20, 31, 10);
	spellWebatlas2.setStartValue(date.getTime()).setStartIntervalType(IntervalType.OPEN);
	date.set(Calendar.MINUTE, 45);
	date.set(Calendar.SECOND, 21);
	spellWebatlas2.setEndValue(date.getTime());
	webatlas.getSpells().add(spellWebatlas2);
	
	Spell spellWebatlas3 = new SpellImpl();
	date.set(2012, 3, 28, 21, 0, 0);
	spellWebatlas3.setStartValue(date.getTime());
	date.set(2012, 4, 11, 10, 49, 27);
	spellWebatlas3.setEndValue(date.getTime()).setEndIntervalType(IntervalType.OPEN);
	webatlas.getSpells().add(spellWebatlas3);
	
	
	/** Node RTGI */
	Node rtgi = graph.createNode("2");
	rtgi
		.setLabel("RTGI")
		.getAttributeValues()
			.addValue(attUrl, "http://rtgi.fr")
			.addValue(attIndegree, "1");
	
	Spell spellRtgi = new SpellImpl();
	date.set(2012, 3, 27, 6, 0, 0);
	spellRtgi.setStartValue(date.getTime());
	date.set(2012, 4, 19);
	spellRtgi.setEndValue(date.getTime());
	rtgi.getSpells().add(spellRtgi);
	
	
	/** Node BarabasiLab */
	Node blab = graph.createNode("3");
	blab
		.setLabel("BarabasiLab")
		.getAttributeValues()
			.addValue(attUrl, "http://barabasilab.com")
			.addValue(attIndegree, "3")
			.addValue(attFrog, "false");
	
	
	/** Node foobar */
	Node foobar = graph.createNode("4");
	foobar
		.setLabel("FooBar")
		.getAttributeValues()
			.addValue(attUrl, "http://foo.bar")
			.addValue(attIndegree, "1")
			.addValue(attFrog, "false");
	
	
	/** Edge 0 [gephi, webatlas] */
	Edge edge0 = gephi.connectTo("0", webatlas);
	
	Spell spellEdge0 = new SpellImpl();
	date.set(2012, 3, 28, 16, 15, 36);
	spellEdge0.setStartValue(date.getTime());
	date.set(2012, 3, 28, 17, 41, 5);
	spellEdge0.setEndValue(date.getTime());
	edge0.getSpells().add(spellEdge0);
	
	
	/** Edge 1 [gephi, rtgi] */
	Edge edge1 = gephi.connectTo("1", rtgi);
	
	Spell spellEdge1 = new SpellImpl();
	date.set(2012, 3, 30, 11, 16, 6);
	spellEdge1.setStartValue(date.getTime());
	date.set(2012, 4, 3, 11, 52, 6);
	spellEdge1.setEndValue(date.getTime());
	edge1.getSpells().add(spellEdge1);
	
	
	/** Edge 2 [rtgi, webatlas] */
	Edge edge2 = rtgi.connectTo("2", webatlas);
	Spell spellEdge2 = new SpellImpl();
	date.set(2012, 4, 1, 11, 0, 0);
	spellEdge2.setStartValue(date.getTime()).setStartIntervalType(IntervalType.OPEN);
	date.set(2012, 4, 5, 11, 9, 44);
	spellEdge2.setEndValue(date.getTime());
	edge2.getSpells().add(spellEdge2);
	
	
	/** Edge 3 [gephi, blab] */
	Edge edge3 = gephi.connectTo("3", blab);
	Spell spellEdge3 = new SpellImpl();
	date.set(2012, 3, 30, 12, 13, 22);
	spellEdge3.setStartValue(date.getTime());
	date.set(Calendar.MINUTE, 58);
	date.set(Calendar.SECOND, 24);
	spellEdge3.setEndValue(date.getTime());
	edge3.getSpells().add(spellEdge3);
	
	
	/** Edge 4 [webatlas, blab] */
	Edge edge4 = webatlas.connectTo("4", blab);
	Spell spellEdge4 = new SpellImpl();
	date.set(2012, 3, 30, 21, 2, 37);
	spellEdge4.setStartValue(date.getTime());
	date.set(Calendar.MINUTE, 13);
	spellEdge4.setEndValue(date.getTime());
	edge4.getSpells().add(spellEdge4);
	
	
	/** Edge 5 [foobar, blab] */
	foobar.connectTo("5", blab);
	
	
	StaxGraphWriter graphWriter = new StaxGraphWriter();
	File f = new File("dynamic_graph_sample.gexf");
	FileOutputStream fos;
	try {
		fos = new FileOutputStream(f, false);
		graphWriter.writeToStream(gexf, fos);
		System.out.println(f.getAbsolutePath());
	} catch (IOException e) {
		e.printStackTrace();
	}
