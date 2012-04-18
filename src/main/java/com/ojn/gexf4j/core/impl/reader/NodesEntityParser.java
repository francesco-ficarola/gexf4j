package com.ojn.gexf4j.core.impl.reader;

import java.util.List;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;

public class NodesEntityParser extends AbstractEntityParser<List<Node>> {
	private static final String ENTITY_NODE = "node";
	
	private Graph graph = null;
	
	public NodesEntityParser(XMLStreamReader reader, Graph graph) {
		super(reader);
		this.graph = graph;
		parse();
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_NODE.equalsIgnoreCase(reader.getLocalName())) {
			new NodeEntityParser(reader, graph);
		}
	}

	@Override
	protected void onCharacters(XMLStreamReader reader) {
		// do nothing
	}

	@Override
	protected void onOther(XMLStreamReader reader, int eventType) {
		// do nothing
	}
	
	@Override
	protected void onAttribute(String name, String value) {
		// do nothing
	}

	@Override
	protected void onEndElement() {
		// do nothing
	}
}