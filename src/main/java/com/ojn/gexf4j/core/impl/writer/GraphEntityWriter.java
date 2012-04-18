package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.data.AttributeList;

public class GraphEntityWriter extends DynamicEntityWriter<Graph> {
	private static final String ENTITY = "graph";
	private static final String ATTRIB_EDGETYPE = "defaultedgetype";
	private static final String ATTRIB_MODE = "mode";
	private static final String ATTRIB_IDTYPE = "idtype";
	private static final String ATTRIB_TIMETYPE = "timeformat";
	
	public GraphEntityWriter(XMLStreamWriter writer, Graph entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		AbstractEntityWriter.writerTimeType = entity.getTimeType();
		
		writer.writeAttribute(
				ATTRIB_EDGETYPE,
				entity.getDefaultEdgeType().toString().toLowerCase());
		
		writer.writeAttribute(
				ATTRIB_IDTYPE,
				entity.getIDType().toString().toLowerCase());
		
		writer.writeAttribute(
				ATTRIB_MODE,
				entity.getMode().toString().toLowerCase());
		
		writer.writeAttribute(
				ATTRIB_TIMETYPE,
				AbstractEntityWriter.writerTimeType);
		
		/** Dynamic information */
		super.writeAttributes();
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		for (AttributeList attList : entity.getAttributeLists()) {
			new AttributesEntityWriter(writer, attList);
		}
		
		new NodesEntityWriter(writer, entity.getNodes());
		new EdgesEntityWriter(writer, entity.getAllEdges());
		super.writeElements();
	}
}