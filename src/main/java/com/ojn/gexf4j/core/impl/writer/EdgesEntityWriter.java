package com.ojn.gexf4j.core.impl.writer;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Edge;

public class EdgesEntityWriter extends AbstractEntityWriter<List<Edge>> {
	private static final String ENTITY = "edges";
	private static final String ATTRIB_COUNT = "count";
	
	public EdgesEntityWriter(XMLStreamWriter writer, List<Edge> entity) {
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
	protected void writeElements() throws XMLStreamException {
		for (Edge e : entity) {
			new EdgeEntityWriter(writer, e);
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_COUNT,
				Integer.toString(entity.size()));
	}
}