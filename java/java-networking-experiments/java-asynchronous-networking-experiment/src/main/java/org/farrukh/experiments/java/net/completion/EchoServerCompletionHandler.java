package org.farrukh.experiments.java.net.completion;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Void> {

    private static final Logger logger = LoggerFactory.getLogger(EchoServerCompletionHandler.class);

    @Override
    public void completed(AsynchronousSocketChannel aClientCannel, Void attachment) {
        try {
            SocketAddress hostName = aClientCannel.getRemoteAddress();
            logger.info("Incoming the client connection: {}", hostName);
            ByteBuffer buffer = ByteBuffer.allocate(128 * 1024);
            while (aClientCannel.read(buffer)
                                .get() != -1) {
                buffer.flip();
                aClientCannel.write(buffer)
                             .get();
                if (buffer.hasRemaining()) {
                    buffer.compact();
                } else {
                    buffer.clear();
                }
            }
            logger.info("The client: {} was successfully served", hostName);
        } catch (IOException | InterruptedException | ExecutionException e) {
            logger.error("Could not handle a client", aClientCannel);
        }
    }

    @Override
    public void failed(Throwable exc, Void attachment) {
        logger.error("Cannot accept a client connection", exc);
    }

}
