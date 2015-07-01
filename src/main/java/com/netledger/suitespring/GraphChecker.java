package com.netledger.suitespring;

import java.util.Map;

/**
 * Created by dbrook on 01/07/2015.
 */
public class GraphChecker {
    Map<String, BeanObj> graph;

    public GraphChecker(Map<String, BeanObj> graph) {
        this.graph = graph;
    }

    boolean verify() {
        return performVerification(graph);
    }
    boolean performVerification(Map<String, BeanObj> toCheck) {
        for(BeanObj bean : toCheck.values()) {
            // iterate over properties checking ref
        }

        return true;
    }
}
