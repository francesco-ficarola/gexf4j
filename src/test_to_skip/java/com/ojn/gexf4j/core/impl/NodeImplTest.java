package com.ojn.gexf4j.core.impl;

import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.NodeTest;

public class NodeImplTest extends NodeTest {

	@Override
	protected Node newNode(String id) {
		return new NodeImpl(id);
	}
}