package org.farrukh.experiments.java.net.completion;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoClientCompletionHandler implements CompletionHandler<Void, Void> {

    private static final Logger logger = LoggerFactory.getLogger(EchoClientCompletionHandler.class);

    private AsynchronousSocketChannel clientChannel;

    public EchoClientCompletionHandler(AsynchronousSocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    @Override
    public void completed(Void result, Void attachment) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        ByteBuffer helloBuffer = ByteBuffer.wrap("Hello !".getBytes());
        ByteBuffer randomBuffer;
        CharBuffer charBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();
        try {
            logger.info("Local address: {}", clientChannel.getLocalAddress());
            // transmitting data
            clientChannel.write(helloBuffer)
                         .get();
            while (clientChannel.read(buffer)
                                .get() != -1) {
                buffer.flip();
                charBuffer = decoder.decode(buffer);
                logger.info(charBuffer.toString());
                if (buffer.hasRemaining()) {
                    buffer.compact();
                } else {
                    buffer.clear();
                }
                int r = new Random().nextInt(100);
                if (r == 50) {
                    logger.info("50 was generated! Close the asynchronous socket channel!");
                    break;
                } else {
                    randomBuffer = ByteBuffer.wrap("Random number:".concat(String.valueOf(r))
                                                                   .getBytes());
                    clientChannel.write(randomBuffer)
                                 .get();
                }
            }
        } catch (InterruptedException | ExecutionException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, Void attachment) {
        logger.error("The connection cannot be established!", exc);
    }

}
