package org.netty.server.experiment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Hello world!
 *
 */
public class ServerApp {

    private static final Logger logger = LoggerFactory.getLogger(ServerApp.class);

    private static final int PORT = 9090;

    private EventLoopGroup eventLoopGroup;

    private ServerBootstrap bootstrap;

    public ServerApp(MessageInboundHandler inboundHandler, MessageOutboundHandler outboundHandler) {
        eventLoopGroup = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(eventLoopGroup)
                 .channel(NioServerSocketChannel.class)
                 .localAddress(PORT)
                 .childHandler(new ChannelInitializer<SocketChannel>() {
                     @Override
                     protected void initChannel(SocketChannel channel) throws Exception {
                         channel.pipeline()
                                .addLast(inboundHandler)
                                .addLast(outboundHandler);
                     }
                 });
    }

    public void start() throws InterruptedException {
        try {
            ChannelFuture chanFuture = bootstrap.bind()
                                                .sync();
            logger.info("The server is started");
            chanFuture.channel()
                      .closeFuture()
                      .sync();
        } finally {
            eventLoopGroup.shutdownGracefully()
                          .sync();
            logger.info("The server is shut down");
        }
    }

    public void stop() throws InterruptedException {
        eventLoopGroup.shutdownGracefully()
                      .sync();
        logger.info("The server is shut down");
    }

    public static void main(String[] args) throws InterruptedException {
        MessageOutboundHandler outboundHandler = new MessageOutboundHandler();
        MessageInboundHandler inboundHandler = new MessageInboundHandler();
        ServerApp server = new ServerApp(inboundHandler, outboundHandler);
        server.start();
    }

}
