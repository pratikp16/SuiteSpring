package com.netledger.suitespring;

import com.netledger.suitespring.exception.BeanReferenceCycleException;
import com.netledger.suitespring.exception.DuplicateBeanException;
import com.netledger.suitespring.exception.UnknownBeanReferenceException;

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

    public static boolean isOk(Map<String, BeanObj> graph) throws DuplicateBeanException, UnknownBeanReferenceException, BeanReferenceCycleException {
        return new GraphChecker(graph).verify();
    }

    boolean verify() throws DuplicateBeanException, UnknownBeanReferenceException, BeanReferenceCycleException {
        return performVerification(beanGraph);
    }

    boolean performVerification(Map<String, BeanObj> toCheck) throws DuplicateBeanException, UnknownBeanReferenceException, BeanReferenceCycleException {
        Map<String, Boolean> visited = new HashMap<>();
        // Duplicate checking.
        for(BeanObj bean : toCheck.values()) {
            String name = bean.getName();
            if(visited.containsKey(name)) {
                throw new DuplicateBeanException("Found duplicate bean: " + name);
            }
            visited.put(bean.getName(), true);

            // Check reference validity.
            for(String ref : bean.getReferences().values()) {
                if(!beanGraph.containsKey(ref)) {
                    throw new UnknownBeanReferenceException("Unknown bean reference: " + ref);
                }
                if(ref.equals(name)) {
                    throw new BeanReferenceCycleException(name);
                }
            }
        }

        return true;
    }
}
