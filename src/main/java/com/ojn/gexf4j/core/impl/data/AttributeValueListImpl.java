package com.ojn.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.data.AttributeValueList;

public class AttributeValueListImpl extends ArrayList<AttributeValue> implements AttributeValueList {
	private static final long serialVersionUID = 7730475001078826140L;

	public AttributeValueListImpl() {
		// do nothing
	}
	
	@Override
	public AttributeValueList addValue(Attribute attribute, String value) {
		createValue(attribute, value);
		return this;
	}

	@Override
	public AttributeValue createValue(Attribute attribute, String value) {
		checkArgument(value != null, "Value cannot be null.");
		
		AttributeValue rv = new AttributeValueImpl(attribute);
		rv.setValue(value);
		add(rv);
		
		return rv;
	}
}