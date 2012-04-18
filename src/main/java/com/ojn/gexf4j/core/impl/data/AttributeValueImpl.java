package com.ojn.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.impl.dynamic.DynamicBase;

public class AttributeValueImpl extends DynamicBase<AttributeValue> implements AttributeValue {

	private Attribute attribute = null;
	private String value = "";
	
	public AttributeValueImpl(Attribute attribute) {
		checkArgument(attribute != null, "Attribute cannot be null.");
		this.attribute = attribute;
	}
	
	@Override
	protected AttributeValue getSelf() {
		return this;
	}

	@Override
	public Attribute getAttribute() {
		return attribute;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public AttributeValue setValue(String value) {
		checkArgument(value != null, "Value cannot be null.");
		this.value = value;
		return this;
	}
}