package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Gexf;
import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.impl.GexfImpl;

public class HierarchyInlineBuilder extends GexfBuilder {

	@Override
	public String getSuffix() {
		return "hierarchyInline";
	}
	
	@Override
	public Gexf buildGexf() {
		Gexf gexf = new GexfImpl();
		
		gexf.getGraph()
			.setMode(Mode.STATIC)
			.setDefaultEdgeType(EdgeType.DIRECTED);
		
		Node kb = gexf.getGraph().createNode("a");
		kb.setLabel("Kevin Bacon");
		
		Node god = kb.createNode("b");
		god.setLabel("God");
		
		Node c = god.createNode("c");
		c.setLabel("human1");
		
		Node d = god.createNode("d");
		d.setLabel("human2");
		
		Node me = kb.createNode("e");
		me.setLabel("Me");
		
		Node f = me.createNode("f");
		f.setLabel("frog1");
		
		Node g = me.createNode("g");
		g.setLabel("frog2");
		
		god.connectTo("0", me);
		c.connectTo("1", d);
		g.connectTo("2", god);
		f.connectTo("3", kb);
		
		return gexf;
	}
}