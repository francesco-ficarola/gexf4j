package com.ojn.gexf4j.core;

import java.util.List;

public interface HasNodes {
	
	Node createNode();
	Node createNode(String id);
	
	List<Node> getNodes();
	List<Edge> getAllEdges();
}