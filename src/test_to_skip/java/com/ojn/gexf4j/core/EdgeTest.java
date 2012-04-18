package com.ojn.gexf4j.core;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.impl.data.AttributeImpl;

public abstract class EdgeTest {

	protected abstract Node newNode();
	protected abstract Edge newEdge(String id, Node source, Node target);
	
	private Node s = null;
	private Node t = null;
	private String edgeId = "";
	private Edge e = null;
	
	@Before
	public void before() {
		s = newNode();
		t = newNode();
		edgeId = UUID.randomUUID().toString();
		e = newEdge(edgeId, s, t);	
	}
	
	@Test
	public void getId() {
		assertThat(e.getId(), is(equalTo(edgeId)));
	}
	
	@Test
	public void setLabelValid() {
		String label = UUID.randomUUID().toString();
		e.setLabel(label);
		assertThat(e.getLabel(), is(equalTo(label)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setLabelNull() {
		e.setLabel(null);
	}
	
	@Test
	public void getSource() {
		assertThat(e.getSource(), is(equalTo(s)));
	}
	
	@Test
	public void setTargetValid() {
		Node newTarget = newNode();
		e.setTarget(newTarget);
		
		assertThat(e.getTarget(), is(equalTo(newTarget)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setTargetNull() {
		e.setTarget(null);
	}
	
	@Test
	public void setWeight() {
		Random rnd = new Random();
		float weight = rnd.nextFloat();
		e.setWeight(weight);
		
		assertThat(e.getWeight(), is(equalTo(weight)));
	}
	
	@Test
	public void setEdgeType() {
		for (EdgeType et : EdgeType.values()) {
			e.setEdgeType(et);
			assertThat(e.getEdgeType(), is(equalTo(et)));
		}
	}
	
	@Test
	public void getAttributeValues() {
		Attribute attrib = new AttributeImpl(AttributeType.STRING, "test", AttributeClass.EDGE);
		AttributeValue av = attrib.createValue("testing");
		
		int a = e.getAttributeValues().size();
		e.getAttributeValues().add(av);
		int b = e.getAttributeValues().size();
		
		assertThat(b, is(equalTo(a+1)));
		assertThat(e.getAttributeValues().contains(av), is(true));
	}
}