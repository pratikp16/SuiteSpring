package Scratch;

import com.netledger.suitespring.BeanObj;
import com.netledger.suitespring.Bootstrap;
import com.netledger.suitespring.Gabriel;
import com.netledger.suitespring.GraphChecker;
import com.netledger.suitespring.exception.BeanReferenceCycleException;
import com.netledger.suitespring.exception.DuplicateBeanException;
import com.netledger.suitespring.exception.UnknownBeanReferenceException;

import java.util.Map;

/**
 * Created by bedwards on 01/07/15.
 */
public class Main {
    public static void main(String[] args) {
        Bootstrap b = new Bootstrap();

        Map<String, BeanObj> beanGraph = b.importFromXML("test/main/resources/test1.xml");

        for (String bean : beanGraph.keySet()) {
            System.out.println( bean + ": " + beanGraph.get(bean));
        }

        try {
            if (GraphChecker.isOk(beanGraph))
                System.out.println("Graph checks out.");
        } catch(DuplicateBeanException | UnknownBeanReferenceException | BeanReferenceCycleException e){
            System.err.println("Graph was faulty: " + e.getMessage());
        }

        // XXX To get this to work make src/test/java a regular source of java. Yes that's horrid.
        for(String beanName : beanGraph.keySet()) {
            System.out.println("Gave life to '" + beanName + "' - " + Gabriel.beanToObject(beanGraph.get(beanName)));
        }
    }
}
