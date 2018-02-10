package org.farrukh.experiments.dp.structural.interceptor;

public class ValidationFilter implements Filter {

    @Override
    public void execute(String request) {
        if (request != null) {
            System.out.println("Validated!");
        }
    }

}
