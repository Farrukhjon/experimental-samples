package org.farrukh.experiments.java.net.completion;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoClientByCompletion {

    private static final Logger logger = LoggerFactory.getLogger(EchoClientByCompletion.class);

    private static final int DEFAULT_PORT = 9090;
    private static final String IP = "127.0.0.1";

    private AsynchronousSocketChannel clientChannel;

    public static void main(String[] args) {
        try {
            new EchoClientByCompletion().start()
                                        .configure()
                                        .connect()
                                        .shutdown();
        } catch (IOException | InterruptedException | ExecutionException e) {
            logger.error("Error: {}", e);
        }
    }
    
    public void shutdown() throws IOException {
        try {
            TimeUnit.SECONDS.sleep(1);
            clientChannel.close();
        } catch (InterruptedException e) {
            logger.error("Failed closing connection: ", e);
        }
    }

    // create an asynchronous socket channel bound to the default group
    public EchoClientByCompletion start() throws IOException {
        clientChannel = AsynchronousSocketChannel.open();
        return this;
    }

    // connect this channel's socket
    public EchoClientByCompletion connect() throws InterruptedException, ExecutionException {
        clientChannel.connect(new InetSocketAddress(IP, DEFAULT_PORT), null, new EchoClientCompletionHandler(clientChannel));
        return this;
    }

    // set some options
    private EchoClientByCompletion configure() throws IOException {
        if (clientChannel.isOpen()) {
            clientChannel.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
            clientChannel.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
            clientChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
        } else {
            logger.warn("The asynchronous socket channel cannot be opened!");
        }
        return this;
    }
}
