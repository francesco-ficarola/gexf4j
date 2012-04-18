package com.ojn.gexf4j.core.impl.reader;


public class GexfEntityParser { /*extends AbstractEntityParser<Graph> {
	private static final String ATTRIB_VERSION = "version";
	private static final String ENTITY_META = "meta";
	private static final String ENTITY_GRAPH = "graph";
	
	private Graph graph = null;
	
	public GexfEntityParser(XMLStreamReader reader) {
		super(reader);
		graph = new GraphImpl();
		parse();
	}
	
	@Override
	protected void onAttribute(String name, String value) {
		if (ATTRIB_VERSION.equalsIgnoreCase(name)) {
			// ensure it is version 1.1
		}
	}
	
	@Override
	protected void onStartElement(XMLStreamReader reader) {
		if (ENTITY_META.equalsIgnoreCase(reader.getLocalName())) {
			new MetaEntityParser(reader, graph);
			
		} else if (ENTITY_GRAPH.equalsIgnoreCase(reader.getLocalName())) {
			new GraphEntityParser(reader, graph);
		}
	}
	
	public Graph getGraph() {
		return graph;
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
		// do nothing
	} */
}