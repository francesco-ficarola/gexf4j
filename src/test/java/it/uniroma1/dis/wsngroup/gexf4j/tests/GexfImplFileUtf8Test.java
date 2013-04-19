package it.uniroma1.dis.wsngroup.gexf4j.tests;

import it.uniroma1.dis.wsngroup.gexf4j.core.EdgeType;
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

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.ResourceBundle;
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
public class GexfImplFileUtf8Test {

    private ResourceBundle bundle = ResourceBundle.getBundle("strings");
    private final GexfImpl gexf;

    public GexfImplFileUtf8Test() {


        gexf = new GexfImpl();
        Calendar date = Calendar.getInstance();
        date.set(2012, 4, 02);
        gexf.getMetadata()
                .setLastModified(date.getTime())
                .setCreator("Gephi.org")
                .setDescription("LONG utf string ĄČĘĖĮŠŲŪ() ąčęėįšųū90");

        Graph graph = gexf.getGraph();
        graph.setDefaultEdgeType(EdgeType.UNDIRECTED).setMode(Mode.STATIC);

        AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
        graph.getAttributeLists().add(attrList);

        Attribute attrSome = attrList.createAttribute("0", AttributeType.STRING, "someThing");


        Node gephi = graph.createNode("0");
        gephi
                .setLabel(bundle.getString("name"))
                .getAttributeValues()
                .addValue(attrSome, "Some string");

        Node webatlas = graph.createNode("1");
        webatlas
                .setLabel(bundle.getString("string"))
                .getAttributeValues()
                .addValue(attrSome, bundle.getString("string.two"));


        gephi.connectTo("0", webatlas);
        webatlas.connectTo("1", gephi);

    }

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
        StaxGraphWriter graphWriter = new StaxGraphWriter();
        StringWriter stringWriter = new StringWriter();

        graphWriter.writeToStream(gexf, new FileWriter("target/testStaticUtf.gexf"), "UTF-8");
        graphWriter.writeToStream(gexf, stringWriter, "UTF-8");
        String found = IOUtils.toString(new FileReader("target/testStaticUtf.gexf"));
        String start = stringWriter.toString();


        Diff myDiff = new Diff(found, start);

//        myDiff.overrideElementQualifier(new ElementNameAndTextQualifier());
        assertTrue("XML similar " + myDiff.toString(),
                myDiff.similar());
    }

    @Test
    public void testStaticGexfGraphStreams() throws IOException, SAXException {
        System.out.println("testStaticGexfGraphStreams");

        StaxGraphWriter graphWriter = new StaxGraphWriter();
        StringWriter stringWriter = new StringWriter();

        graphWriter.writeToStream(gexf, new FileOutputStream("target/testStaticUtf2.gexf"), "UTF-8");
        graphWriter.writeToStream(gexf, stringWriter, "UTF-8");
        String found = IOUtils.toString(new InputStreamReader(new FileInputStream("target/testStaticUtf2.gexf"), "UTF-8"));
        String start = stringWriter.toString();


        InputStream inputStream = GexfImplFileUtf8Test.class.getResourceAsStream("/testStaticUtf.gexf");
        String control = IOUtils.toString(inputStream, "UTF-8");

        System.out.println(start);
        Diff myDiff = new Diff(found, start);

//        myDiff.overrideElementQualifier(new ElementNameAndTextQualifier());
        assertTrue("XML similar " + myDiff.toString(),
                myDiff.similar());



        Diff secondDiff = new Diff(found, control);

//        myDiff.overrideElementQualifier(new ElementNameAndTextQualifier());
        assertTrue("XML similar " + secondDiff.toString(),
                secondDiff.similar());
    }

    @Test
    public void testStaticGexfGraphAgaintControl() throws IOException, SAXException {
        System.out.println("testStaticGexfGraphAgaintControl");

        StaxGraphWriter graphWriter = new StaxGraphWriter();
        StringWriter stringWriter = new StringWriter();

        graphWriter.writeToStream(gexf, stringWriter, "UTF-8");
        String start = stringWriter.toString();
        
        assertTrue(start.contains("LONG utf string ĄČĘĖĮŠŲŪ() ąčęėįšųū90"));
        
        InputStream inputStream = GexfImplFileUtf8Test.class.getResourceAsStream("/testStaticUtf.gexf");
        String control = IOUtils.toString(inputStream, "UTF-8");

        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                new FileOutputStream("target/testStaticGexfGraphAgaintControl.gexf"), "UTF-8"));
        out.write(control);
        out.close();

        System.out.println(start);
        System.out.println(control);
        Diff myDiff = new Diff(control, start);

//        myDiff.overrideElementQualifier(new ElementNameAndTextQualifier());
        assertTrue("XML similar " + myDiff.toString(),
                myDiff.similar());
    }
}
