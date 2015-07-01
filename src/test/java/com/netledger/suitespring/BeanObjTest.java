package com.netledger.suitespring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by dbrook on 01/07/2015.
 */
public class BeanObjTest {
    @Test
    public void construct() {
        BeanObj bean = new BeanObj("foo", "Foo", new HashMap<>(), new HashMap<>());
        assertEquals("foo", bean.getName());
        assertEquals("Foo", bean.getClassName());
        assertEquals(new HashMap<String, String>(), bean.getValues());
        assertEquals(new HashMap<String, String>(), bean.getReferences());
    }
}
