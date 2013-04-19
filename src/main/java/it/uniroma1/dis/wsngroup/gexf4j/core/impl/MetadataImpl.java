package it.uniroma1.dis.wsngroup.gexf4j.core.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import it.uniroma1.dis.wsngroup.gexf4j.core.Metadata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MetadataImpl class is an implementation of the Metadata interface.
 *
 */
public class MetadataImpl implements Metadata {

	private String creator = null;
	private String description = null;
	private List<String> keywords = null;
	private Date lastModified = null;
	
	/**
	 * This constructor is called by GexfImpl() constructor
	 */
	public MetadataImpl() {
		keywords = new ArrayList<String>();
	}
	
	@Override
	public List<String> getKeywords() {
		return keywords;
	}
	
	@Override
	public boolean hasCreator() {
		return (creator != null);
	}
	
	@Override
	public Metadata clearCreator() {
		creator = null;
		return this;
	}
	
	@Override
	public String getCreator() {
		checkState(hasCreator(), "Creator has not been set.");
		return creator;
	}
	
	@Override
	public Metadata setCreator(String creator) {
		checkArgument(creator != null, "Creator cannot be set to null.");
		this.creator = creator;
		return this;
	}
	
	@Override
	public boolean hasDescription() {
		return (description != null);
	}

	@Override
	public Metadata clearDescription() {
		description = null;
		return this;
	}
	
	@Override
	public String getDescription() {
		checkState(hasDescription(), "Description has not been set.");
		return description;
	}
	
	@Override
	public Metadata setDescription(String description) {
		checkArgument(description != null, "Description cannot be set to null.");
		this.description = description;
		return this;
	}
	
	@Override
	public boolean hasLastModified() {
		return (lastModified != null);
	}

	@Override
	public Metadata clearLastModified() {
		lastModified = null;
		return this;
	}
	
	@Override
	public Date getLastModified() {
		checkState(hasLastModified(), "Last Modified has not been set.");
		return lastModified;
	}
	
	@Override
	public Metadata setLastModified(Date lastModified) {
		checkArgument(lastModified != null, "Last Modified cannot be set to null.");
		this.lastModified = lastModified;
		return this;
	}

	@Override
	public Metadata clearMetadata() {
		creator = null;
		description = null;
		lastModified = null;
		keywords.clear();
		return this;
	}

	@Override
	public boolean isEmpty() {
		return (getKeywords().size() == 0 &&
				!hasCreator() &&
				!hasDescription() &&
				!hasLastModified());
	}	
}