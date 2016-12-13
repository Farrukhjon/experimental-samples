package org.farrukh.experiments.java.net.completion;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ServerMessageHandler implements CompletionHandler<AsynchronousSocketChannel, String> {

    @Override
    public void completed(AsynchronousSocketChannel result, String attachment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void failed(Throwable exc, String attachment) {
        // TODO Auto-generated method stub
        
    }

}
