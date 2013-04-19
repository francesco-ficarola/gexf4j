package it.uniroma1.dis.wsngroup.gexf4j.core.data;

import java.util.List;

/**
 * Interface for the Attributes.
 *
 */
public interface Attribute {

	/**
	 * Returns the ID of the Attribute
	 * @return the ID as String
	 */
	String getId();
	
	/**
	 * Returns the title of the Attribute
	 * @return the title as String
	 */
	String getTitle();
	
	/**
	 * Sets the title of the Attribute
	 * @param title the Attribute's title as String
	 * @return the current Attribute
	 */
	Attribute setTitle(String title);
	
	/**
	 * Returns the type of the Attribute
	 * @return an AttributeType enum for that Attribute
	 */
	AttributeType getAttributeType();
	
	/**
	 * Checks if the Attribute has a default value
	 * @return true if the Attribute has a default value
	 */
	boolean hasDefaultValue();
	
	/**
	 * Clears the default value of the Attribute
	 * @return the current Attribute
	 */
	Attribute clearDefaultValue();
	
	/**
	 * Returns the default value of the Attribute
	 * @return the default value as String
	 */
	String getDefaultValue();
	
	/**
	 * Sets the default value of the Attribute
	 * @param defaultValue the default value as String
	 * @return the current Attribute
	 */
	Attribute setDefaultValue(String defaultValue);
	
	/**
	 * Returns the list of the Attribute's options
	 * @return the list of the options
	 */
	List<String> getOptions();
	
	/**
	 * Creates a value for that Attribute
	 * @param value the value of the Attribute as String
	 * @return an instance of the AttributeValue class
	 */
	AttributeValue createValue(String value);
}