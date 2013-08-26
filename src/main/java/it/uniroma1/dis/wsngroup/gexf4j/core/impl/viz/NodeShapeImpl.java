package it.uniroma1.dis.wsngroup.gexf4j.core.impl.viz;

import static com.google.common.base.Preconditions.*;
import it.uniroma1.dis.wsngroup.gexf4j.core.viz.NodeShape;
import it.uniroma1.dis.wsngroup.gexf4j.core.viz.NodeShapeEntity;

/**
 * NodeShapeImpl class is an implementation of the NodeShapeEntity interface.
 *
 */
public class NodeShapeImpl implements NodeShapeEntity {

	private NodeShape shape = NodeShape.NOTSET;
	private String uri = null;
	
	/**
	 * Constructs a NodeShapeImpl object
	 */
	public NodeShapeImpl() {}
	
	@Override
	public NodeShapeEntity clearUri() {
		uri = null;
		return this;
	}

	@Override
	public NodeShape getNodeShape() {
		return shape;
	}

	@Override
	public String getUri() {
		checkState(hasUri(), "URI has not been set.");
		return uri;
	}

	@Override
	public boolean hasUri() {
		return (uri != null);
	}

	@Override
	public NodeShapeEntity setNodeShape(NodeShape shape) {
		checkArgument(shape != NodeShape.NOTSET, "Node Shape cannot be NOTSET.");
		this.shape = shape;
		return this;
	}

	@Override
	public NodeShapeEntity setUri(String uri) {
		checkArgument(uri != null, "URI cannot be set to null.");
		this.uri = uri;
		return this;
	}
}