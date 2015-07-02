package Scratch;

import com.netledger.suitespring.BeanObj;
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

            BeansHandler handler  = new BeansHandler();
            saxParser.parse(inputFile, handler);

            for (BeanObj bean : handler.getBeans()) {
                System.out.println( bean );
            }

        } catch (Exception e) {

        }
    }
}
