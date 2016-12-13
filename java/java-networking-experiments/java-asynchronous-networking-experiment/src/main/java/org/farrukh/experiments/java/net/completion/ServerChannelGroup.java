package org.farrukh.experiments.java.net.completion;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.TimeUnit;

public class ServerChannelGroup extends AsynchronousChannelGroup {

    protected ServerChannelGroup(AsynchronousChannelProvider provider) {
        super(provider);
    }

    @Override
    public boolean isShutdown() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTerminated() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void shutdown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void shutdownNow() throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

}
