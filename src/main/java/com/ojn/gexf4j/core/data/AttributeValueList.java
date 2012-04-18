package com.ojn.gexf4j.core.data;

import java.util.List;

public interface AttributeValueList extends List<AttributeValue> {

	AttributeValueList addValue(Attribute attribute, String value);
	
	AttributeValue createValue(Attribute attribute, String value);
}