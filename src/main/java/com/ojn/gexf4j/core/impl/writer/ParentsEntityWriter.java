package com.ojn.gexf4j.core.impl.writer;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Node;

public class ParentsEntityWriter extends AbstractEntityWriter<List<Node>>{
	private static final String ENTITY = "parents";
	
	public ParentsEntityWriter(XMLStreamWriter writer, List<Node> entity) {
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
			new ParentEntityWriter(writer, n);
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
	}
}