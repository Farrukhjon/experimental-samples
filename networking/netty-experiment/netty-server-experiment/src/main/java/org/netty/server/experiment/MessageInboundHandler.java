package org.netty.server.experiment;

import org.netty.server.experiment.exception.MessageHandlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.util.CharsetUtil;

/**
 * For incoming messages.
 *
 */
@Sharable // Can be shared by multiple channels.
public class MessageInboundHandler extends ChannelInboundHandlerAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(MessageInboundHandler.class);
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf msgInBytes = (ByteBuf)msg;
        String convetedToStrMsg = msgInBytes.toString(CharsetUtil.UTF_8);
        logger.info("Incoming message is: {}", convetedToStrMsg);
        ctx.write(msgInBytes);
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
           .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        throw new MessageHandlerException(cause);
    }

}
