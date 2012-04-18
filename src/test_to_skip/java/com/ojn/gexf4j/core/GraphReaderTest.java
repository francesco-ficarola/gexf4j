package com.ojn.gexf4j.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;

import com.ojn.gexf4j.core.impl.StaxGraphReader;

public class GraphReaderTest {

	@Test
	public void quickTest() throws XMLStreamException, IOException {
		GexfReader gr = new StaxGraphReader();
		
		InputStream in = new FileInputStream(new File("target/stax_basic.gexf"));
        
		gr.readFromStream(in);
	}
}