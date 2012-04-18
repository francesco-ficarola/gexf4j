package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.Gexf;
import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.impl.GexfImpl;
import com.ojn.gexf4j.core.impl.data.AttributeListImpl;
import com.ojn.gexf4j.core.impl.dynamic.SpellImpl;

public class DynamicGraphBuilder extends GexfBuilder {

	@Override
	public String getSuffix() {
		return "dynamic";
	}
	
	@Override
	public Gexf buildGexf() {
		Gexf gexf = new GexfImpl();
		
		gexf.getMetadata()
			.setLastModified(toDate("2009-03-20"))
			.setCreator("Gexf.net")
			.setDescription("A Web network changing over time");
		
		gexf.getGraph()
			.setStartDate(toDate("2009-01-01"))
			.setEndDate(toDate("2009-03-20"));
		
		AttributeList attrListStatic = new AttributeListImpl(AttributeClass.NODE);
		gexf.getGraph().getAttributeLists().add(attrListStatic);
		
		AttributeList attrListDynamic = new AttributeListImpl(AttributeClass.NODE)
			.setMode(Mode.DYNAMIC);
		gexf.getGraph().getAttributeLists().add(attrListDynamic);
		
		Attribute attUrl = attrListStatic.createAttribute("0", AttributeType.STRING, "url");
		Attribute attFrog = attrListStatic.createAttribute("1", AttributeType.BOOLEAN, "frog")
			.setDefaultValue("true");
		
		Attribute attIndegree = attrListDynamic.createAttribute("2", AttributeType.FLOAT, "indegree");
		
		Node gephi = gexf.getGraph().createNode("0");
		gephi
			.setLabel("Gephi")
			.setStartDate(toDate("2009-03-01"))
			.getAttributeValues()
				.addValue(attUrl, "http://gephi.org")
				.addValue(attIndegree, "1");
		
		Node webatlas = gexf.getGraph().createNode("1");
		webatlas
			.setLabel("Webatlas")
			.getAttributeValues()
				.addValue(attUrl, "http://webatlas.fr");
			
		webatlas.getAttributeValues().createValue(attIndegree, "1")
			.setEndDate(toDate("2009-03-01"));
		webatlas.getAttributeValues().createValue(attIndegree, "2")
			.setStartDate(toDate("2009-03-01"))
			.setEndDate(toDate("2009-03-10"));
		webatlas.getAttributeValues().createValue(attIndegree, "1")
			.setStartDate(toDate("2009-03-10"));
	    
		Node rtgi = gexf.getGraph().createNode("2");
		rtgi
			.setLabel("RTGI")
			.getAttributeValues()
				.addValue(attUrl, "http://rtgi.fr");
		
		rtgi.getAttributeValues().createValue(attIndegree, "0")
			.setEndDate(toDate("2009-03-01"));
		rtgi.getAttributeValues().createValue(attIndegree, "1")
			.setStartDate(toDate("2009-03-01"));
		
		rtgi.getSpells().add(new SpellImpl()
			.setEndDate(toDate("2009-03-01")));
		rtgi.getSpells().add(new SpellImpl()
			.setStartDate(toDate("2009-03-05"))
			.setEndDate(toDate("2009-03-10")));
		
		Node blab = gexf.getGraph().createNode("3");
		blab
			.setLabel("BarabasiLab")
			.getAttributeValues()
				.addValue(attUrl, "http://barabasilab.com")
				.addValue(attFrog, "false");
				
		blab.getAttributeValues().createValue(attIndegree, "0")
			.setEndDate(toDate("2009-03-01"));
		blab.getAttributeValues().createValue(attIndegree, "1")
			.setStartDate(toDate("2009-03-01"));
		
		gephi.connectTo("0", webatlas)
			.setStartDate(toDate("2009-03-01"));
		
		gephi.connectTo("1", rtgi)
			.setStartDate(toDate("2009-03-01"))
			.setEndDate(toDate("2009-03-10"));
		
		webatlas.connectTo("2", gephi)
			.setStartDate(toDate("2009-03-01"));
		
		rtgi.connectTo("3", webatlas)
			.setEndDate(toDate("2009-03-10"));
		
		gephi.connectTo("4",blab)
			.setStartDate(toDate("2009-03-01"));
		
		return gexf;
	}
}