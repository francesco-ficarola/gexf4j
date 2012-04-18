package com.ojn.gexf4j.core.impl.viz;

import static com.google.common.base.Preconditions.*;

import com.ojn.gexf4j.core.viz.NodeShape;
import com.ojn.gexf4j.core.viz.NodeShapeEntity;

public class NodeShapeImpl implements NodeShapeEntity {

	private NodeShape shape = NodeShape.NOTSET;
	private String uri = null;
	
	public NodeShapeImpl() {
		// do nothing
	}
	
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
		return this;
	}
}