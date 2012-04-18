package com.ojn.gexf4j.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

import com.ojn.gexf4j.core.testgraphs.BasicGraphBuilder;
import com.ojn.gexf4j.core.testgraphs.DataGraphBuilder;
import com.ojn.gexf4j.core.testgraphs.DynamicGraphBuilder;
import com.ojn.gexf4j.core.testgraphs.GexfBuilder;
import com.ojn.gexf4j.core.testgraphs.HierarchyInlineBuilder;
import com.ojn.gexf4j.core.testgraphs.HierarchyPIDBuilder;
import com.ojn.gexf4j.core.testgraphs.PhylogenyBuilder;
import com.ojn.gexf4j.core.testgraphs.VisualizationBuilder;

@RunWith(Parameterized.class)
public abstract class GraphWriterTest {

	protected abstract String getFileNamePrefix();
	protected abstract GexfWriter newGraphWriter();

	protected GexfBuilder builder = null;
	
	@Parameters
	public static List<Object[]> getData() {
		List<Object[]> rv = new ArrayList<Object[]>();
		
		rv.add(new GexfBuilder[] { new BasicGraphBuilder() });
		rv.add(new GexfBuilder[] { new DataGraphBuilder() });
		rv.add(new GexfBuilder[] { new DynamicGraphBuilder() });
		rv.add(new GexfBuilder[] { new HierarchyInlineBuilder() });
		rv.add(new GexfBuilder[] { new HierarchyPIDBuilder() });
		rv.add(new GexfBuilder[] { new PhylogenyBuilder() });
		rv.add(new GexfBuilder[] { new VisualizationBuilder() });
		
		return rv;
	}
	
	public GraphWriterTest(GexfBuilder builder) {
		this.builder = builder;
	}

	@Test
	public void writeToStream() throws SAXException, IOException {
		Gexf gexf = builder.buildGexf();
		GexfWriter gw = newGraphWriter();
		String fileName = "target/" + getFileNamePrefix() + "_" + builder.getSuffix() + ".gexf";
		File f = new File(fileName);
		FileOutputStream fos = new FileOutputStream(f);
		
		gw.writeToStream(gexf, fos);
		
		URL schemaFile = new URL(builder.getSchemaUrl());
		Source xmlFile = new StreamSource(f);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();

		validator.validate(xmlFile);
	}
}