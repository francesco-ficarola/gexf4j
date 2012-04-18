package com.ojn.gexf4j.core;

import java.io.IOException;
import java.io.OutputStream;

public interface GexfWriter {

	void writeToStream(Gexf gexf, OutputStream out) throws IOException;
}