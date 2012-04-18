package com.ojn.gexf4j.core.impl;

import java.util.UUID;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeTest;
import com.ojn.gexf4j.core.Node;

public class EdgeImplTest extends EdgeTest {

	@Override
	protected Edge newEdge(String id, Node source, Node target) {
		return new EdgeImpl(id, source, target);
	}

	@Override
	protected Node newNode() {
		return new NodeImpl(UUID.randomUUID().toString());
	}
}