package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.Gexf;
import com.ojn.gexf4j.core.impl.GexfImpl;
import com.ojn.gexf4j.core.impl.viz.ColorImpl;
import com.ojn.gexf4j.core.impl.viz.PositionImpl;
import com.ojn.gexf4j.core.viz.NodeShape;

public class VisualizationBuilder extends GexfBuilder {

	@Override
	public String getSuffix() {
		return "viz";
	}
	
	@Override
	public Gexf buildGexf() {
		Gexf gexf = new GexfImpl();
		
		gexf
			.setVisualization(true)
			.getGraph().createNode("a")
				.setLabel("glossy")
				.setColor(new ColorImpl(239, 173, 66))
				.setPosition(new PositionImpl(15.783598f, 40.109245f, 0.0f))
				.setSize(2.0375757f)
				.getShapeEntity().setNodeShape(NodeShape.DISC);
		
		return gexf;
	}

	@Override
	public String getSchemaUrl() {
		return "http://gexf.net/1.1draft/viz.xsd";
	}
}