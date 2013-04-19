package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.Edge;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


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