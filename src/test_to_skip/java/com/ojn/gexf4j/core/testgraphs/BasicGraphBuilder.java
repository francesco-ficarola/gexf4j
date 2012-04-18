package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.Gexf;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.impl.GexfImpl;

public class BasicGraphBuilder extends GexfBuilder {
	
	@Override
	public String getSuffix() {
		return "basic";
	}
	
	@Override
	public Gexf buildGexf() {
		Gexf gexf = new GexfImpl();
		Graph g = gexf.getGraph();
		
		Node hello = g.createNode("0")
			.setLabel("Hello");
		Node world = g.createNode("1")
			.setLabel("World");
		
		hello.connectTo("0", world);
		
		return gexf;
	}
}