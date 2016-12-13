package org.farrukh.experiments.java.net.future;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Callable;

public class ServerWorker implements Callable<String> {

    private final AsynchronousSocketChannel aClientConnection;

    public ServerWorker(AsynchronousSocketChannel theClientConnection) {
        this.aClientConnection = theClientConnection;
    }

    @Override
    public String call() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(128 * 1024);
        while (aClientConnection.read(buffer).get() != -1) {
            buffer.flip();
            aClientConnection.write(buffer)
                             .get();
            if (buffer.hasRemaining()) {
                buffer.compact();
            } else {
                buffer.clear();
            }
        }
        String host = aClientConnection.getRemoteAddress().toString();
        return host;
    }
}
