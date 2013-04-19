/*
 */
package it.uniroma1.dis.wsngroup.gexf4j.tests;

import it.uniroma1.dis.wsngroup.gexf4j.core.EdgeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.Gexf;
import it.uniroma1.dis.wsngroup.gexf4j.core.Graph;
import it.uniroma1.dis.wsngroup.gexf4j.core.Mode;
import it.uniroma1.dis.wsngroup.gexf4j.core.Node;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeClass;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeList;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.GexfImpl;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.StaxGraphWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.data.AttributeListImpl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * This test fails if one uses default JDK stax implementation
 * 
 * @author Tadas Subonis <tadas.subonis@gmail.com>
 */
public class GexfImplFileWritingTest {
    
    @Before
    public void setUp() {
        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreWhitespace(true);

        /*
         * Timezone issues for testing
         */
        System.setProperty("user.timezone", "Etc/GMT-2");
    }

    /**
     * Test of getGraph method, of class GexfImpl.
     */
    @Test
    public void testStaticGexfGraph() throws IOException, SAXException {
        System.out.println("getGraph");
        Gexf gexf = new GexfImpl();
        Calendar date = Calendar.getInstance();
        date.set(2012, 4, 02);
        gexf.getMetadata()
                .setLastModified(date.getTime())
                .setCreator("Gephi.org")
                .setDescription("A Web network");
        
        Graph graph = gexf.getGraph();
        graph.setDefaultEdgeType(EdgeType.UNDIRECTED).setMode(Mode.STATIC);
        
        AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
        graph.getAttributeLists().add(attrList);
        
        Attribute attUrl = attrList.createAttribute("0", AttributeType.STRING, "url");
        Attribute attIndegree = attrList.createAttribute("1", AttributeType.FLOAT, "indegree");
        Attribute attFrog = attrList.createAttribute("2", AttributeType.BOOLEAN, "frog")
                .setDefaultValue("true");
        
        
        Node gephi = graph.createNode("0");
        gephi
                .setLabel("Gephi")
                .getAttributeValues()
                .addValue(attUrl, "http://gephi.org")
                .addValue(attIndegree, "1");
        
        Node webatlas = graph.createNode("1");
        webatlas
                .setLabel("Webatlas")
                .getAttributeValues()
                .addValue(attUrl, "http://webatlas.fr")
                .addValue(attIndegree, "2");
        
        Node rtgi = graph.createNode("2");
        rtgi
                .setLabel("RTGI")
                .getAttributeValues()
                .addValue(attUrl, "http://rtgi.fr")
                .addValue(attIndegree, "1");
        
        Node blab = graph.createNode("3");
        blab
                .setLabel("BarabasiLab")
                .getAttributeValues()
                .addValue(attUrl, "http://barabasilab.com")
                .addValue(attIndegree, "1")
                .addValue(attFrog, "false");
        
        gephi.connectTo("0", webatlas);
        gephi.connectTo("1", rtgi);
        webatlas.connectTo("2", gephi);
        rtgi.connectTo("3", webatlas);
        gephi.connectTo("4", blab);
        
        StaxGraphWriter graphWriter = new StaxGraphWriter();
        StringWriter stringWriter = new StringWriter();
        
        graphWriter.writeToStream(gexf, new FileWriter("target/testStatic.gexf"), "UTF-8");
        graphWriter.writeToStream(gexf, stringWriter, "UTF-8");
        String found = IOUtils.toString(new FileReader("target/testStatic.gexf"));
        String start = stringWriter.toString();
        
        
        Diff myDiff = new Diff(found, start);

//        myDiff.overrideElementQualifier(new ElementNameAndTextQualifier());
        assertTrue("XML similar " + myDiff.toString(),
                myDiff.similar());
    }
}
