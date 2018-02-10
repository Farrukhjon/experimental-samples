package org.farrukh.experiments.dp.structural.proxy;

/**
 * Client of the Proxy
 */
public class Client {

    public static void main(String[] args) {

        System.out.println("Using Real Subject");

        //eager loading resource on instantiation:
        HeavyResourceLoader realSbj = new RealHeavyResourceLoader();
        //realSbj.showResource();

        System.out.println("Using Proxy Subject");
        HeavyResourceLoader proxySbj = new ProxyHeavyResourceLoader();

        //lazy loading resource on demand:
        proxySbj.showResource();


    }

}
