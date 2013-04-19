package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.Gexf;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class GexfEntityWriter extends AbstractEntityWriter<Gexf> {
	private static final String ENTITY = "gexf";
	private static final String ATTRIBUTE_VERSION = "version";
	private static final String ATTRIBUTE_VARIANT = "variant";
	private static final String XMLNS_URL = "http://www.gexf.net/1.2draft";
	private static final String XMLNS_VIZ = "viz";
	private static final String XMLNS_VIZ_URL = "http://www.gexf.net/1.2draft/viz";
    
	public GexfEntityWriter(XMLStreamWriter writer, Gexf entity) {
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
				ATTRIBUTE_VERSION,
				entity.getVersion());
		
		if (entity.hasVariant()) {
			writer.writeAttribute(
					ATTRIBUTE_VARIANT,
					entity.getVariant());
		}
	}

	@Override
	protected void writeStartElement() throws XMLStreamException {
		writer.writeStartElement(getElementName());
		writer.writeDefaultNamespace(XMLNS_URL);
		
		if (entity.hasVisualization()) {
			writer.writeNamespace(XMLNS_VIZ, XMLNS_VIZ_URL);
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		new MetadataEntityWriter(writer, entity.getMetadata());
		new GraphEntityWriter(writer, entity.getGraph());
	}
}