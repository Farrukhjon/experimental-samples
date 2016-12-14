package org.farrukh.examples.patterns.structural.interceptor;

public class LoggerFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("Logging: " + request);
    }

}
