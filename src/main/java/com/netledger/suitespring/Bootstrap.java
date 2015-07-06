package com.netledger.suitespring;

import com.netledger.suitespring.BeanObj;
import com.netledger.suitespring.BeansHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Map;

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

            Map<String, BeanObj> beanGraph = handler.getBeans();

            for (String bean : beanGraph.keySet()) {
                System.out.println( bean + ": " + beanGraph.get(bean));
            }

        } catch (Exception e) {
            System.err.println("Oh dear, something went horrible wrong: " + e.getMessage());
        }
    }
}
