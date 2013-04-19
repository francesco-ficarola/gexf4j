package it.uniroma1.dis.wsngroup.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;

import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeValue;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeValueList;

import java.util.ArrayList;

/**
 * AttributeValueListImpl class is an implementation of the AttributeValueList interface.
 *
 */
public class AttributeValueListImpl extends ArrayList<AttributeValue> implements AttributeValueList {
	private static final long serialVersionUID = 7730475001078826140L;

	/**
	 * Constructs an AttributeValueListImpl object
	 */
	public AttributeValueListImpl() {}
	
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