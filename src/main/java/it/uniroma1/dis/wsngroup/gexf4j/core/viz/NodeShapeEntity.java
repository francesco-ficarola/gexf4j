package it.uniroma1.dis.wsngroup.gexf4j.core.viz;

/**
 * Interface for the NodeShapeEntity.
 *
 */
public interface NodeShapeEntity {

	/**
	 * Returns the shape of the Node
	 * @return an instance of the NodeShape enum
	 */
	NodeShape getNodeShape();
	
	/**
	 * Sets the shape of the Node
	 * @param shape an instance of the NodeShape enum
	 * @return the current NodeShapeEntity
	 */
	NodeShapeEntity setNodeShape(NodeShape shape);
	
	/**
	 * Checks if the NodeShapeEntity has a URI
	 * @return true if the NodeShapeEntity has a URI
	 */
	boolean hasUri();
	
	/**
	 * Clears the URI of the NodeShapeEntity
	 * @return the current NodeShapeEntity
	 */
	NodeShapeEntity clearUri();
	
	/**
	 * Returns the URI of the NodeShapeEntity
	 * @return the URI as String
	 */
	String getUri();
	
	/**
	 * Sets the URI for the NodeShapeEntity
	 * @param uri the URI as String
	 * @return the current NodeShapeEntity
	 */
	NodeShapeEntity setUri(String uri);
}