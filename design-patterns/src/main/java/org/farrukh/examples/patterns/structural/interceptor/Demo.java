package org.farrukh.examples.patterns.structural.interceptor;

public class Demo {

    public static void main(String[] args) {
        FilterManager manager = new FilterManager(new Target());
        manager.addFilter(new ValidationFilter());
        manager.addFilter(new LoggerFilter());

        Client client = new Client();

        client.setFilterManager(manager);

        client.sendRequest("hello");

    }

}
