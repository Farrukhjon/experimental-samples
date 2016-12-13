package org.farrukh.experiments.java.net.completion;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServerByCompletion {

    private static final Logger logger = LoggerFactory.getLogger(EchoServerByCompletion.class);

    private static final int PORT = 9090;
    private static final String HOST = "127.0.0.1";

    public void start() {
        try (AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()) {
            if (serverChannel.isOpen()) {
                configure(serverChannel);
                serverChannel.bind(new InetSocketAddress(HOST, PORT));
                logger.info("Waiting for a client connection...");
                serverChannel.accept(null, new EchoServerCompletionHandler());
                System.in.read();
            }
        } catch (IOException e) {
            logger.error("Cannot open a server channel, reason: ", e);
        }
    }

    private void configure(AsynchronousServerSocketChannel serverChannel) throws IOException {
        serverChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
        serverChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        new EchoServerByCompletion().start();
    }

}
