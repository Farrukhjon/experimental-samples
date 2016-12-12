package org.netty.server.experiment.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private static final String REQUEST_HANDLER_NAME = "requestHandler";
    private static final String AGGREGATOR_NAME = "aggregator";
    private static final String CODEC_NAME = "codec";
    private static final int MAX_CONTENT_LENGTH = 512 * 1024;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
          .addLast(CODEC_NAME, new HttpServerCodec())
          .addLast(AGGREGATOR_NAME, new HttpObjectAggregator(MAX_CONTENT_LENGTH))
          .addLast(REQUEST_HANDLER_NAME, new HttpRequestHandler());
    }

}
