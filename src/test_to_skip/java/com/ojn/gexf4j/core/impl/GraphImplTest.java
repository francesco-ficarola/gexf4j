package com.ojn.gexf4j.core.impl;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GraphTest;

public class GraphImplTest extends GraphTest {

	@Override
	protected Graph newGraph() {
		return new GraphImpl();
	}
}