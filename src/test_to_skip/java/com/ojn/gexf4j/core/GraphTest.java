package com.ojn.gexf4j.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Map;
import java.util.UUID;

import org.junit.Test;

public abstract class GraphTest {

	protected abstract Graph newGraph();
	
	@Test
	public void defaultEdgeTypeValid() {
		Graph g = newGraph();
		for (EdgeType edgeType : EdgeType.values()) {
			g.setDefaultEdgeType(edgeType);
			assertThat(g.getDefaultEdgeType(), is(equalTo(edgeType)));
		}
	}
	
	@Test
	public void modeValid() {
		Graph g = newGraph();
		for (Mode gm : Mode.values()) {
			g.setMode(gm);
			assertThat(g.getMode(), is(equalTo(gm)));
		}
	}
	
	@Test
	public void createNode() {
		Graph g = newGraph();
		g.createNode();
	}
	
	@Test
	public void createNodeId() {
		Graph g = newGraph();
		String id = UUID.randomUUID().toString();
		Node n = g.createNode(id);
		
		assertThat(n, is(notNullValue()));
		assertThat(n.getId(), is(equalTo(id)));
		assertThat(g.getNodeMap().containsKey(id), is(true));
		assertThat(g.getNodeMap().get(id), is(equalTo(n)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdNull() {
		Graph g = newGraph();
		g.createNode(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdBlank() {
		Graph g = newGraph();
		g.createNode("   ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdDuplicate() {
		Graph g = newGraph();
		String id = UUID.randomUUID().toString();
		g.createNode(id);
		g.createNode(id);
	}
	
	@Test
	public void getNodeMap() {
		Graph g = newGraph();
		
		String id1 = UUID.randomUUID().toString();
		String id2 = UUID.randomUUID().toString();
		
		Node n1 = g.createNode(id1);
		Node n2 = g.createNode(id2);
		Node n3 = g.createNode();
		
		Map<String, Node> map = g.getNodeMap();
		
		assertThat(map.size(), is(equalTo(3)));
		assertThat(map.containsKey(id1), is(true));
		assertThat(map.containsKey(id2), is(true));
		assertThat(map.containsValue(n1), is(true));
		assertThat(map.containsValue(n2), is(true));
		assertThat(map.containsValue(n3), is(true));
		assertThat(map.get(id1), is(equalTo(n1)));
		assertThat(map.get(id2), is(equalTo(n2)));
	}
}