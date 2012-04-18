package com.ojn.gexf4j.core;

import java.io.IOException;
import java.io.InputStream;

public interface GexfReader {

	Gexf readFromStream(InputStream in) throws IOException;
}