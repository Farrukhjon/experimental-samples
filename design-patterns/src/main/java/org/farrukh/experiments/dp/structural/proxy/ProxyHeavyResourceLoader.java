package org.farrukh.experiments.dp.structural.proxy;

/**
 * Proxy
 */
public class ProxyHeavyResourceLoader implements HeavyResourceLoader {

    private RealHeavyResourceLoader resourceLoader;

    @Override
    public void showResource() {
        resourceLoader = new RealHeavyResourceLoader();
        resourceLoader.showResource();
    }

}
