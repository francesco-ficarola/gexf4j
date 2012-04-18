package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Node;

public class ParentEntityWriter extends AbstractEntityWriter<Node> {
	private static final String ENTITY = "parent";
	private static final String ATTRIB_FOR = "for";
	
	public ParentEntityWriter(XMLStreamWriter writer, Node entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_FOR,
				entity.getId());
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}