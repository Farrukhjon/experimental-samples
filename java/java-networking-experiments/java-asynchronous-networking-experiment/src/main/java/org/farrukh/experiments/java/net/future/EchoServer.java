package org.farrukh.experiments.java.net.future;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger logger = LoggerFactory.getLogger(EchoServer.class);

    private static final int PORT = 9090;
    private static final String HOST = "127.0.0.1";

    private final ExecutorService taskExecutor;

    public EchoServer() {
        this.taskExecutor = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
    }

    public void start() {
        try (AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()) {
            if (serverChannel.isOpen()) {
                configure(serverChannel);
                serverChannel.bind(new InetSocketAddress(HOST, PORT));
                logger.info("Waiting for a client connection...");
                while (true) {
                    Future<AsynchronousSocketChannel> futureConnection = serverChannel.accept();
                    try {
                        AsynchronousSocketChannel clientConnection = futureConnection.get();
                        logger.info("Incoming the client connection: {}", clientConnection.getRemoteAddress());
                        Future<String> clientHostName = taskExecutor.submit(new ServerWorker(clientConnection));
                        if(clientHostName.isDone()) {
                        }
                        logger.info("The client: {} was successfully served", clientHostName.get());
                    } catch (InterruptedException | ExecutionException e) {
                        logger.error("The Server is shutting down: ", e);
                        stop();
                        while (!taskExecutor.isTerminated()) {
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        taskExecutor.shutdown();
    }

    private void configure(AsynchronousServerSocketChannel serverChannel) throws IOException {
        serverChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
        serverChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        new EchoServer().start();
    }

}
