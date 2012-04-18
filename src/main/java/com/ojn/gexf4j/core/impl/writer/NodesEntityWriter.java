package com.ojn.gexf4j.core.impl.writer;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Node;

public class NodesEntityWriter extends AbstractEntityWriter<List<Node>> {
	private static final String ENTITY = "nodes";
	private static final String ATTRIB_COUNT = "count";
	
	public NodesEntityWriter(XMLStreamWriter writer, List<Node> entity) {
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
		for (Node n : entity) {
			new NodeEntityWriter(writer, n);
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_COUNT,
				Integer.toString(entity.size()));
	}
}