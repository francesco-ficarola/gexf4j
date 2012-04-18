package com.ojn.gexf4j.core.data;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public abstract class AttributeTest {

	protected abstract Attribute newAttribute(AttributeType type, String id, AttributeClass attribClass);
	
	private String id = null;
	private Attribute attrib = null;
	
	@Before
	public void before() {
		id = UUID.randomUUID().toString();
		attrib = newAttribute(AttributeType.STRING, id, AttributeClass.NODE);
	}
	
	@Test
	public void getId() {
		assertThat(attrib.getId(), is(equalTo(id)));
	}
	
	@Test
	public void getAttributeType() {
		Attribute curAttrib = null;
		for (AttributeType at : AttributeType.values()) {
			curAttrib = newAttribute(at, UUID.randomUUID().toString(), AttributeClass.NODE);
			assertThat(curAttrib.getAttributeType(), is(equalTo(at)));
		}
	}
	
	@Test
	public void setTitleValid() {
		String title = UUID.randomUUID().toString();
		attrib.setTitle(title);
		
		assertThat(attrib.getTitle(), is(equalTo(title)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setTitleNull() {
		attrib.setTitle(null);
	}
	
	@Test
	public void createValueValid() {
		String value = UUID.randomUUID().toString();
		AttributeValue av = attrib.createValue(value);
		
		assertThat(av.getValue(), is(equalTo(value)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createValueNull() {
		attrib.createValue(null);
	}
	
	@Test
	public void setDefaultValueValid() {
		String defaultValue = UUID.randomUUID().toString();
		attrib.setDefaultValue(defaultValue);
		
		assertThat(attrib.getDefaultValue(), is(equalTo(defaultValue)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setDefaultValueNull() {
		attrib.setDefaultValue(null);
	}
}