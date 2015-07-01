package com.netledger.suitespring;

import com.netledger.suitespring.exception.DuplicateBeanException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbrook on 01/07/2015.
 */
public class GraphChecker {
    Map<String, BeanObj> beanGraph;

    public GraphChecker(Map<String, BeanObj> graph) {
        this.beanGraph = graph;
    }

    boolean verify() throws DuplicateBeanException {
        return performVerification(beanGraph);
    }

    boolean performVerification(Map<String, BeanObj> toCheck) throws DuplicateBeanException {
        Map<String, Boolean> visited = new HashMap<>();
        // Duplicate checking.
        for(BeanObj bean : toCheck.values()) {
            String name = bean.getName();
            if(visited.containsKey(name)) {
                throw new DuplicateBeanException("Found duplicate bean: " + name);
            }
            visited.put(bean.getName(), true);
        }

        return true;
    }
}
