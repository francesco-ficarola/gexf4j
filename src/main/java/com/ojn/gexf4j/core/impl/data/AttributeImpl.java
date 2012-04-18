package com.ojn.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.List;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;

public class AttributeImpl implements Attribute {

	private String id = "";
	private String defaultValue = null;
	private AttributeType type = AttributeType.STRING;
	private List<String> options = null;
	private String title = "";
	
	public AttributeImpl(String id, AttributeType type, String title) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		checkArgument(title != null, "Title cannot be null.");
		checkArgument(!title.trim().isEmpty(), "Title cannot be null or blank.");
		
		this.id = id;
		this.type = type;
		this.options = new ArrayList<String>();
		this.title = title;
	}
	
	@Override
	public Attribute clearDefaultValue() {
		defaultValue = null;
		return this;
	}

	@Override
	public AttributeType getAttributeType() {
		return type;
	}

	@Override
	public String getDefaultValue() {
		checkState(hasDefaultValue(), "Default Value has not been set.");
		return defaultValue;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public List<String> getOptions() {
		return options;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public boolean hasDefaultValue() {
		return (defaultValue != null);
	}

	@Override
	public Attribute setDefaultValue(String defaultValue) {
		checkArgument(defaultValue != null, "Default Value cannot be null.");
		this.defaultValue = defaultValue;
		return this;
	}

	@Override
	public Attribute setTitle(String title) {
		checkArgument(title != null, "Title cannot be null.");
		checkArgument(!title.trim().isEmpty(), "Title cannot be null or blank.");
		this.title = title;
		return this;
	}
	
	@Override
	public AttributeValue createValue(String value) {
		checkArgument(value != null, "Value cannot be null.");
		AttributeValue rv = new AttributeValueImpl(this);
		rv.setValue(value);
		return rv;
	}
}