package org.farrukh.experiments.networking.mina.time;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class TimeServer {
    
    private static final Logger logger  = LoggerFactory.getLogger(TimeServer.class);
    
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        logger.info("Starting the server...");
        IoAcceptor acceptor = new NioSocketAcceptor();

        /**
         * This filter will log all information such as newly created sessions,
         * messages received, messages sent, session closed. The next filter is
         * a ProtocolCodecFilter. This filter will translate binary or protocol
         * specific data into message object and vice versa. We use an existing
         * TextLine factory because it will handle text base message for you
         * (you don't have to write the codec part)
         */
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(StandardCharsets.UTF_8)));

        /**
         * The handler that will be used to service client connections and the
         * requests for the current time.
         */
        acceptor.setHandler(new TimeMessageHandler());
        
        
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        
        acceptor.bind(new InetSocketAddress(PORT));
        logger.info("The server is started...");

    }
}
