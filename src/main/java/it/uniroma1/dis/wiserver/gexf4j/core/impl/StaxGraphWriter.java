package it.uniroma1.dis.wiserver.gexf4j.core.impl;

import it.uniroma1.dis.wiserver.gexf4j.core.Gexf;
import it.uniroma1.dis.wiserver.gexf4j.core.GexfWriter;
import it.uniroma1.dis.wiserver.gexf4j.core.impl.writer.GexfEntityWriter;

import java.io.IOException;
import java.io.Writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * StaxGraphWriter class is an implementation of the GexfWriter interface.
 *
 */
public class StaxGraphWriter implements GexfWriter {

	@Override
	public void writeToStream(Gexf gexf, Writer out, String encoding) throws IOException {
		try {
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);
			
			writer.writeStartDocument(encoding, "1.0");
			
			new GexfEntityWriter(writer, gexf);
			
			writer.writeEndDocument();
			
			writer.flush();
			writer.close();
			
		} catch (XMLStreamException e) {
			throw new IOException("XML Exception: " + e.getMessage(), e);
		}
	}
}