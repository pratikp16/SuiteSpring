package com.netledger.suitespring;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by dbrook on 01/07/2015.
 */
public class BeanObjTest {
    @Test
    public void construct() {
        BeanObj bean = new BeanObj("foo", "Foo", new ArrayList<>());
        assertEquals("foo", bean.getName());
        assertEquals("Foo", bean.getClassName());
        assertEquals(new ArrayList<>(), bean.getProperties());
    }
}
