package com.ojn.gexf4j.core.impl;

import com.ojn.gexf4j.core.GexfWriter;
import com.ojn.gexf4j.core.GraphWriterTest;
import com.ojn.gexf4j.core.testgraphs.GexfBuilder;

public class StaxGraphWriterTest extends GraphWriterTest {

	public StaxGraphWriterTest(GexfBuilder builder) {
		super(builder);
	}

	@Override
	protected String getFileNamePrefix() {
		return "stax";
	}

	@Override
	protected GexfWriter newGraphWriter() {
		return new StaxGraphWriter();
	}
}