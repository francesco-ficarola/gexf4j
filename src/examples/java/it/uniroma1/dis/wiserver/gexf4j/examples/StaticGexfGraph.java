package it.uniroma1.dis.wiserver.gexf4j.examples;

import it.uniroma1.dis.wiserver.gexf4j.core.EdgeType;
import it.uniroma1.dis.wiserver.gexf4j.core.Gexf;
import it.uniroma1.dis.wiserver.gexf4j.core.Graph;
import it.uniroma1.dis.wiserver.gexf4j.core.Mode;
import it.uniroma1.dis.wiserver.gexf4j.core.Node;
import it.uniroma1.dis.wiserver.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wiserver.gexf4j.core.data.AttributeClass;
import it.uniroma1.dis.wiserver.gexf4j.core.data.AttributeList;
import it.uniroma1.dis.wiserver.gexf4j.core.data.AttributeType;
import it.uniroma1.dis.wiserver.gexf4j.core.impl.GexfImpl;
import it.uniroma1.dis.wiserver.gexf4j.core.impl.StaxGraphWriter;
import it.uniroma1.dis.wiserver.gexf4j.core.impl.data.AttributeListImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;


public class StaticGexfGraph {

	public static void main(String[] args) {
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
	}
	
}
