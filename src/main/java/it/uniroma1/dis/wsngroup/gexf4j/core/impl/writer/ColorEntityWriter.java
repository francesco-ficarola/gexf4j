package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.viz.Color;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class ColorEntityWriter extends AbstractEntityWriter<Color> {
	private static final String ENTITY = "viz:color";
	private static final String ATTRIB_R = "r";
	private static final String ATTRIB_G = "g";
	private static final String ATTRIB_B = "b";
	
	public ColorEntityWriter(XMLStreamWriter writer, Color entity) {
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
				ATTRIB_R,
				Integer.toString(entity.getR()));
		
		writer.writeAttribute(
				ATTRIB_G,
				Integer.toString(entity.getG()));
		
		writer.writeAttribute(
				ATTRIB_B,
				Integer.toString(entity.getB()));
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}