package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.viz.Position;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class PositionEntityWriter extends AbstractEntityWriter<Position> {
	private static final String ENTITY = "viz:position";
	private static final String ATTRIB_X = "x";
	private static final String ATTRIB_Y = "y";
	private static final String ATTRIB_Z = "z";
	
	public PositionEntityWriter(XMLStreamWriter writer, Position entity) {
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
				ATTRIB_X,
				Float.toString(entity.getX()));
		
		writer.writeAttribute(
				ATTRIB_Y,
				Float.toString(entity.getY()));
		
		writer.writeAttribute(
				ATTRIB_Z,
				Float.toString(entity.getZ()));
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}