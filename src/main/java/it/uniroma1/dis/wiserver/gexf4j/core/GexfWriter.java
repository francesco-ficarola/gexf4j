package it.uniroma1.dis.wiserver.gexf4j.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Interface for the GexfWriter tool.
 *
 */
public interface GexfWriter {

    /**
     * Method to physically write the GEXF object in a file
     *
     * @param gexf the current object of the GEXF file
     * @param out the OutputStream of the output file
     * @throws IOException
     */
    void writeToStream(Gexf gexf, Writer out, String encoding) throws IOException;

    /**
     * Method to physically write the GEXF object in a file.
     * Stream version. Currently implementation wrap OutputStream
     * with OutputStreamWriter
     *
     * @param gexf the current object of the GEXF file
     * @param out the OutputStream of the output file
     * @throws IOException
     */
    void writeToStream(Gexf gexf, OutputStream out, String encoding) throws IOException;
}