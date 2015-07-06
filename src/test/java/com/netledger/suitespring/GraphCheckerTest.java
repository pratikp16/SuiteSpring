package com.netledger.suitespring;

import com.netledger.suitespring.exception.DuplicateBeanException;
import com.netledger.suitespring.exception.UnknownBeanReferenceException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by dbrook on 01/07/2015.
 */
public class GraphCheckerTest {
    @Test
    public void detectsDuplicateBeans() throws Exception {
        Map<String, BeanObj> beanGraph = new HashMap<>();
        beanGraph.put("foo", new BeanObj("foo", "Foo"));
        beanGraph.put("bar", new BeanObj("foo", "Foo"));

        GraphChecker graphChecker = new GraphChecker(beanGraph);
        try {
            graphChecker.verify();
        } catch(DuplicateBeanException e) {
            assertEquals("Found duplicate bean: foo", e.getMessage());
            return;
        }

        fail("Didn't throw DuplicateBeanException");
    }

    @Test
    public void detectUnknownBeanReferences() throws Exception {
        Map<String, String> prop = new HashMap<>();
        prop.put("xxx", "NotABean");
        Map<String, BeanObj> beanGraph = new HashMap<>();
        beanGraph.put("foo", new BeanObj("foo", "Foo", new HashMap<>(), prop));

        GraphChecker graphChecker = new GraphChecker(beanGraph);
        try {
            graphChecker.verify();
        } catch(UnknownBeanReferenceException e) {
            assertEquals("Unknown bean reference: NotABean", e.getMessage());
            return;
        }

        fail("Didn't throw UnknownBeanReferenceException");
    }
}
