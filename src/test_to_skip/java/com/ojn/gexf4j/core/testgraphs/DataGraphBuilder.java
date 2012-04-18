package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.Gexf;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.impl.GexfImpl;
import com.ojn.gexf4j.core.impl.data.AttributeListImpl;

public class DataGraphBuilder extends GexfBuilder {
	
	@Override
	public String getSuffix() {
		return "data";
	}
	
	@Override
	public Gexf buildGexf() {
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
		
		return gexf;
	}
}