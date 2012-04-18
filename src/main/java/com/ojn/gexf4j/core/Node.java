package com.ojn.gexf4j.core;

import java.util.List;

import com.ojn.gexf4j.core.viz.Color;
import com.ojn.gexf4j.core.viz.NodeShapeEntity;
import com.ojn.gexf4j.core.viz.Position;

public interface Node extends SpellableDatum<Node>, HasNodes {

	String getId();
	
	String getLabel();
	Node setLabel(String label);
	
	List<Edge> getEdges();
	
	Edge connectTo(Node target);
	Edge connectTo(String id, Node target);
	
	boolean hasEdgeTo(String id);
	
	boolean hasColor();
	Node clearColor();
	Color getColor();
	Node setColor(Color color);
	
	boolean hasPosition();
	Node clearPosition();
	Position getPosition();
	Node setPosition(Position position);
	
	boolean hasSize();
	Node clearSize();
	float getSize();
	Node setSize(float size);
	
	boolean hasShape();
	Node clearShape();
	NodeShapeEntity getShapeEntity();
	
	List<Node> getParentForList();

	boolean hasPID();
	Node clearPID();
	String getPID();
	Node setPID(String pid);
}