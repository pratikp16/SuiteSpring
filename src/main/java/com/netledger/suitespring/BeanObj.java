package com.netledger.suitespring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbrook on 01/07/2015.
 */
public class BeanObj {
    private final String name;
    private final String className;
    private final Map<String, String> values;
    private final Map<String, String> references;

    public BeanObj(String name, String className, Map<String, String> values, Map<String, String> references) {
        this.name = name;
        this.className = className;
        this.values = values;
        this.references = references;
    }

    public BeanObj(String name, String className) {
        this(name, className, new HashMap<String, String>(), new HashMap<String, String>());
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public Map<String, String> getReferences() {
        return references;
    }

    public Map<String, String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Bean - name: ").append(name).append(", classname: ").append(className);

        if (!values.isEmpty()) {
            string.append("\n").append("     - values: ").append(values);
        }
        if (!references.isEmpty()) {
            string.append("\n").append("     - references: ").append(references);
        }

        return string.append("\n").toString();
    }
}
