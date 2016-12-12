package org.netty.server.experiment;

import org.netty.server.experiment.exception.MessageHandlerException;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * For outgoing messages.
 * Can be:
 *   - Opened/Closed
 *   - Connected/Disconnected
 *   The class is - a Channel
 *   The class's methods are  - Callbacks
 */
public class MessageOutboundHandler extends ChannelOutboundHandlerAdapter {

    public MessageOutboundHandler() {
    }
    
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        throw new MessageHandlerException(cause);
    }

}
