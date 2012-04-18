package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.Gexf;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.impl.GexfImpl;

public class PhylogenyBuilder extends GexfBuilder {

	@Override
	public String getSuffix() {
		return "phylogeny";
	}
	
	@Override
	public Gexf buildGexf() {
		Gexf gexf = new GexfImpl();
		
		Node a = gexf.getGraph().createNode("a");
		a.setLabel("cheese");
		
		Node b = gexf.getGraph().createNode("b");
		b.setLabel("cherry");
		
		Node c = gexf.getGraph().createNode("c");
		c.setLabel("cake");
		c.getParentForList().add(a);
		c.getParentForList().add(b);
		
		return gexf;
	}
}