package it.uniroma1.dis.wsngroup.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeValue;

import java.util.ArrayList;
import java.util.List;

/**
 * AttributeImpl class is an implementation of the Attribute interface.
 *
 */
public class AttributeImpl implements Attribute {

	private String id = "";
	private String defaultValue = null;
	private AttributeType type = AttributeType.STRING;
	private List<String> options = null;
	private String title = "";
	
	/**
	 * Constructs an Attribute object with ID, type and title
	 * @param id the ID of the Attribute
	 * @param type an instance of AttributeType enum
	 * @param title the title of the Attribute
	 */
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