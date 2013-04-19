package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.Node;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class NodeEntityWriter extends SpellableDatumEntityWriter<Node> {
	private static final String ENTITY = "node";
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_LABEL = "label";
	private static final String ATTRIB_PID = "pid";
	
	public NodeEntityWriter(XMLStreamWriter writer, Node entity) {
		super(writer, entity);
		write();
	}
	
	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		super.writeAttributes();
		
		writer.writeAttribute(
				ATTRIB_ID,
				entity.getId());
		
		writer.writeAttribute(
				ATTRIB_LABEL,
				entity.getLabel());
		
		if (entity.hasPID()) {
			writer.writeAttribute(
					ATTRIB_PID,
					entity.getPID());
		}
	}
	
	@Override
	protected void writeElements() throws XMLStreamException {
		super.writeElements();
		
		if (entity.hasColor()) {
			new ColorEntityWriter(writer, entity.getColor());
		}
		
		if (entity.hasPosition()) {
			new PositionEntityWriter(writer, entity.getPosition());
		}
		
		if (entity.hasSize()) {
			new ValueEntityWriter<Object>(writer,
					"viz:size",
					entity.getSize());
		}
		
		if (entity.hasShape()) {
			new NodeShapeEntityWriter(writer, entity.getShapeEntity());
		}
		
		new ParentsEntityWriter(writer, entity.getParentForList());
		
		new NodesEntityWriter(writer, entity.getNodes());
		// TODO: Verify this is supposed to be commented out.
		// new EdgesEntityWriter(writer, entity.getAllEdges());
	}
}