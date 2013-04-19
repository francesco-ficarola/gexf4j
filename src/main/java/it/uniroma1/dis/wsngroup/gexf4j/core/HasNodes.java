package it.uniroma1.dis.wsngroup.gexf4j.core;

import java.util.List;

public interface HasNodes {
	
	/**
	 * Creates a new Node
	 * @return the built Node
	 */
	Node createNode();
	
	/**
	 * Creates a new Node with a specific ID
	 * @param id the ID of the Node
	 * @return the built Node
	 */
	Node createNode(String id);
	
	/**
	 * Returns the list of all the Nodes
	 * @return the list of all the Nodes
	 */
	List<Node> getNodes();
	
	/**
	 * Returns the list of all the Edges
	 * @return the list of all the Edges
	 */
	List<Edge> getAllEdges();
}