package org.farrukh.experiments.java.net.future;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoClient {

    private static final Logger logger = LoggerFactory.getLogger(EchoClient.class);

    private static final int DEFAULT_PORT = 9090;
    private static final String IP = "127.0.0.1";

    private AsynchronousSocketChannel clientChannel;

    //Future connect result
    private Void connect;

    public static void main(String[] args) {
        try {
            new EchoClient().start()
                            .configure()
                            .connect()
                            .transmit()
                            .shutdown();
        } catch (IOException | InterruptedException | ExecutionException e) {
            logger.error("Error: {}", e);
        }
    }

    public void shutdown() throws IOException {
        clientChannel.close();
    }

    // create an asynchronous socket channel bound to the default group
    public EchoClient start() throws IOException {
        clientChannel = AsynchronousSocketChannel.open();
        return this;
    }

    // connect this channel's socket
    public EchoClient connect() throws InterruptedException, ExecutionException {
        connect = clientChannel.connect(new InetSocketAddress(IP, DEFAULT_PORT))
                     .get();
        return this;
    }

    // Transmitting data.
    public EchoClient transmit() throws IOException, InterruptedException, ExecutionException, CharacterCodingException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        ByteBuffer helloBuffer = ByteBuffer.wrap("Hello !".getBytes());
        ByteBuffer randomBuffer;
        CharBuffer charBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();
        if (connect == null) {
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
        } else {
            logger.warn("The connection cannot be established!");
        }
        return this;
    }

    // set some options
    private EchoClient configure() throws IOException {
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
