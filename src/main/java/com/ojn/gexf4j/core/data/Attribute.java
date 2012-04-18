package com.ojn.gexf4j.core.data;

import java.util.List;

public interface Attribute {

	String getId();
	
	String getTitle();
	Attribute setTitle(String title);
	
	AttributeType getAttributeType();
	
	boolean hasDefaultValue();
	Attribute clearDefaultValue();
	String getDefaultValue();
	Attribute setDefaultValue(String defaultValue);
	
	List<String> getOptions();
	
	AttributeValue createValue(String value);
}