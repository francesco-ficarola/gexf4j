package it.uniroma1.dis.wsngroup.gexf4j.core;

import it.uniroma1.dis.wsngroup.gexf4j.core.viz.Color;
import it.uniroma1.dis.wsngroup.gexf4j.core.viz.EdgeShape;

/**
 * Interface for the Edge element.
 *
 */
public interface Edge extends SpellableDatum<Edge> {

	/**
	 * Returns the ID of the Edge
	 * @return the Edge ID as String
	 */
	String getId();
	
	/**
	 * Returns the source of the Edge
	 * @return the source node
	 */
	Node getSource();
	
	/**
	 * Returns the target of the Edge
	 * @return the target node
	 */
	Node getTarget();
	
	/**
	 * Sets the target of the Edge
	 * @param target the target node of the Edge
	 * @return the current Edge
	 */
	Edge setTarget(Node target);
	
	/**
	 * Checks if the Edge has a label
	 * @return true if Edge has a label
	 */
	boolean hasLabel();
	
	/**
	 * Clears the label of the Edge
	 * @return the current Edge
	 */
	Edge clearLabel();
	
	/**
	 * Returns the label of the Edge
	 * @return the label as String
	 */
	String getLabel();
	
	/**
	 * Sets the label of the Edge
	 * @param label a label as String for the Edge
	 * @return the current Edge
	 */
	Edge setLabel(String label);
	
	/**
	 * Checks if the Edge has a weight
	 * @return true if the Edge has a weight
	 */
	boolean hasWeight();
	
	/**
	 * Clears the weight of the Edge
	 * @return the current Edge
	 */
	Edge clearWeight();
	
	/**
	 * Returns the weight of the Edge
	 * @return the weight as float
	 */
	float getWeight();
	
	/**
	 * Sets the weight for the Edge
	 * @param weight a float number indicating the weight
	 * @return the current Edge
	 */
	Edge setWeight(float weight);

	/**
	 * Returns the type of the Edge
	 * @return an EdgeType enum for that Edge
	 */
	EdgeType getEdgeType();
	
	/**
	 * Sets the type of the Edge
	 * @param edgeType an instance of the EdgeType enum
	 * @return the current Edge
	 */
	Edge setEdgeType(EdgeType edgeType);

	/**
	 * Checks if the Edge has a color
	 * @return true if the Edge has a color
	 */
	boolean hasColor();
	
	/**
	 * Clears the color of the Edge
	 * @return the current Edge
	 */
	Edge clearColor();
	
	/**
	 * Returns the color of the Edge
	 * @return a Color object for that Edge
	 */
	Color getColor();
	
	/**
	 * Sets the color of the Edge
	 * @param color an instance of Color
	 * @return the current Edge
	 */
	Edge setColor(Color color);

	/**
	 * Checks if the Edge has a thickness
	 * @return true if the Edge has a thickness
	 */
	boolean hasThickness();
	
	/**
	 * Clears the thickness of the Edge
	 * @return the current Edge
	 */
	Edge clearThickness();
	
	/**
	 * Returns the thickness of the Edge
	 * @return the thickness as float
	 */
	float getThickness();
	
	/**
	 * Sets the thickness of the Edge
	 * @param thickness a float number indicating the thickness
	 * @return the current Edge
	 */
	Edge setThickness(float thickness);

	/**
	 * Returns the shape of the Edge
	 * @return a EdgeShape enum for that Edge
	 */
	EdgeShape getShape();
	
	/**
	 * Sets the shape of the Edge
	 * @param shape an instance of the EdgeShape enum
	 * @return the current Edge
	 */
	Edge setShape(EdgeShape shape);	
}