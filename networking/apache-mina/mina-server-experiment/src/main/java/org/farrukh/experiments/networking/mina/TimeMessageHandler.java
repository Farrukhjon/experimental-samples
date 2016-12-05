package org.farrukh.experiments.networking.mina;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeMessageHandler extends IoHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TimeMessageHandler.class);

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String strMessage = message.toString();
        if (strMessage.trim().equalsIgnoreCase("quit")) {
            session.closeNow();
            return;
        }

        Date date = new Date();
        session.write(date.toString());

        logger.info("Message {} written...", strMessage);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info("Session IDLE: {}", session.getIdleCount(status));
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.error("Exception is ouccured: {}", cause);
    }

}
