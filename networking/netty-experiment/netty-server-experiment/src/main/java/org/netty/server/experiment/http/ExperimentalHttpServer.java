package org.netty.server.experiment.http;

import org.netty.server.experiment.ServerPort;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ExperimentalHttpServer {

    private static final int PORT = ServerPort.HTTP.value();
    private static final int BOSS_THREAD_COUNT = 2;
    private static final int WORKER_THREAD_COUNT = 3;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ChannelFuture futureIOResult;

    public ExperimentalHttpServer() {
        bossGroup = new NioEventLoopGroup(BOSS_THREAD_COUNT);
        workerGroup = new NioEventLoopGroup(WORKER_THREAD_COUNT);
        Runtime.getRuntime()
               .addShutdownHook(new Thread() {
                   @Override
                   public void run() {
                       shutdown();
                   }
               });
    }

    public void start() {
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                           .channel(NioServerSocketChannel.class)
                           .childHandler(new ServerChannelInitializer())
                           .option(ChannelOption.SO_BACKLOG, 128)
                           .childOption(ChannelOption.SO_KEEPALIVE, true);
            futureIOResult = serverBootstrap.bind(PORT)
                                            .sync();
        } catch (InterruptedException e) {
            Thread.currentThread()
                  .interrupt();
        }
    }

    public void shutdown() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        try {
            futureIOResult.channel()
                          .closeFuture()
                          .sync();
        } catch (InterruptedException e) {
            Thread.currentThread()
                  .interrupt();
        }
    }

    public static void main(String[] args) {
        new ExperimentalHttpServer().start();
    }

}
