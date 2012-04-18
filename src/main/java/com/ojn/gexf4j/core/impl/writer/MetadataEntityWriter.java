package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.google.common.base.Joiner;
import com.ojn.gexf4j.core.Metadata;

public class MetadataEntityWriter extends AbstractEntityWriter<Metadata> {
	private static final String ENTITY = "meta";
	private static final String ENTITY_CREATOR = "creator";
	private static final String ENTITY_DESCRIPTION = "description";
	private static final String ENTITY_KEYWORDS = "keywords";
	private static final String ATTRIB_LASTMODIFIED = "lastmodifieddate";
	
	public MetadataEntityWriter(XMLStreamWriter writer, Metadata entity) {
		super(writer, entity);
		if (!entity.isEmpty()) {
			write();
		}
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		if (entity.hasLastModified()) {
			writer.writeAttribute(
					ATTRIB_LASTMODIFIED,
					AbstractEntityWriter.toDateString(entity.getLastModified()));
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		if (entity.hasCreator()) {
			new StringEntityWriter(writer, ENTITY_CREATOR, entity.getCreator());
		}
		
		if (entity.hasDescription()) {
			new StringEntityWriter(writer, ENTITY_DESCRIPTION, entity.getDescription());
		}
		
		if (!entity.getKeywords().isEmpty()) {
			String keywords = Joiner.on(',').skipNulls().join(entity.getKeywords());
			new StringEntityWriter(writer, ENTITY_KEYWORDS, keywords);
		}
	}
}