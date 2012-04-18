package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Gexf;
import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.impl.GexfImpl;

public class HierarchyPIDBuilder extends GexfBuilder {

	@Override
	public String getSuffix() {
		return "hierarchyPID";
	}
	
	@Override
	public Gexf buildGexf() {
		Gexf gexf = new GexfImpl();
		
		
		gexf.getGraph()
			.setMode(Mode.STATIC)
			.setDefaultEdgeType(EdgeType.DIRECTED);
		
		Node g = gexf.getGraph().createNode("g");
		g.setLabel("frog2")
			.setPID("e");
		
		Node a = gexf.getGraph().createNode("a");
		a.setLabel("Kevin Bacon");
		
		Node c = gexf.getGraph().createNode("c");
		c.setLabel("human1")
			.setPID("b");
		
        Node b = gexf.getGraph().createNode("b");
		b.setLabel("God")
			.setPID("a");
		
        Node e = gexf.getGraph().createNode("e");
		e.setLabel("Me")
			.setPID("a");
        
        Node d = gexf.getGraph().createNode("d");
		d.setLabel("human2")
			.setPID("b");
		
        Node f = gexf.getGraph().createNode("f");
		f.setLabel("frog1")
			.setPID("e");
		
		
		b.connectTo("0", e);
		c.connectTo("1", d);
		g.connectTo("2", b);
		f.connectTo("3", a);
		
		return gexf;
	}
}