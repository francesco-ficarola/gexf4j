/*
 */
package it.uniroma1.dis.wsngroup.gexf4j.tests;

import it.uniroma1.dis.wsngroup.gexf4j.core.Edge;
import it.uniroma1.dis.wsngroup.gexf4j.core.EdgeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.Gexf;
import it.uniroma1.dis.wsngroup.gexf4j.core.Graph;
import it.uniroma1.dis.wsngroup.gexf4j.core.IntervalType;
import it.uniroma1.dis.wsngroup.gexf4j.core.Mode;
import it.uniroma1.dis.wsngroup.gexf4j.core.Node;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeClass;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeList;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Spell;
import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.TimeFormat;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.GexfImpl;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.SpellImpl;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.StaxGraphWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.data.AttributeListImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Calendar;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author Tadas Subonis <tadas.subonis@gmail.com>
 */
public class GexfImplDefaultTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
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

    @After
    public void tearDown() throws Exception {
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

        graphWriter.writeToStream(gexf, stringWriter, "UTF-8");

        String outputXml = stringWriter.toString();

        InputStream inputStream = GexfImplDefaultTest.class.getResourceAsStream("/staticGraph.gexf");
        String myControlXML = IOUtils.toString(inputStream, "UTF-8");

        System.out.println(outputXml);
        System.out.println(myControlXML);
        Diff myDiff = new Diff(myControlXML, outputXml);

//        myDiff.overrideElementQualifier(new ElementNameAndTextQualifier());
        assertTrue("XML similar " + myDiff.toString(),
                myDiff.similar());
    }

    @Test
    public void testDynamicGexfGraph() throws IOException, SAXException {
        Gexf gexf = new GexfImpl();
        Calendar date = Calendar.getInstance();
        date.set(2012, 4, 03);
//        date.setTimeZone(TimeZone.getTimeZone("GMT+0300"));
        gexf.getMetadata()
                .setLastModified(date.getTime())
                .setCreator("Gephi.org")
                .setDescription("A Web network");


        Graph graph = gexf.getGraph();
        graph.
                setDefaultEdgeType(EdgeType.UNDIRECTED)
                .setMode(Mode.DYNAMIC)
                .setTimeType(TimeFormat.XSDDATETIME);

        AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
        graph.getAttributeLists().add(attrList);

        Attribute attUrl = attrList.createAttribute("0", AttributeType.STRING, "url");
        Attribute attIndegree = attrList.createAttribute("1", AttributeType.FLOAT, "indegree");
        Attribute attFrog = attrList.createAttribute("2", AttributeType.BOOLEAN, "frog")
                .setDefaultValue("true");


        /**
         * Node Gephi
         */
        Node gephi = graph.createNode("0");
        gephi
                .setLabel("Gephi")
                .getAttributeValues()
                .addValue(attUrl, "http://gephi.org")
                .addValue(attIndegree, "1");

        Spell spellGephi = new SpellImpl();
        date.set(2012, 3, 28, 16, 10, 0);
        date.set(Calendar.MILLISECOND, 0);
        spellGephi.setStartValue(date.getTime());
        gephi.getSpells().add(spellGephi);


        /**
         * Node Webatlas
         */
        Node webatlas = graph.createNode("1");
        webatlas
                .setLabel("Webatlas")
                .getAttributeValues()
                .addValue(attUrl, "http://webatlas.fr")
                .addValue(attIndegree, "2");

        Spell spellWebatlas1 = new SpellImpl();
        date.set(Calendar.MINUTE, 15);
        spellWebatlas1.setStartValue(date.getTime());
        date.set(2012, 3, 28, 18, 57, 2);
        spellWebatlas1.setEndValue(date.getTime());
        webatlas.getSpells().add(spellWebatlas1);

        Spell spellWebatlas2 = new SpellImpl();
        date.set(2012, 3, 28, 20, 31, 10);
        spellWebatlas2.setStartValue(date.getTime()).setStartIntervalType(IntervalType.OPEN);
        date.set(Calendar.MINUTE, 45);
        date.set(Calendar.SECOND, 21);
        spellWebatlas2.setEndValue(date.getTime());
        webatlas.getSpells().add(spellWebatlas2);

        Spell spellWebatlas3 = new SpellImpl();
        date.set(2012, 3, 28, 21, 0, 0);
        spellWebatlas3.setStartValue(date.getTime());
        date.set(2012, 4, 11, 10, 49, 27);
        spellWebatlas3.setEndValue(date.getTime()).setEndIntervalType(IntervalType.OPEN);
        webatlas.getSpells().add(spellWebatlas3);


        /**
         * Node RTGI
         */
        Node rtgi = graph.createNode("2");
        rtgi
                .setLabel("RTGI")
                .getAttributeValues()
                .addValue(attUrl, "http://rtgi.fr")
                .addValue(attIndegree, "1");

        Spell spellRtgi = new SpellImpl();
        date.set(2012, 3, 27, 6, 0, 0);
        spellRtgi.setStartValue(date.getTime());
        date.set(2012, 4, 19);
        spellRtgi.setEndValue(date.getTime());
        rtgi.getSpells().add(spellRtgi);


        /**
         * Node BarabasiLab
         */
        Node blab = graph.createNode("3");
        blab
                .setLabel("BarabasiLab")
                .getAttributeValues()
                .addValue(attUrl, "http://barabasilab.com")
                .addValue(attIndegree, "3")
                .addValue(attFrog, "false");


        /**
         * Node foobar
         */
        Node foobar = graph.createNode("4");
        foobar
                .setLabel("FooBar")
                .getAttributeValues()
                .addValue(attUrl, "http://foo.bar")
                .addValue(attIndegree, "1")
                .addValue(attFrog, "false");


        /**
         * Edge 0 [gephi, webatlas]
         */
        Edge edge0 = gephi.connectTo("0", webatlas);

        Spell spellEdge0 = new SpellImpl();
        date.set(2012, 3, 28, 16, 15, 36);
        spellEdge0.setStartValue(date.getTime());
        date.set(2012, 3, 28, 17, 41, 5);
        spellEdge0.setEndValue(date.getTime());
        edge0.getSpells().add(spellEdge0);


        /**
         * Edge 1 [gephi, rtgi]
         */
        Edge edge1 = gephi.connectTo("1", rtgi);

        Spell spellEdge1 = new SpellImpl();
        date.set(2012, 3, 30, 11, 16, 6);
        spellEdge1.setStartValue(date.getTime());
        date.set(2012, 4, 3, 11, 52, 6);
        spellEdge1.setEndValue(date.getTime());
        edge1.getSpells().add(spellEdge1);


        /**
         * Edge 2 [rtgi, webatlas]
         */
        Edge edge2 = rtgi.connectTo("2", webatlas);
        Spell spellEdge2 = new SpellImpl();
        date.set(2012, 4, 1, 11, 0, 0);
        spellEdge2.setStartValue(date.getTime()).setStartIntervalType(IntervalType.OPEN);
        date.set(2012, 4, 5, 11, 9, 44);
        spellEdge2.setEndValue(date.getTime());
        edge2.getSpells().add(spellEdge2);


        /**
         * Edge 3 [gephi, blab]
         */
        Edge edge3 = gephi.connectTo("3", blab);
        Spell spellEdge3 = new SpellImpl();
        date.set(2012, 3, 30, 12, 13, 22);
        spellEdge3.setStartValue(date.getTime());
        date.set(Calendar.MINUTE, 58);
        date.set(Calendar.SECOND, 24);
        spellEdge3.setEndValue(date.getTime());
        edge3.getSpells().add(spellEdge3);


        /**
         * Edge 4 [webatlas, blab]
         */
        Edge edge4 = webatlas.connectTo("4", blab);
        Spell spellEdge4 = new SpellImpl();
        date.set(2012, 3, 30, 21, 2, 37);
        spellEdge4.setStartValue(date.getTime());
        date.set(Calendar.MINUTE, 13);
        spellEdge4.setEndValue(date.getTime());
        edge4.getSpells().add(spellEdge4);


        /**
         * Edge 5 [foobar, blab]
         */
        foobar.connectTo("5", blab);


        StaxGraphWriter graphWriter = new StaxGraphWriter();
        StringWriter stringWriter = new StringWriter();

        graphWriter.writeToStream(gexf, stringWriter, "UTF-8");

        String outputXml = stringWriter.toString();

        InputStream inputStream = GexfImplDefaultTest.class.getResourceAsStream("/dynamicGraph.gexf");
        String myControlXML = IOUtils.toString(inputStream, "UTF-8");

        System.out.println(outputXml);
        System.out.println(myControlXML);
        Diff myDiff = new Diff(myControlXML, outputXml);

//        myDiff.overrideElementQualifier(new ElementNameAndTextQualifier());
        assertTrue("XML similar " + myDiff.toString(),
                myDiff.similar());
    }
}
