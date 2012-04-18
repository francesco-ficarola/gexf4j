package com.ojn.gexf4j.core;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import org.junit.Test;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.impl.data.AttributeImpl;

public abstract class NodeTest {

	protected abstract Node newNode(String id);

	@Test
	public void getId() {
		String id = UUID.randomUUID().toString();
		Node n = newNode(id);
		
		assertThat(n.getId(), is(equalTo(id)));
	}
	
	@Test
	public void setLabelValid() {
		String label= UUID.randomUUID().toString();
		Node n = newNode(UUID.randomUUID().toString());
		n.setLabel(label);
		
		assertThat(n.getLabel(), is(equalTo(label)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setLabelNull() {
		Node n = newNode(UUID.randomUUID().toString());
		n.setLabel(null);
	}
	
	@Test
	public void getAttributeValues() {
		Attribute attrib = new AttributeImpl(AttributeType.STRING, "test", AttributeClass.NODE);
		AttributeValue av = attrib.createValue("testing");
		Node n = newNode(UUID.randomUUID().toString());
		
		int a = n.getAttributeValues().size();
		n.getAttributeValues().add(av);
		int b = n.getAttributeValues().size();
		
		assertThat(b, is(equalTo(a+1)));
		assertThat(n.getAttributeValues().contains(av), is(true));
	}
	
	@Test
	public void getEdges() {
		Node n1 = newNode(UUID.randomUUID().toString());
		Node n2 = newNode(UUID.randomUUID().toString());
		
		assertThat(n1.getEdges(), is(notNullValue()));
		
		n1.connectTo(n2);
		
		assertThat(n1.getEdges().size(), is(equalTo(1)));
	}
	
	@Test
	public void connectToValid() {
		Node n1 = newNode(UUID.randomUUID().toString());
		Node n2 = newNode(UUID.randomUUID().toString());
		
		n1.connectTo(n2);
		
		for (Edge e : n1.getEdges()) {
			assertThat(e.getSource(), is(equalTo(n1)));
			assertThat(e.getTarget(), is(equalTo(n2)));
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToNull() {
		Node n = newNode(UUID.randomUUID().toString());
		n.connectTo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToIdNull() {
		Node n1 = newNode(UUID.randomUUID().toString());
		Node n2 = newNode(UUID.randomUUID().toString());
		n1.connectTo(null, n2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToIdBlank() {
		Node n1 = newNode(UUID.randomUUID().toString());
		Node n2 = newNode(UUID.randomUUID().toString());
		n1.connectTo("   ", n2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToIdDupe() {
		String id = UUID.randomUUID().toString();
		Node n1 = newNode(UUID.randomUUID().toString());
		Node n2 = newNode(UUID.randomUUID().toString());
		Node n3 = newNode(UUID.randomUUID().toString());
		n1.connectTo(id, n2);
		n1.connectTo(id, n3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToIdNodeNull() {
		Node n = newNode(UUID.randomUUID().toString());
		n.connectTo(UUID.randomUUID().toString(), null);
	}
	
	@Test
	public void connectToIdValid() {
		Node n1 = newNode(UUID.randomUUID().toString());
		Node n2 = newNode(UUID.randomUUID().toString());
		n1.connectTo(UUID.randomUUID().toString(), n2);
		
		for (Edge e : n1.getEdges()) {
			assertThat(e.getSource(), is(equalTo(n1)));
			assertThat(e.getTarget(), is(equalTo(n2)));
		}
	}
	
	@Test
	public void hasEdgeToValid() {
		Node n1 = newNode(UUID.randomUUID().toString());
		Node n2 = newNode(UUID.randomUUID().toString());
		Node n3 = newNode(UUID.randomUUID().toString());
		
		n1.connectTo(n2);
		
		assertThat(n1.hasEdgeTo(n2.getId()), is(true));
		assertThat(n1.hasEdgeTo(n3.getId()), is(false));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void hasEdgeToNull() {
		Node n = newNode(UUID.randomUUID().toString());
		n.hasEdgeTo(null);
	}
}