package com.ojn.gexf4j.core.data;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public abstract class AttributeValueTest {

	protected abstract Attribute newAttribute();
	protected abstract AttributeValue newAttributeValue(Attribute attrib, String value);
	
	private String value = null;
	private Attribute attrib = null;
	private AttributeValue av = null;
	
	@Before
	public void before() {
		value = UUID.randomUUID().toString();
		attrib = newAttribute();
		av = newAttributeValue(attrib, value);
	}
	
	@Test
	public void valueFor() {
		assertThat(av.getAttribute(), is(equalTo(attrib)));
	}
	
	@Test
	public void setValueValid() {
		String newValue = UUID.randomUUID().toString();
		av.setValue(newValue);
		
		assertThat(av.getValue(), is(equalTo(newValue)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setValueNull() {
		av.setValue(null);
	}
}