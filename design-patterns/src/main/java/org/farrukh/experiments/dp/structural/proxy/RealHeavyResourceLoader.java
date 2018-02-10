package org.farrukh.experiments.dp.structural.proxy;

/**
 * Real Subject
 */
public class RealHeavyResourceLoader implements HeavyResourceLoader {

    private HeavyResource resource;

    public RealHeavyResourceLoader() {
        loadFromDisk();
    }

    @Override
    public void showResource() {
        System.out.printf("Real Showing loaded Resource: %s \n", resource);
    }

    private void loadFromDisk() {
        System.out.print("Loading resource from disk... \n");
        resource = new HeavyResource();
    }


    private class HeavyResource {

        @Override
        public String toString() {
            return "Some Heavy Resource";
        }

    }
}
