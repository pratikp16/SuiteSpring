package com.netledger.suitespring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dbrook on 01/07/2015.
 */
public class BeanObj {
    String name;
    String className;
    List<BeanProperty> properties;

    public BeanObj(String name, String className, List<BeanProperty> properties) {
        this.name = name;
        this.className = className;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public List<BeanProperty> getProperties() {
        return properties;
    }
}
