package org.netty.client.experiment.http;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class HttpClient {

    private static final int PORT = 80;
    
    private final EventLoopGroup clientEventLoopGroup;

    private ChannelFuture connect;

    public HttpClient() {
        this.clientEventLoopGroup = new NioEventLoopGroup();
    }

    public void start() {
        Bootstrap bootstrap = new Bootstrap();
        ChannelHandler handler = new ClientChannelHandler();
        bootstrap.group(clientEventLoopGroup)
                 .channel(NioSocketChannel.class)
                 .handler(handler)
                 .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000);

        connect = bootstrap.localAddress(PORT)
                           .connect();
    }

    public void shutdown() {
        clientEventLoopGroup.shutdownGracefully();
        try {
            connect.channel()
                   .closeFuture()
                   .sync();
        } catch (InterruptedException e) {
            Thread.currentThread()
                  .interrupt();
        }
    }

    public static void main(String[] args) {
        new HttpClient().start();
    }

}
