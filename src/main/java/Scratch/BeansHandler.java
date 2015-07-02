package Scratch;

import com.netledger.suitespring.BeanObj;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bedwards on 01/07/15.
 */
public class BeansHandler extends DefaultHandler {

    private List<BeanObj> beans;
    private String name;
    private String classname;
    public Map<String, String> values = new HashMap<>();
    public Map<String, String> references = new HashMap<>();

    public BeansHandler() {
        this.beans = new ArrayList<>();
    }

    public List<BeanObj> getBeans() { return beans; }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("bean") ) {
            name = attributes.getValue("name");
            classname = attributes.getValue("classname");
        }
        else if (qName.equalsIgnoreCase("p")) {
            String pName = attributes.getValue("name");
            String pValue = attributes.getValue("value");
            String pRef = attributes.getValue("ref");

            if (pValue != null) {
                values.put(pName, pValue);
            }
            else if (pRef != null) {
                references.put(pName, pRef);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("bean")) {
            Map<String, String> v = new HashMap<>(values);
            Map<String, String> r = new HashMap<>(references);
            BeanObj newBean = new BeanObj(name, classname, v, r);
            beans.add(newBean);

            values.clear();
            references.clear();
        }
    }
}
