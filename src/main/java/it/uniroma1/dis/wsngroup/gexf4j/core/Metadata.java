package it.uniroma1.dis.wsngroup.gexf4j.core;

import java.util.Date;
import java.util.List;

/**
 * Interface for Metadata.
 *
 */
public interface Metadata {

	/**
	 * Checks if the Metadata is empty
	 * @return true if the Metadata is empty
	 */
	boolean isEmpty();
	
	/**
	 * Clears Metadata
	 * @return the current Metadata
	 */
	Metadata clearMetadata();
	
	/**
	 * Checks if the GEXF file has a value for the field lastmodifieddate
	 * @return true if the Metadata has a value for the field lastmodifieddate
	 */
	boolean hasLastModified();
	
	/**
	 * Clears the lastmodifieddate field
	 * @return the current Metadata
	 */
	Metadata clearLastModified();
	
	/**
	 * Returns the value of the lastmodifieddate field
	 * @return the last modified date as Date
	 */
	Date getLastModified();
	
	/**
	 * Sets the value for the lastmodifieddate field
	 * @param lastModified an instance of Date
	 * @return the current Metadata
	 */
	Metadata setLastModified(Date lastModified);
	
	/**
	 * Checks if the GEXF file has a creator
	 * @return true if the Metadata has a creator
	 */
	boolean hasCreator();
	
	/**
	 * Clears the creator field
	 * @return the current Metadata
	 */
	Metadata clearCreator();
	
	/**
	 * Returns the creator of the GEXF file
	 * @return the creator as String
	 */
	String getCreator();
	
	/**
	 * Sets the creator for the GEXF file
	 * @param creator the author as String
	 * @return the current Metadata
	 */
	Metadata setCreator(String creator);
	
	/**
	 * Checks if the GEXF file has a description
	 * @return true if the GEXF file has a description
	 */
	boolean hasDescription();
	
	/**
	 * Clears the description of the GEXF file
	 * @return the current Metadata
	 */
	Metadata clearDescription();
	
	/**
	 * Returns the description of the GEXF file
	 * @return the description as String
	 */
	String getDescription();
	
	/**
	 * Sets the description for the GEXF file
	 * @param description the description as String
	 * @return the current Metadata
	 */
	Metadata setDescription(String description);
	
	/**
	 * Returns a list of keywords of the GEXF file
	 * @return a list of keywords
	 */
	List<String> getKeywords();
}