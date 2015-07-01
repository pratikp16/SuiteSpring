package Scratch;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;

import java.util.Map;

/**
 * Created by bedwards on 01/07/15.
 */


public class PHandler extends DefaultHandler {


    private XMLReader reader;
    private BeanHandler parent;

    public PHandler(XMLReader reader, BeanHandler parent) {
        this.reader = reader;
        this.parent = parent;
    }

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {
            System.out.println( "    PHandler Start" );

            parent.properties.put(attributes.getValue("name"),attributes.getValue("value"));

    }

    @Override
    public void endElement(String uri,
                             String localName, String qName)
            throws SAXException {
        System.out.println( "    PHandler End" );
        if (qName == "p") {
            reader.setContentHandler(parent);
        }
    }
}
