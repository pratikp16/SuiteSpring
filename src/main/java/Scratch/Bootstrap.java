package Scratch;

import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


/**
 * Created by bedwards on 01/07/15.
 */
public class Bootstrap {
    public void importFromXML(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {

            File inputFile = new File(filename);
            SAXParser saxParser = factory.newSAXParser();

            XMLReader reader = saxParser.getXMLReader();
            BeansHandler handler  = new BeansHandler(reader);
            saxParser.parse(inputFile,handler);


        } catch (Exception e) {

        }

    }
}
