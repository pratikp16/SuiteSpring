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
    public Map<String, BeanObj> importFromXML(String filename) {
        Map<String, BeanObj> beans = null;

        try {
            File inputFile = new File(filename);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            BeansHandler handler  = new BeansHandler();
            saxParser.parse(inputFile, handler);

            beans = handler.getBeans();

        } catch (Exception e) {
            System.err.println("Oh dear, something went horrible wrong: " + e.getMessage());
        }

        return beans;
    }
}
