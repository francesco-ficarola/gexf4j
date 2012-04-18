package com.ojn.gexf4j.core.data;

import com.ojn.gexf4j.core.dynamic.Dynamic;

public interface AttributeValue extends Dynamic<AttributeValue> {

	Attribute getAttribute();
	
	String getValue();
	AttributeValue setValue(String value);
}