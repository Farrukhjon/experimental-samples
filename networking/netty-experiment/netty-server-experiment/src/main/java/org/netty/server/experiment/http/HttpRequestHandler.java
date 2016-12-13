package org.netty.server.experiment.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpObject;

public class HttpRequestHandler extends SimpleChannelInboundHandler<HttpObject> {
    
    private final HttpResponseProvider responseProvider;

    public HttpRequestHandler() {
        responseProvider = new DefaultHttpResponseProvider();
    }
    
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject message) throws Exception {
        if(message instanceof FullHttpResponse) {
            FullHttpRequest request = (FullHttpRequest) message;
            FullHttpResponse response = responseProvider.processRequest(request);
            ctx.writeAndFlush(response);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    }


}
