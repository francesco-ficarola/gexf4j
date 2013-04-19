package it.uniroma1.dis.wsngroup.gexf4j.core.data;

import it.uniroma1.dis.wsngroup.gexf4j.core.Mode;
import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Dynamic;

import java.util.List;

/**
 * Interface for the AttributeList
 *
 */
public interface AttributeList extends List<Attribute>, Dynamic<AttributeList> {
	
	/**
	 * Returns the AttributeClass for the list of Attributes
	 * @return an AttributeClass enum for that list
	 */
	AttributeClass getAttributeClass();
	
	/**
	 * Returns the Mode of the list of Attributes
	 * @return a Mode enum
	 */
	Mode getMode();
	
	/**
	 * Sets the Mode for that list of Attributes
	 * @param mode an instance of Mode enum
	 * @return the current AttributeList
	 */
	AttributeList setMode(Mode mode);
	
	/**
	 * Creates and adds an Attribute to the AttributeList
	 * @param type the type of the Attribute as AttributeType enum
	 * @param title the title of the Attribute as String
	 * @return the built Attribute
	 */
	Attribute createAttribute(AttributeType type, String title);
	
	/**
	 * Creates and adds an Attribute to the AttributeList
	 * @param id the ID of the Attribute as String
	 * @param type the type of the Attribute as AttributeType enum
	 * @param title the title of the Attribute as String
	 * @return the built Attribute
	 */
	Attribute createAttribute(String id, AttributeType type, String title);
	
	/**
	 * Creates and adds an Attribute to the AttributeList
	 * @param type the type of the Attribute as AttributeType enum
	 * @param title the title of the Attribute as String
	 * @return the current AttributeList
	 */
	AttributeList addAttribute(AttributeType type, String title);
	
	/**
	 * Creates and adds an Attribute to the AttributeList
	 * @param id the ID of the Attribute as String
	 * @param type the type of the Attribute as AttributeType enum
	 * @param title the title of the Attribute as String
	 * @return the current AttributeList
	 */
	AttributeList addAttribute(String id, AttributeType type, String title);
}