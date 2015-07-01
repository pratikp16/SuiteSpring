package Scratch;

import com.netledger.suitespring.BeanObj;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by bedwards on 01/07/15.
 */
public class Main {
    public static void main(String[] args) {
        Bootstrap b = new Bootstrap();
        b.importFromXML("test/main/resources/test1.xml");



    }
}
