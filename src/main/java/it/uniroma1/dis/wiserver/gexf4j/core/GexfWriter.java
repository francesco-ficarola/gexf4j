package it.uniroma1.dis.wiserver.gexf4j.core;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Interface for the GexfWriter tool.
 *
 */
public interface GexfWriter {

	/**
	 * Method to physically write the GEXF object in a file
	 * @param gexf the current object of the GEXF file
	 * @param out the OutputStream of the output file
	 * @throws IOException
	 */
	void writeToStream(Gexf gexf, OutputStream out) throws IOException;
}