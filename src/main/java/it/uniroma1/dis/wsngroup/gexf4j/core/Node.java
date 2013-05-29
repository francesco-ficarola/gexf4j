package it.uniroma1.dis.wsngroup.gexf4j.core;

import it.uniroma1.dis.wsngroup.gexf4j.core.viz.Color;
import it.uniroma1.dis.wsngroup.gexf4j.core.viz.NodeShapeEntity;
import it.uniroma1.dis.wsngroup.gexf4j.core.viz.Position;

import java.util.List;

/**
 * Interface for the Node element.
 *
 */
public interface Node extends SpellableDatum<Node>, HasNodes {

	/**
	 * Returns the ID of the Node
	 * @return the Node ID as String
	 */
	String getId();
	
	/**
	 * Returns the label of the Node
	 * @return the label as String
	 */
	String getLabel();
	
	/**
	 * Sets the label of the Node
	 * @param label a label as String for the Node
	 * @return the current Node
	 */
	Node setLabel(String label);
	
	/**
	 * Returns the list of the Node's edges
	 * @return the list of the edges for this Node
	 */
	List<Edge> getEdges();
	
	/**
	 * Creates an Edge between this Node and the target Node
	 * @param target the target Node of the Edge
	 * @return the built Edge
	 */
	Edge connectTo(Node target);
	
	/**
	 * Creates an Edge with a particular ID between this Node and the target Node
	 * @param id the ID of the Edge
	 * @param target the target Node of the Edge
	 * @return the built Edge
	 */
	Edge connectTo(String id, Node target);

	/**
	 * Creates an Edge with a particular ID and label between this Node and the target Node
	 * @param id the ID of the Edge
	 * @param label the label of the Edge
	 * @param target the target Node of the Edge
	 * @return the built Edge
	 */
	Edge connectTo(String id, String label, Node target);

	/**
	 * Creates an Edge with a particular ID and label between this Node and the target Node
	 * @param id the ID of the Edge
	 * @param label the label of the Edge
	 * @param edgeType the edgeType of the Edge
	 * @param target the target Node of the Edge
	 * @return the built Edge
	 */
	Edge connectTo(String id, String label, EdgeType edgeType, Node target);

	/**
	 * Checks if this Node is connected to another Node
	 * @param id the ID of the other Node
	 * @return true if this Node is connected to another Node
	 */
	boolean hasEdgeTo(String id);
	
	/**
	 * Checks if the Node has a color
	 * @return true if the Node has a color
	 */
	boolean hasColor();
	
	/**
	 * Clears the color of the Node
	 * @return the current Node
	 */
	Node clearColor();
	
	/**
	 * Returns the color of the Node
	 * @return a Color object for that Node
	 */
	Color getColor();
	
	/**
	 * Sets the color of the Node
	 * @param color an instance of Color
	 * @return the current Node
	 */
	Node setColor(Color color);
	
	/**
	 * Checks if the Node has a position
	 * @return true if the Node has a position
	 */
	boolean hasPosition();
	
	/**
	 * Clears the position of the Node
	 * @return the current Node
	 */
	Node clearPosition();
	
	/**
	 * Returns the position of the Node
	 * @return an instance of Position
	 */
	Position getPosition();
	
	/**
	 * Sets the position of the Node
	 * @param position an instance of Position
	 * @return the current Node
	 */
	Node setPosition(Position position);
	
	/**
	 * Checks if the Node has a size
	 * @return true if the Node has a size
	 */
	boolean hasSize();
	
	/**
	 * Clears the size of the Node
	 * @return the current Node
	 */
	Node clearSize();
	
	/**
	 * Returns the size of the Node
	 * @return the size as float
	 */
	float getSize();
	
	/**
	 * Sets the size of the Node
	 * @param size a float number indicating the size
	 * @return the current Node
	 */
	Node setSize(float size);
	
	/**
	 * Checks if the Node has a shape
	 * @return true if the Node has a shape
	 */
	boolean hasShape();
	
	/**
	 * Clears the shape of the Node
	 * @return the current Node
	 */
	Node clearShape();
	
	/**
	 * Returns the shape entity of the Node
	 * @return an instance of NodeShapeEntity
	 */
	NodeShapeEntity getShapeEntity();
	
	/**
	 * Returns the list of the Node's parents
	 * @return the list of the parents for this Node
	 */
	List<Node> getParentForList();

	/**
	 * Checks if the Node has a PID
	 * @return true if the Node has a PID
	 */
	boolean hasPID();
	
	/**
	 * Clears the PID of the Node
	 * @return the current Node
	 */
	Node clearPID();
	
	/**
	 * Returns the PID of the Node
	 * @return the PID as String
	 */
	String getPID();
	
	/**
	 * Sets the PID of the Node
	 * @param pid a String indicating the PID
	 * @return the current Node
	 */
	Node setPID(String pid);
}
