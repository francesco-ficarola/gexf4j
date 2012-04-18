package com.ojn.gexf4j.core;

import com.ojn.gexf4j.core.viz.Color;
import com.ojn.gexf4j.core.viz.EdgeShape;

public interface Edge extends SpellableDatum<Edge> {

	String getId();
	
	Node getSource();
	
	Node getTarget();
	Edge setTarget(Node target);
	
	boolean hasLabel();
	Edge clearLabel();
	String getLabel();
	Edge setLabel(String label);
	
	boolean hasWeight();
	Edge clearWeight();
	float getWeight();
	Edge setWeight(float weight);

	EdgeType getEdgeType();
	Edge setEdgeType(EdgeType edgeType);

	boolean hasColor();
	Edge clearColor();
	Color getColor();
	Edge setColor(Color color);

	boolean hasThickness();
	Edge clearThickness();
	float getThickness();
	Edge setThickness(float thickness);

	EdgeShape getShape();
	Edge setShape(EdgeShape shape);	
}