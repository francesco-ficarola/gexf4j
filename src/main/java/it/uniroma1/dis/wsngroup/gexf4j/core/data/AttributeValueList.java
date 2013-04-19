package it.uniroma1.dis.wsngroup.gexf4j.core.data;

import java.util.List;

/**
 * Interface for the AttributeValueList
 *
 */
public interface AttributeValueList extends List<AttributeValue> {

	/**
	 * Adds a value in the list
	 * @param attribute
	 * @param value a value for the Attribute
	 * @return the current AttributeValueList
	 */
	AttributeValueList addValue(Attribute attribute, String value);
	
	/**
	 * Creates a value for the Attribute
	 * @param attribute the Attribute that you want to set
	 * @param value a value for the Attribute
	 * @return the current AttributeValueList
	 */
	AttributeValue createValue(Attribute attribute, String value);
}