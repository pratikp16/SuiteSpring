package Scratch;


import com.netledger.suitespring.BeanObj;
import org.xml.sax.XMLReader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;
import java.util.Map;

/**
 * Created by bedwards on 01/07/15.
 */
public class BeansHandler extends DefaultHandler {

    private XMLReader reader;

    private List<BeanObj> beans;

    public BeansHandler(XMLReader reader) {
        this.reader = reader;
    }

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

        System.out.println( "BeansHandler Start :" + qName );
        if (qName == "bean" ) {
            reader.setContentHandler(new BeanHandler(reader, this));
        }

    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        System.out.println( "BeansHandler End" );
    }




}
