package it.uniroma1.dis.wsngroup.gexf4j.core.impl;

import com.ctc.wstx.stax.WstxOutputFactory;

import it.uniroma1.dis.wsngroup.gexf4j.core.Gexf;
import it.uniroma1.dis.wsngroup.gexf4j.core.GexfWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer.GexfEntityWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.utils.PrettyPrintHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Proxy;

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
            XMLOutputFactory xmlOutputFactory = WstxOutputFactory.newInstance();
            XMLStreamWriter streamWriter = xmlOutputFactory.createXMLStreamWriter(out);
            
            PrettyPrintHandler handler = new PrettyPrintHandler(streamWriter);
            streamWriter = (XMLStreamWriter) Proxy.newProxyInstance(
            		XMLStreamWriter.class.getClassLoader(),
            		new Class[]{XMLStreamWriter.class},
            		handler );
            
            streamWriter.writeStartDocument(encoding, "1.0");

            new GexfEntityWriter(streamWriter, gexf);

            streamWriter.writeEndDocument();

            streamWriter.flush();
            streamWriter.close();

        } catch (XMLStreamException e) {
            throw new IOException("XML Exception: " + e.getMessage(), e);
        }
    }
    
    @Override
    public void writeToStream(Gexf gexf, OutputStream out, String encoding) throws IOException {
        writeToStream(gexf, new OutputStreamWriter(out, encoding), encoding);
    }
}