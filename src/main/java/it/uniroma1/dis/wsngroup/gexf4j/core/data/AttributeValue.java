package it.uniroma1.dis.wsngroup.gexf4j.core.data;

import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Dynamic;

/**
 * Interface for the AttributeValue.
 *
 */
public interface AttributeValue extends Dynamic<AttributeValue> {

	/**
	 * Returns the Attribute
	 * @return an instance of the Attribute class
	 */
	Attribute getAttribute();
	
	/**
	 * Returns the value of the Attribute
	 * @return the value as String
	 */
	String getValue();
	
	/**
	 * Sets the value for that Attribute
	 * @param value the value of the Attribute
	 * @return the current AttributeValue
	 */
	AttributeValue setValue(String value);
}