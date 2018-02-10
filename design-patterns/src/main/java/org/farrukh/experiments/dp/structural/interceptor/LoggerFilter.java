package org.farrukh.experiments.dp.structural.interceptor;

public class LoggerFilter implements Filter {

    @Override
    public void execute(String request) {
        System.out.println("Logging: " + request);
    }

}
