package com.ojn.gexf4j.core.impl;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Gexf;
import com.ojn.gexf4j.core.GexfWriter;
import com.ojn.gexf4j.core.impl.writer.GexfEntityWriter;

public class StaxGraphWriter implements GexfWriter {

	@Override
	public void writeToStream(Gexf gexf, OutputStream out) throws IOException {
		try {
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);
			
			writer.writeStartDocument("1.0");
			
			new GexfEntityWriter(writer, gexf);
			
			writer.writeEndDocument();
			
			writer.flush();
			writer.close();
			
		} catch (XMLStreamException e) {
			throw new IOException("XML Exception: " + e.getMessage(), e);
		}
	}
}