package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;

public interface Metadata {

	boolean isEmpty();
	Metadata clearMetadata();
	
	boolean hasLastModified();
	Metadata clearLastModified();
	Date getLastModified();
	Metadata setLastModified(Date lastModified);
	
	boolean hasCreator();
	Metadata clearCreator();
	String getCreator();
	Metadata setCreator(String creator);
	
	boolean hasDescription();
	Metadata clearDescription();
	String getDescription();
	Metadata setDescription(String description);
	
	List<String> getKeywords();
}