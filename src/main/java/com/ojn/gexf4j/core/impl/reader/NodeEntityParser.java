package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;

public class NodeEntityParser extends AbstractEntityParser<Node> {
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_LABEL = "label";
	// private static final String ENTITY_ATTVALUES = "attvalues";
	
	private String id = "";
	private String label = "";
	// private List<AttributeValue> attributeValues = null;
	private Graph graph = null;
	
	public NodeEntityParser(XMLStreamReader reader, Graph graph) {
		super(reader);
		// attributeValues = new ArrayList<AttributeValue>();
		this.graph = graph;
		parse();
	}

	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_ID.equalsIgnoreCase(name)) {
			id = value;
			
		} else if (ATTRIB_LABEL.equalsIgnoreCase(name)) {
			label = value;
		}
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		/*if (ENTITY_ATTVALUES.equalsIgnoreCase(reader.getLocalName())) {
			AttValuesEntityParser avep = new AttValuesEntityParser(reader, attributes);
			attributeValues = avep.getEntity();
			attributeValues.size();
		}*/
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
	protected void onEndElement() {
		Node n = graph.createNode(id);
		n.setLabel(label);
	}
}