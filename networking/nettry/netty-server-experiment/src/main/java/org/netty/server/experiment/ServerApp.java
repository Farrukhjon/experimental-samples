package org.netty.server.experiment;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Hello world!
 *
 */
public class ServerApp {

    private static final int PORT = 9090;

    private NioEventLoopGroup eventLoopGroup;

    private ServerBootstrap bootstrap;

    public ServerApp(MessageInboundAdapter handler) {
        eventLoopGroup = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(eventLoopGroup)
            .channel(NioServerSocketChannel.class)
            .localAddress(PORT)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline()
                        .addLast(handler);
                }
            });
    }

    public void start() throws InterruptedException {
        try {
            ChannelFuture chanFuture = bootstrap.bind()
                .sync();
            chanFuture.channel()
                .closeFuture()
                .sync();
        } finally {
            eventLoopGroup.shutdownGracefully()
                .sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ServerApp(new MessageInboundAdapter()).start();
    }

}
