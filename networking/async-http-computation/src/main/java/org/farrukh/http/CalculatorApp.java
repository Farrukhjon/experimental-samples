package org.farrukh.http;

import org.farrukh.http.server.AsyncHttpServiceImpl;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 */
public class CalculatorApp extends Application {

    private static Set<Class<?>> restResources = new HashSet<Class<?>>();

    static {
        restResources.add(AsyncHttpServiceImpl.class);
    }



    public Set<Class<?>> getClasses() {
        return restResources;
    }

}
